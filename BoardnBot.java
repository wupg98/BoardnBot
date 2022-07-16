/* This is the only class which is not dependant on any other classes in the Reversi/Othello game*/

import java.util.*;
import javax.swing.JOptionPane;

//Board Klasse
class Board{
	int grid[][];
	Board(){
		grid=new int[8][8];
		grid[3][3]=1;  //w=1
		grid[4][4]=1;  //w=1
		grid[3][4]=-1; //b=-1
		grid[4][3]=-1; //b=-1
	}

	Board(Board b){
		int i=0,j=0;
		grid=new int[8][8];
		for(i=0;i<8;i++)
		{
			for(j=0;j<8;j++)
				grid[i][j]=b.grid[i][j];
				
		}
	}


//Methode:
//Eine arraylist von einer nicht statischen Funktion in Java zurückgeben
//https://www.delftstack.com/de/howto/java/return-arraylist-java/#eine-arraylist-von-einer-nicht-statischen-funktion-in-java-zur%25C3%25BCckgeben
	ArrayList<Integer> findPossibleMoves(int color){
		ArrayList<Integer> ans=new ArrayList<>();
		int i=0,j=0,k=0,l=0,val=0;
		for(i=0;i<8;i++){
			for(j=0;j<8;j++){
				if(grid[i][j]!=0)
					continue;
				//Continue keyword can be used in any of the loop control structures.
				//It causes the loop to immediately jump to the next interation
				//in for loop ->immediately jump to the update statement
				//in while loop control immediately jumps to the Boolean expresion
				if(j>0&&grid[i][j-1]==-color){
					k=j-2;
					while(k>=0&&grid[i][k]==-color)
						k--;
					if(k>=0&&grid[i][k]!=0){
						ans.add(i*8+j);
						continue;
					}
				}
				if(j<7&&grid[i][j+1]==-color){
					k=j+2;
					while(k<=7&&grid[i][k]==-color)
						k++;
					if(k<=7&&grid[i][k]!=0){
						ans.add(i*8+j);
						continue;
					}
				}
				if(i>0&&grid[i-1][j]==-color){
					k=i-2;
					while(k>=0&&grid[k][j]==-color)
						k--;
					if(k>=0&&grid[k][j]!=0)
					{
						ans.add(i*8+j);
						continue;
					}
				}
				if(i<7&&grid[i+1][j]==-color)
				{
					k=i+2;
					while(k<=7&&grid[k][j]==-color)
						k++;
					if(k<=7&&grid[k][j]!=0)
					{
						ans.add(i*8+j);
						continue;
					}
				}
				if(j<7&&i<7&&grid[i+1][j+1]==-color)
				{
					k=i+2;
					l=j+2;
					while(k<=7&&l<=7&&grid[k][l]==-color){
						k++;
						l++;
					}
					if(k<=7&&l<=7&&grid[k][l]!=0){
						ans.add(i*8+j);
						continue;
					}
				}
				if(j>0&&i>0&&grid[i-1][j-1]==-color){
					k=i-2;
					l=j-2;
					while(k>=0&&l>=0&&grid[k][l]==-color){
						k--;
						l--;
					}
					if(k>=0&&l>=0&&grid[k][l]!=0){
						ans.add(i*8+j);
						continue;
					}
				}
				if(j<7&&i>0&&grid[i-1][j+1]==-color){
					k=i-2;
					l=j+2;
					while(k>=0&&l<=7&&grid[k][l]==-color){
						k--;
						l++;
					}
					if(k>=0&&l<=7&&grid[k][l]!=0){
						ans.add(i*8+j);
						continue;
					}
				}
				if(j>0&&i<7&&grid[i+1][j-1]==-color){
					k=i+2;
					l=j-2;
					while(k<=7&&l>=0&&grid[k][l]==-color){
						k++;
						l--;
					}
					if(k<=7&&l>=0&&grid[k][l]!=0){
						ans.add(i*8+j);
						continue;
					}
				}
			}
		}
		return ans;
	}
	//

//Methode:
	 void move(int color,int x,int y)throws Exception{
		if(x<0||x>7||y<0||y>7)
			throw new Exception("Out of bounds");
		if(grid[x][y]!=0)
			throw new Exception("Already a piece there");
		boolean flag=false; //Flag prüft ob der Zug legal ist
		int i=0,j=0;
		if(x>0&&grid[x-1][y]==-color){
			i=x-1;
			while(i>=0&&grid[i][y]==-color)
				i--;
			if(i>=0&&grid[i][y]!=0){
				flag=true;
				int ii=x-1;
				while(ii>i)
					grid[ii--][y]=color;
			}
		}
		if(x<7&&grid[x+1][y]==-color){
			i=x+1;
			while(i<=7&&grid[i][y]==-color)
				i++;
			if(i<=7&&grid[i][y]!=0){
				flag=true;
				int ii=x+1;
				while(ii<i)
					grid[ii++][y]=color;
			}
		}
		if(y>0&&grid[x][y-1]==-color){
			j=y-1;
			while(j>=0&&grid[x][j]==-color)
				j--;
			if(j>=0&&grid[x][j]!=0){
				flag=true;
				int jj=y-1;
				while(jj>j)
					grid[x][jj--]=color;
			}
		}
		if(y<7&&grid[x][y+1]==-color){
			j=y+1;
			while(j<=7&&grid[x][j]==-color)
				j++;
			if(j<=7&&grid[x][j]!=0){
				flag=true;
				int jj=y+1;
				while(jj<j)
					grid[x][jj++]=color;
			}
		}
		if(x<7&&y<7&&grid[x+1][y+1]==-color){
			i=x+1;
			j=y+1;
			while(i<=7&&j<=7&&grid[i][j]==-color){
				i++;
				j++;
			}
			if(i<=7&&j<=7&&grid[i][j]!=0){
				flag=true;
				int ii=x+1,jj=y+1;
				while(ii<i)
					grid[ii++][jj++]=color;
			}
		}
		if(x>0&&y>0&&grid[x-1][y-1]==-color){
			i=x-1;
			j=y-1;
			while(i>=0&&j>=0&&grid[i][j]==-color){
				i--;
				j--;
			}
			if(i>=0&&j>=0&&grid[i][j]!=0){
				flag=true;
				int ii=x-1,jj=y-1;
				while(ii>i)
					grid[ii--][jj--]=color;
			}
		}
		if(x<7&&y>0&&grid[x+1][y-1]==-color){
			i=x+1;
			j=y-1;
			while(i<=7&&j>=0&&grid[i][j]==-color){
				i++;
				j--;
			}
			if(i<=7&&j>=0&&grid[i][j]!=0){
				flag=true;
				int ii=x+1,jj=y-1;
				while(ii<i)
					grid[ii++][jj--]=color;
			}
		}
		if(x>0&&y<7&&grid[x-1][y+1]==-color){
			i=x-1;
			j=y+1;
			while(i>=0&&j<=7&&grid[i][j]==-color){
				i--;
				j++;
			}
			if(i>=0&&j<=7&&grid[i][j]!=0){
				flag=true;
				int ii=x-1,jj=y+1;
				while(ii>i)
					grid[ii--][jj++]=color;
			}
		}
		if(!flag)
			throw new Exception("Not a legal square");
		grid[x][y]=color;
	}
	
/*Reine Ausgabe:*/
	void displayResult(){
		int black=0;
		int white=0;
		int i=0,j=0;
		for(i=0;i<8;i++)
		{
			for(j=0;j<8;j++)
			{
				if(grid[i][j]==1)
					white++;
				else if(grid[i][j]==-1)
					black++;
			}
		}
		String str="";
		str=str+"White: "+white+'\n';
		str=str+"Black: "+black+'\n';
		if(white>black)
			str=str+"White wins!";
		else if(black>white)
			str=str+"Black wins!";
		else
			str=str+"It's a draw!";
		JOptionPane.showMessageDialog(null,str);
	}
}

