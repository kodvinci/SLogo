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
        System.out.println("setpallete initiazlied");
        myColorIndex = Integer.parseInt(information[0]);
        myRedValue = Float.parseFloat(information[1]);
        myGreenValue = Float.parseFloat(information[2]);
        myBlueValue = Float.parseFloat(information[BLUE_PLACE]);
        System.out.println("color index: " + myColorIndex + ", red value: " + myRedValue +
                           ", green value");
    }
}
