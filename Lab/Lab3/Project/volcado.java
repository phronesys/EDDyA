import java.util.*;
import java.io.*;

public class volcado {
	public static void main(String[] args) {
		BufferedReader reader;
		//String[] filenames = {"./stats1.csv", "./stats2.csv"};
		String[] filenames = {"./stats3.csv"};
		String[] filenames2 = {"./participants.csv"};
		HashMap<Integer, Integer> duocarry = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> duosupport = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> solo = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> none = new HashMap<Integer, Integer>();
		
		// totdmgdealt guarda [id - totdmg] por cada player de stats 1 y 2
		HashMap<Integer, Integer> totdmgdealt = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> teamData = new HashMap<Integer, Integer>();

		try {
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
						row[0] = row[0].replace("\"",""); 
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
			// se manda data -> prim
			ArrayList<HashMap<Integer,Integer>> data = new ArrayList<HashMap<Integer,Integer>>();
			data.add(duocarry);
			data.add(duosupport);
			data.add(solo);
			data.add(none);

			Prim p = new Prim();
			Integer currentTeamDmg;
			ArrayList<Integer> entries = new ArrayList<Integer>(); // guarda keys de carrys

			for(Map.Entry<Integer, Integer> entry: duocarry.entrySet())
			{
				entries.add(entry.getKey());
			}

			// para cada carry crea su equipo
			for(int i = 0; i < entries.size(); i++){
				currentTeamDmg = p.matchmaking(entries.get(i), data); 
				//System.out.println(currentTeamDmg);
				teamData.put(i, currentTeamDmg);
			}

			greedy miau = new greedy();
			ArrayList<Integer> teamsIdOrdenados = miau.bracket(teamData);
			int j = 0;
			for(int i = 0; i < teamsIdOrdenados.size()-1; i++){
				if(teamsIdOrdenados.get(i+1) != null){
					System.out.print("Match " + j + ": Team " + teamsIdOrdenados.get(i) + " (" + teamData.get(teamsIdOrdenados.get(i)) + ")" );
					System.out.println("\tVs Team " + teamsIdOrdenados.get(i+1) + " (" + teamData.get(teamsIdOrdenados.get(i+1)) + ")" );
				} else {
					System.out.print("El Team " + teamsIdOrdenados.get(i) + " (" + teamData.get(teamsIdOrdenados.get(i)) + ") queda pendiente para la siguiente ronda. uwu" );
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}