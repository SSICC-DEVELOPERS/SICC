/*
 * Created on 29-oct-2003
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package es.indra.druida.belcorp;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import java.util.Locale;

import org.exolab.castor.jdo.ObjectModifiedException;
import org.exolab.castor.jdo.PersistenceException;

import es.indra.druida.DruidaDataBase;
import es.indra.druida.DruidaTransaction;
import es.indra.druida.parser.jaxpv11;
import es.indra.mare.common.mgu.manager.Property;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.ErrorManager;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.utils.Config;

/**
 * @author gogomez
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class MMGDruidaTransaction extends DruidaTransaction implements MMGDruidaDataBaseEnabled, MMGConstants{

	/* (non-Javadoc)
	 * @see es.indra.druida.base.ObjetoNegocio#ejecucion()
	 */
	public void ejecucion() throws Exception{
		//Simplemente inicializamos el druida data si no está inicializado
		if(this.DruidaData == null) setDruidaData(new DruidaDataBase(getRequest(), new jaxpv11()));
	}
	
	/**
	 * Constructor por defecto de la clase. 
	 */
	public MMGDruidaTransaction(){
		super();
	}
	
	/**
	 * Método que centraliza la gestíón de excepciones producidas en el servidor
	 * Analiza la excepción producida en el servidor y redurige a la pagina de error
	 * @param e
	 */
	protected void handleException(Exception e) throws Exception{
		//Sacamos la pila del error por el out y por las trazas de druida
		e.printStackTrace();
		StringWriter writer = new StringWriter();
		e.printStackTrace(new PrintWriter(writer));
		traza(writer.toString());


		//Primero sacamos la información del error
		DTOError errorInfo = (new MMGBelcorpError()).obtenerError(
			e, MMGDruidaHelper.getIdioma(this), MMGDruidaHelper.getPais(this));
			
		//Redirigimos a la pantalla que dipare la ventana de error en el cliente
		conectorAction(LP_ERROR_DIALOG_TRIGGER);
		conectorActionOpener(false);
		conectorActionParametro(ERROR_DIALOG_TRIGGER_CODE, String.valueOf(errorInfo.getCodigoError()));
		conectorActionParametro(ERROR_DIALOG_TRIGGER_DESCRIPTION, errorInfo.getDescripcionError());
		conectorActionParametro(ERROR_DIALOG_TRIGGER_SEVERITY, String.valueOf(errorInfo.getSeveridad()));
	}
	
	/**
	 * Nos permite obtener el obheto DruidaDatabase asocido al trnsaction donde se guarda toda la información asoicada
	 * al pais del usuario que está ejecutando la funcionalidad
	 * @return El DruidaDataBase asociado al transaction
	 */
	public DruidaDataBase getDruidaDataBase(){
		return this.DruidaData;
	}
	
}

