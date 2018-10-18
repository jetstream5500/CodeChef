import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();

    for (int i = 0; i<T; i++) {
      String s = in.next();
      Map<Character,Integer> map = new HashMap<Character,Integer>();
      for (char c : s.toCharArray()) {
        if (map.get(c)==null) {
          map.put(c,1);
        } else {
          map.put(c,map.get(c)+1);
        }
      }
      
      if (map.size() < 3) {
        System.out.println("Dynamic");
      } else {
        ArrayList<Integer> vals = new ArrayList<Integer>(map.values());
        Collections.sort(vals);
        System.out.println(isDynamic(vals) ? "Dynamic" : "Not");
      }
    }
  }
  public static boolean isDynamic(ArrayList<Integer> vals) {
    for (int i = 0; i<vals.size()-2; i++) {
      int x = vals.get(i);
      int y = vals.get(i+1);
      int z = vals.get(i+2);
      if (x+y!=z) {
        if (i!=1) {
          return false;
        } else if (i==1 && vals.get(0)+y!=z) {
          return false;
        }
      }
    }
    return true;
  }
}
