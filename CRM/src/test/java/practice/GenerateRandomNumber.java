package practice;

import java.util.Random;

public class GenerateRandomNumber {
public static void main(String[] args) {
	
	Random random = new Random();
	int randomint = random.nextInt(1000);
	System.out.println(randomint);
}
}
