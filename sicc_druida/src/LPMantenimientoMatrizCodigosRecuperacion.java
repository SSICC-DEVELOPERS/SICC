/*
    INDRA/CAR/PROY
    $Id: LPMantenimientoMatrizCodigosRecuperacion.java,v 1.1 2009/12/03 18:39:53 pecbazalar Exp $
    DESC
	 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 * 1° L.P: by Patricio Peralta L.P., B.A., Argentina
*/


//import LPSICCBase;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.pre.DTOMatrizCodigoRecuperacion;
import es.indra.sicc.dtos.pre.DTOProductoVenta;
import es.indra.sicc.dtos.pre.DTOProductosVenta;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringTokenizer;
import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Vector;

import org.jaxen.dom.DOMXPath;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import es.indra.sicc.util.xml.XMLDocument;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

public class LPMantenimientoMatrizCodigosRecuperacion extends LPSICCBase {

  public LPMantenimientoMatrizCodigosRecuperacion() {
    super();
  }	
	
	public void inicio() throws Exception {
    pagina("contenido_matriz_codigos_recuperacion_registrar"); 
	this.cargarZonas();
	this.cargarRegiones();
	this.cargaComboTipoClien();
    Long pais = UtilidadesSession.getPais(this);
    Long idioma = UtilidadesSession.getIdioma(this);

	asignarAtributo("VAR","hIdioma","valor", (idioma==null?"":idioma.toString()) );
	asignarAtributo("VAR","hPais","valor",  (pais==null?"":pais.toString()) );
	}

