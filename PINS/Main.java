import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();
    
    for (int i = 0; i<T; i++) {
      int N = in.nextInt();
      int exponent = N/2;
      BigInteger ten = BigInteger.valueOf(10);
      System.out.println(1);
      System.out.println(ten.pow(exponent));
    }
  }

  /*public static BigInteger gcd(BigInteger[] a) {
    if ((a[0].mod(a[1]).equals(BigInteger.valueOf(0)))) {
      return a[1];
    } else {
      BigInteger temp = a[0].mod(a[1]);
      a[0] = a[1];
      a[1] = temp;
      return gcd(a);
    }
  }*/
}
