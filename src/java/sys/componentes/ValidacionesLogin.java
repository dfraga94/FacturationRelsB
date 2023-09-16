package sys.componentes;

import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.validation.Valid;

@FacesValidator("vlogin")
public class ValidacionesLogin implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        String nombreUsuario = value.toString().trim();
        if (nombreUsuario.length() == 0) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Ingrese el usuario"));
        
        } else {
            String expresionLetras="^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ]+$";
            boolean aceptable=Pattern.matches(expresionLetras, nombreUsuario);
            if (!aceptable) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Ingrese solo letras"));
                
            }
        }
    }

}
