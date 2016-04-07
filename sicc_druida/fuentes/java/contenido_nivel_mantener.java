
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_nivel_mantener  implements es.indra.druida.base.ObjetoXML {
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
         

      getXML5580(doc);
         
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_nivel_mantener" );
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
      ((Element)v.get(4)).setAttribute("src","contenido_nivel_mantener.js" );
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
      /* Termina nodo:6   */
      /* Termina nodo:5   */

      /* Empieza nodo:36 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(36)).setAttribute("nombre","formulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","accion" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 36   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(36)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 36   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(36)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 36   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(36)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 36   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(41)).setAttribute("valor","" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(36)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 36   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","hPais" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(36)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 36   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","hIdioma" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(36)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 36   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","hOidMarca" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(36)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 36   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","datosNiveles" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(36)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 36   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","listaDatosNiveles" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(36)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 36   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","numeroPremio" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(36)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 36   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","numeroPremioPuntos" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(36)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 36   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","numeroPremioMonetarios" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(36)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 36   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","numeroPremioArticulos" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(36)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 36   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(51)).setAttribute("nombre","numeroPremioDescuento" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(36)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 36   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(52)).setAttribute("nombre","nivelAIngresar" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(36)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 36   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(53)).setAttribute("nombre","numeroNiveles" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(36)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 36   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(54)).setAttribute("nombre","IND_INACTIVO" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(36)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 36   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(55)).setAttribute("nombre","IND_ACTIVO" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(36)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 36   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(56)).setAttribute("nombre","OID_TIPO_PREMIO_PUNTOS" );
      ((Element)v.get(56)).setAttribute("valor","" );
      ((Element)v.get(36)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 36   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(57)).setAttribute("nombre","OID_TIPO_PREMIO_MONETARIO" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(36)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 36   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(58)).setAttribute("nombre","OID_TIPO_PREMIO_ARTICULO" );
      ((Element)v.get(58)).setAttribute("valor","" );
      ((Element)v.get(36)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */

      /* Empieza nodo:59 / Elemento padre: 36   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(59)).setAttribute("nombre","OID_TIPO_PREMIO_DESCUENTO" );
      ((Element)v.get(59)).setAttribute("valor","" );
      ((Element)v.get(36)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */

      /* Empieza nodo:60 / Elemento padre: 36   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(60)).setAttribute("nombre","hIndPuntajeServicio" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(36)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */

      /* Empieza nodo:61 / Elemento padre: 36   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(61)).setAttribute("nombre","hIndPremiosElectivos" );
      ((Element)v.get(61)).setAttribute("valor","" );
      ((Element)v.get(36)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */

      /* Empieza nodo:62 / Elemento padre: 36   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(62)).setAttribute("nombre","OID_TIPO_PREM_NIVELES" );
      ((Element)v.get(62)).setAttribute("valor","" );
      ((Element)v.get(36)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */

      /* Empieza nodo:63 / Elemento padre: 36   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(63)).setAttribute("nombre","hCbTipoSeleccion" );
      ((Element)v.get(63)).setAttribute("valor","" );
      ((Element)v.get(36)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */

      /* Empieza nodo:64 / Elemento padre: 36   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(64)).setAttribute("nombre","hIndRanking" );
      ((Element)v.get(64)).setAttribute("valor","" );
      ((Element)v.get(36)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */

      /* Empieza nodo:65 / Elemento padre: 36   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(65)).setAttribute("nombre","hIndProductosExigidos" );
      ((Element)v.get(65)).setAttribute("valor","" );
      ((Element)v.get(36)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */

      /* Empieza nodo:66 / Elemento padre: 36   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(66)).setAttribute("nombre","OID_TIPO_PREM_PTOS_CANT_FIJA" );
      ((Element)v.get(66)).setAttribute("valor","" );
      ((Element)v.get(36)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */

      /* Empieza nodo:67 / Elemento padre: 36   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(67)).setAttribute("nombre","OID_TIPO_PREM_PTOS_PORC_PUNTAJE_OBT" );
      ((Element)v.get(67)).setAttribute("valor","" );
      ((Element)v.get(36)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */

      /* Empieza nodo:68 / Elemento padre: 36   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(68)).setAttribute("nombre","OID_TIPO_PREM_PTOS_PUNTAJE_OBT" );
      ((Element)v.get(68)).setAttribute("valor","" );
      ((Element)v.get(36)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */

      /* Empieza nodo:69 / Elemento padre: 36   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(69)).setAttribute("nombre","OID_TIPO_PREM_MONET_CANT_FIJA" );
      ((Element)v.get(69)).setAttribute("valor","" );
      ((Element)v.get(36)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */

      /* Empieza nodo:70 / Elemento padre: 36   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(70)).setAttribute("nombre","OID_TIPO_PREM_MONET_PORC_PUNTAJE_OBT" );
      ((Element)v.get(70)).setAttribute("valor","" );
      ((Element)v.get(36)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */

      /* Empieza nodo:71 / Elemento padre: 36   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(71)).setAttribute("nombre","OID_TIPO_PREM_MONET_PUNTAJE_OBT" );
      ((Element)v.get(71)).setAttribute("valor","" );
      ((Element)v.get(36)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */

      /* Empieza nodo:72 / Elemento padre: 36   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(72)).setAttribute("nombre","OID_TIPO_DET_METAS_BONO_ANUAL" );
      ((Element)v.get(72)).setAttribute("valor","" );
      ((Element)v.get(36)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */

      /* Empieza nodo:73 / Elemento padre: 36   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(73)).setAttribute("nombre","OID_TIPO_CUMPLIMIENTO_TOTAL" );
      ((Element)v.get(73)).setAttribute("valor","" );
      ((Element)v.get(36)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */

      /* Empieza nodo:74 / Elemento padre: 36   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(74)).setAttribute("nombre","oidMonedaDefault" );
      ((Element)v.get(74)).setAttribute("valor","" );
      ((Element)v.get(36)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */

      /* Empieza nodo:75 / Elemento padre: 36   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(75)).setAttribute("nombre","hOidTipoDeterminacionMetas" );
      ((Element)v.get(75)).setAttribute("valor","" );
      ((Element)v.get(36)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */

      /* Empieza nodo:76 / Elemento padre: 36   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(76)).setAttribute("nombre","OID_TIPO_DESCUENTO_IMPORTE" );
      ((Element)v.get(76)).setAttribute("valor","" );
      ((Element)v.get(36)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */

      /* Empieza nodo:77 / Elemento padre: 36   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(77)).setAttribute("nombre","OID_TIPO_DESCUENTO_PORCENTAJE" );
      ((Element)v.get(77)).setAttribute("valor","" );
      ((Element)v.get(36)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */

      /* Empieza nodo:78 / Elemento padre: 36   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(78)).setAttribute("nombre","hIndPremiosElectivosPremios" );
      ((Element)v.get(78)).setAttribute("valor","" );
      ((Element)v.get(36)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */

      /* Empieza nodo:79 / Elemento padre: 36   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(79)).setAttribute("nombre","oidPremioPuntos" );
      ((Element)v.get(79)).setAttribute("valor","" );
      ((Element)v.get(36)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */

      /* Empieza nodo:80 / Elemento padre: 36   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(80)).setAttribute("nombre","oidPremioMonetario" );
      ((Element)v.get(80)).setAttribute("valor","" );
      ((Element)v.get(36)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */

      /* Empieza nodo:81 / Elemento padre: 36   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(81)).setAttribute("nombre","oidPremioArticulo" );
      ((Element)v.get(81)).setAttribute("valor","" );
      ((Element)v.get(36)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */

      /* Empieza nodo:82 / Elemento padre: 36   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(82)).setAttribute("nombre","oidPremioDescuento" );
      ((Element)v.get(82)).setAttribute("valor","" );
      ((Element)v.get(36)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */

      /* Empieza nodo:83 / Elemento padre: 36   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(83)).setAttribute("nombre","numeroPago" );
      ((Element)v.get(83)).setAttribute("valor","" );
      ((Element)v.get(36)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */

      /* Empieza nodo:84 / Elemento padre: 36   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(84)).setAttribute("nombre","codLotelista" );
      ((Element)v.get(84)).setAttribute("valor","" );
      ((Element)v.get(36)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */

      /* Empieza nodo:85 / Elemento padre: 36   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(85)).setAttribute("nombre","cantidadPremiosArticulos" );
      ((Element)v.get(85)).setAttribute("valor","" );
      ((Element)v.get(36)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */

      /* Empieza nodo:86 / Elemento padre: 36   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(86)).setAttribute("nombre","oidProdDescuentos" );
      ((Element)v.get(86)).setAttribute("valor","" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(36)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */

      /* Empieza nodo:87 / Elemento padre: 36   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(87)).setAttribute("nombre","oidProdArticulos" );
      ((Element)v.get(87)).setAttribute("valor","" );
      ((Element)v.get(36)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */

      /* Empieza nodo:88 / Elemento padre: 36   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(88)).setAttribute("nombre","txtNumUnidadesPremiosArticulo" );
      ((Element)v.get(88)).setAttribute("valor","" );
      ((Element)v.get(36)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */

      /* Empieza nodo:89 / Elemento padre: 36   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(89)).setAttribute("nombre","varCbSuperGenerico" );
      ((Element)v.get(89)).setAttribute("valor","" );
      ((Element)v.get(36)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */

      /* Empieza nodo:90 / Elemento padre: 36   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(90)).setAttribute("nombre","varCbGenerico" );
      ((Element)v.get(90)).setAttribute("valor","" );
      ((Element)v.get(36)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */

      /* Empieza nodo:91 / Elemento padre: 36   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(91)).setAttribute("nombre","codProducto" );
      ((Element)v.get(91)).setAttribute("valor","" );
      ((Element)v.get(36)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */

      /* Empieza nodo:92 / Elemento padre: 36   */
      v.add(doc.createElement("table"));
      ((Element)v.get(92)).setAttribute("width","100%" );
      ((Element)v.get(92)).setAttribute("border","0" );
      ((Element)v.get(92)).setAttribute("cellspacing","0" );
      ((Element)v.get(92)).setAttribute("cellpadding","0" );
      ((Element)v.get(36)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(92)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).setAttribute("width","100%" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(95)).setAttribute("src","b.gif" );
      ((Element)v.get(95)).setAttribute("width","752" );
      ((Element)v.get(95)).setAttribute("height","8" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:96 / Elemento padre: 36   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(96)).setAttribute("nombre","listado" );
      ((Element)v.get(96)).setAttribute("ancho","732" );
      ((Element)v.get(96)).setAttribute("alto","317" );
      ((Element)v.get(96)).setAttribute("x","12" );
      ((Element)v.get(96)).setAttribute("y","12" );
      ((Element)v.get(96)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(96)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(36)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(97)).setAttribute("precarga","S" );
      ((Element)v.get(97)).setAttribute("conROver","S" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(98)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(98)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(98)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(98)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */

      /* Empieza nodo:99 / Elemento padre: 97   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(99)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(99)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(99)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(99)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(97)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */

      /* Empieza nodo:100 / Elemento padre: 97   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(100)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(100)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(97)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:97   */

      /* Empieza nodo:101 / Elemento padre: 96   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(96)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(102)).setAttribute("borde","1" );
      ((Element)v.get(102)).setAttribute("horizDatos","1" );
      ((Element)v.get(102)).setAttribute("horizCabecera","1" );
      ((Element)v.get(102)).setAttribute("vertical","0" );
      ((Element)v.get(102)).setAttribute("horizTitulo","1" );
      ((Element)v.get(102)).setAttribute("horizBase","1" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */

      /* Empieza nodo:103 / Elemento padre: 101   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(103)).setAttribute("borde","#999999" );
      ((Element)v.get(103)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(103)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(103)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(103)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(103)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(103)).setAttribute("horizBase","#999999" );
      ((Element)v.get(101)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:101   */

      /* Empieza nodo:104 / Elemento padre: 96   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(104)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(104)).setAttribute("alto","22" );
      ((Element)v.get(104)).setAttribute("imgFondo","" );
      ((Element)v.get(104)).setAttribute("cod","00346" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(104)).setAttribute("ID","datosTitle" );
      ((Element)v.get(96)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */

      /* Empieza nodo:105 / Elemento padre: 96   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(105)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(105)).setAttribute("alto","22" );
      ((Element)v.get(105)).setAttribute("imgFondo","" );
      ((Element)v.get(96)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */

      /* Empieza nodo:106 / Elemento padre: 96   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(106)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(106)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(106)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(106)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(106)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(106)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(96)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(107)).setAttribute("ancho","80" );
      ((Element)v.get(107)).setAttribute("minimizable","S" );
      ((Element)v.get(107)).setAttribute("minimizada","N" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */

      /* Empieza nodo:108 / Elemento padre: 106   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(108)).setAttribute("ancho","100" );
      ((Element)v.get(108)).setAttribute("minimizable","S" );
      ((Element)v.get(108)).setAttribute("minimizada","N" );
      ((Element)v.get(106)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */

      /* Empieza nodo:109 / Elemento padre: 106   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(109)).setAttribute("ancho","100" );
      ((Element)v.get(109)).setAttribute("minimizable","S" );
      ((Element)v.get(109)).setAttribute("minimizada","N" );
      ((Element)v.get(106)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */

      /* Empieza nodo:110 / Elemento padre: 106   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(110)).setAttribute("ancho","100" );
      ((Element)v.get(110)).setAttribute("minimizable","S" );
      ((Element)v.get(110)).setAttribute("minimizada","N" );
      ((Element)v.get(106)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */

      /* Empieza nodo:111 / Elemento padre: 106   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(111)).setAttribute("ancho","140" );
      ((Element)v.get(111)).setAttribute("minimizable","S" );
      ((Element)v.get(111)).setAttribute("minimizada","N" );
      ((Element)v.get(106)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */

      /* Empieza nodo:112 / Elemento padre: 106   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(112)).setAttribute("ancho","120" );
      ((Element)v.get(112)).setAttribute("minimizable","S" );
      ((Element)v.get(112)).setAttribute("minimizada","N" );
      ((Element)v.get(106)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */

      /* Empieza nodo:113 / Elemento padre: 106   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(113)).setAttribute("ancho","120" );
      ((Element)v.get(113)).setAttribute("minimizable","S" );
      ((Element)v.get(113)).setAttribute("minimizada","N" );
      ((Element)v.get(106)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */

      /* Empieza nodo:114 / Elemento padre: 106   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(114)).setAttribute("ancho","180" );
      ((Element)v.get(114)).setAttribute("minimizable","S" );
      ((Element)v.get(114)).setAttribute("minimizada","N" );
      ((Element)v.get(106)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */

      /* Empieza nodo:115 / Elemento padre: 106   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(115)).setAttribute("ancho","100" );
      ((Element)v.get(115)).setAttribute("minimizable","S" );
      ((Element)v.get(115)).setAttribute("minimizada","N" );
      ((Element)v.get(106)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */

      /* Empieza nodo:116 / Elemento padre: 106   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(116)).setAttribute("ancho","100" );
      ((Element)v.get(116)).setAttribute("minimizable","S" );
      ((Element)v.get(116)).setAttribute("minimizada","N" );
      ((Element)v.get(116)).setAttribute("oculta","S" );
      ((Element)v.get(106)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */

      /* Empieza nodo:117 / Elemento padre: 106   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(117)).setAttribute("ancho","100" );
      ((Element)v.get(117)).setAttribute("minimizable","S" );
      ((Element)v.get(117)).setAttribute("minimizada","N" );
      ((Element)v.get(106)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:106   */

      /* Empieza nodo:118 / Elemento padre: 96   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(118)).setAttribute("alto","20" );
      ((Element)v.get(118)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(118)).setAttribute("imgFondo","" );
      ((Element)v.get(118)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(96)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(119)).setAttribute("colFondo","" );
      ((Element)v.get(119)).setAttribute("ID","EstCab" );
      ((Element)v.get(119)).setAttribute("cod","1664" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */

      /* Empieza nodo:120 / Elemento padre: 118   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(120)).setAttribute("colFondo","" );
      ((Element)v.get(120)).setAttribute("ID","EstCab" );
      ((Element)v.get(120)).setAttribute("cod","1833" );
      ((Element)v.get(118)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */

      /* Empieza nodo:121 / Elemento padre: 118   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(121)).setAttribute("colFondo","" );
      ((Element)v.get(121)).setAttribute("ID","EstCab" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(121)).setAttribute("cod","1696" );
      ((Element)v.get(118)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */

      /* Empieza nodo:122 / Elemento padre: 118   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(122)).setAttribute("colFondo","" );
      ((Element)v.get(122)).setAttribute("ID","EstCab" );
      ((Element)v.get(122)).setAttribute("cod","1819" );
      ((Element)v.get(118)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */

      /* Empieza nodo:123 / Elemento padre: 118   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(123)).setAttribute("colFondo","" );
      ((Element)v.get(123)).setAttribute("ID","EstCab" );
      ((Element)v.get(123)).setAttribute("cod","2431" );
      ((Element)v.get(118)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */

      /* Empieza nodo:124 / Elemento padre: 118   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(124)).setAttribute("colFondo","" );
      ((Element)v.get(124)).setAttribute("ID","EstCab" );
      ((Element)v.get(124)).setAttribute("cod","1831" );
      ((Element)v.get(118)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */

      /* Empieza nodo:125 / Elemento padre: 118   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(125)).setAttribute("colFondo","" );
      ((Element)v.get(125)).setAttribute("ID","EstCab" );
      ((Element)v.get(125)).setAttribute("cod","1832" );
      ((Element)v.get(118)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */

      /* Empieza nodo:126 / Elemento padre: 118   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(126)).setAttribute("colFondo","" );
      ((Element)v.get(126)).setAttribute("ID","EstCab" );
      ((Element)v.get(126)).setAttribute("cod","1834" );
      ((Element)v.get(118)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */

      /* Empieza nodo:127 / Elemento padre: 118   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(127)).setAttribute("colFondo","" );
      ((Element)v.get(127)).setAttribute("ID","EstCab" );
      ((Element)v.get(127)).setAttribute("cod","2447" );
      ((Element)v.get(118)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */

      /* Empieza nodo:128 / Elemento padre: 118   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(128)).setAttribute("colFondo","" );
      ((Element)v.get(128)).setAttribute("ID","EstCab" );
      ((Element)v.get(118)).appendChild((Element)v.get(128));

      /* Elemento padre:128 / Elemento actual: 129   */
      v.add(doc.createTextNode("oid"));
      ((Element)v.get(128)).appendChild((Text)v.get(129));

      /* Termina nodo Texto:129   */
      /* Termina nodo:128   */

      /* Empieza nodo:130 / Elemento padre: 118   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(130)).setAttribute("colFondo","" );
      ((Element)v.get(130)).setAttribute("ID","EstCab" );
      ((Element)v.get(130)).setAttribute("cod","9" );
      ((Element)v.get(118)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:118   */

      /* Empieza nodo:131 / Elemento padre: 96   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(131)).setAttribute("alto","22" );
      ((Element)v.get(131)).setAttribute("accion","" );
      ((Element)v.get(131)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(131)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(131)).setAttribute("maxSel","1" );
      ((Element)v.get(131)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(131)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(131)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(131)).setAttribute("onLoad","" );
      ((Element)v.get(131)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(96)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(132)).setAttribute("tipo","texto" );
      ((Element)v.get(132)).setAttribute("ID","EstDat" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */

      /* Empieza nodo:133 / Elemento padre: 131   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(133)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(133)).setAttribute("nombre","txtPuntajeServicio" );
      ((Element)v.get(133)).setAttribute("size","9" );
      ((Element)v.get(133)).setAttribute("max","8" );
      ((Element)v.get(133)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(133)).setAttribute("ID","EstDat2" );
      ((Element)v.get(131)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */

      /* Empieza nodo:134 / Elemento padre: 131   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(134)).setAttribute("tipo","combo" );
      ((Element)v.get(134)).setAttribute("nombre","cbTipoPremio" );
      ((Element)v.get(134)).setAttribute("ID","EstDat" );
      ((Element)v.get(134)).setAttribute("IDOBJ","EstDatForm" );
      ((Element)v.get(131)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:136 / Elemento padre: 131   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(136)).setAttribute("tipo","checkbox" );
      ((Element)v.get(136)).setAttribute("nombre","ckNivelElegible" );
      ((Element)v.get(136)).setAttribute("ID","EstDat2" );
      ((Element)v.get(131)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */

      /* Empieza nodo:137 / Elemento padre: 131   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(137)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(137)).setAttribute("nombre","txtCantidadFijoPuntos" );
      ((Element)v.get(137)).setAttribute("size","7" );
      ((Element)v.get(137)).setAttribute("max","7" );
      ((Element)v.get(137)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(137)).setAttribute("ID","EstDa2" );
      ((Element)v.get(131)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */

      /* Empieza nodo:138 / Elemento padre: 131   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(138)).setAttribute("tipo","cajatexto" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(138)).setAttribute("nombre","txtCantidadDesde" );
      ((Element)v.get(138)).setAttribute("size","9" );
      ((Element)v.get(138)).setAttribute("max","7" );
      ((Element)v.get(138)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(138)).setAttribute("ID","EstDat2" );
      ((Element)v.get(131)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */

      /* Empieza nodo:139 / Elemento padre: 131   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(139)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(139)).setAttribute("nombre","txtCantidadHasta" );
      ((Element)v.get(139)).setAttribute("size","9" );
      ((Element)v.get(139)).setAttribute("max","7" );
      ((Element)v.get(139)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(139)).setAttribute("ID","EstDat" );
      ((Element)v.get(131)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */

      /* Empieza nodo:140 / Elemento padre: 131   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(140)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(140)).setAttribute("nombre","txtPuntosProductosExigidos" );
      ((Element)v.get(140)).setAttribute("size","7" );
      ((Element)v.get(140)).setAttribute("max","7" );
      ((Element)v.get(140)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(140)).setAttribute("ID","EstDat2" );
      ((Element)v.get(131)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */

      /* Empieza nodo:141 / Elemento padre: 131   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(141)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(141)).setAttribute("nombre","txtNumAspirantes" );
      ((Element)v.get(141)).setAttribute("size","3" );
      ((Element)v.get(141)).setAttribute("max","3" );
      ((Element)v.get(141)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(141)).setAttribute("ID","EstDat" );
      ((Element)v.get(131)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */

      /* Empieza nodo:142 / Elemento padre: 131   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(142)).setAttribute("tipo","texto" );
      ((Element)v.get(142)).setAttribute("ID","EstDat" );
      ((Element)v.get(131)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */

      /* Empieza nodo:143 / Elemento padre: 131   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(143)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(143)).setAttribute("nombre","txtDescripcion" );
      ((Element)v.get(143)).setAttribute("size","15" );
      ((Element)v.get(143)).setAttribute("max","50" );
      ((Element)v.get(143)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(143)).setAttribute("ID","EstDat" );
      ((Element)v.get(131)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:131   */

      /* Empieza nodo:144 / Elemento padre: 96   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(96)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */

      /* Empieza nodo:145 / Elemento padre: 96   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(145)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(145)).setAttribute("ancho","703" );
      ((Element)v.get(145)).setAttribute("sep","$" );
      ((Element)v.get(145)).setAttribute("x","26" );
      ((Element)v.get(145)).setAttribute("class","botonera" );
      ((Element)v.get(145)).setAttribute("y","306" );
      ((Element)v.get(145)).setAttribute("control","|" );
      ((Element)v.get(145)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(145)).setAttribute("rowset","" );
      ((Element)v.get(145)).setAttribute("cargainicial","N" );
      ((Element)v.get(96)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(146)).setAttribute("nombre","ret" );
      ((Element)v.get(146)).setAttribute("x","51" );
      ((Element)v.get(146)).setAttribute("y","310" );
      ((Element)v.get(146)).setAttribute("ID","botonContenido" );
      ((Element)v.get(146)).setAttribute("img","retroceder_on" );
      ((Element)v.get(146)).setAttribute("tipo","0" );
      ((Element)v.get(146)).setAttribute("estado","false" );
      ((Element)v.get(146)).setAttribute("alt","" );
      ((Element)v.get(146)).setAttribute("codigo","" );
      ((Element)v.get(146)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */

      /* Empieza nodo:147 / Elemento padre: 145   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(147)).setAttribute("nombre","ava" );
      ((Element)v.get(147)).setAttribute("x","66" );
      ((Element)v.get(147)).setAttribute("y","310" );
      ((Element)v.get(147)).setAttribute("ID","botonContenido" );
      ((Element)v.get(147)).setAttribute("img","avanzar_on" );
      ((Element)v.get(147)).setAttribute("tipo","0" );
      ((Element)v.get(147)).setAttribute("estado","false" );
      ((Element)v.get(147)).setAttribute("alt","" );
      ((Element)v.get(147)).setAttribute("codigo","" );
      ((Element)v.get(147)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(145)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:145   */
      /* Termina nodo:96   */

      /* Empieza nodo:148 / Elemento padre: 36   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(148)).setAttribute("nombre","primera" );
      ((Element)v.get(148)).setAttribute("x","34" );
      ((Element)v.get(148)).setAttribute("y","310" );
      ((Element)v.get(148)).setAttribute("ID","botonContenido" );
      ((Element)v.get(148)).setAttribute("img","primera_on" );
      ((Element)v.get(148)).setAttribute("tipo","-2" );
      ((Element)v.get(148)).setAttribute("estado","false" );
      ((Element)v.get(148)).setAttribute("alt","" );
      ((Element)v.get(148)).setAttribute("codigo","" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(148)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(36)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */

      /* Empieza nodo:149 / Elemento padre: 36   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(149)).setAttribute("nombre","separa" );
      ((Element)v.get(149)).setAttribute("x","73" );
      ((Element)v.get(149)).setAttribute("y","306" );
      ((Element)v.get(149)).setAttribute("ID","botonContenido" );
      ((Element)v.get(149)).setAttribute("img","separa_base" );
      ((Element)v.get(149)).setAttribute("tipo","0" );
      ((Element)v.get(149)).setAttribute("estado","false" );
      ((Element)v.get(149)).setAttribute("alt","" );
      ((Element)v.get(149)).setAttribute("codigo","" );
      ((Element)v.get(149)).setAttribute("accion","" );
      ((Element)v.get(36)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */

      /* Empieza nodo:150 / Elemento padre: 36   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(150)).setAttribute("nombre","btnDefinirPremio" );
      ((Element)v.get(150)).setAttribute("x","13" );
      ((Element)v.get(150)).setAttribute("y","307" );
      ((Element)v.get(150)).setAttribute("ID","botonContenido" );
      ((Element)v.get(150)).setAttribute("accion","accionDefinirPremio()" );
      ((Element)v.get(150)).setAttribute("tipo","html" );
      ((Element)v.get(150)).setAttribute("estado","false" );
      ((Element)v.get(150)).setAttribute("cod","2855" );
      ((Element)v.get(36)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */

      /* Empieza nodo:151 / Elemento padre: 36   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(151)).setAttribute("nombre","btnAceptar" );
      ((Element)v.get(151)).setAttribute("x","112" );
      ((Element)v.get(151)).setAttribute("y","307" );
      ((Element)v.get(151)).setAttribute("ID","botonContenido" );
      ((Element)v.get(151)).setAttribute("accion","accionAceptarNiveles()" );
      ((Element)v.get(151)).setAttribute("tipo","html" );
      ((Element)v.get(151)).setAttribute("estado","false" );
      ((Element)v.get(151)).setAttribute("cod","12" );
      ((Element)v.get(36)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */

      /* Empieza nodo:152 / Elemento padre: 36   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(152)).setAttribute("nombre","capa1" );
      ((Element)v.get(152)).setAttribute("alto","180" );
      ((Element)v.get(152)).setAttribute("ancho","100%" );
      ((Element)v.get(152)).setAttribute("colorf","" );
      ((Element)v.get(152)).setAttribute("borde","0" );
      ((Element)v.get(152)).setAttribute("imagenf","" );
      ((Element)v.get(152)).setAttribute("repeat","" );
      ((Element)v.get(152)).setAttribute("padding","" );
      ((Element)v.get(152)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(152)).setAttribute("contravsb","" );
      ((Element)v.get(152)).setAttribute("x","0" );
      ((Element)v.get(152)).setAttribute("y","341" );
      ((Element)v.get(152)).setAttribute("zindex","" );
      ((Element)v.get(36)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("table"));
      ((Element)v.get(153)).setAttribute("width","100%" );
      ((Element)v.get(153)).setAttribute("border","0" );
      ((Element)v.get(153)).setAttribute("cellspacing","0" );
      ((Element)v.get(153)).setAttribute("cellpadding","0" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(153)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
      ((Element)v.get(155)).setAttribute("width","12" );
      ((Element)v.get(155)).setAttribute("align","center" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(156)).setAttribute("src","b.gif" );
      ((Element)v.get(156)).setAttribute("width","12" );
      ((Element)v.get(156)).setAttribute("height","12" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */

      /* Empieza nodo:157 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
      ((Element)v.get(157)).setAttribute("width","750" );
      ((Element)v.get(154)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(158)).setAttribute("src","b.gif" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:159 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
      ((Element)v.get(159)).setAttribute("width","12" );
      ((Element)v.get(154)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(160)).setAttribute("src","b.gif" );
      ((Element)v.get(160)).setAttribute("width","12" );
      ((Element)v.get(160)).setAttribute("height","1" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:159   */
      /* Termina nodo:154   */

      /* Empieza nodo:161 / Elemento padre: 153   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(153)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(161)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(163)).setAttribute("src","b.gif" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */

      /* Empieza nodo:164 / Elemento padre: 161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(161)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("fieldset"));
   }

   private void getXML900(Document doc) {
      ((Element)v.get(164)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(166)).setAttribute("class","legend" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(167)).setAttribute("nombre","lblDatosPremiosPunto" );
      ((Element)v.get(167)).setAttribute("alto","13" );
      ((Element)v.get(167)).setAttribute("filas","1" );
      ((Element)v.get(167)).setAttribute("valor","" );
      ((Element)v.get(167)).setAttribute("id","legend" );
      ((Element)v.get(167)).setAttribute("cod","00347" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:166   */

      /* Empieza nodo:168 / Elemento padre: 165   */
      v.add(doc.createElement("table"));
      ((Element)v.get(168)).setAttribute("width","100%" );
      ((Element)v.get(168)).setAttribute("border","0" );
      ((Element)v.get(168)).setAttribute("align","center" );
      ((Element)v.get(168)).setAttribute("cellspacing","0" );
      ((Element)v.get(168)).setAttribute("cellpadding","0" );
      ((Element)v.get(165)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(168)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("td"));
      ((Element)v.get(169)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("table"));
      ((Element)v.get(171)).setAttribute("width","728" );
      ((Element)v.get(171)).setAttribute("border","0" );
      ((Element)v.get(171)).setAttribute("align","left" );
      ((Element)v.get(171)).setAttribute("cellspacing","0" );
      ((Element)v.get(171)).setAttribute("cellpadding","0" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(171)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(173)).setAttribute("colspan","4" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(174)).setAttribute("src","b.gif" );
      ((Element)v.get(174)).setAttribute("width","8" );
      ((Element)v.get(174)).setAttribute("height","8" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */
      /* Termina nodo:173   */
      /* Termina nodo:172   */

      /* Empieza nodo:175 / Elemento padre: 171   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(171)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(177)).setAttribute("src","b.gif" );
      ((Element)v.get(177)).setAttribute("width","8" );
      ((Element)v.get(177)).setAttribute("height","8" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */
      /* Termina nodo:176   */

      /* Empieza nodo:178 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(179)).setAttribute("nombre","lblNumPremio1" );
      ((Element)v.get(179)).setAttribute("alto","13" );
      ((Element)v.get(179)).setAttribute("filas","1" );
      ((Element)v.get(179)).setAttribute("valor","" );
      ((Element)v.get(179)).setAttribute("id","datosTitle" );
      ((Element)v.get(179)).setAttribute("cod","1691" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:178   */

      /* Empieza nodo:180 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(181)).setAttribute("src","b.gif" );
      ((Element)v.get(181)).setAttribute("width","25" );
      ((Element)v.get(181)).setAttribute("height","8" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:180   */

      /* Empieza nodo:182 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(183)).setAttribute("nombre","lblConcursoDestino" );
      ((Element)v.get(183)).setAttribute("alto","13" );
      ((Element)v.get(183)).setAttribute("filas","1" );
      ((Element)v.get(183)).setAttribute("valor","" );
      ((Element)v.get(183)).setAttribute("id","datosTitle" );
      ((Element)v.get(183)).setAttribute("cod","1835" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:182   */

      /* Empieza nodo:184 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(185)).setAttribute("src","b.gif" );
      ((Element)v.get(185)).setAttribute("width","25" );
      ((Element)v.get(185)).setAttribute("height","8" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */
      /* Termina nodo:184   */

      /* Empieza nodo:186 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(187)).setAttribute("nombre","lblTipoPremiosPunto1" );
      ((Element)v.get(187)).setAttribute("alto","13" );
      ((Element)v.get(187)).setAttribute("filas","1" );
      ((Element)v.get(187)).setAttribute("valor","" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(187)).setAttribute("id","datosTitle" );
      ((Element)v.get(187)).setAttribute("cod","1836" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */
      /* Termina nodo:186   */

      /* Empieza nodo:188 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(189)).setAttribute("src","b.gif" );
      ((Element)v.get(189)).setAttribute("width","25" );
      ((Element)v.get(189)).setAttribute("height","8" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */
      /* Termina nodo:188   */

      /* Empieza nodo:190 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(191)).setAttribute("nombre","lblCantidad2" );
      ((Element)v.get(191)).setAttribute("alto","13" );
      ((Element)v.get(191)).setAttribute("filas","1" );
      ((Element)v.get(191)).setAttribute("valor","" );
      ((Element)v.get(191)).setAttribute("id","datosTitle" );
      ((Element)v.get(191)).setAttribute("cod","1172" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */
      /* Termina nodo:190   */

      /* Empieza nodo:192 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(193)).setAttribute("src","b.gif" );
      ((Element)v.get(193)).setAttribute("width","25" );
      ((Element)v.get(193)).setAttribute("height","8" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:192   */

      /* Empieza nodo:194 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(195)).setAttribute("nombre","lblPorcentaje2" );
      ((Element)v.get(195)).setAttribute("alto","13" );
      ((Element)v.get(195)).setAttribute("filas","1" );
      ((Element)v.get(195)).setAttribute("valor","" );
      ((Element)v.get(195)).setAttribute("id","datosTitle" );
      ((Element)v.get(195)).setAttribute("cod","790" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:194   */

      /* Empieza nodo:196 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(196)).setAttribute("width","100%" );
      ((Element)v.get(175)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(197)).setAttribute("src","b.gif" );
      ((Element)v.get(197)).setAttribute("width","8" );
      ((Element)v.get(197)).setAttribute("height","8" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */
      /* Termina nodo:196   */
      /* Termina nodo:175   */

      /* Empieza nodo:198 / Elemento padre: 171   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(171)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(198)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(200)).setAttribute("src","b.gif" );
      ((Element)v.get(200)).setAttribute("width","8" );
      ((Element)v.get(200)).setAttribute("height","8" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:199   */

      /* Empieza nodo:201 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(201)).setAttribute("valign","bottom" );
      ((Element)v.get(198)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(202)).setAttribute("nombre","lbNumPremio1" );
      ((Element)v.get(202)).setAttribute("alto","13" );
      ((Element)v.get(202)).setAttribute("filas","1" );
      ((Element)v.get(202)).setAttribute("valor","" );
      ((Element)v.get(202)).setAttribute("id","datosCampos" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:201   */

      /* Empieza nodo:203 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(198)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(204)).setAttribute("src","b.gif" );
      ((Element)v.get(204)).setAttribute("width","25" );
      ((Element)v.get(204)).setAttribute("height","8" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:203   */

      /* Empieza nodo:205 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(205)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(198)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(206)).setAttribute("nombre","cbConcursoDestino" );
      ((Element)v.get(206)).setAttribute("id","datosCampos" );
      ((Element)v.get(206)).setAttribute("size","1" );
      ((Element)v.get(206)).setAttribute("multiple","N" );
      ((Element)v.get(206)).setAttribute("req","S" );
      ((Element)v.get(206)).setAttribute("valorinicial","" );
      ((Element)v.get(206)).setAttribute("textoinicial","" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(206)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */
      /* Termina nodo:206   */
      /* Termina nodo:205   */

      /* Empieza nodo:208 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(198)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(209)).setAttribute("src","b.gif" );
      ((Element)v.get(209)).setAttribute("width","25" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(209)).setAttribute("height","8" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */

      /* Empieza nodo:210 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(210)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(198)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(211)).setAttribute("nombre","cbTipoPremioPuntos1" );
      ((Element)v.get(211)).setAttribute("id","datosCampos" );
      ((Element)v.get(211)).setAttribute("size","1" );
      ((Element)v.get(211)).setAttribute("onchange","onChangeTipoPremiosPuntos();" );
      ((Element)v.get(211)).setAttribute("multiple","N" );
      ((Element)v.get(211)).setAttribute("req","S" );
      ((Element)v.get(211)).setAttribute("valorinicial","" );
      ((Element)v.get(211)).setAttribute("textoinicial","" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(211)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */
      /* Termina nodo:211   */
      /* Termina nodo:210   */

      /* Empieza nodo:213 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(198)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(214)).setAttribute("src","b.gif" );
      ((Element)v.get(214)).setAttribute("width","25" );
      ((Element)v.get(214)).setAttribute("height","8" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:213   */

      /* Empieza nodo:215 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(215)).setAttribute("valign","bottom" );
      ((Element)v.get(198)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(216)).setAttribute("nombre","txtCantidad1" );
      ((Element)v.get(216)).setAttribute("id","datosCampos" );
      ((Element)v.get(216)).setAttribute("max","7" );
      ((Element)v.get(216)).setAttribute("tipo","" );
      ((Element)v.get(216)).setAttribute("onchange","" );
      ((Element)v.get(216)).setAttribute("req","N" );
      ((Element)v.get(216)).setAttribute("size","8" );
      ((Element)v.get(216)).setAttribute("valor","" );
      ((Element)v.get(216)).setAttribute("validacion","" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */
      /* Termina nodo:215   */

      /* Empieza nodo:217 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(198)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(218)).setAttribute("src","b.gif" );
      ((Element)v.get(218)).setAttribute("width","25" );
      ((Element)v.get(218)).setAttribute("height","8" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */
      /* Termina nodo:217   */

      /* Empieza nodo:219 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(219)).setAttribute("valign","bottom" );
      ((Element)v.get(198)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(220)).setAttribute("nombre","txtPorcentaje1" );
      ((Element)v.get(220)).setAttribute("id","datosCampos" );
      ((Element)v.get(220)).setAttribute("max","7" );
      ((Element)v.get(220)).setAttribute("tipo","" );
      ((Element)v.get(220)).setAttribute("onchange","" );
      ((Element)v.get(220)).setAttribute("req","N" );
      ((Element)v.get(220)).setAttribute("size","8" );
      ((Element)v.get(220)).setAttribute("valor","" );
      ((Element)v.get(220)).setAttribute("validacion","" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */
      /* Termina nodo:219   */

      /* Empieza nodo:221 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(221)).setAttribute("width","100%" );
      ((Element)v.get(198)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(222)).setAttribute("src","b.gif" );
      ((Element)v.get(222)).setAttribute("width","8" );
      ((Element)v.get(222)).setAttribute("height","8" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */
      /* Termina nodo:221   */
      /* Termina nodo:198   */

      /* Empieza nodo:223 / Elemento padre: 171   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(171)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("td"));
      ((Element)v.get(224)).setAttribute("colspan","4" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(225)).setAttribute("src","b.gif" );
      ((Element)v.get(225)).setAttribute("width","8" );
      ((Element)v.get(225)).setAttribute("height","8" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */
      /* Termina nodo:224   */
      /* Termina nodo:223   */
      /* Termina nodo:171   */
      /* Termina nodo:170   */
      /* Termina nodo:169   */
      /* Termina nodo:168   */
      /* Termina nodo:165   */
      /* Termina nodo:164   */

      /* Empieza nodo:226 / Elemento padre: 161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(161)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(227)).setAttribute("src","b.gif" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */
      /* Termina nodo:226   */
      /* Termina nodo:161   */

      /* Empieza nodo:228 / Elemento padre: 153   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(153)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("td"));
      ((Element)v.get(228)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(230)).setAttribute("src","b.gif" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */
      /* Termina nodo:229   */

      /* Empieza nodo:231 / Elemento padre: 228   */
      v.add(doc.createElement("td"));
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(228)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(231)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("table"));
      ((Element)v.get(233)).setAttribute("width","100%" );
      ((Element)v.get(233)).setAttribute("border","0" );
      ((Element)v.get(233)).setAttribute("align","center" );
      ((Element)v.get(233)).setAttribute("cellspacing","0" );
      ((Element)v.get(233)).setAttribute("cellpadding","0" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(233)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("td"));
      ((Element)v.get(235)).setAttribute("class","botonera" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(236)).setAttribute("nombre","btnAceptar1" );
      ((Element)v.get(236)).setAttribute("ID","botonContenido" );
      ((Element)v.get(236)).setAttribute("tipo","html" );
      ((Element)v.get(236)).setAttribute("accion","accionAceptar(get('formulario.OID_TIPO_PREMIO_PUNTOS'));" );
      ((Element)v.get(236)).setAttribute("estado","false" );
      ((Element)v.get(236)).setAttribute("cod","12" );
      ((Element)v.get(235)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */
      /* Termina nodo:235   */
      /* Termina nodo:234   */
      /* Termina nodo:233   */
      /* Termina nodo:232   */
      /* Termina nodo:231   */

      /* Empieza nodo:237 / Elemento padre: 228   */
      v.add(doc.createElement("td"));
      ((Element)v.get(228)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(238)).setAttribute("src","b.gif" );
      ((Element)v.get(238)).setAttribute("width","8" );
      ((Element)v.get(238)).setAttribute("height","12" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */
      /* Termina nodo:237   */
      /* Termina nodo:228   */

      /* Empieza nodo:239 / Elemento padre: 153   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(153)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("td"));
      ((Element)v.get(240)).setAttribute("width","12" );
      ((Element)v.get(240)).setAttribute("align","center" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(241)).setAttribute("src","b.gif" );
      ((Element)v.get(241)).setAttribute("width","12" );
      ((Element)v.get(241)).setAttribute("height","12" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */
      /* Termina nodo:240   */

      /* Empieza nodo:242 / Elemento padre: 239   */
      v.add(doc.createElement("td"));
      ((Element)v.get(242)).setAttribute("width","756" );
      ((Element)v.get(239)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(243)).setAttribute("src","b.gif" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */
      /* Termina nodo:242   */

      /* Empieza nodo:244 / Elemento padre: 239   */
      v.add(doc.createElement("td"));
      ((Element)v.get(244)).setAttribute("width","12" );
      ((Element)v.get(239)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(245)).setAttribute("src","b.gif" );
      ((Element)v.get(245)).setAttribute("width","12" );
      ((Element)v.get(245)).setAttribute("height","1" );
      ((Element)v.get(244)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */
      /* Termina nodo:244   */
      /* Termina nodo:239   */
      /* Termina nodo:153   */
      /* Termina nodo:152   */

      /* Empieza nodo:246 / Elemento padre: 36   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(246)).setAttribute("nombre","capa2" );
      ((Element)v.get(246)).setAttribute("alto","180" );
      ((Element)v.get(246)).setAttribute("ancho","100%" );
      ((Element)v.get(246)).setAttribute("colorf","" );
      ((Element)v.get(246)).setAttribute("borde","0" );
      ((Element)v.get(246)).setAttribute("imagenf","" );
      ((Element)v.get(246)).setAttribute("repeat","" );
      ((Element)v.get(246)).setAttribute("padding","" );
      ((Element)v.get(246)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(246)).setAttribute("contravsb","" );
      ((Element)v.get(246)).setAttribute("x","0" );
      ((Element)v.get(246)).setAttribute("y","341" );
      ((Element)v.get(246)).setAttribute("zindex","" );
      ((Element)v.get(36)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("table"));
      ((Element)v.get(247)).setAttribute("width","100%" );
      ((Element)v.get(247)).setAttribute("border","0" );
      ((Element)v.get(247)).setAttribute("cellspacing","0" );
      ((Element)v.get(247)).setAttribute("cellpadding","0" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(247)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("td"));
      ((Element)v.get(249)).setAttribute("width","12" );
      ((Element)v.get(249)).setAttribute("align","center" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(250)).setAttribute("src","b.gif" );
      ((Element)v.get(250)).setAttribute("width","12" );
      ((Element)v.get(250)).setAttribute("height","12" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */
      /* Termina nodo:249   */

      /* Empieza nodo:251 / Elemento padre: 248   */
      v.add(doc.createElement("td"));
      ((Element)v.get(251)).setAttribute("width","750" );
      ((Element)v.get(248)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
   }

   private void getXML1260(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(252)).setAttribute("src","b.gif" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */
      /* Termina nodo:251   */

      /* Empieza nodo:253 / Elemento padre: 248   */
      v.add(doc.createElement("td"));
      ((Element)v.get(253)).setAttribute("width","12" );
      ((Element)v.get(248)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(254)).setAttribute("src","b.gif" );
      ((Element)v.get(254)).setAttribute("width","12" );
      ((Element)v.get(254)).setAttribute("height","1" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */
      /* Termina nodo:253   */
      /* Termina nodo:248   */

      /* Empieza nodo:255 / Elemento padre: 247   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(247)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("td"));
      ((Element)v.get(255)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(257)).setAttribute("src","b.gif" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */
      /* Termina nodo:256   */

      /* Empieza nodo:258 / Elemento padre: 255   */
      v.add(doc.createElement("td"));
      ((Element)v.get(255)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(258)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(260)).setAttribute("class","legend" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(261)).setAttribute("nombre","lblDatosPremiosMonetario" );
      ((Element)v.get(261)).setAttribute("alto","13" );
      ((Element)v.get(261)).setAttribute("filas","1" );
      ((Element)v.get(261)).setAttribute("valor","" );
      ((Element)v.get(261)).setAttribute("id","legend" );
      ((Element)v.get(261)).setAttribute("cod","00348" );
      ((Element)v.get(260)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */
      /* Termina nodo:260   */

      /* Empieza nodo:262 / Elemento padre: 259   */
      v.add(doc.createElement("table"));
      ((Element)v.get(262)).setAttribute("width","100%" );
      ((Element)v.get(262)).setAttribute("border","0" );
      ((Element)v.get(262)).setAttribute("align","center" );
      ((Element)v.get(262)).setAttribute("cellspacing","0" );
      ((Element)v.get(262)).setAttribute("cellpadding","0" );
      ((Element)v.get(259)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(262)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("td"));
      ((Element)v.get(263)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("table"));
      ((Element)v.get(265)).setAttribute("width","728" );
      ((Element)v.get(265)).setAttribute("border","0" );
      ((Element)v.get(265)).setAttribute("align","left" );
      ((Element)v.get(265)).setAttribute("cellspacing","0" );
      ((Element)v.get(265)).setAttribute("cellpadding","0" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(265)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("td"));
      ((Element)v.get(267)).setAttribute("colspan","4" );
      ((Element)v.get(266)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(268)).setAttribute("src","b.gif" );
      ((Element)v.get(268)).setAttribute("width","8" );
      ((Element)v.get(268)).setAttribute("height","8" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */
      /* Termina nodo:267   */
      /* Termina nodo:266   */

      /* Empieza nodo:269 / Elemento padre: 265   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(265)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("td"));
      ((Element)v.get(269)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(271)).setAttribute("src","b.gif" );
      ((Element)v.get(271)).setAttribute("width","8" );
      ((Element)v.get(271)).setAttribute("height","8" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */
      /* Termina nodo:270   */

      /* Empieza nodo:272 / Elemento padre: 269   */
      v.add(doc.createElement("td"));
      ((Element)v.get(269)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(273)).setAttribute("nombre","lblNumPremio2" );
      ((Element)v.get(273)).setAttribute("alto","13" );
      ((Element)v.get(273)).setAttribute("filas","1" );
      ((Element)v.get(273)).setAttribute("valor","" );
      ((Element)v.get(273)).setAttribute("id","datosTitle" );
      ((Element)v.get(273)).setAttribute("cod","1691" );
      ((Element)v.get(272)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */
      /* Termina nodo:272   */

      /* Empieza nodo:274 / Elemento padre: 269   */
      v.add(doc.createElement("td"));
      ((Element)v.get(269)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(275)).setAttribute("src","b.gif" );
      ((Element)v.get(275)).setAttribute("width","25" );
      ((Element)v.get(275)).setAttribute("height","8" );
      ((Element)v.get(274)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */
      /* Termina nodo:274   */

      /* Empieza nodo:276 / Elemento padre: 269   */
      v.add(doc.createElement("td"));
      ((Element)v.get(269)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
      v.add(doc.createElement("LABELC"));
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(277)).setAttribute("nombre","lblTipoPremiosMonetario2" );
      ((Element)v.get(277)).setAttribute("alto","13" );
      ((Element)v.get(277)).setAttribute("filas","1" );
      ((Element)v.get(277)).setAttribute("valor","" );
      ((Element)v.get(277)).setAttribute("id","datosTitle" );
      ((Element)v.get(277)).setAttribute("cod","1837" );
      ((Element)v.get(276)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */
      /* Termina nodo:276   */

      /* Empieza nodo:278 / Elemento padre: 269   */
      v.add(doc.createElement("td"));
      ((Element)v.get(269)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(279)).setAttribute("src","b.gif" );
      ((Element)v.get(279)).setAttribute("width","25" );
      ((Element)v.get(279)).setAttribute("height","8" );
      ((Element)v.get(278)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */
      /* Termina nodo:278   */

      /* Empieza nodo:280 / Elemento padre: 269   */
      v.add(doc.createElement("td"));
      ((Element)v.get(269)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(281)).setAttribute("nombre","lblCantidad2" );
      ((Element)v.get(281)).setAttribute("alto","13" );
      ((Element)v.get(281)).setAttribute("filas","1" );
      ((Element)v.get(281)).setAttribute("valor","" );
      ((Element)v.get(281)).setAttribute("id","datosTitle" );
      ((Element)v.get(281)).setAttribute("cod","1172" );
      ((Element)v.get(280)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */
      /* Termina nodo:280   */

      /* Empieza nodo:282 / Elemento padre: 269   */
      v.add(doc.createElement("td"));
      ((Element)v.get(269)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(283)).setAttribute("src","b.gif" );
      ((Element)v.get(283)).setAttribute("width","25" );
      ((Element)v.get(283)).setAttribute("height","8" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */
      /* Termina nodo:282   */

      /* Empieza nodo:284 / Elemento padre: 269   */
      v.add(doc.createElement("td"));
      ((Element)v.get(269)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(285)).setAttribute("nombre","lblPorcentaje2" );
      ((Element)v.get(285)).setAttribute("alto","13" );
      ((Element)v.get(285)).setAttribute("filas","1" );
      ((Element)v.get(285)).setAttribute("valor","" );
      ((Element)v.get(285)).setAttribute("id","datosTitle" );
      ((Element)v.get(285)).setAttribute("cod","790" );
      ((Element)v.get(284)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */
      /* Termina nodo:284   */

      /* Empieza nodo:286 / Elemento padre: 269   */
      v.add(doc.createElement("td"));
      ((Element)v.get(269)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(287)).setAttribute("src","b.gif" );
      ((Element)v.get(287)).setAttribute("width","25" );
      ((Element)v.get(287)).setAttribute("height","8" );
      ((Element)v.get(286)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */
      /* Termina nodo:286   */

      /* Empieza nodo:288 / Elemento padre: 269   */
      v.add(doc.createElement("td"));
      ((Element)v.get(269)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(289)).setAttribute("nombre","lblMoneda" );
      ((Element)v.get(289)).setAttribute("alto","13" );
      ((Element)v.get(289)).setAttribute("filas","1" );
      ((Element)v.get(289)).setAttribute("valor","" );
      ((Element)v.get(289)).setAttribute("id","datosTitle" );
      ((Element)v.get(289)).setAttribute("cod","1216" );
      ((Element)v.get(288)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */
      /* Termina nodo:288   */

      /* Empieza nodo:290 / Elemento padre: 269   */
      v.add(doc.createElement("td"));
      ((Element)v.get(290)).setAttribute("width","100%" );
      ((Element)v.get(269)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(291)).setAttribute("src","b.gif" );
      ((Element)v.get(291)).setAttribute("width","8" );
      ((Element)v.get(291)).setAttribute("height","8" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */
      /* Termina nodo:290   */
      /* Termina nodo:269   */

      /* Empieza nodo:292 / Elemento padre: 265   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(265)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("td"));
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
      ((Element)v.get(295)).setAttribute("valign","bottom" );
      ((Element)v.get(292)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(296)).setAttribute("nombre","lbNumPremio2" );
      ((Element)v.get(296)).setAttribute("alto","13" );
      ((Element)v.get(296)).setAttribute("filas","1" );
      ((Element)v.get(296)).setAttribute("valor","" );
      ((Element)v.get(296)).setAttribute("id","datosCampos" );
      ((Element)v.get(295)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */
      /* Termina nodo:295   */

      /* Empieza nodo:297 / Elemento padre: 292   */
      v.add(doc.createElement("td"));
      ((Element)v.get(292)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(298)).setAttribute("src","b.gif" );
      ((Element)v.get(298)).setAttribute("width","25" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(298)).setAttribute("height","8" );
      ((Element)v.get(297)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */
      /* Termina nodo:297   */

      /* Empieza nodo:299 / Elemento padre: 292   */
      v.add(doc.createElement("td"));
      ((Element)v.get(299)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(292)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(300)).setAttribute("nombre","cbTipoPremioMonetario2" );
      ((Element)v.get(300)).setAttribute("id","datosCampos" );
      ((Element)v.get(300)).setAttribute("size","1" );
      ((Element)v.get(300)).setAttribute("onchange","onChangeTipoPremiosMonetarios();" );
      ((Element)v.get(300)).setAttribute("multiple","N" );
      ((Element)v.get(300)).setAttribute("req","S" );
      ((Element)v.get(300)).setAttribute("valorinicial","" );
      ((Element)v.get(300)).setAttribute("textoinicial","" );
      ((Element)v.get(299)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(300)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */
      /* Termina nodo:300   */
      /* Termina nodo:299   */

      /* Empieza nodo:302 / Elemento padre: 292   */
      v.add(doc.createElement("td"));
      ((Element)v.get(292)).appendChild((Element)v.get(302));

      /* Empieza nodo:303 / Elemento padre: 302   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(303)).setAttribute("src","b.gif" );
      ((Element)v.get(303)).setAttribute("width","25" );
      ((Element)v.get(303)).setAttribute("height","8" );
      ((Element)v.get(302)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */
      /* Termina nodo:302   */

      /* Empieza nodo:304 / Elemento padre: 292   */
      v.add(doc.createElement("td"));
      ((Element)v.get(304)).setAttribute("valign","bottom" );
      ((Element)v.get(292)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(305)).setAttribute("nombre","txtCantidad2" );
      ((Element)v.get(305)).setAttribute("id","datosCampos" );
      ((Element)v.get(305)).setAttribute("max","8" );
      ((Element)v.get(305)).setAttribute("tipo","" );
      ((Element)v.get(305)).setAttribute("onchange","" );
      ((Element)v.get(305)).setAttribute("req","N" );
      ((Element)v.get(305)).setAttribute("size","7" );
      ((Element)v.get(305)).setAttribute("valor","" );
      ((Element)v.get(305)).setAttribute("validacion","" );
      ((Element)v.get(304)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */
      /* Termina nodo:304   */

      /* Empieza nodo:306 / Elemento padre: 292   */
      v.add(doc.createElement("td"));
      ((Element)v.get(292)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(307)).setAttribute("src","b.gif" );
      ((Element)v.get(307)).setAttribute("width","25" );
      ((Element)v.get(307)).setAttribute("height","8" );
      ((Element)v.get(306)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */
      /* Termina nodo:306   */

      /* Empieza nodo:308 / Elemento padre: 292   */
      v.add(doc.createElement("td"));
      ((Element)v.get(308)).setAttribute("valign","bottom" );
      ((Element)v.get(292)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(309)).setAttribute("nombre","txtPorcentaje2" );
      ((Element)v.get(309)).setAttribute("id","datosCampos" );
      ((Element)v.get(309)).setAttribute("max","6" );
      ((Element)v.get(309)).setAttribute("tipo","" );
      ((Element)v.get(309)).setAttribute("onchange","" );
      ((Element)v.get(309)).setAttribute("req","N" );
      ((Element)v.get(309)).setAttribute("size","6" );
      ((Element)v.get(309)).setAttribute("valor","" );
      ((Element)v.get(309)).setAttribute("validacion","" );
      ((Element)v.get(308)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */
      /* Termina nodo:308   */

      /* Empieza nodo:310 / Elemento padre: 292   */
      v.add(doc.createElement("td"));
      ((Element)v.get(292)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(311)).setAttribute("src","b.gif" );
      ((Element)v.get(311)).setAttribute("width","25" );
      ((Element)v.get(311)).setAttribute("height","8" );
      ((Element)v.get(310)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */
      /* Termina nodo:310   */

      /* Empieza nodo:312 / Elemento padre: 292   */
      v.add(doc.createElement("td"));
      ((Element)v.get(312)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(292)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(313)).setAttribute("nombre","cbMoneda" );
      ((Element)v.get(313)).setAttribute("id","datosCampos" );
      ((Element)v.get(313)).setAttribute("size","1" );
      ((Element)v.get(313)).setAttribute("multiple","N" );
      ((Element)v.get(313)).setAttribute("req","S" );
      ((Element)v.get(313)).setAttribute("valorinicial","" );
      ((Element)v.get(313)).setAttribute("textoinicial","" );
      ((Element)v.get(312)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(313)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */
      /* Termina nodo:313   */
      /* Termina nodo:312   */

      /* Empieza nodo:315 / Elemento padre: 292   */
      v.add(doc.createElement("td"));
      ((Element)v.get(315)).setAttribute("width","100%" );
      ((Element)v.get(292)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(316)).setAttribute("src","b.gif" );
      ((Element)v.get(316)).setAttribute("width","8" );
      ((Element)v.get(316)).setAttribute("height","8" );
      ((Element)v.get(315)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */
      /* Termina nodo:315   */
      /* Termina nodo:292   */

      /* Empieza nodo:317 / Elemento padre: 265   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(265)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
   }

   private void getXML1530(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(318)).setAttribute("colspan","4" );
      ((Element)v.get(317)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(319)).setAttribute("src","b.gif" );
      ((Element)v.get(319)).setAttribute("width","8" );
      ((Element)v.get(319)).setAttribute("height","8" );
      ((Element)v.get(318)).appendChild((Element)v.get(319));
      /* Termina nodo:319   */
      /* Termina nodo:318   */
      /* Termina nodo:317   */
      /* Termina nodo:265   */
      /* Termina nodo:264   */
      /* Termina nodo:263   */

      /* Empieza nodo:320 / Elemento padre: 262   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(262)).appendChild((Element)v.get(320));

      /* Empieza nodo:321 / Elemento padre: 320   */
      v.add(doc.createElement("td"));
      ((Element)v.get(320)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("table"));
      ((Element)v.get(322)).setAttribute("width","728" );
      ((Element)v.get(322)).setAttribute("border","0" );
      ((Element)v.get(322)).setAttribute("align","left" );
      ((Element)v.get(322)).setAttribute("cellspacing","0" );
      ((Element)v.get(322)).setAttribute("cellpadding","0" );
      ((Element)v.get(321)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(322)).appendChild((Element)v.get(323));

      /* Empieza nodo:324 / Elemento padre: 323   */
      v.add(doc.createElement("td"));
      ((Element)v.get(323)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(325)).setAttribute("src","b.gif" );
      ((Element)v.get(325)).setAttribute("width","8" );
      ((Element)v.get(325)).setAttribute("height","8" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */
      /* Termina nodo:324   */

      /* Empieza nodo:326 / Elemento padre: 323   */
      v.add(doc.createElement("td"));
      ((Element)v.get(323)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(327)).setAttribute("nombre","lblFormaPago" );
      ((Element)v.get(327)).setAttribute("alto","13" );
      ((Element)v.get(327)).setAttribute("filas","1" );
      ((Element)v.get(327)).setAttribute("valor","" );
      ((Element)v.get(327)).setAttribute("id","datosTitle" );
      ((Element)v.get(327)).setAttribute("cod","541" );
      ((Element)v.get(326)).appendChild((Element)v.get(327));
      /* Termina nodo:327   */
      /* Termina nodo:326   */

      /* Empieza nodo:328 / Elemento padre: 323   */
      v.add(doc.createElement("td"));
      ((Element)v.get(328)).setAttribute("width","100%" );
      ((Element)v.get(323)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(329)).setAttribute("src","b.gif" );
      ((Element)v.get(329)).setAttribute("width","8" );
      ((Element)v.get(329)).setAttribute("height","8" );
      ((Element)v.get(328)).appendChild((Element)v.get(329));
      /* Termina nodo:329   */
      /* Termina nodo:328   */
      /* Termina nodo:323   */

      /* Empieza nodo:330 / Elemento padre: 322   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(322)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("td"));
      ((Element)v.get(330)).appendChild((Element)v.get(331));

      /* Empieza nodo:332 / Elemento padre: 331   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(332)).setAttribute("src","b.gif" );
      ((Element)v.get(332)).setAttribute("width","8" );
      ((Element)v.get(332)).setAttribute("height","8" );
      ((Element)v.get(331)).appendChild((Element)v.get(332));
      /* Termina nodo:332   */
      /* Termina nodo:331   */

      /* Empieza nodo:333 / Elemento padre: 330   */
      v.add(doc.createElement("td"));
      ((Element)v.get(333)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(330)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(334)).setAttribute("nombre","cbFormaPago" );
      ((Element)v.get(334)).setAttribute("id","datosCampos" );
      ((Element)v.get(334)).setAttribute("size","1" );
      ((Element)v.get(334)).setAttribute("multiple","N" );
      ((Element)v.get(334)).setAttribute("req","S" );
      ((Element)v.get(334)).setAttribute("valorinicial","" );
      ((Element)v.get(334)).setAttribute("textoinicial","" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));

      /* Empieza nodo:335 / Elemento padre: 334   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(334)).appendChild((Element)v.get(335));
      /* Termina nodo:335   */
      /* Termina nodo:334   */
      /* Termina nodo:333   */

      /* Empieza nodo:336 / Elemento padre: 330   */
      v.add(doc.createElement("td"));
      ((Element)v.get(336)).setAttribute("width","100%" );
      ((Element)v.get(330)).appendChild((Element)v.get(336));

      /* Empieza nodo:337 / Elemento padre: 336   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(337)).setAttribute("src","b.gif" );
      ((Element)v.get(337)).setAttribute("width","8" );
      ((Element)v.get(337)).setAttribute("height","8" );
      ((Element)v.get(336)).appendChild((Element)v.get(337));
      /* Termina nodo:337   */
      /* Termina nodo:336   */
      /* Termina nodo:330   */

      /* Empieza nodo:338 / Elemento padre: 322   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(322)).appendChild((Element)v.get(338));

      /* Empieza nodo:339 / Elemento padre: 338   */
      v.add(doc.createElement("td"));
      ((Element)v.get(339)).setAttribute("colspan","4" );
      ((Element)v.get(338)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(340)).setAttribute("src","b.gif" );
      ((Element)v.get(340)).setAttribute("width","8" );
      ((Element)v.get(340)).setAttribute("height","8" );
      ((Element)v.get(339)).appendChild((Element)v.get(340));
      /* Termina nodo:340   */
      /* Termina nodo:339   */
      /* Termina nodo:338   */
      /* Termina nodo:322   */
      /* Termina nodo:321   */
      /* Termina nodo:320   */
      /* Termina nodo:262   */
      /* Termina nodo:259   */
      /* Termina nodo:258   */

      /* Empieza nodo:341 / Elemento padre: 255   */
      v.add(doc.createElement("td"));
      ((Element)v.get(255)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(342)).setAttribute("src","b.gif" );
      ((Element)v.get(341)).appendChild((Element)v.get(342));
      /* Termina nodo:342   */
      /* Termina nodo:341   */
      /* Termina nodo:255   */

      /* Empieza nodo:343 / Elemento padre: 247   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(247)).appendChild((Element)v.get(343));

      /* Empieza nodo:344 / Elemento padre: 343   */
      v.add(doc.createElement("td"));
      ((Element)v.get(344)).setAttribute("width","12" );
      ((Element)v.get(344)).setAttribute("align","center" );
      ((Element)v.get(343)).appendChild((Element)v.get(344));

      /* Empieza nodo:345 / Elemento padre: 344   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(345)).setAttribute("src","b.gif" );
      ((Element)v.get(345)).setAttribute("width","12" );
      ((Element)v.get(345)).setAttribute("height","12" );
      ((Element)v.get(344)).appendChild((Element)v.get(345));
      /* Termina nodo:345   */
      /* Termina nodo:344   */

      /* Empieza nodo:346 / Elemento padre: 343   */
      v.add(doc.createElement("td"));
      ((Element)v.get(346)).setAttribute("width","756" );
      ((Element)v.get(343)).appendChild((Element)v.get(346));

      /* Empieza nodo:347 / Elemento padre: 346   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(347)).setAttribute("src","b.gif" );
      ((Element)v.get(346)).appendChild((Element)v.get(347));
      /* Termina nodo:347   */
      /* Termina nodo:346   */

      /* Empieza nodo:348 / Elemento padre: 343   */
      v.add(doc.createElement("td"));
      ((Element)v.get(348)).setAttribute("width","12" );
      ((Element)v.get(343)).appendChild((Element)v.get(348));

      /* Empieza nodo:349 / Elemento padre: 348   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(349)).setAttribute("src","b.gif" );
      ((Element)v.get(349)).setAttribute("width","12" );
      ((Element)v.get(349)).setAttribute("height","1" );
      ((Element)v.get(348)).appendChild((Element)v.get(349));
      /* Termina nodo:349   */
      /* Termina nodo:348   */
      /* Termina nodo:343   */
      /* Termina nodo:247   */
      /* Termina nodo:246   */

      /* Empieza nodo:350 / Elemento padre: 36   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(350)).setAttribute("nombre","capaBoton" );
      ((Element)v.get(350)).setAttribute("x","0" );
      ((Element)v.get(350)).setAttribute("y","447" );
      ((Element)v.get(350)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(36)).appendChild((Element)v.get(350));

      /* Empieza nodo:351 / Elemento padre: 350   */
      v.add(doc.createElement("table"));
      ((Element)v.get(351)).setAttribute("width","100%" );
      ((Element)v.get(351)).setAttribute("border","0" );
      ((Element)v.get(351)).setAttribute("cellspacing","0" );
      ((Element)v.get(351)).setAttribute("cellpadding","0" );
      ((Element)v.get(350)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(351)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
      v.add(doc.createElement("td"));
      ((Element)v.get(353)).setAttribute("width","12" );
      ((Element)v.get(353)).setAttribute("align","center" );
      ((Element)v.get(352)).appendChild((Element)v.get(353));

      /* Empieza nodo:354 / Elemento padre: 353   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(354)).setAttribute("src","b.gif" );
      ((Element)v.get(354)).setAttribute("width","12" );
      ((Element)v.get(354)).setAttribute("height","12" );
      ((Element)v.get(353)).appendChild((Element)v.get(354));
      /* Termina nodo:354   */
      /* Termina nodo:353   */

      /* Empieza nodo:355 / Elemento padre: 352   */
      v.add(doc.createElement("td"));
      ((Element)v.get(355)).setAttribute("width","750" );
      ((Element)v.get(352)).appendChild((Element)v.get(355));

      /* Empieza nodo:356 / Elemento padre: 355   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(356)).setAttribute("src","b.gif" );
      ((Element)v.get(355)).appendChild((Element)v.get(356));
      /* Termina nodo:356   */
      /* Termina nodo:355   */

      /* Empieza nodo:357 / Elemento padre: 352   */
      v.add(doc.createElement("td"));
      ((Element)v.get(357)).setAttribute("width","12" );
      ((Element)v.get(352)).appendChild((Element)v.get(357));

      /* Empieza nodo:358 / Elemento padre: 357   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(358)).setAttribute("src","b.gif" );
      ((Element)v.get(358)).setAttribute("width","12" );
      ((Element)v.get(358)).setAttribute("height","1" );
      ((Element)v.get(357)).appendChild((Element)v.get(358));
      /* Termina nodo:358   */
      /* Termina nodo:357   */
      /* Termina nodo:352   */

      /* Empieza nodo:359 / Elemento padre: 351   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(351)).appendChild((Element)v.get(359));

      /* Empieza nodo:360 / Elemento padre: 359   */
      v.add(doc.createElement("td"));
      ((Element)v.get(359)).appendChild((Element)v.get(360));

      /* Empieza nodo:361 / Elemento padre: 360   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(361)).setAttribute("src","b.gif" );
      ((Element)v.get(360)).appendChild((Element)v.get(361));
      /* Termina nodo:361   */
      /* Termina nodo:360   */

      /* Empieza nodo:362 / Elemento padre: 359   */
      v.add(doc.createElement("td"));
      ((Element)v.get(359)).appendChild((Element)v.get(362));

      /* Empieza nodo:363 / Elemento padre: 362   */
      v.add(doc.createElement("table"));
      ((Element)v.get(363)).setAttribute("width","100%" );
      ((Element)v.get(363)).setAttribute("border","0" );
      ((Element)v.get(363)).setAttribute("align","center" );
      ((Element)v.get(363)).setAttribute("cellspacing","0" );
      ((Element)v.get(363)).setAttribute("cellpadding","0" );
      ((Element)v.get(362)).appendChild((Element)v.get(363));

      /* Empieza nodo:364 / Elemento padre: 363   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(363)).appendChild((Element)v.get(364));

      /* Empieza nodo:365 / Elemento padre: 364   */
      v.add(doc.createElement("td"));
      ((Element)v.get(364)).appendChild((Element)v.get(365));

      /* Empieza nodo:366 / Elemento padre: 365   */
      v.add(doc.createElement("table"));
      ((Element)v.get(366)).setAttribute("width","732" );
      ((Element)v.get(366)).setAttribute("border","0" );
      ((Element)v.get(366)).setAttribute("align","left" );
      ((Element)v.get(366)).setAttribute("cellspacing","0" );
      ((Element)v.get(366)).setAttribute("cellpadding","0" );
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(365)).appendChild((Element)v.get(366));

      /* Empieza nodo:367 / Elemento padre: 366   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(366)).appendChild((Element)v.get(367));

      /* Empieza nodo:368 / Elemento padre: 367   */
      v.add(doc.createElement("td"));
      ((Element)v.get(367)).appendChild((Element)v.get(368));

      /* Empieza nodo:369 / Elemento padre: 368   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(369)).setAttribute("src","b.gif" );
      ((Element)v.get(368)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */
      /* Termina nodo:368   */
      /* Termina nodo:367   */
      /* Termina nodo:366   */
      /* Termina nodo:365   */
      /* Termina nodo:364   */
      /* Termina nodo:363   */
      /* Termina nodo:362   */

      /* Empieza nodo:370 / Elemento padre: 359   */
      v.add(doc.createElement("td"));
      ((Element)v.get(359)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(371)).setAttribute("src","b.gif" );
      ((Element)v.get(370)).appendChild((Element)v.get(371));
      /* Termina nodo:371   */
      /* Termina nodo:370   */
      /* Termina nodo:359   */

      /* Empieza nodo:372 / Elemento padre: 351   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(351)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("td"));
      ((Element)v.get(372)).appendChild((Element)v.get(373));

      /* Empieza nodo:374 / Elemento padre: 373   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(374)).setAttribute("src","b.gif" );
      ((Element)v.get(373)).appendChild((Element)v.get(374));
      /* Termina nodo:374   */
      /* Termina nodo:373   */

      /* Empieza nodo:375 / Elemento padre: 372   */
      v.add(doc.createElement("td"));
      ((Element)v.get(372)).appendChild((Element)v.get(375));

      /* Empieza nodo:376 / Elemento padre: 375   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(375)).appendChild((Element)v.get(376));

      /* Empieza nodo:377 / Elemento padre: 376   */
      v.add(doc.createElement("table"));
      ((Element)v.get(377)).setAttribute("width","100%" );
      ((Element)v.get(377)).setAttribute("border","0" );
      ((Element)v.get(377)).setAttribute("align","center" );
      ((Element)v.get(377)).setAttribute("cellspacing","0" );
      ((Element)v.get(377)).setAttribute("cellpadding","0" );
      ((Element)v.get(376)).appendChild((Element)v.get(377));

      /* Empieza nodo:378 / Elemento padre: 377   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(377)).appendChild((Element)v.get(378));

      /* Empieza nodo:379 / Elemento padre: 378   */
      v.add(doc.createElement("td"));
      ((Element)v.get(379)).setAttribute("class","botonera" );
      ((Element)v.get(378)).appendChild((Element)v.get(379));

      /* Empieza nodo:380 / Elemento padre: 379   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(380)).setAttribute("nombre","btnAceptar5" );
      ((Element)v.get(380)).setAttribute("ID","botonContenido" );
      ((Element)v.get(380)).setAttribute("tipo","html" );
      ((Element)v.get(380)).setAttribute("accion","accionAceptar(get('formulario.OID_TIPO_PREMIO_MONETARIO'));" );
      ((Element)v.get(380)).setAttribute("estado","false" );
      ((Element)v.get(380)).setAttribute("cod","12" );
      ((Element)v.get(379)).appendChild((Element)v.get(380));
      /* Termina nodo:380   */
      /* Termina nodo:379   */
      /* Termina nodo:378   */
      /* Termina nodo:377   */
      /* Termina nodo:376   */
      /* Termina nodo:375   */

      /* Empieza nodo:381 / Elemento padre: 372   */
      v.add(doc.createElement("td"));
      ((Element)v.get(372)).appendChild((Element)v.get(381));

      /* Empieza nodo:382 / Elemento padre: 381   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(382)).setAttribute("src","b.gif" );
      ((Element)v.get(382)).setAttribute("width","8" );
      ((Element)v.get(382)).setAttribute("height","12" );
      ((Element)v.get(381)).appendChild((Element)v.get(382));
      /* Termina nodo:382   */
      /* Termina nodo:381   */
      /* Termina nodo:372   */

      /* Empieza nodo:383 / Elemento padre: 351   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(351)).appendChild((Element)v.get(383));

      /* Empieza nodo:384 / Elemento padre: 383   */
      v.add(doc.createElement("td"));
      ((Element)v.get(384)).setAttribute("width","12" );
      ((Element)v.get(384)).setAttribute("align","center" );
      ((Element)v.get(383)).appendChild((Element)v.get(384));

      /* Empieza nodo:385 / Elemento padre: 384   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(385)).setAttribute("src","b.gif" );
      ((Element)v.get(385)).setAttribute("width","12" );
      ((Element)v.get(385)).setAttribute("height","12" );
      ((Element)v.get(384)).appendChild((Element)v.get(385));
      /* Termina nodo:385   */
      /* Termina nodo:384   */

      /* Empieza nodo:386 / Elemento padre: 383   */
      v.add(doc.createElement("td"));
      ((Element)v.get(386)).setAttribute("width","756" );
      ((Element)v.get(383)).appendChild((Element)v.get(386));

      /* Empieza nodo:387 / Elemento padre: 386   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(387)).setAttribute("src","b.gif" );
      ((Element)v.get(386)).appendChild((Element)v.get(387));
      /* Termina nodo:387   */
      /* Termina nodo:386   */

      /* Empieza nodo:388 / Elemento padre: 383   */
      v.add(doc.createElement("td"));
      ((Element)v.get(388)).setAttribute("width","12" );
      ((Element)v.get(383)).appendChild((Element)v.get(388));

      /* Empieza nodo:389 / Elemento padre: 388   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(389)).setAttribute("src","b.gif" );
      ((Element)v.get(389)).setAttribute("width","12" );
      ((Element)v.get(389)).setAttribute("height","1" );
      ((Element)v.get(388)).appendChild((Element)v.get(389));
      /* Termina nodo:389   */
      /* Termina nodo:388   */
      /* Termina nodo:383   */
      /* Termina nodo:351   */
      /* Termina nodo:350   */

      /* Empieza nodo:390 / Elemento padre: 36   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(390)).setAttribute("nombre","capa3" );
      ((Element)v.get(390)).setAttribute("alto","540" );
      ((Element)v.get(390)).setAttribute("ancho","100%" );
      ((Element)v.get(390)).setAttribute("colorf","" );
      ((Element)v.get(390)).setAttribute("borde","0" );
      ((Element)v.get(390)).setAttribute("imagenf","" );
      ((Element)v.get(390)).setAttribute("repeat","" );
      ((Element)v.get(390)).setAttribute("padding","" );
      ((Element)v.get(390)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(390)).setAttribute("contravsb","" );
      ((Element)v.get(390)).setAttribute("x","0" );
      ((Element)v.get(390)).setAttribute("y","463" );
      ((Element)v.get(390)).setAttribute("zindex","" );
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(36)).appendChild((Element)v.get(390));

      /* Empieza nodo:391 / Elemento padre: 390   */
      v.add(doc.createElement("table"));
      ((Element)v.get(391)).setAttribute("width","100%" );
      ((Element)v.get(391)).setAttribute("border","0" );
      ((Element)v.get(391)).setAttribute("cellspacing","0" );
      ((Element)v.get(391)).setAttribute("cellpadding","0" );
      ((Element)v.get(390)).appendChild((Element)v.get(391));

      /* Empieza nodo:392 / Elemento padre: 391   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(391)).appendChild((Element)v.get(392));

      /* Empieza nodo:393 / Elemento padre: 392   */
      v.add(doc.createElement("td"));
      ((Element)v.get(393)).setAttribute("width","12" );
      ((Element)v.get(393)).setAttribute("align","center" );
      ((Element)v.get(392)).appendChild((Element)v.get(393));

      /* Empieza nodo:394 / Elemento padre: 393   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(394)).setAttribute("src","b.gif" );
      ((Element)v.get(394)).setAttribute("width","12" );
      ((Element)v.get(394)).setAttribute("height","12" );
      ((Element)v.get(393)).appendChild((Element)v.get(394));
      /* Termina nodo:394   */
      /* Termina nodo:393   */

      /* Empieza nodo:395 / Elemento padre: 392   */
      v.add(doc.createElement("td"));
      ((Element)v.get(395)).setAttribute("width","750" );
      ((Element)v.get(392)).appendChild((Element)v.get(395));

      /* Empieza nodo:396 / Elemento padre: 395   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(396)).setAttribute("src","b.gif" );
      ((Element)v.get(395)).appendChild((Element)v.get(396));
      /* Termina nodo:396   */
      /* Termina nodo:395   */

      /* Empieza nodo:397 / Elemento padre: 392   */
      v.add(doc.createElement("td"));
      ((Element)v.get(397)).setAttribute("width","12" );
      ((Element)v.get(392)).appendChild((Element)v.get(397));

      /* Empieza nodo:398 / Elemento padre: 397   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(398)).setAttribute("src","b.gif" );
      ((Element)v.get(398)).setAttribute("width","12" );
      ((Element)v.get(398)).setAttribute("height","1" );
      ((Element)v.get(397)).appendChild((Element)v.get(398));
      /* Termina nodo:398   */
      /* Termina nodo:397   */
      /* Termina nodo:392   */

      /* Empieza nodo:399 / Elemento padre: 391   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(391)).appendChild((Element)v.get(399));

      /* Empieza nodo:400 / Elemento padre: 399   */
      v.add(doc.createElement("td"));
      ((Element)v.get(399)).appendChild((Element)v.get(400));

      /* Empieza nodo:401 / Elemento padre: 400   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(401)).setAttribute("src","b.gif" );
      ((Element)v.get(400)).appendChild((Element)v.get(401));
      /* Termina nodo:401   */
      /* Termina nodo:400   */

      /* Empieza nodo:402 / Elemento padre: 399   */
      v.add(doc.createElement("td"));
      ((Element)v.get(399)).appendChild((Element)v.get(402));

      /* Empieza nodo:403 / Elemento padre: 402   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(402)).appendChild((Element)v.get(403));

      /* Empieza nodo:404 / Elemento padre: 403   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(404)).setAttribute("class","legend" );
      ((Element)v.get(403)).appendChild((Element)v.get(404));

      /* Empieza nodo:405 / Elemento padre: 404   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(405)).setAttribute("nombre","lblOtrosDatosPremiosMonetario" );
      ((Element)v.get(405)).setAttribute("alto","13" );
      ((Element)v.get(405)).setAttribute("filas","1" );
      ((Element)v.get(405)).setAttribute("valor","" );
      ((Element)v.get(405)).setAttribute("id","legend" );
      ((Element)v.get(405)).setAttribute("cod","00349" );
      ((Element)v.get(404)).appendChild((Element)v.get(405));
      /* Termina nodo:405   */
      /* Termina nodo:404   */

      /* Empieza nodo:406 / Elemento padre: 403   */
      v.add(doc.createElement("table"));
      ((Element)v.get(406)).setAttribute("width","100%" );
      ((Element)v.get(406)).setAttribute("border","0" );
      ((Element)v.get(406)).setAttribute("align","center" );
      ((Element)v.get(406)).setAttribute("cellspacing","0" );
      ((Element)v.get(406)).setAttribute("cellpadding","0" );
      ((Element)v.get(403)).appendChild((Element)v.get(406));

      /* Empieza nodo:407 / Elemento padre: 406   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(406)).appendChild((Element)v.get(407));

      /* Empieza nodo:408 / Elemento padre: 407   */
      v.add(doc.createElement("td"));
      ((Element)v.get(407)).appendChild((Element)v.get(408));

      /* Empieza nodo:409 / Elemento padre: 408   */
      v.add(doc.createElement("table"));
      ((Element)v.get(409)).setAttribute("width","728" );
      ((Element)v.get(409)).setAttribute("border","0" );
      ((Element)v.get(409)).setAttribute("align","left" );
      ((Element)v.get(409)).setAttribute("cellspacing","0" );
      ((Element)v.get(409)).setAttribute("cellpadding","0" );
      ((Element)v.get(408)).appendChild((Element)v.get(409));

      /* Empieza nodo:410 / Elemento padre: 409   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(409)).appendChild((Element)v.get(410));

      /* Empieza nodo:411 / Elemento padre: 410   */
      v.add(doc.createElement("td"));
      ((Element)v.get(411)).setAttribute("colspan","4" );
      ((Element)v.get(410)).appendChild((Element)v.get(411));

      /* Empieza nodo:412 / Elemento padre: 411   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(412)).setAttribute("src","b.gif" );
      ((Element)v.get(412)).setAttribute("width","8" );
      ((Element)v.get(412)).setAttribute("height","8" );
      ((Element)v.get(411)).appendChild((Element)v.get(412));
      /* Termina nodo:412   */
      /* Termina nodo:411   */
      /* Termina nodo:410   */

      /* Empieza nodo:413 / Elemento padre: 409   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(409)).appendChild((Element)v.get(413));

      /* Empieza nodo:414 / Elemento padre: 413   */
      v.add(doc.createElement("td"));
      ((Element)v.get(413)).appendChild((Element)v.get(414));

      /* Empieza nodo:415 / Elemento padre: 414   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(415)).setAttribute("src","b.gif" );
      ((Element)v.get(415)).setAttribute("width","8" );
      ((Element)v.get(415)).setAttribute("height","8" );
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(414)).appendChild((Element)v.get(415));
      /* Termina nodo:415   */
      /* Termina nodo:414   */

      /* Empieza nodo:416 / Elemento padre: 413   */
      v.add(doc.createElement("td"));
      ((Element)v.get(413)).appendChild((Element)v.get(416));

      /* Empieza nodo:417 / Elemento padre: 416   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(417)).setAttribute("nombre","lblPagoPartes" );
      ((Element)v.get(417)).setAttribute("alto","13" );
      ((Element)v.get(417)).setAttribute("filas","1" );
      ((Element)v.get(417)).setAttribute("valor","" );
      ((Element)v.get(417)).setAttribute("id","datosTitle" );
      ((Element)v.get(417)).setAttribute("cod","1838" );
      ((Element)v.get(416)).appendChild((Element)v.get(417));
      /* Termina nodo:417   */
      /* Termina nodo:416   */

      /* Empieza nodo:418 / Elemento padre: 413   */
      v.add(doc.createElement("td"));
      ((Element)v.get(413)).appendChild((Element)v.get(418));

      /* Empieza nodo:419 / Elemento padre: 418   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(419)).setAttribute("src","b.gif" );
      ((Element)v.get(419)).setAttribute("width","25" );
      ((Element)v.get(419)).setAttribute("height","8" );
      ((Element)v.get(418)).appendChild((Element)v.get(419));
      /* Termina nodo:419   */
      /* Termina nodo:418   */

      /* Empieza nodo:420 / Elemento padre: 413   */
      v.add(doc.createElement("td"));
      ((Element)v.get(413)).appendChild((Element)v.get(420));

      /* Empieza nodo:421 / Elemento padre: 420   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(421)).setAttribute("nombre","lblCumplimiento" );
      ((Element)v.get(421)).setAttribute("alto","13" );
      ((Element)v.get(421)).setAttribute("filas","1" );
      ((Element)v.get(421)).setAttribute("valor","" );
      ((Element)v.get(421)).setAttribute("id","datosTitle" );
      ((Element)v.get(421)).setAttribute("cod","1839" );
      ((Element)v.get(420)).appendChild((Element)v.get(421));
      /* Termina nodo:421   */
      /* Termina nodo:420   */

      /* Empieza nodo:422 / Elemento padre: 413   */
      v.add(doc.createElement("td"));
      ((Element)v.get(413)).appendChild((Element)v.get(422));

      /* Empieza nodo:423 / Elemento padre: 422   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(423)).setAttribute("src","b.gif" );
      ((Element)v.get(423)).setAttribute("width","25" );
      ((Element)v.get(423)).setAttribute("height","8" );
      ((Element)v.get(422)).appendChild((Element)v.get(423));
      /* Termina nodo:423   */
      /* Termina nodo:422   */

      /* Empieza nodo:424 / Elemento padre: 413   */
      v.add(doc.createElement("td"));
      ((Element)v.get(413)).appendChild((Element)v.get(424));

      /* Empieza nodo:425 / Elemento padre: 424   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(425)).setAttribute("nombre","lblDescontarPago" );
      ((Element)v.get(425)).setAttribute("alto","13" );
      ((Element)v.get(425)).setAttribute("filas","1" );
      ((Element)v.get(425)).setAttribute("valor","" );
      ((Element)v.get(425)).setAttribute("id","datosTitle" );
      ((Element)v.get(425)).setAttribute("cod","1840" );
      ((Element)v.get(424)).appendChild((Element)v.get(425));
      /* Termina nodo:425   */
      /* Termina nodo:424   */

      /* Empieza nodo:426 / Elemento padre: 413   */
      v.add(doc.createElement("td"));
      ((Element)v.get(426)).setAttribute("width","100%" );
      ((Element)v.get(413)).appendChild((Element)v.get(426));

      /* Empieza nodo:427 / Elemento padre: 426   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(427)).setAttribute("src","b.gif" );
      ((Element)v.get(427)).setAttribute("width","8" );
      ((Element)v.get(427)).setAttribute("height","8" );
      ((Element)v.get(426)).appendChild((Element)v.get(427));
      /* Termina nodo:427   */
      /* Termina nodo:426   */
      /* Termina nodo:413   */

      /* Empieza nodo:428 / Elemento padre: 409   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(409)).appendChild((Element)v.get(428));

      /* Empieza nodo:429 / Elemento padre: 428   */
      v.add(doc.createElement("td"));
      ((Element)v.get(428)).appendChild((Element)v.get(429));

      /* Empieza nodo:430 / Elemento padre: 429   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(430)).setAttribute("src","b.gif" );
      ((Element)v.get(430)).setAttribute("width","8" );
      ((Element)v.get(430)).setAttribute("height","8" );
      ((Element)v.get(429)).appendChild((Element)v.get(430));
      /* Termina nodo:430   */
      /* Termina nodo:429   */

      /* Empieza nodo:431 / Elemento padre: 428   */
      v.add(doc.createElement("td"));
      ((Element)v.get(428)).appendChild((Element)v.get(431));

      /* Empieza nodo:432 / Elemento padre: 431   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(432)).setAttribute("nombre","ckPagoPartes" );
      ((Element)v.get(432)).setAttribute("id","datosCampos" );
      ((Element)v.get(432)).setAttribute("onclick","" );
      ((Element)v.get(432)).setAttribute("check","S" );
      ((Element)v.get(431)).appendChild((Element)v.get(432));
      /* Termina nodo:432   */
      /* Termina nodo:431   */

      /* Empieza nodo:433 / Elemento padre: 428   */
      v.add(doc.createElement("td"));
      ((Element)v.get(428)).appendChild((Element)v.get(433));

      /* Empieza nodo:434 / Elemento padre: 433   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(434)).setAttribute("src","b.gif" );
      ((Element)v.get(434)).setAttribute("width","25" );
      ((Element)v.get(434)).setAttribute("height","8" );
      ((Element)v.get(433)).appendChild((Element)v.get(434));
      /* Termina nodo:434   */
      /* Termina nodo:433   */

      /* Empieza nodo:435 / Elemento padre: 428   */
      v.add(doc.createElement("td"));
      ((Element)v.get(435)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(428)).appendChild((Element)v.get(435));

      /* Empieza nodo:436 / Elemento padre: 435   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(436)).setAttribute("nombre","cbCumplimiento" );
      ((Element)v.get(436)).setAttribute("id","datosCampos" );
      ((Element)v.get(436)).setAttribute("size","1" );
      ((Element)v.get(436)).setAttribute("onchange","onChangeCumplimiento();" );
      ((Element)v.get(436)).setAttribute("multiple","N" );
      ((Element)v.get(436)).setAttribute("req","S" );
      ((Element)v.get(436)).setAttribute("valorinicial","" );
      ((Element)v.get(436)).setAttribute("textoinicial","" );
      ((Element)v.get(435)).appendChild((Element)v.get(436));

      /* Empieza nodo:437 / Elemento padre: 436   */
   }

   private void getXML1980(Document doc) {
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(436)).appendChild((Element)v.get(437));
      /* Termina nodo:437   */
      /* Termina nodo:436   */
      /* Termina nodo:435   */

      /* Empieza nodo:438 / Elemento padre: 428   */
      v.add(doc.createElement("td"));
      ((Element)v.get(428)).appendChild((Element)v.get(438));

      /* Empieza nodo:439 / Elemento padre: 438   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(439)).setAttribute("src","b.gif" );
      ((Element)v.get(439)).setAttribute("width","25" );
      ((Element)v.get(439)).setAttribute("height","8" );
      ((Element)v.get(438)).appendChild((Element)v.get(439));
      /* Termina nodo:439   */
      /* Termina nodo:438   */

      /* Empieza nodo:440 / Elemento padre: 428   */
      v.add(doc.createElement("td"));
      ((Element)v.get(428)).appendChild((Element)v.get(440));

      /* Empieza nodo:441 / Elemento padre: 440   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(441)).setAttribute("nombre","ckDescontarPago" );
      ((Element)v.get(441)).setAttribute("id","datosCampos" );
      ((Element)v.get(441)).setAttribute("onclick","" );
      ((Element)v.get(441)).setAttribute("check","N" );
      ((Element)v.get(440)).appendChild((Element)v.get(441));
      /* Termina nodo:441   */
      /* Termina nodo:440   */

      /* Empieza nodo:442 / Elemento padre: 428   */
      v.add(doc.createElement("td"));
      ((Element)v.get(442)).setAttribute("width","100%" );
      ((Element)v.get(428)).appendChild((Element)v.get(442));

      /* Empieza nodo:443 / Elemento padre: 442   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(443)).setAttribute("src","b.gif" );
      ((Element)v.get(443)).setAttribute("width","8" );
      ((Element)v.get(443)).setAttribute("height","8" );
      ((Element)v.get(442)).appendChild((Element)v.get(443));
      /* Termina nodo:443   */
      /* Termina nodo:442   */
      /* Termina nodo:428   */

      /* Empieza nodo:444 / Elemento padre: 409   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(409)).appendChild((Element)v.get(444));

      /* Empieza nodo:445 / Elemento padre: 444   */
      v.add(doc.createElement("td"));
      ((Element)v.get(445)).setAttribute("colspan","4" );
      ((Element)v.get(444)).appendChild((Element)v.get(445));

      /* Empieza nodo:446 / Elemento padre: 445   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(446)).setAttribute("src","b.gif" );
      ((Element)v.get(446)).setAttribute("width","8" );
      ((Element)v.get(446)).setAttribute("height","8" );
      ((Element)v.get(445)).appendChild((Element)v.get(446));
      /* Termina nodo:446   */
      /* Termina nodo:445   */
      /* Termina nodo:444   */
      /* Termina nodo:409   */
      /* Termina nodo:408   */
      /* Termina nodo:407   */

      /* Empieza nodo:447 / Elemento padre: 406   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(406)).appendChild((Element)v.get(447));

      /* Empieza nodo:448 / Elemento padre: 447   */
      v.add(doc.createElement("td"));
      ((Element)v.get(447)).appendChild((Element)v.get(448));

      /* Empieza nodo:449 / Elemento padre: 448   */
      v.add(doc.createElement("table"));
      ((Element)v.get(449)).setAttribute("width","100%" );
      ((Element)v.get(449)).setAttribute("align","left" );
      ((Element)v.get(449)).setAttribute("border","0" );
      ((Element)v.get(449)).setAttribute("cellspacing","0" );
      ((Element)v.get(449)).setAttribute("cellpadding","0" );
      ((Element)v.get(448)).appendChild((Element)v.get(449));

      /* Empieza nodo:450 / Elemento padre: 449   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(449)).appendChild((Element)v.get(450));

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
      v.add(doc.createElement("legend"));
      ((Element)v.get(455)).setAttribute("class","legend" );
      ((Element)v.get(454)).appendChild((Element)v.get(455));

      /* Empieza nodo:456 / Elemento padre: 455   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(456)).setAttribute("nombre","lblDatosPago" );
      ((Element)v.get(456)).setAttribute("alto","13" );
      ((Element)v.get(456)).setAttribute("filas","1" );
      ((Element)v.get(456)).setAttribute("valor","" );
      ((Element)v.get(456)).setAttribute("id","legend" );
      ((Element)v.get(456)).setAttribute("cod","00224" );
      ((Element)v.get(455)).appendChild((Element)v.get(456));
      /* Termina nodo:456   */
      /* Termina nodo:455   */

      /* Empieza nodo:457 / Elemento padre: 454   */
      v.add(doc.createElement("table"));
      ((Element)v.get(457)).setAttribute("width","100%" );
      ((Element)v.get(457)).setAttribute("border","0" );
      ((Element)v.get(457)).setAttribute("align","center" );
      ((Element)v.get(457)).setAttribute("cellspacing","0" );
      ((Element)v.get(457)).setAttribute("cellpadding","0" );
      ((Element)v.get(454)).appendChild((Element)v.get(457));

      /* Empieza nodo:458 / Elemento padre: 457   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(457)).appendChild((Element)v.get(458));

      /* Empieza nodo:459 / Elemento padre: 458   */
      v.add(doc.createElement("td"));
      ((Element)v.get(458)).appendChild((Element)v.get(459));

      /* Empieza nodo:460 / Elemento padre: 459   */
      v.add(doc.createElement("table"));
      ((Element)v.get(460)).setAttribute("width","699" );
      ((Element)v.get(460)).setAttribute("border","0" );
      ((Element)v.get(460)).setAttribute("align","left" );
      ((Element)v.get(460)).setAttribute("cellspacing","0" );
      ((Element)v.get(460)).setAttribute("cellpadding","0" );
      ((Element)v.get(459)).appendChild((Element)v.get(460));

      /* Empieza nodo:461 / Elemento padre: 460   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(460)).appendChild((Element)v.get(461));

      /* Empieza nodo:462 / Elemento padre: 461   */
      v.add(doc.createElement("td"));
      ((Element)v.get(462)).setAttribute("colspan","4" );
   }

   private void getXML2070(Document doc) {
      ((Element)v.get(461)).appendChild((Element)v.get(462));

      /* Empieza nodo:463 / Elemento padre: 462   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(463)).setAttribute("src","b.gif" );
      ((Element)v.get(463)).setAttribute("width","8" );
      ((Element)v.get(463)).setAttribute("height","8" );
      ((Element)v.get(462)).appendChild((Element)v.get(463));
      /* Termina nodo:463   */
      /* Termina nodo:462   */
      /* Termina nodo:461   */

      /* Empieza nodo:464 / Elemento padre: 460   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(460)).appendChild((Element)v.get(464));

      /* Empieza nodo:465 / Elemento padre: 464   */
      v.add(doc.createElement("td"));
      ((Element)v.get(464)).appendChild((Element)v.get(465));

      /* Empieza nodo:466 / Elemento padre: 465   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(466)).setAttribute("src","b.gif" );
      ((Element)v.get(466)).setAttribute("width","8" );
      ((Element)v.get(466)).setAttribute("height","8" );
      ((Element)v.get(465)).appendChild((Element)v.get(466));
      /* Termina nodo:466   */
      /* Termina nodo:465   */

      /* Empieza nodo:467 / Elemento padre: 464   */
      v.add(doc.createElement("td"));
      ((Element)v.get(464)).appendChild((Element)v.get(467));

      /* Empieza nodo:468 / Elemento padre: 467   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(468)).setAttribute("nombre","lblNumPago" );
      ((Element)v.get(468)).setAttribute("alto","13" );
      ((Element)v.get(468)).setAttribute("filas","1" );
      ((Element)v.get(468)).setAttribute("valor","" );
      ((Element)v.get(468)).setAttribute("id","datosTitle" );
      ((Element)v.get(468)).setAttribute("cod","1841" );
      ((Element)v.get(467)).appendChild((Element)v.get(468));
      /* Termina nodo:468   */
      /* Termina nodo:467   */

      /* Empieza nodo:469 / Elemento padre: 464   */
      v.add(doc.createElement("td"));
      ((Element)v.get(464)).appendChild((Element)v.get(469));

      /* Empieza nodo:470 / Elemento padre: 469   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(470)).setAttribute("src","b.gif" );
      ((Element)v.get(470)).setAttribute("width","25" );
      ((Element)v.get(470)).setAttribute("height","8" );
      ((Element)v.get(469)).appendChild((Element)v.get(470));
      /* Termina nodo:470   */
      /* Termina nodo:469   */

      /* Empieza nodo:471 / Elemento padre: 464   */
      v.add(doc.createElement("td"));
      ((Element)v.get(471)).setAttribute("colspan","4" );
      ((Element)v.get(464)).appendChild((Element)v.get(471));

      /* Empieza nodo:472 / Elemento padre: 471   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(472)).setAttribute("nombre","lblPremio" );
      ((Element)v.get(472)).setAttribute("alto","13" );
      ((Element)v.get(472)).setAttribute("filas","1" );
      ((Element)v.get(472)).setAttribute("valor","" );
      ((Element)v.get(472)).setAttribute("id","datosTitle" );
      ((Element)v.get(472)).setAttribute("cod","1784" );
      ((Element)v.get(471)).appendChild((Element)v.get(472));
      /* Termina nodo:472   */
      /* Termina nodo:471   */

      /* Empieza nodo:473 / Elemento padre: 464   */
      v.add(doc.createElement("td"));
      ((Element)v.get(464)).appendChild((Element)v.get(473));

      /* Empieza nodo:474 / Elemento padre: 473   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(474)).setAttribute("src","b.gif" );
      ((Element)v.get(474)).setAttribute("width","25" );
      ((Element)v.get(474)).setAttribute("height","8" );
      ((Element)v.get(473)).appendChild((Element)v.get(474));
      /* Termina nodo:474   */
      /* Termina nodo:473   */

      /* Empieza nodo:475 / Elemento padre: 464   */
      v.add(doc.createElement("td"));
      ((Element)v.get(464)).appendChild((Element)v.get(475));

      /* Empieza nodo:476 / Elemento padre: 475   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(476)).setAttribute("nombre","lblPeriodoControl" );
      ((Element)v.get(476)).setAttribute("alto","13" );
      ((Element)v.get(476)).setAttribute("filas","1" );
      ((Element)v.get(476)).setAttribute("valor","" );
      ((Element)v.get(476)).setAttribute("id","datosTitle" );
      ((Element)v.get(476)).setAttribute("cod","1842" );
      ((Element)v.get(475)).appendChild((Element)v.get(476));
      /* Termina nodo:476   */
      /* Termina nodo:475   */

      /* Empieza nodo:477 / Elemento padre: 464   */
      v.add(doc.createElement("td"));
      ((Element)v.get(477)).setAttribute("width","100%" );
      ((Element)v.get(464)).appendChild((Element)v.get(477));

      /* Empieza nodo:478 / Elemento padre: 477   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(478)).setAttribute("src","b.gif" );
      ((Element)v.get(478)).setAttribute("width","8" );
      ((Element)v.get(478)).setAttribute("height","8" );
      ((Element)v.get(477)).appendChild((Element)v.get(478));
      /* Termina nodo:478   */
      /* Termina nodo:477   */
      /* Termina nodo:464   */

      /* Empieza nodo:479 / Elemento padre: 460   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(460)).appendChild((Element)v.get(479));

      /* Empieza nodo:480 / Elemento padre: 479   */
      v.add(doc.createElement("td"));
      ((Element)v.get(479)).appendChild((Element)v.get(480));

      /* Empieza nodo:481 / Elemento padre: 480   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(481)).setAttribute("src","b.gif" );
      ((Element)v.get(481)).setAttribute("width","8" );
      ((Element)v.get(481)).setAttribute("height","8" );
      ((Element)v.get(480)).appendChild((Element)v.get(481));
      /* Termina nodo:481   */
      /* Termina nodo:480   */

      /* Empieza nodo:482 / Elemento padre: 479   */
      v.add(doc.createElement("td"));
      ((Element)v.get(482)).setAttribute("valign","bottom" );
      ((Element)v.get(479)).appendChild((Element)v.get(482));

      /* Empieza nodo:483 / Elemento padre: 482   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(483)).setAttribute("nombre","lbNPago" );
      ((Element)v.get(483)).setAttribute("alto","13" );
      ((Element)v.get(483)).setAttribute("filas","1" );
      ((Element)v.get(483)).setAttribute("valor","" );
      ((Element)v.get(483)).setAttribute("id","datosCampos" );
      ((Element)v.get(482)).appendChild((Element)v.get(483));
      /* Termina nodo:483   */
      /* Termina nodo:482   */

      /* Empieza nodo:484 / Elemento padre: 479   */
      v.add(doc.createElement("td"));
      ((Element)v.get(479)).appendChild((Element)v.get(484));

      /* Empieza nodo:485 / Elemento padre: 484   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML2160(Document doc) {
      ((Element)v.get(485)).setAttribute("src","b.gif" );
      ((Element)v.get(485)).setAttribute("width","25" );
      ((Element)v.get(485)).setAttribute("height","8" );
      ((Element)v.get(484)).appendChild((Element)v.get(485));
      /* Termina nodo:485   */
      /* Termina nodo:484   */

      /* Empieza nodo:486 / Elemento padre: 479   */
      v.add(doc.createElement("td"));
      ((Element)v.get(486)).setAttribute("valign","bottom" );
      ((Element)v.get(486)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(479)).appendChild((Element)v.get(486));

      /* Empieza nodo:487 / Elemento padre: 486   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(487)).setAttribute("nombre","txtPremio" );
      ((Element)v.get(487)).setAttribute("id","datosCampos" );
      ((Element)v.get(487)).setAttribute("max","6" );
      ((Element)v.get(487)).setAttribute("tipo","" );
      ((Element)v.get(487)).setAttribute("onchange","" );
      ((Element)v.get(487)).setAttribute("req","N" );
      ((Element)v.get(487)).setAttribute("size","6" );
      ((Element)v.get(487)).setAttribute("valor","" );
      ((Element)v.get(487)).setAttribute("validacion","" );
      ((Element)v.get(486)).appendChild((Element)v.get(487));
      /* Termina nodo:487   */
      /* Termina nodo:486   */

      /* Empieza nodo:488 / Elemento padre: 479   */
      v.add(doc.createElement("td"));
      ((Element)v.get(488)).setAttribute("valign","bottom" );
      ((Element)v.get(479)).appendChild((Element)v.get(488));

      /* Empieza nodo:489 / Elemento padre: 488   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(489)).setAttribute("nombre","lbPremio" );
      ((Element)v.get(489)).setAttribute("alto","13" );
      ((Element)v.get(489)).setAttribute("filas","1" );
      ((Element)v.get(489)).setAttribute("valor","" );
      ((Element)v.get(489)).setAttribute("id","datosCampos" );
      ((Element)v.get(489)).setAttribute("cod","1380" );
      ((Element)v.get(488)).appendChild((Element)v.get(489));
      /* Termina nodo:489   */
      /* Termina nodo:488   */

      /* Empieza nodo:490 / Elemento padre: 479   */
      v.add(doc.createElement("td"));
      ((Element)v.get(479)).appendChild((Element)v.get(490));

      /* Empieza nodo:491 / Elemento padre: 490   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(491)).setAttribute("src","b.gif" );
      ((Element)v.get(491)).setAttribute("width","4" );
      ((Element)v.get(491)).setAttribute("height","8" );
      ((Element)v.get(490)).appendChild((Element)v.get(491));
      /* Termina nodo:491   */
      /* Termina nodo:490   */

      /* Empieza nodo:492 / Elemento padre: 479   */
      v.add(doc.createElement("td"));
      ((Element)v.get(479)).appendChild((Element)v.get(492));

      /* Empieza nodo:493 / Elemento padre: 492   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(493)).setAttribute("src","iconorequerido.gif" );
      ((Element)v.get(492)).appendChild((Element)v.get(493));
      /* Termina nodo:493   */
      /* Termina nodo:492   */

      /* Empieza nodo:494 / Elemento padre: 479   */
      v.add(doc.createElement("td"));
      ((Element)v.get(479)).appendChild((Element)v.get(494));

      /* Empieza nodo:495 / Elemento padre: 494   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(495)).setAttribute("src","b.gif" );
      ((Element)v.get(495)).setAttribute("width","25" );
      ((Element)v.get(495)).setAttribute("height","8" );
      ((Element)v.get(494)).appendChild((Element)v.get(495));
      /* Termina nodo:495   */
      /* Termina nodo:494   */

      /* Empieza nodo:496 / Elemento padre: 479   */
      v.add(doc.createElement("td"));
      ((Element)v.get(496)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(479)).appendChild((Element)v.get(496));

      /* Empieza nodo:497 / Elemento padre: 496   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(497)).setAttribute("nombre","cbPeriodoControl" );
      ((Element)v.get(497)).setAttribute("id","datosCampos" );
      ((Element)v.get(497)).setAttribute("size","1" );
      ((Element)v.get(497)).setAttribute("multiple","N" );
      ((Element)v.get(497)).setAttribute("req","S" );
      ((Element)v.get(497)).setAttribute("valorinicial","" );
      ((Element)v.get(497)).setAttribute("textoinicial","" );
      ((Element)v.get(496)).appendChild((Element)v.get(497));

      /* Empieza nodo:498 / Elemento padre: 497   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(497)).appendChild((Element)v.get(498));
      /* Termina nodo:498   */
      /* Termina nodo:497   */
      /* Termina nodo:496   */

      /* Empieza nodo:499 / Elemento padre: 479   */
      v.add(doc.createElement("td"));
      ((Element)v.get(499)).setAttribute("width","100%" );
      ((Element)v.get(479)).appendChild((Element)v.get(499));

      /* Empieza nodo:500 / Elemento padre: 499   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(500)).setAttribute("src","b.gif" );
      ((Element)v.get(500)).setAttribute("width","8" );
      ((Element)v.get(500)).setAttribute("height","8" );
      ((Element)v.get(499)).appendChild((Element)v.get(500));
      /* Termina nodo:500   */
      /* Termina nodo:499   */
      /* Termina nodo:479   */

      /* Empieza nodo:501 / Elemento padre: 460   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(460)).appendChild((Element)v.get(501));

      /* Empieza nodo:502 / Elemento padre: 501   */
      v.add(doc.createElement("td"));
      ((Element)v.get(502)).setAttribute("colspan","4" );
      ((Element)v.get(501)).appendChild((Element)v.get(502));

      /* Empieza nodo:503 / Elemento padre: 502   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(503)).setAttribute("src","b.gif" );
      ((Element)v.get(503)).setAttribute("width","8" );
      ((Element)v.get(503)).setAttribute("height","8" );
      ((Element)v.get(502)).appendChild((Element)v.get(503));
      /* Termina nodo:503   */
      /* Termina nodo:502   */
      /* Termina nodo:501   */
      /* Termina nodo:460   */
      /* Termina nodo:459   */
      /* Termina nodo:458   */
      /* Termina nodo:457   */
      /* Termina nodo:454   */
      /* Termina nodo:453   */

      /* Empieza nodo:504 / Elemento padre: 450   */
      v.add(doc.createElement("td"));
      ((Element)v.get(450)).appendChild((Element)v.get(504));

      /* Empieza nodo:505 / Elemento padre: 504   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(505)).setAttribute("src","b.gif" );
      ((Element)v.get(504)).appendChild((Element)v.get(505));
      /* Termina nodo:505   */
      /* Termina nodo:504   */
      /* Termina nodo:450   */

      /* Empieza nodo:506 / Elemento padre: 449   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(449)).appendChild((Element)v.get(506));

      /* Empieza nodo:507 / Elemento padre: 506   */
      v.add(doc.createElement("td"));
      ((Element)v.get(506)).appendChild((Element)v.get(507));

      /* Empieza nodo:508 / Elemento padre: 507   */
   }

   private void getXML2250(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(508)).setAttribute("src","b.gif" );
      ((Element)v.get(507)).appendChild((Element)v.get(508));
      /* Termina nodo:508   */
      /* Termina nodo:507   */

      /* Empieza nodo:509 / Elemento padre: 506   */
      v.add(doc.createElement("td"));
      ((Element)v.get(506)).appendChild((Element)v.get(509));

      /* Empieza nodo:510 / Elemento padre: 509   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(509)).appendChild((Element)v.get(510));

      /* Empieza nodo:511 / Elemento padre: 510   */
      v.add(doc.createElement("table"));
      ((Element)v.get(511)).setAttribute("width","100%" );
      ((Element)v.get(511)).setAttribute("border","0" );
      ((Element)v.get(511)).setAttribute("align","center" );
      ((Element)v.get(511)).setAttribute("cellspacing","0" );
      ((Element)v.get(511)).setAttribute("cellpadding","0" );
      ((Element)v.get(510)).appendChild((Element)v.get(511));

      /* Empieza nodo:512 / Elemento padre: 511   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(511)).appendChild((Element)v.get(512));

      /* Empieza nodo:513 / Elemento padre: 512   */
      v.add(doc.createElement("td"));
      ((Element)v.get(513)).setAttribute("class","botonera" );
      ((Element)v.get(512)).appendChild((Element)v.get(513));

      /* Empieza nodo:514 / Elemento padre: 513   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(514)).setAttribute("nombre","btnAnadir" );
      ((Element)v.get(514)).setAttribute("ID","botonContenido" );
      ((Element)v.get(514)).setAttribute("tipo","html" );
      ((Element)v.get(514)).setAttribute("accion","accionAniadirPagoMonetario();" );
      ((Element)v.get(514)).setAttribute("estado","false" );
      ((Element)v.get(514)).setAttribute("cod","404" );
      ((Element)v.get(513)).appendChild((Element)v.get(514));
      /* Termina nodo:514   */
      /* Termina nodo:513   */
      /* Termina nodo:512   */
      /* Termina nodo:511   */
      /* Termina nodo:510   */
      /* Termina nodo:509   */

      /* Empieza nodo:515 / Elemento padre: 506   */
      v.add(doc.createElement("td"));
      ((Element)v.get(506)).appendChild((Element)v.get(515));

      /* Empieza nodo:516 / Elemento padre: 515   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(516)).setAttribute("src","b.gif" );
      ((Element)v.get(516)).setAttribute("width","8" );
      ((Element)v.get(516)).setAttribute("height","12" );
      ((Element)v.get(515)).appendChild((Element)v.get(516));
      /* Termina nodo:516   */
      /* Termina nodo:515   */
      /* Termina nodo:506   */

      /* Empieza nodo:517 / Elemento padre: 449   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(449)).appendChild((Element)v.get(517));

      /* Empieza nodo:518 / Elemento padre: 517   */
      v.add(doc.createElement("td"));
      ((Element)v.get(518)).setAttribute("width","12" );
      ((Element)v.get(518)).setAttribute("align","center" );
      ((Element)v.get(517)).appendChild((Element)v.get(518));

      /* Empieza nodo:519 / Elemento padre: 518   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(519)).setAttribute("src","b.gif" );
      ((Element)v.get(519)).setAttribute("width","12" );
      ((Element)v.get(519)).setAttribute("height","342" );
      ((Element)v.get(518)).appendChild((Element)v.get(519));
      /* Termina nodo:519   */
      /* Termina nodo:518   */

      /* Empieza nodo:520 / Elemento padre: 517   */
      v.add(doc.createElement("td"));
      ((Element)v.get(520)).setAttribute("width","756" );
      ((Element)v.get(517)).appendChild((Element)v.get(520));

      /* Empieza nodo:521 / Elemento padre: 520   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(521)).setAttribute("src","b.gif" );
      ((Element)v.get(520)).appendChild((Element)v.get(521));
      /* Termina nodo:521   */
      /* Termina nodo:520   */

      /* Empieza nodo:522 / Elemento padre: 517   */
      v.add(doc.createElement("td"));
      ((Element)v.get(522)).setAttribute("width","12" );
      ((Element)v.get(517)).appendChild((Element)v.get(522));

      /* Empieza nodo:523 / Elemento padre: 522   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(523)).setAttribute("src","b.gif" );
      ((Element)v.get(523)).setAttribute("width","12" );
      ((Element)v.get(523)).setAttribute("height","1" );
      ((Element)v.get(522)).appendChild((Element)v.get(523));
      /* Termina nodo:523   */
      /* Termina nodo:522   */
      /* Termina nodo:517   */
      /* Termina nodo:449   */
      /* Termina nodo:448   */
      /* Termina nodo:447   */
      /* Termina nodo:406   */
      /* Termina nodo:403   */
      /* Termina nodo:402   */

      /* Empieza nodo:524 / Elemento padre: 399   */
      v.add(doc.createElement("td"));
      ((Element)v.get(399)).appendChild((Element)v.get(524));

      /* Empieza nodo:525 / Elemento padre: 524   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(525)).setAttribute("src","b.gif" );
      ((Element)v.get(524)).appendChild((Element)v.get(525));
      /* Termina nodo:525   */
      /* Termina nodo:524   */
      /* Termina nodo:399   */

      /* Empieza nodo:526 / Elemento padre: 391   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(391)).appendChild((Element)v.get(526));

      /* Empieza nodo:527 / Elemento padre: 526   */
      v.add(doc.createElement("td"));
      ((Element)v.get(526)).appendChild((Element)v.get(527));

      /* Empieza nodo:528 / Elemento padre: 527   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(528)).setAttribute("src","b.gif" );
      ((Element)v.get(527)).appendChild((Element)v.get(528));
      /* Termina nodo:528   */
      /* Termina nodo:527   */

      /* Empieza nodo:529 / Elemento padre: 526   */
      v.add(doc.createElement("td"));
      ((Element)v.get(526)).appendChild((Element)v.get(529));

      /* Empieza nodo:530 / Elemento padre: 529   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(529)).appendChild((Element)v.get(530));

      /* Empieza nodo:531 / Elemento padre: 530   */
      v.add(doc.createElement("table"));
      ((Element)v.get(531)).setAttribute("width","100%" );
      ((Element)v.get(531)).setAttribute("border","0" );
      ((Element)v.get(531)).setAttribute("align","center" );
      ((Element)v.get(531)).setAttribute("cellspacing","0" );
      ((Element)v.get(531)).setAttribute("cellpadding","0" );
      ((Element)v.get(530)).appendChild((Element)v.get(531));

      /* Empieza nodo:532 / Elemento padre: 531   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(531)).appendChild((Element)v.get(532));

      /* Empieza nodo:533 / Elemento padre: 532   */
      v.add(doc.createElement("td"));
      ((Element)v.get(533)).setAttribute("class","botonera" );
      ((Element)v.get(532)).appendChild((Element)v.get(533));

      /* Empieza nodo:534 / Elemento padre: 533   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(534)).setAttribute("nombre","btnAceptar2" );
      ((Element)v.get(534)).setAttribute("ID","botonContenido" );
   }

   private void getXML2340(Document doc) {
      ((Element)v.get(534)).setAttribute("tipo","html" );
      ((Element)v.get(534)).setAttribute("accion","accionAceptar(get('formulario.OID_TIPO_PREMIO_MONETARIO'));" );
      ((Element)v.get(534)).setAttribute("estado","false" );
      ((Element)v.get(534)).setAttribute("cod","12" );
      ((Element)v.get(533)).appendChild((Element)v.get(534));
      /* Termina nodo:534   */
      /* Termina nodo:533   */
      /* Termina nodo:532   */
      /* Termina nodo:531   */
      /* Termina nodo:530   */
      /* Termina nodo:529   */

      /* Empieza nodo:535 / Elemento padre: 526   */
      v.add(doc.createElement("td"));
      ((Element)v.get(526)).appendChild((Element)v.get(535));

      /* Empieza nodo:536 / Elemento padre: 535   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(536)).setAttribute("src","b.gif" );
      ((Element)v.get(536)).setAttribute("width","8" );
      ((Element)v.get(536)).setAttribute("height","12" );
      ((Element)v.get(535)).appendChild((Element)v.get(536));
      /* Termina nodo:536   */
      /* Termina nodo:535   */
      /* Termina nodo:526   */

      /* Empieza nodo:537 / Elemento padre: 391   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(391)).appendChild((Element)v.get(537));

      /* Empieza nodo:538 / Elemento padre: 537   */
      v.add(doc.createElement("td"));
      ((Element)v.get(538)).setAttribute("width","12" );
      ((Element)v.get(538)).setAttribute("align","center" );
      ((Element)v.get(537)).appendChild((Element)v.get(538));

      /* Empieza nodo:539 / Elemento padre: 538   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(539)).setAttribute("src","b.gif" );
      ((Element)v.get(539)).setAttribute("width","12" );
      ((Element)v.get(539)).setAttribute("height","12" );
      ((Element)v.get(538)).appendChild((Element)v.get(539));
      /* Termina nodo:539   */
      /* Termina nodo:538   */

      /* Empieza nodo:540 / Elemento padre: 537   */
      v.add(doc.createElement("td"));
      ((Element)v.get(540)).setAttribute("width","756" );
      ((Element)v.get(537)).appendChild((Element)v.get(540));

      /* Empieza nodo:541 / Elemento padre: 540   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(541)).setAttribute("src","b.gif" );
      ((Element)v.get(540)).appendChild((Element)v.get(541));
      /* Termina nodo:541   */
      /* Termina nodo:540   */

      /* Empieza nodo:542 / Elemento padre: 537   */
      v.add(doc.createElement("td"));
      ((Element)v.get(542)).setAttribute("width","12" );
      ((Element)v.get(537)).appendChild((Element)v.get(542));

      /* Empieza nodo:543 / Elemento padre: 542   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(543)).setAttribute("src","b.gif" );
      ((Element)v.get(543)).setAttribute("width","12" );
      ((Element)v.get(543)).setAttribute("height","1" );
      ((Element)v.get(542)).appendChild((Element)v.get(543));
      /* Termina nodo:543   */
      /* Termina nodo:542   */
      /* Termina nodo:537   */
      /* Termina nodo:391   */
      /* Termina nodo:390   */

      /* Empieza nodo:544 / Elemento padre: 36   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(544)).setAttribute("nombre","capa4" );
      ((Element)v.get(544)).setAttribute("alto","1020" );
      ((Element)v.get(544)).setAttribute("ancho","100%" );
      ((Element)v.get(544)).setAttribute("colorf","" );
      ((Element)v.get(544)).setAttribute("borde","0" );
      ((Element)v.get(544)).setAttribute("imagenf","" );
      ((Element)v.get(544)).setAttribute("repeat","" );
      ((Element)v.get(544)).setAttribute("padding","" );
      ((Element)v.get(544)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(544)).setAttribute("contravsb","" );
      ((Element)v.get(544)).setAttribute("x","0" );
      ((Element)v.get(544)).setAttribute("y","341" );
      ((Element)v.get(544)).setAttribute("zindex","" );
      ((Element)v.get(36)).appendChild((Element)v.get(544));

      /* Empieza nodo:545 / Elemento padre: 544   */
      v.add(doc.createElement("table"));
      ((Element)v.get(545)).setAttribute("width","100%" );
      ((Element)v.get(545)).setAttribute("border","0" );
      ((Element)v.get(545)).setAttribute("cellspacing","0" );
      ((Element)v.get(545)).setAttribute("cellpadding","0" );
      ((Element)v.get(544)).appendChild((Element)v.get(545));

      /* Empieza nodo:546 / Elemento padre: 545   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(545)).appendChild((Element)v.get(546));

      /* Empieza nodo:547 / Elemento padre: 546   */
      v.add(doc.createElement("td"));
      ((Element)v.get(547)).setAttribute("width","12" );
      ((Element)v.get(547)).setAttribute("align","center" );
      ((Element)v.get(546)).appendChild((Element)v.get(547));

      /* Empieza nodo:548 / Elemento padre: 547   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(548)).setAttribute("src","b.gif" );
      ((Element)v.get(548)).setAttribute("width","12" );
      ((Element)v.get(548)).setAttribute("height","12" );
      ((Element)v.get(547)).appendChild((Element)v.get(548));
      /* Termina nodo:548   */
      /* Termina nodo:547   */

      /* Empieza nodo:549 / Elemento padre: 546   */
      v.add(doc.createElement("td"));
      ((Element)v.get(549)).setAttribute("width","750" );
      ((Element)v.get(546)).appendChild((Element)v.get(549));

      /* Empieza nodo:550 / Elemento padre: 549   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(550)).setAttribute("src","b.gif" );
      ((Element)v.get(549)).appendChild((Element)v.get(550));
      /* Termina nodo:550   */
      /* Termina nodo:549   */

      /* Empieza nodo:551 / Elemento padre: 546   */
      v.add(doc.createElement("td"));
      ((Element)v.get(551)).setAttribute("width","12" );
      ((Element)v.get(546)).appendChild((Element)v.get(551));

      /* Empieza nodo:552 / Elemento padre: 551   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(552)).setAttribute("src","b.gif" );
      ((Element)v.get(552)).setAttribute("width","12" );
      ((Element)v.get(552)).setAttribute("height","1" );
      ((Element)v.get(551)).appendChild((Element)v.get(552));
      /* Termina nodo:552   */
      /* Termina nodo:551   */
      /* Termina nodo:546   */

      /* Empieza nodo:553 / Elemento padre: 545   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(545)).appendChild((Element)v.get(553));

      /* Empieza nodo:554 / Elemento padre: 553   */
      v.add(doc.createElement("td"));
      ((Element)v.get(553)).appendChild((Element)v.get(554));

      /* Empieza nodo:555 / Elemento padre: 554   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(555)).setAttribute("src","b.gif" );
      ((Element)v.get(554)).appendChild((Element)v.get(555));
      /* Termina nodo:555   */
      /* Termina nodo:554   */

      /* Empieza nodo:556 / Elemento padre: 553   */
   }

   private void getXML2430(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(553)).appendChild((Element)v.get(556));

      /* Empieza nodo:557 / Elemento padre: 556   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(556)).appendChild((Element)v.get(557));

      /* Empieza nodo:558 / Elemento padre: 557   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(558)).setAttribute("class","legend" );
      ((Element)v.get(557)).appendChild((Element)v.get(558));

      /* Empieza nodo:559 / Elemento padre: 558   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(559)).setAttribute("nombre","lblDatosPremiosArticulos4" );
      ((Element)v.get(559)).setAttribute("alto","13" );
      ((Element)v.get(559)).setAttribute("filas","1" );
      ((Element)v.get(559)).setAttribute("valor","" );
      ((Element)v.get(559)).setAttribute("id","legend" );
      ((Element)v.get(559)).setAttribute("cod","00352" );
      ((Element)v.get(558)).appendChild((Element)v.get(559));
      /* Termina nodo:559   */
      /* Termina nodo:558   */

      /* Empieza nodo:560 / Elemento padre: 557   */
      v.add(doc.createElement("table"));
      ((Element)v.get(560)).setAttribute("width","100%" );
      ((Element)v.get(560)).setAttribute("border","0" );
      ((Element)v.get(560)).setAttribute("align","center" );
      ((Element)v.get(560)).setAttribute("cellspacing","0" );
      ((Element)v.get(560)).setAttribute("cellpadding","0" );
      ((Element)v.get(557)).appendChild((Element)v.get(560));

      /* Empieza nodo:561 / Elemento padre: 560   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(560)).appendChild((Element)v.get(561));

      /* Empieza nodo:562 / Elemento padre: 561   */
      v.add(doc.createElement("td"));
      ((Element)v.get(562)).setAttribute("width","12" );
      ((Element)v.get(562)).setAttribute("align","center" );
      ((Element)v.get(561)).appendChild((Element)v.get(562));

      /* Empieza nodo:563 / Elemento padre: 562   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(563)).setAttribute("src","b.gif" );
      ((Element)v.get(563)).setAttribute("width","12" );
      ((Element)v.get(563)).setAttribute("height","12" );
      ((Element)v.get(562)).appendChild((Element)v.get(563));
      /* Termina nodo:563   */
      /* Termina nodo:562   */

      /* Empieza nodo:564 / Elemento padre: 561   */
      v.add(doc.createElement("td"));
      ((Element)v.get(564)).setAttribute("width","750" );
      ((Element)v.get(561)).appendChild((Element)v.get(564));

      /* Empieza nodo:565 / Elemento padre: 564   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(565)).setAttribute("src","b.gif" );
      ((Element)v.get(564)).appendChild((Element)v.get(565));
      /* Termina nodo:565   */
      /* Termina nodo:564   */

      /* Empieza nodo:566 / Elemento padre: 561   */
      v.add(doc.createElement("td"));
      ((Element)v.get(566)).setAttribute("width","12" );
      ((Element)v.get(561)).appendChild((Element)v.get(566));

      /* Empieza nodo:567 / Elemento padre: 566   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(567)).setAttribute("src","b.gif" );
      ((Element)v.get(567)).setAttribute("width","12" );
      ((Element)v.get(567)).setAttribute("height","1" );
      ((Element)v.get(566)).appendChild((Element)v.get(567));
      /* Termina nodo:567   */
      /* Termina nodo:566   */
      /* Termina nodo:561   */

      /* Empieza nodo:568 / Elemento padre: 560   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(560)).appendChild((Element)v.get(568));

      /* Empieza nodo:569 / Elemento padre: 568   */
      v.add(doc.createElement("td"));
      ((Element)v.get(569)).setAttribute("colspan","3" );
      ((Element)v.get(568)).appendChild((Element)v.get(569));

      /* Empieza nodo:570 / Elemento padre: 569   */
      v.add(doc.createElement("table"));
      ((Element)v.get(570)).setAttribute("width","728" );
      ((Element)v.get(570)).setAttribute("border","0" );
      ((Element)v.get(570)).setAttribute("align","left" );
      ((Element)v.get(570)).setAttribute("cellspacing","0" );
      ((Element)v.get(570)).setAttribute("cellpadding","0" );
      ((Element)v.get(569)).appendChild((Element)v.get(570));

      /* Empieza nodo:571 / Elemento padre: 570   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(570)).appendChild((Element)v.get(571));

      /* Empieza nodo:572 / Elemento padre: 571   */
      v.add(doc.createElement("td"));
      ((Element)v.get(572)).setAttribute("colspan","4" );
      ((Element)v.get(571)).appendChild((Element)v.get(572));

      /* Empieza nodo:573 / Elemento padre: 572   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(573)).setAttribute("src","b.gif" );
      ((Element)v.get(573)).setAttribute("width","8" );
      ((Element)v.get(573)).setAttribute("height","309" );
      ((Element)v.get(572)).appendChild((Element)v.get(573));
      /* Termina nodo:573   */
      /* Termina nodo:572   */
      /* Termina nodo:571   */
      /* Termina nodo:570   */
      /* Termina nodo:569   */
      /* Termina nodo:568   */

      /* Empieza nodo:574 / Elemento padre: 560   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(560)).appendChild((Element)v.get(574));

      /* Empieza nodo:575 / Elemento padre: 574   */
      v.add(doc.createElement("td"));
      ((Element)v.get(574)).appendChild((Element)v.get(575));

      /* Empieza nodo:576 / Elemento padre: 575   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(576)).setAttribute("src","b.gif" );
      ((Element)v.get(575)).appendChild((Element)v.get(576));
      /* Termina nodo:576   */
      /* Termina nodo:575   */

      /* Empieza nodo:577 / Elemento padre: 574   */
      v.add(doc.createElement("td"));
      ((Element)v.get(574)).appendChild((Element)v.get(577));

      /* Empieza nodo:578 / Elemento padre: 577   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(577)).appendChild((Element)v.get(578));

      /* Empieza nodo:579 / Elemento padre: 578   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(579)).setAttribute("class","legend" );
      ((Element)v.get(578)).appendChild((Element)v.get(579));

      /* Empieza nodo:580 / Elemento padre: 579   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(580)).setAttribute("nombre","lblDatosLote" );
      ((Element)v.get(580)).setAttribute("alto","13" );
      ((Element)v.get(580)).setAttribute("filas","1" );
      ((Element)v.get(580)).setAttribute("valor","Datos del lote" );
      ((Element)v.get(580)).setAttribute("id","legend" );
      ((Element)v.get(580)).setAttribute("cod","00593" );
   }

   private void getXML2520(Document doc) {
      ((Element)v.get(579)).appendChild((Element)v.get(580));
      /* Termina nodo:580   */
      /* Termina nodo:579   */

      /* Empieza nodo:581 / Elemento padre: 578   */
      v.add(doc.createElement("table"));
      ((Element)v.get(581)).setAttribute("width","100%" );
      ((Element)v.get(581)).setAttribute("border","0" );
      ((Element)v.get(581)).setAttribute("align","center" );
      ((Element)v.get(581)).setAttribute("cellspacing","0" );
      ((Element)v.get(581)).setAttribute("cellpadding","0" );
      ((Element)v.get(578)).appendChild((Element)v.get(581));

      /* Empieza nodo:582 / Elemento padre: 581   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(581)).appendChild((Element)v.get(582));

      /* Empieza nodo:583 / Elemento padre: 582   */
      v.add(doc.createElement("td"));
      ((Element)v.get(582)).appendChild((Element)v.get(583));

      /* Empieza nodo:584 / Elemento padre: 583   */
      v.add(doc.createElement("table"));
      ((Element)v.get(584)).setAttribute("width","100%" );
      ((Element)v.get(584)).setAttribute("align","left" );
      ((Element)v.get(584)).setAttribute("border","0" );
      ((Element)v.get(584)).setAttribute("cellspacing","0" );
      ((Element)v.get(584)).setAttribute("cellpadding","0" );
      ((Element)v.get(583)).appendChild((Element)v.get(584));

      /* Empieza nodo:585 / Elemento padre: 584   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(584)).appendChild((Element)v.get(585));

      /* Empieza nodo:586 / Elemento padre: 585   */
      v.add(doc.createElement("td"));
      ((Element)v.get(586)).setAttribute("colspan","4" );
      ((Element)v.get(585)).appendChild((Element)v.get(586));

      /* Empieza nodo:587 / Elemento padre: 586   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(587)).setAttribute("src","b.gif" );
      ((Element)v.get(587)).setAttribute("width","8" );
      ((Element)v.get(587)).setAttribute("height","8" );
      ((Element)v.get(586)).appendChild((Element)v.get(587));
      /* Termina nodo:587   */
      /* Termina nodo:586   */
      /* Termina nodo:585   */

      /* Empieza nodo:588 / Elemento padre: 584   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(584)).appendChild((Element)v.get(588));

      /* Empieza nodo:589 / Elemento padre: 588   */
      v.add(doc.createElement("td"));
      ((Element)v.get(588)).appendChild((Element)v.get(589));

      /* Empieza nodo:590 / Elemento padre: 589   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(590)).setAttribute("src","b.gif" );
      ((Element)v.get(589)).appendChild((Element)v.get(590));
      /* Termina nodo:590   */
      /* Termina nodo:589   */

      /* Empieza nodo:591 / Elemento padre: 588   */
      v.add(doc.createElement("td"));
      ((Element)v.get(588)).appendChild((Element)v.get(591));

      /* Empieza nodo:592 / Elemento padre: 591   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(591)).appendChild((Element)v.get(592));

      /* Empieza nodo:593 / Elemento padre: 592   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(593)).setAttribute("class","legend" );
      ((Element)v.get(592)).appendChild((Element)v.get(593));

      /* Empieza nodo:594 / Elemento padre: 593   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(594)).setAttribute("nombre","lblDatosProductosLote" );
      ((Element)v.get(594)).setAttribute("alto","13" );
      ((Element)v.get(594)).setAttribute("filas","1" );
      ((Element)v.get(594)).setAttribute("valor","" );
      ((Element)v.get(594)).setAttribute("id","legend" );
      ((Element)v.get(594)).setAttribute("cod","00354" );
      ((Element)v.get(593)).appendChild((Element)v.get(594));
      /* Termina nodo:594   */
      /* Termina nodo:593   */

      /* Empieza nodo:595 / Elemento padre: 592   */
      v.add(doc.createElement("table"));
      ((Element)v.get(595)).setAttribute("width","100%" );
      ((Element)v.get(595)).setAttribute("border","0" );
      ((Element)v.get(595)).setAttribute("align","center" );
      ((Element)v.get(595)).setAttribute("cellspacing","0" );
      ((Element)v.get(595)).setAttribute("cellpadding","0" );
      ((Element)v.get(592)).appendChild((Element)v.get(595));

      /* Empieza nodo:596 / Elemento padre: 595   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(595)).appendChild((Element)v.get(596));

      /* Empieza nodo:597 / Elemento padre: 596   */
      v.add(doc.createElement("td"));
      ((Element)v.get(596)).appendChild((Element)v.get(597));

      /* Empieza nodo:598 / Elemento padre: 597   */
      v.add(doc.createElement("table"));
      ((Element)v.get(598)).setAttribute("width","673" );
      ((Element)v.get(598)).setAttribute("border","0" );
      ((Element)v.get(598)).setAttribute("align","left" );
      ((Element)v.get(598)).setAttribute("cellspacing","0" );
      ((Element)v.get(598)).setAttribute("cellpadding","0" );
      ((Element)v.get(597)).appendChild((Element)v.get(598));

      /* Empieza nodo:599 / Elemento padre: 598   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(598)).appendChild((Element)v.get(599));

      /* Empieza nodo:600 / Elemento padre: 599   */
      v.add(doc.createElement("td"));
      ((Element)v.get(600)).setAttribute("colspan","11" );
      ((Element)v.get(599)).appendChild((Element)v.get(600));

      /* Empieza nodo:601 / Elemento padre: 600   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(601)).setAttribute("src","b.gif" );
      ((Element)v.get(601)).setAttribute("width","8" );
      ((Element)v.get(601)).setAttribute("height","8" );
      ((Element)v.get(600)).appendChild((Element)v.get(601));
      /* Termina nodo:601   */
      /* Termina nodo:600   */
      /* Termina nodo:599   */

      /* Empieza nodo:602 / Elemento padre: 598   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(598)).appendChild((Element)v.get(602));

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
      ((Element)v.get(602)).appendChild((Element)v.get(605));

      /* Empieza nodo:606 / Elemento padre: 605   */
   }

   private void getXML2610(Document doc) {
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(606)).setAttribute("nombre","lblCodProducto4" );
      ((Element)v.get(606)).setAttribute("alto","13" );
      ((Element)v.get(606)).setAttribute("filas","1" );
      ((Element)v.get(606)).setAttribute("valor","" );
      ((Element)v.get(606)).setAttribute("id","datosTitle" );
      ((Element)v.get(606)).setAttribute("cod","337" );
      ((Element)v.get(605)).appendChild((Element)v.get(606));
      /* Termina nodo:606   */
      /* Termina nodo:605   */

      /* Empieza nodo:607 / Elemento padre: 602   */
      v.add(doc.createElement("td"));
      ((Element)v.get(607)).setAttribute("width","100%" );
      ((Element)v.get(602)).appendChild((Element)v.get(607));

      /* Empieza nodo:608 / Elemento padre: 607   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(608)).setAttribute("src","b.gif" );
      ((Element)v.get(608)).setAttribute("width","8" );
      ((Element)v.get(608)).setAttribute("height","8" );
      ((Element)v.get(607)).appendChild((Element)v.get(608));
      /* Termina nodo:608   */
      /* Termina nodo:607   */

      /* Empieza nodo:609 / Elemento padre: 602   */
      v.add(doc.createElement("td"));
      ((Element)v.get(602)).appendChild((Element)v.get(609));

      /* Empieza nodo:610 / Elemento padre: 609   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(610)).setAttribute("src","b.gif" );
      ((Element)v.get(610)).setAttribute("width","8" );
      ((Element)v.get(610)).setAttribute("height","8" );
      ((Element)v.get(609)).appendChild((Element)v.get(610));
      /* Termina nodo:610   */
      /* Termina nodo:609   */

      /* Empieza nodo:611 / Elemento padre: 602   */
      v.add(doc.createElement("td"));
      ((Element)v.get(602)).appendChild((Element)v.get(611));

      /* Empieza nodo:612 / Elemento padre: 611   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(612)).setAttribute("nombre","lblIndCenServGar" );
      ((Element)v.get(612)).setAttribute("alto","25" );
      ((Element)v.get(612)).setAttribute("ancho","105" );
      ((Element)v.get(612)).setAttribute("filas","1" );
      ((Element)v.get(612)).setAttribute("valor","" );
      ((Element)v.get(612)).setAttribute("id","datosTitle" );
      ((Element)v.get(612)).setAttribute("cod","3184" );
      ((Element)v.get(611)).appendChild((Element)v.get(612));
      /* Termina nodo:612   */
      /* Termina nodo:611   */

      /* Empieza nodo:613 / Elemento padre: 602   */
      v.add(doc.createElement("td"));
      ((Element)v.get(602)).appendChild((Element)v.get(613));

      /* Empieza nodo:614 / Elemento padre: 613   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(614)).setAttribute("src","b.gif" );
      ((Element)v.get(614)).setAttribute("width","25" );
      ((Element)v.get(614)).setAttribute("height","8" );
      ((Element)v.get(613)).appendChild((Element)v.get(614));
      /* Termina nodo:614   */
      /* Termina nodo:613   */

      /* Empieza nodo:615 / Elemento padre: 602   */
      v.add(doc.createElement("td"));
      ((Element)v.get(602)).appendChild((Element)v.get(615));

      /* Empieza nodo:616 / Elemento padre: 615   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(616)).setAttribute("nombre","lblCenServGar" );
      ((Element)v.get(616)).setAttribute("alto","25" );
      ((Element)v.get(616)).setAttribute("ancho","100" );
      ((Element)v.get(616)).setAttribute("filas","1" );
      ((Element)v.get(616)).setAttribute("valor","" );
      ((Element)v.get(616)).setAttribute("id","datosTitle" );
      ((Element)v.get(616)).setAttribute("cod","3185" );
      ((Element)v.get(615)).appendChild((Element)v.get(616));
      /* Termina nodo:616   */
      /* Termina nodo:615   */

      /* Empieza nodo:617 / Elemento padre: 602   */
      v.add(doc.createElement("td"));
      ((Element)v.get(617)).setAttribute("width","100%" );
      ((Element)v.get(602)).appendChild((Element)v.get(617));

      /* Empieza nodo:618 / Elemento padre: 617   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(618)).setAttribute("src","b.gif" );
      ((Element)v.get(618)).setAttribute("width","8" );
      ((Element)v.get(618)).setAttribute("height","8" );
      ((Element)v.get(617)).appendChild((Element)v.get(618));
      /* Termina nodo:618   */
      /* Termina nodo:617   */

      /* Empieza nodo:619 / Elemento padre: 602   */
      v.add(doc.createElement("td"));
      ((Element)v.get(602)).appendChild((Element)v.get(619));

      /* Empieza nodo:620 / Elemento padre: 619   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(620)).setAttribute("nombre","lblNumMeses" );
      ((Element)v.get(620)).setAttribute("alto","25" );
      ((Element)v.get(620)).setAttribute("ancho","80" );
      ((Element)v.get(620)).setAttribute("filas","1" );
      ((Element)v.get(620)).setAttribute("valor","" );
      ((Element)v.get(620)).setAttribute("id","datosTitle" );
      ((Element)v.get(620)).setAttribute("cod","3186" );
      ((Element)v.get(619)).appendChild((Element)v.get(620));
      /* Termina nodo:620   */
      /* Termina nodo:619   */

      /* Empieza nodo:621 / Elemento padre: 602   */
      v.add(doc.createElement("td"));
      ((Element)v.get(621)).setAttribute("width","100%" );
      ((Element)v.get(602)).appendChild((Element)v.get(621));

      /* Empieza nodo:622 / Elemento padre: 621   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(622)).setAttribute("src","b.gif" );
      ((Element)v.get(622)).setAttribute("width","8" );
      ((Element)v.get(622)).setAttribute("height","8" );
      ((Element)v.get(621)).appendChild((Element)v.get(622));
      /* Termina nodo:622   */
      /* Termina nodo:621   */

      /* Empieza nodo:623 / Elemento padre: 602   */
      v.add(doc.createElement("td"));
      ((Element)v.get(602)).appendChild((Element)v.get(623));

      /* Empieza nodo:624 / Elemento padre: 623   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(624)).setAttribute("nombre","lblObservaciones" );
      ((Element)v.get(624)).setAttribute("alto","13" );
      ((Element)v.get(624)).setAttribute("filas","1" );
      ((Element)v.get(624)).setAttribute("valor","" );
      ((Element)v.get(624)).setAttribute("id","datosTitle" );
      ((Element)v.get(624)).setAttribute("cod","169" );
      ((Element)v.get(623)).appendChild((Element)v.get(624));
      /* Termina nodo:624   */
      /* Termina nodo:623   */
      /* Termina nodo:602   */

      /* Empieza nodo:625 / Elemento padre: 598   */
      v.add(doc.createElement("tr"));
   }

   private void getXML2700(Document doc) {
      ((Element)v.get(598)).appendChild((Element)v.get(625));

      /* Empieza nodo:626 / Elemento padre: 625   */
      v.add(doc.createElement("td"));
      ((Element)v.get(625)).appendChild((Element)v.get(626));

      /* Empieza nodo:627 / Elemento padre: 626   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(627)).setAttribute("src","b.gif" );
      ((Element)v.get(627)).setAttribute("width","8" );
      ((Element)v.get(627)).setAttribute("height","8" );
      ((Element)v.get(626)).appendChild((Element)v.get(627));
      /* Termina nodo:627   */
      /* Termina nodo:626   */

      /* Empieza nodo:628 / Elemento padre: 625   */
      v.add(doc.createElement("td"));
      ((Element)v.get(628)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(625)).appendChild((Element)v.get(628));

      /* Empieza nodo:629 / Elemento padre: 628   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(629)).setAttribute("nombre","txtCodProducto" );
      ((Element)v.get(629)).setAttribute("id","datosCampos" );
      ((Element)v.get(629)).setAttribute("max","20" );
      ((Element)v.get(629)).setAttribute("tipo","" );
      ((Element)v.get(629)).setAttribute("onchange","" );
      ((Element)v.get(629)).setAttribute("req","S" );
      ((Element)v.get(629)).setAttribute("size","26" );
      ((Element)v.get(629)).setAttribute("valor","" );
      ((Element)v.get(629)).setAttribute("validacion","" );
      ((Element)v.get(628)).appendChild((Element)v.get(629));
      /* Termina nodo:629   */
      /* Termina nodo:628   */

      /* Empieza nodo:630 / Elemento padre: 625   */
      v.add(doc.createElement("td"));
      ((Element)v.get(625)).appendChild((Element)v.get(630));

      /* Empieza nodo:631 / Elemento padre: 630   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(631)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(631)).setAttribute("ID","botonContenido" );
      ((Element)v.get(631)).setAttribute("tipo","html" );
      ((Element)v.get(631)).setAttribute("accion","accionBuscarProducto();" );
      ((Element)v.get(631)).setAttribute("estado","false" );
      ((Element)v.get(631)).setAttribute("cod","1" );
      ((Element)v.get(630)).appendChild((Element)v.get(631));
      /* Termina nodo:631   */
      /* Termina nodo:630   */

      /* Empieza nodo:632 / Elemento padre: 625   */
      v.add(doc.createElement("td"));
      ((Element)v.get(632)).setAttribute("width","100%" );
      ((Element)v.get(625)).appendChild((Element)v.get(632));

      /* Empieza nodo:633 / Elemento padre: 632   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(633)).setAttribute("src","b.gif" );
      ((Element)v.get(633)).setAttribute("width","8" );
      ((Element)v.get(633)).setAttribute("height","8" );
      ((Element)v.get(632)).appendChild((Element)v.get(633));
      /* Termina nodo:633   */
      /* Termina nodo:632   */

      /* Empieza nodo:634 / Elemento padre: 625   */
      v.add(doc.createElement("td"));
      ((Element)v.get(634)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(634)).setAttribute("align","center" );
      ((Element)v.get(625)).appendChild((Element)v.get(634));

      /* Empieza nodo:635 / Elemento padre: 634   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(635)).setAttribute("nombre","ChkIndCenServGar" );
      ((Element)v.get(635)).setAttribute("id","datosCampos" );
      ((Element)v.get(635)).setAttribute("onclick","onclickIndCenServGar();" );
      ((Element)v.get(635)).setAttribute("onshtab","focalizaShTab(2);" );
      ((Element)v.get(635)).setAttribute("check","N" );
      ((Element)v.get(634)).appendChild((Element)v.get(635));
      /* Termina nodo:635   */
      /* Termina nodo:634   */

      /* Empieza nodo:636 / Elemento padre: 625   */
      v.add(doc.createElement("td"));
      ((Element)v.get(625)).appendChild((Element)v.get(636));

      /* Empieza nodo:637 / Elemento padre: 636   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(637)).setAttribute("src","b.gif" );
      ((Element)v.get(637)).setAttribute("width","25" );
      ((Element)v.get(637)).setAttribute("height","8" );
      ((Element)v.get(636)).appendChild((Element)v.get(637));
      /* Termina nodo:637   */
      /* Termina nodo:636   */

      /* Empieza nodo:638 / Elemento padre: 625   */
      v.add(doc.createElement("td"));
      ((Element)v.get(638)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(625)).appendChild((Element)v.get(638));

      /* Empieza nodo:639 / Elemento padre: 638   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(639)).setAttribute("nombre","cbCenServGar" );
      ((Element)v.get(639)).setAttribute("id","datosCampos" );
      ((Element)v.get(639)).setAttribute("size","1" );
      ((Element)v.get(639)).setAttribute("multiple","N" );
      ((Element)v.get(639)).setAttribute("req","N" );
      ((Element)v.get(639)).setAttribute("onchange","" );
      ((Element)v.get(639)).setAttribute("valorinicial","" );
      ((Element)v.get(639)).setAttribute("textoinicial","" );
      ((Element)v.get(638)).appendChild((Element)v.get(639));

      /* Empieza nodo:640 / Elemento padre: 639   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(639)).appendChild((Element)v.get(640));
      /* Termina nodo:640   */
      /* Termina nodo:639   */
      /* Termina nodo:638   */

      /* Empieza nodo:641 / Elemento padre: 625   */
      v.add(doc.createElement("td"));
      ((Element)v.get(641)).setAttribute("width","100%" );
      ((Element)v.get(625)).appendChild((Element)v.get(641));

      /* Empieza nodo:642 / Elemento padre: 641   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(642)).setAttribute("src","b.gif" );
      ((Element)v.get(642)).setAttribute("width","8" );
      ((Element)v.get(642)).setAttribute("height","8" );
      ((Element)v.get(641)).appendChild((Element)v.get(642));
      /* Termina nodo:642   */
      /* Termina nodo:641   */

      /* Empieza nodo:643 / Elemento padre: 625   */
      v.add(doc.createElement("td"));
      ((Element)v.get(643)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(625)).appendChild((Element)v.get(643));

      /* Empieza nodo:644 / Elemento padre: 643   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(644)).setAttribute("nombre","txtNumMeses" );
      ((Element)v.get(644)).setAttribute("id","datosCampos" );
      ((Element)v.get(644)).setAttribute("max","4" );
      ((Element)v.get(644)).setAttribute("tipo","" );
      ((Element)v.get(644)).setAttribute("onblur","" );
   }

   private void getXML2790(Document doc) {
      ((Element)v.get(644)).setAttribute("onchange","" );
      ((Element)v.get(644)).setAttribute("req","N" );
      ((Element)v.get(644)).setAttribute("size","6" );
      ((Element)v.get(644)).setAttribute("valor","" );
      ((Element)v.get(644)).setAttribute("validacion","" );
      ((Element)v.get(643)).appendChild((Element)v.get(644));
      /* Termina nodo:644   */
      /* Termina nodo:643   */

      /* Empieza nodo:645 / Elemento padre: 625   */
      v.add(doc.createElement("td"));
      ((Element)v.get(645)).setAttribute("width","100%" );
      ((Element)v.get(625)).appendChild((Element)v.get(645));

      /* Empieza nodo:646 / Elemento padre: 645   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(646)).setAttribute("src","b.gif" );
      ((Element)v.get(646)).setAttribute("width","8" );
      ((Element)v.get(646)).setAttribute("height","8" );
      ((Element)v.get(645)).appendChild((Element)v.get(646));
      /* Termina nodo:646   */
      /* Termina nodo:645   */

      /* Empieza nodo:647 / Elemento padre: 625   */
      v.add(doc.createElement("td"));
      ((Element)v.get(647)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(625)).appendChild((Element)v.get(647));

      /* Empieza nodo:648 / Elemento padre: 647   */
      v.add(doc.createElement("AREATEXTO"));
      ((Element)v.get(648)).setAttribute("cols","20" );
      ((Element)v.get(648)).setAttribute("id","datosCampos" );
      ((Element)v.get(648)).setAttribute("msjreq","" );
      ((Element)v.get(648)).setAttribute("nombre","areaObservaciones" );
      ((Element)v.get(648)).setAttribute("readonly","N" );
      ((Element)v.get(648)).setAttribute("req","N" );
      ((Element)v.get(648)).setAttribute("rows","3" );
      ((Element)v.get(648)).setAttribute("tabindex","2" );
      ((Element)v.get(648)).setAttribute("valor","" );
      ((Element)v.get(648)).setAttribute("max","80" );
      ((Element)v.get(647)).appendChild((Element)v.get(648));
      /* Termina nodo:648   */
      /* Termina nodo:647   */
      /* Termina nodo:625   */

      /* Empieza nodo:649 / Elemento padre: 598   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(598)).appendChild((Element)v.get(649));

      /* Empieza nodo:650 / Elemento padre: 649   */
      v.add(doc.createElement("td"));
      ((Element)v.get(650)).setAttribute("colspan","11" );
      ((Element)v.get(649)).appendChild((Element)v.get(650));

      /* Empieza nodo:651 / Elemento padre: 650   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(651)).setAttribute("src","b.gif" );
      ((Element)v.get(651)).setAttribute("width","8" );
      ((Element)v.get(651)).setAttribute("height","8" );
      ((Element)v.get(650)).appendChild((Element)v.get(651));
      /* Termina nodo:651   */
      /* Termina nodo:650   */
      /* Termina nodo:649   */
      /* Termina nodo:598   */
      /* Termina nodo:597   */
      /* Termina nodo:596   */

      /* Empieza nodo:652 / Elemento padre: 595   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(595)).appendChild((Element)v.get(652));

      /* Empieza nodo:653 / Elemento padre: 652   */
      v.add(doc.createElement("td"));
      ((Element)v.get(652)).appendChild((Element)v.get(653));

      /* Empieza nodo:654 / Elemento padre: 653   */
      v.add(doc.createElement("table"));
      ((Element)v.get(654)).setAttribute("width","673" );
      ((Element)v.get(654)).setAttribute("border","0" );
      ((Element)v.get(654)).setAttribute("align","left" );
      ((Element)v.get(654)).setAttribute("cellspacing","0" );
      ((Element)v.get(654)).setAttribute("cellpadding","0" );
      ((Element)v.get(653)).appendChild((Element)v.get(654));

      /* Empieza nodo:655 / Elemento padre: 654   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(654)).appendChild((Element)v.get(655));

      /* Empieza nodo:656 / Elemento padre: 655   */
      v.add(doc.createElement("td"));
      ((Element)v.get(655)).appendChild((Element)v.get(656));

      /* Empieza nodo:657 / Elemento padre: 656   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(657)).setAttribute("src","b.gif" );
      ((Element)v.get(657)).setAttribute("width","8" );
      ((Element)v.get(657)).setAttribute("height","8" );
      ((Element)v.get(656)).appendChild((Element)v.get(657));
      /* Termina nodo:657   */
      /* Termina nodo:656   */

      /* Empieza nodo:658 / Elemento padre: 655   */
      v.add(doc.createElement("td"));
      ((Element)v.get(655)).appendChild((Element)v.get(658));

      /* Empieza nodo:659 / Elemento padre: 658   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(659)).setAttribute("nombre","lblNumUnidades4" );
      ((Element)v.get(659)).setAttribute("alto","13" );
      ((Element)v.get(659)).setAttribute("filas","1" );
      ((Element)v.get(659)).setAttribute("valor","" );
      ((Element)v.get(659)).setAttribute("id","datosTitle" );
      ((Element)v.get(659)).setAttribute("cod","495" );
      ((Element)v.get(658)).appendChild((Element)v.get(659));
      /* Termina nodo:659   */
      /* Termina nodo:658   */

      /* Empieza nodo:660 / Elemento padre: 655   */
      v.add(doc.createElement("td"));
      ((Element)v.get(655)).appendChild((Element)v.get(660));

      /* Empieza nodo:661 / Elemento padre: 660   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(661)).setAttribute("src","b.gif" );
      ((Element)v.get(661)).setAttribute("width","25" );
      ((Element)v.get(661)).setAttribute("height","8" );
      ((Element)v.get(660)).appendChild((Element)v.get(661));
      /* Termina nodo:661   */
      /* Termina nodo:660   */

      /* Empieza nodo:662 / Elemento padre: 655   */
      v.add(doc.createElement("td"));
      ((Element)v.get(655)).appendChild((Element)v.get(662));

      /* Empieza nodo:663 / Elemento padre: 662   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(663)).setAttribute("nombre","lblPrecioPublico4" );
      ((Element)v.get(663)).setAttribute("alto","13" );
      ((Element)v.get(663)).setAttribute("filas","1" );
      ((Element)v.get(663)).setAttribute("valor","" );
      ((Element)v.get(663)).setAttribute("id","datosTitle" );
      ((Element)v.get(663)).setAttribute("cod","1854" );
      ((Element)v.get(662)).appendChild((Element)v.get(663));
      /* Termina nodo:663   */
      /* Termina nodo:662   */

      /* Empieza nodo:664 / Elemento padre: 655   */
      v.add(doc.createElement("td"));
      ((Element)v.get(655)).appendChild((Element)v.get(664));

      /* Empieza nodo:665 / Elemento padre: 664   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(665)).setAttribute("src","b.gif" );
   }

   private void getXML2880(Document doc) {
      ((Element)v.get(665)).setAttribute("width","25" );
      ((Element)v.get(665)).setAttribute("height","8" );
      ((Element)v.get(664)).appendChild((Element)v.get(665));
      /* Termina nodo:665   */
      /* Termina nodo:664   */

      /* Empieza nodo:666 / Elemento padre: 655   */
      v.add(doc.createElement("td"));
      ((Element)v.get(655)).appendChild((Element)v.get(666));

      /* Empieza nodo:667 / Elemento padre: 666   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(667)).setAttribute("nombre","lblDespachaArticulo4" );
      ((Element)v.get(667)).setAttribute("alto","13" );
      ((Element)v.get(667)).setAttribute("filas","1" );
      ((Element)v.get(667)).setAttribute("valor","" );
      ((Element)v.get(667)).setAttribute("id","datosTitle" );
      ((Element)v.get(667)).setAttribute("cod","1851" );
      ((Element)v.get(666)).appendChild((Element)v.get(667));
      /* Termina nodo:667   */
      /* Termina nodo:666   */

      /* Empieza nodo:668 / Elemento padre: 655   */
      v.add(doc.createElement("td"));
      ((Element)v.get(668)).setAttribute("width","100%" );
      ((Element)v.get(655)).appendChild((Element)v.get(668));

      /* Empieza nodo:669 / Elemento padre: 668   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(669)).setAttribute("src","b.gif" );
      ((Element)v.get(669)).setAttribute("width","8" );
      ((Element)v.get(669)).setAttribute("height","8" );
      ((Element)v.get(668)).appendChild((Element)v.get(669));
      /* Termina nodo:669   */
      /* Termina nodo:668   */

      /* Empieza nodo:670 / Elemento padre: 655   */
      v.add(doc.createElement("td"));
      ((Element)v.get(655)).appendChild((Element)v.get(670));

      /* Empieza nodo:671 / Elemento padre: 670   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(671)).setAttribute("nombre","lblTipoEntrega" );
      ((Element)v.get(671)).setAttribute("alto","13" );
      ((Element)v.get(671)).setAttribute("filas","1" );
      ((Element)v.get(671)).setAttribute("valor","" );
      ((Element)v.get(671)).setAttribute("id","datosTitle" );
      ((Element)v.get(671)).setAttribute("cod","3187" );
      ((Element)v.get(670)).appendChild((Element)v.get(671));
      /* Termina nodo:671   */
      /* Termina nodo:670   */

      /* Empieza nodo:672 / Elemento padre: 655   */
      v.add(doc.createElement("td"));
      ((Element)v.get(655)).appendChild((Element)v.get(672));

      /* Empieza nodo:673 / Elemento padre: 672   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(673)).setAttribute("src","b.gif" );
      ((Element)v.get(673)).setAttribute("width","25" );
      ((Element)v.get(673)).setAttribute("height","8" );
      ((Element)v.get(672)).appendChild((Element)v.get(673));
      /* Termina nodo:673   */
      /* Termina nodo:672   */

      /* Empieza nodo:674 / Elemento padre: 655   */
      v.add(doc.createElement("td"));
      ((Element)v.get(655)).appendChild((Element)v.get(674));

      /* Empieza nodo:675 / Elemento padre: 674   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(675)).setAttribute("nombre","lblCenServEntrega" );
      ((Element)v.get(675)).setAttribute("alto","13" );
      ((Element)v.get(675)).setAttribute("filas","1" );
      ((Element)v.get(675)).setAttribute("valor","" );
      ((Element)v.get(675)).setAttribute("id","datosTitle" );
      ((Element)v.get(675)).setAttribute("cod","3188" );
      ((Element)v.get(674)).appendChild((Element)v.get(675));
      /* Termina nodo:675   */
      /* Termina nodo:674   */

      /* Empieza nodo:676 / Elemento padre: 655   */
      v.add(doc.createElement("td"));
      ((Element)v.get(676)).setAttribute("width","100%" );
      ((Element)v.get(655)).appendChild((Element)v.get(676));

      /* Empieza nodo:677 / Elemento padre: 676   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(677)).setAttribute("src","b.gif" );
      ((Element)v.get(677)).setAttribute("width","8" );
      ((Element)v.get(677)).setAttribute("height","8" );
      ((Element)v.get(676)).appendChild((Element)v.get(677));
      /* Termina nodo:677   */
      /* Termina nodo:676   */
      /* Termina nodo:655   */

      /* Empieza nodo:678 / Elemento padre: 654   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(654)).appendChild((Element)v.get(678));

      /* Empieza nodo:679 / Elemento padre: 678   */
      v.add(doc.createElement("td"));
      ((Element)v.get(678)).appendChild((Element)v.get(679));

      /* Empieza nodo:680 / Elemento padre: 679   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(680)).setAttribute("src","b.gif" );
      ((Element)v.get(680)).setAttribute("width","8" );
      ((Element)v.get(680)).setAttribute("height","8" );
      ((Element)v.get(679)).appendChild((Element)v.get(680));
      /* Termina nodo:680   */
      /* Termina nodo:679   */

      /* Empieza nodo:681 / Elemento padre: 678   */
      v.add(doc.createElement("td"));
      ((Element)v.get(681)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(678)).appendChild((Element)v.get(681));

      /* Empieza nodo:682 / Elemento padre: 681   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(682)).setAttribute("nombre","txtNumUnidades4" );
      ((Element)v.get(682)).setAttribute("id","datosCampos" );
      ((Element)v.get(682)).setAttribute("max","5" );
      ((Element)v.get(682)).setAttribute("tipo","" );
      ((Element)v.get(682)).setAttribute("onchange","" );
      ((Element)v.get(682)).setAttribute("req","S" );
      ((Element)v.get(682)).setAttribute("size","4" );
      ((Element)v.get(682)).setAttribute("valor","" );
      ((Element)v.get(682)).setAttribute("validacion","" );
      ((Element)v.get(681)).appendChild((Element)v.get(682));
      /* Termina nodo:682   */
      /* Termina nodo:681   */

      /* Empieza nodo:683 / Elemento padre: 678   */
      v.add(doc.createElement("td"));
      ((Element)v.get(678)).appendChild((Element)v.get(683));

      /* Empieza nodo:684 / Elemento padre: 683   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(684)).setAttribute("src","b.gif" );
      ((Element)v.get(684)).setAttribute("width","25" );
      ((Element)v.get(684)).setAttribute("height","8" );
      ((Element)v.get(683)).appendChild((Element)v.get(684));
      /* Termina nodo:684   */
      /* Termina nodo:683   */

      /* Empieza nodo:685 / Elemento padre: 678   */
      v.add(doc.createElement("td"));
      ((Element)v.get(685)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(678)).appendChild((Element)v.get(685));

      /* Empieza nodo:686 / Elemento padre: 685   */
      v.add(doc.createElement("CTEXTO"));
   }

   private void getXML2970(Document doc) {
      ((Element)v.get(686)).setAttribute("nombre","txtPrecioPublico4" );
      ((Element)v.get(686)).setAttribute("id","datosCampos" );
      ((Element)v.get(686)).setAttribute("max","11" );
      ((Element)v.get(686)).setAttribute("tipo","" );
      ((Element)v.get(686)).setAttribute("onchange","" );
      ((Element)v.get(686)).setAttribute("req","S" );
      ((Element)v.get(686)).setAttribute("size","12" );
      ((Element)v.get(686)).setAttribute("valor","" );
      ((Element)v.get(686)).setAttribute("validacion","" );
      ((Element)v.get(685)).appendChild((Element)v.get(686));
      /* Termina nodo:686   */
      /* Termina nodo:685   */

      /* Empieza nodo:687 / Elemento padre: 678   */
      v.add(doc.createElement("td"));
      ((Element)v.get(678)).appendChild((Element)v.get(687));

      /* Empieza nodo:688 / Elemento padre: 687   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(688)).setAttribute("src","b.gif" );
      ((Element)v.get(688)).setAttribute("width","25" );
      ((Element)v.get(688)).setAttribute("height","8" );
      ((Element)v.get(687)).appendChild((Element)v.get(688));
      /* Termina nodo:688   */
      /* Termina nodo:687   */

      /* Empieza nodo:689 / Elemento padre: 678   */
      v.add(doc.createElement("td"));
      ((Element)v.get(689)).setAttribute("valing","bottom" );
      ((Element)v.get(678)).appendChild((Element)v.get(689));

      /* Empieza nodo:690 / Elemento padre: 689   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(690)).setAttribute("nombre","ckArticuloDespacha4" );
      ((Element)v.get(690)).setAttribute("id","datosCampos" );
      ((Element)v.get(690)).setAttribute("onclick","" );
      ((Element)v.get(690)).setAttribute("check","S" );
      ((Element)v.get(689)).appendChild((Element)v.get(690));
      /* Termina nodo:690   */
      /* Termina nodo:689   */

      /* Empieza nodo:691 / Elemento padre: 678   */
      v.add(doc.createElement("td"));
      ((Element)v.get(691)).setAttribute("width","100%" );
      ((Element)v.get(678)).appendChild((Element)v.get(691));

      /* Empieza nodo:692 / Elemento padre: 691   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(692)).setAttribute("src","b.gif" );
      ((Element)v.get(692)).setAttribute("width","8" );
      ((Element)v.get(692)).setAttribute("height","8" );
      ((Element)v.get(691)).appendChild((Element)v.get(692));
      /* Termina nodo:692   */
      /* Termina nodo:691   */

      /* Empieza nodo:693 / Elemento padre: 678   */
      v.add(doc.createElement("td"));
      ((Element)v.get(693)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(678)).appendChild((Element)v.get(693));

      /* Empieza nodo:694 / Elemento padre: 693   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(694)).setAttribute("nombre","rdTipoEntrega" );
      ((Element)v.get(694)).setAttribute("onclick","onclickRdTipoEntrega();" );
      ((Element)v.get(694)).setAttribute("tipo","V" );
      ((Element)v.get(694)).setAttribute("req","N" );
      ((Element)v.get(693)).appendChild((Element)v.get(694));

      /* Empieza nodo:695 / Elemento padre: 694   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(695)).setAttribute("id","datosTitle" );
      ((Element)v.get(695)).setAttribute("valor","C" );
      ((Element)v.get(695)).setAttribute("cod","3190" );
      ((Element)v.get(694)).appendChild((Element)v.get(695));
      /* Termina nodo:695   */

      /* Empieza nodo:696 / Elemento padre: 694   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(696)).setAttribute("id","datosTitle" );
      ((Element)v.get(696)).setAttribute("valor","B" );
      ((Element)v.get(696)).setAttribute("cod","3189" );
      ((Element)v.get(696)).setAttribute("check","S" );
      ((Element)v.get(694)).appendChild((Element)v.get(696));
      /* Termina nodo:696   */
      /* Termina nodo:694   */
      /* Termina nodo:693   */

      /* Empieza nodo:697 / Elemento padre: 678   */
      v.add(doc.createElement("td"));
      ((Element)v.get(678)).appendChild((Element)v.get(697));

      /* Empieza nodo:698 / Elemento padre: 697   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(698)).setAttribute("src","b.gif" );
      ((Element)v.get(698)).setAttribute("width","25" );
      ((Element)v.get(698)).setAttribute("height","8" );
      ((Element)v.get(697)).appendChild((Element)v.get(698));
      /* Termina nodo:698   */
      /* Termina nodo:697   */

      /* Empieza nodo:699 / Elemento padre: 678   */
      v.add(doc.createElement("td"));
      ((Element)v.get(699)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(678)).appendChild((Element)v.get(699));

      /* Empieza nodo:700 / Elemento padre: 699   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(700)).setAttribute("nombre","cbCenServEntrega" );
      ((Element)v.get(700)).setAttribute("id","datosCampos" );
      ((Element)v.get(700)).setAttribute("size","1" );
      ((Element)v.get(700)).setAttribute("multiple","N" );
      ((Element)v.get(700)).setAttribute("req","N" );
      ((Element)v.get(700)).setAttribute("onchange","" );
      ((Element)v.get(700)).setAttribute("valorinicial","" );
      ((Element)v.get(700)).setAttribute("textoinicial","" );
      ((Element)v.get(699)).appendChild((Element)v.get(700));

      /* Empieza nodo:701 / Elemento padre: 700   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(700)).appendChild((Element)v.get(701));
      /* Termina nodo:701   */
      /* Termina nodo:700   */
      /* Termina nodo:699   */

      /* Empieza nodo:702 / Elemento padre: 678   */
      v.add(doc.createElement("td"));
      ((Element)v.get(702)).setAttribute("width","100%" );
      ((Element)v.get(678)).appendChild((Element)v.get(702));

      /* Empieza nodo:703 / Elemento padre: 702   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(703)).setAttribute("src","b.gif" );
      ((Element)v.get(703)).setAttribute("width","8" );
      ((Element)v.get(703)).setAttribute("height","8" );
      ((Element)v.get(702)).appendChild((Element)v.get(703));
      /* Termina nodo:703   */
      /* Termina nodo:702   */
      /* Termina nodo:678   */

      /* Empieza nodo:704 / Elemento padre: 654   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(654)).appendChild((Element)v.get(704));

      /* Empieza nodo:705 / Elemento padre: 704   */
      v.add(doc.createElement("td"));
      ((Element)v.get(705)).setAttribute("colspan","11" );
      ((Element)v.get(704)).appendChild((Element)v.get(705));

      /* Empieza nodo:706 / Elemento padre: 705   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML3060(Document doc) {
      ((Element)v.get(706)).setAttribute("src","b.gif" );
      ((Element)v.get(706)).setAttribute("width","8" );
      ((Element)v.get(706)).setAttribute("height","8" );
      ((Element)v.get(705)).appendChild((Element)v.get(706));
      /* Termina nodo:706   */
      /* Termina nodo:705   */
      /* Termina nodo:704   */
      /* Termina nodo:654   */
      /* Termina nodo:653   */
      /* Termina nodo:652   */
      /* Termina nodo:595   */
      /* Termina nodo:592   */
      /* Termina nodo:591   */

      /* Empieza nodo:707 / Elemento padre: 588   */
      v.add(doc.createElement("td"));
      ((Element)v.get(588)).appendChild((Element)v.get(707));

      /* Empieza nodo:708 / Elemento padre: 707   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(708)).setAttribute("src","b.gif" );
      ((Element)v.get(707)).appendChild((Element)v.get(708));
      /* Termina nodo:708   */
      /* Termina nodo:707   */
      /* Termina nodo:588   */

      /* Empieza nodo:709 / Elemento padre: 584   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(584)).appendChild((Element)v.get(709));

      /* Empieza nodo:710 / Elemento padre: 709   */
      v.add(doc.createElement("td"));
      ((Element)v.get(709)).appendChild((Element)v.get(710));

      /* Empieza nodo:711 / Elemento padre: 710   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(711)).setAttribute("src","b.gif" );
      ((Element)v.get(710)).appendChild((Element)v.get(711));
      /* Termina nodo:711   */
      /* Termina nodo:710   */

      /* Empieza nodo:712 / Elemento padre: 709   */
      v.add(doc.createElement("td"));
      ((Element)v.get(709)).appendChild((Element)v.get(712));

      /* Empieza nodo:713 / Elemento padre: 712   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(712)).appendChild((Element)v.get(713));

      /* Empieza nodo:714 / Elemento padre: 713   */
      v.add(doc.createElement("table"));
      ((Element)v.get(714)).setAttribute("width","100%" );
      ((Element)v.get(714)).setAttribute("border","0" );
      ((Element)v.get(714)).setAttribute("align","center" );
      ((Element)v.get(714)).setAttribute("cellspacing","0" );
      ((Element)v.get(714)).setAttribute("cellpadding","0" );
      ((Element)v.get(713)).appendChild((Element)v.get(714));

      /* Empieza nodo:715 / Elemento padre: 714   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(714)).appendChild((Element)v.get(715));

      /* Empieza nodo:716 / Elemento padre: 715   */
      v.add(doc.createElement("td"));
      ((Element)v.get(716)).setAttribute("class","botonera" );
      ((Element)v.get(715)).appendChild((Element)v.get(716));

      /* Empieza nodo:717 / Elemento padre: 716   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(717)).setAttribute("nombre","btnAnadirProductos" );
      ((Element)v.get(717)).setAttribute("ID","botonContenido" );
      ((Element)v.get(717)).setAttribute("tipo","html" );
      ((Element)v.get(717)).setAttribute("accion","accionAniadirProductoLote();" );
      ((Element)v.get(717)).setAttribute("estado","false" );
      ((Element)v.get(717)).setAttribute("cod","404" );
      ((Element)v.get(716)).appendChild((Element)v.get(717));
      /* Termina nodo:717   */
      /* Termina nodo:716   */
      /* Termina nodo:715   */
      /* Termina nodo:714   */
      /* Termina nodo:713   */
      /* Termina nodo:712   */

      /* Empieza nodo:718 / Elemento padre: 709   */
      v.add(doc.createElement("td"));
      ((Element)v.get(709)).appendChild((Element)v.get(718));

      /* Empieza nodo:719 / Elemento padre: 718   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(719)).setAttribute("src","b.gif" );
      ((Element)v.get(719)).setAttribute("width","8" );
      ((Element)v.get(719)).setAttribute("height","12" );
      ((Element)v.get(718)).appendChild((Element)v.get(719));
      /* Termina nodo:719   */
      /* Termina nodo:718   */
      /* Termina nodo:709   */

      /* Empieza nodo:720 / Elemento padre: 584   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(584)).appendChild((Element)v.get(720));

      /* Empieza nodo:721 / Elemento padre: 720   */
      v.add(doc.createElement("td"));
      ((Element)v.get(721)).setAttribute("width","12" );
      ((Element)v.get(721)).setAttribute("align","center" );
      ((Element)v.get(720)).appendChild((Element)v.get(721));

      /* Empieza nodo:722 / Elemento padre: 721   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(722)).setAttribute("src","b.gif" );
      ((Element)v.get(722)).setAttribute("width","12" );
      ((Element)v.get(722)).setAttribute("height","318" );
      ((Element)v.get(721)).appendChild((Element)v.get(722));
      /* Termina nodo:722   */
      /* Termina nodo:721   */

      /* Empieza nodo:723 / Elemento padre: 720   */
      v.add(doc.createElement("td"));
      ((Element)v.get(723)).setAttribute("width","756" );
      ((Element)v.get(720)).appendChild((Element)v.get(723));

      /* Empieza nodo:724 / Elemento padre: 723   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(724)).setAttribute("src","b.gif" );
      ((Element)v.get(723)).appendChild((Element)v.get(724));
      /* Termina nodo:724   */
      /* Termina nodo:723   */

      /* Empieza nodo:725 / Elemento padre: 720   */
      v.add(doc.createElement("td"));
      ((Element)v.get(725)).setAttribute("width","12" );
      ((Element)v.get(720)).appendChild((Element)v.get(725));

      /* Empieza nodo:726 / Elemento padre: 725   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(726)).setAttribute("src","b.gif" );
      ((Element)v.get(726)).setAttribute("width","12" );
      ((Element)v.get(726)).setAttribute("height","1" );
      ((Element)v.get(725)).appendChild((Element)v.get(726));
      /* Termina nodo:726   */
      /* Termina nodo:725   */
      /* Termina nodo:720   */
      /* Termina nodo:584   */
      /* Termina nodo:583   */
      /* Termina nodo:582   */

      /* Empieza nodo:727 / Elemento padre: 581   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(581)).appendChild((Element)v.get(727));

      /* Empieza nodo:728 / Elemento padre: 727   */
      v.add(doc.createElement("td"));
      ((Element)v.get(727)).appendChild((Element)v.get(728));

      /* Empieza nodo:729 / Elemento padre: 728   */
      v.add(doc.createElement("table"));
      ((Element)v.get(729)).setAttribute("width","100%" );
      ((Element)v.get(729)).setAttribute("align","left" );
      ((Element)v.get(729)).setAttribute("border","0" );
      ((Element)v.get(729)).setAttribute("cellspacing","0" );
      ((Element)v.get(729)).setAttribute("cellpadding","0" );
      ((Element)v.get(728)).appendChild((Element)v.get(729));

      /* Empieza nodo:730 / Elemento padre: 729   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(729)).appendChild((Element)v.get(730));

      /* Empieza nodo:731 / Elemento padre: 730   */
      v.add(doc.createElement("td"));
      ((Element)v.get(731)).setAttribute("colspan","4" );
      ((Element)v.get(730)).appendChild((Element)v.get(731));

      /* Empieza nodo:732 / Elemento padre: 731   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(732)).setAttribute("src","b.gif" );
   }

   private void getXML3150(Document doc) {
      ((Element)v.get(732)).setAttribute("width","8" );
      ((Element)v.get(732)).setAttribute("height","8" );
      ((Element)v.get(731)).appendChild((Element)v.get(732));
      /* Termina nodo:732   */
      /* Termina nodo:731   */
      /* Termina nodo:730   */

      /* Empieza nodo:733 / Elemento padre: 729   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(729)).appendChild((Element)v.get(733));

      /* Empieza nodo:734 / Elemento padre: 733   */
      v.add(doc.createElement("td"));
      ((Element)v.get(733)).appendChild((Element)v.get(734));

      /* Empieza nodo:735 / Elemento padre: 734   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(735)).setAttribute("src","b.gif" );
      ((Element)v.get(734)).appendChild((Element)v.get(735));
      /* Termina nodo:735   */
      /* Termina nodo:734   */

      /* Empieza nodo:736 / Elemento padre: 733   */
      v.add(doc.createElement("td"));
      ((Element)v.get(733)).appendChild((Element)v.get(736));

      /* Empieza nodo:737 / Elemento padre: 736   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(736)).appendChild((Element)v.get(737));

      /* Empieza nodo:738 / Elemento padre: 737   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(738)).setAttribute("class","legend" );
      ((Element)v.get(737)).appendChild((Element)v.get(738));

      /* Empieza nodo:739 / Elemento padre: 738   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(739)).setAttribute("nombre","lblOtrosDatos4" );
      ((Element)v.get(739)).setAttribute("alto","13" );
      ((Element)v.get(739)).setAttribute("filas","1" );
      ((Element)v.get(739)).setAttribute("valor","" );
      ((Element)v.get(739)).setAttribute("id","legend" );
      ((Element)v.get(739)).setAttribute("cod","00167" );
      ((Element)v.get(738)).appendChild((Element)v.get(739));
      /* Termina nodo:739   */
      /* Termina nodo:738   */

      /* Empieza nodo:740 / Elemento padre: 737   */
      v.add(doc.createElement("table"));
      ((Element)v.get(740)).setAttribute("width","100%" );
      ((Element)v.get(740)).setAttribute("border","0" );
      ((Element)v.get(740)).setAttribute("align","center" );
      ((Element)v.get(740)).setAttribute("cellspacing","0" );
      ((Element)v.get(740)).setAttribute("cellpadding","0" );
      ((Element)v.get(737)).appendChild((Element)v.get(740));

      /* Empieza nodo:741 / Elemento padre: 740   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(740)).appendChild((Element)v.get(741));

      /* Empieza nodo:742 / Elemento padre: 741   */
      v.add(doc.createElement("td"));
      ((Element)v.get(741)).appendChild((Element)v.get(742));

      /* Empieza nodo:743 / Elemento padre: 742   */
      v.add(doc.createElement("table"));
      ((Element)v.get(743)).setAttribute("width","673" );
      ((Element)v.get(743)).setAttribute("border","0" );
      ((Element)v.get(743)).setAttribute("align","left" );
      ((Element)v.get(743)).setAttribute("cellspacing","0" );
      ((Element)v.get(743)).setAttribute("cellpadding","0" );
      ((Element)v.get(742)).appendChild((Element)v.get(743));

      /* Empieza nodo:744 / Elemento padre: 743   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(743)).appendChild((Element)v.get(744));

      /* Empieza nodo:745 / Elemento padre: 744   */
      v.add(doc.createElement("td"));
      ((Element)v.get(745)).setAttribute("colspan","4" );
      ((Element)v.get(744)).appendChild((Element)v.get(745));

      /* Empieza nodo:746 / Elemento padre: 745   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(746)).setAttribute("src","b.gif" );
      ((Element)v.get(746)).setAttribute("width","8" );
      ((Element)v.get(746)).setAttribute("height","8" );
      ((Element)v.get(745)).appendChild((Element)v.get(746));
      /* Termina nodo:746   */
      /* Termina nodo:745   */
      /* Termina nodo:744   */

      /* Empieza nodo:747 / Elemento padre: 743   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(743)).appendChild((Element)v.get(747));

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
      ((Element)v.get(751)).setAttribute("nombre","lblNumPremio4" );
      ((Element)v.get(751)).setAttribute("alto","13" );
      ((Element)v.get(751)).setAttribute("filas","1" );
      ((Element)v.get(751)).setAttribute("valor","" );
      ((Element)v.get(751)).setAttribute("id","datosTitle" );
      ((Element)v.get(751)).setAttribute("cod","1691" );
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
      ((Element)v.get(747)).appendChild((Element)v.get(754));

      /* Empieza nodo:755 / Elemento padre: 754   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(755)).setAttribute("nombre","lblDescripcionLote4" );
      ((Element)v.get(755)).setAttribute("alto","13" );
      ((Element)v.get(755)).setAttribute("filas","1" );
      ((Element)v.get(755)).setAttribute("valor","" );
      ((Element)v.get(755)).setAttribute("id","datosTitle" );
      ((Element)v.get(755)).setAttribute("cod","844" );
      ((Element)v.get(754)).appendChild((Element)v.get(755));
      /* Termina nodo:755   */
      /* Termina nodo:754   */

      /* Empieza nodo:756 / Elemento padre: 747   */
      v.add(doc.createElement("td"));
   }

   private void getXML3240(Document doc) {
      ((Element)v.get(756)).setAttribute("width","100%" );
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

      /* Empieza nodo:758 / Elemento padre: 743   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(743)).appendChild((Element)v.get(758));

      /* Empieza nodo:759 / Elemento padre: 758   */
      v.add(doc.createElement("td"));
      ((Element)v.get(758)).appendChild((Element)v.get(759));

      /* Empieza nodo:760 / Elemento padre: 759   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(760)).setAttribute("src","b.gif" );
      ((Element)v.get(760)).setAttribute("width","8" );
      ((Element)v.get(760)).setAttribute("height","8" );
      ((Element)v.get(759)).appendChild((Element)v.get(760));
      /* Termina nodo:760   */
      /* Termina nodo:759   */

      /* Empieza nodo:761 / Elemento padre: 758   */
      v.add(doc.createElement("td"));
      ((Element)v.get(758)).appendChild((Element)v.get(761));

      /* Empieza nodo:762 / Elemento padre: 761   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(762)).setAttribute("nombre","lbNumPremio4" );
      ((Element)v.get(762)).setAttribute("alto","13" );
      ((Element)v.get(762)).setAttribute("filas","1" );
      ((Element)v.get(762)).setAttribute("id","datosCampos" );
      ((Element)v.get(762)).setAttribute("valor","" );
      ((Element)v.get(761)).appendChild((Element)v.get(762));
      /* Termina nodo:762   */
      /* Termina nodo:761   */

      /* Empieza nodo:763 / Elemento padre: 758   */
      v.add(doc.createElement("td"));
      ((Element)v.get(758)).appendChild((Element)v.get(763));

      /* Empieza nodo:764 / Elemento padre: 763   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(764)).setAttribute("src","b.gif" );
      ((Element)v.get(764)).setAttribute("width","25" );
      ((Element)v.get(764)).setAttribute("height","8" );
      ((Element)v.get(763)).appendChild((Element)v.get(764));
      /* Termina nodo:764   */
      /* Termina nodo:763   */

      /* Empieza nodo:765 / Elemento padre: 758   */
      v.add(doc.createElement("td"));
      ((Element)v.get(765)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(758)).appendChild((Element)v.get(765));

      /* Empieza nodo:766 / Elemento padre: 765   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(766)).setAttribute("nombre","txtDescripcionLote4" );
      ((Element)v.get(766)).setAttribute("id","datosCampos" );
      ((Element)v.get(766)).setAttribute("max","50" );
      ((Element)v.get(766)).setAttribute("tipo","" );
      ((Element)v.get(766)).setAttribute("onchange","" );
      ((Element)v.get(766)).setAttribute("req","N" );
      ((Element)v.get(766)).setAttribute("size","50" );
      ((Element)v.get(766)).setAttribute("valor","" );
      ((Element)v.get(766)).setAttribute("validacion","" );
      ((Element)v.get(765)).appendChild((Element)v.get(766));
      /* Termina nodo:766   */
      /* Termina nodo:765   */

      /* Empieza nodo:767 / Elemento padre: 758   */
      v.add(doc.createElement("td"));
      ((Element)v.get(767)).setAttribute("width","100%" );
      ((Element)v.get(758)).appendChild((Element)v.get(767));

      /* Empieza nodo:768 / Elemento padre: 767   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(768)).setAttribute("src","b.gif" );
      ((Element)v.get(768)).setAttribute("width","8" );
      ((Element)v.get(768)).setAttribute("height","8" );
      ((Element)v.get(767)).appendChild((Element)v.get(768));
      /* Termina nodo:768   */
      /* Termina nodo:767   */
      /* Termina nodo:758   */

      /* Empieza nodo:769 / Elemento padre: 743   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(743)).appendChild((Element)v.get(769));

      /* Empieza nodo:770 / Elemento padre: 769   */
      v.add(doc.createElement("td"));
      ((Element)v.get(770)).setAttribute("colspan","4" );
      ((Element)v.get(769)).appendChild((Element)v.get(770));

      /* Empieza nodo:771 / Elemento padre: 770   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(771)).setAttribute("src","b.gif" );
      ((Element)v.get(771)).setAttribute("width","8" );
      ((Element)v.get(771)).setAttribute("height","8" );
      ((Element)v.get(770)).appendChild((Element)v.get(771));
      /* Termina nodo:771   */
      /* Termina nodo:770   */
      /* Termina nodo:769   */
      /* Termina nodo:743   */
      /* Termina nodo:742   */
      /* Termina nodo:741   */
      /* Termina nodo:740   */
      /* Termina nodo:737   */
      /* Termina nodo:736   */

      /* Empieza nodo:772 / Elemento padre: 733   */
      v.add(doc.createElement("td"));
      ((Element)v.get(733)).appendChild((Element)v.get(772));

      /* Empieza nodo:773 / Elemento padre: 772   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(773)).setAttribute("src","b.gif" );
      ((Element)v.get(772)).appendChild((Element)v.get(773));
      /* Termina nodo:773   */
      /* Termina nodo:772   */
      /* Termina nodo:733   */

      /* Empieza nodo:774 / Elemento padre: 729   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(729)).appendChild((Element)v.get(774));

      /* Empieza nodo:775 / Elemento padre: 774   */
      v.add(doc.createElement("td"));
      ((Element)v.get(775)).setAttribute("width","12" );
      ((Element)v.get(775)).setAttribute("align","center" );
      ((Element)v.get(774)).appendChild((Element)v.get(775));

      /* Empieza nodo:776 / Elemento padre: 775   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(776)).setAttribute("src","b.gif" );
      ((Element)v.get(776)).setAttribute("width","12" );
      ((Element)v.get(776)).setAttribute("height","12" );
      ((Element)v.get(775)).appendChild((Element)v.get(776));
      /* Termina nodo:776   */
      /* Termina nodo:775   */

      /* Empieza nodo:777 / Elemento padre: 774   */
      v.add(doc.createElement("td"));
      ((Element)v.get(777)).setAttribute("width","756" );
      ((Element)v.get(774)).appendChild((Element)v.get(777));

      /* Empieza nodo:778 / Elemento padre: 777   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(778)).setAttribute("src","b.gif" );
      ((Element)v.get(777)).appendChild((Element)v.get(778));
      /* Termina nodo:778   */
      /* Termina nodo:777   */

      /* Empieza nodo:779 / Elemento padre: 774   */
      v.add(doc.createElement("td"));
      ((Element)v.get(779)).setAttribute("width","12" );
      ((Element)v.get(774)).appendChild((Element)v.get(779));

      /* Empieza nodo:780 / Elemento padre: 779   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML3330(Document doc) {
      ((Element)v.get(780)).setAttribute("src","b.gif" );
      ((Element)v.get(780)).setAttribute("width","12" );
      ((Element)v.get(780)).setAttribute("height","1" );
      ((Element)v.get(779)).appendChild((Element)v.get(780));
      /* Termina nodo:780   */
      /* Termina nodo:779   */
      /* Termina nodo:774   */
      /* Termina nodo:729   */
      /* Termina nodo:728   */
      /* Termina nodo:727   */
      /* Termina nodo:581   */
      /* Termina nodo:578   */
      /* Termina nodo:577   */

      /* Empieza nodo:781 / Elemento padre: 574   */
      v.add(doc.createElement("td"));
      ((Element)v.get(574)).appendChild((Element)v.get(781));

      /* Empieza nodo:782 / Elemento padre: 781   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(782)).setAttribute("src","b.gif" );
      ((Element)v.get(781)).appendChild((Element)v.get(782));
      /* Termina nodo:782   */
      /* Termina nodo:781   */
      /* Termina nodo:574   */

      /* Empieza nodo:783 / Elemento padre: 560   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(560)).appendChild((Element)v.get(783));

      /* Empieza nodo:784 / Elemento padre: 783   */
      v.add(doc.createElement("td"));
      ((Element)v.get(783)).appendChild((Element)v.get(784));

      /* Empieza nodo:785 / Elemento padre: 784   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(785)).setAttribute("src","b.gif" );
      ((Element)v.get(784)).appendChild((Element)v.get(785));
      /* Termina nodo:785   */
      /* Termina nodo:784   */

      /* Empieza nodo:786 / Elemento padre: 783   */
      v.add(doc.createElement("td"));
      ((Element)v.get(783)).appendChild((Element)v.get(786));

      /* Empieza nodo:787 / Elemento padre: 786   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(786)).appendChild((Element)v.get(787));

      /* Empieza nodo:788 / Elemento padre: 787   */
      v.add(doc.createElement("table"));
      ((Element)v.get(788)).setAttribute("width","100%" );
      ((Element)v.get(788)).setAttribute("border","0" );
      ((Element)v.get(788)).setAttribute("align","center" );
      ((Element)v.get(788)).setAttribute("cellspacing","0" );
      ((Element)v.get(788)).setAttribute("cellpadding","0" );
      ((Element)v.get(787)).appendChild((Element)v.get(788));

      /* Empieza nodo:789 / Elemento padre: 788   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(788)).appendChild((Element)v.get(789));

      /* Empieza nodo:790 / Elemento padre: 789   */
      v.add(doc.createElement("td"));
      ((Element)v.get(790)).setAttribute("class","botonera" );
      ((Element)v.get(789)).appendChild((Element)v.get(790));

      /* Empieza nodo:791 / Elemento padre: 790   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(791)).setAttribute("nombre","btnAnadirLotes" );
      ((Element)v.get(791)).setAttribute("ID","botonContenido" );
      ((Element)v.get(791)).setAttribute("tipo","html" );
      ((Element)v.get(791)).setAttribute("accion","accionAniadirLotePremio();" );
      ((Element)v.get(791)).setAttribute("estado","false" );
      ((Element)v.get(791)).setAttribute("cod","404" );
      ((Element)v.get(790)).appendChild((Element)v.get(791));
      /* Termina nodo:791   */
      /* Termina nodo:790   */
      /* Termina nodo:789   */
      /* Termina nodo:788   */
      /* Termina nodo:787   */
      /* Termina nodo:786   */

      /* Empieza nodo:792 / Elemento padre: 783   */
      v.add(doc.createElement("td"));
      ((Element)v.get(783)).appendChild((Element)v.get(792));

      /* Empieza nodo:793 / Elemento padre: 792   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(793)).setAttribute("src","b.gif" );
      ((Element)v.get(793)).setAttribute("width","8" );
      ((Element)v.get(793)).setAttribute("height","12" );
      ((Element)v.get(792)).appendChild((Element)v.get(793));
      /* Termina nodo:793   */
      /* Termina nodo:792   */
      /* Termina nodo:783   */

      /* Empieza nodo:794 / Elemento padre: 560   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(560)).appendChild((Element)v.get(794));

      /* Empieza nodo:795 / Elemento padre: 794   */
      v.add(doc.createElement("td"));
      ((Element)v.get(795)).setAttribute("width","12" );
      ((Element)v.get(795)).setAttribute("align","center" );
      ((Element)v.get(794)).appendChild((Element)v.get(795));

      /* Empieza nodo:796 / Elemento padre: 795   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(796)).setAttribute("src","b.gif" );
      ((Element)v.get(796)).setAttribute("width","12" );
      ((Element)v.get(796)).setAttribute("height","12" );
      ((Element)v.get(795)).appendChild((Element)v.get(796));
      /* Termina nodo:796   */
      /* Termina nodo:795   */

      /* Empieza nodo:797 / Elemento padre: 794   */
      v.add(doc.createElement("td"));
      ((Element)v.get(797)).setAttribute("width","750" );
      ((Element)v.get(794)).appendChild((Element)v.get(797));

      /* Empieza nodo:798 / Elemento padre: 797   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(798)).setAttribute("src","b.gif" );
      ((Element)v.get(797)).appendChild((Element)v.get(798));
      /* Termina nodo:798   */
      /* Termina nodo:797   */

      /* Empieza nodo:799 / Elemento padre: 794   */
      v.add(doc.createElement("td"));
      ((Element)v.get(799)).setAttribute("width","12" );
      ((Element)v.get(794)).appendChild((Element)v.get(799));

      /* Empieza nodo:800 / Elemento padre: 799   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(800)).setAttribute("src","b.gif" );
      ((Element)v.get(800)).setAttribute("width","12" );
      ((Element)v.get(800)).setAttribute("height","1" );
      ((Element)v.get(799)).appendChild((Element)v.get(800));
      /* Termina nodo:800   */
      /* Termina nodo:799   */
      /* Termina nodo:794   */
      /* Termina nodo:560   */
      /* Termina nodo:557   */
      /* Termina nodo:556   */

      /* Empieza nodo:801 / Elemento padre: 553   */
      v.add(doc.createElement("td"));
      ((Element)v.get(553)).appendChild((Element)v.get(801));

      /* Empieza nodo:802 / Elemento padre: 801   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(802)).setAttribute("src","b.gif" );
      ((Element)v.get(801)).appendChild((Element)v.get(802));
      /* Termina nodo:802   */
      /* Termina nodo:801   */
      /* Termina nodo:553   */

      /* Empieza nodo:803 / Elemento padre: 545   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(545)).appendChild((Element)v.get(803));

      /* Empieza nodo:804 / Elemento padre: 803   */
      v.add(doc.createElement("td"));
      ((Element)v.get(803)).appendChild((Element)v.get(804));

      /* Empieza nodo:805 / Elemento padre: 804   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(805)).setAttribute("src","b.gif" );
      ((Element)v.get(804)).appendChild((Element)v.get(805));
      /* Termina nodo:805   */
      /* Termina nodo:804   */

      /* Empieza nodo:806 / Elemento padre: 803   */
      v.add(doc.createElement("td"));
      ((Element)v.get(803)).appendChild((Element)v.get(806));

      /* Empieza nodo:807 / Elemento padre: 806   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(806)).appendChild((Element)v.get(807));

      /* Empieza nodo:808 / Elemento padre: 807   */
      v.add(doc.createElement("table"));
      ((Element)v.get(808)).setAttribute("width","100%" );
   }

   private void getXML3420(Document doc) {
      ((Element)v.get(808)).setAttribute("border","0" );
      ((Element)v.get(808)).setAttribute("align","center" );
      ((Element)v.get(808)).setAttribute("cellspacing","0" );
      ((Element)v.get(808)).setAttribute("cellpadding","0" );
      ((Element)v.get(807)).appendChild((Element)v.get(808));

      /* Empieza nodo:809 / Elemento padre: 808   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(808)).appendChild((Element)v.get(809));

      /* Empieza nodo:810 / Elemento padre: 809   */
      v.add(doc.createElement("td"));
      ((Element)v.get(810)).setAttribute("class","botonera" );
      ((Element)v.get(809)).appendChild((Element)v.get(810));

      /* Empieza nodo:811 / Elemento padre: 810   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(811)).setAttribute("nombre","btnEliminarProductos" );
      ((Element)v.get(811)).setAttribute("ID","botonContenido" );
      ((Element)v.get(811)).setAttribute("tipo","html" );
      ((Element)v.get(811)).setAttribute("accion","accionEliminarProductos();" );
      ((Element)v.get(811)).setAttribute("estado","false" );
      ((Element)v.get(811)).setAttribute("cod","2459" );
      ((Element)v.get(810)).appendChild((Element)v.get(811));
      /* Termina nodo:811   */

      /* Empieza nodo:812 / Elemento padre: 810   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(812)).setAttribute("nombre","btnEliminarLotes" );
      ((Element)v.get(812)).setAttribute("ID","botonContenido" );
      ((Element)v.get(812)).setAttribute("tipo","html" );
      ((Element)v.get(812)).setAttribute("accion","accionEliminarLotes();" );
      ((Element)v.get(812)).setAttribute("estado","false" );
      ((Element)v.get(812)).setAttribute("cod","2458" );
      ((Element)v.get(810)).appendChild((Element)v.get(812));
      /* Termina nodo:812   */

      /* Empieza nodo:813 / Elemento padre: 810   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(813)).setAttribute("nombre","btnAceptar3" );
      ((Element)v.get(813)).setAttribute("ID","botonContenido" );
      ((Element)v.get(813)).setAttribute("tipo","html" );
      ((Element)v.get(813)).setAttribute("accion","accionAceptar(get('formulario.OID_TIPO_PREMIO_ARTICULO'));" );
      ((Element)v.get(813)).setAttribute("estado","false" );
      ((Element)v.get(813)).setAttribute("cod","12" );
      ((Element)v.get(810)).appendChild((Element)v.get(813));
      /* Termina nodo:813   */
      /* Termina nodo:810   */
      /* Termina nodo:809   */
      /* Termina nodo:808   */
      /* Termina nodo:807   */
      /* Termina nodo:806   */

      /* Empieza nodo:814 / Elemento padre: 803   */
      v.add(doc.createElement("td"));
      ((Element)v.get(803)).appendChild((Element)v.get(814));

      /* Empieza nodo:815 / Elemento padre: 814   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(815)).setAttribute("src","b.gif" );
      ((Element)v.get(815)).setAttribute("width","8" );
      ((Element)v.get(815)).setAttribute("height","12" );
      ((Element)v.get(814)).appendChild((Element)v.get(815));
      /* Termina nodo:815   */
      /* Termina nodo:814   */
      /* Termina nodo:803   */

      /* Empieza nodo:816 / Elemento padre: 545   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(545)).appendChild((Element)v.get(816));

      /* Empieza nodo:817 / Elemento padre: 816   */
      v.add(doc.createElement("td"));
      ((Element)v.get(817)).setAttribute("width","12" );
      ((Element)v.get(817)).setAttribute("align","center" );
      ((Element)v.get(816)).appendChild((Element)v.get(817));

      /* Empieza nodo:818 / Elemento padre: 817   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(818)).setAttribute("src","b.gif" );
      ((Element)v.get(818)).setAttribute("width","12" );
      ((Element)v.get(818)).setAttribute("height","12" );
      ((Element)v.get(817)).appendChild((Element)v.get(818));
      /* Termina nodo:818   */
      /* Termina nodo:817   */

      /* Empieza nodo:819 / Elemento padre: 816   */
      v.add(doc.createElement("td"));
      ((Element)v.get(819)).setAttribute("width","756" );
      ((Element)v.get(816)).appendChild((Element)v.get(819));

      /* Empieza nodo:820 / Elemento padre: 819   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(820)).setAttribute("src","b.gif" );
      ((Element)v.get(819)).appendChild((Element)v.get(820));
      /* Termina nodo:820   */
      /* Termina nodo:819   */

      /* Empieza nodo:821 / Elemento padre: 816   */
      v.add(doc.createElement("td"));
      ((Element)v.get(821)).setAttribute("width","12" );
      ((Element)v.get(816)).appendChild((Element)v.get(821));

      /* Empieza nodo:822 / Elemento padre: 821   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(822)).setAttribute("src","b.gif" );
      ((Element)v.get(822)).setAttribute("width","12" );
      ((Element)v.get(822)).setAttribute("height","1" );
      ((Element)v.get(821)).appendChild((Element)v.get(822));
      /* Termina nodo:822   */
      /* Termina nodo:821   */
      /* Termina nodo:816   */
      /* Termina nodo:545   */
      /* Termina nodo:544   */

      /* Empieza nodo:823 / Elemento padre: 36   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(823)).setAttribute("nombre","capa5" );
      ((Element)v.get(823)).setAttribute("alto","670" );
      ((Element)v.get(823)).setAttribute("ancho","100%" );
      ((Element)v.get(823)).setAttribute("colorf","" );
      ((Element)v.get(823)).setAttribute("borde","0" );
      ((Element)v.get(823)).setAttribute("imagenf","" );
      ((Element)v.get(823)).setAttribute("repeat","" );
      ((Element)v.get(823)).setAttribute("padding","" );
      ((Element)v.get(823)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(823)).setAttribute("contravsb","" );
      ((Element)v.get(823)).setAttribute("x","0" );
      ((Element)v.get(823)).setAttribute("y","341" );
      ((Element)v.get(823)).setAttribute("zindex","" );
      ((Element)v.get(36)).appendChild((Element)v.get(823));

      /* Empieza nodo:824 / Elemento padre: 823   */
      v.add(doc.createElement("table"));
      ((Element)v.get(824)).setAttribute("width","100%" );
      ((Element)v.get(824)).setAttribute("border","0" );
      ((Element)v.get(824)).setAttribute("cellspacing","0" );
      ((Element)v.get(824)).setAttribute("cellpadding","0" );
      ((Element)v.get(823)).appendChild((Element)v.get(824));

      /* Empieza nodo:825 / Elemento padre: 824   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(824)).appendChild((Element)v.get(825));

      /* Empieza nodo:826 / Elemento padre: 825   */
      v.add(doc.createElement("td"));
   }

   private void getXML3510(Document doc) {
      ((Element)v.get(826)).setAttribute("width","12" );
      ((Element)v.get(826)).setAttribute("align","center" );
      ((Element)v.get(825)).appendChild((Element)v.get(826));

      /* Empieza nodo:827 / Elemento padre: 826   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(827)).setAttribute("src","b.gif" );
      ((Element)v.get(827)).setAttribute("width","12" );
      ((Element)v.get(827)).setAttribute("height","12" );
      ((Element)v.get(826)).appendChild((Element)v.get(827));
      /* Termina nodo:827   */
      /* Termina nodo:826   */

      /* Empieza nodo:828 / Elemento padre: 825   */
      v.add(doc.createElement("td"));
      ((Element)v.get(828)).setAttribute("width","750" );
      ((Element)v.get(825)).appendChild((Element)v.get(828));

      /* Empieza nodo:829 / Elemento padre: 828   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(829)).setAttribute("src","b.gif" );
      ((Element)v.get(828)).appendChild((Element)v.get(829));
      /* Termina nodo:829   */
      /* Termina nodo:828   */

      /* Empieza nodo:830 / Elemento padre: 825   */
      v.add(doc.createElement("td"));
      ((Element)v.get(830)).setAttribute("width","12" );
      ((Element)v.get(825)).appendChild((Element)v.get(830));

      /* Empieza nodo:831 / Elemento padre: 830   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(831)).setAttribute("src","b.gif" );
      ((Element)v.get(831)).setAttribute("width","12" );
      ((Element)v.get(831)).setAttribute("height","1" );
      ((Element)v.get(830)).appendChild((Element)v.get(831));
      /* Termina nodo:831   */
      /* Termina nodo:830   */
      /* Termina nodo:825   */

      /* Empieza nodo:832 / Elemento padre: 824   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(824)).appendChild((Element)v.get(832));

      /* Empieza nodo:833 / Elemento padre: 832   */
      v.add(doc.createElement("td"));
      ((Element)v.get(832)).appendChild((Element)v.get(833));

      /* Empieza nodo:834 / Elemento padre: 833   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(834)).setAttribute("src","b.gif" );
      ((Element)v.get(833)).appendChild((Element)v.get(834));
      /* Termina nodo:834   */
      /* Termina nodo:833   */

      /* Empieza nodo:835 / Elemento padre: 832   */
      v.add(doc.createElement("td"));
      ((Element)v.get(832)).appendChild((Element)v.get(835));

      /* Empieza nodo:836 / Elemento padre: 835   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(835)).appendChild((Element)v.get(836));

      /* Empieza nodo:837 / Elemento padre: 836   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(837)).setAttribute("class","legend" );
      ((Element)v.get(836)).appendChild((Element)v.get(837));

      /* Empieza nodo:838 / Elemento padre: 837   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(838)).setAttribute("nombre","lblDatosPremiosDescuento" );
      ((Element)v.get(838)).setAttribute("alto","13" );
      ((Element)v.get(838)).setAttribute("filas","1" );
      ((Element)v.get(838)).setAttribute("valor","" );
      ((Element)v.get(838)).setAttribute("id","legend" );
      ((Element)v.get(838)).setAttribute("cod","00355" );
      ((Element)v.get(837)).appendChild((Element)v.get(838));
      /* Termina nodo:838   */
      /* Termina nodo:837   */

      /* Empieza nodo:839 / Elemento padre: 836   */
      v.add(doc.createElement("table"));
      ((Element)v.get(839)).setAttribute("width","100%" );
      ((Element)v.get(839)).setAttribute("border","0" );
      ((Element)v.get(839)).setAttribute("align","center" );
      ((Element)v.get(839)).setAttribute("cellspacing","0" );
      ((Element)v.get(839)).setAttribute("cellpadding","0" );
      ((Element)v.get(836)).appendChild((Element)v.get(839));

      /* Empieza nodo:840 / Elemento padre: 839   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(839)).appendChild((Element)v.get(840));

      /* Empieza nodo:841 / Elemento padre: 840   */
      v.add(doc.createElement("td"));
      ((Element)v.get(840)).appendChild((Element)v.get(841));

      /* Empieza nodo:842 / Elemento padre: 841   */
      v.add(doc.createElement("table"));
      ((Element)v.get(842)).setAttribute("width","728" );
      ((Element)v.get(842)).setAttribute("border","0" );
      ((Element)v.get(842)).setAttribute("align","left" );
      ((Element)v.get(842)).setAttribute("cellspacing","0" );
      ((Element)v.get(842)).setAttribute("cellpadding","0" );
      ((Element)v.get(841)).appendChild((Element)v.get(842));

      /* Empieza nodo:843 / Elemento padre: 842   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(842)).appendChild((Element)v.get(843));

      /* Empieza nodo:844 / Elemento padre: 843   */
      v.add(doc.createElement("td"));
      ((Element)v.get(844)).setAttribute("colspan","4" );
      ((Element)v.get(843)).appendChild((Element)v.get(844));

      /* Empieza nodo:845 / Elemento padre: 844   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(845)).setAttribute("src","b.gif" );
      ((Element)v.get(845)).setAttribute("width","8" );
      ((Element)v.get(845)).setAttribute("height","8" );
      ((Element)v.get(844)).appendChild((Element)v.get(845));
      /* Termina nodo:845   */
      /* Termina nodo:844   */
      /* Termina nodo:843   */

      /* Empieza nodo:846 / Elemento padre: 842   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(842)).appendChild((Element)v.get(846));

      /* Empieza nodo:847 / Elemento padre: 846   */
      v.add(doc.createElement("td"));
      ((Element)v.get(846)).appendChild((Element)v.get(847));

      /* Empieza nodo:848 / Elemento padre: 847   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(848)).setAttribute("src","b.gif" );
      ((Element)v.get(848)).setAttribute("width","8" );
      ((Element)v.get(848)).setAttribute("height","8" );
      ((Element)v.get(847)).appendChild((Element)v.get(848));
      /* Termina nodo:848   */
      /* Termina nodo:847   */

      /* Empieza nodo:849 / Elemento padre: 846   */
      v.add(doc.createElement("td"));
      ((Element)v.get(846)).appendChild((Element)v.get(849));

      /* Empieza nodo:850 / Elemento padre: 849   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(850)).setAttribute("nombre","lblNumPremio5" );
      ((Element)v.get(850)).setAttribute("alto","13" );
      ((Element)v.get(850)).setAttribute("filas","1" );
      ((Element)v.get(850)).setAttribute("valor","" );
      ((Element)v.get(850)).setAttribute("id","datosTitle" );
      ((Element)v.get(850)).setAttribute("cod","1691" );
   }

   private void getXML3600(Document doc) {
      ((Element)v.get(849)).appendChild((Element)v.get(850));
      /* Termina nodo:850   */
      /* Termina nodo:849   */

      /* Empieza nodo:851 / Elemento padre: 846   */
      v.add(doc.createElement("td"));
      ((Element)v.get(846)).appendChild((Element)v.get(851));

      /* Empieza nodo:852 / Elemento padre: 851   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(852)).setAttribute("src","b.gif" );
      ((Element)v.get(852)).setAttribute("width","25" );
      ((Element)v.get(852)).setAttribute("height","8" );
      ((Element)v.get(851)).appendChild((Element)v.get(852));
      /* Termina nodo:852   */
      /* Termina nodo:851   */

      /* Empieza nodo:853 / Elemento padre: 846   */
      v.add(doc.createElement("td"));
      ((Element)v.get(846)).appendChild((Element)v.get(853));

      /* Empieza nodo:854 / Elemento padre: 853   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(854)).setAttribute("nombre","lblTipoPremioDescuento5" );
      ((Element)v.get(854)).setAttribute("alto","13" );
      ((Element)v.get(854)).setAttribute("filas","1" );
      ((Element)v.get(854)).setAttribute("valor","" );
      ((Element)v.get(854)).setAttribute("id","datosTitle" );
      ((Element)v.get(854)).setAttribute("cod","1855" );
      ((Element)v.get(853)).appendChild((Element)v.get(854));
      /* Termina nodo:854   */
      /* Termina nodo:853   */

      /* Empieza nodo:855 / Elemento padre: 846   */
      v.add(doc.createElement("td"));
      ((Element)v.get(846)).appendChild((Element)v.get(855));

      /* Empieza nodo:856 / Elemento padre: 855   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(856)).setAttribute("src","b.gif" );
      ((Element)v.get(856)).setAttribute("width","25" );
      ((Element)v.get(856)).setAttribute("height","8" );
      ((Element)v.get(855)).appendChild((Element)v.get(856));
      /* Termina nodo:856   */
      /* Termina nodo:855   */

      /* Empieza nodo:857 / Elemento padre: 846   */
      v.add(doc.createElement("td"));
      ((Element)v.get(846)).appendChild((Element)v.get(857));

      /* Empieza nodo:858 / Elemento padre: 857   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(858)).setAttribute("nombre","lblCantidadDescuento" );
      ((Element)v.get(858)).setAttribute("alto","13" );
      ((Element)v.get(858)).setAttribute("filas","1" );
      ((Element)v.get(858)).setAttribute("valor","" );
      ((Element)v.get(858)).setAttribute("id","datosTitle" );
      ((Element)v.get(858)).setAttribute("cod","1856" );
      ((Element)v.get(857)).appendChild((Element)v.get(858));
      /* Termina nodo:858   */
      /* Termina nodo:857   */

      /* Empieza nodo:859 / Elemento padre: 846   */
      v.add(doc.createElement("td"));
      ((Element)v.get(846)).appendChild((Element)v.get(859));

      /* Empieza nodo:860 / Elemento padre: 859   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(860)).setAttribute("src","b.gif" );
      ((Element)v.get(860)).setAttribute("width","25" );
      ((Element)v.get(860)).setAttribute("height","8" );
      ((Element)v.get(859)).appendChild((Element)v.get(860));
      /* Termina nodo:860   */
      /* Termina nodo:859   */

      /* Empieza nodo:861 / Elemento padre: 846   */
      v.add(doc.createElement("td"));
      ((Element)v.get(846)).appendChild((Element)v.get(861));

      /* Empieza nodo:862 / Elemento padre: 861   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(862)).setAttribute("nombre","lblPorcentaje5" );
      ((Element)v.get(862)).setAttribute("alto","13" );
      ((Element)v.get(862)).setAttribute("filas","1" );
      ((Element)v.get(862)).setAttribute("valor","" );
      ((Element)v.get(862)).setAttribute("id","datosTitle" );
      ((Element)v.get(862)).setAttribute("cod","790" );
      ((Element)v.get(861)).appendChild((Element)v.get(862));
      /* Termina nodo:862   */
      /* Termina nodo:861   */

      /* Empieza nodo:863 / Elemento padre: 846   */
      v.add(doc.createElement("td"));
      ((Element)v.get(846)).appendChild((Element)v.get(863));

      /* Empieza nodo:864 / Elemento padre: 863   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(864)).setAttribute("src","b.gif" );
      ((Element)v.get(864)).setAttribute("width","25" );
      ((Element)v.get(864)).setAttribute("height","8" );
      ((Element)v.get(863)).appendChild((Element)v.get(864));
      /* Termina nodo:864   */
      /* Termina nodo:863   */

      /* Empieza nodo:865 / Elemento padre: 846   */
      v.add(doc.createElement("td"));
      ((Element)v.get(846)).appendChild((Element)v.get(865));

      /* Empieza nodo:866 / Elemento padre: 865   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(866)).setAttribute("nombre","lblPeriodoAplicacionDesde" );
      ((Element)v.get(866)).setAttribute("alto","13" );
      ((Element)v.get(866)).setAttribute("filas","1" );
      ((Element)v.get(866)).setAttribute("valor","" );
      ((Element)v.get(866)).setAttribute("id","datosTitle" );
      ((Element)v.get(866)).setAttribute("cod","1899" );
      ((Element)v.get(865)).appendChild((Element)v.get(866));
      /* Termina nodo:866   */
      /* Termina nodo:865   */

      /* Empieza nodo:867 / Elemento padre: 846   */
      v.add(doc.createElement("td"));
      ((Element)v.get(846)).appendChild((Element)v.get(867));

      /* Empieza nodo:868 / Elemento padre: 867   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(868)).setAttribute("src","b.gif" );
      ((Element)v.get(868)).setAttribute("width","25" );
      ((Element)v.get(868)).setAttribute("height","8" );
      ((Element)v.get(867)).appendChild((Element)v.get(868));
      /* Termina nodo:868   */
      /* Termina nodo:867   */

      /* Empieza nodo:869 / Elemento padre: 846   */
      v.add(doc.createElement("td"));
      ((Element)v.get(846)).appendChild((Element)v.get(869));

      /* Empieza nodo:870 / Elemento padre: 869   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(870)).setAttribute("nombre","lblPeriodoAplicacionHasta" );
      ((Element)v.get(870)).setAttribute("alto","13" );
      ((Element)v.get(870)).setAttribute("filas","1" );
      ((Element)v.get(870)).setAttribute("valor","" );
      ((Element)v.get(870)).setAttribute("id","datosTitle" );
      ((Element)v.get(870)).setAttribute("cod","1900" );
      ((Element)v.get(869)).appendChild((Element)v.get(870));
      /* Termina nodo:870   */
      /* Termina nodo:869   */

      /* Empieza nodo:871 / Elemento padre: 846   */
      v.add(doc.createElement("td"));
      ((Element)v.get(871)).setAttribute("width","100%" );
      ((Element)v.get(846)).appendChild((Element)v.get(871));

      /* Empieza nodo:872 / Elemento padre: 871   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML3690(Document doc) {
      ((Element)v.get(872)).setAttribute("src","b.gif" );
      ((Element)v.get(872)).setAttribute("width","8" );
      ((Element)v.get(872)).setAttribute("height","8" );
      ((Element)v.get(871)).appendChild((Element)v.get(872));
      /* Termina nodo:872   */
      /* Termina nodo:871   */
      /* Termina nodo:846   */

      /* Empieza nodo:873 / Elemento padre: 842   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(842)).appendChild((Element)v.get(873));

      /* Empieza nodo:874 / Elemento padre: 873   */
      v.add(doc.createElement("td"));
      ((Element)v.get(873)).appendChild((Element)v.get(874));

      /* Empieza nodo:875 / Elemento padre: 874   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(875)).setAttribute("src","b.gif" );
      ((Element)v.get(875)).setAttribute("width","8" );
      ((Element)v.get(875)).setAttribute("height","8" );
      ((Element)v.get(874)).appendChild((Element)v.get(875));
      /* Termina nodo:875   */
      /* Termina nodo:874   */

      /* Empieza nodo:876 / Elemento padre: 873   */
      v.add(doc.createElement("td"));
      ((Element)v.get(873)).appendChild((Element)v.get(876));

      /* Empieza nodo:877 / Elemento padre: 876   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(877)).setAttribute("nombre","lbNumPremio5" );
      ((Element)v.get(877)).setAttribute("alto","13" );
      ((Element)v.get(877)).setAttribute("filas","1" );
      ((Element)v.get(877)).setAttribute("valor","" );
      ((Element)v.get(877)).setAttribute("id","datosCampos" );
      ((Element)v.get(876)).appendChild((Element)v.get(877));
      /* Termina nodo:877   */
      /* Termina nodo:876   */

      /* Empieza nodo:878 / Elemento padre: 873   */
      v.add(doc.createElement("td"));
      ((Element)v.get(873)).appendChild((Element)v.get(878));

      /* Empieza nodo:879 / Elemento padre: 878   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(879)).setAttribute("src","b.gif" );
      ((Element)v.get(879)).setAttribute("width","25" );
      ((Element)v.get(879)).setAttribute("height","8" );
      ((Element)v.get(878)).appendChild((Element)v.get(879));
      /* Termina nodo:879   */
      /* Termina nodo:878   */

      /* Empieza nodo:880 / Elemento padre: 873   */
      v.add(doc.createElement("td"));
      ((Element)v.get(880)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(873)).appendChild((Element)v.get(880));

      /* Empieza nodo:881 / Elemento padre: 880   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(881)).setAttribute("nombre","cbTipoPremioDescuento5" );
      ((Element)v.get(881)).setAttribute("id","datosCampos" );
      ((Element)v.get(881)).setAttribute("size","1" );
      ((Element)v.get(881)).setAttribute("onchange","onChangeTipoPremioDescuento();" );
      ((Element)v.get(881)).setAttribute("multiple","N" );
      ((Element)v.get(881)).setAttribute("req","S" );
      ((Element)v.get(881)).setAttribute("valorinicial","" );
      ((Element)v.get(881)).setAttribute("textoinicial","" );
      ((Element)v.get(880)).appendChild((Element)v.get(881));

      /* Empieza nodo:882 / Elemento padre: 881   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(881)).appendChild((Element)v.get(882));
      /* Termina nodo:882   */
      /* Termina nodo:881   */
      /* Termina nodo:880   */

      /* Empieza nodo:883 / Elemento padre: 873   */
      v.add(doc.createElement("td"));
      ((Element)v.get(873)).appendChild((Element)v.get(883));

      /* Empieza nodo:884 / Elemento padre: 883   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(884)).setAttribute("src","b.gif" );
      ((Element)v.get(884)).setAttribute("width","25" );
      ((Element)v.get(884)).setAttribute("height","8" );
      ((Element)v.get(883)).appendChild((Element)v.get(884));
      /* Termina nodo:884   */
      /* Termina nodo:883   */

      /* Empieza nodo:885 / Elemento padre: 873   */
      v.add(doc.createElement("td"));
      ((Element)v.get(885)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(885)).setAttribute("valing","bottom" );
      ((Element)v.get(873)).appendChild((Element)v.get(885));

      /* Empieza nodo:886 / Elemento padre: 885   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(886)).setAttribute("nombre","txtCantidadDescuento" );
      ((Element)v.get(886)).setAttribute("id","datosCampos" );
      ((Element)v.get(886)).setAttribute("max","8" );
      ((Element)v.get(886)).setAttribute("tipo","" );
      ((Element)v.get(886)).setAttribute("onchange","" );
      ((Element)v.get(886)).setAttribute("req","N" );
      ((Element)v.get(886)).setAttribute("size","6" );
      ((Element)v.get(886)).setAttribute("valor","" );
      ((Element)v.get(886)).setAttribute("validacion","" );
      ((Element)v.get(885)).appendChild((Element)v.get(886));
      /* Termina nodo:886   */
      /* Termina nodo:885   */

      /* Empieza nodo:887 / Elemento padre: 873   */
      v.add(doc.createElement("td"));
      ((Element)v.get(873)).appendChild((Element)v.get(887));

      /* Empieza nodo:888 / Elemento padre: 887   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(888)).setAttribute("src","b.gif" );
      ((Element)v.get(888)).setAttribute("width","25" );
      ((Element)v.get(888)).setAttribute("height","8" );
      ((Element)v.get(887)).appendChild((Element)v.get(888));
      /* Termina nodo:888   */
      /* Termina nodo:887   */

      /* Empieza nodo:889 / Elemento padre: 873   */
      v.add(doc.createElement("td"));
      ((Element)v.get(889)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(889)).setAttribute("valing","bottom" );
      ((Element)v.get(873)).appendChild((Element)v.get(889));

      /* Empieza nodo:890 / Elemento padre: 889   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(890)).setAttribute("nombre","txtPorcentaje5" );
      ((Element)v.get(890)).setAttribute("id","datosCampos" );
      ((Element)v.get(890)).setAttribute("max","6" );
      ((Element)v.get(890)).setAttribute("tipo","" );
      ((Element)v.get(890)).setAttribute("onchange","" );
      ((Element)v.get(890)).setAttribute("req","N" );
      ((Element)v.get(890)).setAttribute("size","6" );
      ((Element)v.get(890)).setAttribute("valor","" );
      ((Element)v.get(890)).setAttribute("validacion","" );
      ((Element)v.get(889)).appendChild((Element)v.get(890));
      /* Termina nodo:890   */
      /* Termina nodo:889   */

      /* Empieza nodo:891 / Elemento padre: 873   */
      v.add(doc.createElement("td"));
      ((Element)v.get(873)).appendChild((Element)v.get(891));

      /* Empieza nodo:892 / Elemento padre: 891   */
   }

   private void getXML3780(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(892)).setAttribute("src","b.gif" );
      ((Element)v.get(892)).setAttribute("width","25" );
      ((Element)v.get(892)).setAttribute("height","8" );
      ((Element)v.get(891)).appendChild((Element)v.get(892));
      /* Termina nodo:892   */
      /* Termina nodo:891   */

      /* Empieza nodo:893 / Elemento padre: 873   */
      v.add(doc.createElement("td"));
      ((Element)v.get(893)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(873)).appendChild((Element)v.get(893));

      /* Empieza nodo:894 / Elemento padre: 893   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(894)).setAttribute("nombre","cbPeriodoAplicacionDesde" );
      ((Element)v.get(894)).setAttribute("id","datosCampos" );
      ((Element)v.get(894)).setAttribute("size","1" );
      ((Element)v.get(894)).setAttribute("multiple","N" );
      ((Element)v.get(894)).setAttribute("req","S" );
      ((Element)v.get(894)).setAttribute("valorinicial","" );
      ((Element)v.get(894)).setAttribute("textoinicial","" );
      ((Element)v.get(893)).appendChild((Element)v.get(894));

      /* Empieza nodo:895 / Elemento padre: 894   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(894)).appendChild((Element)v.get(895));
      /* Termina nodo:895   */
      /* Termina nodo:894   */
      /* Termina nodo:893   */

      /* Empieza nodo:896 / Elemento padre: 873   */
      v.add(doc.createElement("td"));
      ((Element)v.get(873)).appendChild((Element)v.get(896));

      /* Empieza nodo:897 / Elemento padre: 896   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(897)).setAttribute("src","b.gif" );
      ((Element)v.get(897)).setAttribute("width","25" );
      ((Element)v.get(897)).setAttribute("height","8" );
      ((Element)v.get(896)).appendChild((Element)v.get(897));
      /* Termina nodo:897   */
      /* Termina nodo:896   */

      /* Empieza nodo:898 / Elemento padre: 873   */
      v.add(doc.createElement("td"));
      ((Element)v.get(898)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(873)).appendChild((Element)v.get(898));

      /* Empieza nodo:899 / Elemento padre: 898   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(899)).setAttribute("nombre","cbPeriodoAplicacionHasta" );
      ((Element)v.get(899)).setAttribute("id","datosCampos" );
      ((Element)v.get(899)).setAttribute("size","1" );
      ((Element)v.get(899)).setAttribute("multiple","N" );
      ((Element)v.get(899)).setAttribute("req","N" );
      ((Element)v.get(899)).setAttribute("valorinicial","" );
      ((Element)v.get(899)).setAttribute("textoinicial","" );
      ((Element)v.get(898)).appendChild((Element)v.get(899));

      /* Empieza nodo:900 / Elemento padre: 899   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(899)).appendChild((Element)v.get(900));
      /* Termina nodo:900   */
      /* Termina nodo:899   */
      /* Termina nodo:898   */

      /* Empieza nodo:901 / Elemento padre: 873   */
      v.add(doc.createElement("td"));
      ((Element)v.get(901)).setAttribute("width","100%" );
      ((Element)v.get(873)).appendChild((Element)v.get(901));

      /* Empieza nodo:902 / Elemento padre: 901   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(902)).setAttribute("src","b.gif" );
      ((Element)v.get(902)).setAttribute("width","8" );
      ((Element)v.get(902)).setAttribute("height","8" );
      ((Element)v.get(901)).appendChild((Element)v.get(902));
      /* Termina nodo:902   */
      /* Termina nodo:901   */
      /* Termina nodo:873   */

      /* Empieza nodo:903 / Elemento padre: 842   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(842)).appendChild((Element)v.get(903));

      /* Empieza nodo:904 / Elemento padre: 903   */
      v.add(doc.createElement("td"));
      ((Element)v.get(904)).setAttribute("colspan","4" );
      ((Element)v.get(903)).appendChild((Element)v.get(904));

      /* Empieza nodo:905 / Elemento padre: 904   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(905)).setAttribute("src","b.gif" );
      ((Element)v.get(905)).setAttribute("width","8" );
      ((Element)v.get(905)).setAttribute("height","12" );
      ((Element)v.get(904)).appendChild((Element)v.get(905));
      /* Termina nodo:905   */
      /* Termina nodo:904   */
      /* Termina nodo:903   */
      /* Termina nodo:842   */
      /* Termina nodo:841   */
      /* Termina nodo:840   */

      /* Empieza nodo:906 / Elemento padre: 839   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(839)).appendChild((Element)v.get(906));

      /* Empieza nodo:907 / Elemento padre: 906   */
      v.add(doc.createElement("td"));
      ((Element)v.get(906)).appendChild((Element)v.get(907));

      /* Empieza nodo:908 / Elemento padre: 907   */
      v.add(doc.createElement("table"));
      ((Element)v.get(908)).setAttribute("width","100%" );
      ((Element)v.get(908)).setAttribute("align","left" );
      ((Element)v.get(908)).setAttribute("border","0" );
      ((Element)v.get(908)).setAttribute("cellspacing","0" );
      ((Element)v.get(908)).setAttribute("cellpadding","0" );
      ((Element)v.get(907)).appendChild((Element)v.get(908));

      /* Empieza nodo:909 / Elemento padre: 908   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(908)).appendChild((Element)v.get(909));

      /* Empieza nodo:910 / Elemento padre: 909   */
      v.add(doc.createElement("td"));
      ((Element)v.get(909)).appendChild((Element)v.get(910));

      /* Empieza nodo:911 / Elemento padre: 910   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(911)).setAttribute("src","b.gif" );
      ((Element)v.get(910)).appendChild((Element)v.get(911));
      /* Termina nodo:911   */
      /* Termina nodo:910   */

      /* Empieza nodo:912 / Elemento padre: 909   */
      v.add(doc.createElement("td"));
      ((Element)v.get(909)).appendChild((Element)v.get(912));

      /* Empieza nodo:913 / Elemento padre: 912   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(912)).appendChild((Element)v.get(913));

      /* Empieza nodo:914 / Elemento padre: 913   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(914)).setAttribute("class","legend" );
      ((Element)v.get(913)).appendChild((Element)v.get(914));

      /* Empieza nodo:915 / Elemento padre: 914   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(915)).setAttribute("nombre","lblDatosArticulo5" );
      ((Element)v.get(915)).setAttribute("alto","13" );
      ((Element)v.get(915)).setAttribute("filas","1" );
      ((Element)v.get(915)).setAttribute("valor","" );
      ((Element)v.get(915)).setAttribute("id","legend" );
      ((Element)v.get(915)).setAttribute("cod","00356" );
   }

   private void getXML3870(Document doc) {
      ((Element)v.get(914)).appendChild((Element)v.get(915));
      /* Termina nodo:915   */
      /* Termina nodo:914   */

      /* Empieza nodo:916 / Elemento padre: 913   */
      v.add(doc.createElement("table"));
      ((Element)v.get(916)).setAttribute("width","100%" );
      ((Element)v.get(916)).setAttribute("border","0" );
      ((Element)v.get(916)).setAttribute("align","center" );
      ((Element)v.get(916)).setAttribute("cellspacing","0" );
      ((Element)v.get(916)).setAttribute("cellpadding","0" );
      ((Element)v.get(913)).appendChild((Element)v.get(916));

      /* Empieza nodo:917 / Elemento padre: 916   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(916)).appendChild((Element)v.get(917));

      /* Empieza nodo:918 / Elemento padre: 917   */
      v.add(doc.createElement("td"));
      ((Element)v.get(917)).appendChild((Element)v.get(918));

      /* Empieza nodo:919 / Elemento padre: 918   */
      v.add(doc.createElement("table"));
      ((Element)v.get(919)).setAttribute("width","699" );
      ((Element)v.get(919)).setAttribute("border","0" );
      ((Element)v.get(919)).setAttribute("align","left" );
      ((Element)v.get(919)).setAttribute("cellspacing","0" );
      ((Element)v.get(919)).setAttribute("cellpadding","0" );
      ((Element)v.get(918)).appendChild((Element)v.get(919));

      /* Empieza nodo:920 / Elemento padre: 919   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(919)).appendChild((Element)v.get(920));

      /* Empieza nodo:921 / Elemento padre: 920   */
      v.add(doc.createElement("td"));
      ((Element)v.get(921)).setAttribute("colspan","4" );
      ((Element)v.get(920)).appendChild((Element)v.get(921));

      /* Empieza nodo:922 / Elemento padre: 921   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(922)).setAttribute("src","b.gif" );
      ((Element)v.get(922)).setAttribute("width","8" );
      ((Element)v.get(922)).setAttribute("height","8" );
      ((Element)v.get(921)).appendChild((Element)v.get(922));
      /* Termina nodo:922   */
      /* Termina nodo:921   */
      /* Termina nodo:920   */

      /* Empieza nodo:923 / Elemento padre: 919   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(919)).appendChild((Element)v.get(923));

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
      ((Element)v.get(923)).appendChild((Element)v.get(926));

      /* Empieza nodo:927 / Elemento padre: 926   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(927)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(927)).setAttribute("alto","13" );
      ((Element)v.get(927)).setAttribute("filas","1" );
      ((Element)v.get(927)).setAttribute("valor","" );
      ((Element)v.get(927)).setAttribute("id","datosTitle" );
      ((Element)v.get(927)).setAttribute("cod","6" );
      ((Element)v.get(926)).appendChild((Element)v.get(927));
      /* Termina nodo:927   */
      /* Termina nodo:926   */

      /* Empieza nodo:928 / Elemento padre: 923   */
      v.add(doc.createElement("td"));
      ((Element)v.get(923)).appendChild((Element)v.get(928));

      /* Empieza nodo:929 / Elemento padre: 928   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(929)).setAttribute("src","b.gif" );
      ((Element)v.get(929)).setAttribute("width","25" );
      ((Element)v.get(929)).setAttribute("height","8" );
      ((Element)v.get(928)).appendChild((Element)v.get(929));
      /* Termina nodo:929   */
      /* Termina nodo:928   */

      /* Empieza nodo:930 / Elemento padre: 923   */
      v.add(doc.createElement("td"));
      ((Element)v.get(923)).appendChild((Element)v.get(930));

      /* Empieza nodo:931 / Elemento padre: 930   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(931)).setAttribute("nombre","lblUnidadNegocio" );
      ((Element)v.get(931)).setAttribute("alto","13" );
      ((Element)v.get(931)).setAttribute("filas","1" );
      ((Element)v.get(931)).setAttribute("valor","" );
      ((Element)v.get(931)).setAttribute("id","datosTitle" );
      ((Element)v.get(931)).setAttribute("cod","1338" );
      ((Element)v.get(930)).appendChild((Element)v.get(931));
      /* Termina nodo:931   */
      /* Termina nodo:930   */

      /* Empieza nodo:932 / Elemento padre: 923   */
      v.add(doc.createElement("td"));
      ((Element)v.get(932)).setAttribute("width","100%" );
      ((Element)v.get(923)).appendChild((Element)v.get(932));

      /* Empieza nodo:933 / Elemento padre: 932   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(933)).setAttribute("src","b.gif" );
      ((Element)v.get(933)).setAttribute("width","8" );
      ((Element)v.get(933)).setAttribute("height","8" );
      ((Element)v.get(932)).appendChild((Element)v.get(933));
      /* Termina nodo:933   */
      /* Termina nodo:932   */
      /* Termina nodo:923   */

      /* Empieza nodo:934 / Elemento padre: 919   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(919)).appendChild((Element)v.get(934));

      /* Empieza nodo:935 / Elemento padre: 934   */
      v.add(doc.createElement("td"));
      ((Element)v.get(934)).appendChild((Element)v.get(935));

      /* Empieza nodo:936 / Elemento padre: 935   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(936)).setAttribute("src","b.gif" );
      ((Element)v.get(936)).setAttribute("width","8" );
      ((Element)v.get(936)).setAttribute("height","8" );
      ((Element)v.get(935)).appendChild((Element)v.get(936));
      /* Termina nodo:936   */
      /* Termina nodo:935   */

      /* Empieza nodo:937 / Elemento padre: 934   */
      v.add(doc.createElement("td"));
      ((Element)v.get(937)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(934)).appendChild((Element)v.get(937));

      /* Empieza nodo:938 / Elemento padre: 937   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(938)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(938)).setAttribute("id","datosCampos" );
      ((Element)v.get(938)).setAttribute("size","1" );
      ((Element)v.get(938)).setAttribute("multiple","N" );
   }

   private void getXML3960(Document doc) {
      ((Element)v.get(938)).setAttribute("req","S" );
      ((Element)v.get(938)).setAttribute("valorinicial","" );
      ((Element)v.get(938)).setAttribute("textoinicial","" );
      ((Element)v.get(937)).appendChild((Element)v.get(938));

      /* Empieza nodo:939 / Elemento padre: 938   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(938)).appendChild((Element)v.get(939));
      /* Termina nodo:939   */
      /* Termina nodo:938   */
      /* Termina nodo:937   */

      /* Empieza nodo:940 / Elemento padre: 934   */
      v.add(doc.createElement("td"));
      ((Element)v.get(934)).appendChild((Element)v.get(940));

      /* Empieza nodo:941 / Elemento padre: 940   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(941)).setAttribute("src","b.gif" );
      ((Element)v.get(941)).setAttribute("width","25" );
      ((Element)v.get(941)).setAttribute("height","8" );
      ((Element)v.get(940)).appendChild((Element)v.get(941));
      /* Termina nodo:941   */
      /* Termina nodo:940   */

      /* Empieza nodo:942 / Elemento padre: 934   */
      v.add(doc.createElement("td"));
      ((Element)v.get(942)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(942)).setAttribute("valign","bottom" );
      ((Element)v.get(934)).appendChild((Element)v.get(942));

      /* Empieza nodo:943 / Elemento padre: 942   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(943)).setAttribute("nombre","cbUnidadNegocio" );
      ((Element)v.get(943)).setAttribute("id","datosCampos" );
      ((Element)v.get(943)).setAttribute("size","1" );
      ((Element)v.get(943)).setAttribute("multiple","N" );
      ((Element)v.get(943)).setAttribute("req","N" );
      ((Element)v.get(943)).setAttribute("valorinicial","" );
      ((Element)v.get(943)).setAttribute("textoinicial","" );
      ((Element)v.get(942)).appendChild((Element)v.get(943));

      /* Empieza nodo:944 / Elemento padre: 943   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(943)).appendChild((Element)v.get(944));
      /* Termina nodo:944   */
      /* Termina nodo:943   */
      /* Termina nodo:942   */

      /* Empieza nodo:945 / Elemento padre: 934   */
      v.add(doc.createElement("td"));
      ((Element)v.get(945)).setAttribute("width","100%" );
      ((Element)v.get(934)).appendChild((Element)v.get(945));

      /* Empieza nodo:946 / Elemento padre: 945   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(946)).setAttribute("src","b.gif" );
      ((Element)v.get(946)).setAttribute("width","8" );
      ((Element)v.get(946)).setAttribute("height","8" );
      ((Element)v.get(945)).appendChild((Element)v.get(946));
      /* Termina nodo:946   */
      /* Termina nodo:945   */
      /* Termina nodo:934   */

      /* Empieza nodo:947 / Elemento padre: 919   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(919)).appendChild((Element)v.get(947));

      /* Empieza nodo:948 / Elemento padre: 947   */
      v.add(doc.createElement("td"));
      ((Element)v.get(948)).setAttribute("colspan","4" );
      ((Element)v.get(947)).appendChild((Element)v.get(948));

      /* Empieza nodo:949 / Elemento padre: 948   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(949)).setAttribute("src","b.gif" );
      ((Element)v.get(949)).setAttribute("width","8" );
      ((Element)v.get(949)).setAttribute("height","8" );
      ((Element)v.get(948)).appendChild((Element)v.get(949));
      /* Termina nodo:949   */
      /* Termina nodo:948   */
      /* Termina nodo:947   */
      /* Termina nodo:919   */
      /* Termina nodo:918   */
      /* Termina nodo:917   */

      /* Empieza nodo:950 / Elemento padre: 916   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(916)).appendChild((Element)v.get(950));

      /* Empieza nodo:951 / Elemento padre: 950   */
      v.add(doc.createElement("td"));
      ((Element)v.get(950)).appendChild((Element)v.get(951));

      /* Empieza nodo:952 / Elemento padre: 951   */
      v.add(doc.createElement("table"));
      ((Element)v.get(952)).setAttribute("width","699" );
      ((Element)v.get(952)).setAttribute("border","0" );
      ((Element)v.get(952)).setAttribute("align","left" );
      ((Element)v.get(952)).setAttribute("cellspacing","0" );
      ((Element)v.get(952)).setAttribute("cellpadding","0" );
      ((Element)v.get(951)).appendChild((Element)v.get(952));

      /* Empieza nodo:953 / Elemento padre: 952   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(952)).appendChild((Element)v.get(953));

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
      ((Element)v.get(953)).appendChild((Element)v.get(956));

      /* Empieza nodo:957 / Elemento padre: 956   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(957)).setAttribute("nombre","lblNegocio" );
      ((Element)v.get(957)).setAttribute("alto","13" );
      ((Element)v.get(957)).setAttribute("filas","1" );
      ((Element)v.get(957)).setAttribute("valor","" );
      ((Element)v.get(957)).setAttribute("id","datosTitle" );
      ((Element)v.get(957)).setAttribute("cod","588" );
      ((Element)v.get(956)).appendChild((Element)v.get(957));
      /* Termina nodo:957   */
      /* Termina nodo:956   */

      /* Empieza nodo:958 / Elemento padre: 953   */
      v.add(doc.createElement("td"));
      ((Element)v.get(953)).appendChild((Element)v.get(958));

      /* Empieza nodo:959 / Elemento padre: 958   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(959)).setAttribute("src","b.gif" );
      ((Element)v.get(959)).setAttribute("width","25" );
      ((Element)v.get(959)).setAttribute("height","8" );
      ((Element)v.get(958)).appendChild((Element)v.get(959));
      /* Termina nodo:959   */
      /* Termina nodo:958   */

      /* Empieza nodo:960 / Elemento padre: 953   */
      v.add(doc.createElement("td"));
      ((Element)v.get(953)).appendChild((Element)v.get(960));

      /* Empieza nodo:961 / Elemento padre: 960   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(961)).setAttribute("nombre","lblSupergenerico" );
      ((Element)v.get(961)).setAttribute("alto","13" );
      ((Element)v.get(961)).setAttribute("filas","1" );
      ((Element)v.get(961)).setAttribute("valor","" );
   }

   private void getXML4050(Document doc) {
      ((Element)v.get(961)).setAttribute("id","datosTitle" );
      ((Element)v.get(961)).setAttribute("cod","590" );
      ((Element)v.get(960)).appendChild((Element)v.get(961));
      /* Termina nodo:961   */
      /* Termina nodo:960   */

      /* Empieza nodo:962 / Elemento padre: 953   */
      v.add(doc.createElement("td"));
      ((Element)v.get(962)).setAttribute("width","100%" );
      ((Element)v.get(953)).appendChild((Element)v.get(962));

      /* Empieza nodo:963 / Elemento padre: 962   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(963)).setAttribute("src","b.gif" );
      ((Element)v.get(963)).setAttribute("width","8" );
      ((Element)v.get(963)).setAttribute("height","8" );
      ((Element)v.get(962)).appendChild((Element)v.get(963));
      /* Termina nodo:963   */
      /* Termina nodo:962   */
      /* Termina nodo:953   */

      /* Empieza nodo:964 / Elemento padre: 952   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(952)).appendChild((Element)v.get(964));

      /* Empieza nodo:965 / Elemento padre: 964   */
      v.add(doc.createElement("td"));
      ((Element)v.get(964)).appendChild((Element)v.get(965));

      /* Empieza nodo:966 / Elemento padre: 965   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(966)).setAttribute("src","b.gif" );
      ((Element)v.get(966)).setAttribute("width","8" );
      ((Element)v.get(966)).setAttribute("height","8" );
      ((Element)v.get(965)).appendChild((Element)v.get(966));
      /* Termina nodo:966   */
      /* Termina nodo:965   */

      /* Empieza nodo:967 / Elemento padre: 964   */
      v.add(doc.createElement("td"));
      ((Element)v.get(967)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(964)).appendChild((Element)v.get(967));

      /* Empieza nodo:968 / Elemento padre: 967   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(968)).setAttribute("nombre","cbNegocio" );
      ((Element)v.get(968)).setAttribute("id","datosCampos" );
      ((Element)v.get(968)).setAttribute("size","1" );
      ((Element)v.get(968)).setAttribute("multiple","N" );
      ((Element)v.get(968)).setAttribute("req","N" );
      ((Element)v.get(968)).setAttribute("valorinicial","" );
      ((Element)v.get(968)).setAttribute("textoinicial","" );
      ((Element)v.get(967)).appendChild((Element)v.get(968));

      /* Empieza nodo:969 / Elemento padre: 968   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(968)).appendChild((Element)v.get(969));
      /* Termina nodo:969   */
      /* Termina nodo:968   */
      /* Termina nodo:967   */

      /* Empieza nodo:970 / Elemento padre: 964   */
      v.add(doc.createElement("td"));
      ((Element)v.get(964)).appendChild((Element)v.get(970));

      /* Empieza nodo:971 / Elemento padre: 970   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(971)).setAttribute("src","b.gif" );
      ((Element)v.get(971)).setAttribute("width","25" );
      ((Element)v.get(971)).setAttribute("height","8" );
      ((Element)v.get(970)).appendChild((Element)v.get(971));
      /* Termina nodo:971   */
      /* Termina nodo:970   */

      /* Empieza nodo:972 / Elemento padre: 964   */
      v.add(doc.createElement("td"));
      ((Element)v.get(972)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(964)).appendChild((Element)v.get(972));

      /* Empieza nodo:973 / Elemento padre: 972   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(973)).setAttribute("nombre","cbSupergenerico" );
      ((Element)v.get(973)).setAttribute("id","datosCampos" );
      ((Element)v.get(973)).setAttribute("max","30" );
      ((Element)v.get(973)).setAttribute("readonly","true" );
      ((Element)v.get(973)).setAttribute("tipo","" );
      ((Element)v.get(973)).setAttribute("onchange","" );
      ((Element)v.get(973)).setAttribute("req","N" );
      ((Element)v.get(973)).setAttribute("size","40" );
      ((Element)v.get(973)).setAttribute("valor","" );
      ((Element)v.get(972)).appendChild((Element)v.get(973));
      /* Termina nodo:973   */
      /* Termina nodo:972   */

      /* Empieza nodo:974 / Elemento padre: 964   */
      v.add(doc.createElement("td"));
      ((Element)v.get(974)).setAttribute("width","100%" );
      ((Element)v.get(964)).appendChild((Element)v.get(974));

      /* Empieza nodo:975 / Elemento padre: 974   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(975)).setAttribute("nombre","btnBuscarSuperGenerico" );
      ((Element)v.get(975)).setAttribute("ID","botonContenido" );
      ((Element)v.get(975)).setAttribute("tipo","html" );
      ((Element)v.get(975)).setAttribute("estado","false" );
      ((Element)v.get(975)).setAttribute("cod","1" );
      ((Element)v.get(975)).setAttribute("accion","buscarSuperGenerico();" );
      ((Element)v.get(974)).appendChild((Element)v.get(975));
      /* Termina nodo:975   */
      /* Termina nodo:974   */

      /* Empieza nodo:976 / Elemento padre: 964   */
      v.add(doc.createElement("td"));
      ((Element)v.get(976)).setAttribute("width","100%" );
      ((Element)v.get(964)).appendChild((Element)v.get(976));

      /* Empieza nodo:977 / Elemento padre: 976   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(977)).setAttribute("src","b.gif" );
      ((Element)v.get(977)).setAttribute("width","8" );
      ((Element)v.get(977)).setAttribute("height","8" );
      ((Element)v.get(976)).appendChild((Element)v.get(977));
      /* Termina nodo:977   */
      /* Termina nodo:976   */
      /* Termina nodo:964   */

      /* Empieza nodo:978 / Elemento padre: 952   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(952)).appendChild((Element)v.get(978));

      /* Empieza nodo:979 / Elemento padre: 978   */
      v.add(doc.createElement("td"));
      ((Element)v.get(979)).setAttribute("colspan","4" );
      ((Element)v.get(978)).appendChild((Element)v.get(979));

      /* Empieza nodo:980 / Elemento padre: 979   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(980)).setAttribute("src","b.gif" );
      ((Element)v.get(980)).setAttribute("width","8" );
      ((Element)v.get(980)).setAttribute("height","8" );
      ((Element)v.get(979)).appendChild((Element)v.get(980));
      /* Termina nodo:980   */
      /* Termina nodo:979   */
      /* Termina nodo:978   */
      /* Termina nodo:952   */
      /* Termina nodo:951   */
      /* Termina nodo:950   */

      /* Empieza nodo:981 / Elemento padre: 916   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(916)).appendChild((Element)v.get(981));

      /* Empieza nodo:982 / Elemento padre: 981   */
      v.add(doc.createElement("td"));
      ((Element)v.get(981)).appendChild((Element)v.get(982));

      /* Empieza nodo:983 / Elemento padre: 982   */
      v.add(doc.createElement("table"));
      ((Element)v.get(983)).setAttribute("width","699" );
   }

   private void getXML4140(Document doc) {
      ((Element)v.get(983)).setAttribute("border","0" );
      ((Element)v.get(983)).setAttribute("align","left" );
      ((Element)v.get(983)).setAttribute("cellspacing","0" );
      ((Element)v.get(983)).setAttribute("cellpadding","0" );
      ((Element)v.get(982)).appendChild((Element)v.get(983));

      /* Empieza nodo:984 / Elemento padre: 983   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(983)).appendChild((Element)v.get(984));

      /* Empieza nodo:985 / Elemento padre: 984   */
      v.add(doc.createElement("td"));
      ((Element)v.get(984)).appendChild((Element)v.get(985));

      /* Empieza nodo:986 / Elemento padre: 985   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(986)).setAttribute("src","b.gif" );
      ((Element)v.get(986)).setAttribute("width","8" );
      ((Element)v.get(986)).setAttribute("height","8" );
      ((Element)v.get(985)).appendChild((Element)v.get(986));
      /* Termina nodo:986   */
      /* Termina nodo:985   */

      /* Empieza nodo:987 / Elemento padre: 984   */
      v.add(doc.createElement("td"));
      ((Element)v.get(984)).appendChild((Element)v.get(987));

      /* Empieza nodo:988 / Elemento padre: 987   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(988)).setAttribute("nombre","lblGenerico" );
      ((Element)v.get(988)).setAttribute("alto","13" );
      ((Element)v.get(988)).setAttribute("filas","1" );
      ((Element)v.get(988)).setAttribute("valor","" );
      ((Element)v.get(988)).setAttribute("id","datosTitle" );
      ((Element)v.get(988)).setAttribute("cod","589" );
      ((Element)v.get(987)).appendChild((Element)v.get(988));
      /* Termina nodo:988   */
      /* Termina nodo:987   */

      /* Empieza nodo:989 / Elemento padre: 984   */
      v.add(doc.createElement("td"));
      ((Element)v.get(984)).appendChild((Element)v.get(989));

      /* Empieza nodo:990 / Elemento padre: 989   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(990)).setAttribute("src","b.gif" );
      ((Element)v.get(990)).setAttribute("width","25" );
      ((Element)v.get(990)).setAttribute("height","8" );
      ((Element)v.get(989)).appendChild((Element)v.get(990));
      /* Termina nodo:990   */
      /* Termina nodo:989   */

      /* Empieza nodo:991 / Elemento padre: 984   */
      v.add(doc.createElement("td"));
      ((Element)v.get(991)).setAttribute("colspan","3" );
      ((Element)v.get(984)).appendChild((Element)v.get(991));

      /* Empieza nodo:992 / Elemento padre: 991   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(992)).setAttribute("nombre","lblCodProducto5" );
      ((Element)v.get(992)).setAttribute("alto","13" );
      ((Element)v.get(992)).setAttribute("filas","1" );
      ((Element)v.get(992)).setAttribute("valor","" );
      ((Element)v.get(992)).setAttribute("id","datosTitle" );
      ((Element)v.get(992)).setAttribute("cod","337" );
      ((Element)v.get(991)).appendChild((Element)v.get(992));
      /* Termina nodo:992   */
      /* Termina nodo:991   */

      /* Empieza nodo:993 / Elemento padre: 984   */
      v.add(doc.createElement("td"));
      ((Element)v.get(993)).setAttribute("width","100%" );
      ((Element)v.get(984)).appendChild((Element)v.get(993));

      /* Empieza nodo:994 / Elemento padre: 993   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(994)).setAttribute("src","b.gif" );
      ((Element)v.get(994)).setAttribute("width","8" );
      ((Element)v.get(994)).setAttribute("height","8" );
      ((Element)v.get(993)).appendChild((Element)v.get(994));
      /* Termina nodo:994   */
      /* Termina nodo:993   */
      /* Termina nodo:984   */

      /* Empieza nodo:995 / Elemento padre: 983   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(983)).appendChild((Element)v.get(995));

      /* Empieza nodo:996 / Elemento padre: 995   */
      v.add(doc.createElement("td"));
      ((Element)v.get(995)).appendChild((Element)v.get(996));

      /* Empieza nodo:997 / Elemento padre: 996   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(997)).setAttribute("src","b.gif" );
      ((Element)v.get(997)).setAttribute("width","8" );
      ((Element)v.get(997)).setAttribute("height","8" );
      ((Element)v.get(996)).appendChild((Element)v.get(997));
      /* Termina nodo:997   */
      /* Termina nodo:996   */

      /* Empieza nodo:998 / Elemento padre: 995   */
      v.add(doc.createElement("td"));
      ((Element)v.get(998)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(995)).appendChild((Element)v.get(998));

      /* Empieza nodo:999 / Elemento padre: 998   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(999)).setAttribute("nombre","cbGenerico" );
      ((Element)v.get(999)).setAttribute("id","datosCampos" );
      ((Element)v.get(999)).setAttribute("max","30" );
      ((Element)v.get(999)).setAttribute("readonly","true" );
      ((Element)v.get(999)).setAttribute("tipo","" );
      ((Element)v.get(999)).setAttribute("onchange","" );
      ((Element)v.get(999)).setAttribute("req","N" );
      ((Element)v.get(999)).setAttribute("size","40" );
      ((Element)v.get(999)).setAttribute("valor","" );
      ((Element)v.get(998)).appendChild((Element)v.get(999));
      /* Termina nodo:999   */
      /* Termina nodo:998   */

      /* Empieza nodo:1000 / Elemento padre: 995   */
      v.add(doc.createElement("td"));
      ((Element)v.get(995)).appendChild((Element)v.get(1000));

      /* Empieza nodo:1001 / Elemento padre: 1000   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1001)).setAttribute("nombre","btnBuscarGenerico" );
      ((Element)v.get(1001)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1001)).setAttribute("tipo","html" );
      ((Element)v.get(1001)).setAttribute("estado","false" );
      ((Element)v.get(1001)).setAttribute("cod","1" );
      ((Element)v.get(1001)).setAttribute("accion","buscarGenerico();" );
      ((Element)v.get(1000)).appendChild((Element)v.get(1001));
      /* Termina nodo:1001   */
      /* Termina nodo:1000   */

      /* Empieza nodo:1002 / Elemento padre: 995   */
      v.add(doc.createElement("td"));
      ((Element)v.get(995)).appendChild((Element)v.get(1002));

      /* Empieza nodo:1003 / Elemento padre: 1002   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1003)).setAttribute("src","b.gif" );
      ((Element)v.get(1003)).setAttribute("width","25" );
      ((Element)v.get(1003)).setAttribute("height","8" );
      ((Element)v.get(1002)).appendChild((Element)v.get(1003));
      /* Termina nodo:1003   */
      /* Termina nodo:1002   */

      /* Empieza nodo:1004 / Elemento padre: 995   */
   }

   private void getXML4230(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(1004)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(995)).appendChild((Element)v.get(1004));

      /* Empieza nodo:1005 / Elemento padre: 1004   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(1005)).setAttribute("nombre","txtCodProducto5" );
      ((Element)v.get(1005)).setAttribute("id","datosCampos" );
      ((Element)v.get(1005)).setAttribute("max","20" );
      ((Element)v.get(1005)).setAttribute("tipo","" );
      ((Element)v.get(1005)).setAttribute("onchange","" );
      ((Element)v.get(1005)).setAttribute("req","N" );
      ((Element)v.get(1005)).setAttribute("size","26" );
      ((Element)v.get(1005)).setAttribute("valor","" );
      ((Element)v.get(1005)).setAttribute("validacion","" );
      ((Element)v.get(1004)).appendChild((Element)v.get(1005));
      /* Termina nodo:1005   */
      /* Termina nodo:1004   */

      /* Empieza nodo:1006 / Elemento padre: 995   */
      v.add(doc.createElement("td"));
      ((Element)v.get(995)).appendChild((Element)v.get(1006));

      /* Empieza nodo:1007 / Elemento padre: 1006   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1007)).setAttribute("src","b.gif" );
      ((Element)v.get(1007)).setAttribute("width","8" );
      ((Element)v.get(1007)).setAttribute("height","8" );
      ((Element)v.get(1006)).appendChild((Element)v.get(1007));
      /* Termina nodo:1007   */
      /* Termina nodo:1006   */

      /* Empieza nodo:1008 / Elemento padre: 995   */
      v.add(doc.createElement("td"));
      ((Element)v.get(995)).appendChild((Element)v.get(1008));

      /* Empieza nodo:1009 / Elemento padre: 1008   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1009)).setAttribute("nombre","btnBuscar5" );
      ((Element)v.get(1009)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1009)).setAttribute("tipo","html" );
      ((Element)v.get(1009)).setAttribute("accion","accionBuscarProductoDescuento();" );
      ((Element)v.get(1009)).setAttribute("estado","false" );
      ((Element)v.get(1009)).setAttribute("cod","1" );
      ((Element)v.get(1008)).appendChild((Element)v.get(1009));
      /* Termina nodo:1009   */
      /* Termina nodo:1008   */

      /* Empieza nodo:1010 / Elemento padre: 995   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1010)).setAttribute("width","100%" );
      ((Element)v.get(995)).appendChild((Element)v.get(1010));

      /* Empieza nodo:1011 / Elemento padre: 1010   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1011)).setAttribute("src","b.gif" );
      ((Element)v.get(1011)).setAttribute("width","8" );
      ((Element)v.get(1011)).setAttribute("height","8" );
      ((Element)v.get(1010)).appendChild((Element)v.get(1011));
      /* Termina nodo:1011   */
      /* Termina nodo:1010   */
      /* Termina nodo:995   */

      /* Empieza nodo:1012 / Elemento padre: 983   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(983)).appendChild((Element)v.get(1012));

      /* Empieza nodo:1013 / Elemento padre: 1012   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1013)).setAttribute("colspan","4" );
      ((Element)v.get(1012)).appendChild((Element)v.get(1013));

      /* Empieza nodo:1014 / Elemento padre: 1013   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1014)).setAttribute("src","b.gif" );
      ((Element)v.get(1014)).setAttribute("width","8" );
      ((Element)v.get(1014)).setAttribute("height","8" );
      ((Element)v.get(1013)).appendChild((Element)v.get(1014));
      /* Termina nodo:1014   */
      /* Termina nodo:1013   */
      /* Termina nodo:1012   */
      /* Termina nodo:983   */
      /* Termina nodo:982   */
      /* Termina nodo:981   */
      /* Termina nodo:916   */
      /* Termina nodo:913   */
      /* Termina nodo:912   */

      /* Empieza nodo:1015 / Elemento padre: 909   */
      v.add(doc.createElement("td"));
      ((Element)v.get(909)).appendChild((Element)v.get(1015));

      /* Empieza nodo:1016 / Elemento padre: 1015   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1016)).setAttribute("src","b.gif" );
      ((Element)v.get(1015)).appendChild((Element)v.get(1016));
      /* Termina nodo:1016   */
      /* Termina nodo:1015   */
      /* Termina nodo:909   */

      /* Empieza nodo:1017 / Elemento padre: 908   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(908)).appendChild((Element)v.get(1017));

      /* Empieza nodo:1018 / Elemento padre: 1017   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1017)).appendChild((Element)v.get(1018));

      /* Empieza nodo:1019 / Elemento padre: 1018   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1019)).setAttribute("src","b.gif" );
      ((Element)v.get(1018)).appendChild((Element)v.get(1019));
      /* Termina nodo:1019   */
      /* Termina nodo:1018   */

      /* Empieza nodo:1020 / Elemento padre: 1017   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1017)).appendChild((Element)v.get(1020));

      /* Empieza nodo:1021 / Elemento padre: 1020   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(1020)).appendChild((Element)v.get(1021));

      /* Empieza nodo:1022 / Elemento padre: 1021   */
      v.add(doc.createElement("table"));
      ((Element)v.get(1022)).setAttribute("width","100%" );
      ((Element)v.get(1022)).setAttribute("border","0" );
      ((Element)v.get(1022)).setAttribute("align","center" );
      ((Element)v.get(1022)).setAttribute("cellspacing","0" );
      ((Element)v.get(1022)).setAttribute("cellpadding","0" );
      ((Element)v.get(1021)).appendChild((Element)v.get(1022));

      /* Empieza nodo:1023 / Elemento padre: 1022   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1022)).appendChild((Element)v.get(1023));

      /* Empieza nodo:1024 / Elemento padre: 1023   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1024)).setAttribute("class","botonera" );
      ((Element)v.get(1023)).appendChild((Element)v.get(1024));

      /* Empieza nodo:1025 / Elemento padre: 1024   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1025)).setAttribute("nombre","btnAnadir5" );
      ((Element)v.get(1025)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1025)).setAttribute("tipo","html" );
      ((Element)v.get(1025)).setAttribute("accion","accionAniadirProducto();" );
      ((Element)v.get(1025)).setAttribute("estado","false" );
      ((Element)v.get(1025)).setAttribute("cod","404" );
      ((Element)v.get(1024)).appendChild((Element)v.get(1025));
      /* Termina nodo:1025   */
      /* Termina nodo:1024   */
      /* Termina nodo:1023   */
      /* Termina nodo:1022   */
      /* Termina nodo:1021   */
      /* Termina nodo:1020   */

      /* Empieza nodo:1026 / Elemento padre: 1017   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1017)).appendChild((Element)v.get(1026));

      /* Empieza nodo:1027 / Elemento padre: 1026   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1027)).setAttribute("src","b.gif" );
      ((Element)v.get(1027)).setAttribute("width","8" );
   }

   private void getXML4320(Document doc) {
      ((Element)v.get(1027)).setAttribute("height","12" );
      ((Element)v.get(1026)).appendChild((Element)v.get(1027));
      /* Termina nodo:1027   */
      /* Termina nodo:1026   */
      /* Termina nodo:1017   */

      /* Empieza nodo:1028 / Elemento padre: 908   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(908)).appendChild((Element)v.get(1028));

      /* Empieza nodo:1029 / Elemento padre: 1028   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1029)).setAttribute("width","12" );
      ((Element)v.get(1029)).setAttribute("align","center" );
      ((Element)v.get(1028)).appendChild((Element)v.get(1029));

      /* Empieza nodo:1030 / Elemento padre: 1029   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1030)).setAttribute("src","b.gif" );
      ((Element)v.get(1030)).setAttribute("width","12" );
      ((Element)v.get(1030)).setAttribute("height","354" );
      ((Element)v.get(1029)).appendChild((Element)v.get(1030));
      /* Termina nodo:1030   */
      /* Termina nodo:1029   */

      /* Empieza nodo:1031 / Elemento padre: 1028   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1031)).setAttribute("width","756" );
      ((Element)v.get(1028)).appendChild((Element)v.get(1031));

      /* Empieza nodo:1032 / Elemento padre: 1031   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1032)).setAttribute("src","b.gif" );
      ((Element)v.get(1031)).appendChild((Element)v.get(1032));
      /* Termina nodo:1032   */
      /* Termina nodo:1031   */

      /* Empieza nodo:1033 / Elemento padre: 1028   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1033)).setAttribute("width","12" );
      ((Element)v.get(1028)).appendChild((Element)v.get(1033));

      /* Empieza nodo:1034 / Elemento padre: 1033   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1034)).setAttribute("src","b.gif" );
      ((Element)v.get(1034)).setAttribute("width","12" );
      ((Element)v.get(1034)).setAttribute("height","1" );
      ((Element)v.get(1033)).appendChild((Element)v.get(1034));
      /* Termina nodo:1034   */
      /* Termina nodo:1033   */
      /* Termina nodo:1028   */
      /* Termina nodo:908   */
      /* Termina nodo:907   */
      /* Termina nodo:906   */
      /* Termina nodo:839   */
      /* Termina nodo:836   */
      /* Termina nodo:835   */

      /* Empieza nodo:1035 / Elemento padre: 832   */
      v.add(doc.createElement("td"));
      ((Element)v.get(832)).appendChild((Element)v.get(1035));

      /* Empieza nodo:1036 / Elemento padre: 1035   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1036)).setAttribute("src","b.gif" );
      ((Element)v.get(1035)).appendChild((Element)v.get(1036));
      /* Termina nodo:1036   */
      /* Termina nodo:1035   */
      /* Termina nodo:832   */

      /* Empieza nodo:1037 / Elemento padre: 824   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(824)).appendChild((Element)v.get(1037));

      /* Empieza nodo:1038 / Elemento padre: 1037   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1037)).appendChild((Element)v.get(1038));

      /* Empieza nodo:1039 / Elemento padre: 1038   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1039)).setAttribute("src","b.gif" );
      ((Element)v.get(1038)).appendChild((Element)v.get(1039));
      /* Termina nodo:1039   */
      /* Termina nodo:1038   */

      /* Empieza nodo:1040 / Elemento padre: 1037   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1037)).appendChild((Element)v.get(1040));

      /* Empieza nodo:1041 / Elemento padre: 1040   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(1040)).appendChild((Element)v.get(1041));

      /* Empieza nodo:1042 / Elemento padre: 1041   */
      v.add(doc.createElement("table"));
      ((Element)v.get(1042)).setAttribute("width","100%" );
      ((Element)v.get(1042)).setAttribute("border","0" );
      ((Element)v.get(1042)).setAttribute("align","center" );
      ((Element)v.get(1042)).setAttribute("cellspacing","0" );
      ((Element)v.get(1042)).setAttribute("cellpadding","0" );
      ((Element)v.get(1041)).appendChild((Element)v.get(1042));

      /* Empieza nodo:1043 / Elemento padre: 1042   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1042)).appendChild((Element)v.get(1043));

      /* Empieza nodo:1044 / Elemento padre: 1043   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1044)).setAttribute("class","botonera" );
      ((Element)v.get(1043)).appendChild((Element)v.get(1044));

      /* Empieza nodo:1045 / Elemento padre: 1044   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1045)).setAttribute("nombre","btnAceptar4" );
      ((Element)v.get(1045)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1045)).setAttribute("tipo","html" );
      ((Element)v.get(1045)).setAttribute("accion","accionAceptar(get('formulario.OID_TIPO_PREMIO_DESCUENTO'));" );
      ((Element)v.get(1045)).setAttribute("estado","false" );
      ((Element)v.get(1045)).setAttribute("cod","12" );
      ((Element)v.get(1044)).appendChild((Element)v.get(1045));
      /* Termina nodo:1045   */
      /* Termina nodo:1044   */
      /* Termina nodo:1043   */
      /* Termina nodo:1042   */
      /* Termina nodo:1041   */
      /* Termina nodo:1040   */

      /* Empieza nodo:1046 / Elemento padre: 1037   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1037)).appendChild((Element)v.get(1046));

      /* Empieza nodo:1047 / Elemento padre: 1046   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1047)).setAttribute("src","b.gif" );
      ((Element)v.get(1047)).setAttribute("width","8" );
      ((Element)v.get(1047)).setAttribute("height","12" );
      ((Element)v.get(1046)).appendChild((Element)v.get(1047));
      /* Termina nodo:1047   */
      /* Termina nodo:1046   */
      /* Termina nodo:1037   */

      /* Empieza nodo:1048 / Elemento padre: 824   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(824)).appendChild((Element)v.get(1048));

      /* Empieza nodo:1049 / Elemento padre: 1048   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1049)).setAttribute("width","12" );
      ((Element)v.get(1049)).setAttribute("align","center" );
      ((Element)v.get(1048)).appendChild((Element)v.get(1049));

      /* Empieza nodo:1050 / Elemento padre: 1049   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1050)).setAttribute("src","b.gif" );
      ((Element)v.get(1050)).setAttribute("width","12" );
      ((Element)v.get(1050)).setAttribute("height","12" );
      ((Element)v.get(1049)).appendChild((Element)v.get(1050));
      /* Termina nodo:1050   */
      /* Termina nodo:1049   */

      /* Empieza nodo:1051 / Elemento padre: 1048   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1051)).setAttribute("width","756" );
      ((Element)v.get(1048)).appendChild((Element)v.get(1051));

      /* Empieza nodo:1052 / Elemento padre: 1051   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1052)).setAttribute("src","b.gif" );
      ((Element)v.get(1051)).appendChild((Element)v.get(1052));
      /* Termina nodo:1052   */
      /* Termina nodo:1051   */

      /* Empieza nodo:1053 / Elemento padre: 1048   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1053)).setAttribute("width","12" );
      ((Element)v.get(1048)).appendChild((Element)v.get(1053));

      /* Empieza nodo:1054 / Elemento padre: 1053   */
   }

   private void getXML4410(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1054)).setAttribute("src","b.gif" );
      ((Element)v.get(1054)).setAttribute("width","12" );
      ((Element)v.get(1054)).setAttribute("height","1" );
      ((Element)v.get(1053)).appendChild((Element)v.get(1054));
      /* Termina nodo:1054   */
      /* Termina nodo:1053   */
      /* Termina nodo:1048   */
      /* Termina nodo:824   */
      /* Termina nodo:823   */

      /* Empieza nodo:1055 / Elemento padre: 36   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(1055)).setAttribute("nombre","listado1" );
      ((Element)v.get(1055)).setAttribute("ancho","703" );
      ((Element)v.get(1055)).setAttribute("alto","300" );
      ((Element)v.get(1055)).setAttribute("x","26" );
      ((Element)v.get(1055)).setAttribute("y","652" );
      ((Element)v.get(1055)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(1055)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(36)).appendChild((Element)v.get(1055));

      /* Empieza nodo:1056 / Elemento padre: 1055   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(1056)).setAttribute("precarga","S" );
      ((Element)v.get(1056)).setAttribute("conROver","S" );
      ((Element)v.get(1055)).appendChild((Element)v.get(1056));

      /* Empieza nodo:1057 / Elemento padre: 1056   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(1057)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(1057)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(1057)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(1057)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(1056)).appendChild((Element)v.get(1057));
      /* Termina nodo:1057   */

      /* Empieza nodo:1058 / Elemento padre: 1056   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(1058)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(1058)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(1058)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(1058)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(1056)).appendChild((Element)v.get(1058));
      /* Termina nodo:1058   */

      /* Empieza nodo:1059 / Elemento padre: 1056   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(1059)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(1059)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(1056)).appendChild((Element)v.get(1059));
      /* Termina nodo:1059   */
      /* Termina nodo:1056   */

      /* Empieza nodo:1060 / Elemento padre: 1055   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(1055)).appendChild((Element)v.get(1060));

      /* Empieza nodo:1061 / Elemento padre: 1060   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(1061)).setAttribute("borde","1" );
      ((Element)v.get(1061)).setAttribute("horizDatos","1" );
      ((Element)v.get(1061)).setAttribute("horizCabecera","1" );
      ((Element)v.get(1061)).setAttribute("vertical","0" );
      ((Element)v.get(1061)).setAttribute("horizTitulo","1" );
      ((Element)v.get(1061)).setAttribute("horizBase","1" );
      ((Element)v.get(1060)).appendChild((Element)v.get(1061));
      /* Termina nodo:1061   */

      /* Empieza nodo:1062 / Elemento padre: 1060   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(1062)).setAttribute("borde","#999999" );
      ((Element)v.get(1062)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(1062)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(1062)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(1062)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(1062)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(1062)).setAttribute("horizBase","#999999" );
      ((Element)v.get(1060)).appendChild((Element)v.get(1062));
      /* Termina nodo:1062   */
      /* Termina nodo:1060   */

      /* Empieza nodo:1063 / Elemento padre: 1055   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(1063)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(1063)).setAttribute("alto","22" );
      ((Element)v.get(1063)).setAttribute("imgFondo","" );
      ((Element)v.get(1063)).setAttribute("cod","0031" );
      ((Element)v.get(1063)).setAttribute("ID","datosTitle" );
      ((Element)v.get(1055)).appendChild((Element)v.get(1063));
      /* Termina nodo:1063   */

      /* Empieza nodo:1064 / Elemento padre: 1055   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(1064)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(1064)).setAttribute("alto","22" );
      ((Element)v.get(1064)).setAttribute("imgFondo","" );
      ((Element)v.get(1055)).appendChild((Element)v.get(1064));
      /* Termina nodo:1064   */

      /* Empieza nodo:1065 / Elemento padre: 1055   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(1065)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(1065)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(1065)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(1065)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(1065)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(1065)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(1055)).appendChild((Element)v.get(1065));

      /* Empieza nodo:1066 / Elemento padre: 1065   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1066)).setAttribute("ancho","26" );
      ((Element)v.get(1066)).setAttribute("minimizable","S" );
      ((Element)v.get(1066)).setAttribute("minimizada","N" );
      ((Element)v.get(1065)).appendChild((Element)v.get(1066));
      /* Termina nodo:1066   */

      /* Empieza nodo:1067 / Elemento padre: 1065   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1067)).setAttribute("ancho","26" );
      ((Element)v.get(1067)).setAttribute("minimizable","S" );
      ((Element)v.get(1067)).setAttribute("minimizada","N" );
      ((Element)v.get(1065)).appendChild((Element)v.get(1067));
      /* Termina nodo:1067   */

      /* Empieza nodo:1068 / Elemento padre: 1065   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1068)).setAttribute("ancho","26" );
      ((Element)v.get(1068)).setAttribute("minimizable","S" );
      ((Element)v.get(1068)).setAttribute("minimizada","N" );
      ((Element)v.get(1065)).appendChild((Element)v.get(1068));
      /* Termina nodo:1068   */

      /* Empieza nodo:1069 / Elemento padre: 1065   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1069)).setAttribute("ancho","26" );
   }

   private void getXML4500(Document doc) {
      ((Element)v.get(1069)).setAttribute("minimizable","S" );
      ((Element)v.get(1069)).setAttribute("minimizada","N" );
      ((Element)v.get(1069)).setAttribute("oculta","S" );
      ((Element)v.get(1065)).appendChild((Element)v.get(1069));
      /* Termina nodo:1069   */

      /* Empieza nodo:1070 / Elemento padre: 1065   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1070)).setAttribute("ancho","26" );
      ((Element)v.get(1070)).setAttribute("minimizable","S" );
      ((Element)v.get(1070)).setAttribute("minimizada","N" );
      ((Element)v.get(1070)).setAttribute("oculta","S" );
      ((Element)v.get(1065)).appendChild((Element)v.get(1070));
      /* Termina nodo:1070   */
      /* Termina nodo:1065   */

      /* Empieza nodo:1071 / Elemento padre: 1055   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(1071)).setAttribute("alto","20" );
      ((Element)v.get(1071)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(1071)).setAttribute("imgFondo","" );
      ((Element)v.get(1071)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(1055)).appendChild((Element)v.get(1071));

      /* Empieza nodo:1072 / Elemento padre: 1071   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1072)).setAttribute("colFondo","" );
      ((Element)v.get(1072)).setAttribute("ID","EstCab" );
      ((Element)v.get(1072)).setAttribute("cod","1841" );
      ((Element)v.get(1071)).appendChild((Element)v.get(1072));

      /* Elemento padre:1072 / Elemento actual: 1073   */
      v.add(doc.createTextNode("Nº pago"));
      ((Element)v.get(1072)).appendChild((Text)v.get(1073));

      /* Termina nodo Texto:1073   */
      /* Termina nodo:1072   */

      /* Empieza nodo:1074 / Elemento padre: 1071   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1074)).setAttribute("colFondo","" );
      ((Element)v.get(1074)).setAttribute("ID","EstCab" );
      ((Element)v.get(1074)).setAttribute("cod","1784" );
      ((Element)v.get(1071)).appendChild((Element)v.get(1074));

      /* Elemento padre:1074 / Elemento actual: 1075   */
      v.add(doc.createTextNode("% Premio"));
      ((Element)v.get(1074)).appendChild((Text)v.get(1075));

      /* Termina nodo Texto:1075   */
      /* Termina nodo:1074   */

      /* Empieza nodo:1076 / Elemento padre: 1071   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1076)).setAttribute("colFondo","" );
      ((Element)v.get(1076)).setAttribute("ID","EstCab" );
      ((Element)v.get(1076)).setAttribute("cod","1842" );
      ((Element)v.get(1071)).appendChild((Element)v.get(1076));

      /* Elemento padre:1076 / Elemento actual: 1077   */
      v.add(doc.createTextNode("Período control"));
      ((Element)v.get(1076)).appendChild((Text)v.get(1077));

      /* Termina nodo Texto:1077   */
      /* Termina nodo:1076   */

      /* Empieza nodo:1078 / Elemento padre: 1071   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1078)).setAttribute("colFondo","" );
      ((Element)v.get(1078)).setAttribute("ID","EstCab" );
      ((Element)v.get(1071)).appendChild((Element)v.get(1078));

      /* Elemento padre:1078 / Elemento actual: 1079   */
      v.add(doc.createTextNode("oidPeriodoControl"));
      ((Element)v.get(1078)).appendChild((Text)v.get(1079));

      /* Termina nodo Texto:1079   */
      /* Termina nodo:1078   */

      /* Empieza nodo:1080 / Elemento padre: 1071   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1080)).setAttribute("colFondo","" );
      ((Element)v.get(1080)).setAttribute("ID","EstCab" );
      ((Element)v.get(1071)).appendChild((Element)v.get(1080));

      /* Elemento padre:1080 / Elemento actual: 1081   */
      v.add(doc.createTextNode("oidPago"));
      ((Element)v.get(1080)).appendChild((Text)v.get(1081));

      /* Termina nodo Texto:1081   */
      /* Termina nodo:1080   */
      /* Termina nodo:1071   */

      /* Empieza nodo:1082 / Elemento padre: 1055   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(1082)).setAttribute("alto","22" );
      ((Element)v.get(1082)).setAttribute("accion","" );
      ((Element)v.get(1082)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(1082)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(1082)).setAttribute("maxSel","-1" );
      ((Element)v.get(1082)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(1082)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(1082)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(1082)).setAttribute("onLoad","" );
      ((Element)v.get(1082)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(1055)).appendChild((Element)v.get(1082));

      /* Empieza nodo:1083 / Elemento padre: 1082   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1083)).setAttribute("tipo","texto" );
      ((Element)v.get(1083)).setAttribute("ID","EstDat" );
      ((Element)v.get(1082)).appendChild((Element)v.get(1083));
      /* Termina nodo:1083   */

      /* Empieza nodo:1084 / Elemento padre: 1082   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1084)).setAttribute("tipo","texto" );
      ((Element)v.get(1084)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1082)).appendChild((Element)v.get(1084));
      /* Termina nodo:1084   */

      /* Empieza nodo:1085 / Elemento padre: 1082   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1085)).setAttribute("tipo","texto" );
      ((Element)v.get(1085)).setAttribute("ID","EstDat" );
      ((Element)v.get(1082)).appendChild((Element)v.get(1085));
      /* Termina nodo:1085   */

      /* Empieza nodo:1086 / Elemento padre: 1082   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1086)).setAttribute("tipo","texto" );
      ((Element)v.get(1086)).setAttribute("ID","EstDat" );
      ((Element)v.get(1082)).appendChild((Element)v.get(1086));
      /* Termina nodo:1086   */

      /* Empieza nodo:1087 / Elemento padre: 1082   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1087)).setAttribute("tipo","texto" );
      ((Element)v.get(1087)).setAttribute("ID","EstDat" );
      ((Element)v.get(1082)).appendChild((Element)v.get(1087));
      /* Termina nodo:1087   */
      /* Termina nodo:1082   */

      /* Empieza nodo:1088 / Elemento padre: 1055   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(1055)).appendChild((Element)v.get(1088));
      /* Termina nodo:1088   */

      /* Empieza nodo:1089 / Elemento padre: 1055   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(1089)).setAttribute("nombre","mipgndo1" );
      ((Element)v.get(1089)).setAttribute("ancho","703" );
      ((Element)v.get(1089)).setAttribute("sep","$" );
      ((Element)v.get(1089)).setAttribute("x","26" );
      ((Element)v.get(1089)).setAttribute("class","botonera" );
      ((Element)v.get(1089)).setAttribute("y","929" );
   }

   private void getXML4590(Document doc) {
      ((Element)v.get(1089)).setAttribute("control","|" );
      ((Element)v.get(1089)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(1089)).setAttribute("rowset","" );
      ((Element)v.get(1089)).setAttribute("cargainicial","N" );
      ((Element)v.get(1055)).appendChild((Element)v.get(1089));

      /* Empieza nodo:1090 / Elemento padre: 1089   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1090)).setAttribute("nombre","ret1" );
      ((Element)v.get(1090)).setAttribute("x","51" );
      ((Element)v.get(1090)).setAttribute("y","933" );
      ((Element)v.get(1090)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1090)).setAttribute("img","retroceder_on" );
      ((Element)v.get(1090)).setAttribute("tipo","0" );
      ((Element)v.get(1090)).setAttribute("estado","false" );
      ((Element)v.get(1090)).setAttribute("alt","" );
      ((Element)v.get(1090)).setAttribute("codigo","" );
      ((Element)v.get(1090)).setAttribute("accion","mipgndo1.retroceder();" );
      ((Element)v.get(1089)).appendChild((Element)v.get(1090));
      /* Termina nodo:1090   */

      /* Empieza nodo:1091 / Elemento padre: 1089   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1091)).setAttribute("nombre","ava1" );
      ((Element)v.get(1091)).setAttribute("x","66" );
      ((Element)v.get(1091)).setAttribute("y","933" );
      ((Element)v.get(1091)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1091)).setAttribute("img","avanzar_on" );
      ((Element)v.get(1091)).setAttribute("tipo","0" );
      ((Element)v.get(1091)).setAttribute("estado","false" );
      ((Element)v.get(1091)).setAttribute("alt","" );
      ((Element)v.get(1091)).setAttribute("codigo","" );
      ((Element)v.get(1091)).setAttribute("accion","mipgndo1.avanzar();" );
      ((Element)v.get(1089)).appendChild((Element)v.get(1091));
      /* Termina nodo:1091   */
      /* Termina nodo:1089   */
      /* Termina nodo:1055   */

      /* Empieza nodo:1092 / Elemento padre: 36   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1092)).setAttribute("nombre","primera1" );
      ((Element)v.get(1092)).setAttribute("x","34" );
      ((Element)v.get(1092)).setAttribute("y","933" );
      ((Element)v.get(1092)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1092)).setAttribute("img","primera_on" );
      ((Element)v.get(1092)).setAttribute("tipo","-2" );
      ((Element)v.get(1092)).setAttribute("estado","false" );
      ((Element)v.get(1092)).setAttribute("alt","" );
      ((Element)v.get(1092)).setAttribute("codigo","" );
      ((Element)v.get(1092)).setAttribute("accion","mipgndo1.retrocederPrimeraPagina();" );
      ((Element)v.get(36)).appendChild((Element)v.get(1092));
      /* Termina nodo:1092   */

      /* Empieza nodo:1093 / Elemento padre: 36   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1093)).setAttribute("nombre","separa1" );
      ((Element)v.get(1093)).setAttribute("x","73" );
      ((Element)v.get(1093)).setAttribute("y","929" );
      ((Element)v.get(1093)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1093)).setAttribute("img","separa_base" );
      ((Element)v.get(1093)).setAttribute("tipo","0" );
      ((Element)v.get(1093)).setAttribute("estado","false" );
      ((Element)v.get(1093)).setAttribute("alt","" );
      ((Element)v.get(1093)).setAttribute("codigo","" );
      ((Element)v.get(1093)).setAttribute("accion","" );
      ((Element)v.get(36)).appendChild((Element)v.get(1093));
      /* Termina nodo:1093   */

      /* Empieza nodo:1094 / Elemento padre: 36   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1094)).setAttribute("nombre","btnEliminar2" );
      ((Element)v.get(1094)).setAttribute("x","27" );
      ((Element)v.get(1094)).setAttribute("y","930" );
      ((Element)v.get(1094)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1094)).setAttribute("accion","accionEliminarPago()" );
      ((Element)v.get(1094)).setAttribute("tipo","html" );
      ((Element)v.get(1094)).setAttribute("estado","false" );
      ((Element)v.get(1094)).setAttribute("cod","1254" );
      ((Element)v.get(36)).appendChild((Element)v.get(1094));
      /* Termina nodo:1094   */

      /* Empieza nodo:1095 / Elemento padre: 36   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(1095)).setAttribute("nombre","listado2" );
      ((Element)v.get(1095)).setAttribute("ancho","676" );
      ((Element)v.get(1095)).setAttribute("alto","278" );
      ((Element)v.get(1095)).setAttribute("x","40" );
      ((Element)v.get(1095)).setAttribute("y","910" );
      ((Element)v.get(1095)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(1095)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(36)).appendChild((Element)v.get(1095));

      /* Empieza nodo:1096 / Elemento padre: 1095   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(1096)).setAttribute("precarga","S" );
      ((Element)v.get(1096)).setAttribute("conROver","S" );
      ((Element)v.get(1095)).appendChild((Element)v.get(1096));

      /* Empieza nodo:1097 / Elemento padre: 1096   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(1097)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(1097)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(1097)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(1097)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(1096)).appendChild((Element)v.get(1097));
      /* Termina nodo:1097   */

      /* Empieza nodo:1098 / Elemento padre: 1096   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(1098)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(1098)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(1098)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(1098)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(1096)).appendChild((Element)v.get(1098));
      /* Termina nodo:1098   */

      /* Empieza nodo:1099 / Elemento padre: 1096   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(1099)).setAttribute("ordenar","ascendente_on.gif" );
   }

   private void getXML4680(Document doc) {
      ((Element)v.get(1099)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(1096)).appendChild((Element)v.get(1099));
      /* Termina nodo:1099   */
      /* Termina nodo:1096   */

      /* Empieza nodo:1100 / Elemento padre: 1095   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(1095)).appendChild((Element)v.get(1100));

      /* Empieza nodo:1101 / Elemento padre: 1100   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(1101)).setAttribute("borde","1" );
      ((Element)v.get(1101)).setAttribute("horizDatos","1" );
      ((Element)v.get(1101)).setAttribute("horizCabecera","1" );
      ((Element)v.get(1101)).setAttribute("vertical","0" );
      ((Element)v.get(1101)).setAttribute("horizTitulo","1" );
      ((Element)v.get(1101)).setAttribute("horizBase","1" );
      ((Element)v.get(1100)).appendChild((Element)v.get(1101));
      /* Termina nodo:1101   */

      /* Empieza nodo:1102 / Elemento padre: 1100   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(1102)).setAttribute("borde","#999999" );
      ((Element)v.get(1102)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(1102)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(1102)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(1102)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(1102)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(1102)).setAttribute("horizBase","#999999" );
      ((Element)v.get(1100)).appendChild((Element)v.get(1102));
      /* Termina nodo:1102   */
      /* Termina nodo:1100   */

      /* Empieza nodo:1103 / Elemento padre: 1095   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(1103)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(1103)).setAttribute("alto","22" );
      ((Element)v.get(1103)).setAttribute("imgFondo","" );
      ((Element)v.get(1103)).setAttribute("cod","00353" );
      ((Element)v.get(1103)).setAttribute("ID","datosTitle" );
      ((Element)v.get(1095)).appendChild((Element)v.get(1103));
      /* Termina nodo:1103   */

      /* Empieza nodo:1104 / Elemento padre: 1095   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(1104)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(1104)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(1104)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(1104)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(1104)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(1104)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(1095)).appendChild((Element)v.get(1104));

      /* Empieza nodo:1105 / Elemento padre: 1104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1105)).setAttribute("ancho","80" );
      ((Element)v.get(1105)).setAttribute("minimizable","S" );
      ((Element)v.get(1105)).setAttribute("minimizada","N" );
      ((Element)v.get(1104)).appendChild((Element)v.get(1105));
      /* Termina nodo:1105   */

      /* Empieza nodo:1106 / Elemento padre: 1104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1106)).setAttribute("ancho","160" );
      ((Element)v.get(1106)).setAttribute("minimizable","S" );
      ((Element)v.get(1106)).setAttribute("minimizada","N" );
      ((Element)v.get(1104)).appendChild((Element)v.get(1106));
      /* Termina nodo:1106   */

      /* Empieza nodo:1107 / Elemento padre: 1104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1107)).setAttribute("ancho","80" );
      ((Element)v.get(1107)).setAttribute("minimizable","S" );
      ((Element)v.get(1107)).setAttribute("minimizada","N" );
      ((Element)v.get(1104)).appendChild((Element)v.get(1107));
      /* Termina nodo:1107   */

      /* Empieza nodo:1108 / Elemento padre: 1104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1108)).setAttribute("ancho","80" );
      ((Element)v.get(1108)).setAttribute("minimizable","S" );
      ((Element)v.get(1108)).setAttribute("minimizada","N" );
      ((Element)v.get(1104)).appendChild((Element)v.get(1108));
      /* Termina nodo:1108   */

      /* Empieza nodo:1109 / Elemento padre: 1104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1109)).setAttribute("ancho","80" );
      ((Element)v.get(1109)).setAttribute("minimizable","S" );
      ((Element)v.get(1109)).setAttribute("minimizada","N" );
      ((Element)v.get(1104)).appendChild((Element)v.get(1109));
      /* Termina nodo:1109   */

      /* Empieza nodo:1110 / Elemento padre: 1104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1110)).setAttribute("ancho","80" );
      ((Element)v.get(1110)).setAttribute("minimizable","S" );
      ((Element)v.get(1110)).setAttribute("minimizada","N" );
      ((Element)v.get(1104)).appendChild((Element)v.get(1110));
      /* Termina nodo:1110   */

      /* Empieza nodo:1111 / Elemento padre: 1104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1111)).setAttribute("ancho","80" );
      ((Element)v.get(1111)).setAttribute("minimizable","S" );
      ((Element)v.get(1111)).setAttribute("minimizada","N" );
      ((Element)v.get(1104)).appendChild((Element)v.get(1111));
      /* Termina nodo:1111   */

      /* Empieza nodo:1112 / Elemento padre: 1104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1112)).setAttribute("ancho","110" );
      ((Element)v.get(1112)).setAttribute("minimizable","S" );
      ((Element)v.get(1112)).setAttribute("minimizada","N" );
      ((Element)v.get(1104)).appendChild((Element)v.get(1112));
      /* Termina nodo:1112   */

      /* Empieza nodo:1113 / Elemento padre: 1104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1113)).setAttribute("ancho","100" );
      ((Element)v.get(1113)).setAttribute("minimizable","S" );
      ((Element)v.get(1113)).setAttribute("minimizada","N" );
      ((Element)v.get(1104)).appendChild((Element)v.get(1113));
      /* Termina nodo:1113   */

      /* Empieza nodo:1114 / Elemento padre: 1104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1114)).setAttribute("ancho","80" );
      ((Element)v.get(1114)).setAttribute("minimizable","S" );
      ((Element)v.get(1114)).setAttribute("minimizada","N" );
      ((Element)v.get(1104)).appendChild((Element)v.get(1114));
      /* Termina nodo:1114   */

      /* Empieza nodo:1115 / Elemento padre: 1104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1115)).setAttribute("ancho","80" );
      ((Element)v.get(1115)).setAttribute("minimizable","S" );
      ((Element)v.get(1115)).setAttribute("minimizada","N" );
   }

   private void getXML4770(Document doc) {
      ((Element)v.get(1104)).appendChild((Element)v.get(1115));
      /* Termina nodo:1115   */

      /* Empieza nodo:1116 / Elemento padre: 1104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1116)).setAttribute("ancho","100" );
      ((Element)v.get(1116)).setAttribute("minimizable","S" );
      ((Element)v.get(1116)).setAttribute("minimizada","N" );
      ((Element)v.get(1104)).appendChild((Element)v.get(1116));
      /* Termina nodo:1116   */

      /* Empieza nodo:1117 / Elemento padre: 1104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1117)).setAttribute("ancho","80" );
      ((Element)v.get(1117)).setAttribute("minimizable","S" );
      ((Element)v.get(1117)).setAttribute("minimizada","N" );
      ((Element)v.get(1117)).setAttribute("oculta","S" );
      ((Element)v.get(1104)).appendChild((Element)v.get(1117));
      /* Termina nodo:1117   */

      /* Empieza nodo:1118 / Elemento padre: 1104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1118)).setAttribute("ancho","80" );
      ((Element)v.get(1118)).setAttribute("minimizable","S" );
      ((Element)v.get(1118)).setAttribute("minimizada","N" );
      ((Element)v.get(1118)).setAttribute("oculta","S" );
      ((Element)v.get(1104)).appendChild((Element)v.get(1118));
      /* Termina nodo:1118   */

      /* Empieza nodo:1119 / Elemento padre: 1104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1119)).setAttribute("ancho","80" );
      ((Element)v.get(1119)).setAttribute("minimizable","S" );
      ((Element)v.get(1119)).setAttribute("minimizada","N" );
      ((Element)v.get(1119)).setAttribute("oculta","S" );
      ((Element)v.get(1104)).appendChild((Element)v.get(1119));
      /* Termina nodo:1119   */

      /* Empieza nodo:1120 / Elemento padre: 1104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1120)).setAttribute("ancho","80" );
      ((Element)v.get(1120)).setAttribute("minimizable","S" );
      ((Element)v.get(1120)).setAttribute("minimizada","N" );
      ((Element)v.get(1120)).setAttribute("oculta","S" );
      ((Element)v.get(1104)).appendChild((Element)v.get(1120));
      /* Termina nodo:1120   */
      /* Termina nodo:1104   */

      /* Empieza nodo:1121 / Elemento padre: 1095   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(1121)).setAttribute("alto","50" );
      ((Element)v.get(1121)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(1121)).setAttribute("imgFondo","" );
      ((Element)v.get(1121)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(1095)).appendChild((Element)v.get(1121));

      /* Empieza nodo:1122 / Elemento padre: 1121   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1122)).setAttribute("colFondo","" );
      ((Element)v.get(1122)).setAttribute("ID","EstCab" );
      ((Element)v.get(1122)).setAttribute("cod","337" );
      ((Element)v.get(1121)).appendChild((Element)v.get(1122));

      /* Elemento padre:1122 / Elemento actual: 1123   */
      v.add(doc.createTextNode("Cód. producto"));
      ((Element)v.get(1122)).appendChild((Text)v.get(1123));

      /* Termina nodo Texto:1123   */
      /* Termina nodo:1122   */

      /* Empieza nodo:1124 / Elemento padre: 1121   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1124)).setAttribute("colFondo","" );
      ((Element)v.get(1124)).setAttribute("ID","EstCab" );
      ((Element)v.get(1124)).setAttribute("cod","3439" );
      ((Element)v.get(1121)).appendChild((Element)v.get(1124));

      /* Elemento padre:1124 / Elemento actual: 1125   */
      v.add(doc.createTextNode("Des. producto"));
      ((Element)v.get(1124)).appendChild((Text)v.get(1125));

      /* Termina nodo Texto:1125   */
      /* Termina nodo:1124   */

      /* Empieza nodo:1126 / Elemento padre: 1121   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1126)).setAttribute("colFondo","" );
      ((Element)v.get(1126)).setAttribute("ID","EstCab" );
      ((Element)v.get(1126)).setAttribute("cod","495" );
      ((Element)v.get(1121)).appendChild((Element)v.get(1126));

      /* Elemento padre:1126 / Elemento actual: 1127   */
      v.add(doc.createTextNode("Nº unidades"));
      ((Element)v.get(1126)).appendChild((Text)v.get(1127));

      /* Termina nodo Texto:1127   */
      /* Termina nodo:1126   */

      /* Empieza nodo:1128 / Elemento padre: 1121   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1128)).setAttribute("colFondo","" );
      ((Element)v.get(1128)).setAttribute("ID","EstCab" );
      ((Element)v.get(1128)).setAttribute("cod","1854" );
      ((Element)v.get(1121)).appendChild((Element)v.get(1128));

      /* Elemento padre:1128 / Elemento actual: 1129   */
      v.add(doc.createTextNode("Precio público"));
      ((Element)v.get(1128)).appendChild((Text)v.get(1129));

      /* Termina nodo Texto:1129   */
      /* Termina nodo:1128   */

      /* Empieza nodo:1130 / Elemento padre: 1121   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1130)).setAttribute("colFondo","" );
      ((Element)v.get(1130)).setAttribute("ID","EstCab" );
      ((Element)v.get(1130)).setAttribute("cod","1851" );
      ((Element)v.get(1121)).appendChild((Element)v.get(1130));

      /* Elemento padre:1130 / Elemento actual: 1131   */
      v.add(doc.createTextNode("Despacha articulo"));
      ((Element)v.get(1130)).appendChild((Text)v.get(1131));

      /* Termina nodo Texto:1131   */
      /* Termina nodo:1130   */

      /* Empieza nodo:1132 / Elemento padre: 1121   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1132)).setAttribute("colFondo","" );
      ((Element)v.get(1132)).setAttribute("ID","EstCab" );
      ((Element)v.get(1132)).setAttribute("cod","1853" );
      ((Element)v.get(1121)).appendChild((Element)v.get(1132));

      /* Elemento padre:1132 / Elemento actual: 1133   */
      v.add(doc.createTextNode("Cód. venta ficticio"));
      ((Element)v.get(1132)).appendChild((Text)v.get(1133));

      /* Termina nodo Texto:1133   */
      /* Termina nodo:1132   */

      /* Empieza nodo:1134 / Elemento padre: 1121   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1134)).setAttribute("colFondo","" );
      ((Element)v.get(1134)).setAttribute("ID","EstCab" );
      ((Element)v.get(1134)).setAttribute("cod","3184" );
      ((Element)v.get(1121)).appendChild((Element)v.get(1134));

      /* Elemento padre:1134 / Elemento actual: 1135   */
      v.add(doc.createTextNode("Ind Centro Servicio Garantia"));
      ((Element)v.get(1134)).appendChild((Text)v.get(1135));

      /* Termina nodo Texto:1135   */
      /* Termina nodo:1134   */

      /* Empieza nodo:1136 / Elemento padre: 1121   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1136)).setAttribute("colFondo","" );
      ((Element)v.get(1136)).setAttribute("ID","EstCab" );
      ((Element)v.get(1136)).setAttribute("cod","3185" );
      ((Element)v.get(1121)).appendChild((Element)v.get(1136));

      /* Elemento padre:1136 / Elemento actual: 1137   */
   }

   private void getXML4860(Document doc) {
      v.add(doc.createTextNode("Centro Servicio Garantia"));
      ((Element)v.get(1136)).appendChild((Text)v.get(1137));

      /* Termina nodo Texto:1137   */
      /* Termina nodo:1136   */

      /* Empieza nodo:1138 / Elemento padre: 1121   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1138)).setAttribute("colFondo","" );
      ((Element)v.get(1138)).setAttribute("ID","EstCab" );
      ((Element)v.get(1138)).setAttribute("cod","3186" );
      ((Element)v.get(1121)).appendChild((Element)v.get(1138));

      /* Elemento padre:1138 / Elemento actual: 1139   */
      v.add(doc.createTextNode("Num de meses"));
      ((Element)v.get(1138)).appendChild((Text)v.get(1139));

      /* Termina nodo Texto:1139   */
      /* Termina nodo:1138   */

      /* Empieza nodo:1140 / Elemento padre: 1121   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1140)).setAttribute("colFondo","" );
      ((Element)v.get(1140)).setAttribute("ID","EstCab" );
      ((Element)v.get(1140)).setAttribute("cod","169" );
      ((Element)v.get(1121)).appendChild((Element)v.get(1140));

      /* Elemento padre:1140 / Elemento actual: 1141   */
      v.add(doc.createTextNode("Observaciones"));
      ((Element)v.get(1140)).appendChild((Text)v.get(1141));

      /* Termina nodo Texto:1141   */
      /* Termina nodo:1140   */

      /* Empieza nodo:1142 / Elemento padre: 1121   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1142)).setAttribute("colFondo","" );
      ((Element)v.get(1142)).setAttribute("ID","EstCab" );
      ((Element)v.get(1142)).setAttribute("cod","3187" );
      ((Element)v.get(1121)).appendChild((Element)v.get(1142));

      /* Elemento padre:1142 / Elemento actual: 1143   */
      v.add(doc.createTextNode("Tipo de entrega"));
      ((Element)v.get(1142)).appendChild((Text)v.get(1143));

      /* Termina nodo Texto:1143   */
      /* Termina nodo:1142   */

      /* Empieza nodo:1144 / Elemento padre: 1121   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1144)).setAttribute("colFondo","" );
      ((Element)v.get(1144)).setAttribute("ID","EstCab" );
      ((Element)v.get(1144)).setAttribute("cod","3188" );
      ((Element)v.get(1121)).appendChild((Element)v.get(1144));

      /* Elemento padre:1144 / Elemento actual: 1145   */
      v.add(doc.createTextNode("Centro Servicio Entrega"));
      ((Element)v.get(1144)).appendChild((Text)v.get(1145));

      /* Termina nodo Texto:1145   */
      /* Termina nodo:1144   */

      /* Empieza nodo:1146 / Elemento padre: 1121   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1146)).setAttribute("colFondo","" );
      ((Element)v.get(1146)).setAttribute("ID","EstCab" );
      ((Element)v.get(1121)).appendChild((Element)v.get(1146));

      /* Elemento padre:1146 / Elemento actual: 1147   */
      v.add(doc.createTextNode("oidCentSerGar"));
      ((Element)v.get(1146)).appendChild((Text)v.get(1147));

      /* Termina nodo Texto:1147   */
      /* Termina nodo:1146   */

      /* Empieza nodo:1148 / Elemento padre: 1121   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1148)).setAttribute("colFondo","" );
      ((Element)v.get(1148)).setAttribute("ID","EstCab" );
      ((Element)v.get(1121)).appendChild((Element)v.get(1148));

      /* Elemento padre:1148 / Elemento actual: 1149   */
      v.add(doc.createTextNode("oidCentSerEntrega"));
      ((Element)v.get(1148)).appendChild((Text)v.get(1149));

      /* Termina nodo Texto:1149   */
      /* Termina nodo:1148   */

      /* Empieza nodo:1150 / Elemento padre: 1121   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1150)).setAttribute("colFondo","" );
      ((Element)v.get(1150)).setAttribute("ID","EstCab" );
      ((Element)v.get(1121)).appendChild((Element)v.get(1150));

      /* Elemento padre:1150 / Elemento actual: 1151   */
      v.add(doc.createTextNode("oidProdArticulo"));
      ((Element)v.get(1150)).appendChild((Text)v.get(1151));

      /* Termina nodo Texto:1151   */
      /* Termina nodo:1150   */

      /* Empieza nodo:1152 / Elemento padre: 1121   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1152)).setAttribute("colFondo","" );
      ((Element)v.get(1152)).setAttribute("ID","EstCab" );
      ((Element)v.get(1121)).appendChild((Element)v.get(1152));

      /* Elemento padre:1152 / Elemento actual: 1153   */
      v.add(doc.createTextNode("oidProductoLote"));
      ((Element)v.get(1152)).appendChild((Text)v.get(1153));

      /* Termina nodo Texto:1153   */
      /* Termina nodo:1152   */
      /* Termina nodo:1121   */

      /* Empieza nodo:1154 / Elemento padre: 1095   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(1154)).setAttribute("alto","22" );
      ((Element)v.get(1154)).setAttribute("accion","" );
      ((Element)v.get(1154)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(1154)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(1154)).setAttribute("maxSel","-1" );
      ((Element)v.get(1154)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(1154)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(1154)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(1154)).setAttribute("onLoad","" );
      ((Element)v.get(1154)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(1095)).appendChild((Element)v.get(1154));

      /* Empieza nodo:1155 / Elemento padre: 1154   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1155)).setAttribute("tipo","texto" );
      ((Element)v.get(1155)).setAttribute("ID","EstDat" );
      ((Element)v.get(1154)).appendChild((Element)v.get(1155));
      /* Termina nodo:1155   */

      /* Empieza nodo:1156 / Elemento padre: 1154   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1156)).setAttribute("tipo","texto" );
      ((Element)v.get(1156)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1154)).appendChild((Element)v.get(1156));
      /* Termina nodo:1156   */

      /* Empieza nodo:1157 / Elemento padre: 1154   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1157)).setAttribute("tipo","texto" );
      ((Element)v.get(1157)).setAttribute("ID","EstDat" );
      ((Element)v.get(1154)).appendChild((Element)v.get(1157));
      /* Termina nodo:1157   */

      /* Empieza nodo:1158 / Elemento padre: 1154   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1158)).setAttribute("tipo","texto" );
      ((Element)v.get(1158)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1154)).appendChild((Element)v.get(1158));
      /* Termina nodo:1158   */

      /* Empieza nodo:1159 / Elemento padre: 1154   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1159)).setAttribute("tipo","texto" );
      ((Element)v.get(1159)).setAttribute("ID","EstDat" );
      ((Element)v.get(1154)).appendChild((Element)v.get(1159));
      /* Termina nodo:1159   */

      /* Empieza nodo:1160 / Elemento padre: 1154   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1160)).setAttribute("tipo","texto" );
      ((Element)v.get(1160)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1154)).appendChild((Element)v.get(1160));
      /* Termina nodo:1160   */

      /* Empieza nodo:1161 / Elemento padre: 1154   */
   }

   private void getXML4950(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(1161)).setAttribute("tipo","texto" );
      ((Element)v.get(1161)).setAttribute("ID","EstDat" );
      ((Element)v.get(1154)).appendChild((Element)v.get(1161));
      /* Termina nodo:1161   */

      /* Empieza nodo:1162 / Elemento padre: 1154   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1162)).setAttribute("tipo","texto" );
      ((Element)v.get(1162)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1154)).appendChild((Element)v.get(1162));
      /* Termina nodo:1162   */

      /* Empieza nodo:1163 / Elemento padre: 1154   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1163)).setAttribute("tipo","texto" );
      ((Element)v.get(1163)).setAttribute("ID","EstDat" );
      ((Element)v.get(1154)).appendChild((Element)v.get(1163));
      /* Termina nodo:1163   */

      /* Empieza nodo:1164 / Elemento padre: 1154   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1164)).setAttribute("tipo","texto" );
      ((Element)v.get(1164)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1154)).appendChild((Element)v.get(1164));
      /* Termina nodo:1164   */

      /* Empieza nodo:1165 / Elemento padre: 1154   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1165)).setAttribute("tipo","texto" );
      ((Element)v.get(1165)).setAttribute("ID","EstDat" );
      ((Element)v.get(1154)).appendChild((Element)v.get(1165));
      /* Termina nodo:1165   */

      /* Empieza nodo:1166 / Elemento padre: 1154   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1166)).setAttribute("tipo","texto" );
      ((Element)v.get(1166)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1154)).appendChild((Element)v.get(1166));
      /* Termina nodo:1166   */

      /* Empieza nodo:1167 / Elemento padre: 1154   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1167)).setAttribute("tipo","texto" );
      ((Element)v.get(1167)).setAttribute("ID","EstDat" );
      ((Element)v.get(1154)).appendChild((Element)v.get(1167));
      /* Termina nodo:1167   */

      /* Empieza nodo:1168 / Elemento padre: 1154   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1168)).setAttribute("tipo","texto" );
      ((Element)v.get(1168)).setAttribute("ID","EstDat" );
      ((Element)v.get(1154)).appendChild((Element)v.get(1168));
      /* Termina nodo:1168   */

      /* Empieza nodo:1169 / Elemento padre: 1154   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1169)).setAttribute("tipo","texto" );
      ((Element)v.get(1169)).setAttribute("ID","EstDat" );
      ((Element)v.get(1154)).appendChild((Element)v.get(1169));
      /* Termina nodo:1169   */

      /* Empieza nodo:1170 / Elemento padre: 1154   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1170)).setAttribute("tipo","texto" );
      ((Element)v.get(1170)).setAttribute("ID","EstDat" );
      ((Element)v.get(1154)).appendChild((Element)v.get(1170));
      /* Termina nodo:1170   */
      /* Termina nodo:1154   */

      /* Empieza nodo:1171 / Elemento padre: 1095   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(1095)).appendChild((Element)v.get(1171));
      /* Termina nodo:1171   */

      /* Empieza nodo:1172 / Elemento padre: 1095   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(1172)).setAttribute("nombre","mipgndo2" );
      ((Element)v.get(1172)).setAttribute("ancho","676" );
      ((Element)v.get(1172)).setAttribute("sep","$" );
      ((Element)v.get(1172)).setAttribute("x","40" );
      ((Element)v.get(1172)).setAttribute("class","botonera" );
      ((Element)v.get(1172)).setAttribute("y","1137" );
      ((Element)v.get(1172)).setAttribute("control","|" );
      ((Element)v.get(1172)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(1172)).setAttribute("rowset","" );
      ((Element)v.get(1172)).setAttribute("cargainicial","N" );
      ((Element)v.get(1095)).appendChild((Element)v.get(1172));

      /* Empieza nodo:1173 / Elemento padre: 1172   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1173)).setAttribute("nombre","ret2" );
      ((Element)v.get(1173)).setAttribute("x","63" );
      ((Element)v.get(1173)).setAttribute("y","1141" );
      ((Element)v.get(1173)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1173)).setAttribute("img","retroceder_on" );
      ((Element)v.get(1173)).setAttribute("tipo","0" );
      ((Element)v.get(1173)).setAttribute("estado","false" );
      ((Element)v.get(1173)).setAttribute("alt","" );
      ((Element)v.get(1173)).setAttribute("codigo","" );
      ((Element)v.get(1173)).setAttribute("accion","mipgndo2.retroceder();" );
      ((Element)v.get(1172)).appendChild((Element)v.get(1173));
      /* Termina nodo:1173   */

      /* Empieza nodo:1174 / Elemento padre: 1172   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1174)).setAttribute("nombre","ava2" );
      ((Element)v.get(1174)).setAttribute("x","78" );
      ((Element)v.get(1174)).setAttribute("y","1141" );
      ((Element)v.get(1174)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1174)).setAttribute("img","avanzar_on" );
      ((Element)v.get(1174)).setAttribute("tipo","0" );
      ((Element)v.get(1174)).setAttribute("estado","false" );
      ((Element)v.get(1174)).setAttribute("alt","" );
      ((Element)v.get(1174)).setAttribute("codigo","" );
      ((Element)v.get(1174)).setAttribute("accion","mipgndo2.avanzar();" );
      ((Element)v.get(1172)).appendChild((Element)v.get(1174));
      /* Termina nodo:1174   */
      /* Termina nodo:1172   */
      /* Termina nodo:1095   */

      /* Empieza nodo:1175 / Elemento padre: 36   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1175)).setAttribute("nombre","primera2" );
      ((Element)v.get(1175)).setAttribute("x","56" );
      ((Element)v.get(1175)).setAttribute("y","1141" );
      ((Element)v.get(1175)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1175)).setAttribute("img","primera_on" );
      ((Element)v.get(1175)).setAttribute("tipo","-2" );
      ((Element)v.get(1175)).setAttribute("estado","false" );
      ((Element)v.get(1175)).setAttribute("alt","" );
      ((Element)v.get(1175)).setAttribute("codigo","" );
      ((Element)v.get(1175)).setAttribute("accion","mipgndo2.retrocederPrimeraPagina();" );
      ((Element)v.get(36)).appendChild((Element)v.get(1175));
      /* Termina nodo:1175   */

      /* Empieza nodo:1176 / Elemento padre: 36   */
   }

   private void getXML5040(Document doc) {
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1176)).setAttribute("nombre","separa2" );
      ((Element)v.get(1176)).setAttribute("x","85" );
      ((Element)v.get(1176)).setAttribute("y","1137" );
      ((Element)v.get(1176)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1176)).setAttribute("img","separa_base" );
      ((Element)v.get(1176)).setAttribute("tipo","0" );
      ((Element)v.get(1176)).setAttribute("estado","false" );
      ((Element)v.get(1176)).setAttribute("alt","" );
      ((Element)v.get(1176)).setAttribute("codigo","" );
      ((Element)v.get(1176)).setAttribute("accion","" );
      ((Element)v.get(36)).appendChild((Element)v.get(1176));
      /* Termina nodo:1176   */

      /* Empieza nodo:1177 / Elemento padre: 36   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(1177)).setAttribute("nombre","listado4" );
      ((Element)v.get(1177)).setAttribute("ancho","703" );
      ((Element)v.get(1177)).setAttribute("alto","278" );
      ((Element)v.get(1177)).setAttribute("x","26" );
      ((Element)v.get(1177)).setAttribute("y","381" );
      ((Element)v.get(1177)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(1177)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(36)).appendChild((Element)v.get(1177));

      /* Empieza nodo:1178 / Elemento padre: 1177   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(1178)).setAttribute("precarga","S" );
      ((Element)v.get(1178)).setAttribute("conROver","S" );
      ((Element)v.get(1177)).appendChild((Element)v.get(1178));

      /* Empieza nodo:1179 / Elemento padre: 1178   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(1179)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(1179)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(1179)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(1179)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(1178)).appendChild((Element)v.get(1179));
      /* Termina nodo:1179   */

      /* Empieza nodo:1180 / Elemento padre: 1178   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(1180)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(1180)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(1180)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(1180)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(1178)).appendChild((Element)v.get(1180));
      /* Termina nodo:1180   */

      /* Empieza nodo:1181 / Elemento padre: 1178   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(1181)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(1181)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(1178)).appendChild((Element)v.get(1181));
      /* Termina nodo:1181   */
      /* Termina nodo:1178   */

      /* Empieza nodo:1182 / Elemento padre: 1177   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(1177)).appendChild((Element)v.get(1182));

      /* Empieza nodo:1183 / Elemento padre: 1182   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(1183)).setAttribute("borde","1" );
      ((Element)v.get(1183)).setAttribute("horizDatos","1" );
      ((Element)v.get(1183)).setAttribute("horizCabecera","1" );
      ((Element)v.get(1183)).setAttribute("vertical","0" );
      ((Element)v.get(1183)).setAttribute("horizTitulo","1" );
      ((Element)v.get(1183)).setAttribute("horizBase","1" );
      ((Element)v.get(1182)).appendChild((Element)v.get(1183));
      /* Termina nodo:1183   */

      /* Empieza nodo:1184 / Elemento padre: 1182   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(1184)).setAttribute("borde","#999999" );
      ((Element)v.get(1184)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(1184)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(1184)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(1184)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(1184)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(1184)).setAttribute("horizBase","#999999" );
      ((Element)v.get(1182)).appendChild((Element)v.get(1184));
      /* Termina nodo:1184   */
      /* Termina nodo:1182   */

      /* Empieza nodo:1185 / Elemento padre: 1177   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(1185)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(1185)).setAttribute("alto","22" );
      ((Element)v.get(1185)).setAttribute("imgFondo","" );
      ((Element)v.get(1185)).setAttribute("cod","00592" );
      ((Element)v.get(1185)).setAttribute("ID","datosTitle" );
      ((Element)v.get(1177)).appendChild((Element)v.get(1185));
      /* Termina nodo:1185   */

      /* Empieza nodo:1186 / Elemento padre: 1177   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(1186)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(1186)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(1186)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(1186)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(1186)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(1186)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(1177)).appendChild((Element)v.get(1186));

      /* Empieza nodo:1187 / Elemento padre: 1186   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1187)).setAttribute("ancho","26" );
      ((Element)v.get(1187)).setAttribute("minimizable","S" );
      ((Element)v.get(1187)).setAttribute("minimizada","N" );
      ((Element)v.get(1186)).appendChild((Element)v.get(1187));
      /* Termina nodo:1187   */

      /* Empieza nodo:1188 / Elemento padre: 1186   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1188)).setAttribute("ancho","26" );
      ((Element)v.get(1188)).setAttribute("minimizable","S" );
      ((Element)v.get(1188)).setAttribute("minimizada","N" );
      ((Element)v.get(1186)).appendChild((Element)v.get(1188));
      /* Termina nodo:1188   */

      /* Empieza nodo:1189 / Elemento padre: 1186   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1189)).setAttribute("ancho","26" );
      ((Element)v.get(1189)).setAttribute("minimizable","S" );
      ((Element)v.get(1189)).setAttribute("minimizada","N" );
      ((Element)v.get(1189)).setAttribute("oculta","S" );
   }

   private void getXML5130(Document doc) {
      ((Element)v.get(1186)).appendChild((Element)v.get(1189));
      /* Termina nodo:1189   */

      /* Empieza nodo:1190 / Elemento padre: 1186   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1190)).setAttribute("ancho","26" );
      ((Element)v.get(1190)).setAttribute("minimizable","S" );
      ((Element)v.get(1190)).setAttribute("minimizada","N" );
      ((Element)v.get(1190)).setAttribute("oculta","S" );
      ((Element)v.get(1186)).appendChild((Element)v.get(1190));
      /* Termina nodo:1190   */
      /* Termina nodo:1186   */

      /* Empieza nodo:1191 / Elemento padre: 1177   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(1191)).setAttribute("alto","20" );
      ((Element)v.get(1191)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(1191)).setAttribute("imgFondo","" );
      ((Element)v.get(1191)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(1177)).appendChild((Element)v.get(1191));

      /* Empieza nodo:1192 / Elemento padre: 1191   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1192)).setAttribute("colFondo","" );
      ((Element)v.get(1192)).setAttribute("ID","EstCab" );
      ((Element)v.get(1192)).setAttribute("cod","1691" );
      ((Element)v.get(1191)).appendChild((Element)v.get(1192));

      /* Elemento padre:1192 / Elemento actual: 1193   */
      v.add(doc.createTextNode("Nº premio"));
      ((Element)v.get(1192)).appendChild((Text)v.get(1193));

      /* Termina nodo Texto:1193   */
      /* Termina nodo:1192   */

      /* Empieza nodo:1194 / Elemento padre: 1191   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1194)).setAttribute("colFondo","" );
      ((Element)v.get(1194)).setAttribute("ID","EstCab" );
      ((Element)v.get(1194)).setAttribute("cod","844" );
      ((Element)v.get(1191)).appendChild((Element)v.get(1194));

      /* Elemento padre:1194 / Elemento actual: 1195   */
      v.add(doc.createTextNode("Descripción lote"));
      ((Element)v.get(1194)).appendChild((Text)v.get(1195));

      /* Termina nodo Texto:1195   */
      /* Termina nodo:1194   */

      /* Empieza nodo:1196 / Elemento padre: 1191   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1196)).setAttribute("colFondo","" );
      ((Element)v.get(1196)).setAttribute("ID","EstCab" );
      ((Element)v.get(1191)).appendChild((Element)v.get(1196));

      /* Elemento padre:1196 / Elemento actual: 1197   */
      v.add(doc.createTextNode("oidLote"));
      ((Element)v.get(1196)).appendChild((Text)v.get(1197));

      /* Termina nodo Texto:1197   */
      /* Termina nodo:1196   */

      /* Empieza nodo:1198 / Elemento padre: 1191   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1198)).setAttribute("colFondo","" );
      ((Element)v.get(1198)).setAttribute("ID","EstCab" );
      ((Element)v.get(1191)).appendChild((Element)v.get(1198));

      /* Elemento padre:1198 / Elemento actual: 1199   */
      v.add(doc.createTextNode("listProdLote"));
      ((Element)v.get(1198)).appendChild((Text)v.get(1199));

      /* Termina nodo Texto:1199   */
      /* Termina nodo:1198   */
      /* Termina nodo:1191   */

      /* Empieza nodo:1200 / Elemento padre: 1177   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(1200)).setAttribute("alto","22" );
      ((Element)v.get(1200)).setAttribute("accion","onSelectLotesPremio(FILAEVENTO);" );
      ((Element)v.get(1200)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(1200)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(1200)).setAttribute("maxSel","1" );
      ((Element)v.get(1200)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(1200)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(1200)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(1200)).setAttribute("onLoad","" );
      ((Element)v.get(1200)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(1177)).appendChild((Element)v.get(1200));

      /* Empieza nodo:1201 / Elemento padre: 1200   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1201)).setAttribute("tipo","texto" );
      ((Element)v.get(1201)).setAttribute("ID","EstDat" );
      ((Element)v.get(1200)).appendChild((Element)v.get(1201));
      /* Termina nodo:1201   */

      /* Empieza nodo:1202 / Elemento padre: 1200   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1202)).setAttribute("tipo","texto" );
      ((Element)v.get(1202)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1200)).appendChild((Element)v.get(1202));
      /* Termina nodo:1202   */

      /* Empieza nodo:1203 / Elemento padre: 1200   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1203)).setAttribute("tipo","texto" );
      ((Element)v.get(1203)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1200)).appendChild((Element)v.get(1203));
      /* Termina nodo:1203   */

      /* Empieza nodo:1204 / Elemento padre: 1200   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1204)).setAttribute("tipo","texto" );
      ((Element)v.get(1204)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1200)).appendChild((Element)v.get(1204));
      /* Termina nodo:1204   */
      /* Termina nodo:1200   */

      /* Empieza nodo:1205 / Elemento padre: 1177   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(1177)).appendChild((Element)v.get(1205));
      /* Termina nodo:1205   */

      /* Empieza nodo:1206 / Elemento padre: 1177   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(1206)).setAttribute("nombre","mipgndo4" );
      ((Element)v.get(1206)).setAttribute("ancho","703" );
      ((Element)v.get(1206)).setAttribute("sep","$" );
      ((Element)v.get(1206)).setAttribute("x","26" );
      ((Element)v.get(1206)).setAttribute("class","botonera" );
      ((Element)v.get(1206)).setAttribute("y","637" );
      ((Element)v.get(1206)).setAttribute("control","|" );
      ((Element)v.get(1206)).setAttribute("conector","conectorSandra1" );
      ((Element)v.get(1206)).setAttribute("rowset","" );
      ((Element)v.get(1206)).setAttribute("cargainicial","N" );
      ((Element)v.get(1177)).appendChild((Element)v.get(1206));

      /* Empieza nodo:1207 / Elemento padre: 1206   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1207)).setAttribute("nombre","ret4" );
      ((Element)v.get(1207)).setAttribute("x","51" );
      ((Element)v.get(1207)).setAttribute("y","681" );
      ((Element)v.get(1207)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1207)).setAttribute("img","retroceder_on" );
      ((Element)v.get(1207)).setAttribute("tipo","0" );
      ((Element)v.get(1207)).setAttribute("estado","false" );
      ((Element)v.get(1207)).setAttribute("alt","" );
   }

   private void getXML5220(Document doc) {
      ((Element)v.get(1207)).setAttribute("codigo","" );
      ((Element)v.get(1207)).setAttribute("accion","mipgndo4.retroceder();" );
      ((Element)v.get(1206)).appendChild((Element)v.get(1207));
      /* Termina nodo:1207   */

      /* Empieza nodo:1208 / Elemento padre: 1206   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1208)).setAttribute("nombre","ava4" );
      ((Element)v.get(1208)).setAttribute("x","66" );
      ((Element)v.get(1208)).setAttribute("y","681" );
      ((Element)v.get(1208)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1208)).setAttribute("img","avanzar_on" );
      ((Element)v.get(1208)).setAttribute("tipo","0" );
      ((Element)v.get(1208)).setAttribute("estado","false" );
      ((Element)v.get(1208)).setAttribute("alt","" );
      ((Element)v.get(1208)).setAttribute("codigo","" );
      ((Element)v.get(1208)).setAttribute("accion","mipgndo4.avanzar();" );
      ((Element)v.get(1206)).appendChild((Element)v.get(1208));
      /* Termina nodo:1208   */
      /* Termina nodo:1206   */
      /* Termina nodo:1177   */

      /* Empieza nodo:1209 / Elemento padre: 36   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1209)).setAttribute("nombre","primera4" );
      ((Element)v.get(1209)).setAttribute("x","34" );
      ((Element)v.get(1209)).setAttribute("y","641" );
      ((Element)v.get(1209)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1209)).setAttribute("img","primera_on" );
      ((Element)v.get(1209)).setAttribute("tipo","-2" );
      ((Element)v.get(1209)).setAttribute("estado","false" );
      ((Element)v.get(1209)).setAttribute("alt","" );
      ((Element)v.get(1209)).setAttribute("codigo","" );
      ((Element)v.get(1209)).setAttribute("accion","mipgndo4.retrocederPrimeraPagina();" );
      ((Element)v.get(36)).appendChild((Element)v.get(1209));
      /* Termina nodo:1209   */

      /* Empieza nodo:1210 / Elemento padre: 36   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1210)).setAttribute("nombre","separa4" );
      ((Element)v.get(1210)).setAttribute("x","73" );
      ((Element)v.get(1210)).setAttribute("y","637" );
      ((Element)v.get(1210)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1210)).setAttribute("img","separa_base" );
      ((Element)v.get(1210)).setAttribute("tipo","0" );
      ((Element)v.get(1210)).setAttribute("estado","false" );
      ((Element)v.get(1210)).setAttribute("alt","" );
      ((Element)v.get(1210)).setAttribute("codigo","" );
      ((Element)v.get(1210)).setAttribute("accion","" );
      ((Element)v.get(36)).appendChild((Element)v.get(1210));
      /* Termina nodo:1210   */

      /* Empieza nodo:1211 / Elemento padre: 36   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(1211)).setAttribute("nombre","listado3" );
      ((Element)v.get(1211)).setAttribute("ancho","703" );
      ((Element)v.get(1211)).setAttribute("alto","317" );
      ((Element)v.get(1211)).setAttribute("x","26" );
      ((Element)v.get(1211)).setAttribute("y","614" );
      ((Element)v.get(1211)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(1211)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(36)).appendChild((Element)v.get(1211));

      /* Empieza nodo:1212 / Elemento padre: 1211   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(1212)).setAttribute("precarga","S" );
      ((Element)v.get(1212)).setAttribute("conROver","S" );
      ((Element)v.get(1211)).appendChild((Element)v.get(1212));

      /* Empieza nodo:1213 / Elemento padre: 1212   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(1213)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(1213)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(1213)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(1213)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(1212)).appendChild((Element)v.get(1213));
      /* Termina nodo:1213   */

      /* Empieza nodo:1214 / Elemento padre: 1212   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(1214)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(1214)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(1214)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(1214)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(1212)).appendChild((Element)v.get(1214));
      /* Termina nodo:1214   */

      /* Empieza nodo:1215 / Elemento padre: 1212   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(1215)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(1215)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(1212)).appendChild((Element)v.get(1215));
      /* Termina nodo:1215   */
      /* Termina nodo:1212   */

      /* Empieza nodo:1216 / Elemento padre: 1211   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(1211)).appendChild((Element)v.get(1216));

      /* Empieza nodo:1217 / Elemento padre: 1216   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(1217)).setAttribute("borde","1" );
      ((Element)v.get(1217)).setAttribute("horizDatos","1" );
      ((Element)v.get(1217)).setAttribute("horizCabecera","1" );
      ((Element)v.get(1217)).setAttribute("vertical","0" );
      ((Element)v.get(1217)).setAttribute("horizTitulo","1" );
      ((Element)v.get(1217)).setAttribute("horizBase","1" );
      ((Element)v.get(1216)).appendChild((Element)v.get(1217));
      /* Termina nodo:1217   */

      /* Empieza nodo:1218 / Elemento padre: 1216   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(1218)).setAttribute("borde","#999999" );
      ((Element)v.get(1218)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(1218)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(1218)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(1218)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(1218)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(1218)).setAttribute("horizBase","#999999" );
      ((Element)v.get(1216)).appendChild((Element)v.get(1218));
      /* Termina nodo:1218   */
      /* Termina nodo:1216   */

      /* Empieza nodo:1219 / Elemento padre: 1211   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(1219)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(1219)).setAttribute("alto","22" );
   }

   private void getXML5310(Document doc) {
      ((Element)v.get(1219)).setAttribute("imgFondo","" );
      ((Element)v.get(1219)).setAttribute("cod","00357" );
      ((Element)v.get(1219)).setAttribute("ID","datosTitle" );
      ((Element)v.get(1211)).appendChild((Element)v.get(1219));
      /* Termina nodo:1219   */

      /* Empieza nodo:1220 / Elemento padre: 1211   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(1220)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(1220)).setAttribute("alto","22" );
      ((Element)v.get(1220)).setAttribute("imgFondo","" );
      ((Element)v.get(1211)).appendChild((Element)v.get(1220));
      /* Termina nodo:1220   */

      /* Empieza nodo:1221 / Elemento padre: 1211   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(1221)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(1221)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(1221)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(1221)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(1221)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(1221)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(1211)).appendChild((Element)v.get(1221));

      /* Empieza nodo:1222 / Elemento padre: 1221   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1222)).setAttribute("ancho","80" );
      ((Element)v.get(1222)).setAttribute("minimizable","S" );
      ((Element)v.get(1222)).setAttribute("minimizada","N" );
      ((Element)v.get(1221)).appendChild((Element)v.get(1222));
      /* Termina nodo:1222   */

      /* Empieza nodo:1223 / Elemento padre: 1221   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1223)).setAttribute("ancho","80" );
      ((Element)v.get(1223)).setAttribute("minimizable","S" );
      ((Element)v.get(1223)).setAttribute("minimizada","N" );
      ((Element)v.get(1221)).appendChild((Element)v.get(1223));
      /* Termina nodo:1223   */

      /* Empieza nodo:1224 / Elemento padre: 1221   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1224)).setAttribute("ancho","80" );
      ((Element)v.get(1224)).setAttribute("minimizable","S" );
      ((Element)v.get(1224)).setAttribute("minimizada","N" );
      ((Element)v.get(1221)).appendChild((Element)v.get(1224));
      /* Termina nodo:1224   */

      /* Empieza nodo:1225 / Elemento padre: 1221   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1225)).setAttribute("ancho","80" );
      ((Element)v.get(1225)).setAttribute("minimizable","S" );
      ((Element)v.get(1225)).setAttribute("minimizada","N" );
      ((Element)v.get(1221)).appendChild((Element)v.get(1225));
      /* Termina nodo:1225   */

      /* Empieza nodo:1226 / Elemento padre: 1221   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1226)).setAttribute("ancho","80" );
      ((Element)v.get(1226)).setAttribute("minimizable","S" );
      ((Element)v.get(1226)).setAttribute("minimizada","N" );
      ((Element)v.get(1221)).appendChild((Element)v.get(1226));
      /* Termina nodo:1226   */

      /* Empieza nodo:1227 / Elemento padre: 1221   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1227)).setAttribute("ancho","80" );
      ((Element)v.get(1227)).setAttribute("minimizable","S" );
      ((Element)v.get(1227)).setAttribute("minimizada","N" );
      ((Element)v.get(1221)).appendChild((Element)v.get(1227));
      /* Termina nodo:1227   */

      /* Empieza nodo:1228 / Elemento padre: 1221   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1228)).setAttribute("ancho","80" );
      ((Element)v.get(1228)).setAttribute("minimizable","S" );
      ((Element)v.get(1228)).setAttribute("minimizada","N" );
      ((Element)v.get(1228)).setAttribute("oculta","S" );
      ((Element)v.get(1221)).appendChild((Element)v.get(1228));
      /* Termina nodo:1228   */

      /* Empieza nodo:1229 / Elemento padre: 1221   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1229)).setAttribute("ancho","80" );
      ((Element)v.get(1229)).setAttribute("minimizable","S" );
      ((Element)v.get(1229)).setAttribute("minimizada","N" );
      ((Element)v.get(1229)).setAttribute("oculta","S" );
      ((Element)v.get(1221)).appendChild((Element)v.get(1229));
      /* Termina nodo:1229   */

      /* Empieza nodo:1230 / Elemento padre: 1221   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1230)).setAttribute("ancho","80" );
      ((Element)v.get(1230)).setAttribute("minimizable","S" );
      ((Element)v.get(1230)).setAttribute("minimizada","N" );
      ((Element)v.get(1230)).setAttribute("oculta","S" );
      ((Element)v.get(1221)).appendChild((Element)v.get(1230));
      /* Termina nodo:1230   */

      /* Empieza nodo:1231 / Elemento padre: 1221   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1231)).setAttribute("ancho","80" );
      ((Element)v.get(1231)).setAttribute("minimizable","S" );
      ((Element)v.get(1231)).setAttribute("minimizada","N" );
      ((Element)v.get(1231)).setAttribute("oculta","S" );
      ((Element)v.get(1221)).appendChild((Element)v.get(1231));
      /* Termina nodo:1231   */

      /* Empieza nodo:1232 / Elemento padre: 1221   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1232)).setAttribute("ancho","80" );
      ((Element)v.get(1232)).setAttribute("minimizable","S" );
      ((Element)v.get(1232)).setAttribute("minimizada","N" );
      ((Element)v.get(1232)).setAttribute("oculta","S" );
      ((Element)v.get(1221)).appendChild((Element)v.get(1232));
      /* Termina nodo:1232   */

      /* Empieza nodo:1233 / Elemento padre: 1221   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1233)).setAttribute("ancho","80" );
      ((Element)v.get(1233)).setAttribute("minimizable","S" );
      ((Element)v.get(1233)).setAttribute("minimizada","N" );
      ((Element)v.get(1233)).setAttribute("oculta","S" );
      ((Element)v.get(1221)).appendChild((Element)v.get(1233));
      /* Termina nodo:1233   */

      /* Empieza nodo:1234 / Elemento padre: 1221   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1234)).setAttribute("ancho","80" );
      ((Element)v.get(1234)).setAttribute("minimizable","S" );
      ((Element)v.get(1234)).setAttribute("minimizada","N" );
      ((Element)v.get(1234)).setAttribute("oculta","S" );
      ((Element)v.get(1221)).appendChild((Element)v.get(1234));
      /* Termina nodo:1234   */
      /* Termina nodo:1221   */

      /* Empieza nodo:1235 / Elemento padre: 1211   */
      v.add(doc.createElement("CABECERA"));
   }

   private void getXML5400(Document doc) {
      ((Element)v.get(1235)).setAttribute("alto","20" );
      ((Element)v.get(1235)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(1235)).setAttribute("imgFondo","" );
      ((Element)v.get(1235)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(1211)).appendChild((Element)v.get(1235));

      /* Empieza nodo:1236 / Elemento padre: 1235   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1236)).setAttribute("colFondo","" );
      ((Element)v.get(1236)).setAttribute("ID","EstCab" );
      ((Element)v.get(1236)).setAttribute("cod","6" );
      ((Element)v.get(1235)).appendChild((Element)v.get(1236));

      /* Elemento padre:1236 / Elemento actual: 1237   */
      v.add(doc.createTextNode("Marca"));
      ((Element)v.get(1236)).appendChild((Text)v.get(1237));

      /* Termina nodo Texto:1237   */
      /* Termina nodo:1236   */

      /* Empieza nodo:1238 / Elemento padre: 1235   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1238)).setAttribute("colFondo","" );
      ((Element)v.get(1238)).setAttribute("ID","EstCab" );
      ((Element)v.get(1238)).setAttribute("cod","1338" );
      ((Element)v.get(1235)).appendChild((Element)v.get(1238));

      /* Elemento padre:1238 / Elemento actual: 1239   */
      v.add(doc.createTextNode("Unidad negocio"));
      ((Element)v.get(1238)).appendChild((Text)v.get(1239));

      /* Termina nodo Texto:1239   */
      /* Termina nodo:1238   */

      /* Empieza nodo:1240 / Elemento padre: 1235   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1240)).setAttribute("colFondo","" );
      ((Element)v.get(1240)).setAttribute("ID","EstCab" );
      ((Element)v.get(1240)).setAttribute("cod","588" );
      ((Element)v.get(1235)).appendChild((Element)v.get(1240));

      /* Elemento padre:1240 / Elemento actual: 1241   */
      v.add(doc.createTextNode("Negocio"));
      ((Element)v.get(1240)).appendChild((Text)v.get(1241));

      /* Termina nodo Texto:1241   */
      /* Termina nodo:1240   */

      /* Empieza nodo:1242 / Elemento padre: 1235   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1242)).setAttribute("colFondo","" );
      ((Element)v.get(1242)).setAttribute("ID","EstCab" );
      ((Element)v.get(1242)).setAttribute("cod","590" );
      ((Element)v.get(1235)).appendChild((Element)v.get(1242));

      /* Elemento padre:1242 / Elemento actual: 1243   */
      v.add(doc.createTextNode("Supergenérico"));
      ((Element)v.get(1242)).appendChild((Text)v.get(1243));

      /* Termina nodo Texto:1243   */
      /* Termina nodo:1242   */

      /* Empieza nodo:1244 / Elemento padre: 1235   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1244)).setAttribute("colFondo","" );
      ((Element)v.get(1244)).setAttribute("ID","EstCab" );
      ((Element)v.get(1244)).setAttribute("cod","589" );
      ((Element)v.get(1235)).appendChild((Element)v.get(1244));

      /* Elemento padre:1244 / Elemento actual: 1245   */
      v.add(doc.createTextNode("Genérico"));
      ((Element)v.get(1244)).appendChild((Text)v.get(1245));

      /* Termina nodo Texto:1245   */
      /* Termina nodo:1244   */

      /* Empieza nodo:1246 / Elemento padre: 1235   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1246)).setAttribute("colFondo","" );
      ((Element)v.get(1246)).setAttribute("ID","EstCab" );
      ((Element)v.get(1246)).setAttribute("cod","337" );
      ((Element)v.get(1235)).appendChild((Element)v.get(1246));

      /* Elemento padre:1246 / Elemento actual: 1247   */
      v.add(doc.createTextNode("Cód. producto"));
      ((Element)v.get(1246)).appendChild((Text)v.get(1247));

      /* Termina nodo Texto:1247   */
      /* Termina nodo:1246   */

      /* Empieza nodo:1248 / Elemento padre: 1235   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1248)).setAttribute("colFondo","" );
      ((Element)v.get(1248)).setAttribute("ID","EstCab" );
      ((Element)v.get(1235)).appendChild((Element)v.get(1248));

      /* Elemento padre:1248 / Elemento actual: 1249   */
      v.add(doc.createTextNode("oidMarca"));
      ((Element)v.get(1248)).appendChild((Text)v.get(1249));

      /* Termina nodo Texto:1249   */
      /* Termina nodo:1248   */

      /* Empieza nodo:1250 / Elemento padre: 1235   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1250)).setAttribute("colFondo","" );
      ((Element)v.get(1250)).setAttribute("ID","EstCab" );
      ((Element)v.get(1235)).appendChild((Element)v.get(1250));

      /* Elemento padre:1250 / Elemento actual: 1251   */
      v.add(doc.createTextNode("oidUnidadNeg"));
      ((Element)v.get(1250)).appendChild((Text)v.get(1251));

      /* Termina nodo Texto:1251   */
      /* Termina nodo:1250   */

      /* Empieza nodo:1252 / Elemento padre: 1235   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1252)).setAttribute("colFondo","" );
      ((Element)v.get(1252)).setAttribute("ID","EstCab" );
      ((Element)v.get(1235)).appendChild((Element)v.get(1252));

      /* Elemento padre:1252 / Elemento actual: 1253   */
      v.add(doc.createTextNode("oidNegocio"));
      ((Element)v.get(1252)).appendChild((Text)v.get(1253));

      /* Termina nodo Texto:1253   */
      /* Termina nodo:1252   */

      /* Empieza nodo:1254 / Elemento padre: 1235   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1254)).setAttribute("colFondo","" );
      ((Element)v.get(1254)).setAttribute("ID","EstCab" );
      ((Element)v.get(1235)).appendChild((Element)v.get(1254));

      /* Elemento padre:1254 / Elemento actual: 1255   */
      v.add(doc.createTextNode("oidSupergenerico"));
      ((Element)v.get(1254)).appendChild((Text)v.get(1255));

      /* Termina nodo Texto:1255   */
      /* Termina nodo:1254   */

      /* Empieza nodo:1256 / Elemento padre: 1235   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1256)).setAttribute("colFondo","" );
      ((Element)v.get(1256)).setAttribute("ID","EstCab" );
      ((Element)v.get(1235)).appendChild((Element)v.get(1256));

      /* Elemento padre:1256 / Elemento actual: 1257   */
      v.add(doc.createTextNode("oidGenerico"));
      ((Element)v.get(1256)).appendChild((Text)v.get(1257));

      /* Termina nodo Texto:1257   */
      /* Termina nodo:1256   */

      /* Empieza nodo:1258 / Elemento padre: 1235   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1258)).setAttribute("colFondo","" );
      ((Element)v.get(1258)).setAttribute("ID","EstCab" );
      ((Element)v.get(1235)).appendChild((Element)v.get(1258));

      /* Elemento padre:1258 / Elemento actual: 1259   */
      v.add(doc.createTextNode("oidProd"));
      ((Element)v.get(1258)).appendChild((Text)v.get(1259));

      /* Termina nodo Texto:1259   */
      /* Termina nodo:1258   */

      /* Empieza nodo:1260 / Elemento padre: 1235   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1260)).setAttribute("colFondo","" );
      ((Element)v.get(1260)).setAttribute("ID","EstCab" );
      ((Element)v.get(1235)).appendChild((Element)v.get(1260));

      /* Elemento padre:1260 / Elemento actual: 1261   */
      v.add(doc.createTextNode("oidArticulo"));
      ((Element)v.get(1260)).appendChild((Text)v.get(1261));

      /* Termina nodo Texto:1261   */
      /* Termina nodo:1260   */
      /* Termina nodo:1235   */

      /* Empieza nodo:1262 / Elemento padre: 1211   */
      v.add(doc.createElement("DATOS"));
   }

   private void getXML5490(Document doc) {
      ((Element)v.get(1262)).setAttribute("alto","22" );
      ((Element)v.get(1262)).setAttribute("accion","" );
      ((Element)v.get(1262)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(1262)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(1262)).setAttribute("maxSel","-1" );
      ((Element)v.get(1262)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(1262)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(1262)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(1262)).setAttribute("onLoad","" );
      ((Element)v.get(1262)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(1211)).appendChild((Element)v.get(1262));

      /* Empieza nodo:1263 / Elemento padre: 1262   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1263)).setAttribute("tipo","texto" );
      ((Element)v.get(1263)).setAttribute("ID","EstDat" );
      ((Element)v.get(1262)).appendChild((Element)v.get(1263));
      /* Termina nodo:1263   */

      /* Empieza nodo:1264 / Elemento padre: 1262   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1264)).setAttribute("tipo","texto" );
      ((Element)v.get(1264)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1262)).appendChild((Element)v.get(1264));
      /* Termina nodo:1264   */

      /* Empieza nodo:1265 / Elemento padre: 1262   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1265)).setAttribute("tipo","texto" );
      ((Element)v.get(1265)).setAttribute("ID","EstDat" );
      ((Element)v.get(1262)).appendChild((Element)v.get(1265));
      /* Termina nodo:1265   */

      /* Empieza nodo:1266 / Elemento padre: 1262   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1266)).setAttribute("tipo","texto" );
      ((Element)v.get(1266)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1262)).appendChild((Element)v.get(1266));
      /* Termina nodo:1266   */

      /* Empieza nodo:1267 / Elemento padre: 1262   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1267)).setAttribute("tipo","texto" );
      ((Element)v.get(1267)).setAttribute("ID","EstDat" );
      ((Element)v.get(1262)).appendChild((Element)v.get(1267));
      /* Termina nodo:1267   */

      /* Empieza nodo:1268 / Elemento padre: 1262   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1268)).setAttribute("tipo","texto" );
      ((Element)v.get(1268)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1262)).appendChild((Element)v.get(1268));
      /* Termina nodo:1268   */

      /* Empieza nodo:1269 / Elemento padre: 1262   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1269)).setAttribute("tipo","texto" );
      ((Element)v.get(1269)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1262)).appendChild((Element)v.get(1269));
      /* Termina nodo:1269   */

      /* Empieza nodo:1270 / Elemento padre: 1262   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1270)).setAttribute("tipo","texto" );
      ((Element)v.get(1270)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1262)).appendChild((Element)v.get(1270));
      /* Termina nodo:1270   */

      /* Empieza nodo:1271 / Elemento padre: 1262   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1271)).setAttribute("tipo","texto" );
      ((Element)v.get(1271)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1262)).appendChild((Element)v.get(1271));
      /* Termina nodo:1271   */

      /* Empieza nodo:1272 / Elemento padre: 1262   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1272)).setAttribute("tipo","texto" );
      ((Element)v.get(1272)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1262)).appendChild((Element)v.get(1272));
      /* Termina nodo:1272   */

      /* Empieza nodo:1273 / Elemento padre: 1262   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1273)).setAttribute("tipo","texto" );
      ((Element)v.get(1273)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1262)).appendChild((Element)v.get(1273));
      /* Termina nodo:1273   */

      /* Empieza nodo:1274 / Elemento padre: 1262   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1274)).setAttribute("tipo","texto" );
      ((Element)v.get(1274)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1262)).appendChild((Element)v.get(1274));
      /* Termina nodo:1274   */

      /* Empieza nodo:1275 / Elemento padre: 1262   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1275)).setAttribute("tipo","texto" );
      ((Element)v.get(1275)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1262)).appendChild((Element)v.get(1275));
      /* Termina nodo:1275   */
      /* Termina nodo:1262   */

      /* Empieza nodo:1276 / Elemento padre: 1211   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(1211)).appendChild((Element)v.get(1276));
      /* Termina nodo:1276   */

      /* Empieza nodo:1277 / Elemento padre: 1211   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(1277)).setAttribute("nombre","mipgndo3" );
      ((Element)v.get(1277)).setAttribute("ancho","703" );
      ((Element)v.get(1277)).setAttribute("sep","$" );
      ((Element)v.get(1277)).setAttribute("x","26" );
      ((Element)v.get(1277)).setAttribute("class","botonera" );
      ((Element)v.get(1277)).setAttribute("y","908" );
      ((Element)v.get(1277)).setAttribute("control","|" );
      ((Element)v.get(1277)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(1277)).setAttribute("rowset","" );
      ((Element)v.get(1277)).setAttribute("cargainicial","N" );
      ((Element)v.get(1211)).appendChild((Element)v.get(1277));

      /* Empieza nodo:1278 / Elemento padre: 1277   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1278)).setAttribute("nombre","ret3" );
      ((Element)v.get(1278)).setAttribute("x","51" );
      ((Element)v.get(1278)).setAttribute("y","912" );
      ((Element)v.get(1278)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1278)).setAttribute("img","retroceder_on" );
      ((Element)v.get(1278)).setAttribute("tipo","0" );
      ((Element)v.get(1278)).setAttribute("estado","false" );
      ((Element)v.get(1278)).setAttribute("alt","" );
      ((Element)v.get(1278)).setAttribute("codigo","" );
      ((Element)v.get(1278)).setAttribute("accion","mipgndo3.retroceder();" );
      ((Element)v.get(1277)).appendChild((Element)v.get(1278));
      /* Termina nodo:1278   */

      /* Empieza nodo:1279 / Elemento padre: 1277   */
      v.add(doc.createElement("BOTON"));
   }

   private void getXML5580(Document doc) {
      ((Element)v.get(1279)).setAttribute("nombre","ava3" );
      ((Element)v.get(1279)).setAttribute("x","66" );
      ((Element)v.get(1279)).setAttribute("y","912" );
      ((Element)v.get(1279)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1279)).setAttribute("img","avanzar_on" );
      ((Element)v.get(1279)).setAttribute("tipo","0" );
      ((Element)v.get(1279)).setAttribute("estado","false" );
      ((Element)v.get(1279)).setAttribute("alt","" );
      ((Element)v.get(1279)).setAttribute("codigo","" );
      ((Element)v.get(1279)).setAttribute("accion","mipgndo3.avanzar();" );
      ((Element)v.get(1277)).appendChild((Element)v.get(1279));
      /* Termina nodo:1279   */
      /* Termina nodo:1277   */
      /* Termina nodo:1211   */

      /* Empieza nodo:1280 / Elemento padre: 36   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1280)).setAttribute("nombre","primera3" );
      ((Element)v.get(1280)).setAttribute("x","34" );
      ((Element)v.get(1280)).setAttribute("y","912" );
      ((Element)v.get(1280)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1280)).setAttribute("img","primera_on" );
      ((Element)v.get(1280)).setAttribute("tipo","-2" );
      ((Element)v.get(1280)).setAttribute("estado","false" );
      ((Element)v.get(1280)).setAttribute("alt","" );
      ((Element)v.get(1280)).setAttribute("codigo","" );
      ((Element)v.get(1280)).setAttribute("accion","mipgndo3.retrocederPrimeraPagina();" );
      ((Element)v.get(36)).appendChild((Element)v.get(1280));
      /* Termina nodo:1280   */

      /* Empieza nodo:1281 / Elemento padre: 36   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1281)).setAttribute("nombre","separa3" );
      ((Element)v.get(1281)).setAttribute("x","73" );
      ((Element)v.get(1281)).setAttribute("y","908" );
      ((Element)v.get(1281)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1281)).setAttribute("img","separa_base" );
      ((Element)v.get(1281)).setAttribute("tipo","0" );
      ((Element)v.get(1281)).setAttribute("estado","false" );
      ((Element)v.get(1281)).setAttribute("alt","" );
      ((Element)v.get(1281)).setAttribute("codigo","" );
      ((Element)v.get(1281)).setAttribute("accion","" );
      ((Element)v.get(36)).appendChild((Element)v.get(1281));
      /* Termina nodo:1281   */

      /* Empieza nodo:1282 / Elemento padre: 36   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1282)).setAttribute("nombre","btnEliminar" );
      ((Element)v.get(1282)).setAttribute("x","27" );
      ((Element)v.get(1282)).setAttribute("y","909" );
      ((Element)v.get(1282)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1282)).setAttribute("accion","accionEliminarArticulo()" );
      ((Element)v.get(1282)).setAttribute("tipo","html" );
      ((Element)v.get(1282)).setAttribute("estado","false" );
      ((Element)v.get(1282)).setAttribute("cod","1254" );
      ((Element)v.get(36)).appendChild((Element)v.get(1282));
      /* Termina nodo:1282   */
      /* Termina nodo:36   */


   }

}
