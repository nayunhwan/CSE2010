/*
 * (C) 2015 CSE2010 HW #2
 * 
 */

public interface Polynomial {
	/*
	 * Returns the degree of the polynomial
	 */
	public int getDegree();

	/*
	 * Returns the coefficient for the given input term "exponent"
	 */
	public double getCoefficient(int exponent);
	
	/*
	 * Add this object with a given input "p" and returns itself.
	 */
	public Polynomial padd(Polynomial p);
	
	/*
	 * Multiply this object with a given input "p" and returns itself.
	 */
	Polynomial pmult(Polynomial p);

	/*
	 * Insert a new term to this polynomial object. 
	 * Throws a DupicateException if a term with the same exponent
	 * as the given input term already exists.
	 */
	public void attach(Term term);
	
	/*
	 * Returns the result of the polynomial evaluation for a given input "x"
	 */
	public double evaluate(double val);
	
	/*
	 * Print the contents of the current polynomial as a sequence of 
	 * (coeff_n, expo_n) (coeff_n-1, expo_n-1) ... (coeff_0, expo_0) 
	 * in decreasing order of terms.
	 */
	public void printMe();
}