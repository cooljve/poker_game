import org.junit.Test;

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

  @Test
  public void should_return_minus_when_given_a_1D_3C_5D_QH_KS_b_1D_2C_2D_JH_KS() {
    String a = "1D 3C 5D QH KS";
    String b = "1D 2C 2D JH KS";
    PokerGame pg = new PokerGame();

    int res = pg.judge(a, b);

    assertEquals(-1, res);
  }

  @Test
  public void should_return_positive_when_given_a_1D_3C_5D_3H_KS_b_1D_2C_2D_JH_KS() {
    String a = "1D 3C 5D 3H KS";
    String b = "1D 2C 2D JH KS";
    PokerGame pg = new PokerGame();

    int res = pg.judge(a, b);

    assertEquals(1, res);
  }

  @Test
  public void should_return_minus_when_given_a_1D_3C_5D_3H_KS_b_1D_2C_2D_JH_JS() {
    String a = "1D 3C 5D 3H KS";
    String b = "1D 2C 2D JH JS";
    PokerGame pg = new PokerGame();

    int res = pg.judge(a, b);

    assertEquals(-1, res);
  }

  @Test
  public void should_return_minus_when_given_a_1D_3C_10D_3H_10S_b_1D_2C_2D_JH_JS() {
    String a = "1D 3C 10D 3H 10S";
    String b = "1D 2C 2D JH JS";
    PokerGame pg = new PokerGame();

    int res = pg.judge(a, b);

    assertEquals(-1, res);
  }

  @Test
  public void should_return_positive_when_given_a_1D_3C_5D_3H_3S_b_1D_2C_5D_JH_KS() {
    String a = "1D 3C 5D 3H 3S";
    String b = "1D 2C 5D JH KS";
    PokerGame pg = new PokerGame();

    int res = pg.judge(a, b);

    assertEquals(1, res);
  }

  @Test
  public void should_return_positive_when_given_a_1D_3C_5D_3H_3S_b_1D_2C_2D_JH_KS() {
    String a = "1D 3C 5D 3H 3S";
    String b = "1D 2C 2D JH KS";
    PokerGame pg = new PokerGame();

    int res = pg.judge(a, b);

    assertEquals(1, res);
  }

  @Test
  public void should_return_positive_when_given_a_1D_3C_5D_3H_3S_b_1D_2C_2D_JH_JS() {
    String a = "1D 3C 5D 3H 3S";
    String b = "1D 2C 2D JH JS";
    PokerGame pg = new PokerGame();

    int res = pg.judge(a, b);

    assertEquals(1, res);
  }

  @Test
  public void should_return_positive_when_given_a_1D_3C_5D_3H_3S_b_1D_2C_2D_2H_JS() {
    String a = "1D 3C 5D 3H 3S";
    String b = "1D 2C 2D 2H JS";
    PokerGame pg = new PokerGame();

    int res = pg.judge(a, b);

    assertEquals(1, res);
  }
}
