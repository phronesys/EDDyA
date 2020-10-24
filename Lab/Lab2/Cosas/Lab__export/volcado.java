import java.util.*; 
import java.lang.*; 
import java.io.*; 

public class volcado {
	public static void main(String[] args) {
		BufferedReader reader;
		BufferedWriter writer;
		//String[] filenames = {"./stats1.csv","./stats2.csv","./participants.csv","./champs.csv"};
		String[] filenames = {"./stats1.csv","./stats2.csv"};
		//String[] filenames = {"./stats3.csv"};
		String[] filenames2 = {"./participants.csv","./champs.csv"};
		ArrayList<Tripleta> dataset = new ArrayList<Tripleta>();
		HashMap mapa1 = new HashMap<Integer,String>();
		HashMap mapa2 = new HashMap<Integer,Integer>();
		String outfilename = "./stats_out.csv";			
		try 
		{
			writer = new BufferedWriter(new FileWriter(outfilename, false));

			String line; 
			boolean started = false;
			// participants and champs .csv
			for(String fn2: filenames2)
			{
				reader = new BufferedReader(new FileReader(fn2));
				started = false;
				line = reader.readLine();
				while (line != null)
				{
					String[] row1;
					row1 = line.split(",",-1);
					
					if(started)
					{
						if(fn2.compareTo("./champs.csv") == 0)
						{
							row1[0] = row1[0].replace("\"",""); //Nombre heroe: 0
							row1[1] = row1[1].replace("\"",""); //Id heroe: 1
							mapa1.put(Integer.parseInt(row1[1]),row1[0]);
						}
						else
						{
							row1[0] = row1[0].replace("\"",""); //Id jugador: 0
							row1[3] = row1[3].replace("\"",""); //Id heroe: 3
							mapa2.put(Integer.parseInt(row1[0]),Integer.parseInt(row1[3]));	
						}
					}
					started = true;
					line = reader.readLine();
				}
				reader.close();
			}

			for(String fn : filenames)
			{
				reader = new BufferedReader(new FileReader(fn));		
				line = reader.readLine();
				started = false;

				while (line != null)
				{
					String[] row1;
					String heroName;
					Integer playerId, heroId;
					row1 = line.split(",",-1);
					if(started)
					{
						Tripleta t;
						row1[0] = row1[0].replace("\"",""); //Id jugador: 0
						row1[21] = row1[21].replace("\"",""); //Totaldmgdealt: 21
						
						playerId = Integer.parseInt(row1[0]);
						heroId = (Integer)mapa2.get(playerId);
						heroName = (String)mapa1.get(heroId);
						if(heroName != null && !heroName.isEmpty())
						{
							t = new Tripleta(row1[0], row1[21], heroName);
							dataset.add(t);
						}
					}
					started = true;
					line = reader.readLine();
				}
				reader.close();
			}
			insertSort is = new insertSort();
			dataset = is.Isort(dataset);
			for(Tripleta a : dataset)
			{
				writer.write(Integer.toString(a.getId()));
				writer.write(",");
				writer.write(Integer.toString(a.getDmg()));
				writer.write(",");
				writer.write((String)(a.getHero()));
				writer.write("\n");
			}
			writer.close();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}