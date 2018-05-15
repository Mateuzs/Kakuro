
package Views

import javafx.application.Application
import javafx.geometry.Insets
import javafx.scene.Scene
import javafx.scene.control.{TextField}
import javafx.scene.layout.{GridPane}
import javafx.stage.Stage
import javafx.geometry.Pos
import javafx.scene.layout.HBox
import javafx.scene.layout.Priority
import scala.util.Random

object Kakuro
{
  def main(args: Array[String])
  {
    Application.launch(classOf[Kakuro], args: _*)
  }
}


class Kakuro extends Application
{

  def createContainer(i: Int): HBox ={


    val textField = new TextField()
    textField.setPrefHeight(400)


    i match {
      case 0 => textField.setStyle("-fx-background-color: black")
      case 1 => textField.setStyle("-fx-background-color: white")
      case _ => textField.setStyle("-fx-background-color: red")
    }

    val container = new HBox(textField)
    container.setAlignment(Pos.CENTER)
    container.setPadding(new Insets(1))
    HBox.setHgrow(textField, Priority.ALWAYS)

    container

  }

  def generateLogicBoard(rowSize:Int, colSize:Int) = {

    val board =  Array.ofDim[Int](rowSize,colSize)

    // NOT DECIDED CELL -> -1
    //BLACK 0
    //WHITE 1

    for(i <- 0 until rowSize){
      for(j <- 0 until colSize){
        board(i)(j) = -1
      }
    }

    //1. BORDERS
    //ROWS
    for(i <- 0 until colSize) {
      board(0)(i) = Random.nextInt(2) // range of {0,1}
      board(rowSize - 1)(colSize - i - 1) = board(0)(i)
      //2. ROW 2 AND N-1
      if (board(0)(i) == 1 && i != colSize - 1 && i != 0) {
        board(1)(i) = 1
        board(rowSize - 2)(colSize - i - 1) = 1
      }

    }
    //COLUMNS
    for(j <- 0 until rowSize){

      board(j)(0) = Random.nextInt(2)
      board(rowSize - j - 1)(colSize - 1) = board(j)(0)
      // 2. COLUMN 2 AND N-1
      if (board(j)(0) == 1 && j != rowSize - 1 && j != 0) {
        board(j)(1) = 1
        board(rowSize - j - 1)(colSize - 2) = 1
      }
    }

    //3 CENTER
    for(i <- 1 until colSize/2)
      if(board(rowSize/2 )(i-1) == 1) {
        board((rowSize / 2) )(i) = 0
        board(rowSize / 2 )(colSize - i - 1) = 0
      }else{
        board(rowSize / 2 )(i) = 1
        board(rowSize / 2 )(colSize - i - 1) = 1
      }


    //4. RANDOMIZE THE REST
    for(i <- 1 until (rowSize / 2)){
      for(j <- 1 until colSize) {
        if(board(i)(j) == -1) {
          board(i)(j) = Random.nextInt(2)
          board(rowSize - i - 1)(colSize - j - 1) = board(i)(j)
        }
      }
    }
    // 5. RELEASE BOUNDED WHITE CELLS
    for(i <- 1 to (rowSize / 2)){
      for(j <- 1 until (colSize - 1)) {
        if(board(i-1)(j) == 0 &&
          board(i)(j-1) == 0 &&
          board(i+1)(j) == 0 &&
          board(i)(j+1) == 0 &&
          board(i)(j) == 1) {

          board(i - 1)(j) = 1
          board(i)(j - 1) = 1
          board(i + 1)(j) = 1
          board(i)(j + 1) = 1

          board(rowSize - i  - 2)(colSize - j - 1) = 1
          board(rowSize - i  - 1)(colSize - j - 2) = 1
          board(rowSize - i )(colSize - j - 1) = 1
          board(rowSize - i  - 1)(colSize - j) = 1


        }
      }

    }

    board

  }



  def fillScene( board: Array[Array[Int]], rowSize: Int, colSize: Int): GridPane  = {

    val root = new GridPane
    for(i <- 0 until rowSize){
      for( j <- 0 until colSize){
        root.add(createContainer(board(i)(j)), j , i)
      }
    }


    root
  }



  override def start(primaryStage: Stage)
  {



    primaryStage.setTitle("KAKURO MY DEAR!")

    /*
    val btn = new Button
    btn.setText("Say 'Hello World'")
    btn.setOnAction((e: ActionEvent) => {
      println("Hello World!")
    })
    */


    val rowSize = 11
    val colSize = 10
    val logicBoard = generateLogicBoard(rowSize, colSize)
    val root = fillScene(logicBoard,rowSize,colSize)

    /// let's generate Kakuro board

    primaryStage.setScene(new Scene(root, 400, 400))
    primaryStage.show
  }

}