package UsingExcelTemplates;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

import myobject.DoiTac;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;

import process.QLDoiTacProcess;


public class WriteExcel {

	public void write(Integer hangBatDau,Integer cotBatDau,Vector<Vector<String>> duLieu,String linkTemplate) {
		
		JFileChooser fileChooser = new JFileChooser(".");
	    FileFilter filter1 = new ExtensionFileFilter("Excel file", new String[] { "XLS", "XLSX" });
	    fileChooser.setFileFilter(filter1);
	    int status = fileChooser.showSaveDialog(null);
	    if (status == JFileChooser.APPROVE_OPTION) {
	      File selectedFile = fileChooser.getSelectedFile();
//	      System.out.println(selectedFile.getParent());
//	      System.out.println(selectedFile.getName());
	    String path = selectedFile.getPath();
		System.out.println(path);
		POIFSFileSystem fs = null;
		try {
		fs = new POIFSFileSystem(new FileInputStream(linkTemplate));
		HSSFWorkbook wb;
		wb = new  HSSFWorkbook(fs);
		HSSFSheet sheet = wb.getSheetAt(0); 
		
		for (int i = 0; i < duLieu.size(); i++) {
			int a = hangBatDau +i;
			for (int j = 0; j < duLieu.get(i).size(); j++) {
				
				int b = cotBatDau +j;
				HSSFRow row = sheet.getRow(a);
			    Cell cell = row.getCell(b);
			    cell.setCellType(Cell.CELL_TYPE_STRING);
			    cell.setCellValue(duLieu.get(i).get(j).toString());
//			    System.out.println("Hang: " + a +" Cot: "+b +" Du lieu : "+duLieu.get(i).get(j).toString());
			}
		}
		sheet.autoSizeColumn((short)0); //adjust width of the first column  
		sheet.autoSizeColumn((short)1); //adjust width of the second column  
		sheet.autoSizeColumn((short)2);
		sheet.autoSizeColumn((short)3);
		sheet.autoSizeColumn((short)4);
		sheet.autoSizeColumn((short)5);
		sheet.autoSizeColumn((short)6);
		sheet.autoSizeColumn((short)7);
		//Sheet sheet1 = wb.createSheet("new sheet");
		FileOutputStream fileOut;
		fileOut = new FileOutputStream(path+".xls");
		wb.write(fileOut);
		fileOut.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 				
	    }
		else if (status == JFileChooser.CANCEL_OPTION) {
	      System.out.println(JFileChooser.CANCEL_OPTION);
	    }
	}

	

	public static void main(String[] args) {
		WriteExcel test = new WriteExcel();
		QLDoiTacProcess ql = new QLDoiTacProcess();
		Vector<Vector<String>> duLieu = new Vector<Vector<String>>();
		Vector<DoiTac> doiTac;
		try {
			doiTac = ql.getListDoiTac(1);
			for (int k = 0; k < doiTac.size(); k++) {
				Vector<String> phanTu = new Vector<String>();
				phanTu.add(doiTac.get(k).getsTenDoiTac());
				System.out.println(doiTac.get(k).getPK_sDoiTacID().toString());
				phanTu.add(doiTac.get(k).getPK_sDoiTacID().toString());
				phanTu.add(doiTac.get(k).getsSoDienThoai());
				phanTu.add(doiTac.get(k).getsDiaChi());
				phanTu.add(doiTac.get(k).getsNguoiLienHe());
				phanTu.add(doiTac.get(k).getsGhiChu());
				duLieu.add(phanTu);
			}
			test.write(8, 1, duLieu, "Temp.xls");
			System.out.println(doiTac.get(0).getClass().getCanonicalName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
}
