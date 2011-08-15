/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package module;

import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author liemmaster
 */
public class ThongBao 
{
    public ThongBao(JLabel lblThongBao, Color color, String message)
    {
        lblThongBao.setForeground(color);
        lblThongBao.setText(message);
    }
}
