import com.google.gson.Gson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView {
    public JPanel getMainPanel() {
        return mainPanel;
    }

    private JPanel mainPanel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton newUserButton;
    private JButton loginButton;
    private Client client;

    private NewUserViewController newUserViewController;
    private ManagerViewController managerViewController;

    public LoginView(Client client) {
        this.client = client;
        this.newUserViewController = new NewUserViewController(client);
        this.managerViewController = new ManagerViewController(client);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                Account account = new Account(username, password);

                Gson gson = new Gson();
                String accountString =  gson.toJson(account);
                Message message = new Message(Message.LOGIN, accountString);
                client.sendMessage(message);

                JFrame frame = new JFrame("Manage Store");
                frame.setContentPane(managerViewController.getMainPanel());
                frame.setMinimumSize(new Dimension(800, 400));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });

        newUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("New User");
                frame.setContentPane(newUserViewController.getMainPanel());
                frame.setMinimumSize(new Dimension(800, 400));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
