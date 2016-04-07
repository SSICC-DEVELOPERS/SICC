package es.indra.utils;

import org.exolab.castor.jdo.*;
//import org.exolab.castor.jdo.engine.DatabaseImpl;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.naming.InitialContext;

import java.io.*;
import java.lang.reflect.Method;

/**
 * Esta clase contiene varias utilidades para Castor JDO (dentro del contenedor J2EE)
 *
 * @author Indra Sistemas, S.A. (CPSI)
 * @version 1.0
 */
public final class JDOUtils {

    /*static JDO jdo;

    static {

        try {            
            JDO.loadConfiguration(Config.get("/castor/config/file"));
            jdo = new JDO(Config.get("/castor/config/dbName"));
            jdo.setTransactionManager(Config.get("/castor/config/transactionManager"));
            //jdo.setLogWriter(new PrintWriter(System.out));
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }*/

    /**
     * Devuelve una referencia a la base de datos
     * @return La referencia a la base de datos
     */
    /*public static Database getDatabase() throws Exception {
        return jdo.getDatabase();
    }*/

	/**
	 * Ejecuta una consulta
	 * @param db La base de datos
	 * @param oql La sentencia oql a ejecutar
	 * @param parameters Parámetros de la consulta oql
	 */
	/*public static Vector query(Database db, String oql, Vector parameters) throws Exception {
                return query(db, oql, parameters, null, 1, Integer.MAX_VALUE);		
	}
*/
	/**
	 * Ejecuta una consulta
	 * @param db La base de datos
	 * @param oql La sentencia oql a ejecutar
	 * @param parameters Parámetros de la consulta oql
	 */
	/*public static Vector query(Database db, String oql, Vector parameters, int pageCount, int pageSize) throws Exception {
		return query(db, oql, parameters, null, pageCount, pageSize);		
	}*/

	/**
	 * Ejecuta una consulta
	 * @param db La base de datos
	 * @param oql La sentencia oql a ejecutar
	 * @param parameters Parámetros de la consulta oql
	 * @param userProperties Propiedades de usuario
	 */
	/*public static Vector query(Database db, String oql, Vector parameters, HashMap userProperties) throws Exception {
		return query(db, oql, parameters, userProperties, 1, Integer.MAX_VALUE);		
	}*/

    /**
     * Ejecuta una consulta
     * @param db La base de datos
     * @param oql La sentencia oql a ejecutar
     * @param parameters Parámetros de la consulta oql
     * @param userProperties Propiedades de usuario
     * @param pageCount Número de página a devolver
     * @param pageSize Tamaño de la página
     */
 /*   public static Vector query(Database db, String oql, Vector parameters, HashMap userProperties, int pageCount, int pageSize) throws Exception {

    		Vector rs = new Vector();


        OQLQuery oqlQuery = db.getOQLQuery(oql);
        
        for (int i = 0; i < parameters.size(); i++) {
            oqlQuery.bind(parameters.elementAt(i));
        }        

        QueryResults results = oqlQuery.execute();

        for (int i = 0; i < (pageCount - 1) * pageSize; i++) {
            if (results.hasMore()) results.next();
            else break;   
        }        

        // Devuelve un registro más para que el cliente sepa si existen más páginas
        for (int i = 0; i < ((pageSize == Integer.MAX_VALUE) ? pageSize : (pageSize + 1)); i++) {
            if (results.hasMore()) rs.add(results.next());
            else break;   
        }

        return rs;
    }*/
    
	/*public static void update(java.lang.Object object) throws Exception {
		Database db = getDatabase();
  	try {
	  	// Refrescar dependencias
   		((Persistent) object).jdoPersistent(db);

		  // Cargar objeto de la base de datos
		  Class objectClass = object.getClass();
		  Method getIdMethod = objectClass.getDeclaredMethod("getId", null); 
		  Long id = (Long) getIdMethod.invoke(object, null);
		  Object persistentObject = db.load(objectClass, id);
				
			//Copiamos los datos del nuevo al actualizado
			MSOUtils.copyMso(object, persistentObject);
	   }finally {
		   db.close();   
	   }
   }*/
   
/*	public static void update(java.lang.Object object, Database db ) throws Exception {
		// Refrescar dependencias
   	((Persistent) object).jdoPersistent(db);

	 	// Cargar objeto de la base de datos
 		Class objectClass = object.getClass();
 		Method getIdMethod = objectClass.getDeclaredMethod("getId", null); 
 		Long id = (Long) getIdMethod.invoke(object, null);
 		Object persistentObject = db.load(objectClass, id);
				
   	//Copiamos los datos del nuevo al actualizado
   	MSOUtils.copyMso(object, persistentObject);
	}   */ 
}
