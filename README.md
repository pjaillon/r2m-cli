## rest2mobile Command-line Tool (r2m)
<img style="margin:10px" src="http://developer.magnet.com/tmp/img/logo_r2m_main.png"
 alt="rest2mobile logo" title="rest2mobile" align="right" />
<code>r2m</code> is a command-line tool that generates Android, iOS, and JavaScript code for your mobile app to interact with REST APIs. It takes REST request and JSON response information from a variety of sources you provide, and generates
platform-specific code for making the request and retrieving the response.

**Note:** If you are developing with Android Studio or IntelliJ, you can use the [rest2mobile plugin][r2m-plugin-android] instead of the CLI. For iOS apps, you can use the [rest2mobile plugin for Xcode][r2m-plugin-ios].

### Get Started

### Prerequisites
The <code>r2m</code> command-line tool runs on the following platforms:

* Windows® 7 or later
* Mac® OS X® 10.08 or later
* Linux® Ubuntu® 12

In addition, the tool requires Java JDK 6 or later.

### Download  

Find the latest releases at https://github.com/magnetsystems/r2m-cli/releases 

### Installing r2m (Mac)

Run:
```
brew install https://raw.githubusercontent.com/magnetsystems/r2m-cli/master/brew/r2m.rb
```

If you don't have _brew_, go to: http://brew.sh/


## Installing the rest2mobile CLI (All Platforms)

Unzip the rest2mobile zip file and add r2m to the path.

## How to use it

Start in interactive mode:

```
r2m
r2m> gen 
```

Get help:
```
r2m> help -v gen
```

Here's a simple example generating the Google distance Mobile API for iOS, Android and Javascript

``` 
r2m -d GoogleDistance 
```

You can get a list of examples with:

```
r2m -l
```
or find examples at: https://github.com/magnetsystems/r2m-examples
 

You can also build your own example from other services. See https://github.com/magnetsystems/rest2mobile/wiki/rest2mobile-create-spec-file

For a full description of the CLI. Go to https://github.com/magnetsystems/rest2mobile/wiki/rest2mobile-generate-code-gen


## Copyright

Copyright © 2014 Magnet Systems, Inc. All rights reserved.

## License

Licensed under the **[Apache License, Version 2.0] [license]** (the "License");
you may not use this software except in compliance with the License.

[website]: http://developer.magnet.com
[techdoc]: https://github.com/magnetsystems/rest2mobile/wiki
[r2m-plugin-android]:https://github.com/magnetsystems/r2m-plugin-android/
[r2m-plugin-ios]:https://github.com/magnetsystems/r2m-plugin-ios/
[r2m-cli]:https://github.com/magnetsystems/r2m-cli/
[license]: http://www.apache.org/licenses/LICENSE-2.0
[r2m wiki]:https://github.com/magnetsystems/r2m-cli/wiki
