/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
    INDRA/FAC/PROY
    $Id: LPIntroducirResultadoChequeos.java,v 1.1 2009/12/03 18:35:10 pecbazalar Exp $
    DESC
 */

import es.indra.druida.DruidaConector;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;

import es.indra.druida.dom.DruidaDOMObjeto;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOBoolean;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import es.indra.sicc.dtos.mae.DTOBusquedaRapidaCliente;
import es.indra.sicc.dtos.rec.DTOInsertarResultadoChequeo;
import es.indra.sicc.dtos.rec.DTOResultadosChequeo;

import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.ArrayList;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream; 

import java.text.SimpleDateFormat;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Text;


public class LPIntroducirResultadoChequeos extends LPSICCBase {
	private Long idioma = null; 
	private Long pais = null;
	private String accion = null;
	private String opcionMenu = null;
	
	
	public LPIntroducirResultadoChequeos() {
	super();
	}
	
	public void inicio() throws Exception {
		pagina("contenido_resultados_chequeos_buscar");
	}
	
	public void ejecucion() throws Exception {
		setTrazaFichero();
		try{
			traza("*** LPIntroducirResultadoChequeos.ejecucion: Entrada **");
			this.idioma = UtilidadesSession.getIdioma(this);
			this.pais = UtilidadesSession.getPais(this);
			this.accion = conectorParametroLimpia("accion","",true);
			traza("Accion definida : "+this.accion);
			this.opcionMenu = conectorParametroLimpia("opcionMenu","",true);
			traza("opcionMenu definida : "+this.opcionMenu);
		    if (accion.equals("")){
		    	cargarPagina();
		    } else if (accion.equals("aceptar")){
		    	aceptar();
			} else if (accion.equals("modificar")){
		    	modificar();
		    } else if (accion.equals("aceptarResultadoChequeo")){
		    	aceptarResultadoChequeo();
			} else if (accion.equals("detalle")){
				detalle();
			}
		}
		catch (Exception ex){
			ex.printStackTrace();
			this.logStackTrace(ex);
			lanzarPaginaError(ex);
		}
		traza("*** LPIntroducirResultadoChequeos.ejecucion: Salida **");
	}
	
	private void cargarPagina() throws Exception{
		traza("*** LPIntroducirResultadoChequeos.cargarPagina: Entrada **");
		pagina("contenido_resultados_chequeos_buscar");
		asignar("VAR", "pais", pais.toString());
		asignar("VAR", "idioma", idioma.toString());
		asignar("VAR", "casoUso", "Buscar_resultado_chequeos");
		asignarAtributo("PAGINA","contenido_resultados_chequeos_buscar", "cod", "0219");
		asignarAtributo("PAGINA","contenido_resultados_chequeos_buscar", "msgle", "Introducir Resultados de Chequeos");
		getConfiguracionMenu("LPIntroducirResultadoChequeos", "");
		Byte longitudCodigoCliente = obtenerLongitudCodigoCliente();
        asignar("VAR","longitudCodigoCliente", longitudCodigoCliente.toString());
		traza("*** LPIntroducirResultadoChequeos.cargarPagina: Salida **");	
	}
	
