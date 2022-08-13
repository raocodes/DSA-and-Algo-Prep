public class GCDAndLCM {
    static long gcd(long big, long small) {
        if (small == 0) {
            return big;
        }
        return gcd(small, big % small);
    }

    static long lcm(long A, long B, long GCD) {
        return (A * B) / GCD;
    }

    static Long[] lcmAndGcd(Long A, Long B) {
        long big = A > B ? A : B;
        long small = A < B ? A : B;
        long gcdres = gcd(big, small);
        long lcmres = lcm(big, small, gcdres);
        return new Long[]{lcmres, gcdres};
    }
}
