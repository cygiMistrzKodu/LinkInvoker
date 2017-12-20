package linkInvoker

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.layout.BorderPane
import scalafx.geometry.Insets
import scalafx.scene.control.Label

class Gui extends JFXApp  {
  
  stage = new PrimaryStage{
    scene = new Scene {
      root = new BorderPane {
        padding = Insets(25)
        center = new Label("Hello SBT")
        
      }
    }
  }
  
}