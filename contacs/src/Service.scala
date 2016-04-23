/**
  * Created by randy on 03.01.16.
  */
class Service(serviceName: String, serviceDescription: String) {
  // service name field
  val name_ : String = serviceName

  // service description field
  val description_ : String = serviceName + ":" + serviceDescription

  // service identefication field
  val sid_ = new SID
}
