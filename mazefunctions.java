//Robert Maule and Jessica SilverStein
//3/1/18
//Program 3
import aima.core.agent.Action;
import aima.core.environment.eightpuzzle.EightPuzzleBoard;
import aima.core.search.framework.Node;
import aima.core.util.datastructure.XYLocation;

import java.util.ArrayList;
import java.util.List;
import java.util.function.ToDoubleFunction;

public class mazefunctions {
	//return list of possible actions
	public static List<Action> getActions(MazePuzzle state) {
		List<Action> actions = new ArrayList<>(4);

		if (state.isvalid(MazePuzzle.UP))
			actions.add(MazePuzzle.UP);
		if (state.isvalid(MazePuzzle.RIGHT))
			actions.add(MazePuzzle.RIGHT);
		if (state.isvalid(MazePuzzle.DOWN))
			actions.add(MazePuzzle.DOWN);
		if (state.isvalid(MazePuzzle.LEFT))
			actions.add(MazePuzzle.LEFT);
        
		return actions;
	}
	//gets the result board
	public static MazePuzzle getResult(MazePuzzle state, Action action) {
		MazePuzzle result = new MazePuzzle(state);

		if (MazePuzzle.UP.equals(action) && state.isvalid(MazePuzzle.UP))
			result.moveup();
		else if (MazePuzzle.RIGHT.equals(action) && state.isvalid(MazePuzzle.RIGHT))
			result.moveright();
		else if (MazePuzzle.DOWN.equals(action) && state.isvalid(MazePuzzle.DOWN))
			result.movedown();
		else if (MazePuzzle.LEFT.equals(action) && state.isvalid(MazePuzzle.LEFT))
			result.moveleft();
		return result;
	}
	//returns a goal state of the board given
    public static MazePuzzle GoalState(MazePuzzle state)
    {
    	 MazePuzzle retpuzzle=new MazePuzzle(state);
    	 retpuzzle.x=retpuzzle.goalx;
    	 retpuzzle.y=retpuzzle.goaly;
		return retpuzzle;
    	
    }
    //makes manhattan function
    public static ToDoubleFunction<Node<MazePuzzle, Action>> createManhattanHeuristicFunction() {
		return new ManhattanHeuristicFunction();
	}
    
    //manhatan function class
    private static class ManhattanHeuristicFunction implements ToDoubleFunction<Node<MazePuzzle, Action>> {

        @Override
        public double applyAsDouble(Node<MazePuzzle, Action> node) {
            MazePuzzle board = node.getState();
            int retVal = 0;
            int x=Math.abs(board.goalx-board.x);
            int y=Math.abs(board.goaly-board.y);
            retVal+=x+y;
            return retVal;
        }
}
}
