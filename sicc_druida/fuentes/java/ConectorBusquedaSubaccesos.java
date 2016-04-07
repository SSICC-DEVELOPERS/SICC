
import org.w3c.dom.*;
import java.util.ArrayList;

public class ConectorBusquedaSubaccesos  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("CONECTOR"));
      ((Element)v.get(0)).setAttribute("TIPO","EJB" );
      ((Element)v.get(0)).setAttribute("NOMBRE","mare.mln.BusinessFacade" );
      ((Element)v.get(0)).setAttribute("METODO","execute" );
      ((Element)v.get(0)).setAttribute("REVISION","3.1" );
      ((Element)v.get(0)).setAttribute("OBSERVACIONES","Busqueda Subaccesos" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("ENTRADA"));
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Empieza nodo:2 / Elemento padre: 1   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(2)).setAttribute("NOMBRE","BusquedaSubaccesosEDTO" );
      ((Element)v.get(2)).setAttribute("TIPO","OBJETO" );
      ((Element)v.get(2)).setAttribute("LONGITUD","50" );
      ((Element)v.get(1)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 1   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(3)).setAttribute("NOMBRE","MLNBusquedaSubaccesosFacade" );
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
      ((Element)v.get(5)).setAttribute("NOMBRE","dtoSalida.subaccesos" );
      ((Element)v.get(5)).setAttribute("FORMATO","MARETABLA" );
      ((Element)v.get(5)).setAttribute("LONGITUD","50" );
      ((Element)v.get(4)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("CONCATENAR"));
      ((Element)v.get(6)).setAttribute("NOMBRE","caso" );
      ((Element)v.get(5)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(7)).setAttribute("NOMBRE","ACCE_COD_ACCE" );
      ((Element)v.get(7)).setAttribute("TIPO","INTEGER" );
      ((Element)v.get(7)).setAttribute("LONGITUD","50" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("LITERAL"));
      ((Element)v.get(8)).setAttribute("NOMBRE","lit1" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));

      /* Elemento padre:8 / Elemento actual: 9   */
      v.add(doc.createTextNode("--"));
      ((Element)v.get(8)).appendChild((Text)v.get(9));

      /* Termina nodo Texto:9   */
      /* Termina nodo:8   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(10)).setAttribute("NOMBRE","CANA_COD_CANA" );
      ((Element)v.get(10)).setAttribute("TIPO","INTEGER" );
      ((Element)v.get(10)).setAttribute("LONGITUD","50" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("LITERAL"));
      ((Element)v.get(11)).setAttribute("NOMBRE","lit2" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));

      /* Elemento padre:11 / Elemento actual: 12   */
      v.add(doc.createTextNode("--"));
      ((Element)v.get(11)).appendChild((Text)v.get(12));

      /* Termina nodo Texto:12   */
      /* Termina nodo:11   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(13)).setAttribute("NOMBRE","COD_SBAC" );
      ((Element)v.get(13)).setAttribute("TIPO","INTEGER" );
      ((Element)v.get(13)).setAttribute("LONGITUD","50" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */
      /* Termina nodo:6   */

      /* Empieza nodo:14 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(14)).setAttribute("NOMBRE","COD_SBAC" );
      ((Element)v.get(14)).setAttribute("TIPO","INTEGER" );
      ((Element)v.get(14)).setAttribute("LONGITUD","50" );
      ((Element)v.get(5)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(15)).setAttribute("NOMBRE","DES_SBAC" );
      ((Element)v.get(15)).setAttribute("TIPO","STRING" );
      ((Element)v.get(15)).setAttribute("LONGITUD","50" );
      ((Element)v.get(5)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(16)).setAttribute("NOMBRE","DES_CANA" );
      ((Element)v.get(16)).setAttribute("TIPO","STRING" );
      ((Element)v.get(16)).setAttribute("LONGITUD","50" );
      ((Element)v.get(5)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(17)).setAttribute("NOMBRE","DES_ACCE" );
      ((Element)v.get(17)).setAttribute("TIPO","STRING" );
      ((Element)v.get(17)).setAttribute("LONGITUD","50" );
      ((Element)v.get(5)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */
      /* Termina nodo:5   */
      /* Termina nodo:4   */


   }

}
