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

  stage = new PrimaryStage() {

    title = "Link Invoker"

    val seasonRangeChooserHbox = new HBox {

      spacing = 6
      alignment = Pos.Center

      val fromSeasonLabel = new Label("From: ") {
        font = Font.font(15)
      }
      val beginSeasonNumberInput: TextField = new TextField {
        text = deafultNumber
        prefWidth = getInputPrefSize
        alignment = textAligment

        text.onChange {
          (o: ObservableValue[_ <: String, _ <: String], oldVal: String, newVal: String) =>

            allowOnlyNumbersAndChangeFirstDigitZeroToOne(this, oldVal, newVal)
            endSeasonNumberInput.setText(ifBeginRangeHigerChangeEndRangeToHiger(text.get, endSeasonNumberInput.getText))

        }

        focused.addListener((o, oldVal, newVal) => {

          changeToDefultValueIfEmpty(this)
          text = ifRangeIncorrectFix(text.get, endSeasonNumberInput.getText)

        })
      }

      val toSeasonLabel = new Label("To: ") {
        font = Font.font(15)
      }
      val endSeasonNumberInput: TextField = new TextField {
        text = deafultNumber
        prefWidth = getInputPrefSize
        alignment = textAligment

        text.onChange {
          (o: ObservableValue[_ <: String, _ <: String], oldVal: String, newVal: String) =>

            allowOnlyNumbersAndChangeFirstDigitZeroToOne(this, oldVal, newVal)

        }

        focused.addListener((o, oldVal, newVal) => {

          changeToDefultValueIfEmpty(this)

          beginSeasonNumberInput.setText(ifRangeIncorrectFix(text.get, beginSeasonNumberInput.getText))

        })

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
      val beginEpisodeNumberInput : TextField = new TextField {
        text = deafultNumber
        prefWidth = getInputPrefSize
        alignment = textAligment
        text.onChange {
          (o: ObservableValue[_ <: String, _ <: String], oldVal: String, newVal: String) =>

            allowOnlyNumbersAndChangeFirstDigitZeroToOne(this, oldVal, newVal)
            endEpisodeNumberInput.setText(ifBeginRangeHigerChangeEndRangeToHiger(text.get, endEpisodeNumberInput.getText))

        }

        focused.addListener((o, oldVal, newVal) => {

          changeToDefultValueIfEmpty(this)
          text = ifRangeIncorrectFix(text.get, endEpisodeNumberInput.getText)

        })

      }

      val toEpisodeLabel = new Label("To: ") {
        font = Font.font(15)
      }
      val endEpisodeNumberInput: TextField = new TextField {
        text = deafultNumber
        prefWidth = getInputPrefSize
        alignment = textAligment

        text.onChange {
          (o: ObservableValue[_ <: String, _ <: String], oldVal: String, newVal: String) =>

            allowOnlyNumbersAndChangeFirstDigitZeroToOne(this, oldVal, newVal)

        }

        focused.addListener((o, oldVal, newVal) => {

          changeToDefultValueIfEmpty(this)
          beginEpisodeNumberInput.setText(ifRangeIncorrectFix(text.get, beginEpisodeNumberInput.getText))

        })

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

        onAction = (event: ActionEvent) => {

          val movieName = movieNameInput.getText
          val seasonStart = seasonRangeChooserHbox.beginSeasonNumberInput.getText.toInt
          val seasonEnd = seasonRangeChooserHbox.endSeasonNumberInput.getText.toInt
          val episodeStart = episodeRangeChooserHbox.beginEpisodeNumberInput.getText.toInt
          val episodeEnd = episodeRangeChooserHbox.endEpisodeNumberInput.getText.toInt

          if (!movieName.isEmpty()) {

            val linkCreator = new LinkCreator(movieName, seasonStart, seasonEnd, episodeStart, episodeEnd)
            val links = linkCreator.getLinks
            new LinkSender(links)
          }

        }

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

  private def getInputPrefSize: Double = 120

  private def textAligment: Pos = Pos.CENTER

  private def deafultNumber: String = "1"

  private def allowOnlyNumbersAndChangeFirstDigitZeroToOne(textField: TextField, oldVal: String, newVal: String): Unit = {

    if (!newVal.matches("\\d*")) {

      textField.setText(newVal.replaceAll("[^\\d]", ""));
    }

    if (newVal.matches("0")) {

      textField.setText(deafultNumber);

    }

  }

  private def changeToDefultValueIfEmpty(tF: TextField) = if (tF.getText.isEmpty()) tF.setText(deafultNumber)

  private def ifRangeIncorrectFix(firstNumber: String, secondNumber: String): String = {

    if (secondNumber.isEmpty()) return firstNumber

    if (firstNumber.isEmpty() || secondNumber.isEmpty()) return ""

    if (firstNumber.toInt > secondNumber.toInt) secondNumber else firstNumber

  }

  private def ifBeginRangeHigerChangeEndRangeToHiger(beginRange: String, endRange: String): String = {

    if (beginRange.isEmpty()) return endRange

    if (beginRange.toInt > endRange.toInt) beginRange else endRange

  }

}
