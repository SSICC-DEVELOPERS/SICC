
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_fichas_inscripcion_reimprimir  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         

      getXML180(doc);
         

      getXML270(doc);
         

      getXML360(doc);
         

      getXML450(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_fichas_inscripcion_reimprimir" );
      ((Element)v.get(0)).setAttribute("cod","0320" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","cargarBarra()" );
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
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(3));

      /* Elemento padre:3 / Elemento actual: 4   */
      v.add(doc.createTextNode("\r  \r\r   \r  function onLoadPag2(){\r	DrdEnsanchaConMargenDcho('listado1',24);\r	eval (ON_RSZ);  \r	}\r\r	function mostrarScriptsOcultos(){\r		scriptColl = document.scripts ;\r		for(var u=0;u<scriptColl.length;u++){\r			var temp = scriptColl(u).innerText;\r			alert(temp);\r		}\r	\r	\r	}\r\r  function armarArray()\r  {\r      var hh = new Array();\r      hh[0] = new Array('oidIdioma',get('frmFichasInscripcion.hidIdioma'));\r      hh[1] = new Array('oidPais',get('frmFichasInscripcion.hidPais'));\r\r      return hh;\r  }\r    \r  function cargarBarra(){\r	configurarMenuSecundario(\"frmFichasInscripcion\");\r	DrdEnsanchaConMargenDcho('listado1',24);\r	configurarPaginado(paginadoFichaImpre,\"MAEObtenerFichasInscripcion\",\"ConectorObtenerFichasInscripcion\",\"es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion\", armarArray() );\r	\r	eval (ON_RSZ);  \r	mostrarCodigoError();\r/*	\r	if(get('frmFichasInscripcion.exito').toString()=='S'){\r		fMostrarMensajeExito();\r	}\r*/	\r	focaliza('frmFichasInscripcion.areaMotivosImpresion');\r  }\r\rfunction mostrarCodigoError() {  \r	     \r        var vErrCodigo = get('frmFichasInscripcion.errCodigo');\r        var vErrDescrip = get('frmFichasInscripcion.errDescripcion');\r        if (get('frmFichasInscripcion.errDescripcion')!=''){\r            var wnd = fMostrarMensajeError( vErrCodigo,vErrDescrip);\r     		aceptar();	\r        }\r} \r\rfunction aceptar() {\r         set('frmFichasInscripcion.accion','');\r         set('frmFichasInscripcion.conectorAction','LPReimprimirFichasInscripcion');\r         enviaSICC('frmFichasInscripcion');\r}\r\rfunction reimprimir(){\r	fGuardar();\r}\r\rfunction fGuardar(){\r	var nro = get('frmFichasInscripcion.cbCupCliDisponibles').length;\r	if(	fValidarCTEXT('frmFichasInscripcion.areaMotivosImpresion') ){\r		if (listado1.numSelecc() != 0)\r		  {	\r			var arrAux = new Array();\r			arrAux = listado1.codSeleccionados();\r			set('frmFichasInscripcion.hidCliente',arrAux );\r			set('frmFichasInscripcion.hidMotivo',get('frmFichasInscripcion.areaMotivosImpresion') );\r			set('frmFichasInscripcion.accion','ReimprimirFichas');\r			set('frmFichasInscripcion.conectorAction','LPReimprimirFichasInscripcion');\r			enviaSICC('frmFichasInscripcion');\r		}\r		else {\r			GestionarMensaje('4');\r		}\r	}\r\r}\r\r\r\rfunction fLimpiar(){\r	var codigos = listado1.codigos();\r    var longitud = codigos.length;\r	set('frmFichasInscripcion.areaMotivosImpresion','');\r    for(var i=0;i<longitud;i++) {\r		listado1.deselecciona(i);    \r  }\r\r}\r\rfunction TabUp(){\r	focaliza('frmFichasInscripcion.areaMotivosImpresion');\r}\r\rfunction TabShift(){\r	var obj=document.getElementsByName(\"btnReimprimir\");\r	obj.item(0).focus();\r	\r}\r\r \r"));
      ((Element)v.get(3)).appendChild((Text)v.get(4));

      /* Termina nodo Texto:4   */
      /* Termina nodo:3   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("ESTILO"));
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Elemento padre:5 / Elemento actual: 6   */
      v.add(doc.createTextNode(" \r      #estcomboF {width:170px}  	\r "));
      ((Element)v.get(5)).appendChild((Text)v.get(6));

      /* Termina nodo Texto:6   */
      /* Termina nodo:5   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(7)).setAttribute("nombre","frmFichasInscripcion" );
      ((Element)v.get(0)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","accion" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","hidCliente" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","hidMotivo" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","hidPais" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","hidIdioma" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","exito" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 7   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(17)).setAttribute("nombre","capaContenido" );
      ((Element)v.get(17)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(17)).setAttribute("borde","0" );
      ((Element)v.get(17)).setAttribute("imagenf","" );
      ((Element)v.get(17)).setAttribute("repeat","" );
      ((Element)v.get(17)).setAttribute("padding","" );
      ((Element)v.get(17)).setAttribute("visibilidad","" );
      ((Element)v.get(17)).setAttribute("contravsb","" );
      ((Element)v.get(17)).setAttribute("x","0" );
      ((Element)v.get(17)).setAttribute("y","0" );
      ((Element)v.get(17)).setAttribute("zindex","" );
      ((Element)v.get(7)).appendChild((Element)v.get(17));

      /* Empieza nodo:18 / Elemento padre: 17   */
      v.add(doc.createElement("table"));
      ((Element)v.get(18)).setAttribute("width","100%" );
      ((Element)v.get(18)).setAttribute("border","0" );
      ((Element)v.get(18)).setAttribute("cellspacing","0" );
      ((Element)v.get(18)).setAttribute("cellpadding","0" );
      ((Element)v.get(17)).appendChild((Element)v.get(18));

      /* Empieza nodo:19 / Elemento padre: 18   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(18)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("td"));
      ((Element)v.get(20)).setAttribute("width","12" );
      ((Element)v.get(20)).setAttribute("align","center" );
      ((Element)v.get(19)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(21)).setAttribute("src","b.gif" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(21)).setAttribute("width","12" );
      ((Element)v.get(21)).setAttribute("height","12" );
      ((Element)v.get(20)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */
      /* Termina nodo:20   */

      /* Empieza nodo:22 / Elemento padre: 19   */
      v.add(doc.createElement("td"));
      ((Element)v.get(22)).setAttribute("width","750" );
      ((Element)v.get(19)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(23)).setAttribute("src","b.gif" );
      ((Element)v.get(22)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */
      /* Termina nodo:22   */

      /* Empieza nodo:24 / Elemento padre: 19   */
      v.add(doc.createElement("td"));
      ((Element)v.get(24)).setAttribute("width","12" );
      ((Element)v.get(19)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(25)).setAttribute("src","b.gif" );
      ((Element)v.get(25)).setAttribute("width","12" );
      ((Element)v.get(25)).setAttribute("height","1" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */
      /* Termina nodo:24   */
      /* Termina nodo:19   */

      /* Empieza nodo:26 / Elemento padre: 18   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(18)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(28)).setAttribute("src","b.gif" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */
      /* Termina nodo:27   */

      /* Empieza nodo:29 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(29)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(31)).setAttribute("class","legend" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(32)).setAttribute("nombre","lblFichasInscripcion" );
      ((Element)v.get(32)).setAttribute("alto","13" );
      ((Element)v.get(32)).setAttribute("filas","1" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(32)).setAttribute("id","legend" );
      ((Element)v.get(32)).setAttribute("cod","00139" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */
      /* Termina nodo:31   */

      /* Empieza nodo:33 / Elemento padre: 30   */
      v.add(doc.createElement("table"));
      ((Element)v.get(33)).setAttribute("width","100%" );
      ((Element)v.get(33)).setAttribute("border","0" );
      ((Element)v.get(33)).setAttribute("align","center" );
      ((Element)v.get(33)).setAttribute("cellspacing","0" );
      ((Element)v.get(33)).setAttribute("cellpadding","0" );
      ((Element)v.get(30)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("td"));
      ((Element)v.get(35)).setAttribute("colspan","4" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(36)).setAttribute("src","b.gif" );
      ((Element)v.get(36)).setAttribute("width","8" );
      ((Element)v.get(36)).setAttribute("height","8" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */
      /* Termina nodo:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:37 / Elemento padre: 33   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(33)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(39)).setAttribute("src","b.gif" );
      ((Element)v.get(39)).setAttribute("width","8" );
      ((Element)v.get(39)).setAttribute("height","8" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:40 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(41)).setAttribute("nombre","lblMotivosImpresion" );
      ((Element)v.get(41)).setAttribute("ancho","120" );
      ((Element)v.get(41)).setAttribute("alto","13" );
      ((Element)v.get(41)).setAttribute("filas","1" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(41)).setAttribute("id","datosTitle" );
      ((Element)v.get(41)).setAttribute("cod","1094" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:42 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).setAttribute("width","100%" );
      ((Element)v.get(37)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(43)).setAttribute("src","b.gif" );
      ((Element)v.get(43)).setAttribute("width","8" );
      ((Element)v.get(43)).setAttribute("height","8" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */
      /* Termina nodo:37   */

      /* Empieza nodo:44 / Elemento padre: 33   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(33)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(46)).setAttribute("src","b.gif" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(46)).setAttribute("width","8" );
      ((Element)v.get(46)).setAttribute("height","8" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:47 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(47)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(47)).setAttribute("valign","top" );
      ((Element)v.get(44)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("AREATEXTO"));
      ((Element)v.get(48)).setAttribute("cols","40" );
      ((Element)v.get(48)).setAttribute("id","datosCampos" );
      ((Element)v.get(48)).setAttribute("msjreq","" );
      ((Element)v.get(48)).setAttribute("nombre","areaMotivosImpresion" );
      ((Element)v.get(48)).setAttribute("readonly","N" );
      ((Element)v.get(48)).setAttribute("req","N" );
      ((Element)v.get(48)).setAttribute("rows","3" );
      ((Element)v.get(48)).setAttribute("tabindex","2" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(48)).setAttribute("onshtab","TabShift();" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:49 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(49)).setAttribute("width","100%" );
      ((Element)v.get(44)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(50)).setAttribute("src","b.gif" );
      ((Element)v.get(50)).setAttribute("width","8" );
      ((Element)v.get(50)).setAttribute("height","8" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:49   */
      /* Termina nodo:44   */

      /* Empieza nodo:51 / Elemento padre: 33   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(33)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).setAttribute("colspan","4" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(53)).setAttribute("src","b.gif" );
      ((Element)v.get(53)).setAttribute("width","8" );
      ((Element)v.get(53)).setAttribute("height","325" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */
      /* Termina nodo:51   */
      /* Termina nodo:33   */
      /* Termina nodo:30   */
      /* Termina nodo:29   */

      /* Empieza nodo:54 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(55)).setAttribute("src","b.gif" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:54   */
      /* Termina nodo:26   */

      /* Empieza nodo:56 / Elemento padre: 18   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(18)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(58)).setAttribute("src","b.gif" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:59 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(59)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("table"));
      ((Element)v.get(61)).setAttribute("width","100%" );
      ((Element)v.get(61)).setAttribute("border","0" );
      ((Element)v.get(61)).setAttribute("align","center" );
      ((Element)v.get(61)).setAttribute("cellspacing","0" );
      ((Element)v.get(61)).setAttribute("cellpadding","0" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(61)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).setAttribute("class","botonera" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(64)).setAttribute("nombre","btnReimprimir" );
      ((Element)v.get(64)).setAttribute("ID","botonContenido" );
      ((Element)v.get(64)).setAttribute("tipo","html" );
      ((Element)v.get(64)).setAttribute("accion","reimprimir();" );
      ((Element)v.get(64)).setAttribute("estado","false" );
      ((Element)v.get(64)).setAttribute("cod","1119" );
      ((Element)v.get(64)).setAttribute("ontab","TabUp();" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */
      /* Termina nodo:62   */
      /* Termina nodo:61   */
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:65 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(66)).setAttribute("src","b.gif" );
      ((Element)v.get(66)).setAttribute("width","8" );
      ((Element)v.get(66)).setAttribute("height","12" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */
      /* Termina nodo:56   */

      /* Empieza nodo:67 / Elemento padre: 18   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(18)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).setAttribute("width","12" );
      ((Element)v.get(68)).setAttribute("align","center" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(69)).setAttribute("src","b.gif" );
      ((Element)v.get(69)).setAttribute("width","12" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(69)).setAttribute("height","12" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */

      /* Empieza nodo:70 / Elemento padre: 67   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).setAttribute("width","750" );
      ((Element)v.get(67)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(71)).setAttribute("src","b.gif" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:72 / Elemento padre: 67   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).setAttribute("width","12" );
      ((Element)v.get(67)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(73)).setAttribute("src","b.gif" );
      ((Element)v.get(73)).setAttribute("width","12" );
      ((Element)v.get(73)).setAttribute("height","1" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */
      /* Termina nodo:67   */
      /* Termina nodo:18   */

      /* Empieza nodo:74 / Elemento padre: 17   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(74)).setAttribute("nombre","listado1" );
      ((Element)v.get(74)).setAttribute("ancho","403" );
      ((Element)v.get(74)).setAttribute("alto","301" );
      ((Element)v.get(74)).setAttribute("x","25" );
      ((Element)v.get(74)).setAttribute("y","101" );
      ((Element)v.get(74)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(74)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(17)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(75)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(75)).setAttribute("alto","22" );
      ((Element)v.get(75)).setAttribute("imgFondo","" );
      ((Element)v.get(75)).setAttribute("cod","00386" );
      ((Element)v.get(75)).setAttribute("ID","datosTitle" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */

      /* Empieza nodo:76 / Elemento padre: 74   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(76)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(76)).setAttribute("alto","22" );
      ((Element)v.get(76)).setAttribute("imgFondo","" );
      ((Element)v.get(74)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */

      /* Empieza nodo:77 / Elemento padre: 74   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(77)).setAttribute("precarga","S" );
      ((Element)v.get(77)).setAttribute("conROver","S" );
      ((Element)v.get(74)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(78)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(78)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(78)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(78)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */

      /* Empieza nodo:79 / Elemento padre: 77   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(79)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(79)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(79)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(79)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(77)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */

      /* Empieza nodo:80 / Elemento padre: 77   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(80)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(80)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(77)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:77   */

      /* Empieza nodo:81 / Elemento padre: 74   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(74)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(82)).setAttribute("borde","1" );
      ((Element)v.get(82)).setAttribute("horizDatos","1" );
      ((Element)v.get(82)).setAttribute("horizCabecera","1" );
      ((Element)v.get(82)).setAttribute("vertical","1" );
      ((Element)v.get(82)).setAttribute("horizTitulo","1" );
      ((Element)v.get(82)).setAttribute("horizBase","1" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */

      /* Empieza nodo:83 / Elemento padre: 81   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(83)).setAttribute("borde","#999999" );
      ((Element)v.get(83)).setAttribute("vertCabecera","#999999" );
      ((Element)v.get(83)).setAttribute("vertDatos","#999999" );
      ((Element)v.get(83)).setAttribute("horizDatos","#999999" );
      ((Element)v.get(83)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(83)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(83)).setAttribute("horizBase","#999999" );
      ((Element)v.get(81)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:81   */

      /* Empieza nodo:84 / Elemento padre: 74   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(84)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(84)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(84)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(84)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(84)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(84)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(74)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(85)).setAttribute("ancho","100" );
      ((Element)v.get(85)).setAttribute("minimizable","S" );
      ((Element)v.get(85)).setAttribute("minimizada","N" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */

      /* Empieza nodo:86 / Elemento padre: 74   */
      v.add(doc.createElement("CABECERA"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(86)).setAttribute("alto","20" );
      ((Element)v.get(86)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(86)).setAttribute("imgFondo","" );
      ((Element)v.get(86)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(74)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(87)).setAttribute("colFondo","" );
      ((Element)v.get(87)).setAttribute("ID","EstCab" );
      ((Element)v.get(87)).setAttribute("align","center" );
      ((Element)v.get(87)).setAttribute("cod","263" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));

      /* Elemento padre:87 / Elemento actual: 88   */
      v.add(doc.createTextNode("Identificador"));
      ((Element)v.get(87)).appendChild((Text)v.get(88));

      /* Termina nodo Texto:88   */
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:89 / Elemento padre: 74   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(89)).setAttribute("alto","22" );
      ((Element)v.get(89)).setAttribute("accion","" );
      ((Element)v.get(89)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(89)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(89)).setAttribute("maxSel","-1" );
      ((Element)v.get(89)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(89)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(89)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(89)).setAttribute("onLoad","" );
      ((Element)v.get(89)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(74)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(90)).setAttribute("tipo","texto" );
      ((Element)v.get(90)).setAttribute("ID","EstDat" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:91 / Elemento padre: 74   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(74)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */

      /* Empieza nodo:92 / Elemento padre: 74   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(92)).setAttribute("nombre","paginadoFichaImpre" );
      ((Element)v.get(92)).setAttribute("ancho","403" );
      ((Element)v.get(92)).setAttribute("sep","$" );
      ((Element)v.get(92)).setAttribute("x","12" );
      ((Element)v.get(92)).setAttribute("class","botonera" );
      ((Element)v.get(92)).setAttribute("y","379" );
      ((Element)v.get(92)).setAttribute("control","|" );
      ((Element)v.get(92)).setAttribute("conector","" );
      ((Element)v.get(92)).setAttribute("rowset","" );
      ((Element)v.get(92)).setAttribute("cargainicial","N" );
      ((Element)v.get(74)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(93)).setAttribute("nombre","ret1" );
      ((Element)v.get(93)).setAttribute("x","49" );
      ((Element)v.get(93)).setAttribute("y","383" );
      ((Element)v.get(93)).setAttribute("ID","botonContenido" );
      ((Element)v.get(93)).setAttribute("img","retroceder_on" );
      ((Element)v.get(93)).setAttribute("tipo","0" );
      ((Element)v.get(93)).setAttribute("estado","false" );
      ((Element)v.get(93)).setAttribute("alt","" );
      ((Element)v.get(93)).setAttribute("codigo","" );
      ((Element)v.get(93)).setAttribute("accion","paginadoFichaImpre.retroceder();" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */

      /* Empieza nodo:94 / Elemento padre: 92   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(94)).setAttribute("nombre","ava1" );
      ((Element)v.get(94)).setAttribute("x","64" );
      ((Element)v.get(94)).setAttribute("y","383" );
      ((Element)v.get(94)).setAttribute("ID","botonContenido" );
      ((Element)v.get(94)).setAttribute("img","avanzar_on" );
      ((Element)v.get(94)).setAttribute("tipo","0" );
      ((Element)v.get(94)).setAttribute("estado","false" );
      ((Element)v.get(94)).setAttribute("alt","" );
      ((Element)v.get(94)).setAttribute("codigo","" );
      ((Element)v.get(94)).setAttribute("accion","paginadoFichaImpre.avanzar();" );
      ((Element)v.get(92)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:92   */
      /* Termina nodo:74   */

      /* Empieza nodo:95 / Elemento padre: 17   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(95)).setAttribute("nombre","prim1" );
      ((Element)v.get(95)).setAttribute("x","32" );
      ((Element)v.get(95)).setAttribute("y","383" );
      ((Element)v.get(95)).setAttribute("ID","botonContenido" );
      ((Element)v.get(95)).setAttribute("img","primera_on" );
      ((Element)v.get(95)).setAttribute("tipo","-2" );
      ((Element)v.get(95)).setAttribute("estado","false" );
      ((Element)v.get(95)).setAttribute("alt","" );
      ((Element)v.get(95)).setAttribute("codigo","" );
      ((Element)v.get(95)).setAttribute("accion","paginadoFichaImpre.retrocederPrimeraPagina();" );
      ((Element)v.get(17)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */

      /* Empieza nodo:96 / Elemento padre: 17   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(96)).setAttribute("nombre","separa" );
      ((Element)v.get(96)).setAttribute("x","71" );
      ((Element)v.get(96)).setAttribute("y","379" );
      ((Element)v.get(96)).setAttribute("ID","botonContenido" );
      ((Element)v.get(96)).setAttribute("img","separa_base" );
      ((Element)v.get(96)).setAttribute("tipo","0" );
      ((Element)v.get(96)).setAttribute("estado","false" );
      ((Element)v.get(96)).setAttribute("alt","" );
      ((Element)v.get(96)).setAttribute("codigo","" );
      ((Element)v.get(96)).setAttribute("accion","" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(17)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:17   */
      /* Termina nodo:7   */


   }

}