	private void aceptar() throws Exception{
		traza("*** LPIntroducirResultadoChequeos.aceptar: Entrada **");
		
		Byte longitudCodigoCliente = obtenerLongitudCodigoCliente();
        asignar("VAR","longitudCodigoCliente", longitudCodigoCliente.toString());
        asignar("CTEXTO","txtCodigoCliente",conectorParametroLimpia("txtCodigoCliente","",true));
        asignar("VAR","casoUso", "Buscar_resultado_chequeos");
        
		String oid = conectorParametroLimpia("oidCliente","",true);
		
		if (oid.equals("")){
			DTOBusquedaRapidaCliente dto = new DTOBusquedaRapidaCliente();
			dto.setOidPais(pais);
			dto.setOidIdioma(idioma);
			dto.setCodigoCliente(conectorParametroLimpia("txtCodigoCliente","",true));
			dto.setIndicadorSituacion(new Long(0));
			dto.setTamanioPagina(new Integer(1));
			Vector paramConector = new Vector();
			paramConector.add(dto);
			paramConector.add(new MareBusinessID("MAEBusquedaRapidaCliente"));
			traza("Antes de Conectar ConectorBusquedaRapidaCliente");
			DruidaConector conector = conectar("ConectorBusquedaRapidaCliente", paramConector);
			traza("Despues de Conectar ConectorBusquedaRapidaCliente");
			//dtoSalida.resultado
			DTOSalida dtoSalida = (DTOSalida) conector.objeto("DTOSalida");
			RecordSet rs = dtoSalida.getResultado();
			if (!rs.esVacio()){
				pagina("contenido_resultados_chequeos_introducir");
				getConfiguracionMenu("LPIntroducirResultadoChequeos", "aceptar");
				asignar("VAR", "pais", pais.toString());
				asignar("VAR", "idioma", idioma.toString());
				asignarAtributo("PAGINA","contenido_resultados_chequeos_introducir", "cod", "0145");
				asignarAtributo("PAGINA","contenido_resultados_chequeos_introducir", "msgle", "Introducir Resultados de Chequeos");
				
				
				asignar("VAR","oidCliente",rs.getValueAt(0,0).toString());
				asignar("LABELC","lblCodigoClienteXX",rs.getValueAt(0,1).toString());
				asignar("LABELC","lblNombreXX", (rs.getValueAt(0,2) != null ? rs.getValueAt(0,2).toString() : "") + " " + (rs.getValueAt(0,3) != null ? rs.getValueAt(0,3).toString(): ""));
				asignar("LABELC","lblApellidosXX", (rs.getValueAt(0,4) != null ? rs.getValueAt(0,4).toString() : "") + " " + (rs.getValueAt(0,5) != null ? rs.getValueAt(0,5).toString() : ""));

				obtenerResultadosChequeo();
			}
		} else{
			pagina("contenido_resultados_chequeos_introducir");
		   getConfiguracionMenu("LPIntroducirResultadoChequeos", "aceptar");
			asignar("VAR", "pais", pais.toString());
			asignar("VAR", "idioma", idioma.toString());
			asignarAtributo("PAGINA","contenido_resultados_chequeos_introducir", "cod", "0145");
			asignarAtributo("PAGINA","contenido_resultados_chequeos_introducir", "msgle", "Introducir Resultados de Chequeos");
			asignar("VAR","oidCliente",conectorParametroLimpia("oidCliente","",true));
			asignar("LABELC","lblCodigoClienteXX",conectorParametroLimpia("txtCodigoCliente","",true));
			asignar("LABELC","lblNombreXX",conectorParametroLimpia("nombre1","",true) + " " + conectorParametroLimpia("nombre2","",true));
			asignar("LABELC","lblApellidosXX",conectorParametroLimpia("apellido1","",true) + " " + conectorParametroLimpia("apellido2","",true));

			obtenerResultadosChequeo();
		}
		
		traza("*** LPIntroducirResultadoChequeos.aceptar: Salida **");
	}
	
