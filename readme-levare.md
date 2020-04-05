
# Hall-of-Fame-methodologies
Project in R about the diffusion of software development methodologies using Google Trends data.
I use this code to extract the stastitics to writing the article "#NOEstimates" for the magazine "Il Project Manager", Italian magazine about the project management.
The article can be found [here](https://www.francoangeli.it/riviste/SchedaRivista.aspx?IDArticolo=64820&Tipo=Articolo%20PDF&idRivista=162)


##Getting started

###Prerequisites

- Installed R
- Installed packages _dplyr_ and _barplot_

###Installing

- Clone the project with _git-clone_ (or download diretly it)
- In **code** there's the source code, in **resources** directory there are the other kinds of file
- Run the code
- Have fun!


##Running the tests

No test available

### Break down into to end to end tests

No indications

### Coding styles sheets

Please read the file [CONTRIBUTING.md](http://github.com/alepuzio/Hall-of-Fame-methodologies/CONTRIBUTING.md)

## Deployment

It's running in the IDE, no package to deploy

### Built with:

* [RStudio](http://www.rstudio.com) - most famous IDE for R programming language
* [ViM](http://www.vim.org) - text editor for notes

## Contributing

Please read the [Contributing.md] for the details about the code of conduct and the process for submitting pull requests.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

* **Alessandro Puzielli** - *creator* - [Alepuzio](https://github.com/alepuzio)

See also the list of [contributors](https://github.com/alepuzio/Hall-of-Fame-methodologies/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* **PurpleBooth** - to publish an [excellent template](https://gist.github.com/PurpleBooth/109311bb0361f32d87a2) of README that I used in this project 
* **Yegor256** - to write the post [Elegant READMEs](https://www.yegor256.com/2019/04/23/elegant-readme.html) about the README file and the [An Open Code Base Is Not Yet an Open Source Project](https://www.yegor256.com/2018/05/08/open-source-attributes.html) for the Open Source projects
* **ISIPM (aka Italian Institute of Project Management)** - to allow me to write the article about #NoEstimates in the Italian magazine "Il Project Manager" 



# buildCSS
Automation of creation of CSS stylesheet for my personal site [Alepuzio](http://www.alepuzio.net)



## How to build
* Put the colorscheme in the correct _properties_ file in direcotry __input__
* Run the command __mvn -X -e clean compile package install assembly:single dependency:sources__
* Verify the file _css_ with the same name of coloscheme

### Status CI Integration in [Travis](https://travis-ci.org/)
[![Build Status](https://travis-ci.org/alepuzio/buildCSS.svg?branch=master)](https://travis-ci.org/alepuzio/buildCSS)


## What are the guidelines to coding the source code?
* Add _this_ before attributes;
* In _if_ clause
 * the static elements (Enum, constants, String) have to be at left of compare operator;
 * before the opened parenthesis _"("_, there's a blank espace _(" ")_;
* The test class have to have the name beginning with __Test__

## What is the configuration of package's script?
* __conf__: directory of configuration file
* __input__: directory of template file in __properties__ format
