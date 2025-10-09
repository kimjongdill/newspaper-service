# Newspaper Viewer Project

## About
This project was a gift to my sister-in-law, who at the time was a reporter for a newspaper in Niles, MI. There is a hardware component which renders the most recent published article on an e-ink display in her home. 

## How to Run
```
docker build . -t newspaper:latest
docker run -p 8080:8080 newspaper:latest
```
When you navigate to `localhost:8080` you should see a news article from 2021. 

## Architecture
This project was original bundled as a .jar file to be run on a Raspberry Pi Pico connected to a color ePaper display. The ePaper display rendered the webpage served by the react app in the directory `frontend`. The frontend fetches from our own webserver built in Java with spring boot. 

## Learnings
At the time I was working on this, I was using C# / MVC regularly for my job at nvisia, a consultancy in Chicago. I wanted to demonstrate that I could do similar work in Java / Spring-Boot so that I could be more marketable to clients. 

The most challenging part of this project was reverse engineering the API of the newspaper. This involved loading articles and monitoring the network traffic to discover the API. I even found the wordpress job careers link!

## What I Would Do If This Wasn't A Toy

* Set up unit testing on both modules
* Set up a CI/CD pipeline to confirm unit tests pass when pull requests are opened. 
* Set up a CI/CD pipeline to deploy on pull request to main. 
* Use the git tag to identify the most recent build. Store all build images in an archive to allow for rollback. 

## Kind of Punk to do

If I were interested in southern Michigan news I might build a private web client to read articles from this newspaper without ads. Seriously, check out their page, its unreadable. 