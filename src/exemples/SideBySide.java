package exemples;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
// Removed invalid import

public class SideBySide extends JFrame {

    public static void main(String[] args) {
        new SideBySide();
    }

    public SideBySide() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 150);
        this.setLayout(new GridLayout(1, 2));
        this.setVisible(true);

        JPanel container = new JPanel();
        JPanel panelOne = new JPanel();
        JPanel panelTwo = new JPanel();
        JPanel panelThree = new JPanel();
        JPanel panelFour = new JPanel();

        panelOne.add(new JLabel("1"));
        panelTwo.add(new JLabel("2"));
        panelThree.add(new JLabel("3"));
        panelFour.add(new JLabel("4"));

        container.setLayout(new GridLayout(1, 3));
        container.add(panelOne);
        container.add(panelTwo);
        container.add(panelThree);
        container.add(panelFour);

        this.add(container);
    }

}