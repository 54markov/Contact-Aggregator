/**
  * Created by Markov V.A on 14.05.17.
  */
import java.security.MessageDigest

class SID {
  def getHash(stringToEncrypt: String): String = {
    new String( { val messageDigest = MessageDigest.getInstance("SHA-256")
      messageDigest.update(stringToEncrypt.getBytes())
      messageDigest.digest() } )
  }
}
