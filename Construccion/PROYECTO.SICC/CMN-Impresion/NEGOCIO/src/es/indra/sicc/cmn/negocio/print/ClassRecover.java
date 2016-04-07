/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */

package es.indra.sicc.cmn.negocio.print;

import es.indra.mare.common.exception.MareException;

//import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DocumentoFAC;



public class ClassRecover {
    public ClassRecover() {
    }

    public static Class recoverClassForName(String s)
        throws MareException {
        try {
          
            Class class1 = null;
            class1 = Class.forName(s);

            return class1;
        } catch (Exception ex) {
            throw new MareException("recoverClassForName",ex);
        }
    }

    public static Object recoverInstanceForName(String s)
        throws MareException {
        try {
           

            Class class1 = null;
            class1 = Class.forName(s);

			return class1.newInstance();
        } catch (Exception ex) {
            throw new MareException("recoverInstanceForName",ex);
        }
    }
}