  public void ejecucion() throws Exception {
		setTrazaFichero();
		rastreo();
		String accion = conectorParametroLimpia("accion","",true); 
    
    traza("accion: " + accion);
    
		asignarAtributo("VAR", "accion", "valor", accion );

    String cbReemplazo = conectorParametroLimpia("cbReemplazo", "", true);      
	String ckEmitirMensaje = conectorParametroLimpia("ckEmitirMensaje", "", true);    

	String cbTipoCliente = conectorParametroLimpia("cbTipoCliente", "", true);      
	String cbSubTipoCliente = conectorParametroLimpia("cbSubTipoCliente", "", true);      
	String cbTipoClasificacion = conectorParametroLimpia("cbTipoClasificacion", "", true);
	String cbClasificacion = conectorParametroLimpia("cbClasificacion", "", true);      
	String cbRegion = conectorParametroLimpia("cbRegion", "", true);
	String cbZona = conectorParametroLimpia("cbZona", "", true);

    try  {
      if(accion.equals("")){
        conectorParametroSesion("UltimaLP", "LPMantenimientoMatrizCodigosRecuperacion");
        conectorAction("LPSeleccionarMF");
			} else {
      
        String descripcionPeriodo = (String)conectorParametroSesion("descripcionPeriodo"); 
				asignarAtributo("LABELC", "lblPeriodoMatrizActualXX", "valor",descripcionPeriodo);

				if(accion.equals("matrizSeleccionada") ){
          String sOidMatriz = ((Long) conectorParametroSesion("oidCabeceraMF")).toString(); 
					traza("contenido del oid de matriz  ::: . " + sOidMatriz);	
					
					asignarAtributo("VAR", "oidMatrizFacturacion", "valor", sOidMatriz);
							 
				}else if( accion.equals("buscarProductoPrincipal") ){
				  conectorParametroSesion("UltimaLP", "LPMantenimientoMatrizCodigosRecuperacion");
				  conectorAction("LPBuscarProductosVenta");
				  conectorActionParametro("accion", "buscarProductoPrincipalRecuparacion");
				}else if( accion.equals("productoPrincipalSeleccionado") ){
					DTOProductoVenta dtoProductoPrincipal  = (DTOProductoVenta)conectorParametroSesion("DTOProductoVenta");
					asignarAtributo("LABELC", "lblCodigoVentaXX", "valor", dtoProductoPrincipal.getCodigoVenta());
					asignarAtributo("LABELC", "lblDescripcionXX", "valor", dtoProductoPrincipal.getDescripcion());
					dtoProductoPrincipal.setOidIdioma(UtilidadesSession.getIdioma(this));

					// sapaza -- PER-SiCC-2014-0580 -- 17/09/2014
					conectorParametroSesion("oidMatrizPrincipal", dtoProductoPrincipal.getOidMatrizFacturacion());
					
					MareBusinessID id = new MareBusinessID("PRECargarRegistroMatrizCodigosRecuperacion");
					Vector parametros = new Vector();
					parametros.add(dtoProductoPrincipal);
					parametros.add(id);

					traza("antes conector 1");
					DruidaConector conector = (DruidaConector)conectar("ConectorCargaPantallasRegistro", parametros);
					traza("despues conector 1");

					DTOMatrizCodigoRecuperacion dtoSalida = (DTOMatrizCodigoRecuperacion)conector.objeto("DTOSalida");

					RecordSet rsProdRec = dtoSalida.getProductoRecuperado();

					RecordSet rsPeriod = dtoSalida.getPeriodos();
					DruidaConector tipoconector = (DruidaConector)conectorParametroSesion("comboPeriodoMatrizRecuperada");
          
					if (tipoconector == null) {
						Vector v = rsPeriod.getColumnIdentifiers();
						tipoconector = UtilidadesBelcorp.generarConector("DTOSalida.tipos_ROWSET",rsPeriod, v);
						conectorParametroSesion("comboPeriodoMatrizRecuperada", tipoconector);
					}			   

          traza("============================================================");
          traza("*** valores a asignar a cbPeriodoMatrizRecuperada ***");
          traza( tipoconector.getXML() );
          traza("============================================================");

					this.asignar("COMBO", "cbPeriodoMatrizRecuperada",  tipoconector,"DTOSalida.tipos_ROWSET" );

					if( rsProdRec.esVacio() ){
						asignarAtributo("VAR", "hidDatosReemp", "valor", "N");
						asignarAtributo("VAR", "oidPeriodo", "valor", "");
						asignarAtributo("LABELC", "lblCodigoVentaRecuperarXX", "valor", "" );
						asignarAtributo("LABELC", "lblDescripcionRecuperarXX", "valor", "" );
					} else {
						BigDecimal oidMatrizFacturacion = (BigDecimal)rsProdRec.getValueAt(0, "MAFA_OID_COD_RECU");
						String codVenta = (String)rsProdRec.getValueAt(0, "VAL_CODI_VENT");
						String descripcion = (String)rsProdRec.getValueAt(0, "VAL_I18N");
						BigDecimal bdRecuAuto = (BigDecimal)rsProdRec.getValueAt(0, "IND_RECU_AUTO");
						BigDecimal bdMensaje = (BigDecimal)rsProdRec.getValueAt(0, "IND_MENS");
						String oidPe = rsProdRec.getValueAt(0, "OID_PERI").toString();

						asignarAtributo("VAR", "oidPeriodo", "valor", oidPe);
						traza("oidPe " + oidPe);
						traza("oidMatrizFacturacion: " + new Long(oidMatrizFacturacion.longValue()));
						traza("codVenta: " + codVenta);
						traza("descripcion; " + descripcion);
					
						asignarAtributo("LABELC", "lblCodigoVentaRecuperarXX", "valor", codVenta );
						asignarAtributo("LABELC", "lblDescripcionRecuperarXX", "valor", descripcion );

						if ( bdMensaje!=null && bdMensaje.intValue() == 1 ){
							asignarAtributo("CHECKBOX", "ckEmitirMensaje", "check", "S");
						}else{
							asignarAtributo("CHECKBOX", "ckEmitirMensaje", "check", "N");
						}
						
						if( bdRecuAuto!= null && bdRecuAuto.intValue() == 1 ){
							asignarAtributo("CHECKBOX", "ckRecuperacionAutomatica", "check", "S");
						}else{
							asignarAtributo("CHECKBOX", "ckRecuperacionAutomatica", "check", "N");
						}

						asignarAtributo("VAR", "hidDatosReemp", "valor", "S");
						
						ArrayList array = new ArrayList();		
						DTOProductosVenta dtoProductosRecu = new DTOProductosVenta();
						DTOProductoVenta dtoProductoRecu = new DTOProductoVenta();
					
						dtoProductoRecu.setOidMatrizFacturacion(new Long(oidMatrizFacturacion.longValue()));
						dtoProductoRecu.setCodigoVenta(codVenta);				
						dtoProductoRecu.setDescripcion(descripcion);

						array.add(dtoProductoRecu);

						dtoProductosRecu.setListaProductos(array);		

						conectorParametroSesion("DTOProductosVenta", dtoProductosRecu);
					}
				} else if( accion.equals("buscarGrupoProductosRecuperacion") ){
					traza("periodo "+ conectorParametroLimpia("comboPeriodo", "", true));
					String sOidMatriz = ((Long) conectorParametroSesion("oidCabeceraMF")).toString(); 
					traza("contenido del oid de matriz 3: " + sOidMatriz);	
					conectorParametroSesion("UltimaLP", "LPMantenimientoMatrizCodigosRecuperacion");
					conectorAction("LPBuscarProductosVenta");
					conectorActionParametro("accion", "buscarGrupoProductosRecuperacion");
				}else if( accion.equals("grupoProductosSeleccionado") ){
					DTOProductoVenta dtoProductoVentaPrincReemp  = (DTOProductoVenta)conectorParametroSesion("DTOProductoVenta");

					traza("dtoProductoVentaPrincReemp:" + dtoProductoVentaPrincReemp);
								
					asignarAtributo("LABELC", "lblCodigoVentaXX", "valor", dtoProductoVentaPrincReemp.getCodigoVenta());
					asignarAtributo("LABELC", "lblDescripcionXX", "valor", dtoProductoVentaPrincReemp.getDescripcion());

					asignarAtributo("VAR", "oidPeriodo", "valor", (String)conectorParametroSesion("oidPeriodo"));
					DruidaConector tipoconector = (DruidaConector)conectorParametroSesion("comboPeriodoMatrizRecuperada");
					this.asignar("COMBO", "cbPeriodoMatrizRecuperada",  tipoconector,"DTOSalida.tipos_ROWSET" );

					DTOProductosVenta dtoPsV = (DTOProductosVenta)conectorParametroSesion("DTOProductosVenta");
					DTOProductoVenta dtoProductoRecuperacion = (DTOProductoVenta)(dtoPsV.getListaProductos().get(0));

					asignarAtributo("LABELC", "lblCodigoVentaRecuperarXX", "valor", dtoProductoRecuperacion.getCodigoVenta());
					asignarAtributo("LABELC", "lblDescripcionRecuperarXX", "valor", dtoProductoRecuperacion.getDescripcion());
					asignarAtributo("VAR", "hidDatosReemp", "valor", "S"); 
				}else if( accion.equals("guardarMatriz") ){
			    pagina("salidaGenerica");
					DTOProductosVenta dtoProductos = new DTOProductosVenta();
					DTOProductoVenta dtoProductoRecuperacion = new DTOProductoVenta();

          //Parametros auditoria
          dtoProductos.setPrograma( UtilidadesSession.getFuncion(this) );
          dtoProductos.setIpCliente( UtilidadesBelcorp.getIPCliente(this) );

					// Producto principal
					DTOProductoVenta dtoProductoVentaPrincRecu  = (DTOProductoVenta)conectorParametroSesion("DTOProductoVenta");

          //Parametros auditoria
          dtoProductoVentaPrincRecu.setIpCliente( UtilidadesBelcorp.getIPCliente(this) );
          dtoProductoVentaPrincRecu.setPrograma( UtilidadesSession.getFuncion(this) );
          
					dtoProductos.setProductoPrincipal(dtoProductoVentaPrincRecu);

					// Producto de recuperacion                
					DTOProductosVenta dtoProductosRecuperacion = (DTOProductosVenta)conectorParametroSesion("DTOProductosVenta");

					ArrayList array = new ArrayList();				
					array = dtoProductosRecuperacion.getListaProductos();				
					DTOProductoVenta dtoProductoVentaRecup = (DTOProductoVenta) array.get(0);

					dtoProductoRecuperacion.setOidMatrizFacturacion(dtoProductoVentaRecup.getOidMatrizFacturacion());
					dtoProductoRecuperacion.setCodigoVenta(dtoProductoVentaRecup.getCodigoVenta());				
					dtoProductoRecuperacion.setDescripcion(dtoProductoVentaRecup.getDescripcion());

					String aux = conectorParametroLimpia("ckRecuperacionAutomatica", "", true);
          if((aux != null) || (!aux.equals("")))  {
            dtoProductoRecuperacion.setIndicadorRecuperadorAut(new Boolean(aux.equals("S")));
          }else{
            dtoProductoRecuperacion.setIndicadorRecuperadorAut(null);
          }

		dtoProductoRecuperacion.setTipoCliente(cbTipoCliente.equals("")?null: new Long(cbTipoCliente) );
		dtoProductoRecuperacion.setSubTipoCliente(cbSubTipoCliente.equals("")?null: new Long(cbSubTipoCliente) );
		dtoProductoRecuperacion.setTipoClasificacion(cbTipoClasificacion.equals("")?null: new Long(cbTipoClasificacion) );
		dtoProductoRecuperacion.setClasificacion(cbClasificacion.equals("")?null: new Long(cbClasificacion) );
		
		if(cbZona.trim().equals("")){
			dtoProductoRecuperacion.setRegiones(cbRegion.trim().equals("") ? null : this.obtenerRegiones(cbRegion));
		}
		if(cbRegion.trim().equals("")){
			dtoProductoRecuperacion.setRegiones(cbZona.trim().equals("") ? null : this.obtenerZonas(cbZona,false));
			dtoProductoRecuperacion.setZonas(cbZona.trim().equals("") ? null : this.obtenerZonas(cbZona,true));
		}
					aux = conectorParametroLimpia("ckEmitirMensaje", "", true);
					if ((aux != null) || (!aux.equals("")))  {
            dtoProductoRecuperacion.setEmiteMensaje(new Boolean(aux.equals("S")));
					}else{
            dtoProductoRecuperacion.setEmiteMensaje(null);
          }

          //Parametros auditoria
          dtoProductoRecuperacion.setIpCliente( UtilidadesBelcorp.getIPCliente(this) );
          dtoProductoRecuperacion.setPrograma( UtilidadesSession.getFuncion(this) );

          ArrayList array2 = new ArrayList();
					array2.add(dtoProductoRecuperacion);
					traza("dtoProductoRecuperacion " + dtoProductoRecuperacion);
					dtoProductos.setListaProductos(array2);
					traza("dtoProductos " + dtoProductos);						
					Vector paramEntrada = new Vector();
					paramEntrada.add(dtoProductos);
					paramEntrada.add(new MareBusinessID("PREGuardarMatrizCodigosRecuperacion"));

					DruidaConector conector = conectar("ConectorGuardarMatrizCodigosRecuperacion", paramEntrada); 
					asignarAtributo("VAR", "ejecutar", "valor", "reInicio();");
					//conectorAction("LPMantenimientoMatrizCodigosRecuperacion");
				}
			}
        // Agregado por SICC20070322 - Rafael Romero - 24/07/2007
        agregarMenuComplementario();
        // Fin agregado SICC20070322
    }catch (Exception ex){
      logStackTrace(ex);
      this.lanzarPaginaError(ex);
    }
    
		getConfiguracionMenu("LPMantenimientoMatrizCodigosRecuperacion");
  }
            
