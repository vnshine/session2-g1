package chucnang;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
 

public class ComboxRenderer extends JComboBox implements TableCellRenderer {
 
  public ComboxRenderer() {
    setOpaque(true);
  }
  
  public Component getTableCellRendererComponent(JTable table, Object value,
                   boolean isSelected, boolean hasFocus, int row, int column) {
    if (isSelected) {
      setForeground(table.getSelectionForeground());
      setBackground(table.getSelectionBackground());
    } else{
      setForeground(table.getForeground());
      setBackground(UIManager.getColor("Combobox.background"));
    }
    setToolTipText( (value ==null) ? "" : value.toString() );
    return this;
  }
  
}  
