import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  public static void main(String[] args) {
    Map<String, Double> menu = new LinkedHashMap<String, Double>();
    menu.put("mixed fruit", 2.15);
    menu.put("dish2", 2.15);
    menu.put("dish3", 2.45);
    menu.put("dish4", 2.87);
    menu.put("dish4", 3.15);
    menu.put("dish5", 4.50);
    menu.put("dish6", 5.25);
    menu.put("dish7", 8.15);

    double[] amounts = {5.00, 4.30, 7.40};
    for (double currentAmount : amounts) {
      System.out.println("Testing: " + currentAmount);
      List<List<String>> result = menuCombination(menu, currentAmount);
      for (List<String> curentCombination : result) {
        for (String dish: curentCombination) {
          System.out.print(dish + ", ");
        }
        System.out.println("");
      }
    }



  }

  public static List<List<String>> menuCombination(Map<String, Double> menu, double amount) {
    return menuCombination( menu, amount, new HashMap<Double, List<List<String>> >() );
  }


  public static List<List<String>> menuCombination(Map<String, Double> menu, double amount,Map<Double, List<List<String>>> cache) {
    if ( cache.containsKey(amount)) {
      return cache.get(amount);
    }
    List<List<String>> result = new ArrayList<List<String>>();
    for(String dish : menu.keySet()) {
      //System.out.println("testing: " + dish + " = " + menu.get(dish) + " against " + amount);
      if ( amount < menu.get(dish)) {
        return result;
      }
      List<List<String>> restResult = menuCombination(menu, amount - menu.get(dish), cache);
      if (restResult.isEmpty() && amount == menu.get(dish)) {
        List<String> temp = new ArrayList<String>();
        temp.add(dish);
        result.add(temp);
        continue;
      }
      for (List<String> comb : restResult) {
        List<String> temp = new ArrayList<String>();
        temp.add(dish);
        temp.addAll(comb);
        result.add(temp);
      }
    }
    cache.put(amount, result);
    return result;
  }
}



//xkcd.com/287/
