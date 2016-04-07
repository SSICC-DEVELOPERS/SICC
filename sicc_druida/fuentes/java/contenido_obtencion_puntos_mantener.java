
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_obtencion_puntos_mantener  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         

      getXML180(doc);
         

      getXML270(doc);
         

      getXML360(doc);
         

      getXML450(doc);
         

      getXML540(doc);
         

      getXML630(doc);
         

      getXML720(doc);
         

      getXML810(doc);
         

      getXML900(doc);
         

      getXML990(doc);
         

      getXML1080(doc);
         

      getXML1170(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_obtencion_puntos_mantener" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("titulo","Crear concurso" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(2)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","i18NJS.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(5)).setAttribute("src","pestanyas_concurso_inc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Elemento padre:6 / Elemento actual: 7   */
      v.add(doc.createTextNode("\r \r\rvar txt = false;\rvar oid = \"\";\r\rfunction onLoadPag(){      \r         configurarMenuSecundario(\"formulario\");\r    btnProxy(2, 0);     \r    btnProxy(5, 1);         \r        \r    focaliza(\"formulario.txtFactorConversion\");   \r        \r    set(\"formulario.txtFactorConversion\", get(\"formulario.factorConversion\"));\r    set(\"formulario.txtPuntosAsignar\", get(\"formulario.puntosAsig\"));\r    set(\"formulario.ckComunicacionPuntosAsignar\", get(\"formulario.indComunic\"));\r    set(\"formulario.txtMensajesPuntosAsignar\",get(\"formulario.valorMensaje\"));\r\r          var valMe = get(\"formulario.txtMensaj\");\r        \r    if (valMe == 'true'){\r                      accion(\"formulario.txtMensajesPuntosAsignar\", \".disabled=true\");\r         var txt = true;        \r    }\r        \r    set(\"formulario.PuntejeEsAcumulativo\", get(\"formulario.indPuntajeAcu\"));\r    set(\"formulario.ckActividad\", get(\"formulario.indActividad\"));\r    set(\"formulario.ckConstancia\", get(\"formulario.indConstancia\"));\r    set(\"formulario.oid\", get(\"formulario.oidObtencion\"));        \r        \r    var valores =  get(\"formulario.campos\");\r        \r    if(valores != null &&  valores == 'true'){\r             deshabilitaCampos();         \r    }\r\r          finCargaPagina = true;\r  \r  \r   var menu = get(\"formulario.opcionMenu\");\r  \r  if(menu ==\"Consultar Concurso\"){  \r   btnProxy(1, 0);\r   btnProxy(2, 1);\r   btnProxy(3, 0);\r   btnProxy(5, 0);\r   btnProxy(7, 0);\r   btnProxy(8, 0);\r   btnProxy(9, 0);\r   deshabilitaCampos();\r  }\r  else if(menu ==\"Modificar Concurso\") {\r         btnProxy(2,'1');\r         btnProxy(3,'0');\r         btnProxy(7,'0');\r         btnProxy(8,'0');\r         btnProxy(9,'0');\r  }\r}\r\rfunction fVolver() {\r         window.close();\r}\r\rfunction deshabilitaCampos(){\r    accion(\"formulario.txtFactorConversion\",\".disabled=true\");\r    accion(\"formulario.txtPuntosAsignar\", \".disabled=true\");\r    accion(\"formulario.ckComunicacionPuntosAsignar\", \".disabled=true\");\r    accion(\"formulario.txtMensajesPuntosAsignar\", \".disabled=true\");\r    accion(\"formulario.PuntejeEsAcumulativo\", \".disabled=true\");\r    accion(\"formulario.ckActividad\",\".disabled=true\");\r    accion(\"formulario.ckConstancia\", \".disabled=true\");\r } \r  \rfunction fLimpiar(){\r         onLoadPag();\r}  \r\rfunction onChangeConstancia(){     \r         if(get(\"formulario.ckConstancia\")==\"S\") {	\r                  if(get(\"formulario.ckActividad\")==\"S\") {\r                           set(\"formulario.ckActividad\", \"N\");\r                  }\r         }\r} \r\rfunction onChangeActividad(){\r         if(get(\"formulario.ckActividad\")==\"S\") {	\r                  if(get(\"formulario.ckConstancia\")==\"S\") {\r                           set(\"formulario.ckConstancia\", \"N\");\r                  }\r         } \r}\r\rfunction onChangeComunicacion(){  \r         if(get(\"formulario.ckComunicacionPuntosAsignar\")==\"S\") {\r                  accion(\"formulario.txtMensajesPuntosAsignar\", \".disabled=false\");\r         }\r         else {\r                  set(\"formulario.txtMensajesPuntosAsignar\", \"\");\r                  accion(\"formulario.txtMensajesPuntosAsignar\", \".disabled=true\");\r         }\r}\r\rfunction tomarValoresCamposPantalla() {\r         set(\"formulario.factorConversion\", get(\"formulario.txtFactorConversion\"));\r         set(\"formulario.puntosAsig\", get(\"formulario.txtPuntosAsignar\"));\r         set(\"formulario.indComunic\", get(\"formulario.ckComunicacionPuntosAsignar\"));\r         set(\"formulario.txtMensaj\", get(\"formulario.txtMensajesPuntosAsignar\"));\r    set(\"formulario.indPuntajeAcu\", get(\"formulario.PuntejeEsAcumulativo\"));\r         set(\"formulario.indActividad\", get(\"formulario.ckActividad\"));\r         set(\"formulario.indConstancia\", get(\"formulario.ckConstancia\"));\r         set(\"formulario.oidObtencion\", get(\"formulario.oidObtencion\"));\r         var datosObligatorios = comprobarDatosObligatorios();\r    set(\"formulario.datosObligatorios\", datosObligatorios);\r         set(\"formulario.opcionMenu\", get(\"formulario.opcionMenu\"));\r}\r\rfunction onClickPestanyaPaginaObtencionPuntos(valor, form, nombreLP) {\r	if(get(\"formulario.opcionMenu\")!=\"Consultar Concurso\") {\r	            if(!sicc_validaciones_generales('grupoObligatorio')) {\r		    return;\r        }\r	    tomarValoresCamposPantalla();\r	    onClickPestanyaHabilitada(valor, form, nombreLP);	 \r	}\r	else {\r	   tomarValoresCamposPantalla();\r       onClickPestanyaHabilitada(valor, form, nombreLP);\r	}\r}\r\rfunction fGuardar(){ \r         accionGuardar();\r}\r\r\rfunction accionGuardar() {\r                  if(!sicc_validaciones_generales('grupoObligatorio')) {\r                  return;\r         }\r\r         tomarValoresCamposPantalla();\r         eval(\"formulario\").oculto= \"S\";\r         set(\"formulario.conectorAction\", \"LPMantenerObtencionPuntos\");\r         set(\"formulario.accion\", \"guardar\");\r         enviaSICC('formulario', '', '', 'N');\r}\r\rfunction comprobarDatosObligatorios(){\r         if(get(\"formulario.txtFactorConversion\")!=\"\" && get(\"formulario.txtPuntosAsignar\")!=\"\") {\r                  return true;\r         }\r         else {\r                  return false;\r         }\r} \r\rfunction focalizaTab(){\r         focaliza(\"formulario.txtFactorConversion\");\r} \r \rfunction focalizaShTab(){ \r         focaliza(\"formulario.ckConstancia\");\r}\r\r \r\r"));
      ((Element)v.get(6)).appendChild((Text)v.get(7));

      /* Termina nodo Texto:7   */
      /* Termina nodo:6   */

      /* Empieza nodo:8 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(8));

      /* Empieza nodo:9 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","txtFactorConversion" );
      ((Element)v.get(9)).setAttribute("group","grupoObligatorio" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","1893" );
      ((Element)v.get(9)).setAttribute("min","0" );
      ((Element)v.get(9)).setAttribute("max","9999999.99" );
      ((Element)v.get(9)).setAttribute("format","n" );
      ((Element)v.get(8)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","txtPuntosAsignar" );
      ((Element)v.get(10)).setAttribute("group","grupoObligatorio" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("cod","1894" );
      ((Element)v.get(10)).setAttribute("min","0" );
      ((Element)v.get(10)).setAttribute("max","9999" );
      ((Element)v.get(10)).setAttribute("format","e" );
      ((Element)v.get(8)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","txtFactorConversion" );
      ((Element)v.get(11)).setAttribute("group","grupoOpcional" );
      ((Element)v.get(11)).setAttribute("required","false" );
      ((Element)v.get(11)).setAttribute("cod","1893" );
      ((Element)v.get(11)).setAttribute("min","0" );
      ((Element)v.get(11)).setAttribute("max","9999999.99" );
      ((Element)v.get(11)).setAttribute("format","n" );
      ((Element)v.get(8)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","txtPuntosAsignar" );
      ((Element)v.get(12)).setAttribute("group","grupoOpcional" );
      ((Element)v.get(12)).setAttribute("required","false" );
      ((Element)v.get(12)).setAttribute("cod","1894" );
      ((Element)v.get(12)).setAttribute("min","0" );
      ((Element)v.get(12)).setAttribute("max","9999" );
      ((Element)v.get(12)).setAttribute("format","e" );
      ((Element)v.get(8)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */
      /* Termina nodo:8   */

      /* Empieza nodo:13 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(13)).setAttribute("nombre","formulario" );
      ((Element)v.get(13)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(13));

      /* Empieza nodo:14 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","accion" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(18)).setAttribute("valor","" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(13)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","idPestanyaDest" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hIdioma" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hPais" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","datosObligatorios" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","hIndEstadoProductos" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","hIndEstadoAmbitoGeografico" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hIndEstadoCalificion" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hIndEstadoGerentes" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hIndEstadoConsultoras" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hIndEstadoProgramaNuevas" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","hIndEstadoMultinivel" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","factorConversion" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","puntosAsig" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","indComunic" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","txtMensaj" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","indPuntajeAcu" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","indActividad" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","indConstancia" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","oidObtencion" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","campos" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","valorMensaje" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 13   */
      v.add(doc.createElement("table"));
      ((Element)v.get(40)).setAttribute("width","100%" );
      ((Element)v.get(40)).setAttribute("height","100%" );
      ((Element)v.get(40)).setAttribute("border","0" );
      ((Element)v.get(40)).setAttribute("align","center" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(40)).setAttribute("cellpadding","0" );
      ((Element)v.get(40)).setAttribute("cellspacing","0" );
      ((Element)v.get(40)).setAttribute("class","menu4" );
      ((Element)v.get(13)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).setAttribute("width","12" );
      ((Element)v.get(42)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(42)).setAttribute("class","menu5texto" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(43)).setAttribute("src","b.gif" );
      ((Element)v.get(43)).setAttribute("width","12" );
      ((Element)v.get(43)).setAttribute("height","30" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:44 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(44)).setAttribute("class","menu5texto" );
      ((Element)v.get(41)).appendChild((Element)v.get(44));

      /* Elemento padre:44 / Elemento actual: 45   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(44)).appendChild((Text)v.get(45));

      /* Termina nodo Texto:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:46 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).setAttribute("width","10" );
      ((Element)v.get(46)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(46)).setAttribute("class","menu5texto" );
      ((Element)v.get(41)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(47)).setAttribute("src","b.gif" );
      ((Element)v.get(47)).setAttribute("width","10" );
      ((Element)v.get(47)).setAttribute("height","8" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:48 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).setAttribute("width","92" );
      ((Element)v.get(48)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(48)).setAttribute("class","menu5texto" );
      ((Element)v.get(41)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("table"));
      ((Element)v.get(49)).setAttribute("width","75" );
      ((Element)v.get(49)).setAttribute("border","1" );
      ((Element)v.get(49)).setAttribute("align","center" );
      ((Element)v.get(49)).setAttribute("cellpadding","1" );
      ((Element)v.get(49)).setAttribute("cellspacing","0" );
      ((Element)v.get(49)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(49)).setAttribute("onmouseover","activarPuntero('formulario',1,'lblParametrosGenerales');" );
      ((Element)v.get(49)).setAttribute("onclick","onClickPestanyaPaginaObtencionPuntos(1,'formulario','LPMantenerObtencionPuntos');" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(50)).setAttribute("align","center" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(51)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(52)).setAttribute("nombre","lblParametrosGenerales" );
      ((Element)v.get(52)).setAttribute("alto","13" );
      ((Element)v.get(52)).setAttribute("filas","1" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(52)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(52)).setAttribute("cod","00393" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */
      /* Termina nodo:50   */
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:53 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).setAttribute("width","10" );
      ((Element)v.get(53)).setAttribute("class","menu5texto" );
      ((Element)v.get(41)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(54)).setAttribute("src","b.gif" );
      ((Element)v.get(54)).setAttribute("width","10" );
      ((Element)v.get(54)).setAttribute("height","8" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */

      /* Empieza nodo:55 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).setAttribute("width","20" );
      ((Element)v.get(55)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(55)).setAttribute("class","menu5texto" );
      ((Element)v.get(41)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("table"));
      ((Element)v.get(56)).setAttribute("width","75" );
      ((Element)v.get(56)).setAttribute("border","1" );
      ((Element)v.get(56)).setAttribute("align","center" );
      ((Element)v.get(56)).setAttribute("cellpadding","1" );
      ((Element)v.get(56)).setAttribute("cellspacing","0" );
      ((Element)v.get(56)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(56)).setAttribute("onmouseover","activarPuntero('formulario',5,'lblProductos');" );
      ((Element)v.get(56)).setAttribute("onclick","onClickPestanyaPaginaObtencionPuntos(5,'formulario','LPMantenerObtencionPuntos');" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(57)).setAttribute("align","center" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).setAttribute("nowrap","nowrap" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(57)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(59)).setAttribute("nombre","lblProductos" );
      ((Element)v.get(59)).setAttribute("alto","13" );
      ((Element)v.get(59)).setAttribute("filas","1" );
      ((Element)v.get(59)).setAttribute("valor","" );
      ((Element)v.get(59)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(59)).setAttribute("cod","0094" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */
      /* Termina nodo:57   */
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:60 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).setAttribute("width","10" );
      ((Element)v.get(60)).setAttribute("class","menu5texto" );
      ((Element)v.get(41)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(61)).setAttribute("src","b.gif" );
      ((Element)v.get(61)).setAttribute("width","10" );
      ((Element)v.get(61)).setAttribute("height","8" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:62 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).setAttribute("width","20" );
      ((Element)v.get(62)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(62)).setAttribute("class","menu5texto" );
      ((Element)v.get(41)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("table"));
      ((Element)v.get(63)).setAttribute("width","75" );
      ((Element)v.get(63)).setAttribute("border","1" );
      ((Element)v.get(63)).setAttribute("align","center" );
      ((Element)v.get(63)).setAttribute("cellpadding","1" );
      ((Element)v.get(63)).setAttribute("cellspacing","0" );
      ((Element)v.get(63)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(63)).setAttribute("onmouseover","activarPuntero('formulario',6,'lblPremios');" );
      ((Element)v.get(63)).setAttribute("onclick","onClickPestanyaPaginaObtencionPuntos(6,'formulario','LPMantenerObtencionPuntos');" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(64)).setAttribute("align","center" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(66)).setAttribute("nombre","lblPremios" );
      ((Element)v.get(66)).setAttribute("alto","13" );
      ((Element)v.get(66)).setAttribute("filas","1" );
      ((Element)v.get(66)).setAttribute("valor","" );
      ((Element)v.get(66)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(66)).setAttribute("cod","00394" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */
      /* Termina nodo:64   */
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:67 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(67)).setAttribute("width","10" );
      ((Element)v.get(67)).setAttribute("class","menu5texto" );
      ((Element)v.get(41)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(68)).setAttribute("src","b.gif" );
      ((Element)v.get(68)).setAttribute("width","10" );
      ((Element)v.get(68)).setAttribute("height","8" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:69 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).setAttribute("width","20" );
      ((Element)v.get(69)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(69)).setAttribute("class","menu5texto" );
      ((Element)v.get(41)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("table"));
      ((Element)v.get(70)).setAttribute("width","75" );
      ((Element)v.get(70)).setAttribute("border","1" );
      ((Element)v.get(70)).setAttribute("align","center" );
      ((Element)v.get(70)).setAttribute("cellpadding","1" );
      ((Element)v.get(70)).setAttribute("cellspacing","0" );
      ((Element)v.get(70)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(70)).setAttribute("onmouseover","activarPuntero('formulario',7,'lblRequisitos');" );
      ((Element)v.get(70)).setAttribute("onclick","onClickPestanyaPaginaObtencionPuntos(7,'formulario','LPMantenerObtencionPuntos');" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(71)).setAttribute("align","center" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(73)).setAttribute("nombre","lblRequisitos" );
      ((Element)v.get(73)).setAttribute("alto","13" );
      ((Element)v.get(73)).setAttribute("filas","1" );
      ((Element)v.get(73)).setAttribute("valor","" );
      ((Element)v.get(73)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(73)).setAttribute("cod","00395" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */
      /* Termina nodo:71   */
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:74 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).setAttribute("width","10" );
      ((Element)v.get(74)).setAttribute("class","menu5texto" );
      ((Element)v.get(41)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(75)).setAttribute("src","b.gif" );
      ((Element)v.get(75)).setAttribute("width","10" );
      ((Element)v.get(75)).setAttribute("height","8" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:76 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(76)).setAttribute("width","20" );
      ((Element)v.get(76)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(76)).setAttribute("class","menu5texto" );
      ((Element)v.get(41)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("table"));
      ((Element)v.get(77)).setAttribute("width","75" );
      ((Element)v.get(77)).setAttribute("border","1" );
      ((Element)v.get(77)).setAttribute("align","center" );
      ((Element)v.get(77)).setAttribute("cellpadding","1" );
      ((Element)v.get(77)).setAttribute("cellspacing","0" );
      ((Element)v.get(77)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(77)).setAttribute("bgcolor","#496A9A" );
      ((Element)v.get(77)).setAttribute("onmouseover","" );
      ((Element)v.get(77)).setAttribute("onclick","" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(78)).setAttribute("align","center" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(80)).setAttribute("nombre","lblObtencionPuntos" );
      ((Element)v.get(80)).setAttribute("alto","13" );
      ((Element)v.get(80)).setAttribute("filas","1" );
      ((Element)v.get(80)).setAttribute("valor","" );
      ((Element)v.get(80)).setAttribute("id","menu5textoblanca" );
      ((Element)v.get(80)).setAttribute("cod","00396" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */
      /* Termina nodo:78   */
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:81 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(81)).setAttribute("width","10" );
      ((Element)v.get(81)).setAttribute("class","menu5texto" );
      ((Element)v.get(41)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(82)).setAttribute("src","b.gif" );
      ((Element)v.get(82)).setAttribute("width","10" );
      ((Element)v.get(82)).setAttribute("height","8" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:83 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).setAttribute("width","20" );
      ((Element)v.get(83)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(83)).setAttribute("class","menu5texto" );
      ((Element)v.get(41)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("table"));
      ((Element)v.get(84)).setAttribute("width","75" );
      ((Element)v.get(84)).setAttribute("border","1" );
      ((Element)v.get(84)).setAttribute("align","center" );
      ((Element)v.get(84)).setAttribute("cellpadding","1" );
      ((Element)v.get(84)).setAttribute("cellspacing","0" );
      ((Element)v.get(84)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(84)).setAttribute("onmouseover","activarPuntero('formulario',8,'lblDespachoPremios');" );
      ((Element)v.get(84)).setAttribute("onclick","onClickPestanyaPaginaObtencionPuntos(8,'formulario','LPMantenerObtencionPuntos');" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(85)).setAttribute("align","center" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(86)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(87)).setAttribute("nombre","lblDespachoPremios" );
      ((Element)v.get(87)).setAttribute("alto","13" );
      ((Element)v.get(87)).setAttribute("filas","1" );
      ((Element)v.get(87)).setAttribute("valor","" );
      ((Element)v.get(87)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(87)).setAttribute("cod","00397" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */
      /* Termina nodo:85   */
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:88 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).setAttribute("width","16" );
      ((Element)v.get(88)).setAttribute("class","menu5texto" );
      ((Element)v.get(41)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(89)).setAttribute("src","b.gif" );
      ((Element)v.get(89)).setAttribute("width","12" );
      ((Element)v.get(89)).setAttribute("height","8" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:90 / Elemento padre: 13   */
      v.add(doc.createElement("table"));
      ((Element)v.get(90)).setAttribute("width","100%" );
      ((Element)v.get(90)).setAttribute("height","100%" );
      ((Element)v.get(90)).setAttribute("border","0" );
      ((Element)v.get(90)).setAttribute("align","center" );
      ((Element)v.get(90)).setAttribute("cellpadding","0" );
      ((Element)v.get(90)).setAttribute("cellspacing","0" );
      ((Element)v.get(90)).setAttribute("class","menu4" );
      ((Element)v.get(13)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
   }

   private void getXML450(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(90)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(92)).setAttribute("width","12" );
      ((Element)v.get(92)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(92)).setAttribute("class","menu5texto" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(93)).setAttribute("src","b.gif" );
      ((Element)v.get(93)).setAttribute("width","12" );
      ((Element)v.get(93)).setAttribute("height","30" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:94 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(94)).setAttribute("class","menu5texto" );
      ((Element)v.get(91)).appendChild((Element)v.get(94));

      /* Elemento padre:94 / Elemento actual: 95   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(94)).appendChild((Text)v.get(95));

      /* Termina nodo Texto:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:96 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).setAttribute("width","10" );
      ((Element)v.get(96)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(96)).setAttribute("class","menu5texto" );
      ((Element)v.get(91)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(97)).setAttribute("src","b.gif" );
      ((Element)v.get(97)).setAttribute("width","10" );
      ((Element)v.get(97)).setAttribute("height","8" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:98 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).setAttribute("width","70" );
      ((Element)v.get(98)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(98)).setAttribute("class","menu5texto" );
      ((Element)v.get(91)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("table"));
      ((Element)v.get(99)).setAttribute("width","75" );
      ((Element)v.get(99)).setAttribute("border","1" );
      ((Element)v.get(99)).setAttribute("align","center" );
      ((Element)v.get(99)).setAttribute("cellpadding","1" );
      ((Element)v.get(99)).setAttribute("cellspacing","0" );
      ((Element)v.get(99)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(99)).setAttribute("onmouseover","activarPuntero('formulario',3,'lblAmbitoGeografico');" );
      ((Element)v.get(99)).setAttribute("onclick","onClickPestanyaPaginaObtencionPuntos(3,'formulario','LPMantenerObtencionPuntos');" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(100)).setAttribute("align","center" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(101)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(102)).setAttribute("nombre","lblAmbitoGeografico" );
      ((Element)v.get(102)).setAttribute("alto","13" );
      ((Element)v.get(102)).setAttribute("filas","1" );
      ((Element)v.get(102)).setAttribute("valor","" );
      ((Element)v.get(102)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(102)).setAttribute("cod","2801" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */
      /* Termina nodo:100   */
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:103 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(103)).setAttribute("width","10" );
      ((Element)v.get(103)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(103)).setAttribute("class","menu5texto" );
      ((Element)v.get(91)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(104)).setAttribute("src","b.gif" );
      ((Element)v.get(104)).setAttribute("width","10" );
      ((Element)v.get(104)).setAttribute("height","8" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:105 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).setAttribute("width","70" );
      ((Element)v.get(105)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(105)).setAttribute("class","menu5texto" );
      ((Element)v.get(91)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("table"));
      ((Element)v.get(106)).setAttribute("width","75" );
      ((Element)v.get(106)).setAttribute("border","1" );
      ((Element)v.get(106)).setAttribute("align","center" );
      ((Element)v.get(106)).setAttribute("cellpadding","1" );
      ((Element)v.get(106)).setAttribute("cellspacing","0" );
      ((Element)v.get(106)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(106)).setAttribute("onmouseover","activarPuntero('formulario',9,'lblCalificacion');" );
      ((Element)v.get(106)).setAttribute("onclick","onClickPestanyaPaginaObtencionPuntos(9,'formulario','LPMantenerObtencionPuntos');" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(107)).setAttribute("align","center" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(109)).setAttribute("nombre","lblCalificacion" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(109)).setAttribute("alto","13" );
      ((Element)v.get(109)).setAttribute("filas","1" );
      ((Element)v.get(109)).setAttribute("valor","" );
      ((Element)v.get(109)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(109)).setAttribute("cod","00398" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */
      /* Termina nodo:107   */
      /* Termina nodo:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:110 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).setAttribute("width","10" );
      ((Element)v.get(110)).setAttribute("class","menu5texto" );
      ((Element)v.get(91)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(111)).setAttribute("src","b.gif" );
      ((Element)v.get(111)).setAttribute("width","10" );
      ((Element)v.get(111)).setAttribute("height","8" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:112 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).setAttribute("width","20" );
      ((Element)v.get(112)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(112)).setAttribute("class","menu5texto" );
      ((Element)v.get(91)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("table"));
      ((Element)v.get(113)).setAttribute("width","75" );
      ((Element)v.get(113)).setAttribute("border","1" );
      ((Element)v.get(113)).setAttribute("align","center" );
      ((Element)v.get(113)).setAttribute("cellpadding","1" );
      ((Element)v.get(113)).setAttribute("cellspacing","0" );
      ((Element)v.get(113)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(113)).setAttribute("onmouseover","activarPuntero('formulario',10,'lblGerentes');" );
      ((Element)v.get(113)).setAttribute("onclick","onClickPestanyaPaginaObtencionPuntos(10,'formulario','LPMantenerObtencionPuntos');" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(114)).setAttribute("align","center" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(116)).setAttribute("nombre","lblGerentes" );
      ((Element)v.get(116)).setAttribute("alto","13" );
      ((Element)v.get(116)).setAttribute("filas","1" );
      ((Element)v.get(116)).setAttribute("valor","" );
      ((Element)v.get(116)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(116)).setAttribute("cod","00399" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */
      /* Termina nodo:114   */
      /* Termina nodo:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:117 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(117)).setAttribute("width","10" );
      ((Element)v.get(117)).setAttribute("class","menu5texto" );
      ((Element)v.get(91)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(118)).setAttribute("src","b.gif" );
      ((Element)v.get(118)).setAttribute("width","10" );
      ((Element)v.get(118)).setAttribute("height","8" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:119 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).setAttribute("width","20" );
      ((Element)v.get(119)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(119)).setAttribute("class","menu5texto" );
      ((Element)v.get(91)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("table"));
      ((Element)v.get(120)).setAttribute("width","75" );
      ((Element)v.get(120)).setAttribute("border","1" );
      ((Element)v.get(120)).setAttribute("align","center" );
      ((Element)v.get(120)).setAttribute("cellpadding","1" );
      ((Element)v.get(120)).setAttribute("cellspacing","0" );
      ((Element)v.get(120)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(120)).setAttribute("onmouseover","activarPuntero('formulario',11,'lblConsultoras');" );
      ((Element)v.get(120)).setAttribute("onclick","onClickPestanyaPaginaObtencionPuntos(11,'formulario','LPMantenerObtencionPuntos');" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(121)).setAttribute("align","center" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(123)).setAttribute("nombre","lblConsultoras" );
      ((Element)v.get(123)).setAttribute("alto","13" );
      ((Element)v.get(123)).setAttribute("filas","1" );
      ((Element)v.get(123)).setAttribute("valor","" );
      ((Element)v.get(123)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(123)).setAttribute("cod","00401" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:122   */
      /* Termina nodo:121   */
      /* Termina nodo:120   */
      /* Termina nodo:119   */

      /* Empieza nodo:124 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).setAttribute("width","10" );
      ((Element)v.get(124)).setAttribute("class","menu5texto" );
      ((Element)v.get(91)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(125)).setAttribute("src","b.gif" );
      ((Element)v.get(125)).setAttribute("width","10" );
      ((Element)v.get(125)).setAttribute("height","8" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */

      /* Empieza nodo:126 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).setAttribute("width","20" );
      ((Element)v.get(126)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(126)).setAttribute("class","menu5texto" );
      ((Element)v.get(91)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("table"));
      ((Element)v.get(127)).setAttribute("width","75" );
      ((Element)v.get(127)).setAttribute("border","1" );
      ((Element)v.get(127)).setAttribute("align","center" );
      ((Element)v.get(127)).setAttribute("cellpadding","1" );
      ((Element)v.get(127)).setAttribute("cellspacing","0" );
      ((Element)v.get(127)).setAttribute("ID","DatosGenerales" );
      ((Element)v.get(127)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(127)).setAttribute("onmouseover","activarPuntero('formulario',2,'lblProgramaNuevas');" );
      ((Element)v.get(127)).setAttribute("onclick","onClickPestanyaPaginaObtencionPuntos(2,'formulario','LPMantenerObtencionPuntos');" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(128)).setAttribute("align","center" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(130)).setAttribute("nombre","lblProgramaNuevas" );
      ((Element)v.get(130)).setAttribute("alto","13" );
      ((Element)v.get(130)).setAttribute("filas","1" );
      ((Element)v.get(130)).setAttribute("valor","" );
      ((Element)v.get(130)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(130)).setAttribute("cod","00590" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */
      /* Termina nodo:128   */
      /* Termina nodo:127   */
      /* Termina nodo:126   */

      /* Empieza nodo:131 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(131)).setAttribute("width","10" );
      ((Element)v.get(131)).setAttribute("class","menu5texto" );
      ((Element)v.get(91)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(132)).setAttribute("src","b.gif" );
      ((Element)v.get(132)).setAttribute("width","10" );
      ((Element)v.get(132)).setAttribute("height","8" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */

      /* Empieza nodo:133 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).setAttribute("width","20" );
      ((Element)v.get(133)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(133)).setAttribute("class","menu5texto" );
      ((Element)v.get(91)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("table"));
      ((Element)v.get(134)).setAttribute("width","75" );
      ((Element)v.get(134)).setAttribute("border","1" );
      ((Element)v.get(134)).setAttribute("align","center" );
      ((Element)v.get(134)).setAttribute("cellpadding","1" );
      ((Element)v.get(134)).setAttribute("cellspacing","0" );
      ((Element)v.get(134)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(134)).setAttribute("onmouseover","activarPuntero('formulario',12,'lblMultinivel');" );
      ((Element)v.get(134)).setAttribute("onclick","onClickPestanyaPaginaObtencionPuntos(12,'formulario','LPMantenerObtencionPuntos');" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(135)).setAttribute("align","center" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(137)).setAttribute("nombre","lblMultinivel" );
      ((Element)v.get(137)).setAttribute("alto","13" );
      ((Element)v.get(137)).setAttribute("filas","1" );
      ((Element)v.get(137)).setAttribute("valor","" );
      ((Element)v.get(137)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(137)).setAttribute("cod","00400" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */
      /* Termina nodo:135   */
      /* Termina nodo:134   */
      /* Termina nodo:133   */

      /* Empieza nodo:138 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(138)).setAttribute("width","16" );
      ((Element)v.get(138)).setAttribute("class","menu5texto" );
      ((Element)v.get(91)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(139)).setAttribute("src","b.gif" );
      ((Element)v.get(139)).setAttribute("width","12" );
      ((Element)v.get(139)).setAttribute("height","8" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:138   */
      /* Termina nodo:91   */
      /* Termina nodo:90   */

      /* Empieza nodo:140 / Elemento padre: 13   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(140)).setAttribute("nombre","capa1" );
      ((Element)v.get(13)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("table"));
      ((Element)v.get(141)).setAttribute("width","100%" );
      ((Element)v.get(141)).setAttribute("border","0" );
      ((Element)v.get(141)).setAttribute("cellspacing","0" );
      ((Element)v.get(141)).setAttribute("cellpadding","0" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(141)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
   }

   private void getXML720(Document doc) {
      ((Element)v.get(143)).setAttribute("width","12" );
      ((Element)v.get(143)).setAttribute("align","center" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(144)).setAttribute("src","b.gif" );
      ((Element)v.get(144)).setAttribute("width","12" );
      ((Element)v.get(144)).setAttribute("height","12" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */

      /* Empieza nodo:145 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(145)).setAttribute("width","750" );
      ((Element)v.get(142)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(146)).setAttribute("src","b.gif" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */

      /* Empieza nodo:147 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).setAttribute("width","12" );
      ((Element)v.get(142)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(148)).setAttribute("src","b.gif" );
      ((Element)v.get(148)).setAttribute("width","12" );
      ((Element)v.get(148)).setAttribute("height","1" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */
      /* Termina nodo:142   */

      /* Empieza nodo:149 / Elemento padre: 141   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(141)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(151)).setAttribute("src","b.gif" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:152 / Elemento padre: 149   */
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(152)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(154)).setAttribute("class","legend" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(155)).setAttribute("nombre","lblDatosPrincipales" );
      ((Element)v.get(155)).setAttribute("alto","13" );
      ((Element)v.get(155)).setAttribute("filas","1" );
      ((Element)v.get(155)).setAttribute("valor","" );
      ((Element)v.get(155)).setAttribute("id","legend" );
      ((Element)v.get(155)).setAttribute("cod","00282" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */
      /* Termina nodo:154   */

      /* Empieza nodo:156 / Elemento padre: 153   */
      v.add(doc.createElement("table"));
      ((Element)v.get(156)).setAttribute("width","100%" );
      ((Element)v.get(156)).setAttribute("border","0" );
      ((Element)v.get(156)).setAttribute("align","center" );
      ((Element)v.get(156)).setAttribute("cellspacing","0" );
      ((Element)v.get(156)).setAttribute("cellpadding","0" );
      ((Element)v.get(153)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(156)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("td"));
      ((Element)v.get(157)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("table"));
      ((Element)v.get(159)).setAttribute("width","521" );
      ((Element)v.get(159)).setAttribute("border","0" );
      ((Element)v.get(159)).setAttribute("align","left" );
      ((Element)v.get(159)).setAttribute("cellspacing","0" );
      ((Element)v.get(159)).setAttribute("cellpadding","0" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(159)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("td"));
      ((Element)v.get(161)).setAttribute("colspan","3" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(162)).setAttribute("src","b.gif" );
      ((Element)v.get(162)).setAttribute("width","8" );
      ((Element)v.get(162)).setAttribute("height","8" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */
      /* Termina nodo:161   */
      /* Termina nodo:160   */

      /* Empieza nodo:163 / Elemento padre: 159   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(159)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(165)).setAttribute("src","b.gif" );
      ((Element)v.get(165)).setAttribute("width","8" );
      ((Element)v.get(165)).setAttribute("height","8" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:164   */

      /* Empieza nodo:166 / Elemento padre: 163   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(167)).setAttribute("nombre","lblFactorConversion" );
      ((Element)v.get(167)).setAttribute("alto","13" );
      ((Element)v.get(167)).setAttribute("filas","1" );
      ((Element)v.get(167)).setAttribute("valor","" );
      ((Element)v.get(167)).setAttribute("id","datosTitle" );
      ((Element)v.get(167)).setAttribute("cod","1893" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:166   */

      /* Empieza nodo:168 / Elemento padre: 163   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(169)).setAttribute("src","b.gif" );
      ((Element)v.get(169)).setAttribute("width","25" );
      ((Element)v.get(169)).setAttribute("height","8" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */
      /* Termina nodo:168   */

      /* Empieza nodo:170 / Elemento padre: 163   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(171)).setAttribute("nombre","lblPuntosAsignar" );
      ((Element)v.get(171)).setAttribute("alto","13" );
      ((Element)v.get(171)).setAttribute("filas","1" );
      ((Element)v.get(171)).setAttribute("valor","" );
      ((Element)v.get(171)).setAttribute("id","datosTitle" );
      ((Element)v.get(171)).setAttribute("cod","1894" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:170   */

      /* Empieza nodo:172 / Elemento padre: 163   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(173)).setAttribute("src","b.gif" );
      ((Element)v.get(173)).setAttribute("width","25" );
      ((Element)v.get(173)).setAttribute("height","8" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */
      /* Termina nodo:172   */

      /* Empieza nodo:174 / Elemento padre: 163   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(175)).setAttribute("nombre","lblComunicacionPuntosAsignar" );
      ((Element)v.get(175)).setAttribute("alto","13" );
      ((Element)v.get(175)).setAttribute("filas","1" );
      ((Element)v.get(175)).setAttribute("valor","" );
      ((Element)v.get(175)).setAttribute("id","datosTitle" );
      ((Element)v.get(175)).setAttribute("cod","1812" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:174   */

      /* Empieza nodo:176 / Elemento padre: 163   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(177)).setAttribute("src","b.gif" );
      ((Element)v.get(177)).setAttribute("width","25" );
      ((Element)v.get(177)).setAttribute("height","8" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */
      /* Termina nodo:176   */

      /* Empieza nodo:178 / Elemento padre: 163   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(179)).setAttribute("nombre","lblMensajesPuntosAsignar" );
      ((Element)v.get(179)).setAttribute("alto","13" );
      ((Element)v.get(179)).setAttribute("filas","1" );
      ((Element)v.get(179)).setAttribute("valor","" );
      ((Element)v.get(179)).setAttribute("id","datosTitle" );
      ((Element)v.get(179)).setAttribute("cod","531" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:178   */

      /* Empieza nodo:180 / Elemento padre: 163   */
      v.add(doc.createElement("td"));
      ((Element)v.get(180)).setAttribute("width","100%" );
      ((Element)v.get(163)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(181)).setAttribute("src","b.gif" );
      ((Element)v.get(181)).setAttribute("width","8" );
      ((Element)v.get(181)).setAttribute("height","8" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:180   */
      /* Termina nodo:163   */

      /* Empieza nodo:182 / Elemento padre: 159   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(159)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("td"));
      ((Element)v.get(182)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(184)).setAttribute("src","b.gif" );
      ((Element)v.get(184)).setAttribute("width","8" );
      ((Element)v.get(184)).setAttribute("height","8" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */

      /* Empieza nodo:185 / Elemento padre: 182   */
      v.add(doc.createElement("td"));
      ((Element)v.get(185)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(182)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(186)).setAttribute("nombre","txtFactorConversion" );
      ((Element)v.get(186)).setAttribute("id","datosCampos" );
      ((Element)v.get(186)).setAttribute("max","12" );
      ((Element)v.get(186)).setAttribute("tipo","" );
      ((Element)v.get(186)).setAttribute("onchange","" );
      ((Element)v.get(186)).setAttribute("req","S" );
      ((Element)v.get(186)).setAttribute("size","14" );
      ((Element)v.get(186)).setAttribute("valor","" );
      ((Element)v.get(186)).setAttribute("validacion","" );
      ((Element)v.get(186)).setAttribute("onshtab","focalizaShTab();" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:187 / Elemento padre: 182   */
      v.add(doc.createElement("td"));
      ((Element)v.get(182)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(188)).setAttribute("src","b.gif" );
      ((Element)v.get(188)).setAttribute("width","25" );
      ((Element)v.get(188)).setAttribute("height","8" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */

      /* Empieza nodo:189 / Elemento padre: 182   */
      v.add(doc.createElement("td"));
      ((Element)v.get(189)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(182)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(190)).setAttribute("nombre","txtPuntosAsignar" );
      ((Element)v.get(190)).setAttribute("id","datosCampos" );
      ((Element)v.get(190)).setAttribute("max","5" );
      ((Element)v.get(190)).setAttribute("tipo","" );
      ((Element)v.get(190)).setAttribute("onchange","" );
      ((Element)v.get(190)).setAttribute("req","S" );
      ((Element)v.get(190)).setAttribute("size","7" );
      ((Element)v.get(190)).setAttribute("valor","" );
      ((Element)v.get(190)).setAttribute("validacion","" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:189   */

      /* Empieza nodo:191 / Elemento padre: 182   */
      v.add(doc.createElement("td"));
      ((Element)v.get(182)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(192)).setAttribute("src","b.gif" );
      ((Element)v.get(192)).setAttribute("width","25" );
      ((Element)v.get(192)).setAttribute("height","8" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:191   */

      /* Empieza nodo:193 / Elemento padre: 182   */
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).setAttribute("valing","bottom" );
      ((Element)v.get(182)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(194)).setAttribute("nombre","ckComunicacionPuntosAsignar" );
      ((Element)v.get(194)).setAttribute("id","datosCampos" );
      ((Element)v.get(194)).setAttribute("onclick","onChangeComunicacion();" );
      ((Element)v.get(194)).setAttribute("check","" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */
      /* Termina nodo:193   */

      /* Empieza nodo:195 / Elemento padre: 182   */
      v.add(doc.createElement("td"));
      ((Element)v.get(182)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(196)).setAttribute("src","b.gif" );
      ((Element)v.get(196)).setAttribute("width","25" );
      ((Element)v.get(196)).setAttribute("height","8" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:195   */

      /* Empieza nodo:197 / Elemento padre: 182   */
      v.add(doc.createElement("td"));
      ((Element)v.get(197)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(197)).setAttribute("valing","bottom" );
      ((Element)v.get(182)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(198)).setAttribute("nombre","txtMensajesPuntosAsignar" );
      ((Element)v.get(198)).setAttribute("id","datosCampos" );
      ((Element)v.get(198)).setAttribute("max","5" );
      ((Element)v.get(198)).setAttribute("tipo","" );
      ((Element)v.get(198)).setAttribute("onchange","" );
      ((Element)v.get(198)).setAttribute("req","N" );
      ((Element)v.get(198)).setAttribute("size","5" );
      ((Element)v.get(198)).setAttribute("valor","" );
      ((Element)v.get(198)).setAttribute("validacion","" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:197   */

      /* Empieza nodo:199 / Elemento padre: 182   */
      v.add(doc.createElement("td"));
      ((Element)v.get(199)).setAttribute("width","100%" );
      ((Element)v.get(182)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(200)).setAttribute("src","b.gif" );
      ((Element)v.get(200)).setAttribute("width","8" );
      ((Element)v.get(200)).setAttribute("height","8" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:199   */
      /* Termina nodo:182   */

      /* Empieza nodo:201 / Elemento padre: 159   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(159)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("td"));
      ((Element)v.get(202)).setAttribute("colspan","3" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(203)).setAttribute("src","b.gif" );
      ((Element)v.get(203)).setAttribute("width","8" );
      ((Element)v.get(203)).setAttribute("height","8" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:202   */
      /* Termina nodo:201   */
      /* Termina nodo:159   */
      /* Termina nodo:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:204 / Elemento padre: 156   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(156)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("td"));
      ((Element)v.get(204)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("table"));
      ((Element)v.get(206)).setAttribute("width","521" );
      ((Element)v.get(206)).setAttribute("border","0" );
      ((Element)v.get(206)).setAttribute("align","left" );
      ((Element)v.get(206)).setAttribute("cellspacing","0" );
      ((Element)v.get(206)).setAttribute("cellpadding","0" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(206)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("td"));
      ((Element)v.get(207)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(209)).setAttribute("src","b.gif" );
      ((Element)v.get(209)).setAttribute("width","8" );
      ((Element)v.get(209)).setAttribute("height","8" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */

      /* Empieza nodo:210 / Elemento padre: 207   */
      v.add(doc.createElement("td"));
      ((Element)v.get(207)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(211)).setAttribute("nombre","lblPuntejeEsAcumulativo" );
      ((Element)v.get(211)).setAttribute("alto","13" );
      ((Element)v.get(211)).setAttribute("filas","1" );
      ((Element)v.get(211)).setAttribute("valor","" );
      ((Element)v.get(211)).setAttribute("id","datosTitle" );
      ((Element)v.get(211)).setAttribute("cod","1895" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */
      /* Termina nodo:210   */

      /* Empieza nodo:212 / Elemento padre: 207   */
      v.add(doc.createElement("td"));
      ((Element)v.get(212)).setAttribute("width","100%" );
      ((Element)v.get(207)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(213)).setAttribute("src","b.gif" );
      ((Element)v.get(213)).setAttribute("width","8" );
      ((Element)v.get(213)).setAttribute("height","8" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */
      /* Termina nodo:212   */
      /* Termina nodo:207   */

      /* Empieza nodo:214 / Elemento padre: 206   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(206)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("td"));
      ((Element)v.get(214)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(216)).setAttribute("src","b.gif" );
      ((Element)v.get(216)).setAttribute("width","8" );
      ((Element)v.get(216)).setAttribute("height","8" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */
      /* Termina nodo:215   */

      /* Empieza nodo:217 / Elemento padre: 214   */
      v.add(doc.createElement("td"));
      ((Element)v.get(214)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(218)).setAttribute("nombre","PuntejeEsAcumulativo" );
      ((Element)v.get(218)).setAttribute("id","datosCampos" );
      ((Element)v.get(218)).setAttribute("onclick","" );
      ((Element)v.get(218)).setAttribute("check","" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */
      /* Termina nodo:217   */

      /* Empieza nodo:219 / Elemento padre: 214   */
      v.add(doc.createElement("td"));
      ((Element)v.get(219)).setAttribute("width","100%" );
      ((Element)v.get(214)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(220)).setAttribute("src","b.gif" );
      ((Element)v.get(220)).setAttribute("width","8" );
      ((Element)v.get(220)).setAttribute("height","8" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */
      /* Termina nodo:219   */
      /* Termina nodo:214   */

      /* Empieza nodo:221 / Elemento padre: 206   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(206)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("td"));
      ((Element)v.get(222)).setAttribute("colspan","3" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(223)).setAttribute("src","b.gif" );
      ((Element)v.get(223)).setAttribute("width","8" );
      ((Element)v.get(223)).setAttribute("height","8" );
      ((Element)v.get(222)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */
      /* Termina nodo:222   */
      /* Termina nodo:221   */
      /* Termina nodo:206   */
      /* Termina nodo:205   */
      /* Termina nodo:204   */

      /* Empieza nodo:224 / Elemento padre: 156   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(156)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("td"));
      ((Element)v.get(224)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("table"));
      ((Element)v.get(226)).setAttribute("width","521" );
      ((Element)v.get(226)).setAttribute("border","0" );
      ((Element)v.get(226)).setAttribute("align","left" );
      ((Element)v.get(226)).setAttribute("cellspacing","0" );
      ((Element)v.get(226)).setAttribute("cellpadding","0" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(226)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("td"));
      ((Element)v.get(227)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(229)).setAttribute("src","b.gif" );
      ((Element)v.get(229)).setAttribute("width","8" );
      ((Element)v.get(229)).setAttribute("height","8" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */
      /* Termina nodo:228   */

      /* Empieza nodo:230 / Elemento padre: 227   */
      v.add(doc.createElement("td"));
      ((Element)v.get(227)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(231)).setAttribute("nombre","lblActividad" );
      ((Element)v.get(231)).setAttribute("alto","13" );
      ((Element)v.get(231)).setAttribute("filas","1" );
      ((Element)v.get(231)).setAttribute("valor","" );
      ((Element)v.get(231)).setAttribute("id","datosTitle" );
      ((Element)v.get(231)).setAttribute("cod","173" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */
      /* Termina nodo:230   */

      /* Empieza nodo:232 / Elemento padre: 227   */
      v.add(doc.createElement("td"));
      ((Element)v.get(227)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(233)).setAttribute("src","b.gif" );
      ((Element)v.get(233)).setAttribute("width","25" );
      ((Element)v.get(233)).setAttribute("height","8" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(232)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */
      /* Termina nodo:232   */

      /* Empieza nodo:234 / Elemento padre: 227   */
      v.add(doc.createElement("td"));
      ((Element)v.get(227)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(235)).setAttribute("nombre","lblConstancia" );
      ((Element)v.get(235)).setAttribute("alto","13" );
      ((Element)v.get(235)).setAttribute("filas","1" );
      ((Element)v.get(235)).setAttribute("valor","" );
      ((Element)v.get(235)).setAttribute("id","datosTitle" );
      ((Element)v.get(235)).setAttribute("cod","1797" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */
      /* Termina nodo:234   */

      /* Empieza nodo:236 / Elemento padre: 227   */
      v.add(doc.createElement("td"));
      ((Element)v.get(236)).setAttribute("width","100%" );
      ((Element)v.get(227)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(237)).setAttribute("src","b.gif" );
      ((Element)v.get(237)).setAttribute("width","8" );
      ((Element)v.get(237)).setAttribute("height","8" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */
      /* Termina nodo:236   */
      /* Termina nodo:227   */

      /* Empieza nodo:238 / Elemento padre: 226   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(226)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("td"));
      ((Element)v.get(238)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(240)).setAttribute("src","b.gif" );
      ((Element)v.get(240)).setAttribute("width","8" );
      ((Element)v.get(240)).setAttribute("height","8" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */
      /* Termina nodo:239   */

      /* Empieza nodo:241 / Elemento padre: 238   */
      v.add(doc.createElement("td"));
      ((Element)v.get(238)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(242)).setAttribute("nombre","ckActividad" );
      ((Element)v.get(242)).setAttribute("id","datosCampos" );
      ((Element)v.get(242)).setAttribute("onclick","onChangeActividad();" );
      ((Element)v.get(242)).setAttribute("check","" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */
      /* Termina nodo:241   */

      /* Empieza nodo:243 / Elemento padre: 238   */
      v.add(doc.createElement("td"));
      ((Element)v.get(238)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(244)).setAttribute("src","b.gif" );
      ((Element)v.get(244)).setAttribute("width","25" );
      ((Element)v.get(244)).setAttribute("height","8" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */
      /* Termina nodo:243   */

      /* Empieza nodo:245 / Elemento padre: 238   */
      v.add(doc.createElement("td"));
      ((Element)v.get(238)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(246)).setAttribute("nombre","ckConstancia" );
      ((Element)v.get(246)).setAttribute("id","datosCampos" );
      ((Element)v.get(246)).setAttribute("onclick","onChangeConstancia();" );
      ((Element)v.get(246)).setAttribute("check","" );
      ((Element)v.get(246)).setAttribute("ontab","focalizaTab();" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */
      /* Termina nodo:245   */

      /* Empieza nodo:247 / Elemento padre: 238   */
      v.add(doc.createElement("td"));
      ((Element)v.get(247)).setAttribute("width","100%" );
      ((Element)v.get(238)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(248)).setAttribute("src","b.gif" );
      ((Element)v.get(248)).setAttribute("width","8" );
      ((Element)v.get(248)).setAttribute("height","8" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */
      /* Termina nodo:247   */
      /* Termina nodo:238   */

      /* Empieza nodo:249 / Elemento padre: 226   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(226)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("td"));
      ((Element)v.get(250)).setAttribute("colspan","3" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(251)).setAttribute("src","b.gif" );
      ((Element)v.get(251)).setAttribute("width","8" );
      ((Element)v.get(251)).setAttribute("height","8" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */
      /* Termina nodo:250   */
      /* Termina nodo:249   */
      /* Termina nodo:226   */
      /* Termina nodo:225   */
      /* Termina nodo:224   */
      /* Termina nodo:156   */
      /* Termina nodo:153   */
      /* Termina nodo:152   */

      /* Empieza nodo:252 / Elemento padre: 149   */
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(253)).setAttribute("src","b.gif" );
      ((Element)v.get(252)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */
      /* Termina nodo:252   */
      /* Termina nodo:149   */

      /* Empieza nodo:254 / Elemento padre: 141   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(141)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("td"));
      ((Element)v.get(255)).setAttribute("width","12" );
      ((Element)v.get(255)).setAttribute("align","center" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(256)).setAttribute("src","b.gif" );
      ((Element)v.get(256)).setAttribute("width","12" );
      ((Element)v.get(256)).setAttribute("height","12" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */
      /* Termina nodo:255   */

      /* Empieza nodo:257 / Elemento padre: 254   */
      v.add(doc.createElement("td"));
      ((Element)v.get(257)).setAttribute("width","756" );
      ((Element)v.get(254)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(258)).setAttribute("src","b.gif" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */
      /* Termina nodo:257   */

      /* Empieza nodo:259 / Elemento padre: 254   */
      v.add(doc.createElement("td"));
      ((Element)v.get(259)).setAttribute("width","12" );
      ((Element)v.get(254)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(260)).setAttribute("src","b.gif" );
      ((Element)v.get(260)).setAttribute("width","12" );
      ((Element)v.get(260)).setAttribute("height","1" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */
      /* Termina nodo:259   */
      /* Termina nodo:254   */
      /* Termina nodo:141   */
      /* Termina nodo:140   */
      /* Termina nodo:13   */


   }

}
