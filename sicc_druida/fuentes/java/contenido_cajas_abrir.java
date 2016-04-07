
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_cajas_abrir  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_cajas_abrir" );
      ((Element)v.get(0)).setAttribute("cod","0673" );
      ((Element)v.get(0)).setAttribute("titulo","Abrir cajas" );
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
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(2));

      /* Elemento padre:2 / Elemento actual: 3   */
      v.add(doc.createTextNode("\r   \r\r  function onLoadPag()   {\r\r    configurarMenuSecundario('frmFormulario');\r    \r  \r    DrdEnsanchaConMargenDcho('listado1',12);\r    document.all[\"Cplistado1\"].style.visibility='';\r    document.all[\"CpLin1listado1\"].style.visibility='';\r    document.all[\"CpLin2listado1\"].style.visibility='';\r    document.all[\"CpLin3listado1\"].style.visibility='';\r    document.all[\"CpLin4listado1\"].style.visibility='';\r\r    document.all[\"primera1Div\"].style.visibility='hidden';\r    document.all[\"ret1Div\"].style.visibility='hidden';\r    document.all[\"ava1Div\"].style.visibility='hidden'; \r    document.all[\"separaDiv\"].style.visibility='hidden';\r    document.all[\"btnAperturaMasivaDiv\"].style.visibility='';\r    eval (ON_RSZ);  \r    fMostrarMensajeError();\r\r   }\r\r\r   function accionAperturaMasiva(){\r      var datosEnviar = new Array();\r\r      listado1.actualizaDat();\r\r      if(listado1.datos.length > 0){\r\r        var datos = listado1.datos;\r\r        for(var i=0; i < listado1.datos.length;i++) {\r           datos[i][2] = '1'\r           datosEnviar[datosEnviar.length] = datos[i][0];\r         }\r\r         listado1.setDatos(datos);\r         \r         set('frmFormulario.datosEnviar', datosEnviar);\r         set('frmFormulario.accion', 'guardar');\r         set('frmFormulario.conectorAction', 'LPAbrirCajas');\r         enviaSICC('frmFormulario');\r      }\r   }\r\r   function fGuardar(){\r      listado1.actualizaDat();\r      var bandera = false;\r      var datosEnviar = new Array();\r      \r      if(listado1.datos.length > 0){\r         for(var i=0; i < listado1.datos.length;i++) {\r            if(listado1.datos[i][2] == '1'){\r               datosEnviar[datosEnviar.length] = listado1.datos[i][0];\r               bandera = true;\r            }\r         }\r      }\r      \r      if(bandera){\r         set('frmFormulario.datosEnviar', datosEnviar);\r         set('frmFormulario.accion', 'guardar');\r         set('frmFormulario.conectorAction', 'LPAbrirCajas');\r         enviaSICC('frmFormulario');\r      }\r   }\r\r   \r"));
      ((Element)v.get(2)).appendChild((Text)v.get(3));

      /* Termina nodo Texto:3   */
      /* Termina nodo:2   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(4)).setAttribute("nombre","frmFormulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Empieza nodo:5 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(5)).setAttribute("nombre","accion" );
      ((Element)v.get(5)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(6)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","datosEnviar" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 4   */
      v.add(doc.createElement("table"));
      ((Element)v.get(10)).setAttribute("width","100%" );
      ((Element)v.get(10)).setAttribute("border","0" );
      ((Element)v.get(10)).setAttribute("cellspacing","0" );
      ((Element)v.get(10)).setAttribute("cellpadding","0" );
      ((Element)v.get(4)).appendChild((Element)v.get(10));

      /* Empieza nodo:11 / Elemento padre: 10   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(10)).appendChild((Element)v.get(11));

      /* Empieza nodo:12 / Elemento padre: 11   */
      v.add(doc.createElement("td"));
      ((Element)v.get(12)).setAttribute("width","100%" );
      ((Element)v.get(11)).appendChild((Element)v.get(12));

      /* Empieza nodo:13 / Elemento padre: 12   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(13)).setAttribute("src","b.gif" );
      ((Element)v.get(13)).setAttribute("width","424" );
      ((Element)v.get(13)).setAttribute("height","8" );
      ((Element)v.get(12)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */
      /* Termina nodo:12   */
      /* Termina nodo:11   */
      /* Termina nodo:10   */

      /* Empieza nodo:14 / Elemento padre: 4   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(14)).setAttribute("nombre","listado1" );
      ((Element)v.get(14)).setAttribute("ancho","400" );
      ((Element)v.get(14)).setAttribute("alto","301" );
      ((Element)v.get(14)).setAttribute("x","12" );
      ((Element)v.get(14)).setAttribute("y","12" );
      ((Element)v.get(14)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(14)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(4)).appendChild((Element)v.get(14));

      /* Empieza nodo:15 / Elemento padre: 14   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(15)).setAttribute("precarga","S" );
      ((Element)v.get(15)).setAttribute("conROver","S" );
      ((Element)v.get(14)).appendChild((Element)v.get(15));

      /* Empieza nodo:16 / Elemento padre: 15   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(16)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(16)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(16)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(16)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(15)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 15   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(17)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(17)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(17)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(17)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(15)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 15   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(18)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(18)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(15)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */
      /* Termina nodo:15   */

      /* Empieza nodo:19 / Elemento padre: 14   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(14)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(20)).setAttribute("borde","1" );
      ((Element)v.get(20)).setAttribute("horizDatos","1" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(20)).setAttribute("horizCabecera","1" );
      ((Element)v.get(20)).setAttribute("vertical","1" );
      ((Element)v.get(20)).setAttribute("horizTitulo","1" );
      ((Element)v.get(20)).setAttribute("horizBase","1" );
      ((Element)v.get(19)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 19   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(21)).setAttribute("borde","#999999" );
      ((Element)v.get(21)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(21)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(21)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(21)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(21)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(21)).setAttribute("horizBase","#999999" );
      ((Element)v.get(19)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */
      /* Termina nodo:19   */

      /* Empieza nodo:22 / Elemento padre: 14   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(22)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(22)).setAttribute("alto","22" );
      ((Element)v.get(22)).setAttribute("imgFondo","" );
      ((Element)v.get(22)).setAttribute("ID","datosTitle" );
      ((Element)v.get(22)).setAttribute("cod","00568" );
      ((Element)v.get(14)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 14   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(23)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(23)).setAttribute("alto","22" );
      ((Element)v.get(23)).setAttribute("imgFondo","" );
      ((Element)v.get(14)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 14   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(24)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(24)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(24)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(24)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(24)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(24)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(14)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(25)).setAttribute("ancho","80" );
      ((Element)v.get(25)).setAttribute("minimizable","S" );
      ((Element)v.get(25)).setAttribute("minimizada","N" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 24   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(26)).setAttribute("ancho","30" );
      ((Element)v.get(26)).setAttribute("minimizable","S" );
      ((Element)v.get(26)).setAttribute("minimizada","N" );
      ((Element)v.get(24)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */
      /* Termina nodo:24   */

      /* Empieza nodo:27 / Elemento padre: 14   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(27)).setAttribute("alto","20" );
      ((Element)v.get(27)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(27)).setAttribute("imgFondo","" );
      ((Element)v.get(27)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(14)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(28)).setAttribute("colFondo","" );
      ((Element)v.get(28)).setAttribute("ID","EstCab" );
      ((Element)v.get(28)).setAttribute("align","center" );
      ((Element)v.get(28)).setAttribute("cod","1573" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));

      /* Elemento padre:28 / Elemento actual: 29   */
      v.add(doc.createTextNode("Caja"));
      ((Element)v.get(28)).appendChild((Text)v.get(29));

      /* Termina nodo Texto:29   */
      /* Termina nodo:28   */

      /* Empieza nodo:30 / Elemento padre: 27   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(30)).setAttribute("colFondo","" );
      ((Element)v.get(30)).setAttribute("ID","EstCab" );
      ((Element)v.get(30)).setAttribute("cod","400" );
      ((Element)v.get(27)).appendChild((Element)v.get(30));

      /* Elemento padre:30 / Elemento actual: 31   */
      v.add(doc.createTextNode("Estado"));
      ((Element)v.get(30)).appendChild((Text)v.get(31));

      /* Termina nodo Texto:31   */
      /* Termina nodo:30   */
      /* Termina nodo:27   */

      /* Empieza nodo:32 / Elemento padre: 14   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(32)).setAttribute("alto","22" );
      ((Element)v.get(32)).setAttribute("accion","" );
      ((Element)v.get(32)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(32)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(32)).setAttribute("maxSel","-1" );
      ((Element)v.get(32)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(32)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(32)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(32)).setAttribute("onLoad","" );
      ((Element)v.get(32)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(14)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(33)).setAttribute("tipo","texto" );
      ((Element)v.get(33)).setAttribute("ID","EstDat" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 32   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(34)).setAttribute("tipo","combo" );
      ((Element)v.get(34)).setAttribute("nombre","cbEstado" );
      ((Element)v.get(34)).setAttribute("IDOBJ","EstDatForm" );
      ((Element)v.get(34)).setAttribute("ID","EstDat2" );
      ((Element)v.get(32)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("ROW"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(36)).setAttribute("ID","1" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(37)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(37)).setAttribute("TIPO","STRING" );
      ((Element)v.get(37)).setAttribute("VALOR","0" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 36   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(38)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(38)).setAttribute("TIPO","STRING" );
      ((Element)v.get(38)).setAttribute("VALOR","Cerrado" );
      ((Element)v.get(36)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */
      /* Termina nodo:36   */

      /* Empieza nodo:39 / Elemento padre: 35   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(39)).setAttribute("ID","2" );
      ((Element)v.get(35)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(40)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(40)).setAttribute("TIPO","STRING" );
      ((Element)v.get(40)).setAttribute("VALOR","1" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 39   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(41)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(41)).setAttribute("TIPO","STRING" );
      ((Element)v.get(41)).setAttribute("VALOR","Abierto" );
      ((Element)v.get(39)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:39   */
      /* Termina nodo:35   */
      /* Termina nodo:34   */
      /* Termina nodo:32   */

      /* Empieza nodo:42 / Elemento padre: 14   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(14)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 14   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(43)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(43)).setAttribute("ancho","400" );
      ((Element)v.get(43)).setAttribute("sep","$" );
      ((Element)v.get(43)).setAttribute("x","12" );
      ((Element)v.get(43)).setAttribute("class","botonera" );
      ((Element)v.get(43)).setAttribute("y","290" );
      ((Element)v.get(43)).setAttribute("control","|" );
      ((Element)v.get(43)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(43)).setAttribute("rowset","" );
      ((Element)v.get(43)).setAttribute("cargainicial","N" );
      ((Element)v.get(14)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(44)).setAttribute("nombre","ret1" );
      ((Element)v.get(44)).setAttribute("x","37" );
      ((Element)v.get(44)).setAttribute("y","294" );
      ((Element)v.get(44)).setAttribute("ID","botonContenido" );
      ((Element)v.get(44)).setAttribute("img","retroceder_on" );
      ((Element)v.get(44)).setAttribute("tipo","0" );
      ((Element)v.get(44)).setAttribute("estado","false" );
      ((Element)v.get(44)).setAttribute("alt","" );
      ((Element)v.get(44)).setAttribute("codigo","" );
      ((Element)v.get(44)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 43   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(45)).setAttribute("nombre","ava1" );
      ((Element)v.get(45)).setAttribute("x","52" );
      ((Element)v.get(45)).setAttribute("y","294" );
      ((Element)v.get(45)).setAttribute("ID","botonContenido" );
      ((Element)v.get(45)).setAttribute("img","avanzar_on" );
      ((Element)v.get(45)).setAttribute("tipo","0" );
      ((Element)v.get(45)).setAttribute("estado","false" );
      ((Element)v.get(45)).setAttribute("alt","" );
      ((Element)v.get(45)).setAttribute("codigo","" );
      ((Element)v.get(45)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(43)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:43   */
      /* Termina nodo:14   */

      /* Empieza nodo:46 / Elemento padre: 4   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(46)).setAttribute("nombre","primera1" );
      ((Element)v.get(46)).setAttribute("x","20" );
      ((Element)v.get(46)).setAttribute("y","294" );
      ((Element)v.get(46)).setAttribute("ID","botonContenido" );
      ((Element)v.get(46)).setAttribute("img","primera_on" );
      ((Element)v.get(46)).setAttribute("tipo","-2" );
      ((Element)v.get(46)).setAttribute("estado","false" );
      ((Element)v.get(46)).setAttribute("alt","" );
      ((Element)v.get(46)).setAttribute("codigo","" );
      ((Element)v.get(46)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(4)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 4   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(47)).setAttribute("nombre","separa" );
      ((Element)v.get(47)).setAttribute("x","59" );
      ((Element)v.get(47)).setAttribute("y","290" );
      ((Element)v.get(47)).setAttribute("ID","botonContenido" );
      ((Element)v.get(47)).setAttribute("img","separa_base" );
      ((Element)v.get(47)).setAttribute("tipo","0" );
      ((Element)v.get(47)).setAttribute("estado","false" );
      ((Element)v.get(47)).setAttribute("alt","" );
      ((Element)v.get(47)).setAttribute("codigo","" );
      ((Element)v.get(47)).setAttribute("accion","" );
      ((Element)v.get(4)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 4   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(48)).setAttribute("nombre","btnAperturaMasiva" );
      ((Element)v.get(48)).setAttribute("x","13" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(48)).setAttribute("y","291" );
      ((Element)v.get(48)).setAttribute("ID","botonContenido" );
      ((Element)v.get(48)).setAttribute("img","" );
      ((Element)v.get(48)).setAttribute("tipo","html" );
      ((Element)v.get(48)).setAttribute("estado","false" );
      ((Element)v.get(48)).setAttribute("accion","accionAperturaMasiva();" );
      ((Element)v.get(48)).setAttribute("cod","2310" );
      ((Element)v.get(4)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(49)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(49)).setAttribute("alto","12" );
      ((Element)v.get(49)).setAttribute("ancho","100%" );
      ((Element)v.get(49)).setAttribute("colorf","" );
      ((Element)v.get(49)).setAttribute("borde","0" );
      ((Element)v.get(49)).setAttribute("imagenf","" );
      ((Element)v.get(49)).setAttribute("repeat","" );
      ((Element)v.get(49)).setAttribute("padding","" );
      ((Element)v.get(49)).setAttribute("visibilidad","visible" );
      ((Element)v.get(49)).setAttribute("contravsb","" );
      ((Element)v.get(49)).setAttribute("x","0" );
      ((Element)v.get(49)).setAttribute("y","313" );
      ((Element)v.get(49)).setAttribute("zindex","" );
      ((Element)v.get(4)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:4   */


   }

}
