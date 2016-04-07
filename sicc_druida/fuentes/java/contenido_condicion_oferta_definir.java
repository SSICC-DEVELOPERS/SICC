
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_condicion_oferta_definir  implements es.indra.druida.base.ObjetoXML {
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
         

      getXML990(doc);
         

      getXML1080(doc);
         

      getXML1170(doc);
         

      getXML1260(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_condicion_oferta_definir" );
      ((Element)v.get(0)).setAttribute("cod","0187" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(2)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","contenido_condicion_oferta_definir.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Empieza nodo:5 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(5)).setAttribute("name","cbCatalogo" );
      ((Element)v.get(5)).setAttribute("required","true" );
      ((Element)v.get(5)).setAttribute("cod","516" );
      ((Element)v.get(5)).setAttribute("group","grgral" );
      ((Element)v.get(4)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(6)).setAttribute("name","txtPaginaDesde" );
      ((Element)v.get(6)).setAttribute("required","true" );
      ((Element)v.get(6)).setAttribute("format","e" );
      ((Element)v.get(6)).setAttribute("cod","512" );
      ((Element)v.get(6)).setAttribute("group","grpags" );
      ((Element)v.get(6)).setAttribute("min","0" );
      ((Element)v.get(6)).setAttribute("max","999" );
      ((Element)v.get(4)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","cbIndicadorCuadre" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("cod","461" );
      ((Element)v.get(7)).setAttribute("group","grinicial" );
      ((Element)v.get(4)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","txtFactorCuadre" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","459" );
      ((Element)v.get(8)).setAttribute("format","e" );
      ((Element)v.get(8)).setAttribute("min","1" );
      ((Element)v.get(8)).setAttribute("max","9999999999" );
      ((Element)v.get(8)).setAttribute("group","grinicial" );
      ((Element)v.get(4)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","txtPaginaHasta" );
      ((Element)v.get(9)).setAttribute("required","false" );
      ((Element)v.get(9)).setAttribute("format","e" );
      ((Element)v.get(9)).setAttribute("cod","513" );
      ((Element)v.get(9)).setAttribute("min","0" );
      ((Element)v.get(9)).setAttribute("max","999" );
      ((Element)v.get(9)).setAttribute("group","nros" );
      ((Element)v.get(4)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */
      /* Termina nodo:4   */

      /* Empieza nodo:10 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(10)).setAttribute("nombre","frmContenido" );
      ((Element)v.get(0)).appendChild((Element)v.get(10));

      /* Empieza nodo:11 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(11)).setAttribute("valor","LPDefinirCondicionOferta" );
      ((Element)v.get(10)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","accion" );
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
      ((Element)v.get(15)).setAttribute("nombre","hidIndicadorCuadre" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hidDesIndCuadre" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","hidFactorCuadre" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 10   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","hOidCatalogo" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hLineaProductosSeleccionados" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hProductosSeleccionados" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hLineasCondicionSeleccionadas" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","hidDesCatalogo" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","hidHabilitaCatalogo" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","hidPaginaDesde" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hidPaginaHasta" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hidcheckExcluirPagina" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hidcheckExcluirLineaProd" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hidcheckExcluirProducto" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(30)).setAttribute("nombre","capaPagina" );
      ((Element)v.get(30)).setAttribute("x","0" );
      ((Element)v.get(30)).setAttribute("y","0" );
      ((Element)v.get(10)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("table"));
      ((Element)v.get(31)).setAttribute("width","100%" );
      ((Element)v.get(31)).setAttribute("border","0" );
      ((Element)v.get(31)).setAttribute("cellspacing","0" );
      ((Element)v.get(31)).setAttribute("cellpadding","0" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(31)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("td"));
      ((Element)v.get(33)).setAttribute("width","12" );
      ((Element)v.get(33)).setAttribute("align","center" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(34)).setAttribute("src","b.gif" );
      ((Element)v.get(34)).setAttribute("width","12" );
      ((Element)v.get(34)).setAttribute("height","12" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */
      /* Termina nodo:33   */

      /* Empieza nodo:35 / Elemento padre: 32   */
      v.add(doc.createElement("td"));
      ((Element)v.get(35)).setAttribute("width","750" );
      ((Element)v.get(32)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(36)).setAttribute("src","b.gif" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */
      /* Termina nodo:35   */

      /* Empieza nodo:37 / Elemento padre: 32   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).setAttribute("width","12" );
      ((Element)v.get(32)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(38)).setAttribute("src","b.gif" );
      ((Element)v.get(38)).setAttribute("width","12" );
      ((Element)v.get(38)).setAttribute("height","1" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */
      /* Termina nodo:37   */
      /* Termina nodo:32   */

      /* Empieza nodo:39 / Elemento padre: 31   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(31)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(41)).setAttribute("src","b.gif" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(40)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:42 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(42)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(44)).setAttribute("class","legend" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(45)).setAttribute("nombre","lblParametrosCondicion" );
      ((Element)v.get(45)).setAttribute("alto","13" );
      ((Element)v.get(45)).setAttribute("filas","1" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(45)).setAttribute("id","legend" );
      ((Element)v.get(45)).setAttribute("cod","507" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:46 / Elemento padre: 43   */
      v.add(doc.createElement("table"));
      ((Element)v.get(46)).setAttribute("width","100%" );
      ((Element)v.get(46)).setAttribute("border","0" );
      ((Element)v.get(46)).setAttribute("align","center" );
      ((Element)v.get(46)).setAttribute("cellspacing","0" );
      ((Element)v.get(46)).setAttribute("cellpadding","0" );
      ((Element)v.get(43)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(46)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("table"));
      ((Element)v.get(49)).setAttribute("width","523" );
      ((Element)v.get(49)).setAttribute("border","0" );
      ((Element)v.get(49)).setAttribute("align","left" );
      ((Element)v.get(49)).setAttribute("cellspacing","0" );
      ((Element)v.get(49)).setAttribute("cellpadding","0" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(49)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(51)).setAttribute("colspan","4" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(52)).setAttribute("src","b.gif" );
      ((Element)v.get(52)).setAttribute("width","8" );
      ((Element)v.get(52)).setAttribute("height","8" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:53 / Elemento padre: 49   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(49)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(55)).setAttribute("src","b.gif" );
      ((Element)v.get(55)).setAttribute("width","8" );
      ((Element)v.get(55)).setAttribute("height","8" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:54   */

      /* Empieza nodo:56 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(57)).setAttribute("nombre","lblIndicadorCuadre" );
      ((Element)v.get(57)).setAttribute("alto","13" );
      ((Element)v.get(57)).setAttribute("filas","1" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(57)).setAttribute("id","datosTitle" );
      ((Element)v.get(57)).setAttribute("cod","461" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:58 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(59)).setAttribute("src","b.gif" );
      ((Element)v.get(59)).setAttribute("width","25" );
      ((Element)v.get(59)).setAttribute("height","8" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:60 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(61)).setAttribute("nombre","lblFactorCuadre" );
      ((Element)v.get(61)).setAttribute("alto","13" );
      ((Element)v.get(61)).setAttribute("filas","1" );
      ((Element)v.get(61)).setAttribute("valor","" );
      ((Element)v.get(61)).setAttribute("id","datosTitle" );
      ((Element)v.get(61)).setAttribute("cod","459" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:62 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).setAttribute("width","100%" );
      ((Element)v.get(53)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(63)).setAttribute("src","b.gif" );
      ((Element)v.get(63)).setAttribute("width","8" );
      ((Element)v.get(63)).setAttribute("height","8" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */
      /* Termina nodo:53   */

      /* Empieza nodo:64 / Elemento padre: 49   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(49)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(66)).setAttribute("src","b.gif" );
      ((Element)v.get(66)).setAttribute("width","8" );
      ((Element)v.get(66)).setAttribute("height","8" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:67 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(67)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(64)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(68)).setAttribute("nombre","cbIndicadorCuadre" );
      ((Element)v.get(68)).setAttribute("id","datosCampos" );
      ((Element)v.get(68)).setAttribute("size","1" );
      ((Element)v.get(68)).setAttribute("multiple","N" );
      ((Element)v.get(68)).setAttribute("req","S" );
      ((Element)v.get(68)).setAttribute("valorinicial","" );
      ((Element)v.get(68)).setAttribute("textoinicial","" );
      ((Element)v.get(68)).setAttribute("onshtab","foco2(2);" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:70 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(71)).setAttribute("src","b.gif" );
      ((Element)v.get(71)).setAttribute("width","25" );
      ((Element)v.get(71)).setAttribute("height","8" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:72 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(64)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(73)).setAttribute("nombre","txtFactorCuadre" );
      ((Element)v.get(73)).setAttribute("id","datosCampos" );
      ((Element)v.get(73)).setAttribute("max","10" );
      ((Element)v.get(73)).setAttribute("tipo","" );
      ((Element)v.get(73)).setAttribute("onchange","" );
      ((Element)v.get(73)).setAttribute("req","S" );
      ((Element)v.get(73)).setAttribute("size","12" );
      ((Element)v.get(73)).setAttribute("valor","" );
      ((Element)v.get(73)).setAttribute("validacion","" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:74 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).setAttribute("width","100%" );
      ((Element)v.get(64)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(75)).setAttribute("src","b.gif" );
      ((Element)v.get(75)).setAttribute("width","1" );
      ((Element)v.get(75)).setAttribute("height","1" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */
      /* Termina nodo:64   */

      /* Empieza nodo:76 / Elemento padre: 49   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(49)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).setAttribute("colspan","4" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(78)).setAttribute("src","b.gif" );
      ((Element)v.get(78)).setAttribute("width","8" );
      ((Element)v.get(78)).setAttribute("height","8" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */
      /* Termina nodo:76   */
      /* Termina nodo:49   */
      /* Termina nodo:48   */
      /* Termina nodo:47   */
      /* Termina nodo:46   */
      /* Termina nodo:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:79 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(80)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */
      /* Termina nodo:39   */

      /* Empieza nodo:81 / Elemento padre: 31   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(31)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).setAttribute("width","12" );
      ((Element)v.get(82)).setAttribute("align","center" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(83)).setAttribute("src","b.gif" );
      ((Element)v.get(83)).setAttribute("width","12" );
      ((Element)v.get(83)).setAttribute("height","15" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */

      /* Empieza nodo:84 / Elemento padre: 81   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).setAttribute("width","756" );
      ((Element)v.get(81)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(85)).setAttribute("src","b.gif" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */

      /* Empieza nodo:86 / Elemento padre: 81   */
      v.add(doc.createElement("td"));
      ((Element)v.get(86)).setAttribute("width","12" );
      ((Element)v.get(81)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(87)).setAttribute("src","b.gif" );
      ((Element)v.get(87)).setAttribute("width","12" );
      ((Element)v.get(87)).setAttribute("height","15" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */
      /* Termina nodo:81   */

      /* Empieza nodo:88 / Elemento padre: 31   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(31)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(90)).setAttribute("src","b.gif" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:91 / Elemento padre: 88   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(91)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(93)).setAttribute("class","legend" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(94)).setAttribute("nombre","lblLineasCondicion" );
      ((Element)v.get(94)).setAttribute("alto","13" );
      ((Element)v.get(94)).setAttribute("filas","1" );
      ((Element)v.get(94)).setAttribute("valor","" );
      ((Element)v.get(94)).setAttribute("id","legend" );
      ((Element)v.get(94)).setAttribute("cod","508" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */

      /* Empieza nodo:95 / Elemento padre: 92   */
      v.add(doc.createElement("table"));
      ((Element)v.get(95)).setAttribute("width","100%" );
      ((Element)v.get(95)).setAttribute("border","0" );
      ((Element)v.get(95)).setAttribute("align","center" );
      ((Element)v.get(95)).setAttribute("cellspacing","0" );
      ((Element)v.get(95)).setAttribute("cellpadding","0" );
      ((Element)v.get(92)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(95)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("table"));
      ((Element)v.get(98)).setAttribute("width","523" );
      ((Element)v.get(98)).setAttribute("border","0" );
      ((Element)v.get(98)).setAttribute("align","left" );
      ((Element)v.get(98)).setAttribute("cellspacing","0" );
      ((Element)v.get(98)).setAttribute("cellpadding","0" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).setAttribute("colspan","4" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(101)).setAttribute("src","b.gif" );
      ((Element)v.get(101)).setAttribute("width","8" );
      ((Element)v.get(101)).setAttribute("height","8" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:102 / Elemento padre: 98   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(98)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(104)).setAttribute("src","b.gif" );
      ((Element)v.get(104)).setAttribute("width","8" );
      ((Element)v.get(104)).setAttribute("height","8" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:105 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(106)).setAttribute("nombre","lblCatalogo" );
      ((Element)v.get(106)).setAttribute("alto","13" );
      ((Element)v.get(106)).setAttribute("filas","1" );
      ((Element)v.get(106)).setAttribute("valor","" );
      ((Element)v.get(106)).setAttribute("id","datosTitle" );
      ((Element)v.get(106)).setAttribute("cod","516" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:107 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).setAttribute("width","100%" );
      ((Element)v.get(102)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(108)).setAttribute("src","b.gif" );
      ((Element)v.get(108)).setAttribute("width","8" );
      ((Element)v.get(108)).setAttribute("height","8" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */
      /* Termina nodo:102   */

      /* Empieza nodo:109 / Elemento padre: 98   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(98)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(111)).setAttribute("src","b.gif" );
      ((Element)v.get(111)).setAttribute("width","8" );
      ((Element)v.get(111)).setAttribute("height","8" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:112 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(109)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
   }

   private void getXML450(Document doc) {
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(113)).setAttribute("nombre","cbCatalogo" );
      ((Element)v.get(113)).setAttribute("id","datosCampos" );
      ((Element)v.get(113)).setAttribute("size","1" );
      ((Element)v.get(113)).setAttribute("multiple","N" );
      ((Element)v.get(113)).setAttribute("req","S" );
      ((Element)v.get(113)).setAttribute("valorinicial","" );
      ((Element)v.get(113)).setAttribute("textoinicial","" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:115 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).setAttribute("width","100%" );
      ((Element)v.get(109)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(116)).setAttribute("src","b.gif" );
      ((Element)v.get(116)).setAttribute("width","1" );
      ((Element)v.get(116)).setAttribute("height","1" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */
      /* Termina nodo:109   */
      /* Termina nodo:98   */
      /* Termina nodo:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:117 / Elemento padre: 95   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(95)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("td"));
      ((Element)v.get(117)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("table"));
      ((Element)v.get(119)).setAttribute("width","523" );
      ((Element)v.get(119)).setAttribute("border","0" );
      ((Element)v.get(119)).setAttribute("align","left" );
      ((Element)v.get(119)).setAttribute("cellspacing","0" );
      ((Element)v.get(119)).setAttribute("cellpadding","0" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(119)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("td"));
      ((Element)v.get(121)).setAttribute("colspan","4" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(122)).setAttribute("src","b.gif" );
      ((Element)v.get(122)).setAttribute("width","8" );
      ((Element)v.get(122)).setAttribute("height","8" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */
      /* Termina nodo:120   */

      /* Empieza nodo:123 / Elemento padre: 119   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(119)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).setAttribute("colspan","4" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(125)).setAttribute("src","b.gif" );
      ((Element)v.get(125)).setAttribute("width","8" );
      ((Element)v.get(125)).setAttribute("height","8" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */

      /* Empieza nodo:126 / Elemento padre: 123   */
      v.add(doc.createElement("td"));
      ((Element)v.get(123)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(127)).setAttribute("nombre","lblPaginaDesde" );
      ((Element)v.get(127)).setAttribute("alto","13" );
      ((Element)v.get(127)).setAttribute("filas","1" );
      ((Element)v.get(127)).setAttribute("valor","" );
      ((Element)v.get(127)).setAttribute("id","datosTitle" );
      ((Element)v.get(127)).setAttribute("cod","512" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */

      /* Empieza nodo:128 / Elemento padre: 123   */
      v.add(doc.createElement("td"));
      ((Element)v.get(123)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(129)).setAttribute("src","b.gif" );
      ((Element)v.get(129)).setAttribute("width","25" );
      ((Element)v.get(129)).setAttribute("height","8" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */

      /* Empieza nodo:130 / Elemento padre: 123   */
      v.add(doc.createElement("td"));
      ((Element)v.get(123)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(131)).setAttribute("nombre","lblPaginaHasta" );
      ((Element)v.get(131)).setAttribute("alto","13" );
      ((Element)v.get(131)).setAttribute("filas","1" );
      ((Element)v.get(131)).setAttribute("valor","" );
      ((Element)v.get(131)).setAttribute("id","datosTitle" );
      ((Element)v.get(131)).setAttribute("cod","513" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:132 / Elemento padre: 123   */
      v.add(doc.createElement("td"));
      ((Element)v.get(132)).setAttribute("width","100%" );
      ((Element)v.get(123)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(133)).setAttribute("src","b.gif" );
      ((Element)v.get(133)).setAttribute("width","8" );
      ((Element)v.get(133)).setAttribute("height","8" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */
      /* Termina nodo:123   */

      /* Empieza nodo:134 / Elemento padre: 119   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(119)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML540(Document doc) {
      ((Element)v.get(136)).setAttribute("src","b.gif" );
      ((Element)v.get(136)).setAttribute("width","8" );
      ((Element)v.get(136)).setAttribute("height","8" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */

      /* Empieza nodo:137 / Elemento padre: 134   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(138)).setAttribute("nombre","checkExcluirPagina" );
      ((Element)v.get(138)).setAttribute("texto","" );
      ((Element)v.get(138)).setAttribute("check","N" );
      ((Element)v.get(138)).setAttribute("validacion","" );
      ((Element)v.get(138)).setAttribute("req","N" );
      ((Element)v.get(138)).setAttribute("id","datosCampos" );
      ((Element)v.get(138)).setAttribute("ontab","focaliza('frmContenido.txtPaginaDesde','');" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:139 / Elemento padre: 134   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(140)).setAttribute("nombre","lblExcluirPagina" );
      ((Element)v.get(140)).setAttribute("alto","13" );
      ((Element)v.get(140)).setAttribute("filas","1" );
      ((Element)v.get(140)).setAttribute("valor","" );
      ((Element)v.get(140)).setAttribute("id","datosCampos" );
      ((Element)v.get(140)).setAttribute("cod","1331" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:141 / Elemento padre: 134   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(142)).setAttribute("src","b.gif" );
      ((Element)v.get(142)).setAttribute("width","25" );
      ((Element)v.get(142)).setAttribute("height","8" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */

      /* Empieza nodo:143 / Elemento padre: 134   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(144)).setAttribute("nombre","txtPaginaDesde" );
      ((Element)v.get(144)).setAttribute("id","datosCampos" );
      ((Element)v.get(144)).setAttribute("max","10" );
      ((Element)v.get(144)).setAttribute("tipo","" );
      ((Element)v.get(144)).setAttribute("onchange","" );
      ((Element)v.get(144)).setAttribute("req","N" );
      ((Element)v.get(144)).setAttribute("size","12" );
      ((Element)v.get(144)).setAttribute("valor","" );
      ((Element)v.get(144)).setAttribute("validacion","" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */

      /* Empieza nodo:145 / Elemento padre: 134   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(146)).setAttribute("src","b.gif" );
      ((Element)v.get(146)).setAttribute("width","25" );
      ((Element)v.get(146)).setAttribute("height","8" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */

      /* Empieza nodo:147 / Elemento padre: 134   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(148)).setAttribute("nombre","txtPaginaHasta" );
      ((Element)v.get(148)).setAttribute("id","datosCampos" );
      ((Element)v.get(148)).setAttribute("max","10" );
      ((Element)v.get(148)).setAttribute("tipo","" );
      ((Element)v.get(148)).setAttribute("onchange","" );
      ((Element)v.get(148)).setAttribute("req","N" );
      ((Element)v.get(148)).setAttribute("size","12" );
      ((Element)v.get(148)).setAttribute("valor","" );
      ((Element)v.get(148)).setAttribute("validacion","" );
      ((Element)v.get(148)).setAttribute("ontab","focalizaBotonHTML('botonContenido','Buscar1');" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */

      /* Empieza nodo:149 / Elemento padre: 134   */
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).setAttribute("width","100%" );
      ((Element)v.get(134)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(150)).setAttribute("src","b.gif" );
      ((Element)v.get(150)).setAttribute("width","1" );
      ((Element)v.get(150)).setAttribute("height","1" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:149   */
      /* Termina nodo:134   */
      /* Termina nodo:119   */
      /* Termina nodo:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:151 / Elemento padre: 95   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(95)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("td"));
      ((Element)v.get(151)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("table"));
      ((Element)v.get(153)).setAttribute("width","523" );
      ((Element)v.get(153)).setAttribute("border","0" );
      ((Element)v.get(153)).setAttribute("align","left" );
      ((Element)v.get(153)).setAttribute("cellspacing","0" );
      ((Element)v.get(153)).setAttribute("cellpadding","0" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(153)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML630(Document doc) {
      ((Element)v.get(156)).setAttribute("src","b.gif" );
      ((Element)v.get(156)).setAttribute("width","8" );
      ((Element)v.get(156)).setAttribute("height","990" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */
      /* Termina nodo:154   */
      /* Termina nodo:153   */
      /* Termina nodo:152   */
      /* Termina nodo:151   */
      /* Termina nodo:95   */
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:157 / Elemento padre: 88   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(158)).setAttribute("src","b.gif" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */
      /* Termina nodo:88   */

      /* Empieza nodo:159 / Elemento padre: 31   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(31)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).setAttribute("width","12" );
      ((Element)v.get(160)).setAttribute("align","center" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(161)).setAttribute("src","b.gif" );
      ((Element)v.get(161)).setAttribute("width","12" );
      ((Element)v.get(161)).setAttribute("height","18" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:160   */

      /* Empieza nodo:162 / Elemento padre: 159   */
      v.add(doc.createElement("td"));
      ((Element)v.get(162)).setAttribute("width","756" );
      ((Element)v.get(159)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(163)).setAttribute("src","b.gif" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */

      /* Empieza nodo:164 / Elemento padre: 159   */
      v.add(doc.createElement("td"));
      ((Element)v.get(164)).setAttribute("width","12" );
      ((Element)v.get(159)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(165)).setAttribute("src","b.gif" );
      ((Element)v.get(165)).setAttribute("width","12" );
      ((Element)v.get(165)).setAttribute("height","18" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:164   */
      /* Termina nodo:159   */
      /* Termina nodo:31   */
      /* Termina nodo:30   */

      /* Empieza nodo:166 / Elemento padre: 10   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(166)).setAttribute("nombre","listado1" );
      ((Element)v.get(166)).setAttribute("ancho","503" );
      ((Element)v.get(166)).setAttribute("alto","299" );
      ((Element)v.get(166)).setAttribute("x","22" );
      ((Element)v.get(166)).setAttribute("y","203" );
      ((Element)v.get(166)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(166)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(10)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(167)).setAttribute("precarga","S" );
      ((Element)v.get(167)).setAttribute("conROver","S" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(168)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(168)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(168)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(168)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */

      /* Empieza nodo:169 / Elemento padre: 167   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(169)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(169)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(169)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(169)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(167)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */

      /* Empieza nodo:170 / Elemento padre: 167   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(170)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(170)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(167)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:167   */

      /* Empieza nodo:171 / Elemento padre: 166   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(166)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(172)).setAttribute("borde","1" );
      ((Element)v.get(172)).setAttribute("horizDatos","1" );
      ((Element)v.get(172)).setAttribute("horizCabecera","1" );
      ((Element)v.get(172)).setAttribute("vertical","1" );
      ((Element)v.get(172)).setAttribute("horizTitulo","1" );
      ((Element)v.get(172)).setAttribute("horizBase","1" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */

      /* Empieza nodo:173 / Elemento padre: 171   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(173)).setAttribute("borde","#999999" );
      ((Element)v.get(173)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(173)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(173)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(173)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(173)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(173)).setAttribute("horizBase","#999999" );
      ((Element)v.get(171)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */
      /* Termina nodo:171   */

      /* Empieza nodo:174 / Elemento padre: 166   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(174)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(174)).setAttribute("alto","22" );
      ((Element)v.get(174)).setAttribute("imgFondo","" );
      ((Element)v.get(174)).setAttribute("cod","1653" );
      ((Element)v.get(174)).setAttribute("ID","datosTitle" );
      ((Element)v.get(166)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */

      /* Empieza nodo:175 / Elemento padre: 166   */
      v.add(doc.createElement("BASE"));
   }

   private void getXML720(Document doc) {
      ((Element)v.get(175)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(175)).setAttribute("alto","22" );
      ((Element)v.get(175)).setAttribute("imgFondo","" );
      ((Element)v.get(166)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */

      /* Empieza nodo:176 / Elemento padre: 166   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(176)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(176)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(176)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(176)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(176)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(176)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(166)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(177)).setAttribute("ancho","100" );
      ((Element)v.get(177)).setAttribute("minimizable","S" );
      ((Element)v.get(177)).setAttribute("minimizada","N" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */

      /* Empieza nodo:178 / Elemento padre: 176   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(178)).setAttribute("ancho","200" );
      ((Element)v.get(178)).setAttribute("minimizable","S" );
      ((Element)v.get(178)).setAttribute("minimizada","N" );
      ((Element)v.get(178)).setAttribute("orden","alfanumerico" );
      ((Element)v.get(176)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:176   */

      /* Empieza nodo:179 / Elemento padre: 166   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(179)).setAttribute("alto","20" );
      ((Element)v.get(179)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(179)).setAttribute("imgFondo","" );
      ((Element)v.get(179)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(166)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(180)).setAttribute("colFondo","" );
      ((Element)v.get(180)).setAttribute("ID","EstCab" );
      ((Element)v.get(180)).setAttribute("cod","8" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));

      /* Elemento padre:180 / Elemento actual: 181   */
      v.add(doc.createTextNode("Código"));
      ((Element)v.get(180)).appendChild((Text)v.get(181));

      /* Termina nodo Texto:181   */
      /* Termina nodo:180   */

      /* Empieza nodo:182 / Elemento padre: 179   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(182)).setAttribute("colFondo","" );
      ((Element)v.get(182)).setAttribute("ID","EstCab" );
      ((Element)v.get(182)).setAttribute("cod","9" );
      ((Element)v.get(179)).appendChild((Element)v.get(182));

      /* Elemento padre:182 / Elemento actual: 183   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(182)).appendChild((Text)v.get(183));

      /* Termina nodo Texto:183   */
      /* Termina nodo:182   */
      /* Termina nodo:179   */

      /* Empieza nodo:184 / Elemento padre: 166   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(184)).setAttribute("alto","22" );
      ((Element)v.get(184)).setAttribute("accion","" );
      ((Element)v.get(184)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(184)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(184)).setAttribute("maxSel","-1" );
      ((Element)v.get(184)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(184)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(184)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(184)).setAttribute("onLoad","" );
      ((Element)v.get(184)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(166)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(185)).setAttribute("tipo","texto" );
      ((Element)v.get(185)).setAttribute("ID","EstDat" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */

      /* Empieza nodo:186 / Elemento padre: 184   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(186)).setAttribute("tipo","texto" );
      ((Element)v.get(186)).setAttribute("ID","EstDat2" );
      ((Element)v.get(184)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:184   */

      /* Empieza nodo:187 / Elemento padre: 166   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(166)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */

      /* Empieza nodo:188 / Elemento padre: 166   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(188)).setAttribute("nombre","mipgndo1" );
      ((Element)v.get(188)).setAttribute("ancho","503" );
      ((Element)v.get(188)).setAttribute("sep","$" );
      ((Element)v.get(188)).setAttribute("x","22" );
      ((Element)v.get(188)).setAttribute("class","botonera" );
      ((Element)v.get(188)).setAttribute("y","479" );
      ((Element)v.get(188)).setAttribute("control","|" );
      ((Element)v.get(188)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(188)).setAttribute("rowset","" );
      ((Element)v.get(188)).setAttribute("cargainicial","N" );
      ((Element)v.get(166)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:166   */

      /* Empieza nodo:189 / Elemento padre: 10   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(189)).setAttribute("nombre","Buscar1" );
      ((Element)v.get(189)).setAttribute("x","23" );
      ((Element)v.get(189)).setAttribute("y","480" );
      ((Element)v.get(189)).setAttribute("ID","botonContenido" );
      ((Element)v.get(189)).setAttribute("tipo","html" );
      ((Element)v.get(189)).setAttribute("estado","false" );
      ((Element)v.get(189)).setAttribute("cod","1" );
      ((Element)v.get(189)).setAttribute("accion","buscarLineaProductos();" );
      ((Element)v.get(189)).setAttribute("ontab","focaliza('frmContenido.checkExcluir1')" );
      ((Element)v.get(189)).setAttribute("onshtab","focaliza('frmContenido.txtPaginaHasta')" );
      ((Element)v.get(10)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */

      /* Empieza nodo:190 / Elemento padre: 10   */
      v.add(doc.createElement("LISTAEDITABLE"));
   }

   private void getXML810(Document doc) {
      ((Element)v.get(190)).setAttribute("nombre","listado2" );
      ((Element)v.get(190)).setAttribute("ancho","503" );
      ((Element)v.get(190)).setAttribute("alto","299" );
      ((Element)v.get(190)).setAttribute("x","22" );
      ((Element)v.get(190)).setAttribute("y","526" );
      ((Element)v.get(190)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(190)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(10)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(191)).setAttribute("precarga","S" );
      ((Element)v.get(191)).setAttribute("conROver","S" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(192)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(192)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(192)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(192)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */

      /* Empieza nodo:193 / Elemento padre: 191   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(193)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(193)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(193)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(193)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(191)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */

      /* Empieza nodo:194 / Elemento padre: 191   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(194)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(194)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(191)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */
      /* Termina nodo:191   */

      /* Empieza nodo:195 / Elemento padre: 190   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(190)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(196)).setAttribute("borde","1" );
      ((Element)v.get(196)).setAttribute("horizDatos","1" );
      ((Element)v.get(196)).setAttribute("horizCabecera","1" );
      ((Element)v.get(196)).setAttribute("vertical","1" );
      ((Element)v.get(196)).setAttribute("horizTitulo","1" );
      ((Element)v.get(196)).setAttribute("horizBase","1" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */

      /* Empieza nodo:197 / Elemento padre: 195   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(197)).setAttribute("borde","#999999" );
      ((Element)v.get(197)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(197)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(197)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(197)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(197)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(197)).setAttribute("horizBase","#999999" );
      ((Element)v.get(195)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */
      /* Termina nodo:195   */

      /* Empieza nodo:198 / Elemento padre: 190   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(198)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(198)).setAttribute("alto","22" );
      ((Element)v.get(198)).setAttribute("imgFondo","" );
      ((Element)v.get(198)).setAttribute("cod","1654" );
      ((Element)v.get(198)).setAttribute("ID","datosTitle" );
      ((Element)v.get(190)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */

      /* Empieza nodo:199 / Elemento padre: 190   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(199)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(199)).setAttribute("alto","22" );
      ((Element)v.get(199)).setAttribute("imgFondo","" );
      ((Element)v.get(190)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */

      /* Empieza nodo:200 / Elemento padre: 190   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(200)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(200)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(200)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(200)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(200)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(200)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(190)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(201)).setAttribute("ancho","100" );
      ((Element)v.get(201)).setAttribute("minimizable","S" );
      ((Element)v.get(201)).setAttribute("minimizada","N" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */

      /* Empieza nodo:202 / Elemento padre: 200   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(202)).setAttribute("ancho","200" );
      ((Element)v.get(202)).setAttribute("minimizable","S" );
      ((Element)v.get(202)).setAttribute("minimizada","N" );
      ((Element)v.get(202)).setAttribute("orden","alfanumerico" );
      ((Element)v.get(200)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:200   */

      /* Empieza nodo:203 / Elemento padre: 190   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(203)).setAttribute("alto","20" );
      ((Element)v.get(203)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(203)).setAttribute("imgFondo","" );
      ((Element)v.get(203)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(190)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(204)).setAttribute("colFondo","" );
      ((Element)v.get(204)).setAttribute("ID","EstCab" );
      ((Element)v.get(204)).setAttribute("cod","8" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));

      /* Elemento padre:204 / Elemento actual: 205   */
      v.add(doc.createTextNode("Código"));
   }

   private void getXML900(Document doc) {
      ((Element)v.get(204)).appendChild((Text)v.get(205));

      /* Termina nodo Texto:205   */
      /* Termina nodo:204   */

      /* Empieza nodo:206 / Elemento padre: 203   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(206)).setAttribute("colFondo","" );
      ((Element)v.get(206)).setAttribute("ID","EstCab" );
      ((Element)v.get(206)).setAttribute("cod","9" );
      ((Element)v.get(203)).appendChild((Element)v.get(206));

      /* Elemento padre:206 / Elemento actual: 207   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(206)).appendChild((Text)v.get(207));

      /* Termina nodo Texto:207   */
      /* Termina nodo:206   */
      /* Termina nodo:203   */

      /* Empieza nodo:208 / Elemento padre: 190   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(208)).setAttribute("alto","22" );
      ((Element)v.get(208)).setAttribute("accion","" );
      ((Element)v.get(208)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(208)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(208)).setAttribute("maxSel","-1" );
      ((Element)v.get(208)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(208)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(208)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(208)).setAttribute("onLoad","" );
      ((Element)v.get(208)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(190)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(209)).setAttribute("tipo","texto" );
      ((Element)v.get(209)).setAttribute("ID","EstDat" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */

      /* Empieza nodo:210 / Elemento padre: 208   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(210)).setAttribute("tipo","texto" );
      ((Element)v.get(210)).setAttribute("ID","EstDat2" );
      ((Element)v.get(208)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */
      /* Termina nodo:208   */

      /* Empieza nodo:211 / Elemento padre: 190   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(190)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */

      /* Empieza nodo:212 / Elemento padre: 190   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(212)).setAttribute("nombre","mipgndo2" );
      ((Element)v.get(212)).setAttribute("ancho","503" );
      ((Element)v.get(212)).setAttribute("sep","$" );
      ((Element)v.get(212)).setAttribute("x","22" );
      ((Element)v.get(212)).setAttribute("class","botonera" );
      ((Element)v.get(212)).setAttribute("y","802" );
      ((Element)v.get(212)).setAttribute("control","|" );
      ((Element)v.get(212)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(212)).setAttribute("rowset","" );
      ((Element)v.get(212)).setAttribute("cargainicial","N" );
      ((Element)v.get(190)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */
      /* Termina nodo:190   */

      /* Empieza nodo:213 / Elemento padre: 10   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(213)).setAttribute("nombre","Buscar2" );
      ((Element)v.get(213)).setAttribute("x","23" );
      ((Element)v.get(213)).setAttribute("y","803" );
      ((Element)v.get(213)).setAttribute("ID","botonContenido" );
      ((Element)v.get(213)).setAttribute("tipo","html" );
      ((Element)v.get(213)).setAttribute("estado","false" );
      ((Element)v.get(213)).setAttribute("cod","1" );
      ((Element)v.get(213)).setAttribute("accion","buscarProducto();" );
      ((Element)v.get(213)).setAttribute("onshtab","focaliza('frmContenido.checkExcluir1')" );
      ((Element)v.get(10)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */

      /* Empieza nodo:214 / Elemento padre: 10   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(214)).setAttribute("nombre","AniadirCondicionXX" );
      ((Element)v.get(214)).setAttribute("x","75" );
      ((Element)v.get(214)).setAttribute("y","803" );
      ((Element)v.get(214)).setAttribute("ID","botonContenido" );
      ((Element)v.get(214)).setAttribute("tipo","html" );
      ((Element)v.get(214)).setAttribute("estado","false" );
      ((Element)v.get(214)).setAttribute("cod","514" );
      ((Element)v.get(214)).setAttribute("accion","accionAniadirCondicion();" );
      ((Element)v.get(214)).setAttribute("ontab","focaliza('frmContenido.checkExcluir2');" );
      ((Element)v.get(10)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */

      /* Empieza nodo:215 / Elemento padre: 10   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(215)).setAttribute("nombre","listado3" );
      ((Element)v.get(215)).setAttribute("ancho","503" );
      ((Element)v.get(215)).setAttribute("alto","317" );
      ((Element)v.get(215)).setAttribute("x","22" );
      ((Element)v.get(215)).setAttribute("y","849" );
      ((Element)v.get(215)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(215)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(10)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(216)).setAttribute("precarga","S" );
      ((Element)v.get(216)).setAttribute("conROver","S" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(217)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(217)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(217)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(217)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */

      /* Empieza nodo:218 / Elemento padre: 216   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(218)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(218)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(218)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(218)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(216)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */

      /* Empieza nodo:219 / Elemento padre: 216   */
      v.add(doc.createElement("BTNORDENAR"));
   }

   private void getXML990(Document doc) {
      ((Element)v.get(219)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(219)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(216)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:216   */

      /* Empieza nodo:220 / Elemento padre: 215   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(215)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(221)).setAttribute("borde","1" );
      ((Element)v.get(221)).setAttribute("horizDatos","1" );
      ((Element)v.get(221)).setAttribute("horizCabecera","1" );
      ((Element)v.get(221)).setAttribute("vertical","1" );
      ((Element)v.get(221)).setAttribute("horizTitulo","1" );
      ((Element)v.get(221)).setAttribute("horizBase","1" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */

      /* Empieza nodo:222 / Elemento padre: 220   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(222)).setAttribute("borde","#999999" );
      ((Element)v.get(222)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(222)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(222)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(222)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(222)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(222)).setAttribute("horizBase","#999999" );
      ((Element)v.get(220)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */
      /* Termina nodo:220   */

      /* Empieza nodo:223 / Elemento padre: 215   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(223)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(223)).setAttribute("alto","22" );
      ((Element)v.get(223)).setAttribute("imgFondo","" );
      ((Element)v.get(223)).setAttribute("cod","508" );
      ((Element)v.get(223)).setAttribute("ID","datosTitle" );
      ((Element)v.get(215)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */

      /* Empieza nodo:224 / Elemento padre: 215   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(224)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(224)).setAttribute("alto","22" );
      ((Element)v.get(224)).setAttribute("imgFondo","" );
      ((Element)v.get(215)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */

      /* Empieza nodo:225 / Elemento padre: 215   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(225)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(225)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(225)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(225)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(225)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(225)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(215)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(226)).setAttribute("ancho","100" );
      ((Element)v.get(226)).setAttribute("minimizable","S" );
      ((Element)v.get(226)).setAttribute("minimizada","N" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */

      /* Empieza nodo:227 / Elemento padre: 225   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(227)).setAttribute("ancho","100" );
      ((Element)v.get(227)).setAttribute("minimizable","S" );
      ((Element)v.get(227)).setAttribute("minimizada","N" );
      ((Element)v.get(225)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */

      /* Empieza nodo:228 / Elemento padre: 225   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(228)).setAttribute("ancho","100" );
      ((Element)v.get(228)).setAttribute("minimizable","S" );
      ((Element)v.get(228)).setAttribute("minimizada","N" );
      ((Element)v.get(225)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */

      /* Empieza nodo:229 / Elemento padre: 225   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(229)).setAttribute("ancho","150" );
      ((Element)v.get(229)).setAttribute("minimizable","S" );
      ((Element)v.get(229)).setAttribute("minimizada","N" );
      ((Element)v.get(225)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */

      /* Empieza nodo:230 / Elemento padre: 225   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(230)).setAttribute("ancho","100" );
      ((Element)v.get(230)).setAttribute("minimizable","S" );
      ((Element)v.get(230)).setAttribute("minimizada","N" );
      ((Element)v.get(225)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */

      /* Empieza nodo:231 / Elemento padre: 225   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(231)).setAttribute("ancho","100" );
      ((Element)v.get(231)).setAttribute("minimizable","S" );
      ((Element)v.get(231)).setAttribute("minimizada","N" );
      ((Element)v.get(225)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */

      /* Empieza nodo:232 / Elemento padre: 225   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(232)).setAttribute("ancho","100" );
      ((Element)v.get(232)).setAttribute("minimizable","S" );
      ((Element)v.get(232)).setAttribute("minimizada","N" );
      ((Element)v.get(225)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */
      /* Termina nodo:225   */

      /* Empieza nodo:233 / Elemento padre: 215   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(233)).setAttribute("alto","20" );
      ((Element)v.get(233)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(233)).setAttribute("imgFondo","" );
      ((Element)v.get(233)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(215)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(234)).setAttribute("colFondo","" );
      ((Element)v.get(234)).setAttribute("ID","EstCab" );
      ((Element)v.get(234)).setAttribute("cod","516" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */

      /* Empieza nodo:235 / Elemento padre: 233   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(235)).setAttribute("colFondo","" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(235)).setAttribute("ID","EstCab" );
      ((Element)v.get(235)).setAttribute("cod","512" );
      ((Element)v.get(233)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */

      /* Empieza nodo:236 / Elemento padre: 233   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(236)).setAttribute("colFondo","" );
      ((Element)v.get(236)).setAttribute("ID","EstCab" );
      ((Element)v.get(236)).setAttribute("cod","513" );
      ((Element)v.get(233)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */

      /* Empieza nodo:237 / Elemento padre: 233   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(237)).setAttribute("colFondo","" );
      ((Element)v.get(237)).setAttribute("ID","EstCab" );
      ((Element)v.get(237)).setAttribute("cod","509" );
      ((Element)v.get(233)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */

      /* Empieza nodo:238 / Elemento padre: 233   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(238)).setAttribute("colFondo","" );
      ((Element)v.get(238)).setAttribute("ID","EstCab" );
      ((Element)v.get(238)).setAttribute("cod","337" );
      ((Element)v.get(233)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */

      /* Empieza nodo:239 / Elemento padre: 233   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(239)).setAttribute("colFondo","" );
      ((Element)v.get(239)).setAttribute("ID","EstCab" );
      ((Element)v.get(239)).setAttribute("cod","9" );
      ((Element)v.get(233)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */

      /* Empieza nodo:240 / Elemento padre: 233   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(240)).setAttribute("colFondo","" );
      ((Element)v.get(240)).setAttribute("ID","EstCab" );
      ((Element)v.get(240)).setAttribute("cod","553" );
      ((Element)v.get(233)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */
      /* Termina nodo:233   */

      /* Empieza nodo:241 / Elemento padre: 215   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(241)).setAttribute("alto","22" );
      ((Element)v.get(241)).setAttribute("accion","" );
      ((Element)v.get(241)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(241)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(241)).setAttribute("maxSel","-1" );
      ((Element)v.get(241)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(241)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(241)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(241)).setAttribute("onLoad","" );
      ((Element)v.get(241)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(215)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(242)).setAttribute("tipo","texto" );
      ((Element)v.get(242)).setAttribute("ID","EstDat" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */

      /* Empieza nodo:243 / Elemento padre: 241   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(243)).setAttribute("tipo","texto" );
      ((Element)v.get(243)).setAttribute("ID","EstDat2" );
      ((Element)v.get(241)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */

      /* Empieza nodo:244 / Elemento padre: 241   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(244)).setAttribute("tipo","texto" );
      ((Element)v.get(244)).setAttribute("ID","EstDat" );
      ((Element)v.get(241)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */

      /* Empieza nodo:245 / Elemento padre: 241   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(245)).setAttribute("tipo","texto" );
      ((Element)v.get(245)).setAttribute("ID","EstDat2" );
      ((Element)v.get(241)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */

      /* Empieza nodo:246 / Elemento padre: 241   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(246)).setAttribute("tipo","texto" );
      ((Element)v.get(246)).setAttribute("ID","EstDat" );
      ((Element)v.get(241)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */

      /* Empieza nodo:247 / Elemento padre: 241   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(247)).setAttribute("tipo","texto" );
      ((Element)v.get(247)).setAttribute("ID","EstDat2" );
      ((Element)v.get(241)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */

      /* Empieza nodo:248 / Elemento padre: 241   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(248)).setAttribute("tipo","texto" );
      ((Element)v.get(248)).setAttribute("ID","EstDat" );
      ((Element)v.get(241)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */
      /* Termina nodo:241   */

      /* Empieza nodo:249 / Elemento padre: 215   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(215)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */

      /* Empieza nodo:250 / Elemento padre: 215   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(250)).setAttribute("nombre","mipgndo3" );
      ((Element)v.get(250)).setAttribute("ancho","503" );
      ((Element)v.get(250)).setAttribute("sep","$" );
      ((Element)v.get(250)).setAttribute("x","22" );
      ((Element)v.get(250)).setAttribute("class","botonera" );
      ((Element)v.get(250)).setAttribute("y","1143" );
      ((Element)v.get(250)).setAttribute("control","|" );
      ((Element)v.get(250)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(250)).setAttribute("rowset","" );
      ((Element)v.get(250)).setAttribute("cargainicial","N" );
      ((Element)v.get(215)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */
      /* Termina nodo:215   */

      /* Empieza nodo:251 / Elemento padre: 10   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(251)).setAttribute("nombre","SalirCondicion" );
      ((Element)v.get(251)).setAttribute("x","23" );
      ((Element)v.get(251)).setAttribute("y","1144" );
      ((Element)v.get(251)).setAttribute("ID","botonContenido" );
      ((Element)v.get(251)).setAttribute("tipo","html" );
      ((Element)v.get(251)).setAttribute("estado","false" );
      ((Element)v.get(251)).setAttribute("cod","2136" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(251)).setAttribute("accion","accionSalirDefinirCondicion();" );
      ((Element)v.get(251)).setAttribute("ontab","foco2(1);" );
      ((Element)v.get(251)).setAttribute("onshtab","focaliza('frmContenido.checkExcluir2');" );
      ((Element)v.get(10)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */

      /* Empieza nodo:252 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(252)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(252)).setAttribute("alto","12" );
      ((Element)v.get(252)).setAttribute("ancho","50" );
      ((Element)v.get(252)).setAttribute("colorf","" );
      ((Element)v.get(252)).setAttribute("borde","0" );
      ((Element)v.get(252)).setAttribute("imagenf","" );
      ((Element)v.get(252)).setAttribute("repeat","" );
      ((Element)v.get(252)).setAttribute("padding","" );
      ((Element)v.get(252)).setAttribute("visibilidad","visible" );
      ((Element)v.get(252)).setAttribute("contravsb","" );
      ((Element)v.get(252)).setAttribute("x","0" );
      ((Element)v.get(252)).setAttribute("y","1166" );
      ((Element)v.get(252)).setAttribute("zindex","" );
      ((Element)v.get(10)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */

      /* Empieza nodo:253 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(253)).setAttribute("nombre","capa2" );
      ((Element)v.get(253)).setAttribute("alto","25" );
      ((Element)v.get(253)).setAttribute("ancho","200" );
      ((Element)v.get(253)).setAttribute("visibilidad","visible" );
      ((Element)v.get(253)).setAttribute("x","75" );
      ((Element)v.get(253)).setAttribute("y","480" );
      ((Element)v.get(10)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("table"));
      ((Element)v.get(254)).setAttribute("width","200" );
      ((Element)v.get(254)).setAttribute("border","0" );
      ((Element)v.get(254)).setAttribute("align","left" );
      ((Element)v.get(254)).setAttribute("cellspacing","0" );
      ((Element)v.get(254)).setAttribute("cellpadding","0" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(254)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("td"));
      ((Element)v.get(255)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(257)).setAttribute("src","b.gif" );
      ((Element)v.get(257)).setAttribute("width","8" );
      ((Element)v.get(257)).setAttribute("height","8" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */
      /* Termina nodo:256   */

      /* Empieza nodo:258 / Elemento padre: 255   */
      v.add(doc.createElement("td"));
      ((Element)v.get(255)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(259)).setAttribute("nombre","checkExcluir1" );
      ((Element)v.get(259)).setAttribute("texto","" );
      ((Element)v.get(259)).setAttribute("check","N" );
      ((Element)v.get(259)).setAttribute("validacion","" );
      ((Element)v.get(259)).setAttribute("req","N" );
      ((Element)v.get(259)).setAttribute("id","datosCampos" );
      ((Element)v.get(259)).setAttribute("ontab","focalizaBotonHTML('botonContenido','Buscar2');" );
      ((Element)v.get(259)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','Buscar1');" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */
      /* Termina nodo:258   */

      /* Empieza nodo:260 / Elemento padre: 255   */
      v.add(doc.createElement("td"));
      ((Element)v.get(255)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(261)).setAttribute("nombre","lblExcluir1" );
      ((Element)v.get(261)).setAttribute("alto","13" );
      ((Element)v.get(261)).setAttribute("filas","1" );
      ((Element)v.get(261)).setAttribute("valor","" );
      ((Element)v.get(261)).setAttribute("id","datosCampos" );
      ((Element)v.get(261)).setAttribute("cod","1653" );
      ((Element)v.get(260)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */
      /* Termina nodo:260   */

      /* Empieza nodo:262 / Elemento padre: 255   */
      v.add(doc.createElement("td"));
      ((Element)v.get(262)).setAttribute("width","100%" );
      ((Element)v.get(255)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(263)).setAttribute("src","b.gif" );
      ((Element)v.get(263)).setAttribute("width","1" );
      ((Element)v.get(263)).setAttribute("height","1" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */
      /* Termina nodo:262   */
      /* Termina nodo:255   */
      /* Termina nodo:254   */
      /* Termina nodo:253   */

      /* Empieza nodo:264 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(264)).setAttribute("nombre","capa3" );
      ((Element)v.get(264)).setAttribute("alto","25" );
      ((Element)v.get(264)).setAttribute("ancho","200" );
      ((Element)v.get(264)).setAttribute("visibilidad","visible" );
      ((Element)v.get(264)).setAttribute("x","196" );
      ((Element)v.get(264)).setAttribute("y","803" );
      ((Element)v.get(10)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("table"));
      ((Element)v.get(265)).setAttribute("width","200" );
      ((Element)v.get(265)).setAttribute("border","0" );
      ((Element)v.get(265)).setAttribute("align","left" );
      ((Element)v.get(265)).setAttribute("cellspacing","0" );
      ((Element)v.get(265)).setAttribute("cellpadding","0" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(265)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
   }

   private void getXML1260(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(266)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(268)).setAttribute("src","b.gif" );
      ((Element)v.get(268)).setAttribute("width","8" );
      ((Element)v.get(268)).setAttribute("height","8" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */
      /* Termina nodo:267   */

      /* Empieza nodo:269 / Elemento padre: 266   */
      v.add(doc.createElement("td"));
      ((Element)v.get(266)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(270)).setAttribute("nombre","checkExcluir2" );
      ((Element)v.get(270)).setAttribute("texto","" );
      ((Element)v.get(270)).setAttribute("check","N" );
      ((Element)v.get(270)).setAttribute("validacion","" );
      ((Element)v.get(270)).setAttribute("req","N" );
      ((Element)v.get(270)).setAttribute("id","datosCampos" );
      ((Element)v.get(270)).setAttribute("ontab","foco2(1);" );
      ((Element)v.get(270)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','AniadirCondicionXX');" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */
      /* Termina nodo:269   */

      /* Empieza nodo:271 / Elemento padre: 266   */
      v.add(doc.createElement("td"));
      ((Element)v.get(266)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(272)).setAttribute("nombre","lblExcluir2" );
      ((Element)v.get(272)).setAttribute("alto","13" );
      ((Element)v.get(272)).setAttribute("filas","1" );
      ((Element)v.get(272)).setAttribute("valor","" );
      ((Element)v.get(272)).setAttribute("id","datosCampos" );
      ((Element)v.get(272)).setAttribute("cod","1654" );
      ((Element)v.get(271)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */
      /* Termina nodo:271   */

      /* Empieza nodo:273 / Elemento padre: 266   */
      v.add(doc.createElement("td"));
      ((Element)v.get(273)).setAttribute("width","100%" );
      ((Element)v.get(266)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(274)).setAttribute("src","b.gif" );
      ((Element)v.get(274)).setAttribute("width","1" );
      ((Element)v.get(274)).setAttribute("height","1" );
      ((Element)v.get(273)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */
      /* Termina nodo:273   */
      /* Termina nodo:266   */
      /* Termina nodo:265   */
      /* Termina nodo:264   */
      /* Termina nodo:10   */


   }

}
