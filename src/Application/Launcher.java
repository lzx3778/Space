package Application;

import Application.Engine.Engine;
import Application.stages.MainStage.GameStage;
import Application.system.SystemSettings;
import Application.system.SystemStatus;
import javafx.application.Application;
import javafx.stage.Stage;


/**
 * Created by lzx on 2017/3/21.
 * this is the root class, start stage
 */

public class Launcher extends Application {

    //object used to store system information
    private SystemStatus systemStatus;
    //game settings
    private SystemSettings systemSettings;

    private Engine engine;

    private GameStage gameStage;

    //launch the application
    public static void main(String[] args) {
        launch(args);
    }

    //override the default constructor
    @Override
    //initialize the application
    public void start(Stage stage) {
        //initialize system properties
        systemStatus = new SystemStatus();
        //initialize system settings
        systemSettings = new SystemSettings();

        //create an object of the stage
        stage = new GameStage(this);
        //I am totally unsure if this piece of weired code would be a problem
        gameStage = (GameStage) stage;

        //the position is critical
        engine = new Engine(this);

        //add the window
        stage.show();
    }

    public SystemStatus getSystemStatus(){
        return systemStatus;
    }
    public Engine getEngine(){
        return engine;
    }
    public GameStage getGameStage(){
        return gameStage;
    }

    public SystemSettings getSystemSettings() {
        return systemSettings;
    }

    public void setSystemSettings(SystemSettings systemSettings) {
        this.systemSettings = systemSettings;
    }
}