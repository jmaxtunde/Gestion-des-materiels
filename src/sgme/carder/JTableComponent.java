/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sgme.carder;

import java.awt.Component;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Senghor AKOMINON
 */
public class JTableComponent extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table,
    Object value, boolean isSelected, boolean hasFocus, int row, int
     column) {
    //Si la valeur de la cellule est un JButton, on transtype cette valeur
    if (value instanceof JComponent)
         return (JComponent) value;
    else
      return this;
}
}
