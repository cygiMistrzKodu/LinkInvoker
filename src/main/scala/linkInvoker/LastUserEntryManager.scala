package linkInvoker

import scala.io.Source
import java.io.PrintWriter
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

class LastUserEntryManager {

 private val userEntrySaveFile = "LastEntryOfTheUser"
  
  def saveEntry(userEntryCollector: UserEntryCollector): Unit = {

    val userEntries = userEntryCollector.getUserEntriesInOrder()

    val formatedEntry = userEntries.mkString(";")

    val writer = new PrintWriter(new File(userEntrySaveFile))
    writer.write(formatedEntry)
    writer.close();

    //    val workingDir = System.getProperty("user.dir");
    //    println("Working Direcotry lala: "+ workingDir)

  }

  def getLastUserEntry(): UserEntryCollector = {

    val userEntryCollector = new UserEntryCollector;

    if (Files.exists(Paths.get(userEntrySaveFile))) {

      Source.fromFile(userEntrySaveFile).getLines().foreach(entry => {

        val splitedEntry = entry.split(";")

        userEntryCollector.movieName = splitedEntry(0)
        userEntryCollector.seasonStart = splitedEntry(1)
        userEntryCollector.seasonEnd = splitedEntry(2)
        userEntryCollector.episodeStart = splitedEntry(3)
        userEntryCollector.episodeEnd = splitedEntry(4)

      })

    }
    
    userEntryCollector
  }

}