import java.util.*;
/* Tests to see that circular array is working exactly as it should be 
 */

public class Tester {


    private static boolean expect(Deque20<Integer> d, String s) {
        try {
            String res = "[";
            Iterator<Integer> itr = d.iterator();
            if (itr.hasNext())
                res = res + itr.next();
            while (itr.hasNext())
                res = res + "," + itr.next();
            res = res + "]";
            return res.equals(s);
        }
        catch(Exception e) {
            return false;
        }
    }
    
    public static void main(String[] args) {
        boolean pass = true;
        Deque20<Integer> d = new Deque20<Integer>();
        pass = pass && expect(d,"[]");
        
        System.out.println(pass);
        
        for (int i=0; i<3; i++)
            d.addFirst(i);
        for (int i=3; i<6; i++)
            d.addLast(i);
        pass = pass && expect(d,"[2,1,0,3,4,5]");
        
        System.out.println(pass);
        
        pass = pass && (d.peekFirst() == 2);
        
        System.out.println(pass);
        
        pass = pass && (d.peekLast() == 5);
        
        System.out.println(pass);
        
        pass = pass && (d.isEmpty() == false);
        
        System.out.println(pass);
        
        pass = pass && (d.size() == 6);
        
        System.out.println(pass);
        
        for (int i=0; i<6; i++)
            d.removeLast();
        pass = pass && (d.isEmpty() == true);
        System.out.println(pass);
        
        pass = pass && (d.size() == 0);
        System.out.println(pass);
        
        pass = pass && expect(d,"[]");
        System.out.println(pass);
        
        for (int i=0; i<1000; i++)
            d.addFirst(i);
        pass = pass && (d.size() == 1000);  //FAILS
        System.out.println(pass);
        
        for (int i=0; i<1000; i++)
            pass = pass && (d.removeLast() == i);
        pass = pass && (d.isEmpty() == true);
        pass = pass && (d.size() == 0);
        pass = pass && expect(d,"[]");
        pass = pass && (d.peekFirst() == null);
        pass = pass && (d.peekLast() == null);
        try {
            d.removeFirst();
            pass = false;
        }
        catch(NoSuchElementException e) {
        
        }        
        catch(Exception e) {
            pass = false;
        }
        try {
            d.addFirst(null);
            pass = false;
        }
        catch(NullPointerException e) {
        
        }        
        catch(Exception e) {
            pass = false;
        }
        System.out.println(pass);
    }
    
}








