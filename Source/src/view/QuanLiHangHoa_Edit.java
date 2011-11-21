package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import sun.java2d.ScreenUpdateManager;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QuanLiHangHoa_Edit extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private QuanLiNhapXuat QLNhapXuat;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			QuanLiHangHoa_Edit dialog = new QuanLiHangHoa_Edit();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void closeDialog(){
		this.setVisible(false);
	}
	/**
	 * Create the dialog.
	 * @throws Exception 
	 */
	public QuanLiHangHoa_Edit() throws Exception {
		setTitle("Thêm hàng vào danh sách Nhập/Xuất");
		setIconImage(Toolkit.getDefaultToolkit().getImage("media/images/add.png"));
		this.setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		
		JLabel lblTnMtHng = new JLabel("Tên mặt hàng:");
		GridBagConstraints gbc_lblTnMtHng = new GridBagConstraints();
		gbc_lblTnMtHng.insets = new Insets(0, 0, 5, 5);
		gbc_lblTnMtHng.anchor = GridBagConstraints.EAST;
		gbc_lblTnMtHng.gridx = 0;
		gbc_lblTnMtHng.gridy = 0;
		contentPanel.add(lblTnMtHng, gbc_lblTnMtHng);
		
		JComboBox comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		contentPanel.add(comboBox, gbc_comboBox);
		
		JLabel lblSLng = new JLabel("Số lượng: ");
		GridBagConstraints gbc_lblSLng = new GridBagConstraints();
		gbc_lblSLng.anchor = GridBagConstraints.EAST;
		gbc_lblSLng.insets = new Insets(0, 0, 5, 5);
		gbc_lblSLng.gridx = 0;
		gbc_lblSLng.gridy = 1;
		contentPanel.add(lblSLng, gbc_lblSLng);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		contentPanel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblnGi = new JLabel("Đơn giá: ");
		GridBagConstraints gbc_lblnGi = new GridBagConstraints();
		gbc_lblnGi.anchor = GridBagConstraints.EAST;
		gbc_lblnGi.insets = new Insets(0, 0, 5, 5);
		gbc_lblnGi.gridx = 0;
		gbc_lblnGi.gridy = 2;
		contentPanel.add(lblnGi, gbc_lblnGi);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Giá bán lẻ", "Giá bán buôn", "Giá mua"}));
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 1;
		gbc_comboBox_1.gridy = 2;
		contentPanel.add(comboBox_1, gbc_comboBox_1);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 2;
		contentPanel.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblTngTin = new JLabel("Tổng tiền:");
		GridBagConstraints gbc_lblTngTin = new GridBagConstraints();
		gbc_lblTngTin.anchor = GridBagConstraints.EAST;
		gbc_lblTngTin.insets = new Insets(0, 0, 5, 5);
		gbc_lblTngTin.gridx = 0;
		gbc_lblTngTin.gridy = 3;
		contentPanel.add(lblTngTin, gbc_lblTngTin);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.gridwidth = 2;
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 3;
		contentPanel.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JButton btnng = new JButton("Đồng ý");
		btnng.setIcon(new ImageIcon("media/images/apply.png"));
		GridBagConstraints gbc_btnng = new GridBagConstraints();
		gbc_btnng.insets = new Insets(0, 0, 0, 5);
		gbc_btnng.gridx = 0;
		gbc_btnng.gridy = 4;
		contentPanel.add(btnng, gbc_btnng);
		
		JButton btnBQua = new JButton("Bỏ qua");
		btnBQua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				closeDialog();
			}
		});
		btnBQua.setIcon(new ImageIcon("media/images/Cancel2.png"));
		GridBagConstraints gbc_btnBQua = new GridBagConstraints();
		gbc_btnBQua.anchor = GridBagConstraints.WEST;
		gbc_btnBQua.insets = new Insets(0, 0, 0, 5);
		gbc_btnBQua.gridx = 1;
		gbc_btnBQua.gridy = 4;
		contentPanel.add(btnBQua, gbc_btnBQua);
	}

}
