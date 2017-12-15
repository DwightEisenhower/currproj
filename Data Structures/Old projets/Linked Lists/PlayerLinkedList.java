/** Look in the ReadMe for info on this project **/
public class PlayerLinkedList {
    
    /**Do not change **/
    private Node head; /** Points to the first Player added, unless noted below **/
    private Node starting; /** Points to the first Player added, unless noted below **/
    private int size; /** Updated count of players in PLL **/
    public static void temp() {
        PlayerLinkedList pll = new PlayerLinkedList();
        pll.newPlayer(new Player("Bob"));
        pll.newPlayer(new Player("Abraham"));
        pll.newPlayer(new Player("Chris"));
        pll.newPlayer(new Player("Dave"));
        pll.newPlayer(new Player("Edward"));
        System.out.println(pll.toString());
        
        pll.newStartingPlayer();
    }
    
    /*#
     * Use this method to add a new player to the END of the PLL. 
     */
    public void newPlayer(Player toAdd) {//O(1)
        Node neu = new Node(toAdd);
        size++;
        if(head == null) {
            head = neu;
            starting = neu;
            neu.next = head;
            neu.previous = head;
        } else {
            starting.next = neu;
            neu.previous = starting;
            neu.next = head;
            head.previous = neu;
        }
    }
    
    /*#
     * Remove from the PLL the player who has the fewest wins. In the event of a tie, you may
     * remove ANY single player who has the fewest wins. It does not need to be random amongst those
     * players.
     * 
     * If you end up removing the head player or starting player, set the next player in the PLL to
     * be the head or starting respectively. Head and starting should always be assigned unless the
     * PLL is empty.
     * 
     * Print the name of the removed player.
     */
    public void removePlayer() {//O(n)
        if(head == null || size == 1)
            return;
        Node i = head;
        Node smallest = i;
        for(int index = 0; index < size; index++) {
            if(i.player.getwins() < smallest.player.getwins())
                smallest = i;
            i = i.next;
        }
        System.out.println(smallest.player.getname()+" lost! They are out!");
        //obsolete lines
        if(smallest.player.equals(head.player)) {
            head.previous.next = head.next;
            head.next.previous = head.previous;
            head = head.next;
        } else if(smallest.player.equals(starting.player)) {
            starting.previous.next = starting.next;
            starting.next.previous = head.previous;
            starting = starting.next;
        } else {
            smallest.next.previous = smallest.previous;
            smallest.previous.next = smallest.next;
        }
        size--;
    }
    
    /*#
     * Randomly select a new starting player. The current starting player may be selected again. The
     * random choice should be fair.
     * 
     * Print the name of the new starting player.
     */
    public void newStartingPlayer() {//O(n)
        if(size == 0 || size == 1)
            return;
        else {
            int rindex = (int)(Math.random()*size);
            Node i = head;
            for(int index = 0; index < size; index++) {
                if(index == rindex) {
                    starting = i;
                    System.out.println("\n"+starting.player.getname()+" will start the next round.");
                    return;
                }
                i = i.next;
            }
        }
    }
    
    /*#
     * Simulate a round of the game by calling each player's takeTurn() method once, in order, starting
     * with the starting player. Indicate with Round Starting and Round Ending print statements.
     */
    public void playRound() {//O(n)
        System.out.println("Round started.");
        int looped = 0;
        for(Node i = starting; i != null && looped < size; i = i.next) {
            i.player.takeTurn();
            looped++;
        }
    }
    
    /*#
     * Return the name of the winner if there is one player left in the PLL or return an error if
     * there is not winner.
     */
    public String getWinner() {//O(1)
        if(size > 1 || size == 0) {
            System.out.println("No winner yet");
            return null;
        } else
            return head.player.getname();
    }
    
    /*#
     * Return the number of players in the PLL.
     */
    public int size() {//O(1)
        return size;
    }
    
    /*#
     * No other standard class functionality needed.
     */
    public String toString() {
        if(head == null)
            return null;
        StringBuilder sb = new StringBuilder();
        sb.ensureCapacity(size * 11);//longest name is 11 char-s;
        Node i = head;
        for(int index = 0; index < size && i != null; index++) {
            sb.append(i.player.toString()+"\n");
            i = i.next;
        }
        return sb.toString();
    }
    
    /*#
     * Complete to create a doubly linked list
     */
    public static class Node {
        public Player player;
        public Node next, previous;
        public Node(Player p) {
            player = p;
            next = null;
            previous = null;
        }
        
        public String toString() {
            return player.toString();
        }
    }
}
