public class MyString implements CharSequence,Comparable<CharSequence> {
  private char[] data;

  public MyString(CharSequence s) {
  	//data is a new array, same length as the charSequence
    data = new char[s.length()];
    //for every char in charSequence add it to data
    for (int i = 0; i < s.length(); i++) {
      data[i] = s.charAt(i);
    }
  }

  public char charAt(int index) throws IndexOutOfBoundsException{
    //stop if the the index is out of range, otherwise return char at index index of data
    return data[index];
  }

  public int length() {
    return data.length;
  }

  public CharSequence subSequence(int start, int end) throws IndexOutOfBoundsException{
    CharSequence sub = "";
    //throw exception if out of bounds
    if (start > end || end < 0 || start < 0 || end >= data.length) throw new IndexOutOfBoundsException();
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

  public int compareTo(CharSequence o) throws NullPointerException{

  	//loop through array unless limit is reached or theres a difference in characters, return -1, 0, or 1
  	for (int i = 0; (i < this.length() && i < o.length()); i++) {
  		 if (this.charAt(i) > o.charAt(i)) return 1;
  		 if (this.charAt(i) < o.charAt(i)) return -1;
  	}
  	if (this.length() > o.length()) return 1;
  	if (this.length() < o.length()) return -1;
    return 0;
  }

  public static void main(String[]args) {
    MyString tester = new MyString("thisisatest");
    System.out.println(tester); //should print "thisisatest"
    try {
    	System.out.println(tester.charAt(0)); //should be 't'
    	System.out.println(tester.charAt(9)); //should be 's'
    	System.out.println(tester.charAt(20)); //should be error
    	System.out.println(tester.charAt(-5)); //should be error
    } catch (IndexOutOfBoundsException e) {
    	System.out.println("Error: index is negative or less than the length");
    }
    System.out.println(tester.length()); //should be 11
    try {
    	System.out.println(tester.subSequence(1, 4)); //should be "his"
    	System.out.println(tester.subSequence(1, 1)); //should be ""
    	System.out.println(tester.subSequence(1, 20)); //should be error
    	System.out.println(tester.subSequence(1, -4)); //should be error
    	System.out.println(tester.subSequence(-1, 4)); //should be error
    	System.out.println(tester.subSequence(3, 2)); //should be error
    } catch (IndexOutOfBoundsException e) {
    	System.out.println("Error: either start or end are negative, end is greater than the length, or start is greater than end");
    }
    try {
    	System.out.println(tester.compareTo("thiswasatest")); //should be -1
    	System.out.println(tester.compareTo("thatwasatest")); //should be 1
    	System.out.println(tester.compareTo("thisisatest")); //should be 0
    	System.out.println(tester.compareTo(null)); //should be error
    } catch(NullPointerException e) {
    	System.out.println("Error: specified object cannot be null");
    }
  }
}
