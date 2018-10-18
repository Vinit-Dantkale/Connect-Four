
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class GameWindow {
    public static JFrame frame=new JFrame();
    public static JPanel mainpanel=new JPanel();
    public static JPanel players=new JPanel();
    public static JLabel player1=new JLabel();
    public static JLabel player2=new JLabel();
    public static JPanel secondpanel=new JPanel();
    public static JPanel firstpanel=new JPanel();
    public static JLabel[] smallp=new JLabel[42];
    public static JLabel[] emptyp=new JLabel[7];
    public static String dirpath=System.getProperty("user.dir").replace("\\","\\\\");
    public static ImageIcon empty;    
    public static ImageIcon red;  
    public static ImageIcon yellow;
    public static ImageIcon yellowdisk;
    public static ImageIcon reddisk;
    public static int turn=0;
    
    public static GameLogic gamelogic=new GameLogic();
    
    GameWindow(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        empty=getdirpath("\\\\empty.png");
        if(empty.getImageLoadStatus()==4){
            empty=getdirpath("\\\\connectfour\\\\src\\\\empty.png");
             red=getdirpath("\\\\connectfour\\\\src\\\\red.jpg");   
            yellow=getdirpath("\\\\connectfour\\\\src\\\\yellow.png");
            yellowdisk=getdirpath("\\\\connectfour\\\\src\\\\yellowdisk.png");
            reddisk=getdirpath("\\\\connectfour\\\\src\\\\reddisk.png");
        }
        else{
            red=getdirpath("\\\\red.jpg");   
            yellow=getdirpath("\\\\yellow.png");
            yellowdisk=getdirpath("\\\\yellowdisk.png");
            reddisk=getdirpath("\\\\reddisk.png");
        }
        frame.setSize(700,700);
        
        mainpanel.setBackground(Color.WHITE);
        
        EmptyBorder emptb=new EmptyBorder(2,100,30,100);
        mainpanel.setBorder(emptb);
        mainpanel.setVisible(true);
        
        players.setPreferredSize(new Dimension(500,25));
        players.setLayout(new BorderLayout());
        players.setOpaque(false);
        
        player1.setFont(new Font("Trebuchet MS",Font.BOLD,25));
        player1.setForeground(Color.red);
        player1.setVisible(true);
        
        player2.setFont(new Font("Trebuchet MS",Font.BOLD,25));
        player2.setForeground(Color.GREEN);
        player2.setVisible(true);
        
        players.add(player1,BorderLayout.WEST);
        players.add(player2,BorderLayout.EAST);
        players.setVisible(true);
        
        firstpanel.setLayout(new GridLayout(1,7));
        firstpanel.setBackground(Color.WHITE);
        
        //secondpanel.setPreferredSize(new Dimension(700,700));
        secondpanel.setLayout(new GridLayout(6,7));
    }
    
    public static void setWindow(){
        player1.setText("Player 1 : "+gamelogic.score[0]);
        player2.setText("Player 2 : "+gamelogic.score[1]);
        for(int i=0;i<7;i++){
            emptyp[i]=new JLabel();
            emptyp[i].setPreferredSize(new Dimension(80,80));
            firstpanel.add(emptyp[i]);
        }
        //turn=0;
        for(int i=0;i<42;i++){
            smallp[i]=new JLabel();
            smallp[i]=setLabelProperties(smallp[i],i);
            secondpanel.add(smallp[i]);
            GameLogic.disks[i/7][i%7]=-1;
        }
        
        secondpanel.setBorder(BorderFactory.createLineBorder(Color.BLUE,8,true));
        secondpanel.setVisible(true);
        
        mainpanel.add(players);
        mainpanel.add(firstpanel);
        mainpanel.add(secondpanel);
        frame.add(mainpanel);
       
        frame.setVisible(true); 
    }
    
    public static JLabel setLabelProperties(JLabel label,int i){
            label.setPreferredSize(new Dimension(80,80));
            label.setIcon(empty);
            label.setVisible(true);
            
            label.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int j=putdisk(i);
                    gamelogic.checkgame(j,i%7);                 
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    showdisk(i);
                }

                @Override
                public void mouseReleased(MouseEvent e) {}

                @Override
                public void mouseEntered(MouseEvent e) {
                    showdisk(i);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    removedisk(i);
                }
                
            });
        
        return label;
    }
    
    public static ImageIcon getdirpath(String str){
        ImageIcon img=new ImageIcon(dirpath+str);
        Image newimg=img.getImage().getScaledInstance(80,80,Image.SCALE_SMOOTH);
        img=new ImageIcon(newimg);
        return img;
    }
    
    public static void removedisk(int i){
       emptyp[i%7].setIcon(null);
    }
    
    public static void showdisk(int i){
        if(turn==0){
            emptyp[i%7].setIcon(reddisk);
        }
        else{
            emptyp[i%7].setIcon(yellowdisk);
        }
    }
    
    public static int putdisk(int i){
        ImageIcon disk;
        disk=(turn==0?red:yellow);
        int column=i%7;
        int j;
        for(j=5;j>=0;j--){
            if(GameLogic.disks[j][column]==-1){
                smallp[(7*j)+column].setIcon(disk);
                GameLogic.disks[j][column]=turn;
                turn=(turn==0?1:0);
                showdisk(i);
                break;
            }
        }
        
        return j;
    }
    
    public static void setscore(){
        player1.setText("Player 1: "+gamelogic.score[0]);
        player2.setText("Player 2: "+gamelogic.score[1]);
    }
    
    public static void reset(){
        firstpanel.removeAll();
        secondpanel.removeAll();
        mainpanel.removeAll();
        frame.remove(mainpanel);
        setWindow();
        frame.setVisible(true);
    }
    
}
