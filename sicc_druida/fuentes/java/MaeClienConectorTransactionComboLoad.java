
import org.w3c.dom.*;
import java.util.ArrayList;

public class MaeClienConectorTransactionComboLoad  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("CONECTOR"));
      ((Element)v.get(0)).setAttribute("TIPO","DRUIDATRANSACTION" );
      ((Element)v.get(0)).setAttribute("REVISION","3.1" );
      ((Element)v.get(0)).setAttribute("NOMBRE","MaeClienTransactionComboLoad" );
      ((Element)v.get(0)).setAttribute("OBSERVACIONES","Conector transaccional para la ejección de la carga de combos de tipo MaeClien" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("ENTRADA"));
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Empieza nodo:2 / Elemento padre: 1   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(2)).setAttribute("NOMBRE","mmgApplyStructuralSecurity" );
      ((Element)v.get(2)).setAttribute("TIPO","STRING" );
      ((Element)v.get(2)).setAttribute("LONGITUD","5" );
      ((Element)v.get(1)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */
      /* Termina nodo:1   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("SALIDA"));
      ((Element)v.get(0)).appendChild((Element)v.get(3));

      /* Empieza nodo:4 / Elemento padre: 3   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(4)).setAttribute("NOMBRE","result" );
      ((Element)v.get(4)).setAttribute("LONGITUD","50" );
      ((Element)v.get(3)).appendChild((Element)v.get(4));

      /* Empieza nodo:5 / Elemento padre: 4   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(5)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(5)).setAttribute("TIPO","STRING" );
      ((Element)v.get(5)).setAttribute("LONGITUD","30" );
      ((Element)v.get(4)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 4   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(6)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(6)).setAttribute("TIPO","STRING" );
      ((Element)v.get(6)).setAttribute("LONGITUD","30" );
      ((Element)v.get(4)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */
      /* Termina nodo:4   */
      /* Termina nodo:3   */


   }

}
