
import org.w3c.dom.*;
import java.util.ArrayList;

public class ConectorCargaDatosPantalla  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("OBSERVACIONES","carga datos pantalla busqueda" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("ENTRADA"));
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Empieza nodo:2 / Elemento padre: 1   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(2)).setAttribute("NOMBRE","dtoEntrada" );
      ((Element)v.get(2)).setAttribute("TIPO","OBJETO" );
      ((Element)v.get(2)).setAttribute("LONGITUD","50" );
      ((Element)v.get(1)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 1   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(3)).setAttribute("NOMBRE","businessID" );
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
      ((Element)v.get(5)).setAttribute("NOMBRE","dtoSalida.perfiles" );
      ((Element)v.get(5)).setAttribute("LONGITUD","50" );
      ((Element)v.get(5)).setAttribute("FORMATO","MARETABLA" );
      ((Element)v.get(4)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(6)).setAttribute("NOMBRE","codigo" );
      ((Element)v.get(6)).setAttribute("TIPO","STRING" );
      ((Element)v.get(6)).setAttribute("LONGITUD","50" );
      ((Element)v.get(5)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(7)).setAttribute("NOMBRE","descripcion" );
      ((Element)v.get(7)).setAttribute("TIPO","STRING" );
      ((Element)v.get(7)).setAttribute("LONGITUD","50" );
      ((Element)v.get(5)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */
      /* Termina nodo:5   */

      /* Empieza nodo:8 / Elemento padre: 4   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(8)).setAttribute("NOMBRE","dtoSalida.departamentos" );
      ((Element)v.get(8)).setAttribute("LONGITUD","50" );
      ((Element)v.get(8)).setAttribute("FORMATO","MARETABLA" );
      ((Element)v.get(4)).appendChild((Element)v.get(8));

      /* Empieza nodo:9 / Elemento padre: 8   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(9)).setAttribute("NOMBRE","codigo" );
      ((Element)v.get(9)).setAttribute("TIPO","STRING" );
      ((Element)v.get(9)).setAttribute("LONGITUD","50" );
      ((Element)v.get(8)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 8   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(10)).setAttribute("NOMBRE","descripcion" );
      ((Element)v.get(10)).setAttribute("TIPO","STRING" );
      ((Element)v.get(10)).setAttribute("LONGITUD","50" );
      ((Element)v.get(8)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */
      /* Termina nodo:8   */
      /* Termina nodo:4   */


   }

}
