/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
/*
    INDRA/CAR/PROY
    $Id: LPModificarGruposZonas.java,v 1.1 2009/12/03 18:40:32 pecbazalar Exp $
    DESC
*/
import LPSICCBase;

import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.DTOError;
 
public class LPModificarGruposZonas extends LPSICCBase  {
    String accion=null;
    String casoDeUso = null;
    // Definicion del constructor
    public LPModificarGruposZonas() {
        super();    
    }

    // Definicion del metodo abstracto inicio
    public void inicio() throws Exception {
    }

    // Definicion del metodo abstracto ejecucion
    public void ejecucion() throws Exception {

        this.rastreo();
        setTrazaFichero();

        /*accion = this.conectorParametroLimpia("accion", "", true);
        casoDeUso = this.conectorParametroLimpia("casoDeUso", "", true);*/

        try {

            if (accion==null||accion.equals("")){	
                casoDeUso = "modificar";
                accion = "muestraModificacion";
                traza("Accion: "+accion+" - Caso de Uso: "+casoDeUso);
                conectorAction("LPMantieneGruposZonas");
                conectorParametroSesion("casoDeUso",casoDeUso);
                conectorActionParametro("accion",accion);
            }
            
        } catch (Throwable ex) {
            traza("exception: " + ex);
            java.io.StringWriter sw = new java.io.StringWriter();
            java.io.PrintWriter pw = new java.io.PrintWriter(sw);
            ex.printStackTrace(pw);
            pw.flush();
            traza("trace:"+sw);

            BelcorpError belcorpError = new BelcorpError();
            DTOError dtoError = belcorpError.obtenerError(ex);

       }
    }
}
