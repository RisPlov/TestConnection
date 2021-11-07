import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Window_authentication extends JFrame {
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "root";
    public static final String URL = "jdbc:mysql://localhost:3306/test_schema";

    static JLabel logLabel = new JLabel("Введите логин: ");/// указание ввода  логина
    static JLabel passLabel = new JLabel("Введите пароль: ");/// указание ввода пароля
    static final JTextField login = new JTextField(12);///  текстовое поле логина
    static final JPasswordField password = new JPasswordField(12);///текстовое поле пароля
    static JButton ok = new JButton("OK ");/// кнопка ок
    static JButton cancel = new JButton("Cancel ");/// конпка отмена
    static final JTextField mistake = new JTextField(" ");/// текстовое поле сообщающее об ошибке

    Window_authentication() {
        super("My database"); //Заголовок окна
        setBounds(600, 400, 600, 400);//размер и положение
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //это нужно для того чтобы при закрытии окна закрывалась и программа, иначе она останется висеть в процессах
        logLabel.setSize(150, 100);
        logLabel.setLocation(20, 40);
        passLabel.setSize(150, 100);
        passLabel.setLocation(20, 100);
        login.setSize(150, 25);
        login.setLocation(300, 80);
        password.setEchoChar('*');
        password.setSize(150, 25);
        password.setLocation(300, 140);
        ok.setSize(60, 30);
        ok.setLocation(300, 200);
        cancel.setSize(100, 30);
        cancel.setLocation(400, 200);
        mistake.setSize(300, 30);
        mistake.setLocation(200, 250);
        JPanel contents = new JPanel(null);
        contents.add(passLabel);
        contents.add(logLabel);
        contents.add(password);
        contents.add(login);
        contents.add(ok);
        contents.add(cancel);
        contents.add(mistake);
        setContentPane(contents);//// создание окна со всеми элементами

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String log = login.getText();
                char[] p = password.getPassword();
                String pa = String.valueOf(p);
                int pas = Integer.parseInt(pa);

                try (Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD)) {
                    System.out.println("Connection to Store DB successfully!");

                    Statement statement = conn.createStatement();
                    ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
                    String login = null;
                    int password = 0;
                    while (resultSet.next()) {
                        login = resultSet.getString(2);
                        password = resultSet.getInt(3);
                        if (log.equals(login)&(pas==password)) {mistake.setText("Добро пожаловать!");break;}
                    }
                    if (!log.equals(login)|(pas!=password)) {mistake.setText("Данные введены не верно, попробуйте еще раз.");conn.close();}///проверить закрывается ли соединенение
                }
                catch (Exception ex) {
                    System.out.println("Connection failed!!!!..");
                }
            }
        });
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);////закрытие программы
            }
        });
    }
}