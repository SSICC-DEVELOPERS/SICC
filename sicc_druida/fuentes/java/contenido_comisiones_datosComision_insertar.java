
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_comisiones_datosComision_insertar  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         

      getXML180(doc);
         

      getXML270(doc);
         

      getXML360(doc);
         

      getXML450(doc);
         

      getXML540(doc);
         

      getXML630(doc);
         

      getXML720(doc);
         

      getXML810(doc);
         

      getXML900(doc);
         

      getXML990(doc);
         

      getXML1080(doc);
         

      getXML1170(doc);
         

      getXML1260(doc);
         

      getXML1350(doc);
         

      getXML1440(doc);
         

      getXML1530(doc);
         

      getXML1620(doc);
         

      getXML1710(doc);
         

      getXML1800(doc);
         

      getXML1890(doc);
         

      getXML1980(doc);
         

      getXML2070(doc);
         

      getXML2160(doc);
         

      getXML2250(doc);
         

      getXML2340(doc);
         

      getXML2430(doc);
         

      getXML2520(doc);
         

      getXML2610(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_comisiones_datosComision_insertar" );
      ((Element)v.get(0)).setAttribute("cod","0515" );
      ((Element)v.get(0)).setAttribute("titulo","Insertar comisiones" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(2)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","i18NJS.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Elemento padre:5 / Elemento actual: 6   */
      v.add(doc.createTextNode("\r \r\rfunction cargarCampos(){	\r			set( 'formulario.cbTipoComision', [get('formulario.hCBTipoComision')]);\r		set('formulario.atxtConcepto', get('formulario.hConcepto'));	\r\r\r\r			set('formulario.cbAplicarComision', [get('formulario.hAplicarComision')]);\r	onChangeAplicarComision();\r\r		set('formulario.ckCalcularIncobrables', get('formulario.varCalcularIncobrables'));\r\r	var algo = get('formulario.ckCalcularIncobrables');\r	if(algo==\"S\") {\r				if(get('formulario.hFechaEmision') == 'S'){\r			set('formulario.rbFecha', 'S');\r		}\r		else{\r			set('formulario.rbFecha', 'N');\r		}\r	}\r	else {\r		onChangeCalcularIncobrables();\r	}\r		set('formulario.txtDiasIncobrables', get('formulario.tempDiasIncobrables'));\r		set('formulario.cbFormula', [get('formulario.varFormula')]);\r		set('formulario.ckDevoluciones', get('formulario.varDevoluciones'));\r		set('formulario.ckAnulaciones', get('formulario.varAnulaciones'));\r		set('formulario.ckFaltantesNoAnunciados', get('formulario.varFaltantesNoAnunciados'));\r		set('formulario.txtPorcentaje', get('formulario.tempPorcentaje'));\r		set('formulario.txtImporteFijo', get('formulario.tempImporteFijo'));\r\r		set('formulario.cbComparativo', [get('formulario.varComparativo')]);\r	onChangeComparativo();\r													\r	\r	\r		set('formulario.cbPeriodoEntradaVigor3', [get('formulario.hPeriodoEntradaEnVigor')]);\r	set('formulario.cbPeriodoEntradaVigor5', [get('formulario.hPeriodoEntradaEnVigor')]);	\r		set('formulario.atxtObservaciones3', get('formulario.hObservaciones'));\r	set('formulario.atxtObservaciones52', get('formulario.hObservaciones'));\r\r\r\r		\r}\r\rfunction onLoadPag() {\r	configurarMenuSecundario(\"formulario\");        \r	cargarCampos();\r\r	var tipo = get('formulario.hCBTipoComision');\r	mostrarCapas(tipo);\r\r	if(get('formulario.hHabilitarEstadoSolicitudAutorizada') == 'S'){\r		deshabilitarCamposEstadoSolicitudAceptada();\r	}\r\r	if(get('formulario.opcionMenu') == 'consultar'){\r		deshabilitarTodo();\r		var tipoCobranza = get('formulario.TIPO_COMISION_COBRANZA');\r		if( tipo == tipoCobranza ) {\r			focoComboTipoParticipante();\r		}		\r	}\r\r	var tipoPlan = get(\"formulario.oidTipoPlantilla\");\r	if(tipoPlan!=\"\") {\r		var arraySeteo = new Array();\r		arraySeteo[0] = tipoPlan;\r		set(\"formulario.cbTipoComision\", arraySeteo);\r		document.getElementById(\"cbTipoComision\").disabled = true;\r	}\r\r	if(get('formulario.opcionMenu') == 'insertar'){\r		if(get('formulario.valDefecto') == 'S') {\r			valoresPorDefecto();\r		}\r		\r		focoComboTipoComision();\r	}\r\r	if(get('formulario.opcionMenu') == 'modificar') {\r						btnProxy(3, '1');\r		btnProxy(7, '1');\r		btnProxy(8, '1');\r		btnProxy(9, '1');\r	}\r\r    if (get('formulario.opcionMenu') != \"insertar\") {\r	btnProxy(2,'1');\r  } else {\r	btnProxy(2,'0');\r  }\r}\r\rfunction comboAplicarComision() {\r	var seteoAplicarComision = get(\"formulario.seteoAplicarComision\");\r	if(seteoAplicarComision==\"true\") {\r		var arraySeteo = new Array();\r		arraySeteo[0] = get(\"formulario.valVentaTotal\");\r		set(\"formulario.cbAplicarComision\", arraySeteo);\r		document.getElementById(\"cbAplicarComision\").disabled = true;\r	}\r\r	onChangeAplicarComision();\r}\r\rfunction valoresPorDefecto() {\r	set(\"formulario.ckCalcularIncobrables\", \"N\");	\r	set(\"formulario.ckDevoluciones\", \"S\");\r	set(\"formulario.ckAnulaciones\", \"S\");\r	set(\"formulario.ckFaltantesNoAnunciados\", \"N\");\r	set(\"formulario.txtPorcentaje\", \"\");\r	set(\"formulario.txtImporteFijo\", \"\");\r}\r\rfunction mostrarCapas(tipo){\r	var tipoVentas = get('formulario.TIPO_COMISION_VENTAS');\r	var tipoCobranza = get('formulario.TIPO_COMISION_COBRANZA');\r\r	if( tipo == tipoVentas ){ 		document.all[\"capa2\"].style.visibility= \"visible\";\r		if(get('formulario.opcionMenu') == 'insertar'){\r			document.all[\"capa3\"].style.visibility= \"hidden\";\r		}		\r		else {\r			document.all[\"capa3\"].style.visibility= \"visible\";			\r		}\r		document.all[\"capa4\"].style.visibility= \"hidden\";\r		document.all[\"capa5\"].style.visibility= \"hidden\";\r\r	}\r	else if( tipo == tipoCobranza ){ 		document.all[\"capa2\"].style.visibility= \"hidden\";\r		document.all[\"capa3\"].style.visibility= \"hidden\";\r		document.all[\"capa4\"].style.visibility= \"visible\";\r		if(get('formulario.opcionMenu') == 'insertar'){\r			document.all[\"capa5\"].style.visibility= \"hidden\";\r		}\r		else{\r			document.all[\"capa5\"].style.visibility= \"visible\";\r		}		\r	}\r}\r\rfunction fLimpiar(){\r	onLoadPag();\r}\r\rfunction deshabilitarBotonAceptar(){\r	deshabilitarHabilitarBoton('botonContenido', 'btnAceptar', 'D');\r}\r\rfunction deshabilitarCamposEstadoSolicitudAceptada(){\r							\r	accion('formulario.txtPorcentajeIncremento','.disabled=false');\r	accion('formulario.txtMonto','.disabled=false');\r	accion('formulario.txtPorcentaje','.disabled=false');\r	accion('formulario.txtImporteFijo','.disabled=false');\r	accion('formulario.cbPeriodoEntradaVigor3','.disabled=false');\r	accion('formulario.atxtObservaciones3','.disabled=false');\r	accion('formulario.cbPeriodoEntradaVigor5','.disabled=false');\r	accion('formulario.atxtObservaciones52','.disabled=false');\r\r	\r	accion('formulario.cbTipoComision','.disabled=true');\r	accion('formulario.atxtConcepto','.disabled=true');\r	accion('formulario.cbAplicarComision','.disabled=true');\r	accion('formulario.ckCalcularIncobrables','.disabled=true');\r	accion('formulario.rbFecha','.disabled=true');\r	accion('formulario.txtDiasIncobrables','.disabled=true');\r	accion('formulario.txtDiasIncobrables','.disabled=true');\r	accion('formulario.cbFormula','.disabled=true');\r	accion('formulario.ckDevoluciones','.disabled=true');\r	accion('formulario.ckAnulaciones','.disabled=true');\r	accion('formulario.ckFaltantesNoAnunciados','.disabled=true');\r	accion('formulario.cbComparativo','.disabled=true');\r	accion('formulario.ckDevolucionesMetas','.disabled=true');\r	accion('formulario.ckAnulacionesMetas','.disabled=true');\r\r		var ii = document.all.tags('INPUT');\r	for(i = 0; i < ii.length; i++){\r		if(ii.item(i).type == 'radio'){\r			ii[i].disabled = true;\r		}\r	}\r}\r\rfunction deshabilitarTodo(){\r	accion('formulario.cbTipoComision','.disabled=true');\r	accion('formulario.atxtConcepto','.disabled=true');\r	accion('formulario.cbAplicarComision','.disabled=true');\r	accion('formulario.ckCalcularIncobrables','.disabled=true');\r	accion('formulario.rbFecha','.disabled=true');\r	accion('formulario.txtDiasIncobrables','.disabled=true');\r	accion('formulario.txtDiasIncobrables','.disabled=true');\r	accion('formulario.cbFormula','.disabled=true');\r	accion('formulario.ckDevoluciones','.disabled=true');\r	accion('formulario.ckAnulaciones','.disabled=true');\r	accion('formulario.ckFaltantesNoAnunciados','.disabled=true');\r	accion('formulario.txtPorcentaje','.disabled=true');\r	accion('formulario.txtImporteFijo','.disabled=true');\r	accion('formulario.cbComparativo','.disabled=true');\r	accion('formulario.txtPorcentajeIncremento','.disabled=true');\r	accion('formulario.txtMonto','.disabled=true');\r	accion('formulario.ckDevolucionesMetas','.disabled=true');\r	accion('formulario.ckAnulacionesMetas','.disabled=true');\r	accion('formulario.cbPeriodoEntradaVigor3','.disabled=true');\r	accion('formulario.cbPeriodoEntradaVigor5','.disabled=true');\r	accion('formulario.atxtObservaciones3','.disabled=true');\r	accion('formulario.atxtObservaciones52','.disabled=true');\r	deshabilitarHabilitarBoton('botonContenido', 'btnCalcularMetas', 'D');\r	deshabilitarHabilitarBoton('botonContenido', 'btnAceptar', 'D');\r\r		var ii = document.all.tags('INPUT');\r	for(i = 0; i < ii.length; i++){\r		if(ii.item(i).type == 'radio'){\r			ii[i].disabled = true;\r		}\r	}\r}\r\rfunction focoComboTipoComision() {\r	if(document.all[\"cbTipoComision\"].disabled!=true) {\r		focaliza(\"formulario.cbTipoComision\");\r	}\r	else {\r		focaliza(\"formulario.atxtConcepto\");\r	}\r}\r\rfunction reInicio() {\r	focoComboTipoComision();\r}\r\rfunction fErrorAlGuardar(){\r	focoComboTipoComision();\r}\r\rfunction fGuardar(){\r	\r	\r		if(!sicc_validaciones_generales('grupoCriterios')){\r		return false;\r	}\r\r	var capa2 = document.all[\"capa2\"].style.visibility;\r	var capa3 = document.all[\"capa3\"].style.visibility;\r	var capa4 = document.all[\"capa4\"].style.visibility;\r	var capa5 = document.all[\"capa5\"].style.visibility;\r\r		if(capa2!='hidden') {\r\r						if(!sicc_validaciones_generales('grupoVentas'))\r			return false;\r\r						if(document.getElementById(\"txtDiasIncobrables\").disabled != true) {\r			if(!sicc_validaciones_generales('grupoVentasCalcular'))\r				return false;\r		}		\r\r				if(!sicc_validaciones_generales('grupoCalcularMetas')){\r			return false;\r		}\r	\r						if(document.getElementById(\"cbComparativo\").disabled!=true) {\r			if(!sicc_validaciones_generales('grupoVentasComparativo')){\r				return false;\r			}		\r		}		\r\r		var comision = get(\"formulario.txtPorcentaje\");\r		var importe = get(\"formulario.txtImporteFijo\");\r\r								if((comision!=\"\") && (importe!=\"\")) {		\r			GestionarMensaje('1542',null,null,null)\r			focoPorcentajeComision();\r			return false;\r		}\r\r								if((comision==\"\") && (importe==\"\")) {		\r			GestionarMensaje('1541',null,null,null)\r			focoPorcentajeComision();\r			return false;\r		}\r\r								var porIncremento = get(\"formulario.txtPorcentajeIncremento\");\r		var monIncremento = get(\"formulario.txtMonto\");\r		if((porIncremento!=\"\") && (monIncremento!=\"\")) {\r			GestionarMensaje('1576',null,null,null)\r			focaliza(\"formulario.txtPorcentajeIncremento\");\r			return false;\r		}		\r		\r						if(!sicc_validaciones_generales('grupoVentaHistorica')){\r			return false;\r		}		\r	}\r\r		if(capa4!='hidden') {\r\r						if(!sicc_validaciones_generales('grupoCobranza'))\r		return false;\r	}\r	\r		asignarCamposAHiddens();\r\r	var datosClientes = get(\"formulario.datosPestanyaClientes\");\r\r	var capa2 = document.all[\"capa2\"].style.visibility;\r	var capa3 = document.all[\"capa3\"].style.visibility;\r	var capa4 = document.all[\"capa4\"].style.visibility;\r	var capa5 = document.all[\"capa5\"].style.visibility;\r\r	if((capa2=='hidden') && (capa3=='hidden') && (capa4=='hidden') && (capa5=='hidden')) {\r		return false;\r	}\r\r		if(capa2!='hidden') {\r								if(datosClientes==\"false\") {\r			var resp = GestionarMensaje('1543',null,null,null);\r		\r						if(resp==true) {\r				set(\"formulario.conectorAction\", \"LPMantenimientoComisionesDatosCalculo\");\r				set(\"formulario.accion\", \"guardar\");\r				eval('formulario').oculto = 'S';\r				enviaSICC('formulario', '', '', 'N');\r			}\r						else {\r				return false;\r			}\r		}\r						else {\r			set(\"formulario.conectorAction\", \"LPMantenimientoComisionesDatosCalculo\");\r			set(\"formulario.accion\", \"guardar\");\r			eval('formulario').oculto = 'S';\r			enviaSICC('formulario', '', '', 'N');\r		}	\r	}\r\r		if(capa4!='hidden') {\r								if(datosClientes==\"false\") {\r			var resp = GestionarMensaje('1543',null,null,null);\r\r						if(resp==true) {\r				set(\"formulario.conectorAction\", \"LPMantenimientoComisionesDatosCalculo\");\r				set(\"formulario.accion\", \"guardar\");\r				eval('formulario').oculto = 'S';\r				enviaSICC('formulario', '', '', 'N');\r			}\r						else {\r				return false;\r			}\r		}\r						else {\r						\r			var part = get('formulario.cbTipoParticipante', 'V');\r\r			if(part == get('formulario.TIPO_PARTICIPANTE_CAPITAL')){\r				if ((get('formulario.hTramosComisionesCapital')=='')||(get('formulario.hDiasTrasFacturacionCapital')=='')){\r					GestionarMensaje('UICOM0010',null,null,null);\r					return false;\r				}\r			}\r			else if(part == get('formulario.TIPO_PARTICIPANTE_PROVINCIA')){\r				if ((get('formulario.hTramosComisionesProvincia')=='')||(get('formulario.hDiasTrasFacturacionProvincia')=='')){\r					GestionarMensaje('UICOM0010',null,null,null);\r					return false;\r				}\r			}\r			else if(part == get('formulario.TIPO_PARTICIPANTE_FRONTERA')){\r				if ((get('formulario.hTramosComisionesFrontera')=='')||(get('formulario.hDiasTrasFacturacionFrontera')=='')){\r					GestionarMensaje('UICOM0010',null,null,null);\r					return false;\r				}\r			}\r\r			set(\"formulario.conectorAction\", \"LPMantenimientoComisionesDatosCalculo\");\r			set(\"formulario.accion\", \"guardar\");\r			eval('formulario').oculto = 'S';\r			enviaSICC('formulario', '', '', 'N');\r		}	\r	}\r}\r\rfunction asignarCamposAHiddens(){\r	setMV('formulario.cbTipoParticipante', 'N');\r\r			set('formulario.hTipoComision', get('formulario.cbTipoComision', 'V'));\r\r		set('formulario.hConcepto', get('formulario.atxtConcepto'));\r\r			set('formulario.hAplicarComision', get('formulario.cbAplicarComision'));\r\r		set('formulario.varCalcularIncobrables', get('formulario.ckCalcularIncobrables'));\r\r		var incTemp = get('formulario.ckCalcularIncobrables');\r	if(incTemp==\"N\") {\r		set('formulario.hFechaEmision', 'N');\r		set('formulario.hFechaVencimiento', 'N');\r	}\r	else {\r		if(get('formulario.rbFecha')=='S'){\r			set('formulario.hFechaEmision', 'S');\r			set('formulario.hFechaVencimiento', 'N');\r		}\r		else{\r			set('formulario.hFechaEmision', 'N');\r			set('formulario.hFechaVencimiento', 'S');\r		}	\r	}\r\r		set('formulario.hDiasIncobrables', get('formulario.txtDiasIncobrables'));\r\r		set('formulario.varFormula', get('formulario.cbFormula', 'V'));\r\r		set('formulario.varDevoluciones', get('formulario.ckDevoluciones'));\r\r		set('formulario.varAnulaciones', get('formulario.ckAnulaciones'));\r\r		set('formulario.varFaltantesNoAnunciados', get('formulario.ckFaltantesNoAnunciados'));\r\r		set('formulario.htxtPorcentaje', get('formulario.txtPorcentaje'));\r\r		set('formulario.htxtImporteFijo', get('formulario.txtImporteFijo'));\r\r		set('formulario.varComparativo', get('formulario.cbComparativo', 'V'));\r\r	if(document.getElementById(\"txtPorcentajeIncremento\").disabled == true) {\r				set('formulario.oidPeriodoInicialEval', \"\");\r\r				set('formulario.oidPeriodoFinalEval', \"\");\r	}	\r\r		set('formulario.htxtPorcentajeIncremento', get('formulario.txtPorcentajeIncremento'));\r\r		set('formulario.htxtMonto', get('formulario.txtMonto'));\r\r		set('formulario.varDevolucionesEnMetas', get('formulario.ckDevolucionesMetas'));\r\r		set('formulario.varAnulacionesEnMetas', get('formulario.ckAnulacionesMetas'));\r\r		set('formulario.hTipoParticipante', get('formulario.cbTipoParticipante'));\r\r	\r	if(get('formulario.hTipoComision') == get('formulario.TIPO_COMISION_VENTAS')){\r		set('formulario.hPeriodoEntradaEnVigor', get('formulario.cbPeriodoEntradaVigor3'));\r		set('formulario.hObservaciones', get('formulario.atxtObservaciones3'));\r	}\r	else if(get('formulario.hTipoComision') == get('formulario.TIPO_COMISION_COBRANZA')){\r		set('formulario.hPeriodoEntradaEnVigor', get('formulario.cbPeriodoEntradaVigor5'));\r		set('formulario.hObservaciones', get('formulario.atxtObservaciones52'));\r	}\r}\r\rfunction onChangeAplicarComision() {\r	/* Si el combo TipoComisionVenta el OID == 1 \"Venta Total\" entonces desactivar los siguientes campos:\r		   * Comparativo	NO ACTIVADO\r		   * Per�odo inicial evaluaci�n	NO ACTIVADO\r		   * Per�odo final evaluaci�n	NO ACTIVADO\r		   * Porcentaje incremento	NO ACTIVADO\r		   * Monto incremento	NO ACTIVADO\r		   * Devoluciones en metas	NO ACTIVADO\r		   * Anulaciones en metas	NO ACTIVADO\r		\r		Sino Si el combo el OID de TipoComisionVenta == 2 \"Incremento\" entonces desactivar los siguientes campos:\r		   * Comparativo	        ACTIVADO\r		   * Per�odo inicial evaluaci�n	NO ACTIVADO\r		   * Per�odo final evaluaci�n	NO ACTIVADO\r		   * Porcentaje incremento	NO ACTIVADO\r		   * Monto incremento	NO ACTIVADO\r		   * Devoluciones en metas	NO ACTIVADO\r		   * Anulaciones en metas	NO ACTIVADO\r\r		Fin si*/\r	\r	var oidAplicarComision = get(\"formulario.cbAplicarComision\");\r\r	if(oidAplicarComision==\"1\") {\r	    set(\"formulario.cbComparativo\", \"\");\r		document.getElementById(\"cbComparativo\").disabled = true;\r		txt_to('lblPeriodoInicialEvaluaciondt', \"\");\r		txt_to('lblPeriodoFinalEvaluaciondt', \"\");\r		document.getElementById(\"txtPorcentajeIncremento\").disabled = true;\r		document.getElementById(\"txtMonto\").disabled = true;\r		document.getElementById(\"ckDevolucionesMetas\").disabled = true;\r		document.getElementById(\"ckAnulacionesMetas\").disabled = true;\r		document.getElementById(\"txtImporteFijo\").disabled = true;\r\r		set(\"formulario.ckDevolucionesMetas\", \"\");\r		set(\"formulario.ckAnulacionesMetas\", \"\");\r		set(\"formulario.txtPorcentajeIncremento\", \"\");\r		set(\"formulario.txtImporteFijo\", \"\");\r		set(\"formulario.txtMonto\", \"\");\r	}\r	else if(oidAplicarComision==\"2\") {\r		document.getElementById(\"cbComparativo\").disabled = false;\r		txt_to('lblPeriodoInicialEvaluaciondt', \"\");\r		txt_to('lblPeriodoFinalEvaluaciondt', \"\");\r		document.getElementById(\"txtPorcentajeIncremento\").disabled = true;\r		document.getElementById(\"txtMonto\").disabled = true;\r		document.getElementById(\"ckDevolucionesMetas\").disabled = true;\r		document.getElementById(\"ckAnulacionesMetas\").disabled = true;\r		set(\"formulario.txtImporteFijo\", \"\");\r		document.getElementById(\"txtImporteFijo\").disabled = false;\r	}\r	else {\r		document.getElementById(\"txtImporteFijo\").disabled = false;\r	}\r}\r\rfunction onChangeCalcularIncobrables() {\r	/*\r	Si Checked=\"S\" entonces habilitar\r    Radiobutton Fecha  con el valor por defecto=\"Emision\"\r    D�as para Incobrables con valor por defecto en blanco\r	\r	Si Checked=\"N\" entonces deshabilitar\r    Radiobutton Fecha  dejar sin valor\r    D�as para Incobrables con valor por defecto en blanco\r	*/\r\r	var calcular = get(\"formulario.ckCalcularIncobrables\");\r	if(calcular==\"S\") {\r		document.all.rbFecha[0].disabled= false;\r	    document.all.rbFecha[1].disabled= false;\r		set(\"formulario.rbFecha\", \"S\");\r\r		document.getElementById(\"txtDiasIncobrables\").disabled = false;\r		set(\"formulario.txtDiasIncobrables\", \"\");\r	}\r	else {\r		document.all.rbFecha[0].disabled= true;\r	    document.all.rbFecha[1].disabled= true;\r		set(\"formulario.rbFecha\", \"\");\r\r		document.getElementById(\"txtDiasIncobrables\").disabled = true;\r		set(\"formulario.txtDiasIncobrables\", \"\");\r	}\r}\r\rfunction onChangeComparativo() {\r/* (1)Si el OID de la opci�n seleccionada = \"Venta Historica\" entonces \r			(2)Si las variables ocultas  oidPeriodoInicialAnterior  y oidPeriodoFinallAnterior <> null Entonces \r				Habilitar\r				* Per�odo inicial evaluaci�n	Mostrar los valores\r 				* Per�odo final evaluaci�n	Mostrar los valores\r				* Porcentaje incremento	ACTIVAR Opcional\r				* Monto incremento	ACTIVAR Opcional			\r				(Estos dos campos son excluyentes, por lo que se debe validar que no se ingresen valores en estos dos campos a la vez)\r	 	        * Devoluciones en metas	ACTIVAR por defecto debe ser =\"S\"\r				* Anulaciones en metas	ACTIVAR por defecto debe ser =\"S\"\r\r			(2) Sino Mostrar el mensaje de error UICOM0005 - \"La comisi�n no puede ser incremental de tipo venta 			hist�rica, porque no existe el periodo del a�o anterior\"\r\r	   (1)Sino si el OID de la opci�n seleccion <> \"Venta Historica\" entonces deshabilitar y dejar en blanco \r           * Per�odo inicial evaluaci�n	\r		   * Per�odo final evaluaci�n	\r		   * Porcentaje incremento	\r		   * Monto incremento	\r		   * Devoluciones en metas	\r		   * Anulaciones en metas	\r   (1)Fin si */\r\r	var arraySeteo = new Array();\r	arraySeteo[0] = \"\"\r\r	var comparativo = get(\"formulario.cbComparativo\");\r\r	if(comparativo==\"1\") {\r		var temp1 = get(\"formulario.oidPeriodoInicialEval\");\r		var temp2 = get(\"formulario.desPeriodoInicial\");\r		var temp3 = get(\"formulario.oidPeriodoFinalEval\");\r		var temp4 = get(\"formulario.desPeriodoFinal\");\r\r		if(temp1!=\"\" && temp3!=\"\") {\r			txt_to('lblPeriodoInicialEvaluaciondt', get(\"formulario.desPeriodoInicial\"));\r			txt_to('lblPeriodoFinalEvaluaciondt', get(\"formulario.desPeriodoFinal\"));\r\r			document.getElementById(\"txtPorcentajeIncremento\").disabled = false;\r			document.getElementById(\"txtMonto\").disabled = false;\r			document.getElementById(\"ckDevolucionesMetas\").disabled = false;\r			document.getElementById(\"ckAnulacionesMetas\").disabled = false;\r\r			set(\"formulario.ckDevolucionesMetas\", get(\"formulario.varDevolucionesEnMetas\"));\r			set(\"formulario.ckAnulacionesMetas\", get(\"formulario.varAnulacionesEnMetas\"));\r			set(\"formulario.txtPorcentajeIncremento\", get(\"formulario.tempPorcentajeIncremento\"));\r			set(\"formulario.txtMonto\", get(\"formulario.tempMonto\"));\r		}\r		else {\r			GestionarMensaje('UICOM0005',null,null,null);\r			set(\"formulario.cbComparativo\", arraySeteo);\r			\r			txt_to('lblPeriodoInicialEvaluaciondt', \"\");\r			txt_to('lblPeriodoFinalEvaluaciondt', \"\");\r	\r			document.getElementById(\"txtPorcentajeIncremento\").disabled = true;\r			document.getElementById(\"txtMonto\").disabled = true;\r			document.getElementById(\"ckDevolucionesMetas\").disabled = true;\r			document.getElementById(\"ckAnulacionesMetas\").disabled = true;\r\r			set(\"formulario.ckDevolucionesMetas\", \"\");\r			set(\"formulario.ckAnulacionesMetas\", \"\");\r			set(\"formulario.txtPorcentajeIncremento\", \"\");\r			set(\"formulario.txtMonto\", \"\");\r		}		\r	}\r	else {\r		txt_to('lblPeriodoInicialEvaluaciondt', \"\");\r		txt_to('lblPeriodoFinalEvaluaciondt', \"\");\r\r		document.getElementById(\"txtPorcentajeIncremento\").disabled = true;\r		document.getElementById(\"txtMonto\").disabled = true;\r		document.getElementById(\"ckDevolucionesMetas\").disabled = true;\r		document.getElementById(\"ckAnulacionesMetas\").disabled = true;\r\r		set(\"formulario.ckDevolucionesMetas\", \"\");\r		set(\"formulario.ckAnulacionesMetas\", \"\");\r		set(\"formulario.txtPorcentajeIncremento\", \"\");\r		set(\"formulario.txtMonto\", \"\");\r	}\r}\r\rfunction focoPorcentajeComision() {\r	focaliza(\"formulario.txtPorcentaje\");\r}\r\rfunction btnAceptarOnClick() {\r	if(!sicc_validaciones_generales('grupoCriterios')){\r		return;\r	}\r\r	var tipo = get('formulario.cbTipoComision', 'V');\r	mostrarCapas(tipo);\r}\r\rfunction btnAceptarTipoParticipanteOnClick() {\r	/* -> Levantar ventana modal \"contenido_comisiones_datosComision_Insertar_detalle\" \r	-> Recuperar arreglo de arreglos \r	(1) Si en \"cmbTipoParticipante\" se selecciona \"Capital\" entonces \r	-> guardar arreglo de arreglos en \"tramosComisionesCapital\" \r	(1) Si no Si en \"cmbTipoParticipante\" se selecciona \"Provincia\" entonces \r	-> guardar arreglo de arreglos en \"tramosComisionesProvincia\" \r	(1) Si no Si en \"cmbTipoParticipante\" se selecciona \"Frontera\" entonces \r	-> guardar arreglo de arreglos en \"tramosComisionesFrontera\" \r	(1) Fin Si */\r\r	if(sicc_validaciones_generales('grupoCobranza')){\r		var parametros = new Object();\r\r		var tipoParticipante = get('formulario.cbTipoParticipante', 'V');\r		var tipoPartCapital = get('formulario.TIPO_PARTICIPANTE_CAPITAL');\r		var tipoPartProvincia = get('formulario.TIPO_PARTICIPANTE_PROVINCIA');\r		var tipoPartFrontera = get('formulario.TIPO_PARTICIPANTE_FRONTERA');\r		var tramosComisionesCapital = get('formulario.hTramosComisionesCapital');\r		var tramosComisionesProvincia = get('formulario.hTramosComisionesProvincia');\r		var tramosComisionesFrontera = get('formulario.hTramosComisionesFrontera');\r		var hDiasTrasFacturacionCapital = get('formulario.hDiasTrasFacturacionCapital');\r		var hDiasTrasFacturacionProvincia = get('formulario.hDiasTrasFacturacionProvincia');\r		var hDiasTrasFacturacionFrontera = get('formulario.hDiasTrasFacturacionFrontera');\r		var opcionMenu = get('formulario.opcionMenu');\r		var titulo = get('formulario.titulo');		\r\r		parametros.tipoParticipante = tipoParticipante;\r		parametros.tipoPartCapital = tipoPartCapital;\r		parametros.tipoPartProvincia = tipoPartProvincia;\r		parametros.tipoPartFrontera = tipoPartFrontera;\r		parametros.tramosComisionesCapital = tramosComisionesCapital;\r		parametros.tramosComisionesProvincia = tramosComisionesProvincia;\r		parametros.tramosComisionesFrontera = tramosComisionesFrontera;\r		parametros.hDiasTrasFacturacionCapital = hDiasTrasFacturacionCapital;\r		parametros.hDiasTrasFacturacionProvincia = hDiasTrasFacturacionProvincia;\r		parametros.hDiasTrasFacturacionFrontera = hDiasTrasFacturacionFrontera;\r		parametros.opcionMenu = opcionMenu;\r		parametros.titulo = titulo;		\r\r		var datos = mostrarModalSICC(\"LPMantenimientoComisionesDatosCalculo\", \"mostrarDetalleComisiones\", parametros,800,600);\r\r		if(datos != null){\r			var part = get('formulario.cbTipoParticipante', 'V');\r			var datosTemp = datos.valor.split(\"?\");\r			var datosLista = datosTemp[0];\r			var diasFacturacion = datosTemp[1];\r\r			if(part == get('formulario.TIPO_PARTICIPANTE_CAPITAL')){\r				set('formulario.hTramosComisionesCapital', datosLista);\r				set('formulario.hDiasTrasFacturacionCapital', diasFacturacion);\r			}\r			else if(part == get('formulario.TIPO_PARTICIPANTE_PROVINCIA')){\r				set('formulario.hTramosComisionesProvincia', datosLista);\r				set('formulario.hDiasTrasFacturacionProvincia', diasFacturacion);\r			}\r			else if(part == get('formulario.TIPO_PARTICIPANTE_FRONTERA')){\r				set('formulario.hTramosComisionesFrontera', datosLista);\r				set('formulario.hDiasTrasFacturacionFrontera', diasFacturacion);\r			}\r		}\r	}\r}\r\rfunction poneManito(nombre) {           \r	var nombre = document.getElementById(nombre);\r	nombre.style.cursor = \"hand\";\r}   \r\rfunction onClickPestanya(valor) {\r	\r		if(!sicc_validaciones_generales('grupoCriterios')){\r		return false;\r	}\r\r	var capa2 = document.all[\"capa2\"].style.visibility;\r	var capa3 = document.all[\"capa3\"].style.visibility;\r	var capa4 = document.all[\"capa4\"].style.visibility;\r	var capa5 = document.all[\"capa5\"].style.visibility;\r\r		if(capa2!='hidden') {\r\r						if(!sicc_validaciones_generales('grupoVentas'))\r			return false;\r\r						if(document.getElementById(\"txtDiasIncobrables\").disabled != true) {\r			if(!sicc_validaciones_generales('grupoVentasCalcular'))\r				return false;\r		}		\r\r				if(!sicc_validaciones_generales('grupoCalcularMetas')){\r			return false;\r		}\r	\r						if(document.getElementById(\"cbComparativo\").disabled!=true) {\r			if(!sicc_validaciones_generales('grupoVentasComparativo')){\r				return false;\r			}		\r		}		\r\r		var comision = get(\"formulario.txtPorcentaje\");\r		var importe = get(\"formulario.txtImporteFijo\");\r\r								if((comision!=\"\") && (importe!=\"\")) {		\r			GestionarMensaje('1542',null,null,null)\r			focoPorcentajeComision();\r			return false;\r		}\r\r								if((comision==\"\") && (importe==\"\")) {		\r			GestionarMensaje('1541',null,null,null)\r			focoPorcentajeComision();\r			return false;\r		}\r\r								var porIncremento = get(\"formulario.txtPorcentajeIncremento\");\r		var monIncremento = get(\"formulario.txtMonto\");\r		if((porIncremento!=\"\") && (monIncremento!=\"\")) {\r			GestionarMensaje('1576',null,null,null)\r			focaliza(\"formulario.txtPorcentajeIncremento\");\r			return false;\r		}		\r		\r						if(!sicc_validaciones_generales('grupoVentaHistorica')){\r			return false;\r		}		\r	}\r\r		if(capa4!='hidden') {\r\r						if(!sicc_validaciones_generales('grupoCobranza'))\r		return false;\r	}\r	\r\r	var estadoVentana = get(\"formulario.estadoVentana\");\r	var titulo = get(\"formulario.titulo\");\r	var opcionMenu = get(\"formulario.opcionMenu\");\r	var tipo = get('formulario.cbTipoComision', 'V');\r	set('formulario.hTipoComision', tipo)\r\r	if(valor==\"DatosGenerales\") {\r		set(\"formulario.idPestanyaDest\", \"1\");\r	}\r	else if(valor==\"Productos\") {\r		set(\"formulario.idPestanyaDest\", \"2\");\r	}\r	else if(valor == 'Clientes'){\r		set(\"formulario.idPestanyaDest\", \"3\");\r	}\r	else if(valor==\"DatosCalculo\") {\r		set(\"formulario.idPestanyaDest\", \"4\");\r	}\r\r	asignarCamposAHiddens();\r\r	set(\"formulario.conectorAction\", \"LPMantenimientoComisionesDatosCalculo\");\r	set(\"formulario.estadoVentana\", estadoVentana);\r	set(\"formulario.accion\", \"almacenar\");\r	set(\"formulario.oidTipoPlantilla\", get(\"formulario.oidTipoPlantilla\"));\r	set(\"formulario.titulo\", titulo);\r	set(\"formulario.opcionMenu\", opcionMenu);\r	enviaSICC('formulario', '', '', 'N');\r}\r\rfunction onTabBotonAceptarTipoParticipante() {\r	if(document.all[\"capa5\"].style.visibility== \"hidden\") {\r		focoComboTipoComision();\r	}\r	else {\r		focoComboPeriodoEntradaVigorCobranza();\r	}\r}\r\rfunction focoComboPeriodoEntradaVigorCobranza() {\r	focaliza(\"formulario.cbPeriodoEntradaVigor5\");\r}\r\rfunction focoComboTipoParticipante() {\r	focaliza(\"formulario.cbTipoParticipante\");\r}\r\rfunction onShTabComboTipoParticipante() {\r	if(document.getElementById(\"btnAceptar\").disabled==true) {\r		focoBotonAceptarTipoParticipante();\r	}\r	else {\r		focoBotonAceptarCriterios();\r	}	\r}\r\rfunction focoBotonAceptarTipoParticipante() {\r	focalizaBotonHTML('botonContenido','btnAceptar2');\r}\r\rfunction focoBotonAceptarCriterios() {\r	focalizaBotonHTML('botonContenido','btnAceptar');\r}\r\rfunction focoComboAplicarComision() {\r	if(document.getElementById(\"cbAplicarComision\").disabled == true) {\r		focoCalcularIncobrables();\r	}\r	else {\r		focaliza(\"formulario.cbAplicarComision\");\r	}	\r}\r\rfunction focoCalcularIncobrables() {\r	if(document.getElementById(\"ckCalcularIncobrables\").disabled == true) {\r		focaliza(\"formulario.cbFormula\");\r	}\r	else {\r		focaliza(\"formulario.ckCalcularIncobrables\");\r	}\r}\r\rfunction focoComboTipoComision() {\r	if(document.getElementById(\"cbTipoComision\").disabled != true) {\r		focaliza(\"formulario.cbTipoComision\");\r	}\r	else {\r		focaliza(\"formulario.atxtConcepto\");\r	}	\r}\r\rfunction onShTabTipoComision() {\r	var tipoVentas = get('formulario.TIPO_COMISION_VENTAS');\r	var tipoCobranza = get('formulario.TIPO_COMISION_COBRANZA');\r\r	if(get(\"formulario.cbTipoComision\")==tipoVentas) {\r		if(get('formulario.opcionMenu') == 'insertar'){\r			focalizaBotonHTML('btnCalcularMetas','btnAceptar');	\r		}\r		else {\r			focoObservacionesVentas();\r		}\r	}\r	else if(get(\"formulario.cbTipoComision\")==tipoCobranza) {\r		if(get('formulario.opcionMenu') == 'insertar'){\r			focoBotonAceptarTipoParticipante();\r		}\r		else {\r			focoObservacionesCobranzas();\r		}\r	}\r	else {\r		focoBotonAceptarCriterios();\r	}\r}\r\rfunction focoObservacionesVentas() {\r	focaliza(\"formulario.atxtObservaciones3\");\r}\r\rfunction focoObservacionesCobranzas() {\r	focaliza(\"formulario.atxtObservaciones52\");\r}\r\rfunction onTabCalcularMetas() {\r	if(get('formulario.opcionMenu') == 'insertar'){\r		focoComboTipoComision();\r	}\r	else {\r		focaliza(\"formulario.cbPeriodoEntradaVigor3\");\r	}\r}\r\rfunction fVolver() {\r						  				  			\r	window.close();\r}\r   \r \r"));
      ((Element)v.get(5)).appendChild((Text)v.get(6));

      /* Termina nodo Texto:6   */
      /* Termina nodo:5   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","cbTipoComision" );
      ((Element)v.get(8)).setAttribute("group","grupoCriterios" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","1794" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","cbAplicarComision" );
      ((Element)v.get(9)).setAttribute("group","grupoVentas" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","1733" );
      ((Element)v.get(7)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","cbFormula" );
      ((Element)v.get(10)).setAttribute("group","grupoVentas" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("cod","885" );
      ((Element)v.get(7)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","txtDiasIncobrables" );
      ((Element)v.get(11)).setAttribute("group","grupoVentasCalcular" );
      ((Element)v.get(11)).setAttribute("required","true" );
      ((Element)v.get(11)).setAttribute("cod","1737" );
      ((Element)v.get(11)).setAttribute("format","e" );
      ((Element)v.get(11)).setAttribute("min","0" );
      ((Element)v.get(11)).setAttribute("max","999" );
      ((Element)v.get(7)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","cbComparativo" );
      ((Element)v.get(12)).setAttribute("group","grupoVentasComparativo" );
      ((Element)v.get(12)).setAttribute("required","true" );
      ((Element)v.get(12)).setAttribute("cod","1699" );
      ((Element)v.get(7)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(13)).setAttribute("name","txtPorcentaje" );
      ((Element)v.get(13)).setAttribute("group","grupoCalcularMetas" );
      ((Element)v.get(13)).setAttribute("required","false" );
      ((Element)v.get(13)).setAttribute("cod","1545" );
      ((Element)v.get(13)).setAttribute("format","n" );
      ((Element)v.get(13)).setAttribute("min","0" );
      ((Element)v.get(13)).setAttribute("max","999.99" );
      ((Element)v.get(7)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(14)).setAttribute("name","txtImporteFijo" );
      ((Element)v.get(14)).setAttribute("group","grupoCalcularMetas" );
      ((Element)v.get(14)).setAttribute("required","false" );
      ((Element)v.get(14)).setAttribute("cod","1736" );
      ((Element)v.get(14)).setAttribute("format","n" );
      ((Element)v.get(14)).setAttribute("min","0" );
      ((Element)v.get(14)).setAttribute("max","9999999999.99" );
      ((Element)v.get(7)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(15)).setAttribute("name","txtPorcentajeIncremento" );
      ((Element)v.get(15)).setAttribute("group","grupoVentaHistorica" );
      ((Element)v.get(15)).setAttribute("required","false" );
      ((Element)v.get(15)).setAttribute("cod","1848" );
      ((Element)v.get(15)).setAttribute("format","n" );
      ((Element)v.get(15)).setAttribute("min","0" );
      ((Element)v.get(15)).setAttribute("max","999.99" );
      ((Element)v.get(7)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(16)).setAttribute("name","txtMonto" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(16)).setAttribute("group","grupoVentaHistorica" );
      ((Element)v.get(16)).setAttribute("required","false" );
      ((Element)v.get(16)).setAttribute("cod","1741" );
      ((Element)v.get(16)).setAttribute("format","n" );
      ((Element)v.get(16)).setAttribute("min","0" );
      ((Element)v.get(16)).setAttribute("max","9999999999.99" );
      ((Element)v.get(7)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(17)).setAttribute("name","cbTipoParticipante" );
      ((Element)v.get(17)).setAttribute("group","grupoCobranza" );
      ((Element)v.get(17)).setAttribute("required","true" );
      ((Element)v.get(17)).setAttribute("cod","1728" );
      ((Element)v.get(7)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */
      /* Termina nodo:7   */

      /* Empieza nodo:18 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(18)).setAttribute("nombre","formulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(18));

      /* Empieza nodo:19 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","oidTipoPlantilla" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","titulo" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","estadoVentana" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","accion" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","varPais" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","varIdioma" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hAplicarComision" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","varCalcularIncobrables" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","varFormula" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","varDevoluciones" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","varAnulaciones" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","varFaltantesNoAnunciados" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","varComparativo" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","varDevolucionesEnMetas" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","varAnulacionesEnMetas" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","hDiasTrasFacturacionCapital" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","hDiasTrasFacturacionProvincia" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","hDiasTrasFacturacionFrontera" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","hCBTipoComision" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","hFechaEmision" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","hFechaVencimiento" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","hPeriodoInicialEvaluacion" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","hPeriodoFinalEvaluacion" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","hDiasFacturacion" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","hHabilitarEstadoSolicitudAutorizada" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","hHabilitarCalcularMetas" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","hHabilitarBotonAceptar" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","hOpcionMenu" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","hDeshabilitarTodo" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(51)).setAttribute("nombre","hTramosComisionesCapital" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(52)).setAttribute("nombre","hTramosComisionesProvincia" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(53)).setAttribute("nombre","hTramosComisionesFrontera" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(54)).setAttribute("nombre","TIPO_PARTICIPANTE_CAPITAL" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(55)).setAttribute("nombre","TIPO_PARTICIPANTE_PROVINCIA" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(56)).setAttribute("nombre","TIPO_PARTICIPANTE_FRONTERA" );
      ((Element)v.get(56)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(57)).setAttribute("nombre","TIPO_COMISION_VENTAS" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(58)).setAttribute("nombre","TIPO_COMISION_COBRANZA" );
      ((Element)v.get(58)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */

      /* Empieza nodo:59 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(59)).setAttribute("nombre","hTPCapital" );
      ((Element)v.get(59)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */

      /* Empieza nodo:60 / Elemento padre: 18   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(60)).setAttribute("nombre","idPestanyaDest" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */

      /* Empieza nodo:61 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(61)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(61)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */

      /* Empieza nodo:62 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(62)).setAttribute("nombre","hPeriodoInicialEvaluaciondt" );
      ((Element)v.get(62)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */

      /* Empieza nodo:63 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(63)).setAttribute("nombre","hPeriodoFinalEvaluaciondt" );
      ((Element)v.get(63)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */

      /* Empieza nodo:64 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(64)).setAttribute("nombre","hTipoParticipante" );
      ((Element)v.get(64)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */

      /* Empieza nodo:65 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(65)).setAttribute("nombre","hPeriodoEntradaEnVigor" );
      ((Element)v.get(65)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */

      /* Empieza nodo:66 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(66)).setAttribute("nombre","hObservaciones" );
      ((Element)v.get(66)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */

      /* Empieza nodo:67 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(67)).setAttribute("nombre","datosPestanyaClientes" );
      ((Element)v.get(67)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */

      /* Empieza nodo:68 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(68)).setAttribute("nombre","datosPestanyaDatosCalculo" );
      ((Element)v.get(68)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */

      /* Empieza nodo:69 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(69)).setAttribute("nombre","desPeriodoInicial" );
      ((Element)v.get(69)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */

      /* Empieza nodo:70 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(70)).setAttribute("nombre","desPeriodoFinal" );
      ((Element)v.get(70)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */

      /* Empieza nodo:71 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(71)).setAttribute("nombre","oidPeriodoInicialEval" );
      ((Element)v.get(71)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */

      /* Empieza nodo:72 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(72)).setAttribute("nombre","oidPeriodoFinalEval" );
      ((Element)v.get(72)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */

      /* Empieza nodo:73 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(73)).setAttribute("nombre","seteoAplicarComision" );
      ((Element)v.get(73)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */

      /* Empieza nodo:74 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(74)).setAttribute("nombre","valVentaTotal" );
      ((Element)v.get(74)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */

      /* Empieza nodo:75 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(75)).setAttribute("nombre","valIncremento" );
      ((Element)v.get(75)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */

      /* Empieza nodo:76 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(76)).setAttribute("nombre","hTipoComision" );
      ((Element)v.get(76)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */

      /* Empieza nodo:77 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(77)).setAttribute("nombre","hConcepto" );
      ((Element)v.get(77)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */

      /* Empieza nodo:78 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(78)).setAttribute("nombre","hDiasIncobrables" );
      ((Element)v.get(78)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */

      /* Empieza nodo:79 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(79)).setAttribute("nombre","htxtPorcentaje" );
      ((Element)v.get(79)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */

      /* Empieza nodo:80 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(80)).setAttribute("nombre","htxtImporteFijo" );
      ((Element)v.get(80)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */

      /* Empieza nodo:81 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(81)).setAttribute("nombre","htxtPorcentajeIncremento" );
      ((Element)v.get(81)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */

      /* Empieza nodo:82 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(82)).setAttribute("nombre","htxtMonto" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(82)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */

      /* Empieza nodo:83 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(83)).setAttribute("nombre","tempDiasIncobrables" );
      ((Element)v.get(83)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */

      /* Empieza nodo:84 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(84)).setAttribute("nombre","tempPorcentaje" );
      ((Element)v.get(84)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */

      /* Empieza nodo:85 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(85)).setAttribute("nombre","tempImporteFijo" );
      ((Element)v.get(85)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */

      /* Empieza nodo:86 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(86)).setAttribute("nombre","tempPorcentajeIncremento" );
      ((Element)v.get(86)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */

      /* Empieza nodo:87 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(87)).setAttribute("nombre","tempMonto" );
      ((Element)v.get(87)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */

      /* Empieza nodo:88 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(88)).setAttribute("nombre","valDefecto" );
      ((Element)v.get(88)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */

      /* Empieza nodo:89 / Elemento padre: 18   */
      v.add(doc.createElement("table"));
      ((Element)v.get(89)).setAttribute("width","100%" );
      ((Element)v.get(89)).setAttribute("height","100%" );
      ((Element)v.get(89)).setAttribute("border","0" );
      ((Element)v.get(89)).setAttribute("align","center" );
      ((Element)v.get(89)).setAttribute("cellpadding","0" );
      ((Element)v.get(89)).setAttribute("cellspacing","0" );
      ((Element)v.get(89)).setAttribute("class","menu4" );
      ((Element)v.get(18)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(89)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).setAttribute("width","12" );
      ((Element)v.get(91)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(91)).setAttribute("class","menu5texto" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(92)).setAttribute("src","b.gif" );
      ((Element)v.get(92)).setAttribute("width","12" );
      ((Element)v.get(92)).setAttribute("height","30" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:93 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(93)).setAttribute("class","menu5texto" );
      ((Element)v.get(90)).appendChild((Element)v.get(93));

      /* Elemento padre:93 / Elemento actual: 94   */
      v.add(doc.createTextNode("�"));
      ((Element)v.get(93)).appendChild((Text)v.get(94));

      /* Termina nodo Texto:94   */
      /* Termina nodo:93   */

      /* Empieza nodo:95 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(95)).setAttribute("width","10" );
      ((Element)v.get(95)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(95)).setAttribute("class","menu5texto" );
      ((Element)v.get(90)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(96)).setAttribute("src","b.gif" );
      ((Element)v.get(96)).setAttribute("width","10" );
      ((Element)v.get(96)).setAttribute("height","8" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */

      /* Empieza nodo:97 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).setAttribute("width","92" );
      ((Element)v.get(97)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(97)).setAttribute("class","menu5texto" );
      ((Element)v.get(90)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("table"));
      ((Element)v.get(98)).setAttribute("width","75" );
      ((Element)v.get(98)).setAttribute("border","1" );
      ((Element)v.get(98)).setAttribute("align","center" );
      ((Element)v.get(98)).setAttribute("cellpadding","1" );
      ((Element)v.get(98)).setAttribute("cellspacing","0" );
      ((Element)v.get(98)).setAttribute("ID","DatosGenerales" );
      ((Element)v.get(98)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(98)).setAttribute("onclick","onClickPestanya('DatosGenerales');" );
      ((Element)v.get(98)).setAttribute("onmouseover","poneManito('DatosGenerales');" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(99)).setAttribute("align","center" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(101)).setAttribute("nombre","lblDGC" );
      ((Element)v.get(101)).setAttribute("alto","13" );
      ((Element)v.get(101)).setAttribute("filas","1" );
      ((Element)v.get(101)).setAttribute("valor","" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(101)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(101)).setAttribute("cod","00543" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */
      /* Termina nodo:99   */
      /* Termina nodo:98   */
      /* Termina nodo:97   */

      /* Empieza nodo:102 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).setAttribute("width","10" );
      ((Element)v.get(102)).setAttribute("class","menu5texto" );
      ((Element)v.get(90)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(103)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).setAttribute("width","10" );
      ((Element)v.get(103)).setAttribute("height","8" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:104 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).setAttribute("width","20" );
      ((Element)v.get(104)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(104)).setAttribute("class","menu5texto" );
      ((Element)v.get(90)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("table"));
      ((Element)v.get(105)).setAttribute("width","75" );
      ((Element)v.get(105)).setAttribute("border","1" );
      ((Element)v.get(105)).setAttribute("align","center" );
      ((Element)v.get(105)).setAttribute("cellpadding","1" );
      ((Element)v.get(105)).setAttribute("cellspacing","0" );
      ((Element)v.get(105)).setAttribute("ID","Productos" );
      ((Element)v.get(105)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(105)).setAttribute("onclick","onClickPestanya('Productos');" );
      ((Element)v.get(105)).setAttribute("onmouseover","poneManito('Productos');" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(106)).setAttribute("align","center" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(108)).setAttribute("nombre","lblProductos" );
      ((Element)v.get(108)).setAttribute("alto","13" );
      ((Element)v.get(108)).setAttribute("filas","1" );
      ((Element)v.get(108)).setAttribute("valor","" );
      ((Element)v.get(108)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(108)).setAttribute("cod","0094" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */
      /* Termina nodo:106   */
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:109 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).setAttribute("width","10" );
      ((Element)v.get(109)).setAttribute("class","menu5texto" );
      ((Element)v.get(90)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(110)).setAttribute("src","b.gif" );
      ((Element)v.get(110)).setAttribute("width","10" );
      ((Element)v.get(110)).setAttribute("height","8" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:111 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).setAttribute("width","20" );
      ((Element)v.get(111)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(111)).setAttribute("class","menu5texto" );
      ((Element)v.get(90)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("table"));
      ((Element)v.get(112)).setAttribute("width","75" );
      ((Element)v.get(112)).setAttribute("border","1" );
      ((Element)v.get(112)).setAttribute("align","center" );
      ((Element)v.get(112)).setAttribute("cellpadding","1" );
      ((Element)v.get(112)).setAttribute("cellspacing","0" );
      ((Element)v.get(112)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(112)).setAttribute("onclick","onClickPestanya('Clientes');" );
      ((Element)v.get(112)).setAttribute("onmouseover"," poneManito('Clientes');" );
      ((Element)v.get(112)).setAttribute("ID","Clientes" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(113)).setAttribute("align","center" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(115)).setAttribute("nombre","lblClientes" );
      ((Element)v.get(115)).setAttribute("alto","13" );
      ((Element)v.get(115)).setAttribute("filas","1" );
      ((Element)v.get(115)).setAttribute("valor","" );
      ((Element)v.get(115)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(115)).setAttribute("cod","0026" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */
      /* Termina nodo:113   */
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:116 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).setAttribute("width","10" );
      ((Element)v.get(116)).setAttribute("class","menu5texto" );
      ((Element)v.get(90)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(117)).setAttribute("src","b.gif" );
      ((Element)v.get(117)).setAttribute("width","10" );
      ((Element)v.get(117)).setAttribute("height","8" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:118 / Elemento padre: 90   */
   }

   private void getXML540(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(118)).setAttribute("width","20" );
      ((Element)v.get(118)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(118)).setAttribute("class","menu5texto" );
      ((Element)v.get(90)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("table"));
      ((Element)v.get(119)).setAttribute("width","75" );
      ((Element)v.get(119)).setAttribute("border","1" );
      ((Element)v.get(119)).setAttribute("align","center" );
      ((Element)v.get(119)).setAttribute("cellpadding","1" );
      ((Element)v.get(119)).setAttribute("cellspacing","0" );
      ((Element)v.get(119)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(119)).setAttribute("ID","DatosCalculo" );
      ((Element)v.get(119)).setAttribute("bgcolor","#496A9A" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(120)).setAttribute("align","center" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("td"));
      ((Element)v.get(121)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(122)).setAttribute("nombre","lblDatosC" );
      ((Element)v.get(122)).setAttribute("alto","13" );
      ((Element)v.get(122)).setAttribute("filas","1" );
      ((Element)v.get(122)).setAttribute("valor","" );
      ((Element)v.get(122)).setAttribute("id","menu5textoblanca" );
      ((Element)v.get(122)).setAttribute("cod","00544" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:123 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(123)).setAttribute("width","16" );
      ((Element)v.get(123)).setAttribute("class","menu5texto" );
      ((Element)v.get(90)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(124)).setAttribute("src","b.gif" );
      ((Element)v.get(124)).setAttribute("width","12" );
      ((Element)v.get(124)).setAttribute("height","8" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:125 / Elemento padre: 18   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(125)).setAttribute("nombre","capa1" );
      ((Element)v.get(18)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("table"));
      ((Element)v.get(126)).setAttribute("width","100%" );
      ((Element)v.get(126)).setAttribute("border","0" );
      ((Element)v.get(126)).setAttribute("cellspacing","0" );
      ((Element)v.get(126)).setAttribute("cellpadding","0" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).setAttribute("width","12" );
      ((Element)v.get(128)).setAttribute("align","center" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(129)).setAttribute("src","b.gif" );
      ((Element)v.get(129)).setAttribute("width","12" );
      ((Element)v.get(129)).setAttribute("height","12" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */

      /* Empieza nodo:130 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).setAttribute("width","750" );
      ((Element)v.get(127)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(131)).setAttribute("src","b.gif" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:132 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(132)).setAttribute("width","12" );
      ((Element)v.get(127)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(133)).setAttribute("src","b.gif" );
      ((Element)v.get(133)).setAttribute("width","12" );
      ((Element)v.get(133)).setAttribute("height","1" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */
      /* Termina nodo:127   */

      /* Empieza nodo:134 / Elemento padre: 126   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(126)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(136)).setAttribute("src","b.gif" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */

      /* Empieza nodo:137 / Elemento padre: 134   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(137)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(139)).setAttribute("class","legend" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(140)).setAttribute("nombre","lblCriteriosSeleccion" );
      ((Element)v.get(140)).setAttribute("alto","13" );
      ((Element)v.get(140)).setAttribute("filas","1" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(140)).setAttribute("valor","" );
      ((Element)v.get(140)).setAttribute("id","legend" );
      ((Element)v.get(140)).setAttribute("cod","00275" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:141 / Elemento padre: 138   */
      v.add(doc.createElement("table"));
      ((Element)v.get(141)).setAttribute("width","100%" );
      ((Element)v.get(141)).setAttribute("border","0" );
      ((Element)v.get(141)).setAttribute("align","center" );
      ((Element)v.get(141)).setAttribute("cellspacing","0" );
      ((Element)v.get(141)).setAttribute("cellpadding","0" );
      ((Element)v.get(138)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(141)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("table"));
      ((Element)v.get(144)).setAttribute("width","663" );
      ((Element)v.get(144)).setAttribute("border","0" );
      ((Element)v.get(144)).setAttribute("align","left" );
      ((Element)v.get(144)).setAttribute("cellspacing","0" );
      ((Element)v.get(144)).setAttribute("cellpadding","0" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(144)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).setAttribute("colspan","4" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(147)).setAttribute("src","b.gif" );
      ((Element)v.get(147)).setAttribute("width","8" );
      ((Element)v.get(147)).setAttribute("height","8" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:146   */
      /* Termina nodo:145   */

      /* Empieza nodo:148 / Elemento padre: 144   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(144)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("td"));
      ((Element)v.get(148)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(150)).setAttribute("src","b.gif" );
      ((Element)v.get(150)).setAttribute("width","8" );
      ((Element)v.get(150)).setAttribute("height","8" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:149   */

      /* Empieza nodo:151 / Elemento padre: 148   */
      v.add(doc.createElement("td"));
      ((Element)v.get(148)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(152)).setAttribute("nombre","lblTipoComision" );
      ((Element)v.get(152)).setAttribute("alto","13" );
      ((Element)v.get(152)).setAttribute("filas","1" );
      ((Element)v.get(152)).setAttribute("valor","" );
      ((Element)v.get(152)).setAttribute("id","datosTitle" );
      ((Element)v.get(152)).setAttribute("cod","1857" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:151   */

      /* Empieza nodo:153 / Elemento padre: 148   */
      v.add(doc.createElement("td"));
      ((Element)v.get(148)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(154)).setAttribute("src","b.gif" );
      ((Element)v.get(154)).setAttribute("width","25" );
      ((Element)v.get(154)).setAttribute("height","8" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */

      /* Empieza nodo:155 / Elemento padre: 148   */
      v.add(doc.createElement("td"));
      ((Element)v.get(148)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(156)).setAttribute("nombre","lblConcepto" );
      ((Element)v.get(156)).setAttribute("alto","13" );
      ((Element)v.get(156)).setAttribute("filas","1" );
      ((Element)v.get(156)).setAttribute("valor","" );
      ((Element)v.get(156)).setAttribute("id","datosTitle" );
      ((Element)v.get(156)).setAttribute("cod","1711" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */

      /* Empieza nodo:157 / Elemento padre: 148   */
      v.add(doc.createElement("td"));
      ((Element)v.get(157)).setAttribute("width","100%" );
      ((Element)v.get(148)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(158)).setAttribute("src","b.gif" );
      ((Element)v.get(158)).setAttribute("width","8" );
      ((Element)v.get(158)).setAttribute("height","8" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */
      /* Termina nodo:148   */

      /* Empieza nodo:159 / Elemento padre: 144   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(144)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("td"));
      ((Element)v.get(159)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(161)).setAttribute("src","b.gif" );
      ((Element)v.get(161)).setAttribute("width","8" );
      ((Element)v.get(161)).setAttribute("height","8" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:160   */

      /* Empieza nodo:162 / Elemento padre: 159   */
      v.add(doc.createElement("td"));
      ((Element)v.get(162)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(162)).setAttribute("valign","top" );
      ((Element)v.get(159)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("COMBO"));
   }

   private void getXML720(Document doc) {
      ((Element)v.get(163)).setAttribute("nombre","cbTipoComision" );
      ((Element)v.get(163)).setAttribute("id","datosCampos" );
      ((Element)v.get(163)).setAttribute("size","1" );
      ((Element)v.get(163)).setAttribute("multiple","N" );
      ((Element)v.get(163)).setAttribute("req","S" );
      ((Element)v.get(163)).setAttribute("valorinicial","" );
      ((Element)v.get(163)).setAttribute("textoinicial","" );
      ((Element)v.get(163)).setAttribute("onshtab","onShTabTipoComision();" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */
      /* Termina nodo:162   */

      /* Empieza nodo:165 / Elemento padre: 159   */
      v.add(doc.createElement("td"));
      ((Element)v.get(159)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(166)).setAttribute("src","b.gif" );
      ((Element)v.get(166)).setAttribute("width","25" );
      ((Element)v.get(166)).setAttribute("height","8" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:165   */

      /* Empieza nodo:167 / Elemento padre: 159   */
      v.add(doc.createElement("td"));
      ((Element)v.get(167)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(159)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("AREATEXTO"));
      ((Element)v.get(168)).setAttribute("cols","50" );
      ((Element)v.get(168)).setAttribute("id","datosCampos" );
      ((Element)v.get(168)).setAttribute("msjreq","" );
      ((Element)v.get(168)).setAttribute("nombre","atxtConcepto" );
      ((Element)v.get(168)).setAttribute("readonly","N" );
      ((Element)v.get(168)).setAttribute("req","N" );
      ((Element)v.get(168)).setAttribute("rows","3" );
      ((Element)v.get(168)).setAttribute("tabindex","2" );
      ((Element)v.get(168)).setAttribute("valor","" );
      ((Element)v.get(168)).setAttribute("max","125" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */

      /* Empieza nodo:169 / Elemento padre: 159   */
      v.add(doc.createElement("td"));
      ((Element)v.get(169)).setAttribute("width","100%" );
      ((Element)v.get(159)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(170)).setAttribute("src","b.gif" );
      ((Element)v.get(170)).setAttribute("width","8" );
      ((Element)v.get(170)).setAttribute("height","8" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */
      /* Termina nodo:159   */

      /* Empieza nodo:171 / Elemento padre: 144   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(144)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).setAttribute("colspan","4" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(173)).setAttribute("src","b.gif" );
      ((Element)v.get(173)).setAttribute("width","8" );
      ((Element)v.get(173)).setAttribute("height","8" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */
      /* Termina nodo:172   */
      /* Termina nodo:171   */
      /* Termina nodo:144   */
      /* Termina nodo:143   */
      /* Termina nodo:142   */
      /* Termina nodo:141   */
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:174 / Elemento padre: 134   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(175)).setAttribute("src","b.gif" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:174   */
      /* Termina nodo:134   */

      /* Empieza nodo:176 / Elemento padre: 126   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(126)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("td"));
      ((Element)v.get(176)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(178)).setAttribute("src","b.gif" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:177   */

      /* Empieza nodo:179 / Elemento padre: 176   */
      v.add(doc.createElement("td"));
      ((Element)v.get(176)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(179)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("table"));
      ((Element)v.get(181)).setAttribute("width","100%" );
      ((Element)v.get(181)).setAttribute("border","0" );
      ((Element)v.get(181)).setAttribute("align","center" );
      ((Element)v.get(181)).setAttribute("cellspacing","0" );
      ((Element)v.get(181)).setAttribute("cellpadding","0" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(181)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("td"));
      ((Element)v.get(183)).setAttribute("class","botonera" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(184)).setAttribute("nombre","btnAceptar" );
      ((Element)v.get(184)).setAttribute("ID","botonContenido" );
      ((Element)v.get(184)).setAttribute("tipo","html" );
      ((Element)v.get(184)).setAttribute("accion","btnAceptarOnClick();" );
      ((Element)v.get(184)).setAttribute("estado","false" );
      ((Element)v.get(184)).setAttribute("cod","12" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */
      /* Termina nodo:182   */
      /* Termina nodo:181   */
      /* Termina nodo:180   */
      /* Termina nodo:179   */

      /* Empieza nodo:185 / Elemento padre: 176   */
      v.add(doc.createElement("td"));
      ((Element)v.get(176)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML810(Document doc) {
      ((Element)v.get(186)).setAttribute("src","b.gif" );
      ((Element)v.get(186)).setAttribute("width","8" );
      ((Element)v.get(186)).setAttribute("height","12" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */
      /* Termina nodo:176   */

      /* Empieza nodo:187 / Elemento padre: 126   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(126)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("td"));
      ((Element)v.get(188)).setAttribute("width","12" );
      ((Element)v.get(188)).setAttribute("align","center" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(189)).setAttribute("src","b.gif" );
      ((Element)v.get(189)).setAttribute("width","12" );
      ((Element)v.get(189)).setAttribute("height","12" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */
      /* Termina nodo:188   */

      /* Empieza nodo:190 / Elemento padre: 187   */
      v.add(doc.createElement("td"));
      ((Element)v.get(190)).setAttribute("width","750" );
      ((Element)v.get(187)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(191)).setAttribute("src","b.gif" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */
      /* Termina nodo:190   */

      /* Empieza nodo:192 / Elemento padre: 187   */
      v.add(doc.createElement("td"));
      ((Element)v.get(192)).setAttribute("width","12" );
      ((Element)v.get(187)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(193)).setAttribute("src","b.gif" );
      ((Element)v.get(193)).setAttribute("width","12" );
      ((Element)v.get(193)).setAttribute("height","1" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:192   */
      /* Termina nodo:187   */
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:194 / Elemento padre: 18   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(194)).setAttribute("nombre","capa2" );
      ((Element)v.get(194)).setAttribute("alto","350" );
      ((Element)v.get(194)).setAttribute("ancho","100%" );
      ((Element)v.get(194)).setAttribute("colorf","" );
      ((Element)v.get(194)).setAttribute("borde","0" );
      ((Element)v.get(194)).setAttribute("imagenf","" );
      ((Element)v.get(194)).setAttribute("repeat","" );
      ((Element)v.get(194)).setAttribute("padding","" );
      ((Element)v.get(194)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(194)).setAttribute("contravsb","" );
      ((Element)v.get(194)).setAttribute("x","0" );
      ((Element)v.get(194)).setAttribute("y","157" );
      ((Element)v.get(194)).setAttribute("zindex","" );
      ((Element)v.get(18)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("table"));
      ((Element)v.get(195)).setAttribute("width","100%" );
      ((Element)v.get(195)).setAttribute("border","0" );
      ((Element)v.get(195)).setAttribute("cellspacing","0" );
      ((Element)v.get(195)).setAttribute("cellpadding","0" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(195)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("td"));
      ((Element)v.get(197)).setAttribute("width","12" );
      ((Element)v.get(197)).setAttribute("align","center" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(198)).setAttribute("src","b.gif" );
      ((Element)v.get(198)).setAttribute("width","12" );
      ((Element)v.get(198)).setAttribute("height","12" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:197   */

      /* Empieza nodo:199 / Elemento padre: 196   */
      v.add(doc.createElement("td"));
      ((Element)v.get(199)).setAttribute("width","750" );
      ((Element)v.get(196)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(200)).setAttribute("src","b.gif" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:199   */

      /* Empieza nodo:201 / Elemento padre: 196   */
      v.add(doc.createElement("td"));
      ((Element)v.get(201)).setAttribute("width","12" );
      ((Element)v.get(196)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(202)).setAttribute("src","b.gif" );
      ((Element)v.get(202)).setAttribute("width","12" );
      ((Element)v.get(202)).setAttribute("height","1" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:201   */
      /* Termina nodo:196   */

      /* Empieza nodo:203 / Elemento padre: 195   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(195)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("td"));
      ((Element)v.get(203)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(205)).setAttribute("src","b.gif" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */
      /* Termina nodo:204   */

      /* Empieza nodo:206 / Elemento padre: 203   */
      v.add(doc.createElement("td"));
      ((Element)v.get(203)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(206)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(208)).setAttribute("class","legend" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("LABELC"));
   }

   private void getXML900(Document doc) {
      ((Element)v.get(209)).setAttribute("nombre","lblVentas" );
      ((Element)v.get(209)).setAttribute("alto","13" );
      ((Element)v.get(209)).setAttribute("filas","1" );
      ((Element)v.get(209)).setAttribute("valor","" );
      ((Element)v.get(209)).setAttribute("id","legend" );
      ((Element)v.get(209)).setAttribute("cod","00344" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */

      /* Empieza nodo:210 / Elemento padre: 207   */
      v.add(doc.createElement("table"));
      ((Element)v.get(210)).setAttribute("width","100%" );
      ((Element)v.get(210)).setAttribute("border","0" );
      ((Element)v.get(210)).setAttribute("align","center" );
      ((Element)v.get(210)).setAttribute("cellspacing","0" );
      ((Element)v.get(210)).setAttribute("cellpadding","0" );
      ((Element)v.get(207)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(210)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("td"));
      ((Element)v.get(211)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("table"));
      ((Element)v.get(213)).setAttribute("width","663" );
      ((Element)v.get(213)).setAttribute("border","0" );
      ((Element)v.get(213)).setAttribute("align","left" );
      ((Element)v.get(213)).setAttribute("cellspacing","0" );
      ((Element)v.get(213)).setAttribute("cellpadding","0" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(213)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("td"));
      ((Element)v.get(215)).setAttribute("colspan","4" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(216)).setAttribute("src","b.gif" );
      ((Element)v.get(216)).setAttribute("width","8" );
      ((Element)v.get(216)).setAttribute("height","8" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */
      /* Termina nodo:215   */
      /* Termina nodo:214   */

      /* Empieza nodo:217 / Elemento padre: 213   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(213)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("td"));
      ((Element)v.get(217)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(219)).setAttribute("src","b.gif" );
      ((Element)v.get(219)).setAttribute("width","8" );
      ((Element)v.get(219)).setAttribute("height","8" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */

      /* Empieza nodo:220 / Elemento padre: 217   */
      v.add(doc.createElement("td"));
      ((Element)v.get(217)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(221)).setAttribute("nombre","lblAplicarComision" );
      ((Element)v.get(221)).setAttribute("alto","13" );
      ((Element)v.get(221)).setAttribute("filas","1" );
      ((Element)v.get(221)).setAttribute("valor","" );
      ((Element)v.get(221)).setAttribute("id","datosTitle" );
      ((Element)v.get(221)).setAttribute("cod","1733" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */
      /* Termina nodo:220   */

      /* Empieza nodo:222 / Elemento padre: 217   */
      v.add(doc.createElement("td"));
      ((Element)v.get(217)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(223)).setAttribute("src","b.gif" );
      ((Element)v.get(223)).setAttribute("width","25" );
      ((Element)v.get(223)).setAttribute("height","8" );
      ((Element)v.get(222)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */
      /* Termina nodo:222   */

      /* Empieza nodo:224 / Elemento padre: 217   */
      v.add(doc.createElement("td"));
      ((Element)v.get(217)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(225)).setAttribute("nombre","lblCalcularIncobrables" );
      ((Element)v.get(225)).setAttribute("alto","13" );
      ((Element)v.get(225)).setAttribute("filas","1" );
      ((Element)v.get(225)).setAttribute("valor","" );
      ((Element)v.get(225)).setAttribute("id","datosTitle" );
      ((Element)v.get(225)).setAttribute("cod","1734" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */
      /* Termina nodo:224   */

      /* Empieza nodo:226 / Elemento padre: 217   */
      v.add(doc.createElement("td"));
      ((Element)v.get(217)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(227)).setAttribute("src","b.gif" );
      ((Element)v.get(227)).setAttribute("width","25" );
      ((Element)v.get(227)).setAttribute("height","8" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */
      /* Termina nodo:226   */

      /* Empieza nodo:228 / Elemento padre: 217   */
      v.add(doc.createElement("td"));
      ((Element)v.get(217)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(229)).setAttribute("nombre","lblFecha" );
      ((Element)v.get(229)).setAttribute("alto","13" );
      ((Element)v.get(229)).setAttribute("filas","1" );
      ((Element)v.get(229)).setAttribute("valor","" );
      ((Element)v.get(229)).setAttribute("id","datosTitle" );
      ((Element)v.get(229)).setAttribute("cod","188" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */
      /* Termina nodo:228   */

      /* Empieza nodo:230 / Elemento padre: 217   */
      v.add(doc.createElement("td"));
      ((Element)v.get(217)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
   }

   private void getXML990(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(231)).setAttribute("src","b.gif" );
      ((Element)v.get(231)).setAttribute("width","25" );
      ((Element)v.get(231)).setAttribute("height","8" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */
      /* Termina nodo:230   */

      /* Empieza nodo:232 / Elemento padre: 217   */
      v.add(doc.createElement("td"));
      ((Element)v.get(217)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(233)).setAttribute("nombre","lblDiasIncobrables" );
      ((Element)v.get(233)).setAttribute("alto","13" );
      ((Element)v.get(233)).setAttribute("filas","1" );
      ((Element)v.get(233)).setAttribute("valor","" );
      ((Element)v.get(233)).setAttribute("id","datosTitle" );
      ((Element)v.get(233)).setAttribute("cod","1737" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */
      /* Termina nodo:232   */

      /* Empieza nodo:234 / Elemento padre: 217   */
      v.add(doc.createElement("td"));
      ((Element)v.get(234)).setAttribute("width","100%" );
      ((Element)v.get(217)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(235)).setAttribute("src","b.gif" );
      ((Element)v.get(235)).setAttribute("width","8" );
      ((Element)v.get(235)).setAttribute("height","8" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */
      /* Termina nodo:234   */
      /* Termina nodo:217   */

      /* Empieza nodo:236 / Elemento padre: 213   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(213)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("td"));
      ((Element)v.get(236)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(238)).setAttribute("src","b.gif" );
      ((Element)v.get(238)).setAttribute("width","8" );
      ((Element)v.get(238)).setAttribute("height","8" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */
      /* Termina nodo:237   */

      /* Empieza nodo:239 / Elemento padre: 236   */
      v.add(doc.createElement("td"));
      ((Element)v.get(239)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(236)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(240)).setAttribute("nombre","cbAplicarComision" );
      ((Element)v.get(240)).setAttribute("id","datosCampos" );
      ((Element)v.get(240)).setAttribute("size","1" );
      ((Element)v.get(240)).setAttribute("multiple","N" );
      ((Element)v.get(240)).setAttribute("req","S" );
      ((Element)v.get(240)).setAttribute("valorinicial","" );
      ((Element)v.get(240)).setAttribute("textoinicial","" );
      ((Element)v.get(240)).setAttribute("onchange","onChangeAplicarComision();" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(240)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */
      /* Termina nodo:240   */
      /* Termina nodo:239   */

      /* Empieza nodo:242 / Elemento padre: 236   */
      v.add(doc.createElement("td"));
      ((Element)v.get(236)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(243)).setAttribute("src","b.gif" );
      ((Element)v.get(243)).setAttribute("width","25" );
      ((Element)v.get(243)).setAttribute("height","8" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */
      /* Termina nodo:242   */

      /* Empieza nodo:244 / Elemento padre: 236   */
      v.add(doc.createElement("td"));
      ((Element)v.get(236)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(245)).setAttribute("nombre","ckCalcularIncobrables" );
      ((Element)v.get(245)).setAttribute("id","datosCampos" );
      ((Element)v.get(245)).setAttribute("onclick","onChangeCalcularIncobrables();" );
      ((Element)v.get(245)).setAttribute("check","N" );
      ((Element)v.get(244)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */
      /* Termina nodo:244   */

      /* Empieza nodo:246 / Elemento padre: 236   */
      v.add(doc.createElement("td"));
      ((Element)v.get(236)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(247)).setAttribute("src","b.gif" );
      ((Element)v.get(247)).setAttribute("width","25" );
      ((Element)v.get(247)).setAttribute("height","8" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */
      /* Termina nodo:246   */

      /* Empieza nodo:248 / Elemento padre: 236   */
      v.add(doc.createElement("td"));
      ((Element)v.get(248)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(236)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("table"));
      ((Element)v.get(249)).setAttribute("width","100%" );
      ((Element)v.get(249)).setAttribute("border","0" );
      ((Element)v.get(249)).setAttribute("cellspacing","0" );
      ((Element)v.get(249)).setAttribute("cellpadding","0" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(249)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("td"));
      ((Element)v.get(251)).setAttribute("class","datosCampos" );
      ((Element)v.get(251)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(252)).setAttribute("nombre","rbFecha" );
      ((Element)v.get(252)).setAttribute("tipo","H" );
      ((Element)v.get(252)).setAttribute("id","datosCampos" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("RBINPUT"));
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(253)).setAttribute("valor","S" );
      ((Element)v.get(253)).setAttribute("check","N" );
      ((Element)v.get(253)).setAttribute("onfocus","" );
      ((Element)v.get(253)).setAttribute("id","datosCampos" );
      ((Element)v.get(253)).setAttribute("cod","392" );
      ((Element)v.get(252)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */

      /* Empieza nodo:254 / Elemento padre: 252   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(254)).setAttribute("valor","N" );
      ((Element)v.get(254)).setAttribute("check","S" );
      ((Element)v.get(254)).setAttribute("onfocus","" );
      ((Element)v.get(254)).setAttribute("id","datosCampos" );
      ((Element)v.get(254)).setAttribute("cod","883" );
      ((Element)v.get(252)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */
      /* Termina nodo:252   */
      /* Termina nodo:251   */
      /* Termina nodo:250   */
      /* Termina nodo:249   */
      /* Termina nodo:248   */

      /* Empieza nodo:255 / Elemento padre: 236   */
      v.add(doc.createElement("td"));
      ((Element)v.get(236)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(256)).setAttribute("src","b.gif" );
      ((Element)v.get(256)).setAttribute("width","25" );
      ((Element)v.get(256)).setAttribute("height","8" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */
      /* Termina nodo:255   */

      /* Empieza nodo:257 / Elemento padre: 236   */
      v.add(doc.createElement("td"));
      ((Element)v.get(257)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(236)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(258)).setAttribute("nombre","txtDiasIncobrables" );
      ((Element)v.get(258)).setAttribute("id","datosCampos" );
      ((Element)v.get(258)).setAttribute("max","3" );
      ((Element)v.get(258)).setAttribute("tipo","" );
      ((Element)v.get(258)).setAttribute("onchange","" );
      ((Element)v.get(258)).setAttribute("req","S" );
      ((Element)v.get(258)).setAttribute("size","3" );
      ((Element)v.get(258)).setAttribute("valor","" );
      ((Element)v.get(258)).setAttribute("validacion","" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */
      /* Termina nodo:257   */

      /* Empieza nodo:259 / Elemento padre: 236   */
      v.add(doc.createElement("td"));
      ((Element)v.get(259)).setAttribute("width","100%" );
      ((Element)v.get(236)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(260)).setAttribute("src","b.gif" );
      ((Element)v.get(260)).setAttribute("width","8" );
      ((Element)v.get(260)).setAttribute("height","8" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */
      /* Termina nodo:259   */
      /* Termina nodo:236   */

      /* Empieza nodo:261 / Elemento padre: 213   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(213)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("td"));
      ((Element)v.get(262)).setAttribute("colspan","4" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(263)).setAttribute("src","b.gif" );
      ((Element)v.get(263)).setAttribute("width","8" );
      ((Element)v.get(263)).setAttribute("height","8" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */
      /* Termina nodo:262   */
      /* Termina nodo:261   */
      /* Termina nodo:213   */
      /* Termina nodo:212   */
      /* Termina nodo:211   */

      /* Empieza nodo:264 / Elemento padre: 210   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(210)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("td"));
      ((Element)v.get(264)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("table"));
      ((Element)v.get(266)).setAttribute("width","663" );
      ((Element)v.get(266)).setAttribute("border","0" );
      ((Element)v.get(266)).setAttribute("align","left" );
      ((Element)v.get(266)).setAttribute("cellspacing","0" );
      ((Element)v.get(266)).setAttribute("cellpadding","0" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(266)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("td"));
      ((Element)v.get(267)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(269)).setAttribute("src","b.gif" );
      ((Element)v.get(269)).setAttribute("width","8" );
      ((Element)v.get(269)).setAttribute("height","8" );
      ((Element)v.get(268)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */
      /* Termina nodo:268   */

      /* Empieza nodo:270 / Elemento padre: 267   */
      v.add(doc.createElement("td"));
      ((Element)v.get(267)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(271)).setAttribute("nombre","lblFormula" );
      ((Element)v.get(271)).setAttribute("alto","13" );
      ((Element)v.get(271)).setAttribute("filas","1" );
      ((Element)v.get(271)).setAttribute("valor","" );
      ((Element)v.get(271)).setAttribute("id","datosTitle" );
      ((Element)v.get(271)).setAttribute("cod","885" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */
      /* Termina nodo:270   */

      /* Empieza nodo:272 / Elemento padre: 267   */
      v.add(doc.createElement("td"));
      ((Element)v.get(267)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(273)).setAttribute("src","b.gif" );
      ((Element)v.get(273)).setAttribute("width","25" );
      ((Element)v.get(273)).setAttribute("height","8" );
      ((Element)v.get(272)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */
      /* Termina nodo:272   */

      /* Empieza nodo:274 / Elemento padre: 267   */
      v.add(doc.createElement("td"));
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(267)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(275)).setAttribute("nombre","lblDevoluciones" );
      ((Element)v.get(275)).setAttribute("alto","13" );
      ((Element)v.get(275)).setAttribute("filas","1" );
      ((Element)v.get(275)).setAttribute("valor","" );
      ((Element)v.get(275)).setAttribute("id","datosTitle" );
      ((Element)v.get(275)).setAttribute("cod","1623" );
      ((Element)v.get(274)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */
      /* Termina nodo:274   */

      /* Empieza nodo:276 / Elemento padre: 267   */
      v.add(doc.createElement("td"));
      ((Element)v.get(267)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(277)).setAttribute("src","b.gif" );
      ((Element)v.get(277)).setAttribute("width","25" );
      ((Element)v.get(277)).setAttribute("height","8" );
      ((Element)v.get(276)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */
      /* Termina nodo:276   */

      /* Empieza nodo:278 / Elemento padre: 267   */
      v.add(doc.createElement("td"));
      ((Element)v.get(267)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(279)).setAttribute("nombre","lblAnulaciones" );
      ((Element)v.get(279)).setAttribute("alto","13" );
      ((Element)v.get(279)).setAttribute("filas","1" );
      ((Element)v.get(279)).setAttribute("valor","" );
      ((Element)v.get(279)).setAttribute("id","datosTitle" );
      ((Element)v.get(279)).setAttribute("cod","1624" );
      ((Element)v.get(278)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */
      /* Termina nodo:278   */

      /* Empieza nodo:280 / Elemento padre: 267   */
      v.add(doc.createElement("td"));
      ((Element)v.get(267)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(281)).setAttribute("src","b.gif" );
      ((Element)v.get(281)).setAttribute("width","25" );
      ((Element)v.get(281)).setAttribute("height","8" );
      ((Element)v.get(280)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */
      /* Termina nodo:280   */

      /* Empieza nodo:282 / Elemento padre: 267   */
      v.add(doc.createElement("td"));
      ((Element)v.get(267)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(283)).setAttribute("nombre","lblFaltantesNoAnunciados" );
      ((Element)v.get(283)).setAttribute("alto","13" );
      ((Element)v.get(283)).setAttribute("filas","1" );
      ((Element)v.get(283)).setAttribute("valor","" );
      ((Element)v.get(283)).setAttribute("id","datosTitle" );
      ((Element)v.get(283)).setAttribute("cod","1625" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */
      /* Termina nodo:282   */

      /* Empieza nodo:284 / Elemento padre: 267   */
      v.add(doc.createElement("td"));
      ((Element)v.get(267)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(285)).setAttribute("src","b.gif" );
      ((Element)v.get(285)).setAttribute("width","25" );
      ((Element)v.get(285)).setAttribute("height","8" );
      ((Element)v.get(284)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */
      /* Termina nodo:284   */

      /* Empieza nodo:286 / Elemento padre: 267   */
      v.add(doc.createElement("td"));
      ((Element)v.get(267)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(287)).setAttribute("nombre","lblComision" );
      ((Element)v.get(287)).setAttribute("alto","13" );
      ((Element)v.get(287)).setAttribute("filas","1" );
      ((Element)v.get(287)).setAttribute("valor","" );
      ((Element)v.get(287)).setAttribute("id","datosTitle" );
      ((Element)v.get(287)).setAttribute("cod","1545" );
      ((Element)v.get(286)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */
      /* Termina nodo:286   */

      /* Empieza nodo:288 / Elemento padre: 267   */
      v.add(doc.createElement("td"));
      ((Element)v.get(267)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(289)).setAttribute("src","b.gif" );
      ((Element)v.get(289)).setAttribute("width","25" );
      ((Element)v.get(289)).setAttribute("height","8" );
      ((Element)v.get(288)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */
      /* Termina nodo:288   */

      /* Empieza nodo:290 / Elemento padre: 267   */
      v.add(doc.createElement("td"));
      ((Element)v.get(267)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(291)).setAttribute("nombre","lblImporteFijo" );
      ((Element)v.get(291)).setAttribute("alto","13" );
      ((Element)v.get(291)).setAttribute("filas","1" );
      ((Element)v.get(291)).setAttribute("valor","" );
      ((Element)v.get(291)).setAttribute("id","datosTitle" );
      ((Element)v.get(291)).setAttribute("cod","1736" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */
      /* Termina nodo:290   */

      /* Empieza nodo:292 / Elemento padre: 267   */
      v.add(doc.createElement("td"));
      ((Element)v.get(292)).setAttribute("width","100%" );
      ((Element)v.get(267)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(293)).setAttribute("src","b.gif" );
      ((Element)v.get(293)).setAttribute("width","8" );
      ((Element)v.get(293)).setAttribute("height","8" );
      ((Element)v.get(292)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */
      /* Termina nodo:292   */
      /* Termina nodo:267   */

      /* Empieza nodo:294 / Elemento padre: 266   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(266)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("td"));
      ((Element)v.get(294)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(296)).setAttribute("src","b.gif" );
      ((Element)v.get(296)).setAttribute("width","8" );
      ((Element)v.get(296)).setAttribute("height","8" );
      ((Element)v.get(295)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */
      /* Termina nodo:295   */

      /* Empieza nodo:297 / Elemento padre: 294   */
      v.add(doc.createElement("td"));
      ((Element)v.get(297)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(294)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(298)).setAttribute("nombre","cbFormula" );
      ((Element)v.get(298)).setAttribute("id","datosCampos" );
      ((Element)v.get(298)).setAttribute("size","1" );
      ((Element)v.get(298)).setAttribute("multiple","N" );
      ((Element)v.get(298)).setAttribute("req","S" );
      ((Element)v.get(298)).setAttribute("valorinicial","" );
      ((Element)v.get(298)).setAttribute("textoinicial","" );
      ((Element)v.get(297)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(298)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */
      /* Termina nodo:298   */
      /* Termina nodo:297   */

      /* Empieza nodo:300 / Elemento padre: 294   */
      v.add(doc.createElement("td"));
      ((Element)v.get(294)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(301)).setAttribute("src","b.gif" );
      ((Element)v.get(301)).setAttribute("width","25" );
      ((Element)v.get(301)).setAttribute("height","8" );
      ((Element)v.get(300)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */
      /* Termina nodo:300   */

      /* Empieza nodo:302 / Elemento padre: 294   */
      v.add(doc.createElement("td"));
      ((Element)v.get(294)).appendChild((Element)v.get(302));

      /* Empieza nodo:303 / Elemento padre: 302   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(303)).setAttribute("nombre","ckDevoluciones" );
      ((Element)v.get(303)).setAttribute("id","datosCampos" );
      ((Element)v.get(303)).setAttribute("onclick","" );
      ((Element)v.get(303)).setAttribute("check","N" );
      ((Element)v.get(302)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */
      /* Termina nodo:302   */

      /* Empieza nodo:304 / Elemento padre: 294   */
      v.add(doc.createElement("td"));
      ((Element)v.get(294)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(305)).setAttribute("src","b.gif" );
      ((Element)v.get(305)).setAttribute("width","25" );
      ((Element)v.get(305)).setAttribute("height","8" );
      ((Element)v.get(304)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */
      /* Termina nodo:304   */

      /* Empieza nodo:306 / Elemento padre: 294   */
      v.add(doc.createElement("td"));
      ((Element)v.get(294)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(307)).setAttribute("nombre","ckAnulaciones" );
      ((Element)v.get(307)).setAttribute("id","datosCampos" );
      ((Element)v.get(307)).setAttribute("onclick","" );
      ((Element)v.get(307)).setAttribute("check","N" );
      ((Element)v.get(306)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */
      /* Termina nodo:306   */

      /* Empieza nodo:308 / Elemento padre: 294   */
      v.add(doc.createElement("td"));
      ((Element)v.get(294)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(309)).setAttribute("src","b.gif" );
      ((Element)v.get(309)).setAttribute("width","25" );
      ((Element)v.get(309)).setAttribute("height","8" );
      ((Element)v.get(308)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */
      /* Termina nodo:308   */

      /* Empieza nodo:310 / Elemento padre: 294   */
      v.add(doc.createElement("td"));
      ((Element)v.get(294)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(311)).setAttribute("nombre","ckFaltantesNoAnunciados" );
      ((Element)v.get(311)).setAttribute("id","datosCampos" );
      ((Element)v.get(311)).setAttribute("onclick","" );
      ((Element)v.get(311)).setAttribute("check","N" );
      ((Element)v.get(310)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */
      /* Termina nodo:310   */

      /* Empieza nodo:312 / Elemento padre: 294   */
      v.add(doc.createElement("td"));
      ((Element)v.get(294)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(313)).setAttribute("src","b.gif" );
      ((Element)v.get(313)).setAttribute("width","25" );
      ((Element)v.get(313)).setAttribute("height","8" );
      ((Element)v.get(312)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */
      /* Termina nodo:312   */

      /* Empieza nodo:314 / Elemento padre: 294   */
      v.add(doc.createElement("td"));
      ((Element)v.get(314)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(314)).setAttribute("class","datosCampos" );
      ((Element)v.get(294)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(315)).setAttribute("nombre","txtPorcentaje" );
      ((Element)v.get(315)).setAttribute("id","datosCampos" );
      ((Element)v.get(315)).setAttribute("max","6" );
      ((Element)v.get(315)).setAttribute("tipo","" );
      ((Element)v.get(315)).setAttribute("onchange","" );
      ((Element)v.get(315)).setAttribute("req","N" );
      ((Element)v.get(315)).setAttribute("size","6" );
      ((Element)v.get(315)).setAttribute("valor","" );
      ((Element)v.get(315)).setAttribute("validacion","" );
      ((Element)v.get(314)).appendChild((Element)v.get(315));
      /* Termina nodo:315   */
      /* Termina nodo:314   */

      /* Empieza nodo:316 / Elemento padre: 294   */
      v.add(doc.createElement("td"));
      ((Element)v.get(294)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(317)).setAttribute("src","b.gif" );
      ((Element)v.get(317)).setAttribute("width","25" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(317)).setAttribute("height","8" );
      ((Element)v.get(316)).appendChild((Element)v.get(317));
      /* Termina nodo:317   */
      /* Termina nodo:316   */

      /* Empieza nodo:318 / Elemento padre: 294   */
      v.add(doc.createElement("td"));
      ((Element)v.get(318)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(318)).setAttribute("valign","bottom" );
      ((Element)v.get(294)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(319)).setAttribute("nombre","txtImporteFijo" );
      ((Element)v.get(319)).setAttribute("id","datosCampos" );
      ((Element)v.get(319)).setAttribute("max","16" );
      ((Element)v.get(319)).setAttribute("tipo","" );
      ((Element)v.get(319)).setAttribute("onchange","" );
      ((Element)v.get(319)).setAttribute("req","N" );
      ((Element)v.get(319)).setAttribute("size","19" );
      ((Element)v.get(319)).setAttribute("valor","" );
      ((Element)v.get(319)).setAttribute("validacion","" );
      ((Element)v.get(318)).appendChild((Element)v.get(319));
      /* Termina nodo:319   */
      /* Termina nodo:318   */

      /* Empieza nodo:320 / Elemento padre: 294   */
      v.add(doc.createElement("td"));
      ((Element)v.get(320)).setAttribute("width","100%" );
      ((Element)v.get(294)).appendChild((Element)v.get(320));

      /* Empieza nodo:321 / Elemento padre: 320   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(321)).setAttribute("src","b.gif" );
      ((Element)v.get(321)).setAttribute("width","8" );
      ((Element)v.get(321)).setAttribute("height","8" );
      ((Element)v.get(320)).appendChild((Element)v.get(321));
      /* Termina nodo:321   */
      /* Termina nodo:320   */
      /* Termina nodo:294   */

      /* Empieza nodo:322 / Elemento padre: 266   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(266)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("td"));
      ((Element)v.get(323)).setAttribute("colspan","4" );
      ((Element)v.get(322)).appendChild((Element)v.get(323));

      /* Empieza nodo:324 / Elemento padre: 323   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(324)).setAttribute("src","b.gif" );
      ((Element)v.get(324)).setAttribute("width","8" );
      ((Element)v.get(324)).setAttribute("height","8" );
      ((Element)v.get(323)).appendChild((Element)v.get(324));
      /* Termina nodo:324   */
      /* Termina nodo:323   */
      /* Termina nodo:322   */
      /* Termina nodo:266   */
      /* Termina nodo:265   */
      /* Termina nodo:264   */

      /* Empieza nodo:325 / Elemento padre: 210   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(210)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("td"));
      ((Element)v.get(325)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
      v.add(doc.createElement("table"));
      ((Element)v.get(327)).setAttribute("width","663" );
      ((Element)v.get(327)).setAttribute("border","0" );
      ((Element)v.get(327)).setAttribute("align","left" );
      ((Element)v.get(327)).setAttribute("cellspacing","0" );
      ((Element)v.get(327)).setAttribute("cellpadding","0" );
      ((Element)v.get(326)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(327)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("td"));
      ((Element)v.get(328)).appendChild((Element)v.get(329));

      /* Empieza nodo:330 / Elemento padre: 329   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(330)).setAttribute("src","b.gif" );
      ((Element)v.get(330)).setAttribute("width","8" );
      ((Element)v.get(330)).setAttribute("height","8" );
      ((Element)v.get(329)).appendChild((Element)v.get(330));
      /* Termina nodo:330   */
      /* Termina nodo:329   */

      /* Empieza nodo:331 / Elemento padre: 328   */
      v.add(doc.createElement("td"));
      ((Element)v.get(328)).appendChild((Element)v.get(331));

      /* Empieza nodo:332 / Elemento padre: 331   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(332)).setAttribute("nombre","lblComparativo" );
      ((Element)v.get(332)).setAttribute("alto","13" );
      ((Element)v.get(332)).setAttribute("filas","1" );
      ((Element)v.get(332)).setAttribute("valor","" );
      ((Element)v.get(332)).setAttribute("id","datosTitle" );
      ((Element)v.get(332)).setAttribute("cod","1699" );
      ((Element)v.get(331)).appendChild((Element)v.get(332));
      /* Termina nodo:332   */
      /* Termina nodo:331   */

      /* Empieza nodo:333 / Elemento padre: 328   */
      v.add(doc.createElement("td"));
      ((Element)v.get(333)).setAttribute("width","100%" );
      ((Element)v.get(328)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(334)).setAttribute("src","b.gif" );
      ((Element)v.get(334)).setAttribute("width","8" );
      ((Element)v.get(334)).setAttribute("height","8" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */
      /* Termina nodo:333   */
      /* Termina nodo:328   */

      /* Empieza nodo:335 / Elemento padre: 327   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(327)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("td"));
      ((Element)v.get(335)).appendChild((Element)v.get(336));

      /* Empieza nodo:337 / Elemento padre: 336   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(337)).setAttribute("src","b.gif" );
      ((Element)v.get(337)).setAttribute("width","8" );
      ((Element)v.get(337)).setAttribute("height","8" );
      ((Element)v.get(336)).appendChild((Element)v.get(337));
      /* Termina nodo:337   */
      /* Termina nodo:336   */

      /* Empieza nodo:338 / Elemento padre: 335   */
      v.add(doc.createElement("td"));
      ((Element)v.get(338)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(335)).appendChild((Element)v.get(338));

      /* Empieza nodo:339 / Elemento padre: 338   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(339)).setAttribute("nombre","cbComparativo" );
      ((Element)v.get(339)).setAttribute("id","datosCampos" );
      ((Element)v.get(339)).setAttribute("size","1" );
      ((Element)v.get(339)).setAttribute("multiple","N" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(339)).setAttribute("req","S" );
      ((Element)v.get(339)).setAttribute("valorinicial","" );
      ((Element)v.get(339)).setAttribute("textoinicial","" );
      ((Element)v.get(339)).setAttribute("onchange","onChangeComparativo();" );
      ((Element)v.get(338)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(339)).appendChild((Element)v.get(340));
      /* Termina nodo:340   */
      /* Termina nodo:339   */
      /* Termina nodo:338   */

      /* Empieza nodo:341 / Elemento padre: 335   */
      v.add(doc.createElement("td"));
      ((Element)v.get(341)).setAttribute("width","100%" );
      ((Element)v.get(335)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(342)).setAttribute("src","b.gif" );
      ((Element)v.get(342)).setAttribute("width","8" );
      ((Element)v.get(342)).setAttribute("height","8" );
      ((Element)v.get(341)).appendChild((Element)v.get(342));
      /* Termina nodo:342   */
      /* Termina nodo:341   */
      /* Termina nodo:335   */

      /* Empieza nodo:343 / Elemento padre: 327   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(327)).appendChild((Element)v.get(343));

      /* Empieza nodo:344 / Elemento padre: 343   */
      v.add(doc.createElement("td"));
      ((Element)v.get(344)).setAttribute("colspan","4" );
      ((Element)v.get(343)).appendChild((Element)v.get(344));

      /* Empieza nodo:345 / Elemento padre: 344   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(345)).setAttribute("src","b.gif" );
      ((Element)v.get(345)).setAttribute("width","8" );
      ((Element)v.get(345)).setAttribute("height","12" );
      ((Element)v.get(344)).appendChild((Element)v.get(345));
      /* Termina nodo:345   */
      /* Termina nodo:344   */
      /* Termina nodo:343   */
      /* Termina nodo:327   */
      /* Termina nodo:326   */
      /* Termina nodo:325   */

      /* Empieza nodo:346 / Elemento padre: 210   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(210)).appendChild((Element)v.get(346));

      /* Empieza nodo:347 / Elemento padre: 346   */
      v.add(doc.createElement("td"));
      ((Element)v.get(346)).appendChild((Element)v.get(347));

      /* Empieza nodo:348 / Elemento padre: 347   */
      v.add(doc.createElement("table"));
      ((Element)v.get(348)).setAttribute("width","100%" );
      ((Element)v.get(348)).setAttribute("border","0" );
      ((Element)v.get(348)).setAttribute("align","center" );
      ((Element)v.get(348)).setAttribute("cellspacing","0" );
      ((Element)v.get(348)).setAttribute("cellpadding","0" );
      ((Element)v.get(347)).appendChild((Element)v.get(348));

      /* Empieza nodo:349 / Elemento padre: 348   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(348)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("td"));
      ((Element)v.get(349)).appendChild((Element)v.get(350));

      /* Empieza nodo:351 / Elemento padre: 350   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(351)).setAttribute("src","b.gif" );
      ((Element)v.get(351)).setAttribute("width","8" );
      ((Element)v.get(351)).setAttribute("height","8" );
      ((Element)v.get(350)).appendChild((Element)v.get(351));
      /* Termina nodo:351   */
      /* Termina nodo:350   */

      /* Empieza nodo:352 / Elemento padre: 349   */
      v.add(doc.createElement("td"));
      ((Element)v.get(352)).setAttribute("width","100%" );
      ((Element)v.get(349)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
      v.add(doc.createElement("table"));
      ((Element)v.get(353)).setAttribute("width","100%" );
      ((Element)v.get(353)).setAttribute("border","0" );
      ((Element)v.get(353)).setAttribute("cellspacing","0" );
      ((Element)v.get(353)).setAttribute("cellpadding","0" );
      ((Element)v.get(352)).appendChild((Element)v.get(353));

      /* Empieza nodo:354 / Elemento padre: 353   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(353)).appendChild((Element)v.get(354));

      /* Empieza nodo:355 / Elemento padre: 354   */
      v.add(doc.createElement("td"));
      ((Element)v.get(354)).appendChild((Element)v.get(355));

      /* Empieza nodo:356 / Elemento padre: 355   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(355)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(357)).setAttribute("class","legend" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));

      /* Empieza nodo:358 / Elemento padre: 357   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(358)).setAttribute("nombre","lblVentaHistorica" );
      ((Element)v.get(358)).setAttribute("alto","13" );
      ((Element)v.get(358)).setAttribute("filas","1" );
      ((Element)v.get(358)).setAttribute("valor","" );
      ((Element)v.get(358)).setAttribute("id","legend" );
      ((Element)v.get(358)).setAttribute("cod","00350" );
      ((Element)v.get(357)).appendChild((Element)v.get(358));
      /* Termina nodo:358   */
      /* Termina nodo:357   */

      /* Empieza nodo:359 / Elemento padre: 356   */
      v.add(doc.createElement("table"));
      ((Element)v.get(359)).setAttribute("width","100%" );
      ((Element)v.get(359)).setAttribute("border","0" );
      ((Element)v.get(359)).setAttribute("align","center" );
      ((Element)v.get(359)).setAttribute("cellspacing","0" );
      ((Element)v.get(359)).setAttribute("cellpadding","0" );
      ((Element)v.get(356)).appendChild((Element)v.get(359));

      /* Empieza nodo:360 / Elemento padre: 359   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(359)).appendChild((Element)v.get(360));

      /* Empieza nodo:361 / Elemento padre: 360   */
      v.add(doc.createElement("td"));
      ((Element)v.get(360)).appendChild((Element)v.get(361));

      /* Empieza nodo:362 / Elemento padre: 361   */
      v.add(doc.createElement("table"));
      ((Element)v.get(362)).setAttribute("width","643" );
      ((Element)v.get(362)).setAttribute("border","0" );
      ((Element)v.get(362)).setAttribute("align","left" );
      ((Element)v.get(362)).setAttribute("cellspacing","0" );
      ((Element)v.get(362)).setAttribute("cellpadding","0" );
      ((Element)v.get(361)).appendChild((Element)v.get(362));

      /* Empieza nodo:363 / Elemento padre: 362   */
      v.add(doc.createElement("tr"));
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(362)).appendChild((Element)v.get(363));

      /* Empieza nodo:364 / Elemento padre: 363   */
      v.add(doc.createElement("td"));
      ((Element)v.get(364)).setAttribute("colspan","3" );
      ((Element)v.get(363)).appendChild((Element)v.get(364));

      /* Empieza nodo:365 / Elemento padre: 364   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(365)).setAttribute("src","b.gif" );
      ((Element)v.get(365)).setAttribute("width","8" );
      ((Element)v.get(365)).setAttribute("height","8" );
      ((Element)v.get(364)).appendChild((Element)v.get(365));
      /* Termina nodo:365   */
      /* Termina nodo:364   */
      /* Termina nodo:363   */

      /* Empieza nodo:366 / Elemento padre: 362   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(362)).appendChild((Element)v.get(366));

      /* Empieza nodo:367 / Elemento padre: 366   */
      v.add(doc.createElement("td"));
      ((Element)v.get(366)).appendChild((Element)v.get(367));

      /* Empieza nodo:368 / Elemento padre: 367   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(368)).setAttribute("src","b.gif" );
      ((Element)v.get(368)).setAttribute("width","8" );
      ((Element)v.get(368)).setAttribute("height","8" );
      ((Element)v.get(367)).appendChild((Element)v.get(368));
      /* Termina nodo:368   */
      /* Termina nodo:367   */

      /* Empieza nodo:369 / Elemento padre: 366   */
      v.add(doc.createElement("td"));
      ((Element)v.get(366)).appendChild((Element)v.get(369));

      /* Empieza nodo:370 / Elemento padre: 369   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(370)).setAttribute("nombre","lblPeriodoInicialEvaluacion" );
      ((Element)v.get(370)).setAttribute("alto","13" );
      ((Element)v.get(370)).setAttribute("filas","1" );
      ((Element)v.get(370)).setAttribute("valor","" );
      ((Element)v.get(370)).setAttribute("id","datosTitle" );
      ((Element)v.get(370)).setAttribute("cod","1674" );
      ((Element)v.get(369)).appendChild((Element)v.get(370));
      /* Termina nodo:370   */
      /* Termina nodo:369   */

      /* Empieza nodo:371 / Elemento padre: 366   */
      v.add(doc.createElement("td"));
      ((Element)v.get(366)).appendChild((Element)v.get(371));

      /* Empieza nodo:372 / Elemento padre: 371   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(372)).setAttribute("src","b.gif" );
      ((Element)v.get(372)).setAttribute("width","25" );
      ((Element)v.get(372)).setAttribute("height","8" );
      ((Element)v.get(371)).appendChild((Element)v.get(372));
      /* Termina nodo:372   */
      /* Termina nodo:371   */

      /* Empieza nodo:373 / Elemento padre: 366   */
      v.add(doc.createElement("td"));
      ((Element)v.get(366)).appendChild((Element)v.get(373));

      /* Empieza nodo:374 / Elemento padre: 373   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(374)).setAttribute("nombre","lblPeriodoFinalEvaluacion" );
      ((Element)v.get(374)).setAttribute("alto","13" );
      ((Element)v.get(374)).setAttribute("filas","1" );
      ((Element)v.get(374)).setAttribute("valor","" );
      ((Element)v.get(374)).setAttribute("id","datosTitle" );
      ((Element)v.get(374)).setAttribute("cod","1739" );
      ((Element)v.get(373)).appendChild((Element)v.get(374));
      /* Termina nodo:374   */
      /* Termina nodo:373   */

      /* Empieza nodo:375 / Elemento padre: 366   */
      v.add(doc.createElement("td"));
      ((Element)v.get(366)).appendChild((Element)v.get(375));

      /* Empieza nodo:376 / Elemento padre: 375   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(376)).setAttribute("src","b.gif" );
      ((Element)v.get(376)).setAttribute("width","25" );
      ((Element)v.get(376)).setAttribute("height","8" );
      ((Element)v.get(375)).appendChild((Element)v.get(376));
      /* Termina nodo:376   */
      /* Termina nodo:375   */

      /* Empieza nodo:377 / Elemento padre: 366   */
      v.add(doc.createElement("td"));
      ((Element)v.get(366)).appendChild((Element)v.get(377));

      /* Empieza nodo:378 / Elemento padre: 377   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(378)).setAttribute("nombre","lblPorcentaje" );
      ((Element)v.get(378)).setAttribute("alto","13" );
      ((Element)v.get(378)).setAttribute("filas","1" );
      ((Element)v.get(378)).setAttribute("valor","" );
      ((Element)v.get(378)).setAttribute("id","datosTitle" );
      ((Element)v.get(378)).setAttribute("cod","1848" );
      ((Element)v.get(377)).appendChild((Element)v.get(378));
      /* Termina nodo:378   */
      /* Termina nodo:377   */

      /* Empieza nodo:379 / Elemento padre: 366   */
      v.add(doc.createElement("td"));
      ((Element)v.get(366)).appendChild((Element)v.get(379));

      /* Empieza nodo:380 / Elemento padre: 379   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(380)).setAttribute("src","b.gif" );
      ((Element)v.get(380)).setAttribute("width","25" );
      ((Element)v.get(380)).setAttribute("height","8" );
      ((Element)v.get(379)).appendChild((Element)v.get(380));
      /* Termina nodo:380   */
      /* Termina nodo:379   */

      /* Empieza nodo:381 / Elemento padre: 366   */
      v.add(doc.createElement("td"));
      ((Element)v.get(366)).appendChild((Element)v.get(381));

      /* Empieza nodo:382 / Elemento padre: 381   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(382)).setAttribute("nombre","lblMonto" );
      ((Element)v.get(382)).setAttribute("alto","13" );
      ((Element)v.get(382)).setAttribute("filas","1" );
      ((Element)v.get(382)).setAttribute("valor","" );
      ((Element)v.get(382)).setAttribute("id","datosTitle" );
      ((Element)v.get(382)).setAttribute("cod","1741" );
      ((Element)v.get(381)).appendChild((Element)v.get(382));
      /* Termina nodo:382   */
      /* Termina nodo:381   */

      /* Empieza nodo:383 / Elemento padre: 366   */
      v.add(doc.createElement("td"));
      ((Element)v.get(383)).setAttribute("width","100%" );
      ((Element)v.get(366)).appendChild((Element)v.get(383));

      /* Empieza nodo:384 / Elemento padre: 383   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(384)).setAttribute("src","b.gif" );
      ((Element)v.get(384)).setAttribute("width","8" );
      ((Element)v.get(384)).setAttribute("height","8" );
      ((Element)v.get(383)).appendChild((Element)v.get(384));
      /* Termina nodo:384   */
      /* Termina nodo:383   */
      /* Termina nodo:366   */

      /* Empieza nodo:385 / Elemento padre: 362   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(362)).appendChild((Element)v.get(385));

      /* Empieza nodo:386 / Elemento padre: 385   */
      v.add(doc.createElement("td"));
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(385)).appendChild((Element)v.get(386));

      /* Empieza nodo:387 / Elemento padre: 386   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(387)).setAttribute("src","b.gif" );
      ((Element)v.get(387)).setAttribute("width","8" );
      ((Element)v.get(387)).setAttribute("height","8" );
      ((Element)v.get(386)).appendChild((Element)v.get(387));
      /* Termina nodo:387   */
      /* Termina nodo:386   */

      /* Empieza nodo:388 / Elemento padre: 385   */
      v.add(doc.createElement("td"));
      ((Element)v.get(385)).appendChild((Element)v.get(388));

      /* Empieza nodo:389 / Elemento padre: 388   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(389)).setAttribute("nombre","lblPeriodoInicialEvaluaciondt" );
      ((Element)v.get(389)).setAttribute("alto","13" );
      ((Element)v.get(389)).setAttribute("filas","1" );
      ((Element)v.get(389)).setAttribute("valor","" );
      ((Element)v.get(389)).setAttribute("id","datosCampos" );
      ((Element)v.get(388)).appendChild((Element)v.get(389));
      /* Termina nodo:389   */
      /* Termina nodo:388   */

      /* Empieza nodo:390 / Elemento padre: 385   */
      v.add(doc.createElement("td"));
      ((Element)v.get(385)).appendChild((Element)v.get(390));

      /* Empieza nodo:391 / Elemento padre: 390   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(391)).setAttribute("src","b.gif" );
      ((Element)v.get(391)).setAttribute("width","25" );
      ((Element)v.get(391)).setAttribute("height","8" );
      ((Element)v.get(390)).appendChild((Element)v.get(391));
      /* Termina nodo:391   */
      /* Termina nodo:390   */

      /* Empieza nodo:392 / Elemento padre: 385   */
      v.add(doc.createElement("td"));
      ((Element)v.get(385)).appendChild((Element)v.get(392));

      /* Empieza nodo:393 / Elemento padre: 392   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(393)).setAttribute("nombre","lblPeriodoFinalEvaluaciondt" );
      ((Element)v.get(393)).setAttribute("alto","13" );
      ((Element)v.get(393)).setAttribute("filas","1" );
      ((Element)v.get(393)).setAttribute("valor","" );
      ((Element)v.get(393)).setAttribute("id","datosCampos" );
      ((Element)v.get(392)).appendChild((Element)v.get(393));
      /* Termina nodo:393   */
      /* Termina nodo:392   */

      /* Empieza nodo:394 / Elemento padre: 385   */
      v.add(doc.createElement("td"));
      ((Element)v.get(385)).appendChild((Element)v.get(394));

      /* Empieza nodo:395 / Elemento padre: 394   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(395)).setAttribute("src","b.gif" );
      ((Element)v.get(395)).setAttribute("width","25" );
      ((Element)v.get(395)).setAttribute("height","8" );
      ((Element)v.get(394)).appendChild((Element)v.get(395));
      /* Termina nodo:395   */
      /* Termina nodo:394   */

      /* Empieza nodo:396 / Elemento padre: 385   */
      v.add(doc.createElement("td"));
      ((Element)v.get(396)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(396)).setAttribute("class","datosCampos" );
      ((Element)v.get(385)).appendChild((Element)v.get(396));

      /* Empieza nodo:397 / Elemento padre: 396   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(397)).setAttribute("nombre","txtPorcentajeIncremento" );
      ((Element)v.get(397)).setAttribute("id","datosCampos" );
      ((Element)v.get(397)).setAttribute("max","6" );
      ((Element)v.get(397)).setAttribute("tipo","" );
      ((Element)v.get(397)).setAttribute("onchange","" );
      ((Element)v.get(397)).setAttribute("req","N" );
      ((Element)v.get(397)).setAttribute("size","6" );
      ((Element)v.get(397)).setAttribute("valor","" );
      ((Element)v.get(397)).setAttribute("validacion","" );
      ((Element)v.get(396)).appendChild((Element)v.get(397));
      /* Termina nodo:397   */
      /* Termina nodo:396   */

      /* Empieza nodo:398 / Elemento padre: 385   */
      v.add(doc.createElement("td"));
      ((Element)v.get(385)).appendChild((Element)v.get(398));

      /* Empieza nodo:399 / Elemento padre: 398   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(399)).setAttribute("src","b.gif" );
      ((Element)v.get(399)).setAttribute("width","25" );
      ((Element)v.get(399)).setAttribute("height","8" );
      ((Element)v.get(398)).appendChild((Element)v.get(399));
      /* Termina nodo:399   */
      /* Termina nodo:398   */

      /* Empieza nodo:400 / Elemento padre: 385   */
      v.add(doc.createElement("td"));
      ((Element)v.get(400)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(385)).appendChild((Element)v.get(400));

      /* Empieza nodo:401 / Elemento padre: 400   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(401)).setAttribute("nombre","txtMonto" );
      ((Element)v.get(401)).setAttribute("id","datosCampos" );
      ((Element)v.get(401)).setAttribute("max","16" );
      ((Element)v.get(401)).setAttribute("tipo","" );
      ((Element)v.get(401)).setAttribute("onchange","" );
      ((Element)v.get(401)).setAttribute("req","N" );
      ((Element)v.get(401)).setAttribute("size","19" );
      ((Element)v.get(401)).setAttribute("valor","" );
      ((Element)v.get(401)).setAttribute("validacion","" );
      ((Element)v.get(400)).appendChild((Element)v.get(401));
      /* Termina nodo:401   */
      /* Termina nodo:400   */

      /* Empieza nodo:402 / Elemento padre: 385   */
      v.add(doc.createElement("td"));
      ((Element)v.get(402)).setAttribute("width","100%" );
      ((Element)v.get(385)).appendChild((Element)v.get(402));

      /* Empieza nodo:403 / Elemento padre: 402   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(403)).setAttribute("src","b.gif" );
      ((Element)v.get(403)).setAttribute("width","8" );
      ((Element)v.get(403)).setAttribute("height","8" );
      ((Element)v.get(402)).appendChild((Element)v.get(403));
      /* Termina nodo:403   */
      /* Termina nodo:402   */
      /* Termina nodo:385   */

      /* Empieza nodo:404 / Elemento padre: 362   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(362)).appendChild((Element)v.get(404));

      /* Empieza nodo:405 / Elemento padre: 404   */
      v.add(doc.createElement("td"));
      ((Element)v.get(405)).setAttribute("colspan","4" );
      ((Element)v.get(404)).appendChild((Element)v.get(405));

      /* Empieza nodo:406 / Elemento padre: 405   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(406)).setAttribute("src","b.gif" );
      ((Element)v.get(406)).setAttribute("width","8" );
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(406)).setAttribute("height","8" );
      ((Element)v.get(405)).appendChild((Element)v.get(406));
      /* Termina nodo:406   */
      /* Termina nodo:405   */
      /* Termina nodo:404   */
      /* Termina nodo:362   */
      /* Termina nodo:361   */
      /* Termina nodo:360   */

      /* Empieza nodo:407 / Elemento padre: 359   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(359)).appendChild((Element)v.get(407));

      /* Empieza nodo:408 / Elemento padre: 407   */
      v.add(doc.createElement("td"));
      ((Element)v.get(407)).appendChild((Element)v.get(408));

      /* Empieza nodo:409 / Elemento padre: 408   */
      v.add(doc.createElement("table"));
      ((Element)v.get(409)).setAttribute("width","643" );
      ((Element)v.get(409)).setAttribute("border","0" );
      ((Element)v.get(409)).setAttribute("align","left" );
      ((Element)v.get(409)).setAttribute("cellspacing","0" );
      ((Element)v.get(409)).setAttribute("cellpadding","0" );
      ((Element)v.get(408)).appendChild((Element)v.get(409));

      /* Empieza nodo:410 / Elemento padre: 409   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(409)).appendChild((Element)v.get(410));

      /* Empieza nodo:411 / Elemento padre: 410   */
      v.add(doc.createElement("td"));
      ((Element)v.get(411)).setAttribute("colspan","3" );
      ((Element)v.get(410)).appendChild((Element)v.get(411));

      /* Empieza nodo:412 / Elemento padre: 411   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(412)).setAttribute("src","b.gif" );
      ((Element)v.get(412)).setAttribute("width","8" );
      ((Element)v.get(412)).setAttribute("height","8" );
      ((Element)v.get(411)).appendChild((Element)v.get(412));
      /* Termina nodo:412   */
      /* Termina nodo:411   */
      /* Termina nodo:410   */

      /* Empieza nodo:413 / Elemento padre: 409   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(409)).appendChild((Element)v.get(413));

      /* Empieza nodo:414 / Elemento padre: 413   */
      v.add(doc.createElement("td"));
      ((Element)v.get(413)).appendChild((Element)v.get(414));

      /* Empieza nodo:415 / Elemento padre: 414   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(415)).setAttribute("src","b.gif" );
      ((Element)v.get(415)).setAttribute("width","8" );
      ((Element)v.get(415)).setAttribute("height","8" );
      ((Element)v.get(414)).appendChild((Element)v.get(415));
      /* Termina nodo:415   */
      /* Termina nodo:414   */

      /* Empieza nodo:416 / Elemento padre: 413   */
      v.add(doc.createElement("td"));
      ((Element)v.get(413)).appendChild((Element)v.get(416));

      /* Empieza nodo:417 / Elemento padre: 416   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(417)).setAttribute("nombre","lblDevolucionesMetas" );
      ((Element)v.get(417)).setAttribute("alto","13" );
      ((Element)v.get(417)).setAttribute("filas","1" );
      ((Element)v.get(417)).setAttribute("valor","" );
      ((Element)v.get(417)).setAttribute("id","datosTitle" );
      ((Element)v.get(417)).setAttribute("cod","1742" );
      ((Element)v.get(416)).appendChild((Element)v.get(417));
      /* Termina nodo:417   */
      /* Termina nodo:416   */

      /* Empieza nodo:418 / Elemento padre: 413   */
      v.add(doc.createElement("td"));
      ((Element)v.get(413)).appendChild((Element)v.get(418));

      /* Empieza nodo:419 / Elemento padre: 418   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(419)).setAttribute("src","b.gif" );
      ((Element)v.get(419)).setAttribute("width","25" );
      ((Element)v.get(419)).setAttribute("height","8" );
      ((Element)v.get(418)).appendChild((Element)v.get(419));
      /* Termina nodo:419   */
      /* Termina nodo:418   */

      /* Empieza nodo:420 / Elemento padre: 413   */
      v.add(doc.createElement("td"));
      ((Element)v.get(413)).appendChild((Element)v.get(420));

      /* Empieza nodo:421 / Elemento padre: 420   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(421)).setAttribute("nombre","lblAnulacionesMetas" );
      ((Element)v.get(421)).setAttribute("alto","13" );
      ((Element)v.get(421)).setAttribute("filas","1" );
      ((Element)v.get(421)).setAttribute("valor","" );
      ((Element)v.get(421)).setAttribute("id","datosTitle" );
      ((Element)v.get(421)).setAttribute("cod","1743" );
      ((Element)v.get(420)).appendChild((Element)v.get(421));
      /* Termina nodo:421   */
      /* Termina nodo:420   */

      /* Empieza nodo:422 / Elemento padre: 413   */
      v.add(doc.createElement("td"));
      ((Element)v.get(422)).setAttribute("width","100%" );
      ((Element)v.get(413)).appendChild((Element)v.get(422));

      /* Empieza nodo:423 / Elemento padre: 422   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(423)).setAttribute("src","b.gif" );
      ((Element)v.get(423)).setAttribute("width","8" );
      ((Element)v.get(423)).setAttribute("height","8" );
      ((Element)v.get(422)).appendChild((Element)v.get(423));
      /* Termina nodo:423   */
      /* Termina nodo:422   */
      /* Termina nodo:413   */

      /* Empieza nodo:424 / Elemento padre: 409   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(409)).appendChild((Element)v.get(424));

      /* Empieza nodo:425 / Elemento padre: 424   */
      v.add(doc.createElement("td"));
      ((Element)v.get(424)).appendChild((Element)v.get(425));

      /* Empieza nodo:426 / Elemento padre: 425   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(426)).setAttribute("src","b.gif" );
      ((Element)v.get(426)).setAttribute("width","8" );
      ((Element)v.get(426)).setAttribute("height","8" );
      ((Element)v.get(425)).appendChild((Element)v.get(426));
      /* Termina nodo:426   */
      /* Termina nodo:425   */

      /* Empieza nodo:427 / Elemento padre: 424   */
      v.add(doc.createElement("td"));
      ((Element)v.get(424)).appendChild((Element)v.get(427));

      /* Empieza nodo:428 / Elemento padre: 427   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(428)).setAttribute("nombre","ckDevolucionesMetas" );
      ((Element)v.get(428)).setAttribute("id","datosCampos" );
      ((Element)v.get(428)).setAttribute("onclick","" );
      ((Element)v.get(428)).setAttribute("check","N" );
      ((Element)v.get(427)).appendChild((Element)v.get(428));
      /* Termina nodo:428   */
      /* Termina nodo:427   */

      /* Empieza nodo:429 / Elemento padre: 424   */
      v.add(doc.createElement("td"));
      ((Element)v.get(424)).appendChild((Element)v.get(429));

      /* Empieza nodo:430 / Elemento padre: 429   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(430)).setAttribute("src","b.gif" );
      ((Element)v.get(430)).setAttribute("width","25" );
      ((Element)v.get(430)).setAttribute("height","8" );
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(429)).appendChild((Element)v.get(430));
      /* Termina nodo:430   */
      /* Termina nodo:429   */

      /* Empieza nodo:431 / Elemento padre: 424   */
      v.add(doc.createElement("td"));
      ((Element)v.get(424)).appendChild((Element)v.get(431));

      /* Empieza nodo:432 / Elemento padre: 431   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(432)).setAttribute("nombre","ckAnulacionesMetas" );
      ((Element)v.get(432)).setAttribute("id","datosCampos" );
      ((Element)v.get(432)).setAttribute("onclick","" );
      ((Element)v.get(432)).setAttribute("check","N" );
      ((Element)v.get(431)).appendChild((Element)v.get(432));
      /* Termina nodo:432   */
      /* Termina nodo:431   */

      /* Empieza nodo:433 / Elemento padre: 424   */
      v.add(doc.createElement("td"));
      ((Element)v.get(433)).setAttribute("width","100%" );
      ((Element)v.get(424)).appendChild((Element)v.get(433));

      /* Empieza nodo:434 / Elemento padre: 433   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(434)).setAttribute("src","b.gif" );
      ((Element)v.get(434)).setAttribute("width","8" );
      ((Element)v.get(434)).setAttribute("height","8" );
      ((Element)v.get(433)).appendChild((Element)v.get(434));
      /* Termina nodo:434   */
      /* Termina nodo:433   */
      /* Termina nodo:424   */

      /* Empieza nodo:435 / Elemento padre: 409   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(409)).appendChild((Element)v.get(435));

      /* Empieza nodo:436 / Elemento padre: 435   */
      v.add(doc.createElement("td"));
      ((Element)v.get(436)).setAttribute("colspan","4" );
      ((Element)v.get(435)).appendChild((Element)v.get(436));

      /* Empieza nodo:437 / Elemento padre: 436   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(437)).setAttribute("src","b.gif" );
      ((Element)v.get(437)).setAttribute("width","8" );
      ((Element)v.get(437)).setAttribute("height","8" );
      ((Element)v.get(436)).appendChild((Element)v.get(437));
      /* Termina nodo:437   */
      /* Termina nodo:436   */
      /* Termina nodo:435   */
      /* Termina nodo:409   */
      /* Termina nodo:408   */
      /* Termina nodo:407   */
      /* Termina nodo:359   */
      /* Termina nodo:356   */
      /* Termina nodo:355   */
      /* Termina nodo:354   */
      /* Termina nodo:353   */
      /* Termina nodo:352   */

      /* Empieza nodo:438 / Elemento padre: 349   */
      v.add(doc.createElement("td"));
      ((Element)v.get(349)).appendChild((Element)v.get(438));

      /* Empieza nodo:439 / Elemento padre: 438   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(439)).setAttribute("src","b.gif" );
      ((Element)v.get(439)).setAttribute("width","8" );
      ((Element)v.get(439)).setAttribute("height","8" );
      ((Element)v.get(438)).appendChild((Element)v.get(439));
      /* Termina nodo:439   */
      /* Termina nodo:438   */
      /* Termina nodo:349   */

      /* Empieza nodo:440 / Elemento padre: 348   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(348)).appendChild((Element)v.get(440));

      /* Empieza nodo:441 / Elemento padre: 440   */
      v.add(doc.createElement("td"));
      ((Element)v.get(441)).setAttribute("colspan","4" );
      ((Element)v.get(440)).appendChild((Element)v.get(441));

      /* Empieza nodo:442 / Elemento padre: 441   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(442)).setAttribute("src","b.gif" );
      ((Element)v.get(442)).setAttribute("width","8" );
      ((Element)v.get(442)).setAttribute("height","15" );
      ((Element)v.get(441)).appendChild((Element)v.get(442));
      /* Termina nodo:442   */
      /* Termina nodo:441   */
      /* Termina nodo:440   */
      /* Termina nodo:348   */
      /* Termina nodo:347   */
      /* Termina nodo:346   */
      /* Termina nodo:210   */
      /* Termina nodo:207   */
      /* Termina nodo:206   */

      /* Empieza nodo:443 / Elemento padre: 203   */
      v.add(doc.createElement("td"));
      ((Element)v.get(203)).appendChild((Element)v.get(443));

      /* Empieza nodo:444 / Elemento padre: 443   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(444)).setAttribute("src","b.gif" );
      ((Element)v.get(443)).appendChild((Element)v.get(444));
      /* Termina nodo:444   */
      /* Termina nodo:443   */
      /* Termina nodo:203   */

      /* Empieza nodo:445 / Elemento padre: 195   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(195)).appendChild((Element)v.get(445));

      /* Empieza nodo:446 / Elemento padre: 445   */
      v.add(doc.createElement("td"));
      ((Element)v.get(446)).setAttribute("width","12" );
      ((Element)v.get(446)).setAttribute("align","center" );
      ((Element)v.get(445)).appendChild((Element)v.get(446));

      /* Empieza nodo:447 / Elemento padre: 446   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(447)).setAttribute("src","b.gif" );
      ((Element)v.get(447)).setAttribute("width","12" );
      ((Element)v.get(447)).setAttribute("height","12" );
      ((Element)v.get(446)).appendChild((Element)v.get(447));
      /* Termina nodo:447   */
      /* Termina nodo:446   */

      /* Empieza nodo:448 / Elemento padre: 445   */
      v.add(doc.createElement("td"));
      ((Element)v.get(448)).setAttribute("width","750" );
      ((Element)v.get(445)).appendChild((Element)v.get(448));

      /* Empieza nodo:449 / Elemento padre: 448   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(449)).setAttribute("src","b.gif" );
      ((Element)v.get(448)).appendChild((Element)v.get(449));
      /* Termina nodo:449   */
      /* Termina nodo:448   */

      /* Empieza nodo:450 / Elemento padre: 445   */
      v.add(doc.createElement("td"));
      ((Element)v.get(450)).setAttribute("width","12" );
      ((Element)v.get(445)).appendChild((Element)v.get(450));

      /* Empieza nodo:451 / Elemento padre: 450   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(451)).setAttribute("src","b.gif" );
      ((Element)v.get(451)).setAttribute("width","12" );
      ((Element)v.get(451)).setAttribute("height","1" );
      ((Element)v.get(450)).appendChild((Element)v.get(451));
      /* Termina nodo:451   */
      /* Termina nodo:450   */
      /* Termina nodo:445   */
      /* Termina nodo:195   */
      /* Termina nodo:194   */

      /* Empieza nodo:452 / Elemento padre: 18   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(452)).setAttribute("nombre","capa3" );
      ((Element)v.get(452)).setAttribute("alto","120" );
      ((Element)v.get(452)).setAttribute("ancho","100%" );
      ((Element)v.get(452)).setAttribute("colorf","" );
      ((Element)v.get(452)).setAttribute("borde","0" );
      ((Element)v.get(452)).setAttribute("imagenf","" );
      ((Element)v.get(452)).setAttribute("repeat","" );
      ((Element)v.get(452)).setAttribute("padding","" );
      ((Element)v.get(452)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(452)).setAttribute("contravsb","" );
      ((Element)v.get(452)).setAttribute("x","0" );
      ((Element)v.get(452)).setAttribute("y","452" );
      ((Element)v.get(452)).setAttribute("zindex","" );
      ((Element)v.get(18)).appendChild((Element)v.get(452));

      /* Empieza nodo:453 / Elemento padre: 452   */
      v.add(doc.createElement("table"));
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(453)).setAttribute("width","100%" );
      ((Element)v.get(453)).setAttribute("border","0" );
      ((Element)v.get(453)).setAttribute("cellspacing","0" );
      ((Element)v.get(453)).setAttribute("cellpadding","0" );
      ((Element)v.get(452)).appendChild((Element)v.get(453));

      /* Empieza nodo:454 / Elemento padre: 453   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(453)).appendChild((Element)v.get(454));

      /* Empieza nodo:455 / Elemento padre: 454   */
      v.add(doc.createElement("td"));
      ((Element)v.get(455)).setAttribute("width","12" );
      ((Element)v.get(455)).setAttribute("align","center" );
      ((Element)v.get(454)).appendChild((Element)v.get(455));

      /* Empieza nodo:456 / Elemento padre: 455   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(456)).setAttribute("src","b.gif" );
      ((Element)v.get(456)).setAttribute("width","12" );
      ((Element)v.get(456)).setAttribute("height","12" );
      ((Element)v.get(455)).appendChild((Element)v.get(456));
      /* Termina nodo:456   */
      /* Termina nodo:455   */

      /* Empieza nodo:457 / Elemento padre: 454   */
      v.add(doc.createElement("td"));
      ((Element)v.get(457)).setAttribute("width","750" );
      ((Element)v.get(454)).appendChild((Element)v.get(457));

      /* Empieza nodo:458 / Elemento padre: 457   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(458)).setAttribute("src","b.gif" );
      ((Element)v.get(457)).appendChild((Element)v.get(458));
      /* Termina nodo:458   */
      /* Termina nodo:457   */

      /* Empieza nodo:459 / Elemento padre: 454   */
      v.add(doc.createElement("td"));
      ((Element)v.get(459)).setAttribute("width","12" );
      ((Element)v.get(454)).appendChild((Element)v.get(459));

      /* Empieza nodo:460 / Elemento padre: 459   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(460)).setAttribute("src","b.gif" );
      ((Element)v.get(460)).setAttribute("width","12" );
      ((Element)v.get(460)).setAttribute("height","1" );
      ((Element)v.get(459)).appendChild((Element)v.get(460));
      /* Termina nodo:460   */
      /* Termina nodo:459   */
      /* Termina nodo:454   */

      /* Empieza nodo:461 / Elemento padre: 453   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(453)).appendChild((Element)v.get(461));

      /* Empieza nodo:462 / Elemento padre: 461   */
      v.add(doc.createElement("td"));
      ((Element)v.get(461)).appendChild((Element)v.get(462));

      /* Empieza nodo:463 / Elemento padre: 462   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(463)).setAttribute("src","b.gif" );
      ((Element)v.get(462)).appendChild((Element)v.get(463));
      /* Termina nodo:463   */
      /* Termina nodo:462   */

      /* Empieza nodo:464 / Elemento padre: 461   */
      v.add(doc.createElement("td"));
      ((Element)v.get(461)).appendChild((Element)v.get(464));

      /* Empieza nodo:465 / Elemento padre: 464   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(464)).appendChild((Element)v.get(465));

      /* Empieza nodo:466 / Elemento padre: 465   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(466)).setAttribute("class","legend" );
      ((Element)v.get(465)).appendChild((Element)v.get(466));

      /* Empieza nodo:467 / Elemento padre: 466   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(467)).setAttribute("nombre","lblDatosModificacion3" );
      ((Element)v.get(467)).setAttribute("alto","13" );
      ((Element)v.get(467)).setAttribute("filas","1" );
      ((Element)v.get(467)).setAttribute("valor","" );
      ((Element)v.get(467)).setAttribute("id","legend" );
      ((Element)v.get(467)).setAttribute("cod","00547" );
      ((Element)v.get(466)).appendChild((Element)v.get(467));
      /* Termina nodo:467   */
      /* Termina nodo:466   */

      /* Empieza nodo:468 / Elemento padre: 465   */
      v.add(doc.createElement("table"));
      ((Element)v.get(468)).setAttribute("width","100%" );
      ((Element)v.get(468)).setAttribute("border","0" );
      ((Element)v.get(468)).setAttribute("align","center" );
      ((Element)v.get(468)).setAttribute("cellspacing","0" );
      ((Element)v.get(468)).setAttribute("cellpadding","0" );
      ((Element)v.get(465)).appendChild((Element)v.get(468));

      /* Empieza nodo:469 / Elemento padre: 468   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(468)).appendChild((Element)v.get(469));

      /* Empieza nodo:470 / Elemento padre: 469   */
      v.add(doc.createElement("td"));
      ((Element)v.get(469)).appendChild((Element)v.get(470));

      /* Empieza nodo:471 / Elemento padre: 470   */
      v.add(doc.createElement("table"));
      ((Element)v.get(471)).setAttribute("width","663" );
      ((Element)v.get(471)).setAttribute("border","0" );
      ((Element)v.get(471)).setAttribute("align","left" );
      ((Element)v.get(471)).setAttribute("cellspacing","0" );
      ((Element)v.get(471)).setAttribute("cellpadding","0" );
      ((Element)v.get(470)).appendChild((Element)v.get(471));

      /* Empieza nodo:472 / Elemento padre: 471   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(471)).appendChild((Element)v.get(472));

      /* Empieza nodo:473 / Elemento padre: 472   */
      v.add(doc.createElement("td"));
      ((Element)v.get(473)).setAttribute("colspan","4" );
      ((Element)v.get(472)).appendChild((Element)v.get(473));

      /* Empieza nodo:474 / Elemento padre: 473   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(474)).setAttribute("src","b.gif" );
      ((Element)v.get(474)).setAttribute("width","8" );
      ((Element)v.get(474)).setAttribute("height","8" );
      ((Element)v.get(473)).appendChild((Element)v.get(474));
      /* Termina nodo:474   */
      /* Termina nodo:473   */
      /* Termina nodo:472   */

      /* Empieza nodo:475 / Elemento padre: 471   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(471)).appendChild((Element)v.get(475));

      /* Empieza nodo:476 / Elemento padre: 475   */
      v.add(doc.createElement("td"));
      ((Element)v.get(475)).appendChild((Element)v.get(476));

      /* Empieza nodo:477 / Elemento padre: 476   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(477)).setAttribute("src","b.gif" );
      ((Element)v.get(477)).setAttribute("width","8" );
      ((Element)v.get(477)).setAttribute("height","8" );
      ((Element)v.get(476)).appendChild((Element)v.get(477));
      /* Termina nodo:477   */
      /* Termina nodo:476   */

      /* Empieza nodo:478 / Elemento padre: 475   */
      v.add(doc.createElement("td"));
   }

   private void getXML1980(Document doc) {
      ((Element)v.get(475)).appendChild((Element)v.get(478));

      /* Empieza nodo:479 / Elemento padre: 478   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(479)).setAttribute("nombre","lblPeriodoEntradaVigor3" );
      ((Element)v.get(479)).setAttribute("alto","13" );
      ((Element)v.get(479)).setAttribute("filas","1" );
      ((Element)v.get(479)).setAttribute("valor","" );
      ((Element)v.get(479)).setAttribute("id","datosTitle" );
      ((Element)v.get(479)).setAttribute("cod","1735" );
      ((Element)v.get(478)).appendChild((Element)v.get(479));
      /* Termina nodo:479   */
      /* Termina nodo:478   */

      /* Empieza nodo:480 / Elemento padre: 475   */
      v.add(doc.createElement("td"));
      ((Element)v.get(475)).appendChild((Element)v.get(480));

      /* Empieza nodo:481 / Elemento padre: 480   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(481)).setAttribute("src","b.gif" );
      ((Element)v.get(481)).setAttribute("width","25" );
      ((Element)v.get(481)).setAttribute("height","8" );
      ((Element)v.get(480)).appendChild((Element)v.get(481));
      /* Termina nodo:481   */
      /* Termina nodo:480   */

      /* Empieza nodo:482 / Elemento padre: 475   */
      v.add(doc.createElement("td"));
      ((Element)v.get(475)).appendChild((Element)v.get(482));

      /* Empieza nodo:483 / Elemento padre: 482   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(483)).setAttribute("nombre","lblObservaciones3" );
      ((Element)v.get(483)).setAttribute("alto","13" );
      ((Element)v.get(483)).setAttribute("filas","1" );
      ((Element)v.get(483)).setAttribute("valor","" );
      ((Element)v.get(483)).setAttribute("id","datosTitle" );
      ((Element)v.get(483)).setAttribute("cod","169" );
      ((Element)v.get(482)).appendChild((Element)v.get(483));
      /* Termina nodo:483   */
      /* Termina nodo:482   */

      /* Empieza nodo:484 / Elemento padre: 475   */
      v.add(doc.createElement("td"));
      ((Element)v.get(484)).setAttribute("width","100%" );
      ((Element)v.get(475)).appendChild((Element)v.get(484));

      /* Empieza nodo:485 / Elemento padre: 484   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(485)).setAttribute("src","b.gif" );
      ((Element)v.get(485)).setAttribute("width","8" );
      ((Element)v.get(485)).setAttribute("height","8" );
      ((Element)v.get(484)).appendChild((Element)v.get(485));
      /* Termina nodo:485   */
      /* Termina nodo:484   */
      /* Termina nodo:475   */

      /* Empieza nodo:486 / Elemento padre: 471   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(471)).appendChild((Element)v.get(486));

      /* Empieza nodo:487 / Elemento padre: 486   */
      v.add(doc.createElement("td"));
      ((Element)v.get(486)).appendChild((Element)v.get(487));

      /* Empieza nodo:488 / Elemento padre: 487   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(488)).setAttribute("src","b.gif" );
      ((Element)v.get(488)).setAttribute("width","8" );
      ((Element)v.get(488)).setAttribute("height","8" );
      ((Element)v.get(487)).appendChild((Element)v.get(488));
      /* Termina nodo:488   */
      /* Termina nodo:487   */

      /* Empieza nodo:489 / Elemento padre: 486   */
      v.add(doc.createElement("td"));
      ((Element)v.get(489)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(489)).setAttribute("valign","top" );
      ((Element)v.get(486)).appendChild((Element)v.get(489));

      /* Empieza nodo:490 / Elemento padre: 489   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(490)).setAttribute("nombre","cbPeriodoEntradaVigor3" );
      ((Element)v.get(490)).setAttribute("id","datosCampos" );
      ((Element)v.get(490)).setAttribute("size","1" );
      ((Element)v.get(490)).setAttribute("multiple","N" );
      ((Element)v.get(490)).setAttribute("req","N" );
      ((Element)v.get(490)).setAttribute("valorinicial","" );
      ((Element)v.get(490)).setAttribute("textoinicial","" );
      ((Element)v.get(489)).appendChild((Element)v.get(490));

      /* Empieza nodo:491 / Elemento padre: 490   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(490)).appendChild((Element)v.get(491));
      /* Termina nodo:491   */
      /* Termina nodo:490   */
      /* Termina nodo:489   */

      /* Empieza nodo:492 / Elemento padre: 486   */
      v.add(doc.createElement("td"));
      ((Element)v.get(486)).appendChild((Element)v.get(492));

      /* Empieza nodo:493 / Elemento padre: 492   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(493)).setAttribute("src","b.gif" );
      ((Element)v.get(493)).setAttribute("width","25" );
      ((Element)v.get(493)).setAttribute("height","8" );
      ((Element)v.get(492)).appendChild((Element)v.get(493));
      /* Termina nodo:493   */
      /* Termina nodo:492   */

      /* Empieza nodo:494 / Elemento padre: 486   */
      v.add(doc.createElement("td"));
      ((Element)v.get(494)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(486)).appendChild((Element)v.get(494));

      /* Empieza nodo:495 / Elemento padre: 494   */
      v.add(doc.createElement("AREATEXTO"));
      ((Element)v.get(495)).setAttribute("cols","50" );
      ((Element)v.get(495)).setAttribute("id","datosCampos" );
      ((Element)v.get(495)).setAttribute("msjreq","" );
      ((Element)v.get(495)).setAttribute("nombre","atxtObservaciones3" );
      ((Element)v.get(495)).setAttribute("readonly","N" );
      ((Element)v.get(495)).setAttribute("req","N" );
      ((Element)v.get(495)).setAttribute("rows","3" );
      ((Element)v.get(495)).setAttribute("tabindex","2" );
      ((Element)v.get(495)).setAttribute("valor","" );
      ((Element)v.get(495)).setAttribute("max","125" );
      ((Element)v.get(495)).setAttribute("ontab","focoComboTipoComision();" );
      ((Element)v.get(494)).appendChild((Element)v.get(495));
      /* Termina nodo:495   */
      /* Termina nodo:494   */

      /* Empieza nodo:496 / Elemento padre: 486   */
      v.add(doc.createElement("td"));
      ((Element)v.get(496)).setAttribute("width","100%" );
      ((Element)v.get(486)).appendChild((Element)v.get(496));

      /* Empieza nodo:497 / Elemento padre: 496   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(497)).setAttribute("src","b.gif" );
      ((Element)v.get(497)).setAttribute("width","8" );
      ((Element)v.get(497)).setAttribute("height","8" );
      ((Element)v.get(496)).appendChild((Element)v.get(497));
      /* Termina nodo:497   */
      /* Termina nodo:496   */
      /* Termina nodo:486   */

      /* Empieza nodo:498 / Elemento padre: 471   */
      v.add(doc.createElement("tr"));
   }

   private void getXML2070(Document doc) {
      ((Element)v.get(471)).appendChild((Element)v.get(498));

      /* Empieza nodo:499 / Elemento padre: 498   */
      v.add(doc.createElement("td"));
      ((Element)v.get(499)).setAttribute("colspan","4" );
      ((Element)v.get(498)).appendChild((Element)v.get(499));

      /* Empieza nodo:500 / Elemento padre: 499   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(500)).setAttribute("src","b.gif" );
      ((Element)v.get(500)).setAttribute("width","8" );
      ((Element)v.get(500)).setAttribute("height","8" );
      ((Element)v.get(499)).appendChild((Element)v.get(500));
      /* Termina nodo:500   */
      /* Termina nodo:499   */
      /* Termina nodo:498   */
      /* Termina nodo:471   */
      /* Termina nodo:470   */
      /* Termina nodo:469   */
      /* Termina nodo:468   */
      /* Termina nodo:465   */
      /* Termina nodo:464   */

      /* Empieza nodo:501 / Elemento padre: 461   */
      v.add(doc.createElement("td"));
      ((Element)v.get(461)).appendChild((Element)v.get(501));

      /* Empieza nodo:502 / Elemento padre: 501   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(502)).setAttribute("src","b.gif" );
      ((Element)v.get(501)).appendChild((Element)v.get(502));
      /* Termina nodo:502   */
      /* Termina nodo:501   */
      /* Termina nodo:461   */

      /* Empieza nodo:503 / Elemento padre: 453   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(453)).appendChild((Element)v.get(503));

      /* Empieza nodo:504 / Elemento padre: 503   */
      v.add(doc.createElement("td"));
      ((Element)v.get(504)).setAttribute("width","12" );
      ((Element)v.get(504)).setAttribute("align","center" );
      ((Element)v.get(503)).appendChild((Element)v.get(504));

      /* Empieza nodo:505 / Elemento padre: 504   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(505)).setAttribute("src","b.gif" );
      ((Element)v.get(505)).setAttribute("width","12" );
      ((Element)v.get(505)).setAttribute("height","12" );
      ((Element)v.get(504)).appendChild((Element)v.get(505));
      /* Termina nodo:505   */
      /* Termina nodo:504   */

      /* Empieza nodo:506 / Elemento padre: 503   */
      v.add(doc.createElement("td"));
      ((Element)v.get(506)).setAttribute("width","750" );
      ((Element)v.get(503)).appendChild((Element)v.get(506));

      /* Empieza nodo:507 / Elemento padre: 506   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(507)).setAttribute("src","b.gif" );
      ((Element)v.get(506)).appendChild((Element)v.get(507));
      /* Termina nodo:507   */
      /* Termina nodo:506   */

      /* Empieza nodo:508 / Elemento padre: 503   */
      v.add(doc.createElement("td"));
      ((Element)v.get(508)).setAttribute("width","12" );
      ((Element)v.get(503)).appendChild((Element)v.get(508));

      /* Empieza nodo:509 / Elemento padre: 508   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(509)).setAttribute("src","b.gif" );
      ((Element)v.get(509)).setAttribute("width","12" );
      ((Element)v.get(509)).setAttribute("height","1" );
      ((Element)v.get(508)).appendChild((Element)v.get(509));
      /* Termina nodo:509   */
      /* Termina nodo:508   */
      /* Termina nodo:503   */
      /* Termina nodo:453   */
      /* Termina nodo:452   */

      /* Empieza nodo:510 / Elemento padre: 18   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(510)).setAttribute("nombre","capa4" );
      ((Element)v.get(510)).setAttribute("alto","200" );
      ((Element)v.get(510)).setAttribute("ancho","100%" );
      ((Element)v.get(510)).setAttribute("colorf","" );
      ((Element)v.get(510)).setAttribute("borde","0" );
      ((Element)v.get(510)).setAttribute("imagenf","" );
      ((Element)v.get(510)).setAttribute("repeat","" );
      ((Element)v.get(510)).setAttribute("padding","" );
      ((Element)v.get(510)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(510)).setAttribute("contravsb","" );
      ((Element)v.get(510)).setAttribute("x","0" );
      ((Element)v.get(510)).setAttribute("y","157" );
      ((Element)v.get(510)).setAttribute("zindex","" );
      ((Element)v.get(18)).appendChild((Element)v.get(510));

      /* Empieza nodo:511 / Elemento padre: 510   */
      v.add(doc.createElement("table"));
      ((Element)v.get(511)).setAttribute("width","100%" );
      ((Element)v.get(511)).setAttribute("border","0" );
      ((Element)v.get(511)).setAttribute("cellspacing","0" );
      ((Element)v.get(511)).setAttribute("cellpadding","0" );
      ((Element)v.get(510)).appendChild((Element)v.get(511));

      /* Empieza nodo:512 / Elemento padre: 511   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(511)).appendChild((Element)v.get(512));

      /* Empieza nodo:513 / Elemento padre: 512   */
      v.add(doc.createElement("td"));
      ((Element)v.get(512)).appendChild((Element)v.get(513));

      /* Empieza nodo:514 / Elemento padre: 513   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(514)).setAttribute("src","b.gif" );
      ((Element)v.get(514)).setAttribute("width","12" );
      ((Element)v.get(514)).setAttribute("height","12" );
      ((Element)v.get(513)).appendChild((Element)v.get(514));
      /* Termina nodo:514   */
      /* Termina nodo:513   */

      /* Empieza nodo:515 / Elemento padre: 512   */
      v.add(doc.createElement("td"));
      ((Element)v.get(515)).setAttribute("width","750" );
      ((Element)v.get(512)).appendChild((Element)v.get(515));

      /* Empieza nodo:516 / Elemento padre: 515   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(516)).setAttribute("src","b.gif" );
      ((Element)v.get(516)).setAttribute("width","1" );
      ((Element)v.get(516)).setAttribute("height","1" );
      ((Element)v.get(515)).appendChild((Element)v.get(516));
      /* Termina nodo:516   */
      /* Termina nodo:515   */

      /* Empieza nodo:517 / Elemento padre: 512   */
      v.add(doc.createElement("td"));
      ((Element)v.get(512)).appendChild((Element)v.get(517));

      /* Empieza nodo:518 / Elemento padre: 517   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(518)).setAttribute("src","b.gif" );
      ((Element)v.get(518)).setAttribute("width","12" );
      ((Element)v.get(518)).setAttribute("height","12" );
      ((Element)v.get(517)).appendChild((Element)v.get(518));
      /* Termina nodo:518   */
      /* Termina nodo:517   */
      /* Termina nodo:512   */

      /* Empieza nodo:519 / Elemento padre: 511   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(511)).appendChild((Element)v.get(519));

      /* Empieza nodo:520 / Elemento padre: 519   */
      v.add(doc.createElement("td"));
      ((Element)v.get(520)).setAttribute("width","12" );
      ((Element)v.get(519)).appendChild((Element)v.get(520));

      /* Empieza nodo:521 / Elemento padre: 520   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML2160(Document doc) {
      ((Element)v.get(521)).setAttribute("src","b.gif" );
      ((Element)v.get(521)).setAttribute("width","12" );
      ((Element)v.get(521)).setAttribute("height","12" );
      ((Element)v.get(520)).appendChild((Element)v.get(521));
      /* Termina nodo:521   */
      /* Termina nodo:520   */

      /* Empieza nodo:522 / Elemento padre: 519   */
      v.add(doc.createElement("td"));
      ((Element)v.get(519)).appendChild((Element)v.get(522));

      /* Empieza nodo:523 / Elemento padre: 522   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(522)).appendChild((Element)v.get(523));

      /* Empieza nodo:524 / Elemento padre: 523   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(524)).setAttribute("class","legend" );
      ((Element)v.get(523)).appendChild((Element)v.get(524));

      /* Empieza nodo:525 / Elemento padre: 524   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(525)).setAttribute("nombre","lblCobranza" );
      ((Element)v.get(525)).setAttribute("alto","13" );
      ((Element)v.get(525)).setAttribute("filas","1" );
      ((Element)v.get(525)).setAttribute("valor","" );
      ((Element)v.get(525)).setAttribute("id","legend" );
      ((Element)v.get(525)).setAttribute("cod","00345" );
      ((Element)v.get(524)).appendChild((Element)v.get(525));
      /* Termina nodo:525   */
      /* Termina nodo:524   */

      /* Empieza nodo:526 / Elemento padre: 523   */
      v.add(doc.createElement("table"));
      ((Element)v.get(526)).setAttribute("width","100%" );
      ((Element)v.get(526)).setAttribute("border","0" );
      ((Element)v.get(526)).setAttribute("align","center" );
      ((Element)v.get(526)).setAttribute("cellspacing","0" );
      ((Element)v.get(526)).setAttribute("cellpadding","0" );
      ((Element)v.get(523)).appendChild((Element)v.get(526));

      /* Empieza nodo:527 / Elemento padre: 526   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(526)).appendChild((Element)v.get(527));

      /* Empieza nodo:528 / Elemento padre: 527   */
      v.add(doc.createElement("td"));
      ((Element)v.get(527)).appendChild((Element)v.get(528));

      /* Empieza nodo:529 / Elemento padre: 528   */
      v.add(doc.createElement("table"));
      ((Element)v.get(529)).setAttribute("width","100%" );
      ((Element)v.get(529)).setAttribute("border","0" );
      ((Element)v.get(529)).setAttribute("align","center" );
      ((Element)v.get(529)).setAttribute("cellspacing","0" );
      ((Element)v.get(529)).setAttribute("cellpadding","0" );
      ((Element)v.get(528)).appendChild((Element)v.get(529));

      /* Empieza nodo:530 / Elemento padre: 529   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(529)).appendChild((Element)v.get(530));

      /* Empieza nodo:531 / Elemento padre: 530   */
      v.add(doc.createElement("td"));
      ((Element)v.get(531)).setAttribute("colspan","4" );
      ((Element)v.get(530)).appendChild((Element)v.get(531));

      /* Empieza nodo:532 / Elemento padre: 531   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(532)).setAttribute("src","b.gif" );
      ((Element)v.get(532)).setAttribute("width","12" );
      ((Element)v.get(532)).setAttribute("height","8" );
      ((Element)v.get(531)).appendChild((Element)v.get(532));
      /* Termina nodo:532   */
      /* Termina nodo:531   */
      /* Termina nodo:530   */

      /* Empieza nodo:533 / Elemento padre: 529   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(529)).appendChild((Element)v.get(533));

      /* Empieza nodo:534 / Elemento padre: 533   */
      v.add(doc.createElement("td"));
      ((Element)v.get(533)).appendChild((Element)v.get(534));

      /* Empieza nodo:535 / Elemento padre: 534   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(535)).setAttribute("src","b.gif" );
      ((Element)v.get(535)).setAttribute("width","8" );
      ((Element)v.get(535)).setAttribute("height","8" );
      ((Element)v.get(534)).appendChild((Element)v.get(535));
      /* Termina nodo:535   */
      /* Termina nodo:534   */

      /* Empieza nodo:536 / Elemento padre: 533   */
      v.add(doc.createElement("td"));
      ((Element)v.get(536)).setAttribute("width","100%" );
      ((Element)v.get(533)).appendChild((Element)v.get(536));

      /* Empieza nodo:537 / Elemento padre: 536   */
      v.add(doc.createElement("table"));
      ((Element)v.get(537)).setAttribute("width","100%" );
      ((Element)v.get(537)).setAttribute("border","0" );
      ((Element)v.get(537)).setAttribute("cellspacing","0" );
      ((Element)v.get(537)).setAttribute("cellpadding","0" );
      ((Element)v.get(536)).appendChild((Element)v.get(537));

      /* Empieza nodo:538 / Elemento padre: 537   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(537)).appendChild((Element)v.get(538));

      /* Empieza nodo:539 / Elemento padre: 538   */
      v.add(doc.createElement("td"));
      ((Element)v.get(538)).appendChild((Element)v.get(539));

      /* Empieza nodo:540 / Elemento padre: 539   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(539)).appendChild((Element)v.get(540));

      /* Empieza nodo:541 / Elemento padre: 540   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(541)).setAttribute("class","legend" );
      ((Element)v.get(540)).appendChild((Element)v.get(541));

      /* Empieza nodo:542 / Elemento padre: 541   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(542)).setAttribute("nombre","lblDatosParticipante" );
      ((Element)v.get(542)).setAttribute("alto","13" );
      ((Element)v.get(542)).setAttribute("filas","1" );
      ((Element)v.get(542)).setAttribute("valor","" );
      ((Element)v.get(542)).setAttribute("id","legend" );
      ((Element)v.get(542)).setAttribute("cod","00365" );
      ((Element)v.get(541)).appendChild((Element)v.get(542));
      /* Termina nodo:542   */
      /* Termina nodo:541   */

      /* Empieza nodo:543 / Elemento padre: 540   */
      v.add(doc.createElement("table"));
      ((Element)v.get(543)).setAttribute("width","100%" );
      ((Element)v.get(543)).setAttribute("border","0" );
      ((Element)v.get(543)).setAttribute("align","center" );
      ((Element)v.get(543)).setAttribute("cellspacing","0" );
      ((Element)v.get(543)).setAttribute("cellpadding","0" );
      ((Element)v.get(540)).appendChild((Element)v.get(543));

      /* Empieza nodo:544 / Elemento padre: 543   */
      v.add(doc.createElement("tr"));
   }

   private void getXML2250(Document doc) {
      ((Element)v.get(543)).appendChild((Element)v.get(544));

      /* Empieza nodo:545 / Elemento padre: 544   */
      v.add(doc.createElement("td"));
      ((Element)v.get(544)).appendChild((Element)v.get(545));

      /* Empieza nodo:546 / Elemento padre: 545   */
      v.add(doc.createElement("table"));
      ((Element)v.get(546)).setAttribute("width","643" );
      ((Element)v.get(546)).setAttribute("border","0" );
      ((Element)v.get(546)).setAttribute("align","left" );
      ((Element)v.get(546)).setAttribute("cellspacing","0" );
      ((Element)v.get(546)).setAttribute("cellpadding","0" );
      ((Element)v.get(545)).appendChild((Element)v.get(546));

      /* Empieza nodo:547 / Elemento padre: 546   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(546)).appendChild((Element)v.get(547));

      /* Empieza nodo:548 / Elemento padre: 547   */
      v.add(doc.createElement("td"));
      ((Element)v.get(548)).setAttribute("colspan","4" );
      ((Element)v.get(547)).appendChild((Element)v.get(548));

      /* Empieza nodo:549 / Elemento padre: 548   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(549)).setAttribute("src","b.gif" );
      ((Element)v.get(549)).setAttribute("width","8" );
      ((Element)v.get(549)).setAttribute("height","8" );
      ((Element)v.get(548)).appendChild((Element)v.get(549));
      /* Termina nodo:549   */
      /* Termina nodo:548   */
      /* Termina nodo:547   */

      /* Empieza nodo:550 / Elemento padre: 546   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(546)).appendChild((Element)v.get(550));

      /* Empieza nodo:551 / Elemento padre: 550   */
      v.add(doc.createElement("td"));
      ((Element)v.get(550)).appendChild((Element)v.get(551));

      /* Empieza nodo:552 / Elemento padre: 551   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(552)).setAttribute("src","b.gif" );
      ((Element)v.get(552)).setAttribute("width","8" );
      ((Element)v.get(552)).setAttribute("height","8" );
      ((Element)v.get(551)).appendChild((Element)v.get(552));
      /* Termina nodo:552   */
      /* Termina nodo:551   */

      /* Empieza nodo:553 / Elemento padre: 550   */
      v.add(doc.createElement("td"));
      ((Element)v.get(550)).appendChild((Element)v.get(553));

      /* Empieza nodo:554 / Elemento padre: 553   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(554)).setAttribute("nombre","lblTipoParticipante" );
      ((Element)v.get(554)).setAttribute("alto","13" );
      ((Element)v.get(554)).setAttribute("filas","1" );
      ((Element)v.get(554)).setAttribute("valor","" );
      ((Element)v.get(554)).setAttribute("id","datosTitle" );
      ((Element)v.get(554)).setAttribute("cod","1728" );
      ((Element)v.get(553)).appendChild((Element)v.get(554));
      /* Termina nodo:554   */
      /* Termina nodo:553   */

      /* Empieza nodo:555 / Elemento padre: 550   */
      v.add(doc.createElement("td"));
      ((Element)v.get(555)).setAttribute("width","100%" );
      ((Element)v.get(550)).appendChild((Element)v.get(555));

      /* Empieza nodo:556 / Elemento padre: 555   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(556)).setAttribute("src","b.gif" );
      ((Element)v.get(556)).setAttribute("width","8" );
      ((Element)v.get(556)).setAttribute("height","8" );
      ((Element)v.get(555)).appendChild((Element)v.get(556));
      /* Termina nodo:556   */
      /* Termina nodo:555   */
      /* Termina nodo:550   */

      /* Empieza nodo:557 / Elemento padre: 546   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(546)).appendChild((Element)v.get(557));

      /* Empieza nodo:558 / Elemento padre: 557   */
      v.add(doc.createElement("td"));
      ((Element)v.get(557)).appendChild((Element)v.get(558));

      /* Empieza nodo:559 / Elemento padre: 558   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(559)).setAttribute("src","b.gif" );
      ((Element)v.get(559)).setAttribute("width","8" );
      ((Element)v.get(559)).setAttribute("height","8" );
      ((Element)v.get(558)).appendChild((Element)v.get(559));
      /* Termina nodo:559   */
      /* Termina nodo:558   */

      /* Empieza nodo:560 / Elemento padre: 557   */
      v.add(doc.createElement("td"));
      ((Element)v.get(560)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(557)).appendChild((Element)v.get(560));

      /* Empieza nodo:561 / Elemento padre: 560   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(561)).setAttribute("nombre","cbTipoParticipante" );
      ((Element)v.get(561)).setAttribute("id","datosCampos" );
      ((Element)v.get(561)).setAttribute("size","1" );
      ((Element)v.get(561)).setAttribute("multiple","N" );
      ((Element)v.get(561)).setAttribute("req","S" );
      ((Element)v.get(561)).setAttribute("valorinicial","" );
      ((Element)v.get(561)).setAttribute("textoinicial","" );
      ((Element)v.get(561)).setAttribute("onshtab","onShTabComboTipoParticipante();" );
      ((Element)v.get(560)).appendChild((Element)v.get(561));

      /* Empieza nodo:562 / Elemento padre: 561   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(561)).appendChild((Element)v.get(562));
      /* Termina nodo:562   */
      /* Termina nodo:561   */
      /* Termina nodo:560   */

      /* Empieza nodo:563 / Elemento padre: 557   */
      v.add(doc.createElement("td"));
      ((Element)v.get(563)).setAttribute("width","100%" );
      ((Element)v.get(557)).appendChild((Element)v.get(563));

      /* Empieza nodo:564 / Elemento padre: 563   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(564)).setAttribute("src","b.gif" );
      ((Element)v.get(564)).setAttribute("width","8" );
      ((Element)v.get(564)).setAttribute("height","8" );
      ((Element)v.get(563)).appendChild((Element)v.get(564));
      /* Termina nodo:564   */
      /* Termina nodo:563   */
      /* Termina nodo:557   */

      /* Empieza nodo:565 / Elemento padre: 546   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(546)).appendChild((Element)v.get(565));

      /* Empieza nodo:566 / Elemento padre: 565   */
      v.add(doc.createElement("td"));
      ((Element)v.get(566)).setAttribute("colspan","4" );
      ((Element)v.get(565)).appendChild((Element)v.get(566));

      /* Empieza nodo:567 / Elemento padre: 566   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(567)).setAttribute("src","b.gif" );
      ((Element)v.get(567)).setAttribute("width","8" );
      ((Element)v.get(567)).setAttribute("height","8" );
      ((Element)v.get(566)).appendChild((Element)v.get(567));
      /* Termina nodo:567   */
      /* Termina nodo:566   */
      /* Termina nodo:565   */
      /* Termina nodo:546   */
      /* Termina nodo:545   */
      /* Termina nodo:544   */
      /* Termina nodo:543   */
      /* Termina nodo:540   */
      /* Termina nodo:539   */
      /* Termina nodo:538   */
      /* Termina nodo:537   */
      /* Termina nodo:536   */

      /* Empieza nodo:568 / Elemento padre: 533   */
      v.add(doc.createElement("td"));
   }

   private void getXML2340(Document doc) {
      ((Element)v.get(533)).appendChild((Element)v.get(568));

      /* Empieza nodo:569 / Elemento padre: 568   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(569)).setAttribute("src","b.gif" );
      ((Element)v.get(569)).setAttribute("width","8" );
      ((Element)v.get(569)).setAttribute("height","8" );
      ((Element)v.get(568)).appendChild((Element)v.get(569));
      /* Termina nodo:569   */
      /* Termina nodo:568   */
      /* Termina nodo:533   */

      /* Empieza nodo:570 / Elemento padre: 529   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(529)).appendChild((Element)v.get(570));

      /* Empieza nodo:571 / Elemento padre: 570   */
      v.add(doc.createElement("td"));
      ((Element)v.get(570)).appendChild((Element)v.get(571));

      /* Empieza nodo:572 / Elemento padre: 571   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(572)).setAttribute("src","b.gif" );
      ((Element)v.get(571)).appendChild((Element)v.get(572));
      /* Termina nodo:572   */
      /* Termina nodo:571   */

      /* Empieza nodo:573 / Elemento padre: 570   */
      v.add(doc.createElement("td"));
      ((Element)v.get(570)).appendChild((Element)v.get(573));

      /* Empieza nodo:574 / Elemento padre: 573   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(573)).appendChild((Element)v.get(574));

      /* Empieza nodo:575 / Elemento padre: 574   */
      v.add(doc.createElement("table"));
      ((Element)v.get(575)).setAttribute("width","100%" );
      ((Element)v.get(575)).setAttribute("border","0" );
      ((Element)v.get(575)).setAttribute("align","center" );
      ((Element)v.get(575)).setAttribute("cellspacing","0" );
      ((Element)v.get(575)).setAttribute("cellpadding","0" );
      ((Element)v.get(574)).appendChild((Element)v.get(575));

      /* Empieza nodo:576 / Elemento padre: 575   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(575)).appendChild((Element)v.get(576));

      /* Empieza nodo:577 / Elemento padre: 576   */
      v.add(doc.createElement("td"));
      ((Element)v.get(577)).setAttribute("class","botonera" );
      ((Element)v.get(577)).setAttribute("width","100%" );
      ((Element)v.get(576)).appendChild((Element)v.get(577));

      /* Empieza nodo:578 / Elemento padre: 577   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(578)).setAttribute("nombre","btnAceptar2" );
      ((Element)v.get(578)).setAttribute("ID","botonContenido" );
      ((Element)v.get(578)).setAttribute("tipo","html" );
      ((Element)v.get(578)).setAttribute("accion","btnAceptarTipoParticipanteOnClick();" );
      ((Element)v.get(578)).setAttribute("estado","false" );
      ((Element)v.get(578)).setAttribute("cod","12" );
      ((Element)v.get(578)).setAttribute("ontab","onTabBotonAceptarTipoParticipante();" );
      ((Element)v.get(577)).appendChild((Element)v.get(578));
      /* Termina nodo:578   */
      /* Termina nodo:577   */
      /* Termina nodo:576   */
      /* Termina nodo:575   */
      /* Termina nodo:574   */
      /* Termina nodo:573   */

      /* Empieza nodo:579 / Elemento padre: 570   */
      v.add(doc.createElement("td"));
      ((Element)v.get(570)).appendChild((Element)v.get(579));

      /* Empieza nodo:580 / Elemento padre: 579   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(580)).setAttribute("src","b.gif" );
      ((Element)v.get(580)).setAttribute("width","8" );
      ((Element)v.get(580)).setAttribute("height","8" );
      ((Element)v.get(579)).appendChild((Element)v.get(580));
      /* Termina nodo:580   */
      /* Termina nodo:579   */
      /* Termina nodo:570   */

      /* Empieza nodo:581 / Elemento padre: 529   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(529)).appendChild((Element)v.get(581));

      /* Empieza nodo:582 / Elemento padre: 581   */
      v.add(doc.createElement("td"));
      ((Element)v.get(582)).setAttribute("colspan","3" );
      ((Element)v.get(581)).appendChild((Element)v.get(582));

      /* Empieza nodo:583 / Elemento padre: 582   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(583)).setAttribute("src","b.gif" );
      ((Element)v.get(583)).setAttribute("width","8" );
      ((Element)v.get(583)).setAttribute("height","8" );
      ((Element)v.get(582)).appendChild((Element)v.get(583));
      /* Termina nodo:583   */
      /* Termina nodo:582   */
      /* Termina nodo:581   */
      /* Termina nodo:529   */
      /* Termina nodo:528   */
      /* Termina nodo:527   */

      /* Empieza nodo:584 / Elemento padre: 526   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(526)).appendChild((Element)v.get(584));

      /* Empieza nodo:585 / Elemento padre: 584   */
      v.add(doc.createElement("td"));
      ((Element)v.get(585)).setAttribute("colspan","3" );
      ((Element)v.get(584)).appendChild((Element)v.get(585));

      /* Empieza nodo:586 / Elemento padre: 585   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(586)).setAttribute("src","b.gif" );
      ((Element)v.get(586)).setAttribute("width","8" );
      ((Element)v.get(586)).setAttribute("height","12" );
      ((Element)v.get(585)).appendChild((Element)v.get(586));
      /* Termina nodo:586   */
      /* Termina nodo:585   */
      /* Termina nodo:584   */
      /* Termina nodo:526   */
      /* Termina nodo:523   */
      /* Termina nodo:522   */

      /* Empieza nodo:587 / Elemento padre: 519   */
      v.add(doc.createElement("td"));
      ((Element)v.get(519)).appendChild((Element)v.get(587));

      /* Empieza nodo:588 / Elemento padre: 587   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(588)).setAttribute("src","b.gif" );
      ((Element)v.get(588)).setAttribute("width","12" );
      ((Element)v.get(588)).setAttribute("height","12" );
      ((Element)v.get(587)).appendChild((Element)v.get(588));
      /* Termina nodo:588   */
      /* Termina nodo:587   */
      /* Termina nodo:519   */

      /* Empieza nodo:589 / Elemento padre: 511   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(511)).appendChild((Element)v.get(589));

      /* Empieza nodo:590 / Elemento padre: 589   */
      v.add(doc.createElement("td"));
      ((Element)v.get(590)).setAttribute("width","12" );
      ((Element)v.get(590)).setAttribute("align","center" );
      ((Element)v.get(589)).appendChild((Element)v.get(590));

      /* Empieza nodo:591 / Elemento padre: 590   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(591)).setAttribute("src","b.gif" );
      ((Element)v.get(591)).setAttribute("width","12" );
      ((Element)v.get(591)).setAttribute("height","12" );
      ((Element)v.get(590)).appendChild((Element)v.get(591));
      /* Termina nodo:591   */
      /* Termina nodo:590   */

      /* Empieza nodo:592 / Elemento padre: 589   */
      v.add(doc.createElement("td"));
      ((Element)v.get(592)).setAttribute("width","750" );
      ((Element)v.get(589)).appendChild((Element)v.get(592));

      /* Empieza nodo:593 / Elemento padre: 592   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(593)).setAttribute("src","b.gif" );
      ((Element)v.get(592)).appendChild((Element)v.get(593));
      /* Termina nodo:593   */
      /* Termina nodo:592   */

      /* Empieza nodo:594 / Elemento padre: 589   */
   }

   private void getXML2430(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(594)).setAttribute("width","12" );
      ((Element)v.get(589)).appendChild((Element)v.get(594));

      /* Empieza nodo:595 / Elemento padre: 594   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(595)).setAttribute("src","b.gif" );
      ((Element)v.get(595)).setAttribute("width","12" );
      ((Element)v.get(595)).setAttribute("height","12" );
      ((Element)v.get(594)).appendChild((Element)v.get(595));
      /* Termina nodo:595   */
      /* Termina nodo:594   */
      /* Termina nodo:589   */
      /* Termina nodo:511   */
      /* Termina nodo:510   */

      /* Empieza nodo:596 / Elemento padre: 18   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(596)).setAttribute("nombre","capa5" );
      ((Element)v.get(596)).setAttribute("alto","100" );
      ((Element)v.get(596)).setAttribute("ancho","100%" );
      ((Element)v.get(596)).setAttribute("colorf","" );
      ((Element)v.get(596)).setAttribute("borde","0" );
      ((Element)v.get(596)).setAttribute("imagenf","" );
      ((Element)v.get(596)).setAttribute("repeat","" );
      ((Element)v.get(596)).setAttribute("padding","" );
      ((Element)v.get(596)).setAttribute("visibilidad","" );
      ((Element)v.get(596)).setAttribute("contravsb","" );
      ((Element)v.get(596)).setAttribute("x","0" );
      ((Element)v.get(596)).setAttribute("y","305" );
      ((Element)v.get(596)).setAttribute("zindex","" );
      ((Element)v.get(18)).appendChild((Element)v.get(596));

      /* Empieza nodo:597 / Elemento padre: 596   */
      v.add(doc.createElement("table"));
      ((Element)v.get(597)).setAttribute("width","100%" );
      ((Element)v.get(597)).setAttribute("border","0" );
      ((Element)v.get(597)).setAttribute("cellspacing","0" );
      ((Element)v.get(597)).setAttribute("cellpadding","0" );
      ((Element)v.get(596)).appendChild((Element)v.get(597));

      /* Empieza nodo:598 / Elemento padre: 597   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(597)).appendChild((Element)v.get(598));

      /* Empieza nodo:599 / Elemento padre: 598   */
      v.add(doc.createElement("td"));
      ((Element)v.get(599)).setAttribute("width","12" );
      ((Element)v.get(599)).setAttribute("align","center" );
      ((Element)v.get(598)).appendChild((Element)v.get(599));

      /* Empieza nodo:600 / Elemento padre: 599   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(600)).setAttribute("src","b.gif" );
      ((Element)v.get(600)).setAttribute("width","12" );
      ((Element)v.get(600)).setAttribute("height","12" );
      ((Element)v.get(599)).appendChild((Element)v.get(600));
      /* Termina nodo:600   */
      /* Termina nodo:599   */

      /* Empieza nodo:601 / Elemento padre: 598   */
      v.add(doc.createElement("td"));
      ((Element)v.get(601)).setAttribute("width","750" );
      ((Element)v.get(598)).appendChild((Element)v.get(601));

      /* Empieza nodo:602 / Elemento padre: 601   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(602)).setAttribute("src","b.gif" );
      ((Element)v.get(601)).appendChild((Element)v.get(602));
      /* Termina nodo:602   */
      /* Termina nodo:601   */

      /* Empieza nodo:603 / Elemento padre: 598   */
      v.add(doc.createElement("td"));
      ((Element)v.get(603)).setAttribute("width","12" );
      ((Element)v.get(598)).appendChild((Element)v.get(603));

      /* Empieza nodo:604 / Elemento padre: 603   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(604)).setAttribute("src","b.gif" );
      ((Element)v.get(604)).setAttribute("width","12" );
      ((Element)v.get(604)).setAttribute("height","1" );
      ((Element)v.get(603)).appendChild((Element)v.get(604));
      /* Termina nodo:604   */
      /* Termina nodo:603   */
      /* Termina nodo:598   */

      /* Empieza nodo:605 / Elemento padre: 597   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(597)).appendChild((Element)v.get(605));

      /* Empieza nodo:606 / Elemento padre: 605   */
      v.add(doc.createElement("td"));
      ((Element)v.get(605)).appendChild((Element)v.get(606));

      /* Empieza nodo:607 / Elemento padre: 606   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(607)).setAttribute("src","b.gif" );
      ((Element)v.get(606)).appendChild((Element)v.get(607));
      /* Termina nodo:607   */
      /* Termina nodo:606   */

      /* Empieza nodo:608 / Elemento padre: 605   */
      v.add(doc.createElement("td"));
      ((Element)v.get(605)).appendChild((Element)v.get(608));

      /* Empieza nodo:609 / Elemento padre: 608   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(608)).appendChild((Element)v.get(609));

      /* Empieza nodo:610 / Elemento padre: 609   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(610)).setAttribute("class","legend" );
      ((Element)v.get(609)).appendChild((Element)v.get(610));

      /* Empieza nodo:611 / Elemento padre: 610   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(611)).setAttribute("nombre","lblCriteriosModificacion5" );
      ((Element)v.get(611)).setAttribute("alto","13" );
      ((Element)v.get(611)).setAttribute("filas","1" );
      ((Element)v.get(611)).setAttribute("valor","" );
      ((Element)v.get(611)).setAttribute("id","legend" );
      ((Element)v.get(611)).setAttribute("cod","00547" );
      ((Element)v.get(610)).appendChild((Element)v.get(611));
      /* Termina nodo:611   */
      /* Termina nodo:610   */

      /* Empieza nodo:612 / Elemento padre: 609   */
      v.add(doc.createElement("table"));
      ((Element)v.get(612)).setAttribute("width","100%" );
      ((Element)v.get(612)).setAttribute("border","0" );
      ((Element)v.get(612)).setAttribute("align","center" );
      ((Element)v.get(612)).setAttribute("cellspacing","0" );
      ((Element)v.get(612)).setAttribute("cellpadding","0" );
      ((Element)v.get(609)).appendChild((Element)v.get(612));

      /* Empieza nodo:613 / Elemento padre: 612   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(612)).appendChild((Element)v.get(613));

      /* Empieza nodo:614 / Elemento padre: 613   */
      v.add(doc.createElement("td"));
      ((Element)v.get(613)).appendChild((Element)v.get(614));

      /* Empieza nodo:615 / Elemento padre: 614   */
      v.add(doc.createElement("table"));
      ((Element)v.get(615)).setAttribute("width","663" );
      ((Element)v.get(615)).setAttribute("border","0" );
   }

   private void getXML2520(Document doc) {
      ((Element)v.get(615)).setAttribute("align","left" );
      ((Element)v.get(615)).setAttribute("cellspacing","0" );
      ((Element)v.get(615)).setAttribute("cellpadding","0" );
      ((Element)v.get(614)).appendChild((Element)v.get(615));

      /* Empieza nodo:616 / Elemento padre: 615   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(615)).appendChild((Element)v.get(616));

      /* Empieza nodo:617 / Elemento padre: 616   */
      v.add(doc.createElement("td"));
      ((Element)v.get(617)).setAttribute("colspan","4" );
      ((Element)v.get(616)).appendChild((Element)v.get(617));

      /* Empieza nodo:618 / Elemento padre: 617   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(618)).setAttribute("src","b.gif" );
      ((Element)v.get(618)).setAttribute("width","8" );
      ((Element)v.get(618)).setAttribute("height","8" );
      ((Element)v.get(617)).appendChild((Element)v.get(618));
      /* Termina nodo:618   */
      /* Termina nodo:617   */
      /* Termina nodo:616   */

      /* Empieza nodo:619 / Elemento padre: 615   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(615)).appendChild((Element)v.get(619));

      /* Empieza nodo:620 / Elemento padre: 619   */
      v.add(doc.createElement("td"));
      ((Element)v.get(619)).appendChild((Element)v.get(620));

      /* Empieza nodo:621 / Elemento padre: 620   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(621)).setAttribute("src","b.gif" );
      ((Element)v.get(621)).setAttribute("width","8" );
      ((Element)v.get(621)).setAttribute("height","8" );
      ((Element)v.get(620)).appendChild((Element)v.get(621));
      /* Termina nodo:621   */
      /* Termina nodo:620   */

      /* Empieza nodo:622 / Elemento padre: 619   */
      v.add(doc.createElement("td"));
      ((Element)v.get(619)).appendChild((Element)v.get(622));

      /* Empieza nodo:623 / Elemento padre: 622   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(623)).setAttribute("nombre","lblPeriodoEntradaVigor5" );
      ((Element)v.get(623)).setAttribute("alto","13" );
      ((Element)v.get(623)).setAttribute("filas","1" );
      ((Element)v.get(623)).setAttribute("valor","" );
      ((Element)v.get(623)).setAttribute("id","datosTitle" );
      ((Element)v.get(623)).setAttribute("cod","1735" );
      ((Element)v.get(622)).appendChild((Element)v.get(623));
      /* Termina nodo:623   */
      /* Termina nodo:622   */

      /* Empieza nodo:624 / Elemento padre: 619   */
      v.add(doc.createElement("td"));
      ((Element)v.get(619)).appendChild((Element)v.get(624));

      /* Empieza nodo:625 / Elemento padre: 624   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(625)).setAttribute("src","b.gif" );
      ((Element)v.get(625)).setAttribute("width","25" );
      ((Element)v.get(625)).setAttribute("height","8" );
      ((Element)v.get(624)).appendChild((Element)v.get(625));
      /* Termina nodo:625   */
      /* Termina nodo:624   */

      /* Empieza nodo:626 / Elemento padre: 619   */
      v.add(doc.createElement("td"));
      ((Element)v.get(619)).appendChild((Element)v.get(626));

      /* Empieza nodo:627 / Elemento padre: 626   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(627)).setAttribute("nombre","lblObservaciones5" );
      ((Element)v.get(627)).setAttribute("alto","13" );
      ((Element)v.get(627)).setAttribute("filas","1" );
      ((Element)v.get(627)).setAttribute("valor","" );
      ((Element)v.get(627)).setAttribute("id","datosTitle" );
      ((Element)v.get(627)).setAttribute("cod","169" );
      ((Element)v.get(626)).appendChild((Element)v.get(627));
      /* Termina nodo:627   */
      /* Termina nodo:626   */

      /* Empieza nodo:628 / Elemento padre: 619   */
      v.add(doc.createElement("td"));
      ((Element)v.get(628)).setAttribute("width","100%" );
      ((Element)v.get(619)).appendChild((Element)v.get(628));

      /* Empieza nodo:629 / Elemento padre: 628   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(629)).setAttribute("src","b.gif" );
      ((Element)v.get(629)).setAttribute("width","8" );
      ((Element)v.get(629)).setAttribute("height","8" );
      ((Element)v.get(628)).appendChild((Element)v.get(629));
      /* Termina nodo:629   */
      /* Termina nodo:628   */
      /* Termina nodo:619   */

      /* Empieza nodo:630 / Elemento padre: 615   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(615)).appendChild((Element)v.get(630));

      /* Empieza nodo:631 / Elemento padre: 630   */
      v.add(doc.createElement("td"));
      ((Element)v.get(630)).appendChild((Element)v.get(631));

      /* Empieza nodo:632 / Elemento padre: 631   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(632)).setAttribute("src","b.gif" );
      ((Element)v.get(632)).setAttribute("width","8" );
      ((Element)v.get(632)).setAttribute("height","8" );
      ((Element)v.get(631)).appendChild((Element)v.get(632));
      /* Termina nodo:632   */
      /* Termina nodo:631   */

      /* Empieza nodo:633 / Elemento padre: 630   */
      v.add(doc.createElement("td"));
      ((Element)v.get(633)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(633)).setAttribute("valign","top" );
      ((Element)v.get(630)).appendChild((Element)v.get(633));

      /* Empieza nodo:634 / Elemento padre: 633   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(634)).setAttribute("nombre","cbPeriodoEntradaVigor5" );
      ((Element)v.get(634)).setAttribute("id","datosCampos" );
      ((Element)v.get(634)).setAttribute("size","1" );
      ((Element)v.get(634)).setAttribute("multiple","N" );
      ((Element)v.get(634)).setAttribute("req","N" );
      ((Element)v.get(634)).setAttribute("valorinicial","" );
      ((Element)v.get(634)).setAttribute("textoinicial","" );
      ((Element)v.get(633)).appendChild((Element)v.get(634));

      /* Empieza nodo:635 / Elemento padre: 634   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(634)).appendChild((Element)v.get(635));
      /* Termina nodo:635   */
      /* Termina nodo:634   */
      /* Termina nodo:633   */

      /* Empieza nodo:636 / Elemento padre: 630   */
      v.add(doc.createElement("td"));
      ((Element)v.get(630)).appendChild((Element)v.get(636));

      /* Empieza nodo:637 / Elemento padre: 636   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(637)).setAttribute("src","b.gif" );
      ((Element)v.get(637)).setAttribute("width","25" );
      ((Element)v.get(637)).setAttribute("height","8" );
      ((Element)v.get(636)).appendChild((Element)v.get(637));
      /* Termina nodo:637   */
      /* Termina nodo:636   */

      /* Empieza nodo:638 / Elemento padre: 630   */
      v.add(doc.createElement("td"));
   }

   private void getXML2610(Document doc) {
      ((Element)v.get(638)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(630)).appendChild((Element)v.get(638));

      /* Empieza nodo:639 / Elemento padre: 638   */
      v.add(doc.createElement("AREATEXTO"));
      ((Element)v.get(639)).setAttribute("cols","50" );
      ((Element)v.get(639)).setAttribute("id","datosCampos" );
      ((Element)v.get(639)).setAttribute("msjreq","" );
      ((Element)v.get(639)).setAttribute("nombre","atxtObservaciones52" );
      ((Element)v.get(639)).setAttribute("readonly","N" );
      ((Element)v.get(639)).setAttribute("req","N" );
      ((Element)v.get(639)).setAttribute("rows","3" );
      ((Element)v.get(639)).setAttribute("tabindex","2" );
      ((Element)v.get(639)).setAttribute("valor","" );
      ((Element)v.get(639)).setAttribute("max","125" );
      ((Element)v.get(639)).setAttribute("ontab","focoComboTipoComision();" );
      ((Element)v.get(638)).appendChild((Element)v.get(639));
      /* Termina nodo:639   */
      /* Termina nodo:638   */

      /* Empieza nodo:640 / Elemento padre: 630   */
      v.add(doc.createElement("td"));
      ((Element)v.get(640)).setAttribute("width","100%" );
      ((Element)v.get(630)).appendChild((Element)v.get(640));

      /* Empieza nodo:641 / Elemento padre: 640   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(641)).setAttribute("src","b.gif" );
      ((Element)v.get(641)).setAttribute("width","8" );
      ((Element)v.get(641)).setAttribute("height","8" );
      ((Element)v.get(640)).appendChild((Element)v.get(641));
      /* Termina nodo:641   */
      /* Termina nodo:640   */
      /* Termina nodo:630   */

      /* Empieza nodo:642 / Elemento padre: 615   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(615)).appendChild((Element)v.get(642));

      /* Empieza nodo:643 / Elemento padre: 642   */
      v.add(doc.createElement("td"));
      ((Element)v.get(643)).setAttribute("colspan","4" );
      ((Element)v.get(642)).appendChild((Element)v.get(643));

      /* Empieza nodo:644 / Elemento padre: 643   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(644)).setAttribute("src","b.gif" );
      ((Element)v.get(644)).setAttribute("width","8" );
      ((Element)v.get(644)).setAttribute("height","8" );
      ((Element)v.get(643)).appendChild((Element)v.get(644));
      /* Termina nodo:644   */
      /* Termina nodo:643   */
      /* Termina nodo:642   */
      /* Termina nodo:615   */
      /* Termina nodo:614   */
      /* Termina nodo:613   */
      /* Termina nodo:612   */
      /* Termina nodo:609   */
      /* Termina nodo:608   */

      /* Empieza nodo:645 / Elemento padre: 605   */
      v.add(doc.createElement("td"));
      ((Element)v.get(605)).appendChild((Element)v.get(645));

      /* Empieza nodo:646 / Elemento padre: 645   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(646)).setAttribute("src","b.gif" );
      ((Element)v.get(645)).appendChild((Element)v.get(646));
      /* Termina nodo:646   */
      /* Termina nodo:645   */
      /* Termina nodo:605   */

      /* Empieza nodo:647 / Elemento padre: 597   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(597)).appendChild((Element)v.get(647));

      /* Empieza nodo:648 / Elemento padre: 647   */
      v.add(doc.createElement("td"));
      ((Element)v.get(648)).setAttribute("width","12" );
      ((Element)v.get(648)).setAttribute("align","center" );
      ((Element)v.get(647)).appendChild((Element)v.get(648));

      /* Empieza nodo:649 / Elemento padre: 648   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(649)).setAttribute("src","b.gif" );
      ((Element)v.get(649)).setAttribute("width","12" );
      ((Element)v.get(649)).setAttribute("height","12" );
      ((Element)v.get(648)).appendChild((Element)v.get(649));
      /* Termina nodo:649   */
      /* Termina nodo:648   */

      /* Empieza nodo:650 / Elemento padre: 647   */
      v.add(doc.createElement("td"));
      ((Element)v.get(650)).setAttribute("width","750" );
      ((Element)v.get(647)).appendChild((Element)v.get(650));

      /* Empieza nodo:651 / Elemento padre: 650   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(651)).setAttribute("src","b.gif" );
      ((Element)v.get(650)).appendChild((Element)v.get(651));
      /* Termina nodo:651   */
      /* Termina nodo:650   */

      /* Empieza nodo:652 / Elemento padre: 647   */
      v.add(doc.createElement("td"));
      ((Element)v.get(652)).setAttribute("width","12" );
      ((Element)v.get(647)).appendChild((Element)v.get(652));

      /* Empieza nodo:653 / Elemento padre: 652   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(653)).setAttribute("src","b.gif" );
      ((Element)v.get(653)).setAttribute("width","12" );
      ((Element)v.get(653)).setAttribute("height","1" );
      ((Element)v.get(652)).appendChild((Element)v.get(653));
      /* Termina nodo:653   */
      /* Termina nodo:652   */
      /* Termina nodo:647   */
      /* Termina nodo:597   */
      /* Termina nodo:596   */
      /* Termina nodo:18   */


   }

}
