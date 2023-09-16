package sys.bean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.PrimeFaces;
import sys.dao.UsuarioDAO;
import sys.impl.UsuarioDAOImpl;
import sys.modelo.Usuario;

@ManagedBean
@Named(value = "loginBean")
@SessionScoped

public class LoginBean implements Serializable {

    private Usuario usuario;
    private String nombreUsuario;
    private String password;

    public LoginBean() {
        this.usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void login() {
        FacesMessage message = null;
        boolean loggedIn = false;
        String ruta = "";

        UsuarioDAO datos = new UsuarioDAOImpl();
        this.usuario = datos.login(usuario);

        if (this.usuario != null) {
            loggedIn = true;

            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido al sistema", this.usuario.getNombreUsuario());
            ruta = "/FacturationRelsB/faces/views/Bienvenido.xhtml";
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de acceso", "Usuario o contraseña incorrectos");
            usuario = new Usuario();
        }

        FacesContext.getCurrentInstance().addMessage(null, message);
        PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
        PrimeFaces.current().ajax().addCallbackParam("ruta", ruta);

    }

    public String logout() {
        this.nombreUsuario = null;
        this.password = null;
        HttpSession httpsession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        httpsession.invalidate(); // borrar sesion
        return "/Login";

    }

}
