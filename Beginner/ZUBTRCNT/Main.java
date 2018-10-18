import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();
    for (int i = 0; i<T; i++) {
      int fullTriangle = in.nextInt();
      int subTriangle = in.nextInt();

      System.out.println("Case "+(i+1)+": "+sumToN(Math.max(fullTriangle-subTriangle+1,0)));
    }
  }

  public static int sumToN(int n) {
    return n*(n+1)/2;
  }
}
