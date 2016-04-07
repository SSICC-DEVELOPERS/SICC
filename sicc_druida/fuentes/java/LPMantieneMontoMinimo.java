//$Id: LPMantieneMontoMinimo.java,v 1.1 2009/12/03 18:36:00 pecbazalar Exp $ 
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
 * 
 * Autor: Marta Aurora Montiel
 */

import es.indra.sicc.util.*;
import es.indra.druida.DruidaConector;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.presentacion.rastreador.*;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.dtos.ped.DTOMontoMinimo;
import es.indra.sicc.dtos.ped.DTODetalleFlete;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Enumeration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;
import java.math.BigDecimal;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import es.indra.sicc.util.xml.XMLDocument;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;


import java.util.Locale;
import java.text.*;

public class LPMantieneMontoMinimo extends LPSICCBase{


	public LPMantieneMontoMinimo()  {
	  super();
	}  

	public void inicio() throws Exception {
		String casoDeUso = conectorParametroLimpia("casoDeUso", "", true);

		if(casoDeUso.equals("inserta")){
			pagina("contenido_monto_minimo_insertar");
		}else if(casoDeUso.equals("elimina") || casoDeUso.equals("modifica") || casoDeUso.equals("consulta")){
			pagina("contenido_monto_minimo_modificar");
		}
							
	}

	public void ejecucion() throws Exception{

		setTrazaFichero();

		String accion = conectorParametroLimpia("accion", "", true);
		String casoDeUso = conectorParametroLimpia("casoDeUso", "", true);

		asignarAtributo("VAR", "accion", "valor", accion);

		traza("caso de uso: " + casoDeUso);

		try{
			if( accion.equals("modificar") ){
				muestraCarga(true); 
				asignarAtributoPagina("cod", "0616");
				modifica(); 
			}else if( accion.equals("detalle") ){
				muestraCarga(true);
				modifica(); 
				// Titulo
				if(casoDeUso.equals("modifica")){
					asignarAtributoPagina("cod", "0616");
				}else if(casoDeUso.equals("consulta")){
					asignarAtributoPagina("cod", "0617");
				}else if(casoDeUso.equals("elimina")){
					asignarAtributoPagina("cod", "0618");
				}				

			}else if( accion.equals("muestraConsulta") ){
				muestraCarga(false);
				asignarAtributoPagina("cod", "0617");
			}else if( accion.equals("muestraBorrado") ){
				muestraCarga(false);                
				asignarAtributoPagina("cod", "0618");
			}else if( accion.equals("muestraModificacion") ){
				muestraCarga(false);
                asignarAtributoPagina("cod", "0616");
			}else if( accion.equals("muestraInsercion") ){
				 muestraCarga(true);
				 asignarAtributoPagina("cod", "0615");
			}else if( accion.equals("guardar")){
				 guarda();                             
			}

	 }catch (Exception e){   

	   logStackTrace(e);
	   this.lanzarPaginaError(e);

	 }
     // Configura menu secundario
	 getConfiguracionMenu();

	}//fin ejecucion


