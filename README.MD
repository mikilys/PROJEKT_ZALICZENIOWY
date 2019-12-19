# Tic Othelo Toe

A simple web app to play Tic Tac Toe with little addition to the winner from Othello game!

## Features & Notes:
* Player names entry;
* Hot chair gameplay;
* Random player start;
* If you don't win in classic way, 'count' yours colors and make sure that you 'close' as many opponents marks as possible, because they will be yours! Eg. if you are 'X' and on board you have sth. like this: '|X|O|X|', then 'O' becomes 'X'.

## Tech Stack:
* Language: Java 11
* Framework: Spring
* UI Layer: JSP, Javascript, jQuery
* Build Tool: InteliJ

## Install & Run:
* Install Java 11.
* Download and install InteliJ from [https://www.jetbrains.com/idea/](https://www.jetbrains.com/idea/).
* git clone [https://github.com/mikilys/PROJEKT_ZALICZENIOWY](https://github.com/mikilys/PROJEKT_ZALICZENIOWY).
* Download Tomcat from [https://tomcat.apache.org/download-90.cgi/](https://tomcat.apache.org/download-90.cgi/).
* Open InteliJ and configure Tomcat to 'local war : exploded'.
* Make sure your host file is configured for localhost.
* Once gradle build has finished and is running, go to [http://localhost:8080/](http://localhost:8080/) and play a game.

## Next to do:
* Implement AI based on 'minimax algorithm': [https://towardsdatascience.com/tic-tac-toe-creating-unbeatable-ai-with-minimax-algorithm-8af9e52c1e7d?#14e6](https://towardsdatascience.com/tic-tac-toe-creating-unbeatable-ai-with-minimax-algorithm-8af9e52c1e7d?#14e6).
* Implement "game replay".
* Upgrade UX.

## Idea and develop:
* mikilys: [https://github.com/mikilys](https://github.com/mikilys).