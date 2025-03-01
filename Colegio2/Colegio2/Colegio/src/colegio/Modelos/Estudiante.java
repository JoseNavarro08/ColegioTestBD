package colegio.Modelos;
public class Estudiante extends Usuario {
    private String grado;

    public Estudiante(int id, String nombre, String correo, String contrasena, String grado) {
        super(id, nombre, correo, contrasena);
        this.grado = grado;
    }

    public String getGrado() { return grado; }
    public void setGrado(String grado) { this.grado = grado; }
}
