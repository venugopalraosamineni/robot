#IOCO Robot Service

###Purpose

The purpose of this service is to encapsulate the robot apocalypse

###Project Structure

`/database/repository` contains database integration code

`/database/model` contains database entities

`/database/dao` contains data access objects

`/service` contains logic for the service

`/src` contains the application Main class and application wide config

`/controller` contains controllers logic

`/config` contains Application configuration

`/constants` contains application constants

`/dto` contains data transfer objects

###Languages,Frameworks & Tools
Application : `Maven` `Java` `SpringBoot` `Swagger` `H2 databse`

###API's

`/survivor/register` - [POST] -- To register survivor

`/survivor/reportSurvivorInfected` -  [PUT] -- To report infected survivor

`/survivor/update` - [PUT] -- To update the survivor

`/reports` - [GET] -- To get the reports

`/robots` - [GET] -- to get the sorted robots list