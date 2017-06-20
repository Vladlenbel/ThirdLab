package View;

import Controller.Control;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Vladlen on 20.06.2017.
 */
public class MainJFrame {

   private JButton butGenerate;
    private JButton butDrawinGr;
    private JTextField maxValue;
    private JTextField stepValuel;
    GraphicView graphicView;
    TableView tableView;
  //  JFrame mainFrame;

    public MainJFrame(Control control){
        JFrame mainFrame = new JFrame("Graphic");
        /*JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        mainFrame.add(panel);
        mainFrame.add(panel1);*/
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        graphicView = new GraphicView(control.getDotList());

        tableView = new TableView(control);
        mainFrame.add(graphicView,BorderLayout.EAST);
        mainFrame.add(tableView,BorderLayout.WEST);
       // mainFrame.add(graphicView);

        /*butGenerate = new JButton("Сгенерировать");
        butDrawinGr = new JButton("Построить");
        maxValue = new JTextField( 30);
        stepValuel = new JTextField(30);*/

/*        mainFrame.add(butGenerate, BorderLayout.WEST);
        mainFrame.add(butDrawinGr,BorderLayout.WEST);
        mainFrame.add(maxValue,BorderLayout.WEST);
        mainFrame.add(stepValuel,BorderLayout.WEST);*/

       // mainFrame.setPreferredSize(new Dimension(1300, 650));

        mainFrame.setResizable(false);
        mainFrame.pack();
        //mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);

    }
    public TableView getTableView(){
        return tableView;
    }
    public GraphicView getGraphicView() {
        return graphicView;
    }
}
