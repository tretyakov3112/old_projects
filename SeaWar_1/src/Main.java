import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[][] myField;
        int myCount = 10;
        int[][] computerField;
        int computerCount = 10;
        Action action = new Action();
        Scanner scanner = new Scanner(System.in);


        myField = action.randomField();
        computerField = action.randomField();

        while (myCount !=0 && computerCount != 0){
            int n1 = scanner.nextInt();
            int n2 = scanner.nextInt();
            if (action.isCrushed(n1,n2,computerField)){
                System.out.println("You got it!");
                computerCount--;
            } else {
                System.out.println("You missed");
            }
            Random random = new Random();
            int k1 = random.nextInt(10);
            int k2 = random.nextInt(10);
            System.out.println(k1+", "+k2);
            if (action.isCrushed(k1,k2,myField)){
                System.out.println("You were crushed!");
                myCount--;
            } else {
                System.out.println("Enemy missed");
            }
        }
    }

}
