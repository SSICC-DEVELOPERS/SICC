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

//import LPSICCBase;
import es.indra.druida.DruidaBaseComun;
import es.indra.mare.common.exception.MareException;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class LPConsultarMatrizDescuentos extends LPSICCBase{
    public LPConsultarMatrizDescuentos(){
    }

    public void inicio() throws Exception{
    }

    public void ejecucion() throws Exception{
        this.rastreo();
        setTrazaFichero();
        try{
            String sAccion = conectorParametro("accion") != null ? conectorParametro("accion") : "";
            if(sAccion.equals("")){
                conectorAction("LPMantenimientoMatrizDescuentos");
                conectorActionParametro("accion", "buscar");
                conectorActionParametro("casodeuso", "consultar");
            }
        }
        catch(Exception exception){
            logStackTrace(exception);
            lanzarPaginaError(exception);
        }
    }

    private void logStackTrace(Throwable throwable) throws Exception{
        traza("Se produjo la excepcion: " + throwable.getMessage());
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        PrintStream printstream = new PrintStream(bytearrayoutputstream);
        if(throwable instanceof MareException){
            MareException mareexception = (MareException)throwable;
            traza("Es una mare Exception con codigo de error: " + mareexception.getCode());
        }
        throwable.printStackTrace(printstream);
        traza("stack Trace : " + bytearrayoutputstream.toString());
    }
}