	private void modificar() throws Exception{
		traza("*** LPIntroducirResultadoChequeos.modificar: Entrada **");
		pagina("contenido_resultados_chequeos_introducir_1");
		asignar("VAR", "pais", pais.toString());
		asignar("VAR", "idioma", idioma.toString());
		String revision = conectorParametroLimpia("revision","",true);
		asignarAtributo("PAGINA","contenido_resultados_chequeos_introducir_1", "cod", "0145");
		asignarAtributo("PAGINA","contenido_resultados_chequeos_introducir_1", "msgle", "Introducir Resultados de Chequeos");
		getConfiguracionMenu("LPIntroducirResultadoChequeos", "modificar");
		
		DTOBelcorp dto = new DTOBelcorp();
		dto.setOidPais(pais);
		dto.setOidIdioma(pais);
		
		ComposerViewElementList listelem = new ComposerViewElementList();
        ComposerViewElement elem = new ComposerViewElement();
        
        elem.setIDBusiness("RECObtenerResultadosChequeo");
        elem.setDTOE(dto);
        listelem.addViewElement(elem);
		
		traza("antes conector");
		ConectorComposerView conector = new ConectorComposerView(listelem,this.getRequest());
        traza("conector creado");

		conector.ejecucion();
        traza("ejecutado");
        DruidaConector conConsultar = conector.getConector();
        traza("Obtener conConsultar");
        //asignar("COMBO","cbResultadoRevision", conConsultar,"RECObtenerResultadosChequeo", "DESCRIPCION", conectorParametroLimpia("revision","",true));
         if (!revision.equals("")){
			asignar("COMBO","cbResultadoRevision", conConsultar,"RECObtenerResultadosChequeo", "DESCRIPCION", conectorParametroLimpia("revision","",true));
        }else{
            asignar("COMBO","cbResultadoRevision", conConsultar,"RECObtenerResultadosChequeo");
        }
		//asignar("MATRIZJS", "datosAccesos", conConsultar,"RECObtenerResultadosChequeo");

		Vector paramConector = new Vector();
		paramConector.add(dto);
		paramConector.add(new MareBusinessID("RECObtenerResultadosChequeo"));
		traza("Antes de Conectar ConectorObtenerResultadosChequeo");
		DruidaConector conector2 = conectar("ConectorObtenerResutadosChequeo", paramConector);
		traza("Despues de Conectar ConectorObtenerResultadosChequeo");
		
		asignar("MATRIZJS", "datosAccesos", conector2);
		asignar("VAR","oidSolicitud",conectorParametroLimpia("oid","",true));
		asignar("VAR","resultado",conectorParametroLimpia("revision","",true));
		asignar("AREATEXTO","atxtObservaciones",conectorParametroLimpia("observaciones","",true));
		traza("*** LPIntroducirResultadoChequeos.modificar: Salida **");
	}
	
	private void detalle() throws Exception{
		traza("*** LPIntroducirResultadoChequeos.detalle: entrada **");
		pagina("contenido_resultados_chequeos_introducir_2");
		asignar("VAR", "pais", pais.toString());
		asignar("VAR", "idioma", idioma.toString());
		asignarAtributo("PAGINA","contenido_resultados_chequeos_introducir_2", "cod", "0145");
		asignarAtributo("PAGINA","contenido_resultados_chequeos_introducir_2", "msgle", "Introducir Resultados de Chequeos");
		getConfiguracionMenu("LPIntroducirResultadoChequeos", "detalle");
		asignar("VAR","oidSolicitud",conectorParametroLimpia("oid","",true));
		traza("*** LPIntroducirResultadoChequeos.detalle: salida **");
	}
	
	private void logStackTrace(Throwable e) throws Exception {
         traza("Se produjo la excepcion: " + e.getMessage());            
         ByteArrayOutputStream baos = new ByteArrayOutputStream();
         PrintStream ps = new PrintStream(baos);
         e.printStackTrace(ps);                    
         traza("Stack Trace: " + baos.toString());
    }  

