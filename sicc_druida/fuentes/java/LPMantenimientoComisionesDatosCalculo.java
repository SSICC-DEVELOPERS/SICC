import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.com.DTOComisiones;
import es.indra.sicc.dtos.com.DTOComisionesCobranza;
import es.indra.sicc.dtos.com.DTOComisionesCobranzaTipoParticipante;
import es.indra.sicc.dtos.com.DTOComisionesVentas;
import es.indra.sicc.dtos.com.DTOComisionesVentasHistoricas;
import es.indra.sicc.dtos.cra.DTOID;
import es.indra.sicc.logicanegocio.com.ConstantesCOM;
import es.indra.sicc.logicanegocio.com.ConstantesCOMPestanyas;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;

public class LPMantenimientoComisionesDatosCalculo extends LPComisiones {
	private String accion = null;
	private String sPais = null;     
	private String sIdioma = null;
	private String sDescPais = null;     
	private Long lIdioma = null;
	private Long lPais = null;   

	private Long lMarca;
	private Long lCanal;

	private String idPestanyaDest;

	private static final String CAMPO_OID = "OID";
	private static final String CAMPO_OID_COM_COB = "OID_COM_COB";
	private static final String CAMPO_NIVEL_TRAMO = "NIVEL_TRAMO";
	private static final String CAMPO_DIAS_COM = "DIAS_COM";
	private static final String CAMPO_PORC_RECUP = "PORC_RECUP";
	private static final String CAMPO_PORC_COM = "PORC_COM";
  
	private boolean $debug = false;

	//Guardan los tramos de comisiones creados en la ventana modal.
	//String con el formato: xx,xx,xx,xx|xx,xx,xx,xx|xx,xx,xx,xx|...
	private String sTramosComisionesCapital;
	private String sTramosComisionesProvincia;
	private String sTramosComisionesFrontera;

	private String hDiasTrasFacturacionCapital;
	private String hDiasTrasFacturacionProvincia;
	private String hDiasTrasFacturacionFrontera;

	private String sTipoComision;

	private String TIPO_COMISION_VENTAS = null; 
	private String TIPO_COMISION_COBRANZA = null;

	public LPMantenimientoComisionesDatosCalculo() { super(); }

	public void inicio() throws Exception {	
		this.pagina("contenido_comisiones_datosComision_insertar");
	}  
  
	public void ejecucion() throws Exception {       
		setTrazaFichero();    
  		traza("************ Entre a LPMantenimientoComisionesDatosCalculo");

		accion = conectorParametroLimpia("accion", "", true);    
	    opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
		titulo = conectorParametroLimpia("titulo", "", true);
		oidTipoPlantilla = conectorParametroLimpia("oidTipoPlantilla", "", true);
		estadoVentana = conectorParametroLimpia("estadoVentana", "", true);

		traza("************ accion:" + accion);
		traza("************ opcionMenu:" + opcionMenu);
		traza("************ titulo:" + titulo);
		traza("************ oidTipoPlantilla:" + oidTipoPlantilla);
		traza("************ estadoVentana:" + estadoVentana);

		asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);

		sPais = UtilidadesSession.getPais(this).toString();
		sIdioma = UtilidadesSession.getIdioma(this).toString();
		sDescPais = UtilidadesSession.getDescripcionPais(this).toString();  	  
		lIdioma = UtilidadesSession.getIdioma(this);
		lPais = UtilidadesSession.getPais(this);

		//------------------------------------------------------
		if($debug){
			opcionMenu = "insertar";
		}
		//------------------------------------------------------

		//Recuperar los tramos de comisiones
		sTramosComisionesCapital = conectorParametroLimpia("hTramosComisionesCapital", "", true);
		sTramosComisionesProvincia = conectorParametroLimpia("hTramosComisionesProvincia", "", true);
		sTramosComisionesFrontera = conectorParametroLimpia("hTramosComisionesFrontera", "", true);
		traza("sTramosComisionesCapital: " + sTramosComisionesCapital);
		traza("sTramosComisionesProvincia: " + sTramosComisionesProvincia);
		traza("sTramosComisionesFrontera: " + sTramosComisionesFrontera);

	    hDiasTrasFacturacionCapital = conectorParametroLimpia("hDiasTrasFacturacionCapital", "", true);
	    hDiasTrasFacturacionProvincia = conectorParametroLimpia("hDiasTrasFacturacionProvincia", "", true);
	    hDiasTrasFacturacionFrontera = conectorParametroLimpia("hDiasTrasFacturacionFrontera", "", true);
		traza("hDiasTrasFacturacionCapital: " + hDiasTrasFacturacionCapital);
		traza("hDiasTrasFacturacionProvincia: " + hDiasTrasFacturacionProvincia);
		traza("hDiasTrasFacturacionFrontera: " + hDiasTrasFacturacionFrontera);

		//asignar constantes a pagina
		String sTipoParticipanteFrontera = ConstantesCOM.TIPO_PARTICIPANTE_FRONTERA.toString();
		String sTipoParticipanteProvincia = ConstantesCOM.TIPO_PARTICIPANTE_PROVINCIA.toString();
		String sTipoParticipanteCapital = ConstantesCOM.TIPO_PARTICIPANTE_CAPITAL.toString();
		traza("sTipoParticipanteCapital: " + sTipoParticipanteCapital);
		traza("sTipoParticipanteProvincia: " + sTipoParticipanteProvincia);
		traza("sTipoParticipanteFrontera: " + sTipoParticipanteFrontera);
		asignarAtributo("VAR", "TIPO_PARTICIPANTE_CAPITAL", "valor", sTipoParticipanteCapital);
		asignarAtributo("VAR", "TIPO_PARTICIPANTE_PROVINCIA", "valor", sTipoParticipanteProvincia);
		asignarAtributo("VAR", "TIPO_PARTICIPANTE_FRONTERA", "valor", sTipoParticipanteFrontera);

		String sTipoComisionVentas = ConstantesCOM.TIPO_COMISION_VENTAS.toString();
	    String sTipoComisionCobranza = ConstantesCOM.TIPO_COMISION_COBRANZA.toString();		
	    traza("sTipoComisionVentas: " + sTipoComisionVentas);
		traza("sTipoComisionCobranza: " + sTipoComisionCobranza);    
		asignarAtributo("VAR", "TIPO_COMISION_VENTAS", "valor", sTipoComisionVentas);
		asignarAtributo("VAR", "TIPO_COMISION_COBRANZA", "valor", sTipoComisionCobranza);

