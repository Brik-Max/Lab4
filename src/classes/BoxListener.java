package classes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoxListener implements ActionListener {

    private JComboBox<String> box;
    private JCheckBox comboBox;
    private JTextArea area;

    public BoxListener(JComboBox<String> box, JTextArea area, JCheckBox comboBox){
        this.box = box;
        this.area = area;
        this.comboBox = comboBox;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int index = box.getSelectedIndex();
        if (comboBox.isSelected()){
            area.setText(CountryInformation.IFORMATION[index] + " | Чек бокс");
            return;
        }
        area.setText(CountryInformation.IFORMATION[index]);
    }
}
