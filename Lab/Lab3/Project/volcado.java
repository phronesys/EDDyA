import java.util.*;
import java.lang.*;
import java.io.*;

public class volcado {
	public static void main(String[] args) {
		BufferedReader reader;
		BufferedWriter writer;
		String[] filenames = {"./stats1.csv", "./stats2.csv"};
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
						playerId = Integer.parseInt(row[0]);

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
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		 
		

	}
}