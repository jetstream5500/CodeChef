import java.util.*;
import java.math.*;

public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();
    for (int i = 0; i<T; i++) {
      int n = in.nextInt();
      System.out.println(Z(n));
    }
  }

  public static int Z(int n) {
    long fives = 5;
    int total = 0;
    while (fives <= n) {
      total+=n/fives;
      fives*=5;
    }
    return total;
  }
}
