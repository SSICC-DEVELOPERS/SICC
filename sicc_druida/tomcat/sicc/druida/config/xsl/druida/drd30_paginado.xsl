<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
   INDRA/CAR/Druida 3.0
   $Id: drd30_paginado.xsl,v 1.1 2009/12/03 19:03:46 pecbazalar Exp $
-->


<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

<!--           -->
<!--   HEAD    -->   
<!--           -->

<xsl:template match="PAGINADO" mode="head">
   <SCRIPT TYPE="text/javascript">
      <xsl:attribute name="SRC">
         <xsl:value-of select="$jsDruidaPath"/>
         <xsl:text>d3pag.js</xsl:text>
      </xsl:attribute>
      <xsl:text> </xsl:text>
   </SCRIPT>
   <xsl:apply-templates mode="head" />   
</xsl:template>

<!--           -->
<!--  SCRIPT   -->   
<!--           -->
<xsl:template match="PAGINADO" mode="script">
      <xsl:param name="nsdoc"/>

      <xsl:value-of select="@nombre"/>
      <xsl:text>=new Paginado('</xsl:text><xsl:value-of select="@nombre"/><xsl:text>','</xsl:text><xsl:value-of select="@sep"/><xsl:text>','</xsl:text><xsl:value-of select="../@nombre"/><xsl:text>','</xsl:text><xsl:value-of select="BOTON[1]/@nombre"/><xsl:text>','</xsl:text><xsl:value-of select="BOTON[2]/@nombre"/><xsl:text>','</xsl:text><xsl:value-of select="@cargainicial"/><xsl:text>','</xsl:text><xsl:value-of select="@labelPag"/><xsl:text>','</xsl:text><xsl:value-of select="@labelUltima"/><xsl:text>');
</xsl:text>

   <xsl:if test="@onload">
      <xsl:value-of select="@nombre"/>
      <xsl:text>.funcion="</xsl:text><xsl:value-of select="@onload"/><xsl:text>";
</xsl:text>
         </xsl:if>

   <xsl:if test="@valores and string-length(@valores)>0">
      <xsl:value-of select="@nombre"/>
      <xsl:text>.valores="</xsl:text><xsl:value-of select="@valores"/><xsl:text>";
</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>.ir1="N";
</xsl:text>
         </xsl:if>


  <xsl:if test="@msjUltima and string-length(@msjUltima)>0">
      <xsl:value-of select="@nombre"/>
      <xsl:text>.msjUltima="</xsl:text><xsl:value-of select="@msjUltima"/><xsl:text>";
</xsl:text>
         </xsl:if>

      <xsl:apply-templates mode="script">
         <xsl:with-param name="nsdoc">
            <xsl:value-of select="$nsdoc"/>
         </xsl:with-param>
      </xsl:apply-templates>

</xsl:template>


<!--           -->
<!--   INIT    -->   
<!--           -->

<xsl:template match="PAGINADO" mode="init">
      <!-- Introduce en el array de componentes para DruidaBack sus datos -->
      <xsl:text>d3_componentes[d3_componentes.length]=['</xsl:text>
      <xsl:value-of select="name()"/>
      <xsl:text>','</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>'];</xsl:text>

   <xsl:if test="not($pGeneroHTML='S')">
      <xsl:value-of select="@nombre"/><xsl:text>.init();</xsl:text>
   </xsl:if>

   <xsl:apply-templates mode="init"/>
</xsl:template>

<!--           -->
<!--  BODY     -->   
<!--           -->
<xsl:template match="PAGINADO" mode="body">
    <xsl:apply-templates mode="body"/> 
</xsl:template>


<xsl:template match="PAGINADO" mode="dinamico">
    <xsl:text>&#xa;DrMainEstatico.</xsl:text>
    <xsl:value-of select="@nombre"/>
    <xsl:text>_form.paginado_control.value='</xsl:text>
    <xsl:value-of select="@control"/>
    <xsl:text>';</xsl:text>
    <xsl:text>&#xa;DrMainEstatico.</xsl:text>
    <xsl:value-of select="@nombre"/>
    <xsl:text>_form.paginado_conector.value='</xsl:text>
    <xsl:value-of select="@conector"/>
    <xsl:text>';</xsl:text>
    <xsl:text>&#xa;DrMainEstatico.</xsl:text>
    <xsl:value-of select="@nombre"/>
    <xsl:text>_form.paginado_idrowset.value='</xsl:text>
    <xsl:value-of select="@rowset"/>
    <xsl:text>';</xsl:text>

    <xsl:text>&#xa;DrMainEstatico.</xsl:text>
    <xsl:value-of select="@nombre"/>
    <xsl:text>.init();</xsl:text>
    <xsl:text>;</xsl:text>

    <xsl:apply-templates mode="dinamico"/>
</xsl:template>


<xsl:template name="FORMULARIOFINALPAGINADO">
      <TABLE border="0" cellspaceng="0" cellpadding="0">
         <TR><TD>
         <FORM name="{@nombre}_form" METHOD="post" action="{$vgConfig/DATOSPROY/PROXYSERVLET}?ON=ObjetoPaginado">
            <INPUT TYPE="hidden" NAME="paginado_nombre" VALUE="{@nombre}"/>
            <INPUT TYPE="hidden" NAME="paginado_indice" VALUE=""/>
            <INPUT TYPE="hidden" NAME="paginado_control" VALUE="{@control}"/>
            <INPUT TYPE="hidden" NAME="paginado_conector" VALUE="{@conector}"/>
            <INPUT TYPE="hidden" NAME="paginado_idrowset" VALUE="{@rowset}"/>
            <xsl:text>&#xa;</xsl:text>
         </FORM>
         </TD></TR>
      </TABLE>

</xsl:template>

</xsl:stylesheet>

