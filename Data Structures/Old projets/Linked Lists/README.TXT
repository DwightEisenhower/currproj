Project #1:

For this project we will create a framework for playing a game. The project includes the
following classes:

Player -- The player class has been written for you and SHOULD NOT BE CHANGED. Note
the takeTurn() method that simulates a player taking a turn in a game and randomly
providing a win.
    - Things that work:
        - Adding
        - removing
        - selecting a new starting player
        - toString
        - getWinner
        - size
        - playRound
    - Things that don't:
        - None.

NameGenerator -- The NameGenerator class has been written for you and SHOULD NOT
BE CHANGED. This class ensures that all randomly generated names are unique.

PlayerLinkedList -- Complete the methods in this class. Be sure to have each method
running in the lowest possible Big O runtime.

PLL is a DCLL or Doubly Circularly Linked List. In a CLL the last element in the list points
back to the first element in the list, creating a circle. As such, there is technically no 
first or last element in the DCLL. We will mark the first element added as the head and the
last element added as the end. No reference should
ever be null (unless the entire PLL is empty)

Game -- Complete the method in this class. This method is used to run an entire game.

Once finished, you should be able to run a full game with any number of players.