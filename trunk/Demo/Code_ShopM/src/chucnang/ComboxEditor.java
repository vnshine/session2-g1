package chucnang;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.table.*;
 

public class ComboxEditor extends DefaultCellEditor {
  protected JComboBox combox;
  private String    label;
  private boolean   isPushed;
  ResultSet rs;
  Statement st;
  Connection conn;
 
  
  public ComboxEditor(JCheckBox checkBox) {
    super(checkBox);
    combox = new JComboBox();   
    combox.setOpaque(true);
    combox.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        fireEditingStopped();
      }
    });
    
    try {

		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");



		conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=NhanVien","sa","123456");

		st = conn.createStatement();
		
		}

		
		catch (Exception ex) {

		System.out.println(ex.toString());

		}
     try {

    	 rs = st.executeQuery("select * from HosoNV");

    	 while (rs.next()) {
    		 
    		combox.addItem(rs.getString("Manv"));
    		combox.addItem(rs.getString("HoTen"));
    		combox.addItem(rs.getString("NgaySinh"));
    		
    	 }
    	 }

    	 catch (Exception ex) {

    	 System.out.println(ex.toString());

    	 }

    	 
    	 try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    
  }
 
  public Component getTableCellEditorComponent(JTable table, Object value,
                   boolean isSelected, int row, int column) {
    if (isSelected) {
    	combox.setForeground(table.getSelectionForeground());
    	combox.setBackground(table.getSelectionBackground());
    } else{
    	combox.setForeground(table.getForeground());
        combox.setBackground(table.getBackground());
    }
    label = (value ==null) ? "" : value.toString();
    combox.setToolTipText( label );
    isPushed = true;
    return combox;
  }
 
  public Object getCellEditorValue() {
    if (isPushed)  {
      // 
      // 
      //JOptionPane.showMessageDialog(combox ,label + ": Ouch!");
      // System.out.println(label + ": Ouch!");
    }
    isPushed = false;
    return new String( label ) ;
  }
   
  public boolean stopCellEditing() {
    isPushed = false;
    return super.stopCellEditing();
  }
 
  protected void fireEditingStopped() {
    super.fireEditingStopped();
  }
}  