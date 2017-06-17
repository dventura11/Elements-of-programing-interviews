import java.io.*;
import java.util.*;

class SolutionDp {
  public static void main(String[] args) {
    Map<String, Double> menu = new LinkedHashMap<String, Double>();
    menu.put("mixed fruit", 0.35);
    menu.put("orange juice", 2.15);
    menu.put("soup", 2.45);
    menu.put("rice", 2.87);
    menu.put("pasta", 3.15);
    menu.put("chicken", 4.50);
    menu.put("pork", 5.25);
    menu.put("beef", 8.15);

    double[] amounts = {5.00d, 4.30d, 7.40d };//,20.40d};
    for (double currentAmount : amounts) {
      System.out.println("Testing: " + currentAmount);
      int result = menuCombination(menu, currentAmount);
      System.out.println("result: " + result);
      //List<List<String>> result = menuCombination(menu, currentAmount);
      //for (List<String> curentCombination : result) {
      //for (String dish: curentCombination) {
      //System.out.print(dish + ", ");
      //}
      //System.out.println("");
      //}
    }
  }

//public static List<List<String>> menuCombination(Map<String, Double> menu, double amount) {
public static int menuCombination(Map<String, Double> menu, double amount) {
  amount = fixDecimals(amount);
  Map<Double, Integer> result = new LinkedHashMap<Double, Integer>();
  result.put(0d, 1);
  for(String dish : menu.keySet() ) {
    double dishCost = menu.get(dish);
    for (double totalCost = dishCost; totalCost <= amount; totalCost += dishCost ) {
      totalCost = fixDecimals(totalCost);
      double previousCost = fixDecimals( totalCost - dishCost );
      System.out.println("totalCost: " + totalCost + " previousCost: " + previousCost );
      if ( !result.containsKey(totalCost) ) {
        result.put(totalCost,0);
      }
      result.put(totalCost, result.get(totalCost) + result.get(previousCost));
    }
  }
  for(double r : result.keySet() ) {
    System.out.println(r + " = " + result.get(r) );
  }
  return result.containsKey(amount) ? result.get(amount) : 0;
}

private static double fixDecimals(double number) {
  number *= 100;
  number = Math.round(number);
  number /= 100;
  return number;
}
}
