
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_comisiones_clientes_insertar2  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_comisiones_clientes_insertar2" );
      ((Element)v.get(0)).setAttribute("cod","0515" );
      ((Element)v.get(0)).setAttribute("titulo","" );
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
      v.add(doc.createTextNode("\r \r\rfunction mostrarLista() {\r    document.all[\"Cplistado1\"].style.visibility='';\r    document.all[\"CpLin1listado1\"].style.visibility='';\r    document.all[\"CpLin2listado1\"].style.visibility='';\r    document.all[\"CpLin3listado1\"].style.visibility='';\r    document.all[\"CpLin4listado1\"].style.visibility='';\r}\r\rfunction onLoadPag()   {  \r	configurarMenuSecundario(\"formulario\");        \r    DrdEnsanchaConMargenDcho('listado1',24);\r	mostrarLista();\r    eval (ON_RSZ); \r\r	var accion = get(\"formulario.accionModificar\");\r\r	if(accion==\"modificar\") {\r		reasignarDatosPantalla();\r	}\r\r	var valor = get(\"formulario.deshabilitoCombosZonificacion\");\r	if(valor==\"false\") {\r		document.getElementById(\"txtFechaAntiguedadDesde\").disabled = true;\r		document.getElementById(\"txtFechaAntiguedadHasta\").disabled = true;\r		document.getElementById(\"cbSubgerenciaVentas\").disabled = true;\r		document.getElementById(\"cbRegion\").disabled = true;\r		document.getElementById(\"cbZona\").disabled = true;\r		document.getElementById(\"cbSeccion\").disabled = true;\r		document.getElementById(\"cbTerritorio\").disabled = true;\r		document.getElementById(\"btnAnadir\").disabled = true;\r		document.getElementById(\"btnEliminar\").disabled = true;\r	}\r\r	var valor2 = get(\"formulario.deshabilitoTodoMenosTopes\");\r	if(valor2==\"true\") {\r		document.getElementById(\"cbTipoClientes\").disabled = true;\r		document.getElementById(\"txtFechaAntiguedadDesde\").disabled = true;\r		document.getElementById(\"txtFechaAntiguedadHasta\").disabled = true;\r		document.getElementById(\"cbSubgerenciaVentas\").disabled = true;\r		document.getElementById(\"cbRegion\").disabled = true;\r		document.getElementById(\"cbZona\").disabled = true;\r		document.getElementById(\"cbSeccion\").disabled = true;\r		document.getElementById(\"cbTerritorio\").disabled = true;\r		document.getElementById(\"btnAnadir\").disabled = true;\r		document.getElementById(\"btnEliminar\").disabled = true;\r	}\r\r	focoComboTipoCliente();\r\r	var opcionMenu = get(\"formulario.opcionMenu\");\r	if(opcionMenu==\"consultar\") {\r		document.getElementById(\"cbTipoClientes\").disabled = true;\r		document.getElementById(\"txtTopeMax\").disabled = true;\r		document.getElementById(\"txtTopeMin\").disabled = true;\r		document.getElementById(\"txtFechaAntiguedadDesde\").disabled = true;\r		document.getElementById(\"txtFechaAntiguedadHasta\").disabled = true;\r		document.getElementById(\"cbSubgerenciaVentas\").disabled = true;\r		document.getElementById(\"cbRegion\").disabled = true;\r		document.getElementById(\"cbZona\").disabled = true;\r		document.getElementById(\"cbSeccion\").disabled = true;\r		document.getElementById(\"cbTerritorio\").disabled = true;\r		document.getElementById(\"btnAnadir\").disabled = true;\r		document.getElementById(\"btnEliminar\").disabled = true;\r		document.getElementById(\"btnAceptar\").disabled = true;\r		btnProxy(5, '0');\r	}\r}\r\rfunction reasignarDatosPantalla() {\r	var topeMaximo = get(\"formulario.topeMaximo\");\r	var topeMinimo = get(\"formulario.topeMinimo\");\r	var fechaDesde = get(\"formulario.fechaDesde\");\r	var fechaHasta = get(\"formulario.fechaHasta\");	\r\r	set(\"formulario.txtTopeMax\", topeMaximo);\r	set(\"formulario.txtTopeMin\", topeMinimo);\r	set(\"formulario.txtFechaAntiguedadDesde\", fechaDesde);\r	set(\"formulario.txtFechaAntiguedadHasta\", fechaHasta);\r\r	seleccionarComboTipoCliente();		\r	seleccionarComboSubgerencia();\r}\r\rfunction seleccionarComboTipoCliente() {\r	var oidTipoCliente = get(\"formulario.oidTipoCliente\");\r	var tipoClienteSeleccionado = new Array();\r	tipoClienteSeleccionado = oidTipoCliente.split(\",\");	  \r	set(\"formulario.cbTipoClientes\", tipoClienteSeleccionado);\r}\r\rfunction seleccionarComboSubgerencia() {\r	var oidSubgerencia = get(\"formulario.oidSubgerencia\");\r	var subgerenciaSeleccionada = new Array();\r	subgerenciaSeleccionada = oidSubgerencia.split(\",\");	  \r	set(\"formulario.cbSubgerenciaVentas\", subgerenciaSeleccionada);\r\r	recargaComboRegion();\r}\r\rfunction recargaComboRegion() {\r	var vSGV = get(\"formulario.cbSubgerenciaVentas\");\r\r    if( vSGV != '' && vSGV != null ){\r		var arr = new Array();   \r        arr[arr.length] = new Array(\"oidSGV\", vSGV);\r        recargaCombo(\"formulario.cbRegion\",\"ZONRecargaRegiones\",\r		\"es.indra.sicc.dtos.zon.DTOUnidadAdministrativa\", arr,\"marcaComboRegion(datos);\");\r	}\r}\r\rfunction marcaComboRegion(datos) {\r		var datosNuevo = new Array();\r	datosNuevo[0] = [\"\",\"\"];\r\r	for (var i = 0; i < datos.length; i++ )\r		datosNuevo[i+1]  = datos[i];\r\r	set_combo(\"formulario.cbRegion\", datosNuevo);\r\r	var oidRegion = get(\"formulario.oidRegion\");\r	var regionSeleccionada = new Array();\r	regionSeleccionada = oidRegion.split(\",\");	  \r	set(\"formulario.cbRegion\", regionSeleccionada);\r\r	recargaComboZona();\r}\r\rfunction recargaComboZona() {\r	var vRegion = get(\"formulario.cbRegion\");\r\r    if( vRegion != '' && vRegion != null ) { \r	    var arr = new Array();   \r        arr[arr.length] = new Array(\"oidRegion\", vRegion);\r        recargaCombo(\"formulario.cbZona\",\"ZONRecargaZonas\",\r		\"es.indra.sicc.dtos.zon.DTOUnidadAdministrativa\", arr,\"marcaComboZona(datos);\"); \r	}\r}\r\rfunction marcaComboZona(datos) {\r		var datosNuevo = new Array();\r	datosNuevo[0] = [\"\",\"\"];\r\r	for (var i = 0; i < datos.length; i++ )\r		datosNuevo[i+1]  = datos[i];\r\r	set_combo(\"formulario.cbZona\", datosNuevo);\r\r	var oidZona = get(\"formulario.oidZona\");\r	var zonaSeleccionada = new Array();\r	zonaSeleccionada = oidZona.split(\",\");	  \r	set(\"formulario.cbZona\", zonaSeleccionada);\r\r	recargaComboSeccion();\r}\r\rfunction recargaComboSeccion() {\r	var vZona = get(\"formulario.cbZona\");\r    \r	if( vZona != '' && vZona != null ) {\r	    var arr = new Array();   \r        arr[arr.length] = new Array(\"oidZona\", vZona);\r        recargaCombo(\"formulario.cbSeccion\",\"ZONRecargaSecciones\",\r        \"es.indra.sicc.dtos.zon.DTOUnidadAdministrativa\", arr,\"marcaComboSeccion(datos);\");\r	}\r}\r\rfunction marcaComboSeccion(datos) {\r		var datosNuevo = new Array();\r	datosNuevo[0] = [\"\",\"\"];\r\r	for (var i = 0; i < datos.length; i++ )\r		datosNuevo[i+1]  = datos[i];\r\r	set_combo(\"formulario.cbSeccion\", datosNuevo);\r\r	var oidSeccion = get(\"formulario.oidSeccion\");\r	var seccionSeleccionada = new Array();\r	seccionSeleccionada = oidSeccion.split(\",\");	  \r	set(\"formulario.cbSeccion\", seccionSeleccionada);\r\r	recargaComboTerritorio();\r}\r\rfunction recargaComboTerritorio() {\r	var vSeccion = get(\"formulario.cbSeccion\");\r\r    if( vSeccion != '' && vSeccion != null ) {\r	    var arr = new Array();   \r        arr[arr.length] = new Array(\"oidSeccion\", vSeccion);\r        recargaCombo(\"formulario.cbTerritorio\",\"ZONRecargaTerritorios\",\r        \"es.indra.sicc.dtos.zon.DTOUnidadAdministrativa\", arr,\"marcaComboTerritorio(datos);\");\r    }\r}\r\rfunction marcaComboTerritorio(datos) {\r		var datosNuevo = new Array();\r	datosNuevo[0] = [\"\",\"\"];\r\r	for (var i = 0; i < datos.length; i++ )\r		datosNuevo[i+1]  = datos[i];\r\r	set_combo(\"formulario.cbTerritorio\", datosNuevo);\r\r	var oidTerritorio = get(\"formulario.oidTerritorio\");\r	var territorioSeleccionado = new Array();\r	territorioSeleccionado = oidTerritorio.split(\",\");	  \r	set(\"formulario.cbTerritorio\", territorioSeleccionado);\r}\r\rfunction subgerenciaOnChange()  {\r	var vSGV = get(\"formulario.cbSubgerenciaVentas\");\r\r    if( vSGV != '' && vSGV != null ){\r	    var arr = new Array();   \r        arr[arr.length] = new Array(\"oidSGV\", vSGV);\r        recargaCombo(\"formulario.cbRegion\",\"ZONRecargaRegiones\",\r        \"es.indra.sicc.dtos.zon.DTOUnidadAdministrativa\", arr,\"\"); \r\r				var datosNuevo2 = new Array();\r        datosNuevo2[0] = [\"\",\"\"];    \r        set_combo(\"formulario.cbZona\", datosNuevo2);            \r\r				var datosNuevo3 = new Array();\r        datosNuevo3[0] = [\"\",\"\"];    \r        set_combo(\"formulario.cbSeccion\", datosNuevo3);            \r\r				var datosNuevo4 = new Array();\r        datosNuevo4[0] = [\"\",\"\"];    \r        set_combo(\"formulario.cbTerritorio\", datosNuevo4);            \r    }\r    else {\r	    		var datosNuevo = new Array();\r        datosNuevo[0] = [\"\",\"\"];    \r        set_combo(\"formulario.cbRegion\", datosNuevo);            \r\r				var datosNuevo2 = new Array();\r        datosNuevo2[0] = [\"\",\"\"];    \r        set_combo(\"formulario.cbZona\", datosNuevo2);            \r\r				var datosNuevo3 = new Array();\r        datosNuevo3[0] = [\"\",\"\"];    \r        set_combo(\"formulario.cbSeccion\", datosNuevo3);            \r\r				var datosNuevo4 = new Array();\r        datosNuevo4[0] = [\"\",\"\"];    \r        set_combo(\"formulario.cbTerritorio\", datosNuevo4);            \r    }\r}\r\rfunction regionOnChange()  {       \r	var vRegion = get(\"formulario.cbRegion\");\r\r    if( vRegion != '' && vRegion != null ) { \r	    var arr = new Array();   \r        arr[arr.length] = new Array(\"oidRegion\", vRegion);\r        recargaCombo(\"formulario.cbZona\",\"ZONRecargaZonas\",\r		\"es.indra.sicc.dtos.zon.DTOUnidadAdministrativa\", arr,\"\"); \r\r				var datosNuevo3 = new Array();\r        datosNuevo3[0] = [\"\",\"\"];    \r        set_combo(\"formulario.cbSeccion\", datosNuevo3);            \r\r				var datosNuevo4 = new Array();\r        datosNuevo4[0] = [\"\",\"\"];    \r        set_combo(\"formulario.cbTerritorio\", datosNuevo4);            \r    }\r    else {\r			    var datosNuevo = new Array();\r        datosNuevo[0] = [\"\",\"\"];    \r        set_combo(\"formulario.cbZona\", datosNuevo);     \r		\r				var datosNuevo3 = new Array();\r        datosNuevo3[0] = [\"\",\"\"];    \r        set_combo(\"formulario.cbSeccion\", datosNuevo3);            \r\r				var datosNuevo4 = new Array();\r        datosNuevo4[0] = [\"\",\"\"];    \r        set_combo(\"formulario.cbTerritorio\", datosNuevo4);            \r    }\r}\r\rfunction zonaOnChange()  {\r	var vZona = get(\"formulario.cbZona\");\r    \r	if( vZona != '' && vZona != null ) {\r	    var arr = new Array();   \r        arr[arr.length] = new Array(\"oidZona\", vZona);\r        recargaCombo(\"formulario.cbSeccion\",\"ZONRecargaSecciones\",\r        \"es.indra.sicc.dtos.zon.DTOUnidadAdministrativa\", arr,\"\");\r\r				var datosNuevo4 = new Array();\r        datosNuevo4[0] = [\"\",\"\"];    \r        set_combo(\"formulario.cbTerritorio\", datosNuevo4);            \r    }\r    else {\r				var datosNuevo = new Array();\r        datosNuevo[0] = [\"\",\"\"];    \r        set_combo(\"formulario.cbSeccion\", datosNuevo);         \r		\r				var datosNuevo4 = new Array();\r        datosNuevo4[0] = [\"\",\"\"];    \r        set_combo(\"formulario.cbTerritorio\", datosNuevo4);            \r    }\r}\r\rfunction seccionOnChange() {        \r	var vSeccion = get(\"formulario.cbSeccion\");\r\r    if( vSeccion != '' && vSeccion != null ) {\r	    var arr = new Array();   \r        arr[arr.length] = new Array(\"oidSeccion\", vSeccion);\r        recargaCombo(\"formulario.cbTerritorio\",\"ZONRecargaTerritorios\",\r        \"es.indra.sicc.dtos.zon.DTOUnidadAdministrativa\", arr,\"\");\r    }\r    else {\r			    var datosNuevo = new Array();\r        datosNuevo[0] = [\"\",\"\"];    \r        set_combo(\"formulario.cbTerritorio\", datosNuevo);            \r    }\r}\r\rfunction focalizaTopeMaximo() {\r	focaliza(\"formulario.txtTopeMax\");\r}\r\rfunction focalizaFechaDesde() {\r	focaliza(\"formulario.txtFechaAntiguedadDesde\");\r}\r\rfunction anadirOnClick() {\r	var subgerencia = get(\"formulario.cbSubgerenciaVentas\");\r\r	if(subgerencia==\"\") {\r		cdos_mostrarAlert(GestionarMensaje('268',null,null,null));\r		focaliza(\"formulario.cbSubgerenciaVentas\");\r		return false;\r	}\r	else {\r		var oidSubgerencia = get(\"formulario.cbSubgerenciaVentas\");\r		var oidRegion = get(\"formulario.cbRegion\");\r		var oidZona = get(\"formulario.cbZona\");\r		var oidSeccion = get(\"formulario.cbSeccion\");\r		var oidTerritorio = get(\"formulario.cbTerritorio\");\r\r		var desubgerencia = get(\"formulario.cbSubgerenciaVentas\", \"T\");\r		var desRegion = get(\"formulario.cbRegion\", \"T\");\r		var desZona = get(\"formulario.cbZona\", \"T\");\r		var desSeccion = get(\"formulario.cbSeccion\", \"T\");\r		var desTerritorio = get(\"formulario.cbTerritorio\", \"T\");\r\r		var array = new Array();\r		array[0] = new String(oidSubgerencia);\r		array[1] = new String(desubgerencia);\r		array[2] = new String(desRegion);\r		array[3] = new String(desZona);\r		array[4] = new String(desSeccion);\r		array[5] = new String(desTerritorio);\r		array[6] = new String(oidRegion);\r		array[7] = new String(oidZona);\r		array[8] = new String(oidSeccion);\r		array[9] = new String(oidTerritorio);\r\r		listado1.actualizaDat();\r		var datos = listado1.datos;\r		datos[datos.length] = array; \r		listado1.setDatos(datos);\r		listado1.repintaDat();\r	}\r}\r\rfunction eliminarOnClick() {\r	if (listado1.numSelecc()== 0) {\r		GestionarMensaje('1021',null,null,null);\r		return false;\r    }\r\r	listado1.eliminarSelecc();\r	focoBotonEliminar();\r}\r\rfunction aceptarOnClick() {\r	if(!sicc_validaciones_generales()){\r		return false;\r	}\r\r	var topeMax = get(\"formulario.txtTopeMax\");\r	var topeMin = get(\"formulario.txtTopeMin\");\r\r	if((topeMax!=\"\") && (topeMin!=\"\")) {\r		if(parseFloat(topeMin)>parseFloat(topeMax)) {\r			GestionarMensaje('1493',null,null,null)\r			focalizaTopeMaximo();\r			return false;\r		}\r	}\r\r	var fechaD = get(\"formulario.txtFechaAntiguedadDesde\");\r	var fechaH = get(\"formulario.txtFechaAntiguedadHasta\");\r\r	if((fechaD!=\"\") && (fechaH!=\"\")) {\r		var valorDevuelto = EsFechaValida(fechaD, fechaH, \"formulario\") \r\r		if(valorDevuelto==3) {\r			GestionarMensaje('1494',null,null,null)\r			focalizaFechaDesde();\r			return false;\r		}\r	}	\r\r	var arrayDatosAlcance = listado1.datos;\r\r	var oidTipoCliente = \" \";\r	var desTipoCliente = \" \";\r	var topeMaximo = \" \";\r	var topeMinimo = \" \";\r	var fechaDesde = \" \";\r	var fechaHasta = \" \";\r\r	if(get(\"formulario.cbTipoClientes\")!=\"\") oidTipoCliente = get(\"formulario.cbTipoClientes\");\r	if(get(\"formulario.cbTipoClientes\", \"T\")!=\"\") desTipoCliente = get(\"formulario.cbTipoClientes\", \"T\");\r	if(get(\"formulario.txtTopeMax\")!=\"\") topeMaximo = get(\"formulario.txtTopeMax\");\r	if(get(\"formulario.txtTopeMin\")!=\"\") topeMinimo = get(\"formulario.txtTopeMin\");\r	if(get(\"formulario.txtFechaAntiguedadDesde\")!=\"\") fechaDesde = get(\"formulario.txtFechaAntiguedadDesde\");\r	if(get(\"formulario.txtFechaAntiguedadHasta\")!=\"\") fechaHasta = get(\"formulario.txtFechaAntiguedadHasta\");\r\r	var arrayCompleto = new Array();\r\r	if(arrayDatosAlcance!=\"\") {\r		for(var i=0; i<arrayDatosAlcance.length; i++) {\r			oidSubgerencia = arrayDatosAlcance[i][0].toString();\r			oidRegion = arrayDatosAlcance[i][6].toString();\r			oidZona = arrayDatosAlcance[i][7].toString();\r			oidSeccion = arrayDatosAlcance[i][8].toString();\r			oidTerritorio = arrayDatosAlcance[i][9].toString();\r			desubgerencia = arrayDatosAlcance[i][1].toString();\r			desRegion = arrayDatosAlcance[i][2].toString();\r			desZona = arrayDatosAlcance[i][3].toString();\r			desSeccion = arrayDatosAlcance[i][4].toString();\r			desTerritorio = arrayDatosAlcance[i][5].toString();\r\r			var arrayTemp = new Array();\r			arrayTemp[0] = new String(oidSubgerencia);\r			arrayTemp[1] = new String(desubgerencia);\r			arrayTemp[2] = new String(desRegion);\r			arrayTemp[3] = new String(desZona);\r			arrayTemp[4] = new String(desSeccion);\r			arrayTemp[5] = new String(desTerritorio);\r			arrayTemp[6] = new String(oidRegion);\r			arrayTemp[7] = new String(oidZona);\r			arrayTemp[8] = new String(oidSeccion);\r			arrayTemp[9] = new String(oidTerritorio);\r			arrayTemp[10] = new String(oidTipoCliente);\r			arrayTemp[11] = new String(desTipoCliente);\r			arrayTemp[12] = new String(topeMaximo);\r			arrayTemp[13] = new String(topeMinimo);\r			arrayTemp[14] = new String(fechaDesde);\r			arrayTemp[15] = new String(fechaHasta);\r\r			arrayCompleto[i] = arrayTemp;\r		}	\r	}\r	else{\r		var arrayTemp = new Array();\r		var aux = \" \";\r		arrayTemp[0] = new String(aux);\r		arrayTemp[1] = new String(aux);\r		arrayTemp[2] = new String(aux);\r		arrayTemp[3] = new String(aux);\r		arrayTemp[4] = new String(aux);\r		arrayTemp[5] = new String(aux);\r		arrayTemp[6] = new String(aux);\r		arrayTemp[7] = new String(aux);\r		arrayTemp[8] = new String(aux);\r		arrayTemp[9] = new String(aux);\r		arrayTemp[10] = new String(oidTipoCliente);\r		arrayTemp[11] = new String(desTipoCliente);\r		arrayTemp[12] = new String(topeMaximo);\r		arrayTemp[13] = new String(topeMinimo);\r		arrayTemp[14] = new String(fechaDesde);\r		arrayTemp[15] = new String(fechaHasta);\r\r		var datos;\r		for(var i=0; i<arrayTemp.length; i++) {\r			if(i==0) {\r				datos = arrayTemp[i];\r			}\r			else {\r				datos = datos + \",\" + arrayTemp[i];\r			}\r			\r		}\r\r		var arTemp = datos.split(\",\");\r		arrayCompleto[0] = arTemp;\r	}\r\r	returnValue = arrayCompleto;\r	window.close();\r}\r\rfunction fVolver() {\r	window.close();\r}\r\rfunction fLimpiar() {\r	var accion = get(\"formulario.accionModificar\");\r\r	if(accion==\"modificar\") {\r		reasignarDatosPantalla();\r	}\r	else {\r	    		var datosNuevo = new Array();\r        datosNuevo[0] = [\"\",\"\"];    \r        set_combo(\"formulario.cbRegion\", datosNuevo);            \r\r				var datosNuevo2 = new Array();\r        datosNuevo2[0] = [\"\",\"\"];    \r        set_combo(\"formulario.cbZona\", datosNuevo2);            \r\r				var datosNuevo3 = new Array();\r        datosNuevo3[0] = [\"\",\"\"];    \r        set_combo(\"formulario.cbSeccion\", datosNuevo3);            \r\r				var datosNuevo4 = new Array();\r        datosNuevo4[0] = [\"\",\"\"];    \r        set_combo(\"formulario.cbTerritorio\", datosNuevo4);            \r	}\r\r	var arrayVacio = new Array();\r	listado1.setDatos(arrayVacio);\r\r	focoComboTipoCliente();\r}\r\rfunction focoBotonEliminar() {\r	focalizaBotonHTML('botonContenido','btnEliminar');	\r}\r\rfunction focoBotonAnadir() {\r	focalizaBotonHTML('botonContenido','btnAnadir');	\r}\r\rfunction focoComboTipoCliente() {\r	if(document.getElementById(\"cbTipoClientes\").disabled != true) {\r		focaliza(\"formulario.cbTipoClientes\");\r	}\r	else {\r		focaliza(\"formulario.txtTopeMax\");\r	}\r	\r}\r\rfunction onShTabTopeMaximo() {\r	if(document.getElementById(\"cbTipoClientes\").disabled != true) {\r		focaliza(\"formulario.cbTipoClientes\");\r	}\r	else {\r		focoBotonAceptar();\r	}\r}\r\rfunction onShTabBotonAceptar() {\r	if(document.getElementById(\"btnEliminar\").disabled != true) {\r		focoBotonEliminar();\r	}\r	else {\r		focaliza(\"formulario.txtTopeMin\");\r	}\r}\r\rfunction focoBotonAceptar() {\r	focalizaBotonHTML('botonContenido','btnAceptar');\r}\r\r   \r \r"));
      ((Element)v.get(5)).appendChild((Text)v.get(6));

      /* Termina nodo Texto:6   */
      /* Termina nodo:5   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","cbTipoClientes" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","393" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","txtTopeMax" );
      ((Element)v.get(9)).setAttribute("required","false" );
      ((Element)v.get(9)).setAttribute("cod","1724" );
      ((Element)v.get(9)).setAttribute("format","n" );
      ((Element)v.get(9)).setAttribute("min","0" );
      ((Element)v.get(9)).setAttribute("max","9999999999.99" );
      ((Element)v.get(7)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","txtTopeMin" );
      ((Element)v.get(10)).setAttribute("required","false" );
      ((Element)v.get(10)).setAttribute("cod","1725" );
      ((Element)v.get(10)).setAttribute("format","n" );
      ((Element)v.get(10)).setAttribute("min","0" );
      ((Element)v.get(10)).setAttribute("max","9999999999.99" );
      ((Element)v.get(7)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","txtFechaAntiguedadDesde" );
      ((Element)v.get(11)).setAttribute("required","false" );
      ((Element)v.get(11)).setAttribute("cod","1726" );
      ((Element)v.get(11)).setAttribute("format","F" );
      ((Element)v.get(7)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","txtFechaAntiguedadHasta" );
      ((Element)v.get(12)).setAttribute("required","false" );
      ((Element)v.get(12)).setAttribute("cod","1727" );
      ((Element)v.get(12)).setAttribute("format","F" );
      ((Element)v.get(7)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */
      /* Termina nodo:7   */

      /* Empieza nodo:13 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(13)).setAttribute("nombre","formulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(13));

      /* Empieza nodo:14 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","accion" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","varPais" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","varIdioma" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","oidTipoCliente" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","topeMaximo" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","topeMinimo" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","fechaDesde" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","fechaHasta" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","oidSubgerencia" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","oidRegion" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","oidZona" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","oidSeccion" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","oidTerritorio" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","accionModificar" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","deshabilitoCombosZonificacion" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","deshabilitoTodoMenosTopes" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 13   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(34)).setAttribute("nombre","capa1" );
      ((Element)v.get(13)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("table"));
      ((Element)v.get(35)).setAttribute("width","100%" );
      ((Element)v.get(35)).setAttribute("border","0" );
      ((Element)v.get(35)).setAttribute("cellspacing","0" );
      ((Element)v.get(35)).setAttribute("cellpadding","0" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("td"));
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(38)).setAttribute("src","b.gif" );
      ((Element)v.get(38)).setAttribute("width","12" );
      ((Element)v.get(38)).setAttribute("height","12" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */
      /* Termina nodo:37   */

      /* Empieza nodo:39 / Elemento padre: 36   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).setAttribute("width","750" );
      ((Element)v.get(36)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(40)).setAttribute("src","b.gif" );
      ((Element)v.get(40)).setAttribute("width","1" );
      ((Element)v.get(40)).setAttribute("height","1" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */
      /* Termina nodo:39   */

      /* Empieza nodo:41 / Elemento padre: 36   */
      v.add(doc.createElement("td"));
      ((Element)v.get(36)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(42)).setAttribute("src","b.gif" );
      ((Element)v.get(42)).setAttribute("width","12" );
      ((Element)v.get(42)).setAttribute("height","12" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */
      /* Termina nodo:41   */
      /* Termina nodo:36   */

      /* Empieza nodo:43 / Elemento padre: 35   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(35)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(44)).setAttribute("width","12" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(45)).setAttribute("src","b.gif" );
      ((Element)v.get(45)).setAttribute("width","12" );
      ((Element)v.get(45)).setAttribute("height","12" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:46 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(46)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(48)).setAttribute("class","legend" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(49)).setAttribute("nombre","lblDatosClientes" );
      ((Element)v.get(49)).setAttribute("alto","13" );
      ((Element)v.get(49)).setAttribute("filas","1" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(49)).setAttribute("id","legend" );
      ((Element)v.get(49)).setAttribute("cod","00138" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 47   */
      v.add(doc.createElement("table"));
      ((Element)v.get(50)).setAttribute("width","100%" );
      ((Element)v.get(50)).setAttribute("border","0" );
      ((Element)v.get(50)).setAttribute("align","center" );
      ((Element)v.get(50)).setAttribute("cellspacing","0" );
      ((Element)v.get(50)).setAttribute("cellpadding","0" );
      ((Element)v.get(47)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(51)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("table"));
      ((Element)v.get(53)).setAttribute("width","587" );
      ((Element)v.get(53)).setAttribute("border","0" );
      ((Element)v.get(53)).setAttribute("align","left" );
      ((Element)v.get(53)).setAttribute("cellspacing","0" );
      ((Element)v.get(53)).setAttribute("cellpadding","0" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(53)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).setAttribute("colspan","4" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(56)).setAttribute("src","b.gif" );
      ((Element)v.get(56)).setAttribute("width","8" );
      ((Element)v.get(56)).setAttribute("height","8" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */
      /* Termina nodo:54   */

      /* Empieza nodo:57 / Elemento padre: 53   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(53)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(59)).setAttribute("src","b.gif" );
      ((Element)v.get(59)).setAttribute("width","8" );
      ((Element)v.get(59)).setAttribute("height","8" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:60 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(61)).setAttribute("nombre","lblTipoClientes" );
      ((Element)v.get(61)).setAttribute("alto","13" );
      ((Element)v.get(61)).setAttribute("filas","1" );
      ((Element)v.get(61)).setAttribute("valor","" );
      ((Element)v.get(61)).setAttribute("id","datosTitle" );
      ((Element)v.get(61)).setAttribute("cod","393" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:62 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(63)).setAttribute("src","b.gif" );
      ((Element)v.get(63)).setAttribute("width","25" );
      ((Element)v.get(63)).setAttribute("height","8" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:64 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(65)).setAttribute("nombre","lblTopeMax" );
      ((Element)v.get(65)).setAttribute("alto","13" );
      ((Element)v.get(65)).setAttribute("filas","1" );
      ((Element)v.get(65)).setAttribute("valor","" );
      ((Element)v.get(65)).setAttribute("id","datosTitle" );
      ((Element)v.get(65)).setAttribute("cod","1724" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:66 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(67)).setAttribute("src","b.gif" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(67)).setAttribute("width","25" );
      ((Element)v.get(67)).setAttribute("height","8" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:68 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(69)).setAttribute("nombre","lblTopeMin" );
      ((Element)v.get(69)).setAttribute("alto","13" );
      ((Element)v.get(69)).setAttribute("filas","1" );
      ((Element)v.get(69)).setAttribute("valor","" );
      ((Element)v.get(69)).setAttribute("id","datosTitle" );
      ((Element)v.get(69)).setAttribute("cod","1725" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */

      /* Empieza nodo:70 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).setAttribute("width","100%" );
      ((Element)v.get(57)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(71)).setAttribute("src","b.gif" );
      ((Element)v.get(71)).setAttribute("width","8" );
      ((Element)v.get(71)).setAttribute("height","8" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */
      /* Termina nodo:57   */

      /* Empieza nodo:72 / Elemento padre: 53   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(53)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(74)).setAttribute("src","b.gif" );
      ((Element)v.get(74)).setAttribute("width","8" );
      ((Element)v.get(74)).setAttribute("height","8" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:75 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(72)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(76)).setAttribute("nombre","cbTipoClientes" );
      ((Element)v.get(76)).setAttribute("id","datosCampos" );
      ((Element)v.get(76)).setAttribute("size","1" );
      ((Element)v.get(76)).setAttribute("multiple","N" );
      ((Element)v.get(76)).setAttribute("req","S" );
      ((Element)v.get(76)).setAttribute("valorinicial","" );
      ((Element)v.get(76)).setAttribute("textoinicial","" );
      ((Element)v.get(76)).setAttribute("onshtab","focoBotonAceptar();" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:78 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).setAttribute("width","25" );
      ((Element)v.get(79)).setAttribute("height","8" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:80 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(72)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(81)).setAttribute("nombre","txtTopeMax" );
      ((Element)v.get(81)).setAttribute("id","datosCampos" );
      ((Element)v.get(81)).setAttribute("max","13" );
      ((Element)v.get(81)).setAttribute("tipo","" );
      ((Element)v.get(81)).setAttribute("onchange","" );
      ((Element)v.get(81)).setAttribute("req","N" );
      ((Element)v.get(81)).setAttribute("size","15" );
      ((Element)v.get(81)).setAttribute("valor","" );
      ((Element)v.get(81)).setAttribute("validacion","" );
      ((Element)v.get(81)).setAttribute("onshtab","onShTabTopeMaximo();" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:82 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(83)).setAttribute("src","b.gif" );
      ((Element)v.get(83)).setAttribute("width","25" );
      ((Element)v.get(83)).setAttribute("height","8" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */

      /* Empieza nodo:84 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(72)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(85)).setAttribute("nombre","txtTopeMin" );
      ((Element)v.get(85)).setAttribute("id","datosCampos" );
      ((Element)v.get(85)).setAttribute("max","13" );
      ((Element)v.get(85)).setAttribute("tipo","" );
      ((Element)v.get(85)).setAttribute("onchange","" );
      ((Element)v.get(85)).setAttribute("req","N" );
      ((Element)v.get(85)).setAttribute("size","15" );
      ((Element)v.get(85)).setAttribute("valor","" );
      ((Element)v.get(85)).setAttribute("validacion","" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */

      /* Empieza nodo:86 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(86)).setAttribute("width","100%" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(72)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(87)).setAttribute("src","b.gif" );
      ((Element)v.get(87)).setAttribute("width","8" );
      ((Element)v.get(87)).setAttribute("height","8" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */
      /* Termina nodo:72   */

      /* Empieza nodo:88 / Elemento padre: 53   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(53)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).setAttribute("colspan","4" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(90)).setAttribute("src","b.gif" );
      ((Element)v.get(90)).setAttribute("width","8" );
      ((Element)v.get(90)).setAttribute("height","8" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */
      /* Termina nodo:88   */
      /* Termina nodo:53   */
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:91 / Elemento padre: 50   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(50)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("table"));
      ((Element)v.get(93)).setAttribute("width","587" );
      ((Element)v.get(93)).setAttribute("border","0" );
      ((Element)v.get(93)).setAttribute("align","left" );
      ((Element)v.get(93)).setAttribute("cellspacing","0" );
      ((Element)v.get(93)).setAttribute("cellpadding","0" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(96)).setAttribute("src","b.gif" );
      ((Element)v.get(96)).setAttribute("width","8" );
      ((Element)v.get(96)).setAttribute("height","8" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */

      /* Empieza nodo:97 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(98)).setAttribute("nombre","lblFechaAntiguedadDesde" );
      ((Element)v.get(98)).setAttribute("alto","13" );
      ((Element)v.get(98)).setAttribute("filas","1" );
      ((Element)v.get(98)).setAttribute("valor","" );
      ((Element)v.get(98)).setAttribute("id","datosTitle" );
      ((Element)v.get(98)).setAttribute("cod","1726" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */

      /* Empieza nodo:99 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(100)).setAttribute("src","b.gif" );
      ((Element)v.get(100)).setAttribute("width","25" );
      ((Element)v.get(100)).setAttribute("height","8" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:101 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(102)).setAttribute("nombre","lblFechaAntiguedadHasta" );
      ((Element)v.get(102)).setAttribute("alto","13" );
      ((Element)v.get(102)).setAttribute("filas","1" );
      ((Element)v.get(102)).setAttribute("valor","" );
      ((Element)v.get(102)).setAttribute("id","datosTitle" );
      ((Element)v.get(102)).setAttribute("cod","1727" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:103 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(103)).setAttribute("width","100%" );
      ((Element)v.get(94)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(104)).setAttribute("src","b.gif" );
      ((Element)v.get(104)).setAttribute("width","8" );
      ((Element)v.get(104)).setAttribute("height","8" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */
      /* Termina nodo:94   */

      /* Empieza nodo:105 / Elemento padre: 93   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(93)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(107)).setAttribute("src","b.gif" );
      ((Element)v.get(107)).setAttribute("width","8" );
      ((Element)v.get(107)).setAttribute("height","8" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */

      /* Empieza nodo:108 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(105)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(109)).setAttribute("nombre","txtFechaAntiguedadDesde" );
      ((Element)v.get(109)).setAttribute("id","datosCampos" );
      ((Element)v.get(109)).setAttribute("max","10" );
      ((Element)v.get(109)).setAttribute("tipo","" );
      ((Element)v.get(109)).setAttribute("onchange","" );
      ((Element)v.get(109)).setAttribute("req","N" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(109)).setAttribute("size","12" );
      ((Element)v.get(109)).setAttribute("valor","" );
      ((Element)v.get(109)).setAttribute("validacion","" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */

      /* Empieza nodo:110 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(111)).setAttribute("src","b.gif" );
      ((Element)v.get(111)).setAttribute("width","25" );
      ((Element)v.get(111)).setAttribute("height","8" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:112 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(105)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(113)).setAttribute("nombre","txtFechaAntiguedadHasta" );
      ((Element)v.get(113)).setAttribute("id","datosCampos" );
      ((Element)v.get(113)).setAttribute("max","10" );
      ((Element)v.get(113)).setAttribute("tipo","" );
      ((Element)v.get(113)).setAttribute("onchange","" );
      ((Element)v.get(113)).setAttribute("req","N" );
      ((Element)v.get(113)).setAttribute("size","12" );
      ((Element)v.get(113)).setAttribute("valor","" );
      ((Element)v.get(113)).setAttribute("validacion","" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:114 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).setAttribute("width","100%" );
      ((Element)v.get(105)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(115)).setAttribute("src","b.gif" );
      ((Element)v.get(115)).setAttribute("width","8" );
      ((Element)v.get(115)).setAttribute("height","8" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */
      /* Termina nodo:105   */

      /* Empieza nodo:116 / Elemento padre: 93   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(93)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(117)).setAttribute("colspan","4" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(118)).setAttribute("src","b.gif" );
      ((Element)v.get(118)).setAttribute("width","8" );
      ((Element)v.get(118)).setAttribute("height","8" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */
      /* Termina nodo:116   */
      /* Termina nodo:93   */
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:119 / Elemento padre: 50   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(50)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("table"));
      ((Element)v.get(121)).setAttribute("width","100%" );
      ((Element)v.get(121)).setAttribute("border","0" );
      ((Element)v.get(121)).setAttribute("align","center" );
      ((Element)v.get(121)).setAttribute("cellspacing","0" );
      ((Element)v.get(121)).setAttribute("cellpadding","0" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(121)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(124)).setAttribute("src","b.gif" );
      ((Element)v.get(124)).setAttribute("width","8" );
      ((Element)v.get(124)).setAttribute("height","8" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:125 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).setAttribute("width","100%" );
      ((Element)v.get(122)).appendChild((Element)v.get(125));

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
      ((Element)v.get(127)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(128)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(130)).setAttribute("class","legend" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(131)).setAttribute("nombre","lblAlcanceGeografico" );
      ((Element)v.get(131)).setAttribute("alto","13" );
      ((Element)v.get(131)).setAttribute("filas","1" );
      ((Element)v.get(131)).setAttribute("valor","" );
      ((Element)v.get(131)).setAttribute("id","legend" );
      ((Element)v.get(131)).setAttribute("cod","00368" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:132 / Elemento padre: 129   */
      v.add(doc.createElement("table"));
   }

   private void getXML540(Document doc) {
      ((Element)v.get(132)).setAttribute("width","100%" );
      ((Element)v.get(132)).setAttribute("border","0" );
      ((Element)v.get(132)).setAttribute("align","center" );
      ((Element)v.get(132)).setAttribute("cellspacing","0" );
      ((Element)v.get(132)).setAttribute("cellpadding","0" );
      ((Element)v.get(129)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(132)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("table"));
      ((Element)v.get(135)).setAttribute("width","575" );
      ((Element)v.get(135)).setAttribute("border","0" );
      ((Element)v.get(135)).setAttribute("align","left" );
      ((Element)v.get(135)).setAttribute("cellspacing","0" );
      ((Element)v.get(135)).setAttribute("cellpadding","0" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(135)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(137)).setAttribute("colspan","4" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(138)).setAttribute("src","b.gif" );
      ((Element)v.get(138)).setAttribute("width","8" );
      ((Element)v.get(138)).setAttribute("height","8" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */
      /* Termina nodo:136   */

      /* Empieza nodo:139 / Elemento padre: 135   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(135)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(141)).setAttribute("src","b.gif" );
      ((Element)v.get(141)).setAttribute("width","8" );
      ((Element)v.get(141)).setAttribute("height","8" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */

      /* Empieza nodo:142 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(143)).setAttribute("nombre","lblPais" );
      ((Element)v.get(143)).setAttribute("alto","13" );
      ((Element)v.get(143)).setAttribute("filas","1" );
      ((Element)v.get(143)).setAttribute("valor","" );
      ((Element)v.get(143)).setAttribute("id","datosTitle" );
      ((Element)v.get(143)).setAttribute("cod","5" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:142   */

      /* Empieza nodo:144 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(145)).setAttribute("src","b.gif" );
      ((Element)v.get(145)).setAttribute("width","25" );
      ((Element)v.get(145)).setAttribute("height","8" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:144   */

      /* Empieza nodo:146 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(147)).setAttribute("nombre","lblSubgerenciaVentas" );
      ((Element)v.get(147)).setAttribute("alto","13" );
      ((Element)v.get(147)).setAttribute("filas","1" );
      ((Element)v.get(147)).setAttribute("valor","" );
      ((Element)v.get(147)).setAttribute("id","datosTitle" );
      ((Element)v.get(147)).setAttribute("cod","124" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:146   */

      /* Empieza nodo:148 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(148)).setAttribute("width","100%" );
      ((Element)v.get(139)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(149)).setAttribute("src","b.gif" );
      ((Element)v.get(149)).setAttribute("width","8" );
      ((Element)v.get(149)).setAttribute("height","8" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */
      /* Termina nodo:139   */

      /* Empieza nodo:150 / Elemento padre: 135   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(135)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(152)).setAttribute("src","b.gif" );
      ((Element)v.get(152)).setAttribute("width","8" );
      ((Element)v.get(152)).setAttribute("height","8" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:151   */

      /* Empieza nodo:153 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(153)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(150)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(154)).setAttribute("nombre","lbldtPais" );
      ((Element)v.get(154)).setAttribute("alto","13" );
      ((Element)v.get(154)).setAttribute("filas","1" );
      ((Element)v.get(154)).setAttribute("valor","" );
      ((Element)v.get(154)).setAttribute("id","datosCampos" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */

      /* Empieza nodo:155 / Elemento padre: 150   */
   }

   private void getXML630(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(156)).setAttribute("src","b.gif" );
      ((Element)v.get(156)).setAttribute("width","25" );
      ((Element)v.get(156)).setAttribute("height","8" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */

      /* Empieza nodo:157 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(157)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(150)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(158)).setAttribute("nombre","cbSubgerenciaVentas" );
      ((Element)v.get(158)).setAttribute("id","datosCampos" );
      ((Element)v.get(158)).setAttribute("size","1" );
      ((Element)v.get(158)).setAttribute("multiple","N" );
      ((Element)v.get(158)).setAttribute("req","N" );
      ((Element)v.get(158)).setAttribute("valorinicial","" );
      ((Element)v.get(158)).setAttribute("textoinicial","" );
      ((Element)v.get(158)).setAttribute("onchange","subgerenciaOnChange();" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:160 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).setAttribute("width","100%" );
      ((Element)v.get(150)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(161)).setAttribute("src","b.gif" );
      ((Element)v.get(161)).setAttribute("width","8" );
      ((Element)v.get(161)).setAttribute("height","8" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:160   */
      /* Termina nodo:150   */

      /* Empieza nodo:162 / Elemento padre: 135   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(135)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).setAttribute("colspan","4" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(164)).setAttribute("src","b.gif" );
      ((Element)v.get(164)).setAttribute("width","8" );
      ((Element)v.get(164)).setAttribute("height","8" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */
      /* Termina nodo:162   */
      /* Termina nodo:135   */
      /* Termina nodo:134   */
      /* Termina nodo:133   */

      /* Empieza nodo:165 / Elemento padre: 132   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(132)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("td"));
      ((Element)v.get(165)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("table"));
      ((Element)v.get(167)).setAttribute("width","575" );
      ((Element)v.get(167)).setAttribute("border","0" );
      ((Element)v.get(167)).setAttribute("align","left" );
      ((Element)v.get(167)).setAttribute("cellspacing","0" );
      ((Element)v.get(167)).setAttribute("cellpadding","0" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(167)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("td"));
      ((Element)v.get(168)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(170)).setAttribute("src","b.gif" );
      ((Element)v.get(170)).setAttribute("width","8" );
      ((Element)v.get(170)).setAttribute("height","8" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */

      /* Empieza nodo:171 / Elemento padre: 168   */
      v.add(doc.createElement("td"));
      ((Element)v.get(168)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(172)).setAttribute("nombre","lblRegion" );
      ((Element)v.get(172)).setAttribute("alto","13" );
      ((Element)v.get(172)).setAttribute("filas","1" );
      ((Element)v.get(172)).setAttribute("valor","" );
      ((Element)v.get(172)).setAttribute("id","datosTitle" );
      ((Element)v.get(172)).setAttribute("cod","109" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:171   */

      /* Empieza nodo:173 / Elemento padre: 168   */
      v.add(doc.createElement("td"));
      ((Element)v.get(168)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(174)).setAttribute("src","b.gif" );
      ((Element)v.get(174)).setAttribute("width","25" );
      ((Element)v.get(174)).setAttribute("height","8" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */
      /* Termina nodo:173   */

      /* Empieza nodo:175 / Elemento padre: 168   */
      v.add(doc.createElement("td"));
      ((Element)v.get(168)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(176)).setAttribute("nombre","lblZona" );
      ((Element)v.get(176)).setAttribute("alto","13" );
      ((Element)v.get(176)).setAttribute("filas","1" );
      ((Element)v.get(176)).setAttribute("valor","" );
      ((Element)v.get(176)).setAttribute("id","datosTitle" );
      ((Element)v.get(176)).setAttribute("cod","143" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:175   */

      /* Empieza nodo:177 / Elemento padre: 168   */
      v.add(doc.createElement("td"));
      ((Element)v.get(177)).setAttribute("width","100%" );
      ((Element)v.get(168)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
   }

   private void getXML720(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(178)).setAttribute("src","b.gif" );
      ((Element)v.get(178)).setAttribute("width","8" );
      ((Element)v.get(178)).setAttribute("height","8" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:177   */
      /* Termina nodo:168   */

      /* Empieza nodo:179 / Elemento padre: 167   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(167)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(179)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(181)).setAttribute("src","b.gif" );
      ((Element)v.get(181)).setAttribute("width","8" );
      ((Element)v.get(181)).setAttribute("height","8" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:180   */

      /* Empieza nodo:182 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(182)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(179)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(183)).setAttribute("nombre","cbRegion" );
      ((Element)v.get(183)).setAttribute("id","datosCampos" );
      ((Element)v.get(183)).setAttribute("size","1" );
      ((Element)v.get(183)).setAttribute("multiple","N" );
      ((Element)v.get(183)).setAttribute("req","N" );
      ((Element)v.get(183)).setAttribute("valorinicial","" );
      ((Element)v.get(183)).setAttribute("textoinicial","" );
      ((Element)v.get(183)).setAttribute("onchange","regionOnChange();" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */
      /* Termina nodo:182   */

      /* Empieza nodo:185 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(179)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(186)).setAttribute("src","b.gif" );
      ((Element)v.get(186)).setAttribute("width","25" );
      ((Element)v.get(186)).setAttribute("height","8" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:187 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(187)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(179)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(188)).setAttribute("nombre","cbZona" );
      ((Element)v.get(188)).setAttribute("id","datosCampos" );
      ((Element)v.get(188)).setAttribute("size","1" );
      ((Element)v.get(188)).setAttribute("multiple","N" );
      ((Element)v.get(188)).setAttribute("req","N" );
      ((Element)v.get(188)).setAttribute("valorinicial","" );
      ((Element)v.get(188)).setAttribute("textoinicial","" );
      ((Element)v.get(188)).setAttribute("onchange","zonaOnChange();" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(188)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */
      /* Termina nodo:188   */
      /* Termina nodo:187   */

      /* Empieza nodo:190 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(190)).setAttribute("width","100%" );
      ((Element)v.get(179)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(191)).setAttribute("src","b.gif" );
      ((Element)v.get(191)).setAttribute("width","8" );
      ((Element)v.get(191)).setAttribute("height","8" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */
      /* Termina nodo:190   */
      /* Termina nodo:179   */

      /* Empieza nodo:192 / Elemento padre: 167   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(167)).appendChild((Element)v.get(192));

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
      /* Termina nodo:167   */
      /* Termina nodo:166   */
      /* Termina nodo:165   */

      /* Empieza nodo:195 / Elemento padre: 132   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(132)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("td"));
      ((Element)v.get(195)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("table"));
      ((Element)v.get(197)).setAttribute("width","575" );
      ((Element)v.get(197)).setAttribute("border","0" );
      ((Element)v.get(197)).setAttribute("align","left" );
      ((Element)v.get(197)).setAttribute("cellspacing","0" );
      ((Element)v.get(197)).setAttribute("cellpadding","0" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(197)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(198)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(200)).setAttribute("src","b.gif" );
      ((Element)v.get(200)).setAttribute("width","8" );
      ((Element)v.get(200)).setAttribute("height","8" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:199   */

      /* Empieza nodo:201 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
   }

   private void getXML810(Document doc) {
      ((Element)v.get(198)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(202)).setAttribute("nombre","lblSeccion" );
      ((Element)v.get(202)).setAttribute("alto","13" );
      ((Element)v.get(202)).setAttribute("filas","1" );
      ((Element)v.get(202)).setAttribute("valor","" );
      ((Element)v.get(202)).setAttribute("id","datosTitle" );
      ((Element)v.get(202)).setAttribute("cod","112" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:201   */

      /* Empieza nodo:203 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(198)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(204)).setAttribute("src","b.gif" );
      ((Element)v.get(204)).setAttribute("width","25" );
      ((Element)v.get(204)).setAttribute("height","8" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:203   */

      /* Empieza nodo:205 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(198)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(206)).setAttribute("nombre","lblTerritorio" );
      ((Element)v.get(206)).setAttribute("alto","13" );
      ((Element)v.get(206)).setAttribute("filas","1" );
      ((Element)v.get(206)).setAttribute("valor","" );
      ((Element)v.get(206)).setAttribute("id","datosTitle" );
      ((Element)v.get(206)).setAttribute("cod","126" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:205   */

      /* Empieza nodo:207 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(207)).setAttribute("width","100%" );
      ((Element)v.get(198)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(208)).setAttribute("src","b.gif" );
      ((Element)v.get(208)).setAttribute("width","8" );
      ((Element)v.get(208)).setAttribute("height","8" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */
      /* Termina nodo:207   */
      /* Termina nodo:198   */

      /* Empieza nodo:209 / Elemento padre: 197   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(197)).appendChild((Element)v.get(209));

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
      ((Element)v.get(213)).setAttribute("nombre","cbSeccion" );
      ((Element)v.get(213)).setAttribute("id","datosCampos" );
      ((Element)v.get(213)).setAttribute("size","1" );
      ((Element)v.get(213)).setAttribute("multiple","N" );
      ((Element)v.get(213)).setAttribute("req","N" );
      ((Element)v.get(213)).setAttribute("valorinicial","" );
      ((Element)v.get(213)).setAttribute("textoinicial","" );
      ((Element)v.get(213)).setAttribute("onchange","seccionOnChange();" );
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
      ((Element)v.get(218)).setAttribute("nombre","cbTerritorio" );
      ((Element)v.get(218)).setAttribute("id","datosCampos" );
      ((Element)v.get(218)).setAttribute("size","1" );
      ((Element)v.get(218)).setAttribute("multiple","N" );
      ((Element)v.get(218)).setAttribute("req","N" );
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
      ((Element)v.get(220)).setAttribute("width","100%" );
      ((Element)v.get(209)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(221)).setAttribute("src","b.gif" );
      ((Element)v.get(221)).setAttribute("width","8" );
      ((Element)v.get(221)).setAttribute("height","8" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */
      /* Termina nodo:220   */
      /* Termina nodo:209   */

      /* Empieza nodo:222 / Elemento padre: 197   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(197)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("td"));
   }

   private void getXML900(Document doc) {
      ((Element)v.get(223)).setAttribute("colspan","4" );
      ((Element)v.get(222)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(224)).setAttribute("src","b.gif" );
      ((Element)v.get(224)).setAttribute("width","8" );
      ((Element)v.get(224)).setAttribute("height","8" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */
      /* Termina nodo:223   */
      /* Termina nodo:222   */
      /* Termina nodo:197   */
      /* Termina nodo:196   */
      /* Termina nodo:195   */
      /* Termina nodo:132   */
      /* Termina nodo:129   */
      /* Termina nodo:128   */
      /* Termina nodo:127   */
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:225 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(226)).setAttribute("src","b.gif" );
      ((Element)v.get(226)).setAttribute("width","8" );
      ((Element)v.get(226)).setAttribute("height","8" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */
      /* Termina nodo:225   */
      /* Termina nodo:122   */

      /* Empieza nodo:227 / Elemento padre: 121   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(121)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("td"));
      ((Element)v.get(227)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(229)).setAttribute("src","b.gif" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */
      /* Termina nodo:228   */

      /* Empieza nodo:230 / Elemento padre: 227   */
      v.add(doc.createElement("td"));
      ((Element)v.get(227)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(230)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("table"));
      ((Element)v.get(232)).setAttribute("width","100%" );
      ((Element)v.get(232)).setAttribute("border","0" );
      ((Element)v.get(232)).setAttribute("align","center" );
      ((Element)v.get(232)).setAttribute("cellspacing","0" );
      ((Element)v.get(232)).setAttribute("cellpadding","0" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(232)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("td"));
      ((Element)v.get(234)).setAttribute("class","botonera" );
      ((Element)v.get(234)).setAttribute("width","100%" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(235)).setAttribute("nombre","btnAnadir" );
      ((Element)v.get(235)).setAttribute("ID","botonContenido" );
      ((Element)v.get(235)).setAttribute("tipo","html" );
      ((Element)v.get(235)).setAttribute("accion","anadirOnClick();" );
      ((Element)v.get(235)).setAttribute("estado","false" );
      ((Element)v.get(235)).setAttribute("cod","404" );
      ((Element)v.get(235)).setAttribute("ontab","focoBotonEliminar();" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */
      /* Termina nodo:234   */
      /* Termina nodo:233   */
      /* Termina nodo:232   */
      /* Termina nodo:231   */
      /* Termina nodo:230   */

      /* Empieza nodo:236 / Elemento padre: 227   */
      v.add(doc.createElement("td"));
      ((Element)v.get(227)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(237)).setAttribute("src","b.gif" );
      ((Element)v.get(237)).setAttribute("width","12" );
      ((Element)v.get(237)).setAttribute("height","12" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */
      /* Termina nodo:236   */
      /* Termina nodo:227   */

      /* Empieza nodo:238 / Elemento padre: 121   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(121)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("td"));
      ((Element)v.get(239)).setAttribute("colspan","4" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(240)).setAttribute("src","b.gif" );
      ((Element)v.get(240)).setAttribute("width","8" );
      ((Element)v.get(240)).setAttribute("height","356" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */
      /* Termina nodo:239   */
      /* Termina nodo:238   */
      /* Termina nodo:121   */
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:50   */
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:241 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(242)).setAttribute("src","b.gif" );
      ((Element)v.get(242)).setAttribute("width","12" );
      ((Element)v.get(242)).setAttribute("height","12" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */
      /* Termina nodo:241   */
      /* Termina nodo:43   */

      /* Empieza nodo:243 / Elemento padre: 35   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(35)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("td"));
      ((Element)v.get(243)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(245)).setAttribute("src","b.gif" );
      ((Element)v.get(244)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */
      /* Termina nodo:244   */

      /* Empieza nodo:246 / Elemento padre: 243   */
      v.add(doc.createElement("td"));
      ((Element)v.get(243)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(246)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("table"));
      ((Element)v.get(248)).setAttribute("width","100%" );
      ((Element)v.get(248)).setAttribute("border","0" );
      ((Element)v.get(248)).setAttribute("align","center" );
      ((Element)v.get(248)).setAttribute("cellspacing","0" );
      ((Element)v.get(248)).setAttribute("cellpadding","0" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("tr"));
   }

   private void getXML990(Document doc) {
      ((Element)v.get(248)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("td"));
      ((Element)v.get(250)).setAttribute("class","botonera" );
      ((Element)v.get(250)).setAttribute("width","100%" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(251)).setAttribute("nombre","btnAceptar" );
      ((Element)v.get(251)).setAttribute("ID","botonContenido" );
      ((Element)v.get(251)).setAttribute("tipo","html" );
      ((Element)v.get(251)).setAttribute("accion","aceptarOnClick();" );
      ((Element)v.get(251)).setAttribute("estado","false" );
      ((Element)v.get(251)).setAttribute("cod","12" );
      ((Element)v.get(251)).setAttribute("ontab","focoComboTipoCliente();" );
      ((Element)v.get(251)).setAttribute("onshtab","onShTabBotonAceptar();" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */
      /* Termina nodo:250   */
      /* Termina nodo:249   */
      /* Termina nodo:248   */
      /* Termina nodo:247   */
      /* Termina nodo:246   */

      /* Empieza nodo:252 / Elemento padre: 243   */
      v.add(doc.createElement("td"));
      ((Element)v.get(243)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(253)).setAttribute("src","b.gif" );
      ((Element)v.get(253)).setAttribute("width","12" );
      ((Element)v.get(253)).setAttribute("height","12" );
      ((Element)v.get(252)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */
      /* Termina nodo:252   */
      /* Termina nodo:243   */

      /* Empieza nodo:254 / Elemento padre: 35   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(35)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("td"));
      ((Element)v.get(255)).setAttribute("width","12" );
      ((Element)v.get(255)).setAttribute("align","center" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(256)).setAttribute("src","b.gif" );
      ((Element)v.get(256)).setAttribute("width","12" );
      ((Element)v.get(256)).setAttribute("height","12" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */
      /* Termina nodo:255   */

      /* Empieza nodo:257 / Elemento padre: 254   */
      v.add(doc.createElement("td"));
      ((Element)v.get(257)).setAttribute("width","750" );
      ((Element)v.get(254)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(258)).setAttribute("src","b.gif" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */
      /* Termina nodo:257   */

      /* Empieza nodo:259 / Elemento padre: 254   */
      v.add(doc.createElement("td"));
      ((Element)v.get(259)).setAttribute("width","12" );
      ((Element)v.get(254)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(260)).setAttribute("src","b.gif" );
      ((Element)v.get(260)).setAttribute("width","12" );
      ((Element)v.get(260)).setAttribute("height","12" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */
      /* Termina nodo:259   */
      /* Termina nodo:254   */
      /* Termina nodo:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:261 / Elemento padre: 13   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(261)).setAttribute("nombre","listado1" );
      ((Element)v.get(261)).setAttribute("ancho","576" );
      ((Element)v.get(261)).setAttribute("alto","317" );
      ((Element)v.get(261)).setAttribute("x","24" );
      ((Element)v.get(261)).setAttribute("y","304" );
      ((Element)v.get(261)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(261)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(13)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(262)).setAttribute("precarga","S" );
      ((Element)v.get(262)).setAttribute("conROver","S" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(263)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(263)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(263)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(263)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */

      /* Empieza nodo:264 / Elemento padre: 262   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(264)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(264)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(264)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(264)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(262)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */

      /* Empieza nodo:265 / Elemento padre: 262   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(265)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(265)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(262)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */
      /* Termina nodo:262   */

      /* Empieza nodo:266 / Elemento padre: 261   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(261)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(267)).setAttribute("borde","1" );
      ((Element)v.get(267)).setAttribute("horizDatos","1" );
      ((Element)v.get(267)).setAttribute("horizCabecera","1" );
      ((Element)v.get(267)).setAttribute("vertical","0" );
      ((Element)v.get(267)).setAttribute("horizTitulo","1" );
      ((Element)v.get(267)).setAttribute("horizBase","1" );
      ((Element)v.get(266)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */

      /* Empieza nodo:268 / Elemento padre: 266   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(268)).setAttribute("borde","#999999" );
      ((Element)v.get(268)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(268)).setAttribute("vertDatos","#FFFFFF" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(268)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(268)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(268)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(268)).setAttribute("horizBase","#999999" );
      ((Element)v.get(266)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */
      /* Termina nodo:266   */

      /* Empieza nodo:269 / Elemento padre: 261   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(269)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(269)).setAttribute("alto","22" );
      ((Element)v.get(269)).setAttribute("imgFondo","" );
      ((Element)v.get(269)).setAttribute("cod","00368" );
      ((Element)v.get(269)).setAttribute("ID","datosTitle" );
      ((Element)v.get(261)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */

      /* Empieza nodo:270 / Elemento padre: 261   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(270)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(270)).setAttribute("alto","22" );
      ((Element)v.get(270)).setAttribute("imgFondo","" );
      ((Element)v.get(261)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */

      /* Empieza nodo:271 / Elemento padre: 261   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(271)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(271)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(271)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(271)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(271)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(271)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(261)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(272)).setAttribute("ancho","95" );
      ((Element)v.get(272)).setAttribute("minimizable","S" );
      ((Element)v.get(272)).setAttribute("minimizada","N" );
      ((Element)v.get(271)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */

      /* Empieza nodo:273 / Elemento padre: 271   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(273)).setAttribute("ancho","50" );
      ((Element)v.get(273)).setAttribute("minimizable","S" );
      ((Element)v.get(273)).setAttribute("minimizada","N" );
      ((Element)v.get(271)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */

      /* Empieza nodo:274 / Elemento padre: 271   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(274)).setAttribute("ancho","70" );
      ((Element)v.get(274)).setAttribute("minimizable","S" );
      ((Element)v.get(274)).setAttribute("minimizada","N" );
      ((Element)v.get(271)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */

      /* Empieza nodo:275 / Elemento padre: 271   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(275)).setAttribute("ancho","50" );
      ((Element)v.get(275)).setAttribute("minimizable","S" );
      ((Element)v.get(275)).setAttribute("minimizada","N" );
      ((Element)v.get(271)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */

      /* Empieza nodo:276 / Elemento padre: 271   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(276)).setAttribute("ancho","60" );
      ((Element)v.get(276)).setAttribute("minimizable","S" );
      ((Element)v.get(276)).setAttribute("minimizada","N" );
      ((Element)v.get(271)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */

      /* Empieza nodo:277 / Elemento padre: 271   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(277)).setAttribute("ancho","50" );
      ((Element)v.get(277)).setAttribute("minimizable","S" );
      ((Element)v.get(277)).setAttribute("minimizada","N" );
      ((Element)v.get(277)).setAttribute("oculta","S" );
      ((Element)v.get(271)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */

      /* Empieza nodo:278 / Elemento padre: 271   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(278)).setAttribute("ancho","70" );
      ((Element)v.get(278)).setAttribute("minimizable","S" );
      ((Element)v.get(278)).setAttribute("minimizada","N" );
      ((Element)v.get(278)).setAttribute("oculta","S" );
      ((Element)v.get(271)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */

      /* Empieza nodo:279 / Elemento padre: 271   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(279)).setAttribute("ancho","50" );
      ((Element)v.get(279)).setAttribute("minimizable","S" );
      ((Element)v.get(279)).setAttribute("minimizada","N" );
      ((Element)v.get(279)).setAttribute("oculta","S" );
      ((Element)v.get(271)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */

      /* Empieza nodo:280 / Elemento padre: 271   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(280)).setAttribute("ancho","60" );
      ((Element)v.get(280)).setAttribute("minimizable","S" );
      ((Element)v.get(280)).setAttribute("minimizada","N" );
      ((Element)v.get(280)).setAttribute("oculta","S" );
      ((Element)v.get(271)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */
      /* Termina nodo:271   */

      /* Empieza nodo:281 / Elemento padre: 261   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(281)).setAttribute("alto","20" );
      ((Element)v.get(281)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(281)).setAttribute("imgFondo","" );
      ((Element)v.get(281)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(261)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(282)).setAttribute("colFondo","" );
      ((Element)v.get(282)).setAttribute("ID","EstCab" );
      ((Element)v.get(282)).setAttribute("cod","124" );
      ((Element)v.get(281)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */

      /* Empieza nodo:283 / Elemento padre: 281   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(283)).setAttribute("colFondo","" );
      ((Element)v.get(283)).setAttribute("ID","EstCab" );
      ((Element)v.get(283)).setAttribute("cod","109" );
      ((Element)v.get(281)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */

      /* Empieza nodo:284 / Elemento padre: 281   */
   }

   private void getXML1170(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(284)).setAttribute("colFondo","" );
      ((Element)v.get(284)).setAttribute("ID","EstCab" );
      ((Element)v.get(284)).setAttribute("cod","143" );
      ((Element)v.get(281)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */

      /* Empieza nodo:285 / Elemento padre: 281   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(285)).setAttribute("colFondo","" );
      ((Element)v.get(285)).setAttribute("ID","EstCab" );
      ((Element)v.get(285)).setAttribute("cod","112" );
      ((Element)v.get(281)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */

      /* Empieza nodo:286 / Elemento padre: 281   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(286)).setAttribute("colFondo","" );
      ((Element)v.get(286)).setAttribute("ID","EstCab" );
      ((Element)v.get(286)).setAttribute("cod","126" );
      ((Element)v.get(281)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */

      /* Empieza nodo:287 / Elemento padre: 281   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(287)).setAttribute("colFondo","" );
      ((Element)v.get(287)).setAttribute("ID","EstCab" );
      ((Element)v.get(287)).setAttribute("cod","109" );
      ((Element)v.get(281)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */

      /* Empieza nodo:288 / Elemento padre: 281   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(288)).setAttribute("colFondo","" );
      ((Element)v.get(288)).setAttribute("ID","EstCab" );
      ((Element)v.get(288)).setAttribute("cod","143" );
      ((Element)v.get(281)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */

      /* Empieza nodo:289 / Elemento padre: 281   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(289)).setAttribute("colFondo","" );
      ((Element)v.get(289)).setAttribute("ID","EstCab" );
      ((Element)v.get(289)).setAttribute("cod","112" );
      ((Element)v.get(281)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */

      /* Empieza nodo:290 / Elemento padre: 281   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(290)).setAttribute("colFondo","" );
      ((Element)v.get(290)).setAttribute("ID","EstCab" );
      ((Element)v.get(290)).setAttribute("cod","126" );
      ((Element)v.get(281)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */
      /* Termina nodo:281   */

      /* Empieza nodo:291 / Elemento padre: 261   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(291)).setAttribute("alto","22" );
      ((Element)v.get(291)).setAttribute("accion","" );
      ((Element)v.get(291)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(291)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(291)).setAttribute("maxSel","-1" );
      ((Element)v.get(291)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(291)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(291)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(291)).setAttribute("onLoad","" );
      ((Element)v.get(291)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(261)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(292)).setAttribute("tipo","texto" );
      ((Element)v.get(292)).setAttribute("ID","EstDat" );
      ((Element)v.get(291)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */

      /* Empieza nodo:293 / Elemento padre: 291   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(293)).setAttribute("tipo","texto" );
      ((Element)v.get(293)).setAttribute("ID","EstDat2" );
      ((Element)v.get(291)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */

      /* Empieza nodo:294 / Elemento padre: 291   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(294)).setAttribute("tipo","texto" );
      ((Element)v.get(294)).setAttribute("ID","EstDat" );
      ((Element)v.get(291)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */

      /* Empieza nodo:295 / Elemento padre: 291   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(295)).setAttribute("tipo","texto" );
      ((Element)v.get(295)).setAttribute("ID","EstDat2" );
      ((Element)v.get(291)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */

      /* Empieza nodo:296 / Elemento padre: 291   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(296)).setAttribute("tipo","texto" );
      ((Element)v.get(296)).setAttribute("ID","EstDat" );
      ((Element)v.get(291)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */

      /* Empieza nodo:297 / Elemento padre: 291   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(297)).setAttribute("tipo","texto" );
      ((Element)v.get(297)).setAttribute("ID","EstDat" );
      ((Element)v.get(291)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */

      /* Empieza nodo:298 / Elemento padre: 291   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(298)).setAttribute("tipo","texto" );
      ((Element)v.get(298)).setAttribute("ID","EstDat2" );
      ((Element)v.get(291)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */

      /* Empieza nodo:299 / Elemento padre: 291   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(299)).setAttribute("tipo","texto" );
      ((Element)v.get(299)).setAttribute("ID","EstDat" );
      ((Element)v.get(291)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */

      /* Empieza nodo:300 / Elemento padre: 291   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(300)).setAttribute("tipo","texto" );
      ((Element)v.get(300)).setAttribute("ID","EstDat2" );
      ((Element)v.get(291)).appendChild((Element)v.get(300));
      /* Termina nodo:300   */
      /* Termina nodo:291   */

      /* Empieza nodo:301 / Elemento padre: 261   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(261)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */

      /* Empieza nodo:302 / Elemento padre: 261   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(302)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(302)).setAttribute("ancho","576" );
      ((Element)v.get(302)).setAttribute("sep","$" );
      ((Element)v.get(302)).setAttribute("x","12" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(302)).setAttribute("class","botonera" );
      ((Element)v.get(302)).setAttribute("y","598" );
      ((Element)v.get(302)).setAttribute("control","|" );
      ((Element)v.get(302)).setAttribute("conector","" );
      ((Element)v.get(302)).setAttribute("rowset","" );
      ((Element)v.get(302)).setAttribute("cargainicial","N" );
      ((Element)v.get(261)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */
      /* Termina nodo:261   */

      /* Empieza nodo:303 / Elemento padre: 13   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(303)).setAttribute("nombre","btnEliminar" );
      ((Element)v.get(303)).setAttribute("x","30" );
      ((Element)v.get(303)).setAttribute("y","599" );
      ((Element)v.get(303)).setAttribute("ID","botonContenido" );
      ((Element)v.get(303)).setAttribute("tipo","html" );
      ((Element)v.get(303)).setAttribute("estado","false" );
      ((Element)v.get(303)).setAttribute("cod","1254" );
      ((Element)v.get(303)).setAttribute("accion","eliminarOnClick();" );
      ((Element)v.get(303)).setAttribute("ontab","focoBotonAceptar();" );
      ((Element)v.get(303)).setAttribute("onshtab","focoBotonAnadir();" );
      ((Element)v.get(13)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */

      /* Empieza nodo:304 / Elemento padre: 13   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(304)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(304)).setAttribute("alto","12" );
      ((Element)v.get(304)).setAttribute("ancho","100%" );
      ((Element)v.get(304)).setAttribute("colorf","" );
      ((Element)v.get(304)).setAttribute("borde","0" );
      ((Element)v.get(304)).setAttribute("imagenf","" );
      ((Element)v.get(304)).setAttribute("repeat","" );
      ((Element)v.get(304)).setAttribute("padding","" );
      ((Element)v.get(304)).setAttribute("visibilidad","visible" );
      ((Element)v.get(304)).setAttribute("contravsb","" );
      ((Element)v.get(304)).setAttribute("x","0" );
      ((Element)v.get(304)).setAttribute("y","621" );
      ((Element)v.get(304)).setAttribute("zindex","" );
      ((Element)v.get(13)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */
      /* Termina nodo:13   */


   }

}
