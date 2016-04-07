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

import java.io.ByteArrayOutputStream;
import java.io.PrintStream; 

import java.util.Vector;
import java.util.Date;

import java.sql.Timestamp;

import es.indra.druida.DruidaConector;

import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.xml.XMLDocument;

import es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOString;

import es.indra.sicc.dtos.bel.DTOERecuperarRegistroAbastecimiento;
import es.indra.sicc.dtos.bel.DTORegistroAbastecimiento;
import es.indra.sicc.dtos.bel.DTORegistroAbastecimientoDetalle;

import es.indra.sicc.dtos.mae.DTOProducto;

import es.indra.sicc.logicanegocio.bel.ConstantesBEL;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.ejb.FinderException;
 
import java.math.BigDecimal;
 
public class LPIngresoFisicoHojaDemanda extends LPSICCBase {
		  
		  private String accion	= null;
		  private String casoUso = "";
		  private Long subacceso = null;
		  private Long pais = null;
		  private Long idioma = null;
		  
          public LPIngresoFisicoHojaDemanda() {
                    super();
          }
          
          public void inicio() throws Exception {
          
          }

          public void ejecucion() throws Exception {
          rastreo();
          setTrazaFichero();
          traza("*** Entrada - LPIngresoFisicoHojaDemanda - ejecucion ***");
          
          //Recuperamos pais e idioma de session
		 this.idioma = UtilidadesSession.getIdioma(this);
		 this.pais = UtilidadesSession.getPais(this);
		 traza("*** pais ***"+ this.pais);
		 traza("*** idioma ***"+ this.idioma);
          
          this.accion = conectorParametroLimpia("accion", "", true);
                    try  {
                            if(this.accion.equals("")){
                           		this.cargarPagina();  	
                            }else if(this.accion.equals("ingresar")){
                            	this.casoUso = "ingresar";
                            	this.ingresar(); 
                            }else if(this.accion.equals("añadir")){
                            	this.casoUso = "añadir";
                            	this.añadir();
                            }else if(this.accion.equals("modificar")){
                            	this.casoUso = "modificar";
                            	this.modificar();
                            }else if(this.accion.equals("buscarProducto")){
                            	this.casoUso = "buscarProducto";
                            	this.buscarProducto();
                            }else if(this.accion.equals("guardarLineaDetalle")){
                            	this.casoUso = "guardarLineaDetalle";
                            	this.guardarLineaDetalle();
                            }else if(this.accion.equals("guardar")){
                            	this.casoUso = "guardar";
                            	this.guardar();
                            }else if(this.accion.equals("mostrar")){
                            	this.casoUso = "mostrar";
                            	this.mostrarListados();
                            }
                            asignarAtributo("VAR","casoUso","valor",this.casoUso);
                            asignarAtributo("VAR","pais","valor",this.pais.toString());
							asignarAtributo("VAR","idioma","valor",this.idioma.toString());
                            getConfiguracionMenu("LPIngresoFisicoHojaDemanda",this.casoUso);
                    }
                    catch ( Exception e )  {
                              logStackTrace(e);
                              lanzarPaginaError(e);
                    }
           traza("*** Salida - LPIngresoFisicoHojaDemanda - ejecucion ***");
          }
          
