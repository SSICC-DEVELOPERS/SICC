
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_productos_exigidos_premiacion_mantener  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_productos_exigidos_premiacion_mantener" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("titulo","Mantener productos exigidos de premiación" );
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
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Elemento padre:6 / Elemento actual: 7   */
      v.add(doc.createTextNode("\r \r\rfunction onLoadPag() {  \r	configurarMenuSecundario(\"formulario\");	\r	muestraCapa();\r	\r	var opcionMenu = get(\"formulario.opcionMenu\");  \r\r	if(opcionMenu==\"Consultar Concurso\") {\r		document.getElementById(\"cbMarca\").disabled = true;\r		document.getElementById(\"cbUnidadNegocio\").disabled = true;\r		document.getElementById(\"cbNegocio\").disabled = true;\r		document.getElementById(\"cbSupergenerico\").disabled = true;\r		document.getElementById(\"cbGenerico\").disabled = true;\r		document.getElementById(\"txtCodProducto5\").disabled = true;\r		document.getElementById(\"btnBuscar\").disabled = true;\r		document.getElementById(\"btnAnadir4\").disabled = true;\r		document.getElementById(\"btnAceptar\").disabled = true;\r		btnProxy(4, '0');	\r		btnProxy(5, '0');	\r	}	\r	else {\r		focoComboMarca();\r	}	\r}\r\rfunction fLimpiar() {\r	var arrayVacio = new Array();\r	listado1.setDatos(arrayVacio);\r	focoComboMarca();\r}\r\rfunction focoComboMarca() {\r	focaliza(\"formulario.cbMarca\");\r}\r\rfunction focoBotonAceptar() {\r	focalizaBotonHTML('botonContenido','btnAceptar');	\r}\r\rfunction focoBotonAnadir() {\r	focalizaBotonHTML('botonContenido','btnAnadir4');	\r}\r\rfunction fVolver() {\r	window.close();\r}\r\rfunction muestraCapa() {\r	DrdEnsanchaConMargenDcho('listado1',12);\r    document.all[\"Cplistado1\"].style.visibility='';\r    document.all[\"CpLin1listado1\"].style.visibility='';\r    document.all[\"CpLin2listado1\"].style.visibility='';\r    document.all[\"CpLin3listado1\"].style.visibility='';\r    document.all[\"CpLin4listado1\"].style.visibility='';\r    document.all[\"separaDiv\"].style.visibility='hidden';\r    document.all[\"primera1Div\"].style.visibility='hidden';\r    document.all[\"ret1Div\"].style.visibility='hidden';\r    document.all[\"ava1Div\"].style.visibility='hidden';   \r    eval (ON_RSZ);  \r}\r\rfunction accionAnadir() {	\r	if(!sicc_validaciones_generales()) {\r	    return;\r    }	\r\r	var datos = listado1.datos; \r	var existe = \"false\";\r\r	var oidProductoExigido = \" \";\r	var oidMarca = \" \";\r	var marca = \" \";\r	var oidUnidadNegocio = \" \";\r	var unidadNegocio = \" \";\r	var oidNegocio = \" \";\r	var negocio = \" \";\r	var oidSupergenerico = \" \";\r	var supergenerico = \" \";\r	var oidGenerico = \" \";\r	var generico = \" \";\r	var codigoProducto = \" \";\r	var oidProducto = \" \";\r\r	if(get(\"formulario.cbMarca\")!=\"\") oidMarca = get(\"formulario.cbMarca\");\r	if(get(\"formulario.cbMarca\", \"T\")!=\"\") marca = get(\"formulario.cbMarca\", \"T\");\r	if(get(\"formulario.cbUnidadNegocio\")!=\"\") oidUnidadNegocio = get(\"formulario.cbUnidadNegocio\");\r	if(get(\"formulario.cbUnidadNegocio\", \"T\")!=\"\") unidadNegocio = get(\"formulario.cbUnidadNegocio\", \"T\");\r	if(get(\"formulario.cbNegocio\")!=\"\") oidNegocio = get(\"formulario.cbNegocio\");\r	if(get(\"formulario.cbNegocio\", \"T\")!=\"\") negocio = get(\"formulario.cbNegocio\", \"T\");\r	if(get(\"formulario.cbSupergenerico\")!=\"\") oidSupergenerico = get(\"formulario.cbSupergenerico\");\r	if(get(\"formulario.cbSupergenerico\", \"T\")!=\"\") supergenerico = get(\"formulario.cbSupergenerico\", \"T\");\r	if(get(\"formulario.cbGenerico\")!=\"\") oidGenerico = get(\"formulario.cbGenerico\");\r	if(get(\"formulario.cbGenerico\", \"T\")!=\"\") generico = get(\"formulario.cbGenerico\", \"T\");\r\r	if(get(\"formulario.txtCodProducto5\")!=\"\") {\r		codigoProducto = get(\"formulario.txtCodProducto5\");\r	}	\r	\r	if(get(\"formulario.oidCodigoProducto\")!=\"\" && get(\"formulario.txtCodProducto5\")!=\"\") {\r		oidProducto = get(\"formulario.oidCodigoProducto\");\r	}\r\r	var oidsCombos = \"\";\r	if(get(\"formulario.cbMarca\")!=\"\") oidsCombos = oidsCombos + get(\"formulario.cbMarca\") + \",\";\r	else oidsCombos = oidsCombos + \" \" + \",\";\r\r	if(get(\"formulario.cbUnidadNegocio\")!=\"\") oidsCombos = oidsCombos + get(\"formulario.cbUnidadNegocio\") + \",\";\r	else oidsCombos = oidsCombos + \" \" + \",\";\r\r	if(get(\"formulario.cbNegocio\")!=\"\") oidsCombos = oidsCombos + get(\"formulario.cbNegocio\") + \",\";\r	else oidsCombos = oidsCombos + \" \" + \",\";\r\r	if(get(\"formulario.cbSupergenerico\")!=\"\") oidsCombos = oidsCombos + get(\"formulario.cbSupergenerico\") + \",\";\r	else oidsCombos = oidsCombos + \" \" + \",\";\r\r	if(get(\"formulario.cbGenerico\")!=\"\") oidsCombos = oidsCombos + get(\"formulario.cbGenerico\") + \",\";\r	else oidsCombos = oidsCombos + \" \" + \",\";\r\r	if(get(\"formulario.txtCodProducto5\")!=\"\") oidsCombos = oidsCombos + get(\"formulario.txtCodProducto5\");\r	else oidsCombos = oidsCombos + \" \";\r\r	for(var i=0 ; i<datos.length; i++) {\r		var oidsLista = \"\";\r\r		var temp1 = datos[i][7];\r		var temp2 = datos[i][8];\r		var temp3 = datos[i][9];\r		var temp4 = datos[i][11];\r		var temp5 = datos[i][10];\r		var temp6 = datos[i][6];\r\r		oidsLista = oidsLista + temp1 + \",\";\r		oidsLista = oidsLista + temp2 + \",\";\r		oidsLista = oidsLista + temp3 + \",\";\r		oidsLista = oidsLista + temp4 + \",\";\r		oidsLista = oidsLista + temp5 + \",\";\r		oidsLista = oidsLista + temp6;\r	\r		if(oidsCombos==oidsLista) {\r			existe = \"true\";\r		}\r	}\r\r/*	- 0 = oid producto exigido\r	- 1 = descripcion marca\r	- 2 = descripcion unidad negocio\r	- 3 = descripcion negocio\r	- 4 = descripcion generico\r	- 5 = descripcion supergenerico\r	- 6 = codigo producto\r	- 7 = oid marca\r	- 8 = oid unidad negocio\r	- 9 = oid negocio\r	-10 = oid generico\r	-11 = oid supergenerico\r	-12 = oid producto	*/\r\r   if(existe==\"false\") {\r		var array = new Array();\r			\r		array[0] = new String(oidProductoExigido);\r		array[1] = new String(marca);\r		array[2] = new String(unidadNegocio);\r		array[3] = new String(negocio);\r		array[4] = new String(generico);\r		array[5] = new String(supergenerico);\r		array[6] = new String(codigoProducto);\r		array[7] = new String(oidMarca);\r		array[8] = new String(oidUnidadNegocio);\r		array[9] = new String(oidNegocio);\r		array[10] = new String(oidGenerico);\r		array[11] = new String(oidSupergenerico);\r		array[12] = new String(oidProducto);\r\r		listado1.actualizaDat();\r		var datos = listado1.datos;\r		datos[datos.length] = array; \r		listado1.setDatos(datos);\r		listado1.repintaDat();		\r	}\r}\r\rfunction fBorrar() {\r	accionEliminar();\r}\r\rfunction accionEliminar() {	\r	if (listado1.numSelecc()== 0) {\r		GestionarMensaje('1021',null,null,null);\r		return false;\r    }\r\r	listado1.eliminarSelecc();\r}\r\rfunction accionAceptar() {\r	var datos = listado1.datos;\r	var datosCompletos = \"[\";\r\r	for(var i=0; i<datos.length; i++) {\r		var fila = new Array();\r\r		var temp0 = datos[i][0];\r		if(temp0==\"\") temp0 = \" \";\r		fila[0] = temp0;\r\r		var temp1 = datos[i][1];\r		if(temp1==\"\") temp1 = \" \";\r		fila[1] = temp1;\r\r		var temp2 = datos[i][2];\r		if(temp2==\"\") temp2 = \" \";\r		fila[2] = temp2;\r\r		var temp3 = datos[i][3];\r		if(temp3==\"\") temp3 = \" \";\r		fila[3] = temp3;\r\r		var temp4 = datos[i][4];\r		if(temp4==\"\") temp4 = \" \";\r		fila[4] = temp4;\r\r		var temp5 = datos[i][5];\r		if(temp5==\"\") temp5 = \" \";\r		fila[5] = temp5;\r\r		var temp6 = datos[i][6];\r		if(temp6==\"\") temp6 = \" \";\r		fila[6] = temp6;\r\r		var temp7 = datos[i][7];\r		if(temp7==\"\") temp7 = \" \";\r		fila[7] = temp7;\r\r		var temp8 = datos[i][8];\r		if(temp8==\"\") temp8 = \" \";\r		fila[8] = temp8;\r\r		var temp9 = datos[i][9];\r		if(temp9==\"\") temp9 = \" \";\r		fila[9] = temp9;\r\r		var temp10 = datos[i][10];\r		if(temp10==\"\") temp10 = \" \";\r		fila[10] = temp10;\r\r		var temp11 = datos[i][11];\r		if(temp11==\"\") temp11 = \" \";\r		fila[11] = temp11;\r\r		var temp12 = datos[i][12];\r		if(temp12==\"\") temp12 = \" \";\r		fila[12] = temp12;\r\r		if(i==0) datosCompletos = datosCompletos + fila;	\r		else datosCompletos = datosCompletos + \"|\" + fila;			\r	}\r\r	datosCompletos = datosCompletos + \"]\";\r	returnValue = datosCompletos;\r	window.close();\r}\r\rfunction accionBuscarProducto() {	\r	var obj = new Object();\r	obj.casoDeUso = \"buscarProducto\"\r    var whnd = mostrarModalSICC('LPBuscarProductosDTO','',obj);\r    if(whnd!=null){\r		var producto = whnd[0];\r		var dato = producto.split(\"$\");\r\r		if(dato.length!=2) {\r			GestionarMensaje('1497');\r		}\r		else {\r			var array = dato[1].split(\"|\");		\r			var oid = array[0];\r			var cod = array[1];      \r			set(\"formulario.oidCodigoProducto\", oid);      \r			set(\"formulario.txtCodProducto5\", cod);\r		}\r    }\r}\r   \r \r"));
      ((Element)v.get(6)).appendChild((Text)v.get(7));

      /* Termina nodo Texto:7   */
      /* Termina nodo:6   */

      /* Empieza nodo:8 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(8));

      /* Empieza nodo:9 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","cbMarca" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","6" );
      ((Element)v.get(8)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */
      /* Termina nodo:8   */

      /* Empieza nodo:10 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(10)).setAttribute("nombre","formulario" );
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
      ((Element)v.get(15)).setAttribute("nombre","varPais" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","varIdioma" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","oidCodigoProducto" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","datosObligatorios" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","idPestanyaDest" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 10   */
      v.add(doc.createElement("table"));
      ((Element)v.get(22)).setAttribute("width","100%" );
      ((Element)v.get(22)).setAttribute("border","0" );
      ((Element)v.get(22)).setAttribute("cellspacing","0" );
      ((Element)v.get(22)).setAttribute("cellpadding","0" );
      ((Element)v.get(10)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("tr"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(22)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(24)).setAttribute("width","12" );
      ((Element)v.get(24)).setAttribute("align","center" );
      ((Element)v.get(23)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(25)).setAttribute("src","b.gif" );
      ((Element)v.get(25)).setAttribute("width","12" );
      ((Element)v.get(25)).setAttribute("height","12" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */
      /* Termina nodo:24   */

      /* Empieza nodo:26 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).setAttribute("width","750" );
      ((Element)v.get(23)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(27)).setAttribute("src","b.gif" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */
      /* Termina nodo:26   */

      /* Empieza nodo:28 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(28)).setAttribute("width","12" );
      ((Element)v.get(23)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(29)).setAttribute("src","b.gif" );
      ((Element)v.get(29)).setAttribute("width","12" );
      ((Element)v.get(29)).setAttribute("height","1" );
      ((Element)v.get(28)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */
      /* Termina nodo:28   */
      /* Termina nodo:23   */

      /* Empieza nodo:30 / Elemento padre: 22   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(22)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("td"));
      ((Element)v.get(30)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(32)).setAttribute("src","b.gif" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */
      /* Termina nodo:31   */

      /* Empieza nodo:33 / Elemento padre: 30   */
      v.add(doc.createElement("td"));
      ((Element)v.get(30)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(35)).setAttribute("class","legend" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(36)).setAttribute("nombre","lblProductosExigidosPremiacion" );
      ((Element)v.get(36)).setAttribute("alto","13" );
      ((Element)v.get(36)).setAttribute("filas","1" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(36)).setAttribute("id","legend" );
      ((Element)v.get(36)).setAttribute("cod","00361" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */
      /* Termina nodo:35   */

      /* Empieza nodo:37 / Elemento padre: 34   */
      v.add(doc.createElement("table"));
      ((Element)v.get(37)).setAttribute("width","100%" );
      ((Element)v.get(37)).setAttribute("border","0" );
      ((Element)v.get(37)).setAttribute("align","center" );
      ((Element)v.get(37)).setAttribute("cellspacing","0" );
      ((Element)v.get(37)).setAttribute("cellpadding","0" );
      ((Element)v.get(34)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("td"));
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("table"));
      ((Element)v.get(40)).setAttribute("width","706" );
      ((Element)v.get(40)).setAttribute("border","0" );
      ((Element)v.get(40)).setAttribute("align","left" );
      ((Element)v.get(40)).setAttribute("cellspacing","0" );
      ((Element)v.get(40)).setAttribute("cellpadding","0" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).setAttribute("colspan","4" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(43)).setAttribute("src","b.gif" );
      ((Element)v.get(43)).setAttribute("width","8" );
      ((Element)v.get(43)).setAttribute("height","8" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */
      /* Termina nodo:41   */

      /* Empieza nodo:44 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(46)).setAttribute("src","b.gif" );
      ((Element)v.get(46)).setAttribute("width","8" );
      ((Element)v.get(46)).setAttribute("height","8" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:47 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(48)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(48)).setAttribute("alto","13" );
      ((Element)v.get(48)).setAttribute("filas","1" );
      ((Element)v.get(48)).setAttribute("valor","" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(48)).setAttribute("id","datosTitle" );
      ((Element)v.get(48)).setAttribute("cod","6" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:49 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(50)).setAttribute("src","b.gif" );
      ((Element)v.get(50)).setAttribute("width","25" );
      ((Element)v.get(50)).setAttribute("height","8" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:51 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(52)).setAttribute("nombre","lblUnidadNegocio" );
      ((Element)v.get(52)).setAttribute("alto","13" );
      ((Element)v.get(52)).setAttribute("filas","1" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(52)).setAttribute("id","datosTitle" );
      ((Element)v.get(52)).setAttribute("cod","1338" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:53 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).setAttribute("width","100%" );
      ((Element)v.get(44)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(54)).setAttribute("src","b.gif" );
      ((Element)v.get(54)).setAttribute("width","8" );
      ((Element)v.get(54)).setAttribute("height","8" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */
      /* Termina nodo:44   */

      /* Empieza nodo:55 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(57)).setAttribute("src","b.gif" );
      ((Element)v.get(57)).setAttribute("width","8" );
      ((Element)v.get(57)).setAttribute("height","8" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:58 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(55)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(59)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(59)).setAttribute("id","datosCampos" );
      ((Element)v.get(59)).setAttribute("size","1" );
      ((Element)v.get(59)).setAttribute("multiple","N" );
      ((Element)v.get(59)).setAttribute("req","S" );
      ((Element)v.get(59)).setAttribute("valorinicial","" );
      ((Element)v.get(59)).setAttribute("textoinicial","" );
      ((Element)v.get(59)).setAttribute("onshtab","focoBotonAceptar();" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:61 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(62)).setAttribute("src","b.gif" );
      ((Element)v.get(62)).setAttribute("width","25" );
      ((Element)v.get(62)).setAttribute("height","8" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:63 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(63)).setAttribute("valign","bottom" );
      ((Element)v.get(55)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(64)).setAttribute("nombre","cbUnidadNegocio" );
      ((Element)v.get(64)).setAttribute("id","datosCampos" );
      ((Element)v.get(64)).setAttribute("size","1" );
      ((Element)v.get(64)).setAttribute("multiple","N" );
      ((Element)v.get(64)).setAttribute("req","N" );
      ((Element)v.get(64)).setAttribute("valorinicial","" );
      ((Element)v.get(64)).setAttribute("textoinicial","" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:66 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).setAttribute("width","100%" );
      ((Element)v.get(55)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(67)).setAttribute("src","b.gif" );
      ((Element)v.get(67)).setAttribute("width","8" );
      ((Element)v.get(67)).setAttribute("height","8" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:55   */

      /* Empieza nodo:68 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).setAttribute("colspan","4" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(70)).setAttribute("src","b.gif" );
      ((Element)v.get(70)).setAttribute("width","8" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(70)).setAttribute("height","8" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:40   */
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:71 / Elemento padre: 37   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(37)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("table"));
      ((Element)v.get(73)).setAttribute("width","706" );
      ((Element)v.get(73)).setAttribute("border","0" );
      ((Element)v.get(73)).setAttribute("align","left" );
      ((Element)v.get(73)).setAttribute("cellspacing","0" );
      ((Element)v.get(73)).setAttribute("cellpadding","0" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(76)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).setAttribute("width","8" );
      ((Element)v.get(76)).setAttribute("height","8" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:77 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(78)).setAttribute("nombre","lblNegocio" );
      ((Element)v.get(78)).setAttribute("alto","13" );
      ((Element)v.get(78)).setAttribute("filas","1" );
      ((Element)v.get(78)).setAttribute("valor","" );
      ((Element)v.get(78)).setAttribute("id","datosTitle" );
      ((Element)v.get(78)).setAttribute("cod","588" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:79 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(80)).setAttribute("src","b.gif" );
      ((Element)v.get(80)).setAttribute("width","25" );
      ((Element)v.get(80)).setAttribute("height","8" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:81 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(82)).setAttribute("nombre","lblSupergenerico" );
      ((Element)v.get(82)).setAttribute("alto","13" );
      ((Element)v.get(82)).setAttribute("filas","1" );
      ((Element)v.get(82)).setAttribute("valor","" );
      ((Element)v.get(82)).setAttribute("id","datosTitle" );
      ((Element)v.get(82)).setAttribute("cod","590" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:83 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).setAttribute("width","100%" );
      ((Element)v.get(74)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(84)).setAttribute("src","b.gif" );
      ((Element)v.get(84)).setAttribute("width","8" );
      ((Element)v.get(84)).setAttribute("height","8" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */
      /* Termina nodo:74   */

      /* Empieza nodo:85 / Elemento padre: 73   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(73)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(87)).setAttribute("src","b.gif" );
      ((Element)v.get(87)).setAttribute("width","8" );
      ((Element)v.get(87)).setAttribute("height","8" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:88 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(85)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(89)).setAttribute("nombre","cbNegocio" );
      ((Element)v.get(89)).setAttribute("id","datosCampos" );
      ((Element)v.get(89)).setAttribute("size","1" );
      ((Element)v.get(89)).setAttribute("multiple","N" );
      ((Element)v.get(89)).setAttribute("req","N" );
      ((Element)v.get(89)).setAttribute("valorinicial","" );
      ((Element)v.get(89)).setAttribute("textoinicial","" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */
      /* Termina nodo:88   */

      /* Empieza nodo:91 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(92)).setAttribute("src","b.gif" );
      ((Element)v.get(92)).setAttribute("width","25" );
      ((Element)v.get(92)).setAttribute("height","8" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:93 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(85)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(94)).setAttribute("nombre","cbSupergenerico" );
      ((Element)v.get(94)).setAttribute("id","datosCampos" );
      ((Element)v.get(94)).setAttribute("size","1" );
      ((Element)v.get(94)).setAttribute("multiple","N" );
      ((Element)v.get(94)).setAttribute("req","N" );
      ((Element)v.get(94)).setAttribute("valorinicial","" );
      ((Element)v.get(94)).setAttribute("textoinicial","" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */
      /* Termina nodo:93   */

      /* Empieza nodo:96 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).setAttribute("width","100%" );
      ((Element)v.get(85)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(97)).setAttribute("src","b.gif" );
      ((Element)v.get(97)).setAttribute("width","8" );
      ((Element)v.get(97)).setAttribute("height","8" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */
      /* Termina nodo:85   */

      /* Empieza nodo:98 / Elemento padre: 73   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(73)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).setAttribute("colspan","4" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(100)).setAttribute("src","b.gif" );
      ((Element)v.get(100)).setAttribute("width","8" );
      ((Element)v.get(100)).setAttribute("height","8" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */
      /* Termina nodo:98   */
      /* Termina nodo:73   */
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:101 / Elemento padre: 37   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(37)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(101)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("table"));
      ((Element)v.get(103)).setAttribute("width","706" );
      ((Element)v.get(103)).setAttribute("border","0" );
      ((Element)v.get(103)).setAttribute("align","left" );
      ((Element)v.get(103)).setAttribute("cellspacing","0" );
      ((Element)v.get(103)).setAttribute("cellpadding","0" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(103)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(106)).setAttribute("src","b.gif" );
      ((Element)v.get(106)).setAttribute("width","8" );
      ((Element)v.get(106)).setAttribute("height","8" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:107 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(108)).setAttribute("nombre","lblGenerico" );
      ((Element)v.get(108)).setAttribute("alto","13" );
      ((Element)v.get(108)).setAttribute("filas","1" );
      ((Element)v.get(108)).setAttribute("valor","" );
      ((Element)v.get(108)).setAttribute("id","datosTitle" );
      ((Element)v.get(108)).setAttribute("cod","589" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:109 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(110)).setAttribute("src","b.gif" );
      ((Element)v.get(110)).setAttribute("width","25" );
      ((Element)v.get(110)).setAttribute("height","8" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:111 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).setAttribute("colspan","3" );
      ((Element)v.get(104)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(112)).setAttribute("nombre","lblCodProducto5" );
      ((Element)v.get(112)).setAttribute("alto","13" );
      ((Element)v.get(112)).setAttribute("filas","1" );
      ((Element)v.get(112)).setAttribute("valor","" );
      ((Element)v.get(112)).setAttribute("id","datosTitle" );
      ((Element)v.get(112)).setAttribute("cod","337" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:113 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).setAttribute("width","100%" );
      ((Element)v.get(104)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(114)).setAttribute("src","b.gif" );
      ((Element)v.get(114)).setAttribute("width","8" );
      ((Element)v.get(114)).setAttribute("height","8" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */
      /* Termina nodo:104   */

      /* Empieza nodo:115 / Elemento padre: 103   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(103)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(117)).setAttribute("src","b.gif" );
      ((Element)v.get(117)).setAttribute("width","8" );
      ((Element)v.get(117)).setAttribute("height","8" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:118 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(118)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(115)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(119)).setAttribute("nombre","cbGenerico" );
      ((Element)v.get(119)).setAttribute("id","datosCampos" );
      ((Element)v.get(119)).setAttribute("size","1" );
      ((Element)v.get(119)).setAttribute("multiple","N" );
      ((Element)v.get(119)).setAttribute("req","N" );
      ((Element)v.get(119)).setAttribute("valorinicial","" );
      ((Element)v.get(119)).setAttribute("textoinicial","" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:121 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(122)).setAttribute("src","b.gif" );
      ((Element)v.get(122)).setAttribute("width","25" );
      ((Element)v.get(122)).setAttribute("height","8" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:123 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(123)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(115)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(124)).setAttribute("nombre","txtCodProducto5" );
      ((Element)v.get(124)).setAttribute("id","datosCampos" );
      ((Element)v.get(124)).setAttribute("max","20" );
      ((Element)v.get(124)).setAttribute("tipo","" );
      ((Element)v.get(124)).setAttribute("onchange","" );
      ((Element)v.get(124)).setAttribute("req","N" );
      ((Element)v.get(124)).setAttribute("size","26" );
      ((Element)v.get(124)).setAttribute("valor","" );
      ((Element)v.get(124)).setAttribute("validacion","" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:125 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(126)).setAttribute("src","b.gif" );
      ((Element)v.get(126)).setAttribute("width","8" );
      ((Element)v.get(126)).setAttribute("height","8" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:127 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(128)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(128)).setAttribute("ID","botonContenido" );
      ((Element)v.get(128)).setAttribute("tipo","html" );
      ((Element)v.get(128)).setAttribute("accion","accionBuscarProducto();" );
      ((Element)v.get(128)).setAttribute("estado","false" );
      ((Element)v.get(128)).setAttribute("cod","1" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:129 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).setAttribute("width","100%" );
      ((Element)v.get(115)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(130)).setAttribute("src","b.gif" );
      ((Element)v.get(130)).setAttribute("width","8" );
      ((Element)v.get(130)).setAttribute("height","8" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */
      /* Termina nodo:115   */

      /* Empieza nodo:131 / Elemento padre: 103   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(103)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("td"));
      ((Element)v.get(132)).setAttribute("colspan","4" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(133)).setAttribute("src","b.gif" );
      ((Element)v.get(133)).setAttribute("width","8" );
      ((Element)v.get(133)).setAttribute("height","8" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */
      /* Termina nodo:131   */
      /* Termina nodo:103   */
      /* Termina nodo:102   */
      /* Termina nodo:101   */
      /* Termina nodo:37   */
      /* Termina nodo:34   */
      /* Termina nodo:33   */

      /* Empieza nodo:134 / Elemento padre: 30   */
      v.add(doc.createElement("td"));
      ((Element)v.get(30)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(135)).setAttribute("src","b.gif" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */
      /* Termina nodo:30   */

      /* Empieza nodo:136 / Elemento padre: 22   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(22)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(138)).setAttribute("src","b.gif" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:139 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
   }

   private void getXML540(Document doc) {
      v.add(doc.createElement("table"));
      ((Element)v.get(141)).setAttribute("width","100%" );
      ((Element)v.get(141)).setAttribute("border","0" );
      ((Element)v.get(141)).setAttribute("align","center" );
      ((Element)v.get(141)).setAttribute("cellspacing","0" );
      ((Element)v.get(141)).setAttribute("cellpadding","0" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(141)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(143)).setAttribute("class","botonera" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(144)).setAttribute("nombre","btnAnadir4" );
      ((Element)v.get(144)).setAttribute("ID","botonContenido" );
      ((Element)v.get(144)).setAttribute("tipo","html" );
      ((Element)v.get(144)).setAttribute("accion","accionAnadir();" );
      ((Element)v.get(144)).setAttribute("estado","false" );
      ((Element)v.get(144)).setAttribute("cod","404" );
      ((Element)v.get(144)).setAttribute("ontab","focoBotonAceptar();" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */
      /* Termina nodo:142   */
      /* Termina nodo:141   */
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:145 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(146)).setAttribute("src","b.gif" );
      ((Element)v.get(146)).setAttribute("width","8" );
      ((Element)v.get(146)).setAttribute("height","12" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */
      /* Termina nodo:136   */

      /* Empieza nodo:147 / Elemento padre: 22   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(22)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(148)).setAttribute("width","12" );
      ((Element)v.get(148)).setAttribute("align","center" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(149)).setAttribute("src","b.gif" );
      ((Element)v.get(149)).setAttribute("width","12" );
      ((Element)v.get(149)).setAttribute("height","8" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */

      /* Empieza nodo:150 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).setAttribute("width","756" );
      ((Element)v.get(147)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(151)).setAttribute("src","b.gif" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:152 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(152)).setAttribute("width","12" );
      ((Element)v.get(147)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(153)).setAttribute("src","b.gif" );
      ((Element)v.get(153)).setAttribute("width","12" );
      ((Element)v.get(153)).setAttribute("height","1" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:152   */
      /* Termina nodo:147   */
      /* Termina nodo:22   */

      /* Empieza nodo:154 / Elemento padre: 10   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(154)).setAttribute("nombre","listado1" );
      ((Element)v.get(154)).setAttribute("ancho","710" );
      ((Element)v.get(154)).setAttribute("alto","317" );
      ((Element)v.get(154)).setAttribute("x","12" );
      ((Element)v.get(154)).setAttribute("y","206" );
      ((Element)v.get(154)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(154)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(10)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(155)).setAttribute("precarga","S" );
      ((Element)v.get(155)).setAttribute("conROver","S" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(156)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(156)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(156)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(156)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */

      /* Empieza nodo:157 / Elemento padre: 155   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(157)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(157)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(157)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(157)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(155)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */

      /* Empieza nodo:158 / Elemento padre: 155   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(158)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(158)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(155)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:155   */

      /* Empieza nodo:159 / Elemento padre: 154   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(154)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(160)).setAttribute("borde","1" );
      ((Element)v.get(160)).setAttribute("horizDatos","1" );
      ((Element)v.get(160)).setAttribute("horizCabecera","1" );
      ((Element)v.get(160)).setAttribute("vertical","0" );
      ((Element)v.get(160)).setAttribute("horizTitulo","1" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(160)).setAttribute("horizBase","1" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */

      /* Empieza nodo:161 / Elemento padre: 159   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(161)).setAttribute("borde","#999999" );
      ((Element)v.get(161)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(161)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(161)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(161)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(161)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(161)).setAttribute("horizBase","#999999" );
      ((Element)v.get(159)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:159   */

      /* Empieza nodo:162 / Elemento padre: 154   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(162)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(162)).setAttribute("alto","22" );
      ((Element)v.get(162)).setAttribute("imgFondo","" );
      ((Element)v.get(162)).setAttribute("cod","00362" );
      ((Element)v.get(162)).setAttribute("ID","datosTitle" );
      ((Element)v.get(154)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */

      /* Empieza nodo:163 / Elemento padre: 154   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(163)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(163)).setAttribute("alto","22" );
      ((Element)v.get(163)).setAttribute("imgFondo","" );
      ((Element)v.get(154)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */

      /* Empieza nodo:164 / Elemento padre: 154   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(164)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(164)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(164)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(164)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(164)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(164)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(154)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(165)).setAttribute("ancho","50" );
      ((Element)v.get(165)).setAttribute("minimizable","S" );
      ((Element)v.get(165)).setAttribute("minimizada","N" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */

      /* Empieza nodo:166 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(166)).setAttribute("ancho","80" );
      ((Element)v.get(166)).setAttribute("minimizable","S" );
      ((Element)v.get(166)).setAttribute("minimizada","N" );
      ((Element)v.get(164)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */

      /* Empieza nodo:167 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(167)).setAttribute("ancho","50" );
      ((Element)v.get(167)).setAttribute("minimizable","S" );
      ((Element)v.get(167)).setAttribute("minimizada","N" );
      ((Element)v.get(164)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */

      /* Empieza nodo:168 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(168)).setAttribute("ancho","50" );
      ((Element)v.get(168)).setAttribute("minimizable","S" );
      ((Element)v.get(168)).setAttribute("minimizada","N" );
      ((Element)v.get(164)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */

      /* Empieza nodo:169 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(169)).setAttribute("ancho","50" );
      ((Element)v.get(169)).setAttribute("minimizable","S" );
      ((Element)v.get(169)).setAttribute("minimizada","N" );
      ((Element)v.get(164)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */

      /* Empieza nodo:170 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(170)).setAttribute("ancho","80" );
      ((Element)v.get(170)).setAttribute("minimizable","S" );
      ((Element)v.get(170)).setAttribute("minimizada","N" );
      ((Element)v.get(164)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:164   */

      /* Empieza nodo:171 / Elemento padre: 154   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(171)).setAttribute("alto","20" );
      ((Element)v.get(171)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(171)).setAttribute("imgFondo","" );
      ((Element)v.get(171)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(154)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(172)).setAttribute("colFondo","" );
      ((Element)v.get(172)).setAttribute("ID","EstCab" );
      ((Element)v.get(172)).setAttribute("cod","6" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */

      /* Empieza nodo:173 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(173)).setAttribute("colFondo","" );
      ((Element)v.get(173)).setAttribute("ID","EstCab" );
      ((Element)v.get(173)).setAttribute("cod","1338" );
      ((Element)v.get(171)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */

      /* Empieza nodo:174 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(174)).setAttribute("colFondo","" );
      ((Element)v.get(174)).setAttribute("ID","EstCab" );
      ((Element)v.get(174)).setAttribute("cod","588" );
      ((Element)v.get(171)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */

      /* Empieza nodo:175 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(175)).setAttribute("colFondo","" );
      ((Element)v.get(175)).setAttribute("ID","EstCab" );
      ((Element)v.get(175)).setAttribute("cod","589" );
      ((Element)v.get(171)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */

      /* Empieza nodo:176 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(176)).setAttribute("colFondo","" );
      ((Element)v.get(176)).setAttribute("ID","EstCab" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(176)).setAttribute("cod","590" );
      ((Element)v.get(171)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */

      /* Empieza nodo:177 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(177)).setAttribute("colFondo","" );
      ((Element)v.get(177)).setAttribute("ID","EstCab" );
      ((Element)v.get(177)).setAttribute("cod","337" );
      ((Element)v.get(171)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */
      /* Termina nodo:171   */

      /* Empieza nodo:178 / Elemento padre: 154   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(178)).setAttribute("alto","22" );
      ((Element)v.get(178)).setAttribute("accion","" );
      ((Element)v.get(178)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(178)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(178)).setAttribute("maxSel","-1" );
      ((Element)v.get(178)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(178)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(178)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(178)).setAttribute("onLoad","" );
      ((Element)v.get(178)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(154)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(179)).setAttribute("tipo","texto" );
      ((Element)v.get(179)).setAttribute("ID","EstDat" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */

      /* Empieza nodo:180 / Elemento padre: 178   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(180)).setAttribute("tipo","texto" );
      ((Element)v.get(180)).setAttribute("ID","EstDat2" );
      ((Element)v.get(178)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */

      /* Empieza nodo:181 / Elemento padre: 178   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(181)).setAttribute("tipo","texto" );
      ((Element)v.get(181)).setAttribute("ID","EstDat" );
      ((Element)v.get(178)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */

      /* Empieza nodo:182 / Elemento padre: 178   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(182)).setAttribute("tipo","texto" );
      ((Element)v.get(182)).setAttribute("ID","EstDat2" );
      ((Element)v.get(178)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */

      /* Empieza nodo:183 / Elemento padre: 178   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(183)).setAttribute("tipo","texto" );
      ((Element)v.get(183)).setAttribute("ID","EstDat" );
      ((Element)v.get(178)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */

      /* Empieza nodo:184 / Elemento padre: 178   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(184)).setAttribute("tipo","texto" );
      ((Element)v.get(184)).setAttribute("ID","EstDat2" );
      ((Element)v.get(178)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:178   */

      /* Empieza nodo:185 / Elemento padre: 154   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(154)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */

      /* Empieza nodo:186 / Elemento padre: 154   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(186)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(186)).setAttribute("ancho","710" );
      ((Element)v.get(186)).setAttribute("sep","$" );
      ((Element)v.get(186)).setAttribute("x","12" );
      ((Element)v.get(186)).setAttribute("class","botonera" );
      ((Element)v.get(186)).setAttribute("y","500" );
      ((Element)v.get(186)).setAttribute("control","|" );
      ((Element)v.get(186)).setAttribute("conector","" );
      ((Element)v.get(186)).setAttribute("rowset","" );
      ((Element)v.get(186)).setAttribute("cargainicial","N" );
      ((Element)v.get(154)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(187)).setAttribute("nombre","ret1" );
      ((Element)v.get(187)).setAttribute("x","37" );
      ((Element)v.get(187)).setAttribute("y","504" );
      ((Element)v.get(187)).setAttribute("ID","botonContenido" );
      ((Element)v.get(187)).setAttribute("img","retroceder_on" );
      ((Element)v.get(187)).setAttribute("tipo","0" );
      ((Element)v.get(187)).setAttribute("estado","false" );
      ((Element)v.get(187)).setAttribute("alt","" );
      ((Element)v.get(187)).setAttribute("codigo","" );
      ((Element)v.get(187)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */

      /* Empieza nodo:188 / Elemento padre: 186   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(188)).setAttribute("nombre","ava1" );
      ((Element)v.get(188)).setAttribute("x","52" );
      ((Element)v.get(188)).setAttribute("y","504" );
      ((Element)v.get(188)).setAttribute("ID","botonContenido" );
      ((Element)v.get(188)).setAttribute("img","avanzar_on" );
      ((Element)v.get(188)).setAttribute("tipo","0" );
      ((Element)v.get(188)).setAttribute("estado","false" );
      ((Element)v.get(188)).setAttribute("alt","" );
      ((Element)v.get(188)).setAttribute("codigo","" );
      ((Element)v.get(188)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(186)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:186   */
      /* Termina nodo:154   */

      /* Empieza nodo:189 / Elemento padre: 10   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(189)).setAttribute("nombre","primera1" );
      ((Element)v.get(189)).setAttribute("x","20" );
      ((Element)v.get(189)).setAttribute("y","504" );
      ((Element)v.get(189)).setAttribute("ID","botonContenido" );
      ((Element)v.get(189)).setAttribute("img","primera_on" );
      ((Element)v.get(189)).setAttribute("tipo","-2" );
      ((Element)v.get(189)).setAttribute("estado","false" );
      ((Element)v.get(189)).setAttribute("alt","" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(189)).setAttribute("codigo","" );
      ((Element)v.get(189)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(10)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */

      /* Empieza nodo:190 / Elemento padre: 10   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(190)).setAttribute("nombre","separa" );
      ((Element)v.get(190)).setAttribute("x","59" );
      ((Element)v.get(190)).setAttribute("y","500" );
      ((Element)v.get(190)).setAttribute("ID","botonContenido" );
      ((Element)v.get(190)).setAttribute("img","separa_base" );
      ((Element)v.get(190)).setAttribute("tipo","0" );
      ((Element)v.get(190)).setAttribute("estado","false" );
      ((Element)v.get(190)).setAttribute("alt","" );
      ((Element)v.get(190)).setAttribute("codigo","" );
      ((Element)v.get(190)).setAttribute("accion","" );
      ((Element)v.get(10)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */

      /* Empieza nodo:191 / Elemento padre: 10   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(191)).setAttribute("nombre","btnAceptar" );
      ((Element)v.get(191)).setAttribute("x","13" );
      ((Element)v.get(191)).setAttribute("y","501" );
      ((Element)v.get(191)).setAttribute("ID","botonContenido" );
      ((Element)v.get(191)).setAttribute("tipo","html" );
      ((Element)v.get(191)).setAttribute("estado","false" );
      ((Element)v.get(191)).setAttribute("cod","12" );
      ((Element)v.get(191)).setAttribute("ontab","focoComboMarca();" );
      ((Element)v.get(191)).setAttribute("onshtab","focoBotonAnadir();" );
      ((Element)v.get(191)).setAttribute("accion","accionAceptar();" );
      ((Element)v.get(10)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */

      /* Empieza nodo:192 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(192)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(192)).setAttribute("alto","12" );
      ((Element)v.get(192)).setAttribute("ancho","100%" );
      ((Element)v.get(192)).setAttribute("colorf","" );
      ((Element)v.get(192)).setAttribute("borde","0" );
      ((Element)v.get(192)).setAttribute("imagenf","" );
      ((Element)v.get(192)).setAttribute("repeat","" );
      ((Element)v.get(192)).setAttribute("padding","" );
      ((Element)v.get(192)).setAttribute("visibilidad","visible" );
      ((Element)v.get(192)).setAttribute("contravsb","" );
      ((Element)v.get(192)).setAttribute("x","0" );
      ((Element)v.get(192)).setAttribute("y","523" );
      ((Element)v.get(192)).setAttribute("zindex","" );
      ((Element)v.get(10)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:10   */


   }

}
