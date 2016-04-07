
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_comisiones_clientes_insertar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_comisiones_clientes_insertar" );
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
      v.add(doc.createTextNode("\r \r\rfunction onLoadPag()   {  \r    configurarMenuSecundario(\"formulario\");        \r	DrdEnsanchaConMargenDcho('listado1',12);\r	muestroCapa();\r    eval (ON_RSZ);  \r}\r\rfunction focoBotonAnadir() {\r	focalizaBotonHTML_XY('btnAnadir');\r}\r\rfunction focoBotonModificar() {\r	focalizaBotonHTML_XY('btnModificar');\r}\r\rfunction muestroCapa() {\r    document.all[\"Cplistado1\"].style.visibility='';\r    document.all[\"CpLin1listado1\"].style.visibility='';\r    document.all[\"CpLin2listado1\"].style.visibility='';\r    document.all[\"CpLin3listado1\"].style.visibility='';\r    document.all[\"CpLin4listado1\"].style.visibility='';\r    document.all[\"separaDiv\"].style.visibility='';\r    document.all[\"primera1Div\"].style.visibility='';\r    document.all[\"ret1Div\"].style.visibility='';\r    document.all[\"ava1Div\"].style.visibility='';\r\r	var opcionMenu = get(\"formulario.opcionMenu\");\r	if(opcionMenu==\"consultar\") {\r	    document.all[\"btnAnadirDiv\"].style.visibility='hidden';\r	    document.all[\"btnModificarDiv\"].style.visibility='hidden';   \r						btnProxy(3, '0');  \r    }  \r	else {\r		document.all[\"btnAnadirDiv\"].style.visibility='';\r		document.all[\"btnModificarDiv\"].style.visibility='';   \r		focoBotonAnadir();\r	}    \r\r    if (opcionMenu != \"insertar\") {\r	btnProxy(2,'1');\r  } else {\r	btnProxy(2,'0');\r  }\r}\r\rfunction agregarFila(nuevaFila) {\r  /* Posiciones de 0 a 16:\r	  - 0: oid tipo cliente\r	  - 1: desc tipo cliente\r	  - 2: tope maximo\r	  - 3: tope minimo\r	  - 4: fecha desde\r	  - 5: fecha hasta\r	  - 6: pais\r	  - 7: desc subgerencia ventas\r	  - 8: desc region\r	  - 9: desc zona \r	  - 10: desc seccion\r	  - 11: desc territorio\r	  - 12: oid subgerencia\r	  - 13: oid region\r	  - 14: oid zona\r	  - 15: oid seccion\r	  - 16: oid territorio */\r\r	  if(nuevaFila!=\"\") {\r		for(var i=0; i<nuevaFila.length; i++) {\r			var oidTipoCliente = nuevaFila[i][10].toString();\r			var desTipoCliente = nuevaFila[i][11].toString();  \r			var topeMaximo = nuevaFila[i][12].toString();		\r			var topeMinimo = nuevaFila[i][13].toString();\r			var fechaDesde = nuevaFila[i][14].toString();\r			var fechaHasta = nuevaFila[i][15].toString();\r			var pais = get(\"formulario.descPais\");\r			var desubgerencia = nuevaFila[i][1].toString();\r			var desRegion = nuevaFila[i][2].toString();\r			var desZona = nuevaFila[i][3].toString();\r			var desSeccion = nuevaFila[i][4].toString();\r			var desTerritorio = nuevaFila[i][5].toString();			\r			var oidSubgerencia = nuevaFila[i][0].toString();\r			var oidRegion = nuevaFila[i][6].toString();	\r			var oidZona = nuevaFila[i][7].toString();\r			var oidSeccion = nuevaFila[i][8].toString();			\r			var oidTerritorio = nuevaFila[i][9].toString();\r\r			var arrayInsertar = new Array();\r		\r			arrayInsertar[0] = new String(oidTipoCliente);\r			arrayInsertar[1] = new String(desTipoCliente);\r			arrayInsertar[2] = new String(topeMaximo);\r			arrayInsertar[3] = new String(topeMinimo);\r			arrayInsertar[4] = new String(fechaDesde);\r			arrayInsertar[5] = new String(fechaHasta);\r			arrayInsertar[6] = new String(pais);\r			arrayInsertar[7] = new String(desubgerencia);\r			arrayInsertar[8] = new String(desRegion);\r			arrayInsertar[9] = new String(desZona);\r			arrayInsertar[10] = new String(desSeccion);\r			arrayInsertar[11] = new String(desTerritorio);\r			arrayInsertar[12] = new String(oidSubgerencia);\r			arrayInsertar[13] = new String(oidRegion);\r			arrayInsertar[14] = new String(oidZona);\r			arrayInsertar[15] = new String(oidSeccion); \r			arrayInsertar[16] = new String(oidTerritorio); \r\r		    var filaSeleccionadaModificar = get(\"formulario.filaSeleccionadaModificar\");\r	        var presionoModificar = get(\"formulario.presionoModificar\");\r\r			if(presionoModificar==\"true\") {\r				listado1.actualizaDat();   \r				var datos = listado1.datos;\r				datos[filaSeleccionadaModificar] = arrayInsertar; \r				listado1.setDatos(datos);\r				listado1.repintaDat();\r			}\r			else {\r				listado1.actualizaDat();   \r				var datos = listado1.datos;\r				datos[datos.length] = arrayInsertar; \r				listado1.setDatos(datos);\r				listado1.repintaDat();\r			}\r		}\r	  }\r}\r  \rfunction btnAnadirOnClick() {\r	/* Abrir una ventana modal con una llamada a la\r	lp \"LPMantenimientoComisionesClientes\" con acción \"añadir\" \r	  Recibir una arreglo de arreglos de datos para añadir\r	  las líneas nuevas que vengan a la lista \"lstClientes\" */\r\r	set(\"formulario.presionoModificar\", \"false\");\r	var opcionMenu = get(\"formulario.opcionMenu\");\r	var deshabilitoCombosZonificacion = get(\"formulario.deshabilitoCombosZonificacion\");\r  \r	var obj = new Object();\r	obj.opcionMenu = opcionMenu;\r	obj.deshabilitoCombosZonificacion = deshabilitoCombosZonificacion;\r    \r	var whnd = mostrarModalSICC('LPMantenimientoComisionesClientes','anadir',obj);\r	if(whnd!=null){\r		agregarFila(whnd);   \r	}\r}\r\rfunction btnModificarOnClick() {\r	/* -> El usuario debe haber seleccionado un registro de la\r	lista \"lstClientes\", en caso contrario mostrar un mensaje genérico\r	que diga al usuario que debe seleccionar un registro \r\r	-> Abrir una ventana modal con una llamada a la lp\r	\"LPMantenimientoComisionesClientes\" con acción \"modificar\" \r	-> Recuperar un arreglo de datos devuelto por la ventana modal \r	-> Actualizar el registro seleccionado con los datos recuperados */\r	\r	if (listado1.numSelecc()== 0) {\r		GestionarMensaje('1021',null,null,null);\r		return false;\r    }\r\r	var fila = listado1.filaSelecc;\r	set(\"formulario.filaSeleccionadaModificar\", fila);\r	set(\"formulario.presionoModificar\", \"true\");\r\r	var filaDatos = listado1.datos[fila];\r\r		var oidTipoCliente = filaDatos[0].toString();\r	var topeMaximo = filaDatos[2].toString();\r	var topeMinimo = filaDatos[3].toString();\r	var fechaDesde = filaDatos[4].toString();\r	var fechaHasta = filaDatos[5].toString();\r	var oidSubgerencia = filaDatos[12].toString();\r	var oidRegion = filaDatos[13].toString();\r	var oidZona = filaDatos[14].toString();\r	var oidSeccion = filaDatos[15].toString();\r	var oidTerritorio = filaDatos[16].toString();\r\r	var canal = get(\"formulario.varOidCanal\");\r	var marca = get(\"formulario.varOidMarca\");\r\r	var opcionMenu = get(\"formulario.opcionMenu\");\r	var deshabilitoCombosZonificacion = get(\"formulario.deshabilitoCombosZonificacion\");\r	var deshabilitoTodoMenosTopes = get(\"formulario.deshabilitoTodoMenosTopes\");\r\r	var obj = new Object();\r	obj.varOidCanal = canal;\r	obj.varOidMarca = marca;\r	obj.oidTipoCliente = oidTipoCliente;\r	obj.topeMaximo = topeMaximo;\r	obj.topeMinimo = topeMinimo;\r	obj.fechaDesde = fechaDesde;\r	obj.fechaHasta = fechaHasta;\r	obj.oidSubgerencia = oidSubgerencia;\r	obj.oidRegion = oidRegion;\r	obj.oidZona = oidZona;\r	obj.oidSeccion = oidSeccion;\r	obj.oidTerritorio = oidTerritorio;\r	obj.opcionMenu = opcionMenu;\r	obj.deshabilitoCombosZonificacion = deshabilitoCombosZonificacion;\r	obj.deshabilitoTodoMenosTopes = deshabilitoTodoMenosTopes;\r		\r	var whnd = mostrarModalSICC('LPMantenimientoComisionesClientes','modificar',obj);\r	if(whnd!=null){\r		agregarFila(whnd);   \r	}\r}\r\rfunction btnEliminarOnClick() {\r	if (listado1.numSelecc()== 0) {\r		GestionarMensaje('1021',null,null,null);\r		return false;\r    }\r\r	listado1.eliminarSelecc();\r}\r\rfunction onClickPestanya(valor) {      \r	var estadoVentana = get(\"formulario.estadoVentana\");\r\r	if(valor==\"DatosGenerales\") {\r		set(\"formulario.idPestanyaDest\", \"1\");\r	}\r	else if(valor==\"Productos\") {\r		set(\"formulario.idPestanyaDest\", \"2\");\r	}\r	else if(valor==\"DatosCalculo\") {\r		set(\"formulario.idPestanyaDest\", \"4\");\r	}\r\r	var valoresLista = listado1.datos;    \r\r	if(valoresLista==\"\") {\r		set(\"formulario.conectorAction\", \"LPMantenimientoComisionesClientes\");\r		set(\"formulario.estadoVentana\", estadoVentana);\r		set(\"formulario.accion\", \"almacenar\");\r		set(\"formulario.datosDeLista\", \"null\");\r  	    set(\"formulario.titulo\", get(\"formulario.titulo\"));\r		set(\"formulario.oidTipoPlantilla\", get(\"formulario.oidTipoPlantilla\"));\r		enviaSICC(\"formulario\"); 		\r	}\r	else {\r		var datosDeLista = \"[\";\r\r	 /* Posiciones de 0 a 16:\r	  - 0: oid tipo cliente\r	  - 1: desc tipo cliente\r	  - 2: tope maximo\r	  - 3: tope minimo\r	  - 4: fecha desde\r	  - 5: fecha hasta\r	  - 6: pais\r	  - 7: desc subgerencia ventas\r	  - 8: desc region\r	  - 9: desc zona \r	  - 10: desc seccion\r	  - 11: desc territorio\r	  - 12: oid subgerencia\r	  - 13: oid region\r	  - 14: oid zona\r	  - 15: oid seccion\r	  - 16: oid territorio */\r\r		for(var i=0; i<valoresLista.length; i++) {\r			var fila = new Array();\r\r						var topeMaximo = valoresLista[i][2];\r			if(topeMaximo==\"\") topeMaximo = \" \";\r			fila[0] = topeMaximo;\r\r						var topeMinimo = valoresLista[i][3];\r			if(topeMinimo==\"\") topeMinimo = \" \";\r			fila[1] = topeMinimo;		\r			\r						var fechaDesde = valoresLista[i][4];\r			if(fechaDesde==\"\") fechaDesde= \" \";\r			fila[2] = fechaDesde;\r\r						var fechaHasta = valoresLista[i][5];\r			if(fechaHasta == \"\") fechaHasta = \" \";\r			fila[3] = fechaHasta;\r\r						var oidTipo = valoresLista[i][0];\r			if(oidTipo==\"\") oidTipo = \" \";\r			fila[4] = oidTipo;\r\r						var oidSubgerencia = valoresLista[i][12];\r			if(oidSubgerencia==\"\") oidSubgerencia = \" \";\r			fila[5] = oidSubgerencia;\r\r						var oidRegion = valoresLista[i][13];\r			if(oidRegion==\"\") oidRegion = \" \";\r			fila[6] = oidRegion;\r\r						var oidZona = valoresLista[i][14];\r			if(oidZona==\"\") oidZona = \" \";\r			fila[7] = oidZona;\r\r						var oidSeccion = valoresLista[i][15];\r			if(oidSeccion==\"\") oidSeccion = \" \";\r			fila[8] = oidSeccion;\r\r						var oidTerritorio = valoresLista[i][16];\r			if(oidTerritorio==\"\") oidTerritorio = \" \";\r			fila[9] = oidTerritorio;\r\r						fila[10] = i + 1;\r\r						var descTipoCliente = valoresLista[i][1];\r			if(descTipoCliente==\"\") descTipoCliente = \" \";\r			fila[11] = descTipoCliente;\r\r						var descSubgerencia = valoresLista[i][7];\r			if(descSubgerencia==\"\") descSubgerencia = \" \";\r			fila[12] = descSubgerencia;\r\r						var descRegion = valoresLista[i][8];\r			if(descRegion==\"\") descRegion = \" \";\r			fila[13] = descRegion;\r\r						var descZona = valoresLista[i][9];\r			if(descZona==\"\") descZona = \" \";\r			fila[14] = descZona;\r\r						var descSeccion = valoresLista[i][10];\r			if(descSeccion==\"\") descSeccion = \" \";\r			fila[15] = descSeccion;\r\r						var descTerritorio = valoresLista[i][11];\r			if(descTerritorio==\"\") descTerritorio = \" \";\r			fila[16] = descTerritorio;\r\r			if(i==0) {\r				datosDeLista = datosDeLista + fila;	\r			}\r			else {\r				datosDeLista = datosDeLista + \"|\" + fila;	\r			}\r		}\r\r		datosDeLista = datosDeLista + \"]\"\r\r		set(\"formulario.conectorAction\", \"LPMantenimientoComisionesClientes\");\r		set(\"formulario.estadoVentana\", estadoVentana);\r		set(\"formulario.accion\", \"almacenar\");\r		set(\"formulario.datosDeLista\", datosDeLista);\r  	    set(\"formulario.titulo\", get(\"formulario.titulo\"));\r		set(\"formulario.oidTipoPlantilla\", get(\"formulario.oidTipoPlantilla\"));\r		enviaSICC(\"formulario\"); \r	}\r}\r\rfunction onClickGuardar() {\r	var valoresLista = listado1.datos;    \r	var oidTipoPlantilla = get(\"formulario.oidTipoPlantilla\");\r	var datosPestanyaDatosCalculo = get(\"formulario.datosPestanyaDatosCalculo\");\r	\r	if(valoresLista==\"\") {\r		var impedirGuardarSinClientes = get(\"formulario.impedirGuardarSinClientes\");\r		if(impedirGuardarSinClientes==\"true\") {\r			GestionarMensaje('UICOM0010',null,null,null);\r			return;\r		}\r	}	\r\r	if(valoresLista==\"\") {\r		if((datosPestanyaDatosCalculo==\"false\") && (oidTipoPlantilla==\"\")) {\r			GestionarMensaje('1544',null,null,null)\r			return false;\r		}\r\r		if(datosPestanyaDatosCalculo==\"false\") {\r			var resp = GestionarMensaje('1543',null,null,null);\r\r			if(resp==true) {\r				eval(\"formulario\").oculto= \"S\";\r				set(\"formulario.conectorAction\", \"LPMantenimientoComisionesClientes\");\r				set(\"formulario.accion\", \"guardar\");\r				set(\"formulario.datosDeLista\", \"null\");\r				enviaSICC(\"formulario\"); \r			}\r			else {\r				return;\r			}\r		}\r		else {\r			eval(\"formulario\").oculto= \"S\";\r			set(\"formulario.conectorAction\", \"LPMantenimientoComisionesClientes\");\r			set(\"formulario.accion\", \"guardar\");\r			set(\"formulario.datosDeLista\", \"null\");\r			enviaSICC(\"formulario\"); 	\r		}		 \r	}\r	else {\r		var datosDeLista = \"[\";\r\r		for(var i=0; i<valoresLista.length; i++) {\r			var fila = new Array();\r\r						var topeMaximo = valoresLista[i][2];\r			if(topeMaximo==\"\") topeMaximo = \" \";\r			fila[0] = topeMaximo;\r\r						var topeMinimo = valoresLista[i][3];\r			if(topeMinimo==\"\") topeMinimo = \" \";\r			fila[1] = topeMinimo;		\r			\r						var fechaDesde = valoresLista[i][4];\r			if(fechaDesde==\"\") fechaDesde= \" \";\r			fila[2] = fechaDesde;\r\r						var fechaHasta = valoresLista[i][5];\r			if(fechaHasta == \"\") fechaHasta = \" \";\r			fila[3] = fechaHasta;\r\r						var oidTipo = valoresLista[i][0];\r			if(oidTipo==\"\") oidTipo = \" \";\r			fila[4] = oidTipo;\r\r						var oidSubgerencia = valoresLista[i][12];\r			if(oidSubgerencia==\"\") oidSubgerencia = \" \";\r			fila[5] = oidSubgerencia;\r\r						var oidRegion = valoresLista[i][13];\r			if(oidRegion==\"\") oidRegion = \" \";\r			fila[6] = oidRegion;\r\r						var oidZona = valoresLista[i][14];\r			if(oidZona==\"\") oidZona = \" \";\r			fila[7] = oidZona;\r\r						var oidSeccion = valoresLista[i][15];\r			if(oidSeccion==\"\") oidSeccion = \" \";\r			fila[8] = oidSeccion;\r\r						var oidTerritorio = valoresLista[i][16];\r			if(oidTerritorio==\"\") oidTerritorio = \" \";\r			fila[9] = oidTerritorio;\r\r						fila[10] = i + 1;\r\r						var descTipoCliente = valoresLista[i][1];\r			if(descTipoCliente==\"\") descTipoCliente = \" \";\r			fila[11] = descTipoCliente;\r\r						var descSubgerencia = valoresLista[i][7];\r			if(descSubgerencia==\"\") descSubgerencia = \" \";\r			fila[12] = descSubgerencia;\r\r						var descRegion = valoresLista[i][8];\r			if(descRegion==\"\") descRegion = \" \";\r			fila[13] = descRegion;\r\r						var descZona = valoresLista[i][9];\r			if(descZona==\"\") descZona = \" \";\r			fila[14] = descZona;\r\r						var descSeccion = valoresLista[i][10];\r			if(descSeccion==\"\") descSeccion = \" \";\r			fila[15] = descSeccion;\r\r						var descTerritorio = valoresLista[i][11];\r			if(descTerritorio==\"\") descTerritorio = \" \";\r			fila[16] = descTerritorio;\r\r			if(i==0) {\r				datosDeLista = datosDeLista + fila;	\r			}\r			else {\r				datosDeLista = datosDeLista + \"|\" + fila;	\r			}\r		}\r\r		datosDeLista = datosDeLista + \"]\"\r\r		if((datosPestanyaDatosCalculo==\"false\") && (oidTipoPlantilla==\"\")) {\r			GestionarMensaje('1544',null,null,null)\r			return false;\r		}\r\r		if(datosPestanyaDatosCalculo==\"false\") {\r			var resp = GestionarMensaje('1543',null,null,null);\r\r			if(resp==true) {\r				eval(\"formulario\").oculto= \"S\";	\r				set(\"formulario.conectorAction\", \"LPMantenimientoComisionesClientes\");\r				set(\"formulario.accion\", \"guardar\");\r				set(\"formulario.datosDeLista\", datosDeLista);\r				enviaSICC(\"formulario\"); \r			}\r			else {\r				return;\r			}\r		}\r		else {\r			eval(\"formulario\").oculto= \"S\";	\r			set(\"formulario.conectorAction\", \"LPMantenimientoComisionesClientes\");\r			set(\"formulario.accion\", \"guardar\");\r			set(\"formulario.datosDeLista\", datosDeLista);\r			enviaSICC(\"formulario\"); \r		}		 \r	}\r}\r\rfunction fGuardar() {\r	onClickGuardar();\r}\r\rfunction poneManito(nombre) {           \r	var nombre = document.getElementById(nombre);\r	nombre.style.cursor = \"hand\";\r}   \r\rfunction fBorrar() {\r	eliminarOnClick();\r}\r\rfunction eliminarOnClick() {\r	if (listado1.numSelecc()== 0) {\r		GestionarMensaje('1021',null,null,null);\r		return false;\r    }\r\r	listado1.eliminarSelecc();\r	focoBotonAnadir();\r}\r\rfunction reInicio() {\r	focoBotonAnadir();\r}\r\rfunction fVolver() {\r						  				  			\r	window.close();\r}\r\r \r"));
      ((Element)v.get(5)).appendChild((Text)v.get(6));

      /* Termina nodo Texto:6   */
      /* Termina nodo:5   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(7)).setAttribute("nombre","formulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","estadoVentana" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","oidTipoPlantilla" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","titulo" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","accion" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","varPais" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","varIdioma" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","idPestanyaDest" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","valoresLista" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","datosDeLista" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","descPais" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","varOidCanal" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","varOidMarca" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(23)).setAttribute("nombre","oidTipoCliente" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","topeMaximo" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","topeMinimo" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","fechaDesde" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","fechaHasta" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","oidSubgerencia" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","oidRegion" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","oidZona" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","oidSeccion" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","oidTerritorio" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","filaSeleccionadaModificar" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","presionoModificar" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","datosPestanyaClientes" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","datosPestanyaDatosCalculo" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","deshabilitoCombosZonificacion" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","deshabilitoTodoMenosTopes" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","impedirGuardarSinClientes" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 7   */
      v.add(doc.createElement("table"));
      ((Element)v.get(41)).setAttribute("width","100%" );
      ((Element)v.get(41)).setAttribute("height","100%" );
      ((Element)v.get(41)).setAttribute("border","0" );
      ((Element)v.get(41)).setAttribute("align","center" );
      ((Element)v.get(41)).setAttribute("cellpadding","0" );
      ((Element)v.get(41)).setAttribute("cellspacing","0" );
      ((Element)v.get(41)).setAttribute("class","menu4" );
      ((Element)v.get(7)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).setAttribute("width","12" );
      ((Element)v.get(43)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(43)).setAttribute("class","menu5texto" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(44)).setAttribute("src","b.gif" );
      ((Element)v.get(44)).setAttribute("width","12" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(44)).setAttribute("height","30" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */
      /* Termina nodo:43   */

      /* Empieza nodo:45 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(45)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(45)).setAttribute("class","menu5texto" );
      ((Element)v.get(42)).appendChild((Element)v.get(45));

      /* Elemento padre:45 / Elemento actual: 46   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(45)).appendChild((Text)v.get(46));

      /* Termina nodo Texto:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:47 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(47)).setAttribute("width","10" );
      ((Element)v.get(47)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(47)).setAttribute("class","menu5texto" );
      ((Element)v.get(42)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(48)).setAttribute("src","b.gif" );
      ((Element)v.get(48)).setAttribute("width","10" );
      ((Element)v.get(48)).setAttribute("height","8" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:49 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(49)).setAttribute("width","92" );
      ((Element)v.get(49)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(49)).setAttribute("class","menu5texto" );
      ((Element)v.get(42)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("table"));
      ((Element)v.get(50)).setAttribute("width","75" );
      ((Element)v.get(50)).setAttribute("border","1" );
      ((Element)v.get(50)).setAttribute("align","center" );
      ((Element)v.get(50)).setAttribute("cellpadding","1" );
      ((Element)v.get(50)).setAttribute("cellspacing","0" );
      ((Element)v.get(50)).setAttribute("ID","DatosGenerales" );
      ((Element)v.get(50)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(50)).setAttribute("onclick","onClickPestanya('DatosGenerales');" );
      ((Element)v.get(50)).setAttribute("onmouseover","poneManito('DatosGenerales');" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(51)).setAttribute("align","center" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(53)).setAttribute("nombre","lblDGC" );
      ((Element)v.get(53)).setAttribute("alto","13" );
      ((Element)v.get(53)).setAttribute("filas","1" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(53)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(53)).setAttribute("cod","00543" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */
      /* Termina nodo:51   */
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:54 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).setAttribute("width","10" );
      ((Element)v.get(54)).setAttribute("class","menu5texto" );
      ((Element)v.get(42)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(55)).setAttribute("src","b.gif" );
      ((Element)v.get(55)).setAttribute("width","10" );
      ((Element)v.get(55)).setAttribute("height","8" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:54   */

      /* Empieza nodo:56 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).setAttribute("width","20" );
      ((Element)v.get(56)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(56)).setAttribute("class","menu5texto" );
      ((Element)v.get(42)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("table"));
      ((Element)v.get(57)).setAttribute("width","75" );
      ((Element)v.get(57)).setAttribute("border","1" );
      ((Element)v.get(57)).setAttribute("align","center" );
      ((Element)v.get(57)).setAttribute("cellpadding","1" );
      ((Element)v.get(57)).setAttribute("cellspacing","0" );
      ((Element)v.get(57)).setAttribute("ID","Productos" );
      ((Element)v.get(57)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(57)).setAttribute("onclick","onClickPestanya('Productos');" );
      ((Element)v.get(57)).setAttribute("onmouseover","poneManito('Productos');" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(58)).setAttribute("align","center" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(60)).setAttribute("nombre","lblProductos" );
      ((Element)v.get(60)).setAttribute("alto","13" );
      ((Element)v.get(60)).setAttribute("filas","1" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(60)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(60)).setAttribute("cod","0094" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */
      /* Termina nodo:58   */
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:61 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).setAttribute("width","10" );
      ((Element)v.get(61)).setAttribute("class","menu5texto" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(42)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(62)).setAttribute("src","b.gif" );
      ((Element)v.get(62)).setAttribute("width","10" );
      ((Element)v.get(62)).setAttribute("height","8" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:63 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).setAttribute("width","20" );
      ((Element)v.get(63)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(63)).setAttribute("class","menu5texto" );
      ((Element)v.get(42)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("table"));
      ((Element)v.get(64)).setAttribute("width","75" );
      ((Element)v.get(64)).setAttribute("border","1" );
      ((Element)v.get(64)).setAttribute("align","center" );
      ((Element)v.get(64)).setAttribute("cellpadding","1" );
      ((Element)v.get(64)).setAttribute("cellspacing","0" );
      ((Element)v.get(64)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(64)).setAttribute("bgcolor","#496A9A" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(65)).setAttribute("align","center" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(67)).setAttribute("nombre","lblClientes" );
      ((Element)v.get(67)).setAttribute("alto","13" );
      ((Element)v.get(67)).setAttribute("filas","1" );
      ((Element)v.get(67)).setAttribute("valor","" );
      ((Element)v.get(67)).setAttribute("id","menu5textoblanca" );
      ((Element)v.get(67)).setAttribute("cod","0026" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:65   */
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:68 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).setAttribute("width","10" );
      ((Element)v.get(68)).setAttribute("class","menu5texto" );
      ((Element)v.get(42)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(69)).setAttribute("src","b.gif" );
      ((Element)v.get(69)).setAttribute("width","10" );
      ((Element)v.get(69)).setAttribute("height","8" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */

      /* Empieza nodo:70 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).setAttribute("width","20" );
      ((Element)v.get(70)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(70)).setAttribute("class","menu5texto" );
      ((Element)v.get(42)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("table"));
      ((Element)v.get(71)).setAttribute("width","75" );
      ((Element)v.get(71)).setAttribute("border","1" );
      ((Element)v.get(71)).setAttribute("align","center" );
      ((Element)v.get(71)).setAttribute("cellpadding","1" );
      ((Element)v.get(71)).setAttribute("cellspacing","0" );
      ((Element)v.get(71)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(71)).setAttribute("ID","DatosCalculo" );
      ((Element)v.get(71)).setAttribute("onclick","onClickPestanya('DatosCalculo');" );
      ((Element)v.get(71)).setAttribute("onmouseover","poneManito('DatosCalculo');" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(72)).setAttribute("align","center" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(74)).setAttribute("nombre","lblDatosC" );
      ((Element)v.get(74)).setAttribute("alto","13" );
      ((Element)v.get(74)).setAttribute("filas","1" );
      ((Element)v.get(74)).setAttribute("valor","" );
      ((Element)v.get(74)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(74)).setAttribute("cod","00544" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */
      /* Termina nodo:72   */
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:75 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).setAttribute("width","16" );
      ((Element)v.get(75)).setAttribute("class","menu5texto" );
      ((Element)v.get(42)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(76)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).setAttribute("width","12" );
      ((Element)v.get(76)).setAttribute("height","8" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */
      /* Termina nodo:42   */
      /* Termina nodo:41   */

      /* Empieza nodo:77 / Elemento padre: 7   */
      v.add(doc.createElement("table"));
      ((Element)v.get(77)).setAttribute("width","100%" );
      ((Element)v.get(77)).setAttribute("border","0" );
      ((Element)v.get(77)).setAttribute("cellspacing","0" );
      ((Element)v.get(77)).setAttribute("cellpadding","0" );
      ((Element)v.get(7)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).setAttribute("width","100%" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(80)).setAttribute("src","b.gif" );
      ((Element)v.get(80)).setAttribute("width","424" );
      ((Element)v.get(80)).setAttribute("height","8" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:81 / Elemento padre: 7   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(81)).setAttribute("nombre","listado1" );
      ((Element)v.get(81)).setAttribute("ancho","400" );
      ((Element)v.get(81)).setAttribute("alto","317" );
      ((Element)v.get(81)).setAttribute("x","12" );
      ((Element)v.get(81)).setAttribute("y","35" );
      ((Element)v.get(81)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(81)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(7)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(82)).setAttribute("precarga","S" );
      ((Element)v.get(82)).setAttribute("conROver","S" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(83)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(83)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(83)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(83)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */

      /* Empieza nodo:84 / Elemento padre: 82   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(84)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(84)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(84)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(84)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(82)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */

      /* Empieza nodo:85 / Elemento padre: 82   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(85)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(85)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(82)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:82   */

      /* Empieza nodo:86 / Elemento padre: 81   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(81)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(87)).setAttribute("borde","1" );
      ((Element)v.get(87)).setAttribute("horizDatos","1" );
      ((Element)v.get(87)).setAttribute("horizCabecera","1" );
      ((Element)v.get(87)).setAttribute("vertical","0" );
      ((Element)v.get(87)).setAttribute("horizTitulo","1" );
      ((Element)v.get(87)).setAttribute("horizBase","1" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */

      /* Empieza nodo:88 / Elemento padre: 86   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(88)).setAttribute("borde","#999999" );
      ((Element)v.get(88)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(88)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(88)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(88)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(88)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(88)).setAttribute("horizBase","#999999" );
      ((Element)v.get(86)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:86   */

      /* Empieza nodo:89 / Elemento padre: 81   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(89)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(89)).setAttribute("alto","22" );
      ((Element)v.get(89)).setAttribute("imgFondo","" );
      ((Element)v.get(89)).setAttribute("cod","0026" );
      ((Element)v.get(89)).setAttribute("ID","datosTitle" );
      ((Element)v.get(81)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */

      /* Empieza nodo:90 / Elemento padre: 81   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(90)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(90)).setAttribute("alto","22" );
      ((Element)v.get(90)).setAttribute("imgFondo","" );
      ((Element)v.get(81)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */

      /* Empieza nodo:91 / Elemento padre: 81   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(91)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(91)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(91)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(91)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(91)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(91)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(81)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(92)).setAttribute("ancho","100" );
      ((Element)v.get(92)).setAttribute("minimizable","S" );
      ((Element)v.get(92)).setAttribute("minimizada","N" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */

      /* Empieza nodo:93 / Elemento padre: 91   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(93)).setAttribute("ancho","100" );
      ((Element)v.get(93)).setAttribute("minimizable","S" );
      ((Element)v.get(93)).setAttribute("minimizada","N" );
      ((Element)v.get(91)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */

      /* Empieza nodo:94 / Elemento padre: 91   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(94)).setAttribute("ancho","100" );
      ((Element)v.get(94)).setAttribute("minimizable","S" );
      ((Element)v.get(94)).setAttribute("minimizada","N" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(91)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */

      /* Empieza nodo:95 / Elemento padre: 91   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(95)).setAttribute("ancho","150" );
      ((Element)v.get(95)).setAttribute("minimizable","S" );
      ((Element)v.get(95)).setAttribute("minimizada","N" );
      ((Element)v.get(91)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */

      /* Empieza nodo:96 / Elemento padre: 91   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(96)).setAttribute("ancho","150" );
      ((Element)v.get(96)).setAttribute("minimizable","S" );
      ((Element)v.get(96)).setAttribute("minimizada","N" );
      ((Element)v.get(91)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */

      /* Empieza nodo:97 / Elemento padre: 91   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(97)).setAttribute("ancho","100" );
      ((Element)v.get(97)).setAttribute("minimizable","S" );
      ((Element)v.get(97)).setAttribute("minimizada","N" );
      ((Element)v.get(91)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */

      /* Empieza nodo:98 / Elemento padre: 91   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(98)).setAttribute("ancho","150" );
      ((Element)v.get(98)).setAttribute("minimizable","S" );
      ((Element)v.get(98)).setAttribute("minimizada","N" );
      ((Element)v.get(91)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */

      /* Empieza nodo:99 / Elemento padre: 91   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(99)).setAttribute("ancho","100" );
      ((Element)v.get(99)).setAttribute("minimizable","S" );
      ((Element)v.get(99)).setAttribute("minimizada","N" );
      ((Element)v.get(91)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */

      /* Empieza nodo:100 / Elemento padre: 91   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(100)).setAttribute("ancho","100" );
      ((Element)v.get(100)).setAttribute("minimizable","S" );
      ((Element)v.get(100)).setAttribute("minimizada","N" );
      ((Element)v.get(91)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */

      /* Empieza nodo:101 / Elemento padre: 91   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(101)).setAttribute("ancho","100" );
      ((Element)v.get(101)).setAttribute("minimizable","S" );
      ((Element)v.get(101)).setAttribute("minimizada","N" );
      ((Element)v.get(91)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */

      /* Empieza nodo:102 / Elemento padre: 91   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(102)).setAttribute("ancho","100" );
      ((Element)v.get(102)).setAttribute("minimizable","S" );
      ((Element)v.get(102)).setAttribute("minimizada","N" );
      ((Element)v.get(91)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */

      /* Empieza nodo:103 / Elemento padre: 91   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(103)).setAttribute("ancho","100" );
      ((Element)v.get(103)).setAttribute("minimizable","S" );
      ((Element)v.get(103)).setAttribute("minimizada","N" );
      ((Element)v.get(103)).setAttribute("oculta","S" );
      ((Element)v.get(91)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */

      /* Empieza nodo:104 / Elemento padre: 91   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(104)).setAttribute("ancho","100" );
      ((Element)v.get(104)).setAttribute("minimizable","S" );
      ((Element)v.get(104)).setAttribute("minimizada","N" );
      ((Element)v.get(104)).setAttribute("oculta","S" );
      ((Element)v.get(91)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */

      /* Empieza nodo:105 / Elemento padre: 91   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(105)).setAttribute("ancho","100" );
      ((Element)v.get(105)).setAttribute("minimizable","S" );
      ((Element)v.get(105)).setAttribute("minimizada","N" );
      ((Element)v.get(105)).setAttribute("oculta","S" );
      ((Element)v.get(91)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */

      /* Empieza nodo:106 / Elemento padre: 91   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(106)).setAttribute("ancho","100" );
      ((Element)v.get(106)).setAttribute("minimizable","S" );
      ((Element)v.get(106)).setAttribute("minimizada","N" );
      ((Element)v.get(106)).setAttribute("oculta","S" );
      ((Element)v.get(91)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */

      /* Empieza nodo:107 / Elemento padre: 91   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(107)).setAttribute("ancho","100" );
      ((Element)v.get(107)).setAttribute("minimizable","S" );
      ((Element)v.get(107)).setAttribute("minimizada","N" );
      ((Element)v.get(107)).setAttribute("oculta","S" );
      ((Element)v.get(91)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:91   */

      /* Empieza nodo:108 / Elemento padre: 81   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(108)).setAttribute("alto","20" );
      ((Element)v.get(108)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(108)).setAttribute("imgFondo","" );
      ((Element)v.get(108)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(81)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(109)).setAttribute("colFondo","" );
      ((Element)v.get(109)).setAttribute("ID","EstCab" );
      ((Element)v.get(109)).setAttribute("cod","393" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */

      /* Empieza nodo:110 / Elemento padre: 108   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(110)).setAttribute("colFondo","" );
      ((Element)v.get(110)).setAttribute("ID","EstCab" );
      ((Element)v.get(110)).setAttribute("cod","1724" );
      ((Element)v.get(108)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */

      /* Empieza nodo:111 / Elemento padre: 108   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(111)).setAttribute("colFondo","" );
      ((Element)v.get(111)).setAttribute("ID","EstCab" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(111)).setAttribute("cod","1725" );
      ((Element)v.get(108)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */

      /* Empieza nodo:112 / Elemento padre: 108   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(112)).setAttribute("colFondo","" );
      ((Element)v.get(112)).setAttribute("ID","EstCab" );
      ((Element)v.get(112)).setAttribute("cod","1726" );
      ((Element)v.get(108)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */

      /* Empieza nodo:113 / Elemento padre: 108   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(113)).setAttribute("colFondo","" );
      ((Element)v.get(113)).setAttribute("ID","EstCab" );
      ((Element)v.get(113)).setAttribute("cod","1727" );
      ((Element)v.get(108)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */

      /* Empieza nodo:114 / Elemento padre: 108   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(114)).setAttribute("colFondo","" );
      ((Element)v.get(114)).setAttribute("ID","EstCab" );
      ((Element)v.get(114)).setAttribute("cod","5" );
      ((Element)v.get(108)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */

      /* Empieza nodo:115 / Elemento padre: 108   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(115)).setAttribute("colFondo","" );
      ((Element)v.get(115)).setAttribute("ID","EstCab" );
      ((Element)v.get(115)).setAttribute("cod","124" );
      ((Element)v.get(108)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */

      /* Empieza nodo:116 / Elemento padre: 108   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(116)).setAttribute("colFondo","" );
      ((Element)v.get(116)).setAttribute("ID","EstCab" );
      ((Element)v.get(116)).setAttribute("cod","109" );
      ((Element)v.get(108)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */

      /* Empieza nodo:117 / Elemento padre: 108   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(117)).setAttribute("colFondo","" );
      ((Element)v.get(117)).setAttribute("ID","EstCab" );
      ((Element)v.get(117)).setAttribute("cod","143" );
      ((Element)v.get(108)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */

      /* Empieza nodo:118 / Elemento padre: 108   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(118)).setAttribute("colFondo","" );
      ((Element)v.get(118)).setAttribute("ID","EstCab" );
      ((Element)v.get(118)).setAttribute("cod","112" );
      ((Element)v.get(108)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */

      /* Empieza nodo:119 / Elemento padre: 108   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(119)).setAttribute("colFondo","" );
      ((Element)v.get(119)).setAttribute("ID","EstCab" );
      ((Element)v.get(119)).setAttribute("cod","126" );
      ((Element)v.get(108)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */

      /* Empieza nodo:120 / Elemento padre: 108   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(120)).setAttribute("colFondo","" );
      ((Element)v.get(120)).setAttribute("ID","EstCab" );
      ((Element)v.get(120)).setAttribute("cod","109" );
      ((Element)v.get(108)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */

      /* Empieza nodo:121 / Elemento padre: 108   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(121)).setAttribute("colFondo","" );
      ((Element)v.get(121)).setAttribute("ID","EstCab" );
      ((Element)v.get(121)).setAttribute("cod","143" );
      ((Element)v.get(108)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */

      /* Empieza nodo:122 / Elemento padre: 108   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(122)).setAttribute("colFondo","" );
      ((Element)v.get(122)).setAttribute("ID","EstCab" );
      ((Element)v.get(122)).setAttribute("cod","112" );
      ((Element)v.get(108)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */

      /* Empieza nodo:123 / Elemento padre: 108   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(123)).setAttribute("colFondo","" );
      ((Element)v.get(123)).setAttribute("ID","EstCab" );
      ((Element)v.get(123)).setAttribute("cod","126" );
      ((Element)v.get(108)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */

      /* Empieza nodo:124 / Elemento padre: 108   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(124)).setAttribute("colFondo","" );
      ((Element)v.get(124)).setAttribute("ID","EstCab" );
      ((Element)v.get(124)).setAttribute("cod","126" );
      ((Element)v.get(108)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:108   */

      /* Empieza nodo:125 / Elemento padre: 81   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(125)).setAttribute("alto","22" );
      ((Element)v.get(125)).setAttribute("accion","" );
      ((Element)v.get(125)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(125)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(125)).setAttribute("maxSel","1" );
      ((Element)v.get(125)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(125)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(125)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(125)).setAttribute("onLoad","" );
      ((Element)v.get(125)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(81)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(126)).setAttribute("tipo","texto" );
      ((Element)v.get(126)).setAttribute("ID","EstDat" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */

      /* Empieza nodo:127 / Elemento padre: 125   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(127)).setAttribute("tipo","texto" );
      ((Element)v.get(127)).setAttribute("ID","EstDat2" );
      ((Element)v.get(125)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */

      /* Empieza nodo:128 / Elemento padre: 125   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(128)).setAttribute("tipo","texto" );
      ((Element)v.get(128)).setAttribute("ID","EstDat" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(125)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */

      /* Empieza nodo:129 / Elemento padre: 125   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(129)).setAttribute("tipo","texto" );
      ((Element)v.get(129)).setAttribute("ID","EstDat2" );
      ((Element)v.get(125)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */

      /* Empieza nodo:130 / Elemento padre: 125   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(130)).setAttribute("tipo","texto" );
      ((Element)v.get(130)).setAttribute("ID","EstDat" );
      ((Element)v.get(125)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */

      /* Empieza nodo:131 / Elemento padre: 125   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(131)).setAttribute("tipo","texto" );
      ((Element)v.get(131)).setAttribute("ID","EstDat2" );
      ((Element)v.get(125)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */

      /* Empieza nodo:132 / Elemento padre: 125   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(132)).setAttribute("tipo","texto" );
      ((Element)v.get(132)).setAttribute("ID","EstDat" );
      ((Element)v.get(125)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */

      /* Empieza nodo:133 / Elemento padre: 125   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(133)).setAttribute("tipo","texto" );
      ((Element)v.get(133)).setAttribute("ID","EstDat2" );
      ((Element)v.get(125)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */

      /* Empieza nodo:134 / Elemento padre: 125   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(134)).setAttribute("tipo","texto" );
      ((Element)v.get(134)).setAttribute("ID","EstDat" );
      ((Element)v.get(125)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */

      /* Empieza nodo:135 / Elemento padre: 125   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(135)).setAttribute("tipo","texto" );
      ((Element)v.get(135)).setAttribute("ID","EstDat2" );
      ((Element)v.get(125)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */

      /* Empieza nodo:136 / Elemento padre: 125   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(136)).setAttribute("tipo","texto" );
      ((Element)v.get(136)).setAttribute("ID","EstDat" );
      ((Element)v.get(125)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */

      /* Empieza nodo:137 / Elemento padre: 125   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(137)).setAttribute("tipo","texto" );
      ((Element)v.get(137)).setAttribute("ID","EstDat2" );
      ((Element)v.get(125)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */

      /* Empieza nodo:138 / Elemento padre: 125   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(138)).setAttribute("tipo","texto" );
      ((Element)v.get(138)).setAttribute("ID","EstDat" );
      ((Element)v.get(125)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */

      /* Empieza nodo:139 / Elemento padre: 125   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(139)).setAttribute("tipo","texto" );
      ((Element)v.get(139)).setAttribute("ID","EstDat2" );
      ((Element)v.get(125)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */

      /* Empieza nodo:140 / Elemento padre: 125   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(140)).setAttribute("tipo","texto" );
      ((Element)v.get(140)).setAttribute("ID","EstDat" );
      ((Element)v.get(125)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */

      /* Empieza nodo:141 / Elemento padre: 125   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(141)).setAttribute("tipo","texto" );
      ((Element)v.get(141)).setAttribute("ID","EstDat2" );
      ((Element)v.get(125)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:125   */

      /* Empieza nodo:142 / Elemento padre: 81   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(81)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */

      /* Empieza nodo:143 / Elemento padre: 81   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(143)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(143)).setAttribute("ancho","400" );
      ((Element)v.get(143)).setAttribute("sep","$" );
      ((Element)v.get(143)).setAttribute("x","12" );
      ((Element)v.get(143)).setAttribute("class","botonera" );
      ((Element)v.get(143)).setAttribute("y","306" );
      ((Element)v.get(143)).setAttribute("control","|" );
      ((Element)v.get(143)).setAttribute("conector","" );
      ((Element)v.get(143)).setAttribute("rowset","" );
      ((Element)v.get(143)).setAttribute("cargainicial","N" );
      ((Element)v.get(81)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(144)).setAttribute("nombre","ret1" );
      ((Element)v.get(144)).setAttribute("x","37" );
      ((Element)v.get(144)).setAttribute("y","333" );
      ((Element)v.get(144)).setAttribute("ID","botonContenido" );
      ((Element)v.get(144)).setAttribute("img","retroceder_on" );
      ((Element)v.get(144)).setAttribute("tipo","0" );
      ((Element)v.get(144)).setAttribute("estado","false" );
      ((Element)v.get(144)).setAttribute("alt","" );
      ((Element)v.get(144)).setAttribute("codigo","" );
      ((Element)v.get(144)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */

      /* Empieza nodo:145 / Elemento padre: 143   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(145)).setAttribute("nombre","ava1" );
      ((Element)v.get(145)).setAttribute("x","52" );
      ((Element)v.get(145)).setAttribute("y","333" );
      ((Element)v.get(145)).setAttribute("ID","botonContenido" );
      ((Element)v.get(145)).setAttribute("img","avanzar_on" );
      ((Element)v.get(145)).setAttribute("tipo","0" );
      ((Element)v.get(145)).setAttribute("estado","false" );
      ((Element)v.get(145)).setAttribute("alt","" );
      ((Element)v.get(145)).setAttribute("codigo","" );
      ((Element)v.get(145)).setAttribute("accion","mipgndo.avanzar();" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(143)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:143   */
      /* Termina nodo:81   */

      /* Empieza nodo:146 / Elemento padre: 7   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(146)).setAttribute("nombre","primera1" );
      ((Element)v.get(146)).setAttribute("x","20" );
      ((Element)v.get(146)).setAttribute("y","333" );
      ((Element)v.get(146)).setAttribute("ID","botonContenido" );
      ((Element)v.get(146)).setAttribute("img","primera_on" );
      ((Element)v.get(146)).setAttribute("tipo","-2" );
      ((Element)v.get(146)).setAttribute("estado","false" );
      ((Element)v.get(146)).setAttribute("alt","" );
      ((Element)v.get(146)).setAttribute("codigo","" );
      ((Element)v.get(146)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(7)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */

      /* Empieza nodo:147 / Elemento padre: 7   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(147)).setAttribute("nombre","separa" );
      ((Element)v.get(147)).setAttribute("x","59" );
      ((Element)v.get(147)).setAttribute("y","329" );
      ((Element)v.get(147)).setAttribute("ID","botonContenido" );
      ((Element)v.get(147)).setAttribute("img","separa_base" );
      ((Element)v.get(147)).setAttribute("tipo","0" );
      ((Element)v.get(147)).setAttribute("estado","false" );
      ((Element)v.get(147)).setAttribute("alt","" );
      ((Element)v.get(147)).setAttribute("codigo","" );
      ((Element)v.get(147)).setAttribute("accion","" );
      ((Element)v.get(7)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */

      /* Empieza nodo:148 / Elemento padre: 7   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(148)).setAttribute("nombre","btnAnadir" );
      ((Element)v.get(148)).setAttribute("x","80" );
      ((Element)v.get(148)).setAttribute("y","330" );
      ((Element)v.get(148)).setAttribute("ID","botonContenido" );
      ((Element)v.get(148)).setAttribute("tipo","html" );
      ((Element)v.get(148)).setAttribute("estado","false" );
      ((Element)v.get(148)).setAttribute("cod","404" );
      ((Element)v.get(148)).setAttribute("accion","btnAnadirOnClick();" );
      ((Element)v.get(148)).setAttribute("ontab","focoBotonModificar();" );
      ((Element)v.get(148)).setAttribute("onshtab","focoBotonModificar();" );
      ((Element)v.get(7)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */

      /* Empieza nodo:149 / Elemento padre: 7   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(149)).setAttribute("nombre","btnModificar" );
      ((Element)v.get(149)).setAttribute("x","128" );
      ((Element)v.get(149)).setAttribute("y","330" );
      ((Element)v.get(149)).setAttribute("ID","botonContenido" );
      ((Element)v.get(149)).setAttribute("tipo","html" );
      ((Element)v.get(149)).setAttribute("estado","false" );
      ((Element)v.get(149)).setAttribute("cod","2" );
      ((Element)v.get(149)).setAttribute("accion","btnModificarOnClick();" );
      ((Element)v.get(149)).setAttribute("ontab","focoBotonAnadir();" );
      ((Element)v.get(149)).setAttribute("onshtab","focoBotonAnadir();" );
      ((Element)v.get(7)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */

      /* Empieza nodo:150 / Elemento padre: 7   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(150)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(150)).setAttribute("alto","12" );
      ((Element)v.get(150)).setAttribute("ancho","100%" );
      ((Element)v.get(150)).setAttribute("colorf","" );
      ((Element)v.get(150)).setAttribute("borde","0" );
      ((Element)v.get(150)).setAttribute("imagenf","" );
      ((Element)v.get(150)).setAttribute("repeat","" );
      ((Element)v.get(150)).setAttribute("padding","" );
      ((Element)v.get(150)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(150)).setAttribute("contravsb","" );
      ((Element)v.get(150)).setAttribute("x","0" );
      ((Element)v.get(150)).setAttribute("y","329" );
      ((Element)v.get(150)).setAttribute("zindex","" );
      ((Element)v.get(7)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:7   */


   }

}
