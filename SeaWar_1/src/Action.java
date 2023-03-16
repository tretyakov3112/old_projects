import java.util.Random;

public class Action {
    public int[][] randomField(){
        int[][] field = new int[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                    field[i][j] = 0;
            }
            Random random = new Random();
            int k = random.nextInt(10);
            field[i][k] = 1;
        }
        return field;
    }

    public boolean isCrushed(int n1, int n2, int[][] field){
        if (field[n1][n2] == 1){
            return true;
        } else {
            return false;
        }
    }


}
