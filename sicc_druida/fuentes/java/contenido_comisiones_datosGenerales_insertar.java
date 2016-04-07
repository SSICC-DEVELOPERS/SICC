
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_comisiones_datosGenerales_insertar  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_comisiones_datosGenerales_insertar" );
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
      v.add(doc.createTextNode("\r \r\rfunction onLoadPag() {\r  configurarMenuSecundario(\"formulario\");    \r  \r    var varIndComparativo = get(\"formulario.varIndComparativo\");\r  if(varIndComparativo!=\"\") {\r	  if(varIndComparativo==\"true\")  \r		set(\"formulario.rbComparativo\", \"S\");\r	  else\r		set(\"formulario.rbComparativo\", \"N\");\r\r		if (get(\"formulario.opcionMenu\") == \"insertar\") {\r		  document.all.rbComparativo[0].disabled= true;\r		  document.all.rbComparativo[1].disabled= true;\r		}\r\r  }\r\r/*agregado ciglesias incidencia DBLG700000207 inicio*/\r\rif (get(\"formulario.opcionMenu\") == \"modificar\") {\r  var desComparativo = get(\"formulario.varDeshabilitarComparativo\");\r  if(desComparativo != \"\") {\r	  if(desComparativo==\"true\") {\r		  document.all.rbComparativo[0].disabled= true;\r		  document.all.rbComparativo[1].disabled= true;\r	  } else {\r		  document.all.rbComparativo[0].disabled= false;\r		  document.all.rbComparativo[1].disabled= false;\r	  }\r\r  }}\r/*agregado ciglesias incidencia DBLG700000207 fin*/\r\r    var varIndTratamientoDif = get(\"formulario.varIndTratamientoDif\");  \r  if(varIndTratamientoDif!=\"\") {\r	if(varIndTratamientoDif==\"true\")\r		set(\"formulario.rbTratamientoDiferencialAntigua\", \"S\");\r	else\r		set(\"formulario.rbTratamientoDiferencialAntigua\", \"N\");\r\r 	if (get(\"formulario.opcionMenu\") == \"insertar\") {\r			document.all.rbTratamientoDiferencialAntigua[0].disabled = true;\r			document.all.rbTratamientoDiferencialAntigua[1].disabled = true;\r	}\r  }\r\r/*agregado ciglesias incidencia DBLG700000207 inicio*/\r 	if (get(\"formulario.opcionMenu\") == \"modificar\") {\r var desTratDif = get(\"formulario.varDeshabilitarTratDif\");\r  if(desTratDif!=\"\") {\r	  if(desTratDif==\"true\") {\r			document.all.rbTratamientoDiferencialAntigua[0].disabled = true;\r			document.all.rbTratamientoDiferencialAntigua[1].disabled = true;\r	  } else {\r			document.all.rbTratamientoDiferencialAntigua[0].disabled = false;\r			document.all.rbTratamientoDiferencialAntigua[1].disabled = false;\r	  }\r\r  }}\r/*agregado ciglesias incidencia DBLG700000207 fin*/\r\r    var opcionMenu = get(\"formulario.opcionMenu\");\r  if((opcionMenu == \"consultar\") || (opcionMenu == \"modificar\") || (opcionMenu == \"insertar\")) {	\r	var sDescripcionComision = get(\"formulario.sDescripcionComision\");\r	var sOidMarca = get(\"formulario.sOidMarca\");\r	var sOidAccesos = get(\"formulario.sOidAccesos\");\r	var marcoAccesos = get(\"formulario.marcoAccesos\");\r	var sOidPeriodoDesde = get(\"formulario.sOidPeriodoDesde\");\r	var sOidPeriodoHasta = get(\"formulario.sOidPeriodoHasta\");\r	var sNumeroPeriodosEspera = get(\"formulario.sNumeroPeriodosEspera\");\r\r		var sConsideraSabDomFer = get(\"formulario.sConsideraSabDomFer\");\r	var sDsctoImpstoVtaPagos = get(\"formulario.sDsctoImpstoVtaPagos\");\r	\r		set(\"formulario.txtDescripcionComision\", sDescripcionComision);\r\r		var arraySeteo = new Array();\r	arraySeteo[0] = sOidMarca;\r	set(\"formulario.cbMarca\", arraySeteo);\r\r		var arrayMarcarAccesos = marcoAccesos.split(\",\");\r	set(\"formulario.cbAcceso\", arrayMarcarAccesos);\r	if(sOidAccesos!=\"\") {\r				var arrayAccesos = sOidAccesos.split(\",\");\r		set(\"formulario.cbAcceso\", arrayAccesos);\r	}	\r\r		set(\"formulario.txtNumPeriodosEspera\", sNumeroPeriodosEspera);\r\r    	set(\"formulario.ckConsideraSabDomFer\", sConsideraSabDomFer);\r	set(\"formulario.ckDsctoImpstoVtaPagos\", sDsctoImpstoVtaPagos);\r\r	\r			recargoCombosPeriodos();\r  }\r\r      var solicitudAutorizada = get(\"formulario.solicitudAutorizada\");\r  if(solicitudAutorizada==\"true\") {\r	document.getElementById(\"txtDescripcionComision\").disabled = true;\r	document.getElementById(\"cbMarca\").disabled = true;\r	document.getElementById(\"cbAcceso\").disabled = true;\r	document.getElementById(\"cbPeriodoDesde\").disabled = true;   \r\r  }\r\r    if(opcionMenu == \"consultar\") {\r  	document.getElementById(\"txtDescripcionComision\").disabled = true;\r	document.getElementById(\"cbMarca\").disabled = true;\r	document.getElementById(\"cbAcceso\").disabled = true;\r	document.getElementById(\"cbPeriodoDesde\").disabled = true;\r	document.getElementById(\"cbPeriodoHasta\").disabled = true;\r	document.getElementById(\"txtNumPeriodosEspera\").disabled = true;\r    document.all.rbComparativo[0].disabled= true;\r    document.all.rbComparativo[1].disabled= true;\r	document.all.rbTratamientoDiferencialAntigua[0].disabled = true;\r	document.all.rbTratamientoDiferencialAntigua[1].disabled = true;\r\r		document.getElementById(\"ckConsideraSabDomFer\").disabled = true;\r	document.getElementById(\"ckDsctoImpstoVtaPagos\").disabled = true;\r\r			  }\r\r    if (opcionMenu != \"insertar\") {\r	btnProxy(2,'1');\r  } else {\r	btnProxy(2,'0');\r  }\r\r\r    if(opcionMenu!=\"consultar\") {\r	  focoDescripcion();\r  }\r\r  if(opcionMenu == \"modificar\") {\r	btnProxy(4, '0');  \r  }\r}  \r\rfunction recargoCombosPeriodos() {\r	var valor = get(\"formulario.cbMarca\");\r  \r	if(valor==\"\") {\r		var objArr = document.all['cbPeriodoDesde'];\r		for(var i=0; i < objArr.length; i++){\r			if(objArr[i].tagName && objArr[i].tagName.toUpperCase()==\"SELECT\"){\r				if (!objArr[i].disabled) {\r					var aCombo = new Array(new Array(\"\",\"\"));\r					set_combo('formulario.cbPeriodoDesde',aCombo, []);				\r		        }\r			 }\r	     }\r    \r		var objArr = document.all['cbPeriodoHasta'];\r	    for(var i=0; i < objArr.length; i++){\r		    if(objArr[i].tagName && objArr[i].tagName.toUpperCase()==\"SELECT\"){\r			    if (!objArr[i].disabled) {\r				    var aCombo = new Array(new Array(\"\",\"\"));\r					set_combo('formulario.cbPeriodoHasta',aCombo, []);				\r	            }\r		     }\r	     }\r\r		return;\r	}\r\r	var arr = new Array();\r	arr[arr.length]=new Array(\"marca\", get(\"formulario.cbMarca\"));\r	arr[arr.length]=new Array(\"pais\", get(\"formulario.varPais\"));\r	arr[arr.length]=new Array(\"canal\", get(\"formulario.varOidCanal\"));\r  \r	recargaCombo(\"formulario.cbPeriodoDesde\", 'CRAObtienePeriodos', 'es.indra.sicc.dtos.cra.DTOPeriodo', arr, \"marcaComboPeriodosDesde(datos);\");\r}\r\rfunction marcaComboPeriodosDesde(datos) {\r	var datosNuevo = new Array();\r	datosNuevo[0] = [\"\",\"\"];\r\r	for (var i = 0; i < datos.length; i++ )\r		datosNuevo[i+1]  = datos[i];\r\r	set_combo(\"formulario.cbPeriodoDesde\", datosNuevo);\r	var sOidPeriodoDesde = get(\"formulario.sOidPeriodoDesde\");\r	var periodoSeleccionado = new Array();\r	periodoSeleccionado = sOidPeriodoDesde.split(\",\");	  \r	set(\"formulario.cbPeriodoDesde\", periodoSeleccionado);\r\r	recargaComboPeriodoHasta();\r}\r\rfunction recargaComboPeriodoHasta() {\r  var valor = get(\"formulario.cbPeriodoDesde\");\r  \r  if(valor==\"\") {    \r	var objArr = document.all['cbPeriodoHasta'];\r    for(var i=0; i < objArr.length; i++){\r	    if(objArr[i].tagName && objArr[i].tagName.toUpperCase()==\"SELECT\"){\r		    if (!objArr[i].disabled) {\r			    var aCombo = new Array(new Array(\"\",\"\"));\r				set_combo('formulario.cbPeriodoHasta',aCombo, []);				\r            }\r         }\r     }\r\r	return;\r  }\r\r  var arr = new Array();\r  arr[arr.length]=new Array(\"oidPais\", get(\"formulario.varPais\"));\r  arr[arr.length]=new Array(\"marca\", get(\"formulario.cbMarca\"));\r  arr[arr.length]=new Array(\"canal\", get(\"formulario.varOidCanal\"));\r  arr[arr.length]=new Array(\"oid\", get(\"formulario.cbPeriodoDesde\"));\r  \r  recargaCombo(\"formulario.cbPeriodoHasta\", 'COMObtenerPeriodosMayores', 'es.indra.sicc.dtos.cra.DTOPeriodo', arr, \"marcaComboPeriodosHasta(datos);\");\r}\r\rfunction marcaComboPeriodosHasta(datos) {\r	var datosNuevo = new Array();\r	datosNuevo[0] = [\"\",\"\"];\r\r	for (var i = 0; i < datos.length; i++ )\r		datosNuevo[i+1]  = datos[i];\r\r	set_combo(\"formulario.cbPeriodoHasta\", datosNuevo);\r	var sOidPeriodoHasta = get(\"formulario.sOidPeriodoHasta\");\r	var periodoSeleccionado = new Array();\r	periodoSeleccionado = sOidPeriodoHasta.split(\",\");	  \r	set(\"formulario.cbPeriodoHasta\", periodoSeleccionado)\r}\r\rfunction onTabNumeroPeriodos() {\r	if(document.all.rbComparativo[0].disabled!=true) {\r			focoIndicadorComparativo();\r	}\r	else {\r		if(document.all.rbTratamientoDiferencialAntigua[0].disabled!=true) {\r			focoTratamientoDiferencial();\r		}\r		else {\r			focoDescripcion();\r		}\r	}	\r}\r\rfunction onTabComparativo() {\r	if(document.all.rbTratamientoDiferencialAntigua[0].disabled!=true) {\r		focoTratamientoDiferencial();\r	}\r	else {\r		focoDescripcion();\r	}\r}\r\rfunction focoNumeroPeriodosEspera() {\r	focaliza(\"formulario.txtNumPeriodosEspera\");\r}\r\rfunction onShtabTratamientoDiferencial() {\r	if(document.all.rbComparativo[0].disabled!=true) {\r		focoIndicadorComparativo();\r	}\r	else {\r		focoNumeroPeriodosEspera();\r	}	\r}\r\rfunction focoDescripcion() {\r  focaliza(\"formulario.txtDescripcionComision\");\r}\r\rfunction focoIndicadorComparativo() {\r	focaliza(\"formulario.rbComparativo\");\r}\r\rfunction focoTratamientoDiferencial() {\r	focaliza(\"formulario.rbTratamientoDiferencialAntigua\");\r}\r\rfunction onShTabDescripcion() {\r	\r	focaliza(\"formulario.ckDsctoImpstoVtaPagos\");\r		\r}\r\rfunction onSeleccionaMarca() {  \r  var valor = get(\"formulario.cbMarca\");\r  \r  if(valor==\"\") {\r    var objArr = document.all['cbPeriodoDesde'];\r    for(var i=0; i < objArr.length; i++){\r	    if(objArr[i].tagName && objArr[i].tagName.toUpperCase()==\"SELECT\"){\r		    if (!objArr[i].disabled) {\r			    var aCombo = new Array(new Array(\"\",\"\"));\r				set_combo('formulario.cbPeriodoDesde',aCombo, []);				\r            }\r         }\r     }\r    \r	var objArr = document.all['cbPeriodoHasta'];\r    for(var i=0; i < objArr.length; i++){\r	    if(objArr[i].tagName && objArr[i].tagName.toUpperCase()==\"SELECT\"){\r		    if (!objArr[i].disabled) {\r			    var aCombo = new Array(new Array(\"\",\"\"));\r				set_combo('formulario.cbPeriodoHasta',aCombo, []);				\r            }\r         }\r     }\r\r	return;\r  }\r\r  var arr = new Array();\r  arr[arr.length]=new Array(\"marca\", get(\"formulario.cbMarca\"));\r  arr[arr.length]=new Array(\"pais\", get(\"formulario.varPais\"));\r  arr[arr.length]=new Array(\"canal\", get(\"formulario.varOidCanal\"));\r  \r  recargaCombo(\"formulario.cbPeriodoDesde\", 'CRAObtienePeriodos', 'es.indra.sicc.dtos.cra.DTOPeriodo', arr);\r}\r\rfunction onChangePeriodoDesde() {\r  var valor = get(\"formulario.cbPeriodoDesde\");\r  \r  if(valor==\"\") {    \r	var objArr = document.all['cbPeriodoHasta'];\r    for(var i=0; i < objArr.length; i++){\r	    if(objArr[i].tagName && objArr[i].tagName.toUpperCase()==\"SELECT\"){\r		    if (!objArr[i].disabled) {\r			    var aCombo = new Array(new Array(\"\",\"\"));\r				set_combo('formulario.cbPeriodoHasta',aCombo, []);				\r            }\r         }\r     }\r\r	return;\r  }\r\r  var arr = new Array();\r  arr[arr.length]=new Array(\"oidPais\", get(\"formulario.varPais\"));\r  arr[arr.length]=new Array(\"marca\", get(\"formulario.cbMarca\"));\r  arr[arr.length]=new Array(\"canal\", get(\"formulario.varOidCanal\"));\r  arr[arr.length]=new Array(\"oid\", get(\"formulario.cbPeriodoDesde\"));\r  \r  recargaCombo(\"formulario.cbPeriodoHasta\", 'COMObtenerPeriodosMayores', 'es.indra.sicc.dtos.cra.DTOPeriodo', arr);\r}\r\rfunction onClickPestanya(valor) {  \r	var opcionMenu = get(\"formulario.opcionMenu\");\r    if(!sicc_validaciones_generales())\r		return;\r\r   	var estadoVentana = get(\"formulario.estadoVentana\");\r	var marca = get(\"formulario.cbMarca\");\r	var descMarca = get(\"formulario.cbMarca\", \"T\");\r	var canal = get(\"formulario.varOidCanal\");\r 	var descCanal = get(\"formulario.descCanal\");\r	var acceso = get(\"formulario.cbAcceso\");\r	var periodoDesde = get(\"formulario.cbPeriodoDesde\");\r	var periodoHasta = get(\"formulario.cbPeriodoHasta\");\r	var periodosEspera = get(\"formulario.txtNumPeriodosEspera\");\r	var varIndComparativo = get(\"formulario.rbComparativo\");\r\r		var consideraSabDomFer = get(\"formulario.ckConsideraSabDomFer\");\r	var dsctoImpstoVtaPagos = get(\"formulario.ckDsctoImpstoVtaPagos\");\r\r	if(varIndComparativo==\"S\"){\r		varIndComparativo = \"true\";\r	}\r	else {\r		varIndComparativo = \"false\";\r	}\r\r	var varIndTratamientoDif = get(\"formulario.rbTratamientoDiferencialAntigua\");\r	if(varIndTratamientoDif==\"S\") {\r		varIndTratamientoDif = \"true\";\r	}\r	else {\r		varIndTratamientoDif = \"false\";\r	}\r\r   	var varOidPlantilla = get(\"formulario.varOidPlantilla\");\r\r	var arrayaccesos = new Array();\r	var j = 0;\r	for(var i=0 ;i<acceso.length; i++) {\r		var temp = acceso[i];\r		if(temp!='') {\r			arrayaccesos[j] = acceso[i];\r			j++;\r		}\r	}\r			  \r	set(\"formulario.marca\", marca);\r	set(\"formulario.descMarca\", descMarca);\r	set(\"formulario.canal\", canal);\r  	set(\"formulario.descCanal\", descCanal);\r	set(\"formulario.acceso\", arrayaccesos);\r	set(\"formulario.periodoDesde\", periodoDesde);\r	set(\"formulario.periodoHasta\", periodoHasta);\r	set(\"formulario.periodosEspera\", periodosEspera);\r	set(\"formulario.varIndComparativo\", varIndComparativo);\r	set(\"formulario.varIndTratamientoDif\", varIndTratamientoDif);\r	set(\"formulario.varOidPlantilla\", varOidPlantilla);\r\r		set(\"formulario.consideraSabDomFer\", consideraSabDomFer);\r	set(\"formulario.dsctoImpstoVtaPagos\", dsctoImpstoVtaPagos);\r			  \r	if(valor==\"Productos\") {\r		set(\"formulario.idPestanyaDest\", \"2\");\r	}\r	else if(valor==\"Clientes\") {\r		set(\"formulario.idPestanyaDest\", \"3\");\r	}\r	else if(valor==\"DatosCalculo\") {\r		set(\"formulario.idPestanyaDest\", \"4\");\r	}\r\r	set(\"formulario.conectorAction\", \"LPMantenimientoComisionesDatosGenerales\");\r 	set(\"formulario.titulo\", get(\"formulario.titulo\"));\r	set(\"formulario.oidTipoPlantilla\", get(\"formulario.oidTipoPlantilla\"));\r	set(\"formulario.accion\", \"almacenar\");\r  	set(\"formulario.opcionMenu\", opcionMenu);\r  	set(\"formulario.estadoVentana\", estadoVentana);\r	enviaSICC(\"formulario\");     \r}\r\rfunction fGuardar() {\r  onClickGuardar();\r}\r\rfunction onClickGuardar() {\r  if(!sicc_validaciones_generales())\r    return;\r\r  var marca = get(\"formulario.cbMarca\");\r  var descMarca = get(\"formulario.cbMarca\", \"T\");\r  var canal = get(\"formulario.varOidCanal\");\r  var descCanal = get(\"formulario.descCanal\");\r  var acceso = get(\"formulario.cbAcceso\");\r  var periodoDesde = get(\"formulario.cbPeriodoDesde\");\r  var periodoHasta = get(\"formulario.cbPeriodoHasta\");\r  var periodosEspera = get(\"formulario.txtNumPeriodosEspera\");\r  var varIndComparativo = get(\"formulario.rbComparativo\");\r\r    var consideraSabDomFer = get(\"formulario.ckConsideraSabDomFer\");\r  var dsctoImpstoVtaPagos = get(\"formulario.ckDsctoImpstoVtaPagos\");\r\r\r	if(varIndComparativo==\"S\"){\r		varIndComparativo = \"true\";\r	}\r	else {\r		varIndComparativo = \"false\";\r	}\r\r	var varIndTratamientoDif = get(\"formulario.rbTratamientoDiferencialAntigua\");\r	if(varIndTratamientoDif==\"S\") {\r		varIndTratamientoDif = \"true\";\r	}\r	else {\r		varIndTratamientoDif = \"false\";\r	}\r\r  var oidTipoPlantilla = get(\"formulario.oidTipoPlantilla\");\r  \r  set(\"formulario.marca\", marca);\r  set(\"formulario.descMarca\", descMarca);\r  set(\"formulario.canal\", canal);\r  set(\"formulario.descCanal\", descCanal);\r  set(\"formulario.acceso\", acceso);\r  set(\"formulario.periodoDesde\", periodoDesde);\r  set(\"formulario.periodoHasta\", periodoHasta);\r  set(\"formulario.periodosEspera\", periodosEspera);\r  set(\"formulario.varIndComparativo\", varIndComparativo);\r  set(\"formulario.varIndTratamientoDif\", varIndTratamientoDif);\r\r    set(\"formulario.consideraSabDomFer\", consideraSabDomFer);\r  set(\"formulario.dsctoImpstoVtaPagos\", dsctoImpstoVtaPagos);\r\r  var datosClientes = get(\"formulario.datosPestanyaClientes\");\r  var datosPestanyaDatosCalculo = get(\"formulario.datosPestanyaDatosCalculo\");\r\r  if((oidTipoPlantilla==\"\") && (datosPestanyaDatosCalculo==\"false\")) {\r	GestionarMensaje('1544',null,null,null)\r	return false;\r  }\r\r  if((datosClientes==\"false\") || (datosPestanyaDatosCalculo==\"false\")) {\r	var resp = GestionarMensaje('1543',null,null,null);\r\r	if(resp==true) {\r		eval(\"formulario\").oculto= \"S\";\r		set(\"formulario.conectorAction\", \"LPMantenimientoComisionesDatosGenerales\");\r		set(\"formulario.accion\", \"guardar\");\r		enviaSICC(\"formulario\");\r	}\r	else {\r		return;\r	}\r  }\r  else {\r	  eval(\"formulario\").oculto= \"S\";\r	  set(\"formulario.conectorAction\", \"LPMantenimientoComisionesDatosGenerales\");\r	  set(\"formulario.accion\", \"guardar\");\r	  enviaSICC(\"formulario\");\r  }  \r}\r\rfunction poneManito(nombre) {           \r  var nombre = document.getElementById(nombre);\r  nombre.style.cursor = \"hand\";\r}    \r\rfunction fErrorAlGuardar() {\r	focoDescripcion();	\r}\r\rfunction fLimpiar() {\r	onLoadPag();\r	}\r\rfunction limpiarRadioButtons() {\r	document.all.rbComparativo[0].disabled= false;\r	document.all.rbComparativo[1].disabled= false;\r	document.all.rbTratamientoDiferencialAntigua[0].disabled = false;\r	document.all.rbTratamientoDiferencialAntigua[1].disabled = false;\r}\r\rfunction reInicio() {\r	focoDescripcion();\r}\r\rfunction focoIndicadorComparativo() {\r	focaliza(\"formulario.rbComparativo\");\r}\r\rfunction fVolver() {\r						  				  			\r	window.close();\r}\r\r \r"));
      ((Element)v.get(5)).appendChild((Text)v.get(6));

      /* Termina nodo Texto:6   */
      /* Termina nodo:5   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","cbMarca" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","6" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","cbAcceso" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","10" );
      ((Element)v.get(7)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","cbPeriodoDesde" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("cod","1175" );
      ((Element)v.get(7)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","cbPeriodoHasta" );
      ((Element)v.get(11)).setAttribute("required","true" );
      ((Element)v.get(11)).setAttribute("cod","1176" );
      ((Element)v.get(7)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","txtNumPeriodosEspera" );
      ((Element)v.get(12)).setAttribute("required","false" );
      ((Element)v.get(12)).setAttribute("cod","1718" );
      ((Element)v.get(12)).setAttribute("format","e" );
      ((Element)v.get(12)).setAttribute("min","0" );
      ((Element)v.get(12)).setAttribute("max","99" );
      ((Element)v.get(7)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(13)).setAttribute("name","rbComparativo" );
      ((Element)v.get(13)).setAttribute("required","true" );
      ((Element)v.get(13)).setAttribute("cod","1719" );
      ((Element)v.get(7)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(14)).setAttribute("name","rbTratamientoDiferencialAntigua" );
      ((Element)v.get(14)).setAttribute("required","true" );
      ((Element)v.get(14)).setAttribute("cod","1700" );
      ((Element)v.get(7)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */
      /* Termina nodo:7   */

      /* Empieza nodo:15 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(15)).setAttribute("nombre","formulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(15));

      /* Empieza nodo:16 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","estadoVentana" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","oidTipoPlantilla" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","titulo" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","accion" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(21)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","varPais" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","varIdioma" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","varOidPlantilla" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","varOidCanal" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","varIndComparativo" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","varIndTratamientoDif" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","idPestanyaDest" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","marca" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","descMarca" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","canal" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","descCanal" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","acceso" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","periodoDesde" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","periodoHasta" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","periodosEspera" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","comparativo" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","indTratamientoDif" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","consideraSabDomFer" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","dsctoImpstoVtaPagos" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","sDescripcionComision" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","sOidMarca" );
      ((Element)v.get(43)).setAttribute("valor","" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(15)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","sOidAccesos" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","sOidPeriodoDesde" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","sOidPeriodoHasta" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","sNumeroPeriodosEspera" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","sConsideraSabDomFer" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","sDsctoImpstoVtaPagos" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(51)).setAttribute("nombre","solicitudAutorizada" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(52)).setAttribute("nombre","datosPestanyaClientes" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(53)).setAttribute("nombre","datosPestanyaDatosCalculo" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(54)).setAttribute("nombre","marcoAccesos" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(55)).setAttribute("nombre","varDeshabilitarTratDif" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(56)).setAttribute("nombre","varDeshabilitarComparativo" );
      ((Element)v.get(56)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 15   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(57)).setAttribute("nombre","capa1" );
      ((Element)v.get(15)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("table"));
      ((Element)v.get(58)).setAttribute("width","100%" );
      ((Element)v.get(58)).setAttribute("height","100%" );
      ((Element)v.get(58)).setAttribute("border","0" );
      ((Element)v.get(58)).setAttribute("align","center" );
      ((Element)v.get(58)).setAttribute("cellpadding","0" );
      ((Element)v.get(58)).setAttribute("cellspacing","0" );
      ((Element)v.get(58)).setAttribute("class","menu4" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).setAttribute("width","12" );
      ((Element)v.get(60)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(60)).setAttribute("class","menu5texto" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(61)).setAttribute("src","b.gif" );
      ((Element)v.get(61)).setAttribute("width","12" );
      ((Element)v.get(61)).setAttribute("height","30" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:62 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(62)).setAttribute("class","menu5texto" );
      ((Element)v.get(59)).appendChild((Element)v.get(62));

      /* Elemento padre:62 / Elemento actual: 63   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(62)).appendChild((Text)v.get(63));

      /* Termina nodo Texto:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:64 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).setAttribute("width","10" );
      ((Element)v.get(64)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(64)).setAttribute("class","menu5texto" );
      ((Element)v.get(59)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(65)).setAttribute("src","b.gif" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(65)).setAttribute("width","10" );
      ((Element)v.get(65)).setAttribute("height","8" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:66 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).setAttribute("width","92" );
      ((Element)v.get(66)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(66)).setAttribute("class","menu5texto" );
      ((Element)v.get(59)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("table"));
      ((Element)v.get(67)).setAttribute("width","75" );
      ((Element)v.get(67)).setAttribute("border","1" );
      ((Element)v.get(67)).setAttribute("align","center" );
      ((Element)v.get(67)).setAttribute("cellpadding","1" );
      ((Element)v.get(67)).setAttribute("cellspacing","0" );
      ((Element)v.get(67)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(67)).setAttribute("bgcolor","#496A9A" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(68)).setAttribute("align","center" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(70)).setAttribute("nombre","lblDGC" );
      ((Element)v.get(70)).setAttribute("alto","13" );
      ((Element)v.get(70)).setAttribute("filas","1" );
      ((Element)v.get(70)).setAttribute("valor","" );
      ((Element)v.get(70)).setAttribute("id","menu5textoblanca" );
      ((Element)v.get(70)).setAttribute("cod","00543" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:71 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).setAttribute("width","10" );
      ((Element)v.get(71)).setAttribute("class","menu5texto" );
      ((Element)v.get(59)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(72)).setAttribute("src","b.gif" );
      ((Element)v.get(72)).setAttribute("width","10" );
      ((Element)v.get(72)).setAttribute("height","8" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:73 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).setAttribute("width","20" );
      ((Element)v.get(73)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(73)).setAttribute("class","menu5texto" );
      ((Element)v.get(59)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("table"));
      ((Element)v.get(74)).setAttribute("width","75" );
      ((Element)v.get(74)).setAttribute("border","1" );
      ((Element)v.get(74)).setAttribute("align","center" );
      ((Element)v.get(74)).setAttribute("cellpadding","1" );
      ((Element)v.get(74)).setAttribute("cellspacing","0" );
      ((Element)v.get(74)).setAttribute("ID","Productos" );
      ((Element)v.get(74)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(74)).setAttribute("onclick","onClickPestanya('Productos');" );
      ((Element)v.get(74)).setAttribute("onmouseover","poneManito('Productos');" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(75)).setAttribute("align","center" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("td"));
      ((Element)v.get(76)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(77)).setAttribute("nombre","lblProductos" );
      ((Element)v.get(77)).setAttribute("alto","13" );
      ((Element)v.get(77)).setAttribute("filas","1" );
      ((Element)v.get(77)).setAttribute("valor","" );
      ((Element)v.get(77)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(77)).setAttribute("cod","0094" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */
      /* Termina nodo:75   */
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:78 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).setAttribute("width","10" );
      ((Element)v.get(78)).setAttribute("class","menu5texto" );
      ((Element)v.get(59)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).setAttribute("width","10" );
      ((Element)v.get(79)).setAttribute("height","8" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:80 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).setAttribute("width","20" );
      ((Element)v.get(80)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(80)).setAttribute("class","menu5texto" );
      ((Element)v.get(59)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("table"));
      ((Element)v.get(81)).setAttribute("width","75" );
      ((Element)v.get(81)).setAttribute("border","1" );
      ((Element)v.get(81)).setAttribute("align","center" );
      ((Element)v.get(81)).setAttribute("cellpadding","1" );
      ((Element)v.get(81)).setAttribute("cellspacing","0" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(81)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(81)).setAttribute("ID","Clientes" );
      ((Element)v.get(81)).setAttribute("onclick","onClickPestanya('Clientes');" );
      ((Element)v.get(81)).setAttribute("onmouseover","poneManito('Clientes');" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(82)).setAttribute("align","center" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(84)).setAttribute("nombre","lblClientes" );
      ((Element)v.get(84)).setAttribute("alto","13" );
      ((Element)v.get(84)).setAttribute("filas","1" );
      ((Element)v.get(84)).setAttribute("valor","" );
      ((Element)v.get(84)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(84)).setAttribute("cod","0026" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */
      /* Termina nodo:82   */
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:85 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).setAttribute("width","10" );
      ((Element)v.get(85)).setAttribute("class","menu5texto" );
      ((Element)v.get(59)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(86)).setAttribute("src","b.gif" );
      ((Element)v.get(86)).setAttribute("width","10" );
      ((Element)v.get(86)).setAttribute("height","8" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(87)).setAttribute("width","20" );
      ((Element)v.get(87)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(87)).setAttribute("class","menu5texto" );
      ((Element)v.get(59)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("table"));
      ((Element)v.get(88)).setAttribute("width","75" );
      ((Element)v.get(88)).setAttribute("border","1" );
      ((Element)v.get(88)).setAttribute("align","center" );
      ((Element)v.get(88)).setAttribute("cellpadding","1" );
      ((Element)v.get(88)).setAttribute("cellspacing","0" );
      ((Element)v.get(88)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(88)).setAttribute("ID","DatosCalculo" );
      ((Element)v.get(88)).setAttribute("onclick","onClickPestanya('DatosCalculo');" );
      ((Element)v.get(88)).setAttribute("onmouseover","poneManito('DatosCalculo');" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(89)).setAttribute("align","center" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(91)).setAttribute("nombre","lblDatosC" );
      ((Element)v.get(91)).setAttribute("alto","13" );
      ((Element)v.get(91)).setAttribute("filas","1" );
      ((Element)v.get(91)).setAttribute("valor","" );
      ((Element)v.get(91)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(91)).setAttribute("cod","00544" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */
      /* Termina nodo:89   */
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:92 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(92)).setAttribute("width","16" );
      ((Element)v.get(92)).setAttribute("class","menu5texto" );
      ((Element)v.get(59)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(93)).setAttribute("src","b.gif" );
      ((Element)v.get(93)).setAttribute("width","12" );
      ((Element)v.get(93)).setAttribute("height","8" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:94 / Elemento padre: 57   */
      v.add(doc.createElement("table"));
      ((Element)v.get(94)).setAttribute("width","100%" );
      ((Element)v.get(94)).setAttribute("border","0" );
      ((Element)v.get(94)).setAttribute("cellspacing","0" );
      ((Element)v.get(94)).setAttribute("cellpadding","0" );
      ((Element)v.get(57)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).setAttribute("width","12" );
      ((Element)v.get(96)).setAttribute("align","center" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(97)).setAttribute("src","b.gif" );
      ((Element)v.get(97)).setAttribute("width","12" );
      ((Element)v.get(97)).setAttribute("height","12" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:98 / Elemento padre: 95   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).setAttribute("width","750" );
      ((Element)v.get(95)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(99)).setAttribute("src","b.gif" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:100 / Elemento padre: 95   */
   }

   private void getXML450(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).setAttribute("width","12" );
      ((Element)v.get(95)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(101)).setAttribute("src","b.gif" );
      ((Element)v.get(101)).setAttribute("width","12" );
      ((Element)v.get(101)).setAttribute("height","1" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */
      /* Termina nodo:95   */

      /* Empieza nodo:102 / Elemento padre: 94   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(94)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(104)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:105 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(105)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(107)).setAttribute("class","legend" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(108)).setAttribute("nombre","lblDatosComision" );
      ((Element)v.get(108)).setAttribute("alto","13" );
      ((Element)v.get(108)).setAttribute("filas","1" );
      ((Element)v.get(108)).setAttribute("valor","" );
      ((Element)v.get(108)).setAttribute("id","legend" );
      ((Element)v.get(108)).setAttribute("cod","00363" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:109 / Elemento padre: 106   */
      v.add(doc.createElement("table"));
      ((Element)v.get(109)).setAttribute("width","100%" );
      ((Element)v.get(109)).setAttribute("border","0" );
      ((Element)v.get(109)).setAttribute("align","center" );
      ((Element)v.get(109)).setAttribute("cellspacing","0" );
      ((Element)v.get(109)).setAttribute("cellpadding","0" );
      ((Element)v.get(106)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("table"));
      ((Element)v.get(112)).setAttribute("width","100%" );
      ((Element)v.get(112)).setAttribute("border","0" );
      ((Element)v.get(112)).setAttribute("align","left" );
      ((Element)v.get(112)).setAttribute("cellspacing","0" );
      ((Element)v.get(112)).setAttribute("cellpadding","0" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).setAttribute("colspan","4" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(115)).setAttribute("src","b.gif" );
      ((Element)v.get(115)).setAttribute("width","8" );
      ((Element)v.get(115)).setAttribute("height","8" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:116 / Elemento padre: 112   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(112)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(118)).setAttribute("src","b.gif" );
      ((Element)v.get(118)).setAttribute("width","8" );
      ((Element)v.get(118)).setAttribute("height","8" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:119 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).setAttribute("colspan","3" );
      ((Element)v.get(116)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(120)).setAttribute("nombre","lblDescripcionComision" );
      ((Element)v.get(120)).setAttribute("alto","13" );
      ((Element)v.get(120)).setAttribute("filas","1" );
      ((Element)v.get(120)).setAttribute("valor","" );
      ((Element)v.get(120)).setAttribute("id","datosTitle" );
      ((Element)v.get(120)).setAttribute("cod","1710" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */

      /* Empieza nodo:121 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(122)).setAttribute("src","b.gif" );
      ((Element)v.get(122)).setAttribute("width","25" );
      ((Element)v.get(122)).setAttribute("height","8" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:123 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(124)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(124)).setAttribute("alto","13" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(124)).setAttribute("filas","1" );
      ((Element)v.get(124)).setAttribute("valor","" );
      ((Element)v.get(124)).setAttribute("id","datosTitle" );
      ((Element)v.get(124)).setAttribute("cod","6" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:125 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).setAttribute("width","100%" );
      ((Element)v.get(116)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(126)).setAttribute("src","b.gif" );
      ((Element)v.get(126)).setAttribute("width","8" );
      ((Element)v.get(126)).setAttribute("height","8" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */
      /* Termina nodo:116   */

      /* Empieza nodo:127 / Elemento padre: 112   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(112)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(129)).setAttribute("src","b.gif" );
      ((Element)v.get(129)).setAttribute("width","8" );
      ((Element)v.get(129)).setAttribute("height","8" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */

      /* Empieza nodo:130 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(130)).setAttribute("valign","bottom" );
      ((Element)v.get(127)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(131)).setAttribute("nombre","txtDescripcionComision" );
      ((Element)v.get(131)).setAttribute("id","datosCampos" );
      ((Element)v.get(131)).setAttribute("max","50" );
      ((Element)v.get(131)).setAttribute("tipo","" );
      ((Element)v.get(131)).setAttribute("onchange","" );
      ((Element)v.get(131)).setAttribute("req","N" );
      ((Element)v.get(131)).setAttribute("size","50" );
      ((Element)v.get(131)).setAttribute("valor","" );
      ((Element)v.get(131)).setAttribute("validacion","" );
      ((Element)v.get(131)).setAttribute("onshtab","onShTabDescripcion();" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:132 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(133)).setAttribute("src","b.gif" );
      ((Element)v.get(133)).setAttribute("width","8" );
      ((Element)v.get(133)).setAttribute("height","8" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */

      /* Empieza nodo:134 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(135)).setAttribute("src","iconmultidioma.gif" );
      ((Element)v.get(135)).setAttribute("width","21" );
      ((Element)v.get(135)).setAttribute("height","15" );
      ((Element)v.get(135)).setAttribute("onclick","levantarI18N('formulario','1');" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:136 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(137)).setAttribute("src","b.gif" );
      ((Element)v.get(137)).setAttribute("width","25" );
      ((Element)v.get(137)).setAttribute("height","8" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */

      /* Empieza nodo:138 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(138)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(127)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(139)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(139)).setAttribute("id","datosCampos" );
      ((Element)v.get(139)).setAttribute("size","1" );
      ((Element)v.get(139)).setAttribute("multiple","N" );
      ((Element)v.get(139)).setAttribute("req","S" );
      ((Element)v.get(139)).setAttribute("valorinicial","" );
      ((Element)v.get(139)).setAttribute("textoinicial","" );
      ((Element)v.get(139)).setAttribute("onchange","onSeleccionaMarca();" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */
      /* Termina nodo:138   */

      /* Empieza nodo:141 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(141)).setAttribute("width","100%" );
      ((Element)v.get(127)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(142)).setAttribute("src","b.gif" );
      ((Element)v.get(142)).setAttribute("width","8" );
      ((Element)v.get(142)).setAttribute("height","8" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */
      /* Termina nodo:127   */

      /* Empieza nodo:143 / Elemento padre: 112   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(112)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("td"));
      ((Element)v.get(144)).setAttribute("colspan","4" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(145)).setAttribute("src","b.gif" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(145)).setAttribute("width","8" );
      ((Element)v.get(145)).setAttribute("height","8" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:144   */
      /* Termina nodo:143   */
      /* Termina nodo:112   */
      /* Termina nodo:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:146 / Elemento padre: 109   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(109)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("table"));
      ((Element)v.get(148)).setAttribute("width","100%" );
      ((Element)v.get(148)).setAttribute("border","0" );
      ((Element)v.get(148)).setAttribute("align","left" );
      ((Element)v.get(148)).setAttribute("cellspacing","0" );
      ((Element)v.get(148)).setAttribute("cellpadding","0" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(148)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(151)).setAttribute("src","b.gif" );
      ((Element)v.get(151)).setAttribute("width","8" );
      ((Element)v.get(151)).setAttribute("height","8" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:152 / Elemento padre: 149   */
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(153)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(153)).setAttribute("alto","13" );
      ((Element)v.get(153)).setAttribute("filas","1" );
      ((Element)v.get(153)).setAttribute("valor","" );
      ((Element)v.get(153)).setAttribute("id","datosTitle" );
      ((Element)v.get(153)).setAttribute("cod","7" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:152   */

      /* Empieza nodo:154 / Elemento padre: 149   */
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(155)).setAttribute("src","b.gif" );
      ((Element)v.get(155)).setAttribute("width","25" );
      ((Element)v.get(155)).setAttribute("height","8" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */
      /* Termina nodo:154   */

      /* Empieza nodo:156 / Elemento padre: 149   */
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(157)).setAttribute("nombre","lblAcceso" );
      ((Element)v.get(157)).setAttribute("alto","13" );
      ((Element)v.get(157)).setAttribute("filas","1" );
      ((Element)v.get(157)).setAttribute("valor","" );
      ((Element)v.get(157)).setAttribute("id","datosTitle" );
      ((Element)v.get(157)).setAttribute("cod","10" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */
      /* Termina nodo:156   */

      /* Empieza nodo:158 / Elemento padre: 149   */
      v.add(doc.createElement("td"));
      ((Element)v.get(158)).setAttribute("width","100%" );
      ((Element)v.get(149)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(159)).setAttribute("src","b.gif" );
      ((Element)v.get(159)).setAttribute("width","8" );
      ((Element)v.get(159)).setAttribute("height","8" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */
      /* Termina nodo:149   */

      /* Empieza nodo:160 / Elemento padre: 148   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(148)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(162)).setAttribute("src","b.gif" );
      ((Element)v.get(162)).setAttribute("width","8" );
      ((Element)v.get(162)).setAttribute("height","8" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */
      /* Termina nodo:161   */

      /* Empieza nodo:163 / Elemento padre: 160   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(163)).setAttribute("valign","top" );
      ((Element)v.get(160)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(164)).setAttribute("nombre","lbldtCanal" );
      ((Element)v.get(164)).setAttribute("alto","13" );
      ((Element)v.get(164)).setAttribute("filas","1" );
      ((Element)v.get(164)).setAttribute("valor","" );
      ((Element)v.get(164)).setAttribute("id","datosCampos" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */

      /* Empieza nodo:165 / Elemento padre: 160   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(166)).setAttribute("src","b.gif" );
      ((Element)v.get(166)).setAttribute("width","8" );
      ((Element)v.get(166)).setAttribute("height","8" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:165   */

      /* Empieza nodo:167 / Elemento padre: 160   */
      v.add(doc.createElement("td"));
      ((Element)v.get(167)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(160)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(168)).setAttribute("nombre","cbAcceso" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(168)).setAttribute("id","datosCampos" );
      ((Element)v.get(168)).setAttribute("size","5" );
      ((Element)v.get(168)).setAttribute("multiple","S" );
      ((Element)v.get(168)).setAttribute("req","S" );
      ((Element)v.get(168)).setAttribute("valorinicial","" );
      ((Element)v.get(168)).setAttribute("textoinicial","" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(168)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */
      /* Termina nodo:168   */
      /* Termina nodo:167   */

      /* Empieza nodo:170 / Elemento padre: 160   */
      v.add(doc.createElement("td"));
      ((Element)v.get(170)).setAttribute("width","100%" );
      ((Element)v.get(160)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(171)).setAttribute("src","b.gif" );
      ((Element)v.get(171)).setAttribute("width","8" );
      ((Element)v.get(171)).setAttribute("height","8" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:170   */
      /* Termina nodo:160   */

      /* Empieza nodo:172 / Elemento padre: 148   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(148)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(173)).setAttribute("colspan","4" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(174)).setAttribute("src","b.gif" );
      ((Element)v.get(174)).setAttribute("width","8" );
      ((Element)v.get(174)).setAttribute("height","8" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */
      /* Termina nodo:173   */
      /* Termina nodo:172   */
      /* Termina nodo:148   */
      /* Termina nodo:147   */
      /* Termina nodo:146   */

      /* Empieza nodo:175 / Elemento padre: 109   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(109)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("table"));
      ((Element)v.get(177)).setAttribute("width","100%" );
      ((Element)v.get(177)).setAttribute("border","0" );
      ((Element)v.get(177)).setAttribute("align","left" );
      ((Element)v.get(177)).setAttribute("cellspacing","0" );
      ((Element)v.get(177)).setAttribute("cellpadding","0" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(177)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(180)).setAttribute("src","b.gif" );
      ((Element)v.get(180)).setAttribute("width","8" );
      ((Element)v.get(180)).setAttribute("height","8" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */
      /* Termina nodo:179   */

      /* Empieza nodo:181 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(182)).setAttribute("nombre","lblPeriodoDesde" );
      ((Element)v.get(182)).setAttribute("alto","13" );
      ((Element)v.get(182)).setAttribute("filas","1" );
      ((Element)v.get(182)).setAttribute("valor","" );
      ((Element)v.get(182)).setAttribute("id","datosTitle" );
      ((Element)v.get(182)).setAttribute("cod","1175" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:181   */

      /* Empieza nodo:183 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(184)).setAttribute("src","b.gif" );
      ((Element)v.get(184)).setAttribute("width","25" );
      ((Element)v.get(184)).setAttribute("height","8" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */

      /* Empieza nodo:185 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(186)).setAttribute("nombre","lblPeriodoHasta" );
      ((Element)v.get(186)).setAttribute("alto","13" );
      ((Element)v.get(186)).setAttribute("filas","1" );
      ((Element)v.get(186)).setAttribute("valor","" );
      ((Element)v.get(186)).setAttribute("id","datosTitle" );
      ((Element)v.get(186)).setAttribute("cod","1176" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:187 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(188)).setAttribute("src","b.gif" );
      ((Element)v.get(188)).setAttribute("width","25" );
      ((Element)v.get(188)).setAttribute("height","8" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */

      /* Empieza nodo:189 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(190)).setAttribute("nombre","lblNumPeriodosEspera" );
      ((Element)v.get(190)).setAttribute("alto","13" );
      ((Element)v.get(190)).setAttribute("filas","1" );
      ((Element)v.get(190)).setAttribute("valor","Tipo período desde" );
      ((Element)v.get(190)).setAttribute("id","datosTitle" );
      ((Element)v.get(190)).setAttribute("cod","1718" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:189   */

      /* Empieza nodo:191 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(192)).setAttribute("src","b.gif" );
      ((Element)v.get(192)).setAttribute("width","25" );
      ((Element)v.get(192)).setAttribute("height","8" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:191   */

      /* Empieza nodo:193 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(194)).setAttribute("nombre","lblComparativo" );
      ((Element)v.get(194)).setAttribute("alto","13" );
      ((Element)v.get(194)).setAttribute("filas","1" );
      ((Element)v.get(194)).setAttribute("valor","" );
      ((Element)v.get(194)).setAttribute("id","datosTitle" );
      ((Element)v.get(194)).setAttribute("cod","1719" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */
      /* Termina nodo:193   */

      /* Empieza nodo:195 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(196)).setAttribute("src","b.gif" );
      ((Element)v.get(196)).setAttribute("width","25" );
      ((Element)v.get(196)).setAttribute("height","8" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:195   */

      /* Empieza nodo:197 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(198)).setAttribute("nombre","lblTratamientoDiferencialAntiguas" );
      ((Element)v.get(198)).setAttribute("alto","13" );
      ((Element)v.get(198)).setAttribute("filas","1" );
      ((Element)v.get(198)).setAttribute("valor","Tipo período hasta" );
      ((Element)v.get(198)).setAttribute("id","datosTitle" );
      ((Element)v.get(198)).setAttribute("cod","1700" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:197   */

      /* Empieza nodo:199 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(200)).setAttribute("src","b.gif" );
      ((Element)v.get(200)).setAttribute("width","25" );
      ((Element)v.get(200)).setAttribute("height","8" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:199   */

      /* Empieza nodo:201 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(202)).setAttribute("nombre","lblConsideraSabDomFer" );
      ((Element)v.get(202)).setAttribute("alto","13" );
      ((Element)v.get(202)).setAttribute("filas","1" );
      ((Element)v.get(202)).setAttribute("valor","" );
      ((Element)v.get(202)).setAttribute("id","datosTitle" );
      ((Element)v.get(202)).setAttribute("cod","3440" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:201   */

      /* Empieza nodo:203 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(204)).setAttribute("src","b.gif" );
      ((Element)v.get(204)).setAttribute("width","25" );
      ((Element)v.get(204)).setAttribute("height","8" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:203   */

      /* Empieza nodo:205 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(206)).setAttribute("nombre","lblDsctoImpstoVtaPagos" );
      ((Element)v.get(206)).setAttribute("alto","13" );
      ((Element)v.get(206)).setAttribute("filas","1" );
      ((Element)v.get(206)).setAttribute("valor","" );
      ((Element)v.get(206)).setAttribute("id","datosTitle" );
      ((Element)v.get(206)).setAttribute("cod","3441" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:205   */

      /* Empieza nodo:207 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(207)).setAttribute("width","100%" );
      ((Element)v.get(178)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(208)).setAttribute("src","b.gif" );
      ((Element)v.get(208)).setAttribute("width","8" );
      ((Element)v.get(208)).setAttribute("height","8" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */
      /* Termina nodo:207   */
      /* Termina nodo:178   */

      /* Empieza nodo:209 / Elemento padre: 177   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(177)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(209)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(211)).setAttribute("src","b.gif" );
      ((Element)v.get(211)).setAttribute("width","8" );
      ((Element)v.get(211)).setAttribute("height","8" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */
      /* Termina nodo:210   */

      /* Empieza nodo:212 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(212)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(209)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("COMBO"));
   }

   private void getXML900(Document doc) {
      ((Element)v.get(213)).setAttribute("nombre","cbPeriodoDesde" );
      ((Element)v.get(213)).setAttribute("id","datosCampos" );
      ((Element)v.get(213)).setAttribute("size","1" );
      ((Element)v.get(213)).setAttribute("multiple","N" );
      ((Element)v.get(213)).setAttribute("req","S" );
      ((Element)v.get(213)).setAttribute("valorinicial","" );
      ((Element)v.get(213)).setAttribute("textoinicial","" );
      ((Element)v.get(213)).setAttribute("onchange","onChangePeriodoDesde();" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:213   */
      /* Termina nodo:212   */

      /* Empieza nodo:215 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(209)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(216)).setAttribute("src","b.gif" );
      ((Element)v.get(216)).setAttribute("width","25" );
      ((Element)v.get(216)).setAttribute("height","8" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */
      /* Termina nodo:215   */

      /* Empieza nodo:217 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(217)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(209)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(218)).setAttribute("nombre","cbPeriodoHasta" );
      ((Element)v.get(218)).setAttribute("id","datosCampos" );
      ((Element)v.get(218)).setAttribute("size","1" );
      ((Element)v.get(218)).setAttribute("multiple","N" );
      ((Element)v.get(218)).setAttribute("req","S" );
      ((Element)v.get(218)).setAttribute("valorinicial","" );
      ((Element)v.get(218)).setAttribute("textoinicial","" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */
      /* Termina nodo:217   */

      /* Empieza nodo:220 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(209)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(221)).setAttribute("src","b.gif" );
      ((Element)v.get(221)).setAttribute("width","25" );
      ((Element)v.get(221)).setAttribute("height","8" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */
      /* Termina nodo:220   */

      /* Empieza nodo:222 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(222)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(222)).setAttribute("valign","bottom" );
      ((Element)v.get(209)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(223)).setAttribute("nombre","txtNumPeriodosEspera" );
      ((Element)v.get(223)).setAttribute("id","datosCampos" );
      ((Element)v.get(223)).setAttribute("max","2" );
      ((Element)v.get(223)).setAttribute("tipo","" );
      ((Element)v.get(223)).setAttribute("onchange","" );
      ((Element)v.get(223)).setAttribute("req","N" );
      ((Element)v.get(223)).setAttribute("size","2" );
      ((Element)v.get(223)).setAttribute("valor","" );
      ((Element)v.get(223)).setAttribute("validacion","" );
      ((Element)v.get(222)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */
      /* Termina nodo:222   */

      /* Empieza nodo:224 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(209)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(225)).setAttribute("src","b.gif" );
      ((Element)v.get(225)).setAttribute("width","25" );
      ((Element)v.get(225)).setAttribute("height","8" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */
      /* Termina nodo:224   */

      /* Empieza nodo:226 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(226)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(226)).setAttribute("valign","bottom" );
      ((Element)v.get(209)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("table"));
      ((Element)v.get(227)).setAttribute("width","100%" );
      ((Element)v.get(227)).setAttribute("border","0" );
      ((Element)v.get(227)).setAttribute("cellspacing","0" );
      ((Element)v.get(227)).setAttribute("cellpadding","0" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(227)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("td"));
      ((Element)v.get(229)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(229)).setAttribute("class","datosCampos" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(230)).setAttribute("nombre","rbComparativo" );
      ((Element)v.get(230)).setAttribute("tipo","H" );
      ((Element)v.get(230)).setAttribute("id","datosCampos" );
      ((Element)v.get(230)).setAttribute("req","S" );
      ((Element)v.get(230)).setAttribute("ontab","onTabComparativo();" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(231)).setAttribute("valor","S" );
      ((Element)v.get(231)).setAttribute("check","N" );
      ((Element)v.get(231)).setAttribute("onfocus","" );
      ((Element)v.get(231)).setAttribute("id","datosCampos" );
      ((Element)v.get(231)).setAttribute("cod","117" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(230)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */

      /* Empieza nodo:232 / Elemento padre: 230   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(232)).setAttribute("valor","N" );
      ((Element)v.get(232)).setAttribute("check","N" );
      ((Element)v.get(232)).setAttribute("onfocus","" );
      ((Element)v.get(232)).setAttribute("id","datosCampos" );
      ((Element)v.get(232)).setAttribute("cod","87" );
      ((Element)v.get(230)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */
      /* Termina nodo:230   */
      /* Termina nodo:229   */
      /* Termina nodo:228   */
      /* Termina nodo:227   */
      /* Termina nodo:226   */

      /* Empieza nodo:233 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(209)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(234)).setAttribute("src","b.gif" );
      ((Element)v.get(234)).setAttribute("width","25" );
      ((Element)v.get(234)).setAttribute("height","8" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */
      /* Termina nodo:233   */

      /* Empieza nodo:235 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(235)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(235)).setAttribute("valign","bottom" );
      ((Element)v.get(209)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("table"));
      ((Element)v.get(236)).setAttribute("width","100%" );
      ((Element)v.get(236)).setAttribute("border","0" );
      ((Element)v.get(236)).setAttribute("cellspacing","0" );
      ((Element)v.get(236)).setAttribute("cellpadding","0" );
      ((Element)v.get(235)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(236)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("td"));
      ((Element)v.get(238)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(238)).setAttribute("class","datosCampos" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(239)).setAttribute("nombre","rbTratamientoDiferencialAntigua" );
      ((Element)v.get(239)).setAttribute("tipo","H" );
      ((Element)v.get(239)).setAttribute("id","datosCampos" );
      ((Element)v.get(239)).setAttribute("req","S" );
      ((Element)v.get(239)).setAttribute("onshtab","onShtabTratamientoDiferencial();" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(240)).setAttribute("valor","S" );
      ((Element)v.get(240)).setAttribute("check","N" );
      ((Element)v.get(240)).setAttribute("onfocus","" );
      ((Element)v.get(240)).setAttribute("id","datosCampos" );
      ((Element)v.get(240)).setAttribute("cod","117" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */

      /* Empieza nodo:241 / Elemento padre: 239   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(241)).setAttribute("valor","N" );
      ((Element)v.get(241)).setAttribute("check","N" );
      ((Element)v.get(241)).setAttribute("onfocus","" );
      ((Element)v.get(241)).setAttribute("id","datosCampos" );
      ((Element)v.get(241)).setAttribute("cod","87" );
      ((Element)v.get(239)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */
      /* Termina nodo:239   */
      /* Termina nodo:238   */
      /* Termina nodo:237   */
      /* Termina nodo:236   */
      /* Termina nodo:235   */

      /* Empieza nodo:242 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(209)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(243)).setAttribute("src","b.gif" );
      ((Element)v.get(243)).setAttribute("width","25" );
      ((Element)v.get(243)).setAttribute("height","8" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */
      /* Termina nodo:242   */

      /* Empieza nodo:244 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(244)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(244)).setAttribute("valign","bottom" );
      ((Element)v.get(209)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(245)).setAttribute("nombre","ckConsideraSabDomFer" );
      ((Element)v.get(245)).setAttribute("id","datosCampos" );
      ((Element)v.get(245)).setAttribute("onclick","" );
      ((Element)v.get(245)).setAttribute("check","N" );
      ((Element)v.get(244)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */
      /* Termina nodo:244   */

      /* Empieza nodo:246 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(209)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(247)).setAttribute("src","b.gif" );
      ((Element)v.get(247)).setAttribute("width","25" );
      ((Element)v.get(247)).setAttribute("height","8" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */
      /* Termina nodo:246   */

      /* Empieza nodo:248 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(248)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(248)).setAttribute("valign","bottom" );
      ((Element)v.get(209)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(249)).setAttribute("nombre","ckDsctoImpstoVtaPagos" );
      ((Element)v.get(249)).setAttribute("id","datosCampos" );
      ((Element)v.get(249)).setAttribute("onclick","" );
      ((Element)v.get(249)).setAttribute("check","N" );
      ((Element)v.get(249)).setAttribute("ontab","focoDescripcion();" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */
      /* Termina nodo:248   */

      /* Empieza nodo:250 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(250)).setAttribute("width","100%" );
      ((Element)v.get(209)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
   }

   private void getXML1080(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(251)).setAttribute("src","b.gif" );
      ((Element)v.get(251)).setAttribute("width","8" );
      ((Element)v.get(251)).setAttribute("height","8" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */
      /* Termina nodo:250   */
      /* Termina nodo:209   */

      /* Empieza nodo:252 / Elemento padre: 177   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(177)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("td"));
      ((Element)v.get(253)).setAttribute("colspan","4" );
      ((Element)v.get(252)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(254)).setAttribute("src","b.gif" );
      ((Element)v.get(254)).setAttribute("width","8" );
      ((Element)v.get(254)).setAttribute("height","8" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */
      /* Termina nodo:253   */
      /* Termina nodo:252   */
      /* Termina nodo:177   */
      /* Termina nodo:176   */
      /* Termina nodo:175   */
      /* Termina nodo:109   */
      /* Termina nodo:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:255 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(256)).setAttribute("src","b.gif" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */
      /* Termina nodo:255   */
      /* Termina nodo:102   */

      /* Empieza nodo:257 / Elemento padre: 94   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(94)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("td"));
      ((Element)v.get(258)).setAttribute("width","12" );
      ((Element)v.get(258)).setAttribute("align","center" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(259)).setAttribute("src","b.gif" );
      ((Element)v.get(259)).setAttribute("width","12" );
      ((Element)v.get(259)).setAttribute("height","12" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */
      /* Termina nodo:258   */

      /* Empieza nodo:260 / Elemento padre: 257   */
      v.add(doc.createElement("td"));
      ((Element)v.get(260)).setAttribute("width","750" );
      ((Element)v.get(257)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(261)).setAttribute("src","b.gif" );
      ((Element)v.get(260)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */
      /* Termina nodo:260   */

      /* Empieza nodo:262 / Elemento padre: 257   */
      v.add(doc.createElement("td"));
      ((Element)v.get(262)).setAttribute("width","12" );
      ((Element)v.get(257)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(263)).setAttribute("src","b.gif" );
      ((Element)v.get(263)).setAttribute("width","12" );
      ((Element)v.get(263)).setAttribute("height","1" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */
      /* Termina nodo:262   */
      /* Termina nodo:257   */
      /* Termina nodo:94   */
      /* Termina nodo:57   */
      /* Termina nodo:15   */


   }

}
