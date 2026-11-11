public class Exercise1 {
    public static void main(String[] args) {
        int sum = 2;
        for (int i = 2; i <= 100; i += 2) {
            System.out.println(sum);
            sum += i;
        }
    }
}
