public class TrailingZeros {
    public int Solution(int n){
        n = findNearstFive(n);
        System.out.println(n);
        if (n == 0){
            return 1;
        }
        if (n < 5){
            return 0;
        }
        int result = 0;
        while (n % 5 == 0){
            result = result + n / 5;
            n = findNearstFive(n / 5);
        }
        return result;
    }

    public int findNearstFive(int n){
        if (n == 0 ){
            return n;
        }
        if (n < 5){
            return n;
        }
        while (n % 5 != 0){
            n --;
        }
        return n;
    }
}
