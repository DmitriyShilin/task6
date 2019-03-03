package formatstring.exception;

public class LargeNumberValueException extends Exception {
    
    private int first;
    private int second;

    public LargeNumberValueException(int first, int second) {
        this.first = first;
        this.second = second;
    }
    
    @Override
    public String toString(){
        return "Inadmissible value a first number = " + first + " and a second number = " + second + ". Result multiply > Integer.MAX_VALUE";
    }
}