	 private void obtenerResultadosChequeo()  throws Exception {
		
		traza("***  Entrada -  LPIntroducirResultadoChequeos- obtenerResultadosChequeo ***");

		DTOOID dto = new DTOOID();
		dto.setOidPais(this.pais);
		dto.setOidIdioma(this.idioma);

		MareBusinessID id = new MareBusinessID("RECObtenerResultadosChequeo");
			
		Vector params = new Vector();
			
		params.add(dto);
		params.add(id);

		DruidaConector con = conectar("ConectorObtenerResutadosChequeo", params);

		DTOSalida dtos = (DTOSalida)con.objeto("DTOSalida");
		RecordSet rs = null;

		Vector oids = null;
		Vector descs = null;
		Vector IndsResultadoChequeo = null;

		String sOids = null;
		String sDescs = null;
		String sIndsResultadoChequeo = null;

		if (dtos != null && dtos.getResultado() != null && !dtos.getResultado().esVacio()){
			rs = dtos.getResultado();

			oids = rs.getColumn(0);
			descs = rs.getColumn(1);
			IndsResultadoChequeo = rs.getColumn(2);

			sOids = oids.toString();
			sDescs = descs.toString();
			sIndsResultadoChequeo =	IndsResultadoChequeo.toString();
			
			}

		if (sOids != null && sOids.length() >= 1){
			 sOids = sOids.substring( 1, sOids.length() - 1);
		}
		
		if (sDescs != null && sDescs.length() >= 1){
			 sDescs = sDescs.substring(1, sDescs.length() - 1);
		}

		 if (sIndsResultadoChequeo != null && sIndsResultadoChequeo.length() >= 1){
			 sIndsResultadoChequeo = sIndsResultadoChequeo.substring(1, sIndsResultadoChequeo.length() - 1);
		}

		//Setear los valores a la pagina.
/*		asignarAtributo("VAR", "hOidsResultadoChequeo", "valor", sOids);
		asignarAtributo("VAR", "hDescsResultadoChequeo", "valor", sDescs);
		asignarAtributo("VAR", "hIndsResultadoChequeo", "valor", sIndsResultadoChequeo);
*/
		asignar("VAR", "hOidsResultadoChequeo", sOids);
		asignar("VAR", "hDescsResultadoChequeo", sDescs);
		asignar("VAR", "hIndsResultadoChequeo", sIndsResultadoChequeo);

		traza("LPIntroducirResultadoChequeos- obtenerResultadosChequeo Oids: "+sOids+" sDescs: "+sDescs+" sIndsResultadoChequeo: "+sIndsResultadoChequeo);

		traza("***  Salida -  LPIntroducirResultadoChequeos- obtenerResultadosChequeo ***");
		}



	private void aceptarResultadoChequeo() throws Exception{
		traza("*** LPIntroducirResultadoChequeos.aceptarResultadoChequeo: Entrada **");
		pagina("salidaGenerica");
		asignarAtributo("VAR", "ejecutar", "valor", "retornoGuardar()");

		asignarAtributo("VAR", "ejecutarError", "valor", "retornoGuardar()");

		Vector paramConector = new Vector();
		String sXml = conectorParametroLimpia("sXml","",false);
		DTOInsertarResultadoChequeo[] dtos = parseaLista(sXml);
		
		DTOResultadosChequeo dto = new DTOResultadosChequeo();
		dto.setLista( dtos );
		paramConector.add( dto );

		paramConector.add(new MareBusinessID("RECActualizaResultadoChequeo"));

		traza("antes del conector");
		DruidaConector conector = conectar("ConectorActualizarResultadoChequeo", paramConector);
		traza("despues del conector");

		traza("*** LPIntroducirResultadoChequeos.aceptarResultadoChequeo: Salida **");
		
	}

