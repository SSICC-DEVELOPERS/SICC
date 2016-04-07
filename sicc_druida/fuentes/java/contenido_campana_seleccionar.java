
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_campana_seleccionar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_campana_seleccionar" );
      ((Element)v.get(0)).setAttribute("cod","0303" );
      ((Element)v.get(0)).setAttribute("titulo","Simular Estimados Business Planning" );
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
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Elemento padre:4 / Elemento actual: 5   */
      v.add(doc.createTextNode("\r \r\r  function detalle()  {\r    if (listado1.numSelecc()== 0) {\r      GestionarMensaje('1021',null,null,null);\r      return false;\r    }\r\r    var vacio = new Array();\r    listado2.setDatos(vacio);\r\r    var cod = listado1.codSeleccionados();\r    var valor1 = listado1.extraeDato(cod, 6);\r    var valor2 = listado1.extraeDato(cod, 7);\r    var valor3 = listado1.extraeDato(cod, 8);\r                    var valor4 = listado1.extraeDato(cod, 9);\r\r\r          set('formulario.campana', valor4);\r    set('formulario.marca',valor1);\r    set('formulario.tip_cli',valor2);\r    set('formulario.actividad',valor3);\r\r    set('formulario.conectorAction', 'LPSimularEstimadosBP');\r    eval('formulario').oculto='S';\r    set('formulario.accion', 'detalle');\r    enviaSICC('formulario');\r  }\r\r  function muestraListado1() {\r    DrdEnsanchaConMargenDcho('listado1',12);\r    document.all[\"Cplistado1\"].style.visibility='';\r    document.all[\"CpLin1listado1\"].style.visibility='';\r    document.all[\"CpLin2listado1\"].style.visibility='';\r    document.all[\"CpLin3listado1\"].style.visibility='';\r    document.all[\"CpLin4listado1\"].style.visibility='';\r    document.all[\"separa1Div\"].style.visibility='';\r    document.all[\"primera1Div\"].style.visibility='';\r    document.all[\"ret1Div\"].style.visibility='';\r    document.all[\"ava1Div\"].style.visibility='';\r    document.all[\"btnDetalleDiv\"].style.visibility='';\r  }\r\r  function muestraListado2() {\r    DrdEnsanchaConMargenDcho('listado2',12);\r    document.all[\"Cplistado2\"].style.visibility='';\r    document.all[\"CpLin1listado2\"].style.visibility='';\r    document.all[\"CpLin2listado2\"].style.visibility='';\r    document.all[\"CpLin3listado2\"].style.visibility='';\r    document.all[\"CpLin4listado2\"].style.visibility='';\r    document.all[\"separa2Div\"].style.visibility='';\r    document.all[\"primera2Div\"].style.visibility='';\r    document.all[\"ret2Div\"].style.visibility='hidden';     document.all[\"ava2Div\"].style.visibility='hidden';     document.all[\"btnRecalcularDiv\"].style.visibility='';\r  }\r\r  function ocultaListado2() {\r        DrdEnsanchaConMargenDcho('listado2',12);\r    document.all[\"Cplistado2\"].style.visibility='hidden';\r    document.all[\"CpLin1listado2\"].style.visibility='hidden';\r    document.all[\"CpLin2listado2\"].style.visibility='hidden';\r    document.all[\"CpLin3listado2\"].style.visibility='hidden';\r    document.all[\"CpLin4listado2\"].style.visibility='hidden';\r    document.all[\"separa2Div\"].style.visibility='hidden';\r    document.all[\"primera2Div\"].style.visibility='hidden';\r    document.all[\"ret2Div\"].style.visibility='hidden';     document.all[\"ava2Div\"].style.visibility='hidden';     document.all[\"btnRecalcularDiv\"].style.visibility='hidden';\r  }\r\r  function mostrarCodigoError()  {\r    var vErrCodigo = get('formulario.errCodigo');\r    var vErrDescrip = get('formulario.errDescripcion');\r    if (get('formulario.errDescripcion')!='')  {\r      var wnd = fMostrarMensajeError( vErrCodigo,vErrDescrip);\r    }\r  }\r\r  function onLoadPag()   {\r    configurarMenuSecundario(\"formulario\");\r    mostrarCodigoError();\r    ocultaListado2();\r    var arrDatos = new Array();\r    arrDatos = armarArray();\r    muestraListado1();\r    eval (ON_RSZ);\r    listado1.maxSel=1;\r    listado2.maxSel=1;\r\r		listado2.ponColorFondoFila = ponColorFondoFila_Modificada;\r   listado2.repintaDat_simplificado = repintaDat_simplificado_Modificado;\r\r   configurarPaginado(mipgndo,\"MAVCargarCampaniasSimularEstimadosBP\",\"ConectorCargarCampaniasSimularEstimadosBP\",\"es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion\",arrDatos);\r   }\r\r  function datos ( datum ) {\r    set ('formulario.campana',datum);\r    var reg =datum.split('|');\r    var campo = 'nada';\r    var campo2 = new Array();\r\r    for (i = 0; i < reg.length-1; i++){\r      var fila = new Array();\r\r      campo = reg[i];\r      campo2 = campo.split('¬');\r\r      fila[0]= campo2[0];\r      fila[1]= campo2[1];\r      fila[2]= campo2[2];\r      fila[3]= campo2[4];\r      fila[4]= campo2[5];\r      fila[5]= campo2[7];\r      fila[6]= campo2[9];\r      fila[7]= campo2[21];\r      fila[8]= campo2[10];\r      fila[9]= campo2[11];\r      fila[10]= campo2[13];\r      fila[11]= campo2[14];\r      fila[12]= campo2[15];\r      fila[13]= campo2[6];\r      fila[14]= campo2[8];\r      fila[15]= campo2[23];\r      fila[16]= \"false\";\r\r      /*fila[0]= campo2[0];\r      fila[1]= campo2[1];\r      fila[2]= campo2[2];\r      fila[3]= campo2[4];\r      fila[4]= campo2[5];\r      fila[5]= campo2[7];\r      fila[6]= campo2[9];\r      fila[7]= campo2[21];\r      fila[8]= campo2[10];\r      fila[9]= campo2[11];\r      fila[10]= campo2[13];\r      fila[11]= campo2[14];\r      fila[12]= campo2[15];\r      fila[13]= campo2[6];\r      fila[14]= campo2[8];\r      fila[15]= campo2[23];\r      fila[16]= \"false\";*/\r\r\r      if(fila[0]==\"null\") fila[0]=\"\";\r      if(fila[1]==\"null\") fila[1]=\"\";\r      if(fila[2]==\"null\") fila[2]=\"\";\r      if(fila[3]==\"null\") fila[3]=\"\";\r      if(fila[4]==\"null\") fila[4]=\"\";\r      if(fila[5]==\"null\") fila[5]=\"\";\r      if(fila[6]==\"null\") fila[6]=\"\";\r      if(fila[7]==\"null\") fila[7]=\"\";\r      if(fila[8]==\"null\") fila[8]=\"\";\r      if(fila[9]==\"null\") fila[9]=\"\";\r      if(fila[10]==\"null\") fila[10]=\"\";\r      if(fila[11]==\"null\") fila[11]=\"\";\r      if(fila[12]==\"null\") fila[12]=\"\";\r      if(fila[13]==\"null\") fila[13]=\"\";\r      if(fila[14]==\"null\") fila[14]=\"\";\r      if(fila[15]==\"null\") fila[15]=\"\";\r      if(fila[16]==\"null\") fila[16]=\"\";\r\r      listado2.insertar(fila);\r                }\r    muestraListado2();\r    focalizaBotonHTML_XY('btnRecalcular');\r  }\r\r         function recalcular() {\r         if (listado2.numSelecc()== 0) {\r           GestionarMensaje('1021',null,null,null);\r           return false;\r         }\r         else {\r           var listado = listado2.datos;\r           var indice = listado2.selecc;\r           var obj = new Object();\r\r           for(var i =0; i<indice.length; i++) {\r             if(indice[i]==1) {\r                var oidDetalleMAV = listado[i][0];\r                var tipoClasificacion = listado[i][13];\r                var clasificacion = listado[i][14];\r                var oidsSubtipos = listado[i][15];\r                var recal = listado[i][16];\r\r                if(recal==\"true\") {\r                  var recalCodProducto = listado[i][1];\r                  var recalCodVenta = listado[i][2];\r                  var recalDesProducto = listado[i][3];\r                  var recalClientesEsti = listado[i][7];\r                  var recalUnidadesPro = listado[i][8];\r                  var recalUnidadesTot = listado[i][9];\r                  var recalUnidadesDis = listado[i][10];\r                  var recalCondicion = listado[i][11];\r                  var recalValCondicion = listado[i][12];\r\r                  obj.recalCodProducto = recalCodProducto;\r                  obj.recalCodVenta = recalCodVenta;\r                  obj.recalDesProducto = recalDesProducto;\r                  obj.recalClientesEsti = recalClientesEsti;\r                  obj.recalUnidadesPro = recalUnidadesPro;\r                  obj.recalUnidadesTot = recalUnidadesTot;\r                  obj.recalUnidadesDis = recalUnidadesDis;\r                  obj.recalCondicion = recalCondicion;\r                  obj.recalValCondicion = recalValCondicion;\r                }\r             }\r           }\r\r           var tip_cli = get('formulario.tip_cli');\r\r           obj.tip_cli = tip_cli;\r           obj.tipoClasificacion = tipoClasificacion;\r           obj.clasificacion = clasificacion;\r           obj.oidDetalleMAV = oidDetalleMAV;\r           obj.oidsSubtipos = oidsSubtipos;\r           obj.recal = recal;\r\r           var nuevosValores = mostrarModalSICC('LPSimularEstimadosBP','cargarPaginaDetalle',obj,800,350);\r           detalle();            /*if(nuevosValores!=null) {\r             var limpia = new Array();\r             listado2.setDatos(limpia);\r             listado2.insertar(nuevosValores);\r           }*/\r         }\r    }\r\r   function armarArray(){\r      var arrDatos = new Array();\r      var i=0;\r\r      arrDatos[i] = new Array('oidPais',get('formulario.pais'));\r      i++;\r\r      arrDatos[i] = new Array('oidIdioma',get('formulario.idioma'));\r      i++;\r      return arrDatos;\r  }\r\r  function focoBotonDetalle() {\r    focalizaBotonHTML_XY('btnDetalle');\r  }\r\r  function focoBoton() {\r    if(document.all[\"btnRecalcularDiv\"].style.visibility=='hidden') {\r      focalizaBotonHTML_XY('btnDetalle');\r    }\r    else {\r      focalizaBotonHTML_XY('btnRecalcular');\r    }\r  }\r\r  function muestraLista(ultima, rowset) {\r    var tamano = rowset.length;\r    if (tamano > 0) {\r      focoBotonDetalle();\r           return true;\r    }\r    else{\r      focoBotonDetalle();\r    }\r  }\r\r  function fLimpiar() {\r    ocultaListado2();\r    focoBotonDetalle();\r  }\r\rvar ROJO_FONDO = \"#FF6666\";\rvar ROJO_SELECCION = \"#FF3333\";\r\rfunction seModificaColor( fila ){\r		if( listado2.datos[fila][10] < listado2.datos[fila][9] )\r		return true;\r	else\r		return false;\r}\r\rfunction ponColorFondoFila_Modificada(fila,color){\r	var j,tab=document.all[\"tblDat\"+listado2.nombre];\r	if( seModificaColor(fila) )\r		if(color==\"\")\r			color= ROJO_FONDO;\r		else\r			color= ROJO_SELECCION;\r\r	if (listado2.renderOptimizado) {\r		var fila=tab.rows(fila);\r		for (j=0;j<fila.cells.length;j++)\r			fila.cells(j).style.backgroundColor=color;\r	} else {\r		var fila;\r		if (listado2.GrHDat > 0)\r			fila=tab.rows(fila*2);\r		else\r			fila=tab.rows(fila);\r		for (j=0;j<fila.cells.length;j++) {\r			if (listado2.GrV==0 ||DrEsPar(j))\r				{ fila.cells(j).style.backgroundColor=color; }\r		}\r	}\r}\r\r	function repintaDat_simplificado_Modificado() {      var debeEscapar = /<|>|\\\"/;\r      var minombre=listado2.nombre;\r      var dat=listado2.datos;\r      var elOnMouseOverTabla=\"\",elOnMouseOutTabla=\"\",elOnClickTabla=\"\",elOnDblClickTabla=\"\";\r\r      if (listado2.colOn!=\"\")   {\r         elOnMouseOverTabla=\" onMouseOver=\"+minombre+\".onMouseOverTabla() \";\r         elOnMouseOutTabla=\" onMouseOut=\"+minombre+\".onMouseOutTabla() \";\r         }\r\r            if ((listado2.colOn!=\"\" || listado2.colSel!=\"\") && listado2.tipoSeleccion==\"fila\") {\r         if (listado2.hayDobleClic)  {\r            elOnClickTabla=\" onClick=window.TOSrcEvent=window.event.srcElement;\"+minombre+\".IDDBLCLICK=setTimeout('\"+minombre+\".onClickTabla(true)',\"+listado2.msegDobleClick+\") \";\r            elOnDblClickTabla=\" ondblclick=\"+minombre+\".onDblclickTabla() \";\r            }\r         else\r            elOnClickTabla=\" onClick=\"+minombre+\".onClickTabla() \";\r         }\r      var txt=[];\r      txt.mete(\"<FORM action=\\\"\\\" name=\\\"form\"+minombre+\"\\\">\");\r      txt.mete(\"<TABLE ID=tblDat\"+minombre+\" border=0 cellspacing=0 cellpadding=0 class=brdTblDat\"+minombre+\" \"+ elOnMouseOverTabla + elOnMouseOutTabla + elOnClickTabla + elOnDblClickTabla +\">\")\r                  var colVisible=[], colMinimizada=[], colIndEnDatos=[];                        var columnaDatos=1;\r      for (var c=0,tam=listado2.tiposCol.length;c<tam;c++)   {\r         colVisible.mete( (listado2.estadoCol[c][0].toUpperCase()!=\"OCULTA\")?true:false );\r         colMinimizada.mete( (listado2.estadoCol[c][0].toUpperCase()!=\"MINIMIZADA\")?false:true );\r         if (listado2.tiposCol[c][0].toUpperCase() == \"BOTON\")\r            colIndEnDatos.mete(-1);         else  {\r            colIndEnDatos.mete(columnaDatos);\r            columnaDatos++;\r            }\r         }\r      var elHhtmlTr=(listado2.altoFila!='')?\"<TR height=\"+listado2.altoFila+\">\":\"<TR>\";\r      for (var f=0,tam=dat.length;f<tam;f++)   {         txt.mete(elHhtmlTr);\r         for (var c=0,tam2=listado2.tiposCol.length;c<tam2;c++)   {            if (colVisible[c]) {               var cEst=listado2.estilosDat[c];\r               var estilotd=cEst[f%(cEst.length)];\r               txt.mete(\"<TD ID=\"+estilotd+\">\");\r               var eldato=\"\";\r               if (colIndEnDatos[c]!=-1) {                   var datoTemp = listado2.datos[f][colIndEnDatos[c]]+\"\";\r                  if(debeEscapar.test(datoTemp))\r                     eldato=DrdEscHTML(datoTemp);\r                  else\r                     eldato=datoTemp;\r                  }\r               if (!colMinimizada[c]) {\r                  var t2=listado2.nbsp+listado2.pintaElemento(listado2.tiposCol[c] , eldato ,f,c);\r                  if (t2==\"\")\r                     txt.mete(\"&nbsp;\");                  else\r                     txt.mete(t2);\r                  }\r               else\r                  txt.mete(\"&nbsp;\");\r               if (f==0)\r                  txt.mete(\"<BR><div style=height:1;width:\"+listado2.anchos[c]+\"><x/></div>\");\r               txt.mete(\"</TD>\");\r               }\r            }\r         txt.mete(\"</TR>\");\r         }\r      txt.mete(\"</TABLE>\");\r      scroll_to('CpScroll'+minombre,txt.join(''));\r      if (!window.FLAG_SCR_NATIVO || window.FLAG_SCR_NATIVO!='S')\r         listado2.form=listado2.cpDat.document[\"form\"+listado2.nombre];\r      else\r         listado2.form=document[\"form\"+listado2.nombre];\r      listado2.cargaEstadoBotones(listado2.selecc);\r\r		  for (var i = 0; i < listado2.datos.length;i++ ) {listado2.ponColorFondoFila(i,\"\"); } \r      }\r\r \r"));
      ((Element)v.get(4)).appendChild((Text)v.get(5));

      /* Termina nodo Texto:5   */
      /* Termina nodo:4   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(6)).setAttribute("nombre","formulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","accion" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","idioma" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","pais" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","marca" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","tip_cli" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","actividad" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","campana" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","seleccion" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","oid_det" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","recal" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","recalCodProducto" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","recalCodVenta" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 6   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","recalDesProducto" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","recalClientesEsti" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","recalUnidadesPro" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","recalUnidadesTot" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","recalUnidadesDis" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","recalCondicion" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","recalValCondicion" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 6   */
      v.add(doc.createElement("table"));
      ((Element)v.get(30)).setAttribute("width","100%" );
      ((Element)v.get(30)).setAttribute("border","0" );
      ((Element)v.get(30)).setAttribute("cellspacing","0" );
      ((Element)v.get(30)).setAttribute("cellpadding","0" );
      ((Element)v.get(6)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(30)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("td"));
      ((Element)v.get(32)).setAttribute("width","100%" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(33)).setAttribute("src","b.gif" );
      ((Element)v.get(33)).setAttribute("width","424" );
      ((Element)v.get(33)).setAttribute("height","8" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */
      /* Termina nodo:32   */
      /* Termina nodo:31   */
      /* Termina nodo:30   */

      /* Empieza nodo:34 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(34)).setAttribute("nombre","listado1" );
      ((Element)v.get(34)).setAttribute("ancho","400" );
      ((Element)v.get(34)).setAttribute("alto","317" );
      ((Element)v.get(34)).setAttribute("x","12" );
      ((Element)v.get(34)).setAttribute("y","12" );
      ((Element)v.get(34)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(34)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(35)).setAttribute("precarga","S" );
      ((Element)v.get(35)).setAttribute("conROver","S" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(36)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(36)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(36)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(36)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 35   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(37)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(37)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(37)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(37)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(35)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 35   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(38)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(38)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(35)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */
      /* Termina nodo:35   */

      /* Empieza nodo:39 / Elemento padre: 34   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(34)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(40)).setAttribute("borde","1" );
      ((Element)v.get(40)).setAttribute("horizDatos","1" );
      ((Element)v.get(40)).setAttribute("horizCabecera","1" );
      ((Element)v.get(40)).setAttribute("vertical","0" );
      ((Element)v.get(40)).setAttribute("horizTitulo","1" );
      ((Element)v.get(40)).setAttribute("horizBase","1" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 39   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(41)).setAttribute("borde","#999999" );
      ((Element)v.get(41)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(41)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(41)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(41)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(41)).setAttribute("horizTitulo","#999999" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(41)).setAttribute("horizBase","#999999" );
      ((Element)v.get(39)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:39   */

      /* Empieza nodo:42 / Elemento padre: 34   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(42)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(42)).setAttribute("alto","22" );
      ((Element)v.get(42)).setAttribute("imgFondo","" );
      ((Element)v.get(42)).setAttribute("cod","00168" );
      ((Element)v.get(42)).setAttribute("ID","datosTitle" );
      ((Element)v.get(34)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 34   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(43)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(43)).setAttribute("alto","22" );
      ((Element)v.get(43)).setAttribute("imgFondo","" );
      ((Element)v.get(34)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 34   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(44)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(44)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(44)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(44)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(44)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(44)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(34)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(45)).setAttribute("ancho","30" );
      ((Element)v.get(45)).setAttribute("minimizable","S" );
      ((Element)v.get(45)).setAttribute("minimizada","N" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 44   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(46)).setAttribute("ancho","50" );
      ((Element)v.get(46)).setAttribute("minimizable","S" );
      ((Element)v.get(46)).setAttribute("minimizada","N" );
      ((Element)v.get(46)).setAttribute("orden","alfanumerico" );
      ((Element)v.get(44)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 44   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(47)).setAttribute("ancho","48" );
      ((Element)v.get(47)).setAttribute("minimizable","S" );
      ((Element)v.get(47)).setAttribute("minimizada","N" );
      ((Element)v.get(44)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 44   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(48)).setAttribute("ancho","10" );
      ((Element)v.get(48)).setAttribute("minimizable","S" );
      ((Element)v.get(48)).setAttribute("minimizada","N" );
      ((Element)v.get(44)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 44   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(49)).setAttribute("ancho","40" );
      ((Element)v.get(49)).setAttribute("minimizable","S" );
      ((Element)v.get(49)).setAttribute("minimizada","N" );
      ((Element)v.get(44)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 44   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(50)).setAttribute("ancho","48" );
      ((Element)v.get(50)).setAttribute("minimizable","S" );
      ((Element)v.get(50)).setAttribute("minimizada","N" );
      ((Element)v.get(44)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 44   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(51)).setAttribute("ancho","30" );
      ((Element)v.get(51)).setAttribute("minimizable","S" );
      ((Element)v.get(51)).setAttribute("minimizada","N" );
      ((Element)v.get(51)).setAttribute("oculta","S" );
      ((Element)v.get(44)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 44   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(52)).setAttribute("ancho","30" );
      ((Element)v.get(52)).setAttribute("minimizable","S" );
      ((Element)v.get(52)).setAttribute("minimizada","N" );
      ((Element)v.get(52)).setAttribute("oculta","S" );
      ((Element)v.get(44)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 44   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(53)).setAttribute("ancho","30" );
      ((Element)v.get(53)).setAttribute("minimizable","S" );
      ((Element)v.get(53)).setAttribute("minimizada","N" );
      ((Element)v.get(53)).setAttribute("oculta","S" );
      ((Element)v.get(44)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 44   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(54)).setAttribute("ancho","30" );
      ((Element)v.get(54)).setAttribute("minimizable","S" );
      ((Element)v.get(54)).setAttribute("minimizada","N" );
      ((Element)v.get(54)).setAttribute("oculta","S" );
      ((Element)v.get(44)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:44   */

      /* Empieza nodo:55 / Elemento padre: 34   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(55)).setAttribute("alto","20" );
      ((Element)v.get(55)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(55)).setAttribute("imgFondo","" );
      ((Element)v.get(55)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(34)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(56)).setAttribute("colFondo","" );
      ((Element)v.get(56)).setAttribute("ID","EstCab" );
      ((Element)v.get(56)).setAttribute("align","center" );
      ((Element)v.get(56)).setAttribute("cod","5" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Elemento padre:56 / Elemento actual: 57   */
      v.add(doc.createTextNode("País"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(56)).appendChild((Text)v.get(57));

      /* Termina nodo Texto:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:58 / Elemento padre: 55   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(58)).setAttribute("colFondo","" );
      ((Element)v.get(58)).setAttribute("ID","EstCab" );
      ((Element)v.get(58)).setAttribute("cod","6" );
      ((Element)v.get(55)).appendChild((Element)v.get(58));

      /* Elemento padre:58 / Elemento actual: 59   */
      v.add(doc.createTextNode("Marca"));
      ((Element)v.get(58)).appendChild((Text)v.get(59));

      /* Termina nodo Texto:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:60 / Elemento padre: 55   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(60)).setAttribute("colFondo","" );
      ((Element)v.get(60)).setAttribute("ID","EstCab" );
      ((Element)v.get(60)).setAttribute("cod","7" );
      ((Element)v.get(55)).appendChild((Element)v.get(60));

      /* Elemento padre:60 / Elemento actual: 61   */
      v.add(doc.createTextNode("Canal"));
      ((Element)v.get(60)).appendChild((Text)v.get(61));

      /* Termina nodo Texto:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:62 / Elemento padre: 55   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(62)).setAttribute("colFondo","" );
      ((Element)v.get(62)).setAttribute("ID","EstCab" );
      ((Element)v.get(62)).setAttribute("cod","276" );
      ((Element)v.get(55)).appendChild((Element)v.get(62));

      /* Elemento padre:62 / Elemento actual: 63   */
      v.add(doc.createTextNode("Período"));
      ((Element)v.get(62)).appendChild((Text)v.get(63));

      /* Termina nodo Texto:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:64 / Elemento padre: 55   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(64)).setAttribute("colFondo","" );
      ((Element)v.get(64)).setAttribute("ID","EstCab" );
      ((Element)v.get(64)).setAttribute("cod","173" );
      ((Element)v.get(55)).appendChild((Element)v.get(64));

      /* Elemento padre:64 / Elemento actual: 65   */
      v.add(doc.createTextNode("Actividad"));
      ((Element)v.get(64)).appendChild((Text)v.get(65));

      /* Termina nodo Texto:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:66 / Elemento padre: 55   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(66)).setAttribute("colFondo","" );
      ((Element)v.get(66)).setAttribute("ID","EstCab" );
      ((Element)v.get(66)).setAttribute("cod","393" );
      ((Element)v.get(55)).appendChild((Element)v.get(66));

      /* Elemento padre:66 / Elemento actual: 67   */
      v.add(doc.createTextNode("Tipo cliente"));
      ((Element)v.get(66)).appendChild((Text)v.get(67));

      /* Termina nodo Texto:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:68 / Elemento padre: 55   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(68)).setAttribute("colFondo","" );
      ((Element)v.get(68)).setAttribute("ID","EstCab" );
      ((Element)v.get(55)).appendChild((Element)v.get(68));

      /* Elemento padre:68 / Elemento actual: 69   */
      v.add(doc.createTextNode("oidmarca"));
      ((Element)v.get(68)).appendChild((Text)v.get(69));

      /* Termina nodo Texto:69   */
      /* Termina nodo:68   */

      /* Empieza nodo:70 / Elemento padre: 55   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(70)).setAttribute("colFondo","" );
      ((Element)v.get(70)).setAttribute("ID","EstCab" );
      ((Element)v.get(55)).appendChild((Element)v.get(70));

      /* Elemento padre:70 / Elemento actual: 71   */
      v.add(doc.createTextNode("oidTipCli"));
      ((Element)v.get(70)).appendChild((Text)v.get(71));

      /* Termina nodo Texto:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:72 / Elemento padre: 55   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(72)).setAttribute("colFondo","" );
      ((Element)v.get(72)).setAttribute("ID","EstCab" );
      ((Element)v.get(55)).appendChild((Element)v.get(72));

      /* Elemento padre:72 / Elemento actual: 73   */
      v.add(doc.createTextNode("oidactividad"));
      ((Element)v.get(72)).appendChild((Text)v.get(73));

      /* Termina nodo Texto:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:74 / Elemento padre: 55   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(74)).setAttribute("colFondo","" );
      ((Element)v.get(74)).setAttribute("ID","EstCab" );
      ((Element)v.get(55)).appendChild((Element)v.get(74));

      /* Elemento padre:74 / Elemento actual: 75   */
      v.add(doc.createTextNode("oidPeriodo"));
      ((Element)v.get(74)).appendChild((Text)v.get(75));

      /* Termina nodo Texto:75   */
      /* Termina nodo:74   */
      /* Termina nodo:55   */

      /* Empieza nodo:76 / Elemento padre: 34   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(76)).setAttribute("alto","22" );
      ((Element)v.get(76)).setAttribute("accion","" );
      ((Element)v.get(76)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(76)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(76)).setAttribute("maxSel","-1" );
      ((Element)v.get(76)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(76)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(76)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(76)).setAttribute("onLoad","" );
      ((Element)v.get(76)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(34)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(77)).setAttribute("tipo","texto" );
      ((Element)v.get(77)).setAttribute("ID","EstDat" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */

      /* Empieza nodo:78 / Elemento padre: 76   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(78)).setAttribute("tipo","texto" );
      ((Element)v.get(78)).setAttribute("ID","EstDat2" );
      ((Element)v.get(76)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */

      /* Empieza nodo:79 / Elemento padre: 76   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(79)).setAttribute("tipo","texto" );
      ((Element)v.get(79)).setAttribute("ID","EstDat" );
      ((Element)v.get(76)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */

      /* Empieza nodo:80 / Elemento padre: 76   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(80)).setAttribute("tipo","texto" );
      ((Element)v.get(80)).setAttribute("ID","EstDat2" );
      ((Element)v.get(76)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */

      /* Empieza nodo:81 / Elemento padre: 76   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(81)).setAttribute("tipo","texto" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(81)).setAttribute("ID","EstDat" );
      ((Element)v.get(76)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */

      /* Empieza nodo:82 / Elemento padre: 76   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(82)).setAttribute("tipo","texto" );
      ((Element)v.get(82)).setAttribute("ID","EstDat2" );
      ((Element)v.get(76)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */

      /* Empieza nodo:83 / Elemento padre: 76   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(83)).setAttribute("tipo","texto" );
      ((Element)v.get(83)).setAttribute("ID","EstDat" );
      ((Element)v.get(76)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */

      /* Empieza nodo:84 / Elemento padre: 76   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(84)).setAttribute("tipo","texto" );
      ((Element)v.get(84)).setAttribute("ID","EstDat2" );
      ((Element)v.get(76)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */

      /* Empieza nodo:85 / Elemento padre: 76   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(85)).setAttribute("tipo","texto" );
      ((Element)v.get(85)).setAttribute("ID","EstDat" );
      ((Element)v.get(76)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */

      /* Empieza nodo:86 / Elemento padre: 76   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(86)).setAttribute("tipo","texto" );
      ((Element)v.get(86)).setAttribute("ID","EstDat2" );
      ((Element)v.get(76)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:76   */

      /* Empieza nodo:87 / Elemento padre: 34   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(34)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */

      /* Empieza nodo:88 / Elemento padre: 34   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(88)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(88)).setAttribute("ancho","400" );
      ((Element)v.get(88)).setAttribute("sep","$" );
      ((Element)v.get(88)).setAttribute("x","12" );
      ((Element)v.get(88)).setAttribute("class","botonera" );
      ((Element)v.get(88)).setAttribute("y","306" );
      ((Element)v.get(88)).setAttribute("control","|" );
      ((Element)v.get(88)).setAttribute("conector","" );
      ((Element)v.get(88)).setAttribute("rowset","" );
      ((Element)v.get(88)).setAttribute("cargainicial","N" );
      ((Element)v.get(88)).setAttribute("onload","procesarPaginado(mipgndo,msgError,ultima,rowset,'muestraLista(ultima,rowset)');" );
      ((Element)v.get(34)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(89)).setAttribute("nombre","ret1" );
      ((Element)v.get(89)).setAttribute("x","37" );
      ((Element)v.get(89)).setAttribute("y","310" );
      ((Element)v.get(89)).setAttribute("ID","botonContenido" );
      ((Element)v.get(89)).setAttribute("img","retroceder_on" );
      ((Element)v.get(89)).setAttribute("tipo","0" );
      ((Element)v.get(89)).setAttribute("estado","false" );
      ((Element)v.get(89)).setAttribute("alt","" );
      ((Element)v.get(89)).setAttribute("codigo","" );
      ((Element)v.get(89)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */

      /* Empieza nodo:90 / Elemento padre: 88   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(90)).setAttribute("nombre","ava1" );
      ((Element)v.get(90)).setAttribute("x","52" );
      ((Element)v.get(90)).setAttribute("y","310" );
      ((Element)v.get(90)).setAttribute("ID","botonContenido" );
      ((Element)v.get(90)).setAttribute("img","avanzar_on" );
      ((Element)v.get(90)).setAttribute("tipo","0" );
      ((Element)v.get(90)).setAttribute("estado","false" );
      ((Element)v.get(90)).setAttribute("alt","" );
      ((Element)v.get(90)).setAttribute("codigo","" );
      ((Element)v.get(90)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(88)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:88   */
      /* Termina nodo:34   */

      /* Empieza nodo:91 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(91)).setAttribute("nombre","primera1" );
      ((Element)v.get(91)).setAttribute("x","20" );
      ((Element)v.get(91)).setAttribute("y","310" );
      ((Element)v.get(91)).setAttribute("ID","botonContenido" );
      ((Element)v.get(91)).setAttribute("img","primera_on" );
      ((Element)v.get(91)).setAttribute("tipo","0" );
      ((Element)v.get(91)).setAttribute("estado","false" );
      ((Element)v.get(91)).setAttribute("alt","" );
      ((Element)v.get(91)).setAttribute("codigo","" );
      ((Element)v.get(91)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(6)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */

      /* Empieza nodo:92 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(92)).setAttribute("nombre","separa1" );
      ((Element)v.get(92)).setAttribute("x","59" );
      ((Element)v.get(92)).setAttribute("y","306" );
      ((Element)v.get(92)).setAttribute("ID","botonContenido" );
      ((Element)v.get(92)).setAttribute("img","separa_base" );
      ((Element)v.get(92)).setAttribute("tipo","0" );
      ((Element)v.get(92)).setAttribute("estado","false" );
      ((Element)v.get(92)).setAttribute("alt","" );
      ((Element)v.get(92)).setAttribute("codigo","" );
      ((Element)v.get(92)).setAttribute("accion","" );
      ((Element)v.get(6)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */

      /* Empieza nodo:93 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(93)).setAttribute("nombre","btnDetalle" );
      ((Element)v.get(93)).setAttribute("x","80" );
      ((Element)v.get(93)).setAttribute("y","307" );
      ((Element)v.get(93)).setAttribute("ID","botonContenido" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(93)).setAttribute("tipo","html" );
      ((Element)v.get(93)).setAttribute("estado","false" );
      ((Element)v.get(93)).setAttribute("cod","3" );
      ((Element)v.get(93)).setAttribute("accion","detalle();" );
      ((Element)v.get(93)).setAttribute("ontab","focoBoton();" );
      ((Element)v.get(93)).setAttribute("onshtab","focoBoton();" );
      ((Element)v.get(6)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */

      /* Empieza nodo:94 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(94)).setAttribute("nombre","listado2" );
      ((Element)v.get(94)).setAttribute("ancho","400" );
      ((Element)v.get(94)).setAttribute("alto","317" );
      ((Element)v.get(94)).setAttribute("x","12" );
      ((Element)v.get(94)).setAttribute("y","353" );
      ((Element)v.get(94)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(94)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(95)).setAttribute("precarga","S" );
      ((Element)v.get(95)).setAttribute("conROver","S" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(96)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(96)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(96)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(96)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */

      /* Empieza nodo:97 / Elemento padre: 95   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(97)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(97)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(97)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(97)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(95)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */

      /* Empieza nodo:98 / Elemento padre: 95   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(98)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(98)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(95)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:95   */

      /* Empieza nodo:99 / Elemento padre: 94   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(94)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(100)).setAttribute("borde","1" );
      ((Element)v.get(100)).setAttribute("horizDatos","1" );
      ((Element)v.get(100)).setAttribute("horizCabecera","1" );
      ((Element)v.get(100)).setAttribute("vertical","0" );
      ((Element)v.get(100)).setAttribute("horizTitulo","1" );
      ((Element)v.get(100)).setAttribute("horizBase","1" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */

      /* Empieza nodo:101 / Elemento padre: 99   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(101)).setAttribute("borde","#999999" );
      ((Element)v.get(101)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(101)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(101)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(101)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(101)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(101)).setAttribute("horizBase","#999999" );
      ((Element)v.get(99)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:99   */

      /* Empieza nodo:102 / Elemento padre: 94   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(102)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(102)).setAttribute("alto","22" );
      ((Element)v.get(102)).setAttribute("imgFondo","" );
      ((Element)v.get(102)).setAttribute("cod","00169" );
      ((Element)v.get(102)).setAttribute("ID","datosTitle" );
      ((Element)v.get(94)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */

      /* Empieza nodo:103 / Elemento padre: 94   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(103)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(103)).setAttribute("alto","22" );
      ((Element)v.get(103)).setAttribute("imgFondo","" );
      ((Element)v.get(94)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */

      /* Empieza nodo:104 / Elemento padre: 94   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(104)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(104)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(104)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(104)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(104)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(104)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(94)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(105)).setAttribute("ancho","100" );
      ((Element)v.get(105)).setAttribute("minimizable","S" );
      ((Element)v.get(105)).setAttribute("minimizada","N" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */

      /* Empieza nodo:106 / Elemento padre: 104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(106)).setAttribute("ancho","80" );
      ((Element)v.get(106)).setAttribute("minimizable","S" );
      ((Element)v.get(106)).setAttribute("minimizada","N" );
      ((Element)v.get(106)).setAttribute("oculta","S" );
      ((Element)v.get(104)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */

      /* Empieza nodo:107 / Elemento padre: 104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(107)).setAttribute("ancho","150" );
      ((Element)v.get(107)).setAttribute("minimizable","S" );
      ((Element)v.get(107)).setAttribute("minimizada","N" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(104)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */

      /* Empieza nodo:108 / Elemento padre: 104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(108)).setAttribute("ancho","150" );
      ((Element)v.get(108)).setAttribute("minimizable","S" );
      ((Element)v.get(108)).setAttribute("minimizada","N" );
      ((Element)v.get(104)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */

      /* Empieza nodo:109 / Elemento padre: 104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(109)).setAttribute("ancho","100" );
      ((Element)v.get(109)).setAttribute("minimizable","S" );
      ((Element)v.get(109)).setAttribute("minimizada","N" );
      ((Element)v.get(104)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */

      /* Empieza nodo:110 / Elemento padre: 104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(110)).setAttribute("ancho","100" );
      ((Element)v.get(110)).setAttribute("minimizable","S" );
      ((Element)v.get(110)).setAttribute("minimizada","N" );
      ((Element)v.get(104)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */

      /* Empieza nodo:111 / Elemento padre: 104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(111)).setAttribute("ancho","150" );
      ((Element)v.get(111)).setAttribute("minimizable","S" );
      ((Element)v.get(111)).setAttribute("minimizada","N" );
      ((Element)v.get(104)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */

      /* Empieza nodo:112 / Elemento padre: 104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(112)).setAttribute("ancho","150" );
      ((Element)v.get(112)).setAttribute("minimizable","S" );
      ((Element)v.get(112)).setAttribute("minimizada","N" );
      ((Element)v.get(104)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */

      /* Empieza nodo:113 / Elemento padre: 104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(113)).setAttribute("ancho","150" );
      ((Element)v.get(113)).setAttribute("minimizable","S" );
      ((Element)v.get(113)).setAttribute("minimizada","N" );
      ((Element)v.get(104)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */

      /* Empieza nodo:114 / Elemento padre: 104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(114)).setAttribute("ancho","120" );
      ((Element)v.get(114)).setAttribute("minimizable","S" );
      ((Element)v.get(114)).setAttribute("minimizada","N" );
      ((Element)v.get(104)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */

      /* Empieza nodo:115 / Elemento padre: 104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(115)).setAttribute("ancho","70" );
      ((Element)v.get(115)).setAttribute("minimizable","S" );
      ((Element)v.get(115)).setAttribute("minimizada","N" );
      ((Element)v.get(104)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */

      /* Empieza nodo:116 / Elemento padre: 104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(116)).setAttribute("ancho","110" );
      ((Element)v.get(116)).setAttribute("minimizable","S" );
      ((Element)v.get(116)).setAttribute("minimizada","N" );
      ((Element)v.get(104)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:104   */

      /* Empieza nodo:117 / Elemento padre: 94   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(117)).setAttribute("alto","20" );
      ((Element)v.get(117)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(117)).setAttribute("imgFondo","" );
      ((Element)v.get(117)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(94)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(118)).setAttribute("colFondo","" );
      ((Element)v.get(118)).setAttribute("ID","EstCab" );
      ((Element)v.get(118)).setAttribute("align","center" );
      ((Element)v.get(118)).setAttribute("cod","337" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));

      /* Elemento padre:118 / Elemento actual: 119   */
      v.add(doc.createTextNode("Cód. producto"));
      ((Element)v.get(118)).appendChild((Text)v.get(119));

      /* Termina nodo Texto:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:120 / Elemento padre: 117   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(120)).setAttribute("colFondo","" );
      ((Element)v.get(120)).setAttribute("ID","EstCab" );
      ((Element)v.get(120)).setAttribute("cod","336" );
      ((Element)v.get(117)).appendChild((Element)v.get(120));

      /* Elemento padre:120 / Elemento actual: 121   */
      v.add(doc.createTextNode("Cód. venta"));
      ((Element)v.get(120)).appendChild((Text)v.get(121));

      /* Termina nodo Texto:121   */
      /* Termina nodo:120   */

      /* Empieza nodo:122 / Elemento padre: 117   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(122)).setAttribute("colFondo","" );
      ((Element)v.get(122)).setAttribute("ID","EstCab" );
      ((Element)v.get(122)).setAttribute("cod","338" );
      ((Element)v.get(117)).appendChild((Element)v.get(122));

      /* Elemento padre:122 / Elemento actual: 123   */
      v.add(doc.createTextNode("Descripción producto"));
      ((Element)v.get(122)).appendChild((Text)v.get(123));

      /* Termina nodo Texto:123   */
      /* Termina nodo:122   */

      /* Empieza nodo:124 / Elemento padre: 117   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(124)).setAttribute("colFondo","" );
      ((Element)v.get(124)).setAttribute("ID","EstCab" );
      ((Element)v.get(124)).setAttribute("cod","595" );
      ((Element)v.get(117)).appendChild((Element)v.get(124));

      /* Elemento padre:124 / Elemento actual: 125   */
      v.add(doc.createTextNode("Subtipo cliente"));
      ((Element)v.get(124)).appendChild((Text)v.get(125));

      /* Termina nodo Texto:125   */
      /* Termina nodo:124   */

      /* Empieza nodo:126 / Elemento padre: 117   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(126)).setAttribute("colFondo","" );
      ((Element)v.get(126)).setAttribute("ID","EstCab" );
      ((Element)v.get(126)).setAttribute("cod","756" );
      ((Element)v.get(117)).appendChild((Element)v.get(126));

      /* Elemento padre:126 / Elemento actual: 127   */
      v.add(doc.createTextNode("Tipo clasificación"));
      ((Element)v.get(126)).appendChild((Text)v.get(127));

      /* Termina nodo Texto:127   */
      /* Termina nodo:126   */

      /* Empieza nodo:128 / Elemento padre: 117   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(128)).setAttribute("colFondo","" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(128)).setAttribute("ID","EstCab" );
      ((Element)v.get(128)).setAttribute("cod","550" );
      ((Element)v.get(117)).appendChild((Element)v.get(128));

      /* Elemento padre:128 / Elemento actual: 129   */
      v.add(doc.createTextNode("Clasificación"));
      ((Element)v.get(128)).appendChild((Text)v.get(129));

      /* Termina nodo Texto:129   */
      /* Termina nodo:128   */

      /* Empieza nodo:130 / Elemento padre: 117   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(130)).setAttribute("colFondo","" );
      ((Element)v.get(130)).setAttribute("ID","EstCab" );
      ((Element)v.get(130)).setAttribute("cod","931" );
      ((Element)v.get(117)).appendChild((Element)v.get(130));

      /* Elemento padre:130 / Elemento actual: 131   */
      v.add(doc.createTextNode("Nº clientes estimados"));
      ((Element)v.get(130)).appendChild((Text)v.get(131));

      /* Termina nodo Texto:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:132 / Elemento padre: 117   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(132)).setAttribute("colFondo","" );
      ((Element)v.get(132)).setAttribute("ID","EstCab" );
      ((Element)v.get(132)).setAttribute("cod","1017" );
      ((Element)v.get(117)).appendChild((Element)v.get(132));

      /* Elemento padre:132 / Elemento actual: 133   */
      v.add(doc.createTextNode("Unidades promedio"));
      ((Element)v.get(132)).appendChild((Text)v.get(133));

      /* Termina nodo Texto:133   */
      /* Termina nodo:132   */

      /* Empieza nodo:134 / Elemento padre: 117   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(134)).setAttribute("colFondo","" );
      ((Element)v.get(134)).setAttribute("ID","EstCab" );
      ((Element)v.get(134)).setAttribute("cod","1015" );
      ((Element)v.get(117)).appendChild((Element)v.get(134));

      /* Elemento padre:134 / Elemento actual: 135   */
      v.add(doc.createTextNode("Unidades totales"));
      ((Element)v.get(134)).appendChild((Text)v.get(135));

      /* Termina nodo Texto:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:136 / Elemento padre: 117   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(136)).setAttribute("colFondo","" );
      ((Element)v.get(136)).setAttribute("ID","EstCab" );
      ((Element)v.get(136)).setAttribute("cod","1011" );
      ((Element)v.get(117)).appendChild((Element)v.get(136));

      /* Elemento padre:136 / Elemento actual: 137   */
      v.add(doc.createTextNode("Unidades disponibles"));
      ((Element)v.get(136)).appendChild((Text)v.get(137));

      /* Termina nodo Texto:137   */
      /* Termina nodo:136   */

      /* Empieza nodo:138 / Elemento padre: 117   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(138)).setAttribute("colFondo","" );
      ((Element)v.get(138)).setAttribute("ID","EstCab" );
      ((Element)v.get(138)).setAttribute("cod","1376" );
      ((Element)v.get(117)).appendChild((Element)v.get(138));

      /* Elemento padre:138 / Elemento actual: 139   */
      v.add(doc.createTextNode("Condición"));
      ((Element)v.get(138)).appendChild((Text)v.get(139));

      /* Termina nodo Texto:139   */
      /* Termina nodo:138   */

      /* Empieza nodo:140 / Elemento padre: 117   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(140)).setAttribute("colFondo","" );
      ((Element)v.get(140)).setAttribute("ID","EstCab" );
      ((Element)v.get(140)).setAttribute("cod","1377" );
      ((Element)v.get(117)).appendChild((Element)v.get(140));

      /* Elemento padre:140 / Elemento actual: 141   */
      v.add(doc.createTextNode("Valor condición"));
      ((Element)v.get(140)).appendChild((Text)v.get(141));

      /* Termina nodo Texto:141   */
      /* Termina nodo:140   */
      /* Termina nodo:117   */

      /* Empieza nodo:142 / Elemento padre: 94   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(142)).setAttribute("alto","22" );
      ((Element)v.get(142)).setAttribute("accion","" );
      ((Element)v.get(142)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(142)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(142)).setAttribute("maxSel","-1" );
      ((Element)v.get(142)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(142)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(142)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(142)).setAttribute("onLoad","" );
      ((Element)v.get(142)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(94)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(143)).setAttribute("tipo","texto" );
      ((Element)v.get(143)).setAttribute("ID","EstDat" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */

      /* Empieza nodo:144 / Elemento padre: 142   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(144)).setAttribute("tipo","texto" );
      ((Element)v.get(144)).setAttribute("ID","EstDat2" );
      ((Element)v.get(142)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */

      /* Empieza nodo:145 / Elemento padre: 142   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(145)).setAttribute("tipo","texto" );
      ((Element)v.get(145)).setAttribute("ID","EstDat" );
      ((Element)v.get(142)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */

      /* Empieza nodo:146 / Elemento padre: 142   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(146)).setAttribute("tipo","texto" );
      ((Element)v.get(146)).setAttribute("ID","EstDat2" );
      ((Element)v.get(142)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */

      /* Empieza nodo:147 / Elemento padre: 142   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(147)).setAttribute("tipo","texto" );
      ((Element)v.get(147)).setAttribute("ID","EstDat" );
      ((Element)v.get(142)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */

      /* Empieza nodo:148 / Elemento padre: 142   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(148)).setAttribute("tipo","texto" );
      ((Element)v.get(148)).setAttribute("ID","EstDat2" );
      ((Element)v.get(142)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */

      /* Empieza nodo:149 / Elemento padre: 142   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(149)).setAttribute("tipo","texto" );
      ((Element)v.get(149)).setAttribute("ID","EstDat" );
      ((Element)v.get(142)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */

      /* Empieza nodo:150 / Elemento padre: 142   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(150)).setAttribute("tipo","texto" );
      ((Element)v.get(150)).setAttribute("ID","EstDat2" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(142)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */

      /* Empieza nodo:151 / Elemento padre: 142   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(151)).setAttribute("tipo","texto" );
      ((Element)v.get(151)).setAttribute("ID","EstDat" );
      ((Element)v.get(142)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */

      /* Empieza nodo:152 / Elemento padre: 142   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(152)).setAttribute("tipo","texto" );
      ((Element)v.get(152)).setAttribute("ID","EstDat2" );
      ((Element)v.get(142)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */

      /* Empieza nodo:153 / Elemento padre: 142   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(153)).setAttribute("tipo","texto" );
      ((Element)v.get(153)).setAttribute("ID","EstDat" );
      ((Element)v.get(142)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */

      /* Empieza nodo:154 / Elemento padre: 142   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(154)).setAttribute("tipo","texto" );
      ((Element)v.get(154)).setAttribute("ID","EstDat2" );
      ((Element)v.get(142)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:142   */

      /* Empieza nodo:155 / Elemento padre: 94   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(94)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */

      /* Empieza nodo:156 / Elemento padre: 94   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(156)).setAttribute("nombre","mipgndo2" );
      ((Element)v.get(156)).setAttribute("ancho","400" );
      ((Element)v.get(156)).setAttribute("sep","$" );
      ((Element)v.get(156)).setAttribute("x","12" );
      ((Element)v.get(156)).setAttribute("class","botonera" );
      ((Element)v.get(156)).setAttribute("y","647" );
      ((Element)v.get(156)).setAttribute("control","|" );
      ((Element)v.get(156)).setAttribute("conector","conectorSandra1" );
      ((Element)v.get(156)).setAttribute("rowset","" );
      ((Element)v.get(156)).setAttribute("cargainicial","N" );
      ((Element)v.get(94)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(157)).setAttribute("nombre","ret2" );
      ((Element)v.get(157)).setAttribute("x","37" );
      ((Element)v.get(157)).setAttribute("y","651" );
      ((Element)v.get(157)).setAttribute("ID","botonContenido" );
      ((Element)v.get(157)).setAttribute("img","retroceder_on" );
      ((Element)v.get(157)).setAttribute("tipo","0" );
      ((Element)v.get(157)).setAttribute("estado","false" );
      ((Element)v.get(157)).setAttribute("alt","" );
      ((Element)v.get(157)).setAttribute("codigo","" );
      ((Element)v.get(157)).setAttribute("accion","mipgndo2.retroceder();" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */

      /* Empieza nodo:158 / Elemento padre: 156   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(158)).setAttribute("nombre","ava2" );
      ((Element)v.get(158)).setAttribute("x","52" );
      ((Element)v.get(158)).setAttribute("y","651" );
      ((Element)v.get(158)).setAttribute("ID","botonContenido" );
      ((Element)v.get(158)).setAttribute("img","avanzar_on" );
      ((Element)v.get(158)).setAttribute("tipo","0" );
      ((Element)v.get(158)).setAttribute("estado","false" );
      ((Element)v.get(158)).setAttribute("alt","" );
      ((Element)v.get(158)).setAttribute("codigo","" );
      ((Element)v.get(158)).setAttribute("accion","mipgndo2.avanzar();" );
      ((Element)v.get(156)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:156   */
      /* Termina nodo:94   */

      /* Empieza nodo:159 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(159)).setAttribute("nombre","primera2" );
      ((Element)v.get(159)).setAttribute("x","20" );
      ((Element)v.get(159)).setAttribute("y","651" );
      ((Element)v.get(159)).setAttribute("ID","botonContenido" );
      ((Element)v.get(159)).setAttribute("img","primera_on" );
      ((Element)v.get(159)).setAttribute("tipo","0" );
      ((Element)v.get(159)).setAttribute("estado","false" );
      ((Element)v.get(159)).setAttribute("alt","" );
      ((Element)v.get(159)).setAttribute("codigo","" );
      ((Element)v.get(159)).setAttribute("accion","mipgndo2.retrocederPrimeraPagina();" );
      ((Element)v.get(6)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */

      /* Empieza nodo:160 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(160)).setAttribute("nombre","separa2" );
      ((Element)v.get(160)).setAttribute("x","59" );
      ((Element)v.get(160)).setAttribute("y","647" );
      ((Element)v.get(160)).setAttribute("ID","botonContenido" );
      ((Element)v.get(160)).setAttribute("img","separa_base" );
      ((Element)v.get(160)).setAttribute("tipo","0" );
      ((Element)v.get(160)).setAttribute("estado","false" );
      ((Element)v.get(160)).setAttribute("alt","" );
      ((Element)v.get(160)).setAttribute("codigo","" );
      ((Element)v.get(160)).setAttribute("accion","" );
      ((Element)v.get(6)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */

      /* Empieza nodo:161 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(161)).setAttribute("nombre","btnRecalcular" );
      ((Element)v.get(161)).setAttribute("x","13" );
      ((Element)v.get(161)).setAttribute("y","648" );
      ((Element)v.get(161)).setAttribute("ID","botonContenido" );
      ((Element)v.get(161)).setAttribute("tipo","html" );
      ((Element)v.get(161)).setAttribute("estado","false" );
      ((Element)v.get(161)).setAttribute("cod","978" );
      ((Element)v.get(161)).setAttribute("accion","recalcular();" );
      ((Element)v.get(161)).setAttribute("onshtab","focoBotonDetalle();" );
      ((Element)v.get(161)).setAttribute("ontab","focoBotonDetalle();" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(6)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */

      /* Empieza nodo:162 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(162)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(162)).setAttribute("alto","12" );
      ((Element)v.get(162)).setAttribute("ancho","100%" );
      ((Element)v.get(162)).setAttribute("colorf","" );
      ((Element)v.get(162)).setAttribute("borde","0" );
      ((Element)v.get(162)).setAttribute("imagenf","" );
      ((Element)v.get(162)).setAttribute("repeat","" );
      ((Element)v.get(162)).setAttribute("padding","" );
      ((Element)v.get(162)).setAttribute("visibilidad","visible" );
      ((Element)v.get(162)).setAttribute("contravsb","" );
      ((Element)v.get(162)).setAttribute("x","0" );
      ((Element)v.get(162)).setAttribute("y","670" );
      ((Element)v.get(162)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */
      /* Termina nodo:6   */


   }

}
