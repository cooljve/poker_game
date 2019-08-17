import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PokerGameTest {
  @Test
  public void should_return_minus_when_given_a_is_2C_b_is_3C(){
    List<String> a = new ArrayList<>(Arrays.asList("2C"));
    List<String> b = new ArrayList<>(Arrays.asList("3C"));
    PokerGame pg = new PokerGame();

    int res = pg.judge(a, b);

    assertEquals(-1, res);
  }

  @Test
  public void should_return_minus_when_given_a_is_QC_b_is_KC(){
    List<String> a = new ArrayList<>(Arrays.asList("QC"));
    List<String> b = new ArrayList<>(Arrays.asList("KC"));
    PokerGame pg = new PokerGame();

    int res = pg.judge(a, b);

    assertEquals(-1, res);
  }
}
