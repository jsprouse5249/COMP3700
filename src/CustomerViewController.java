//import javax.swing.*;
//
//public class CustomerViewController {

//}

import com.google.gson.Gson;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerViewController {
    private JPanel mainPanel;
    private JTextField customerIDTF;
    private JTextField customerNameTF;
    private JTextField customerPhoneNumberTF;
    private JButton loadCustomerButton;
    private JButton saveCustomerButton;

    private Client client;

    public CustomerViewController(Client client) {
        this.client = client;

        loadCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String customerID = customerIDTF.getText();
                Message message = new Message(Message.LOAD_CUSTOMER, customerID);
                client.sendMessage(message);
            }
        });

        saveCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Customer customer = new Customer();

                customer.setCustomerID(Integer.parseInt(customerIDTF.getText()));
                customer.setName(customerNameTF.getText());
                customer.setPhoneNumber(Integer.parseInt(customerPhoneNumberTF.getText()));

                Gson gson = new Gson();

                String customerString = gson.toJson(customer);

                Message message = new Message(Message.SAVE_CUSTOMER, customerString);
                client.sendMessage(message);
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void updateCustomerInfo(Customer customer) {
        customerIDTF.setText(String.valueOf(customer.getCustomerID()));
        customerNameTF.setText(customer.getName());
        customerPhoneNumberTF.setText(String.valueOf(customer.getPhoneNumber()));
    }
}

