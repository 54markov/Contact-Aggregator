/**
  * Created by randy on 03.01.16.
  */

import java.security.MessageDigest;

class UID {
  def getHash(stringToEncrypt: String): String = {
    // implementation of hash function
    val messageDigest = MessageDigest.getInstance("SHA-256")

    messageDigest.update(stringToEncrypt.getBytes())

    val encryptedString = new String(messageDigest.digest());

    return encryptedString
  }
}
