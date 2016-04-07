/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;


import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;



import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream; 


public class LPRecibirProductosReclamados extends LPSICCBase {
          
    public LPRecibirProductosReclamados() {
         super();
    }
           
    public void inicio() throws Exception {
    }
           
    public void ejecucion() throws Exception {
         setTrazaFichero();

        try {
            traza("*** HSH Entrada -  LPRecibirProductosReclamados - ejecucion ***");
            conectorAction("LPRecibirProductos");
            conectorActionParametro("accion", "");  
            traza("*** HSH Salida -  LPRecibirProductosReclamados - ejecucion ***");
        } catch (Exception e) {
            e.printStackTrace();
            logStackTrace(e);
            lanzarPaginaError(e); 
        }
    }

    private void logStackTrace(Throwable e) throws Exception {
         traza("Se produjo la excepcion: " + e.getMessage());             
         ByteArrayOutputStream baos = new ByteArrayOutputStream();
         PrintStream ps = new PrintStream(baos);
         e.printStackTrace(ps);           
         traza("Stack Trace: " + baos.toString());
    }
}