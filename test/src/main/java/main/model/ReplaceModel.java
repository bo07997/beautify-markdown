package main.model;

public class ReplaceModel {
  private String pre;
  private String pattern;
  private String back;

  public String getPre() {
    return pre;
  }

  public String getPattern() {
    return pattern;
  }

  public String getBack() {
    return back;
  }

  public void setPre(String pre) {
    this.pre = pre;
  }

  public void setPattern(String pattern) {
    this.pattern = pattern;
  }

  public void setBack(String back) {
    this.back = back;
  }

  public ReplaceModel(String pre, String pattern, String back) {
    this.pre = pre;
    this.pattern = pattern;
    this.back = back;
  }

  public ReplaceModel() {}
}
