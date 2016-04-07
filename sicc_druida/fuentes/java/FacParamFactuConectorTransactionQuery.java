
import org.w3c.dom.*;
import java.util.ArrayList;

public class FacParamFactuConectorTransactionQuery  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("CONECTOR"));
      ((Element)v.get(0)).setAttribute("TIPO","DRUIDATRANSACTION" );
      ((Element)v.get(0)).setAttribute("REVISION","3.1" );
      ((Element)v.get(0)).setAttribute("NOMBRE","FacParamFactuTransactionQuery" );
      ((Element)v.get(0)).setAttribute("OBSERVACIONES","Conector transaccional para la ejecci�n de query sobre la entidad FacParamFactu" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("ENTRADA"));
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Empieza nodo:2 / Elemento padre: 1   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(2)).setAttribute("NOMBRE","indDocuMonoPagi" );
      ((Element)v.get(2)).setAttribute("TIPO","STRING" );
      ((Element)v.get(2)).setAttribute("LONGITUD","1" );
      ((Element)v.get(1)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 1   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(3)).setAttribute("NOMBRE","valMontLimiUit" );
      ((Element)v.get(3)).setAttribute("TIPO","STRING" );
      ((Element)v.get(3)).setAttribute("LONGITUD","9" );
      ((Element)v.get(1)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 1   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(4)).setAttribute("NOMBRE","numMaxiCampPrd" );
      ((Element)v.get(4)).setAttribute("TIPO","STRING" );
      ((Element)v.get(4)).setAttribute("LONGITUD","2" );
      ((Element)v.get(1)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 1   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(5)).setAttribute("NOMBRE","indTipoProyRegi" );
      ((Element)v.get(5)).setAttribute("TIPO","STRING" );
      ((Element)v.get(5)).setAttribute("LONGITUD","1" );
      ((Element)v.get(1)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 1   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(6)).setAttribute("NOMBRE","indMostVencCupo" );
      ((Element)v.get(6)).setAttribute("TIPO","STRING" );
      ((Element)v.get(6)).setAttribute("LONGITUD","1" );
      ((Element)v.get(1)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 1   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(7)).setAttribute("NOMBRE","numMaxiPediProy" );
      ((Element)v.get(7)).setAttribute("TIPO","STRING" );
      ((Element)v.get(7)).setAttribute("LONGITUD","5" );
      ((Element)v.get(1)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 1   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(8)).setAttribute("NOMBRE","codModaDist" );
      ((Element)v.get(8)).setAttribute("TIPO","STRING" );
      ((Element)v.get(8)).setAttribute("LONGITUD","1" );
      ((Element)v.get(1)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 1   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(9)).setAttribute("NOMBRE","pageCount" );
      ((Element)v.get(9)).setAttribute("TIPO","STRING" );
      ((Element)v.get(9)).setAttribute("LONGITUD","30" );
      ((Element)v.get(1)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 1   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(10)).setAttribute("NOMBRE","pageSize" );
      ((Element)v.get(10)).setAttribute("TIPO","STRING" );
      ((Element)v.get(10)).setAttribute("LONGITUD","30" );
      ((Element)v.get(1)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */
      /* Termina nodo:1   */

      /* Empieza nodo:11 / Elemento padre: 0   */
      v.add(doc.createElement("SALIDA"));
      ((Element)v.get(0)).appendChild((Element)v.get(11));

      /* Empieza nodo:12 / Elemento padre: 11   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(12)).setAttribute("NOMBRE","result" );
      ((Element)v.get(12)).setAttribute("LONGITUD","50" );
      ((Element)v.get(11)).appendChild((Element)v.get(12));

      /* Empieza nodo:13 / Elemento padre: 12   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(13)).setAttribute("NOMBRE","id" );
      ((Element)v.get(13)).setAttribute("TIPO","STRING" );
      ((Element)v.get(13)).setAttribute("LONGITUD","12" );
      ((Element)v.get(12)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 12   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(14)).setAttribute("NOMBRE","indDocuMonoPagi" );
      ((Element)v.get(14)).setAttribute("TIPO","STRING" );
      ((Element)v.get(14)).setAttribute("LONGITUD","1" );
      ((Element)v.get(12)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 12   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(15)).setAttribute("NOMBRE","valMontLimiUit" );
      ((Element)v.get(15)).setAttribute("TIPO","STRING" );
      ((Element)v.get(15)).setAttribute("LONGITUD","9" );
      ((Element)v.get(12)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 12   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(16)).setAttribute("NOMBRE","numMaxiCampPrd" );
      ((Element)v.get(16)).setAttribute("TIPO","STRING" );
      ((Element)v.get(16)).setAttribute("LONGITUD","2" );
      ((Element)v.get(12)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 12   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(17)).setAttribute("NOMBRE","indTipoProyRegi" );
      ((Element)v.get(17)).setAttribute("TIPO","STRING" );
      ((Element)v.get(17)).setAttribute("LONGITUD","1" );
      ((Element)v.get(12)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 12   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(18)).setAttribute("NOMBRE","indMostVencCupo" );
      ((Element)v.get(18)).setAttribute("TIPO","STRING" );
      ((Element)v.get(18)).setAttribute("LONGITUD","1" );
      ((Element)v.get(12)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 12   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(19)).setAttribute("NOMBRE","numMaxiPediProy" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(19)).setAttribute("TIPO","STRING" );
      ((Element)v.get(19)).setAttribute("LONGITUD","5" );
      ((Element)v.get(12)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 12   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(20)).setAttribute("NOMBRE","codModaDist" );
      ((Element)v.get(20)).setAttribute("TIPO","STRING" );
      ((Element)v.get(20)).setAttribute("LONGITUD","1" );
      ((Element)v.get(12)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 12   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(21)).setAttribute("NOMBRE","indCheqClieNuev" );
      ((Element)v.get(21)).setAttribute("TIPO","STRING" );
      ((Element)v.get(21)).setAttribute("LONGITUD","1" );
      ((Element)v.get(12)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 12   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(22)).setAttribute("NOMBRE","timestamp" );
      ((Element)v.get(22)).setAttribute("TIPO","STRING" );
      ((Element)v.get(22)).setAttribute("LONGITUD","30" );
      ((Element)v.get(12)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */
      /* Termina nodo:12   */
      /* Termina nodo:11   */


   }

}