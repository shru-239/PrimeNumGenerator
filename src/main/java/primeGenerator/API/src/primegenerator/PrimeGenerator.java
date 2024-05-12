package primeGenerator.API.src.primegenerator;

import java.util.*;

public class PrimeGenerator {
	private int startRange;
	private int endRange;
	public PrimeGenerator(int startRange, int endRange){
		 this.startRange= startRange;
		 this.endRange = endRange;
	 }
	 public List<Integer> generate(String strategy){
		 
		 switch(strategy.toLowerCase()) {
		 case "brute" :
			 return bruteForce(startRange, endRange);
		 case "sieve" :
			  return sieveOfEratosthenes(startRange, endRange);
		 case "trial" :
			   return trialDivision(startRange,endRange); 
	     default :
	    	 System.out.println("Strategy doesn't exist, Using brute force by default");
	    	 return bruteForce(startRange, endRange);
		 }
	 }
	 //Strategy 1 (Brute Force)
	  public  List<Integer> bruteForce(int start, int end){
		  List<Integer> primes = new ArrayList<>();
		  for(int i=start; i<=end;i++) {
		  if(isPrimeBruteForce(i)) {
			  primes.add(i);
		  }
		 }
		  return primes;
	  }

	private boolean isPrimeBruteForce(int num) {
		 if(num<=1) {
			 return false;
		 }
		 for(int i =2;i<=Math.sqrt(num);i++) {
			 if(num%i==0) {
				 return false; 
			 }
		 }
		
		return true;
	}
	//Strategy 2 (sieve of Eratosthenes)
	private List<Integer> sieveOfEratosthenes(int start, int end){
		 boolean[] isPrime = new boolean[end+1];
		 for(int i =2;i<= end ;i++) {
			 isPrime[i]= true;
		 }
		 for(int p =2;p*p<=end; p++) {
			  if(isPrime[p]) {
				  for(int i = p*p;i<=end;i+=p) {
					  isPrime[i]=false;
				  }
			  }
		 }
		 List<Integer> primes = new ArrayList<>();
		 for (int i = Math.max(start, 2); i <= end; i++) {
	            if (isPrime[i]) {
	                primes.add(i);
	            }
	        }

	        return primes;   	 
	}
	//Strategy 3 (trial Division)
	private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> trialDivision(int start, int end) {
        List<Integer> primes = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        return primes;
    }
    

	public int getStartRange() {
		return startRange;
	}

	public void setStartRange(int startRange) {
		this.startRange = startRange;
	}

	public int getEndRange() {
		return endRange;
	}

	public void setEndRange(int endRange) {
		this.endRange = endRange;
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter the valid start range:");
			int start= sc.nextInt();
			System.out.println("Enter the valid end range:");
			int end = sc.nextInt();
			sc.nextLine();
			
			System.out.println("Enter the generation strategy (trial/sieve/brute):");
	        String strategy = sc.nextLine();
			PrimeGenerator prime = new PrimeGenerator(start, end);
			List<Integer> primes = prime.generate(strategy);
			System.out.println("Prime numbers between " + prime.getStartRange() + " and "
			        + prime.getEndRange() + ": " + primes);
		}

	}

}
