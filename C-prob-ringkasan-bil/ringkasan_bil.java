import java.util.*;

public class ringkasan_bil {

    public static String ringkasan_bil(int[] bilangan) {
        TreeSet<Integer> pengurutan = new TreeSet<>();
        for (int bil : bilangan) {
            pengurutan.add(bil);
        }

        StringBuilder hasil = new StringBuilder();
        Integer[] bilunik = pengurutan.toArray(new Integer[0]);
        int n = bilunik.length;
        int i = 0;

        while (i < n) {
            int s = bilunik[i];
            while (i + 1 < n && bilunik[i + 1] == bilunik[i] + 1) {
                i++;
            }
            int e = bilunik[i];
            if (s == e) {
                hasil.append(s);
            } else {
                hasil.append(s).append("-").append(e);
            }
            if (i + 1 < n) {
                hasil.append(",");
            }
            i++;
        }
        return hasil.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] bilangan = new int[N];
        for (int i = 0; i < N; i++) {
            bilangan[i] = scanner.nextInt();
        }
        String summary = ringkasan_bil(bilangan);

        System.out.println(summary);
    }
}
