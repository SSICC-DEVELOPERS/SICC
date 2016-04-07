
import org.w3c.dom.*;
import java.util.ArrayList;

public class ConectorRecuperaDatosPantalla  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         

      getXML180(doc);
         

      getXML270(doc);
         

      getXML360(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("CONECTOR"));
      ((Element)v.get(0)).setAttribute("TIPO","EJB" );
      ((Element)v.get(0)).setAttribute("NOMBRE","mare.mln.BusinessFacade" );
      ((Element)v.get(0)).setAttribute("METODO","execute" );
      ((Element)v.get(0)).setAttribute("REVISION","3.1" );
      ((Element)v.get(0)).setAttribute("OBSERVACIONES","carga datos pantalla insercion" );

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
      ((Element)v.get(5)).setAttribute("LONGITUD","200" );
      ((Element)v.get(5)).setAttribute("FORMATO","MARETABLA" );
      ((Element)v.get(4)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(6)).setAttribute("NOMBRE","ID_PERFIL" );
      ((Element)v.get(6)).setAttribute("TIPO","STRING" );
      ((Element)v.get(6)).setAttribute("LONGITUD","256" );
      ((Element)v.get(5)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */
      /* Termina nodo:5   */

      /* Empieza nodo:7 / Elemento padre: 4   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(7)).setAttribute("NOMBRE","dtoSalida.funcionesMenu" );
      ((Element)v.get(7)).setAttribute("LONGITUD","200" );
      ((Element)v.get(7)).setAttribute("FORMATO","MARETABLA" );
      ((Element)v.get(4)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(8)).setAttribute("NOMBRE","ID_PERFIL" );
      ((Element)v.get(8)).setAttribute("TIPO","STRING" );
      ((Element)v.get(8)).setAttribute("LONGITUD","256" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 7   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(9)).setAttribute("NOMBRE","NOMB_PROG" );
      ((Element)v.get(9)).setAttribute("TIPO","STRING" );
      ((Element)v.get(9)).setAttribute("LONGITUD","256" );
      ((Element)v.get(7)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 7   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(10)).setAttribute("NOMBRE","DESC_FUNCION" );
      ((Element)v.get(10)).setAttribute("TIPO","STRING" );
      ((Element)v.get(10)).setAttribute("LONGITUD","256" );
      ((Element)v.get(7)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */
      /* Termina nodo:7   */

      /* Empieza nodo:11 / Elemento padre: 4   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(11)).setAttribute("NOMBRE","dtoSalida.usuariosSustitucion" );
      ((Element)v.get(11)).setAttribute("LONGITUD","200" );
      ((Element)v.get(11)).setAttribute("FORMATO","MARETABLA" );
      ((Element)v.get(4)).appendChild((Element)v.get(11));

      /* Empieza nodo:12 / Elemento padre: 11   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(12)).setAttribute("NOMBRE","USUARIOS_1" );
      ((Element)v.get(12)).setAttribute("TIPO","STRING" );
      ((Element)v.get(12)).setAttribute("LONGITUD","256" );
      ((Element)v.get(11)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 11   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(13)).setAttribute("NOMBRE","APE_USUARIO" );
      ((Element)v.get(13)).setAttribute("TIPO","STRING" );
      ((Element)v.get(13)).setAttribute("LONGITUD","256" );
      ((Element)v.get(11)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 11   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(14)).setAttribute("NOMBRE","NOM_USUARIO" );
      ((Element)v.get(14)).setAttribute("TIPO","STRING" );
      ((Element)v.get(14)).setAttribute("LONGITUD","256" );
      ((Element)v.get(11)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */
      /* Termina nodo:11   */

      /* Empieza nodo:15 / Elemento padre: 4   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(15)).setAttribute("NOMBRE","dtoSalida.idiomas" );
      ((Element)v.get(15)).setAttribute("LONGITUD","200" );
      ((Element)v.get(15)).setAttribute("FORMATO","MARETABLA" );
      ((Element)v.get(4)).appendChild((Element)v.get(15));

      /* Empieza nodo:16 / Elemento padre: 15   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(16)).setAttribute("NOMBRE","COD_IDIO" );
      ((Element)v.get(16)).setAttribute("TIPO","INTEGER" );
      ((Element)v.get(16)).setAttribute("LONGITUD","2" );
      ((Element)v.get(15)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 15   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(17)).setAttribute("NOMBRE","DES_IDIO" );
      ((Element)v.get(17)).setAttribute("TIPO","STRING" );
      ((Element)v.get(17)).setAttribute("LONGITUD","15" );
      ((Element)v.get(15)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */
      /* Termina nodo:15   */

      /* Empieza nodo:18 / Elemento padre: 4   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(18)).setAttribute("NOMBRE","dtoSalida.canales" );
      ((Element)v.get(18)).setAttribute("LONGITUD","200" );
      ((Element)v.get(18)).setAttribute("FORMATO","MARETABLA" );
      ((Element)v.get(4)).appendChild((Element)v.get(18));

      /* Empieza nodo:19 / Elemento padre: 18   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(19)).setAttribute("NOMBRE","COD_CANA" );
      ((Element)v.get(19)).setAttribute("TIPO","STRING" );
      ((Element)v.get(19)).setAttribute("LONGITUD","50" );
      ((Element)v.get(18)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 18   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(20)).setAttribute("NOMBRE","DES_CANA" );
      ((Element)v.get(20)).setAttribute("TIPO","STRING" );
      ((Element)v.get(20)).setAttribute("LONGITUD","50" );
      ((Element)v.get(18)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */
      /* Termina nodo:18   */

      /* Empieza nodo:21 / Elemento padre: 4   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(21)).setAttribute("NOMBRE","dtoSalida.marcas" );
      ((Element)v.get(21)).setAttribute("LONGITUD","200" );
      ((Element)v.get(21)).setAttribute("FORMATO","MARETABLA" );
      ((Element)v.get(4)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(22)).setAttribute("NOMBRE","COD_MARC" );
      ((Element)v.get(22)).setAttribute("TIPO","STRING" );
      ((Element)v.get(22)).setAttribute("LONGITUD","50" );
      ((Element)v.get(21)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 21   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(23)).setAttribute("NOMBRE","DES_MARC" );
      ((Element)v.get(23)).setAttribute("TIPO","STRING" );
      ((Element)v.get(23)).setAttribute("LONGITUD","50" );
      ((Element)v.get(21)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */
      /* Termina nodo:21   */

      /* Empieza nodo:24 / Elemento padre: 4   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(24)).setAttribute("NOMBRE","dtoSalida.accesos" );
      ((Element)v.get(24)).setAttribute("LONGITUD","200" );
      ((Element)v.get(24)).setAttribute("FORMATO","MARETABLA" );
      ((Element)v.get(4)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(25)).setAttribute("NOMBRE","COD_ACCE" );
      ((Element)v.get(25)).setAttribute("TIPO","STRING" );
      ((Element)v.get(25)).setAttribute("LONGITUD","50" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 24   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(26)).setAttribute("NOMBRE","DES_ACCE" );
      ((Element)v.get(26)).setAttribute("TIPO","STRING" );
      ((Element)v.get(26)).setAttribute("LONGITUD","50" );
      ((Element)v.get(24)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 24   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(27)).setAttribute("NOMBRE","COD_CANA" );
      ((Element)v.get(27)).setAttribute("TIPO","STRING" );
      ((Element)v.get(27)).setAttribute("LONGITUD","50" );
      ((Element)v.get(24)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */
      /* Termina nodo:24   */

      /* Empieza nodo:28 / Elemento padre: 4   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(28)).setAttribute("NOMBRE","dtoSalida.paises" );
      ((Element)v.get(28)).setAttribute("LONGITUD","200" );
      ((Element)v.get(28)).setAttribute("FORMATO","MARETABLA" );
      ((Element)v.get(4)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(29)).setAttribute("NOMBRE","COD_PAIS" );
      ((Element)v.get(29)).setAttribute("TIPO","STRING" );
      ((Element)v.get(29)).setAttribute("LONGITUD","50" );
      ((Element)v.get(28)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 28   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(30)).setAttribute("NOMBRE","DESC_PAIS" );
      ((Element)v.get(30)).setAttribute("TIPO","STRING" );
      ((Element)v.get(30)).setAttribute("LONGITUD","50" );
      ((Element)v.get(28)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */
      /* Termina nodo:28   */

      /* Empieza nodo:31 / Elemento padre: 4   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(31)).setAttribute("NOMBRE","dtoSalida.departamentos" );
      ((Element)v.get(31)).setAttribute("LONGITUD","200" );
      ((Element)v.get(31)).setAttribute("FORMATO","MARETABLA" );
      ((Element)v.get(4)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(32)).setAttribute("NOMBRE","COD_DPTO" );
      ((Element)v.get(32)).setAttribute("TIPO","STRING" );
      ((Element)v.get(32)).setAttribute("LONGITUD","50" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 31   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(33)).setAttribute("NOMBRE","DESC_DPTO" );
      ((Element)v.get(33)).setAttribute("TIPO","STRING" );
      ((Element)v.get(33)).setAttribute("LONGITUD","50" );
      ((Element)v.get(31)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */
      /* Termina nodo:31   */

      /* Empieza nodo:34 / Elemento padre: 4   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(34)).setAttribute("NOMBRE","dtoSalida.subaccesos" );
      ((Element)v.get(34)).setAttribute("LONGITUD","200" );
      ((Element)v.get(34)).setAttribute("FORMATO","MARETABLA" );
      ((Element)v.get(4)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(35)).setAttribute("NOMBRE","COD_SBAC" );
      ((Element)v.get(35)).setAttribute("TIPO","STRING" );
      ((Element)v.get(35)).setAttribute("LONGITUD","50" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 34   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(36)).setAttribute("NOMBRE","DES_SBAC" );
      ((Element)v.get(36)).setAttribute("TIPO","STRING" );
      ((Element)v.get(36)).setAttribute("LONGITUD","50" );
      ((Element)v.get(34)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 34   */
   }

   private void getXML180(Document doc) {
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(37)).setAttribute("NOMBRE","ACCE_COD_ACCE" );
      ((Element)v.get(37)).setAttribute("TIPO","STRING" );
      ((Element)v.get(37)).setAttribute("LONGITUD","50" );
      ((Element)v.get(34)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */
      /* Termina nodo:34   */

      /* Empieza nodo:38 / Elemento padre: 4   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(38)).setAttribute("NOMBRE","dtoSalida.empresas" );
      ((Element)v.get(38)).setAttribute("LONGITUD","200" );
      ((Element)v.get(38)).setAttribute("FORMATO","MARETABLA" );
      ((Element)v.get(4)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(39)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(39)).setAttribute("TIPO","STRING" );
      ((Element)v.get(39)).setAttribute("LONGITUD","50" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 38   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(40)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(40)).setAttribute("TIPO","STRING" );
      ((Element)v.get(40)).setAttribute("LONGITUD","50" );
      ((Element)v.get(38)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 38   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(41)).setAttribute("NOMBRE","PAIS" );
      ((Element)v.get(41)).setAttribute("TIPO","STRING" );
      ((Element)v.get(41)).setAttribute("LONGITUD","50" );
      ((Element)v.get(38)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:38   */

      /* Empieza nodo:42 / Elemento padre: 4   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(42)).setAttribute("NOMBRE","dtoSalida.subgerencias" );
      ((Element)v.get(42)).setAttribute("LONGITUD","50" );
      ((Element)v.get(42)).setAttribute("FORMATO","MARETABLA" );
      ((Element)v.get(4)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(43)).setAttribute("NOMBRE","SGV_COD" );
      ((Element)v.get(43)).setAttribute("TIPO","STRING" );
      ((Element)v.get(43)).setAttribute("LONGITUD","50" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 42   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(44)).setAttribute("NOMBRE","NSE1" );
      ((Element)v.get(44)).setAttribute("TIPO","STRING" );
      ((Element)v.get(44)).setAttribute("LONGITUD","50" );
      ((Element)v.get(42)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 42   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(45)).setAttribute("NOMBRE","NSE2" );
      ((Element)v.get(45)).setAttribute("TIPO","STRING" );
      ((Element)v.get(45)).setAttribute("LONGITUD","50" );
      ((Element)v.get(42)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 42   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(46)).setAttribute("NOMBRE","NSE3" );
      ((Element)v.get(46)).setAttribute("TIPO","STRING" );
      ((Element)v.get(46)).setAttribute("LONGITUD","50" );
      ((Element)v.get(42)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 42   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(47)).setAttribute("NOMBRE","SGV_DESC" );
      ((Element)v.get(47)).setAttribute("TIPO","STRING" );
      ((Element)v.get(47)).setAttribute("LONGITUD","50" );
      ((Element)v.get(42)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 42   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(48)).setAttribute("NOMBRE","COD_CANA" );
      ((Element)v.get(48)).setAttribute("TIPO","STRING" );
      ((Element)v.get(48)).setAttribute("LONGITUD","50" );
      ((Element)v.get(42)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 42   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(49)).setAttribute("NOMBRE","COD_MARC" );
      ((Element)v.get(49)).setAttribute("TIPO","STRING" );
      ((Element)v.get(49)).setAttribute("LONGITUD","50" );
      ((Element)v.get(42)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 42   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(50)).setAttribute("NOMBRE","COD_PAIS" );
      ((Element)v.get(50)).setAttribute("TIPO","STRING" );
      ((Element)v.get(50)).setAttribute("LONGITUD","50" );
      ((Element)v.get(42)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:42   */

      /* Empieza nodo:51 / Elemento padre: 4   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(51)).setAttribute("NOMBRE","dtoSalida.regiones" );
      ((Element)v.get(51)).setAttribute("LONGITUD","200" );
      ((Element)v.get(51)).setAttribute("FORMATO","MARETABLA" );
      ((Element)v.get(4)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(52)).setAttribute("NOMBRE","COD_REGI" );
      ((Element)v.get(52)).setAttribute("TIPO","STRING" );
      ((Element)v.get(52)).setAttribute("LONGITUD","50" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 51   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(53)).setAttribute("NOMBRE","COD_SGV" );
      ((Element)v.get(53)).setAttribute("TIPO","STRING" );
      ((Element)v.get(53)).setAttribute("LONGITUD","50" );
      ((Element)v.get(51)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 51   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(54)).setAttribute("NOMBRE","NSE1" );
      ((Element)v.get(54)).setAttribute("TIPO","STRING" );
      ((Element)v.get(54)).setAttribute("LONGITUD","50" );
      ((Element)v.get(51)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 51   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(55)).setAttribute("NOMBRE","NSE2" );
      ((Element)v.get(55)).setAttribute("TIPO","STRING" );
      ((Element)v.get(55)).setAttribute("LONGITUD","50" );
      ((Element)v.get(51)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 51   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(56)).setAttribute("NOMBRE","NSE3" );
      ((Element)v.get(56)).setAttribute("TIPO","STRING" );
      ((Element)v.get(56)).setAttribute("LONGITUD","50" );
      ((Element)v.get(51)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 51   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(57)).setAttribute("NOMBRE","REGI_DESC" );
      ((Element)v.get(57)).setAttribute("TIPO","STRING" );
      ((Element)v.get(57)).setAttribute("LONGITUD","50" );
      ((Element)v.get(51)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:51   */

      /* Empieza nodo:58 / Elemento padre: 4   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(58)).setAttribute("NOMBRE","dtoSalida.zonas" );
      ((Element)v.get(58)).setAttribute("LONGITUD","200" );
      ((Element)v.get(58)).setAttribute("FORMATO","MARETABLA" );
      ((Element)v.get(4)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(59)).setAttribute("NOMBRE","COD_ZONA" );
      ((Element)v.get(59)).setAttribute("TIPO","STRING" );
      ((Element)v.get(59)).setAttribute("LONGITUD","50" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */

      /* Empieza nodo:60 / Elemento padre: 58   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(60)).setAttribute("NOMBRE","COD_REGI" );
      ((Element)v.get(60)).setAttribute("TIPO","STRING" );
      ((Element)v.get(60)).setAttribute("LONGITUD","50" );
      ((Element)v.get(58)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */

      /* Empieza nodo:61 / Elemento padre: 58   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(61)).setAttribute("NOMBRE","NSE1" );
      ((Element)v.get(61)).setAttribute("TIPO","STRING" );
      ((Element)v.get(61)).setAttribute("LONGITUD","50" );
      ((Element)v.get(58)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */

      /* Empieza nodo:62 / Elemento padre: 58   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(62)).setAttribute("NOMBRE","NSE2" );
      ((Element)v.get(62)).setAttribute("TIPO","STRING" );
      ((Element)v.get(62)).setAttribute("LONGITUD","50" );
      ((Element)v.get(58)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */

      /* Empieza nodo:63 / Elemento padre: 58   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(63)).setAttribute("NOMBRE","NSE3" );
      ((Element)v.get(63)).setAttribute("TIPO","STRING" );
      ((Element)v.get(63)).setAttribute("LONGITUD","50" );
      ((Element)v.get(58)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */

      /* Empieza nodo:64 / Elemento padre: 58   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(64)).setAttribute("NOMBRE","ZONA_DESC" );
      ((Element)v.get(64)).setAttribute("TIPO","STRING" );
      ((Element)v.get(64)).setAttribute("LONGITUD","50" );
      ((Element)v.get(58)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:58   */

      /* Empieza nodo:65 / Elemento padre: 4   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(65)).setAttribute("NOMBRE","dtoSalida.secciones" );
      ((Element)v.get(65)).setAttribute("LONGITUD","200" );
      ((Element)v.get(65)).setAttribute("FORMATO","MARETABLA" );
      ((Element)v.get(4)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(66)).setAttribute("NOMBRE","COD_SECC" );
      ((Element)v.get(66)).setAttribute("TIPO","STRING" );
      ((Element)v.get(66)).setAttribute("LONGITUD","50" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */

      /* Empieza nodo:67 / Elemento padre: 65   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(67)).setAttribute("NOMBRE","COD_ZONA" );
      ((Element)v.get(67)).setAttribute("TIPO","STRING" );
      ((Element)v.get(67)).setAttribute("LONGITUD","50" );
      ((Element)v.get(65)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */

      /* Empieza nodo:68 / Elemento padre: 65   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(68)).setAttribute("NOMBRE","NSE1" );
      ((Element)v.get(68)).setAttribute("TIPO","STRING" );
      ((Element)v.get(68)).setAttribute("LONGITUD","50" );
      ((Element)v.get(65)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */

      /* Empieza nodo:69 / Elemento padre: 65   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(69)).setAttribute("NOMBRE","NSE2" );
      ((Element)v.get(69)).setAttribute("TIPO","STRING" );
      ((Element)v.get(69)).setAttribute("LONGITUD","50" );
      ((Element)v.get(65)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */

      /* Empieza nodo:70 / Elemento padre: 65   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(70)).setAttribute("NOMBRE","NSE3" );
      ((Element)v.get(70)).setAttribute("TIPO","STRING" );
      ((Element)v.get(70)).setAttribute("LONGITUD","50" );
      ((Element)v.get(65)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */

      /* Empieza nodo:71 / Elemento padre: 65   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(71)).setAttribute("NOMBRE","SECC_DESC" );
      ((Element)v.get(71)).setAttribute("TIPO","STRING" );
      ((Element)v.get(71)).setAttribute("LONGITUD","50" );
      ((Element)v.get(65)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:65   */

      /* Empieza nodo:72 / Elemento padre: 4   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(72)).setAttribute("NOMBRE","dtoSalida.territorios" );
      ((Element)v.get(72)).setAttribute("LONGITUD","200" );
      ((Element)v.get(72)).setAttribute("FORMATO","MARETABLA" );
      ((Element)v.get(4)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(73)).setAttribute("NOMBRE","COD_TERR" );
      ((Element)v.get(73)).setAttribute("TIPO","STRING" );
      ((Element)v.get(73)).setAttribute("LONGITUD","50" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */

      /* Empieza nodo:74 / Elemento padre: 72   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(74)).setAttribute("NOMBRE","COD_SECC" );
      ((Element)v.get(74)).setAttribute("TIPO","STRING" );
      ((Element)v.get(74)).setAttribute("LONGITUD","50" );
      ((Element)v.get(72)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */

      /* Empieza nodo:75 / Elemento padre: 72   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(75)).setAttribute("NOMBRE","NSE1" );
      ((Element)v.get(75)).setAttribute("TIPO","STRING" );
      ((Element)v.get(75)).setAttribute("LONGITUD","50" );
      ((Element)v.get(72)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */

      /* Empieza nodo:76 / Elemento padre: 72   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(76)).setAttribute("NOMBRE","NSE2" );
      ((Element)v.get(76)).setAttribute("TIPO","STRING" );
      ((Element)v.get(76)).setAttribute("LONGITUD","50" );
      ((Element)v.get(72)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */

      /* Empieza nodo:77 / Elemento padre: 72   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(77)).setAttribute("NOMBRE","NSE3" );
      ((Element)v.get(77)).setAttribute("TIPO","STRING" );
      ((Element)v.get(77)).setAttribute("LONGITUD","50" );
      ((Element)v.get(72)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */

      /* Empieza nodo:78 / Elemento padre: 72   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(78)).setAttribute("NOMBRE","DESC" );
      ((Element)v.get(78)).setAttribute("TIPO","STRING" );
      ((Element)v.get(78)).setAttribute("LONGITUD","50" );
      ((Element)v.get(72)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */

      /* Empieza nodo:79 / Elemento padre: 72   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(79)).setAttribute("NOMBRE","PAIS" );
      ((Element)v.get(79)).setAttribute("TIPO","STRING" );
      ((Element)v.get(79)).setAttribute("LONGITUD","50" );
      ((Element)v.get(72)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:72   */
      /* Termina nodo:4   */


   }

}
