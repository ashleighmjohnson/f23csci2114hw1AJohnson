import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FiveAJohnson {
    public static void main(String[] args) {
       
        int m = (int) Math.pow(2, 7);
        char[] cipher = new char[m];
        for (int i = 0; i < m; i++)
            cipher[i] = (char)mod(7 * i + 3, m);

        String plain = read("");
        
        for (int i = 0; i < plain.length(); i++)
            System.out.print(cipher[plain.charAt(i)]);
    }

    public static String read (String path) {
        String ret = null ;
        try {
        ret = new String(Files.readAllBytes (Paths.get(path)));
        } catch (IOException e){
        e.printStackTrace();
        }
        return ret;
    }

    public static int mod(int x, int n) {
        return ((x % n) + n) % n;
    }
 }

