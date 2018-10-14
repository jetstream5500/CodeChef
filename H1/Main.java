import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) {
    ArrayList<String> ps = new ArrayList<String>();
    ArrayList<Integer> moves = new ArrayList<Integer>();
    HashMap<String, Integer> map = new HashMap<String, Integer>();

    ps.add("123456789");
    moves.add(0);

    for (int i = 0; i<ps.size(); i++) {
      String p = ps.get(i);
      int move = moves.get(i);
      if (map.get(p) == null) {
        map.put(p, move);
        ArrayList<String> newps = generateNewPuzzles(p);
        ps.addAll(newps);
        for (int j = 0; j<newps.size(); j++) {
          moves.add(move+1);
        }
      }
      //ps.remove(0);
      //moves.remove(0);
      //i--;
    }

    Scanner in = new Scanner(System.in);
    int tests = in.nextInt();

    for (int i = 0; i<tests; i++) {
      String start = readInput(in);
      if (map.get(start) == null) {
        System.out.println(-1);
      } else {
        System.out.println(map.get(start));
      }
    }
  }

  public static String readInput(Scanner in) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i<9; i++) {
      sb.append(in.nextInt());
    }
    return sb.toString();
  }

  public static boolean isPrime(int num) {
    if (num==2 || num==3 || (num%2!=0 && num%3!=0)) {
      return true;
    }
    return false;
  }

  public static ArrayList<String> generateNewPuzzles(String p) {
    ArrayList<String> ps = new ArrayList<String>();
    for (int i = 0; i<2; i++) {
      for (int j = 0; j<3; j++) {
        if (isPrime(p.charAt(j*3+i)+p.charAt(j*3+i+1)-96)) {
          ps.add(swap(p, j*3+i, j*3+i+1));
        }
      }
    }

    for (int i = 0; i<3; i++) {
      for (int j = 0; j<2; j++) {
        if (isPrime(p.charAt(j*3+i)+p.charAt(j*3+3+i)-96)) {
          ps.add(swap(p, j*3+i, j*3+3+i));
        }
      }
    }
    return ps;
  }

  public static String swap(String p, int a, int b) {
    StringBuilder sb = new StringBuilder(p);
    sb.delete(b, b+1);
    sb.insert(b, p.charAt(a));
    sb.delete(a, a+1);
    sb.insert(a, p.charAt(b));
    return sb.toString();
  }
}
