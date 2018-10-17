package sample;

import sample.model.Player;

import java.util.ArrayList;
import java.util.List;
/**
* This is a controller class
*/

public class Controller {

    private static Controller instance = new Controller();

    public static Controller getInstance() {
        return instance;
    }

    private static List<Player> players ;

    private static int phase = 1;

    private static int currentPlayerIndex= 0;

    public static List<Player> getPlayers(){

        return players;
    }

    public static int getPhase(){
        return phase;
    }

    public static void addPlayer(Player player){

        players.add(player);
    }
    public static Player getCurrentPlayer(){

        return players.get(currentPlayerIndex);
    }

    private static void nextPlayer(){ currentPlayerIndex = (currentPlayerIndex+1)%players.size();}

    public static void nextPhase(){

        phase = (phase+1)%3;

        if (phase == 1) nextPlayer();
    }

    public static void setPlayers(List<Player> players) {
        Controller.players = players;
    }

    public static void reset() {

        phase = 1;

        currentPlayerIndex = 0;

        players = new ArrayList<>();
    }
}
