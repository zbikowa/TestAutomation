package fruitCalculator;

public class PearCalculatorUgly {

	public void writeMeIfMoreThanFivePears(String[] fruits)
	{
		int numberOfFruits = fruits.length;
		int pears = 0;
		int fruitsChecked = 0;
		int counter = 0;					
		
		while(fruitsChecked < numberOfFruits)
		{
			//Take another fruit
			String fruit = fruits[counter++];
			
			if(fruit.equals("pear"))
			{
				pears = pears + 1;
			}
			
			fruitsChecked++;
		}
				
		if(pears > 5)
		{
			System.out.println("YES");
		}
		else
		{
			System.out.println("NO");
		}
	}
	
	public static void main(String[] args) {
		String[] fruits = new String[] { "pear", "pear", "apple", "pear", "pear", "apple" };
		new PearCalculator().writeMeIfMoreThanFivePears(fruits);
	}
}


