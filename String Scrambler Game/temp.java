import java.awt.*;	
import java.util.*;
import java.io.*;	
import java.text.*;	
import java.util.regex.*;

public class temp{
	 
        public static void main(String args[])
        {
			int x = 0;
			while (x==0)
			{
				
			//Declared EasyReaders, Ints, Chars, and Arrays
			
			int numwords1;
			int z = 1;
			char quit3 = 'p';
			char quit2;
			String wrdinput2;
			EasyReader numwords2;
			numwords2 = new EasyReader();
			System.out.println("Enter the amount of words to be scrambled");
			numwords1 = numwords2.readInt();
			String[] strArr1 = new String[numwords1];
			String[] strArr2 = new String[numwords1];
			ArrayList<Integer> list = getRandomNonRepeatingIntegers(numwords1, 0, numwords1-1);
			
			//Adds each word to the array
			
			for (int i=0;i<numwords1;i++)
			{
				int wordnum = i+1;
				String word2;
				EasyReader word1;
				word1 = new EasyReader();
				System.out.println("Enter word number "+wordnum);
				word2 = word1.readLine();
				strArr1[i] = word2;
				strArr2[i] = shuffle(word2);
				System.out.println("");
			}
			
			System.out.println("");
			System.out.println("Now try to unscramble your words!");
			
			//Checks the guesses
			
			do{
				int t = 0;
				System.out.println("Random Word "+z);
				System.out.println(": "+strArr2[list.get(z-1)]);
					while (t==0)
					{
						EasyReader wrdinput1;
						wrdinput1 = new EasyReader();
						wrdinput2 = wrdinput1.readLine();
						if (Objects.equals(wrdinput2, strArr1[list.get(z-1)]))
						{
							System.out.println("That was correct!");
							t=1;
						}
						else 
						{
							System.out.println("That was incorrect. Try again.");
						}
					}
				z++;
				System.out.println("");
			} while (z <= numwords1);
			
			//Asks to play again or to quit
			
			System.out.println("Press any key to quit or 'p' to play again");
			EasyReader quit1;
			quit1 = new EasyReader();
			quit2 = quit1.readChar();
			if (Objects.equals(quit2, quit3))
			{
				x = 0;
				System.out.println("");
				continue;
			}
			else
			{
				System.exit(1);
			}
			
			}
			
		}
		
		//Word Scrambler Method
		
		public static String shuffle(String string) {
			StringBuilder sb = new StringBuilder(string.length());
					double rnd;
				for (char c: string.toCharArray()) {
					rnd = Math.random();
				if (rnd < 0.34)
					sb.append(c);
				else if (rnd < 0.67)
					sb.insert(sb.length() / 2, c);
				else
					sb.insert(0, c);
			}       
		return sb.toString();
}

		//Random number method with no repeats
		
		public static int getRandomInt(int min, int max) {
			Random random = new Random();

			return random.nextInt((max - min) + 1) + min;
			}
			
		public static ArrayList<Integer> getRandomNonRepeatingIntegers(int size, int min,int max) {
			ArrayList<Integer> numbers = new ArrayList<Integer>();

			while (numbers.size() < size) {
				int random = getRandomInt(min, max);

			if (!numbers.contains(random)) {
				numbers.add(random);
			}
			}

			return numbers;
		}
}