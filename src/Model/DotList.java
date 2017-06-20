package Model;

import Controller.Control;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by Vladlen on 20.06.2017.
 */
public class DotList {
    private List<Point> dotList;
    private Calculate calculate;
    Control controlier;

    public DotList(Control control){
        this.controlier = control;
        dotList = new ArrayList<>();
    }

    public void addDot(Point point) {
        dotList.add(point);
        //Collections.sort(pointList, new PointsComparatorXAxis());
    }
    public List<Point> getDotList() {
        return dotList;
    }

    public void makeDotList(int maxKVal, int stepK){
        dotList.clear();
        calculate = new Calculate(maxKVal, stepK, controlier, dotList);
        calculate.start();
    }

}
