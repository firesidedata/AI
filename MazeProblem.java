//Robert Maule and Jessica SilverStein
//3/1/18
//Program 3
import aima.core.agent.Action;
import aima.core.search.framework.problem.BidirectionalProblem;
import aima.core.search.framework.problem.GeneralProblem;
import aima.core.search.framework.problem.GoalTest;
import aima.core.search.framework.problem.Problem;
//creates the maze Problem to be used in the search Classes
public class MazeProblem extends GeneralProblem<MazePuzzle, Action> {
	
 public  MazeProblem(MazePuzzle initalstate)
 {
	super(initalstate, mazefunctions::getActions, mazefunctions::getResult,
			GoalTest.isEqual(mazefunctions.GoalState(initalstate)));
 }
} 
