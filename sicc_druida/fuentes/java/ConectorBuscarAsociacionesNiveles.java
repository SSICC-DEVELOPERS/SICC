
import org.w3c.dom.*;
import java.util.ArrayList;

public class ConectorBuscarAsociacionesNiveles  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("OBSERVACIONES","Descripcion:" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("ENTRADA"));
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Empieza nodo:2 / Elemento padre: 1   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(2)).setAttribute("NOMBRE","FiltroPaisDTO" );
      ((Element)v.get(2)).setAttribute("TIPO","OBJETO" );
      ((Element)v.get(2)).setAttribute("LONGITUD","50" );
      ((Element)v.get(1)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 1   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(3)).setAttribute("NOMBRE","MLNFBuscarAsociacionesNiveles" );
      ((Element)v.get(3)).setAttribute("TIPO","OBJETO" );
      ((Element)v.get(3)).setAttribute("LONGITUD","50" );
      ((Element)v.get(1)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */
      /* Termina nodo:1   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("SALIDA"));
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Empieza nodo:5 / Elemento padre: 4   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(5)).setAttribute("NOMBRE","PaginaEliminarNivelesDTO" );
      ((Element)v.get(5)).setAttribute("TIPO","OBJETO" );
      ((Element)v.get(5)).setAttribute("LONGITUD","50" );
      ((Element)v.get(4)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 4   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(6)).setAttribute("NOMBRE","dtoSalida.paises" );
      ((Element)v.get(6)).setAttribute("FORMATO","MARETABLA" );
      ((Element)v.get(6)).setAttribute("LONGITUD","50" );
      ((Element)v.get(4)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(7)).setAttribute("NOMBRE","OID_PAIS " );
      ((Element)v.get(7)).setAttribute("TIPO","STRING" );
      ((Element)v.get(7)).setAttribute("LONGITUD","50" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(8)).setAttribute("NOMBRE","DESC_PAIS_I18N" );
      ((Element)v.get(8)).setAttribute("TIPO","STRING" );
      ((Element)v.get(8)).setAttribute("LONGITUD","50" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */
      /* Termina nodo:6   */

      /* Empieza nodo:9 / Elemento padre: 4   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(9)).setAttribute("NOMBRE","dtoSalida.asociaciones" );
      ((Element)v.get(9)).setAttribute("FORMATO","MARETABLA" );
      ((Element)v.get(9)).setAttribute("LONGITUD","50" );
      ((Element)v.get(4)).appendChild((Element)v.get(9));

      /* Empieza nodo:10 / Elemento padre: 9   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(10)).setAttribute("NOMBRE","OID_NIVE_SOEC_ASOC" );
      ((Element)v.get(10)).setAttribute("TIPO","STRING" );
      ((Element)v.get(10)).setAttribute("LONGITUD","50" );
      ((Element)v.get(9)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 9   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(11)).setAttribute("NOMBRE","PAIS_OID_PAIS" );
      ((Element)v.get(11)).setAttribute("TIPO","STRING" );
      ((Element)v.get(11)).setAttribute("LONGITUD","50" );
      ((Element)v.get(9)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 9   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(12)).setAttribute("NOMBRE","OID_NIVE_SOEC_BELC" );
      ((Element)v.get(12)).setAttribute("TIPO","STRING" );
      ((Element)v.get(12)).setAttribute("LONGITUD","50" );
      ((Element)v.get(9)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 9   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(13)).setAttribute("NOMBRE","DES_NIVE_SOCI_ECON_BELC" );
      ((Element)v.get(13)).setAttribute("TIPO","STRING" );
      ((Element)v.get(13)).setAttribute("LONGITUD","50" );
      ((Element)v.get(9)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 9   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(14)).setAttribute("NOMBRE","OID_NSEP" );
      ((Element)v.get(14)).setAttribute("TIPO","STRING" );
      ((Element)v.get(14)).setAttribute("LONGITUD","50" );
      ((Element)v.get(9)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 9   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(15)).setAttribute("NOMBRE","desc_nsep_il8n" );
      ((Element)v.get(15)).setAttribute("TIPO","STRING" );
      ((Element)v.get(15)).setAttribute("LONGITUD","50" );
      ((Element)v.get(9)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */
      /* Termina nodo:9   */

      /* Empieza nodo:16 / Elemento padre: 4   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(16)).setAttribute("NOMBRE","DTOSalidaBuscarNiveles" );
      ((Element)v.get(16)).setAttribute("TIPO","OBJETO" );
      ((Element)v.get(16)).setAttribute("LONGITUD","50" );
      ((Element)v.get(4)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */
      /* Termina nodo:4   */


   }

}
