import java.util.ArrayList;
import java.util.List;

public class PokerGame {
  public int judge(List<String> cardList1, List<String> cardList2) {
    List<Poker> pokerList1 = convertCards(cardList1);
    List<Poker> pokerList2 = convertCards(cardList2);
    if (pokerList1.get(0).getSize() > pokerList2.get(0).getSize()) {
      return 1;
    } else if (pokerList1.get(0).getSize() == pokerList2.get(0).getSize()) {
      return 0;
    } else {
      return -1;
    }
  }

  private List<Poker> convertCards(List<String> cardList) {
    List<Poker> pokerList = new ArrayList<>();
    for (String card : cardList) {
      pokerList.add(new Poker(card.substring(0, 1), card.substring(1, 2)));
    }
    return pokerList;
  }
}
