import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.Scene;
public class hstController implements Initializable{
    public TableView table;
    public Button clr;
    @FXML
        public Button gethst;
    Tab newTab1=new Tab();


    @FXML public void getHistory(ActionEvent actionEvent)  {
        Button close=(Button)actionEvent.getSource();
        Scene btnscene=close.getScene();

//        Tab thistabPane=(Tab)btnscene.lookup("#ht");
        //histabPane.getTabs().remove(1);
       /* newTab1.setClosable(true);
        newTab1.setId("nt");
        newTab1.setText("ukfuy");
        newTab1.setContent(FXMLLoader.<Node>load(getClass().getResource("sample.fxml")));*/
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
