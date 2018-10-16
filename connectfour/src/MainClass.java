/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vinit
 */
public class MainClass {
    
    public static void main(String[] args) {
        GameWindow gamewindow=new GameWindow();
        GameWindow.setWindow();
        
        for(int i=3;i<6;i++){
                        int temp=0;
			for(int j=i;j>=0;j--){			
			     System.out.print("["+j+","+temp+"]");
                             temp+=1;
                        }
			         System.out.println("");
			
                        temp=0;
			for(int j=i;j>=0;j--){			
			     System.out.print("["+temp+","+temp+"]");
                             temp+=1;
                        }
			         System.out.println("");
		}
        
    }
    
    
}
