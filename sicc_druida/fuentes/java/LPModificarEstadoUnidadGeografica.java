//$Id: LPModificarEstadoUnidadGeografica.java,v 1.1 2009/12/03 18:34:31 pecbazalar Exp $ 
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

import es.indra.druida.DruidaBase;
import es.indra.druida.DruidaConector;
//import es.indra.druida.dom.DruidaDOMObjeto;
import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.IBelcorpError;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;

import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.dto.IMareDTO;
import java.lang.reflect.InvocationTargetException;
import com.evermind.server.rmi.OrionRemoteException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

//import org.w3c.dom.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
//import org.w3c.dom.Text;

import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.cmn.presentacion.rastreador.Rastreador;
import es.indra.sicc.cmn.presentacion.rastreador.IRastreador;
import es.indra.mare.common.mii.MareCredentials;

import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.IBelcorpError;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.DTOSalida;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.sicc.dtos.zon.DTOUBIGEOS;
import es.indra.sicc.dtos.zon.DTOUBIGEO;

import java.util.Vector;
import java.lang.Boolean;
import java.io.*;

public class LPModificarEstadoUnidadGeografica extends LPSICCBase {		
	
   Vector dtoUbigeoVec = new Vector();
	public LPModificarEstadoUnidadGeografica() {	 super();  }
	public void inicio() throws Exception { pagina("contenido_estado_unidades_geograficas_modificar"); }
	public void ejecucion() throws Exception {		
		setTrazaFichero();  

		String casoDeUso			= conectorParametro("casoDeUso");
		String accion				= conectorParametroLimpia("accion", "", true);
		String EstadoUnidades   = conectorParametroLimpia( "hidEstadoUnidades","",true );

	  // Rastreo
	  if(accion.equals("")){
		  this.rastreo();
	  }

      try {
         if(!EstadoUnidades.equals("")) {
            DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = f.newDocumentBuilder();
            Vector paramEntrada = new Vector();
            // Armando vector DTOUBIGEOS
            DTOUBIGEOS dtoUBIS = new DTOUBIGEOS();
            Document doc = db.parse(new StringBufferInputStream(EstadoUnidades));
            Element root = doc.getDocumentElement();			     
            Node child = root.getFirstChild();
            while (child != null) {
              if(child instanceof Element) {
                Element el = (Element)child;
                if(!(el.getAttribute("ACTIVO")).equals(el.getAttribute("ACTIVO_LOADED"))){
                  DTOUBIGEO dtoUbigeo = new DTOUBIGEO();
                  dtoUbigeo.setUBIGEO(el.getAttribute("UBIGEO"));
                  if((el.getAttribute("ACTIVO")).equals("1"))
                    dtoUbigeo.setIndicadorActiva(Boolean.TRUE);
                  else
                    dtoUbigeo.setIndicadorActiva(Boolean.FALSE);
                  dtoUbigeoVec.add(dtoUbigeo);
                }
              }
              putVectorByNode(child);             
              child = child.getNextSibling();
            } 
            traza("DTOBIGEOS_Vector: " + dtoUbigeoVec.toString());
            dtoUBIS.setDtoUbigeoVec(dtoUbigeoVec); 
            MareBusinessID id = new MareBusinessID("ZONModificaUnidadesGeograficas"); 
            paramEntrada.addElement(dtoUBIS); 
            paramEntrada.addElement(id);
            // Conectando 
            DruidaConector conector = conectar("ConectorModificarEstadoUnidadesGeograficas",paramEntrada);            
            asignarAtributo("VAR", "exito", "valor", "S" );
         }
         asignarAtributo("VAR", "hidPais", "valor", UtilidadesSession.getDescripcionPais(this) );
	      getConfiguracionMenu();          
         } catch (Exception ex) {
           ByteArrayOutputStream stack = new ByteArrayOutputStream();
           PrintStream out = new PrintStream(stack);
           ex.printStackTrace(out);
           traza("EXCEPCION:" + stack.toString());
		   /* Patricio Peralta 23/01/2004 uso de this.lanzarPaginaError(ex)
           BelcorpError belcorpError = new BelcorpError();
           Long codPais = UtilidadesSession.getPais(this);
           Long codIdioma = UtilidadesSession.getIdioma(this);          
           DTOError dtoError = belcorpError.obtenerError(ex, codIdioma.toString(), codPais.toString() );
           traza("codigo:"+dtoError.getCodigoError());
           traza("descricption:"+dtoError.getDescripcionError() );
           asignarAtributo("VAR","errCodigo", "valor", "" + dtoError.getCodigoError());
           asignarAtributo("VAR","errDescripcion", "valor", dtoError.getDescripcionError()) ;
		   */
         }				            
	}

   private void putVectorByNode(Node nod) {
      if(nod.hasChildNodes()) {
        Node child  = nod.getFirstChild();
        while (child != null) {
          if(child instanceof Element) {
            Element el = (Element)child;
            if(!(el.getAttribute("ACTIVO")).equals(el.getAttribute("ACTIVO_LOADED"))) {
              DTOUBIGEO dtoUbigeo = new DTOUBIGEO();
              dtoUbigeo.setUBIGEO(el.getAttribute("UBIGEO"));
              if((el.getAttribute("ACTIVO")).equals("1"))
                dtoUbigeo.setIndicadorActiva(Boolean.TRUE);
              else
                dtoUbigeo.setIndicadorActiva(Boolean.FALSE);
                dtoUbigeoVec.add(dtoUbigeo);
            }
          }            
          putVectorByNode(child);
          child = child.getNextSibling();
        }
      }
   }
/* .......................................................................................................... */
}
