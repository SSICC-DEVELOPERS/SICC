
import org.w3c.dom.*;
import java.util.ArrayList;

public class pestana_cliente_basico  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","pestana_cliente_basico" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("titulo","Cliente básico" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#E5E5E5" );
      ((Element)v.get(0)).setAttribute("msgle","Cliente básico" );
      ((Element)v.get(0)).setAttribute("onload","" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(1)).setAttribute("nombre","frmFormulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Empieza nodo:2 / Elemento padre: 1   */
      v.add(doc.createElement("table"));
      ((Element)v.get(2)).setAttribute("width","100%" );
      ((Element)v.get(2)).setAttribute("height","100%" );
      ((Element)v.get(2)).setAttribute("border","0" );
      ((Element)v.get(2)).setAttribute("align","center" );
      ((Element)v.get(2)).setAttribute("cellpadding","0" );
      ((Element)v.get(2)).setAttribute("cellspacing","0" );
      ((Element)v.get(2)).setAttribute("class","menu4" );
      ((Element)v.get(1)).appendChild((Element)v.get(2));

      /* Empieza nodo:3 / Elemento padre: 2   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(2)).appendChild((Element)v.get(3));

      /* Empieza nodo:4 / Elemento padre: 3   */
      v.add(doc.createElement("td"));
      ((Element)v.get(4)).setAttribute("width","12" );
      ((Element)v.get(4)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(4)).setAttribute("class","menu5texto" );
      ((Element)v.get(3)).appendChild((Element)v.get(4));

      /* Empieza nodo:5 / Elemento padre: 4   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(5)).setAttribute("src","b.gif" );
      ((Element)v.get(5)).setAttribute("width","12" );
      ((Element)v.get(5)).setAttribute("height","30" );
      ((Element)v.get(4)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */
      /* Termina nodo:4   */

      /* Empieza nodo:6 / Elemento padre: 3   */
      v.add(doc.createElement("td"));
      ((Element)v.get(6)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(6)).setAttribute("class","menu5texto" );
      ((Element)v.get(3)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(7)).setAttribute("src","b.gif" );
      ((Element)v.get(7)).setAttribute("witdh","8" );
      ((Element)v.get(7)).setAttribute("height","8" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */
      /* Termina nodo:6   */

      /* Empieza nodo:8 / Elemento padre: 3   */
      v.add(doc.createElement("td"));
      ((Element)v.get(8)).setAttribute("width","10" );
      ((Element)v.get(8)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(8)).setAttribute("class","menu5texto" );
      ((Element)v.get(3)).appendChild((Element)v.get(8));

      /* Empieza nodo:9 / Elemento padre: 8   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(9)).setAttribute("src","b.gif" );
      ((Element)v.get(9)).setAttribute("width","10" );
      ((Element)v.get(9)).setAttribute("height","8" );
      ((Element)v.get(8)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */
      /* Termina nodo:8   */

      /* Empieza nodo:10 / Elemento padre: 3   */
      v.add(doc.createElement("td"));
      ((Element)v.get(10)).setAttribute("width","92" );
      ((Element)v.get(10)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(10)).setAttribute("class","menu5texto" );
      ((Element)v.get(3)).appendChild((Element)v.get(10));

      /* Empieza nodo:11 / Elemento padre: 10   */
      v.add(doc.createElement("table"));
      ((Element)v.get(11)).setAttribute("width","75" );
      ((Element)v.get(11)).setAttribute("border","1" );
      ((Element)v.get(11)).setAttribute("align","center" );
      ((Element)v.get(11)).setAttribute("cellpadding","1" );
      ((Element)v.get(11)).setAttribute("cellspacing","0" );
      ((Element)v.get(11)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(10)).appendChild((Element)v.get(11));

      /* Empieza nodo:12 / Elemento padre: 11   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(12)).setAttribute("align","center" );
      ((Element)v.get(11)).appendChild((Element)v.get(12));

      /* Empieza nodo:13 / Elemento padre: 12   */
      v.add(doc.createElement("td"));
      ((Element)v.get(13)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(13)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(12)).appendChild((Element)v.get(13));

      /* Elemento padre:13 / Elemento actual: 14   */
      v.add(doc.createTextNode("Pestaña 1"));
      ((Element)v.get(13)).appendChild((Text)v.get(14));

      /* Termina nodo Texto:14   */
      /* Termina nodo:13   */
      /* Termina nodo:12   */
      /* Termina nodo:11   */
      /* Termina nodo:10   */

      /* Empieza nodo:15 / Elemento padre: 3   */
      v.add(doc.createElement("td"));
      ((Element)v.get(15)).setAttribute("width","10" );
      ((Element)v.get(15)).setAttribute("class","menu5texto" );
      ((Element)v.get(3)).appendChild((Element)v.get(15));

      /* Empieza nodo:16 / Elemento padre: 15   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(16)).setAttribute("src","b.gif" );
      ((Element)v.get(16)).setAttribute("width","10" );
      ((Element)v.get(16)).setAttribute("height","8" );
      ((Element)v.get(15)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */
      /* Termina nodo:15   */

      /* Empieza nodo:17 / Elemento padre: 3   */
      v.add(doc.createElement("td"));
      ((Element)v.get(17)).setAttribute("width","20" );
      ((Element)v.get(17)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(17)).setAttribute("class","menu5texto" );
      ((Element)v.get(3)).appendChild((Element)v.get(17));

      /* Empieza nodo:18 / Elemento padre: 17   */
      v.add(doc.createElement("table"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(18)).setAttribute("width","75" );
      ((Element)v.get(18)).setAttribute("border","1" );
      ((Element)v.get(18)).setAttribute("align","center" );
      ((Element)v.get(18)).setAttribute("cellpadding","1" );
      ((Element)v.get(18)).setAttribute("cellspacing","0" );
      ((Element)v.get(18)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(17)).appendChild((Element)v.get(18));

      /* Empieza nodo:19 / Elemento padre: 18   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(19)).setAttribute("align","center" );
      ((Element)v.get(18)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("td"));
      ((Element)v.get(20)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(20)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(19)).appendChild((Element)v.get(20));

      /* Elemento padre:20 / Elemento actual: 21   */
      v.add(doc.createTextNode("Pestaña 2"));
      ((Element)v.get(20)).appendChild((Text)v.get(21));

      /* Termina nodo Texto:21   */
      /* Termina nodo:20   */
      /* Termina nodo:19   */
      /* Termina nodo:18   */
      /* Termina nodo:17   */

      /* Empieza nodo:22 / Elemento padre: 3   */
      v.add(doc.createElement("td"));
      ((Element)v.get(22)).setAttribute("width","10" );
      ((Element)v.get(22)).setAttribute("class","menu5texto" );
      ((Element)v.get(3)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(23)).setAttribute("src","b.gif" );
      ((Element)v.get(23)).setAttribute("width","10" );
      ((Element)v.get(23)).setAttribute("height","8" );
      ((Element)v.get(22)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */
      /* Termina nodo:22   */

      /* Empieza nodo:24 / Elemento padre: 3   */
      v.add(doc.createElement("td"));
      ((Element)v.get(24)).setAttribute("width","20" );
      ((Element)v.get(24)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(24)).setAttribute("class","menu5texto" );
      ((Element)v.get(3)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("table"));
      ((Element)v.get(25)).setAttribute("width","75" );
      ((Element)v.get(25)).setAttribute("border","1" );
      ((Element)v.get(25)).setAttribute("align","center" );
      ((Element)v.get(25)).setAttribute("cellpadding","1" );
      ((Element)v.get(25)).setAttribute("cellspacing","0" );
      ((Element)v.get(25)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(25)).setAttribute("bgcolor","#496A9A" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(26)).setAttribute("align","center" );
      ((Element)v.get(25)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(27)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(27)).setAttribute("class","menu5textoblanca" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));

      /* Elemento padre:27 / Elemento actual: 28   */
      v.add(doc.createTextNode("Pestaña 3"));
      ((Element)v.get(27)).appendChild((Text)v.get(28));

      /* Termina nodo Texto:28   */
      /* Termina nodo:27   */
      /* Termina nodo:26   */
      /* Termina nodo:25   */
      /* Termina nodo:24   */

      /* Empieza nodo:29 / Elemento padre: 3   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).setAttribute("width","16" );
      ((Element)v.get(29)).setAttribute("class","menu5texto" );
      ((Element)v.get(3)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(30)).setAttribute("src","b.gif" );
      ((Element)v.get(30)).setAttribute("width","12" );
      ((Element)v.get(30)).setAttribute("height","8" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */
      /* Termina nodo:29   */
      /* Termina nodo:3   */
      /* Termina nodo:2   */
      /* Termina nodo:1   */


   }

}
