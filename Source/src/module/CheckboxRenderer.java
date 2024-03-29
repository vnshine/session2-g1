package module;

import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author an156382
 */
public class CheckboxRenderer extends  DefaultTableCellRenderer {

    private JCheckBox comp;
    private Object obj;

    /** Creates a new instance of CheckBoxRenderer */
    public CheckboxRenderer(JCheckBox comp) {
        this.comp = comp;
    }

    /**
         * Method returning the modified component (component + rendering)
         * @param table the table in which the component is contained
         * @param value the value of the component
         * @param isSelected true if the component is selected
         * @param hasFocus true if the component has the focus
         * @param row the row of the component in the table
         * @param column the column of the component in the table
         * @return Component the modified component
         */
	public Component getTableCellRendererComponent(JTable table,
						       Object value,
						       boolean isSelected,
						       boolean hasFocus,
						       int row,
						       int column) {
            //obj = table.getModel().getValueAt(row,column);
            //comp.setSelectedItem(obj);
            comp.setHorizontalAlignment(SwingConstants.CENTER);
            comp.setSelected(((Boolean)table.getModel().getValueAt(row,column)));
	    return comp;
	}

        /**
         * Returns simply the component
         * @return Component the component
         */
	public Component getComponent() {
	    return comp;
	}
    
}