		try {			  
			if(accion.equals(""))  {
				traza("************ Llamando a getFormatosValidaciones");
				getFormatosValidaciones();

			    asignarAtributo("VAR", "titulo", "valor", titulo);
				asignarAtributo("VAR", "oidTipoPlantilla", "valor", oidTipoPlantilla);
				asignarAtributo("VAR", "estadoVentana", "valor", estadoVentana);

				idPestanya = ConstantesCOMPestanyas.PESTANYA_DATOS_CALCULO;
				this.recuperarMarcaCanal();
				cargarPantalla();
			}
			else if(accion.equals("almacenar")) {
				if(!opcionMenu.equals("consultar")) {
					almacenar();
				}

				setearMarcaCanal();
				idPestanyaDest = conectorParametroLimpia("idPestanyaDest", "", true);
		        redirigir(new Integer(idPestanyaDest));
			}
			else if(accion.equals("guardar")) {           
				almacenar();
				try {
					this.guardar();          
					if(opcionMenu.equals("insertar")) {
						this.setComision(null);          
						this.conectorAction("LPInsertarComisiones");
					}
					else{
					  // 23192 - dmorello, 30/05/2006: Luego de guardar, corresponde cerrar la ventana modal
					  //asignarAtributo("VAR", "ejecutar", "valor", "reInicio()");          
					  asignarAtributo("VAR", "ejecutar", "valor", "window.close();");
					}
				}
				catch(Exception e) {
				  asignarAtributo("VAR", "ejecutarError", "valor", "fErrorAlGuardar()");          
				  throw e;
				}
			}
			else if(accion.equals("mostrarDetalleComisiones")){
				pagina("contenido_comisiones_datosComision_insertar_detalle");
				traza("************ Llamando a getFormatosValidaciones");
				getFormatosValidaciones();

				this.mostrarDetalleComisiones();
			}
			cargarMenuSecundario();
		}
		catch(Exception e)  {
			ByteArrayOutputStream pila = new ByteArrayOutputStream();
			PrintStream out = new PrintStream(pila);
			e.printStackTrace(out);
			traza("EL STACK ES COMO SIGUE : " +  pila.toString());
			e.printStackTrace(); 
			e.getMessage();
			lanzarPaginaError(e);
		}
	}

	public void setearMarcaCanal() throws Exception {
	    DTOComisiones dtoc = this.getComision();

		if(dtoc == null){
		  dtoc = new DTOComisiones();
	    }

		//Seteando marca y canal, se usaran al pasar de pestaña
		if(dtoc.getOidMarca()!=null) {
			marcaTemp = dtoc.getOidMarca().toString();
		}
		if(dtoc.getOidCanal()!=null) {
			canalTemp = dtoc.getOidCanal().toString();
		}		

	}

	public void almacenar() throws Exception {
		traza("*********** Entre a almacenar");

		pagina("salidaGenerica");          

	    DTOComisiones dtoc = this.getComision();

		if(dtoc == null){
		  dtoc = new DTOComisiones();
	    }
    
	    dtoc = this.levantarMarcoCriterios(dtoc);

		if(sTipoComision.equals(ConstantesCOM.TIPO_COMISION_VENTAS.toString())){ //ventas
			traza("*** Entro por ventas");

			DTOComisionesVentas dtocv = null;
			DTOComisionesVentasHistoricas dtocvh = null;
      
			if(opcionMenu.equalsIgnoreCase("insertar")){
				traza("*** Inicializa por insertar");
				dtocv = new DTOComisionesVentas();
				dtocvh = new DTOComisionesVentasHistoricas();
			}
			else if(opcionMenu.equalsIgnoreCase("consultar")){
				traza("*** Inicializa por consultar");
				dtocv = new DTOComisionesVentas();
				dtocvh = new DTOComisionesVentasHistoricas();
			}
			else if(opcionMenu.equalsIgnoreCase("modificar")){
				traza("*** Inicializa por modificar");
				dtocv = dtoc.getComisionesVentas();
				dtocvh = dtoc.getComisionesVentaHistorica();
				if(dtocv==null) {
					dtocv = new DTOComisionesVentas();
				}
				if(dtocvh==null) {
					dtocvh = new DTOComisionesVentasHistoricas();
				}
			}

			dtoc.setComisionesVentas(dtocv);
			dtoc.setComisionesVentaHistorica(dtocvh);

			//Levantar datos de pantalla a dto en sesion
			dtoc = levantarMarcoVentas(dtoc);
			dtoc = levantarMarcoVentaHistorica(dtoc);
			dtoc.setIndVentaCobranza(ConstantesCOM.COMISION_VENTAS);

			dtoc.setComisionesCobranza(new ArrayList());
			setComision(dtoc);
		}
		else if(sTipoComision.equals(ConstantesCOM.TIPO_COMISION_COBRANZA.toString())){ //cobranza
			traza("*** Entro por cobranza");

		    dtoc = this.levantarMarcoCobranza(dtoc);

			//Otros campos
			dtoc.setIndVentaCobranza(ConstantesCOM.COMISION_COBRANZAS);
		    dtoc.setComisionesVentas(null);
			dtoc.setComisionesVentaHistorica(null);
			traza("***** dtoc.getComisionesCobranza() " + dtoc.getComisionesCobranza());
		} //else

	    //MARCO DATOS DE LA MODIFICACION
	    dtoc = this.levantarMarcoDatosModificacion(dtoc);

	    traza("*********** Salio de almacenar");
	}

	private DTOComisiones levantarMarcoCriterios(DTOComisiones dtoc) throws Exception {  
		traza("********** Entre a levantarMarcoCriterios");

	    sTipoComision = conectorParametroLimpia("hTipoComision", "", true);
		traza("*** sTipoComision: " + sTipoComision);
  
		try {
			dtoc.setOidTipoComision(sTipoComision!=null&&sTipoComision.length()>0?
	        new Long(sTipoComision):null);
		}
		catch(NumberFormatException nfe){
		}    

		String sConcepto = conectorParametroLimpia("hConcepto", "", true);
		traza("*** sConcepto: " + sConcepto);
	    dtoc.setConcepto(sConcepto);  

	    return dtoc;
	}

	private DTOComisiones levantarMarcoVentas(DTOComisiones dtoc) throws Exception {  
	    DTOComisionesVentas dtocv = dtoc.getComisionesVentas();
		traza("***** dtocv: " + dtocv );
  
		String sAplicarComision = conectorParametroLimpia("hAplicarComision", "", true);
	    String sCalcularIncobrables = conectorParametroLimpia("varCalcularIncobrables", "", true);
		String sFechaEmision = conectorParametroLimpia( "hFechaEmision", "", true);
	    String sFechaVencimiento = conectorParametroLimpia( "hFechaVencimiento", "", true);
		String sDiasIncobrables = conectorParametroLimpia( "hDiasIncobrables", "", true);
		String sFormula = conectorParametroLimpia("varFormula", "", true);
	    String sDevoluciones = conectorParametroLimpia("varDevoluciones", "", true);
		String sAnulaciones = conectorParametroLimpia("varAnulaciones", "", true);
	    String sFaltantesNoAnunciados = conectorParametroLimpia("varFaltantesNoAnunciados", "", true);
		String sPorcentajeComision = conectorParametroNumero( "htxtPorcentaje", this.FORMATO_DEFAULT);
	    String sImporteFijo = conectorParametroNumero( "htxtImporteFijo", this.FORMATO_DEFAULT);		
		String sComparativo = conectorParametroLimpia("varComparativo", "", true); 
  
		traza("***** sAplicarComision: " + sAplicarComision );
		traza("***** sCalcularIncobrables: " + sCalcularIncobrables );
		traza("***** sFechaEmision: " + sFechaEmision );
		traza("***** sFechaVencimiento: " + sFechaVencimiento );
		traza("***** sDiasIncobrables: " + sDiasIncobrables );
		traza("***** sFormula: " + sFormula );
		traza("***** sDevoluciones: " + sDevoluciones);
		traza("***** sAnulaciones: " + sAnulaciones );
		traza("***** sFaltantesNoAnunciados: " + sFaltantesNoAnunciados );
		traza("***** sPorcentajeComision: " + sPorcentajeComision );
		traza("***** sImporteFijo: " + sImporteFijo );
		traza("***** sComparativo: " + sComparativo );  

		//Aplicar comision
		if(sAplicarComision.equals("")) dtocv.setOidTipoComisionVenta(null);
		else dtocv.setOidTipoComisionVenta(new Long(sAplicarComision.toString()));		
		
		//Calcular incobrables
		if(sCalcularIncobrables.equalsIgnoreCase("S")) dtocv.setCalculoIncobrables(Boolean.TRUE);
		else dtocv.setCalculoIncobrables(Boolean.FALSE);

		//Fecha Emision
		if(sFechaEmision.equalsIgnoreCase("S")) {
			dtocv.setCalculoIncobrablesFechaEmision(Boolean.TRUE);
		}
		else {
			dtocv.setCalculoIncobrablesFechaEmision(Boolean.FALSE);
		}

		//Fecha vencimiento
		if(sFechaVencimiento.equalsIgnoreCase("S")) {
			dtocv.setCalculoIncobrablesFechaVencimiento(Boolean.TRUE);
		}
		else {
			dtocv.setCalculoIncobrablesFechaVencimiento(Boolean.FALSE);
		}

		//Dias para incobrables
		if(sDiasIncobrables.equals("")) dtocv.setDiasIncobrables(null);
		else dtocv.setDiasIncobrables(new Integer(sDiasIncobrables));

		//Formula
		if(sFormula.equals("")) dtocv.setOidFormula(null);
		else dtocv.setOidFormula(new Long(sFormula));

		//Devoluciones
		if(sDevoluciones.equalsIgnoreCase("S")) dtocv.setDevoluciones(Boolean.TRUE);
		else dtocv.setDevoluciones(Boolean.FALSE);

		//Anulaciones
		if(sAnulaciones.equalsIgnoreCase("S")) dtocv.setAnulaciones(Boolean.TRUE);
		else dtocv.setAnulaciones(Boolean.FALSE);

		//Faltantes no anunciados
		if(sFaltantesNoAnunciados.equalsIgnoreCase("S")) dtocv.setFaltantesNoAnunciados(Boolean.TRUE);
		else dtocv.setFaltantesNoAnunciados(Boolean.FALSE);

		//Comision (porcentaje)
		if(sPorcentajeComision.equals("")) dtocv.setPorcentajeComision(null);
		else dtocv.setPorcentajeComision(new BigDecimal(sPorcentajeComision));

		//Importe fijo
		if(sImporteFijo.equals("")) dtocv.setImporteFijoComision(null);
		else dtocv.setImporteFijoComision(new BigDecimal(sImporteFijo));

		//Comparativo
		if(sComparativo.equals("")) dtocv.setOidTipoComisionVentaIncremental(null);
		else dtocv.setOidTipoComisionVentaIncremental(new Long(sComparativo));
	  
		return dtoc;
  }

	private DTOComisiones levantarMarcoVentaHistorica(DTOComisiones dtoc) throws Exception {  
		traza("******** Entre a levantarMarcoVentaHistorica");
		DTOComisionesVentasHistoricas dtocvh;		
	  
		String sPeriodoInicialEvaluacion = conectorParametroLimpia( "oidPeriodoInicialEval", "", true);
		String sPeriodoFinalEvaluacion = conectorParametroLimpia( "oidPeriodoFinalEval", "", true);
		String sPorcentajeIncremento = conectorParametroNumero( "htxtPorcentajeIncremento", this.FORMATO_DEFAULT);
		String sMonto = conectorParametroNumero( "htxtMonto", this.FORMATO_DEFAULT);		
		String sDevolucionesEnMetas = conectorParametroLimpia("varDevolucionesEnMetas", "", true);
		String sAnulacionesEnMetas = conectorParametroLimpia("varAnulacionesEnMetas", "", true);

		traza("***** sPeriodoInicialEvaluacion: " + sPeriodoInicialEvaluacion);
		traza("***** sPeriodoFinalEvaluacion: " + sPeriodoFinalEvaluacion);
		traza("***** sPorcentajeIncremento: " + sPorcentajeIncremento );
		traza("***** sMonto: " + sMonto );
		traza("***** sDevolucionesEnMetas: " + sDevolucionesEnMetas );
		traza("***** sAnulacionesEnMetas: " + sAnulacionesEnMetas );

		if(sPeriodoInicialEvaluacion.equals("") && sPeriodoFinalEvaluacion.equals("")) {
			dtocvh = null;
		}
		else {
			dtocvh = new DTOComisionesVentasHistoricas();
			//Periodo inicial evaluacion
			dtocvh.setOidPeriodoInicio(new Long(sPeriodoInicialEvaluacion));

			//Periodo final evaluacion
			dtocvh.setOidPeriodoFinal(new Long(sPeriodoFinalEvaluacion));		

			//Porcentaje incremento
			if(sPorcentajeIncremento.equals("")) dtocvh.setPorcentajeIncremento(null);
			else dtocvh.setPorcentajeIncremento(new BigDecimal(sPorcentajeIncremento));

			//Monto incremento
			if(sMonto.equals("")) dtocvh.setMontoIncremento(null);
			else dtocvh.setMontoIncremento(new BigDecimal(sMonto));

			//Devoluciones en metas
			if(sDevolucionesEnMetas.equals("S")) dtocvh.setDevoluciones(new Boolean(true));
			else dtocvh.setDevoluciones(new Boolean(false));

			//Anulaciones en metas
			if(sAnulacionesEnMetas.equals("S")) dtocvh.setAnulaciones(new Boolean(true));
			else dtocvh.setAnulaciones(new Boolean(false));
		}		  

		traza("********* VOY A DEVOLVER ESTO EN VENTA HISTORICA dtocvh " + dtocvh);
		dtoc.setComisionesVentaHistorica(dtocvh);
		return dtoc;
	}

	private DTOComisiones levantarMarcoCobranza(DTOComisiones dtoc) throws Exception {  
		traza("********* Entre a levantarMarcoCobranza");

		DTOComisionesCobranza dtoCCCapital = null;
		DTOComisionesCobranza dtoCCProvincia = null;
		DTOComisionesCobranza dtoCCFrontera = null;

		ArrayList alDTOCC = dtoc.getComisionesCobranza();

		ArrayList vDtocctpCapital = new ArrayList();
		ArrayList vDtocctpProvincia = new ArrayList();
		ArrayList vDtocctpFrontera = new ArrayList();

		DTOComisionesCobranzaTipoParticipante dtocctp = new DTOComisionesCobranzaTipoParticipante();

		traza("***** sTramosComisionesCapital: " + sTramosComisionesCapital);
		traza("***** sTramosComisionesProvincia: " + sTramosComisionesProvincia);
		traza("***** sTramosComisionesFrontera: " + sTramosComisionesFrontera);

		traza("***** hDiasTrasFacturacionCapital: " + hDiasTrasFacturacionCapital);
		traza("***** hDiasTrasFacturacionProvincia: " + hDiasTrasFacturacionProvincia);
		traza("***** hDiasTrasFacturacionFrontera: " + hDiasTrasFacturacionFrontera);

		StringTokenizer strTokenCapital = new StringTokenizer(sTramosComisionesCapital, "|");
		StringTokenizer strTokenProvincia = new StringTokenizer(sTramosComisionesProvincia, "|");
		StringTokenizer strTokenFrontera = new StringTokenizer(sTramosComisionesFrontera, "|");
		StringTokenizer strTokenTemp = null;
		// vbongiov -- Cambio 20090913 -- 5/08/2009
		String porcentajeActividad = null;

		// sapaza -- PER-SiCC-2010-0478 -- 19/08/2010
		String porcentajeComisionActividad = null;
		
		//while para capital
		while(strTokenCapital.hasMoreTokens()){
		  String linea = strTokenCapital.nextToken();
		   //Agregado 31/10/2005 por incidencia Peru DBLG400000843
		  traza("***** linea antes de replace: " + linea);
		  linea = UtilidadesBelcorp.replace(linea, ",,", ", ,");
		  traza("***** linea después de replace: " + linea);
		  strTokenTemp = new StringTokenizer(linea, ",");
		  String oid = strTokenTemp.nextToken();
		  String nivelTramo = strTokenTemp.nextToken();
		  String diasComision = strTokenTemp.nextToken();
		  String porcentajeRecuperacion = desFormatearNumero(strTokenTemp.nextToken().trim(), this.FORMATO_DEFAULT);
		  String porcentajeComision = desFormatearNumero(strTokenTemp.nextToken().trim(), this.FORMATO_DEFAULT);

		  // vbongiov -- Cambio 20090913 -- 5/08/2009
		  if(strTokenTemp.hasMoreTokens()){
			  porcentajeActividad = desFormatearNumero(strTokenTemp.nextToken().trim(), this.FORMATO_DEFAULT);
		  } else {
			  porcentajeActividad = "";
		  }

		  // sapaza -- PER-SiCC-2010-0478 -- 19/08/2010
		  if(strTokenTemp.hasMoreTokens()){
			  porcentajeComisionActividad = desFormatearNumero(strTokenTemp.nextToken().trim(), this.FORMATO_DEFAULT);
		  } else {
			  porcentajeComisionActividad = "";
		  }
		  
		  traza("***** CAPITAL");
		  traza("***** nivelTramo: " + nivelTramo);
		  traza("***** diasComision: " + diasComision);
		  traza("***** porcentajeRecuperacion: " + porcentajeRecuperacion);
		  traza("***** porcentajeComision: " + porcentajeComision);
		  traza("***** porcentajeActividad: " + porcentajeActividad);
		  traza("***** porcentajeComisionActividad: " + porcentajeComisionActividad);

		  dtocctp = new DTOComisionesCobranzaTipoParticipante();
		  dtocctp.setOid(null);
		  dtocctp.setOidComisionesCobranzas(null);
		  dtocctp.setNivelTramo(new Integer(nivelTramo));
		  dtocctp.setDiasComision(new Integer(diasComision));
		  dtocctp.setPorcentajeRecuperacion(new BigDecimal(porcentajeRecuperacion));
		  dtocctp.setPorcentajeComision(new BigDecimal(porcentajeComision));
		  // vbongiov -- Cambio 20090913 -- 5/08/2009
		  dtocctp.setPorcentajeActividad(porcentajeActividad.equals("")?null:new BigDecimal(porcentajeActividad));

		  // sapaza -- PER-SiCC-2010-0478 -- 19/08/2010
		  dtocctp.setPorcentajeComisionActividad(porcentajeComisionActividad.equals("")?null:new BigDecimal(porcentajeComisionActividad));
		  
		  vDtocctpCapital.add(dtocctp);
		}

		//while para provincia
		while(strTokenProvincia.hasMoreTokens()){
		  String linea = strTokenProvincia.nextToken();
		   //Agregado 31/10/2005 por incidencia Peru DBLG400000843
		  traza("***** linea antes de replace: " + linea);
		  linea = UtilidadesBelcorp.replace(linea, ",,", ", ,");
		  traza("***** linea después de replace: " + linea);
		  strTokenTemp = new StringTokenizer(linea, ",");
		  String oid = strTokenTemp.nextToken();
		  String nivelTramo = strTokenTemp.nextToken();
		  String diasComision = strTokenTemp.nextToken();
		  String porcentajeRecuperacion = desFormatearNumero(strTokenTemp.nextToken().trim(), this.FORMATO_DEFAULT);
		  String porcentajeComision = desFormatearNumero(strTokenTemp.nextToken().trim(), this.FORMATO_DEFAULT);

		  // vbongiov -- Cambio 20090913 -- 5/08/2009
		  if(strTokenTemp.hasMoreTokens()){
			  porcentajeActividad = desFormatearNumero(strTokenTemp.nextToken().trim(), this.FORMATO_DEFAULT);
		  } else {
			  porcentajeActividad = "";
		  }
		  
		  // sapaza -- PER-SiCC-2010-0478 -- 19/08/2010
		  if(strTokenTemp.hasMoreTokens()){
			  porcentajeComisionActividad = desFormatearNumero(strTokenTemp.nextToken().trim(), this.FORMATO_DEFAULT);
		  } else {
			  porcentajeComisionActividad = "";
		  }

		  traza("***** PROVINCIA");
		  traza("***** nivelTramo: " + nivelTramo);
		  traza("***** diasComision: " + diasComision);
		  traza("***** porcentajeRecuperacion: " + porcentajeRecuperacion);
		  traza("***** porcentajeComision: " + porcentajeComision);

		  dtocctp = new DTOComisionesCobranzaTipoParticipante();
		  dtocctp.setOid(null); 
		  dtocctp.setOidComisionesCobranzas(null);
		  dtocctp.setNivelTramo(new Integer(nivelTramo));
		  dtocctp.setDiasComision(new Integer(diasComision));
		  dtocctp.setPorcentajeRecuperacion(new BigDecimal(porcentajeRecuperacion));
		  dtocctp.setPorcentajeComision(new BigDecimal(porcentajeComision));
		  // vbongiov -- Cambio 20090913 -- 5/08/2009
		  dtocctp.setPorcentajeActividad(porcentajeActividad.equals("")?null:new BigDecimal(porcentajeActividad));
		  
		  // sapaza -- PER-SiCC-2010-0478 -- 19/08/2010
		  dtocctp.setPorcentajeComisionActividad(porcentajeComisionActividad.equals("")?null:new BigDecimal(porcentajeComisionActividad));
		  
		  vDtocctpProvincia.add(dtocctp);
		}

		//String porcentajeRecuperacion = desFormatearNumero(strTokenTemp.nextToken(), this.FORMATO_DEFAULT);

		//while para frontera
		while(strTokenFrontera.hasMoreTokens()){
		  String linea = strTokenFrontera.nextToken();
		   //Agregado 31/10/2005 por incidencia Peru DBLG400000843
		  traza("***** linea antes de replace: " + linea);
		  linea = UtilidadesBelcorp.replace(linea, ",,", ", ,");
		  traza("***** linea después de replace: " + linea);
		  strTokenTemp = new StringTokenizer(linea, ",");
		  String oid = strTokenTemp.nextToken();
		  String nivelTramo = strTokenTemp.nextToken();
		  String diasComision = strTokenTemp.nextToken();
		  String porcentajeRecuperacion = desFormatearNumero(strTokenTemp.nextToken().trim(), this.FORMATO_DEFAULT);
		  String porcentajeComision = desFormatearNumero(strTokenTemp.nextToken().trim(), this.FORMATO_DEFAULT);

		  // vbongiov -- Cambio 20090913 -- 5/08/2009
		  if(strTokenTemp.hasMoreTokens()){
			  porcentajeActividad = desFormatearNumero(strTokenTemp.nextToken().trim(), this.FORMATO_DEFAULT);
		  } else {
			  porcentajeActividad = "";
		  }

		  // sapaza -- PER-SiCC-2010-0478 -- 19/08/2010
		  if(strTokenTemp.hasMoreTokens()){
			  porcentajeComisionActividad = desFormatearNumero(strTokenTemp.nextToken().trim(), this.FORMATO_DEFAULT);
		  } else {
			  porcentajeComisionActividad = "";
		  }
		  
		  traza("***** FRONTERA");
		  traza("***** nivelTramo: " + nivelTramo);
		  traza("***** diasComision: " + diasComision);
		  traza("***** porcentajeRecuperacion: " + porcentajeRecuperacion);
		  traza("***** porcentajeComision: " + porcentajeComision);

		  dtocctp = new DTOComisionesCobranzaTipoParticipante();
		  dtocctp.setOid(null);
		  dtocctp.setOidComisionesCobranzas(null);
		  dtocctp.setNivelTramo(new Integer(nivelTramo));
		  dtocctp.setDiasComision(new Integer(diasComision));
		  dtocctp.setPorcentajeRecuperacion(new BigDecimal(porcentajeRecuperacion));
		  dtocctp.setPorcentajeComision(new BigDecimal(porcentajeComision));
		  // vbongiov -- Cambio 20090913 -- 5/08/2009
		  dtocctp.setPorcentajeActividad(porcentajeActividad.equals("")?null:new BigDecimal(porcentajeActividad));
		  
		  // sapaza -- PER-SiCC-2010-0478 -- 19/08/2010
		  dtocctp.setPorcentajeComisionActividad(porcentajeComisionActividad.equals("")?null:new BigDecimal(porcentajeComisionActividad));
		  
		  vDtocctpFrontera.add(dtocctp);
		}
	  
		if(vDtocctpCapital != null && vDtocctpCapital.size() > 0){
		  dtoCCCapital = new DTOComisionesCobranza();
		  if(!hDiasTrasFacturacionCapital.equals("")) {
	 		  dtoCCCapital.setDiasTrasFacturacion(new Integer(hDiasTrasFacturacionCapital));
		  }
		  dtoCCCapital.setOidTipoParticipante(ConstantesCOM.TIPO_PARTICIPANTE_CAPITAL);
		  dtoCCCapital.setComisionesCobranzasTipoParticipante(vDtocctpCapital);
		}
	  
		if(vDtocctpProvincia != null && vDtocctpProvincia.size() > 0){
		  dtoCCProvincia = new DTOComisionesCobranza();
		  if(!hDiasTrasFacturacionProvincia.equals("")) {
			  dtoCCProvincia.setDiasTrasFacturacion(new Integer(hDiasTrasFacturacionProvincia));
		  }
		  dtoCCProvincia.setOidTipoParticipante(ConstantesCOM.TIPO_PARTICIPANTE_PROVINCIA);
		  dtoCCProvincia.setComisionesCobranzasTipoParticipante(vDtocctpProvincia);
		}
		
		if(vDtocctpFrontera != null && vDtocctpFrontera.size() > 0){
		  dtoCCFrontera = new DTOComisionesCobranza();
		  if(!hDiasTrasFacturacionFrontera.equals("")) {
			  dtoCCFrontera.setDiasTrasFacturacion(new Integer(hDiasTrasFacturacionFrontera));
		  }
		  dtoCCFrontera.setOidTipoParticipante(ConstantesCOM.TIPO_PARTICIPANTE_FRONTERA);
		  dtoCCFrontera.setComisionesCobranzasTipoParticipante(vDtocctpFrontera);
		}
	  
		ArrayList alDTOC = new ArrayList();
		
		if(dtoCCCapital != null){
		  alDTOC.add(dtoCCCapital);
		  traza("***** agrego dtoCCCapital");
		}

		if(dtoCCProvincia != null){
		  alDTOC.add(dtoCCProvincia);
		  traza("***** agrego dtoCCProvincia");
		}
	  
		if(dtoCCFrontera != null){
		  alDTOC.add(dtoCCFrontera);
		  traza("***** agrego dtoCCFrontera");
		}
	  
		dtoc.setComisionesCobranza(alDTOC);
	  
		return dtoc;
  }


	private DTOComisiones levantarMarcoDatosModificacion(DTOComisiones dtoc) throws Exception {  
		traza("***** Entre a levantarMarcoDatosModificacion");

		String sPeriodoEntradaVigor = conectorParametroLimpia( "hPeriodoEntradaEnVigor", "", true);
		String sObservaciones = conectorParametroLimpia( "hObservaciones", "", true);

		traza("***** sPeriodoEntradaVigor: " + sPeriodoEntradaVigor);
		traza("***** sObservaciones: " + sObservaciones);

		try{
		  dtoc.setOidPeriodoVigorModificacion( sPeriodoEntradaVigor!=null&&
			sPeriodoEntradaVigor.length()>0?new Long(sPeriodoEntradaVigor):null);
		}catch(NumberFormatException nfe){}

		dtoc.setObservaciones(sObservaciones);
		
		return dtoc;
	}

	private Vector obtienePeriodosEvaluacion(Long oidPeriodo) throws Exception {
		DTOOID dtoOid = new DTOOID();
	    dtoOid.setOid(oidPeriodo);
		dtoOid.setOidIdioma(lIdioma);
	    dtoOid.setOidPais(lPais);

		MareBusinessID businessID = new MareBusinessID("COMObtenerPeriodoAnioAnterior");
		Vector parametros = new Vector();      
      
	    parametros.add(dtoOid);
		parametros.add(businessID);

	    traza("******************* Antes de conectar");
		DruidaConector con = conectar("ConectorObtenerPeriodoAnterior", parametros);
		traza("******************* Despues de conectar");

		DTOSalida dtoSalida = (DTOSalida)con.objeto("DTOSalida");   
		traza("******************* dtoSalida " + dtoSalida);
		Vector datos = null;

		if(dtoSalida.getResultado()!=null) {
			RecordSet rs = dtoSalida.getResultado();		

			BigDecimal oid = (BigDecimal)rs.getValueAt(0,0);
			String descripcion = (String)rs.getValueAt(0,1);

			traza("******************* oid " + oid);
			traza("******************* descripcion " + descripcion);

		    datos = new Vector();
		    datos.add(0, oid);
		    datos.add(1, descripcion);
		}

		return datos;
	}

	public void cargarPantalla() throws Exception {
		Long ventaTotal = ConstantesCOM.COMISION_SOBRE_VENTA_TOTAL;
		asignarAtributo("VAR", "valVentaTotal", "valor", ventaTotal.toString());		
		traza("************** valVentaTotal " + ventaTotal.toString());

		Long incremento = ConstantesCOM.COMISION_SOBRE_INCREMENTO;
		asignarAtributo("VAR", "valIncremento", "valor", incremento.toString());		
		traza("************** valIncremento " + incremento.toString());

	    DTOComisiones dtoCom = this.getComision();
		Boolean comparativo = dtoCom.getComparativo();
		if(comparativo.booleanValue()==true) {
			asignarAtributo("VAR", "seteoAplicarComision", "valor", "true");		
		}
		else {
			asignarAtributo("VAR", "seteoAplicarComision", "valor", "false");		
		}
		
		//Para obtener oid y descripcion de periodo inicial evaluacion
		Vector datosPeriodoInicial = obtienePeriodosEvaluacion(dtoCom.getOidPeriodoDesde());
		if(datosPeriodoInicial!=null) {
			BigDecimal oidPeriodoInicial = (BigDecimal)datosPeriodoInicial.get(0);
			String desPeriodoInicial = (String)datosPeriodoInicial.get(1);
			traza("*********** oidPeriodoInicial " + oidPeriodoInicial);
			traza("*********** desPeriodoInicial " + desPeriodoInicial);

			asignarAtributo("VAR", "oidPeriodoInicialEval", "valor", oidPeriodoInicial.toString());		
			asignarAtributo("VAR", "desPeriodoInicial", "valor", desPeriodoInicial.toString());		
		}
		else {
			asignarAtributo("VAR", "oidPeriodoInicialEval", "valor", "");		
			asignarAtributo("VAR", "desPeriodoInicial", "valor", "");		
		}


		//Para obtener oid y descripcion de periodo final evaluacion
		Vector datosPeriodoFinal = obtienePeriodosEvaluacion(dtoCom.getOidPeriodoHasta());
		if(datosPeriodoFinal!=null) {
			BigDecimal oidPeriodoFinal = (BigDecimal)datosPeriodoFinal.get(0);
			String desPeriodoFinal = (String)datosPeriodoFinal.get(1);

			traza("*********** oidPeriodoFinal " + oidPeriodoFinal);
			traza("*********** desPeriodoFinal " + desPeriodoFinal);

			asignarAtributo("VAR", "oidPeriodoFinalEval", "valor", oidPeriodoFinal.toString());		
			asignarAtributo("VAR", "desPeriodoFinal", "valor", desPeriodoFinal.toString());		
		}
		else {
			asignarAtributo("VAR", "oidPeriodoFinalEval", "valor", "");		
			asignarAtributo("VAR", "desPeriodoFinal", "valor", "");		
		}

		traza("-- Entro a cargar pantalla --");
		traza("opcionMenu: " + opcionMenu);

	    ComposerViewElementList cv = crearParametrosEntradaAnadir(dtoCom);
		ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
	    conector.ejecucion();
		DruidaConector resultados = conector.getConector();
    
	    asignar("COMBO", "cbTipoParticipante", resultados, "COMObtenerTiposParticipantes");
		asignar("COMBO", "cbAplicarComision", resultados, "COMObtenerTiposComisionesVenta");
	    asignar("COMBO", "cbFormula", resultados, "COMObtenerFormulas");
		asignar("COMBO", "cbComparativo", resultados, "COMObtenerTiposComisionesVentaIncremental");
		//Los periodos de la 4° pestaña se cargan solamente en el modificar o en el consultar
		if(!opcionMenu.equals("insertar")){
		    asignar("COMBO", "cbPeriodoEntradaVigor3", resultados, "CRAObtienePeriodosPosterioresFechaActual");
			asignar("COMBO", "cbPeriodoEntradaVigor5", resultados, "CRAObtienePeriodosPosterioresFechaActual");
		}
	    asignar("COMBO", "cbTipoComision", resultados, "COMObtenerTiposPlantilla");

		if(this.opcionMenu != null){
			if(this.opcionMenu.equalsIgnoreCase("modificar") || this.opcionMenu.equalsIgnoreCase("consultar") || 
			this.opcionMenu.equalsIgnoreCase("insertar")  ){          
				
				DTOComisiones dtoc = this.getComision();
				traza("************ Llamando a verificarDatosComision");
				verificarDatosComision();

		        if(dtoc == null){
					return;
				}

		        traza("DTOComisiones de sesion: " + dtoc);

				/////////////////////////////////
				//Mapear los datos de la pantalla
				/////////////////////////////////
        
				cargarMarcoCobranza(dtoc);
				cargarMarcoCriteriosDeSeleccion(dtoc);
				cargarMarcoVentas(dtoc);
				cargarMarcoVentaHistorica(dtoc);
				cargarMarcoDatosModificacion(dtoc);				
        
				if(this.opcionMenu.equals("modificar")){
					dtoc = this.getComision();
          
					if(dtoc != null && dtoc.getOidEstado() != null && 
				    dtoc.getOidEstado().equals(ConstantesCOM.ESTADO_COMISION_SOLICITUD_ACEPTADA)){
					    //únicamente aparecerán habilitados para la modificación los siguientes: 
				        //Porcentaje de Incremento y 
			            //Monto de Incremento, 
						//Porcentaje de Comisión e 
			            //Importe Fijo de la comisión. 
						this.asignarAtributo("VAR", "hHabilitarEstadoSolicitudAutorizada", "valor", "S");
					}
					else{
						/*agregado ciglesias incidencia DBLG700000207 inicio*/
						if (dtoc.getPlantillaDetalle().getOidTipoComision() != null) {
							asignarAtributo("VAR", "varDeshabilitarTipoCom", "valor", "true");
						} else {
							asignarAtributo("VAR", "varDeshabilitarTipoCom", "valor", "false");
						}
						/*agregado ciglesias incidencia DBLG700000207 fin*/

						this.asignarAtributo("VAR", "hHabilitarEstadoSolicitudAutorizada", "valor", "N");
					}
          
					//Se habitilará el Botón Calcular Metas, si se modifica alguno de los valores relacionados 
					//con la venta histórica.
					//TODO: respecto del comentario anterior, ver como determino que se modifico algo.
        
				}
				else if(this.opcionMenu.equals("consultar")){
					//se deshabilita el boton calcularMetas y todos los campos
					this.asignarAtributo("VAR", "hHabilitarCalcularMetas", "valor", "N");
					this.asignarAtributo("VAR", "hDeshabilitarTodo", "valor", "S");
					this.asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
          
				}
			}
		}
	}

	private void cargarMarcoCobranza(DTOComisiones dtoc) throws Exception {  
		//Obtencion de los DTOComisionesCobranza correspondientes a Capital,
		//Provincia y Frontera.
		ArrayList alComisionesCobranzas = dtoc.getComisionesCobranza();
		Iterator i = null;
		DTOComisionesCobranza dtoCCAux = null;
		DTOComisionesCobranza dtoCCCapital = null;
		DTOComisionesCobranza dtoCCFrontera = null;
		DTOComisionesCobranza dtoCCProvincia = null;
			
		traza("llega a condicion");
			
		if(alComisionesCobranzas != null && !alComisionesCobranzas.isEmpty()){    
			traza("entra a condicion");    
		    i = alComisionesCobranzas.iterator();
      
		    while(i.hasNext()){
				dtoCCAux = (DTOComisionesCobranza)i.next();
        
		        if(dtoCCAux != null){
					traza(dtoCCAux);
        
			        if(dtoCCAux.getOidTipoParticipante() != null && dtoCCAux.getOidTipoParticipante().equals(
					    ConstantesCOM.TIPO_PARTICIPANTE_CAPITAL)){ //CAPITAL
						dtoCCCapital = dtoCCAux;
						if(dtoCCCapital.getDiasTrasFacturacion()!=null) {
							this.asignarAtributo("VAR", "hDiasTrasFacturacionCapital", "valor", dtoCCCapital.getDiasTrasFacturacion().toString());
						}
						else {
							this.asignarAtributo("VAR", "hDiasTrasFacturacionCapital", "valor", "");
						}
					}
					else if(dtoCCAux.getOidTipoParticipante() != null && dtoCCAux.getOidTipoParticipante().equals(
						ConstantesCOM.TIPO_PARTICIPANTE_PROVINCIA)){ //PROVINCIA
						dtoCCProvincia = dtoCCAux;
						if(dtoCCProvincia.getDiasTrasFacturacion()!=null) {
							this.asignarAtributo("VAR", "hDiasTrasFacturacionProvincia", "valor", dtoCCProvincia.getDiasTrasFacturacion().toString());						
						}
						else {
							this.asignarAtributo("VAR", "hDiasTrasFacturacionProvincia", "valor", "");						
						}
					}
					else if(dtoCCAux.getOidTipoParticipante() != null && dtoCCAux.getOidTipoParticipante().equals(
						ConstantesCOM.TIPO_PARTICIPANTE_FRONTERA)){ //FRONTERA
						dtoCCFrontera = dtoCCAux;
						if(dtoCCFrontera.getDiasTrasFacturacion()!=null) {
							this.asignarAtributo("VAR", "hDiasTrasFacturacionFrontera", "valor", dtoCCFrontera.getDiasTrasFacturacion().toString());
						}
						else {
							this.asignarAtributo("VAR", "hDiasTrasFacturacionFrontera", "valor", "");
						}

					}
				}
	      }//while
		}
    
	    traza("obtuvo dtoCCs");
		traza("dtoCCCapital: " + dtoCCCapital);
	    traza("dtoCCProvincia: " + dtoCCProvincia);
		traza("dtoCCFrontera: " + dtoCCFrontera);

	    ArrayList alComisionesCobranzasTipoParticipanteCapital = null; 
		if( dtoCCCapital != null ){
	      alComisionesCobranzasTipoParticipanteCapital = 
		  dtoCCCapital.getComisionesCobranzasTipoParticipante(); //ArrayList
		}
    
	    ArrayList alComisionesCobranzasTipoParticipanteProvincia = null;
		if(dtoCCProvincia != null){
	      alComisionesCobranzasTipoParticipanteProvincia = 
		  dtoCCProvincia.getComisionesCobranzasTipoParticipante(); //ArrayList
		}
    
	    ArrayList alComisionesCobranzasTipoParticipanteFrontera = null;
		if( dtoCCFrontera != null ){
	      alComisionesCobranzasTipoParticipanteFrontera = 
		  dtoCCFrontera.getComisionesCobranzasTipoParticipante(); //ArrayList
		}
    
		traza("obtuvo arraylists");
		traza("alComisionesCobranzasTipoParticipanteCapital: " + alComisionesCobranzasTipoParticipanteCapital);
		traza("alComisionesCobranzasTipoParticipanteProvincia: " + alComisionesCobranzasTipoParticipanteProvincia);
		traza("alComisionesCobranzasTipoParticipanteFrontera: " + alComisionesCobranzasTipoParticipanteFrontera);
		
		String sComisionesCobranzasTipoParticipanteCapital = 
		  obtenerStringCobranzaTipoParticipante(alComisionesCobranzasTipoParticipanteCapital);
		String sComisionesCobranzasTipoParticipanteProvincia = 
		  obtenerStringCobranzaTipoParticipante(alComisionesCobranzasTipoParticipanteProvincia);
		String sComisionesCobranzasTipoParticipanteFrontera = 
		  obtenerStringCobranzaTipoParticipante(alComisionesCobranzasTipoParticipanteFrontera);

		traza("sComisionesCobranzasTipoParticipanteCapital: " + sComisionesCobranzasTipoParticipanteCapital);
		traza("sComisionesCobranzasTipoParticipanteProvincia: " + sComisionesCobranzasTipoParticipanteProvincia);
		traza("sComisionesCobranzasTipoParticipanteFrontera: " + sComisionesCobranzasTipoParticipanteFrontera);

		asignarAtributo("VAR", "hTramosComisionesCapital", "valor", sComisionesCobranzasTipoParticipanteCapital);
		asignarAtributo("VAR", "hTramosComisionesProvincia", "valor", sComisionesCobranzasTipoParticipanteProvincia);
		asignarAtributo("VAR", "hTramosComisionesFrontera", "valor", sComisionesCobranzasTipoParticipanteFrontera);

	    traza("DATOS OBTENIDOS DE DTOS EN SESION");
  }

	private void cargarMarcoCriteriosDeSeleccion(DTOComisiones dtoc) throws Exception {  
	    Long lTipoComision = dtoc.getOidTipoComision();
		String sConcepto = dtoc.getConcepto();
    
	    traza("********* lTipoComision: " + lTipoComision);
		traza("********* sConcepto: " + sConcepto);  
    
	    this.asignarAtributo("VAR", "hCBTipoComision", "valor", lTipoComision!=null?lTipoComision.toString():"");  
	    this.asignarAtributo("VAR", "hConcepto", "valor", sConcepto!=null?sConcepto:""); 
	}

	private void cargarMarcoVentas(DTOComisiones dtoc) throws Exception{  
		traza("*** Entre a cargarMarcoVentas");
		DTOComisionesVentas dtocv = dtoc.getComisionesVentas();

		if(dtocv==null) asignarAtributo("VAR", "valDefecto", "valor", "S");
		else asignarAtributo("VAR", "valDefecto", "valor", "N");
        
		Long lAplicarComision = null;
		Boolean bCalculoIncobrables = null;
		Boolean bFechaEmision = null;
		Boolean bFechaVencimiento = null;
		Integer iDiasIncobrables = null;
		Long lFormula = null;
		Boolean bDevoluciones = null;
		Boolean bAnulaciones = null;
		Boolean bFaltantesNoAnunciados = null;
		String tempPorcentajeComision = null;
		String tempImporteFijo = null;		
		Long oidTipoComisionVentaIncremental = null;
		
		if( dtocv != null ){
		  lAplicarComision = dtocv.getOidTipoComisionVenta();
		  bCalculoIncobrables = dtocv.getCalculoIncobrables();
		  bFechaEmision = dtocv.getCalculoIncobrablesFechaEmision();
		  bFechaVencimiento = dtocv.getCalculoIncobrablesFechaVencimiento();
		  iDiasIncobrables = dtocv.getDiasIncobrables();
		  lFormula = dtocv.getOidFormula();
		  bDevoluciones = dtocv.getDevoluciones();
		  bAnulaciones = dtocv.getAnulaciones();
		  bFaltantesNoAnunciados = dtocv.getFaltantesNoAnunciados();

		  if(dtocv.getPorcentajeComision()!=null) {
			tempPorcentajeComision = UtilidadesBelcorp.formateaNumeroSICC(dtocv.getPorcentajeComision().toString(), 
			this.FORMATO_DEFAULT, this);
		  }
		  else {
			tempPorcentajeComision = new String();
		  }	

  		  if(dtocv.getImporteFijoComision()!=null) {
			tempImporteFijo = UtilidadesBelcorp.formateaNumeroSICC(dtocv.getImporteFijoComision().toString(), 
			this.FORMATO_DEFAULT, this);
		  }
		  else {
			tempImporteFijo = new String();
		  }	
		  
		  oidTipoComisionVentaIncremental = dtocv.getOidTipoComisionVentaIncremental();
		}
		
		traza("*** lAplicarComision: " + lAplicarComision);
		traza("*** bCalculoIncobrables: " + bCalculoIncobrables);
		traza("*** bFechaEmision: " + bFechaEmision);
		traza("*** bFechaVencimiento: " + bFechaVencimiento);
		traza("*** iDiasIncobrables: " + iDiasIncobrables);
		traza("*** lFormula: " + lFormula);
		traza("*** bDevoluciones: " + bDevoluciones);
		traza("*** bAnulaciones: " + bAnulaciones);
		traza("*** bFaltantesNoAnunciados: " + bFaltantesNoAnunciados);
		traza("*** tempPorcentajeComision: " + tempPorcentajeComision);
		traza("*** tempImporteFijo: " + tempImporteFijo);
		traza("*** oidTipoComisionVentaIncremental: " + oidTipoComisionVentaIncremental);
			
		traza("*** 1");
		if(lAplicarComision!=null) asignarAtributo("VAR", "hAplicarComision", "valor", lAplicarComision.toString());
		else asignarAtributo("VAR", "hAplicarComision", "valor", "");

		traza("*** 2");
		if(bCalculoIncobrables!=null) {
			if(bCalculoIncobrables.booleanValue()==true) {
				asignarAtributo("VAR", "varCalcularIncobrables", "valor", "S");
			}
			else {
				asignarAtributo("VAR", "varCalcularIncobrables", "valor", "N");
			}
		}
		else {
			asignarAtributo("VAR", "varCalcularIncobrables", "valor", "N");
		}
			
		traza("*** 3");
		if(bFechaEmision!=null) {
			if(bFechaEmision.booleanValue()==true) {
				this.asignarAtributo("VAR", "hFechaEmision", "valor", "S");
			}
			else {
				this.asignarAtributo("VAR", "hFechaEmision", "valor", "N");
			}
		}
		else {
			this.asignarAtributo("VAR", "hFechaEmision", "valor", "N");
		}

		traza("*** 4");
		if(bFechaVencimiento!=null) {
			if(bFechaVencimiento.booleanValue()==true) {
				this.asignarAtributo("VAR", "hFechaVencimiento", "valor", "S");
			}
			else {
				this.asignarAtributo("VAR", "hFechaVencimiento", "valor", "N");
			}
		}
		else {
			this.asignarAtributo("VAR", "hFechaVencimiento", "valor", "N");
		}
		
		traza("*** 5");
		if(iDiasIncobrables!=null) {
			this.asignarAtributo("VAR", "tempDiasIncobrables", "valor", iDiasIncobrables.toString());
		}
		else {
			this.asignarAtributo("VAR", "tempDiasIncobrables", "valor", "");
		}

		traza("*** 6");
		this.asignarAtributo("VAR", "varFormula", "valor", lFormula!=null?lFormula.toString():"");

		traza("*** 7");
		this.asignarAtributo("VAR", "varDevoluciones", "valor", 
		  bDevoluciones!=null&&bDevoluciones.booleanValue()?"S":"N");
		
		traza("*** 8");
		this.asignarAtributo("VAR", "varAnulaciones", "valor", 
		  bAnulaciones!=null&&bAnulaciones.booleanValue()?"S":"N");

		traza("*** 9");
		this.asignarAtributo("VAR", "varFaltantesNoAnunciados", "valor", 
		  bFaltantesNoAnunciados!=null&&bFaltantesNoAnunciados.booleanValue()?"S":"N");
		
		traza("*** 10");
		this.asignarAtributo("VAR", "tempPorcentaje", "valor", tempPorcentajeComision!=null?tempPorcentajeComision.toString():""); 

		traza("*** 11");
		this.asignarAtributo("VAR", "tempImporteFijo", "valor", tempImporteFijo!=null?tempImporteFijo.toString():"");		
		traza("*** 12");
		this.asignarAtributo("VAR", "varComparativo", "valor", 
		  oidTipoComisionVentaIncremental!=null?oidTipoComisionVentaIncremental.toString():""); 
	}

	private void cargarMarcoVentaHistorica(DTOComisiones dtoc) throws Exception {  
		traza("*** Entre a cargarMarcoVentaHistorica");

		DTOComisionesVentasHistoricas dtocvh = dtoc.getComisionesVentaHistorica();

		Long lPeriodoInicio = null;
		Long lPeriodoFinal = null;
		String tempPorcentajeIncremento = null;
		String tempMontoIncremento = null;
		Boolean bDevolucionesEnMetas = null;
		Boolean bAnulacionesEnMetas = null;

		if( dtocvh != null ){
		  lPeriodoInicio = dtocvh.getOidPeriodoInicio();
		  lPeriodoFinal = dtocvh.getOidPeriodoFinal();

		  if(dtocvh.getPorcentajeIncremento()!=null) {
			tempPorcentajeIncremento = UtilidadesBelcorp.formateaNumeroSICC(dtocvh.getPorcentajeIncremento().toString(), 
				this.FORMATO_DEFAULT, this);
		  }
		  else {
			tempPorcentajeIncremento = new String();
		  }		

		  if(dtocvh.getMontoIncremento()!=null) {
			tempMontoIncremento = UtilidadesBelcorp.formateaNumeroSICC(dtocvh.getMontoIncremento().toString(), 
				this.FORMATO_DEFAULT, this);
		  }
		  else {
			tempMontoIncremento = new String();
		  }		

		  bDevolucionesEnMetas = dtocvh.getDevoluciones();
		  bAnulacionesEnMetas = dtocvh.getAnulaciones();
		}

		traza("*** lPeriodoInicio: " + lPeriodoInicio);
		traza("*** lPeriodoFinal: " + lPeriodoFinal);
		traza("*** tempPorcentajeIncremento: " + tempPorcentajeIncremento);
		traza("*** tempMontoIncremento: " + tempMontoIncremento);
		traza("*** bDevolucionesEnMetas: " + bDevolucionesEnMetas);
		traza("*** bAnulacionesEnMetas: " + bAnulacionesEnMetas);

		this.asignarAtributo("VAR", "tempPorcentajeIncremento", "valor", tempPorcentajeIncremento!=null?tempPorcentajeIncremento:""); 
		this.asignarAtributo("VAR", "tempMonto", "valor", tempMontoIncremento!=null?tempMontoIncremento:""); 

		this.asignarAtributo("VAR", "varDevolucionesEnMetas", "valor", 
		  bDevolucionesEnMetas!=null&&bDevolucionesEnMetas.booleanValue()?"S":"N");
		
		this.asignarAtributo("VAR", "varAnulacionesEnMetas", "valor", 
		  bAnulacionesEnMetas!=null&&bAnulacionesEnMetas.booleanValue()?"S":"N");
	}

	private void cargarMarcoDatosModificacion(DTOComisiones dtoc) throws Exception {  
		Long lPeriodoEntradaVigor = dtoc.getOidPeriodoVigorModificacion();
	    String sObservaciones = dtoc.getObservaciones();

		traza("*********** lPeriodoEntradaVigor " + lPeriodoEntradaVigor);
		traza("*********** sObservaciones " + sObservaciones);
    
		this.asignarAtributo("VAR", "hPeriodoEntradaEnVigor", "valor", 
	    lPeriodoEntradaVigor!=null?lPeriodoEntradaVigor.toString():"");

		this.asignarAtributo("VAR", "hObservaciones", "valor", 
		sObservaciones!=null?sObservaciones:"");
	}

