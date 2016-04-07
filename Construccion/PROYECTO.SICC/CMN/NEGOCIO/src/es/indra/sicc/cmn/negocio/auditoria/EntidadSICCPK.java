package es.indra.sicc.cmn.negocio.auditoria;

import java.lang.reflect.*;

public class EntidadSICCPK implements java.io.Serializable {
	
	public String toString() {
		String str = "";
		Class c = this.getClass();
		Field[] publicFields = c.getFields();
		for (int i = 0; i < publicFields.length; i++) {
         String fieldName  = publicFields[i].getName();
         try {
           String fieldValue = publicFields[i].get(this).toString();
           str = str + "(" + fieldName + "=" + fieldValue + ")";
         } catch (Exception e) {
           e.printStackTrace();
         }
         /*Class typeClass = publicFields[i].getType();
         String fieldType = typeClass.getName();
         str = str + "(Name: " + fieldName + ", Type: " + fieldType + ")";*/
         
    }
    return str;
	}
}