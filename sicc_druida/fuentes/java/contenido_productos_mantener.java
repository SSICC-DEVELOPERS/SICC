
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_productos_mantener  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_productos_mantener" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("titulo","Crear concurso" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","init();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(2)).setAttribute("src","pestanyas_concurso_inc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(3));

      /* Elemento padre:3 / Elemento actual: 4   */
      v.add(doc.createTextNode("\r \r\rfunction init() {	\r	configurarMenuSecundario(\"formulario\");  \r	btnProxy(2, 0);\r  \r/*	var valor = get(\"formulario.valorMenu\");\r	if (valor ==\"no\"){\r		btnProxy(1, 0);\r	}*/\r\r    focoComboProductos();\r	finCargaPagina = true;\r  \r   var menu = get(\"formulario.opcionMenu\");   \r  if(menu ==\"Consultar Concurso\"){\r            btnProxy(1, 0);\r    btnProxy(2, 1);\r    btnProxy(3, 0);\r    btnProxy(5, 0);\r    btnProxy(7, 0);\r    btnProxy(8, 0);\r    btnProxy(9, 0);    \r  }\r  else if(menu ==\"Modificar Concurso\") {\r	btnProxy(2,'1');\r	btnProxy(3,'0');\r	btnProxy(7,'0');\r	btnProxy(8,'0');\r	btnProxy(9,'0');\r  }\r\r  if (menu == 'nueva version') {\r            btnProxy(2, 1);\r      btnProxy(3, 0);\r  }\r\r		if (get('formulario.ocultarPestanyas') == 'S'){\r		document.getElementById('tblPestanyas1').style.display='none';\r		document.getElementById('tblPestanyas2').style.display='none';\r	}\r\r}\r\rfunction focoComboProductos() {\r	focaliza(\"formulario.cbProductos\");\r}\r\rfunction fVolver() {\r   if (get(\"formulario.opcionMenu\") == 'nueva version') {\r      window.close();\r	  return;\r   }\r\r   if (get(\"formulario.opcionMenu\") == 'Consultar Concurso') {\r      window.close();\r	  return;\r   }\r}\r\r\r\rfunction accionAceptar() {\r		var seleccionCombo = get(\"formulario.cbProductos\");\r\r		if ( sicc_validaciones_generales(\"combo\") )	{\r						var descCombo = get(\"formulario.cbProductos\", \"T\"); \r			var entroAModal = get(\"formulario.yaEntroAModal\");\r\r			var params = new Object();\r			params.oidCombo = seleccionCombo;\r			params.descCombo = descCombo;\r			params.yaEntroAModal = entroAModal;\r			params.accion = get(\"formulario.accion\");\r			params.opcionMenu = get(\"formulario.opcionMenu\");\r\r			this.mostrarModalSICC('LPMantenerProductos', 'mantener', params);\r\r												set(\"formulario.yaEntroAModal\", \"SI\");\r		}\r}\r\rfunction onClickPestanyaHabilitadaSS(valor, form){\r                \r  nombreLP = \"LPMantenerProductos\";\r  \r  switch(valor){\r  \r    case 2:\r      if(get(form + '.hIndEstadoProgramaNuevas')=='S'){\r        onClickPestanyaSS(valor, form, nombreLP);\r      }\r      break;\r    case 3:\r      if(get(form + '.hIndEstadoAmbitoGeografico')=='S'){\r        onClickPestanyaSS(valor, form, nombreLP);\r      }\r      break;\r    case 9:\r      if(get(form + '.hIndEstadoCalificion')=='S'){\r        onClickPestanyaSS(valor, form, nombreLP);\r      }\r      break;\r    case 10:\r      if(get(form + '.hIndEstadoGerentes')=='S'){\r        onClickPestanyaSS(valor, form, nombreLP);\r      }\r      break;\r    case 11:\r      if(get(form + '.hIndEstadoConsultoras')=='S'){\r        onClickPestanyaSS(valor, form, nombreLP);\r      }\r      break;\r    case 12:\r      if(get(form + '.hIndEstadoMultinivel')=='S'){\r        onClickPestanyaSS(valor, form, nombreLP);\r      }\r      break;\r    default:\r            onClickPestanyaSS(valor, form, nombreLP);\r  }\r}\r\rfunction onClickPestanyaSS(valor, form, nombreLP) {\r		var oMenu = get(form + '.opcionMenu');\r\r    set(form + '.accion', 'redirigir');\r/*    if( oMenu.toLowerCase() != 'consultar concurso' ){\r      set(form + '.conectorAction', nombreLP);\r            set(form + '.idPestanyaDest', valor);\r          }else{*/\r     set(form + '.conectorAction', nombreLP);\r     set(form + '.accion', 'redirigir');\r     set(form + '.idPestanyaDest', valor);\r    \r    enviaSICC(form, null, null, 'N');\r\r}\r    \r    	/* 11.	Se modifica PGMantenerProductos.accionGuardar() : void\r	\r	********************AGREGADO********************\r	Si opcionMenu == \"nueva version\" {\r		   Cerrar la ventana y volver a la pantalla PGGenerarNuevaVersion\r	}else {\r	***************************************************\r		formulario.oculto = \"S\"\r	enviaSICC(formulario)\r\r	Llamar a la LPMantenerProductos con:\r	   accion = \"guardar\"\r	*********************AGREGADO******************\r	}\r	*************************************************/\r\rfunction fGuardar() {\r    \r	if (get(\"formulario.opcionMenu\") == 'nueva version') {\r        window.close();\r	    return;    \r    } else {\r		\r		if (get(\"formulario.accion\") == 'cargarProductosGrupo1') {\r			window.close();\r			return;    \r		} else {\r		    \r			eval(\"formulario\").oculto = \"S\";\r			set(\"formulario.accion\", \"guardar\");\r			set(\"formulario.conectorAction\", \"LPMantenerProductos\");\r		  \r						enviaSICC(\"formulario\", \"\", \"\", \"N\");\r		}\r	}\r}\r\r\r \r"));
      ((Element)v.get(3)).appendChild((Text)v.get(4));

      /* Termina nodo Texto:4   */
      /* Termina nodo:3   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(6)).setAttribute("name","cbProductos" );
      ((Element)v.get(6)).setAttribute("group","combo" );
      ((Element)v.get(6)).setAttribute("required","true" );
      ((Element)v.get(6)).setAttribute("cod","515" );
      ((Element)v.get(5)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */
      /* Termina nodo:5   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(7)).setAttribute("nombre","formulario" );
      ((Element)v.get(7)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","accion" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","yaEntroAModal" );
      ((Element)v.get(12)).setAttribute("valor","NO" );
      ((Element)v.get(7)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","valorMenu" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","hIndEstadoProductos" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hIndEstadoAmbitoGeografico" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","hIndEstadoCalificion" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","hIndEstadoGerentes" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hIndEstadoConsultoras" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hIndEstadoProgramaNuevas" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hIndEstadoMultinivel" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","idPestanyaDest" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","ocultarPestanyas" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 7   */
      v.add(doc.createElement("table"));
      ((Element)v.get(24)).setAttribute("width","100%" );
      ((Element)v.get(24)).setAttribute("height","100%" );
      ((Element)v.get(24)).setAttribute("border","0" );
      ((Element)v.get(24)).setAttribute("align","center" );
      ((Element)v.get(24)).setAttribute("cellpadding","0" );
      ((Element)v.get(24)).setAttribute("cellspacing","0" );
      ((Element)v.get(24)).setAttribute("class","menu4" );
      ((Element)v.get(24)).setAttribute("id","tblPestanyas1" );
      ((Element)v.get(7)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(24)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).setAttribute("width","12" );
      ((Element)v.get(26)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(26)).setAttribute("class","menu5texto" );
      ((Element)v.get(25)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(27)).setAttribute("src","b.gif" );
      ((Element)v.get(27)).setAttribute("width","12" );
      ((Element)v.get(27)).setAttribute("height","30" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */
      /* Termina nodo:26   */

      /* Empieza nodo:28 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(28)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(28)).setAttribute("class","menu5texto" );
      ((Element)v.get(25)).appendChild((Element)v.get(28));

      /* Elemento padre:28 / Elemento actual: 29   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(28)).appendChild((Text)v.get(29));

      /* Termina nodo Texto:29   */
      /* Termina nodo:28   */

      /* Empieza nodo:30 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(30)).setAttribute("width","10" );
      ((Element)v.get(30)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(30)).setAttribute("class","menu5texto" );
      ((Element)v.get(25)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(31)).setAttribute("src","b.gif" );
      ((Element)v.get(31)).setAttribute("width","10" );
      ((Element)v.get(31)).setAttribute("height","8" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */
      /* Termina nodo:30   */

      /* Empieza nodo:32 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(32)).setAttribute("width","92" );
      ((Element)v.get(32)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(32)).setAttribute("class","menu5texto" );
      ((Element)v.get(25)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("table"));
      ((Element)v.get(33)).setAttribute("width","75" );
      ((Element)v.get(33)).setAttribute("border","1" );
      ((Element)v.get(33)).setAttribute("align","center" );
      ((Element)v.get(33)).setAttribute("cellpadding","1" );
      ((Element)v.get(33)).setAttribute("cellspacing","0" );
      ((Element)v.get(33)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(33)).setAttribute("onmouseover","activarPuntero('formulario',1,'lblParametrosGenerales');" );
      ((Element)v.get(33)).setAttribute("onclick","onClickPestanyaHabilitadaSS(1,'formulario');" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(34)).setAttribute("align","center" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("td"));
      ((Element)v.get(35)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(36)).setAttribute("nombre","lblParametrosGenerales" );
      ((Element)v.get(36)).setAttribute("alto","13" );
      ((Element)v.get(36)).setAttribute("filas","1" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(36)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(36)).setAttribute("cod","00393" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */
      /* Termina nodo:35   */
      /* Termina nodo:34   */
      /* Termina nodo:33   */
      /* Termina nodo:32   */

      /* Empieza nodo:37 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).setAttribute("width","10" );
      ((Element)v.get(37)).setAttribute("class","menu5texto" );
      ((Element)v.get(25)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(38)).setAttribute("src","b.gif" );
      ((Element)v.get(38)).setAttribute("width","10" );
      ((Element)v.get(38)).setAttribute("height","8" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */
      /* Termina nodo:37   */

      /* Empieza nodo:39 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).setAttribute("width","20" );
      ((Element)v.get(39)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(39)).setAttribute("class","menu5texto" );
      ((Element)v.get(25)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("table"));
      ((Element)v.get(40)).setAttribute("width","75" );
      ((Element)v.get(40)).setAttribute("border","1" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(40)).setAttribute("align","center" );
      ((Element)v.get(40)).setAttribute("cellpadding","1" );
      ((Element)v.get(40)).setAttribute("cellspacing","0" );
      ((Element)v.get(40)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(40)).setAttribute("bgcolor","#496A9A" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(41)).setAttribute("align","center" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(43)).setAttribute("nombre","lblProductos" );
      ((Element)v.get(43)).setAttribute("alto","13" );
      ((Element)v.get(43)).setAttribute("filas","1" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(43)).setAttribute("id","menu5textoblanca" );
      ((Element)v.get(43)).setAttribute("cod","0094" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */
      /* Termina nodo:41   */
      /* Termina nodo:40   */
      /* Termina nodo:39   */

      /* Empieza nodo:44 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).setAttribute("width","10" );
      ((Element)v.get(44)).setAttribute("class","menu5texto" );
      ((Element)v.get(25)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(45)).setAttribute("src","b.gif" );
      ((Element)v.get(45)).setAttribute("width","10" );
      ((Element)v.get(45)).setAttribute("height","8" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:46 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).setAttribute("width","20" );
      ((Element)v.get(46)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(46)).setAttribute("class","menu5texto" );
      ((Element)v.get(25)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("table"));
      ((Element)v.get(47)).setAttribute("width","75" );
      ((Element)v.get(47)).setAttribute("border","1" );
      ((Element)v.get(47)).setAttribute("align","center" );
      ((Element)v.get(47)).setAttribute("cellpadding","1" );
      ((Element)v.get(47)).setAttribute("cellspacing","0" );
      ((Element)v.get(47)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(47)).setAttribute("onmouseover","activarPuntero('formulario',6,'lblPremios');" );
      ((Element)v.get(47)).setAttribute("onclick","onClickPestanyaHabilitadaSS(6,'formulario');" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(48)).setAttribute("align","center" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(49)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(50)).setAttribute("nombre","lblPremios" );
      ((Element)v.get(50)).setAttribute("alto","13" );
      ((Element)v.get(50)).setAttribute("filas","1" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(50)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(50)).setAttribute("cod","00394" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:49   */
      /* Termina nodo:48   */
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:51 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(51)).setAttribute("width","10" );
      ((Element)v.get(51)).setAttribute("class","menu5texto" );
      ((Element)v.get(25)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(52)).setAttribute("src","b.gif" );
      ((Element)v.get(52)).setAttribute("width","10" );
      ((Element)v.get(52)).setAttribute("height","8" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:53 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).setAttribute("width","20" );
      ((Element)v.get(53)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(53)).setAttribute("class","menu5texto" );
      ((Element)v.get(25)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("table"));
      ((Element)v.get(54)).setAttribute("width","75" );
      ((Element)v.get(54)).setAttribute("border","1" );
      ((Element)v.get(54)).setAttribute("align","center" );
      ((Element)v.get(54)).setAttribute("cellpadding","1" );
      ((Element)v.get(54)).setAttribute("cellspacing","0" );
      ((Element)v.get(54)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(54)).setAttribute("onmouseover","activarPuntero('formulario',7,'lblRequisitos');" );
      ((Element)v.get(54)).setAttribute("onclick","onClickPestanyaHabilitadaSS(7,'formulario');" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(55)).setAttribute("align","center" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(57)).setAttribute("nombre","lblRequisitos" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(57)).setAttribute("alto","13" );
      ((Element)v.get(57)).setAttribute("filas","1" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(57)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(57)).setAttribute("cod","00395" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */
      /* Termina nodo:55   */
      /* Termina nodo:54   */
      /* Termina nodo:53   */

      /* Empieza nodo:58 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).setAttribute("width","10" );
      ((Element)v.get(58)).setAttribute("class","menu5texto" );
      ((Element)v.get(25)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(59)).setAttribute("src","b.gif" );
      ((Element)v.get(59)).setAttribute("width","10" );
      ((Element)v.get(59)).setAttribute("height","8" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:60 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).setAttribute("width","20" );
      ((Element)v.get(60)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(60)).setAttribute("class","menu5texto" );
      ((Element)v.get(25)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("table"));
      ((Element)v.get(61)).setAttribute("width","75" );
      ((Element)v.get(61)).setAttribute("border","1" );
      ((Element)v.get(61)).setAttribute("align","center" );
      ((Element)v.get(61)).setAttribute("cellpadding","1" );
      ((Element)v.get(61)).setAttribute("cellspacing","0" );
      ((Element)v.get(61)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(61)).setAttribute("onmouseover","activarPuntero('formulario',4,'lblObtencionPuntos');" );
      ((Element)v.get(61)).setAttribute("onclick","onClickPestanyaHabilitadaSS(4,'formulario');" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(62)).setAttribute("align","center" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(64)).setAttribute("nombre","lblObtencionPuntos" );
      ((Element)v.get(64)).setAttribute("alto","13" );
      ((Element)v.get(64)).setAttribute("filas","1" );
      ((Element)v.get(64)).setAttribute("valor","" );
      ((Element)v.get(64)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(64)).setAttribute("cod","00396" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */
      /* Termina nodo:62   */
      /* Termina nodo:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:65 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).setAttribute("width","10" );
      ((Element)v.get(65)).setAttribute("class","menu5texto" );
      ((Element)v.get(25)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(66)).setAttribute("src","b.gif" );
      ((Element)v.get(66)).setAttribute("width","10" );
      ((Element)v.get(66)).setAttribute("height","8" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:67 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(67)).setAttribute("width","20" );
      ((Element)v.get(67)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(67)).setAttribute("class","menu5texto" );
      ((Element)v.get(25)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("table"));
      ((Element)v.get(68)).setAttribute("width","75" );
      ((Element)v.get(68)).setAttribute("border","1" );
      ((Element)v.get(68)).setAttribute("align","center" );
      ((Element)v.get(68)).setAttribute("cellpadding","1" );
      ((Element)v.get(68)).setAttribute("cellspacing","0" );
      ((Element)v.get(68)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(68)).setAttribute("onmouseover","activarPuntero('formulario',8,'lblDespachoPremios');" );
      ((Element)v.get(68)).setAttribute("onclick","onClickPestanyaHabilitadaSS(8,'formulario');" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(69)).setAttribute("align","center" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(71)).setAttribute("nombre","lblDespachoPremios" );
      ((Element)v.get(71)).setAttribute("alto","13" );
      ((Element)v.get(71)).setAttribute("filas","1" );
      ((Element)v.get(71)).setAttribute("valor","" );
      ((Element)v.get(71)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(71)).setAttribute("cod","00397" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:72 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).setAttribute("width","16" );
      ((Element)v.get(72)).setAttribute("class","menu5texto" );
      ((Element)v.get(25)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(73)).setAttribute("src","b.gif" );
      ((Element)v.get(73)).setAttribute("width","12" );
      ((Element)v.get(73)).setAttribute("height","8" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */
      /* Termina nodo:25   */
      /* Termina nodo:24   */

      /* Empieza nodo:74 / Elemento padre: 7   */
      v.add(doc.createElement("table"));
      ((Element)v.get(74)).setAttribute("width","100%" );
      ((Element)v.get(74)).setAttribute("height","100%" );
      ((Element)v.get(74)).setAttribute("border","0" );
      ((Element)v.get(74)).setAttribute("align","center" );
      ((Element)v.get(74)).setAttribute("cellpadding","0" );
      ((Element)v.get(74)).setAttribute("cellspacing","0" );
      ((Element)v.get(74)).setAttribute("class","menu4" );
      ((Element)v.get(74)).setAttribute("id","tblPestanyas2" );
      ((Element)v.get(7)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("td"));
      ((Element)v.get(76)).setAttribute("width","12" );
      ((Element)v.get(76)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(76)).setAttribute("class","menu5texto" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(77)).setAttribute("src","b.gif" );
      ((Element)v.get(77)).setAttribute("width","12" );
      ((Element)v.get(77)).setAttribute("height","30" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:78 / Elemento padre: 75   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(78)).setAttribute("class","menu5texto" );
      ((Element)v.get(75)).appendChild((Element)v.get(78));

      /* Elemento padre:78 / Elemento actual: 79   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(78)).appendChild((Text)v.get(79));

      /* Termina nodo Texto:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:80 / Elemento padre: 75   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).setAttribute("width","10" );
      ((Element)v.get(80)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(80)).setAttribute("class","menu5texto" );
      ((Element)v.get(75)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(81)).setAttribute("src","b.gif" );
      ((Element)v.get(81)).setAttribute("width","10" );
      ((Element)v.get(81)).setAttribute("height","8" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:82 / Elemento padre: 75   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).setAttribute("width","70" );
      ((Element)v.get(82)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(82)).setAttribute("class","menu5texto" );
      ((Element)v.get(75)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("table"));
      ((Element)v.get(83)).setAttribute("width","75" );
      ((Element)v.get(83)).setAttribute("border","1" );
      ((Element)v.get(83)).setAttribute("align","center" );
      ((Element)v.get(83)).setAttribute("cellpadding","1" );
      ((Element)v.get(83)).setAttribute("cellspacing","0" );
      ((Element)v.get(83)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(83)).setAttribute("onmouseover","activarPuntero('formulario', 3, 'lblAmbitoGeografico');" );
      ((Element)v.get(83)).setAttribute("onclick","onClickPestanyaHabilitadaSS(3, 'formulario');" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(84)).setAttribute("align","center" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(86)).setAttribute("nombre","lblAmbitoGeografico" );
      ((Element)v.get(86)).setAttribute("alto","13" );
      ((Element)v.get(86)).setAttribute("filas","1" );
      ((Element)v.get(86)).setAttribute("valor","" );
      ((Element)v.get(86)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(86)).setAttribute("cod","2801" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */
      /* Termina nodo:84   */
      /* Termina nodo:83   */
      /* Termina nodo:82   */

      /* Empieza nodo:87 / Elemento padre: 75   */
      v.add(doc.createElement("td"));
      ((Element)v.get(87)).setAttribute("width","10" );
      ((Element)v.get(87)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(87)).setAttribute("class","menu5texto" );
      ((Element)v.get(75)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(88)).setAttribute("src","b.gif" );
      ((Element)v.get(88)).setAttribute("width","10" );
      ((Element)v.get(88)).setAttribute("height","8" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:89 / Elemento padre: 75   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).setAttribute("width","70" );
      ((Element)v.get(89)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(89)).setAttribute("class","menu5texto" );
      ((Element)v.get(75)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("table"));
      ((Element)v.get(90)).setAttribute("width","75" );
      ((Element)v.get(90)).setAttribute("border","1" );
      ((Element)v.get(90)).setAttribute("align","center" );
      ((Element)v.get(90)).setAttribute("cellpadding","1" );
      ((Element)v.get(90)).setAttribute("cellspacing","0" );
      ((Element)v.get(90)).setAttribute("bordercolor","#496A9A" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(90)).setAttribute("onmouseover","activarPuntero('formulario',9,'lblCalificacion');" );
      ((Element)v.get(90)).setAttribute("onclick","onClickPestanyaHabilitadaSS(9,'formulario');" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(91)).setAttribute("align","center" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(92)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(93)).setAttribute("nombre","lblCalificacion" );
      ((Element)v.get(93)).setAttribute("alto","13" );
      ((Element)v.get(93)).setAttribute("filas","1" );
      ((Element)v.get(93)).setAttribute("valor","" );
      ((Element)v.get(93)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(93)).setAttribute("cod","00398" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */
      /* Termina nodo:91   */
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:94 / Elemento padre: 75   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).setAttribute("width","10" );
      ((Element)v.get(94)).setAttribute("class","menu5texto" );
      ((Element)v.get(75)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(95)).setAttribute("src","b.gif" );
      ((Element)v.get(95)).setAttribute("width","10" );
      ((Element)v.get(95)).setAttribute("height","8" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:96 / Elemento padre: 75   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).setAttribute("width","20" );
      ((Element)v.get(96)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(96)).setAttribute("class","menu5texto" );
      ((Element)v.get(75)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("table"));
      ((Element)v.get(97)).setAttribute("width","75" );
      ((Element)v.get(97)).setAttribute("border","1" );
      ((Element)v.get(97)).setAttribute("align","center" );
      ((Element)v.get(97)).setAttribute("cellpadding","1" );
      ((Element)v.get(97)).setAttribute("cellspacing","0" );
      ((Element)v.get(97)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(97)).setAttribute("onmouseover","activarPuntero('formulario',10,'lblGerentes');" );
      ((Element)v.get(97)).setAttribute("onclick","onClickPestanyaHabilitadaSS(10,'formulario');" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(98)).setAttribute("align","center" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(100)).setAttribute("nombre","lblGerentes" );
      ((Element)v.get(100)).setAttribute("alto","13" );
      ((Element)v.get(100)).setAttribute("filas","1" );
      ((Element)v.get(100)).setAttribute("valor","" );
      ((Element)v.get(100)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(100)).setAttribute("cod","00399" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */
      /* Termina nodo:98   */
      /* Termina nodo:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:101 / Elemento padre: 75   */
      v.add(doc.createElement("td"));
      ((Element)v.get(101)).setAttribute("width","10" );
      ((Element)v.get(101)).setAttribute("class","menu5texto" );
      ((Element)v.get(75)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(102)).setAttribute("src","b.gif" );
      ((Element)v.get(102)).setAttribute("width","10" );
      ((Element)v.get(102)).setAttribute("height","8" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:103 / Elemento padre: 75   */
      v.add(doc.createElement("td"));
      ((Element)v.get(103)).setAttribute("width","20" );
      ((Element)v.get(103)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(103)).setAttribute("class","menu5texto" );
      ((Element)v.get(75)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("table"));
      ((Element)v.get(104)).setAttribute("width","75" );
      ((Element)v.get(104)).setAttribute("border","1" );
      ((Element)v.get(104)).setAttribute("align","center" );
      ((Element)v.get(104)).setAttribute("cellpadding","1" );
      ((Element)v.get(104)).setAttribute("cellspacing","0" );
      ((Element)v.get(104)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(104)).setAttribute("onmouseover","activarPuntero('formulario',11,'lblConsultoras');" );
      ((Element)v.get(104)).setAttribute("onclick","onClickPestanyaHabilitadaSS(11,'formulario');" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(105)).setAttribute("align","center" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(106)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(107)).setAttribute("nombre","lblConsultoras" );
      ((Element)v.get(107)).setAttribute("alto","13" );
      ((Element)v.get(107)).setAttribute("filas","1" );
      ((Element)v.get(107)).setAttribute("valor","" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(107)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(107)).setAttribute("cod","00401" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */
      /* Termina nodo:105   */
      /* Termina nodo:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:108 / Elemento padre: 75   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).setAttribute("width","10" );
      ((Element)v.get(108)).setAttribute("class","menu5texto" );
      ((Element)v.get(75)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(109)).setAttribute("src","b.gif" );
      ((Element)v.get(109)).setAttribute("width","10" );
      ((Element)v.get(109)).setAttribute("height","8" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */

      /* Empieza nodo:110 / Elemento padre: 75   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).setAttribute("width","20" );
      ((Element)v.get(110)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(110)).setAttribute("class","menu5texto" );
      ((Element)v.get(75)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("table"));
      ((Element)v.get(111)).setAttribute("width","75" );
      ((Element)v.get(111)).setAttribute("border","1" );
      ((Element)v.get(111)).setAttribute("align","center" );
      ((Element)v.get(111)).setAttribute("cellpadding","1" );
      ((Element)v.get(111)).setAttribute("cellspacing","0" );
      ((Element)v.get(111)).setAttribute("ID","DatosGenerales" );
      ((Element)v.get(111)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(111)).setAttribute("onmouseover","activarPuntero('formulario',2,'lblProgramaNuevas');" );
      ((Element)v.get(111)).setAttribute("onclick","onClickPestanyaHabilitadaSS(2,'formulario');" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(112)).setAttribute("align","center" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(114)).setAttribute("nombre","lblProgramaNuevas" );
      ((Element)v.get(114)).setAttribute("alto","13" );
      ((Element)v.get(114)).setAttribute("filas","1" );
      ((Element)v.get(114)).setAttribute("valor","" );
      ((Element)v.get(114)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(114)).setAttribute("cod","00590" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */
      /* Termina nodo:112   */
      /* Termina nodo:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:115 / Elemento padre: 75   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).setAttribute("width","10" );
      ((Element)v.get(115)).setAttribute("class","menu5texto" );
      ((Element)v.get(75)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(116)).setAttribute("src","b.gif" );
      ((Element)v.get(116)).setAttribute("width","10" );
      ((Element)v.get(116)).setAttribute("height","8" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:117 / Elemento padre: 75   */
      v.add(doc.createElement("td"));
      ((Element)v.get(117)).setAttribute("width","20" );
      ((Element)v.get(117)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(117)).setAttribute("class","menu5texto" );
      ((Element)v.get(75)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("table"));
      ((Element)v.get(118)).setAttribute("width","75" );
      ((Element)v.get(118)).setAttribute("border","1" );
      ((Element)v.get(118)).setAttribute("align","center" );
      ((Element)v.get(118)).setAttribute("cellpadding","1" );
      ((Element)v.get(118)).setAttribute("cellspacing","0" );
      ((Element)v.get(118)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(118)).setAttribute("onmouseover","activarPuntero('formulario',12,'lblMultinivel');" );
      ((Element)v.get(118)).setAttribute("onclick","onClickPestanyaHabilitadaSS(12,'formulario');" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(119)).setAttribute("align","center" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(120)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(121)).setAttribute("nombre","lblMultinivel" );
      ((Element)v.get(121)).setAttribute("alto","13" );
      ((Element)v.get(121)).setAttribute("filas","1" );
      ((Element)v.get(121)).setAttribute("valor","" );
      ((Element)v.get(121)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(121)).setAttribute("cod","00400" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:122 / Elemento padre: 75   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).setAttribute("width","16" );
      ((Element)v.get(122)).setAttribute("class","menu5texto" );
      ((Element)v.get(75)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(123)).setAttribute("src","b.gif" );
      ((Element)v.get(123)).setAttribute("width","12" );
      ((Element)v.get(123)).setAttribute("height","8" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:122   */
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:124 / Elemento padre: 7   */
      v.add(doc.createElement("CAPA"));
   }

   private void getXML630(Document doc) {
      ((Element)v.get(124)).setAttribute("nombre","capa1" );
      ((Element)v.get(7)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("table"));
      ((Element)v.get(125)).setAttribute("width","100%" );
      ((Element)v.get(125)).setAttribute("border","0" );
      ((Element)v.get(125)).setAttribute("cellspacing","0" );
      ((Element)v.get(125)).setAttribute("cellpadding","0" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).setAttribute("width","12" );
      ((Element)v.get(127)).setAttribute("align","center" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(128)).setAttribute("src","b.gif" );
      ((Element)v.get(128)).setAttribute("width","12" );
      ((Element)v.get(128)).setAttribute("height","12" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:129 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).setAttribute("width","750" );
      ((Element)v.get(126)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(130)).setAttribute("src","b.gif" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:131 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(131)).setAttribute("width","12" );
      ((Element)v.get(126)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(132)).setAttribute("src","b.gif" );
      ((Element)v.get(132)).setAttribute("width","12" );
      ((Element)v.get(132)).setAttribute("height","1" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */
      /* Termina nodo:126   */

      /* Empieza nodo:133 / Elemento padre: 125   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(125)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(135)).setAttribute("src","b.gif" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:136 / Elemento padre: 133   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(136)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(138)).setAttribute("class","legend" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(139)).setAttribute("nombre","lblMantenerProductos" );
      ((Element)v.get(139)).setAttribute("alto","13" );
      ((Element)v.get(139)).setAttribute("filas","1" );
      ((Element)v.get(139)).setAttribute("valor","" );
      ((Element)v.get(139)).setAttribute("id","legend" );
      ((Element)v.get(139)).setAttribute("cod","00333" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:138   */

      /* Empieza nodo:140 / Elemento padre: 137   */
      v.add(doc.createElement("table"));
      ((Element)v.get(140)).setAttribute("width","100%" );
      ((Element)v.get(140)).setAttribute("border","0" );
      ((Element)v.get(140)).setAttribute("align","center" );
      ((Element)v.get(140)).setAttribute("cellspacing","0" );
      ((Element)v.get(140)).setAttribute("cellpadding","0" );
      ((Element)v.get(137)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(140)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("td"));
      ((Element)v.get(141)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("table"));
      ((Element)v.get(143)).setAttribute("width","500" );
      ((Element)v.get(143)).setAttribute("border","0" );
      ((Element)v.get(143)).setAttribute("align","left" );
      ((Element)v.get(143)).setAttribute("cellspacing","0" );
      ((Element)v.get(143)).setAttribute("cellpadding","0" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(143)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("td"));
      ((Element)v.get(145)).setAttribute("colspan","4" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(146)).setAttribute("src","b.gif" );
      ((Element)v.get(146)).setAttribute("width","8" );
      ((Element)v.get(146)).setAttribute("height","8" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */
      /* Termina nodo:144   */

      /* Empieza nodo:147 / Elemento padre: 143   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(143)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(149)).setAttribute("src","b.gif" );
      ((Element)v.get(149)).setAttribute("width","8" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(149)).setAttribute("height","8" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */

      /* Empieza nodo:150 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(151)).setAttribute("nombre","lblProductos2" );
      ((Element)v.get(151)).setAttribute("alto","13" );
      ((Element)v.get(151)).setAttribute("filas","1" );
      ((Element)v.get(151)).setAttribute("valor","" );
      ((Element)v.get(151)).setAttribute("id","datosTitle" );
      ((Element)v.get(151)).setAttribute("cod","515" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:152 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(152)).setAttribute("width","100%" );
      ((Element)v.get(147)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(153)).setAttribute("src","b.gif" );
      ((Element)v.get(153)).setAttribute("width","8" );
      ((Element)v.get(153)).setAttribute("height","8" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:152   */
      /* Termina nodo:147   */

      /* Empieza nodo:154 / Elemento padre: 143   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(143)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(156)).setAttribute("src","b.gif" );
      ((Element)v.get(156)).setAttribute("width","8" );
      ((Element)v.get(156)).setAttribute("height","8" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */

      /* Empieza nodo:157 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
      ((Element)v.get(157)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(154)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(158)).setAttribute("nombre","cbProductos" );
      ((Element)v.get(158)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnAceptar');" );
      ((Element)v.get(158)).setAttribute("id","datosCampos" );
      ((Element)v.get(158)).setAttribute("size","1" );
      ((Element)v.get(158)).setAttribute("multiple","N" );
      ((Element)v.get(158)).setAttribute("req","S" );
      ((Element)v.get(158)).setAttribute("valorinicial","" );
      ((Element)v.get(158)).setAttribute("textoinicial","" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:160 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).setAttribute("width","100%" );
      ((Element)v.get(154)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(161)).setAttribute("src","b.gif" );
      ((Element)v.get(161)).setAttribute("width","8" );
      ((Element)v.get(161)).setAttribute("height","8" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:160   */
      /* Termina nodo:154   */

      /* Empieza nodo:162 / Elemento padre: 143   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(143)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).setAttribute("colspan","4" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(164)).setAttribute("src","b.gif" );
      ((Element)v.get(164)).setAttribute("width","8" );
      ((Element)v.get(164)).setAttribute("height","8" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */
      /* Termina nodo:162   */
      /* Termina nodo:143   */
      /* Termina nodo:142   */
      /* Termina nodo:141   */
      /* Termina nodo:140   */
      /* Termina nodo:137   */
      /* Termina nodo:136   */

      /* Empieza nodo:165 / Elemento padre: 133   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(166)).setAttribute("src","b.gif" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:165   */
      /* Termina nodo:133   */

      /* Empieza nodo:167 / Elemento padre: 125   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(125)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(167)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(169)).setAttribute("src","b.gif" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */
      /* Termina nodo:168   */

      /* Empieza nodo:170 / Elemento padre: 167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(167)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(170)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("table"));
      ((Element)v.get(172)).setAttribute("width","100%" );
      ((Element)v.get(172)).setAttribute("border","0" );
      ((Element)v.get(172)).setAttribute("align","center" );
      ((Element)v.get(172)).setAttribute("cellspacing","0" );
      ((Element)v.get(172)).setAttribute("cellpadding","0" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(172)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("td"));
      ((Element)v.get(174)).setAttribute("class","botonera" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
   }

   private void getXML810(Document doc) {
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(175)).setAttribute("nombre","btnAceptar" );
      ((Element)v.get(175)).setAttribute("ID","botonContenido" );
      ((Element)v.get(175)).setAttribute("tipo","html" );
      ((Element)v.get(175)).setAttribute("accion","accionAceptar();" );
      ((Element)v.get(175)).setAttribute("ontab","focaliza('formulario.cbProductos');" );
      ((Element)v.get(175)).setAttribute("estado","false" );
      ((Element)v.get(175)).setAttribute("cod","12" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:174   */
      /* Termina nodo:173   */
      /* Termina nodo:172   */
      /* Termina nodo:171   */
      /* Termina nodo:170   */

      /* Empieza nodo:176 / Elemento padre: 167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(167)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(177)).setAttribute("src","b.gif" );
      ((Element)v.get(177)).setAttribute("width","8" );
      ((Element)v.get(177)).setAttribute("height","12" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */
      /* Termina nodo:176   */
      /* Termina nodo:167   */

      /* Empieza nodo:178 / Elemento padre: 125   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(125)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(179)).setAttribute("width","12" );
      ((Element)v.get(179)).setAttribute("align","center" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(180)).setAttribute("src","b.gif" );
      ((Element)v.get(180)).setAttribute("width","12" );
      ((Element)v.get(180)).setAttribute("height","12" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */
      /* Termina nodo:179   */

      /* Empieza nodo:181 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(181)).setAttribute("width","756" );
      ((Element)v.get(178)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(182)).setAttribute("src","b.gif" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:181   */

      /* Empieza nodo:183 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(183)).setAttribute("width","12" );
      ((Element)v.get(178)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(184)).setAttribute("src","b.gif" );
      ((Element)v.get(184)).setAttribute("width","12" );
      ((Element)v.get(184)).setAttribute("height","1" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */
      /* Termina nodo:178   */
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:7   */


   }

}
