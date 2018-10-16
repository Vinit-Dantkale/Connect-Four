
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;


public class NewClass1 {
    
    public static void main(String[] args) {
        
        JFrame frame=new JFrame();
        frame.setSize(700,600);
        
        JPanel panel=new JPanel();
        
        EmptyBorder emptb=new EmptyBorder(50,80,80,80);
        panel.setBorder(emptb);
        panel.setVisible(true);
        
        
        JPanel[] smallp=new JPanel[50];
        for(int i=0;i<50;i++){
        smallp[i]=new JPanel();
        smallp[i].setBorder(BorderFactory.createLineBorder(Color.yellow, 3, true));
        smallp[i].setVisible(true);
        
        panel.add(smallp[i]);
        }
        
        
        frame.add(panel);
        
        
        frame.setVisible(true);
        
    }
    
    
}
