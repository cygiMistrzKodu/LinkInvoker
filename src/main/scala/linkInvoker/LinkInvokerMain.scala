package linkInvoker

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.control.Label
import scalafx.scene.layout.BorderPane
import scalafx.scene.layout.StackPane
import scalafx.scene.control.TextField
import scalafx.scene.Node
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.control.Button
import scalafx.scene.layout.VBox
import scalafx.geometry.Pos
import scalafx.scene.layout.HBox
import scalafx.scene.text.Font
import scala.io.Position
import scalafx.scene.text.TextAlignment
import scalafx.event.ActionEvent
import scalafx.Includes._
import javafx.beans.value.ChangeListener
import scalafx.beans.value.ObservableValue

object LinkInvokerMain extends JFXApp {
  //      def  main(args: Array[String]): Unit = {

  //      val linkCreator = new LinkCreator("mr Robot",1,4, 1, 10)
  //      val links = linkCreator.getLinks

  //     Gui.main(Array())

  //    a.main(args: _ *)

  //    new LinkSender(links)

  //      for (link <- links) println(link)

  //    }

  stage = new PrimaryStage() {

    title = "Link Invoker"

    val seasonRangeChooserHbox = new HBox {

      spacing = 6
      alignment = Pos.Center

      val fromSeasonLabel = new Label("From: ") {
        font = Font.font(15)
      }
      val beginSeasonNumberInput = new TextField {
        text = deafultNumber
        prefWidth = getInputPrefSize
        alignment = textAligment
      }

      val toSeasonLabel = new Label("To: ") {
        font = Font.font(15)
      }
      val endSeasonNumberInput = new TextField {
        text = deafultNumber
        prefWidth = getInputPrefSize
        alignment = textAligment
      }

      children = Seq(fromSeasonLabel, beginSeasonNumberInput, toSeasonLabel, endSeasonNumberInput)

    }

    val seasonChooser = new VBox {

      spacing = 6
      alignment = Pos.Center

      val seasonName = new Label("Seasons choose") {
        font = Font.font(18)
      }

      children = Seq(seasonName, seasonRangeChooserHbox)
    }

    val episodeRangeChooserHbox = new HBox {

      spacing = 6
      alignment = Pos.Center

      val fromEpisodeLabel = new Label("From: ") {
        font = Font.font(15)
      }
      val beginEpisodeNumberInput = new TextField {
        text = deafultNumber
        prefWidth = getInputPrefSize
        alignment = textAligment
        text.onChange {
          
          (o: ObservableValue[_ <: String , _ <: String], oldVal: String, newVal: String) => {  //First Solution to Handel WIRD THING With Parameters
            
             println("Mamusika")
             
              println("new value:" + newVal)
        
               println("old value:" + oldVal)
            
          }
           
//          def dupa(ab: ObservableValue[String, String], a: String, b: String): Unit = {
//            println("DUpa DUp Dupa dupa")
//
//          }

          //          if (text.get.isEmpty()){
          //             text = deafultNumber
          //          }
          
           
          
//           println("lala")

        }

      }
      
      
      beginEpisodeNumberInput.textProperty().addListener((observable,oldValue,newValue) => { // Second Solution to Handel Event WIth Parameters
        
//        println("new value:" + oldValue)
//        
//        println("old value:" + newValue)
        
      })
      
      
      

      val toEpisodeLabel = new Label("To: ") {
        font = Font.font(15)
      }
      val endEpisodeNumberInput = new TextField {
        text = deafultNumber
        prefWidth = getInputPrefSize
        alignment = textAligment
      }

      val seasonName = new Label("Seasons choose")

      children = Seq(fromEpisodeLabel, beginEpisodeNumberInput, toEpisodeLabel, endEpisodeNumberInput)

    }

    val episdoeChooser = new VBox {

      spacing = 6
      alignment = Pos.Center

      val episdoeName = new Label("Episode choose") {
        font = Font.font(18)
      }

      children = Seq(episdoeName, episodeRangeChooserHbox)
    }

    val rangeChooser = new VBox {

      spacing = 6
      alignment = Pos.Center

      val serialNameLabel = new Label("Input Movie Name") {
        font = Font.font(20)

      }
      val movieNameInput = new TextField {
        spacing = 10
        alignment = textAligment
      }

      val sendRequestButton = new Button("Send") {
        prefWidth = 100
        prefHeight = 50
        font = Font.font(20)
      }

      children = Seq(serialNameLabel, movieNameInput, seasonChooser, episdoeChooser, sendRequestButton)
    }

    scene = new Scene(460, 280) {

      resizable = false

      root = new StackPane {

        children = Seq(rangeChooser)

      }

    }

  }

  def getInputPrefSize: Double = 120

  def textAligment: Pos = Pos.CENTER

  def deafultNumber: String = "1"

//  def dupa(ab: ObservableValue[String, String], a: String, b: String): Unit = {
//    println("DUpa DUp Dupa dupa")
//
//  }

}
