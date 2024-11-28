package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {
    private String string;

    public ReversedSequence(String string) {
        this.string = reverseString(string);


    }

    public String reverseString(String someString) {
        StringBuilder stringBuilder = new StringBuilder(someString).reverse();
        return stringBuilder.toString();
    }


    @Override
    public int length() {
        return string.length();
    }

    @Override
    public char charAt(int i) {
        return string.charAt(i);
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        return string.subSequence(i, i1);
    }

    @Override
    public String toString() {
        return string;
    }
}
// END
