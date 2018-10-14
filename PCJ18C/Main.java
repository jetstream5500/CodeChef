import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();

    for (int i = 0; i<T; i++) {
      long N = in.nextLong();
      long A = in.nextLong();
      long K = in.nextLong();
      //System.out.println(N+" "+A+" "+K);
      long sum = interiorAngleSum(N);
      long denom = triangleNumber(N-1);
      long num = (sum-N*A)*(K-1)+A*denom;

      long[] a = new long[]{num,denom};
      long gcd = gcd(a);
      System.out.println(num/gcd+" "+denom/gcd);
    }
  }

  public static long interiorAngleSum(long numSides) {
    return (numSides-2)*180;
  }

  public static long triangleNumber(long n) {
    return n*(n+1)/2;
  }

  public static long gcd(long[] a) {
    if (a[0]%a[1] == 0) {
      return a[1];
    } else {
      long temp = a[0]%a[1];
      a[0] = a[1];
      a[1] = temp;
      return gcd(a);
    }
  }
}
