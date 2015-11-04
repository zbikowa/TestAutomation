package fruitsTests;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import fruitCalculator.AsianPearsDbProvider;
import fruitCalculator.PearCalculator;

/**
 * Set of tests for PearCalculator - that cover all scenarios presented during the workshop.
 * 
 * @author Mirek Rakowski <https://github.com/mirek-rakowski>
 * @see https://github.com/mirek-rakowski/TestAutomation
 * @see Wiki on <https://github.com/mirek-rakowski/TestAutomation/wiki> for more info.
 */
public class PearCalculatorTests {

	PearCalculator pearCalculator;
	AsianPearsDbProvider dbProvider;
	
	@BeforeClass
	public void setup(){
		dbProvider = Mockito.mock(AsianPearsDbProvider.class);
		pearCalculator = new PearCalculator();
	}
	
	@Test
	public void ifThreeAsianPearsAreLessThanFivePears(){
		PearCalculator localPearCalculator = new PearCalculator(dbProvider);
		Mockito.when(dbProvider.getAllAsianFruits()).thenReturn(new String[] {"pear", "pear", "pear"});
		Assert.assertFalse(localPearCalculator.ifMoreThanFivePearsInAsia());
	}
	
	@Test
	public void ifSixAsianPearsAreMoreThanFivePears(){
		PearCalculator localPearCalculator = new PearCalculator(dbProvider);
		Mockito.when(dbProvider.getAllAsianFruits()).thenReturn(new String[] {"pear", "pear", "pear", "pear", "pear", "pear"});
		Assert.assertTrue(localPearCalculator.ifMoreThanFivePearsInAsia());
	}
	
	@Test
	public void ifTwoPearsAreNotMoreThanThreePears(){
		Assert.assertTrue(pearCalculator.ifNotMoreThanThreePears(new String[] { "pear", "pear"}));
	}
	
	@Test
	public void ifThreePearsAreNotMoreThanThreePears(){
		Assert.assertTrue(pearCalculator.ifNotMoreThanThreePears(new String[] { "pear", "pear", "pear"}));
	}
	
	@Test
	public void isPearAPear(){
		Assert.assertTrue(pearCalculator.isFruitAPear("pear"));
	}
	
	@Test
	public void isAppleNotAPear(){
		Assert.assertFalse(pearCalculator.isFruitAPear("apple"));
	}
	
	@Test
	public void threePearsAreThreePears(){
		String[] fruits = new String[] {"pear", "pear", "pear"};
		Assert.assertEquals(pearCalculator.countPears(fruits), 3);
	}

	@Test
	public void threePearsAreLessThanFivePears(){
		String[] fruits = new String[] {"pear", "pear", "pear"};
		Assert.assertFalse(pearCalculator.ifMoreThanFivePears(fruits));
	}

	
	@Test
	public void allCitrusesAreNotPears(){
		String[] cit = new String[] {"melon", "banana", "lime", "orange"};
		
		for(int i = 0; i< cit.length; i++)
		{
			Assert.assertFalse(pearCalculator.isFruitAPear(cit[i]));
		}
	}
	
	@Test
	public void largePearIsAPear(){
		Assert.assertTrue(pearCalculator.isFruitAPear("PEAR"));
	}
	
	@Test(dataProvider = "provideFruitSet")
	public void followingThreeFruitsAreNotPears(String fruit1, String fruit2, String fruit3) {
		Assert.assertFalse(pearCalculator.isFruitAPear(fruit1));
		Assert.assertFalse(pearCalculator.isFruitAPear(fruit2));
		Assert.assertFalse(pearCalculator.isFruitAPear(fruit3));
	}

	@DataProvider
	public Object[][] provideFruitSet()
	{
		return new Object[][] {
				{ "apple", "apple", "apple" },
				{ "watermelon", "banana", "lime" },
				{ "coffee", "butter", "milk" },
				{ "coffee", "butter", "mug" }
		};
	}
}
