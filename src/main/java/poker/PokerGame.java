package poker;

import java.util.List;
import java.util.Map;

import static utils.PokerUtils.*;

public class PokerGame {

  public int judge(String card1, String card2) {
    List<Poker> pokerList1 = transformPokers(card1);
    List<Poker> pokerList2 = transformPokers(card2);
    Map<Integer, Integer> map1 = getPokerMapByPokerList(pokerList1);
    Map<Integer, Integer> map2 = getPokerMapByPokerList(pokerList2);

    if (hasStraightFlush(pokerList1, pokerList2)) {
      Integer x = judgeWithStraightFlush(pokerList1, pokerList2);
      if (x != null) return x;
    }
    if (hasFourOfKind(map1, map2)) {
      Integer x = judgeWithFourOfKind(map1, map2);
      if (x != null) return x;
    }
    if (hasFullHouse(map1, map2)) {
      Integer x = judgeWithFullHouse(map1, map2);
      if (x != null) return x;
    }
    if (hasFlush(pokerList1, pokerList2)) {
      Integer x = judgeWithFlush(pokerList1, pokerList2);
      if (x != null) return x;
    }
    if (hasStraight(pokerList1, pokerList2)) {
      Integer x = judgeWithStraight(pokerList1, pokerList2);
      if (x != null) return x;
    }
    if (hasThreeOfKind(map1, map2)) {
      Integer x = judgeWithThreeOfKind(map1, map2);
      if (x != null) return x;
    }
    if (hasPairs(map1, map2)) {
      Integer x = judgeWithPairs(map1, map2);
      if (x != null) return x;
    }
    Integer x = judgeHighCard(pokerList1, pokerList2);
    if (x != null) return x;
    return 0;
  }

  private Integer judgeWithStraightFlush(List<Poker> pokerList1, List<Poker> pokerList2) {
    if (isStraightFlush(pokerList1) && !isStraightFlush(pokerList2)) {
      return 1;
    } else if (isStraightFlush(pokerList2) && !isStraightFlush(pokerList1)) {
      return -1;
    }
    return null;
  }

  private Integer judgeWithFourOfKind(Map<Integer, Integer> map1, Map<Integer, Integer> map2) {
    if (isFourOfKind(map1) && !isFourOfKind(map2)) {
      return 1;
    } else if (isFourOfKind(map2) && !isFourOfKind(map1)) {
      return -1;
    } else if (getKeysByMapAndValue(map1, 4).get(0) > getKeysByMapAndValue(map2, 4).get(0)) {
      return 1;
    } else if (getKeysByMapAndValue(map1, 4).get(0) < getKeysByMapAndValue(map2, 4).get(0)) {
      return -1;
    }
    return null;
  }

  private Integer judgeWithFullHouse(Map<Integer, Integer> map1, Map<Integer, Integer> map2) {
    if (map1.size() > map2.size()) {
      return -1;
    } else if (map1.size() < map2.size()) {
      return 1;
    }
    return null;
  }

  private Integer judgeWithFlush(List<Poker> pokerList1, List<Poker> pokerList2) {
    if (isFlush(pokerList1) && !isFlush(pokerList2)) {
      return 1;
    } else if (isFlush(pokerList2) && !isFlush(pokerList1)) {
      return -1;
    }
    return null;
  }

  private Integer judgeWithStraight(List<Poker> pokerList1, List<Poker> pokerList2) {
    if (isStraight(pokerList1) && !isStraight(pokerList2)) {
      return 1;
    } else if (isStraight(pokerList2) && !isStraight(pokerList1)) {
      return -1;
    }
    return null;
  }

  private Integer judgeWithThreeOfKind(Map<Integer, Integer> map1, Map<Integer, Integer> map2) {
    if (isThreeOfKind(map1) && !isThreeOfKind(map2)) {
      return 1;
    } else if (isThreeOfKind(map1) && !isThreeOfKind(map2)) {
      return -1;
    } else if (getKeysByMapAndValue(map1, 3).get(0) > getKeysByMapAndValue(map2, 3).get(0)) {
      return 1;
    } else if (getKeysByMapAndValue(map1, 3).get(0) < getKeysByMapAndValue(map2, 3).get(0)) {
      return -1;
    }
    return null;
  }

  private Integer judgeWithPairs(Map<Integer, Integer> map1, Map<Integer, Integer> map2) {
    if (map1.size() > map2.size()) {
      return -1;
    } else if (map1.size() < map2.size()) {
      return 1;
    } else {
      List<Integer> keyList1 = getKeysByMapAndValue(map1, 2);
      List<Integer> keyList2 = getKeysByMapAndValue(map2, 2);
      for (int i = keyList1.size() - 1; i >= 0; i--) {
        if (keyList1.get(i) > keyList2.get(i)) {
          return 1;
        } else if (keyList1.get(i) < keyList2.get(i)) {
          return -1;
        }
      }
    }
    return null;
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
}
