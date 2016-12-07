import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * Stats.java
 *
 *
 *
 * @author Brandon Nguyen
 *
 * @version December 07, 2016
 *
 */
public class Stats {

    /**
     * Computes the winner statistics
     *
     * @param br BufferedReader object
     * @return a Hashmap
     */
    public static String wins(BufferedReader br) throws IOException {

        return br.readLine();
    }

    /**
     *
     * @param hm Hashmap object
     * @return name of the player with the most wins (if tie, return any player)
     */
    public static String winner(HashMap hm) {
        return "";
    }

    public static void main(String[] args) throws IOException {

        FileReader input = new FileReader("/Users/brandonnguyen/Desktop/PurdueStuffs/CS18000/Labs/Week 14/src/lab14inputfile.txt");
        BufferedReader br = new BufferedReader(input);

        System.out.println(wins(br));

    }
}