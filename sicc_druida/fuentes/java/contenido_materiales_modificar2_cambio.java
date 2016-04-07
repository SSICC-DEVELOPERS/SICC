
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_materiales_modificar2_cambio  implements es.indra.druida.base.ObjetoXML {
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
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(129)).setAttribute("nombre","capaFormulario" );
      ((Element)v.get(129)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(129)).setAttribute("borde","0" );
      ((Element)v.get(129)).setAttribute("imagenf","" );
      ((Element)v.get(129)).setAttribute("repeat","" );
      ((Element)v.get(129)).setAttribute("padding","" );
      ((Element)v.get(129)).setAttribute("visibilidad","" );
      ((Element)v.get(129)).setAttribute("contravsb","" );
      ((Element)v.get(129)).setAttribute("x","0" );
      ((Element)v.get(129)).setAttribute("y","0" );
      ((Element)v.get(129)).setAttribute("zindex","" );
      ((Element)v.get(43)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("table"));
      ((Element)v.get(130)).setAttribute("width","100%" );
      ((Element)v.get(130)).setAttribute("border","0" );
      ((Element)v.get(130)).setAttribute("cellspacing","0" );
      ((Element)v.get(130)).setAttribute("cellpadding","0" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(130)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("td"));
      ((Element)v.get(132)).setAttribute("width","12" );
      ((Element)v.get(132)).setAttribute("align","center" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(133)).setAttribute("src","b.gif" );
      ((Element)v.get(133)).setAttribute("width","12" );
      ((Element)v.get(133)).setAttribute("height","12" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */

      /* Empieza nodo:134 / Elemento padre: 131   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).setAttribute("width","750" );
      ((Element)v.get(131)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(135)).setAttribute("src","b.gif" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:136 / Elemento padre: 131   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).setAttribute("width","12" );
      ((Element)v.get(131)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(137)).setAttribute("src","b.gif" );
      ((Element)v.get(137)).setAttribute("width","12" );
      ((Element)v.get(137)).setAttribute("height","1" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */
      /* Termina nodo:131   */

      /* Empieza nodo:138 / Elemento padre: 130   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(130)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(138)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(140)).setAttribute("src","b.gif" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:141 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(138)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(141)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(143)).setAttribute("class","legend" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(144)).setAttribute("nombre","lblCriterios" );
      ((Element)v.get(144)).setAttribute("alto","13" );
      ((Element)v.get(144)).setAttribute("filas","1" );
      ((Element)v.get(144)).setAttribute("valor","Datos de material" );
      ((Element)v.get(144)).setAttribute("id","legend" );
      ((Element)v.get(144)).setAttribute("cod","00151" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */

      /* Empieza nodo:145 / Elemento padre: 142   */
      v.add(doc.createElement("table"));
      ((Element)v.get(145)).setAttribute("width","100%" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(145)).setAttribute("border","0" );
      ((Element)v.get(145)).setAttribute("align","center" );
      ((Element)v.get(145)).setAttribute("cellspacing","0" );
      ((Element)v.get(145)).setAttribute("cellpadding","0" );
      ((Element)v.get(142)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(145)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).setAttribute("colspan","4" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(148)).setAttribute("src","b.gif" );
      ((Element)v.get(148)).setAttribute("width","8" );
      ((Element)v.get(148)).setAttribute("height","8" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */
      /* Termina nodo:146   */

      /* Empieza nodo:149 / Elemento padre: 145   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(145)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(151)).setAttribute("src","b.gif" );
      ((Element)v.get(151)).setAttribute("width","8" );
      ((Element)v.get(151)).setAttribute("height","8" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:152 / Elemento padre: 149   */
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(153)).setAttribute("nombre","lblCUV" );
      ((Element)v.get(153)).setAttribute("alto","13" );
      ((Element)v.get(153)).setAttribute("filas","1" );
      ((Element)v.get(153)).setAttribute("valor","" );
      ((Element)v.get(153)).setAttribute("id","datosTitle" );
      ((Element)v.get(153)).setAttribute("cod","3058" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:152   */

      /* Empieza nodo:154 / Elemento padre: 149   */
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(155)).setAttribute("src","b.gif" );
      ((Element)v.get(155)).setAttribute("width","25" );
      ((Element)v.get(155)).setAttribute("height","8" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */
      /* Termina nodo:154   */

      /* Empieza nodo:156 / Elemento padre: 149   */
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(157)).setAttribute("nombre","lblCodSAP" );
      ((Element)v.get(157)).setAttribute("alto","13" );
      ((Element)v.get(157)).setAttribute("filas","1" );
      ((Element)v.get(157)).setAttribute("valor","" );
      ((Element)v.get(157)).setAttribute("id","datosTitle" );
      ((Element)v.get(157)).setAttribute("cod","585" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */
      /* Termina nodo:156   */

      /* Empieza nodo:158 / Elemento padre: 149   */
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(159)).setAttribute("src","b.gif" );
      ((Element)v.get(159)).setAttribute("width","25" );
      ((Element)v.get(159)).setAttribute("height","8" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */

      /* Empieza nodo:160 / Elemento padre: 149   */
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(161)).setAttribute("nombre","lblCodAntiguo" );
      ((Element)v.get(161)).setAttribute("alto","13" );
      ((Element)v.get(161)).setAttribute("filas","1" );
      ((Element)v.get(161)).setAttribute("valor","" );
      ((Element)v.get(161)).setAttribute("id","datosTitle" );
      ((Element)v.get(161)).setAttribute("cod","1059" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:160   */

      /* Empieza nodo:162 / Elemento padre: 149   */
      v.add(doc.createElement("td"));
      ((Element)v.get(162)).setAttribute("width","100%" );
      ((Element)v.get(149)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(163)).setAttribute("src","b.gif" );
      ((Element)v.get(163)).setAttribute("width","8" );
      ((Element)v.get(163)).setAttribute("height","8" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */
      /* Termina nodo:149   */

      /* Empieza nodo:164 / Elemento padre: 145   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(145)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("td"));
      ((Element)v.get(164)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(166)).setAttribute("src","b.gif" );
      ((Element)v.get(166)).setAttribute("width","8" );
      ((Element)v.get(166)).setAttribute("height","8" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:165   */

      /* Empieza nodo:167 / Elemento padre: 164   */
      v.add(doc.createElement("td"));
      ((Element)v.get(167)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(164)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(168)).setAttribute("nombre","lblcodigoUnicoVenta" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(168)).setAttribute("alto","13" );
      ((Element)v.get(168)).setAttribute("filas","1" );
      ((Element)v.get(168)).setAttribute("valor","" );
      ((Element)v.get(168)).setAttribute("id","datosCampos" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */

      /* Empieza nodo:169 / Elemento padre: 164   */
      v.add(doc.createElement("td"));
      ((Element)v.get(164)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(170)).setAttribute("src","b.gif" );
      ((Element)v.get(170)).setAttribute("width","25" );
      ((Element)v.get(170)).setAttribute("height","8" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */

      /* Empieza nodo:171 / Elemento padre: 164   */
      v.add(doc.createElement("td"));
      ((Element)v.get(171)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(164)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(172)).setAttribute("nombre","lblR1" );
      ((Element)v.get(172)).setAttribute("alto","13" );
      ((Element)v.get(172)).setAttribute("filas","1" );
      ((Element)v.get(172)).setAttribute("valor","" );
      ((Element)v.get(172)).setAttribute("id","datosCampos" );
      ((Element)v.get(172)).setAttribute("codi","5" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:171   */

      /* Empieza nodo:173 / Elemento padre: 164   */
      v.add(doc.createElement("td"));
      ((Element)v.get(164)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(174)).setAttribute("src","b.gif" );
      ((Element)v.get(174)).setAttribute("width","25" );
      ((Element)v.get(174)).setAttribute("height","8" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */
      /* Termina nodo:173   */

      /* Empieza nodo:175 / Elemento padre: 164   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(164)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(176)).setAttribute("nombre","txtAnt" );
      ((Element)v.get(176)).setAttribute("id","datosCampos" );
      ((Element)v.get(176)).setAttribute("max","18" );
      ((Element)v.get(176)).setAttribute("tipo","" );
      ((Element)v.get(176)).setAttribute("onchange","" );
      ((Element)v.get(176)).setAttribute("req","N" );
      ((Element)v.get(176)).setAttribute("size","23" );
      ((Element)v.get(176)).setAttribute("valor","" );
      ((Element)v.get(176)).setAttribute("validacion","" );
      ((Element)v.get(176)).setAttribute("ontab","setTabFocus('txtAnt');" );
      ((Element)v.get(176)).setAttribute("onshtab","setSHTabFocus('txtAnt')" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:175   */

      /* Empieza nodo:177 / Elemento padre: 164   */
      v.add(doc.createElement("td"));
      ((Element)v.get(177)).setAttribute("width","100%" );
      ((Element)v.get(164)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(178)).setAttribute("src","b.gif" );
      ((Element)v.get(178)).setAttribute("width","8" );
      ((Element)v.get(178)).setAttribute("height","8" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:177   */
      /* Termina nodo:164   */

      /* Empieza nodo:179 / Elemento padre: 145   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(145)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(180)).setAttribute("colspan","4" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(181)).setAttribute("src","b.gif" );
      ((Element)v.get(181)).setAttribute("width","8" );
      ((Element)v.get(181)).setAttribute("height","8" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:180   */
      /* Termina nodo:179   */
      /* Termina nodo:145   */

      /* Empieza nodo:182 / Elemento padre: 142   */
      v.add(doc.createElement("table"));
      ((Element)v.get(182)).setAttribute("width","100%" );
      ((Element)v.get(182)).setAttribute("border","0" );
      ((Element)v.get(182)).setAttribute("align","center" );
      ((Element)v.get(182)).setAttribute("cellspacing","0" );
      ((Element)v.get(182)).setAttribute("cellpadding","0" );
      ((Element)v.get(142)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(182)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("td"));
      ((Element)v.get(183)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(185)).setAttribute("src","b.gif" );
      ((Element)v.get(185)).setAttribute("width","8" );
      ((Element)v.get(185)).setAttribute("height","8" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */
      /* Termina nodo:184   */

      /* Empieza nodo:186 / Elemento padre: 183   */
      v.add(doc.createElement("td"));
      ((Element)v.get(183)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(187)).setAttribute("nombre","lblDescripcionSAP" );
      ((Element)v.get(187)).setAttribute("alto","13" );
      ((Element)v.get(187)).setAttribute("filas","1" );
      ((Element)v.get(187)).setAttribute("valor","" );
      ((Element)v.get(187)).setAttribute("id","datosTitle" );
      ((Element)v.get(187)).setAttribute("cod","1068" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */
      /* Termina nodo:186   */

      /* Empieza nodo:188 / Elemento padre: 183   */
   }

   private void getXML900(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(183)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(189)).setAttribute("src","b.gif" );
      ((Element)v.get(189)).setAttribute("width","25" );
      ((Element)v.get(189)).setAttribute("height","8" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */
      /* Termina nodo:188   */

      /* Empieza nodo:190 / Elemento padre: 183   */
      v.add(doc.createElement("td"));
      ((Element)v.get(183)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(191)).setAttribute("nombre","lblDescripcionCorta" );
      ((Element)v.get(191)).setAttribute("alto","13" );
      ((Element)v.get(191)).setAttribute("filas","1" );
      ((Element)v.get(191)).setAttribute("valor","" );
      ((Element)v.get(191)).setAttribute("id","datosTitle" );
      ((Element)v.get(191)).setAttribute("cod","47" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */
      /* Termina nodo:190   */

      /* Empieza nodo:192 / Elemento padre: 183   */
      v.add(doc.createElement("td"));
      ((Element)v.get(192)).setAttribute("width","100%" );
      ((Element)v.get(183)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(193)).setAttribute("src","b.gif" );
      ((Element)v.get(193)).setAttribute("width","8" );
      ((Element)v.get(193)).setAttribute("height","8" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:192   */
      /* Termina nodo:183   */

      /* Empieza nodo:194 / Elemento padre: 182   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(182)).appendChild((Element)v.get(194));

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
      ((Element)v.get(197)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(194)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(198)).setAttribute("nombre","txtDSAP" );
      ((Element)v.get(198)).setAttribute("id","datosCampos" );
      ((Element)v.get(198)).setAttribute("max","40" );
      ((Element)v.get(198)).setAttribute("tipo","" );
      ((Element)v.get(198)).setAttribute("onchange","" );
      ((Element)v.get(198)).setAttribute("req","N" );
      ((Element)v.get(198)).setAttribute("size","55" );
      ((Element)v.get(198)).setAttribute("valor","" );
      ((Element)v.get(198)).setAttribute("validacion","" );
      ((Element)v.get(198)).setAttribute("ontab","setTabFocus('txtDSAP');" );
      ((Element)v.get(198)).setAttribute("onshtab","setSHTabFocus('txtDSAP')" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */

      /* Empieza nodo:199 / Elemento padre: 197   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(199)).setAttribute("src","iconmultidioma.gif" );
      ((Element)v.get(199)).setAttribute("onclick","levantarI18N('frmFormulario', 1);" );
      ((Element)v.get(197)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */
      /* Termina nodo:197   */

      /* Empieza nodo:200 / Elemento padre: 194   */
      v.add(doc.createElement("td"));
      ((Element)v.get(194)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(201)).setAttribute("src","b.gif" );
      ((Element)v.get(201)).setAttribute("width","25" );
      ((Element)v.get(201)).setAttribute("height","8" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:200   */

      /* Empieza nodo:202 / Elemento padre: 194   */
      v.add(doc.createElement("td"));
      ((Element)v.get(202)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(194)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(203)).setAttribute("nombre","txtDCorta" );
      ((Element)v.get(203)).setAttribute("id","datosCampos" );
      ((Element)v.get(203)).setAttribute("max","40" );
      ((Element)v.get(203)).setAttribute("tipo","" );
      ((Element)v.get(203)).setAttribute("onchange","" );
      ((Element)v.get(203)).setAttribute("req","N" );
      ((Element)v.get(203)).setAttribute("size","55" );
      ((Element)v.get(203)).setAttribute("valor","" );
      ((Element)v.get(203)).setAttribute("validacion","" );
      ((Element)v.get(203)).setAttribute("ontab","setTabFocus('txtDCorta');" );
      ((Element)v.get(203)).setAttribute("onshtab","setSHTabFocus('txtDCorta')" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:202   */

      /* Empieza nodo:204 / Elemento padre: 194   */
      v.add(doc.createElement("td"));
      ((Element)v.get(204)).setAttribute("width","100%" );
      ((Element)v.get(194)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(205)).setAttribute("src","b.gif" );
      ((Element)v.get(205)).setAttribute("width","8" );
      ((Element)v.get(205)).setAttribute("height","8" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */
      /* Termina nodo:204   */
      /* Termina nodo:194   */

      /* Empieza nodo:206 / Elemento padre: 182   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(182)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("td"));
      ((Element)v.get(207)).setAttribute("colspan","4" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
   }

   private void getXML990(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(208)).setAttribute("src","b.gif" );
      ((Element)v.get(208)).setAttribute("width","8" );
      ((Element)v.get(208)).setAttribute("height","8" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */
      /* Termina nodo:207   */
      /* Termina nodo:206   */
      /* Termina nodo:182   */

      /* Empieza nodo:209 / Elemento padre: 142   */
      v.add(doc.createElement("table"));
      ((Element)v.get(209)).setAttribute("width","100%" );
      ((Element)v.get(209)).setAttribute("border","0" );
      ((Element)v.get(209)).setAttribute("align","center" );
      ((Element)v.get(209)).setAttribute("cellspacing","0" );
      ((Element)v.get(209)).setAttribute("cellpadding","0" );
      ((Element)v.get(142)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(209)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("td"));
      ((Element)v.get(210)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(212)).setAttribute("src","b.gif" );
      ((Element)v.get(212)).setAttribute("width","8" );
      ((Element)v.get(212)).setAttribute("height","8" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */
      /* Termina nodo:211   */

      /* Empieza nodo:213 / Elemento padre: 210   */
      v.add(doc.createElement("td"));
      ((Element)v.get(210)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(214)).setAttribute("nombre","lblIdLote" );
      ((Element)v.get(214)).setAttribute("alto","13" );
      ((Element)v.get(214)).setAttribute("filas","1" );
      ((Element)v.get(214)).setAttribute("valor","" );
      ((Element)v.get(214)).setAttribute("id","datosTitle" );
      ((Element)v.get(214)).setAttribute("cod","1086" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:213   */

      /* Empieza nodo:215 / Elemento padre: 210   */
      v.add(doc.createElement("td"));
      ((Element)v.get(210)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(216)).setAttribute("src","b.gif" );
      ((Element)v.get(216)).setAttribute("width","25" );
      ((Element)v.get(216)).setAttribute("height","8" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */
      /* Termina nodo:215   */

      /* Empieza nodo:217 / Elemento padre: 210   */
      v.add(doc.createElement("td"));
      ((Element)v.get(210)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(218)).setAttribute("nombre","lblIdPS" );
      ((Element)v.get(218)).setAttribute("alto","13" );
      ((Element)v.get(218)).setAttribute("filas","1" );
      ((Element)v.get(218)).setAttribute("valor","" );
      ((Element)v.get(218)).setAttribute("id","datosTitle" );
      ((Element)v.get(218)).setAttribute("cod","1087" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */
      /* Termina nodo:217   */

      /* Empieza nodo:219 / Elemento padre: 210   */
      v.add(doc.createElement("td"));
      ((Element)v.get(210)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(220)).setAttribute("src","b.gif" );
      ((Element)v.get(220)).setAttribute("width","25" );
      ((Element)v.get(220)).setAttribute("height","8" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */
      /* Termina nodo:219   */

      /* Empieza nodo:221 / Elemento padre: 210   */
      v.add(doc.createElement("td"));
      ((Element)v.get(210)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(222)).setAttribute("nombre","lblMarcaProducto" );
      ((Element)v.get(222)).setAttribute("alto","13" );
      ((Element)v.get(222)).setAttribute("filas","1" );
      ((Element)v.get(222)).setAttribute("valor","" );
      ((Element)v.get(222)).setAttribute("id","datosTitle" );
      ((Element)v.get(222)).setAttribute("cod","2448" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */
      /* Termina nodo:221   */

      /* Empieza nodo:223 / Elemento padre: 210   */
      v.add(doc.createElement("td"));
      ((Element)v.get(223)).setAttribute("width","100%" );
      ((Element)v.get(210)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(224)).setAttribute("src","b.gif" );
      ((Element)v.get(224)).setAttribute("width","8" );
      ((Element)v.get(224)).setAttribute("height","8" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */
      /* Termina nodo:223   */
      /* Termina nodo:210   */

      /* Empieza nodo:225 / Elemento padre: 209   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(209)).appendChild((Element)v.get(225));

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
      ((Element)v.get(228)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(225)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("table"));
      ((Element)v.get(229)).setAttribute("width","100%" );
      ((Element)v.get(229)).setAttribute("border","0" );
      ((Element)v.get(229)).setAttribute("cellspacing","0" );
      ((Element)v.get(229)).setAttribute("cellpadding","0" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(228)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(229)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("td"));
      ((Element)v.get(231)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(231)).setAttribute("class","datosCampos" );
      ((Element)v.get(231)).setAttribute("id","tdRadio" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(232)).setAttribute("nombre","rbIdLote" );
      ((Element)v.get(232)).setAttribute("tipo","H" );
      ((Element)v.get(232)).setAttribute("id","datosCampos" );
      ((Element)v.get(232)).setAttribute("onclick","actualizarHiddenRadio();" );
      ((Element)v.get(232)).setAttribute("ontab","setTabFocus('rbIdLote');" );
      ((Element)v.get(232)).setAttribute("onshtab","setSHTabFocus('rbIdLote');" );
      ((Element)v.get(232)).setAttribute("req","S" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(233)).setAttribute("valor","S" );
      ((Element)v.get(233)).setAttribute("check","N" );
      ((Element)v.get(233)).setAttribute("onfocus","" );
      ((Element)v.get(233)).setAttribute("id","datosCampos" );
      ((Element)v.get(233)).setAttribute("cod","117" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));

      /* Elemento padre:233 / Elemento actual: 234   */
      v.add(doc.createTextNode("xxx"));
      ((Element)v.get(233)).appendChild((Text)v.get(234));

      /* Termina nodo Texto:234   */
      /* Termina nodo:233   */

      /* Empieza nodo:235 / Elemento padre: 232   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(235)).setAttribute("valor","N" );
      ((Element)v.get(235)).setAttribute("check","N" );
      ((Element)v.get(235)).setAttribute("onfocus","" );
      ((Element)v.get(235)).setAttribute("id","datosCampos" );
      ((Element)v.get(235)).setAttribute("cod","87" );
      ((Element)v.get(232)).appendChild((Element)v.get(235));

      /* Elemento padre:235 / Elemento actual: 236   */
      v.add(doc.createTextNode("ccc"));
      ((Element)v.get(235)).appendChild((Text)v.get(236));

      /* Termina nodo Texto:236   */
      /* Termina nodo:235   */
      /* Termina nodo:232   */
      /* Termina nodo:231   */
      /* Termina nodo:230   */
      /* Termina nodo:229   */
      /* Termina nodo:228   */

      /* Empieza nodo:237 / Elemento padre: 225   */
      v.add(doc.createElement("td"));
      ((Element)v.get(225)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(238)).setAttribute("src","b.gif" );
      ((Element)v.get(238)).setAttribute("width","25" );
      ((Element)v.get(238)).setAttribute("height","8" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */
      /* Termina nodo:237   */

      /* Empieza nodo:239 / Elemento padre: 225   */
      v.add(doc.createElement("td"));
      ((Element)v.get(239)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(225)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(240)).setAttribute("nombre","cbIdPS" );
      ((Element)v.get(240)).setAttribute("id","datosCampos" );
      ((Element)v.get(240)).setAttribute("size","1" );
      ((Element)v.get(240)).setAttribute("multiple","N" );
      ((Element)v.get(240)).setAttribute("req","N" );
      ((Element)v.get(240)).setAttribute("valorinicial","" );
      ((Element)v.get(240)).setAttribute("textoinicial","" );
      ((Element)v.get(240)).setAttribute("ontab","setTabFocus('cbIdPS');" );
      ((Element)v.get(240)).setAttribute("onshtab","setSHTabFocus('cbIdPS');" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(240)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */
      /* Termina nodo:240   */
      /* Termina nodo:239   */

      /* Empieza nodo:242 / Elemento padre: 225   */
      v.add(doc.createElement("td"));
      ((Element)v.get(225)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(243)).setAttribute("src","b.gif" );
      ((Element)v.get(243)).setAttribute("width","25" );
      ((Element)v.get(243)).setAttribute("height","8" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */
      /* Termina nodo:242   */

      /* Empieza nodo:244 / Elemento padre: 225   */
      v.add(doc.createElement("td"));
      ((Element)v.get(244)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(225)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(245)).setAttribute("nombre","cbM" );
      ((Element)v.get(245)).setAttribute("id","datosCampos" );
      ((Element)v.get(245)).setAttribute("size","1" );
      ((Element)v.get(245)).setAttribute("multiple","N" );
      ((Element)v.get(245)).setAttribute("req","N" );
      ((Element)v.get(245)).setAttribute("valorinicial","" );
      ((Element)v.get(245)).setAttribute("textoinicial","" );
      ((Element)v.get(245)).setAttribute("ontab","setTabFocus('cbM');" );
      ((Element)v.get(245)).setAttribute("onshtab","setSHTabFocus('cbM');" );
      ((Element)v.get(244)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(245)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */
      /* Termina nodo:245   */
      /* Termina nodo:244   */

      /* Empieza nodo:247 / Elemento padre: 225   */
      v.add(doc.createElement("td"));
      ((Element)v.get(247)).setAttribute("width","100%" );
      ((Element)v.get(225)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(248)).setAttribute("src","b.gif" );
      ((Element)v.get(248)).setAttribute("width","8" );
      ((Element)v.get(248)).setAttribute("height","8" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */
      /* Termina nodo:247   */
      /* Termina nodo:225   */

      /* Empieza nodo:249 / Elemento padre: 209   */
      v.add(doc.createElement("tr"));
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(209)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("td"));
      ((Element)v.get(250)).setAttribute("colspan","4" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(251)).setAttribute("src","b.gif" );
      ((Element)v.get(251)).setAttribute("width","8" );
      ((Element)v.get(251)).setAttribute("height","8" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */
      /* Termina nodo:250   */
      /* Termina nodo:249   */
      /* Termina nodo:209   */

      /* Empieza nodo:252 / Elemento padre: 142   */
      v.add(doc.createElement("table"));
      ((Element)v.get(252)).setAttribute("width","100%" );
      ((Element)v.get(252)).setAttribute("border","0" );
      ((Element)v.get(252)).setAttribute("align","center" );
      ((Element)v.get(252)).setAttribute("cellspacing","0" );
      ((Element)v.get(252)).setAttribute("cellpadding","0" );
      ((Element)v.get(142)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(252)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("td"));
      ((Element)v.get(253)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(255)).setAttribute("src","b.gif" );
      ((Element)v.get(255)).setAttribute("width","8" );
      ((Element)v.get(255)).setAttribute("height","8" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */
      /* Termina nodo:254   */

      /* Empieza nodo:256 / Elemento padre: 253   */
      v.add(doc.createElement("td"));
      ((Element)v.get(253)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(257)).setAttribute("nombre","lblUniNegocio" );
      ((Element)v.get(257)).setAttribute("alto","13" );
      ((Element)v.get(257)).setAttribute("filas","1" );
      ((Element)v.get(257)).setAttribute("valor","" );
      ((Element)v.get(257)).setAttribute("id","datosTitle" );
      ((Element)v.get(257)).setAttribute("cod","587" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */
      /* Termina nodo:256   */

      /* Empieza nodo:258 / Elemento padre: 253   */
      v.add(doc.createElement("td"));
      ((Element)v.get(253)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(259)).setAttribute("src","b.gif" );
      ((Element)v.get(259)).setAttribute("width","25" );
      ((Element)v.get(259)).setAttribute("height","8" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */
      /* Termina nodo:258   */

      /* Empieza nodo:260 / Elemento padre: 253   */
      v.add(doc.createElement("td"));
      ((Element)v.get(253)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(261)).setAttribute("nombre","lblNegocio" );
      ((Element)v.get(261)).setAttribute("alto","13" );
      ((Element)v.get(261)).setAttribute("filas","1" );
      ((Element)v.get(261)).setAttribute("valor","" );
      ((Element)v.get(261)).setAttribute("id","datosTitle" );
      ((Element)v.get(261)).setAttribute("cod","588" );
      ((Element)v.get(260)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */
      /* Termina nodo:260   */

      /* Empieza nodo:262 / Elemento padre: 253   */
      v.add(doc.createElement("td"));
      ((Element)v.get(262)).setAttribute("width","100%" );
      ((Element)v.get(253)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(263)).setAttribute("src","b.gif" );
      ((Element)v.get(263)).setAttribute("width","8" );
      ((Element)v.get(263)).setAttribute("height","8" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */
      /* Termina nodo:262   */
      /* Termina nodo:253   */

      /* Empieza nodo:264 / Elemento padre: 252   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(252)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("td"));
      ((Element)v.get(264)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(266)).setAttribute("src","b.gif" );
      ((Element)v.get(266)).setAttribute("width","8" );
      ((Element)v.get(266)).setAttribute("height","8" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */
      /* Termina nodo:265   */

      /* Empieza nodo:267 / Elemento padre: 264   */
      v.add(doc.createElement("td"));
      ((Element)v.get(267)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(264)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(268)).setAttribute("nombre","cbUN" );
      ((Element)v.get(268)).setAttribute("id","datosCampos" );
      ((Element)v.get(268)).setAttribute("size","1" );
      ((Element)v.get(268)).setAttribute("multiple","N" );
      ((Element)v.get(268)).setAttribute("req","N" );
      ((Element)v.get(268)).setAttribute("valorinicial","" );
      ((Element)v.get(268)).setAttribute("textoinicial","" );
      ((Element)v.get(268)).setAttribute("ontab","setTabFocus('cbUN');" );
      ((Element)v.get(268)).setAttribute("onshtab","setSHTabFocus('cbUN');" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(268)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */
      /* Termina nodo:268   */
      /* Termina nodo:267   */

      /* Empieza nodo:270 / Elemento padre: 264   */
      v.add(doc.createElement("td"));
      ((Element)v.get(264)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(271)).setAttribute("src","b.gif" );
      ((Element)v.get(271)).setAttribute("width","25" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(271)).setAttribute("height","8" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */
      /* Termina nodo:270   */

      /* Empieza nodo:272 / Elemento padre: 264   */
      v.add(doc.createElement("td"));
      ((Element)v.get(272)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(264)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(273)).setAttribute("nombre","cbNeg" );
      ((Element)v.get(273)).setAttribute("id","datosCampos" );
      ((Element)v.get(273)).setAttribute("size","1" );
      ((Element)v.get(273)).setAttribute("multiple","N" );
      ((Element)v.get(273)).setAttribute("req","N" );
      ((Element)v.get(273)).setAttribute("valorinicial","" );
      ((Element)v.get(273)).setAttribute("textoinicial","" );
      ((Element)v.get(273)).setAttribute("ontab","setTabFocus('cbNeg');" );
      ((Element)v.get(273)).setAttribute("onshtab","setSHTabFocus('cbNeg');" );
      ((Element)v.get(272)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(273)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */
      /* Termina nodo:273   */
      /* Termina nodo:272   */

      /* Empieza nodo:275 / Elemento padre: 264   */
      v.add(doc.createElement("td"));
      ((Element)v.get(275)).setAttribute("width","100%" );
      ((Element)v.get(264)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(276)).setAttribute("src","b.gif" );
      ((Element)v.get(276)).setAttribute("width","8" );
      ((Element)v.get(276)).setAttribute("height","8" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */
      /* Termina nodo:275   */
      /* Termina nodo:264   */

      /* Empieza nodo:277 / Elemento padre: 252   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(252)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("td"));
      ((Element)v.get(278)).setAttribute("colspan","4" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(279)).setAttribute("src","b.gif" );
      ((Element)v.get(279)).setAttribute("width","8" );
      ((Element)v.get(279)).setAttribute("height","8" );
      ((Element)v.get(278)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */
      /* Termina nodo:278   */
      /* Termina nodo:277   */
      /* Termina nodo:252   */

      /* Empieza nodo:280 / Elemento padre: 142   */
      v.add(doc.createElement("table"));
      ((Element)v.get(280)).setAttribute("width","100%" );
      ((Element)v.get(280)).setAttribute("border","0" );
      ((Element)v.get(280)).setAttribute("align","center" );
      ((Element)v.get(280)).setAttribute("cellspacing","0" );
      ((Element)v.get(280)).setAttribute("cellpadding","0" );
      ((Element)v.get(142)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(280)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("td"));
      ((Element)v.get(281)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(283)).setAttribute("src","b.gif" );
      ((Element)v.get(283)).setAttribute("width","8" );
      ((Element)v.get(283)).setAttribute("height","8" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */
      /* Termina nodo:282   */

      /* Empieza nodo:284 / Elemento padre: 281   */
      v.add(doc.createElement("td"));
      ((Element)v.get(281)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(285)).setAttribute("nombre","lblGenerico" );
      ((Element)v.get(285)).setAttribute("alto","13" );
      ((Element)v.get(285)).setAttribute("filas","1" );
      ((Element)v.get(285)).setAttribute("valor","" );
      ((Element)v.get(285)).setAttribute("id","datosTitle" );
      ((Element)v.get(285)).setAttribute("cod","589" );
      ((Element)v.get(284)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */
      /* Termina nodo:284   */

      /* Empieza nodo:286 / Elemento padre: 281   */
      v.add(doc.createElement("td"));
      ((Element)v.get(281)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(287)).setAttribute("src","b.gif" );
      ((Element)v.get(287)).setAttribute("width","25" );
      ((Element)v.get(287)).setAttribute("height","8" );
      ((Element)v.get(286)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */
      /* Termina nodo:286   */

      /* Empieza nodo:288 / Elemento padre: 281   */
      v.add(doc.createElement("td"));
      ((Element)v.get(281)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(289)).setAttribute("nombre","lblSupergenerico" );
      ((Element)v.get(289)).setAttribute("alto","13" );
      ((Element)v.get(289)).setAttribute("filas","1" );
      ((Element)v.get(289)).setAttribute("valor","" );
      ((Element)v.get(289)).setAttribute("id","datosTitle" );
      ((Element)v.get(289)).setAttribute("cod","590" );
      ((Element)v.get(288)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */
      /* Termina nodo:288   */

      /* Empieza nodo:290 / Elemento padre: 281   */
      v.add(doc.createElement("td"));
      ((Element)v.get(290)).setAttribute("width","100%" );
      ((Element)v.get(281)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(291)).setAttribute("src","b.gif" );
      ((Element)v.get(291)).setAttribute("width","8" );
      ((Element)v.get(291)).setAttribute("height","8" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */
      /* Termina nodo:290   */
      /* Termina nodo:281   */

      /* Empieza nodo:292 / Elemento padre: 280   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(280)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("td"));
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(292)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(294)).setAttribute("src","b.gif" );
      ((Element)v.get(294)).setAttribute("width","8" );
      ((Element)v.get(294)).setAttribute("height","8" );
      ((Element)v.get(293)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */
      /* Termina nodo:293   */

      /* Empieza nodo:295 / Elemento padre: 292   */
      v.add(doc.createElement("td"));
      ((Element)v.get(295)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(292)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(296)).setAttribute("nombre","cbGenr" );
      ((Element)v.get(296)).setAttribute("id","datosCampos" );
      ((Element)v.get(296)).setAttribute("size","1" );
      ((Element)v.get(296)).setAttribute("multiple","N" );
      ((Element)v.get(296)).setAttribute("req","N" );
      ((Element)v.get(296)).setAttribute("valorinicial","" );
      ((Element)v.get(296)).setAttribute("textoinicial","" );
      ((Element)v.get(296)).setAttribute("ontab","setTabFocus('cbGenr');" );
      ((Element)v.get(296)).setAttribute("onshtab","setSHTabFocus('cbGenr');" );
      ((Element)v.get(295)).appendChild((Element)v.get(296));

      /* Empieza nodo:297 / Elemento padre: 296   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(296)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */
      /* Termina nodo:296   */
      /* Termina nodo:295   */

      /* Empieza nodo:298 / Elemento padre: 292   */
      v.add(doc.createElement("td"));
      ((Element)v.get(292)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(299)).setAttribute("src","b.gif" );
      ((Element)v.get(299)).setAttribute("width","25" );
      ((Element)v.get(299)).setAttribute("height","8" );
      ((Element)v.get(298)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */
      /* Termina nodo:298   */

      /* Empieza nodo:300 / Elemento padre: 292   */
      v.add(doc.createElement("td"));
      ((Element)v.get(300)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(292)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(301)).setAttribute("nombre","cbSuperGeg" );
      ((Element)v.get(301)).setAttribute("id","datosCampos" );
      ((Element)v.get(301)).setAttribute("size","1" );
      ((Element)v.get(301)).setAttribute("multiple","N" );
      ((Element)v.get(301)).setAttribute("req","N" );
      ((Element)v.get(301)).setAttribute("valorinicial","" );
      ((Element)v.get(301)).setAttribute("textoinicial","" );
      ((Element)v.get(301)).setAttribute("ontab","setTabFocus('cbSuperGeg');" );
      ((Element)v.get(301)).setAttribute("onshtab","setSHTabFocus('cbSuperGeg');" );
      ((Element)v.get(300)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(301)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */
      /* Termina nodo:301   */
      /* Termina nodo:300   */

      /* Empieza nodo:303 / Elemento padre: 292   */
      v.add(doc.createElement("td"));
      ((Element)v.get(303)).setAttribute("width","100%" );
      ((Element)v.get(292)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(304)).setAttribute("src","b.gif" );
      ((Element)v.get(304)).setAttribute("width","8" );
      ((Element)v.get(304)).setAttribute("height","8" );
      ((Element)v.get(303)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */
      /* Termina nodo:303   */
      /* Termina nodo:292   */

      /* Empieza nodo:305 / Elemento padre: 280   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(280)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("td"));
      ((Element)v.get(306)).setAttribute("colspan","4" );
      ((Element)v.get(305)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(307)).setAttribute("src","b.gif" );
      ((Element)v.get(307)).setAttribute("width","8" );
      ((Element)v.get(307)).setAttribute("height","8" );
      ((Element)v.get(306)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */
      /* Termina nodo:306   */
      /* Termina nodo:305   */
      /* Termina nodo:280   */

      /* Empieza nodo:308 / Elemento padre: 142   */
      v.add(doc.createElement("table"));
      ((Element)v.get(308)).setAttribute("width","100%" );
      ((Element)v.get(308)).setAttribute("border","0" );
      ((Element)v.get(308)).setAttribute("align","center" );
      ((Element)v.get(308)).setAttribute("cellspacing","0" );
      ((Element)v.get(308)).setAttribute("cellpadding","0" );
      ((Element)v.get(142)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(308)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("td"));
      ((Element)v.get(309)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(311)).setAttribute("src","b.gif" );
      ((Element)v.get(311)).setAttribute("width","8" );
      ((Element)v.get(311)).setAttribute("height","8" );
      ((Element)v.get(310)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */
      /* Termina nodo:310   */

      /* Empieza nodo:312 / Elemento padre: 309   */
      v.add(doc.createElement("td"));
      ((Element)v.get(309)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(313)).setAttribute("nombre","lblJerar1" );
      ((Element)v.get(313)).setAttribute("alto","13" );
      ((Element)v.get(313)).setAttribute("filas","1" );
      ((Element)v.get(313)).setAttribute("valor","" );
      ((Element)v.get(313)).setAttribute("id","datosTitle" );
      ((Element)v.get(313)).setAttribute("cod","1088" );
      ((Element)v.get(312)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */
      /* Termina nodo:312   */

      /* Empieza nodo:314 / Elemento padre: 309   */
      v.add(doc.createElement("td"));
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(309)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(315)).setAttribute("src","b.gif" );
      ((Element)v.get(315)).setAttribute("width","25" );
      ((Element)v.get(315)).setAttribute("height","8" );
      ((Element)v.get(314)).appendChild((Element)v.get(315));
      /* Termina nodo:315   */
      /* Termina nodo:314   */

      /* Empieza nodo:316 / Elemento padre: 309   */
      v.add(doc.createElement("td"));
      ((Element)v.get(309)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(317)).setAttribute("nombre","lblJerar2" );
      ((Element)v.get(317)).setAttribute("alto","13" );
      ((Element)v.get(317)).setAttribute("filas","1" );
      ((Element)v.get(317)).setAttribute("valor","" );
      ((Element)v.get(317)).setAttribute("id","datosTitle" );
      ((Element)v.get(317)).setAttribute("cod","1089" );
      ((Element)v.get(316)).appendChild((Element)v.get(317));
      /* Termina nodo:317   */
      /* Termina nodo:316   */

      /* Empieza nodo:318 / Elemento padre: 309   */
      v.add(doc.createElement("td"));
      ((Element)v.get(309)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(319)).setAttribute("src","b.gif" );
      ((Element)v.get(319)).setAttribute("width","25" );
      ((Element)v.get(319)).setAttribute("height","8" );
      ((Element)v.get(318)).appendChild((Element)v.get(319));
      /* Termina nodo:319   */
      /* Termina nodo:318   */

      /* Empieza nodo:320 / Elemento padre: 309   */
      v.add(doc.createElement("td"));
      ((Element)v.get(309)).appendChild((Element)v.get(320));

      /* Empieza nodo:321 / Elemento padre: 320   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(321)).setAttribute("nombre","lblJerar3" );
      ((Element)v.get(321)).setAttribute("alto","13" );
      ((Element)v.get(321)).setAttribute("filas","1" );
      ((Element)v.get(321)).setAttribute("valor","" );
      ((Element)v.get(321)).setAttribute("id","datosTitle" );
      ((Element)v.get(321)).setAttribute("cod","1090" );
      ((Element)v.get(320)).appendChild((Element)v.get(321));
      /* Termina nodo:321   */
      /* Termina nodo:320   */

      /* Empieza nodo:322 / Elemento padre: 309   */
      v.add(doc.createElement("td"));
      ((Element)v.get(309)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(323)).setAttribute("src","b.gif" );
      ((Element)v.get(323)).setAttribute("width","25" );
      ((Element)v.get(323)).setAttribute("height","8" );
      ((Element)v.get(322)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */
      /* Termina nodo:322   */

      /* Empieza nodo:324 / Elemento padre: 309   */
      v.add(doc.createElement("td"));
      ((Element)v.get(309)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(325)).setAttribute("nombre","lblLinea" );
      ((Element)v.get(325)).setAttribute("alto","13" );
      ((Element)v.get(325)).setAttribute("filas","1" );
      ((Element)v.get(325)).setAttribute("valor","" );
      ((Element)v.get(325)).setAttribute("id","datosTitle" );
      ((Element)v.get(325)).setAttribute("cod","586" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */
      /* Termina nodo:324   */

      /* Empieza nodo:326 / Elemento padre: 309   */
      v.add(doc.createElement("td"));
      ((Element)v.get(326)).setAttribute("width","100%" );
      ((Element)v.get(309)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(327)).setAttribute("src","b.gif" );
      ((Element)v.get(327)).setAttribute("width","8" );
      ((Element)v.get(327)).setAttribute("height","8" );
      ((Element)v.get(326)).appendChild((Element)v.get(327));
      /* Termina nodo:327   */
      /* Termina nodo:326   */
      /* Termina nodo:309   */

      /* Empieza nodo:328 / Elemento padre: 308   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(308)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("td"));
      ((Element)v.get(328)).appendChild((Element)v.get(329));

      /* Empieza nodo:330 / Elemento padre: 329   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(330)).setAttribute("src","b.gif" );
      ((Element)v.get(330)).setAttribute("width","8" );
      ((Element)v.get(330)).setAttribute("height","8" );
      ((Element)v.get(329)).appendChild((Element)v.get(330));
      /* Termina nodo:330   */
      /* Termina nodo:329   */

      /* Empieza nodo:331 / Elemento padre: 328   */
      v.add(doc.createElement("td"));
      ((Element)v.get(331)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(328)).appendChild((Element)v.get(331));

      /* Empieza nodo:332 / Elemento padre: 331   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(332)).setAttribute("nombre","txtJ1" );
      ((Element)v.get(332)).setAttribute("id","datosCampos" );
      ((Element)v.get(332)).setAttribute("max","3" );
      ((Element)v.get(332)).setAttribute("tipo","" );
      ((Element)v.get(332)).setAttribute("onchange","" );
      ((Element)v.get(332)).setAttribute("req","N" );
      ((Element)v.get(332)).setAttribute("size","3" );
      ((Element)v.get(332)).setAttribute("valor","" );
      ((Element)v.get(332)).setAttribute("validacion","" );
      ((Element)v.get(332)).setAttribute("ontab","setTabFocus('txtJ1');" );
      ((Element)v.get(332)).setAttribute("onshtab","setSHTabFocus('txtJ1');" );
      ((Element)v.get(331)).appendChild((Element)v.get(332));
      /* Termina nodo:332   */
      /* Termina nodo:331   */

      /* Empieza nodo:333 / Elemento padre: 328   */
      v.add(doc.createElement("td"));
      ((Element)v.get(328)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(334)).setAttribute("src","b.gif" );
      ((Element)v.get(334)).setAttribute("width","25" );
      ((Element)v.get(334)).setAttribute("height","8" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */
      /* Termina nodo:333   */

      /* Empieza nodo:335 / Elemento padre: 328   */
   }

   private void getXML1530(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(335)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(328)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(336)).setAttribute("nombre","txtJ2" );
      ((Element)v.get(336)).setAttribute("id","datosCampos" );
      ((Element)v.get(336)).setAttribute("max","3" );
      ((Element)v.get(336)).setAttribute("tipo","" );
      ((Element)v.get(336)).setAttribute("onchange","" );
      ((Element)v.get(336)).setAttribute("req","N" );
      ((Element)v.get(336)).setAttribute("size","3" );
      ((Element)v.get(336)).setAttribute("valor","" );
      ((Element)v.get(336)).setAttribute("validacion","" );
      ((Element)v.get(336)).setAttribute("ontab","setTabFocus('txtJ2');" );
      ((Element)v.get(336)).setAttribute("onshtab","setSHTabFocus('txtJ2');" );
      ((Element)v.get(335)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */
      /* Termina nodo:335   */

      /* Empieza nodo:337 / Elemento padre: 328   */
      v.add(doc.createElement("td"));
      ((Element)v.get(328)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(338)).setAttribute("src","b.gif" );
      ((Element)v.get(338)).setAttribute("width","25" );
      ((Element)v.get(338)).setAttribute("height","8" );
      ((Element)v.get(337)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */
      /* Termina nodo:337   */

      /* Empieza nodo:339 / Elemento padre: 328   */
      v.add(doc.createElement("td"));
      ((Element)v.get(339)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(328)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(340)).setAttribute("nombre","txtJ3" );
      ((Element)v.get(340)).setAttribute("id","datosCampos" );
      ((Element)v.get(340)).setAttribute("max","3" );
      ((Element)v.get(340)).setAttribute("tipo","" );
      ((Element)v.get(340)).setAttribute("onchange","" );
      ((Element)v.get(340)).setAttribute("req","N" );
      ((Element)v.get(340)).setAttribute("size","3" );
      ((Element)v.get(340)).setAttribute("valor","" );
      ((Element)v.get(340)).setAttribute("validacion","" );
      ((Element)v.get(340)).setAttribute("ontab","setTabFocus('txtJ3');" );
      ((Element)v.get(340)).setAttribute("onshtab","setSHTabFocus('txtJ3');" );
      ((Element)v.get(339)).appendChild((Element)v.get(340));
      /* Termina nodo:340   */
      /* Termina nodo:339   */

      /* Empieza nodo:341 / Elemento padre: 328   */
      v.add(doc.createElement("td"));
      ((Element)v.get(328)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(342)).setAttribute("src","b.gif" );
      ((Element)v.get(342)).setAttribute("width","25" );
      ((Element)v.get(342)).setAttribute("height","8" );
      ((Element)v.get(341)).appendChild((Element)v.get(342));
      /* Termina nodo:342   */
      /* Termina nodo:341   */

      /* Empieza nodo:343 / Elemento padre: 328   */
      v.add(doc.createElement("td"));
      ((Element)v.get(343)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(328)).appendChild((Element)v.get(343));

      /* Empieza nodo:344 / Elemento padre: 343   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(344)).setAttribute("nombre","cbLin" );
      ((Element)v.get(344)).setAttribute("id","datosCampos" );
      ((Element)v.get(344)).setAttribute("size","1" );
      ((Element)v.get(344)).setAttribute("multiple","N" );
      ((Element)v.get(344)).setAttribute("req","N" );
      ((Element)v.get(344)).setAttribute("valorinicial","" );
      ((Element)v.get(344)).setAttribute("textoinicial","" );
      ((Element)v.get(344)).setAttribute("ontab","setTabFocus('cbLin');" );
      ((Element)v.get(344)).setAttribute("onshtab","setSHTabFocus('cbLin');" );
      ((Element)v.get(343)).appendChild((Element)v.get(344));

      /* Empieza nodo:345 / Elemento padre: 344   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(344)).appendChild((Element)v.get(345));
      /* Termina nodo:345   */
      /* Termina nodo:344   */
      /* Termina nodo:343   */

      /* Empieza nodo:346 / Elemento padre: 328   */
      v.add(doc.createElement("td"));
      ((Element)v.get(346)).setAttribute("width","100%" );
      ((Element)v.get(328)).appendChild((Element)v.get(346));

      /* Empieza nodo:347 / Elemento padre: 346   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(347)).setAttribute("src","b.gif" );
      ((Element)v.get(347)).setAttribute("width","8" );
      ((Element)v.get(347)).setAttribute("height","8" );
      ((Element)v.get(346)).appendChild((Element)v.get(347));
      /* Termina nodo:347   */
      /* Termina nodo:346   */
      /* Termina nodo:328   */

      /* Empieza nodo:348 / Elemento padre: 308   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(308)).appendChild((Element)v.get(348));

      /* Empieza nodo:349 / Elemento padre: 348   */
      v.add(doc.createElement("td"));
      ((Element)v.get(349)).setAttribute("colspan","4" );
      ((Element)v.get(348)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(350)).setAttribute("src","b.gif" );
      ((Element)v.get(350)).setAttribute("width","8" );
      ((Element)v.get(350)).setAttribute("height","8" );
      ((Element)v.get(349)).appendChild((Element)v.get(350));
      /* Termina nodo:350   */
      /* Termina nodo:349   */
      /* Termina nodo:348   */
      /* Termina nodo:308   */

      /* Empieza nodo:351 / Elemento padre: 142   */
      v.add(doc.createElement("table"));
      ((Element)v.get(351)).setAttribute("width","100%" );
      ((Element)v.get(351)).setAttribute("border","0" );
      ((Element)v.get(351)).setAttribute("align","center" );
      ((Element)v.get(351)).setAttribute("cellspacing","0" );
      ((Element)v.get(351)).setAttribute("cellpadding","0" );
      ((Element)v.get(142)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(351)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
      v.add(doc.createElement("td"));
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(352)).appendChild((Element)v.get(353));

      /* Empieza nodo:354 / Elemento padre: 353   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(354)).setAttribute("src","b.gif" );
      ((Element)v.get(354)).setAttribute("width","8" );
      ((Element)v.get(354)).setAttribute("height","8" );
      ((Element)v.get(353)).appendChild((Element)v.get(354));
      /* Termina nodo:354   */
      /* Termina nodo:353   */

      /* Empieza nodo:355 / Elemento padre: 352   */
      v.add(doc.createElement("td"));
      ((Element)v.get(352)).appendChild((Element)v.get(355));

      /* Empieza nodo:356 / Elemento padre: 355   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(356)).setAttribute("nombre","lblAtrib1" );
      ((Element)v.get(356)).setAttribute("alto","13" );
      ((Element)v.get(356)).setAttribute("filas","1" );
      ((Element)v.get(356)).setAttribute("valor","" );
      ((Element)v.get(356)).setAttribute("id","datosTitle" );
      ((Element)v.get(356)).setAttribute("cod","481" );
      ((Element)v.get(355)).appendChild((Element)v.get(356));
      /* Termina nodo:356   */
      /* Termina nodo:355   */

      /* Empieza nodo:357 / Elemento padre: 352   */
      v.add(doc.createElement("td"));
      ((Element)v.get(352)).appendChild((Element)v.get(357));

      /* Empieza nodo:358 / Elemento padre: 357   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(358)).setAttribute("src","b.gif" );
      ((Element)v.get(358)).setAttribute("width","25" );
      ((Element)v.get(358)).setAttribute("height","8" );
      ((Element)v.get(357)).appendChild((Element)v.get(358));
      /* Termina nodo:358   */
      /* Termina nodo:357   */

      /* Empieza nodo:359 / Elemento padre: 352   */
      v.add(doc.createElement("td"));
      ((Element)v.get(352)).appendChild((Element)v.get(359));

      /* Empieza nodo:360 / Elemento padre: 359   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(360)).setAttribute("nombre","lblAtrib2" );
      ((Element)v.get(360)).setAttribute("alto","13" );
      ((Element)v.get(360)).setAttribute("filas","1" );
      ((Element)v.get(360)).setAttribute("valor","" );
      ((Element)v.get(360)).setAttribute("id","datosTitle" );
      ((Element)v.get(360)).setAttribute("cod","482" );
      ((Element)v.get(359)).appendChild((Element)v.get(360));
      /* Termina nodo:360   */
      /* Termina nodo:359   */

      /* Empieza nodo:361 / Elemento padre: 352   */
      v.add(doc.createElement("td"));
      ((Element)v.get(352)).appendChild((Element)v.get(361));

      /* Empieza nodo:362 / Elemento padre: 361   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(362)).setAttribute("src","b.gif" );
      ((Element)v.get(362)).setAttribute("width","25" );
      ((Element)v.get(362)).setAttribute("height","8" );
      ((Element)v.get(361)).appendChild((Element)v.get(362));
      /* Termina nodo:362   */
      /* Termina nodo:361   */

      /* Empieza nodo:363 / Elemento padre: 352   */
      v.add(doc.createElement("td"));
      ((Element)v.get(352)).appendChild((Element)v.get(363));

      /* Empieza nodo:364 / Elemento padre: 363   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(364)).setAttribute("nombre","lblAtrib3" );
      ((Element)v.get(364)).setAttribute("alto","13" );
      ((Element)v.get(364)).setAttribute("filas","1" );
      ((Element)v.get(364)).setAttribute("valor","" );
      ((Element)v.get(364)).setAttribute("id","datosTitle" );
      ((Element)v.get(364)).setAttribute("cod","483" );
      ((Element)v.get(363)).appendChild((Element)v.get(364));
      /* Termina nodo:364   */
      /* Termina nodo:363   */

      /* Empieza nodo:365 / Elemento padre: 352   */
      v.add(doc.createElement("td"));
      ((Element)v.get(365)).setAttribute("width","100%" );
      ((Element)v.get(352)).appendChild((Element)v.get(365));

      /* Empieza nodo:366 / Elemento padre: 365   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(366)).setAttribute("src","b.gif" );
      ((Element)v.get(366)).setAttribute("width","8" );
      ((Element)v.get(366)).setAttribute("height","8" );
      ((Element)v.get(365)).appendChild((Element)v.get(366));
      /* Termina nodo:366   */
      /* Termina nodo:365   */
      /* Termina nodo:352   */

      /* Empieza nodo:367 / Elemento padre: 351   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(351)).appendChild((Element)v.get(367));

      /* Empieza nodo:368 / Elemento padre: 367   */
      v.add(doc.createElement("td"));
      ((Element)v.get(367)).appendChild((Element)v.get(368));

      /* Empieza nodo:369 / Elemento padre: 368   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(369)).setAttribute("src","b.gif" );
      ((Element)v.get(369)).setAttribute("width","8" );
      ((Element)v.get(369)).setAttribute("height","8" );
      ((Element)v.get(368)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */
      /* Termina nodo:368   */

      /* Empieza nodo:370 / Elemento padre: 367   */
      v.add(doc.createElement("td"));
      ((Element)v.get(370)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(367)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(371)).setAttribute("nombre","txtA1" );
      ((Element)v.get(371)).setAttribute("id","datosCampos" );
      ((Element)v.get(371)).setAttribute("max","3" );
      ((Element)v.get(371)).setAttribute("tipo","" );
      ((Element)v.get(371)).setAttribute("onchange","" );
      ((Element)v.get(371)).setAttribute("req","N" );
      ((Element)v.get(371)).setAttribute("size","3" );
      ((Element)v.get(371)).setAttribute("valor","" );
      ((Element)v.get(371)).setAttribute("validacion","" );
      ((Element)v.get(371)).setAttribute("ontab","setTabFocus('txtA1');" );
      ((Element)v.get(371)).setAttribute("onshtab","setSHTabFocus('txtA1');" );
      ((Element)v.get(370)).appendChild((Element)v.get(371));
      /* Termina nodo:371   */
      /* Termina nodo:370   */

      /* Empieza nodo:372 / Elemento padre: 367   */
      v.add(doc.createElement("td"));
      ((Element)v.get(367)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(373)).setAttribute("src","b.gif" );
      ((Element)v.get(373)).setAttribute("width","25" );
      ((Element)v.get(373)).setAttribute("height","8" );
      ((Element)v.get(372)).appendChild((Element)v.get(373));
      /* Termina nodo:373   */
      /* Termina nodo:372   */

      /* Empieza nodo:374 / Elemento padre: 367   */
   }

   private void getXML1710(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(374)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(367)).appendChild((Element)v.get(374));

      /* Empieza nodo:375 / Elemento padre: 374   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(375)).setAttribute("nombre","txtA2" );
      ((Element)v.get(375)).setAttribute("id","datosCampos" );
      ((Element)v.get(375)).setAttribute("max","4" );
      ((Element)v.get(375)).setAttribute("tipo","" );
      ((Element)v.get(375)).setAttribute("onchange","" );
      ((Element)v.get(375)).setAttribute("req","N" );
      ((Element)v.get(375)).setAttribute("size","4" );
      ((Element)v.get(375)).setAttribute("valor","" );
      ((Element)v.get(375)).setAttribute("validacion","" );
      ((Element)v.get(375)).setAttribute("ontab","setTabFocus('txtA2');" );
      ((Element)v.get(375)).setAttribute("onshtab","setSHTabFocus('txtA2');" );
      ((Element)v.get(374)).appendChild((Element)v.get(375));
      /* Termina nodo:375   */
      /* Termina nodo:374   */

      /* Empieza nodo:376 / Elemento padre: 367   */
      v.add(doc.createElement("td"));
      ((Element)v.get(367)).appendChild((Element)v.get(376));

      /* Empieza nodo:377 / Elemento padre: 376   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(377)).setAttribute("src","b.gif" );
      ((Element)v.get(377)).setAttribute("width","25" );
      ((Element)v.get(377)).setAttribute("height","8" );
      ((Element)v.get(376)).appendChild((Element)v.get(377));
      /* Termina nodo:377   */
      /* Termina nodo:376   */

      /* Empieza nodo:378 / Elemento padre: 367   */
      v.add(doc.createElement("td"));
      ((Element)v.get(378)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(367)).appendChild((Element)v.get(378));

      /* Empieza nodo:379 / Elemento padre: 378   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(379)).setAttribute("nombre","txtA3" );
      ((Element)v.get(379)).setAttribute("id","datosCampos" );
      ((Element)v.get(379)).setAttribute("max","10" );
      ((Element)v.get(379)).setAttribute("tipo","" );
      ((Element)v.get(379)).setAttribute("onchange","" );
      ((Element)v.get(379)).setAttribute("req","N" );
      ((Element)v.get(379)).setAttribute("size","12" );
      ((Element)v.get(379)).setAttribute("valor","" );
      ((Element)v.get(379)).setAttribute("validacion","" );
      ((Element)v.get(379)).setAttribute("ontab","setTabFocus('txtA3');" );
      ((Element)v.get(379)).setAttribute("onshtab","setSHTabFocus('txtA3');" );
      ((Element)v.get(378)).appendChild((Element)v.get(379));
      /* Termina nodo:379   */
      /* Termina nodo:378   */

      /* Empieza nodo:380 / Elemento padre: 367   */
      v.add(doc.createElement("td"));
      ((Element)v.get(380)).setAttribute("width","100%" );
      ((Element)v.get(367)).appendChild((Element)v.get(380));

      /* Empieza nodo:381 / Elemento padre: 380   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(381)).setAttribute("src","b.gif" );
      ((Element)v.get(381)).setAttribute("width","8" );
      ((Element)v.get(381)).setAttribute("height","8" );
      ((Element)v.get(380)).appendChild((Element)v.get(381));
      /* Termina nodo:381   */
      /* Termina nodo:380   */
      /* Termina nodo:367   */

      /* Empieza nodo:382 / Elemento padre: 351   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(351)).appendChild((Element)v.get(382));

      /* Empieza nodo:383 / Elemento padre: 382   */
      v.add(doc.createElement("td"));
      ((Element)v.get(383)).setAttribute("colspan","4" );
      ((Element)v.get(382)).appendChild((Element)v.get(383));

      /* Empieza nodo:384 / Elemento padre: 383   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(384)).setAttribute("src","b.gif" );
      ((Element)v.get(384)).setAttribute("width","8" );
      ((Element)v.get(384)).setAttribute("height","8" );
      ((Element)v.get(383)).appendChild((Element)v.get(384));
      /* Termina nodo:384   */
      /* Termina nodo:383   */
      /* Termina nodo:382   */
      /* Termina nodo:351   */

      /* Empieza nodo:385 / Elemento padre: 142   */
      v.add(doc.createElement("table"));
      ((Element)v.get(385)).setAttribute("width","100%" );
      ((Element)v.get(385)).setAttribute("border","0" );
      ((Element)v.get(385)).setAttribute("align","center" );
      ((Element)v.get(385)).setAttribute("cellspacing","0" );
      ((Element)v.get(385)).setAttribute("cellpadding","0" );
      ((Element)v.get(142)).appendChild((Element)v.get(385));

      /* Empieza nodo:386 / Elemento padre: 385   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(385)).appendChild((Element)v.get(386));

      /* Empieza nodo:387 / Elemento padre: 386   */
      v.add(doc.createElement("td"));
      ((Element)v.get(386)).appendChild((Element)v.get(387));

      /* Empieza nodo:388 / Elemento padre: 387   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(388)).setAttribute("src","b.gif" );
      ((Element)v.get(388)).setAttribute("width","8" );
      ((Element)v.get(388)).setAttribute("height","8" );
      ((Element)v.get(387)).appendChild((Element)v.get(388));
      /* Termina nodo:388   */
      /* Termina nodo:387   */

      /* Empieza nodo:389 / Elemento padre: 386   */
      v.add(doc.createElement("td"));
      ((Element)v.get(386)).appendChild((Element)v.get(389));

      /* Empieza nodo:390 / Elemento padre: 389   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(390)).setAttribute("nombre","lblAlto" );
      ((Element)v.get(390)).setAttribute("alto","13" );
      ((Element)v.get(390)).setAttribute("filas","1" );
      ((Element)v.get(390)).setAttribute("valor","" );
      ((Element)v.get(390)).setAttribute("id","datosTitle" );
      ((Element)v.get(390)).setAttribute("cod","1070" );
      ((Element)v.get(389)).appendChild((Element)v.get(390));
      /* Termina nodo:390   */
      /* Termina nodo:389   */

      /* Empieza nodo:391 / Elemento padre: 386   */
      v.add(doc.createElement("td"));
      ((Element)v.get(386)).appendChild((Element)v.get(391));

      /* Empieza nodo:392 / Elemento padre: 391   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(392)).setAttribute("src","b.gif" );
      ((Element)v.get(392)).setAttribute("width","25" );
      ((Element)v.get(392)).setAttribute("height","8" );
      ((Element)v.get(391)).appendChild((Element)v.get(392));
      /* Termina nodo:392   */
      /* Termina nodo:391   */

      /* Empieza nodo:393 / Elemento padre: 386   */
   }

   private void getXML1800(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(386)).appendChild((Element)v.get(393));

      /* Empieza nodo:394 / Elemento padre: 393   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(394)).setAttribute("nombre","lblLargo" );
      ((Element)v.get(394)).setAttribute("alto","13" );
      ((Element)v.get(394)).setAttribute("filas","1" );
      ((Element)v.get(394)).setAttribute("valor","" );
      ((Element)v.get(394)).setAttribute("id","datosTitle" );
      ((Element)v.get(394)).setAttribute("cod","1071" );
      ((Element)v.get(393)).appendChild((Element)v.get(394));
      /* Termina nodo:394   */
      /* Termina nodo:393   */

      /* Empieza nodo:395 / Elemento padre: 386   */
      v.add(doc.createElement("td"));
      ((Element)v.get(386)).appendChild((Element)v.get(395));

      /* Empieza nodo:396 / Elemento padre: 395   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(396)).setAttribute("src","b.gif" );
      ((Element)v.get(396)).setAttribute("width","25" );
      ((Element)v.get(396)).setAttribute("height","8" );
      ((Element)v.get(395)).appendChild((Element)v.get(396));
      /* Termina nodo:396   */
      /* Termina nodo:395   */

      /* Empieza nodo:397 / Elemento padre: 386   */
      v.add(doc.createElement("td"));
      ((Element)v.get(386)).appendChild((Element)v.get(397));

      /* Empieza nodo:398 / Elemento padre: 397   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(398)).setAttribute("nombre","lblAncho" );
      ((Element)v.get(398)).setAttribute("alto","13" );
      ((Element)v.get(398)).setAttribute("filas","1" );
      ((Element)v.get(398)).setAttribute("valor","" );
      ((Element)v.get(398)).setAttribute("id","datosTitle" );
      ((Element)v.get(398)).setAttribute("cod","1072" );
      ((Element)v.get(397)).appendChild((Element)v.get(398));
      /* Termina nodo:398   */
      /* Termina nodo:397   */

      /* Empieza nodo:399 / Elemento padre: 386   */
      v.add(doc.createElement("td"));
      ((Element)v.get(386)).appendChild((Element)v.get(399));

      /* Empieza nodo:400 / Elemento padre: 399   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(400)).setAttribute("src","b.gif" );
      ((Element)v.get(400)).setAttribute("width","25" );
      ((Element)v.get(400)).setAttribute("height","8" );
      ((Element)v.get(399)).appendChild((Element)v.get(400));
      /* Termina nodo:400   */
      /* Termina nodo:399   */

      /* Empieza nodo:401 / Elemento padre: 386   */
      v.add(doc.createElement("td"));
      ((Element)v.get(386)).appendChild((Element)v.get(401));

      /* Empieza nodo:402 / Elemento padre: 401   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(402)).setAttribute("nombre","lblMedidaDimensiones" );
      ((Element)v.get(402)).setAttribute("alto","13" );
      ((Element)v.get(402)).setAttribute("filas","1" );
      ((Element)v.get(402)).setAttribute("valor","" );
      ((Element)v.get(402)).setAttribute("id","datosTitle" );
      ((Element)v.get(402)).setAttribute("cod","1133" );
      ((Element)v.get(401)).appendChild((Element)v.get(402));
      /* Termina nodo:402   */
      /* Termina nodo:401   */

      /* Empieza nodo:403 / Elemento padre: 386   */
      v.add(doc.createElement("td"));
      ((Element)v.get(403)).setAttribute("width","100%" );
      ((Element)v.get(386)).appendChild((Element)v.get(403));

      /* Empieza nodo:404 / Elemento padre: 403   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(404)).setAttribute("src","b.gif" );
      ((Element)v.get(404)).setAttribute("width","8" );
      ((Element)v.get(404)).setAttribute("height","8" );
      ((Element)v.get(403)).appendChild((Element)v.get(404));
      /* Termina nodo:404   */
      /* Termina nodo:403   */
      /* Termina nodo:386   */

      /* Empieza nodo:405 / Elemento padre: 385   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(385)).appendChild((Element)v.get(405));

      /* Empieza nodo:406 / Elemento padre: 405   */
      v.add(doc.createElement("td"));
      ((Element)v.get(405)).appendChild((Element)v.get(406));

      /* Empieza nodo:407 / Elemento padre: 406   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(407)).setAttribute("src","b.gif" );
      ((Element)v.get(407)).setAttribute("width","8" );
      ((Element)v.get(407)).setAttribute("height","8" );
      ((Element)v.get(406)).appendChild((Element)v.get(407));
      /* Termina nodo:407   */
      /* Termina nodo:406   */

      /* Empieza nodo:408 / Elemento padre: 405   */
      v.add(doc.createElement("td"));
      ((Element)v.get(408)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(405)).appendChild((Element)v.get(408));

      /* Empieza nodo:409 / Elemento padre: 408   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(409)).setAttribute("nombre","txtDA" );
      ((Element)v.get(409)).setAttribute("id","datosCampos" );
      ((Element)v.get(409)).setAttribute("max","6" );
      ((Element)v.get(409)).setAttribute("tipo","" );
      ((Element)v.get(409)).setAttribute("onchange","" );
      ((Element)v.get(409)).setAttribute("req","N" );
      ((Element)v.get(409)).setAttribute("size","7" );
      ((Element)v.get(409)).setAttribute("valor","" );
      ((Element)v.get(409)).setAttribute("validacion","" );
      ((Element)v.get(409)).setAttribute("ontab","setTabFocus('txtDA');" );
      ((Element)v.get(409)).setAttribute("onshtab","setSHTabFocus('txtDA');" );
      ((Element)v.get(408)).appendChild((Element)v.get(409));
      /* Termina nodo:409   */
      /* Termina nodo:408   */

      /* Empieza nodo:410 / Elemento padre: 405   */
      v.add(doc.createElement("td"));
      ((Element)v.get(405)).appendChild((Element)v.get(410));

      /* Empieza nodo:411 / Elemento padre: 410   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(411)).setAttribute("src","b.gif" );
      ((Element)v.get(411)).setAttribute("width","25" );
      ((Element)v.get(411)).setAttribute("height","8" );
      ((Element)v.get(410)).appendChild((Element)v.get(411));
      /* Termina nodo:411   */
      /* Termina nodo:410   */

      /* Empieza nodo:412 / Elemento padre: 405   */
      v.add(doc.createElement("td"));
      ((Element)v.get(412)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(405)).appendChild((Element)v.get(412));

      /* Empieza nodo:413 / Elemento padre: 412   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(413)).setAttribute("nombre","txtDL" );
      ((Element)v.get(413)).setAttribute("id","datosCampos" );
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(413)).setAttribute("max","6" );
      ((Element)v.get(413)).setAttribute("tipo","" );
      ((Element)v.get(413)).setAttribute("onchange","" );
      ((Element)v.get(413)).setAttribute("req","N" );
      ((Element)v.get(413)).setAttribute("size","7" );
      ((Element)v.get(413)).setAttribute("valor","" );
      ((Element)v.get(413)).setAttribute("validacion","" );
      ((Element)v.get(413)).setAttribute("ontab","setTabFocus('txtDL');" );
      ((Element)v.get(413)).setAttribute("onshtab","setSHTabFocus('txtDL');" );
      ((Element)v.get(412)).appendChild((Element)v.get(413));
      /* Termina nodo:413   */
      /* Termina nodo:412   */

      /* Empieza nodo:414 / Elemento padre: 405   */
      v.add(doc.createElement("td"));
      ((Element)v.get(405)).appendChild((Element)v.get(414));

      /* Empieza nodo:415 / Elemento padre: 414   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(415)).setAttribute("src","b.gif" );
      ((Element)v.get(415)).setAttribute("width","25" );
      ((Element)v.get(415)).setAttribute("height","8" );
      ((Element)v.get(414)).appendChild((Element)v.get(415));
      /* Termina nodo:415   */
      /* Termina nodo:414   */

      /* Empieza nodo:416 / Elemento padre: 405   */
      v.add(doc.createElement("td"));
      ((Element)v.get(416)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(405)).appendChild((Element)v.get(416));

      /* Empieza nodo:417 / Elemento padre: 416   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(417)).setAttribute("nombre","txtDAL" );
      ((Element)v.get(417)).setAttribute("id","datosCampos" );
      ((Element)v.get(417)).setAttribute("max","6" );
      ((Element)v.get(417)).setAttribute("tipo","" );
      ((Element)v.get(417)).setAttribute("onchange","" );
      ((Element)v.get(417)).setAttribute("req","N" );
      ((Element)v.get(417)).setAttribute("size","7" );
      ((Element)v.get(417)).setAttribute("valor","" );
      ((Element)v.get(417)).setAttribute("validacion","" );
      ((Element)v.get(417)).setAttribute("ontab","setTabFocus('txtDAL');" );
      ((Element)v.get(417)).setAttribute("onshtab","setSHTabFocus('txtDAL');" );
      ((Element)v.get(416)).appendChild((Element)v.get(417));
      /* Termina nodo:417   */
      /* Termina nodo:416   */

      /* Empieza nodo:418 / Elemento padre: 405   */
      v.add(doc.createElement("td"));
      ((Element)v.get(405)).appendChild((Element)v.get(418));

      /* Empieza nodo:419 / Elemento padre: 418   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(419)).setAttribute("src","b.gif" );
      ((Element)v.get(419)).setAttribute("width","25" );
      ((Element)v.get(419)).setAttribute("height","8" );
      ((Element)v.get(418)).appendChild((Element)v.get(419));
      /* Termina nodo:419   */
      /* Termina nodo:418   */

      /* Empieza nodo:420 / Elemento padre: 405   */
      v.add(doc.createElement("td"));
      ((Element)v.get(420)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(405)).appendChild((Element)v.get(420));

      /* Empieza nodo:421 / Elemento padre: 420   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(421)).setAttribute("nombre","cbUNMedidaDimensiones" );
      ((Element)v.get(421)).setAttribute("id","datosCampos" );
      ((Element)v.get(421)).setAttribute("size","1" );
      ((Element)v.get(421)).setAttribute("multiple","N" );
      ((Element)v.get(421)).setAttribute("req","N" );
      ((Element)v.get(421)).setAttribute("valorinicial","" );
      ((Element)v.get(421)).setAttribute("textoinicial","" );
      ((Element)v.get(421)).setAttribute("ontab","setTabFocus('cbUNMedidaDimensiones');" );
      ((Element)v.get(421)).setAttribute("onshtab","setSHTabFocus('cbUNMedidaDimensiones');" );
      ((Element)v.get(420)).appendChild((Element)v.get(421));

      /* Empieza nodo:422 / Elemento padre: 421   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(421)).appendChild((Element)v.get(422));
      /* Termina nodo:422   */
      /* Termina nodo:421   */
      /* Termina nodo:420   */

      /* Empieza nodo:423 / Elemento padre: 405   */
      v.add(doc.createElement("td"));
      ((Element)v.get(423)).setAttribute("width","100%" );
      ((Element)v.get(405)).appendChild((Element)v.get(423));

      /* Empieza nodo:424 / Elemento padre: 423   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(424)).setAttribute("src","b.gif" );
      ((Element)v.get(424)).setAttribute("width","8" );
      ((Element)v.get(424)).setAttribute("height","8" );
      ((Element)v.get(423)).appendChild((Element)v.get(424));
      /* Termina nodo:424   */
      /* Termina nodo:423   */
      /* Termina nodo:405   */

      /* Empieza nodo:425 / Elemento padre: 385   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(385)).appendChild((Element)v.get(425));

      /* Empieza nodo:426 / Elemento padre: 425   */
      v.add(doc.createElement("td"));
      ((Element)v.get(426)).setAttribute("colspan","4" );
      ((Element)v.get(425)).appendChild((Element)v.get(426));

      /* Empieza nodo:427 / Elemento padre: 426   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(427)).setAttribute("src","b.gif" );
      ((Element)v.get(427)).setAttribute("width","8" );
      ((Element)v.get(427)).setAttribute("height","8" );
      ((Element)v.get(426)).appendChild((Element)v.get(427));
      /* Termina nodo:427   */
      /* Termina nodo:426   */
      /* Termina nodo:425   */
      /* Termina nodo:385   */

      /* Empieza nodo:428 / Elemento padre: 142   */
      v.add(doc.createElement("table"));
      ((Element)v.get(428)).setAttribute("width","100%" );
      ((Element)v.get(428)).setAttribute("border","0" );
      ((Element)v.get(428)).setAttribute("align","center" );
      ((Element)v.get(428)).setAttribute("cellspacing","0" );
      ((Element)v.get(428)).setAttribute("cellpadding","0" );
      ((Element)v.get(142)).appendChild((Element)v.get(428));

      /* Empieza nodo:429 / Elemento padre: 428   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(428)).appendChild((Element)v.get(429));

      /* Empieza nodo:430 / Elemento padre: 429   */
      v.add(doc.createElement("td"));
      ((Element)v.get(429)).appendChild((Element)v.get(430));

      /* Empieza nodo:431 / Elemento padre: 430   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(431)).setAttribute("src","b.gif" );
      ((Element)v.get(431)).setAttribute("width","8" );
      ((Element)v.get(431)).setAttribute("height","8" );
      ((Element)v.get(430)).appendChild((Element)v.get(431));
      /* Termina nodo:431   */
      /* Termina nodo:430   */

      /* Empieza nodo:432 / Elemento padre: 429   */
   }

   private void getXML1980(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(429)).appendChild((Element)v.get(432));

      /* Empieza nodo:433 / Elemento padre: 432   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(433)).setAttribute("nombre","lblVolumen" );
      ((Element)v.get(433)).setAttribute("alto","13" );
      ((Element)v.get(433)).setAttribute("filas","1" );
      ((Element)v.get(433)).setAttribute("valor","" );
      ((Element)v.get(433)).setAttribute("id","datosTitle" );
      ((Element)v.get(433)).setAttribute("cod","1140" );
      ((Element)v.get(432)).appendChild((Element)v.get(433));
      /* Termina nodo:433   */
      /* Termina nodo:432   */

      /* Empieza nodo:434 / Elemento padre: 429   */
      v.add(doc.createElement("td"));
      ((Element)v.get(429)).appendChild((Element)v.get(434));

      /* Empieza nodo:435 / Elemento padre: 434   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(435)).setAttribute("src","b.gif" );
      ((Element)v.get(435)).setAttribute("width","25" );
      ((Element)v.get(435)).setAttribute("height","8" );
      ((Element)v.get(434)).appendChild((Element)v.get(435));
      /* Termina nodo:435   */
      /* Termina nodo:434   */

      /* Empieza nodo:436 / Elemento padre: 429   */
      v.add(doc.createElement("td"));
      ((Element)v.get(429)).appendChild((Element)v.get(436));

      /* Empieza nodo:437 / Elemento padre: 436   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(437)).setAttribute("nombre","lblMedidaVolumen" );
      ((Element)v.get(437)).setAttribute("alto","13" );
      ((Element)v.get(437)).setAttribute("filas","1" );
      ((Element)v.get(437)).setAttribute("valor","" );
      ((Element)v.get(437)).setAttribute("id","datosTitle" );
      ((Element)v.get(437)).setAttribute("cod","1135" );
      ((Element)v.get(436)).appendChild((Element)v.get(437));
      /* Termina nodo:437   */
      /* Termina nodo:436   */

      /* Empieza nodo:438 / Elemento padre: 429   */
      v.add(doc.createElement("td"));
      ((Element)v.get(438)).setAttribute("width","100%" );
      ((Element)v.get(429)).appendChild((Element)v.get(438));

      /* Empieza nodo:439 / Elemento padre: 438   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(439)).setAttribute("src","b.gif" );
      ((Element)v.get(439)).setAttribute("width","8" );
      ((Element)v.get(439)).setAttribute("height","8" );
      ((Element)v.get(438)).appendChild((Element)v.get(439));
      /* Termina nodo:439   */
      /* Termina nodo:438   */
      /* Termina nodo:429   */

      /* Empieza nodo:440 / Elemento padre: 428   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(428)).appendChild((Element)v.get(440));

      /* Empieza nodo:441 / Elemento padre: 440   */
      v.add(doc.createElement("td"));
      ((Element)v.get(440)).appendChild((Element)v.get(441));

      /* Empieza nodo:442 / Elemento padre: 441   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(442)).setAttribute("src","b.gif" );
      ((Element)v.get(442)).setAttribute("width","8" );
      ((Element)v.get(442)).setAttribute("height","8" );
      ((Element)v.get(441)).appendChild((Element)v.get(442));
      /* Termina nodo:442   */
      /* Termina nodo:441   */

      /* Empieza nodo:443 / Elemento padre: 440   */
      v.add(doc.createElement("td"));
      ((Element)v.get(443)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(440)).appendChild((Element)v.get(443));

      /* Empieza nodo:444 / Elemento padre: 443   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(444)).setAttribute("nombre","txtVoluA" );
      ((Element)v.get(444)).setAttribute("id","datosCampos" );
      ((Element)v.get(444)).setAttribute("max","6" );
      ((Element)v.get(444)).setAttribute("tipo","" );
      ((Element)v.get(444)).setAttribute("onchange","" );
      ((Element)v.get(444)).setAttribute("req","N" );
      ((Element)v.get(444)).setAttribute("size","13" );
      ((Element)v.get(444)).setAttribute("valor","" );
      ((Element)v.get(444)).setAttribute("validacion","" );
      ((Element)v.get(444)).setAttribute("ontab","setTabFocus('txtVoluA');" );
      ((Element)v.get(444)).setAttribute("onshtab","setSHTabFocus('txtVoluA');" );
      ((Element)v.get(443)).appendChild((Element)v.get(444));
      /* Termina nodo:444   */
      /* Termina nodo:443   */

      /* Empieza nodo:445 / Elemento padre: 440   */
      v.add(doc.createElement("td"));
      ((Element)v.get(440)).appendChild((Element)v.get(445));

      /* Empieza nodo:446 / Elemento padre: 445   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(446)).setAttribute("src","b.gif" );
      ((Element)v.get(446)).setAttribute("width","25" );
      ((Element)v.get(446)).setAttribute("height","8" );
      ((Element)v.get(445)).appendChild((Element)v.get(446));
      /* Termina nodo:446   */
      /* Termina nodo:445   */

      /* Empieza nodo:447 / Elemento padre: 440   */
      v.add(doc.createElement("td"));
      ((Element)v.get(447)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(440)).appendChild((Element)v.get(447));

      /* Empieza nodo:448 / Elemento padre: 447   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(448)).setAttribute("nombre","cbUDV" );
      ((Element)v.get(448)).setAttribute("id","datosCampos" );
      ((Element)v.get(448)).setAttribute("size","1" );
      ((Element)v.get(448)).setAttribute("multiple","N" );
      ((Element)v.get(448)).setAttribute("req","N" );
      ((Element)v.get(448)).setAttribute("valorinicial","" );
      ((Element)v.get(448)).setAttribute("textoinicial","" );
      ((Element)v.get(448)).setAttribute("ontab","setTabFocus('cbUDV');" );
      ((Element)v.get(448)).setAttribute("onshtab","setSHTabFocus('cbUDV');" );
      ((Element)v.get(447)).appendChild((Element)v.get(448));

      /* Empieza nodo:449 / Elemento padre: 448   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(448)).appendChild((Element)v.get(449));
      /* Termina nodo:449   */
      /* Termina nodo:448   */
      /* Termina nodo:447   */

      /* Empieza nodo:450 / Elemento padre: 440   */
      v.add(doc.createElement("td"));
      ((Element)v.get(450)).setAttribute("width","100%" );
      ((Element)v.get(440)).appendChild((Element)v.get(450));

      /* Empieza nodo:451 / Elemento padre: 450   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(451)).setAttribute("src","b.gif" );
      ((Element)v.get(451)).setAttribute("width","8" );
      ((Element)v.get(451)).setAttribute("height","8" );
   }

   private void getXML2070(Document doc) {
      ((Element)v.get(450)).appendChild((Element)v.get(451));
      /* Termina nodo:451   */
      /* Termina nodo:450   */
      /* Termina nodo:440   */

      /* Empieza nodo:452 / Elemento padre: 428   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(428)).appendChild((Element)v.get(452));

      /* Empieza nodo:453 / Elemento padre: 452   */
      v.add(doc.createElement("td"));
      ((Element)v.get(453)).setAttribute("colspan","4" );
      ((Element)v.get(452)).appendChild((Element)v.get(453));

      /* Empieza nodo:454 / Elemento padre: 453   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(454)).setAttribute("src","b.gif" );
      ((Element)v.get(454)).setAttribute("width","8" );
      ((Element)v.get(454)).setAttribute("height","8" );
      ((Element)v.get(453)).appendChild((Element)v.get(454));
      /* Termina nodo:454   */
      /* Termina nodo:453   */
      /* Termina nodo:452   */
      /* Termina nodo:428   */

      /* Empieza nodo:455 / Elemento padre: 142   */
      v.add(doc.createElement("table"));
      ((Element)v.get(455)).setAttribute("width","100%" );
      ((Element)v.get(455)).setAttribute("border","0" );
      ((Element)v.get(455)).setAttribute("align","center" );
      ((Element)v.get(455)).setAttribute("cellspacing","0" );
      ((Element)v.get(455)).setAttribute("cellpadding","0" );
      ((Element)v.get(142)).appendChild((Element)v.get(455));

      /* Empieza nodo:456 / Elemento padre: 455   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(455)).appendChild((Element)v.get(456));

      /* Empieza nodo:457 / Elemento padre: 456   */
      v.add(doc.createElement("td"));
      ((Element)v.get(456)).appendChild((Element)v.get(457));

      /* Empieza nodo:458 / Elemento padre: 457   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(458)).setAttribute("src","b.gif" );
      ((Element)v.get(458)).setAttribute("width","8" );
      ((Element)v.get(458)).setAttribute("height","8" );
      ((Element)v.get(457)).appendChild((Element)v.get(458));
      /* Termina nodo:458   */
      /* Termina nodo:457   */

      /* Empieza nodo:459 / Elemento padre: 456   */
      v.add(doc.createElement("td"));
      ((Element)v.get(456)).appendChild((Element)v.get(459));

      /* Empieza nodo:460 / Elemento padre: 459   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(460)).setAttribute("nombre","lblPeso" );
      ((Element)v.get(460)).setAttribute("alto","13" );
      ((Element)v.get(460)).setAttribute("filas","1" );
      ((Element)v.get(460)).setAttribute("valor","" );
      ((Element)v.get(460)).setAttribute("id","datosTitle" );
      ((Element)v.get(460)).setAttribute("cod","1115" );
      ((Element)v.get(459)).appendChild((Element)v.get(460));
      /* Termina nodo:460   */
      /* Termina nodo:459   */

      /* Empieza nodo:461 / Elemento padre: 456   */
      v.add(doc.createElement("td"));
      ((Element)v.get(456)).appendChild((Element)v.get(461));

      /* Empieza nodo:462 / Elemento padre: 461   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(462)).setAttribute("src","b.gif" );
      ((Element)v.get(462)).setAttribute("width","25" );
      ((Element)v.get(462)).setAttribute("height","8" );
      ((Element)v.get(461)).appendChild((Element)v.get(462));
      /* Termina nodo:462   */
      /* Termina nodo:461   */

      /* Empieza nodo:463 / Elemento padre: 456   */
      v.add(doc.createElement("td"));
      ((Element)v.get(456)).appendChild((Element)v.get(463));

      /* Empieza nodo:464 / Elemento padre: 463   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(464)).setAttribute("nombre","lblMedidaPeso" );
      ((Element)v.get(464)).setAttribute("alto","13" );
      ((Element)v.get(464)).setAttribute("filas","1" );
      ((Element)v.get(464)).setAttribute("valor","" );
      ((Element)v.get(464)).setAttribute("id","datosTitle" );
      ((Element)v.get(464)).setAttribute("cod","1134" );
      ((Element)v.get(463)).appendChild((Element)v.get(464));
      /* Termina nodo:464   */
      /* Termina nodo:463   */

      /* Empieza nodo:465 / Elemento padre: 456   */
      v.add(doc.createElement("td"));
      ((Element)v.get(465)).setAttribute("width","100%" );
      ((Element)v.get(456)).appendChild((Element)v.get(465));

      /* Empieza nodo:466 / Elemento padre: 465   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(466)).setAttribute("src","b.gif" );
      ((Element)v.get(466)).setAttribute("width","8" );
      ((Element)v.get(466)).setAttribute("height","8" );
      ((Element)v.get(465)).appendChild((Element)v.get(466));
      /* Termina nodo:466   */
      /* Termina nodo:465   */
      /* Termina nodo:456   */

      /* Empieza nodo:467 / Elemento padre: 455   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(455)).appendChild((Element)v.get(467));

      /* Empieza nodo:468 / Elemento padre: 467   */
      v.add(doc.createElement("td"));
      ((Element)v.get(467)).appendChild((Element)v.get(468));

      /* Empieza nodo:469 / Elemento padre: 468   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(469)).setAttribute("src","b.gif" );
      ((Element)v.get(469)).setAttribute("width","8" );
      ((Element)v.get(469)).setAttribute("height","8" );
      ((Element)v.get(468)).appendChild((Element)v.get(469));
      /* Termina nodo:469   */
      /* Termina nodo:468   */

      /* Empieza nodo:470 / Elemento padre: 467   */
      v.add(doc.createElement("td"));
      ((Element)v.get(470)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(467)).appendChild((Element)v.get(470));

      /* Empieza nodo:471 / Elemento padre: 470   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(471)).setAttribute("nombre","txtPeso" );
      ((Element)v.get(471)).setAttribute("id","datosCampos" );
      ((Element)v.get(471)).setAttribute("max","6" );
      ((Element)v.get(471)).setAttribute("tipo","" );
      ((Element)v.get(471)).setAttribute("onchange","" );
      ((Element)v.get(471)).setAttribute("req","N" );
      ((Element)v.get(471)).setAttribute("size","7" );
      ((Element)v.get(471)).setAttribute("valor","" );
      ((Element)v.get(471)).setAttribute("validacion","" );
      ((Element)v.get(471)).setAttribute("ontab","setTabFocus('txtPeso');" );
      ((Element)v.get(471)).setAttribute("onshtab","setSHTabFocus('txtPeso');" );
      ((Element)v.get(470)).appendChild((Element)v.get(471));
      /* Termina nodo:471   */
      /* Termina nodo:470   */

      /* Empieza nodo:472 / Elemento padre: 467   */
      v.add(doc.createElement("td"));
      ((Element)v.get(467)).appendChild((Element)v.get(472));

      /* Empieza nodo:473 / Elemento padre: 472   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML2160(Document doc) {
      ((Element)v.get(473)).setAttribute("src","b.gif" );
      ((Element)v.get(473)).setAttribute("width","25" );
      ((Element)v.get(473)).setAttribute("height","8" );
      ((Element)v.get(472)).appendChild((Element)v.get(473));
      /* Termina nodo:473   */
      /* Termina nodo:472   */

      /* Empieza nodo:474 / Elemento padre: 467   */
      v.add(doc.createElement("td"));
      ((Element)v.get(474)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(467)).appendChild((Element)v.get(474));

      /* Empieza nodo:475 / Elemento padre: 474   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(475)).setAttribute("nombre","cbUDP" );
      ((Element)v.get(475)).setAttribute("id","datosCampos" );
      ((Element)v.get(475)).setAttribute("size","1" );
      ((Element)v.get(475)).setAttribute("multiple","N" );
      ((Element)v.get(475)).setAttribute("req","N" );
      ((Element)v.get(475)).setAttribute("valorinicial","" );
      ((Element)v.get(475)).setAttribute("textoinicial","" );
      ((Element)v.get(475)).setAttribute("ontab","setTabFocus('cbUDP');" );
      ((Element)v.get(475)).setAttribute("onshtab","setSHTabFocus('cbUDP');" );
      ((Element)v.get(474)).appendChild((Element)v.get(475));

      /* Empieza nodo:476 / Elemento padre: 475   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(475)).appendChild((Element)v.get(476));
      /* Termina nodo:476   */
      /* Termina nodo:475   */
      /* Termina nodo:474   */

      /* Empieza nodo:477 / Elemento padre: 467   */
      v.add(doc.createElement("td"));
      ((Element)v.get(477)).setAttribute("width","100%" );
      ((Element)v.get(467)).appendChild((Element)v.get(477));

      /* Empieza nodo:478 / Elemento padre: 477   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(478)).setAttribute("src","b.gif" );
      ((Element)v.get(478)).setAttribute("width","8" );
      ((Element)v.get(478)).setAttribute("height","8" );
      ((Element)v.get(477)).appendChild((Element)v.get(478));
      /* Termina nodo:478   */
      /* Termina nodo:477   */
      /* Termina nodo:467   */

      /* Empieza nodo:479 / Elemento padre: 455   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(455)).appendChild((Element)v.get(479));

      /* Empieza nodo:480 / Elemento padre: 479   */
      v.add(doc.createElement("td"));
      ((Element)v.get(480)).setAttribute("colspan","4" );
      ((Element)v.get(479)).appendChild((Element)v.get(480));

      /* Empieza nodo:481 / Elemento padre: 480   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(481)).setAttribute("src","b.gif" );
      ((Element)v.get(481)).setAttribute("width","8" );
      ((Element)v.get(481)).setAttribute("height","8" );
      ((Element)v.get(480)).appendChild((Element)v.get(481));
      /* Termina nodo:481   */
      /* Termina nodo:480   */
      /* Termina nodo:479   */
      /* Termina nodo:455   */

      /* Empieza nodo:482 / Elemento padre: 142   */
      v.add(doc.createElement("table"));
      ((Element)v.get(482)).setAttribute("width","100%" );
      ((Element)v.get(482)).setAttribute("border","0" );
      ((Element)v.get(482)).setAttribute("align","center" );
      ((Element)v.get(482)).setAttribute("cellspacing","0" );
      ((Element)v.get(482)).setAttribute("cellpadding","0" );
      ((Element)v.get(142)).appendChild((Element)v.get(482));

      /* Empieza nodo:483 / Elemento padre: 482   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(482)).appendChild((Element)v.get(483));

      /* Empieza nodo:484 / Elemento padre: 483   */
      v.add(doc.createElement("td"));
      ((Element)v.get(483)).appendChild((Element)v.get(484));

      /* Empieza nodo:485 / Elemento padre: 484   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(485)).setAttribute("src","b.gif" );
      ((Element)v.get(485)).setAttribute("width","8" );
      ((Element)v.get(485)).setAttribute("height","8" );
      ((Element)v.get(484)).appendChild((Element)v.get(485));
      /* Termina nodo:485   */
      /* Termina nodo:484   */

      /* Empieza nodo:486 / Elemento padre: 483   */
      v.add(doc.createElement("td"));
      ((Element)v.get(483)).appendChild((Element)v.get(486));

      /* Empieza nodo:487 / Elemento padre: 486   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(487)).setAttribute("nombre","lblDentroPedido" );
      ((Element)v.get(487)).setAttribute("alto","13" );
      ((Element)v.get(487)).setAttribute("filas","1" );
      ((Element)v.get(487)).setAttribute("valor","" );
      ((Element)v.get(487)).setAttribute("id","datosTitle" );
      ((Element)v.get(487)).setAttribute("cod","1132" );
      ((Element)v.get(486)).appendChild((Element)v.get(487));
      /* Termina nodo:487   */
      /* Termina nodo:486   */

      /* Empieza nodo:488 / Elemento padre: 483   */
      v.add(doc.createElement("td"));
      ((Element)v.get(483)).appendChild((Element)v.get(488));

      /* Empieza nodo:489 / Elemento padre: 488   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(489)).setAttribute("src","b.gif" );
      ((Element)v.get(489)).setAttribute("width","25" );
      ((Element)v.get(489)).setAttribute("height","8" );
      ((Element)v.get(488)).appendChild((Element)v.get(489));
      /* Termina nodo:489   */
      /* Termina nodo:488   */

      /* Empieza nodo:490 / Elemento padre: 483   */
      v.add(doc.createElement("td"));
      ((Element)v.get(483)).appendChild((Element)v.get(490));

      /* Empieza nodo:491 / Elemento padre: 490   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(491)).setAttribute("nombre","lblPorCaja" );
      ((Element)v.get(491)).setAttribute("alto","13" );
      ((Element)v.get(491)).setAttribute("filas","1" );
      ((Element)v.get(491)).setAttribute("valor","" );
      ((Element)v.get(491)).setAttribute("id","datosTitle" );
      ((Element)v.get(491)).setAttribute("cod","1136" );
      ((Element)v.get(490)).appendChild((Element)v.get(491));
      /* Termina nodo:491   */
      /* Termina nodo:490   */

      /* Empieza nodo:492 / Elemento padre: 483   */
      v.add(doc.createElement("td"));
      ((Element)v.get(483)).appendChild((Element)v.get(492));

      /* Empieza nodo:493 / Elemento padre: 492   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(493)).setAttribute("src","b.gif" );
      ((Element)v.get(493)).setAttribute("width","25" );
      ((Element)v.get(493)).setAttribute("height","8" );
      ((Element)v.get(492)).appendChild((Element)v.get(493));
      /* Termina nodo:493   */
      /* Termina nodo:492   */

      /* Empieza nodo:494 / Elemento padre: 483   */
      v.add(doc.createElement("td"));
      ((Element)v.get(483)).appendChild((Element)v.get(494));

      /* Empieza nodo:495 / Elemento padre: 494   */
   }

   private void getXML2250(Document doc) {
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(495)).setAttribute("nombre","lblCosteEstandar" );
      ((Element)v.get(495)).setAttribute("alto","13" );
      ((Element)v.get(495)).setAttribute("filas","1" );
      ((Element)v.get(495)).setAttribute("valor","" );
      ((Element)v.get(495)).setAttribute("id","datosTitle" );
      ((Element)v.get(495)).setAttribute("cod","604" );
      ((Element)v.get(494)).appendChild((Element)v.get(495));
      /* Termina nodo:495   */
      /* Termina nodo:494   */

      /* Empieza nodo:496 / Elemento padre: 483   */
      v.add(doc.createElement("td"));
      ((Element)v.get(483)).appendChild((Element)v.get(496));

      /* Empieza nodo:497 / Elemento padre: 496   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(497)).setAttribute("src","b.gif" );
      ((Element)v.get(497)).setAttribute("width","25" );
      ((Element)v.get(497)).setAttribute("height","8" );
      ((Element)v.get(496)).appendChild((Element)v.get(497));
      /* Termina nodo:497   */
      /* Termina nodo:496   */

      /* Empieza nodo:498 / Elemento padre: 483   */
      v.add(doc.createElement("td"));
      ((Element)v.get(483)).appendChild((Element)v.get(498));

      /* Empieza nodo:499 / Elemento padre: 498   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(499)).setAttribute("nombre","lblPrecioPos" );
      ((Element)v.get(499)).setAttribute("alto","13" );
      ((Element)v.get(499)).setAttribute("filas","1" );
      ((Element)v.get(499)).setAttribute("valor","" );
      ((Element)v.get(499)).setAttribute("id","datosTitle" );
      ((Element)v.get(499)).setAttribute("cod","1116" );
      ((Element)v.get(498)).appendChild((Element)v.get(499));
      /* Termina nodo:499   */
      /* Termina nodo:498   */

      /* Empieza nodo:500 / Elemento padre: 483   */
      v.add(doc.createElement("td"));
      ((Element)v.get(483)).appendChild((Element)v.get(500));

      /* Empieza nodo:501 / Elemento padre: 500   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(501)).setAttribute("src","b.gif" );
      ((Element)v.get(501)).setAttribute("width","25" );
      ((Element)v.get(501)).setAttribute("height","8" );
      ((Element)v.get(500)).appendChild((Element)v.get(501));
      /* Termina nodo:501   */
      /* Termina nodo:500   */

      /* Empieza nodo:502 / Elemento padre: 483   */
      v.add(doc.createElement("td"));
      ((Element)v.get(483)).appendChild((Element)v.get(502));

      /* Empieza nodo:503 / Elemento padre: 502   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(503)).setAttribute("nombre","lblSituacion" );
      ((Element)v.get(503)).setAttribute("alto","13" );
      ((Element)v.get(503)).setAttribute("filas","1" );
      ((Element)v.get(503)).setAttribute("valor","" );
      ((Element)v.get(503)).setAttribute("id","datosTitle" );
      ((Element)v.get(503)).setAttribute("cod","695" );
      ((Element)v.get(502)).appendChild((Element)v.get(503));
      /* Termina nodo:503   */
      /* Termina nodo:502   */

      /* Empieza nodo:504 / Elemento padre: 483   */
      v.add(doc.createElement("td"));
      ((Element)v.get(504)).setAttribute("width","100%" );
      ((Element)v.get(483)).appendChild((Element)v.get(504));

      /* Empieza nodo:505 / Elemento padre: 504   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(505)).setAttribute("src","b.gif" );
      ((Element)v.get(505)).setAttribute("width","8" );
      ((Element)v.get(505)).setAttribute("height","8" );
      ((Element)v.get(504)).appendChild((Element)v.get(505));
      /* Termina nodo:505   */
      /* Termina nodo:504   */
      /* Termina nodo:483   */

      /* Empieza nodo:506 / Elemento padre: 482   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(482)).appendChild((Element)v.get(506));

      /* Empieza nodo:507 / Elemento padre: 506   */
      v.add(doc.createElement("td"));
      ((Element)v.get(506)).appendChild((Element)v.get(507));

      /* Empieza nodo:508 / Elemento padre: 507   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(508)).setAttribute("src","b.gif" );
      ((Element)v.get(508)).setAttribute("width","8" );
      ((Element)v.get(508)).setAttribute("height","8" );
      ((Element)v.get(507)).appendChild((Element)v.get(508));
      /* Termina nodo:508   */
      /* Termina nodo:507   */

      /* Empieza nodo:509 / Elemento padre: 506   */
      v.add(doc.createElement("td"));
      ((Element)v.get(509)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(506)).appendChild((Element)v.get(509));

      /* Empieza nodo:510 / Elemento padre: 509   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(510)).setAttribute("nombre","txtUnidDentroPedido" );
      ((Element)v.get(510)).setAttribute("id","datosCampos" );
      ((Element)v.get(510)).setAttribute("max","5" );
      ((Element)v.get(510)).setAttribute("tipo","" );
      ((Element)v.get(510)).setAttribute("onchange","" );
      ((Element)v.get(510)).setAttribute("req","N" );
      ((Element)v.get(510)).setAttribute("size","5" );
      ((Element)v.get(510)).setAttribute("valor","" );
      ((Element)v.get(510)).setAttribute("validacion","" );
      ((Element)v.get(510)).setAttribute("ontab","setTabFocus('txtUnidDentroPedido');" );
      ((Element)v.get(510)).setAttribute("onshtab","setSHTabFocus('txtUnidDentroPedido');" );
      ((Element)v.get(509)).appendChild((Element)v.get(510));
      /* Termina nodo:510   */
      /* Termina nodo:509   */

      /* Empieza nodo:511 / Elemento padre: 506   */
      v.add(doc.createElement("td"));
      ((Element)v.get(506)).appendChild((Element)v.get(511));

      /* Empieza nodo:512 / Elemento padre: 511   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(512)).setAttribute("src","b.gif" );
      ((Element)v.get(512)).setAttribute("width","25" );
      ((Element)v.get(512)).setAttribute("height","8" );
      ((Element)v.get(511)).appendChild((Element)v.get(512));
      /* Termina nodo:512   */
      /* Termina nodo:511   */

      /* Empieza nodo:513 / Elemento padre: 506   */
      v.add(doc.createElement("td"));
      ((Element)v.get(513)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(506)).appendChild((Element)v.get(513));

      /* Empieza nodo:514 / Elemento padre: 513   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(514)).setAttribute("nombre","txtUDC" );
      ((Element)v.get(514)).setAttribute("id","datosCampos" );
      ((Element)v.get(514)).setAttribute("max","5" );
      ((Element)v.get(514)).setAttribute("tipo","" );
   }

   private void getXML2340(Document doc) {
      ((Element)v.get(514)).setAttribute("onchange","" );
      ((Element)v.get(514)).setAttribute("req","N" );
      ((Element)v.get(514)).setAttribute("size","5" );
      ((Element)v.get(514)).setAttribute("valor","" );
      ((Element)v.get(514)).setAttribute("validacion","" );
      ((Element)v.get(514)).setAttribute("ontab","setTabFocus('txtUDC');" );
      ((Element)v.get(514)).setAttribute("onshtab","setSHTabFocus('txtUDC');" );
      ((Element)v.get(513)).appendChild((Element)v.get(514));
      /* Termina nodo:514   */
      /* Termina nodo:513   */

      /* Empieza nodo:515 / Elemento padre: 506   */
      v.add(doc.createElement("td"));
      ((Element)v.get(506)).appendChild((Element)v.get(515));

      /* Empieza nodo:516 / Elemento padre: 515   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(516)).setAttribute("src","b.gif" );
      ((Element)v.get(516)).setAttribute("width","25" );
      ((Element)v.get(516)).setAttribute("height","8" );
      ((Element)v.get(515)).appendChild((Element)v.get(516));
      /* Termina nodo:516   */
      /* Termina nodo:515   */

      /* Empieza nodo:517 / Elemento padre: 506   */
      v.add(doc.createElement("td"));
      ((Element)v.get(517)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(506)).appendChild((Element)v.get(517));

      /* Empieza nodo:518 / Elemento padre: 517   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(518)).setAttribute("nombre","txtCosteEstandar" );
      ((Element)v.get(518)).setAttribute("id","datosCampos" );
      ((Element)v.get(518)).setAttribute("max","16" );
      ((Element)v.get(518)).setAttribute("tipo","" );
      ((Element)v.get(518)).setAttribute("onchange","" );
      ((Element)v.get(518)).setAttribute("req","N" );
      ((Element)v.get(518)).setAttribute("size","20" );
      ((Element)v.get(518)).setAttribute("valor","" );
      ((Element)v.get(518)).setAttribute("validacion","" );
      ((Element)v.get(518)).setAttribute("ontab","setTabFocus('txtCosteEstandar');" );
      ((Element)v.get(518)).setAttribute("onshtab","setSHTabFocus('txtCosteEstandar');" );
      ((Element)v.get(517)).appendChild((Element)v.get(518));
      /* Termina nodo:518   */
      /* Termina nodo:517   */

      /* Empieza nodo:519 / Elemento padre: 506   */
      v.add(doc.createElement("td"));
      ((Element)v.get(506)).appendChild((Element)v.get(519));

      /* Empieza nodo:520 / Elemento padre: 519   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(520)).setAttribute("src","b.gif" );
      ((Element)v.get(520)).setAttribute("width","25" );
      ((Element)v.get(520)).setAttribute("height","8" );
      ((Element)v.get(519)).appendChild((Element)v.get(520));
      /* Termina nodo:520   */
      /* Termina nodo:519   */

      /* Empieza nodo:521 / Elemento padre: 506   */
      v.add(doc.createElement("td"));
      ((Element)v.get(521)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(506)).appendChild((Element)v.get(521));

      /* Empieza nodo:522 / Elemento padre: 521   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(522)).setAttribute("nombre","txtPPos" );
      ((Element)v.get(522)).setAttribute("id","datosCampos" );
      ((Element)v.get(522)).setAttribute("max","16" );
      ((Element)v.get(522)).setAttribute("tipo","" );
      ((Element)v.get(522)).setAttribute("onchange","" );
      ((Element)v.get(522)).setAttribute("req","N" );
      ((Element)v.get(522)).setAttribute("size","20" );
      ((Element)v.get(522)).setAttribute("valor","" );
      ((Element)v.get(522)).setAttribute("validacion","" );
      ((Element)v.get(522)).setAttribute("ontab","setTabFocus('txtPPos');" );
      ((Element)v.get(522)).setAttribute("onshtab","setSHTabFocus('txtPPos');" );
      ((Element)v.get(521)).appendChild((Element)v.get(522));
      /* Termina nodo:522   */
      /* Termina nodo:521   */

      /* Empieza nodo:523 / Elemento padre: 506   */
      v.add(doc.createElement("td"));
      ((Element)v.get(506)).appendChild((Element)v.get(523));

      /* Empieza nodo:524 / Elemento padre: 523   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(524)).setAttribute("src","b.gif" );
      ((Element)v.get(524)).setAttribute("width","25" );
      ((Element)v.get(524)).setAttribute("height","8" );
      ((Element)v.get(523)).appendChild((Element)v.get(524));
      /* Termina nodo:524   */
      /* Termina nodo:523   */

      /* Empieza nodo:525 / Elemento padre: 506   */
      v.add(doc.createElement("td"));
      ((Element)v.get(525)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(506)).appendChild((Element)v.get(525));

      /* Empieza nodo:526 / Elemento padre: 525   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(526)).setAttribute("nombre","cbSituac" );
      ((Element)v.get(526)).setAttribute("id","datosCampos" );
      ((Element)v.get(526)).setAttribute("size","1" );
      ((Element)v.get(526)).setAttribute("multiple","N" );
      ((Element)v.get(526)).setAttribute("req","N" );
      ((Element)v.get(526)).setAttribute("valorinicial","" );
      ((Element)v.get(526)).setAttribute("textoinicial","" );
      ((Element)v.get(526)).setAttribute("ontab","setTabFocus('cbSituac');" );
      ((Element)v.get(526)).setAttribute("onshtab","setSHTabFocus('cbSituac');" );
      ((Element)v.get(525)).appendChild((Element)v.get(526));

      /* Empieza nodo:527 / Elemento padre: 526   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(526)).appendChild((Element)v.get(527));
      /* Termina nodo:527   */
      /* Termina nodo:526   */
      /* Termina nodo:525   */

      /* Empieza nodo:528 / Elemento padre: 506   */
      v.add(doc.createElement("td"));
      ((Element)v.get(528)).setAttribute("width","100%" );
      ((Element)v.get(506)).appendChild((Element)v.get(528));

      /* Empieza nodo:529 / Elemento padre: 528   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(529)).setAttribute("src","b.gif" );
      ((Element)v.get(529)).setAttribute("width","8" );
      ((Element)v.get(529)).setAttribute("height","8" );
      ((Element)v.get(528)).appendChild((Element)v.get(529));
      /* Termina nodo:529   */
      /* Termina nodo:528   */
      /* Termina nodo:506   */

      /* Empieza nodo:530 / Elemento padre: 482   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(482)).appendChild((Element)v.get(530));

      /* Empieza nodo:531 / Elemento padre: 530   */
      v.add(doc.createElement("td"));
      ((Element)v.get(531)).setAttribute("colspan","4" );
      ((Element)v.get(530)).appendChild((Element)v.get(531));

      /* Empieza nodo:532 / Elemento padre: 531   */
   }

   private void getXML2430(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(532)).setAttribute("src","b.gif" );
      ((Element)v.get(532)).setAttribute("width","8" );
      ((Element)v.get(532)).setAttribute("height","8" );
      ((Element)v.get(531)).appendChild((Element)v.get(532));
      /* Termina nodo:532   */
      /* Termina nodo:531   */
      /* Termina nodo:530   */
      /* Termina nodo:482   */

      /* Empieza nodo:533 / Elemento padre: 142   */
      v.add(doc.createElement("table"));
      ((Element)v.get(533)).setAttribute("width","100%" );
      ((Element)v.get(533)).setAttribute("border","0" );
      ((Element)v.get(533)).setAttribute("align","center" );
      ((Element)v.get(533)).setAttribute("cellspacing","0" );
      ((Element)v.get(533)).setAttribute("cellpadding","0" );
      ((Element)v.get(142)).appendChild((Element)v.get(533));

      /* Empieza nodo:534 / Elemento padre: 533   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(533)).appendChild((Element)v.get(534));

      /* Empieza nodo:535 / Elemento padre: 534   */
      v.add(doc.createElement("td"));
      ((Element)v.get(534)).appendChild((Element)v.get(535));

      /* Empieza nodo:536 / Elemento padre: 535   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(536)).setAttribute("src","b.gif" );
      ((Element)v.get(536)).setAttribute("width","8" );
      ((Element)v.get(536)).setAttribute("height","8" );
      ((Element)v.get(535)).appendChild((Element)v.get(536));
      /* Termina nodo:536   */
      /* Termina nodo:535   */

      /* Empieza nodo:537 / Elemento padre: 534   */
      v.add(doc.createElement("td"));
      ((Element)v.get(534)).appendChild((Element)v.get(537));

      /* Empieza nodo:538 / Elemento padre: 537   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(538)).setAttribute("nombre","lblEstatusProducto" );
      ((Element)v.get(538)).setAttribute("alto","13" );
      ((Element)v.get(538)).setAttribute("filas","1" );
      ((Element)v.get(538)).setAttribute("valor","" );
      ((Element)v.get(538)).setAttribute("id","datosTitle" );
      ((Element)v.get(538)).setAttribute("cod","1077" );
      ((Element)v.get(537)).appendChild((Element)v.get(538));
      /* Termina nodo:538   */
      /* Termina nodo:537   */

      /* Empieza nodo:539 / Elemento padre: 534   */
      v.add(doc.createElement("td"));
      ((Element)v.get(534)).appendChild((Element)v.get(539));

      /* Empieza nodo:540 / Elemento padre: 539   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(540)).setAttribute("src","b.gif" );
      ((Element)v.get(540)).setAttribute("width","25" );
      ((Element)v.get(540)).setAttribute("height","8" );
      ((Element)v.get(539)).appendChild((Element)v.get(540));
      /* Termina nodo:540   */
      /* Termina nodo:539   */

      /* Empieza nodo:541 / Elemento padre: 534   */
      v.add(doc.createElement("td"));
      ((Element)v.get(534)).appendChild((Element)v.get(541));

      /* Empieza nodo:542 / Elemento padre: 541   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(542)).setAttribute("nombre","lblDentroCaja" );
      ((Element)v.get(542)).setAttribute("alto","13" );
      ((Element)v.get(542)).setAttribute("filas","1" );
      ((Element)v.get(542)).setAttribute("valor","" );
      ((Element)v.get(542)).setAttribute("id","datosTitle" );
      ((Element)v.get(542)).setAttribute("cod","1083" );
      ((Element)v.get(541)).appendChild((Element)v.get(542));
      /* Termina nodo:542   */
      /* Termina nodo:541   */

      /* Empieza nodo:543 / Elemento padre: 534   */
      v.add(doc.createElement("td"));
      ((Element)v.get(534)).appendChild((Element)v.get(543));

      /* Empieza nodo:544 / Elemento padre: 543   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(544)).setAttribute("src","b.gif" );
      ((Element)v.get(544)).setAttribute("width","25" );
      ((Element)v.get(544)).setAttribute("height","8" );
      ((Element)v.get(543)).appendChild((Element)v.get(544));
      /* Termina nodo:544   */
      /* Termina nodo:543   */

      /* Empieza nodo:545 / Elemento padre: 534   */
      v.add(doc.createElement("td"));
      ((Element)v.get(534)).appendChild((Element)v.get(545));

      /* Empieza nodo:546 / Elemento padre: 545   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(546)).setAttribute("nombre","lblCodPagoFraccionado" );
      ((Element)v.get(546)).setAttribute("alto","13" );
      ((Element)v.get(546)).setAttribute("filas","1" );
      ((Element)v.get(546)).setAttribute("valor","" );
      ((Element)v.get(546)).setAttribute("id","datosTitle" );
      ((Element)v.get(546)).setAttribute("cod","541" );
      ((Element)v.get(545)).appendChild((Element)v.get(546));
      /* Termina nodo:546   */
      /* Termina nodo:545   */

      /* Empieza nodo:547 / Elemento padre: 534   */
      v.add(doc.createElement("td"));
      ((Element)v.get(534)).appendChild((Element)v.get(547));

      /* Empieza nodo:548 / Elemento padre: 547   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(548)).setAttribute("src","b.gif" );
      ((Element)v.get(548)).setAttribute("width","25" );
      ((Element)v.get(548)).setAttribute("height","8" );
      ((Element)v.get(547)).appendChild((Element)v.get(548));
      /* Termina nodo:548   */
      /* Termina nodo:547   */

      /* Empieza nodo:549 / Elemento padre: 534   */
      v.add(doc.createElement("td"));
      ((Element)v.get(534)).appendChild((Element)v.get(549));

      /* Empieza nodo:550 / Elemento padre: 549   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(550)).setAttribute("nombre","lblCodImpuesto" );
      ((Element)v.get(550)).setAttribute("alto","13" );
      ((Element)v.get(550)).setAttribute("filas","1" );
      ((Element)v.get(550)).setAttribute("valor","" );
      ((Element)v.get(550)).setAttribute("id","datosTitle" );
      ((Element)v.get(550)).setAttribute("cod","1062" );
      ((Element)v.get(549)).appendChild((Element)v.get(550));
      /* Termina nodo:550   */
      /* Termina nodo:549   */

      /* Empieza nodo:551 / Elemento padre: 534   */
      v.add(doc.createElement("td"));
      ((Element)v.get(551)).setAttribute("width","100%" );
      ((Element)v.get(534)).appendChild((Element)v.get(551));

      /* Empieza nodo:552 / Elemento padre: 551   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(552)).setAttribute("src","b.gif" );
      ((Element)v.get(552)).setAttribute("width","8" );
      ((Element)v.get(552)).setAttribute("height","8" );
      ((Element)v.get(551)).appendChild((Element)v.get(552));
      /* Termina nodo:552   */
      /* Termina nodo:551   */
      /* Termina nodo:534   */

      /* Empieza nodo:553 / Elemento padre: 533   */
   }

   private void getXML2520(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(533)).appendChild((Element)v.get(553));

      /* Empieza nodo:554 / Elemento padre: 553   */
      v.add(doc.createElement("td"));
      ((Element)v.get(553)).appendChild((Element)v.get(554));

      /* Empieza nodo:555 / Elemento padre: 554   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(555)).setAttribute("src","b.gif" );
      ((Element)v.get(555)).setAttribute("width","8" );
      ((Element)v.get(555)).setAttribute("height","8" );
      ((Element)v.get(554)).appendChild((Element)v.get(555));
      /* Termina nodo:555   */
      /* Termina nodo:554   */

      /* Empieza nodo:556 / Elemento padre: 553   */
      v.add(doc.createElement("td"));
      ((Element)v.get(556)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(553)).appendChild((Element)v.get(556));

      /* Empieza nodo:557 / Elemento padre: 556   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(557)).setAttribute("nombre","cbSProd" );
      ((Element)v.get(557)).setAttribute("id","datosCampos" );
      ((Element)v.get(557)).setAttribute("size","1" );
      ((Element)v.get(557)).setAttribute("multiple","N" );
      ((Element)v.get(557)).setAttribute("req","N" );
      ((Element)v.get(557)).setAttribute("valorinicial","" );
      ((Element)v.get(557)).setAttribute("textoinicial","" );
      ((Element)v.get(557)).setAttribute("ontab","setTabFocus('cbSProd');" );
      ((Element)v.get(557)).setAttribute("onshtab","setSHTabFocus('cbSProd');" );
      ((Element)v.get(556)).appendChild((Element)v.get(557));

      /* Empieza nodo:558 / Elemento padre: 557   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(557)).appendChild((Element)v.get(558));

      /* Empieza nodo:559 / Elemento padre: 558   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(559)).setAttribute("ID","1" );
      ((Element)v.get(558)).appendChild((Element)v.get(559));

      /* Empieza nodo:560 / Elemento padre: 559   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(560)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(560)).setAttribute("TIPO","STRING" );
      ((Element)v.get(560)).setAttribute("VALOR","00" );
      ((Element)v.get(559)).appendChild((Element)v.get(560));
      /* Termina nodo:560   */

      /* Empieza nodo:561 / Elemento padre: 559   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(561)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(561)).setAttribute("TIPO","STRING" );
      ((Element)v.get(561)).setAttribute("VALOR","xx1" );
      ((Element)v.get(559)).appendChild((Element)v.get(561));
      /* Termina nodo:561   */
      /* Termina nodo:559   */
      /* Termina nodo:558   */
      /* Termina nodo:557   */
      /* Termina nodo:556   */

      /* Empieza nodo:562 / Elemento padre: 553   */
      v.add(doc.createElement("td"));
      ((Element)v.get(553)).appendChild((Element)v.get(562));

      /* Empieza nodo:563 / Elemento padre: 562   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(563)).setAttribute("src","b.gif" );
      ((Element)v.get(563)).setAttribute("width","25" );
      ((Element)v.get(563)).setAttribute("height","8" );
      ((Element)v.get(562)).appendChild((Element)v.get(563));
      /* Termina nodo:563   */
      /* Termina nodo:562   */

      /* Empieza nodo:564 / Elemento padre: 553   */
      v.add(doc.createElement("td"));
      ((Element)v.get(564)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(553)).appendChild((Element)v.get(564));

      /* Empieza nodo:565 / Elemento padre: 564   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(565)).setAttribute("nombre","cbSCaja" );
      ((Element)v.get(565)).setAttribute("id","datosCampos" );
      ((Element)v.get(565)).setAttribute("size","1" );
      ((Element)v.get(565)).setAttribute("multiple","N" );
      ((Element)v.get(565)).setAttribute("req","N" );
      ((Element)v.get(565)).setAttribute("valorinicial","" );
      ((Element)v.get(565)).setAttribute("textoinicial","" );
      ((Element)v.get(565)).setAttribute("ontab","setTabFocus('cbSCaja');" );
      ((Element)v.get(565)).setAttribute("onshtab","setSHTabFocus('cbSCaja');" );
      ((Element)v.get(564)).appendChild((Element)v.get(565));

      /* Empieza nodo:566 / Elemento padre: 565   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(565)).appendChild((Element)v.get(566));
      /* Termina nodo:566   */
      /* Termina nodo:565   */
      /* Termina nodo:564   */

      /* Empieza nodo:567 / Elemento padre: 553   */
      v.add(doc.createElement("td"));
      ((Element)v.get(553)).appendChild((Element)v.get(567));

      /* Empieza nodo:568 / Elemento padre: 567   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(568)).setAttribute("src","b.gif" );
      ((Element)v.get(568)).setAttribute("width","25" );
      ((Element)v.get(568)).setAttribute("height","8" );
      ((Element)v.get(567)).appendChild((Element)v.get(568));
      /* Termina nodo:568   */
      /* Termina nodo:567   */

      /* Empieza nodo:569 / Elemento padre: 553   */
      v.add(doc.createElement("td"));
      ((Element)v.get(569)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(553)).appendChild((Element)v.get(569));

      /* Empieza nodo:570 / Elemento padre: 569   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(570)).setAttribute("nombre","cbFormaPago" );
      ((Element)v.get(570)).setAttribute("id","datosCampos" );
      ((Element)v.get(570)).setAttribute("size","1" );
      ((Element)v.get(570)).setAttribute("multiple","N" );
      ((Element)v.get(570)).setAttribute("req","N" );
      ((Element)v.get(570)).setAttribute("valorinicial","" );
      ((Element)v.get(570)).setAttribute("textoinicial","" );
      ((Element)v.get(570)).setAttribute("ontab","setTabFocus('cbFormaPago');" );
      ((Element)v.get(570)).setAttribute("onshtab","setSHTabFocus('cbFormaPago');" );
      ((Element)v.get(569)).appendChild((Element)v.get(570));

      /* Empieza nodo:571 / Elemento padre: 570   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(570)).appendChild((Element)v.get(571));
      /* Termina nodo:571   */
      /* Termina nodo:570   */
      /* Termina nodo:569   */

      /* Empieza nodo:572 / Elemento padre: 553   */
      v.add(doc.createElement("td"));
      ((Element)v.get(553)).appendChild((Element)v.get(572));

      /* Empieza nodo:573 / Elemento padre: 572   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(573)).setAttribute("src","b.gif" );
      ((Element)v.get(573)).setAttribute("width","25" );
      ((Element)v.get(573)).setAttribute("height","8" );
   }

   private void getXML2610(Document doc) {
      ((Element)v.get(572)).appendChild((Element)v.get(573));
      /* Termina nodo:573   */
      /* Termina nodo:572   */

      /* Empieza nodo:574 / Elemento padre: 553   */
      v.add(doc.createElement("td"));
      ((Element)v.get(574)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(553)).appendChild((Element)v.get(574));

      /* Empieza nodo:575 / Elemento padre: 574   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(575)).setAttribute("nombre","txtCodImpuesto" );
      ((Element)v.get(575)).setAttribute("id","datosCampos" );
      ((Element)v.get(575)).setAttribute("max","2" );
      ((Element)v.get(575)).setAttribute("tipo","" );
      ((Element)v.get(575)).setAttribute("onchange","" );
      ((Element)v.get(575)).setAttribute("req","N" );
      ((Element)v.get(575)).setAttribute("size","2" );
      ((Element)v.get(575)).setAttribute("valor","" );
      ((Element)v.get(575)).setAttribute("validacion","" );
      ((Element)v.get(575)).setAttribute("ontab","setTabFocus('txtCodImpuesto');" );
      ((Element)v.get(575)).setAttribute("onshtab","setSHTabFocus('txtCodImpuesto');" );
      ((Element)v.get(574)).appendChild((Element)v.get(575));
      /* Termina nodo:575   */
      /* Termina nodo:574   */

      /* Empieza nodo:576 / Elemento padre: 553   */
      v.add(doc.createElement("td"));
      ((Element)v.get(576)).setAttribute("width","100%" );
      ((Element)v.get(553)).appendChild((Element)v.get(576));

      /* Empieza nodo:577 / Elemento padre: 576   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(577)).setAttribute("src","b.gif" );
      ((Element)v.get(577)).setAttribute("width","8" );
      ((Element)v.get(577)).setAttribute("height","8" );
      ((Element)v.get(576)).appendChild((Element)v.get(577));
      /* Termina nodo:577   */
      /* Termina nodo:576   */
      /* Termina nodo:553   */

      /* Empieza nodo:578 / Elemento padre: 533   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(533)).appendChild((Element)v.get(578));

      /* Empieza nodo:579 / Elemento padre: 578   */
      v.add(doc.createElement("td"));
      ((Element)v.get(579)).setAttribute("colspan","4" );
      ((Element)v.get(578)).appendChild((Element)v.get(579));

      /* Empieza nodo:580 / Elemento padre: 579   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(580)).setAttribute("src","b.gif" );
      ((Element)v.get(580)).setAttribute("width","8" );
      ((Element)v.get(580)).setAttribute("height","8" );
      ((Element)v.get(579)).appendChild((Element)v.get(580));
      /* Termina nodo:580   */
      /* Termina nodo:579   */
      /* Termina nodo:578   */
      /* Termina nodo:533   */

      /* Empieza nodo:581 / Elemento padre: 142   */
      v.add(doc.createElement("table"));
      ((Element)v.get(581)).setAttribute("width","100%" );
      ((Element)v.get(581)).setAttribute("border","0" );
      ((Element)v.get(581)).setAttribute("align","center" );
      ((Element)v.get(581)).setAttribute("cellspacing","0" );
      ((Element)v.get(581)).setAttribute("cellpadding","0" );
      ((Element)v.get(142)).appendChild((Element)v.get(581));

      /* Empieza nodo:582 / Elemento padre: 581   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(581)).appendChild((Element)v.get(582));

      /* Empieza nodo:583 / Elemento padre: 582   */
      v.add(doc.createElement("td"));
      ((Element)v.get(582)).appendChild((Element)v.get(583));

      /* Empieza nodo:584 / Elemento padre: 583   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(584)).setAttribute("src","b.gif" );
      ((Element)v.get(584)).setAttribute("width","8" );
      ((Element)v.get(584)).setAttribute("height","8" );
      ((Element)v.get(583)).appendChild((Element)v.get(584));
      /* Termina nodo:584   */
      /* Termina nodo:583   */

      /* Empieza nodo:585 / Elemento padre: 582   */
      v.add(doc.createElement("td"));
      ((Element)v.get(582)).appendChild((Element)v.get(585));

      /* Empieza nodo:586 / Elemento padre: 585   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(586)).setAttribute("nombre","lblPrecioCatalogo" );
      ((Element)v.get(586)).setAttribute("alto","13" );
      ((Element)v.get(586)).setAttribute("filas","1" );
      ((Element)v.get(586)).setAttribute("valor","" );
      ((Element)v.get(586)).setAttribute("id","datosTitle" );
      ((Element)v.get(586)).setAttribute("cod","503" );
      ((Element)v.get(585)).appendChild((Element)v.get(586));
      /* Termina nodo:586   */
      /* Termina nodo:585   */

      /* Empieza nodo:587 / Elemento padre: 582   */
      v.add(doc.createElement("td"));
      ((Element)v.get(582)).appendChild((Element)v.get(587));

      /* Empieza nodo:588 / Elemento padre: 587   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(588)).setAttribute("src","b.gif" );
      ((Element)v.get(588)).setAttribute("width","25" );
      ((Element)v.get(588)).setAttribute("height","8" );
      ((Element)v.get(587)).appendChild((Element)v.get(588));
      /* Termina nodo:588   */
      /* Termina nodo:587   */

      /* Empieza nodo:589 / Elemento padre: 582   */
      v.add(doc.createElement("td"));
      ((Element)v.get(582)).appendChild((Element)v.get(589));

      /* Empieza nodo:590 / Elemento padre: 589   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(590)).setAttribute("nombre","lblPrecioContable" );
      ((Element)v.get(590)).setAttribute("alto","13" );
      ((Element)v.get(590)).setAttribute("filas","1" );
      ((Element)v.get(590)).setAttribute("valor","" );
      ((Element)v.get(590)).setAttribute("id","datosTitle" );
      ((Element)v.get(590)).setAttribute("cod","974" );
      ((Element)v.get(589)).appendChild((Element)v.get(590));
      /* Termina nodo:590   */
      /* Termina nodo:589   */

      /* Empieza nodo:591 / Elemento padre: 582   */
      v.add(doc.createElement("td"));
      ((Element)v.get(582)).appendChild((Element)v.get(591));

      /* Empieza nodo:592 / Elemento padre: 591   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(592)).setAttribute("src","b.gif" );
      ((Element)v.get(592)).setAttribute("width","25" );
      ((Element)v.get(592)).setAttribute("height","8" );
      ((Element)v.get(591)).appendChild((Element)v.get(592));
      /* Termina nodo:592   */
      /* Termina nodo:591   */

      /* Empieza nodo:593 / Elemento padre: 582   */
      v.add(doc.createElement("td"));
      ((Element)v.get(582)).appendChild((Element)v.get(593));

      /* Empieza nodo:594 / Elemento padre: 593   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(594)).setAttribute("nombre","lblGrupoArticulos" );
      ((Element)v.get(594)).setAttribute("alto","13" );
   }

   private void getXML2700(Document doc) {
      ((Element)v.get(594)).setAttribute("filas","1" );
      ((Element)v.get(594)).setAttribute("valor","" );
      ((Element)v.get(594)).setAttribute("id","datosTitle" );
      ((Element)v.get(594)).setAttribute("cod","2473" );
      ((Element)v.get(593)).appendChild((Element)v.get(594));
      /* Termina nodo:594   */
      /* Termina nodo:593   */

      /* Empieza nodo:595 / Elemento padre: 582   */
      v.add(doc.createElement("td"));
      ((Element)v.get(582)).appendChild((Element)v.get(595));

      /* Empieza nodo:596 / Elemento padre: 595   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(596)).setAttribute("src","b.gif" );
      ((Element)v.get(596)).setAttribute("width","25" );
      ((Element)v.get(596)).setAttribute("height","8" );
      ((Element)v.get(595)).appendChild((Element)v.get(596));
      /* Termina nodo:596   */
      /* Termina nodo:595   */

      /* Empieza nodo:597 / Elemento padre: 582   */
      v.add(doc.createElement("td"));
      ((Element)v.get(582)).appendChild((Element)v.get(597));

      /* Empieza nodo:598 / Elemento padre: 597   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(598)).setAttribute("nombre","lblProgFidelizacion" );
      ((Element)v.get(598)).setAttribute("alto","13" );
      ((Element)v.get(598)).setAttribute("filas","1" );
      ((Element)v.get(598)).setAttribute("valor","" );
      ((Element)v.get(598)).setAttribute("id","datosTitle" );
      ((Element)v.get(598)).setAttribute("cod","3052" );
      ((Element)v.get(597)).appendChild((Element)v.get(598));
      /* Termina nodo:598   */
      /* Termina nodo:597   */

      /* Empieza nodo:599 / Elemento padre: 582   */
      v.add(doc.createElement("td"));
      ((Element)v.get(599)).setAttribute("width","100%" );
      ((Element)v.get(582)).appendChild((Element)v.get(599));

      /* Empieza nodo:600 / Elemento padre: 599   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(600)).setAttribute("src","b.gif" );
      ((Element)v.get(600)).setAttribute("width","8" );
      ((Element)v.get(600)).setAttribute("height","8" );
      ((Element)v.get(599)).appendChild((Element)v.get(600));
      /* Termina nodo:600   */
      /* Termina nodo:599   */
      /* Termina nodo:582   */

      /* Empieza nodo:601 / Elemento padre: 581   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(581)).appendChild((Element)v.get(601));

      /* Empieza nodo:602 / Elemento padre: 601   */
      v.add(doc.createElement("td"));
      ((Element)v.get(601)).appendChild((Element)v.get(602));

      /* Empieza nodo:603 / Elemento padre: 602   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(603)).setAttribute("src","b.gif" );
      ((Element)v.get(603)).setAttribute("width","8" );
      ((Element)v.get(603)).setAttribute("height","8" );
      ((Element)v.get(602)).appendChild((Element)v.get(603));
      /* Termina nodo:603   */
      /* Termina nodo:602   */

      /* Empieza nodo:604 / Elemento padre: 601   */
      v.add(doc.createElement("td"));
      ((Element)v.get(604)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(601)).appendChild((Element)v.get(604));

      /* Empieza nodo:605 / Elemento padre: 604   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(605)).setAttribute("nombre","txtPrecioCatalogo" );
      ((Element)v.get(605)).setAttribute("id","datosCampos" );
      ((Element)v.get(605)).setAttribute("max","16" );
      ((Element)v.get(605)).setAttribute("tipo","" );
      ((Element)v.get(605)).setAttribute("onchange","" );
      ((Element)v.get(605)).setAttribute("req","N" );
      ((Element)v.get(605)).setAttribute("size","20" );
      ((Element)v.get(605)).setAttribute("valor","" );
      ((Element)v.get(605)).setAttribute("validacion","" );
      ((Element)v.get(605)).setAttribute("ontab","setTabFocus('txtPrecioCatalogo');" );
      ((Element)v.get(605)).setAttribute("onshtab","setSHTabFocus('txtPrecioCatalogo');" );
      ((Element)v.get(604)).appendChild((Element)v.get(605));
      /* Termina nodo:605   */
      /* Termina nodo:604   */

      /* Empieza nodo:606 / Elemento padre: 601   */
      v.add(doc.createElement("td"));
      ((Element)v.get(601)).appendChild((Element)v.get(606));

      /* Empieza nodo:607 / Elemento padre: 606   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(607)).setAttribute("src","b.gif" );
      ((Element)v.get(607)).setAttribute("width","25" );
      ((Element)v.get(607)).setAttribute("height","8" );
      ((Element)v.get(606)).appendChild((Element)v.get(607));
      /* Termina nodo:607   */
      /* Termina nodo:606   */

      /* Empieza nodo:608 / Elemento padre: 601   */
      v.add(doc.createElement("td"));
      ((Element)v.get(608)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(601)).appendChild((Element)v.get(608));

      /* Empieza nodo:609 / Elemento padre: 608   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(609)).setAttribute("nombre","txtPrecioContable" );
      ((Element)v.get(609)).setAttribute("id","datosCampos" );
      ((Element)v.get(609)).setAttribute("max","16" );
      ((Element)v.get(609)).setAttribute("tipo","" );
      ((Element)v.get(609)).setAttribute("onchange","" );
      ((Element)v.get(609)).setAttribute("req","N" );
      ((Element)v.get(609)).setAttribute("size","20" );
      ((Element)v.get(609)).setAttribute("valor","" );
      ((Element)v.get(609)).setAttribute("validacion","" );
      ((Element)v.get(609)).setAttribute("ontab","setTabFocus('txtPrecioContable');" );
      ((Element)v.get(609)).setAttribute("onshtab","setSHTabFocus('txtPrecioContable');" );
      ((Element)v.get(608)).appendChild((Element)v.get(609));
      /* Termina nodo:609   */
      /* Termina nodo:608   */

      /* Empieza nodo:610 / Elemento padre: 601   */
      v.add(doc.createElement("td"));
      ((Element)v.get(601)).appendChild((Element)v.get(610));

      /* Empieza nodo:611 / Elemento padre: 610   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(611)).setAttribute("src","b.gif" );
      ((Element)v.get(611)).setAttribute("width","25" );
      ((Element)v.get(611)).setAttribute("height","8" );
      ((Element)v.get(610)).appendChild((Element)v.get(611));
      /* Termina nodo:611   */
      /* Termina nodo:610   */

      /* Empieza nodo:612 / Elemento padre: 601   */
      v.add(doc.createElement("td"));
      ((Element)v.get(612)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(601)).appendChild((Element)v.get(612));

      /* Empieza nodo:613 / Elemento padre: 612   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(613)).setAttribute("nombre","txtGrupoArticulos" );
   }

   private void getXML2790(Document doc) {
      ((Element)v.get(613)).setAttribute("id","datosCampos" );
      ((Element)v.get(613)).setAttribute("max","9" );
      ((Element)v.get(613)).setAttribute("tipo","" );
      ((Element)v.get(613)).setAttribute("onchange","" );
      ((Element)v.get(613)).setAttribute("req","N" );
      ((Element)v.get(613)).setAttribute("size","11" );
      ((Element)v.get(613)).setAttribute("valor","" );
      ((Element)v.get(613)).setAttribute("validacion","" );
      ((Element)v.get(613)).setAttribute("ontab","setTabFocus('txtGrupoArticulos');" );
      ((Element)v.get(613)).setAttribute("onshtab","setSHTabFocus('txtGrupoArticulos');" );
      ((Element)v.get(612)).appendChild((Element)v.get(613));
      /* Termina nodo:613   */
      /* Termina nodo:612   */

      /* Empieza nodo:614 / Elemento padre: 601   */
      v.add(doc.createElement("td"));
      ((Element)v.get(601)).appendChild((Element)v.get(614));

      /* Empieza nodo:615 / Elemento padre: 614   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(615)).setAttribute("src","b.gif" );
      ((Element)v.get(615)).setAttribute("width","25" );
      ((Element)v.get(615)).setAttribute("height","8" );
      ((Element)v.get(614)).appendChild((Element)v.get(615));
      /* Termina nodo:615   */
      /* Termina nodo:614   */

      /* Empieza nodo:616 / Elemento padre: 601   */
      v.add(doc.createElement("td"));
      ((Element)v.get(616)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(601)).appendChild((Element)v.get(616));

      /* Empieza nodo:617 / Elemento padre: 616   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(617)).setAttribute("nombre","cbProgFidelizacion" );
      ((Element)v.get(617)).setAttribute("id","datosCampos" );
      ((Element)v.get(617)).setAttribute("size","1" );
      ((Element)v.get(617)).setAttribute("multiple","N" );
      ((Element)v.get(617)).setAttribute("req","N" );
      ((Element)v.get(617)).setAttribute("valorinicial","" );
      ((Element)v.get(617)).setAttribute("textoinicial","" );
      ((Element)v.get(617)).setAttribute("ontab","setTabFocus('cbProgFidelizacion');" );
      ((Element)v.get(617)).setAttribute("onshtab","setSHTabFocus('cbProgFidelizacion');" );
      ((Element)v.get(616)).appendChild((Element)v.get(617));

      /* Empieza nodo:618 / Elemento padre: 617   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(617)).appendChild((Element)v.get(618));
      /* Termina nodo:618   */
      /* Termina nodo:617   */
      /* Termina nodo:616   */

      /* Empieza nodo:619 / Elemento padre: 601   */
      v.add(doc.createElement("td"));
      ((Element)v.get(619)).setAttribute("width","100%" );
      ((Element)v.get(601)).appendChild((Element)v.get(619));

      /* Empieza nodo:620 / Elemento padre: 619   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(620)).setAttribute("src","b.gif" );
      ((Element)v.get(620)).setAttribute("width","8" );
      ((Element)v.get(620)).setAttribute("height","8" );
      ((Element)v.get(619)).appendChild((Element)v.get(620));
      /* Termina nodo:620   */
      /* Termina nodo:619   */
      /* Termina nodo:601   */

      /* Empieza nodo:621 / Elemento padre: 581   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(581)).appendChild((Element)v.get(621));

      /* Empieza nodo:622 / Elemento padre: 621   */
      v.add(doc.createElement("td"));
      ((Element)v.get(622)).setAttribute("colspan","4" );
      ((Element)v.get(621)).appendChild((Element)v.get(622));

      /* Empieza nodo:623 / Elemento padre: 622   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(623)).setAttribute("src","b.gif" );
      ((Element)v.get(623)).setAttribute("width","8" );
      ((Element)v.get(623)).setAttribute("height","8" );
      ((Element)v.get(622)).appendChild((Element)v.get(623));
      /* Termina nodo:623   */
      /* Termina nodo:622   */
      /* Termina nodo:621   */
      /* Termina nodo:581   */
      /* Termina nodo:142   */
      /* Termina nodo:141   */

      /* Empieza nodo:624 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(138)).appendChild((Element)v.get(624));

      /* Empieza nodo:625 / Elemento padre: 624   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(625)).setAttribute("src","b.gif" );
      ((Element)v.get(624)).appendChild((Element)v.get(625));
      /* Termina nodo:625   */
      /* Termina nodo:624   */
      /* Termina nodo:138   */

      /* Empieza nodo:626 / Elemento padre: 130   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(130)).appendChild((Element)v.get(626));

      /* Empieza nodo:627 / Elemento padre: 626   */
      v.add(doc.createElement("td"));
      ((Element)v.get(627)).setAttribute("width","12" );
      ((Element)v.get(627)).setAttribute("align","center" );
      ((Element)v.get(626)).appendChild((Element)v.get(627));

      /* Empieza nodo:628 / Elemento padre: 627   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(628)).setAttribute("src","b.gif" );
      ((Element)v.get(628)).setAttribute("width","12" );
      ((Element)v.get(628)).setAttribute("height","12" );
      ((Element)v.get(627)).appendChild((Element)v.get(628));
      /* Termina nodo:628   */
      /* Termina nodo:627   */

      /* Empieza nodo:629 / Elemento padre: 626   */
      v.add(doc.createElement("td"));
      ((Element)v.get(629)).setAttribute("width","750" );
      ((Element)v.get(626)).appendChild((Element)v.get(629));

      /* Empieza nodo:630 / Elemento padre: 629   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(630)).setAttribute("src","b.gif" );
      ((Element)v.get(629)).appendChild((Element)v.get(630));
      /* Termina nodo:630   */
      /* Termina nodo:629   */

      /* Empieza nodo:631 / Elemento padre: 626   */
      v.add(doc.createElement("td"));
      ((Element)v.get(631)).setAttribute("width","12" );
      ((Element)v.get(626)).appendChild((Element)v.get(631));

      /* Empieza nodo:632 / Elemento padre: 631   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(632)).setAttribute("src","b.gif" );
      ((Element)v.get(632)).setAttribute("width","12" );
      ((Element)v.get(632)).setAttribute("height","1" );
      ((Element)v.get(631)).appendChild((Element)v.get(632));
      /* Termina nodo:632   */
      /* Termina nodo:631   */
      /* Termina nodo:626   */
      /* Termina nodo:130   */
      /* Termina nodo:129   */
      /* Termina nodo:43   */


   }

}
