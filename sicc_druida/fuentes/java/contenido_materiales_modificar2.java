
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_materiales_modificar2  implements es.indra.druida.base.ObjetoXML {
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
         

      getXML2520(doc);
         

      getXML2610(doc);
         

      getXML2700(doc);
         

      getXML2790(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_materiales_modificar2" );
      ((Element)v.get(0)).setAttribute("cod","0316" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","cargarPagina();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(2)).setAttribute("src","i18NJS.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","contenido_materiales_modificar2.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Empieza nodo:5 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(5)).setAttribute("name","txtAnt" );
      ((Element)v.get(5)).setAttribute("required","false" );
      ((Element)v.get(5)).setAttribute("group","gGuardar" );
      ((Element)v.get(5)).setAttribute("cod","1059" );
      ((Element)v.get(5)).setAttribute("format","t" );
      ((Element)v.get(5)).setAttribute("min","0" );
      ((Element)v.get(5)).setAttribute("max","18" );
      ((Element)v.get(4)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(6)).setAttribute("name","txtDSAP" );
      ((Element)v.get(6)).setAttribute("required","false" );
      ((Element)v.get(6)).setAttribute("group","gGuardar" );
      ((Element)v.get(6)).setAttribute("cod","1068" );
      ((Element)v.get(4)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","txtDCorta" );
      ((Element)v.get(7)).setAttribute("required","false" );
      ((Element)v.get(7)).setAttribute("group","gGuardar" );
      ((Element)v.get(7)).setAttribute("cod","47" );
      ((Element)v.get(7)).setAttribute("format","t" );
      ((Element)v.get(7)).setAttribute("min","0" );
      ((Element)v.get(7)).setAttribute("max","40" );
      ((Element)v.get(4)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","rbIdLote" );
      ((Element)v.get(8)).setAttribute("required","false" );
      ((Element)v.get(8)).setAttribute("group","gGuardar" );
      ((Element)v.get(8)).setAttribute("cod","1086" );
      ((Element)v.get(4)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","cbIdPS" );
      ((Element)v.get(9)).setAttribute("required","false" );
      ((Element)v.get(9)).setAttribute("group","gGuardar" );
      ((Element)v.get(9)).setAttribute("cod","1087" );
      ((Element)v.get(4)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","cbM" );
      ((Element)v.get(10)).setAttribute("required","false" );
      ((Element)v.get(10)).setAttribute("group","gGuardar" );
      ((Element)v.get(10)).setAttribute("cod","2448" );
      ((Element)v.get(4)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","cbUN" );
      ((Element)v.get(11)).setAttribute("required","false" );
      ((Element)v.get(11)).setAttribute("group","gGuardar" );
      ((Element)v.get(11)).setAttribute("cod","587" );
      ((Element)v.get(4)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","cbNeg" );
      ((Element)v.get(12)).setAttribute("required","false" );
      ((Element)v.get(12)).setAttribute("group","gGuardar" );
      ((Element)v.get(12)).setAttribute("cod","588" );
      ((Element)v.get(4)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(13)).setAttribute("name","cbGenr" );
      ((Element)v.get(13)).setAttribute("required","false" );
      ((Element)v.get(13)).setAttribute("group","gGuardar" );
      ((Element)v.get(13)).setAttribute("cod","589" );
      ((Element)v.get(4)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(14)).setAttribute("name","cbSuperGeg" );
      ((Element)v.get(14)).setAttribute("required","false" );
      ((Element)v.get(14)).setAttribute("group","gGuardar" );
      ((Element)v.get(14)).setAttribute("cod","590" );
      ((Element)v.get(4)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(15)).setAttribute("name","txtJ1" );
      ((Element)v.get(15)).setAttribute("required","false" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(15)).setAttribute("group","gGuardar" );
      ((Element)v.get(15)).setAttribute("cod","1088" );
      ((Element)v.get(15)).setAttribute("format","t" );
      ((Element)v.get(15)).setAttribute("min","0" );
      ((Element)v.get(15)).setAttribute("max","3" );
      ((Element)v.get(4)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(16)).setAttribute("name","txtJ2" );
      ((Element)v.get(16)).setAttribute("required","false" );
      ((Element)v.get(16)).setAttribute("group","gGuardar" );
      ((Element)v.get(16)).setAttribute("cod","1089" );
      ((Element)v.get(16)).setAttribute("format","t" );
      ((Element)v.get(16)).setAttribute("min","0" );
      ((Element)v.get(16)).setAttribute("max","3" );
      ((Element)v.get(4)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(17)).setAttribute("name","txtJ3" );
      ((Element)v.get(17)).setAttribute("required","false" );
      ((Element)v.get(17)).setAttribute("group","gGuardar" );
      ((Element)v.get(17)).setAttribute("cod","1090" );
      ((Element)v.get(17)).setAttribute("format","t" );
      ((Element)v.get(17)).setAttribute("min","0" );
      ((Element)v.get(17)).setAttribute("max","3" );
      ((Element)v.get(4)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(18)).setAttribute("name","cbLin" );
      ((Element)v.get(18)).setAttribute("required","false" );
      ((Element)v.get(18)).setAttribute("group","gGuardar" );
      ((Element)v.get(18)).setAttribute("cod","586" );
      ((Element)v.get(4)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(19)).setAttribute("name","txtA1" );
      ((Element)v.get(19)).setAttribute("required","false" );
      ((Element)v.get(19)).setAttribute("group","gGuardar" );
      ((Element)v.get(19)).setAttribute("cod","481" );
      ((Element)v.get(19)).setAttribute("format","t" );
      ((Element)v.get(19)).setAttribute("min","0" );
      ((Element)v.get(19)).setAttribute("max","3" );
      ((Element)v.get(4)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(20)).setAttribute("name","txtA2" );
      ((Element)v.get(20)).setAttribute("required","false" );
      ((Element)v.get(20)).setAttribute("group","gGuardar" );
      ((Element)v.get(20)).setAttribute("cod","482" );
      ((Element)v.get(20)).setAttribute("format","t" );
      ((Element)v.get(20)).setAttribute("min","0" );
      ((Element)v.get(20)).setAttribute("max","4" );
      ((Element)v.get(4)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(21)).setAttribute("name","txtA3" );
      ((Element)v.get(21)).setAttribute("required","false" );
      ((Element)v.get(21)).setAttribute("group","gGuardar" );
      ((Element)v.get(21)).setAttribute("cod","483" );
      ((Element)v.get(21)).setAttribute("format","t" );
      ((Element)v.get(21)).setAttribute("min","0" );
      ((Element)v.get(21)).setAttribute("max","10" );
      ((Element)v.get(4)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(22)).setAttribute("name","txtDA" );
      ((Element)v.get(22)).setAttribute("required","false" );
      ((Element)v.get(22)).setAttribute("group","gGuardar" );
      ((Element)v.get(22)).setAttribute("cod","1070" );
      ((Element)v.get(22)).setAttribute("format","e" );
      ((Element)v.get(22)).setAttribute("min","0" );
      ((Element)v.get(22)).setAttribute("max","999999" );
      ((Element)v.get(4)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(23)).setAttribute("name","txtDL" );
      ((Element)v.get(23)).setAttribute("required","false" );
      ((Element)v.get(23)).setAttribute("group","gGuardar" );
      ((Element)v.get(23)).setAttribute("cod","1071" );
      ((Element)v.get(23)).setAttribute("format","e" );
      ((Element)v.get(23)).setAttribute("min","0" );
      ((Element)v.get(23)).setAttribute("max","999999" );
      ((Element)v.get(4)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(24)).setAttribute("name","txtDAL" );
      ((Element)v.get(24)).setAttribute("required","false" );
      ((Element)v.get(24)).setAttribute("group","gGuardar" );
      ((Element)v.get(24)).setAttribute("cod","1072" );
      ((Element)v.get(24)).setAttribute("format","e" );
      ((Element)v.get(24)).setAttribute("min","0" );
      ((Element)v.get(24)).setAttribute("max","999999" );
      ((Element)v.get(4)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(25)).setAttribute("name","cbUNMedidaDimensiones" );
      ((Element)v.get(25)).setAttribute("required","false" );
      ((Element)v.get(25)).setAttribute("group","gGuardar" );
      ((Element)v.get(25)).setAttribute("cod","1133" );
      ((Element)v.get(4)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 4   */
   }

   private void getXML180(Document doc) {
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(26)).setAttribute("name","txtVoluA" );
      ((Element)v.get(26)).setAttribute("required","false" );
      ((Element)v.get(26)).setAttribute("group","gGuardar" );
      ((Element)v.get(26)).setAttribute("cod","1140" );
      ((Element)v.get(26)).setAttribute("format","e" );
      ((Element)v.get(26)).setAttribute("min","0" );
      ((Element)v.get(26)).setAttribute("max","999999" );
      ((Element)v.get(4)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(27)).setAttribute("name","cbUDV" );
      ((Element)v.get(27)).setAttribute("required","false" );
      ((Element)v.get(27)).setAttribute("group","gGuardar" );
      ((Element)v.get(27)).setAttribute("cod","1135" );
      ((Element)v.get(4)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(28)).setAttribute("name","txtPeso" );
      ((Element)v.get(28)).setAttribute("required","false" );
      ((Element)v.get(28)).setAttribute("group","gGuardar" );
      ((Element)v.get(28)).setAttribute("cod","1115" );
      ((Element)v.get(28)).setAttribute("format","e" );
      ((Element)v.get(28)).setAttribute("min","0" );
      ((Element)v.get(28)).setAttribute("max","999999" );
      ((Element)v.get(4)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(29)).setAttribute("name","cbUDP" );
      ((Element)v.get(29)).setAttribute("required","false" );
      ((Element)v.get(29)).setAttribute("group","gGuardar" );
      ((Element)v.get(29)).setAttribute("cod","1134" );
      ((Element)v.get(4)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(30)).setAttribute("name","txtUnidDentroPedido" );
      ((Element)v.get(30)).setAttribute("required","false" );
      ((Element)v.get(30)).setAttribute("group","gGuardar" );
      ((Element)v.get(30)).setAttribute("cod","1132" );
      ((Element)v.get(30)).setAttribute("format","e" );
      ((Element)v.get(30)).setAttribute("min","0" );
      ((Element)v.get(30)).setAttribute("max","99999" );
      ((Element)v.get(4)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(31)).setAttribute("name","txtUDC" );
      ((Element)v.get(31)).setAttribute("required","false" );
      ((Element)v.get(31)).setAttribute("group","gGuardar" );
      ((Element)v.get(31)).setAttribute("cod","1136" );
      ((Element)v.get(31)).setAttribute("format","e" );
      ((Element)v.get(31)).setAttribute("min","0" );
      ((Element)v.get(31)).setAttribute("max","99999" );
      ((Element)v.get(4)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(32)).setAttribute("name","txtCosteEstandar" );
      ((Element)v.get(32)).setAttribute("required","false" );
      ((Element)v.get(32)).setAttribute("group","gGuardar" );
      ((Element)v.get(32)).setAttribute("cod","604" );
      ((Element)v.get(32)).setAttribute("format","m" );
      ((Element)v.get(32)).setAttribute("min","0" );
      ((Element)v.get(32)).setAttribute("max","9999999999.99" );
      ((Element)v.get(4)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(33)).setAttribute("name","txtPPos" );
      ((Element)v.get(33)).setAttribute("required","false" );
      ((Element)v.get(33)).setAttribute("group","gGuardar" );
      ((Element)v.get(33)).setAttribute("cod","1116" );
      ((Element)v.get(33)).setAttribute("format","m" );
      ((Element)v.get(33)).setAttribute("min","0" );
      ((Element)v.get(33)).setAttribute("max","9999999999.99" );
      ((Element)v.get(4)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(34)).setAttribute("name","cbSituac" );
      ((Element)v.get(34)).setAttribute("required","false" );
      ((Element)v.get(34)).setAttribute("group","gGuardar" );
      ((Element)v.get(34)).setAttribute("cod","695" );
      ((Element)v.get(4)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(35)).setAttribute("name","cbSProd" );
      ((Element)v.get(35)).setAttribute("required","false" );
      ((Element)v.get(35)).setAttribute("group","gGuardar" );
      ((Element)v.get(35)).setAttribute("cod","1077" );
      ((Element)v.get(4)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(36)).setAttribute("name","cbSCaja" );
      ((Element)v.get(36)).setAttribute("required","false" );
      ((Element)v.get(36)).setAttribute("group","gGuardar" );
      ((Element)v.get(36)).setAttribute("cod","1083" );
      ((Element)v.get(4)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(37)).setAttribute("name","cbFormaPago" );
      ((Element)v.get(37)).setAttribute("required","false" );
      ((Element)v.get(37)).setAttribute("group","gGuardar" );
      ((Element)v.get(37)).setAttribute("cod","541" );
      ((Element)v.get(4)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 4   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(38)).setAttribute("name","txtCodImpuesto" );
      ((Element)v.get(38)).setAttribute("required","false" );
      ((Element)v.get(38)).setAttribute("group","gGuardar" );
      ((Element)v.get(38)).setAttribute("cod","1062" );
      ((Element)v.get(38)).setAttribute("format","t" );
      ((Element)v.get(38)).setAttribute("min","0" );
      ((Element)v.get(38)).setAttribute("max","2" );
      ((Element)v.get(4)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(39)).setAttribute("name","txtPrecioCatalogo" );
      ((Element)v.get(39)).setAttribute("required","false" );
      ((Element)v.get(39)).setAttribute("group","gGuardar" );
      ((Element)v.get(39)).setAttribute("cod","503" );
      ((Element)v.get(39)).setAttribute("format","m" );
      ((Element)v.get(39)).setAttribute("min","0" );
      ((Element)v.get(39)).setAttribute("max","9999999999.99" );
      ((Element)v.get(4)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(40)).setAttribute("name","txtPrecioContable" );
      ((Element)v.get(40)).setAttribute("required","false" );
      ((Element)v.get(40)).setAttribute("group","gGuardar" );
      ((Element)v.get(40)).setAttribute("cod","974" );
      ((Element)v.get(40)).setAttribute("format","m" );
      ((Element)v.get(40)).setAttribute("min","0" );
      ((Element)v.get(40)).setAttribute("max","9999999999.99" );
      ((Element)v.get(4)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(41)).setAttribute("name","txtGrupoArticulos" );
      ((Element)v.get(41)).setAttribute("required","false" );
      ((Element)v.get(41)).setAttribute("group","gGuardar" );
      ((Element)v.get(41)).setAttribute("cod","2473" );
      ((Element)v.get(41)).setAttribute("format","t" );
      ((Element)v.get(41)).setAttribute("min","0" );
      ((Element)v.get(41)).setAttribute("max","9" );
      ((Element)v.get(4)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:4   */

      /* Empieza nodo:42 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(43)).setAttribute("nombre","frmFormulario" );
      ((Element)v.get(43)).setAttribute("oculto","S" );
      ((Element)v.get(0)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(45)).setAttribute("valor","modificar" );
      ((Element)v.get(43)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","accion" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","hTxtAnt" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","hTxtDSap" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","hTxtDCorta" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","hTxtDA" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(51)).setAttribute("nombre","hTxtA3" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(52)).setAttribute("nombre","hTxtA2" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(53)).setAttribute("nombre","hTxtA1" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(54)).setAttribute("nombre","hTxtJ3" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(55)).setAttribute("nombre","hTxtJ2" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 43   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(56)).setAttribute("nombre","hTxtJ1" );
      ((Element)v.get(56)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(57)).setAttribute("nombre","hTxtDL" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(58)).setAttribute("nombre","hTxtDAL" );
      ((Element)v.get(58)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */

      /* Empieza nodo:59 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(59)).setAttribute("nombre","hTxtVoluA" );
      ((Element)v.get(59)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */

      /* Empieza nodo:60 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(60)).setAttribute("nombre","hTxtPeso" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */

      /* Empieza nodo:61 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(61)).setAttribute("nombre","hTxtUnidDentroPedido" );
      ((Element)v.get(61)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */

      /* Empieza nodo:62 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(62)).setAttribute("nombre","hTxtUDC" );
      ((Element)v.get(62)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */

      /* Empieza nodo:63 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(63)).setAttribute("nombre","hTxtCosteEstandar" );
      ((Element)v.get(63)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */

      /* Empieza nodo:64 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(64)).setAttribute("nombre","hTxtPPos" );
      ((Element)v.get(64)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */

      /* Empieza nodo:65 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(65)).setAttribute("nombre","hTxtCodImpuesto" );
      ((Element)v.get(65)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */

      /* Empieza nodo:66 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(66)).setAttribute("nombre","hTxtPrecioCatalogo" );
      ((Element)v.get(66)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */

      /* Empieza nodo:67 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(67)).setAttribute("nombre","hTxtPrecioContable" );
      ((Element)v.get(67)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */

      /* Empieza nodo:68 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(68)).setAttribute("nombre","hTxtGrupoArticulos" );
      ((Element)v.get(68)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */

      /* Empieza nodo:69 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(69)).setAttribute("nombre","hOID" );
      ((Element)v.get(69)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */

      /* Empieza nodo:70 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(70)).setAttribute("nombre","hR5" );
      ((Element)v.get(70)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */

      /* Empieza nodo:71 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(71)).setAttribute("nombre","hcbIndicadorPS" );
      ((Element)v.get(71)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */

      /* Empieza nodo:72 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(72)).setAttribute("nombre","hcbM" );
      ((Element)v.get(72)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */

      /* Empieza nodo:73 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(73)).setAttribute("nombre","hcbUN" );
      ((Element)v.get(73)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */

      /* Empieza nodo:74 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(74)).setAttribute("nombre","hcbNeg" );
      ((Element)v.get(74)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */

      /* Empieza nodo:75 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(75)).setAttribute("nombre","hcbGenr" );
      ((Element)v.get(75)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */

      /* Empieza nodo:76 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(76)).setAttribute("nombre","hcbSuperGeg" );
      ((Element)v.get(76)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */

      /* Empieza nodo:77 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(77)).setAttribute("nombre","hcbLin" );
      ((Element)v.get(77)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */

      /* Empieza nodo:78 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(78)).setAttribute("nombre","hcbUNMedidaDimensiones" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(78)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */

      /* Empieza nodo:79 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(79)).setAttribute("nombre","hcbUDV" );
      ((Element)v.get(79)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */

      /* Empieza nodo:80 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(80)).setAttribute("nombre","hcbUDP" );
      ((Element)v.get(80)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */

      /* Empieza nodo:81 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(81)).setAttribute("nombre","hcbSituac" );
      ((Element)v.get(81)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */

      /* Empieza nodo:82 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(82)).setAttribute("nombre","hcbSProd" );
      ((Element)v.get(82)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */

      /* Empieza nodo:83 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(83)).setAttribute("nombre","hcbSCaja" );
      ((Element)v.get(83)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */

      /* Empieza nodo:84 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(84)).setAttribute("nombre","exito" );
      ((Element)v.get(84)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */

      /* Empieza nodo:85 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(85)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(85)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */

      /* Empieza nodo:86 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(86)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(86)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */

      /* Empieza nodo:87 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(87)).setAttribute("nombre","hCodPagoFraccionado" );
      ((Element)v.get(87)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */

      /* Empieza nodo:88 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(88)).setAttribute("nombre","hCodSap" );
      ((Element)v.get(88)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */

      /* Empieza nodo:89 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(89)).setAttribute("nombre","hIndLote" );
      ((Element)v.get(89)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */

      /* Empieza nodo:90 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(90)).setAttribute("nombre","hFormaPago" );
      ((Element)v.get(90)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */

      /* Empieza nodo:91 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(91)).setAttribute("nombre","hModtxtAnt" );
      ((Element)v.get(91)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */

      /* Empieza nodo:92 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(92)).setAttribute("nombre","hModtxtDSAP" );
      ((Element)v.get(92)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */

      /* Empieza nodo:93 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(93)).setAttribute("nombre","hModtxtDCorta" );
      ((Element)v.get(93)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */

      /* Empieza nodo:94 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(94)).setAttribute("nombre","hModrbIdLote" );
      ((Element)v.get(94)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */

      /* Empieza nodo:95 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(95)).setAttribute("nombre","hModcbIndicadorPS" );
      ((Element)v.get(95)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */

      /* Empieza nodo:96 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(96)).setAttribute("nombre","hModcbM" );
      ((Element)v.get(96)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */

      /* Empieza nodo:97 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(97)).setAttribute("nombre","hModcbUN" );
      ((Element)v.get(97)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */

      /* Empieza nodo:98 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(98)).setAttribute("nombre","hModcbNeg" );
      ((Element)v.get(98)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */

      /* Empieza nodo:99 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(99)).setAttribute("nombre","hModcbGenr" );
      ((Element)v.get(99)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */

      /* Empieza nodo:100 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(100)).setAttribute("nombre","hModcbSuperGeg" );
      ((Element)v.get(100)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */

      /* Empieza nodo:101 / Elemento padre: 43   */
   }

   private void getXML540(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(101)).setAttribute("nombre","hModtxtJ1" );
      ((Element)v.get(101)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */

      /* Empieza nodo:102 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(102)).setAttribute("nombre","hModtxtJ2" );
      ((Element)v.get(102)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */

      /* Empieza nodo:103 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(103)).setAttribute("nombre","hModtxtJ3" );
      ((Element)v.get(103)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */

      /* Empieza nodo:104 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(104)).setAttribute("nombre","hModcbLin" );
      ((Element)v.get(104)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */

      /* Empieza nodo:105 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(105)).setAttribute("nombre","hModtxtA1" );
      ((Element)v.get(105)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */

      /* Empieza nodo:106 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(106)).setAttribute("nombre","hModtxtA2" );
      ((Element)v.get(106)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */

      /* Empieza nodo:107 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(107)).setAttribute("nombre","hModtxtA3" );
      ((Element)v.get(107)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */

      /* Empieza nodo:108 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(108)).setAttribute("nombre","hModtxtDA" );
      ((Element)v.get(108)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */

      /* Empieza nodo:109 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(109)).setAttribute("nombre","hModtxtDL" );
      ((Element)v.get(109)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */

      /* Empieza nodo:110 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(110)).setAttribute("nombre","hModtxtDAL" );
      ((Element)v.get(110)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */

      /* Empieza nodo:111 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(111)).setAttribute("nombre","hModcbUNMedidaDimensiones" );
      ((Element)v.get(111)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */

      /* Empieza nodo:112 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(112)).setAttribute("nombre","hModtxtVoluA" );
      ((Element)v.get(112)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */

      /* Empieza nodo:113 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(113)).setAttribute("nombre","hModcbUDV" );
      ((Element)v.get(113)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */

      /* Empieza nodo:114 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(114)).setAttribute("nombre","hModtxtPeso" );
      ((Element)v.get(114)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */

      /* Empieza nodo:115 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(115)).setAttribute("nombre","hModcbUDP" );
      ((Element)v.get(115)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */

      /* Empieza nodo:116 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(116)).setAttribute("nombre","hModtxtUnidDentroPedido" );
      ((Element)v.get(116)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */

      /* Empieza nodo:117 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(117)).setAttribute("nombre","hModtxtUDC" );
      ((Element)v.get(117)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */

      /* Empieza nodo:118 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(118)).setAttribute("nombre","hModtxtCosteEstandar" );
      ((Element)v.get(118)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */

      /* Empieza nodo:119 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(119)).setAttribute("nombre","hModtxtPPos" );
      ((Element)v.get(119)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */

      /* Empieza nodo:120 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(120)).setAttribute("nombre","hModcbSituac" );
      ((Element)v.get(120)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */

      /* Empieza nodo:121 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(121)).setAttribute("nombre","hModcbSProd" );
      ((Element)v.get(121)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */

      /* Empieza nodo:122 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(122)).setAttribute("nombre","hModcbSCaja" );
      ((Element)v.get(122)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */

      /* Empieza nodo:123 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(123)).setAttribute("nombre","hModcbFormaPago" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(123)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */

      /* Empieza nodo:124 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(124)).setAttribute("nombre","hModtxtCodImpuesto" );
      ((Element)v.get(124)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */

      /* Empieza nodo:125 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(125)).setAttribute("nombre","hModtxtPrecioCatalogo" );
      ((Element)v.get(125)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */

      /* Empieza nodo:126 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(126)).setAttribute("nombre","hModtxtPrecioContable" );
      ((Element)v.get(126)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */

      /* Empieza nodo:127 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(127)).setAttribute("nombre","hModtxtGrupoArticulos" );
      ((Element)v.get(127)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */

      /* Empieza nodo:128 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(128)).setAttribute("nombre","hIdLoteReq" );
      ((Element)v.get(128)).setAttribute("valor","S" );
      ((Element)v.get(43)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */

      /* Empieza nodo:129 / Elemento padre: 43   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(129)).setAttribute("nombre","hcbProgFide" );
      ((Element)v.get(129)).setAttribute("valor","" );
      ((Element)v.get(43)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */

      /* Empieza nodo:130 / Elemento padre: 43   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(130)).setAttribute("nombre","capaFormulario" );
      ((Element)v.get(130)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(130)).setAttribute("borde","0" );
      ((Element)v.get(130)).setAttribute("imagenf","" );
      ((Element)v.get(130)).setAttribute("repeat","" );
      ((Element)v.get(130)).setAttribute("padding","" );
      ((Element)v.get(130)).setAttribute("visibilidad","" );
      ((Element)v.get(130)).setAttribute("contravsb","" );
      ((Element)v.get(130)).setAttribute("x","0" );
      ((Element)v.get(130)).setAttribute("y","0" );
      ((Element)v.get(130)).setAttribute("zindex","" );
      ((Element)v.get(43)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("table"));
      ((Element)v.get(131)).setAttribute("width","100%" );
      ((Element)v.get(131)).setAttribute("border","0" );
      ((Element)v.get(131)).setAttribute("cellspacing","0" );
      ((Element)v.get(131)).setAttribute("cellpadding","0" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).setAttribute("width","12" );
      ((Element)v.get(133)).setAttribute("align","center" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(134)).setAttribute("src","b.gif" );
      ((Element)v.get(134)).setAttribute("width","12" );
      ((Element)v.get(134)).setAttribute("height","12" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */

      /* Empieza nodo:135 / Elemento padre: 132   */
      v.add(doc.createElement("td"));
      ((Element)v.get(135)).setAttribute("width","750" );
      ((Element)v.get(132)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(136)).setAttribute("src","b.gif" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */

      /* Empieza nodo:137 / Elemento padre: 132   */
      v.add(doc.createElement("td"));
      ((Element)v.get(137)).setAttribute("width","12" );
      ((Element)v.get(132)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(138)).setAttribute("src","b.gif" );
      ((Element)v.get(138)).setAttribute("width","12" );
      ((Element)v.get(138)).setAttribute("height","1" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */
      /* Termina nodo:132   */

      /* Empieza nodo:139 / Elemento padre: 131   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(131)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(141)).setAttribute("src","b.gif" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */

      /* Empieza nodo:142 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(144)).setAttribute("class","legend" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(145)).setAttribute("nombre","lblCriterios" );
      ((Element)v.get(145)).setAttribute("alto","13" );
      ((Element)v.get(145)).setAttribute("filas","1" );
      ((Element)v.get(145)).setAttribute("valor","Datos de material" );
      ((Element)v.get(145)).setAttribute("id","legend" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(145)).setAttribute("cod","00151" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:144   */

      /* Empieza nodo:146 / Elemento padre: 143   */
      v.add(doc.createElement("table"));
      ((Element)v.get(146)).setAttribute("width","100%" );
      ((Element)v.get(146)).setAttribute("border","0" );
      ((Element)v.get(146)).setAttribute("align","center" );
      ((Element)v.get(146)).setAttribute("cellspacing","0" );
      ((Element)v.get(146)).setAttribute("cellpadding","0" );
      ((Element)v.get(143)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(146)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(148)).setAttribute("colspan","4" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(149)).setAttribute("src","b.gif" );
      ((Element)v.get(149)).setAttribute("width","8" );
      ((Element)v.get(149)).setAttribute("height","8" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */
      /* Termina nodo:147   */

      /* Empieza nodo:150 / Elemento padre: 146   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(146)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(152)).setAttribute("src","b.gif" );
      ((Element)v.get(152)).setAttribute("width","8" );
      ((Element)v.get(152)).setAttribute("height","8" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:151   */

      /* Empieza nodo:153 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(154)).setAttribute("nombre","lblCUV" );
      ((Element)v.get(154)).setAttribute("alto","13" );
      ((Element)v.get(154)).setAttribute("filas","1" );
      ((Element)v.get(154)).setAttribute("valor","" );
      ((Element)v.get(154)).setAttribute("id","datosTitle" );
      ((Element)v.get(154)).setAttribute("cod","3058" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */

      /* Empieza nodo:155 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(156)).setAttribute("src","b.gif" );
      ((Element)v.get(156)).setAttribute("width","25" );
      ((Element)v.get(156)).setAttribute("height","8" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */

      /* Empieza nodo:157 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(158)).setAttribute("nombre","lblCodSAP" );
      ((Element)v.get(158)).setAttribute("alto","13" );
      ((Element)v.get(158)).setAttribute("filas","1" );
      ((Element)v.get(158)).setAttribute("valor","" );
      ((Element)v.get(158)).setAttribute("id","datosTitle" );
      ((Element)v.get(158)).setAttribute("cod","585" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:159 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(160)).setAttribute("src","b.gif" );
      ((Element)v.get(160)).setAttribute("width","25" );
      ((Element)v.get(160)).setAttribute("height","8" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:159   */

      /* Empieza nodo:161 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(162)).setAttribute("nombre","lblCodAntiguo" );
      ((Element)v.get(162)).setAttribute("alto","13" );
      ((Element)v.get(162)).setAttribute("filas","1" );
      ((Element)v.get(162)).setAttribute("valor","" );
      ((Element)v.get(162)).setAttribute("id","datosTitle" );
      ((Element)v.get(162)).setAttribute("cod","1059" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */
      /* Termina nodo:161   */

      /* Empieza nodo:163 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).setAttribute("width","100%" );
      ((Element)v.get(150)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(164)).setAttribute("src","b.gif" );
      ((Element)v.get(164)).setAttribute("width","8" );
      ((Element)v.get(164)).setAttribute("height","8" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */
      /* Termina nodo:150   */

      /* Empieza nodo:165 / Elemento padre: 146   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(146)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("td"));
      ((Element)v.get(165)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(167)).setAttribute("src","b.gif" );
      ((Element)v.get(167)).setAttribute("width","8" );
      ((Element)v.get(167)).setAttribute("height","8" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:166   */

      /* Empieza nodo:168 / Elemento padre: 165   */
      v.add(doc.createElement("td"));
   }

   private void getXML810(Document doc) {
      ((Element)v.get(168)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(165)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(169)).setAttribute("nombre","lblcodigoUnicoVenta" );
      ((Element)v.get(169)).setAttribute("alto","13" );
      ((Element)v.get(169)).setAttribute("filas","1" );
      ((Element)v.get(169)).setAttribute("valor","" );
      ((Element)v.get(169)).setAttribute("id","datosCampos" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */
      /* Termina nodo:168   */

      /* Empieza nodo:170 / Elemento padre: 165   */
      v.add(doc.createElement("td"));
      ((Element)v.get(165)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(171)).setAttribute("src","b.gif" );
      ((Element)v.get(171)).setAttribute("width","25" );
      ((Element)v.get(171)).setAttribute("height","8" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:170   */

      /* Empieza nodo:172 / Elemento padre: 165   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(165)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(173)).setAttribute("nombre","lblR1" );
      ((Element)v.get(173)).setAttribute("alto","13" );
      ((Element)v.get(173)).setAttribute("filas","1" );
      ((Element)v.get(173)).setAttribute("valor","" );
      ((Element)v.get(173)).setAttribute("id","datosCampos" );
      ((Element)v.get(173)).setAttribute("codi","5" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */
      /* Termina nodo:172   */

      /* Empieza nodo:174 / Elemento padre: 165   */
      v.add(doc.createElement("td"));
      ((Element)v.get(165)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(175)).setAttribute("src","b.gif" );
      ((Element)v.get(175)).setAttribute("width","25" );
      ((Element)v.get(175)).setAttribute("height","8" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:174   */

      /* Empieza nodo:176 / Elemento padre: 165   */
      v.add(doc.createElement("td"));
      ((Element)v.get(176)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(165)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(177)).setAttribute("nombre","txtAnt" );
      ((Element)v.get(177)).setAttribute("id","datosCampos" );
      ((Element)v.get(177)).setAttribute("max","18" );
      ((Element)v.get(177)).setAttribute("tipo","" );
      ((Element)v.get(177)).setAttribute("onchange","" );
      ((Element)v.get(177)).setAttribute("req","N" );
      ((Element)v.get(177)).setAttribute("size","23" );
      ((Element)v.get(177)).setAttribute("valor","" );
      ((Element)v.get(177)).setAttribute("validacion","" );
      ((Element)v.get(177)).setAttribute("ontab","setTabFocus('txtAnt');" );
      ((Element)v.get(177)).setAttribute("onshtab","setSHTabFocus('txtAnt')" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */
      /* Termina nodo:176   */

      /* Empieza nodo:178 / Elemento padre: 165   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).setAttribute("width","100%" );
      ((Element)v.get(165)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(179)).setAttribute("src","b.gif" );
      ((Element)v.get(179)).setAttribute("width","8" );
      ((Element)v.get(179)).setAttribute("height","8" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:178   */
      /* Termina nodo:165   */

      /* Empieza nodo:180 / Elemento padre: 146   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(146)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("td"));
      ((Element)v.get(181)).setAttribute("colspan","4" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(182)).setAttribute("src","b.gif" );
      ((Element)v.get(182)).setAttribute("width","8" );
      ((Element)v.get(182)).setAttribute("height","8" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:181   */
      /* Termina nodo:180   */
      /* Termina nodo:146   */

      /* Empieza nodo:183 / Elemento padre: 143   */
      v.add(doc.createElement("table"));
      ((Element)v.get(183)).setAttribute("width","100%" );
      ((Element)v.get(183)).setAttribute("border","0" );
      ((Element)v.get(183)).setAttribute("align","center" );
      ((Element)v.get(183)).setAttribute("cellspacing","0" );
      ((Element)v.get(183)).setAttribute("cellpadding","0" );
      ((Element)v.get(143)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(183)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("td"));
      ((Element)v.get(184)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(186)).setAttribute("src","b.gif" );
      ((Element)v.get(186)).setAttribute("width","8" );
      ((Element)v.get(186)).setAttribute("height","8" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:187 / Elemento padre: 184   */
      v.add(doc.createElement("td"));
      ((Element)v.get(184)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(188)).setAttribute("nombre","lblDescripcionSAP" );
      ((Element)v.get(188)).setAttribute("alto","13" );
      ((Element)v.get(188)).setAttribute("filas","1" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(188)).setAttribute("valor","" );
      ((Element)v.get(188)).setAttribute("id","datosTitle" );
      ((Element)v.get(188)).setAttribute("cod","1068" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */

      /* Empieza nodo:189 / Elemento padre: 184   */
      v.add(doc.createElement("td"));
      ((Element)v.get(184)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(190)).setAttribute("src","b.gif" );
      ((Element)v.get(190)).setAttribute("width","25" );
      ((Element)v.get(190)).setAttribute("height","8" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:189   */

      /* Empieza nodo:191 / Elemento padre: 184   */
      v.add(doc.createElement("td"));
      ((Element)v.get(184)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(192)).setAttribute("nombre","lblDescripcionCorta" );
      ((Element)v.get(192)).setAttribute("alto","13" );
      ((Element)v.get(192)).setAttribute("filas","1" );
      ((Element)v.get(192)).setAttribute("valor","" );
      ((Element)v.get(192)).setAttribute("id","datosTitle" );
      ((Element)v.get(192)).setAttribute("cod","47" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:191   */

      /* Empieza nodo:193 / Elemento padre: 184   */
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).setAttribute("width","100%" );
      ((Element)v.get(184)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(194)).setAttribute("src","b.gif" );
      ((Element)v.get(194)).setAttribute("width","8" );
      ((Element)v.get(194)).setAttribute("height","8" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */
      /* Termina nodo:193   */
      /* Termina nodo:184   */

      /* Empieza nodo:195 / Elemento padre: 183   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(183)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("td"));
      ((Element)v.get(195)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(197)).setAttribute("src","b.gif" );
      ((Element)v.get(197)).setAttribute("width","8" );
      ((Element)v.get(197)).setAttribute("height","8" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */
      /* Termina nodo:196   */

      /* Empieza nodo:198 / Elemento padre: 195   */
      v.add(doc.createElement("td"));
      ((Element)v.get(198)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(195)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(199)).setAttribute("nombre","txtDSAP" );
      ((Element)v.get(199)).setAttribute("id","datosCampos" );
      ((Element)v.get(199)).setAttribute("max","40" );
      ((Element)v.get(199)).setAttribute("tipo","" );
      ((Element)v.get(199)).setAttribute("onchange","" );
      ((Element)v.get(199)).setAttribute("req","N" );
      ((Element)v.get(199)).setAttribute("size","55" );
      ((Element)v.get(199)).setAttribute("valor","" );
      ((Element)v.get(199)).setAttribute("validacion","" );
      ((Element)v.get(199)).setAttribute("ontab","setTabFocus('txtDSAP');" );
      ((Element)v.get(199)).setAttribute("onshtab","setSHTabFocus('txtDSAP')" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */

      /* Empieza nodo:200 / Elemento padre: 198   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(200)).setAttribute("src","iconmultidioma.gif" );
      ((Element)v.get(200)).setAttribute("onclick","levantarI18N('frmFormulario', 1);" );
      ((Element)v.get(198)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:198   */

      /* Empieza nodo:201 / Elemento padre: 195   */
      v.add(doc.createElement("td"));
      ((Element)v.get(195)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(202)).setAttribute("src","b.gif" );
      ((Element)v.get(202)).setAttribute("width","25" );
      ((Element)v.get(202)).setAttribute("height","8" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:201   */

      /* Empieza nodo:203 / Elemento padre: 195   */
      v.add(doc.createElement("td"));
      ((Element)v.get(203)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(195)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(204)).setAttribute("nombre","txtDCorta" );
      ((Element)v.get(204)).setAttribute("id","datosCampos" );
      ((Element)v.get(204)).setAttribute("max","40" );
      ((Element)v.get(204)).setAttribute("tipo","" );
      ((Element)v.get(204)).setAttribute("onchange","" );
      ((Element)v.get(204)).setAttribute("req","N" );
      ((Element)v.get(204)).setAttribute("size","55" );
      ((Element)v.get(204)).setAttribute("valor","" );
      ((Element)v.get(204)).setAttribute("validacion","" );
      ((Element)v.get(204)).setAttribute("ontab","setTabFocus('txtDCorta');" );
      ((Element)v.get(204)).setAttribute("onshtab","setSHTabFocus('txtDCorta')" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:203   */

      /* Empieza nodo:205 / Elemento padre: 195   */
      v.add(doc.createElement("td"));
      ((Element)v.get(205)).setAttribute("width","100%" );
      ((Element)v.get(195)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(206)).setAttribute("src","b.gif" );
      ((Element)v.get(206)).setAttribute("width","8" );
      ((Element)v.get(206)).setAttribute("height","8" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:205   */
      /* Termina nodo:195   */

      /* Empieza nodo:207 / Elemento padre: 183   */
      v.add(doc.createElement("tr"));
   }

   private void getXML990(Document doc) {
      ((Element)v.get(183)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("td"));
      ((Element)v.get(208)).setAttribute("colspan","4" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(209)).setAttribute("src","b.gif" );
      ((Element)v.get(209)).setAttribute("width","8" );
      ((Element)v.get(209)).setAttribute("height","8" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */
      /* Termina nodo:207   */
      /* Termina nodo:183   */

      /* Empieza nodo:210 / Elemento padre: 143   */
      v.add(doc.createElement("table"));
      ((Element)v.get(210)).setAttribute("width","100%" );
      ((Element)v.get(210)).setAttribute("border","0" );
      ((Element)v.get(210)).setAttribute("align","center" );
      ((Element)v.get(210)).setAttribute("cellspacing","0" );
      ((Element)v.get(210)).setAttribute("cellpadding","0" );
      ((Element)v.get(143)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(210)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("td"));
      ((Element)v.get(211)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(213)).setAttribute("src","b.gif" );
      ((Element)v.get(213)).setAttribute("width","8" );
      ((Element)v.get(213)).setAttribute("height","8" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */
      /* Termina nodo:212   */

      /* Empieza nodo:214 / Elemento padre: 211   */
      v.add(doc.createElement("td"));
      ((Element)v.get(211)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(215)).setAttribute("nombre","lblIdLote" );
      ((Element)v.get(215)).setAttribute("alto","13" );
      ((Element)v.get(215)).setAttribute("filas","1" );
      ((Element)v.get(215)).setAttribute("valor","" );
      ((Element)v.get(215)).setAttribute("id","datosTitle" );
      ((Element)v.get(215)).setAttribute("cod","1086" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */
      /* Termina nodo:214   */

      /* Empieza nodo:216 / Elemento padre: 211   */
      v.add(doc.createElement("td"));
      ((Element)v.get(211)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(217)).setAttribute("src","b.gif" );
      ((Element)v.get(217)).setAttribute("width","25" );
      ((Element)v.get(217)).setAttribute("height","8" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:216   */

      /* Empieza nodo:218 / Elemento padre: 211   */
      v.add(doc.createElement("td"));
      ((Element)v.get(211)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(219)).setAttribute("nombre","lblIdPS" );
      ((Element)v.get(219)).setAttribute("alto","13" );
      ((Element)v.get(219)).setAttribute("filas","1" );
      ((Element)v.get(219)).setAttribute("valor","" );
      ((Element)v.get(219)).setAttribute("id","datosTitle" );
      ((Element)v.get(219)).setAttribute("cod","1087" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */

      /* Empieza nodo:220 / Elemento padre: 211   */
      v.add(doc.createElement("td"));
      ((Element)v.get(211)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(221)).setAttribute("src","b.gif" );
      ((Element)v.get(221)).setAttribute("width","25" );
      ((Element)v.get(221)).setAttribute("height","8" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */
      /* Termina nodo:220   */

      /* Empieza nodo:222 / Elemento padre: 211   */
      v.add(doc.createElement("td"));
      ((Element)v.get(211)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(223)).setAttribute("nombre","lblMarcaProducto" );
      ((Element)v.get(223)).setAttribute("alto","13" );
      ((Element)v.get(223)).setAttribute("filas","1" );
      ((Element)v.get(223)).setAttribute("valor","" );
      ((Element)v.get(223)).setAttribute("id","datosTitle" );
      ((Element)v.get(223)).setAttribute("cod","2448" );
      ((Element)v.get(222)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */
      /* Termina nodo:222   */

      /* Empieza nodo:224 / Elemento padre: 211   */
      v.add(doc.createElement("td"));
      ((Element)v.get(224)).setAttribute("width","100%" );
      ((Element)v.get(211)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(225)).setAttribute("src","b.gif" );
      ((Element)v.get(225)).setAttribute("width","8" );
      ((Element)v.get(225)).setAttribute("height","8" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */
      /* Termina nodo:224   */
      /* Termina nodo:211   */

      /* Empieza nodo:226 / Elemento padre: 210   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(210)).appendChild((Element)v.get(226));

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
      ((Element)v.get(229)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(226)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("table"));
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(230)).setAttribute("width","100%" );
      ((Element)v.get(230)).setAttribute("border","0" );
      ((Element)v.get(230)).setAttribute("cellspacing","0" );
      ((Element)v.get(230)).setAttribute("cellpadding","0" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(230)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("td"));
      ((Element)v.get(232)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(232)).setAttribute("class","datosCampos" );
      ((Element)v.get(232)).setAttribute("id","tdRadio" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(233)).setAttribute("nombre","rbIdLote" );
      ((Element)v.get(233)).setAttribute("tipo","H" );
      ((Element)v.get(233)).setAttribute("id","datosCampos" );
      ((Element)v.get(233)).setAttribute("onclick","actualizarHiddenRadio();" );
      ((Element)v.get(233)).setAttribute("ontab","setTabFocus('rbIdLote');" );
      ((Element)v.get(233)).setAttribute("onshtab","setSHTabFocus('rbIdLote');" );
      ((Element)v.get(233)).setAttribute("req","S" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(234)).setAttribute("valor","S" );
      ((Element)v.get(234)).setAttribute("check","N" );
      ((Element)v.get(234)).setAttribute("onfocus","" );
      ((Element)v.get(234)).setAttribute("id","datosCampos" );
      ((Element)v.get(234)).setAttribute("cod","117" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));

      /* Elemento padre:234 / Elemento actual: 235   */
      v.add(doc.createTextNode("xxx"));
      ((Element)v.get(234)).appendChild((Text)v.get(235));

      /* Termina nodo Texto:235   */
      /* Termina nodo:234   */

      /* Empieza nodo:236 / Elemento padre: 233   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(236)).setAttribute("valor","N" );
      ((Element)v.get(236)).setAttribute("check","N" );
      ((Element)v.get(236)).setAttribute("onfocus","" );
      ((Element)v.get(236)).setAttribute("id","datosCampos" );
      ((Element)v.get(236)).setAttribute("cod","87" );
      ((Element)v.get(233)).appendChild((Element)v.get(236));

      /* Elemento padre:236 / Elemento actual: 237   */
      v.add(doc.createTextNode("ccc"));
      ((Element)v.get(236)).appendChild((Text)v.get(237));

      /* Termina nodo Texto:237   */
      /* Termina nodo:236   */
      /* Termina nodo:233   */
      /* Termina nodo:232   */
      /* Termina nodo:231   */
      /* Termina nodo:230   */
      /* Termina nodo:229   */

      /* Empieza nodo:238 / Elemento padre: 226   */
      v.add(doc.createElement("td"));
      ((Element)v.get(226)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(239)).setAttribute("src","b.gif" );
      ((Element)v.get(239)).setAttribute("width","25" );
      ((Element)v.get(239)).setAttribute("height","8" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */
      /* Termina nodo:238   */

      /* Empieza nodo:240 / Elemento padre: 226   */
      v.add(doc.createElement("td"));
      ((Element)v.get(240)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(226)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(241)).setAttribute("nombre","cbIdPS" );
      ((Element)v.get(241)).setAttribute("id","datosCampos" );
      ((Element)v.get(241)).setAttribute("size","1" );
      ((Element)v.get(241)).setAttribute("multiple","N" );
      ((Element)v.get(241)).setAttribute("req","N" );
      ((Element)v.get(241)).setAttribute("valorinicial","" );
      ((Element)v.get(241)).setAttribute("textoinicial","" );
      ((Element)v.get(241)).setAttribute("ontab","setTabFocus('cbIdPS');" );
      ((Element)v.get(241)).setAttribute("onshtab","setSHTabFocus('cbIdPS');" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(241)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */
      /* Termina nodo:241   */
      /* Termina nodo:240   */

      /* Empieza nodo:243 / Elemento padre: 226   */
      v.add(doc.createElement("td"));
      ((Element)v.get(226)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(244)).setAttribute("src","b.gif" );
      ((Element)v.get(244)).setAttribute("width","25" );
      ((Element)v.get(244)).setAttribute("height","8" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */
      /* Termina nodo:243   */

      /* Empieza nodo:245 / Elemento padre: 226   */
      v.add(doc.createElement("td"));
      ((Element)v.get(245)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(226)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(246)).setAttribute("nombre","cbM" );
      ((Element)v.get(246)).setAttribute("id","datosCampos" );
      ((Element)v.get(246)).setAttribute("size","1" );
      ((Element)v.get(246)).setAttribute("multiple","N" );
      ((Element)v.get(246)).setAttribute("req","N" );
      ((Element)v.get(246)).setAttribute("valorinicial","" );
      ((Element)v.get(246)).setAttribute("textoinicial","" );
      ((Element)v.get(246)).setAttribute("ontab","setTabFocus('cbM');" );
      ((Element)v.get(246)).setAttribute("onshtab","setSHTabFocus('cbM');" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(246)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */
      /* Termina nodo:246   */
      /* Termina nodo:245   */

      /* Empieza nodo:248 / Elemento padre: 226   */
      v.add(doc.createElement("td"));
      ((Element)v.get(248)).setAttribute("width","100%" );
      ((Element)v.get(226)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(249)).setAttribute("src","b.gif" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(249)).setAttribute("width","8" );
      ((Element)v.get(249)).setAttribute("height","8" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */
      /* Termina nodo:248   */
      /* Termina nodo:226   */

      /* Empieza nodo:250 / Elemento padre: 210   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(210)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("td"));
      ((Element)v.get(251)).setAttribute("colspan","4" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(252)).setAttribute("src","b.gif" );
      ((Element)v.get(252)).setAttribute("width","8" );
      ((Element)v.get(252)).setAttribute("height","8" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */
      /* Termina nodo:251   */
      /* Termina nodo:250   */
      /* Termina nodo:210   */

      /* Empieza nodo:253 / Elemento padre: 143   */
      v.add(doc.createElement("table"));
      ((Element)v.get(253)).setAttribute("width","100%" );
      ((Element)v.get(253)).setAttribute("border","0" );
      ((Element)v.get(253)).setAttribute("align","center" );
      ((Element)v.get(253)).setAttribute("cellspacing","0" );
      ((Element)v.get(253)).setAttribute("cellpadding","0" );
      ((Element)v.get(143)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(253)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("td"));
      ((Element)v.get(254)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(256)).setAttribute("src","b.gif" );
      ((Element)v.get(256)).setAttribute("width","8" );
      ((Element)v.get(256)).setAttribute("height","8" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */
      /* Termina nodo:255   */

      /* Empieza nodo:257 / Elemento padre: 254   */
      v.add(doc.createElement("td"));
      ((Element)v.get(254)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(258)).setAttribute("nombre","lblUniNegocio" );
      ((Element)v.get(258)).setAttribute("alto","13" );
      ((Element)v.get(258)).setAttribute("filas","1" );
      ((Element)v.get(258)).setAttribute("valor","" );
      ((Element)v.get(258)).setAttribute("id","datosTitle" );
      ((Element)v.get(258)).setAttribute("cod","587" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */
      /* Termina nodo:257   */

      /* Empieza nodo:259 / Elemento padre: 254   */
      v.add(doc.createElement("td"));
      ((Element)v.get(254)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(260)).setAttribute("src","b.gif" );
      ((Element)v.get(260)).setAttribute("width","25" );
      ((Element)v.get(260)).setAttribute("height","8" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */
      /* Termina nodo:259   */

      /* Empieza nodo:261 / Elemento padre: 254   */
      v.add(doc.createElement("td"));
      ((Element)v.get(254)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(262)).setAttribute("nombre","lblNegocio" );
      ((Element)v.get(262)).setAttribute("alto","13" );
      ((Element)v.get(262)).setAttribute("filas","1" );
      ((Element)v.get(262)).setAttribute("valor","" );
      ((Element)v.get(262)).setAttribute("id","datosTitle" );
      ((Element)v.get(262)).setAttribute("cod","588" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */
      /* Termina nodo:261   */

      /* Empieza nodo:263 / Elemento padre: 254   */
      v.add(doc.createElement("td"));
      ((Element)v.get(263)).setAttribute("width","100%" );
      ((Element)v.get(254)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(264)).setAttribute("src","b.gif" );
      ((Element)v.get(264)).setAttribute("width","8" );
      ((Element)v.get(264)).setAttribute("height","8" );
      ((Element)v.get(263)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */
      /* Termina nodo:263   */
      /* Termina nodo:254   */

      /* Empieza nodo:265 / Elemento padre: 253   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(253)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("td"));
      ((Element)v.get(265)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(267)).setAttribute("src","b.gif" );
      ((Element)v.get(267)).setAttribute("width","8" );
      ((Element)v.get(267)).setAttribute("height","8" );
      ((Element)v.get(266)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */
      /* Termina nodo:266   */

      /* Empieza nodo:268 / Elemento padre: 265   */
      v.add(doc.createElement("td"));
      ((Element)v.get(268)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(265)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(269)).setAttribute("nombre","cbUN" );
      ((Element)v.get(269)).setAttribute("id","datosCampos" );
      ((Element)v.get(269)).setAttribute("size","1" );
      ((Element)v.get(269)).setAttribute("multiple","N" );
      ((Element)v.get(269)).setAttribute("req","N" );
      ((Element)v.get(269)).setAttribute("valorinicial","" );
      ((Element)v.get(269)).setAttribute("textoinicial","" );
      ((Element)v.get(269)).setAttribute("ontab","setTabFocus('cbUN');" );
      ((Element)v.get(269)).setAttribute("onshtab","setSHTabFocus('cbUN');" );
      ((Element)v.get(268)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(269)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */
      /* Termina nodo:269   */
      /* Termina nodo:268   */

      /* Empieza nodo:271 / Elemento padre: 265   */
      v.add(doc.createElement("td"));
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(265)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(272)).setAttribute("src","b.gif" );
      ((Element)v.get(272)).setAttribute("width","25" );
      ((Element)v.get(272)).setAttribute("height","8" );
      ((Element)v.get(271)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */
      /* Termina nodo:271   */

      /* Empieza nodo:273 / Elemento padre: 265   */
      v.add(doc.createElement("td"));
      ((Element)v.get(273)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(265)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(274)).setAttribute("nombre","cbNeg" );
      ((Element)v.get(274)).setAttribute("id","datosCampos" );
      ((Element)v.get(274)).setAttribute("size","1" );
      ((Element)v.get(274)).setAttribute("multiple","N" );
      ((Element)v.get(274)).setAttribute("req","N" );
      ((Element)v.get(274)).setAttribute("valorinicial","" );
      ((Element)v.get(274)).setAttribute("textoinicial","" );
      ((Element)v.get(274)).setAttribute("ontab","setTabFocus('cbNeg');" );
      ((Element)v.get(274)).setAttribute("onshtab","setSHTabFocus('cbNeg');" );
      ((Element)v.get(273)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(274)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */
      /* Termina nodo:274   */
      /* Termina nodo:273   */

      /* Empieza nodo:276 / Elemento padre: 265   */
      v.add(doc.createElement("td"));
      ((Element)v.get(276)).setAttribute("width","100%" );
      ((Element)v.get(265)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(277)).setAttribute("src","b.gif" );
      ((Element)v.get(277)).setAttribute("width","8" );
      ((Element)v.get(277)).setAttribute("height","8" );
      ((Element)v.get(276)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */
      /* Termina nodo:276   */
      /* Termina nodo:265   */

      /* Empieza nodo:278 / Elemento padre: 253   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(253)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("td"));
      ((Element)v.get(279)).setAttribute("colspan","4" );
      ((Element)v.get(278)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(280)).setAttribute("src","b.gif" );
      ((Element)v.get(280)).setAttribute("width","8" );
      ((Element)v.get(280)).setAttribute("height","8" );
      ((Element)v.get(279)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */
      /* Termina nodo:279   */
      /* Termina nodo:278   */
      /* Termina nodo:253   */

      /* Empieza nodo:281 / Elemento padre: 143   */
      v.add(doc.createElement("table"));
      ((Element)v.get(281)).setAttribute("width","100%" );
      ((Element)v.get(281)).setAttribute("border","0" );
      ((Element)v.get(281)).setAttribute("align","center" );
      ((Element)v.get(281)).setAttribute("cellspacing","0" );
      ((Element)v.get(281)).setAttribute("cellpadding","0" );
      ((Element)v.get(143)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(281)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("td"));
      ((Element)v.get(282)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(284)).setAttribute("src","b.gif" );
      ((Element)v.get(284)).setAttribute("width","8" );
      ((Element)v.get(284)).setAttribute("height","8" );
      ((Element)v.get(283)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */
      /* Termina nodo:283   */

      /* Empieza nodo:285 / Elemento padre: 282   */
      v.add(doc.createElement("td"));
      ((Element)v.get(282)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(286)).setAttribute("nombre","lblGenerico" );
      ((Element)v.get(286)).setAttribute("alto","13" );
      ((Element)v.get(286)).setAttribute("filas","1" );
      ((Element)v.get(286)).setAttribute("valor","" );
      ((Element)v.get(286)).setAttribute("id","datosTitle" );
      ((Element)v.get(286)).setAttribute("cod","589" );
      ((Element)v.get(285)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */
      /* Termina nodo:285   */

      /* Empieza nodo:287 / Elemento padre: 282   */
      v.add(doc.createElement("td"));
      ((Element)v.get(282)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(288)).setAttribute("src","b.gif" );
      ((Element)v.get(288)).setAttribute("width","25" );
      ((Element)v.get(288)).setAttribute("height","8" );
      ((Element)v.get(287)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */
      /* Termina nodo:287   */

      /* Empieza nodo:289 / Elemento padre: 282   */
      v.add(doc.createElement("td"));
      ((Element)v.get(282)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(290)).setAttribute("nombre","lblSupergenerico" );
      ((Element)v.get(290)).setAttribute("alto","13" );
      ((Element)v.get(290)).setAttribute("filas","1" );
      ((Element)v.get(290)).setAttribute("valor","" );
      ((Element)v.get(290)).setAttribute("id","datosTitle" );
      ((Element)v.get(290)).setAttribute("cod","590" );
      ((Element)v.get(289)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */
      /* Termina nodo:289   */

      /* Empieza nodo:291 / Elemento padre: 282   */
      v.add(doc.createElement("td"));
      ((Element)v.get(291)).setAttribute("width","100%" );
      ((Element)v.get(282)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(292)).setAttribute("src","b.gif" );
      ((Element)v.get(292)).setAttribute("width","8" );
      ((Element)v.get(292)).setAttribute("height","8" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(291)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */
      /* Termina nodo:291   */
      /* Termina nodo:282   */

      /* Empieza nodo:293 / Elemento padre: 281   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(281)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("td"));
      ((Element)v.get(293)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(295)).setAttribute("src","b.gif" );
      ((Element)v.get(295)).setAttribute("width","8" );
      ((Element)v.get(295)).setAttribute("height","8" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */
      /* Termina nodo:294   */

      /* Empieza nodo:296 / Elemento padre: 293   */
      v.add(doc.createElement("td"));
      ((Element)v.get(296)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(293)).appendChild((Element)v.get(296));

      /* Empieza nodo:297 / Elemento padre: 296   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(297)).setAttribute("nombre","cbGenr" );
      ((Element)v.get(297)).setAttribute("id","datosCampos" );
      ((Element)v.get(297)).setAttribute("size","1" );
      ((Element)v.get(297)).setAttribute("multiple","N" );
      ((Element)v.get(297)).setAttribute("req","N" );
      ((Element)v.get(297)).setAttribute("valorinicial","" );
      ((Element)v.get(297)).setAttribute("textoinicial","" );
      ((Element)v.get(297)).setAttribute("ontab","setTabFocus('cbGenr');" );
      ((Element)v.get(297)).setAttribute("onshtab","setSHTabFocus('cbGenr');" );
      ((Element)v.get(296)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(297)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */
      /* Termina nodo:297   */
      /* Termina nodo:296   */

      /* Empieza nodo:299 / Elemento padre: 293   */
      v.add(doc.createElement("td"));
      ((Element)v.get(293)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(300)).setAttribute("src","b.gif" );
      ((Element)v.get(300)).setAttribute("width","25" );
      ((Element)v.get(300)).setAttribute("height","8" );
      ((Element)v.get(299)).appendChild((Element)v.get(300));
      /* Termina nodo:300   */
      /* Termina nodo:299   */

      /* Empieza nodo:301 / Elemento padre: 293   */
      v.add(doc.createElement("td"));
      ((Element)v.get(301)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(293)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(302)).setAttribute("nombre","cbSuperGeg" );
      ((Element)v.get(302)).setAttribute("id","datosCampos" );
      ((Element)v.get(302)).setAttribute("size","1" );
      ((Element)v.get(302)).setAttribute("multiple","N" );
      ((Element)v.get(302)).setAttribute("req","N" );
      ((Element)v.get(302)).setAttribute("valorinicial","" );
      ((Element)v.get(302)).setAttribute("textoinicial","" );
      ((Element)v.get(302)).setAttribute("ontab","setTabFocus('cbSuperGeg');" );
      ((Element)v.get(302)).setAttribute("onshtab","setSHTabFocus('cbSuperGeg');" );
      ((Element)v.get(301)).appendChild((Element)v.get(302));

      /* Empieza nodo:303 / Elemento padre: 302   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(302)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */
      /* Termina nodo:302   */
      /* Termina nodo:301   */

      /* Empieza nodo:304 / Elemento padre: 293   */
      v.add(doc.createElement("td"));
      ((Element)v.get(304)).setAttribute("width","100%" );
      ((Element)v.get(293)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(305)).setAttribute("src","b.gif" );
      ((Element)v.get(305)).setAttribute("width","8" );
      ((Element)v.get(305)).setAttribute("height","8" );
      ((Element)v.get(304)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */
      /* Termina nodo:304   */
      /* Termina nodo:293   */

      /* Empieza nodo:306 / Elemento padre: 281   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(281)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("td"));
      ((Element)v.get(307)).setAttribute("colspan","4" );
      ((Element)v.get(306)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(308)).setAttribute("src","b.gif" );
      ((Element)v.get(308)).setAttribute("width","8" );
      ((Element)v.get(308)).setAttribute("height","8" );
      ((Element)v.get(307)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */
      /* Termina nodo:307   */
      /* Termina nodo:306   */
      /* Termina nodo:281   */

      /* Empieza nodo:309 / Elemento padre: 143   */
      v.add(doc.createElement("table"));
      ((Element)v.get(309)).setAttribute("width","100%" );
      ((Element)v.get(309)).setAttribute("border","0" );
      ((Element)v.get(309)).setAttribute("align","center" );
      ((Element)v.get(309)).setAttribute("cellspacing","0" );
      ((Element)v.get(309)).setAttribute("cellpadding","0" );
      ((Element)v.get(143)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(309)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("td"));
      ((Element)v.get(310)).appendChild((Element)v.get(311));

      /* Empieza nodo:312 / Elemento padre: 311   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(312)).setAttribute("src","b.gif" );
      ((Element)v.get(312)).setAttribute("width","8" );
      ((Element)v.get(312)).setAttribute("height","8" );
      ((Element)v.get(311)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */
      /* Termina nodo:311   */

      /* Empieza nodo:313 / Elemento padre: 310   */
      v.add(doc.createElement("td"));
      ((Element)v.get(310)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(314)).setAttribute("nombre","lblJerar1" );
      ((Element)v.get(314)).setAttribute("alto","13" );
      ((Element)v.get(314)).setAttribute("filas","1" );
      ((Element)v.get(314)).setAttribute("valor","" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(314)).setAttribute("id","datosTitle" );
      ((Element)v.get(314)).setAttribute("cod","1088" );
      ((Element)v.get(313)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */
      /* Termina nodo:313   */

      /* Empieza nodo:315 / Elemento padre: 310   */
      v.add(doc.createElement("td"));
      ((Element)v.get(310)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(316)).setAttribute("src","b.gif" );
      ((Element)v.get(316)).setAttribute("width","25" );
      ((Element)v.get(316)).setAttribute("height","8" );
      ((Element)v.get(315)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */
      /* Termina nodo:315   */

      /* Empieza nodo:317 / Elemento padre: 310   */
      v.add(doc.createElement("td"));
      ((Element)v.get(310)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(318)).setAttribute("nombre","lblJerar2" );
      ((Element)v.get(318)).setAttribute("alto","13" );
      ((Element)v.get(318)).setAttribute("filas","1" );
      ((Element)v.get(318)).setAttribute("valor","" );
      ((Element)v.get(318)).setAttribute("id","datosTitle" );
      ((Element)v.get(318)).setAttribute("cod","1089" );
      ((Element)v.get(317)).appendChild((Element)v.get(318));
      /* Termina nodo:318   */
      /* Termina nodo:317   */

      /* Empieza nodo:319 / Elemento padre: 310   */
      v.add(doc.createElement("td"));
      ((Element)v.get(310)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(320)).setAttribute("src","b.gif" );
      ((Element)v.get(320)).setAttribute("width","25" );
      ((Element)v.get(320)).setAttribute("height","8" );
      ((Element)v.get(319)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */
      /* Termina nodo:319   */

      /* Empieza nodo:321 / Elemento padre: 310   */
      v.add(doc.createElement("td"));
      ((Element)v.get(310)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(322)).setAttribute("nombre","lblJerar3" );
      ((Element)v.get(322)).setAttribute("alto","13" );
      ((Element)v.get(322)).setAttribute("filas","1" );
      ((Element)v.get(322)).setAttribute("valor","" );
      ((Element)v.get(322)).setAttribute("id","datosTitle" );
      ((Element)v.get(322)).setAttribute("cod","1090" );
      ((Element)v.get(321)).appendChild((Element)v.get(322));
      /* Termina nodo:322   */
      /* Termina nodo:321   */

      /* Empieza nodo:323 / Elemento padre: 310   */
      v.add(doc.createElement("td"));
      ((Element)v.get(310)).appendChild((Element)v.get(323));

      /* Empieza nodo:324 / Elemento padre: 323   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(324)).setAttribute("src","b.gif" );
      ((Element)v.get(324)).setAttribute("width","25" );
      ((Element)v.get(324)).setAttribute("height","8" );
      ((Element)v.get(323)).appendChild((Element)v.get(324));
      /* Termina nodo:324   */
      /* Termina nodo:323   */

      /* Empieza nodo:325 / Elemento padre: 310   */
      v.add(doc.createElement("td"));
      ((Element)v.get(310)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(326)).setAttribute("nombre","lblLinea" );
      ((Element)v.get(326)).setAttribute("alto","13" );
      ((Element)v.get(326)).setAttribute("filas","1" );
      ((Element)v.get(326)).setAttribute("valor","" );
      ((Element)v.get(326)).setAttribute("id","datosTitle" );
      ((Element)v.get(326)).setAttribute("cod","586" );
      ((Element)v.get(325)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */
      /* Termina nodo:325   */

      /* Empieza nodo:327 / Elemento padre: 310   */
      v.add(doc.createElement("td"));
      ((Element)v.get(327)).setAttribute("width","100%" );
      ((Element)v.get(310)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(328)).setAttribute("src","b.gif" );
      ((Element)v.get(328)).setAttribute("width","8" );
      ((Element)v.get(328)).setAttribute("height","8" );
      ((Element)v.get(327)).appendChild((Element)v.get(328));
      /* Termina nodo:328   */
      /* Termina nodo:327   */
      /* Termina nodo:310   */

      /* Empieza nodo:329 / Elemento padre: 309   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(309)).appendChild((Element)v.get(329));

      /* Empieza nodo:330 / Elemento padre: 329   */
      v.add(doc.createElement("td"));
      ((Element)v.get(329)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(331)).setAttribute("src","b.gif" );
      ((Element)v.get(331)).setAttribute("width","8" );
      ((Element)v.get(331)).setAttribute("height","8" );
      ((Element)v.get(330)).appendChild((Element)v.get(331));
      /* Termina nodo:331   */
      /* Termina nodo:330   */

      /* Empieza nodo:332 / Elemento padre: 329   */
      v.add(doc.createElement("td"));
      ((Element)v.get(332)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(329)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(333)).setAttribute("nombre","txtJ1" );
      ((Element)v.get(333)).setAttribute("id","datosCampos" );
      ((Element)v.get(333)).setAttribute("max","3" );
      ((Element)v.get(333)).setAttribute("tipo","" );
      ((Element)v.get(333)).setAttribute("onchange","" );
      ((Element)v.get(333)).setAttribute("req","N" );
      ((Element)v.get(333)).setAttribute("size","3" );
      ((Element)v.get(333)).setAttribute("valor","" );
      ((Element)v.get(333)).setAttribute("validacion","" );
      ((Element)v.get(333)).setAttribute("ontab","setTabFocus('txtJ1');" );
      ((Element)v.get(333)).setAttribute("onshtab","setSHTabFocus('txtJ1');" );
      ((Element)v.get(332)).appendChild((Element)v.get(333));
      /* Termina nodo:333   */
      /* Termina nodo:332   */

      /* Empieza nodo:334 / Elemento padre: 329   */
      v.add(doc.createElement("td"));
      ((Element)v.get(329)).appendChild((Element)v.get(334));

      /* Empieza nodo:335 / Elemento padre: 334   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(335)).setAttribute("src","b.gif" );
      ((Element)v.get(335)).setAttribute("width","25" );
      ((Element)v.get(335)).setAttribute("height","8" );
      ((Element)v.get(334)).appendChild((Element)v.get(335));
      /* Termina nodo:335   */
      /* Termina nodo:334   */

      /* Empieza nodo:336 / Elemento padre: 329   */
      v.add(doc.createElement("td"));
      ((Element)v.get(336)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(329)).appendChild((Element)v.get(336));

      /* Empieza nodo:337 / Elemento padre: 336   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(337)).setAttribute("nombre","txtJ2" );
      ((Element)v.get(337)).setAttribute("id","datosCampos" );
      ((Element)v.get(337)).setAttribute("max","3" );
      ((Element)v.get(337)).setAttribute("tipo","" );
      ((Element)v.get(337)).setAttribute("onchange","" );
      ((Element)v.get(337)).setAttribute("req","N" );
      ((Element)v.get(337)).setAttribute("size","3" );
      ((Element)v.get(337)).setAttribute("valor","" );
      ((Element)v.get(337)).setAttribute("validacion","" );
      ((Element)v.get(337)).setAttribute("ontab","setTabFocus('txtJ2');" );
      ((Element)v.get(337)).setAttribute("onshtab","setSHTabFocus('txtJ2');" );
      ((Element)v.get(336)).appendChild((Element)v.get(337));
      /* Termina nodo:337   */
      /* Termina nodo:336   */

      /* Empieza nodo:338 / Elemento padre: 329   */
      v.add(doc.createElement("td"));
      ((Element)v.get(329)).appendChild((Element)v.get(338));

      /* Empieza nodo:339 / Elemento padre: 338   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(339)).setAttribute("src","b.gif" );
      ((Element)v.get(339)).setAttribute("width","25" );
      ((Element)v.get(339)).setAttribute("height","8" );
      ((Element)v.get(338)).appendChild((Element)v.get(339));
      /* Termina nodo:339   */
      /* Termina nodo:338   */

      /* Empieza nodo:340 / Elemento padre: 329   */
      v.add(doc.createElement("td"));
      ((Element)v.get(340)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(329)).appendChild((Element)v.get(340));

      /* Empieza nodo:341 / Elemento padre: 340   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(341)).setAttribute("nombre","txtJ3" );
      ((Element)v.get(341)).setAttribute("id","datosCampos" );
      ((Element)v.get(341)).setAttribute("max","3" );
      ((Element)v.get(341)).setAttribute("tipo","" );
      ((Element)v.get(341)).setAttribute("onchange","" );
      ((Element)v.get(341)).setAttribute("req","N" );
      ((Element)v.get(341)).setAttribute("size","3" );
      ((Element)v.get(341)).setAttribute("valor","" );
      ((Element)v.get(341)).setAttribute("validacion","" );
      ((Element)v.get(341)).setAttribute("ontab","setTabFocus('txtJ3');" );
      ((Element)v.get(341)).setAttribute("onshtab","setSHTabFocus('txtJ3');" );
      ((Element)v.get(340)).appendChild((Element)v.get(341));
      /* Termina nodo:341   */
      /* Termina nodo:340   */

      /* Empieza nodo:342 / Elemento padre: 329   */
      v.add(doc.createElement("td"));
      ((Element)v.get(329)).appendChild((Element)v.get(342));

      /* Empieza nodo:343 / Elemento padre: 342   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(343)).setAttribute("src","b.gif" );
      ((Element)v.get(343)).setAttribute("width","25" );
      ((Element)v.get(343)).setAttribute("height","8" );
      ((Element)v.get(342)).appendChild((Element)v.get(343));
      /* Termina nodo:343   */
      /* Termina nodo:342   */

      /* Empieza nodo:344 / Elemento padre: 329   */
      v.add(doc.createElement("td"));
      ((Element)v.get(344)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(329)).appendChild((Element)v.get(344));

      /* Empieza nodo:345 / Elemento padre: 344   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(345)).setAttribute("nombre","cbLin" );
      ((Element)v.get(345)).setAttribute("id","datosCampos" );
      ((Element)v.get(345)).setAttribute("size","1" );
      ((Element)v.get(345)).setAttribute("multiple","N" );
      ((Element)v.get(345)).setAttribute("req","N" );
      ((Element)v.get(345)).setAttribute("valorinicial","" );
      ((Element)v.get(345)).setAttribute("textoinicial","" );
      ((Element)v.get(345)).setAttribute("ontab","setTabFocus('cbLin');" );
      ((Element)v.get(345)).setAttribute("onshtab","setSHTabFocus('cbLin');" );
      ((Element)v.get(344)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(345)).appendChild((Element)v.get(346));
      /* Termina nodo:346   */
      /* Termina nodo:345   */
      /* Termina nodo:344   */

      /* Empieza nodo:347 / Elemento padre: 329   */
      v.add(doc.createElement("td"));
      ((Element)v.get(347)).setAttribute("width","100%" );
      ((Element)v.get(329)).appendChild((Element)v.get(347));

      /* Empieza nodo:348 / Elemento padre: 347   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(348)).setAttribute("src","b.gif" );
      ((Element)v.get(348)).setAttribute("width","8" );
      ((Element)v.get(348)).setAttribute("height","8" );
      ((Element)v.get(347)).appendChild((Element)v.get(348));
      /* Termina nodo:348   */
      /* Termina nodo:347   */
      /* Termina nodo:329   */

      /* Empieza nodo:349 / Elemento padre: 309   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(309)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("td"));
      ((Element)v.get(350)).setAttribute("colspan","4" );
      ((Element)v.get(349)).appendChild((Element)v.get(350));

      /* Empieza nodo:351 / Elemento padre: 350   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(351)).setAttribute("src","b.gif" );
      ((Element)v.get(351)).setAttribute("width","8" );
      ((Element)v.get(351)).setAttribute("height","8" );
      ((Element)v.get(350)).appendChild((Element)v.get(351));
      /* Termina nodo:351   */
      /* Termina nodo:350   */
      /* Termina nodo:349   */
      /* Termina nodo:309   */

      /* Empieza nodo:352 / Elemento padre: 143   */
      v.add(doc.createElement("table"));
      ((Element)v.get(352)).setAttribute("width","100%" );
      ((Element)v.get(352)).setAttribute("border","0" );
      ((Element)v.get(352)).setAttribute("align","center" );
      ((Element)v.get(352)).setAttribute("cellspacing","0" );
      ((Element)v.get(352)).setAttribute("cellpadding","0" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(143)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(352)).appendChild((Element)v.get(353));

      /* Empieza nodo:354 / Elemento padre: 353   */
      v.add(doc.createElement("td"));
      ((Element)v.get(353)).appendChild((Element)v.get(354));

      /* Empieza nodo:355 / Elemento padre: 354   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(355)).setAttribute("src","b.gif" );
      ((Element)v.get(355)).setAttribute("width","8" );
      ((Element)v.get(355)).setAttribute("height","8" );
      ((Element)v.get(354)).appendChild((Element)v.get(355));
      /* Termina nodo:355   */
      /* Termina nodo:354   */

      /* Empieza nodo:356 / Elemento padre: 353   */
      v.add(doc.createElement("td"));
      ((Element)v.get(353)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(357)).setAttribute("nombre","lblAtrib1" );
      ((Element)v.get(357)).setAttribute("alto","13" );
      ((Element)v.get(357)).setAttribute("filas","1" );
      ((Element)v.get(357)).setAttribute("valor","" );
      ((Element)v.get(357)).setAttribute("id","datosTitle" );
      ((Element)v.get(357)).setAttribute("cod","481" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */
      /* Termina nodo:356   */

      /* Empieza nodo:358 / Elemento padre: 353   */
      v.add(doc.createElement("td"));
      ((Element)v.get(353)).appendChild((Element)v.get(358));

      /* Empieza nodo:359 / Elemento padre: 358   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(359)).setAttribute("src","b.gif" );
      ((Element)v.get(359)).setAttribute("width","25" );
      ((Element)v.get(359)).setAttribute("height","8" );
      ((Element)v.get(358)).appendChild((Element)v.get(359));
      /* Termina nodo:359   */
      /* Termina nodo:358   */

      /* Empieza nodo:360 / Elemento padre: 353   */
      v.add(doc.createElement("td"));
      ((Element)v.get(353)).appendChild((Element)v.get(360));

      /* Empieza nodo:361 / Elemento padre: 360   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(361)).setAttribute("nombre","lblAtrib2" );
      ((Element)v.get(361)).setAttribute("alto","13" );
      ((Element)v.get(361)).setAttribute("filas","1" );
      ((Element)v.get(361)).setAttribute("valor","" );
      ((Element)v.get(361)).setAttribute("id","datosTitle" );
      ((Element)v.get(361)).setAttribute("cod","482" );
      ((Element)v.get(360)).appendChild((Element)v.get(361));
      /* Termina nodo:361   */
      /* Termina nodo:360   */

      /* Empieza nodo:362 / Elemento padre: 353   */
      v.add(doc.createElement("td"));
      ((Element)v.get(353)).appendChild((Element)v.get(362));

      /* Empieza nodo:363 / Elemento padre: 362   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(363)).setAttribute("src","b.gif" );
      ((Element)v.get(363)).setAttribute("width","25" );
      ((Element)v.get(363)).setAttribute("height","8" );
      ((Element)v.get(362)).appendChild((Element)v.get(363));
      /* Termina nodo:363   */
      /* Termina nodo:362   */

      /* Empieza nodo:364 / Elemento padre: 353   */
      v.add(doc.createElement("td"));
      ((Element)v.get(353)).appendChild((Element)v.get(364));

      /* Empieza nodo:365 / Elemento padre: 364   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(365)).setAttribute("nombre","lblAtrib3" );
      ((Element)v.get(365)).setAttribute("alto","13" );
      ((Element)v.get(365)).setAttribute("filas","1" );
      ((Element)v.get(365)).setAttribute("valor","" );
      ((Element)v.get(365)).setAttribute("id","datosTitle" );
      ((Element)v.get(365)).setAttribute("cod","483" );
      ((Element)v.get(364)).appendChild((Element)v.get(365));
      /* Termina nodo:365   */
      /* Termina nodo:364   */

      /* Empieza nodo:366 / Elemento padre: 353   */
      v.add(doc.createElement("td"));
      ((Element)v.get(366)).setAttribute("width","100%" );
      ((Element)v.get(353)).appendChild((Element)v.get(366));

      /* Empieza nodo:367 / Elemento padre: 366   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(367)).setAttribute("src","b.gif" );
      ((Element)v.get(367)).setAttribute("width","8" );
      ((Element)v.get(367)).setAttribute("height","8" );
      ((Element)v.get(366)).appendChild((Element)v.get(367));
      /* Termina nodo:367   */
      /* Termina nodo:366   */
      /* Termina nodo:353   */

      /* Empieza nodo:368 / Elemento padre: 352   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(352)).appendChild((Element)v.get(368));

      /* Empieza nodo:369 / Elemento padre: 368   */
      v.add(doc.createElement("td"));
      ((Element)v.get(368)).appendChild((Element)v.get(369));

      /* Empieza nodo:370 / Elemento padre: 369   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(370)).setAttribute("src","b.gif" );
      ((Element)v.get(370)).setAttribute("width","8" );
      ((Element)v.get(370)).setAttribute("height","8" );
      ((Element)v.get(369)).appendChild((Element)v.get(370));
      /* Termina nodo:370   */
      /* Termina nodo:369   */

      /* Empieza nodo:371 / Elemento padre: 368   */
      v.add(doc.createElement("td"));
      ((Element)v.get(371)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(368)).appendChild((Element)v.get(371));

      /* Empieza nodo:372 / Elemento padre: 371   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(372)).setAttribute("nombre","txtA1" );
      ((Element)v.get(372)).setAttribute("id","datosCampos" );
      ((Element)v.get(372)).setAttribute("max","3" );
      ((Element)v.get(372)).setAttribute("tipo","" );
      ((Element)v.get(372)).setAttribute("onchange","" );
      ((Element)v.get(372)).setAttribute("req","N" );
      ((Element)v.get(372)).setAttribute("size","3" );
      ((Element)v.get(372)).setAttribute("valor","" );
      ((Element)v.get(372)).setAttribute("validacion","" );
      ((Element)v.get(372)).setAttribute("ontab","setTabFocus('txtA1');" );
      ((Element)v.get(372)).setAttribute("onshtab","setSHTabFocus('txtA1');" );
      ((Element)v.get(371)).appendChild((Element)v.get(372));
      /* Termina nodo:372   */
      /* Termina nodo:371   */

      /* Empieza nodo:373 / Elemento padre: 368   */
      v.add(doc.createElement("td"));
      ((Element)v.get(368)).appendChild((Element)v.get(373));

      /* Empieza nodo:374 / Elemento padre: 373   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(374)).setAttribute("src","b.gif" );
      ((Element)v.get(374)).setAttribute("width","25" );
      ((Element)v.get(374)).setAttribute("height","8" );
      ((Element)v.get(373)).appendChild((Element)v.get(374));
      /* Termina nodo:374   */
      /* Termina nodo:373   */

      /* Empieza nodo:375 / Elemento padre: 368   */
      v.add(doc.createElement("td"));
      ((Element)v.get(375)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(368)).appendChild((Element)v.get(375));

      /* Empieza nodo:376 / Elemento padre: 375   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(376)).setAttribute("nombre","txtA2" );
      ((Element)v.get(376)).setAttribute("id","datosCampos" );
      ((Element)v.get(376)).setAttribute("max","4" );
      ((Element)v.get(376)).setAttribute("tipo","" );
      ((Element)v.get(376)).setAttribute("onchange","" );
      ((Element)v.get(376)).setAttribute("req","N" );
      ((Element)v.get(376)).setAttribute("size","4" );
      ((Element)v.get(376)).setAttribute("valor","" );
      ((Element)v.get(376)).setAttribute("validacion","" );
      ((Element)v.get(376)).setAttribute("ontab","setTabFocus('txtA2');" );
      ((Element)v.get(376)).setAttribute("onshtab","setSHTabFocus('txtA2');" );
      ((Element)v.get(375)).appendChild((Element)v.get(376));
      /* Termina nodo:376   */
      /* Termina nodo:375   */

      /* Empieza nodo:377 / Elemento padre: 368   */
      v.add(doc.createElement("td"));
      ((Element)v.get(368)).appendChild((Element)v.get(377));

      /* Empieza nodo:378 / Elemento padre: 377   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(378)).setAttribute("src","b.gif" );
      ((Element)v.get(378)).setAttribute("width","25" );
      ((Element)v.get(378)).setAttribute("height","8" );
      ((Element)v.get(377)).appendChild((Element)v.get(378));
      /* Termina nodo:378   */
      /* Termina nodo:377   */

      /* Empieza nodo:379 / Elemento padre: 368   */
      v.add(doc.createElement("td"));
      ((Element)v.get(379)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(368)).appendChild((Element)v.get(379));

      /* Empieza nodo:380 / Elemento padre: 379   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(380)).setAttribute("nombre","txtA3" );
      ((Element)v.get(380)).setAttribute("id","datosCampos" );
      ((Element)v.get(380)).setAttribute("max","10" );
      ((Element)v.get(380)).setAttribute("tipo","" );
      ((Element)v.get(380)).setAttribute("onchange","" );
      ((Element)v.get(380)).setAttribute("req","N" );
      ((Element)v.get(380)).setAttribute("size","12" );
      ((Element)v.get(380)).setAttribute("valor","" );
      ((Element)v.get(380)).setAttribute("validacion","" );
      ((Element)v.get(380)).setAttribute("ontab","setTabFocus('txtA3');" );
      ((Element)v.get(380)).setAttribute("onshtab","setSHTabFocus('txtA3');" );
      ((Element)v.get(379)).appendChild((Element)v.get(380));
      /* Termina nodo:380   */
      /* Termina nodo:379   */

      /* Empieza nodo:381 / Elemento padre: 368   */
      v.add(doc.createElement("td"));
      ((Element)v.get(381)).setAttribute("width","100%" );
      ((Element)v.get(368)).appendChild((Element)v.get(381));

      /* Empieza nodo:382 / Elemento padre: 381   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(382)).setAttribute("src","b.gif" );
      ((Element)v.get(382)).setAttribute("width","8" );
      ((Element)v.get(382)).setAttribute("height","8" );
      ((Element)v.get(381)).appendChild((Element)v.get(382));
      /* Termina nodo:382   */
      /* Termina nodo:381   */
      /* Termina nodo:368   */

      /* Empieza nodo:383 / Elemento padre: 352   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(352)).appendChild((Element)v.get(383));

      /* Empieza nodo:384 / Elemento padre: 383   */
      v.add(doc.createElement("td"));
      ((Element)v.get(384)).setAttribute("colspan","4" );
      ((Element)v.get(383)).appendChild((Element)v.get(384));

      /* Empieza nodo:385 / Elemento padre: 384   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(385)).setAttribute("src","b.gif" );
      ((Element)v.get(385)).setAttribute("width","8" );
      ((Element)v.get(385)).setAttribute("height","8" );
      ((Element)v.get(384)).appendChild((Element)v.get(385));
      /* Termina nodo:385   */
      /* Termina nodo:384   */
      /* Termina nodo:383   */
      /* Termina nodo:352   */

      /* Empieza nodo:386 / Elemento padre: 143   */
      v.add(doc.createElement("table"));
      ((Element)v.get(386)).setAttribute("width","100%" );
      ((Element)v.get(386)).setAttribute("border","0" );
      ((Element)v.get(386)).setAttribute("align","center" );
      ((Element)v.get(386)).setAttribute("cellspacing","0" );
      ((Element)v.get(386)).setAttribute("cellpadding","0" );
      ((Element)v.get(143)).appendChild((Element)v.get(386));

      /* Empieza nodo:387 / Elemento padre: 386   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(386)).appendChild((Element)v.get(387));

      /* Empieza nodo:388 / Elemento padre: 387   */
      v.add(doc.createElement("td"));
      ((Element)v.get(387)).appendChild((Element)v.get(388));

      /* Empieza nodo:389 / Elemento padre: 388   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(389)).setAttribute("src","b.gif" );
      ((Element)v.get(389)).setAttribute("width","8" );
      ((Element)v.get(389)).setAttribute("height","8" );
      ((Element)v.get(388)).appendChild((Element)v.get(389));
      /* Termina nodo:389   */
      /* Termina nodo:388   */

      /* Empieza nodo:390 / Elemento padre: 387   */
      v.add(doc.createElement("td"));
      ((Element)v.get(387)).appendChild((Element)v.get(390));

      /* Empieza nodo:391 / Elemento padre: 390   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(391)).setAttribute("nombre","lblAlto" );
      ((Element)v.get(391)).setAttribute("alto","13" );
      ((Element)v.get(391)).setAttribute("filas","1" );
      ((Element)v.get(391)).setAttribute("valor","" );
      ((Element)v.get(391)).setAttribute("id","datosTitle" );
      ((Element)v.get(391)).setAttribute("cod","1070" );
      ((Element)v.get(390)).appendChild((Element)v.get(391));
      /* Termina nodo:391   */
      /* Termina nodo:390   */

      /* Empieza nodo:392 / Elemento padre: 387   */
      v.add(doc.createElement("td"));
      ((Element)v.get(387)).appendChild((Element)v.get(392));

      /* Empieza nodo:393 / Elemento padre: 392   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(393)).setAttribute("src","b.gif" );
      ((Element)v.get(393)).setAttribute("width","25" );
      ((Element)v.get(393)).setAttribute("height","8" );
      ((Element)v.get(392)).appendChild((Element)v.get(393));
      /* Termina nodo:393   */
      /* Termina nodo:392   */

      /* Empieza nodo:394 / Elemento padre: 387   */
      v.add(doc.createElement("td"));
      ((Element)v.get(387)).appendChild((Element)v.get(394));

      /* Empieza nodo:395 / Elemento padre: 394   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(395)).setAttribute("nombre","lblLargo" );
      ((Element)v.get(395)).setAttribute("alto","13" );
      ((Element)v.get(395)).setAttribute("filas","1" );
      ((Element)v.get(395)).setAttribute("valor","" );
      ((Element)v.get(395)).setAttribute("id","datosTitle" );
      ((Element)v.get(395)).setAttribute("cod","1071" );
      ((Element)v.get(394)).appendChild((Element)v.get(395));
      /* Termina nodo:395   */
      /* Termina nodo:394   */

      /* Empieza nodo:396 / Elemento padre: 387   */
      v.add(doc.createElement("td"));
      ((Element)v.get(387)).appendChild((Element)v.get(396));

      /* Empieza nodo:397 / Elemento padre: 396   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(397)).setAttribute("src","b.gif" );
      ((Element)v.get(397)).setAttribute("width","25" );
      ((Element)v.get(397)).setAttribute("height","8" );
      ((Element)v.get(396)).appendChild((Element)v.get(397));
      /* Termina nodo:397   */
      /* Termina nodo:396   */

      /* Empieza nodo:398 / Elemento padre: 387   */
      v.add(doc.createElement("td"));
      ((Element)v.get(387)).appendChild((Element)v.get(398));

      /* Empieza nodo:399 / Elemento padre: 398   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(399)).setAttribute("nombre","lblAncho" );
      ((Element)v.get(399)).setAttribute("alto","13" );
      ((Element)v.get(399)).setAttribute("filas","1" );
      ((Element)v.get(399)).setAttribute("valor","" );
      ((Element)v.get(399)).setAttribute("id","datosTitle" );
      ((Element)v.get(399)).setAttribute("cod","1072" );
      ((Element)v.get(398)).appendChild((Element)v.get(399));
      /* Termina nodo:399   */
      /* Termina nodo:398   */

      /* Empieza nodo:400 / Elemento padre: 387   */
      v.add(doc.createElement("td"));
      ((Element)v.get(387)).appendChild((Element)v.get(400));

      /* Empieza nodo:401 / Elemento padre: 400   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(401)).setAttribute("src","b.gif" );
      ((Element)v.get(401)).setAttribute("width","25" );
      ((Element)v.get(401)).setAttribute("height","8" );
      ((Element)v.get(400)).appendChild((Element)v.get(401));
      /* Termina nodo:401   */
      /* Termina nodo:400   */

      /* Empieza nodo:402 / Elemento padre: 387   */
      v.add(doc.createElement("td"));
      ((Element)v.get(387)).appendChild((Element)v.get(402));

      /* Empieza nodo:403 / Elemento padre: 402   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(403)).setAttribute("nombre","lblMedidaDimensiones" );
      ((Element)v.get(403)).setAttribute("alto","13" );
      ((Element)v.get(403)).setAttribute("filas","1" );
      ((Element)v.get(403)).setAttribute("valor","" );
      ((Element)v.get(403)).setAttribute("id","datosTitle" );
      ((Element)v.get(403)).setAttribute("cod","1133" );
      ((Element)v.get(402)).appendChild((Element)v.get(403));
      /* Termina nodo:403   */
      /* Termina nodo:402   */

      /* Empieza nodo:404 / Elemento padre: 387   */
      v.add(doc.createElement("td"));
      ((Element)v.get(404)).setAttribute("width","100%" );
      ((Element)v.get(387)).appendChild((Element)v.get(404));

      /* Empieza nodo:405 / Elemento padre: 404   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(405)).setAttribute("src","b.gif" );
      ((Element)v.get(405)).setAttribute("width","8" );
      ((Element)v.get(405)).setAttribute("height","8" );
      ((Element)v.get(404)).appendChild((Element)v.get(405));
      /* Termina nodo:405   */
      /* Termina nodo:404   */
      /* Termina nodo:387   */

      /* Empieza nodo:406 / Elemento padre: 386   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(386)).appendChild((Element)v.get(406));

      /* Empieza nodo:407 / Elemento padre: 406   */
      v.add(doc.createElement("td"));
      ((Element)v.get(406)).appendChild((Element)v.get(407));

      /* Empieza nodo:408 / Elemento padre: 407   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(408)).setAttribute("src","b.gif" );
      ((Element)v.get(408)).setAttribute("width","8" );
      ((Element)v.get(408)).setAttribute("height","8" );
      ((Element)v.get(407)).appendChild((Element)v.get(408));
      /* Termina nodo:408   */
      /* Termina nodo:407   */

      /* Empieza nodo:409 / Elemento padre: 406   */
      v.add(doc.createElement("td"));
      ((Element)v.get(409)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(406)).appendChild((Element)v.get(409));

      /* Empieza nodo:410 / Elemento padre: 409   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(410)).setAttribute("nombre","txtDA" );
      ((Element)v.get(410)).setAttribute("id","datosCampos" );
      ((Element)v.get(410)).setAttribute("max","6" );
      ((Element)v.get(410)).setAttribute("tipo","" );
      ((Element)v.get(410)).setAttribute("onchange","" );
      ((Element)v.get(410)).setAttribute("req","N" );
      ((Element)v.get(410)).setAttribute("size","7" );
      ((Element)v.get(410)).setAttribute("valor","" );
      ((Element)v.get(410)).setAttribute("validacion","" );
      ((Element)v.get(410)).setAttribute("ontab","setTabFocus('txtDA');" );
      ((Element)v.get(410)).setAttribute("onshtab","setSHTabFocus('txtDA');" );
      ((Element)v.get(409)).appendChild((Element)v.get(410));
      /* Termina nodo:410   */
      /* Termina nodo:409   */

      /* Empieza nodo:411 / Elemento padre: 406   */
      v.add(doc.createElement("td"));
      ((Element)v.get(406)).appendChild((Element)v.get(411));

      /* Empieza nodo:412 / Elemento padre: 411   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(412)).setAttribute("src","b.gif" );
      ((Element)v.get(412)).setAttribute("width","25" );
      ((Element)v.get(412)).setAttribute("height","8" );
      ((Element)v.get(411)).appendChild((Element)v.get(412));
      /* Termina nodo:412   */
      /* Termina nodo:411   */

      /* Empieza nodo:413 / Elemento padre: 406   */
      v.add(doc.createElement("td"));
      ((Element)v.get(413)).setAttribute("nowrap","nowrap" );
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(406)).appendChild((Element)v.get(413));

      /* Empieza nodo:414 / Elemento padre: 413   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(414)).setAttribute("nombre","txtDL" );
      ((Element)v.get(414)).setAttribute("id","datosCampos" );
      ((Element)v.get(414)).setAttribute("max","6" );
      ((Element)v.get(414)).setAttribute("tipo","" );
      ((Element)v.get(414)).setAttribute("onchange","" );
      ((Element)v.get(414)).setAttribute("req","N" );
      ((Element)v.get(414)).setAttribute("size","7" );
      ((Element)v.get(414)).setAttribute("valor","" );
      ((Element)v.get(414)).setAttribute("validacion","" );
      ((Element)v.get(414)).setAttribute("ontab","setTabFocus('txtDL');" );
      ((Element)v.get(414)).setAttribute("onshtab","setSHTabFocus('txtDL');" );
      ((Element)v.get(413)).appendChild((Element)v.get(414));
      /* Termina nodo:414   */
      /* Termina nodo:413   */

      /* Empieza nodo:415 / Elemento padre: 406   */
      v.add(doc.createElement("td"));
      ((Element)v.get(406)).appendChild((Element)v.get(415));

      /* Empieza nodo:416 / Elemento padre: 415   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(416)).setAttribute("src","b.gif" );
      ((Element)v.get(416)).setAttribute("width","25" );
      ((Element)v.get(416)).setAttribute("height","8" );
      ((Element)v.get(415)).appendChild((Element)v.get(416));
      /* Termina nodo:416   */
      /* Termina nodo:415   */

      /* Empieza nodo:417 / Elemento padre: 406   */
      v.add(doc.createElement("td"));
      ((Element)v.get(417)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(406)).appendChild((Element)v.get(417));

      /* Empieza nodo:418 / Elemento padre: 417   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(418)).setAttribute("nombre","txtDAL" );
      ((Element)v.get(418)).setAttribute("id","datosCampos" );
      ((Element)v.get(418)).setAttribute("max","6" );
      ((Element)v.get(418)).setAttribute("tipo","" );
      ((Element)v.get(418)).setAttribute("onchange","" );
      ((Element)v.get(418)).setAttribute("req","N" );
      ((Element)v.get(418)).setAttribute("size","7" );
      ((Element)v.get(418)).setAttribute("valor","" );
      ((Element)v.get(418)).setAttribute("validacion","" );
      ((Element)v.get(418)).setAttribute("ontab","setTabFocus('txtDAL');" );
      ((Element)v.get(418)).setAttribute("onshtab","setSHTabFocus('txtDAL');" );
      ((Element)v.get(417)).appendChild((Element)v.get(418));
      /* Termina nodo:418   */
      /* Termina nodo:417   */

      /* Empieza nodo:419 / Elemento padre: 406   */
      v.add(doc.createElement("td"));
      ((Element)v.get(406)).appendChild((Element)v.get(419));

      /* Empieza nodo:420 / Elemento padre: 419   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(420)).setAttribute("src","b.gif" );
      ((Element)v.get(420)).setAttribute("width","25" );
      ((Element)v.get(420)).setAttribute("height","8" );
      ((Element)v.get(419)).appendChild((Element)v.get(420));
      /* Termina nodo:420   */
      /* Termina nodo:419   */

      /* Empieza nodo:421 / Elemento padre: 406   */
      v.add(doc.createElement("td"));
      ((Element)v.get(421)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(406)).appendChild((Element)v.get(421));

      /* Empieza nodo:422 / Elemento padre: 421   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(422)).setAttribute("nombre","cbUNMedidaDimensiones" );
      ((Element)v.get(422)).setAttribute("id","datosCampos" );
      ((Element)v.get(422)).setAttribute("size","1" );
      ((Element)v.get(422)).setAttribute("multiple","N" );
      ((Element)v.get(422)).setAttribute("req","N" );
      ((Element)v.get(422)).setAttribute("valorinicial","" );
      ((Element)v.get(422)).setAttribute("textoinicial","" );
      ((Element)v.get(422)).setAttribute("ontab","setTabFocus('cbUNMedidaDimensiones');" );
      ((Element)v.get(422)).setAttribute("onshtab","setSHTabFocus('cbUNMedidaDimensiones');" );
      ((Element)v.get(421)).appendChild((Element)v.get(422));

      /* Empieza nodo:423 / Elemento padre: 422   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(422)).appendChild((Element)v.get(423));
      /* Termina nodo:423   */
      /* Termina nodo:422   */
      /* Termina nodo:421   */

      /* Empieza nodo:424 / Elemento padre: 406   */
      v.add(doc.createElement("td"));
      ((Element)v.get(424)).setAttribute("width","100%" );
      ((Element)v.get(406)).appendChild((Element)v.get(424));

      /* Empieza nodo:425 / Elemento padre: 424   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(425)).setAttribute("src","b.gif" );
      ((Element)v.get(425)).setAttribute("width","8" );
      ((Element)v.get(425)).setAttribute("height","8" );
      ((Element)v.get(424)).appendChild((Element)v.get(425));
      /* Termina nodo:425   */
      /* Termina nodo:424   */
      /* Termina nodo:406   */

      /* Empieza nodo:426 / Elemento padre: 386   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(386)).appendChild((Element)v.get(426));

      /* Empieza nodo:427 / Elemento padre: 426   */
      v.add(doc.createElement("td"));
      ((Element)v.get(427)).setAttribute("colspan","4" );
      ((Element)v.get(426)).appendChild((Element)v.get(427));

      /* Empieza nodo:428 / Elemento padre: 427   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(428)).setAttribute("src","b.gif" );
      ((Element)v.get(428)).setAttribute("width","8" );
      ((Element)v.get(428)).setAttribute("height","8" );
      ((Element)v.get(427)).appendChild((Element)v.get(428));
      /* Termina nodo:428   */
      /* Termina nodo:427   */
      /* Termina nodo:426   */
      /* Termina nodo:386   */

      /* Empieza nodo:429 / Elemento padre: 143   */
      v.add(doc.createElement("table"));
      ((Element)v.get(429)).setAttribute("width","100%" );
      ((Element)v.get(429)).setAttribute("border","0" );
      ((Element)v.get(429)).setAttribute("align","center" );
      ((Element)v.get(429)).setAttribute("cellspacing","0" );
      ((Element)v.get(429)).setAttribute("cellpadding","0" );
      ((Element)v.get(143)).appendChild((Element)v.get(429));

      /* Empieza nodo:430 / Elemento padre: 429   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(429)).appendChild((Element)v.get(430));

      /* Empieza nodo:431 / Elemento padre: 430   */
      v.add(doc.createElement("td"));
      ((Element)v.get(430)).appendChild((Element)v.get(431));

      /* Empieza nodo:432 / Elemento padre: 431   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML1980(Document doc) {
      ((Element)v.get(432)).setAttribute("src","b.gif" );
      ((Element)v.get(432)).setAttribute("width","8" );
      ((Element)v.get(432)).setAttribute("height","8" );
      ((Element)v.get(431)).appendChild((Element)v.get(432));
      /* Termina nodo:432   */
      /* Termina nodo:431   */

      /* Empieza nodo:433 / Elemento padre: 430   */
      v.add(doc.createElement("td"));
      ((Element)v.get(430)).appendChild((Element)v.get(433));

      /* Empieza nodo:434 / Elemento padre: 433   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(434)).setAttribute("nombre","lblVolumen" );
      ((Element)v.get(434)).setAttribute("alto","13" );
      ((Element)v.get(434)).setAttribute("filas","1" );
      ((Element)v.get(434)).setAttribute("valor","" );
      ((Element)v.get(434)).setAttribute("id","datosTitle" );
      ((Element)v.get(434)).setAttribute("cod","1140" );
      ((Element)v.get(433)).appendChild((Element)v.get(434));
      /* Termina nodo:434   */
      /* Termina nodo:433   */

      /* Empieza nodo:435 / Elemento padre: 430   */
      v.add(doc.createElement("td"));
      ((Element)v.get(430)).appendChild((Element)v.get(435));

      /* Empieza nodo:436 / Elemento padre: 435   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(436)).setAttribute("src","b.gif" );
      ((Element)v.get(436)).setAttribute("width","25" );
      ((Element)v.get(436)).setAttribute("height","8" );
      ((Element)v.get(435)).appendChild((Element)v.get(436));
      /* Termina nodo:436   */
      /* Termina nodo:435   */

      /* Empieza nodo:437 / Elemento padre: 430   */
      v.add(doc.createElement("td"));
      ((Element)v.get(430)).appendChild((Element)v.get(437));

      /* Empieza nodo:438 / Elemento padre: 437   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(438)).setAttribute("nombre","lblMedidaVolumen" );
      ((Element)v.get(438)).setAttribute("alto","13" );
      ((Element)v.get(438)).setAttribute("filas","1" );
      ((Element)v.get(438)).setAttribute("valor","" );
      ((Element)v.get(438)).setAttribute("id","datosTitle" );
      ((Element)v.get(438)).setAttribute("cod","1135" );
      ((Element)v.get(437)).appendChild((Element)v.get(438));
      /* Termina nodo:438   */
      /* Termina nodo:437   */

      /* Empieza nodo:439 / Elemento padre: 430   */
      v.add(doc.createElement("td"));
      ((Element)v.get(439)).setAttribute("width","100%" );
      ((Element)v.get(430)).appendChild((Element)v.get(439));

      /* Empieza nodo:440 / Elemento padre: 439   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(440)).setAttribute("src","b.gif" );
      ((Element)v.get(440)).setAttribute("width","8" );
      ((Element)v.get(440)).setAttribute("height","8" );
      ((Element)v.get(439)).appendChild((Element)v.get(440));
      /* Termina nodo:440   */
      /* Termina nodo:439   */
      /* Termina nodo:430   */

      /* Empieza nodo:441 / Elemento padre: 429   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(429)).appendChild((Element)v.get(441));

      /* Empieza nodo:442 / Elemento padre: 441   */
      v.add(doc.createElement("td"));
      ((Element)v.get(441)).appendChild((Element)v.get(442));

      /* Empieza nodo:443 / Elemento padre: 442   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(443)).setAttribute("src","b.gif" );
      ((Element)v.get(443)).setAttribute("width","8" );
      ((Element)v.get(443)).setAttribute("height","8" );
      ((Element)v.get(442)).appendChild((Element)v.get(443));
      /* Termina nodo:443   */
      /* Termina nodo:442   */

      /* Empieza nodo:444 / Elemento padre: 441   */
      v.add(doc.createElement("td"));
      ((Element)v.get(444)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(441)).appendChild((Element)v.get(444));

      /* Empieza nodo:445 / Elemento padre: 444   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(445)).setAttribute("nombre","txtVoluA" );
      ((Element)v.get(445)).setAttribute("id","datosCampos" );
      ((Element)v.get(445)).setAttribute("max","6" );
      ((Element)v.get(445)).setAttribute("tipo","" );
      ((Element)v.get(445)).setAttribute("onchange","" );
      ((Element)v.get(445)).setAttribute("req","N" );
      ((Element)v.get(445)).setAttribute("size","13" );
      ((Element)v.get(445)).setAttribute("valor","" );
      ((Element)v.get(445)).setAttribute("validacion","" );
      ((Element)v.get(445)).setAttribute("ontab","setTabFocus('txtVoluA');" );
      ((Element)v.get(445)).setAttribute("onshtab","setSHTabFocus('txtVoluA');" );
      ((Element)v.get(444)).appendChild((Element)v.get(445));
      /* Termina nodo:445   */
      /* Termina nodo:444   */

      /* Empieza nodo:446 / Elemento padre: 441   */
      v.add(doc.createElement("td"));
      ((Element)v.get(441)).appendChild((Element)v.get(446));

      /* Empieza nodo:447 / Elemento padre: 446   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(447)).setAttribute("src","b.gif" );
      ((Element)v.get(447)).setAttribute("width","25" );
      ((Element)v.get(447)).setAttribute("height","8" );
      ((Element)v.get(446)).appendChild((Element)v.get(447));
      /* Termina nodo:447   */
      /* Termina nodo:446   */

      /* Empieza nodo:448 / Elemento padre: 441   */
      v.add(doc.createElement("td"));
      ((Element)v.get(448)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(441)).appendChild((Element)v.get(448));

      /* Empieza nodo:449 / Elemento padre: 448   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(449)).setAttribute("nombre","cbUDV" );
      ((Element)v.get(449)).setAttribute("id","datosCampos" );
      ((Element)v.get(449)).setAttribute("size","1" );
      ((Element)v.get(449)).setAttribute("multiple","N" );
      ((Element)v.get(449)).setAttribute("req","N" );
      ((Element)v.get(449)).setAttribute("valorinicial","" );
      ((Element)v.get(449)).setAttribute("textoinicial","" );
      ((Element)v.get(449)).setAttribute("ontab","setTabFocus('cbUDV');" );
      ((Element)v.get(449)).setAttribute("onshtab","setSHTabFocus('cbUDV');" );
      ((Element)v.get(448)).appendChild((Element)v.get(449));

      /* Empieza nodo:450 / Elemento padre: 449   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(449)).appendChild((Element)v.get(450));
      /* Termina nodo:450   */
      /* Termina nodo:449   */
      /* Termina nodo:448   */

      /* Empieza nodo:451 / Elemento padre: 441   */
      v.add(doc.createElement("td"));
      ((Element)v.get(451)).setAttribute("width","100%" );
      ((Element)v.get(441)).appendChild((Element)v.get(451));

      /* Empieza nodo:452 / Elemento padre: 451   */
   }

   private void getXML2070(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(452)).setAttribute("src","b.gif" );
      ((Element)v.get(452)).setAttribute("width","8" );
      ((Element)v.get(452)).setAttribute("height","8" );
      ((Element)v.get(451)).appendChild((Element)v.get(452));
      /* Termina nodo:452   */
      /* Termina nodo:451   */
      /* Termina nodo:441   */

      /* Empieza nodo:453 / Elemento padre: 429   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(429)).appendChild((Element)v.get(453));

      /* Empieza nodo:454 / Elemento padre: 453   */
      v.add(doc.createElement("td"));
      ((Element)v.get(454)).setAttribute("colspan","4" );
      ((Element)v.get(453)).appendChild((Element)v.get(454));

      /* Empieza nodo:455 / Elemento padre: 454   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(455)).setAttribute("src","b.gif" );
      ((Element)v.get(455)).setAttribute("width","8" );
      ((Element)v.get(455)).setAttribute("height","8" );
      ((Element)v.get(454)).appendChild((Element)v.get(455));
      /* Termina nodo:455   */
      /* Termina nodo:454   */
      /* Termina nodo:453   */
      /* Termina nodo:429   */

      /* Empieza nodo:456 / Elemento padre: 143   */
      v.add(doc.createElement("table"));
      ((Element)v.get(456)).setAttribute("width","100%" );
      ((Element)v.get(456)).setAttribute("border","0" );
      ((Element)v.get(456)).setAttribute("align","center" );
      ((Element)v.get(456)).setAttribute("cellspacing","0" );
      ((Element)v.get(456)).setAttribute("cellpadding","0" );
      ((Element)v.get(143)).appendChild((Element)v.get(456));

      /* Empieza nodo:457 / Elemento padre: 456   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(456)).appendChild((Element)v.get(457));

      /* Empieza nodo:458 / Elemento padre: 457   */
      v.add(doc.createElement("td"));
      ((Element)v.get(457)).appendChild((Element)v.get(458));

      /* Empieza nodo:459 / Elemento padre: 458   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(459)).setAttribute("src","b.gif" );
      ((Element)v.get(459)).setAttribute("width","8" );
      ((Element)v.get(459)).setAttribute("height","8" );
      ((Element)v.get(458)).appendChild((Element)v.get(459));
      /* Termina nodo:459   */
      /* Termina nodo:458   */

      /* Empieza nodo:460 / Elemento padre: 457   */
      v.add(doc.createElement("td"));
      ((Element)v.get(457)).appendChild((Element)v.get(460));

      /* Empieza nodo:461 / Elemento padre: 460   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(461)).setAttribute("nombre","lblPeso" );
      ((Element)v.get(461)).setAttribute("alto","13" );
      ((Element)v.get(461)).setAttribute("filas","1" );
      ((Element)v.get(461)).setAttribute("valor","" );
      ((Element)v.get(461)).setAttribute("id","datosTitle" );
      ((Element)v.get(461)).setAttribute("cod","1115" );
      ((Element)v.get(460)).appendChild((Element)v.get(461));
      /* Termina nodo:461   */
      /* Termina nodo:460   */

      /* Empieza nodo:462 / Elemento padre: 457   */
      v.add(doc.createElement("td"));
      ((Element)v.get(457)).appendChild((Element)v.get(462));

      /* Empieza nodo:463 / Elemento padre: 462   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(463)).setAttribute("src","b.gif" );
      ((Element)v.get(463)).setAttribute("width","25" );
      ((Element)v.get(463)).setAttribute("height","8" );
      ((Element)v.get(462)).appendChild((Element)v.get(463));
      /* Termina nodo:463   */
      /* Termina nodo:462   */

      /* Empieza nodo:464 / Elemento padre: 457   */
      v.add(doc.createElement("td"));
      ((Element)v.get(457)).appendChild((Element)v.get(464));

      /* Empieza nodo:465 / Elemento padre: 464   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(465)).setAttribute("nombre","lblMedidaPeso" );
      ((Element)v.get(465)).setAttribute("alto","13" );
      ((Element)v.get(465)).setAttribute("filas","1" );
      ((Element)v.get(465)).setAttribute("valor","" );
      ((Element)v.get(465)).setAttribute("id","datosTitle" );
      ((Element)v.get(465)).setAttribute("cod","1134" );
      ((Element)v.get(464)).appendChild((Element)v.get(465));
      /* Termina nodo:465   */
      /* Termina nodo:464   */

      /* Empieza nodo:466 / Elemento padre: 457   */
      v.add(doc.createElement("td"));
      ((Element)v.get(466)).setAttribute("width","100%" );
      ((Element)v.get(457)).appendChild((Element)v.get(466));

      /* Empieza nodo:467 / Elemento padre: 466   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(467)).setAttribute("src","b.gif" );
      ((Element)v.get(467)).setAttribute("width","8" );
      ((Element)v.get(467)).setAttribute("height","8" );
      ((Element)v.get(466)).appendChild((Element)v.get(467));
      /* Termina nodo:467   */
      /* Termina nodo:466   */
      /* Termina nodo:457   */

      /* Empieza nodo:468 / Elemento padre: 456   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(456)).appendChild((Element)v.get(468));

      /* Empieza nodo:469 / Elemento padre: 468   */
      v.add(doc.createElement("td"));
      ((Element)v.get(468)).appendChild((Element)v.get(469));

      /* Empieza nodo:470 / Elemento padre: 469   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(470)).setAttribute("src","b.gif" );
      ((Element)v.get(470)).setAttribute("width","8" );
      ((Element)v.get(470)).setAttribute("height","8" );
      ((Element)v.get(469)).appendChild((Element)v.get(470));
      /* Termina nodo:470   */
      /* Termina nodo:469   */

      /* Empieza nodo:471 / Elemento padre: 468   */
      v.add(doc.createElement("td"));
      ((Element)v.get(471)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(468)).appendChild((Element)v.get(471));

      /* Empieza nodo:472 / Elemento padre: 471   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(472)).setAttribute("nombre","txtPeso" );
      ((Element)v.get(472)).setAttribute("id","datosCampos" );
      ((Element)v.get(472)).setAttribute("max","6" );
      ((Element)v.get(472)).setAttribute("tipo","" );
      ((Element)v.get(472)).setAttribute("onchange","" );
      ((Element)v.get(472)).setAttribute("req","N" );
      ((Element)v.get(472)).setAttribute("size","7" );
      ((Element)v.get(472)).setAttribute("valor","" );
      ((Element)v.get(472)).setAttribute("validacion","" );
      ((Element)v.get(472)).setAttribute("ontab","setTabFocus('txtPeso');" );
      ((Element)v.get(472)).setAttribute("onshtab","setSHTabFocus('txtPeso');" );
   }

   private void getXML2160(Document doc) {
      ((Element)v.get(471)).appendChild((Element)v.get(472));
      /* Termina nodo:472   */
      /* Termina nodo:471   */

      /* Empieza nodo:473 / Elemento padre: 468   */
      v.add(doc.createElement("td"));
      ((Element)v.get(468)).appendChild((Element)v.get(473));

      /* Empieza nodo:474 / Elemento padre: 473   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(474)).setAttribute("src","b.gif" );
      ((Element)v.get(474)).setAttribute("width","25" );
      ((Element)v.get(474)).setAttribute("height","8" );
      ((Element)v.get(473)).appendChild((Element)v.get(474));
      /* Termina nodo:474   */
      /* Termina nodo:473   */

      /* Empieza nodo:475 / Elemento padre: 468   */
      v.add(doc.createElement("td"));
      ((Element)v.get(475)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(468)).appendChild((Element)v.get(475));

      /* Empieza nodo:476 / Elemento padre: 475   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(476)).setAttribute("nombre","cbUDP" );
      ((Element)v.get(476)).setAttribute("id","datosCampos" );
      ((Element)v.get(476)).setAttribute("size","1" );
      ((Element)v.get(476)).setAttribute("multiple","N" );
      ((Element)v.get(476)).setAttribute("req","N" );
      ((Element)v.get(476)).setAttribute("valorinicial","" );
      ((Element)v.get(476)).setAttribute("textoinicial","" );
      ((Element)v.get(476)).setAttribute("ontab","setTabFocus('cbUDP');" );
      ((Element)v.get(476)).setAttribute("onshtab","setSHTabFocus('cbUDP');" );
      ((Element)v.get(475)).appendChild((Element)v.get(476));

      /* Empieza nodo:477 / Elemento padre: 476   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(476)).appendChild((Element)v.get(477));
      /* Termina nodo:477   */
      /* Termina nodo:476   */
      /* Termina nodo:475   */

      /* Empieza nodo:478 / Elemento padre: 468   */
      v.add(doc.createElement("td"));
      ((Element)v.get(478)).setAttribute("width","100%" );
      ((Element)v.get(468)).appendChild((Element)v.get(478));

      /* Empieza nodo:479 / Elemento padre: 478   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(479)).setAttribute("src","b.gif" );
      ((Element)v.get(479)).setAttribute("width","8" );
      ((Element)v.get(479)).setAttribute("height","8" );
      ((Element)v.get(478)).appendChild((Element)v.get(479));
      /* Termina nodo:479   */
      /* Termina nodo:478   */
      /* Termina nodo:468   */

      /* Empieza nodo:480 / Elemento padre: 456   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(456)).appendChild((Element)v.get(480));

      /* Empieza nodo:481 / Elemento padre: 480   */
      v.add(doc.createElement("td"));
      ((Element)v.get(481)).setAttribute("colspan","4" );
      ((Element)v.get(480)).appendChild((Element)v.get(481));

      /* Empieza nodo:482 / Elemento padre: 481   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(482)).setAttribute("src","b.gif" );
      ((Element)v.get(482)).setAttribute("width","8" );
      ((Element)v.get(482)).setAttribute("height","8" );
      ((Element)v.get(481)).appendChild((Element)v.get(482));
      /* Termina nodo:482   */
      /* Termina nodo:481   */
      /* Termina nodo:480   */
      /* Termina nodo:456   */

      /* Empieza nodo:483 / Elemento padre: 143   */
      v.add(doc.createElement("table"));
      ((Element)v.get(483)).setAttribute("width","100%" );
      ((Element)v.get(483)).setAttribute("border","0" );
      ((Element)v.get(483)).setAttribute("align","center" );
      ((Element)v.get(483)).setAttribute("cellspacing","0" );
      ((Element)v.get(483)).setAttribute("cellpadding","0" );
      ((Element)v.get(143)).appendChild((Element)v.get(483));

      /* Empieza nodo:484 / Elemento padre: 483   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(483)).appendChild((Element)v.get(484));

      /* Empieza nodo:485 / Elemento padre: 484   */
      v.add(doc.createElement("td"));
      ((Element)v.get(484)).appendChild((Element)v.get(485));

      /* Empieza nodo:486 / Elemento padre: 485   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(486)).setAttribute("src","b.gif" );
      ((Element)v.get(486)).setAttribute("width","8" );
      ((Element)v.get(486)).setAttribute("height","8" );
      ((Element)v.get(485)).appendChild((Element)v.get(486));
      /* Termina nodo:486   */
      /* Termina nodo:485   */

      /* Empieza nodo:487 / Elemento padre: 484   */
      v.add(doc.createElement("td"));
      ((Element)v.get(484)).appendChild((Element)v.get(487));

      /* Empieza nodo:488 / Elemento padre: 487   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(488)).setAttribute("nombre","lblDentroPedido" );
      ((Element)v.get(488)).setAttribute("alto","13" );
      ((Element)v.get(488)).setAttribute("filas","1" );
      ((Element)v.get(488)).setAttribute("valor","" );
      ((Element)v.get(488)).setAttribute("id","datosTitle" );
      ((Element)v.get(488)).setAttribute("cod","1132" );
      ((Element)v.get(487)).appendChild((Element)v.get(488));
      /* Termina nodo:488   */
      /* Termina nodo:487   */

      /* Empieza nodo:489 / Elemento padre: 484   */
      v.add(doc.createElement("td"));
      ((Element)v.get(484)).appendChild((Element)v.get(489));

      /* Empieza nodo:490 / Elemento padre: 489   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(490)).setAttribute("src","b.gif" );
      ((Element)v.get(490)).setAttribute("width","25" );
      ((Element)v.get(490)).setAttribute("height","8" );
      ((Element)v.get(489)).appendChild((Element)v.get(490));
      /* Termina nodo:490   */
      /* Termina nodo:489   */

      /* Empieza nodo:491 / Elemento padre: 484   */
      v.add(doc.createElement("td"));
      ((Element)v.get(484)).appendChild((Element)v.get(491));

      /* Empieza nodo:492 / Elemento padre: 491   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(492)).setAttribute("nombre","lblPorCaja" );
      ((Element)v.get(492)).setAttribute("alto","13" );
      ((Element)v.get(492)).setAttribute("filas","1" );
      ((Element)v.get(492)).setAttribute("valor","" );
      ((Element)v.get(492)).setAttribute("id","datosTitle" );
      ((Element)v.get(492)).setAttribute("cod","1136" );
      ((Element)v.get(491)).appendChild((Element)v.get(492));
      /* Termina nodo:492   */
      /* Termina nodo:491   */

      /* Empieza nodo:493 / Elemento padre: 484   */
      v.add(doc.createElement("td"));
      ((Element)v.get(484)).appendChild((Element)v.get(493));

      /* Empieza nodo:494 / Elemento padre: 493   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(494)).setAttribute("src","b.gif" );
      ((Element)v.get(494)).setAttribute("width","25" );
   }

   private void getXML2250(Document doc) {
      ((Element)v.get(494)).setAttribute("height","8" );
      ((Element)v.get(493)).appendChild((Element)v.get(494));
      /* Termina nodo:494   */
      /* Termina nodo:493   */

      /* Empieza nodo:495 / Elemento padre: 484   */
      v.add(doc.createElement("td"));
      ((Element)v.get(484)).appendChild((Element)v.get(495));

      /* Empieza nodo:496 / Elemento padre: 495   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(496)).setAttribute("nombre","lblCosteEstandar" );
      ((Element)v.get(496)).setAttribute("alto","13" );
      ((Element)v.get(496)).setAttribute("filas","1" );
      ((Element)v.get(496)).setAttribute("valor","" );
      ((Element)v.get(496)).setAttribute("id","datosTitle" );
      ((Element)v.get(496)).setAttribute("cod","604" );
      ((Element)v.get(495)).appendChild((Element)v.get(496));
      /* Termina nodo:496   */
      /* Termina nodo:495   */

      /* Empieza nodo:497 / Elemento padre: 484   */
      v.add(doc.createElement("td"));
      ((Element)v.get(484)).appendChild((Element)v.get(497));

      /* Empieza nodo:498 / Elemento padre: 497   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(498)).setAttribute("src","b.gif" );
      ((Element)v.get(498)).setAttribute("width","25" );
      ((Element)v.get(498)).setAttribute("height","8" );
      ((Element)v.get(497)).appendChild((Element)v.get(498));
      /* Termina nodo:498   */
      /* Termina nodo:497   */

      /* Empieza nodo:499 / Elemento padre: 484   */
      v.add(doc.createElement("td"));
      ((Element)v.get(484)).appendChild((Element)v.get(499));

      /* Empieza nodo:500 / Elemento padre: 499   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(500)).setAttribute("nombre","lblPrecioPos" );
      ((Element)v.get(500)).setAttribute("alto","13" );
      ((Element)v.get(500)).setAttribute("filas","1" );
      ((Element)v.get(500)).setAttribute("valor","" );
      ((Element)v.get(500)).setAttribute("id","datosTitle" );
      ((Element)v.get(500)).setAttribute("cod","1116" );
      ((Element)v.get(499)).appendChild((Element)v.get(500));
      /* Termina nodo:500   */
      /* Termina nodo:499   */

      /* Empieza nodo:501 / Elemento padre: 484   */
      v.add(doc.createElement("td"));
      ((Element)v.get(484)).appendChild((Element)v.get(501));

      /* Empieza nodo:502 / Elemento padre: 501   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(502)).setAttribute("src","b.gif" );
      ((Element)v.get(502)).setAttribute("width","25" );
      ((Element)v.get(502)).setAttribute("height","8" );
      ((Element)v.get(501)).appendChild((Element)v.get(502));
      /* Termina nodo:502   */
      /* Termina nodo:501   */

      /* Empieza nodo:503 / Elemento padre: 484   */
      v.add(doc.createElement("td"));
      ((Element)v.get(484)).appendChild((Element)v.get(503));

      /* Empieza nodo:504 / Elemento padre: 503   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(504)).setAttribute("nombre","lblSituacion" );
      ((Element)v.get(504)).setAttribute("alto","13" );
      ((Element)v.get(504)).setAttribute("filas","1" );
      ((Element)v.get(504)).setAttribute("valor","" );
      ((Element)v.get(504)).setAttribute("id","datosTitle" );
      ((Element)v.get(504)).setAttribute("cod","695" );
      ((Element)v.get(503)).appendChild((Element)v.get(504));
      /* Termina nodo:504   */
      /* Termina nodo:503   */

      /* Empieza nodo:505 / Elemento padre: 484   */
      v.add(doc.createElement("td"));
      ((Element)v.get(505)).setAttribute("width","100%" );
      ((Element)v.get(484)).appendChild((Element)v.get(505));

      /* Empieza nodo:506 / Elemento padre: 505   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(506)).setAttribute("src","b.gif" );
      ((Element)v.get(506)).setAttribute("width","8" );
      ((Element)v.get(506)).setAttribute("height","8" );
      ((Element)v.get(505)).appendChild((Element)v.get(506));
      /* Termina nodo:506   */
      /* Termina nodo:505   */
      /* Termina nodo:484   */

      /* Empieza nodo:507 / Elemento padre: 483   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(483)).appendChild((Element)v.get(507));

      /* Empieza nodo:508 / Elemento padre: 507   */
      v.add(doc.createElement("td"));
      ((Element)v.get(507)).appendChild((Element)v.get(508));

      /* Empieza nodo:509 / Elemento padre: 508   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(509)).setAttribute("src","b.gif" );
      ((Element)v.get(509)).setAttribute("width","8" );
      ((Element)v.get(509)).setAttribute("height","8" );
      ((Element)v.get(508)).appendChild((Element)v.get(509));
      /* Termina nodo:509   */
      /* Termina nodo:508   */

      /* Empieza nodo:510 / Elemento padre: 507   */
      v.add(doc.createElement("td"));
      ((Element)v.get(510)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(507)).appendChild((Element)v.get(510));

      /* Empieza nodo:511 / Elemento padre: 510   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(511)).setAttribute("nombre","txtUnidDentroPedido" );
      ((Element)v.get(511)).setAttribute("id","datosCampos" );
      ((Element)v.get(511)).setAttribute("max","5" );
      ((Element)v.get(511)).setAttribute("tipo","" );
      ((Element)v.get(511)).setAttribute("onchange","" );
      ((Element)v.get(511)).setAttribute("req","N" );
      ((Element)v.get(511)).setAttribute("size","5" );
      ((Element)v.get(511)).setAttribute("valor","" );
      ((Element)v.get(511)).setAttribute("validacion","" );
      ((Element)v.get(511)).setAttribute("ontab","setTabFocus('txtUnidDentroPedido');" );
      ((Element)v.get(511)).setAttribute("onshtab","setSHTabFocus('txtUnidDentroPedido');" );
      ((Element)v.get(510)).appendChild((Element)v.get(511));
      /* Termina nodo:511   */
      /* Termina nodo:510   */

      /* Empieza nodo:512 / Elemento padre: 507   */
      v.add(doc.createElement("td"));
      ((Element)v.get(507)).appendChild((Element)v.get(512));

      /* Empieza nodo:513 / Elemento padre: 512   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(513)).setAttribute("src","b.gif" );
      ((Element)v.get(513)).setAttribute("width","25" );
      ((Element)v.get(513)).setAttribute("height","8" );
      ((Element)v.get(512)).appendChild((Element)v.get(513));
      /* Termina nodo:513   */
      /* Termina nodo:512   */

      /* Empieza nodo:514 / Elemento padre: 507   */
      v.add(doc.createElement("td"));
      ((Element)v.get(514)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(507)).appendChild((Element)v.get(514));

      /* Empieza nodo:515 / Elemento padre: 514   */
      v.add(doc.createElement("CTEXTO"));
   }

   private void getXML2340(Document doc) {
      ((Element)v.get(515)).setAttribute("nombre","txtUDC" );
      ((Element)v.get(515)).setAttribute("id","datosCampos" );
      ((Element)v.get(515)).setAttribute("max","5" );
      ((Element)v.get(515)).setAttribute("tipo","" );
      ((Element)v.get(515)).setAttribute("onchange","" );
      ((Element)v.get(515)).setAttribute("req","N" );
      ((Element)v.get(515)).setAttribute("size","5" );
      ((Element)v.get(515)).setAttribute("valor","" );
      ((Element)v.get(515)).setAttribute("validacion","" );
      ((Element)v.get(515)).setAttribute("ontab","setTabFocus('txtUDC');" );
      ((Element)v.get(515)).setAttribute("onshtab","setSHTabFocus('txtUDC');" );
      ((Element)v.get(514)).appendChild((Element)v.get(515));
      /* Termina nodo:515   */
      /* Termina nodo:514   */

      /* Empieza nodo:516 / Elemento padre: 507   */
      v.add(doc.createElement("td"));
      ((Element)v.get(507)).appendChild((Element)v.get(516));

      /* Empieza nodo:517 / Elemento padre: 516   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(517)).setAttribute("src","b.gif" );
      ((Element)v.get(517)).setAttribute("width","25" );
      ((Element)v.get(517)).setAttribute("height","8" );
      ((Element)v.get(516)).appendChild((Element)v.get(517));
      /* Termina nodo:517   */
      /* Termina nodo:516   */

      /* Empieza nodo:518 / Elemento padre: 507   */
      v.add(doc.createElement("td"));
      ((Element)v.get(518)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(507)).appendChild((Element)v.get(518));

      /* Empieza nodo:519 / Elemento padre: 518   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(519)).setAttribute("nombre","txtCosteEstandar" );
      ((Element)v.get(519)).setAttribute("id","datosCampos" );
      ((Element)v.get(519)).setAttribute("max","16" );
      ((Element)v.get(519)).setAttribute("tipo","" );
      ((Element)v.get(519)).setAttribute("onchange","" );
      ((Element)v.get(519)).setAttribute("req","N" );
      ((Element)v.get(519)).setAttribute("size","20" );
      ((Element)v.get(519)).setAttribute("valor","" );
      ((Element)v.get(519)).setAttribute("validacion","" );
      ((Element)v.get(519)).setAttribute("ontab","setTabFocus('txtCosteEstandar');" );
      ((Element)v.get(519)).setAttribute("onshtab","setSHTabFocus('txtCosteEstandar');" );
      ((Element)v.get(518)).appendChild((Element)v.get(519));
      /* Termina nodo:519   */
      /* Termina nodo:518   */

      /* Empieza nodo:520 / Elemento padre: 507   */
      v.add(doc.createElement("td"));
      ((Element)v.get(507)).appendChild((Element)v.get(520));

      /* Empieza nodo:521 / Elemento padre: 520   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(521)).setAttribute("src","b.gif" );
      ((Element)v.get(521)).setAttribute("width","25" );
      ((Element)v.get(521)).setAttribute("height","8" );
      ((Element)v.get(520)).appendChild((Element)v.get(521));
      /* Termina nodo:521   */
      /* Termina nodo:520   */

      /* Empieza nodo:522 / Elemento padre: 507   */
      v.add(doc.createElement("td"));
      ((Element)v.get(522)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(507)).appendChild((Element)v.get(522));

      /* Empieza nodo:523 / Elemento padre: 522   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(523)).setAttribute("nombre","txtPPos" );
      ((Element)v.get(523)).setAttribute("id","datosCampos" );
      ((Element)v.get(523)).setAttribute("max","16" );
      ((Element)v.get(523)).setAttribute("tipo","" );
      ((Element)v.get(523)).setAttribute("onchange","" );
      ((Element)v.get(523)).setAttribute("req","N" );
      ((Element)v.get(523)).setAttribute("size","20" );
      ((Element)v.get(523)).setAttribute("valor","" );
      ((Element)v.get(523)).setAttribute("validacion","" );
      ((Element)v.get(523)).setAttribute("ontab","setTabFocus('txtPPos');" );
      ((Element)v.get(523)).setAttribute("onshtab","setSHTabFocus('txtPPos');" );
      ((Element)v.get(522)).appendChild((Element)v.get(523));
      /* Termina nodo:523   */
      /* Termina nodo:522   */

      /* Empieza nodo:524 / Elemento padre: 507   */
      v.add(doc.createElement("td"));
      ((Element)v.get(507)).appendChild((Element)v.get(524));

      /* Empieza nodo:525 / Elemento padre: 524   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(525)).setAttribute("src","b.gif" );
      ((Element)v.get(525)).setAttribute("width","25" );
      ((Element)v.get(525)).setAttribute("height","8" );
      ((Element)v.get(524)).appendChild((Element)v.get(525));
      /* Termina nodo:525   */
      /* Termina nodo:524   */

      /* Empieza nodo:526 / Elemento padre: 507   */
      v.add(doc.createElement("td"));
      ((Element)v.get(526)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(507)).appendChild((Element)v.get(526));

      /* Empieza nodo:527 / Elemento padre: 526   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(527)).setAttribute("nombre","cbSituac" );
      ((Element)v.get(527)).setAttribute("id","datosCampos" );
      ((Element)v.get(527)).setAttribute("size","1" );
      ((Element)v.get(527)).setAttribute("multiple","N" );
      ((Element)v.get(527)).setAttribute("req","N" );
      ((Element)v.get(527)).setAttribute("valorinicial","" );
      ((Element)v.get(527)).setAttribute("textoinicial","" );
      ((Element)v.get(527)).setAttribute("ontab","setTabFocus('cbSituac');" );
      ((Element)v.get(527)).setAttribute("onshtab","setSHTabFocus('cbSituac');" );
      ((Element)v.get(526)).appendChild((Element)v.get(527));

      /* Empieza nodo:528 / Elemento padre: 527   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(527)).appendChild((Element)v.get(528));
      /* Termina nodo:528   */
      /* Termina nodo:527   */
      /* Termina nodo:526   */

      /* Empieza nodo:529 / Elemento padre: 507   */
      v.add(doc.createElement("td"));
      ((Element)v.get(529)).setAttribute("width","100%" );
      ((Element)v.get(507)).appendChild((Element)v.get(529));

      /* Empieza nodo:530 / Elemento padre: 529   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(530)).setAttribute("src","b.gif" );
      ((Element)v.get(530)).setAttribute("width","8" );
      ((Element)v.get(530)).setAttribute("height","8" );
      ((Element)v.get(529)).appendChild((Element)v.get(530));
      /* Termina nodo:530   */
      /* Termina nodo:529   */
      /* Termina nodo:507   */

      /* Empieza nodo:531 / Elemento padre: 483   */
      v.add(doc.createElement("tr"));
   }

   private void getXML2430(Document doc) {
      ((Element)v.get(483)).appendChild((Element)v.get(531));

      /* Empieza nodo:532 / Elemento padre: 531   */
      v.add(doc.createElement("td"));
      ((Element)v.get(532)).setAttribute("colspan","4" );
      ((Element)v.get(531)).appendChild((Element)v.get(532));

      /* Empieza nodo:533 / Elemento padre: 532   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(533)).setAttribute("src","b.gif" );
      ((Element)v.get(533)).setAttribute("width","8" );
      ((Element)v.get(533)).setAttribute("height","8" );
      ((Element)v.get(532)).appendChild((Element)v.get(533));
      /* Termina nodo:533   */
      /* Termina nodo:532   */
      /* Termina nodo:531   */
      /* Termina nodo:483   */

      /* Empieza nodo:534 / Elemento padre: 143   */
      v.add(doc.createElement("table"));
      ((Element)v.get(534)).setAttribute("width","100%" );
      ((Element)v.get(534)).setAttribute("border","0" );
      ((Element)v.get(534)).setAttribute("align","center" );
      ((Element)v.get(534)).setAttribute("cellspacing","0" );
      ((Element)v.get(534)).setAttribute("cellpadding","0" );
      ((Element)v.get(143)).appendChild((Element)v.get(534));

      /* Empieza nodo:535 / Elemento padre: 534   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(534)).appendChild((Element)v.get(535));

      /* Empieza nodo:536 / Elemento padre: 535   */
      v.add(doc.createElement("td"));
      ((Element)v.get(535)).appendChild((Element)v.get(536));

      /* Empieza nodo:537 / Elemento padre: 536   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(537)).setAttribute("src","b.gif" );
      ((Element)v.get(537)).setAttribute("width","8" );
      ((Element)v.get(537)).setAttribute("height","8" );
      ((Element)v.get(536)).appendChild((Element)v.get(537));
      /* Termina nodo:537   */
      /* Termina nodo:536   */

      /* Empieza nodo:538 / Elemento padre: 535   */
      v.add(doc.createElement("td"));
      ((Element)v.get(535)).appendChild((Element)v.get(538));

      /* Empieza nodo:539 / Elemento padre: 538   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(539)).setAttribute("nombre","lblEstatusProducto" );
      ((Element)v.get(539)).setAttribute("alto","13" );
      ((Element)v.get(539)).setAttribute("filas","1" );
      ((Element)v.get(539)).setAttribute("valor","" );
      ((Element)v.get(539)).setAttribute("id","datosTitle" );
      ((Element)v.get(539)).setAttribute("cod","1077" );
      ((Element)v.get(538)).appendChild((Element)v.get(539));
      /* Termina nodo:539   */
      /* Termina nodo:538   */

      /* Empieza nodo:540 / Elemento padre: 535   */
      v.add(doc.createElement("td"));
      ((Element)v.get(535)).appendChild((Element)v.get(540));

      /* Empieza nodo:541 / Elemento padre: 540   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(541)).setAttribute("src","b.gif" );
      ((Element)v.get(541)).setAttribute("width","25" );
      ((Element)v.get(541)).setAttribute("height","8" );
      ((Element)v.get(540)).appendChild((Element)v.get(541));
      /* Termina nodo:541   */
      /* Termina nodo:540   */

      /* Empieza nodo:542 / Elemento padre: 535   */
      v.add(doc.createElement("td"));
      ((Element)v.get(535)).appendChild((Element)v.get(542));

      /* Empieza nodo:543 / Elemento padre: 542   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(543)).setAttribute("nombre","lblDentroCaja" );
      ((Element)v.get(543)).setAttribute("alto","13" );
      ((Element)v.get(543)).setAttribute("filas","1" );
      ((Element)v.get(543)).setAttribute("valor","" );
      ((Element)v.get(543)).setAttribute("id","datosTitle" );
      ((Element)v.get(543)).setAttribute("cod","1083" );
      ((Element)v.get(542)).appendChild((Element)v.get(543));
      /* Termina nodo:543   */
      /* Termina nodo:542   */

      /* Empieza nodo:544 / Elemento padre: 535   */
      v.add(doc.createElement("td"));
      ((Element)v.get(535)).appendChild((Element)v.get(544));

      /* Empieza nodo:545 / Elemento padre: 544   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(545)).setAttribute("src","b.gif" );
      ((Element)v.get(545)).setAttribute("width","25" );
      ((Element)v.get(545)).setAttribute("height","8" );
      ((Element)v.get(544)).appendChild((Element)v.get(545));
      /* Termina nodo:545   */
      /* Termina nodo:544   */

      /* Empieza nodo:546 / Elemento padre: 535   */
      v.add(doc.createElement("td"));
      ((Element)v.get(535)).appendChild((Element)v.get(546));

      /* Empieza nodo:547 / Elemento padre: 546   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(547)).setAttribute("nombre","lblCodPagoFraccionado" );
      ((Element)v.get(547)).setAttribute("alto","13" );
      ((Element)v.get(547)).setAttribute("filas","1" );
      ((Element)v.get(547)).setAttribute("valor","" );
      ((Element)v.get(547)).setAttribute("id","datosTitle" );
      ((Element)v.get(547)).setAttribute("cod","541" );
      ((Element)v.get(546)).appendChild((Element)v.get(547));
      /* Termina nodo:547   */
      /* Termina nodo:546   */

      /* Empieza nodo:548 / Elemento padre: 535   */
      v.add(doc.createElement("td"));
      ((Element)v.get(535)).appendChild((Element)v.get(548));

      /* Empieza nodo:549 / Elemento padre: 548   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(549)).setAttribute("src","b.gif" );
      ((Element)v.get(549)).setAttribute("width","25" );
      ((Element)v.get(549)).setAttribute("height","8" );
      ((Element)v.get(548)).appendChild((Element)v.get(549));
      /* Termina nodo:549   */
      /* Termina nodo:548   */

      /* Empieza nodo:550 / Elemento padre: 535   */
      v.add(doc.createElement("td"));
      ((Element)v.get(535)).appendChild((Element)v.get(550));

      /* Empieza nodo:551 / Elemento padre: 550   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(551)).setAttribute("nombre","lblCodImpuesto" );
      ((Element)v.get(551)).setAttribute("alto","13" );
      ((Element)v.get(551)).setAttribute("filas","1" );
      ((Element)v.get(551)).setAttribute("valor","" );
      ((Element)v.get(551)).setAttribute("id","datosTitle" );
      ((Element)v.get(551)).setAttribute("cod","1062" );
      ((Element)v.get(550)).appendChild((Element)v.get(551));
      /* Termina nodo:551   */
      /* Termina nodo:550   */

      /* Empieza nodo:552 / Elemento padre: 535   */
      v.add(doc.createElement("td"));
      ((Element)v.get(552)).setAttribute("width","100%" );
      ((Element)v.get(535)).appendChild((Element)v.get(552));

      /* Empieza nodo:553 / Elemento padre: 552   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML2520(Document doc) {
      ((Element)v.get(553)).setAttribute("src","b.gif" );
      ((Element)v.get(553)).setAttribute("width","8" );
      ((Element)v.get(553)).setAttribute("height","8" );
      ((Element)v.get(552)).appendChild((Element)v.get(553));
      /* Termina nodo:553   */
      /* Termina nodo:552   */
      /* Termina nodo:535   */

      /* Empieza nodo:554 / Elemento padre: 534   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(534)).appendChild((Element)v.get(554));

      /* Empieza nodo:555 / Elemento padre: 554   */
      v.add(doc.createElement("td"));
      ((Element)v.get(554)).appendChild((Element)v.get(555));

      /* Empieza nodo:556 / Elemento padre: 555   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(556)).setAttribute("src","b.gif" );
      ((Element)v.get(556)).setAttribute("width","8" );
      ((Element)v.get(556)).setAttribute("height","8" );
      ((Element)v.get(555)).appendChild((Element)v.get(556));
      /* Termina nodo:556   */
      /* Termina nodo:555   */

      /* Empieza nodo:557 / Elemento padre: 554   */
      v.add(doc.createElement("td"));
      ((Element)v.get(557)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(554)).appendChild((Element)v.get(557));

      /* Empieza nodo:558 / Elemento padre: 557   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(558)).setAttribute("nombre","cbSProd" );
      ((Element)v.get(558)).setAttribute("id","datosCampos" );
      ((Element)v.get(558)).setAttribute("size","1" );
      ((Element)v.get(558)).setAttribute("multiple","N" );
      ((Element)v.get(558)).setAttribute("req","N" );
      ((Element)v.get(558)).setAttribute("valorinicial","" );
      ((Element)v.get(558)).setAttribute("textoinicial","" );
      ((Element)v.get(558)).setAttribute("ontab","setTabFocus('cbSProd');" );
      ((Element)v.get(558)).setAttribute("onshtab","setSHTabFocus('cbSProd');" );
      ((Element)v.get(557)).appendChild((Element)v.get(558));

      /* Empieza nodo:559 / Elemento padre: 558   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(558)).appendChild((Element)v.get(559));

      /* Empieza nodo:560 / Elemento padre: 559   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(560)).setAttribute("ID","1" );
      ((Element)v.get(559)).appendChild((Element)v.get(560));

      /* Empieza nodo:561 / Elemento padre: 560   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(561)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(561)).setAttribute("TIPO","STRING" );
      ((Element)v.get(561)).setAttribute("VALOR","00" );
      ((Element)v.get(560)).appendChild((Element)v.get(561));
      /* Termina nodo:561   */

      /* Empieza nodo:562 / Elemento padre: 560   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(562)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(562)).setAttribute("TIPO","STRING" );
      ((Element)v.get(562)).setAttribute("VALOR","xx1" );
      ((Element)v.get(560)).appendChild((Element)v.get(562));
      /* Termina nodo:562   */
      /* Termina nodo:560   */
      /* Termina nodo:559   */
      /* Termina nodo:558   */
      /* Termina nodo:557   */

      /* Empieza nodo:563 / Elemento padre: 554   */
      v.add(doc.createElement("td"));
      ((Element)v.get(554)).appendChild((Element)v.get(563));

      /* Empieza nodo:564 / Elemento padre: 563   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(564)).setAttribute("src","b.gif" );
      ((Element)v.get(564)).setAttribute("width","25" );
      ((Element)v.get(564)).setAttribute("height","8" );
      ((Element)v.get(563)).appendChild((Element)v.get(564));
      /* Termina nodo:564   */
      /* Termina nodo:563   */

      /* Empieza nodo:565 / Elemento padre: 554   */
      v.add(doc.createElement("td"));
      ((Element)v.get(565)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(554)).appendChild((Element)v.get(565));

      /* Empieza nodo:566 / Elemento padre: 565   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(566)).setAttribute("nombre","cbSCaja" );
      ((Element)v.get(566)).setAttribute("id","datosCampos" );
      ((Element)v.get(566)).setAttribute("size","1" );
      ((Element)v.get(566)).setAttribute("multiple","N" );
      ((Element)v.get(566)).setAttribute("req","N" );
      ((Element)v.get(566)).setAttribute("valorinicial","" );
      ((Element)v.get(566)).setAttribute("textoinicial","" );
      ((Element)v.get(566)).setAttribute("ontab","setTabFocus('cbSCaja');" );
      ((Element)v.get(566)).setAttribute("onshtab","setSHTabFocus('cbSCaja');" );
      ((Element)v.get(565)).appendChild((Element)v.get(566));

      /* Empieza nodo:567 / Elemento padre: 566   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(566)).appendChild((Element)v.get(567));
      /* Termina nodo:567   */
      /* Termina nodo:566   */
      /* Termina nodo:565   */

      /* Empieza nodo:568 / Elemento padre: 554   */
      v.add(doc.createElement("td"));
      ((Element)v.get(554)).appendChild((Element)v.get(568));

      /* Empieza nodo:569 / Elemento padre: 568   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(569)).setAttribute("src","b.gif" );
      ((Element)v.get(569)).setAttribute("width","25" );
      ((Element)v.get(569)).setAttribute("height","8" );
      ((Element)v.get(568)).appendChild((Element)v.get(569));
      /* Termina nodo:569   */
      /* Termina nodo:568   */

      /* Empieza nodo:570 / Elemento padre: 554   */
      v.add(doc.createElement("td"));
      ((Element)v.get(570)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(554)).appendChild((Element)v.get(570));

      /* Empieza nodo:571 / Elemento padre: 570   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(571)).setAttribute("nombre","cbFormaPago" );
      ((Element)v.get(571)).setAttribute("id","datosCampos" );
      ((Element)v.get(571)).setAttribute("size","1" );
      ((Element)v.get(571)).setAttribute("multiple","N" );
      ((Element)v.get(571)).setAttribute("req","N" );
      ((Element)v.get(571)).setAttribute("valorinicial","" );
      ((Element)v.get(571)).setAttribute("textoinicial","" );
      ((Element)v.get(571)).setAttribute("ontab","setTabFocus('cbFormaPago');" );
      ((Element)v.get(571)).setAttribute("onshtab","setSHTabFocus('cbFormaPago');" );
      ((Element)v.get(570)).appendChild((Element)v.get(571));

      /* Empieza nodo:572 / Elemento padre: 571   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(571)).appendChild((Element)v.get(572));
      /* Termina nodo:572   */
      /* Termina nodo:571   */
      /* Termina nodo:570   */

      /* Empieza nodo:573 / Elemento padre: 554   */
      v.add(doc.createElement("td"));
      ((Element)v.get(554)).appendChild((Element)v.get(573));

      /* Empieza nodo:574 / Elemento padre: 573   */
   }

   private void getXML2610(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(574)).setAttribute("src","b.gif" );
      ((Element)v.get(574)).setAttribute("width","25" );
      ((Element)v.get(574)).setAttribute("height","8" );
      ((Element)v.get(573)).appendChild((Element)v.get(574));
      /* Termina nodo:574   */
      /* Termina nodo:573   */

      /* Empieza nodo:575 / Elemento padre: 554   */
      v.add(doc.createElement("td"));
      ((Element)v.get(575)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(554)).appendChild((Element)v.get(575));

      /* Empieza nodo:576 / Elemento padre: 575   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(576)).setAttribute("nombre","txtCodImpuesto" );
      ((Element)v.get(576)).setAttribute("id","datosCampos" );
      ((Element)v.get(576)).setAttribute("max","2" );
      ((Element)v.get(576)).setAttribute("tipo","" );
      ((Element)v.get(576)).setAttribute("onchange","" );
      ((Element)v.get(576)).setAttribute("req","N" );
      ((Element)v.get(576)).setAttribute("size","2" );
      ((Element)v.get(576)).setAttribute("valor","" );
      ((Element)v.get(576)).setAttribute("validacion","" );
      ((Element)v.get(576)).setAttribute("ontab","setTabFocus('txtCodImpuesto');" );
      ((Element)v.get(576)).setAttribute("onshtab","setSHTabFocus('txtCodImpuesto');" );
      ((Element)v.get(575)).appendChild((Element)v.get(576));
      /* Termina nodo:576   */
      /* Termina nodo:575   */

      /* Empieza nodo:577 / Elemento padre: 554   */
      v.add(doc.createElement("td"));
      ((Element)v.get(577)).setAttribute("width","100%" );
      ((Element)v.get(554)).appendChild((Element)v.get(577));

      /* Empieza nodo:578 / Elemento padre: 577   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(578)).setAttribute("src","b.gif" );
      ((Element)v.get(578)).setAttribute("width","8" );
      ((Element)v.get(578)).setAttribute("height","8" );
      ((Element)v.get(577)).appendChild((Element)v.get(578));
      /* Termina nodo:578   */
      /* Termina nodo:577   */
      /* Termina nodo:554   */

      /* Empieza nodo:579 / Elemento padre: 534   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(534)).appendChild((Element)v.get(579));

      /* Empieza nodo:580 / Elemento padre: 579   */
      v.add(doc.createElement("td"));
      ((Element)v.get(580)).setAttribute("colspan","4" );
      ((Element)v.get(579)).appendChild((Element)v.get(580));

      /* Empieza nodo:581 / Elemento padre: 580   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(581)).setAttribute("src","b.gif" );
      ((Element)v.get(581)).setAttribute("width","8" );
      ((Element)v.get(581)).setAttribute("height","8" );
      ((Element)v.get(580)).appendChild((Element)v.get(581));
      /* Termina nodo:581   */
      /* Termina nodo:580   */
      /* Termina nodo:579   */
      /* Termina nodo:534   */

      /* Empieza nodo:582 / Elemento padre: 143   */
      v.add(doc.createElement("table"));
      ((Element)v.get(582)).setAttribute("width","100%" );
      ((Element)v.get(582)).setAttribute("border","0" );
      ((Element)v.get(582)).setAttribute("align","center" );
      ((Element)v.get(582)).setAttribute("cellspacing","0" );
      ((Element)v.get(582)).setAttribute("cellpadding","0" );
      ((Element)v.get(143)).appendChild((Element)v.get(582));

      /* Empieza nodo:583 / Elemento padre: 582   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(582)).appendChild((Element)v.get(583));

      /* Empieza nodo:584 / Elemento padre: 583   */
      v.add(doc.createElement("td"));
      ((Element)v.get(583)).appendChild((Element)v.get(584));

      /* Empieza nodo:585 / Elemento padre: 584   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(585)).setAttribute("src","b.gif" );
      ((Element)v.get(585)).setAttribute("width","8" );
      ((Element)v.get(585)).setAttribute("height","8" );
      ((Element)v.get(584)).appendChild((Element)v.get(585));
      /* Termina nodo:585   */
      /* Termina nodo:584   */

      /* Empieza nodo:586 / Elemento padre: 583   */
      v.add(doc.createElement("td"));
      ((Element)v.get(583)).appendChild((Element)v.get(586));

      /* Empieza nodo:587 / Elemento padre: 586   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(587)).setAttribute("nombre","lblPrecioCatalogo" );
      ((Element)v.get(587)).setAttribute("alto","13" );
      ((Element)v.get(587)).setAttribute("filas","1" );
      ((Element)v.get(587)).setAttribute("valor","" );
      ((Element)v.get(587)).setAttribute("id","datosTitle" );
      ((Element)v.get(587)).setAttribute("cod","503" );
      ((Element)v.get(586)).appendChild((Element)v.get(587));
      /* Termina nodo:587   */
      /* Termina nodo:586   */

      /* Empieza nodo:588 / Elemento padre: 583   */
      v.add(doc.createElement("td"));
      ((Element)v.get(583)).appendChild((Element)v.get(588));

      /* Empieza nodo:589 / Elemento padre: 588   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(589)).setAttribute("src","b.gif" );
      ((Element)v.get(589)).setAttribute("width","25" );
      ((Element)v.get(589)).setAttribute("height","8" );
      ((Element)v.get(588)).appendChild((Element)v.get(589));
      /* Termina nodo:589   */
      /* Termina nodo:588   */

      /* Empieza nodo:590 / Elemento padre: 583   */
      v.add(doc.createElement("td"));
      ((Element)v.get(583)).appendChild((Element)v.get(590));

      /* Empieza nodo:591 / Elemento padre: 590   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(591)).setAttribute("nombre","lblPrecioContable" );
      ((Element)v.get(591)).setAttribute("alto","13" );
      ((Element)v.get(591)).setAttribute("filas","1" );
      ((Element)v.get(591)).setAttribute("valor","" );
      ((Element)v.get(591)).setAttribute("id","datosTitle" );
      ((Element)v.get(591)).setAttribute("cod","974" );
      ((Element)v.get(590)).appendChild((Element)v.get(591));
      /* Termina nodo:591   */
      /* Termina nodo:590   */

      /* Empieza nodo:592 / Elemento padre: 583   */
      v.add(doc.createElement("td"));
      ((Element)v.get(583)).appendChild((Element)v.get(592));

      /* Empieza nodo:593 / Elemento padre: 592   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(593)).setAttribute("src","b.gif" );
      ((Element)v.get(593)).setAttribute("width","25" );
      ((Element)v.get(593)).setAttribute("height","8" );
      ((Element)v.get(592)).appendChild((Element)v.get(593));
      /* Termina nodo:593   */
      /* Termina nodo:592   */

      /* Empieza nodo:594 / Elemento padre: 583   */
      v.add(doc.createElement("td"));
   }

   private void getXML2700(Document doc) {
      ((Element)v.get(583)).appendChild((Element)v.get(594));

      /* Empieza nodo:595 / Elemento padre: 594   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(595)).setAttribute("nombre","lblGrupoArticulos" );
      ((Element)v.get(595)).setAttribute("alto","13" );
      ((Element)v.get(595)).setAttribute("filas","1" );
      ((Element)v.get(595)).setAttribute("valor","" );
      ((Element)v.get(595)).setAttribute("id","datosTitle" );
      ((Element)v.get(595)).setAttribute("cod","2473" );
      ((Element)v.get(594)).appendChild((Element)v.get(595));
      /* Termina nodo:595   */
      /* Termina nodo:594   */

      /* Empieza nodo:596 / Elemento padre: 583   */
      v.add(doc.createElement("td"));
      ((Element)v.get(583)).appendChild((Element)v.get(596));

      /* Empieza nodo:597 / Elemento padre: 596   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(597)).setAttribute("src","b.gif" );
      ((Element)v.get(597)).setAttribute("width","25" );
      ((Element)v.get(597)).setAttribute("height","8" );
      ((Element)v.get(596)).appendChild((Element)v.get(597));
      /* Termina nodo:597   */
      /* Termina nodo:596   */

      /* Empieza nodo:598 / Elemento padre: 583   */
      v.add(doc.createElement("td"));
      ((Element)v.get(583)).appendChild((Element)v.get(598));

      /* Empieza nodo:599 / Elemento padre: 598   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(599)).setAttribute("nombre","lblProgFidelizacion" );
      ((Element)v.get(599)).setAttribute("alto","13" );
      ((Element)v.get(599)).setAttribute("filas","1" );
      ((Element)v.get(599)).setAttribute("valor","" );
      ((Element)v.get(599)).setAttribute("id","datosTitle" );
      ((Element)v.get(599)).setAttribute("cod","3052" );
      ((Element)v.get(598)).appendChild((Element)v.get(599));
      /* Termina nodo:599   */
      /* Termina nodo:598   */

      /* Empieza nodo:600 / Elemento padre: 583   */
      v.add(doc.createElement("td"));
      ((Element)v.get(600)).setAttribute("width","100%" );
      ((Element)v.get(583)).appendChild((Element)v.get(600));

      /* Empieza nodo:601 / Elemento padre: 600   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(601)).setAttribute("src","b.gif" );
      ((Element)v.get(601)).setAttribute("width","8" );
      ((Element)v.get(601)).setAttribute("height","8" );
      ((Element)v.get(600)).appendChild((Element)v.get(601));
      /* Termina nodo:601   */
      /* Termina nodo:600   */
      /* Termina nodo:583   */

      /* Empieza nodo:602 / Elemento padre: 582   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(582)).appendChild((Element)v.get(602));

      /* Empieza nodo:603 / Elemento padre: 602   */
      v.add(doc.createElement("td"));
      ((Element)v.get(602)).appendChild((Element)v.get(603));

      /* Empieza nodo:604 / Elemento padre: 603   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(604)).setAttribute("src","b.gif" );
      ((Element)v.get(604)).setAttribute("width","8" );
      ((Element)v.get(604)).setAttribute("height","8" );
      ((Element)v.get(603)).appendChild((Element)v.get(604));
      /* Termina nodo:604   */
      /* Termina nodo:603   */

      /* Empieza nodo:605 / Elemento padre: 602   */
      v.add(doc.createElement("td"));
      ((Element)v.get(605)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(602)).appendChild((Element)v.get(605));

      /* Empieza nodo:606 / Elemento padre: 605   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(606)).setAttribute("nombre","txtPrecioCatalogo" );
      ((Element)v.get(606)).setAttribute("id","datosCampos" );
      ((Element)v.get(606)).setAttribute("max","16" );
      ((Element)v.get(606)).setAttribute("tipo","" );
      ((Element)v.get(606)).setAttribute("onchange","" );
      ((Element)v.get(606)).setAttribute("req","N" );
      ((Element)v.get(606)).setAttribute("size","20" );
      ((Element)v.get(606)).setAttribute("valor","" );
      ((Element)v.get(606)).setAttribute("validacion","" );
      ((Element)v.get(606)).setAttribute("ontab","setTabFocus('txtPrecioCatalogo');" );
      ((Element)v.get(606)).setAttribute("onshtab","setSHTabFocus('txtPrecioCatalogo');" );
      ((Element)v.get(605)).appendChild((Element)v.get(606));
      /* Termina nodo:606   */
      /* Termina nodo:605   */

      /* Empieza nodo:607 / Elemento padre: 602   */
      v.add(doc.createElement("td"));
      ((Element)v.get(602)).appendChild((Element)v.get(607));

      /* Empieza nodo:608 / Elemento padre: 607   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(608)).setAttribute("src","b.gif" );
      ((Element)v.get(608)).setAttribute("width","25" );
      ((Element)v.get(608)).setAttribute("height","8" );
      ((Element)v.get(607)).appendChild((Element)v.get(608));
      /* Termina nodo:608   */
      /* Termina nodo:607   */

      /* Empieza nodo:609 / Elemento padre: 602   */
      v.add(doc.createElement("td"));
      ((Element)v.get(609)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(602)).appendChild((Element)v.get(609));

      /* Empieza nodo:610 / Elemento padre: 609   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(610)).setAttribute("nombre","txtPrecioContable" );
      ((Element)v.get(610)).setAttribute("id","datosCampos" );
      ((Element)v.get(610)).setAttribute("max","16" );
      ((Element)v.get(610)).setAttribute("tipo","" );
      ((Element)v.get(610)).setAttribute("onchange","" );
      ((Element)v.get(610)).setAttribute("req","N" );
      ((Element)v.get(610)).setAttribute("size","20" );
      ((Element)v.get(610)).setAttribute("valor","" );
      ((Element)v.get(610)).setAttribute("validacion","" );
      ((Element)v.get(610)).setAttribute("ontab","setTabFocus('txtPrecioContable');" );
      ((Element)v.get(610)).setAttribute("onshtab","setSHTabFocus('txtPrecioContable');" );
      ((Element)v.get(609)).appendChild((Element)v.get(610));
      /* Termina nodo:610   */
      /* Termina nodo:609   */

      /* Empieza nodo:611 / Elemento padre: 602   */
      v.add(doc.createElement("td"));
      ((Element)v.get(602)).appendChild((Element)v.get(611));

      /* Empieza nodo:612 / Elemento padre: 611   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(612)).setAttribute("src","b.gif" );
      ((Element)v.get(612)).setAttribute("width","25" );
      ((Element)v.get(612)).setAttribute("height","8" );
      ((Element)v.get(611)).appendChild((Element)v.get(612));
      /* Termina nodo:612   */
      /* Termina nodo:611   */

      /* Empieza nodo:613 / Elemento padre: 602   */
      v.add(doc.createElement("td"));
   }

   private void getXML2790(Document doc) {
      ((Element)v.get(613)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(602)).appendChild((Element)v.get(613));

      /* Empieza nodo:614 / Elemento padre: 613   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(614)).setAttribute("nombre","txtGrupoArticulos" );
      ((Element)v.get(614)).setAttribute("id","datosCampos" );
      ((Element)v.get(614)).setAttribute("max","9" );
      ((Element)v.get(614)).setAttribute("tipo","" );
      ((Element)v.get(614)).setAttribute("onchange","" );
      ((Element)v.get(614)).setAttribute("req","N" );
      ((Element)v.get(614)).setAttribute("size","11" );
      ((Element)v.get(614)).setAttribute("valor","" );
      ((Element)v.get(614)).setAttribute("validacion","" );
      ((Element)v.get(614)).setAttribute("ontab","setTabFocus('txtGrupoArticulos');" );
      ((Element)v.get(614)).setAttribute("onshtab","setSHTabFocus('txtGrupoArticulos');" );
      ((Element)v.get(613)).appendChild((Element)v.get(614));
      /* Termina nodo:614   */
      /* Termina nodo:613   */

      /* Empieza nodo:615 / Elemento padre: 602   */
      v.add(doc.createElement("td"));
      ((Element)v.get(602)).appendChild((Element)v.get(615));

      /* Empieza nodo:616 / Elemento padre: 615   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(616)).setAttribute("src","b.gif" );
      ((Element)v.get(616)).setAttribute("width","25" );
      ((Element)v.get(616)).setAttribute("height","8" );
      ((Element)v.get(615)).appendChild((Element)v.get(616));
      /* Termina nodo:616   */
      /* Termina nodo:615   */

      /* Empieza nodo:617 / Elemento padre: 602   */
      v.add(doc.createElement("td"));
      ((Element)v.get(617)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(602)).appendChild((Element)v.get(617));

      /* Empieza nodo:618 / Elemento padre: 617   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(618)).setAttribute("nombre","cbProgFidelizacion" );
      ((Element)v.get(618)).setAttribute("id","datosCampos" );
      ((Element)v.get(618)).setAttribute("size","1" );
      ((Element)v.get(618)).setAttribute("multiple","N" );
      ((Element)v.get(618)).setAttribute("req","N" );
      ((Element)v.get(618)).setAttribute("valorinicial","" );
      ((Element)v.get(618)).setAttribute("textoinicial","" );
      ((Element)v.get(618)).setAttribute("ontab","setTabFocus('cbProgFidelizacion');" );
      ((Element)v.get(618)).setAttribute("onshtab","setSHTabFocus('cbProgFidelizacion');" );
      ((Element)v.get(617)).appendChild((Element)v.get(618));

      /* Empieza nodo:619 / Elemento padre: 618   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(618)).appendChild((Element)v.get(619));
      /* Termina nodo:619   */
      /* Termina nodo:618   */
      /* Termina nodo:617   */

      /* Empieza nodo:620 / Elemento padre: 602   */
      v.add(doc.createElement("td"));
      ((Element)v.get(620)).setAttribute("width","100%" );
      ((Element)v.get(602)).appendChild((Element)v.get(620));

      /* Empieza nodo:621 / Elemento padre: 620   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(621)).setAttribute("src","b.gif" );
      ((Element)v.get(621)).setAttribute("width","8" );
      ((Element)v.get(621)).setAttribute("height","8" );
      ((Element)v.get(620)).appendChild((Element)v.get(621));
      /* Termina nodo:621   */
      /* Termina nodo:620   */
      /* Termina nodo:602   */

      /* Empieza nodo:622 / Elemento padre: 582   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(582)).appendChild((Element)v.get(622));

      /* Empieza nodo:623 / Elemento padre: 622   */
      v.add(doc.createElement("td"));
      ((Element)v.get(623)).setAttribute("colspan","4" );
      ((Element)v.get(622)).appendChild((Element)v.get(623));

      /* Empieza nodo:624 / Elemento padre: 623   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(624)).setAttribute("src","b.gif" );
      ((Element)v.get(624)).setAttribute("width","8" );
      ((Element)v.get(624)).setAttribute("height","8" );
      ((Element)v.get(623)).appendChild((Element)v.get(624));
      /* Termina nodo:624   */
      /* Termina nodo:623   */
      /* Termina nodo:622   */
      /* Termina nodo:582   */
      /* Termina nodo:143   */
      /* Termina nodo:142   */

      /* Empieza nodo:625 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).appendChild((Element)v.get(625));

      /* Empieza nodo:626 / Elemento padre: 625   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(626)).setAttribute("src","b.gif" );
      ((Element)v.get(625)).appendChild((Element)v.get(626));
      /* Termina nodo:626   */
      /* Termina nodo:625   */
      /* Termina nodo:139   */

      /* Empieza nodo:627 / Elemento padre: 131   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(131)).appendChild((Element)v.get(627));

      /* Empieza nodo:628 / Elemento padre: 627   */
      v.add(doc.createElement("td"));
      ((Element)v.get(628)).setAttribute("width","12" );
      ((Element)v.get(628)).setAttribute("align","center" );
      ((Element)v.get(627)).appendChild((Element)v.get(628));

      /* Empieza nodo:629 / Elemento padre: 628   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(629)).setAttribute("src","b.gif" );
      ((Element)v.get(629)).setAttribute("width","12" );
      ((Element)v.get(629)).setAttribute("height","12" );
      ((Element)v.get(628)).appendChild((Element)v.get(629));
      /* Termina nodo:629   */
      /* Termina nodo:628   */

      /* Empieza nodo:630 / Elemento padre: 627   */
      v.add(doc.createElement("td"));
      ((Element)v.get(630)).setAttribute("width","750" );
      ((Element)v.get(627)).appendChild((Element)v.get(630));

      /* Empieza nodo:631 / Elemento padre: 630   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(631)).setAttribute("src","b.gif" );
      ((Element)v.get(630)).appendChild((Element)v.get(631));
      /* Termina nodo:631   */
      /* Termina nodo:630   */

      /* Empieza nodo:632 / Elemento padre: 627   */
      v.add(doc.createElement("td"));
      ((Element)v.get(632)).setAttribute("width","12" );
      ((Element)v.get(627)).appendChild((Element)v.get(632));

      /* Empieza nodo:633 / Elemento padre: 632   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(633)).setAttribute("src","b.gif" );
      ((Element)v.get(633)).setAttribute("width","12" );
      ((Element)v.get(633)).setAttribute("height","1" );
      ((Element)v.get(632)).appendChild((Element)v.get(633));
      /* Termina nodo:633   */
      /* Termina nodo:632   */
      /* Termina nodo:627   */
      /* Termina nodo:131   */
      /* Termina nodo:130   */
      /* Termina nodo:43   */


   }

}
