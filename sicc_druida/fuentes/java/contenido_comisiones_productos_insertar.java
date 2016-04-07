
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_comisiones_productos_insertar  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_comisiones_productos_insertar" );
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
      v.add(doc.createTextNode("\r \r\rfunction onLoadPag()   {  \r  configurarMenuSecundario(\"formulario\");        \r  DrdEnsanchaConMargenDcho('listado1',12);  \r  mostrarCapa();\r  eval(ON_RSZ);  \r}\r\rfunction mostrarCapa() {\r  document.all[\"Cplistado1\"].style.visibility='';\r  document.all[\"CpLin1listado1\"].style.visibility='';\r  document.all[\"CpLin2listado1\"].style.visibility='';\r  document.all[\"CpLin3listado1\"].style.visibility='';\r  document.all[\"CpLin4listado1\"].style.visibility='';\r  document.all[\"separaDiv\"].style.visibility='';\r  document.all[\"primera1Div\"].style.visibility='';\r  document.all[\"ret1Div\"].style.visibility='';\r  document.all[\"ava1Div\"].style.visibility='';\r\r  var opcionMenu = get(\"formulario.opcionMenu\");\r  if(opcionMenu==\"consultar\") {\r	document.all[\"btnIncluirDiv\"].style.visibility='hidden';\r	document.all[\"btnModificarDiv\"].style.visibility='hidden';\r	document.all[\"btnExcluirDiv\"].style.visibility='hidden';\r    btnProxy(4, '0');\r			btnProxy(3, '0');  \r  }  \r  else {\r	document.all[\"btnIncluirDiv\"].style.visibility='';\r	document.all[\"btnModificarDiv\"].style.visibility='';\r	document.all[\"btnExcluirDiv\"].style.visibility='';\r    btnProxy(4, '1');\r    focoBotonIncluir();\r  }\r\r    if (opcionMenu != \"insertar\") {\r	btnProxy(2,'1');\r  } else {\r	btnProxy(2,'0');\r  }\r}\r\rfunction focoBotonIncluir() {\r  focalizaBotonHTML_XY('btnIncluir');\r}\r\rfunction focoBotonExcluir() {\r  focalizaBotonHTML_XY('btnExcluir');\r}\r\rfunction poneManito(nombre) {           \r  var nombre = document.getElementById(nombre);\r  nombre.style.cursor = \"hand\";\r} \r\rfunction onClickPestanya(valor) {      \r	var opcionMenu = get(\"formulario.opcionMenu\");\r	var estadoVentana = get(\"formulario.estadoVentana\");\r\r	if(valor==\"DatosGenerales\") {\r		set(\"formulario.idPestanyaDest\", \"1\");\r	}\r	else if(valor==\"Clientes\") {\r		set(\"formulario.idPestanyaDest\", \"3\");\r	}\r	else if(valor==\"DatosCalculo\") {\r		set(\"formulario.idPestanyaDest\", \"4\");\r	}\r\r	var valoresLista = listado1.datos;    \r\r	if(valoresLista==\"\") {\r		set(\"formulario.conectorAction\", \"LPMantenimientoComisionesProductos\");\r		set(\"formulario.estadoVentana\", estadoVentana);\r		set(\"formulario.accion\", \"almacenar\");\r	    set(\"formulario.opcionMenu\", opcionMenu);\r		set(\"formulario.datosDeLista\", \"null\");\r  	    set(\"formulario.titulo\", get(\"formulario.titulo\"));\r		set(\"formulario.oidTipoPlantilla\", get(\"formulario.oidTipoPlantilla\"));\r		enviaSICC(\"formulario\"); 	\r	}\r	else {\r		var datosDeLista = \"[\";\r\r		for(var i=0; i<valoresLista.length; i++) {\r			var fila = new Array();\r\r						var oidTipoProducto = valoresLista[i][0];\r			if(oidTipoProducto==\"\") oidTipoProducto = \" \";\r			fila[0] = oidTipoProducto;\r\r						var tipoProducto = valoresLista[i][1];\r			if(tipoProducto==\"\") tipoProducto = \" \";\r			fila[1] = tipoProducto;		\r\r						var codigoProducto = valoresLista[i][2];\r			if(codigoProducto==\"\") codigoProducto= \" \";\r			fila[2] = codigoProducto;\r\r						var tipoOferta = valoresLista[i][3];\r			if(tipoOferta == \"\") tipoOferta = \" \";\r			fila[3] = tipoOferta;\r\r						var cicloVida = valoresLista[i][4];\r			if(cicloVida==\"\") cicloVida = \" \";\r			fila[4] = cicloVida;\r\r						var marca = valoresLista[i][5];\r			if(marca==\"\") marca = \" \";\r			fila[5] = marca;\r\r						var unidadNegocio = valoresLista[i][6];\r			if(unidadNegocio==\"\") unidadNegocio = \" \";\r			fila[6] = unidadNegocio;\r\r						var negocio = valoresLista[i][7];\r			if(negocio==\"\") negocio = \" \";\r			fila[7] = negocio;\r\r						var supergenerico = valoresLista[i][8];\r			if(supergenerico==\"\") supergenerico = \" \";\r			fila[8] = supergenerico;\r\r						var generico = valoresLista[i][9];\r			if(generico==\"\") generico = \" \";\r			fila[9] = generico;\r\r						var oidTipoOferta = valoresLista[i][10];\r			if(oidTipoOferta==\"\") oidTipoOferta = \" \";\r			fila[10] = oidTipoOferta;\r\r						var oidCicloVida = valoresLista[i][11];\r			if(oidCicloVida==\"\") oidCicloVida = \" \";\r			fila[11] = oidCicloVida;\r\r						var oidMarca = valoresLista[i][12];\r			if(oidMarca==\"\") oidMarca = \" \";\r			fila[12] = oidMarca;\r			\r						var oidUnidadNegocio = valoresLista[i][13];\r			if(oidUnidadNegocio==\"\") oidUnidadNegocio = \" \";\r			fila[13] = oidUnidadNegocio;\r\r						var oidNegocio = valoresLista[i][14];\r			if(oidNegocio==\"\") oidNegocio = \" \";\r			fila[14] = oidNegocio;\r\r						var oidSupergenerico = valoresLista[i][15];\r			if(oidSupergenerico==\"\") oidSupergenerico = \" \";\r			fila[15] = oidSupergenerico;\r			\r						var oidGenerico = valoresLista[i][16];\r			if(oidGenerico==\"\") oidGenerico = \" \";\r			fila[16] = oidGenerico;\r			\r						var oidTipoInsercion = valoresLista[i][17];\r			if(oidTipoInsercion==\"\") oidTipoInsercion = \" \";\r			fila[17] = oidTipoInsercion;\r			\r						var oidProducto = valoresLista[i][18];\r			if(oidProducto==\"\") oidProducto = \" \";\r			fila[18] = oidProducto;\r\r						fila[19] = i + 1;\r\r			if(i==0) {\r				datosDeLista = datosDeLista + fila;	\r			}\r			else {\r				datosDeLista = datosDeLista + \"|\" + fila;	\r			}\r		}\r\r		datosDeLista = datosDeLista + \"]\"\r\r		set(\"formulario.conectorAction\", \"LPMantenimientoComisionesProductos\");\r		set(\"formulario.estadoVentana\", estadoVentana);\r		set(\"formulario.accion\", \"almacenar\");\r	    set(\"formulario.opcionMenu\", opcionMenu);\r		set(\"formulario.datosDeLista\", datosDeLista);\r  	    set(\"formulario.titulo\", get(\"formulario.titulo\"));\r		set(\"formulario.oidTipoPlantilla\", get(\"formulario.oidTipoPlantilla\"));\r		enviaSICC(\"formulario\"); \r	}       \r}\r\rfunction fGuardar() {\r  onClickGuardar();\r}\r\rfunction onClickGuardar() {\r	var valoresLista = listado1.datos;    \r	var oidTipoPlantilla = get(\"formulario.oidTipoPlantilla\");\r	var datosClientes = get(\"formulario.datosPestanyaClientes\");\r	var datosPestanyaDatosCalculo = get(\"formulario.datosPestanyaDatosCalculo\");\r\r	if(valoresLista==\"\") {\r		if((datosPestanyaDatosCalculo==\"false\") && (oidTipoPlantilla==\"\")) {\r			GestionarMensaje('1544',null,null,null)\r			return false;\r		}\r\r		if((datosClientes==\"false\") || (datosPestanyaDatosCalculo==\"false\")) {\r			var resp = GestionarMensaje('1543',null,null,null);\r\r			if(resp==true) {\r				eval(\"formulario\").oculto= \"S\";\r				set(\"formulario.conectorAction\", \"LPMantenimientoComisionesProductos\");\r				set(\"formulario.accion\", \"guardar\");\r				set(\"formulario.datosDeLista\", \"null\");\r				enviaSICC(\"formulario\"); 	\r			}\r			else {\r				return;\r			}\r		}\r		else {\r			eval(\"formulario\").oculto= \"S\";\r			set(\"formulario.conectorAction\", \"LPMantenimientoComisionesProductos\");\r			set(\"formulario.accion\", \"guardar\");\r			set(\"formulario.datosDeLista\", \"null\");\r			enviaSICC(\"formulario\"); 	\r		}		 \r	}\r	else {\r		var datosDeLista = \"[\";\r\r		for(var i=0; i<valoresLista.length; i++) {\r			var fila = new Array();\r\r						var oidTipoProducto = valoresLista[i][0];\r			if(oidTipoProducto==\"\") oidTipoProducto = \" \";\r			fila[0] = oidTipoProducto;\r\r						var tipoProducto = valoresLista[i][1];\r			if(tipoProducto==\"\") tipoProducto = \" \";\r			fila[1] = tipoProducto;		\r\r						var codigoProducto = valoresLista[i][2];\r			if(codigoProducto==\"\") codigoProducto= \" \";\r			fila[2] = codigoProducto;\r\r						var tipoOferta = valoresLista[i][3];\r			if(tipoOferta == \"\") tipoOferta = \" \";\r			fila[3] = tipoOferta;\r\r						var cicloVida = valoresLista[i][4];\r			if(cicloVida==\"\") cicloVida = \" \";\r			fila[4] = cicloVida;\r\r						var marca = valoresLista[i][5];\r			if(marca==\"\") marca = \" \";\r			fila[5] = marca;\r\r						var unidadNegocio = valoresLista[i][6];\r			if(unidadNegocio==\"\") unidadNegocio = \" \";\r			fila[6] = unidadNegocio;\r\r						var negocio = valoresLista[i][7];\r			if(negocio==\"\") negocio = \" \";\r			fila[7] = negocio;\r\r						var supergenerico = valoresLista[i][8];\r			if(supergenerico==\"\") supergenerico = \" \";\r			fila[8] = supergenerico;\r\r						var generico = valoresLista[i][9];\r			if(generico==\"\") generico = \" \";\r			fila[9] = generico;\r\r						var oidTipoOferta = valoresLista[i][10];\r			if(oidTipoOferta==\"\") oidTipoOferta = \" \";\r			fila[10] = oidTipoOferta;\r\r						var oidCicloVida = valoresLista[i][11];\r			if(oidCicloVida==\"\") oidCicloVida = \" \";\r			fila[11] = oidCicloVida;\r\r						var oidMarca = valoresLista[i][12];\r			if(oidMarca==\"\") oidMarca = \" \";\r			fila[12] = oidMarca;\r			\r						var oidUnidadNegocio = valoresLista[i][13];\r			if(oidUnidadNegocio==\"\") oidUnidadNegocio = \" \";\r			fila[13] = oidUnidadNegocio;\r\r						var oidNegocio = valoresLista[i][14];\r			if(oidNegocio==\"\") oidNegocio = \" \";\r			fila[14] = oidNegocio;\r\r						var oidSupergenerico = valoresLista[i][15];\r			if(oidSupergenerico==\"\") oidSupergenerico = \" \";\r			fila[15] = oidSupergenerico;\r			\r						var oidGenerico = valoresLista[i][16];\r			if(oidGenerico==\"\") oidGenerico = \" \";\r			fila[16] = oidGenerico;\r			\r						var oidTipoInsercion = valoresLista[i][17];\r			if(oidTipoInsercion==\"\") oidTipoInsercion = \" \";\r			fila[17] = oidTipoInsercion;\r			\r						var oidProducto = valoresLista[i][18];\r			if(oidProducto==\"\") oidProducto = \" \";\r			fila[18] = oidProducto;\r\r						fila[19] = i + 1;\r\r			if(i==0) {\r				datosDeLista = datosDeLista + fila;	\r			}\r			else {\r				datosDeLista = datosDeLista + \"|\" + fila;	\r			}\r		}\r\r		datosDeLista = datosDeLista + \"]\"\r\r		if((datosPestanyaDatosCalculo==\"false\") && (oidTipoPlantilla==\"\")) {\r			GestionarMensaje('1544',null,null,null)\r			return false;\r		}\r\r		if((datosClientes==\"false\") || (datosPestanyaDatosCalculo==\"false\")) {\r			var resp = GestionarMensaje('1543',null,null,null);\r\r			if(resp==true) {\r				eval(\"formulario\").oculto= \"S\";\r				set(\"formulario.conectorAction\", \"LPMantenimientoComisionesProductos\");\r				set(\"formulario.accion\", \"guardar\");\r				set(\"formulario.datosDeLista\", datosDeLista);\r				enviaSICC(\"formulario\"); \r			}\r			else {\r				return;\r			}\r		}\r		else {\r			eval(\"formulario\").oculto= \"S\";\r			set(\"formulario.conectorAction\", \"LPMantenimientoComisionesProductos\");\r			set(\"formulario.accion\", \"guardar\");\r			set(\"formulario.datosDeLista\", datosDeLista);\r			enviaSICC(\"formulario\");  	\r		}		 \r	}    \r}\r\rfunction onClickAnadir() {  \r  var canal = get(\"formulario.varOidCanal\");\r  var marca = get(\"formulario.varOidMarca\");  \r  var opcionMenu = get(\"formulario.opcionMenu\");\r\r  set(\"formulario.filaSeleccionadaModificar\", \"\");\r  set(\"formulario.presionoModificar\", \"false\");\r  set(\"formulario.vieneModificar\", \"false\");\r  \r  var obj = new Object();\r  obj.varOidCanal = canal;\r  obj.varOidMarca = marca;\r  obj.descTipoProducto = \"incluir\";\r  obj.opcionMenu = opcionMenu;\r    \r  var whnd = mostrarModalSICC('LPMantenimientoComisionesProductos','Anadir',obj);\r  if(whnd!=null){\r    agregarFila(whnd);   \r  }\r}\r\rfunction onClickExcluir() {\r	/* El usuario ha debido seleccionar un registro de \"lstProductos\"\r	que sea una \"inclusión\" y que sea por \"jerarquía\" \r	Si es así entonces \r	Se abre una ventana emergente modal y en la nueva ventana se\r	invoca LPMantenimientoComisionesProductos con: \r	accion = \"Excluir\" \r	oidCanal = varOidCanal \r	oidMarca = varOidMarca \r\r	Cuando se cierre la ventana, esta retorna un arreglo JavaScript\r	para añadir una nueva línea a la lista \"lstProductos\" \r\r	Si no entonces \r	Mostrar mensaje de error con código \"UICOM0003\" \r	Fin Si */\r\r    listado1.actualizaDat();\r\r    if (listado1.numSelecc()== 0) {\r		GestionarMensaje('1021',null,null,null);\r		return false;\r    }\r\r	var fila = listado1.filaSelecc;\r	set(\"formulario.filaSeleccionadaModificar\", \"\");\r	set(\"formulario.presionoModificar\", \"false\");\r	set(\"formulario.vieneModificar\", \"false\");\r\r	var filaDatos = listado1.datos[fila];\r\r	var tipoProducto = filaDatos[0].toString();\r	var tipoInsercion = filaDatos[17].toString();\r\r		var lblDescMarcaProducto  = filaDatos[5].toString();\r    var lblDescUnidadNegocio = filaDatos[6].toString();\r    var lblDescNegocio = filaDatos[7].toString();  \r    var lblDescSupergenerico = filaDatos[8].toString();  \r    var lblDescGenerico = filaDatos[9].toString();  \r    var lblDescTipoOferta = filaDatos[3].toString();  \r    var lblDescCicloVida = filaDatos[4].toString();  \r\r		var oidMarcaTemp = filaDatos[12].toString();\r	var oidUNegocioTemp = filaDatos[13].toString();\r	var oidNegocioTemp = filaDatos[14].toString();\r	var oidSupergenericoTemp = filaDatos[15].toString();\r	var oidGenericoTemp = filaDatos[16].toString();\r	var oidTipoOfertaTemp = filaDatos[10].toString();\r	var oidCicloVidaTemp = filaDatos[11].toString();\r\r	if((tipoProducto==1) && (tipoInsercion==2)) {\r		var canal = get(\"formulario.varOidCanal\");\r	    var marca = get(\"formulario.varOidMarca\");  \r	    var opcionMenu = get(\"formulario.opcionMenu\");\r  \r		var obj = new Object();\r		obj.varOidCanal = canal;\r		obj.varOidMarca = marca;\r\r		obj.lblDescMarcaProducto = lblDescMarcaProducto;\r		obj.lblDescUnidadNegocio = lblDescUnidadNegocio;\r		obj.lblDescNegocio = lblDescNegocio;\r		obj.lblDescSupergenerico = lblDescSupergenerico;\r		obj.lblDescGenerico = lblDescGenerico;\r		obj.lblDescTipoOferta = lblDescTipoOferta;\r		obj.lblDescCicloVida = lblDescCicloVida;\r\r		obj.tipoInsercion = tipoInsercion;\r\r		obj.oidMarcaTemp = oidMarcaTemp;\r		obj.oidUNegocioTemp = oidUNegocioTemp;\r		obj.oidNegocioTemp = oidNegocioTemp;\r		obj.oidSupergenericoTemp = oidSupergenericoTemp;\r		obj.oidGenericoTemp = oidGenericoTemp;\r		obj.oidTipoOfertaTemp = oidTipoOfertaTemp;\r		obj.oidCicloVidaTemp = oidCicloVidaTemp;\r		obj.descTipoProducto = \"excluir\";\r\r	    obj.opcionMenu = opcionMenu;\r    \r		var whnd = mostrarModalSICC('LPMantenimientoComisionesProductos','excluir',obj);\r		if(whnd!=null){\r			agregarFila(whnd);   \r		}\r	}\r	else {\r		GestionarMensaje('1491',null,null,null);\r		return false;\r	}\r}\r\rfunction onClickModificar() {\r	listado1.actualizaDat();\r\r    if (listado1.numSelecc()== 0) {\r		GestionarMensaje('1021',null,null,null);\r		return false;\r    }\r\r	var canal = get(\"formulario.varOidCanal\");\r	var marca = get(\"formulario.varOidMarca\");  \r	var opcionMenu = get(\"formulario.opcionMenu\");\r\r	var fila = listado1.filaSelecc;\r	var filaDatos = listado1.datos[fila];\r\r	set(\"formulario.filaSeleccionadaModificar\", fila);\r	set(\"formulario.presionoModificar\", \"true\");\r	set(\"formulario.vieneModificar\", \"true\");\r	var vieneModificar = get(\"formulario.vieneModificar\");\r\r		var tipoProducto = filaDatos[0].toString();\r	var tipoInsercion = filaDatos[17].toString();\r		var lblDescMarcaProducto  = filaDatos[5].toString();\r	var lblDescUnidadNegocio = filaDatos[6].toString();\r	var lblDescNegocio = filaDatos[7].toString();  \r   	var lblDescSupergenerico = filaDatos[8].toString();  \r   	var lblDescGenerico = filaDatos[9].toString();  \r   	var lblDescTipoOferta = filaDatos[3].toString();  \r   	var lblDescCicloVida = filaDatos[4].toString();  \r	var lblCodigoProducto = filaDatos[2].toString();  \r		var oidMarcaTemp = filaDatos[12].toString();\r	var oidUNegocioTemp = filaDatos[13].toString();\r	var oidNegocioTemp = filaDatos[14].toString();\r	var oidSupergenericoTemp = filaDatos[15].toString();\r	var oidGenericoTemp = filaDatos[16].toString();\r	var oidTipoOfertaTemp = filaDatos[10].toString();\r	var oidCicloVidaTemp = filaDatos[11].toString();\r	var oidProductoTemp = filaDatos[18].toString();  \r\r	var obj = new Object();\r	obj.varOidCanal = canal;\r	obj.varOidMarca = marca;\r	obj.opcionMenu = opcionMenu;\r\r	obj.tipoProducto = tipoProducto;\r	obj.tipoInsercion = tipoInsercion;\r\r	obj.lblDescMarcaProducto = lblDescMarcaProducto;\r	obj.lblDescUnidadNegocio = lblDescUnidadNegocio;\r	obj.lblDescNegocio = lblDescNegocio;\r	obj.lblDescSupergenerico = lblDescSupergenerico;\r	obj.lblDescGenerico = lblDescGenerico;\r	obj.lblDescTipoOferta = lblDescTipoOferta;\r	obj.lblDescCicloVida = lblDescCicloVida;	\r	obj.lblCodigoProducto = lblCodigoProducto;	\r\r	obj.oidMarcaTemp = oidMarcaTemp;\r	obj.oidUNegocioTemp = oidUNegocioTemp;\r	obj.oidNegocioTemp = oidNegocioTemp;\r	obj.oidSupergenericoTemp = oidSupergenericoTemp;\r	obj.oidGenericoTemp = oidGenericoTemp;\r	obj.oidTipoOfertaTemp = oidTipoOfertaTemp;\r	obj.oidCicloVidaTemp = oidCicloVidaTemp;	\r	obj.oidProductoTemp = oidProductoTemp;	\r	obj.vieneModificar = vieneModificar;\r\r	if(tipoProducto==1) {\r		obj.descTipoProducto = \"incluir\";\r		obj.incluido = \"true\";\r	}\r	else {\r		obj.descTipoProducto = \"excluir\";\r		obj.incluido = \"false\";\r	}\r    \r	var whnd = mostrarModalSICC('LPMantenimientoComisionesProductos','modificar',obj);\r	if(whnd!=null){\r		agregarFila(whnd);   \r	}\r}\r\rfunction fBorrar() {\r	onClickEliminar();\r}\r\rfunction onClickEliminar() {\r	if (listado1.numSelecc()== 0) {\r		GestionarMensaje('1021',null,null,null);\r		return false;\r    }\r\r	listado1.eliminarSelecc();\r	focoBotonIncluir();\r}\r\rfunction agregarFila(nuevaFila) {\r  /* Posiciones de 0 a 18:\r	  - 0: oid tipo de producto\r	  - 1: descripcion tipo de producto\r	  - 2: codigo producto\r	  - 3: descripcion tipo oferta\r	  - 4: descripcion ciclo vida\r	  - 5: descripcion marca\r	  - 6: descripcion unidad negocio\r	  - 7: descripcion negocio\r	  - 8: descripcion supergenerico\r	  - 9: descripcion generico\r	  - 10: oid tipo oferta\r	  - 11: oid ciclo vida\r	  - 12: oid marca\r	  - 13: oid unidad negocio\r	  - 14: oid negocio\r	  - 15: oid supergenerico\r	  - 16: oid generico\r	  - 17: oid tipo insercion \r  	  - 18: oid producto*/\r\r	if(nuevaFila!=\"\") {\r		var unicaFila = nuevaFila[0];\r		var arrayTemp = unicaFila.split(\",\");\r		var arrayInsertar = new Array();\r\r		var tip = arrayTemp[0];\r\r		if(tip==\"codigo\") {\r			arrayInsertar[0] = arrayTemp[1];\r			arrayInsertar[1] = arrayTemp[2];\r			arrayInsertar[2] = arrayTemp[3]; \r			arrayInsertar[3] = arrayTemp[4];  \r			arrayInsertar[4] = arrayTemp[5];   \r			arrayInsertar[5] = \"\";\r			arrayInsertar[6] = \"\"; \r			arrayInsertar[7] = \"\"; \r			arrayInsertar[8] = \"\"; \r			arrayInsertar[9] = \"\"; \r			arrayInsertar[10] = arrayTemp[6];    \r			arrayInsertar[11] = arrayTemp[7]; \r			arrayInsertar[12] = \"\"; \r			arrayInsertar[13] = \"\"; \r			arrayInsertar[14] = \"\"; \r			arrayInsertar[15] = \"\";\r			arrayInsertar[16] = \"\"; \r			arrayInsertar[17] = arrayTemp[8];  \r			arrayInsertar[18] = arrayTemp[9];  \r		}\r		else {\r			arrayInsertar[0] = arrayTemp[16];\r			arrayInsertar[1] = arrayTemp[17];\r			arrayInsertar[2] = \"\"; \r			arrayInsertar[3] = arrayTemp[12];  \r			arrayInsertar[4] = arrayTemp[14];   \r			arrayInsertar[5] = arrayTemp[2];\r			arrayInsertar[6] = arrayTemp[4]; \r			arrayInsertar[7] = arrayTemp[6]; \r			arrayInsertar[8] = arrayTemp[8]; \r			arrayInsertar[9] = arrayTemp[10]; \r			arrayInsertar[10] = arrayTemp[11];    \r			arrayInsertar[11] = arrayTemp[13]; \r			arrayInsertar[12] = arrayTemp[1]; \r			arrayInsertar[13] = arrayTemp[3]; \r			arrayInsertar[14] = arrayTemp[5]; \r			arrayInsertar[15] = arrayTemp[7];\r			arrayInsertar[16] = arrayTemp[9]; \r			arrayInsertar[17] = arrayTemp[15];  \r			arrayInsertar[18] = \"\";  \r		}\r\r		var filaSeleccionadaModificar = get(\"formulario.filaSeleccionadaModificar\");\r		var presionoModificar = get(\"formulario.presionoModificar\");\r\r		if(presionoModificar==\"true\") {\r			listado1.actualizaDat();   \r			var datos = listado1.datos;\r			datos[filaSeleccionadaModificar] = arrayInsertar; \r			listado1.setDatos(datos);\r			listado1.repintaDat();\r		}\r		else {\r			listado1.actualizaDat();   \r			var datos = listado1.datos;\r			datos[datos.length] = arrayInsertar; \r			listado1.setDatos(datos);\r			listado1.repintaDat();\r		}\r	  }\r  focoBotonIncluir();\r}\r\rfunction fErrorAlGuardar() {\r	focoBotonIncluir();\r}\r\rfunction reInicio() {\r	focoBotonIncluir();\r}\r\rfunction fVolver() {\r						  				  			\r	window.close();\r}\r\r \r"));
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
      ((Element)v.get(11)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","accion" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","varPais" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","varIdioma" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","varOidCanal" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","varOidMarca" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","incluido" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","codProducto" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","descMarcaProducto" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(23)).setAttribute("nombre","descUnidadNegocio" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","descNegocio" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","descSupergenerico" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","descGenerico" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","descTipoOferta" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","descCicloVida" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","idPestanyaDest" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","datosDeLista" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","lblCodigoProducto" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","lblDescMarcaProducto" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","lblDescUnidadNegocio" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","lblDescNegocio" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","lblDescSupergenerico" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","lblDescGenerico" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","lblDescTipoOferta" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","lblDescCicloVida" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","descTipoProducto" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","vieneModificar" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","tipoInsercion" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","tipoProducto" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","oidProductoTemp" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","oidMarcaTemp" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","oidUNegocioTemp" );
      ((Element)v.get(45)).setAttribute("valor","" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(7)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","oidNegocioTemp" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","oidSupergenericoTemp" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","oidGenericoTemp" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","oidTipoOfertaTemp" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","oidCicloVidaTemp" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(51)).setAttribute("nombre","filaSeleccionadaModificar" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(52)).setAttribute("nombre","presionoModificar" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(53)).setAttribute("nombre","datosPestanyaClientes" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(54)).setAttribute("nombre","datosPestanyaDatosCalculo" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 7   */
      v.add(doc.createElement("table"));
      ((Element)v.get(55)).setAttribute("width","100%" );
      ((Element)v.get(55)).setAttribute("height","100%" );
      ((Element)v.get(55)).setAttribute("border","0" );
      ((Element)v.get(55)).setAttribute("align","center" );
      ((Element)v.get(55)).setAttribute("cellpadding","0" );
      ((Element)v.get(55)).setAttribute("cellspacing","0" );
      ((Element)v.get(55)).setAttribute("class","menu4" );
      ((Element)v.get(7)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).setAttribute("width","12" );
      ((Element)v.get(57)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(57)).setAttribute("class","menu5texto" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(58)).setAttribute("src","b.gif" );
      ((Element)v.get(58)).setAttribute("width","12" );
      ((Element)v.get(58)).setAttribute("height","30" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:59 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(59)).setAttribute("class","menu5texto" );
      ((Element)v.get(56)).appendChild((Element)v.get(59));

      /* Elemento padre:59 / Elemento actual: 60   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(59)).appendChild((Text)v.get(60));

      /* Termina nodo Texto:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:61 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).setAttribute("width","10" );
      ((Element)v.get(61)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(61)).setAttribute("class","menu5texto" );
      ((Element)v.get(56)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(62)).setAttribute("src","b.gif" );
      ((Element)v.get(62)).setAttribute("width","10" );
      ((Element)v.get(62)).setAttribute("height","8" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:63 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).setAttribute("width","92" );
      ((Element)v.get(63)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(63)).setAttribute("class","menu5texto" );
      ((Element)v.get(56)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("table"));
      ((Element)v.get(64)).setAttribute("width","75" );
      ((Element)v.get(64)).setAttribute("border","1" );
      ((Element)v.get(64)).setAttribute("align","center" );
      ((Element)v.get(64)).setAttribute("cellpadding","1" );
      ((Element)v.get(64)).setAttribute("cellspacing","0" );
      ((Element)v.get(64)).setAttribute("ID","DatosGenerales" );
      ((Element)v.get(64)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(64)).setAttribute("onclick","onClickPestanya('DatosGenerales');" );
      ((Element)v.get(64)).setAttribute("onmouseover","poneManito('DatosGenerales');" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(65)).setAttribute("align","center" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(67)).setAttribute("nombre","lblDGC" );
      ((Element)v.get(67)).setAttribute("alto","13" );
      ((Element)v.get(67)).setAttribute("filas","1" );
      ((Element)v.get(67)).setAttribute("valor","" );
      ((Element)v.get(67)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(67)).setAttribute("cod","00543" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:65   */
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:68 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).setAttribute("width","10" );
      ((Element)v.get(68)).setAttribute("class","menu5texto" );
      ((Element)v.get(56)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(69)).setAttribute("src","b.gif" );
      ((Element)v.get(69)).setAttribute("width","10" );
      ((Element)v.get(69)).setAttribute("height","8" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */

      /* Empieza nodo:70 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).setAttribute("width","20" );
      ((Element)v.get(70)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(70)).setAttribute("class","menu5texto" );
      ((Element)v.get(56)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("table"));
      ((Element)v.get(71)).setAttribute("width","75" );
      ((Element)v.get(71)).setAttribute("border","1" );
      ((Element)v.get(71)).setAttribute("align","center" );
      ((Element)v.get(71)).setAttribute("cellpadding","1" );
      ((Element)v.get(71)).setAttribute("cellspacing","0" );
      ((Element)v.get(71)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(71)).setAttribute("bgcolor","#496A9A" );
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
      ((Element)v.get(74)).setAttribute("nombre","lblProductos" );
      ((Element)v.get(74)).setAttribute("alto","13" );
      ((Element)v.get(74)).setAttribute("filas","1" );
      ((Element)v.get(74)).setAttribute("valor","" );
      ((Element)v.get(74)).setAttribute("id","menu5textoblanca" );
      ((Element)v.get(74)).setAttribute("cod","0094" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */
      /* Termina nodo:72   */
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:75 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).setAttribute("width","10" );
      ((Element)v.get(75)).setAttribute("class","menu5texto" );
      ((Element)v.get(56)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(76)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).setAttribute("width","10" );
      ((Element)v.get(76)).setAttribute("height","8" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:77 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).setAttribute("width","20" );
      ((Element)v.get(77)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(77)).setAttribute("class","menu5texto" );
      ((Element)v.get(56)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("table"));
      ((Element)v.get(78)).setAttribute("width","75" );
      ((Element)v.get(78)).setAttribute("border","1" );
      ((Element)v.get(78)).setAttribute("align","center" );
      ((Element)v.get(78)).setAttribute("cellpadding","1" );
      ((Element)v.get(78)).setAttribute("cellspacing","0" );
      ((Element)v.get(78)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(78)).setAttribute("ID","Clientes" );
      ((Element)v.get(78)).setAttribute("onclick","onClickPestanya('Clientes');" );
      ((Element)v.get(78)).setAttribute("onmouseover","poneManito('Clientes');" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(79)).setAttribute("align","center" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(81)).setAttribute("nombre","lblClientes" );
      ((Element)v.get(81)).setAttribute("alto","13" );
      ((Element)v.get(81)).setAttribute("filas","1" );
      ((Element)v.get(81)).setAttribute("valor","" );
      ((Element)v.get(81)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(81)).setAttribute("cod","0026" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */
      /* Termina nodo:79   */
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:82 / Elemento padre: 56   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).setAttribute("width","10" );
      ((Element)v.get(82)).setAttribute("class","menu5texto" );
      ((Element)v.get(56)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(83)).setAttribute("src","b.gif" );
      ((Element)v.get(83)).setAttribute("width","10" );
      ((Element)v.get(83)).setAttribute("height","8" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */

      /* Empieza nodo:84 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).setAttribute("width","20" );
      ((Element)v.get(84)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(84)).setAttribute("class","menu5texto" );
      ((Element)v.get(56)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("table"));
      ((Element)v.get(85)).setAttribute("width","75" );
      ((Element)v.get(85)).setAttribute("border","1" );
      ((Element)v.get(85)).setAttribute("align","center" );
      ((Element)v.get(85)).setAttribute("cellpadding","1" );
      ((Element)v.get(85)).setAttribute("cellspacing","0" );
      ((Element)v.get(85)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(85)).setAttribute("ID","DatosCalculo" );
      ((Element)v.get(85)).setAttribute("onclick","onClickPestanya('DatosCalculo');" );
      ((Element)v.get(85)).setAttribute("onmouseover","poneManito('DatosCalculo');" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(86)).setAttribute("align","center" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("td"));
      ((Element)v.get(87)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(88)).setAttribute("nombre","lblDatosC" );
      ((Element)v.get(88)).setAttribute("alto","13" );
      ((Element)v.get(88)).setAttribute("filas","1" );
      ((Element)v.get(88)).setAttribute("valor","" );
      ((Element)v.get(88)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(88)).setAttribute("cod","00544" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */
      /* Termina nodo:86   */
      /* Termina nodo:85   */
      /* Termina nodo:84   */

      /* Empieza nodo:89 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).setAttribute("width","16" );
      ((Element)v.get(89)).setAttribute("class","menu5texto" );
      ((Element)v.get(56)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(90)).setAttribute("src","b.gif" );
      ((Element)v.get(90)).setAttribute("width","12" );
      ((Element)v.get(90)).setAttribute("height","8" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:91 / Elemento padre: 7   */
      v.add(doc.createElement("table"));
      ((Element)v.get(91)).setAttribute("width","100%" );
      ((Element)v.get(91)).setAttribute("border","0" );
      ((Element)v.get(91)).setAttribute("cellspacing","0" );
      ((Element)v.get(91)).setAttribute("cellpadding","0" );
      ((Element)v.get(7)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(91)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).setAttribute("width","100%" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(94)).setAttribute("src","b.gif" );
      ((Element)v.get(94)).setAttribute("width","424" );
      ((Element)v.get(94)).setAttribute("height","8" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:95 / Elemento padre: 7   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(95)).setAttribute("nombre","listado1" );
      ((Element)v.get(95)).setAttribute("ancho","400" );
      ((Element)v.get(95)).setAttribute("alto","317" );
      ((Element)v.get(95)).setAttribute("x","12" );
      ((Element)v.get(95)).setAttribute("y","35" );
      ((Element)v.get(95)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(95)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(7)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(96)).setAttribute("precarga","S" );
      ((Element)v.get(96)).setAttribute("conROver","S" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(97)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(97)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(97)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(97)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */

      /* Empieza nodo:98 / Elemento padre: 96   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(98)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(98)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(98)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(98)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(96)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */

      /* Empieza nodo:99 / Elemento padre: 96   */
      v.add(doc.createElement("BTNORDENAR"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(99)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(99)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(96)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:96   */

      /* Empieza nodo:100 / Elemento padre: 95   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(95)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(101)).setAttribute("borde","1" );
      ((Element)v.get(101)).setAttribute("horizDatos","1" );
      ((Element)v.get(101)).setAttribute("horizCabecera","1" );
      ((Element)v.get(101)).setAttribute("vertical","0" );
      ((Element)v.get(101)).setAttribute("horizTitulo","1" );
      ((Element)v.get(101)).setAttribute("horizBase","1" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */

      /* Empieza nodo:102 / Elemento padre: 100   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(102)).setAttribute("borde","#999999" );
      ((Element)v.get(102)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(102)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(102)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(102)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(102)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(102)).setAttribute("horizBase","#999999" );
      ((Element)v.get(100)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:100   */

      /* Empieza nodo:103 / Elemento padre: 95   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(103)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(103)).setAttribute("alto","22" );
      ((Element)v.get(103)).setAttribute("imgFondo","" );
      ((Element)v.get(103)).setAttribute("cod","0094" );
      ((Element)v.get(103)).setAttribute("ID","datosTitle" );
      ((Element)v.get(95)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */

      /* Empieza nodo:104 / Elemento padre: 95   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(104)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(104)).setAttribute("alto","22" );
      ((Element)v.get(104)).setAttribute("imgFondo","" );
      ((Element)v.get(95)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */

      /* Empieza nodo:105 / Elemento padre: 95   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(105)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(105)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(105)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(105)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(105)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(105)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(95)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(106)).setAttribute("ancho","100" );
      ((Element)v.get(106)).setAttribute("minimizable","S" );
      ((Element)v.get(106)).setAttribute("minimizada","N" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */

      /* Empieza nodo:107 / Elemento padre: 105   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(107)).setAttribute("ancho","100" );
      ((Element)v.get(107)).setAttribute("minimizable","S" );
      ((Element)v.get(107)).setAttribute("minimizada","N" );
      ((Element)v.get(105)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */

      /* Empieza nodo:108 / Elemento padre: 105   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(108)).setAttribute("ancho","100" );
      ((Element)v.get(108)).setAttribute("minimizable","S" );
      ((Element)v.get(108)).setAttribute("minimizada","N" );
      ((Element)v.get(105)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */

      /* Empieza nodo:109 / Elemento padre: 105   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(109)).setAttribute("ancho","100" );
      ((Element)v.get(109)).setAttribute("minimizable","S" );
      ((Element)v.get(109)).setAttribute("minimizada","N" );
      ((Element)v.get(105)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */

      /* Empieza nodo:110 / Elemento padre: 105   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(110)).setAttribute("ancho","100" );
      ((Element)v.get(110)).setAttribute("minimizable","S" );
      ((Element)v.get(110)).setAttribute("minimizada","N" );
      ((Element)v.get(105)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */

      /* Empieza nodo:111 / Elemento padre: 105   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(111)).setAttribute("ancho","100" );
      ((Element)v.get(111)).setAttribute("minimizable","S" );
      ((Element)v.get(111)).setAttribute("minimizada","N" );
      ((Element)v.get(105)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */

      /* Empieza nodo:112 / Elemento padre: 105   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(112)).setAttribute("ancho","100" );
      ((Element)v.get(112)).setAttribute("minimizable","S" );
      ((Element)v.get(112)).setAttribute("minimizada","N" );
      ((Element)v.get(105)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */

      /* Empieza nodo:113 / Elemento padre: 105   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(113)).setAttribute("ancho","100" );
      ((Element)v.get(113)).setAttribute("minimizable","S" );
      ((Element)v.get(113)).setAttribute("minimizada","N" );
      ((Element)v.get(105)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */

      /* Empieza nodo:114 / Elemento padre: 105   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(114)).setAttribute("ancho","100" );
      ((Element)v.get(114)).setAttribute("minimizable","S" );
      ((Element)v.get(114)).setAttribute("minimizada","N" );
      ((Element)v.get(105)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */

      /* Empieza nodo:115 / Elemento padre: 105   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(115)).setAttribute("ancho","100" );
      ((Element)v.get(115)).setAttribute("minimizable","S" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(115)).setAttribute("minimizada","N" );
      ((Element)v.get(115)).setAttribute("oculta","S" );
      ((Element)v.get(105)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */

      /* Empieza nodo:116 / Elemento padre: 105   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(116)).setAttribute("ancho","100" );
      ((Element)v.get(116)).setAttribute("minimizable","S" );
      ((Element)v.get(116)).setAttribute("minimizada","N" );
      ((Element)v.get(116)).setAttribute("oculta","S" );
      ((Element)v.get(105)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */

      /* Empieza nodo:117 / Elemento padre: 105   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(117)).setAttribute("ancho","100" );
      ((Element)v.get(117)).setAttribute("minimizable","S" );
      ((Element)v.get(117)).setAttribute("minimizada","N" );
      ((Element)v.get(117)).setAttribute("oculta","S" );
      ((Element)v.get(105)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */

      /* Empieza nodo:118 / Elemento padre: 105   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(118)).setAttribute("ancho","100" );
      ((Element)v.get(118)).setAttribute("minimizable","S" );
      ((Element)v.get(118)).setAttribute("minimizada","N" );
      ((Element)v.get(118)).setAttribute("oculta","S" );
      ((Element)v.get(105)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */

      /* Empieza nodo:119 / Elemento padre: 105   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(119)).setAttribute("ancho","100" );
      ((Element)v.get(119)).setAttribute("minimizable","S" );
      ((Element)v.get(119)).setAttribute("minimizada","N" );
      ((Element)v.get(119)).setAttribute("oculta","S" );
      ((Element)v.get(105)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */

      /* Empieza nodo:120 / Elemento padre: 105   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(120)).setAttribute("ancho","100" );
      ((Element)v.get(120)).setAttribute("minimizable","S" );
      ((Element)v.get(120)).setAttribute("minimizada","N" );
      ((Element)v.get(120)).setAttribute("oculta","S" );
      ((Element)v.get(105)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */

      /* Empieza nodo:121 / Elemento padre: 105   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(121)).setAttribute("ancho","100" );
      ((Element)v.get(121)).setAttribute("minimizable","S" );
      ((Element)v.get(121)).setAttribute("minimizada","N" );
      ((Element)v.get(121)).setAttribute("oculta","S" );
      ((Element)v.get(105)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */

      /* Empieza nodo:122 / Elemento padre: 105   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(122)).setAttribute("ancho","100" );
      ((Element)v.get(122)).setAttribute("minimizable","S" );
      ((Element)v.get(122)).setAttribute("minimizada","N" );
      ((Element)v.get(122)).setAttribute("oculta","S" );
      ((Element)v.get(105)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */

      /* Empieza nodo:123 / Elemento padre: 105   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(123)).setAttribute("ancho","100" );
      ((Element)v.get(123)).setAttribute("minimizable","S" );
      ((Element)v.get(123)).setAttribute("minimizada","N" );
      ((Element)v.get(123)).setAttribute("oculta","S" );
      ((Element)v.get(105)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:105   */

      /* Empieza nodo:124 / Elemento padre: 95   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(124)).setAttribute("alto","20" );
      ((Element)v.get(124)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(124)).setAttribute("imgFondo","" );
      ((Element)v.get(124)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(95)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(125)).setAttribute("colFondo","" );
      ((Element)v.get(125)).setAttribute("ID","EstCab" );
      ((Element)v.get(125)).setAttribute("cod","793" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */

      /* Empieza nodo:126 / Elemento padre: 124   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(126)).setAttribute("colFondo","" );
      ((Element)v.get(126)).setAttribute("ID","EstCab" );
      ((Element)v.get(126)).setAttribute("cod","337" );
      ((Element)v.get(124)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */

      /* Empieza nodo:127 / Elemento padre: 124   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(127)).setAttribute("colFondo","" );
      ((Element)v.get(127)).setAttribute("ID","EstCab" );
      ((Element)v.get(127)).setAttribute("cod","608" );
      ((Element)v.get(124)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */

      /* Empieza nodo:128 / Elemento padre: 124   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(128)).setAttribute("colFondo","" );
      ((Element)v.get(128)).setAttribute("ID","EstCab" );
      ((Element)v.get(128)).setAttribute("cod","581" );
      ((Element)v.get(124)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */

      /* Empieza nodo:129 / Elemento padre: 124   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(129)).setAttribute("colFondo","" );
      ((Element)v.get(129)).setAttribute("ID","EstCab" );
      ((Element)v.get(129)).setAttribute("cod","6" );
      ((Element)v.get(124)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */

      /* Empieza nodo:130 / Elemento padre: 124   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(130)).setAttribute("colFondo","" );
      ((Element)v.get(130)).setAttribute("ID","EstCab" );
      ((Element)v.get(130)).setAttribute("cod","1338" );
      ((Element)v.get(124)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */

      /* Empieza nodo:131 / Elemento padre: 124   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(131)).setAttribute("colFondo","" );
      ((Element)v.get(131)).setAttribute("ID","EstCab" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(131)).setAttribute("cod","588" );
      ((Element)v.get(124)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */

      /* Empieza nodo:132 / Elemento padre: 124   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(132)).setAttribute("colFondo","" );
      ((Element)v.get(132)).setAttribute("ID","EstCab" );
      ((Element)v.get(132)).setAttribute("cod","590" );
      ((Element)v.get(124)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */

      /* Empieza nodo:133 / Elemento padre: 124   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(133)).setAttribute("colFondo","" );
      ((Element)v.get(133)).setAttribute("ID","EstCab" );
      ((Element)v.get(133)).setAttribute("cod","589" );
      ((Element)v.get(124)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */

      /* Empieza nodo:134 / Elemento padre: 124   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(134)).setAttribute("colFondo","" );
      ((Element)v.get(134)).setAttribute("ID","EstCab" );
      ((Element)v.get(134)).setAttribute("cod","608" );
      ((Element)v.get(124)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */

      /* Empieza nodo:135 / Elemento padre: 124   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(135)).setAttribute("colFondo","" );
      ((Element)v.get(135)).setAttribute("ID","EstCab" );
      ((Element)v.get(135)).setAttribute("cod","581" );
      ((Element)v.get(124)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */

      /* Empieza nodo:136 / Elemento padre: 124   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(136)).setAttribute("colFondo","" );
      ((Element)v.get(136)).setAttribute("ID","EstCab" );
      ((Element)v.get(136)).setAttribute("cod","6" );
      ((Element)v.get(124)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */

      /* Empieza nodo:137 / Elemento padre: 124   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(137)).setAttribute("colFondo","" );
      ((Element)v.get(137)).setAttribute("ID","EstCab" );
      ((Element)v.get(137)).setAttribute("cod","1338" );
      ((Element)v.get(124)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */

      /* Empieza nodo:138 / Elemento padre: 124   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(138)).setAttribute("colFondo","" );
      ((Element)v.get(138)).setAttribute("ID","EstCab" );
      ((Element)v.get(138)).setAttribute("cod","588" );
      ((Element)v.get(124)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */

      /* Empieza nodo:139 / Elemento padre: 124   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(139)).setAttribute("colFondo","" );
      ((Element)v.get(139)).setAttribute("ID","EstCab" );
      ((Element)v.get(139)).setAttribute("cod","590" );
      ((Element)v.get(124)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */

      /* Empieza nodo:140 / Elemento padre: 124   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(140)).setAttribute("colFondo","" );
      ((Element)v.get(140)).setAttribute("ID","EstCab" );
      ((Element)v.get(140)).setAttribute("cod","589" );
      ((Element)v.get(124)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */

      /* Empieza nodo:141 / Elemento padre: 124   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(141)).setAttribute("colFondo","" );
      ((Element)v.get(141)).setAttribute("ID","EstCab" );
      ((Element)v.get(141)).setAttribute("cod","590" );
      ((Element)v.get(124)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */

      /* Empieza nodo:142 / Elemento padre: 124   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(142)).setAttribute("colFondo","" );
      ((Element)v.get(142)).setAttribute("ID","EstCab" );
      ((Element)v.get(142)).setAttribute("cod","589" );
      ((Element)v.get(124)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:124   */

      /* Empieza nodo:143 / Elemento padre: 95   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(143)).setAttribute("alto","22" );
      ((Element)v.get(143)).setAttribute("accion","" );
      ((Element)v.get(143)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(143)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(143)).setAttribute("maxSel","1" );
      ((Element)v.get(143)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(143)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(143)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(143)).setAttribute("onLoad","" );
      ((Element)v.get(143)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(95)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(144)).setAttribute("tipo","texto" );
      ((Element)v.get(144)).setAttribute("ID","EstDat" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */

      /* Empieza nodo:145 / Elemento padre: 143   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(145)).setAttribute("tipo","texto" );
      ((Element)v.get(145)).setAttribute("ID","EstDat2" );
      ((Element)v.get(143)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */

      /* Empieza nodo:146 / Elemento padre: 143   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(146)).setAttribute("tipo","texto" );
      ((Element)v.get(146)).setAttribute("ID","EstDat" );
      ((Element)v.get(143)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */

      /* Empieza nodo:147 / Elemento padre: 143   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(147)).setAttribute("tipo","texto" );
      ((Element)v.get(147)).setAttribute("ID","EstDat2" );
      ((Element)v.get(143)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */

      /* Empieza nodo:148 / Elemento padre: 143   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(148)).setAttribute("tipo","texto" );
      ((Element)v.get(148)).setAttribute("ID","EstDat" );
      ((Element)v.get(143)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */

      /* Empieza nodo:149 / Elemento padre: 143   */
      v.add(doc.createElement("COL"));
   }

   private void getXML720(Document doc) {
      ((Element)v.get(149)).setAttribute("tipo","texto" );
      ((Element)v.get(149)).setAttribute("ID","EstDat2" );
      ((Element)v.get(143)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */

      /* Empieza nodo:150 / Elemento padre: 143   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(150)).setAttribute("tipo","texto" );
      ((Element)v.get(150)).setAttribute("ID","EstDat" );
      ((Element)v.get(143)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */

      /* Empieza nodo:151 / Elemento padre: 143   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(151)).setAttribute("tipo","texto" );
      ((Element)v.get(151)).setAttribute("ID","EstDat2" );
      ((Element)v.get(143)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */

      /* Empieza nodo:152 / Elemento padre: 143   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(152)).setAttribute("tipo","texto" );
      ((Element)v.get(152)).setAttribute("ID","EstDat" );
      ((Element)v.get(143)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */

      /* Empieza nodo:153 / Elemento padre: 143   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(153)).setAttribute("tipo","texto" );
      ((Element)v.get(153)).setAttribute("ID","EstDat2" );
      ((Element)v.get(143)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */

      /* Empieza nodo:154 / Elemento padre: 143   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(154)).setAttribute("tipo","texto" );
      ((Element)v.get(154)).setAttribute("ID","EstDat" );
      ((Element)v.get(143)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */

      /* Empieza nodo:155 / Elemento padre: 143   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(155)).setAttribute("tipo","texto" );
      ((Element)v.get(155)).setAttribute("ID","EstDat2" );
      ((Element)v.get(143)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */

      /* Empieza nodo:156 / Elemento padre: 143   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(156)).setAttribute("tipo","texto" );
      ((Element)v.get(156)).setAttribute("ID","EstDat" );
      ((Element)v.get(143)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */

      /* Empieza nodo:157 / Elemento padre: 143   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(157)).setAttribute("tipo","texto" );
      ((Element)v.get(157)).setAttribute("ID","EstDat2" );
      ((Element)v.get(143)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */

      /* Empieza nodo:158 / Elemento padre: 143   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(158)).setAttribute("tipo","texto" );
      ((Element)v.get(158)).setAttribute("ID","EstDat" );
      ((Element)v.get(143)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */

      /* Empieza nodo:159 / Elemento padre: 143   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(159)).setAttribute("tipo","texto" );
      ((Element)v.get(159)).setAttribute("ID","EstDat2" );
      ((Element)v.get(143)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */

      /* Empieza nodo:160 / Elemento padre: 143   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(160)).setAttribute("tipo","texto" );
      ((Element)v.get(160)).setAttribute("ID","EstDat" );
      ((Element)v.get(143)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */

      /* Empieza nodo:161 / Elemento padre: 143   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(161)).setAttribute("tipo","texto" );
      ((Element)v.get(161)).setAttribute("ID","EstDat2" );
      ((Element)v.get(143)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:143   */

      /* Empieza nodo:162 / Elemento padre: 95   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(95)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */

      /* Empieza nodo:163 / Elemento padre: 95   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(163)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(163)).setAttribute("ancho","400" );
      ((Element)v.get(163)).setAttribute("sep","$" );
      ((Element)v.get(163)).setAttribute("x","12" );
      ((Element)v.get(163)).setAttribute("class","botonera" );
      ((Element)v.get(163)).setAttribute("y","306" );
      ((Element)v.get(163)).setAttribute("control","|" );
      ((Element)v.get(163)).setAttribute("conector","" );
      ((Element)v.get(163)).setAttribute("rowset","" );
      ((Element)v.get(163)).setAttribute("cargainicial","N" );
      ((Element)v.get(95)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(164)).setAttribute("nombre","ret1" );
      ((Element)v.get(164)).setAttribute("x","37" );
      ((Element)v.get(164)).setAttribute("y","333" );
      ((Element)v.get(164)).setAttribute("ID","botonContenido" );
      ((Element)v.get(164)).setAttribute("img","retroceder_on" );
      ((Element)v.get(164)).setAttribute("tipo","0" );
      ((Element)v.get(164)).setAttribute("estado","false" );
      ((Element)v.get(164)).setAttribute("alt","" );
      ((Element)v.get(164)).setAttribute("codigo","" );
      ((Element)v.get(164)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */

      /* Empieza nodo:165 / Elemento padre: 163   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(165)).setAttribute("nombre","ava1" );
      ((Element)v.get(165)).setAttribute("x","52" );
      ((Element)v.get(165)).setAttribute("y","333" );
      ((Element)v.get(165)).setAttribute("ID","botonContenido" );
      ((Element)v.get(165)).setAttribute("img","avanzar_on" );
      ((Element)v.get(165)).setAttribute("tipo","0" );
      ((Element)v.get(165)).setAttribute("estado","false" );
      ((Element)v.get(165)).setAttribute("alt","" );
      ((Element)v.get(165)).setAttribute("codigo","" );
      ((Element)v.get(165)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(163)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:163   */
      /* Termina nodo:95   */

      /* Empieza nodo:166 / Elemento padre: 7   */
      v.add(doc.createElement("BOTON"));
   }

   private void getXML810(Document doc) {
      ((Element)v.get(166)).setAttribute("nombre","primera1" );
      ((Element)v.get(166)).setAttribute("x","20" );
      ((Element)v.get(166)).setAttribute("y","333" );
      ((Element)v.get(166)).setAttribute("ID","botonContenido" );
      ((Element)v.get(166)).setAttribute("img","primera_on" );
      ((Element)v.get(166)).setAttribute("tipo","-2" );
      ((Element)v.get(166)).setAttribute("estado","false" );
      ((Element)v.get(166)).setAttribute("alt","" );
      ((Element)v.get(166)).setAttribute("codigo","" );
      ((Element)v.get(166)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(7)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */

      /* Empieza nodo:167 / Elemento padre: 7   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(167)).setAttribute("nombre","separa" );
      ((Element)v.get(167)).setAttribute("x","59" );
      ((Element)v.get(167)).setAttribute("y","329" );
      ((Element)v.get(167)).setAttribute("ID","botonContenido" );
      ((Element)v.get(167)).setAttribute("img","separa_base" );
      ((Element)v.get(167)).setAttribute("tipo","0" );
      ((Element)v.get(167)).setAttribute("estado","false" );
      ((Element)v.get(167)).setAttribute("alt","" );
      ((Element)v.get(167)).setAttribute("codigo","" );
      ((Element)v.get(167)).setAttribute("accion","" );
      ((Element)v.get(7)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */

      /* Empieza nodo:168 / Elemento padre: 7   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(168)).setAttribute("nombre","btnIncluir" );
      ((Element)v.get(168)).setAttribute("x","80" );
      ((Element)v.get(168)).setAttribute("y","330" );
      ((Element)v.get(168)).setAttribute("ID","botonContenido" );
      ((Element)v.get(168)).setAttribute("tipo","html" );
      ((Element)v.get(168)).setAttribute("estado","false" );
      ((Element)v.get(168)).setAttribute("cod","2477" );
      ((Element)v.get(168)).setAttribute("onshtab","focoBotonExcluir();" );
      ((Element)v.get(168)).setAttribute("accion","onClickAnadir();" );
      ((Element)v.get(7)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */

      /* Empieza nodo:169 / Elemento padre: 7   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(169)).setAttribute("nombre","btnModificar" );
      ((Element)v.get(169)).setAttribute("x","122" );
      ((Element)v.get(169)).setAttribute("y","330" );
      ((Element)v.get(169)).setAttribute("ID","botonContenido" );
      ((Element)v.get(169)).setAttribute("tipo","html" );
      ((Element)v.get(169)).setAttribute("estado","false" );
      ((Element)v.get(169)).setAttribute("cod","2" );
      ((Element)v.get(169)).setAttribute("accion","onClickModificar();" );
      ((Element)v.get(7)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */

      /* Empieza nodo:170 / Elemento padre: 7   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(170)).setAttribute("nombre","btnExcluir" );
      ((Element)v.get(170)).setAttribute("x","188" );
      ((Element)v.get(170)).setAttribute("y","330" );
      ((Element)v.get(170)).setAttribute("ID","botonContenido" );
      ((Element)v.get(170)).setAttribute("tipo","html" );
      ((Element)v.get(170)).setAttribute("estado","false" );
      ((Element)v.get(170)).setAttribute("cod","2272" );
      ((Element)v.get(170)).setAttribute("ontab","focoBotonIncluir();" );
      ((Element)v.get(170)).setAttribute("accion","onClickExcluir();" );
      ((Element)v.get(7)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */

      /* Empieza nodo:171 / Elemento padre: 7   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(171)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(171)).setAttribute("alto","12" );
      ((Element)v.get(171)).setAttribute("ancho","100%" );
      ((Element)v.get(171)).setAttribute("colorf","" );
      ((Element)v.get(171)).setAttribute("borde","0" );
      ((Element)v.get(171)).setAttribute("imagenf","" );
      ((Element)v.get(171)).setAttribute("repeat","" );
      ((Element)v.get(171)).setAttribute("padding","" );
      ((Element)v.get(171)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(171)).setAttribute("contravsb","" );
      ((Element)v.get(171)).setAttribute("x","0" );
      ((Element)v.get(171)).setAttribute("y","329" );
      ((Element)v.get(171)).setAttribute("zindex","" );
      ((Element)v.get(7)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:7   */


   }

}
