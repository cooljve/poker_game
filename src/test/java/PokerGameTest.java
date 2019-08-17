import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PokerGameTest {
  //high card
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

  //one pair
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

  //two pairs
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
  public void should_return_minus_when_given_a_KD_3C_10D_3H_10S_b_1D_2C_2D_JH_JS() {
    String a = "KD 3C 10D 3H 10S";
    String b = "1D 2C 2D JH JS";
    PokerGame pg = new PokerGame();

    int res = pg.judge(a, b);

    assertEquals(-1, res);
  }

  //three of a kind
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

  //Straight
  @Test
  public void should_return_positive_when_given_a_1D_2C_3D_4H_5S_b_1D_2C_5D_JH_KS() {
    String a = "1D 2C 3D 4H 5S";
    String b = "1D 2C 5D JH KS";
    PokerGame pg = new PokerGame();

    int res = pg.judge(a, b);

    assertEquals(1, res);
  }

  @Test
  public void should_return_positive_when_given_a_1D_2C_3D_4H_5S_b_1D_2C_2D_JH_KS() {
    String a = "1D 2C 3D 4H 5S";
    String b = "1D 2C 2D JH KS";
    PokerGame pg = new PokerGame();

    int res = pg.judge(a, b);

    assertEquals(1, res);
  }

  @Test
  public void should_return_positive_when_given_a_1D_2C_3D_4H_5S_b_1D_2C_2D_JH_JS() {
    String a = "1D 2C 3D 4H 5S";
    String b = "1D 2C 2D JH JS";
    PokerGame pg = new PokerGame();

    int res = pg.judge(a, b);

    assertEquals(1, res);
  }

  @Test
  public void should_return_positive_when_given_a_1D_2C_3D_4H_5S_b_1D_2C_2D_2H_JS() {
    String a = "1D 2C 3D 4H 5S";
    String b = "1D 2C 2D 2H JS";
    PokerGame pg = new PokerGame();

    int res = pg.judge(a, b);

    assertEquals(1, res);
  }

  @Test
  public void should_return_minus_when_given_a_1D_2C_3D_4H_5S_b_3D_4C_5D_6H_7S() {
    String a = "1D 2C 3D 4H 5S";
    String b = "3D 4C 5D 6H 7S";
    PokerGame pg = new PokerGame();

    int res = pg.judge(a, b);

    assertEquals(-1, res);
  }

  //  Flush
  @Test
  public void should_return_positive_when_given_a_1D_3D_5D_6D_KD_b_3D_4C_5D_6H_7S() {
    String a = "1D 3D 5D 6D KD";
    String b = "3D 4C 5D 6H 7S";
    PokerGame pg = new PokerGame();

    int res = pg.judge(a, b);

    assertEquals(1, res);
  }

  @Test
  public void should_return_positive_when_given_a_1D_3D_5D_6D_KD_b_1D_2D_3D_4D_KD() {
    String a = "1D 3D 5D 6D KD";
    String b = "1D 2D 3D 4D KD";
    PokerGame pg = new PokerGame();

    int res = pg.judge(a, b);

    assertEquals(1, res);
  }

  //  Full House
  @Test
  public void should_return_positive_when_given_a_1D_3D_5D_6D_KD_b_1D_2C_2D_2H_1S() {
    String a = "1D 3D 5D 6D KD";
    String b = "1D 2C 2D 2H 1S";
    PokerGame pg = new PokerGame();

    int res = pg.judge(a, b);

    assertEquals(-1, res);
  }

  @Test
  public void should_return_positive_when_given_a_1D_3C_3D_3H_1S_b_1D_2C_2D_2H_1S() {
    String a = "1D 3C 3D 3H 1S";
    String b = "1D 2C 2D 2H 1S";
    PokerGame pg = new PokerGame();

    int res = pg.judge(a, b);

    assertEquals(1, res);
  }

  //  Four of a kind
  @Test
  public void should_return_minus_when_given_a_1D_3C_3D_3H_1S_b_1D_2C_2D_2H_2S() {
    String a = "1D 3C 3D 3H 1S";
    String b = "1D 2C 2D 2H 2S";
    PokerGame pg = new PokerGame();

    int res = pg.judge(a, b);

    assertEquals(-1, res);
  }

  @Test
  public void should_return_positive_when_given_a_1D_3C_3D_3H_3S_b_1D_2C_2D_2H_2S() {
    String a = "1D 3C 3D 3H 3S";
    String b = "1D 2C 2D 2H 2S";
    PokerGame pg = new PokerGame();

    int res = pg.judge(a, b);

    assertEquals(1, res);
  }

  //  Straight flush
  @Test
  public void should_return_minus_when_given_a_1D_3C_3D_3H_3S_b_3D_4D_5D_6D_7D() {
    String a = "1D 3C 3D 3H 3S";
    String b = "3D 4D 5D 6D 7D";
    PokerGame pg = new PokerGame();

    int res = pg.judge(a, b);

    assertEquals(-1, res);
  }

  @Test
  public void should_return_positive_when_given_a_9D_10D_JD_QD_KD_b_3D_4D_5D_6D_7D() {
    String a = "9D 10D JD QD KD ";
    String b = "3D 4D 5D 6D 7D";
    PokerGame pg = new PokerGame();

    int res = pg.judge(a, b);

    assertEquals(1, res);
  }
}
