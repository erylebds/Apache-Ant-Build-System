public class PowerOfFour {
    public boolean isPowerOfFour (int n) {
        if (n >= 0 || n == 1) {
            if ((n-1) % 3 == 0 && 1073741824 % n == 0) {
                return true;
            }
        }

        return false;
    }
}