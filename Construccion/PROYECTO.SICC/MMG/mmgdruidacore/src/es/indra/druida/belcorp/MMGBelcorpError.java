/*
 * Created on 23-mar-2004
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package es.indra.druida.belcorp;

import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.sql.SQLException;

//import javax.transaction.RollbackException;

//import org.exolab.castor.jdo.ObjectModifiedException;
//import org.exolab.castor.jdo.PersistenceException;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.DTOError;

/**
 * @author gogomez
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class MMGBelcorpError extends BelcorpError implements MMGConstants{

	/* (non-Javadoc)
	 * @see es.indra.sicc.util.IBelcorpError#obtenerError(java.lang.Throwable, java.lang.String, java.lang.String)
	 */
	public DTOError obtenerError(Throwable e, String language, String country) {
		Throwable exception = null;
		
		//SI es una excepción de tipo InvocationTargetException es que se ha producdio una excepción en el conector ejb
		if(e instanceof InvocationTargetException){
			Throwable cause = ((InvocationTargetException )e).getTargetException();
			
			//Si la causa es una remote exception llegamos hasta el final
			if(cause instanceof RemoteException){
				while(cause != null){
					cause = ((RemoteException)cause).detail;
					if(!(cause instanceof RemoteException)) break;
				}
			}
			
			//En función del error determinamos la salida del error
			if(cause instanceof MareException) exception = cause;
			else if(cause instanceof MMGException) exception = new MareException(cause, ((MMGException)cause).getErrorCode());
			else if(cause instanceof SQLException) exception = new MareException(cause, ((SQLException)cause).getErrorCode());
			else exception = new MareException(cause, ERRORCODE_DESCONOCIDO);
		}else if(e instanceof MMGNoSessionException) exception = new MareException(e, ERRORCODE_NO_SESSION);
		else if(e instanceof MMGNoLanguageException) exception = new MareException(e, ERRORCODE_NO_USER_LANGUAGE);
		else if(e instanceof MMGException) exception = new MareException(e, ((MMGException)e).getErrorCode());
		else exception = new MareException(e, ERRORCODE_DESCONOCIDO);
		
		//Finalmente llamamos al método de la clase padre
		return super.obtenerError(exception , language, country);
	}

	/* (non-Javadoc)
	 * @see es.indra.sicc.util.IBelcorpError#obtenerError(java.lang.Throwable)
	 */
	public DTOError obtenerError(Throwable e) {
		return obtenerError(e, "es", "ES");
	}
	
	/**
	 * Nos permite transformar un eror sql en un error reconocido por mantenimientos mmg
	 * @param e La SQLException generado
	 * @return
	 */
	public int mapSQLErrorCode2mmgErrorCode(SQLException e){
		switch(e.getErrorCode()){
			case SQLERROR_UNIQUE_CONSTRAIN_VIOLATED: return ERRORCODE_UNIQUE_KEY_VIOLATED;
			default: return ERRORCODE_DESCONOCIDO;
		}
	}

}
