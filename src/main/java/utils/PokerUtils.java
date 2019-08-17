package utils;

import poker.Poker;

import java.util.*;
import java.util.stream.Collectors;

public class PokerUtils {

  public static Map<Integer, Integer> getPokerMapByPokerList(List<Poker> pokerList1) {
    Map<Integer, Integer> map1 = new LinkedHashMap<>();
    for (Poker poker : pokerList1) {
      map1.put(poker.getSize(), map1.getOrDefault(poker.getSize(), 0) + 1);
    }
    return map1;
  }

  public static List<Poker> transformPokers(String cards) {
    List<String> cardList = new ArrayList<>(Arrays.asList(cards.split(" ")));
    List<Poker> pokerList = new ArrayList<>();
    cardList.stream()
        .map(x -> new Poker(x.substring(0, x.length() - 1), x.substring(x.length() - 1)))
        .forEach(pokerList::add);
    pokerList = pokerList.stream().sorted(Comparator.comparing(Poker::getSize)).collect(Collectors.toList());
    return pokerList;
  }

  public static List<Integer> getKeysByMapAndValue(Map map, Object value) {
    List<Integer> keyList = new ArrayList<>();
    map.keySet().stream()
        .filter(x -> value.equals(map.get(x)))
        .mapToInt(x -> (Integer) x)
        .forEach(keyList::add);
    return keyList;
  }

  public static boolean hasStraightFlush(List<Poker> pokerList1, List<Poker> pokerList2) {
    return isStraightFlush(pokerList1) || isStraightFlush(pokerList2);
  }

  public static boolean isStraightFlush(List<Poker> pokerList) {
    return isStraight(pokerList) && isFlush(pokerList);
  }


  public static boolean hasStraight(List<Poker> pokerList1, List<Poker> pokerList2) {
    return isStraight(pokerList1) || isStraight(pokerList2);
  }

  public static boolean isStraight(List<Poker> pokerList) {
    for (int i = 0; i < pokerList.size() - 1; i++) {
      if (pokerList.get(i).getSize() + 1 != pokerList.get(i + 1).getSize()) {
        return false;
      }
    }
    return true;
  }

  public static boolean hasThreeOfKind(Map<Integer, Integer> map1, Map<Integer, Integer> map2) {
    return isThreeOfKind(map1) || isThreeOfKind(map2);
  }

  public static boolean isThreeOfKind(Map<Integer, Integer> map) {
    return getKeysByMapAndValue(map, 3).size() == 1;
  }

  public static boolean hasFlush(List<Poker> pokerList1, List<Poker> pokerList2) {
    return isFlush(pokerList1) || isFlush(pokerList2);
  }

  public static boolean isFlush(List<Poker> pokerList) {
    Map<String, Integer> map = new HashMap<>();
    for (Poker poker : pokerList) {
      map.put(poker.getColor(), map.getOrDefault(poker.getColor(), 0) + 1);
    }
    return map.size() == 1;
  }

  public static boolean hasPairs(Map<Integer, Integer> map1, Map<Integer, Integer> map2) {
    return map1.size() == 3 || map2.size() == 3 || map1.size() == 4 || map2.size() == 4;
  }


  public static boolean hasFourOfKind(Map<Integer, Integer> map1, Map<Integer, Integer> map2) {
    return isFourOfKind(map1) || isFourOfKind(map2);
  }

  public static boolean isFourOfKind(Map<Integer, Integer> map) {
    return getKeysByMapAndValue(map, 4).size() == 1;
  }

  public static boolean hasFullHouse(Map<Integer, Integer> map1, Map<Integer, Integer> map2) {
    return map1.size() == 2 || map2.size() == 2;
  }
}
