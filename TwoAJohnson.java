public class TwoAJohnson {
    public static void main(String[] args) {
        // amount needed to display
        int amount = 42;
        int[] fibonacci = new int[amount];

        // initialize these as a starting point
        fibonacci[0] = 0;
        fibonacci[1] = 1;

        // calculates each number starting at num
        for (int num = 2; num < amount; num++) {
            fibonacci[num] = fibonacci[num - 1] + fibonacci[num - 2];
        }

        // formatting
        int digits = ((int) Math.log10(fibonacci[fibonacci.length - 1])) + 1;
        digits += 2; // padding
        for (int i = 0; i < fibonacci.length; i++) {
            if(i % 7 == 0 && i> 0) {
                System.out.println();
            }
            System.out.printf("%"+ digits + "d", fibonacci[i]);
        }
    }
}
