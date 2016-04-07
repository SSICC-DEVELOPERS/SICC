/**
 * Copyright 2007 � por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * Espa�a
 *
 * Privado y Confidencial.
 * La informaci�n contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permiti�ndose
 * la distribuci�n de este c�digo sin permiso expreso.
 */

public class LPAsignacionManualProductosAnaqueles extends LPSICCBase {
    
    public LPAsignacionManualProductosAnaqueles() {
        super();
    }
    
    public void inicio() throws Exception {
        
    }
    
    public void ejecucion() throws Exception {
        try {
            conectorAction("LPMantenerAsignacionManualProductos");
            conectorActionParametro("accion", "");
            conectorActionParametro("opcionMenu", "asignar");
        } catch (Exception e) {
            e.printStackTrace();
            lanzarPaginaError(e);
        }
    }

}

