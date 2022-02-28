import java.util.Arrays;
import java.util.Queue;
import java.util.Random;
import java.util.LinkedList;

class Seismic {

    // Deck has 52 cards
    static int N = 52;

    // number of Players
    static int numberPlayers = 2;

    // Sorted array of pile of cards;
    static int[] pileCards;

    // shuffled card
    static int[] shuffledPileCards;

    public static void main(String[] args) {
        pileCards = new int[N];
        makePileCard();
        shuffleCard();

        printCard(pileCards);
        System.out.println();
        printCard(shuffledPileCards);
        System.out.println();

        Queue<Integer> player1 = new LinkedList<>();
        Queue<Integer> player2 = new LinkedList<>();
        dividCard(player1, player2);
        game(player1, player2);
    }

    private static void makePileCard() {
        int m = 0;
        for (int i = 2; i <= 14; i++) {
            for (int j = 1; j <= 4; j++) {
                pileCards[m++] = i;
            }
        }
    }

    private static void shuffleCard() {
        Random r = new Random();
        shuffledPileCards = Arrays.copyOf(pileCards, N);
        int j;
        for (int i = 0; i < N; i++) {
            j = r.nextInt(N);
            int temp = shuffledPileCards[i];
            shuffledPileCards[i] = shuffledPileCards[j];
            shuffledPileCards[j] = temp;
        }
    }

    private static void printCard(int[] cards) {
        for (int i = 0; i < N; i++) {
            System.out.print(cards[i]);
            System.out.print(' ');
        }
    }

    private static void dividCard(Queue<Integer> player1, Queue<Integer> player2) {
        for (int i = 0; i < N; i++) {
            if (i < N / numberPlayers) {
                player1.add(shuffledPileCards[i]);
            } else {
                player2.add(shuffledPileCards[i]);
            }
        }
    }

    /**
     * 
     * @param player1
     * @param player2
     */
    private static void game(Queue<Integer> player1, Queue<Integer> player2) {
        while (!player1.isEmpty() && !player2.isEmpty()) {
            int card1 = player1.poll();
            int card2 = player2.poll();
            int res = chechCards(card1, card2);
            // player1 won
            if (res == 1) {
                // Need to add Randomizer
                player1.add(card1);
                player1.add(card2);
            } else if (res == -1) {
                // Need to add Randomizer
                player2.add(card2);
                player2.add(card1);
            } else {
                war(player1, player2);
            }
            System.out.println();
        }

        if (player1.size() > player2.size()) {
            System.out.println("player1 WINS!!!");
        } else if (player1.size() < player2.size()) {
            System.out.println("player2 WINS!!!");
        }

    }

    private static void war(Queue<Integer> player1, Queue<Integer> player2) {
        Queue<Integer> temp1 = new LinkedList();
        Queue<Integer> temp2 = new LinkedList();

        for (int i = 1; i <= 4; i++) {
            if (!player1.isEmpty()) {
                temp1.add(player1.poll());
            }
            if (!player2.isEmpty()) {
                temp2.add(player2.poll());
            }
        }

        for (int i = 1; i <= 4; i++) {
            int card1 = 0;
            int card2 = 0;
            if (!temp1.isEmpty()) {
                card1 = temp1.poll();
            }
            if (!temp2.isEmpty()) {
                card2 = temp2.poll();
            }
            int res = (chechCards(card1, card2));
            if (res == 1) {
                while (!temp2.isEmpty()) {
                    player1.add(temp2.poll());
                    player1.add(temp1.poll());
                    player1.add(card1);
                    player1.add(card2);
                }
            } else if (res == -1) {
                while (!temp1.isEmpty()) {
                    player2.add(temp1.poll());
                    player2.add(temp2.poll());
                    player1.add(card1);
                    player1.add(card2);
                }
            }
            System.out.println();
        }
    }

    private static int chechCards(int card1, int card2) {
        if (card1 > card2) {
            System.out.print(card1);
            System.out.print('>');
            System.out.println(card2);
            System.out.println("Player1 takes cards!!!");
            return 1;
        } else if (card1 < card2) {
            System.out.print(card1);
            System.out.print('<');
            System.out.println(card2);
            System.out.println("Player2 takes cards!!!");
            return -1;
        } else {
            System.out.print(card1);
            System.out.print('=');
            System.out.println(card2);
            System.out.println("WAR!!!");
            return 0;
        }
    }
}