import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import org.controlsfx.control.textfield.TextFields;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class Controller implements Initializable{
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

        //PrintWriter pw = new PrintWriter("history.txt");
        //pw.close();
        FileWriter fw = new FileWriter("history.txt",true);
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            //get current date time with Date()
            Date date = new Date();
            int space;
            int len = (htLink+links[ind]).length();
            int con = 153;
            space = con-len;

            //System.out.println(space);
            String s = htLink+links[ind];
            for(int i=0;i<space;i++)
                s+=" ";
            s+=dateFormat.format(date);
            System.out.println(s.length());
            for(int i=0;i<s.length();i++) {
                fw.append(s.charAt(i));
            }
            fw.append('\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
        fw.close();
    }
    public void go(ActionEvent actionEvent) throws IOException {
        ind++;
        String adrsLink = addressBar.getText().toString();
        links[ind]=adrsLink;

        engine=web.getEngine();
        engine.load(htLink+links[ind]);
        i=ind;

        //PrintWriter pw = new PrintWriter("history.txt");
        //pw.close();
        FileWriter fw = new FileWriter("history.txt",true);
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            //get current date time with Date()
            Date date = new Date();
            int space;
            int len = (htLink+links[ind]).length();
            int con = 153;
            space = con-len;

            //System.out.println(space);
            String s = htLink+links[ind];
            for(int i=0;i<space;i++)
                s+=" ";
            s+=dateFormat.format(date);
            System.out.println(s.length());
            for(int i=0;i<s.length();i++) {
                fw.append(s.charAt(i));
            }
            fw.append('\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
        fw.close();
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
