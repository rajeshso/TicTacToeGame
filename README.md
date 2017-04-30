#Noughts and Crosses Game Service - Requirements

This coding test is to build a simple Noughts and Crosses (Tic-Tac-Toe) game.
The features of the service are documented as [User Stories]. There are some 
[technical requirements] that we require you adhere to. Finally we have some 
[expectations] that describes what we expect from you.

## Game Rules 
- The game is played on a 3x3 grid.
- Players alternate to place their mark on an unoccupied space on the grid.
- The objective is to get three of their marks in a row.
- The first player uses X the second player uses O.
- Play continues until a player gets three of their marks in a row 
  (horizontally or diagonally) or there are no free spaces left on the grid.


## User Stories 

*As a* Player  
I *need* to be able to start a game  
so *that* I can play noughts and crosses with a friend

*As a* Player  
I *need* to be able place my mark (O or X ) on a gameboard that my friend or I 
have started  
so *that*  I can participate in a game of noughts and crosses with a friend

*As a* Player  
I *need* to be able to determine the outcome of the game  
so *that* I know if I have won , lost, or drawn.

*So that* games of noughts and crossed can be played  
*the* Game service  
*will need to* enforce the rules of noughts and crosses

*So that* many people can play at the same time  
*the* Game Service  
*will need to* support multiple concurrent games


## Technical Requirements

- The test should be coded in Java 8.
- Clients will interact with the game service via a RESTful API.

## Expectations
All of these expectations are up to your own judgement. If you think you should 
you can deviate from these expectations expect us to  challenge you on why you 
have made that change.

### We expect:
- Production quality code.
- A Readme that describes what you've built  and details about your RESTful API.

### We don't expect:
- The game service to be deployed anywhere.
- A user interface.
- Any form of automated (AI) player for the game.
- Data to be persisted in a database
- Exhaustive documentation

We have expectations that we have not documented here. Use your best judgement.

[user stories]: #user-stories
[technical requirements]: #technical-requirements
[expectations]: #expectations

#Noughts and Crosses Game Service - How to operate

## How to Operate the system?
The System can be started using a plain java program as java Application
The user may use an open source Restful client to connect to the service as http://somehost:8090/startGame 

To start a game, use a similar json object
http://somehost:8090/startGame 
{
  "id": 1,
  "player": "A",
  "counterPlayer" : "B"
}

To know the status of the game, 
http://somehost:8090/gameStatus
{
  "id": 1,
  "player": "A"
}

To Play,
http://localhost:8090/placeMark
{
  "gameId": 1,
  "player": "A",
  "row" : 0,
  "col" : 2
}

To Complete,
http://localhost:8090/completeGame
{
  "id": 1,
  "player": "A"
}

## How the system is built ?

The system is built using a Spring Boot Restful framework.
The design are standard mvc style components with visually clear distinctions of the components and functionalities
The business logic is placed under the model/game
The Model Service is in model/game/service
The Restful controller service is in controller
The same system is extensible for newer grid based games
