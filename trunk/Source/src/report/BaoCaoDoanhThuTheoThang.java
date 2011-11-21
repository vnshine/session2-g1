package report;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.*;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.*;

import connect.*;
import module.*;

public class BaoCaoDoanhThuTheoThang extends JFrame
{
	public BaoCaoDoanhThuTheoThang(String fileName)
	{
		this(fileName,null);
	}
	
	public BaoCaoDoanhThuTheoThang(String fileName,HashMap parameter)
	{
		super("Báo cáo doanh thu theo tháng");
		try
		{
			Connection con = ioconnection.getConnection();
			JasperPrint print = JasperFillManager.fillReport(fileName, parameter, con);
			
			JRViewer viewer=new JRViewer(print);
			
			Container c=getContentPane();
			c.add(viewer);
		}
		catch(JRException jre)
		{
			jre.printStackTrace();
		}
		GetScreenSize size = new GetScreenSize();
		setBounds(0,0,size.getWidth(),size.getHeigth());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public static void main(String args[])
	{
		/* A sample calling */
		//HashMap param=new HashMap();
		//param.put("reportParameterName",valueForTheParameter);
		BaoCaoDoanhThuTheoThang viewer=new BaoCaoDoanhThuTheoThang("report/rptDoanhThu.jasper",null);
		viewer.setVisible(true);
		new SetCenter(viewer);
	}
}