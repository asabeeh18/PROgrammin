import java.util.Date;
import javafx.application.Application;
import javafx.beans.value.*;
import javafx.concurrent.Worker.State;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.web.WebEngine;
import javafx.stage.Stage;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/** times the loading of a page in a WebEngine */
public class Downloader extends Application {
  public static void main(String[] args) { launch(args); }
  @Override public void start(Stage stage) {
    final Label instructions = new Label(
      "Loads a web page into a JavaFX WebEngine.  " +
      "The first page loaded will take a bit longer than subsequent page loads due to WebEngine intialization.\n" +
      "Once a given url has been loaded, subsequent loads of the same url will be quick as url resources have been cached on the client."
    );
    instructions.setWrapText(true);
    instructions.setStyle("-fx-font-size: 14px");

    // configure some controls.
    final WebEngine engine   = new WebEngine();
    final TextField location = new TextField("http://www.hbrowse.com/browse/relationship/mother");
    final Button    go       = new Button("Go");
    final Date      start    = new Date();
    go.setOnAction(new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent arg0) {
        engine.load(location.getText());
        start.setTime(new Date().getTime());
      }
    });
    go.setDefaultButton(true);
    final Label timeTaken = new Label();

    // configure help tooltips.
    go.setTooltip(new Tooltip("Start timing the load of a page at the entered location."));
    location.setTooltip(new Tooltip("Enter the location whose page loading is to be timed."));
    timeTaken.setTooltip(new Tooltip("Current loading state and time taken to load the last page."));

    // monitor the page load status and update the time taken appropriately.
    engine.getLoadWorker().stateProperty().addListener(new ChangeListener<State>() {
      @Override public void changed(ObservableValue<? extends State> state, State oldState, State newState) {
        switch (newState) {
          case SUCCEEDED: 
              Document doc=engine.getDocument();
        NodeList element = doc.getElementsByTagName("browseDescription");
        String s=element.item(0).toString();
        
//        for(int i=0;i<elementsByTagName.getLength();i++)
//        {
//            String s=elementsByTagName.item(i).toString();
//        }
              timeTaken.setText(((new Date().getTime()) - start.getTime()) + "ms"); break;
          default: timeTaken.setText(newState.toString());  
        }
      }
    });

    // layout the controls.
    HBox controls = HBoxBuilder.create().spacing(10).children(new Label("Location"), location, go, timeTaken).build();
    HBox.setHgrow(location, Priority.ALWAYS);
    timeTaken.setMinWidth(120);

    // layout the scene.
    VBox layout = new VBox(10);
    layout.setStyle("-fx-padding: 10; -fx-background-color: cornsilk; -fx-font-size: 20px;");
    layout.getChildren().addAll(controls, instructions);
    stage.setTitle("Page load timing");
    stage.getIcons().add(new Image("http://icons.iconarchive.com/icons/aha-soft/perfect-time/48/Hourglass-icon.png"));
    stage.setScene(new Scene(layout, 1000, 110));
    stage.show();

    // trigger loading the default page.
    go.fire();
  }
}