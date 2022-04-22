import com.google.gson.Gson;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView {
    public JPanel getMainPanel() {
        return mainPanel;
    }

    private JPanel mainPanel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private Client client;

    public LoginView(Client client) {
        this.client = client;

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
            }
        });
    }
}
