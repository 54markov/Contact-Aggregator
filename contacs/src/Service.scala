/**
  * Created by randy on 03.01.16.
  */
class Service(serviceName: String, serviceDescription: String) {
  val name_ : String = serviceName // service name field
  val description_ : String = serviceName + ":" + serviceDescription  // service description field
  val sid_ = new SID// service identefication field
}
