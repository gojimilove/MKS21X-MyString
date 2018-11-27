public class MyString implements CharSequence,Comparable<CharSequence> {
  private char[] data;

  public MyString(CharSequence s) {
    data = new char[s.length()];
    for (int i = 0; i < s.length(); i++) {
      data[i] = s.charAt(i);
    }
  }

  public char charAt(int index) throws ArrayIndexOutOfBoundsException{
    return data[index];
  }

  public int length() {
    return data.length;
  }

  public CharSequence subSequence(int start, int end) {
    //initialize new charSequence
    CharSequence sub = "";

    //add all chars in that range to the charSequence from the array
    for (int i = start; i < end; i++) {
    	sub += (""+data[i]);
    }
    return sub;
  }

  public String toString() {
    String result = "";
    for (int i = 0; i < data.length; i++) {
      result+=data[i];
    }
    return result;
  }

  public int compareTo(CharSequence o){
    return 0;
  }

  public static void main(String[]args) {
    MyString tester = new MyString("thisisatest");
    System.out.println(tester); //should print ""
    try {
    	System.out.println(tester.charAt(0)); //should be 't'
    	System.out.println(tester.charAt(9)); //should be 's'
    	System.out.println(tester.charAt(20)); //should be 's'
    } catch (ArrayIndexOutOfBoundsException e) {
    	System.out.println("TESTING");
    }
    System.out.println(tester.length()); //should be 11
    System.out.println(tester.subSequence(4, -1)); //should be "his"
  }
}
