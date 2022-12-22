import java.util.Formatter;
import java.util.Scanner;
import java.text.*;
import java.util.*;

class My_class
{
    public static void main(String[] args) {

        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        //Formatter fmrt =new Formatter();
        Formatter fmt = new Formatter ();
        Scanner first = new Scanner(System.in);
        System.out.print("Input a x = ");
        double x = first.nextDouble();
        System.out.print("Input a k = ");
        int k = first.nextInt();
        System.out.print("Input a a = ");
        double a = first.nextDouble();
        double res2, e;
        e = Math.pow(10, -k);
        res2 = Math.pow(a, x);
        if (a > 0 && k >= 1) {
            first.close();
            numberFormat.setMaximumFractionDigits(k+1);
            double result= Reshenie.Otvet(x, k, a);
            fmt.format ("%3$d, %1$d, %2$d ", 10, 20, 30 );
                System.out.println(fmt.format("e: |%3a|, res2: |%,012.3f|, With Taylor result: |%#.4f|, Hex k: |%#03x|, Octal k: |%#03o|, %+d", e, res2, result, k, k, k)); //not integer
            System.out.println("***************************************************");
            //System.out.println(fmt.format("Hex k: |%#03x|,  Octal k: |%#03o|, %+d",k ,k, k));

        } else {
            System.out.println("Error ");
        }
    }

    public static class Reshenie {
        public static double Otvet(double x, int k, double a) {
            double e, res = 1, numb = 1, sl = 1;
            e = Math.pow(10, -k);
            while (Math.abs(sl) >= e) {
                sl = sl * ((x * (Math.log(a))) / numb);
                numb = numb + 1;
                res = res + sl;
            }
            return res;
        }
    }

}