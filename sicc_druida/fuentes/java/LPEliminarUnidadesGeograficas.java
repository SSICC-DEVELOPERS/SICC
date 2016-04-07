import LPSICCBase;
import es.indra.sicc.util.DTOError;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.HashMap;
import es.indra.sicc.cmn.presentacion.rastreador.Rastreador;
import es.indra.sicc.cmn.presentacion.rastreador.IRastreador;
import es.indra.mare.common.mgu.manager.Property;

import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.IBelcorpError;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.DTOPais;
import es.indra.sicc.dtos.seg.DTOInternacional;
import es.indra.sicc.util.UtilidadesSession;

import java.sql.Date;
import es.indra.mare.common.mii.MareCredentials;
import java.util.*;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;

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

// $Id: LPEliminarUnidadesGeograficas.java,v 1.1 2009/12/03 18:34:23 pecbazalar Exp $
public class LPEliminarUnidadesGeograficas extends LPSICCBase // extender de LPSICCBase
{
  private final String LP_NAME = "LPEliminarUnidadesGeograficas";
  public LPEliminarUnidadesGeograficas()
  {
    super();
  }

  public void inicio() throws Exception
  {
    pagina("contenido_confirmacion");
  }

  public void ejecucion() throws Exception
  {
    setTrazaFichero();
    String accion = "";

    accion = conectorParametro("accion");
    if (accion == null)
      accion = "";
      
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
          // Aca llama al método desasignarUG del MONUnidadesGeograficas
          // pasandole como parámetro un DTOPais.
          MareBusinessID bussID = new MareBusinessID("ZONDesasignarUG");
          DTOPais dtoEntrada = new DTOPais();
          Vector vParams = new Vector(); 
          
          // Setea el DTOPais de entrada.          
          //String paisSesion = getPais();
          Long paisSesion = UtilidadesSession.getPais(this);
          dtoEntrada.setPais(paisSesion);
          dtoEntrada.setIpCliente(UtilidadesBelcorp.getIPCliente(this) );
          dtoEntrada.setPrograma(UtilidadesSession.getFuncion(this) );
          
          //dtoEntrada.setPais( new Integer(1) );

          // Setea los paramétros
          vParams.add(dtoEntrada);
          vParams.add(bussID);
          traza("Antes de llamar a conectar");          
          DruidaConector con = conectar("ConectorDesasignarUG", vParams);
          traza("Despues de llamar a conectar");
          asignarAtributo("VAR", "accion", "valor", accion);
          asignarAtributo("VAR", "exito", "valor", "SI");
        } else if(accion.equals("volver") )
        {
          // Este método es llamado luego de que el usuario da click en 
          // aceptar o cancelar. Vuelve a LPInicioBelcorp.
          traza("Accion Volver");
          conectorAction("LPInicioBelcorp");
/*          String pantallaInicio = getPantallaInicioAsociada();
 
          if (pantallaInicio == null)
          {
            traza("PantallaInicio de sesion null - Enviando a LPInicioBelcorp");
            conectorAction("LPInicioBelcorp");
          } else
          {
            traza("PantallaInicio de sesion encontrada - Enviando a " + pantallaInicio);          
            conectorAction(pantallaInicio);
          }*/
        }
    } catch (Exception ex)
    {
          ByteArrayOutputStream stack = new ByteArrayOutputStream();
          PrintStream out = new PrintStream(stack);
          ex.printStackTrace(out);
          traza("EXCEPCION:" + stack.toString());
		  this.lanzarPaginaError(ex);
		  /* Patricio Peralta 23/01/2004 uso de this.lanzarPaginaError(ex)
		  
          BelcorpError belcorpError = new BelcorpError();
          Long codPais = UtilidadesSession.getPais(this);
          Long codIdioma = UtilidadesSession.getIdioma(this);
          
          DTOError dtoError = belcorpError.obtenerError(ex, codIdioma.toString(), codPais.toString() );
          //String sCodigoPais = this.getPais();
			
          traza("codigo:"+dtoError.getCodigoError());
          traza("descricption:"+dtoError.getDescripcionError() );

          asignarAtributo("VAR","conectorAction", "valor", LP_NAME );
          asignarAtributo("VAR","accion", "valor", accion );
          asignarAtributo("VAR","errCodigo", "valor", ""+ dtoError.getCodigoError());
          asignarAtributo("VAR","errDescripcion", "valor",dtoError.getDescripcionError() );
          */
		  }      
    } 
    
	private String getPais() throws Exception
	{
		HashMap propiedades  = (HashMap) conectorParametroSesion("propiedades");		

    traza("propiedades.toString(): " + propiedades.toString() );
		if ( propiedades == null || propiedades.size()==0 ){
			return "";
		}
		Property paisDefecto = (Property) propiedades.get("PaisDefecto");
		if ( paisDefecto == null || paisDefecto.getValue() == null ){
			return "";
		}
		return (String)paisDefecto.getValue(); 
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