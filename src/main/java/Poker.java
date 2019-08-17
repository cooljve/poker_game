public class Poker {
  private int size;
  private String color;

  public Poker(String strSize, String color) {
    if (strSize.equals("J")) {
      this.size=11;
    } else if (strSize.equals("Q")) {
      this.size=12;
    } else if (strSize.equals("K")) {
      this.size=13;
    }else {
      this.size = Integer.valueOf(strSize);
    }
    this.color = color;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }
}
