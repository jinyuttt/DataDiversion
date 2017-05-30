package DataControls;


import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StateLamp extends JPanel {
 private JLabel jlpic;
 private String pngSrc="";
 private String title="";
 private String name="";
 public StateLamp(String imgsrc,String title)
 {
     pngSrc=imgsrc;
     this.title=title;
     this.setLayout(new BorderLayout());
     jlpic=new JLabel();
     init1Frame();
     this.add(jlpic,BorderLayout.WEST);
 }
 public void setName(String name)
 {
     this.name=name;
 }
 public String getName()
 {
     return  name;
 }
    /**    
     * serialVersionUID:TODO����һ�仰�������������ʾʲô��    
     *    
     * @since Ver 1.1    
     */    
    
    private static final long serialVersionUID = 1L;
    public void init1Frame() {  
        ImageIcon icon = new ImageIcon(pngSrc);  
       icon.setImage(icon.getImage().getScaledInstance(40,    40, Image.SCALE_DEFAULT));  
       // System.out.println(icon.getIconHeight() + "" + icon.getIconWidth());  
        jlpic.setBounds(0, 0, 30, 30);  
       // jlpic.setHorizontalAlignment(0);
        jlpic.setVerticalAlignment(0);
        jlpic.setIcon(icon);  
        jlpic.setText(title);
        jlpic.setOpaque(false);
        jlpic.setVerticalTextPosition(JLabel.BOTTOM);
        jlpic.setHorizontalTextPosition(JLabel.CENTER);
    }  
}