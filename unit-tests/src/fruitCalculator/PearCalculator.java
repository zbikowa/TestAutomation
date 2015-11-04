package fruitCalculator;

import java.util.Arrays;

/**
 * This is a better version of class that counts Pears - now tests are much easier to be written.
 * 
 * @author Mirek Rakowski <https://github.com/mirek-rakowski>
 * @see https://github.com/mirek-rakowski/TestAutomation
 * @see Wiki on <https://github.com/mirek-rakowski/TestAutomation/wiki> for more info.
 */

public class PearCalculator {

	private AsianPearsDbProvider dbProvider;
	
	public PearCalculator(){
		dbProvider = new AsianPearsDbProvider();
	}
	
	public PearCalculator(AsianPearsDbProvider dbExternal){
		dbProvider = dbExternal;
	}
	
	public boolean ifMoreThanFivePearsInAsia(){
		return countPears(dbProvider.getAllAsianFruits()) > 5;
	}
	
	public void writeMeIfMoreThanFivePears(String[] fruits)
	{
		if(ifMoreThanFivePears(fruits))
		{
			System.out.println("YES");
		}
		else
		{
			System.out.println("NO");
		}
	}

	public boolean ifMoreThanFivePears(String[] fruits) {
		return countPears(fruits) > 5;
	}

	/**
	 * Main counting loop - before refactoring.
	 * @see next method for refactored version.
	 */
	public long countPears(String[] fruits) {
		int numberOfFruits = fruits.length;
		int pears = 0;
		int fruitsChecked = 0;
		int counter = 0;				
		
		while(fruitsChecked < numberOfFruits)
		{
			//Take another fruit
			String fruit = fruits[counter++];
			
			if(isFruitAPear(fruit)) {
				pears++;
			}
			
			fruitsChecked++;
		}
		return pears;
	}

	/**
	 * This entire method can be reduced to one liner - our automated tests can be 
	 * our validation of refactoring was successful.
	 * @category This uses Java 8 structures.
	 */
//	public long countPears(String[] fruits) {
//		return Arrays.asList(fruits).stream().filter(fruit -> isFruitAPear(fruit)).count();
//	}
	
	public boolean isFruitAPear(String fruit) {
		return fruit.equalsIgnoreCase("pear"); //PEAR
	}
	
	public static void main(String[] args) {
		String[] fruits = new String[] { "pear", "pear", "apple", "pear", "pear", "apple" };
		new PearCalculator().writeMeIfMoreThanFivePears(fruits);
	}

	public boolean ifNotMoreThanThreePears(String[] fruits) {
		return countPears(fruits) <= 3;
	}
}
