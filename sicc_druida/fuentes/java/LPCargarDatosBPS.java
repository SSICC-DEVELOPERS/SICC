/*
    INDRA/CAR/PROY
    $Id: LPCargarDatosBPS.java,v 1.1 2009/12/03 18:39:20 pecbazalar Exp $
    DESC
*/

//import LPSICCBase;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.Vector;

public class LPCargarDatosBPS extends LPSICCBase {
    String accion;

    public LPCargarDatosBPS()  {
        super();
    }

    public void inicio() throws Exception  {
          pagina("contenido_cargar_datos_BPS");
    }

    public void ejecucion() throws Exception  {
        try{
            rastreo();
            setTrazaFichero();
            Long pais = UtilidadesSession.getPais(this);
            Long idioma = UtilidadesSession.getIdioma(this);
            MareBusinessID id = new MareBusinessID("MAVCargarDatosBPS");
            DTOBelcorp dto = new DTOBelcorp();
            dto.setOidIdioma(idioma);
            dto.setOidPais(pais);
            Vector vec = new Vector();
            vec.add(dto);
            vec.add(id);
            conectar("ConectorCargarDatosBPS",vec);
            
        }catch(Exception e){
            lanzarPaginaError(e);
            logStackTrace(e);
        }
    }

    private void logStackTrace(Throwable e) throws Exception {
        traza("Se produjo la excepcion: " + e.getMessage());
 
        ByteArrayOutputStream pila = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(pila);
        if (e instanceof MareException) {
            MareException e2=(MareException)e;
            traza("Es una mare Exception con codigo de error: "+e2.getCode());
        }
        e.printStackTrace(out);
        traza("stack Trace : " +  pila.toString());
    }
}
