/**
  * Describe only user statement and behavior
  *
  * Created by randy on 03.01.16.
  */
class User(userName: String) {
  // user name field
  val userName_ = userName

  // user identefication field
  val uid_       = new UID

  // user services filed
  val userService_ = scala.collection.mutable.Map[String, Service]()

  def infoUser(): Unit = {
    println(userName_)
    userService_ foreach {case (key, value) => println ("--> " + value.description_)}
    println()
  }

  def addService(sid: Service) {
    userService_ += (sid.sid_.getHash(sid.name_) -> sid)
  }

  def delService(sid: Service) {
    userService_ -= sid.sid_.getHash(sid.name_)
  }
}