    private void logStackTrace(Throwable e) {
         ByteArrayOutputStream os = new ByteArrayOutputStream();
         PrintStream ps = new PrintStream(os);

         e.printStackTrace(ps);
         try {
            traza("Se produjo la excepcion: " 
                + e.getMessage() 
                + "\n" 
                + "stackTrace = " 
                + os.toString());
         }
         catch (Exception ex) {
            //traza ("Error en logStackTrace: " + ex.getMessage ());
            e.printStackTrace ();
         }
    }

/*
 * Muestra la pantalla de modificación del monto mínimo seleccionado.
 * */
    private void modifica()throws Exception{
        Long oid = new Long(conectorParametro("seleccion"));

		traza("oid: " + oid);

        DTOOID  dtoOid = new DTOOID();
        dtoOid.setOid(oid);
		dtoOid.setOidPais(UtilidadesSession.getPais(this));
        dtoOid.setOidIdioma(UtilidadesSession.getIdioma(this));

        MareBusinessID id = new MareBusinessID("PEDdetallesMontoMinimo");
        Vector paramEntrada = new Vector();
        paramEntrada.add(dtoOid);
        paramEntrada.add(id);
		traza("Antes de conector");
        DruidaConector conObtenerOfertaModif = conectar("ConectorDetallesMontoMinimo", paramEntrada);
        DTOMontoMinimo dtoMontoMin = (DTOMontoMinimo)conObtenerOfertaModif.objeto("DTOMontoMinimo");
		traza("Despues de conector");

        oid = dtoMontoMin.getOid();
		Long oidTipoSolicitud = dtoMontoMin.getTipoSolicitudPais(); 
        Long oidTipoCliente = dtoMontoMin.getOidTipoCliente(); 
        BigDecimal nivel1 = dtoMontoMin.getNivel1();
        BigDecimal nivel2 = dtoMontoMin.getNivel2();
        BigDecimal nivel3 = dtoMontoMin.getNivel3();       
        BigDecimal recargo = dtoMontoMin.getRecargo();
		BigDecimal montoMin = dtoMontoMin.getMontoMinimo();
		Long oidSubTipoCliente = dtoMontoMin.getOidSubtipoCliente(); 
		Long oidTipoClasificacion = dtoMontoMin.getOidTipoClasificacion(); 
		Long oidClasificacion = dtoMontoMin.getOidClasificacion(); 
		ArrayList oidRegiones = dtoMontoMin.getOidRegiones(); 
		ArrayList oidZonas = dtoMontoMin.getOidZonas();


        asignarAtributo("VAR", "hcbTipoSolicitud", "valor", (oidTipoSolicitud==null?"":oidTipoSolicitud.toString()));            
        asignarAtributo("VAR", "hcbTipoCliente", "valor", (oidTipoCliente==null?"":oidTipoCliente.toString()));
		asignarAtributo("VAR", "hcbSubTipoCliente", "valor", (oidSubTipoCliente==null?"":oidSubTipoCliente.toString()));
		asignarAtributo("VAR", "hcbTipoClasificacion", "valor", (oidTipoClasificacion==null?"":oidTipoClasificacion.toString()));
		asignarAtributo("VAR", "hcbClasificacion", "valor", (oidClasificacion==null?"":oidClasificacion.toString()));
	
		asignarAtributo("VAR", "hRegion", "valor", (oidRegiones==null?"":oidRegiones.get(0).toString()));
		asignarAtributo("VAR", "hZona", "valor", (oidZonas==null?"":oidZonas.get(0).toString()));



        asignarAtributo("VAR", "oid", "valor", (oid==null?"":oid.toString()));
    
        asignarAtributo("CTEXTO","txtNivel1","valor",(nivel1==null?"": UtilidadesBelcorp.formateaNumeroSICC(nivel1.toString(), this.FORMATO_DEFAULT, this)));
        asignarAtributo("CTEXTO","txtNivel2","valor",(nivel2==null?"": UtilidadesBelcorp.formateaNumeroSICC(nivel2.toString(), this.FORMATO_DEFAULT, this)));
        asignarAtributo("CTEXTO","txtNivel3","valor",(nivel3==null?"": UtilidadesBelcorp.formateaNumeroSICC(nivel3.toString(), this.FORMATO_DEFAULT, this)));
        asignarAtributo("CTEXTO","txtRecargo","valor",(recargo==null?"":UtilidadesBelcorp.formateaNumeroSICC(recargo.toString(), this.FORMATO_DEFAULT, this)));
		asignarAtributo("CTEXTO","txtMontoMinimoNominal","valor",(montoMin==null?"":UtilidadesBelcorp.formateaNumeroSICC(montoMin.toString(), this.FORMATO_DEFAULT, this)));

        // Valores ocultos para el limpiar
		asignarAtributo("VAR","hTxtNivel1","valor",(nivel1==null?"": UtilidadesBelcorp.formateaNumeroSICC(nivel1.toString(), this.FORMATO_DEFAULT, this)));
        asignarAtributo("VAR","hTxtNivel2","valor",(nivel2==null?"": UtilidadesBelcorp.formateaNumeroSICC(nivel2.toString(), this.FORMATO_DEFAULT, this)));
        asignarAtributo("VAR","hTxtNivel3","valor",(nivel3==null?"": UtilidadesBelcorp.formateaNumeroSICC(nivel3.toString(), this.FORMATO_DEFAULT, this)));
        asignarAtributo("VAR","hTxtRecargo","valor",(recargo==null?"":UtilidadesBelcorp.formateaNumeroSICC(recargo.toString(), this.FORMATO_DEFAULT, this)));
		asignarAtributo("VAR","hTxtMontoMinimoNominal","valor",(montoMin==null?"":UtilidadesBelcorp.formateaNumeroSICC(montoMin.toString(), this.FORMATO_DEFAULT, this)));
		asignarAtributo("VAR", "hDcbSubTipoCliente", "valor", (oidSubTipoCliente==null?"":oidSubTipoCliente.toString()));
		asignarAtributo("VAR", "hDcbTipoClasificacion", "valor", (oidTipoClasificacion==null?"":oidTipoClasificacion.toString()));
		asignarAtributo("VAR", "hDcbClasificacion", "valor", (oidClasificacion==null?"":oidClasificacion.toString()));
              
    }//fin metodo modifica()



