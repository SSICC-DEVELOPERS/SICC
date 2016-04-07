<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
   INDRA/CAR/sicc
   $Id: sicc.xsl,v 1.1 2009/12/03 19:02:36 pecbazalar Exp $
   Plantillas propias del proyecto
-->

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

   <xsl:template match="TABLEDIT" mode="estilo">
		.button { font-size:10; }
      body,table,form {background-color: white; margin: 0px 0px 0px 0px; text-align:left;font-family:Verdana, Arial, Helvetica; font-size: 10px;}
   </xsl:template> 


   <xsl:template match="TABLEDIT" mode="body">
   <xsl:variable name="vNombreTE" select="@nombre"/>

			<form name="{$vNombreTE}" id="{$vNombreTE}">
			   <xsl:variable name="onclickaddrow">
               <xsl:apply-templates select="PRESENTACION" mode="addrow"/>
            </xsl:variable>
				<INPUT class="button" id="Button1" onclick="{$onclickaddrow}" type="button" value="Add article" name="Button1"/>
				<input type="button" value="Delete article" onclick="deleter()" class="button" name="del" id="del"/>
				<br/>
				<table id="{$vNombreTE}_table" border="1">
					<TBODY>
				     <xsl:apply-templates select="CABECERA" mode="body"/>
					</TBODY>
				</table>
				<br/>
<!--			<input type="button" onclick="values()" value="values" class="button" ID="Button2" NAME="Button2"/>	-->
		   	<input type="hidden" name="count" ID="Hidden1"/>
		   	<input type="hidden" name="lst_list" ID="Hidden1"/>
			</form>
			<script language="javascript">
var max = 10 //maximum rows
var color = "red";
var selected_row = 0;

<![CDATA[
document.write ("\<\script language='JavaScript'>");
for(i=1;i<(max + 1);i++)
]]>
{
 funct_name = "funct_row" + i;
 document.write ("function " + funct_name +"()");
 document.write ("{");
 document.write ("end_color();");
 row_name = "row" + i;
 document.write (row_name+".style.backgroundColor='"+color+"';");
 document.write ("selected_row = "+ i +";");
 document.write ("}");
}
<![CDATA[
  document.write ("<\/script>");
]]>

function end_color()
{
 if (selected_row != 0)
 {
  object = eval("row"+selected_row);
  object.style.backgroundColor ='white';
 }
}

function setcolor()
{
  index = 'row1';
  object = eval(index);
  object.style.backgroundColor = "red";
}

   <xsl:apply-templates select="PRESENTACION" mode="addrowdef"/>
{
 // count the number of rows from a table
 numrows = document.all.<xsl:value-of select="$vNombreTE"/>_table.rows.length;
 if (numrows == max + 1)
 {
   alert("You can only add "+ max + " articles!");
 }
 else
 {
   var newRow = document.all.<xsl:value-of select="$vNombreTE"/>_table.insertRow(numrows);
   document.<xsl:value-of select="$vNombreTE"/>.count.value = numrows;

   <xsl:apply-templates select="PRESENTACION" mode="body"/>


   <xsl:value-of select="$vNombreTE"/>_table.rows.item(numrows).id = "row" + numrows;
   <xsl:value-of select="$vNombreTE"/>_table.rows.item(numrows).name = "row" + numrows;
   funct_name = eval("funct_row" + numrows);
   row_name = eval("row"+numrows);
   row_name.attachEvent("onclick",funct_name);
 }
}

function deleter()
{
 numrows = document.all.<xsl:value-of select="$vNombreTE"/>_table.rows.length;
 if (numrows != 1)
 {
   if(selected_row == 0)
   {
     <xsl:value-of select="$vNombreTE"/>_table.deleteRow(numrows-1);
     document.<xsl:value-of select="$vNombreTE"/>.count.value = numrows - 2;
   }
   else
   {
     getval(selected_row);
     <xsl:value-of select="$vNombreTE"/>_table.deleteRow(selected_row);
     changef(selected_row);
     document.<xsl:value-of select="$vNombreTE"/>.count.value = numrows - 2;
   }
 }
  selected_row = 0;
}

function changef(index)
{
 numrows = document.all.<xsl:value-of select="$vNombreTE"/>_table.rows.length;
 numrows = numrows + 1;
<![CDATA[for(i = index + 1;i<numrows;i++)]]>
 {
  plus = i+1
  min = i-1;
  row_name = eval("row" + i);
<![CDATA[
  row_name.cells(0).innerHTML = "<b><center>"+ min +"<center></b>";
]]>
  row_name2 = "row" + min;
  funct_name = eval("funct_row" + i);
  row_name.detachEvent("onclick",funct_name);
  row_name.name = row_name2;
  row_name.id = row_name2;
  funct_name = eval("funct_row" + min);
  row_name2 = eval(row_name2);
  row_name2.attachEvent("onclick",funct_name);
 }
}

