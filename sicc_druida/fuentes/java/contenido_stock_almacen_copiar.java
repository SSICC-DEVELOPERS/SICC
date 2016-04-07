
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_stock_almacen_copiar  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         

      getXML180(doc);
         

      getXML270(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_stock_almacen_copiar" );
      ((Element)v.get(0)).setAttribute("cod","" );
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
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Elemento padre:4 / Elemento actual: 5   */
      v.add(doc.createTextNode("\r \r\rfunction onLoadPag(){\r		configurarMenuSecundario(\"frmContenido\");\r		focaliza('frmContenido.cbAlmacen');\r		\r		if (get('frmContenido.errDescripcion')!='') {\r			 var wnd = fMostrarMensajeError(get('frmContenido.errCodigo'), get('frmContenido.errDescripcion'));\r		}\r\r	}\r\r\rfunction onClickCopiar(){\r		var almacenO = get(\"frmContenido.cbAlmacen\");\r		set(\"frmContenido.oidAlmacenO\", almacenO);\r		\r		var almacenD = get(\"frmContenido.cbAlmacenDestino\");\r		set(\"frmContenido.oidAlmacenD\", almacenD);\r\r		if (almacenO == 0){\r			GestionarMensaje('1330',null,null,null);\r			focaliza('frmContenido.cbAlmacen');\r		}\r		 else \r		    if(almacenD == 0){\r				GestionarMensaje('1331',null,null,null);\r				focaliza('frmContenido.cbAlmacenDestino');\r		   }\r		   else{\r				set(\"frmContenido.conectorAction\",\"LPCopiaStockAlmacen\");\r				set(\"frmContenido.accion\",\"copiar\");				\r				enviaSICC(\"frmContenido\");\r		   }\r }\r\r\rfunction borrarTodo(){\r	 var arr = new Array();	 \r	 set(\"frmContenido.cbAlmacenDestino\", \"\"); \r	 set(\"frmContenido.cbAlmacen\", \"\");    \r	 focaliza(\"frmContenido.cbAlmacen\");\r}\r\rfunction fLimpiar(){\r	var arr = new Array();	 \r	 set(\"frmContenido.cbAlmacenDestino\", \"\"); \r	 set(\"frmContenido.cbAlmacen\", \"\");    \r	 focaliza(\"frmContenido.cbAlmacen\");\r}\r\rfunction comboAlmacenD(){\r	focaliza(\"frmContenido.cbAlmacenDestino\");\r}\r\rfunction comboHasta(){\r	focalizaBotonHTML('btnCopiar' ,'botonContenido');\r}\r\r\rfunction comboAlmacenD1(){\r	focaliza(\"frmContenido.cbAlmacen\");\r}\r\rfunction comboAlmacenO(){\r	focalizaBotonHTML('botonContenido' ,'btnCopiar');\r}\r\rfunction fBorrar(){\r\r	var almacenO = get(\"frmContenido.cbAlmacen\");\r	set(\"frmContenido.oidAlmacenO\", almacenO);\r\r    if (almacenO == 0){		\r		   GestionarMensaje('1330',null,null,null);\r		   focaliza('frmContenido.cbAlmacen');\r	}else{	   \r           var retorno = GestionarMensaje('131',null,null,null);	\r		   if (retorno == true){	\r				var codigos = get('frmContenido.cbAlmacen');\r				set(\"frmContenido.oidAlmacenO\", codigos);				\r				set('frmContenido.conectorAction','LPCopiaStockAlmacen');\r				set('frmContenido.accion','eliminar');				\r				enviaSICC('frmContenido');\r			}\r	}\r\r }\r\r function comboDesde(){\r	 focaliza(\"frmContenido.cbAlmacenDestino\");\r }\r\r\r\r \r"));
      ((Element)v.get(4)).appendChild((Text)v.get(5));

      /* Termina nodo Texto:5   */
      /* Termina nodo:4   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(6)).setAttribute("nombre","frmContenido" );
      ((Element)v.get(6)).setAttribute("oculto","S" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","accion" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","ejecutar" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","oidAlmacenO" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","oidAlmacenD" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(13)).setAttribute("nombre","capaContenido" );
      ((Element)v.get(13)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(13)).setAttribute("borde","0" );
      ((Element)v.get(13)).setAttribute("imagenf","" );
      ((Element)v.get(13)).setAttribute("repeat","" );
      ((Element)v.get(13)).setAttribute("padding","" );
      ((Element)v.get(13)).setAttribute("visibilidad","" );
      ((Element)v.get(13)).setAttribute("contravsb","" );
      ((Element)v.get(13)).setAttribute("x","0" );
      ((Element)v.get(13)).setAttribute("y","0" );
      ((Element)v.get(13)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));

      /* Empieza nodo:14 / Elemento padre: 13   */
      v.add(doc.createElement("table"));
      ((Element)v.get(14)).setAttribute("width","100%" );
      ((Element)v.get(14)).setAttribute("border","0" );
      ((Element)v.get(14)).setAttribute("cellspacing","0" );
      ((Element)v.get(14)).setAttribute("cellpadding","0" );
      ((Element)v.get(13)).appendChild((Element)v.get(14));

      /* Empieza nodo:15 / Elemento padre: 14   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(14)).appendChild((Element)v.get(15));

      /* Empieza nodo:16 / Elemento padre: 15   */
      v.add(doc.createElement("td"));
      ((Element)v.get(16)).setAttribute("width","12" );
      ((Element)v.get(16)).setAttribute("align","center" );
      ((Element)v.get(15)).appendChild((Element)v.get(16));

      /* Empieza nodo:17 / Elemento padre: 16   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(17)).setAttribute("src","b.gif" );
      ((Element)v.get(17)).setAttribute("width","12" );
      ((Element)v.get(17)).setAttribute("height","12" );
      ((Element)v.get(16)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */
      /* Termina nodo:16   */

      /* Empieza nodo:18 / Elemento padre: 15   */
      v.add(doc.createElement("td"));
      ((Element)v.get(18)).setAttribute("width","750" );
      ((Element)v.get(15)).appendChild((Element)v.get(18));

      /* Empieza nodo:19 / Elemento padre: 18   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(19)).setAttribute("src","b.gif" );
      ((Element)v.get(18)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */
      /* Termina nodo:18   */

      /* Empieza nodo:20 / Elemento padre: 15   */
      v.add(doc.createElement("td"));
      ((Element)v.get(20)).setAttribute("width","12" );
      ((Element)v.get(15)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(21)).setAttribute("src","b.gif" );
      ((Element)v.get(21)).setAttribute("width","12" );
      ((Element)v.get(21)).setAttribute("height","1" );
      ((Element)v.get(20)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */
      /* Termina nodo:20   */
      /* Termina nodo:15   */

      /* Empieza nodo:22 / Elemento padre: 14   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(14)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("td"));
      ((Element)v.get(22)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(24)).setAttribute("src","b.gif" );
      ((Element)v.get(23)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */
      /* Termina nodo:23   */

      /* Empieza nodo:25 / Elemento padre: 22   */
      v.add(doc.createElement("td"));
      ((Element)v.get(22)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(25)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(27)).setAttribute("class","legend" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(28)).setAttribute("nombre","lblDatosAlmacen" );
      ((Element)v.get(28)).setAttribute("alto","13" );
      ((Element)v.get(28)).setAttribute("filas","1" );
      ((Element)v.get(28)).setAttribute("valor","Datos de almacén" );
      ((Element)v.get(28)).setAttribute("id","legend" );
      ((Element)v.get(28)).setAttribute("cod","00191" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */
      /* Termina nodo:27   */

      /* Empieza nodo:29 / Elemento padre: 26   */
      v.add(doc.createElement("table"));
      ((Element)v.get(29)).setAttribute("width","100%" );
      ((Element)v.get(29)).setAttribute("border","0" );
      ((Element)v.get(29)).setAttribute("align","center" );
      ((Element)v.get(29)).setAttribute("cellspacing","0" );
      ((Element)v.get(29)).setAttribute("cellpadding","0" );
      ((Element)v.get(26)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(29)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("td"));
      ((Element)v.get(31)).setAttribute("colspan","4" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(32)).setAttribute("src","b.gif" );
      ((Element)v.get(32)).setAttribute("width","8" );
      ((Element)v.get(32)).setAttribute("height","8" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */
      /* Termina nodo:31   */
      /* Termina nodo:30   */

      /* Empieza nodo:33 / Elemento padre: 29   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(29)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("td"));
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(35)).setAttribute("src","b.gif" );
      ((Element)v.get(35)).setAttribute("width","8" );
      ((Element)v.get(35)).setAttribute("height","8" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:36 / Elemento padre: 33   */
      v.add(doc.createElement("td"));
      ((Element)v.get(33)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(37)).setAttribute("nombre","lblAlmacen" );
      ((Element)v.get(37)).setAttribute("alto","13" );
      ((Element)v.get(37)).setAttribute("filas","1" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(37)).setAttribute("id","datosTitle" );
      ((Element)v.get(37)).setAttribute("cod","797" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:38 / Elemento padre: 33   */
      v.add(doc.createElement("td"));
      ((Element)v.get(33)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(39)).setAttribute("src","b.gif" );
      ((Element)v.get(39)).setAttribute("width","25" );
      ((Element)v.get(39)).setAttribute("height","8" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:40 / Elemento padre: 33   */
      v.add(doc.createElement("td"));
      ((Element)v.get(33)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(41)).setAttribute("nombre","lblAlmacenDestino" );
      ((Element)v.get(41)).setAttribute("alto","13" );
      ((Element)v.get(41)).setAttribute("filas","1" );
      ((Element)v.get(41)).setAttribute("valor","Almacén destino" );
      ((Element)v.get(41)).setAttribute("id","datosTitle" );
      ((Element)v.get(41)).setAttribute("cod","1450" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:42 / Elemento padre: 33   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).setAttribute("width","100%" );
      ((Element)v.get(33)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(43)).setAttribute("src","b.gif" );
      ((Element)v.get(43)).setAttribute("width","8" );
      ((Element)v.get(43)).setAttribute("height","8" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */
      /* Termina nodo:33   */

      /* Empieza nodo:44 / Elemento padre: 29   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(29)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
   }

   private void getXML180(Document doc) {
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
      ((Element)v.get(47)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(44)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(48)).setAttribute("nombre","cbAlmacen" );
      ((Element)v.get(48)).setAttribute("valorinicial","0" );
      ((Element)v.get(48)).setAttribute("req","S" );
      ((Element)v.get(48)).setAttribute("multiple","N" );
      ((Element)v.get(48)).setAttribute("size","1" );
      ((Element)v.get(48)).setAttribute("id","datosCampos" );
      ((Element)v.get(48)).setAttribute("textoinicial","" );
      ((Element)v.get(48)).setAttribute("ontab","comboAlmacenD();" );
      ((Element)v.get(48)).setAttribute("onshtab","comboHasta();" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:50 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(51)).setAttribute("src","b.gif" );
      ((Element)v.get(51)).setAttribute("width","25" );
      ((Element)v.get(51)).setAttribute("height","8" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:52 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(44)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(53)).setAttribute("nombre","cbAlmacenDestino" );
      ((Element)v.get(53)).setAttribute("valorinicial","0" );
      ((Element)v.get(53)).setAttribute("req","S" );
      ((Element)v.get(53)).setAttribute("multiple","N" );
      ((Element)v.get(53)).setAttribute("size","1" );
      ((Element)v.get(53)).setAttribute("id","datosCampos" );
      ((Element)v.get(53)).setAttribute("textoinicial","" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:55 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).setAttribute("width","100%" );
      ((Element)v.get(44)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(56)).setAttribute("src","b.gif" );
      ((Element)v.get(56)).setAttribute("width","8" );
      ((Element)v.get(56)).setAttribute("height","8" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */
      /* Termina nodo:44   */

      /* Empieza nodo:57 / Elemento padre: 29   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(29)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).setAttribute("colspan","4" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(59)).setAttribute("src","b.gif" );
      ((Element)v.get(59)).setAttribute("width","8" );
      ((Element)v.get(59)).setAttribute("height","8" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */
      /* Termina nodo:57   */
      /* Termina nodo:29   */
      /* Termina nodo:26   */
      /* Termina nodo:25   */

      /* Empieza nodo:60 / Elemento padre: 22   */
      v.add(doc.createElement("td"));
      ((Element)v.get(22)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(61)).setAttribute("src","b.gif" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */
      /* Termina nodo:22   */

      /* Empieza nodo:62 / Elemento padre: 14   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(14)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(64)).setAttribute("src","b.gif" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:65 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("table"));
      ((Element)v.get(67)).setAttribute("width","100%" );
      ((Element)v.get(67)).setAttribute("border","0" );
      ((Element)v.get(67)).setAttribute("align","center" );
      ((Element)v.get(67)).setAttribute("cellspacing","0" );
      ((Element)v.get(67)).setAttribute("cellpadding","0" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).setAttribute("class","botonera" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(70)).setAttribute("nombre","btnCopiar" );
      ((Element)v.get(70)).setAttribute("ID","botonContenido" );
      ((Element)v.get(70)).setAttribute("tipo","html" );
      ((Element)v.get(70)).setAttribute("accion","onClickCopiar();" );
      ((Element)v.get(70)).setAttribute("estado","false" );
      ((Element)v.get(70)).setAttribute("cod","721" );
      ((Element)v.get(70)).setAttribute("ontab","comboAlmacenD1();" );
      ((Element)v.get(70)).setAttribute("onshtab","comboDesde()" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:71 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(72)).setAttribute("src","b.gif" );
      ((Element)v.get(72)).setAttribute("width","8" );
      ((Element)v.get(72)).setAttribute("height","12" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */
      /* Termina nodo:62   */

      /* Empieza nodo:73 / Elemento padre: 14   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(14)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).setAttribute("width","12" );
      ((Element)v.get(74)).setAttribute("align","center" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(75)).setAttribute("src","b.gif" );
      ((Element)v.get(75)).setAttribute("width","12" );
      ((Element)v.get(75)).setAttribute("height","12" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:76 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(76)).setAttribute("width","750" );
      ((Element)v.get(73)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(77)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:78 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).setAttribute("width","12" );
      ((Element)v.get(73)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).setAttribute("width","12" );
      ((Element)v.get(79)).setAttribute("height","1" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */
      /* Termina nodo:73   */
      /* Termina nodo:14   */
      /* Termina nodo:13   */
      /* Termina nodo:6   */


   }

}
