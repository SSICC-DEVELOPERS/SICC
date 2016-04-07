
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_nivel_ranking_mantener  implements es.indra.druida.base.ObjetoXML {
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
         

      getXML2880(doc);
         

      getXML2970(doc);
         

      getXML3060(doc);
         

      getXML3150(doc);
         

      getXML3240(doc);
         

      getXML3330(doc);
         

      getXML3420(doc);
         

      getXML3510(doc);
         

      getXML3600(doc);
         

      getXML3690(doc);
         

      getXML3780(doc);
         

      getXML3870(doc);
         

      getXML3960(doc);
         

      getXML4050(doc);
         

      getXML4140(doc);
         

      getXML4230(doc);
         

      getXML4320(doc);
         

      getXML4410(doc);
         

      getXML4500(doc);
         

      getXML4590(doc);
         

      getXML4680(doc);
         

      getXML4770(doc);
         

      getXML4860(doc);
         

      getXML4950(doc);
         

      getXML5040(doc);
         

      getXML5130(doc);
         

      getXML5220(doc);
         

      getXML5310(doc);
         
      MgetXML0 (doc);
            
            return (Element)v.get(0);
            
}
   private void MgetXML0 (Document doc) {
            

      getXML5400(doc);
         

      getXML5490(doc);
         
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_nivel_ranking_mantener" );
      ((Element)v.get(0)).setAttribute("cod","0530" );
      ((Element)v.get(0)).setAttribute("titulo","Mantener nivel" );
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
      ((Element)v.get(3)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","contenido_nivel_ranking_mantener.js" );
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
      ((Element)v.get(7)).setAttribute("name","cbConcursoDestino" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("group","gPuntos" );
      ((Element)v.get(7)).setAttribute("cod","1835" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","cbTipoPremioPuntos1" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("group","gPuntos" );
      ((Element)v.get(8)).setAttribute("cod","1836" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","txtCantidad1" );
      ((Element)v.get(9)).setAttribute("required","false" );
      ((Element)v.get(9)).setAttribute("min","0" );
      ((Element)v.get(9)).setAttribute("max","999999" );
      ((Element)v.get(9)).setAttribute("format","e" );
      ((Element)v.get(9)).setAttribute("group","gPuntos" );
      ((Element)v.get(9)).setAttribute("cod","1172" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","txtPorcentaje1" );
      ((Element)v.get(10)).setAttribute("required","false" );
      ((Element)v.get(10)).setAttribute("min","0" );
      ((Element)v.get(10)).setAttribute("max","999.999" );
      ((Element)v.get(10)).setAttribute("format","n" );
      ((Element)v.get(10)).setAttribute("group","gPuntos" );
      ((Element)v.get(10)).setAttribute("cod","790" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","txtCantidad1" );
      ((Element)v.get(11)).setAttribute("required","true" );
      ((Element)v.get(11)).setAttribute("min","0" );
      ((Element)v.get(11)).setAttribute("max","999999" );
      ((Element)v.get(11)).setAttribute("format","e" );
      ((Element)v.get(11)).setAttribute("group","gPuntosCantidad" );
      ((Element)v.get(11)).setAttribute("cod","1172" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","txtPorcentaje1" );
      ((Element)v.get(12)).setAttribute("required","true" );
      ((Element)v.get(12)).setAttribute("min","0" );
      ((Element)v.get(12)).setAttribute("max","999.999" );
      ((Element)v.get(12)).setAttribute("format","n" );
      ((Element)v.get(12)).setAttribute("group","gPuntosPorcentaje" );
      ((Element)v.get(12)).setAttribute("cod","790" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(13)).setAttribute("name","cbTipoPremioDescuento5" );
      ((Element)v.get(13)).setAttribute("required","true" );
      ((Element)v.get(13)).setAttribute("group","gDescuento" );
      ((Element)v.get(13)).setAttribute("cod","1855" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(14)).setAttribute("name","cbPeriodoAplicacionDesde" );
      ((Element)v.get(14)).setAttribute("required","true" );
      ((Element)v.get(14)).setAttribute("group","gDescuento" );
      ((Element)v.get(14)).setAttribute("cod","1899" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(15)).setAttribute("name","txtCantidadDescuento" );
      ((Element)v.get(15)).setAttribute("required","false" );
      ((Element)v.get(15)).setAttribute("min","0" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(15)).setAttribute("max","9999.99" );
      ((Element)v.get(15)).setAttribute("format","m" );
      ((Element)v.get(15)).setAttribute("group","gDescuento" );
      ((Element)v.get(15)).setAttribute("cod","1856" );
      ((Element)v.get(6)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(16)).setAttribute("name","txtPorcentaje5" );
      ((Element)v.get(16)).setAttribute("required","false" );
      ((Element)v.get(16)).setAttribute("min","0" );
      ((Element)v.get(16)).setAttribute("max","999.99" );
      ((Element)v.get(16)).setAttribute("format","n" );
      ((Element)v.get(16)).setAttribute("group","gDescuento" );
      ((Element)v.get(16)).setAttribute("cod","790" );
      ((Element)v.get(6)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(17)).setAttribute("name","txtCantidadDescuento" );
      ((Element)v.get(17)).setAttribute("required","true" );
      ((Element)v.get(17)).setAttribute("min","0" );
      ((Element)v.get(17)).setAttribute("max","9999.99" );
      ((Element)v.get(17)).setAttribute("format","m" );
      ((Element)v.get(17)).setAttribute("group","gDescuentoCantidad" );
      ((Element)v.get(17)).setAttribute("cod","1856" );
      ((Element)v.get(6)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(18)).setAttribute("name","txtPorcentaje5" );
      ((Element)v.get(18)).setAttribute("required","true" );
      ((Element)v.get(18)).setAttribute("min","0" );
      ((Element)v.get(18)).setAttribute("max","999.99" );
      ((Element)v.get(18)).setAttribute("format","n" );
      ((Element)v.get(18)).setAttribute("group","gDescuentoPorcentaje" );
      ((Element)v.get(18)).setAttribute("cod","790" );
      ((Element)v.get(6)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(19)).setAttribute("name","cbMarca" );
      ((Element)v.get(19)).setAttribute("required","true" );
      ((Element)v.get(19)).setAttribute("group","gDescuentoProducto" );
      ((Element)v.get(19)).setAttribute("cod","6" );
      ((Element)v.get(6)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(20)).setAttribute("name","cbTipoPremioMonetario2" );
      ((Element)v.get(20)).setAttribute("required","true" );
      ((Element)v.get(20)).setAttribute("group","gMonetario" );
      ((Element)v.get(20)).setAttribute("cod","1837" );
      ((Element)v.get(6)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(21)).setAttribute("name","cbMoneda" );
      ((Element)v.get(21)).setAttribute("required","true" );
      ((Element)v.get(21)).setAttribute("group","gMonetario" );
      ((Element)v.get(21)).setAttribute("cod","1216" );
      ((Element)v.get(6)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(22)).setAttribute("name","cbFormaPago" );
      ((Element)v.get(22)).setAttribute("required","true" );
      ((Element)v.get(22)).setAttribute("group","gMonetario" );
      ((Element)v.get(22)).setAttribute("cod","541" );
      ((Element)v.get(6)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(23)).setAttribute("name","txtCantidad2" );
      ((Element)v.get(23)).setAttribute("required","false" );
      ((Element)v.get(23)).setAttribute("min","0" );
      ((Element)v.get(23)).setAttribute("max","999999" );
      ((Element)v.get(23)).setAttribute("format","e" );
      ((Element)v.get(23)).setAttribute("group","gMonetario" );
      ((Element)v.get(23)).setAttribute("cod","1172" );
      ((Element)v.get(6)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(24)).setAttribute("name","txtPorcentaje2" );
      ((Element)v.get(24)).setAttribute("required","false" );
      ((Element)v.get(24)).setAttribute("min","0" );
      ((Element)v.get(24)).setAttribute("max","999.99" );
      ((Element)v.get(24)).setAttribute("format","n" );
      ((Element)v.get(24)).setAttribute("group","gMonetario" );
      ((Element)v.get(24)).setAttribute("cod","790" );
      ((Element)v.get(6)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(25)).setAttribute("name","txtCantidad2" );
      ((Element)v.get(25)).setAttribute("required","true" );
      ((Element)v.get(25)).setAttribute("min","0" );
      ((Element)v.get(25)).setAttribute("max","999999" );
      ((Element)v.get(25)).setAttribute("format","e" );
      ((Element)v.get(25)).setAttribute("group","gMonetarioCantidad" );
      ((Element)v.get(25)).setAttribute("cod","1172" );
      ((Element)v.get(6)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(26)).setAttribute("name","txtPorcentaje2" );
      ((Element)v.get(26)).setAttribute("required","true" );
      ((Element)v.get(26)).setAttribute("min","0" );
      ((Element)v.get(26)).setAttribute("max","999.99" );
      ((Element)v.get(26)).setAttribute("format","n" );
      ((Element)v.get(26)).setAttribute("group","gMonetarioPorcentaje" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(26)).setAttribute("cod","790" );
      ((Element)v.get(6)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(27)).setAttribute("name","cbCumplimiento" );
      ((Element)v.get(27)).setAttribute("required","true" );
      ((Element)v.get(27)).setAttribute("group","gMonetarioCumplimiento" );
      ((Element)v.get(27)).setAttribute("cod","1839" );
      ((Element)v.get(6)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(28)).setAttribute("name","txtPremio" );
      ((Element)v.get(28)).setAttribute("required","true" );
      ((Element)v.get(28)).setAttribute("min","0" );
      ((Element)v.get(28)).setAttribute("max","999.99" );
      ((Element)v.get(28)).setAttribute("format","m" );
      ((Element)v.get(28)).setAttribute("group","gMonetarioPago" );
      ((Element)v.get(28)).setAttribute("cod","1380" );
      ((Element)v.get(6)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(29)).setAttribute("name","cbPeriodoControl" );
      ((Element)v.get(29)).setAttribute("required","true" );
      ((Element)v.get(29)).setAttribute("group","gMonetarioPago" );
      ((Element)v.get(29)).setAttribute("cod","1842" );
      ((Element)v.get(6)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(30)).setAttribute("name","txtCodProducto" );
      ((Element)v.get(30)).setAttribute("required","true" );
      ((Element)v.get(30)).setAttribute("group","gArticuloProducto" );
      ((Element)v.get(30)).setAttribute("cod","337" );
      ((Element)v.get(6)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(31)).setAttribute("name","txtNumUnidades4" );
      ((Element)v.get(31)).setAttribute("required","true" );
      ((Element)v.get(31)).setAttribute("min","0" );
      ((Element)v.get(31)).setAttribute("max","9999" );
      ((Element)v.get(31)).setAttribute("format","e" );
      ((Element)v.get(31)).setAttribute("group","gArticuloProducto" );
      ((Element)v.get(31)).setAttribute("cod","495" );
      ((Element)v.get(6)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(32)).setAttribute("name","txtPrecioPublico4" );
      ((Element)v.get(32)).setAttribute("required","true" );
      ((Element)v.get(32)).setAttribute("min","0" );
      ((Element)v.get(32)).setAttribute("max","9999999.99" );
      ((Element)v.get(32)).setAttribute("format","m" );
      ((Element)v.get(32)).setAttribute("group","gArticuloProducto" );
      ((Element)v.get(32)).setAttribute("cod","1854" );
      ((Element)v.get(6)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(33)).setAttribute("name","cbCenServGar" );
      ((Element)v.get(33)).setAttribute("required","true" );
      ((Element)v.get(33)).setAttribute("group","gCenServGar" );
      ((Element)v.get(33)).setAttribute("cod","3185" );
      ((Element)v.get(6)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(34)).setAttribute("name","txtNumMeses" );
      ((Element)v.get(34)).setAttribute("required","false" );
      ((Element)v.get(34)).setAttribute("min","0" );
      ((Element)v.get(34)).setAttribute("max","9999" );
      ((Element)v.get(34)).setAttribute("format","e" );
      ((Element)v.get(34)).setAttribute("group","gCenServGar" );
      ((Element)v.get(34)).setAttribute("cod","3186" );
      ((Element)v.get(6)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(35)).setAttribute("name","cbCenServEntrega" );
      ((Element)v.get(35)).setAttribute("required","true" );
      ((Element)v.get(35)).setAttribute("group","gCenServEntrega" );
      ((Element)v.get(35)).setAttribute("cod","3188" );
      ((Element)v.get(6)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(36)).setAttribute("name","txtDescripcionLote4" );
      ((Element)v.get(36)).setAttribute("required","true" );
      ((Element)v.get(36)).setAttribute("group","gArticulo" );
      ((Element)v.get(36)).setAttribute("cod","844" );
      ((Element)v.get(6)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */
      /* Termina nodo:6   */
      /* Termina nodo:5   */

      /* Empieza nodo:37 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(37)).setAttribute("nombre","formulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","accion" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(41)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","hPais" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","hIdioma" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","hOidMarca" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","datosNiveles" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","listaDatosNiveles" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","numeroPremio" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","numeroPremioPuntos" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","numeroPremioMonetarios" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(51)).setAttribute("nombre","numeroPremioArticulos" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(52)).setAttribute("nombre","numeroPremioDescuento" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(53)).setAttribute("nombre","nivelAIngresar" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(54)).setAttribute("nombre","numeroNiveles" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(55)).setAttribute("nombre","IND_INACTIVO" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(56)).setAttribute("nombre","IND_ACTIVO" );
      ((Element)v.get(56)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(57)).setAttribute("nombre","OID_TIPO_PREMIO_PUNTOS" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(58)).setAttribute("nombre","OID_TIPO_PREMIO_MONETARIO" );
      ((Element)v.get(58)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */

      /* Empieza nodo:59 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(59)).setAttribute("nombre","OID_TIPO_PREMIO_ARTICULO" );
      ((Element)v.get(59)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */

      /* Empieza nodo:60 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(60)).setAttribute("nombre","OID_TIPO_PREMIO_DESCUENTO" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */

      /* Empieza nodo:61 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(61)).setAttribute("nombre","OID_TIPO_PREM_PTOS_CANT_FIJA" );
      ((Element)v.get(61)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */

      /* Empieza nodo:62 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(62)).setAttribute("nombre","OID_TIPO_PREM_PTOS_PORC_PUNTAJE_OBT" );
      ((Element)v.get(62)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */

      /* Empieza nodo:63 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(63)).setAttribute("nombre","OID_TIPO_PREM_PTOS_PUNTAJE_OBT" );
      ((Element)v.get(63)).setAttribute("valor","" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(37)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */

      /* Empieza nodo:64 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(64)).setAttribute("nombre","OID_TIPO_PREM_MONET_CANT_FIJA" );
      ((Element)v.get(64)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */

      /* Empieza nodo:65 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(65)).setAttribute("nombre","OID_TIPO_PREM_MONET_PORC_PUNTAJE_OBT" );
      ((Element)v.get(65)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */

      /* Empieza nodo:66 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(66)).setAttribute("nombre","OID_TIPO_PREM_MONET_PUNTAJE_OBT" );
      ((Element)v.get(66)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */

      /* Empieza nodo:67 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(67)).setAttribute("nombre","OID_TIPO_DET_METAS_BONO_ANUAL" );
      ((Element)v.get(67)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */

      /* Empieza nodo:68 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(68)).setAttribute("nombre","OID_TIPO_CUMPLIMIENTO_TOTAL" );
      ((Element)v.get(68)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */

      /* Empieza nodo:69 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(69)).setAttribute("nombre","oidMonedaDefault" );
      ((Element)v.get(69)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */

      /* Empieza nodo:70 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(70)).setAttribute("nombre","hOidTipoDeterminacionMetas" );
      ((Element)v.get(70)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */

      /* Empieza nodo:71 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(71)).setAttribute("nombre","OID_TIPO_DESCUENTO_IMPORTE" );
      ((Element)v.get(71)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */

      /* Empieza nodo:72 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(72)).setAttribute("nombre","OID_TIPO_DESCUENTO_PORCENTAJE" );
      ((Element)v.get(72)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */

      /* Empieza nodo:73 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(73)).setAttribute("nombre","hIndPremiosElectivosPremios" );
      ((Element)v.get(73)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */

      /* Empieza nodo:74 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(74)).setAttribute("nombre","oidPremioPuntos" );
      ((Element)v.get(74)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */

      /* Empieza nodo:75 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(75)).setAttribute("nombre","oidPremioMonetario" );
      ((Element)v.get(75)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */

      /* Empieza nodo:76 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(76)).setAttribute("nombre","oidPremioArticulo" );
      ((Element)v.get(76)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */

      /* Empieza nodo:77 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(77)).setAttribute("nombre","oidPremioDescuento" );
      ((Element)v.get(77)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */

      /* Empieza nodo:78 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(78)).setAttribute("nombre","numeroPago" );
      ((Element)v.get(78)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */

      /* Empieza nodo:79 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(79)).setAttribute("nombre","codLotelista" );
      ((Element)v.get(79)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */

      /* Empieza nodo:80 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(80)).setAttribute("nombre","cantidadPremiosArticulos" );
      ((Element)v.get(80)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */

      /* Empieza nodo:81 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(81)).setAttribute("nombre","oidProdDescuentos" );
      ((Element)v.get(81)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */

      /* Empieza nodo:82 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(82)).setAttribute("nombre","oidProdArticulos" );
      ((Element)v.get(82)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */

      /* Empieza nodo:83 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(83)).setAttribute("nombre","txtNumUnidadesPremiosArticulo" );
      ((Element)v.get(83)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */

      /* Empieza nodo:84 / Elemento padre: 37   */
      v.add(doc.createElement("table"));
      ((Element)v.get(84)).setAttribute("width","100%" );
      ((Element)v.get(84)).setAttribute("border","0" );
      ((Element)v.get(84)).setAttribute("cellspacing","0" );
      ((Element)v.get(84)).setAttribute("cellpadding","0" );
      ((Element)v.get(37)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(84)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(86)).setAttribute("width","100%" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(87)).setAttribute("src","b.gif" );
      ((Element)v.get(87)).setAttribute("width","752" );
      ((Element)v.get(87)).setAttribute("height","8" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */
      /* Termina nodo:85   */
      /* Termina nodo:84   */

      /* Empieza nodo:88 / Elemento padre: 37   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(88)).setAttribute("nombre","listado" );
      ((Element)v.get(88)).setAttribute("ancho","732" );
      ((Element)v.get(88)).setAttribute("alto","317" );
      ((Element)v.get(88)).setAttribute("x","12" );
      ((Element)v.get(88)).setAttribute("y","12" );
      ((Element)v.get(88)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(88)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(37)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(89)).setAttribute("precarga","S" );
      ((Element)v.get(89)).setAttribute("conROver","S" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(90)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(90)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(90)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(90)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */

      /* Empieza nodo:91 / Elemento padre: 89   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(91)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(91)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(91)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(91)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(89)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */

      /* Empieza nodo:92 / Elemento padre: 89   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(92)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(92)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(89)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:89   */

      /* Empieza nodo:93 / Elemento padre: 88   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(88)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(94)).setAttribute("borde","1" );
      ((Element)v.get(94)).setAttribute("horizDatos","1" );
      ((Element)v.get(94)).setAttribute("horizCabecera","1" );
      ((Element)v.get(94)).setAttribute("vertical","0" );
      ((Element)v.get(94)).setAttribute("horizTitulo","1" );
      ((Element)v.get(94)).setAttribute("horizBase","1" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */

      /* Empieza nodo:95 / Elemento padre: 93   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(95)).setAttribute("borde","#999999" );
      ((Element)v.get(95)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(95)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(95)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(95)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(95)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(95)).setAttribute("horizBase","#999999" );
      ((Element)v.get(93)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:93   */

      /* Empieza nodo:96 / Elemento padre: 88   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(96)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(96)).setAttribute("alto","22" );
      ((Element)v.get(96)).setAttribute("imgFondo","" );
      ((Element)v.get(96)).setAttribute("cod","00346" );
      ((Element)v.get(96)).setAttribute("ID","datosTitle" );
      ((Element)v.get(88)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */

      /* Empieza nodo:97 / Elemento padre: 88   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(97)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(97)).setAttribute("alto","22" );
      ((Element)v.get(97)).setAttribute("imgFondo","" );
      ((Element)v.get(88)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */

      /* Empieza nodo:98 / Elemento padre: 88   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(98)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(98)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(98)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(98)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(98)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(98)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(88)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(99)).setAttribute("ancho","80" );
      ((Element)v.get(99)).setAttribute("minimizable","S" );
      ((Element)v.get(99)).setAttribute("minimizada","N" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */

      /* Empieza nodo:100 / Elemento padre: 98   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(100)).setAttribute("ancho","100" );
      ((Element)v.get(100)).setAttribute("minimizable","S" );
      ((Element)v.get(100)).setAttribute("minimizada","N" );
      ((Element)v.get(98)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */

      /* Empieza nodo:101 / Elemento padre: 98   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(101)).setAttribute("ancho","100" );
      ((Element)v.get(101)).setAttribute("minimizable","S" );
      ((Element)v.get(101)).setAttribute("minimizada","N" );
      ((Element)v.get(98)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */

      /* Empieza nodo:102 / Elemento padre: 98   */
   }

   private void getXML540(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(102)).setAttribute("ancho","100" );
      ((Element)v.get(102)).setAttribute("minimizable","S" );
      ((Element)v.get(102)).setAttribute("minimizada","N" );
      ((Element)v.get(98)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */

      /* Empieza nodo:103 / Elemento padre: 98   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(103)).setAttribute("ancho","140" );
      ((Element)v.get(103)).setAttribute("minimizable","S" );
      ((Element)v.get(103)).setAttribute("minimizada","N" );
      ((Element)v.get(98)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */

      /* Empieza nodo:104 / Elemento padre: 98   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(104)).setAttribute("ancho","120" );
      ((Element)v.get(104)).setAttribute("minimizable","S" );
      ((Element)v.get(104)).setAttribute("minimizada","N" );
      ((Element)v.get(98)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */

      /* Empieza nodo:105 / Elemento padre: 98   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(105)).setAttribute("ancho","120" );
      ((Element)v.get(105)).setAttribute("minimizable","S" );
      ((Element)v.get(105)).setAttribute("minimizada","N" );
      ((Element)v.get(98)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */

      /* Empieza nodo:106 / Elemento padre: 98   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(106)).setAttribute("ancho","180" );
      ((Element)v.get(106)).setAttribute("minimizable","S" );
      ((Element)v.get(106)).setAttribute("minimizada","N" );
      ((Element)v.get(98)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */

      /* Empieza nodo:107 / Elemento padre: 98   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(107)).setAttribute("ancho","100" );
      ((Element)v.get(107)).setAttribute("minimizable","S" );
      ((Element)v.get(107)).setAttribute("minimizada","N" );
      ((Element)v.get(98)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */

      /* Empieza nodo:108 / Elemento padre: 98   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(108)).setAttribute("ancho","100" );
      ((Element)v.get(108)).setAttribute("minimizable","S" );
      ((Element)v.get(108)).setAttribute("minimizada","N" );
      ((Element)v.get(108)).setAttribute("oculta","S" );
      ((Element)v.get(98)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:98   */

      /* Empieza nodo:109 / Elemento padre: 88   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(109)).setAttribute("alto","20" );
      ((Element)v.get(109)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(109)).setAttribute("imgFondo","" );
      ((Element)v.get(109)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(88)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(110)).setAttribute("colFondo","" );
      ((Element)v.get(110)).setAttribute("ID","EstCab" );
      ((Element)v.get(110)).setAttribute("cod","1664" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */

      /* Empieza nodo:111 / Elemento padre: 109   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(111)).setAttribute("colFondo","" );
      ((Element)v.get(111)).setAttribute("ID","EstCab" );
      ((Element)v.get(111)).setAttribute("cod","1833" );
      ((Element)v.get(109)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */

      /* Empieza nodo:112 / Elemento padre: 109   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(112)).setAttribute("colFondo","" );
      ((Element)v.get(112)).setAttribute("ID","EstCab" );
      ((Element)v.get(112)).setAttribute("cod","1696" );
      ((Element)v.get(109)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */

      /* Empieza nodo:113 / Elemento padre: 109   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(113)).setAttribute("colFondo","" );
      ((Element)v.get(113)).setAttribute("ID","EstCab" );
      ((Element)v.get(113)).setAttribute("cod","1819" );
      ((Element)v.get(109)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */

      /* Empieza nodo:114 / Elemento padre: 109   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(114)).setAttribute("colFondo","" );
      ((Element)v.get(114)).setAttribute("ID","EstCab" );
      ((Element)v.get(114)).setAttribute("cod","2431" );
      ((Element)v.get(109)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */

      /* Empieza nodo:115 / Elemento padre: 109   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(115)).setAttribute("colFondo","" );
      ((Element)v.get(115)).setAttribute("ID","EstCab" );
      ((Element)v.get(115)).setAttribute("cod","1831" );
      ((Element)v.get(109)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */

      /* Empieza nodo:116 / Elemento padre: 109   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(116)).setAttribute("colFondo","" );
      ((Element)v.get(116)).setAttribute("ID","EstCab" );
      ((Element)v.get(116)).setAttribute("cod","1832" );
      ((Element)v.get(109)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */

      /* Empieza nodo:117 / Elemento padre: 109   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(117)).setAttribute("colFondo","" );
      ((Element)v.get(117)).setAttribute("ID","EstCab" );
      ((Element)v.get(117)).setAttribute("cod","1834" );
      ((Element)v.get(109)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */

      /* Empieza nodo:118 / Elemento padre: 109   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(118)).setAttribute("colFondo","" );
      ((Element)v.get(118)).setAttribute("ID","EstCab" );
      ((Element)v.get(118)).setAttribute("cod","2447" );
      ((Element)v.get(109)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */

      /* Empieza nodo:119 / Elemento padre: 109   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(119)).setAttribute("colFondo","" );
      ((Element)v.get(119)).setAttribute("ID","EstCab" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(109)).appendChild((Element)v.get(119));

      /* Elemento padre:119 / Elemento actual: 120   */
      v.add(doc.createTextNode("oid"));
      ((Element)v.get(119)).appendChild((Text)v.get(120));

      /* Termina nodo Texto:120   */
      /* Termina nodo:119   */
      /* Termina nodo:109   */

      /* Empieza nodo:121 / Elemento padre: 88   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(121)).setAttribute("alto","22" );
      ((Element)v.get(121)).setAttribute("accion","" );
      ((Element)v.get(121)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(121)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(121)).setAttribute("maxSel","1" );
      ((Element)v.get(121)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(121)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(121)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(121)).setAttribute("onLoad","" );
      ((Element)v.get(121)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(88)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(122)).setAttribute("tipo","texto" );
      ((Element)v.get(122)).setAttribute("ID","EstDat" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */

      /* Empieza nodo:123 / Elemento padre: 121   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(123)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(123)).setAttribute("nombre","txtPuntajeServicio" );
      ((Element)v.get(123)).setAttribute("size","9" );
      ((Element)v.get(123)).setAttribute("max","8" );
      ((Element)v.get(123)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(123)).setAttribute("ID","EstDat2" );
      ((Element)v.get(121)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */

      /* Empieza nodo:124 / Elemento padre: 121   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(124)).setAttribute("tipo","combo" );
      ((Element)v.get(124)).setAttribute("nombre","cbTipoPremio" );
      ((Element)v.get(124)).setAttribute("ID","EstDat" );
      ((Element)v.get(124)).setAttribute("IDOBJ","EstDatForm" );
      ((Element)v.get(121)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */

      /* Empieza nodo:126 / Elemento padre: 121   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(126)).setAttribute("tipo","checkbox" );
      ((Element)v.get(126)).setAttribute("nombre","ckNivelElegible" );
      ((Element)v.get(126)).setAttribute("ID","EstDat2" );
      ((Element)v.get(121)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */

      /* Empieza nodo:127 / Elemento padre: 121   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(127)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(127)).setAttribute("nombre","txtCantidadFijoPuntos" );
      ((Element)v.get(127)).setAttribute("size","4" );
      ((Element)v.get(127)).setAttribute("max","5" );
      ((Element)v.get(127)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(127)).setAttribute("ID","EstDa2" );
      ((Element)v.get(121)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */

      /* Empieza nodo:128 / Elemento padre: 121   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(128)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(128)).setAttribute("nombre","txtCantidadDesde" );
      ((Element)v.get(128)).setAttribute("size","4" );
      ((Element)v.get(128)).setAttribute("max","5" );
      ((Element)v.get(128)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(128)).setAttribute("ID","EstDat2" );
      ((Element)v.get(121)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */

      /* Empieza nodo:129 / Elemento padre: 121   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(129)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(129)).setAttribute("nombre","txtCantidadHasta" );
      ((Element)v.get(129)).setAttribute("size","4" );
      ((Element)v.get(129)).setAttribute("max","5" );
      ((Element)v.get(129)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(129)).setAttribute("ID","EstDat" );
      ((Element)v.get(121)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */

      /* Empieza nodo:130 / Elemento padre: 121   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(130)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(130)).setAttribute("nombre","txtPuntosProductosExigidos" );
      ((Element)v.get(130)).setAttribute("size","5" );
      ((Element)v.get(130)).setAttribute("max","4" );
      ((Element)v.get(130)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(130)).setAttribute("ID","EstDat2" );
      ((Element)v.get(121)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */

      /* Empieza nodo:131 / Elemento padre: 121   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(131)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(131)).setAttribute("nombre","txtNumAspirantes" );
      ((Element)v.get(131)).setAttribute("size","3" );
      ((Element)v.get(131)).setAttribute("max","3" );
      ((Element)v.get(131)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(131)).setAttribute("ID","EstDat" );
      ((Element)v.get(121)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */

      /* Empieza nodo:132 / Elemento padre: 121   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(132)).setAttribute("tipo","texto" );
      ((Element)v.get(132)).setAttribute("ID","EstDat" );
      ((Element)v.get(121)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:121   */

      /* Empieza nodo:133 / Elemento padre: 88   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(88)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */

      /* Empieza nodo:134 / Elemento padre: 88   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(134)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(134)).setAttribute("ancho","703" );
      ((Element)v.get(134)).setAttribute("sep","$" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(134)).setAttribute("x","26" );
      ((Element)v.get(134)).setAttribute("class","botonera" );
      ((Element)v.get(134)).setAttribute("y","306" );
      ((Element)v.get(134)).setAttribute("control","|" );
      ((Element)v.get(134)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(134)).setAttribute("rowset","" );
      ((Element)v.get(134)).setAttribute("cargainicial","N" );
      ((Element)v.get(88)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(135)).setAttribute("nombre","ret" );
      ((Element)v.get(135)).setAttribute("x","51" );
      ((Element)v.get(135)).setAttribute("y","310" );
      ((Element)v.get(135)).setAttribute("ID","botonContenido" );
      ((Element)v.get(135)).setAttribute("img","retroceder_on" );
      ((Element)v.get(135)).setAttribute("tipo","0" );
      ((Element)v.get(135)).setAttribute("estado","false" );
      ((Element)v.get(135)).setAttribute("alt","" );
      ((Element)v.get(135)).setAttribute("codigo","" );
      ((Element)v.get(135)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */

      /* Empieza nodo:136 / Elemento padre: 134   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(136)).setAttribute("nombre","ava" );
      ((Element)v.get(136)).setAttribute("x","66" );
      ((Element)v.get(136)).setAttribute("y","310" );
      ((Element)v.get(136)).setAttribute("ID","botonContenido" );
      ((Element)v.get(136)).setAttribute("img","avanzar_on" );
      ((Element)v.get(136)).setAttribute("tipo","0" );
      ((Element)v.get(136)).setAttribute("estado","false" );
      ((Element)v.get(136)).setAttribute("alt","" );
      ((Element)v.get(136)).setAttribute("codigo","" );
      ((Element)v.get(136)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(134)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:134   */
      /* Termina nodo:88   */

      /* Empieza nodo:137 / Elemento padre: 37   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(137)).setAttribute("nombre","primera" );
      ((Element)v.get(137)).setAttribute("x","34" );
      ((Element)v.get(137)).setAttribute("y","310" );
      ((Element)v.get(137)).setAttribute("ID","botonContenido" );
      ((Element)v.get(137)).setAttribute("img","primera_on" );
      ((Element)v.get(137)).setAttribute("tipo","-2" );
      ((Element)v.get(137)).setAttribute("estado","false" );
      ((Element)v.get(137)).setAttribute("alt","" );
      ((Element)v.get(137)).setAttribute("codigo","" );
      ((Element)v.get(137)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(37)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */

      /* Empieza nodo:138 / Elemento padre: 37   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(138)).setAttribute("nombre","separa" );
      ((Element)v.get(138)).setAttribute("x","73" );
      ((Element)v.get(138)).setAttribute("y","306" );
      ((Element)v.get(138)).setAttribute("ID","botonContenido" );
      ((Element)v.get(138)).setAttribute("img","separa_base" );
      ((Element)v.get(138)).setAttribute("tipo","0" );
      ((Element)v.get(138)).setAttribute("estado","false" );
      ((Element)v.get(138)).setAttribute("alt","" );
      ((Element)v.get(138)).setAttribute("codigo","" );
      ((Element)v.get(138)).setAttribute("accion","" );
      ((Element)v.get(37)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */

      /* Empieza nodo:139 / Elemento padre: 37   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(139)).setAttribute("nombre","btnDefinirPremio" );
      ((Element)v.get(139)).setAttribute("x","13" );
      ((Element)v.get(139)).setAttribute("y","307" );
      ((Element)v.get(139)).setAttribute("ID","botonContenido" );
      ((Element)v.get(139)).setAttribute("accion","accionDefinirPremio()" );
      ((Element)v.get(139)).setAttribute("tipo","html" );
      ((Element)v.get(139)).setAttribute("estado","false" );
      ((Element)v.get(139)).setAttribute("cod","2855" );
      ((Element)v.get(37)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */

      /* Empieza nodo:140 / Elemento padre: 37   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(140)).setAttribute("nombre","btnAceptar" );
      ((Element)v.get(140)).setAttribute("x","112" );
      ((Element)v.get(140)).setAttribute("y","307" );
      ((Element)v.get(140)).setAttribute("ID","botonContenido" );
      ((Element)v.get(140)).setAttribute("accion","accionAceptarNiveles()" );
      ((Element)v.get(140)).setAttribute("tipo","html" );
      ((Element)v.get(140)).setAttribute("estado","false" );
      ((Element)v.get(140)).setAttribute("cod","12" );
      ((Element)v.get(37)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */

      /* Empieza nodo:141 / Elemento padre: 37   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(141)).setAttribute("nombre","capa1" );
      ((Element)v.get(141)).setAttribute("alto","180" );
      ((Element)v.get(141)).setAttribute("ancho","100%" );
      ((Element)v.get(141)).setAttribute("colorf","" );
      ((Element)v.get(141)).setAttribute("borde","0" );
      ((Element)v.get(141)).setAttribute("imagenf","" );
      ((Element)v.get(141)).setAttribute("repeat","" );
      ((Element)v.get(141)).setAttribute("padding","" );
      ((Element)v.get(141)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(141)).setAttribute("contravsb","" );
      ((Element)v.get(141)).setAttribute("x","0" );
      ((Element)v.get(141)).setAttribute("y","341" );
      ((Element)v.get(141)).setAttribute("zindex","" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(37)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("table"));
      ((Element)v.get(142)).setAttribute("width","100%" );
      ((Element)v.get(142)).setAttribute("border","0" );
      ((Element)v.get(142)).setAttribute("cellspacing","0" );
      ((Element)v.get(142)).setAttribute("cellpadding","0" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("td"));
      ((Element)v.get(144)).setAttribute("width","12" );
      ((Element)v.get(144)).setAttribute("align","center" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(145)).setAttribute("src","b.gif" );
      ((Element)v.get(145)).setAttribute("width","12" );
      ((Element)v.get(145)).setAttribute("height","12" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:144   */

      /* Empieza nodo:146 / Elemento padre: 143   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).setAttribute("width","750" );
      ((Element)v.get(143)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(147)).setAttribute("src","b.gif" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:146   */

      /* Empieza nodo:148 / Elemento padre: 143   */
      v.add(doc.createElement("td"));
      ((Element)v.get(148)).setAttribute("width","12" );
      ((Element)v.get(143)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(149)).setAttribute("src","b.gif" );
      ((Element)v.get(149)).setAttribute("width","12" );
      ((Element)v.get(149)).setAttribute("height","1" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */
      /* Termina nodo:143   */

      /* Empieza nodo:150 / Elemento padre: 142   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(142)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(152)).setAttribute("src","b.gif" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:151   */

      /* Empieza nodo:153 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(153)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(155)).setAttribute("class","legend" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(156)).setAttribute("nombre","lblDatosPremiosPunto" );
      ((Element)v.get(156)).setAttribute("alto","13" );
      ((Element)v.get(156)).setAttribute("filas","1" );
      ((Element)v.get(156)).setAttribute("valor","" );
      ((Element)v.get(156)).setAttribute("id","legend" );
      ((Element)v.get(156)).setAttribute("cod","00347" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */

      /* Empieza nodo:157 / Elemento padre: 154   */
      v.add(doc.createElement("table"));
      ((Element)v.get(157)).setAttribute("width","100%" );
      ((Element)v.get(157)).setAttribute("border","0" );
      ((Element)v.get(157)).setAttribute("align","center" );
      ((Element)v.get(157)).setAttribute("cellspacing","0" );
      ((Element)v.get(157)).setAttribute("cellpadding","0" );
      ((Element)v.get(154)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(157)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(158)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("table"));
      ((Element)v.get(160)).setAttribute("width","728" );
      ((Element)v.get(160)).setAttribute("border","0" );
      ((Element)v.get(160)).setAttribute("align","left" );
      ((Element)v.get(160)).setAttribute("cellspacing","0" );
      ((Element)v.get(160)).setAttribute("cellpadding","0" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(160)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(162)).setAttribute("colspan","4" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(163)).setAttribute("src","b.gif" );
      ((Element)v.get(163)).setAttribute("width","8" );
      ((Element)v.get(163)).setAttribute("height","8" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */
      /* Termina nodo:161   */

      /* Empieza nodo:164 / Elemento padre: 160   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(160)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("td"));
      ((Element)v.get(164)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(166)).setAttribute("src","b.gif" );
      ((Element)v.get(166)).setAttribute("width","8" );
      ((Element)v.get(166)).setAttribute("height","8" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:165   */

      /* Empieza nodo:167 / Elemento padre: 164   */
      v.add(doc.createElement("td"));
      ((Element)v.get(164)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(168)).setAttribute("nombre","lblNumPremio1" );
      ((Element)v.get(168)).setAttribute("alto","13" );
      ((Element)v.get(168)).setAttribute("filas","1" );
      ((Element)v.get(168)).setAttribute("valor","" );
      ((Element)v.get(168)).setAttribute("id","datosTitle" );
      ((Element)v.get(168)).setAttribute("cod","1691" );
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
      ((Element)v.get(164)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(172)).setAttribute("nombre","lblConcursoDestino" );
      ((Element)v.get(172)).setAttribute("alto","13" );
      ((Element)v.get(172)).setAttribute("filas","1" );
      ((Element)v.get(172)).setAttribute("valor","" );
      ((Element)v.get(172)).setAttribute("id","datosTitle" );
      ((Element)v.get(172)).setAttribute("cod","1835" );
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
      ((Element)v.get(164)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(176)).setAttribute("nombre","lblTipoPremiosPunto1" );
      ((Element)v.get(176)).setAttribute("alto","13" );
      ((Element)v.get(176)).setAttribute("filas","1" );
      ((Element)v.get(176)).setAttribute("valor","" );
      ((Element)v.get(176)).setAttribute("id","datosTitle" );
      ((Element)v.get(176)).setAttribute("cod","1836" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:175   */

      /* Empieza nodo:177 / Elemento padre: 164   */
      v.add(doc.createElement("td"));
      ((Element)v.get(164)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(178)).setAttribute("src","b.gif" );
      ((Element)v.get(178)).setAttribute("width","25" );
      ((Element)v.get(178)).setAttribute("height","8" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:177   */

      /* Empieza nodo:179 / Elemento padre: 164   */
      v.add(doc.createElement("td"));
      ((Element)v.get(164)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(180)).setAttribute("nombre","lblCantidad2" );
      ((Element)v.get(180)).setAttribute("alto","13" );
      ((Element)v.get(180)).setAttribute("filas","1" );
      ((Element)v.get(180)).setAttribute("valor","" );
      ((Element)v.get(180)).setAttribute("id","datosTitle" );
      ((Element)v.get(180)).setAttribute("cod","1172" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */
      /* Termina nodo:179   */

      /* Empieza nodo:181 / Elemento padre: 164   */
      v.add(doc.createElement("td"));
      ((Element)v.get(164)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(182)).setAttribute("src","b.gif" );
      ((Element)v.get(182)).setAttribute("width","25" );
      ((Element)v.get(182)).setAttribute("height","8" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:181   */

      /* Empieza nodo:183 / Elemento padre: 164   */
      v.add(doc.createElement("td"));
      ((Element)v.get(164)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(184)).setAttribute("nombre","lblPorcentaje2" );
      ((Element)v.get(184)).setAttribute("alto","13" );
      ((Element)v.get(184)).setAttribute("filas","1" );
      ((Element)v.get(184)).setAttribute("valor","" );
      ((Element)v.get(184)).setAttribute("id","datosTitle" );
      ((Element)v.get(184)).setAttribute("cod","790" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */

      /* Empieza nodo:185 / Elemento padre: 164   */
      v.add(doc.createElement("td"));
      ((Element)v.get(185)).setAttribute("width","100%" );
      ((Element)v.get(164)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(186)).setAttribute("src","b.gif" );
      ((Element)v.get(186)).setAttribute("width","8" );
      ((Element)v.get(186)).setAttribute("height","8" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */
      /* Termina nodo:164   */

      /* Empieza nodo:187 / Elemento padre: 160   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(160)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("td"));
   }

   private void getXML990(Document doc) {
      ((Element)v.get(187)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(189)).setAttribute("src","b.gif" );
      ((Element)v.get(189)).setAttribute("width","8" );
      ((Element)v.get(189)).setAttribute("height","8" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */
      /* Termina nodo:188   */

      /* Empieza nodo:190 / Elemento padre: 187   */
      v.add(doc.createElement("td"));
      ((Element)v.get(190)).setAttribute("valign","bottom" );
      ((Element)v.get(187)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(191)).setAttribute("nombre","lbNumPremio1" );
      ((Element)v.get(191)).setAttribute("alto","13" );
      ((Element)v.get(191)).setAttribute("filas","1" );
      ((Element)v.get(191)).setAttribute("valor","" );
      ((Element)v.get(191)).setAttribute("id","datosCampos" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */
      /* Termina nodo:190   */

      /* Empieza nodo:192 / Elemento padre: 187   */
      v.add(doc.createElement("td"));
      ((Element)v.get(187)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(193)).setAttribute("src","b.gif" );
      ((Element)v.get(193)).setAttribute("width","25" );
      ((Element)v.get(193)).setAttribute("height","8" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:192   */

      /* Empieza nodo:194 / Elemento padre: 187   */
      v.add(doc.createElement("td"));
      ((Element)v.get(194)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(187)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(195)).setAttribute("nombre","cbConcursoDestino" );
      ((Element)v.get(195)).setAttribute("id","datosCampos" );
      ((Element)v.get(195)).setAttribute("size","1" );
      ((Element)v.get(195)).setAttribute("multiple","N" );
      ((Element)v.get(195)).setAttribute("req","S" );
      ((Element)v.get(195)).setAttribute("valorinicial","" );
      ((Element)v.get(195)).setAttribute("textoinicial","" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:195   */
      /* Termina nodo:194   */

      /* Empieza nodo:197 / Elemento padre: 187   */
      v.add(doc.createElement("td"));
      ((Element)v.get(187)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(198)).setAttribute("src","b.gif" );
      ((Element)v.get(198)).setAttribute("width","25" );
      ((Element)v.get(198)).setAttribute("height","8" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:197   */

      /* Empieza nodo:199 / Elemento padre: 187   */
      v.add(doc.createElement("td"));
      ((Element)v.get(199)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(187)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(200)).setAttribute("nombre","cbTipoPremioPuntos1" );
      ((Element)v.get(200)).setAttribute("id","datosCampos" );
      ((Element)v.get(200)).setAttribute("size","1" );
      ((Element)v.get(200)).setAttribute("onchange","onChangeTipoPremiosPuntos();" );
      ((Element)v.get(200)).setAttribute("multiple","N" );
      ((Element)v.get(200)).setAttribute("req","S" );
      ((Element)v.get(200)).setAttribute("valorinicial","" );
      ((Element)v.get(200)).setAttribute("textoinicial","" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(200)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:200   */
      /* Termina nodo:199   */

      /* Empieza nodo:202 / Elemento padre: 187   */
      v.add(doc.createElement("td"));
      ((Element)v.get(187)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(203)).setAttribute("src","b.gif" );
      ((Element)v.get(203)).setAttribute("width","25" );
      ((Element)v.get(203)).setAttribute("height","8" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:202   */

      /* Empieza nodo:204 / Elemento padre: 187   */
      v.add(doc.createElement("td"));
      ((Element)v.get(204)).setAttribute("valign","bottom" );
      ((Element)v.get(187)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(205)).setAttribute("nombre","txtCantidad1" );
      ((Element)v.get(205)).setAttribute("id","datosCampos" );
      ((Element)v.get(205)).setAttribute("max","7" );
      ((Element)v.get(205)).setAttribute("tipo","" );
      ((Element)v.get(205)).setAttribute("onchange","" );
      ((Element)v.get(205)).setAttribute("req","N" );
      ((Element)v.get(205)).setAttribute("size","8" );
      ((Element)v.get(205)).setAttribute("valor","" );
      ((Element)v.get(205)).setAttribute("validacion","" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */
      /* Termina nodo:204   */

      /* Empieza nodo:206 / Elemento padre: 187   */
      v.add(doc.createElement("td"));
      ((Element)v.get(187)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(207)).setAttribute("src","b.gif" );
      ((Element)v.get(207)).setAttribute("width","25" );
      ((Element)v.get(207)).setAttribute("height","8" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */
      /* Termina nodo:206   */

      /* Empieza nodo:208 / Elemento padre: 187   */
      v.add(doc.createElement("td"));
      ((Element)v.get(208)).setAttribute("valign","bottom" );
      ((Element)v.get(187)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
   }

   private void getXML1080(Document doc) {
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(209)).setAttribute("nombre","txtPorcentaje1" );
      ((Element)v.get(209)).setAttribute("id","datosCampos" );
      ((Element)v.get(209)).setAttribute("max","7" );
      ((Element)v.get(209)).setAttribute("tipo","" );
      ((Element)v.get(209)).setAttribute("onchange","" );
      ((Element)v.get(209)).setAttribute("req","N" );
      ((Element)v.get(209)).setAttribute("size","8" );
      ((Element)v.get(209)).setAttribute("valor","" );
      ((Element)v.get(209)).setAttribute("validacion","" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */

      /* Empieza nodo:210 / Elemento padre: 187   */
      v.add(doc.createElement("td"));
      ((Element)v.get(210)).setAttribute("width","100%" );
      ((Element)v.get(187)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(211)).setAttribute("src","b.gif" );
      ((Element)v.get(211)).setAttribute("width","8" );
      ((Element)v.get(211)).setAttribute("height","8" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */
      /* Termina nodo:210   */
      /* Termina nodo:187   */

      /* Empieza nodo:212 / Elemento padre: 160   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(160)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("td"));
      ((Element)v.get(213)).setAttribute("colspan","4" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(214)).setAttribute("src","b.gif" );
      ((Element)v.get(214)).setAttribute("width","8" );
      ((Element)v.get(214)).setAttribute("height","8" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:213   */
      /* Termina nodo:212   */
      /* Termina nodo:160   */
      /* Termina nodo:159   */
      /* Termina nodo:158   */
      /* Termina nodo:157   */
      /* Termina nodo:154   */
      /* Termina nodo:153   */

      /* Empieza nodo:215 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(216)).setAttribute("src","b.gif" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */
      /* Termina nodo:215   */
      /* Termina nodo:150   */

      /* Empieza nodo:217 / Elemento padre: 142   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(142)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("td"));
      ((Element)v.get(217)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(219)).setAttribute("src","b.gif" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */

      /* Empieza nodo:220 / Elemento padre: 217   */
      v.add(doc.createElement("td"));
      ((Element)v.get(217)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(220)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("table"));
      ((Element)v.get(222)).setAttribute("width","100%" );
      ((Element)v.get(222)).setAttribute("border","0" );
      ((Element)v.get(222)).setAttribute("align","center" );
      ((Element)v.get(222)).setAttribute("cellspacing","0" );
      ((Element)v.get(222)).setAttribute("cellpadding","0" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(222)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("td"));
      ((Element)v.get(224)).setAttribute("class","botonera" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(225)).setAttribute("nombre","btnAceptar1" );
      ((Element)v.get(225)).setAttribute("ID","botonContenido" );
      ((Element)v.get(225)).setAttribute("tipo","html" );
      ((Element)v.get(225)).setAttribute("accion","accionAceptar(get('formulario.OID_TIPO_PREMIO_PUNTOS'));" );
      ((Element)v.get(225)).setAttribute("estado","false" );
      ((Element)v.get(225)).setAttribute("cod","12" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */
      /* Termina nodo:224   */
      /* Termina nodo:223   */
      /* Termina nodo:222   */
      /* Termina nodo:221   */
      /* Termina nodo:220   */

      /* Empieza nodo:226 / Elemento padre: 217   */
      v.add(doc.createElement("td"));
      ((Element)v.get(217)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(227)).setAttribute("src","b.gif" );
      ((Element)v.get(227)).setAttribute("width","8" );
      ((Element)v.get(227)).setAttribute("height","12" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */
      /* Termina nodo:226   */
      /* Termina nodo:217   */

      /* Empieza nodo:228 / Elemento padre: 142   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(142)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("td"));
      ((Element)v.get(229)).setAttribute("width","12" );
      ((Element)v.get(229)).setAttribute("align","center" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(230)).setAttribute("src","b.gif" );
      ((Element)v.get(230)).setAttribute("width","12" );
      ((Element)v.get(230)).setAttribute("height","12" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */
      /* Termina nodo:229   */

      /* Empieza nodo:231 / Elemento padre: 228   */
      v.add(doc.createElement("td"));
      ((Element)v.get(231)).setAttribute("width","756" );
      ((Element)v.get(228)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(232)).setAttribute("src","b.gif" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */
      /* Termina nodo:231   */

      /* Empieza nodo:233 / Elemento padre: 228   */
      v.add(doc.createElement("td"));
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(233)).setAttribute("width","12" );
      ((Element)v.get(228)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(234)).setAttribute("src","b.gif" );
      ((Element)v.get(234)).setAttribute("width","12" );
      ((Element)v.get(234)).setAttribute("height","1" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */
      /* Termina nodo:233   */
      /* Termina nodo:228   */
      /* Termina nodo:142   */
      /* Termina nodo:141   */

      /* Empieza nodo:235 / Elemento padre: 37   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(235)).setAttribute("nombre","capa2" );
      ((Element)v.get(235)).setAttribute("alto","180" );
      ((Element)v.get(235)).setAttribute("ancho","100%" );
      ((Element)v.get(235)).setAttribute("colorf","" );
      ((Element)v.get(235)).setAttribute("borde","0" );
      ((Element)v.get(235)).setAttribute("imagenf","" );
      ((Element)v.get(235)).setAttribute("repeat","" );
      ((Element)v.get(235)).setAttribute("padding","" );
      ((Element)v.get(235)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(235)).setAttribute("contravsb","" );
      ((Element)v.get(235)).setAttribute("x","0" );
      ((Element)v.get(235)).setAttribute("y","341" );
      ((Element)v.get(235)).setAttribute("zindex","" );
      ((Element)v.get(37)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("table"));
      ((Element)v.get(236)).setAttribute("width","100%" );
      ((Element)v.get(236)).setAttribute("border","0" );
      ((Element)v.get(236)).setAttribute("cellspacing","0" );
      ((Element)v.get(236)).setAttribute("cellpadding","0" );
      ((Element)v.get(235)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(236)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("td"));
      ((Element)v.get(238)).setAttribute("width","12" );
      ((Element)v.get(238)).setAttribute("align","center" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(239)).setAttribute("src","b.gif" );
      ((Element)v.get(239)).setAttribute("width","12" );
      ((Element)v.get(239)).setAttribute("height","12" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */
      /* Termina nodo:238   */

      /* Empieza nodo:240 / Elemento padre: 237   */
      v.add(doc.createElement("td"));
      ((Element)v.get(240)).setAttribute("width","750" );
      ((Element)v.get(237)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(241)).setAttribute("src","b.gif" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */
      /* Termina nodo:240   */

      /* Empieza nodo:242 / Elemento padre: 237   */
      v.add(doc.createElement("td"));
      ((Element)v.get(242)).setAttribute("width","12" );
      ((Element)v.get(237)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(243)).setAttribute("src","b.gif" );
      ((Element)v.get(243)).setAttribute("width","12" );
      ((Element)v.get(243)).setAttribute("height","1" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */
      /* Termina nodo:242   */
      /* Termina nodo:237   */

      /* Empieza nodo:244 / Elemento padre: 236   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(236)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("td"));
      ((Element)v.get(244)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(246)).setAttribute("src","b.gif" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */
      /* Termina nodo:245   */

      /* Empieza nodo:247 / Elemento padre: 244   */
      v.add(doc.createElement("td"));
      ((Element)v.get(244)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(247)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(249)).setAttribute("class","legend" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(250)).setAttribute("nombre","lblDatosPremiosMonetario" );
      ((Element)v.get(250)).setAttribute("alto","13" );
      ((Element)v.get(250)).setAttribute("filas","1" );
      ((Element)v.get(250)).setAttribute("valor","" );
      ((Element)v.get(250)).setAttribute("id","legend" );
      ((Element)v.get(250)).setAttribute("cod","00348" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */
      /* Termina nodo:249   */

      /* Empieza nodo:251 / Elemento padre: 248   */
      v.add(doc.createElement("table"));
      ((Element)v.get(251)).setAttribute("width","100%" );
      ((Element)v.get(251)).setAttribute("border","0" );
      ((Element)v.get(251)).setAttribute("align","center" );
      ((Element)v.get(251)).setAttribute("cellspacing","0" );
      ((Element)v.get(251)).setAttribute("cellpadding","0" );
      ((Element)v.get(248)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(251)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("td"));
      ((Element)v.get(252)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("table"));
      ((Element)v.get(254)).setAttribute("width","728" );
      ((Element)v.get(254)).setAttribute("border","0" );
      ((Element)v.get(254)).setAttribute("align","left" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(254)).setAttribute("cellspacing","0" );
      ((Element)v.get(254)).setAttribute("cellpadding","0" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(254)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("td"));
      ((Element)v.get(256)).setAttribute("colspan","4" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(257)).setAttribute("src","b.gif" );
      ((Element)v.get(257)).setAttribute("width","8" );
      ((Element)v.get(257)).setAttribute("height","8" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */
      /* Termina nodo:256   */
      /* Termina nodo:255   */

      /* Empieza nodo:258 / Elemento padre: 254   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(254)).appendChild((Element)v.get(258));

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
      ((Element)v.get(258)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(262)).setAttribute("nombre","lblNumPremio2" );
      ((Element)v.get(262)).setAttribute("alto","13" );
      ((Element)v.get(262)).setAttribute("filas","1" );
      ((Element)v.get(262)).setAttribute("valor","" );
      ((Element)v.get(262)).setAttribute("id","datosTitle" );
      ((Element)v.get(262)).setAttribute("cod","1691" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */
      /* Termina nodo:261   */

      /* Empieza nodo:263 / Elemento padre: 258   */
      v.add(doc.createElement("td"));
      ((Element)v.get(258)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(264)).setAttribute("src","b.gif" );
      ((Element)v.get(264)).setAttribute("width","25" );
      ((Element)v.get(264)).setAttribute("height","8" );
      ((Element)v.get(263)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */
      /* Termina nodo:263   */

      /* Empieza nodo:265 / Elemento padre: 258   */
      v.add(doc.createElement("td"));
      ((Element)v.get(258)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(266)).setAttribute("nombre","lblTipoPremiosMonetario2" );
      ((Element)v.get(266)).setAttribute("alto","13" );
      ((Element)v.get(266)).setAttribute("filas","1" );
      ((Element)v.get(266)).setAttribute("valor","" );
      ((Element)v.get(266)).setAttribute("id","datosTitle" );
      ((Element)v.get(266)).setAttribute("cod","1837" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */
      /* Termina nodo:265   */

      /* Empieza nodo:267 / Elemento padre: 258   */
      v.add(doc.createElement("td"));
      ((Element)v.get(258)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(268)).setAttribute("src","b.gif" );
      ((Element)v.get(268)).setAttribute("width","25" );
      ((Element)v.get(268)).setAttribute("height","8" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */
      /* Termina nodo:267   */

      /* Empieza nodo:269 / Elemento padre: 258   */
      v.add(doc.createElement("td"));
      ((Element)v.get(258)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(270)).setAttribute("nombre","lblCantidad2" );
      ((Element)v.get(270)).setAttribute("alto","13" );
      ((Element)v.get(270)).setAttribute("filas","1" );
      ((Element)v.get(270)).setAttribute("valor","" );
      ((Element)v.get(270)).setAttribute("id","datosTitle" );
      ((Element)v.get(270)).setAttribute("cod","1172" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */
      /* Termina nodo:269   */

      /* Empieza nodo:271 / Elemento padre: 258   */
      v.add(doc.createElement("td"));
      ((Element)v.get(258)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(272)).setAttribute("src","b.gif" );
      ((Element)v.get(272)).setAttribute("width","25" );
      ((Element)v.get(272)).setAttribute("height","8" );
      ((Element)v.get(271)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */
      /* Termina nodo:271   */

      /* Empieza nodo:273 / Elemento padre: 258   */
      v.add(doc.createElement("td"));
      ((Element)v.get(258)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(274)).setAttribute("nombre","lblPorcentaje2" );
      ((Element)v.get(274)).setAttribute("alto","13" );
      ((Element)v.get(274)).setAttribute("filas","1" );
      ((Element)v.get(274)).setAttribute("valor","" );
      ((Element)v.get(274)).setAttribute("id","datosTitle" );
      ((Element)v.get(274)).setAttribute("cod","790" );
      ((Element)v.get(273)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */
      /* Termina nodo:273   */

      /* Empieza nodo:275 / Elemento padre: 258   */
      v.add(doc.createElement("td"));
      ((Element)v.get(258)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(276)).setAttribute("src","b.gif" );
      ((Element)v.get(276)).setAttribute("width","25" );
      ((Element)v.get(276)).setAttribute("height","8" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */
      /* Termina nodo:275   */

      /* Empieza nodo:277 / Elemento padre: 258   */
   }

   private void getXML1350(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(258)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(278)).setAttribute("nombre","lblMoneda" );
      ((Element)v.get(278)).setAttribute("alto","13" );
      ((Element)v.get(278)).setAttribute("filas","1" );
      ((Element)v.get(278)).setAttribute("valor","" );
      ((Element)v.get(278)).setAttribute("id","datosTitle" );
      ((Element)v.get(278)).setAttribute("cod","1216" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */
      /* Termina nodo:277   */

      /* Empieza nodo:279 / Elemento padre: 258   */
      v.add(doc.createElement("td"));
      ((Element)v.get(279)).setAttribute("width","100%" );
      ((Element)v.get(258)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(280)).setAttribute("src","b.gif" );
      ((Element)v.get(280)).setAttribute("width","8" );
      ((Element)v.get(280)).setAttribute("height","8" );
      ((Element)v.get(279)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */
      /* Termina nodo:279   */
      /* Termina nodo:258   */

      /* Empieza nodo:281 / Elemento padre: 254   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(254)).appendChild((Element)v.get(281));

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
      ((Element)v.get(284)).setAttribute("valign","bottom" );
      ((Element)v.get(281)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(285)).setAttribute("nombre","lbNumPremio2" );
      ((Element)v.get(285)).setAttribute("alto","13" );
      ((Element)v.get(285)).setAttribute("filas","1" );
      ((Element)v.get(285)).setAttribute("valor","" );
      ((Element)v.get(285)).setAttribute("id","datosCampos" );
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
      ((Element)v.get(288)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(281)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(289)).setAttribute("nombre","cbTipoPremioMonetario2" );
      ((Element)v.get(289)).setAttribute("id","datosCampos" );
      ((Element)v.get(289)).setAttribute("size","1" );
      ((Element)v.get(289)).setAttribute("onchange","onChangeTipoPremiosMonetarios();" );
      ((Element)v.get(289)).setAttribute("multiple","N" );
      ((Element)v.get(289)).setAttribute("req","S" );
      ((Element)v.get(289)).setAttribute("valorinicial","" );
      ((Element)v.get(289)).setAttribute("textoinicial","" );
      ((Element)v.get(288)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(289)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */
      /* Termina nodo:289   */
      /* Termina nodo:288   */

      /* Empieza nodo:291 / Elemento padre: 281   */
      v.add(doc.createElement("td"));
      ((Element)v.get(281)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(292)).setAttribute("src","b.gif" );
      ((Element)v.get(292)).setAttribute("width","25" );
      ((Element)v.get(292)).setAttribute("height","8" );
      ((Element)v.get(291)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */
      /* Termina nodo:291   */

      /* Empieza nodo:293 / Elemento padre: 281   */
      v.add(doc.createElement("td"));
      ((Element)v.get(293)).setAttribute("valign","bottom" );
      ((Element)v.get(281)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(294)).setAttribute("nombre","txtCantidad2" );
      ((Element)v.get(294)).setAttribute("id","datosCampos" );
      ((Element)v.get(294)).setAttribute("max","6" );
      ((Element)v.get(294)).setAttribute("tipo","" );
      ((Element)v.get(294)).setAttribute("onchange","" );
      ((Element)v.get(294)).setAttribute("req","N" );
      ((Element)v.get(294)).setAttribute("size","7" );
      ((Element)v.get(294)).setAttribute("valor","" );
      ((Element)v.get(294)).setAttribute("validacion","" );
      ((Element)v.get(293)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */
      /* Termina nodo:293   */

      /* Empieza nodo:295 / Elemento padre: 281   */
      v.add(doc.createElement("td"));
      ((Element)v.get(281)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(296)).setAttribute("src","b.gif" );
      ((Element)v.get(296)).setAttribute("width","25" );
      ((Element)v.get(296)).setAttribute("height","8" );
      ((Element)v.get(295)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */
      /* Termina nodo:295   */

      /* Empieza nodo:297 / Elemento padre: 281   */
      v.add(doc.createElement("td"));
      ((Element)v.get(297)).setAttribute("valign","bottom" );
      ((Element)v.get(281)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
   }

   private void getXML1440(Document doc) {
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(298)).setAttribute("nombre","txtPorcentaje2" );
      ((Element)v.get(298)).setAttribute("id","datosCampos" );
      ((Element)v.get(298)).setAttribute("max","6" );
      ((Element)v.get(298)).setAttribute("tipo","" );
      ((Element)v.get(298)).setAttribute("onchange","" );
      ((Element)v.get(298)).setAttribute("req","N" );
      ((Element)v.get(298)).setAttribute("size","6" );
      ((Element)v.get(298)).setAttribute("valor","" );
      ((Element)v.get(298)).setAttribute("validacion","" );
      ((Element)v.get(297)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */
      /* Termina nodo:297   */

      /* Empieza nodo:299 / Elemento padre: 281   */
      v.add(doc.createElement("td"));
      ((Element)v.get(281)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(300)).setAttribute("src","b.gif" );
      ((Element)v.get(300)).setAttribute("width","25" );
      ((Element)v.get(300)).setAttribute("height","8" );
      ((Element)v.get(299)).appendChild((Element)v.get(300));
      /* Termina nodo:300   */
      /* Termina nodo:299   */

      /* Empieza nodo:301 / Elemento padre: 281   */
      v.add(doc.createElement("td"));
      ((Element)v.get(301)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(281)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(302)).setAttribute("nombre","cbMoneda" );
      ((Element)v.get(302)).setAttribute("id","datosCampos" );
      ((Element)v.get(302)).setAttribute("size","1" );
      ((Element)v.get(302)).setAttribute("multiple","N" );
      ((Element)v.get(302)).setAttribute("req","S" );
      ((Element)v.get(302)).setAttribute("valorinicial","" );
      ((Element)v.get(302)).setAttribute("textoinicial","" );
      ((Element)v.get(301)).appendChild((Element)v.get(302));

      /* Empieza nodo:303 / Elemento padre: 302   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(302)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */
      /* Termina nodo:302   */
      /* Termina nodo:301   */

      /* Empieza nodo:304 / Elemento padre: 281   */
      v.add(doc.createElement("td"));
      ((Element)v.get(304)).setAttribute("width","100%" );
      ((Element)v.get(281)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(305)).setAttribute("src","b.gif" );
      ((Element)v.get(305)).setAttribute("width","8" );
      ((Element)v.get(305)).setAttribute("height","8" );
      ((Element)v.get(304)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */
      /* Termina nodo:304   */
      /* Termina nodo:281   */

      /* Empieza nodo:306 / Elemento padre: 254   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(254)).appendChild((Element)v.get(306));

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
      /* Termina nodo:254   */
      /* Termina nodo:253   */
      /* Termina nodo:252   */

      /* Empieza nodo:309 / Elemento padre: 251   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(251)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("td"));
      ((Element)v.get(309)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("table"));
      ((Element)v.get(311)).setAttribute("width","728" );
      ((Element)v.get(311)).setAttribute("border","0" );
      ((Element)v.get(311)).setAttribute("align","left" );
      ((Element)v.get(311)).setAttribute("cellspacing","0" );
      ((Element)v.get(311)).setAttribute("cellpadding","0" );
      ((Element)v.get(310)).appendChild((Element)v.get(311));

      /* Empieza nodo:312 / Elemento padre: 311   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(311)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("td"));
      ((Element)v.get(312)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(314)).setAttribute("src","b.gif" );
      ((Element)v.get(314)).setAttribute("width","8" );
      ((Element)v.get(314)).setAttribute("height","8" );
      ((Element)v.get(313)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */
      /* Termina nodo:313   */

      /* Empieza nodo:315 / Elemento padre: 312   */
      v.add(doc.createElement("td"));
      ((Element)v.get(312)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(316)).setAttribute("nombre","lblFormaPago" );
      ((Element)v.get(316)).setAttribute("alto","13" );
      ((Element)v.get(316)).setAttribute("filas","1" );
      ((Element)v.get(316)).setAttribute("valor","" );
      ((Element)v.get(316)).setAttribute("id","datosTitle" );
      ((Element)v.get(316)).setAttribute("cod","541" );
      ((Element)v.get(315)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */
      /* Termina nodo:315   */

      /* Empieza nodo:317 / Elemento padre: 312   */
      v.add(doc.createElement("td"));
      ((Element)v.get(317)).setAttribute("width","100%" );
      ((Element)v.get(312)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(318)).setAttribute("src","b.gif" );
      ((Element)v.get(318)).setAttribute("width","8" );
      ((Element)v.get(318)).setAttribute("height","8" );
      ((Element)v.get(317)).appendChild((Element)v.get(318));
      /* Termina nodo:318   */
      /* Termina nodo:317   */
      /* Termina nodo:312   */

      /* Empieza nodo:319 / Elemento padre: 311   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(311)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
   }

   private void getXML1530(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(319)).appendChild((Element)v.get(320));

      /* Empieza nodo:321 / Elemento padre: 320   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(321)).setAttribute("src","b.gif" );
      ((Element)v.get(321)).setAttribute("width","8" );
      ((Element)v.get(321)).setAttribute("height","8" );
      ((Element)v.get(320)).appendChild((Element)v.get(321));
      /* Termina nodo:321   */
      /* Termina nodo:320   */

      /* Empieza nodo:322 / Elemento padre: 319   */
      v.add(doc.createElement("td"));
      ((Element)v.get(322)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(319)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(323)).setAttribute("nombre","cbFormaPago" );
      ((Element)v.get(323)).setAttribute("id","datosCampos" );
      ((Element)v.get(323)).setAttribute("size","1" );
      ((Element)v.get(323)).setAttribute("multiple","N" );
      ((Element)v.get(323)).setAttribute("req","S" );
      ((Element)v.get(323)).setAttribute("valorinicial","" );
      ((Element)v.get(323)).setAttribute("textoinicial","" );
      ((Element)v.get(322)).appendChild((Element)v.get(323));

      /* Empieza nodo:324 / Elemento padre: 323   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(323)).appendChild((Element)v.get(324));
      /* Termina nodo:324   */
      /* Termina nodo:323   */
      /* Termina nodo:322   */

      /* Empieza nodo:325 / Elemento padre: 319   */
      v.add(doc.createElement("td"));
      ((Element)v.get(325)).setAttribute("width","100%" );
      ((Element)v.get(319)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(326)).setAttribute("src","b.gif" );
      ((Element)v.get(326)).setAttribute("width","8" );
      ((Element)v.get(326)).setAttribute("height","8" );
      ((Element)v.get(325)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */
      /* Termina nodo:325   */
      /* Termina nodo:319   */

      /* Empieza nodo:327 / Elemento padre: 311   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(311)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("td"));
      ((Element)v.get(328)).setAttribute("colspan","4" );
      ((Element)v.get(327)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(329)).setAttribute("src","b.gif" );
      ((Element)v.get(329)).setAttribute("width","8" );
      ((Element)v.get(329)).setAttribute("height","8" );
      ((Element)v.get(328)).appendChild((Element)v.get(329));
      /* Termina nodo:329   */
      /* Termina nodo:328   */
      /* Termina nodo:327   */
      /* Termina nodo:311   */
      /* Termina nodo:310   */
      /* Termina nodo:309   */
      /* Termina nodo:251   */
      /* Termina nodo:248   */
      /* Termina nodo:247   */

      /* Empieza nodo:330 / Elemento padre: 244   */
      v.add(doc.createElement("td"));
      ((Element)v.get(244)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(331)).setAttribute("src","b.gif" );
      ((Element)v.get(330)).appendChild((Element)v.get(331));
      /* Termina nodo:331   */
      /* Termina nodo:330   */
      /* Termina nodo:244   */

      /* Empieza nodo:332 / Elemento padre: 236   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(236)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("td"));
      ((Element)v.get(333)).setAttribute("width","12" );
      ((Element)v.get(333)).setAttribute("align","center" );
      ((Element)v.get(332)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(334)).setAttribute("src","b.gif" );
      ((Element)v.get(334)).setAttribute("width","12" );
      ((Element)v.get(334)).setAttribute("height","12" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */
      /* Termina nodo:333   */

      /* Empieza nodo:335 / Elemento padre: 332   */
      v.add(doc.createElement("td"));
      ((Element)v.get(335)).setAttribute("width","756" );
      ((Element)v.get(332)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(336)).setAttribute("src","b.gif" );
      ((Element)v.get(335)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */
      /* Termina nodo:335   */

      /* Empieza nodo:337 / Elemento padre: 332   */
      v.add(doc.createElement("td"));
      ((Element)v.get(337)).setAttribute("width","12" );
      ((Element)v.get(332)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(338)).setAttribute("src","b.gif" );
      ((Element)v.get(338)).setAttribute("width","12" );
      ((Element)v.get(338)).setAttribute("height","1" );
      ((Element)v.get(337)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */
      /* Termina nodo:337   */
      /* Termina nodo:332   */
      /* Termina nodo:236   */
      /* Termina nodo:235   */

      /* Empieza nodo:339 / Elemento padre: 37   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(339)).setAttribute("nombre","capaBoton" );
      ((Element)v.get(339)).setAttribute("x","0" );
      ((Element)v.get(339)).setAttribute("y","447" );
      ((Element)v.get(339)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(37)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("table"));
      ((Element)v.get(340)).setAttribute("width","100%" );
      ((Element)v.get(340)).setAttribute("border","0" );
      ((Element)v.get(340)).setAttribute("cellspacing","0" );
      ((Element)v.get(340)).setAttribute("cellpadding","0" );
      ((Element)v.get(339)).appendChild((Element)v.get(340));

      /* Empieza nodo:341 / Elemento padre: 340   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(340)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("td"));
      ((Element)v.get(342)).setAttribute("width","12" );
      ((Element)v.get(342)).setAttribute("align","center" );
      ((Element)v.get(341)).appendChild((Element)v.get(342));

      /* Empieza nodo:343 / Elemento padre: 342   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(343)).setAttribute("src","b.gif" );
      ((Element)v.get(343)).setAttribute("width","12" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(343)).setAttribute("height","12" );
      ((Element)v.get(342)).appendChild((Element)v.get(343));
      /* Termina nodo:343   */
      /* Termina nodo:342   */

      /* Empieza nodo:344 / Elemento padre: 341   */
      v.add(doc.createElement("td"));
      ((Element)v.get(344)).setAttribute("width","750" );
      ((Element)v.get(341)).appendChild((Element)v.get(344));

      /* Empieza nodo:345 / Elemento padre: 344   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(345)).setAttribute("src","b.gif" );
      ((Element)v.get(344)).appendChild((Element)v.get(345));
      /* Termina nodo:345   */
      /* Termina nodo:344   */

      /* Empieza nodo:346 / Elemento padre: 341   */
      v.add(doc.createElement("td"));
      ((Element)v.get(346)).setAttribute("width","12" );
      ((Element)v.get(341)).appendChild((Element)v.get(346));

      /* Empieza nodo:347 / Elemento padre: 346   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(347)).setAttribute("src","b.gif" );
      ((Element)v.get(347)).setAttribute("width","12" );
      ((Element)v.get(347)).setAttribute("height","1" );
      ((Element)v.get(346)).appendChild((Element)v.get(347));
      /* Termina nodo:347   */
      /* Termina nodo:346   */
      /* Termina nodo:341   */

      /* Empieza nodo:348 / Elemento padre: 340   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(340)).appendChild((Element)v.get(348));

      /* Empieza nodo:349 / Elemento padre: 348   */
      v.add(doc.createElement("td"));
      ((Element)v.get(348)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(350)).setAttribute("src","b.gif" );
      ((Element)v.get(349)).appendChild((Element)v.get(350));
      /* Termina nodo:350   */
      /* Termina nodo:349   */

      /* Empieza nodo:351 / Elemento padre: 348   */
      v.add(doc.createElement("td"));
      ((Element)v.get(348)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
      v.add(doc.createElement("table"));
      ((Element)v.get(352)).setAttribute("width","100%" );
      ((Element)v.get(352)).setAttribute("border","0" );
      ((Element)v.get(352)).setAttribute("align","center" );
      ((Element)v.get(352)).setAttribute("cellspacing","0" );
      ((Element)v.get(352)).setAttribute("cellpadding","0" );
      ((Element)v.get(351)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(352)).appendChild((Element)v.get(353));

      /* Empieza nodo:354 / Elemento padre: 353   */
      v.add(doc.createElement("td"));
      ((Element)v.get(353)).appendChild((Element)v.get(354));

      /* Empieza nodo:355 / Elemento padre: 354   */
      v.add(doc.createElement("table"));
      ((Element)v.get(355)).setAttribute("width","732" );
      ((Element)v.get(355)).setAttribute("border","0" );
      ((Element)v.get(355)).setAttribute("align","left" );
      ((Element)v.get(355)).setAttribute("cellspacing","0" );
      ((Element)v.get(355)).setAttribute("cellpadding","0" );
      ((Element)v.get(354)).appendChild((Element)v.get(355));

      /* Empieza nodo:356 / Elemento padre: 355   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(355)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("td"));
      ((Element)v.get(356)).appendChild((Element)v.get(357));

      /* Empieza nodo:358 / Elemento padre: 357   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(358)).setAttribute("src","b.gif" );
      ((Element)v.get(357)).appendChild((Element)v.get(358));
      /* Termina nodo:358   */
      /* Termina nodo:357   */
      /* Termina nodo:356   */
      /* Termina nodo:355   */
      /* Termina nodo:354   */
      /* Termina nodo:353   */
      /* Termina nodo:352   */
      /* Termina nodo:351   */

      /* Empieza nodo:359 / Elemento padre: 348   */
      v.add(doc.createElement("td"));
      ((Element)v.get(348)).appendChild((Element)v.get(359));

      /* Empieza nodo:360 / Elemento padre: 359   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(360)).setAttribute("src","b.gif" );
      ((Element)v.get(359)).appendChild((Element)v.get(360));
      /* Termina nodo:360   */
      /* Termina nodo:359   */
      /* Termina nodo:348   */

      /* Empieza nodo:361 / Elemento padre: 340   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(340)).appendChild((Element)v.get(361));

      /* Empieza nodo:362 / Elemento padre: 361   */
      v.add(doc.createElement("td"));
      ((Element)v.get(361)).appendChild((Element)v.get(362));

      /* Empieza nodo:363 / Elemento padre: 362   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(363)).setAttribute("src","b.gif" );
      ((Element)v.get(362)).appendChild((Element)v.get(363));
      /* Termina nodo:363   */
      /* Termina nodo:362   */

      /* Empieza nodo:364 / Elemento padre: 361   */
      v.add(doc.createElement("td"));
      ((Element)v.get(361)).appendChild((Element)v.get(364));

      /* Empieza nodo:365 / Elemento padre: 364   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(364)).appendChild((Element)v.get(365));

      /* Empieza nodo:366 / Elemento padre: 365   */
      v.add(doc.createElement("table"));
      ((Element)v.get(366)).setAttribute("width","100%" );
      ((Element)v.get(366)).setAttribute("border","0" );
      ((Element)v.get(366)).setAttribute("align","center" );
      ((Element)v.get(366)).setAttribute("cellspacing","0" );
      ((Element)v.get(366)).setAttribute("cellpadding","0" );
      ((Element)v.get(365)).appendChild((Element)v.get(366));

      /* Empieza nodo:367 / Elemento padre: 366   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(366)).appendChild((Element)v.get(367));

      /* Empieza nodo:368 / Elemento padre: 367   */
      v.add(doc.createElement("td"));
      ((Element)v.get(368)).setAttribute("class","botonera" );
      ((Element)v.get(367)).appendChild((Element)v.get(368));

      /* Empieza nodo:369 / Elemento padre: 368   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(369)).setAttribute("nombre","btnAceptar5" );
      ((Element)v.get(369)).setAttribute("ID","botonContenido" );
      ((Element)v.get(369)).setAttribute("tipo","html" );
      ((Element)v.get(369)).setAttribute("accion","accionAceptar(get('formulario.OID_TIPO_PREMIO_MONETARIO'));" );
      ((Element)v.get(369)).setAttribute("estado","false" );
      ((Element)v.get(369)).setAttribute("cod","12" );
      ((Element)v.get(368)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */
      /* Termina nodo:368   */
      /* Termina nodo:367   */
      /* Termina nodo:366   */
      /* Termina nodo:365   */
      /* Termina nodo:364   */

      /* Empieza nodo:370 / Elemento padre: 361   */
      v.add(doc.createElement("td"));
      ((Element)v.get(361)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(371)).setAttribute("src","b.gif" );
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(371)).setAttribute("width","8" );
      ((Element)v.get(371)).setAttribute("height","12" );
      ((Element)v.get(370)).appendChild((Element)v.get(371));
      /* Termina nodo:371   */
      /* Termina nodo:370   */
      /* Termina nodo:361   */

      /* Empieza nodo:372 / Elemento padre: 340   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(340)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("td"));
      ((Element)v.get(373)).setAttribute("width","12" );
      ((Element)v.get(373)).setAttribute("align","center" );
      ((Element)v.get(372)).appendChild((Element)v.get(373));

      /* Empieza nodo:374 / Elemento padre: 373   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(374)).setAttribute("src","b.gif" );
      ((Element)v.get(374)).setAttribute("width","12" );
      ((Element)v.get(374)).setAttribute("height","12" );
      ((Element)v.get(373)).appendChild((Element)v.get(374));
      /* Termina nodo:374   */
      /* Termina nodo:373   */

      /* Empieza nodo:375 / Elemento padre: 372   */
      v.add(doc.createElement("td"));
      ((Element)v.get(375)).setAttribute("width","756" );
      ((Element)v.get(372)).appendChild((Element)v.get(375));

      /* Empieza nodo:376 / Elemento padre: 375   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(376)).setAttribute("src","b.gif" );
      ((Element)v.get(375)).appendChild((Element)v.get(376));
      /* Termina nodo:376   */
      /* Termina nodo:375   */

      /* Empieza nodo:377 / Elemento padre: 372   */
      v.add(doc.createElement("td"));
      ((Element)v.get(377)).setAttribute("width","12" );
      ((Element)v.get(372)).appendChild((Element)v.get(377));

      /* Empieza nodo:378 / Elemento padre: 377   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(378)).setAttribute("src","b.gif" );
      ((Element)v.get(378)).setAttribute("width","12" );
      ((Element)v.get(378)).setAttribute("height","1" );
      ((Element)v.get(377)).appendChild((Element)v.get(378));
      /* Termina nodo:378   */
      /* Termina nodo:377   */
      /* Termina nodo:372   */
      /* Termina nodo:340   */
      /* Termina nodo:339   */

      /* Empieza nodo:379 / Elemento padre: 37   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(379)).setAttribute("nombre","capa3" );
      ((Element)v.get(379)).setAttribute("alto","540" );
      ((Element)v.get(379)).setAttribute("ancho","100%" );
      ((Element)v.get(379)).setAttribute("colorf","" );
      ((Element)v.get(379)).setAttribute("borde","0" );
      ((Element)v.get(379)).setAttribute("imagenf","" );
      ((Element)v.get(379)).setAttribute("repeat","" );
      ((Element)v.get(379)).setAttribute("padding","" );
      ((Element)v.get(379)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(379)).setAttribute("contravsb","" );
      ((Element)v.get(379)).setAttribute("x","0" );
      ((Element)v.get(379)).setAttribute("y","463" );
      ((Element)v.get(379)).setAttribute("zindex","" );
      ((Element)v.get(37)).appendChild((Element)v.get(379));

      /* Empieza nodo:380 / Elemento padre: 379   */
      v.add(doc.createElement("table"));
      ((Element)v.get(380)).setAttribute("width","100%" );
      ((Element)v.get(380)).setAttribute("border","0" );
      ((Element)v.get(380)).setAttribute("cellspacing","0" );
      ((Element)v.get(380)).setAttribute("cellpadding","0" );
      ((Element)v.get(379)).appendChild((Element)v.get(380));

      /* Empieza nodo:381 / Elemento padre: 380   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(380)).appendChild((Element)v.get(381));

      /* Empieza nodo:382 / Elemento padre: 381   */
      v.add(doc.createElement("td"));
      ((Element)v.get(382)).setAttribute("width","12" );
      ((Element)v.get(382)).setAttribute("align","center" );
      ((Element)v.get(381)).appendChild((Element)v.get(382));

      /* Empieza nodo:383 / Elemento padre: 382   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(383)).setAttribute("src","b.gif" );
      ((Element)v.get(383)).setAttribute("width","12" );
      ((Element)v.get(383)).setAttribute("height","12" );
      ((Element)v.get(382)).appendChild((Element)v.get(383));
      /* Termina nodo:383   */
      /* Termina nodo:382   */

      /* Empieza nodo:384 / Elemento padre: 381   */
      v.add(doc.createElement("td"));
      ((Element)v.get(384)).setAttribute("width","750" );
      ((Element)v.get(381)).appendChild((Element)v.get(384));

      /* Empieza nodo:385 / Elemento padre: 384   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(385)).setAttribute("src","b.gif" );
      ((Element)v.get(384)).appendChild((Element)v.get(385));
      /* Termina nodo:385   */
      /* Termina nodo:384   */

      /* Empieza nodo:386 / Elemento padre: 381   */
      v.add(doc.createElement("td"));
      ((Element)v.get(386)).setAttribute("width","12" );
      ((Element)v.get(381)).appendChild((Element)v.get(386));

      /* Empieza nodo:387 / Elemento padre: 386   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(387)).setAttribute("src","b.gif" );
      ((Element)v.get(387)).setAttribute("width","12" );
      ((Element)v.get(387)).setAttribute("height","1" );
      ((Element)v.get(386)).appendChild((Element)v.get(387));
      /* Termina nodo:387   */
      /* Termina nodo:386   */
      /* Termina nodo:381   */

      /* Empieza nodo:388 / Elemento padre: 380   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(380)).appendChild((Element)v.get(388));

      /* Empieza nodo:389 / Elemento padre: 388   */
      v.add(doc.createElement("td"));
      ((Element)v.get(388)).appendChild((Element)v.get(389));

      /* Empieza nodo:390 / Elemento padre: 389   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(390)).setAttribute("src","b.gif" );
      ((Element)v.get(389)).appendChild((Element)v.get(390));
      /* Termina nodo:390   */
      /* Termina nodo:389   */

      /* Empieza nodo:391 / Elemento padre: 388   */
      v.add(doc.createElement("td"));
      ((Element)v.get(388)).appendChild((Element)v.get(391));

      /* Empieza nodo:392 / Elemento padre: 391   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(391)).appendChild((Element)v.get(392));

      /* Empieza nodo:393 / Elemento padre: 392   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(393)).setAttribute("class","legend" );
      ((Element)v.get(392)).appendChild((Element)v.get(393));

      /* Empieza nodo:394 / Elemento padre: 393   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(394)).setAttribute("nombre","lblOtrosDatosPremiosMonetario" );
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(394)).setAttribute("alto","13" );
      ((Element)v.get(394)).setAttribute("filas","1" );
      ((Element)v.get(394)).setAttribute("valor","" );
      ((Element)v.get(394)).setAttribute("id","legend" );
      ((Element)v.get(394)).setAttribute("cod","00349" );
      ((Element)v.get(393)).appendChild((Element)v.get(394));
      /* Termina nodo:394   */
      /* Termina nodo:393   */

      /* Empieza nodo:395 / Elemento padre: 392   */
      v.add(doc.createElement("table"));
      ((Element)v.get(395)).setAttribute("width","100%" );
      ((Element)v.get(395)).setAttribute("border","0" );
      ((Element)v.get(395)).setAttribute("align","center" );
      ((Element)v.get(395)).setAttribute("cellspacing","0" );
      ((Element)v.get(395)).setAttribute("cellpadding","0" );
      ((Element)v.get(392)).appendChild((Element)v.get(395));

      /* Empieza nodo:396 / Elemento padre: 395   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(395)).appendChild((Element)v.get(396));

      /* Empieza nodo:397 / Elemento padre: 396   */
      v.add(doc.createElement("td"));
      ((Element)v.get(396)).appendChild((Element)v.get(397));

      /* Empieza nodo:398 / Elemento padre: 397   */
      v.add(doc.createElement("table"));
      ((Element)v.get(398)).setAttribute("width","728" );
      ((Element)v.get(398)).setAttribute("border","0" );
      ((Element)v.get(398)).setAttribute("align","left" );
      ((Element)v.get(398)).setAttribute("cellspacing","0" );
      ((Element)v.get(398)).setAttribute("cellpadding","0" );
      ((Element)v.get(397)).appendChild((Element)v.get(398));

      /* Empieza nodo:399 / Elemento padre: 398   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(398)).appendChild((Element)v.get(399));

      /* Empieza nodo:400 / Elemento padre: 399   */
      v.add(doc.createElement("td"));
      ((Element)v.get(400)).setAttribute("colspan","4" );
      ((Element)v.get(399)).appendChild((Element)v.get(400));

      /* Empieza nodo:401 / Elemento padre: 400   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(401)).setAttribute("src","b.gif" );
      ((Element)v.get(401)).setAttribute("width","8" );
      ((Element)v.get(401)).setAttribute("height","8" );
      ((Element)v.get(400)).appendChild((Element)v.get(401));
      /* Termina nodo:401   */
      /* Termina nodo:400   */
      /* Termina nodo:399   */

      /* Empieza nodo:402 / Elemento padre: 398   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(398)).appendChild((Element)v.get(402));

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
      ((Element)v.get(402)).appendChild((Element)v.get(405));

      /* Empieza nodo:406 / Elemento padre: 405   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(406)).setAttribute("nombre","lblPagoPartes" );
      ((Element)v.get(406)).setAttribute("alto","13" );
      ((Element)v.get(406)).setAttribute("filas","1" );
      ((Element)v.get(406)).setAttribute("valor","" );
      ((Element)v.get(406)).setAttribute("id","datosTitle" );
      ((Element)v.get(406)).setAttribute("cod","1838" );
      ((Element)v.get(405)).appendChild((Element)v.get(406));
      /* Termina nodo:406   */
      /* Termina nodo:405   */

      /* Empieza nodo:407 / Elemento padre: 402   */
      v.add(doc.createElement("td"));
      ((Element)v.get(402)).appendChild((Element)v.get(407));

      /* Empieza nodo:408 / Elemento padre: 407   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(408)).setAttribute("src","b.gif" );
      ((Element)v.get(408)).setAttribute("width","25" );
      ((Element)v.get(408)).setAttribute("height","8" );
      ((Element)v.get(407)).appendChild((Element)v.get(408));
      /* Termina nodo:408   */
      /* Termina nodo:407   */

      /* Empieza nodo:409 / Elemento padre: 402   */
      v.add(doc.createElement("td"));
      ((Element)v.get(402)).appendChild((Element)v.get(409));

      /* Empieza nodo:410 / Elemento padre: 409   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(410)).setAttribute("nombre","lblCumplimiento" );
      ((Element)v.get(410)).setAttribute("alto","13" );
      ((Element)v.get(410)).setAttribute("filas","1" );
      ((Element)v.get(410)).setAttribute("valor","" );
      ((Element)v.get(410)).setAttribute("id","datosTitle" );
      ((Element)v.get(410)).setAttribute("cod","1839" );
      ((Element)v.get(409)).appendChild((Element)v.get(410));
      /* Termina nodo:410   */
      /* Termina nodo:409   */

      /* Empieza nodo:411 / Elemento padre: 402   */
      v.add(doc.createElement("td"));
      ((Element)v.get(402)).appendChild((Element)v.get(411));

      /* Empieza nodo:412 / Elemento padre: 411   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(412)).setAttribute("src","b.gif" );
      ((Element)v.get(412)).setAttribute("width","25" );
      ((Element)v.get(412)).setAttribute("height","8" );
      ((Element)v.get(411)).appendChild((Element)v.get(412));
      /* Termina nodo:412   */
      /* Termina nodo:411   */

      /* Empieza nodo:413 / Elemento padre: 402   */
      v.add(doc.createElement("td"));
      ((Element)v.get(402)).appendChild((Element)v.get(413));

      /* Empieza nodo:414 / Elemento padre: 413   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(414)).setAttribute("nombre","lblDescontarPago" );
      ((Element)v.get(414)).setAttribute("alto","13" );
      ((Element)v.get(414)).setAttribute("filas","1" );
      ((Element)v.get(414)).setAttribute("valor","" );
      ((Element)v.get(414)).setAttribute("id","datosTitle" );
      ((Element)v.get(414)).setAttribute("cod","1840" );
      ((Element)v.get(413)).appendChild((Element)v.get(414));
      /* Termina nodo:414   */
      /* Termina nodo:413   */

      /* Empieza nodo:415 / Elemento padre: 402   */
      v.add(doc.createElement("td"));
      ((Element)v.get(415)).setAttribute("width","100%" );
      ((Element)v.get(402)).appendChild((Element)v.get(415));

      /* Empieza nodo:416 / Elemento padre: 415   */
   }

   private void getXML1890(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(416)).setAttribute("src","b.gif" );
      ((Element)v.get(416)).setAttribute("width","8" );
      ((Element)v.get(416)).setAttribute("height","8" );
      ((Element)v.get(415)).appendChild((Element)v.get(416));
      /* Termina nodo:416   */
      /* Termina nodo:415   */
      /* Termina nodo:402   */

      /* Empieza nodo:417 / Elemento padre: 398   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(398)).appendChild((Element)v.get(417));

      /* Empieza nodo:418 / Elemento padre: 417   */
      v.add(doc.createElement("td"));
      ((Element)v.get(417)).appendChild((Element)v.get(418));

      /* Empieza nodo:419 / Elemento padre: 418   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(419)).setAttribute("src","b.gif" );
      ((Element)v.get(419)).setAttribute("width","8" );
      ((Element)v.get(419)).setAttribute("height","8" );
      ((Element)v.get(418)).appendChild((Element)v.get(419));
      /* Termina nodo:419   */
      /* Termina nodo:418   */

      /* Empieza nodo:420 / Elemento padre: 417   */
      v.add(doc.createElement("td"));
      ((Element)v.get(417)).appendChild((Element)v.get(420));

      /* Empieza nodo:421 / Elemento padre: 420   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(421)).setAttribute("nombre","ckPagoPartes" );
      ((Element)v.get(421)).setAttribute("id","datosCampos" );
      ((Element)v.get(421)).setAttribute("onclick","" );
      ((Element)v.get(421)).setAttribute("check","S" );
      ((Element)v.get(420)).appendChild((Element)v.get(421));
      /* Termina nodo:421   */
      /* Termina nodo:420   */

      /* Empieza nodo:422 / Elemento padre: 417   */
      v.add(doc.createElement("td"));
      ((Element)v.get(417)).appendChild((Element)v.get(422));

      /* Empieza nodo:423 / Elemento padre: 422   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(423)).setAttribute("src","b.gif" );
      ((Element)v.get(423)).setAttribute("width","25" );
      ((Element)v.get(423)).setAttribute("height","8" );
      ((Element)v.get(422)).appendChild((Element)v.get(423));
      /* Termina nodo:423   */
      /* Termina nodo:422   */

      /* Empieza nodo:424 / Elemento padre: 417   */
      v.add(doc.createElement("td"));
      ((Element)v.get(424)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(417)).appendChild((Element)v.get(424));

      /* Empieza nodo:425 / Elemento padre: 424   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(425)).setAttribute("nombre","cbCumplimiento" );
      ((Element)v.get(425)).setAttribute("id","datosCampos" );
      ((Element)v.get(425)).setAttribute("size","1" );
      ((Element)v.get(425)).setAttribute("onchange","onChangeCumplimiento();" );
      ((Element)v.get(425)).setAttribute("multiple","N" );
      ((Element)v.get(425)).setAttribute("req","S" );
      ((Element)v.get(425)).setAttribute("valorinicial","" );
      ((Element)v.get(425)).setAttribute("textoinicial","" );
      ((Element)v.get(424)).appendChild((Element)v.get(425));

      /* Empieza nodo:426 / Elemento padre: 425   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(425)).appendChild((Element)v.get(426));
      /* Termina nodo:426   */
      /* Termina nodo:425   */
      /* Termina nodo:424   */

      /* Empieza nodo:427 / Elemento padre: 417   */
      v.add(doc.createElement("td"));
      ((Element)v.get(417)).appendChild((Element)v.get(427));

      /* Empieza nodo:428 / Elemento padre: 427   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(428)).setAttribute("src","b.gif" );
      ((Element)v.get(428)).setAttribute("width","25" );
      ((Element)v.get(428)).setAttribute("height","8" );
      ((Element)v.get(427)).appendChild((Element)v.get(428));
      /* Termina nodo:428   */
      /* Termina nodo:427   */

      /* Empieza nodo:429 / Elemento padre: 417   */
      v.add(doc.createElement("td"));
      ((Element)v.get(417)).appendChild((Element)v.get(429));

      /* Empieza nodo:430 / Elemento padre: 429   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(430)).setAttribute("nombre","ckDescontarPago" );
      ((Element)v.get(430)).setAttribute("id","datosCampos" );
      ((Element)v.get(430)).setAttribute("onclick","" );
      ((Element)v.get(430)).setAttribute("check","N" );
      ((Element)v.get(429)).appendChild((Element)v.get(430));
      /* Termina nodo:430   */
      /* Termina nodo:429   */

      /* Empieza nodo:431 / Elemento padre: 417   */
      v.add(doc.createElement("td"));
      ((Element)v.get(431)).setAttribute("width","100%" );
      ((Element)v.get(417)).appendChild((Element)v.get(431));

      /* Empieza nodo:432 / Elemento padre: 431   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(432)).setAttribute("src","b.gif" );
      ((Element)v.get(432)).setAttribute("width","8" );
      ((Element)v.get(432)).setAttribute("height","8" );
      ((Element)v.get(431)).appendChild((Element)v.get(432));
      /* Termina nodo:432   */
      /* Termina nodo:431   */
      /* Termina nodo:417   */

      /* Empieza nodo:433 / Elemento padre: 398   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(398)).appendChild((Element)v.get(433));

      /* Empieza nodo:434 / Elemento padre: 433   */
      v.add(doc.createElement("td"));
      ((Element)v.get(434)).setAttribute("colspan","4" );
      ((Element)v.get(433)).appendChild((Element)v.get(434));

      /* Empieza nodo:435 / Elemento padre: 434   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(435)).setAttribute("src","b.gif" );
      ((Element)v.get(435)).setAttribute("width","8" );
      ((Element)v.get(435)).setAttribute("height","8" );
      ((Element)v.get(434)).appendChild((Element)v.get(435));
      /* Termina nodo:435   */
      /* Termina nodo:434   */
      /* Termina nodo:433   */
      /* Termina nodo:398   */
      /* Termina nodo:397   */
      /* Termina nodo:396   */

      /* Empieza nodo:436 / Elemento padre: 395   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(395)).appendChild((Element)v.get(436));

      /* Empieza nodo:437 / Elemento padre: 436   */
      v.add(doc.createElement("td"));
      ((Element)v.get(436)).appendChild((Element)v.get(437));

      /* Empieza nodo:438 / Elemento padre: 437   */
      v.add(doc.createElement("table"));
      ((Element)v.get(438)).setAttribute("width","100%" );
      ((Element)v.get(438)).setAttribute("align","left" );
      ((Element)v.get(438)).setAttribute("border","0" );
      ((Element)v.get(438)).setAttribute("cellspacing","0" );
      ((Element)v.get(438)).setAttribute("cellpadding","0" );
      ((Element)v.get(437)).appendChild((Element)v.get(438));

      /* Empieza nodo:439 / Elemento padre: 438   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(438)).appendChild((Element)v.get(439));

      /* Empieza nodo:440 / Elemento padre: 439   */
   }

   private void getXML1980(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(439)).appendChild((Element)v.get(440));

      /* Empieza nodo:441 / Elemento padre: 440   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(441)).setAttribute("src","b.gif" );
      ((Element)v.get(440)).appendChild((Element)v.get(441));
      /* Termina nodo:441   */
      /* Termina nodo:440   */

      /* Empieza nodo:442 / Elemento padre: 439   */
      v.add(doc.createElement("td"));
      ((Element)v.get(439)).appendChild((Element)v.get(442));

      /* Empieza nodo:443 / Elemento padre: 442   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(442)).appendChild((Element)v.get(443));

      /* Empieza nodo:444 / Elemento padre: 443   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(444)).setAttribute("class","legend" );
      ((Element)v.get(443)).appendChild((Element)v.get(444));

      /* Empieza nodo:445 / Elemento padre: 444   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(445)).setAttribute("nombre","lblDatosPago" );
      ((Element)v.get(445)).setAttribute("alto","13" );
      ((Element)v.get(445)).setAttribute("filas","1" );
      ((Element)v.get(445)).setAttribute("valor","" );
      ((Element)v.get(445)).setAttribute("id","legend" );
      ((Element)v.get(445)).setAttribute("cod","00224" );
      ((Element)v.get(444)).appendChild((Element)v.get(445));
      /* Termina nodo:445   */
      /* Termina nodo:444   */

      /* Empieza nodo:446 / Elemento padre: 443   */
      v.add(doc.createElement("table"));
      ((Element)v.get(446)).setAttribute("width","100%" );
      ((Element)v.get(446)).setAttribute("border","0" );
      ((Element)v.get(446)).setAttribute("align","center" );
      ((Element)v.get(446)).setAttribute("cellspacing","0" );
      ((Element)v.get(446)).setAttribute("cellpadding","0" );
      ((Element)v.get(443)).appendChild((Element)v.get(446));

      /* Empieza nodo:447 / Elemento padre: 446   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(446)).appendChild((Element)v.get(447));

      /* Empieza nodo:448 / Elemento padre: 447   */
      v.add(doc.createElement("td"));
      ((Element)v.get(447)).appendChild((Element)v.get(448));

      /* Empieza nodo:449 / Elemento padre: 448   */
      v.add(doc.createElement("table"));
      ((Element)v.get(449)).setAttribute("width","699" );
      ((Element)v.get(449)).setAttribute("border","0" );
      ((Element)v.get(449)).setAttribute("align","left" );
      ((Element)v.get(449)).setAttribute("cellspacing","0" );
      ((Element)v.get(449)).setAttribute("cellpadding","0" );
      ((Element)v.get(448)).appendChild((Element)v.get(449));

      /* Empieza nodo:450 / Elemento padre: 449   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(449)).appendChild((Element)v.get(450));

      /* Empieza nodo:451 / Elemento padre: 450   */
      v.add(doc.createElement("td"));
      ((Element)v.get(451)).setAttribute("colspan","4" );
      ((Element)v.get(450)).appendChild((Element)v.get(451));

      /* Empieza nodo:452 / Elemento padre: 451   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(452)).setAttribute("src","b.gif" );
      ((Element)v.get(452)).setAttribute("width","8" );
      ((Element)v.get(452)).setAttribute("height","8" );
      ((Element)v.get(451)).appendChild((Element)v.get(452));
      /* Termina nodo:452   */
      /* Termina nodo:451   */
      /* Termina nodo:450   */

      /* Empieza nodo:453 / Elemento padre: 449   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(449)).appendChild((Element)v.get(453));

      /* Empieza nodo:454 / Elemento padre: 453   */
      v.add(doc.createElement("td"));
      ((Element)v.get(453)).appendChild((Element)v.get(454));

      /* Empieza nodo:455 / Elemento padre: 454   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(455)).setAttribute("src","b.gif" );
      ((Element)v.get(455)).setAttribute("width","8" );
      ((Element)v.get(455)).setAttribute("height","8" );
      ((Element)v.get(454)).appendChild((Element)v.get(455));
      /* Termina nodo:455   */
      /* Termina nodo:454   */

      /* Empieza nodo:456 / Elemento padre: 453   */
      v.add(doc.createElement("td"));
      ((Element)v.get(453)).appendChild((Element)v.get(456));

      /* Empieza nodo:457 / Elemento padre: 456   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(457)).setAttribute("nombre","lblNumPago" );
      ((Element)v.get(457)).setAttribute("alto","13" );
      ((Element)v.get(457)).setAttribute("filas","1" );
      ((Element)v.get(457)).setAttribute("valor","" );
      ((Element)v.get(457)).setAttribute("id","datosTitle" );
      ((Element)v.get(457)).setAttribute("cod","1841" );
      ((Element)v.get(456)).appendChild((Element)v.get(457));
      /* Termina nodo:457   */
      /* Termina nodo:456   */

      /* Empieza nodo:458 / Elemento padre: 453   */
      v.add(doc.createElement("td"));
      ((Element)v.get(453)).appendChild((Element)v.get(458));

      /* Empieza nodo:459 / Elemento padre: 458   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(459)).setAttribute("src","b.gif" );
      ((Element)v.get(459)).setAttribute("width","25" );
      ((Element)v.get(459)).setAttribute("height","8" );
      ((Element)v.get(458)).appendChild((Element)v.get(459));
      /* Termina nodo:459   */
      /* Termina nodo:458   */

      /* Empieza nodo:460 / Elemento padre: 453   */
      v.add(doc.createElement("td"));
      ((Element)v.get(460)).setAttribute("colspan","4" );
      ((Element)v.get(453)).appendChild((Element)v.get(460));

      /* Empieza nodo:461 / Elemento padre: 460   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(461)).setAttribute("nombre","lblPremio" );
      ((Element)v.get(461)).setAttribute("alto","13" );
      ((Element)v.get(461)).setAttribute("filas","1" );
      ((Element)v.get(461)).setAttribute("valor","" );
      ((Element)v.get(461)).setAttribute("id","datosTitle" );
      ((Element)v.get(461)).setAttribute("cod","1784" );
      ((Element)v.get(460)).appendChild((Element)v.get(461));
      /* Termina nodo:461   */
      /* Termina nodo:460   */

      /* Empieza nodo:462 / Elemento padre: 453   */
      v.add(doc.createElement("td"));
      ((Element)v.get(453)).appendChild((Element)v.get(462));

      /* Empieza nodo:463 / Elemento padre: 462   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(463)).setAttribute("src","b.gif" );
      ((Element)v.get(463)).setAttribute("width","25" );
   }

   private void getXML2070(Document doc) {
      ((Element)v.get(463)).setAttribute("height","8" );
      ((Element)v.get(462)).appendChild((Element)v.get(463));
      /* Termina nodo:463   */
      /* Termina nodo:462   */

      /* Empieza nodo:464 / Elemento padre: 453   */
      v.add(doc.createElement("td"));
      ((Element)v.get(453)).appendChild((Element)v.get(464));

      /* Empieza nodo:465 / Elemento padre: 464   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(465)).setAttribute("nombre","lblPeriodoControl" );
      ((Element)v.get(465)).setAttribute("alto","13" );
      ((Element)v.get(465)).setAttribute("filas","1" );
      ((Element)v.get(465)).setAttribute("valor","" );
      ((Element)v.get(465)).setAttribute("id","datosTitle" );
      ((Element)v.get(465)).setAttribute("cod","1842" );
      ((Element)v.get(464)).appendChild((Element)v.get(465));
      /* Termina nodo:465   */
      /* Termina nodo:464   */

      /* Empieza nodo:466 / Elemento padre: 453   */
      v.add(doc.createElement("td"));
      ((Element)v.get(466)).setAttribute("width","100%" );
      ((Element)v.get(453)).appendChild((Element)v.get(466));

      /* Empieza nodo:467 / Elemento padre: 466   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(467)).setAttribute("src","b.gif" );
      ((Element)v.get(467)).setAttribute("width","8" );
      ((Element)v.get(467)).setAttribute("height","8" );
      ((Element)v.get(466)).appendChild((Element)v.get(467));
      /* Termina nodo:467   */
      /* Termina nodo:466   */
      /* Termina nodo:453   */

      /* Empieza nodo:468 / Elemento padre: 449   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(449)).appendChild((Element)v.get(468));

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
      ((Element)v.get(471)).setAttribute("valign","bottom" );
      ((Element)v.get(468)).appendChild((Element)v.get(471));

      /* Empieza nodo:472 / Elemento padre: 471   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(472)).setAttribute("nombre","lbNPago" );
      ((Element)v.get(472)).setAttribute("alto","13" );
      ((Element)v.get(472)).setAttribute("filas","1" );
      ((Element)v.get(472)).setAttribute("valor","" );
      ((Element)v.get(472)).setAttribute("id","datosCampos" );
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
      ((Element)v.get(475)).setAttribute("valign","bottom" );
      ((Element)v.get(475)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(468)).appendChild((Element)v.get(475));

      /* Empieza nodo:476 / Elemento padre: 475   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(476)).setAttribute("nombre","txtPremio" );
      ((Element)v.get(476)).setAttribute("id","datosCampos" );
      ((Element)v.get(476)).setAttribute("max","6" );
      ((Element)v.get(476)).setAttribute("tipo","" );
      ((Element)v.get(476)).setAttribute("onchange","" );
      ((Element)v.get(476)).setAttribute("req","N" );
      ((Element)v.get(476)).setAttribute("size","6" );
      ((Element)v.get(476)).setAttribute("valor","" );
      ((Element)v.get(476)).setAttribute("validacion","" );
      ((Element)v.get(475)).appendChild((Element)v.get(476));
      /* Termina nodo:476   */
      /* Termina nodo:475   */

      /* Empieza nodo:477 / Elemento padre: 468   */
      v.add(doc.createElement("td"));
      ((Element)v.get(477)).setAttribute("valign","bottom" );
      ((Element)v.get(468)).appendChild((Element)v.get(477));

      /* Empieza nodo:478 / Elemento padre: 477   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(478)).setAttribute("nombre","lbPremio" );
      ((Element)v.get(478)).setAttribute("alto","13" );
      ((Element)v.get(478)).setAttribute("filas","1" );
      ((Element)v.get(478)).setAttribute("valor","" );
      ((Element)v.get(478)).setAttribute("id","datosCampos" );
      ((Element)v.get(478)).setAttribute("cod","1380" );
      ((Element)v.get(477)).appendChild((Element)v.get(478));
      /* Termina nodo:478   */
      /* Termina nodo:477   */

      /* Empieza nodo:479 / Elemento padre: 468   */
      v.add(doc.createElement("td"));
      ((Element)v.get(468)).appendChild((Element)v.get(479));

      /* Empieza nodo:480 / Elemento padre: 479   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(480)).setAttribute("src","b.gif" );
      ((Element)v.get(480)).setAttribute("width","4" );
      ((Element)v.get(480)).setAttribute("height","8" );
      ((Element)v.get(479)).appendChild((Element)v.get(480));
      /* Termina nodo:480   */
      /* Termina nodo:479   */

      /* Empieza nodo:481 / Elemento padre: 468   */
      v.add(doc.createElement("td"));
      ((Element)v.get(468)).appendChild((Element)v.get(481));

      /* Empieza nodo:482 / Elemento padre: 481   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(482)).setAttribute("src","iconorequerido.gif" );
      ((Element)v.get(481)).appendChild((Element)v.get(482));
      /* Termina nodo:482   */
      /* Termina nodo:481   */

      /* Empieza nodo:483 / Elemento padre: 468   */
      v.add(doc.createElement("td"));
      ((Element)v.get(468)).appendChild((Element)v.get(483));

      /* Empieza nodo:484 / Elemento padre: 483   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(484)).setAttribute("src","b.gif" );
      ((Element)v.get(484)).setAttribute("width","25" );
      ((Element)v.get(484)).setAttribute("height","8" );
   }

   private void getXML2160(Document doc) {
      ((Element)v.get(483)).appendChild((Element)v.get(484));
      /* Termina nodo:484   */
      /* Termina nodo:483   */

      /* Empieza nodo:485 / Elemento padre: 468   */
      v.add(doc.createElement("td"));
      ((Element)v.get(485)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(468)).appendChild((Element)v.get(485));

      /* Empieza nodo:486 / Elemento padre: 485   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(486)).setAttribute("nombre","cbPeriodoControl" );
      ((Element)v.get(486)).setAttribute("id","datosCampos" );
      ((Element)v.get(486)).setAttribute("size","1" );
      ((Element)v.get(486)).setAttribute("multiple","N" );
      ((Element)v.get(486)).setAttribute("req","S" );
      ((Element)v.get(486)).setAttribute("valorinicial","" );
      ((Element)v.get(486)).setAttribute("textoinicial","" );
      ((Element)v.get(485)).appendChild((Element)v.get(486));

      /* Empieza nodo:487 / Elemento padre: 486   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(486)).appendChild((Element)v.get(487));
      /* Termina nodo:487   */
      /* Termina nodo:486   */
      /* Termina nodo:485   */

      /* Empieza nodo:488 / Elemento padre: 468   */
      v.add(doc.createElement("td"));
      ((Element)v.get(488)).setAttribute("width","100%" );
      ((Element)v.get(468)).appendChild((Element)v.get(488));

      /* Empieza nodo:489 / Elemento padre: 488   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(489)).setAttribute("src","b.gif" );
      ((Element)v.get(489)).setAttribute("width","8" );
      ((Element)v.get(489)).setAttribute("height","8" );
      ((Element)v.get(488)).appendChild((Element)v.get(489));
      /* Termina nodo:489   */
      /* Termina nodo:488   */
      /* Termina nodo:468   */

      /* Empieza nodo:490 / Elemento padre: 449   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(449)).appendChild((Element)v.get(490));

      /* Empieza nodo:491 / Elemento padre: 490   */
      v.add(doc.createElement("td"));
      ((Element)v.get(491)).setAttribute("colspan","4" );
      ((Element)v.get(490)).appendChild((Element)v.get(491));

      /* Empieza nodo:492 / Elemento padre: 491   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(492)).setAttribute("src","b.gif" );
      ((Element)v.get(492)).setAttribute("width","8" );
      ((Element)v.get(492)).setAttribute("height","8" );
      ((Element)v.get(491)).appendChild((Element)v.get(492));
      /* Termina nodo:492   */
      /* Termina nodo:491   */
      /* Termina nodo:490   */
      /* Termina nodo:449   */
      /* Termina nodo:448   */
      /* Termina nodo:447   */
      /* Termina nodo:446   */
      /* Termina nodo:443   */
      /* Termina nodo:442   */

      /* Empieza nodo:493 / Elemento padre: 439   */
      v.add(doc.createElement("td"));
      ((Element)v.get(439)).appendChild((Element)v.get(493));

      /* Empieza nodo:494 / Elemento padre: 493   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(494)).setAttribute("src","b.gif" );
      ((Element)v.get(493)).appendChild((Element)v.get(494));
      /* Termina nodo:494   */
      /* Termina nodo:493   */
      /* Termina nodo:439   */

      /* Empieza nodo:495 / Elemento padre: 438   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(438)).appendChild((Element)v.get(495));

      /* Empieza nodo:496 / Elemento padre: 495   */
      v.add(doc.createElement("td"));
      ((Element)v.get(495)).appendChild((Element)v.get(496));

      /* Empieza nodo:497 / Elemento padre: 496   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(497)).setAttribute("src","b.gif" );
      ((Element)v.get(496)).appendChild((Element)v.get(497));
      /* Termina nodo:497   */
      /* Termina nodo:496   */

      /* Empieza nodo:498 / Elemento padre: 495   */
      v.add(doc.createElement("td"));
      ((Element)v.get(495)).appendChild((Element)v.get(498));

      /* Empieza nodo:499 / Elemento padre: 498   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(498)).appendChild((Element)v.get(499));

      /* Empieza nodo:500 / Elemento padre: 499   */
      v.add(doc.createElement("table"));
      ((Element)v.get(500)).setAttribute("width","100%" );
      ((Element)v.get(500)).setAttribute("border","0" );
      ((Element)v.get(500)).setAttribute("align","center" );
      ((Element)v.get(500)).setAttribute("cellspacing","0" );
      ((Element)v.get(500)).setAttribute("cellpadding","0" );
      ((Element)v.get(499)).appendChild((Element)v.get(500));

      /* Empieza nodo:501 / Elemento padre: 500   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(500)).appendChild((Element)v.get(501));

      /* Empieza nodo:502 / Elemento padre: 501   */
      v.add(doc.createElement("td"));
      ((Element)v.get(502)).setAttribute("class","botonera" );
      ((Element)v.get(501)).appendChild((Element)v.get(502));

      /* Empieza nodo:503 / Elemento padre: 502   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(503)).setAttribute("nombre","btnAnadir" );
      ((Element)v.get(503)).setAttribute("ID","botonContenido" );
      ((Element)v.get(503)).setAttribute("tipo","html" );
      ((Element)v.get(503)).setAttribute("accion","accionAniadirPagoMonetario();" );
      ((Element)v.get(503)).setAttribute("estado","false" );
      ((Element)v.get(503)).setAttribute("cod","404" );
      ((Element)v.get(502)).appendChild((Element)v.get(503));
      /* Termina nodo:503   */
      /* Termina nodo:502   */
      /* Termina nodo:501   */
      /* Termina nodo:500   */
      /* Termina nodo:499   */
      /* Termina nodo:498   */

      /* Empieza nodo:504 / Elemento padre: 495   */
      v.add(doc.createElement("td"));
      ((Element)v.get(495)).appendChild((Element)v.get(504));

      /* Empieza nodo:505 / Elemento padre: 504   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(505)).setAttribute("src","b.gif" );
      ((Element)v.get(505)).setAttribute("width","8" );
      ((Element)v.get(505)).setAttribute("height","12" );
      ((Element)v.get(504)).appendChild((Element)v.get(505));
      /* Termina nodo:505   */
      /* Termina nodo:504   */
      /* Termina nodo:495   */

      /* Empieza nodo:506 / Elemento padre: 438   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(438)).appendChild((Element)v.get(506));

      /* Empieza nodo:507 / Elemento padre: 506   */
      v.add(doc.createElement("td"));
      ((Element)v.get(507)).setAttribute("width","12" );
      ((Element)v.get(507)).setAttribute("align","center" );
      ((Element)v.get(506)).appendChild((Element)v.get(507));

      /* Empieza nodo:508 / Elemento padre: 507   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(508)).setAttribute("src","b.gif" );
      ((Element)v.get(508)).setAttribute("width","12" );
      ((Element)v.get(508)).setAttribute("height","342" );
      ((Element)v.get(507)).appendChild((Element)v.get(508));
      /* Termina nodo:508   */
      /* Termina nodo:507   */

      /* Empieza nodo:509 / Elemento padre: 506   */
      v.add(doc.createElement("td"));
      ((Element)v.get(509)).setAttribute("width","756" );
      ((Element)v.get(506)).appendChild((Element)v.get(509));

      /* Empieza nodo:510 / Elemento padre: 509   */
   }

   private void getXML2250(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(510)).setAttribute("src","b.gif" );
      ((Element)v.get(509)).appendChild((Element)v.get(510));
      /* Termina nodo:510   */
      /* Termina nodo:509   */

      /* Empieza nodo:511 / Elemento padre: 506   */
      v.add(doc.createElement("td"));
      ((Element)v.get(511)).setAttribute("width","12" );
      ((Element)v.get(506)).appendChild((Element)v.get(511));

      /* Empieza nodo:512 / Elemento padre: 511   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(512)).setAttribute("src","b.gif" );
      ((Element)v.get(512)).setAttribute("width","12" );
      ((Element)v.get(512)).setAttribute("height","1" );
      ((Element)v.get(511)).appendChild((Element)v.get(512));
      /* Termina nodo:512   */
      /* Termina nodo:511   */
      /* Termina nodo:506   */
      /* Termina nodo:438   */
      /* Termina nodo:437   */
      /* Termina nodo:436   */
      /* Termina nodo:395   */
      /* Termina nodo:392   */
      /* Termina nodo:391   */

      /* Empieza nodo:513 / Elemento padre: 388   */
      v.add(doc.createElement("td"));
      ((Element)v.get(388)).appendChild((Element)v.get(513));

      /* Empieza nodo:514 / Elemento padre: 513   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(514)).setAttribute("src","b.gif" );
      ((Element)v.get(513)).appendChild((Element)v.get(514));
      /* Termina nodo:514   */
      /* Termina nodo:513   */
      /* Termina nodo:388   */

      /* Empieza nodo:515 / Elemento padre: 380   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(380)).appendChild((Element)v.get(515));

      /* Empieza nodo:516 / Elemento padre: 515   */
      v.add(doc.createElement("td"));
      ((Element)v.get(515)).appendChild((Element)v.get(516));

      /* Empieza nodo:517 / Elemento padre: 516   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(517)).setAttribute("src","b.gif" );
      ((Element)v.get(516)).appendChild((Element)v.get(517));
      /* Termina nodo:517   */
      /* Termina nodo:516   */

      /* Empieza nodo:518 / Elemento padre: 515   */
      v.add(doc.createElement("td"));
      ((Element)v.get(515)).appendChild((Element)v.get(518));

      /* Empieza nodo:519 / Elemento padre: 518   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(518)).appendChild((Element)v.get(519));

      /* Empieza nodo:520 / Elemento padre: 519   */
      v.add(doc.createElement("table"));
      ((Element)v.get(520)).setAttribute("width","100%" );
      ((Element)v.get(520)).setAttribute("border","0" );
      ((Element)v.get(520)).setAttribute("align","center" );
      ((Element)v.get(520)).setAttribute("cellspacing","0" );
      ((Element)v.get(520)).setAttribute("cellpadding","0" );
      ((Element)v.get(519)).appendChild((Element)v.get(520));

      /* Empieza nodo:521 / Elemento padre: 520   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(520)).appendChild((Element)v.get(521));

      /* Empieza nodo:522 / Elemento padre: 521   */
      v.add(doc.createElement("td"));
      ((Element)v.get(522)).setAttribute("class","botonera" );
      ((Element)v.get(521)).appendChild((Element)v.get(522));

      /* Empieza nodo:523 / Elemento padre: 522   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(523)).setAttribute("nombre","btnAceptar2" );
      ((Element)v.get(523)).setAttribute("ID","botonContenido" );
      ((Element)v.get(523)).setAttribute("tipo","html" );
      ((Element)v.get(523)).setAttribute("accion","accionAceptar(get('formulario.OID_TIPO_PREMIO_MONETARIO'));" );
      ((Element)v.get(523)).setAttribute("estado","false" );
      ((Element)v.get(523)).setAttribute("cod","12" );
      ((Element)v.get(522)).appendChild((Element)v.get(523));
      /* Termina nodo:523   */
      /* Termina nodo:522   */
      /* Termina nodo:521   */
      /* Termina nodo:520   */
      /* Termina nodo:519   */
      /* Termina nodo:518   */

      /* Empieza nodo:524 / Elemento padre: 515   */
      v.add(doc.createElement("td"));
      ((Element)v.get(515)).appendChild((Element)v.get(524));

      /* Empieza nodo:525 / Elemento padre: 524   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(525)).setAttribute("src","b.gif" );
      ((Element)v.get(525)).setAttribute("width","8" );
      ((Element)v.get(525)).setAttribute("height","12" );
      ((Element)v.get(524)).appendChild((Element)v.get(525));
      /* Termina nodo:525   */
      /* Termina nodo:524   */
      /* Termina nodo:515   */

      /* Empieza nodo:526 / Elemento padre: 380   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(380)).appendChild((Element)v.get(526));

      /* Empieza nodo:527 / Elemento padre: 526   */
      v.add(doc.createElement("td"));
      ((Element)v.get(527)).setAttribute("width","12" );
      ((Element)v.get(527)).setAttribute("align","center" );
      ((Element)v.get(526)).appendChild((Element)v.get(527));

      /* Empieza nodo:528 / Elemento padre: 527   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(528)).setAttribute("src","b.gif" );
      ((Element)v.get(528)).setAttribute("width","12" );
      ((Element)v.get(528)).setAttribute("height","12" );
      ((Element)v.get(527)).appendChild((Element)v.get(528));
      /* Termina nodo:528   */
      /* Termina nodo:527   */

      /* Empieza nodo:529 / Elemento padre: 526   */
      v.add(doc.createElement("td"));
      ((Element)v.get(529)).setAttribute("width","756" );
      ((Element)v.get(526)).appendChild((Element)v.get(529));

      /* Empieza nodo:530 / Elemento padre: 529   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(530)).setAttribute("src","b.gif" );
      ((Element)v.get(529)).appendChild((Element)v.get(530));
      /* Termina nodo:530   */
      /* Termina nodo:529   */

      /* Empieza nodo:531 / Elemento padre: 526   */
      v.add(doc.createElement("td"));
      ((Element)v.get(531)).setAttribute("width","12" );
      ((Element)v.get(526)).appendChild((Element)v.get(531));

      /* Empieza nodo:532 / Elemento padre: 531   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(532)).setAttribute("src","b.gif" );
      ((Element)v.get(532)).setAttribute("width","12" );
      ((Element)v.get(532)).setAttribute("height","1" );
      ((Element)v.get(531)).appendChild((Element)v.get(532));
      /* Termina nodo:532   */
      /* Termina nodo:531   */
      /* Termina nodo:526   */
      /* Termina nodo:380   */
      /* Termina nodo:379   */

      /* Empieza nodo:533 / Elemento padre: 37   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(533)).setAttribute("nombre","capa4" );
      ((Element)v.get(533)).setAttribute("alto","1020" );
      ((Element)v.get(533)).setAttribute("ancho","100%" );
      ((Element)v.get(533)).setAttribute("colorf","" );
      ((Element)v.get(533)).setAttribute("borde","0" );
      ((Element)v.get(533)).setAttribute("imagenf","" );
      ((Element)v.get(533)).setAttribute("repeat","" );
      ((Element)v.get(533)).setAttribute("padding","" );
      ((Element)v.get(533)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(533)).setAttribute("contravsb","" );
   }

   private void getXML2340(Document doc) {
      ((Element)v.get(533)).setAttribute("x","0" );
      ((Element)v.get(533)).setAttribute("y","341" );
      ((Element)v.get(533)).setAttribute("zindex","" );
      ((Element)v.get(37)).appendChild((Element)v.get(533));

      /* Empieza nodo:534 / Elemento padre: 533   */
      v.add(doc.createElement("table"));
      ((Element)v.get(534)).setAttribute("width","100%" );
      ((Element)v.get(534)).setAttribute("border","0" );
      ((Element)v.get(534)).setAttribute("cellspacing","0" );
      ((Element)v.get(534)).setAttribute("cellpadding","0" );
      ((Element)v.get(533)).appendChild((Element)v.get(534));

      /* Empieza nodo:535 / Elemento padre: 534   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(534)).appendChild((Element)v.get(535));

      /* Empieza nodo:536 / Elemento padre: 535   */
      v.add(doc.createElement("td"));
      ((Element)v.get(536)).setAttribute("width","12" );
      ((Element)v.get(536)).setAttribute("align","center" );
      ((Element)v.get(535)).appendChild((Element)v.get(536));

      /* Empieza nodo:537 / Elemento padre: 536   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(537)).setAttribute("src","b.gif" );
      ((Element)v.get(537)).setAttribute("width","12" );
      ((Element)v.get(537)).setAttribute("height","12" );
      ((Element)v.get(536)).appendChild((Element)v.get(537));
      /* Termina nodo:537   */
      /* Termina nodo:536   */

      /* Empieza nodo:538 / Elemento padre: 535   */
      v.add(doc.createElement("td"));
      ((Element)v.get(538)).setAttribute("width","750" );
      ((Element)v.get(535)).appendChild((Element)v.get(538));

      /* Empieza nodo:539 / Elemento padre: 538   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(539)).setAttribute("src","b.gif" );
      ((Element)v.get(538)).appendChild((Element)v.get(539));
      /* Termina nodo:539   */
      /* Termina nodo:538   */

      /* Empieza nodo:540 / Elemento padre: 535   */
      v.add(doc.createElement("td"));
      ((Element)v.get(540)).setAttribute("width","12" );
      ((Element)v.get(535)).appendChild((Element)v.get(540));

      /* Empieza nodo:541 / Elemento padre: 540   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(541)).setAttribute("src","b.gif" );
      ((Element)v.get(541)).setAttribute("width","12" );
      ((Element)v.get(541)).setAttribute("height","1" );
      ((Element)v.get(540)).appendChild((Element)v.get(541));
      /* Termina nodo:541   */
      /* Termina nodo:540   */
      /* Termina nodo:535   */

      /* Empieza nodo:542 / Elemento padre: 534   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(534)).appendChild((Element)v.get(542));

      /* Empieza nodo:543 / Elemento padre: 542   */
      v.add(doc.createElement("td"));
      ((Element)v.get(542)).appendChild((Element)v.get(543));

      /* Empieza nodo:544 / Elemento padre: 543   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(544)).setAttribute("src","b.gif" );
      ((Element)v.get(543)).appendChild((Element)v.get(544));
      /* Termina nodo:544   */
      /* Termina nodo:543   */

      /* Empieza nodo:545 / Elemento padre: 542   */
      v.add(doc.createElement("td"));
      ((Element)v.get(542)).appendChild((Element)v.get(545));

      /* Empieza nodo:546 / Elemento padre: 545   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(545)).appendChild((Element)v.get(546));

      /* Empieza nodo:547 / Elemento padre: 546   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(547)).setAttribute("class","legend" );
      ((Element)v.get(546)).appendChild((Element)v.get(547));

      /* Empieza nodo:548 / Elemento padre: 547   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(548)).setAttribute("nombre","lblDatosPremiosArticulos4" );
      ((Element)v.get(548)).setAttribute("alto","13" );
      ((Element)v.get(548)).setAttribute("filas","1" );
      ((Element)v.get(548)).setAttribute("valor","" );
      ((Element)v.get(548)).setAttribute("id","legend" );
      ((Element)v.get(548)).setAttribute("cod","00352" );
      ((Element)v.get(547)).appendChild((Element)v.get(548));
      /* Termina nodo:548   */
      /* Termina nodo:547   */

      /* Empieza nodo:549 / Elemento padre: 546   */
      v.add(doc.createElement("table"));
      ((Element)v.get(549)).setAttribute("width","100%" );
      ((Element)v.get(549)).setAttribute("border","0" );
      ((Element)v.get(549)).setAttribute("align","center" );
      ((Element)v.get(549)).setAttribute("cellspacing","0" );
      ((Element)v.get(549)).setAttribute("cellpadding","0" );
      ((Element)v.get(546)).appendChild((Element)v.get(549));

      /* Empieza nodo:550 / Elemento padre: 549   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(549)).appendChild((Element)v.get(550));

      /* Empieza nodo:551 / Elemento padre: 550   */
      v.add(doc.createElement("td"));
      ((Element)v.get(551)).setAttribute("width","12" );
      ((Element)v.get(551)).setAttribute("align","center" );
      ((Element)v.get(550)).appendChild((Element)v.get(551));

      /* Empieza nodo:552 / Elemento padre: 551   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(552)).setAttribute("src","b.gif" );
      ((Element)v.get(552)).setAttribute("width","12" );
      ((Element)v.get(552)).setAttribute("height","12" );
      ((Element)v.get(551)).appendChild((Element)v.get(552));
      /* Termina nodo:552   */
      /* Termina nodo:551   */

      /* Empieza nodo:553 / Elemento padre: 550   */
      v.add(doc.createElement("td"));
      ((Element)v.get(553)).setAttribute("width","750" );
      ((Element)v.get(550)).appendChild((Element)v.get(553));

      /* Empieza nodo:554 / Elemento padre: 553   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(554)).setAttribute("src","b.gif" );
      ((Element)v.get(553)).appendChild((Element)v.get(554));
      /* Termina nodo:554   */
      /* Termina nodo:553   */

      /* Empieza nodo:555 / Elemento padre: 550   */
      v.add(doc.createElement("td"));
      ((Element)v.get(555)).setAttribute("width","12" );
      ((Element)v.get(550)).appendChild((Element)v.get(555));

      /* Empieza nodo:556 / Elemento padre: 555   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(556)).setAttribute("src","b.gif" );
      ((Element)v.get(556)).setAttribute("width","12" );
      ((Element)v.get(556)).setAttribute("height","1" );
      ((Element)v.get(555)).appendChild((Element)v.get(556));
      /* Termina nodo:556   */
      /* Termina nodo:555   */
      /* Termina nodo:550   */

      /* Empieza nodo:557 / Elemento padre: 549   */
      v.add(doc.createElement("tr"));
   }

   private void getXML2430(Document doc) {
      ((Element)v.get(549)).appendChild((Element)v.get(557));

      /* Empieza nodo:558 / Elemento padre: 557   */
      v.add(doc.createElement("td"));
      ((Element)v.get(558)).setAttribute("colspan","3" );
      ((Element)v.get(557)).appendChild((Element)v.get(558));

      /* Empieza nodo:559 / Elemento padre: 558   */
      v.add(doc.createElement("table"));
      ((Element)v.get(559)).setAttribute("width","728" );
      ((Element)v.get(559)).setAttribute("border","0" );
      ((Element)v.get(559)).setAttribute("align","left" );
      ((Element)v.get(559)).setAttribute("cellspacing","0" );
      ((Element)v.get(559)).setAttribute("cellpadding","0" );
      ((Element)v.get(558)).appendChild((Element)v.get(559));

      /* Empieza nodo:560 / Elemento padre: 559   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(559)).appendChild((Element)v.get(560));

      /* Empieza nodo:561 / Elemento padre: 560   */
      v.add(doc.createElement("td"));
      ((Element)v.get(561)).setAttribute("colspan","4" );
      ((Element)v.get(560)).appendChild((Element)v.get(561));

      /* Empieza nodo:562 / Elemento padre: 561   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(562)).setAttribute("src","b.gif" );
      ((Element)v.get(562)).setAttribute("width","8" );
      ((Element)v.get(562)).setAttribute("height","309" );
      ((Element)v.get(561)).appendChild((Element)v.get(562));
      /* Termina nodo:562   */
      /* Termina nodo:561   */
      /* Termina nodo:560   */
      /* Termina nodo:559   */
      /* Termina nodo:558   */
      /* Termina nodo:557   */

      /* Empieza nodo:563 / Elemento padre: 549   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(549)).appendChild((Element)v.get(563));

      /* Empieza nodo:564 / Elemento padre: 563   */
      v.add(doc.createElement("td"));
      ((Element)v.get(563)).appendChild((Element)v.get(564));

      /* Empieza nodo:565 / Elemento padre: 564   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(565)).setAttribute("src","b.gif" );
      ((Element)v.get(564)).appendChild((Element)v.get(565));
      /* Termina nodo:565   */
      /* Termina nodo:564   */

      /* Empieza nodo:566 / Elemento padre: 563   */
      v.add(doc.createElement("td"));
      ((Element)v.get(563)).appendChild((Element)v.get(566));

      /* Empieza nodo:567 / Elemento padre: 566   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(566)).appendChild((Element)v.get(567));

      /* Empieza nodo:568 / Elemento padre: 567   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(568)).setAttribute("class","legend" );
      ((Element)v.get(567)).appendChild((Element)v.get(568));

      /* Empieza nodo:569 / Elemento padre: 568   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(569)).setAttribute("nombre","lblDatosLote" );
      ((Element)v.get(569)).setAttribute("alto","13" );
      ((Element)v.get(569)).setAttribute("filas","1" );
      ((Element)v.get(569)).setAttribute("valor","Datos del lote" );
      ((Element)v.get(569)).setAttribute("id","legend" );
      ((Element)v.get(569)).setAttribute("cod","00593" );
      ((Element)v.get(568)).appendChild((Element)v.get(569));
      /* Termina nodo:569   */
      /* Termina nodo:568   */

      /* Empieza nodo:570 / Elemento padre: 567   */
      v.add(doc.createElement("table"));
      ((Element)v.get(570)).setAttribute("width","100%" );
      ((Element)v.get(570)).setAttribute("border","0" );
      ((Element)v.get(570)).setAttribute("align","center" );
      ((Element)v.get(570)).setAttribute("cellspacing","0" );
      ((Element)v.get(570)).setAttribute("cellpadding","0" );
      ((Element)v.get(567)).appendChild((Element)v.get(570));

      /* Empieza nodo:571 / Elemento padre: 570   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(570)).appendChild((Element)v.get(571));

      /* Empieza nodo:572 / Elemento padre: 571   */
      v.add(doc.createElement("td"));
      ((Element)v.get(571)).appendChild((Element)v.get(572));

      /* Empieza nodo:573 / Elemento padre: 572   */
      v.add(doc.createElement("table"));
      ((Element)v.get(573)).setAttribute("width","100%" );
      ((Element)v.get(573)).setAttribute("align","left" );
      ((Element)v.get(573)).setAttribute("border","0" );
      ((Element)v.get(573)).setAttribute("cellspacing","0" );
      ((Element)v.get(573)).setAttribute("cellpadding","0" );
      ((Element)v.get(572)).appendChild((Element)v.get(573));

      /* Empieza nodo:574 / Elemento padre: 573   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(573)).appendChild((Element)v.get(574));

      /* Empieza nodo:575 / Elemento padre: 574   */
      v.add(doc.createElement("td"));
      ((Element)v.get(575)).setAttribute("colspan","4" );
      ((Element)v.get(574)).appendChild((Element)v.get(575));

      /* Empieza nodo:576 / Elemento padre: 575   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(576)).setAttribute("src","b.gif" );
      ((Element)v.get(576)).setAttribute("width","8" );
      ((Element)v.get(576)).setAttribute("height","8" );
      ((Element)v.get(575)).appendChild((Element)v.get(576));
      /* Termina nodo:576   */
      /* Termina nodo:575   */
      /* Termina nodo:574   */

      /* Empieza nodo:577 / Elemento padre: 573   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(573)).appendChild((Element)v.get(577));

      /* Empieza nodo:578 / Elemento padre: 577   */
      v.add(doc.createElement("td"));
      ((Element)v.get(577)).appendChild((Element)v.get(578));

      /* Empieza nodo:579 / Elemento padre: 578   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(579)).setAttribute("src","b.gif" );
      ((Element)v.get(578)).appendChild((Element)v.get(579));
      /* Termina nodo:579   */
      /* Termina nodo:578   */

      /* Empieza nodo:580 / Elemento padre: 577   */
      v.add(doc.createElement("td"));
      ((Element)v.get(577)).appendChild((Element)v.get(580));

      /* Empieza nodo:581 / Elemento padre: 580   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(580)).appendChild((Element)v.get(581));

      /* Empieza nodo:582 / Elemento padre: 581   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(582)).setAttribute("class","legend" );
      ((Element)v.get(581)).appendChild((Element)v.get(582));

      /* Empieza nodo:583 / Elemento padre: 582   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(583)).setAttribute("nombre","lblDatosProductosLote" );
      ((Element)v.get(583)).setAttribute("alto","13" );
      ((Element)v.get(583)).setAttribute("filas","1" );
      ((Element)v.get(583)).setAttribute("valor","" );
   }

   private void getXML2520(Document doc) {
      ((Element)v.get(583)).setAttribute("id","legend" );
      ((Element)v.get(583)).setAttribute("cod","00354" );
      ((Element)v.get(582)).appendChild((Element)v.get(583));
      /* Termina nodo:583   */
      /* Termina nodo:582   */

      /* Empieza nodo:584 / Elemento padre: 581   */
      v.add(doc.createElement("table"));
      ((Element)v.get(584)).setAttribute("width","100%" );
      ((Element)v.get(584)).setAttribute("border","0" );
      ((Element)v.get(584)).setAttribute("align","center" );
      ((Element)v.get(584)).setAttribute("cellspacing","0" );
      ((Element)v.get(584)).setAttribute("cellpadding","0" );
      ((Element)v.get(581)).appendChild((Element)v.get(584));

      /* Empieza nodo:585 / Elemento padre: 584   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(584)).appendChild((Element)v.get(585));

      /* Empieza nodo:586 / Elemento padre: 585   */
      v.add(doc.createElement("td"));
      ((Element)v.get(585)).appendChild((Element)v.get(586));

      /* Empieza nodo:587 / Elemento padre: 586   */
      v.add(doc.createElement("table"));
      ((Element)v.get(587)).setAttribute("width","673" );
      ((Element)v.get(587)).setAttribute("border","0" );
      ((Element)v.get(587)).setAttribute("align","left" );
      ((Element)v.get(587)).setAttribute("cellspacing","0" );
      ((Element)v.get(587)).setAttribute("cellpadding","0" );
      ((Element)v.get(586)).appendChild((Element)v.get(587));

      /* Empieza nodo:588 / Elemento padre: 587   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(587)).appendChild((Element)v.get(588));

      /* Empieza nodo:589 / Elemento padre: 588   */
      v.add(doc.createElement("td"));
      ((Element)v.get(589)).setAttribute("colspan","11" );
      ((Element)v.get(588)).appendChild((Element)v.get(589));

      /* Empieza nodo:590 / Elemento padre: 589   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(590)).setAttribute("src","b.gif" );
      ((Element)v.get(590)).setAttribute("width","8" );
      ((Element)v.get(590)).setAttribute("height","8" );
      ((Element)v.get(589)).appendChild((Element)v.get(590));
      /* Termina nodo:590   */
      /* Termina nodo:589   */
      /* Termina nodo:588   */

      /* Empieza nodo:591 / Elemento padre: 587   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(587)).appendChild((Element)v.get(591));

      /* Empieza nodo:592 / Elemento padre: 591   */
      v.add(doc.createElement("td"));
      ((Element)v.get(591)).appendChild((Element)v.get(592));

      /* Empieza nodo:593 / Elemento padre: 592   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(593)).setAttribute("src","b.gif" );
      ((Element)v.get(593)).setAttribute("width","8" );
      ((Element)v.get(593)).setAttribute("height","8" );
      ((Element)v.get(592)).appendChild((Element)v.get(593));
      /* Termina nodo:593   */
      /* Termina nodo:592   */

      /* Empieza nodo:594 / Elemento padre: 591   */
      v.add(doc.createElement("td"));
      ((Element)v.get(591)).appendChild((Element)v.get(594));

      /* Empieza nodo:595 / Elemento padre: 594   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(595)).setAttribute("nombre","lblCodProducto4" );
      ((Element)v.get(595)).setAttribute("alto","13" );
      ((Element)v.get(595)).setAttribute("filas","1" );
      ((Element)v.get(595)).setAttribute("valor","" );
      ((Element)v.get(595)).setAttribute("id","datosTitle" );
      ((Element)v.get(595)).setAttribute("cod","337" );
      ((Element)v.get(594)).appendChild((Element)v.get(595));
      /* Termina nodo:595   */
      /* Termina nodo:594   */

      /* Empieza nodo:596 / Elemento padre: 591   */
      v.add(doc.createElement("td"));
      ((Element)v.get(596)).setAttribute("width","100%" );
      ((Element)v.get(591)).appendChild((Element)v.get(596));

      /* Empieza nodo:597 / Elemento padre: 596   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(597)).setAttribute("src","b.gif" );
      ((Element)v.get(597)).setAttribute("width","8" );
      ((Element)v.get(597)).setAttribute("height","8" );
      ((Element)v.get(596)).appendChild((Element)v.get(597));
      /* Termina nodo:597   */
      /* Termina nodo:596   */

      /* Empieza nodo:598 / Elemento padre: 591   */
      v.add(doc.createElement("td"));
      ((Element)v.get(591)).appendChild((Element)v.get(598));

      /* Empieza nodo:599 / Elemento padre: 598   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(599)).setAttribute("src","b.gif" );
      ((Element)v.get(599)).setAttribute("width","8" );
      ((Element)v.get(599)).setAttribute("height","8" );
      ((Element)v.get(598)).appendChild((Element)v.get(599));
      /* Termina nodo:599   */
      /* Termina nodo:598   */

      /* Empieza nodo:600 / Elemento padre: 591   */
      v.add(doc.createElement("td"));
      ((Element)v.get(591)).appendChild((Element)v.get(600));

      /* Empieza nodo:601 / Elemento padre: 600   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(601)).setAttribute("nombre","lblIndCenServGar" );
      ((Element)v.get(601)).setAttribute("alto","25" );
      ((Element)v.get(601)).setAttribute("ancho","105" );
      ((Element)v.get(601)).setAttribute("filas","1" );
      ((Element)v.get(601)).setAttribute("valor","" );
      ((Element)v.get(601)).setAttribute("id","datosTitle" );
      ((Element)v.get(601)).setAttribute("cod","3184" );
      ((Element)v.get(600)).appendChild((Element)v.get(601));
      /* Termina nodo:601   */
      /* Termina nodo:600   */

      /* Empieza nodo:602 / Elemento padre: 591   */
      v.add(doc.createElement("td"));
      ((Element)v.get(591)).appendChild((Element)v.get(602));

      /* Empieza nodo:603 / Elemento padre: 602   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(603)).setAttribute("src","b.gif" );
      ((Element)v.get(603)).setAttribute("width","25" );
      ((Element)v.get(603)).setAttribute("height","8" );
      ((Element)v.get(602)).appendChild((Element)v.get(603));
      /* Termina nodo:603   */
      /* Termina nodo:602   */

      /* Empieza nodo:604 / Elemento padre: 591   */
      v.add(doc.createElement("td"));
      ((Element)v.get(591)).appendChild((Element)v.get(604));

      /* Empieza nodo:605 / Elemento padre: 604   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(605)).setAttribute("nombre","lblCenServGar" );
      ((Element)v.get(605)).setAttribute("alto","25" );
      ((Element)v.get(605)).setAttribute("ancho","100" );
      ((Element)v.get(605)).setAttribute("filas","1" );
   }

   private void getXML2610(Document doc) {
      ((Element)v.get(605)).setAttribute("valor","" );
      ((Element)v.get(605)).setAttribute("id","datosTitle" );
      ((Element)v.get(605)).setAttribute("cod","3185" );
      ((Element)v.get(604)).appendChild((Element)v.get(605));
      /* Termina nodo:605   */
      /* Termina nodo:604   */

      /* Empieza nodo:606 / Elemento padre: 591   */
      v.add(doc.createElement("td"));
      ((Element)v.get(606)).setAttribute("width","100%" );
      ((Element)v.get(591)).appendChild((Element)v.get(606));

      /* Empieza nodo:607 / Elemento padre: 606   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(607)).setAttribute("src","b.gif" );
      ((Element)v.get(607)).setAttribute("width","8" );
      ((Element)v.get(607)).setAttribute("height","8" );
      ((Element)v.get(606)).appendChild((Element)v.get(607));
      /* Termina nodo:607   */
      /* Termina nodo:606   */

      /* Empieza nodo:608 / Elemento padre: 591   */
      v.add(doc.createElement("td"));
      ((Element)v.get(591)).appendChild((Element)v.get(608));

      /* Empieza nodo:609 / Elemento padre: 608   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(609)).setAttribute("nombre","lblNumMeses" );
      ((Element)v.get(609)).setAttribute("alto","25" );
      ((Element)v.get(609)).setAttribute("ancho","80" );
      ((Element)v.get(609)).setAttribute("filas","1" );
      ((Element)v.get(609)).setAttribute("valor","" );
      ((Element)v.get(609)).setAttribute("id","datosTitle" );
      ((Element)v.get(609)).setAttribute("cod","3186" );
      ((Element)v.get(608)).appendChild((Element)v.get(609));
      /* Termina nodo:609   */
      /* Termina nodo:608   */

      /* Empieza nodo:610 / Elemento padre: 591   */
      v.add(doc.createElement("td"));
      ((Element)v.get(610)).setAttribute("width","100%" );
      ((Element)v.get(591)).appendChild((Element)v.get(610));

      /* Empieza nodo:611 / Elemento padre: 610   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(611)).setAttribute("src","b.gif" );
      ((Element)v.get(611)).setAttribute("width","8" );
      ((Element)v.get(611)).setAttribute("height","8" );
      ((Element)v.get(610)).appendChild((Element)v.get(611));
      /* Termina nodo:611   */
      /* Termina nodo:610   */

      /* Empieza nodo:612 / Elemento padre: 591   */
      v.add(doc.createElement("td"));
      ((Element)v.get(591)).appendChild((Element)v.get(612));

      /* Empieza nodo:613 / Elemento padre: 612   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(613)).setAttribute("nombre","lblObservaciones" );
      ((Element)v.get(613)).setAttribute("alto","13" );
      ((Element)v.get(613)).setAttribute("filas","1" );
      ((Element)v.get(613)).setAttribute("valor","" );
      ((Element)v.get(613)).setAttribute("id","datosTitle" );
      ((Element)v.get(613)).setAttribute("cod","169" );
      ((Element)v.get(612)).appendChild((Element)v.get(613));
      /* Termina nodo:613   */
      /* Termina nodo:612   */
      /* Termina nodo:591   */

      /* Empieza nodo:614 / Elemento padre: 587   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(587)).appendChild((Element)v.get(614));

      /* Empieza nodo:615 / Elemento padre: 614   */
      v.add(doc.createElement("td"));
      ((Element)v.get(614)).appendChild((Element)v.get(615));

      /* Empieza nodo:616 / Elemento padre: 615   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(616)).setAttribute("src","b.gif" );
      ((Element)v.get(616)).setAttribute("width","8" );
      ((Element)v.get(616)).setAttribute("height","8" );
      ((Element)v.get(615)).appendChild((Element)v.get(616));
      /* Termina nodo:616   */
      /* Termina nodo:615   */

      /* Empieza nodo:617 / Elemento padre: 614   */
      v.add(doc.createElement("td"));
      ((Element)v.get(617)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(614)).appendChild((Element)v.get(617));

      /* Empieza nodo:618 / Elemento padre: 617   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(618)).setAttribute("nombre","txtCodProducto" );
      ((Element)v.get(618)).setAttribute("id","datosCampos" );
      ((Element)v.get(618)).setAttribute("max","20" );
      ((Element)v.get(618)).setAttribute("tipo","" );
      ((Element)v.get(618)).setAttribute("onchange","" );
      ((Element)v.get(618)).setAttribute("req","S" );
      ((Element)v.get(618)).setAttribute("size","26" );
      ((Element)v.get(618)).setAttribute("valor","" );
      ((Element)v.get(618)).setAttribute("validacion","" );
      ((Element)v.get(617)).appendChild((Element)v.get(618));
      /* Termina nodo:618   */
      /* Termina nodo:617   */

      /* Empieza nodo:619 / Elemento padre: 614   */
      v.add(doc.createElement("td"));
      ((Element)v.get(614)).appendChild((Element)v.get(619));

      /* Empieza nodo:620 / Elemento padre: 619   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(620)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(620)).setAttribute("ID","botonContenido" );
      ((Element)v.get(620)).setAttribute("tipo","html" );
      ((Element)v.get(620)).setAttribute("accion","accionBuscarProducto();" );
      ((Element)v.get(620)).setAttribute("estado","false" );
      ((Element)v.get(620)).setAttribute("cod","1" );
      ((Element)v.get(619)).appendChild((Element)v.get(620));
      /* Termina nodo:620   */
      /* Termina nodo:619   */

      /* Empieza nodo:621 / Elemento padre: 614   */
      v.add(doc.createElement("td"));
      ((Element)v.get(621)).setAttribute("width","100%" );
      ((Element)v.get(614)).appendChild((Element)v.get(621));

      /* Empieza nodo:622 / Elemento padre: 621   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(622)).setAttribute("src","b.gif" );
      ((Element)v.get(622)).setAttribute("width","8" );
      ((Element)v.get(622)).setAttribute("height","8" );
      ((Element)v.get(621)).appendChild((Element)v.get(622));
      /* Termina nodo:622   */
      /* Termina nodo:621   */

      /* Empieza nodo:623 / Elemento padre: 614   */
      v.add(doc.createElement("td"));
      ((Element)v.get(623)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(623)).setAttribute("align","center" );
      ((Element)v.get(614)).appendChild((Element)v.get(623));

      /* Empieza nodo:624 / Elemento padre: 623   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(624)).setAttribute("nombre","ChkIndCenServGar" );
      ((Element)v.get(624)).setAttribute("id","datosCampos" );
      ((Element)v.get(624)).setAttribute("onclick","onclickIndCenServGar();" );
   }

   private void getXML2700(Document doc) {
      ((Element)v.get(624)).setAttribute("onshtab","focalizaShTab(2);" );
      ((Element)v.get(624)).setAttribute("check","N" );
      ((Element)v.get(623)).appendChild((Element)v.get(624));
      /* Termina nodo:624   */
      /* Termina nodo:623   */

      /* Empieza nodo:625 / Elemento padre: 614   */
      v.add(doc.createElement("td"));
      ((Element)v.get(614)).appendChild((Element)v.get(625));

      /* Empieza nodo:626 / Elemento padre: 625   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(626)).setAttribute("src","b.gif" );
      ((Element)v.get(626)).setAttribute("width","25" );
      ((Element)v.get(626)).setAttribute("height","8" );
      ((Element)v.get(625)).appendChild((Element)v.get(626));
      /* Termina nodo:626   */
      /* Termina nodo:625   */

      /* Empieza nodo:627 / Elemento padre: 614   */
      v.add(doc.createElement("td"));
      ((Element)v.get(627)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(614)).appendChild((Element)v.get(627));

      /* Empieza nodo:628 / Elemento padre: 627   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(628)).setAttribute("nombre","cbCenServGar" );
      ((Element)v.get(628)).setAttribute("id","datosCampos" );
      ((Element)v.get(628)).setAttribute("size","1" );
      ((Element)v.get(628)).setAttribute("multiple","N" );
      ((Element)v.get(628)).setAttribute("req","N" );
      ((Element)v.get(628)).setAttribute("onchange","" );
      ((Element)v.get(628)).setAttribute("valorinicial","" );
      ((Element)v.get(628)).setAttribute("textoinicial","" );
      ((Element)v.get(627)).appendChild((Element)v.get(628));

      /* Empieza nodo:629 / Elemento padre: 628   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(628)).appendChild((Element)v.get(629));
      /* Termina nodo:629   */
      /* Termina nodo:628   */
      /* Termina nodo:627   */

      /* Empieza nodo:630 / Elemento padre: 614   */
      v.add(doc.createElement("td"));
      ((Element)v.get(630)).setAttribute("width","100%" );
      ((Element)v.get(614)).appendChild((Element)v.get(630));

      /* Empieza nodo:631 / Elemento padre: 630   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(631)).setAttribute("src","b.gif" );
      ((Element)v.get(631)).setAttribute("width","8" );
      ((Element)v.get(631)).setAttribute("height","8" );
      ((Element)v.get(630)).appendChild((Element)v.get(631));
      /* Termina nodo:631   */
      /* Termina nodo:630   */

      /* Empieza nodo:632 / Elemento padre: 614   */
      v.add(doc.createElement("td"));
      ((Element)v.get(632)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(614)).appendChild((Element)v.get(632));

      /* Empieza nodo:633 / Elemento padre: 632   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(633)).setAttribute("nombre","txtNumMeses" );
      ((Element)v.get(633)).setAttribute("id","datosCampos" );
      ((Element)v.get(633)).setAttribute("max","4" );
      ((Element)v.get(633)).setAttribute("tipo","" );
      ((Element)v.get(633)).setAttribute("onblur","" );
      ((Element)v.get(633)).setAttribute("onchange","" );
      ((Element)v.get(633)).setAttribute("req","N" );
      ((Element)v.get(633)).setAttribute("size","6" );
      ((Element)v.get(633)).setAttribute("valor","" );
      ((Element)v.get(633)).setAttribute("validacion","" );
      ((Element)v.get(632)).appendChild((Element)v.get(633));
      /* Termina nodo:633   */
      /* Termina nodo:632   */

      /* Empieza nodo:634 / Elemento padre: 614   */
      v.add(doc.createElement("td"));
      ((Element)v.get(634)).setAttribute("width","100%" );
      ((Element)v.get(614)).appendChild((Element)v.get(634));

      /* Empieza nodo:635 / Elemento padre: 634   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(635)).setAttribute("src","b.gif" );
      ((Element)v.get(635)).setAttribute("width","8" );
      ((Element)v.get(635)).setAttribute("height","8" );
      ((Element)v.get(634)).appendChild((Element)v.get(635));
      /* Termina nodo:635   */
      /* Termina nodo:634   */

      /* Empieza nodo:636 / Elemento padre: 614   */
      v.add(doc.createElement("td"));
      ((Element)v.get(636)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(614)).appendChild((Element)v.get(636));

      /* Empieza nodo:637 / Elemento padre: 636   */
      v.add(doc.createElement("AREATEXTO"));
      ((Element)v.get(637)).setAttribute("cols","20" );
      ((Element)v.get(637)).setAttribute("id","datosCampos" );
      ((Element)v.get(637)).setAttribute("msjreq","" );
      ((Element)v.get(637)).setAttribute("nombre","areaObservaciones" );
      ((Element)v.get(637)).setAttribute("readonly","N" );
      ((Element)v.get(637)).setAttribute("req","N" );
      ((Element)v.get(637)).setAttribute("rows","3" );
      ((Element)v.get(637)).setAttribute("tabindex","2" );
      ((Element)v.get(637)).setAttribute("valor","" );
      ((Element)v.get(637)).setAttribute("max","80" );
      ((Element)v.get(636)).appendChild((Element)v.get(637));
      /* Termina nodo:637   */
      /* Termina nodo:636   */
      /* Termina nodo:614   */

      /* Empieza nodo:638 / Elemento padre: 587   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(587)).appendChild((Element)v.get(638));

      /* Empieza nodo:639 / Elemento padre: 638   */
      v.add(doc.createElement("td"));
      ((Element)v.get(639)).setAttribute("colspan","11" );
      ((Element)v.get(638)).appendChild((Element)v.get(639));

      /* Empieza nodo:640 / Elemento padre: 639   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(640)).setAttribute("src","b.gif" );
      ((Element)v.get(640)).setAttribute("width","8" );
      ((Element)v.get(640)).setAttribute("height","8" );
      ((Element)v.get(639)).appendChild((Element)v.get(640));
      /* Termina nodo:640   */
      /* Termina nodo:639   */
      /* Termina nodo:638   */
      /* Termina nodo:587   */
      /* Termina nodo:586   */
      /* Termina nodo:585   */

      /* Empieza nodo:641 / Elemento padre: 584   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(584)).appendChild((Element)v.get(641));

      /* Empieza nodo:642 / Elemento padre: 641   */
      v.add(doc.createElement("td"));
      ((Element)v.get(641)).appendChild((Element)v.get(642));

      /* Empieza nodo:643 / Elemento padre: 642   */
      v.add(doc.createElement("table"));
      ((Element)v.get(643)).setAttribute("width","673" );
      ((Element)v.get(643)).setAttribute("border","0" );
      ((Element)v.get(643)).setAttribute("align","left" );
      ((Element)v.get(643)).setAttribute("cellspacing","0" );
   }

   private void getXML2790(Document doc) {
      ((Element)v.get(643)).setAttribute("cellpadding","0" );
      ((Element)v.get(642)).appendChild((Element)v.get(643));

      /* Empieza nodo:644 / Elemento padre: 643   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(643)).appendChild((Element)v.get(644));

      /* Empieza nodo:645 / Elemento padre: 644   */
      v.add(doc.createElement("td"));
      ((Element)v.get(644)).appendChild((Element)v.get(645));

      /* Empieza nodo:646 / Elemento padre: 645   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(646)).setAttribute("src","b.gif" );
      ((Element)v.get(646)).setAttribute("width","8" );
      ((Element)v.get(646)).setAttribute("height","8" );
      ((Element)v.get(645)).appendChild((Element)v.get(646));
      /* Termina nodo:646   */
      /* Termina nodo:645   */

      /* Empieza nodo:647 / Elemento padre: 644   */
      v.add(doc.createElement("td"));
      ((Element)v.get(644)).appendChild((Element)v.get(647));

      /* Empieza nodo:648 / Elemento padre: 647   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(648)).setAttribute("nombre","lblNumUnidades4" );
      ((Element)v.get(648)).setAttribute("alto","13" );
      ((Element)v.get(648)).setAttribute("filas","1" );
      ((Element)v.get(648)).setAttribute("valor","" );
      ((Element)v.get(648)).setAttribute("id","datosTitle" );
      ((Element)v.get(648)).setAttribute("cod","495" );
      ((Element)v.get(647)).appendChild((Element)v.get(648));
      /* Termina nodo:648   */
      /* Termina nodo:647   */

      /* Empieza nodo:649 / Elemento padre: 644   */
      v.add(doc.createElement("td"));
      ((Element)v.get(644)).appendChild((Element)v.get(649));

      /* Empieza nodo:650 / Elemento padre: 649   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(650)).setAttribute("src","b.gif" );
      ((Element)v.get(650)).setAttribute("width","25" );
      ((Element)v.get(650)).setAttribute("height","8" );
      ((Element)v.get(649)).appendChild((Element)v.get(650));
      /* Termina nodo:650   */
      /* Termina nodo:649   */

      /* Empieza nodo:651 / Elemento padre: 644   */
      v.add(doc.createElement("td"));
      ((Element)v.get(644)).appendChild((Element)v.get(651));

      /* Empieza nodo:652 / Elemento padre: 651   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(652)).setAttribute("nombre","lblPrecioPublico4" );
      ((Element)v.get(652)).setAttribute("alto","13" );
      ((Element)v.get(652)).setAttribute("filas","1" );
      ((Element)v.get(652)).setAttribute("valor","" );
      ((Element)v.get(652)).setAttribute("id","datosTitle" );
      ((Element)v.get(652)).setAttribute("cod","1854" );
      ((Element)v.get(651)).appendChild((Element)v.get(652));
      /* Termina nodo:652   */
      /* Termina nodo:651   */

      /* Empieza nodo:653 / Elemento padre: 644   */
      v.add(doc.createElement("td"));
      ((Element)v.get(644)).appendChild((Element)v.get(653));

      /* Empieza nodo:654 / Elemento padre: 653   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(654)).setAttribute("src","b.gif" );
      ((Element)v.get(654)).setAttribute("width","25" );
      ((Element)v.get(654)).setAttribute("height","8" );
      ((Element)v.get(653)).appendChild((Element)v.get(654));
      /* Termina nodo:654   */
      /* Termina nodo:653   */

      /* Empieza nodo:655 / Elemento padre: 644   */
      v.add(doc.createElement("td"));
      ((Element)v.get(644)).appendChild((Element)v.get(655));

      /* Empieza nodo:656 / Elemento padre: 655   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(656)).setAttribute("nombre","lblDespachaArticulo4" );
      ((Element)v.get(656)).setAttribute("alto","13" );
      ((Element)v.get(656)).setAttribute("filas","1" );
      ((Element)v.get(656)).setAttribute("valor","" );
      ((Element)v.get(656)).setAttribute("id","datosTitle" );
      ((Element)v.get(656)).setAttribute("cod","1851" );
      ((Element)v.get(655)).appendChild((Element)v.get(656));
      /* Termina nodo:656   */
      /* Termina nodo:655   */

      /* Empieza nodo:657 / Elemento padre: 644   */
      v.add(doc.createElement("td"));
      ((Element)v.get(657)).setAttribute("width","100%" );
      ((Element)v.get(644)).appendChild((Element)v.get(657));

      /* Empieza nodo:658 / Elemento padre: 657   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(658)).setAttribute("src","b.gif" );
      ((Element)v.get(658)).setAttribute("width","8" );
      ((Element)v.get(658)).setAttribute("height","8" );
      ((Element)v.get(657)).appendChild((Element)v.get(658));
      /* Termina nodo:658   */
      /* Termina nodo:657   */

      /* Empieza nodo:659 / Elemento padre: 644   */
      v.add(doc.createElement("td"));
      ((Element)v.get(644)).appendChild((Element)v.get(659));

      /* Empieza nodo:660 / Elemento padre: 659   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(660)).setAttribute("nombre","lblTipoEntrega" );
      ((Element)v.get(660)).setAttribute("alto","13" );
      ((Element)v.get(660)).setAttribute("filas","1" );
      ((Element)v.get(660)).setAttribute("valor","" );
      ((Element)v.get(660)).setAttribute("id","datosTitle" );
      ((Element)v.get(660)).setAttribute("cod","3187" );
      ((Element)v.get(659)).appendChild((Element)v.get(660));
      /* Termina nodo:660   */
      /* Termina nodo:659   */

      /* Empieza nodo:661 / Elemento padre: 644   */
      v.add(doc.createElement("td"));
      ((Element)v.get(644)).appendChild((Element)v.get(661));

      /* Empieza nodo:662 / Elemento padre: 661   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(662)).setAttribute("src","b.gif" );
      ((Element)v.get(662)).setAttribute("width","25" );
      ((Element)v.get(662)).setAttribute("height","8" );
      ((Element)v.get(661)).appendChild((Element)v.get(662));
      /* Termina nodo:662   */
      /* Termina nodo:661   */

      /* Empieza nodo:663 / Elemento padre: 644   */
      v.add(doc.createElement("td"));
      ((Element)v.get(644)).appendChild((Element)v.get(663));

      /* Empieza nodo:664 / Elemento padre: 663   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(664)).setAttribute("nombre","lblCenServEntrega" );
      ((Element)v.get(664)).setAttribute("alto","13" );
      ((Element)v.get(664)).setAttribute("filas","1" );
      ((Element)v.get(664)).setAttribute("valor","" );
      ((Element)v.get(664)).setAttribute("id","datosTitle" );
      ((Element)v.get(664)).setAttribute("cod","3188" );
      ((Element)v.get(663)).appendChild((Element)v.get(664));
      /* Termina nodo:664   */
      /* Termina nodo:663   */

      /* Empieza nodo:665 / Elemento padre: 644   */
   }

   private void getXML2880(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(665)).setAttribute("width","100%" );
      ((Element)v.get(644)).appendChild((Element)v.get(665));

      /* Empieza nodo:666 / Elemento padre: 665   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(666)).setAttribute("src","b.gif" );
      ((Element)v.get(666)).setAttribute("width","8" );
      ((Element)v.get(666)).setAttribute("height","8" );
      ((Element)v.get(665)).appendChild((Element)v.get(666));
      /* Termina nodo:666   */
      /* Termina nodo:665   */
      /* Termina nodo:644   */

      /* Empieza nodo:667 / Elemento padre: 643   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(643)).appendChild((Element)v.get(667));

      /* Empieza nodo:668 / Elemento padre: 667   */
      v.add(doc.createElement("td"));
      ((Element)v.get(667)).appendChild((Element)v.get(668));

      /* Empieza nodo:669 / Elemento padre: 668   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(669)).setAttribute("src","b.gif" );
      ((Element)v.get(669)).setAttribute("width","8" );
      ((Element)v.get(669)).setAttribute("height","8" );
      ((Element)v.get(668)).appendChild((Element)v.get(669));
      /* Termina nodo:669   */
      /* Termina nodo:668   */

      /* Empieza nodo:670 / Elemento padre: 667   */
      v.add(doc.createElement("td"));
      ((Element)v.get(670)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(667)).appendChild((Element)v.get(670));

      /* Empieza nodo:671 / Elemento padre: 670   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(671)).setAttribute("nombre","txtNumUnidades4" );
      ((Element)v.get(671)).setAttribute("id","datosCampos" );
      ((Element)v.get(671)).setAttribute("max","5" );
      ((Element)v.get(671)).setAttribute("tipo","" );
      ((Element)v.get(671)).setAttribute("onchange","" );
      ((Element)v.get(671)).setAttribute("req","S" );
      ((Element)v.get(671)).setAttribute("size","4" );
      ((Element)v.get(671)).setAttribute("valor","" );
      ((Element)v.get(671)).setAttribute("validacion","" );
      ((Element)v.get(670)).appendChild((Element)v.get(671));
      /* Termina nodo:671   */
      /* Termina nodo:670   */

      /* Empieza nodo:672 / Elemento padre: 667   */
      v.add(doc.createElement("td"));
      ((Element)v.get(667)).appendChild((Element)v.get(672));

      /* Empieza nodo:673 / Elemento padre: 672   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(673)).setAttribute("src","b.gif" );
      ((Element)v.get(673)).setAttribute("width","25" );
      ((Element)v.get(673)).setAttribute("height","8" );
      ((Element)v.get(672)).appendChild((Element)v.get(673));
      /* Termina nodo:673   */
      /* Termina nodo:672   */

      /* Empieza nodo:674 / Elemento padre: 667   */
      v.add(doc.createElement("td"));
      ((Element)v.get(674)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(667)).appendChild((Element)v.get(674));

      /* Empieza nodo:675 / Elemento padre: 674   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(675)).setAttribute("nombre","txtPrecioPublico4" );
      ((Element)v.get(675)).setAttribute("id","datosCampos" );
      ((Element)v.get(675)).setAttribute("max","11" );
      ((Element)v.get(675)).setAttribute("tipo","" );
      ((Element)v.get(675)).setAttribute("onchange","" );
      ((Element)v.get(675)).setAttribute("req","S" );
      ((Element)v.get(675)).setAttribute("size","12" );
      ((Element)v.get(675)).setAttribute("valor","" );
      ((Element)v.get(675)).setAttribute("validacion","" );
      ((Element)v.get(674)).appendChild((Element)v.get(675));
      /* Termina nodo:675   */
      /* Termina nodo:674   */

      /* Empieza nodo:676 / Elemento padre: 667   */
      v.add(doc.createElement("td"));
      ((Element)v.get(667)).appendChild((Element)v.get(676));

      /* Empieza nodo:677 / Elemento padre: 676   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(677)).setAttribute("src","b.gif" );
      ((Element)v.get(677)).setAttribute("width","25" );
      ((Element)v.get(677)).setAttribute("height","8" );
      ((Element)v.get(676)).appendChild((Element)v.get(677));
      /* Termina nodo:677   */
      /* Termina nodo:676   */

      /* Empieza nodo:678 / Elemento padre: 667   */
      v.add(doc.createElement("td"));
      ((Element)v.get(678)).setAttribute("valing","bottom" );
      ((Element)v.get(667)).appendChild((Element)v.get(678));

      /* Empieza nodo:679 / Elemento padre: 678   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(679)).setAttribute("nombre","ckArticuloDespacha4" );
      ((Element)v.get(679)).setAttribute("id","datosCampos" );
      ((Element)v.get(679)).setAttribute("onclick","" );
      ((Element)v.get(679)).setAttribute("check","S" );
      ((Element)v.get(678)).appendChild((Element)v.get(679));
      /* Termina nodo:679   */
      /* Termina nodo:678   */

      /* Empieza nodo:680 / Elemento padre: 667   */
      v.add(doc.createElement("td"));
      ((Element)v.get(680)).setAttribute("width","100%" );
      ((Element)v.get(667)).appendChild((Element)v.get(680));

      /* Empieza nodo:681 / Elemento padre: 680   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(681)).setAttribute("src","b.gif" );
      ((Element)v.get(681)).setAttribute("width","8" );
      ((Element)v.get(681)).setAttribute("height","8" );
      ((Element)v.get(680)).appendChild((Element)v.get(681));
      /* Termina nodo:681   */
      /* Termina nodo:680   */

      /* Empieza nodo:682 / Elemento padre: 667   */
      v.add(doc.createElement("td"));
      ((Element)v.get(682)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(667)).appendChild((Element)v.get(682));

      /* Empieza nodo:683 / Elemento padre: 682   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(683)).setAttribute("nombre","rdTipoEntrega" );
      ((Element)v.get(683)).setAttribute("onclick","onclickRdTipoEntrega();" );
      ((Element)v.get(683)).setAttribute("tipo","V" );
      ((Element)v.get(683)).setAttribute("req","N" );
      ((Element)v.get(682)).appendChild((Element)v.get(683));

      /* Empieza nodo:684 / Elemento padre: 683   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(684)).setAttribute("id","datosTitle" );
      ((Element)v.get(684)).setAttribute("valor","C" );
      ((Element)v.get(684)).setAttribute("cod","3190" );
      ((Element)v.get(683)).appendChild((Element)v.get(684));
      /* Termina nodo:684   */

      /* Empieza nodo:685 / Elemento padre: 683   */
   }

   private void getXML2970(Document doc) {
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(685)).setAttribute("id","datosTitle" );
      ((Element)v.get(685)).setAttribute("valor","B" );
      ((Element)v.get(685)).setAttribute("cod","3189" );
      ((Element)v.get(685)).setAttribute("check","S" );
      ((Element)v.get(683)).appendChild((Element)v.get(685));
      /* Termina nodo:685   */
      /* Termina nodo:683   */
      /* Termina nodo:682   */

      /* Empieza nodo:686 / Elemento padre: 667   */
      v.add(doc.createElement("td"));
      ((Element)v.get(667)).appendChild((Element)v.get(686));

      /* Empieza nodo:687 / Elemento padre: 686   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(687)).setAttribute("src","b.gif" );
      ((Element)v.get(687)).setAttribute("width","25" );
      ((Element)v.get(687)).setAttribute("height","8" );
      ((Element)v.get(686)).appendChild((Element)v.get(687));
      /* Termina nodo:687   */
      /* Termina nodo:686   */

      /* Empieza nodo:688 / Elemento padre: 667   */
      v.add(doc.createElement("td"));
      ((Element)v.get(688)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(667)).appendChild((Element)v.get(688));

      /* Empieza nodo:689 / Elemento padre: 688   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(689)).setAttribute("nombre","cbCenServEntrega" );
      ((Element)v.get(689)).setAttribute("id","datosCampos" );
      ((Element)v.get(689)).setAttribute("size","1" );
      ((Element)v.get(689)).setAttribute("multiple","N" );
      ((Element)v.get(689)).setAttribute("req","N" );
      ((Element)v.get(689)).setAttribute("onchange","" );
      ((Element)v.get(689)).setAttribute("valorinicial","" );
      ((Element)v.get(689)).setAttribute("textoinicial","" );
      ((Element)v.get(688)).appendChild((Element)v.get(689));

      /* Empieza nodo:690 / Elemento padre: 689   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(689)).appendChild((Element)v.get(690));
      /* Termina nodo:690   */
      /* Termina nodo:689   */
      /* Termina nodo:688   */

      /* Empieza nodo:691 / Elemento padre: 667   */
      v.add(doc.createElement("td"));
      ((Element)v.get(691)).setAttribute("width","100%" );
      ((Element)v.get(667)).appendChild((Element)v.get(691));

      /* Empieza nodo:692 / Elemento padre: 691   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(692)).setAttribute("src","b.gif" );
      ((Element)v.get(692)).setAttribute("width","8" );
      ((Element)v.get(692)).setAttribute("height","8" );
      ((Element)v.get(691)).appendChild((Element)v.get(692));
      /* Termina nodo:692   */
      /* Termina nodo:691   */
      /* Termina nodo:667   */

      /* Empieza nodo:693 / Elemento padre: 643   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(643)).appendChild((Element)v.get(693));

      /* Empieza nodo:694 / Elemento padre: 693   */
      v.add(doc.createElement("td"));
      ((Element)v.get(694)).setAttribute("colspan","11" );
      ((Element)v.get(693)).appendChild((Element)v.get(694));

      /* Empieza nodo:695 / Elemento padre: 694   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(695)).setAttribute("src","b.gif" );
      ((Element)v.get(695)).setAttribute("width","8" );
      ((Element)v.get(695)).setAttribute("height","8" );
      ((Element)v.get(694)).appendChild((Element)v.get(695));
      /* Termina nodo:695   */
      /* Termina nodo:694   */
      /* Termina nodo:693   */
      /* Termina nodo:643   */
      /* Termina nodo:642   */
      /* Termina nodo:641   */
      /* Termina nodo:584   */
      /* Termina nodo:581   */
      /* Termina nodo:580   */

      /* Empieza nodo:696 / Elemento padre: 577   */
      v.add(doc.createElement("td"));
      ((Element)v.get(577)).appendChild((Element)v.get(696));

      /* Empieza nodo:697 / Elemento padre: 696   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(697)).setAttribute("src","b.gif" );
      ((Element)v.get(696)).appendChild((Element)v.get(697));
      /* Termina nodo:697   */
      /* Termina nodo:696   */
      /* Termina nodo:577   */

      /* Empieza nodo:698 / Elemento padre: 573   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(573)).appendChild((Element)v.get(698));

      /* Empieza nodo:699 / Elemento padre: 698   */
      v.add(doc.createElement("td"));
      ((Element)v.get(698)).appendChild((Element)v.get(699));

      /* Empieza nodo:700 / Elemento padre: 699   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(700)).setAttribute("src","b.gif" );
      ((Element)v.get(699)).appendChild((Element)v.get(700));
      /* Termina nodo:700   */
      /* Termina nodo:699   */

      /* Empieza nodo:701 / Elemento padre: 698   */
      v.add(doc.createElement("td"));
      ((Element)v.get(698)).appendChild((Element)v.get(701));

      /* Empieza nodo:702 / Elemento padre: 701   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(701)).appendChild((Element)v.get(702));

      /* Empieza nodo:703 / Elemento padre: 702   */
      v.add(doc.createElement("table"));
      ((Element)v.get(703)).setAttribute("width","100%" );
      ((Element)v.get(703)).setAttribute("border","0" );
      ((Element)v.get(703)).setAttribute("align","center" );
      ((Element)v.get(703)).setAttribute("cellspacing","0" );
      ((Element)v.get(703)).setAttribute("cellpadding","0" );
      ((Element)v.get(702)).appendChild((Element)v.get(703));

      /* Empieza nodo:704 / Elemento padre: 703   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(703)).appendChild((Element)v.get(704));

      /* Empieza nodo:705 / Elemento padre: 704   */
      v.add(doc.createElement("td"));
      ((Element)v.get(705)).setAttribute("class","botonera" );
      ((Element)v.get(704)).appendChild((Element)v.get(705));

      /* Empieza nodo:706 / Elemento padre: 705   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(706)).setAttribute("nombre","btnAnadirProductos" );
      ((Element)v.get(706)).setAttribute("ID","botonContenido" );
      ((Element)v.get(706)).setAttribute("tipo","html" );
      ((Element)v.get(706)).setAttribute("accion","accionAniadirProductoLote();" );
      ((Element)v.get(706)).setAttribute("estado","false" );
      ((Element)v.get(706)).setAttribute("cod","404" );
      ((Element)v.get(705)).appendChild((Element)v.get(706));
      /* Termina nodo:706   */
      /* Termina nodo:705   */
      /* Termina nodo:704   */
      /* Termina nodo:703   */
      /* Termina nodo:702   */
      /* Termina nodo:701   */

      /* Empieza nodo:707 / Elemento padre: 698   */
      v.add(doc.createElement("td"));
      ((Element)v.get(698)).appendChild((Element)v.get(707));

      /* Empieza nodo:708 / Elemento padre: 707   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(708)).setAttribute("src","b.gif" );
      ((Element)v.get(708)).setAttribute("width","8" );
      ((Element)v.get(708)).setAttribute("height","12" );
      ((Element)v.get(707)).appendChild((Element)v.get(708));
      /* Termina nodo:708   */
      /* Termina nodo:707   */
      /* Termina nodo:698   */

      /* Empieza nodo:709 / Elemento padre: 573   */
      v.add(doc.createElement("tr"));
   }

   private void getXML3060(Document doc) {
      ((Element)v.get(573)).appendChild((Element)v.get(709));

      /* Empieza nodo:710 / Elemento padre: 709   */
      v.add(doc.createElement("td"));
      ((Element)v.get(710)).setAttribute("width","12" );
      ((Element)v.get(710)).setAttribute("align","center" );
      ((Element)v.get(709)).appendChild((Element)v.get(710));

      /* Empieza nodo:711 / Elemento padre: 710   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(711)).setAttribute("src","b.gif" );
      ((Element)v.get(711)).setAttribute("width","12" );
      ((Element)v.get(711)).setAttribute("height","318" );
      ((Element)v.get(710)).appendChild((Element)v.get(711));
      /* Termina nodo:711   */
      /* Termina nodo:710   */

      /* Empieza nodo:712 / Elemento padre: 709   */
      v.add(doc.createElement("td"));
      ((Element)v.get(712)).setAttribute("width","756" );
      ((Element)v.get(709)).appendChild((Element)v.get(712));

      /* Empieza nodo:713 / Elemento padre: 712   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(713)).setAttribute("src","b.gif" );
      ((Element)v.get(712)).appendChild((Element)v.get(713));
      /* Termina nodo:713   */
      /* Termina nodo:712   */

      /* Empieza nodo:714 / Elemento padre: 709   */
      v.add(doc.createElement("td"));
      ((Element)v.get(714)).setAttribute("width","12" );
      ((Element)v.get(709)).appendChild((Element)v.get(714));

      /* Empieza nodo:715 / Elemento padre: 714   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(715)).setAttribute("src","b.gif" );
      ((Element)v.get(715)).setAttribute("width","12" );
      ((Element)v.get(715)).setAttribute("height","1" );
      ((Element)v.get(714)).appendChild((Element)v.get(715));
      /* Termina nodo:715   */
      /* Termina nodo:714   */
      /* Termina nodo:709   */
      /* Termina nodo:573   */
      /* Termina nodo:572   */
      /* Termina nodo:571   */

      /* Empieza nodo:716 / Elemento padre: 570   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(570)).appendChild((Element)v.get(716));

      /* Empieza nodo:717 / Elemento padre: 716   */
      v.add(doc.createElement("td"));
      ((Element)v.get(716)).appendChild((Element)v.get(717));

      /* Empieza nodo:718 / Elemento padre: 717   */
      v.add(doc.createElement("table"));
      ((Element)v.get(718)).setAttribute("width","100%" );
      ((Element)v.get(718)).setAttribute("align","left" );
      ((Element)v.get(718)).setAttribute("border","0" );
      ((Element)v.get(718)).setAttribute("cellspacing","0" );
      ((Element)v.get(718)).setAttribute("cellpadding","0" );
      ((Element)v.get(717)).appendChild((Element)v.get(718));

      /* Empieza nodo:719 / Elemento padre: 718   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(718)).appendChild((Element)v.get(719));

      /* Empieza nodo:720 / Elemento padre: 719   */
      v.add(doc.createElement("td"));
      ((Element)v.get(720)).setAttribute("colspan","4" );
      ((Element)v.get(719)).appendChild((Element)v.get(720));

      /* Empieza nodo:721 / Elemento padre: 720   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(721)).setAttribute("src","b.gif" );
      ((Element)v.get(721)).setAttribute("width","8" );
      ((Element)v.get(721)).setAttribute("height","8" );
      ((Element)v.get(720)).appendChild((Element)v.get(721));
      /* Termina nodo:721   */
      /* Termina nodo:720   */
      /* Termina nodo:719   */

      /* Empieza nodo:722 / Elemento padre: 718   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(718)).appendChild((Element)v.get(722));

      /* Empieza nodo:723 / Elemento padre: 722   */
      v.add(doc.createElement("td"));
      ((Element)v.get(722)).appendChild((Element)v.get(723));

      /* Empieza nodo:724 / Elemento padre: 723   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(724)).setAttribute("src","b.gif" );
      ((Element)v.get(723)).appendChild((Element)v.get(724));
      /* Termina nodo:724   */
      /* Termina nodo:723   */

      /* Empieza nodo:725 / Elemento padre: 722   */
      v.add(doc.createElement("td"));
      ((Element)v.get(722)).appendChild((Element)v.get(725));

      /* Empieza nodo:726 / Elemento padre: 725   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(725)).appendChild((Element)v.get(726));

      /* Empieza nodo:727 / Elemento padre: 726   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(727)).setAttribute("class","legend" );
      ((Element)v.get(726)).appendChild((Element)v.get(727));

      /* Empieza nodo:728 / Elemento padre: 727   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(728)).setAttribute("nombre","lblOtrosDatos4" );
      ((Element)v.get(728)).setAttribute("alto","13" );
      ((Element)v.get(728)).setAttribute("filas","1" );
      ((Element)v.get(728)).setAttribute("valor","" );
      ((Element)v.get(728)).setAttribute("id","legend" );
      ((Element)v.get(728)).setAttribute("cod","00167" );
      ((Element)v.get(727)).appendChild((Element)v.get(728));
      /* Termina nodo:728   */
      /* Termina nodo:727   */

      /* Empieza nodo:729 / Elemento padre: 726   */
      v.add(doc.createElement("table"));
      ((Element)v.get(729)).setAttribute("width","100%" );
      ((Element)v.get(729)).setAttribute("border","0" );
      ((Element)v.get(729)).setAttribute("align","center" );
      ((Element)v.get(729)).setAttribute("cellspacing","0" );
      ((Element)v.get(729)).setAttribute("cellpadding","0" );
      ((Element)v.get(726)).appendChild((Element)v.get(729));

      /* Empieza nodo:730 / Elemento padre: 729   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(729)).appendChild((Element)v.get(730));

      /* Empieza nodo:731 / Elemento padre: 730   */
      v.add(doc.createElement("td"));
      ((Element)v.get(730)).appendChild((Element)v.get(731));

      /* Empieza nodo:732 / Elemento padre: 731   */
      v.add(doc.createElement("table"));
      ((Element)v.get(732)).setAttribute("width","673" );
      ((Element)v.get(732)).setAttribute("border","0" );
      ((Element)v.get(732)).setAttribute("align","left" );
      ((Element)v.get(732)).setAttribute("cellspacing","0" );
      ((Element)v.get(732)).setAttribute("cellpadding","0" );
      ((Element)v.get(731)).appendChild((Element)v.get(732));

      /* Empieza nodo:733 / Elemento padre: 732   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(732)).appendChild((Element)v.get(733));

      /* Empieza nodo:734 / Elemento padre: 733   */
      v.add(doc.createElement("td"));
      ((Element)v.get(734)).setAttribute("colspan","4" );
      ((Element)v.get(733)).appendChild((Element)v.get(734));

      /* Empieza nodo:735 / Elemento padre: 734   */
   }

   private void getXML3150(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(735)).setAttribute("src","b.gif" );
      ((Element)v.get(735)).setAttribute("width","8" );
      ((Element)v.get(735)).setAttribute("height","8" );
      ((Element)v.get(734)).appendChild((Element)v.get(735));
      /* Termina nodo:735   */
      /* Termina nodo:734   */
      /* Termina nodo:733   */

      /* Empieza nodo:736 / Elemento padre: 732   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(732)).appendChild((Element)v.get(736));

      /* Empieza nodo:737 / Elemento padre: 736   */
      v.add(doc.createElement("td"));
      ((Element)v.get(736)).appendChild((Element)v.get(737));

      /* Empieza nodo:738 / Elemento padre: 737   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(738)).setAttribute("src","b.gif" );
      ((Element)v.get(738)).setAttribute("width","8" );
      ((Element)v.get(738)).setAttribute("height","8" );
      ((Element)v.get(737)).appendChild((Element)v.get(738));
      /* Termina nodo:738   */
      /* Termina nodo:737   */

      /* Empieza nodo:739 / Elemento padre: 736   */
      v.add(doc.createElement("td"));
      ((Element)v.get(736)).appendChild((Element)v.get(739));

      /* Empieza nodo:740 / Elemento padre: 739   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(740)).setAttribute("nombre","lblNumPremio4" );
      ((Element)v.get(740)).setAttribute("alto","13" );
      ((Element)v.get(740)).setAttribute("filas","1" );
      ((Element)v.get(740)).setAttribute("valor","" );
      ((Element)v.get(740)).setAttribute("id","datosTitle" );
      ((Element)v.get(740)).setAttribute("cod","1691" );
      ((Element)v.get(739)).appendChild((Element)v.get(740));
      /* Termina nodo:740   */
      /* Termina nodo:739   */

      /* Empieza nodo:741 / Elemento padre: 736   */
      v.add(doc.createElement("td"));
      ((Element)v.get(736)).appendChild((Element)v.get(741));

      /* Empieza nodo:742 / Elemento padre: 741   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(742)).setAttribute("src","b.gif" );
      ((Element)v.get(742)).setAttribute("width","25" );
      ((Element)v.get(742)).setAttribute("height","8" );
      ((Element)v.get(741)).appendChild((Element)v.get(742));
      /* Termina nodo:742   */
      /* Termina nodo:741   */

      /* Empieza nodo:743 / Elemento padre: 736   */
      v.add(doc.createElement("td"));
      ((Element)v.get(736)).appendChild((Element)v.get(743));

      /* Empieza nodo:744 / Elemento padre: 743   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(744)).setAttribute("nombre","lblDescripcionLote4" );
      ((Element)v.get(744)).setAttribute("alto","13" );
      ((Element)v.get(744)).setAttribute("filas","1" );
      ((Element)v.get(744)).setAttribute("valor","" );
      ((Element)v.get(744)).setAttribute("id","datosTitle" );
      ((Element)v.get(744)).setAttribute("cod","844" );
      ((Element)v.get(743)).appendChild((Element)v.get(744));
      /* Termina nodo:744   */
      /* Termina nodo:743   */

      /* Empieza nodo:745 / Elemento padre: 736   */
      v.add(doc.createElement("td"));
      ((Element)v.get(745)).setAttribute("width","100%" );
      ((Element)v.get(736)).appendChild((Element)v.get(745));

      /* Empieza nodo:746 / Elemento padre: 745   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(746)).setAttribute("src","b.gif" );
      ((Element)v.get(746)).setAttribute("width","8" );
      ((Element)v.get(746)).setAttribute("height","8" );
      ((Element)v.get(745)).appendChild((Element)v.get(746));
      /* Termina nodo:746   */
      /* Termina nodo:745   */
      /* Termina nodo:736   */

      /* Empieza nodo:747 / Elemento padre: 732   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(732)).appendChild((Element)v.get(747));

      /* Empieza nodo:748 / Elemento padre: 747   */
      v.add(doc.createElement("td"));
      ((Element)v.get(747)).appendChild((Element)v.get(748));

      /* Empieza nodo:749 / Elemento padre: 748   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(749)).setAttribute("src","b.gif" );
      ((Element)v.get(749)).setAttribute("width","8" );
      ((Element)v.get(749)).setAttribute("height","8" );
      ((Element)v.get(748)).appendChild((Element)v.get(749));
      /* Termina nodo:749   */
      /* Termina nodo:748   */

      /* Empieza nodo:750 / Elemento padre: 747   */
      v.add(doc.createElement("td"));
      ((Element)v.get(747)).appendChild((Element)v.get(750));

      /* Empieza nodo:751 / Elemento padre: 750   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(751)).setAttribute("nombre","lbNumPremio4" );
      ((Element)v.get(751)).setAttribute("alto","13" );
      ((Element)v.get(751)).setAttribute("filas","1" );
      ((Element)v.get(751)).setAttribute("id","datosCampos" );
      ((Element)v.get(751)).setAttribute("valor","" );
      ((Element)v.get(750)).appendChild((Element)v.get(751));
      /* Termina nodo:751   */
      /* Termina nodo:750   */

      /* Empieza nodo:752 / Elemento padre: 747   */
      v.add(doc.createElement("td"));
      ((Element)v.get(747)).appendChild((Element)v.get(752));

      /* Empieza nodo:753 / Elemento padre: 752   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(753)).setAttribute("src","b.gif" );
      ((Element)v.get(753)).setAttribute("width","25" );
      ((Element)v.get(753)).setAttribute("height","8" );
      ((Element)v.get(752)).appendChild((Element)v.get(753));
      /* Termina nodo:753   */
      /* Termina nodo:752   */

      /* Empieza nodo:754 / Elemento padre: 747   */
      v.add(doc.createElement("td"));
      ((Element)v.get(754)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(747)).appendChild((Element)v.get(754));

      /* Empieza nodo:755 / Elemento padre: 754   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(755)).setAttribute("nombre","txtDescripcionLote4" );
      ((Element)v.get(755)).setAttribute("id","datosCampos" );
      ((Element)v.get(755)).setAttribute("max","50" );
      ((Element)v.get(755)).setAttribute("tipo","" );
      ((Element)v.get(755)).setAttribute("onchange","" );
      ((Element)v.get(755)).setAttribute("req","N" );
      ((Element)v.get(755)).setAttribute("size","50" );
      ((Element)v.get(755)).setAttribute("valor","" );
      ((Element)v.get(755)).setAttribute("validacion","" );
      ((Element)v.get(754)).appendChild((Element)v.get(755));
      /* Termina nodo:755   */
      /* Termina nodo:754   */

      /* Empieza nodo:756 / Elemento padre: 747   */
      v.add(doc.createElement("td"));
      ((Element)v.get(756)).setAttribute("width","100%" );
   }

   private void getXML3240(Document doc) {
      ((Element)v.get(747)).appendChild((Element)v.get(756));

      /* Empieza nodo:757 / Elemento padre: 756   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(757)).setAttribute("src","b.gif" );
      ((Element)v.get(757)).setAttribute("width","8" );
      ((Element)v.get(757)).setAttribute("height","8" );
      ((Element)v.get(756)).appendChild((Element)v.get(757));
      /* Termina nodo:757   */
      /* Termina nodo:756   */
      /* Termina nodo:747   */

      /* Empieza nodo:758 / Elemento padre: 732   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(732)).appendChild((Element)v.get(758));

      /* Empieza nodo:759 / Elemento padre: 758   */
      v.add(doc.createElement("td"));
      ((Element)v.get(759)).setAttribute("colspan","4" );
      ((Element)v.get(758)).appendChild((Element)v.get(759));

      /* Empieza nodo:760 / Elemento padre: 759   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(760)).setAttribute("src","b.gif" );
      ((Element)v.get(760)).setAttribute("width","8" );
      ((Element)v.get(760)).setAttribute("height","8" );
      ((Element)v.get(759)).appendChild((Element)v.get(760));
      /* Termina nodo:760   */
      /* Termina nodo:759   */
      /* Termina nodo:758   */
      /* Termina nodo:732   */
      /* Termina nodo:731   */
      /* Termina nodo:730   */
      /* Termina nodo:729   */
      /* Termina nodo:726   */
      /* Termina nodo:725   */

      /* Empieza nodo:761 / Elemento padre: 722   */
      v.add(doc.createElement("td"));
      ((Element)v.get(722)).appendChild((Element)v.get(761));

      /* Empieza nodo:762 / Elemento padre: 761   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(762)).setAttribute("src","b.gif" );
      ((Element)v.get(761)).appendChild((Element)v.get(762));
      /* Termina nodo:762   */
      /* Termina nodo:761   */
      /* Termina nodo:722   */

      /* Empieza nodo:763 / Elemento padre: 718   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(718)).appendChild((Element)v.get(763));

      /* Empieza nodo:764 / Elemento padre: 763   */
      v.add(doc.createElement("td"));
      ((Element)v.get(764)).setAttribute("width","12" );
      ((Element)v.get(764)).setAttribute("align","center" );
      ((Element)v.get(763)).appendChild((Element)v.get(764));

      /* Empieza nodo:765 / Elemento padre: 764   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(765)).setAttribute("src","b.gif" );
      ((Element)v.get(765)).setAttribute("width","12" );
      ((Element)v.get(765)).setAttribute("height","12" );
      ((Element)v.get(764)).appendChild((Element)v.get(765));
      /* Termina nodo:765   */
      /* Termina nodo:764   */

      /* Empieza nodo:766 / Elemento padre: 763   */
      v.add(doc.createElement("td"));
      ((Element)v.get(766)).setAttribute("width","756" );
      ((Element)v.get(763)).appendChild((Element)v.get(766));

      /* Empieza nodo:767 / Elemento padre: 766   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(767)).setAttribute("src","b.gif" );
      ((Element)v.get(766)).appendChild((Element)v.get(767));
      /* Termina nodo:767   */
      /* Termina nodo:766   */

      /* Empieza nodo:768 / Elemento padre: 763   */
      v.add(doc.createElement("td"));
      ((Element)v.get(768)).setAttribute("width","12" );
      ((Element)v.get(763)).appendChild((Element)v.get(768));

      /* Empieza nodo:769 / Elemento padre: 768   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(769)).setAttribute("src","b.gif" );
      ((Element)v.get(769)).setAttribute("width","12" );
      ((Element)v.get(769)).setAttribute("height","1" );
      ((Element)v.get(768)).appendChild((Element)v.get(769));
      /* Termina nodo:769   */
      /* Termina nodo:768   */
      /* Termina nodo:763   */
      /* Termina nodo:718   */
      /* Termina nodo:717   */
      /* Termina nodo:716   */
      /* Termina nodo:570   */
      /* Termina nodo:567   */
      /* Termina nodo:566   */

      /* Empieza nodo:770 / Elemento padre: 563   */
      v.add(doc.createElement("td"));
      ((Element)v.get(563)).appendChild((Element)v.get(770));

      /* Empieza nodo:771 / Elemento padre: 770   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(771)).setAttribute("src","b.gif" );
      ((Element)v.get(770)).appendChild((Element)v.get(771));
      /* Termina nodo:771   */
      /* Termina nodo:770   */
      /* Termina nodo:563   */

      /* Empieza nodo:772 / Elemento padre: 549   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(549)).appendChild((Element)v.get(772));

      /* Empieza nodo:773 / Elemento padre: 772   */
      v.add(doc.createElement("td"));
      ((Element)v.get(772)).appendChild((Element)v.get(773));

      /* Empieza nodo:774 / Elemento padre: 773   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(774)).setAttribute("src","b.gif" );
      ((Element)v.get(773)).appendChild((Element)v.get(774));
      /* Termina nodo:774   */
      /* Termina nodo:773   */

      /* Empieza nodo:775 / Elemento padre: 772   */
      v.add(doc.createElement("td"));
      ((Element)v.get(772)).appendChild((Element)v.get(775));

      /* Empieza nodo:776 / Elemento padre: 775   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(775)).appendChild((Element)v.get(776));

      /* Empieza nodo:777 / Elemento padre: 776   */
      v.add(doc.createElement("table"));
      ((Element)v.get(777)).setAttribute("width","100%" );
      ((Element)v.get(777)).setAttribute("border","0" );
      ((Element)v.get(777)).setAttribute("align","center" );
      ((Element)v.get(777)).setAttribute("cellspacing","0" );
      ((Element)v.get(777)).setAttribute("cellpadding","0" );
      ((Element)v.get(776)).appendChild((Element)v.get(777));

      /* Empieza nodo:778 / Elemento padre: 777   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(777)).appendChild((Element)v.get(778));

      /* Empieza nodo:779 / Elemento padre: 778   */
      v.add(doc.createElement("td"));
      ((Element)v.get(779)).setAttribute("class","botonera" );
      ((Element)v.get(778)).appendChild((Element)v.get(779));

      /* Empieza nodo:780 / Elemento padre: 779   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(780)).setAttribute("nombre","btnAnadirLotes" );
      ((Element)v.get(780)).setAttribute("ID","botonContenido" );
      ((Element)v.get(780)).setAttribute("tipo","html" );
      ((Element)v.get(780)).setAttribute("accion","accionAniadirLotePremio();" );
      ((Element)v.get(780)).setAttribute("estado","false" );
      ((Element)v.get(780)).setAttribute("cod","404" );
      ((Element)v.get(779)).appendChild((Element)v.get(780));
      /* Termina nodo:780   */
      /* Termina nodo:779   */
      /* Termina nodo:778   */
      /* Termina nodo:777   */
      /* Termina nodo:776   */
      /* Termina nodo:775   */

      /* Empieza nodo:781 / Elemento padre: 772   */
      v.add(doc.createElement("td"));
      ((Element)v.get(772)).appendChild((Element)v.get(781));

      /* Empieza nodo:782 / Elemento padre: 781   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(782)).setAttribute("src","b.gif" );
      ((Element)v.get(782)).setAttribute("width","8" );
      ((Element)v.get(782)).setAttribute("height","12" );
      ((Element)v.get(781)).appendChild((Element)v.get(782));
      /* Termina nodo:782   */
      /* Termina nodo:781   */
      /* Termina nodo:772   */

      /* Empieza nodo:783 / Elemento padre: 549   */
      v.add(doc.createElement("tr"));
   }

   private void getXML3330(Document doc) {
      ((Element)v.get(549)).appendChild((Element)v.get(783));

      /* Empieza nodo:784 / Elemento padre: 783   */
      v.add(doc.createElement("td"));
      ((Element)v.get(784)).setAttribute("width","12" );
      ((Element)v.get(784)).setAttribute("align","center" );
      ((Element)v.get(783)).appendChild((Element)v.get(784));

      /* Empieza nodo:785 / Elemento padre: 784   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(785)).setAttribute("src","b.gif" );
      ((Element)v.get(785)).setAttribute("width","12" );
      ((Element)v.get(785)).setAttribute("height","12" );
      ((Element)v.get(784)).appendChild((Element)v.get(785));
      /* Termina nodo:785   */
      /* Termina nodo:784   */

      /* Empieza nodo:786 / Elemento padre: 783   */
      v.add(doc.createElement("td"));
      ((Element)v.get(786)).setAttribute("width","750" );
      ((Element)v.get(783)).appendChild((Element)v.get(786));

      /* Empieza nodo:787 / Elemento padre: 786   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(787)).setAttribute("src","b.gif" );
      ((Element)v.get(786)).appendChild((Element)v.get(787));
      /* Termina nodo:787   */
      /* Termina nodo:786   */

      /* Empieza nodo:788 / Elemento padre: 783   */
      v.add(doc.createElement("td"));
      ((Element)v.get(788)).setAttribute("width","12" );
      ((Element)v.get(783)).appendChild((Element)v.get(788));

      /* Empieza nodo:789 / Elemento padre: 788   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(789)).setAttribute("src","b.gif" );
      ((Element)v.get(789)).setAttribute("width","12" );
      ((Element)v.get(789)).setAttribute("height","1" );
      ((Element)v.get(788)).appendChild((Element)v.get(789));
      /* Termina nodo:789   */
      /* Termina nodo:788   */
      /* Termina nodo:783   */
      /* Termina nodo:549   */
      /* Termina nodo:546   */
      /* Termina nodo:545   */

      /* Empieza nodo:790 / Elemento padre: 542   */
      v.add(doc.createElement("td"));
      ((Element)v.get(542)).appendChild((Element)v.get(790));

      /* Empieza nodo:791 / Elemento padre: 790   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(791)).setAttribute("src","b.gif" );
      ((Element)v.get(790)).appendChild((Element)v.get(791));
      /* Termina nodo:791   */
      /* Termina nodo:790   */
      /* Termina nodo:542   */

      /* Empieza nodo:792 / Elemento padre: 534   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(534)).appendChild((Element)v.get(792));

      /* Empieza nodo:793 / Elemento padre: 792   */
      v.add(doc.createElement("td"));
      ((Element)v.get(792)).appendChild((Element)v.get(793));

      /* Empieza nodo:794 / Elemento padre: 793   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(794)).setAttribute("src","b.gif" );
      ((Element)v.get(793)).appendChild((Element)v.get(794));
      /* Termina nodo:794   */
      /* Termina nodo:793   */

      /* Empieza nodo:795 / Elemento padre: 792   */
      v.add(doc.createElement("td"));
      ((Element)v.get(792)).appendChild((Element)v.get(795));

      /* Empieza nodo:796 / Elemento padre: 795   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(795)).appendChild((Element)v.get(796));

      /* Empieza nodo:797 / Elemento padre: 796   */
      v.add(doc.createElement("table"));
      ((Element)v.get(797)).setAttribute("width","100%" );
      ((Element)v.get(797)).setAttribute("border","0" );
      ((Element)v.get(797)).setAttribute("align","center" );
      ((Element)v.get(797)).setAttribute("cellspacing","0" );
      ((Element)v.get(797)).setAttribute("cellpadding","0" );
      ((Element)v.get(796)).appendChild((Element)v.get(797));

      /* Empieza nodo:798 / Elemento padre: 797   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(797)).appendChild((Element)v.get(798));

      /* Empieza nodo:799 / Elemento padre: 798   */
      v.add(doc.createElement("td"));
      ((Element)v.get(799)).setAttribute("class","botonera" );
      ((Element)v.get(798)).appendChild((Element)v.get(799));

      /* Empieza nodo:800 / Elemento padre: 799   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(800)).setAttribute("nombre","btnEliminarProductos" );
      ((Element)v.get(800)).setAttribute("ID","botonContenido" );
      ((Element)v.get(800)).setAttribute("tipo","html" );
      ((Element)v.get(800)).setAttribute("accion","accionEliminarProductos();" );
      ((Element)v.get(800)).setAttribute("estado","false" );
      ((Element)v.get(800)).setAttribute("cod","2459" );
      ((Element)v.get(799)).appendChild((Element)v.get(800));
      /* Termina nodo:800   */

      /* Empieza nodo:801 / Elemento padre: 799   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(801)).setAttribute("nombre","btnEliminarLotes" );
      ((Element)v.get(801)).setAttribute("ID","botonContenido" );
      ((Element)v.get(801)).setAttribute("tipo","html" );
      ((Element)v.get(801)).setAttribute("accion","accionEliminarLotes();" );
      ((Element)v.get(801)).setAttribute("estado","false" );
      ((Element)v.get(801)).setAttribute("cod","2458" );
      ((Element)v.get(799)).appendChild((Element)v.get(801));
      /* Termina nodo:801   */

      /* Empieza nodo:802 / Elemento padre: 799   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(802)).setAttribute("nombre","btnAceptar3" );
      ((Element)v.get(802)).setAttribute("ID","botonContenido" );
      ((Element)v.get(802)).setAttribute("tipo","html" );
      ((Element)v.get(802)).setAttribute("accion","accionAceptar(get('formulario.OID_TIPO_PREMIO_ARTICULO'));" );
      ((Element)v.get(802)).setAttribute("estado","false" );
      ((Element)v.get(802)).setAttribute("cod","12" );
      ((Element)v.get(799)).appendChild((Element)v.get(802));
      /* Termina nodo:802   */
      /* Termina nodo:799   */
      /* Termina nodo:798   */
      /* Termina nodo:797   */
      /* Termina nodo:796   */
      /* Termina nodo:795   */

      /* Empieza nodo:803 / Elemento padre: 792   */
      v.add(doc.createElement("td"));
      ((Element)v.get(792)).appendChild((Element)v.get(803));

      /* Empieza nodo:804 / Elemento padre: 803   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(804)).setAttribute("src","b.gif" );
      ((Element)v.get(804)).setAttribute("width","8" );
      ((Element)v.get(804)).setAttribute("height","12" );
      ((Element)v.get(803)).appendChild((Element)v.get(804));
      /* Termina nodo:804   */
      /* Termina nodo:803   */
      /* Termina nodo:792   */

      /* Empieza nodo:805 / Elemento padre: 534   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(534)).appendChild((Element)v.get(805));

      /* Empieza nodo:806 / Elemento padre: 805   */
      v.add(doc.createElement("td"));
      ((Element)v.get(806)).setAttribute("width","12" );
      ((Element)v.get(806)).setAttribute("align","center" );
      ((Element)v.get(805)).appendChild((Element)v.get(806));

      /* Empieza nodo:807 / Elemento padre: 806   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML3420(Document doc) {
      ((Element)v.get(807)).setAttribute("src","b.gif" );
      ((Element)v.get(807)).setAttribute("width","12" );
      ((Element)v.get(807)).setAttribute("height","12" );
      ((Element)v.get(806)).appendChild((Element)v.get(807));
      /* Termina nodo:807   */
      /* Termina nodo:806   */

      /* Empieza nodo:808 / Elemento padre: 805   */
      v.add(doc.createElement("td"));
      ((Element)v.get(808)).setAttribute("width","756" );
      ((Element)v.get(805)).appendChild((Element)v.get(808));

      /* Empieza nodo:809 / Elemento padre: 808   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(809)).setAttribute("src","b.gif" );
      ((Element)v.get(808)).appendChild((Element)v.get(809));
      /* Termina nodo:809   */
      /* Termina nodo:808   */

      /* Empieza nodo:810 / Elemento padre: 805   */
      v.add(doc.createElement("td"));
      ((Element)v.get(810)).setAttribute("width","12" );
      ((Element)v.get(805)).appendChild((Element)v.get(810));

      /* Empieza nodo:811 / Elemento padre: 810   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(811)).setAttribute("src","b.gif" );
      ((Element)v.get(811)).setAttribute("width","12" );
      ((Element)v.get(811)).setAttribute("height","1" );
      ((Element)v.get(810)).appendChild((Element)v.get(811));
      /* Termina nodo:811   */
      /* Termina nodo:810   */
      /* Termina nodo:805   */
      /* Termina nodo:534   */
      /* Termina nodo:533   */

      /* Empieza nodo:812 / Elemento padre: 37   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(812)).setAttribute("nombre","capa5" );
      ((Element)v.get(812)).setAttribute("alto","670" );
      ((Element)v.get(812)).setAttribute("ancho","100%" );
      ((Element)v.get(812)).setAttribute("colorf","" );
      ((Element)v.get(812)).setAttribute("borde","0" );
      ((Element)v.get(812)).setAttribute("imagenf","" );
      ((Element)v.get(812)).setAttribute("repeat","" );
      ((Element)v.get(812)).setAttribute("padding","" );
      ((Element)v.get(812)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(812)).setAttribute("contravsb","" );
      ((Element)v.get(812)).setAttribute("x","0" );
      ((Element)v.get(812)).setAttribute("y","341" );
      ((Element)v.get(812)).setAttribute("zindex","" );
      ((Element)v.get(37)).appendChild((Element)v.get(812));

      /* Empieza nodo:813 / Elemento padre: 812   */
      v.add(doc.createElement("table"));
      ((Element)v.get(813)).setAttribute("width","100%" );
      ((Element)v.get(813)).setAttribute("border","0" );
      ((Element)v.get(813)).setAttribute("cellspacing","0" );
      ((Element)v.get(813)).setAttribute("cellpadding","0" );
      ((Element)v.get(812)).appendChild((Element)v.get(813));

      /* Empieza nodo:814 / Elemento padre: 813   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(813)).appendChild((Element)v.get(814));

      /* Empieza nodo:815 / Elemento padre: 814   */
      v.add(doc.createElement("td"));
      ((Element)v.get(815)).setAttribute("width","12" );
      ((Element)v.get(815)).setAttribute("align","center" );
      ((Element)v.get(814)).appendChild((Element)v.get(815));

      /* Empieza nodo:816 / Elemento padre: 815   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(816)).setAttribute("src","b.gif" );
      ((Element)v.get(816)).setAttribute("width","12" );
      ((Element)v.get(816)).setAttribute("height","12" );
      ((Element)v.get(815)).appendChild((Element)v.get(816));
      /* Termina nodo:816   */
      /* Termina nodo:815   */

      /* Empieza nodo:817 / Elemento padre: 814   */
      v.add(doc.createElement("td"));
      ((Element)v.get(817)).setAttribute("width","750" );
      ((Element)v.get(814)).appendChild((Element)v.get(817));

      /* Empieza nodo:818 / Elemento padre: 817   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(818)).setAttribute("src","b.gif" );
      ((Element)v.get(817)).appendChild((Element)v.get(818));
      /* Termina nodo:818   */
      /* Termina nodo:817   */

      /* Empieza nodo:819 / Elemento padre: 814   */
      v.add(doc.createElement("td"));
      ((Element)v.get(819)).setAttribute("width","12" );
      ((Element)v.get(814)).appendChild((Element)v.get(819));

      /* Empieza nodo:820 / Elemento padre: 819   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(820)).setAttribute("src","b.gif" );
      ((Element)v.get(820)).setAttribute("width","12" );
      ((Element)v.get(820)).setAttribute("height","1" );
      ((Element)v.get(819)).appendChild((Element)v.get(820));
      /* Termina nodo:820   */
      /* Termina nodo:819   */
      /* Termina nodo:814   */

      /* Empieza nodo:821 / Elemento padre: 813   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(813)).appendChild((Element)v.get(821));

      /* Empieza nodo:822 / Elemento padre: 821   */
      v.add(doc.createElement("td"));
      ((Element)v.get(821)).appendChild((Element)v.get(822));

      /* Empieza nodo:823 / Elemento padre: 822   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(823)).setAttribute("src","b.gif" );
      ((Element)v.get(822)).appendChild((Element)v.get(823));
      /* Termina nodo:823   */
      /* Termina nodo:822   */

      /* Empieza nodo:824 / Elemento padre: 821   */
      v.add(doc.createElement("td"));
      ((Element)v.get(821)).appendChild((Element)v.get(824));

      /* Empieza nodo:825 / Elemento padre: 824   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(824)).appendChild((Element)v.get(825));

      /* Empieza nodo:826 / Elemento padre: 825   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(826)).setAttribute("class","legend" );
      ((Element)v.get(825)).appendChild((Element)v.get(826));

      /* Empieza nodo:827 / Elemento padre: 826   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(827)).setAttribute("nombre","lblDatosPremiosDescuento" );
      ((Element)v.get(827)).setAttribute("alto","13" );
      ((Element)v.get(827)).setAttribute("filas","1" );
      ((Element)v.get(827)).setAttribute("valor","" );
      ((Element)v.get(827)).setAttribute("id","legend" );
      ((Element)v.get(827)).setAttribute("cod","00355" );
      ((Element)v.get(826)).appendChild((Element)v.get(827));
      /* Termina nodo:827   */
      /* Termina nodo:826   */

      /* Empieza nodo:828 / Elemento padre: 825   */
      v.add(doc.createElement("table"));
      ((Element)v.get(828)).setAttribute("width","100%" );
      ((Element)v.get(828)).setAttribute("border","0" );
      ((Element)v.get(828)).setAttribute("align","center" );
   }

   private void getXML3510(Document doc) {
      ((Element)v.get(828)).setAttribute("cellspacing","0" );
      ((Element)v.get(828)).setAttribute("cellpadding","0" );
      ((Element)v.get(825)).appendChild((Element)v.get(828));

      /* Empieza nodo:829 / Elemento padre: 828   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(828)).appendChild((Element)v.get(829));

      /* Empieza nodo:830 / Elemento padre: 829   */
      v.add(doc.createElement("td"));
      ((Element)v.get(829)).appendChild((Element)v.get(830));

      /* Empieza nodo:831 / Elemento padre: 830   */
      v.add(doc.createElement("table"));
      ((Element)v.get(831)).setAttribute("width","728" );
      ((Element)v.get(831)).setAttribute("border","0" );
      ((Element)v.get(831)).setAttribute("align","left" );
      ((Element)v.get(831)).setAttribute("cellspacing","0" );
      ((Element)v.get(831)).setAttribute("cellpadding","0" );
      ((Element)v.get(830)).appendChild((Element)v.get(831));

      /* Empieza nodo:832 / Elemento padre: 831   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(831)).appendChild((Element)v.get(832));

      /* Empieza nodo:833 / Elemento padre: 832   */
      v.add(doc.createElement("td"));
      ((Element)v.get(833)).setAttribute("colspan","4" );
      ((Element)v.get(832)).appendChild((Element)v.get(833));

      /* Empieza nodo:834 / Elemento padre: 833   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(834)).setAttribute("src","b.gif" );
      ((Element)v.get(834)).setAttribute("width","8" );
      ((Element)v.get(834)).setAttribute("height","8" );
      ((Element)v.get(833)).appendChild((Element)v.get(834));
      /* Termina nodo:834   */
      /* Termina nodo:833   */
      /* Termina nodo:832   */

      /* Empieza nodo:835 / Elemento padre: 831   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(831)).appendChild((Element)v.get(835));

      /* Empieza nodo:836 / Elemento padre: 835   */
      v.add(doc.createElement("td"));
      ((Element)v.get(835)).appendChild((Element)v.get(836));

      /* Empieza nodo:837 / Elemento padre: 836   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(837)).setAttribute("src","b.gif" );
      ((Element)v.get(837)).setAttribute("width","8" );
      ((Element)v.get(837)).setAttribute("height","8" );
      ((Element)v.get(836)).appendChild((Element)v.get(837));
      /* Termina nodo:837   */
      /* Termina nodo:836   */

      /* Empieza nodo:838 / Elemento padre: 835   */
      v.add(doc.createElement("td"));
      ((Element)v.get(835)).appendChild((Element)v.get(838));

      /* Empieza nodo:839 / Elemento padre: 838   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(839)).setAttribute("nombre","lblNumPremio5" );
      ((Element)v.get(839)).setAttribute("alto","13" );
      ((Element)v.get(839)).setAttribute("filas","1" );
      ((Element)v.get(839)).setAttribute("valor","" );
      ((Element)v.get(839)).setAttribute("id","datosTitle" );
      ((Element)v.get(839)).setAttribute("cod","1691" );
      ((Element)v.get(838)).appendChild((Element)v.get(839));
      /* Termina nodo:839   */
      /* Termina nodo:838   */

      /* Empieza nodo:840 / Elemento padre: 835   */
      v.add(doc.createElement("td"));
      ((Element)v.get(835)).appendChild((Element)v.get(840));

      /* Empieza nodo:841 / Elemento padre: 840   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(841)).setAttribute("src","b.gif" );
      ((Element)v.get(841)).setAttribute("width","25" );
      ((Element)v.get(841)).setAttribute("height","8" );
      ((Element)v.get(840)).appendChild((Element)v.get(841));
      /* Termina nodo:841   */
      /* Termina nodo:840   */

      /* Empieza nodo:842 / Elemento padre: 835   */
      v.add(doc.createElement("td"));
      ((Element)v.get(835)).appendChild((Element)v.get(842));

      /* Empieza nodo:843 / Elemento padre: 842   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(843)).setAttribute("nombre","lblTipoPremioDescuento5" );
      ((Element)v.get(843)).setAttribute("alto","13" );
      ((Element)v.get(843)).setAttribute("filas","1" );
      ((Element)v.get(843)).setAttribute("valor","" );
      ((Element)v.get(843)).setAttribute("id","datosTitle" );
      ((Element)v.get(843)).setAttribute("cod","1855" );
      ((Element)v.get(842)).appendChild((Element)v.get(843));
      /* Termina nodo:843   */
      /* Termina nodo:842   */

      /* Empieza nodo:844 / Elemento padre: 835   */
      v.add(doc.createElement("td"));
      ((Element)v.get(835)).appendChild((Element)v.get(844));

      /* Empieza nodo:845 / Elemento padre: 844   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(845)).setAttribute("src","b.gif" );
      ((Element)v.get(845)).setAttribute("width","25" );
      ((Element)v.get(845)).setAttribute("height","8" );
      ((Element)v.get(844)).appendChild((Element)v.get(845));
      /* Termina nodo:845   */
      /* Termina nodo:844   */

      /* Empieza nodo:846 / Elemento padre: 835   */
      v.add(doc.createElement("td"));
      ((Element)v.get(835)).appendChild((Element)v.get(846));

      /* Empieza nodo:847 / Elemento padre: 846   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(847)).setAttribute("nombre","lblCantidadDescuento" );
      ((Element)v.get(847)).setAttribute("alto","13" );
      ((Element)v.get(847)).setAttribute("filas","1" );
      ((Element)v.get(847)).setAttribute("valor","" );
      ((Element)v.get(847)).setAttribute("id","datosTitle" );
      ((Element)v.get(847)).setAttribute("cod","1856" );
      ((Element)v.get(846)).appendChild((Element)v.get(847));
      /* Termina nodo:847   */
      /* Termina nodo:846   */

      /* Empieza nodo:848 / Elemento padre: 835   */
      v.add(doc.createElement("td"));
      ((Element)v.get(835)).appendChild((Element)v.get(848));

      /* Empieza nodo:849 / Elemento padre: 848   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(849)).setAttribute("src","b.gif" );
      ((Element)v.get(849)).setAttribute("width","25" );
      ((Element)v.get(849)).setAttribute("height","8" );
      ((Element)v.get(848)).appendChild((Element)v.get(849));
      /* Termina nodo:849   */
      /* Termina nodo:848   */

      /* Empieza nodo:850 / Elemento padre: 835   */
      v.add(doc.createElement("td"));
      ((Element)v.get(835)).appendChild((Element)v.get(850));

      /* Empieza nodo:851 / Elemento padre: 850   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(851)).setAttribute("nombre","lblPorcentaje5" );
      ((Element)v.get(851)).setAttribute("alto","13" );
      ((Element)v.get(851)).setAttribute("filas","1" );
   }

   private void getXML3600(Document doc) {
      ((Element)v.get(851)).setAttribute("valor","" );
      ((Element)v.get(851)).setAttribute("id","datosTitle" );
      ((Element)v.get(851)).setAttribute("cod","790" );
      ((Element)v.get(850)).appendChild((Element)v.get(851));
      /* Termina nodo:851   */
      /* Termina nodo:850   */

      /* Empieza nodo:852 / Elemento padre: 835   */
      v.add(doc.createElement("td"));
      ((Element)v.get(835)).appendChild((Element)v.get(852));

      /* Empieza nodo:853 / Elemento padre: 852   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(853)).setAttribute("src","b.gif" );
      ((Element)v.get(853)).setAttribute("width","25" );
      ((Element)v.get(853)).setAttribute("height","8" );
      ((Element)v.get(852)).appendChild((Element)v.get(853));
      /* Termina nodo:853   */
      /* Termina nodo:852   */

      /* Empieza nodo:854 / Elemento padre: 835   */
      v.add(doc.createElement("td"));
      ((Element)v.get(835)).appendChild((Element)v.get(854));

      /* Empieza nodo:855 / Elemento padre: 854   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(855)).setAttribute("nombre","lblPeriodoAplicacionDesde" );
      ((Element)v.get(855)).setAttribute("alto","13" );
      ((Element)v.get(855)).setAttribute("filas","1" );
      ((Element)v.get(855)).setAttribute("valor","" );
      ((Element)v.get(855)).setAttribute("id","datosTitle" );
      ((Element)v.get(855)).setAttribute("cod","1899" );
      ((Element)v.get(854)).appendChild((Element)v.get(855));
      /* Termina nodo:855   */
      /* Termina nodo:854   */

      /* Empieza nodo:856 / Elemento padre: 835   */
      v.add(doc.createElement("td"));
      ((Element)v.get(835)).appendChild((Element)v.get(856));

      /* Empieza nodo:857 / Elemento padre: 856   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(857)).setAttribute("src","b.gif" );
      ((Element)v.get(857)).setAttribute("width","25" );
      ((Element)v.get(857)).setAttribute("height","8" );
      ((Element)v.get(856)).appendChild((Element)v.get(857));
      /* Termina nodo:857   */
      /* Termina nodo:856   */

      /* Empieza nodo:858 / Elemento padre: 835   */
      v.add(doc.createElement("td"));
      ((Element)v.get(835)).appendChild((Element)v.get(858));

      /* Empieza nodo:859 / Elemento padre: 858   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(859)).setAttribute("nombre","lblPeriodoAplicacionHasta" );
      ((Element)v.get(859)).setAttribute("alto","13" );
      ((Element)v.get(859)).setAttribute("filas","1" );
      ((Element)v.get(859)).setAttribute("valor","" );
      ((Element)v.get(859)).setAttribute("id","datosTitle" );
      ((Element)v.get(859)).setAttribute("cod","1900" );
      ((Element)v.get(858)).appendChild((Element)v.get(859));
      /* Termina nodo:859   */
      /* Termina nodo:858   */

      /* Empieza nodo:860 / Elemento padre: 835   */
      v.add(doc.createElement("td"));
      ((Element)v.get(860)).setAttribute("width","100%" );
      ((Element)v.get(835)).appendChild((Element)v.get(860));

      /* Empieza nodo:861 / Elemento padre: 860   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(861)).setAttribute("src","b.gif" );
      ((Element)v.get(861)).setAttribute("width","8" );
      ((Element)v.get(861)).setAttribute("height","8" );
      ((Element)v.get(860)).appendChild((Element)v.get(861));
      /* Termina nodo:861   */
      /* Termina nodo:860   */
      /* Termina nodo:835   */

      /* Empieza nodo:862 / Elemento padre: 831   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(831)).appendChild((Element)v.get(862));

      /* Empieza nodo:863 / Elemento padre: 862   */
      v.add(doc.createElement("td"));
      ((Element)v.get(862)).appendChild((Element)v.get(863));

      /* Empieza nodo:864 / Elemento padre: 863   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(864)).setAttribute("src","b.gif" );
      ((Element)v.get(864)).setAttribute("width","8" );
      ((Element)v.get(864)).setAttribute("height","8" );
      ((Element)v.get(863)).appendChild((Element)v.get(864));
      /* Termina nodo:864   */
      /* Termina nodo:863   */

      /* Empieza nodo:865 / Elemento padre: 862   */
      v.add(doc.createElement("td"));
      ((Element)v.get(862)).appendChild((Element)v.get(865));

      /* Empieza nodo:866 / Elemento padre: 865   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(866)).setAttribute("nombre","lbNumPremio5" );
      ((Element)v.get(866)).setAttribute("alto","13" );
      ((Element)v.get(866)).setAttribute("filas","1" );
      ((Element)v.get(866)).setAttribute("valor","" );
      ((Element)v.get(866)).setAttribute("id","datosCampos" );
      ((Element)v.get(865)).appendChild((Element)v.get(866));
      /* Termina nodo:866   */
      /* Termina nodo:865   */

      /* Empieza nodo:867 / Elemento padre: 862   */
      v.add(doc.createElement("td"));
      ((Element)v.get(862)).appendChild((Element)v.get(867));

      /* Empieza nodo:868 / Elemento padre: 867   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(868)).setAttribute("src","b.gif" );
      ((Element)v.get(868)).setAttribute("width","25" );
      ((Element)v.get(868)).setAttribute("height","8" );
      ((Element)v.get(867)).appendChild((Element)v.get(868));
      /* Termina nodo:868   */
      /* Termina nodo:867   */

      /* Empieza nodo:869 / Elemento padre: 862   */
      v.add(doc.createElement("td"));
      ((Element)v.get(869)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(862)).appendChild((Element)v.get(869));

      /* Empieza nodo:870 / Elemento padre: 869   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(870)).setAttribute("nombre","cbTipoPremioDescuento5" );
      ((Element)v.get(870)).setAttribute("id","datosCampos" );
      ((Element)v.get(870)).setAttribute("size","1" );
      ((Element)v.get(870)).setAttribute("onchange","onChangeTipoPremioDescuento();" );
      ((Element)v.get(870)).setAttribute("multiple","N" );
      ((Element)v.get(870)).setAttribute("req","S" );
      ((Element)v.get(870)).setAttribute("valorinicial","" );
      ((Element)v.get(870)).setAttribute("textoinicial","" );
      ((Element)v.get(869)).appendChild((Element)v.get(870));

      /* Empieza nodo:871 / Elemento padre: 870   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(870)).appendChild((Element)v.get(871));
      /* Termina nodo:871   */
      /* Termina nodo:870   */
      /* Termina nodo:869   */

      /* Empieza nodo:872 / Elemento padre: 862   */
      v.add(doc.createElement("td"));
      ((Element)v.get(862)).appendChild((Element)v.get(872));

      /* Empieza nodo:873 / Elemento padre: 872   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(873)).setAttribute("src","b.gif" );
   }

   private void getXML3690(Document doc) {
      ((Element)v.get(873)).setAttribute("width","25" );
      ((Element)v.get(873)).setAttribute("height","8" );
      ((Element)v.get(872)).appendChild((Element)v.get(873));
      /* Termina nodo:873   */
      /* Termina nodo:872   */

      /* Empieza nodo:874 / Elemento padre: 862   */
      v.add(doc.createElement("td"));
      ((Element)v.get(874)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(874)).setAttribute("valing","bottom" );
      ((Element)v.get(862)).appendChild((Element)v.get(874));

      /* Empieza nodo:875 / Elemento padre: 874   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(875)).setAttribute("nombre","txtCantidadDescuento" );
      ((Element)v.get(875)).setAttribute("id","datosCampos" );
      ((Element)v.get(875)).setAttribute("max","8" );
      ((Element)v.get(875)).setAttribute("tipo","" );
      ((Element)v.get(875)).setAttribute("onchange","" );
      ((Element)v.get(875)).setAttribute("req","N" );
      ((Element)v.get(875)).setAttribute("size","6" );
      ((Element)v.get(875)).setAttribute("valor","" );
      ((Element)v.get(875)).setAttribute("validacion","" );
      ((Element)v.get(874)).appendChild((Element)v.get(875));
      /* Termina nodo:875   */
      /* Termina nodo:874   */

      /* Empieza nodo:876 / Elemento padre: 862   */
      v.add(doc.createElement("td"));
      ((Element)v.get(862)).appendChild((Element)v.get(876));

      /* Empieza nodo:877 / Elemento padre: 876   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(877)).setAttribute("src","b.gif" );
      ((Element)v.get(877)).setAttribute("width","25" );
      ((Element)v.get(877)).setAttribute("height","8" );
      ((Element)v.get(876)).appendChild((Element)v.get(877));
      /* Termina nodo:877   */
      /* Termina nodo:876   */

      /* Empieza nodo:878 / Elemento padre: 862   */
      v.add(doc.createElement("td"));
      ((Element)v.get(878)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(878)).setAttribute("valing","bottom" );
      ((Element)v.get(862)).appendChild((Element)v.get(878));

      /* Empieza nodo:879 / Elemento padre: 878   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(879)).setAttribute("nombre","txtPorcentaje5" );
      ((Element)v.get(879)).setAttribute("id","datosCampos" );
      ((Element)v.get(879)).setAttribute("max","6" );
      ((Element)v.get(879)).setAttribute("tipo","" );
      ((Element)v.get(879)).setAttribute("onchange","" );
      ((Element)v.get(879)).setAttribute("req","N" );
      ((Element)v.get(879)).setAttribute("size","6" );
      ((Element)v.get(879)).setAttribute("valor","" );
      ((Element)v.get(879)).setAttribute("validacion","" );
      ((Element)v.get(878)).appendChild((Element)v.get(879));
      /* Termina nodo:879   */
      /* Termina nodo:878   */

      /* Empieza nodo:880 / Elemento padre: 862   */
      v.add(doc.createElement("td"));
      ((Element)v.get(862)).appendChild((Element)v.get(880));

      /* Empieza nodo:881 / Elemento padre: 880   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(881)).setAttribute("src","b.gif" );
      ((Element)v.get(881)).setAttribute("width","25" );
      ((Element)v.get(881)).setAttribute("height","8" );
      ((Element)v.get(880)).appendChild((Element)v.get(881));
      /* Termina nodo:881   */
      /* Termina nodo:880   */

      /* Empieza nodo:882 / Elemento padre: 862   */
      v.add(doc.createElement("td"));
      ((Element)v.get(882)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(862)).appendChild((Element)v.get(882));

      /* Empieza nodo:883 / Elemento padre: 882   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(883)).setAttribute("nombre","cbPeriodoAplicacionDesde" );
      ((Element)v.get(883)).setAttribute("id","datosCampos" );
      ((Element)v.get(883)).setAttribute("size","1" );
      ((Element)v.get(883)).setAttribute("multiple","N" );
      ((Element)v.get(883)).setAttribute("req","S" );
      ((Element)v.get(883)).setAttribute("valorinicial","" );
      ((Element)v.get(883)).setAttribute("textoinicial","" );
      ((Element)v.get(882)).appendChild((Element)v.get(883));

      /* Empieza nodo:884 / Elemento padre: 883   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(883)).appendChild((Element)v.get(884));
      /* Termina nodo:884   */
      /* Termina nodo:883   */
      /* Termina nodo:882   */

      /* Empieza nodo:885 / Elemento padre: 862   */
      v.add(doc.createElement("td"));
      ((Element)v.get(862)).appendChild((Element)v.get(885));

      /* Empieza nodo:886 / Elemento padre: 885   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(886)).setAttribute("src","b.gif" );
      ((Element)v.get(886)).setAttribute("width","25" );
      ((Element)v.get(886)).setAttribute("height","8" );
      ((Element)v.get(885)).appendChild((Element)v.get(886));
      /* Termina nodo:886   */
      /* Termina nodo:885   */

      /* Empieza nodo:887 / Elemento padre: 862   */
      v.add(doc.createElement("td"));
      ((Element)v.get(887)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(862)).appendChild((Element)v.get(887));

      /* Empieza nodo:888 / Elemento padre: 887   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(888)).setAttribute("nombre","cbPeriodoAplicacionHasta" );
      ((Element)v.get(888)).setAttribute("id","datosCampos" );
      ((Element)v.get(888)).setAttribute("size","1" );
      ((Element)v.get(888)).setAttribute("multiple","N" );
      ((Element)v.get(888)).setAttribute("req","N" );
      ((Element)v.get(888)).setAttribute("valorinicial","" );
      ((Element)v.get(888)).setAttribute("textoinicial","" );
      ((Element)v.get(887)).appendChild((Element)v.get(888));

      /* Empieza nodo:889 / Elemento padre: 888   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(888)).appendChild((Element)v.get(889));
      /* Termina nodo:889   */
      /* Termina nodo:888   */
      /* Termina nodo:887   */

      /* Empieza nodo:890 / Elemento padre: 862   */
      v.add(doc.createElement("td"));
      ((Element)v.get(890)).setAttribute("width","100%" );
      ((Element)v.get(862)).appendChild((Element)v.get(890));

      /* Empieza nodo:891 / Elemento padre: 890   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(891)).setAttribute("src","b.gif" );
      ((Element)v.get(891)).setAttribute("width","8" );
      ((Element)v.get(891)).setAttribute("height","8" );
      ((Element)v.get(890)).appendChild((Element)v.get(891));
      /* Termina nodo:891   */
      /* Termina nodo:890   */
      /* Termina nodo:862   */

      /* Empieza nodo:892 / Elemento padre: 831   */
   }

   private void getXML3780(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(831)).appendChild((Element)v.get(892));

      /* Empieza nodo:893 / Elemento padre: 892   */
      v.add(doc.createElement("td"));
      ((Element)v.get(893)).setAttribute("colspan","4" );
      ((Element)v.get(892)).appendChild((Element)v.get(893));

      /* Empieza nodo:894 / Elemento padre: 893   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(894)).setAttribute("src","b.gif" );
      ((Element)v.get(894)).setAttribute("width","8" );
      ((Element)v.get(894)).setAttribute("height","12" );
      ((Element)v.get(893)).appendChild((Element)v.get(894));
      /* Termina nodo:894   */
      /* Termina nodo:893   */
      /* Termina nodo:892   */
      /* Termina nodo:831   */
      /* Termina nodo:830   */
      /* Termina nodo:829   */

      /* Empieza nodo:895 / Elemento padre: 828   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(828)).appendChild((Element)v.get(895));

      /* Empieza nodo:896 / Elemento padre: 895   */
      v.add(doc.createElement("td"));
      ((Element)v.get(895)).appendChild((Element)v.get(896));

      /* Empieza nodo:897 / Elemento padre: 896   */
      v.add(doc.createElement("table"));
      ((Element)v.get(897)).setAttribute("width","100%" );
      ((Element)v.get(897)).setAttribute("align","left" );
      ((Element)v.get(897)).setAttribute("border","0" );
      ((Element)v.get(897)).setAttribute("cellspacing","0" );
      ((Element)v.get(897)).setAttribute("cellpadding","0" );
      ((Element)v.get(896)).appendChild((Element)v.get(897));

      /* Empieza nodo:898 / Elemento padre: 897   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(897)).appendChild((Element)v.get(898));

      /* Empieza nodo:899 / Elemento padre: 898   */
      v.add(doc.createElement("td"));
      ((Element)v.get(898)).appendChild((Element)v.get(899));

      /* Empieza nodo:900 / Elemento padre: 899   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(900)).setAttribute("src","b.gif" );
      ((Element)v.get(899)).appendChild((Element)v.get(900));
      /* Termina nodo:900   */
      /* Termina nodo:899   */

      /* Empieza nodo:901 / Elemento padre: 898   */
      v.add(doc.createElement("td"));
      ((Element)v.get(898)).appendChild((Element)v.get(901));

      /* Empieza nodo:902 / Elemento padre: 901   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(901)).appendChild((Element)v.get(902));

      /* Empieza nodo:903 / Elemento padre: 902   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(903)).setAttribute("class","legend" );
      ((Element)v.get(902)).appendChild((Element)v.get(903));

      /* Empieza nodo:904 / Elemento padre: 903   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(904)).setAttribute("nombre","lblDatosArticulo5" );
      ((Element)v.get(904)).setAttribute("alto","13" );
      ((Element)v.get(904)).setAttribute("filas","1" );
      ((Element)v.get(904)).setAttribute("valor","" );
      ((Element)v.get(904)).setAttribute("id","legend" );
      ((Element)v.get(904)).setAttribute("cod","00356" );
      ((Element)v.get(903)).appendChild((Element)v.get(904));
      /* Termina nodo:904   */
      /* Termina nodo:903   */

      /* Empieza nodo:905 / Elemento padre: 902   */
      v.add(doc.createElement("table"));
      ((Element)v.get(905)).setAttribute("width","100%" );
      ((Element)v.get(905)).setAttribute("border","0" );
      ((Element)v.get(905)).setAttribute("align","center" );
      ((Element)v.get(905)).setAttribute("cellspacing","0" );
      ((Element)v.get(905)).setAttribute("cellpadding","0" );
      ((Element)v.get(902)).appendChild((Element)v.get(905));

      /* Empieza nodo:906 / Elemento padre: 905   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(905)).appendChild((Element)v.get(906));

      /* Empieza nodo:907 / Elemento padre: 906   */
      v.add(doc.createElement("td"));
      ((Element)v.get(906)).appendChild((Element)v.get(907));

      /* Empieza nodo:908 / Elemento padre: 907   */
      v.add(doc.createElement("table"));
      ((Element)v.get(908)).setAttribute("width","699" );
      ((Element)v.get(908)).setAttribute("border","0" );
      ((Element)v.get(908)).setAttribute("align","left" );
      ((Element)v.get(908)).setAttribute("cellspacing","0" );
      ((Element)v.get(908)).setAttribute("cellpadding","0" );
      ((Element)v.get(907)).appendChild((Element)v.get(908));

      /* Empieza nodo:909 / Elemento padre: 908   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(908)).appendChild((Element)v.get(909));

      /* Empieza nodo:910 / Elemento padre: 909   */
      v.add(doc.createElement("td"));
      ((Element)v.get(910)).setAttribute("colspan","4" );
      ((Element)v.get(909)).appendChild((Element)v.get(910));

      /* Empieza nodo:911 / Elemento padre: 910   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(911)).setAttribute("src","b.gif" );
      ((Element)v.get(911)).setAttribute("width","8" );
      ((Element)v.get(911)).setAttribute("height","8" );
      ((Element)v.get(910)).appendChild((Element)v.get(911));
      /* Termina nodo:911   */
      /* Termina nodo:910   */
      /* Termina nodo:909   */

      /* Empieza nodo:912 / Elemento padre: 908   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(908)).appendChild((Element)v.get(912));

      /* Empieza nodo:913 / Elemento padre: 912   */
      v.add(doc.createElement("td"));
      ((Element)v.get(912)).appendChild((Element)v.get(913));

      /* Empieza nodo:914 / Elemento padre: 913   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(914)).setAttribute("src","b.gif" );
      ((Element)v.get(914)).setAttribute("width","8" );
      ((Element)v.get(914)).setAttribute("height","8" );
      ((Element)v.get(913)).appendChild((Element)v.get(914));
      /* Termina nodo:914   */
      /* Termina nodo:913   */

      /* Empieza nodo:915 / Elemento padre: 912   */
      v.add(doc.createElement("td"));
      ((Element)v.get(912)).appendChild((Element)v.get(915));

      /* Empieza nodo:916 / Elemento padre: 915   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(916)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(916)).setAttribute("alto","13" );
      ((Element)v.get(916)).setAttribute("filas","1" );
      ((Element)v.get(916)).setAttribute("valor","" );
      ((Element)v.get(916)).setAttribute("id","datosTitle" );
      ((Element)v.get(916)).setAttribute("cod","6" );
      ((Element)v.get(915)).appendChild((Element)v.get(916));
      /* Termina nodo:916   */
      /* Termina nodo:915   */

      /* Empieza nodo:917 / Elemento padre: 912   */
   }

   private void getXML3870(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(912)).appendChild((Element)v.get(917));

      /* Empieza nodo:918 / Elemento padre: 917   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(918)).setAttribute("src","b.gif" );
      ((Element)v.get(918)).setAttribute("width","25" );
      ((Element)v.get(918)).setAttribute("height","8" );
      ((Element)v.get(917)).appendChild((Element)v.get(918));
      /* Termina nodo:918   */
      /* Termina nodo:917   */

      /* Empieza nodo:919 / Elemento padre: 912   */
      v.add(doc.createElement("td"));
      ((Element)v.get(912)).appendChild((Element)v.get(919));

      /* Empieza nodo:920 / Elemento padre: 919   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(920)).setAttribute("nombre","lblUnidadNegocio" );
      ((Element)v.get(920)).setAttribute("alto","13" );
      ((Element)v.get(920)).setAttribute("filas","1" );
      ((Element)v.get(920)).setAttribute("valor","" );
      ((Element)v.get(920)).setAttribute("id","datosTitle" );
      ((Element)v.get(920)).setAttribute("cod","1338" );
      ((Element)v.get(919)).appendChild((Element)v.get(920));
      /* Termina nodo:920   */
      /* Termina nodo:919   */

      /* Empieza nodo:921 / Elemento padre: 912   */
      v.add(doc.createElement("td"));
      ((Element)v.get(921)).setAttribute("width","100%" );
      ((Element)v.get(912)).appendChild((Element)v.get(921));

      /* Empieza nodo:922 / Elemento padre: 921   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(922)).setAttribute("src","b.gif" );
      ((Element)v.get(922)).setAttribute("width","8" );
      ((Element)v.get(922)).setAttribute("height","8" );
      ((Element)v.get(921)).appendChild((Element)v.get(922));
      /* Termina nodo:922   */
      /* Termina nodo:921   */
      /* Termina nodo:912   */

      /* Empieza nodo:923 / Elemento padre: 908   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(908)).appendChild((Element)v.get(923));

      /* Empieza nodo:924 / Elemento padre: 923   */
      v.add(doc.createElement("td"));
      ((Element)v.get(923)).appendChild((Element)v.get(924));

      /* Empieza nodo:925 / Elemento padre: 924   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(925)).setAttribute("src","b.gif" );
      ((Element)v.get(925)).setAttribute("width","8" );
      ((Element)v.get(925)).setAttribute("height","8" );
      ((Element)v.get(924)).appendChild((Element)v.get(925));
      /* Termina nodo:925   */
      /* Termina nodo:924   */

      /* Empieza nodo:926 / Elemento padre: 923   */
      v.add(doc.createElement("td"));
      ((Element)v.get(926)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(923)).appendChild((Element)v.get(926));

      /* Empieza nodo:927 / Elemento padre: 926   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(927)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(927)).setAttribute("id","datosCampos" );
      ((Element)v.get(927)).setAttribute("size","1" );
      ((Element)v.get(927)).setAttribute("multiple","N" );
      ((Element)v.get(927)).setAttribute("req","S" );
      ((Element)v.get(927)).setAttribute("valorinicial","" );
      ((Element)v.get(927)).setAttribute("textoinicial","" );
      ((Element)v.get(926)).appendChild((Element)v.get(927));

      /* Empieza nodo:928 / Elemento padre: 927   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(927)).appendChild((Element)v.get(928));
      /* Termina nodo:928   */
      /* Termina nodo:927   */
      /* Termina nodo:926   */

      /* Empieza nodo:929 / Elemento padre: 923   */
      v.add(doc.createElement("td"));
      ((Element)v.get(923)).appendChild((Element)v.get(929));

      /* Empieza nodo:930 / Elemento padre: 929   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(930)).setAttribute("src","b.gif" );
      ((Element)v.get(930)).setAttribute("width","25" );
      ((Element)v.get(930)).setAttribute("height","8" );
      ((Element)v.get(929)).appendChild((Element)v.get(930));
      /* Termina nodo:930   */
      /* Termina nodo:929   */

      /* Empieza nodo:931 / Elemento padre: 923   */
      v.add(doc.createElement("td"));
      ((Element)v.get(931)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(931)).setAttribute("valign","bottom" );
      ((Element)v.get(923)).appendChild((Element)v.get(931));

      /* Empieza nodo:932 / Elemento padre: 931   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(932)).setAttribute("nombre","cbUnidadNegocio" );
      ((Element)v.get(932)).setAttribute("id","datosCampos" );
      ((Element)v.get(932)).setAttribute("size","1" );
      ((Element)v.get(932)).setAttribute("multiple","N" );
      ((Element)v.get(932)).setAttribute("req","N" );
      ((Element)v.get(932)).setAttribute("valorinicial","" );
      ((Element)v.get(932)).setAttribute("textoinicial","" );
      ((Element)v.get(931)).appendChild((Element)v.get(932));

      /* Empieza nodo:933 / Elemento padre: 932   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(932)).appendChild((Element)v.get(933));
      /* Termina nodo:933   */
      /* Termina nodo:932   */
      /* Termina nodo:931   */

      /* Empieza nodo:934 / Elemento padre: 923   */
      v.add(doc.createElement("td"));
      ((Element)v.get(934)).setAttribute("width","100%" );
      ((Element)v.get(923)).appendChild((Element)v.get(934));

      /* Empieza nodo:935 / Elemento padre: 934   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(935)).setAttribute("src","b.gif" );
      ((Element)v.get(935)).setAttribute("width","8" );
      ((Element)v.get(935)).setAttribute("height","8" );
      ((Element)v.get(934)).appendChild((Element)v.get(935));
      /* Termina nodo:935   */
      /* Termina nodo:934   */
      /* Termina nodo:923   */

      /* Empieza nodo:936 / Elemento padre: 908   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(908)).appendChild((Element)v.get(936));

      /* Empieza nodo:937 / Elemento padre: 936   */
      v.add(doc.createElement("td"));
      ((Element)v.get(937)).setAttribute("colspan","4" );
      ((Element)v.get(936)).appendChild((Element)v.get(937));

      /* Empieza nodo:938 / Elemento padre: 937   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(938)).setAttribute("src","b.gif" );
      ((Element)v.get(938)).setAttribute("width","8" );
      ((Element)v.get(938)).setAttribute("height","8" );
      ((Element)v.get(937)).appendChild((Element)v.get(938));
      /* Termina nodo:938   */
      /* Termina nodo:937   */
      /* Termina nodo:936   */
      /* Termina nodo:908   */
      /* Termina nodo:907   */
      /* Termina nodo:906   */

      /* Empieza nodo:939 / Elemento padre: 905   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(905)).appendChild((Element)v.get(939));

      /* Empieza nodo:940 / Elemento padre: 939   */
   }

   private void getXML3960(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(939)).appendChild((Element)v.get(940));

      /* Empieza nodo:941 / Elemento padre: 940   */
      v.add(doc.createElement("table"));
      ((Element)v.get(941)).setAttribute("width","699" );
      ((Element)v.get(941)).setAttribute("border","0" );
      ((Element)v.get(941)).setAttribute("align","left" );
      ((Element)v.get(941)).setAttribute("cellspacing","0" );
      ((Element)v.get(941)).setAttribute("cellpadding","0" );
      ((Element)v.get(940)).appendChild((Element)v.get(941));

      /* Empieza nodo:942 / Elemento padre: 941   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(941)).appendChild((Element)v.get(942));

      /* Empieza nodo:943 / Elemento padre: 942   */
      v.add(doc.createElement("td"));
      ((Element)v.get(942)).appendChild((Element)v.get(943));

      /* Empieza nodo:944 / Elemento padre: 943   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(944)).setAttribute("src","b.gif" );
      ((Element)v.get(944)).setAttribute("width","8" );
      ((Element)v.get(944)).setAttribute("height","8" );
      ((Element)v.get(943)).appendChild((Element)v.get(944));
      /* Termina nodo:944   */
      /* Termina nodo:943   */

      /* Empieza nodo:945 / Elemento padre: 942   */
      v.add(doc.createElement("td"));
      ((Element)v.get(942)).appendChild((Element)v.get(945));

      /* Empieza nodo:946 / Elemento padre: 945   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(946)).setAttribute("nombre","lblNegocio" );
      ((Element)v.get(946)).setAttribute("alto","13" );
      ((Element)v.get(946)).setAttribute("filas","1" );
      ((Element)v.get(946)).setAttribute("valor","" );
      ((Element)v.get(946)).setAttribute("id","datosTitle" );
      ((Element)v.get(946)).setAttribute("cod","588" );
      ((Element)v.get(945)).appendChild((Element)v.get(946));
      /* Termina nodo:946   */
      /* Termina nodo:945   */

      /* Empieza nodo:947 / Elemento padre: 942   */
      v.add(doc.createElement("td"));
      ((Element)v.get(942)).appendChild((Element)v.get(947));

      /* Empieza nodo:948 / Elemento padre: 947   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(948)).setAttribute("src","b.gif" );
      ((Element)v.get(948)).setAttribute("width","25" );
      ((Element)v.get(948)).setAttribute("height","8" );
      ((Element)v.get(947)).appendChild((Element)v.get(948));
      /* Termina nodo:948   */
      /* Termina nodo:947   */

      /* Empieza nodo:949 / Elemento padre: 942   */
      v.add(doc.createElement("td"));
      ((Element)v.get(942)).appendChild((Element)v.get(949));

      /* Empieza nodo:950 / Elemento padre: 949   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(950)).setAttribute("nombre","lblSupergenerico" );
      ((Element)v.get(950)).setAttribute("alto","13" );
      ((Element)v.get(950)).setAttribute("filas","1" );
      ((Element)v.get(950)).setAttribute("valor","" );
      ((Element)v.get(950)).setAttribute("id","datosTitle" );
      ((Element)v.get(950)).setAttribute("cod","590" );
      ((Element)v.get(949)).appendChild((Element)v.get(950));
      /* Termina nodo:950   */
      /* Termina nodo:949   */

      /* Empieza nodo:951 / Elemento padre: 942   */
      v.add(doc.createElement("td"));
      ((Element)v.get(951)).setAttribute("width","100%" );
      ((Element)v.get(942)).appendChild((Element)v.get(951));

      /* Empieza nodo:952 / Elemento padre: 951   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(952)).setAttribute("src","b.gif" );
      ((Element)v.get(952)).setAttribute("width","8" );
      ((Element)v.get(952)).setAttribute("height","8" );
      ((Element)v.get(951)).appendChild((Element)v.get(952));
      /* Termina nodo:952   */
      /* Termina nodo:951   */
      /* Termina nodo:942   */

      /* Empieza nodo:953 / Elemento padre: 941   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(941)).appendChild((Element)v.get(953));

      /* Empieza nodo:954 / Elemento padre: 953   */
      v.add(doc.createElement("td"));
      ((Element)v.get(953)).appendChild((Element)v.get(954));

      /* Empieza nodo:955 / Elemento padre: 954   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(955)).setAttribute("src","b.gif" );
      ((Element)v.get(955)).setAttribute("width","8" );
      ((Element)v.get(955)).setAttribute("height","8" );
      ((Element)v.get(954)).appendChild((Element)v.get(955));
      /* Termina nodo:955   */
      /* Termina nodo:954   */

      /* Empieza nodo:956 / Elemento padre: 953   */
      v.add(doc.createElement("td"));
      ((Element)v.get(956)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(953)).appendChild((Element)v.get(956));

      /* Empieza nodo:957 / Elemento padre: 956   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(957)).setAttribute("nombre","cbNegocio" );
      ((Element)v.get(957)).setAttribute("id","datosCampos" );
      ((Element)v.get(957)).setAttribute("size","1" );
      ((Element)v.get(957)).setAttribute("multiple","N" );
      ((Element)v.get(957)).setAttribute("req","N" );
      ((Element)v.get(957)).setAttribute("valorinicial","" );
      ((Element)v.get(957)).setAttribute("textoinicial","" );
      ((Element)v.get(956)).appendChild((Element)v.get(957));

      /* Empieza nodo:958 / Elemento padre: 957   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(957)).appendChild((Element)v.get(958));
      /* Termina nodo:958   */
      /* Termina nodo:957   */
      /* Termina nodo:956   */

      /* Empieza nodo:959 / Elemento padre: 953   */
      v.add(doc.createElement("td"));
      ((Element)v.get(953)).appendChild((Element)v.get(959));

      /* Empieza nodo:960 / Elemento padre: 959   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(960)).setAttribute("src","b.gif" );
      ((Element)v.get(960)).setAttribute("width","25" );
      ((Element)v.get(960)).setAttribute("height","8" );
      ((Element)v.get(959)).appendChild((Element)v.get(960));
      /* Termina nodo:960   */
      /* Termina nodo:959   */

      /* Empieza nodo:961 / Elemento padre: 953   */
      v.add(doc.createElement("td"));
      ((Element)v.get(961)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(953)).appendChild((Element)v.get(961));

      /* Empieza nodo:962 / Elemento padre: 961   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(962)).setAttribute("nombre","cbSupergenerico" );
      ((Element)v.get(962)).setAttribute("id","datosCampos" );
      ((Element)v.get(962)).setAttribute("size","1" );
   }

   private void getXML4050(Document doc) {
      ((Element)v.get(962)).setAttribute("multiple","N" );
      ((Element)v.get(962)).setAttribute("req","N" );
      ((Element)v.get(962)).setAttribute("valorinicial","" );
      ((Element)v.get(962)).setAttribute("textoinicial","" );
      ((Element)v.get(961)).appendChild((Element)v.get(962));

      /* Empieza nodo:963 / Elemento padre: 962   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(962)).appendChild((Element)v.get(963));
      /* Termina nodo:963   */
      /* Termina nodo:962   */
      /* Termina nodo:961   */

      /* Empieza nodo:964 / Elemento padre: 953   */
      v.add(doc.createElement("td"));
      ((Element)v.get(964)).setAttribute("width","100%" );
      ((Element)v.get(953)).appendChild((Element)v.get(964));

      /* Empieza nodo:965 / Elemento padre: 964   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(965)).setAttribute("src","b.gif" );
      ((Element)v.get(965)).setAttribute("width","8" );
      ((Element)v.get(965)).setAttribute("height","8" );
      ((Element)v.get(964)).appendChild((Element)v.get(965));
      /* Termina nodo:965   */
      /* Termina nodo:964   */
      /* Termina nodo:953   */

      /* Empieza nodo:966 / Elemento padre: 941   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(941)).appendChild((Element)v.get(966));

      /* Empieza nodo:967 / Elemento padre: 966   */
      v.add(doc.createElement("td"));
      ((Element)v.get(967)).setAttribute("colspan","4" );
      ((Element)v.get(966)).appendChild((Element)v.get(967));

      /* Empieza nodo:968 / Elemento padre: 967   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(968)).setAttribute("src","b.gif" );
      ((Element)v.get(968)).setAttribute("width","8" );
      ((Element)v.get(968)).setAttribute("height","8" );
      ((Element)v.get(967)).appendChild((Element)v.get(968));
      /* Termina nodo:968   */
      /* Termina nodo:967   */
      /* Termina nodo:966   */
      /* Termina nodo:941   */
      /* Termina nodo:940   */
      /* Termina nodo:939   */

      /* Empieza nodo:969 / Elemento padre: 905   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(905)).appendChild((Element)v.get(969));

      /* Empieza nodo:970 / Elemento padre: 969   */
      v.add(doc.createElement("td"));
      ((Element)v.get(969)).appendChild((Element)v.get(970));

      /* Empieza nodo:971 / Elemento padre: 970   */
      v.add(doc.createElement("table"));
      ((Element)v.get(971)).setAttribute("width","699" );
      ((Element)v.get(971)).setAttribute("border","0" );
      ((Element)v.get(971)).setAttribute("align","left" );
      ((Element)v.get(971)).setAttribute("cellspacing","0" );
      ((Element)v.get(971)).setAttribute("cellpadding","0" );
      ((Element)v.get(970)).appendChild((Element)v.get(971));

      /* Empieza nodo:972 / Elemento padre: 971   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(971)).appendChild((Element)v.get(972));

      /* Empieza nodo:973 / Elemento padre: 972   */
      v.add(doc.createElement("td"));
      ((Element)v.get(972)).appendChild((Element)v.get(973));

      /* Empieza nodo:974 / Elemento padre: 973   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(974)).setAttribute("src","b.gif" );
      ((Element)v.get(974)).setAttribute("width","8" );
      ((Element)v.get(974)).setAttribute("height","8" );
      ((Element)v.get(973)).appendChild((Element)v.get(974));
      /* Termina nodo:974   */
      /* Termina nodo:973   */

      /* Empieza nodo:975 / Elemento padre: 972   */
      v.add(doc.createElement("td"));
      ((Element)v.get(972)).appendChild((Element)v.get(975));

      /* Empieza nodo:976 / Elemento padre: 975   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(976)).setAttribute("nombre","lblGenerico" );
      ((Element)v.get(976)).setAttribute("alto","13" );
      ((Element)v.get(976)).setAttribute("filas","1" );
      ((Element)v.get(976)).setAttribute("valor","" );
      ((Element)v.get(976)).setAttribute("id","datosTitle" );
      ((Element)v.get(976)).setAttribute("cod","589" );
      ((Element)v.get(975)).appendChild((Element)v.get(976));
      /* Termina nodo:976   */
      /* Termina nodo:975   */

      /* Empieza nodo:977 / Elemento padre: 972   */
      v.add(doc.createElement("td"));
      ((Element)v.get(972)).appendChild((Element)v.get(977));

      /* Empieza nodo:978 / Elemento padre: 977   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(978)).setAttribute("src","b.gif" );
      ((Element)v.get(978)).setAttribute("width","25" );
      ((Element)v.get(978)).setAttribute("height","8" );
      ((Element)v.get(977)).appendChild((Element)v.get(978));
      /* Termina nodo:978   */
      /* Termina nodo:977   */

      /* Empieza nodo:979 / Elemento padre: 972   */
      v.add(doc.createElement("td"));
      ((Element)v.get(979)).setAttribute("colspan","3" );
      ((Element)v.get(972)).appendChild((Element)v.get(979));

      /* Empieza nodo:980 / Elemento padre: 979   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(980)).setAttribute("nombre","lblCodProducto5" );
      ((Element)v.get(980)).setAttribute("alto","13" );
      ((Element)v.get(980)).setAttribute("filas","1" );
      ((Element)v.get(980)).setAttribute("valor","" );
      ((Element)v.get(980)).setAttribute("id","datosTitle" );
      ((Element)v.get(980)).setAttribute("cod","337" );
      ((Element)v.get(979)).appendChild((Element)v.get(980));
      /* Termina nodo:980   */
      /* Termina nodo:979   */

      /* Empieza nodo:981 / Elemento padre: 972   */
      v.add(doc.createElement("td"));
      ((Element)v.get(981)).setAttribute("width","100%" );
      ((Element)v.get(972)).appendChild((Element)v.get(981));

      /* Empieza nodo:982 / Elemento padre: 981   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(982)).setAttribute("src","b.gif" );
      ((Element)v.get(982)).setAttribute("width","8" );
      ((Element)v.get(982)).setAttribute("height","8" );
      ((Element)v.get(981)).appendChild((Element)v.get(982));
      /* Termina nodo:982   */
      /* Termina nodo:981   */
      /* Termina nodo:972   */

      /* Empieza nodo:983 / Elemento padre: 971   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(971)).appendChild((Element)v.get(983));

      /* Empieza nodo:984 / Elemento padre: 983   */
      v.add(doc.createElement("td"));
      ((Element)v.get(983)).appendChild((Element)v.get(984));

      /* Empieza nodo:985 / Elemento padre: 984   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(985)).setAttribute("src","b.gif" );
      ((Element)v.get(985)).setAttribute("width","8" );
      ((Element)v.get(985)).setAttribute("height","8" );
      ((Element)v.get(984)).appendChild((Element)v.get(985));
      /* Termina nodo:985   */
      /* Termina nodo:984   */

      /* Empieza nodo:986 / Elemento padre: 983   */
   }

   private void getXML4140(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(986)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(983)).appendChild((Element)v.get(986));

      /* Empieza nodo:987 / Elemento padre: 986   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(987)).setAttribute("nombre","cbGenerico" );
      ((Element)v.get(987)).setAttribute("id","datosCampos" );
      ((Element)v.get(987)).setAttribute("size","1" );
      ((Element)v.get(987)).setAttribute("multiple","N" );
      ((Element)v.get(987)).setAttribute("req","N" );
      ((Element)v.get(987)).setAttribute("valorinicial","" );
      ((Element)v.get(987)).setAttribute("textoinicial","" );
      ((Element)v.get(986)).appendChild((Element)v.get(987));

      /* Empieza nodo:988 / Elemento padre: 987   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(987)).appendChild((Element)v.get(988));
      /* Termina nodo:988   */
      /* Termina nodo:987   */
      /* Termina nodo:986   */

      /* Empieza nodo:989 / Elemento padre: 983   */
      v.add(doc.createElement("td"));
      ((Element)v.get(983)).appendChild((Element)v.get(989));

      /* Empieza nodo:990 / Elemento padre: 989   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(990)).setAttribute("src","b.gif" );
      ((Element)v.get(990)).setAttribute("width","25" );
      ((Element)v.get(990)).setAttribute("height","8" );
      ((Element)v.get(989)).appendChild((Element)v.get(990));
      /* Termina nodo:990   */
      /* Termina nodo:989   */

      /* Empieza nodo:991 / Elemento padre: 983   */
      v.add(doc.createElement("td"));
      ((Element)v.get(991)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(983)).appendChild((Element)v.get(991));

      /* Empieza nodo:992 / Elemento padre: 991   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(992)).setAttribute("nombre","txtCodProducto5" );
      ((Element)v.get(992)).setAttribute("id","datosCampos" );
      ((Element)v.get(992)).setAttribute("max","20" );
      ((Element)v.get(992)).setAttribute("tipo","" );
      ((Element)v.get(992)).setAttribute("onchange","" );
      ((Element)v.get(992)).setAttribute("req","N" );
      ((Element)v.get(992)).setAttribute("size","26" );
      ((Element)v.get(992)).setAttribute("valor","" );
      ((Element)v.get(992)).setAttribute("validacion","" );
      ((Element)v.get(991)).appendChild((Element)v.get(992));
      /* Termina nodo:992   */
      /* Termina nodo:991   */

      /* Empieza nodo:993 / Elemento padre: 983   */
      v.add(doc.createElement("td"));
      ((Element)v.get(983)).appendChild((Element)v.get(993));

      /* Empieza nodo:994 / Elemento padre: 993   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(994)).setAttribute("src","b.gif" );
      ((Element)v.get(994)).setAttribute("width","8" );
      ((Element)v.get(994)).setAttribute("height","8" );
      ((Element)v.get(993)).appendChild((Element)v.get(994));
      /* Termina nodo:994   */
      /* Termina nodo:993   */

      /* Empieza nodo:995 / Elemento padre: 983   */
      v.add(doc.createElement("td"));
      ((Element)v.get(983)).appendChild((Element)v.get(995));

      /* Empieza nodo:996 / Elemento padre: 995   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(996)).setAttribute("nombre","btnBuscar5" );
      ((Element)v.get(996)).setAttribute("ID","botonContenido" );
      ((Element)v.get(996)).setAttribute("tipo","html" );
      ((Element)v.get(996)).setAttribute("accion","accionBuscarProductoDescuento();" );
      ((Element)v.get(996)).setAttribute("estado","false" );
      ((Element)v.get(996)).setAttribute("cod","1" );
      ((Element)v.get(995)).appendChild((Element)v.get(996));
      /* Termina nodo:996   */
      /* Termina nodo:995   */

      /* Empieza nodo:997 / Elemento padre: 983   */
      v.add(doc.createElement("td"));
      ((Element)v.get(997)).setAttribute("width","100%" );
      ((Element)v.get(983)).appendChild((Element)v.get(997));

      /* Empieza nodo:998 / Elemento padre: 997   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(998)).setAttribute("src","b.gif" );
      ((Element)v.get(998)).setAttribute("width","8" );
      ((Element)v.get(998)).setAttribute("height","8" );
      ((Element)v.get(997)).appendChild((Element)v.get(998));
      /* Termina nodo:998   */
      /* Termina nodo:997   */
      /* Termina nodo:983   */

      /* Empieza nodo:999 / Elemento padre: 971   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(971)).appendChild((Element)v.get(999));

      /* Empieza nodo:1000 / Elemento padre: 999   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1000)).setAttribute("colspan","4" );
      ((Element)v.get(999)).appendChild((Element)v.get(1000));

      /* Empieza nodo:1001 / Elemento padre: 1000   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1001)).setAttribute("src","b.gif" );
      ((Element)v.get(1001)).setAttribute("width","8" );
      ((Element)v.get(1001)).setAttribute("height","8" );
      ((Element)v.get(1000)).appendChild((Element)v.get(1001));
      /* Termina nodo:1001   */
      /* Termina nodo:1000   */
      /* Termina nodo:999   */
      /* Termina nodo:971   */
      /* Termina nodo:970   */
      /* Termina nodo:969   */
      /* Termina nodo:905   */
      /* Termina nodo:902   */
      /* Termina nodo:901   */

      /* Empieza nodo:1002 / Elemento padre: 898   */
      v.add(doc.createElement("td"));
      ((Element)v.get(898)).appendChild((Element)v.get(1002));

      /* Empieza nodo:1003 / Elemento padre: 1002   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1003)).setAttribute("src","b.gif" );
      ((Element)v.get(1002)).appendChild((Element)v.get(1003));
      /* Termina nodo:1003   */
      /* Termina nodo:1002   */
      /* Termina nodo:898   */

      /* Empieza nodo:1004 / Elemento padre: 897   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(897)).appendChild((Element)v.get(1004));

      /* Empieza nodo:1005 / Elemento padre: 1004   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1004)).appendChild((Element)v.get(1005));

      /* Empieza nodo:1006 / Elemento padre: 1005   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1006)).setAttribute("src","b.gif" );
      ((Element)v.get(1005)).appendChild((Element)v.get(1006));
      /* Termina nodo:1006   */
      /* Termina nodo:1005   */

      /* Empieza nodo:1007 / Elemento padre: 1004   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1004)).appendChild((Element)v.get(1007));

      /* Empieza nodo:1008 / Elemento padre: 1007   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(1007)).appendChild((Element)v.get(1008));

      /* Empieza nodo:1009 / Elemento padre: 1008   */
      v.add(doc.createElement("table"));
      ((Element)v.get(1009)).setAttribute("width","100%" );
      ((Element)v.get(1009)).setAttribute("border","0" );
      ((Element)v.get(1009)).setAttribute("align","center" );
   }

   private void getXML4230(Document doc) {
      ((Element)v.get(1009)).setAttribute("cellspacing","0" );
      ((Element)v.get(1009)).setAttribute("cellpadding","0" );
      ((Element)v.get(1008)).appendChild((Element)v.get(1009));

      /* Empieza nodo:1010 / Elemento padre: 1009   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1009)).appendChild((Element)v.get(1010));

      /* Empieza nodo:1011 / Elemento padre: 1010   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1011)).setAttribute("class","botonera" );
      ((Element)v.get(1010)).appendChild((Element)v.get(1011));

      /* Empieza nodo:1012 / Elemento padre: 1011   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1012)).setAttribute("nombre","btnAnadir5" );
      ((Element)v.get(1012)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1012)).setAttribute("tipo","html" );
      ((Element)v.get(1012)).setAttribute("accion","accionAniadirProducto();" );
      ((Element)v.get(1012)).setAttribute("estado","false" );
      ((Element)v.get(1012)).setAttribute("cod","404" );
      ((Element)v.get(1011)).appendChild((Element)v.get(1012));
      /* Termina nodo:1012   */
      /* Termina nodo:1011   */
      /* Termina nodo:1010   */
      /* Termina nodo:1009   */
      /* Termina nodo:1008   */
      /* Termina nodo:1007   */

      /* Empieza nodo:1013 / Elemento padre: 1004   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1004)).appendChild((Element)v.get(1013));

      /* Empieza nodo:1014 / Elemento padre: 1013   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1014)).setAttribute("src","b.gif" );
      ((Element)v.get(1014)).setAttribute("width","8" );
      ((Element)v.get(1014)).setAttribute("height","12" );
      ((Element)v.get(1013)).appendChild((Element)v.get(1014));
      /* Termina nodo:1014   */
      /* Termina nodo:1013   */
      /* Termina nodo:1004   */

      /* Empieza nodo:1015 / Elemento padre: 897   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(897)).appendChild((Element)v.get(1015));

      /* Empieza nodo:1016 / Elemento padre: 1015   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1016)).setAttribute("width","12" );
      ((Element)v.get(1016)).setAttribute("align","center" );
      ((Element)v.get(1015)).appendChild((Element)v.get(1016));

      /* Empieza nodo:1017 / Elemento padre: 1016   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1017)).setAttribute("src","b.gif" );
      ((Element)v.get(1017)).setAttribute("width","12" );
      ((Element)v.get(1017)).setAttribute("height","354" );
      ((Element)v.get(1016)).appendChild((Element)v.get(1017));
      /* Termina nodo:1017   */
      /* Termina nodo:1016   */

      /* Empieza nodo:1018 / Elemento padre: 1015   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1018)).setAttribute("width","756" );
      ((Element)v.get(1015)).appendChild((Element)v.get(1018));

      /* Empieza nodo:1019 / Elemento padre: 1018   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1019)).setAttribute("src","b.gif" );
      ((Element)v.get(1018)).appendChild((Element)v.get(1019));
      /* Termina nodo:1019   */
      /* Termina nodo:1018   */

      /* Empieza nodo:1020 / Elemento padre: 1015   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1020)).setAttribute("width","12" );
      ((Element)v.get(1015)).appendChild((Element)v.get(1020));

      /* Empieza nodo:1021 / Elemento padre: 1020   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1021)).setAttribute("src","b.gif" );
      ((Element)v.get(1021)).setAttribute("width","12" );
      ((Element)v.get(1021)).setAttribute("height","1" );
      ((Element)v.get(1020)).appendChild((Element)v.get(1021));
      /* Termina nodo:1021   */
      /* Termina nodo:1020   */
      /* Termina nodo:1015   */
      /* Termina nodo:897   */
      /* Termina nodo:896   */
      /* Termina nodo:895   */
      /* Termina nodo:828   */
      /* Termina nodo:825   */
      /* Termina nodo:824   */

      /* Empieza nodo:1022 / Elemento padre: 821   */
      v.add(doc.createElement("td"));
      ((Element)v.get(821)).appendChild((Element)v.get(1022));

      /* Empieza nodo:1023 / Elemento padre: 1022   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1023)).setAttribute("src","b.gif" );
      ((Element)v.get(1022)).appendChild((Element)v.get(1023));
      /* Termina nodo:1023   */
      /* Termina nodo:1022   */
      /* Termina nodo:821   */

      /* Empieza nodo:1024 / Elemento padre: 813   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(813)).appendChild((Element)v.get(1024));

      /* Empieza nodo:1025 / Elemento padre: 1024   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1024)).appendChild((Element)v.get(1025));

      /* Empieza nodo:1026 / Elemento padre: 1025   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1026)).setAttribute("src","b.gif" );
      ((Element)v.get(1025)).appendChild((Element)v.get(1026));
      /* Termina nodo:1026   */
      /* Termina nodo:1025   */

      /* Empieza nodo:1027 / Elemento padre: 1024   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1024)).appendChild((Element)v.get(1027));

      /* Empieza nodo:1028 / Elemento padre: 1027   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(1027)).appendChild((Element)v.get(1028));

      /* Empieza nodo:1029 / Elemento padre: 1028   */
      v.add(doc.createElement("table"));
      ((Element)v.get(1029)).setAttribute("width","100%" );
      ((Element)v.get(1029)).setAttribute("border","0" );
      ((Element)v.get(1029)).setAttribute("align","center" );
      ((Element)v.get(1029)).setAttribute("cellspacing","0" );
      ((Element)v.get(1029)).setAttribute("cellpadding","0" );
      ((Element)v.get(1028)).appendChild((Element)v.get(1029));

      /* Empieza nodo:1030 / Elemento padre: 1029   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1029)).appendChild((Element)v.get(1030));

      /* Empieza nodo:1031 / Elemento padre: 1030   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1031)).setAttribute("class","botonera" );
      ((Element)v.get(1030)).appendChild((Element)v.get(1031));

      /* Empieza nodo:1032 / Elemento padre: 1031   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1032)).setAttribute("nombre","btnAceptar4" );
      ((Element)v.get(1032)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1032)).setAttribute("tipo","html" );
      ((Element)v.get(1032)).setAttribute("accion","accionAceptar(get('formulario.OID_TIPO_PREMIO_DESCUENTO'));" );
      ((Element)v.get(1032)).setAttribute("estado","false" );
      ((Element)v.get(1032)).setAttribute("cod","12" );
      ((Element)v.get(1031)).appendChild((Element)v.get(1032));
      /* Termina nodo:1032   */
      /* Termina nodo:1031   */
      /* Termina nodo:1030   */
      /* Termina nodo:1029   */
      /* Termina nodo:1028   */
      /* Termina nodo:1027   */

      /* Empieza nodo:1033 / Elemento padre: 1024   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1024)).appendChild((Element)v.get(1033));

      /* Empieza nodo:1034 / Elemento padre: 1033   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1034)).setAttribute("src","b.gif" );
      ((Element)v.get(1034)).setAttribute("width","8" );
      ((Element)v.get(1034)).setAttribute("height","12" );
   }

   private void getXML4320(Document doc) {
      ((Element)v.get(1033)).appendChild((Element)v.get(1034));
      /* Termina nodo:1034   */
      /* Termina nodo:1033   */
      /* Termina nodo:1024   */

      /* Empieza nodo:1035 / Elemento padre: 813   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(813)).appendChild((Element)v.get(1035));

      /* Empieza nodo:1036 / Elemento padre: 1035   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1036)).setAttribute("width","12" );
      ((Element)v.get(1036)).setAttribute("align","center" );
      ((Element)v.get(1035)).appendChild((Element)v.get(1036));

      /* Empieza nodo:1037 / Elemento padre: 1036   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1037)).setAttribute("src","b.gif" );
      ((Element)v.get(1037)).setAttribute("width","12" );
      ((Element)v.get(1037)).setAttribute("height","12" );
      ((Element)v.get(1036)).appendChild((Element)v.get(1037));
      /* Termina nodo:1037   */
      /* Termina nodo:1036   */

      /* Empieza nodo:1038 / Elemento padre: 1035   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1038)).setAttribute("width","756" );
      ((Element)v.get(1035)).appendChild((Element)v.get(1038));

      /* Empieza nodo:1039 / Elemento padre: 1038   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1039)).setAttribute("src","b.gif" );
      ((Element)v.get(1038)).appendChild((Element)v.get(1039));
      /* Termina nodo:1039   */
      /* Termina nodo:1038   */

      /* Empieza nodo:1040 / Elemento padre: 1035   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1040)).setAttribute("width","12" );
      ((Element)v.get(1035)).appendChild((Element)v.get(1040));

      /* Empieza nodo:1041 / Elemento padre: 1040   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1041)).setAttribute("src","b.gif" );
      ((Element)v.get(1041)).setAttribute("width","12" );
      ((Element)v.get(1041)).setAttribute("height","1" );
      ((Element)v.get(1040)).appendChild((Element)v.get(1041));
      /* Termina nodo:1041   */
      /* Termina nodo:1040   */
      /* Termina nodo:1035   */
      /* Termina nodo:813   */
      /* Termina nodo:812   */

      /* Empieza nodo:1042 / Elemento padre: 37   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(1042)).setAttribute("nombre","listado1" );
      ((Element)v.get(1042)).setAttribute("ancho","703" );
      ((Element)v.get(1042)).setAttribute("alto","300" );
      ((Element)v.get(1042)).setAttribute("x","26" );
      ((Element)v.get(1042)).setAttribute("y","652" );
      ((Element)v.get(1042)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(1042)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(37)).appendChild((Element)v.get(1042));

      /* Empieza nodo:1043 / Elemento padre: 1042   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(1043)).setAttribute("precarga","S" );
      ((Element)v.get(1043)).setAttribute("conROver","S" );
      ((Element)v.get(1042)).appendChild((Element)v.get(1043));

      /* Empieza nodo:1044 / Elemento padre: 1043   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(1044)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(1044)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(1044)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(1044)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(1043)).appendChild((Element)v.get(1044));
      /* Termina nodo:1044   */

      /* Empieza nodo:1045 / Elemento padre: 1043   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(1045)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(1045)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(1045)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(1045)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(1043)).appendChild((Element)v.get(1045));
      /* Termina nodo:1045   */

      /* Empieza nodo:1046 / Elemento padre: 1043   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(1046)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(1046)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(1043)).appendChild((Element)v.get(1046));
      /* Termina nodo:1046   */
      /* Termina nodo:1043   */

      /* Empieza nodo:1047 / Elemento padre: 1042   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(1042)).appendChild((Element)v.get(1047));

      /* Empieza nodo:1048 / Elemento padre: 1047   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(1048)).setAttribute("borde","1" );
      ((Element)v.get(1048)).setAttribute("horizDatos","1" );
      ((Element)v.get(1048)).setAttribute("horizCabecera","1" );
      ((Element)v.get(1048)).setAttribute("vertical","0" );
      ((Element)v.get(1048)).setAttribute("horizTitulo","1" );
      ((Element)v.get(1048)).setAttribute("horizBase","1" );
      ((Element)v.get(1047)).appendChild((Element)v.get(1048));
      /* Termina nodo:1048   */

      /* Empieza nodo:1049 / Elemento padre: 1047   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(1049)).setAttribute("borde","#999999" );
      ((Element)v.get(1049)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(1049)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(1049)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(1049)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(1049)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(1049)).setAttribute("horizBase","#999999" );
      ((Element)v.get(1047)).appendChild((Element)v.get(1049));
      /* Termina nodo:1049   */
      /* Termina nodo:1047   */

      /* Empieza nodo:1050 / Elemento padre: 1042   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(1050)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(1050)).setAttribute("alto","22" );
      ((Element)v.get(1050)).setAttribute("imgFondo","" );
      ((Element)v.get(1050)).setAttribute("cod","0031" );
      ((Element)v.get(1050)).setAttribute("ID","datosTitle" );
      ((Element)v.get(1042)).appendChild((Element)v.get(1050));
      /* Termina nodo:1050   */

      /* Empieza nodo:1051 / Elemento padre: 1042   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(1051)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(1051)).setAttribute("alto","22" );
      ((Element)v.get(1051)).setAttribute("imgFondo","" );
      ((Element)v.get(1042)).appendChild((Element)v.get(1051));
      /* Termina nodo:1051   */

      /* Empieza nodo:1052 / Elemento padre: 1042   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(1052)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(1052)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(1052)).setAttribute("blancosAInsertar","1" );
   }

   private void getXML4410(Document doc) {
      ((Element)v.get(1052)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(1052)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(1052)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(1042)).appendChild((Element)v.get(1052));

      /* Empieza nodo:1053 / Elemento padre: 1052   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1053)).setAttribute("ancho","26" );
      ((Element)v.get(1053)).setAttribute("minimizable","S" );
      ((Element)v.get(1053)).setAttribute("minimizada","N" );
      ((Element)v.get(1052)).appendChild((Element)v.get(1053));
      /* Termina nodo:1053   */

      /* Empieza nodo:1054 / Elemento padre: 1052   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1054)).setAttribute("ancho","26" );
      ((Element)v.get(1054)).setAttribute("minimizable","S" );
      ((Element)v.get(1054)).setAttribute("minimizada","N" );
      ((Element)v.get(1052)).appendChild((Element)v.get(1054));
      /* Termina nodo:1054   */

      /* Empieza nodo:1055 / Elemento padre: 1052   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1055)).setAttribute("ancho","26" );
      ((Element)v.get(1055)).setAttribute("minimizable","S" );
      ((Element)v.get(1055)).setAttribute("minimizada","N" );
      ((Element)v.get(1052)).appendChild((Element)v.get(1055));
      /* Termina nodo:1055   */

      /* Empieza nodo:1056 / Elemento padre: 1052   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1056)).setAttribute("ancho","26" );
      ((Element)v.get(1056)).setAttribute("minimizable","S" );
      ((Element)v.get(1056)).setAttribute("minimizada","N" );
      ((Element)v.get(1056)).setAttribute("oculta","S" );
      ((Element)v.get(1052)).appendChild((Element)v.get(1056));
      /* Termina nodo:1056   */

      /* Empieza nodo:1057 / Elemento padre: 1052   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1057)).setAttribute("ancho","26" );
      ((Element)v.get(1057)).setAttribute("minimizable","S" );
      ((Element)v.get(1057)).setAttribute("minimizada","N" );
      ((Element)v.get(1057)).setAttribute("oculta","S" );
      ((Element)v.get(1052)).appendChild((Element)v.get(1057));
      /* Termina nodo:1057   */
      /* Termina nodo:1052   */

      /* Empieza nodo:1058 / Elemento padre: 1042   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(1058)).setAttribute("alto","20" );
      ((Element)v.get(1058)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(1058)).setAttribute("imgFondo","" );
      ((Element)v.get(1058)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(1042)).appendChild((Element)v.get(1058));

      /* Empieza nodo:1059 / Elemento padre: 1058   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1059)).setAttribute("colFondo","" );
      ((Element)v.get(1059)).setAttribute("ID","EstCab" );
      ((Element)v.get(1059)).setAttribute("cod","1841" );
      ((Element)v.get(1058)).appendChild((Element)v.get(1059));

      /* Elemento padre:1059 / Elemento actual: 1060   */
      v.add(doc.createTextNode("Nº pago"));
      ((Element)v.get(1059)).appendChild((Text)v.get(1060));

      /* Termina nodo Texto:1060   */
      /* Termina nodo:1059   */

      /* Empieza nodo:1061 / Elemento padre: 1058   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1061)).setAttribute("colFondo","" );
      ((Element)v.get(1061)).setAttribute("ID","EstCab" );
      ((Element)v.get(1061)).setAttribute("cod","1784" );
      ((Element)v.get(1058)).appendChild((Element)v.get(1061));

      /* Elemento padre:1061 / Elemento actual: 1062   */
      v.add(doc.createTextNode("% Premio"));
      ((Element)v.get(1061)).appendChild((Text)v.get(1062));

      /* Termina nodo Texto:1062   */
      /* Termina nodo:1061   */

      /* Empieza nodo:1063 / Elemento padre: 1058   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1063)).setAttribute("colFondo","" );
      ((Element)v.get(1063)).setAttribute("ID","EstCab" );
      ((Element)v.get(1063)).setAttribute("cod","1842" );
      ((Element)v.get(1058)).appendChild((Element)v.get(1063));

      /* Elemento padre:1063 / Elemento actual: 1064   */
      v.add(doc.createTextNode("Período control"));
      ((Element)v.get(1063)).appendChild((Text)v.get(1064));

      /* Termina nodo Texto:1064   */
      /* Termina nodo:1063   */

      /* Empieza nodo:1065 / Elemento padre: 1058   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1065)).setAttribute("colFondo","" );
      ((Element)v.get(1065)).setAttribute("ID","EstCab" );
      ((Element)v.get(1058)).appendChild((Element)v.get(1065));

      /* Elemento padre:1065 / Elemento actual: 1066   */
      v.add(doc.createTextNode("oidPeriodoControl"));
      ((Element)v.get(1065)).appendChild((Text)v.get(1066));

      /* Termina nodo Texto:1066   */
      /* Termina nodo:1065   */

      /* Empieza nodo:1067 / Elemento padre: 1058   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1067)).setAttribute("colFondo","" );
      ((Element)v.get(1067)).setAttribute("ID","EstCab" );
      ((Element)v.get(1058)).appendChild((Element)v.get(1067));

      /* Elemento padre:1067 / Elemento actual: 1068   */
      v.add(doc.createTextNode("oidPago"));
      ((Element)v.get(1067)).appendChild((Text)v.get(1068));

      /* Termina nodo Texto:1068   */
      /* Termina nodo:1067   */
      /* Termina nodo:1058   */

      /* Empieza nodo:1069 / Elemento padre: 1042   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(1069)).setAttribute("alto","22" );
      ((Element)v.get(1069)).setAttribute("accion","" );
      ((Element)v.get(1069)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(1069)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(1069)).setAttribute("maxSel","-1" );
      ((Element)v.get(1069)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(1069)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(1069)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(1069)).setAttribute("onLoad","" );
      ((Element)v.get(1069)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(1042)).appendChild((Element)v.get(1069));

      /* Empieza nodo:1070 / Elemento padre: 1069   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1070)).setAttribute("tipo","texto" );
      ((Element)v.get(1070)).setAttribute("ID","EstDat" );
      ((Element)v.get(1069)).appendChild((Element)v.get(1070));
      /* Termina nodo:1070   */

      /* Empieza nodo:1071 / Elemento padre: 1069   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1071)).setAttribute("tipo","texto" );
      ((Element)v.get(1071)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1069)).appendChild((Element)v.get(1071));
      /* Termina nodo:1071   */

      /* Empieza nodo:1072 / Elemento padre: 1069   */
   }

   private void getXML4500(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(1072)).setAttribute("tipo","texto" );
      ((Element)v.get(1072)).setAttribute("ID","EstDat" );
      ((Element)v.get(1069)).appendChild((Element)v.get(1072));
      /* Termina nodo:1072   */

      /* Empieza nodo:1073 / Elemento padre: 1069   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1073)).setAttribute("tipo","texto" );
      ((Element)v.get(1073)).setAttribute("ID","EstDat" );
      ((Element)v.get(1069)).appendChild((Element)v.get(1073));
      /* Termina nodo:1073   */

      /* Empieza nodo:1074 / Elemento padre: 1069   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1074)).setAttribute("tipo","texto" );
      ((Element)v.get(1074)).setAttribute("ID","EstDat" );
      ((Element)v.get(1069)).appendChild((Element)v.get(1074));
      /* Termina nodo:1074   */
      /* Termina nodo:1069   */

      /* Empieza nodo:1075 / Elemento padre: 1042   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(1042)).appendChild((Element)v.get(1075));
      /* Termina nodo:1075   */

      /* Empieza nodo:1076 / Elemento padre: 1042   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(1076)).setAttribute("nombre","mipgndo1" );
      ((Element)v.get(1076)).setAttribute("ancho","703" );
      ((Element)v.get(1076)).setAttribute("sep","$" );
      ((Element)v.get(1076)).setAttribute("x","26" );
      ((Element)v.get(1076)).setAttribute("class","botonera" );
      ((Element)v.get(1076)).setAttribute("y","929" );
      ((Element)v.get(1076)).setAttribute("control","|" );
      ((Element)v.get(1076)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(1076)).setAttribute("rowset","" );
      ((Element)v.get(1076)).setAttribute("cargainicial","N" );
      ((Element)v.get(1042)).appendChild((Element)v.get(1076));

      /* Empieza nodo:1077 / Elemento padre: 1076   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1077)).setAttribute("nombre","ret1" );
      ((Element)v.get(1077)).setAttribute("x","51" );
      ((Element)v.get(1077)).setAttribute("y","933" );
      ((Element)v.get(1077)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1077)).setAttribute("img","retroceder_on" );
      ((Element)v.get(1077)).setAttribute("tipo","0" );
      ((Element)v.get(1077)).setAttribute("estado","false" );
      ((Element)v.get(1077)).setAttribute("alt","" );
      ((Element)v.get(1077)).setAttribute("codigo","" );
      ((Element)v.get(1077)).setAttribute("accion","mipgndo1.retroceder();" );
      ((Element)v.get(1076)).appendChild((Element)v.get(1077));
      /* Termina nodo:1077   */

      /* Empieza nodo:1078 / Elemento padre: 1076   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1078)).setAttribute("nombre","ava1" );
      ((Element)v.get(1078)).setAttribute("x","66" );
      ((Element)v.get(1078)).setAttribute("y","933" );
      ((Element)v.get(1078)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1078)).setAttribute("img","avanzar_on" );
      ((Element)v.get(1078)).setAttribute("tipo","0" );
      ((Element)v.get(1078)).setAttribute("estado","false" );
      ((Element)v.get(1078)).setAttribute("alt","" );
      ((Element)v.get(1078)).setAttribute("codigo","" );
      ((Element)v.get(1078)).setAttribute("accion","mipgndo1.avanzar();" );
      ((Element)v.get(1076)).appendChild((Element)v.get(1078));
      /* Termina nodo:1078   */
      /* Termina nodo:1076   */
      /* Termina nodo:1042   */

      /* Empieza nodo:1079 / Elemento padre: 37   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1079)).setAttribute("nombre","primera1" );
      ((Element)v.get(1079)).setAttribute("x","34" );
      ((Element)v.get(1079)).setAttribute("y","933" );
      ((Element)v.get(1079)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1079)).setAttribute("img","primera_on" );
      ((Element)v.get(1079)).setAttribute("tipo","-2" );
      ((Element)v.get(1079)).setAttribute("estado","false" );
      ((Element)v.get(1079)).setAttribute("alt","" );
      ((Element)v.get(1079)).setAttribute("codigo","" );
      ((Element)v.get(1079)).setAttribute("accion","mipgndo1.retrocederPrimeraPagina();" );
      ((Element)v.get(37)).appendChild((Element)v.get(1079));
      /* Termina nodo:1079   */

      /* Empieza nodo:1080 / Elemento padre: 37   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1080)).setAttribute("nombre","separa1" );
      ((Element)v.get(1080)).setAttribute("x","73" );
      ((Element)v.get(1080)).setAttribute("y","929" );
      ((Element)v.get(1080)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1080)).setAttribute("img","separa_base" );
      ((Element)v.get(1080)).setAttribute("tipo","0" );
      ((Element)v.get(1080)).setAttribute("estado","false" );
      ((Element)v.get(1080)).setAttribute("alt","" );
      ((Element)v.get(1080)).setAttribute("codigo","" );
      ((Element)v.get(1080)).setAttribute("accion","" );
      ((Element)v.get(37)).appendChild((Element)v.get(1080));
      /* Termina nodo:1080   */

      /* Empieza nodo:1081 / Elemento padre: 37   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1081)).setAttribute("nombre","btnEliminar2" );
      ((Element)v.get(1081)).setAttribute("x","27" );
      ((Element)v.get(1081)).setAttribute("y","930" );
      ((Element)v.get(1081)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1081)).setAttribute("accion","accionEliminarPago()" );
      ((Element)v.get(1081)).setAttribute("tipo","html" );
      ((Element)v.get(1081)).setAttribute("estado","false" );
      ((Element)v.get(1081)).setAttribute("cod","1254" );
      ((Element)v.get(37)).appendChild((Element)v.get(1081));
      /* Termina nodo:1081   */

      /* Empieza nodo:1082 / Elemento padre: 37   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(1082)).setAttribute("nombre","listado2" );
      ((Element)v.get(1082)).setAttribute("ancho","676" );
      ((Element)v.get(1082)).setAttribute("alto","278" );
      ((Element)v.get(1082)).setAttribute("x","40" );
      ((Element)v.get(1082)).setAttribute("y","910" );
   }

   private void getXML4590(Document doc) {
      ((Element)v.get(1082)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(1082)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(37)).appendChild((Element)v.get(1082));

      /* Empieza nodo:1083 / Elemento padre: 1082   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(1083)).setAttribute("precarga","S" );
      ((Element)v.get(1083)).setAttribute("conROver","S" );
      ((Element)v.get(1082)).appendChild((Element)v.get(1083));

      /* Empieza nodo:1084 / Elemento padre: 1083   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(1084)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(1084)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(1084)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(1084)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(1083)).appendChild((Element)v.get(1084));
      /* Termina nodo:1084   */

      /* Empieza nodo:1085 / Elemento padre: 1083   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(1085)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(1085)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(1085)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(1085)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(1083)).appendChild((Element)v.get(1085));
      /* Termina nodo:1085   */

      /* Empieza nodo:1086 / Elemento padre: 1083   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(1086)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(1086)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(1083)).appendChild((Element)v.get(1086));
      /* Termina nodo:1086   */
      /* Termina nodo:1083   */

      /* Empieza nodo:1087 / Elemento padre: 1082   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(1082)).appendChild((Element)v.get(1087));

      /* Empieza nodo:1088 / Elemento padre: 1087   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(1088)).setAttribute("borde","1" );
      ((Element)v.get(1088)).setAttribute("horizDatos","1" );
      ((Element)v.get(1088)).setAttribute("horizCabecera","1" );
      ((Element)v.get(1088)).setAttribute("vertical","0" );
      ((Element)v.get(1088)).setAttribute("horizTitulo","1" );
      ((Element)v.get(1088)).setAttribute("horizBase","1" );
      ((Element)v.get(1087)).appendChild((Element)v.get(1088));
      /* Termina nodo:1088   */

      /* Empieza nodo:1089 / Elemento padre: 1087   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(1089)).setAttribute("borde","#999999" );
      ((Element)v.get(1089)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(1089)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(1089)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(1089)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(1089)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(1089)).setAttribute("horizBase","#999999" );
      ((Element)v.get(1087)).appendChild((Element)v.get(1089));
      /* Termina nodo:1089   */
      /* Termina nodo:1087   */

      /* Empieza nodo:1090 / Elemento padre: 1082   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(1090)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(1090)).setAttribute("alto","22" );
      ((Element)v.get(1090)).setAttribute("imgFondo","" );
      ((Element)v.get(1090)).setAttribute("cod","00353" );
      ((Element)v.get(1090)).setAttribute("ID","datosTitle" );
      ((Element)v.get(1082)).appendChild((Element)v.get(1090));
      /* Termina nodo:1090   */

      /* Empieza nodo:1091 / Elemento padre: 1082   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(1091)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(1091)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(1091)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(1091)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(1091)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(1091)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(1082)).appendChild((Element)v.get(1091));

      /* Empieza nodo:1092 / Elemento padre: 1091   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1092)).setAttribute("ancho","80" );
      ((Element)v.get(1092)).setAttribute("minimizable","S" );
      ((Element)v.get(1092)).setAttribute("minimizada","N" );
      ((Element)v.get(1091)).appendChild((Element)v.get(1092));
      /* Termina nodo:1092   */

      /* Empieza nodo:1093 / Elemento padre: 1091   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1093)).setAttribute("ancho","80" );
      ((Element)v.get(1093)).setAttribute("minimizable","S" );
      ((Element)v.get(1093)).setAttribute("minimizada","N" );
      ((Element)v.get(1091)).appendChild((Element)v.get(1093));
      /* Termina nodo:1093   */

      /* Empieza nodo:1094 / Elemento padre: 1091   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1094)).setAttribute("ancho","80" );
      ((Element)v.get(1094)).setAttribute("minimizable","S" );
      ((Element)v.get(1094)).setAttribute("minimizada","N" );
      ((Element)v.get(1091)).appendChild((Element)v.get(1094));
      /* Termina nodo:1094   */

      /* Empieza nodo:1095 / Elemento padre: 1091   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1095)).setAttribute("ancho","80" );
      ((Element)v.get(1095)).setAttribute("minimizable","S" );
      ((Element)v.get(1095)).setAttribute("minimizada","N" );
      ((Element)v.get(1091)).appendChild((Element)v.get(1095));
      /* Termina nodo:1095   */

      /* Empieza nodo:1096 / Elemento padre: 1091   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1096)).setAttribute("ancho","80" );
      ((Element)v.get(1096)).setAttribute("minimizable","S" );
      ((Element)v.get(1096)).setAttribute("minimizada","N" );
      ((Element)v.get(1091)).appendChild((Element)v.get(1096));
      /* Termina nodo:1096   */

      /* Empieza nodo:1097 / Elemento padre: 1091   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1097)).setAttribute("ancho","80" );
      ((Element)v.get(1097)).setAttribute("minimizable","S" );
      ((Element)v.get(1097)).setAttribute("minimizada","N" );
      ((Element)v.get(1091)).appendChild((Element)v.get(1097));
      /* Termina nodo:1097   */

      /* Empieza nodo:1098 / Elemento padre: 1091   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1098)).setAttribute("ancho","110" );
      ((Element)v.get(1098)).setAttribute("minimizable","S" );
   }

   private void getXML4680(Document doc) {
      ((Element)v.get(1098)).setAttribute("minimizada","N" );
      ((Element)v.get(1091)).appendChild((Element)v.get(1098));
      /* Termina nodo:1098   */

      /* Empieza nodo:1099 / Elemento padre: 1091   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1099)).setAttribute("ancho","100" );
      ((Element)v.get(1099)).setAttribute("minimizable","S" );
      ((Element)v.get(1099)).setAttribute("minimizada","N" );
      ((Element)v.get(1091)).appendChild((Element)v.get(1099));
      /* Termina nodo:1099   */

      /* Empieza nodo:1100 / Elemento padre: 1091   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1100)).setAttribute("ancho","80" );
      ((Element)v.get(1100)).setAttribute("minimizable","S" );
      ((Element)v.get(1100)).setAttribute("minimizada","N" );
      ((Element)v.get(1091)).appendChild((Element)v.get(1100));
      /* Termina nodo:1100   */

      /* Empieza nodo:1101 / Elemento padre: 1091   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1101)).setAttribute("ancho","80" );
      ((Element)v.get(1101)).setAttribute("minimizable","S" );
      ((Element)v.get(1101)).setAttribute("minimizada","N" );
      ((Element)v.get(1091)).appendChild((Element)v.get(1101));
      /* Termina nodo:1101   */

      /* Empieza nodo:1102 / Elemento padre: 1091   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1102)).setAttribute("ancho","100" );
      ((Element)v.get(1102)).setAttribute("minimizable","S" );
      ((Element)v.get(1102)).setAttribute("minimizada","N" );
      ((Element)v.get(1091)).appendChild((Element)v.get(1102));
      /* Termina nodo:1102   */

      /* Empieza nodo:1103 / Elemento padre: 1091   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1103)).setAttribute("ancho","80" );
      ((Element)v.get(1103)).setAttribute("minimizable","S" );
      ((Element)v.get(1103)).setAttribute("minimizada","N" );
      ((Element)v.get(1103)).setAttribute("oculta","S" );
      ((Element)v.get(1091)).appendChild((Element)v.get(1103));
      /* Termina nodo:1103   */

      /* Empieza nodo:1104 / Elemento padre: 1091   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1104)).setAttribute("ancho","80" );
      ((Element)v.get(1104)).setAttribute("minimizable","S" );
      ((Element)v.get(1104)).setAttribute("minimizada","N" );
      ((Element)v.get(1104)).setAttribute("oculta","S" );
      ((Element)v.get(1091)).appendChild((Element)v.get(1104));
      /* Termina nodo:1104   */

      /* Empieza nodo:1105 / Elemento padre: 1091   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1105)).setAttribute("ancho","80" );
      ((Element)v.get(1105)).setAttribute("minimizable","S" );
      ((Element)v.get(1105)).setAttribute("minimizada","N" );
      ((Element)v.get(1105)).setAttribute("oculta","S" );
      ((Element)v.get(1091)).appendChild((Element)v.get(1105));
      /* Termina nodo:1105   */

      /* Empieza nodo:1106 / Elemento padre: 1091   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1106)).setAttribute("ancho","80" );
      ((Element)v.get(1106)).setAttribute("minimizable","S" );
      ((Element)v.get(1106)).setAttribute("minimizada","N" );
      ((Element)v.get(1106)).setAttribute("oculta","S" );
      ((Element)v.get(1091)).appendChild((Element)v.get(1106));
      /* Termina nodo:1106   */
      /* Termina nodo:1091   */

      /* Empieza nodo:1107 / Elemento padre: 1082   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(1107)).setAttribute("alto","50" );
      ((Element)v.get(1107)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(1107)).setAttribute("imgFondo","" );
      ((Element)v.get(1107)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(1082)).appendChild((Element)v.get(1107));

      /* Empieza nodo:1108 / Elemento padre: 1107   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1108)).setAttribute("colFondo","" );
      ((Element)v.get(1108)).setAttribute("ID","EstCab" );
      ((Element)v.get(1108)).setAttribute("cod","337" );
      ((Element)v.get(1107)).appendChild((Element)v.get(1108));

      /* Elemento padre:1108 / Elemento actual: 1109   */
      v.add(doc.createTextNode("Cód. producto"));
      ((Element)v.get(1108)).appendChild((Text)v.get(1109));

      /* Termina nodo Texto:1109   */
      /* Termina nodo:1108   */

      /* Empieza nodo:1110 / Elemento padre: 1107   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1110)).setAttribute("colFondo","" );
      ((Element)v.get(1110)).setAttribute("ID","EstCab" );
      ((Element)v.get(1110)).setAttribute("cod","495" );
      ((Element)v.get(1107)).appendChild((Element)v.get(1110));

      /* Elemento padre:1110 / Elemento actual: 1111   */
      v.add(doc.createTextNode("Nº unidades"));
      ((Element)v.get(1110)).appendChild((Text)v.get(1111));

      /* Termina nodo Texto:1111   */
      /* Termina nodo:1110   */

      /* Empieza nodo:1112 / Elemento padre: 1107   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1112)).setAttribute("colFondo","" );
      ((Element)v.get(1112)).setAttribute("ID","EstCab" );
      ((Element)v.get(1112)).setAttribute("cod","1854" );
      ((Element)v.get(1107)).appendChild((Element)v.get(1112));

      /* Elemento padre:1112 / Elemento actual: 1113   */
      v.add(doc.createTextNode("Precio público"));
      ((Element)v.get(1112)).appendChild((Text)v.get(1113));

      /* Termina nodo Texto:1113   */
      /* Termina nodo:1112   */

      /* Empieza nodo:1114 / Elemento padre: 1107   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1114)).setAttribute("colFondo","" );
      ((Element)v.get(1114)).setAttribute("ID","EstCab" );
      ((Element)v.get(1114)).setAttribute("cod","1851" );
      ((Element)v.get(1107)).appendChild((Element)v.get(1114));

      /* Elemento padre:1114 / Elemento actual: 1115   */
      v.add(doc.createTextNode("Despacha articulo"));
      ((Element)v.get(1114)).appendChild((Text)v.get(1115));

      /* Termina nodo Texto:1115   */
      /* Termina nodo:1114   */

      /* Empieza nodo:1116 / Elemento padre: 1107   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1116)).setAttribute("colFondo","" );
      ((Element)v.get(1116)).setAttribute("ID","EstCab" );
      ((Element)v.get(1116)).setAttribute("cod","1853" );
      ((Element)v.get(1107)).appendChild((Element)v.get(1116));

      /* Elemento padre:1116 / Elemento actual: 1117   */
      v.add(doc.createTextNode("Cód. venta ficticio"));
      ((Element)v.get(1116)).appendChild((Text)v.get(1117));

      /* Termina nodo Texto:1117   */
      /* Termina nodo:1116   */

      /* Empieza nodo:1118 / Elemento padre: 1107   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1118)).setAttribute("colFondo","" );
      ((Element)v.get(1118)).setAttribute("ID","EstCab" );
   }

   private void getXML4770(Document doc) {
      ((Element)v.get(1118)).setAttribute("cod","3184" );
      ((Element)v.get(1107)).appendChild((Element)v.get(1118));

      /* Elemento padre:1118 / Elemento actual: 1119   */
      v.add(doc.createTextNode("Ind Centro Servicio Garantia"));
      ((Element)v.get(1118)).appendChild((Text)v.get(1119));

      /* Termina nodo Texto:1119   */
      /* Termina nodo:1118   */

      /* Empieza nodo:1120 / Elemento padre: 1107   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1120)).setAttribute("colFondo","" );
      ((Element)v.get(1120)).setAttribute("ID","EstCab" );
      ((Element)v.get(1120)).setAttribute("cod","3185" );
      ((Element)v.get(1107)).appendChild((Element)v.get(1120));

      /* Elemento padre:1120 / Elemento actual: 1121   */
      v.add(doc.createTextNode("Centro Servicio Garantia"));
      ((Element)v.get(1120)).appendChild((Text)v.get(1121));

      /* Termina nodo Texto:1121   */
      /* Termina nodo:1120   */

      /* Empieza nodo:1122 / Elemento padre: 1107   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1122)).setAttribute("colFondo","" );
      ((Element)v.get(1122)).setAttribute("ID","EstCab" );
      ((Element)v.get(1122)).setAttribute("cod","3186" );
      ((Element)v.get(1107)).appendChild((Element)v.get(1122));

      /* Elemento padre:1122 / Elemento actual: 1123   */
      v.add(doc.createTextNode("Num de meses"));
      ((Element)v.get(1122)).appendChild((Text)v.get(1123));

      /* Termina nodo Texto:1123   */
      /* Termina nodo:1122   */

      /* Empieza nodo:1124 / Elemento padre: 1107   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1124)).setAttribute("colFondo","" );
      ((Element)v.get(1124)).setAttribute("ID","EstCab" );
      ((Element)v.get(1124)).setAttribute("cod","169" );
      ((Element)v.get(1107)).appendChild((Element)v.get(1124));

      /* Elemento padre:1124 / Elemento actual: 1125   */
      v.add(doc.createTextNode("Observaciones"));
      ((Element)v.get(1124)).appendChild((Text)v.get(1125));

      /* Termina nodo Texto:1125   */
      /* Termina nodo:1124   */

      /* Empieza nodo:1126 / Elemento padre: 1107   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1126)).setAttribute("colFondo","" );
      ((Element)v.get(1126)).setAttribute("ID","EstCab" );
      ((Element)v.get(1126)).setAttribute("cod","3187" );
      ((Element)v.get(1107)).appendChild((Element)v.get(1126));

      /* Elemento padre:1126 / Elemento actual: 1127   */
      v.add(doc.createTextNode("Tipo de entrega"));
      ((Element)v.get(1126)).appendChild((Text)v.get(1127));

      /* Termina nodo Texto:1127   */
      /* Termina nodo:1126   */

      /* Empieza nodo:1128 / Elemento padre: 1107   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1128)).setAttribute("colFondo","" );
      ((Element)v.get(1128)).setAttribute("ID","EstCab" );
      ((Element)v.get(1128)).setAttribute("cod","3188" );
      ((Element)v.get(1107)).appendChild((Element)v.get(1128));

      /* Elemento padre:1128 / Elemento actual: 1129   */
      v.add(doc.createTextNode("Centro Servicio Entrega"));
      ((Element)v.get(1128)).appendChild((Text)v.get(1129));

      /* Termina nodo Texto:1129   */
      /* Termina nodo:1128   */

      /* Empieza nodo:1130 / Elemento padre: 1107   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1130)).setAttribute("colFondo","" );
      ((Element)v.get(1130)).setAttribute("ID","EstCab" );
      ((Element)v.get(1107)).appendChild((Element)v.get(1130));

      /* Elemento padre:1130 / Elemento actual: 1131   */
      v.add(doc.createTextNode("oidCentSerGar"));
      ((Element)v.get(1130)).appendChild((Text)v.get(1131));

      /* Termina nodo Texto:1131   */
      /* Termina nodo:1130   */

      /* Empieza nodo:1132 / Elemento padre: 1107   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1132)).setAttribute("colFondo","" );
      ((Element)v.get(1132)).setAttribute("ID","EstCab" );
      ((Element)v.get(1107)).appendChild((Element)v.get(1132));

      /* Elemento padre:1132 / Elemento actual: 1133   */
      v.add(doc.createTextNode("oidCentSerEntrega"));
      ((Element)v.get(1132)).appendChild((Text)v.get(1133));

      /* Termina nodo Texto:1133   */
      /* Termina nodo:1132   */

      /* Empieza nodo:1134 / Elemento padre: 1107   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1134)).setAttribute("colFondo","" );
      ((Element)v.get(1134)).setAttribute("ID","EstCab" );
      ((Element)v.get(1107)).appendChild((Element)v.get(1134));

      /* Elemento padre:1134 / Elemento actual: 1135   */
      v.add(doc.createTextNode("oidProdArticulo"));
      ((Element)v.get(1134)).appendChild((Text)v.get(1135));

      /* Termina nodo Texto:1135   */
      /* Termina nodo:1134   */

      /* Empieza nodo:1136 / Elemento padre: 1107   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1136)).setAttribute("colFondo","" );
      ((Element)v.get(1136)).setAttribute("ID","EstCab" );
      ((Element)v.get(1107)).appendChild((Element)v.get(1136));

      /* Elemento padre:1136 / Elemento actual: 1137   */
      v.add(doc.createTextNode("oidProductoLote"));
      ((Element)v.get(1136)).appendChild((Text)v.get(1137));

      /* Termina nodo Texto:1137   */
      /* Termina nodo:1136   */
      /* Termina nodo:1107   */

      /* Empieza nodo:1138 / Elemento padre: 1082   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(1138)).setAttribute("alto","22" );
      ((Element)v.get(1138)).setAttribute("accion","" );
      ((Element)v.get(1138)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(1138)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(1138)).setAttribute("maxSel","-1" );
      ((Element)v.get(1138)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(1138)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(1138)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(1138)).setAttribute("onLoad","" );
      ((Element)v.get(1138)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(1082)).appendChild((Element)v.get(1138));

      /* Empieza nodo:1139 / Elemento padre: 1138   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1139)).setAttribute("tipo","texto" );
      ((Element)v.get(1139)).setAttribute("ID","EstDat" );
      ((Element)v.get(1138)).appendChild((Element)v.get(1139));
      /* Termina nodo:1139   */

      /* Empieza nodo:1140 / Elemento padre: 1138   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1140)).setAttribute("tipo","texto" );
      ((Element)v.get(1140)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1138)).appendChild((Element)v.get(1140));
      /* Termina nodo:1140   */

      /* Empieza nodo:1141 / Elemento padre: 1138   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1141)).setAttribute("tipo","texto" );
      ((Element)v.get(1141)).setAttribute("ID","EstDat" );
      ((Element)v.get(1138)).appendChild((Element)v.get(1141));
      /* Termina nodo:1141   */

      /* Empieza nodo:1142 / Elemento padre: 1138   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1142)).setAttribute("tipo","texto" );
      ((Element)v.get(1142)).setAttribute("ID","EstDat2" );
   }

   private void getXML4860(Document doc) {
      ((Element)v.get(1138)).appendChild((Element)v.get(1142));
      /* Termina nodo:1142   */

      /* Empieza nodo:1143 / Elemento padre: 1138   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1143)).setAttribute("tipo","texto" );
      ((Element)v.get(1143)).setAttribute("ID","EstDat" );
      ((Element)v.get(1138)).appendChild((Element)v.get(1143));
      /* Termina nodo:1143   */

      /* Empieza nodo:1144 / Elemento padre: 1138   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1144)).setAttribute("tipo","texto" );
      ((Element)v.get(1144)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1138)).appendChild((Element)v.get(1144));
      /* Termina nodo:1144   */

      /* Empieza nodo:1145 / Elemento padre: 1138   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1145)).setAttribute("tipo","texto" );
      ((Element)v.get(1145)).setAttribute("ID","EstDat" );
      ((Element)v.get(1138)).appendChild((Element)v.get(1145));
      /* Termina nodo:1145   */

      /* Empieza nodo:1146 / Elemento padre: 1138   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1146)).setAttribute("tipo","texto" );
      ((Element)v.get(1146)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1138)).appendChild((Element)v.get(1146));
      /* Termina nodo:1146   */

      /* Empieza nodo:1147 / Elemento padre: 1138   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1147)).setAttribute("tipo","texto" );
      ((Element)v.get(1147)).setAttribute("ID","EstDat" );
      ((Element)v.get(1138)).appendChild((Element)v.get(1147));
      /* Termina nodo:1147   */

      /* Empieza nodo:1148 / Elemento padre: 1138   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1148)).setAttribute("tipo","texto" );
      ((Element)v.get(1148)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1138)).appendChild((Element)v.get(1148));
      /* Termina nodo:1148   */

      /* Empieza nodo:1149 / Elemento padre: 1138   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1149)).setAttribute("tipo","texto" );
      ((Element)v.get(1149)).setAttribute("ID","EstDat" );
      ((Element)v.get(1138)).appendChild((Element)v.get(1149));
      /* Termina nodo:1149   */

      /* Empieza nodo:1150 / Elemento padre: 1138   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1150)).setAttribute("tipo","texto" );
      ((Element)v.get(1150)).setAttribute("ID","EstDat" );
      ((Element)v.get(1138)).appendChild((Element)v.get(1150));
      /* Termina nodo:1150   */

      /* Empieza nodo:1151 / Elemento padre: 1138   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1151)).setAttribute("tipo","texto" );
      ((Element)v.get(1151)).setAttribute("ID","EstDat" );
      ((Element)v.get(1138)).appendChild((Element)v.get(1151));
      /* Termina nodo:1151   */

      /* Empieza nodo:1152 / Elemento padre: 1138   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1152)).setAttribute("tipo","texto" );
      ((Element)v.get(1152)).setAttribute("ID","EstDat" );
      ((Element)v.get(1138)).appendChild((Element)v.get(1152));
      /* Termina nodo:1152   */

      /* Empieza nodo:1153 / Elemento padre: 1138   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1153)).setAttribute("tipo","texto" );
      ((Element)v.get(1153)).setAttribute("ID","EstDat" );
      ((Element)v.get(1138)).appendChild((Element)v.get(1153));
      /* Termina nodo:1153   */
      /* Termina nodo:1138   */

      /* Empieza nodo:1154 / Elemento padre: 1082   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(1082)).appendChild((Element)v.get(1154));
      /* Termina nodo:1154   */

      /* Empieza nodo:1155 / Elemento padre: 1082   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(1155)).setAttribute("nombre","mipgndo2" );
      ((Element)v.get(1155)).setAttribute("ancho","676" );
      ((Element)v.get(1155)).setAttribute("sep","$" );
      ((Element)v.get(1155)).setAttribute("x","40" );
      ((Element)v.get(1155)).setAttribute("class","botonera" );
      ((Element)v.get(1155)).setAttribute("y","1177" );
      ((Element)v.get(1155)).setAttribute("control","|" );
      ((Element)v.get(1155)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(1155)).setAttribute("rowset","" );
      ((Element)v.get(1155)).setAttribute("cargainicial","N" );
      ((Element)v.get(1082)).appendChild((Element)v.get(1155));

      /* Empieza nodo:1156 / Elemento padre: 1155   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1156)).setAttribute("nombre","ret2" );
      ((Element)v.get(1156)).setAttribute("x","63" );
      ((Element)v.get(1156)).setAttribute("y","1181" );
      ((Element)v.get(1156)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1156)).setAttribute("img","retroceder_on" );
      ((Element)v.get(1156)).setAttribute("tipo","0" );
      ((Element)v.get(1156)).setAttribute("estado","false" );
      ((Element)v.get(1156)).setAttribute("alt","" );
      ((Element)v.get(1156)).setAttribute("codigo","" );
      ((Element)v.get(1156)).setAttribute("accion","mipgndo2.retroceder();" );
      ((Element)v.get(1155)).appendChild((Element)v.get(1156));
      /* Termina nodo:1156   */

      /* Empieza nodo:1157 / Elemento padre: 1155   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1157)).setAttribute("nombre","ava2" );
      ((Element)v.get(1157)).setAttribute("x","78" );
      ((Element)v.get(1157)).setAttribute("y","1181" );
      ((Element)v.get(1157)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1157)).setAttribute("img","avanzar_on" );
      ((Element)v.get(1157)).setAttribute("tipo","0" );
      ((Element)v.get(1157)).setAttribute("estado","false" );
      ((Element)v.get(1157)).setAttribute("alt","" );
      ((Element)v.get(1157)).setAttribute("codigo","" );
      ((Element)v.get(1157)).setAttribute("accion","mipgndo2.avanzar();" );
      ((Element)v.get(1155)).appendChild((Element)v.get(1157));
      /* Termina nodo:1157   */
      /* Termina nodo:1155   */
      /* Termina nodo:1082   */

      /* Empieza nodo:1158 / Elemento padre: 37   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1158)).setAttribute("nombre","primera2" );
      ((Element)v.get(1158)).setAttribute("x","56" );
      ((Element)v.get(1158)).setAttribute("y","1181" );
      ((Element)v.get(1158)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1158)).setAttribute("img","primera_on" );
      ((Element)v.get(1158)).setAttribute("tipo","-2" );
   }

   private void getXML4950(Document doc) {
      ((Element)v.get(1158)).setAttribute("estado","false" );
      ((Element)v.get(1158)).setAttribute("alt","" );
      ((Element)v.get(1158)).setAttribute("codigo","" );
      ((Element)v.get(1158)).setAttribute("accion","mipgndo2.retrocederPrimeraPagina();" );
      ((Element)v.get(37)).appendChild((Element)v.get(1158));
      /* Termina nodo:1158   */

      /* Empieza nodo:1159 / Elemento padre: 37   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1159)).setAttribute("nombre","separa2" );
      ((Element)v.get(1159)).setAttribute("x","85" );
      ((Element)v.get(1159)).setAttribute("y","1177" );
      ((Element)v.get(1159)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1159)).setAttribute("img","separa_base" );
      ((Element)v.get(1159)).setAttribute("tipo","0" );
      ((Element)v.get(1159)).setAttribute("estado","false" );
      ((Element)v.get(1159)).setAttribute("alt","" );
      ((Element)v.get(1159)).setAttribute("codigo","" );
      ((Element)v.get(1159)).setAttribute("accion","" );
      ((Element)v.get(37)).appendChild((Element)v.get(1159));
      /* Termina nodo:1159   */

      /* Empieza nodo:1160 / Elemento padre: 37   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(1160)).setAttribute("nombre","listado4" );
      ((Element)v.get(1160)).setAttribute("ancho","703" );
      ((Element)v.get(1160)).setAttribute("alto","278" );
      ((Element)v.get(1160)).setAttribute("x","26" );
      ((Element)v.get(1160)).setAttribute("y","400" );
      ((Element)v.get(1160)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(1160)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(37)).appendChild((Element)v.get(1160));

      /* Empieza nodo:1161 / Elemento padre: 1160   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(1161)).setAttribute("precarga","S" );
      ((Element)v.get(1161)).setAttribute("conROver","S" );
      ((Element)v.get(1160)).appendChild((Element)v.get(1161));

      /* Empieza nodo:1162 / Elemento padre: 1161   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(1162)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(1162)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(1162)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(1162)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(1161)).appendChild((Element)v.get(1162));
      /* Termina nodo:1162   */

      /* Empieza nodo:1163 / Elemento padre: 1161   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(1163)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(1163)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(1163)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(1163)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(1161)).appendChild((Element)v.get(1163));
      /* Termina nodo:1163   */

      /* Empieza nodo:1164 / Elemento padre: 1161   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(1164)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(1164)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(1161)).appendChild((Element)v.get(1164));
      /* Termina nodo:1164   */
      /* Termina nodo:1161   */

      /* Empieza nodo:1165 / Elemento padre: 1160   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(1160)).appendChild((Element)v.get(1165));

      /* Empieza nodo:1166 / Elemento padre: 1165   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(1166)).setAttribute("borde","1" );
      ((Element)v.get(1166)).setAttribute("horizDatos","1" );
      ((Element)v.get(1166)).setAttribute("horizCabecera","1" );
      ((Element)v.get(1166)).setAttribute("vertical","0" );
      ((Element)v.get(1166)).setAttribute("horizTitulo","1" );
      ((Element)v.get(1166)).setAttribute("horizBase","1" );
      ((Element)v.get(1165)).appendChild((Element)v.get(1166));
      /* Termina nodo:1166   */

      /* Empieza nodo:1167 / Elemento padre: 1165   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(1167)).setAttribute("borde","#999999" );
      ((Element)v.get(1167)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(1167)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(1167)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(1167)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(1167)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(1167)).setAttribute("horizBase","#999999" );
      ((Element)v.get(1165)).appendChild((Element)v.get(1167));
      /* Termina nodo:1167   */
      /* Termina nodo:1165   */

      /* Empieza nodo:1168 / Elemento padre: 1160   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(1168)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(1168)).setAttribute("alto","22" );
      ((Element)v.get(1168)).setAttribute("imgFondo","" );
      ((Element)v.get(1168)).setAttribute("cod","00592" );
      ((Element)v.get(1168)).setAttribute("ID","datosTitle" );
      ((Element)v.get(1160)).appendChild((Element)v.get(1168));
      /* Termina nodo:1168   */

      /* Empieza nodo:1169 / Elemento padre: 1160   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(1169)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(1169)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(1169)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(1169)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(1169)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(1169)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(1160)).appendChild((Element)v.get(1169));

      /* Empieza nodo:1170 / Elemento padre: 1169   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1170)).setAttribute("ancho","26" );
      ((Element)v.get(1170)).setAttribute("minimizable","S" );
      ((Element)v.get(1170)).setAttribute("minimizada","N" );
      ((Element)v.get(1169)).appendChild((Element)v.get(1170));
      /* Termina nodo:1170   */

      /* Empieza nodo:1171 / Elemento padre: 1169   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1171)).setAttribute("ancho","26" );
      ((Element)v.get(1171)).setAttribute("minimizable","S" );
      ((Element)v.get(1171)).setAttribute("minimizada","N" );
      ((Element)v.get(1169)).appendChild((Element)v.get(1171));
      /* Termina nodo:1171   */

      /* Empieza nodo:1172 / Elemento padre: 1169   */
   }

   private void getXML5040(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(1172)).setAttribute("ancho","26" );
      ((Element)v.get(1172)).setAttribute("minimizable","S" );
      ((Element)v.get(1172)).setAttribute("minimizada","N" );
      ((Element)v.get(1172)).setAttribute("oculta","S" );
      ((Element)v.get(1169)).appendChild((Element)v.get(1172));
      /* Termina nodo:1172   */

      /* Empieza nodo:1173 / Elemento padre: 1169   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1173)).setAttribute("ancho","26" );
      ((Element)v.get(1173)).setAttribute("minimizable","S" );
      ((Element)v.get(1173)).setAttribute("minimizada","N" );
      ((Element)v.get(1173)).setAttribute("oculta","S" );
      ((Element)v.get(1169)).appendChild((Element)v.get(1173));
      /* Termina nodo:1173   */
      /* Termina nodo:1169   */

      /* Empieza nodo:1174 / Elemento padre: 1160   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(1174)).setAttribute("alto","20" );
      ((Element)v.get(1174)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(1174)).setAttribute("imgFondo","" );
      ((Element)v.get(1174)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(1160)).appendChild((Element)v.get(1174));

      /* Empieza nodo:1175 / Elemento padre: 1174   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1175)).setAttribute("colFondo","" );
      ((Element)v.get(1175)).setAttribute("ID","EstCab" );
      ((Element)v.get(1175)).setAttribute("cod","1691" );
      ((Element)v.get(1174)).appendChild((Element)v.get(1175));

      /* Elemento padre:1175 / Elemento actual: 1176   */
      v.add(doc.createTextNode("Nº premio"));
      ((Element)v.get(1175)).appendChild((Text)v.get(1176));

      /* Termina nodo Texto:1176   */
      /* Termina nodo:1175   */

      /* Empieza nodo:1177 / Elemento padre: 1174   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1177)).setAttribute("colFondo","" );
      ((Element)v.get(1177)).setAttribute("ID","EstCab" );
      ((Element)v.get(1177)).setAttribute("cod","844" );
      ((Element)v.get(1174)).appendChild((Element)v.get(1177));

      /* Elemento padre:1177 / Elemento actual: 1178   */
      v.add(doc.createTextNode("Descripción lote"));
      ((Element)v.get(1177)).appendChild((Text)v.get(1178));

      /* Termina nodo Texto:1178   */
      /* Termina nodo:1177   */

      /* Empieza nodo:1179 / Elemento padre: 1174   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1179)).setAttribute("colFondo","" );
      ((Element)v.get(1179)).setAttribute("ID","EstCab" );
      ((Element)v.get(1174)).appendChild((Element)v.get(1179));

      /* Elemento padre:1179 / Elemento actual: 1180   */
      v.add(doc.createTextNode("oidLote"));
      ((Element)v.get(1179)).appendChild((Text)v.get(1180));

      /* Termina nodo Texto:1180   */
      /* Termina nodo:1179   */

      /* Empieza nodo:1181 / Elemento padre: 1174   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1181)).setAttribute("colFondo","" );
      ((Element)v.get(1181)).setAttribute("ID","EstCab" );
      ((Element)v.get(1174)).appendChild((Element)v.get(1181));

      /* Elemento padre:1181 / Elemento actual: 1182   */
      v.add(doc.createTextNode("listProdLote"));
      ((Element)v.get(1181)).appendChild((Text)v.get(1182));

      /* Termina nodo Texto:1182   */
      /* Termina nodo:1181   */
      /* Termina nodo:1174   */

      /* Empieza nodo:1183 / Elemento padre: 1160   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(1183)).setAttribute("alto","22" );
      ((Element)v.get(1183)).setAttribute("accion","onSelectLotesPremio(FILAEVENTO);" );
      ((Element)v.get(1183)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(1183)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(1183)).setAttribute("maxSel","1" );
      ((Element)v.get(1183)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(1183)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(1183)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(1183)).setAttribute("onLoad","" );
      ((Element)v.get(1183)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(1160)).appendChild((Element)v.get(1183));

      /* Empieza nodo:1184 / Elemento padre: 1183   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1184)).setAttribute("tipo","texto" );
      ((Element)v.get(1184)).setAttribute("ID","EstDat" );
      ((Element)v.get(1183)).appendChild((Element)v.get(1184));
      /* Termina nodo:1184   */

      /* Empieza nodo:1185 / Elemento padre: 1183   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1185)).setAttribute("tipo","texto" );
      ((Element)v.get(1185)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1183)).appendChild((Element)v.get(1185));
      /* Termina nodo:1185   */

      /* Empieza nodo:1186 / Elemento padre: 1183   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1186)).setAttribute("tipo","texto" );
      ((Element)v.get(1186)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1183)).appendChild((Element)v.get(1186));
      /* Termina nodo:1186   */

      /* Empieza nodo:1187 / Elemento padre: 1183   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1187)).setAttribute("tipo","texto" );
      ((Element)v.get(1187)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1183)).appendChild((Element)v.get(1187));
      /* Termina nodo:1187   */
      /* Termina nodo:1183   */

      /* Empieza nodo:1188 / Elemento padre: 1160   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(1160)).appendChild((Element)v.get(1188));
      /* Termina nodo:1188   */

      /* Empieza nodo:1189 / Elemento padre: 1160   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(1189)).setAttribute("nombre","mipgndo4" );
      ((Element)v.get(1189)).setAttribute("ancho","703" );
      ((Element)v.get(1189)).setAttribute("sep","$" );
      ((Element)v.get(1189)).setAttribute("x","26" );
      ((Element)v.get(1189)).setAttribute("class","botonera" );
      ((Element)v.get(1189)).setAttribute("y","677" );
      ((Element)v.get(1189)).setAttribute("control","|" );
      ((Element)v.get(1189)).setAttribute("conector","conectorSandra1" );
      ((Element)v.get(1189)).setAttribute("rowset","" );
      ((Element)v.get(1189)).setAttribute("cargainicial","N" );
      ((Element)v.get(1160)).appendChild((Element)v.get(1189));

      /* Empieza nodo:1190 / Elemento padre: 1189   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1190)).setAttribute("nombre","ret4" );
      ((Element)v.get(1190)).setAttribute("x","51" );
      ((Element)v.get(1190)).setAttribute("y","681" );
   }

   private void getXML5130(Document doc) {
      ((Element)v.get(1190)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1190)).setAttribute("img","retroceder_on" );
      ((Element)v.get(1190)).setAttribute("tipo","0" );
      ((Element)v.get(1190)).setAttribute("estado","false" );
      ((Element)v.get(1190)).setAttribute("alt","" );
      ((Element)v.get(1190)).setAttribute("codigo","" );
      ((Element)v.get(1190)).setAttribute("accion","mipgndo4.retroceder();" );
      ((Element)v.get(1189)).appendChild((Element)v.get(1190));
      /* Termina nodo:1190   */

      /* Empieza nodo:1191 / Elemento padre: 1189   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1191)).setAttribute("nombre","ava4" );
      ((Element)v.get(1191)).setAttribute("x","66" );
      ((Element)v.get(1191)).setAttribute("y","681" );
      ((Element)v.get(1191)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1191)).setAttribute("img","avanzar_on" );
      ((Element)v.get(1191)).setAttribute("tipo","0" );
      ((Element)v.get(1191)).setAttribute("estado","false" );
      ((Element)v.get(1191)).setAttribute("alt","" );
      ((Element)v.get(1191)).setAttribute("codigo","" );
      ((Element)v.get(1191)).setAttribute("accion","mipgndo4.avanzar();" );
      ((Element)v.get(1189)).appendChild((Element)v.get(1191));
      /* Termina nodo:1191   */
      /* Termina nodo:1189   */
      /* Termina nodo:1160   */

      /* Empieza nodo:1192 / Elemento padre: 37   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1192)).setAttribute("nombre","primera4" );
      ((Element)v.get(1192)).setAttribute("x","34" );
      ((Element)v.get(1192)).setAttribute("y","681" );
      ((Element)v.get(1192)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1192)).setAttribute("img","primera_on" );
      ((Element)v.get(1192)).setAttribute("tipo","-2" );
      ((Element)v.get(1192)).setAttribute("estado","false" );
      ((Element)v.get(1192)).setAttribute("alt","" );
      ((Element)v.get(1192)).setAttribute("codigo","" );
      ((Element)v.get(1192)).setAttribute("accion","mipgndo4.retrocederPrimeraPagina();" );
      ((Element)v.get(37)).appendChild((Element)v.get(1192));
      /* Termina nodo:1192   */

      /* Empieza nodo:1193 / Elemento padre: 37   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1193)).setAttribute("nombre","separa4" );
      ((Element)v.get(1193)).setAttribute("x","73" );
      ((Element)v.get(1193)).setAttribute("y","677" );
      ((Element)v.get(1193)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1193)).setAttribute("img","separa_base" );
      ((Element)v.get(1193)).setAttribute("tipo","0" );
      ((Element)v.get(1193)).setAttribute("estado","false" );
      ((Element)v.get(1193)).setAttribute("alt","" );
      ((Element)v.get(1193)).setAttribute("codigo","" );
      ((Element)v.get(1193)).setAttribute("accion","" );
      ((Element)v.get(37)).appendChild((Element)v.get(1193));
      /* Termina nodo:1193   */

      /* Empieza nodo:1194 / Elemento padre: 37   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(1194)).setAttribute("nombre","listado3" );
      ((Element)v.get(1194)).setAttribute("ancho","703" );
      ((Element)v.get(1194)).setAttribute("alto","317" );
      ((Element)v.get(1194)).setAttribute("x","26" );
      ((Element)v.get(1194)).setAttribute("y","614" );
      ((Element)v.get(1194)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(1194)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(37)).appendChild((Element)v.get(1194));

      /* Empieza nodo:1195 / Elemento padre: 1194   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(1195)).setAttribute("precarga","S" );
      ((Element)v.get(1195)).setAttribute("conROver","S" );
      ((Element)v.get(1194)).appendChild((Element)v.get(1195));

      /* Empieza nodo:1196 / Elemento padre: 1195   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(1196)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(1196)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(1196)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(1196)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(1195)).appendChild((Element)v.get(1196));
      /* Termina nodo:1196   */

      /* Empieza nodo:1197 / Elemento padre: 1195   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(1197)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(1197)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(1197)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(1197)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(1195)).appendChild((Element)v.get(1197));
      /* Termina nodo:1197   */

      /* Empieza nodo:1198 / Elemento padre: 1195   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(1198)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(1198)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(1195)).appendChild((Element)v.get(1198));
      /* Termina nodo:1198   */
      /* Termina nodo:1195   */

      /* Empieza nodo:1199 / Elemento padre: 1194   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(1194)).appendChild((Element)v.get(1199));

      /* Empieza nodo:1200 / Elemento padre: 1199   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(1200)).setAttribute("borde","1" );
      ((Element)v.get(1200)).setAttribute("horizDatos","1" );
      ((Element)v.get(1200)).setAttribute("horizCabecera","1" );
      ((Element)v.get(1200)).setAttribute("vertical","0" );
      ((Element)v.get(1200)).setAttribute("horizTitulo","1" );
      ((Element)v.get(1200)).setAttribute("horizBase","1" );
      ((Element)v.get(1199)).appendChild((Element)v.get(1200));
      /* Termina nodo:1200   */

      /* Empieza nodo:1201 / Elemento padre: 1199   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(1201)).setAttribute("borde","#999999" );
      ((Element)v.get(1201)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(1201)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(1201)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(1201)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(1201)).setAttribute("horizTitulo","#999999" );
   }

   private void getXML5220(Document doc) {
      ((Element)v.get(1201)).setAttribute("horizBase","#999999" );
      ((Element)v.get(1199)).appendChild((Element)v.get(1201));
      /* Termina nodo:1201   */
      /* Termina nodo:1199   */

      /* Empieza nodo:1202 / Elemento padre: 1194   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(1202)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(1202)).setAttribute("alto","22" );
      ((Element)v.get(1202)).setAttribute("imgFondo","" );
      ((Element)v.get(1202)).setAttribute("cod","00357" );
      ((Element)v.get(1202)).setAttribute("ID","datosTitle" );
      ((Element)v.get(1194)).appendChild((Element)v.get(1202));
      /* Termina nodo:1202   */

      /* Empieza nodo:1203 / Elemento padre: 1194   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(1203)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(1203)).setAttribute("alto","22" );
      ((Element)v.get(1203)).setAttribute("imgFondo","" );
      ((Element)v.get(1194)).appendChild((Element)v.get(1203));
      /* Termina nodo:1203   */

      /* Empieza nodo:1204 / Elemento padre: 1194   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(1204)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(1204)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(1204)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(1204)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(1204)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(1204)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(1194)).appendChild((Element)v.get(1204));

      /* Empieza nodo:1205 / Elemento padre: 1204   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1205)).setAttribute("ancho","80" );
      ((Element)v.get(1205)).setAttribute("minimizable","S" );
      ((Element)v.get(1205)).setAttribute("minimizada","N" );
      ((Element)v.get(1204)).appendChild((Element)v.get(1205));
      /* Termina nodo:1205   */

      /* Empieza nodo:1206 / Elemento padre: 1204   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1206)).setAttribute("ancho","80" );
      ((Element)v.get(1206)).setAttribute("minimizable","S" );
      ((Element)v.get(1206)).setAttribute("minimizada","N" );
      ((Element)v.get(1204)).appendChild((Element)v.get(1206));
      /* Termina nodo:1206   */

      /* Empieza nodo:1207 / Elemento padre: 1204   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1207)).setAttribute("ancho","80" );
      ((Element)v.get(1207)).setAttribute("minimizable","S" );
      ((Element)v.get(1207)).setAttribute("minimizada","N" );
      ((Element)v.get(1204)).appendChild((Element)v.get(1207));
      /* Termina nodo:1207   */

      /* Empieza nodo:1208 / Elemento padre: 1204   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1208)).setAttribute("ancho","80" );
      ((Element)v.get(1208)).setAttribute("minimizable","S" );
      ((Element)v.get(1208)).setAttribute("minimizada","N" );
      ((Element)v.get(1204)).appendChild((Element)v.get(1208));
      /* Termina nodo:1208   */

      /* Empieza nodo:1209 / Elemento padre: 1204   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1209)).setAttribute("ancho","80" );
      ((Element)v.get(1209)).setAttribute("minimizable","S" );
      ((Element)v.get(1209)).setAttribute("minimizada","N" );
      ((Element)v.get(1204)).appendChild((Element)v.get(1209));
      /* Termina nodo:1209   */

      /* Empieza nodo:1210 / Elemento padre: 1204   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1210)).setAttribute("ancho","80" );
      ((Element)v.get(1210)).setAttribute("minimizable","S" );
      ((Element)v.get(1210)).setAttribute("minimizada","N" );
      ((Element)v.get(1204)).appendChild((Element)v.get(1210));
      /* Termina nodo:1210   */

      /* Empieza nodo:1211 / Elemento padre: 1204   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1211)).setAttribute("ancho","80" );
      ((Element)v.get(1211)).setAttribute("minimizable","S" );
      ((Element)v.get(1211)).setAttribute("minimizada","N" );
      ((Element)v.get(1211)).setAttribute("oculta","S" );
      ((Element)v.get(1204)).appendChild((Element)v.get(1211));
      /* Termina nodo:1211   */

      /* Empieza nodo:1212 / Elemento padre: 1204   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1212)).setAttribute("ancho","80" );
      ((Element)v.get(1212)).setAttribute("minimizable","S" );
      ((Element)v.get(1212)).setAttribute("minimizada","N" );
      ((Element)v.get(1212)).setAttribute("oculta","S" );
      ((Element)v.get(1204)).appendChild((Element)v.get(1212));
      /* Termina nodo:1212   */

      /* Empieza nodo:1213 / Elemento padre: 1204   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1213)).setAttribute("ancho","80" );
      ((Element)v.get(1213)).setAttribute("minimizable","S" );
      ((Element)v.get(1213)).setAttribute("minimizada","N" );
      ((Element)v.get(1213)).setAttribute("oculta","S" );
      ((Element)v.get(1204)).appendChild((Element)v.get(1213));
      /* Termina nodo:1213   */

      /* Empieza nodo:1214 / Elemento padre: 1204   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1214)).setAttribute("ancho","80" );
      ((Element)v.get(1214)).setAttribute("minimizable","S" );
      ((Element)v.get(1214)).setAttribute("minimizada","N" );
      ((Element)v.get(1214)).setAttribute("oculta","S" );
      ((Element)v.get(1204)).appendChild((Element)v.get(1214));
      /* Termina nodo:1214   */

      /* Empieza nodo:1215 / Elemento padre: 1204   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1215)).setAttribute("ancho","80" );
      ((Element)v.get(1215)).setAttribute("minimizable","S" );
      ((Element)v.get(1215)).setAttribute("minimizada","N" );
      ((Element)v.get(1215)).setAttribute("oculta","S" );
      ((Element)v.get(1204)).appendChild((Element)v.get(1215));
      /* Termina nodo:1215   */

      /* Empieza nodo:1216 / Elemento padre: 1204   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1216)).setAttribute("ancho","80" );
      ((Element)v.get(1216)).setAttribute("minimizable","S" );
      ((Element)v.get(1216)).setAttribute("minimizada","N" );
      ((Element)v.get(1216)).setAttribute("oculta","S" );
      ((Element)v.get(1204)).appendChild((Element)v.get(1216));
      /* Termina nodo:1216   */

      /* Empieza nodo:1217 / Elemento padre: 1204   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1217)).setAttribute("ancho","80" );
   }

   private void getXML5310(Document doc) {
      ((Element)v.get(1217)).setAttribute("minimizable","S" );
      ((Element)v.get(1217)).setAttribute("minimizada","N" );
      ((Element)v.get(1217)).setAttribute("oculta","S" );
      ((Element)v.get(1204)).appendChild((Element)v.get(1217));
      /* Termina nodo:1217   */
      /* Termina nodo:1204   */

      /* Empieza nodo:1218 / Elemento padre: 1194   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(1218)).setAttribute("alto","20" );
      ((Element)v.get(1218)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(1218)).setAttribute("imgFondo","" );
      ((Element)v.get(1218)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(1194)).appendChild((Element)v.get(1218));

      /* Empieza nodo:1219 / Elemento padre: 1218   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1219)).setAttribute("colFondo","" );
      ((Element)v.get(1219)).setAttribute("ID","EstCab" );
      ((Element)v.get(1219)).setAttribute("cod","6" );
      ((Element)v.get(1218)).appendChild((Element)v.get(1219));

      /* Elemento padre:1219 / Elemento actual: 1220   */
      v.add(doc.createTextNode("Marca"));
      ((Element)v.get(1219)).appendChild((Text)v.get(1220));

      /* Termina nodo Texto:1220   */
      /* Termina nodo:1219   */

      /* Empieza nodo:1221 / Elemento padre: 1218   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1221)).setAttribute("colFondo","" );
      ((Element)v.get(1221)).setAttribute("ID","EstCab" );
      ((Element)v.get(1221)).setAttribute("cod","1338" );
      ((Element)v.get(1218)).appendChild((Element)v.get(1221));

      /* Elemento padre:1221 / Elemento actual: 1222   */
      v.add(doc.createTextNode("Unidad negocio"));
      ((Element)v.get(1221)).appendChild((Text)v.get(1222));

      /* Termina nodo Texto:1222   */
      /* Termina nodo:1221   */

      /* Empieza nodo:1223 / Elemento padre: 1218   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1223)).setAttribute("colFondo","" );
      ((Element)v.get(1223)).setAttribute("ID","EstCab" );
      ((Element)v.get(1223)).setAttribute("cod","588" );
      ((Element)v.get(1218)).appendChild((Element)v.get(1223));

      /* Elemento padre:1223 / Elemento actual: 1224   */
      v.add(doc.createTextNode("Negocio"));
      ((Element)v.get(1223)).appendChild((Text)v.get(1224));

      /* Termina nodo Texto:1224   */
      /* Termina nodo:1223   */

      /* Empieza nodo:1225 / Elemento padre: 1218   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1225)).setAttribute("colFondo","" );
      ((Element)v.get(1225)).setAttribute("ID","EstCab" );
      ((Element)v.get(1225)).setAttribute("cod","590" );
      ((Element)v.get(1218)).appendChild((Element)v.get(1225));

      /* Elemento padre:1225 / Elemento actual: 1226   */
      v.add(doc.createTextNode("Supergenérico"));
      ((Element)v.get(1225)).appendChild((Text)v.get(1226));

      /* Termina nodo Texto:1226   */
      /* Termina nodo:1225   */

      /* Empieza nodo:1227 / Elemento padre: 1218   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1227)).setAttribute("colFondo","" );
      ((Element)v.get(1227)).setAttribute("ID","EstCab" );
      ((Element)v.get(1227)).setAttribute("cod","589" );
      ((Element)v.get(1218)).appendChild((Element)v.get(1227));

      /* Elemento padre:1227 / Elemento actual: 1228   */
      v.add(doc.createTextNode("Genérico"));
      ((Element)v.get(1227)).appendChild((Text)v.get(1228));

      /* Termina nodo Texto:1228   */
      /* Termina nodo:1227   */

      /* Empieza nodo:1229 / Elemento padre: 1218   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1229)).setAttribute("colFondo","" );
      ((Element)v.get(1229)).setAttribute("ID","EstCab" );
      ((Element)v.get(1229)).setAttribute("cod","337" );
      ((Element)v.get(1218)).appendChild((Element)v.get(1229));

      /* Elemento padre:1229 / Elemento actual: 1230   */
      v.add(doc.createTextNode("Cód. producto"));
      ((Element)v.get(1229)).appendChild((Text)v.get(1230));

      /* Termina nodo Texto:1230   */
      /* Termina nodo:1229   */

      /* Empieza nodo:1231 / Elemento padre: 1218   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1231)).setAttribute("colFondo","" );
      ((Element)v.get(1231)).setAttribute("ID","EstCab" );
      ((Element)v.get(1218)).appendChild((Element)v.get(1231));

      /* Elemento padre:1231 / Elemento actual: 1232   */
      v.add(doc.createTextNode("oidMarca"));
      ((Element)v.get(1231)).appendChild((Text)v.get(1232));

      /* Termina nodo Texto:1232   */
      /* Termina nodo:1231   */

      /* Empieza nodo:1233 / Elemento padre: 1218   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1233)).setAttribute("colFondo","" );
      ((Element)v.get(1233)).setAttribute("ID","EstCab" );
      ((Element)v.get(1218)).appendChild((Element)v.get(1233));

      /* Elemento padre:1233 / Elemento actual: 1234   */
      v.add(doc.createTextNode("oidUnidadNeg"));
      ((Element)v.get(1233)).appendChild((Text)v.get(1234));

      /* Termina nodo Texto:1234   */
      /* Termina nodo:1233   */

      /* Empieza nodo:1235 / Elemento padre: 1218   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1235)).setAttribute("colFondo","" );
      ((Element)v.get(1235)).setAttribute("ID","EstCab" );
      ((Element)v.get(1218)).appendChild((Element)v.get(1235));

      /* Elemento padre:1235 / Elemento actual: 1236   */
      v.add(doc.createTextNode("oidNegocio"));
      ((Element)v.get(1235)).appendChild((Text)v.get(1236));

      /* Termina nodo Texto:1236   */
      /* Termina nodo:1235   */

      /* Empieza nodo:1237 / Elemento padre: 1218   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1237)).setAttribute("colFondo","" );
      ((Element)v.get(1237)).setAttribute("ID","EstCab" );
      ((Element)v.get(1218)).appendChild((Element)v.get(1237));

      /* Elemento padre:1237 / Elemento actual: 1238   */
      v.add(doc.createTextNode("oidSupergenerico"));
      ((Element)v.get(1237)).appendChild((Text)v.get(1238));

      /* Termina nodo Texto:1238   */
      /* Termina nodo:1237   */

      /* Empieza nodo:1239 / Elemento padre: 1218   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1239)).setAttribute("colFondo","" );
      ((Element)v.get(1239)).setAttribute("ID","EstCab" );
      ((Element)v.get(1218)).appendChild((Element)v.get(1239));

      /* Elemento padre:1239 / Elemento actual: 1240   */
      v.add(doc.createTextNode("oidGenerico"));
      ((Element)v.get(1239)).appendChild((Text)v.get(1240));

      /* Termina nodo Texto:1240   */
      /* Termina nodo:1239   */

      /* Empieza nodo:1241 / Elemento padre: 1218   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1241)).setAttribute("colFondo","" );
      ((Element)v.get(1241)).setAttribute("ID","EstCab" );
      ((Element)v.get(1218)).appendChild((Element)v.get(1241));

      /* Elemento padre:1241 / Elemento actual: 1242   */
      v.add(doc.createTextNode("oidProd"));
      ((Element)v.get(1241)).appendChild((Text)v.get(1242));

      /* Termina nodo Texto:1242   */
      /* Termina nodo:1241   */

      /* Empieza nodo:1243 / Elemento padre: 1218   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1243)).setAttribute("colFondo","" );
   }

   private void getXML5400(Document doc) {
      ((Element)v.get(1243)).setAttribute("ID","EstCab" );
      ((Element)v.get(1218)).appendChild((Element)v.get(1243));

      /* Elemento padre:1243 / Elemento actual: 1244   */
      v.add(doc.createTextNode("oidArticulo"));
      ((Element)v.get(1243)).appendChild((Text)v.get(1244));

      /* Termina nodo Texto:1244   */
      /* Termina nodo:1243   */
      /* Termina nodo:1218   */

      /* Empieza nodo:1245 / Elemento padre: 1194   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(1245)).setAttribute("alto","22" );
      ((Element)v.get(1245)).setAttribute("accion","" );
      ((Element)v.get(1245)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(1245)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(1245)).setAttribute("maxSel","-1" );
      ((Element)v.get(1245)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(1245)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(1245)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(1245)).setAttribute("onLoad","" );
      ((Element)v.get(1245)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(1194)).appendChild((Element)v.get(1245));

      /* Empieza nodo:1246 / Elemento padre: 1245   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1246)).setAttribute("tipo","texto" );
      ((Element)v.get(1246)).setAttribute("ID","EstDat" );
      ((Element)v.get(1245)).appendChild((Element)v.get(1246));
      /* Termina nodo:1246   */

      /* Empieza nodo:1247 / Elemento padre: 1245   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1247)).setAttribute("tipo","texto" );
      ((Element)v.get(1247)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1245)).appendChild((Element)v.get(1247));
      /* Termina nodo:1247   */

      /* Empieza nodo:1248 / Elemento padre: 1245   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1248)).setAttribute("tipo","texto" );
      ((Element)v.get(1248)).setAttribute("ID","EstDat" );
      ((Element)v.get(1245)).appendChild((Element)v.get(1248));
      /* Termina nodo:1248   */

      /* Empieza nodo:1249 / Elemento padre: 1245   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1249)).setAttribute("tipo","texto" );
      ((Element)v.get(1249)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1245)).appendChild((Element)v.get(1249));
      /* Termina nodo:1249   */

      /* Empieza nodo:1250 / Elemento padre: 1245   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1250)).setAttribute("tipo","texto" );
      ((Element)v.get(1250)).setAttribute("ID","EstDat" );
      ((Element)v.get(1245)).appendChild((Element)v.get(1250));
      /* Termina nodo:1250   */

      /* Empieza nodo:1251 / Elemento padre: 1245   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1251)).setAttribute("tipo","texto" );
      ((Element)v.get(1251)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1245)).appendChild((Element)v.get(1251));
      /* Termina nodo:1251   */

      /* Empieza nodo:1252 / Elemento padre: 1245   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1252)).setAttribute("tipo","texto" );
      ((Element)v.get(1252)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1245)).appendChild((Element)v.get(1252));
      /* Termina nodo:1252   */

      /* Empieza nodo:1253 / Elemento padre: 1245   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1253)).setAttribute("tipo","texto" );
      ((Element)v.get(1253)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1245)).appendChild((Element)v.get(1253));
      /* Termina nodo:1253   */

      /* Empieza nodo:1254 / Elemento padre: 1245   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1254)).setAttribute("tipo","texto" );
      ((Element)v.get(1254)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1245)).appendChild((Element)v.get(1254));
      /* Termina nodo:1254   */

      /* Empieza nodo:1255 / Elemento padre: 1245   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1255)).setAttribute("tipo","texto" );
      ((Element)v.get(1255)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1245)).appendChild((Element)v.get(1255));
      /* Termina nodo:1255   */

      /* Empieza nodo:1256 / Elemento padre: 1245   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1256)).setAttribute("tipo","texto" );
      ((Element)v.get(1256)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1245)).appendChild((Element)v.get(1256));
      /* Termina nodo:1256   */

      /* Empieza nodo:1257 / Elemento padre: 1245   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1257)).setAttribute("tipo","texto" );
      ((Element)v.get(1257)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1245)).appendChild((Element)v.get(1257));
      /* Termina nodo:1257   */

      /* Empieza nodo:1258 / Elemento padre: 1245   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1258)).setAttribute("tipo","texto" );
      ((Element)v.get(1258)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1245)).appendChild((Element)v.get(1258));
      /* Termina nodo:1258   */
      /* Termina nodo:1245   */

      /* Empieza nodo:1259 / Elemento padre: 1194   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(1194)).appendChild((Element)v.get(1259));
      /* Termina nodo:1259   */

      /* Empieza nodo:1260 / Elemento padre: 1194   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(1260)).setAttribute("nombre","mipgndo3" );
      ((Element)v.get(1260)).setAttribute("ancho","703" );
      ((Element)v.get(1260)).setAttribute("sep","$" );
      ((Element)v.get(1260)).setAttribute("x","26" );
      ((Element)v.get(1260)).setAttribute("class","botonera" );
      ((Element)v.get(1260)).setAttribute("y","908" );
      ((Element)v.get(1260)).setAttribute("control","|" );
      ((Element)v.get(1260)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(1260)).setAttribute("rowset","" );
      ((Element)v.get(1260)).setAttribute("cargainicial","N" );
      ((Element)v.get(1194)).appendChild((Element)v.get(1260));

      /* Empieza nodo:1261 / Elemento padre: 1260   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1261)).setAttribute("nombre","ret3" );
      ((Element)v.get(1261)).setAttribute("x","51" );
      ((Element)v.get(1261)).setAttribute("y","912" );
      ((Element)v.get(1261)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1261)).setAttribute("img","retroceder_on" );
      ((Element)v.get(1261)).setAttribute("tipo","0" );
      ((Element)v.get(1261)).setAttribute("estado","false" );
   }

   private void getXML5490(Document doc) {
      ((Element)v.get(1261)).setAttribute("alt","" );
      ((Element)v.get(1261)).setAttribute("codigo","" );
      ((Element)v.get(1261)).setAttribute("accion","mipgndo3.retroceder();" );
      ((Element)v.get(1260)).appendChild((Element)v.get(1261));
      /* Termina nodo:1261   */

      /* Empieza nodo:1262 / Elemento padre: 1260   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1262)).setAttribute("nombre","ava3" );
      ((Element)v.get(1262)).setAttribute("x","66" );
      ((Element)v.get(1262)).setAttribute("y","912" );
      ((Element)v.get(1262)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1262)).setAttribute("img","avanzar_on" );
      ((Element)v.get(1262)).setAttribute("tipo","0" );
      ((Element)v.get(1262)).setAttribute("estado","false" );
      ((Element)v.get(1262)).setAttribute("alt","" );
      ((Element)v.get(1262)).setAttribute("codigo","" );
      ((Element)v.get(1262)).setAttribute("accion","mipgndo3.avanzar();" );
      ((Element)v.get(1260)).appendChild((Element)v.get(1262));
      /* Termina nodo:1262   */
      /* Termina nodo:1260   */
      /* Termina nodo:1194   */

      /* Empieza nodo:1263 / Elemento padre: 37   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1263)).setAttribute("nombre","primera3" );
      ((Element)v.get(1263)).setAttribute("x","34" );
      ((Element)v.get(1263)).setAttribute("y","912" );
      ((Element)v.get(1263)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1263)).setAttribute("img","primera_on" );
      ((Element)v.get(1263)).setAttribute("tipo","-2" );
      ((Element)v.get(1263)).setAttribute("estado","false" );
      ((Element)v.get(1263)).setAttribute("alt","" );
      ((Element)v.get(1263)).setAttribute("codigo","" );
      ((Element)v.get(1263)).setAttribute("accion","mipgndo3.retrocederPrimeraPagina();" );
      ((Element)v.get(37)).appendChild((Element)v.get(1263));
      /* Termina nodo:1263   */

      /* Empieza nodo:1264 / Elemento padre: 37   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1264)).setAttribute("nombre","separa3" );
      ((Element)v.get(1264)).setAttribute("x","73" );
      ((Element)v.get(1264)).setAttribute("y","908" );
      ((Element)v.get(1264)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1264)).setAttribute("img","separa_base" );
      ((Element)v.get(1264)).setAttribute("tipo","0" );
      ((Element)v.get(1264)).setAttribute("estado","false" );
      ((Element)v.get(1264)).setAttribute("alt","" );
      ((Element)v.get(1264)).setAttribute("codigo","" );
      ((Element)v.get(1264)).setAttribute("accion","" );
      ((Element)v.get(37)).appendChild((Element)v.get(1264));
      /* Termina nodo:1264   */

      /* Empieza nodo:1265 / Elemento padre: 37   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1265)).setAttribute("nombre","btnEliminar" );
      ((Element)v.get(1265)).setAttribute("x","27" );
      ((Element)v.get(1265)).setAttribute("y","909" );
      ((Element)v.get(1265)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1265)).setAttribute("accion","accionEliminarArticulo()" );
      ((Element)v.get(1265)).setAttribute("tipo","html" );
      ((Element)v.get(1265)).setAttribute("estado","false" );
      ((Element)v.get(1265)).setAttribute("cod","1254" );
      ((Element)v.get(37)).appendChild((Element)v.get(1265));
      /* Termina nodo:1265   */
      /* Termina nodo:37   */


   }

}
