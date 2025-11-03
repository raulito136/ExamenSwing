package org.example.ui;

import org.example.context.ContextService;
import org.example.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

/**
 * Clase que contiene todo lo relativo a la pantalla Principal del programa
 * @author Raúl López Palomo
 */
public class Principal extends JFrame {
    private JPanel principal;
    private JTextField tfCorreo;
    private JComboBox cbPais;
    private JComboBox cbPlataforma;
    private JButton btnGuardar;
    private JTable tabla;
    private JButton btnCerrar;
    private JLabel lblInfo;

    DefaultTableModel modelo;
    ArrayList<Usuario> usuarios=new ArrayList<>();

    public Principal(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Examen Swing");
        this.setResizable(false);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setContentPane(principal);

        tfCorreo.setText("ejemplocorreo@gmail.com");
        crearTabla();
        initListeners();


    }

    /**
     * Metodo el cual es llamado por el Main para abrir esta pantalla
     */
    public void start(){
        this.setVisible(true);
    }

    /**
     * Metodo que se encarga de crear la tabla
     */
    private void crearTabla(){
        modelo = new DefaultTableModel(null,new Object[]{"Correo","Pais","Plataforma"});
        tabla.setModel(modelo);
    }

    /**
     * Metodo que se encarga de iniciar todos los listeners
     */
    private void initListeners(){
        btnGuardar.addActionListener(e -> {
            String correo = tfCorreo.getText();
            String pais = cbPais.getSelectedItem().toString();
            String plataforma = cbPlataforma.getSelectedItem().toString();
            if (correo.isEmpty() || pais.isEmpty() || plataforma.isEmpty()){
                lblInfo.setText("ERROR: Por favor ingrese todos los campos");
            }else{
                Usuario usuario = new Usuario(correo, pais, plataforma);
                usuarios.add(usuario);
                modelo.addRow(new Object[]{correo,pais,plataforma});
                lblInfo.setText("El usuario se ha añadido correctamente");
            }
        });
        btnCerrar.addActionListener(e -> {
            System.exit(0);
        });


        tabla.getSelectionModel().addListSelectionListener(e -> {
           if (!e.getValueIsAdjusting() && tabla.getSelectedRow() >= 0){
               Usuario usuario = usuarios.get(tabla.getSelectedRow());
               // Utilizamos un ContextService para mandarle el usuario seleccionado a Detalle
               ContextService.getInstance().addItem("usuarioSeleccionado", usuario);
               // Abrimos la pantalla de Detalle para ver los detalles del usuario previamente seleccionado
               new Detalle(this).setVisible(true);
           }
        });
    }

}
