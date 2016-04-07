
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_comisiones_datosComision_insertar_detalle  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_comisiones_datosComision_insertar_detalle" );
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
      v.add(doc.createTextNode("\r \r\rfunction onLoadPag(){\r	configurarMenuSecundario(\"formulario\");        \r	muestraLista();	\r\r	cargarLista();\r	var valor = get('formulario.hOpcionMenu');\r\r	if(get('formulario.hOpcionMenu') == 'consultar'){\r		deshabilitarTodo();\r	}\r\r	focoDiasTrasFacturacion();\r}\r\rfunction muestraLista() {\r	DrdEnsanchaConMargenDcho('listado1',24);\r    document.all[\"Cplistado1\"].style.visibility='';\r    document.all[\"CpLin1listado1\"].style.visibility='';\r    document.all[\"CpLin2listado1\"].style.visibility='';\r    document.all[\"CpLin3listado1\"].style.visibility='';\r    document.all[\"CpLin4listado1\"].style.visibility='';\r    document.all[\"separaDiv\"].style.visibility='hidden';\r    document.all[\"primera1Div\"].style.visibility='hidden';\r    document.all[\"ret1Div\"].style.visibility='hidden';\r    document.all[\"ava1Div\"].style.visibility='hidden';\r    document.all[\"EliminarDiv\"].style.visibility='';\r    eval (ON_RSZ);\r}\r\rfunction deshabilitarTodo(){\r	accion('formulario.txtDiasFacturacion','.disabled=true');\r	accion('formulario.txtNumDiasComision','.disabled=true');\r	accion('formulario.txtPorcentajeRecuperacion','.disabled=true');\r	accion('formulario.txtPorcentajeComision','.disabled=true');\r\r		accion('formulario.txtPorcentajeActividad','.disabled=true');\r\r	deshabilitarHabilitarBoton('botonContenido', 'btnAnadir', 'D');\r	deshabilitarHabilitarBoton('botonContenido', 'Eliminar', 'D');\r	deshabilitarHabilitarBoton('botonContenido', 'btnAceptar', 'D');\r}\r\rfunction cargarLista(){\r	var tipoParticipante = get('formulario.hTipoParticipante');\r	var tipoParticipanteCapital = get('formulario.hTipoParticipanteCapital');\r	var tipoParticipanteProvincia = get('formulario.hTipoParticipanteProvincia');\r	var tipoParticipanteFrontera = get('formulario.hTipoParticipanteFrontera');\r	var tramosComisionesCapital = get('formulario.hTramosComisionesCapital');\r	var tramosComisionesProvincia = get('formulario.hTramosComisionesProvincia');\r	var tramosComisionesFrontera = get('formulario.hTramosComisionesFrontera');\r	var hDiasTrasFacturacionCapital = get('formulario.hDiasTrasFacturacionCapital');\r	var hDiasTrasFacturacionProvincia = get('formulario.hDiasTrasFacturacionProvincia');\r	var hDiasTrasFacturacionFrontera = get('formulario.hDiasTrasFacturacionFrontera');\r\r	if(tipoParticipante == tipoParticipanteCapital){\r		pasarDatosLista(tramosComisionesCapital);\r		set(\"formulario.txtDiasFacturacion\", hDiasTrasFacturacionCapital);\r	}\r	else if(tipoParticipante == tipoParticipanteProvincia){\r		pasarDatosLista(tramosComisionesProvincia);\r		set(\"formulario.txtDiasFacturacion\", hDiasTrasFacturacionProvincia);\r	}\r	else if(tipoParticipante == tipoParticipanteFrontera){\r		pasarDatosLista(tramosComisionesFrontera);\r		set(\"formulario.txtDiasFacturacion\", hDiasTrasFacturacionFrontera);\r	}\r}\r\rfunction pasarDatosLista(datos){\r	var ar;\r	var ar2;\r\r	if(datos.length > 0){\r		ar = datos.split('|');\r\r		for(var i = 0; i < ar.length; i++){\r			var s = ar[i];\r			ar2 = s.split('#');\r			listado1.insertar(ar2);\r		}\r	}\r}\r\rfunction btnAnyadirOnClick() {\r	/*	Si se han completado los campos del formulario: \r	N° Días Comision\r	Porcentaje recuperación\r	Porcentaje Comisión\r\r	Validar que \"N° Días Comisión\" no sea igual a otro nivel de tramo ya ingresado\r	Si no es igual a otro nivel de tramo, se añade una línea con sus valores a la lista \"tramos\" \r	Si es igual, se debe presentar el mensaje de error :\r	UICOM0008	(Número de días para comisión no puede ser igual para dos niveles de tramo) */\r\r	var numDiasComision = get('formulario.txtNumDiasComision');\r	var porcentajeRecuperacion = get('formulario.txtPorcentajeRecuperacion');\r	var porcentajeComision = get('formulario.txtPorcentajeComision');\r\r    	var porcentajeActividad = get('formulario.txtPorcentajeActividad');\r\r		if(sicc_validaciones_generales('grupoAnadir')){\r\r				var datos = listado1.datos;\r		for(var i=0; i<datos.length; i++) {\r			var temp = datos[i][2];\r			if(temp==numDiasComision) {\r				GestionarMensaje('UICOM0008',null,null,null);\r				focoDiasComision();\r				return;\r			}\r		}\r		\r		var dat = new Array();\r\r				var a = listado1.datos;\r		var oid;\r\r		if(a != null && a.length > 0){\r			var ind = a.length;\r			var ind2 = ind - 1;\r			var arr = a[ind2];\r			oid = eval(arr[0]) + 1;\r		}else{\r			oid = 1;\r		}\r\r		dat[0] = oid; 		dat[1] = oid; 		dat[2] = numDiasComision;\r		dat[3] = porcentajeRecuperacion;\r		dat[4] = porcentajeComision;\r				dat[5] = porcentajeActividad;\r\r		listado1.insertar(dat);\r\r				set('formulario.txtNumDiasComision', '');\r		set('formulario.txtPorcentajeRecuperacion', '');\r		set('formulario.txtPorcentajeComision', '');\r				set('formulario.txtPorcentajeActividad', '');\r\r		focoDiasComision();\r	}\r}\r\rfunction btnEliminarOnClick() {\r	/*	Se eliminan las líneas de \"tramos\" que halla seleccionado el usuario,\r	renumerando las que hayan quedado de arriba a abajo y numerando desde 1 a n	*/\r\r	if (listado1.numSelecc()== 0) {\r		GestionarMensaje('1021',null,null,null);\r		return;\r    }\r\r	listado1.eliminarSelecc();\r\r	var datos = listado1.datos;\r	var linea;\r	var j;\r\r	if(datos != null && datos.length > 0){\r		for(j = 0; j < datos.length; j++){\r			linea = datos[j];\r			if(linea != null && linea.length > 0){\r				var num = j + 1;\r				linea[0] = num.toString();\r				linea[1] = num.toString();\r			}\r		}\r		listado1.setDatos(datos);\r	}\r}\r\rfunction btnAceptarOnClick() {\r	var diasFacturacion = get('formulario.txtDiasFacturacion');\r	var o = new Object();\r	var datos = listado1.datos;\r	var datoTemp;\r	var sDatoTemp = '';\r	var i;\r\r		if(sicc_validaciones_generales('grupoAceptar')){\r\r				if(datos==\"\") {\r			GestionarMensaje('UICOM0009',null,null,null);\r			focoDiasComision();\r			return;\r		}\r\r		for(i = 0; i < datos.length; i++){\r			datoTemp = datos[i];\r			if(i > 0){\r				sDatoTemp += '|';\r			}\r			sDatoTemp += datoTemp.toString();\r		}\r\r		sDatoTemp = sDatoTemp + \"?\" + diasFacturacion;\r		o.valor = sDatoTemp;\r\r		window.returnValue = o;\r		window.close();\r	}\r}\r\rfunction onTabBotonAnadir() {\r	focalizaBotonHTML('botonContenido','Eliminar');\r}\r\rfunction onTabBotonEliminar() {\r	focalizaBotonHTML('botonContenido','btnAceptar');\r}\r\rfunction onShTabBotonEliminar() {\r	focalizaBotonHTML('botonContenido','btnAnadir');\r}\r\rfunction fVolver(){\r	window.close();\r}\r\rfunction fLimpiar(){\r	focoDiasTrasFacturacion();\r	var arrayVacio = new Array();\r	listado1.setDatos(arrayVacio);\r}\r\rfunction focoDiasTrasFacturacion() {\r	focaliza(\"formulario.txtDiasFacturacion\");\r}\r\rfunction focoDiasComision() {\r	focaliza(\"formulario.txtNumDiasComision\");\r}\r   \r \r\r"));
      ((Element)v.get(5)).appendChild((Text)v.get(6));

      /* Termina nodo Texto:6   */
      /* Termina nodo:5   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","txtDiasFacturacion" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("group","grupoAceptar" );
      ((Element)v.get(8)).setAttribute("cod","1729" );
      ((Element)v.get(8)).setAttribute("format","e" );
      ((Element)v.get(8)).setAttribute("min","0" );
      ((Element)v.get(8)).setAttribute("max","999" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","txtNumDiasComision" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("group","grupoAnadir" );
      ((Element)v.get(9)).setAttribute("cod","1730" );
      ((Element)v.get(9)).setAttribute("format","e" );
      ((Element)v.get(9)).setAttribute("min","0" );
      ((Element)v.get(9)).setAttribute("max","999" );
      ((Element)v.get(7)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","txtPorcentajeRecuperacion" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("group","grupoAnadir" );
      ((Element)v.get(10)).setAttribute("cod","2278" );
      ((Element)v.get(10)).setAttribute("format","n" );
      ((Element)v.get(10)).setAttribute("min","0" );
      ((Element)v.get(10)).setAttribute("max","999.99" );
      ((Element)v.get(7)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","txtPorcentajeComision" );
      ((Element)v.get(11)).setAttribute("required","true" );
      ((Element)v.get(11)).setAttribute("group","grupoAnadir" );
      ((Element)v.get(11)).setAttribute("cod","2279" );
      ((Element)v.get(11)).setAttribute("format","n" );
      ((Element)v.get(11)).setAttribute("min","0" );
      ((Element)v.get(11)).setAttribute("max","999.99" );
      ((Element)v.get(7)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","txtPorcentajeActividad" );
      ((Element)v.get(12)).setAttribute("required","false" );
      ((Element)v.get(12)).setAttribute("group","grupoAnadir" );
      ((Element)v.get(12)).setAttribute("cod","3442" );
      ((Element)v.get(12)).setAttribute("format","n" );
      ((Element)v.get(12)).setAttribute("min","0" );
      ((Element)v.get(12)).setAttribute("max","9999999.99" );
      ((Element)v.get(7)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */
      /* Termina nodo:7   */

      /* Empieza nodo:13 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(13)).setAttribute("nombre","formulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(13));

      /* Empieza nodo:14 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","titulo" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","accion" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","errCodigo" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","varPais" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","varIdioma" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hOpcionMenu" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","hTramosComisionesCapital" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","hTramosComisionesProvincia" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","hTramosComisionesFrontera" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hTipoParticipante" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hTipoParticipanteCapital" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hTipoParticipanteProvincia" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hTipoParticipanteFrontera" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","hDiasTrasFacturacionCapital" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hDiasTrasFacturacionProvincia" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","hDiasTrasFacturacionFrontera" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","tituloFrame" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 13   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(33)).setAttribute("nombre","capa1" );
      ((Element)v.get(13)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("table"));
      ((Element)v.get(34)).setAttribute("width","100%" );
      ((Element)v.get(34)).setAttribute("border","0" );
      ((Element)v.get(34)).setAttribute("cellspacing","0" );
      ((Element)v.get(34)).setAttribute("cellpadding","0" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("td"));
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(37)).setAttribute("src","b.gif" );
      ((Element)v.get(37)).setAttribute("width","12" );
      ((Element)v.get(37)).setAttribute("height","12" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:38 / Elemento padre: 35   */
      v.add(doc.createElement("td"));
      ((Element)v.get(38)).setAttribute("width","750" );
      ((Element)v.get(35)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(39)).setAttribute("src","b.gif" );
      ((Element)v.get(39)).setAttribute("width","1" );
      ((Element)v.get(39)).setAttribute("height","1" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:40 / Elemento padre: 35   */
      v.add(doc.createElement("td"));
      ((Element)v.get(35)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
   }

   private void getXML180(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(41)).setAttribute("src","b.gif" );
      ((Element)v.get(41)).setAttribute("width","12" );
      ((Element)v.get(41)).setAttribute("height","12" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:40   */
      /* Termina nodo:35   */

      /* Empieza nodo:42 / Elemento padre: 34   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(34)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).setAttribute("width","12" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(44)).setAttribute("src","b.gif" );
      ((Element)v.get(44)).setAttribute("width","12" );
      ((Element)v.get(44)).setAttribute("height","12" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */
      /* Termina nodo:43   */

      /* Empieza nodo:45 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(45)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(47)).setAttribute("class","legend" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(48)).setAttribute("nombre","lblDatos" );
      ((Element)v.get(48)).setAttribute("alto","13" );
      ((Element)v.get(48)).setAttribute("filas","1" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(48)).setAttribute("id","legend" );
      ((Element)v.get(48)).setAttribute("cod","00548" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:49 / Elemento padre: 46   */
      v.add(doc.createElement("table"));
      ((Element)v.get(49)).setAttribute("width","100%" );
      ((Element)v.get(49)).setAttribute("border","0" );
      ((Element)v.get(49)).setAttribute("align","center" );
      ((Element)v.get(49)).setAttribute("cellspacing","0" );
      ((Element)v.get(49)).setAttribute("cellpadding","0" );
      ((Element)v.get(46)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(49)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("table"));
      ((Element)v.get(52)).setAttribute("width","587" );
      ((Element)v.get(52)).setAttribute("border","0" );
      ((Element)v.get(52)).setAttribute("align","left" );
      ((Element)v.get(52)).setAttribute("cellspacing","0" );
      ((Element)v.get(52)).setAttribute("cellpadding","0" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).setAttribute("colspan","4" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(55)).setAttribute("src","b.gif" );
      ((Element)v.get(55)).setAttribute("width","8" );
      ((Element)v.get(55)).setAttribute("height","8" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:54   */
      /* Termina nodo:53   */

      /* Empieza nodo:56 / Elemento padre: 52   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(52)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(58)).setAttribute("src","b.gif" );
      ((Element)v.get(58)).setAttribute("width","8" );
      ((Element)v.get(58)).setAttribute("height","8" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:59 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(60)).setAttribute("nombre","lblDiasFacturacion" );
      ((Element)v.get(60)).setAttribute("alto","13" );
      ((Element)v.get(60)).setAttribute("filas","1" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(60)).setAttribute("id","datosTitle" );
      ((Element)v.get(60)).setAttribute("cod","1729" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:61 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).setAttribute("width","100%" );
      ((Element)v.get(56)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(62)).setAttribute("src","b.gif" );
      ((Element)v.get(62)).setAttribute("width","8" );
      ((Element)v.get(62)).setAttribute("height","8" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */
      /* Termina nodo:56   */

      /* Empieza nodo:63 / Elemento padre: 52   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(52)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(65)).setAttribute("src","b.gif" );
      ((Element)v.get(65)).setAttribute("width","8" );
      ((Element)v.get(65)).setAttribute("height","8" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:66 / Elemento padre: 63   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(63)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(67)).setAttribute("nombre","txtDiasFacturacion" );
      ((Element)v.get(67)).setAttribute("id","datosCampos" );
      ((Element)v.get(67)).setAttribute("max","3" );
      ((Element)v.get(67)).setAttribute("tipo","" );
      ((Element)v.get(67)).setAttribute("onchange","" );
      ((Element)v.get(67)).setAttribute("req","S" );
      ((Element)v.get(67)).setAttribute("size","3" );
      ((Element)v.get(67)).setAttribute("valor","" );
      ((Element)v.get(67)).setAttribute("validacion","" );
      ((Element)v.get(67)).setAttribute("onshtab","onTabBotonEliminar();" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:63   */

      /* Empieza nodo:68 / Elemento padre: 52   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(52)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).setAttribute("colspan","4" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(70)).setAttribute("src","b.gif" );
      ((Element)v.get(70)).setAttribute("width","8" );
      ((Element)v.get(70)).setAttribute("height","8" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:52   */
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:71 / Elemento padre: 49   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(49)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("table"));
      ((Element)v.get(73)).setAttribute("width","100%" );
      ((Element)v.get(73)).setAttribute("border","0" );
      ((Element)v.get(73)).setAttribute("align","center" );
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
      ((Element)v.get(77)).setAttribute("width","100%" );
      ((Element)v.get(74)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("table"));
      ((Element)v.get(78)).setAttribute("width","100%" );
      ((Element)v.get(78)).setAttribute("border","0" );
      ((Element)v.get(78)).setAttribute("cellspacing","0" );
      ((Element)v.get(78)).setAttribute("cellpadding","0" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(78)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(80)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(82)).setAttribute("class","legend" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(83)).setAttribute("nombre","lblDatosAnadir" );
      ((Element)v.get(83)).setAttribute("alto","13" );
      ((Element)v.get(83)).setAttribute("filas","1" );
      ((Element)v.get(83)).setAttribute("valor","" );
      ((Element)v.get(83)).setAttribute("id","legend" );
      ((Element)v.get(83)).setAttribute("cod","00280" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */

      /* Empieza nodo:84 / Elemento padre: 81   */
      v.add(doc.createElement("table"));
      ((Element)v.get(84)).setAttribute("width","100%" );
      ((Element)v.get(84)).setAttribute("border","0" );
      ((Element)v.get(84)).setAttribute("align","center" );
      ((Element)v.get(84)).setAttribute("cellspacing","0" );
      ((Element)v.get(84)).setAttribute("cellpadding","0" );
      ((Element)v.get(81)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(84)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("table"));
      ((Element)v.get(87)).setAttribute("width","575" );
      ((Element)v.get(87)).setAttribute("border","0" );
      ((Element)v.get(87)).setAttribute("align","left" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(87)).setAttribute("cellspacing","0" );
      ((Element)v.get(87)).setAttribute("cellpadding","0" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(87)).appendChild((Element)v.get(88));

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

      /* Empieza nodo:91 / Elemento padre: 87   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(87)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(93)).setAttribute("src","b.gif" );
      ((Element)v.get(93)).setAttribute("width","8" );
      ((Element)v.get(93)).setAttribute("height","8" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:94 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(95)).setAttribute("nombre","lblNumDiasComision" );
      ((Element)v.get(95)).setAttribute("alto","13" );
      ((Element)v.get(95)).setAttribute("filas","1" );
      ((Element)v.get(95)).setAttribute("valor","" );
      ((Element)v.get(95)).setAttribute("id","datosTitle" );
      ((Element)v.get(95)).setAttribute("cod","1730" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:96 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(97)).setAttribute("src","b.gif" );
      ((Element)v.get(97)).setAttribute("width","25" );
      ((Element)v.get(97)).setAttribute("height","8" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:98 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(99)).setAttribute("nombre","lblPorcentajeRecuperacion" );
      ((Element)v.get(99)).setAttribute("alto","13" );
      ((Element)v.get(99)).setAttribute("filas","1" );
      ((Element)v.get(99)).setAttribute("valor","" );
      ((Element)v.get(99)).setAttribute("id","datosTitle" );
      ((Element)v.get(99)).setAttribute("cod","2278" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:100 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(101)).setAttribute("src","b.gif" );
      ((Element)v.get(101)).setAttribute("width","25" );
      ((Element)v.get(101)).setAttribute("height","8" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:102 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(103)).setAttribute("nombre","lblPorcentajeComision" );
      ((Element)v.get(103)).setAttribute("alto","13" );
      ((Element)v.get(103)).setAttribute("filas","1" );
      ((Element)v.get(103)).setAttribute("valor","" );
      ((Element)v.get(103)).setAttribute("id","datosTitle" );
      ((Element)v.get(103)).setAttribute("cod","2279" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:104 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(105)).setAttribute("src","b.gif" );
      ((Element)v.get(105)).setAttribute("width","25" );
      ((Element)v.get(105)).setAttribute("height","8" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:106 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(107)).setAttribute("nombre","lblPorcentajeActividad" );
      ((Element)v.get(107)).setAttribute("alto","13" );
      ((Element)v.get(107)).setAttribute("filas","1" );
      ((Element)v.get(107)).setAttribute("valor","" );
      ((Element)v.get(107)).setAttribute("id","datosTitle" );
      ((Element)v.get(107)).setAttribute("cod","3442" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */

      /* Empieza nodo:108 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).setAttribute("width","100%" );
      ((Element)v.get(91)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(109)).setAttribute("src","b.gif" );
      ((Element)v.get(109)).setAttribute("width","8" );
      ((Element)v.get(109)).setAttribute("height","8" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */
      /* Termina nodo:91   */

      /* Empieza nodo:110 / Elemento padre: 87   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(87)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(112)).setAttribute("src","b.gif" );
      ((Element)v.get(112)).setAttribute("width","8" );
      ((Element)v.get(112)).setAttribute("height","8" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:113 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(110)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(114)).setAttribute("nombre","txtNumDiasComision" );
      ((Element)v.get(114)).setAttribute("id","datosCampos" );
      ((Element)v.get(114)).setAttribute("max","3" );
      ((Element)v.get(114)).setAttribute("tipo","" );
      ((Element)v.get(114)).setAttribute("onchange","" );
      ((Element)v.get(114)).setAttribute("req","S" );
      ((Element)v.get(114)).setAttribute("size","3" );
      ((Element)v.get(114)).setAttribute("valor","" );
      ((Element)v.get(114)).setAttribute("validacion","" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:115 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(116)).setAttribute("src","b.gif" );
      ((Element)v.get(116)).setAttribute("width","25" );
      ((Element)v.get(116)).setAttribute("height","8" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:117 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(117)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(110)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(118)).setAttribute("nombre","txtPorcentajeRecuperacion" );
      ((Element)v.get(118)).setAttribute("id","datosCampos" );
      ((Element)v.get(118)).setAttribute("max","6" );
      ((Element)v.get(118)).setAttribute("tipo","" );
      ((Element)v.get(118)).setAttribute("onchange","" );
      ((Element)v.get(118)).setAttribute("req","S" );
      ((Element)v.get(118)).setAttribute("size","6" );
      ((Element)v.get(118)).setAttribute("valor","" );
      ((Element)v.get(118)).setAttribute("validacion","" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:119 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(120)).setAttribute("src","b.gif" );
      ((Element)v.get(120)).setAttribute("width","25" );
      ((Element)v.get(120)).setAttribute("height","8" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */

      /* Empieza nodo:121 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(121)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(110)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(122)).setAttribute("nombre","txtPorcentajeComision" );
      ((Element)v.get(122)).setAttribute("id","datosCampos" );
      ((Element)v.get(122)).setAttribute("max","6" );
      ((Element)v.get(122)).setAttribute("tipo","" );
      ((Element)v.get(122)).setAttribute("onchange","" );
      ((Element)v.get(122)).setAttribute("req","S" );
      ((Element)v.get(122)).setAttribute("size","6" );
      ((Element)v.get(122)).setAttribute("valor","" );
      ((Element)v.get(122)).setAttribute("validacion","" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:123 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(124)).setAttribute("src","b.gif" );
      ((Element)v.get(124)).setAttribute("width","25" );
      ((Element)v.get(124)).setAttribute("height","8" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:125 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(110)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(126)).setAttribute("nombre","txtPorcentajeActividad" );
      ((Element)v.get(126)).setAttribute("id","datosCampos" );
      ((Element)v.get(126)).setAttribute("max","10" );
      ((Element)v.get(126)).setAttribute("tipo","" );
      ((Element)v.get(126)).setAttribute("onchange","" );
      ((Element)v.get(126)).setAttribute("req","S" );
      ((Element)v.get(126)).setAttribute("size","10" );
      ((Element)v.get(126)).setAttribute("valor","" );
      ((Element)v.get(126)).setAttribute("validacion","" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:127 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).setAttribute("width","100%" );
      ((Element)v.get(110)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
   }

   private void getXML540(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(128)).setAttribute("src","b.gif" );
      ((Element)v.get(128)).setAttribute("width","8" );
      ((Element)v.get(128)).setAttribute("height","8" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */
      /* Termina nodo:110   */

      /* Empieza nodo:129 / Elemento padre: 87   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(87)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).setAttribute("colspan","4" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(131)).setAttribute("src","b.gif" );
      ((Element)v.get(131)).setAttribute("width","8" );
      ((Element)v.get(131)).setAttribute("height","8" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */
      /* Termina nodo:129   */
      /* Termina nodo:87   */
      /* Termina nodo:86   */
      /* Termina nodo:85   */
      /* Termina nodo:84   */
      /* Termina nodo:81   */
      /* Termina nodo:80   */
      /* Termina nodo:79   */
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:132 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(133)).setAttribute("src","b.gif" );
      ((Element)v.get(133)).setAttribute("width","8" );
      ((Element)v.get(133)).setAttribute("height","8" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */
      /* Termina nodo:74   */

      /* Empieza nodo:134 / Elemento padre: 73   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(73)).appendChild((Element)v.get(134));

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
      v.add(doc.createElement("table"));
      ((Element)v.get(139)).setAttribute("width","100%" );
      ((Element)v.get(139)).setAttribute("border","0" );
      ((Element)v.get(139)).setAttribute("align","center" );
      ((Element)v.get(139)).setAttribute("cellspacing","0" );
      ((Element)v.get(139)).setAttribute("cellpadding","0" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("td"));
      ((Element)v.get(141)).setAttribute("class","botonera" );
      ((Element)v.get(141)).setAttribute("width","100%" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(142)).setAttribute("nombre","btnAnadir" );
      ((Element)v.get(142)).setAttribute("ID","botonContenido" );
      ((Element)v.get(142)).setAttribute("tipo","html" );
      ((Element)v.get(142)).setAttribute("accion","btnAnyadirOnClick();" );
      ((Element)v.get(142)).setAttribute("estado","false" );
      ((Element)v.get(142)).setAttribute("cod","404" );
      ((Element)v.get(142)).setAttribute("ontab","onTabBotonAnadir();" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */
      /* Termina nodo:140   */
      /* Termina nodo:139   */
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:143 / Elemento padre: 134   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(144)).setAttribute("src","b.gif" );
      ((Element)v.get(144)).setAttribute("width","12" );
      ((Element)v.get(144)).setAttribute("height","12" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */
      /* Termina nodo:134   */

      /* Empieza nodo:145 / Elemento padre: 73   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(73)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).setAttribute("colspan","4" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(147)).setAttribute("src","b.gif" );
      ((Element)v.get(147)).setAttribute("width","8" );
      ((Element)v.get(147)).setAttribute("height","339" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:146   */
      /* Termina nodo:145   */
      /* Termina nodo:73   */
      /* Termina nodo:72   */
      /* Termina nodo:71   */
      /* Termina nodo:49   */
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:148 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(149)).setAttribute("src","b.gif" );
      ((Element)v.get(149)).setAttribute("width","12" );
      ((Element)v.get(149)).setAttribute("height","12" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */
      /* Termina nodo:42   */

      /* Empieza nodo:150 / Elemento padre: 34   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(34)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(152)).setAttribute("src","b.gif" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:151   */

      /* Empieza nodo:153 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(153)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
   }

   private void getXML630(Document doc) {
      v.add(doc.createElement("table"));
      ((Element)v.get(155)).setAttribute("width","100%" );
      ((Element)v.get(155)).setAttribute("border","0" );
      ((Element)v.get(155)).setAttribute("align","center" );
      ((Element)v.get(155)).setAttribute("cellspacing","0" );
      ((Element)v.get(155)).setAttribute("cellpadding","0" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(155)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("td"));
      ((Element)v.get(157)).setAttribute("class","botonera" );
      ((Element)v.get(157)).setAttribute("width","100%" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(158)).setAttribute("nombre","btnAceptar" );
      ((Element)v.get(158)).setAttribute("ID","botonContenido" );
      ((Element)v.get(158)).setAttribute("tipo","html" );
      ((Element)v.get(158)).setAttribute("accion","btnAceptarOnClick();" );
      ((Element)v.get(158)).setAttribute("estado","false" );
      ((Element)v.get(158)).setAttribute("cod","12" );
      ((Element)v.get(158)).setAttribute("ontab","focoDiasTrasFacturacion();" );
      ((Element)v.get(158)).setAttribute("onshtab","onTabBotonAnadir();" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */
      /* Termina nodo:156   */
      /* Termina nodo:155   */
      /* Termina nodo:154   */
      /* Termina nodo:153   */

      /* Empieza nodo:159 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(160)).setAttribute("src","b.gif" );
      ((Element)v.get(160)).setAttribute("width","12" );
      ((Element)v.get(160)).setAttribute("height","12" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:159   */
      /* Termina nodo:150   */

      /* Empieza nodo:161 / Elemento padre: 34   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(34)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(162)).setAttribute("width","12" );
      ((Element)v.get(162)).setAttribute("align","center" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(163)).setAttribute("src","b.gif" );
      ((Element)v.get(163)).setAttribute("width","12" );
      ((Element)v.get(163)).setAttribute("height","12" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */

      /* Empieza nodo:164 / Elemento padre: 161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(164)).setAttribute("width","750" );
      ((Element)v.get(161)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(165)).setAttribute("src","b.gif" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:164   */

      /* Empieza nodo:166 / Elemento padre: 161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(166)).setAttribute("width","12" );
      ((Element)v.get(161)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(167)).setAttribute("src","b.gif" );
      ((Element)v.get(167)).setAttribute("width","12" );
      ((Element)v.get(167)).setAttribute("height","12" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:166   */
      /* Termina nodo:161   */
      /* Termina nodo:34   */
      /* Termina nodo:33   */

      /* Empieza nodo:168 / Elemento padre: 13   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(168)).setAttribute("nombre","listado1" );
      ((Element)v.get(168)).setAttribute("ancho","576" );
      ((Element)v.get(168)).setAttribute("alto","300" );
      ((Element)v.get(168)).setAttribute("x","24" );
      ((Element)v.get(168)).setAttribute("y","191" );
      ((Element)v.get(168)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(168)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(13)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(169)).setAttribute("precarga","S" );
      ((Element)v.get(169)).setAttribute("conROver","S" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(170)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(170)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(170)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(170)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */

      /* Empieza nodo:171 / Elemento padre: 169   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(171)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(171)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(171)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(171)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(169)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */

      /* Empieza nodo:172 / Elemento padre: 169   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(172)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(172)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(169)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:169   */

      /* Empieza nodo:173 / Elemento padre: 168   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(168)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(174)).setAttribute("borde","1" );
      ((Element)v.get(174)).setAttribute("horizDatos","1" );
      ((Element)v.get(174)).setAttribute("horizCabecera","1" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(174)).setAttribute("vertical","0" );
      ((Element)v.get(174)).setAttribute("horizTitulo","1" );
      ((Element)v.get(174)).setAttribute("horizBase","1" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */

      /* Empieza nodo:175 / Elemento padre: 173   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(175)).setAttribute("borde","#999999" );
      ((Element)v.get(175)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(175)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(175)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(175)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(175)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(175)).setAttribute("horizBase","#999999" );
      ((Element)v.get(173)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:173   */

      /* Empieza nodo:176 / Elemento padre: 168   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(176)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(176)).setAttribute("alto","22" );
      ((Element)v.get(176)).setAttribute("imgFondo","" );
      ((Element)v.get(176)).setAttribute("cod","00346" );
      ((Element)v.get(176)).setAttribute("ID","datosTitle" );
      ((Element)v.get(168)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */

      /* Empieza nodo:177 / Elemento padre: 168   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(177)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(177)).setAttribute("alto","22" );
      ((Element)v.get(177)).setAttribute("imgFondo","" );
      ((Element)v.get(168)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */

      /* Empieza nodo:178 / Elemento padre: 168   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(178)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(178)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(178)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(178)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(178)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(178)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(168)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(179)).setAttribute("ancho","20" );
      ((Element)v.get(179)).setAttribute("minimizable","S" );
      ((Element)v.get(179)).setAttribute("minimizada","N" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */

      /* Empieza nodo:180 / Elemento padre: 178   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(180)).setAttribute("ancho","30" );
      ((Element)v.get(180)).setAttribute("minimizable","S" );
      ((Element)v.get(180)).setAttribute("minimizada","N" );
      ((Element)v.get(178)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */

      /* Empieza nodo:181 / Elemento padre: 178   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(181)).setAttribute("ancho","60" );
      ((Element)v.get(181)).setAttribute("minimizable","S" );
      ((Element)v.get(181)).setAttribute("minimizada","N" );
      ((Element)v.get(178)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */

      /* Empieza nodo:182 / Elemento padre: 178   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(182)).setAttribute("ancho","50" );
      ((Element)v.get(182)).setAttribute("minimizable","S" );
      ((Element)v.get(182)).setAttribute("minimizada","N" );
      ((Element)v.get(178)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */

      /* Empieza nodo:183 / Elemento padre: 178   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(183)).setAttribute("ancho","50" );
      ((Element)v.get(183)).setAttribute("minimizable","S" );
      ((Element)v.get(183)).setAttribute("minimizada","N" );
      ((Element)v.get(178)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:178   */

      /* Empieza nodo:184 / Elemento padre: 168   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(184)).setAttribute("alto","20" );
      ((Element)v.get(184)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(184)).setAttribute("imgFondo","" );
      ((Element)v.get(184)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(168)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(185)).setAttribute("colFondo","" );
      ((Element)v.get(185)).setAttribute("ID","EstCab" );
      ((Element)v.get(185)).setAttribute("align","center" );
      ((Element)v.get(185)).setAttribute("cod","1871" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */

      /* Empieza nodo:186 / Elemento padre: 184   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(186)).setAttribute("colFondo","" );
      ((Element)v.get(186)).setAttribute("ID","EstCab" );
      ((Element)v.get(186)).setAttribute("cod","1730" );
      ((Element)v.get(184)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */

      /* Empieza nodo:187 / Elemento padre: 184   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(187)).setAttribute("colFondo","" );
      ((Element)v.get(187)).setAttribute("ID","EstCab" );
      ((Element)v.get(187)).setAttribute("cod","2278" );
      ((Element)v.get(184)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */

      /* Empieza nodo:188 / Elemento padre: 184   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(188)).setAttribute("colFondo","" );
      ((Element)v.get(188)).setAttribute("ID","EstCab" );
      ((Element)v.get(188)).setAttribute("cod","2279" );
      ((Element)v.get(184)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */

      /* Empieza nodo:189 / Elemento padre: 184   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(189)).setAttribute("colFondo","" );
      ((Element)v.get(189)).setAttribute("ID","EstCab" );
      ((Element)v.get(189)).setAttribute("cod","3442" );
      ((Element)v.get(184)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */
      /* Termina nodo:184   */

      /* Empieza nodo:190 / Elemento padre: 168   */
   }

   private void getXML810(Document doc) {
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(190)).setAttribute("alto","22" );
      ((Element)v.get(190)).setAttribute("accion","" );
      ((Element)v.get(190)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(190)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(190)).setAttribute("maxSel","-1" );
      ((Element)v.get(190)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(190)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(190)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(190)).setAttribute("onLoad","" );
      ((Element)v.get(190)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(168)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(191)).setAttribute("tipo","texto" );
      ((Element)v.get(191)).setAttribute("ID","EstDat" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */

      /* Empieza nodo:192 / Elemento padre: 190   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(192)).setAttribute("tipo","texto" );
      ((Element)v.get(192)).setAttribute("ID","EstDat2" );
      ((Element)v.get(190)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */

      /* Empieza nodo:193 / Elemento padre: 190   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(193)).setAttribute("tipo","texto" );
      ((Element)v.get(193)).setAttribute("ID","EstDat" );
      ((Element)v.get(190)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */

      /* Empieza nodo:194 / Elemento padre: 190   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(194)).setAttribute("tipo","texto" );
      ((Element)v.get(194)).setAttribute("ID","EstDat2" );
      ((Element)v.get(190)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */

      /* Empieza nodo:195 / Elemento padre: 190   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(195)).setAttribute("tipo","texto" );
      ((Element)v.get(195)).setAttribute("ID","EstDat" );
      ((Element)v.get(190)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:190   */

      /* Empieza nodo:196 / Elemento padre: 168   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(168)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */

      /* Empieza nodo:197 / Elemento padre: 168   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(197)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(197)).setAttribute("ancho","576" );
      ((Element)v.get(197)).setAttribute("sep","$" );
      ((Element)v.get(197)).setAttribute("x","12" );
      ((Element)v.get(197)).setAttribute("class","botonera" );
      ((Element)v.get(197)).setAttribute("y","468" );
      ((Element)v.get(197)).setAttribute("control","|" );
      ((Element)v.get(197)).setAttribute("conector","" );
      ((Element)v.get(197)).setAttribute("rowset","" );
      ((Element)v.get(197)).setAttribute("cargainicial","N" );
      ((Element)v.get(168)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(198)).setAttribute("nombre","ret1" );
      ((Element)v.get(198)).setAttribute("x","37" );
      ((Element)v.get(198)).setAttribute("y","472" );
      ((Element)v.get(198)).setAttribute("ID","botonContenido" );
      ((Element)v.get(198)).setAttribute("img","retroceder_on" );
      ((Element)v.get(198)).setAttribute("tipo","0" );
      ((Element)v.get(198)).setAttribute("estado","false" );
      ((Element)v.get(198)).setAttribute("alt","" );
      ((Element)v.get(198)).setAttribute("codigo","" );
      ((Element)v.get(198)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */

      /* Empieza nodo:199 / Elemento padre: 197   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(199)).setAttribute("nombre","ava1" );
      ((Element)v.get(199)).setAttribute("x","52" );
      ((Element)v.get(199)).setAttribute("y","472" );
      ((Element)v.get(199)).setAttribute("ID","botonContenido" );
      ((Element)v.get(199)).setAttribute("img","avanzar_on" );
      ((Element)v.get(199)).setAttribute("tipo","0" );
      ((Element)v.get(199)).setAttribute("estado","false" );
      ((Element)v.get(199)).setAttribute("alt","" );
      ((Element)v.get(199)).setAttribute("codigo","" );
      ((Element)v.get(199)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(197)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */
      /* Termina nodo:197   */
      /* Termina nodo:168   */

      /* Empieza nodo:200 / Elemento padre: 13   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(200)).setAttribute("nombre","primera1" );
      ((Element)v.get(200)).setAttribute("x","20" );
      ((Element)v.get(200)).setAttribute("y","472" );
      ((Element)v.get(200)).setAttribute("ID","botonContenido" );
      ((Element)v.get(200)).setAttribute("img","primera_on" );
      ((Element)v.get(200)).setAttribute("tipo","-2" );
      ((Element)v.get(200)).setAttribute("estado","false" );
      ((Element)v.get(200)).setAttribute("alt","" );
      ((Element)v.get(200)).setAttribute("codigo","" );
      ((Element)v.get(200)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(13)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */

      /* Empieza nodo:201 / Elemento padre: 13   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(201)).setAttribute("nombre","separa" );
      ((Element)v.get(201)).setAttribute("x","59" );
      ((Element)v.get(201)).setAttribute("y","468" );
      ((Element)v.get(201)).setAttribute("ID","botonContenido" );
      ((Element)v.get(201)).setAttribute("img","separa_base" );
      ((Element)v.get(201)).setAttribute("tipo","0" );
      ((Element)v.get(201)).setAttribute("estado","false" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(201)).setAttribute("alt","" );
      ((Element)v.get(201)).setAttribute("codigo","" );
      ((Element)v.get(201)).setAttribute("accion","" );
      ((Element)v.get(13)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */

      /* Empieza nodo:202 / Elemento padre: 13   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(202)).setAttribute("nombre","Eliminar" );
      ((Element)v.get(202)).setAttribute("x","24" );
      ((Element)v.get(202)).setAttribute("y","469" );
      ((Element)v.get(202)).setAttribute("ID","botonContenido" );
      ((Element)v.get(202)).setAttribute("img","separa_base" );
      ((Element)v.get(202)).setAttribute("tipo","html" );
      ((Element)v.get(202)).setAttribute("estado","false" );
      ((Element)v.get(202)).setAttribute("cod","1254" );
      ((Element)v.get(202)).setAttribute("accion","btnEliminarOnClick();" );
      ((Element)v.get(202)).setAttribute("ontab","onTabBotonEliminar();" );
      ((Element)v.get(202)).setAttribute("onshtab","onShTabBotonEliminar();" );
      ((Element)v.get(13)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:13   */


   }

}
