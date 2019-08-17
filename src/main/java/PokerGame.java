import java.util.*;
import java.util.stream.Collectors;

public class PokerGame {

  public int judge(String card1, String card2) {
    List<Poker> pokerList1 = convertCards(card1);
    List<Poker> pokerList2 = convertCards(card2);
    if (hasFlush(pokerList1, pokerList2)) {
      if (isFlush(pokerList1) && !isFlush(pokerList2)) {
        return 1;
      } else if (isFlush(pokerList2) && !isFlush(pokerList1)) {
        return -1;
      }
    }
    if (hasStraight(pokerList1,pokerList2)) {
      if (isStraight(pokerList1) && !isStraight(pokerList2)) {
        return 1;
      } else if (isStraight(pokerList2) && !isStraight(pokerList1)) {
        return -1;
      }
    }
    Map<Integer, Integer> map1 = new LinkedHashMap<>();
    Map<Integer, Integer> map2 = new LinkedHashMap<>();
    for (Poker poker : pokerList1) {
      map1.put(poker.getSize(), map1.getOrDefault(poker.getSize(), 0) + 1);
    }
    for (Poker poker : pokerList2) {
      map2.put(poker.getSize(), map2.getOrDefault(poker.getSize(), 0) + 1);
    }
    if (isHighCard(pokerList1, pokerList2, map1, map2)) {
      Integer x = judgeHighCard(pokerList1, pokerList2);
      if (x != null) return x;
    } else {
      if (map1.size() > map2.size()) {
        return -1;
      } else if (map1.size() < map2.size()) {
        return 1;
      } else {
        if (getKey(map1, 3).size() > getKey(map2, 3).size()) {
          return 1;
        } else if (getKey(map1, 3).size() == getKey(map2, 3).size() && getKey(map1, 3).size() != 0) {
          if (getKey(map1, 3).get(0) > getKey(map2, 3).get(0)) {
            return 1;
          } else if (getKey(map1, 3).get(0) > getKey(map2, 3).get(0)) {
            return -1;
          }
        }
        List<Integer> keyList1 = getKey(map1, 2);
        List<Integer> keyList2 = getKey(map2, 2);
        for (int i = keyList1.size() - 1; i >= 0; i--) {
          if (keyList1.get(i) > keyList2.get(i)) {
            return 1;
          } else if (keyList1.get(i) < keyList2.get(i)) {
            return -1;
          }
        }
      }
    }

    return 0;
  }

  private boolean hasFlush(List<Poker> pokerList1, List<Poker> pokerList2) {
    return isFlush(pokerList1) || isFlush(pokerList2);
  }

  private boolean isFlush(List<Poker> pokerList) {
    Map<String, Integer> map = new HashMap<>();
    for (Poker poker : pokerList) {
      map.put(poker.getColor(), map.getOrDefault(poker.getColor(), 0) + 1);
    }
    return map.size() == 1;
  }

  private boolean hasStraight(List<Poker> pokerList1, List<Poker> pokerList2) {
    return isStraight(pokerList1) || isStraight(pokerList2);
  }

  private boolean isStraight(List<Poker> pokerList) {
    for (int i = 0; i < pokerList.size() - 1; i++) {
      if (pokerList.get(i).getSize() + 1 != pokerList.get(i + 1).getSize()) {
        return false;
      }
    }
    return true;
  }

  private Integer judgeHighCard(List<Poker> pokerList1, List<Poker> pokerList2) {
    for (int i = pokerList1.size() - 1; i >= 0; i--) {
      if (pokerList1.get(i).getSize() > pokerList2.get(i).getSize()) {
        return 1;
      } else if (pokerList1.get(i).getSize() < pokerList2.get(i).getSize()) {
        return -1;
      }
    }
    return null;
  }

  private boolean isHighCard(List<Poker> pokerList1, List<Poker> pokerList2, Map<Integer, Integer> map1, Map<Integer, Integer> map2) {
    return map1.size() == pokerList1.size() && map2.size() == pokerList2.size();
  }

  private List<Poker> convertCards(String cards) {
    List<String> cardList = new ArrayList<>(Arrays.asList(cards.split(" ")));
    List<Poker> pokerList = new ArrayList<>();
    cardList.stream()
        .map(x -> new Poker(x.substring(0, x.length() - 1), x.substring(x.length() - 1)))
        .forEach(pokerList::add);
    pokerList = pokerList.stream().sorted(Comparator.comparing(Poker::getSize)).collect(Collectors.toList());
    return pokerList;
  }

  public static List<Integer> getKey(Map map, Object value) {
    List<Integer> keyList = new ArrayList<>();
    map.keySet().stream()
        .filter(x -> value.equals(map.get(x)))
        .mapToInt(x -> (Integer) x)
        .forEach(keyList::add);
    return keyList;
  }
}
