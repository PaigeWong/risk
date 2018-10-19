package sample.gamePage.status.countryStatus;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import sample.GameStatus;
import sample.model.Country;
import sample.utils.GameUtil;
    /**
	 * This class is to move Army
	 * 
	 */
public class MoveArmy {

    @FXML
    private AnchorPane moveArmy;

    @FXML
    private ChoiceBox<Country> options;

    void setFrom(Country from) {

        options.setItems(FXCollections.observableArrayList(
                GameUtil.findAllConnectedCountry(GameStatus.getInstance().getCurrentPlayer(), from)));
    }
    /**
	 * This method is move army with ArnchorPane
	 * 
	 * @return
	 *           moveArmy
	 */
    AnchorPane getMoveArmy() {

        return moveArmy;
    }
    /**
	 * This method is get the selected country
	 * 
	 * @return options.getValue
	 */
    Country getSelected() {

        return options.getValue();
    }
}
