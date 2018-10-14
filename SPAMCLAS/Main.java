import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int tests = in.nextInt();

    for (int i = 0; i<tests; i++) {
      int N = in.nextInt();
      long minX = in.nextLong();
      long maxX = in.nextLong();
      ArrayList<Point> ps = new ArrayList<Point>();
      for (int j = 0; j<N; j++) {
        ps.add(new Point(
          (int)(in.nextLong()%2),
          (int)(in.nextLong()%2)
        ));
      }
      //System.out.println(ps);

      long even = isSpammer(0, ps);
      long odd = isSpammer(1, ps);
      //System.out.println(even);
      //System.out.println(odd);
      long spamCount = (maxX-minX+1)/2*even+(maxX-minX+1)/2*odd;
      long notSpamCount = (maxX-minX+1)/2*(1-even)+(maxX-minX+1)/2*(1-odd);
      if (minX%2==maxX%2) {
        if (minX%2==0) {
          spamCount+=even;
          notSpamCount+=(1-even);
        } else {
          spamCount+=odd;
          notSpamCount+=(1-odd);
        }
      }
      System.out.println(notSpamCount+" "+spamCount);
    }
  }

  public static long isSpammer(long userID, ArrayList<Point> ps) {
    //System.out.println("--------");
    for (int i = 0; i<ps.size(); i++) {
      Point p = ps.get(i);
      int w = (int) p.getX();
      int b = (int) p.getY();
      userID = (w*userID + b)%2;
      //System.out.println(userID);
    }
    return userID;
  }
}
