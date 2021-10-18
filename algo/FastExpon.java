public class FastExpon {

    public int fastExpon(int x, int n) {
        if (n==0) {
        return 1;
        }
        if (n%2==1) {
        return x*fastExpon(x*x, n/2);
        } else {
        return fastExpon(x*x, n/2);
        }
    }
}
  