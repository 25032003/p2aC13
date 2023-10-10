package edu.umg.ui;

import edu.umg.datos.UsuarioJDBC;
import edu.umg.domain.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;


public class LoginUsuario extends JFrame {
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel resultLabel;

    public LoginUsuario() {
        setTitle("Login de Usuario");
        setSize(750, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2));

        label1 = new JLabel("Usuarios preterminados:");
        label2 = new JLabel("User:         Password:");
        label3 = new JLabel("Paco:          carro");
        label4 = new JLabel("Jefferson:     niña");
        label5 = new JLabel("Brandon:       jajaja");


        usernameField = new JTextField();
        JLabel usernameLabel = new JLabel("Usuario:");
        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordField = new JPasswordField();
        loginButton = new JButton("Iniciar sesión");
        resultLabel = new JLabel();

        panel.add(label1);
        panel.add(new JLabel()); // Espacio en blanco
        panel.add(label2);
        panel.add(new JLabel()); // Espacio en blanco
        panel.add(label3);
        panel.add(new JLabel()); // Espacio en blanco
        panel.add(label4);
        panel.add(new JLabel()); // Espacio en blanco
        panel.add(label5);
        panel.add(new JLabel()); // Espacio en blanco
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(resultLabel);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Usuario check = new Usuario();
                check.setUsername(usernameField.getText());
                check.setPassword(new String(passwordField.getPassword()));

                UsuarioJDBC usuarioJDBC = new UsuarioJDBC();
                try {
                    boolean isAuthenticated = usuarioJDBC.autenticarUsuario(check);
                    if (isAuthenticated) {
                        resultLabel.setText("Inicio de sesión exitoso.");
                    } else {
                        resultLabel.setText("Inicio de sesión fallido.");
                    }
                } catch (SQLException | NoSuchAlgorithmException ex) {
                    ex.printStackTrace();
                }
            }
        });

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LoginUsuario frame = new LoginUsuario();
                frame.setVisible(true);
            }
        });
    }
}