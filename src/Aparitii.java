import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Aparitii {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		File file = new File("elodia.txt");
		try
		{
			Scanner sc = new Scanner(file);
			HashMap<String, Integer> dictionary = new HashMap<String, Integer>();
			String isRead = "";
			while(sc.hasNext())
			{
				isRead = sc.next();
				if(dictionary.containsKey(isRead))
				{
					dictionary.put(isRead, dictionary.get(isRead)+1);
				}
				else 
				{
					dictionary.put(isRead, 1);
				}
			}
			System.out.println("Output:" + dictionary);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}

}
