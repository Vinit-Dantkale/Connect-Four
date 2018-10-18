
public class GameLogic {
    public int score[]=new int[2];
    public static int[][] disks=new int[6][7];
    
    GameLogic(){
        score[0]=0;
        score[1]=0;
    }
    
    public void checkgame(int row,int col){
        int ones=0,zeros=0;
        //Horizontal
        for(int i=0;i<7;i++){
            if(disks[row][i]==1){ones+=1;zeros=0;}
            if(disks[row][i]==0){zeros+=1;ones=0;}    
            if(checkwinner(ones,zeros)){break;}
        }
        
        ones=0;zeros=0;
        //Vertical
        for(int i=0;i<6;i++){
            if(disks[i][col]==1){ones+=1;zeros=0;}
            if(disks[i][col]==0){zeros+=1;ones=0;}
            if(checkwinner(ones,zeros)){break;}
        }
        
        //Diagonal 1
        for(int i=2;i>=0;i--){
			int temp=0;
			ones=0;zeros=0;
			for(int j=i;j<6;j++){			
				if(disks[j][temp]==1){ones+=1;zeros=0;}
				if(disks[j][temp]==0){zeros+=1;ones=0;}      
				if(checkwinner(ones,zeros)){break;}
				temp+=1;
			}
			
			temp=0;
			ones=0;zeros=0;
			for(int j=i;j<6;j++){			
				if(disks[temp][j+1]==1){ones+=1;zeros=0;}
				if(disks[temp][j+1]==0){zeros+=1;ones=0;}      
				if(checkwinner(ones,zeros)){break;}
				temp+=1;
			}
			
		}
        
        //Diagonal 2
        for(int i=3;i<6;i++){
                        int temp=0;
                        ones=0;zeros=0;
			for(int j=i;j>=0;j--){			
			     //System.out.print("["+j+","+temp+"]");
                             if(disks[j][temp]==1){ones+=1;zeros=0;}
                             if(disks[j][temp]==0){zeros+=1;ones=0;}      
                             if(checkwinner(ones,zeros)){break;}
                             temp+=1;
                        }
			
                        temp=5;
                        ones=0;zeros=0;
			for(int j=i;j>=0;j--){			
			     //System.out.print("["+temp+","+(6-j)+"]");
                             if(disks[temp][6-j]==1){ones+=1;zeros=0;}
                             if(disks[temp][6-j]==0){zeros+=1;ones=0;}      
                             if(checkwinner(ones,zeros)){break;}
                             temp-=1;
                        }
                          
            }
    
        
        
    }
    
    public boolean checkwinner(int ones,int zeros){
        
            if(ones==4){
                score[1]+=1;
                GameWindow.setscore();
                GameWindow.reset();
                return true;
            }
            if(zeros==4){
                score[0]+=1;
                GameWindow.setscore();
                GameWindow.reset();
                return true;
            }   
            return false;
    }
    
}
