import java.util.*;
import java.lang.*;
public class idiomaSecreto {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        System.out.println(solve(input));
        scan.close();
    }  
    public static String solve(String input){
        String output = "";
        Stack<Character> stacky = new Stack<Character>();
        for(int i = input.length() -1; i >= 0; i--){
            stacky.push(input.charAt(i));
        }

        while(!stacky.isEmpty()){ // stacky tiene cada char en orden
            if(Character.isDigit(stacky.peek())){
                int veces = Character.getNumericValue(stacky.peek());         
                stacky.pop();       
                if(stacky.pop() == '['){
                    String trim = "";
                    trim += stacky.pop();
                    while(stacky.peek() != ']'){
                        trim += stacky.pop(); 
                    }
                    stacky.pop();
                    for(int i = 0; i < veces; i++){
                        output += trim; 
                    }
                }  
            }
            if(!stacky.isEmpty()){
                output += stacky.pop();
            }
        } 
        return output;
    }
}

