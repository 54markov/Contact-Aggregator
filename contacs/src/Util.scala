/**
  * Created by user on 23.06.17.
  */
class Util {
  def find(user: Option[User]) : String = {
    user match {
      case None => "Report: User not found"
      case Some(user) => "Report: User found" + "\n" + user.getInfo
    }
  }
}
