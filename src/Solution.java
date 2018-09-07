import java.util.Scanner;

public class Solution {
    public static void main(String[] args)throws CloneNotSupportedException {
        ComplexNumberImpl a = new ComplexNumberImpl(-3.0,-1.0);
        ComplexNumberImpl b = new ComplexNumberImpl(5.0,1.0);
        ComplexNumberImpl c = new ComplexNumberImpl(2.0,1.0);
        b.multiply(a);
        System.out.println(c);
        System.out.println(b);
    }
}
