import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.control.Slider;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.geometry.Insets;

public class colorswitcher extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    
    BorderPane pane = new BorderPane();
    Pane paneForColor = new Pane();
    
    //create scrollbars
    ScrollBar sbRed = new ScrollBar();
    sbRed.setMin(0);
    sbRed.setMax(1.0);
    sbRed.setOrientation(Orientation.VERTICAL);
    ScrollBar sbBlue = new ScrollBar();
    sbBlue.setMin(0);
    sbBlue.setMax(1.0);
    sbBlue.setOrientation(Orientation.VERTICAL);    
    ScrollBar sbGreen = new ScrollBar();
    sbGreen.setMin(0);
    sbGreen.setMax(1.0);
    sbGreen.setOrientation(Orientation.VERTICAL);
    ScrollBar sbOpacity = new ScrollBar();
    sbOpacity.setMin(0);
    sbOpacity.setMax(1.0);
    sbOpacity.setValue(1.0);
    sbOpacity.setOrientation(Orientation.VERTICAL);
     
    // text field
    PasswordField tf = new PasswordField();

    // SLIDER
    Slider slrotate = new Slider();
    slrotate.setMax(360);
    slrotate.setMin(0);
    slrotate.setShowTickMarks(true);
    
    // font buttons
    ToggleGroup group = new ToggleGroup();
    RadioButton bt12 = new RadioButton("12");
    bt12.setToggleGroup(group);
    RadioButton bt24 = new RadioButton("24");
    bt24.setToggleGroup(group);
    RadioButton bt48 = new RadioButton("48");
    bt48.setToggleGroup(group);
    
    //create text
    Text text = new Text("Color");
    text.setTextAlignment(TextAlignment.CENTER);
    
    // create labels
    Label red = new Label("R");
    Label green = new Label("G");
    Label blue = new Label("B");
    Label opac = new Label("O");
    
    //listeners
    sbRed.valueProperty().addListener(ov -> {
     Color r = new Color(sbRed.getValue(), sbGreen.getValue(), 
     	sbBlue.getValue(), sbOpacity.getValue());
     text.setFill(r);}
     );

    sbBlue.valueProperty().addListener(ov -> {
    	Color b = new Color(sbRed.getValue(), sbGreen.getValue(), 
    		sbBlue.getValue(), sbOpacity.getValue());
    	text.setFill(b);}
    	);

    sbGreen.valueProperty().addListener(ov -> {
    	Color g = new Color(sbRed.getValue(), sbGreen.getValue(), 
    		sbBlue.getValue(), sbOpacity.getValue());
    	text.setFill(g);}
    	);

    sbOpacity.valueProperty().addListener(ov -> {
    	Color o = new Color(sbRed.getValue(), sbGreen.getValue(), 
    		sbBlue.getValue(), sbOpacity.getValue());
    	text.setFill(o);} 
    	);
   
    //to rotate text
    slrotate.valueProperty().addListener(ov ->
        text.setRotate(slrotate.getValue())
        );

    // to get text
    tf.setOnAction(e -> text.setText(tf.getText()));

    
    //paneForColor.setOnKeypressed(e ->)
    //case DOWN: text.setText()
    
    // change font
    bt12.setOnAction(e -> text.setFont(new Font("SansSerif", 12)));
    bt24.setOnAction(e -> text.setFont(new Font("SansSerif", 24)));
    bt48.setOnAction(e -> text.setFont(new Font("SansSerif", 48)));
     
    //create hbox for labels
    HBox labels = new HBox(13);
    labels. getChildren().addAll(red, green, blue, opac);
   
    //create vbox for scrollbars
    HBox hBox = new HBox(5);
    hBox.getChildren().addAll(sbRed, sbGreen, sbBlue, sbOpacity);

    //create vbox for buttons
    VBox vBox = new VBox(5);
    vBox.getChildren().addAll(bt12, bt24, bt48);
    vBox.setPadding(new Insets(10, 10, 10, 10));

    //create vbox for labels and scrollbars
    VBox rgb = new VBox(5);
    rgb.getChildren().addAll(hBox, labels);
    rgb.setPadding(new Insets(10, 10, 10, 10));

    Rectangle rec = new Rectangle();
    rec.setStroke(Color.BLACK);
    rec.setFill(Color.WHITE);
    rec.heightProperty().bind(paneForColor.heightProperty().divide(2));
    rec.widthProperty().bind(paneForColor.widthProperty().divide(2));
    rec.xProperty().bind(paneForColor.widthProperty().divide(4));
    rec.yProperty().bind(paneForColor.heightProperty().divide(4));
    
    // add items to paneforcolor
    paneForColor.getChildren().addAll(rec, text);
    
    // bind text to center
    text.yProperty().bind(paneForColor.heightProperty().divide(2));
    text.xProperty().bind(paneForColor.widthProperty().divide(2));
   
    //set up pane
    pane.setPrefSize(500, 300);
    pane.setCenter(paneForColor);
    pane.setRight(rgb);
    pane.setBottom(slrotate);
    pane.setLeft(vBox);
    pane.setTop(tf);

    //create stage
    Scene scene = new Scene(pane);
    primaryStage.setTitle("change color");
    primaryStage.setScene(scene);
    primaryStage.show();

   }
 }
