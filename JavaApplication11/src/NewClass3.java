
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class NewClass3 {
    public static JFrame frame=new JFrame();
    public static JPanel mainpanel=new JPanel();
    public static JPanel players=new JPanel();
    public static JLabel player1=new JLabel();
    public static JLabel player2=new JLabel();
    public static JPanel secondpanel=new JPanel();
    public static JLabel[] smallp=new JLabel[49];
    public static String dirpath=System.getProperty("user.dir").replace("\\","\\\\");
   public static ImageIcon empty=getdirpath("\\src\\empty.png");    
   public static ImageIcon red=getdirpath("\\src\\red.jpg");   
    public static ImageIcon yellow=getdirpath("\\src\\yellow.png");
        
    
    
    public static void main(String[] args) {
        
        frame.setSize(700,680);
        
        mainpanel.setBackground(Color.WHITE);
        
        EmptyBorder emptb=new EmptyBorder(2,100,30,100);
        mainpanel.setBorder(emptb);
        mainpanel.setVisible(true);
        
        players.setPreferredSize(new Dimension(500,25));
        players.setLayout(new BorderLayout());
        players.setOpaque(false);
        
        player1.setFont(new Font("Trebuchet MS",Font.BOLD,25));
        player1.setText("Player 1 : ");
        player1.setForeground(Color.red);
        player1.setVisible(true);
        
        player2.setFont(new Font("Trebuchet MS",Font.BOLD,25));
        player2.setText("Player 2 : ");
        player2.setForeground(Color.GREEN);
        player2.setVisible(true);
        
        players.add(player1,BorderLayout.WEST);
        players.add(player2,BorderLayout.EAST);
        players.setVisible(true);
        
        //secondpanel.setPreferredSize(new Dimension(700,700));
        secondpanel.setLayout(new GridLayout(7,7));
        
        
        for(int i=0;i<49;i++){
            smallp[i]=new JLabel();
            smallp[i]=setLabelProperties(smallp[i]);

            secondpanel.add(smallp[i]);
        }
        
        smallp[25].setIcon(red);
        smallp[30].setIcon(yellow);
        
        secondpanel.setBorder(BorderFactory.createLineBorder(Color.BLUE,8,true));
        secondpanel.setVisible(true);
        
        mainpanel.add(players);
        mainpanel.add(secondpanel);
        frame.add(mainpanel);
        
        
        frame.setVisible(true);
        
    }
    
    public static JLabel setLabelProperties(JLabel label){
            label.setPreferredSize(new Dimension(80,80));
            label.setIcon(empty);
            //label.setBorder(BorderFactory.createLineBorder(Color.BLUE,6, true));
            //label.setBorder(BorderFactory.createRaisedBevelBorder());
            label.setVisible(true);
        
        return label;
    }
    
    
    public static ImageIcon getdirpath(String str){
        ImageIcon img=new ImageIcon(dirpath+str);
        Image newimg=img.getImage().getScaledInstance(80,80,Image.SCALE_SMOOTH);
        img=new ImageIcon(newimg);
        return img;
    }
    
}
