
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_flete_insertar  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_flete_insertar" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("titulo","Insertar flete" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Insertar flete" );
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
      ((Element)v.get(4)).setAttribute("src","i18NJS.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(5)).setAttribute("src","ConstantesJS.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(6)).setAttribute("src","UtilidadesFlete.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(7)).setAttribute("src","contenido_flete_insertar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(8));

      /* Empieza nodo:9 / Elemento padre: 8   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(8)).appendChild((Element)v.get(9));

      /* Empieza nodo:10 / Elemento padre: 9   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","cbMarca" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("cod","6" );
      ((Element)v.get(9)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 9   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","cbCanal" );
      ((Element)v.get(11)).setAttribute("required","true" );
      ((Element)v.get(11)).setAttribute("cod","7" );
      ((Element)v.get(9)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 9   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","cbZona" );
      ((Element)v.get(12)).setAttribute("required","false" );
      ((Element)v.get(12)).setAttribute("cod","143" );
      ((Element)v.get(9)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 9   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(13)).setAttribute("name","txtUbigeo" );
      ((Element)v.get(13)).setAttribute("required","false" );
      ((Element)v.get(13)).setAttribute("cod","135" );
      ((Element)v.get(9)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 9   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(14)).setAttribute("name","cbTipoDespacho" );
      ((Element)v.get(14)).setAttribute("required","true" );
      ((Element)v.get(14)).setAttribute("cod","1000" );
      ((Element)v.get(9)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 9   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(15)).setAttribute("name","txtDescripcion" );
      ((Element)v.get(15)).setAttribute("required","true" );
      ((Element)v.get(15)).setAttribute("cod","9" );
      ((Element)v.get(9)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 9   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(16)).setAttribute("name","txtMontoFijo" );
      ((Element)v.get(16)).setAttribute("required","false" );
      ((Element)v.get(16)).setAttribute("min","0" );
      ((Element)v.get(16)).setAttribute("max","9999999999.99" );
      ((Element)v.get(16)).setAttribute("format","n" );
      ((Element)v.get(16)).setAttribute("cod","1414" );
      ((Element)v.get(9)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 9   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(17)).setAttribute("name","txtTasa" );
      ((Element)v.get(17)).setAttribute("required","false" );
      ((Element)v.get(17)).setAttribute("min","0" );
      ((Element)v.get(17)).setAttribute("max","99.99" );
      ((Element)v.get(17)).setAttribute("format","n" );
      ((Element)v.get(17)).setAttribute("cod","1415" );
      ((Element)v.get(9)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 9   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(18)).setAttribute("name","txtFleteMin" );
      ((Element)v.get(18)).setAttribute("required","false" );
      ((Element)v.get(18)).setAttribute("min","0" );
      ((Element)v.get(18)).setAttribute("max","9999999999.99" );
      ((Element)v.get(18)).setAttribute("format","n" );
      ((Element)v.get(18)).setAttribute("cod","2177" );
      ((Element)v.get(9)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 9   */
      v.add(doc.createElement("ELEMENTO"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(19)).setAttribute("name","txtFleteMax" );
      ((Element)v.get(19)).setAttribute("required","false" );
      ((Element)v.get(19)).setAttribute("min","0" );
      ((Element)v.get(19)).setAttribute("max","9999999999.99" );
      ((Element)v.get(19)).setAttribute("format","n" );
      ((Element)v.get(19)).setAttribute("cod","2178" );
      ((Element)v.get(9)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 9   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(20)).setAttribute("name","txtContraEntrega" );
      ((Element)v.get(20)).setAttribute("required","false" );
      ((Element)v.get(20)).setAttribute("min","0" );
      ((Element)v.get(20)).setAttribute("max","9999999999.99" );
      ((Element)v.get(20)).setAttribute("format","n" );
      ((Element)v.get(20)).setAttribute("cod","1418" );
      ((Element)v.get(9)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 9   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(21)).setAttribute("name","cbTipoCliente" );
      ((Element)v.get(21)).setAttribute("required","true" );
      ((Element)v.get(21)).setAttribute("cod","1869" );
      ((Element)v.get(9)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */
      /* Termina nodo:9   */
      /* Termina nodo:8   */

      /* Empieza nodo:22 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(22)).setAttribute("nombre","formulario" );
      ((Element)v.get(22)).setAttribute("oculto","S" );
      ((Element)v.get(0)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","accion" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","varOid" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","Oids" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","seleccion" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","OIDMarca" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","OIDCanal" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","OIDZona" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","OIDUbigeo" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","OIDDespacho" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","OIDTipoCliente" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","OIDSubTipoCliente" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","OIDTipoClasificacion" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","OIDClasificacion" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","subModi" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","tipClas" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","clsi" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","OIDUbige" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","ubigeo" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","descrip" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","montoF" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","tas" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","fmin" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","fmax" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","contraE" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(51)).setAttribute("nombre","esCargaInicial" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(52)).setAttribute("nombre","hPais" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(53)).setAttribute("nombre","hIdioma" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(54)).setAttribute("nombre","marca" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(55)).setAttribute("nombre","canal" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(56)).setAttribute("nombre","zona" );
      ((Element)v.get(56)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(57)).setAttribute("nombre","marca2" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(58)).setAttribute("nombre","canal2" );
      ((Element)v.get(58)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */

      /* Empieza nodo:59 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(59)).setAttribute("nombre","TipoDespacho" );
      ((Element)v.get(59)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */

      /* Empieza nodo:60 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(60)).setAttribute("nombre","TipoCliente" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */

      /* Empieza nodo:61 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(61)).setAttribute("nombre","marcaDescr" );
      ((Element)v.get(61)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */

      /* Empieza nodo:62 / Elemento padre: 22   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(62)).setAttribute("nombre","canalDescr" );
      ((Element)v.get(62)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */

      /* Empieza nodo:63 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(63)).setAttribute("nombre","zonaDescr" );
      ((Element)v.get(63)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */

      /* Empieza nodo:64 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(64)).setAttribute("nombre","despachoDescr" );
      ((Element)v.get(64)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */

      /* Empieza nodo:65 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(65)).setAttribute("nombre","tipoClienteDescr" );
      ((Element)v.get(65)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */

      /* Empieza nodo:66 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(66)).setAttribute("nombre","subTipoClienteDescr" );
      ((Element)v.get(66)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */

      /* Empieza nodo:67 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(67)).setAttribute("nombre","tipoClasiDescr" );
      ((Element)v.get(67)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */

      /* Empieza nodo:68 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(68)).setAttribute("nombre","clasiDescr" );
      ((Element)v.get(68)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */

      /* Empieza nodo:69 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(69)).setAttribute("nombre","SubTipoCliente" );
      ((Element)v.get(69)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */

      /* Empieza nodo:70 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(70)).setAttribute("nombre","OIDTipoClasificacion" );
      ((Element)v.get(70)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */

      /* Empieza nodo:71 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(71)).setAttribute("nombre","TipoClasificacion" );
      ((Element)v.get(71)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */

      /* Empieza nodo:72 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(72)).setAttribute("nombre","OIDClasificacion" );
      ((Element)v.get(72)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */

      /* Empieza nodo:73 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(73)).setAttribute("nombre","Clasificacion" );
      ((Element)v.get(73)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */

      /* Empieza nodo:74 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(74)).setAttribute("nombre","hVisibleZona" );
      ((Element)v.get(74)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */

      /* Empieza nodo:75 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(75)).setAttribute("nombre","hTxtUbigeo" );
      ((Element)v.get(75)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */

      /* Empieza nodo:76 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(76)).setAttribute("nombre","hFormatoDef" );
      ((Element)v.get(76)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */

      /* Empieza nodo:77 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(77)).setAttribute("nombre","hSepMiles" );
      ((Element)v.get(77)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */

      /* Empieza nodo:78 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(78)).setAttribute("nombre","hSepDec" );
      ((Element)v.get(78)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */

      /* Empieza nodo:79 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(79)).setAttribute("nombre","hSDetalleFlete" );
      ((Element)v.get(79)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */

      /* Empieza nodo:80 / Elemento padre: 22   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(80)).setAttribute("nombre","hOidFlete" );
      ((Element)v.get(80)).setAttribute("valor","" );
      ((Element)v.get(22)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */

      /* Empieza nodo:81 / Elemento padre: 22   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(81)).setAttribute("nombre","capa1" );
      ((Element)v.get(22)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("table"));
      ((Element)v.get(82)).setAttribute("width","100%" );
      ((Element)v.get(82)).setAttribute("border","0" );
      ((Element)v.get(82)).setAttribute("cellspacing","0" );
      ((Element)v.get(82)).setAttribute("cellpadding","0" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(82)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).setAttribute("width","12" );
      ((Element)v.get(84)).setAttribute("align","center" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(85)).setAttribute("src","b.gif" );
      ((Element)v.get(85)).setAttribute("width","12" );
      ((Element)v.get(85)).setAttribute("height","12" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */

      /* Empieza nodo:86 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(86)).setAttribute("width","750" );
      ((Element)v.get(83)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(87)).setAttribute("src","b.gif" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:88 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).setAttribute("width","12" );
      ((Element)v.get(83)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(89)).setAttribute("src","b.gif" );
      ((Element)v.get(89)).setAttribute("width","12" );
      ((Element)v.get(89)).setAttribute("height","1" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */
      /* Termina nodo:83   */

      /* Empieza nodo:90 / Elemento padre: 82   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(82)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(92)).setAttribute("src","b.gif" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:93 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(95)).setAttribute("class","legend" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(96)).setAttribute("nombre","lblDatosFlete" );
      ((Element)v.get(96)).setAttribute("filas","1" );
      ((Element)v.get(96)).setAttribute("cod","00181" );
      ((Element)v.get(96)).setAttribute("id","legend" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */

      /* Empieza nodo:97 / Elemento padre: 94   */
      v.add(doc.createElement("table"));
      ((Element)v.get(97)).setAttribute("width","100%" );
      ((Element)v.get(97)).setAttribute("border","0" );
      ((Element)v.get(97)).setAttribute("align","center" );
      ((Element)v.get(97)).setAttribute("cellspacing","0" );
      ((Element)v.get(97)).setAttribute("cellpadding","0" );
      ((Element)v.get(94)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("table"));
      ((Element)v.get(100)).setAttribute("width","623" );
      ((Element)v.get(100)).setAttribute("border","0" );
      ((Element)v.get(100)).setAttribute("align","left" );
      ((Element)v.get(100)).setAttribute("cellspacing","0" );
      ((Element)v.get(100)).setAttribute("cellpadding","0" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).setAttribute("colspan","4" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(103)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).setAttribute("width","8" );
      ((Element)v.get(103)).setAttribute("height","8" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:104 / Elemento padre: 100   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(100)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(106)).setAttribute("src","b.gif" );
      ((Element)v.get(106)).setAttribute("width","8" );
      ((Element)v.get(106)).setAttribute("height","8" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:107 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(108)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(108)).setAttribute("alto","13" );
      ((Element)v.get(108)).setAttribute("filas","1" );
      ((Element)v.get(108)).setAttribute("valor","" );
      ((Element)v.get(108)).setAttribute("id","datosTitle" );
      ((Element)v.get(108)).setAttribute("cod","6" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:109 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(110)).setAttribute("src","b.gif" );
      ((Element)v.get(110)).setAttribute("width","25" );
      ((Element)v.get(110)).setAttribute("height","8" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:111 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(112)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(112)).setAttribute("alto","13" );
      ((Element)v.get(112)).setAttribute("filas","1" );
      ((Element)v.get(112)).setAttribute("valor","" );
      ((Element)v.get(112)).setAttribute("id","datosTitle" );
      ((Element)v.get(112)).setAttribute("cod","7" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:113 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).setAttribute("width","100%" );
      ((Element)v.get(104)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(114)).setAttribute("src","b.gif" );
      ((Element)v.get(114)).setAttribute("width","8" );
      ((Element)v.get(114)).setAttribute("height","8" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */
      /* Termina nodo:104   */

      /* Empieza nodo:115 / Elemento padre: 100   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(100)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(117)).setAttribute("src","b.gif" );
      ((Element)v.get(117)).setAttribute("width","8" );
      ((Element)v.get(117)).setAttribute("height","8" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:118 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(118)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(115)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(119)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(119)).setAttribute("id","datosCampos" );
      ((Element)v.get(119)).setAttribute("size","1" );
      ((Element)v.get(119)).setAttribute("multiple","N" );
      ((Element)v.get(119)).setAttribute("req","S" );
      ((Element)v.get(119)).setAttribute("valorinicial","" );
      ((Element)v.get(119)).setAttribute("textoinicial","" );
      ((Element)v.get(119)).setAttribute("onchange","MarcaOnChange();" );
      ((Element)v.get(119)).setAttribute("onshtab","focalizaShTab(1);" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:121 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(122)).setAttribute("src","b.gif" );
      ((Element)v.get(122)).setAttribute("width","25" );
      ((Element)v.get(122)).setAttribute("height","8" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:123 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(123)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(115)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(124)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(124)).setAttribute("id","datosCampos" );
      ((Element)v.get(124)).setAttribute("size","1" );
      ((Element)v.get(124)).setAttribute("multiple","N" );
      ((Element)v.get(124)).setAttribute("req","S" );
      ((Element)v.get(124)).setAttribute("valorinicial","" );
      ((Element)v.get(124)).setAttribute("textoinicial","" );
      ((Element)v.get(124)).setAttribute("onchange","CanalOnChange();" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:126 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).setAttribute("width","100%" );
      ((Element)v.get(115)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(127)).setAttribute("src","b.gif" );
      ((Element)v.get(127)).setAttribute("width","8" );
      ((Element)v.get(127)).setAttribute("height","8" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */
      /* Termina nodo:115   */

      /* Empieza nodo:128 / Elemento padre: 100   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(100)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).setAttribute("colspan","4" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(130)).setAttribute("src","b.gif" );
      ((Element)v.get(130)).setAttribute("width","8" );
      ((Element)v.get(130)).setAttribute("height","8" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */
      /* Termina nodo:128   */
      /* Termina nodo:100   */
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:131 / Elemento padre: 97   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(97)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("td"));
   }

   private void getXML540(Document doc) {
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("table"));
      ((Element)v.get(133)).setAttribute("width","623" );
      ((Element)v.get(133)).setAttribute("border","0" );
      ((Element)v.get(133)).setAttribute("align","left" );
      ((Element)v.get(133)).setAttribute("cellspacing","0" );
      ((Element)v.get(133)).setAttribute("cellpadding","0" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(133)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("IMG"));
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
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(138)).setAttribute("nombre","lblZona" );
      ((Element)v.get(138)).setAttribute("alto","13" );
      ((Element)v.get(138)).setAttribute("filas","1" );
      ((Element)v.get(138)).setAttribute("valor","" );
      ((Element)v.get(138)).setAttribute("id","datosTitle" );
      ((Element)v.get(138)).setAttribute("cod","143" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:139 / Elemento padre: 134   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(140)).setAttribute("src","b.gif" );
      ((Element)v.get(140)).setAttribute("width","25" );
      ((Element)v.get(140)).setAttribute("height","8" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:141 / Elemento padre: 134   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(142)).setAttribute("nombre","lblUbigeo" );
      ((Element)v.get(142)).setAttribute("alto","13" );
      ((Element)v.get(142)).setAttribute("filas","1" );
      ((Element)v.get(142)).setAttribute("valor","" );
      ((Element)v.get(142)).setAttribute("id","datosTitle" );
      ((Element)v.get(142)).setAttribute("cod","135" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */

      /* Empieza nodo:143 / Elemento padre: 134   */
      v.add(doc.createElement("td"));
      ((Element)v.get(143)).setAttribute("width","100%" );
      ((Element)v.get(134)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(144)).setAttribute("src","b.gif" );
      ((Element)v.get(144)).setAttribute("width","8" );
      ((Element)v.get(144)).setAttribute("height","8" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */
      /* Termina nodo:134   */

      /* Empieza nodo:145 / Elemento padre: 133   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(133)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("td"));
      ((Element)v.get(145)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(147)).setAttribute("src","b.gif" );
      ((Element)v.get(147)).setAttribute("width","8" );
      ((Element)v.get(147)).setAttribute("height","8" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:146   */

      /* Empieza nodo:148 / Elemento padre: 145   */
      v.add(doc.createElement("td"));
      ((Element)v.get(148)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(145)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(149)).setAttribute("nombre","cbZona" );
      ((Element)v.get(149)).setAttribute("id","datosCampos" );
      ((Element)v.get(149)).setAttribute("size","1" );
      ((Element)v.get(149)).setAttribute("multiple","N" );
      ((Element)v.get(149)).setAttribute("req","N" );
      ((Element)v.get(149)).setAttribute("valorinicial","" );
      ((Element)v.get(149)).setAttribute("textoinicial","" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:149   */
      /* Termina nodo:148   */

      /* Empieza nodo:151 / Elemento padre: 145   */
      v.add(doc.createElement("td"));
      ((Element)v.get(145)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(152)).setAttribute("src","b.gif" );
      ((Element)v.get(152)).setAttribute("width","25" );
      ((Element)v.get(152)).setAttribute("height","8" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:151   */

      /* Empieza nodo:153 / Elemento padre: 145   */
      v.add(doc.createElement("td"));
      ((Element)v.get(153)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(145)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(154)).setAttribute("nombre","txtUbigeo" );
      ((Element)v.get(154)).setAttribute("id","datosCampos" );
      ((Element)v.get(154)).setAttribute("max","60" );
      ((Element)v.get(154)).setAttribute("tipo","" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(154)).setAttribute("onchange","" );
      ((Element)v.get(154)).setAttribute("req","N" );
      ((Element)v.get(154)).setAttribute("size","60" );
      ((Element)v.get(154)).setAttribute("valor","" );
      ((Element)v.get(154)).setAttribute("validacion","" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */

      /* Empieza nodo:155 / Elemento padre: 145   */
      v.add(doc.createElement("td"));
      ((Element)v.get(155)).setAttribute("width","100%" );
      ((Element)v.get(145)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(156)).setAttribute("src","b.gif" );
      ((Element)v.get(156)).setAttribute("width","8" );
      ((Element)v.get(156)).setAttribute("height","8" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */
      /* Termina nodo:145   */

      /* Empieza nodo:157 / Elemento padre: 133   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(133)).appendChild((Element)v.get(157));

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
      /* Termina nodo:133   */
      /* Termina nodo:132   */
      /* Termina nodo:131   */

      /* Empieza nodo:160 / Elemento padre: 97   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(97)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("table"));
      ((Element)v.get(162)).setAttribute("width","623" );
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
      ((Element)v.get(167)).setAttribute("nombre","lblTipoDespacho" );
      ((Element)v.get(167)).setAttribute("alto","13" );
      ((Element)v.get(167)).setAttribute("filas","1" );
      ((Element)v.get(167)).setAttribute("valor","" );
      ((Element)v.get(167)).setAttribute("id","datosTitle" );
      ((Element)v.get(167)).setAttribute("cod","1000" );
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
      ((Element)v.get(170)).setAttribute("colspan","2" );
      ((Element)v.get(163)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(171)).setAttribute("nombre","lblDescripcion" );
      ((Element)v.get(171)).setAttribute("alto","13" );
      ((Element)v.get(171)).setAttribute("filas","1" );
      ((Element)v.get(171)).setAttribute("valor","" );
      ((Element)v.get(171)).setAttribute("id","datosTitle" );
      ((Element)v.get(171)).setAttribute("cod","9" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:170   */

      /* Empieza nodo:172 / Elemento padre: 163   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).setAttribute("width","100%" );
      ((Element)v.get(163)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(173)).setAttribute("src","b.gif" );
      ((Element)v.get(173)).setAttribute("width","8" );
      ((Element)v.get(173)).setAttribute("height","8" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */
      /* Termina nodo:172   */
      /* Termina nodo:163   */

      /* Empieza nodo:174 / Elemento padre: 162   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(162)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("td"));
      ((Element)v.get(174)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(176)).setAttribute("src","b.gif" );
      ((Element)v.get(176)).setAttribute("width","8" );
      ((Element)v.get(176)).setAttribute("height","8" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:175   */

      /* Empieza nodo:177 / Elemento padre: 174   */
      v.add(doc.createElement("td"));
   }

   private void getXML720(Document doc) {
      ((Element)v.get(177)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(174)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(178)).setAttribute("nombre","cbTipoDespacho" );
      ((Element)v.get(178)).setAttribute("id","datosCampos" );
      ((Element)v.get(178)).setAttribute("size","1" );
      ((Element)v.get(178)).setAttribute("multiple","N" );
      ((Element)v.get(178)).setAttribute("req","S" );
      ((Element)v.get(178)).setAttribute("valorinicial","" );
      ((Element)v.get(178)).setAttribute("textoinicial","" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:178   */
      /* Termina nodo:177   */

      /* Empieza nodo:180 / Elemento padre: 174   */
      v.add(doc.createElement("td"));
      ((Element)v.get(174)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(181)).setAttribute("src","b.gif" );
      ((Element)v.get(181)).setAttribute("width","25" );
      ((Element)v.get(181)).setAttribute("height","8" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:180   */

      /* Empieza nodo:182 / Elemento padre: 174   */
      v.add(doc.createElement("td"));
      ((Element)v.get(182)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(174)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(183)).setAttribute("nombre","txtDescripcion" );
      ((Element)v.get(183)).setAttribute("id","datosCampos" );
      ((Element)v.get(183)).setAttribute("max","40" );
      ((Element)v.get(183)).setAttribute("tipo","" );
      ((Element)v.get(183)).setAttribute("onchange","" );
      ((Element)v.get(183)).setAttribute("req","S" );
      ((Element)v.get(183)).setAttribute("size","40" );
      ((Element)v.get(183)).setAttribute("valor","" );
      ((Element)v.get(183)).setAttribute("validacion","" );
      ((Element)v.get(183)).setAttribute("onshtab","focalizaShTab(2);" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:182   */

      /* Empieza nodo:184 / Elemento padre: 174   */
      v.add(doc.createElement("td"));
      ((Element)v.get(174)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(185)).setAttribute("src","iconmultidioma.gif" );
      ((Element)v.get(185)).setAttribute("onclick","levantarI18N('formulario','1');" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */
      /* Termina nodo:184   */

      /* Empieza nodo:186 / Elemento padre: 174   */
      v.add(doc.createElement("td"));
      ((Element)v.get(186)).setAttribute("width","100%" );
      ((Element)v.get(174)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(187)).setAttribute("src","b.gif" );
      ((Element)v.get(187)).setAttribute("width","8" );
      ((Element)v.get(187)).setAttribute("height","8" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */
      /* Termina nodo:186   */
      /* Termina nodo:174   */

      /* Empieza nodo:188 / Elemento padre: 162   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(162)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("td"));
      ((Element)v.get(189)).setAttribute("colspan","4" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(190)).setAttribute("src","b.gif" );
      ((Element)v.get(190)).setAttribute("width","8" );
      ((Element)v.get(190)).setAttribute("height","8" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:189   */
      /* Termina nodo:188   */
      /* Termina nodo:162   */
      /* Termina nodo:161   */
      /* Termina nodo:160   */

      /* Empieza nodo:191 / Elemento padre: 97   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(97)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("td"));
      ((Element)v.get(191)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("table"));
      ((Element)v.get(193)).setAttribute("width","623" );
      ((Element)v.get(193)).setAttribute("border","0" );
      ((Element)v.get(193)).setAttribute("align","left" );
      ((Element)v.get(193)).setAttribute("cellspacing","0" );
      ((Element)v.get(193)).setAttribute("cellpadding","0" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(193)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("td"));
      ((Element)v.get(194)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(196)).setAttribute("src","b.gif" );
      ((Element)v.get(196)).setAttribute("width","8" );
      ((Element)v.get(196)).setAttribute("height","8" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:195   */

      /* Empieza nodo:197 / Elemento padre: 194   */
      v.add(doc.createElement("td"));
      ((Element)v.get(194)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(198)).setAttribute("nombre","lblMontoFijo" );
      ((Element)v.get(198)).setAttribute("alto","13" );
      ((Element)v.get(198)).setAttribute("filas","1" );
      ((Element)v.get(198)).setAttribute("valor","" );
      ((Element)v.get(198)).setAttribute("id","datosTitle" );
      ((Element)v.get(198)).setAttribute("cod","1414" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:197   */

      /* Empieza nodo:199 / Elemento padre: 194   */
      v.add(doc.createElement("td"));
   }

   private void getXML810(Document doc) {
      ((Element)v.get(194)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(200)).setAttribute("src","b.gif" );
      ((Element)v.get(200)).setAttribute("width","25" );
      ((Element)v.get(200)).setAttribute("height","8" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:199   */

      /* Empieza nodo:201 / Elemento padre: 194   */
      v.add(doc.createElement("td"));
      ((Element)v.get(194)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(202)).setAttribute("nombre","lblTasa" );
      ((Element)v.get(202)).setAttribute("alto","13" );
      ((Element)v.get(202)).setAttribute("filas","1" );
      ((Element)v.get(202)).setAttribute("valor","" );
      ((Element)v.get(202)).setAttribute("id","datosTitle" );
      ((Element)v.get(202)).setAttribute("cod","1415" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:201   */

      /* Empieza nodo:203 / Elemento padre: 194   */
      v.add(doc.createElement("td"));
      ((Element)v.get(194)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(204)).setAttribute("src","b.gif" );
      ((Element)v.get(204)).setAttribute("width","25" );
      ((Element)v.get(204)).setAttribute("height","8" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:203   */

      /* Empieza nodo:205 / Elemento padre: 194   */
      v.add(doc.createElement("td"));
      ((Element)v.get(194)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(206)).setAttribute("nombre","lblFleteMin" );
      ((Element)v.get(206)).setAttribute("alto","13" );
      ((Element)v.get(206)).setAttribute("filas","1" );
      ((Element)v.get(206)).setAttribute("valor","" );
      ((Element)v.get(206)).setAttribute("id","datosTitle" );
      ((Element)v.get(206)).setAttribute("cod","2177" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:205   */

      /* Empieza nodo:207 / Elemento padre: 194   */
      v.add(doc.createElement("td"));
      ((Element)v.get(194)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(208)).setAttribute("src","b.gif" );
      ((Element)v.get(208)).setAttribute("width","25" );
      ((Element)v.get(208)).setAttribute("height","8" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */
      /* Termina nodo:207   */

      /* Empieza nodo:209 / Elemento padre: 194   */
      v.add(doc.createElement("td"));
      ((Element)v.get(194)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(210)).setAttribute("nombre","lblFleteMax" );
      ((Element)v.get(210)).setAttribute("alto","13" );
      ((Element)v.get(210)).setAttribute("filas","1" );
      ((Element)v.get(210)).setAttribute("valor","" );
      ((Element)v.get(210)).setAttribute("id","datosTitle" );
      ((Element)v.get(210)).setAttribute("cod","2178" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */
      /* Termina nodo:209   */

      /* Empieza nodo:211 / Elemento padre: 194   */
      v.add(doc.createElement("td"));
      ((Element)v.get(194)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(212)).setAttribute("src","b.gif" );
      ((Element)v.get(212)).setAttribute("width","25" );
      ((Element)v.get(212)).setAttribute("height","8" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */
      /* Termina nodo:211   */

      /* Empieza nodo:213 / Elemento padre: 194   */
      v.add(doc.createElement("td"));
      ((Element)v.get(194)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(214)).setAttribute("nombre","lblContraEntrega" );
      ((Element)v.get(214)).setAttribute("alto","13" );
      ((Element)v.get(214)).setAttribute("filas","1" );
      ((Element)v.get(214)).setAttribute("valor","" );
      ((Element)v.get(214)).setAttribute("id","datosTitle" );
      ((Element)v.get(214)).setAttribute("cod","1418" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:213   */

      /* Empieza nodo:215 / Elemento padre: 194   */
      v.add(doc.createElement("td"));
      ((Element)v.get(215)).setAttribute("width","100%" );
      ((Element)v.get(194)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(216)).setAttribute("src","b.gif" );
      ((Element)v.get(216)).setAttribute("width","8" );
      ((Element)v.get(216)).setAttribute("height","8" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */
      /* Termina nodo:215   */
      /* Termina nodo:194   */

      /* Empieza nodo:217 / Elemento padre: 193   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(193)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("td"));
      ((Element)v.get(217)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(219)).setAttribute("src","b.gif" );
      ((Element)v.get(219)).setAttribute("width","8" );
      ((Element)v.get(219)).setAttribute("height","8" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */

      /* Empieza nodo:220 / Elemento padre: 217   */
      v.add(doc.createElement("td"));
      ((Element)v.get(217)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(221)).setAttribute("nombre","txtMontoFijo" );
      ((Element)v.get(221)).setAttribute("id","datosCampos" );
      ((Element)v.get(221)).setAttribute("max","13" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(221)).setAttribute("tipo","" );
      ((Element)v.get(221)).setAttribute("onchange","chngMontoFijo();" );
      ((Element)v.get(221)).setAttribute("req","N" );
      ((Element)v.get(221)).setAttribute("size","16" );
      ((Element)v.get(221)).setAttribute("valor","" );
      ((Element)v.get(221)).setAttribute("validacion","" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */
      /* Termina nodo:220   */

      /* Empieza nodo:222 / Elemento padre: 217   */
      v.add(doc.createElement("td"));
      ((Element)v.get(217)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(223)).setAttribute("src","b.gif" );
      ((Element)v.get(223)).setAttribute("width","25" );
      ((Element)v.get(223)).setAttribute("height","8" );
      ((Element)v.get(222)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */
      /* Termina nodo:222   */

      /* Empieza nodo:224 / Elemento padre: 217   */
      v.add(doc.createElement("td"));
      ((Element)v.get(224)).setAttribute("class","datosCampos" );
      ((Element)v.get(224)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(217)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(225)).setAttribute("nombre","txtTasa" );
      ((Element)v.get(225)).setAttribute("id","datosCampos" );
      ((Element)v.get(225)).setAttribute("max","5" );
      ((Element)v.get(225)).setAttribute("tipo","" );
      ((Element)v.get(225)).setAttribute("onchange","" );
      ((Element)v.get(225)).setAttribute("req","N" );
      ((Element)v.get(225)).setAttribute("size","5" );
      ((Element)v.get(225)).setAttribute("valor","" );
      ((Element)v.get(225)).setAttribute("validacion","" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */

      /* Elemento padre:224 / Elemento actual: 226   */
      v.add(doc.createTextNode("%"));
      ((Element)v.get(224)).appendChild((Text)v.get(226));

      /* Termina nodo Texto:226   */
      /* Termina nodo:224   */

      /* Empieza nodo:227 / Elemento padre: 217   */
      v.add(doc.createElement("td"));
      ((Element)v.get(217)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(228)).setAttribute("src","b.gif" );
      ((Element)v.get(228)).setAttribute("width","25" );
      ((Element)v.get(228)).setAttribute("height","8" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */
      /* Termina nodo:227   */

      /* Empieza nodo:229 / Elemento padre: 217   */
      v.add(doc.createElement("td"));
      ((Element)v.get(229)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(217)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(230)).setAttribute("nombre","txtFleteMin" );
      ((Element)v.get(230)).setAttribute("id","datosCampos" );
      ((Element)v.get(230)).setAttribute("max","13" );
      ((Element)v.get(230)).setAttribute("tipo","" );
      ((Element)v.get(230)).setAttribute("onchange","" );
      ((Element)v.get(230)).setAttribute("req","N" );
      ((Element)v.get(230)).setAttribute("size","16" );
      ((Element)v.get(230)).setAttribute("valor","" );
      ((Element)v.get(230)).setAttribute("validacion","" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */
      /* Termina nodo:229   */

      /* Empieza nodo:231 / Elemento padre: 217   */
      v.add(doc.createElement("td"));
      ((Element)v.get(217)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(232)).setAttribute("src","b.gif" );
      ((Element)v.get(232)).setAttribute("width","25" );
      ((Element)v.get(232)).setAttribute("height","8" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */
      /* Termina nodo:231   */

      /* Empieza nodo:233 / Elemento padre: 217   */
      v.add(doc.createElement("td"));
      ((Element)v.get(233)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(217)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(234)).setAttribute("nombre","txtFleteMax" );
      ((Element)v.get(234)).setAttribute("id","datosCampos" );
      ((Element)v.get(234)).setAttribute("max","13" );
      ((Element)v.get(234)).setAttribute("tipo","" );
      ((Element)v.get(234)).setAttribute("onchange","" );
      ((Element)v.get(234)).setAttribute("req","N" );
      ((Element)v.get(234)).setAttribute("size","16" );
      ((Element)v.get(234)).setAttribute("valor","" );
      ((Element)v.get(234)).setAttribute("validacion","" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */
      /* Termina nodo:233   */

      /* Empieza nodo:235 / Elemento padre: 217   */
      v.add(doc.createElement("td"));
      ((Element)v.get(217)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(236)).setAttribute("src","b.gif" );
      ((Element)v.get(236)).setAttribute("width","25" );
      ((Element)v.get(236)).setAttribute("height","8" );
      ((Element)v.get(235)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */
      /* Termina nodo:235   */

      /* Empieza nodo:237 / Elemento padre: 217   */
      v.add(doc.createElement("td"));
      ((Element)v.get(237)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(217)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(238)).setAttribute("nombre","txtContraEntrega" );
      ((Element)v.get(238)).setAttribute("id","datosCampos" );
      ((Element)v.get(238)).setAttribute("max","13" );
      ((Element)v.get(238)).setAttribute("tipo","" );
      ((Element)v.get(238)).setAttribute("onchange","" );
      ((Element)v.get(238)).setAttribute("req","N" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(238)).setAttribute("size","16" );
      ((Element)v.get(238)).setAttribute("valor","" );
      ((Element)v.get(238)).setAttribute("validacion","" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */
      /* Termina nodo:237   */

      /* Empieza nodo:239 / Elemento padre: 217   */
      v.add(doc.createElement("td"));
      ((Element)v.get(239)).setAttribute("width","100%" );
      ((Element)v.get(217)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(240)).setAttribute("src","b.gif" );
      ((Element)v.get(240)).setAttribute("width","8" );
      ((Element)v.get(240)).setAttribute("height","8" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */
      /* Termina nodo:239   */
      /* Termina nodo:217   */

      /* Empieza nodo:241 / Elemento padre: 193   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(193)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("td"));
      ((Element)v.get(242)).setAttribute("colspan","4" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(243)).setAttribute("src","b.gif" );
      ((Element)v.get(243)).setAttribute("width","8" );
      ((Element)v.get(243)).setAttribute("height","8" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */
      /* Termina nodo:242   */
      /* Termina nodo:241   */
      /* Termina nodo:193   */
      /* Termina nodo:192   */
      /* Termina nodo:191   */

      /* Empieza nodo:244 / Elemento padre: 97   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(97)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("td"));
      ((Element)v.get(244)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("table"));
      ((Element)v.get(246)).setAttribute("width","623" );
      ((Element)v.get(246)).setAttribute("border","0" );
      ((Element)v.get(246)).setAttribute("align","left" );
      ((Element)v.get(246)).setAttribute("cellspacing","0" );
      ((Element)v.get(246)).setAttribute("cellpadding","0" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(246)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("td"));
      ((Element)v.get(247)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(249)).setAttribute("src","b.gif" );
      ((Element)v.get(249)).setAttribute("width","1" );
      ((Element)v.get(249)).setAttribute("height","8" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */
      /* Termina nodo:248   */

      /* Empieza nodo:250 / Elemento padre: 247   */
      v.add(doc.createElement("td"));
      ((Element)v.get(250)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(247)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(251)).setAttribute("nombre","btnDetalle" );
      ((Element)v.get(251)).setAttribute("ID","botonContenido" );
      ((Element)v.get(251)).setAttribute("tipo","html" );
      ((Element)v.get(251)).setAttribute("accion","detalle();" );
      ((Element)v.get(251)).setAttribute("estado","false" );
      ((Element)v.get(251)).setAttribute("cod","3433" );
      ((Element)v.get(251)).setAttribute("ontab","focaliza('formulario.cbTipoCliente');" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */
      /* Termina nodo:250   */
      /* Termina nodo:247   */

      /* Empieza nodo:252 / Elemento padre: 246   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(246)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("td"));
      ((Element)v.get(253)).setAttribute("colspan","4" );
      ((Element)v.get(252)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(254)).setAttribute("src","b.gif" );
      ((Element)v.get(254)).setAttribute("width","8" );
      ((Element)v.get(254)).setAttribute("height","8" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */
      /* Termina nodo:253   */
      /* Termina nodo:252   */
      /* Termina nodo:246   */
      /* Termina nodo:245   */
      /* Termina nodo:244   */

      /* Empieza nodo:255 / Elemento padre: 97   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(97)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("td"));
      ((Element)v.get(255)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("table"));
      ((Element)v.get(257)).setAttribute("width","100%" );
      ((Element)v.get(257)).setAttribute("border","0" );
      ((Element)v.get(257)).setAttribute("align","left" );
      ((Element)v.get(257)).setAttribute("cellspacing","0" );
      ((Element)v.get(257)).setAttribute("cellpadding","0" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(257)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("td"));
      ((Element)v.get(258)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(260)).setAttribute("src","b.gif" );
      ((Element)v.get(260)).setAttribute("width","8" );
      ((Element)v.get(260)).setAttribute("height","8" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */
      /* Termina nodo:259   */

      /* Empieza nodo:261 / Elemento padre: 258   */
      v.add(doc.createElement("td"));
      ((Element)v.get(261)).setAttribute("width","100%" );
      ((Element)v.get(258)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("table"));
      ((Element)v.get(262)).setAttribute("width","100%" );
      ((Element)v.get(262)).setAttribute("border","0" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(262)).setAttribute("cellspacing","0" );
      ((Element)v.get(262)).setAttribute("cellpadding","0" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(262)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("td"));
      ((Element)v.get(263)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(264)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(266)).setAttribute("class","legend" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(267)).setAttribute("nombre","lblTipificacionCliente" );
      ((Element)v.get(267)).setAttribute("alto","13" );
      ((Element)v.get(267)).setAttribute("filas","1" );
      ((Element)v.get(267)).setAttribute("valor","" );
      ((Element)v.get(267)).setAttribute("id","legend" );
      ((Element)v.get(267)).setAttribute("cod","00571" );
      ((Element)v.get(266)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */
      /* Termina nodo:266   */

      /* Empieza nodo:268 / Elemento padre: 265   */
      v.add(doc.createElement("table"));
      ((Element)v.get(268)).setAttribute("width","100%" );
      ((Element)v.get(268)).setAttribute("border","0" );
      ((Element)v.get(268)).setAttribute("align","center" );
      ((Element)v.get(268)).setAttribute("cellspacing","0" );
      ((Element)v.get(268)).setAttribute("cellpadding","0" );
      ((Element)v.get(265)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(268)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("td"));
      ((Element)v.get(269)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("table"));
      ((Element)v.get(271)).setAttribute("width","601" );
      ((Element)v.get(271)).setAttribute("border","0" );
      ((Element)v.get(271)).setAttribute("align","left" );
      ((Element)v.get(271)).setAttribute("cellspacing","0" );
      ((Element)v.get(271)).setAttribute("cellpadding","0" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(271)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("td"));
      ((Element)v.get(273)).setAttribute("colspan","3" );
      ((Element)v.get(272)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(274)).setAttribute("src","b.gif" );
      ((Element)v.get(274)).setAttribute("width","8" );
      ((Element)v.get(274)).setAttribute("height","7" );
      ((Element)v.get(273)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */
      /* Termina nodo:273   */
      /* Termina nodo:272   */

      /* Empieza nodo:275 / Elemento padre: 271   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(271)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("td"));
      ((Element)v.get(275)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(277)).setAttribute("src","b.gif" );
      ((Element)v.get(277)).setAttribute("width","8" );
      ((Element)v.get(277)).setAttribute("height","8" );
      ((Element)v.get(276)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */
      /* Termina nodo:276   */

      /* Empieza nodo:278 / Elemento padre: 275   */
      v.add(doc.createElement("td"));
      ((Element)v.get(275)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(279)).setAttribute("nombre","lblTipoCliente" );
      ((Element)v.get(279)).setAttribute("alto","13" );
      ((Element)v.get(279)).setAttribute("filas","1" );
      ((Element)v.get(279)).setAttribute("valor","" );
      ((Element)v.get(279)).setAttribute("id","datosTitle" );
      ((Element)v.get(279)).setAttribute("cod","1869" );
      ((Element)v.get(278)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */
      /* Termina nodo:278   */

      /* Empieza nodo:280 / Elemento padre: 275   */
      v.add(doc.createElement("td"));
      ((Element)v.get(275)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(281)).setAttribute("src","b.gif" );
      ((Element)v.get(281)).setAttribute("width","25" );
      ((Element)v.get(281)).setAttribute("height","8" );
      ((Element)v.get(280)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */
      /* Termina nodo:280   */

      /* Empieza nodo:282 / Elemento padre: 275   */
      v.add(doc.createElement("td"));
      ((Element)v.get(275)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(283)).setAttribute("nombre","lblSubTipoCliente" );
      ((Element)v.get(283)).setAttribute("alto","13" );
      ((Element)v.get(283)).setAttribute("filas","1" );
      ((Element)v.get(283)).setAttribute("valor","" );
      ((Element)v.get(283)).setAttribute("id","datosTitle" );
      ((Element)v.get(283)).setAttribute("cod","595" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */
      /* Termina nodo:282   */

      /* Empieza nodo:284 / Elemento padre: 275   */
      v.add(doc.createElement("td"));
      ((Element)v.get(284)).setAttribute("width","100%" );
      ((Element)v.get(275)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(285)).setAttribute("src","b.gif" );
      ((Element)v.get(285)).setAttribute("width","8" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(285)).setAttribute("height","8" );
      ((Element)v.get(284)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */
      /* Termina nodo:284   */
      /* Termina nodo:275   */

      /* Empieza nodo:286 / Elemento padre: 271   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(271)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("td"));
      ((Element)v.get(286)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(288)).setAttribute("src","b.gif" );
      ((Element)v.get(288)).setAttribute("width","8" );
      ((Element)v.get(288)).setAttribute("height","8" );
      ((Element)v.get(287)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */
      /* Termina nodo:287   */

      /* Empieza nodo:289 / Elemento padre: 286   */
      v.add(doc.createElement("td"));
      ((Element)v.get(289)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(286)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(290)).setAttribute("nombre","cbTipoCliente" );
      ((Element)v.get(290)).setAttribute("id","datosCampos" );
      ((Element)v.get(290)).setAttribute("size","1" );
      ((Element)v.get(290)).setAttribute("multiple","N" );
      ((Element)v.get(290)).setAttribute("req","S" );
      ((Element)v.get(290)).setAttribute("valorinicial","" );
      ((Element)v.get(290)).setAttribute("textoinicial","" );
      ((Element)v.get(290)).setAttribute("onchange","onChangeTipoCliente();" );
      ((Element)v.get(290)).setAttribute("ontab","focalizaTab(1);" );
      ((Element)v.get(289)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(290)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */
      /* Termina nodo:290   */
      /* Termina nodo:289   */

      /* Empieza nodo:292 / Elemento padre: 286   */
      v.add(doc.createElement("td"));
      ((Element)v.get(286)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(293)).setAttribute("src","b.gif" );
      ((Element)v.get(293)).setAttribute("width","25" );
      ((Element)v.get(293)).setAttribute("height","8" );
      ((Element)v.get(292)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */
      /* Termina nodo:292   */

      /* Empieza nodo:294 / Elemento padre: 286   */
      v.add(doc.createElement("td"));
      ((Element)v.get(286)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(295)).setAttribute("nombre","cbSubTipoCliente" );
      ((Element)v.get(295)).setAttribute("id","datosCampos" );
      ((Element)v.get(295)).setAttribute("size","1" );
      ((Element)v.get(295)).setAttribute("multiple","N" );
      ((Element)v.get(295)).setAttribute("req","N" );
      ((Element)v.get(295)).setAttribute("valorinicial","" );
      ((Element)v.get(295)).setAttribute("textoinicial","" );
      ((Element)v.get(295)).setAttribute("onchange","onChangeSubtipoCliente();" );
      ((Element)v.get(295)).setAttribute("ontab","focalizaTab(2);" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(295)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */
      /* Termina nodo:295   */
      /* Termina nodo:294   */

      /* Empieza nodo:297 / Elemento padre: 286   */
      v.add(doc.createElement("td"));
      ((Element)v.get(297)).setAttribute("width","100%" );
      ((Element)v.get(286)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(298)).setAttribute("src","b.gif" );
      ((Element)v.get(298)).setAttribute("width","8" );
      ((Element)v.get(298)).setAttribute("height","8" );
      ((Element)v.get(297)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */
      /* Termina nodo:297   */
      /* Termina nodo:286   */

      /* Empieza nodo:299 / Elemento padre: 271   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(271)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
      v.add(doc.createElement("td"));
      ((Element)v.get(300)).setAttribute("colspan","3" );
      ((Element)v.get(299)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(301)).setAttribute("src","b.gif" );
      ((Element)v.get(301)).setAttribute("width","8" );
      ((Element)v.get(301)).setAttribute("height","8" );
      ((Element)v.get(300)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */
      /* Termina nodo:300   */
      /* Termina nodo:299   */
      /* Termina nodo:271   */
      /* Termina nodo:270   */
      /* Termina nodo:269   */

      /* Empieza nodo:302 / Elemento padre: 268   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(268)).appendChild((Element)v.get(302));

      /* Empieza nodo:303 / Elemento padre: 302   */
      v.add(doc.createElement("td"));
      ((Element)v.get(302)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("table"));
      ((Element)v.get(304)).setAttribute("width","601" );
      ((Element)v.get(304)).setAttribute("border","0" );
      ((Element)v.get(304)).setAttribute("align","left" );
      ((Element)v.get(304)).setAttribute("cellspacing","0" );
      ((Element)v.get(304)).setAttribute("cellpadding","0" );
      ((Element)v.get(303)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(304)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("td"));
      ((Element)v.get(305)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(307)).setAttribute("src","b.gif" );
      ((Element)v.get(307)).setAttribute("width","8" );
      ((Element)v.get(307)).setAttribute("height","8" );
      ((Element)v.get(306)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */
      /* Termina nodo:306   */

      /* Empieza nodo:308 / Elemento padre: 305   */
      v.add(doc.createElement("td"));
      ((Element)v.get(305)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("LABELC"));
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(309)).setAttribute("nombre","lblTipoClasificacion" );
      ((Element)v.get(309)).setAttribute("alto","13" );
      ((Element)v.get(309)).setAttribute("filas","1" );
      ((Element)v.get(309)).setAttribute("valor","" );
      ((Element)v.get(309)).setAttribute("id","datosTitle" );
      ((Element)v.get(309)).setAttribute("cod","756" );
      ((Element)v.get(308)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */
      /* Termina nodo:308   */

      /* Empieza nodo:310 / Elemento padre: 305   */
      v.add(doc.createElement("td"));
      ((Element)v.get(305)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(311)).setAttribute("src","b.gif" );
      ((Element)v.get(311)).setAttribute("width","25" );
      ((Element)v.get(311)).setAttribute("height","8" );
      ((Element)v.get(310)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */
      /* Termina nodo:310   */

      /* Empieza nodo:312 / Elemento padre: 305   */
      v.add(doc.createElement("td"));
      ((Element)v.get(305)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(313)).setAttribute("nombre","lblClasificacion" );
      ((Element)v.get(313)).setAttribute("alto","13" );
      ((Element)v.get(313)).setAttribute("filas","1" );
      ((Element)v.get(313)).setAttribute("valor","" );
      ((Element)v.get(313)).setAttribute("id","datosTitle" );
      ((Element)v.get(313)).setAttribute("cod","550" );
      ((Element)v.get(312)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */
      /* Termina nodo:312   */

      /* Empieza nodo:314 / Elemento padre: 305   */
      v.add(doc.createElement("td"));
      ((Element)v.get(314)).setAttribute("width","100%" );
      ((Element)v.get(305)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(315)).setAttribute("src","b.gif" );
      ((Element)v.get(315)).setAttribute("width","8" );
      ((Element)v.get(315)).setAttribute("height","8" );
      ((Element)v.get(314)).appendChild((Element)v.get(315));
      /* Termina nodo:315   */
      /* Termina nodo:314   */
      /* Termina nodo:305   */

      /* Empieza nodo:316 / Elemento padre: 304   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(304)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
      v.add(doc.createElement("td"));
      ((Element)v.get(316)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(318)).setAttribute("src","b.gif" );
      ((Element)v.get(318)).setAttribute("width","8" );
      ((Element)v.get(318)).setAttribute("height","8" );
      ((Element)v.get(317)).appendChild((Element)v.get(318));
      /* Termina nodo:318   */
      /* Termina nodo:317   */

      /* Empieza nodo:319 / Elemento padre: 316   */
      v.add(doc.createElement("td"));
      ((Element)v.get(316)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(320)).setAttribute("nombre","cbTipoClasificacion" );
      ((Element)v.get(320)).setAttribute("id","datosCampos" );
      ((Element)v.get(320)).setAttribute("size","1" );
      ((Element)v.get(320)).setAttribute("multiple","N" );
      ((Element)v.get(320)).setAttribute("req","N" );
      ((Element)v.get(320)).setAttribute("valorinicial","" );
      ((Element)v.get(320)).setAttribute("textoinicial","" );
      ((Element)v.get(320)).setAttribute("onchange","onChangeTipoClasificacion();" );
      ((Element)v.get(320)).setAttribute("ontab","focalizaTab(3);" );
      ((Element)v.get(319)).appendChild((Element)v.get(320));

      /* Empieza nodo:321 / Elemento padre: 320   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(320)).appendChild((Element)v.get(321));
      /* Termina nodo:321   */
      /* Termina nodo:320   */
      /* Termina nodo:319   */

      /* Empieza nodo:322 / Elemento padre: 316   */
      v.add(doc.createElement("td"));
      ((Element)v.get(316)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(323)).setAttribute("src","b.gif" );
      ((Element)v.get(323)).setAttribute("width","25" );
      ((Element)v.get(323)).setAttribute("height","8" );
      ((Element)v.get(322)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */
      /* Termina nodo:322   */

      /* Empieza nodo:324 / Elemento padre: 316   */
      v.add(doc.createElement("td"));
      ((Element)v.get(316)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(325)).setAttribute("nombre","cbClasificacion" );
      ((Element)v.get(325)).setAttribute("id","datosCampos" );
      ((Element)v.get(325)).setAttribute("size","1" );
      ((Element)v.get(325)).setAttribute("multiple","N" );
      ((Element)v.get(325)).setAttribute("req","N" );
      ((Element)v.get(325)).setAttribute("valorinicial","" );
      ((Element)v.get(325)).setAttribute("textoinicial","" );
      ((Element)v.get(325)).setAttribute("ontab","focalizaTab(4);" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(325)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */
      /* Termina nodo:325   */
      /* Termina nodo:324   */

      /* Empieza nodo:327 / Elemento padre: 316   */
      v.add(doc.createElement("td"));
      ((Element)v.get(327)).setAttribute("width","100%" );
      ((Element)v.get(316)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(328)).setAttribute("src","b.gif" );
      ((Element)v.get(328)).setAttribute("width","8" );
      ((Element)v.get(328)).setAttribute("height","8" );
      ((Element)v.get(327)).appendChild((Element)v.get(328));
      /* Termina nodo:328   */
      /* Termina nodo:327   */
      /* Termina nodo:316   */

      /* Empieza nodo:329 / Elemento padre: 304   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(304)).appendChild((Element)v.get(329));

      /* Empieza nodo:330 / Elemento padre: 329   */
      v.add(doc.createElement("td"));
      ((Element)v.get(330)).setAttribute("colspan","3" );
      ((Element)v.get(329)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
   }

   private void getXML1350(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(331)).setAttribute("src","b.gif" );
      ((Element)v.get(331)).setAttribute("width","8" );
      ((Element)v.get(331)).setAttribute("height","8" );
      ((Element)v.get(330)).appendChild((Element)v.get(331));
      /* Termina nodo:331   */
      /* Termina nodo:330   */
      /* Termina nodo:329   */
      /* Termina nodo:304   */
      /* Termina nodo:303   */
      /* Termina nodo:302   */
      /* Termina nodo:268   */
      /* Termina nodo:265   */
      /* Termina nodo:264   */
      /* Termina nodo:263   */
      /* Termina nodo:262   */
      /* Termina nodo:261   */

      /* Empieza nodo:332 / Elemento padre: 258   */
      v.add(doc.createElement("td"));
      ((Element)v.get(258)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(333)).setAttribute("src","b.gif" );
      ((Element)v.get(333)).setAttribute("width","8" );
      ((Element)v.get(333)).setAttribute("height","8" );
      ((Element)v.get(332)).appendChild((Element)v.get(333));
      /* Termina nodo:333   */
      /* Termina nodo:332   */
      /* Termina nodo:258   */
      /* Termina nodo:257   */
      /* Termina nodo:256   */
      /* Termina nodo:255   */

      /* Empieza nodo:334 / Elemento padre: 97   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(97)).appendChild((Element)v.get(334));

      /* Empieza nodo:335 / Elemento padre: 334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(335)).setAttribute("colspan","4" );
      ((Element)v.get(334)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(336)).setAttribute("src","b.gif" );
      ((Element)v.get(336)).setAttribute("width","8" );
      ((Element)v.get(336)).setAttribute("height","12" );
      ((Element)v.get(335)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */
      /* Termina nodo:335   */
      /* Termina nodo:334   */
      /* Termina nodo:97   */
      /* Termina nodo:94   */
      /* Termina nodo:93   */

      /* Empieza nodo:337 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(338)).setAttribute("src","b.gif" );
      ((Element)v.get(337)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */
      /* Termina nodo:337   */
      /* Termina nodo:90   */

      /* Empieza nodo:339 / Elemento padre: 82   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(82)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("td"));
      ((Element)v.get(340)).setAttribute("width","12" );
      ((Element)v.get(340)).setAttribute("align","center" );
      ((Element)v.get(339)).appendChild((Element)v.get(340));

      /* Empieza nodo:341 / Elemento padre: 340   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(341)).setAttribute("src","b.gif" );
      ((Element)v.get(341)).setAttribute("width","12" );
      ((Element)v.get(341)).setAttribute("height","12" );
      ((Element)v.get(340)).appendChild((Element)v.get(341));
      /* Termina nodo:341   */
      /* Termina nodo:340   */

      /* Empieza nodo:342 / Elemento padre: 339   */
      v.add(doc.createElement("td"));
      ((Element)v.get(342)).setAttribute("width","756" );
      ((Element)v.get(339)).appendChild((Element)v.get(342));

      /* Empieza nodo:343 / Elemento padre: 342   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(343)).setAttribute("src","b.gif" );
      ((Element)v.get(342)).appendChild((Element)v.get(343));
      /* Termina nodo:343   */
      /* Termina nodo:342   */

      /* Empieza nodo:344 / Elemento padre: 339   */
      v.add(doc.createElement("td"));
      ((Element)v.get(344)).setAttribute("width","12" );
      ((Element)v.get(339)).appendChild((Element)v.get(344));

      /* Empieza nodo:345 / Elemento padre: 344   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(345)).setAttribute("src","b.gif" );
      ((Element)v.get(345)).setAttribute("width","12" );
      ((Element)v.get(345)).setAttribute("height","1" );
      ((Element)v.get(344)).appendChild((Element)v.get(345));
      /* Termina nodo:345   */
      /* Termina nodo:344   */
      /* Termina nodo:339   */
      /* Termina nodo:82   */
      /* Termina nodo:81   */
      /* Termina nodo:22   */


   }

}
