package org.hillel;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Hello world!
 */
public class App {
  public static void main(String[] args) {
    Map<Long, Citizen> map = new HashMap<>();
    final Random rand = new Random();

    for (long i = 1; i <= 100; i++) {
      final String m = Math.random() > 0.5 ? "M" : "F";
      final Citizen c = new Citizen("fn_" + i, "ln_" + i, new Date(), rand.nextInt(100), m, i);
      map.put(i, c);
    }

    for (long i = 1; i <= 100; i++)
    {
      System.out.println(map.get(i));
    }

//    for (Long inn : map.keySet()) {
//      if (inn % 10 == 0) {
//        final Citizen citizen = map.get(inn);
//        System.out.printf("%d :: %s %s\n", citizen.getINN(), citizen.getFirstName(), citizen.getLastName());
//      }
//    }
//
//    System.out.println("\n\n\n\n");
//
//    int cnt = 0;
//    for (Map.Entry<Long, Citizen> e : map.entrySet()) {
//      final Citizen citizen = e.getValue();
//      if (citizen.getSex().equals("F")) {
//        cnt++;
//      }
//    }
//    System.out.println("Female citizens = " + cnt);
  }
}