class Bot extends Board{
	int color;
	int depth;
//Gewichtung der Felder
	static int weights[][]={{4,-3,2,2,2,2,-3,4},
                          {-3,-4,-1,-1,-1,-1,-4,-3},
                          {2,-1,1,0,0,1,-1,2},
                          {2,-1,0,1,1,0,-1,2},
                          {2,-1,0,1,1,0,-1,2},
                          {2,-1,1,0,0,1,-1,2},
                          {-3,-4,-1,-1,-1,-1,-4,-3},
                          {4,-1,2,2,2,2,-3,4}};
//Der Konstruktor
	Bot(int c,int d){
		color=c;
		depth=d;
		//static Bot bot =new Bot(1,7); #color=1 depth=7 (Aufruf)
	}

	int think(Board board,ArrayList<Integer> moves){ //grid(lismat) und die Arraylist(listchen2)
		Board mindBoard;
		int i=0,l=moves.size();
		int max=Integer.MIN_VALUE,val=0;  //Chooses lowest Integer number existing (-....)
		int finalMove=moves.get(0);
		int alpha=Integer.MIN_VALUE,beta=Integer.MAX_VALUE; //Choosest highest Integer number existing( + ....)
		for(i=i;i<l;i++){
			mindBoard=new Board(board);
			try{
				mindBoard.move(color,moves.get(i)/8,moves.get(i)%8);  //mindBoard.(weiß,....) ?
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
			val=mini(mindBoard,1,alpha,beta);
			if(val>max){
				max=val;
				finalMove=moves.get(i);
			}
			if(max>=beta)
				return finalMove;
			alpha=alpha>max?alpha:max;  // if(alpha>max){ alpha=alpha} else{ alpha=max} 
		}
		return finalMove;
	}

int mini(Board board,int d,int alpha,int beta){
		if(d==depth)
			return heuristicValue(board);
		Board mindBoard;
		ArrayList<Integer> moves=board.findPossibleMoves(-color);
		if(moves.size()==0)
			return maxi(board,d+1,alpha,beta);
		int i=0,l=moves.size();
		int min=Integer.MAX_VALUE,val=0;
		for(i=i;i<l;i++){
			mindBoard=new Board(board);
			try{
				mindBoard.move(-color,moves.get(i)/8,moves.get(i)%8);  //mindBoard.(schwarz,....)  ?
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
			val=maxi(mindBoard,d+1,alpha,beta);
			if(val<min)
				min=val;
			if(min<=alpha)
				return min;
			beta=beta<min?beta:min; // if(beta<min){ beta=beta} else{ beta=min} 
		}
		return min;
	}

int maxi(Board board,int d,int alpha,int beta){
		if(d==depth)
			return heuristicValue(board);
		Board mindBoard;
		ArrayList<Integer> moves=board.findPossibleMoves(color);
		if(moves.size()==0)
			return mini(board,d+1,alpha,beta);
		int i=0,l=moves.size();
		int max=Integer.MIN_VALUE,val=0;
		for(i=i;i<l;i++){
			mindBoard=new Board(board);
			try{
				mindBoard.move(color,moves.get(i)/8,moves.get(i)%8);
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
			val=mini(mindBoard,d+1,alpha,beta);
			if(val>max)
				max=val;
			if(max>=beta)
				return max;
			alpha=alpha>max?alpha:max;  // if(alpha>max){ alpha=alpha} else{ alpha=max} 
		}
		return max;
	}

	int heuristicValue(Board board){
		return (5*mobilityHeuristic(board))+(25*coinParityHeuristic(board))+(50*stabilityHeuristic(board));
	}

	 int stabilityHeuristic(Board board){
		int max=0,min=0;
		int i=0,j=0;
		for(i=0;i<8;i++){
			for(j=0;j<8;j++){
				if(board.grid[i][j]==color)
					max+=weights[i][j];
				else if(board.grid[i][j]==-color)
					min+=weights[i][j];
			}
		}
		if(max+min!=0)
			return 100*(max-min)/(max+min);
		return 0;
	}

	 int coinParityHeuristic(Board board){
		int countMax=0,countMin=0;
		int i=0,j=0;
		for(i=i;i<8;i++){
			for(j=0;j<8;j++){
				if(board.grid[i][j]==color)
					countMax++;
				else if(board.grid[i][j]==-color)
					countMin++;
			}
		}
		if(countMax+countMin!=0)
			return 100*(countMax-countMin)/(countMax+countMin);
		return 0;
	}

	int mobilityHeuristic(Board board){
		ArrayList<Integer> max=board.findPossibleMoves(color);
		ArrayList<Integer> min=board.findPossibleMoves(-color);
		if(max.size()+min.size()!=0)
			return 100*(max.size()-min.size())/(max.size()+min.size());
		return 0;
	}
}


