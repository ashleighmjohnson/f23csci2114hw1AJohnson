import java.util.Scanner;

public class ThreeAJohnson {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
       
        // user enters number in
        System.out.println("Sieve of Eratosthenes");
        System.out.println("Enter a number: ");
        int number = scan.nextInt();
        System.out.println();
    

        // time
        long startTime = System.nanoTime();

        // call to method to print prime numbers for user entered number
        printPrimesUpTo(number);

        //duration calculation
        long duration = System.nanoTime() - startTime; 
        duration = (long) (duration / (60 * Math.pow(10, 9)));
        System.out.println("\nDuration: " + duration + " seconds");

        scan.close();
    }
    
    // method to print the prime numbers to user given num
    public static void printPrimesUpTo(int number){
        
        // marks prime numbers
        boolean[] isPrime = new boolean[number +1];
        for (int prime = 2; prime <= number; prime++){
            isPrime[prime] = true;
        }

        // sieve of eratosthenes to mark not prime numbers
        for (int notPrime = 2; notPrime * notPrime <= number; notPrime++){
            if (isPrime[notPrime]){
                for (int notTrue = notPrime * notPrime; notTrue <= number; notTrue += notPrime){
                    isPrime[notTrue] = false;
                }
            }
        }


        // shows how the algorithm displays prime numbers + identifies them
        System.out.println("Prime numbers up to " + number + ":");
        for(int n =2; n <= number; n++){
            //cahecks if num is prime using isPrime array
            if (isPrime[n]){
                System.out.print(n + ", ");
            }
        }
        
        System.out.println();

        // printout + calculates the five largest prime nums
        System.out.println("\nFive largest prime numbers: ");
        int amount = 0; 
        for (int x = number; x >= 2; x--){
            if (isPrime[x]){
                System.out.print(x + ", ");
                amount++;
                // loop breaks when five largest are found
                if (amount ==5){
                    break; 
                }
            }
        }

        System.out.println();



    }
    

}
