package View;

import Controller.Control;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

/**
 * Created by Vladlen on 20.06.2017.
 */
public class TableView extends JPanel {
    private JTable table;
    private JButton butGenerate;
    JButton butDrawinGr;
    JTextField maxValue;
    JTextField stepValuel;
    JLabel maxKValue;
    JLabel stepK;
    private GraphicView graphicView;

    public TableView (final Control control){

        this.setPreferredSize(new Dimension(400,300));
        this.setLayout(new FlowLayout());
        Vector<String> headerVect = new Vector<>();
        headerVect.add("X");
        headerVect.add("F(x)");

        DefaultTableModel mod = new DefaultTableModel(headerVect, 0);
        table =new JTable(mod);
        table.setEnabled(false);

        JScrollPane jScrollPane = new JScrollPane(table);
        jScrollPane.setPreferredSize(new Dimension(350, 480));
       // butGenerate = new JButton("Сгенерировать");
        butDrawinGr = new JButton("Построить");
        maxValue = new JTextField( 30);
        stepValuel = new JTextField(30);
        maxKValue = new JLabel("Максимальное значение К");
        stepK = new JLabel("Шаг изменения К");


        this.add(jScrollPane);


        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(maxKValue);
        this.add(maxValue);
        this.add(stepK);
        this.add(stepValuel);
       // panel.add(butGenerate,BorderLayout.SOUTH);
        this.add(butDrawinGr);
       // graphicView = new GraphicView(dotList);


        butDrawinGr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int maxNumber = Integer.valueOf(maxValue.getText());
                int step = Integer.valueOf(stepValuel.getText());
                control.newDList(maxNumber, step);
            }
        });

    }
    public JTable getTable() {
        return table;
    }

}
