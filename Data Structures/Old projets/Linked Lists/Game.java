/** Look in the ReadMe for info on this project **/

public class Game
{
    /** Do not change **/
    private PlayerLinkedList list;
    
    /*#
     * Initialize and add players players to the PLL.
     */
    public Game(int players) {
        list = new PlayerLinkedList();
        for(int i = 0; i < players; i++)
            list.newPlayer(new Player(NameGenerator.newPlayerName()));
    }
    
    public static void main() {
        Game test = new Game(0);
        long start = System.currentTimeMillis();
        test.playGame();
        System.out.println(System.currentTimeMillis() - start);
    }
    
    /*#
     * Simulate an entire play of the game. A game is played as follows.
     * 
     * As long as there is more than 1 player in the game, play another
     * round. A round consists of each player taking a turn, removing
     * the player with the fewest number of wins and finally selecting
     * a new starting player.
     * 
     * Be sure to display the remaining players at the beginning of each 
     * round and the winner after the game is over.
     */
    public void playGame() {
        while(list.size() > 1) {
            System.out.println("\nPlayers:\n"+list.toString());
            list.playRound();
            list.removePlayer();
            list.newStartingPlayer();
        }
        System.out.println("Aaaaand the Grand Winner is... "+list.getWinner());
    }
}
