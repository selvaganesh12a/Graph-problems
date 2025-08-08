import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int j = in.nextInt();
        int m = in.nextInt();
        int p = in.nextInt();
        if(n < 0 || k < 0 || j < 0 || m < 0 || p < 0) {
            System.out.println("INVALID INPUT");
            return;
        }
        while(m > 0 || p > 0) {
            while (m > 0 && n > 0) {
                n--;
                m -= k;
            }
            while (p > 0 && n > 0) {
                n--;
                p -= j;
            }
        }
        System.out.println("The number of monkey left on tree " + n);
    }
}