  public void logStackTrace(Throwable e) throws Exception {
    traza("Se produjo la excepcion: " + e.getMessage());

		ByteArrayOutputStream pila = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(pila);
		if(e instanceof MareException){
			MareException e2=(MareException)e;
			traza("Es una mare Exception con codigo de error: "+e2.getCode());
		}
    e.printStackTrace(out);
		traza("stack Trace : " +  pila.toString());
	}
    // Agregado por SICC20070322 - Rafael Romero - 24/07/2007
    private void agregarMenuComplementario() throws Exception{
        if(conectorParametroSesion("descripcionPeriodo")!=null){
            DOMXPath xform = new DOMXPath("//PAGINA/FORMULARIO[VAR[@nombre='conectorAction']]");
            Element formulario = (Element)xform.selectSingleNode(getXML());
            if(formulario != null)
            {
                DOMXPath xpath = new DOMXPath("//VAR[@nombre='SICC_CUSTOM_TITTLE']");
                Node var = (Node)xpath.selectSingleNode(getXML());
                if(var == null)
                {
                    var = getXML().createElement("VAR");
                    ((Element)var).setAttribute("nombre", "SICC_CUSTOM_TITTLE");
                }
                ((Element)var).setAttribute("valor", (String)conectorParametroSesion("descripcionPeriodo"));
                
                formulario.appendChild(var);
            }
        }
    }
    // Fin agregado SICC20070322
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

	private void cargaComboTipoClien()throws Exception{
		
		ComposerViewElementList cv = crearParametrosEntrada();
        ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
        traza("antes del conector.ejecucion");
        conector.ejecucion();
        traza("antes del conector");
        DruidaConector resultados = conector.getConector();

        traza("antes de asignar al COMBO");
        asignar("COMBO","cbTipoCliente",resultados,"MAEObtenerTipos");      

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
        
		tipSolicitud.setIDBusiness("MAEObtenerTipos");
		tipSolicitud.setDTOE(dtoBel);
        
        lista.addViewElement(tipSolicitud);
        return lista;
    }

}
