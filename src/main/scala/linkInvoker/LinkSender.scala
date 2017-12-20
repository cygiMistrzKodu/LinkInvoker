package linkInvoker

import java.awt.Desktop
import java.net.URI
import scala.collection.Seq

class LinkSender(links: Seq[String]) {

  if (Desktop.isDesktopSupported) {

    for (link <- links) {

      new Thread {
        override def run {
          Desktop.getDesktop.browse(new URI(link))
        }
      }.start()

      Thread.sleep(700)

    }

  }

}