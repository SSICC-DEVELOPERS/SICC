
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_cajas_chequear2  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_cajas_chequear2" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoad()" );
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
      v.add(doc.createTextNode("\r  \r    function onLoad() {\r        configurarMenuSecundario('formulario');\r        redimensionarLista();\r    }   \r    \r    function onClickAceptar() {\r        var seleccionados = listado1.codSeleccionados();\r        var cantSeleccionados = seleccionados.length;\r\r                if (cantSeleccionados == 1) {\r            set('formulario.conectorAction', 'LPChequearCajas');\r            set('formulario.accion', 'cajaSeleccionada');\r            set('formulario.hOidEtiqueta', seleccionados[0]);\r    \r            enviaSICC('formulario');\r\r            return true;\r\r        } else if (cantSeleccionados == 0) {\r            GestionarMensaje(\"4\", null, null, null);\r            return false;\r        } else {\r            cdos_mostrarAlert(GestionarMensaje(\"240\", null, null, null));\r        }\r    }  \r    \r\r    function redimensionarLista(){\r        DrdEnsanchaConMargenDcho('listado1',12);\r        eval (ON_RSZ);\r    }    \r   \r"));
      ((Element)v.get(4)).appendChild((Text)v.get(5));

      /* Termina nodo Texto:5   */
      /* Termina nodo:4   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(7)).setAttribute("nombre","formulario" );
      ((Element)v.get(7)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","accion" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","varIdioma" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","varPais" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","hOidEtiqueta" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hNroCaja" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","hNroConsolidado" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","hCodigoCliente" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 7   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(19)).setAttribute("nombre","capaLista" );
      ((Element)v.get(19)).setAttribute("ancho","100%" );
      ((Element)v.get(19)).setAttribute("alto","580" );
      ((Element)v.get(19)).setAttribute("x","11" );
      ((Element)v.get(19)).setAttribute("y","20" );
      ((Element)v.get(19)).setAttribute("colorf","" );
      ((Element)v.get(19)).setAttribute("borde","0" );
      ((Element)v.get(19)).setAttribute("imagenf","" );
      ((Element)v.get(19)).setAttribute("repeat","" );
      ((Element)v.get(19)).setAttribute("padding","" );
      ((Element)v.get(19)).setAttribute("visibilidad","" );
      ((Element)v.get(19)).setAttribute("contravsb","" );
      ((Element)v.get(19)).setAttribute("zindex","" );
      ((Element)v.get(7)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(20)).setAttribute("nombre","listado1" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(20)).setAttribute("ancho","600" );
      ((Element)v.get(20)).setAttribute("alto","301" );
      ((Element)v.get(20)).setAttribute("x","12" );
      ((Element)v.get(20)).setAttribute("y","0" );
      ((Element)v.get(20)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(20)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(19)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(21)).setAttribute("precarga","S" );
      ((Element)v.get(21)).setAttribute("conROver","S" );
      ((Element)v.get(20)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(22)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(22)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(22)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(22)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(21)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 21   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(23)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(23)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(23)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(23)).setAttribute("aximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(21)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 21   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(24)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(24)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(21)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */
      /* Termina nodo:21   */

      /* Empieza nodo:25 / Elemento padre: 20   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(20)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(26)).setAttribute("borde","1" );
      ((Element)v.get(26)).setAttribute("horizDatos","1" );
      ((Element)v.get(26)).setAttribute("horizCabecera","1" );
      ((Element)v.get(26)).setAttribute("vertical","1" );
      ((Element)v.get(26)).setAttribute("horizTitulo","1" );
      ((Element)v.get(26)).setAttribute("horizBase","1" );
      ((Element)v.get(25)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 25   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(27)).setAttribute("borde","#999999" );
      ((Element)v.get(27)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(27)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(27)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(27)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(27)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(27)).setAttribute("horizBase","#999999" );
      ((Element)v.get(25)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */
      /* Termina nodo:25   */

      /* Empieza nodo:28 / Elemento padre: 20   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(28)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(28)).setAttribute("alto","22" );
      ((Element)v.get(28)).setAttribute("imgFondo","" );
      ((Element)v.get(28)).setAttribute("cod","00135" );
      ((Element)v.get(28)).setAttribute("ID","datosTitle" );
      ((Element)v.get(20)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 20   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(29)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(29)).setAttribute("alto","22" );
      ((Element)v.get(29)).setAttribute("imgFondo","" );
      ((Element)v.get(20)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 20   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(30)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(30)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(30)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(30)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(30)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(30)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(20)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(31)).setAttribute("ancho","100" );
      ((Element)v.get(31)).setAttribute("minimizable","S" );
      ((Element)v.get(31)).setAttribute("minimizada","N" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 30   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(32)).setAttribute("ancho","200" );
      ((Element)v.get(32)).setAttribute("minimizable","S" );
      ((Element)v.get(32)).setAttribute("minimizada","N" );
      ((Element)v.get(30)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 30   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(33)).setAttribute("ancho","100" );
      ((Element)v.get(33)).setAttribute("minimizable","S" );
      ((Element)v.get(33)).setAttribute("minimizada","N" );
      ((Element)v.get(30)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 30   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(34)).setAttribute("ancho","50" );
      ((Element)v.get(34)).setAttribute("minimizable","S" );
      ((Element)v.get(34)).setAttribute("minimizada","N" );
      ((Element)v.get(30)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 30   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(35)).setAttribute("ancho","100" );
      ((Element)v.get(35)).setAttribute("minimizable","S" );
      ((Element)v.get(35)).setAttribute("minimizada","N" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(30)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */
      /* Termina nodo:30   */

      /* Empieza nodo:36 / Elemento padre: 20   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(36)).setAttribute("alto","25" );
      ((Element)v.get(36)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(36)).setAttribute("imgFondo","" );
      ((Element)v.get(36)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(20)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(37)).setAttribute("colFondo","" );
      ((Element)v.get(37)).setAttribute("ID","EstCab" );
      ((Element)v.get(37)).setAttribute("cod","ApeCajasCheq.codCliente.label" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Elemento padre:37 / Elemento actual: 38   */
      v.add(doc.createTextNode("Cod. Cliente"));
      ((Element)v.get(37)).appendChild((Text)v.get(38));

      /* Termina nodo Texto:38   */
      /* Termina nodo:37   */

      /* Empieza nodo:39 / Elemento padre: 36   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(39)).setAttribute("colFondo","" );
      ((Element)v.get(39)).setAttribute("ID","EstCab" );
      ((Element)v.get(39)).setAttribute("cod","ApeCajasCheq.nombreCliente.label" );
      ((Element)v.get(36)).appendChild((Element)v.get(39));

      /* Elemento padre:39 / Elemento actual: 40   */
      v.add(doc.createTextNode("Nombre cliente"));
      ((Element)v.get(39)).appendChild((Text)v.get(40));

      /* Termina nodo Texto:40   */
      /* Termina nodo:39   */

      /* Empieza nodo:41 / Elemento padre: 36   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(41)).setAttribute("colFondo","" );
      ((Element)v.get(41)).setAttribute("ID","EstCab" );
      ((Element)v.get(41)).setAttribute("cod","ApeCajasCheq.nroConsolidado.label" );
      ((Element)v.get(36)).appendChild((Element)v.get(41));

      /* Elemento padre:41 / Elemento actual: 42   */
      v.add(doc.createTextNode("N° consolidado"));
      ((Element)v.get(41)).appendChild((Text)v.get(42));

      /* Termina nodo Texto:42   */
      /* Termina nodo:41   */

      /* Empieza nodo:43 / Elemento padre: 36   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(43)).setAttribute("colFondo","" );
      ((Element)v.get(43)).setAttribute("ID","EstCab" );
      ((Element)v.get(43)).setAttribute("cod","ApeCajasCheq.nroCaja.label" );
      ((Element)v.get(36)).appendChild((Element)v.get(43));

      /* Elemento padre:43 / Elemento actual: 44   */
      v.add(doc.createTextNode("N° caja"));
      ((Element)v.get(43)).appendChild((Text)v.get(44));

      /* Termina nodo Texto:44   */
      /* Termina nodo:43   */

      /* Empieza nodo:45 / Elemento padre: 36   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(45)).setAttribute("colFondo","" );
      ((Element)v.get(45)).setAttribute("ID","EstCab" );
      ((Element)v.get(45)).setAttribute("cod","ApeCajasCheq.fechaCreacion.label" );
      ((Element)v.get(36)).appendChild((Element)v.get(45));

      /* Elemento padre:45 / Elemento actual: 46   */
      v.add(doc.createTextNode("Fecha creación"));
      ((Element)v.get(45)).appendChild((Text)v.get(46));

      /* Termina nodo Texto:46   */
      /* Termina nodo:45   */
      /* Termina nodo:36   */

      /* Empieza nodo:47 / Elemento padre: 20   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(47)).setAttribute("alto","22" );
      ((Element)v.get(47)).setAttribute("accion","" );
      ((Element)v.get(47)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(47)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(47)).setAttribute("maxSel","-1" );
      ((Element)v.get(47)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(47)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(47)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(47)).setAttribute("onLoad","" );
      ((Element)v.get(47)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(20)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(48)).setAttribute("tipo","texto" );
      ((Element)v.get(48)).setAttribute("ID","EstDat" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 47   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(49)).setAttribute("tipo","texto" );
      ((Element)v.get(49)).setAttribute("ID","EstDat2" );
      ((Element)v.get(47)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 47   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(50)).setAttribute("tipo","texto" );
      ((Element)v.get(50)).setAttribute("ID","EstDat" );
      ((Element)v.get(47)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 47   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(51)).setAttribute("tipo","texto" );
      ((Element)v.get(51)).setAttribute("ID","EstDat2" );
      ((Element)v.get(47)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 47   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(52)).setAttribute("tipo","texto" );
      ((Element)v.get(52)).setAttribute("ID","EstDat" );
      ((Element)v.get(47)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:47   */

      /* Empieza nodo:53 / Elemento padre: 20   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(20)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 20   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(54)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(54)).setAttribute("ancho","679" );
      ((Element)v.get(54)).setAttribute("sep","$" );
      ((Element)v.get(54)).setAttribute("x","12" );
      ((Element)v.get(54)).setAttribute("class","botonera" );
      ((Element)v.get(54)).setAttribute("y","294" );
      ((Element)v.get(54)).setAttribute("control","|" );
      ((Element)v.get(54)).setAttribute("conector","ConectorBuscarCargosAbonos" );
      ((Element)v.get(54)).setAttribute("rowset","" );
      ((Element)v.get(54)).setAttribute("cargainicial","N" );
      ((Element)v.get(20)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:20   */

      /* Empieza nodo:55 / Elemento padre: 19   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(55)).setAttribute("nombre","Aceptar" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(55)).setAttribute("x","13" );
      ((Element)v.get(55)).setAttribute("y","279" );
      ((Element)v.get(55)).setAttribute("ID","botonContenido" );
      ((Element)v.get(55)).setAttribute("tipo","html" );
      ((Element)v.get(55)).setAttribute("estado","false" );
      ((Element)v.get(55)).setAttribute("cod","ApeCajasCheq.aceptar.label" );
      ((Element)v.get(55)).setAttribute("accion","onClickAceptar();" );
      ((Element)v.get(19)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:19   */
      /* Termina nodo:7   */


   }

}
