import sun.rmi.server.InactiveGroupException;

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
    }else {
      if (map1.size() > map2.size()) {
        return -1;
      } else if (map1.size() < map2.size()) {
        return 1;
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
}