    private void muestraCarga(boolean esInsercion) throws Exception{
        traza("metodo muestraCarga()");
        
        if(esInsercion){
            pagina("contenido_monto_minimo_insertar");
			this.getFormatosValidaciones();            
        }else{
            pagina("contenido_monto_minimo_modificar");
        }

        // Seteo caso de uso
		String casoDeUso = conectorParametroLimpia("casoDeUso", "", true);
		String accion = conectorParametroLimpia("accion", "", true);

		asignarAtributo("VAR", "accion", "valor", accion);
		asignarAtributo("VAR", "casoDeUso", "valor", casoDeUso);
		
		asignarAtributo("VAR", "hFormatoDef", "valor", (new Integer(this.FORMATO_DEFAULT)).toString());

        // Seteo Pais e Idioma
        Long pais = UtilidadesSession.getPais(this);
        Long idioma = UtilidadesSession.getIdioma(this);

        asignarAtributo("VAR","hIdioma","valor", (idioma==null?"":idioma.toString()) );
        asignarAtributo("VAR","hPais","valor",  (pais==null?"":pais.toString()) );

        traza("antes de ComposerViewElementList  ");
        ComposerViewElementList cv = crearParametrosEntrada();
        ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
        traza("antes del conector.ejecucion");
        conector.ejecucion();
        traza("antes del conector");
        DruidaConector resultados = conector.getConector();

        traza("antes de asignar al COMBO");
        asignar("COMBO","cbTipoSolicitud",resultados,"PEDobtieneTiposSolicitudPorPais");      
        if(esInsercion){
    		this.cargarZonas();
	    	this.cargarRegiones();
		}
	}  


