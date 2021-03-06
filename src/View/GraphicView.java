package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.*;

/**
 * Created by Vladlen on 20.06.2017.
 */
public class GraphicView extends JPanel {
    private Graphic graphic;
    private JLabel scaleTextLabel;

    // private JSlider slider;
    // private JProgressBar progressBar;
    GraphicView(java.util.List<Point> pointList ) {
        super();
        this.setLayout(new BorderLayout());
        // JToolBar toolBar = new JToolBar(JToolBar.HORIZONTAL);
        // progressBar = new JProgressBar(JProgressBar.HORIZONTAL);
       /* slider = new JSlider(JSlider.HORIZONTAL, 50, 150, 100);
        slider.setMajorTickSpacing(25);
        slider.setMinorTickSpacing(5);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.setSnapToTicks(true);*/

        graphic = new Graphic(pointList);
        // scaleTextLabel = new JLabel(chartDrawPanel.getZoom()*100+"%");

     /*  toolBar.setFloatable(false);
        toolBar.setLayout(new FlowLayout());
*/

        JScrollPane scrollPanel = new JScrollPane(graphic);

        scrollPanel.setAutoscrolls(true);
        MouseAdapter mouseAdapter = new MouseAdapter() {
            private Point origin;

            @Override
            public void mousePressed(MouseEvent e) {
                origin = e.getPoint();
            }


            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                if (origin != null) {
                    JViewport viewPort = (JViewport) SwingUtilities.getAncestorOfClass(JViewport.class, graphic);
                    if (viewPort != null) {
                        int deltaX = origin.x - e.getX();
                        int deltaY = origin.y - e.getY();

                        Rectangle view = viewPort.getViewRect();
                        view.x += deltaX * 0.3;
                        view.y += deltaY * 0.2;
                        graphic.scrollRectToVisible(view);
                    }
                }
            }
        };
        graphic.addMouseListener(mouseAdapter);
        graphic.addMouseMotionListener(mouseAdapter);
        scrollPanel.setPreferredSize(new Dimension(800, 650));
        scrollPanel.setVisible(true);
        /*progressBar.setString("Начните вычисления");
        progressBar.setStringPainted(true);*/

        // toolBar.add(slider);
        // toolBar.add(progressBar /*FlowLayout.RIGHT*/);
       this.add(scrollPanel, BorderLayout.WEST);
        //  this.add(toolBar, BorderLayout.SOUTH);
        this.setVisible(true);
        // slider.addChangeListener(new SliderListener(this));
        scrollPanel.addMouseWheelListener(new MouseWheelListener() {
            public void mouseWheelMoved(MouseWheelEvent e) {
                if (e.isControlDown()) {
                    if (e.getWheelRotation() < 0) {
                        graphic.setZoom(graphic.getZoom() + 0.1);

                    } else {
                        graphic.setZoom(graphic.getZoom() - 0.1);
                    }
                    // slider.setValue((int)(chartDrawPanel.getZoom()*100));
                    graphic.revalidate();
                }
            }
        });
    }

    void revalidatePanel() {
        //scaleTextLabel.setText(Math.round(graphic.getZoom() * 100) + "%");
        graphic.revalidate();
    }
    public Graphic getGraphic() {
        return graphic;
    }
}

