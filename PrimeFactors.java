public class PrimeFactors {
    public long trailingZeros(long n) {
        // write your code here, try to do it without arithmetic operators.
        long f = 5;
        long count = 0;
        long floor = n / f;
        //System.out.println(floor);
        while (floor > 0) {
            count += floor;
            f = f *5;
            floor = n / f;
        }

        return count;
    }

    public static void main(String[] args) {
        PrimeFactors p = new PrimeFactors();
        System.out.println(p.trailingZeros(11));
    }
}
