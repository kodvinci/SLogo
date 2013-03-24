package behavior;

import slogo.Model;


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
     * @throws Exception
     */
    public abstract double move (Model model, int turtleNumber) throws Exception;

    /**
     * 
     * @param information information used to initialize
     * @param model model we want to operate
     * @throws Exception
     */
    public abstract void initialize (String[] information, Model model) throws Exception;

}