    private DTOInsertarResultadoChequeo[] parseaLista(String sXml) throws Exception {
        traza("LPIntroducirResultadoChequeos.parseaLista():Entrada");
        traza("sxml: " + sXml);
        String sPropiedadActual = null;
        String sValorCampo = null;
        String sPropiedad = null;
        Node nodeDoc = null;        
        Node nodoRow = null;
        Node nodoCampo = null;
        Node textNode = null;
        NodeList nodeList = null;
        NodeList nodeListCampos = null;
        HashMap hshAtributos = new HashMap();
        DocumentBuilder docBuilder = null;
		DTOInsertarResultadoChequeo dto = null;
        Object obj = null;
   
        DTOInsertarResultadoChequeo[] dtos = null;
		sXml = sXml.replaceAll("&", "&amp;");
        
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        docBuilder = docBuilderFactory.newDocumentBuilder();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(sXml.getBytes());
        
        nodeDoc = docBuilder.parse(inputStream).getFirstChild();
        traza("nodeDoc: " + nodeDoc.getNodeName());
        nodeList = nodeDoc.getOwnerDocument().getElementsByTagName("ROW");
        long cantElems = nodeList.getLength();

		dtos = new DTOInsertarResultadoChequeo[(int)cantElems];

        traza("cantElems: " + cantElems);
        /* Recorro tags <ROW> */        
        for (int i=0; i<cantElems; i++) {
            hshAtributos = new HashMap();
            nodoRow = nodeList.item(i);
            nodeListCampos = nodoRow.getChildNodes();
            long cantCampos = nodeListCampos.getLength();
            /* Recorro tags <CAMPO> */
            for (int j=0; j<cantCampos; j++) {
                nodoCampo = nodeListCampos.item(j);
                sPropiedad = this.obtenerPropiedadCampo(nodoCampo);
                sValorCampo = this.obtenerValorCampo(nodoCampo);
                hshAtributos.put(sPropiedad, sValorCampo);
            }
            dto = this.armaDTOLineaOperacion(hshAtributos);
            dtos[i] = dto;
        }
        return dtos;
    }

    private DTOInsertarResultadoChequeo armaDTOLineaOperacion(HashMap hshMap)
          throws Exception { 
        DTOInsertarResultadoChequeo dto = null;
        Object obj = null;
        dto = new DTOInsertarResultadoChequeo();
        traza("hshMap: " + hshMap);
        
        traza("0");
        obj = hshMap.get("Oid");
        dto.setOidSolicitudCabecera( (Long)this.chequeaNulos(obj,"L"));
        
        traza("5");
        obj = hshMap.get("Resultado"); 
        dto.setOidResultadoChequeo((Long) this.chequeaNulos(obj,"L"));
        
        traza("6");
        obj = hshMap.get("Observaciones"); 
        dto.setObservaciones((String) this.chequeaNulos(obj,"S"));

        traza("DTOInsertarResultadoChequeo: " + dto);
        return dto;
    }

    private String obtenerPropiedadCampo(Node nodo) 
          throws Exception {
      NamedNodeMap nodeMap = nodo.getAttributes();
      Node nAtributo = nodeMap.getNamedItem("nombre");
      String sValorAtributo = nAtributo.getNodeValue();
      
      return sValorAtributo;
    }

	private String obtenerValorCampo(Node nodo) 
          throws Exception {
        Node textNode = nodo.getFirstChild();
        String sValorCampo = null;
        if (textNode != null) { 

          sValorCampo = textNode.getNodeValue();
        } else {
          sValorCampo = "";
        }
        return sValorCampo;
    }

    private Object chequeaNulos(Object o, String sTipoDato) 
          throws Exception {
          
       Object oRetorno = null;
       /* Long */        
       if (sTipoDato.equals("L") ) {  
          if (o != null && !o.toString().trim().equals("") ) {
            oRetorno = Long.valueOf(o.toString().trim());
          }
       } 
       
       /* Integer */        
       if (sTipoDato.equals("I") ) {  
          if (o != null && !o.toString().trim().equals("") ) {
            oRetorno = Integer.valueOf(o.toString().trim());
          }         
       }
       
       /* Double */       
       if (sTipoDato.equals("D") ) {  
          if (o != null && !o.toString().trim().equals("") ) {
            oRetorno = Double.valueOf(o.toString().trim());
          }         
       }

	   /* String */       
       if (sTipoDato.equals("S") ) {  
          if (o != null ) {
            oRetorno = o.toString().trim();
          }         
       }
       return oRetorno;
    }
}