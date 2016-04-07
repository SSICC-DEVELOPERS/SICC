
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_grupo3_cliente_basico_crear  implements es.indra.druida.base.ObjetoXML {
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
         

      getXML1350(doc);
         

      getXML1440(doc);
         

      getXML1530(doc);
         

      getXML1620(doc);
         

      getXML1710(doc);
         

      getXML1800(doc);
         

      getXML1890(doc);
         

      getXML1980(doc);
         

      getXML2070(doc);
         

      getXML2160(doc);
         

      getXML2250(doc);
         

      getXML2340(doc);
         

      getXML2430(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_grupo3_cliente_basico_crear" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Insertar Cliente Básico" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag()" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(2)).setAttribute("src","scripts_clientes.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","contenido_grupo3_cliente_basico_crear.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(5)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("group","grupo1" );
      ((Element)v.get(7)).setAttribute("name","comboMarcaClasificacion" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("cod","6" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("group","grupo1" );
      ((Element)v.get(8)).setAttribute("name","comboCanal" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","7" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("group","grupo2" );
      ((Element)v.get(9)).setAttribute("name","cbTipoCliente" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","1869" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("group","grupo2" );
      ((Element)v.get(10)).setAttribute("name","cbSubtipoCliente" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("cod","595" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("group","grupo2" );
      ((Element)v.get(11)).setAttribute("name","comboTipoClasificacion" );
      ((Element)v.get(11)).setAttribute("required","true" );
      ((Element)v.get(11)).setAttribute("cod","756" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("group","grupo2" );
      ((Element)v.get(12)).setAttribute("name","comboClasificacion" );
      ((Element)v.get(12)).setAttribute("required","true" );
      ((Element)v.get(12)).setAttribute("cod","550" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */
      /* Termina nodo:6   */
      /* Termina nodo:5   */

      /* Empieza nodo:13 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(13)).setAttribute("nombre","frmInsertarCliente" );
      ((Element)v.get(0)).appendChild((Element)v.get(13));

      /* Empieza nodo:14 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","accion" );
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
      ((Element)v.get(16)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","cbTipo" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","cbSTipo" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","nameComboSelected" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(20)).setAttribute("nombre","valueComboSelected" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","nameComboSelectedTipo" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","valueComboSelectedTipo" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","nameComboSelectedSubtipo" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","valueComboSelectedSubtipo" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","usaGeoreferenciador" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hidPais" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hidIdioma" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hidTerritorio" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","hidDescTerritorio" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hidDescTerritorioOLD" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","elementosP3" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","elementosP3Marca" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","elementosP3MarcaListado2" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","elementosExtra" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","primeraVez" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","envia" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","hidFocusPrimerComponente" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","origen" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","hidOidCliente" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","hidCodigoCliente" );
      ((Element)v.get(42)).setAttribute("valor","" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(13)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","hidOitTipoCliente" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","hidCerrarVentana" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","hiddenOidVia" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 13   */
      v.add(doc.createElement("table"));
      ((Element)v.get(46)).setAttribute("width","100%" );
      ((Element)v.get(46)).setAttribute("height","100%" );
      ((Element)v.get(46)).setAttribute("border","0" );
      ((Element)v.get(46)).setAttribute("align","center" );
      ((Element)v.get(46)).setAttribute("cellpadding","0" );
      ((Element)v.get(46)).setAttribute("cellspacing","0" );
      ((Element)v.get(46)).setAttribute("class","menu4" );
      ((Element)v.get(13)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(46)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).setAttribute("width","12" );
      ((Element)v.get(48)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(48)).setAttribute("class","menu5texto" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(49)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).setAttribute("width","12" );
      ((Element)v.get(49)).setAttribute("height","30" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(50)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(50)).setAttribute("class","menu5texto" );
      ((Element)v.get(47)).appendChild((Element)v.get(50));

      /* Elemento padre:50 / Elemento actual: 51   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(50)).appendChild((Text)v.get(51));

      /* Termina nodo Texto:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:52 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).setAttribute("width","10" );
      ((Element)v.get(52)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(52)).setAttribute("class","menu5texto" );
      ((Element)v.get(47)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(53)).setAttribute("src","b.gif" );
      ((Element)v.get(53)).setAttribute("width","10" );
      ((Element)v.get(53)).setAttribute("height","8" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:54 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).setAttribute("width","20" );
      ((Element)v.get(54)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(54)).setAttribute("class","menu5texto" );
      ((Element)v.get(47)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("table"));
      ((Element)v.get(55)).setAttribute("width","75" );
      ((Element)v.get(55)).setAttribute("border","1" );
      ((Element)v.get(55)).setAttribute("align","center" );
      ((Element)v.get(55)).setAttribute("cellpadding","1" );
      ((Element)v.get(55)).setAttribute("cellspacing","0" );
      ((Element)v.get(55)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(56)).setAttribute("align","center" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(58)).setAttribute("nombre","lblPes1" );
      ((Element)v.get(58)).setAttribute("alto","13" );
      ((Element)v.get(58)).setAttribute("filas","1" );
      ((Element)v.get(58)).setAttribute("valor","Pestaña 1" );
      ((Element)v.get(58)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(58)).setAttribute("cod","00515" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */
      /* Termina nodo:56   */
      /* Termina nodo:55   */
      /* Termina nodo:54   */

      /* Empieza nodo:59 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).setAttribute("width","10" );
      ((Element)v.get(59)).setAttribute("class","menu5texto" );
      ((Element)v.get(47)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(60)).setAttribute("src","b.gif" );
      ((Element)v.get(60)).setAttribute("width","10" );
      ((Element)v.get(60)).setAttribute("height","8" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:61 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).setAttribute("width","20" );
      ((Element)v.get(61)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(61)).setAttribute("class","menu5texto" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(47)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("table"));
      ((Element)v.get(62)).setAttribute("width","75" );
      ((Element)v.get(62)).setAttribute("border","1" );
      ((Element)v.get(62)).setAttribute("align","center" );
      ((Element)v.get(62)).setAttribute("cellpadding","1" );
      ((Element)v.get(62)).setAttribute("cellspacing","0" );
      ((Element)v.get(62)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(63)).setAttribute("align","center" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(64)).setAttribute("onclick","accionP2DesdeP3()" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(65)).setAttribute("nombre","lblPes2" );
      ((Element)v.get(65)).setAttribute("alto","13" );
      ((Element)v.get(65)).setAttribute("filas","1" );
      ((Element)v.get(65)).setAttribute("valor","Pestaña 1" );
      ((Element)v.get(65)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(65)).setAttribute("cod","00516" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */
      /* Termina nodo:63   */
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:66 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).setAttribute("width","10" );
      ((Element)v.get(66)).setAttribute("class","menu5texto" );
      ((Element)v.get(47)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(67)).setAttribute("src","b.gif" );
      ((Element)v.get(67)).setAttribute("width","10" );
      ((Element)v.get(67)).setAttribute("height","8" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:68 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).setAttribute("width","20" );
      ((Element)v.get(68)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(68)).setAttribute("class","menu5texto" );
      ((Element)v.get(47)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("table"));
      ((Element)v.get(69)).setAttribute("width","75" );
      ((Element)v.get(69)).setAttribute("border","1" );
      ((Element)v.get(69)).setAttribute("align","center" );
      ((Element)v.get(69)).setAttribute("cellpadding","1" );
      ((Element)v.get(69)).setAttribute("cellspacing","0" );
      ((Element)v.get(69)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(69)).setAttribute("bgcolor","#496A9A" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(70)).setAttribute("align","center" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(72)).setAttribute("nombre","lblPes3" );
      ((Element)v.get(72)).setAttribute("alto","13" );
      ((Element)v.get(72)).setAttribute("filas","1" );
      ((Element)v.get(72)).setAttribute("valor","Pestaña 1" );
      ((Element)v.get(72)).setAttribute("id","menu5textoblanca" );
      ((Element)v.get(72)).setAttribute("cod","00517" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */
      /* Termina nodo:70   */
      /* Termina nodo:69   */
      /* Termina nodo:68   */

      /* Empieza nodo:73 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).setAttribute("width","16" );
      ((Element)v.get(73)).setAttribute("class","menu5texto" );
      ((Element)v.get(47)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(74)).setAttribute("src","b.gif" );
      ((Element)v.get(74)).setAttribute("width","12" );
      ((Element)v.get(74)).setAttribute("height","8" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:75 / Elemento padre: 13   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(75)).setAttribute("nombre","capaEspacio1" );
      ((Element)v.get(13)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("table"));
      ((Element)v.get(76)).setAttribute("width","100%" );
      ((Element)v.get(76)).setAttribute("border","0" );
      ((Element)v.get(76)).setAttribute("cellspacing","0" );
      ((Element)v.get(76)).setAttribute("cellpadding","0" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(76)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).setAttribute("width","9" );
      ((Element)v.get(78)).setAttribute("align","center" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).setAttribute("width","9" );
      ((Element)v.get(79)).setAttribute("height","12" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:80 / Elemento padre: 77   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).setAttribute("width","750" );
      ((Element)v.get(77)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(81)).setAttribute("src","b.gif" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:82 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).setAttribute("width","9" );
      ((Element)v.get(77)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(83)).setAttribute("src","b.gif" );
      ((Element)v.get(83)).setAttribute("width","9" );
      ((Element)v.get(83)).setAttribute("height","1" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */
      /* Termina nodo:77   */

      /* Empieza nodo:84 / Elemento padre: 76   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(76)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(86)).setAttribute("src","b.gif" );
      ((Element)v.get(86)).setAttribute("width","8" );
      ((Element)v.get(86)).setAttribute("height","12" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 84   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(89)).setAttribute("class","legend" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(90)).setAttribute("nombre","lblDatosDirecciones" );
      ((Element)v.get(90)).setAttribute("alto","13" );
      ((Element)v.get(90)).setAttribute("filas","1" );
      ((Element)v.get(90)).setAttribute("valor","" );
      ((Element)v.get(90)).setAttribute("id","legend" );
      ((Element)v.get(90)).setAttribute("cod","00430" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:91 / Elemento padre: 88   */
      v.add(doc.createElement("table"));
      ((Element)v.get(91)).setAttribute("width","100%" );
      ((Element)v.get(91)).setAttribute("border","0" );
      ((Element)v.get(91)).setAttribute("align","center" );
      ((Element)v.get(91)).setAttribute("cellspacing","0" );
      ((Element)v.get(91)).setAttribute("cellpadding","0" );
      ((Element)v.get(88)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(91)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("td"));
      ((Element)v.get(92)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("table"));
      ((Element)v.get(94)).setAttribute("width","575" );
      ((Element)v.get(94)).setAttribute("border","0" );
      ((Element)v.get(94)).setAttribute("align","left" );
      ((Element)v.get(94)).setAttribute("cellspacing","0" );
      ((Element)v.get(94)).setAttribute("cellpadding","0" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).setAttribute("colspan","3" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(97)).setAttribute("src","b.gif" );
      ((Element)v.get(97)).setAttribute("width","8" );
      ((Element)v.get(97)).setAttribute("height","8" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */
      /* Termina nodo:95   */

      /* Empieza nodo:98 / Elemento padre: 94   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(94)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(100)).setAttribute("src","b.gif" );
      ((Element)v.get(100)).setAttribute("width","8" );
      ((Element)v.get(100)).setAttribute("height","8" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:101 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(102)).setAttribute("nombre","lblTipoDireccion" );
      ((Element)v.get(102)).setAttribute("alto","13" );
      ((Element)v.get(102)).setAttribute("filas","1" );
      ((Element)v.get(102)).setAttribute("valor","" );
      ((Element)v.get(102)).setAttribute("id","datosTitle" );
      ((Element)v.get(102)).setAttribute("cod","159" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:103 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(104)).setAttribute("src","b.gif" );
      ((Element)v.get(104)).setAttribute("width","25" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(104)).setAttribute("height","8" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:105 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(106)).setAttribute("nombre","capalblTipoVia" );
      ((Element)v.get(106)).setAttribute("alto","100%" );
      ((Element)v.get(106)).setAttribute("ancho","100%" );
      ((Element)v.get(106)).setAttribute("colorf","" );
      ((Element)v.get(106)).setAttribute("borde","0" );
      ((Element)v.get(106)).setAttribute("imagenf","" );
      ((Element)v.get(106)).setAttribute("repeat","" );
      ((Element)v.get(106)).setAttribute("padding","" );
      ((Element)v.get(106)).setAttribute("visibilidad","" );
      ((Element)v.get(106)).setAttribute("contravsb","" );
      ((Element)v.get(106)).setAttribute("position","relative" );
      ((Element)v.get(106)).setAttribute("zindex","" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(107)).setAttribute("nombre","lblTipoVia" );
      ((Element)v.get(107)).setAttribute("alto","13" );
      ((Element)v.get(107)).setAttribute("filas","1" );
      ((Element)v.get(107)).setAttribute("valor","" );
      ((Element)v.get(107)).setAttribute("id","datosTitle" );
      ((Element)v.get(107)).setAttribute("cod","215" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:108 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).setAttribute("width","100%" );
      ((Element)v.get(98)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(109)).setAttribute("src","b.gif" );
      ((Element)v.get(109)).setAttribute("width","8" );
      ((Element)v.get(109)).setAttribute("height","8" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */
      /* Termina nodo:98   */

      /* Empieza nodo:110 / Elemento padre: 94   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(94)).appendChild((Element)v.get(110));

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
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(114)).setAttribute("nombre","comboTipoDireccion" );
      ((Element)v.get(114)).setAttribute("req","S" );
      ((Element)v.get(114)).setAttribute("multiple","N" );
      ((Element)v.get(114)).setAttribute("size","1" );
      ((Element)v.get(114)).setAttribute("valorinicial","" );
      ((Element)v.get(114)).setAttribute("id","datosCampos" );
      ((Element)v.get(114)).setAttribute("onshtab","javascript:accionP2DesdeP3();" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:116 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(117)).setAttribute("src","b.gif" );
      ((Element)v.get(117)).setAttribute("width","25" );
      ((Element)v.get(117)).setAttribute("height","8" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:118 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(118)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(110)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(119)).setAttribute("nombre","capaComboTipoVia" );
      ((Element)v.get(119)).setAttribute("alto","100%" );
      ((Element)v.get(119)).setAttribute("ancho","100%" );
      ((Element)v.get(119)).setAttribute("colorf","" );
      ((Element)v.get(119)).setAttribute("borde","0" );
      ((Element)v.get(119)).setAttribute("imagenf","" );
      ((Element)v.get(119)).setAttribute("repeat","" );
      ((Element)v.get(119)).setAttribute("padding","" );
      ((Element)v.get(119)).setAttribute("visibilidad","visible" );
      ((Element)v.get(119)).setAttribute("contravsb","" );
      ((Element)v.get(119)).setAttribute("position","relative" );
      ((Element)v.get(119)).setAttribute("zindex","" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(120)).setAttribute("nombre","comboTipoVia" );
      ((Element)v.get(120)).setAttribute("req","S" );
      ((Element)v.get(120)).setAttribute("multiple","N" );
      ((Element)v.get(120)).setAttribute("size","1" );
      ((Element)v.get(120)).setAttribute("id","datosCampos" );
      ((Element)v.get(120)).setAttribute("onchange","recargaVia();" );
      ((Element)v.get(120)).setAttribute("valorinicial","" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
   }

   private void getXML540(Document doc) {
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:122 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).setAttribute("width","100%" );
      ((Element)v.get(110)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(123)).setAttribute("src","b.gif" );
      ((Element)v.get(123)).setAttribute("width","8" );
      ((Element)v.get(123)).setAttribute("height","8" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:122   */
      /* Termina nodo:110   */

      /* Empieza nodo:124 / Elemento padre: 94   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(94)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).setAttribute("colspan","4" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(126)).setAttribute("src","b.gif" );
      ((Element)v.get(126)).setAttribute("width","8" );
      ((Element)v.get(126)).setAttribute("height","8" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:94   */
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:127 / Elemento padre: 91   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(91)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("table"));
      ((Element)v.get(129)).setAttribute("width","575" );
      ((Element)v.get(129)).setAttribute("height","41" );
      ((Element)v.get(129)).setAttribute("border","0" );
      ((Element)v.get(129)).setAttribute("align","left" );
      ((Element)v.get(129)).setAttribute("cellspacing","0" );
      ((Element)v.get(129)).setAttribute("cellpadding","0" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(129)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(132)).setAttribute("src","b.gif" );
      ((Element)v.get(132)).setAttribute("width","8" );
      ((Element)v.get(132)).setAttribute("height","8" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */

      /* Empieza nodo:133 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(134)).setAttribute("nombre","capalblNombreVia" );
      ((Element)v.get(134)).setAttribute("alto","100%" );
      ((Element)v.get(134)).setAttribute("ancho","100%" );
      ((Element)v.get(134)).setAttribute("colorf","" );
      ((Element)v.get(134)).setAttribute("borde","0" );
      ((Element)v.get(134)).setAttribute("imagenf","" );
      ((Element)v.get(134)).setAttribute("repeat","" );
      ((Element)v.get(134)).setAttribute("padding","" );
      ((Element)v.get(134)).setAttribute("visibilidad","" );
      ((Element)v.get(134)).setAttribute("contravsb","" );
      ((Element)v.get(134)).setAttribute("position","relative" );
      ((Element)v.get(134)).setAttribute("zindex","" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(135)).setAttribute("nombre","lblNombreVia" );
      ((Element)v.get(135)).setAttribute("alto","13" );
      ((Element)v.get(135)).setAttribute("filas","1" );
      ((Element)v.get(135)).setAttribute("valor","" );
      ((Element)v.get(135)).setAttribute("id","datosTitle" );
      ((Element)v.get(135)).setAttribute("cod","216" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:136 / Elemento padre: 133   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(136)).setAttribute("nombre","capalblVia" );
      ((Element)v.get(136)).setAttribute("alto","100%" );
      ((Element)v.get(136)).setAttribute("ancho","100%" );
      ((Element)v.get(136)).setAttribute("colorf","" );
      ((Element)v.get(136)).setAttribute("borde","0" );
      ((Element)v.get(136)).setAttribute("imagenf","" );
      ((Element)v.get(136)).setAttribute("repeat","" );
      ((Element)v.get(136)).setAttribute("padding","" );
      ((Element)v.get(136)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(136)).setAttribute("contravsb","" );
      ((Element)v.get(136)).setAttribute("position","relative" );
      ((Element)v.get(136)).setAttribute("zindex","" );
      ((Element)v.get(133)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(137)).setAttribute("nombre","lblVia" );
      ((Element)v.get(137)).setAttribute("alto","13" );
      ((Element)v.get(137)).setAttribute("filas","1" );
      ((Element)v.get(137)).setAttribute("valor","" );
      ((Element)v.get(137)).setAttribute("id","datosTitle" );
      ((Element)v.get(137)).setAttribute("cod","2267" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */
      /* Termina nodo:133   */

      /* Empieza nodo:138 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(138)).setAttribute("width","100%" );
      ((Element)v.get(130)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
   }

   private void getXML630(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(139)).setAttribute("src","b.gif" );
      ((Element)v.get(139)).setAttribute("width","8" );
      ((Element)v.get(139)).setAttribute("height","8" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:138   */
      /* Termina nodo:130   */

      /* Empieza nodo:140 / Elemento padre: 129   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(129)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(142)).setAttribute("src","b.gif" );
      ((Element)v.get(142)).setAttribute("width","8" );
      ((Element)v.get(142)).setAttribute("height","8" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */

      /* Empieza nodo:143 / Elemento padre: 140   */
      v.add(doc.createElement("td"));
      ((Element)v.get(143)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(140)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(144)).setAttribute("nombre","capaTextoNombreVia" );
      ((Element)v.get(144)).setAttribute("alto","50" );
      ((Element)v.get(144)).setAttribute("ancho","100%" );
      ((Element)v.get(144)).setAttribute("colorf","" );
      ((Element)v.get(144)).setAttribute("borde","0" );
      ((Element)v.get(144)).setAttribute("imagenf","" );
      ((Element)v.get(144)).setAttribute("repeat","" );
      ((Element)v.get(144)).setAttribute("padding","" );
      ((Element)v.get(144)).setAttribute("visibilidad","" );
      ((Element)v.get(144)).setAttribute("contravsb","" );
      ((Element)v.get(144)).setAttribute("position","relative" );
      ((Element)v.get(144)).setAttribute("zindex","" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(145)).setAttribute("nombre","TextoNombreVia" );
      ((Element)v.get(145)).setAttribute("id","datosCampos" );
      ((Element)v.get(145)).setAttribute("max","60" );
      ((Element)v.get(145)).setAttribute("tipo","" );
      ((Element)v.get(145)).setAttribute("onchange","" );
      ((Element)v.get(145)).setAttribute("req","S" );
      ((Element)v.get(145)).setAttribute("size","60" );
      ((Element)v.get(145)).setAttribute("valor","" );
      ((Element)v.get(145)).setAttribute("validacion","" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:144   */

      /* Empieza nodo:146 / Elemento padre: 143   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(146)).setAttribute("nombre","capaComboVia" );
      ((Element)v.get(146)).setAttribute("alto","100%" );
      ((Element)v.get(146)).setAttribute("ancho","100%" );
      ((Element)v.get(146)).setAttribute("colorf","" );
      ((Element)v.get(146)).setAttribute("borde","0" );
      ((Element)v.get(146)).setAttribute("imagenf","" );
      ((Element)v.get(146)).setAttribute("repeat","" );
      ((Element)v.get(146)).setAttribute("padding","" );
      ((Element)v.get(146)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(146)).setAttribute("contravsb","" );
      ((Element)v.get(146)).setAttribute("position","relative" );
      ((Element)v.get(146)).setAttribute("zindex","" );
      ((Element)v.get(143)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("table"));
      ((Element)v.get(147)).setAttribute("width","515" );
      ((Element)v.get(147)).setAttribute("border","0" );
      ((Element)v.get(147)).setAttribute("align","left" );
      ((Element)v.get(147)).setAttribute("cellspacing","0" );
      ((Element)v.get(147)).setAttribute("cellpadding","0" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(147)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(150)).setAttribute("nombre","comboNombreVia" );
      ((Element)v.get(150)).setAttribute("id","datosCampos" );
      ((Element)v.get(150)).setAttribute("max","60" );
      ((Element)v.get(150)).setAttribute("tipo","" );
      ((Element)v.get(150)).setAttribute("onchange","" );
      ((Element)v.get(150)).setAttribute("req","S" );
      ((Element)v.get(150)).setAttribute("size","60" );
      ((Element)v.get(150)).setAttribute("valor","" );
      ((Element)v.get(150)).setAttribute("validacion","" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:149   */

      /* Empieza nodo:151 / Elemento padre: 148   */
      v.add(doc.createElement("td"));
      ((Element)v.get(151)).setAttribute("width","100%" );
      ((Element)v.get(148)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(152)).setAttribute("src","b.gif" );
      ((Element)v.get(152)).setAttribute("width","5" );
      ((Element)v.get(152)).setAttribute("height","8" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:151   */

      /* Empieza nodo:153 / Elemento padre: 148   */
      v.add(doc.createElement("td"));
      ((Element)v.get(153)).setAttribute("class","botonera" );
      ((Element)v.get(148)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
   }

   private void getXML720(Document doc) {
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(154)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(154)).setAttribute("ID","botonContenido" );
      ((Element)v.get(154)).setAttribute("tipo","html" );
      ((Element)v.get(154)).setAttribute("accion","buscarVia();" );
      ((Element)v.get(154)).setAttribute("estado","false" );
      ((Element)v.get(154)).setAttribute("cod","1" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */
      /* Termina nodo:148   */
      /* Termina nodo:147   */
      /* Termina nodo:146   */
      /* Termina nodo:143   */

      /* Empieza nodo:155 / Elemento padre: 140   */
      v.add(doc.createElement("td"));
      ((Element)v.get(155)).setAttribute("width","100%" );
      ((Element)v.get(140)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(156)).setAttribute("src","b.gif" );
      ((Element)v.get(156)).setAttribute("width","8" );
      ((Element)v.get(156)).setAttribute("height","8" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */
      /* Termina nodo:140   */

      /* Empieza nodo:157 / Elemento padre: 129   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(129)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("td"));
      ((Element)v.get(158)).setAttribute("colspan","4" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(159)).setAttribute("src","b.gif" );
      ((Element)v.get(159)).setAttribute("width","8" );
      ((Element)v.get(159)).setAttribute("height","8" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */
      /* Termina nodo:157   */
      /* Termina nodo:129   */
      /* Termina nodo:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:160 / Elemento padre: 91   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(91)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("table"));
      ((Element)v.get(162)).setAttribute("width","575" );
      ((Element)v.get(162)).setAttribute("border","0" );
      ((Element)v.get(162)).setAttribute("align","left" );
      ((Element)v.get(162)).setAttribute("cellspacing","0" );
      ((Element)v.get(162)).setAttribute("cellpadding","0" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(162)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(165)).setAttribute("src","b.gif" );
      ((Element)v.get(165)).setAttribute("width","8" );
      ((Element)v.get(165)).setAttribute("height","8" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:164   */

      /* Empieza nodo:166 / Elemento padre: 163   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(167)).setAttribute("nombre","lblNumeroPrincipal" );
      ((Element)v.get(167)).setAttribute("alto","13" );
      ((Element)v.get(167)).setAttribute("filas","1" );
      ((Element)v.get(167)).setAttribute("valor","" );
      ((Element)v.get(167)).setAttribute("id","datosTitle" );
      ((Element)v.get(167)).setAttribute("cod","939" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:166   */

      /* Empieza nodo:168 / Elemento padre: 163   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(169)).setAttribute("src","b.gif" );
      ((Element)v.get(169)).setAttribute("width","25" );
      ((Element)v.get(169)).setAttribute("height","8" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */
      /* Termina nodo:168   */

      /* Empieza nodo:170 / Elemento padre: 163   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(171)).setAttribute("nombre","lblCodigoPostal" );
      ((Element)v.get(171)).setAttribute("alto","13" );
      ((Element)v.get(171)).setAttribute("filas","1" );
      ((Element)v.get(171)).setAttribute("valor","" );
      ((Element)v.get(171)).setAttribute("id","datosTitle" );
      ((Element)v.get(171)).setAttribute("cod","1344" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:170   */

      /* Empieza nodo:172 / Elemento padre: 163   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(173)).setAttribute("src","b.gif" );
      ((Element)v.get(173)).setAttribute("width","25" );
      ((Element)v.get(173)).setAttribute("height","8" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */
      /* Termina nodo:172   */

      /* Empieza nodo:174 / Elemento padre: 163   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(175)).setAttribute("nombre","lblDireccionPrincipal" );
      ((Element)v.get(175)).setAttribute("alto","13" );
      ((Element)v.get(175)).setAttribute("filas","1" );
      ((Element)v.get(175)).setAttribute("valor","" );
      ((Element)v.get(175)).setAttribute("id","datosTitle" );
      ((Element)v.get(175)).setAttribute("cod","1349" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:174   */

      /* Empieza nodo:176 / Elemento padre: 163   */
   }

   private void getXML810(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(176)).setAttribute("width","100%" );
      ((Element)v.get(163)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(177)).setAttribute("src","b.gif" );
      ((Element)v.get(177)).setAttribute("width","8" );
      ((Element)v.get(177)).setAttribute("height","8" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */
      /* Termina nodo:176   */
      /* Termina nodo:163   */

      /* Empieza nodo:178 / Elemento padre: 162   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(162)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(180)).setAttribute("src","b.gif" );
      ((Element)v.get(180)).setAttribute("width","8" );
      ((Element)v.get(180)).setAttribute("height","8" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */
      /* Termina nodo:179   */

      /* Empieza nodo:181 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(182)).setAttribute("nombre","TextoNumeroPrincipal" );
      ((Element)v.get(182)).setAttribute("id","datosCampos" );
      ((Element)v.get(182)).setAttribute("max","6" );
      ((Element)v.get(182)).setAttribute("tipo","" );
      ((Element)v.get(182)).setAttribute("onchange","" );
      ((Element)v.get(182)).setAttribute("req","N" );
      ((Element)v.get(182)).setAttribute("size","6" );
      ((Element)v.get(182)).setAttribute("valor","" );
      ((Element)v.get(182)).setAttribute("validacion","" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:181   */

      /* Empieza nodo:183 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(184)).setAttribute("src","b.gif" );
      ((Element)v.get(184)).setAttribute("width","25" );
      ((Element)v.get(184)).setAttribute("height","8" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */

      /* Empieza nodo:185 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(186)).setAttribute("nombre","TextoCodPostal" );
      ((Element)v.get(186)).setAttribute("id","datosCampos" );
      ((Element)v.get(186)).setAttribute("max","5" );
      ((Element)v.get(186)).setAttribute("tipo","" );
      ((Element)v.get(186)).setAttribute("onchange","" );
      ((Element)v.get(186)).setAttribute("req","N" );
      ((Element)v.get(186)).setAttribute("size","5" );
      ((Element)v.get(186)).setAttribute("valor","" );
      ((Element)v.get(186)).setAttribute("validacion","" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:187 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(188)).setAttribute("src","b.gif" );
      ((Element)v.get(188)).setAttribute("width","25" );
      ((Element)v.get(188)).setAttribute("height","8" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */

      /* Empieza nodo:189 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(190)).setAttribute("nombre","cbxDireccionPrincipal" );
      ((Element)v.get(190)).setAttribute("texto","" );
      ((Element)v.get(190)).setAttribute("check","N" );
      ((Element)v.get(190)).setAttribute("validacion","" );
      ((Element)v.get(190)).setAttribute("req","N" );
      ((Element)v.get(190)).setAttribute("id","datosCampos" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:189   */

      /* Empieza nodo:191 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(191)).setAttribute("width","100%" );
      ((Element)v.get(178)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(192)).setAttribute("src","b.gif" );
      ((Element)v.get(192)).setAttribute("width","8" );
      ((Element)v.get(192)).setAttribute("height","8" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:191   */
      /* Termina nodo:178   */

      /* Empieza nodo:193 / Elemento padre: 162   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(162)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("td"));
      ((Element)v.get(194)).setAttribute("colspan","4" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(195)).setAttribute("src","b.gif" );
      ((Element)v.get(195)).setAttribute("width","8" );
      ((Element)v.get(195)).setAttribute("height","8" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:194   */
      /* Termina nodo:193   */
      /* Termina nodo:162   */
      /* Termina nodo:161   */
      /* Termina nodo:160   */

      /* Empieza nodo:196 / Elemento padre: 91   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(91)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("td"));
      ((Element)v.get(196)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("table"));
   }

   private void getXML900(Document doc) {
      ((Element)v.get(198)).setAttribute("width","575" );
      ((Element)v.get(198)).setAttribute("border","0" );
      ((Element)v.get(198)).setAttribute("align","left" );
      ((Element)v.get(198)).setAttribute("cellspacing","0" );
      ((Element)v.get(198)).setAttribute("cellpadding","0" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(198)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(199)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(201)).setAttribute("src","b.gif" );
      ((Element)v.get(201)).setAttribute("width","8" );
      ((Element)v.get(201)).setAttribute("height","8" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:200   */

      /* Empieza nodo:202 / Elemento padre: 199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(199)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(203)).setAttribute("nombre","lblUnidadesGeograficas" );
      ((Element)v.get(203)).setAttribute("alto","13" );
      ((Element)v.get(203)).setAttribute("filas","1" );
      ((Element)v.get(203)).setAttribute("valor","" );
      ((Element)v.get(203)).setAttribute("id","datosTitle" );
      ((Element)v.get(203)).setAttribute("cod","1137" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:202   */

      /* Empieza nodo:204 / Elemento padre: 199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(204)).setAttribute("width","100%" );
      ((Element)v.get(199)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(205)).setAttribute("src","b.gif" );
      ((Element)v.get(205)).setAttribute("width","8" );
      ((Element)v.get(205)).setAttribute("height","8" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */
      /* Termina nodo:204   */
      /* Termina nodo:199   */

      /* Empieza nodo:206 / Elemento padre: 198   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(198)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("td"));
      ((Element)v.get(206)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(208)).setAttribute("src","b.gif" );
      ((Element)v.get(208)).setAttribute("width","8" );
      ((Element)v.get(208)).setAttribute("height","8" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */
      /* Termina nodo:207   */

      /* Empieza nodo:209 / Elemento padre: 206   */
      v.add(doc.createElement("td"));
      ((Element)v.get(206)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(210)).setAttribute("nombre","lblUnidadesGeograficasXX" );
      ((Element)v.get(210)).setAttribute("alto","13" );
      ((Element)v.get(210)).setAttribute("filas","1" );
      ((Element)v.get(210)).setAttribute("valor","" );
      ((Element)v.get(210)).setAttribute("id","datosCampos" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */
      /* Termina nodo:209   */

      /* Empieza nodo:211 / Elemento padre: 206   */
      v.add(doc.createElement("td"));
      ((Element)v.get(211)).setAttribute("width","100%" );
      ((Element)v.get(206)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(212)).setAttribute("src","b.gif" );
      ((Element)v.get(212)).setAttribute("width","8" );
      ((Element)v.get(212)).setAttribute("height","8" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */
      /* Termina nodo:211   */
      /* Termina nodo:206   */

      /* Empieza nodo:213 / Elemento padre: 198   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(198)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("td"));
      ((Element)v.get(214)).setAttribute("colspan","4" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(215)).setAttribute("src","b.gif" );
      ((Element)v.get(215)).setAttribute("width","8" );
      ((Element)v.get(215)).setAttribute("height","8" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */
      /* Termina nodo:214   */
      /* Termina nodo:213   */
      /* Termina nodo:198   */
      /* Termina nodo:197   */
      /* Termina nodo:196   */

      /* Empieza nodo:216 / Elemento padre: 91   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(91)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(216)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("table"));
      ((Element)v.get(218)).setAttribute("width","575" );
      ((Element)v.get(218)).setAttribute("border","0" );
      ((Element)v.get(218)).setAttribute("align","left" );
      ((Element)v.get(218)).setAttribute("cellspacing","0" );
      ((Element)v.get(218)).setAttribute("cellpadding","0" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(218)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("td"));
      ((Element)v.get(219)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(221)).setAttribute("src","b.gif" );
      ((Element)v.get(221)).setAttribute("width","8" );
      ((Element)v.get(221)).setAttribute("height","8" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */
      /* Termina nodo:220   */

      /* Empieza nodo:222 / Elemento padre: 219   */
      v.add(doc.createElement("td"));
   }

   private void getXML990(Document doc) {
      ((Element)v.get(219)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(223)).setAttribute("nombre","lblObservaciones" );
      ((Element)v.get(223)).setAttribute("alto","13" );
      ((Element)v.get(223)).setAttribute("filas","1" );
      ((Element)v.get(223)).setAttribute("valor","" );
      ((Element)v.get(223)).setAttribute("id","datosTitle" );
      ((Element)v.get(223)).setAttribute("cod","169" );
      ((Element)v.get(222)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */
      /* Termina nodo:222   */

      /* Empieza nodo:224 / Elemento padre: 219   */
      v.add(doc.createElement("td"));
      ((Element)v.get(224)).setAttribute("width","100%" );
      ((Element)v.get(219)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(225)).setAttribute("src","b.gif" );
      ((Element)v.get(225)).setAttribute("width","8" );
      ((Element)v.get(225)).setAttribute("height","8" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */
      /* Termina nodo:224   */
      /* Termina nodo:219   */

      /* Empieza nodo:226 / Elemento padre: 218   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(218)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("td"));
      ((Element)v.get(226)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(228)).setAttribute("src","b.gif" );
      ((Element)v.get(228)).setAttribute("width","8" );
      ((Element)v.get(228)).setAttribute("height","8" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */
      /* Termina nodo:227   */

      /* Empieza nodo:229 / Elemento padre: 226   */
      v.add(doc.createElement("td"));
      ((Element)v.get(226)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("AREATEXTO"));
      ((Element)v.get(230)).setAttribute("cols","50" );
      ((Element)v.get(230)).setAttribute("id","" );
      ((Element)v.get(230)).setAttribute("msjreq","" );
      ((Element)v.get(230)).setAttribute("nombre","AreaTxtObservaciones" );
      ((Element)v.get(230)).setAttribute("readonly","N" );
      ((Element)v.get(230)).setAttribute("req","N" );
      ((Element)v.get(230)).setAttribute("rows","3" );
      ((Element)v.get(230)).setAttribute("tabindex","2" );
      ((Element)v.get(230)).setAttribute("valor","" );
      ((Element)v.get(230)).setAttribute("max","100" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */
      /* Termina nodo:229   */

      /* Empieza nodo:231 / Elemento padre: 226   */
      v.add(doc.createElement("td"));
      ((Element)v.get(231)).setAttribute("width","100%" );
      ((Element)v.get(226)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(232)).setAttribute("src","b.gif" );
      ((Element)v.get(232)).setAttribute("width","8" );
      ((Element)v.get(232)).setAttribute("height","8" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */
      /* Termina nodo:231   */
      /* Termina nodo:226   */

      /* Empieza nodo:233 / Elemento padre: 218   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(218)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("td"));
      ((Element)v.get(234)).setAttribute("colspan","4" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(235)).setAttribute("src","b.gif" );
      ((Element)v.get(235)).setAttribute("width","8" );
      ((Element)v.get(235)).setAttribute("height","8" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */
      /* Termina nodo:234   */
      /* Termina nodo:233   */
      /* Termina nodo:218   */
      /* Termina nodo:217   */
      /* Termina nodo:216   */
      /* Termina nodo:91   */
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:236 / Elemento padre: 84   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(237)).setAttribute("src","b.gif" );
      ((Element)v.get(237)).setAttribute("width","8" );
      ((Element)v.get(237)).setAttribute("height","12" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */
      /* Termina nodo:236   */
      /* Termina nodo:84   */

      /* Empieza nodo:238 / Elemento padre: 76   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(76)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("td"));
      ((Element)v.get(238)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(240)).setAttribute("src","b.gif" );
      ((Element)v.get(240)).setAttribute("width","8" );
      ((Element)v.get(240)).setAttribute("height","12" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */
      /* Termina nodo:239   */

      /* Empieza nodo:241 / Elemento padre: 238   */
      v.add(doc.createElement("td"));
      ((Element)v.get(238)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(241)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("table"));
      ((Element)v.get(243)).setAttribute("width","100%" );
      ((Element)v.get(243)).setAttribute("border","0" );
      ((Element)v.get(243)).setAttribute("align","center" );
      ((Element)v.get(243)).setAttribute("cellspacing","0" );
      ((Element)v.get(243)).setAttribute("cellpadding","0" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(243)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("td"));
      ((Element)v.get(245)).setAttribute("class","botonera" );
      ((Element)v.get(245)).setAttribute("width","100%" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(244)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(246)).setAttribute("nombre","btnAnadir" );
      ((Element)v.get(246)).setAttribute("ID","botonContenido" );
      ((Element)v.get(246)).setAttribute("tipo","html" );
      ((Element)v.get(246)).setAttribute("accion","javascript:aniadirFilaDirecciones();" );
      ((Element)v.get(246)).setAttribute("estado","false" );
      ((Element)v.get(246)).setAttribute("cod","404" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */

      /* Empieza nodo:247 / Elemento padre: 245   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(247)).setAttribute("nombre","SeleccionarUnidadesGeograficas" );
      ((Element)v.get(247)).setAttribute("ID","botonContenido" );
      ((Element)v.get(247)).setAttribute("tipo","html" );
      ((Element)v.get(247)).setAttribute("estado","false" );
      ((Element)v.get(247)).setAttribute("cod","2266" );
      ((Element)v.get(247)).setAttribute("accion","javascript:seleccionarTerritorioFunc();" );
      ((Element)v.get(245)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */
      /* Termina nodo:245   */
      /* Termina nodo:244   */
      /* Termina nodo:243   */
      /* Termina nodo:242   */
      /* Termina nodo:241   */

      /* Empieza nodo:248 / Elemento padre: 238   */
      v.add(doc.createElement("td"));
      ((Element)v.get(238)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(249)).setAttribute("src","b.gif" );
      ((Element)v.get(249)).setAttribute("width","9" );
      ((Element)v.get(249)).setAttribute("height","12" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */
      /* Termina nodo:248   */
      /* Termina nodo:238   */

      /* Empieza nodo:250 / Elemento padre: 76   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(76)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("td"));
      ((Element)v.get(251)).setAttribute("width","9" );
      ((Element)v.get(251)).setAttribute("align","center" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(252)).setAttribute("src","b.gif" );
      ((Element)v.get(252)).setAttribute("width","8" );
      ((Element)v.get(252)).setAttribute("height","12" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */
      /* Termina nodo:251   */

      /* Empieza nodo:253 / Elemento padre: 250   */
      v.add(doc.createElement("td"));
      ((Element)v.get(253)).setAttribute("width","756" );
      ((Element)v.get(250)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(254)).setAttribute("src","b.gif" );
      ((Element)v.get(254)).setAttribute("width","8" );
      ((Element)v.get(254)).setAttribute("height","12" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */
      /* Termina nodo:253   */

      /* Empieza nodo:255 / Elemento padre: 250   */
      v.add(doc.createElement("td"));
      ((Element)v.get(255)).setAttribute("width","9" );
      ((Element)v.get(250)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(256)).setAttribute("src","b.gif" );
      ((Element)v.get(256)).setAttribute("width","8" );
      ((Element)v.get(256)).setAttribute("height","1" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */
      /* Termina nodo:255   */
      /* Termina nodo:250   */
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:257 / Elemento padre: 13   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(257)).setAttribute("nombre","listado1" );
      ((Element)v.get(257)).setAttribute("ancho","578" );
      ((Element)v.get(257)).setAttribute("alto","179" );
      ((Element)v.get(257)).setAttribute("x","12" );
      ((Element)v.get(257)).setAttribute("y","343" );
      ((Element)v.get(257)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(257)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(13)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(258)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(258)).setAttribute("alto","22" );
      ((Element)v.get(258)).setAttribute("imgFondo","" );
      ((Element)v.get(258)).setAttribute("cod","00143" );
      ((Element)v.get(258)).setAttribute("ID","datosTitle" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */

      /* Empieza nodo:259 / Elemento padre: 257   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(259)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(259)).setAttribute("alto","22" );
      ((Element)v.get(259)).setAttribute("imgFondo","" );
      ((Element)v.get(257)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */

      /* Empieza nodo:260 / Elemento padre: 257   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(260)).setAttribute("precarga","S" );
      ((Element)v.get(260)).setAttribute("conROver","S" );
      ((Element)v.get(257)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(261)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(261)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(261)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(261)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(260)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */

      /* Empieza nodo:262 / Elemento padre: 260   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(262)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(262)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(262)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(262)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(260)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */

      /* Empieza nodo:263 / Elemento padre: 260   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(263)).setAttribute("ordenar","ascendente_on.gif" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(263)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(260)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */
      /* Termina nodo:260   */

      /* Empieza nodo:264 / Elemento padre: 257   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(257)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(265)).setAttribute("borde","1" );
      ((Element)v.get(265)).setAttribute("horizDatos","1" );
      ((Element)v.get(265)).setAttribute("horizCabecera","1" );
      ((Element)v.get(265)).setAttribute("vertical","1" );
      ((Element)v.get(265)).setAttribute("horizTitulo","1" );
      ((Element)v.get(265)).setAttribute("horizBase","1" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */

      /* Empieza nodo:266 / Elemento padre: 264   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(266)).setAttribute("borde","#999999" );
      ((Element)v.get(266)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(266)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(266)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(266)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(266)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(266)).setAttribute("horizBase","#999999" );
      ((Element)v.get(264)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */
      /* Termina nodo:264   */

      /* Empieza nodo:267 / Elemento padre: 257   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(267)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(267)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(267)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(267)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(267)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(267)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(257)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(268)).setAttribute("ancho","200" );
      ((Element)v.get(268)).setAttribute("minimizable","S" );
      ((Element)v.get(268)).setAttribute("minimizada","N" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */

      /* Empieza nodo:269 / Elemento padre: 267   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(269)).setAttribute("ancho","90" );
      ((Element)v.get(269)).setAttribute("minimizable","S" );
      ((Element)v.get(269)).setAttribute("minimizada","N" );
      ((Element)v.get(267)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */

      /* Empieza nodo:270 / Elemento padre: 267   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(270)).setAttribute("ancho","61" );
      ((Element)v.get(270)).setAttribute("minimizable","S" );
      ((Element)v.get(270)).setAttribute("minimizada","N" );
      ((Element)v.get(267)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */

      /* Empieza nodo:271 / Elemento padre: 267   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(271)).setAttribute("ancho","215" );
      ((Element)v.get(271)).setAttribute("minimizable","S" );
      ((Element)v.get(271)).setAttribute("minimizada","N" );
      ((Element)v.get(267)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */

      /* Empieza nodo:272 / Elemento padre: 267   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(272)).setAttribute("ancho","73" );
      ((Element)v.get(272)).setAttribute("minimizable","S" );
      ((Element)v.get(272)).setAttribute("minimizada","N" );
      ((Element)v.get(267)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */

      /* Empieza nodo:273 / Elemento padre: 267   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(273)).setAttribute("ancho","72" );
      ((Element)v.get(273)).setAttribute("minimizable","S" );
      ((Element)v.get(273)).setAttribute("minimizada","N" );
      ((Element)v.get(267)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */

      /* Empieza nodo:274 / Elemento padre: 267   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(274)).setAttribute("ancho","100" );
      ((Element)v.get(274)).setAttribute("minimizable","S" );
      ((Element)v.get(274)).setAttribute("minimizada","N" );
      ((Element)v.get(267)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */

      /* Empieza nodo:275 / Elemento padre: 267   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(275)).setAttribute("ancho","115" );
      ((Element)v.get(275)).setAttribute("minimizable","S" );
      ((Element)v.get(275)).setAttribute("minimizada","N" );
      ((Element)v.get(267)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */

      /* Empieza nodo:276 / Elemento padre: 267   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(276)).setAttribute("ancho","115" );
      ((Element)v.get(276)).setAttribute("minimizable","S" );
      ((Element)v.get(276)).setAttribute("minimizada","N" );
      ((Element)v.get(267)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */

      /* Empieza nodo:277 / Elemento padre: 267   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(277)).setAttribute("ancho","115" );
      ((Element)v.get(277)).setAttribute("minimizable","S" );
      ((Element)v.get(277)).setAttribute("minimizada","N" );
      ((Element)v.get(277)).setAttribute("oculta","S" );
      ((Element)v.get(267)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */

      /* Empieza nodo:278 / Elemento padre: 267   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(278)).setAttribute("ancho","115" );
      ((Element)v.get(278)).setAttribute("minimizable","S" );
      ((Element)v.get(278)).setAttribute("minimizada","N" );
      ((Element)v.get(278)).setAttribute("oculta","S" );
      ((Element)v.get(267)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */

      /* Empieza nodo:279 / Elemento padre: 267   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(279)).setAttribute("ancho","115" );
      ((Element)v.get(279)).setAttribute("minimizable","S" );
      ((Element)v.get(279)).setAttribute("minimizada","N" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(279)).setAttribute("oculta","S" );
      ((Element)v.get(267)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */

      /* Empieza nodo:280 / Elemento padre: 267   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(280)).setAttribute("ancho","115" );
      ((Element)v.get(280)).setAttribute("minimizable","S" );
      ((Element)v.get(280)).setAttribute("minimizada","N" );
      ((Element)v.get(280)).setAttribute("oculta","S" );
      ((Element)v.get(267)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */
      /* Termina nodo:267   */

      /* Empieza nodo:281 / Elemento padre: 257   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(281)).setAttribute("alto","20" );
      ((Element)v.get(281)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(281)).setAttribute("imgFondo","" );
      ((Element)v.get(281)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(257)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(282)).setAttribute("colFondo","" );
      ((Element)v.get(282)).setAttribute("ID","EstCab" );
      ((Element)v.get(282)).setAttribute("align","center" );
      ((Element)v.get(282)).setAttribute("cod","1137" );
      ((Element)v.get(281)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */

      /* Empieza nodo:283 / Elemento padre: 281   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(283)).setAttribute("colFondo","" );
      ((Element)v.get(283)).setAttribute("ID","EstCab" );
      ((Element)v.get(283)).setAttribute("align","center" );
      ((Element)v.get(283)).setAttribute("cod","159" );
      ((Element)v.get(281)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */

      /* Empieza nodo:284 / Elemento padre: 281   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(284)).setAttribute("colFondo","" );
      ((Element)v.get(284)).setAttribute("ID","EstCab" );
      ((Element)v.get(284)).setAttribute("align","center" );
      ((Element)v.get(284)).setAttribute("cod","215" );
      ((Element)v.get(281)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */

      /* Empieza nodo:285 / Elemento padre: 281   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(285)).setAttribute("colFondo","" );
      ((Element)v.get(285)).setAttribute("ID","EstCab" );
      ((Element)v.get(285)).setAttribute("align","center" );
      ((Element)v.get(285)).setAttribute("cod","216" );
      ((Element)v.get(281)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */

      /* Empieza nodo:286 / Elemento padre: 281   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(286)).setAttribute("colFondo","" );
      ((Element)v.get(286)).setAttribute("ID","EstCab" );
      ((Element)v.get(286)).setAttribute("align","center" );
      ((Element)v.get(286)).setAttribute("cod","2267" );
      ((Element)v.get(281)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */

      /* Empieza nodo:287 / Elemento padre: 281   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(287)).setAttribute("colFondo","" );
      ((Element)v.get(287)).setAttribute("ID","EstCab" );
      ((Element)v.get(287)).setAttribute("align","center" );
      ((Element)v.get(287)).setAttribute("cod","939" );
      ((Element)v.get(281)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */

      /* Empieza nodo:288 / Elemento padre: 281   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(288)).setAttribute("colFondo","" );
      ((Element)v.get(288)).setAttribute("ID","EstCab" );
      ((Element)v.get(288)).setAttribute("align","center" );
      ((Element)v.get(288)).setAttribute("cod","1344" );
      ((Element)v.get(281)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */

      /* Empieza nodo:289 / Elemento padre: 281   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(289)).setAttribute("colFondo","" );
      ((Element)v.get(289)).setAttribute("ID","EstCab" );
      ((Element)v.get(289)).setAttribute("align","center" );
      ((Element)v.get(289)).setAttribute("cod","169" );
      ((Element)v.get(281)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */

      /* Empieza nodo:290 / Elemento padre: 281   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(290)).setAttribute("colFondo","" );
      ((Element)v.get(290)).setAttribute("ID","EstCab" );
      ((Element)v.get(290)).setAttribute("align","center" );
      ((Element)v.get(290)).setAttribute("cod","1349" );
      ((Element)v.get(281)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */

      /* Empieza nodo:291 / Elemento padre: 281   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(291)).setAttribute("colFondo","" );
      ((Element)v.get(291)).setAttribute("ID","EstCab" );
      ((Element)v.get(291)).setAttribute("align","center" );
      ((Element)v.get(281)).appendChild((Element)v.get(291));

      /* Elemento padre:291 / Elemento actual: 292   */
      v.add(doc.createTextNode("oidUnidadGeografica"));
      ((Element)v.get(291)).appendChild((Text)v.get(292));

      /* Termina nodo Texto:292   */
      /* Termina nodo:291   */

      /* Empieza nodo:293 / Elemento padre: 281   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(293)).setAttribute("colFondo","" );
      ((Element)v.get(293)).setAttribute("ID","EstCab" );
      ((Element)v.get(293)).setAttribute("align","center" );
      ((Element)v.get(281)).appendChild((Element)v.get(293));

      /* Elemento padre:293 / Elemento actual: 294   */
      v.add(doc.createTextNode("oidVia"));
      ((Element)v.get(293)).appendChild((Text)v.get(294));

      /* Termina nodo Texto:294   */
      /* Termina nodo:293   */

      /* Empieza nodo:295 / Elemento padre: 281   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(295)).setAttribute("colFondo","" );
      ((Element)v.get(295)).setAttribute("ID","EstCab" );
      ((Element)v.get(295)).setAttribute("align","center" );
      ((Element)v.get(281)).appendChild((Element)v.get(295));

      /* Elemento padre:295 / Elemento actual: 296   */
      v.add(doc.createTextNode("oidTipoVia"));
      ((Element)v.get(295)).appendChild((Text)v.get(296));

      /* Termina nodo Texto:296   */
      /* Termina nodo:295   */

      /* Empieza nodo:297 / Elemento padre: 281   */
      v.add(doc.createElement("COL"));
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(297)).setAttribute("colFondo","" );
      ((Element)v.get(297)).setAttribute("ID","EstCab" );
      ((Element)v.get(297)).setAttribute("align","center" );
      ((Element)v.get(281)).appendChild((Element)v.get(297));

      /* Elemento padre:297 / Elemento actual: 298   */
      v.add(doc.createTextNode("oidTipoDireccion"));
      ((Element)v.get(297)).appendChild((Text)v.get(298));

      /* Termina nodo Texto:298   */
      /* Termina nodo:297   */
      /* Termina nodo:281   */

      /* Empieza nodo:299 / Elemento padre: 257   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(299)).setAttribute("alto","22" );
      ((Element)v.get(299)).setAttribute("accion","" );
      ((Element)v.get(299)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(299)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(299)).setAttribute("maxSel","-1" );
      ((Element)v.get(299)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(299)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(299)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(299)).setAttribute("onLoad","" );
      ((Element)v.get(299)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(257)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(300)).setAttribute("tipo","texto" );
      ((Element)v.get(300)).setAttribute("ID","EstDat" );
      ((Element)v.get(299)).appendChild((Element)v.get(300));
      /* Termina nodo:300   */

      /* Empieza nodo:301 / Elemento padre: 299   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(301)).setAttribute("tipo","texto" );
      ((Element)v.get(301)).setAttribute("ID","EstDat2" );
      ((Element)v.get(299)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */

      /* Empieza nodo:302 / Elemento padre: 299   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(302)).setAttribute("tipo","texto" );
      ((Element)v.get(302)).setAttribute("ID","EstDat" );
      ((Element)v.get(299)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */

      /* Empieza nodo:303 / Elemento padre: 299   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(303)).setAttribute("tipo","texto" );
      ((Element)v.get(303)).setAttribute("ID","EstDat2" );
      ((Element)v.get(299)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */

      /* Empieza nodo:304 / Elemento padre: 299   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(304)).setAttribute("tipo","texto" );
      ((Element)v.get(304)).setAttribute("ID","EstDat" );
      ((Element)v.get(299)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */

      /* Empieza nodo:305 / Elemento padre: 299   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(305)).setAttribute("tipo","texto" );
      ((Element)v.get(305)).setAttribute("ID","EstDat2" );
      ((Element)v.get(299)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */

      /* Empieza nodo:306 / Elemento padre: 299   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(306)).setAttribute("tipo","texto" );
      ((Element)v.get(306)).setAttribute("ID","EstDat" );
      ((Element)v.get(299)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */

      /* Empieza nodo:307 / Elemento padre: 299   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(307)).setAttribute("tipo","texto" );
      ((Element)v.get(307)).setAttribute("ID","EstDat2" );
      ((Element)v.get(299)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */

      /* Empieza nodo:308 / Elemento padre: 299   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(308)).setAttribute("tipo","texto" );
      ((Element)v.get(308)).setAttribute("ID","EstDat" );
      ((Element)v.get(299)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */

      /* Empieza nodo:309 / Elemento padre: 299   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(309)).setAttribute("tipo","texto" );
      ((Element)v.get(309)).setAttribute("ID","EstDat2" );
      ((Element)v.get(299)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */

      /* Empieza nodo:310 / Elemento padre: 299   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(310)).setAttribute("tipo","texto" );
      ((Element)v.get(310)).setAttribute("ID","EstDat" );
      ((Element)v.get(299)).appendChild((Element)v.get(310));
      /* Termina nodo:310   */

      /* Empieza nodo:311 / Elemento padre: 299   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(311)).setAttribute("tipo","texto" );
      ((Element)v.get(311)).setAttribute("ID","EstDat2" );
      ((Element)v.get(299)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */

      /* Empieza nodo:312 / Elemento padre: 299   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(312)).setAttribute("tipo","texto" );
      ((Element)v.get(312)).setAttribute("ID","EstDat" );
      ((Element)v.get(299)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */
      /* Termina nodo:299   */

      /* Empieza nodo:313 / Elemento padre: 257   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(257)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */
      /* Termina nodo:257   */

      /* Empieza nodo:314 / Elemento padre: 13   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(314)).setAttribute("nombre","Eliminar1" );
      ((Element)v.get(314)).setAttribute("x","13" );
      ((Element)v.get(314)).setAttribute("y","500" );
      ((Element)v.get(314)).setAttribute("ID","botonContenido" );
      ((Element)v.get(314)).setAttribute("tipo","html" );
      ((Element)v.get(314)).setAttribute("estado","false" );
      ((Element)v.get(314)).setAttribute("cod","1254" );
      ((Element)v.get(314)).setAttribute("accion","javascript:eliminarFilaDirecciones();" );
      ((Element)v.get(13)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */

      /* Empieza nodo:315 / Elemento padre: 13   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(315)).setAttribute("nombre","listado2" );
      ((Element)v.get(315)).setAttribute("ancho","578" );
      ((Element)v.get(315)).setAttribute("alto","161" );
      ((Element)v.get(315)).setAttribute("x","12" );
      ((Element)v.get(315)).setAttribute("y","546" );
      ((Element)v.get(315)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(315)).setAttribute("msgDebugJS","S" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(13)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(316)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(316)).setAttribute("alto","22" );
      ((Element)v.get(316)).setAttribute("imgFondo","" );
      ((Element)v.get(316)).setAttribute("cod","00145" );
      ((Element)v.get(316)).setAttribute("ID","datosTitle" );
      ((Element)v.get(315)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */

      /* Empieza nodo:317 / Elemento padre: 315   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(317)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(317)).setAttribute("alto","22" );
      ((Element)v.get(317)).setAttribute("imgFondo","" );
      ((Element)v.get(315)).appendChild((Element)v.get(317));
      /* Termina nodo:317   */

      /* Empieza nodo:318 / Elemento padre: 315   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(318)).setAttribute("precarga","S" );
      ((Element)v.get(318)).setAttribute("conROver","S" );
      ((Element)v.get(315)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(319)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(319)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(319)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(319)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(318)).appendChild((Element)v.get(319));
      /* Termina nodo:319   */

      /* Empieza nodo:320 / Elemento padre: 318   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(320)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(320)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(320)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(320)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(318)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */

      /* Empieza nodo:321 / Elemento padre: 318   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(321)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(321)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(318)).appendChild((Element)v.get(321));
      /* Termina nodo:321   */
      /* Termina nodo:318   */

      /* Empieza nodo:322 / Elemento padre: 315   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(315)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(323)).setAttribute("borde","1" );
      ((Element)v.get(323)).setAttribute("horizDatos","1" );
      ((Element)v.get(323)).setAttribute("horizCabecera","1" );
      ((Element)v.get(323)).setAttribute("vertical","1" );
      ((Element)v.get(323)).setAttribute("horizTitulo","1" );
      ((Element)v.get(323)).setAttribute("horizBase","1" );
      ((Element)v.get(322)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */

      /* Empieza nodo:324 / Elemento padre: 322   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(324)).setAttribute("borde","#999999" );
      ((Element)v.get(324)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(324)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(324)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(324)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(324)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(324)).setAttribute("horizBase","#999999" );
      ((Element)v.get(322)).appendChild((Element)v.get(324));
      /* Termina nodo:324   */
      /* Termina nodo:322   */

      /* Empieza nodo:325 / Elemento padre: 315   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(325)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(325)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(325)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(325)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(325)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(325)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(315)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(326)).setAttribute("ancho","40" );
      ((Element)v.get(326)).setAttribute("minimizable","S" );
      ((Element)v.get(326)).setAttribute("minimizada","N" );
      ((Element)v.get(325)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */
      /* Termina nodo:325   */

      /* Empieza nodo:327 / Elemento padre: 315   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(327)).setAttribute("alto","20" );
      ((Element)v.get(327)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(327)).setAttribute("imgFondo","" );
      ((Element)v.get(327)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(315)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(328)).setAttribute("colFondo","" );
      ((Element)v.get(328)).setAttribute("ID","EstCab" );
      ((Element)v.get(328)).setAttribute("align","center" );
      ((Element)v.get(328)).setAttribute("cod","6" );
      ((Element)v.get(327)).appendChild((Element)v.get(328));
      /* Termina nodo:328   */
      /* Termina nodo:327   */

      /* Empieza nodo:329 / Elemento padre: 315   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(329)).setAttribute("alto","22" );
      ((Element)v.get(329)).setAttribute("accion","" );
      ((Element)v.get(329)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(329)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(329)).setAttribute("maxSel","-1" );
      ((Element)v.get(329)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(329)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(329)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(329)).setAttribute("onLoad","" );
      ((Element)v.get(329)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(315)).appendChild((Element)v.get(329));

      /* Empieza nodo:330 / Elemento padre: 329   */
      v.add(doc.createElement("COL"));
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(330)).setAttribute("tipo","combo" );
      ((Element)v.get(330)).setAttribute("nombre","comboMarca" );
      ((Element)v.get(330)).setAttribute("IDOBJ","EstDatForm" );
      ((Element)v.get(330)).setAttribute("ID","EstDat" );
      ((Element)v.get(330)).setAttribute("req","S" );
      ((Element)v.get(330)).setAttribute("size","1" );
      ((Element)v.get(330)).setAttribute("multiple","N" );
      ((Element)v.get(330)).setAttribute("onchange","cambioMarca();" );
      ((Element)v.get(329)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(330)).appendChild((Element)v.get(331));
      /* Termina nodo:331   */
      /* Termina nodo:330   */
      /* Termina nodo:329   */

      /* Empieza nodo:332 / Elemento padre: 315   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(315)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(333)).setAttribute("ID","1" );
      ((Element)v.get(332)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(334)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(334)).setAttribute("TIPO","STRING" );
      ((Element)v.get(334)).setAttribute("VALOR","0" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */

      /* Empieza nodo:335 / Elemento padre: 333   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(335)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(335)).setAttribute("TIPO","STRING" );
      ((Element)v.get(335)).setAttribute("VALOR","" );
      ((Element)v.get(333)).appendChild((Element)v.get(335));
      /* Termina nodo:335   */
      /* Termina nodo:333   */
      /* Termina nodo:332   */
      /* Termina nodo:315   */

      /* Empieza nodo:336 / Elemento padre: 13   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(336)).setAttribute("nombre","Anadir2" );
      ((Element)v.get(336)).setAttribute("x","13" );
      ((Element)v.get(336)).setAttribute("y","685" );
      ((Element)v.get(336)).setAttribute("ID","botonContenido" );
      ((Element)v.get(336)).setAttribute("tipo","html" );
      ((Element)v.get(336)).setAttribute("estado","false" );
      ((Element)v.get(336)).setAttribute("cod","404" );
      ((Element)v.get(336)).setAttribute("accion","javascript:aniadirFilaGrupoMarcas();" );
      ((Element)v.get(13)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */

      /* Empieza nodo:337 / Elemento padre: 13   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(337)).setAttribute("nombre","Eliminar2" );
      ((Element)v.get(337)).setAttribute("x","61" );
      ((Element)v.get(337)).setAttribute("y","685" );
      ((Element)v.get(337)).setAttribute("ID","botonContenido" );
      ((Element)v.get(337)).setAttribute("tipo","html" );
      ((Element)v.get(337)).setAttribute("estado","false" );
      ((Element)v.get(337)).setAttribute("cod","1254" );
      ((Element)v.get(337)).setAttribute("accion","javascript:eliminarFilaGrupoMarcas();" );
      ((Element)v.get(13)).appendChild((Element)v.get(337));
      /* Termina nodo:337   */

      /* Empieza nodo:338 / Elemento padre: 13   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(338)).setAttribute("nombre","capaEspacio2" );
      ((Element)v.get(338)).setAttribute("x","0" );
      ((Element)v.get(338)).setAttribute("y","719" );
      ((Element)v.get(13)).appendChild((Element)v.get(338));

      /* Empieza nodo:339 / Elemento padre: 338   */
      v.add(doc.createElement("table"));
      ((Element)v.get(339)).setAttribute("width","100%" );
      ((Element)v.get(339)).setAttribute("border","0" );
      ((Element)v.get(339)).setAttribute("cellspacing","0" );
      ((Element)v.get(339)).setAttribute("cellpadding","0" );
      ((Element)v.get(338)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(339)).appendChild((Element)v.get(340));

      /* Empieza nodo:341 / Elemento padre: 340   */
      v.add(doc.createElement("td"));
      ((Element)v.get(341)).setAttribute("width","9" );
      ((Element)v.get(341)).setAttribute("align","center" );
      ((Element)v.get(340)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(342)).setAttribute("src","b.gif" );
      ((Element)v.get(342)).setAttribute("width","9" );
      ((Element)v.get(342)).setAttribute("height","12" );
      ((Element)v.get(341)).appendChild((Element)v.get(342));
      /* Termina nodo:342   */
      /* Termina nodo:341   */

      /* Empieza nodo:343 / Elemento padre: 340   */
      v.add(doc.createElement("td"));
      ((Element)v.get(343)).setAttribute("width","750" );
      ((Element)v.get(340)).appendChild((Element)v.get(343));

      /* Empieza nodo:344 / Elemento padre: 343   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(344)).setAttribute("src","b.gif" );
      ((Element)v.get(343)).appendChild((Element)v.get(344));
      /* Termina nodo:344   */
      /* Termina nodo:343   */

      /* Empieza nodo:345 / Elemento padre: 340   */
      v.add(doc.createElement("td"));
      ((Element)v.get(345)).setAttribute("width","9" );
      ((Element)v.get(340)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(346)).setAttribute("src","b.gif" );
      ((Element)v.get(346)).setAttribute("width","9" );
      ((Element)v.get(346)).setAttribute("height","1" );
      ((Element)v.get(345)).appendChild((Element)v.get(346));
      /* Termina nodo:346   */
      /* Termina nodo:345   */
      /* Termina nodo:340   */

      /* Empieza nodo:347 / Elemento padre: 339   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(339)).appendChild((Element)v.get(347));

      /* Empieza nodo:348 / Elemento padre: 347   */
      v.add(doc.createElement("td"));
      ((Element)v.get(347)).appendChild((Element)v.get(348));

      /* Empieza nodo:349 / Elemento padre: 348   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(349)).setAttribute("src","b.gif" );
      ((Element)v.get(348)).appendChild((Element)v.get(349));
      /* Termina nodo:349   */
      /* Termina nodo:348   */

      /* Empieza nodo:350 / Elemento padre: 347   */
      v.add(doc.createElement("td"));
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(347)).appendChild((Element)v.get(350));

      /* Empieza nodo:351 / Elemento padre: 350   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(350)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(352)).setAttribute("class","legend" );
      ((Element)v.get(351)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(353)).setAttribute("nombre","lblDatosClasificacion" );
      ((Element)v.get(353)).setAttribute("alto","13" );
      ((Element)v.get(353)).setAttribute("filas","1" );
      ((Element)v.get(353)).setAttribute("valor","" );
      ((Element)v.get(353)).setAttribute("id","legend" );
      ((Element)v.get(353)).setAttribute("cod","00539" );
      ((Element)v.get(352)).appendChild((Element)v.get(353));
      /* Termina nodo:353   */
      /* Termina nodo:352   */

      /* Empieza nodo:354 / Elemento padre: 351   */
      v.add(doc.createElement("table"));
      ((Element)v.get(354)).setAttribute("width","100%" );
      ((Element)v.get(354)).setAttribute("border","0" );
      ((Element)v.get(354)).setAttribute("align","center" );
      ((Element)v.get(354)).setAttribute("cellspacing","0" );
      ((Element)v.get(354)).setAttribute("cellpadding","0" );
      ((Element)v.get(351)).appendChild((Element)v.get(354));

      /* Empieza nodo:355 / Elemento padre: 354   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(354)).appendChild((Element)v.get(355));

      /* Empieza nodo:356 / Elemento padre: 355   */
      v.add(doc.createElement("td"));
      ((Element)v.get(355)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("table"));
      ((Element)v.get(357)).setAttribute("width","575" );
      ((Element)v.get(357)).setAttribute("border","0" );
      ((Element)v.get(357)).setAttribute("align","left" );
      ((Element)v.get(357)).setAttribute("cellspacing","0" );
      ((Element)v.get(357)).setAttribute("cellpadding","0" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));

      /* Empieza nodo:358 / Elemento padre: 357   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(357)).appendChild((Element)v.get(358));

      /* Empieza nodo:359 / Elemento padre: 358   */
      v.add(doc.createElement("td"));
      ((Element)v.get(359)).setAttribute("colspan","3" );
      ((Element)v.get(358)).appendChild((Element)v.get(359));

      /* Empieza nodo:360 / Elemento padre: 359   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(360)).setAttribute("src","b.gif" );
      ((Element)v.get(360)).setAttribute("width","8" );
      ((Element)v.get(360)).setAttribute("height","8" );
      ((Element)v.get(359)).appendChild((Element)v.get(360));
      /* Termina nodo:360   */
      /* Termina nodo:359   */
      /* Termina nodo:358   */

      /* Empieza nodo:361 / Elemento padre: 357   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(357)).appendChild((Element)v.get(361));

      /* Empieza nodo:362 / Elemento padre: 361   */
      v.add(doc.createElement("td"));
      ((Element)v.get(361)).appendChild((Element)v.get(362));

      /* Empieza nodo:363 / Elemento padre: 362   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(363)).setAttribute("src","b.gif" );
      ((Element)v.get(363)).setAttribute("width","8" );
      ((Element)v.get(363)).setAttribute("height","8" );
      ((Element)v.get(362)).appendChild((Element)v.get(363));
      /* Termina nodo:363   */
      /* Termina nodo:362   */

      /* Empieza nodo:364 / Elemento padre: 361   */
      v.add(doc.createElement("td"));
      ((Element)v.get(361)).appendChild((Element)v.get(364));

      /* Empieza nodo:365 / Elemento padre: 364   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(365)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(365)).setAttribute("alto","13" );
      ((Element)v.get(365)).setAttribute("filas","1" );
      ((Element)v.get(365)).setAttribute("valor","" );
      ((Element)v.get(365)).setAttribute("id","datosTitle" );
      ((Element)v.get(365)).setAttribute("cod","6" );
      ((Element)v.get(364)).appendChild((Element)v.get(365));
      /* Termina nodo:365   */
      /* Termina nodo:364   */

      /* Empieza nodo:366 / Elemento padre: 361   */
      v.add(doc.createElement("td"));
      ((Element)v.get(361)).appendChild((Element)v.get(366));

      /* Empieza nodo:367 / Elemento padre: 366   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(367)).setAttribute("src","b.gif" );
      ((Element)v.get(367)).setAttribute("width","25" );
      ((Element)v.get(367)).setAttribute("height","8" );
      ((Element)v.get(366)).appendChild((Element)v.get(367));
      /* Termina nodo:367   */
      /* Termina nodo:366   */

      /* Empieza nodo:368 / Elemento padre: 361   */
      v.add(doc.createElement("td"));
      ((Element)v.get(361)).appendChild((Element)v.get(368));

      /* Empieza nodo:369 / Elemento padre: 368   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(369)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(369)).setAttribute("alto","13" );
      ((Element)v.get(369)).setAttribute("filas","1" );
      ((Element)v.get(369)).setAttribute("valor","" );
      ((Element)v.get(369)).setAttribute("id","datosTitle" );
      ((Element)v.get(369)).setAttribute("cod","7" );
      ((Element)v.get(368)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */
      /* Termina nodo:368   */

      /* Empieza nodo:370 / Elemento padre: 361   */
      v.add(doc.createElement("td"));
      ((Element)v.get(370)).setAttribute("width","100%" );
      ((Element)v.get(361)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(371)).setAttribute("src","b.gif" );
      ((Element)v.get(371)).setAttribute("width","8" );
      ((Element)v.get(371)).setAttribute("height","8" );
      ((Element)v.get(370)).appendChild((Element)v.get(371));
      /* Termina nodo:371   */
      /* Termina nodo:370   */
      /* Termina nodo:361   */

      /* Empieza nodo:372 / Elemento padre: 357   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(357)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("td"));
      ((Element)v.get(372)).appendChild((Element)v.get(373));

      /* Empieza nodo:374 / Elemento padre: 373   */
   }

   private void getXML1710(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(374)).setAttribute("src","b.gif" );
      ((Element)v.get(374)).setAttribute("width","8" );
      ((Element)v.get(374)).setAttribute("height","8" );
      ((Element)v.get(373)).appendChild((Element)v.get(374));
      /* Termina nodo:374   */
      /* Termina nodo:373   */

      /* Empieza nodo:375 / Elemento padre: 372   */
      v.add(doc.createElement("td"));
      ((Element)v.get(375)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(372)).appendChild((Element)v.get(375));

      /* Empieza nodo:376 / Elemento padre: 375   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(376)).setAttribute("nombre","comboMarcaClasificacion" );
      ((Element)v.get(376)).setAttribute("req","S" );
      ((Element)v.get(376)).setAttribute("multiple","N" );
      ((Element)v.get(376)).setAttribute("size","1" );
      ((Element)v.get(376)).setAttribute("id","datosCampos" );
      ((Element)v.get(375)).appendChild((Element)v.get(376));

      /* Empieza nodo:377 / Elemento padre: 376   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(376)).appendChild((Element)v.get(377));
      /* Termina nodo:377   */
      /* Termina nodo:376   */
      /* Termina nodo:375   */

      /* Empieza nodo:378 / Elemento padre: 372   */
      v.add(doc.createElement("td"));
      ((Element)v.get(372)).appendChild((Element)v.get(378));

      /* Empieza nodo:379 / Elemento padre: 378   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(379)).setAttribute("src","b.gif" );
      ((Element)v.get(379)).setAttribute("width","25" );
      ((Element)v.get(379)).setAttribute("height","8" );
      ((Element)v.get(378)).appendChild((Element)v.get(379));
      /* Termina nodo:379   */
      /* Termina nodo:378   */

      /* Empieza nodo:380 / Elemento padre: 372   */
      v.add(doc.createElement("td"));
      ((Element)v.get(380)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(372)).appendChild((Element)v.get(380));

      /* Empieza nodo:381 / Elemento padre: 380   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(381)).setAttribute("nombre","comboCanal" );
      ((Element)v.get(381)).setAttribute("req","S" );
      ((Element)v.get(381)).setAttribute("multiple","N" );
      ((Element)v.get(381)).setAttribute("size","1" );
      ((Element)v.get(381)).setAttribute("id","datosCampos" );
      ((Element)v.get(380)).appendChild((Element)v.get(381));

      /* Empieza nodo:382 / Elemento padre: 381   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(381)).appendChild((Element)v.get(382));
      /* Termina nodo:382   */
      /* Termina nodo:381   */
      /* Termina nodo:380   */

      /* Empieza nodo:383 / Elemento padre: 372   */
      v.add(doc.createElement("td"));
      ((Element)v.get(383)).setAttribute("width","100%" );
      ((Element)v.get(372)).appendChild((Element)v.get(383));

      /* Empieza nodo:384 / Elemento padre: 383   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(384)).setAttribute("src","b.gif" );
      ((Element)v.get(384)).setAttribute("width","8" );
      ((Element)v.get(384)).setAttribute("height","8" );
      ((Element)v.get(383)).appendChild((Element)v.get(384));
      /* Termina nodo:384   */
      /* Termina nodo:383   */
      /* Termina nodo:372   */

      /* Empieza nodo:385 / Elemento padre: 357   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(357)).appendChild((Element)v.get(385));

      /* Empieza nodo:386 / Elemento padre: 385   */
      v.add(doc.createElement("td"));
      ((Element)v.get(386)).setAttribute("colspan","4" );
      ((Element)v.get(385)).appendChild((Element)v.get(386));

      /* Empieza nodo:387 / Elemento padre: 386   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(387)).setAttribute("src","b.gif" );
      ((Element)v.get(387)).setAttribute("width","8" );
      ((Element)v.get(387)).setAttribute("height","8" );
      ((Element)v.get(386)).appendChild((Element)v.get(387));
      /* Termina nodo:387   */
      /* Termina nodo:386   */
      /* Termina nodo:385   */
      /* Termina nodo:357   */
      /* Termina nodo:356   */
      /* Termina nodo:355   */

      /* Empieza nodo:388 / Elemento padre: 354   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(354)).appendChild((Element)v.get(388));

      /* Empieza nodo:389 / Elemento padre: 388   */
      v.add(doc.createElement("td"));
      ((Element)v.get(388)).appendChild((Element)v.get(389));

      /* Empieza nodo:390 / Elemento padre: 389   */
      v.add(doc.createElement("table"));
      ((Element)v.get(390)).setAttribute("width","575" );
      ((Element)v.get(390)).setAttribute("border","0" );
      ((Element)v.get(390)).setAttribute("align","left" );
      ((Element)v.get(390)).setAttribute("cellspacing","0" );
      ((Element)v.get(390)).setAttribute("cellpadding","0" );
      ((Element)v.get(389)).appendChild((Element)v.get(390));

      /* Empieza nodo:391 / Elemento padre: 390   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(390)).appendChild((Element)v.get(391));

      /* Empieza nodo:392 / Elemento padre: 391   */
      v.add(doc.createElement("td"));
      ((Element)v.get(391)).appendChild((Element)v.get(392));

      /* Empieza nodo:393 / Elemento padre: 392   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(393)).setAttribute("src","b.gif" );
      ((Element)v.get(393)).setAttribute("width","8" );
      ((Element)v.get(393)).setAttribute("height","8" );
      ((Element)v.get(392)).appendChild((Element)v.get(393));
      /* Termina nodo:393   */
      /* Termina nodo:392   */

      /* Empieza nodo:394 / Elemento padre: 391   */
      v.add(doc.createElement("td"));
      ((Element)v.get(391)).appendChild((Element)v.get(394));

      /* Empieza nodo:395 / Elemento padre: 394   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(395)).setAttribute("nombre","lblTipoCliente" );
      ((Element)v.get(395)).setAttribute("alto","13" );
      ((Element)v.get(395)).setAttribute("filas","1" );
      ((Element)v.get(395)).setAttribute("valor","" );
      ((Element)v.get(395)).setAttribute("id","datosTitle" );
      ((Element)v.get(395)).setAttribute("cod","1869" );
      ((Element)v.get(394)).appendChild((Element)v.get(395));
      /* Termina nodo:395   */
      /* Termina nodo:394   */

      /* Empieza nodo:396 / Elemento padre: 391   */
      v.add(doc.createElement("td"));
      ((Element)v.get(391)).appendChild((Element)v.get(396));

      /* Empieza nodo:397 / Elemento padre: 396   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(397)).setAttribute("src","b.gif" );
      ((Element)v.get(397)).setAttribute("width","25" );
      ((Element)v.get(397)).setAttribute("height","8" );
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(396)).appendChild((Element)v.get(397));
      /* Termina nodo:397   */
      /* Termina nodo:396   */

      /* Empieza nodo:398 / Elemento padre: 391   */
      v.add(doc.createElement("td"));
      ((Element)v.get(391)).appendChild((Element)v.get(398));

      /* Empieza nodo:399 / Elemento padre: 398   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(399)).setAttribute("nombre","lblSubtipoCliente" );
      ((Element)v.get(399)).setAttribute("alto","13" );
      ((Element)v.get(399)).setAttribute("filas","1" );
      ((Element)v.get(399)).setAttribute("valor","" );
      ((Element)v.get(399)).setAttribute("id","datosTitle" );
      ((Element)v.get(399)).setAttribute("cod","595" );
      ((Element)v.get(398)).appendChild((Element)v.get(399));
      /* Termina nodo:399   */
      /* Termina nodo:398   */

      /* Empieza nodo:400 / Elemento padre: 391   */
      v.add(doc.createElement("td"));
      ((Element)v.get(400)).setAttribute("width","100%" );
      ((Element)v.get(391)).appendChild((Element)v.get(400));

      /* Empieza nodo:401 / Elemento padre: 400   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(401)).setAttribute("src","b.gif" );
      ((Element)v.get(401)).setAttribute("width","8" );
      ((Element)v.get(401)).setAttribute("height","8" );
      ((Element)v.get(400)).appendChild((Element)v.get(401));
      /* Termina nodo:401   */
      /* Termina nodo:400   */
      /* Termina nodo:391   */

      /* Empieza nodo:402 / Elemento padre: 390   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(390)).appendChild((Element)v.get(402));

      /* Empieza nodo:403 / Elemento padre: 402   */
      v.add(doc.createElement("td"));
      ((Element)v.get(402)).appendChild((Element)v.get(403));

      /* Empieza nodo:404 / Elemento padre: 403   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(404)).setAttribute("src","b.gif" );
      ((Element)v.get(404)).setAttribute("width","8" );
      ((Element)v.get(404)).setAttribute("height","8" );
      ((Element)v.get(403)).appendChild((Element)v.get(404));
      /* Termina nodo:404   */
      /* Termina nodo:403   */

      /* Empieza nodo:405 / Elemento padre: 402   */
      v.add(doc.createElement("td"));
      ((Element)v.get(405)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(402)).appendChild((Element)v.get(405));

      /* Empieza nodo:406 / Elemento padre: 405   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(406)).setAttribute("nombre","cbTipoCliente" );
      ((Element)v.get(406)).setAttribute("valorinicial","" );
      ((Element)v.get(406)).setAttribute("req","N" );
      ((Element)v.get(406)).setAttribute("multiple","N" );
      ((Element)v.get(406)).setAttribute("size","1" );
      ((Element)v.get(406)).setAttribute("id","datosCampos" );
      ((Element)v.get(406)).setAttribute("textoinicial","" );
      ((Element)v.get(406)).setAttribute("onchange","onChangeTipo();" );
      ((Element)v.get(405)).appendChild((Element)v.get(406));

      /* Empieza nodo:407 / Elemento padre: 406   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(406)).appendChild((Element)v.get(407));
      /* Termina nodo:407   */
      /* Termina nodo:406   */
      /* Termina nodo:405   */

      /* Empieza nodo:408 / Elemento padre: 402   */
      v.add(doc.createElement("td"));
      ((Element)v.get(402)).appendChild((Element)v.get(408));

      /* Empieza nodo:409 / Elemento padre: 408   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(409)).setAttribute("src","b.gif" );
      ((Element)v.get(409)).setAttribute("width","25" );
      ((Element)v.get(409)).setAttribute("height","8" );
      ((Element)v.get(408)).appendChild((Element)v.get(409));
      /* Termina nodo:409   */
      /* Termina nodo:408   */

      /* Empieza nodo:410 / Elemento padre: 402   */
      v.add(doc.createElement("td"));
      ((Element)v.get(410)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(402)).appendChild((Element)v.get(410));

      /* Empieza nodo:411 / Elemento padre: 410   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(411)).setAttribute("nombre","cbSubtipoCliente" );
      ((Element)v.get(411)).setAttribute("valorinicial","" );
      ((Element)v.get(411)).setAttribute("req","N" );
      ((Element)v.get(411)).setAttribute("multiple","N" );
      ((Element)v.get(411)).setAttribute("size","1" );
      ((Element)v.get(411)).setAttribute("id","datosCampos" );
      ((Element)v.get(411)).setAttribute("textoinicial","" );
      ((Element)v.get(411)).setAttribute("onchange","onChangeSubtipo();" );
      ((Element)v.get(410)).appendChild((Element)v.get(411));

      /* Empieza nodo:412 / Elemento padre: 411   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(411)).appendChild((Element)v.get(412));
      /* Termina nodo:412   */
      /* Termina nodo:411   */
      /* Termina nodo:410   */

      /* Empieza nodo:413 / Elemento padre: 402   */
      v.add(doc.createElement("td"));
      ((Element)v.get(413)).setAttribute("width","100%" );
      ((Element)v.get(402)).appendChild((Element)v.get(413));

      /* Empieza nodo:414 / Elemento padre: 413   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(414)).setAttribute("src","b.gif" );
      ((Element)v.get(414)).setAttribute("width","8" );
      ((Element)v.get(414)).setAttribute("height","8" );
      ((Element)v.get(413)).appendChild((Element)v.get(414));
      /* Termina nodo:414   */
      /* Termina nodo:413   */
      /* Termina nodo:402   */

      /* Empieza nodo:415 / Elemento padre: 390   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(390)).appendChild((Element)v.get(415));

      /* Empieza nodo:416 / Elemento padre: 415   */
      v.add(doc.createElement("td"));
      ((Element)v.get(416)).setAttribute("colspan","4" );
      ((Element)v.get(415)).appendChild((Element)v.get(416));

      /* Empieza nodo:417 / Elemento padre: 416   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(417)).setAttribute("src","b.gif" );
      ((Element)v.get(417)).setAttribute("width","8" );
      ((Element)v.get(417)).setAttribute("height","8" );
      ((Element)v.get(416)).appendChild((Element)v.get(417));
      /* Termina nodo:417   */
      /* Termina nodo:416   */
      /* Termina nodo:415   */
      /* Termina nodo:390   */
      /* Termina nodo:389   */
      /* Termina nodo:388   */

      /* Empieza nodo:418 / Elemento padre: 354   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(354)).appendChild((Element)v.get(418));

      /* Empieza nodo:419 / Elemento padre: 418   */
      v.add(doc.createElement("td"));
      ((Element)v.get(418)).appendChild((Element)v.get(419));

      /* Empieza nodo:420 / Elemento padre: 419   */
      v.add(doc.createElement("table"));
      ((Element)v.get(420)).setAttribute("width","575" );
      ((Element)v.get(420)).setAttribute("border","0" );
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(420)).setAttribute("align","left" );
      ((Element)v.get(420)).setAttribute("cellspacing","0" );
      ((Element)v.get(420)).setAttribute("cellpadding","0" );
      ((Element)v.get(419)).appendChild((Element)v.get(420));

      /* Empieza nodo:421 / Elemento padre: 420   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(420)).appendChild((Element)v.get(421));

      /* Empieza nodo:422 / Elemento padre: 421   */
      v.add(doc.createElement("td"));
      ((Element)v.get(421)).appendChild((Element)v.get(422));

      /* Empieza nodo:423 / Elemento padre: 422   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(423)).setAttribute("src","b.gif" );
      ((Element)v.get(423)).setAttribute("width","8" );
      ((Element)v.get(423)).setAttribute("height","8" );
      ((Element)v.get(422)).appendChild((Element)v.get(423));
      /* Termina nodo:423   */
      /* Termina nodo:422   */

      /* Empieza nodo:424 / Elemento padre: 421   */
      v.add(doc.createElement("td"));
      ((Element)v.get(421)).appendChild((Element)v.get(424));

      /* Empieza nodo:425 / Elemento padre: 424   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(425)).setAttribute("nombre","lblTipoClasificacion" );
      ((Element)v.get(425)).setAttribute("alto","13" );
      ((Element)v.get(425)).setAttribute("filas","1" );
      ((Element)v.get(425)).setAttribute("valor","" );
      ((Element)v.get(425)).setAttribute("id","datosTitle" );
      ((Element)v.get(425)).setAttribute("cod","756" );
      ((Element)v.get(424)).appendChild((Element)v.get(425));
      /* Termina nodo:425   */
      /* Termina nodo:424   */

      /* Empieza nodo:426 / Elemento padre: 421   */
      v.add(doc.createElement("td"));
      ((Element)v.get(421)).appendChild((Element)v.get(426));

      /* Empieza nodo:427 / Elemento padre: 426   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(427)).setAttribute("src","b.gif" );
      ((Element)v.get(427)).setAttribute("width","25" );
      ((Element)v.get(427)).setAttribute("height","8" );
      ((Element)v.get(426)).appendChild((Element)v.get(427));
      /* Termina nodo:427   */
      /* Termina nodo:426   */

      /* Empieza nodo:428 / Elemento padre: 421   */
      v.add(doc.createElement("td"));
      ((Element)v.get(421)).appendChild((Element)v.get(428));

      /* Empieza nodo:429 / Elemento padre: 428   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(429)).setAttribute("nombre","lblClasificacion" );
      ((Element)v.get(429)).setAttribute("alto","13" );
      ((Element)v.get(429)).setAttribute("filas","1" );
      ((Element)v.get(429)).setAttribute("valor","" );
      ((Element)v.get(429)).setAttribute("id","datosTitle" );
      ((Element)v.get(429)).setAttribute("cod","550" );
      ((Element)v.get(428)).appendChild((Element)v.get(429));
      /* Termina nodo:429   */
      /* Termina nodo:428   */

      /* Empieza nodo:430 / Elemento padre: 421   */
      v.add(doc.createElement("td"));
      ((Element)v.get(430)).setAttribute("width","100%" );
      ((Element)v.get(421)).appendChild((Element)v.get(430));

      /* Empieza nodo:431 / Elemento padre: 430   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(431)).setAttribute("src","b.gif" );
      ((Element)v.get(431)).setAttribute("width","8" );
      ((Element)v.get(431)).setAttribute("height","8" );
      ((Element)v.get(430)).appendChild((Element)v.get(431));
      /* Termina nodo:431   */
      /* Termina nodo:430   */
      /* Termina nodo:421   */

      /* Empieza nodo:432 / Elemento padre: 420   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(420)).appendChild((Element)v.get(432));

      /* Empieza nodo:433 / Elemento padre: 432   */
      v.add(doc.createElement("td"));
      ((Element)v.get(432)).appendChild((Element)v.get(433));

      /* Empieza nodo:434 / Elemento padre: 433   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(434)).setAttribute("src","b.gif" );
      ((Element)v.get(434)).setAttribute("width","8" );
      ((Element)v.get(434)).setAttribute("height","8" );
      ((Element)v.get(433)).appendChild((Element)v.get(434));
      /* Termina nodo:434   */
      /* Termina nodo:433   */

      /* Empieza nodo:435 / Elemento padre: 432   */
      v.add(doc.createElement("td"));
      ((Element)v.get(435)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(432)).appendChild((Element)v.get(435));

      /* Empieza nodo:436 / Elemento padre: 435   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(436)).setAttribute("nombre","comboTipoClasificacion" );
      ((Element)v.get(436)).setAttribute("req","N" );
      ((Element)v.get(436)).setAttribute("multiple","N" );
      ((Element)v.get(436)).setAttribute("size","1" );
      ((Element)v.get(436)).setAttribute("id","datosCampos" );
      ((Element)v.get(436)).setAttribute("onchange","javascript:getRefCombo();" );
      ((Element)v.get(435)).appendChild((Element)v.get(436));

      /* Empieza nodo:437 / Elemento padre: 436   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(436)).appendChild((Element)v.get(437));
      /* Termina nodo:437   */
      /* Termina nodo:436   */
      /* Termina nodo:435   */

      /* Empieza nodo:438 / Elemento padre: 432   */
      v.add(doc.createElement("td"));
      ((Element)v.get(432)).appendChild((Element)v.get(438));

      /* Empieza nodo:439 / Elemento padre: 438   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(439)).setAttribute("src","b.gif" );
      ((Element)v.get(439)).setAttribute("width","25" );
      ((Element)v.get(439)).setAttribute("height","8" );
      ((Element)v.get(438)).appendChild((Element)v.get(439));
      /* Termina nodo:439   */
      /* Termina nodo:438   */

      /* Empieza nodo:440 / Elemento padre: 432   */
      v.add(doc.createElement("td"));
      ((Element)v.get(440)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(432)).appendChild((Element)v.get(440));

      /* Empieza nodo:441 / Elemento padre: 440   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(441)).setAttribute("nombre","comboClasificacion" );
      ((Element)v.get(441)).setAttribute("req","N" );
      ((Element)v.get(441)).setAttribute("multiple","N" );
      ((Element)v.get(441)).setAttribute("size","1" );
      ((Element)v.get(441)).setAttribute("id","datosCampos" );
      ((Element)v.get(440)).appendChild((Element)v.get(441));

      /* Empieza nodo:442 / Elemento padre: 441   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(441)).appendChild((Element)v.get(442));
      /* Termina nodo:442   */
      /* Termina nodo:441   */
      /* Termina nodo:440   */

      /* Empieza nodo:443 / Elemento padre: 432   */
      v.add(doc.createElement("td"));
   }

   private void getXML1980(Document doc) {
      ((Element)v.get(443)).setAttribute("width","100%" );
      ((Element)v.get(432)).appendChild((Element)v.get(443));

      /* Empieza nodo:444 / Elemento padre: 443   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(444)).setAttribute("src","b.gif" );
      ((Element)v.get(444)).setAttribute("width","8" );
      ((Element)v.get(444)).setAttribute("height","8" );
      ((Element)v.get(443)).appendChild((Element)v.get(444));
      /* Termina nodo:444   */
      /* Termina nodo:443   */
      /* Termina nodo:432   */

      /* Empieza nodo:445 / Elemento padre: 420   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(420)).appendChild((Element)v.get(445));

      /* Empieza nodo:446 / Elemento padre: 445   */
      v.add(doc.createElement("td"));
      ((Element)v.get(446)).setAttribute("colspan","4" );
      ((Element)v.get(445)).appendChild((Element)v.get(446));

      /* Empieza nodo:447 / Elemento padre: 446   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(447)).setAttribute("src","b.gif" );
      ((Element)v.get(447)).setAttribute("width","8" );
      ((Element)v.get(447)).setAttribute("height","8" );
      ((Element)v.get(446)).appendChild((Element)v.get(447));
      /* Termina nodo:447   */
      /* Termina nodo:446   */
      /* Termina nodo:445   */
      /* Termina nodo:420   */
      /* Termina nodo:419   */
      /* Termina nodo:418   */
      /* Termina nodo:354   */
      /* Termina nodo:351   */
      /* Termina nodo:350   */

      /* Empieza nodo:448 / Elemento padre: 347   */
      v.add(doc.createElement("td"));
      ((Element)v.get(347)).appendChild((Element)v.get(448));

      /* Empieza nodo:449 / Elemento padre: 448   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(449)).setAttribute("src","b.gif" );
      ((Element)v.get(449)).setAttribute("width","9" );
      ((Element)v.get(449)).setAttribute("height","12" );
      ((Element)v.get(448)).appendChild((Element)v.get(449));
      /* Termina nodo:449   */
      /* Termina nodo:448   */
      /* Termina nodo:347   */

      /* Empieza nodo:450 / Elemento padre: 339   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(339)).appendChild((Element)v.get(450));

      /* Empieza nodo:451 / Elemento padre: 450   */
      v.add(doc.createElement("td"));
      ((Element)v.get(450)).appendChild((Element)v.get(451));

      /* Empieza nodo:452 / Elemento padre: 451   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(452)).setAttribute("src","b.gif" );
      ((Element)v.get(451)).appendChild((Element)v.get(452));
      /* Termina nodo:452   */
      /* Termina nodo:451   */

      /* Empieza nodo:453 / Elemento padre: 450   */
      v.add(doc.createElement("td"));
      ((Element)v.get(450)).appendChild((Element)v.get(453));

      /* Empieza nodo:454 / Elemento padre: 453   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(453)).appendChild((Element)v.get(454));

      /* Empieza nodo:455 / Elemento padre: 454   */
      v.add(doc.createElement("table"));
      ((Element)v.get(455)).setAttribute("width","100%" );
      ((Element)v.get(455)).setAttribute("border","0" );
      ((Element)v.get(455)).setAttribute("align","center" );
      ((Element)v.get(455)).setAttribute("cellspacing","0" );
      ((Element)v.get(455)).setAttribute("cellpadding","0" );
      ((Element)v.get(454)).appendChild((Element)v.get(455));

      /* Empieza nodo:456 / Elemento padre: 455   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(455)).appendChild((Element)v.get(456));

      /* Empieza nodo:457 / Elemento padre: 456   */
      v.add(doc.createElement("td"));
      ((Element)v.get(457)).setAttribute("class","botonera" );
      ((Element)v.get(457)).setAttribute("width","100%" );
      ((Element)v.get(456)).appendChild((Element)v.get(457));

      /* Empieza nodo:458 / Elemento padre: 457   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(458)).setAttribute("nombre","btnAnadir2" );
      ((Element)v.get(458)).setAttribute("ID","botonContenido" );
      ((Element)v.get(458)).setAttribute("tipo","html" );
      ((Element)v.get(458)).setAttribute("accion","javascript:aniadirFilaClasificacion();" );
      ((Element)v.get(458)).setAttribute("estado","false" );
      ((Element)v.get(458)).setAttribute("cod","404" );
      ((Element)v.get(457)).appendChild((Element)v.get(458));
      /* Termina nodo:458   */
      /* Termina nodo:457   */
      /* Termina nodo:456   */
      /* Termina nodo:455   */
      /* Termina nodo:454   */
      /* Termina nodo:453   */

      /* Empieza nodo:459 / Elemento padre: 450   */
      v.add(doc.createElement("td"));
      ((Element)v.get(450)).appendChild((Element)v.get(459));

      /* Empieza nodo:460 / Elemento padre: 459   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(460)).setAttribute("src","b.gif" );
      ((Element)v.get(460)).setAttribute("width","9" );
      ((Element)v.get(460)).setAttribute("height","12" );
      ((Element)v.get(459)).appendChild((Element)v.get(460));
      /* Termina nodo:460   */
      /* Termina nodo:459   */
      /* Termina nodo:450   */

      /* Empieza nodo:461 / Elemento padre: 339   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(339)).appendChild((Element)v.get(461));

      /* Empieza nodo:462 / Elemento padre: 461   */
      v.add(doc.createElement("td"));
      ((Element)v.get(462)).setAttribute("width","9" );
      ((Element)v.get(462)).setAttribute("align","center" );
      ((Element)v.get(461)).appendChild((Element)v.get(462));

      /* Empieza nodo:463 / Elemento padre: 462   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(463)).setAttribute("src","b.gif" );
      ((Element)v.get(463)).setAttribute("width","9" );
      ((Element)v.get(463)).setAttribute("height","12" );
      ((Element)v.get(462)).appendChild((Element)v.get(463));
      /* Termina nodo:463   */
      /* Termina nodo:462   */

      /* Empieza nodo:464 / Elemento padre: 461   */
      v.add(doc.createElement("td"));
      ((Element)v.get(464)).setAttribute("width","756" );
      ((Element)v.get(461)).appendChild((Element)v.get(464));

      /* Empieza nodo:465 / Elemento padre: 464   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(465)).setAttribute("src","b.gif" );
      ((Element)v.get(464)).appendChild((Element)v.get(465));
      /* Termina nodo:465   */
      /* Termina nodo:464   */

      /* Empieza nodo:466 / Elemento padre: 461   */
      v.add(doc.createElement("td"));
      ((Element)v.get(466)).setAttribute("width","9" );
      ((Element)v.get(461)).appendChild((Element)v.get(466));

      /* Empieza nodo:467 / Elemento padre: 466   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(467)).setAttribute("src","b.gif" );
      ((Element)v.get(467)).setAttribute("width","9" );
      ((Element)v.get(467)).setAttribute("height","1" );
      ((Element)v.get(466)).appendChild((Element)v.get(467));
      /* Termina nodo:467   */
      /* Termina nodo:466   */
      /* Termina nodo:461   */
      /* Termina nodo:339   */
      /* Termina nodo:338   */

      /* Empieza nodo:468 / Elemento padre: 13   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(468)).setAttribute("nombre","listado3" );
   }

   private void getXML2070(Document doc) {
      ((Element)v.get(468)).setAttribute("ancho","578" );
      ((Element)v.get(468)).setAttribute("alto","179" );
      ((Element)v.get(468)).setAttribute("x","12" );
      ((Element)v.get(468)).setAttribute("y","920" );
      ((Element)v.get(468)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(468)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(13)).appendChild((Element)v.get(468));

      /* Empieza nodo:469 / Elemento padre: 468   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(469)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(469)).setAttribute("alto","22" );
      ((Element)v.get(469)).setAttribute("imgFondo","" );
      ((Element)v.get(469)).setAttribute("cod","0059" );
      ((Element)v.get(469)).setAttribute("ID","datosTitle" );
      ((Element)v.get(468)).appendChild((Element)v.get(469));
      /* Termina nodo:469   */

      /* Empieza nodo:470 / Elemento padre: 468   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(470)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(470)).setAttribute("alto","22" );
      ((Element)v.get(470)).setAttribute("imgFondo","" );
      ((Element)v.get(468)).appendChild((Element)v.get(470));
      /* Termina nodo:470   */

      /* Empieza nodo:471 / Elemento padre: 468   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(471)).setAttribute("precarga","S" );
      ((Element)v.get(471)).setAttribute("conROver","S" );
      ((Element)v.get(468)).appendChild((Element)v.get(471));

      /* Empieza nodo:472 / Elemento padre: 471   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(472)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(472)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(472)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(472)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(471)).appendChild((Element)v.get(472));
      /* Termina nodo:472   */

      /* Empieza nodo:473 / Elemento padre: 471   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(473)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(473)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(473)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(473)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(471)).appendChild((Element)v.get(473));
      /* Termina nodo:473   */

      /* Empieza nodo:474 / Elemento padre: 471   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(474)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(474)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(471)).appendChild((Element)v.get(474));
      /* Termina nodo:474   */
      /* Termina nodo:471   */

      /* Empieza nodo:475 / Elemento padre: 468   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(468)).appendChild((Element)v.get(475));

      /* Empieza nodo:476 / Elemento padre: 475   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(476)).setAttribute("borde","1" );
      ((Element)v.get(476)).setAttribute("horizDatos","1" );
      ((Element)v.get(476)).setAttribute("horizCabecera","1" );
      ((Element)v.get(476)).setAttribute("vertical","1" );
      ((Element)v.get(476)).setAttribute("horizTitulo","1" );
      ((Element)v.get(476)).setAttribute("horizBase","1" );
      ((Element)v.get(475)).appendChild((Element)v.get(476));
      /* Termina nodo:476   */

      /* Empieza nodo:477 / Elemento padre: 475   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(477)).setAttribute("borde","#999999" );
      ((Element)v.get(477)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(477)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(477)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(477)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(477)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(477)).setAttribute("horizBase","#999999" );
      ((Element)v.get(475)).appendChild((Element)v.get(477));
      /* Termina nodo:477   */
      /* Termina nodo:475   */

      /* Empieza nodo:478 / Elemento padre: 468   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(478)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(478)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(478)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(478)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(478)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(478)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(468)).appendChild((Element)v.get(478));

      /* Empieza nodo:479 / Elemento padre: 478   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(479)).setAttribute("ancho","60" );
      ((Element)v.get(479)).setAttribute("minimizable","S" );
      ((Element)v.get(479)).setAttribute("minimizada","N" );
      ((Element)v.get(478)).appendChild((Element)v.get(479));
      /* Termina nodo:479   */

      /* Empieza nodo:480 / Elemento padre: 478   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(480)).setAttribute("ancho","65" );
      ((Element)v.get(480)).setAttribute("minimizable","S" );
      ((Element)v.get(480)).setAttribute("minimizada","N" );
      ((Element)v.get(478)).appendChild((Element)v.get(480));
      /* Termina nodo:480   */

      /* Empieza nodo:481 / Elemento padre: 478   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(481)).setAttribute("ancho","100" );
      ((Element)v.get(481)).setAttribute("minimizable","S" );
      ((Element)v.get(481)).setAttribute("minimizada","N" );
      ((Element)v.get(478)).appendChild((Element)v.get(481));
      /* Termina nodo:481   */

      /* Empieza nodo:482 / Elemento padre: 478   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(482)).setAttribute("ancho","100" );
      ((Element)v.get(482)).setAttribute("minimizable","S" );
      ((Element)v.get(482)).setAttribute("minimizada","N" );
      ((Element)v.get(478)).appendChild((Element)v.get(482));
      /* Termina nodo:482   */

      /* Empieza nodo:483 / Elemento padre: 478   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(483)).setAttribute("ancho","110" );
      ((Element)v.get(483)).setAttribute("minimizable","S" );
      ((Element)v.get(483)).setAttribute("minimizada","N" );
   }

   private void getXML2160(Document doc) {
      ((Element)v.get(478)).appendChild((Element)v.get(483));
      /* Termina nodo:483   */

      /* Empieza nodo:484 / Elemento padre: 478   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(484)).setAttribute("ancho","75" );
      ((Element)v.get(484)).setAttribute("minimizable","S" );
      ((Element)v.get(484)).setAttribute("minimizada","N" );
      ((Element)v.get(478)).appendChild((Element)v.get(484));
      /* Termina nodo:484   */

      /* Empieza nodo:485 / Elemento padre: 478   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(485)).setAttribute("ancho","60" );
      ((Element)v.get(485)).setAttribute("minimizable","S" );
      ((Element)v.get(485)).setAttribute("minimizada","N" );
      ((Element)v.get(485)).setAttribute("oculta","S" );
      ((Element)v.get(478)).appendChild((Element)v.get(485));
      /* Termina nodo:485   */

      /* Empieza nodo:486 / Elemento padre: 478   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(486)).setAttribute("ancho","65" );
      ((Element)v.get(486)).setAttribute("minimizable","S" );
      ((Element)v.get(486)).setAttribute("minimizada","N" );
      ((Element)v.get(486)).setAttribute("oculta","S" );
      ((Element)v.get(478)).appendChild((Element)v.get(486));
      /* Termina nodo:486   */

      /* Empieza nodo:487 / Elemento padre: 478   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(487)).setAttribute("ancho","110" );
      ((Element)v.get(487)).setAttribute("minimizable","S" );
      ((Element)v.get(487)).setAttribute("minimizada","N" );
      ((Element)v.get(487)).setAttribute("oculta","S" );
      ((Element)v.get(478)).appendChild((Element)v.get(487));
      /* Termina nodo:487   */

      /* Empieza nodo:488 / Elemento padre: 478   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(488)).setAttribute("ancho","75" );
      ((Element)v.get(488)).setAttribute("minimizable","S" );
      ((Element)v.get(488)).setAttribute("minimizada","N" );
      ((Element)v.get(488)).setAttribute("oculta","S" );
      ((Element)v.get(478)).appendChild((Element)v.get(488));
      /* Termina nodo:488   */
      /* Termina nodo:478   */

      /* Empieza nodo:489 / Elemento padre: 468   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(489)).setAttribute("alto","20" );
      ((Element)v.get(489)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(489)).setAttribute("imgFondo","" );
      ((Element)v.get(489)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(468)).appendChild((Element)v.get(489));

      /* Empieza nodo:490 / Elemento padre: 489   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(490)).setAttribute("colFondo","" );
      ((Element)v.get(490)).setAttribute("ID","EstCab" );
      ((Element)v.get(490)).setAttribute("align","center" );
      ((Element)v.get(490)).setAttribute("cod","6" );
      ((Element)v.get(489)).appendChild((Element)v.get(490));
      /* Termina nodo:490   */

      /* Empieza nodo:491 / Elemento padre: 489   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(491)).setAttribute("colFondo","" );
      ((Element)v.get(491)).setAttribute("ID","EstCab" );
      ((Element)v.get(491)).setAttribute("align","center" );
      ((Element)v.get(491)).setAttribute("cod","7" );
      ((Element)v.get(489)).appendChild((Element)v.get(491));
      /* Termina nodo:491   */

      /* Empieza nodo:492 / Elemento padre: 489   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(492)).setAttribute("colFondo","" );
      ((Element)v.get(492)).setAttribute("ID","EstCab" );
      ((Element)v.get(492)).setAttribute("align","center" );
      ((Element)v.get(492)).setAttribute("cod","1869" );
      ((Element)v.get(489)).appendChild((Element)v.get(492));
      /* Termina nodo:492   */

      /* Empieza nodo:493 / Elemento padre: 489   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(493)).setAttribute("colFondo","" );
      ((Element)v.get(493)).setAttribute("ID","EstCab" );
      ((Element)v.get(493)).setAttribute("align","center" );
      ((Element)v.get(493)).setAttribute("cod","595" );
      ((Element)v.get(489)).appendChild((Element)v.get(493));
      /* Termina nodo:493   */

      /* Empieza nodo:494 / Elemento padre: 489   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(494)).setAttribute("colFondo","" );
      ((Element)v.get(494)).setAttribute("ID","EstCab" );
      ((Element)v.get(494)).setAttribute("align","center" );
      ((Element)v.get(494)).setAttribute("cod","756" );
      ((Element)v.get(489)).appendChild((Element)v.get(494));
      /* Termina nodo:494   */

      /* Empieza nodo:495 / Elemento padre: 489   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(495)).setAttribute("colFondo","" );
      ((Element)v.get(495)).setAttribute("ID","EstCab" );
      ((Element)v.get(495)).setAttribute("align","center" );
      ((Element)v.get(495)).setAttribute("cod","550" );
      ((Element)v.get(489)).appendChild((Element)v.get(495));
      /* Termina nodo:495   */

      /* Empieza nodo:496 / Elemento padre: 489   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(496)).setAttribute("colFondo","" );
      ((Element)v.get(496)).setAttribute("ID","EstCab" );
      ((Element)v.get(496)).setAttribute("align","center" );
      ((Element)v.get(489)).appendChild((Element)v.get(496));

      /* Elemento padre:496 / Elemento actual: 497   */
      v.add(doc.createTextNode("oidMarcaClasificacion"));
      ((Element)v.get(496)).appendChild((Text)v.get(497));

      /* Termina nodo Texto:497   */
      /* Termina nodo:496   */

      /* Empieza nodo:498 / Elemento padre: 489   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(498)).setAttribute("colFondo","" );
      ((Element)v.get(498)).setAttribute("ID","EstCab" );
      ((Element)v.get(498)).setAttribute("align","center" );
      ((Element)v.get(489)).appendChild((Element)v.get(498));

      /* Elemento padre:498 / Elemento actual: 499   */
      v.add(doc.createTextNode("oidCanalClasificacion"));
      ((Element)v.get(498)).appendChild((Text)v.get(499));

      /* Termina nodo Texto:499   */
      /* Termina nodo:498   */

      /* Empieza nodo:500 / Elemento padre: 489   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(500)).setAttribute("colFondo","" );
      ((Element)v.get(500)).setAttribute("ID","EstCab" );
      ((Element)v.get(500)).setAttribute("align","center" );
   }

   private void getXML2250(Document doc) {
      ((Element)v.get(489)).appendChild((Element)v.get(500));

      /* Elemento padre:500 / Elemento actual: 501   */
      v.add(doc.createTextNode("oidTipoClasificacion"));
      ((Element)v.get(500)).appendChild((Text)v.get(501));

      /* Termina nodo Texto:501   */
      /* Termina nodo:500   */

      /* Empieza nodo:502 / Elemento padre: 489   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(502)).setAttribute("colFondo","" );
      ((Element)v.get(502)).setAttribute("ID","EstCab" );
      ((Element)v.get(502)).setAttribute("align","center" );
      ((Element)v.get(489)).appendChild((Element)v.get(502));

      /* Elemento padre:502 / Elemento actual: 503   */
      v.add(doc.createTextNode("oidClasificacion"));
      ((Element)v.get(502)).appendChild((Text)v.get(503));

      /* Termina nodo Texto:503   */
      /* Termina nodo:502   */
      /* Termina nodo:489   */

      /* Empieza nodo:504 / Elemento padre: 468   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(504)).setAttribute("alto","22" );
      ((Element)v.get(504)).setAttribute("accion","" );
      ((Element)v.get(504)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(504)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(504)).setAttribute("maxSel","-1" );
      ((Element)v.get(504)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(504)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(504)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(504)).setAttribute("onLoad","" );
      ((Element)v.get(504)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(468)).appendChild((Element)v.get(504));

      /* Empieza nodo:505 / Elemento padre: 504   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(505)).setAttribute("tipo","texto" );
      ((Element)v.get(505)).setAttribute("ID","EstDat" );
      ((Element)v.get(504)).appendChild((Element)v.get(505));
      /* Termina nodo:505   */

      /* Empieza nodo:506 / Elemento padre: 504   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(506)).setAttribute("tipo","texto" );
      ((Element)v.get(506)).setAttribute("ID","EstDat2" );
      ((Element)v.get(504)).appendChild((Element)v.get(506));
      /* Termina nodo:506   */

      /* Empieza nodo:507 / Elemento padre: 504   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(507)).setAttribute("tipo","texto" );
      ((Element)v.get(507)).setAttribute("ID","EstDat" );
      ((Element)v.get(504)).appendChild((Element)v.get(507));
      /* Termina nodo:507   */

      /* Empieza nodo:508 / Elemento padre: 504   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(508)).setAttribute("tipo","texto" );
      ((Element)v.get(508)).setAttribute("ID","EstDat2" );
      ((Element)v.get(504)).appendChild((Element)v.get(508));
      /* Termina nodo:508   */

      /* Empieza nodo:509 / Elemento padre: 504   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(509)).setAttribute("tipo","texto" );
      ((Element)v.get(509)).setAttribute("ID","EstDat" );
      ((Element)v.get(504)).appendChild((Element)v.get(509));
      /* Termina nodo:509   */

      /* Empieza nodo:510 / Elemento padre: 504   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(510)).setAttribute("tipo","texto" );
      ((Element)v.get(510)).setAttribute("ID","EstDat2" );
      ((Element)v.get(504)).appendChild((Element)v.get(510));
      /* Termina nodo:510   */

      /* Empieza nodo:511 / Elemento padre: 504   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(511)).setAttribute("tipo","texto" );
      ((Element)v.get(511)).setAttribute("ID","EstDat" );
      ((Element)v.get(504)).appendChild((Element)v.get(511));
      /* Termina nodo:511   */

      /* Empieza nodo:512 / Elemento padre: 504   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(512)).setAttribute("tipo","texto" );
      ((Element)v.get(512)).setAttribute("ID","EstDat2" );
      ((Element)v.get(504)).appendChild((Element)v.get(512));
      /* Termina nodo:512   */

      /* Empieza nodo:513 / Elemento padre: 504   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(513)).setAttribute("tipo","texto" );
      ((Element)v.get(513)).setAttribute("ID","EstDat" );
      ((Element)v.get(504)).appendChild((Element)v.get(513));
      /* Termina nodo:513   */

      /* Empieza nodo:514 / Elemento padre: 504   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(514)).setAttribute("tipo","texto" );
      ((Element)v.get(514)).setAttribute("ID","EstDat2" );
      ((Element)v.get(504)).appendChild((Element)v.get(514));
      /* Termina nodo:514   */
      /* Termina nodo:504   */

      /* Empieza nodo:515 / Elemento padre: 468   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(468)).appendChild((Element)v.get(515));
      /* Termina nodo:515   */
      /* Termina nodo:468   */

      /* Empieza nodo:516 / Elemento padre: 13   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(516)).setAttribute("nombre","Eliminar3" );
      ((Element)v.get(516)).setAttribute("x","13" );
      ((Element)v.get(516)).setAttribute("y","1077" );
      ((Element)v.get(516)).setAttribute("ID","botonContenido" );
      ((Element)v.get(516)).setAttribute("tipo","html" );
      ((Element)v.get(516)).setAttribute("estado","false" );
      ((Element)v.get(516)).setAttribute("cod","1254" );
      ((Element)v.get(516)).setAttribute("accion","eliminarFilaClasificacion();" );
      ((Element)v.get(13)).appendChild((Element)v.get(516));
      /* Termina nodo:516   */

      /* Empieza nodo:517 / Elemento padre: 13   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(517)).setAttribute("nombre","capaEspacio3" );
      ((Element)v.get(517)).setAttribute("x","0" );
      ((Element)v.get(517)).setAttribute("y","1098" );
      ((Element)v.get(13)).appendChild((Element)v.get(517));

      /* Empieza nodo:518 / Elemento padre: 517   */
      v.add(doc.createElement("table"));
      ((Element)v.get(518)).setAttribute("width","100%" );
      ((Element)v.get(518)).setAttribute("border","0" );
      ((Element)v.get(518)).setAttribute("cellspacing","0" );
      ((Element)v.get(518)).setAttribute("cellpadding","0" );
      ((Element)v.get(517)).appendChild((Element)v.get(518));

      /* Empieza nodo:519 / Elemento padre: 518   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(518)).appendChild((Element)v.get(519));

      /* Empieza nodo:520 / Elemento padre: 519   */
      v.add(doc.createElement("td"));
      ((Element)v.get(519)).appendChild((Element)v.get(520));

      /* Empieza nodo:521 / Elemento padre: 520   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML2340(Document doc) {
      ((Element)v.get(521)).setAttribute("src","b.gif" );
      ((Element)v.get(520)).appendChild((Element)v.get(521));
      /* Termina nodo:521   */
      /* Termina nodo:520   */

      /* Empieza nodo:522 / Elemento padre: 519   */
      v.add(doc.createElement("td"));
      ((Element)v.get(519)).appendChild((Element)v.get(522));

      /* Empieza nodo:523 / Elemento padre: 522   */
      v.add(doc.createElement("table"));
      ((Element)v.get(523)).setAttribute("width","100%" );
      ((Element)v.get(523)).setAttribute("border","0" );
      ((Element)v.get(523)).setAttribute("align","center" );
      ((Element)v.get(523)).setAttribute("cellspacing","0" );
      ((Element)v.get(523)).setAttribute("cellpadding","0" );
      ((Element)v.get(522)).appendChild((Element)v.get(523));

      /* Empieza nodo:524 / Elemento padre: 523   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(523)).appendChild((Element)v.get(524));

      /* Empieza nodo:525 / Elemento padre: 524   */
      v.add(doc.createElement("td"));
      ((Element)v.get(524)).appendChild((Element)v.get(525));

      /* Empieza nodo:526 / Elemento padre: 525   */
      v.add(doc.createElement("table"));
      ((Element)v.get(526)).setAttribute("width","579" );
      ((Element)v.get(526)).setAttribute("border","0" );
      ((Element)v.get(526)).setAttribute("align","left" );
      ((Element)v.get(526)).setAttribute("cellspacing","0" );
      ((Element)v.get(526)).setAttribute("cellpadding","0" );
      ((Element)v.get(525)).appendChild((Element)v.get(526));

      /* Empieza nodo:527 / Elemento padre: 526   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(526)).appendChild((Element)v.get(527));

      /* Empieza nodo:528 / Elemento padre: 527   */
      v.add(doc.createElement("td"));
      ((Element)v.get(527)).appendChild((Element)v.get(528));

      /* Empieza nodo:529 / Elemento padre: 528   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(529)).setAttribute("src","b.gif" );
      ((Element)v.get(528)).appendChild((Element)v.get(529));
      /* Termina nodo:529   */
      /* Termina nodo:528   */
      /* Termina nodo:527   */
      /* Termina nodo:526   */
      /* Termina nodo:525   */
      /* Termina nodo:524   */
      /* Termina nodo:523   */
      /* Termina nodo:522   */

      /* Empieza nodo:530 / Elemento padre: 519   */
      v.add(doc.createElement("td"));
      ((Element)v.get(519)).appendChild((Element)v.get(530));

      /* Empieza nodo:531 / Elemento padre: 530   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(531)).setAttribute("src","b.gif" );
      ((Element)v.get(530)).appendChild((Element)v.get(531));
      /* Termina nodo:531   */
      /* Termina nodo:530   */
      /* Termina nodo:519   */

      /* Empieza nodo:532 / Elemento padre: 518   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(518)).appendChild((Element)v.get(532));

      /* Empieza nodo:533 / Elemento padre: 532   */
      v.add(doc.createElement("td"));
      ((Element)v.get(532)).appendChild((Element)v.get(533));

      /* Empieza nodo:534 / Elemento padre: 533   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(534)).setAttribute("src","b.gif" );
      ((Element)v.get(533)).appendChild((Element)v.get(534));
      /* Termina nodo:534   */
      /* Termina nodo:533   */

      /* Empieza nodo:535 / Elemento padre: 532   */
      v.add(doc.createElement("td"));
      ((Element)v.get(532)).appendChild((Element)v.get(535));

      /* Empieza nodo:536 / Elemento padre: 535   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(535)).appendChild((Element)v.get(536));

      /* Empieza nodo:537 / Elemento padre: 536   */
      v.add(doc.createElement("table"));
      ((Element)v.get(537)).setAttribute("width","100%" );
      ((Element)v.get(537)).setAttribute("border","0" );
      ((Element)v.get(537)).setAttribute("align","center" );
      ((Element)v.get(537)).setAttribute("cellspacing","0" );
      ((Element)v.get(537)).setAttribute("cellpadding","0" );
      ((Element)v.get(536)).appendChild((Element)v.get(537));

      /* Empieza nodo:538 / Elemento padre: 537   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(537)).appendChild((Element)v.get(538));

      /* Empieza nodo:539 / Elemento padre: 538   */
      v.add(doc.createElement("td"));
      ((Element)v.get(539)).setAttribute("align","right" );
      ((Element)v.get(539)).setAttribute("class","botonera" );
      ((Element)v.get(539)).setAttribute("width","100%" );
      ((Element)v.get(538)).appendChild((Element)v.get(539));

      /* Empieza nodo:540 / Elemento padre: 539   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(540)).setAttribute("nombre","btnAnterior" );
      ((Element)v.get(540)).setAttribute("ID","botonContenido" );
      ((Element)v.get(540)).setAttribute("tipo","html" );
      ((Element)v.get(540)).setAttribute("accion","javascript:accionP2DesdeP3();" );
      ((Element)v.get(540)).setAttribute("estado","false" );
      ((Element)v.get(540)).setAttribute("cod","1649" );
      ((Element)v.get(539)).appendChild((Element)v.get(540));
      /* Termina nodo:540   */
      /* Termina nodo:539   */
      /* Termina nodo:538   */
      /* Termina nodo:537   */
      /* Termina nodo:536   */
      /* Termina nodo:535   */

      /* Empieza nodo:541 / Elemento padre: 532   */
      v.add(doc.createElement("td"));
      ((Element)v.get(532)).appendChild((Element)v.get(541));

      /* Empieza nodo:542 / Elemento padre: 541   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(542)).setAttribute("src","b.gif" );
      ((Element)v.get(541)).appendChild((Element)v.get(542));
      /* Termina nodo:542   */
      /* Termina nodo:541   */
      /* Termina nodo:532   */

      /* Empieza nodo:543 / Elemento padre: 518   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(518)).appendChild((Element)v.get(543));

      /* Empieza nodo:544 / Elemento padre: 543   */
      v.add(doc.createElement("td"));
      ((Element)v.get(544)).setAttribute("width","9" );
      ((Element)v.get(544)).setAttribute("align","center" );
      ((Element)v.get(543)).appendChild((Element)v.get(544));

      /* Empieza nodo:545 / Elemento padre: 544   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(545)).setAttribute("src","b.gif" );
      ((Element)v.get(545)).setAttribute("width","9" );
      ((Element)v.get(545)).setAttribute("height","12" );
      ((Element)v.get(544)).appendChild((Element)v.get(545));
      /* Termina nodo:545   */
      /* Termina nodo:544   */

      /* Empieza nodo:546 / Elemento padre: 543   */
      v.add(doc.createElement("td"));
      ((Element)v.get(546)).setAttribute("width","756" );
      ((Element)v.get(543)).appendChild((Element)v.get(546));

      /* Empieza nodo:547 / Elemento padre: 546   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(547)).setAttribute("src","b.gif" );
      ((Element)v.get(546)).appendChild((Element)v.get(547));
      /* Termina nodo:547   */
      /* Termina nodo:546   */

      /* Empieza nodo:548 / Elemento padre: 543   */
      v.add(doc.createElement("td"));
   }

   private void getXML2430(Document doc) {
      ((Element)v.get(548)).setAttribute("width","9" );
      ((Element)v.get(543)).appendChild((Element)v.get(548));

      /* Empieza nodo:549 / Elemento padre: 548   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(549)).setAttribute("src","b.gif" );
      ((Element)v.get(549)).setAttribute("width","9" );
      ((Element)v.get(549)).setAttribute("height","1" );
      ((Element)v.get(548)).appendChild((Element)v.get(549));
      /* Termina nodo:549   */
      /* Termina nodo:548   */
      /* Termina nodo:543   */
      /* Termina nodo:518   */
      /* Termina nodo:517   */
      /* Termina nodo:13   */

      /* Empieza nodo:550 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(550)).setAttribute("nombre","frmInsertarClienteVolver" );
      ((Element)v.get(0)).appendChild((Element)v.get(550));

      /* Empieza nodo:551 / Elemento padre: 550   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(551)).setAttribute("nombre","accion" );
      ((Element)v.get(551)).setAttribute("valor","" );
      ((Element)v.get(550)).appendChild((Element)v.get(551));
      /* Termina nodo:551   */

      /* Empieza nodo:552 / Elemento padre: 550   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(552)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(552)).setAttribute("valor","" );
      ((Element)v.get(550)).appendChild((Element)v.get(552));
      /* Termina nodo:552   */

      /* Empieza nodo:553 / Elemento padre: 550   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(553)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(553)).setAttribute("valor","" );
      ((Element)v.get(550)).appendChild((Element)v.get(553));
      /* Termina nodo:553   */

      /* Empieza nodo:554 / Elemento padre: 550   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(554)).setAttribute("nombre","cbTipo" );
      ((Element)v.get(554)).setAttribute("valor","" );
      ((Element)v.get(550)).appendChild((Element)v.get(554));
      /* Termina nodo:554   */

      /* Empieza nodo:555 / Elemento padre: 550   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(555)).setAttribute("nombre","cbSTipo" );
      ((Element)v.get(555)).setAttribute("valor","" );
      ((Element)v.get(550)).appendChild((Element)v.get(555));
      /* Termina nodo:555   */

      /* Empieza nodo:556 / Elemento padre: 550   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(556)).setAttribute("nombre","nameComboSelected" );
      ((Element)v.get(556)).setAttribute("valor","" );
      ((Element)v.get(550)).appendChild((Element)v.get(556));
      /* Termina nodo:556   */

      /* Empieza nodo:557 / Elemento padre: 550   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(557)).setAttribute("nombre","valueComboSelected" );
      ((Element)v.get(557)).setAttribute("valor","" );
      ((Element)v.get(550)).appendChild((Element)v.get(557));
      /* Termina nodo:557   */

      /* Empieza nodo:558 / Elemento padre: 550   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(558)).setAttribute("nombre","usaGeoreferenciador" );
      ((Element)v.get(558)).setAttribute("valor","" );
      ((Element)v.get(550)).appendChild((Element)v.get(558));
      /* Termina nodo:558   */

      /* Empieza nodo:559 / Elemento padre: 550   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(559)).setAttribute("nombre","hidPais" );
      ((Element)v.get(559)).setAttribute("valor","" );
      ((Element)v.get(550)).appendChild((Element)v.get(559));
      /* Termina nodo:559   */

      /* Empieza nodo:560 / Elemento padre: 550   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(560)).setAttribute("nombre","hidIdioma" );
      ((Element)v.get(560)).setAttribute("valor","" );
      ((Element)v.get(550)).appendChild((Element)v.get(560));
      /* Termina nodo:560   */

      /* Empieza nodo:561 / Elemento padre: 550   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(561)).setAttribute("nombre","hidTerritorio" );
      ((Element)v.get(561)).setAttribute("valor","" );
      ((Element)v.get(550)).appendChild((Element)v.get(561));
      /* Termina nodo:561   */

      /* Empieza nodo:562 / Elemento padre: 550   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(562)).setAttribute("nombre","hidDescTerritorio" );
      ((Element)v.get(562)).setAttribute("valor","" );
      ((Element)v.get(550)).appendChild((Element)v.get(562));
      /* Termina nodo:562   */

      /* Empieza nodo:563 / Elemento padre: 550   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(563)).setAttribute("nombre","elementosP3" );
      ((Element)v.get(563)).setAttribute("valor","" );
      ((Element)v.get(550)).appendChild((Element)v.get(563));
      /* Termina nodo:563   */

      /* Empieza nodo:564 / Elemento padre: 550   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(564)).setAttribute("nombre","elementosP3Marca" );
      ((Element)v.get(564)).setAttribute("valor","" );
      ((Element)v.get(550)).appendChild((Element)v.get(564));
      /* Termina nodo:564   */

      /* Empieza nodo:565 / Elemento padre: 550   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(565)).setAttribute("nombre","elementosExtra" );
      ((Element)v.get(565)).setAttribute("valor","" );
      ((Element)v.get(550)).appendChild((Element)v.get(565));
      /* Termina nodo:565   */

      /* Empieza nodo:566 / Elemento padre: 550   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(566)).setAttribute("nombre","primeraVez" );
      ((Element)v.get(566)).setAttribute("valor","" );
      ((Element)v.get(550)).appendChild((Element)v.get(566));
      /* Termina nodo:566   */

      /* Empieza nodo:567 / Elemento padre: 550   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(567)).setAttribute("nombre","envia" );
      ((Element)v.get(567)).setAttribute("valor","" );
      ((Element)v.get(550)).appendChild((Element)v.get(567));
      /* Termina nodo:567   */

      /* Empieza nodo:568 / Elemento padre: 550   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(568)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(568)).setAttribute("valor","" );
      ((Element)v.get(550)).appendChild((Element)v.get(568));
      /* Termina nodo:568   */

      /* Empieza nodo:569 / Elemento padre: 550   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(569)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(569)).setAttribute("valor","" );
      ((Element)v.get(550)).appendChild((Element)v.get(569));
      /* Termina nodo:569   */

      /* Empieza nodo:570 / Elemento padre: 550   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(570)).setAttribute("nombre","hidFocusPrimerComponente" );
      ((Element)v.get(570)).setAttribute("valor","" );
      ((Element)v.get(550)).appendChild((Element)v.get(570));
      /* Termina nodo:570   */
      /* Termina nodo:550   */


   }

}
