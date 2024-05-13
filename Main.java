import javax.swing.*;//creating gui components such as buttons, text fields, labels, and panels.
import java.awt.*;//for layout
import java.awt.event.ActionEvent;// just for Action of buttons
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    // Instance of UserAccountManager to handle user accounts
    private UserAccountManager accountManager;
    // Text fields for username and password input
    private JTextField usernameField;
    private JPasswordField passwordField;
    // Label to display status messages
    private JLabel statusLabel;
    // Panels for user authentication and payment options
    private JPanel userPanel;
    private JPanel paymentPanel;
    // Label to display balance
    private JLabel balanceLabel;
    // Instance of AddMoney class for adding money functionality
    private AddMoney addMoney;
    // Instance of FareCalculation class for calculating fare
    private FareCalculation fareCalculation;

    // Constructor
    public Main() {
        // Initialize components and display welcome dialog
        accountManager = new UserAccountManager();
        addMoney = new AddMoney();
        fareCalculation = new FareCalculation();
        initializeComponents();
        showWelcomeDialog();
    }

    // Method to display welcome dialog
    private void showWelcomeDialog() {
        JOptionPane.showMessageDialog(null, "Welcome to Metro Payment System", "Welcome", JOptionPane.PLAIN_MESSAGE);
        setVisible(true);
    }

    // Method to initialize GUI components
    private void initializeComponents() {
        setTitle("Metro Payment System");//The title of the window
        setSize(1280, 720);// size of the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// performs exit operation
        setLocationRelativeTo(null);// ensures that the window appears in the center of the screen
        setLayout(new CardLayout());// layout of the window

        createUserPanel(); // Create user authentication panel
        createPaymentPanel(); // Create payment options panel

        add(userPanel, "UserPanel");
        add(paymentPanel, "PaymentPanel");

        // Initially, only the user panel is visible
        paymentPanel.setVisible(false);
    }

    // Method to create user authentication panel
    private void createUserPanel() {
        userPanel = new JPanel(new GridBagLayout());//for layout
        userPanel.setBackground(new Color(184, 246, 184, 255));//for coloring
        GridBagConstraints gbc = new GridBagConstraints();//for the grid layout
        gbc.insets = new Insets(10, 10, 10, 10);//Setting the size of the grid

        // Username field
        gbc.gridx = 0;//setting the position on the x axis
        gbc.gridy = 0;//setting the position on the y axis
        userPanel.add(new JLabel("Username:"), gbc);//adding a label
        gbc.gridx = 1;//setting the position on the x axis
        usernameField = new JTextField(15);//taking input from the user
        userPanel.add(usernameField, gbc);//adding the input field

        // Password field
        gbc.gridx = 0;//setting the position on the x axis
        gbc.gridy = 1;//setting the position on the y axis
        userPanel.add(new JLabel("Password:"), gbc);//adding a label
        gbc.gridx = 1;//setting the possition for input field
        passwordField = new JPasswordField(15);//taking input from the user
        userPanel.add(passwordField, gbc);//adding the input field

        // Login button
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        JButton loginButton = new JButton("Login");
        loginButton.setActionCommand("Login");
        loginButton.addActionListener(this);
        userPanel.add(loginButton, gbc);

        // Sign Up button
        gbc.gridy = 3;
        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setActionCommand("Sign Up");
        signUpButton.addActionListener(this);
        userPanel.add(signUpButton, gbc);

        // Status label
        gbc.gridy = 4;//the row number
        statusLabel = new JLabel();//display status message to the user
        userPanel.add(statusLabel, gbc);//adding the input field
    }

    // Method to create payment options panel
    private void createPaymentPanel() {
        paymentPanel = new JPanel(new GridBagLayout());//new option for payment panel
        paymentPanel.setBackground(new Color(173, 216, 230));//color
        GridBagConstraints gbc = new GridBagConstraints();//for grid layout
        gbc.insets = new Insets(5, 10, 5, 10);//adjuting the size of the grid
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;//filling the grid horizontally

        // Add Money button
        JButton addMoneyButton = new JButton("Add Money");//creating a button
        addMoneyButton.setActionCommand("Add Money");//setting the action command
        addMoneyButton.addActionListener(this);//adding action listener to the button
        paymentPanel.add(addMoneyButton, gbc);//adding the button to the panel for payment

        // Pay Bill button
        gbc.gridy++; //increasing the row number
        JButton payBillButton = new JButton("Pay Bill");//creating a button
        payBillButton.setActionCommand("Pay Bill");// setting the action command
        payBillButton.addActionListener(this);//adding action listener to the button
        paymentPanel.add(payBillButton, gbc);//adding action listener to the button

        // View Balance button
        gbc.gridy++;
        JButton viewBalanceButton = new JButton("View Balance");
        viewBalanceButton.setActionCommand("View Balance");
        viewBalanceButton.addActionListener(this);
        paymentPanel.add(viewBalanceButton, gbc);

        // Balance label
        gbc.gridy++;
        balanceLabel = new JLabel("");
        paymentPanel.add(balanceLabel, gbc);
    }

    // ActionListener implementation for handling button clicks
    @Override //overriding the method of interface
    public void actionPerformed(ActionEvent e)//parameter e contains the action performed by the user
     {
        String command = e.getActionCommand(); //getting the action command
        if ("Login".equals(command)) //checking if the action command is login
        {
            // Attempting login
            String username = usernameField.getText().trim();//getting the username and leading and trailing spaces are removed
            String password = new String(passwordField.getPassword());//getting the password
            boolean loggedIn = accountManager.login(username, password);//checking if the user is logged in
            if (loggedIn) {
                // If login successful, switch to payment panel
                statusLabel.setText("Login successful.");
                userPanel.setVisible(false);
                paymentPanel.setVisible(true);
            } else {
                statusLabel.setText("Invalid username or password.");
            }
        } else if ("Sign Up".equals(command))//checking if the action command is sign up
         {
            // Attempting sign up
            String username = usernameField.getText().trim();//getting the username and leading and trailing spaces are removed 
            String password = new String(passwordField.getPassword());//getting the password
            String email = ""; 
            String fullName = "";
            String phoneNumber = "";
            boolean signUpSuccess = accountManager.signUp(username, password, email, fullName, phoneNumber);//checking if true or false
            if (signUpSuccess) {
                statusLabel.setText("Sign-up successful. Please log in.");
            } else {
                statusLabel.setText("Sign-up failed. Please try again.");
            }
        } else if ("Add Money".equals(command))//checking if the action command is add money
         {
            // Adding money
            String amountString = JOptionPane.showInputDialog(this, "Enter amount to add:");//taking input from the user
            try //using try catch block to handle exceptions
            {
                double amount = Double.parseDouble(amountString);//converting the string to double
                if (amount > 0) {
                    addMoney.addBalance(amount);
                    JOptionPane.showMessageDialog(this, "Amount added successfully.");
                } else {
                    JOptionPane.showMessageDialog(this, "Please enter a positive amount.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid amount.");
            }
        } else if ("Pay Bill".equals(command)) {
            // Paying bill
            fareCalculation.Location(); 
            double fare = fareCalculation.setFare();
            if (addMoney.getBalance() >= fare) {
                addMoney.deductBalance(fare);
                JOptionPane.showMessageDialog(this, "Balance deducted: " + fare);
            } else {
                JOptionPane.showMessageDialog(this, "Insufficient balance to pay the bill.");
            }
        } else if ("View Balance".equals(command)) {
            // Viewing balance
            double balance = addMoney.getBalance(); 
            JOptionPane.showMessageDialog(this, "Current balance: " + balance);
        }
    }

    // Main method to launch the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main());//starting the application
    }
}
