import java.util.ArrayList;
import java.util.Random;

public class Action {
    public ArrayList action(ArrayList array){
        Random random = new Random();
        int index = random.nextInt(array.size());
        int k = (int) array.get(index);
        if (k != 0){
            array.set(index, k-1);
        } else {
            for (int i = index; i < array.size() ; i++) {
                array.remove(index);
            }
        }
        return array;
    }


    public ArrayList stringToArray(String s) {
        ArrayList arr = new ArrayList();
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9')
            arr.add(Integer.parseInt(String.valueOf(s.charAt(i))));
        }
        return arr;
    }

}