	private void cargarPagina() throws Exception  {
		traza("*** Entrada - LPIngresoFisicoHojaDemanda - cargarPagina ***");
		pagina("contenido_hoja_demanda_ingreso_fisico");
		asignarAtributo("PAGINA","contenido_hoja_demanda_ingreso_fisico","cod","0485");
        asignarAtributo("PAGINA","contenido_hoja_demanda_ingreso_fisico","msgle","Ingreso físico hoja de demanda");
		
		obtenerSubacceso();
		
		//generamos VAR para el formato de fecha
		generarHiddenFormatoFecha();
		
		DTOERecuperarRegistroAbastecimiento dto = new DTOERecuperarRegistroAbastecimiento();
		dto.setOidPais(this.pais);
		dto.setOidIdioma(this.idioma);
		dto.setSubacceso(this.subacceso);
		dto.setEstado(ConstantesBEL.ESTADO_HOJA_DEMANDA_CONFIRMADO);
		
		//-> Invocar al conector "ConectorConsultarMediosPagoBelcenter" con idBusiness anterior y el objeto DTOOID creado 
		Vector paramEntrada = new Vector();
		paramEntrada.add(dto);
		paramEntrada.add(new MareBusinessID("BELObtenerHojaDemanda")); 
		DruidaConector conector = conectar("ConectorObtenerHojaDemanda", paramEntrada);
		
		DTOSalida resultado = (DTOSalida)conector.objeto("DTOSalida");
		
		RecordSet rs = resultado.getResultado();
		Vector cols = new Vector();
		cols.add(rs.getColumnName(rs.getColumnPosition("OID")));
		cols.add(rs.getColumnName(rs.getColumnPosition("NUM_SOLI")));
		cols.add(rs.getColumnName(rs.getColumnPosition("FEC_CONF")));
        DruidaConector conectorCargaCombo = this.generarConectorFormato( "DTOSalida.combo_ROWSET", rs, cols);

		asignar("LISTAEDITABLE", "datosHojaDemanda", conectorCargaCombo, "DTOSalida.combo_ROWSET");
		
		traza("*** Salida - LPIngresoFisicoHojaDemanda - cargarPagina ***");
	}
	
	private void obtenerSubacceso() throws Exception {
		traza("*** Entrada - LPIngresoFisicoHojaDemanda - obtenerSubacceso ***");
		
		String ip = this.getRequest().getRemoteAddr();
		traza("*** ip ***"+ ip);
		traza("*** pais ***"+ this.pais);
		traza("*** idioma ***"+ this.idioma);
		
		DTOString dto = new DTOString();
		dto.setCadena(ip);
		dto.setOidPais(this.pais);
		dto.setOidIdioma(this.idioma);
		traza("*** Pais del dto ***"+ dto.getOidPais());
		traza("*** Idioma del dto ***"+ dto.getOidIdioma());
		Vector paramEntrada = new Vector();
		paramEntrada.add(dto);
		paramEntrada.add(new MareBusinessID("BELObtenerSubaccesoAsociado")); 
		traza("*** Llamamos al conector ***");
		DruidaConector conector = conectar("ConectorObtenerSubaccesoAsociado", paramEntrada);
		traza("*** Recuperamos el DTOOID  ***");
		DTOOID resultado = (DTOOID)conector.objeto("DTOOID");
		traza("*** Asignamos oid a la variable ***");
		this.subacceso = resultado.getOid();
		
		traza("*** Salida - LPIngresoFisicoHojaDemanda - obtenerSubacceso ***");
	}
	
