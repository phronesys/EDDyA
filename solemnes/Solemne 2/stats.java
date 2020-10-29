import java.util.*;

public class stats {
    public static void main(String[] args) {
        Map<String, List<String>> deportes = new HashMap<String, List<String>> ();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        List<String> personas = new ArrayList();
        String deporte;
        for(int i = 0; i < n; i++)
        {
            
            String persona = scan.nextLine();
            personas.add(persona);

            deporte = scan.nextLine();
            deportes.put(deporte, personas);
        }
        System.out.println((deportes.get("football")).size());
    }
}
