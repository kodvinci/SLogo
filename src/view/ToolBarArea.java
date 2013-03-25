package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import slogo.Controller;


/**
 * Provides the tool bar area where menus can be added
 * 
 * @author Leonard
 * 
 */
public class ToolBarArea extends JMenuBar {

    private static final String DEFAULT_RESOURCE_PACKAGE = "resources.";
    private static final String USER_DIR = "user.dir";
    private static final Color TOOLBARCOLOR = Color.GREEN;
    private static final long serialVersionUID = 1L;
    private Controller myController;
    private JFileChooser myChooser;
    private ResourceBundle myResources;
    private ResourceBundle myTurtles;
    private ResourceBundle myBackgroundImages;
    private ResourceBundle myColors;
    private String myBackgroundColor;
    private String myBackgroundImage;

    ToolBarArea (Controller control) {
        myController = control;
        myChooser = new JFileChooser(System.getProperties().getProperty(USER_DIR));
        myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "English");
        myBackgroundImages = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "Background");

        myColors = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "Colors");
        myTurtles = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "Turtles");

        setBackground(TOOLBARCOLOR);
        this.add(makeFileMenu());
        this.add(makeTurtleMenu());
        this.add(makeBackgroundMenu());
        this.add(makePenMenu());
        this.add(makeGridMenu());
    }

    /**
     * make a file menu for opening and saving files
     */
    private JMenu makeFileMenu () {
        JMenu result = new JMenu(myResources.getString("FileMenu"));
        result.add(new AbstractAction(myResources.getString("OpenCommand")) {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed (ActionEvent e) {
                try {
                    int response = myChooser.showOpenDialog(null);
                    if (response == JFileChooser.APPROVE_OPTION) {
                        try {
                            echo(new FileReader(myChooser.getSelectedFile()));
                        }
                        catch (NoSuchFieldException | SecurityException | IllegalArgumentException
                                | IllegalAccessException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                    }
                }
                catch (IOException io) {
                    showError(io.toString());
                }
            }
        });
        result.add(new AbstractAction(myResources.getString("SaveCommand")) {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed (ActionEvent e) {
                try {
                    echo(new FileWriter("demo.out"));
                }
                catch (IOException io) {
                    showError(io.toString());
                }
            }
        });
        result.add(new AbstractAction(myResources.getString("UndoCommand")) {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed (ActionEvent e) {
                myController.getView().getTurtleArea().undo();
            }
        });
        result.add(new AbstractAction(myResources.getString("RedoCommand")) {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed (ActionEvent e) {
                myController.getView().getTurtleArea().redo();
            }
        });
        result.add(new AbstractAction(myResources.getString("HelpCommand")) {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed (ActionEvent e) {
                String htmlPath =
                        "https://www.cs.duke.edu/courses/cps108/compsci308/cps108/spring13/assign/03_slogo/commands.php"; // path
                                                                                                                          // to
                                                                                                                          // your
                                                                                                                          // new
                                                                                                                          // file

                try {
                    java.awt.Desktop.getDesktop().browse(java.net.URI.create(htmlPath));
                }
                catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        result.add(new JSeparator());
        result.add(new AbstractAction(myResources.getString("QuitCommand")) {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed (ActionEvent e) {
                System.exit(0);
            }
        });
        return result;
    }

    private void echo (FileWriter fileWriter) {
    }

    private void showError (String message) {
        JOptionPane.showMessageDialog(this, message, myResources.getString("ErrorTitle"),
                                      JOptionPane.ERROR_MESSAGE);
    }

    private void echo (FileReader fileReader) throws NoSuchFieldException, SecurityException,
                                             IllegalArgumentException, IllegalAccessException {
        try {
            BufferedReader input = new BufferedReader(fileReader);
            String line = input.readLine();
            List<String> inputCommands = new ArrayList<String>();
            while (line.length() != 0) {
                inputCommands.add(line);
                line = input.readLine();
            }
            for (String inputCommand : inputCommands) {
                myController.processUserInput(inputCommand);
            }
        }
        catch (IOException e) {
            showError(e.toString());
        }
    }

    private JMenu makeTurtleMenu () {
        JMenu result = new JMenu(myResources.getString("TurtleMenu"));
        JMenu subMenu = new JMenu(myResources.getString("TurtleSubMenu"));

        subMenu.add(new AbstractAction(myTurtles.getString("Turtle1")) {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed (ActionEvent e) {
                myController.getMyTurtle(0, 0).changeTurtleImage("turtle.gif");
                myController.getView().update();
            }
        });

        subMenu.add(new AbstractAction(myTurtles.getString("Turtle2")) {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed (ActionEvent e) {
                myController.getMyTurtle(0, 0).changeTurtleImage("turtle2.gif");
                myController.getView().update();
            }
        });

        result.add(subMenu);
        return result;
    }

    private JMenu makeBackgroundMenu () {
        JMenu result = new JMenu(myResources.getString("BackgroundMenu"));

        JMenu imageSubMenu = new JMenu(myResources.getString("BackgroundSubMenu"));
        myBackgroundImage = myBackgroundImages.getString("Brown");
        imageSubMenu.add(setBackgroundImage(myBackgroundImage));

        myBackgroundImage = myBackgroundImages.getString("CarolinaBlue");
        imageSubMenu.add(setBackgroundImage(myBackgroundImage));

        myBackgroundImage = myBackgroundImages.getString("DukeBlue");
        imageSubMenu.add(setBackgroundImage(myBackgroundImage));

        myBackgroundImage = myBackgroundImages.getString("Green");
        imageSubMenu.add(setBackgroundImage(myBackgroundImage));

        myBackgroundImage = myBackgroundImages.getString("Wooden");
        imageSubMenu.add(setBackgroundImage(myBackgroundImage));

        JMenu colorSubMenu = new JMenu(myResources.getString("BackgroundColor"));
        myBackgroundColor = myBackgroundImages.getString("Color1");
        colorSubMenu.add(setBackgroundColor(myBackgroundColor));

        myBackgroundColor = myBackgroundImages.getString("Color2");
        colorSubMenu.add(setBackgroundColor(myBackgroundColor));

        myBackgroundColor = myBackgroundImages.getString("Color3");
        colorSubMenu.add(setBackgroundColor(myBackgroundColor));

        myBackgroundColor = myBackgroundImages.getString("Color4");
        colorSubMenu.add(setBackgroundColor(myBackgroundColor));

        myBackgroundColor = myBackgroundImages.getString("Color5");
        colorSubMenu.add(setBackgroundColor(myBackgroundColor));

        result.add(imageSubMenu);
        result.add(colorSubMenu);
        return result;
    }

    private AbstractAction setBackgroundImage (String backgroundImage) {
        final String BACKGROUND_IMAGE = backgroundImage;
        AbstractAction action = new AbstractAction(backgroundImage) {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed (ActionEvent e) {
                myController.getView().getTurtleArea().changeBackgroundImage(BACKGROUND_IMAGE);
            }
        };
        return action;
    }

    private AbstractAction setBackgroundColor (String backgroundColor) {
        final int COLORINT = Integer.parseInt(backgroundColor);
        AbstractAction action = new AbstractAction(backgroundColor) {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed (ActionEvent e) {
                myController.getView().getTurtleArea().changeBackgroundColor(COLORINT);
            }
        };
        return action;
    }

    private JMenu makePenMenu () {
        JMenu result = new JMenu(myResources.getString("PenMenu"));

        JMenu subMenu = new JMenu(myResources.getString("PenProperties"));
        JMenu colorMenu = new JMenu(myResources.getString("Colors"));
        result.add(new AbstractAction(myResources.getString("UpCommand")) {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed (ActionEvent e) {
                myController.getView().getTurtleArea().penUp();
            }
        });
        result.add(new AbstractAction(myResources.getString("DownCommand")) {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed (ActionEvent e) {
                myController.getView().getTurtleArea().penDown();
            }
        });

        subMenu.add(new AbstractAction(myResources.getString("Dash")) {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed (ActionEvent e) {
                myController.getView().getTurtleArea().setDashed();
            }
        });
        subMenu.add(new AbstractAction(myResources.getString("Solid")) {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed (ActionEvent e) {
                myController.getView().getTurtleArea().setSolid();
            }
        });
        colorMenu.add(new AbstractAction(myColors.getString("Black")) {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed (ActionEvent e) {
                myController.getView().getTurtleArea().setTrailColor(1);
            }
        });
        colorMenu.add(new AbstractAction(myColors.getString("Blue")) {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed (ActionEvent e) {
                myController.getView().getTurtleArea().setTrailColor(2);
            }
        });
        colorMenu.add(new AbstractAction(myColors.getString("Green")) {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed (ActionEvent e) {
                myController.getView().getTurtleArea().setTrailColor(3);
            }
        });
        colorMenu.add(new AbstractAction(myColors.getString("Red")) {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed (ActionEvent e) {
                myController.getView().getTurtleArea().setTrailColor(4);
            }
        });
        colorMenu.add(new AbstractAction(myColors.getString("Yellow")) {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed (ActionEvent e) {
                myController.getView().getTurtleArea().setTrailColor(5);
            }
        });

        result.add(colorMenu);
        result.add(subMenu);
        return result;

    }

    private JMenu makeGridMenu () {
        JMenu result = new JMenu(myResources.getString("GridMenu"));

        result.add(new AbstractAction(myResources.getString("OnCommand")) {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed (ActionEvent e) {
                myController.getView().getTurtleArea().toggleGridOn();
            }
        });
        result.add(new AbstractAction(myResources.getString("OffCommand")) {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed (ActionEvent e) {
                myController.getView().getTurtleArea().toggleGridOff();
            }
        });
        return result;
    }
}
