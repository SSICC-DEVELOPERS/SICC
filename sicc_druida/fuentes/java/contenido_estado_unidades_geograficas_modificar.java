
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_estado_unidades_geograficas_modificar  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_estado_unidades_geograficas_modificar" );
      ((Element)v.get(0)).setAttribute("titulo","Modificar estado de unidades geográficas" );
      ((Element)v.get(0)).setAttribute("cod","0359" );
      ((Element)v.get(0)).setAttribute("estilos","estilos.css" );
      ((Element)v.get(0)).setAttribute("colorf","white" );
      ((Element)v.get(0)).setAttribute("msgle","Modificar estado de unidades geográficas" );
      ((Element)v.get(0)).setAttribute("onload","LoadBar()" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("STYLE"));
      ((Element)v.get(2)).setAttribute("TYPE","text/css" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));

      /* Elemento padre:2 / Elemento actual: 3   */
      v.add(doc.createTextNode("\r.treelistcontrol {\r   font-family: microsoft sans serif, verdana;\r   font-size: 8pt;\r   position: relative;\r   border: 2px inset;\r   background-color: white;\r}\r\r.tlc_headings {\r   position:relative;\r   font-family: Arial, Helvetica, sans-serif; \r   font-size: 9pt; \r   font-weight: bold; \r   color: #000000; \r      background-color: threedface;\r   border: 1px outset;\r   border-top: 0px solid white;\r   border-left: 0px solid white;\r   height:16px;\r}\r\r.tlc_columnheading {\r   font-size: 8pt;\r   position: absolute;\r   background-color: threedface;\r   border: 1px outset;\r   border-top: 1px solid white;\r   border-left: 1px solid white;\r   padding-left: 2px;\r   padding-bottom: 1px;\r}\r\r.tlc_node {\r   position: relative;\r}\r\r.tlc_node_row {\r   position: relative;\r   border-top: 1px dotted #EEEEEE;\r   background-color: #F0F0F0; \r   font-family: Arial, Helvetica, sans-serif; \r   font-size: 9pt; \r   font-weight: bold; \r   color: #000000; \r   height:16px;\r}\r\r.tlc_node_row_hover {\r   position: relative;\r   border-top: 1px dotted #EEEEEE;\r   background-color: #F0F0F0; \r   font-family: Arial, Helvetica, sans-serif; \r   font-size: 9pt; \r   font-weight: bold; \r   color: #000000;\r   height:16px;\r}\r\r.tlc_node_row_click {\r   position: relative;\r   border-top: 1px dotted #EEEEEE;\r   background-color: darkblue;\r   font-weight: bold; \r   color: white;\r   height:16px;\r}\r\r.tlc_node_text {\r   position: absolute;\r   height: 16px;\r   vertical-align: middle;\r   overflow: hidden;\r   padding-left: 2px;\r   white-space: nowrap;\r}\r\r.tlc_node_children {\r}\r\r"));
      ((Element)v.get(2)).appendChild((Text)v.get(3));

      /* Termina nodo Texto:3   */
      /* Termina nodo:2   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Elemento padre:4 / Elemento actual: 5   */
      v.add(doc.createTextNode("\r\rvar formName = 'frmContenido';\rvar unidades = \"\";\rvar loading = false;\rvar varNoLimpiarSICC = true;\r\rTreeListControlHandler = {\r   nextID               : 0,\r   getUniqueID          : function() { return this.nextID++; },\r   allTrees             : new Array(),\r   preventRowClick      : false,\r   callExpand           : function(treeID, nodeID) { this.allTrees[treeID].allNodes[nodeID].expand(); },\r   callCollapse         : function(treeID, nodeID) { this.allTrees[treeID].allNodes[nodeID].collapse(); },\r   callRowClick         : function(treeID, nodeID) { this.allTrees[treeID].allNodes[nodeID].click(); },\r   callCheckBoxes       : function(treeID, nodeID) { this.allTrees[treeID].allNodes[nodeID].recalcCheckBoxes(); },   \r   imgConnectMore       : 'cn_more.gif',\r   imgConnectEnd        : 'cn_end.gif',\r   imgConnectBridge     : 'cn_bridge.gif',\r   imgHandleCollapseMore   : 'hdl_coll_more.gif',\r   imgHandleCollapseEnd : 'hdl_coll_end.gif',\r   imgHandleExpandMore  : 'hdl_exp_more.gif',\r   imgHandleExpandEnd   : 'hdl_exp_end.gif',\r   imgEmpty             : 'vacio.gif',\r   imgIconDefault       : 'carpeta.gif',  \r   xmlHTTPStateChange   : function(treeID, nodeID) { this.allTrees[treeID].allNodes[nodeID].xmlCallback(); }\r}\r\rfunction createXMLstrByArray(arr) {\r  var xml = \"\";\r  if(arr != \"\") {\r     xml = \"<ROWSET>\";\r     for(var i = 0; i < arr.length;i++) {\r         xml += \"<ROW>\";\r         for(var j = 0; j < arr[i].length;j++) {\r            xml += \"<CAMPO>\" + arr[i][j] + \"</CAMPO>\";\r         }\r         xml += \"</ROW>\";\r     }\r     xml += \"</ROWSET>\";\r  }\r  return xml;\r}\r\rfunction loadFirstNodeByArray(arr) {\r      if(arr != \"\") {\r      var xDoc = createXMLstrByArray(arr);\r      set(formName + '.hidNode',xDoc); \r      firstDoc = new ActiveXObject(\"Microsoft.XMLDOM\");\r      firstDoc.loadXML(xDoc); \r      if(firstDoc.readyState == 4) {\r           var xmlDocElem = firstDoc.documentElement;\r           var parentNodes = 0;\r           if(xmlDocElem.hasChildNodes()) {                     \r               var node = xmlDocElem.firstChild;         \r            while(node != null)  {\r                       /*\r                          OID_VALO_ESTR_GEOP  - 0\r                          COD_UNID_GEOG       - 1\r                          DES_GEOG            - 2\r                          IND_ACTI            - 3\r                          COD_NSE1            - 4\r                          COD_NSE2            - 5\r                          COD_NSE3            - 6\r                          COD_POST            - 7\r                          UBIGEO              - 8\r                       */\r                  _nodeTree = new TreeListControlNode(false, null, 'invalid.text',node.childNodes[0].text);\r                  _nodeTree.setText('',node.childNodes[0].text,node.childNodes[2].text, node.childNodes[4].text,node.childNodes[5].text,node.childNodes[6].text,node.childNodes[7].text);\r                  _nodeTree.checked = node.childNodes[3].text;\r                  _nodeTree.loaded_base = node.childNodes[3].text;\r                  _nodeTree.ubigeo = node.childNodes[8].text;\r                  tree.add(_nodeTree);\r                  node = node.nextSibling;\r            }     \r         }\r         tree.allNodes[2].remove();\r         tree.allNodes[4].remove();\r         document.getElementById(\"treelistcontrol0\").style.display = \"block\";\r         set(formName + '.hidNode','');\r      }\r   }else{ /*alert(\"Return null: [No hay registros en la tabla o error en servidor]\");*/  }\r}\r\rfunction LoadBar() { \r    var correcto = chequeaErrores();\r    \r    configurarMenuSecundario(formName);\r\r    if (correcto) {\r                               asignar([['LISTA', '', 'ConectorDTZON', 'dtoSalida.resultado_ROWSET', 'ConectorConsultaUnidadesGeograficasEstado|xxx','loadFirstNodeByArray(datos);']], '', '');\r              getById(\"s_23\").innerHTML = getLabelById(\"e794\"); \r       getById(\"s_24\").innerHTML = getLabelById(\"e1137\"); \r       getById(\"s_25\").innerHTML = getLabelById(\"e243\") + \"1\";\r       getById(\"s_26\").innerHTML = getLabelById(\"e243\") + \"2\";\r       getById(\"s_27\").innerHTML = getLabelById(\"e243\") + \"3\";\r       getById(\"s_28\").innerHTML = getLabelById(\"e1344\");\r	   \r	       }\r}\r\rfunction getById(id){ return document.getElementById(id); }\rfunction getLabelById(id) { return getById(id).children[0].children[0].children[0].children[0].innerText; }\rfunction chequeaErrores() {\r         var codigoError = get(formName + \".errCodigo\");\r         var descError = get(formName + \".errDescripcion\");\r         if (codigoError == \"\") {\r               return true;\r         } else   {\r               fMostrarMensajeError(codigoError, descError);\r                              \r               return false;\r         }\r }\r\rvar ob = new Object();\r\rfunction TreeListControl(sRootLabel, sIconSrc, hideColumnHeadings, hideRootNode) {\r   this.ID                 = TreeListControlHandler.getUniqueID();\r   TreeListControlHandler.allTrees[this.ID] = this;\r   this.all             = new Array(); \r   this.allNodes           = new Array(); \r   this.columns            = new Array();\r   this.rootNode           = new TreeListControlNode(true, sIconSrc, null, 1);\r   this.rootNode.columnText[0]   = sRootLabel;\r   this.rootNode.depth        = 0;\r   this.rootNode.bShowHandle  = false;\r   this.rootNode.oTree        = this;\r   this.allNodes[this.rootNode.ID] = this.rootNode;\r   this.rendered           = false;\r   this.nLabelColumn       = 0; \r   this.iconPath           = '/sicc/es/img/zon/';\r   this.showColumnHeadings    = hideColumnHeadings ? false : true;\r   this.showRootNode       = hideRootNode ? false : true;\r   this.disableRecalc         = false;\r}\r\rTreeListControl.prototype.toString = function() {\r   var str, x;\r   str = '';\r   x = 0;\r   for(var i=0; i<this.columns.length; i++) {\r      str += '<div class=\"tlc_columnheading\" style=\"width:' + this.columns[i].width + 'px; left:' + x + 'px; ' +\r            ' \">' + this.columns[i].name + \"</div>\";\r      x += this.columns[i].width;\r   }\r   	str = '<div id=\"treelistcontrol' + this.ID + '\" class=\"treelistcontrol\" style=\"width: 100%;' +\r        'top: 0px; display: none;\"><div class=\"tlc_headings\" style=\"display:expression(TreeListControlHandler.allTrees[' + this.ID +\r            '].showColumnHeadings ? \\'block\\' : \\'none\\');\">' + str + '</div>' + this.rootNode + '</div>';\r   this.rendered = true;\r   return str;\r}\r\rTreeListControl.prototype.redraw = function() { }\r\rTreeListControl.prototype.add = function(oNode) {\r   this.rootNode.add(oNode);\r}\r\rTreeListControl.prototype.addColumn = function(oColumn) {\r   this.columns[this.columns.length] = oColumn;\r}\r\rfunction TreeListControlColumn(width, name, onclickdisabled) {\r   this.name = name;\r   this.width = width ? width : '100';\r   this.onclickdisabled = onclickdisabled ? true : false;  \r}\r\rfunction TreeListControlNode(bShowChildren, sIconSrc, sXMLSrc, refKey) {\r   this.columnText         = new Array();\r   this.ckKeys           = new Array();\r   this.checked         = 0;\r   this.ubigeo          = \"\";\r   this.loaded_base        = 0;\r   this.bShowChildren      = bShowChildren ? true : false;\r   this.sIconSrc        = sIconSrc ? sIconSrc : null;\r   this.sXMLSrc         = (typeof(sXMLSrc) == 'string') ? sXMLSrc : '';\r   this.bDynamicNode    = this.sXMLSrc.length > 0 ? true : false; \r   this.bShowHandle     = true; \r   this.refKey          = (refKey || refKey == 0) ? refKey : null;\r   this.ID              = TreeListControlHandler.getUniqueID();            \r   this.sImages         = '';\r   this.sHandle         = '';\r   this.onclick         = '';\r   this.onclickCheckBox = '';\r   this.stage            = 0;\r   this.stageCounter    = 0;\r   this.useIcon         = true;\r   this.nextSibling     = null;\r   this.previousSibling = null;\r   this.firstChild      = null;\r   this.lastChild       = null;\r   this.parentNode      = null;\r   this.oTree           = null;\r   this.rendered        = false;\r   this.nodes           = 0;   \r}\r\rTreeListControlNode.prototype.toString = function() {\r   var str = '<div class=\"tlc_node\" id=\"tlcnode' + this.ID + '\">';\r   str += '<div class=\"tlc_node_row\" onmouseenter=\"this.className=\\'tlc_node_row_hover\\'\"' +\r         ' onmouseleave=\"this.className=\\'tlc_node_row\\';\" style=\"cursor:default;' +\r         (this.parentNode == null ? 'display:expression(TreeListControlHandler.allTrees[' + this.oTree.ID +\r            '].showRootNode ? \\'block\\' : \\'none\\');' : '') + '\" onclick=\"if(!TreeListControlHandler.preventRowClick) { ' + this.onclick + ' }\"' +\r         ' onmousedown=\"if(!TreeListControlHandler.preventRowClick) this.className=\\'tlc_node_row_click\\';\" onmouseup=\"this.className=\\'tlc_node_row_hover\\';\">';\r   var c = this.oTree.columns;\r   var x = 0;\r   for(var i=0; i<c.length; i++) {\r      str += '<div class=\"tlc_node_text\" style=\"width:' + c[i].width + 'px; left:' + x + 'px;\"' +\r            (c[i].onclickdisabled ? ' onmouseenter=\"TreeListControlHandler.preventRowClick=true;\" onmouseleave=\"TreeListControlHandler.preventRowClick=false;\"' : '' )+ '>';\r      if(this.oTree.nLabelColumn == i) {\r         if(!this.oTree.disableRecalc) this.recalcImages();\r         str += '<span>';          str += this.sImages + this.sHandle + '<img src=\"' + (this.sIconSrc ? this.sIconSrc : this.oTree.iconPath + TreeListControlHandler.imgIconDefault) + '\" width=\"16\" height=\"16\" align=\"absmiddle\">';\r         str += '</span>&nbsp;';\r      }\r      if(i == 1) {\r        var chk = \"\";\r        if(this.checked == \"1\") chk = \"checked\";        \r        str += '<span><input type=\"checkbox\" id=\"'+(this.columnText[i] ? this.columnText[i] : '&nbsp;')+'\" nodes=\"0\" onclick=\"TreeListControlHandler.callCheckBoxes('+this.oTree.ID+','+this.ID+');\" tree_node=\"\" '+chk+'></input></span></div>';\r      }else{\r        str += '<span>' + (this.columnText[i] ? this.columnText[i] : '&nbsp;') + '</span></div>';\r      }\r      x += c[i].width;\r   }\r   str += '</div><div id=\"children' + this.ID + '\" class=\"tlc_node_children\" style=\"display:' + ((this.bShowChildren && this.firstChild) ? 'block' : 'none') + '\">';\r   var node = this.firstChild;\r   while(node) {\r      str += node;\r      node = node.nextSibling;\r   }\r   str += \"</div></div>\";\r   this.rendered = true\r   return str;\r}\r\rTreeListControlNode.prototype.recalcImages = function() {\r   var h = TreeListControlHandler;\r   this.sImages = '';\r   if(this.parentNode) {\r      if(this.parentNode.parentNode) {\r         this.sImages = this.parentNode.sImages;\r         this.sImages += '<img src=\"' + this.oTree.iconPath +\r                     (this.parentNode.nextSibling ? h.imgConnectBridge : h.imgEmpty) +\r                     '\" width=\"16\" height=\"16\" align=\"absmiddle\">';\r      }\r      if(this.firstChild || this.bDynamicNode) {\r         if(this.bShowChildren && !this.bDynamicNode) {\r            this.sHandle = '<img src=\"' + this.oTree.iconPath +\r                        (this.nextSibling ? h.imgHandleCollapseMore : h.imgHandleCollapseEnd) +\r                         '\" style=\"cursor:hand;\"' +\r                        ' width=\"16\" height=\"16\" align=\"absmiddle\" onmouseenter=\"TreeListControlHandler.preventRowClick=true;\" onmouseleave=\"TreeListControlHandler.preventRowClick=false;\"' +\r                        ' onclick=\"TreeListControlHandler.callCollapse(' +\r                        this.oTree.ID + ',' + this.ID + ');\">';\r         } else {\r            this.sHandle = '<img src=\"' + this.oTree.iconPath +\r                        (this.nextSibling ? h.imgHandleExpandMore : h.imgHandleExpandEnd) +\r                         '\" style=\"cursor:hand;\"' +\r                        ' width=\"16\" height=\"16\" align=\"absmiddle\"' +\r                        ' onmouseenter=\"TreeListControlHandler.preventRowClick=true;\"' +\r                        ' onmouseleave=\"TreeListControlHandler.preventRowClick=false;\"' +\r                        ' onclick=\"TreeListControlHandler.callExpand(' +\r                        this.oTree.ID + ',' + this.ID + ');\">';\r         }\r      } else {\r         this.sHandle = '<img src=\"' + this.oTree.iconPath +\r                     (this.nextSibling ? h.imgConnectMore : h.imgConnectEnd) +\r                     '\" width=\"16\" height=\"16\" align=\"absmiddle\">';\r      }\r   }\r   if(this.rendered) {\r      var o = document.all['tlcnode'+this.ID].firstChild.childNodes[this.oTree.nLabelColumn].firstChild;\r      o.innerHTML = this.sImages + this.sHandle + (this.useIcon ? '<img src=\"' + (this.sIconSrc ? this.sIconSrc : this.oTree.iconPath + TreeListControlHandler.imgIconDefault) + '\" width=\"16\" height=\"16\" align=\"absmiddle\">' : '');\r   }\r}\r\rTreeListControlNode.prototype.recalcChildImages = function() {\r   var node = this.firstChild;\r   while(node) {\r      node.recalcImages();\r      node.recalcChildImages();\r      node = node.nextSibling;\r   }\r}\r\rTreeListControlNode.prototype.expand = function() {\r  if(!loading) {\r   this.bShowChildren = true;\r   var o = document.all['tlcnode' + this.ID];    \r   o.lastChild.style.display = 'block';\r   var id1 = this.oTree.ID;\r   var id2 = this.ID;\r   if(!this.oTree.disableRecalc) this.recalcImages();\r   if(this.bDynamicNode) {\r      document.all['tlcnode' + this.ID].firstChild.className = 'tlc_node_row';\r      this.bDynamicNode = false;    \r      ob = this;        \r      searchNivel(this.refKey);\r   }else{        var bool = (document.getElementById(this.refKey).checked == false)?true:false;\r      for(var s = 0; s < this.nodes; s++) {\r         if(bool) document.getElementById(this.ckKeys[s]).checked = (!bool);\r         document.getElementById(this.ckKeys[s]).disabled = bool;       \r      }\r   }\r  }\r}\r\rfunction searchNivel(csv_orde) {\r      loading = true;\r      asignar([['LISTA', '', 'ConectorDTZON', 'dtoSalida.resultado_ROWSET', 'ConectorConsultaUnidadesGeograficasEstado|' + csv_orde,'loadNode(datos);']], '', '');\r}\r\rfunction loadNode(arr) {\r          /*\r        OID_VALO_ESTR_GEOP  - node.childNodes[0].text\r        COD_UNID_GEOG       - node.childNodes[1].text\r        DES_GEOG            - node.childNodes[2].text\r        IND_ACTI            - node.childNodes[3].text\r        COD_NSE1            - node.childNodes[4].text\r        COD_NSE2            - node.childNodes[5].text\r        COD_NSE3            - node.childNodes[6].text\r        COD_POST            - node.childNodes[7].text\r        ubigeo              - node.childNodes[8].text;\r     */\r    var xDocument = createXMLstrByArray(arr);\r    if(xDocument != null && xDocument != \"\") {\r      var nodeResult = new ActiveXObject(\"Microsoft.XMLDOM\");\r      nodeResult.loadXML(xDocument);        \r      if(nodeResult.readyState == 4) {\r      var xmlDocElem = nodeResult.documentElement;\r      var parentNodes = 0;\r        if(xmlDocElem.hasChildNodes()) {                     \r            var node = xmlDocElem.firstChild;         \r         while(node != null)  {\r             var b = node.childNodes.length; \r            var subNode = node.firstChild;            \r            while(subNode != null) {            \r               strKey += subNode.text;\r               var ssNode = subNode.firstChild;\r               var i = 0;\r               var strKey = \"\";                  \r               subNode = subNode.nextSibling;\r            }\r             var o;\r             var rKey = \"\";\r             var modes = 'invalid.text';\r               if(ob.stage == 9) {\r                     o = new TreeListControlNode(false,null,null,node.childNodes[0].text);\r                     o.setText('',node.childNodes[0].text,node.childNodes[2].text,node.childNodes[4].text,node.childNodes[5].text,node.childNodes[6].text,node.childNodes[7].text);\r               }else{\r                  o = new TreeListControlNode(false,null,'invalid.text',node.childNodes[0].text);\r                  o.setText('',node.childNodes[0].text,node.childNodes[2].text,node.childNodes[4].text,node.childNodes[5].text,node.childNodes[6].text,node.childNodes[7].text);\r                  o.sXMLSrc = '<rowset id=\"data_' + node.childNodes[0].text + '\" oid=\"'+node.childNodes[0].text+'\" activo=\"'+node.childNodes[3].text+'\" ubigeo=\"' +  node.childNodes[8].text + '\" />';\r                  o.checked = node.childNodes[3].text;\r                  o.loaded_base = node.childNodes[3].text;\r                  o.ubigeo = node.childNodes[8].text;\r               }             \r               o.stage = ob.stage + 1;\r               ob.ckKeys[parentNodes] = node.childNodes[0].text;            \r                ob.add(o);\r                /* PARA CASO CONSULTAR */\r                /* document.getElementById(node.childNodes[0].text).disabled = true; */\r               if(!document.getElementById(ob.refKey).checked) {\r                     o.checked = 0;\r                document.getElementById(o.refKey).checked = false;\r                document.getElementById(node.childNodes[0].text).disabled = true;\r               }\r               parentNodes++;\r               node = node.nextSibling;\r         }     \r      }\r         ob.nodes = parentNodes;\r         document.getElementById(ob.refKey).nodes = parentNodes;\r         ob.recalcImages();\r         loading = false;\r      }\r   }else{\r      ob.sXMLSrc = null;\r      ob.collapse();\r      ob.recalcImages();\r      ob.recalcChildImages();\r      loading = false;\r   }  \r}\rvar d = 0;\rTreeListControlNode.prototype.cleanCheckBoxes = function(obj, bool) {   \r      for(i = 0; i < obj.nodes; i++) {\r        if(bool) document.getElementById(obj.ckKeys[i]).checked = (!bool);\r        document.getElementById(obj.ckKeys[i]).disabled = bool;\r      }\r      for(i = 0; i < obj.nodes; i++) {\r        if(bool) {\r               var node = obj.firstChild;\r               if(this.stageCounter != 6) {\r                      this.stageCounter++;                 \r                       while(node != null) {\r                           this.cleanCheckBoxes(node,bool);\r                        node = node.nextSibling;\r                      }  \r               }\r             }\r      }  \r}\r\rTreeListControlNode.prototype.recalcCheckBoxes = function() {\r   var bool = (document.getElementById(this.refKey).checked == false)?true:false;\r   with (this) {\r       checked = (bool)?0:1;\r      stageCounter = 0;\r      cleanCheckBoxes(this,bool);\r   }\r}\r\rTreeListControlNode.prototype.callCheckBoxes = function(){ }\r\rTreeListControlNode.prototype.collapse = function() {\r   this.bShowChildren = false;\r   var o = document.all['tlcnode' + this.ID];\r   o.lastChild.style.display = 'none';\r   var img = o.childNodes[0].childNodes[this.oTree.nLabelColumn].firstChild.lastChild.previousSibling;\r   var id1 = this.oTree.ID;\r   var id2 = this.ID;\r   img.onclick = function() { TreeListControlHandler.callExpand(id1, id2); return false; };\r   img.src = this.oTree.iconPath + (this.nextSibling ? TreeListControlHandler.imgHandleExpandMore : TreeListControlHandler.imgHandleExpandEnd);\r}\r\rTreeListControlNode.prototype.click = function() { }\rTreeListControlNode.prototype.setText = function() {\r   for(var i=0; i<arguments.length; i++)\r      this.setColumnText(i, arguments[i]);\r}\r\rTreeListControlNode.prototype.setColumnText = function(nColumn, sText) {\r   this.columnText[nColumn] = (sText ? sText : '');\r   if(this.rendered) {\r      var o = document.all['tlcnode' + this.ID];\r      o.firstChild.childNodes[nColumn].lastChild.innerHTML = this.columnText[nColumn];\r   }\r}\r\rTreeListControlNode.prototype.add = function(oNode, bNoRedraw, oSibling, bInsertAfter) {\r   if(bNoRedraw) this.oTree.disableRecalc = true;\r   this.bDynamicNode = false;\r   oNode.oTree = this.oTree;\r   oNode.parentNode = this;\r   if(oNode.refKey || oNode.refKey == 0) this.oTree.all[oNode.refKey] = oNode;\r   this.oTree.allNodes[oNode.ID] = oNode;\r   if(!this.firstChild) {\r      this.firstChild = oNode;\r      this.lastChild = oNode;\r   } else {\r      var node1, node2;\r      if(oSibling) {\r         if(bInsertAfter) {\r            node1 = oSibling;\r            node2 = oSibling.nextSibling;\r         } else {\r            node1 = oSibling.previousSibling;\r            node2 = oSibling;\r         }\r      } else {\r         node1 = this.lastChild;\r         node2 = null;\r      }\r      if(node1) {\r         oNode.previousSibling = node1;\r         node1.nextSibling = oNode;\r      } else {\r         this.firstChild = oNode;\r      }\r      if(node2) {\r         oNode.nextSibling = node2;\r         node2.previousSibling = oNode;\r      } else {\r         this.lastChild = oNode;\r      }\r   }\r   if(this.oTree.rendered) {\r      var oSib;\r      var html = oNode + '';\r      var oParent = document.all['tlcnode' + this.ID];\r      if(node1) {\r         oSib = document.all['tlcnode' + node1.ID];\r         oSib.insertAdjacentHTML('afterEnd', html);\r      } else if(node2) {\r         oSib = document.all['tlcnode' + node2.ID];\r         oSib.insertAdjacentHTML('beforeBegin', html);\r      } else {\r         oParent.lastChild.innerHTML = html;\r      }\r      if(this.parentNode) this.expand();\r      if(!node2 && node1) {\r         node1.recalcImages();\r         node1.recalcChildImages();\r      }\r   }\r   if(bNoRedraw) this.oTree.disableRecalc = false;\r}\r\rTreeListControlNode.prototype.insertBefore = function(oNode, bNoRedraw) {\r   this.parentNode.add(oNode, bNoRedraw, this, false);\r}\r\rTreeListControlNode.prototype.insertAfter = function(oNode, bNoRedraw) {\r   this.parentNode.add(oNode, bNoRedraw, this, true);\r}\r\rTreeListControlNode.prototype.remove = function() {\r   this.removeChildren();\r   var node1 = this.previousSibling;\r   var node2 = this.nextSibling;\r   if(node1)\r      node1.nextSibling = node2;\r   else\r      this.parentNode.firstChild = node2;\r   if(node2)\r      node2.previousSibling = node1;\r   else\r      this.parentNode.lastChild = node1;\r   this.oTree.allNodes[this.ID] = null;\r   if(this.refKey != null) this.oTree.all[this.refKey] = null;\r   var p = document.all['tlcnode' + this.ID].parentElement;\r   document.all['tlcnode' + this.ID].removeNode(true);\r   if(this.rendered && this.previousSibling && !this.nextSibling) {\r      this.previousSibling.recalcImages();\r      this.previousSibling.recalcChildImages();\r   }\r   if(!this.parentNode.firstChild) {\r      this.parentNode.recalcImages();\r      p.style.display = 'none';\r   }\r   this.rendered = false;\r   this.parentNode = null;\r   this.nextSibling = null;\r   this.previousSibling = null;\r   this.firstChild = null;\r   this.lastChild = null;\r   return this;\r}\r\rTreeListControlNode.prototype.removeChildren = function() {\r   var node = this.firstChild;\r   while(node) {\r      node.removeChildren();\r      this.oTree.allNodes[node.ID] = null;\r      var dead = node;\r      node = node.nextSibling;\r      delete dead;\r   }\r}\r\rTreeListControlNode.prototype.xmlCallback = function() {\r   var failed;\r   if(this.xmlhttp.readyState == 4)\r      if(this.xmlhttp.status==0) {\r         var xml = new ActiveXObject(\"Microsoft.XMLDOM\");\r         if(xml.loadXML(this.xmlhttp.responseText)) {\r            failed = false;\r            this.firstChild.remove();\r            if(xml.documentElement) {\r               this.addXMLChildNodes(xml.documentElement, this);\r            }\r            this.recalcImages();\r         } else {\r            failed = true;\r         }\r      } else {\r         failed = true;\r      }\r      if(failed) {\r         this.firstChild.setColumnText(this.oTree.nLabelColumn, '<span style=\"color:red\">Unavailable - ' + this.xmlhttp.status + '</span>');\r         this.firstChild.useIcon = false;\r         this.firstChild.recalcImages();\r      }\r}\r\rTreeListControlNode.prototype.addXMLChildNodes = function(xml, oParent) {\r   var showchildren, refkey, xmlsrc, onclick, iconsrc;\r   if(xml.childNodes.length > 0) {\r      var x = xml.lastChild;\r      while(x) {\r         showchildren = x.getAttribute('showchildren');\r         if(!showchildren) showchildren = false;\r         else showchildren = (showchildren == 'yes' ? true : false);\r         refkey = x.getAttribute('refkey');\r         if(!refkey) refkey = null;\r         xmlsrc = x.getAttribute('xmlsrc');\r         if(!xmlsrc) xmlsrc = null;\r         onclick = x.getAttribute('onclick');\r         if(!onclick) onclick = null;\r         iconsrc = x.getAttribute('iconsrc');\r         if(!iconsrc) iconsrc = null;\r         var node = new TreeListControlNode(showchildren, iconsrc, xmlsrc, refkey);\r         node.onclick = onclick;\r         for(var i=0; i<x.childNodes.length-1; i++)\r            node.setColumnText(i,x.childNodes[i].firstChild.nodeValue+'');\r         if(oParent.firstChild)\r            oParent.firstChild.insertBefore(node);\r         else\r            oParent.add(node);\r         if(x.lastChild.childNodes.length > 0)\r            this.addXMLChildNodes(x.lastChild, node)\r         x = x.previousSibling;\r      }\r   }\r}\r\rfunction getResultDocument() {\r   _stageCounter = 1;\r   sResult = '<rowset2 id=\"root\">\\n';\r   var xmlDocElem = firstDoc.documentElement;\r   if(xmlDocElem.hasChildNodes()) {\r      var cnt = 8;\r      var node = xmlDocElem.firstChild;         \r      while(node != null)  {\r         if(tree.allNodes[cnt].checked == 1) {           \r            sResult += '\\t<rowset OID=\"'+tree.allNodes[cnt].refKey+'\" ACTIVO=\"1\" ACTIVO_LOADED=\"'+tree.allNodes[cnt].loaded_base+'\" UBIGEO=\"' + tree.allNodes[cnt].ubigeo + '\" >\\n';\r            var _node_1 = tree.allNodes[cnt].firstChild;\r            if(_node_1 != null) {\r              while(_node_1 != null) {           \r                 d++;\r                 _rAddNode(_node_1);\r                  _node_1 = _node_1.nextSibling;\r                 }\r            }\r               sResult += '\\t</rowset>\\n';\r         } else {\r               sResult += '\\t<rowset OID=\"'+tree.allNodes[cnt].refKey+'\" ACTIVO=\"0\" ACTIVO_LOADED=\"'+tree.allNodes[cnt].loaded_base+'\" UBIGEO=\"' + tree.allNodes[cnt].ubigeo + '\" />\\n';\r         }         \r            cnt++;\r         node = node.nextSibling;\r      }     \r   }\r   sResult += '</rowset2>';\r   return sResult;\r}\r\rvar _stageCounter;\rvar sResult = \"\";\rvar csv_druida_grabara = \"\";\rvar d = 0;\rfunction _rAddNode(node) {\r   var space = \"\";\r   if( d == 1) _stageCounter++; \r   for(var sp = 0;sp < _stageCounter;sp++) {          \r            space += \"\\t\";   \r   }\r   if(node.checked == 1) {           \r    sResult += space + '<rowset OID=\"'+node.refKey+'\" ACTIVO=\"1\" ACTIVO_LOADED=\"'+node.loaded_base+'\" UBIGEO=\"' + node.ubigeo + '\" >\\n';                   \r    var next_node = node.firstChild;    \r    if(next_node != null) {\r        d = 0;\r       while(next_node != null) {\r         d++;\r        _rAddNode(next_node);      \r        next_node = next_node.nextSibling;\r       }\r    }\r    sResult += space + '</rowset>\\n';\r   } else {      \r    sResult += space + '<rowset OID=\"'+node.refKey+'\" ACTIVO=\"0\" ACTIVO_LOADED=\"'+node.loaded_base+'\" UBIGEO=\"' + node.ubigeo + '\"/>\\n';\r   }\r}\r\rfunction fGuardar() {\r  unidades = getResultDocument();\r    set(formName + '.hidEstadoUnidades', unidades );\r  set(formName + '.conectorAction', 'LPModificarEstadoUnidadGeografica');\r  set(formName + '.accion','Modificar');  \r  set(formName + '.casoDeUso','Modificar');\r  get(formName + '.exito','');\r  enviaSICC(formName);\r}\r\rfunction fLimpiar() {\r   set(formName + '.conectorAction', 'LPModificarEstadoUnidadGeografica');\r   set(formName + '.accion','limpiar');  \r   set(formName + '.casoDeUso','Modificar');\r   get(formName + '.exito','');\r   enviaSICC(formName);\r}\r\rfunction fVolver() {}\r\rtree = new TreeListControl('UBIGEOTree', '');\rtree.addColumn ( new TreeListControlColumn(1, '') );\rtree.addColumn ( new TreeListControlColumn(38, '<span id=\"s_23\"></span>', true) );\rtree.addColumn ( new TreeListControlColumn(360,'<span id=\"s_24\"></span>') );\rtree.addColumn ( new TreeListControlColumn(40, '<span id=\"s_25\"></span>') );\rtree.addColumn ( new TreeListControlColumn(40, '<span id=\"s_26\"></span>') );\rtree.addColumn ( new TreeListControlColumn(40, '<span id=\"s_27\"></span>') );\rtree.addColumn ( new TreeListControlColumn(80, '<span id=\"s_28\"></span>') );\rtree.rootNode.setText('','chk_root','UBIGEOTree','','?');\rtree.showRootNode = (!tree.showRootNode);\rtree.nLabelColumn = 2;\rvar node = new TreeListControlNode(true);\rnode.setText('.','chk_1','....','....','....');\rtree.add(node);\rvar node2 = new TreeListControlNode(false, null, null);\rnode2.setText('','chk_9','....','....','....');\rnode.add(node2);\rvar node3 = new TreeListControlNode(true);\rnode3.setText('.','chk_2','....','....','....');\rnode.insertBefore(node3);\rvar node4 = new TreeListControlNode(true);\rnode4.setText('.','chk_3','....','....','....');\rnode2.insertBefore(node4);\rvar node5 = new TreeListControlNode(true);\rnode5.setText('','chk_4','....','....','....');\rnode4.add(node5);\rvar node6 = new TreeListControlNode(true);\rnode6.setText('','chk_5','....','....','....');\rnode3.add(node6);\rdocument.write(tree);\r\r\r\r"));
      ((Element)v.get(4)).appendChild((Text)v.get(5));

      /* Termina nodo Texto:5   */
      /* Termina nodo:4   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(6)).setAttribute("id","frmContenido" );
      ((Element)v.get(6)).setAttribute("nombre","frmContenido" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","accion" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","conectorAction" );
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
      ((Element)v.get(11)).setAttribute("nombre","hidPais" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","hidNode" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","hidEstadoUnidades" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","exito" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(15)).setAttribute("nombre","CAPITA" );
      ((Element)v.get(15)).setAttribute("alto","202" );
      ((Element)v.get(15)).setAttribute("ancho","200" );
      ((Element)v.get(15)).setAttribute("colorf","" );
      ((Element)v.get(15)).setAttribute("borde","0" );
      ((Element)v.get(15)).setAttribute("imagenf","" );
      ((Element)v.get(15)).setAttribute("repeat","" );
      ((Element)v.get(15)).setAttribute("padding","" );
      ((Element)v.get(15)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(15)).setAttribute("contravsb","" );
      ((Element)v.get(15)).setAttribute("x","0" );
      ((Element)v.get(15)).setAttribute("y","124" );
      ((Element)v.get(15)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(15));

      /* Empieza nodo:16 / Elemento padre: 15   */
      v.add(doc.createElement("DIV"));
      ((Element)v.get(16)).setAttribute("id","div_labels" );
      ((Element)v.get(15)).appendChild((Element)v.get(16));

      /* Empieza nodo:17 / Elemento padre: 16   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(17)).setAttribute("nombre","e243" );
      ((Element)v.get(17)).setAttribute("cod","243" );
      ((Element)v.get(17)).setAttribute("id","datosTitle" );
      ((Element)v.get(16)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 16   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(18)).setAttribute("nombre","e100" );
      ((Element)v.get(18)).setAttribute("cod","357" );
      ((Element)v.get(18)).setAttribute("id","datosTitle" );
      ((Element)v.get(16)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 16   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(19)).setAttribute("nombre","e794" );
      ((Element)v.get(19)).setAttribute("cod","794" );
      ((Element)v.get(19)).setAttribute("id","datosTitle" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(16)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 16   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(20)).setAttribute("nombre","e1344" );
      ((Element)v.get(20)).setAttribute("cod","1344" );
      ((Element)v.get(20)).setAttribute("id","datosTitle" );
      ((Element)v.get(16)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 16   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(21)).setAttribute("nombre","e1137" );
      ((Element)v.get(21)).setAttribute("cod","1137" );
      ((Element)v.get(21)).setAttribute("id","datosTitle" );
      ((Element)v.get(16)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */
      /* Termina nodo:16   */
      /* Termina nodo:15   */
      /* Termina nodo:6   */


   }

}