    private ComposerViewElementList crearParametrosEntrada() throws Exception{
        traza("metodo ComposerViewElementList");
		ComposerViewElementList lista = new ComposerViewElementList();
		//combo codigo configuracion
		ComposerViewElement tipSolicitud = new ComposerViewElement();

        DTOBelcorp dtoBel = new DTOBelcorp();
        traza("antes de asignar al dtobelcorp");
        dtoBel.setOidPais(UtilidadesSession.getPais(this));
        dtoBel.setOidIdioma(UtilidadesSession.getIdioma(this));
        
		tipSolicitud.setIDBusiness("PEDobtieneTiposSolicitudPorPais");
		tipSolicitud.setDTOE(dtoBel);
        
        lista.addViewElement(tipSolicitud);
        return lista;
    }

/*
 * Guarda la informacion de la pantalla PantallaGuardarMontoMinimo
 * */
    private void guarda() throws Exception{

		   pagina("salidaGenerica");
		   String casoDeUso = conectorParametroLimpia("casoDeUso", "", true);
          
		   try{

			   DTOMontoMinimo dto = construyeMonto();

			   traza("dto: " + dto);

			   dto.setIpCliente(UtilidadesBelcorp.getIPCliente(this));				
               dto.setPrograma(UtilidadesSession.getFuncion(this));

			   MareBusinessID id = new MareBusinessID("PEDguardaMontoMinimo");
			   Vector paramEntrada = new Vector();
			   paramEntrada.add(dto);
			   paramEntrada.add(id);

			   DruidaConector conObtenerOfertaModif = conectar("ConectorGuardarMontoMinimo", paramEntrada);

			   if(casoDeUso.equals("modifica") ){
					asignarAtributo("VAR", "ejecutar", "valor", "cerrarVentana()");
			   } else {
					asignarAtributo("VAR", "ejecutar", "valor", "fLimpiar()");
			   }

		   }catch(Exception e){
			   asignarAtributo("VAR", "ejecutarError", "valor", "errorAlGuardar()");
			   throw e;
		}
    }

/*
 * Construye un DTOMontoMinimo con sus detalles, un detalle por cada
 * elemento de la lista lsTipologia de la pantalla PantallaGuardarMontoMinimo
 * */
    private DTOMontoMinimo construyeMonto() throws Exception{

	   String casoDeUso = conectorParametroLimpia("casoDeUso", "", true);

		String  oid = conectorParametroLimpia("oid","",true);

        String  tipoSolicitudPais = conectorParametroLimpia("cbTipoSolicitud","",true);
		String  tipoCliente = conectorParametroLimpia("hcbTipoCliente","",true);
        String  nivel1 = conectorParametroNumero("txtNivel1",this.FORMATO_DEFAULT);
        String  nivel2 = conectorParametroNumero("txtNivel2",this.FORMATO_DEFAULT);
        String  nivel3 = conectorParametroNumero("txtNivel3",this.FORMATO_DEFAULT);
        String  recargo = conectorParametroNumero("txtRecargo",this.FORMATO_DEFAULT);
        String  montoMinN = conectorParametroNumero("txtMontoMinimoNominal",this.FORMATO_DEFAULT);
		String  subTipoCliente = conectorParametroLimpia("cbSubTipoCliente","",true);
		String  tipoClasificacion = conectorParametroLimpia("cbTipoClasificacion","",true);
		String  clasificacion = conectorParametroLimpia("cbClasificacion","",true);
        String region = conectorParametroLimpia( "cbRegion", "", true );
        String zona = conectorParametroLimpia( "cbZona", "", true );


      
		DTOMontoMinimo dto = new DTOMontoMinimo();

		dto.setOid(oid.equals("")?null: new Long(oid));
		dto.setTipoSolicitudPais(new Long(tipoSolicitudPais));
		dto.setOidTipoCliente(new Long(tipoCliente));
        dto.setNivel1(nivel1.equals("")?null: new BigDecimal(nivel1));
        dto.setNivel2( nivel2.equals("")?null: new BigDecimal(nivel2));
        dto.setNivel3( nivel3.equals("")?null: new BigDecimal(nivel3));
		traza("5");
        dto.setRecargo(recargo.equals("")?null: new BigDecimal(recargo));
		traza("6");
        dto.setMontoMinimo(montoMinN.equals("")?null: new BigDecimal(montoMinN));
		traza("7");
        dto.setOidSubtipoCliente(subTipoCliente.equals("")?null: new Long(subTipoCliente));
		traza("8");
		dto.setOidTipoClasificacion(tipoClasificacion.equals("")?null: new Long(tipoClasificacion));
		traza("9: " + clasificacion);
		dto.setOidClasificacion(clasificacion.equals("")?null: new Long(clasificacion));
		traza("10");

	    if(!casoDeUso.equals("modifica") ){
			traza("Regiones: "+region);
			if(zona.trim().equals("")){
				dto.setOidRegiones(region.trim().equals("") ? null : this.obtenerRegiones(region));
			}
			if(region.trim().equals("")){
				dto.setOidRegiones(zona.trim().equals("") ? null : this.obtenerZonas(zona,false));
				dto.setOidZonas(zona.trim().equals("") ? null : this.obtenerZonas(zona,true));
			}
			traza("Regiones y zonas : "+zona);
		}
        return dto;        
    }
	private ArrayList obtenerRegiones(String oidsRegiones) throws Exception {
		StringTokenizer oidsRegionesTk = new StringTokenizer(oidsRegiones,"|");
		ArrayList regiones = new ArrayList();
    
		while (oidsRegionesTk.hasMoreTokens()) {
			Long oidRegion = new Long(oidsRegionesTk.nextToken());
			regiones.add(oidRegion);
		}
		return regiones;
	}

