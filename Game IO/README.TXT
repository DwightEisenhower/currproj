The purpose of this project is to play a game of tokens between a number of humans and computers. To 
complete this project you must write the Game, Human and Computer classes along with any additional 
classes required.

Your game requires full exception handling. Be sure that no input at any point in time will crash your
program. You should provide hepful error messages to the user to explain any mistakes they might make.
Imagine you are giving this game to others to play.

The game of tokens is played as follows. A random number from 25 to 75 is generated to represent the
number of tokens in this game. Starting with the 0th player, they select a number of tokens from 1 to 4
that they would like to take from the pot. This continues cycling through all the players as necessary
until a player takes the last token available. That player is the winner.

Human:
    This class implements Player and represents the humans playing the game. The only required instance
    variable is the name of the player, which is set in the constructor. A name for a human MUST start
    with a non-number and cannot contain a space in it. Request a valid name from the human player.
    
    The getMove method returns the number of tokens the player wishes to take from the pot. A valid move
    is an integer from 1 to 4.
    
Computer:
    This class implements Player and represents the computers playing the game. The only required instance
    variable is the name of the player, which is set in the constructor. The computer's name is always
    CPU x where x is the player number they are.
    
    The getMove method returns a random number of tokens from 1 to 4.
   
 Game:
    This class tracks the players in the game and runs the game. You do not need to add any additional 
    instance variables.
    
    The constructor is work as follows:
        - Ask how many total players there are (must be between 2 and 10 inclusive)
        - Ask in order whether a player is a human or a computer. Initalize the players accordingly.
        - Print all the players in the game once they have all been set.
      
    The play method plays the game as follows:
        - Randomly generate a number of tokens (25 to 75) and display that value.
        - Starting with player 0, state their name and ask them for a move.
        - Update and display the number of tokens after a valid move.
        - Continue cycling through players until there is a winner.
        - Display all the players with their number of wins.
        - Display the winner's name with a congratulations and ask if they want to play again. If they
            do, replay the game from the start (no need to select players again).
        - If not, you can exit the program with the line System.exit(0);
      
Extension:
    - Before the game starts, randomize the order of the players in the list array. Each possible
        permutation of players must be equally possible. 
    - Add a parameter to getMove() that sends in the number of tokens left in the pot. Use this value
        to assist the computer in making a better strategic move. You could also consider sending in
        the number of players in the game if you like.
    - The ArrayList isn't really a great choice for data structure. Substitute it for a better choice.

Challenge:
    - The game can be made into a tournament as follows:
        - Add a win instance variable to Human and Computer that tracks the number of times they won.
        - Increase this number whenever a game is won.
        - Randomly eliminate a player from list from those who have the fewest number of wins (and
            who did not win this game). Do this after each game.
        - Repeat the game with one fewer player and continue until there is only one player left.
        - Display the players in order they finished the tournament from 1-> along with their wins. (Note
            that the player who won the tournament may not necessarily have the most wins overall).
    
    
    