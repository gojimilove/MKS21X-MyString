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

  public char charAt(int index) throws ArrayIndexOutOfBoundsException{
    //stop if the the index is out of range, otherwise return char at index index of data
    return data[index];
  }

  public int length() {
    return data.length;
  }

  public CharSequence subSequence(int start, int end) {
    if (start < 0 || end > data.length - 1) throw new ArrayIndexOutOfBoundsException("Either the starting or ending index is our of bounds! (or both)");
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
  	//loop through array unless limit is reached or theres a difference in characters
  	for (int i = 0; (i < this.length() || i < o.length()); i++) {
  		 if (this.charAt(i) > o.charAt(i)) return 1;
  		 if (this.charAt(i) < o.charAt(i)) return -1;
  	}
    return 0;
  }

  public static void main(String[]args) {
    MyString tester = new MyString("thisisatest");
    System.out.println(tester); //should print "thisisatest"
    try {
    	System.out.println(tester.charAt(0)); //should be 't'
    	System.out.println(tester.charAt(9)); //should be 's'
    	//System.out.println(tester.charAt(20)); //should be 's'
    } catch (ArrayIndexOutOfBoundsException e) {
    	System.out.println("TESTING");
    }
    System.out.println(tester.length()); //should be 11
    System.out.println(tester.subSequence(1, 4)); //should be "his"
    System.out.println(tester.compareTo("thiswasatest")); //should be -1
    System.out.println(tester.compareTo("thatwasatest")); //should be 1
    System.out.println(tester.compareTo("thisisatest")); //should be 0
  }
}
