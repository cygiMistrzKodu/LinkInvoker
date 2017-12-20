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

object LinkInvokerMain {//extends JFXApp {
      def  main(args: Array[String]): Unit = {

      val linkCreator = new LinkCreator("mr Robot",1,4, 1, 10)
      val links = linkCreator.getLinks

         
//     Gui.main(Array())

  //    a.main(args: _ *)

  //    new LinkSender(links)
      
      
      for (link <- links) println(link)

    }

//  stage = new PrimaryStage() {
//
//    val vBox = new HBox {
//
//      spacing = 6
//
//      alignment = Pos.Center
//
//      children = Seq(new Button("lalalala"), new Button("pasternak"))
//      
//     
//
//    }
//
//    scene = new Scene(300, 300) {
//
//      root = new StackPane {
//
//        children = Seq(vBox)
//
//      }
//
//    }
//
//  }

}
