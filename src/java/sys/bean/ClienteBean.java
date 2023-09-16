package sys.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
  import javax.faces.bean.ViewScoped;
import sys.dao.ClienteDAO;
import sys.impl.ClienteDAOImpl;
import sys.modelo.Cliente;

@ManagedBean   //Controlador
@Named(value = "clienteBean")
@ViewScoped
public class ClienteBean {

    private Cliente cliente = null;
    private List<Cliente> clientes = null;

    public ClienteBean() {
    }

    //Establecer las acciones sobre la vista
    public List<Cliente> getClientes() {
        ClienteDAO datos = new ClienteDAOImpl();
        this.clientes = datos.select();
        return clientes;
    }

    public void prepareCliente() {
        this.cliente = new Cliente(); 
    }

    public void insertCliente() {
        ClienteDAO datos = new ClienteDAOImpl();
        datos.insert(cliente);
    }

    public void updateCliente() {
        ClienteDAO datos = new ClienteDAOImpl();
        datos.update(cliente);
        this.cliente = new Cliente();
    }

    public void deleteCliente() {
        ClienteDAO datos = new ClienteDAOImpl();
        datos.delete(cliente);
        this.cliente = new Cliente();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

}
