/**
  * Created by Markov V.A on 14.05.17.
  */
object ContactAgregator {
  def main(args: Array[String]) {
    val testDrawer  = new AbstractDrawer
    val testStorage = new AbstractStorage
    val testManager = new UserManager(testStorage)

    testDrawer.initMainForm(testManager)
    testDrawer.displayMainWindow
  }
}
