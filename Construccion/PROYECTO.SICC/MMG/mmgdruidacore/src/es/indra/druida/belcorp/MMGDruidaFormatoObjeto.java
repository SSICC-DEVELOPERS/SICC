/*
 * Created on 09-mar-2004
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package es.indra.druida.belcorp;

import java.util.HashMap;

import es.indra.druida.DruidaDataBase;
import es.indra.druida.DruidaFormatoObjeto;
import es.indra.druida.parser.jaxpv11;

/**
 * @author gogomez
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public abstract class MMGDruidaFormatoObjeto extends DruidaFormatoObjeto implements MMGDruidaDataBaseEnabled{
	
	/**
	 * El objeto data base asociado al formater
	 */
	protected DruidaDataBase dataBase;
	
	public MMGDruidaFormatoObjeto(){
		super();
		this.dataBase = null;
	}
	
	/**
	 * Nos permite obtener el hasmap con los atributos del usuario
	 * @return
	 * @throws MMGNoSessionException Si la sesión a espirado o no están definidos los parámetros de los usuarios
	 */
	protected HashMap getUserProperties() throws MMGNoSessionException{
		HashMap userProperties = (HashMap)conectorParametroSesion("propiedades");
		if(userProperties == null) throw new MMGNoSessionException();
		else return userProperties;
	}

	/**
	 * @return
	 */
	public DruidaDataBase getDruidaDataBase() {
		if(this.dataBase == null) dataBase = new DruidaDataBase(getRequest(), new jaxpv11());
		return dataBase;
	}

}