function getval(index)
{
 numrows = document.all.<xsl:value-of select="$vNombreTE"/>_table.rows.length;
 numrows = numrows -1;
<![CDATA[
 for (i = index;i < numrows;i++)
]]>
 {
  obj_list = eval("document.<xsl:value-of select="$vNombreTE"/>.lst_list" + i);
  obj_list2 = eval("document.<xsl:value-of select="$vNombreTE"/>.lst_list" + (i+1));
  obj_count = eval("document.<xsl:value-of select="$vNombreTE"/>.txt_count" + i);
  obj_count2 = eval("document.<xsl:value-of select="$vNombreTE"/>.txt_count" + (i+1));
  obj_list.options[obj_list2.options.selectedIndex].selected = true;
  obj_count.value = obj_count2.value;
  
 }
 for (i = numrows ;i > index;i--)
 {
  row_name = eval("row" + (i-1));
  row_name2 = eval("row" + i);
  row_name2.cells(1).innerHTML = row_name.cells(1).innerHTML
  row_name2.cells(2).innerHTML = row_name.cells(2).innerHTML
 }
}


function values()
{
 numrows = document.all.<xsl:value-of select="$vNombreTE"/>_table.rows.length;
 str = "";
 str += "count = " + document.<xsl:value-of select="$vNombreTE"/>.count.value +"\n";
<![CDATA[
 for(i=1;i<numrows;i++)
]]>
 {
  obj_list = eval("document.<xsl:value-of select="$vNombreTE"/>.lst_list"+i);
  obj_count = eval("document.<xsl:value-of select="$vNombreTE"/>.txt_count"+i);
  str += obj_list.name + ": "+ obj_list.options[obj_list.selectedIndex].text+"    "+obj_count.name+": "+obj_count.value+"\n";
 }
 alert(str);
}
	   <xsl:apply-templates select="ROWSET/ROW" mode="addrow"/>
	</script>
			<!-- end Source -->

  </xsl:template> 


  <xsl:template match="TABLEDIT/CABECERA" mode="body">
    <tr id="tr1"><xsl:apply-templates  mode="body"/></tr>
  </xsl:template>

  <xsl:template match="TABLEDIT/CABECERA/COL" mode="body">
    <td><b><xsl:value-of select="."/></b></td>
  </xsl:template> 

  <xsl:template match="TABLEDIT/PRESENTACION" mode="body">
    <xsl:apply-templates mode="body"/>
  </xsl:template>
  
  <xsl:template match="TABLEDIT/PRESENTACION/TETEXT" mode="body">
    inner = <![CDATA[ "<input type='text'";]]>
    <xsl:if test="@style">inner += "' style='<xsl:value-of select="@style"/>'";</xsl:if>
    <xsl:if test="@id">inner += "' id='<xsl:value-of select="@id"/>'";</xsl:if>
    <xsl:if test="@onclick">inner += "' onclick='"+<xsl:value-of select="@onclick"/>+"'";</xsl:if>
    <xsl:if test="@size">inner += "' size='<xsl:value-of select="@size"/>'";</xsl:if>
    <xsl:if test="@max">inner += "' max='<xsl:value-of select="@max"/>'";</xsl:if>
    <xsl:if test="@valor">inner += "' value='"+<xsl:value-of select="@nombre"/>+"'";</xsl:if>

    name = "<xsl:value-of select="@nombre"/>" + numrows;
    inner += " name='"+name+"'>";
    (newRow.insertCell()).innerHTML = inner;
  </xsl:template>

  
  <xsl:template match="TABLEDIT/PRESENTACION/TECOMBO" mode="body" priority="-1">
    inner = <![CDATA[ "<select ";]]>
    <xsl:if test="@style">inner += "' style='<xsl:value-of select="@style"/>'";</xsl:if>
    <xsl:if test="@id">inner += "' id='<xsl:value-of select="@id"/>'";</xsl:if>
    <xsl:if test="@onclick">inner += "' onclick='"+<xsl:value-of select="@onclick"/>+"'";</xsl:if>
    <xsl:if test="@onchange">inner += "' onchange='"+<xsl:value-of select="@onchange"/>+"'";</xsl:if>
    name = "<xsl:value-of select="@NOMBRE"/>" + numrows;
    inner += " name='"+name+"'>";
    <xsl:apply-templates select="ROWSET/ROW" mode="body"/>
    <![CDATA[inner += "</select>";]]>
    (newRow.insertCell()).innerHTML = inner;
  </xsl:template> 
   
  <xsl:template match="TABLEDIT/PRESENTACION/TECOMBO/ROWSET/ROW" mode="body">
    inner += "<option><xsl:value-of select="CAMPO"/></option>";
  </xsl:template>

  <xsl:template match="TABLEDIT/PRESENTACION" mode="addrowdef">
  function addrow(<xsl:apply-templates select="TETEXT|TECOMBO" mode="addrowdef"/>)</xsl:template>

  <xsl:template match="TABLEDIT/PRESENTACION/*" mode="addrowdef">
   <xsl:if test="position()>1">,</xsl:if><xsl:value-of select="@nombre"/>
  </xsl:template>

  <xsl:template match="TABLEDIT/PRESENTACION" mode="addrow">addrow(<xsl:apply-templates select="TETEXT|TECOMBO" mode="addrow"/>);</xsl:template>
  <xsl:template match="TABLEDIT/PRESENTACION/*" mode="addrow"><xsl:if test="position()>1">,</xsl:if>'<xsl:value-of select="@valor"/>'</xsl:template>

  <xsl:template match="TABLEDIT/ROWSET/ROW" mode="addrow">addrow(<xsl:apply-templates select="CAMPO" mode="addrow"/>);</xsl:template>
  <xsl:template match="TABLEDIT/ROWSET/ROW/CAMPO" mode="addrow"><xsl:if test="position()>1">,</xsl:if>'<xsl:value-of select="."/>'</xsl:template>


</xsl:stylesheet>


