package module;
import java.awt.*;

public class GetScreenSize
{
	private Integer width;
	private Integer heigth;
	public Integer getWidth() {
		return width;
	}
	public void setWidth(Integer width) {
		this.width = width;
	}
	public Integer getHeigth() {
		return heigth;
	}
	public void setHeigth(Integer heigth) {
		this.heigth = heigth;
	}
	
	public GetScreenSize()
	{
		Toolkit toolkit =  Toolkit.getDefaultToolkit ();
		Dimension dim = toolkit.getScreenSize();
		this.setWidth(dim.width);
		this.setHeigth(dim.height);
	}
}