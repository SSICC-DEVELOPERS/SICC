import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.intsys.DTOCargaInicialInterfaz;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.UtilidadesSession;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Vector;
import es.indra.sicc.util.DTOOID;

public class LPRecepcionarFuenteVentasPrevistas extends LPSICCBase
{

    private String accion;
    private String casoUso;
    private Long idioma;
    private Long pais;

    public LPRecepcionarFuenteVentasPrevistas()
    {
        accion = "";
        casoUso = null;
        idioma = null;
        pais = null;
    }

    public void inicio()
        throws Exception
    {
    }

    public void ejecucion()
        throws Exception
    {
        setTrazaFichero();
        rastreo();
        traza("*** Entrada - LPRecepcionarFuenteVentasPrevistas - ejecucion ***");
        try
        {
            accion = conectorParametroLimpia("accion", "", true);
            idioma = UtilidadesSession.getIdioma(this);
            pais = UtilidadesSession.getPais(this);
            if(accion.equals(""))
            {
                cargarDatosIniciales();
            } else
            if(accion.equals("recepcionar"))
            {
                recepcionar();
            }
        }
        catch(Exception exception)
        {
            logStackTrace(exception);
            lanzarPaginaError(exception);
        }
        traza("*** Salida - LPRecepcionarFuenteVentasPrevistas - ejecucion ***");
    }

    private void cargarDatosIniciales()
        throws Exception
    {
        traza("*** Entrada - LPRecepcionarFuenteVentasPrevistas - cargarDatosIniciales ***");
        pagina("contenido_estimados_MAV_activacion_recepcionar");
        DTOString dtostring = new DTOString();
        dtostring.setOidIdioma(idioma);
        dtostring.setOidPais(pais);
        dtostring.setCadena("SAB-11");
        MareBusinessID marebusinessid = new MareBusinessID("INTCargaInicialInterfaz");
        Vector vector = new Vector();
        vector.add(dtostring);
        vector.add(marebusinessid);
        DruidaConector druidaconector = conectar("ConectorObjeto", vector);
        DTOCargaInicialInterfaz dtocargainicialinterfaz = (DTOCargaInicialInterfaz)druidaconector.objeto("DTOSalida");
        String s = "N/A";//dtocargainicialinterfaz.getNumeroLote().toString();
        String s1 = dtocargainicialinterfaz.getDescripcion();
        asignar("CTEXTO", "Descripcion", s1);
        asignar("LABELC", "lblvalorLote", s);
        asignar("VAR", "hNumeroLote", "0");
        this.asignarAtributoElemento("areatxtObservaciones","visible","N");
        asignar("VAR", "casoUso", "LPRecepcionarFuenteVentasPrevistas");
        asignarAtributo("PAGINA", "contenido_estimados_MAV_activacion_recepcionar", "cod", "01054");
        asignarAtributo("PAGINA", "contenido_estimados_MAV_activacion_recepcionar", "msgle", "Recepcionar Fuente de Ventas previstas (Manual)");
        getConfiguracionMenu("LPRecepcionarFuenteVentasPrevistas", "");
        traza("*** Entrada - LPRecepcionarFuenteVentasPrevistas - cargarDatosIniciales ***");
    }

    private void recepcionar()
        throws Exception
    {
        traza("*** Entrada - LPRecepcionarFuenteVentasPrevistas - recepcionar ***");
        try{
            pagina("salidaGenerica");
            DTOOID dtoOid = new DTOOID();
            dtoOid.setOid(UtilidadesSession.getPais(this));
            traza("Pais: "+dtoOid.getOid());
            traza("*** Antes de valObserv *** ");
            String s = conectorParametro("areatxtObservaciones");
            String s1 = conectorParametro("Descripcion");
            traza("*** valObserv *** " + s);
            traza("*** valDescLote *** " + s1);
            MareBusinessID marebusinessid = new MareBusinessID("INTRecepcionarFuenteVentasPrevista");
            traza("marebusinessid: "+marebusinessid.getBusinessID());
            Vector vector = new Vector();
            vector.add(dtoOid);
            vector.add(marebusinessid);
            conectar("ConectorRecepcionarEstimadosVentas", vector);
        }catch(Exception e) {
            logStackTrace(e);
            lanzarPaginaError(e);
        }finally {
            asignarAtributo("VAR", "ejecutar", "valor", "cerrarVentana()");
        }
        traza("*** Entrada - LPRecepcionarFuenteVentasPrevistas - recepcionar ***");
    }

    private void logStackTrace(Throwable throwable)
        throws Exception
    {
        traza("Se produjo la excepcion: " + throwable.getMessage());
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        PrintStream printstream = new PrintStream(bytearrayoutputstream);
        throwable.printStackTrace(printstream);
        traza("Stack Trace: " + bytearrayoutputstream.toString());
    }
}