	private ArrayList obtenerZonas(String oids, boolean Zona) throws Exception {
		StringTokenizer oidsZonasTk = new StringTokenizer(oids,"|");
		ArrayList zonas = new ArrayList();
		ArrayList regiones = new ArrayList();
		StringTokenizer oidsZonasSinRegionTk;
		while (oidsZonasTk.hasMoreTokens()) {
			oidsZonasSinRegionTk = new StringTokenizer(oidsZonasTk.nextToken(),"x");
			Long oidZona = new Long(oidsZonasSinRegionTk.nextToken());
			Long oidRegion = new Long(oidsZonasSinRegionTk.nextToken());
			zonas.add(oidZona);
			regiones.add(oidRegion);
		}
		if(Zona){
			return zonas;
		}else{
			return regiones;
		}
	}

  
  private void cargarRegiones()
        throws Exception
    {
        Long pais = UtilidadesSession.getPais(this);
        Long idioma = UtilidadesSession.getIdioma(this);

		DTOSalida dtosalida = new DTOSalida();
        DTOBelcorp dto = new DTOBelcorp();
        dto.setOidIdioma(idioma);
        dto.setOidPais(pais);
        DruidaConector druidaconector = null;
        Vector vector = new Vector();
        vector.add(dto);
        vector.add(new MareBusinessID("ZONObtenerRegionesPorPais"));
        druidaconector = conectar("ConectorObjeto", vector);
        dtosalida = (DTOSalida)druidaconector.objeto("DTOSalida");
        druidaconector = generaConector(dtosalida.getResultado(), "dtoSalida", "OID", "DESCRIPCION", "MARCA", "CANAL", null, null);
        asignar("COMBO", "cbRegion", druidaconector, "dtoSalida");
    }

    private void cargarZonas()
        throws Exception
    {
        Long pais = UtilidadesSession.getPais(this);
        Long idioma = UtilidadesSession.getIdioma(this);

		DTOSalida dtosalida = new DTOSalida();
        DTOUnidadAdministrativa dtounidadadministrativa = new DTOUnidadAdministrativa();
        dtounidadadministrativa.setOidIdioma(idioma);
        dtounidadadministrativa.setOidPais(pais);
        dtounidadadministrativa.setOidMarca(null);
        dtounidadadministrativa.setOidCanal(null);
        DruidaConector druidaconector = null;
        Vector vector = new Vector();
        vector.add(dtounidadadministrativa);
        vector.add(new MareBusinessID("ZONObtenerZonasPorRegiones"));
        druidaconector = conectar("ConectorObjeto", vector);
        dtosalida = (DTOSalida)druidaconector.objeto("DTOSalida");
        druidaconector = generaConectorZona(dtosalida.getResultado(), "dtoSalida", "OID_ZONA","DES_ZONA", "ZORG_OID_REGI", "MARCA", "CANAL", null);
        asignar("COMBO", "cbZona", druidaconector, "dtoSalida");
    }

