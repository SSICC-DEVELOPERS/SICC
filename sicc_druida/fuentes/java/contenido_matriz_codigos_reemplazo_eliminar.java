
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_matriz_codigos_reemplazo_eliminar  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_matriz_codigos_reemplazo_eliminar" );
      ((Element)v.get(0)).setAttribute("cod","0322" );
      ((Element)v.get(0)).setAttribute("titulo","Eliminar Matriz de Reemplazo" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Eliminar Matriz de Reemplazo" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Elemento padre:1 / Elemento actual: 2   */
      v.add(doc.createTextNode("\r   \r\rvar formName = 'frmFormulario.';\rvar formNameSinPunto = 'frmFormulario';\r		\rfunction fBorrar() {\r     if (listado1.numSelecc()== 0) {\r        GestionarMensaje('1021',null,null,null);\r        return false;\r     } else{            \r            eliminarFilas(listado1.codSeleccionados(), \"PREEliminarMatricesCodigosReemplazo\", mipgndo,null, false);\r      }	\r  }\r\r function focalizaTab(componente) {  \r	if (componente==1){\r			focalizaBotonHTML('botonContenido' ,'btnBuscarProductoRemmplazos');\r	}else if (componente==2){\r			focalizaBotonHTML('botonContenido' ,'btnBuscarProductoPrincipal');	\r	}\r}\r\r\rfunction focalizaTabShift(componente) {    \r    if (componente==1){		   \r			focalizaBotonHTML('botonContenido' ,'btnBuscarProductoRemmplazos');		   \r	} else if (componente==2){	\r		focalizaBotonHTML('botonContenido' ,'btnBuscarProductoPrincipal');	\r	}\r}\r\r  \r\rfunction fLimpiar(){	\r	cargarAccion(\"Matriz seleccionada\");\r}\r\rfunction inicializar(){\r	\r	configurarMenuSecundario(\"frmFormulario\");\r	\r	onLoadPag();\r\r	focalizaBotonHTML('botonContenido' ,'btnBuscarProductoPrincipal');	\r\r	fMostrarMensajeError();\r		\r\r}\r\rfunction onLoadPag()   {\r  \r    DrdEnsanchaConMargenDcho('listado1',12);   \r     ocultarCapas();\r     eval (ON_RSZ);  \r\r   }\r\r\r\rfunction cargarAccion(accion){\r    if(accion == \"buscarProductoPrincipal\" || accion == \"Matriz seleccionada\") {\r		set(formName + \"conectorAction\" ,\"LPBuscarMatrizCodigosReemplazo\"); \r		set(formName + 'accion', accion);\r		enviaSICC(formNameSinPunto);	\r	} else {\r\r		var arr = new Array();\r		arr[arr.length]=new Array('oidCabeceraMF', get(formName + 'hidOidFacturacion'));\r		arr[arr.length]=new Array('codigoVenta', get(formName + 'hidCodigoVenta'));\r		arr[arr.length]=new Array('descripcionProducto', get(formName + 'hidDescripcion'));   \r		arr[arr.length]=new Array('oidIdioma', get(formName + 'hIdioma'));\r		arr[arr.length]=new Array('oidPais', get(formName + 'hPais'));\r		arr[arr.length]=new Array('indicadorSituacion', '1');\r		arr[arr.length]=new Array('tamanioPagina', '2');\r\r		  \r		configurarPaginado(mipgndo,\"PREBuscarMatricesCodigosReemplazo\",\"ConectorBuscarMatricesCodigosReemplazo\",\"es.indra.sicc.dtos.pre.DTOEBuscarMatrizCodigosReemplazo\", arr);\r	}\r\r}\r\r\rfunction mostrarLista( ultima, rowset){\r	var tamano = rowset.length;\r\r	\r    if (tamano > 0) {\r		reemplazarValores(rowset);\r		muestraCapas();\r		if(get(formName + 'casodeuso')==\"eliminar\"){\r			btnProxy(4,'1');\r		}\r		return true;\r	}else {\r		ocultarCapas();		\r		btnProxy(4,'0');\r        return false;     \r	}\r	return true;\r\r}\r\rfunction ocultarCapas(){\r    document.all[\"Cplistado1\"].style.visibility='hidden';\r    document.all[\"CpLin1listado1\"].style.visibility='hidden';\r    document.all[\"CpLin2listado1\"].style.visibility='hidden';\r    document.all[\"CpLin3listado1\"].style.visibility='hidden';\r    document.all[\"CpLin4listado1\"].style.visibility='hidden';\r	document.all[\"capaTitulo\"].style.visibility='hidden';\r\r    document.all[\"primera1Div\"].style.visibility='hidden';\r    document.all[\"ret1Div\"].style.visibility='hidden';\r    document.all[\"ava1Div\"].style.visibility='hidden';    \r  }\r\r  function muestraCapas(){\r    document.all[\"Cplistado1\"].style.visibility='';\r    document.all[\"CpLin1listado1\"].style.visibility='';\r    document.all[\"CpLin2listado1\"].style.visibility='';\r    document.all[\"CpLin3listado1\"].style.visibility='';\r    document.all[\"CpLin4listado1\"].style.visibility='';\r	document.all[\"capaTitulo\"].style.visibility='';\r\r    document.all[\"primera1Div\"].style.visibility='';\r    document.all[\"ret1Div\"].style.visibility='';\r    document.all[\"ava1Div\"].style.visibility='';    \r  }\r\r  function reemplazarValores(rowset){\r\r	  var valorAntesDeCuadre = 5;\r	  var valorEmitirMensj = 6;\r	  var antesDeCuadre = GestionarMensaje(1207);\r	  var despuesDeCuadre = GestionarMensaje(1208);\r	  var si = GestionarMensaje(1010);\r	  var no = GestionarMensaje(1011);\r	\r	  for( var i = 0; i < rowset.length; i++ ){\r	\r	    	    if(rowset[i][valorAntesDeCuadre] == '1'){\r	      rowset[i][valorAntesDeCuadre] = antesDeCuadre;\r	    }else{\r	      if(rowset[i][valorAntesDeCuadre] == '0'){\r	         rowset[i][valorAntesDeCuadre] = despuesDeCuadre;\r	   	  }else{\r		     rowset[i][valorAntesDeCuadre] = '';\r		  }\r		}\r	\r	    	  \r		if( rowset[i][valorEmitirMensj] == 'SI')\r	      rowset[i][valorEmitirMensj] = si;\r	    else\r	      rowset[i][valorEmitirMensj] = no;\r	  }\r    \r  }\r\r\r  \r   \r\r\r"));
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
      ((Element)v.get(4)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(5)).setAttribute("nombre","frmFormulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","oidCabecera" );
      ((Element)v.get(6)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","accion" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 5   */
      v.add(doc.createElement("table"));
      ((Element)v.get(9)).setAttribute("width","100%" );
      ((Element)v.get(9)).setAttribute("border","0" );
      ((Element)v.get(9)).setAttribute("cellspacing","0" );
      ((Element)v.get(9)).setAttribute("cellpadding","0" );
      ((Element)v.get(5)).appendChild((Element)v.get(9));

      /* Empieza nodo:10 / Elemento padre: 9   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(9)).appendChild((Element)v.get(10));

      /* Empieza nodo:11 / Elemento padre: 10   */
      v.add(doc.createElement("td"));
      ((Element)v.get(11)).setAttribute("width","12" );
      ((Element)v.get(11)).setAttribute("align","center" );
      ((Element)v.get(10)).appendChild((Element)v.get(11));

      /* Empieza nodo:12 / Elemento padre: 11   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(12)).setAttribute("src","b.gif" );
      ((Element)v.get(12)).setAttribute("width","12" );
      ((Element)v.get(12)).setAttribute("height","12" );
      ((Element)v.get(11)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */
      /* Termina nodo:11   */

      /* Empieza nodo:13 / Elemento padre: 10   */
      v.add(doc.createElement("td"));
      ((Element)v.get(13)).setAttribute("width","750" );
      ((Element)v.get(10)).appendChild((Element)v.get(13));

      /* Empieza nodo:14 / Elemento padre: 13   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(14)).setAttribute("src","b.gif" );
      ((Element)v.get(13)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */
      /* Termina nodo:13   */

      /* Empieza nodo:15 / Elemento padre: 10   */
      v.add(doc.createElement("td"));
      ((Element)v.get(15)).setAttribute("width","12" );
      ((Element)v.get(10)).appendChild((Element)v.get(15));

      /* Empieza nodo:16 / Elemento padre: 15   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(16)).setAttribute("src","b.gif" );
      ((Element)v.get(16)).setAttribute("width","12" );
      ((Element)v.get(16)).setAttribute("height","1" );
      ((Element)v.get(15)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */
      /* Termina nodo:15   */
      /* Termina nodo:10   */

      /* Empieza nodo:17 / Elemento padre: 9   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(9)).appendChild((Element)v.get(17));

      /* Empieza nodo:18 / Elemento padre: 17   */
      v.add(doc.createElement("td"));
      ((Element)v.get(17)).appendChild((Element)v.get(18));

      /* Empieza nodo:19 / Elemento padre: 18   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(19)).setAttribute("src","b.gif" );
      ((Element)v.get(18)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */
      /* Termina nodo:18   */

      /* Empieza nodo:20 / Elemento padre: 17   */
      v.add(doc.createElement("td"));
      ((Element)v.get(17)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(20)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(22)).setAttribute("class","legend" );
      ((Element)v.get(21)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(23)).setAttribute("nombre","lblProductoPrincipal" );
      ((Element)v.get(23)).setAttribute("alto","13" );
      ((Element)v.get(23)).setAttribute("filas","1" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(23)).setAttribute("id","legend" );
      ((Element)v.get(23)).setAttribute("cod","0014" );
      ((Element)v.get(22)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */
      /* Termina nodo:22   */

      /* Empieza nodo:24 / Elemento padre: 21   */
      v.add(doc.createElement("table"));
      ((Element)v.get(24)).setAttribute("width","100%" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(24)).setAttribute("border","0" );
      ((Element)v.get(24)).setAttribute("align","center" );
      ((Element)v.get(24)).setAttribute("cellspacing","0" );
      ((Element)v.get(24)).setAttribute("cellpadding","0" );
      ((Element)v.get(21)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(24)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(25)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("table"));
      ((Element)v.get(27)).setAttribute("width","600" );
      ((Element)v.get(27)).setAttribute("border","0" );
      ((Element)v.get(27)).setAttribute("align","left" );
      ((Element)v.get(27)).setAttribute("cellspacing","0" );
      ((Element)v.get(27)).setAttribute("cellpadding","0" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(27)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).setAttribute("colspan","4" );
      ((Element)v.get(28)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(30)).setAttribute("src","b.gif" );
      ((Element)v.get(30)).setAttribute("width","8" );
      ((Element)v.get(30)).setAttribute("height","8" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */
      /* Termina nodo:29   */
      /* Termina nodo:28   */

      /* Empieza nodo:31 / Elemento padre: 27   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(27)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("td"));
      ((Element)v.get(31)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(33)).setAttribute("src","b.gif" );
      ((Element)v.get(33)).setAttribute("width","8" );
      ((Element)v.get(33)).setAttribute("height","8" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */
      /* Termina nodo:32   */

      /* Empieza nodo:34 / Elemento padre: 31   */
      v.add(doc.createElement("td"));
      ((Element)v.get(31)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(35)).setAttribute("nombre","lblCodigoVenta" );
      ((Element)v.get(35)).setAttribute("alto","13" );
      ((Element)v.get(35)).setAttribute("filas","1" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(35)).setAttribute("id","datosTitle" );
      ((Element)v.get(35)).setAttribute("cod","336" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:36 / Elemento padre: 31   */
      v.add(doc.createElement("td"));
      ((Element)v.get(31)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(37)).setAttribute("src","b.gif" );
      ((Element)v.get(37)).setAttribute("width","25" );
      ((Element)v.get(37)).setAttribute("height","8" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:38 / Elemento padre: 31   */
      v.add(doc.createElement("td"));
      ((Element)v.get(31)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(39)).setAttribute("nombre","lblDescripcion" );
      ((Element)v.get(39)).setAttribute("alto","13" );
      ((Element)v.get(39)).setAttribute("filas","1" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(39)).setAttribute("id","datosTitle" );
      ((Element)v.get(39)).setAttribute("cod","9" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:40 / Elemento padre: 31   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).setAttribute("width","100%" );
      ((Element)v.get(31)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(41)).setAttribute("src","b.gif" );
      ((Element)v.get(41)).setAttribute("width","8" );
      ((Element)v.get(41)).setAttribute("height","8" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:40   */
      /* Termina nodo:31   */

      /* Empieza nodo:42 / Elemento padre: 27   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(27)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(44)).setAttribute("src","b.gif" );
      ((Element)v.get(44)).setAttribute("width","8" );
      ((Element)v.get(44)).setAttribute("height","8" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */
      /* Termina nodo:43   */

      /* Empieza nodo:45 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(46)).setAttribute("nombre","lblCodigoVentaXX" );
      ((Element)v.get(46)).setAttribute("alto","13" );
      ((Element)v.get(46)).setAttribute("filas","1" );
      ((Element)v.get(46)).setAttribute("valor","xxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(46)).setAttribute("id","datosCampos" );
      ((Element)v.get(46)).setAttribute("codigo","" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:47 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(42)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(48)).setAttribute("src","b.gif" );
      ((Element)v.get(48)).setAttribute("width","25" );
      ((Element)v.get(48)).setAttribute("height","8" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:49 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(50)).setAttribute("nombre","lblDescripcionXX" );
      ((Element)v.get(50)).setAttribute("alto","13" );
      ((Element)v.get(50)).setAttribute("filas","1" );
      ((Element)v.get(50)).setAttribute("valor","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(50)).setAttribute("id","datosCampos" );
      ((Element)v.get(50)).setAttribute("codigo","" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:51 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(51)).setAttribute("width","100%" );
      ((Element)v.get(42)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(52)).setAttribute("src","b.gif" );
      ((Element)v.get(52)).setAttribute("width","8" );
      ((Element)v.get(52)).setAttribute("height","8" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */
      /* Termina nodo:42   */

      /* Empieza nodo:53 / Elemento padre: 27   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(27)).appendChild((Element)v.get(53));

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
      /* Termina nodo:27   */
      /* Termina nodo:26   */
      /* Termina nodo:25   */
      /* Termina nodo:24   */
      /* Termina nodo:21   */
      /* Termina nodo:20   */

      /* Empieza nodo:56 / Elemento padre: 17   */
      v.add(doc.createElement("td"));
      ((Element)v.get(17)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(57)).setAttribute("src","b.gif" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */
      /* Termina nodo:17   */

      /* Empieza nodo:58 / Elemento padre: 9   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(9)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(60)).setAttribute("src","b.gif" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:61 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(61)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("table"));
      ((Element)v.get(63)).setAttribute("width","100%" );
      ((Element)v.get(63)).setAttribute("border","0" );
      ((Element)v.get(63)).setAttribute("align","center" );
      ((Element)v.get(63)).setAttribute("cellspacing","0" );
      ((Element)v.get(63)).setAttribute("cellpadding","0" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).setAttribute("class","botonera" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(66)).setAttribute("nombre","btnBuscarProductoPrincipal" );
      ((Element)v.get(66)).setAttribute("ID","botonContenido" );
      ((Element)v.get(66)).setAttribute("tipo","html" );
      ((Element)v.get(66)).setAttribute("accion","" );
      ((Element)v.get(66)).setAttribute("estado","false" );
      ((Element)v.get(66)).setAttribute("cod","431" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */

      /* Empieza nodo:67 / Elemento padre: 65   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(67)).setAttribute("nombre","btnBuscarProductoReemplazo" );
      ((Element)v.get(67)).setAttribute("ID","botonContenido" );
      ((Element)v.get(67)).setAttribute("tipo","html" );
      ((Element)v.get(67)).setAttribute("accion","" );
      ((Element)v.get(67)).setAttribute("estado","false" );
      ((Element)v.get(67)).setAttribute("cod","521" );
      ((Element)v.get(65)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:65   */
      /* Termina nodo:64   */
      /* Termina nodo:63   */
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:68 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(69)).setAttribute("src","b.gif" );
      ((Element)v.get(69)).setAttribute("width","8" );
      ((Element)v.get(69)).setAttribute("height","12" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:58   */

      /* Empieza nodo:70 / Elemento padre: 9   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(9)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).setAttribute("width","12" );
      ((Element)v.get(71)).setAttribute("align","center" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(70)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(72)).setAttribute("src","b.gif" );
      ((Element)v.get(72)).setAttribute("width","12" );
      ((Element)v.get(72)).setAttribute("height","12" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:73 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).setAttribute("width","756" );
      ((Element)v.get(70)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(74)).setAttribute("src","b.gif" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:75 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).setAttribute("width","12" );
      ((Element)v.get(70)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(76)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).setAttribute("width","12" );
      ((Element)v.get(76)).setAttribute("height","1" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */
      /* Termina nodo:70   */
      /* Termina nodo:9   */

      /* Empieza nodo:77 / Elemento padre: 5   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(77)).setAttribute("nombre","listado1" );
      ((Element)v.get(77)).setAttribute("ancho","603" );
      ((Element)v.get(77)).setAttribute("alto","317" );
      ((Element)v.get(77)).setAttribute("x","12" );
      ((Element)v.get(77)).setAttribute("y","117" );
      ((Element)v.get(77)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(77)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(5)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(78)).setAttribute("precarga","S" );
      ((Element)v.get(78)).setAttribute("conROver","S" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(79)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(79)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(79)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(79)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */

      /* Empieza nodo:80 / Elemento padre: 78   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(80)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(80)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(80)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(80)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(78)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */

      /* Empieza nodo:81 / Elemento padre: 78   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(81)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(81)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(78)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:78   */

      /* Empieza nodo:82 / Elemento padre: 77   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(77)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(83)).setAttribute("borde","1" );
      ((Element)v.get(83)).setAttribute("horizDatos","1" );
      ((Element)v.get(83)).setAttribute("horizCabecera","1" );
      ((Element)v.get(83)).setAttribute("vertical","1" );
      ((Element)v.get(83)).setAttribute("horizTitulo","1" );
      ((Element)v.get(83)).setAttribute("horizBase","1" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */

      /* Empieza nodo:84 / Elemento padre: 82   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(84)).setAttribute("borde","#999999" );
      ((Element)v.get(84)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(84)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(84)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(84)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(84)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(84)).setAttribute("horizBase","#999999" );
      ((Element)v.get(82)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:82   */

      /* Empieza nodo:85 / Elemento padre: 77   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(85)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(85)).setAttribute("alto","22" );
      ((Element)v.get(85)).setAttribute("imgFondo","" );
      ((Element)v.get(85)).setAttribute("cod","1305" );
      ((Element)v.get(85)).setAttribute("ID","datosTitle" );
      ((Element)v.get(77)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */

      /* Empieza nodo:86 / Elemento padre: 77   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(86)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(86)).setAttribute("alto","22" );
      ((Element)v.get(86)).setAttribute("imgFondo","" );
      ((Element)v.get(77)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */

      /* Empieza nodo:87 / Elemento padre: 77   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(87)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(87)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(87)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(87)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(87)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(87)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(77)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(88)).setAttribute("ancho","180" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(88)).setAttribute("minimizable","S" );
      ((Element)v.get(88)).setAttribute("minimizada","N" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */

      /* Empieza nodo:89 / Elemento padre: 87   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(89)).setAttribute("ancho","180" );
      ((Element)v.get(89)).setAttribute("minimizable","S" );
      ((Element)v.get(89)).setAttribute("minimizada","N" );
      ((Element)v.get(87)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */

      /* Empieza nodo:90 / Elemento padre: 87   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(90)).setAttribute("ancho","180" );
      ((Element)v.get(90)).setAttribute("minimizable","S" );
      ((Element)v.get(90)).setAttribute("minimizada","N" );
      ((Element)v.get(87)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */

      /* Empieza nodo:91 / Elemento padre: 87   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(91)).setAttribute("ancho","200" );
      ((Element)v.get(91)).setAttribute("minimizable","S" );
      ((Element)v.get(91)).setAttribute("minimizada","N" );
      ((Element)v.get(87)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */

      /* Empieza nodo:92 / Elemento padre: 87   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(92)).setAttribute("ancho","160" );
      ((Element)v.get(92)).setAttribute("minimizable","S" );
      ((Element)v.get(92)).setAttribute("minimizada","N" );
      ((Element)v.get(87)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */

      /* Empieza nodo:93 / Elemento padre: 87   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(93)).setAttribute("ancho","160" );
      ((Element)v.get(93)).setAttribute("minimizable","S" );
      ((Element)v.get(93)).setAttribute("minimizada","N" );
      ((Element)v.get(87)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */

      /* Empieza nodo:94 / Elemento padre: 87   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(94)).setAttribute("ancho","160" );
      ((Element)v.get(94)).setAttribute("minimizable","S" );
      ((Element)v.get(94)).setAttribute("minimizada","N" );
      ((Element)v.get(87)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */

      /* Empieza nodo:95 / Elemento padre: 87   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(95)).setAttribute("ancho","160" );
      ((Element)v.get(95)).setAttribute("minimizable","S" );
      ((Element)v.get(95)).setAttribute("minimizada","N" );
      ((Element)v.get(87)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */

      /* Empieza nodo:96 / Elemento padre: 87   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(96)).setAttribute("ancho","160" );
      ((Element)v.get(96)).setAttribute("minimizable","S" );
      ((Element)v.get(96)).setAttribute("minimizada","N" );
      ((Element)v.get(87)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */

      /* Empieza nodo:97 / Elemento padre: 87   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(97)).setAttribute("ancho","160" );
      ((Element)v.get(97)).setAttribute("minimizable","S" );
      ((Element)v.get(97)).setAttribute("minimizada","N" );
      ((Element)v.get(87)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */

      /* Empieza nodo:98 / Elemento padre: 87   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(98)).setAttribute("ancho","180" );
      ((Element)v.get(98)).setAttribute("minimizable","S" );
      ((Element)v.get(98)).setAttribute("minimizada","N" );
      ((Element)v.get(87)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */

      /* Empieza nodo:99 / Elemento padre: 87   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(99)).setAttribute("ancho","100" );
      ((Element)v.get(99)).setAttribute("minimizable","S" );
      ((Element)v.get(99)).setAttribute("minimizada","N" );
      ((Element)v.get(87)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:87   */

      /* Empieza nodo:100 / Elemento padre: 77   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(100)).setAttribute("alto","20" );
      ((Element)v.get(100)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(100)).setAttribute("imgFondo","" );
      ((Element)v.get(100)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(77)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(101)).setAttribute("colFondo","" );
      ((Element)v.get(101)).setAttribute("ID","EstCab" );
      ((Element)v.get(101)).setAttribute("align","center" );
      ((Element)v.get(101)).setAttribute("cod","435" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Elemento padre:101 / Elemento actual: 102   */
      v.add(doc.createTextNode("Cód. venta producto principal"));
      ((Element)v.get(101)).appendChild((Text)v.get(102));

      /* Termina nodo Texto:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:103 / Elemento padre: 100   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(103)).setAttribute("colFondo","" );
      ((Element)v.get(103)).setAttribute("ID","EstCab" );
      ((Element)v.get(103)).setAttribute("cod","436" );
      ((Element)v.get(100)).appendChild((Element)v.get(103));

      /* Elemento padre:103 / Elemento actual: 104   */
      v.add(doc.createTextNode("Descripción producto principal"));
      ((Element)v.get(103)).appendChild((Text)v.get(104));

      /* Termina nodo Texto:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:105 / Elemento padre: 100   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(105)).setAttribute("colFondo","" );
      ((Element)v.get(105)).setAttribute("ID","EstCab" );
      ((Element)v.get(105)).setAttribute("cod","522" );
      ((Element)v.get(100)).appendChild((Element)v.get(105));

      /* Elemento padre:105 / Elemento actual: 106   */
      v.add(doc.createTextNode("Cód. venta reemplazo"));
      ((Element)v.get(105)).appendChild((Text)v.get(106));

      /* Termina nodo Texto:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:107 / Elemento padre: 100   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(107)).setAttribute("colFondo","" );
      ((Element)v.get(107)).setAttribute("ID","EstCab" );
      ((Element)v.get(107)).setAttribute("cod","523" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(100)).appendChild((Element)v.get(107));

      /* Elemento padre:107 / Elemento actual: 108   */
      v.add(doc.createTextNode("Descripción producto reemplazo"));
      ((Element)v.get(107)).appendChild((Text)v.get(108));

      /* Termina nodo Texto:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:109 / Elemento padre: 100   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(109)).setAttribute("colFondo","" );
      ((Element)v.get(109)).setAttribute("ID","EstCab" );
      ((Element)v.get(109)).setAttribute("cod","109" );
      ((Element)v.get(100)).appendChild((Element)v.get(109));

      /* Elemento padre:109 / Elemento actual: 110   */
      v.add(doc.createTextNode("Región"));
      ((Element)v.get(109)).appendChild((Text)v.get(110));

      /* Termina nodo Texto:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:111 / Elemento padre: 100   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(111)).setAttribute("colFondo","" );
      ((Element)v.get(111)).setAttribute("ID","EstCab" );
      ((Element)v.get(111)).setAttribute("cod","143" );
      ((Element)v.get(100)).appendChild((Element)v.get(111));

      /* Elemento padre:111 / Elemento actual: 112   */
      v.add(doc.createTextNode("Zona"));
      ((Element)v.get(111)).appendChild((Text)v.get(112));

      /* Termina nodo Texto:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:113 / Elemento padre: 100   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(113)).setAttribute("colFondo","" );
      ((Element)v.get(113)).setAttribute("ID","EstCab" );
      ((Element)v.get(113)).setAttribute("cod","393" );
      ((Element)v.get(100)).appendChild((Element)v.get(113));

      /* Elemento padre:113 / Elemento actual: 114   */
      v.add(doc.createTextNode("Tipo Cliente"));
      ((Element)v.get(113)).appendChild((Text)v.get(114));

      /* Termina nodo Texto:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:115 / Elemento padre: 100   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(115)).setAttribute("colFondo","" );
      ((Element)v.get(115)).setAttribute("ID","EstCab" );
      ((Element)v.get(115)).setAttribute("cod","595" );
      ((Element)v.get(100)).appendChild((Element)v.get(115));

      /* Elemento padre:115 / Elemento actual: 116   */
      v.add(doc.createTextNode("SubTipo Cliente"));
      ((Element)v.get(115)).appendChild((Text)v.get(116));

      /* Termina nodo Texto:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:117 / Elemento padre: 100   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(117)).setAttribute("colFondo","" );
      ((Element)v.get(117)).setAttribute("ID","EstCab" );
      ((Element)v.get(117)).setAttribute("cod","756" );
      ((Element)v.get(100)).appendChild((Element)v.get(117));

      /* Elemento padre:117 / Elemento actual: 118   */
      v.add(doc.createTextNode("Tipo Clasificacion"));
      ((Element)v.get(117)).appendChild((Text)v.get(118));

      /* Termina nodo Texto:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:119 / Elemento padre: 100   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(119)).setAttribute("colFondo","" );
      ((Element)v.get(119)).setAttribute("ID","EstCab" );
      ((Element)v.get(119)).setAttribute("cod","550" );
      ((Element)v.get(100)).appendChild((Element)v.get(119));

      /* Elemento padre:119 / Elemento actual: 120   */
      v.add(doc.createTextNode("Clasificacion"));
      ((Element)v.get(119)).appendChild((Text)v.get(120));

      /* Termina nodo Texto:120   */
      /* Termina nodo:119   */

      /* Empieza nodo:121 / Elemento padre: 100   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(121)).setAttribute("colFondo","" );
      ((Element)v.get(121)).setAttribute("ID","EstCab" );
      ((Element)v.get(121)).setAttribute("cod","524" );
      ((Element)v.get(100)).appendChild((Element)v.get(121));

      /* Elemento padre:121 / Elemento actual: 122   */
      v.add(doc.createTextNode("Antes/Después cuadre"));
      ((Element)v.get(121)).appendChild((Text)v.get(122));

      /* Termina nodo Texto:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:123 / Elemento padre: 100   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(123)).setAttribute("colFondo","" );
      ((Element)v.get(123)).setAttribute("ID","EstCab" );
      ((Element)v.get(123)).setAttribute("cod","531" );
      ((Element)v.get(100)).appendChild((Element)v.get(123));

      /* Elemento padre:123 / Elemento actual: 124   */
      v.add(doc.createTextNode("Mensaje"));
      ((Element)v.get(123)).appendChild((Text)v.get(124));

      /* Termina nodo Texto:124   */
      /* Termina nodo:123   */
      /* Termina nodo:100   */

      /* Empieza nodo:125 / Elemento padre: 77   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(125)).setAttribute("alto","22" );
      ((Element)v.get(125)).setAttribute("accion","" );
      ((Element)v.get(125)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(125)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(125)).setAttribute("maxSel","-1" );
      ((Element)v.get(125)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(125)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(125)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(125)).setAttribute("onLoad","" );
      ((Element)v.get(125)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(77)).appendChild((Element)v.get(125));

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
   }

   private void getXML540(Document doc) {
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
      /* Termina nodo:125   */

      /* Empieza nodo:138 / Elemento padre: 77   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(77)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(139)).setAttribute("ID","1" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(140)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(140)).setAttribute("TIPO","STRING" );
      ((Element)v.get(140)).setAttribute("VALOR","COD0" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */

      /* Empieza nodo:141 / Elemento padre: 139   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(141)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(141)).setAttribute("TIPO","STRING" );
      ((Element)v.get(141)).setAttribute("VALOR","" );
      ((Element)v.get(139)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */

      /* Empieza nodo:142 / Elemento padre: 139   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(142)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(142)).setAttribute("TIPO","STRING" );
      ((Element)v.get(142)).setAttribute("VALOR","" );
      ((Element)v.get(139)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */

      /* Empieza nodo:143 / Elemento padre: 139   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(143)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(143)).setAttribute("TIPO","STRING" );
      ((Element)v.get(143)).setAttribute("VALOR","" );
      ((Element)v.get(139)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */

      /* Empieza nodo:144 / Elemento padre: 139   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(144)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(144)).setAttribute("TIPO","STRING" );
      ((Element)v.get(144)).setAttribute("VALOR","" );
      ((Element)v.get(139)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */

      /* Empieza nodo:145 / Elemento padre: 139   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(145)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(145)).setAttribute("TIPO","STRING" );
      ((Element)v.get(145)).setAttribute("VALOR","" );
      ((Element)v.get(139)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */

      /* Empieza nodo:146 / Elemento padre: 139   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(146)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(146)).setAttribute("TIPO","STRING" );
      ((Element)v.get(146)).setAttribute("VALOR","" );
      ((Element)v.get(139)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:139   */
      /* Termina nodo:138   */

      /* Empieza nodo:147 / Elemento padre: 77   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(147)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(147)).setAttribute("ancho","603" );
      ((Element)v.get(147)).setAttribute("sep","$" );
      ((Element)v.get(147)).setAttribute("x","12" );
      ((Element)v.get(147)).setAttribute("class","botonera" );
      ((Element)v.get(147)).setAttribute("y","411" );
      ((Element)v.get(147)).setAttribute("control","|" );
      ((Element)v.get(147)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(147)).setAttribute("rowset","" );
      ((Element)v.get(147)).setAttribute("cargainicial","N" );
      ((Element)v.get(147)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'mostrarLista(ultima, rowset)')" );
      ((Element)v.get(77)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(148)).setAttribute("nombre","ret1" );
      ((Element)v.get(148)).setAttribute("x","37" );
      ((Element)v.get(148)).setAttribute("y","415" );
      ((Element)v.get(148)).setAttribute("ID","botonContenido" );
      ((Element)v.get(148)).setAttribute("img","retroceder_on" );
      ((Element)v.get(148)).setAttribute("tipo","0" );
      ((Element)v.get(148)).setAttribute("estado","false" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(148)).setAttribute("alt","" );
      ((Element)v.get(148)).setAttribute("codigo","" );
      ((Element)v.get(148)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */

      /* Empieza nodo:149 / Elemento padre: 147   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(149)).setAttribute("nombre","ava1" );
      ((Element)v.get(149)).setAttribute("x","52" );
      ((Element)v.get(149)).setAttribute("y","415" );
      ((Element)v.get(149)).setAttribute("ID","botonContenido" );
      ((Element)v.get(149)).setAttribute("img","avanzar_on" );
      ((Element)v.get(149)).setAttribute("tipo","0" );
      ((Element)v.get(149)).setAttribute("estado","false" );
      ((Element)v.get(149)).setAttribute("alt","" );
      ((Element)v.get(149)).setAttribute("codigo","" );
      ((Element)v.get(149)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(147)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:147   */
      /* Termina nodo:77   */

      /* Empieza nodo:150 / Elemento padre: 5   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(150)).setAttribute("nombre","primera1" );
      ((Element)v.get(150)).setAttribute("x","20" );
      ((Element)v.get(150)).setAttribute("y","415" );
      ((Element)v.get(150)).setAttribute("ID","botonContenido" );
      ((Element)v.get(150)).setAttribute("img","primera_on" );
      ((Element)v.get(150)).setAttribute("tipo","-2" );
      ((Element)v.get(150)).setAttribute("estado","false" );
      ((Element)v.get(150)).setAttribute("alt","" );
      ((Element)v.get(150)).setAttribute("codigo","" );
      ((Element)v.get(150)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(5)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */

      /* Empieza nodo:151 / Elemento padre: 5   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(151)).setAttribute("nombre","separa" );
      ((Element)v.get(151)).setAttribute("x","59" );
      ((Element)v.get(151)).setAttribute("y","411" );
      ((Element)v.get(151)).setAttribute("ID","botonContenido" );
      ((Element)v.get(151)).setAttribute("img","separa_base" );
      ((Element)v.get(151)).setAttribute("tipo","0" );
      ((Element)v.get(151)).setAttribute("estado","false" );
      ((Element)v.get(151)).setAttribute("alt","" );
      ((Element)v.get(151)).setAttribute("codigo","" );
      ((Element)v.get(151)).setAttribute("accion","" );
      ((Element)v.get(5)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */

      /* Empieza nodo:152 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(152)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(152)).setAttribute("alto","12" );
      ((Element)v.get(152)).setAttribute("ancho","50" );
      ((Element)v.get(152)).setAttribute("x","0" );
      ((Element)v.get(152)).setAttribute("y","434" );
      ((Element)v.get(5)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:5   */


   }

}
