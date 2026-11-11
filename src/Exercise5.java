public class Exercise5 {
    public static long factorial(long n) {
        if (n <= 1)
            return 1;
        long fac = n * factorial(n - 1);
        System.out.println(fac);
        return fac;
    }

    public static void main(String[] args) {
        factorial(15);
    }
}
