import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerViewController {
    private JPanel mainPanel;
    private JTextArea messageTextArea;
    private JButton manageCheckoutButton;
    private JButton manageProductButton;
    private JButton manageCustomerButton;
    private JButton manageOrderButton;
    private JButton loginButton;

    private ProductViewController productViewController;
    private OrderViewController orderViewController;
    private CustomerViewController customerViewController;
    private LoginView loginView;

    public ManagerViewController(Client client) {
        this.productViewController = new ProductViewController(client);
        this.customerViewController = new CustomerViewController(client);
        this.orderViewController = new OrderViewController(client);
        this.loginView = new LoginView(client);

        manageProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Manage Product");
                frame.setContentPane(productViewController.getMainPanel());
                frame.setMinimumSize(new Dimension(800, 400));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });

        manageOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Manage Order");
                frame.setContentPane(orderViewController.getMainPanel());
                frame.setMinimumSize(new Dimension(800, 400));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });

        manageCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Manage Customer");
                frame.setContentPane(customerViewController.getMainPanel());
                frame.setMinimumSize(new Dimension(800, 400));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Login");
                frame.setContentPane(loginView.getMainPanel());
                frame.setMinimumSize(new Dimension(800, 400));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
