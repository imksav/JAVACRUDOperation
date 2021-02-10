package src;

import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame {
     public Login() {
          JFrame frame = new JFrame();
          frame.setTitle("Login");
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.setSize(200, 300);
          frame.setResizable(false);

          frame.setLocationRelativeTo(null);
          // designing the login window frame
          JPanel loginPanel = new JPanel();
          loginPanel.setLayout(new FlowLayout());
          loginPanel.setBackground(Color.MAGENTA);
          JLabel heading = new JLabel("Welcome to Khata.com");
          JLabel username = new JLabel("USERNAME:");
          JLabel password = new JLabel("PASSWORD:");
          JTextField usernameTextField = new JTextField(10);
          JPasswordField passwordField = new JPasswordField(10);
          JButton loginBtn = new JButton("Login");
          JButton signupBtn = new JButton("Sign up");
          loginPanel.add(heading);
          loginPanel.add(username);
          loginPanel.add(usernameTextField);

          loginPanel.add(password);
          loginPanel.add(passwordField);
          loginPanel.add(loginBtn);
          loginPanel.add(signupBtn);
          frame.add(loginPanel);
          // login button functionality starts here of login window frame
          loginBtn.addActionListener(new ActionListener() {

               @Override
               public void actionPerformed(ActionEvent e) {
                    if (e.getSource().equals(loginBtn)) {
                         if ("admin".equals(usernameTextField.getText()) && "admin".equals(passwordField.getText())) {
                              new HomePage();
                              frame.dispose();
                         } else {
                              JOptionPane.showMessageDialog(loginBtn, "Incorrect Username or Password", "Login Denied",
                                        JOptionPane.WARNING_MESSAGE);
                         }
                    }

               }

          });
          frame.setVisible(true);

     }
}
