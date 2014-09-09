/*
 * Copyright (c) 2014 Magnet Systems, Inc.
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you
 * may not use this file except in compliance with the License. You
 * may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package jline;

import java.io.*;
import java.util.*;

/**
 *  An {@link InputStream} implementation that wraps a {@link ConsoleReader}.
 *  It is useful for setting up the {@link System#in} for a generic
 *  console.
 *  @author  <a href="mailto:mwp1@cornell.edu">Marc Prud'hommeaux</a>
 */
public class ConsoleReaderInputStream extends SequenceInputStream {
    private static InputStream systemIn = System.in;

    public static void setIn() throws IOException {
        setIn(new ConsoleReader());
    }

    public static void setIn(final ConsoleReader reader) {
        System.setIn(new ConsoleReaderInputStream(reader));
    }

    /**
     *  Restore the original {@link System#in} input stream.
     */
    public static void restoreIn() {
        System.setIn(systemIn);
    }

    public ConsoleReaderInputStream(final ConsoleReader reader) {
        super(new ConsoleEnumeration(reader));
    }

    private static class ConsoleEnumeration implements Enumeration {
        private final ConsoleReader reader;
        private ConsoleLineInputStream next = null;
        private ConsoleLineInputStream prev = null;

        public ConsoleEnumeration(final ConsoleReader reader) {
            this.reader = reader;
        }

        public Object nextElement() {
            if (next != null) {
                InputStream n = next;
                prev = next;
                next = null;

                return n;
            }

            return new ConsoleLineInputStream(reader);
        }

        public boolean hasMoreElements() {
            // the last line was null
            if ((prev != null) && (prev.wasNull == true)) {
                return false;
            }

            if (next == null) {
                next = (ConsoleLineInputStream) nextElement();
            }

            return next != null;
        }
    }

    private static class ConsoleLineInputStream extends InputStream {
        private final ConsoleReader reader;
        private String line = null;
        private int index = 0;
        private boolean eol = false;
        protected boolean wasNull = false;

        public ConsoleLineInputStream(final ConsoleReader reader) {
            this.reader = reader;
        }

        public int read() throws IOException {
            if (eol) {
                return -1;
            }

            if (line == null) {
                line = reader.readLine();
            }

            if (line == null) {
                wasNull = true;
                return -1;
            }

            if (index >= line.length()) {
                eol = true;
                return '\n'; // lines are ended with a newline
            }

            return line.charAt(index++);
        }
    }
}
