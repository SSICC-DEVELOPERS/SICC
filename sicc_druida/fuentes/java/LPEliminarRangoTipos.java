import LPSICCBase;
import es.indra.druida.DruidaBase;
import es.indra.druida.DruidaConector;
import es.indra.druida.dom.DruidaDOMObjeto;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.presentacion.rastreador.IRastreador;
import es.indra.sicc.cmn.presentacion.rastreador.Rastreador;
import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.IBelcorpError;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.xml.XMLDocument;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class LPEliminarRangoTipos extends LPSICCBase {  
    
    public LPEliminarRangoTipos() { super(); }

    public void inicio() throws Exception { }

    public void ejecucion() throws Exception {
      setTrazaFichero();
      traza(" * * * Entre a LPEliminarRangoTipos * * *");
      String accion  = conectorParametro("accion");
      
      if(accion==null) accion = "";
      traza(" * * * accion = " + accion);
      
      try {
        if (accion.equals("")) {        
          traza(" * * * Llamando a LPMantenimientoRangoTipos * * *");
          conectorAction("LPMantenimientoRangoTipos");
          conectorActionParametro("casoDeUso", "Eliminar");
          conectorActionParametro("accion","");                
        }
      }
      catch (Exception ex) {
        ByteArrayOutputStream stack = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(stack);
        ex.printStackTrace(out);
        traza("* * * EXCEPCION:" + stack.toString());
        
        this.lanzarPaginaError(ex);
      }      
    }  
  }
