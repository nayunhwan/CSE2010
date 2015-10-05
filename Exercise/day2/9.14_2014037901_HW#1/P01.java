import java.util.*;

class P01{
	

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in); // 스캐너
		ArrayList<Integer> primes = new ArrayList<Integer>(); //Integer Type Generic ArrayList 선언

		int n = s.nextInt(); // Input integer

		// Start of Find Prime Algorithm
		for(int i = 2; i <= n; i++){
			boolean is_prime = true;
			for(int j = 2; j <= Math.sqrt(i); j++){
				if(i % j == 0){
					is_prime = false;
					break;
				}
			}

			if(is_prime){
				primes.add(i);
			}
		}
		// End of Find Prime Algorithm

		// Print Result
		for(Integer i : primes){
			System.out.print(i+", ");
		}
		System.out.println();

	}
}