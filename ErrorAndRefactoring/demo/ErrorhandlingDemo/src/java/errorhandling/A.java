package errorhandling;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Thomas Hartmann - tha@cphbusiness.dk created on Nov 7, 2016 
 */
public class A {
    public static void main(String[] args) {
        try {
            //        try {
            a();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static void a() throws Exception{ b();}
    public static void b() throws Exception{ c();}
    public static void c() throws Exception{ throw new Exception();}
}
