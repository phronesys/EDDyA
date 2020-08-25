import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class volcado {
	public static void main(String[] args) {
		BufferedReader reader;
		BufferedWriter writer;
		ArrayList<ArrayList<String>> dataset = new ArrayList<ArrayList<String>>();
		try {
			reader = new BufferedReader(new FileReader("./COVID19_open_line_list.csv"));
			writer = new BufferedWriter(new FileWriter("./salida_java.csv", false));
			String line = reader.readLine();
			int i = 0, j = 0, k = 0;
			while (line != null)
			{
				ArrayList<String> parsing1 = new ArrayList<String>();
				String[] row1, row2;
				row1 = line.split("\"",-1);
				for(String x : row1)
				{
					if(x.length() > 0 && x.charAt(0) == ',')
					{
						if(x.length() > 1)
						{
							x = x.substring(1, x.length());
						}
					}
					if(i%2 == 0)
					{
						if(x.length() > 0 && x.charAt(x.length()-1) == ',')
						{
							x = x.substring(0, x.length()-1);
						}
						row2 = x.split(",",-1);
						//System.out.println(row2.length);
						for(String y : row2)
						{
							parsing1.add(y);
						}
					}
					else
					{
						String z = new String("\"");
						z = z.concat(x);
						z = z.concat("\"");
						parsing1.add(z);
					}
					i++;
				}
				i = 0;
				dataset.add(parsing1);
				line = reader.readLine();
			}
			for(ArrayList a : dataset)
			{
				for(j = 0; j < a.size()-1; j++)
				{
					writer.write(a.get(j).toString());
					writer.write(",");
				}
				writer.write(a.get(j).toString());
				//writer.write(System.getProperty("line.separator"));
				writer.write("\n");
			}
			reader.close();
			writer.close();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}