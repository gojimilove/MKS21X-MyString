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
    if (start == end) return "";
    CharSequence sub = "";
    for (int i = start; i < end; i++) {
    	sub += (""+data[i]);
    }
    return sub;
  }

  public String toString() {
    String result = "";
    for (int i = 0; i < data.length; i++) {
      
    }
    return result;
  }

  public int compareTo(CharSequence o){
    return 0;
  }

  public static void main(String[]args) {
    MyString tester = new MyString("thisisatest");
    System.out.println(tester); //should print ""
    System.out.println(tester.charAt(0)); //should be 't'
    System.out.println(tester.charAt(9)); //should be 's'
    System.out.println(tester.length()); //should be 11
    System.out.println(tester.subSequence(1, 4)); //should be "his"
  }
}
