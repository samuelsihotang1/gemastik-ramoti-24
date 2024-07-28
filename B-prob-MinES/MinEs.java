import java.util.Scanner;

public class MinEs {
    private static final String[][] TABLE1 = {
        {"AB", "DC", "CC", "CB"},
        {"CA", "DA", "CD", "DD"},
        {"BC", "AA", "BA", "DB"},
        {"BD", "AD", "BB", "AC"}
    };
    
    private static final String[][] TABLE2 = {
        {"CD", "BB", "AC", "CC"},
        {"CB", "DB", "AD", "DD"},
        {"DA", "DC", "BC", "BD"},
        {"AA", "BA", "CA", "AB"}
    };

    private static String decodeBlock(String block) {
        String intermediate = decodeUsingTable(block, TABLE2);
        return decodeUsingTable(intermediate, TABLE1);
    }

    private static String decodeUsingTable(String block, String[][] table) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (table[i][j].equals(block)) {
                    return "" + (char) ('A' + i) + (char) ('A' + j);
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String encodedMessage = scanner.nextLine();
        scanner.close();

        StringBuilder originalMessage = new StringBuilder();
        
        for (int i = 0; i < encodedMessage.length(); i += 2) {
            String block = encodedMessage.substring(i, i + 2);
            originalMessage.append(decodeBlock(block));
        }

        System.out.println(originalMessage.toString());
    }
}
