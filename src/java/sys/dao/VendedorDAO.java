
package sys.dao;

import java.util.List;
import sys.modelo.Vendedor;

public interface VendedorDAO {
    
    public List<Vendedor> select();
    public void insert(Vendedor vendedor);
    public void update(Vendedor vendedor);
    public void delete(Vendedor vendedor);
}
