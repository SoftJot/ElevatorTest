/*
trial shot at building IU elements.

CJ

 */

package elevatortest;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;


public class ElevatorTest extends JApplet {
    
    private static final int JFXPANEL_WIDTH_INT = 400;
    private static final int JFXPANEL_HEIGHT_INT = 300;
    private static JFXPanel fxContainer;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
                } catch (Exception e) {
                }
                
                JFrame frame = new JFrame("Elevator App 'first build' ");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                JApplet applet = new ElevatorTest();
                applet.init();
                
                frame.setContentPane(applet.getContentPane());
                
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                
                applet.start();
            }
        });
    }
    
    @Override
    public void init() {
        fxContainer = new JFXPanel();
        fxContainer.setPreferredSize(new Dimension(JFXPANEL_WIDTH_INT, JFXPANEL_HEIGHT_INT));
        add(fxContainer, BorderLayout.CENTER);

        // create JavaFX scene
        Platform.runLater(new Runnable() {
            
            @Override
            public void run() {
                createScene();
            }
        });
    }
    
    private void createScene() {
        Button btnKill = new Button();
        Button btnAdd = new Button();
        Button btnCall = new Button();

        btnAdd.setText("Add person");
        btnAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Added new person");
            }
        });
            
        btnCall.setText("Call Elevator");
        btnCall.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Elevator Called!");
            }
        });
            
        btnKill.setText("person arrived");
        btnKill.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Person process killed.");
            }
        });
        StackPane root = new StackPane();
        btnKill.setLayoutX(125);
        btnKill.setLayoutY(125); 
        btnAdd.setLayoutX(125);
        btnAdd.setLayoutY(225); 
        btnCall.setLayoutX(125);
        btnCall.setLayoutY(325); 
        root.getChildren().add(btnKill);
        root.getChildren().add(btnAdd);
        root.getChildren().add(btnCall);
        fxContainer.setScene(new Scene(root, 400, 400));
    }
    
}
