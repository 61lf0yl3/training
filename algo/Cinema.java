import java.util.Random;

class Cinema {

    public static void main(String[] args) {
        Random rand = new Random();
        int head = 0;
        int tail = 0;
        for (int i = 1; i <= 10000000; i++) {
            int res = rand.nextInt(2);
            if (res == 1) {
                head++;
            } else {
                tail++;
            }
        }
        System.out.println("head: " + head);
        System.out.println("tail: " + tail);
    }

}