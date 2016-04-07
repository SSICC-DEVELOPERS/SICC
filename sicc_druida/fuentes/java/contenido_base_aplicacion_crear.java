
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_base_aplicacion_crear  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_base_aplicacion_crear" );
      ((Element)v.get(0)).setAttribute("cod","0644" );
      ((Element)v.get(0)).setAttribute("titulo","Ingresar valores de descuento" );
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
      ((Element)v.get(3)).setAttribute("src","utilidadesIngresarDesc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","utilidadesDTO.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(5)).setAttribute("src","contenido_base_aplicacion_crear.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","cbMarca" );
      ((Element)v.get(8)).setAttribute("required","false" );
      ((Element)v.get(8)).setAttribute("cod","2448" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","cbUnidadNegocio" );
      ((Element)v.get(9)).setAttribute("required","false" );
      ((Element)v.get(9)).setAttribute("cod","537" );
      ((Element)v.get(7)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","cbNegocio" );
      ((Element)v.get(10)).setAttribute("required","false" );
      ((Element)v.get(10)).setAttribute("cod","588" );
      ((Element)v.get(7)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","cbSupergenerico" );
      ((Element)v.get(11)).setAttribute("required","false" );
      ((Element)v.get(11)).setAttribute("cod","590" );
      ((Element)v.get(7)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","cbGenerico" );
      ((Element)v.get(12)).setAttribute("required","false" );
      ((Element)v.get(12)).setAttribute("cod","589" );
      ((Element)v.get(7)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(13)).setAttribute("name","txtNumUnidadesObligatorias" );
      ((Element)v.get(13)).setAttribute("required","false" );
      ((Element)v.get(13)).setAttribute("cod","860" );
      ((Element)v.get(13)).setAttribute("format","e" );
      ((Element)v.get(7)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(14)).setAttribute("name","cbCicloVida" );
      ((Element)v.get(14)).setAttribute("required","false" );
      ((Element)v.get(14)).setAttribute("cod","581" );
      ((Element)v.get(7)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */
      /* Termina nodo:7   */

      /* Empieza nodo:15 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(15)).setAttribute("nombre","formulario" );
      ((Element)v.get(15)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(15));

      /* Empieza nodo:16 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","idPestanyaDest" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","accion" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(21)).setAttribute("nombre","hidOidBase" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","hidOidDescuento" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","hidMensajeExito" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hidDetalleCriterios" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hidDetalleCriterios2" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hidUltimoElementoEnLaLista" );
      ((Element)v.get(27)).setAttribute("valor","0" );
      ((Element)v.get(15)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","secuencia" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","posicion" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","longitud" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","hExito" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","hidDetalleProductos" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","hidMarcasSel" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","hidUniNegSel" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","hidNegocioSel" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","hidSuperGenericoSel" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","hidGenericoSel" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","hidETO" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","selTipoOferta" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","selCicloVida" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","VisibleBADM" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","ObligatorioBADM" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","ModificableBADM" );
      ((Element)v.get(43)).setAttribute("valor","" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(15)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","VisibleBADUN" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","ObligatorioBADUN" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","ModificableBADUN" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","VisibleBADN" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","ObligatorioBADN" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","ModificableBADN" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","VisibleBADSG" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(51)).setAttribute("nombre","ObligatorioBADSG" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(52)).setAttribute("nombre","ModificableBADSG" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(53)).setAttribute("nombre","VisibleBADG" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(54)).setAttribute("nombre","ObligatorioBADG" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(55)).setAttribute("nombre","ModificableBADG" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(56)).setAttribute("nombre","VisibleBADP" );
      ((Element)v.get(56)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(57)).setAttribute("nombre","ObligatorioBADP" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(58)).setAttribute("nombre","ModificableBADP" );
      ((Element)v.get(58)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */

      /* Empieza nodo:59 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(59)).setAttribute("nombre","varNoLimpiarSICC" );
      ((Element)v.get(59)).setAttribute("valor","true" );
      ((Element)v.get(15)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */

      /* Empieza nodo:60 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(60)).setAttribute("nombre","hFormatoDef" );
      ((Element)v.get(60)).setAttribute("valor","true" );
      ((Element)v.get(15)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */

      /* Empieza nodo:61 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(61)).setAttribute("nombre","oidMarcaCorporativa" );
      ((Element)v.get(61)).setAttribute("valor","0" );
      ((Element)v.get(15)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */

      /* Empieza nodo:62 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(62)).setAttribute("nombre","indiceBase" );
      ((Element)v.get(62)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */

      /* Empieza nodo:63 / Elemento padre: 15   */
      v.add(doc.createElement("table"));
      ((Element)v.get(63)).setAttribute("bgcolor","red" );
      ((Element)v.get(63)).setAttribute("width","100%" );
      ((Element)v.get(63)).setAttribute("height","100%" );
      ((Element)v.get(63)).setAttribute("border","0" );
      ((Element)v.get(63)).setAttribute("align","center" );
      ((Element)v.get(63)).setAttribute("cellpadding","0" );
      ((Element)v.get(63)).setAttribute("cellspacing","0" );
      ((Element)v.get(63)).setAttribute("class","menu5" );
      ((Element)v.get(15)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(65)).setAttribute("width","12" );
      ((Element)v.get(65)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(65)).setAttribute("class","menu5texto" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(66)).setAttribute("src","b.gif" );
      ((Element)v.get(66)).setAttribute("width","12" );
      ((Element)v.get(66)).setAttribute("height","10" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:67 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(67)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(67)).setAttribute("class","menu5texto" );
      ((Element)v.get(64)).appendChild((Element)v.get(67));

      /* Elemento padre:67 / Elemento actual: 68   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(67)).appendChild((Text)v.get(68));

      /* Termina nodo Texto:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:69 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).setAttribute("width","10" );
      ((Element)v.get(69)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(69)).setAttribute("class","menu5texto" );
      ((Element)v.get(64)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(70)).setAttribute("src","b.gif" );
      ((Element)v.get(70)).setAttribute("width","10" );
      ((Element)v.get(70)).setAttribute("height","0" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:71 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).setAttribute("width","10" );
      ((Element)v.get(71)).setAttribute("class","menu5texto" );
      ((Element)v.get(64)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(72)).setAttribute("src","b.gif" );
      ((Element)v.get(72)).setAttribute("width","10" );
      ((Element)v.get(72)).setAttribute("height","8" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:73 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).setAttribute("width","20" );
      ((Element)v.get(73)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(73)).setAttribute("class","menu5texto" );
      ((Element)v.get(64)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("table"));
      ((Element)v.get(74)).setAttribute("width","75" );
      ((Element)v.get(74)).setAttribute("border","0" );
      ((Element)v.get(74)).setAttribute("align","center" );
      ((Element)v.get(74)).setAttribute("cellpadding","1" );
      ((Element)v.get(74)).setAttribute("cellspacing","0" );
      ((Element)v.get(74)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(75)).setAttribute("align","center" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("td"));
      ((Element)v.get(76)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(76)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("a"));
      ((Element)v.get(77)).setAttribute("href","#" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("DIV"));
      ((Element)v.get(78)).setAttribute("ID","InsertarP1" );
      ((Element)v.get(78)).setAttribute("onmouseover","poneManito('InsertarP1');" );
      ((Element)v.get(78)).setAttribute("onclick","onClickPestanya('0')" );
      ((Element)v.get(78)).setAttribute("style","width:80px;border-style:solid; border-color:#496A9A;border-width:2px;position:relative;top:3px;text-align:center;color:#496A9A;font-family: Arial, Helvetica, sans-serif;font-size: 11px;font-weight: bold; visibility:visible" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Elemento padre:78 / Elemento actual: 79   */
      v.add(doc.createTextNode("Datos generales"));
      ((Element)v.get(78)).appendChild((Text)v.get(79));

      /* Termina nodo Texto:79   */
      /* Termina nodo:78   */
      /* Termina nodo:77   */
      /* Termina nodo:76   */
      /* Termina nodo:75   */
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:80 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).setAttribute("width","10" );
      ((Element)v.get(80)).setAttribute("class","menu5texto" );
      ((Element)v.get(64)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(81)).setAttribute("src","b.gif" );
      ((Element)v.get(81)).setAttribute("width","10" );
      ((Element)v.get(81)).setAttribute("height","8" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:82 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).setAttribute("width","20" );
      ((Element)v.get(82)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(82)).setAttribute("class","menu5texto" );
      ((Element)v.get(64)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("table"));
      ((Element)v.get(83)).setAttribute("width","75" );
      ((Element)v.get(83)).setAttribute("border","0" );
      ((Element)v.get(83)).setAttribute("align","center" );
      ((Element)v.get(83)).setAttribute("cellpadding","1" );
      ((Element)v.get(83)).setAttribute("cellspacing","0" );
      ((Element)v.get(83)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(84)).setAttribute("align","center" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(85)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("DIV"));
      ((Element)v.get(86)).setAttribute("ID","InsertarP2" );
      ((Element)v.get(86)).setAttribute("onmouseover","poneManito('InsertarP2');" );
      ((Element)v.get(86)).setAttribute("onclick","onClickPestanya('1')" );
      ((Element)v.get(86)).setAttribute("style","width:80px;border-style:solid; border-color:#496A9A;border-width:2px;position:relative;top:3px;text-align:center;color:#496A9A;font-family: Arial, Helvetica, sans-serif;font-size: 11px;font-weight: bold; visibility:visible" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));

      /* Elemento padre:86 / Elemento actual: 87   */
      v.add(doc.createTextNode("Tipo de cliente"));
      ((Element)v.get(86)).appendChild((Text)v.get(87));

      /* Termina nodo Texto:87   */
      /* Termina nodo:86   */
      /* Termina nodo:85   */
      /* Termina nodo:84   */
      /* Termina nodo:83   */
      /* Termina nodo:82   */

      /* Empieza nodo:88 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).setAttribute("width","10" );
      ((Element)v.get(88)).setAttribute("class","menu5texto" );
      ((Element)v.get(64)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(89)).setAttribute("src","b.gif" );
      ((Element)v.get(89)).setAttribute("width","10" );
      ((Element)v.get(89)).setAttribute("height","8" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */

      /* Empieza nodo:90 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).setAttribute("width","20" );
      ((Element)v.get(90)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(90)).setAttribute("class","menu5texto" );
      ((Element)v.get(64)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("table"));
      ((Element)v.get(91)).setAttribute("width","75" );
      ((Element)v.get(91)).setAttribute("border","0" );
      ((Element)v.get(91)).setAttribute("align","center" );
      ((Element)v.get(91)).setAttribute("cellpadding","1" );
      ((Element)v.get(91)).setAttribute("cellspacing","0" );
      ((Element)v.get(91)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(92)).setAttribute("align","center" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(93)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("DIV"));
      ((Element)v.get(94)).setAttribute("ID","InsertarP3" );
      ((Element)v.get(94)).setAttribute("onmouseover","poneManito('InsertarP3');" );
      ((Element)v.get(94)).setAttribute("onclick","onClickPestanya('2')" );
      ((Element)v.get(94)).setAttribute("style","width:80px;border-style:solid; border-color:#496A9A;border-width:2px;position:relative;top:3px;text-align:center;color:#496A9A;font-family: Arial, Helvetica, sans-serif;font-size: 11px;font-weight: bold; visibility:visible" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Elemento padre:94 / Elemento actual: 95   */
      v.add(doc.createTextNode("Alcance administrativo"));
      ((Element)v.get(94)).appendChild((Text)v.get(95));

      /* Termina nodo Texto:95   */
      /* Termina nodo:94   */
      /* Termina nodo:93   */
      /* Termina nodo:92   */
      /* Termina nodo:91   */
      /* Termina nodo:90   */

      /* Empieza nodo:96 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).setAttribute("width","10" );
      ((Element)v.get(96)).setAttribute("class","menu5texto" );
      ((Element)v.get(64)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(97)).setAttribute("src","b.gif" );
      ((Element)v.get(97)).setAttribute("width","10" );
      ((Element)v.get(97)).setAttribute("height","8" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:98 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).setAttribute("width","20" );
      ((Element)v.get(98)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(98)).setAttribute("class","menu5texto" );
      ((Element)v.get(64)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("table"));
      ((Element)v.get(99)).setAttribute("width","75" );
      ((Element)v.get(99)).setAttribute("border","0" );
      ((Element)v.get(99)).setAttribute("align","center" );
      ((Element)v.get(99)).setAttribute("cellpadding","1" );
      ((Element)v.get(99)).setAttribute("cellspacing","0" );
      ((Element)v.get(99)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(100)).setAttribute("align","center" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(101)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(101)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("DIV"));
      ((Element)v.get(102)).setAttribute("ID","InsertarP4" );
      ((Element)v.get(102)).setAttribute("onmouseover","poneManito('InsertarP4');" );
      ((Element)v.get(102)).setAttribute("onclick","onClickPestanya('3')" );
      ((Element)v.get(102)).setAttribute("style","width:80px;border-style:solid; border-color:#496A9A;border-width:2px;position:relative;top:3px;text-align:center;color:#496A9A;font-family: Arial, Helvetica, sans-serif;font-size: 11px;font-weight: bold; visibility:visible" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));

      /* Elemento padre:102 / Elemento actual: 103   */
      v.add(doc.createTextNode("Base de cálculo"));
      ((Element)v.get(102)).appendChild((Text)v.get(103));

      /* Termina nodo Texto:103   */
      /* Termina nodo:102   */
      /* Termina nodo:101   */
      /* Termina nodo:100   */
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:104 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).setAttribute("width","10" );
      ((Element)v.get(104)).setAttribute("class","menu5texto" );
      ((Element)v.get(64)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
   }

   private void getXML450(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(105)).setAttribute("src","b.gif" );
      ((Element)v.get(105)).setAttribute("width","10" );
      ((Element)v.get(105)).setAttribute("height","8" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:106 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(106)).setAttribute("width","20" );
      ((Element)v.get(106)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(106)).setAttribute("class","menu5texto" );
      ((Element)v.get(64)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("table"));
      ((Element)v.get(107)).setAttribute("width","75" );
      ((Element)v.get(107)).setAttribute("border","0" );
      ((Element)v.get(107)).setAttribute("align","center" );
      ((Element)v.get(107)).setAttribute("cellpadding","1" );
      ((Element)v.get(107)).setAttribute("cellspacing","0" );
      ((Element)v.get(107)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(108)).setAttribute("align","center" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(109)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("DIV"));
      ((Element)v.get(110)).setAttribute("ID","InsertarP5" );
      ((Element)v.get(110)).setAttribute("style","width:80px;border-style:solid; border-color:#496A9A;border-width:2px;position:relative;top:3px;text-align:center;color:#496A9A;font-family: Arial, Helvetica, sans-serif;font-size: 11px;font-weight: bold; visibility:visible" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Elemento padre:110 / Elemento actual: 111   */
      v.add(doc.createTextNode("Aplicación de descuento"));
      ((Element)v.get(110)).appendChild((Text)v.get(111));

      /* Termina nodo Texto:111   */
      /* Termina nodo:110   */
      /* Termina nodo:109   */
      /* Termina nodo:108   */
      /* Termina nodo:107   */
      /* Termina nodo:106   */

      /* Empieza nodo:112 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).setAttribute("width","16" );
      ((Element)v.get(112)).setAttribute("class","menu5texto" );
      ((Element)v.get(64)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(113)).setAttribute("src","b.gif" );
      ((Element)v.get(113)).setAttribute("width","12" );
      ((Element)v.get(113)).setAttribute("height","8" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:114 / Elemento padre: 15   */
      v.add(doc.createElement("table"));
      ((Element)v.get(114)).setAttribute("width","100%" );
      ((Element)v.get(114)).setAttribute("border","0" );
      ((Element)v.get(114)).setAttribute("cellspacing","0" );
      ((Element)v.get(114)).setAttribute("cellpadding","0" );
      ((Element)v.get(15)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(114)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).setAttribute("width","12" );
      ((Element)v.get(116)).setAttribute("align","center" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(117)).setAttribute("src","b.gif" );
      ((Element)v.get(117)).setAttribute("width","12" );
      ((Element)v.get(117)).setAttribute("height","12" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:118 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(118)).setAttribute("width","750" );
      ((Element)v.get(115)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(119)).setAttribute("src","b.gif" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:120 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(120)).setAttribute("width","12" );
      ((Element)v.get(115)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(121)).setAttribute("src","b.gif" );
      ((Element)v.get(121)).setAttribute("width","12" );
      ((Element)v.get(121)).setAttribute("height","1" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */
      /* Termina nodo:115   */

      /* Empieza nodo:122 / Elemento padre: 114   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(114)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(124)).setAttribute("src","b.gif" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:125 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(127)).setAttribute("class","legend" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(128)).setAttribute("nombre","lblDefinicionBases" );
      ((Element)v.get(128)).setAttribute("alto","13" );
      ((Element)v.get(128)).setAttribute("filas","1" );
      ((Element)v.get(128)).setAttribute("valor","" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(128)).setAttribute("cod","0097" );
      ((Element)v.get(128)).setAttribute("id","legend" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:129 / Elemento padre: 126   */
      v.add(doc.createElement("table"));
      ((Element)v.get(129)).setAttribute("width","100%" );
      ((Element)v.get(129)).setAttribute("border","0" );
      ((Element)v.get(129)).setAttribute("align","center" );
      ((Element)v.get(129)).setAttribute("cellspacing","0" );
      ((Element)v.get(129)).setAttribute("cellpadding","0" );
      ((Element)v.get(126)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(129)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("table"));
      ((Element)v.get(132)).setAttribute("width","575" );
      ((Element)v.get(132)).setAttribute("border","0" );
      ((Element)v.get(132)).setAttribute("align","left" );
      ((Element)v.get(132)).setAttribute("cellspacing","0" );
      ((Element)v.get(132)).setAttribute("cellpadding","0" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(132)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).setAttribute("colspan","4" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(135)).setAttribute("src","b.gif" );
      ((Element)v.get(135)).setAttribute("width","8" );
      ((Element)v.get(135)).setAttribute("height","8" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */
      /* Termina nodo:133   */

      /* Empieza nodo:136 / Elemento padre: 132   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(132)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(138)).setAttribute("src","b.gif" );
      ((Element)v.get(138)).setAttribute("width","8" );
      ((Element)v.get(138)).setAttribute("height","8" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:139 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(140)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(140)).setAttribute("alto","13" );
      ((Element)v.get(140)).setAttribute("filas","1" );
      ((Element)v.get(140)).setAttribute("valor","" );
      ((Element)v.get(140)).setAttribute("id","datosTitle" );
      ((Element)v.get(140)).setAttribute("cod","2448" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:141 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(142)).setAttribute("src","b.gif" );
      ((Element)v.get(142)).setAttribute("width","25" );
      ((Element)v.get(142)).setAttribute("height","8" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */

      /* Empieza nodo:143 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(144)).setAttribute("nombre","lblUnidadNegocio" );
      ((Element)v.get(144)).setAttribute("alto","13" );
      ((Element)v.get(144)).setAttribute("filas","1" );
      ((Element)v.get(144)).setAttribute("valor","" );
      ((Element)v.get(144)).setAttribute("id","datosTitle" );
      ((Element)v.get(144)).setAttribute("cod","587" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */

      /* Empieza nodo:145 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(145)).setAttribute("width","100%" );
      ((Element)v.get(145)).setAttribute("colspan","2" );
      ((Element)v.get(136)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(146)).setAttribute("src","b.gif" );
      ((Element)v.get(146)).setAttribute("width","8" );
      ((Element)v.get(146)).setAttribute("height","8" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */
      /* Termina nodo:136   */

      /* Empieza nodo:147 / Elemento padre: 132   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(132)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(149)).setAttribute("src","b.gif" );
      ((Element)v.get(149)).setAttribute("width","8" );
      ((Element)v.get(149)).setAttribute("height","8" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */

      /* Empieza nodo:150 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(147)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(151)).setAttribute("nombre","cbMarca" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(151)).setAttribute("id","datosCampos" );
      ((Element)v.get(151)).setAttribute("size","1" );
      ((Element)v.get(151)).setAttribute("multiple","N" );
      ((Element)v.get(151)).setAttribute("req","N" );
      ((Element)v.get(151)).setAttribute("valorinicial","" );
      ((Element)v.get(151)).setAttribute("textoinicial","" );
      ((Element)v.get(151)).setAttribute("ontab","ontabComboMarca();" );
      ((Element)v.get(151)).setAttribute("onshtab","onshtabMarca();" );
      ((Element)v.get(151)).setAttribute("onchange","marcaOnChange();" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:153 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(154)).setAttribute("src","b.gif" );
      ((Element)v.get(154)).setAttribute("width","25" );
      ((Element)v.get(154)).setAttribute("height","8" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */

      /* Empieza nodo:155 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(155)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(147)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(156)).setAttribute("nombre","cbUnidadNegocio" );
      ((Element)v.get(156)).setAttribute("id","datosCampos" );
      ((Element)v.get(156)).setAttribute("size","1" );
      ((Element)v.get(156)).setAttribute("multiple","N" );
      ((Element)v.get(156)).setAttribute("req","N" );
      ((Element)v.get(156)).setAttribute("valorinicial","" );
      ((Element)v.get(156)).setAttribute("textoinicial","" );
      ((Element)v.get(156)).setAttribute("onchange","unidadNegocioOnChange();" );
      ((Element)v.get(156)).setAttribute("ontab","ontabComboUnidadNegocio();" );
      ((Element)v.get(156)).setAttribute("onshtab","onshtabUnidadNegocio();" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(156)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */
      /* Termina nodo:156   */
      /* Termina nodo:155   */

      /* Empieza nodo:158 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(158)).setAttribute("width","100%" );
      ((Element)v.get(147)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(159)).setAttribute("src","b.gif" );
      ((Element)v.get(159)).setAttribute("width","8" );
      ((Element)v.get(159)).setAttribute("height","8" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */
      /* Termina nodo:147   */

      /* Empieza nodo:160 / Elemento padre: 132   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(132)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("td"));
      ((Element)v.get(161)).setAttribute("colspan","4" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(162)).setAttribute("src","b.gif" );
      ((Element)v.get(162)).setAttribute("width","8" );
      ((Element)v.get(162)).setAttribute("height","8" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */
      /* Termina nodo:161   */
      /* Termina nodo:160   */
      /* Termina nodo:132   */
      /* Termina nodo:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:163 / Elemento padre: 129   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(129)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("table"));
      ((Element)v.get(165)).setAttribute("width","575" );
      ((Element)v.get(165)).setAttribute("border","0" );
      ((Element)v.get(165)).setAttribute("align","left" );
      ((Element)v.get(165)).setAttribute("cellspacing","0" );
      ((Element)v.get(165)).setAttribute("cellpadding","0" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(165)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(166)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(168)).setAttribute("src","b.gif" );
      ((Element)v.get(168)).setAttribute("width","8" );
      ((Element)v.get(168)).setAttribute("height","8" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */

      /* Empieza nodo:169 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(166)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(170)).setAttribute("nombre","lblNegocio" );
      ((Element)v.get(170)).setAttribute("alto","13" );
      ((Element)v.get(170)).setAttribute("filas","1" );
      ((Element)v.get(170)).setAttribute("valor","" );
      ((Element)v.get(170)).setAttribute("id","datosTitle" );
      ((Element)v.get(170)).setAttribute("cod","588" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */

      /* Empieza nodo:171 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(166)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(172)).setAttribute("src","b.gif" );
      ((Element)v.get(172)).setAttribute("width","25" );
      ((Element)v.get(172)).setAttribute("height","8" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:171   */

      /* Empieza nodo:173 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(166)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(174)).setAttribute("nombre","lblSupergenerico" );
      ((Element)v.get(174)).setAttribute("alto","13" );
      ((Element)v.get(174)).setAttribute("filas","1" );
      ((Element)v.get(174)).setAttribute("valor","" );
      ((Element)v.get(174)).setAttribute("id","datosTitle" );
      ((Element)v.get(174)).setAttribute("cod","590" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */
      /* Termina nodo:173   */

      /* Empieza nodo:175 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).setAttribute("width","100%" );
      ((Element)v.get(175)).setAttribute("colspan","2" );
      ((Element)v.get(166)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(176)).setAttribute("src","b.gif" );
      ((Element)v.get(176)).setAttribute("width","8" );
      ((Element)v.get(176)).setAttribute("height","8" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:175   */
      /* Termina nodo:166   */

      /* Empieza nodo:177 / Elemento padre: 165   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(165)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(177)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(179)).setAttribute("src","b.gif" );
      ((Element)v.get(179)).setAttribute("width","8" );
      ((Element)v.get(179)).setAttribute("height","8" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:178   */

      /* Empieza nodo:180 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(180)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(177)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(181)).setAttribute("nombre","cbNegocio" );
      ((Element)v.get(181)).setAttribute("id","datosCampos" );
      ((Element)v.get(181)).setAttribute("size","1" );
      ((Element)v.get(181)).setAttribute("multiple","N" );
      ((Element)v.get(181)).setAttribute("req","N" );
      ((Element)v.get(181)).setAttribute("valorinicial","" );
      ((Element)v.get(181)).setAttribute("textoinicial","" );
      ((Element)v.get(181)).setAttribute("onchange","NegocioOnChange();" );
      ((Element)v.get(181)).setAttribute("ontab","ontabComboNegocio();" );
      ((Element)v.get(181)).setAttribute("onshtab","onshtabNegocio();" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:181   */
      /* Termina nodo:180   */

      /* Empieza nodo:183 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(177)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(184)).setAttribute("src","b.gif" );
      ((Element)v.get(184)).setAttribute("width","25" );
      ((Element)v.get(184)).setAttribute("height","8" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */

      /* Empieza nodo:185 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(185)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(177)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(186)).setAttribute("nombre","cbSupergenerico" );
      ((Element)v.get(186)).setAttribute("id","datosCampos" );
      ((Element)v.get(186)).setAttribute("size","1" );
      ((Element)v.get(186)).setAttribute("multiple","N" );
      ((Element)v.get(186)).setAttribute("req","N" );
      ((Element)v.get(186)).setAttribute("valorinicial","" );
      ((Element)v.get(186)).setAttribute("textoinicial","" );
      ((Element)v.get(186)).setAttribute("onchange","SuperGenericoOnChange();" );
      ((Element)v.get(186)).setAttribute("ontab","ontabComboSuperGenerico();" );
      ((Element)v.get(186)).setAttribute("onshtab","onshtabSuperGenerico();" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(186)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */
      /* Termina nodo:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:188 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(188)).setAttribute("width","100%" );
      ((Element)v.get(177)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(189)).setAttribute("src","b.gif" );
      ((Element)v.get(189)).setAttribute("width","8" );
      ((Element)v.get(189)).setAttribute("height","8" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */
      /* Termina nodo:188   */
      /* Termina nodo:177   */

      /* Empieza nodo:190 / Elemento padre: 165   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(165)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("td"));
      ((Element)v.get(191)).setAttribute("colspan","4" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(192)).setAttribute("src","b.gif" );
      ((Element)v.get(192)).setAttribute("width","8" );
      ((Element)v.get(192)).setAttribute("height","8" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:191   */
      /* Termina nodo:190   */
      /* Termina nodo:165   */
      /* Termina nodo:164   */
      /* Termina nodo:163   */

      /* Empieza nodo:193 / Elemento padre: 129   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(129)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
   }

   private void getXML810(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("table"));
      ((Element)v.get(195)).setAttribute("width","575" );
      ((Element)v.get(195)).setAttribute("border","0" );
      ((Element)v.get(195)).setAttribute("align","left" );
      ((Element)v.get(195)).setAttribute("cellspacing","0" );
      ((Element)v.get(195)).setAttribute("cellpadding","0" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(195)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("td"));
      ((Element)v.get(196)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(198)).setAttribute("src","b.gif" );
      ((Element)v.get(198)).setAttribute("width","8" );
      ((Element)v.get(198)).setAttribute("height","8" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:197   */

      /* Empieza nodo:199 / Elemento padre: 196   */
      v.add(doc.createElement("td"));
      ((Element)v.get(196)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(200)).setAttribute("nombre","lblGenerico" );
      ((Element)v.get(200)).setAttribute("alto","13" );
      ((Element)v.get(200)).setAttribute("filas","1" );
      ((Element)v.get(200)).setAttribute("valor","" );
      ((Element)v.get(200)).setAttribute("id","datosTitle" );
      ((Element)v.get(200)).setAttribute("cod","589" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:199   */

      /* Empieza nodo:201 / Elemento padre: 196   */
      v.add(doc.createElement("td"));
      ((Element)v.get(196)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(202)).setAttribute("src","b.gif" );
      ((Element)v.get(202)).setAttribute("width","25" );
      ((Element)v.get(202)).setAttribute("height","8" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:201   */

      /* Empieza nodo:203 / Elemento padre: 196   */
      v.add(doc.createElement("td"));
      ((Element)v.get(196)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(204)).setAttribute("nombre","lblExclusionTipoOferta" );
      ((Element)v.get(204)).setAttribute("alto","13" );
      ((Element)v.get(204)).setAttribute("filas","1" );
      ((Element)v.get(204)).setAttribute("valor","Exclusión tipo oferta" );
      ((Element)v.get(204)).setAttribute("id","datosTitle" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:203   */

      /* Empieza nodo:205 / Elemento padre: 196   */
      v.add(doc.createElement("td"));
      ((Element)v.get(205)).setAttribute("width","100%" );
      ((Element)v.get(205)).setAttribute("colspan","2" );
      ((Element)v.get(196)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(206)).setAttribute("src","b.gif" );
      ((Element)v.get(206)).setAttribute("width","8" );
      ((Element)v.get(206)).setAttribute("height","8" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:205   */
      /* Termina nodo:196   */

      /* Empieza nodo:207 / Elemento padre: 195   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(195)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("td"));
      ((Element)v.get(207)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(209)).setAttribute("src","b.gif" );
      ((Element)v.get(209)).setAttribute("width","8" );
      ((Element)v.get(209)).setAttribute("height","8" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */

      /* Empieza nodo:210 / Elemento padre: 207   */
      v.add(doc.createElement("td"));
      ((Element)v.get(210)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(207)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(211)).setAttribute("nombre","cbGenerico" );
      ((Element)v.get(211)).setAttribute("id","datosCampos" );
      ((Element)v.get(211)).setAttribute("size","1" );
      ((Element)v.get(211)).setAttribute("multiple","N" );
      ((Element)v.get(211)).setAttribute("req","N" );
      ((Element)v.get(211)).setAttribute("valorinicial","" );
      ((Element)v.get(211)).setAttribute("textoinicial","" );
      ((Element)v.get(211)).setAttribute("onchange","GenericoOnChange();" );
      ((Element)v.get(211)).setAttribute("ontab","ontabComboGenerico();" );
      ((Element)v.get(211)).setAttribute("onshtab","onshtabGenerico();" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(211)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */
      /* Termina nodo:211   */
      /* Termina nodo:210   */

      /* Empieza nodo:213 / Elemento padre: 207   */
      v.add(doc.createElement("td"));
      ((Element)v.get(207)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(214)).setAttribute("src","b.gif" );
      ((Element)v.get(214)).setAttribute("width","25" );
      ((Element)v.get(214)).setAttribute("height","8" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:213   */

      /* Empieza nodo:215 / Elemento padre: 207   */
      v.add(doc.createElement("td"));
      ((Element)v.get(207)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(216)).setAttribute("nombre","ExclusionTipoOferta" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(216)).setAttribute("id","datosCampos" );
      ((Element)v.get(216)).setAttribute("onclick","cambiaEstado();" );
      ((Element)v.get(216)).setAttribute("check","N" );
      ((Element)v.get(216)).setAttribute("onshtab","onshtabExclusionTipoOferta();" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */
      /* Termina nodo:215   */

      /* Empieza nodo:217 / Elemento padre: 207   */
      v.add(doc.createElement("td"));
      ((Element)v.get(217)).setAttribute("width","100%" );
      ((Element)v.get(207)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(218)).setAttribute("src","b.gif" );
      ((Element)v.get(218)).setAttribute("width","8" );
      ((Element)v.get(218)).setAttribute("height","8" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */
      /* Termina nodo:217   */
      /* Termina nodo:207   */

      /* Empieza nodo:219 / Elemento padre: 195   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(195)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("td"));
      ((Element)v.get(220)).setAttribute("colspan","4" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(221)).setAttribute("src","b.gif" );
      ((Element)v.get(221)).setAttribute("width","8" );
      ((Element)v.get(221)).setAttribute("height","8" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */
      /* Termina nodo:220   */
      /* Termina nodo:219   */
      /* Termina nodo:195   */
      /* Termina nodo:194   */
      /* Termina nodo:193   */

      /* Empieza nodo:222 / Elemento padre: 129   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(129)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("td"));
      ((Element)v.get(222)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("table"));
      ((Element)v.get(224)).setAttribute("width","575" );
      ((Element)v.get(224)).setAttribute("border","0" );
      ((Element)v.get(224)).setAttribute("align","left" );
      ((Element)v.get(224)).setAttribute("cellspacing","0" );
      ((Element)v.get(224)).setAttribute("cellpadding","0" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(224)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("td"));
      ((Element)v.get(225)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(227)).setAttribute("src","b.gif" );
      ((Element)v.get(227)).setAttribute("width","8" );
      ((Element)v.get(227)).setAttribute("height","8" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */
      /* Termina nodo:226   */

      /* Empieza nodo:228 / Elemento padre: 225   */
      v.add(doc.createElement("td"));
      ((Element)v.get(225)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(229)).setAttribute("nombre","lblTipoOferta" );
      ((Element)v.get(229)).setAttribute("alto","13" );
      ((Element)v.get(229)).setAttribute("filas","1" );
      ((Element)v.get(229)).setAttribute("valor","" );
      ((Element)v.get(229)).setAttribute("id","datosTitle" );
      ((Element)v.get(229)).setAttribute("cod","608" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */
      /* Termina nodo:228   */

      /* Empieza nodo:230 / Elemento padre: 225   */
      v.add(doc.createElement("td"));
      ((Element)v.get(225)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(231)).setAttribute("src","b.gif" );
      ((Element)v.get(231)).setAttribute("width","25" );
      ((Element)v.get(231)).setAttribute("height","8" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */
      /* Termina nodo:230   */

      /* Empieza nodo:232 / Elemento padre: 225   */
      v.add(doc.createElement("td"));
      ((Element)v.get(225)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(233)).setAttribute("nombre","lblCicloVida" );
      ((Element)v.get(233)).setAttribute("alto","13" );
      ((Element)v.get(233)).setAttribute("filas","1" );
      ((Element)v.get(233)).setAttribute("valor","" );
      ((Element)v.get(233)).setAttribute("id","datosTitle" );
      ((Element)v.get(233)).setAttribute("cod","581" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */
      /* Termina nodo:232   */

      /* Empieza nodo:234 / Elemento padre: 225   */
      v.add(doc.createElement("td"));
      ((Element)v.get(234)).setAttribute("width","100%" );
      ((Element)v.get(234)).setAttribute("colspan","2" );
      ((Element)v.get(225)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(235)).setAttribute("src","b.gif" );
      ((Element)v.get(235)).setAttribute("width","8" );
      ((Element)v.get(235)).setAttribute("height","8" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */
      /* Termina nodo:234   */
      /* Termina nodo:225   */

      /* Empieza nodo:236 / Elemento padre: 224   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(224)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("td"));
      ((Element)v.get(236)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(238)).setAttribute("src","b.gif" );
      ((Element)v.get(238)).setAttribute("width","8" );
      ((Element)v.get(238)).setAttribute("height","8" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */
      /* Termina nodo:237   */

      /* Empieza nodo:239 / Elemento padre: 236   */
      v.add(doc.createElement("td"));
      ((Element)v.get(239)).setAttribute("nowrap","nowrap" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(236)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(240)).setAttribute("nombre","cbTipoOferta" );
      ((Element)v.get(240)).setAttribute("id","datosCampos" );
      ((Element)v.get(240)).setAttribute("size","5" );
      ((Element)v.get(240)).setAttribute("multiple","S" );
      ((Element)v.get(240)).setAttribute("req","N" );
      ((Element)v.get(240)).setAttribute("valorinicial","" );
      ((Element)v.get(240)).setAttribute("textoinicial","" );
      ((Element)v.get(240)).setAttribute("onchange","TipoOfertaOnChange();" );
      ((Element)v.get(240)).setAttribute("onshtab","onshtabTipoOferta();" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(240)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */
      /* Termina nodo:240   */
      /* Termina nodo:239   */

      /* Empieza nodo:242 / Elemento padre: 236   */
      v.add(doc.createElement("td"));
      ((Element)v.get(236)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(243)).setAttribute("src","b.gif" );
      ((Element)v.get(243)).setAttribute("width","25" );
      ((Element)v.get(243)).setAttribute("height","8" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */
      /* Termina nodo:242   */

      /* Empieza nodo:244 / Elemento padre: 236   */
      v.add(doc.createElement("td"));
      ((Element)v.get(244)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(236)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(245)).setAttribute("nombre","cbCicloVida" );
      ((Element)v.get(245)).setAttribute("id","datosCampos" );
      ((Element)v.get(245)).setAttribute("size","5" );
      ((Element)v.get(245)).setAttribute("multiple","S" );
      ((Element)v.get(245)).setAttribute("req","S" );
      ((Element)v.get(245)).setAttribute("valorinicial","" );
      ((Element)v.get(245)).setAttribute("textoinicial","" );
      ((Element)v.get(245)).setAttribute("onchange","CicloVidaOnChange();" );
      ((Element)v.get(245)).setAttribute("ontab","focalizaBotonHTML('botonContenido','btnEliminar')" );
      ((Element)v.get(245)).setAttribute("onshtab","onshtabCicloVida();" );
      ((Element)v.get(244)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(245)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */
      /* Termina nodo:245   */
      /* Termina nodo:244   */

      /* Empieza nodo:247 / Elemento padre: 236   */
      v.add(doc.createElement("td"));
      ((Element)v.get(247)).setAttribute("width","100%" );
      ((Element)v.get(236)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(248)).setAttribute("src","b.gif" );
      ((Element)v.get(248)).setAttribute("width","8" );
      ((Element)v.get(248)).setAttribute("height","8" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */
      /* Termina nodo:247   */
      /* Termina nodo:236   */

      /* Empieza nodo:249 / Elemento padre: 224   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(224)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("td"));
      ((Element)v.get(250)).setAttribute("colspan","4" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(251)).setAttribute("src","b.gif" );
      ((Element)v.get(251)).setAttribute("width","8" );
      ((Element)v.get(251)).setAttribute("height","331" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */
      /* Termina nodo:250   */
      /* Termina nodo:249   */
      /* Termina nodo:224   */
      /* Termina nodo:223   */
      /* Termina nodo:222   */
      /* Termina nodo:129   */
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:252 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(253)).setAttribute("src","b.gif" );
      ((Element)v.get(253)).setAttribute("width","8" );
      ((Element)v.get(253)).setAttribute("height","12" );
      ((Element)v.get(252)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */
      /* Termina nodo:252   */
      /* Termina nodo:122   */

      /* Empieza nodo:254 / Elemento padre: 114   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(114)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("td"));
      ((Element)v.get(254)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(256)).setAttribute("src","b.gif" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */
      /* Termina nodo:255   */

      /* Empieza nodo:257 / Elemento padre: 254   */
      v.add(doc.createElement("td"));
      ((Element)v.get(254)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(257)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("table"));
      ((Element)v.get(259)).setAttribute("width","100%" );
      ((Element)v.get(259)).setAttribute("border","0" );
      ((Element)v.get(259)).setAttribute("align","center" );
      ((Element)v.get(259)).setAttribute("cellspacing","0" );
      ((Element)v.get(259)).setAttribute("cellpadding","0" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(259)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("td"));
      ((Element)v.get(261)).setAttribute("class","botonera" );
      ((Element)v.get(260)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(262)).setAttribute("nombre","btnAnadir" );
      ((Element)v.get(262)).setAttribute("ID","botonContenido" );
      ((Element)v.get(262)).setAttribute("tipo","html" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(262)).setAttribute("accion","accionAniadir();" );
      ((Element)v.get(262)).setAttribute("estado","false" );
      ((Element)v.get(262)).setAttribute("cod","404" );
      ((Element)v.get(262)).setAttribute("ontab","focalizaBotonHTML('botonContenido','btnEliminar2')" );
      ((Element)v.get(262)).setAttribute("onshtab","onShTabAnadir();" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */
      /* Termina nodo:261   */
      /* Termina nodo:260   */
      /* Termina nodo:259   */
      /* Termina nodo:258   */
      /* Termina nodo:257   */

      /* Empieza nodo:263 / Elemento padre: 254   */
      v.add(doc.createElement("td"));
      ((Element)v.get(254)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(264)).setAttribute("src","b.gif" );
      ((Element)v.get(263)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */
      /* Termina nodo:263   */
      /* Termina nodo:254   */

      /* Empieza nodo:265 / Elemento padre: 114   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(114)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("td"));
      ((Element)v.get(266)).setAttribute("width","12" );
      ((Element)v.get(266)).setAttribute("align","center" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(267)).setAttribute("src","b.gif" );
      ((Element)v.get(267)).setAttribute("width","12" );
      ((Element)v.get(267)).setAttribute("height","12" );
      ((Element)v.get(266)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */
      /* Termina nodo:266   */

      /* Empieza nodo:268 / Elemento padre: 265   */
      v.add(doc.createElement("td"));
      ((Element)v.get(268)).setAttribute("width","756" );
      ((Element)v.get(265)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(269)).setAttribute("src","b.gif" );
      ((Element)v.get(268)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */
      /* Termina nodo:268   */

      /* Empieza nodo:270 / Elemento padre: 265   */
      v.add(doc.createElement("td"));
      ((Element)v.get(270)).setAttribute("width","12" );
      ((Element)v.get(265)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(271)).setAttribute("src","b.gif" );
      ((Element)v.get(271)).setAttribute("width","12" );
      ((Element)v.get(271)).setAttribute("height","12" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */
      /* Termina nodo:270   */
      /* Termina nodo:265   */
      /* Termina nodo:114   */

      /* Empieza nodo:272 / Elemento padre: 15   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(272)).setAttribute("nombre","capa1" );
      ((Element)v.get(272)).setAttribute("alto","434" );
      ((Element)v.get(272)).setAttribute("ancho","100%" );
      ((Element)v.get(272)).setAttribute("colorf","" );
      ((Element)v.get(272)).setAttribute("borde","0" );
      ((Element)v.get(272)).setAttribute("imagenf","" );
      ((Element)v.get(272)).setAttribute("repeat","" );
      ((Element)v.get(272)).setAttribute("padding","" );
      ((Element)v.get(272)).setAttribute("visibilidad","visible" );
      ((Element)v.get(272)).setAttribute("contravsb","" );
      ((Element)v.get(272)).setAttribute("x","0" );
      ((Element)v.get(272)).setAttribute("y","934" );
      ((Element)v.get(272)).setAttribute("zindex","" );
      ((Element)v.get(15)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("table"));
      ((Element)v.get(273)).setAttribute("width","100%" );
      ((Element)v.get(273)).setAttribute("border","0" );
      ((Element)v.get(273)).setAttribute("cellspacing","0" );
      ((Element)v.get(273)).setAttribute("cellpadding","0" );
      ((Element)v.get(272)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(273)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
      v.add(doc.createElement("td"));
      ((Element)v.get(275)).setAttribute("width","12" );
      ((Element)v.get(275)).setAttribute("align","center" );
      ((Element)v.get(274)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(276)).setAttribute("src","b.gif" );
      ((Element)v.get(276)).setAttribute("width","12" );
      ((Element)v.get(276)).setAttribute("height","12" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */
      /* Termina nodo:275   */

      /* Empieza nodo:277 / Elemento padre: 274   */
      v.add(doc.createElement("td"));
      ((Element)v.get(277)).setAttribute("width","756" );
      ((Element)v.get(274)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(278)).setAttribute("src","b.gif" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */
      /* Termina nodo:277   */

      /* Empieza nodo:279 / Elemento padre: 274   */
      v.add(doc.createElement("td"));
      ((Element)v.get(279)).setAttribute("width","12" );
      ((Element)v.get(274)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(280)).setAttribute("src","b.gif" );
      ((Element)v.get(280)).setAttribute("width","12" );
      ((Element)v.get(280)).setAttribute("height","12" );
      ((Element)v.get(279)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */
      /* Termina nodo:279   */
      /* Termina nodo:274   */

      /* Empieza nodo:281 / Elemento padre: 273   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(273)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("td"));
      ((Element)v.get(281)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(283)).setAttribute("src","b.gif" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */
      /* Termina nodo:282   */

      /* Empieza nodo:284 / Elemento padre: 281   */
      v.add(doc.createElement("td"));
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(281)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(284)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(286)).setAttribute("class","legend" );
      ((Element)v.get(285)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(287)).setAttribute("nombre","lblEscalasDescuento" );
      ((Element)v.get(287)).setAttribute("alto","13" );
      ((Element)v.get(287)).setAttribute("filas","1" );
      ((Element)v.get(287)).setAttribute("valor","" );
      ((Element)v.get(287)).setAttribute("cod","00491" );
      ((Element)v.get(287)).setAttribute("id","legend" );
      ((Element)v.get(286)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */
      /* Termina nodo:286   */

      /* Empieza nodo:288 / Elemento padre: 285   */
      v.add(doc.createElement("table"));
      ((Element)v.get(288)).setAttribute("width","100%" );
      ((Element)v.get(288)).setAttribute("border","0" );
      ((Element)v.get(288)).setAttribute("align","center" );
      ((Element)v.get(288)).setAttribute("cellspacing","0" );
      ((Element)v.get(288)).setAttribute("cellpadding","0" );
      ((Element)v.get(285)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(288)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("td"));
      ((Element)v.get(289)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("table"));
      ((Element)v.get(291)).setAttribute("width","575" );
      ((Element)v.get(291)).setAttribute("border","0" );
      ((Element)v.get(291)).setAttribute("align","left" );
      ((Element)v.get(291)).setAttribute("cellspacing","0" );
      ((Element)v.get(291)).setAttribute("cellpadding","0" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(291)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("td"));
      ((Element)v.get(293)).setAttribute("colspan","4" );
      ((Element)v.get(292)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(294)).setAttribute("src","b.gif" );
      ((Element)v.get(294)).setAttribute("width","8" );
      ((Element)v.get(294)).setAttribute("height","8" );
      ((Element)v.get(293)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */
      /* Termina nodo:293   */
      /* Termina nodo:292   */

      /* Empieza nodo:295 / Elemento padre: 291   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(291)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("td"));
      ((Element)v.get(295)).appendChild((Element)v.get(296));

      /* Empieza nodo:297 / Elemento padre: 296   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(297)).setAttribute("src","b.gif" );
      ((Element)v.get(297)).setAttribute("width","8" );
      ((Element)v.get(297)).setAttribute("height","8" );
      ((Element)v.get(296)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */
      /* Termina nodo:296   */

      /* Empieza nodo:298 / Elemento padre: 295   */
      v.add(doc.createElement("td"));
      ((Element)v.get(295)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(299)).setAttribute("nombre","lblNumUnidadesObligatorias" );
      ((Element)v.get(299)).setAttribute("alto","13" );
      ((Element)v.get(299)).setAttribute("filas","1" );
      ((Element)v.get(299)).setAttribute("valor","" );
      ((Element)v.get(299)).setAttribute("id","datosTitle" );
      ((Element)v.get(299)).setAttribute("cod","941" );
      ((Element)v.get(298)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */
      /* Termina nodo:298   */

      /* Empieza nodo:300 / Elemento padre: 295   */
      v.add(doc.createElement("td"));
      ((Element)v.get(300)).setAttribute("width","100%" );
      ((Element)v.get(295)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(301)).setAttribute("src","b.gif" );
      ((Element)v.get(301)).setAttribute("width","8" );
      ((Element)v.get(301)).setAttribute("height","8" );
      ((Element)v.get(300)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */
      /* Termina nodo:300   */
      /* Termina nodo:295   */

      /* Empieza nodo:302 / Elemento padre: 291   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(291)).appendChild((Element)v.get(302));

      /* Empieza nodo:303 / Elemento padre: 302   */
      v.add(doc.createElement("td"));
      ((Element)v.get(302)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(304)).setAttribute("src","b.gif" );
      ((Element)v.get(304)).setAttribute("width","8" );
      ((Element)v.get(304)).setAttribute("height","8" );
      ((Element)v.get(303)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */
      /* Termina nodo:303   */

      /* Empieza nodo:305 / Elemento padre: 302   */
      v.add(doc.createElement("td"));
      ((Element)v.get(302)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(306)).setAttribute("nombre","txtNumUnidadesObligatorias" );
      ((Element)v.get(306)).setAttribute("id","datosCampos" );
      ((Element)v.get(306)).setAttribute("max","3" );
      ((Element)v.get(306)).setAttribute("tipo","" );
      ((Element)v.get(306)).setAttribute("onchange","" );
      ((Element)v.get(306)).setAttribute("req","N" );
      ((Element)v.get(306)).setAttribute("size","3" );
      ((Element)v.get(306)).setAttribute("valor","" );
      ((Element)v.get(306)).setAttribute("validacion","" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(306)).setAttribute("ontab","focalizaBotonHTML('botonContenido','btnEliminar3')" );
      ((Element)v.get(306)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnEliminar2')" );
      ((Element)v.get(305)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */
      /* Termina nodo:305   */

      /* Empieza nodo:307 / Elemento padre: 302   */
      v.add(doc.createElement("td"));
      ((Element)v.get(307)).setAttribute("width","100%" );
      ((Element)v.get(302)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(308)).setAttribute("src","b.gif" );
      ((Element)v.get(308)).setAttribute("width","8" );
      ((Element)v.get(308)).setAttribute("height","8" );
      ((Element)v.get(307)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */
      /* Termina nodo:307   */
      /* Termina nodo:302   */

      /* Empieza nodo:309 / Elemento padre: 291   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(291)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("td"));
      ((Element)v.get(309)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(311)).setAttribute("src","b.gif" );
      ((Element)v.get(311)).setAttribute("width","8" );
      ((Element)v.get(311)).setAttribute("height","330" );
      ((Element)v.get(310)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */
      /* Termina nodo:310   */
      /* Termina nodo:309   */
      /* Termina nodo:291   */
      /* Termina nodo:290   */
      /* Termina nodo:289   */
      /* Termina nodo:288   */
      /* Termina nodo:285   */
      /* Termina nodo:284   */

      /* Empieza nodo:312 / Elemento padre: 281   */
      v.add(doc.createElement("td"));
      ((Element)v.get(281)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(313)).setAttribute("src","b.gif" );
      ((Element)v.get(313)).setAttribute("width","8" );
      ((Element)v.get(313)).setAttribute("height","12" );
      ((Element)v.get(312)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */
      /* Termina nodo:312   */
      /* Termina nodo:281   */

      /* Empieza nodo:314 / Elemento padre: 273   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(273)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("td"));
      ((Element)v.get(314)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(316)).setAttribute("src","b.gif" );
      ((Element)v.get(315)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */
      /* Termina nodo:315   */

      /* Empieza nodo:317 / Elemento padre: 314   */
      v.add(doc.createElement("td"));
      ((Element)v.get(314)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(317)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
      v.add(doc.createElement("table"));
      ((Element)v.get(319)).setAttribute("width","100%" );
      ((Element)v.get(319)).setAttribute("border","0" );
      ((Element)v.get(319)).setAttribute("align","center" );
      ((Element)v.get(319)).setAttribute("cellspacing","0" );
      ((Element)v.get(319)).setAttribute("cellpadding","0" );
      ((Element)v.get(318)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(319)).appendChild((Element)v.get(320));

      /* Empieza nodo:321 / Elemento padre: 320   */
      v.add(doc.createElement("td"));
      ((Element)v.get(321)).setAttribute("class","botonera" );
      ((Element)v.get(320)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(322)).setAttribute("nombre","btnOtraBase" );
      ((Element)v.get(322)).setAttribute("ID","botonContenido" );
      ((Element)v.get(322)).setAttribute("tipo","html" );
      ((Element)v.get(322)).setAttribute("accion","accionOtraBase();" );
      ((Element)v.get(322)).setAttribute("estado","false" );
      ((Element)v.get(322)).setAttribute("cod","2368" );
      ((Element)v.get(322)).setAttribute("ontab","onTabOtraBase();" );
      ((Element)v.get(322)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnAnadir3')" );
      ((Element)v.get(321)).appendChild((Element)v.get(322));
      /* Termina nodo:322   */

      /* Empieza nodo:323 / Elemento padre: 321   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(323)).setAttribute("nombre","btnSiguiente" );
      ((Element)v.get(323)).setAttribute("ID","botonContenido" );
      ((Element)v.get(323)).setAttribute("tipo","html" );
      ((Element)v.get(323)).setAttribute("accion","accionSiguiente();" );
      ((Element)v.get(323)).setAttribute("estado","false" );
      ((Element)v.get(323)).setAttribute("cod","446" );
      ((Element)v.get(323)).setAttribute("ontab","onTabSiguiente();" );
      ((Element)v.get(323)).setAttribute("onshtab","onshtabBotonSiguiente();" );
      ((Element)v.get(321)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */
      /* Termina nodo:321   */
      /* Termina nodo:320   */
      /* Termina nodo:319   */
      /* Termina nodo:318   */
      /* Termina nodo:317   */

      /* Empieza nodo:324 / Elemento padre: 314   */
      v.add(doc.createElement("td"));
      ((Element)v.get(314)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(325)).setAttribute("src","b.gif" );
      ((Element)v.get(325)).setAttribute("width","8" );
      ((Element)v.get(325)).setAttribute("height","12" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */
      /* Termina nodo:324   */
      /* Termina nodo:314   */

      /* Empieza nodo:326 / Elemento padre: 273   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(273)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
      v.add(doc.createElement("td"));
      ((Element)v.get(327)).setAttribute("width","12" );
      ((Element)v.get(327)).setAttribute("align","center" );
      ((Element)v.get(326)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(328)).setAttribute("src","b.gif" );
      ((Element)v.get(328)).setAttribute("width","12" );
      ((Element)v.get(328)).setAttribute("height","12" );
      ((Element)v.get(327)).appendChild((Element)v.get(328));
      /* Termina nodo:328   */
      /* Termina nodo:327   */

      /* Empieza nodo:329 / Elemento padre: 326   */
      v.add(doc.createElement("td"));
      ((Element)v.get(329)).setAttribute("width","756" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(326)).appendChild((Element)v.get(329));

      /* Empieza nodo:330 / Elemento padre: 329   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(330)).setAttribute("src","b.gif" );
      ((Element)v.get(329)).appendChild((Element)v.get(330));
      /* Termina nodo:330   */
      /* Termina nodo:329   */

      /* Empieza nodo:331 / Elemento padre: 326   */
      v.add(doc.createElement("td"));
      ((Element)v.get(331)).setAttribute("width","12" );
      ((Element)v.get(326)).appendChild((Element)v.get(331));

      /* Empieza nodo:332 / Elemento padre: 331   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(332)).setAttribute("src","b.gif" );
      ((Element)v.get(332)).setAttribute("width","12" );
      ((Element)v.get(332)).setAttribute("height","12" );
      ((Element)v.get(331)).appendChild((Element)v.get(332));
      /* Termina nodo:332   */
      /* Termina nodo:331   */
      /* Termina nodo:326   */
      /* Termina nodo:273   */
      /* Termina nodo:272   */

      /* Empieza nodo:333 / Elemento padre: 15   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(333)).setAttribute("nombre","listado1" );
      ((Element)v.get(333)).setAttribute("ancho","555" );
      ((Element)v.get(333)).setAttribute("alto","301" );
      ((Element)v.get(333)).setAttribute("x","24" );
      ((Element)v.get(333)).setAttribute("y","261" );
      ((Element)v.get(333)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(333)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(15)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(334)).setAttribute("precarga","S" );
      ((Element)v.get(334)).setAttribute("conROver","S" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));

      /* Empieza nodo:335 / Elemento padre: 334   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(335)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(335)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(335)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(335)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(334)).appendChild((Element)v.get(335));
      /* Termina nodo:335   */

      /* Empieza nodo:336 / Elemento padre: 334   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(336)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(336)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(336)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(336)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(334)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */

      /* Empieza nodo:337 / Elemento padre: 334   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(337)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(337)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(334)).appendChild((Element)v.get(337));
      /* Termina nodo:337   */
      /* Termina nodo:334   */

      /* Empieza nodo:338 / Elemento padre: 333   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(333)).appendChild((Element)v.get(338));

      /* Empieza nodo:339 / Elemento padre: 338   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(339)).setAttribute("borde","1" );
      ((Element)v.get(339)).setAttribute("horizDatos","1" );
      ((Element)v.get(339)).setAttribute("horizCabecera","1" );
      ((Element)v.get(339)).setAttribute("vertical","0" );
      ((Element)v.get(339)).setAttribute("horizTitulo","1" );
      ((Element)v.get(339)).setAttribute("horizBase","1" );
      ((Element)v.get(338)).appendChild((Element)v.get(339));
      /* Termina nodo:339   */

      /* Empieza nodo:340 / Elemento padre: 338   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(340)).setAttribute("borde","#999999" );
      ((Element)v.get(340)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(340)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(340)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(340)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(340)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(340)).setAttribute("horizBase","#999999" );
      ((Element)v.get(338)).appendChild((Element)v.get(340));
      /* Termina nodo:340   */
      /* Termina nodo:338   */

      /* Empieza nodo:341 / Elemento padre: 333   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(341)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(341)).setAttribute("alto","22" );
      ((Element)v.get(341)).setAttribute("imgFondo","" );
      ((Element)v.get(341)).setAttribute("cod","515" );
      ((Element)v.get(341)).setAttribute("ID","datosTitle" );
      ((Element)v.get(333)).appendChild((Element)v.get(341));
      /* Termina nodo:341   */

      /* Empieza nodo:342 / Elemento padre: 333   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(342)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(342)).setAttribute("alto","22" );
      ((Element)v.get(342)).setAttribute("imgFondo","" );
      ((Element)v.get(333)).appendChild((Element)v.get(342));
      /* Termina nodo:342   */

      /* Empieza nodo:343 / Elemento padre: 333   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(343)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(343)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(343)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(343)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(343)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(343)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(333)).appendChild((Element)v.get(343));

      /* Empieza nodo:344 / Elemento padre: 343   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(344)).setAttribute("ancho","20" );
      ((Element)v.get(344)).setAttribute("minimizable","S" );
      ((Element)v.get(344)).setAttribute("minimizada","N" );
      ((Element)v.get(343)).appendChild((Element)v.get(344));
      /* Termina nodo:344   */

      /* Empieza nodo:345 / Elemento padre: 343   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(345)).setAttribute("ancho","40" );
      ((Element)v.get(345)).setAttribute("minimizable","S" );
      ((Element)v.get(345)).setAttribute("minimizada","N" );
      ((Element)v.get(345)).setAttribute("orden","alfanumerico" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(343)).appendChild((Element)v.get(345));
      /* Termina nodo:345   */
      /* Termina nodo:343   */

      /* Empieza nodo:346 / Elemento padre: 333   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(346)).setAttribute("alto","20" );
      ((Element)v.get(346)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(346)).setAttribute("imgFondo","" );
      ((Element)v.get(346)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(333)).appendChild((Element)v.get(346));

      /* Empieza nodo:347 / Elemento padre: 346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(347)).setAttribute("colFondo","" );
      ((Element)v.get(347)).setAttribute("ID","EstCab" );
      ((Element)v.get(347)).setAttribute("align","center" );
      ((Element)v.get(347)).setAttribute("cod","337" );
      ((Element)v.get(346)).appendChild((Element)v.get(347));

      /* Elemento padre:347 / Elemento actual: 348   */
      v.add(doc.createTextNode("Código producto"));
      ((Element)v.get(347)).appendChild((Text)v.get(348));

      /* Termina nodo Texto:348   */
      /* Termina nodo:347   */

      /* Empieza nodo:349 / Elemento padre: 346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(349)).setAttribute("colFondo","" );
      ((Element)v.get(349)).setAttribute("ID","EstCab" );
      ((Element)v.get(349)).setAttribute("cod","338" );
      ((Element)v.get(346)).appendChild((Element)v.get(349));

      /* Elemento padre:349 / Elemento actual: 350   */
      v.add(doc.createTextNode("Descripción producto"));
      ((Element)v.get(349)).appendChild((Text)v.get(350));

      /* Termina nodo Texto:350   */
      /* Termina nodo:349   */
      /* Termina nodo:346   */

      /* Empieza nodo:351 / Elemento padre: 333   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(351)).setAttribute("alto","22" );
      ((Element)v.get(351)).setAttribute("accion","" );
      ((Element)v.get(351)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(351)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(351)).setAttribute("maxSel","-1" );
      ((Element)v.get(351)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(351)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(351)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(351)).setAttribute("onLoad","" );
      ((Element)v.get(351)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(333)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(352)).setAttribute("tipo","texto" );
      ((Element)v.get(352)).setAttribute("ID","EstDat" );
      ((Element)v.get(351)).appendChild((Element)v.get(352));
      /* Termina nodo:352   */

      /* Empieza nodo:353 / Elemento padre: 351   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(353)).setAttribute("tipo","texto" );
      ((Element)v.get(353)).setAttribute("ID","EstDat2" );
      ((Element)v.get(351)).appendChild((Element)v.get(353));
      /* Termina nodo:353   */
      /* Termina nodo:351   */

      /* Empieza nodo:354 / Elemento padre: 333   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(333)).appendChild((Element)v.get(354));
      /* Termina nodo:354   */

      /* Empieza nodo:355 / Elemento padre: 333   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(355)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(355)).setAttribute("ancho","555" );
      ((Element)v.get(355)).setAttribute("sep","$" );
      ((Element)v.get(355)).setAttribute("x","24" );
      ((Element)v.get(355)).setAttribute("class","botonera" );
      ((Element)v.get(355)).setAttribute("y","519" );
      ((Element)v.get(355)).setAttribute("control","|" );
      ((Element)v.get(355)).setAttribute("conector","" );
      ((Element)v.get(355)).setAttribute("rowset","" );
      ((Element)v.get(355)).setAttribute("cargainicial","N" );
      ((Element)v.get(333)).appendChild((Element)v.get(355));

      /* Empieza nodo:356 / Elemento padre: 355   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(356)).setAttribute("nombre","ret1" );
      ((Element)v.get(356)).setAttribute("x","49" );
      ((Element)v.get(356)).setAttribute("y","543" );
      ((Element)v.get(356)).setAttribute("ID","botonContenido" );
      ((Element)v.get(356)).setAttribute("img","retroceder_on" );
      ((Element)v.get(356)).setAttribute("tipo","0" );
      ((Element)v.get(356)).setAttribute("estado","false" );
      ((Element)v.get(356)).setAttribute("alt","" );
      ((Element)v.get(356)).setAttribute("codigo","" );
      ((Element)v.get(356)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(355)).appendChild((Element)v.get(356));
      /* Termina nodo:356   */

      /* Empieza nodo:357 / Elemento padre: 355   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(357)).setAttribute("nombre","ava1" );
      ((Element)v.get(357)).setAttribute("x","64" );
      ((Element)v.get(357)).setAttribute("y","543" );
      ((Element)v.get(357)).setAttribute("ID","botonContenido" );
      ((Element)v.get(357)).setAttribute("img","avanzar_on" );
      ((Element)v.get(357)).setAttribute("tipo","0" );
      ((Element)v.get(357)).setAttribute("estado","false" );
      ((Element)v.get(357)).setAttribute("alt","" );
      ((Element)v.get(357)).setAttribute("codigo","" );
      ((Element)v.get(357)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(355)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */
      /* Termina nodo:355   */
      /* Termina nodo:333   */

      /* Empieza nodo:358 / Elemento padre: 15   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(358)).setAttribute("nombre","primera1" );
      ((Element)v.get(358)).setAttribute("x","32" );
      ((Element)v.get(358)).setAttribute("y","543" );
      ((Element)v.get(358)).setAttribute("ID","botonContenido" );
      ((Element)v.get(358)).setAttribute("img","primera_on" );
      ((Element)v.get(358)).setAttribute("tipo","1" );
      ((Element)v.get(358)).setAttribute("estado","false" );
      ((Element)v.get(358)).setAttribute("alt","" );
      ((Element)v.get(358)).setAttribute("codigo","" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(358)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(15)).appendChild((Element)v.get(358));
      /* Termina nodo:358   */

      /* Empieza nodo:359 / Elemento padre: 15   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(359)).setAttribute("nombre","separa" );
      ((Element)v.get(359)).setAttribute("x","71" );
      ((Element)v.get(359)).setAttribute("y","539" );
      ((Element)v.get(359)).setAttribute("ID","botonContenido" );
      ((Element)v.get(359)).setAttribute("img","separa_base" );
      ((Element)v.get(359)).setAttribute("tipo","0" );
      ((Element)v.get(359)).setAttribute("estado","false" );
      ((Element)v.get(359)).setAttribute("alt","" );
      ((Element)v.get(359)).setAttribute("codigo","" );
      ((Element)v.get(359)).setAttribute("accion","" );
      ((Element)v.get(15)).appendChild((Element)v.get(359));
      /* Termina nodo:359   */

      /* Empieza nodo:360 / Elemento padre: 15   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(360)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(360)).setAttribute("x","79" );
      ((Element)v.get(360)).setAttribute("y","540" );
      ((Element)v.get(360)).setAttribute("ID","botonContenido" );
      ((Element)v.get(360)).setAttribute("tipo","html" );
      ((Element)v.get(360)).setAttribute("estado","false" );
      ((Element)v.get(360)).setAttribute("cod","445" );
      ((Element)v.get(360)).setAttribute("accion","accionBuscarProductos();" );
      ((Element)v.get(360)).setAttribute("ontab","focalizaBotonHTML('botonContenido','btnAnadir')" );
      ((Element)v.get(360)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnEliminar')" );
      ((Element)v.get(15)).appendChild((Element)v.get(360));
      /* Termina nodo:360   */

      /* Empieza nodo:361 / Elemento padre: 15   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(361)).setAttribute("nombre","btnEliminar" );
      ((Element)v.get(361)).setAttribute("x","25" );
      ((Element)v.get(361)).setAttribute("y","540" );
      ((Element)v.get(361)).setAttribute("ID","botonContenido" );
      ((Element)v.get(361)).setAttribute("tipo","html" );
      ((Element)v.get(361)).setAttribute("estado","false" );
      ((Element)v.get(361)).setAttribute("cod","1254" );
      ((Element)v.get(361)).setAttribute("accion","accionEliminar(1);" );
      ((Element)v.get(361)).setAttribute("ontab","onTabEliminar();" );
      ((Element)v.get(361)).setAttribute("onshtab","focaliza('formulario.cbCicloVida')" );
      ((Element)v.get(15)).appendChild((Element)v.get(361));
      /* Termina nodo:361   */

      /* Empieza nodo:362 / Elemento padre: 15   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(362)).setAttribute("nombre","listado2" );
      ((Element)v.get(362)).setAttribute("ancho","579" );
      ((Element)v.get(362)).setAttribute("alto","317" );
      ((Element)v.get(362)).setAttribute("x","12" );
      ((Element)v.get(362)).setAttribute("y","611" );
      ((Element)v.get(362)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(362)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(15)).appendChild((Element)v.get(362));

      /* Empieza nodo:363 / Elemento padre: 362   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(363)).setAttribute("precarga","S" );
      ((Element)v.get(363)).setAttribute("conROver","S" );
      ((Element)v.get(362)).appendChild((Element)v.get(363));

      /* Empieza nodo:364 / Elemento padre: 363   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(364)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(364)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(364)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(364)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(363)).appendChild((Element)v.get(364));
      /* Termina nodo:364   */

      /* Empieza nodo:365 / Elemento padre: 363   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(365)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(365)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(365)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(365)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(363)).appendChild((Element)v.get(365));
      /* Termina nodo:365   */

      /* Empieza nodo:366 / Elemento padre: 363   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(366)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(366)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(363)).appendChild((Element)v.get(366));
      /* Termina nodo:366   */
      /* Termina nodo:363   */

      /* Empieza nodo:367 / Elemento padre: 362   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(362)).appendChild((Element)v.get(367));

      /* Empieza nodo:368 / Elemento padre: 367   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(368)).setAttribute("borde","1" );
      ((Element)v.get(368)).setAttribute("horizDatos","1" );
      ((Element)v.get(368)).setAttribute("horizCabecera","1" );
      ((Element)v.get(368)).setAttribute("vertical","0" );
      ((Element)v.get(368)).setAttribute("horizTitulo","1" );
      ((Element)v.get(368)).setAttribute("horizBase","1" );
      ((Element)v.get(367)).appendChild((Element)v.get(368));
      /* Termina nodo:368   */

      /* Empieza nodo:369 / Elemento padre: 367   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(369)).setAttribute("borde","#999999" );
      ((Element)v.get(369)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(369)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(369)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(369)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(369)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(369)).setAttribute("horizBase","#999999" );
      ((Element)v.get(367)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */
      /* Termina nodo:367   */

      /* Empieza nodo:370 / Elemento padre: 362   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(370)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(370)).setAttribute("alto","22" );
      ((Element)v.get(370)).setAttribute("imgFondo","" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(370)).setAttribute("ID","datosTitle" );
      ((Element)v.get(370)).setAttribute("cod","00579" );
      ((Element)v.get(362)).appendChild((Element)v.get(370));
      /* Termina nodo:370   */

      /* Empieza nodo:371 / Elemento padre: 362   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(371)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(371)).setAttribute("alto","22" );
      ((Element)v.get(371)).setAttribute("imgFondo","" );
      ((Element)v.get(362)).appendChild((Element)v.get(371));
      /* Termina nodo:371   */

      /* Empieza nodo:372 / Elemento padre: 362   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(372)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(372)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(372)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(372)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(372)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(372)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(362)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(373)).setAttribute("ancho","30" );
      ((Element)v.get(373)).setAttribute("minimizable","S" );
      ((Element)v.get(373)).setAttribute("minimizada","N" );
      ((Element)v.get(373)).setAttribute("oculta","S" );
      ((Element)v.get(372)).appendChild((Element)v.get(373));
      /* Termina nodo:373   */

      /* Empieza nodo:374 / Elemento padre: 372   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(374)).setAttribute("ancho","50" );
      ((Element)v.get(374)).setAttribute("minimizable","S" );
      ((Element)v.get(374)).setAttribute("minimizada","N" );
      ((Element)v.get(372)).appendChild((Element)v.get(374));
      /* Termina nodo:374   */

      /* Empieza nodo:375 / Elemento padre: 372   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(375)).setAttribute("ancho","30" );
      ((Element)v.get(375)).setAttribute("minimizable","S" );
      ((Element)v.get(375)).setAttribute("minimizada","N" );
      ((Element)v.get(375)).setAttribute("oculta","S" );
      ((Element)v.get(372)).appendChild((Element)v.get(375));
      /* Termina nodo:375   */

      /* Empieza nodo:376 / Elemento padre: 372   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(376)).setAttribute("ancho","100" );
      ((Element)v.get(376)).setAttribute("minimizable","S" );
      ((Element)v.get(376)).setAttribute("minimizada","N" );
      ((Element)v.get(372)).appendChild((Element)v.get(376));
      /* Termina nodo:376   */

      /* Empieza nodo:377 / Elemento padre: 372   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(377)).setAttribute("ancho","30" );
      ((Element)v.get(377)).setAttribute("minimizable","S" );
      ((Element)v.get(377)).setAttribute("minimizada","N" );
      ((Element)v.get(377)).setAttribute("oculta","S" );
      ((Element)v.get(372)).appendChild((Element)v.get(377));
      /* Termina nodo:377   */

      /* Empieza nodo:378 / Elemento padre: 372   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(378)).setAttribute("ancho","50" );
      ((Element)v.get(378)).setAttribute("minimizable","S" );
      ((Element)v.get(378)).setAttribute("minimizada","N" );
      ((Element)v.get(372)).appendChild((Element)v.get(378));
      /* Termina nodo:378   */

      /* Empieza nodo:379 / Elemento padre: 372   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(379)).setAttribute("ancho","30" );
      ((Element)v.get(379)).setAttribute("minimizable","S" );
      ((Element)v.get(379)).setAttribute("minimizada","N" );
      ((Element)v.get(379)).setAttribute("oculta","S" );
      ((Element)v.get(372)).appendChild((Element)v.get(379));
      /* Termina nodo:379   */

      /* Empieza nodo:380 / Elemento padre: 372   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(380)).setAttribute("ancho","80" );
      ((Element)v.get(380)).setAttribute("minimizable","S" );
      ((Element)v.get(380)).setAttribute("minimizada","N" );
      ((Element)v.get(372)).appendChild((Element)v.get(380));
      /* Termina nodo:380   */

      /* Empieza nodo:381 / Elemento padre: 372   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(381)).setAttribute("ancho","30" );
      ((Element)v.get(381)).setAttribute("minimizable","S" );
      ((Element)v.get(381)).setAttribute("minimizada","N" );
      ((Element)v.get(381)).setAttribute("oculta","S" );
      ((Element)v.get(372)).appendChild((Element)v.get(381));
      /* Termina nodo:381   */

      /* Empieza nodo:382 / Elemento padre: 372   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(382)).setAttribute("ancho","50" );
      ((Element)v.get(382)).setAttribute("minimizable","S" );
      ((Element)v.get(382)).setAttribute("minimizada","N" );
      ((Element)v.get(372)).appendChild((Element)v.get(382));
      /* Termina nodo:382   */

      /* Empieza nodo:383 / Elemento padre: 372   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(383)).setAttribute("ancho","120" );
      ((Element)v.get(383)).setAttribute("minimizable","S" );
      ((Element)v.get(383)).setAttribute("minimizada","N" );
      ((Element)v.get(372)).appendChild((Element)v.get(383));
      /* Termina nodo:383   */

      /* Empieza nodo:384 / Elemento padre: 372   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(384)).setAttribute("ancho","30" );
      ((Element)v.get(384)).setAttribute("minimizable","S" );
      ((Element)v.get(384)).setAttribute("minimizada","N" );
      ((Element)v.get(384)).setAttribute("oculta","S" );
      ((Element)v.get(372)).appendChild((Element)v.get(384));
      /* Termina nodo:384   */

      /* Empieza nodo:385 / Elemento padre: 372   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(385)).setAttribute("ancho","100" );
      ((Element)v.get(385)).setAttribute("minimizable","S" );
      ((Element)v.get(385)).setAttribute("minimizada","N" );
      ((Element)v.get(372)).appendChild((Element)v.get(385));
      /* Termina nodo:385   */

      /* Empieza nodo:386 / Elemento padre: 372   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(386)).setAttribute("ancho","30" );
      ((Element)v.get(386)).setAttribute("minimizable","S" );
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(386)).setAttribute("minimizada","N" );
      ((Element)v.get(386)).setAttribute("oculta","S" );
      ((Element)v.get(372)).appendChild((Element)v.get(386));
      /* Termina nodo:386   */

      /* Empieza nodo:387 / Elemento padre: 372   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(387)).setAttribute("ancho","100" );
      ((Element)v.get(387)).setAttribute("minimizable","S" );
      ((Element)v.get(387)).setAttribute("minimizada","N" );
      ((Element)v.get(372)).appendChild((Element)v.get(387));
      /* Termina nodo:387   */

      /* Empieza nodo:388 / Elemento padre: 372   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(388)).setAttribute("ancho","30" );
      ((Element)v.get(388)).setAttribute("minimizable","S" );
      ((Element)v.get(388)).setAttribute("minimizada","N" );
      ((Element)v.get(388)).setAttribute("oculta","S" );
      ((Element)v.get(372)).appendChild((Element)v.get(388));
      /* Termina nodo:388   */

      /* Empieza nodo:389 / Elemento padre: 372   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(389)).setAttribute("ancho","80" );
      ((Element)v.get(389)).setAttribute("minimizable","S" );
      ((Element)v.get(389)).setAttribute("minimizada","N" );
      ((Element)v.get(372)).appendChild((Element)v.get(389));
      /* Termina nodo:389   */
      /* Termina nodo:372   */

      /* Empieza nodo:390 / Elemento padre: 362   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(390)).setAttribute("alto","20" );
      ((Element)v.get(390)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(390)).setAttribute("imgFondo","" );
      ((Element)v.get(390)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(362)).appendChild((Element)v.get(390));

      /* Empieza nodo:391 / Elemento padre: 390   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(391)).setAttribute("colFondo","" );
      ((Element)v.get(391)).setAttribute("ID","EstCab" );
      ((Element)v.get(390)).appendChild((Element)v.get(391));

      /* Elemento padre:391 / Elemento actual: 392   */
      v.add(doc.createTextNode("oidMarca"));
      ((Element)v.get(391)).appendChild((Text)v.get(392));

      /* Termina nodo Texto:392   */
      /* Termina nodo:391   */

      /* Empieza nodo:393 / Elemento padre: 390   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(393)).setAttribute("colFondo","" );
      ((Element)v.get(393)).setAttribute("ID","EstCab" );
      ((Element)v.get(393)).setAttribute("cod","6" );
      ((Element)v.get(390)).appendChild((Element)v.get(393));

      /* Elemento padre:393 / Elemento actual: 394   */
      v.add(doc.createTextNode("Marca"));
      ((Element)v.get(393)).appendChild((Text)v.get(394));

      /* Termina nodo Texto:394   */
      /* Termina nodo:393   */

      /* Empieza nodo:395 / Elemento padre: 390   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(395)).setAttribute("colFondo","" );
      ((Element)v.get(395)).setAttribute("ID","EstCab" );
      ((Element)v.get(390)).appendChild((Element)v.get(395));

      /* Elemento padre:395 / Elemento actual: 396   */
      v.add(doc.createTextNode("oidUnidadNegocio"));
      ((Element)v.get(395)).appendChild((Text)v.get(396));

      /* Termina nodo Texto:396   */
      /* Termina nodo:395   */

      /* Empieza nodo:397 / Elemento padre: 390   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(397)).setAttribute("colFondo","" );
      ((Element)v.get(397)).setAttribute("ID","EstCab" );
      ((Element)v.get(397)).setAttribute("cod","587" );
      ((Element)v.get(390)).appendChild((Element)v.get(397));

      /* Elemento padre:397 / Elemento actual: 398   */
      v.add(doc.createTextNode("Unidad negocio"));
      ((Element)v.get(397)).appendChild((Text)v.get(398));

      /* Termina nodo Texto:398   */
      /* Termina nodo:397   */

      /* Empieza nodo:399 / Elemento padre: 390   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(399)).setAttribute("colFondo","" );
      ((Element)v.get(399)).setAttribute("ID","EstCab" );
      ((Element)v.get(390)).appendChild((Element)v.get(399));

      /* Elemento padre:399 / Elemento actual: 400   */
      v.add(doc.createTextNode("oidNegocio"));
      ((Element)v.get(399)).appendChild((Text)v.get(400));

      /* Termina nodo Texto:400   */
      /* Termina nodo:399   */

      /* Empieza nodo:401 / Elemento padre: 390   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(401)).setAttribute("colFondo","" );
      ((Element)v.get(401)).setAttribute("ID","EstCab" );
      ((Element)v.get(401)).setAttribute("cod","588" );
      ((Element)v.get(390)).appendChild((Element)v.get(401));

      /* Elemento padre:401 / Elemento actual: 402   */
      v.add(doc.createTextNode("Negocio"));
      ((Element)v.get(401)).appendChild((Text)v.get(402));

      /* Termina nodo Texto:402   */
      /* Termina nodo:401   */

      /* Empieza nodo:403 / Elemento padre: 390   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(403)).setAttribute("colFondo","" );
      ((Element)v.get(403)).setAttribute("ID","EstCab" );
      ((Element)v.get(390)).appendChild((Element)v.get(403));

      /* Elemento padre:403 / Elemento actual: 404   */
      v.add(doc.createTextNode("oidSupergenerico"));
      ((Element)v.get(403)).appendChild((Text)v.get(404));

      /* Termina nodo Texto:404   */
      /* Termina nodo:403   */

      /* Empieza nodo:405 / Elemento padre: 390   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(405)).setAttribute("colFondo","" );
      ((Element)v.get(405)).setAttribute("ID","EstCab" );
      ((Element)v.get(405)).setAttribute("cod","590" );
      ((Element)v.get(390)).appendChild((Element)v.get(405));

      /* Elemento padre:405 / Elemento actual: 406   */
      v.add(doc.createTextNode("Supergenérico"));
      ((Element)v.get(405)).appendChild((Text)v.get(406));

      /* Termina nodo Texto:406   */
      /* Termina nodo:405   */

      /* Empieza nodo:407 / Elemento padre: 390   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(407)).setAttribute("colFondo","" );
      ((Element)v.get(407)).setAttribute("ID","EstCab" );
      ((Element)v.get(390)).appendChild((Element)v.get(407));

      /* Elemento padre:407 / Elemento actual: 408   */
      v.add(doc.createTextNode("oidGenerico"));
      ((Element)v.get(407)).appendChild((Text)v.get(408));

      /* Termina nodo Texto:408   */
      /* Termina nodo:407   */

      /* Empieza nodo:409 / Elemento padre: 390   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(409)).setAttribute("colFondo","" );
      ((Element)v.get(409)).setAttribute("ID","EstCab" );
      ((Element)v.get(409)).setAttribute("cod","589" );
      ((Element)v.get(390)).appendChild((Element)v.get(409));

      /* Elemento padre:409 / Elemento actual: 410   */
      v.add(doc.createTextNode("Genérico"));
      ((Element)v.get(409)).appendChild((Text)v.get(410));

      /* Termina nodo Texto:410   */
      /* Termina nodo:409   */

      /* Empieza nodo:411 / Elemento padre: 390   */
   }

   private void getXML1800(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(411)).setAttribute("colFondo","" );
      ((Element)v.get(411)).setAttribute("ID","EstCab" );
      ((Element)v.get(411)).setAttribute("cod","2371" );
      ((Element)v.get(390)).appendChild((Element)v.get(411));

      /* Elemento padre:411 / Elemento actual: 412   */
      v.add(doc.createTextNode("Exclusión tipo oferta"));
      ((Element)v.get(411)).appendChild((Text)v.get(412));

      /* Termina nodo Texto:412   */
      /* Termina nodo:411   */

      /* Empieza nodo:413 / Elemento padre: 390   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(413)).setAttribute("colFondo","" );
      ((Element)v.get(413)).setAttribute("ID","EstCab" );
      ((Element)v.get(390)).appendChild((Element)v.get(413));

      /* Elemento padre:413 / Elemento actual: 414   */
      v.add(doc.createTextNode("oidTipoOferta"));
      ((Element)v.get(413)).appendChild((Text)v.get(414));

      /* Termina nodo Texto:414   */
      /* Termina nodo:413   */

      /* Empieza nodo:415 / Elemento padre: 390   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(415)).setAttribute("colFondo","" );
      ((Element)v.get(415)).setAttribute("ID","EstCab" );
      ((Element)v.get(415)).setAttribute("cod","608" );
      ((Element)v.get(390)).appendChild((Element)v.get(415));

      /* Elemento padre:415 / Elemento actual: 416   */
      v.add(doc.createTextNode("Tipo oferta"));
      ((Element)v.get(415)).appendChild((Text)v.get(416));

      /* Termina nodo Texto:416   */
      /* Termina nodo:415   */

      /* Empieza nodo:417 / Elemento padre: 390   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(417)).setAttribute("colFondo","" );
      ((Element)v.get(417)).setAttribute("ID","EstCab" );
      ((Element)v.get(390)).appendChild((Element)v.get(417));

      /* Elemento padre:417 / Elemento actual: 418   */
      v.add(doc.createTextNode("oidCicloVida"));
      ((Element)v.get(417)).appendChild((Text)v.get(418));

      /* Termina nodo Texto:418   */
      /* Termina nodo:417   */

      /* Empieza nodo:419 / Elemento padre: 390   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(419)).setAttribute("colFondo","" );
      ((Element)v.get(419)).setAttribute("ID","EstCab" );
      ((Element)v.get(419)).setAttribute("cod","581" );
      ((Element)v.get(390)).appendChild((Element)v.get(419));

      /* Elemento padre:419 / Elemento actual: 420   */
      v.add(doc.createTextNode("Ciclo vida"));
      ((Element)v.get(419)).appendChild((Text)v.get(420));

      /* Termina nodo Texto:420   */
      /* Termina nodo:419   */

      /* Empieza nodo:421 / Elemento padre: 390   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(421)).setAttribute("colFondo","" );
      ((Element)v.get(421)).setAttribute("ID","EstCab" );
      ((Element)v.get(390)).appendChild((Element)v.get(421));

      /* Elemento padre:421 / Elemento actual: 422   */
      v.add(doc.createTextNode("oidProducto"));
      ((Element)v.get(421)).appendChild((Text)v.get(422));

      /* Termina nodo Texto:422   */
      /* Termina nodo:421   */

      /* Empieza nodo:423 / Elemento padre: 390   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(423)).setAttribute("colFondo","" );
      ((Element)v.get(423)).setAttribute("ID","EstCab" );
      ((Element)v.get(423)).setAttribute("cod","574" );
      ((Element)v.get(390)).appendChild((Element)v.get(423));

      /* Elemento padre:423 / Elemento actual: 424   */
      v.add(doc.createTextNode("Producto"));
      ((Element)v.get(423)).appendChild((Text)v.get(424));

      /* Termina nodo Texto:424   */
      /* Termina nodo:423   */
      /* Termina nodo:390   */

      /* Empieza nodo:425 / Elemento padre: 362   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(425)).setAttribute("alto","22" );
      ((Element)v.get(425)).setAttribute("accion","" );
      ((Element)v.get(425)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(425)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(425)).setAttribute("maxSel","-1" );
      ((Element)v.get(425)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(425)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(425)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(425)).setAttribute("onLoad","" );
      ((Element)v.get(425)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(362)).appendChild((Element)v.get(425));

      /* Empieza nodo:426 / Elemento padre: 425   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(426)).setAttribute("tipo","texto" );
      ((Element)v.get(426)).setAttribute("ID","EstDat" );
      ((Element)v.get(425)).appendChild((Element)v.get(426));
      /* Termina nodo:426   */

      /* Empieza nodo:427 / Elemento padre: 425   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(427)).setAttribute("tipo","texto" );
      ((Element)v.get(427)).setAttribute("ID","EstDat" );
      ((Element)v.get(425)).appendChild((Element)v.get(427));
      /* Termina nodo:427   */

      /* Empieza nodo:428 / Elemento padre: 425   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(428)).setAttribute("tipo","texto" );
      ((Element)v.get(428)).setAttribute("ID","EstDat2" );
      ((Element)v.get(425)).appendChild((Element)v.get(428));
      /* Termina nodo:428   */

      /* Empieza nodo:429 / Elemento padre: 425   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(429)).setAttribute("tipo","texto" );
      ((Element)v.get(429)).setAttribute("ID","EstDat2" );
      ((Element)v.get(425)).appendChild((Element)v.get(429));
      /* Termina nodo:429   */

      /* Empieza nodo:430 / Elemento padre: 425   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(430)).setAttribute("tipo","texto" );
      ((Element)v.get(430)).setAttribute("ID","EstDat" );
      ((Element)v.get(425)).appendChild((Element)v.get(430));
      /* Termina nodo:430   */

      /* Empieza nodo:431 / Elemento padre: 425   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(431)).setAttribute("tipo","texto" );
      ((Element)v.get(431)).setAttribute("ID","EstDat" );
      ((Element)v.get(425)).appendChild((Element)v.get(431));
      /* Termina nodo:431   */

      /* Empieza nodo:432 / Elemento padre: 425   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(432)).setAttribute("tipo","texto" );
      ((Element)v.get(432)).setAttribute("ID","EstDat2" );
      ((Element)v.get(425)).appendChild((Element)v.get(432));
      /* Termina nodo:432   */

      /* Empieza nodo:433 / Elemento padre: 425   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(433)).setAttribute("tipo","texto" );
      ((Element)v.get(433)).setAttribute("ID","EstDat2" );
      ((Element)v.get(425)).appendChild((Element)v.get(433));
      /* Termina nodo:433   */

      /* Empieza nodo:434 / Elemento padre: 425   */
   }

   private void getXML1890(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(434)).setAttribute("tipo","texto" );
      ((Element)v.get(434)).setAttribute("ID","EstDat" );
      ((Element)v.get(425)).appendChild((Element)v.get(434));
      /* Termina nodo:434   */

      /* Empieza nodo:435 / Elemento padre: 425   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(435)).setAttribute("tipo","texto" );
      ((Element)v.get(435)).setAttribute("ID","EstDat" );
      ((Element)v.get(425)).appendChild((Element)v.get(435));
      /* Termina nodo:435   */

      /* Empieza nodo:436 / Elemento padre: 425   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(436)).setAttribute("tipo","texto" );
      ((Element)v.get(436)).setAttribute("ID","EstDat2" );
      ((Element)v.get(425)).appendChild((Element)v.get(436));
      /* Termina nodo:436   */

      /* Empieza nodo:437 / Elemento padre: 425   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(437)).setAttribute("tipo","texto" );
      ((Element)v.get(437)).setAttribute("ID","EstDat2" );
      ((Element)v.get(425)).appendChild((Element)v.get(437));
      /* Termina nodo:437   */

      /* Empieza nodo:438 / Elemento padre: 425   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(438)).setAttribute("tipo","texto" );
      ((Element)v.get(438)).setAttribute("ID","EstDat" );
      ((Element)v.get(425)).appendChild((Element)v.get(438));
      /* Termina nodo:438   */

      /* Empieza nodo:439 / Elemento padre: 425   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(439)).setAttribute("tipo","texto" );
      ((Element)v.get(439)).setAttribute("ID","EstDat" );
      ((Element)v.get(425)).appendChild((Element)v.get(439));
      /* Termina nodo:439   */

      /* Empieza nodo:440 / Elemento padre: 425   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(440)).setAttribute("tipo","texto" );
      ((Element)v.get(440)).setAttribute("ID","EstDat2" );
      ((Element)v.get(425)).appendChild((Element)v.get(440));
      /* Termina nodo:440   */

      /* Empieza nodo:441 / Elemento padre: 425   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(441)).setAttribute("tipo","texto" );
      ((Element)v.get(441)).setAttribute("ID","EstDat2" );
      ((Element)v.get(425)).appendChild((Element)v.get(441));
      /* Termina nodo:441   */

      /* Empieza nodo:442 / Elemento padre: 425   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(442)).setAttribute("tipo","texto" );
      ((Element)v.get(442)).setAttribute("ID","EstDat" );
      ((Element)v.get(425)).appendChild((Element)v.get(442));
      /* Termina nodo:442   */
      /* Termina nodo:425   */

      /* Empieza nodo:443 / Elemento padre: 362   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(362)).appendChild((Element)v.get(443));
      /* Termina nodo:443   */

      /* Empieza nodo:444 / Elemento padre: 362   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(444)).setAttribute("nombre","mipgndo2" );
      ((Element)v.get(444)).setAttribute("ancho","579" );
      ((Element)v.get(444)).setAttribute("sep","$" );
      ((Element)v.get(444)).setAttribute("x","12" );
      ((Element)v.get(444)).setAttribute("class","botonera" );
      ((Element)v.get(444)).setAttribute("y","905" );
      ((Element)v.get(444)).setAttribute("control","|" );
      ((Element)v.get(444)).setAttribute("conector","" );
      ((Element)v.get(444)).setAttribute("rowset","" );
      ((Element)v.get(444)).setAttribute("cargainicial","N" );
      ((Element)v.get(362)).appendChild((Element)v.get(444));

      /* Empieza nodo:445 / Elemento padre: 444   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(445)).setAttribute("nombre","ret2" );
      ((Element)v.get(445)).setAttribute("x","37" );
      ((Element)v.get(445)).setAttribute("y","909" );
      ((Element)v.get(445)).setAttribute("ID","botonContenido" );
      ((Element)v.get(445)).setAttribute("img","retroceder_on" );
      ((Element)v.get(445)).setAttribute("tipo","0" );
      ((Element)v.get(445)).setAttribute("estado","false" );
      ((Element)v.get(445)).setAttribute("alt","" );
      ((Element)v.get(445)).setAttribute("codigo","" );
      ((Element)v.get(445)).setAttribute("accion","mipgndo2.retroceder();" );
      ((Element)v.get(444)).appendChild((Element)v.get(445));
      /* Termina nodo:445   */

      /* Empieza nodo:446 / Elemento padre: 444   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(446)).setAttribute("nombre","ava2" );
      ((Element)v.get(446)).setAttribute("x","52" );
      ((Element)v.get(446)).setAttribute("y","909" );
      ((Element)v.get(446)).setAttribute("ID","botonContenido" );
      ((Element)v.get(446)).setAttribute("img","avanzar_on" );
      ((Element)v.get(446)).setAttribute("tipo","0" );
      ((Element)v.get(446)).setAttribute("estado","false" );
      ((Element)v.get(446)).setAttribute("alt","" );
      ((Element)v.get(446)).setAttribute("codigo","" );
      ((Element)v.get(446)).setAttribute("accion","mipgndo2.avanzar();" );
      ((Element)v.get(444)).appendChild((Element)v.get(446));
      /* Termina nodo:446   */
      /* Termina nodo:444   */
      /* Termina nodo:362   */

      /* Empieza nodo:447 / Elemento padre: 15   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(447)).setAttribute("nombre","primera2" );
      ((Element)v.get(447)).setAttribute("x","20" );
      ((Element)v.get(447)).setAttribute("y","909" );
      ((Element)v.get(447)).setAttribute("ID","botonContenido" );
      ((Element)v.get(447)).setAttribute("img","primera_on" );
      ((Element)v.get(447)).setAttribute("tipo","1" );
      ((Element)v.get(447)).setAttribute("estado","false" );
      ((Element)v.get(447)).setAttribute("alt","" );
      ((Element)v.get(447)).setAttribute("codigo","" );
      ((Element)v.get(447)).setAttribute("accion","mipgndo2.retrocederPrimeraPagina();" );
      ((Element)v.get(15)).appendChild((Element)v.get(447));
      /* Termina nodo:447   */

      /* Empieza nodo:448 / Elemento padre: 15   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(448)).setAttribute("nombre","separa2" );
      ((Element)v.get(448)).setAttribute("x","59" );
      ((Element)v.get(448)).setAttribute("y","905" );
   }

   private void getXML1980(Document doc) {
      ((Element)v.get(448)).setAttribute("ID","botonContenido" );
      ((Element)v.get(448)).setAttribute("img","separa_base" );
      ((Element)v.get(448)).setAttribute("tipo","0" );
      ((Element)v.get(448)).setAttribute("estado","false" );
      ((Element)v.get(448)).setAttribute("alt","" );
      ((Element)v.get(448)).setAttribute("codigo","" );
      ((Element)v.get(448)).setAttribute("accion","" );
      ((Element)v.get(15)).appendChild((Element)v.get(448));
      /* Termina nodo:448   */

      /* Empieza nodo:449 / Elemento padre: 15   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(449)).setAttribute("nombre","btnEliminar2" );
      ((Element)v.get(449)).setAttribute("x","13" );
      ((Element)v.get(449)).setAttribute("y","906" );
      ((Element)v.get(449)).setAttribute("ID","botonContenido" );
      ((Element)v.get(449)).setAttribute("tipo","html" );
      ((Element)v.get(449)).setAttribute("estado","false" );
      ((Element)v.get(449)).setAttribute("cod","1254" );
      ((Element)v.get(449)).setAttribute("accion","accionEliminar(2)" );
      ((Element)v.get(449)).setAttribute("ontab","focaliza('formulario.txtNumUnidadesObligatorias')" );
      ((Element)v.get(449)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnAnadir')" );
      ((Element)v.get(15)).appendChild((Element)v.get(449));
      /* Termina nodo:449   */

      /* Empieza nodo:450 / Elemento padre: 15   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(450)).setAttribute("nombre","listado3" );
      ((Element)v.get(450)).setAttribute("ancho","555" );
      ((Element)v.get(450)).setAttribute("alto","301" );
      ((Element)v.get(450)).setAttribute("x","24" );
      ((Element)v.get(450)).setAttribute("y","1009" );
      ((Element)v.get(450)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(450)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(15)).appendChild((Element)v.get(450));

      /* Empieza nodo:451 / Elemento padre: 450   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(451)).setAttribute("precarga","S" );
      ((Element)v.get(451)).setAttribute("conROver","S" );
      ((Element)v.get(450)).appendChild((Element)v.get(451));

      /* Empieza nodo:452 / Elemento padre: 451   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(452)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(452)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(452)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(452)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(451)).appendChild((Element)v.get(452));
      /* Termina nodo:452   */

      /* Empieza nodo:453 / Elemento padre: 451   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(453)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(453)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(453)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(453)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(451)).appendChild((Element)v.get(453));
      /* Termina nodo:453   */

      /* Empieza nodo:454 / Elemento padre: 451   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(454)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(454)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(451)).appendChild((Element)v.get(454));
      /* Termina nodo:454   */
      /* Termina nodo:451   */

      /* Empieza nodo:455 / Elemento padre: 450   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(450)).appendChild((Element)v.get(455));

      /* Empieza nodo:456 / Elemento padre: 455   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(456)).setAttribute("borde","1" );
      ((Element)v.get(456)).setAttribute("horizDatos","1" );
      ((Element)v.get(456)).setAttribute("horizCabecera","1" );
      ((Element)v.get(456)).setAttribute("vertical","0" );
      ((Element)v.get(456)).setAttribute("horizTitulo","1" );
      ((Element)v.get(456)).setAttribute("horizBase","1" );
      ((Element)v.get(455)).appendChild((Element)v.get(456));
      /* Termina nodo:456   */

      /* Empieza nodo:457 / Elemento padre: 455   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(457)).setAttribute("borde","#999999" );
      ((Element)v.get(457)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(457)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(457)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(457)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(457)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(457)).setAttribute("horizBase","#999999" );
      ((Element)v.get(455)).appendChild((Element)v.get(457));
      /* Termina nodo:457   */
      /* Termina nodo:455   */

      /* Empieza nodo:458 / Elemento padre: 450   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(458)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(458)).setAttribute("alto","22" );
      ((Element)v.get(458)).setAttribute("imgFondo","" );
      ((Element)v.get(458)).setAttribute("cod","0098" );
      ((Element)v.get(458)).setAttribute("ID","datosTitle" );
      ((Element)v.get(450)).appendChild((Element)v.get(458));
      /* Termina nodo:458   */

      /* Empieza nodo:459 / Elemento padre: 450   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(459)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(459)).setAttribute("alto","22" );
      ((Element)v.get(459)).setAttribute("imgFondo","" );
      ((Element)v.get(450)).appendChild((Element)v.get(459));
      /* Termina nodo:459   */

      /* Empieza nodo:460 / Elemento padre: 450   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(460)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(460)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(460)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(460)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(460)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(460)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(450)).appendChild((Element)v.get(460));

      /* Empieza nodo:461 / Elemento padre: 460   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(461)).setAttribute("ancho","100" );
   }

   private void getXML2070(Document doc) {
      ((Element)v.get(461)).setAttribute("minimizable","S" );
      ((Element)v.get(461)).setAttribute("minimizada","N" );
      ((Element)v.get(460)).appendChild((Element)v.get(461));
      /* Termina nodo:461   */

      /* Empieza nodo:462 / Elemento padre: 460   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(462)).setAttribute("ancho","100" );
      ((Element)v.get(462)).setAttribute("minimizable","S" );
      ((Element)v.get(462)).setAttribute("minimizada","N" );
      ((Element)v.get(460)).appendChild((Element)v.get(462));
      /* Termina nodo:462   */

      /* Empieza nodo:463 / Elemento padre: 460   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(463)).setAttribute("ancho","100" );
      ((Element)v.get(463)).setAttribute("minimizable","S" );
      ((Element)v.get(463)).setAttribute("minimizada","N" );
      ((Element)v.get(460)).appendChild((Element)v.get(463));
      /* Termina nodo:463   */

      /* Empieza nodo:464 / Elemento padre: 460   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(464)).setAttribute("ancho","100" );
      ((Element)v.get(464)).setAttribute("minimizable","S" );
      ((Element)v.get(464)).setAttribute("oculta","S" );
      ((Element)v.get(460)).appendChild((Element)v.get(464));
      /* Termina nodo:464   */
      /* Termina nodo:460   */

      /* Empieza nodo:465 / Elemento padre: 450   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(465)).setAttribute("alto","20" );
      ((Element)v.get(465)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(465)).setAttribute("imgFondo","" );
      ((Element)v.get(465)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(450)).appendChild((Element)v.get(465));

      /* Empieza nodo:466 / Elemento padre: 465   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(466)).setAttribute("colFondo","" );
      ((Element)v.get(466)).setAttribute("ID","EstCab" );
      ((Element)v.get(466)).setAttribute("align","center" );
      ((Element)v.get(466)).setAttribute("cod","860" );
      ((Element)v.get(465)).appendChild((Element)v.get(466));
      /* Termina nodo:466   */

      /* Empieza nodo:467 / Elemento padre: 465   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(467)).setAttribute("colFondo","" );
      ((Element)v.get(467)).setAttribute("ID","EstCab" );
      ((Element)v.get(467)).setAttribute("cod","1303" );
      ((Element)v.get(465)).appendChild((Element)v.get(467));
      /* Termina nodo:467   */

      /* Empieza nodo:468 / Elemento padre: 465   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(468)).setAttribute("colFondo","" );
      ((Element)v.get(468)).setAttribute("ID","EstCab" );
      ((Element)v.get(468)).setAttribute("cod","971" );
      ((Element)v.get(465)).appendChild((Element)v.get(468));
      /* Termina nodo:468   */
      /* Termina nodo:465   */

      /* Empieza nodo:469 / Elemento padre: 450   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(469)).setAttribute("alto","22" );
      ((Element)v.get(469)).setAttribute("accion","" );
      ((Element)v.get(469)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(469)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(469)).setAttribute("maxSel","-1" );
      ((Element)v.get(469)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(469)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(469)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(469)).setAttribute("onLoad","" );
      ((Element)v.get(469)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(450)).appendChild((Element)v.get(469));

      /* Empieza nodo:470 / Elemento padre: 469   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(470)).setAttribute("tipo","texto" );
      ((Element)v.get(470)).setAttribute("ID","EstDat" );
      ((Element)v.get(469)).appendChild((Element)v.get(470));
      /* Termina nodo:470   */

      /* Empieza nodo:471 / Elemento padre: 469   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(471)).setAttribute("tipo","texto" );
      ((Element)v.get(471)).setAttribute("ID","EstDat2" );
      ((Element)v.get(469)).appendChild((Element)v.get(471));
      /* Termina nodo:471   */

      /* Empieza nodo:472 / Elemento padre: 469   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(472)).setAttribute("tipo","texto" );
      ((Element)v.get(472)).setAttribute("ID","EstDat" );
      ((Element)v.get(469)).appendChild((Element)v.get(472));
      /* Termina nodo:472   */

      /* Empieza nodo:473 / Elemento padre: 469   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(473)).setAttribute("tipo","texto" );
      ((Element)v.get(473)).setAttribute("ID","EstDat2" );
      ((Element)v.get(469)).appendChild((Element)v.get(473));
      /* Termina nodo:473   */
      /* Termina nodo:469   */

      /* Empieza nodo:474 / Elemento padre: 450   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(450)).appendChild((Element)v.get(474));
      /* Termina nodo:474   */

      /* Empieza nodo:475 / Elemento padre: 450   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(475)).setAttribute("nombre","mipgndo3" );
      ((Element)v.get(475)).setAttribute("ancho","726" );
      ((Element)v.get(475)).setAttribute("sep","$" );
      ((Element)v.get(475)).setAttribute("x","12" );
      ((Element)v.get(475)).setAttribute("class","botonera" );
      ((Element)v.get(475)).setAttribute("y","1287" );
      ((Element)v.get(475)).setAttribute("control","|" );
      ((Element)v.get(475)).setAttribute("conector","" );
      ((Element)v.get(475)).setAttribute("rowset","" );
      ((Element)v.get(475)).setAttribute("cargainicial","N" );
      ((Element)v.get(450)).appendChild((Element)v.get(475));

      /* Empieza nodo:476 / Elemento padre: 475   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(476)).setAttribute("nombre","ret3" );
      ((Element)v.get(476)).setAttribute("x","49" );
      ((Element)v.get(476)).setAttribute("y","1291" );
      ((Element)v.get(476)).setAttribute("ID","botonContenido" );
      ((Element)v.get(476)).setAttribute("img","retroceder_on" );
      ((Element)v.get(476)).setAttribute("tipo","0" );
      ((Element)v.get(476)).setAttribute("estado","false" );
   }

   private void getXML2160(Document doc) {
      ((Element)v.get(476)).setAttribute("alt","" );
      ((Element)v.get(476)).setAttribute("codigo","" );
      ((Element)v.get(476)).setAttribute("accion","mipgndo3.retroceder();" );
      ((Element)v.get(475)).appendChild((Element)v.get(476));
      /* Termina nodo:476   */

      /* Empieza nodo:477 / Elemento padre: 475   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(477)).setAttribute("nombre","ava3" );
      ((Element)v.get(477)).setAttribute("x","64" );
      ((Element)v.get(477)).setAttribute("y","1291" );
      ((Element)v.get(477)).setAttribute("ID","botonContenido" );
      ((Element)v.get(477)).setAttribute("img","avanzar_on" );
      ((Element)v.get(477)).setAttribute("tipo","0" );
      ((Element)v.get(477)).setAttribute("estado","false" );
      ((Element)v.get(477)).setAttribute("alt","" );
      ((Element)v.get(477)).setAttribute("codigo","" );
      ((Element)v.get(477)).setAttribute("accion","mipgndo3.avanzar();" );
      ((Element)v.get(475)).appendChild((Element)v.get(477));
      /* Termina nodo:477   */
      /* Termina nodo:475   */
      /* Termina nodo:450   */

      /* Empieza nodo:478 / Elemento padre: 15   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(478)).setAttribute("nombre","primera3" );
      ((Element)v.get(478)).setAttribute("x","32" );
      ((Element)v.get(478)).setAttribute("y","1291" );
      ((Element)v.get(478)).setAttribute("ID","botonContenido" );
      ((Element)v.get(478)).setAttribute("img","primera_on" );
      ((Element)v.get(478)).setAttribute("tipo","1" );
      ((Element)v.get(478)).setAttribute("estado","false" );
      ((Element)v.get(478)).setAttribute("alt","" );
      ((Element)v.get(478)).setAttribute("codigo","" );
      ((Element)v.get(478)).setAttribute("accion","mipgndo3.retrocederPrimeraPagina();" );
      ((Element)v.get(15)).appendChild((Element)v.get(478));
      /* Termina nodo:478   */

      /* Empieza nodo:479 / Elemento padre: 15   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(479)).setAttribute("nombre","separa3" );
      ((Element)v.get(479)).setAttribute("x","71" );
      ((Element)v.get(479)).setAttribute("y","1287" );
      ((Element)v.get(479)).setAttribute("ID","botonContenido" );
      ((Element)v.get(479)).setAttribute("img","separa_base" );
      ((Element)v.get(479)).setAttribute("tipo","0" );
      ((Element)v.get(479)).setAttribute("estado","false" );
      ((Element)v.get(479)).setAttribute("alt","" );
      ((Element)v.get(479)).setAttribute("codigo","" );
      ((Element)v.get(479)).setAttribute("accion","" );
      ((Element)v.get(15)).appendChild((Element)v.get(479));
      /* Termina nodo:479   */

      /* Empieza nodo:480 / Elemento padre: 15   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(480)).setAttribute("nombre","btnAnadir3" );
      ((Element)v.get(480)).setAttribute("x","79" );
      ((Element)v.get(480)).setAttribute("y","1288" );
      ((Element)v.get(480)).setAttribute("ID","botonContenido" );
      ((Element)v.get(480)).setAttribute("tipo","html" );
      ((Element)v.get(480)).setAttribute("estado","false" );
      ((Element)v.get(480)).setAttribute("cod","404" );
      ((Element)v.get(480)).setAttribute("accion","accionAnadirEscala();" );
      ((Element)v.get(480)).setAttribute("ontab","focalizaBotonHTML('botonContenido','btnOtraBase')" );
      ((Element)v.get(480)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnEliminar3')" );
      ((Element)v.get(15)).appendChild((Element)v.get(480));
      /* Termina nodo:480   */

      /* Empieza nodo:481 / Elemento padre: 15   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(481)).setAttribute("nombre","btnEliminar3" );
      ((Element)v.get(481)).setAttribute("x","25" );
      ((Element)v.get(481)).setAttribute("y","1288" );
      ((Element)v.get(481)).setAttribute("ID","botonContenido" );
      ((Element)v.get(481)).setAttribute("tipo","html" );
      ((Element)v.get(481)).setAttribute("estado","false" );
      ((Element)v.get(481)).setAttribute("cod","1254" );
      ((Element)v.get(481)).setAttribute("accion","accionEliminar2();" );
      ((Element)v.get(481)).setAttribute("ontab","focalizaBotonHTML('botonContenido','btnAnadir3')" );
      ((Element)v.get(481)).setAttribute("onshtab","focaliza('formulario.txtNumUnidadesObligatorias')" );
      ((Element)v.get(15)).appendChild((Element)v.get(481));
      /* Termina nodo:481   */
      /* Termina nodo:15   */


   }

}
