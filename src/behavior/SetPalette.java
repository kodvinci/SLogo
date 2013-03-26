package behavior;

import slogo.Model;


/**
 * Set palette
 * 
 * @author Jerry
 * 
 */
public class SetPalette implements ICommand {

    /**
     * Number of parameters command takes
     */
    public static final int PARAMETER_NUMBER = 4;

    /**
     * Blue place number
     */
    private static final int BLUE_PLACE = 3;
    
    /**
     * rgb factor
     */
    private static final int RGB_FACTOR = 256;
    
    private int myColorIndex;
    private float myRedValue;
    private float myGreenValue;
    private float myBlueValue;

    @Override
    public double move (Model model, int turtleNumber) {

        model.getController().getView().getTurtleArea().addToColorPalette(myColorIndex,
                                                                          myRedValue,
                                                                          myGreenValue,
                                                                          myBlueValue);
        return 0;
    }

    @Override
    public void initialize (String[] information, Model model) {
        myColorIndex = Integer.parseInt(information[0]) / RGB_FACTOR;
        myRedValue = Float.parseFloat(information[1]) / RGB_FACTOR;
        myGreenValue = Float.parseFloat(information[2]) / RGB_FACTOR;
        myBlueValue = Float.parseFloat(information[BLUE_PLACE]) / RGB_FACTOR;
    }
}