    private DruidaConector generaConector(RecordSet recordset, String s, String s1, String s2, String s3, String s4, String s5, 
            String s6)
        throws Exception
    {
        XMLDocument xmldocument = new XMLDocument();
        Document document = xmldocument.makeDocument("<ROWSET2/>");
        String s7 = UtilidadesSession.getFormatoFecha(this);
        Element element = document.createElement("ROWSET");
        element.setAttribute("ID", s);
        document.getDocumentElement().appendChild(element);
        for(int i = 0; i < recordset.getRowCount(); i++)
        {
            Element element1 = document.createElement("ROW");
            element.appendChild(element1);
            Element element2 = document.createElement("CAMPO");
            element2.setAttribute("NOMBRE", s1);
            element2.setAttribute("TIPO", "OBJECTO");
            element2.setAttribute("LONGITUD", "50");
            org.w3c.dom.Text text = document.createTextNode(recordset.getValueAt(i, s1) != null ? recordset.getValueAt(i, s1).toString() : "");
            element2.appendChild(text);
            element1.appendChild(element2);
            Element element3 = document.createElement("CAMPO");
            element3.setAttribute("NOMBRE", s2);
            element3.setAttribute("TIPO", "OBJECTO");
            element3.setAttribute("LONGITUD", "50");
            org.w3c.dom.Text text1 = document.createTextNode(recordset.getValueAt(i, s2) != null ? recordset.getValueAt(i, s2).toString() : "");
            element3.appendChild(text1);
            element1.appendChild(element3);
            if(s3 != null)
            {
                Element element4 = document.createElement("CAMPO");
                element4.setAttribute("NOMBRE", s3);
                element4.setAttribute("TIPO", "OBJECTO");
                element4.setAttribute("LONGITUD", "50");
                org.w3c.dom.Text text2 = document.createTextNode(recordset.getValueAt(i, s3) != null ? recordset.getValueAt(i, s3).toString() : "");
                element4.appendChild(text2);
                element1.appendChild(element4);
            }
            if(s4 != null)
            {
                Element element5 = document.createElement("CAMPO");
                element5.setAttribute("NOMBRE", s4);
                element5.setAttribute("TIPO", "OBJECTO");
                element5.setAttribute("LONGITUD", "50");
                org.w3c.dom.Text text3 = document.createTextNode(recordset.getValueAt(i, s4) != null ? recordset.getValueAt(i, s4).toString() : "");
                element5.appendChild(text3);
                element1.appendChild(element5);
            }
            if(s5 != null)
            {
                Element element6 = document.createElement("CAMPO");
                element6.setAttribute("NOMBRE", s4);
                element6.setAttribute("TIPO", "OBJECTO");
                element6.setAttribute("LONGITUD", "50");
                org.w3c.dom.Text text4 = document.createTextNode(recordset.getValueAt(i, s5) != null ? recordset.getValueAt(i, s5).toString() : "");
                element6.appendChild(text4);
                element1.appendChild(element6);
            }
            if(s6 != null)
            {
                Element element7 = document.createElement("CAMPO");
                element7.setAttribute("NOMBRE", s6);
                element7.setAttribute("TIPO", "OBJECTO");
                element7.setAttribute("LONGITUD", "50");
                org.w3c.dom.Text text5 = document.createTextNode(recordset.getValueAt(i, s6) != null ? recordset.getValueAt(i, s6).toString() : "");
                element7.appendChild(text5);
                element1.appendChild(element7);
            }
        }

        DruidaConector druidaconector = new DruidaConector();
        druidaconector.setXML(document.getDocumentElement());
        return druidaconector;
    }
  private DruidaConector generaConectorZona(RecordSet recordset, String s, String s1, String s2, String s3, String s4, String s5, 
            String s6)
        throws Exception
    {
        XMLDocument xmldocument = new XMLDocument();
        Document document = xmldocument.makeDocument("<ROWSET2/>");
        String s7 = UtilidadesSession.getFormatoFecha(this);
        Element element = document.createElement("ROWSET");
        element.setAttribute("ID", s);
        document.getDocumentElement().appendChild(element);
        for(int i = 0; i < recordset.getRowCount(); i++)
        {
            Element element1 = document.createElement("ROW");
            element.appendChild(element1);
            Element element2 = document.createElement("CAMPO");
            element2.setAttribute("NOMBRE", s1);
            element2.setAttribute("TIPO", "OBJECTO");
            element2.setAttribute("LONGITUD", "50");
            ///// OJO  SUMA DE STRINGS
			org.w3c.dom.Text text = document.createTextNode(recordset.getValueAt(i, s1) != null ? recordset.getValueAt(i, s1).toString()+"x"+recordset.getValueAt(i, s3).toString()  : "");
            element2.appendChild(text);
            element1.appendChild(element2);
            Element element3 = document.createElement("CAMPO");
            element3.setAttribute("NOMBRE", s2);
            element3.setAttribute("TIPO", "OBJECTO");
            element3.setAttribute("LONGITUD", "50");
            org.w3c.dom.Text text1 = document.createTextNode(recordset.getValueAt(i, s2) != null ? recordset.getValueAt(i, s2).toString() : "");
            element3.appendChild(text1);
            element1.appendChild(element3);
            if(s3 != null)
            {
                Element element4 = document.createElement("CAMPO");
                element4.setAttribute("NOMBRE", s3);
                element4.setAttribute("TIPO", "OBJECTO");
                element4.setAttribute("LONGITUD", "50");
                org.w3c.dom.Text text2 = document.createTextNode(recordset.getValueAt(i, s3) != null ? recordset.getValueAt(i, s3).toString() : "");
                element4.appendChild(text2);
                element1.appendChild(element4);
            }
            if(s4 != null)
            {
                Element element5 = document.createElement("CAMPO");
                element5.setAttribute("NOMBRE", s4);
                element5.setAttribute("TIPO", "OBJECTO");
                element5.setAttribute("LONGITUD", "50");
                org.w3c.dom.Text text3 = document.createTextNode(recordset.getValueAt(i, s4) != null ? recordset.getValueAt(i, s4).toString() : "");
                element5.appendChild(text3);
                element1.appendChild(element5);
            }
            if(s5 != null)
            {
                Element element6 = document.createElement("CAMPO");
                element6.setAttribute("NOMBRE", s4);
                element6.setAttribute("TIPO", "OBJECTO");
                element6.setAttribute("LONGITUD", "50");
                org.w3c.dom.Text text4 = document.createTextNode(recordset.getValueAt(i, s5) != null ? recordset.getValueAt(i, s5).toString() : "");
                element6.appendChild(text4);
                element1.appendChild(element6);
            }
            if(s6 != null)
            {
                Element element7 = document.createElement("CAMPO");
                element7.setAttribute("NOMBRE", s6);
                element7.setAttribute("TIPO", "OBJECTO");
                element7.setAttribute("LONGITUD", "50");
                org.w3c.dom.Text text5 = document.createTextNode(recordset.getValueAt(i, s6) != null ? recordset.getValueAt(i, s6).toString() : "");
                element7.appendChild(text5);
                element1.appendChild(element7);
            }
        }

        DruidaConector druidaconector = new DruidaConector();
        druidaconector.setXML(document.getDocumentElement());
        return druidaconector;
    }
}
