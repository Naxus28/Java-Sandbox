import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        /* sum of doubles can be imprecise */
        double value = .012;
        double valueSum = value * 3;
        System.out.println("The sum is: " + valueSum); // result is 0.036000000000000004

        /* Fix:
         * 1. cast double as string
         */
        String sValue = Double.toString(value);
        System.out.println("String value: " + sValue);

        /*
         * 2. Create a BigDecimal (from the Math library) object and feed the string into it
         */
        BigDecimal bValue = new BigDecimal(sValue);
        System.out.println("bValue: " + bValue);

        /*
         * 3. Use BigDecimal 'add' method to add the values
         */
        BigDecimal bSum = bValue.add(bValue).add(bValue);
        System.out.println("bSum: " + bSum);
    }
}