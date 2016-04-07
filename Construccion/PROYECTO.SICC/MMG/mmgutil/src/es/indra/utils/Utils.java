package es.indra.utils;

/**
 * @author Indra
 *
 * 
 */
public class Utils {

    public static String capitalize(String text) {
     
        if (text == null) return null;
        return text.substring(0, 1).toUpperCase() + text.substring(1);
    }

    public static String lowerize(String text) {
     
        if (text == null) return null;
        return text.substring(0, 1).toLowerCase() + text.substring(1);
    }
    
    public static String toLowerCase(String s){
    	if(s==null) return null;
    	else return s.toLowerCase(); 
    }

		public static String toUpperCase(String s){
			if(s==null) return null;
			else return s.toUpperCase(); 
		}    
}