	private void ingresar() throws Exception {
		traza("*** Entrada - LPIngresoFisicoHojaDemanda - ingresar ***");
		
		pagina("contenido_hoja_demanda_ingresar");
		asignarAtributo("PAGINA","contenido_hoja_demanda_ingresar","cod","0485");
		
		//recuperamos el oid seleccionado
		String oid = conectorParametroLimpia("datosHojaDemanda","",true);
		traza("*** Codigo Seleccionado  ***"+ oid);
		
		DTOOID dto = new DTOOID();
		dto.setOidPais(this.pais);
		dto.setOidIdioma(this.idioma);
		dto.setOid(new Long(oid));
		
		Vector paramEntrada = new Vector();
		paramEntrada.add(dto);
		paramEntrada.add(new MareBusinessID("BELObtenerRegistroAbastecimiento")); 
		DruidaConector conector = conectar("ConectorObtenerRegistroAbastecimiento", paramEntrada);
		traza("*** Conector ejecutado  ***");
		DTORegistroAbastecimiento dtos = (DTORegistroAbastecimiento)conector.objeto("DTORegistroAbastecimiento");
		
		//Mapeamos el DTO en la página en las variables ocultas
		asignarAtributo("VAR","oidMarca","valor",dtos.getOidMarca().toString());
		asignarAtributo("VAR","marca","valor",dtos.getDescripcionMarca());
		asignarAtributo("VAR","oidCanal","valor",dtos.getOidCanal().toString());
		asignarAtributo("VAR","canal","valor",dtos.getDescripcionCanal());
		asignarAtributo("VAR","oidAcceso","valor",dtos.getOidAcceso().toString());
		asignarAtributo("VAR","acceso","valor",dtos.getDescripcionAcceso());
		asignarAtributo("VAR","subacceso","valor",dtos.getDescripcionSubacceso());
		asignarAtributo("VAR","oidSubacceso","valor",dtos.getOidSubacceso().toString());
		asignarAtributo("VAR","almacen","valor",dtos.getDescripcionAlmacen());
		asignarAtributo("VAR","oidAlmacen","valor",dtos.getOidAlmacen().toString());
		asignarAtributo("VAR","numeroSolicitud","valor",dtos.getNSolicitud().toString());
		asignarAtributo("VAR","oidPeriodo","valor",dtos.getOidPeriodo().toString());
		asignarAtributo("VAR","oidRegistroAbastecimientoCabecera","valor",dtos.getOid().toString());
		asignarAtributo("VAR","oidAgrupacionStock","valor",dtos.getOidAgrupacionStock().toString());
		
		//Ponemos los valores en los label.
		asignarAtributo("LABELC","lbldtMarca","valor",dtos.getDescripcionMarca());
		asignarAtributo("LABELC","lbldtCanal","valor",dtos.getDescripcionCanal());
		asignarAtributo("LABELC","lbldtAcceso","valor",dtos.getDescripcionAcceso());
		asignarAtributo("LABELC","lbldtSubacceso","valor",dtos.getDescripcionSubacceso());
		asignarAtributo("LABELC","lbldtAlmacen","valor",dtos.getDescripcionAlmacen());
		asignarAtributo("LABELC","lbldtNumSolicitud","valor",dtos.getNSolicitud().toString());
		
		traza("*** Codigo que devuelve dto  ***"+ dtos.getOid().toString());
		
		traza("*** Salida - LPIngresoFisicoHojaDemanda - ingresar ***");
	}

	private void añadir() throws Exception {
		traza("*** Entrada - LPIngresoFisicoHojaDemanda - añadir ***");
		
		pagina("contenido_hoja_demanda_ingresar_detalle");
		asignarAtributo("PAGINA","contenido_hoja_demanda_ingresar_detalle","cod","0485");
		
		//recuperamos oidRegistroAbastecimientoCabecera
		String oid = conectorParametroLimpia("oidRegistroAbastecimientoCabecera","",true);
    
    //recuperamos los codigos de productos
    String codigosProductos = conectorParametroLimpia("arrCodigosProductos","",true);
    traza("*** Salida - LPIngresoFisicoHojaDemanda - codigosProductos ***" + codigosProductos );
		
		//mapeamos el valor en la pantalla
		asignarAtributo("VAR","oidRegistroAbastecimientoCabecera","valor",oid);
    asignarAtributo("VAR","hArrCodigosProductos","valor",codigosProductos);
		
		//Recuperamos separador decimales y miles
		String separadorDecimales = UtilidadesSession.getSeparadorDecimales(this);
		String separadorMiles = ",";
        if (separadorDecimales.equals(",")) {
        	separadorMiles = ".";
        }
		asignar("VAR","hid_SeparadorMiles", separadorMiles);
		asignar("VAR","hid_SeparadorDecimales", separadorDecimales);
		
		//deshabilitamos todos los campos excepto "codigoProducto" y "unidadesAtendidas"
		asignarAtributo("COMBO","cbFlagActuacion","readonly","S");
		
		//Ponemos un 0 en lbldtUnidadesEnviadades y lbldtUnidadesconfirmadas
		asignarAtributo("LABELC","lbldtUnidadesEnviadades","valor",new Long(0).toString());
		asignarAtributo("LABELC","lbldtUnidadesconfirmadas","valor",new Long(0).toString());
		asignarAtributo("VAR","unidEnvi","valor",new Long(0).toString());
		asignarAtributo("VAR","unidConfir","valor",new Long(0).toString());
				
		traza("*** Salida - LPIngresoFisicoHojaDemanda - añadir ***");
	}
	
