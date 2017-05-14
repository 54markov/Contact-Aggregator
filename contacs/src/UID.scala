/**
  * Created by randy on 14.05.17.
  */
import java.security.MessageDigest

class UID {
  def getHash(stringToEncrypt: String): String = {
    new String(
      {
        val messageDigest = MessageDigest.getInstance("SHA-256")
        messageDigest.update(stringToEncrypt.getBytes())
        messageDigest.digest()
      }
    )
  }
}
