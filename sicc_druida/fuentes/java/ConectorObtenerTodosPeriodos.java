
import org.w3c.dom.*;
import java.util.ArrayList;

public class ConectorObtenerTodosPeriodos  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("CONECTOR"));
      ((Element)v.get(0)).setAttribute("TIPO","EJB" );
      ((Element)v.get(0)).setAttribute("NOMBRE","mare.mln.BusinessFacade" );
      ((Element)v.get(0)).setAttribute("METODO","execute" );
      ((Element)v.get(0)).setAttribute("REVISION","3.1" );
      ((Element)v.get(0)).setAttribute("OBSERVACIONES","" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("ENTRADA"));
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Empieza nodo:2 / Elemento padre: 1   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(2)).setAttribute("NOMBRE","DTOCriteriosPeriodo" );
      ((Element)v.get(2)).setAttribute("TIPO","OBJETO" );
      ((Element)v.get(2)).setAttribute("LONGITUD","50" );
      ((Element)v.get(1)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 1   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(3)).setAttribute("NOMBRE","CRAConsultarPeriodos" );
      ((Element)v.get(3)).setAttribute("TIPO","OBJETO" );
      ((Element)v.get(3)).setAttribute("LONGITUD","50" );
      ((Element)v.get(1)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */
      /* Termina nodo:1   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("SALIDA"));
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Empieza nodo:5 / Elemento padre: 4   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(5)).setAttribute("NOMBRE","dtoSalida.resultado" );
      ((Element)v.get(5)).setAttribute("ID","dtoSalida.resultado" );
      ((Element)v.get(5)).setAttribute("FORMATO","MARETABLA" );
      ((Element)v.get(5)).setAttribute("LONGITUD","50" );
      ((Element)v.get(4)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(6)).setAttribute("NOMBRE","DESC_PAIS" );
      ((Element)v.get(6)).setAttribute("TIPO","STRING" );
      ((Element)v.get(6)).setAttribute("LONGITUD","30" );
      ((Element)v.get(5)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(7)).setAttribute("NOMBRE","DURA" );
      ((Element)v.get(7)).setAttribute("TIPO","INTEGER" );
      ((Element)v.get(7)).setAttribute("LONGITUD","12" );
      ((Element)v.get(5)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(8)).setAttribute("NOMBRE","DES_MARC" );
      ((Element)v.get(8)).setAttribute("TIPO","STRING" );
      ((Element)v.get(8)).setAttribute("LONGITUD","30" );
      ((Element)v.get(5)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(9)).setAttribute("NOMBRE","DESC_CANAL" );
      ((Element)v.get(9)).setAttribute("TIPO","STRING" );
      ((Element)v.get(9)).setAttribute("LONGITUD","12" );
      ((Element)v.get(5)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(10)).setAttribute("NOMBRE","COD_TIPO_PERI" );
      ((Element)v.get(10)).setAttribute("TIPO","STRING" );
      ((Element)v.get(10)).setAttribute("LONGITUD","12" );
      ((Element)v.get(5)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(11)).setAttribute("NOMBRE","COD_PERI" );
      ((Element)v.get(11)).setAttribute("TIPO","STRING" );
      ((Element)v.get(11)).setAttribute("LONGITUD","30" );
      ((Element)v.get(5)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(12)).setAttribute("NOMBRE","VAL_NOMB_PERI" );
      ((Element)v.get(12)).setAttribute("TIPO","STRING" );
      ((Element)v.get(12)).setAttribute("LONGITUD","30" );
      ((Element)v.get(5)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(13)).setAttribute("NOMBRE","FEC_INIC" );
      ((Element)v.get(13)).setAttribute("TIPO","DATE" );
      ((Element)v.get(13)).setAttribute("LONGITUD","8" );
      ((Element)v.get(5)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(14)).setAttribute("NOMBRE","FEC_FINA" );
      ((Element)v.get(14)).setAttribute("TIPO","DATE" );
      ((Element)v.get(14)).setAttribute("LONGITUD","8" );
      ((Element)v.get(5)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(15)).setAttribute("NOMBRE","OID_PERI" );
      ((Element)v.get(15)).setAttribute("TIPO","STRING" );
      ((Element)v.get(15)).setAttribute("LONGITUD","12" );
      ((Element)v.get(5)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(16)).setAttribute("NOMBRE","OID_TIPO_PERI" );
      ((Element)v.get(16)).setAttribute("TIPO","LONG" );
      ((Element)v.get(16)).setAttribute("LONGITUD","12" );
      ((Element)v.get(5)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(17)).setAttribute("NOMBRE","PERI_OID_PERI" );
      ((Element)v.get(17)).setAttribute("TIPO","LONG" );
      ((Element)v.get(17)).setAttribute("LONGITUD","12" );
      ((Element)v.get(5)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(18)).setAttribute("NOMBRE","PAIS_OID_PAIS" );
      ((Element)v.get(18)).setAttribute("TIPO","LONG" );
      ((Element)v.get(18)).setAttribute("LONGITUD","12" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(5)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(19)).setAttribute("NOMBRE","MARC_OID_MARC" );
      ((Element)v.get(19)).setAttribute("TIPO","LONG" );
      ((Element)v.get(19)).setAttribute("LONGITUD","12" );
      ((Element)v.get(5)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(20)).setAttribute("NOMBRE","CANA_OID_CANA" );
      ((Element)v.get(20)).setAttribute("TIPO","LONG" );
      ((Element)v.get(20)).setAttribute("LONGITUD","12" );
      ((Element)v.get(5)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */
      /* Termina nodo:5   */
      /* Termina nodo:4   */

      /* Empieza nodo:21 / Elemento padre: 0   */
      v.add(doc.createElement("TRANSFORMAR"));
      ((Element)v.get(21)).setAttribute("ID","dtoSalida.resultado_ROWSET" );
      ((Element)v.get(0)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("CCAMPO"));
      ((Element)v.get(22)).setAttribute("NOMBRE","OID_PERI" );
      ((Element)v.get(22)).setAttribute("TIPO","STRING" );
      ((Element)v.get(22)).setAttribute("LONGITUD","12" );
      ((Element)v.get(21)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 21   */
      v.add(doc.createElement("CCAMPO"));
      ((Element)v.get(23)).setAttribute("NOMBRE","COD_TIPO_PERI" );
      ((Element)v.get(23)).setAttribute("TIPO","STRING" );
      ((Element)v.get(23)).setAttribute("LONGITUD","30" );
      ((Element)v.get(21)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 21   */
      v.add(doc.createElement("CCAMPO"));
      ((Element)v.get(24)).setAttribute("NOMBRE","VAL_NOMB_PERI" );
      ((Element)v.get(24)).setAttribute("TIPO","STRING" );
      ((Element)v.get(24)).setAttribute("LONGITUD","30" );
      ((Element)v.get(21)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 21   */
      v.add(doc.createElement("CCAMPO"));
      ((Element)v.get(25)).setAttribute("NOMBRE","DURA" );
      ((Element)v.get(25)).setAttribute("TIPO","INTEGER" );
      ((Element)v.get(25)).setAttribute("LONGITUD","3" );
      ((Element)v.get(21)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 21   */
      v.add(doc.createElement("CCAMPO"));
      ((Element)v.get(26)).setAttribute("NOMBRE","FEC_INIC" );
      ((Element)v.get(26)).setAttribute("TIPO","DATE" );
      ((Element)v.get(26)).setAttribute("LONGITUD","3" );
      ((Element)v.get(21)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 21   */
      v.add(doc.createElement("CCAMPO"));
      ((Element)v.get(27)).setAttribute("NOMBRE","FEC_FINA" );
      ((Element)v.get(27)).setAttribute("TIPO","DATE" );
      ((Element)v.get(27)).setAttribute("LONGITUD","3" );
      ((Element)v.get(21)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 21   */
      v.add(doc.createElement("CCAMPO"));
      ((Element)v.get(28)).setAttribute("NOMBRE","OID_TIPO_PERI" );
      ((Element)v.get(28)).setAttribute("TIPO","LONG" );
      ((Element)v.get(28)).setAttribute("LONGITUD","3" );
      ((Element)v.get(21)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 21   */
      v.add(doc.createElement("CCAMPO"));
      ((Element)v.get(29)).setAttribute("NOMBRE","PERI_OID_PERI" );
      ((Element)v.get(29)).setAttribute("TIPO","LONG" );
      ((Element)v.get(29)).setAttribute("LONGITUD","3" );
      ((Element)v.get(21)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 21   */
      v.add(doc.createElement("CCAMPO"));
      ((Element)v.get(30)).setAttribute("NOMBRE","COD_PERI" );
      ((Element)v.get(30)).setAttribute("TIPO","STRING" );
      ((Element)v.get(30)).setAttribute("LONGITUD","30" );
      ((Element)v.get(21)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */
      /* Termina nodo:21   */


   }

}
