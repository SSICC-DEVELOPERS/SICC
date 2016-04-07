
import org.w3c.dom.*;
import java.util.ArrayList;

public class menu_usuario  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","nombre" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","" );
      ((Element)v.get(0)).setAttribute("colorf","#999999" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","carga();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("ESTILO"));
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Elemento padre:1 / Elemento actual: 2   */
      v.add(doc.createTextNode("\r		A.menu1{ font-family: Arial; font-size: 12px; color: #000000; text-decoration: none; text-align: left; height: 10px; } "));
      ((Element)v.get(1)).appendChild((Text)v.get(2));

      /* Termina nodo Texto:2   */

      /* Elemento padre:1 / Elemento actual: 3   */
      v.add(doc.createTextNode("\r		A.menu1:hover {font-family: Arial, Helvetica; font-size: 12px; color: #000000; font-weight:bold; text-align: left ; text-decoration: none; background-image: url(../img/es/menuresaltado.gif);} "));
      ((Element)v.get(1)).appendChild((Text)v.get(3));

      /* Termina nodo Texto:3   */

      /* Elemento padre:1 / Elemento actual: 4   */
      v.add(doc.createTextNode("\r		A.menu1:active  {font-family: Arial, Helvetica; font-size: 12px; color: #000000; font-weight:bold; text-decoration: none; background-image: url(../img/es/menuresaltado.gif);}\r		A.menu2{ font-family: Arial; font-size: 12px;  color: #000000; text-decoration: none; text-align: left; height: 10px; } "));
      ((Element)v.get(1)).appendChild((Text)v.get(4));

      /* Termina nodo Texto:4   */

      /* Elemento padre:1 / Elemento actual: 5   */
      v.add(doc.createTextNode("\r		A.menu2:hover {font-family: Arial, Helvetica; font-size: 12px; color: #000000;  font-weight:bold; text-align: left ; text-decoration: none;  background-image: url(../img/es/menuresaltado.gif);} "));
      ((Element)v.get(1)).appendChild((Text)v.get(5));

      /* Termina nodo Texto:5   */

      /* Elemento padre:1 / Elemento actual: 6   */
      v.add(doc.createTextNode("\r		A.menu2:active  {font-family: Arial, Helvetica; font-size: 12px; color: #000000;  font-weight:bold; text-decoration: none; background-image: url(../img/es/menuresaltado.gif);}\r		A.menu3{ font-family: Arial; font-size: 12px; color: #496A9A; text-decoration: none; text-align: left; height: 10px; } "));
      ((Element)v.get(1)).appendChild((Text)v.get(6));

      /* Termina nodo Texto:6   */

      /* Elemento padre:1 / Elemento actual: 7   */
      v.add(doc.createTextNode("\r		A.menu3:hover {font-family: Arial, Helvetica; font-size: 12px; color: #496A9A; font-weight:bold; text-align: left ; text-decoration: none;  background-image: url(../img/es/menuresaltado.gif);} "));
      ((Element)v.get(1)).appendChild((Text)v.get(7));

      /* Termina nodo Texto:7   */

      /* Elemento padre:1 / Elemento actual: 8   */
      v.add(doc.createTextNode("\r		A.menu3:active  {font-family: Arial, Helvetica; font-size: 12px; color: #496A9A; font-weight:bold; text-decoration: none; background-image: url(../img/es/menuresaltado.gif);} "));
      ((Element)v.get(1)).appendChild((Text)v.get(8));

      /* Termina nodo Texto:8   */

      /* Elemento padre:1 / Elemento actual: 9   */
      v.add(doc.createTextNode("\r		A.menu4{ font-family: Arial; font-size: 12px; color: #496A9A; text-decoration: none; text-align: left; height: 10px; } "));
      ((Element)v.get(1)).appendChild((Text)v.get(9));

      /* Termina nodo Texto:9   */

      /* Elemento padre:1 / Elemento actual: 10   */
      v.add(doc.createTextNode("\r		A.menu4:hover {font-family: Arial, Helvetica; font-size: 12px; color: #496A9A; font-weight:bold; text-align: left ; text-decoration: none;  background-image: url(../img/es/menuresaltado.gif);} "));
      ((Element)v.get(1)).appendChild((Text)v.get(10));

      /* Termina nodo Texto:10   */

      /* Elemento padre:1 / Elemento actual: 11   */
      v.add(doc.createTextNode("\r		A.menu4:active  {font-family: Arial, Helvetica; font-size: 12px; color: #496A9A; font-weight:bold; text-decoration: none; background-image: url(../img/es/menuresaltado.gif);} "));
      ((Element)v.get(1)).appendChild((Text)v.get(11));

      /* Termina nodo Texto:11   */

      /* Elemento padre:1 / Elemento actual: 12   */
      v.add(doc.createTextNode("\r		A.menu5{ font-family: Arial; font-size: 12px; color: #496A9A; text-decoration: none; text-align: left; height: 10px; } "));
      ((Element)v.get(1)).appendChild((Text)v.get(12));

      /* Termina nodo Texto:12   */

      /* Elemento padre:1 / Elemento actual: 13   */
      v.add(doc.createTextNode("\r		A.menu5:hover {font-family: Arial, Helvetica; font-size: 12px; color: #496A9A; font-weight:bold; text-align: left ; text-decoration: none;  background-image: url(../img/es/menuresaltado.gif);} "));
      ((Element)v.get(1)).appendChild((Text)v.get(13));

      /* Termina nodo Texto:13   */

      /* Elemento padre:1 / Elemento actual: 14   */
      v.add(doc.createTextNode("\r		A.menu5:active  {font-family: Arial, Helvetica; font-size: 12px; color: #496A9A; font-weight:bold; text-decoration: none; background-image: url(../img/es/menuresaltado.gif);} "));
      ((Element)v.get(1)).appendChild((Text)v.get(14));

      /* Termina nodo Texto:14   */

      /* Elemento padre:1 / Elemento actual: 15   */
      v.add(doc.createTextNode("\r		A.menu{ font-family: Arial; font-size: 12px; font-weight: bold; color: #000000; background-color: red;text-decoration: none; text-align: left; height: 10px; }\r		.menu{ font-family: Arial; font-size: 12px; font-weight: bold; color: #0000FF; background-color: red;text-decoration: none; text-align: left; height: 10px; }                        \r	"));
      ((Element)v.get(1)).appendChild((Text)v.get(15));

      /* Termina nodo Texto:15   */
      /* Termina nodo:1   */

      /* Empieza nodo:16 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(16)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(17)).setAttribute("src","menu_usuario.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(18)).setAttribute("nombre","frmSalida" );
      ((Element)v.get(0)).appendChild((Element)v.get(18));

      /* Empieza nodo:19 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hidIdFuncion" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","idFuncion" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hidPantallaInicio" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","fromMenu" );
      ((Element)v.get(23)).setAttribute("valor","true" );
      ((Element)v.get(18)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","clean" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */
      /* Termina nodo:18   */


   }

}
