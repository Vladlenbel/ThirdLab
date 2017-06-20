package Model;

import Controller.Control;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by Vladlen on 20.06.2017.
 */
public class Calculate extends Thread {
    private Random random;
    private int maxKVal;
    private int stepK;

    private Control controller;

    public Calculate(int maxKVal,  int stepK, Control controller, List<Point> pointList) {
        random = new Random();
        this.controller = controller;
        this.maxKVal = maxKVal;
        this.stepK = stepK;

    }
    public void run() {
       // int koef = 0;
        int yKoef;
        int xKoef = 0;
        for (double  x = 0; x <= 50; x++) {
            double xd = x / 100;
            yKoef = calculationTwo(maxKVal, stepK, xd);
            Point point = new Point(xKoef, yKoef);
            controller.addDotToList(point);
           //System.out.println(yKoef);
            //System.out.println(xKoef);
            xKoef++;

        }
    }



    private int calculationTwo( int max, int step, double x){
        double answer = 0;
        String asd = "";
        double ysKoef;
        int yKoef;

        for ( int k = 0; k < max; k = k +step){
            answer +=  Math.pow(-1, k) * Math.pow(x, 2*k)/ factorial(k);
        }


        if (Double.toString(answer).length()>=6){
            asd = Double.toString(answer).substring(0,6);
        }
        if (Double.toString(answer).length()<6) {
            asd = Double.toString(answer);
            while (asd.length()<6) {
                asd += "0";
            }
        }
        ysKoef = Double.parseDouble(asd)*10000;
        yKoef = (int)ysKoef;
       // System.out.println(yKoef);

        //System.out.println(asd.length());

        return yKoef;
    }

    private static int factorial(int n)
    {
        if (n == 0) return 1;
        return n * factorial(n-1);
    }
}
