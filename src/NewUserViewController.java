//import javax.swing.*;
//
//public class NewUserViewController {

//}

//import javax.swing.*;
//
//public class CustomerViewController {

//}

import com.google.gson.Gson;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewUserViewController {
    private JPanel mainPanel;
    private JTextField newUsernameTF;
    private JTextField newPasswordTF;
    private JTextField displayNameTF;
    private JButton saveNewUserButton;

    private Client client;

    public NewUserViewController(Client client) {
        this.client = client;

        saveNewUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewUser newUser = new NewUser();
                newUser.setUsername(newUsernameTF.getText());
                newUser.setPassword(newPasswordTF.getText());
                newUser.setDisplayName(displayNameTF.getText());
                Gson gson = new Gson();

                String newUserString = gson.toJson(newUser);

                Message message = new Message(Message.SAVE_NEW_USER, newUserString);
                client.sendMessage(message);
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}


