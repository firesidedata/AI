//Robert Maule and Jessica SilverStein
//3/1/18
//Program 3
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import aima.core.agent.Action;
import aima.core.search.agent.SearchAgent;
import aima.core.search.framework.SearchForActions;
import aima.core.search.framework.problem.Problem;
import aima.core.search.framework.qsearch.GraphSearch;
import aima.core.search.informed.AStarSearch;
import aima.core.search.informed.GreedyBestFirstSearch;
import aima.core.search.uninformed.BreadthFirstSearch;
import aima.core.search.uninformed.DepthFirstSearch;

import java.util.Scanner;
public class maze {
public static void main(String[] args) throws Exception
{
	//reads in the maze from file
	
	File file = new File("smallMaze.txt");
	Scanner sc = new Scanner(file);
	int MAX_X=0;
	int MAX_Y=0;
	int goalx=0;
	int goaly=0;
	int startx=0;
	int starty=0;
	Vector<String> lines = new Vector<String>();
	char grid[][];
	while(sc.hasNextLine())
	{
	String temp=sc.nextLine();
	lines.add(temp);
	}
	sc.close();
	MAX_Y=lines.size();
	MAX_X=lines.get(0).length();
	grid=new char[MAX_Y][MAX_X];
	for(int i=0; i<MAX_Y; i++)
	{
		for(int j=0; j<MAX_X; j++)
		{
			grid[i][j]=lines.get(i).charAt(j);
			if(grid[i][j]=='S')
			{
				starty=i;
				startx=j;
			}
			if(grid[i][j]=='G')
			{
				goaly=i;
				goalx=j;
			}
		}
	}
	//makes puzzles
	MazePuzzle maze=new MazePuzzle(startx,starty,goalx,goaly,MAX_X,MAX_Y,grid);
	MazePuzzle maze2=new MazePuzzle(maze);
	MazePuzzle maze3=new MazePuzzle(maze);
	MazePuzzle maze4=new MazePuzzle(maze);
    maze.printboard();
    List<Properties> p=new ArrayList<>();
    //does the earches and then adds the proprites of each to an arraylist
	p.add(breadthfirst(maze2));
	p.add(depthfirst(maze3));
	p.add(Greedy(maze4));
    p.add(Astar(maze));
    //output
   System.out.println();
   System.out.println("Algorithm   QueueSize  MaxQueueSize    PathCost        NodesExpanded");
   System.out.println("--------------------------------------------------------------------");
   System.out.println("BFS      "+p.get(0));
   System.out.println("DFS      "+p.get(1));
   System.out.println("GFS      "+p.get(2));
   System.out.println("Astar    "+p.get(3));



	
}
public static Properties breadthfirst(MazePuzzle state) throws Exception
{
	Problem<MazePuzzle, Action> problem = new MazeProblem(state);
	SearchForActions<MazePuzzle, Action> search = new BreadthFirstSearch<>(new GraphSearch<>());
	SearchAgent<MazePuzzle, Action> agent = new SearchAgent<>(problem, search);
	System.out.println("Breadth First Search");
	
	//prints completed maze
	List<Action> actionslist=agent.getActions();
	for(Action e:actionslist)
	{
		if (MazePuzzle.UP.equals(e))
			state.moveup();
		else if (MazePuzzle.RIGHT.equals(e))
			state.moveright();
		else if (MazePuzzle.DOWN.equals(e))
			state.movedown();
		else if (MazePuzzle.LEFT.equals(e))
			state.moveleft();
	}
	state.printboard();
	return agent.getInstrumentation();
	
}
public static Properties depthfirst(MazePuzzle state) throws Exception
{
	Problem<MazePuzzle, Action> problem = new MazeProblem(state);
	SearchForActions<MazePuzzle, Action> search = new DepthFirstSearch<>(new GraphSearch<>());
	SearchAgent<MazePuzzle, Action> agent = new SearchAgent<>(problem, search);
	System.out.println("Depth First Search");
	//prints completed maze
	List<Action> actionslist=agent.getActions();
	for(Action e:actionslist)
	{
		if (MazePuzzle.UP.equals(e))
			state.moveup();
		else if (MazePuzzle.RIGHT.equals(e))
			state.moveright();
		else if (MazePuzzle.DOWN.equals(e))
			state.movedown();
		else if (MazePuzzle.LEFT.equals(e))
			state.moveleft();
	}
	state.printboard();
	return agent.getInstrumentation();

}
public static Properties Astar(MazePuzzle state) throws Exception
{
	Problem<MazePuzzle, Action> problem = new MazeProblem(state);
	SearchForActions<MazePuzzle, Action> search = new AStarSearch<>(new GraphSearch<>(),
			mazefunctions.createManhattanHeuristicFunction());
	SearchAgent<MazePuzzle, Action> agent = new SearchAgent<>(problem, search);
	System.out.println("AStar First Search");
	//prints completed maze
	List<Action> actionslist=agent.getActions();
	for(Action e:actionslist)
	{
		if (MazePuzzle.UP.equals(e))
			state.moveup();
		else if (MazePuzzle.RIGHT.equals(e))
			state.moveright();
		else if (MazePuzzle.DOWN.equals(e))
			state.movedown();
		else if (MazePuzzle.LEFT.equals(e))
			state.moveleft();
	}
	state.printboard();
	return agent.getInstrumentation();

	
}
public static Properties Greedy(MazePuzzle state) throws Exception
{
	Problem<MazePuzzle, Action> problem = new MazeProblem(state);
	SearchForActions<MazePuzzle, Action> search = new GreedyBestFirstSearch<>(new GraphSearch<>(),
			mazefunctions.createManhattanHeuristicFunction());
	SearchAgent<MazePuzzle, Action> agent = new SearchAgent<>(problem, search);
	System.out.println("Greedy First Search");
	//prints completed maze
	List<Action> actionslist=agent.getActions();
	for(Action e:actionslist)
	{
		if (MazePuzzle.UP.equals(e))
			state.moveup();
		else if (MazePuzzle.RIGHT.equals(e))
			state.moveright();
		else if (MazePuzzle.DOWN.equals(e))
			state.movedown();
		else if (MazePuzzle.LEFT.equals(e))
			state.moveleft();
	}
	state.printboard();
	return agent.getInstrumentation();
}
}