	private void modificar() throws Exception {
		traza("*** Entrada - LPIngresoFisicoHojaDemanda - modificar ***");
		
		pagina("contenido_hoja_demanda_ingresar_detalle");
		asignarAtributo("PAGINA","contenido_hoja_demanda_ingresar_detalle","cod","0485");
		
		//recuperamos oidRegistroAbastecimientoCabecera
		String oid = conectorParametroLimpia("oidRegistroAbastecimientoCabecera","",true);
		traza("*** OID de cabecera ***"+ oid);
		//mapeamos el valor en la pantalla
		asignarAtributo("VAR","oidRegistroAbastecimientoCabecera","valor",oid);
		
		//Recuperamos separador decimales y miles
		String separadorDecimales = UtilidadesSession.getSeparadorDecimales(this);
		String separadorMiles = ",";
        if (separadorDecimales.equals(",")) {
        	separadorMiles = ".";
        }
		asignar("VAR","hid_SeparadorMiles", separadorMiles);
		asignar("VAR","hid_SeparadorDecimales", separadorDecimales);
		
		//recuperamos datos de lista editable
		String oidDetalle = conectorParametroLimpia("oidDetalle","",true);
		asignarAtributo("VAR","oidDetalle","valor",oidDetalle);
		String oidProducto = conectorParametroLimpia("oidProducto","",true);
		asignarAtributo("VAR","oidProducto","valor",oidProducto);
		String codigoProducto = conectorParametroLimpia("codigoProducto","",true);
		asignarAtributo("CTEXTO","txtCodigoProducto","valor",codigoProducto);
		String descripcionCorta = conectorParametroLimpia("descripcionCorta","",true);
		asignarAtributo("LABELC","lbldtDescripcionProducto","valor",descripcionCorta);
		String unidadesEnviadas = conectorParametroLimpia("unidadesEnviadas","",true);
		asignarAtributo("LABELC","lbldtUnidadesEnviadades","valor",unidadesEnviadas);
		String unidadesCofirmadas = conectorParametroLimpia("unidadesCofirmadas","",true);
		asignarAtributo("LABELC","lbldtUnidadesconfirmadas","valor",unidadesCofirmadas);
		String unidadesAtendidas = conectorParametroLimpia("unidadesAtendidas","",true);
		asignarAtributo("CTEXTO","txtUnidadesAtendidas","valor",unidadesAtendidas);
		
		asignarAtributo("VAR","unidEnvi","valor",unidadesEnviadas);
		asignarAtributo("VAR","unidConfir","valor",unidadesCofirmadas);
		
		traza("*** Salida - LPIngresoFisicoHojaDemanda - modificar ***");
	}
	
	private void buscarProducto() throws Exception {
		traza("*** Entrada - LPIngresoFisicoHojaDemanda - buscarProducto ***");
		
		//pagina("contenido_hoja_demanda_ingresar_detalle");
		pagina("salidaGenerica");
        asignar("VAR", "cerrarVentana", "false");
        asignar("VAR","ejecutarError","errorProducto()");

		//Recuperamos los datos del detalle
		String codigo = conectorParametroLimpia("txtCodigoProducto","",true);
		
		DTOString dto = new DTOString();
		dto.setOidPais(this.pais);
		dto.setOidIdioma(this.idioma);
		dto.setCadena(codigo);
		
		Vector paramEntrada = new Vector();
		paramEntrada.add(dto);
		paramEntrada.add(new MareBusinessID("BELBuscarProductoHDDetalle")); 
		
		DruidaConector conector = conectar("ConectorBuscarProductoHDDetalle", paramEntrada);
			
		DTOProducto dtos = (DTOProducto)conector.objeto("DTOProducto");
		
		asignar("VAR", "ejecutar", "cargaDescrip('"+ dtos.getDescCorta() +"','"+ dtos.getOid().toString() +"')");
		traza("*** Descripcion  ***"+ dtos.getDescCorta());
		traza("*** Oid producto  ***"+ dtos.getOid().toString());
		
		traza("*** Salida - LPIngresoFisicoHojaDemanda - buscarProducto ***");
	}
	
