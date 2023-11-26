package classes;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Окно");
        frame.setLocation(400,400);
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        JComboBox<String> box = new JComboBox<String>(CountryInformation.COUNTRIES);

        JCheckBox checkBox = new JCheckBox("Чек бокс");

        JTextField text = new JTextField();
        JTextArea area2 = new JTextArea();

        JTextArea area = new JTextArea();
        area.setText("Выберите страну");
        area.setEditable(false);
        area2.setEditable(false);

        BoxListener myListener = new BoxListener(box, area, checkBox);
        box.addActionListener(myListener);

        FlowLayout flow = new FlowLayout(FlowLayout.CENTER,0,0);
        GridLayout grid = new GridLayout(10,1,1,1);

        JPanel panel = new JPanel(flow);
        panel.add(area);
        Container container = frame.getContentPane();
        container.setLayout(grid);
        container.add(panel);
        container.add(checkBox);
        container.add(area2);
        container.add(text);
        container.add(box);

        checkBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ( checkBox.isSelected()){
                    String temp = area.getText();
                    area.setText(temp + " | Чек бокс");
                }
                else
                {
                    String temp = area.getText();
                    temp = temp.replace(" | Чек бокс", "");
                    area.setText(temp);
                }

            }

        });

        text.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                area2.setText(String.valueOf(e.getKeyChar()));
                super.keyPressed(e);
            }
        });
        frame.setVisible(true);


    }
}