package module;

import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JFrame;
import ch.rakudave.suggest.JSuggestField;
import connect.ioconnection;

public class AutoCompleteSearch extends JFrame {
	private JFrame frame;
	private JSuggestField s;
	public AutoCompleteSearch() 
        {
		Vector<String> a = Autocomplete();
		frame = new JFrame();
		s = new JSuggestField(frame, a);
		s.setPreferredSize(new Dimension(50,20));
		s.setPreferredSuggestSize(new Dimension(50,300));
		
		frame.add(s);
		
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
		
		public static Vector<String> Autocomplete()
                {
			Vector<String> hangs = new Vector<String>();
			Connection con = ioconnection.getConnection();
			try {
				PreparedStatement cst = con.prepareStatement("SELECT * from tbl_doitac");
				ResultSet rs = cst.executeQuery();
				while(rs.next()){
//					popup.add(rs.getString(1));
					
					System.out.println(rs.getString(1));
					hangs.add(rs.getString(1));
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			return hangs;
		}
		public static void main (String[] args){
			new AutoCompleteSearch();
			
		}
	}



	



