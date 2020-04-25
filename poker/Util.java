package poker;

import java.util.*;

public class Util {
  public static <T> List<T> concat(List<T> l1, List<T> l2) {
    List<T> result = new ArrayList<>();
    result.addAll(l1);
    result.addAll(l2);
    return result;
  }
}