
public class GameLogic {
   
    public int[][] disks=new int[6][7];
    
    GameLogic(){
        for(int i=0;i<42;i++){
               disks[i/7][i%7]=-1;
        }
    }
    
    public void checkgame(int row,int col){
        int ones=0,zeros=0;
        //Horizontal
        for(int i=0;i<7;i++){
            if(disks[row][i]==1){ones+=1;zeros=0;}
            if(disks[row][i]==0){zeros+=1;ones=0;}    
            checkwinner(ones,zeros);
        }
        
        ones=0;zeros=0;
        //Vertical
        for(int i=0;i<6;i++){
            if(disks[i][col]==1){ones+=1;zeros=0;}
            if(disks[i][col]==0){zeros+=1;ones=0;}
            checkwinner(ones,zeros);
        }
        
        ones=0;zeros=0;
        //Up left diagonal
        for(int i=2;i>=0;i--){
			int temp=0;
			ones=0;zeros=0;
			for(int j=i;j<6;j++){			
				if(disks[j][temp]==1){ones+=1;zeros=0;}
				if(disks[j][temp]==0){zeros+=1;ones=0;}      
				checkwinner(ones,zeros);
				temp+=1;
			}
			
			temp=0;
			ones=0;zeros=0;
			for(int j=i;j<6;j++){			
				if(disks[temp][j+1]==1){ones+=1;zeros=0;}
				if(disks[temp][j+1]==0){zeros+=1;ones=0;}      
				checkwinner(ones,zeros);
				temp+=1;
			}
			
		}
        
        
        
    }
    
    public void checkwinner(int ones,int zeros){
            if(ones==4){System.out.println("Player 2");}
            if(zeros==4){System.out.println("Player 1");}   
    }
    
}
