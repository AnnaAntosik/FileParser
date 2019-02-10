# FileParser

Web application that allows to upload a ".csv" or ".prn" file and displays it as HTML.

## Getting Started

Project is written in JAVA (1.8) under IntelliJ IDEA.

### Prerequisites

Install dependencies from pom file using Maven.

## Built With

* [Spring](https://spring.io/) - The framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [Thymeleaf](https://www.thymeleaf.org/) -  Template engine

### Technologies

* Spring Web MVC
* Spring boot
* Maven
* HTML
  * Thymeleaf
* [OpenCSV](http://opencsv.sourceforge.net/)

## Usage

Application starts a web server under [localhost:8080](http://localhost:8080)

### Features

* User can upload and display '.csv' or '.prn' file from local computer
* User receives information when file format is unsupported
* User can upload a new file after displaying other file or receiving an error
* Thanks to introduced "PraserDispacher" and "Parser Service" interfaces, application can be easly extended for another file formats

## Authors

* **Anna Kuna** - [LinkedIn](https://www.linkedin.com/in/anna-kuna/)


