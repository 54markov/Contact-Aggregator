/**
  * Describe only user statement and behavior
  *
  * Created by randy on 03.01.16.
  */
class User(userName: String) {
  val userName_ = userName  // user name field
  val uid_ = new UID        // user identefication field

  // user services filed
  val userService_ = scala.collection.mutable.Map[String, Service]()

  def infoUser(): String = {
    var infoString = userName_ + "\n"
    userService_ foreach {case (key, value) => infoString += value.description_; infoString += "\n" }
    return  infoString
  }

  def addService(sid: Service) {
    userService_ += (sid.sid_.getHash(sid.name_) -> sid)
  }

  def delService(sid: Service) {
    userService_ -= sid.sid_.getHash(sid.name_)
  }
}
