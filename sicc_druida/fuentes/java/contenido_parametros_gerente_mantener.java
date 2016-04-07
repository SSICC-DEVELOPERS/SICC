
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_parametros_gerente_mantener  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_parametros_gerente_mantener" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("titulo","Crear Concurso" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Elemento padre:1 / Elemento actual: 2   */
      v.add(doc.createTextNode("\r \r\rvar vConstantesPestInc = new Array();    \r\rfunction onLoadPag() {  \r	configurarMenuSecundario('formulario');\r    fMostrarMensajeError();\r         \r    if (get('formulario.ocultaParticipante') == '1'){\r		        deshabilitarHabilitarBoton('botonContenido','btnParticipantes','D');\r    }\r	\r        document.getElementById(\"capa2\").style.visibility='hidden';    document.getElementById(\"capa3\").style.visibility='hidden';    document.getElementById(\"capa4\").style.visibility='hidden';\r    marcaSeleccionDelUsuario('formulario.cbFormaCalculo', get('formulario.oidFormaCalculo'));         \r         \r    if (get('formulario.hidIndGerentes') == '1'){ \r		\r        if  ( get('formulario.oidFormaCalculo') == get('formulario.oid_Forma_Calc_Base_Calc')){\r	        document.getElementById(\"capa2\").style.visibility='visible';\r            marcaSeleccionDelUsuario('formulario.cbFormaCalculo', get('formulario.oidFormaCalculo'));\r    \r			if (get('formulario.oidPlantillaBaseCalculo')!= '') {                  \r				marcaSeleccionDelUsuario('formulario.cbBaseCalculo', get('formulario.oidPlantillaBaseCalculo'));    \r                accion(\"formulario.cbBaseCalculo\",\".disabled=true\");\r                      \r                if ( get('formulario.oidPlantillaBaseCalculo') == get('formulario.oidBC_Recomendada')) {\r					marcaSeleccionDelUsuario('formulario.cbPeriodoInicialEvaluacion', get('formulario.hidPeriodoInicialEval'));\r                    \r					document.getElementById(\"capa3\").style.visibility='visible';\r                }\r                else { \r					if( get('formulario.oidPlantillaBaseCalculo') == get('formulario.oidBC_Calculo_Monto'))\r						document.getElementById(\"capa4\").style.visibility='visible';                         \r	                \r					                    document.getElementById(\"capa3\").style.visibility='hidden';                    marcaSeleccionDelUsuario('formulario.cbTipoVenta', get('formulario.oidTipoVta'));\r\r					if(get('formulario.oidTipoVta')!=\"\" || get('formulario.oidTipoVentaPlantilla')!=\"\") {\r						accion(\"formulario.cbTipoVenta\",\".disabled=true\");\r					}\r\r                    document.getElementById(\"capa4\").style.visibility='visible';\r                }\r            }\r            else {\r				marcaSeleccionDelUsuario('formulario.cbBaseCalculo', get('formulario.oidParamBaseCalculo'));\r\r                if ( get('formulario.oidParamBaseCalculo') == get('formulario.oidBC_Calculo_Monto')){\r					marcaSeleccionDelUsuario('formulario.cbTipoVenta', get('formulario.oidTipoVta'));\r					if(get('formulario.oidTipoVta')!=\"\" || get('formulario.oidTipoVentaPlantilla')!=\"\") {\r						accion(\"formulario.cbTipoVenta\",\".disabled=true\");\r					}\r\r                    document.getElementById(\"capa4\").style.visibility='visible';\r                }\r\r                if ( get('formulario.oidParamBaseCalculo') == get('formulario.oidBC_Recomendada')){\r					marcaSeleccionDelUsuario('formulario.cbPeriodoInicialEvaluacion', get('formulario.hidPeriodoInicialEval'));\r                    document.getElementById(\"capa3\").style.visibility='visible';\r                }\r            } \r        } \r                           \r        if(get('formulario.hIndFaseCalificacion') == '1'){\r			accion(\"formulario.cbFormaCalculo\",\".disabled=true\");				\r        }\r    } \r    else {  		        var seleccFormaCalculo = get(\"formulario.seleccFormaCalculo\");\r        var oidBaseCalculoTemp = get(\"formulario.oidBaseCalculoTemp\");\r\r        if(seleccFormaCalculo==\"variablesVenta\") {\r			                        marcaSeleccionDelUsuario('formulario.cbFormaCalculo', get('formulario.oid_Forma_Calc_Vbles_Vta'));\r            accion(\"formulario.cbFormaCalculo\",\".disabled=true\");\r\r                        document.getElementById(\"capa2\").style.visibility='hidden';            marcaSeleccionDelUsuario('formulario.cbBaseCalculo', \"\");\r            document.getElementById(\"capa4\").style.visibility='hidden';            marcaSeleccionDelUsuario('formulario.cbTipoVenta', \"\");\r            document.getElementById(\"capa3\").style.visibility='hidden';            marcaSeleccionDelUsuario('formulario.cbPeriodoInicialEvaluacion', \"\");\r        }\r        else if(seleccFormaCalculo==\"baseCalculo\") {\r			                        marcaSeleccionDelUsuario('formulario.cbFormaCalculo', get('formulario.oid_Forma_Calc_Base_Calc'));\r            accion(\"formulario.cbFormaCalculo\",\".disabled=true\");\r\r                        accionAceptar();\r            accionAceptarFormaCalculo();\r        }\r\r        if(oidBaseCalculoTemp!=\"\") {\r			                        marcaSeleccionDelUsuario('formulario.cbBaseCalculo', get('formulario.oidBaseCalculoTemp'));\r            accion(\"formulario.cbBaseCalculo\",\".disabled=true\");\r        }\r            }\r\r    var menu = get(\"formulario.opcionMenu\");      \r    if (menu == \"Consultar Concurso\"){\r		deshabilitaCamposTodos();            \r        btnProxy(1, 0);\r        btnProxy(5, 0);\r    }\r    else {\r		focoComboFormaCalculo();\r    }\r         \r    var vConst = get('formulario.hidConstantesPestINC');\r    vConstantesPestInc = vConst.split(\"|\");      \r    finCargaPagina = true;\r}\r\rfunction fLimpiar() {\r         onLoadPag();	\r}\r\rfunction focoComboFormaCalculo() {\r         focaliza('formulario.cbFormaCalculo');\r}\r\rfunction focoComboTipoVenta() {\r         focaliza('formulario.cbTipoVenta');\r}\r    \rfunction deshabilitaCampos() {\r	accion('formulario.txtNumPeriodosEvaluar','.readOnly=true');\r	accion('formulario.txtNumMinPedidos','.readOnly=true');\r	accion('formulario.txtNumMinPedidosRecomendada','.readOnly=true');\r}\r    \rfunction accionExitosa() {\r		\r}\r    \rfunction deshabilitaCamposTodos(){    \r	accion(\"formulario.cbBaseCalculo\", \".disabled=true\");\r    accion(\"formulario.cbFormaCalculo\", \".disabled=true\");\r    accion(\"formulario.cbTipoVenta\", \".disabled=true\");\r    accion(\"formulario.ckRecomendacionEfectiva\", \".disabled=true\");\r    accion(\"formulario.cbPeriodoInicialEvaluacion\", \".disabled=true\");\r    deshabilitaCampos();\r    deshabilitarHabilitarBoton('botonContenido','btnAceptar1','D');\r    deshabilitarHabilitarBoton('botonContenido','btnAceptar2','D');\r}\r    \rfunction marcaSeleccionDelUsuario(pControl, datos){\r	datos = datos.split(\",\");\r    var comb = pControl;\r    set(comb, datos);\r}\r\rfunction comprobarDatosObligatorios(){\r	var formaCalculo = get(\"formulario.cbFormaCalculo\");\r    var baseCalculo = get(\"formulario.cbBaseCalculo\");\r    var oidFormaCalcBaseCalc = get(\"formulario.oid_Forma_Calc_Base_Calc\");\r    var oidBaseCalcMonto = get(\"formulario.oidBC_Calculo_Monto\");\r    var tipoVenta = get(\"formulario.cbTipoVenta\");\r    var retorno = true;\r\r    	if ( formaCalculo == \"\" ) {\r		retorno = false;\r    }\r    else { \r		        if ( parseInt(formaCalculo, 10) == parseInt(oidFormaCalcBaseCalc, 10) )  {\r			if ( baseCalculo == \"\" ) {\r				retorno = false;\r            }\r            else {\r				if(parseInt(baseCalculo, 10) == parseInt(oidBaseCalcMonto, 10) ) {\r					if(tipoVenta==\"\") {\r						retorno = false;\r                    }\r                }\r            }				\r        }\r    }\r    return retorno;\r}\r\rfunction onClickParticipantes() {                  \r	var obj = new Object();\r    obj.opcionMenu = get('formulario.opcionMenu');\r    var whnd = mostrarModalSICC('LPMantenerParametrosGerentes','cargar clasificacion participantes',obj);\r    \r	if (whnd != null) {\r	    set ('formulario.hidLstClasConsul',whnd[0]);\r        set ('formulario.hidListaClasif',whnd[1]);             \r        set('formulario.conectorAction', 'LPMantenerParametrosGerentes');\r        eval('formulario').oculto=\"S\"; \r        set('formulario.accion', 'almacenar Clasificacion Participantes');\r        enviaSICC('formulario','','','N');\r    }\r}\r\rfunction onClickMontoVentaRecomendada() {\r	var obj = new Object();\r    obj.opcionMenu = get('formulario.opcionMenu');\r    var whnd = mostrarModalSICC('LPMantenerParametrosGerentes','cargar monto venta recomendadas',obj,null,260);\r    \r	if (whnd != null){         \r	    set('formulario.hidLstMVR', whnd[0]) ;\r        set('formulario.conectorAction', 'LPMantenerParametrosGerentes');\r        eval('formulario').oculto=\"S\"; \r        set('formulario.accion', 'almacenar monto venta recomendadas');\r        enviaSICC('formulario');\r    }\r}\r    \rfunction accionAceptar(){        \r	var vOidFC = get('formulario.cbFormaCalculo');\r    set('formulario.oidFormaCalculo', vOidFC);\r    \r	if ( vOidFC == get('formulario.oid_Forma_Calc_Base_Calc')) {\r        	    var oidBCPlantilla = get('formulario.oidPlantillaBaseCalculo');\r        if ( oidBCPlantilla != \"\") {\r	        marcaSeleccionDelUsuario('formulario.cbBaseCalculo', oidBCPlantilla );\r            accion(\"formulario.cbBaseCalculo\",\".disabled=true\");\r            document.getElementById(\"capa2\").style.visibility = \"visible\";\r\r			if ( oidBCPlantilla == get('formulario.oidBC_Recomendada') ) {\r				document.getElementById(\"capa1\").style.visibility='visible';\r            }\r			else { \r				if( oidBCPlantilla == get('formulario.oidBC_Calculo_Monto') ) {\r					document.getElementById(\"capa4\").style.visibility='visible';\r\r										var oidTipoVta = get('formulario.oidTipoVta');\r					var oidTipoVentaPlantilla = get('formulario.oidTipoVentaPlantilla');\r					if(oidTipoVentaPlantilla!=\"\") {\r												var oidSeleccionado = new Array();\r						oidSeleccionado = oidTipoVentaPlantilla.split(\",\");	    \r						set(\"formulario.cbTipoVenta\", oidSeleccionado);\r\r												accion(\"formulario.cbTipoVenta\",\".disabled=true\");\r					}\r					else {\r						if(oidTipoVta!=\"\") {\r							marcaSeleccionDelUsuario('formulario.cbTipoVenta', get('formulario.oidTipoVta'));\r							accion(\"formulario.cbTipoVenta\",\".disabled=true\");\r						}\r					}		\r				}\r                \r				                document.getElementById(\"capa3\").style.visibility='hidden';\r            } \r        }\r		else {\r			            document.getElementById(\"capa2\").style.visibility='hidden';\r            document.getElementById(\"capa3\").style.visibility='hidden';            document.getElementById(\"capa4\").style.visibility='hidden';         \r        } \r\r        document.getElementById(\"capa2\").style.visibility='visible';\r    }\r    else{\r		document.getElementById(\"capa2\").style.visibility='hidden';        marcaSeleccionDelUsuario('formulario.cbBaseCalculo', \"\");\r        \r		document.getElementById(\"capa4\").style.visibility='hidden';        marcaSeleccionDelUsuario('formulario.cbTipoVenta', \"\");\r        \r		document.getElementById(\"capa3\").style.visibility='hidden';        marcaSeleccionDelUsuario('formulario.cbPeriodoInicialEvaluacion', \"\");        \r		set('formulario.chkRecomendacionEfectiva','');\r        set('formulario.cbPeriodoInicialEvaluacion','');\r        set('formulario.txtNumeroPeriodosEvaluar','');\r        set('formulario.txtNumeroMinimoPedidos','');\r        set('formulario.txtNumeroMinimoPedidosRecomendada','');\r             \r        if ( vOidFC == get('formulario.oid_Forma_Calc_Vbles_Vta')) {\r			var obj = new Object();\r            obj.oidVariablesVenta = get('formulario.oidVariablesVenta');\r            obj.opcionMenu = get('formulario.opcionMenu');\r                  \r            var whnd = mostrarModalSICC('LPMantenerParametrosGerentes','cargar variables venta',obj,null,230);      \r            if (whnd != null) {\r                      set('formulario.hidVariablesVenta', whnd[0]);\r                      set('formulario.conectorAction', 'LPMantenerParametrosGerentes');\r                      eval('formulario').oculto=\"S\"; \r                      set('formulario.accion', 'almacenar variables venta');\r                      enviaSICC('formulario','','','N');\r            }\r        }\r    }\r}\r\rfunction onChangeBaseCalculo()    {\r	if (get('formulario.cbBaseCalculo','V') == get('formulario.oidBC_Calculo_Monto'))\r		document.getElementById(\"capa4\").style.visibility='visible';    else\r		document.getElementById(\"capa4\").style.visibility='hidden';}\r          \rfunction accionGuardar () {\r    if(get(\"formulario.cbFormaCalculo\")==get(\"formulario.oid_Forma_Calc_Base_Calc\") \r    && get('formulario.cbBaseCalculo')== get('formulario.oidBC_Calculo_Monto')){\r		if(!sicc_validaciones_generales('Obligatorio')) {\r			return;\r        }	\r    }\r\r    if(!sicc_validaciones_generales('grupoCamposNumericos')) {\r		return;\r    }\r\r    if (tomarDatosPantalla()) {\r		var vDatosOblig = comprobarDatosObligatorios();\r        set('formulario.datosObligatorios', vDatosOblig);\r        set('formulario.conectorAction', 'LPMantenerParametrosGerentes');\r        eval('formulario').oculto=\"S\"; \r        set('formulario.accion', 'guardar');\r        enviaSICC('formulario','','','N');\r    }\r}\r    \rfunction tomarDatosPantalla(){\r	set('formulario.hidRecomendacionEfectiva',get('formulario.ckRecomendacionEfectiva'));\r    set('formulario.hidPeriodoInicialEval',get('formulario.cbPeriodoInicialEvaluacion','V'));\r    set('formulario.hidNroPeriodosEvaluar',get('formulario.txtNumPeriodosEvaluar'));\r    set('formulario.hidNroMinimoPedidos',get('formulario.txtNumMinPedidos'));\r    set('formulario.hidNroMinPedidosReco',get('formulario.txtNumMinPedidosRecomendada'));         \r    set('formulario.oidTipoVta', get('formulario.cbTipoVenta'));\r\r    if (document.getElementById(\"capa3\").style.visibility =='hidden' ){\r		        set('formulario.hidLstMVR','');\r    }\r\r    var vOidFC = get('formulario.cbFormaCalculo');\r    \r	if ( vOidFC == get('formulario.oid_Forma_Calc_Vbles_Vta')) {\r		if( get('formulario.hidVariablesVenta') == '' && get('formulario.tengoVariablesVenta') == ''){\r			GestionarMensaje('1498');\r            return false;\r        }\r    }\r         \r    if (get('formulario.cbBaseCalculo','V') == get('formulario.oidBC_Recomendada')){\r		if( get('formulario.hidLstMVR') == '' && get('formulario.tengoLstMVR') == ''){\r			GestionarMensaje('1499');\r            return false;\r        }\r    }\r    \r	return true;\r}\r    \rfunction fGuardar(){\r	accionGuardar();\r}\r    \rfunction pasaMouse(valor, nombre) {\r	var iPos = vConstantesPestInc[valor];\r    activarPuntero('formulario',  iPos, nombre);\r}\r    \rfunction haceClick(valor) {\r	var iPos = vConstantesPestInc[valor];\r    onClickPestanyaHabilitada(iPos, 'formulario', 'LPMantenerParametrosGerentes');\r}\r    \rfunction accionError(){\r	fMostrarMensajeError();\r}\r\rfunction accionAceptarFormaCalculo(){    \r		set('formulario.oidBaseCalculo', get('formulario.cbBaseCalculo','V'));\r         \r	    if (get('formulario.cbBaseCalculo','V') == get('formulario.oidBC_Calculo_Monto')){\r				document.getElementById(\"capa4\").style.visibility='visible';		\r				var oidTipoVta = get('formulario.oidTipoVta');\r		var oidTipoVentaPlantilla = get('formulario.oidTipoVentaPlantilla');\r		if(oidTipoVentaPlantilla!=\"\") {\r						var oidSeleccionado = new Array();\r			oidSeleccionado = oidTipoVentaPlantilla.split(\",\");	    \r			set(\"formulario.cbTipoVenta\", oidSeleccionado);\r\r			            accion(\"formulario.cbTipoVenta\",\".disabled=true\");\r		}\r		else {\r			if(oidTipoVta!=\"\") {\r				marcaSeleccionDelUsuario('formulario.cbTipoVenta', get('formulario.oidTipoVta'));\r	 		    accion(\"formulario.cbTipoVenta\",\".disabled=true\");\r			}\r		}		\r\r		        document.getElementById(\"capa3\").style.visibility='hidden';        \r		        limpiaCapaRecomendados();\r    }\r    else{ 		set('formulario.cbTipoVenta','');\r		        document.getElementById(\"capa4\").style.visibility='hidden';        \r				if ( get('formulario.cbBaseCalculo','V') == get('formulario.oidBC_Recomendada'))\r			document.getElementById(\"capa3\").style.visibility='visible';        else { 	        document.getElementById(\"capa3\").style.visibility='hidden';            limpiaCapaRecomendados();\r        }\r    }\r}\r\rfunction limpiaCapaRecomendados(){\r	set('formulario.ckRecomendacionEfectiva', 'N');\r    set('formulario.cbPeriodoInicialEvaluacion', '');\r    set('formulario.txtNumPeriodosEvaluar','');\r    set('formulario.txtNumMinPedidos','');\r    set('formulario.txtNumMinPedidosRecomendada','');         \r}\r\rfunction onClickPestanyaPaginaGerentes(valor, form, nombreLP) {\r    if(get(\"formulario.cbFormaCalculo\")==get(\"formulario.oid_Forma_Calc_Base_Calc\") \r    && get('formulario.cbBaseCalculo')== get('formulario.oidBC_Calculo_Monto')){\r		if(!sicc_validaciones_generales('Obligatorio')) {\r			return;\r        }	\r    }\r         \r    if(!sicc_validaciones_generales('grupoCamposNumericos')) {\r		return;\r    }\r\r    onClickPestanyaHabilitada(valor, form, nombreLP);\r}\r\r\r \r"));
      ((Element)v.get(1)).appendChild((Text)v.get(2));

      /* Termina nodo Texto:2   */
      /* Termina nodo:1   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","pestanyas_concurso_inc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(6)).setAttribute("name","txtNumPeriodosEvaluar" );
      ((Element)v.get(6)).setAttribute("group","grupoCamposNumericos" );
      ((Element)v.get(6)).setAttribute("required","false" );
      ((Element)v.get(6)).setAttribute("cod","1675" );
      ((Element)v.get(6)).setAttribute("format","e" );
      ((Element)v.get(6)).setAttribute("min","0" );
      ((Element)v.get(6)).setAttribute("max","99" );
      ((Element)v.get(5)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","txtNumMinPedidos" );
      ((Element)v.get(7)).setAttribute("group","grupoCamposNumericos" );
      ((Element)v.get(7)).setAttribute("required","false" );
      ((Element)v.get(7)).setAttribute("cod","1676" );
      ((Element)v.get(7)).setAttribute("format","e" );
      ((Element)v.get(7)).setAttribute("min","0" );
      ((Element)v.get(7)).setAttribute("max","999" );
      ((Element)v.get(5)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","txtNumMinPedidosRecomendada" );
      ((Element)v.get(8)).setAttribute("group","grupoCamposNumericos" );
      ((Element)v.get(8)).setAttribute("required","false" );
      ((Element)v.get(8)).setAttribute("cod","2423" );
      ((Element)v.get(8)).setAttribute("format","e" );
      ((Element)v.get(8)).setAttribute("min","0" );
      ((Element)v.get(8)).setAttribute("max","999" );
      ((Element)v.get(5)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","cbTipoVenta" );
      ((Element)v.get(9)).setAttribute("group","Obligatorio" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","1622" );
      ((Element)v.get(5)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */
      /* Termina nodo:5   */

      /* Empieza nodo:10 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(10)).setAttribute("nombre","formulario" );
      ((Element)v.get(10)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(10));

      /* Empieza nodo:11 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","accion" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","idPestanyaDest" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","datosObligatorios" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","oidBaseCalculo" );
      ((Element)v.get(18)).setAttribute("valor","" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(10)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","oidVariablesVenta" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hidIndGerentes" );
      ((Element)v.get(20)).setAttribute("valor","0" );
      ((Element)v.get(10)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hidListaClasif" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","hidLstClasConsul" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","hidLstMVR" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","hidVariablesVenta" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","tengoLstMVR" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","tengoVariablesVenta" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","oidParamGerentes" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","oidFormaCalculo" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","oidPlantillaBaseCalculo" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","oidParamBaseCalculo" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","hidConstantesPestINC" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","oidBC_Recomendada" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","oidBC_Calculo_Monto" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","oid_Forma_Calc_Base_Calc" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","oid_Forma_Calc_Vbles_Vta" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","oidTipoVta" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","ocultaParticipante" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","hidRecomendacionEfectiva" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","hidPeriodoInicialEval" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","hidNroPeriodosEvaluar" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(41)).setAttribute("nombre","hidNroMinimoPedidos" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","hidNroMinPedidosReco" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","hIndEstadoProductos" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","hIndEstadoAmbitoGeografico" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","hIndEstadoCalificion" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","hIndEstadoGerentes" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","hIndEstadoConsultoras" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","hIndEstadoProgramaNuevas" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","hIndEstadoMultinivel" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","hIndFaseCalificacion" );
      ((Element)v.get(50)).setAttribute("valor","0" );
      ((Element)v.get(10)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(51)).setAttribute("nombre","seleccFormaCalculo" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(52)).setAttribute("nombre","oidBaseCalculoTemp" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(53)).setAttribute("nombre","oidTipoVentaPlantilla" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 10   */
      v.add(doc.createElement("table"));
      ((Element)v.get(54)).setAttribute("width","100%" );
      ((Element)v.get(54)).setAttribute("height","100%" );
      ((Element)v.get(54)).setAttribute("border","0" );
      ((Element)v.get(54)).setAttribute("align","center" );
      ((Element)v.get(54)).setAttribute("cellpadding","0" );
      ((Element)v.get(54)).setAttribute("cellspacing","0" );
      ((Element)v.get(54)).setAttribute("class","menu4" );
      ((Element)v.get(10)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(54)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).setAttribute("width","12" );
      ((Element)v.get(56)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(56)).setAttribute("class","menu5texto" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(57)).setAttribute("src","b.gif" );
      ((Element)v.get(57)).setAttribute("width","12" );
      ((Element)v.get(57)).setAttribute("height","30" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:58 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(58)).setAttribute("class","menu5texto" );
      ((Element)v.get(55)).appendChild((Element)v.get(58));

      /* Elemento padre:58 / Elemento actual: 59   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(58)).appendChild((Text)v.get(59));

      /* Termina nodo Texto:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:60 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).setAttribute("width","10" );
      ((Element)v.get(60)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(60)).setAttribute("class","menu5texto" );
      ((Element)v.get(55)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(61)).setAttribute("src","b.gif" );
      ((Element)v.get(61)).setAttribute("width","10" );
      ((Element)v.get(61)).setAttribute("height","8" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:62 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).setAttribute("width","92" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(62)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(62)).setAttribute("class","menu5texto" );
      ((Element)v.get(55)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("table"));
      ((Element)v.get(63)).setAttribute("width","75" );
      ((Element)v.get(63)).setAttribute("border","1" );
      ((Element)v.get(63)).setAttribute("align","center" );
      ((Element)v.get(63)).setAttribute("cellpadding","1" );
      ((Element)v.get(63)).setAttribute("cellspacing","0" );
      ((Element)v.get(63)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(63)).setAttribute("onmouseover","activarPuntero('formulario',1,'lblParametrosGenerales');" );
      ((Element)v.get(63)).setAttribute("onclick","onClickPestanyaPaginaGerentes(1,'formulario','LPMantenerParametrosGerentes');" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(64)).setAttribute("align","center" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(66)).setAttribute("nombre","lblParametrosGenerales" );
      ((Element)v.get(66)).setAttribute("alto","13" );
      ((Element)v.get(66)).setAttribute("filas","1" );
      ((Element)v.get(66)).setAttribute("valor","" );
      ((Element)v.get(66)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(66)).setAttribute("cod","00393" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */
      /* Termina nodo:64   */
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:67 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(67)).setAttribute("width","10" );
      ((Element)v.get(67)).setAttribute("class","menu5texto" );
      ((Element)v.get(55)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(68)).setAttribute("src","b.gif" );
      ((Element)v.get(68)).setAttribute("width","10" );
      ((Element)v.get(68)).setAttribute("height","8" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:69 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).setAttribute("width","20" );
      ((Element)v.get(69)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(69)).setAttribute("class","menu5texto" );
      ((Element)v.get(55)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("table"));
      ((Element)v.get(70)).setAttribute("width","75" );
      ((Element)v.get(70)).setAttribute("border","1" );
      ((Element)v.get(70)).setAttribute("align","center" );
      ((Element)v.get(70)).setAttribute("cellpadding","1" );
      ((Element)v.get(70)).setAttribute("cellspacing","0" );
      ((Element)v.get(70)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(70)).setAttribute("onmouseover","activarPuntero('formulario',5,'lblProductos');" );
      ((Element)v.get(70)).setAttribute("onclick","onClickPestanyaPaginaGerentes(5,'formulario','LPMantenerParametrosGerentes');" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(71)).setAttribute("align","center" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(73)).setAttribute("nombre","lblProductos" );
      ((Element)v.get(73)).setAttribute("alto","13" );
      ((Element)v.get(73)).setAttribute("filas","1" );
      ((Element)v.get(73)).setAttribute("valor","" );
      ((Element)v.get(73)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(73)).setAttribute("cod","0094" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */
      /* Termina nodo:71   */
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:74 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).setAttribute("width","10" );
      ((Element)v.get(74)).setAttribute("class","menu5texto" );
      ((Element)v.get(55)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(75)).setAttribute("src","b.gif" );
      ((Element)v.get(75)).setAttribute("width","10" );
      ((Element)v.get(75)).setAttribute("height","8" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:76 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(76)).setAttribute("width","20" );
      ((Element)v.get(76)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(76)).setAttribute("class","menu5texto" );
      ((Element)v.get(55)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("table"));
      ((Element)v.get(77)).setAttribute("width","75" );
      ((Element)v.get(77)).setAttribute("border","1" );
      ((Element)v.get(77)).setAttribute("align","center" );
      ((Element)v.get(77)).setAttribute("cellpadding","1" );
      ((Element)v.get(77)).setAttribute("cellspacing","0" );
      ((Element)v.get(77)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(77)).setAttribute("onmouseover","activarPuntero('formulario',6,'lblPremios');" );
      ((Element)v.get(77)).setAttribute("onclick","onClickPestanyaPaginaGerentes(6,'formulario','LPMantenerParametrosGerentes');" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("tr"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(78)).setAttribute("align","center" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(80)).setAttribute("nombre","lblPremios" );
      ((Element)v.get(80)).setAttribute("alto","13" );
      ((Element)v.get(80)).setAttribute("filas","1" );
      ((Element)v.get(80)).setAttribute("valor","" );
      ((Element)v.get(80)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(80)).setAttribute("cod","00394" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */
      /* Termina nodo:78   */
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:81 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(81)).setAttribute("width","10" );
      ((Element)v.get(81)).setAttribute("class","menu5texto" );
      ((Element)v.get(55)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(82)).setAttribute("src","b.gif" );
      ((Element)v.get(82)).setAttribute("width","10" );
      ((Element)v.get(82)).setAttribute("height","8" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:83 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).setAttribute("width","20" );
      ((Element)v.get(83)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(83)).setAttribute("class","menu5texto" );
      ((Element)v.get(55)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("table"));
      ((Element)v.get(84)).setAttribute("width","75" );
      ((Element)v.get(84)).setAttribute("border","1" );
      ((Element)v.get(84)).setAttribute("align","center" );
      ((Element)v.get(84)).setAttribute("cellpadding","1" );
      ((Element)v.get(84)).setAttribute("cellspacing","0" );
      ((Element)v.get(84)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(84)).setAttribute("onmouseover","activarPuntero('formulario',7,'lblRequisitos');" );
      ((Element)v.get(84)).setAttribute("onclick","onClickPestanyaPaginaGerentes(7,'formulario','LPMantenerParametrosGerentes');" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(85)).setAttribute("align","center" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(86)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(87)).setAttribute("nombre","lblRequisitos" );
      ((Element)v.get(87)).setAttribute("alto","13" );
      ((Element)v.get(87)).setAttribute("filas","1" );
      ((Element)v.get(87)).setAttribute("valor","" );
      ((Element)v.get(87)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(87)).setAttribute("cod","00395" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */
      /* Termina nodo:85   */
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:88 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).setAttribute("width","10" );
      ((Element)v.get(88)).setAttribute("class","menu5texto" );
      ((Element)v.get(55)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(89)).setAttribute("src","b.gif" );
      ((Element)v.get(89)).setAttribute("width","10" );
      ((Element)v.get(89)).setAttribute("height","8" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */

      /* Empieza nodo:90 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).setAttribute("width","20" );
      ((Element)v.get(90)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(90)).setAttribute("class","menu5texto" );
      ((Element)v.get(55)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("table"));
      ((Element)v.get(91)).setAttribute("width","75" );
      ((Element)v.get(91)).setAttribute("border","1" );
      ((Element)v.get(91)).setAttribute("align","center" );
      ((Element)v.get(91)).setAttribute("cellpadding","1" );
      ((Element)v.get(91)).setAttribute("cellspacing","0" );
      ((Element)v.get(91)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(91)).setAttribute("onmouseover","activarPuntero('formulario',4,'lblObtencionPuntos');" );
      ((Element)v.get(91)).setAttribute("onclick","onClickPestanyaPaginaGerentes(4,'formulario','LPMantenerParametrosGerentes');" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(92)).setAttribute("align","center" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(94)).setAttribute("nombre","lblObtencionPuntos" );
      ((Element)v.get(94)).setAttribute("alto","13" );
      ((Element)v.get(94)).setAttribute("filas","1" );
      ((Element)v.get(94)).setAttribute("valor","" );
      ((Element)v.get(94)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(94)).setAttribute("cod","00396" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */
      /* Termina nodo:92   */
      /* Termina nodo:91   */
      /* Termina nodo:90   */

      /* Empieza nodo:95 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(95)).setAttribute("width","10" );
      ((Element)v.get(95)).setAttribute("class","menu5texto" );
      ((Element)v.get(55)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(96)).setAttribute("src","b.gif" );
      ((Element)v.get(96)).setAttribute("width","10" );
      ((Element)v.get(96)).setAttribute("height","8" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */

      /* Empieza nodo:97 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).setAttribute("width","20" );
      ((Element)v.get(97)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(97)).setAttribute("class","menu5texto" );
      ((Element)v.get(55)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("table"));
      ((Element)v.get(98)).setAttribute("width","75" );
      ((Element)v.get(98)).setAttribute("border","1" );
      ((Element)v.get(98)).setAttribute("align","center" );
      ((Element)v.get(98)).setAttribute("cellpadding","1" );
      ((Element)v.get(98)).setAttribute("cellspacing","0" );
      ((Element)v.get(98)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(98)).setAttribute("onmouseover","activarPuntero('formulario',8,'lblDespachoPremios');" );
      ((Element)v.get(98)).setAttribute("onclick","onClickPestanyaPaginaGerentes(8,'formulario','LPMantenerParametrosGerentes');" );
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
      ((Element)v.get(101)).setAttribute("nombre","lblDespachoPremios" );
      ((Element)v.get(101)).setAttribute("alto","13" );
      ((Element)v.get(101)).setAttribute("filas","1" );
      ((Element)v.get(101)).setAttribute("valor","" );
      ((Element)v.get(101)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(101)).setAttribute("cod","00397" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */
      /* Termina nodo:99   */
      /* Termina nodo:98   */
      /* Termina nodo:97   */

      /* Empieza nodo:102 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).setAttribute("width","16" );
      ((Element)v.get(102)).setAttribute("class","menu5texto" );
      ((Element)v.get(55)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(103)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).setAttribute("width","12" );
      ((Element)v.get(103)).setAttribute("height","8" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */
      /* Termina nodo:55   */
      /* Termina nodo:54   */

      /* Empieza nodo:104 / Elemento padre: 10   */
      v.add(doc.createElement("table"));
      ((Element)v.get(104)).setAttribute("width","100%" );
      ((Element)v.get(104)).setAttribute("height","100%" );
      ((Element)v.get(104)).setAttribute("border","0" );
      ((Element)v.get(104)).setAttribute("align","center" );
      ((Element)v.get(104)).setAttribute("cellpadding","0" );
      ((Element)v.get(104)).setAttribute("cellspacing","0" );
      ((Element)v.get(104)).setAttribute("class","menu4" );
      ((Element)v.get(10)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(104)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(106)).setAttribute("width","12" );
      ((Element)v.get(106)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(106)).setAttribute("class","menu5texto" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(107)).setAttribute("src","b.gif" );
      ((Element)v.get(107)).setAttribute("width","12" );
      ((Element)v.get(107)).setAttribute("height","30" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */

      /* Empieza nodo:108 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(108)).setAttribute("class","menu5texto" );
      ((Element)v.get(105)).appendChild((Element)v.get(108));

      /* Elemento padre:108 / Elemento actual: 109   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(108)).appendChild((Text)v.get(109));

      /* Termina nodo Texto:109   */
      /* Termina nodo:108   */

      /* Empieza nodo:110 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).setAttribute("width","10" );
      ((Element)v.get(110)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(110)).setAttribute("class","menu5texto" );
      ((Element)v.get(105)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(111)).setAttribute("src","b.gif" );
      ((Element)v.get(111)).setAttribute("width","10" );
      ((Element)v.get(111)).setAttribute("height","8" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:112 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).setAttribute("width","70" );
      ((Element)v.get(112)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(112)).setAttribute("class","menu5texto" );
      ((Element)v.get(105)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("table"));
      ((Element)v.get(113)).setAttribute("width","75" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(113)).setAttribute("border","1" );
      ((Element)v.get(113)).setAttribute("align","center" );
      ((Element)v.get(113)).setAttribute("cellpadding","1" );
      ((Element)v.get(113)).setAttribute("cellspacing","0" );
      ((Element)v.get(113)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(113)).setAttribute("onmouseover","activarPuntero('formulario',3,'lblAmbitoGeografico');" );
      ((Element)v.get(113)).setAttribute("onclick","onClickPestanyaPaginaGerentes(3,'formulario','LPMantenerParametrosGerentes');" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(114)).setAttribute("align","center" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(116)).setAttribute("nombre","lblAmbitoGeografico" );
      ((Element)v.get(116)).setAttribute("alto","13" );
      ((Element)v.get(116)).setAttribute("filas","1" );
      ((Element)v.get(116)).setAttribute("valor","" );
      ((Element)v.get(116)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(116)).setAttribute("cod","2801" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */
      /* Termina nodo:114   */
      /* Termina nodo:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:117 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(117)).setAttribute("width","10" );
      ((Element)v.get(117)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(117)).setAttribute("class","menu5texto" );
      ((Element)v.get(105)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(118)).setAttribute("src","b.gif" );
      ((Element)v.get(118)).setAttribute("width","10" );
      ((Element)v.get(118)).setAttribute("height","8" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:119 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).setAttribute("width","70" );
      ((Element)v.get(119)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(119)).setAttribute("class","menu5texto" );
      ((Element)v.get(105)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("table"));
      ((Element)v.get(120)).setAttribute("width","75" );
      ((Element)v.get(120)).setAttribute("border","1" );
      ((Element)v.get(120)).setAttribute("align","center" );
      ((Element)v.get(120)).setAttribute("cellpadding","1" );
      ((Element)v.get(120)).setAttribute("cellspacing","0" );
      ((Element)v.get(120)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(120)).setAttribute("onmouseover","activarPuntero('formulario',9,'lblCalificacion');" );
      ((Element)v.get(120)).setAttribute("onclick","onClickPestanyaPaginaGerentes(9,'formulario','LPMantenerParametrosGerentes');" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(121)).setAttribute("align","center" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(123)).setAttribute("nombre","lblCalificacion" );
      ((Element)v.get(123)).setAttribute("alto","13" );
      ((Element)v.get(123)).setAttribute("filas","1" );
      ((Element)v.get(123)).setAttribute("valor","" );
      ((Element)v.get(123)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(123)).setAttribute("cod","00398" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:122   */
      /* Termina nodo:121   */
      /* Termina nodo:120   */
      /* Termina nodo:119   */

      /* Empieza nodo:124 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).setAttribute("width","10" );
      ((Element)v.get(124)).setAttribute("class","menu5texto" );
      ((Element)v.get(105)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(125)).setAttribute("src","b.gif" );
      ((Element)v.get(125)).setAttribute("width","10" );
      ((Element)v.get(125)).setAttribute("height","8" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */

      /* Empieza nodo:126 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).setAttribute("width","20" );
      ((Element)v.get(126)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(126)).setAttribute("class","menu5texto" );
      ((Element)v.get(105)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("table"));
      ((Element)v.get(127)).setAttribute("width","75" );
      ((Element)v.get(127)).setAttribute("border","1" );
      ((Element)v.get(127)).setAttribute("align","center" );
      ((Element)v.get(127)).setAttribute("cellpadding","1" );
      ((Element)v.get(127)).setAttribute("cellspacing","0" );
      ((Element)v.get(127)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(127)).setAttribute("bgcolor","##496A9A" );
      ((Element)v.get(127)).setAttribute("onmouseover","" );
      ((Element)v.get(127)).setAttribute("onclick","" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(128)).setAttribute("align","center" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
   }

   private void getXML630(Document doc) {
      ((Element)v.get(129)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(130)).setAttribute("nombre","lblGerentes" );
      ((Element)v.get(130)).setAttribute("alto","13" );
      ((Element)v.get(130)).setAttribute("filas","1" );
      ((Element)v.get(130)).setAttribute("valor","" );
      ((Element)v.get(130)).setAttribute("id","menu5textoblanca" );
      ((Element)v.get(130)).setAttribute("cod","00399" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */
      /* Termina nodo:128   */
      /* Termina nodo:127   */
      /* Termina nodo:126   */

      /* Empieza nodo:131 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(131)).setAttribute("width","10" );
      ((Element)v.get(131)).setAttribute("class","menu5texto" );
      ((Element)v.get(105)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(132)).setAttribute("src","b.gif" );
      ((Element)v.get(132)).setAttribute("width","10" );
      ((Element)v.get(132)).setAttribute("height","8" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */

      /* Empieza nodo:133 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).setAttribute("width","20" );
      ((Element)v.get(133)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(133)).setAttribute("class","menu5texto" );
      ((Element)v.get(105)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("table"));
      ((Element)v.get(134)).setAttribute("width","75" );
      ((Element)v.get(134)).setAttribute("border","1" );
      ((Element)v.get(134)).setAttribute("align","center" );
      ((Element)v.get(134)).setAttribute("cellpadding","1" );
      ((Element)v.get(134)).setAttribute("cellspacing","0" );
      ((Element)v.get(134)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(134)).setAttribute("onmouseover","activarPuntero('formulario',11,'lblConsultoras');" );
      ((Element)v.get(134)).setAttribute("onclick","onClickPestanyaPaginaGerentes(11,'formulario','LPMantenerParametrosGerentes');" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(135)).setAttribute("align","center" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(137)).setAttribute("nombre","lblConsultoras" );
      ((Element)v.get(137)).setAttribute("alto","13" );
      ((Element)v.get(137)).setAttribute("filas","1" );
      ((Element)v.get(137)).setAttribute("valor","" );
      ((Element)v.get(137)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(137)).setAttribute("cod","00401" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */
      /* Termina nodo:135   */
      /* Termina nodo:134   */
      /* Termina nodo:133   */

      /* Empieza nodo:138 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(138)).setAttribute("width","10" );
      ((Element)v.get(138)).setAttribute("class","menu5texto" );
      ((Element)v.get(105)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(139)).setAttribute("src","b.gif" );
      ((Element)v.get(139)).setAttribute("width","10" );
      ((Element)v.get(139)).setAttribute("height","8" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:138   */

      /* Empieza nodo:140 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).setAttribute("width","20" );
      ((Element)v.get(140)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(140)).setAttribute("class","menu5texto" );
      ((Element)v.get(105)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("table"));
      ((Element)v.get(141)).setAttribute("width","75" );
      ((Element)v.get(141)).setAttribute("border","1" );
      ((Element)v.get(141)).setAttribute("align","center" );
      ((Element)v.get(141)).setAttribute("cellpadding","1" );
      ((Element)v.get(141)).setAttribute("cellspacing","0" );
      ((Element)v.get(141)).setAttribute("ID","DatosGenerales" );
      ((Element)v.get(141)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(141)).setAttribute("onmouseover","activarPuntero('formulario',2,'lblProgramaNuevas');" );
      ((Element)v.get(141)).setAttribute("onclick","onClickPestanyaPaginaGerentes(2,'formulario','LPMantenerParametrosGerentes');" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(142)).setAttribute("align","center" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(143)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(144)).setAttribute("nombre","lblProgramaNuevas" );
      ((Element)v.get(144)).setAttribute("alto","13" );
      ((Element)v.get(144)).setAttribute("filas","1" );
      ((Element)v.get(144)).setAttribute("valor","" );
      ((Element)v.get(144)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(144)).setAttribute("cod","00590" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */
      /* Termina nodo:142   */
      /* Termina nodo:141   */
      /* Termina nodo:140   */

      /* Empieza nodo:145 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(145)).setAttribute("width","10" );
      ((Element)v.get(145)).setAttribute("class","menu5texto" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(105)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(146)).setAttribute("src","b.gif" );
      ((Element)v.get(146)).setAttribute("width","10" );
      ((Element)v.get(146)).setAttribute("height","8" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */

      /* Empieza nodo:147 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).setAttribute("width","20" );
      ((Element)v.get(147)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(147)).setAttribute("class","menu5texto" );
      ((Element)v.get(105)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("table"));
      ((Element)v.get(148)).setAttribute("width","75" );
      ((Element)v.get(148)).setAttribute("border","1" );
      ((Element)v.get(148)).setAttribute("align","center" );
      ((Element)v.get(148)).setAttribute("cellpadding","1" );
      ((Element)v.get(148)).setAttribute("cellspacing","0" );
      ((Element)v.get(148)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(148)).setAttribute("onmouseover","activarPuntero('formulario',12,'lblMultinivel');" );
      ((Element)v.get(148)).setAttribute("onclick","onClickPestanyaPaginaGerentes(12,'formulario','LPMantenerParametrosGerentes');" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(149)).setAttribute("align","center" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(151)).setAttribute("nombre","lblMultinivel" );
      ((Element)v.get(151)).setAttribute("alto","13" );
      ((Element)v.get(151)).setAttribute("filas","1" );
      ((Element)v.get(151)).setAttribute("valor","" );
      ((Element)v.get(151)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(151)).setAttribute("cod","00400" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:150   */
      /* Termina nodo:149   */
      /* Termina nodo:148   */
      /* Termina nodo:147   */

      /* Empieza nodo:152 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(152)).setAttribute("width","16" );
      ((Element)v.get(152)).setAttribute("class","menu5texto" );
      ((Element)v.get(105)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(153)).setAttribute("src","b.gif" );
      ((Element)v.get(153)).setAttribute("width","12" );
      ((Element)v.get(153)).setAttribute("height","8" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:152   */
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:154 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(154)).setAttribute("nombre","capa1" );
      ((Element)v.get(154)).setAttribute("alto","110" );
      ((Element)v.get(154)).setAttribute("ancho","100%" );
      ((Element)v.get(154)).setAttribute("colorf","" );
      ((Element)v.get(154)).setAttribute("borde","0" );
      ((Element)v.get(154)).setAttribute("imagenf","" );
      ((Element)v.get(154)).setAttribute("repeat","" );
      ((Element)v.get(154)).setAttribute("padding","" );
      ((Element)v.get(154)).setAttribute("visibilidad","visible" );
      ((Element)v.get(154)).setAttribute("contravsb","" );
      ((Element)v.get(154)).setAttribute("x","0" );
      ((Element)v.get(154)).setAttribute("y","70" );
      ((Element)v.get(154)).setAttribute("zindex","" );
      ((Element)v.get(10)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("table"));
      ((Element)v.get(155)).setAttribute("width","100%" );
      ((Element)v.get(155)).setAttribute("border","0" );
      ((Element)v.get(155)).setAttribute("cellspacing","0" );
      ((Element)v.get(155)).setAttribute("cellpadding","0" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(155)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("td"));
      ((Element)v.get(157)).setAttribute("width","12" );
      ((Element)v.get(157)).setAttribute("align","center" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(158)).setAttribute("src","b.gif" );
      ((Element)v.get(158)).setAttribute("width","12" );
      ((Element)v.get(158)).setAttribute("height","12" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:159 / Elemento padre: 156   */
      v.add(doc.createElement("td"));
      ((Element)v.get(159)).setAttribute("width","750" );
      ((Element)v.get(156)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(160)).setAttribute("src","b.gif" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:159   */

      /* Empieza nodo:161 / Elemento padre: 156   */
      v.add(doc.createElement("td"));
      ((Element)v.get(161)).setAttribute("width","12" );
      ((Element)v.get(156)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(162)).setAttribute("src","b.gif" );
      ((Element)v.get(162)).setAttribute("width","12" );
      ((Element)v.get(162)).setAttribute("height","1" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */
      /* Termina nodo:161   */
      /* Termina nodo:156   */

      /* Empieza nodo:163 / Elemento padre: 155   */
   }

   private void getXML810(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(155)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(165)).setAttribute("src","b.gif" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:164   */

      /* Empieza nodo:166 / Elemento padre: 163   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(166)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(168)).setAttribute("class","legend" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(169)).setAttribute("nombre","lblDatosAdicionales" );
      ((Element)v.get(169)).setAttribute("alto","13" );
      ((Element)v.get(169)).setAttribute("filas","1" );
      ((Element)v.get(169)).setAttribute("valor","" );
      ((Element)v.get(169)).setAttribute("id","legend" );
      ((Element)v.get(169)).setAttribute("cod","0052" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */
      /* Termina nodo:168   */

      /* Empieza nodo:170 / Elemento padre: 167   */
      v.add(doc.createElement("table"));
      ((Element)v.get(170)).setAttribute("width","100%" );
      ((Element)v.get(170)).setAttribute("border","0" );
      ((Element)v.get(170)).setAttribute("align","center" );
      ((Element)v.get(170)).setAttribute("cellspacing","0" );
      ((Element)v.get(170)).setAttribute("cellpadding","0" );
      ((Element)v.get(167)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(170)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("td"));
      ((Element)v.get(171)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("table"));
      ((Element)v.get(173)).setAttribute("width","696" );
      ((Element)v.get(173)).setAttribute("border","0" );
      ((Element)v.get(173)).setAttribute("align","left" );
      ((Element)v.get(173)).setAttribute("cellspacing","0" );
      ((Element)v.get(173)).setAttribute("cellpadding","0" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(173)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).setAttribute("colspan","4" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(176)).setAttribute("src","b.gif" );
      ((Element)v.get(176)).setAttribute("width","8" );
      ((Element)v.get(176)).setAttribute("height","8" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:175   */
      /* Termina nodo:174   */

      /* Empieza nodo:177 / Elemento padre: 173   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(173)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(177)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(179)).setAttribute("src","b.gif" );
      ((Element)v.get(179)).setAttribute("width","8" );
      ((Element)v.get(179)).setAttribute("height","8" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:178   */

      /* Empieza nodo:180 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(177)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(181)).setAttribute("nombre","lblFormaCalculo1" );
      ((Element)v.get(181)).setAttribute("alto","13" );
      ((Element)v.get(181)).setAttribute("filas","1" );
      ((Element)v.get(181)).setAttribute("valor","" );
      ((Element)v.get(181)).setAttribute("id","datosTitle" );
      ((Element)v.get(181)).setAttribute("cod","1671" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:180   */

      /* Empieza nodo:182 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(182)).setAttribute("width","100%" );
      ((Element)v.get(177)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(183)).setAttribute("src","b.gif" );
      ((Element)v.get(183)).setAttribute("width","266" );
      ((Element)v.get(183)).setAttribute("height","8" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:182   */
      /* Termina nodo:177   */

      /* Empieza nodo:184 / Elemento padre: 173   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(173)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("td"));
      ((Element)v.get(184)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(186)).setAttribute("src","b.gif" );
      ((Element)v.get(186)).setAttribute("width","8" );
      ((Element)v.get(186)).setAttribute("height","8" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:187 / Elemento padre: 184   */
      v.add(doc.createElement("td"));
      ((Element)v.get(187)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(184)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("COMBO"));
   }

   private void getXML900(Document doc) {
      ((Element)v.get(188)).setAttribute("nombre","cbFormaCalculo" );
      ((Element)v.get(188)).setAttribute("id","datosCampos" );
      ((Element)v.get(188)).setAttribute("size","1" );
      ((Element)v.get(188)).setAttribute("multiple","N" );
      ((Element)v.get(188)).setAttribute("req","S" );
      ((Element)v.get(188)).setAttribute("valorinicial","" );
      ((Element)v.get(188)).setAttribute("textoinicial","" );
      ((Element)v.get(188)).setAttribute("onshtab","focoComboTipoVenta();" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(188)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */
      /* Termina nodo:188   */
      /* Termina nodo:187   */

      /* Empieza nodo:190 / Elemento padre: 184   */
      v.add(doc.createElement("td"));
      ((Element)v.get(190)).setAttribute("width","100%" );
      ((Element)v.get(184)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(191)).setAttribute("src","b.gif" );
      ((Element)v.get(191)).setAttribute("width","8" );
      ((Element)v.get(191)).setAttribute("height","8" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */
      /* Termina nodo:190   */
      /* Termina nodo:184   */

      /* Empieza nodo:192 / Elemento padre: 173   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(173)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).setAttribute("colspan","4" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(194)).setAttribute("src","b.gif" );
      ((Element)v.get(194)).setAttribute("width","8" );
      ((Element)v.get(194)).setAttribute("height","8" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */
      /* Termina nodo:193   */
      /* Termina nodo:192   */
      /* Termina nodo:173   */
      /* Termina nodo:172   */
      /* Termina nodo:171   */
      /* Termina nodo:170   */
      /* Termina nodo:167   */
      /* Termina nodo:166   */

      /* Empieza nodo:195 / Elemento padre: 163   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(196)).setAttribute("src","b.gif" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:195   */
      /* Termina nodo:163   */

      /* Empieza nodo:197 / Elemento padre: 155   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(155)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("td"));
      ((Element)v.get(197)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(199)).setAttribute("src","b.gif" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */
      /* Termina nodo:198   */

      /* Empieza nodo:200 / Elemento padre: 197   */
      v.add(doc.createElement("td"));
      ((Element)v.get(197)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(200)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("table"));
      ((Element)v.get(202)).setAttribute("width","100%" );
      ((Element)v.get(202)).setAttribute("border","0" );
      ((Element)v.get(202)).setAttribute("align","center" );
      ((Element)v.get(202)).setAttribute("cellspacing","0" );
      ((Element)v.get(202)).setAttribute("cellpadding","0" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(202)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("td"));
      ((Element)v.get(204)).setAttribute("class","botonera" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(205)).setAttribute("nombre","btnAceptar1" );
      ((Element)v.get(205)).setAttribute("ID","botonContenido" );
      ((Element)v.get(205)).setAttribute("tipo","html" );
      ((Element)v.get(205)).setAttribute("accion","accionAceptar();" );
      ((Element)v.get(205)).setAttribute("estado","false" );
      ((Element)v.get(205)).setAttribute("cod","12" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */

      /* Empieza nodo:206 / Elemento padre: 204   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(206)).setAttribute("nombre","btnParticipantes" );
      ((Element)v.get(206)).setAttribute("ID","botonContenido" );
      ((Element)v.get(206)).setAttribute("tipo","html" );
      ((Element)v.get(206)).setAttribute("accion","onClickParticipantes();" );
      ((Element)v.get(206)).setAttribute("estado","false" );
      ((Element)v.get(206)).setAttribute("cod","745" );
      ((Element)v.get(204)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:204   */
      /* Termina nodo:203   */
      /* Termina nodo:202   */
      /* Termina nodo:201   */
      /* Termina nodo:200   */

      /* Empieza nodo:207 / Elemento padre: 197   */
      v.add(doc.createElement("td"));
      ((Element)v.get(197)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(208)).setAttribute("src","b.gif" );
      ((Element)v.get(208)).setAttribute("width","8" );
      ((Element)v.get(208)).setAttribute("height","12" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */
      /* Termina nodo:207   */
      /* Termina nodo:197   */

      /* Empieza nodo:209 / Elemento padre: 155   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(155)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(210)).setAttribute("width","12" );
      ((Element)v.get(210)).setAttribute("align","center" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(211)).setAttribute("src","b.gif" );
      ((Element)v.get(211)).setAttribute("width","12" );
      ((Element)v.get(211)).setAttribute("height","12" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */
      /* Termina nodo:210   */

      /* Empieza nodo:212 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(212)).setAttribute("width","756" );
      ((Element)v.get(209)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(213)).setAttribute("src","b.gif" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */
      /* Termina nodo:212   */

      /* Empieza nodo:214 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(214)).setAttribute("width","12" );
      ((Element)v.get(209)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(215)).setAttribute("src","b.gif" );
      ((Element)v.get(215)).setAttribute("width","12" );
      ((Element)v.get(215)).setAttribute("height","1" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */
      /* Termina nodo:214   */
      /* Termina nodo:209   */
      /* Termina nodo:155   */
      /* Termina nodo:154   */

      /* Empieza nodo:216 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(216)).setAttribute("nombre","capa2" );
      ((Element)v.get(216)).setAttribute("alto","110" );
      ((Element)v.get(216)).setAttribute("ancho","100%" );
      ((Element)v.get(216)).setAttribute("colorf","" );
      ((Element)v.get(216)).setAttribute("borde","0" );
      ((Element)v.get(216)).setAttribute("imagenf","" );
      ((Element)v.get(216)).setAttribute("repeat","" );
      ((Element)v.get(216)).setAttribute("padding","" );
      ((Element)v.get(216)).setAttribute("visibilidad","visible" );
      ((Element)v.get(216)).setAttribute("contravsb","" );
      ((Element)v.get(216)).setAttribute("x","0" );
      ((Element)v.get(216)).setAttribute("y","175" );
      ((Element)v.get(216)).setAttribute("zindex","" );
      ((Element)v.get(10)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("table"));
      ((Element)v.get(217)).setAttribute("width","100%" );
      ((Element)v.get(217)).setAttribute("border","0" );
      ((Element)v.get(217)).setAttribute("cellspacing","0" );
      ((Element)v.get(217)).setAttribute("cellpadding","0" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(217)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("td"));
      ((Element)v.get(219)).setAttribute("width","12" );
      ((Element)v.get(219)).setAttribute("align","center" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(220)).setAttribute("src","b.gif" );
      ((Element)v.get(220)).setAttribute("width","12" );
      ((Element)v.get(220)).setAttribute("height","12" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */
      /* Termina nodo:219   */

      /* Empieza nodo:221 / Elemento padre: 218   */
      v.add(doc.createElement("td"));
      ((Element)v.get(221)).setAttribute("width","750" );
      ((Element)v.get(218)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(222)).setAttribute("src","b.gif" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */
      /* Termina nodo:221   */

      /* Empieza nodo:223 / Elemento padre: 218   */
      v.add(doc.createElement("td"));
      ((Element)v.get(223)).setAttribute("width","12" );
      ((Element)v.get(218)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(224)).setAttribute("src","b.gif" );
      ((Element)v.get(224)).setAttribute("width","12" );
      ((Element)v.get(224)).setAttribute("height","1" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */
      /* Termina nodo:223   */
      /* Termina nodo:218   */

      /* Empieza nodo:225 / Elemento padre: 217   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(217)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("td"));
      ((Element)v.get(225)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(227)).setAttribute("src","b.gif" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */
      /* Termina nodo:226   */

      /* Empieza nodo:228 / Elemento padre: 225   */
      v.add(doc.createElement("td"));
      ((Element)v.get(225)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(228)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(230)).setAttribute("class","legend" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(231)).setAttribute("nombre","lblFormaCalculo2" );
      ((Element)v.get(231)).setAttribute("alto","13" );
      ((Element)v.get(231)).setAttribute("filas","1" );
      ((Element)v.get(231)).setAttribute("valor","" );
      ((Element)v.get(231)).setAttribute("id","legend" );
      ((Element)v.get(231)).setAttribute("cod","00288" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */
      /* Termina nodo:230   */

      /* Empieza nodo:232 / Elemento padre: 229   */
      v.add(doc.createElement("table"));
      ((Element)v.get(232)).setAttribute("width","100%" );
      ((Element)v.get(232)).setAttribute("border","0" );
      ((Element)v.get(232)).setAttribute("align","center" );
      ((Element)v.get(232)).setAttribute("cellspacing","0" );
      ((Element)v.get(232)).setAttribute("cellpadding","0" );
      ((Element)v.get(229)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
   }

   private void getXML1080(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(232)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("td"));
      ((Element)v.get(233)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("table"));
      ((Element)v.get(235)).setAttribute("width","696" );
      ((Element)v.get(235)).setAttribute("border","0" );
      ((Element)v.get(235)).setAttribute("align","left" );
      ((Element)v.get(235)).setAttribute("cellspacing","0" );
      ((Element)v.get(235)).setAttribute("cellpadding","0" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(235)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("td"));
      ((Element)v.get(237)).setAttribute("colspan","4" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(238)).setAttribute("src","b.gif" );
      ((Element)v.get(238)).setAttribute("width","8" );
      ((Element)v.get(238)).setAttribute("height","8" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */
      /* Termina nodo:237   */
      /* Termina nodo:236   */

      /* Empieza nodo:239 / Elemento padre: 235   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(235)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("td"));
      ((Element)v.get(239)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(241)).setAttribute("src","b.gif" );
      ((Element)v.get(241)).setAttribute("width","8" );
      ((Element)v.get(241)).setAttribute("height","8" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */
      /* Termina nodo:240   */

      /* Empieza nodo:242 / Elemento padre: 239   */
      v.add(doc.createElement("td"));
      ((Element)v.get(239)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(243)).setAttribute("nombre","lblBaseCalculo" );
      ((Element)v.get(243)).setAttribute("alto","13" );
      ((Element)v.get(243)).setAttribute("filas","1" );
      ((Element)v.get(243)).setAttribute("valor","" );
      ((Element)v.get(243)).setAttribute("id","datosTitle" );
      ((Element)v.get(243)).setAttribute("cod","1181" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */
      /* Termina nodo:242   */

      /* Empieza nodo:244 / Elemento padre: 239   */
      v.add(doc.createElement("td"));
      ((Element)v.get(244)).setAttribute("width","100%" );
      ((Element)v.get(239)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(245)).setAttribute("src","b.gif" );
      ((Element)v.get(245)).setAttribute("width","8" );
      ((Element)v.get(245)).setAttribute("height","8" );
      ((Element)v.get(244)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */
      /* Termina nodo:244   */
      /* Termina nodo:239   */

      /* Empieza nodo:246 / Elemento padre: 235   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(235)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("td"));
      ((Element)v.get(246)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(248)).setAttribute("src","b.gif" );
      ((Element)v.get(248)).setAttribute("width","8" );
      ((Element)v.get(248)).setAttribute("height","8" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */
      /* Termina nodo:247   */

      /* Empieza nodo:249 / Elemento padre: 246   */
      v.add(doc.createElement("td"));
      ((Element)v.get(249)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(246)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(250)).setAttribute("nombre","cbBaseCalculo" );
      ((Element)v.get(250)).setAttribute("id","datosCampos" );
      ((Element)v.get(250)).setAttribute("size","1" );
      ((Element)v.get(250)).setAttribute("multiple","N" );
      ((Element)v.get(250)).setAttribute("req","S" );
      ((Element)v.get(250)).setAttribute("valorinicial","" );
      ((Element)v.get(250)).setAttribute("textoinicial","" );
      ((Element)v.get(250)).setAttribute("onchange","" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(250)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */
      /* Termina nodo:250   */
      /* Termina nodo:249   */

      /* Empieza nodo:252 / Elemento padre: 246   */
      v.add(doc.createElement("td"));
      ((Element)v.get(252)).setAttribute("width","100%" );
      ((Element)v.get(246)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(253)).setAttribute("src","b.gif" );
      ((Element)v.get(253)).setAttribute("width","8" );
      ((Element)v.get(253)).setAttribute("height","8" );
      ((Element)v.get(252)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */
      /* Termina nodo:252   */
      /* Termina nodo:246   */

      /* Empieza nodo:254 / Elemento padre: 235   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(235)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("td"));
      ((Element)v.get(255)).setAttribute("colspan","4" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(256)).setAttribute("src","b.gif" );
      ((Element)v.get(256)).setAttribute("width","8" );
      ((Element)v.get(256)).setAttribute("height","8" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */
      /* Termina nodo:255   */
      /* Termina nodo:254   */
      /* Termina nodo:235   */
      /* Termina nodo:234   */
      /* Termina nodo:233   */
      /* Termina nodo:232   */
      /* Termina nodo:229   */
      /* Termina nodo:228   */

      /* Empieza nodo:257 / Elemento padre: 225   */
   }

   private void getXML1170(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(225)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(258)).setAttribute("src","b.gif" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */
      /* Termina nodo:257   */
      /* Termina nodo:225   */

      /* Empieza nodo:259 / Elemento padre: 217   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(217)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("td"));
      ((Element)v.get(259)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(261)).setAttribute("src","b.gif" );
      ((Element)v.get(260)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */
      /* Termina nodo:260   */

      /* Empieza nodo:262 / Elemento padre: 259   */
      v.add(doc.createElement("td"));
      ((Element)v.get(259)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(262)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("table"));
      ((Element)v.get(264)).setAttribute("width","100%" );
      ((Element)v.get(264)).setAttribute("border","0" );
      ((Element)v.get(264)).setAttribute("align","center" );
      ((Element)v.get(264)).setAttribute("cellspacing","0" );
      ((Element)v.get(264)).setAttribute("cellpadding","0" );
      ((Element)v.get(263)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(264)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("td"));
      ((Element)v.get(266)).setAttribute("class","botonera" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(267)).setAttribute("nombre","btnAceptar2" );
      ((Element)v.get(267)).setAttribute("ID","botonContenido" );
      ((Element)v.get(267)).setAttribute("tipo","html" );
      ((Element)v.get(267)).setAttribute("accion","accionAceptarFormaCalculo();" );
      ((Element)v.get(267)).setAttribute("estado","false" );
      ((Element)v.get(267)).setAttribute("cod","12" );
      ((Element)v.get(266)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */
      /* Termina nodo:266   */
      /* Termina nodo:265   */
      /* Termina nodo:264   */
      /* Termina nodo:263   */
      /* Termina nodo:262   */

      /* Empieza nodo:268 / Elemento padre: 259   */
      v.add(doc.createElement("td"));
      ((Element)v.get(259)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(269)).setAttribute("src","b.gif" );
      ((Element)v.get(269)).setAttribute("width","8" );
      ((Element)v.get(269)).setAttribute("height","12" );
      ((Element)v.get(268)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */
      /* Termina nodo:268   */
      /* Termina nodo:259   */

      /* Empieza nodo:270 / Elemento padre: 217   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(217)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("td"));
      ((Element)v.get(271)).setAttribute("width","12" );
      ((Element)v.get(271)).setAttribute("align","center" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(272)).setAttribute("src","b.gif" );
      ((Element)v.get(272)).setAttribute("width","12" );
      ((Element)v.get(272)).setAttribute("height","15" );
      ((Element)v.get(271)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */
      /* Termina nodo:271   */

      /* Empieza nodo:273 / Elemento padre: 270   */
      v.add(doc.createElement("td"));
      ((Element)v.get(273)).setAttribute("width","756" );
      ((Element)v.get(270)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(274)).setAttribute("src","b.gif" );
      ((Element)v.get(273)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */
      /* Termina nodo:273   */

      /* Empieza nodo:275 / Elemento padre: 270   */
      v.add(doc.createElement("td"));
      ((Element)v.get(275)).setAttribute("width","12" );
      ((Element)v.get(270)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(276)).setAttribute("src","b.gif" );
      ((Element)v.get(276)).setAttribute("width","12" );
      ((Element)v.get(276)).setAttribute("height","1" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */
      /* Termina nodo:275   */
      /* Termina nodo:270   */
      /* Termina nodo:217   */
      /* Termina nodo:216   */

      /* Empieza nodo:277 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(277)).setAttribute("nombre","capa3" );
      ((Element)v.get(277)).setAttribute("alto","120" );
      ((Element)v.get(277)).setAttribute("ancho","100%" );
      ((Element)v.get(277)).setAttribute("colorf","" );
      ((Element)v.get(277)).setAttribute("borde","0" );
      ((Element)v.get(277)).setAttribute("imagenf","" );
      ((Element)v.get(277)).setAttribute("repeat","" );
      ((Element)v.get(277)).setAttribute("padding","" );
      ((Element)v.get(277)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(277)).setAttribute("contravsb","" );
      ((Element)v.get(277)).setAttribute("x","0" );
      ((Element)v.get(277)).setAttribute("y","280" );
      ((Element)v.get(277)).setAttribute("zindex","" );
      ((Element)v.get(10)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("table"));
      ((Element)v.get(278)).setAttribute("width","100%" );
      ((Element)v.get(278)).setAttribute("border","0" );
      ((Element)v.get(278)).setAttribute("cellspacing","0" );
      ((Element)v.get(278)).setAttribute("cellpadding","0" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("tr"));
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(278)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
      v.add(doc.createElement("td"));
      ((Element)v.get(280)).setAttribute("width","12" );
      ((Element)v.get(280)).setAttribute("align","center" );
      ((Element)v.get(279)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(281)).setAttribute("src","b.gif" );
      ((Element)v.get(281)).setAttribute("width","12" );
      ((Element)v.get(281)).setAttribute("height","12" );
      ((Element)v.get(280)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */
      /* Termina nodo:280   */

      /* Empieza nodo:282 / Elemento padre: 279   */
      v.add(doc.createElement("td"));
      ((Element)v.get(282)).setAttribute("width","750" );
      ((Element)v.get(279)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(283)).setAttribute("src","b.gif" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */
      /* Termina nodo:282   */

      /* Empieza nodo:284 / Elemento padre: 279   */
      v.add(doc.createElement("td"));
      ((Element)v.get(284)).setAttribute("width","12" );
      ((Element)v.get(279)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(285)).setAttribute("src","b.gif" );
      ((Element)v.get(285)).setAttribute("width","12" );
      ((Element)v.get(285)).setAttribute("height","1" );
      ((Element)v.get(284)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */
      /* Termina nodo:284   */
      /* Termina nodo:279   */

      /* Empieza nodo:286 / Elemento padre: 278   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(278)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("td"));
      ((Element)v.get(286)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(288)).setAttribute("src","b.gif" );
      ((Element)v.get(287)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */
      /* Termina nodo:287   */

      /* Empieza nodo:289 / Elemento padre: 286   */
      v.add(doc.createElement("td"));
      ((Element)v.get(286)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(289)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(291)).setAttribute("class","legend" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(292)).setAttribute("nombre","lblRecomendadas" );
      ((Element)v.get(292)).setAttribute("alto","13" );
      ((Element)v.get(292)).setAttribute("filas","1" );
      ((Element)v.get(292)).setAttribute("valor","" );
      ((Element)v.get(292)).setAttribute("id","legend" );
      ((Element)v.get(292)).setAttribute("cod","00289" );
      ((Element)v.get(291)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */
      /* Termina nodo:291   */

      /* Empieza nodo:293 / Elemento padre: 290   */
      v.add(doc.createElement("table"));
      ((Element)v.get(293)).setAttribute("width","100%" );
      ((Element)v.get(293)).setAttribute("border","0" );
      ((Element)v.get(293)).setAttribute("align","center" );
      ((Element)v.get(293)).setAttribute("cellspacing","0" );
      ((Element)v.get(293)).setAttribute("cellpadding","0" );
      ((Element)v.get(290)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(293)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("td"));
      ((Element)v.get(294)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("table"));
      ((Element)v.get(296)).setAttribute("width","696" );
      ((Element)v.get(296)).setAttribute("border","0" );
      ((Element)v.get(296)).setAttribute("align","left" );
      ((Element)v.get(296)).setAttribute("cellspacing","0" );
      ((Element)v.get(296)).setAttribute("cellpadding","0" );
      ((Element)v.get(295)).appendChild((Element)v.get(296));

      /* Empieza nodo:297 / Elemento padre: 296   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(296)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("td"));
      ((Element)v.get(298)).setAttribute("colspan","4" );
      ((Element)v.get(297)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(299)).setAttribute("src","b.gif" );
      ((Element)v.get(299)).setAttribute("width","8" );
      ((Element)v.get(299)).setAttribute("height","8" );
      ((Element)v.get(298)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */
      /* Termina nodo:298   */
      /* Termina nodo:297   */

      /* Empieza nodo:300 / Elemento padre: 296   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(296)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("td"));
      ((Element)v.get(300)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(302)).setAttribute("src","b.gif" );
      ((Element)v.get(302)).setAttribute("width","8" );
      ((Element)v.get(302)).setAttribute("height","8" );
      ((Element)v.get(301)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */
      /* Termina nodo:301   */

      /* Empieza nodo:303 / Elemento padre: 300   */
      v.add(doc.createElement("td"));
      ((Element)v.get(300)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(304)).setAttribute("nombre","lblRecomendacionEfectiva" );
      ((Element)v.get(304)).setAttribute("alto","13" );
      ((Element)v.get(304)).setAttribute("filas","1" );
      ((Element)v.get(304)).setAttribute("valor","" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(304)).setAttribute("id","datosTitle" );
      ((Element)v.get(304)).setAttribute("cod","1672" );
      ((Element)v.get(303)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */
      /* Termina nodo:303   */

      /* Empieza nodo:305 / Elemento padre: 300   */
      v.add(doc.createElement("td"));
      ((Element)v.get(300)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(306)).setAttribute("src","b.gif" );
      ((Element)v.get(306)).setAttribute("width","25" );
      ((Element)v.get(306)).setAttribute("height","8" );
      ((Element)v.get(305)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */
      /* Termina nodo:305   */

      /* Empieza nodo:307 / Elemento padre: 300   */
      v.add(doc.createElement("td"));
      ((Element)v.get(300)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(308)).setAttribute("nombre","lblPeriodoInicialEvaluacion" );
      ((Element)v.get(308)).setAttribute("alto","13" );
      ((Element)v.get(308)).setAttribute("filas","1" );
      ((Element)v.get(308)).setAttribute("valor","" );
      ((Element)v.get(308)).setAttribute("id","datosTitle" );
      ((Element)v.get(308)).setAttribute("cod","1674" );
      ((Element)v.get(307)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */
      /* Termina nodo:307   */

      /* Empieza nodo:309 / Elemento padre: 300   */
      v.add(doc.createElement("td"));
      ((Element)v.get(300)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(310)).setAttribute("src","b.gif" );
      ((Element)v.get(310)).setAttribute("width","25" );
      ((Element)v.get(310)).setAttribute("height","8" );
      ((Element)v.get(309)).appendChild((Element)v.get(310));
      /* Termina nodo:310   */
      /* Termina nodo:309   */

      /* Empieza nodo:311 / Elemento padre: 300   */
      v.add(doc.createElement("td"));
      ((Element)v.get(300)).appendChild((Element)v.get(311));

      /* Empieza nodo:312 / Elemento padre: 311   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(312)).setAttribute("nombre","lblNumPeriodosEvaluar" );
      ((Element)v.get(312)).setAttribute("alto","13" );
      ((Element)v.get(312)).setAttribute("filas","1" );
      ((Element)v.get(312)).setAttribute("valor","" );
      ((Element)v.get(312)).setAttribute("id","datosTitle" );
      ((Element)v.get(312)).setAttribute("cod","1675" );
      ((Element)v.get(311)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */
      /* Termina nodo:311   */

      /* Empieza nodo:313 / Elemento padre: 300   */
      v.add(doc.createElement("td"));
      ((Element)v.get(300)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(314)).setAttribute("src","b.gif" );
      ((Element)v.get(314)).setAttribute("width","25" );
      ((Element)v.get(314)).setAttribute("height","8" );
      ((Element)v.get(313)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */
      /* Termina nodo:313   */

      /* Empieza nodo:315 / Elemento padre: 300   */
      v.add(doc.createElement("td"));
      ((Element)v.get(300)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(316)).setAttribute("nombre","lblNumMinPedidos" );
      ((Element)v.get(316)).setAttribute("alto","13" );
      ((Element)v.get(316)).setAttribute("filas","1" );
      ((Element)v.get(316)).setAttribute("valor","" );
      ((Element)v.get(316)).setAttribute("id","datosTitle" );
      ((Element)v.get(316)).setAttribute("cod","1676" );
      ((Element)v.get(315)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */
      /* Termina nodo:315   */

      /* Empieza nodo:317 / Elemento padre: 300   */
      v.add(doc.createElement("td"));
      ((Element)v.get(300)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(318)).setAttribute("src","b.gif" );
      ((Element)v.get(318)).setAttribute("width","25" );
      ((Element)v.get(318)).setAttribute("height","8" );
      ((Element)v.get(317)).appendChild((Element)v.get(318));
      /* Termina nodo:318   */
      /* Termina nodo:317   */

      /* Empieza nodo:319 / Elemento padre: 300   */
      v.add(doc.createElement("td"));
      ((Element)v.get(300)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(320)).setAttribute("nombre","lblNumMinPedidosRecomendada" );
      ((Element)v.get(320)).setAttribute("alto","13" );
      ((Element)v.get(320)).setAttribute("filas","1" );
      ((Element)v.get(320)).setAttribute("valor","" );
      ((Element)v.get(320)).setAttribute("id","datosTitle" );
      ((Element)v.get(320)).setAttribute("cod","2423" );
      ((Element)v.get(319)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */
      /* Termina nodo:319   */

      /* Empieza nodo:321 / Elemento padre: 300   */
      v.add(doc.createElement("td"));
      ((Element)v.get(321)).setAttribute("width","100%" );
      ((Element)v.get(300)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(322)).setAttribute("src","b.gif" );
      ((Element)v.get(322)).setAttribute("width","8" );
      ((Element)v.get(322)).setAttribute("height","8" );
      ((Element)v.get(321)).appendChild((Element)v.get(322));
      /* Termina nodo:322   */
      /* Termina nodo:321   */
      /* Termina nodo:300   */

      /* Empieza nodo:323 / Elemento padre: 296   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(296)).appendChild((Element)v.get(323));

      /* Empieza nodo:324 / Elemento padre: 323   */
      v.add(doc.createElement("td"));
      ((Element)v.get(323)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(325)).setAttribute("src","b.gif" );
      ((Element)v.get(325)).setAttribute("width","8" );
      ((Element)v.get(325)).setAttribute("height","8" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */
      /* Termina nodo:324   */

      /* Empieza nodo:326 / Elemento padre: 323   */
      v.add(doc.createElement("td"));
      ((Element)v.get(323)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
   }

   private void getXML1440(Document doc) {
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(327)).setAttribute("nombre","ckRecomendacionEfectiva" );
      ((Element)v.get(327)).setAttribute("id","datosCampos" );
      ((Element)v.get(327)).setAttribute("onclick","" );
      ((Element)v.get(327)).setAttribute("check","S" );
      ((Element)v.get(326)).appendChild((Element)v.get(327));
      /* Termina nodo:327   */
      /* Termina nodo:326   */

      /* Empieza nodo:328 / Elemento padre: 323   */
      v.add(doc.createElement("td"));
      ((Element)v.get(323)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(329)).setAttribute("src","b.gif" );
      ((Element)v.get(329)).setAttribute("width","25" );
      ((Element)v.get(329)).setAttribute("height","8" );
      ((Element)v.get(328)).appendChild((Element)v.get(329));
      /* Termina nodo:329   */
      /* Termina nodo:328   */

      /* Empieza nodo:330 / Elemento padre: 323   */
      v.add(doc.createElement("td"));
      ((Element)v.get(330)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(323)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(331)).setAttribute("nombre","cbPeriodoInicialEvaluacion" );
      ((Element)v.get(331)).setAttribute("id","datosCampos" );
      ((Element)v.get(331)).setAttribute("size","1" );
      ((Element)v.get(331)).setAttribute("multiple","N" );
      ((Element)v.get(331)).setAttribute("req","N" );
      ((Element)v.get(331)).setAttribute("valorinicial","" );
      ((Element)v.get(331)).setAttribute("textoinicial","" );
      ((Element)v.get(330)).appendChild((Element)v.get(331));

      /* Empieza nodo:332 / Elemento padre: 331   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(331)).appendChild((Element)v.get(332));
      /* Termina nodo:332   */
      /* Termina nodo:331   */
      /* Termina nodo:330   */

      /* Empieza nodo:333 / Elemento padre: 323   */
      v.add(doc.createElement("td"));
      ((Element)v.get(323)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(334)).setAttribute("src","b.gif" );
      ((Element)v.get(334)).setAttribute("width","25" );
      ((Element)v.get(334)).setAttribute("height","8" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */
      /* Termina nodo:333   */

      /* Empieza nodo:335 / Elemento padre: 323   */
      v.add(doc.createElement("td"));
      ((Element)v.get(323)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(336)).setAttribute("nombre","txtNumPeriodosEvaluar" );
      ((Element)v.get(336)).setAttribute("id","datosCampos" );
      ((Element)v.get(336)).setAttribute("max","2" );
      ((Element)v.get(336)).setAttribute("tipo","" );
      ((Element)v.get(336)).setAttribute("onchange","" );
      ((Element)v.get(336)).setAttribute("req","N" );
      ((Element)v.get(336)).setAttribute("size","2" );
      ((Element)v.get(336)).setAttribute("valor","" );
      ((Element)v.get(336)).setAttribute("validacion","" );
      ((Element)v.get(335)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */
      /* Termina nodo:335   */

      /* Empieza nodo:337 / Elemento padre: 323   */
      v.add(doc.createElement("td"));
      ((Element)v.get(323)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(338)).setAttribute("src","b.gif" );
      ((Element)v.get(338)).setAttribute("width","25" );
      ((Element)v.get(338)).setAttribute("height","8" );
      ((Element)v.get(337)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */
      /* Termina nodo:337   */

      /* Empieza nodo:339 / Elemento padre: 323   */
      v.add(doc.createElement("td"));
      ((Element)v.get(323)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(340)).setAttribute("nombre","txtNumMinPedidos" );
      ((Element)v.get(340)).setAttribute("id","datosCampos" );
      ((Element)v.get(340)).setAttribute("max","3" );
      ((Element)v.get(340)).setAttribute("tipo","" );
      ((Element)v.get(340)).setAttribute("onchange","" );
      ((Element)v.get(340)).setAttribute("req","N" );
      ((Element)v.get(340)).setAttribute("size","3" );
      ((Element)v.get(340)).setAttribute("valor","" );
      ((Element)v.get(340)).setAttribute("validacion","" );
      ((Element)v.get(339)).appendChild((Element)v.get(340));
      /* Termina nodo:340   */
      /* Termina nodo:339   */

      /* Empieza nodo:341 / Elemento padre: 323   */
      v.add(doc.createElement("td"));
      ((Element)v.get(323)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(342)).setAttribute("src","b.gif" );
      ((Element)v.get(342)).setAttribute("width","25" );
      ((Element)v.get(342)).setAttribute("height","8" );
      ((Element)v.get(341)).appendChild((Element)v.get(342));
      /* Termina nodo:342   */
      /* Termina nodo:341   */

      /* Empieza nodo:343 / Elemento padre: 323   */
      v.add(doc.createElement("td"));
      ((Element)v.get(323)).appendChild((Element)v.get(343));

      /* Empieza nodo:344 / Elemento padre: 343   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(344)).setAttribute("nombre","txtNumMinPedidosRecomendada" );
      ((Element)v.get(344)).setAttribute("id","datosCampos" );
      ((Element)v.get(344)).setAttribute("max","3" );
      ((Element)v.get(344)).setAttribute("tipo","" );
      ((Element)v.get(344)).setAttribute("onchange","" );
      ((Element)v.get(344)).setAttribute("req","N" );
      ((Element)v.get(344)).setAttribute("size","3" );
      ((Element)v.get(344)).setAttribute("valor","" );
      ((Element)v.get(344)).setAttribute("validacion","" );
      ((Element)v.get(343)).appendChild((Element)v.get(344));
      /* Termina nodo:344   */
      /* Termina nodo:343   */

      /* Empieza nodo:345 / Elemento padre: 323   */
      v.add(doc.createElement("td"));
      ((Element)v.get(345)).setAttribute("width","100%" );
      ((Element)v.get(323)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
   }

   private void getXML1530(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(346)).setAttribute("src","b.gif" );
      ((Element)v.get(346)).setAttribute("width","8" );
      ((Element)v.get(346)).setAttribute("height","8" );
      ((Element)v.get(345)).appendChild((Element)v.get(346));
      /* Termina nodo:346   */
      /* Termina nodo:345   */
      /* Termina nodo:323   */

      /* Empieza nodo:347 / Elemento padre: 296   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(296)).appendChild((Element)v.get(347));

      /* Empieza nodo:348 / Elemento padre: 347   */
      v.add(doc.createElement("td"));
      ((Element)v.get(348)).setAttribute("colspan","4" );
      ((Element)v.get(347)).appendChild((Element)v.get(348));

      /* Empieza nodo:349 / Elemento padre: 348   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(349)).setAttribute("src","b.gif" );
      ((Element)v.get(349)).setAttribute("width","8" );
      ((Element)v.get(349)).setAttribute("height","8" );
      ((Element)v.get(348)).appendChild((Element)v.get(349));
      /* Termina nodo:349   */
      /* Termina nodo:348   */
      /* Termina nodo:347   */
      /* Termina nodo:296   */
      /* Termina nodo:295   */
      /* Termina nodo:294   */
      /* Termina nodo:293   */
      /* Termina nodo:290   */
      /* Termina nodo:289   */

      /* Empieza nodo:350 / Elemento padre: 286   */
      v.add(doc.createElement("td"));
      ((Element)v.get(286)).appendChild((Element)v.get(350));

      /* Empieza nodo:351 / Elemento padre: 350   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(351)).setAttribute("src","b.gif" );
      ((Element)v.get(350)).appendChild((Element)v.get(351));
      /* Termina nodo:351   */
      /* Termina nodo:350   */
      /* Termina nodo:286   */

      /* Empieza nodo:352 / Elemento padre: 278   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(278)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
      v.add(doc.createElement("td"));
      ((Element)v.get(352)).appendChild((Element)v.get(353));

      /* Empieza nodo:354 / Elemento padre: 353   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(354)).setAttribute("src","b.gif" );
      ((Element)v.get(353)).appendChild((Element)v.get(354));
      /* Termina nodo:354   */
      /* Termina nodo:353   */

      /* Empieza nodo:355 / Elemento padre: 352   */
      v.add(doc.createElement("td"));
      ((Element)v.get(352)).appendChild((Element)v.get(355));

      /* Empieza nodo:356 / Elemento padre: 355   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(355)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("table"));
      ((Element)v.get(357)).setAttribute("width","100%" );
      ((Element)v.get(357)).setAttribute("border","0" );
      ((Element)v.get(357)).setAttribute("align","center" );
      ((Element)v.get(357)).setAttribute("cellspacing","0" );
      ((Element)v.get(357)).setAttribute("cellpadding","0" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));

      /* Empieza nodo:358 / Elemento padre: 357   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(357)).appendChild((Element)v.get(358));

      /* Empieza nodo:359 / Elemento padre: 358   */
      v.add(doc.createElement("td"));
      ((Element)v.get(359)).setAttribute("class","botonera" );
      ((Element)v.get(358)).appendChild((Element)v.get(359));

      /* Empieza nodo:360 / Elemento padre: 359   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(360)).setAttribute("nombre","btnMontoVentas" );
      ((Element)v.get(360)).setAttribute("ID","botonContenido" );
      ((Element)v.get(360)).setAttribute("tipo","html" );
      ((Element)v.get(360)).setAttribute("accion","onClickMontoVentaRecomendada();" );
      ((Element)v.get(360)).setAttribute("estado","false" );
      ((Element)v.get(360)).setAttribute("cod","1677" );
      ((Element)v.get(359)).appendChild((Element)v.get(360));
      /* Termina nodo:360   */
      /* Termina nodo:359   */
      /* Termina nodo:358   */
      /* Termina nodo:357   */
      /* Termina nodo:356   */
      /* Termina nodo:355   */

      /* Empieza nodo:361 / Elemento padre: 352   */
      v.add(doc.createElement("td"));
      ((Element)v.get(352)).appendChild((Element)v.get(361));

      /* Empieza nodo:362 / Elemento padre: 361   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(362)).setAttribute("src","b.gif" );
      ((Element)v.get(362)).setAttribute("width","8" );
      ((Element)v.get(362)).setAttribute("height","12" );
      ((Element)v.get(361)).appendChild((Element)v.get(362));
      /* Termina nodo:362   */
      /* Termina nodo:361   */
      /* Termina nodo:352   */

      /* Empieza nodo:363 / Elemento padre: 278   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(278)).appendChild((Element)v.get(363));

      /* Empieza nodo:364 / Elemento padre: 363   */
      v.add(doc.createElement("td"));
      ((Element)v.get(364)).setAttribute("width","12" );
      ((Element)v.get(364)).setAttribute("align","center" );
      ((Element)v.get(363)).appendChild((Element)v.get(364));

      /* Empieza nodo:365 / Elemento padre: 364   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(365)).setAttribute("src","b.gif" );
      ((Element)v.get(365)).setAttribute("width","12" );
      ((Element)v.get(365)).setAttribute("height","12" );
      ((Element)v.get(364)).appendChild((Element)v.get(365));
      /* Termina nodo:365   */
      /* Termina nodo:364   */

      /* Empieza nodo:366 / Elemento padre: 363   */
      v.add(doc.createElement("td"));
      ((Element)v.get(366)).setAttribute("width","756" );
      ((Element)v.get(363)).appendChild((Element)v.get(366));

      /* Empieza nodo:367 / Elemento padre: 366   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(367)).setAttribute("src","b.gif" );
      ((Element)v.get(366)).appendChild((Element)v.get(367));
      /* Termina nodo:367   */
      /* Termina nodo:366   */

      /* Empieza nodo:368 / Elemento padre: 363   */
      v.add(doc.createElement("td"));
      ((Element)v.get(368)).setAttribute("width","12" );
      ((Element)v.get(363)).appendChild((Element)v.get(368));

      /* Empieza nodo:369 / Elemento padre: 368   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(369)).setAttribute("src","b.gif" );
      ((Element)v.get(369)).setAttribute("width","12" );
      ((Element)v.get(369)).setAttribute("height","1" );
      ((Element)v.get(368)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */
      /* Termina nodo:368   */
      /* Termina nodo:363   */
      /* Termina nodo:278   */
      /* Termina nodo:277   */

      /* Empieza nodo:370 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(370)).setAttribute("nombre","capa4" );
      ((Element)v.get(370)).setAttribute("alto","90" );
      ((Element)v.get(370)).setAttribute("ancho","100%" );
      ((Element)v.get(370)).setAttribute("colorf","" );
      ((Element)v.get(370)).setAttribute("borde","0" );
      ((Element)v.get(370)).setAttribute("imagenf","" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(370)).setAttribute("repeat","" );
      ((Element)v.get(370)).setAttribute("padding","" );
      ((Element)v.get(370)).setAttribute("visibilidad","" );
      ((Element)v.get(370)).setAttribute("contravsb","" );
      ((Element)v.get(370)).setAttribute("x","0" );
      ((Element)v.get(370)).setAttribute("y","280" );
      ((Element)v.get(370)).setAttribute("zindex","" );
      ((Element)v.get(10)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("table"));
      ((Element)v.get(371)).setAttribute("width","100%" );
      ((Element)v.get(371)).setAttribute("border","0" );
      ((Element)v.get(371)).setAttribute("cellspacing","0" );
      ((Element)v.get(371)).setAttribute("cellpadding","0" );
      ((Element)v.get(370)).appendChild((Element)v.get(371));

      /* Empieza nodo:372 / Elemento padre: 371   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(371)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("td"));
      ((Element)v.get(373)).setAttribute("width","12" );
      ((Element)v.get(373)).setAttribute("align","center" );
      ((Element)v.get(372)).appendChild((Element)v.get(373));

      /* Empieza nodo:374 / Elemento padre: 373   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(374)).setAttribute("src","b.gif" );
      ((Element)v.get(374)).setAttribute("width","12" );
      ((Element)v.get(374)).setAttribute("height","12" );
      ((Element)v.get(373)).appendChild((Element)v.get(374));
      /* Termina nodo:374   */
      /* Termina nodo:373   */

      /* Empieza nodo:375 / Elemento padre: 372   */
      v.add(doc.createElement("td"));
      ((Element)v.get(375)).setAttribute("width","750" );
      ((Element)v.get(372)).appendChild((Element)v.get(375));

      /* Empieza nodo:376 / Elemento padre: 375   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(376)).setAttribute("src","b.gif" );
      ((Element)v.get(375)).appendChild((Element)v.get(376));
      /* Termina nodo:376   */
      /* Termina nodo:375   */

      /* Empieza nodo:377 / Elemento padre: 372   */
      v.add(doc.createElement("td"));
      ((Element)v.get(377)).setAttribute("width","12" );
      ((Element)v.get(372)).appendChild((Element)v.get(377));

      /* Empieza nodo:378 / Elemento padre: 377   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(378)).setAttribute("src","b.gif" );
      ((Element)v.get(378)).setAttribute("width","12" );
      ((Element)v.get(378)).setAttribute("height","1" );
      ((Element)v.get(377)).appendChild((Element)v.get(378));
      /* Termina nodo:378   */
      /* Termina nodo:377   */
      /* Termina nodo:372   */

      /* Empieza nodo:379 / Elemento padre: 371   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(371)).appendChild((Element)v.get(379));

      /* Empieza nodo:380 / Elemento padre: 379   */
      v.add(doc.createElement("td"));
      ((Element)v.get(379)).appendChild((Element)v.get(380));

      /* Empieza nodo:381 / Elemento padre: 380   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(381)).setAttribute("src","b.gif" );
      ((Element)v.get(380)).appendChild((Element)v.get(381));
      /* Termina nodo:381   */
      /* Termina nodo:380   */

      /* Empieza nodo:382 / Elemento padre: 379   */
      v.add(doc.createElement("td"));
      ((Element)v.get(379)).appendChild((Element)v.get(382));

      /* Empieza nodo:383 / Elemento padre: 382   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(382)).appendChild((Element)v.get(383));

      /* Empieza nodo:384 / Elemento padre: 383   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(384)).setAttribute("class","legend" );
      ((Element)v.get(383)).appendChild((Element)v.get(384));

      /* Empieza nodo:385 / Elemento padre: 384   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(385)).setAttribute("nombre","lblDatosMonto" );
      ((Element)v.get(385)).setAttribute("alto","13" );
      ((Element)v.get(385)).setAttribute("filas","1" );
      ((Element)v.get(385)).setAttribute("valor","" );
      ((Element)v.get(385)).setAttribute("id","legend" );
      ((Element)v.get(385)).setAttribute("cod","917" );
      ((Element)v.get(384)).appendChild((Element)v.get(385));
      /* Termina nodo:385   */
      /* Termina nodo:384   */

      /* Empieza nodo:386 / Elemento padre: 383   */
      v.add(doc.createElement("table"));
      ((Element)v.get(386)).setAttribute("width","100%" );
      ((Element)v.get(386)).setAttribute("border","0" );
      ((Element)v.get(386)).setAttribute("align","center" );
      ((Element)v.get(386)).setAttribute("cellspacing","0" );
      ((Element)v.get(386)).setAttribute("cellpadding","0" );
      ((Element)v.get(383)).appendChild((Element)v.get(386));

      /* Empieza nodo:387 / Elemento padre: 386   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(386)).appendChild((Element)v.get(387));

      /* Empieza nodo:388 / Elemento padre: 387   */
      v.add(doc.createElement("td"));
      ((Element)v.get(387)).appendChild((Element)v.get(388));

      /* Empieza nodo:389 / Elemento padre: 388   */
      v.add(doc.createElement("table"));
      ((Element)v.get(389)).setAttribute("width","696" );
      ((Element)v.get(389)).setAttribute("border","0" );
      ((Element)v.get(389)).setAttribute("align","left" );
      ((Element)v.get(389)).setAttribute("cellspacing","0" );
      ((Element)v.get(389)).setAttribute("cellpadding","0" );
      ((Element)v.get(388)).appendChild((Element)v.get(389));

      /* Empieza nodo:390 / Elemento padre: 389   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(389)).appendChild((Element)v.get(390));

      /* Empieza nodo:391 / Elemento padre: 390   */
      v.add(doc.createElement("td"));
      ((Element)v.get(391)).setAttribute("colspan","4" );
      ((Element)v.get(390)).appendChild((Element)v.get(391));

      /* Empieza nodo:392 / Elemento padre: 391   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(392)).setAttribute("src","b.gif" );
      ((Element)v.get(392)).setAttribute("width","8" );
      ((Element)v.get(392)).setAttribute("height","8" );
      ((Element)v.get(391)).appendChild((Element)v.get(392));
      /* Termina nodo:392   */
      /* Termina nodo:391   */
      /* Termina nodo:390   */

      /* Empieza nodo:393 / Elemento padre: 389   */
      v.add(doc.createElement("tr"));
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(389)).appendChild((Element)v.get(393));

      /* Empieza nodo:394 / Elemento padre: 393   */
      v.add(doc.createElement("td"));
      ((Element)v.get(393)).appendChild((Element)v.get(394));

      /* Empieza nodo:395 / Elemento padre: 394   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(395)).setAttribute("src","b.gif" );
      ((Element)v.get(395)).setAttribute("width","8" );
      ((Element)v.get(395)).setAttribute("height","8" );
      ((Element)v.get(394)).appendChild((Element)v.get(395));
      /* Termina nodo:395   */
      /* Termina nodo:394   */

      /* Empieza nodo:396 / Elemento padre: 393   */
      v.add(doc.createElement("td"));
      ((Element)v.get(393)).appendChild((Element)v.get(396));

      /* Empieza nodo:397 / Elemento padre: 396   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(397)).setAttribute("nombre","lblTipoVenta" );
      ((Element)v.get(397)).setAttribute("alto","13" );
      ((Element)v.get(397)).setAttribute("filas","1" );
      ((Element)v.get(397)).setAttribute("valor","" );
      ((Element)v.get(397)).setAttribute("id","datosTitle" );
      ((Element)v.get(397)).setAttribute("cod","1622" );
      ((Element)v.get(396)).appendChild((Element)v.get(397));
      /* Termina nodo:397   */
      /* Termina nodo:396   */

      /* Empieza nodo:398 / Elemento padre: 393   */
      v.add(doc.createElement("td"));
      ((Element)v.get(398)).setAttribute("width","100%" );
      ((Element)v.get(393)).appendChild((Element)v.get(398));

      /* Empieza nodo:399 / Elemento padre: 398   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(399)).setAttribute("src","b.gif" );
      ((Element)v.get(399)).setAttribute("width","8" );
      ((Element)v.get(399)).setAttribute("height","8" );
      ((Element)v.get(398)).appendChild((Element)v.get(399));
      /* Termina nodo:399   */
      /* Termina nodo:398   */
      /* Termina nodo:393   */

      /* Empieza nodo:400 / Elemento padre: 389   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(389)).appendChild((Element)v.get(400));

      /* Empieza nodo:401 / Elemento padre: 400   */
      v.add(doc.createElement("td"));
      ((Element)v.get(400)).appendChild((Element)v.get(401));

      /* Empieza nodo:402 / Elemento padre: 401   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(402)).setAttribute("src","b.gif" );
      ((Element)v.get(402)).setAttribute("width","8" );
      ((Element)v.get(402)).setAttribute("height","8" );
      ((Element)v.get(401)).appendChild((Element)v.get(402));
      /* Termina nodo:402   */
      /* Termina nodo:401   */

      /* Empieza nodo:403 / Elemento padre: 400   */
      v.add(doc.createElement("td"));
      ((Element)v.get(403)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(400)).appendChild((Element)v.get(403));

      /* Empieza nodo:404 / Elemento padre: 403   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(404)).setAttribute("nombre","cbTipoVenta" );
      ((Element)v.get(404)).setAttribute("id","datosCampos" );
      ((Element)v.get(404)).setAttribute("size","1" );
      ((Element)v.get(404)).setAttribute("multiple","N" );
      ((Element)v.get(404)).setAttribute("req","N" );
      ((Element)v.get(404)).setAttribute("valorinicial","" );
      ((Element)v.get(404)).setAttribute("textoinicial","" );
      ((Element)v.get(404)).setAttribute("ontab","focoComboFormaCalculo();" );
      ((Element)v.get(403)).appendChild((Element)v.get(404));

      /* Empieza nodo:405 / Elemento padre: 404   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(404)).appendChild((Element)v.get(405));
      /* Termina nodo:405   */
      /* Termina nodo:404   */
      /* Termina nodo:403   */

      /* Empieza nodo:406 / Elemento padre: 400   */
      v.add(doc.createElement("td"));
      ((Element)v.get(406)).setAttribute("width","100%" );
      ((Element)v.get(400)).appendChild((Element)v.get(406));

      /* Empieza nodo:407 / Elemento padre: 406   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(407)).setAttribute("src","b.gif" );
      ((Element)v.get(407)).setAttribute("width","8" );
      ((Element)v.get(407)).setAttribute("height","8" );
      ((Element)v.get(406)).appendChild((Element)v.get(407));
      /* Termina nodo:407   */
      /* Termina nodo:406   */
      /* Termina nodo:400   */

      /* Empieza nodo:408 / Elemento padre: 389   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(389)).appendChild((Element)v.get(408));

      /* Empieza nodo:409 / Elemento padre: 408   */
      v.add(doc.createElement("td"));
      ((Element)v.get(409)).setAttribute("colspan","4" );
      ((Element)v.get(408)).appendChild((Element)v.get(409));

      /* Empieza nodo:410 / Elemento padre: 409   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(410)).setAttribute("src","b.gif" );
      ((Element)v.get(410)).setAttribute("width","8" );
      ((Element)v.get(410)).setAttribute("height","8" );
      ((Element)v.get(409)).appendChild((Element)v.get(410));
      /* Termina nodo:410   */
      /* Termina nodo:409   */
      /* Termina nodo:408   */
      /* Termina nodo:389   */
      /* Termina nodo:388   */
      /* Termina nodo:387   */
      /* Termina nodo:386   */
      /* Termina nodo:383   */
      /* Termina nodo:382   */

      /* Empieza nodo:411 / Elemento padre: 379   */
      v.add(doc.createElement("td"));
      ((Element)v.get(379)).appendChild((Element)v.get(411));

      /* Empieza nodo:412 / Elemento padre: 411   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(412)).setAttribute("src","b.gif" );
      ((Element)v.get(411)).appendChild((Element)v.get(412));
      /* Termina nodo:412   */
      /* Termina nodo:411   */
      /* Termina nodo:379   */

      /* Empieza nodo:413 / Elemento padre: 371   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(371)).appendChild((Element)v.get(413));

      /* Empieza nodo:414 / Elemento padre: 413   */
      v.add(doc.createElement("td"));
      ((Element)v.get(414)).setAttribute("width","12" );
      ((Element)v.get(414)).setAttribute("align","center" );
      ((Element)v.get(413)).appendChild((Element)v.get(414));

      /* Empieza nodo:415 / Elemento padre: 414   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(415)).setAttribute("src","b.gif" );
      ((Element)v.get(415)).setAttribute("width","12" );
      ((Element)v.get(415)).setAttribute("height","12" );
      ((Element)v.get(414)).appendChild((Element)v.get(415));
      /* Termina nodo:415   */
      /* Termina nodo:414   */

      /* Empieza nodo:416 / Elemento padre: 413   */
      v.add(doc.createElement("td"));
      ((Element)v.get(416)).setAttribute("width","756" );
      ((Element)v.get(413)).appendChild((Element)v.get(416));

      /* Empieza nodo:417 / Elemento padre: 416   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(417)).setAttribute("src","b.gif" );
      ((Element)v.get(416)).appendChild((Element)v.get(417));
      /* Termina nodo:417   */
      /* Termina nodo:416   */

      /* Empieza nodo:418 / Elemento padre: 413   */
   }

   private void getXML1800(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(418)).setAttribute("width","12" );
      ((Element)v.get(413)).appendChild((Element)v.get(418));

      /* Empieza nodo:419 / Elemento padre: 418   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(419)).setAttribute("src","b.gif" );
      ((Element)v.get(419)).setAttribute("width","12" );
      ((Element)v.get(419)).setAttribute("height","1" );
      ((Element)v.get(418)).appendChild((Element)v.get(419));
      /* Termina nodo:419   */
      /* Termina nodo:418   */
      /* Termina nodo:413   */
      /* Termina nodo:371   */
      /* Termina nodo:370   */
      /* Termina nodo:10   */


   }

}
