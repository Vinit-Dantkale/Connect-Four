package connectfour;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class Connectfour {
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
    public static ImageIcon empty=getdirpath("\\src\\empty.png");    
    public static ImageIcon red=getdirpath("\\src\\red.jpg");   
    public static ImageIcon yellow=getdirpath("\\src\\yellow.png");
    public static ImageIcon yellowdisk=getdirpath("\\src\\yellowdisk.png");
    public static ImageIcon reddisk=getdirpath("\\src\\reddisk.png");
    public static int turn=0;
    public static int[][] disks=new int[6][7];
    
    public static void main(String[] args) {
        
        frame.setSize(700,700);
        
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
        
        firstpanel.setLayout(new GridLayout(1,7));
        firstpanel.setBackground(Color.WHITE);
        
        //secondpanel.setPreferredSize(new Dimension(700,700));
        secondpanel.setLayout(new GridLayout(6,7));
        
        for(int i=0;i<7;i++){
            emptyp[i]=new JLabel();
            emptyp[i].setPreferredSize(new Dimension(80,80));
            firstpanel.add(emptyp[i]);
        }
        
        for(int i=0;i<42;i++){
            smallp[i]=new JLabel();
            smallp[i]=setLabelProperties(smallp[i],i);
            secondpanel.add(smallp[i]);
            disks[i/7][i%7]=-1;
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
                    checkgame(j,i%7);
                    
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    showdisk(i);
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    //putdisk(i);
                    //turn=(turn==0?1:0);
                }

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
    
    public static void checkgame(int row,int col){
        int ones=0,zeros=0;
        for(int i=0;i<7;i++){
            if(disks[row][i]==1){ones+=1;}
            if(disks[row][i]==0){zeros+=1;}    
            if(ones==4){System.out.println("Player 2");break;}
            if(zeros==4){System.out.println("Player 1");break;}
        }
        
        ones=0;zeros=0;
        for(int i=0;i<6;i++){
            if(disks[i][col]==1){ones+=1;}
            if(disks[i][col]==0){zeros+=1;}      
            if(ones==4){System.out.println("Player 2");break;}
            if(zeros==4){System.out.println("Player 1");break;}
        }
        
        ones=0;zeros=0;
        
        
        
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
            if(disks[j][column]==-1){
                smallp[(7*j)+column].setIcon(disk);
                disks[j][column]=turn;
                turn=(turn==0?1:0);
                showdisk(i);
                break;
            }
        }
        
        return j;
    }
    
}

