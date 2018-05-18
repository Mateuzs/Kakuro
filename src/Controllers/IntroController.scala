package Controllers

import javafx.event.{ActionEvent, EventHandler}
import javafx.stage.Stage

import Views.Kakuro

class IntroController extends App{



  def playBtnHandlerEvent(stage: Stage): EventHandler[ActionEvent] = {


    val handler = new EventHandler[ActionEvent] {

      def handle(e: ActionEvent): Unit = {


        val kakuroBoard: Kakuro = new Kakuro

        kakuroBoard.start(stage)

      }
    }


    handler
  }
}