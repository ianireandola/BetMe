package LN;

/**
 * Clase que gestiona excepciones 
 * @author Martin Router King
 *
 */
public class ExcepcionDeporte extends Exception {
	
	private static final long serialVersionUID = 1L;
	protected static final String MENSAJE = "No existe ningún deporte con ese nombre";
	
	@Override
	public String getMessage() 
	{
		return MENSAJE;
	}

	@Override
	public String toString() 
	{
		return MENSAJE;
	}
	

}
