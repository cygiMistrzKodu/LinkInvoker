package linkInvoker

import scala.collection.immutable.List

class UserEntryCollector {

  var movieName = "";
  var seasonStart = "1";
  var seasonEnd = "1";
  var episodeStart = "1";
  var episodeEnd = "1";

  def getUserEntriesInOrder(): List[String] = {

    val userEntries: List[String] = 
      List(movieName,seasonStart,seasonEnd,episodeStart,episodeEnd)

    userEntries
  }

}