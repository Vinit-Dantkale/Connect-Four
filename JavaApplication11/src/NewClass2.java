
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class NewClass2 {
    
    public static void main(String[] args) {
        
        JFrame frame=new JFrame();
        frame.setSize(700,680);
        
        JPanel mainpanel=new JPanel();
        mainpanel.setBackground(Color.WHITE);
        
        EmptyBorder emptb=new EmptyBorder(2,100,30,100);
        mainpanel.setBorder(emptb);
        mainpanel.setVisible(true);
        
        JPanel players=new JPanel();
        players.setPreferredSize(new Dimension(500,25));
        players.setLayout(new BorderLayout());
        players.setOpaque(false);
        
        JLabel player1=new JLabel();
        player1.setFont(new Font("Trebuchet MS",Font.BOLD,25));
        player1.setText("Player 1 : ");
        player1.setForeground(Color.red);
        player1.setVisible(true);
        
        JLabel player2=new JLabel();
        player2.setFont(new Font("Trebuchet MS",Font.BOLD,25));
        player2.setText("Player 2 : ");
        player2.setForeground(Color.GREEN);
        player2.setVisible(true);
        
        players.add(player1,BorderLayout.WEST);
        players.add(player2,BorderLayout.EAST);
        players.setVisible(true);
        
        ImageIcon img=new ImageIcon("C:\\Users\\Vinit\\Downloads\\temp4.png");
        Image newimg=img.getImage().getScaledInstance(80,80,Image.SCALE_SMOOTH);
        img=new ImageIcon(newimg);
        
        ImageIcon img1=new ImageIcon("C:\\Users\\Vinit\\Downloads\\temp2.jpg");
        Image newimg1=img1.getImage().getScaledInstance(80,80,Image.SCALE_SMOOTH);
        img1=new ImageIcon(newimg1);
        
        ImageIcon img2=new ImageIcon("C:\\Users\\Vinit\\Downloads\\temp5.png");
        Image newimg2=img2.getImage().getScaledInstance(80,80,Image.SCALE_SMOOTH);
        img2=new ImageIcon(newimg2);
        
        JPanel secondpanel=new JPanel();
        //secondpanel.setPreferredSize(new Dimension(700,700));
        secondpanel.setLayout(new GridLayout(7,7));
        
        JLabel[] smallp=new JLabel[49];
        for(int i=0;i<49;i++){
            smallp[i]=new JLabel();
            smallp[i].setPreferredSize(new Dimension(80,80));
            smallp[i].setIcon(img);
            //smallp[i].setBorder(BorderFactory.createLineBorder(Color.BLUE,6, true));
            //smallp[i].setBorder(BorderFactory.createRaisedBevelBorder());
            smallp[i].setVisible(true);
            secondpanel.add(smallp[i]);
        }
        
        smallp[25].setIcon(img1);
        smallp[30].setIcon(img2);
        
        secondpanel.setBorder(BorderFactory.createLineBorder(Color.BLUE,8,true));
        secondpanel.setBackground(Color.CYAN);
        secondpanel.setVisible(true);
        
        mainpanel.add(players);
        mainpanel.add(secondpanel);
        frame.add(mainpanel);
        
        
        frame.setVisible(true);
        
    }
    
    
}
