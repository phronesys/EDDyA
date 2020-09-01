public class test {
    public static void main(String[] args) {
        int a = 1;
        for(int i = 0; i < 10; i++){
            if((a--) > 0){
                System.out.println(a);
            }
        }
        System.out.println(a);
    }
}