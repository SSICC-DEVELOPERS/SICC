
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_favoritos_seleccionar  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         

      getXML180(doc);
         

      getXML270(doc);
         

      getXML360(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_favoritos_seleccionar" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("cod","043" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(2)).setAttribute("src",".js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(3));

      /* Elemento padre:3 / Elemento actual: 4   */
      v.add(doc.createTextNode("\r  \r\r  function onLoadPag()   {\r\r    if ( get(\"frmContenido.grabo\") == \"\") {\r\r      configurarMenuSecundario(\"frmContenido\");\r      DrdEnsanchaConMargenDcho('listado1',12);\r      document.all[\"Cplistado1\"].style.visibility='';\r      document.all[\"CpLin1listado1\"].style.visibility='';\r      document.all[\"CpLin2listado1\"].style.visibility='';\r      document.all[\"CpLin3listado1\"].style.visibility='';\r      document.all[\"CpLin4listado1\"].style.visibility='';\r      document.all[\"prim1Div\"].style.visibility='';\r      document.all[\"ret1Div\"].style.visibility='';\r      document.all[\"ava1Div\"].style.visibility='';\r\r      eval (ON_RSZ);\r    \r      if(!fMostrarMensajeError()){\r      }\r    }else{\r    \r      parent.frames(\"menu\").location.reload();\r      set(\"frmContenido.conectorAction\",\"LPInicioBelcorp\");\r      enviaSICC(\"frmContenido\");\r    }\r   }\r   \r  function funcionOnClick(nOid, cNombreFunc)   {\r  \r    var arrayVerificRepe = new Array();\r    arrayVerificRepe = listado1.codigos();\r\r        for(var i=0; i<arrayVerificRepe.length; i++) {\r      if (arrayVerificRepe[i] == nOid) {\r                return false;\r      }\r    }\r    var cPathCompletoFunc = obtengoRuta(nOid);\r    agregarFavorito(nOid, cPathCompletoFunc);\r   }\r\r  function obtengoRuta(nId) {\r  \r    var cRuta;\r    var cOrig;\r    var arrayRutaOrig = new Array();\r    cRuta = \"Menu/\";\r\r    for(var i=0; i<name1.entradas.length; i++) {\r            if (name1.entradas[i][2] == nId) {\r         cOrig = name1.entradas[i][0];\r         arrayRutaOrig = cOrig.split(\".name\");\r                  for(var j=0; j<arrayRutaOrig.length; j++) {\r           for(var h=0; h<name1.entradas.length; h++) {\r             if (arrayRutaOrig[j] == name1.entradas[h][2]) {\r                                cRuta = cRuta + name1.entradas[h][3] + '/';\r                break;\r             } \r           }\r         } \r      }\r    }\r    cRuta = cRuta.substr(0, (cRuta.length-1));\r    return cRuta;\r  }\r  \r  function agregarFavorito(v1, v2)   {\r    var nuevaFila = new Array();\r    \r    nuevaFila[0] = v1;\r    nuevaFila[1] = v2;\r\r    listado1.insertar(nuevaFila);\r   }\r\r  function fGuardar()   {\r                  set('frmContenido.accion','Guardar');\r    set('frmContenido.elemPrimColumn', listado1.codigos());\r                  postForm();\r                  return true;\r  }   \r\r  function fBorrar()   {\r    listado1.eliminarSelecc();    \r  }\r\r  function postForm() {\r           enviaSICC(\"frmContenido\");\r  }\r   \r    \r  "));
      ((Element)v.get(3)).appendChild((Text)v.get(4));

      /* Termina nodo Texto:4   */
      /* Termina nodo:3   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(5)).setAttribute("nombre","frmContenido" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","accion" );
      ((Element)v.get(6)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(7)).setAttribute("valor","LPSeleccionarFuncionesFavoritas" );
      ((Element)v.get(5)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","hidSeleccionados" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","hidAsignados" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","SICC_TOOLBAR_CONFIG" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","exito" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","elemPrimColumn" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","grabo" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(16)).setAttribute("nombre","capaPrincipal" );
      ((Element)v.get(16)).setAttribute("x","0" );
      ((Element)v.get(16)).setAttribute("y","0" );
      ((Element)v.get(5)).appendChild((Element)v.get(16));

      /* Empieza nodo:17 / Elemento padre: 16   */
      v.add(doc.createElement("table"));
      ((Element)v.get(17)).setAttribute("width","100%" );
      ((Element)v.get(17)).setAttribute("border","0" );
      ((Element)v.get(17)).setAttribute("cellspacing","0" );
      ((Element)v.get(17)).setAttribute("cellpadding","0" );
      ((Element)v.get(16)).appendChild((Element)v.get(17));

      /* Empieza nodo:18 / Elemento padre: 17   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(17)).appendChild((Element)v.get(18));

      /* Empieza nodo:19 / Elemento padre: 18   */
      v.add(doc.createElement("td"));
      ((Element)v.get(19)).setAttribute("width","12" );
      ((Element)v.get(19)).setAttribute("align","center" );
      ((Element)v.get(18)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(20)).setAttribute("src","b.gif" );
      ((Element)v.get(20)).setAttribute("width","12" );
      ((Element)v.get(20)).setAttribute("height","12" );
      ((Element)v.get(19)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */
      /* Termina nodo:19   */

      /* Empieza nodo:21 / Elemento padre: 18   */
      v.add(doc.createElement("td"));
      ((Element)v.get(21)).setAttribute("width","750" );
      ((Element)v.get(18)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(22)).setAttribute("src","b.gif" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(21)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */
      /* Termina nodo:21   */

      /* Empieza nodo:23 / Elemento padre: 18   */
      v.add(doc.createElement("td"));
      ((Element)v.get(23)).setAttribute("width","12" );
      ((Element)v.get(18)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(24)).setAttribute("src","b.gif" );
      ((Element)v.get(24)).setAttribute("width","12" );
      ((Element)v.get(24)).setAttribute("height","1" );
      ((Element)v.get(23)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */
      /* Termina nodo:23   */
      /* Termina nodo:18   */

      /* Empieza nodo:25 / Elemento padre: 17   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(17)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(25)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(27)).setAttribute("src","b.gif" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */
      /* Termina nodo:26   */

      /* Empieza nodo:28 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(25)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(28)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(30)).setAttribute("class","legend" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(31)).setAttribute("nombre","lblListaFunciones" );
      ((Element)v.get(31)).setAttribute("alto","13" );
      ((Element)v.get(31)).setAttribute("filas","1" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(31)).setAttribute("id","legend" );
      ((Element)v.get(31)).setAttribute("cod","00505" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */
      /* Termina nodo:30   */

      /* Empieza nodo:32 / Elemento padre: 29   */
      v.add(doc.createElement("table"));
      ((Element)v.get(32)).setAttribute("width","100%" );
      ((Element)v.get(32)).setAttribute("border","0" );
      ((Element)v.get(32)).setAttribute("align","center" );
      ((Element)v.get(32)).setAttribute("cellspacing","0" );
      ((Element)v.get(32)).setAttribute("cellpadding","0" );
      ((Element)v.get(29)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(32)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("td"));
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("table"));
      ((Element)v.get(35)).setAttribute("width","605" );
      ((Element)v.get(35)).setAttribute("border","0" );
      ((Element)v.get(35)).setAttribute("align","left" );
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
      ((Element)v.get(38)).setAttribute("width","8" );
      ((Element)v.get(38)).setAttribute("height","230" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */
      /* Termina nodo:37   */

      /* Empieza nodo:39 / Elemento padre: 36   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).setAttribute("width","100%" );
      ((Element)v.get(36)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(40)).setAttribute("src","b.gif" );
      ((Element)v.get(40)).setAttribute("width","500" );
      ((Element)v.get(40)).setAttribute("height","8" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */
      /* Termina nodo:39   */
      /* Termina nodo:36   */
      /* Termina nodo:35   */
      /* Termina nodo:34   */
      /* Termina nodo:33   */
      /* Termina nodo:32   */
      /* Termina nodo:29   */
      /* Termina nodo:28   */

      /* Empieza nodo:41 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(25)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(42)).setAttribute("src","b.gif" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */
      /* Termina nodo:41   */
      /* Termina nodo:25   */

      /* Empieza nodo:43 / Elemento padre: 17   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(17)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).setAttribute("width","12" );
      ((Element)v.get(44)).setAttribute("align","center" );
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
      ((Element)v.get(46)).setAttribute("width","756" );
      ((Element)v.get(43)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(47)).setAttribute("src","b.gif" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:48 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).setAttribute("width","12" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(43)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(49)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).setAttribute("width","12" );
      ((Element)v.get(49)).setAttribute("height","1" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */
      /* Termina nodo:43   */
      /* Termina nodo:17   */
      /* Termina nodo:16   */

      /* Empieza nodo:50 / Elemento padre: 5   */
      v.add(doc.createElement("SCROLL"));
      ((Element)v.get(50)).setAttribute("nombre","miscroll" );
      ((Element)v.get(50)).setAttribute("x","20" );
      ((Element)v.get(50)).setAttribute("y","28" );
      ((Element)v.get(50)).setAttribute("ancho","800" );
      ((Element)v.get(50)).setAttribute("alto","250" );
      ((Element)v.get(50)).setAttribute("colorf","" );
      ((Element)v.get(50)).setAttribute("visibilidad","visible" );
      ((Element)v.get(50)).setAttribute("incx","10" );
      ((Element)v.get(50)).setAttribute("incy","10" );
      ((Element)v.get(50)).setAttribute("colores","" );
      ((Element)v.get(5)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("REJILLA"));
      ((Element)v.get(51)).setAttribute("nombre","RArbol" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:52 / Elemento padre: 5   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(52)).setAttribute("nombre","listado1" );
      ((Element)v.get(52)).setAttribute("ancho","608" );
      ((Element)v.get(52)).setAttribute("alto","301" );
      ((Element)v.get(52)).setAttribute("x","12" );
      ((Element)v.get(52)).setAttribute("y","281" );
      ((Element)v.get(52)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(52)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(5)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(53)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(53)).setAttribute("alto","22" );
      ((Element)v.get(53)).setAttribute("imgFondo","" );
      ((Element)v.get(53)).setAttribute("cod","00533" );
      ((Element)v.get(53)).setAttribute("ID","datosTitle" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 52   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(54)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(54)).setAttribute("alto","22" );
      ((Element)v.get(54)).setAttribute("imgFondo","" );
      ((Element)v.get(52)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 52   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(55)).setAttribute("precarga","S" );
      ((Element)v.get(55)).setAttribute("conROver","S" );
      ((Element)v.get(52)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(56)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(56)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(56)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(56)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 55   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(57)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(57)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(57)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(57)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(55)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 55   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(58)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(58)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(55)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:55   */

      /* Empieza nodo:59 / Elemento padre: 52   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(52)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(60)).setAttribute("borde","1" );
      ((Element)v.get(60)).setAttribute("horizDatos","1" );
      ((Element)v.get(60)).setAttribute("horizCabecera","1" );
      ((Element)v.get(60)).setAttribute("vertical","1" );
      ((Element)v.get(60)).setAttribute("horizTitulo","1" );
      ((Element)v.get(60)).setAttribute("horizBase","1" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */

      /* Empieza nodo:61 / Elemento padre: 59   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(61)).setAttribute("borde","#999999" );
      ((Element)v.get(61)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(61)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(61)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(61)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(61)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(61)).setAttribute("horizBase","#999999" );
      ((Element)v.get(59)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:59   */

      /* Empieza nodo:62 / Elemento padre: 52   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(62)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(62)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(62)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(62)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(62)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(62)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(52)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("COL"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(63)).setAttribute("ancho","30" );
      ((Element)v.get(63)).setAttribute("minimizable","S" );
      ((Element)v.get(63)).setAttribute("minimizada","N" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:64 / Elemento padre: 52   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(64)).setAttribute("alto","20" );
      ((Element)v.get(64)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(64)).setAttribute("imgFondo","" );
      ((Element)v.get(64)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(52)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(65)).setAttribute("colFondo","" );
      ((Element)v.get(65)).setAttribute("ID","EstCab" );
      ((Element)v.get(65)).setAttribute("align","center" );
      ((Element)v.get(65)).setAttribute("cod","2260" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:66 / Elemento padre: 52   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(66)).setAttribute("alto","22" );
      ((Element)v.get(66)).setAttribute("accion","" );
      ((Element)v.get(66)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(66)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(66)).setAttribute("maxSel","-1" );
      ((Element)v.get(66)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(66)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(66)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(66)).setAttribute("onLoad","" );
      ((Element)v.get(66)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(52)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(67)).setAttribute("tipo","texto" );
      ((Element)v.get(67)).setAttribute("ID","EstDat2" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:68 / Elemento padre: 52   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(52)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */

      /* Empieza nodo:69 / Elemento padre: 52   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(69)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(69)).setAttribute("ancho","608" );
      ((Element)v.get(69)).setAttribute("sep","$" );
      ((Element)v.get(69)).setAttribute("x","12" );
      ((Element)v.get(69)).setAttribute("class","botonera" );
      ((Element)v.get(69)).setAttribute("y","559" );
      ((Element)v.get(69)).setAttribute("control","|" );
      ((Element)v.get(69)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(69)).setAttribute("rowset","" );
      ((Element)v.get(69)).setAttribute("cargainicial","N" );
      ((Element)v.get(52)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(70)).setAttribute("nombre","ret1" );
      ((Element)v.get(70)).setAttribute("x","37" );
      ((Element)v.get(70)).setAttribute("y","563" );
      ((Element)v.get(70)).setAttribute("ID","botonContenido" );
      ((Element)v.get(70)).setAttribute("img","retroceder_on" );
      ((Element)v.get(70)).setAttribute("tipo","0" );
      ((Element)v.get(70)).setAttribute("estado","false" );
      ((Element)v.get(70)).setAttribute("alt","" );
      ((Element)v.get(70)).setAttribute("codigo","" );
      ((Element)v.get(70)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */

      /* Empieza nodo:71 / Elemento padre: 69   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(71)).setAttribute("nombre","ava1" );
      ((Element)v.get(71)).setAttribute("x","52" );
      ((Element)v.get(71)).setAttribute("y","563" );
      ((Element)v.get(71)).setAttribute("ID","botonContenido" );
      ((Element)v.get(71)).setAttribute("img","avanzar_on" );
      ((Element)v.get(71)).setAttribute("tipo","0" );
      ((Element)v.get(71)).setAttribute("estado","false" );
      ((Element)v.get(71)).setAttribute("alt","" );
      ((Element)v.get(71)).setAttribute("codigo","" );
      ((Element)v.get(71)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(69)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:69   */
      /* Termina nodo:52   */

      /* Empieza nodo:72 / Elemento padre: 5   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(72)).setAttribute("nombre","prim1" );
      ((Element)v.get(72)).setAttribute("x","20" );
      ((Element)v.get(72)).setAttribute("y","563" );
      ((Element)v.get(72)).setAttribute("ID","botonContenido" );
      ((Element)v.get(72)).setAttribute("img","primera_on" );
      ((Element)v.get(72)).setAttribute("tipo","-2" );
      ((Element)v.get(72)).setAttribute("estado","false" );
      ((Element)v.get(72)).setAttribute("alt","" );
      ((Element)v.get(72)).setAttribute("codigo","" );
      ((Element)v.get(72)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(5)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */

      /* Empieza nodo:73 / Elemento padre: 5   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(73)).setAttribute("nombre","separa" );
      ((Element)v.get(73)).setAttribute("x","59" );
      ((Element)v.get(73)).setAttribute("y","559" );
      ((Element)v.get(73)).setAttribute("ID","botonContenido" );
      ((Element)v.get(73)).setAttribute("img","separa_base" );
      ((Element)v.get(73)).setAttribute("tipo","0" );
      ((Element)v.get(73)).setAttribute("estado","false" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(73)).setAttribute("alt","" );
      ((Element)v.get(73)).setAttribute("codigo","" );
      ((Element)v.get(73)).setAttribute("accion","" );
      ((Element)v.get(5)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */

      /* Empieza nodo:74 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(74)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(74)).setAttribute("x","0" );
      ((Element)v.get(74)).setAttribute("y","582" );
      ((Element)v.get(74)).setAttribute("alto","12" );
      ((Element)v.get(74)).setAttribute("ancho","50" );
      ((Element)v.get(5)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:5   */


   }

}
