
import org.w3c.dom.*;
import java.util.ArrayList;

public class ConectorProductosPrueba  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("TIPO","TAPON" );
      ((Element)v.get(0)).setAttribute("REVISION","3.1" );
      ((Element)v.get(0)).setAttribute("OBSERVACIONES","Tapon de cargar pantalla buscar productos" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("ENTRADA"));
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Empieza nodo:2 / Elemento padre: 1   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(2)).setAttribute("NOMBRE","BusquedaProductos" );
      ((Element)v.get(2)).setAttribute("TIPO","OBJETO" );
      ((Element)v.get(2)).setAttribute("LONGITUD","50" );
      ((Element)v.get(1)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 1   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(3)).setAttribute("NOMBRE","PRECargarCriteriosBusquedaProductos" );
      ((Element)v.get(3)).setAttribute("TIPO","OBJETO" );
      ((Element)v.get(3)).setAttribute("LONGITUD","50" );
      ((Element)v.get(1)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */
      /* Termina nodo:1   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("SALIDA"));
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Empieza nodo:5 / Elemento padre: 4   */
      v.add(doc.createElement("ROWSET2"));
      ((Element)v.get(4)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(6)).setAttribute("ID","marca_ROWSET" );
      ((Element)v.get(5)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(6)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(8)).setAttribute("NOMBRE","OID" );
      ((Element)v.get(8)).setAttribute("TIPO","STRING" );
      ((Element)v.get(8)).setAttribute("LONGITUD","50" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));

      /* Elemento padre:8 / Elemento actual: 9   */
      v.add(doc.createTextNode("1"));
      ((Element)v.get(8)).appendChild((Text)v.get(9));

      /* Termina nodo Texto:9   */
      /* Termina nodo:8   */

      /* Empieza nodo:10 / Elemento padre: 7   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(10)).setAttribute("NOMBRE","DES_MARC" );
      ((Element)v.get(10)).setAttribute("TIPO","STRING" );
      ((Element)v.get(10)).setAttribute("LONGITUD","50" );
      ((Element)v.get(7)).appendChild((Element)v.get(10));

      /* Elemento padre:10 / Elemento actual: 11   */
      v.add(doc.createTextNode("MARCA 1"));
      ((Element)v.get(10)).appendChild((Text)v.get(11));

      /* Termina nodo Texto:11   */
      /* Termina nodo:10   */
      /* Termina nodo:7   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(6)).appendChild((Element)v.get(12));

      /* Empieza nodo:13 / Elemento padre: 12   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(13)).setAttribute("NOMBRE","OID" );
      ((Element)v.get(13)).setAttribute("TIPO","INTEGER" );
      ((Element)v.get(13)).setAttribute("LONGITUD","50" );
      ((Element)v.get(12)).appendChild((Element)v.get(13));

      /* Elemento padre:13 / Elemento actual: 14   */
      v.add(doc.createTextNode("2"));
      ((Element)v.get(13)).appendChild((Text)v.get(14));

      /* Termina nodo Texto:14   */
      /* Termina nodo:13   */

      /* Empieza nodo:15 / Elemento padre: 12   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(15)).setAttribute("NOMBRE","DES_MARC" );
      ((Element)v.get(15)).setAttribute("TIPO","STRING" );
      ((Element)v.get(15)).setAttribute("LONGITUD","50" );
      ((Element)v.get(12)).appendChild((Element)v.get(15));

      /* Elemento padre:15 / Elemento actual: 16   */
      v.add(doc.createTextNode("MARCA 2"));
      ((Element)v.get(15)).appendChild((Text)v.get(16));

      /* Termina nodo Texto:16   */
      /* Termina nodo:15   */
      /* Termina nodo:12   */

      /* Empieza nodo:17 / Elemento padre: 6   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(6)).appendChild((Element)v.get(17));

      /* Empieza nodo:18 / Elemento padre: 17   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(18)).setAttribute("NOMBRE","OID" );
      ((Element)v.get(18)).setAttribute("TIPO","INTEGER" );
      ((Element)v.get(18)).setAttribute("LONGITUD","50" );
      ((Element)v.get(17)).appendChild((Element)v.get(18));

      /* Elemento padre:18 / Elemento actual: 19   */
      v.add(doc.createTextNode("3"));
      ((Element)v.get(18)).appendChild((Text)v.get(19));

      /* Termina nodo Texto:19   */
      /* Termina nodo:18   */

      /* Empieza nodo:20 / Elemento padre: 17   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(20)).setAttribute("NOMBRE","DES_MARC" );
      ((Element)v.get(20)).setAttribute("TIPO","STRING" );
      ((Element)v.get(20)).setAttribute("LONGITUD","50" );
      ((Element)v.get(17)).appendChild((Element)v.get(20));

      /* Elemento padre:20 / Elemento actual: 21   */
      v.add(doc.createTextNode("MARCA 3"));
      ((Element)v.get(20)).appendChild((Text)v.get(21));

      /* Termina nodo Texto:21   */
      /* Termina nodo:20   */
      /* Termina nodo:17   */
      /* Termina nodo:6   */

      /* Empieza nodo:22 / Elemento padre: 5   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(22)).setAttribute("ID","lineaProducto_ROWSET" );
      ((Element)v.get(5)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(22)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(24)).setAttribute("NOMBRE","OID" );
      ((Element)v.get(24)).setAttribute("TIPO","INTEGER" );
      ((Element)v.get(24)).setAttribute("LONGITUD","50" );
      ((Element)v.get(23)).appendChild((Element)v.get(24));

      /* Elemento padre:24 / Elemento actual: 25   */
      v.add(doc.createTextNode("1"));
      ((Element)v.get(24)).appendChild((Text)v.get(25));

      /* Termina nodo Texto:25   */
      /* Termina nodo:24   */

      /* Empieza nodo:26 / Elemento padre: 23   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(26)).setAttribute("NOMBRE","DES_LINE_PROD" );
      ((Element)v.get(26)).setAttribute("TIPO","STRING" );
      ((Element)v.get(26)).setAttribute("LONGITUD","50" );
      ((Element)v.get(23)).appendChild((Element)v.get(26));

      /* Elemento padre:26 / Elemento actual: 27   */
      v.add(doc.createTextNode("LINEA 1"));
      ((Element)v.get(26)).appendChild((Text)v.get(27));

      /* Termina nodo Texto:27   */
      /* Termina nodo:26   */
      /* Termina nodo:23   */

      /* Empieza nodo:28 / Elemento padre: 22   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("ROW"));
      ((Element)v.get(22)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(29)).setAttribute("NOMBRE","OID" );
      ((Element)v.get(29)).setAttribute("TIPO","INTEGER" );
      ((Element)v.get(29)).setAttribute("LONGITUD","50" );
      ((Element)v.get(28)).appendChild((Element)v.get(29));

      /* Elemento padre:29 / Elemento actual: 30   */
      v.add(doc.createTextNode("2"));
      ((Element)v.get(29)).appendChild((Text)v.get(30));

      /* Termina nodo Texto:30   */
      /* Termina nodo:29   */

      /* Empieza nodo:31 / Elemento padre: 28   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(31)).setAttribute("NOMBRE","DES_LINE_PROD" );
      ((Element)v.get(31)).setAttribute("TIPO","STRING" );
      ((Element)v.get(31)).setAttribute("LONGITUD","50" );
      ((Element)v.get(28)).appendChild((Element)v.get(31));

      /* Elemento padre:31 / Elemento actual: 32   */
      v.add(doc.createTextNode("LINEA 2"));
      ((Element)v.get(31)).appendChild((Text)v.get(32));

      /* Termina nodo Texto:32   */
      /* Termina nodo:31   */
      /* Termina nodo:28   */

      /* Empieza nodo:33 / Elemento padre: 22   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(22)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(34)).setAttribute("NOMBRE","OID" );
      ((Element)v.get(34)).setAttribute("TIPO","INTEGER" );
      ((Element)v.get(34)).setAttribute("LONGITUD","50" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Elemento padre:34 / Elemento actual: 35   */
      v.add(doc.createTextNode("3"));
      ((Element)v.get(34)).appendChild((Text)v.get(35));

      /* Termina nodo Texto:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:36 / Elemento padre: 33   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(36)).setAttribute("NOMBRE","DES_LINE_PROD" );
      ((Element)v.get(36)).setAttribute("TIPO","STRING" );
      ((Element)v.get(36)).setAttribute("LONGITUD","50" );
      ((Element)v.get(33)).appendChild((Element)v.get(36));

      /* Elemento padre:36 / Elemento actual: 37   */
      v.add(doc.createTextNode("LINEA 3"));
      ((Element)v.get(36)).appendChild((Text)v.get(37));

      /* Termina nodo Texto:37   */
      /* Termina nodo:36   */
      /* Termina nodo:33   */
      /* Termina nodo:22   */

      /* Empieza nodo:38 / Elemento padre: 5   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(38)).setAttribute("ID","generico_ROWSET" );
      ((Element)v.get(5)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(40)).setAttribute("NOMBRE","OID" );
      ((Element)v.get(40)).setAttribute("TIPO","INTEGER" );
      ((Element)v.get(40)).setAttribute("LONGITUD","50" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Elemento padre:40 / Elemento actual: 41   */
      v.add(doc.createTextNode("1"));
      ((Element)v.get(40)).appendChild((Text)v.get(41));

      /* Termina nodo Texto:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:42 / Elemento padre: 39   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(42)).setAttribute("NOMBRE","DES_GENE" );
      ((Element)v.get(42)).setAttribute("TIPO","STRING" );
      ((Element)v.get(42)).setAttribute("LONGITUD","50" );
      ((Element)v.get(39)).appendChild((Element)v.get(42));

      /* Elemento padre:42 / Elemento actual: 43   */
      v.add(doc.createTextNode("GENERICO 1"));
      ((Element)v.get(42)).appendChild((Text)v.get(43));

      /* Termina nodo Texto:43   */
      /* Termina nodo:42   */
      /* Termina nodo:39   */

      /* Empieza nodo:44 / Elemento padre: 38   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(38)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(45)).setAttribute("NOMBRE","OID" );
      ((Element)v.get(45)).setAttribute("TIPO","INTEGER" );
      ((Element)v.get(45)).setAttribute("LONGITUD","50" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Elemento padre:45 / Elemento actual: 46   */
      v.add(doc.createTextNode("2"));
      ((Element)v.get(45)).appendChild((Text)v.get(46));

      /* Termina nodo Texto:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:47 / Elemento padre: 44   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(47)).setAttribute("NOMBRE","DES_GENE" );
      ((Element)v.get(47)).setAttribute("TIPO","STRING" );
      ((Element)v.get(47)).setAttribute("LONGITUD","50" );
      ((Element)v.get(44)).appendChild((Element)v.get(47));

      /* Elemento padre:47 / Elemento actual: 48   */
      v.add(doc.createTextNode("GENERICO 2"));
      ((Element)v.get(47)).appendChild((Text)v.get(48));

      /* Termina nodo Texto:48   */
      /* Termina nodo:47   */
      /* Termina nodo:44   */

      /* Empieza nodo:49 / Elemento padre: 38   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(38)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(50)).setAttribute("NOMBRE","OID" );
      ((Element)v.get(50)).setAttribute("TIPO","INTEGER" );
      ((Element)v.get(50)).setAttribute("LONGITUD","50" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));

      /* Elemento padre:50 / Elemento actual: 51   */
      v.add(doc.createTextNode("3"));
      ((Element)v.get(50)).appendChild((Text)v.get(51));

      /* Termina nodo Texto:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:52 / Elemento padre: 49   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(52)).setAttribute("NOMBRE","DES_GENE" );
      ((Element)v.get(52)).setAttribute("TIPO","STRING" );
      ((Element)v.get(52)).setAttribute("LONGITUD","50" );
      ((Element)v.get(49)).appendChild((Element)v.get(52));

      /* Elemento padre:52 / Elemento actual: 53   */
      v.add(doc.createTextNode("GENERICO 3"));
      ((Element)v.get(52)).appendChild((Text)v.get(53));

      /* Termina nodo Texto:53   */
      /* Termina nodo:52   */
      /* Termina nodo:49   */
      /* Termina nodo:38   */

      /* Empieza nodo:54 / Elemento padre: 5   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(54)).setAttribute("ID","supergenerico_ROWSET" );
      ((Element)v.get(5)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(54)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(56)).setAttribute("NOMBRE","OID" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(56)).setAttribute("TIPO","INTEGER" );
      ((Element)v.get(56)).setAttribute("LONGITUD","50" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Elemento padre:56 / Elemento actual: 57   */
      v.add(doc.createTextNode("1"));
      ((Element)v.get(56)).appendChild((Text)v.get(57));

      /* Termina nodo Texto:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:58 / Elemento padre: 55   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(58)).setAttribute("NOMBRE","DES_SUPE_GENE" );
      ((Element)v.get(58)).setAttribute("TIPO","STRING" );
      ((Element)v.get(58)).setAttribute("LONGITUD","50" );
      ((Element)v.get(55)).appendChild((Element)v.get(58));

      /* Elemento padre:58 / Elemento actual: 59   */
      v.add(doc.createTextNode("SUPERGENERICO 1"));
      ((Element)v.get(58)).appendChild((Text)v.get(59));

      /* Termina nodo Texto:59   */
      /* Termina nodo:58   */
      /* Termina nodo:55   */

      /* Empieza nodo:60 / Elemento padre: 54   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(54)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(61)).setAttribute("NOMBRE","OID" );
      ((Element)v.get(61)).setAttribute("TIPO","INTEGER" );
      ((Element)v.get(61)).setAttribute("LONGITUD","50" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));

      /* Elemento padre:61 / Elemento actual: 62   */
      v.add(doc.createTextNode("2"));
      ((Element)v.get(61)).appendChild((Text)v.get(62));

      /* Termina nodo Texto:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:63 / Elemento padre: 60   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(63)).setAttribute("NOMBRE","DES_SUPE_GENE" );
      ((Element)v.get(63)).setAttribute("TIPO","STRING" );
      ((Element)v.get(63)).setAttribute("LONGITUD","50" );
      ((Element)v.get(60)).appendChild((Element)v.get(63));

      /* Elemento padre:63 / Elemento actual: 64   */
      v.add(doc.createTextNode("SUPERGENERICO 2"));
      ((Element)v.get(63)).appendChild((Text)v.get(64));

      /* Termina nodo Texto:64   */
      /* Termina nodo:63   */
      /* Termina nodo:60   */

      /* Empieza nodo:65 / Elemento padre: 54   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(54)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(66)).setAttribute("NOMBRE","OID" );
      ((Element)v.get(66)).setAttribute("TIPO","INTEGER" );
      ((Element)v.get(66)).setAttribute("LONGITUD","50" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Elemento padre:66 / Elemento actual: 67   */
      v.add(doc.createTextNode("3"));
      ((Element)v.get(66)).appendChild((Text)v.get(67));

      /* Termina nodo Texto:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:68 / Elemento padre: 65   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(68)).setAttribute("NOMBRE","DES_SUPE_GENE" );
      ((Element)v.get(68)).setAttribute("TIPO","STRING" );
      ((Element)v.get(68)).setAttribute("LONGITUD","50" );
      ((Element)v.get(65)).appendChild((Element)v.get(68));

      /* Elemento padre:68 / Elemento actual: 69   */
      v.add(doc.createTextNode("SUPERGENERICO 3"));
      ((Element)v.get(68)).appendChild((Text)v.get(69));

      /* Termina nodo Texto:69   */
      /* Termina nodo:68   */
      /* Termina nodo:65   */
      /* Termina nodo:54   */

      /* Empieza nodo:70 / Elemento padre: 5   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(70)).setAttribute("ID","negocio_ROWSET" );
      ((Element)v.get(5)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(70)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(72)).setAttribute("NOMBRE","OID" );
      ((Element)v.get(72)).setAttribute("TIPO","STRING" );
      ((Element)v.get(72)).setAttribute("LONGITUD","50" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));

      /* Elemento padre:72 / Elemento actual: 73   */
      v.add(doc.createTextNode("1"));
      ((Element)v.get(72)).appendChild((Text)v.get(73));

      /* Termina nodo Texto:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:74 / Elemento padre: 71   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(74)).setAttribute("NOMBRE","DES_NEGO" );
      ((Element)v.get(74)).setAttribute("TIPO","STRING" );
      ((Element)v.get(74)).setAttribute("LONGITUD","50" );
      ((Element)v.get(71)).appendChild((Element)v.get(74));

      /* Elemento padre:74 / Elemento actual: 75   */
      v.add(doc.createTextNode("NEGOCIO 1"));
      ((Element)v.get(74)).appendChild((Text)v.get(75));

      /* Termina nodo Texto:75   */
      /* Termina nodo:74   */
      /* Termina nodo:71   */

      /* Empieza nodo:76 / Elemento padre: 70   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(70)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(77)).setAttribute("NOMBRE","OID" );
      ((Element)v.get(77)).setAttribute("TIPO","STRING" );
      ((Element)v.get(77)).setAttribute("LONGITUD","50" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));

      /* Elemento padre:77 / Elemento actual: 78   */
      v.add(doc.createTextNode("2"));
      ((Element)v.get(77)).appendChild((Text)v.get(78));

      /* Termina nodo Texto:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:79 / Elemento padre: 76   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(79)).setAttribute("NOMBRE","DES_NEGO" );
      ((Element)v.get(79)).setAttribute("TIPO","STRING" );
      ((Element)v.get(79)).setAttribute("LONGITUD","50" );
      ((Element)v.get(76)).appendChild((Element)v.get(79));

      /* Elemento padre:79 / Elemento actual: 80   */
      v.add(doc.createTextNode("NEGOCIO 2"));
      ((Element)v.get(79)).appendChild((Text)v.get(80));

      /* Termina nodo Texto:80   */
      /* Termina nodo:79   */
      /* Termina nodo:76   */

      /* Empieza nodo:81 / Elemento padre: 70   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(70)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(82)).setAttribute("NOMBRE","OID" );
      ((Element)v.get(82)).setAttribute("TIPO","STRING" );
      ((Element)v.get(82)).setAttribute("LONGITUD","50" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));

      /* Elemento padre:82 / Elemento actual: 83   */
      v.add(doc.createTextNode("3"));
      ((Element)v.get(82)).appendChild((Text)v.get(83));

      /* Termina nodo Texto:83   */
      /* Termina nodo:82   */

      /* Empieza nodo:84 / Elemento padre: 81   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(84)).setAttribute("NOMBRE","DES_NEGO" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(84)).setAttribute("TIPO","STRING" );
      ((Element)v.get(84)).setAttribute("LONGITUD","50" );
      ((Element)v.get(81)).appendChild((Element)v.get(84));

      /* Elemento padre:84 / Elemento actual: 85   */
      v.add(doc.createTextNode("NEGOCIO 3"));
      ((Element)v.get(84)).appendChild((Text)v.get(85));

      /* Termina nodo Texto:85   */
      /* Termina nodo:84   */
      /* Termina nodo:81   */
      /* Termina nodo:70   */

      /* Empieza nodo:86 / Elemento padre: 5   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(86)).setAttribute("ID","uniNegocio_ROWSET" );
      ((Element)v.get(5)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(86)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(88)).setAttribute("NOMBRE","OID" );
      ((Element)v.get(88)).setAttribute("TIPO","INTEGER" );
      ((Element)v.get(88)).setAttribute("LONGITUD","50" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Elemento padre:88 / Elemento actual: 89   */
      v.add(doc.createTextNode("1"));
      ((Element)v.get(88)).appendChild((Text)v.get(89));

      /* Termina nodo Texto:89   */
      /* Termina nodo:88   */

      /* Empieza nodo:90 / Elemento padre: 87   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(90)).setAttribute("NOMBRE","DES_UNID_NEGO" );
      ((Element)v.get(90)).setAttribute("TIPO","STRING" );
      ((Element)v.get(90)).setAttribute("LONGITUD","50" );
      ((Element)v.get(87)).appendChild((Element)v.get(90));

      /* Elemento padre:90 / Elemento actual: 91   */
      v.add(doc.createTextNode("UNIDAD 1"));
      ((Element)v.get(90)).appendChild((Text)v.get(91));

      /* Termina nodo Texto:91   */
      /* Termina nodo:90   */
      /* Termina nodo:87   */

      /* Empieza nodo:92 / Elemento padre: 86   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(86)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(93)).setAttribute("NOMBRE","OID" );
      ((Element)v.get(93)).setAttribute("TIPO","INTEGER" );
      ((Element)v.get(93)).setAttribute("LONGITUD","50" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));

      /* Elemento padre:93 / Elemento actual: 94   */
      v.add(doc.createTextNode("2"));
      ((Element)v.get(93)).appendChild((Text)v.get(94));

      /* Termina nodo Texto:94   */
      /* Termina nodo:93   */

      /* Empieza nodo:95 / Elemento padre: 92   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(95)).setAttribute("NOMBRE","DES_UNID_NEGO" );
      ((Element)v.get(95)).setAttribute("TIPO","STRING" );
      ((Element)v.get(95)).setAttribute("LONGITUD","50" );
      ((Element)v.get(92)).appendChild((Element)v.get(95));

      /* Elemento padre:95 / Elemento actual: 96   */
      v.add(doc.createTextNode("UNIDAD 2"));
      ((Element)v.get(95)).appendChild((Text)v.get(96));

      /* Termina nodo Texto:96   */
      /* Termina nodo:95   */
      /* Termina nodo:92   */

      /* Empieza nodo:97 / Elemento padre: 86   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(86)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(98)).setAttribute("NOMBRE","OID" );
      ((Element)v.get(98)).setAttribute("TIPO","INTEGER" );
      ((Element)v.get(98)).setAttribute("LONGITUD","50" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Elemento padre:98 / Elemento actual: 99   */
      v.add(doc.createTextNode("3"));
      ((Element)v.get(98)).appendChild((Text)v.get(99));

      /* Termina nodo Texto:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:100 / Elemento padre: 97   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(100)).setAttribute("NOMBRE","DES_UNID_NEGO" );
      ((Element)v.get(100)).setAttribute("TIPO","STRING" );
      ((Element)v.get(100)).setAttribute("LONGITUD","50" );
      ((Element)v.get(97)).appendChild((Element)v.get(100));

      /* Elemento padre:100 / Elemento actual: 101   */
      v.add(doc.createTextNode("UNIDAD 3"));
      ((Element)v.get(100)).appendChild((Text)v.get(101));

      /* Termina nodo Texto:101   */
      /* Termina nodo:100   */
      /* Termina nodo:97   */
      /* Termina nodo:86   */

      /* Empieza nodo:102 / Elemento padre: 5   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(102)).setAttribute("ID","catalogo_ROWSET" );
      ((Element)v.get(5)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(102)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(104)).setAttribute("NOMBRE","COD_CATA" );
      ((Element)v.get(104)).setAttribute("TIPO","INTEGER" );
      ((Element)v.get(104)).setAttribute("LONGITUD","50" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));

      /* Elemento padre:104 / Elemento actual: 105   */
      v.add(doc.createTextNode("1"));
      ((Element)v.get(104)).appendChild((Text)v.get(105));

      /* Termina nodo Texto:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:106 / Elemento padre: 103   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(106)).setAttribute("NOMBRE","DES_CATA" );
      ((Element)v.get(106)).setAttribute("TIPO","STRING" );
      ((Element)v.get(106)).setAttribute("LONGITUD","50" );
      ((Element)v.get(103)).appendChild((Element)v.get(106));

      /* Elemento padre:106 / Elemento actual: 107   */
      v.add(doc.createTextNode("CATALOGO 1"));
      ((Element)v.get(106)).appendChild((Text)v.get(107));

      /* Termina nodo Texto:107   */
      /* Termina nodo:106   */
      /* Termina nodo:103   */

      /* Empieza nodo:108 / Elemento padre: 102   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(102)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(109)).setAttribute("NOMBRE","COD_CATA" );
      ((Element)v.get(109)).setAttribute("TIPO","INTEGER" );
      ((Element)v.get(109)).setAttribute("LONGITUD","50" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));

      /* Elemento padre:109 / Elemento actual: 110   */
      v.add(doc.createTextNode("2"));
      ((Element)v.get(109)).appendChild((Text)v.get(110));

      /* Termina nodo Texto:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:111 / Elemento padre: 108   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(111)).setAttribute("NOMBRE","DES_CATA" );
      ((Element)v.get(111)).setAttribute("TIPO","STRING" );
      ((Element)v.get(111)).setAttribute("LONGITUD","50" );
      ((Element)v.get(108)).appendChild((Element)v.get(111));

      /* Elemento padre:111 / Elemento actual: 112   */
      v.add(doc.createTextNode("CATALOGO 2"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(111)).appendChild((Text)v.get(112));

      /* Termina nodo Texto:112   */
      /* Termina nodo:111   */
      /* Termina nodo:108   */

      /* Empieza nodo:113 / Elemento padre: 102   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(102)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(114)).setAttribute("NOMBRE","COD_CATA" );
      ((Element)v.get(114)).setAttribute("TIPO","INTEGER" );
      ((Element)v.get(114)).setAttribute("LONGITUD","50" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Elemento padre:114 / Elemento actual: 115   */
      v.add(doc.createTextNode("3"));
      ((Element)v.get(114)).appendChild((Text)v.get(115));

      /* Termina nodo Texto:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:116 / Elemento padre: 113   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(116)).setAttribute("NOMBRE","DES_CATA" );
      ((Element)v.get(116)).setAttribute("TIPO","STRING" );
      ((Element)v.get(116)).setAttribute("LONGITUD","50" );
      ((Element)v.get(113)).appendChild((Element)v.get(116));

      /* Elemento padre:116 / Elemento actual: 117   */
      v.add(doc.createTextNode("CATALOGO 3"));
      ((Element)v.get(116)).appendChild((Text)v.get(117));

      /* Termina nodo Texto:117   */
      /* Termina nodo:116   */
      /* Termina nodo:113   */
      /* Termina nodo:102   */
      /* Termina nodo:5   */
      /* Termina nodo:4   */


   }

}
