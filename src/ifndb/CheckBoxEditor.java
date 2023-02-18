/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifndb;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 *
 * @author Davide
 */
public class CheckBoxEditor extends DefaultCellEditor {
    public CheckBoxEditor() {
        super(new JCheckBox());
    }

    @Override
    public Object getCellEditorValue() {
        return ((JCheckBox) editorComponent).isSelected();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        JCheckBox checkBox = (JCheckBox) editorComponent;
        checkBox.setSelected((Boolean) value);
        return checkBox;
    }
}
