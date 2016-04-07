<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">

   <!--    FORM    -->
   <!-- ********** -->

   <!--    head    -->
   <xsl:template match="FORM" mode="head">
      <xsl:call-template name="TRAZA">
         <xsl:with-param name="text" select="head"/>
      </xsl:call-template>

      <xsl:apply-templates mode="head"/>
   </xsl:template>


   <!--   estilo  -->
   <xsl:template match="FORM" mode="estilo">
      <xsl:call-template name="TRAZA">
         <xsl:with-param name="text" select="estilo"/>
      </xsl:call-template>
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
   <xsl:template match="FORM" mode="script">
      <xsl:call-template name="TRAZA">
         <xsl:with-param name="text" select="script"/>
      </xsl:call-template>
      <xsl:text>
</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>= new Object();</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>.action='</xsl:text>
      <xsl:value-of select="@action"/>
      <xsl:text>';</xsl:text>

      <xsl:apply-templates mode="script-elem-form"/>
      <xsl:apply-templates mode="script"/>
   </xsl:template>


   <!--   body  -->
   <xsl:template match="FORM" mode="body">
      <xsl:call-template name="TRAZA">
         <xsl:with-param name="text" select="body"/>
      </xsl:call-template>

<!--      <FORM METHOD="post">
         <xsl:attribute name="NAME">
            <xsl:value-of select="@nombre"/>
         </xsl:attribute>
         <xsl:if test="@action!=''">
            <xsl:attribute name="ACTION">
               <xsl:value-of select="@action"/>
            </xsl:attribute>
         </xsl:if> -->
         <xsl:apply-templates mode="body"/>
<!--      </FORM> -->
   </xsl:template>

</xsl:stylesheet>

