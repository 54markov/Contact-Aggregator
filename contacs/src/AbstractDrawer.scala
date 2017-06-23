/**
  * Created by user on 23.06.17.
  */
import javax.swing._
import java.awt.event._

class AbstractDrawer extends  Util {
  private val mainFrame: JFrame = new JFrame()

  private val addUserButton    = new JButton("Add User")
  private val addServiceButton = new JButton("Add Service")
  private val delUserButton    = new JButton("Del User")
  private val showUserButton   = new JButton("Show User")
  private val closeButton      = new JButton("Quit")

  def initAddUserButton(userManager: UserManager) : Unit = {
    addUserButton.addActionListener(
      new ActionListener() {
        def actionPerformed(e: ActionEvent) {
          val frame = new JFrame()
          initSubWindowAdd(userManager, frame, "Add User")
          displaySubWindow(frame, 500, 200)
        }
      }
    )
  }

  def initAddServiceButton(userManager: UserManager) : Unit = {
    addServiceButton.addActionListener(
      new ActionListener() {
        def actionPerformed(e: ActionEvent) {
          val frame = new JFrame()
          initSubWindowAddService(userManager, frame, "Add Service")
          displaySubWindow(frame, 500, 200)
        }
      }
    )
  }

  def initDelUserButton(userManager: UserManager) : Unit = {
    delUserButton.addActionListener(
      new ActionListener() {
        def actionPerformed(e: ActionEvent) {
          val frame = new JFrame()
          initSubWindowDel(userManager, frame, "Delete User")
          displaySubWindow(frame, 500, 200)
        }
      }
    )
  }

  def initShowUserButton(userManager: UserManager) : Unit = {
    showUserButton.addActionListener(
      new ActionListener() {
        def actionPerformed(e: ActionEvent) {
          val frame = new JFrame()
          initSubWindowFind(userManager, frame, "Find User")
          displaySubWindow(frame, 500, 200)
        }
      }
    )
  }

  def initMainForm(userManager: UserManager) : Unit = {
    val panel = new JPanel()
    panel.setLayout(null)

    initAddUserButton(userManager)
    initDelUserButton(userManager)
    initAddServiceButton(userManager)
    initShowUserButton(userManager)

    addServiceButton.setLocation(50, 10)
    addServiceButton.setSize(200, 50)

    addUserButton.setLocation(50, 100)
    addUserButton.setSize(200, 50)

    delUserButton.setLocation(50, 200)
    delUserButton.setSize(200, 50)

    showUserButton.setLocation(50, 300)
    showUserButton.setSize(200, 50)

    panel.add(addServiceButton)
    panel.add(addUserButton)
    panel.add(delUserButton)
    panel.add(showUserButton)

    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    mainFrame.getContentPane.add(panel)
  }

  def initSubWindowFind(userManager: UserManager, frame : JFrame, text: String) : Unit = {
    val panel   = new JPanel()
    val button  = new JButton(text)
    val textBox = new JTextArea()

    button.setLocation(50, 10)
    button.setSize(200, 50)

    textBox.setLocation(250, 10)
    textBox.setSize(150, 150)

    textBox.setText(null)

    button.addActionListener(
      new ActionListener() {
        def actionPerformed(e: ActionEvent) {
          textBox.setText(find(userManager.getUser(new User(textBox.getText()))))
        }
      }
    )

    panel.setLayout(null)
    panel.add(button)
    panel.add(textBox)

    frame.getContentPane.add(panel)
  }

  def initSubWindowAdd(userManager: UserManager, frame : JFrame, text: String) : Unit = {
    val panel   = new JPanel()
    val button  = new JButton(text)
    val textBox = new JTextArea()

    button.setLocation(50, 10)
    button.setSize(200, 50)

    textBox.setLocation(250, 10)
    textBox.setSize(150, 50)

    textBox.setText(null)

    button.addActionListener(
      new ActionListener() {
        def actionPerformed(e: ActionEvent) {
          if (userManager.addUser(new User(textBox.getText())) == ResultOperation.OperationComplete) {
            textBox.setText("Sucsess!")
          } else {
            textBox.setText("Ops, something wrong!")
          }
        }
      }
    )

    panel.setLayout(null)
    panel.add(button)
    panel.add(textBox)

    frame.getContentPane.add(panel)
  }

  def initSubWindowDel(userManager: UserManager, frame : JFrame, text: String) : Unit = {
    val panel   = new JPanel()
    val button  = new JButton(text)
    val textBox = new JTextArea()

    button.setLocation(50, 10)
    button.setSize(200, 50)

    textBox.setLocation(250, 10)
    textBox.setSize(150, 50)

    textBox.setText(null)

    button.addActionListener(
      new ActionListener() {
        def actionPerformed(e: ActionEvent) {
          if (userManager.delUser(new User(textBox.getText())) == ResultOperation.OperationComplete) {
            textBox.setText("Sucsess!")
          } else {
            textBox.setText("Ops, something wrong!")
          }
        }
      }
    )

    panel.setLayout(null)
    panel.add(button)
    panel.add(textBox)

    frame.getContentPane.add(panel)
  }

  def initSubWindowAddService(userManager: UserManager, frame : JFrame, text: String) : Unit = {
    val panel      = new JPanel()
    val button     = new JButton(text)
    val userBox    = new JTextArea()
    val serviceBox = new JTextArea()
    val urlBox     = new JTextArea()

    button.setLocation(50, 10)
    button.setSize(200, 50)

    userBox.setLocation(250, 10)
    userBox.setSize(150, 50)

    serviceBox.setLocation(250, 70)
    serviceBox.setSize(150, 50)

    urlBox.setLocation(250, 130)
    urlBox.setSize(150, 50)

    userBox.setText(null)
    serviceBox.setText(null)
    urlBox.setText(null)

    button.addActionListener(
      new ActionListener() {
        def actionPerformed(e: ActionEvent) {
          val newUser = new User(userBox.getText())
          val newService = new Service(serviceBox.getText(), urlBox.getText())
          if (userManager.addService(newUser, newService) == ResultOperation.OperationComplete){
            userBox.setText("Sucsess!")
            serviceBox.setText(null)
            urlBox.setText(null)
          } else {
            userBox.setText("Ops, something wrong!")
            serviceBox.setText(null)
            urlBox.setText(null)
          }
        }
      }
    )

    panel.setLayout(null)
    panel.add(button)
    panel.add(userBox)
    panel.add(serviceBox)
    panel.add(urlBox)

    frame.getContentPane.add(panel)
  }

  def displayMainWindow : Unit = {
    mainFrame.pack
    mainFrame.setSize(800, 600)
    mainFrame.setVisible(true)
  }

  def displaySubWindow(frame: JFrame, width: Int, height: Int) : Unit = {
    frame.pack
    frame.setSize(width, height)
    frame.setVisible(true)
  }
}
