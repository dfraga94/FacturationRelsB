
package sys.dao;

import java.util.List;
import sys.modelo.Cliente;


public interface ClienteDAO {
    
    public List<Cliente> select();
    public void insert(Cliente cliente);
    public void update(Cliente cliente);
    public void delete(Cliente cliente);
}
