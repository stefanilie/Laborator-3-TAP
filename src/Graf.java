import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class Graf 
{	
	
	public static ArrayList<Integer> BF (ArrayList<ArrayList<Integer>> arrParam, ArrayList<Integer> arrResult, boolean bFirstWave,
			int nStartIndex, HashMap<Integer, Boolean> hash)
	{
		if(bFirstWave)
		{
			//adauga toti fratii nodului de start
			for (Integer integer : arrParam.get(nStartIndex - 1)) 
			{
				arrResult.add(integer);
				hash.put(integer, true);
			}
		}
		else
		{
			for (Integer parser : arrResult) 
			{
				for (Integer integer : arrParam.get(parser - 1))
				{
					if(!hash.containsKey(integer))
					{
						hash.put(integer, true);
						arrResult
						//TODO vezi si tu aici care'i baiu' ca cam faci aceeasi treaba ca mai jos
						//halal refactoring
						//#rudarel
					}
				}
			}
		}
		/*
		ArrayList<Integer> arrToReturn = new ArrayList<Integer>();
		HashMap<Integer, Boolean> hash = new HashMap<Integer, Boolean>();
		ArrayList<Integer> arrTemp = new ArrayList<Integer>();
		
		// Adds to the return list the nodes adiacent to the first node
		// TODO add start node feature
		for (Integer integer : arrParam.get(0)) 
		{
			arrToReturn.add(integer);
			hash.put(integer, true);
		}
		
		System.out.println("\n\nHash:" + hash);
		
		//this passes through all the arraylists of the matrice
		for (Integer parser : arrToReturn)
		{
			arrTemp.clear();
			for (Integer integer : arrParam.get(parser - 1))
			{
				if(!hash.containsKey(integer))
				{
				
					arrTemp.add(integer);
					//TODO nu poa sa faca recursiv aici, cand ii atribui
					// pe arrReturn, foreachu de rahat din java
					//nu permite modificarea lui
					//refactoring maine la prima ora
					//#zacusca
					//faci prumu val cu return si tot ce e in return cu 
					hash.put(integer, true);
				}
			}
			System.out.println("Pentru parser = " + parser + " arrReturn = " + arrToReturn + " iar hash : " + hash);
		}
		return arrToReturn;
		*/
	}
	
	
	public static int nextElement(int nToSearch, ArrayList<Integer> arrList, HashMap<Integer, Boolean> hash)
	{
		int nToReturn = 0;
		
		for (Integer integer : arrList)
		{
			
		}
		
		return nToReturn;
	}
	
	public static ArrayList<Integer> DF (ArrayList<ArrayList<Integer>> arrParams, int nStartNode)
	{
		ArrayList<Integer> arrToReturn = new ArrayList<Integer>();
		HashMap<Integer, Boolean> hash = new HashMap<Integer, Boolean>();
		
		for (ArrayList<Integer> list : arrParams)
		{
			// vizitez pe primul si il adaug la return
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
			
			sc.close();
			
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
