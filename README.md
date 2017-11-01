# buildCSS
Automation of creation of CSS stylesheet for my personal site [Alepuzio] (http://www.alepuzio.net)

## How to build
* Put the colorscheme in the correct _properties_ file in direcotry __input__
* Run the command __mvn -X -e clean compile package install assembly:single dependency:sources__
* Verify the file _css_ with the same name of coloscheme

## What are the guidelines to coding the source code?
* Add _this_ before attributes;
* In _if_ clause
 * the static elements (Enum, constants, String) have to be at left of compare operator;
 * before the opened parenthesis _"("_, there's a blank espace _(" ")_;
* The test class have to have the name beginning with __Test__

## What is the configuration of package's script?
* __conf__: directory of configuration file
* __input__: directory of template file in __properties__ format
