public class SafeClient{


    public static void main(String[] args) {

        int[] lock = new int[]{1,2,3};

        Safe s = new Safe(lock);
        s.store("Hej");
        s.lock();

        s.insert(1);
        s.insert(3);
        s.insert(4);

        System.out.println(s.contents());

        s.insert(1);
        s.insert(2);
        s.insert(3);

        System.out.println(s.contents());



    }


}