/*
if(concurso.getRequisitosPremiacion().getMontoMinimoConcurso()!=null) {
	montoMinimoConcurso = UtilidadesBelcorp.formateaNumeroSICC(concurso.getRequisitosPremiacion().getMontoMinimoConcurso().toString(), 
	this.FORMATO_DEFAULT, this);
}
else {
	montoMinimoConcurso = new String();
}		
*/

	private String obtenerStringCobranzaTipoParticipante(ArrayList al) throws Exception{
		DTOComisionesCobranzaTipoParticipante dtoCCTP = null;
	    Iterator it = null;
    
		if(al != null && al.size() > 0){
	      it = al.iterator();
		  StringBuffer sbComisionesCobranzaTipoCapital = new StringBuffer();
      
		  while(it.hasNext()){
			dtoCCTP = (DTOComisionesCobranzaTipoParticipante)it.next();
        
			if(dtoCCTP != null){          
				String oid = dtoCCTP.getOid() != null ? dtoCCTP.getOid().toString() : "";
				String nivelTramo = dtoCCTP.getNivelTramo() != null ? dtoCCTP.getNivelTramo().toString() : "";
				String numDiasCom = dtoCCTP.getDiasComision() != null ? dtoCCTP.getDiasComision().toString() : "";
				String porcentajeRecuperacion;
				String porcentajeComision;
				// vbongiov -- Cambio 20090913 -- 5/08/2009
				String porcentajeActividad;

				if(dtoCCTP.getPorcentajeRecuperacion() != null) {
					porcentajeRecuperacion =  UtilidadesBelcorp.formateaNumeroSICC(dtoCCTP.getPorcentajeRecuperacion().toString(), 
					this.FORMATO_DEFAULT, this);
				}
				else {
					porcentajeRecuperacion = "";
				}

				if(dtoCCTP.getPorcentajeComision() != null) {
					porcentajeComision = UtilidadesBelcorp.formateaNumeroSICC(dtoCCTP.getPorcentajeComision().toString(), 
					this.FORMATO_DEFAULT, this);
				}
				else {
					porcentajeComision = "";
				}			
				
				// vbongiov -- Cambio 20090913 -- 5/08/2009
				if(dtoCCTP.getPorcentajeActividad() != null) {
					porcentajeActividad = UtilidadesBelcorp.formateaNumeroSICC(dtoCCTP.getPorcentajeActividad().toString(), 
					this.FORMATO_DEFAULT, this);
				}
				else {
					porcentajeActividad = "";
				}		

				// sapaza -- PER-SiCC-2010-0478 -- 19/08/2010
				String porcentajeComisionActividad;
				if(dtoCCTP.getPorcentajeComisionActividad() != null) {
					porcentajeComisionActividad = UtilidadesBelcorp.formateaNumeroSICC(dtoCCTP.getPorcentajeComisionActividad().toString(), 
					this.FORMATO_DEFAULT, this);
				}
				else {
					porcentajeComisionActividad = "";
				}		
				
				if(sbComisionesCobranzaTipoCapital.toString().length() > 0){
					sbComisionesCobranzaTipoCapital.append("|");
				}

			    sbComisionesCobranzaTipoCapital.append(nivelTramo); 
				//en oid se usa nivel tramo para insertar en lista editable
			    sbComisionesCobranzaTipoCapital.append("#");
			    sbComisionesCobranzaTipoCapital.append(nivelTramo);
				sbComisionesCobranzaTipoCapital.append("#");
				sbComisionesCobranzaTipoCapital.append(numDiasCom);
				sbComisionesCobranzaTipoCapital.append("#");
				sbComisionesCobranzaTipoCapital.append(porcentajeRecuperacion);
				sbComisionesCobranzaTipoCapital.append("#");
				sbComisionesCobranzaTipoCapital.append(porcentajeComision);
				// vbongiov -- Cambio 20090913 -- 5/08/2009
				sbComisionesCobranzaTipoCapital.append("#");
				sbComisionesCobranzaTipoCapital.append(porcentajeActividad);
				
				// sapaza -- PER-SiCC-2010-0478 -- 19/08/2010
				sbComisionesCobranzaTipoCapital.append("#");
				sbComisionesCobranzaTipoCapital.append(porcentajeComisionActividad);
			}
		}
      return sbComisionesCobranzaTipoCapital.toString();
    }else{
      return "";
    }
  }
   
  private ComposerViewElementList crearParametrosEntradaAnadir(DTOComisiones dtoComisiones) throws Exception{  
		traza("************ Entre a crearParametrosEntradaAnadir");
    
		traza("Idioma: " + lIdioma);
		traza("Pais: " + lPais);
		traza("Marca: " + lMarca);
		traza("Canal: " + lCanal);

		//cmbTipoParticipantes
		DTOBelcorp dtoe = new DTOBelcorp(); 
		dtoe.setOidIdioma(lIdioma);
		dtoe.setOidPais(lPais);

		//Para los combos periodo entrada vigor
		DTOID dtoID = new DTOID();
		dtoID.setOidPais(lPais);
		dtoID.setCanal(dtoComisiones.getOidCanal());
		dtoID.setMarca(dtoComisiones.getOidMarca());
    
		ComposerViewElementList lista = new ComposerViewElementList(); 
		
		//Primer componente - cmbTipoParticipantes
		ComposerViewElement cve1 = new ComposerViewElement();
		cve1.setIDBusiness("COMObtenerTiposParticipantes");
		cve1.setDTOE(dtoe);
		
		//Segundo componente - cmbAplicarComision
		ComposerViewElement cve2 = new ComposerViewElement();
		cve2.setIDBusiness("COMObtenerTiposComisionesVenta");
		cve2.setDTOE(dtoe);

		//Tercer componente - cmbFormula
		ComposerViewElement cve3 = new ComposerViewElement();
		cve3.setIDBusiness("COMObtenerFormulas");
		cve3.setDTOE(dtoe);
		
		//Cuarto componente - cmbComparativo
		ComposerViewElement cve4 = new ComposerViewElement();
		cve4.setIDBusiness("COMObtenerTiposComisionesVentaIncremental");
		cve4.setDTOE(dtoe);
    
		//Quinto componente - periodoEntradaEnVigor
		ComposerViewElement cve5 = new ComposerViewElement();
		cve5.setIDBusiness("CRAObtienePeriodosPosterioresFechaActual");
		cve5.setDTOE(dtoID);

		//Sexto componente - cmbTiposVenta
		ComposerViewElement cve6 = new ComposerViewElement();
		cve6.setIDBusiness("COMObtenerTiposPlantilla");

		lista.addViewElement(cve1);
		lista.addViewElement(cve2);
		lista.addViewElement(cve3);
		lista.addViewElement(cve4);

		//Los periodos de la 4° pestaña se cargan solamente en el modificar o en el consultar
		if(!opcionMenu.equals("insertar")){
			lista.addViewElement(cve5);		    
		}		
		
		lista.addViewElement(cve6);
    
		return lista;
  }

	private void recuperarMarcaCanal() throws Exception {  
		traza("****** Entre a recuperarMarcaCanal");
  
	    String marca = this.conectorParametroLimpia("marcaTemp", "", true);
		String canal = this.conectorParametroLimpia("canalTemp", "", true);
    
	    traza("****** marca: " + marca);
		traza("****** canal: " + canal);
    
	    if(marca.length() > 0){
			try{
				lMarca = new Long(marca);
			}
			catch(NumberFormatException nfe){}
		}
    
		if(canal.length() > 0){
			try{
				lCanal = new Long(canal);
			}
			catch(NumberFormatException nfe){}
		}
  }
  
  //Recibe un ArrayList de DTOComisionesCobranzaTipoParticipante
  //Devuelve un RecordSet con la siguiente estructura:
  //
  // Long  Long          Integer       Integer    BigDecimal   BigDecimal
  // OID | OID_COM_COB | NIVEL_TRAMO | DIAS_COM | PORC_RECUP | PORC_COM
	private RecordSet obtenerRecordSet(ArrayList al) throws Exception{    
		traza("***** Entre a obtenerRecordSet");
	    Iterator i = null;
		DTOComisionesCobranzaTipoParticipante dto = null;
	    RecordSet rs = new RecordSet();
    
		Vector cab = new Vector();
	    Vector row = null;
    
		cab.add(LPMantenimientoComisionesDatosCalculo.CAMPO_OID);
	    cab.add(LPMantenimientoComisionesDatosCalculo.CAMPO_OID_COM_COB);
		cab.add(LPMantenimientoComisionesDatosCalculo.CAMPO_NIVEL_TRAMO);
	    cab.add(LPMantenimientoComisionesDatosCalculo.CAMPO_DIAS_COM);
		cab.add(LPMantenimientoComisionesDatosCalculo.CAMPO_PORC_RECUP);
	    cab.add(LPMantenimientoComisionesDatosCalculo.CAMPO_PORC_COM);
    
		rs.setColumnIdentifiers(cab);
    
	    if(al != null && !al.isEmpty()){
		  i = al.iterator();
      
			while(i.hasNext()){
				dto = (DTOComisionesCobranzaTipoParticipante)i.next();
				row = new Vector();
		        row.add(dto.getOid());
			    row.add(dto.getOidComisionesCobranzas());
				row.add(dto.getNivelTramo());
		        row.add(dto.getDiasComision());
			    row.add(dto.getPorcentajeRecuperacion());
				row.add(dto.getPorcentajeComision());
				rs.addRow(row);
			}
		}    
		
		return rs;
	}
  
	private void mostrarDetalleComisiones() throws Exception {  
		traza("***** Entre a mostrarDetalleComisiones");

		String sTipoParticipante = conectorParametro("tipoParticipante");

		if(sTipoParticipante.equals(ConstantesCOM.TIPO_PARTICIPANTE_FRONTERA.toString())) {
			asignarAtributo("LABELC", "lblDatos", "cod", "00550");
		}
		else if(sTipoParticipante.equals(ConstantesCOM.TIPO_PARTICIPANTE_PROVINCIA.toString())) {
			asignarAtributo("LABELC", "lblDatos", "cod", "00549");
		}
		else if(sTipoParticipante.equals(ConstantesCOM.TIPO_PARTICIPANTE_CAPITAL.toString())) {
			asignarAtributo("LABELC", "lblDatos", "cod", "00548");
		}		

		String sTipoPartCapital = conectorParametro("tipoPartCapital");
		String sTipoPartProvincia = conectorParametro("tipoPartProvincia");
		String sTipoPartFrontera = conectorParametro("tipoPartFrontera");
		
		String sTramosComisionesCapital = conectorParametro("tramosComisionesCapital");
		String sTramosComisionesProvincia = conectorParametro("tramosComisionesProvincia");
		String sTramosComisionesFrontera = conectorParametro("tramosComisionesFrontera");
		
		String sOpcion = conectorParametro("opcionMenu");

		String sDiasTrasFacturacionCapital = conectorParametroLimpia("hDiasTrasFacturacionCapital", "", true);
		String sDiasTrasFacturacionProvincia = conectorParametroLimpia("hDiasTrasFacturacionProvincia", "", true);
		String sDiasTrasFacturacionFrontera = conectorParametroLimpia("hDiasTrasFacturacionFrontera", "", true);

		traza("***** sTipoParticipante: " + sTipoParticipante);

		traza("***** sTipoPartCapital: " + sTipoPartCapital);
		traza("***** sTipoPartProvincia: " + sTipoPartProvincia);
		traza("***** sTipoPartFrontera: " + sTipoPartFrontera);

		traza("***** sTramosComisionesCapital: " + sTramosComisionesCapital);
		traza("***** sTramosComisionesProvincia: " + sTramosComisionesProvincia);
		traza("***** sTramosComisionesFrontera: " + sTramosComisionesFrontera);

		traza("sDiasTrasFacturacionCapital: " + sDiasTrasFacturacionCapital);
		traza("sDiasTrasFacturacionProvincia: " + sDiasTrasFacturacionProvincia);
		traza("sDiasTrasFacturacionFrontera: " + sDiasTrasFacturacionFrontera);

		traza("***** sOpcion: " + sOpcion);

		asignarAtributo("VAR", "titulo", "valor", titulo);		
		asignarAtributo("VAR", "hTipoParticipante", "valor", sTipoParticipante!=null?sTipoParticipante:"");		  

		asignarAtributo("VAR", "hTipoParticipanteCapital", "valor", sTipoPartCapital!=null?sTipoPartCapital:"");	  
		asignarAtributo("VAR", "hTipoParticipanteProvincia", "valor", sTipoPartProvincia!=null?sTipoPartProvincia:"");  
		asignarAtributo("VAR", "hTipoParticipanteFrontera", "valor", sTipoPartFrontera!=null?sTipoPartFrontera:"");		

		asignarAtributo("VAR", "hTramosComisionesCapital", "valor",   sTramosComisionesCapital!=null?sTramosComisionesCapital:"");
		
		asignarAtributo("VAR", "hTramosComisionesProvincia", "valor", 
		  sTramosComisionesProvincia!=null?sTramosComisionesProvincia:"");
	  
		asignarAtributo("VAR", "hTramosComisionesFrontera", "valor", 
		  sTramosComisionesFrontera!=null?sTramosComisionesFrontera:"");

		this.asignarAtributo("VAR", "hDiasTrasFacturacionCapital", "valor", sDiasTrasFacturacionCapital);
		this.asignarAtributo("VAR", "hDiasTrasFacturacionProvincia", "valor", sDiasTrasFacturacionProvincia);
		this.asignarAtributo("VAR", "hDiasTrasFacturacionFrontera", "valor", sDiasTrasFacturacionFrontera);
		  
		asignarAtributo("VAR", "hOpcionMenu", "valor", opcionMenu!=null?opcionMenu:"");
}

	private void cargarMenuSecundario() throws Exception {     
		traza("************ Entre a cargarMenuSecundario");
	  	traza("************ accion " + accion);
	  	traza("************ opcionMenu " + opcionMenu);
	  	traza("************ titulo " + titulo);

        if(accion != null && accion.equalsIgnoreCase("mostrarDetalleComisiones")){
			if(opcionMenu != null && opcionMenu.equalsIgnoreCase("insertar")) {
				getConfiguracionMenu("LPMantenimientoComisionesDatosCalculo", "mostrarDetalleComisiones");
			}
			else if(opcionMenu != null && opcionMenu.equalsIgnoreCase("modificar")) {
				getConfiguracionMenu("LPMantenimientoComisionesDatosCalculo", "mostrarDetalleComisiones");
				asignarAtributoPagina("cod","0520");      
			}
			else{
				getConfiguracionMenu("LPMantenimientoComisionesDatosCalculo", 
				"mostrarDetalleComisionesConsultar");
				if(titulo.equals("EliminarComisiones")) {
					asignarAtributoPagina("cod","0558");      
				}
				else {
					asignarAtributoPagina("cod","0510");      
				}
			}
		}
		else{
			if( opcionMenu != null && opcionMenu.equalsIgnoreCase("insertar") ){
				getConfiguracionMenu("LPMantenimientoComisionesDatosCalculo","insertar");
			}
			else if(opcionMenu != null && opcionMenu.equalsIgnoreCase("modificar")){
				getConfiguracionMenu("LPMantenimientoComisionesDatosCalculo","modificar");
				asignarAtributoPagina("cod","0520");
			}
			else if(opcionMenu != null && opcionMenu.equalsIgnoreCase("consultar")){
				getConfiguracionMenu("LPMantenimientoComisionesDatosCalculo","consultar");
				if(titulo.equals("EliminarComisiones")) {
					asignarAtributoPagina("cod","0558");         
				}
				else if(titulo.equals("ConsultarComisiones")) {
					asignarAtributoPagina("cod","0510");         
				}
			}
		}
	}
}