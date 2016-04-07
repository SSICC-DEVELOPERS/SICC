<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
   INDRA/CAR/Druida 3.0
   $Id: drd30_formulario.xsl,v 1.1 2009/12/03 19:03:44 pecbazalar Exp $
-->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">

   <!--    FORM    -->
   <!-- ********** -->

   <!--    head    -->
   <xsl:template match="FORMULARIO" mode="head">

      <xsl:variable name="rutaEntV">
         <xsl:choose>
            <xsl:when test="$vgConfig/DATOSPROY/RUTAENTORNOV">
               <xsl:value-of select="$vgConfig/DATOSPROY/RUTAENTORNOV"/>
            </xsl:when>
            <xsl:otherwise>
               <xsl:value-of select="$jsDruidaPath"/>
            </xsl:otherwise>
         </xsl:choose>
      </xsl:variable>

      <xsl:choose>
         <xsl:when test="$vgConfig/DATOSPROY/MULTIIDIOMA and $vgConfig/DATOSPROY/MULTIIDIOMA='S' and /PAGINA/@xml:lang and not(/PAGINA/@xml:lang='es')">
            <SCRIPT TYPE="text/javascript" SRC="{$rutaEntV}entornoV_{/PAGINA/@xml:lang}.js"><xsl:text> </xsl:text></SCRIPT>
         </xsl:when>
         <xsl:otherwise>
            <SCRIPT TYPE="text/javascript" SRC="{$rutaEntV}entornoV.js"><xsl:text> </xsl:text></SCRIPT>
         </xsl:otherwise>
      </xsl:choose>

      <SCRIPT TYPE="text/javascript">
         <xsl:attribute name="SRC">
            <xsl:value-of select="$jsDruidaPath"/>
            <xsl:text>valida.js</xsl:text>
         </xsl:attribute>
        <xsl:text> </xsl:text>
      </SCRIPT>

      
      <xsl:apply-templates mode="head"/>
   </xsl:template>


   <!--   init  -->
   <xsl:template match="FORMULARIO" mode="init"> 
      <xsl:apply-templates mode="init"/>
   </xsl:template>


   <!--   estilo  -->
   <xsl:template match="FORMULARIO" mode="estilo">
      <xsl:apply-templates mode="estilo"/>
   </xsl:template>


   <!--   script  -->
<!--
f1=new Object();f1.action="";
f1.date11TC='Hidden';
f1.date22TC='Hidden';
f1.SociosTC='Hidden';
f1.provinciaTNS='document.capa1.document.tabla1.provinciaT';f1.provinciaTIE='document.tabla1.provinciaT';f1.provinciaTTV="null";f1.provinciaTMV='c';f1.provinciaTSZ=1;f1.provinciaTTC='Combo';
f1.RSocioNS='document.capa1.document.tabla1.RSocio';f1.RSocioIE='document.tabla1.RSocio';f1.RSocioTV="null";f1.RSocioMV='C';f1.RSocioTC='Radio';
f1.Tipo1NS='document.capa1.document.tabla1.Tipo1';f1.Tipo1IE='document.tabla1.Tipo1';f1.Tipo1TV="null";f1.Tipo1MV='c';f1.Tipo1SZ=1;f1.Tipo1TC='Combo';
f1.Sub1NS='document.capa1.document.tabla1.Sub1';f1.Sub1IE='document.tabla1.Sub1';f1.Sub1TV="null";f1.Sub1MV='c';f1.Sub1SZ=1;f1.Sub1TC='Combo';
f1.date1NS='document.capa0.document.tabla0.date1';f1.date1IE='document.tabla0.date1';f1.date1TV="ValidaFecha('$f1.date1$','d/m/Y')";f1.date1MV='C';f1.date1TC='Texto';
f1.date2NS='document.capa0.document.tabla0.date2';f1.date2IE='document.tabla0.date2';f1.date2TV="ValidaFecha('$f1.date2$','d/m/Y')";f1.date2MV='C';f1.date2TC='Texto';

-->
   <xsl:template match="FORMULARIO" mode="script">
      <xsl:param name="nsdoc"/>
      <xsl:variable name="nsdoc-parte-local"/>
      <xsl:variable name="nsdoc-local">
         <xsl:value-of select="concat($nsdoc,$nsdoc-parte-local)"/>
      </xsl:variable>

      <xsl:text>
</xsl:text>
     <xsl:value-of select="@nombre"/>
      <xsl:text>=new Object();</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>.action="</xsl:text>
      <xsl:value-of select="$ProxyServlet"/>
      <xsl:text>";</xsl:text>

   <xsl:variable name="vOculto">
      <xsl:choose>
        <xsl:when test="@oculto"><xsl:value-of select="@oculto"/></xsl:when>
        <xsl:otherwise>N</xsl:otherwise>
      </xsl:choose> 
   </xsl:variable> 

         <xsl:value-of select="@nombre"/>
         <xsl:text>.oculto='</xsl:text>
         <xsl:value-of select="$vOculto"/>
         <xsl:text>';
 </xsl:text>

<!-- Si no hay action, se necesita la variable conectorActionOculto.  
     Ver FORMULARIOFILNAL en drd30_comunes.xsl -->
<xsl:value-of select="@nombre"/><xsl:text>.conectorActionOcultoTC="Hidden";
</xsl:text>
      
      
      
      

      <xsl:apply-templates mode="script">
         <xsl:with-param name="nsdoc">
            <xsl:value-of select="$nsdoc-local"/>
         </xsl:with-param>
      </xsl:apply-templates>
   </xsl:template>


   <!--   body  -->
   <xsl:template match="FORMULARIO" mode="body">
      <xsl:param name="nsdoc"/>
      <xsl:variable name="nsdoc-parte-local"/>
      <xsl:variable name="nsdoc-local">
         <xsl:value-of select="concat($nsdoc,$nsdoc-parte-local)"/>
      </xsl:variable>

<!--      <FORM METHOD="post">
         <xsl:attribute name="NAME">
            <xsl:value-of select="@nombre"/>
         </xsl:attribute>
         <xsl:if test="@action!=''">
            <xsl:attribute name="ACTION">
               <xsl:value-of select="@action"/>
            </xsl:attribute>
         </xsl:if> -->
         <xsl:apply-templates mode="body">
            <xsl:with-param name="nsdoc">
               <xsl:value-of select="$nsdoc-local"/>
            </xsl:with-param>
         </xsl:apply-templates>

<!--      </FORM> -->
   </xsl:template>

</xsl:stylesheet>

