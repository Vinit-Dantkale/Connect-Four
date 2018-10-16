/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class NewClass {
    
    public static JFrame frame=new JFrame();
    public static JPanel[] panel=new JPanel[9];
    public static JPanel mainpanel=new JPanel();
    
    public static void main(String[] args) {
        // TODO code application logic here

        frame.setSize(700, 600);
        
        for(int i=0;i<9;i++){
            panel[i]=new JPanel();
        }
        
        panel[4].setSize(200,200);
        panel[4].setBorder(BorderFactory.createLineBorder(Color.CYAN,6, true));
        
        ImageIcon img=new ImageIcon("C:\\Users\\Vinit\\Downloads\\images.jpeg");
        
        JLabel[] label=new JLabel[49];
        
        label[0]=new JLabel();
        label[0].setVisible(true);
        label[0].setPreferredSize(new Dimension(240,230));
        label[0].setBorder(BorderFactory.createLineBorder(Color.yellow,4, true));
        label[0].setIcon(img);
        
        panel[4].add(label[0]);
        frame.add(panel[4]);
   
        //frame.pack();
        
        //frame.add(label[0]);
        frame.setVisible(true);
        int ones=0,zeros=0;
        int temp=4;
        while(temp<7){
            for(int i=0;i<temp;i++){
                System.out.print("["+i+","+i+"]");
                //if(disks[i][i]==1){ones+=1;}
               //if(disks[i][i]==0){zeros+=1;}   
            }
            System.out.println("");
            for(int i=0;i<temp;i++){
                System.out.print("["+i+","+(i+1)+"]");
            }
            System.out.println("");
            if(ones==4){System.out.println("Player 2");break;}
            if(zeros==4){System.out.println("Player 1");break;}
            temp+=1;
        }
        
        
        
    }
    
    
}
