package Views

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.layout.{GridPane, HBox, Priority}
import javafx.scene.text.Text
import javafx.stage.Stage



object Intro
{
  def main(args: Array[String])
  {
    Application.launch(classOf[Intro], args: _*)
  }
}


class Intro extends Application {

  def createButton(text :String): HBox = {

    val button = new Button
    button.setText(text)
    button.setId("Button")


    val container = new HBox(button)
    container.setId("ButtonContainer")
    HBox.setHgrow(button, Priority.ALWAYS)


    container
  }

  def createText(inputText: String): HBox ={

    val text = new Text(inputText)
    text.setId("IntroText")

    val container = new HBox(text)
    container.setId("ButtonContainer")

    container
  }





  def generateIntroBox(): GridPane = {

    val gridPane = new GridPane



    gridPane.add(createText("KAKURO MY DEAR!"), 1, 0)
    gridPane.add(createButton("PLAY"), 1, 1)
    gridPane.add(createButton("SCORES"), 1, 2)
    gridPane.add(createButton("QUIT"), 1, 3)
    gridPane.add(createText(""), 1, 4)




    gridPane
  }


  def generateScene(gridPane: GridPane): Scene = {

    val scene = new Scene(gridPane, 400, 400)

    scene
  }


  override def start(primaryStage: Stage)
  {

    val root = generateIntroBox
    val scene = generateScene(root)
    scene.getStylesheets.add("Views/styles.css")
    primaryStage.setScene(scene)
    primaryStage.show()

  }

}