	private void guardarLineaDetalle() throws Exception {
		traza("*** Entrada - LPIngresoFisicoHojaDemanda - guardarLineaDetalle ***");
		
		pagina("salidaGenerica");
		asignar("VAR", "cerrarVentana", "true");
		asignar("VAR", "ejecutar", "cerrarVentana()");
		
		//recuperamos datos de la página
		String oid = conectorParametroLimpia("oidDetalle","",true);
		traza(" oid "+ oid);
		String oidMaestroProducto = conectorParametroLimpia("oidProducto","",true);
		traza(" oidProducto "+ oidMaestroProducto);
		String unidadesConfirmadas = conectorParametroLimpia("unidConfir","",true);
		traza(" uniConfi "+ unidadesConfirmadas);
		String unidadesEnviadas = conectorParametroLimpia("unidEnvi","",true);
		traza(" uniEnvi "+ unidadesEnviadas);
		String unidadesAtendidas = conectorParametroLimpia("txtUnidadesAtendidas","",true);
		traza(" uniAten "+ unidadesAtendidas);
		String oidTipoActuacion = conectorParametroLimpia("oidActuacion","",true);
		traza(" tipoActu "+ oidTipoActuacion);
		String oidRegistroCabecera = conectorParametroLimpia("oidRegistroAbastecimientoCabecera","",true);
		traza(" oidCabec "+ oidRegistroCabecera);
		
		traza(" creamos DTO ");
		DTORegistroAbastecimientoDetalle raDetalle = new DTORegistroAbastecimientoDetalle();
		if((!oid.equals("null"))&&(!oid.equals(""))){
			traza(" dentro del if ");
			raDetalle.setOid(new Long(oid));
			traza(" oid ");
		}
		traza("pasado el if oid ");
		raDetalle.setOidProducto(new Long(oidMaestroProducto));
		traza(" oidProd ");
		raDetalle.setUnidadesConfirmadas(new Long(unidadesConfirmadas));
		traza(" uniConfi ");
		raDetalle.setUnidadesEnviadas(new Long(unidadesEnviadas));
		traza(" uniEnvi ");
		raDetalle.setUnidadesAtendidas(new Long(unidadesAtendidas));
		traza(" uniAten ");
		raDetalle.setOidTipoActuacion(new Long(oidTipoActuacion));
		traza(" oidCabec ");
		raDetalle.setOidRegistroAbastecimientoCabecera(new Long(oidRegistroCabecera));
		
		Vector paramEntrada = new Vector();
		paramEntrada.add(raDetalle);
		paramEntrada.add(new MareBusinessID("BELGuardarHDDetalle")); 
		traza(" llamamos conector ");
		DruidaConector conector = conectar("ConectorGuardarHDDetalle", paramEntrada);
		
		traza("*** Salida - LPIngresoFisicoHojaDemanda - guardarLineaDetalle ***");
	}
	
	private void guardar() throws Exception {
		traza("*** Entrada - LPIngresoFisicoHojaDemanda - guardar ***");
		
		pagina("salidaGenerica");
        asignar("VAR", "cerrarVentana", "false");
        asignar("VAR", "ejecutar", "Correcto()");
		
		
		//Recuperamos datos de la xml
		String oidRegistroCabecera = conectorParametroLimpia("oidRegistroAbastecimientoCabecera","",true);
		traza(" oidCabecera "+ oidRegistroCabecera);
		String marca = conectorParametroLimpia("oidMarca","",true);
		String canal = conectorParametroLimpia("oidCanal","",true);
		String acceso = conectorParametroLimpia("oidAcceso","",true);
		String subacceso = conectorParametroLimpia("oidSubacceso","",true);
		
		DTORegistroAbastecimiento hojaDemanda = new DTORegistroAbastecimiento();
		hojaDemanda.setOid(new Long(oidRegistroCabecera));
		hojaDemanda.setOidEstadoHojaDemanda(ConstantesBEL.ESTADO_HOJA_DEMANDA_INGRESADO);
		hojaDemanda.setFechaIngresado(new Timestamp(System.currentTimeMillis()));
		hojaDemanda.setOidPais(this.pais);
		hojaDemanda.setOidIdioma(this.idioma);
		hojaDemanda.setOidMarca(new Long(marca));
		hojaDemanda.setOidCanal(new Long(canal));
		hojaDemanda.setOidSubacceso(new Long(subacceso));
		hojaDemanda.setOidAcceso(new Long(acceso));
		
		Vector paramEntrada = new Vector();
		paramEntrada.add(hojaDemanda);
		paramEntrada.add(new MareBusinessID("BELGuardarIngresoFisicoHD")); 
		DruidaConector conector = conectar("ConectorGuardarIngresoFisicoHD", paramEntrada);
		
		//this.mostrarListados();
		
		/*conectorActionOpener(true);
        conectorAction("LPIngresoFisicoHojaDemanda"); */
		
		traza("*** Salida - LPIngresoFisicoHojaDemanda - guardar ***");
	}
	
