import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;


public class Graf 
{	
	
	public static ArrayList<Integer> BF (ArrayList<ArrayList<Integer>> arrParam)
	{
		ArrayList<Integer> arrToReturn = new ArrayList<Integer>();
		HashMap<Integer, Boolean> hash = new HashMap<Integer, Boolean>();
		
		for (Integer integer : arrParam.get(0)) 
		{
			arrToReturn.add(integer);
			hash.put(integer, true);
		}
		
		for (Integer parser : arrToReturn)
		{
			for (Integer integer : arrParam.get(parser - 1))
			{
				if(!hash.get(integer))
					arrToReturn.add(integer);
			}
		}
		return arrToReturn;
	}
	
	
	public static int nextElement(int nToSearch, ArrayList<Integer> arrList, HashMap<Integer, Boolean> hash)
	{
		int nToReturn = 0;
		
		for (Integer integer : arrList)
		{
			
		}
		
		return nToReturn;
	}
	
	public static ArrayList<Integer> DF (ArrayList<ArrayList<Integer>> arrParams)
	{
		ArrayList<Integer> arrToReturn = new ArrayList<Integer>();
		HashMap<Integer, Boolean> hash = new HashMap<Integer, Boolean>();
		
		for (ArrayList<Integer> list : arrParams)
		{
			hash.put(arrParams.indexOf(list) + 1, true);
			arrToReturn.add(arrParams.indexOf(list));
			for (Integer integer : list) 
			{
				if(hash.containsKey(integer))
				{
					if(hash.get(integer))
					{
						hash.put(integer, true);
						arrToReturn.add(integer);
					}
				}
				else
				{
					hash.put(integer, true);
					arrToReturn.add(integer);
				}
				
			}
			
		}
		
		return arrToReturn;
	}
	
	/**
	 * @param args
	 * The input file will contain on the first line the nodes that connect to the first one
	 * on the second line will be the nodes adicent to the second one and so on, and so forth.
	 */
	public static void main(String[] args)
	{
		File file = new File("elodia.txt");
		try
		{
			Scanner sc = new Scanner(file);
			ArrayList<ArrayList<Integer>> arrColum = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> arrLine = new ArrayList<Integer>();
			boolean hasNextLine = sc.hasNextLine();
			
			while(hasNextLine)
			{
				ArrayList<Integer> temp = new ArrayList<Integer>();
				int isRead = sc.nextInt();
				temp.clear();
				while(isRead != 0)
				{
					System.out.println(isRead);
					temp.add(isRead);
					isRead = sc.nextInt();
				}
				System.out.println("ArrTemp:" + temp);
				arrLine = temp;
				System.out.println("Arrline: " + arrLine);
				arrColum.add(arrLine);
				System.out.println("ArrColumn" + arrColum);
				hasNextLine = sc.hasNextLine();
			}
			
			int nCounter = 1;
			/**
			 * This prints the graph.
			 */
			for (ArrayList<Integer> nParser : arrColum)
			{
				System.out.print(nCounter + ": ");
				System.out.print(nParser);
				nCounter++;
				System.out.println();
			}
			
			System.out.println(BF(arrColum));
		}
		catch (FileNotFoundException ex)
		{
			System.out.println(ex);
		}
		
	}
}
