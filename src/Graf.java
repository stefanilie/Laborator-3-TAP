import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;


public class Graf 
{
	/**
	 * This function calculates the neighbors of the provided node.
	 * @param arrParams All the neighbors of the node.
	 * @param bStartNode True if if the start node of the BF or false if else.
	 * @return
	 */
	public static ArrayList<Integer> BF (ArrayList<Integer> arrParams, boolean bStartNode, HashMap<Integer, Boolean> hash)
	{
		ArrayList<Integer> arrToReturn = new ArrayList<Integer>();
		
		//this adds all the neighbors of the start node.
		if(bStartNode)
		{
			for (Integer integer : arrParams)
			{
				arrToReturn.add(integer);
				hash.put(integer, true);
			}
		}
		else
		{
			for (Integer integer : arrParams)
			{
				if(!hash.containsKey(integer))
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
			HashMap<Integer, Boolean> hash = new HashMap<Integer, Boolean>();
			int nStartNode = sc.nextInt();
			boolean hasNextLine = sc.hasNextLine();
			int nCounter = 1;
			
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
				arrLine = temp;
				arrColum.add(arrLine);
				System.out.println("ArrColumn" + arrColum);
				
				//this initalizes the hash with default value false for all nodes.
				hash.put(nCounter, false);
				System.out.println("Hash: " + hash);
				nCounter ++;
				hasNextLine = sc.hasNextLine();
			}
			
			sc.close();
			
			nCounter = 1;
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
			
			//here starts the BF function
			ArrayList<Integer> arrFirstWave = new ArrayList<Integer>();
			
			//maybe the hash value won't be refreshed after the function call here.
			//In this case, make a forech here.
			arrFirstWave = BF(arrColum.get(nStartNode - 1), true, hash);
			arrFirstWave.add(nStartNode);
			hash.put(nStartNode, true);
		
			//This will store the final result
			ArrayList<Integer> arrFinalResult = new ArrayList<Integer>();
			arrFinalResult = arrFirstWave;
			
			ArrayList<Integer> temp = new ArrayList<Integer>();
			boolean bContains = true;
			
			//after we got the neighbors for the first node, we start the second part of the BF.
			while(bContains)
			{	
				for (Integer integer : arrFirstWave)
				{
					temp.clear();
					temp = BF(arrColum.get(integer - 1), false, hash);
					for (Integer aux : temp)
					{
						arrFinalResult.add(aux);
						//also if the hash doesn't refresh here, refresh it here manually.
					}
				}
				if(hash.containsValue(false) && arrFinalResult != arrFirstWave)
				{
					arrFirstWave = arrFinalResult;
				}
				else if(hash.containsValue(false))
				{
					for (Integer intr : hash.keySet())
					{
							if(hash.get(intr) == false)
							{
								temp.clear();
								temp = BF(arrColum.get(intr - 1), false, hash);
							}
							for (Integer aux : temp)
							{
								arrFinalResult.add(aux);
								//also if the hash doesn't refresh here, refresh it here manually.
							}  
					}
				}
				else
				{
					bContains = false;
				}
			}
			System.out.println("Parcurgerea: " + arrFinalResult);
		}
		catch (FileNotFoundException ex)
		{
			System.out.println(ex);
		}
		
	}
}
