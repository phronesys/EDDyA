import java.util.*; 
import java.lang.*; 
import java.io.*; 

public class volcado {
	public static void main(String[] args) {
		BufferedReader reader;
		BufferedWriter writer;
		//String[] filenames = {"./stats1.csv","./stats2.csv"};
		String[] filenames = {"./stats3.csv"};
		String[] filenames2 = {"./participants.csv"};
		HashMap<Integer, Integer> duocarry = new HashMap<Integer,Integer>();
		HashMap<Integer, Integer> duosupport = new HashMap<Integer,Integer>();
		HashMap<Integer, Integer> solo = new HashMap<Integer,Integer>();
		HashMap<Integer, Integer> none = new HashMap<Integer,Integer>();
		HashMap<Integer, Integer> totdmgdealt = new HashMap<Integer,Integer>();
		String<Integer, Integer> outfilename = "./roles_out.txt";			
		try 
		{
			writer = new BufferedWriter(new FileWriter(outfilename, false));

			String line; 
			boolean started = false;

			for(String fn : filenames)
			{
				reader = new BufferedReader(new FileReader(fn));		
				line = reader.readLine();
				started = false;

				while (line != null)
				{
					String[] row1;
					Integer playerId, totdmg;
					row1 = line.split(",",-1);
					if(started)
					{
						row1[0] = row1[0].replace("\"",""); //Id jugador: 0
						row1[21] = row1[21].replace("\"",""); //Totaldmgdealt: 21
						
						playerId = Integer.parseInt(row1[0]);
						totdmg = Integer.parseInt(row1[21]);

						totdmgdealt.put(playerId,totdmg);
					}
					started = true;
					line = reader.readLine();
				}
				reader.close();
			}

			for(String fn2: filenames2)
			{
				reader = new BufferedReader(new FileReader(fn2));
				started = false;
				line = reader.readLine();
				while (line != null)
				{
					String[] row1;
					Integer playerId;
					row1 = line.split(",",-1);
					
					if(started)
					{
						row1[0] = row1[0].replace("\"",""); //Id jugador: 0
						row1[6] = row1[6].replace("\"",""); //Role: 6
						playerId = Integer.parseInt(row1[0]);
						//System.out.println(row1[6]);

						if(totdmgdealt.get(playerId) != null)
						{
							switch(row1[6]) 
							{
								case "DUO_CARRY":
									duocarry.put(playerId,totdmgdealt.get(playerId));
									break;
								case "DUO_SUPPORT":
									duosupport.put(playerId,totdmgdealt.get(playerId));
									break;
								case "SOLO":
									solo.put(playerId,totdmgdealt.get(playerId));
									break;
								case "NONE":
									none.put(playerId,totdmgdealt.get(playerId));
									break;
								default:
									break;
							}
						}
					}	
					started = true;
					line = reader.readLine();
				}
				reader.close();
			}

			
			/*insertSort is = new insertSort();
			bubbleSort bs = new bubbleSort();
			selectSort ss = new selectSort();
			heapSort hs = new heapSort();
			quickSort qs = new quickSort();
			mergeSort ms = new mergeSort();
			dataset = is.Isort(dataset);
			dataset = bs.Bsort(dataset);
			dataset = ss.Ssort(dataset);
			dataset = hs.Hsort(dataset);
			dataset = qs.Qsort(dataset);
			dataset = ms.Msort(dataset);*/
			//ColaPriorizadaMaxHeap pqmh = new ColaPriorizadaMaxHeap();

			writer.write("DUO CARRY\n\n");
			writer.write("Id \t TotDmg\n---------------\n");
			duocarry.forEach((k,v)->
			{
				try
				{
					writer.write(k + "\t" + v + "\n");
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
				
			});
			writer.write("\n\n\n");

			writer.write("DUO SUPPORT\n\n");
			writer.write("Id \t TotDmg\n---------------\n");
			duosupport.forEach((k,v)->
			{
				try
				{
					writer.write(k + "\t" + v + "\n");
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
				
			});
			writer.write("\n\n\n");

			writer.write("SOLO\n\n");
			writer.write("Id \t TotDmg\n---------------\n");
			solo.forEach((k,v)->
			{
				try
				{
					writer.write(k + "\t" + v + "\n");
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
				
			});
			writer.write("\n\n\n");

			writer.write("NONE\n\n");
			writer.write("Id \t TotDmg\n---------------\n");
			none.forEach((k,v)->
			{
				try
				{
					writer.write(k + "\t" + v + "\n");
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
				
			});
			writer.write("\n\n\n");
		
			writer.close();

			ArrayList<HashMap<Integer,Integer>> data = new ArrayList<HashMap<Integer,Integer>>();
			data.add(duocarry);
			data.add(duosupport);
			data.add(solo);
			data.add(none);
			Prim p = new Prim();
			Integer team[] = new Integer[5];
			team = p.calcTeam(11,data);

		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}