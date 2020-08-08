import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import org.controlsfx.control.textfield.TextFields;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class incogController implements Initializable{
    public Button gobtn;
    public Button backbtn;
    public Button nextbtn;
    @FXML
    TextField addressBar;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        String[] possibleSuggestions = {"www.google.com","www.mnit.ac.in","www.youtube.com","www.facebook.com","www.gmail.com","www.geeksforgeeks.org","www.learncpp.com","www.tutoialspoint.com","www.github.com","www.wikipedia.org","www.amazon.in","www.flipkart.com","www.myntra.com","www.netflix.com","www.udemy.com","www.udacity.com","www.coursera.org","www.mkvcage.com","www4.9anime.is","www.javatpoint.com"};
        TextFields.bindAutoCompletion(addressBar,possibleSuggestions);

    }
    @FXML
    WebView web;
    WebEngine engine;
    Tab tab;
    String htLink = "http://";


    String[] links=new String[100];
    int ind=-1;
    int i=0;

    public void onEnter(ActionEvent actionEvent) throws IOException {
        ind++;
        String adrsLink = addressBar.getText().toString();
        links[ind]=adrsLink;

        engine=web.getEngine();
        engine.load(htLink+links[ind]);
        i=ind;
    }
    public void go(ActionEvent actionEvent) throws IOException {
        ind++;
        String adrsLink = addressBar.getText().toString();
        links[ind]=adrsLink;

        engine=web.getEngine();
        engine.load(htLink+links[ind]);
        i=ind;
    }
    public void back(ActionEvent actionEvent) {
        if(i>0)
        {
            i--;
            addressBar.setText(links[i]);
            System.out.print(links[i]);
            engine=web.getEngine();
            engine.load(htLink+links[i]);
        }
    }
    public void next(ActionEvent actionEvent) {
        if(i<ind)
        {
            i++;
            addressBar.setText(links[i]);
            System.out.print(links[i]);
            engine=web.getEngine();
            engine.load(htLink+links[i]);
        }
    }
}
