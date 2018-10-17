package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.frontPage.FrontPageController;
import sample.gamePage.GamePageController;

public class Main extends Application {

    private Stage stage;



    private FrontPageController frontPageController;

    private GamePageController gamePageController;

    @Override
    public void start(Stage primaryStage) throws Exception{

        this.stage = primaryStage;

        mainWindow();

    }

    private void mainWindow(){

        try{

            stage.setResizable(true);

            stage.setTitle("Main Menu");

            //Initialize two primary scenes for the stage, allow the controller to switch between them.

            FXMLLoader frontPageLoader = new FXMLLoader(getClass().getResource("frontPage/FrontPage.fxml"));

            FXMLLoader gamePageLoader = new FXMLLoader(getClass().getResource("gamePage/GamePage.fxml"));

            AnchorPane frontPagePane = frontPageLoader.load();

            AnchorPane gamePagePane = gamePageLoader.load();

            Scene frontPageScene = new Scene(frontPagePane);

            Scene gamePageScene = new Scene(gamePagePane);

            String stylesheet = Main.class.getResource("style.css").toExternalForm();

            frontPageScene.getStylesheets().addAll(stylesheet);

            gamePagePane.getStylesheets().addAll(stylesheet);

            frontPageController = frontPageLoader.getController();

            frontPageController.setMain(this);

            frontPageController.setGame(gamePageScene);

            gamePageController = gamePageLoader.getController();

            gamePageController.setFrontPage(frontPageScene);

            stage.setScene(frontPageScene);

            stage.show();

        }catch (Exception e){

            e.printStackTrace();
        }
    }

    public FrontPageController getFrontPageController() {
        return frontPageController;
    }

    public void setFrontPageController(FrontPageController frontPageController) {
        this.frontPageController = frontPageController;
    }

    public GamePageController getGamePageController() {
        return gamePageController;
    }

    public void setGamePageController(GamePageController gamePageController) {
        this.gamePageController = gamePageController;
    }
	/**
	 * Launch the application.
	 */
    public static void main(String[] args) {
        launch(args);
    }
}
