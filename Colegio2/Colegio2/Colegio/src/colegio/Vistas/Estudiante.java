package colegio.Vistas;

import javax.swing.*;
import java.awt.*;

public class Estudiante extends JFrame {
    private JTable tablaTareas;
    private JScrollPane scrollPane;
    
    public Estudiante() {
        initComponents();
        setTitle("Vista de Estudiante");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true); // Asegurar que la ventana se muestre
    }
    
    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        JLabel titulo = new JLabel("Tareas Asignadas", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(titulo, BorderLayout.NORTH);
        
        String[] columnas = {"ID", "Título", "Descripción"};
        Object[][] datos = {};
        
        tablaTareas = new JTable(datos, columnas);
        scrollPane = new JScrollPane(tablaTareas);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        add(panel);
    }
}
