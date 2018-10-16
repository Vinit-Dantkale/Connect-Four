/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication11;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author Vinit
 */
public class JavaApplication11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame frame=new JFrame();
        frame.setSize(700, 600);
        
        JPanel panel=new JPanel();
        panel.setSize(200,200);
        panel.setBorder(BorderFactory.createLineBorder(Color.CYAN,6, true));
        
        ImageIcon img=new ImageIcon("C:\\Users\\Vinit\\Documents\\NetBeansProjects\\JavaApplication11\\src\\javaapplication11\\dragon.png");
        
        JLabel[] label=new JLabel[49];
        
        label[0]=new JLabel();
        label[0].setVisible(true);
        label[0].setPreferredSize(new Dimension(110,100));
        label[0].setBorder(BorderFactory.createLineBorder(Color.yellow,4, true));
        label[0].setIcon(img);
        
        panel.add(label[0]);
        frame.add(panel);
   
        //frame.pack();
        
        //frame.add(label[0]);
        frame.setVisible(true);
        
        
        
        
        
    }
    
}
/*JRadioButton radbut=new JRadioButton();
        radbut.setSize(100,100);
        radbut.setText("Helloo");
        radbut.setBorder(BorderFactory.createLineBorder(Color.yellow, 3, true));
        radbut.setVisible(true);*/