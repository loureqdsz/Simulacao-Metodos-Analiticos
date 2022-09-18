package src;

public class NumberGenerator {
    public static int[] methodCongruentialLinear (int xo, int m, int a, int c, int  qtyNumbers) {
        int[] randonNumbers = new int[qtyNumbers];
        randonNumbers[0] = xo;

        for (int i = 1; i < qtyNumbers; i++) {
            randonNumbers[i] = ((a * (randonNumbers[i-1] + c)) % m);            
        }

        return randonNumbers;
    }    
}
