# buildCSS
Automation of creation of CSS stylesheet for my personal site [Alepuzio] (http://www.alepuzio.net)

#How to build
Run command    mvn -X -e clean compile package install

#What are the guidelines to coding the source code?
* Add _this_ before attributes;
* in _if_ clause
 * the static elements (enum, constants, String) have to be at left of compare operator;
 * before the opened parenthesis _"("_, there's a blank espace _(" ")_;
* The test class have to have the name beggining with __Test__

#What is the configuration of package script?
* __conf__: directory of configuration file
* __input__: directory of template file in __properties__ format