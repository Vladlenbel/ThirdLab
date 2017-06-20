package Controller;

import Model.DotList;
import View.MainJFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.*;
import java.util.List;


/**
 * Created by Vladlen on 20.06.2017.
 */
public class Control {
    private DotList dotList;
    private MainJFrame mainJFrame;
    public Control(){
        dotList = new DotList(this);
        mainJFrame = new MainJFrame(this);

    }
    public void addDotToList (Point point){
        dotList.addDot(point);
        mainJFrame.getGraphicView().getGraphic().repaint();
        JTable table = mainJFrame.getTableView().getTable();
        Vector<String> newRow = new Vector<>();
        newRow.add(String.valueOf(dotList.getDotList()));
        newRow.add(String.valueOf(point.getX()));
        newRow.add(String.valueOf(point.getY()));
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.addRow(newRow);
    }

    public List<Point> getDotList() {
        return dotList.getDotList();
    }
    public void newDList(int maxKVal, int stepK){
        dotList.makeDotList(maxKVal, stepK);
        JTable table = mainJFrame.getTableView().getTable();
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        int rowCount = tableModel.getRowCount();
        for (int rowIndex = rowCount - 1; rowIndex >= 0; rowIndex--) {
            tableModel.removeRow(rowIndex);
        }

    }
}
