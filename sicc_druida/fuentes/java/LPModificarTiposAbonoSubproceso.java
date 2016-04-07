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
* 
* 
* @Autor: Paola Cabrera
* @Fecha: 17/01/2006
* @Modulo: CCC
* 
*/ 


import java.io.ByteArrayOutputStream;
import java.io.PrintStream; 
 
public class LPModificarTiposAbonoSubproceso extends LPSICCBase {

    public LPModificarTiposAbonoSubproceso() {
        super();
    }
           
    public void inicio() throws Exception {
    }

    public void ejecucion() throws Exception {
        rastreo();
        setTrazaFichero();
        traza("*** Entrada - LPModificarTiposAbonoSubproceso - ejecucion ***");
        
        try{
            
            conectorAction("LPMantenimientoTiposAbonoSubproceso"); 
            conectorActionParametro("accion", ""); 
            conectorActionParametro("opcionMenu","Modificar"); 
        
        }catch(Exception e){
        
            logStackTrace(e);
            lanzarPaginaError(e);
        
        }
        traza("*** Salida - LPModificarTiposAbonoSubproceso - ejecucion ***");
    }

    private void logStackTrace(Throwable e) throws Exception {
        traza("LPModificarTiposAbonoSubproceso Se produjo la excepcion: " + e.getMessage());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        e.printStackTrace(ps);
        traza("Stack Trace: " + baos.toString());
    }

}


