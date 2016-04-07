/*
 * Created on 05-mar-2004
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package es.indra.utils;

import java.lang.reflect.Method;

/**
 * @author gogomez
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class MSOUtils {
	
	/**
	 * Nos permite copiar del mso source al destination todos los valores
	 * @param source El mso con los datos que se queiren copiar
	 * @param destination El mso donde se van a copiar
	 * @throws Exception SI se produce algún error con la reflection
	 */
	public static void copyMso(Object source, Object destination) throws Exception{
		Class objClass = source.getClass();
		Method[] methods = objClass.getDeclaredMethods();
		for (int i = 0; i < methods.length; i++) {
			//Seguimos si unicamente es un getter
			if(!methods[i].getName().startsWith("get")) continue;

			//Sacamos el nombre de la prodpiedad y los métodos get y set
			String propertyName = methods[i].getName().substring(3);
			Method get = methods[i];
			Method set = null;
			try{
				set = objClass.getMethod("set" + propertyName, new Class[]{get.getReturnType()});
			}catch (NoSuchMethodException e) {
				continue;
			}
			set.invoke(destination, new Object[]{get.invoke(source, new Object[]{})});
		}
	}
}
