//Robert Maule and Jessica SilverStein
//3/1/18
//Program 3
import java.util.ArrayList;
import java.util.List;

import aima.core.agent.Action;
import aima.core.agent.impl.DynamicAction;
import aima.core.util.datastructure.XYLocation;
public class MazePuzzle {
	public static Action LEFT = new DynamicAction("Left");

	public static Action RIGHT = new DynamicAction("Right");

	public static Action UP = new DynamicAction("Up");

	public static Action DOWN = new DynamicAction("Down");
	int x; //curent x
	int y; //current y
	int maxx; //maxx x
	int maxy; //max y
	int goalx; //goal x
	int goaly; // goal y
	char board[][]; //state of the board
	public MazePuzzle(){//defult constructor
		board=null;
		x=0;
		y=0;
		goalx=99;
		goaly=99;
		
	}
	//constructor
	public MazePuzzle(int x, int y, int goalx,int goaly,int maxx,int maxy, char newboard[][]){
		this.x=x;
		this.y=y;
		this.goalx=goalx;
		this.goaly=goaly;
		this.maxx=maxx;
		this.maxy=maxy;
		this.board=new char[maxy][maxx];
		for(int i=0; i<maxy; i++)
		{
			for(int j=0; j<maxx; j++)
			{
				board[i][j]=newboard[i][j];
			}
		}
	}
	//contrustor for copying
	public MazePuzzle(MazePuzzle state)
	{
		this.x=state.x;
		this.y=state.y;
		this.goalx=state.goalx;
		this.goaly=state.goaly;
		this.maxx=state.maxx;
		this.maxy=state.maxy;
		this.board=new char[maxy][maxx];
		for(int i=0; i<maxy; i++)
		{
			for(int j=0; j<maxx; j++)
			{
				board[i][j]=state. board[i][j];
			}
		}
	}
	//print
	public void printboard()
	{
		for(int i=0; i<maxy; i++)
		{
			for(int j=0; j<maxx; j++)
			{
				System.out.print(board[i][j]+"");
			}
			System.out.println();
		}
	}
	public void moveup()
	{
		int newYcord=y-1;
		
			y=newYcord;
			adddashdown();
	}
	public void movedown()
	{
		int newYcord=y+1;
	
			y=newYcord;
			adddashdown();
		
	}
	public void moveleft()
	{
		int newXcord=x-1;

			x=newXcord;
			adddashright();
	}
	public void moveright()
	{
		
		int newXcord=x+1;
			x=newXcord;
			adddashright();
		
	}
	//used before i used dots. i was using lines at first, no longer completley nessecarry
	public void adddashright()
	{
		board[y][x]='.';
	}
	public void adddashdown()
	{
		board[y][x]='.';
	}
	//checks if a spot is valid
	public boolean isvalid(Action where)
	{
		boolean retVal = true;
		if (where.equals(LEFT))
			return!(board[y][x-1]=='#');
		else if (where.equals(RIGHT))
			return!(board[y][x+1]=='#');
		else if (where.equals(UP))
			return!(board[y-1][x]=='#');
		else if (where.equals(DOWN))
			return!(board[y+1][x]=='#');
		return retVal;
	}
	@Override
	public boolean equals(Object o) {
		MazePuzzle temp=new MazePuzzle((MazePuzzle)o);
		if(x==temp.x&&y==temp.y)
		return true;
		return false;
	}
	@Override
	public int hashCode() {
		return 37+x+y;
	}
	
	}
	
	 

