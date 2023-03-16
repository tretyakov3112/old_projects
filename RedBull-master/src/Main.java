import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> actionNumber = new ArrayList();
        Action action = new Action();
        Random random = new Random();
        int n = 1234;//random.nextInt(8999) + 1000;
        int k = 0;
        while (true) {
            play(n, k, actionNumber, action);
            if (action.scam(action.countNumber, actionNumber) == 0 || action.scam(action.countNumber, actionNumber) == n) {
                actionNumber.clear();
                System.out.println("You win!");
                return;
            } else {
                n = action.scam(action.countNumber, actionNumber);
            }
        }

    }

    private static void play(int n, int k, ArrayList<Integer> actionNumber, Action action)
    {
        Scanner scanner = new Scanner(System.in);
        while (n!=k) {

            k = scanner.nextInt();
            actionNumber.add(actionNumber.size(), k);
            System.out.println(action.action(n,k));
            System.out.println(actionNumber);
            System.out.println(action.countNumber);

        }

    }
}
