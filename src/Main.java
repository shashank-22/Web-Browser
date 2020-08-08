import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import javax.xml.soap.Node;
//import javax.xml.soap.Text;
import java.io.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        final AnchorPane root = new AnchorPane();
        final TabPane tabs = new TabPane();
        final Button addButton = new Button("+");
        final Button incogbtn = new Button("+Incog");
        final Button hstButton = new Button("History");
        final Button clrButton = new Button("Clear H");

        AnchorPane.setTopAnchor(tabs, 5.0);
        AnchorPane.setLeftAnchor(tabs, 5.0);
        AnchorPane.setRightAnchor(tabs, 5.0);
        AnchorPane.setTopAnchor(addButton, 7.0);
        AnchorPane.setRightAnchor(addButton, 9.0);
        AnchorPane.setTopAnchor(hstButton, 40.0);
        AnchorPane.setRightAnchor(hstButton, 10.0);
        AnchorPane.setTopAnchor(clrButton, 40.0);
        AnchorPane.setRightAnchor(clrButton, 70.0);
        AnchorPane.setTopAnchor(incogbtn, 7.0);
        AnchorPane.setRightAnchor(incogbtn, 40.0);

        hstButton.setStyle("-fx-background-color: #bfe896;");
        clrButton.setStyle("-fx-background-color: #bfe896");
        addButton.setStyle("-fx-background-color: #f22e2e");
        incogbtn.setStyle("-fx-background-color: #f22e2e");
        final Tab tab = new Tab("Tab " + (tabs.getTabs().size() + 1));
        WebView web;
        WebEngine engine;

        try {
            tab.setContent((javafx.scene.Node) FXMLLoader.<Node>load(getClass().getResource("resources/sample.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        tab.setClosable(false);
        tabs.getTabs().add(tab);
        tabs.getSelectionModel().select(tab);
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                final Tab tab = new Tab("Tab " + (tabs.getTabs().size() + 1));
                WebView web;
                WebEngine engine;

                try {
                    tab.setContent((javafx.scene.Node) FXMLLoader.<Node>load(getClass().getResource("resources/sample.fxml")));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                tabs.getTabs().add(tab);
                tabs.getSelectionModel().select(tab);
            }
        });

        incogbtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                final Tab tab = new Tab("IncogTab " + (tabs.getTabs().size() + 1));
                WebView web;
                WebEngine engine;

                try {
                    tab.setContent((javafx.scene.Node) FXMLLoader.<Node>load(getClass().getResource("resources/incog.fxml")));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                tabs.getTabs().add(tab);
                tabs.getSelectionModel().select(tab);
            }
        });



        hstButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage hstWindow = new Stage();
                hstWindow.setTitle("History");
                try  {
                    FileReader fr = new FileReader("history.txt");
                    String str = "";
                    int ch;
                    while((ch=fr.read()) != -1)
                    {
                        str+=(char)ch;
                    }
                    StackPane root = new StackPane();
                    //System.out.println(str);
                    Text txt = new Text(str);


                    root.getChildren().add(txt);
                    txt.setTextOrigin(VPos.TOP);
                    txt.setX(0.0);
                    Scene scene = new Scene(root,800,720);
                    hstWindow.setScene(scene);
                    hstWindow.show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        clrButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                PrintWriter pw = null;
                try {
                    pw = new PrintWriter("history.txt");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                pw.close();
            }
        });

        root.getChildren().addAll(tabs, addButton,hstButton,clrButton,incogbtn);

        final Scene scene = new Scene(root, 800, 450);
        primaryStage.setMaximized(true);
        primaryStage.setFullScreen(true);
        //scene.getStylesheets().add("tabs.css");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}