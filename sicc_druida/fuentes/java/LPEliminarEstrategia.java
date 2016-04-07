import LPSICCBase;
import es.indra.druida.DruidaBaseComun;
import es.indra.mare.common.exception.MareException;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class LPEliminarEstrategia extends LPSICCBase{
    public LPEliminarEstrategia(){
    }

    public void inicio() throws Exception{
    }

    public void ejecucion() throws Exception{
        this.rastreo();
        setTrazaFichero();
        try{
            String sAccion = conectorParametro("accion") != null ? conectorParametro("accion") : "";
            if(sAccion.equals("")){
                conectorAction("LPMantenimientoEstrategias");
                conectorActionParametro("accion", "");
                conectorActionParametro("opcionMenu", "Eliminar");
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