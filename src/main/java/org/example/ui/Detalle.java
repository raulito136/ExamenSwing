package org.example.ui;

import org.example.context.ContextService;
import org.example.Usuario;

import javax.swing.*;
import java.awt.event.*;

/**
 * Clase que contiene todo lo relativo a la pantalla Detalle del programa
 * @author Raúl López Palomo
 */
public class Detalle extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JLabel lblEmail;
    private JLabel lblPais;
    private JLabel lblPlataforma;

    /**
     * Metodo contructor de la clase
     * @param parent este parametro nos sirve para el setLocationRelativeTo para que aparezca encima dela pantalla Principal
     */
    public Detalle(JFrame parent) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setSize(500,500);
        setLocationRelativeTo(parent);

        // Cogemos el usuario seleccinado que nos manda Principal
        Usuario u= (Usuario) ContextService.getInstance().getItem("usuarioSeleccionado").get();
        //Mostramos la información del usuario en pantalla
        lblEmail.setText("Correo: "+u.getEmail());
        lblPais.setText("País: "+u.getPais());
        lblPlataforma.setText("Plataforma: "+u.getPlataforma());

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });


        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}
