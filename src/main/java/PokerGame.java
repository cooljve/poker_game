import java.util.*;
import java.util.stream.Collectors;

public class PokerGame {

  public int judge(String card1, String card2) {
    List<Poker> pokerList1 = convertCards(card1);
    List<Poker> pokerList2 = convertCards(card2);
    Map<Integer, Integer> map1 = new LinkedHashMap<>();
    Map<Integer, Integer> map2 = new LinkedHashMap<>();
    for (Poker poker : pokerList1) {
      map1.put(poker.getSize(), map1.getOrDefault(poker.getSize(), 0) + 1);
    }
    for (Poker poker : pokerList2) {
      map2.put(poker.getSize(), map2.getOrDefault(poker.getSize(), 0) + 1);
    }
    if (map1.size() == pokerList1.size() && map2.size() == pokerList2.size()) {
      for (int i = pokerList1.size() - 1; i >= 0; i--) {

        if (pokerList1.get(i).getSize() > pokerList2.get(i).getSize()) {
          return 1;
        } else if (pokerList1.get(i).getSize() < pokerList2.get(i).getSize()) {
          return -1;
        }
      }
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
