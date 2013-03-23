package behavior;

import slogo.Model;
import exceptions.NoSuchCommandException;
import exceptions.NoSuchVariableException;
import exceptions.SyntaxException;


/**
 * 
 * @author Richard Yang
 * 
 */

public interface ICommand {

    /**
     * 
     * @param model model we want to operate
     * @param turtleNumber which turtle we want to operate
     * @return return value
     * @throws SyntaxException wrong syntax format
     * @throws NoSuchVariableException
     * @throws NoSuchCommandException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws SecurityException
     * @throws NoSuchFieldException
     */
    public abstract double move (Model model, int turtleNumber) throws Exception;

    /**
     * 
     * @param information information used to initialize
     * @param model model we want to operate
     * @throws SyntaxException wrong syntax
     * @throws NoSuchCommandException
     * @throws NoSuchVariableException
     * @throws SecurityException
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     */
    public abstract void initialize (String[] information, Model model) throws Exception;

}
