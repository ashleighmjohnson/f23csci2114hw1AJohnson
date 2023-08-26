import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FourAJohnson {
    public static void main(String[] args) throws Exception {
        // time
        double startTime = System.nanoTime();
    
        // calling method
        calculateCumSum();

        // duration in mins
        double duration = (System.nanoTime()- startTime) / (60 * Math.pow(10, 9));
        System.out.println("\nDuration: "+ duration);
    
    }

    
    public static void calculateCumSum() {
        // read bytes from file
        byte[] bytes = getFileBytes("/Users/ashmi/Downloads/Data Structures - Fall23/Week 1 HW/half_gaps.bin");
        long[] gaps = new long[bytes.length];
        long sum = 0;

        // bytes -> long. stored in gaps
        for (int i = 0; i < gaps.length; i++) {
            gaps[i] = Byte.toUnsignedLong(bytes[i]);
        }

        // cum sum calculation and replaces gaps values
        for (int i = 0; i < gaps.length; i++) {
            sum += gaps[i]; // calculates sum
            gaps[i] = sum; // replaces w cumsum
        }

        // multiply cumsum by 2 then adds 3
        for (int i = 0; i < gaps.length; i++) {
            gaps[i] = (gaps[i] * 2) + 3;
        }

        // printoff + format first 15 nums
        System.out.println();
        System.out.println("First 15 numbers: ");
        for (int i = 0; i < 15; i++) {
            System.out.print(gaps[i] + ", ");
        }

        // this is supposed to printoff the last 5 elements of an array but i think 
        System.out.println();
        System.out.println("Last 5 elements: ");
        int elementNum = Math.max(0, gaps.length-5); 
        for (int i = elementNum; elementNum < gaps.length; elementNum++){
            System.out.print((gaps[i]+ ", "));
        }

    }

    public static byte[] getFileBytes(String path) {
        byte[] bytes = null;
        try {
            bytes = Files.readAllBytes(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }
}