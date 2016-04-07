package es.indra.sicc.cmn.presentacion.cache;

import java.util.Map;

/** 
 * <p>Title: Cache</p>
 * <p>Description: Esta interfaz proporciona metodos para manipular una cache</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Indra</p>
 * @author Gonzalo Herreros González
 * @version 1.0
 */
public interface Cache{
	Object put(String key, Object value);
	Object get(String key);
	void putAll(Map map);
	boolean containsKey(String key);
	boolean containsValue(Object value);
	void remove(String key);
	void clear();
}