	private void mostrarListados() throws Exception{
		traza("*** Entrada - LPIngresoFisicoHojaDemanda - mostrarlistados ***");
		
		pagina("contenido_hoja_demanda_ingresar_flag");
		asignarAtributo("PAGINA","contenido_hoja_demanda_ingresar_flag","cod","0485");
		
		String oidRegistroCabecera = conectorParametroLimpia("oidRegistroAbastecimientoCabecera","",true);
		asignarAtributo("VAR","oidRegistroAbastecimientoCabecera","valor",oidRegistroCabecera);
		traza(" oidCabecera "+ oidRegistroCabecera);
		
		traza("*** Salida - LPIngresoFisicoHojaDemanda - mostrarlistados ***");
	}
	
	// Devuelve cadena de fecha conforme al formato que está en sesion
    private String obtieneCadenaFecha(java.sql.Date valor) throws Exception {
    	String fecha = new String("");
    	if (valor != null) {
    	         fecha = UtilidadesBelcorp.fechaFormateada(valor, UtilidadesSession.getFormatoFecha(this));
    	}
    	
    	return fecha;
    }

	private DruidaConector generarConectorFormato(String rowsetID, RecordSet datos, Vector columns) throws Exception, DOMException {
        StringBuffer salida = new StringBuffer();
        int sizeColums = datos.getColumnCount();
        int sizeRows = datos.getRowCount();
        if(columns == null)
            columns = new Vector();
        Vector columsDesc = datos.getColumnIdentifiers();
        DruidaConector conectorValoresPosibles = new DruidaConector();
        XMLDocument xmlDoc = new XMLDocument();
        Document docDestino = xmlDoc.makeDocument("<ROWSET2/>");
        Element e_rows = docDestino.createElement("ROWSET");
        e_rows.setAttribute("ID", rowsetID);
        docDestino.getDocumentElement().appendChild(e_rows);
        for (int i = 0; i < sizeRows; i++) {
            Element e_row = docDestino.createElement("ROW");
            e_rows.appendChild(e_row);
            for(int j = 0; j < sizeColums; j++)
                if(columns.contains(columsDesc.elementAt(j))) {
                    Element e_campo2 = docDestino.createElement("CAMPO");
                    e_campo2.setAttribute("NOMBRE", columsDesc.elementAt(j).toString());
                    e_campo2.setAttribute("TIPO", "OBJECTO");
                    e_campo2.setAttribute("LONGITUD", "50");
                    String dato = "";
                    Object datoObj = datos.getValueAt(i, j);
                    if (datoObj != null ) {
                    	if (datoObj instanceof java.sql.Date)
                    		dato = this.obtieneCadenaFecha((java.sql.Date) datoObj);
                    	else
                    		dato = datoObj.toString();
                    }
                    org.w3c.dom.Text txt = docDestino.createTextNode(dato);
                    e_campo2.appendChild(txt);
                    e_row.appendChild(e_campo2);
                }
        }

        conectorValoresPosibles.setXML(docDestino.getDocumentElement());
        return conectorValoresPosibles;
    }

	
    private void logStackTrace(Throwable e) throws Exception {
                    traza("Se produjo la excepcion: " + e.getMessage());
                    
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    PrintStream ps = new PrintStream(baos);
                    e.printStackTrace(ps);
                    
                    traza("Stack Trace: " + baos.toString());
     }

}

