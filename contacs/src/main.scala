/**
  * Created by randy on 03.01.16.
  */

object HelloWorld {
  def main(args: Array[String]) {
    println("Start my first scala project!")

    val testStorage = new AbstractStorage()
    val testManager = new UserManager(testStorage)

    val testService1 = new Service("vk.com", "my.first.page")
    val testService2 = new Service("facebook.com", "my.second.page")

    val testUser1 = new User("User1")
    val testUser2 = new User("User2")
    val testUser3 = new User("User3")

    testManager.addUser(testUser1)
    testManager.addUser(testUser2)

    testManager.delUser(testUser2)

    testManager.addService(testUser1, testService1)
    testManager.addService(testUser1, testService2)

    var foundUser = testManager.getUser(testUser1)
    if (foundUser != null) {
      foundUser.infoUser()
    } else {
      println("Report: User not found\n")
    }

    foundUser = null

    foundUser = testManager.getUser(testUser2)
    if (foundUser != null) {
      foundUser.infoUser()
    } else {
      println("Report: User not found\n")
    }
  }

}