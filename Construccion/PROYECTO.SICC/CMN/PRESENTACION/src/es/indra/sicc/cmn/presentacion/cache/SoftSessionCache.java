package es.indra.sicc.cmn.presentacion.cache;

import es.indra.druida.DruidaBaseComun;
import java.util.*;

/** 
 * <p>Title: SoftSessionCache</p>
 * <p>Description: Hace de wrapper para objetos temporalmente guardados en session</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Indra</p>
 * @author Gonzalo Herreros González
 * @version 1.0
 */
public class SoftSessionCache implements Cache{
	private static final String PARAMETRO_CLEAN = "clean";   //El parametro que indica cuando hay que limpiar la cache
	private static final String PARAMETRO_CLEAN_OK = "true"; //Indica que indica el momento de limpiar la cache
	private static final String CACHE_SESSION = "SSCHM";    //El parametro con el que guardamos la cache en sesión

	private Map cache; //La cache que va a dar soporte a las peticiones de la lp

	/** Este el único constructor de la clase, recibe la lp que lo va a utilizar
	 * @param lp
	 */
	public SoftSessionCache(DruidaBaseComun lp){
		cargarCache(lp);

		//Si se ha solicitado una limpieza de la cache la realizamos
		if (cleanUpRequested(lp)) {
			clear();
		}			
	}
	
	/** Simplemente delega en el map con la cache
	 * @param key
	 * @param value
	 * @return
	 */
	public Object put(String key, Object value) {
		return cache.put(key, value);
	}
	
	/** Simplemente delega en el map con la cache
	 * @param key
	 * @return
	 */
	public Object get(String key) {
		return cache.get(key);
	}
	
	/** Simplemente delega en el map con la cache
	 * @param map
	 */
	public void putAll(Map map){
		cache.putAll(map);
	}
	
	/** Simplemente delega en el map con la cache
	 * @param key
	 * @return
	 */
	public boolean containsKey(String key){
		return cache.containsKey(key);
	}

	/** Simplemente delega en el map con la cache
	 * @param key
	 * @return
	 */
	public boolean containsValue(Object value){
		return cache.containsValue(value);
	}

	/** Simplemente delega en el map con la cache
	 * @param key
	 */
	public void remove(String key){
		cache.remove(key); 
	}
			
	/**
	 * Simplemente delega en el map con la cache
	 */
	public void clear() {
		cache.clear();
	}
				
	/** Obtiene la cache de la sesión o la inicializa si no existe
	 * @param lp
	 */
	private void cargarCache(DruidaBaseComun lp){
		Object object = lp.conectorParametroSesion(CACHE_SESSION);
		if (object != null && object instanceof Map) {
			cache = (Map)object;
		} else {
			cache = new HashMap();
			//Guardamos la cache que hemos credo
			lp.conectorParametroSesion(CACHE_SESSION, cache);
		}		
	}
	
	/** Comprueba si se ha indicado por parametro que se debe limpiar la cache
	 * @param lp
	 * @return
	 */
	private boolean cleanUpRequested(DruidaBaseComun lp){
		String param = lp.conectorParametro(PARAMETRO_CLEAN);
		return PARAMETRO_CLEAN_OK.equals(param);
	}
}
