package sys.dao;

import java.util.List;
import sys.modelo.Usuario;

public interface UsuarioDAO {


    public Usuario search(Usuario usuario);

    public Usuario login(Usuario usuario);

}
