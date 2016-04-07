
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_carga_evaluar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_carga_evaluar" );
      ((Element)v.get(0)).setAttribute("cod","0570" );
      ((Element)v.get(0)).setAttribute("titulo","Evaluar carga" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Evaluar carga" );
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
      ((Element)v.get(4)).setAttribute("src","contenido_carga_evaluar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(5)).setAttribute("src","validaciones_sicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(6)).setAttribute("nombre","formulario" );
      ((Element)v.get(6)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","errCodigo" );
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
      ((Element)v.get(10)).setAttribute("nombre","accion" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","pais" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","idioma" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","lstSublineas" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","lstCargaSublineas" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hFormatoDef" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","hid_SeparadorMiles" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","hid_NumeroDecimales" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hid_SeparadorDecimales" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(20)).setAttribute("nombre","capa1" );
      ((Element)v.get(6)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("table"));
      ((Element)v.get(21)).setAttribute("width","100%" );
      ((Element)v.get(21)).setAttribute("border","0" );
      ((Element)v.get(21)).setAttribute("cellspacing","0" );
      ((Element)v.get(21)).setAttribute("cellpadding","0" );
      ((Element)v.get(20)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(21)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("td"));
      ((Element)v.get(23)).setAttribute("width","12" );
      ((Element)v.get(23)).setAttribute("align","center" );
      ((Element)v.get(22)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(24)).setAttribute("src","b.gif" );
      ((Element)v.get(24)).setAttribute("width","12" );
      ((Element)v.get(24)).setAttribute("height","12" );
      ((Element)v.get(23)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */
      /* Termina nodo:23   */

      /* Empieza nodo:25 / Elemento padre: 22   */
      v.add(doc.createElement("td"));
      ((Element)v.get(25)).setAttribute("width","750" );
      ((Element)v.get(22)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(26)).setAttribute("src","b.gif" );
      ((Element)v.get(25)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */
      /* Termina nodo:25   */

      /* Empieza nodo:27 / Elemento padre: 22   */
      v.add(doc.createElement("td"));
      ((Element)v.get(27)).setAttribute("width","12" );
      ((Element)v.get(22)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(28)).setAttribute("src","b.gif" );
      ((Element)v.get(28)).setAttribute("width","12" );
      ((Element)v.get(28)).setAttribute("height","1" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */
      /* Termina nodo:27   */
      /* Termina nodo:22   */

      /* Empieza nodo:29 / Elemento padre: 21   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(21)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(31)).setAttribute("src","b.gif" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */
      /* Termina nodo:30   */

      /* Empieza nodo:32 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(32)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(34)).setAttribute("class","legend" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(35)).setAttribute("nombre","lblDatosPrincipales" );
      ((Element)v.get(35)).setAttribute("alto","13" );
      ((Element)v.get(35)).setAttribute("filas","1" );
      ((Element)v.get(35)).setAttribute("cod","ApeCargaEvaluar.legend.label" );
      ((Element)v.get(35)).setAttribute("id","legend" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:36 / Elemento padre: 33   */
      v.add(doc.createElement("table"));
      ((Element)v.get(36)).setAttribute("width","100%" );
      ((Element)v.get(36)).setAttribute("border","0" );
      ((Element)v.get(36)).setAttribute("align","center" );
      ((Element)v.get(36)).setAttribute("cellspacing","0" );
      ((Element)v.get(36)).setAttribute("cellpadding","0" );
      ((Element)v.get(33)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(38)).setAttribute("colspan","4" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(39)).setAttribute("src","b.gif" );
      ((Element)v.get(39)).setAttribute("width","8" );
      ((Element)v.get(39)).setAttribute("height","8" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */
      /* Termina nodo:38   */
      /* Termina nodo:37   */

      /* Empieza nodo:40 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(42)).setAttribute("src","b.gif" );
      ((Element)v.get(42)).setAttribute("width","8" );
      ((Element)v.get(42)).setAttribute("height","8" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */
      /* Termina nodo:41   */

      /* Empieza nodo:43 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(44)).setAttribute("nombre","lblSublinea" );
      ((Element)v.get(44)).setAttribute("alto","13" );
      ((Element)v.get(44)).setAttribute("filas","1" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(44)).setAttribute("id","datosTitle" );
      ((Element)v.get(44)).setAttribute("cod","ApeCargaEvaluar.sublinea.label" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */
      /* Termina nodo:43   */

      /* Empieza nodo:45 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(46)).setAttribute("src","b.gif" );
      ((Element)v.get(46)).setAttribute("width","25" );
      ((Element)v.get(46)).setAttribute("height","8" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:47 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(40)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(48)).setAttribute("nombre","lblUnidadesPromedio" );
      ((Element)v.get(48)).setAttribute("alto","13" );
      ((Element)v.get(48)).setAttribute("filas","1" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(48)).setAttribute("id","datosTitle" );
      ((Element)v.get(48)).setAttribute("cod","ApeCargaEvaluar.unidadesPromedio.label" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:49 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(50)).setAttribute("src","b.gif" );
      ((Element)v.get(50)).setAttribute("width","25" );
      ((Element)v.get(50)).setAttribute("height","8" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:51 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(52)).setAttribute("nombre","lblErrorPromedio" );
      ((Element)v.get(52)).setAttribute("alto","13" );
      ((Element)v.get(52)).setAttribute("filas","1" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(52)).setAttribute("id","datosTitle" );
      ((Element)v.get(52)).setAttribute("cod","ApeCargaEvaluar.codProducto.label" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:53 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).setAttribute("width","100%" );
      ((Element)v.get(40)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(54)).setAttribute("src","b.gif" );
      ((Element)v.get(54)).setAttribute("width","8" );
      ((Element)v.get(54)).setAttribute("height","8" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */
      /* Termina nodo:40   */

      /* Empieza nodo:55 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(55));

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
      ((Element)v.get(59)).setAttribute("nombre","cbSublinea" );
      ((Element)v.get(59)).setAttribute("id","datosCampos" );
      ((Element)v.get(59)).setAttribute("size","1" );
      ((Element)v.get(59)).setAttribute("multiple","N" );
      ((Element)v.get(59)).setAttribute("req","N" );
      ((Element)v.get(59)).setAttribute("onchange","onChangeSublinea();" );
      ((Element)v.get(59)).setAttribute("onshtab","onSHTABcomboSublinea();" );
      ((Element)v.get(59)).setAttribute("ontab","onTABcomboSublinea();" );
      ((Element)v.get(59)).setAttribute("valorinicial","" );
      ((Element)v.get(59)).setAttribute("textoinicial","" );
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
      ((Element)v.get(55)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(64)).setAttribute("nombre","unidadesPromedio" );
      ((Element)v.get(64)).setAttribute("alto","13" );
      ((Element)v.get(64)).setAttribute("filas","1" );
      ((Element)v.get(64)).setAttribute("valor","" );
      ((Element)v.get(64)).setAttribute("id","datosCampos" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:65 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(66)).setAttribute("src","b.gif" );
      ((Element)v.get(66)).setAttribute("width","25" );
      ((Element)v.get(66)).setAttribute("height","8" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:67 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(67)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(55)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(68)).setAttribute("nombre","errorPromedio" );
      ((Element)v.get(68)).setAttribute("alto","13" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(68)).setAttribute("filas","1" );
      ((Element)v.get(68)).setAttribute("valor","" );
      ((Element)v.get(68)).setAttribute("id","datosCampos" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:69 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(55)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(70)).setAttribute("nombre","porcentaje" );
      ((Element)v.get(70)).setAttribute("alto","13" );
      ((Element)v.get(70)).setAttribute("filas","1" );
      ((Element)v.get(70)).setAttribute("valor","" );
      ((Element)v.get(70)).setAttribute("id","datosCampos" );
      ((Element)v.get(70)).setAttribute("cod","ApeCargaEvaluar.porciento.label" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:71 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).setAttribute("width","100%" );
      ((Element)v.get(55)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(72)).setAttribute("src","b.gif" );
      ((Element)v.get(72)).setAttribute("width","8" );
      ((Element)v.get(72)).setAttribute("height","8" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */
      /* Termina nodo:55   */

      /* Empieza nodo:73 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).setAttribute("colspan","4" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(75)).setAttribute("src","b.gif" );
      ((Element)v.get(75)).setAttribute("width","8" );
      ((Element)v.get(75)).setAttribute("height","8" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */
      /* Termina nodo:73   */
      /* Termina nodo:36   */
      /* Termina nodo:33   */
      /* Termina nodo:32   */

      /* Empieza nodo:76 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(77)).setAttribute("src","b.gif" );
      ((Element)v.get(77)).setAttribute("width","8" );
      ((Element)v.get(77)).setAttribute("height","12" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */
      /* Termina nodo:29   */

      /* Empieza nodo:78 / Elemento padre: 21   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(21)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).setAttribute("width","12" );
      ((Element)v.get(79)).setAttribute("align","center" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(80)).setAttribute("src","b.gif" );
      ((Element)v.get(80)).setAttribute("width","12" );
      ((Element)v.get(80)).setAttribute("height","12" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:81 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(81)).setAttribute("width","756" );
      ((Element)v.get(78)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(82)).setAttribute("src","b.gif" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:83 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).setAttribute("width","12" );
      ((Element)v.get(78)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(84)).setAttribute("src","b.gif" );
      ((Element)v.get(84)).setAttribute("width","12" );
      ((Element)v.get(84)).setAttribute("height","1" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */
      /* Termina nodo:78   */
      /* Termina nodo:21   */
      /* Termina nodo:20   */

      /* Empieza nodo:85 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(85)).setAttribute("nombre","capaLista" );
      ((Element)v.get(85)).setAttribute("ancho","100%" );
      ((Element)v.get(85)).setAttribute("alto","330" );
      ((Element)v.get(85)).setAttribute("x","4" );
      ((Element)v.get(85)).setAttribute("y","100" );
      ((Element)v.get(85)).setAttribute("colorf","" );
      ((Element)v.get(85)).setAttribute("borde","0" );
      ((Element)v.get(85)).setAttribute("imagenf","" );
      ((Element)v.get(85)).setAttribute("repeat","" );
      ((Element)v.get(85)).setAttribute("padding","" );
      ((Element)v.get(85)).setAttribute("visibilidad","" );
      ((Element)v.get(85)).setAttribute("contravsb","" );
      ((Element)v.get(85)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(86)).setAttribute("nombre","listado1" );
      ((Element)v.get(86)).setAttribute("ancho","369" );
      ((Element)v.get(86)).setAttribute("alto","301" );
      ((Element)v.get(86)).setAttribute("x","12" );
      ((Element)v.get(86)).setAttribute("y","0" );
      ((Element)v.get(86)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(86)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("IMGBOTONES"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(87)).setAttribute("precarga","S" );
      ((Element)v.get(87)).setAttribute("conROver","S" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(88)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(88)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(88)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(88)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */

      /* Empieza nodo:89 / Elemento padre: 87   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(89)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(89)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(89)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(89)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(87)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */

      /* Empieza nodo:90 / Elemento padre: 87   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(90)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(90)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(87)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:87   */

      /* Empieza nodo:91 / Elemento padre: 86   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(86)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(92)).setAttribute("borde","1" );
      ((Element)v.get(92)).setAttribute("horizDatos","1" );
      ((Element)v.get(92)).setAttribute("horizCabecera","1" );
      ((Element)v.get(92)).setAttribute("vertical","1" );
      ((Element)v.get(92)).setAttribute("horizTitulo","1" );
      ((Element)v.get(92)).setAttribute("horizBase","1" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */

      /* Empieza nodo:93 / Elemento padre: 91   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(93)).setAttribute("borde","#999999" );
      ((Element)v.get(93)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(93)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(93)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(93)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(93)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(93)).setAttribute("horizBase","#999999" );
      ((Element)v.get(91)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:91   */

      /* Empieza nodo:94 / Elemento padre: 86   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(94)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(94)).setAttribute("alto","22" );
      ((Element)v.get(94)).setAttribute("imgFondo","" );
      ((Element)v.get(94)).setAttribute("cod","00261" );
      ((Element)v.get(94)).setAttribute("ID","datosTitle" );
      ((Element)v.get(86)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */

      /* Empieza nodo:95 / Elemento padre: 86   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(95)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(95)).setAttribute("alto","22" );
      ((Element)v.get(95)).setAttribute("imgFondo","" );
      ((Element)v.get(86)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */

      /* Empieza nodo:96 / Elemento padre: 86   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(96)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(96)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(96)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(96)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(96)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(96)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(86)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(97)).setAttribute("ancho","100" );
      ((Element)v.get(97)).setAttribute("minimizable","S" );
      ((Element)v.get(97)).setAttribute("minimizada","N" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */

      /* Empieza nodo:98 / Elemento padre: 96   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(98)).setAttribute("ancho","100" );
      ((Element)v.get(98)).setAttribute("minimizable","S" );
      ((Element)v.get(98)).setAttribute("minimizada","N" );
      ((Element)v.get(96)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */

      /* Empieza nodo:99 / Elemento padre: 96   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(99)).setAttribute("ancho","100" );
      ((Element)v.get(99)).setAttribute("minimizable","S" );
      ((Element)v.get(99)).setAttribute("minimizada","N" );
      ((Element)v.get(96)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:96   */

      /* Empieza nodo:100 / Elemento padre: 86   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(100)).setAttribute("alto","25" );
      ((Element)v.get(100)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(100)).setAttribute("imgFondo","" );
      ((Element)v.get(100)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(86)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(101)).setAttribute("colFondo","" );
      ((Element)v.get(101)).setAttribute("ID","EstCab" );
      ((Element)v.get(101)).setAttribute("align","center" );
      ((Element)v.get(101)).setAttribute("cod","ApeCargaEvaluar.idZona.label" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Elemento padre:101 / Elemento actual: 102   */
      v.add(doc.createTextNode("Id. zona"));
      ((Element)v.get(101)).appendChild((Text)v.get(102));

      /* Termina nodo Texto:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:103 / Elemento padre: 100   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(103)).setAttribute("colFondo","" );
      ((Element)v.get(103)).setAttribute("ID","EstCab" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(103)).setAttribute("cod","ApeCargaEvaluar.unidades.label" );
      ((Element)v.get(100)).appendChild((Element)v.get(103));

      /* Elemento padre:103 / Elemento actual: 104   */
      v.add(doc.createTextNode("Unidades"));
      ((Element)v.get(103)).appendChild((Text)v.get(104));

      /* Termina nodo Texto:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:105 / Elemento padre: 100   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(105)).setAttribute("colFondo","" );
      ((Element)v.get(105)).setAttribute("ID","EstCab" );
      ((Element)v.get(105)).setAttribute("cod","ApeCargaEvaluar.porcentaje.label" );
      ((Element)v.get(100)).appendChild((Element)v.get(105));

      /* Elemento padre:105 / Elemento actual: 106   */
      v.add(doc.createTextNode("Porcentaje"));
      ((Element)v.get(105)).appendChild((Text)v.get(106));

      /* Termina nodo Texto:106   */
      /* Termina nodo:105   */
      /* Termina nodo:100   */

      /* Empieza nodo:107 / Elemento padre: 86   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(107)).setAttribute("alto","22" );
      ((Element)v.get(107)).setAttribute("accion","" );
      ((Element)v.get(107)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(107)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(107)).setAttribute("maxSel","0" );
      ((Element)v.get(107)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(107)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(107)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(107)).setAttribute("onLoad","" );
      ((Element)v.get(107)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(86)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(108)).setAttribute("tipo","texto" );
      ((Element)v.get(108)).setAttribute("ID","EstDat" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */

      /* Empieza nodo:109 / Elemento padre: 107   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(109)).setAttribute("tipo","texto" );
      ((Element)v.get(109)).setAttribute("ID","EstDat2" );
      ((Element)v.get(107)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */

      /* Empieza nodo:110 / Elemento padre: 107   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(110)).setAttribute("tipo","texto" );
      ((Element)v.get(110)).setAttribute("ID","EstDat" );
      ((Element)v.get(107)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:107   */

      /* Empieza nodo:111 / Elemento padre: 86   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(86)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:112 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(112)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(112)).setAttribute("alto","12" );
      ((Element)v.get(112)).setAttribute("ancho","100%" );
      ((Element)v.get(112)).setAttribute("colorf","" );
      ((Element)v.get(112)).setAttribute("borde","0" );
      ((Element)v.get(112)).setAttribute("imagenf","" );
      ((Element)v.get(112)).setAttribute("repeat","" );
      ((Element)v.get(112)).setAttribute("padding","" );
      ((Element)v.get(112)).setAttribute("visibilidad","visible" );
      ((Element)v.get(112)).setAttribute("contravsb","" );
      ((Element)v.get(112)).setAttribute("x","0" );
      ((Element)v.get(112)).setAttribute("y","428" );
      ((Element)v.get(112)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:6   */


   }

}
