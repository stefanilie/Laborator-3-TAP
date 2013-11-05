import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class Graf 
{

	/**
	 * @param args
	 * The input file will contain on the first line the nodes that connect to the first one
	 * on the second line will be the nodes adicent to the second one and so on, and so forth.
	 */
	public static void main(String[] args)
	{
		int nIsRead;
		File file = new File("elodia.txt");
		try
		{
			Scanner sc = new Scanner(file);
			ArrayList<ArrayList<Integer>> arrColum = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> arrLine = new ArrayList<Integer>();
			
			while(sc.hasNextLine())
			{
				ArrayList<Integer> arrTemp = new ArrayList<Integer>();
				while(sc.next() != "\n")
				{
					arrTemp.add(sc.nextInt());
				}
				arrLine = arrTemp;
				arrColum.add(arrLine);
				sc.nextLine();
			}
			
			
			/**
			 * This prints the graph.
			 */
			for (ArrayList<Integer> nParser : arrColum)
			{
				for (Integer nNumber : arrLine) 
				{
					System.out.println(arrLine.indexOf(nNumber) + ": ");
					if(nNumber != arrLine.get(arrLine.size()-1))
					{
						System.out.println(nNumber + "->");
					}
					else 
					{
						System.out.println(nNumber);
					}
				}
			}
		}
		catch (FileNotFoundException ex)
		{
			System.out.println(ex);
		}
		}
		
		

	}
