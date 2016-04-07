
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_calificacion_participantes_seleccionar  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_calificacion_participantes_seleccionar" );
      ((Element)v.get(0)).setAttribute("cod","0491" );
      ((Element)v.get(0)).setAttribute("titulo","Crear concurso" );
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
      v.add(doc.createElement("JS"));
      ((Element)v.get(5)).setAttribute("src","pestanyas_concurso_inc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(6)).setAttribute("src","validaciones_sicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(7));

      /* Elemento padre:7 / Elemento actual: 8   */
      v.add(doc.createTextNode("\r   \r\rvar contador;\r\r function onLoadPag()   { \r    contador = 0;\r    DrdEnsanchaConMargenDcho('listado1',26);\r    document.all[\"Cplistado1\"].style.visibility='';\r    document.all[\"CpLin1listado1\"].style.visibility='';\r    document.all[\"CpLin2listado1\"].style.visibility='';\r    document.all[\"CpLin3listado1\"].style.visibility='';\r    document.all[\"CpLin4listado1\"].style.visibility='';\r    document.all[\"separa1Div\"].style.visibility='hidden';\r    document.all[\"primera1Div\"].style.visibility='hidden';\r    document.all[\"ret1Div\"].style.visibility='hidden';\r    document.all[\"ava1Div\"].style.visibility='hidden';\r    document.all[\"btnExcluirDiv\"].style.visibility='';\r    document.all[\"btnExcluirTodosDiv\"].style.visibility='';\r  \r    eval (ON_RSZ);\r  \r    configurarMenuSecundario(\"formulario\");   \r\r	btnProxy(1, '0');\r	btnProxy(2, '1');\r	btnProxy(3, '0');\r	btnProxy(7, '0');\r	btnProxy(8, '0');\r	btnProxy(9, '0');\r    \r    var controles = get(\"formulario.hPantallaParticipantesControlesOcultos\");    \r    if (controles ==\"S\") mostrarLista('N');        \r    else mostrarLista('S');\r  \r    deshabilitarBotones(); \r    \r    if (get('formulario.lstClasificacionParticipantesConsultoras') != null)\r            cargaLista(listado1,get('formulario.lstClasificacionParticipantesConsultoras'));\r  \r    if (get('formulario.lstClasificacionParticipantes') != null)\r         cargaLista(listado2, get('formulario.lstClasificacionParticipantes'));\r            \r    if (listado1.datos.length > 0)\r         set('formulario.hidUltimoElementoEnLaLista', listado2.datos.length);\r         \r    var menu = get(\"formulario.opcionMenu\"); \r    if (menu == \"Consultar Concurso\"){\r          deshabilitarHabilitarBoton('botonContenido', 'btnAnadirTodos', 'D');\r          deshabilitarHabilitarBoton('botonContenido', 'btnAnadir', 'D');\r          deshabilitarHabilitarBoton('botonContenido', 'btnAceptar', 'D');\r          deshabilitarHabilitarBoton('botonContenido', 'btnExcluir', 'D');\r          deshabilitarHabilitarBoton('botonContenido', 'btnExcluirTodos', 'D');   \r    }\r\r	var datosLista1 = listado1.datos;\r	var datosLista2 = listado2.datos;\r\r	var datosFinales = new Array();\r	var k = 0;\r\r			for(var j=0; j<datosLista2.length; j++) {\r		var igual = \"false\";\r\r		for(var i=0; i<datosLista1.length; i++) {\r			if(datosLista2[j][0]==datosLista1[i][1]) igual = \"true\";\r		}\r\r		if(igual==\"false\") {\r			datosFinales[k] = datosLista2[j];\r			k++;\r		}\r	}\r\r	listado2.setDatos(datosFinales);\r	listado2.actualizaDat();\r	if (menu != \"Consultar Concurso\"){\r		onTabAnadirTodos();\r	}\r }\r \r function mostrarLista(estado){   \r   \r   estado = \"S\";\r   \r   \r   if (estado == 'N'){\r      document.getElementById('panel').height = 320;\r       DrdEnsanchaConMargenDcho('listado2',26);\r       document.all[\"Cplistado2\"].style.display='none';\r       document.all[\"CpLin1listado2\"].style.display='none';\r       document.all[\"CpLin2listado2\"].style.display='none';\r       document.all[\"CpLin3listado2\"].style.display='none';\r       document.all[\"CpLin4listado2\"].style.display='none';\r       document.all[\"separa2Div\"].style.display='none';\r       document.all[\"primera2Div\"].style.display='none';\r       document.all[\"ret2Div\"].style.display='none';\r       document.all[\"ava2Div\"].style.display='none';\r       document.all[\"btnAnadirDiv\"].style.display='none';\r       document.all[\"btnAnadirTodosDiv\"].style.display='none';\r       deshabilitarHabilitarBoton('botonContenido','btnExcluir','D');\r       deshabilitarHabilitarBoton('botonContenido','btnExcluirTodos','D');\r       \r  }else{\r          DrdEnsanchaConMargenDcho('listado2',26);\r          document.all[\"Cplistado2\"].style.visibility='visible';\r          document.all[\"CpLin1listado2\"].style.visibility='visible';\r          document.all[\"CpLin2listado2\"].style.visibility='visible';\r          document.all[\"CpLin3listado2\"].style.visibility='visible';\r          document.all[\"CpLin4listado2\"].style.visibility='visible';\r          document.all[\"separa2Div\"].style.visibility='visible';\r          document.all[\"primera2Div\"].style.visibility='visible';\r          document.all[\"ret2Div\"].style.visibility='visible';\r          document.all[\"ava2Div\"].style.visibility='visible';\r          document.all[\"btnAnadirDiv\"].style.visibility='visible';\r          document.all[\"btnAnadirTodosDiv\"].style.visibility='visible';\r          deshabilitarHabilitarBoton('botonContenido','btnExcluir','A');\r          deshabilitarHabilitarBoton('botonContenido','btnExcluirTodos','A');\r   }\r   eval (ON_RSZ);\r }\r \r \r    \r\r  function deshabilitarBotones(){\r	    if(get('formulario.hEstadoBtnEstatusVenta')=='N'){\r      deshabilitarHabilitarBoton('botonContenido', 'btnEstatusVenta', 'D');\r    }\r  }\r  \r    function ocultarListaParticipantes(){\r        document.all[\"Cplistado2\"].style.visibility='';\r    document.all[\"CpLin1listado2\"].style.visibility='';\r    document.all[\"CpLin2listado2\"].style.visibility='';\r    document.all[\"CpLin3listado2\"].style.visibility='';\r    document.all[\"CpLin4listado2\"].style.visibility='';\r    document.all[\"separa2Div\"].style.visibility='';\r    document.all[\"primera2Div\"].style.visibility='';\r    document.all[\"ret2Div\"].style.visibility='';\r    document.all[\"ava2Div\"].style.visibility='';\r    document.all[\"btnAnadirDiv\"].style.visibility='';\r    document.all[\"btnAnadirTodosDiv\"].style.visibility='';\r\r        document.all[\"btnAnadirDiv\"].style.visibility='';\r    document.all[\"btnAnadirTodosDiv\"].style.visibility='';\r    document.all[\"btnExcluirDiv\"].style.visibility='';\r    document.all[\"btnExcluirTodosDiv\"].style.visibility='';\r    document.getElementById('panel').height = 320;\r  \r }  \r  \rfunction cargaLista(lista, items) { \r  if (items != null) {\r   actualizaListado(lista, items);\r }\r}\r\rfunction actualizaListado(lista, listaItems){\r		var fila = listaItems.split('$');\r		for(i=0;i<fila.length;i++){\r			if (fila[i] != ''){\r				var newRow = new Array();\r				newRow = fila[i].split(\"|\");\r				lista.insertar(newRow);\r			}\r		}\r}\r   \r  function fVolver(){\r        window.close();\r    }\r\rfunction fLimpiar() {\r	focalizaBotonHTML('botonContenido','btnAceptar');	\r}\r\rfunction accionExcluir(){\r	listado1.actualizaDat();\r	listado2.actualizaDat();\r	excluyeEltosSel(listado1, listado2);\r}\r\rfunction excluyeEltosSel(listaOr, listaDe){\r	var codSelecc = listaOr.codSeleccionados(); \r	var cantTemp = codSelecc.length;\r	var datos = listaOr.codigos();   \r\r		if (codSelecc == \"\"){\r		GestionarMensaje(\"4\", null, null, null);\r		return;\r	}  \r\r			var toAdd = \"\";\r	for(var i=0; i<cantTemp; i++) {	\r		if(i==0)  {\r		    toAdd = listaOr.extraeDato(codSelecc[i], 0) + \"|\" + listaOr.extraeDato(codSelecc[i], 2); \r		}\r		else {			\r			toAdd = toAdd + \"$\" + listaOr.extraeDato(codSelecc[i], 0) + \"|\" + listaOr.extraeDato(codSelecc[i], 2);\r		}		\r	}\r\r		var arrayNuevo = new Array();\r	var g = 0;\r	for(var i=0; i<datos.length; i++) {\r		var inserto = \"true\";\r		for(var j=0; j<codSelecc.length; j++) {\r			if((listaOr.datos[i][1]==listaOr.extraeDato(codSelecc[j], 0))) {\r				inserto = \"false\";\r			}\r		}\r		if(inserto==\"true\") {\r			arrayNuevo[g] = listaOr.datos[i];\r			g++;\r		}\r	}\r	listaOr.setDatos(arrayNuevo);\r	\r\r	\r		    var filas = new Array();  \r	filas = toAdd.split(\"$\");	\r	var listaDes = listaDe.datos;\r\r	for(var i=0; i<filas.length; i++) {		\r		var registro = new Array();\r		registro = filas[i].split(\"|\");\r		var inserto = \"true\";\r\r		for(var j=0; j<listaDes.length; j++) {\r			if(registro[0]==listaDes[j][0]) inserto = \"false\";\r		}	\r	\r		if(inserto==\"true\") listaDe.insertar(registro);\r	}\r\r	listaOr.eliminarSelecc();\r }\r\rfunction accionExcluirTodos(){\r  excluyeTodosLosEltos(listado1, listado2);  \r}\r\r\rfunction excluyeTodosLosEltos(listaOr, listaDe){  \r  listaOr.actualizaDat();\r  listaDe.actualizaDat();\r   \r  var codigo = listaOr.codigos();\r  lon =  codigo.length;  \r   \r  var cant = get(\"formulario.hCantidad\");    \r  total = lon/cant;  \r  var dato = \"\";\r  \r	for(var a = 0; a < lon ; a++){                   \r       var dos = listaOr.extraeDato(codigo[a], 0);             \r       toAdd = dos + \"|\" + listaOr.extraeDato(codigo[a], 2);                   \r       var newRow = new Array();\r       newRow = toAdd.split(\"|\");\r        \r       if (dato == newRow[1]){\r       }\r       else{\r	       listaDe.insertar(newRow);\r       }\r       \r       dato = listaOr.extraeDato(codigo[a], 2);        \r     } \r          \r     var nuevos_datos = new Array();\r     listaOr.setDatos(nuevos_datos);\r  }\r\r\rfunction isInListado2(item, listaDestino){\r   \r   listaDestino.actualizaDat();\r   var codListD = listaDestino.codigos();\r   \r   var lonLisD = listaDestino.datos.length; \r  \r   var estaEnLista = 0;\r        \r   for(var b = 0; b < lonLisD ; b++){  \r    \r      if (item == codListD[b]){\r       estaEnLista = 1;           \r    \r      }\r   }\r   return estaEnLista;\r }\r\rfunction accionAniadir(){\r var oidDirigido = get(\"formulario.oidDirigidoA\");\r var constante = get(\"formulario.cteOidDirigidoAConsultora\");\r var listaEstatus = get(\"formulario.hidLstEstatusVta\"); \r\r if (oidDirigido == constante){  \r	if(listaEstatus !=\"\"){\r		aniadeEltosSel(listado2, listado1); \r	}\r	else{\r		GestionarMensaje(\"10000\", null, null, null);     \r	}      \r }\r else {\r	 aniadeEltosSel2(listado2,listado1); \r }\r}\r\rfunction aniadeEltosSel2(listaOr, listaDe){\r    listaOr.actualizaDat();\r    listaDe.actualizaDat();   \r    \r    var cantElementosL2 = listaOr.codSeleccionados();		      \r    \r    if (cantElementosL2.length == 0){\r       GestionarMensaje(\"4\", null, null, null);\r       return;\r    }\r        \r    var codigo = listaOr.codSeleccionados();  \r    var total = \"\";\r    lon = codigo.length;      \r \r    for(var a = 0; a < lon ; a++){\r        if (isInListado1(codigo[a], listaDe) == 0) {            \r                var posi = parseInt(get('formulario.hidUltimoElementoEnLaLista'), 10);                \r                var datosLista = get(\"formulario.hidLstEstatusVta\");\r                var listaParseada = parsearDatosLista(datosLista);                 \r                var cant = get(\"formulario.hCantidad\");    \r                var dos =  get(\"formulario.dEstatus\");\r                var oid = get(\"formulario.oEstatus\");                          \r                \r                for(t=0; t < cant ; t++){          \r                    var valor = dos.split(\",\");     \r                    					var iPos = \"G\" + contador;\r                    toAdd = iPos + \"|\" + codigo[a] +\"|\" + \" \" + \"|\" + listaOr.extraeDato(codigo[a], 0) ;             \r                    toAdd = toAdd + \"|\" + \" \" + \"|\";                    \r                    var newRow = new Array();\r                    newRow = toAdd.split(\"|\");                    \r                    listaDe.insertar(newRow);     \r					contador++; \r                }\r                set('formulario.hidUltimoElementoEnLaLista', iPos);\r            }\r        }\r        listaOr.eliminarSelecc();        \r		cantElementosL1 = \"\";     \r}\r\r\rfunction aniadeEltosSel(listaOr, listaDe){\r    listaOr.actualizaDat();\r    listaDe.actualizaDat();   \r    \r    var cantElementosL1 = \"\";\r \r    cantElementosL1 = listaOr.codSeleccionados();		    \r    \r    if (cantElementosL1.length == 0){\r       GestionarMensaje(\"4\", null, null, null);\r       return;\r    }\r\r    var total = \"\";\r    lon = cantElementosL1.length;\r    \r    for(var a = 0; a < lon ; a++){\r        if (isInListado1(cantElementosL1[a], listaDe) == 0) {\r                var posi = parseInt(get('formulario.hidUltimoElementoEnLaLista'), 10);                \r                var datosLista = get(\"formulario.hidLstEstatusVta\");\r                var listaParseada = parsearDatosLista(datosLista);                 \r                var cant = get(\"formulario.hCantidad\");    \r                var dos =  get(\"formulario.dEstatus\");\r                var oid = get(\"formulario.oEstatus\");                          \r                \r                for(t=0; t < cant ; t++){          \r                    var valor = dos.split(\",\");     \r				    var oidParseados = oid.split(\",\");					\r                    					var iPos = \"G\" + contador;\r                   \r                    toAdd = iPos + \"|\" + cantElementosL1[a] +\"|\" + oidParseados[t] + \"|\" + listaOr.extraeDato(cantElementosL1[a], 0);\r                    toAdd = toAdd + \"|\" + valor[t] + \"|\";          \r                    var newRow = new Array();\r                    newRow = toAdd.split(\"|\");                    \r                    listaDe.insertar(newRow);\r					contador++;               \r                }\r                set('formulario.hidUltimoElementoEnLaLista', iPos);\r            }\r        }\r        listaOr.eliminarSelecc();        \r	    cantElementosL1 = \"\";     \r}\r\r\rfunction parsearDatosLista(datos) {      \r        var newRow = new Array();      \r        newRow = datos.split(\",\");\r        \r        var oidEstatus = new Array();\r        var descEstatus = new Array();               \r        var cantidadFilas = newRow.length/8;\r        \r        set(\"formulario.hCantidad\" , cantidadFilas);\r\r		  		  var indiceOid = 2;\r		  var indiceDesc = 5\r		  for (var i = 0; i < cantidadFilas; i++)\r		  {\r				var oid = newRow[indiceOid];\r				var desc = newRow[indiceDesc];\r\r				if ( i != 0) {\r						oidEstatus = oidEstatus + \",\" \r						descEstatus = descEstatus + \" ,\"\r				}\r\r				oidEstatus = oidEstatus + oid;\r				descEstatus = descEstatus + desc;\r\r				indiceOid = indiceOid + 8;\r				indiceDesc = indiceDesc + 8;\r\r		  }\r		          \r        set(\"formulario.oEstatus\" , oidEstatus);\r        set(\"formulario.dEstatus\" , descEstatus);\r				 \r  }\r\rfunction isInListado1(item, listaDestino){\r	listaDestino.actualizaDat();\r	var codListD = listaDestino.codigos();\r	var lonLisD = listaDestino.datos.length;        \r	var estaEnLista = 0;\r        \r	for(var b = 0; b < lonLisD ; b++){     \r	  var vDestino = listaDestino.extraeDato(codListD[b], 0);     \r	\r	  if (item == vDestino) estaEnLista = 1;       \r    }\r   \r    return estaEnLista;\r}\r\r\r\r\rfunction accionAniadirTodos(){\r var oidDirigido = get(\"formulario.oidDirigidoA\");\r var constante = get(\"formulario.cteOidDirigidoAConsultora\"); \r var listaEstatus = get(\"formulario.hidLstEstatusVta\");\r\r if (oidDirigido == constante){ \r    if(listaEstatus !=\"\"){       \r         aniadeLosEltos(listado2, listado1);\r     }\r	 else{\r        GestionarMensaje(\"10000\", null, null, null);     \r     }   \r  } \r  else {     \r     aniadeTodosLosEltos(listado2, listado1);\r  } \r} \r\r\rfunction aniadeLosEltos(listaOr, listaDe){  listaOr.actualizaDat();\r listaDe.actualizaDat();\r \r var codigo = listaOr.codigos();\r lon =  codigo.length;\r    \r  for(var a = 0; a < lon ; a++){        if (isInListado1(codigo[a], listaDe) == 0) {            \r                var posi = parseInt(get('formulario.hidUltimoElementoEnLaLista'), 10);               \r                \r                var datosLista = get(\"formulario.hidLstEstatusVta\");\r                var listaParseada = parsearDatosLista(datosLista); \r                \r                var cant = get(\"formulario.hCantidad\");    \r                var dos =  get(\"formulario.dEstatus\");\r                var oid = get(\"formulario.oEstatus\");				 \r                \r                for(t=0; t < cant ; t++){          \r						  						  var oidParseados = oid.split(\",\");\r						  \r                    var valor = dos.split(\",\");            \r                    					var iPos = \"G\" + contador;                   \r                    \r                    toAdd = iPos + \"|\" + codigo[a] +\"|\" + oidParseados[t] + \"|\" + listaOr.extraeDato(codigo[a], 0) ;\r                    toAdd = toAdd + \"|\" + valor[t] + \"|\";\r                    \r                    \r                    var newRow = new Array();\r                    newRow = toAdd.split(\"|\");\r                    \r                    \r                    listaDe.insertar(newRow);\r					contador++;      \r               \r                }                set('formulario.hidUltimoElementoEnLaLista', iPos);\r            }        }        \r        \r        \r       var nuevos_datos = new Array();\r        listaOr.setDatos(nuevos_datos);\r   }   \r   \rfunction aniadeTodosLosEltos(listaOr, listaDe){  \r listaOr.actualizaDat();\r listaDe.actualizaDat();\r \r var codigo = listaOr.codigos();\r\r lon =  codigo.length;\r \r		for(var a = 0; a < lon ; a++){ \r  \r          if (isInListado1(codigo[a], listaDe) == 0) \r            {            \r                var posi = parseInt(get('formulario.hidUltimoElementoEnLaLista'), 10);\r           \r                \r                var datosLista = get(\"formulario.hidLstEstatusVta\");\r                \r                if (datosLista != \"\"){\r                      var listaParseada = parsearDatosLista(datosLista); \r                \r                      var cant = get(\"formulario.hCantidad\");    \r                      var dos =  get(\"formulario.dEstatus\");\r                      var oid = get(\"formulario.oEstatus\");\r                      \r                      \r                      var valor = dos.split(\",\");\r                }\r            \r                        \r                    					var iPos = \"G\" + contador;\r                   \r                    \r                    toAdd = iPos + \"|\" + codigo[a] +\"|\" + \" \" + \"|\" + listaOr.extraeDato(codigo[a], 0) ;\r                    toAdd = toAdd + \"|\" + \" \" + \"|\";\r                    \r                    \r                    var newRow = new Array();\r                    newRow = toAdd.split(\"|\");\r                    \r                    \r                    listaDe.insertar(newRow);\r					contador++;  \r               \r                             set('formulario.hidUltimoElementoEnLaLista', iPos);\r            }        }        \r        \r       var nuevos_datos = new Array();\r        listaOr.setDatos(nuevos_datos);\r   }   \r   \rfunction accionEstatusVenta(){\r\r  var parametros = new Object();  \r  parametros.opcionMenu = get('formulario.opcionMenu');\r  \r  var listasEstatusVenta =  mostrarModalSICC(\"LPMantenerParametrosConsultoras\", \"cargar estatus venta calificacion\", parametros,800,500);\r      if (listasEstatusVenta != null && listasEstatusVenta != undefined) {\r	  var uno = listasEstatusVenta[0];  \r	  var dos = listasEstatusVenta[1];\r	  	  	  set(\"formulario.tempEstatusVenta\", uno);\r\r	  	  	  eval('formulario').oculto = 'S';\r	  set('formulario.accion', 'almacenarModalEstatusVenta');\r	  set('formulario.conectorAction', 'LPMantenerParametrosCalificacion');\r	  set('formulario.hidLstEstatusVta', uno);\r	  enviaSICC('formulario', null, null, 'N');\r	  \r	  set('formulario.hidLstEstatusVta', dos);\r  }\r\r\r}\r\rfunction despuesAlmacenarEstatusVenta() {\r	btnProxy(1, '0');\r	btnProxy(2, '1');\r	btnProxy(3, '0');\r	btnProxy(7, '0');\r	btnProxy(8, '0');\r	btnProxy(9, '0');\r\r    var datosLista = get(\"formulario.hidLstEstatusVta\");\r    var listaParseada = parsearDatosLista(datosLista);                 \r    var oid = get(\"formulario.oEstatus\");    \r    var oidParseados = oid.split(\",\");		\r	var datosLista1 = listado1.datos;\r	var arrayAuxiliar = new Array();\r	var h = 0;\r\r	if(datosLista1.length > 0) {\r		for(var i=0; i<datosLista1.length; i++) {\r						var encontro = \"false\";	\r\r			for(var j=0; j<oidParseados.length; j++) {\r				if(datosLista1[i][2]==oidParseados[j]){\r					encontro = \"true\";\r									}\r			}		\r\r			if(encontro==\"true\") {\r				arrayAuxiliar[h] = datosLista1[i];\r				h++;\r			}\r					}			\r	}\r\r	listado1.actualizaDat();\r	var datosLista1Act = listado1.datos;\r	var datosLista2Act = listado1.datos;\r		for(var i=0; i<datosLista1Act.length; i++) {\r		var contador = 0;			\r		\r		for(var j=0; j<datosLista2Act.length; j++) {\r			if(datosLista1Act[i][1] == datosLista2Act[j][1]) {\r				contador++;\r			}\r		}\r		\r		if(contador == 1) {\r			var id = datosLista1Act[i][0];\r			bajarHaciaParticipantes(id, datosLista1Act);\r		}\r	}\r	\r	listado1.setDatos(arrayAuxiliar);\r}\r\rfunction obtieneFilaSegunId(id, lista) {\r	var pos;\r	for(var i=0; i<lista.length; i++) {\r		if(id==lista[i][0]) {\r			pos = i;\r		}\r	}\r	return pos;\r}\r\rfunction bajarHaciaParticipantes(id, lista){\r	var codSelecc = new Array(); \r	codSelecc[0] = id;\r	var cantTemp = codSelecc.length;\r\r			var toAdd = \"\";\r	for(var i=0; i<cantTemp; i++) {	\r\r		var pos = obtieneFilaSegunId(codSelecc[i], lista);\r\r		if(i==0) toAdd = lista[pos][1] + \"|\" + lista[pos][3]; \r		else toAdd = toAdd + \"$\" + lista[pos][1] + \"|\" + lista[pos][3];	\r	}\r	\r	    var filas = new Array();  \r	filas = toAdd.split(\"$\");	\r\r	for(var i=0; i<filas.length; i++) {		\r		var registro = new Array();\r		registro = filas[i].split(\"|\");\r	\r		listado2.insertar(registro);\r	}\r }\r\rfunction listado1Tostring(){        \r        listado1.actualizaDat();\r        var codigo = listado1.codigos();\r        \r        var total = \"\";\r        for(var a = 0; a < codigo.length ; a++){            \r            var toAdd = \"\";        \r            toAdd = codigo[a];\r            \r            if(listado1.extraeDato(codigo[a], 0)!= null && listado1.extraeDato(codigo[a], 0)!=\"\") {                 \r                 toAdd = toAdd + \",\" + listado1.extraeDato(codigo[a], 0);    			}\r			else {\r			     toAdd = toAdd + \",\" + \" \"; \r			}\r            \r            if(listado1.extraeDato(codigo[a], 1)!= null && listado1.extraeDato(codigo[a], 1)!=\"\") {\r				  toAdd = toAdd + \",\" + listado1.extraeDato(codigo[a], 1);    			}\r			else {\r			     toAdd = toAdd + \",\" + \" \"; \r			}\r            \r            if(listado1.extraeDato(codigo[a], 2)!= null && listado1.extraeDato(codigo[a], 2)!=\"\") {\r                 toAdd = toAdd + \",\" + listado1.extraeDato(codigo[a], 2);    			}\r			else {\r			     toAdd = toAdd + \",\" + \" \"; \r			}\r        \r            if(listado1.extraeDato(codigo[a], 3)!= null && listado1.extraeDato(codigo[a], 3)!=\"\") {\r                 toAdd = toAdd + \",\" + listado1.extraeDato(codigo[a], 3);    			} \r			else {\r			     toAdd = toAdd + \",\" + \" \"; \r			}\r        \r            if(listado1.extraeDato(codigo[a], 4)!= null && listado1.extraeDato(codigo[a], 4)!=\"\") {\r				toAdd = toAdd + \",\" + listado1.extraeDato(codigo[a], 4);    		    }\r			else {\r			     toAdd = toAdd + \",\" + \" \"; \r			}\r            \r			total = total + \"|\" + toAdd;                    \r		}	\r        \r    total = total + \"|\";    \r	return total;\r	}  \r  \rfunction listado2Tostring(){    \r    listado2.actualizaDat();\r    var codigo = listado2.codigos();\r    var total = \"\";\r    \r    for(var a = 0; a < codigo.length ; a++){\r	    var toAdd = \"\";\r        toAdd = codigo[a];\r\r        if(listado2.extraeDato(codigo[a], 0)!= null && listado2.extraeDato(codigo[a], 0)!=\"\")\r            toAdd = toAdd + \",\" + listado2.extraeDato(codigo[a], 0);    \r		total = total + \"|\" + toAdd;\r	}	\r    \r    total = total + \"|\";      \r	return total;\r}\r\rfunction accionAceptar(){\r		listado1.actualizaDat();\r		\r				var devuelto = sicc_valida_requerido_LE('txtMontoMin', GestionarMensaje(\"1577\", null, null, null), \r		'listado1', 5);\r\r		if(devuelto==true) {\r						var retorno = sicc_valida_numero_LE('txtMontoMin', GestionarMensaje(\"1577\", null, null, null), 0, 	99999999999.99, 'Numerico', 'listado1', 5);\r\r			if(retorno==true) {\r				var listaCalificacionParticipantes = listado1Tostring();        			\r				var listaParticipantes = listado2Tostring();        		   \r				var lstEstatusVenta = listado3Tostring();  \r				var v = listaCalificacionParticipantes + '~' + listaParticipantes + '~' + lstEstatusVenta;			\r\r																eval('formulario').oculto = 'S';\r				set('formulario.accion', 'almacenarModalParticipantes');\r				set('formulario.conectorAction', 'LPMantenerParametrosCalificacion');\r				set('formulario.varListaCalificacionParticipantes', listaCalificacionParticipantes);\r				set('formulario.varListaParticipantes', listaParticipantes);\r				set('formulario.varEstatusVenta', lstEstatusVenta);\r				set('formulario.listasCalificacion', v);\r				enviaSICC('formulario');\r							}\r			else {\r				return false;\r			}		\r		}\r		else {\r			return;\r		}\r}\r\rfunction cierraModalOK(cadenaRetorno) {\r	returnValue = cadenaRetorno;\r	\r	close();\r}\r\rfunction listado3Tostring(){\r   var datosEstatus = get(\"formulario.hidLstEstatusVta\");   \r   var fila = datosEstatus.split(',');  \r   return fila;  \r}\r\rfunction onTabExcluirTodos() {\r	focalizaBotonHTML_XY('btnAnadir');	\r}\r\rfunction onTabAnadirTodos() {\r	focalizaBotonHTML('botonContenido','btnAceptar');	\r}\r\rfunction onTabAceptar() {\r	if(document.getElementById(\"btnEstatusVenta\").disabled == true) {\r		focalizaBotonHTML_XY('btnExcluir');	\r	}\r	else {\r		focalizaBotonHTML('botonContenido','btnEstatusVenta');	\r	}\r}\r\rfunction onShTabAceptar() {\r	focalizaBotonHTML_XY('btnAnadirTodos');	\r}\r\rfunction onShTabAnadir() {\r	focalizaBotonHTML_XY('btnExcluirTodos');	\r}\r\rfunction onShTabExcluir() {\r	if(document.getElementById(\"btnEstatusVenta\").disabled == true) {\r		focalizaBotonHTML('botonContenido','btnAceptar');\r	}\r	else {\r		focalizaBotonHTML('botonContenido','btnEstatusVenta');	\r	}	\r}\r\rfunction onTabEstatusVenta() {\r	focalizaBotonHTML_XY('btnExcluir');	\r}\r\r  \r"));
      ((Element)v.get(7)).appendChild((Text)v.get(8));

      /* Termina nodo Texto:8   */
      /* Termina nodo:7   */

      /* Empieza nodo:9 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(9)).setAttribute("nombre","formulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(9));

      /* Empieza nodo:10 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","accion" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","oidDirigidoA" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","cteOidDirigidoAConsultora" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","hidLstEstatusVta" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","oEstatus" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","dEstatus" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hCantidad" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","listasCalificacion" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","varListaCalificacionParticipantes" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","varListaParticipantes" );
      ((Element)v.get(23)).setAttribute("valor","" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(9)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","varEstatusVenta" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hEstadoBtnEstatusVenta" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hPantallaParticipantesControlesOcultos" );
      ((Element)v.get(26)).setAttribute("valor","S" );
      ((Element)v.get(9)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hidUltimoElementoEnLaLista" );
      ((Element)v.get(27)).setAttribute("valor","1" );
      ((Element)v.get(9)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","lstClasificacionParticipantes" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","lstParticipantes" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","tempEstatusVenta" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 9   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(31)).setAttribute("nombre","capaEspacio1" );
      ((Element)v.get(31)).setAttribute("x","0" );
      ((Element)v.get(31)).setAttribute("y","0" );
      ((Element)v.get(9)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("table"));
      ((Element)v.get(32)).setAttribute("width","100%" );
      ((Element)v.get(32)).setAttribute("border","0" );
      ((Element)v.get(32)).setAttribute("cellspacing","0" );
      ((Element)v.get(32)).setAttribute("cellpadding","0" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(32)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("td"));
      ((Element)v.get(34)).setAttribute("width","12" );
      ((Element)v.get(34)).setAttribute("align","center" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(35)).setAttribute("src","b.gif" );
      ((Element)v.get(35)).setAttribute("width","12" );
      ((Element)v.get(35)).setAttribute("height","12" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:36 / Elemento padre: 33   */
      v.add(doc.createElement("td"));
      ((Element)v.get(36)).setAttribute("width","750" );
      ((Element)v.get(33)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(37)).setAttribute("src","b.gif" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:38 / Elemento padre: 33   */
      v.add(doc.createElement("td"));
      ((Element)v.get(38)).setAttribute("width","12" );
      ((Element)v.get(33)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(39)).setAttribute("src","b.gif" );
      ((Element)v.get(39)).setAttribute("width","12" );
      ((Element)v.get(39)).setAttribute("height","1" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */
      /* Termina nodo:38   */
      /* Termina nodo:33   */

      /* Empieza nodo:40 / Elemento padre: 32   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(32)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(42)).setAttribute("src","b.gif" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */
      /* Termina nodo:41   */

      /* Empieza nodo:43 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(43)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(45)).setAttribute("class","legend" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(46)).setAttribute("nombre","lblParticipantes" );
      ((Element)v.get(46)).setAttribute("alto","13" );
      ((Element)v.get(46)).setAttribute("filas","1" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(46)).setAttribute("id","legend" );
      ((Element)v.get(46)).setAttribute("cod","0022" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:47 / Elemento padre: 44   */
      v.add(doc.createElement("table"));
      ((Element)v.get(47)).setAttribute("width","100%" );
      ((Element)v.get(47)).setAttribute("border","0" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(47)).setAttribute("align","center" );
      ((Element)v.get(47)).setAttribute("cellspacing","0" );
      ((Element)v.get(47)).setAttribute("cellpadding","0" );
      ((Element)v.get(44)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("table"));
      ((Element)v.get(50)).setAttribute("width","648" );
      ((Element)v.get(50)).setAttribute("align","left" );
      ((Element)v.get(50)).setAttribute("border","0" );
      ((Element)v.get(50)).setAttribute("cellspacing","0" );
      ((Element)v.get(50)).setAttribute("cellpadding","0" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).setAttribute("colspan","3" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(53)).setAttribute("src","b.gif" );
      ((Element)v.get(53)).setAttribute("ID","panel" );
      ((Element)v.get(53)).setAttribute("width","8" );
      ((Element)v.get(53)).setAttribute("height","653" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */
      /* Termina nodo:51   */
      /* Termina nodo:50   */
      /* Termina nodo:49   */
      /* Termina nodo:48   */
      /* Termina nodo:47   */
      /* Termina nodo:44   */
      /* Termina nodo:43   */
      /* Termina nodo:40   */

      /* Empieza nodo:54 / Elemento padre: 32   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(32)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(56)).setAttribute("src","b.gif" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:57 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(57)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("table"));
      ((Element)v.get(59)).setAttribute("width","100%" );
      ((Element)v.get(59)).setAttribute("border","0" );
      ((Element)v.get(59)).setAttribute("align","center" );
      ((Element)v.get(59)).setAttribute("cellspacing","0" );
      ((Element)v.get(59)).setAttribute("cellpadding","0" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(59)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).setAttribute("class","botonera" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(62)).setAttribute("nombre","btnAceptar" );
      ((Element)v.get(62)).setAttribute("ID","botonContenido" );
      ((Element)v.get(62)).setAttribute("tipo","html" );
      ((Element)v.get(62)).setAttribute("estado","false" );
      ((Element)v.get(62)).setAttribute("cod","12" );
      ((Element)v.get(62)).setAttribute("accion","accionAceptar();" );
      ((Element)v.get(62)).setAttribute("ontab","onTabAceptar();" );
      ((Element)v.get(62)).setAttribute("onshtab","onShTabAceptar();" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */

      /* Empieza nodo:63 / Elemento padre: 61   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(63)).setAttribute("nombre","btnEstatusVenta" );
      ((Element)v.get(63)).setAttribute("ID","botonContenido" );
      ((Element)v.get(63)).setAttribute("tipo","html" );
      ((Element)v.get(63)).setAttribute("estado","false" );
      ((Element)v.get(63)).setAttribute("cod","1701" );
      ((Element)v.get(63)).setAttribute("accion","accionEstatusVenta();" );
      ((Element)v.get(63)).setAttribute("ontab","onTabEstatusVenta();" );
      ((Element)v.get(61)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:61   */
      /* Termina nodo:60   */
      /* Termina nodo:59   */
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:64 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(65)).setAttribute("src","b.gif" );
      ((Element)v.get(65)).setAttribute("width","8" );
      ((Element)v.get(65)).setAttribute("height","12" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */
      /* Termina nodo:54   */

      /* Empieza nodo:66 / Elemento padre: 32   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(32)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(67)).setAttribute("width","12" );
      ((Element)v.get(67)).setAttribute("align","center" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(68)).setAttribute("src","b.gif" );
      ((Element)v.get(68)).setAttribute("width","12" );
      ((Element)v.get(68)).setAttribute("height","12" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:69 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).setAttribute("width","756" );
      ((Element)v.get(66)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(70)).setAttribute("src","b.gif" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:71 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).setAttribute("width","12" );
      ((Element)v.get(66)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(72)).setAttribute("src","b.gif" );
      ((Element)v.get(72)).setAttribute("width","12" );
      ((Element)v.get(72)).setAttribute("height","1" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */
      /* Termina nodo:66   */
      /* Termina nodo:32   */
      /* Termina nodo:31   */

      /* Empieza nodo:73 / Elemento padre: 9   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(73)).setAttribute("nombre","listado1" );
      ((Element)v.get(73)).setAttribute("ancho","620" );
      ((Element)v.get(73)).setAttribute("alto","301" );
      ((Element)v.get(73)).setAttribute("x","26" );
      ((Element)v.get(73)).setAttribute("y","37" );
      ((Element)v.get(73)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(73)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(9)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(74)).setAttribute("precarga","S" );
      ((Element)v.get(74)).setAttribute("conROver","S" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(75)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(75)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(75)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(75)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */

      /* Empieza nodo:76 / Elemento padre: 74   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(76)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(76)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(76)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(76)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(74)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */

      /* Empieza nodo:77 / Elemento padre: 74   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(77)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(77)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(74)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:74   */

      /* Empieza nodo:78 / Elemento padre: 73   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(73)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(79)).setAttribute("borde","1" );
      ((Element)v.get(79)).setAttribute("horizDatos","1" );
      ((Element)v.get(79)).setAttribute("horizCabecera","1" );
      ((Element)v.get(79)).setAttribute("vertical","0" );
      ((Element)v.get(79)).setAttribute("horizTitulo","1" );
      ((Element)v.get(79)).setAttribute("horizBase","1" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */

      /* Empieza nodo:80 / Elemento padre: 78   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(80)).setAttribute("borde","#999999" );
      ((Element)v.get(80)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(80)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(80)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(80)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(80)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(80)).setAttribute("horizBase","#999999" );
      ((Element)v.get(78)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:78   */

      /* Empieza nodo:81 / Elemento padre: 73   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(81)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(81)).setAttribute("alto","22" );
      ((Element)v.get(81)).setAttribute("imgFondo","" );
      ((Element)v.get(81)).setAttribute("cod","00382" );
      ((Element)v.get(81)).setAttribute("ID","datosTitle" );
      ((Element)v.get(73)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */

      /* Empieza nodo:82 / Elemento padre: 73   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(82)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(82)).setAttribute("alto","22" );
      ((Element)v.get(82)).setAttribute("imgFondo","" );
      ((Element)v.get(73)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */

      /* Empieza nodo:83 / Elemento padre: 73   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(83)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(83)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(83)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(83)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(83)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(83)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(73)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(84)).setAttribute("ancho","60" );
      ((Element)v.get(84)).setAttribute("minimizable","S" );
      ((Element)v.get(84)).setAttribute("minimizada","N" );
      ((Element)v.get(84)).setAttribute("oculta","S" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */

      /* Empieza nodo:85 / Elemento padre: 83   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(85)).setAttribute("ancho","60" );
      ((Element)v.get(85)).setAttribute("minimizable","S" );
      ((Element)v.get(85)).setAttribute("minimizada","N" );
      ((Element)v.get(85)).setAttribute("oculta","S" );
      ((Element)v.get(83)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */

      /* Empieza nodo:86 / Elemento padre: 83   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(86)).setAttribute("ancho","130" );
      ((Element)v.get(86)).setAttribute("minimizable","S" );
      ((Element)v.get(86)).setAttribute("minimizada","N" );
      ((Element)v.get(83)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */

      /* Empieza nodo:87 / Elemento padre: 83   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(87)).setAttribute("ancho","130" );
      ((Element)v.get(87)).setAttribute("minimizable","S" );
      ((Element)v.get(87)).setAttribute("minimizada","N" );
      ((Element)v.get(83)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */

      /* Empieza nodo:88 / Elemento padre: 83   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(88)).setAttribute("ancho","60" );
      ((Element)v.get(88)).setAttribute("minimizable","S" );
      ((Element)v.get(88)).setAttribute("minimizada","N" );
      ((Element)v.get(83)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:83   */

      /* Empieza nodo:89 / Elemento padre: 73   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(89)).setAttribute("alto","20" );
      ((Element)v.get(89)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(89)).setAttribute("imgFondo","" );
      ((Element)v.get(89)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(73)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(90)).setAttribute("colFondo","" );
      ((Element)v.get(90)).setAttribute("ID","EstCab" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));

      /* Elemento padre:90 / Elemento actual: 91   */
      v.add(doc.createTextNode("oidParticipante"));
      ((Element)v.get(90)).appendChild((Text)v.get(91));

      /* Termina nodo Texto:91   */
      /* Termina nodo:90   */

      /* Empieza nodo:92 / Elemento padre: 89   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(92)).setAttribute("colFondo","" );
      ((Element)v.get(92)).setAttribute("ID","EstCab" );
      ((Element)v.get(89)).appendChild((Element)v.get(92));

      /* Elemento padre:92 / Elemento actual: 93   */
      v.add(doc.createTextNode("oidEstatusVenta"));
      ((Element)v.get(92)).appendChild((Text)v.get(93));

      /* Termina nodo Texto:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:94 / Elemento padre: 89   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(94)).setAttribute("colFondo","" );
      ((Element)v.get(94)).setAttribute("ID","EstCab" );
      ((Element)v.get(94)).setAttribute("cod","9" );
      ((Element)v.get(89)).appendChild((Element)v.get(94));

      /* Elemento padre:94 / Elemento actual: 95   */
      v.add(doc.createTextNode("Descripcion"));
      ((Element)v.get(94)).appendChild((Text)v.get(95));

      /* Termina nodo Texto:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:96 / Elemento padre: 89   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(96)).setAttribute("colFondo","" );
      ((Element)v.get(96)).setAttribute("ID","EstCab" );
      ((Element)v.get(96)).setAttribute("cod","1705" );
      ((Element)v.get(89)).appendChild((Element)v.get(96));

      /* Elemento padre:96 / Elemento actual: 97   */
      v.add(doc.createTextNode("Estatus venta MAE"));
      ((Element)v.get(96)).appendChild((Text)v.get(97));

      /* Termina nodo Texto:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:98 / Elemento padre: 89   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(98)).setAttribute("colFondo","" );
      ((Element)v.get(98)).setAttribute("ID","EstCab" );
      ((Element)v.get(98)).setAttribute("cod","469" );
      ((Element)v.get(89)).appendChild((Element)v.get(98));

      /* Elemento padre:98 / Elemento actual: 99   */
      v.add(doc.createTextNode("Monto mín."));
      ((Element)v.get(98)).appendChild((Text)v.get(99));

      /* Termina nodo Texto:99   */
      /* Termina nodo:98   */
      /* Termina nodo:89   */

      /* Empieza nodo:100 / Elemento padre: 73   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(100)).setAttribute("alto","22" );
      ((Element)v.get(100)).setAttribute("accion","" );
      ((Element)v.get(100)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(100)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(100)).setAttribute("maxSel","-1" );
      ((Element)v.get(100)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(100)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(100)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(100)).setAttribute("onLoad","" );
      ((Element)v.get(100)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(73)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(101)).setAttribute("tipo","texto" );
      ((Element)v.get(101)).setAttribute("ID","EstDat" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */

      /* Empieza nodo:102 / Elemento padre: 100   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(102)).setAttribute("tipo","texto" );
      ((Element)v.get(102)).setAttribute("ID","EstDat2" );
      ((Element)v.get(100)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */

      /* Empieza nodo:103 / Elemento padre: 100   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(103)).setAttribute("tipo","texto" );
      ((Element)v.get(103)).setAttribute("ID","EstDat" );
      ((Element)v.get(100)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */

      /* Empieza nodo:104 / Elemento padre: 100   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(104)).setAttribute("tipo","texto" );
      ((Element)v.get(104)).setAttribute("ID","EstDat2" );
      ((Element)v.get(100)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */

      /* Empieza nodo:105 / Elemento padre: 100   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(105)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(105)).setAttribute("nombre","txtMontoMin" );
      ((Element)v.get(105)).setAttribute("size","16" );
      ((Element)v.get(105)).setAttribute("max","13" );
      ((Element)v.get(105)).setAttribute("ID","EstDat" );
      ((Element)v.get(105)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(100)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:100   */

      /* Empieza nodo:106 / Elemento padre: 73   */
   }

   private void getXML450(Document doc) {
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(73)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */

      /* Empieza nodo:107 / Elemento padre: 73   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(107)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(107)).setAttribute("ancho","620" );
      ((Element)v.get(107)).setAttribute("sep","$" );
      ((Element)v.get(107)).setAttribute("x","26" );
      ((Element)v.get(107)).setAttribute("class","botonera" );
      ((Element)v.get(107)).setAttribute("y","315" );
      ((Element)v.get(107)).setAttribute("control","|" );
      ((Element)v.get(107)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(107)).setAttribute("rowset","" );
      ((Element)v.get(107)).setAttribute("cargainicial","N" );
      ((Element)v.get(73)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(108)).setAttribute("nombre","ret1" );
      ((Element)v.get(108)).setAttribute("x","51" );
      ((Element)v.get(108)).setAttribute("y","319" );
      ((Element)v.get(108)).setAttribute("ID","botonContenido" );
      ((Element)v.get(108)).setAttribute("img","retroceder_on" );
      ((Element)v.get(108)).setAttribute("tipo","0" );
      ((Element)v.get(108)).setAttribute("estado","false" );
      ((Element)v.get(108)).setAttribute("alt","" );
      ((Element)v.get(108)).setAttribute("codigo","" );
      ((Element)v.get(108)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */

      /* Empieza nodo:109 / Elemento padre: 107   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(109)).setAttribute("nombre","ava1" );
      ((Element)v.get(109)).setAttribute("x","66" );
      ((Element)v.get(109)).setAttribute("y","319" );
      ((Element)v.get(109)).setAttribute("ID","botonContenido" );
      ((Element)v.get(109)).setAttribute("img","avanzar_on" );
      ((Element)v.get(109)).setAttribute("tipo","0" );
      ((Element)v.get(109)).setAttribute("estado","false" );
      ((Element)v.get(109)).setAttribute("alt","" );
      ((Element)v.get(109)).setAttribute("codigo","" );
      ((Element)v.get(109)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(107)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:107   */
      /* Termina nodo:73   */

      /* Empieza nodo:110 / Elemento padre: 9   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(110)).setAttribute("nombre","primera1" );
      ((Element)v.get(110)).setAttribute("x","34" );
      ((Element)v.get(110)).setAttribute("y","319" );
      ((Element)v.get(110)).setAttribute("ID","botonContenido" );
      ((Element)v.get(110)).setAttribute("img","primera_on" );
      ((Element)v.get(110)).setAttribute("tipo","-2" );
      ((Element)v.get(110)).setAttribute("estado","false" );
      ((Element)v.get(110)).setAttribute("alt","" );
      ((Element)v.get(110)).setAttribute("codigo","" );
      ((Element)v.get(110)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(9)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */

      /* Empieza nodo:111 / Elemento padre: 9   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(111)).setAttribute("nombre","separa1" );
      ((Element)v.get(111)).setAttribute("x","73" );
      ((Element)v.get(111)).setAttribute("y","315" );
      ((Element)v.get(111)).setAttribute("ID","botonContenido" );
      ((Element)v.get(111)).setAttribute("img","separa_base" );
      ((Element)v.get(111)).setAttribute("tipo","0" );
      ((Element)v.get(111)).setAttribute("estado","false" );
      ((Element)v.get(111)).setAttribute("alt","" );
      ((Element)v.get(111)).setAttribute("codigo","" );
      ((Element)v.get(111)).setAttribute("accion","" );
      ((Element)v.get(9)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */

      /* Empieza nodo:112 / Elemento padre: 9   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(112)).setAttribute("nombre","btnExcluir" );
      ((Element)v.get(112)).setAttribute("x","27" );
      ((Element)v.get(112)).setAttribute("y","316" );
      ((Element)v.get(112)).setAttribute("ID","botonContenido" );
      ((Element)v.get(112)).setAttribute("tipo","html" );
      ((Element)v.get(112)).setAttribute("estado","false" );
      ((Element)v.get(112)).setAttribute("cod","2421" );
      ((Element)v.get(112)).setAttribute("accion","accionExcluir();" );
      ((Element)v.get(112)).setAttribute("onshtab","onShTabExcluir();" );
      ((Element)v.get(9)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */

      /* Empieza nodo:113 / Elemento padre: 9   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(113)).setAttribute("nombre","btnExcluirTodos" );
      ((Element)v.get(113)).setAttribute("x","75" );
      ((Element)v.get(113)).setAttribute("y","316" );
      ((Element)v.get(113)).setAttribute("ID","botonContenido" );
      ((Element)v.get(113)).setAttribute("tipo","html" );
      ((Element)v.get(113)).setAttribute("estado","false" );
      ((Element)v.get(113)).setAttribute("cod","2422" );
      ((Element)v.get(113)).setAttribute("accion","accionExcluirTodos();" );
      ((Element)v.get(113)).setAttribute("ontab","onTabExcluirTodos();" );
      ((Element)v.get(9)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */

      /* Empieza nodo:114 / Elemento padre: 9   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(114)).setAttribute("nombre","listado2" );
      ((Element)v.get(114)).setAttribute("ancho","620" );
      ((Element)v.get(114)).setAttribute("alto","301" );
      ((Element)v.get(114)).setAttribute("x","26" );
      ((Element)v.get(114)).setAttribute("y","362" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(114)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(114)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(9)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(115)).setAttribute("precarga","S" );
      ((Element)v.get(115)).setAttribute("conROver","S" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(116)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(116)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(116)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(116)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */

      /* Empieza nodo:117 / Elemento padre: 115   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(117)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(117)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(117)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(117)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(115)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */

      /* Empieza nodo:118 / Elemento padre: 115   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(118)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(118)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(115)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:115   */

      /* Empieza nodo:119 / Elemento padre: 114   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(114)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(120)).setAttribute("borde","1" );
      ((Element)v.get(120)).setAttribute("horizDatos","1" );
      ((Element)v.get(120)).setAttribute("horizCabecera","1" );
      ((Element)v.get(120)).setAttribute("vertical","0" );
      ((Element)v.get(120)).setAttribute("horizTitulo","1" );
      ((Element)v.get(120)).setAttribute("horizBase","1" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */

      /* Empieza nodo:121 / Elemento padre: 119   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(121)).setAttribute("borde","#999999" );
      ((Element)v.get(121)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(121)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(121)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(121)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(121)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(121)).setAttribute("horizBase","#999999" );
      ((Element)v.get(119)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:119   */

      /* Empieza nodo:122 / Elemento padre: 114   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(122)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(122)).setAttribute("alto","22" );
      ((Element)v.get(122)).setAttribute("imgFondo","" );
      ((Element)v.get(122)).setAttribute("cod","00313" );
      ((Element)v.get(122)).setAttribute("ID","datosTitle" );
      ((Element)v.get(114)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */

      /* Empieza nodo:123 / Elemento padre: 114   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(123)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(123)).setAttribute("alto","22" );
      ((Element)v.get(123)).setAttribute("imgFondo","" );
      ((Element)v.get(114)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */

      /* Empieza nodo:124 / Elemento padre: 114   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(124)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(124)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(124)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(124)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(124)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(124)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(114)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(125)).setAttribute("ancho","100" );
      ((Element)v.get(125)).setAttribute("minimizable","S" );
      ((Element)v.get(125)).setAttribute("minimizada","N" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */

      /* Empieza nodo:126 / Elemento padre: 124   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(126)).setAttribute("ancho","30" );
      ((Element)v.get(126)).setAttribute("minimizable","S" );
      ((Element)v.get(126)).setAttribute("minimizada","N" );
      ((Element)v.get(126)).setAttribute("oculta","S" );
      ((Element)v.get(124)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */

      /* Empieza nodo:127 / Elemento padre: 124   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(127)).setAttribute("ancho","30" );
      ((Element)v.get(127)).setAttribute("minimizable","S" );
      ((Element)v.get(127)).setAttribute("minimizada","N" );
      ((Element)v.get(127)).setAttribute("oculta","S" );
      ((Element)v.get(124)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:124   */

      /* Empieza nodo:128 / Elemento padre: 114   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(128)).setAttribute("alto","20" );
      ((Element)v.get(128)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(128)).setAttribute("imgFondo","" );
      ((Element)v.get(128)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(114)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(129)).setAttribute("colFondo","" );
      ((Element)v.get(129)).setAttribute("ID","EstCab" );
      ((Element)v.get(129)).setAttribute("cod","9" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));

      /* Elemento padre:129 / Elemento actual: 130   */
   }

   private void getXML630(Document doc) {
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(129)).appendChild((Text)v.get(130));

      /* Termina nodo Texto:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:131 / Elemento padre: 128   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(131)).setAttribute("colFondo","" );
      ((Element)v.get(131)).setAttribute("ID","EstCab" );
      ((Element)v.get(128)).appendChild((Element)v.get(131));

      /* Elemento padre:131 / Elemento actual: 132   */
      v.add(doc.createTextNode("oidParticipanteCalificacion"));
      ((Element)v.get(131)).appendChild((Text)v.get(132));

      /* Termina nodo Texto:132   */
      /* Termina nodo:131   */

      /* Empieza nodo:133 / Elemento padre: 128   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(133)).setAttribute("colFondo","" );
      ((Element)v.get(133)).setAttribute("ID","EstCab" );
      ((Element)v.get(128)).appendChild((Element)v.get(133));

      /* Elemento padre:133 / Elemento actual: 134   */
      v.add(doc.createTextNode("oidParticipante"));
      ((Element)v.get(133)).appendChild((Text)v.get(134));

      /* Termina nodo Texto:134   */
      /* Termina nodo:133   */
      /* Termina nodo:128   */

      /* Empieza nodo:135 / Elemento padre: 114   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(135)).setAttribute("alto","22" );
      ((Element)v.get(135)).setAttribute("accion","" );
      ((Element)v.get(135)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(135)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(135)).setAttribute("maxSel","-1" );
      ((Element)v.get(135)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(135)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(135)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(135)).setAttribute("onLoad","" );
      ((Element)v.get(135)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(114)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(136)).setAttribute("tipo","texto" );
      ((Element)v.get(136)).setAttribute("ID","EstDat" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */

      /* Empieza nodo:137 / Elemento padre: 135   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(137)).setAttribute("tipo","texto" );
      ((Element)v.get(137)).setAttribute("ID","EstDat2" );
      ((Element)v.get(135)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */

      /* Empieza nodo:138 / Elemento padre: 135   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(138)).setAttribute("tipo","texto" );
      ((Element)v.get(138)).setAttribute("ID","EstDat" );
      ((Element)v.get(135)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:135   */

      /* Empieza nodo:139 / Elemento padre: 114   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(114)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */

      /* Empieza nodo:140 / Elemento padre: 114   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(140)).setAttribute("nombre","mipgndo2" );
      ((Element)v.get(140)).setAttribute("ancho","620" );
      ((Element)v.get(140)).setAttribute("sep","$" );
      ((Element)v.get(140)).setAttribute("x","26" );
      ((Element)v.get(140)).setAttribute("class","botonera" );
      ((Element)v.get(140)).setAttribute("y","640" );
      ((Element)v.get(140)).setAttribute("control","|" );
      ((Element)v.get(140)).setAttribute("conector","conectorSandra1" );
      ((Element)v.get(140)).setAttribute("rowset","" );
      ((Element)v.get(140)).setAttribute("cargainicial","N" );
      ((Element)v.get(114)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(141)).setAttribute("nombre","ret2" );
      ((Element)v.get(141)).setAttribute("x","51" );
      ((Element)v.get(141)).setAttribute("y","644" );
      ((Element)v.get(141)).setAttribute("ID","botonContenido" );
      ((Element)v.get(141)).setAttribute("img","retroceder_on" );
      ((Element)v.get(141)).setAttribute("tipo","0" );
      ((Element)v.get(141)).setAttribute("estado","false" );
      ((Element)v.get(141)).setAttribute("alt","" );
      ((Element)v.get(141)).setAttribute("codigo","" );
      ((Element)v.get(141)).setAttribute("accion","mipgndo2.retroceder();" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */

      /* Empieza nodo:142 / Elemento padre: 140   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(142)).setAttribute("nombre","ava2" );
      ((Element)v.get(142)).setAttribute("x","66" );
      ((Element)v.get(142)).setAttribute("y","644" );
      ((Element)v.get(142)).setAttribute("ID","botonContenido" );
      ((Element)v.get(142)).setAttribute("img","avanzar_on" );
      ((Element)v.get(142)).setAttribute("tipo","0" );
      ((Element)v.get(142)).setAttribute("estado","false" );
      ((Element)v.get(142)).setAttribute("alt","" );
      ((Element)v.get(142)).setAttribute("codigo","" );
      ((Element)v.get(142)).setAttribute("accion","mipgndo2.avanzar();" );
      ((Element)v.get(140)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:140   */
      /* Termina nodo:114   */

      /* Empieza nodo:143 / Elemento padre: 9   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(143)).setAttribute("nombre","primera2" );
      ((Element)v.get(143)).setAttribute("x","34" );
      ((Element)v.get(143)).setAttribute("y","644" );
      ((Element)v.get(143)).setAttribute("ID","botonContenido" );
      ((Element)v.get(143)).setAttribute("img","primera_on" );
      ((Element)v.get(143)).setAttribute("tipo","-2" );
      ((Element)v.get(143)).setAttribute("estado","false" );
      ((Element)v.get(143)).setAttribute("alt","" );
      ((Element)v.get(143)).setAttribute("codigo","" );
      ((Element)v.get(143)).setAttribute("accion","mipgndo2.retrocederPrimeraPagina();" );
      ((Element)v.get(9)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */

      /* Empieza nodo:144 / Elemento padre: 9   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(144)).setAttribute("nombre","separa2" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(144)).setAttribute("x","73" );
      ((Element)v.get(144)).setAttribute("y","640" );
      ((Element)v.get(144)).setAttribute("ID","botonContenido" );
      ((Element)v.get(144)).setAttribute("img","separa_base" );
      ((Element)v.get(144)).setAttribute("tipo","0" );
      ((Element)v.get(144)).setAttribute("estado","false" );
      ((Element)v.get(144)).setAttribute("alt","" );
      ((Element)v.get(144)).setAttribute("codigo","" );
      ((Element)v.get(144)).setAttribute("accion","" );
      ((Element)v.get(9)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */

      /* Empieza nodo:145 / Elemento padre: 9   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(145)).setAttribute("nombre","btnAnadir" );
      ((Element)v.get(145)).setAttribute("x","27" );
      ((Element)v.get(145)).setAttribute("y","641" );
      ((Element)v.get(145)).setAttribute("ID","botonContenido" );
      ((Element)v.get(145)).setAttribute("tipo","html" );
      ((Element)v.get(145)).setAttribute("estado","false" );
      ((Element)v.get(145)).setAttribute("cod","404" );
      ((Element)v.get(145)).setAttribute("accion","accionAniadir();" );
      ((Element)v.get(145)).setAttribute("onshtab","onShTabAnadir();" );
      ((Element)v.get(9)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */

      /* Empieza nodo:146 / Elemento padre: 9   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(146)).setAttribute("nombre","btnAnadirTodos" );
      ((Element)v.get(146)).setAttribute("x","75" );
      ((Element)v.get(146)).setAttribute("y","641" );
      ((Element)v.get(146)).setAttribute("ID","botonContenido" );
      ((Element)v.get(146)).setAttribute("tipo","html" );
      ((Element)v.get(146)).setAttribute("estado","false" );
      ((Element)v.get(146)).setAttribute("cod","1670" );
      ((Element)v.get(146)).setAttribute("accion","accionAniadirTodos();" );
      ((Element)v.get(146)).setAttribute("ontab","onTabAnadirTodos();" );
      ((Element)v.get(9)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:9   */


   }

}
