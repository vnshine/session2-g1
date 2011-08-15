/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package module;

import javax.swing.JFrame;

/**
 *
 * @author liemmaster
 */
public class SetCenter
{
    public SetCenter(Object obj)
    {
        GetScreenSize size = new GetScreenSize();
        JFrame temp = (JFrame) obj;
        temp.setBounds(size.getWidth()/2 - temp.getWidth()/2, size.getHeigth()/2 - temp.getHeight()/2, temp.getWidth(), temp.getHeight());
    }
}
