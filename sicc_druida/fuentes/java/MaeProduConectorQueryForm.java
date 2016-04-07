
import org.w3c.dom.*;
import java.util.ArrayList;

public class MaeProduConectorQueryForm  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         

      getXML180(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("CONECTOR"));
      ((Element)v.get(0)).setAttribute("TIPO","EJB" );
      ((Element)v.get(0)).setAttribute("NOMBRE","mare.mln.BusinessFacade" );
      ((Element)v.get(0)).setAttribute("METODO","execute" );
      ((Element)v.get(0)).setAttribute("REVISION","3.1" );
      ((Element)v.get(0)).setAttribute("OBSERVACIONES","Conector para la consulta sobre la entidad MaeProdu" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("ENTRADA"));
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Empieza nodo:2 / Elemento padre: 1   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(2)).setAttribute("NOMBRE","MMGMaeProduQueryID" );
      ((Element)v.get(2)).setAttribute("TIPO","OBJETO" );
      ((Element)v.get(2)).setAttribute("LONGITUD","50" );
      ((Element)v.get(1)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 1   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(3)).setAttribute("NOMBRE","MMGMaeProduQueryDTO" );
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
      ((Element)v.get(5)).setAttribute("NOMBRE","result" );
      ((Element)v.get(5)).setAttribute("FORMATO","MaeProduFormFormatter" );
      ((Element)v.get(5)).setAttribute("LONGITUD","50" );
      ((Element)v.get(4)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(6)).setAttribute("NOMBRE","id" );
      ((Element)v.get(6)).setAttribute("TIPO","STRING" );
      ((Element)v.get(6)).setAttribute("LONGITUD","12" );
      ((Element)v.get(5)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(7)).setAttribute("NOMBRE","paisOidPais" );
      ((Element)v.get(7)).setAttribute("TIPO","STRING" );
      ((Element)v.get(7)).setAttribute("LONGITUD","12" );
      ((Element)v.get(5)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(8)).setAttribute("NOMBRE","codSap" );
      ((Element)v.get(8)).setAttribute("TIPO","STRING" );
      ((Element)v.get(8)).setAttribute("LONGITUD","20" );
      ((Element)v.get(5)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(9)).setAttribute("NOMBRE","codiAnti" );
      ((Element)v.get(9)).setAttribute("TIPO","STRING" );
      ((Element)v.get(9)).setAttribute("LONGITUD","18" );
      ((Element)v.get(5)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(10)).setAttribute("NOMBRE","desCort" );
      ((Element)v.get(10)).setAttribute("TIPO","STRING" );
      ((Element)v.get(10)).setAttribute("LONGITUD","40" );
      ((Element)v.get(5)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(11)).setAttribute("NOMBRE","valJera1" );
      ((Element)v.get(11)).setAttribute("TIPO","STRING" );
      ((Element)v.get(11)).setAttribute("LONGITUD","3" );
      ((Element)v.get(5)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(12)).setAttribute("NOMBRE","valJera2" );
      ((Element)v.get(12)).setAttribute("TIPO","STRING" );
      ((Element)v.get(12)).setAttribute("LONGITUD","3" );
      ((Element)v.get(5)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(13)).setAttribute("NOMBRE","valJera3" );
      ((Element)v.get(13)).setAttribute("TIPO","STRING" );
      ((Element)v.get(13)).setAttribute("LONGITUD","3" );
      ((Element)v.get(5)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(14)).setAttribute("NOMBRE","valAtri1" );
      ((Element)v.get(14)).setAttribute("TIPO","STRING" );
      ((Element)v.get(14)).setAttribute("LONGITUD","3" );
      ((Element)v.get(5)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(15)).setAttribute("NOMBRE","valAtri2" );
      ((Element)v.get(15)).setAttribute("TIPO","STRING" );
      ((Element)v.get(15)).setAttribute("LONGITUD","4" );
      ((Element)v.get(5)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(16)).setAttribute("NOMBRE","valAtri3" );
      ((Element)v.get(16)).setAttribute("TIPO","STRING" );
      ((Element)v.get(16)).setAttribute("LONGITUD","10" );
      ((Element)v.get(5)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(17)).setAttribute("NOMBRE","valDimeAlto" );
      ((Element)v.get(17)).setAttribute("TIPO","STRING" );
      ((Element)v.get(17)).setAttribute("LONGITUD","6" );
      ((Element)v.get(5)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(18)).setAttribute("NOMBRE","valDimeLarg" );
      ((Element)v.get(18)).setAttribute("TIPO","STRING" );
      ((Element)v.get(18)).setAttribute("LONGITUD","6" );
      ((Element)v.get(5)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 5   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(19)).setAttribute("NOMBRE","valDimeAnch" );
      ((Element)v.get(19)).setAttribute("TIPO","STRING" );
      ((Element)v.get(19)).setAttribute("LONGITUD","6" );
      ((Element)v.get(5)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(20)).setAttribute("NOMBRE","valPeso" );
      ((Element)v.get(20)).setAttribute("TIPO","STRING" );
      ((Element)v.get(20)).setAttribute("LONGITUD","6" );
      ((Element)v.get(5)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(21)).setAttribute("NOMBRE","valVolu" );
      ((Element)v.get(21)).setAttribute("TIPO","STRING" );
      ((Element)v.get(21)).setAttribute("LONGITUD","6" );
      ((Element)v.get(5)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(22)).setAttribute("NOMBRE","valCostEstd" );
      ((Element)v.get(22)).setAttribute("TIPO","STRING" );
      ((Element)v.get(22)).setAttribute("LONGITUD","12" );
      ((Element)v.get(5)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(23)).setAttribute("NOMBRE","valPrecPosi" );
      ((Element)v.get(23)).setAttribute("TIPO","STRING" );
      ((Element)v.get(23)).setAttribute("LONGITUD","12" );
      ((Element)v.get(5)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(24)).setAttribute("NOMBRE","valPrecCata" );
      ((Element)v.get(24)).setAttribute("TIPO","STRING" );
      ((Element)v.get(24)).setAttribute("LONGITUD","12" );
      ((Element)v.get(5)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(25)).setAttribute("NOMBRE","valPrecCont" );
      ((Element)v.get(25)).setAttribute("TIPO","STRING" );
      ((Element)v.get(25)).setAttribute("LONGITUD","12" );
      ((Element)v.get(5)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(26)).setAttribute("NOMBRE","numUnidDentPedi" );
      ((Element)v.get(26)).setAttribute("TIPO","STRING" );
      ((Element)v.get(26)).setAttribute("LONGITUD","5" );
      ((Element)v.get(5)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(27)).setAttribute("NOMBRE","numUnidCaja" );
      ((Element)v.get(27)).setAttribute("TIPO","STRING" );
      ((Element)v.get(27)).setAttribute("LONGITUD","5" );
      ((Element)v.get(5)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(28)).setAttribute("NOMBRE","codImpu" );
      ((Element)v.get(28)).setAttribute("TIPO","STRING" );
      ((Element)v.get(28)).setAttribute("LONGITUD","2" );
      ((Element)v.get(5)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(29)).setAttribute("NOMBRE","pctUnid" );
      ((Element)v.get(29)).setAttribute("TIPO","STRING" );
      ((Element)v.get(29)).setAttribute("LONGITUD","3" );
      ((Element)v.get(5)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(30)).setAttribute("NOMBRE","geneOidGene" );
      ((Element)v.get(30)).setAttribute("TIPO","STRING" );
      ((Element)v.get(30)).setAttribute("LONGITUD","12" );
      ((Element)v.get(5)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(31)).setAttribute("NOMBRE","sgenOidSupeGene" );
      ((Element)v.get(31)).setAttribute("TIPO","STRING" );
      ((Element)v.get(31)).setAttribute("LONGITUD","12" );
      ((Element)v.get(5)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(32)).setAttribute("NOMBRE","unmdOidUnidMedi" );
      ((Element)v.get(32)).setAttribute("TIPO","STRING" );
      ((Element)v.get(32)).setAttribute("LONGITUD","12" );
      ((Element)v.get(5)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(33)).setAttribute("NOMBRE","unmdOidUnidMediPeso" );
      ((Element)v.get(33)).setAttribute("TIPO","STRING" );
      ((Element)v.get(33)).setAttribute("LONGITUD","12" );
      ((Element)v.get(5)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(34)).setAttribute("NOMBRE","unmdOidUnidMediDime" );
      ((Element)v.get(34)).setAttribute("TIPO","STRING" );
      ((Element)v.get(34)).setAttribute("LONGITUD","12" );
      ((Element)v.get(5)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(35)).setAttribute("NOMBRE","negoOidNego" );
      ((Element)v.get(35)).setAttribute("TIPO","STRING" );
      ((Element)v.get(35)).setAttribute("LONGITUD","12" );
      ((Element)v.get(5)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(36)).setAttribute("NOMBRE","meudOidEstaProd" );
      ((Element)v.get(36)).setAttribute("TIPO","STRING" );
      ((Element)v.get(36)).setAttribute("LONGITUD","12" );
      ((Element)v.get(5)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 5   */
   }

   private void getXML180(Document doc) {
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(37)).setAttribute("NOMBRE","liprOidLineProd" );
      ((Element)v.get(37)).setAttribute("TIPO","STRING" );
      ((Element)v.get(37)).setAttribute("LONGITUD","12" );
      ((Element)v.get(5)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(38)).setAttribute("NOMBRE","unegOidUnidNego" );
      ((Element)v.get(38)).setAttribute("TIPO","STRING" );
      ((Element)v.get(38)).setAttribute("LONGITUD","12" );
      ((Element)v.get(5)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(39)).setAttribute("NOMBRE","perdOidPeriInic" );
      ((Element)v.get(39)).setAttribute("TIPO","STRING" );
      ((Element)v.get(39)).setAttribute("LONGITUD","12" );
      ((Element)v.get(5)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(40)).setAttribute("NOMBRE","perdOidPeriFin" );
      ((Element)v.get(40)).setAttribute("TIPO","STRING" );
      ((Element)v.get(40)).setAttribute("LONGITUD","12" );
      ((Element)v.get(5)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(41)).setAttribute("NOMBRE","indLote" );
      ((Element)v.get(41)).setAttribute("TIPO","STRING" );
      ((Element)v.get(41)).setAttribute("LONGITUD","1" );
      ((Element)v.get(5)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(42)).setAttribute("NOMBRE","indProdServ" );
      ((Element)v.get(42)).setAttribute("TIPO","STRING" );
      ((Element)v.get(42)).setAttribute("LONGITUD","1" );
      ((Element)v.get(5)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(43)).setAttribute("NOMBRE","codIndSitu" );
      ((Element)v.get(43)).setAttribute("TIPO","STRING" );
      ((Element)v.get(43)).setAttribute("LONGITUD","1" );
      ((Element)v.get(5)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(44)).setAttribute("NOMBRE","codIndDentCaja" );
      ((Element)v.get(44)).setAttribute("TIPO","STRING" );
      ((Element)v.get(44)).setAttribute("LONGITUD","1" );
      ((Element)v.get(5)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(45)).setAttribute("NOMBRE","indKit" );
      ((Element)v.get(45)).setAttribute("TIPO","STRING" );
      ((Element)v.get(45)).setAttribute("LONGITUD","1" );
      ((Element)v.get(5)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(46)).setAttribute("NOMBRE","fopaOidFormPago" );
      ((Element)v.get(46)).setAttribute("TIPO","STRING" );
      ((Element)v.get(46)).setAttribute("LONGITUD","12" );
      ((Element)v.get(5)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(47)).setAttribute("NOMBRE","maprOidMarcProd" );
      ((Element)v.get(47)).setAttribute("TIPO","STRING" );
      ((Element)v.get(47)).setAttribute("LONGITUD","12" );
      ((Element)v.get(5)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(48)).setAttribute("NOMBRE","valGrupArti" );
      ((Element)v.get(48)).setAttribute("TIPO","STRING" );
      ((Element)v.get(48)).setAttribute("LONGITUD","9" );
      ((Element)v.get(5)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(49)).setAttribute("NOMBRE","codUnicVent" );
      ((Element)v.get(49)).setAttribute("TIPO","STRING" );
      ((Element)v.get(49)).setAttribute("LONGITUD","6" );
      ((Element)v.get(5)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(50)).setAttribute("NOMBRE","prfiOidProgFide" );
      ((Element)v.get(50)).setAttribute("TIPO","STRING" );
      ((Element)v.get(50)).setAttribute("LONGITUD","12" );
      ((Element)v.get(5)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(51)).setAttribute("NOMBRE","timestamp" );
      ((Element)v.get(51)).setAttribute("TIPO","STRING" );
      ((Element)v.get(51)).setAttribute("LONGITUD","30" );
      ((Element)v.get(5)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:5   */
      /* Termina nodo:4   */


   }

}
