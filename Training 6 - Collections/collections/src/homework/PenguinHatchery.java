package homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Class for creating Penguins at your discretion  
 *
 */
public class PenguinHatchery {
	private final int MAX_MATES = 3;

	private Random rand;
	private char [] letters;
	private List<PenguinRace> penguinRaces = Arrays.asList(PenguinRace.values());
	private int numberOfRaces = penguinRaces.size();

	public PenguinHatchery() {
		rand = new Random();
		StringBuilder sb = new StringBuilder();
		for(char c= 'a' ; c <= 'z' ; c++){
			sb.append(c);
		}
		letters = sb.toString().toCharArray();
	}
	
	
	public Penguin hatchPenguin(){
		return new Penguin("pingu-"+generateString(5),
							penguinRaces.get(rand.nextInt(numberOfRaces)),
							rand.nextDouble()*15);
	}

	public List<Penguin> matePenguin() {
		int mateCount = rand.nextInt(MAX_MATES);
		List<Penguin> mates = new ArrayList<>();

		for(int i = 0; i <= mateCount; i++) {
			mates.add(hatchPenguin());
		}

		return mates;
	}
	
	/**
	 * Generates a random string of the specified length
	 * @param length - Length of the string being generated
	 */
	private String generateString(int length){
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ;i < length; i++){
			sb.append(letters[rand.nextInt(letters.length)]);
		}
		return sb.toString();
	}







}
