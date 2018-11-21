public class MyString implements CharSequence,Comparable<CharSequence> {
  private char[] data;
  public MyString(CharSequence s) {
    data = new char[s.length()];
    for (int i = 0; i < s.length(); i++) {
      data[i] = s.charAt(i);
    }
  }

  public char charAt(int index) {
    return data[index];
  }

  public int length() {
    return data.length;
  }

  public CharSequence subSequence(int start, int end) {
    CharSequence sub = "";
    return sub;
  }

  public String toString() {
    return "";
  }

  public int compareTo(CharSequence o){
    return 0;
  }

  public static void main(String[]args) {
    MyString tester = new MyString("thisisatest");
    System.out.println(tester.charAt(0)); //should be 't'
    System.out.println(tester.charAt(9)); //should be 's'
    System.out.println(tester.length()); //should be 11
  }
}
