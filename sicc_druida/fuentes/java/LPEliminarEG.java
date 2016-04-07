import LPSICCBase;
import es.indra.sicc.util.DTOError;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.HashMap;
import es.indra.sicc.cmn.presentacion.rastreador.Rastreador;
import es.indra.sicc.cmn.presentacion.rastreador.IRastreador;
import es.indra.mare.common.mgu.manager.Property;

import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;

import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.IBelcorpError;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.DTOPais;
import es.indra.sicc.dtos.seg.DTOInternacional;

import java.sql.Date;
import es.indra.mare.common.mii.MareCredentials;
import java.util.*;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.exception.MareException;

import es.indra.druida.DruidaBase;
import es.indra.druida.DruidaConector;
import es.indra.druida.dom.DruidaDOMObjeto;

import java.util.Vector;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.w3c.dom.DOMException;
import es.indra.sicc.util.xml.XMLDocument;

// $Id: LPEliminarEG.java,v 1.1 2009/12/03 18:43:05 pecbazalar Exp $
public class LPEliminarEG extends LPSICCBase // extender de LPSICCBase
{
  private final String LP_NAME = "LPEliminarEG";
  public LPEliminarEG() {
    super();
  }

  public void inicio() throws Exception
  {
    pagina("contenido_PantallaConfirmacionEG");
  }

  public void ejecucion() throws Exception
  {
	setTrazaFichero();
    String accion = "";

    accion = conectorParametro("accion");
    if (accion == null)  accion = "";
      
    traza("accion: " + accion);
    
    try
    {
        if ( accion.equals("") )  // Accio Vacio
        {
          traza("Accion Vacio");
		  // Rastreo
		  this.rastreo();

        } else if(accion.equals("aceptar")){
          traza("Accion aceptar");  

          MareBusinessID bussID = new MareBusinessID("ZONEliminarEstructuraGeopolitica");
          DTOPais dtoEntrada = new DTOPais();
          Vector vParams = new Vector(); 
          
          dtoEntrada.setPais( UtilidadesSession.getPais(this) );
          dtoEntrada.setIpCliente( UtilidadesBelcorp.getIPCliente(this) );
          dtoEntrada.setPrograma( UtilidadesSession.getFuncion(this) );

          // Setea los paramétros
          vParams.add(dtoEntrada);
          vParams.add(bussID);

          traza("Antes de llamar a conectar");          
          DruidaConector con = conectar("ConectorModificarEG", vParams);
          traza("Despues de llamar a conectar");
          asignarAtributo("VAR", "accion", "valor", accion);
          asignarAtributo("VAR", "exito", "valor", "SI");
          traza("Todo ok!");
          //conectorAction("LPEliminarEG"); 

        } else if(accion.equals("volver") )
        {
          // Este método llama siempre a LPInicioBelcorp.
          // La lógica de LPInicioBelcorp se encarga de enviar al 
          // usuario a su pantalla de inicio correspondiente.
          traza("accion volver");
          conectorAction("LPInicioBelcorp");
/*        String pantallaInicio = getPantallaInicioAsociada();
          traza("pantallaInicio: " + pantallaInicio);
          if (pantallaInicio == null)
          {
            traza("PantallaInicio es null");
            conectorAction("LPInicioBelcorp");
          } else
          {
            traza("Pantalla de inicio en sesion: " + pantallaInicio.toString() );
            conectorAction(pantallaInicio);
          }*/    
          
        }
    } catch (Exception ex)
    {
          ByteArrayOutputStream stack = new ByteArrayOutputStream();
          PrintStream out = new PrintStream(stack);
          ex.printStackTrace(out);
          this.lanzarPaginaError(ex);
		  traza("EXCEPCION:" + stack.toString());
		  /* Patricio Peralta 23/01/2004 uso de this.lanzarPaginaError(ex)
		  
          BelcorpError belcorpError = new BelcorpError();
          Long codPais = UtilidadesSession.getPais(this);
          Long codIdioma = UtilidadesSession.getIdioma(this);
          
          DTOError dtoError = belcorpError.obtenerError(ex, codIdioma.toString(), codPais.toString() );
		
          traza("codigo:"+dtoError.getCodigoError());
          traza("descricption:"+dtoError.getDescripcionError() );

          asignarAtributo("VAR","conectorAction", "valor", LP_NAME );
          asignarAtributo("VAR","accion", "valor", accion );
          asignarAtributo("VAR","errCodigo", "valor", ""+ dtoError.getCodigoError());
          asignarAtributo("VAR","errDescripcion", "valor",dtoError.getDescripcionError() );
          */
		  }      
    }

	private String getPantallaInicioAsociada() throws Exception
	{
		HashMap propiedades  = (HashMap) conectorParametroSesion("propiedades");

		if ( propiedades == null || propiedades.size()==0 )
			return null;
 		Property pantallaInicio = (Property) propiedades.get("PantallaInicioAsociada");
		if ( pantallaInicio == null || pantallaInicio.getValue() == null)
		   return null;
	  traza("propiedades.toString(): " + propiedades.toString() );
    
		return (String)pantallaInicio.getValue();
    
	}

}