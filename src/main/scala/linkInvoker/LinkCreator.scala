package linkInvoker

class LinkCreator(private val movieName: String , private val startNumberOfSeason: Int, private val endNumberOfSeason: Int,private val startNumberOfEpisode: Int ,private val endNumberOfEpisode: Int) {
  
  
  def getLinks()  =  {
    
    val baseUrl = "https://rarbgmirror.org/torrents.php"

    val questionMark = "?"

    
    
    val parameterName = "search"

    val equals = "="

    val plus = "+"
    
    val seasonPrefix = "S"
    
    val episodePrefix = "E"
    
    
     val urls = 
        for (seasonNumber <- startNumberOfSeason to endNumberOfSeason) yield {
          
          for (episodeNumber <- startNumberOfEpisode to endNumberOfEpisode) yield  {

            baseUrl + questionMark + parameterName + equals + changeSpacesToPlusSign(movieName) + plus + seasonPrefix + formatNumber(seasonNumber) + episodePrefix + formatNumber(episodeNumber)
          }
        }
    
    urls.flatten
    
  }
  
  
  def formatNumber(number: Int): String = if (number <= 9) "0" + number else number toString

  def changeSpacesToPlusSign(text: String) = text.replace(" ", "+")
}