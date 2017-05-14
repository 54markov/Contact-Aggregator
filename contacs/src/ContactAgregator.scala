/**
  * Created by randy on 14.05.17.
  */
import javax.swing._
import java.awt.event._

object ContactAgregator {

  def find(user: Option[User]) : String = {
    user match {
      case None => "Report: User not found"
      case Some(user) => "Report: User found" + "\n" + user.getInfo
    }
  }

  def main(args: Array[String]) {

    val addUserButton = new JButton("Add User")
    val addServiceButton = new JButton("Add Service")
    val delUserButton = new JButton("Del User")
    val showUserButton = new JButton("Show User")

    val addUserText = new JTextArea()
    val delUserText = new JTextArea()
    val showUserText = new JTextArea()

    val addServiceUserText = new JTextArea()
    val addServiceNameText = new JTextArea()
    val addServiceURLText = new JTextArea()

    val commonText = new JTextArea()

    val panel = new JPanel()

    panel.setLayout(null)

    val testStorage = new AbstractStorage()
    val testManager = new UserManager(testStorage)

    /* Adding-service button */
    addServiceButton.addActionListener(new ActionListener() {
      def actionPerformed(e: ActionEvent) {
        val newUser = new User(addServiceUserText.getText())
        commonText.setText(null)

        val newService = new Service(addServiceNameText.getText(), addServiceURLText.getText())

        commonText.append(addServiceUserText.getText()+"\n")
        commonText.append(addServiceNameText.getText()+"\n")
        commonText.append(addServiceURLText.getText()+"\n")
        commonText.append(testManager.addService(newUser, newService))
      }
    } )

    /* Adding-user button */
    addUserButton.addActionListener(new ActionListener() {
      def actionPerformed(e: ActionEvent) {
        val newUser = new User(addUserText.getText())
        commonText.setText(null)
        commonText.append(testManager.addUser(newUser))
      }
    } )

    /* Deleting button */
    delUserButton.addActionListener(new ActionListener() {
      def actionPerformed(e: ActionEvent) {
        val newUser = new User(delUserText.getText())
        commonText.setText(null);
        commonText.append(testManager.delUser(newUser))
      }
    } )

    /* Showing button */
    showUserButton.addActionListener(new ActionListener() {
      def actionPerformed(e: ActionEvent) {
        val newUser = new User(showUserText.getText())
        commonText.setText(null);
        commonText.append(find(testManager.getUser(newUser)))
      }
    } )

    addServiceButton.setLocation(50, 10);
    addServiceButton.setSize(200, 50);

    addServiceUserText.setLocation(250, 10);
    addServiceUserText.setSize(150, 50);

    addServiceNameText.setLocation(450, 10);
    addServiceNameText.setSize(150, 50);

    addServiceURLText.setLocation(650, 10);
    addServiceURLText.setSize(150, 50);


    addUserButton.setLocation(50, 100);
    addUserButton.setSize(200, 50);

    addUserText.setLocation(250, 100);
    addUserText.setSize(200, 50);


    delUserButton.setLocation(50, 200);
    delUserButton.setSize(200, 50);

    delUserText.setLocation(250, 200);
    delUserText.setSize(200, 50)


    showUserButton.setLocation(50, 300);
    showUserButton.setSize(200, 50);

    showUserText.setLocation(250, 300);
    showUserText.setSize(200, 50);

    commonText.setLocation(500, 100);
    commonText.setSize(300, 250);

    panel.add(addServiceButton)
    panel.add(addUserButton)
    panel.add(delUserButton)
    panel.add(showUserButton)

    panel.add(addServiceNameText)
    panel.add(addServiceURLText)
    panel.add(addServiceUserText)

    panel.add(addUserText)
    panel.add(delUserText)
    panel.add(showUserText)
    panel.add(commonText)

    val frame: JFrame = new JFrame()
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)

    frame.getContentPane.add(panel)

    //Display the window


    frame.pack
    frame.setSize(1024, 768)
    frame.setVisible(true)
  }
}

