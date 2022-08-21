package companyot.sap;

public class BobPower {
    public static int power(int x, int y, int modulo) {
        int result = 1;

        x = x % modulo;

        if (x == 0) {
            return 0;
        }

        while (y > 0) {
            if ((y & 1) != 0) {
                result = (result * x) % modulo;
            }

            y = y >> 1;
            x = (x * x) % modulo;
        }

        return result;
    }

    public static int findSecretCode(int secretCode, int firstKey, int secondKey) {
        int sn = power(secretCode, firstKey, 10);
        int snm = power(sn, secondKey, 1000000007);
        return snm;
    }
}
