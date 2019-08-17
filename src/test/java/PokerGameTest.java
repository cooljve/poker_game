import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PokerGameTest {
  @Test
  public void should_return_minus_when_given_a_is_2C_b_is_10C() {
    String a = "2C";
    String b = "10C";
    PokerGame pg = new PokerGame();

    int res = pg.judge(a, b);

    assertEquals(-1, res);
  }

  @Test
  public void should_return_minus_when_given_a_is_QC_b_is_KC() {
    String a = "QC";
    String b = "KC";
    PokerGame pg = new PokerGame();

    int res = pg.judge(a, b);

    assertEquals(-1, res);
  }

  @Test
  public void should_return_minus_when_given_a_3D_1C_5D_6H_KS_b_1D_2C_5D_JH_KS() {
    String a = "3D 1C 5D 6H KS";
    String b = "1D 2C 5D JH KS";
    PokerGame pg = new PokerGame();

    int res = pg.judge(a, b);

    assertEquals(-1, res);
  }
}
