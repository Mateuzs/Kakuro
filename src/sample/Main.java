
package sample;

        import javafx.application.Application;
        import javafx.fxml.FXMLLoader;
        import javafx.geometry.Pos;
        import javafx.scene.Group;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.control.Label;
        import javafx.scene.control.PasswordField;
        import javafx.scene.control.TextField;
        import javafx.scene.layout.*;
        import javafx.scene.paint.Color;
        import javafx.scene.text.Font;
        import javafx.scene.text.FontWeight;
        import javafx.scene.text.Text;
        import javafx.stage.Stage;
        import javafx.scene.control.Button;
        import javafx.event.ActionEvent;
        import javafx.event.EventHandler;

        import static java.lang.Math.random;
        import javax.sound.sampled.Line;
        import javafx.geometry.Insets;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{



        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));


        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Fira Code", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);


        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        Button btn = new Button("Sign in");
        btn.setId("button");
        HBox hbBtn = new HBox(10);
        hbBtn.setId("button");
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);


        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {

                System.out.println(userTextField.getCharacters());
                System.out.println(pwBox.getCharacters());
                //ColorfulCircles circles = new ColorfulCircles();
                //circles.start(primaryStage);

            }
        });


        Scene scene = new Scene(grid, 300, 275);
        scene.getStylesheets().add("sample/Login.css");
        primaryStage.setTitle("Hello World");
        scenetitle.setId("welcome-text");
        primaryStage.setScene(scene);


        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
