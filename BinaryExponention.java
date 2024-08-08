public static long power(long a, long b, long m) {
        long result = 1;
        a = a % m;  // Handle cases where a >= m

        while (b > 0) {
            if (b % 2 == 1) {  // If b is odd, multiply the current base with the result
                result = (result * a) % m;
            }
            a = (a * a) % m;  // Square the base
            b = b / 2;        // Divide b by 2
        }

        return result;
    }
   ans=ans*ans;
  n/=2;

return ans;
}
