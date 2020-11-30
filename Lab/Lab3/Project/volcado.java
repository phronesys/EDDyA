import java.util.*;
import java.lang.*;
import java.lang.reflect.Array;
import java.io.*;

public class volcado {
	public static void main(String[] args) {
		BufferedReader reader;
		BufferedWriter writer;
		//String[] filenames = {"./stats1.csv", "./stats2.csv"};
		String[] filenames = {"./stats3.csv"};
		String[] filenames2 = {"./participants.csv"};
		HashMap<Integer, Integer> duocarry = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> duosupport = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> solo = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> none = new HashMap<Integer, Integer>();
		
		// totdmgdealt guarda [id - totdmg] por cada player de stats 1 y 2
		HashMap<Integer, Integer> totdmgdealt = new HashMap<Integer, Integer>();
		String outfilename = "./out.csv";
		
		try {
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
					String[] row;
					Integer playerId, totdmg;
					row = line.split(",", -1);
					if(started){
						row[0] = row[0].replace("\"",""); // 0
						row[21] = row[21].replace("\"","");

						playerId = Integer.parseInt(row[0]);
						totdmg = Integer.parseInt(row[21]);

						totdmgdealt.put(playerId, totdmg);
					}
					started = true;
					line = reader.readLine();
				}
				reader.close();
			}
			for(String fn : filenames2)
			{
				reader = new BufferedReader(new FileReader(fn));
				started = false;
				line = reader.readLine();
				while(line != null)
				{
					String[] row;
					Integer playerId;
					row = line.split(",",-1);
					if(started)
					{
						row[0] = row[0].replace("\"","");
						row[6] = row[6].replace("\"","");
						playerId = Integer.parseInt(row[0]);

						if(totdmgdealt.get(playerId) != null){	
							switch(row[6])
							{
								case "DUO_CARRY":
									duocarry.put(playerId, totdmgdealt.get(playerId));
									break;
								case "DUO_SUPPORT":
									duosupport.put(playerId, totdmgdealt.get(playerId));
									break;
								case "SOLO":
									solo.put(playerId, totdmgdealt.get(playerId));
									break;
								case "NONE":
									none.put(playerId, totdmgdealt.get(playerId));
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
			// esto se ve muy bonito asi que lo dejo :v //
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
			///-------------------------------------------///
			ArrayList<HashMap<Integer,Integer>> data = new ArrayList<HashMap<Integer,Integer>>();
			data.add(duocarry);
			data.add(duosupport);
			data.add(solo);
			data.add(none);

			Prim p = new Prim();
			Integer team[] = new Integer[5];
			


		} catch (Exception e) {
			e.printStackTrace();
		}
		
		 
		

	}
}