package Application;

import Application.logicUnit.World;
import Application.graphicUnit.GameStage;
import Application.graphicUnit.SettingStage;
import Application.status.CanvasStatus;
import Application.status.EngineStatus;
import Application.status.Mouse;
import Application.system.SystemSettings;
import Application.status.SystemStatus;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.awt.*;


/**
 * Created by lzx on 2017/3/21.
 * this is the root class, start stage
 */

public class Launcher extends Application {

    //object used to store world information
    private EngineStatus engineStatus;
    //object used to store canvas information
    private CanvasStatus canvasStatus;

    //get screen size
    private Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();

    //game worldSettings
    private SystemSettings systemSettings;

    private World World;

    private GameStage gameStage;
    //option menu
    private SettingStage settingStage;

    //launch the application
    public static void main(String[] args) {
        Application.launch(args);
    }

    //override the default constructor
    @Override
    //initialize the application
    public void start(Stage stage) {

        //get width height
        SystemStatus.setScreenHeight(screenSize.getHeight());
        SystemStatus.setScreenwidth(screenSize.getWidth());

        //initialize world status
        engineStatus = new EngineStatus();
        //initialize canvas status
        canvasStatus = new CanvasStatus();

        //initialize system worldSettings
        systemSettings = new SystemSettings();

        //create an object of the stage
        stage = new GameStage(this);
        //I am totally unsure if this piece of weired code would be a problem
        gameStage = (GameStage) stage;

        //setting window
        settingStage = new SettingStage(400, 400, 400, 400);
        settingStage.setOnCloseRequest(event -> SystemStatus.setSettingStageOut(false));
        SystemStatus.setSettingStageOut(false);

        //the position is critical
        World = new World(this);

        //add the window
        stage.show();
    }

    public World getWorld(){
        return World;
    }

    public GameStage getGameStage(){
        return gameStage;
    }

    public SettingStage getSettingStage(){
        return settingStage;
    }

    public SystemSettings getSystemSettings() {
        return systemSettings;
    }

    public void setSystemSettings(SystemSettings systemSettings) {
        this.systemSettings = systemSettings;
    }

    public EngineStatus getEngineStatus() {
        return engineStatus;
    }

    public void setEngineStatus(EngineStatus engineStatus) {
        this.engineStatus = engineStatus;
    }

    public CanvasStatus getCanvasStatus() {
        return canvasStatus;
    }

    public void setCanvasStatus(CanvasStatus canvasStatus) {
        this.canvasStatus = canvasStatus;
    }

    public Rectangle2D getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(Rectangle2D screenSize) {
        this.screenSize = screenSize;
    }

}
