package colegio.Modelos;
public class Usuario {
    protected int id;
    protected String nombre;
    protected String correo;
    protected String contraseña;
    protected String rol;

    public Usuario(int id, String nombre, String correo, String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
        this.rol = (rol != null) ? rol : "Estudiante"; // Evita null
    }
    
    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getContraseña() { return contraseña; }
    public void setContrasena(String contrasena) { this.contraseña = contrasena; }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre='" + nombre + '\'' + ", correo='" + correo + '\'' + '}';
    }
    
}
