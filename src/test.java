import java.util.Vector;

public class test {
    public static void main(String[] args){
        Vector<Integer> test = new Vector<Integer>();
        System.out.println(test);
        test.add(1);
        test.add(2);
        test.add(3);
        test.remove(1);
        System.out.println(test);
        System.out.println(test.get(1));
    }
}
