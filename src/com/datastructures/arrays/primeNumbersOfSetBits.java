public class primeNumbersOfSetBits {

    public int countPrimeSetBits(int L, int R) {
        int numPrimes = 0;
        for(int i = L; i <= R; i++){
            if(isPrime(numberOfSetBits(i))) numPrimes++;
        }
        return numPrimes;
    }

    public int numberOfSetBits(int i){
        int count = 0;
        while(i>0){
            i &= (i-1);
            count++;
        }
        return count;
    }

    public boolean isPrime(int num){
        if(num == 1 || num == 0) return false;
        for(int i = 2; i<=num/2; i++){
            if( num % i == 0) return false;
        }
        return true;
    }
}
