<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
   INDRA/CAR/Druida 3.0
   $Id: drd30_tabla.xsl,v 1.1 2009/12/03 19:03:45 pecbazalar Exp $
-->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">

   <!--    TABLA    -->
   <!-- ********** -->

   <!--    head    -->
   <xsl:template match="TABLA" mode="head">
      <xsl:apply-templates mode="head"/>
   </xsl:template>


   <!--   estilo  -->
   <xsl:template match="TABLA" mode="estilo">
      <xsl:apply-templates mode="estilo"/>
   </xsl:template>


   <!--   script  -->
   <xsl:template match="TABLA" mode="script">
      <xsl:param name="nsdoc"/>
      <xsl:variable name="nsdoc-parte-local">
<!--         <xsl:value-of select="concat('.',@nombre,'.document')"/> -->
         <xsl:value-of select="concat('.',@nombre)"/>
      </xsl:variable>
      <xsl:variable name="nsdoc-local">
         <xsl:value-of select="concat($nsdoc,$nsdoc-parte-local)"/>
      </xsl:variable>

      <xsl:text>
</xsl:text>

      <xsl:value-of select="@nombre"/>
      <xsl:text>=new Object();</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>.TC='Tabla';</xsl:text>

      <!--
      <xsl:apply-templates select="descendant::TEXT |
                                   descendant::CTEXTO |
                                   descendant::AREATEXTO |
                                   descendant::CHECKBOX |
                                   descendant::SELECT |
                                   descendant::COMBO |
                                   descendant::RADIOB" mode="script">
      -->
      <xsl:apply-templates mode="script">
         <xsl:with-param name="nsdoc">
            <xsl:value-of select="$nsdoc-local"/>
         </xsl:with-param>
      </xsl:apply-templates>
   </xsl:template>



   <!--   body  -->
   <xsl:template match="TABLA" mode="body">
      <xsl:param name="nsdoc"/>
      <xsl:variable name="nsdoc-parte-local">
         <xsl:value-of select="concat('.',@nombre)"/>
      </xsl:variable>
      <xsl:variable name="nsdoc-local">
         <xsl:value-of select="concat($nsdoc,$nsdoc-parte-local)"/>
      </xsl:variable>

      
      <TABLE>
         <!-- atributos de TABLE. Copia todos los atributos que trae TABLA excepto -nombre-
              Estos atributos serán los propios de HTML:TABLE -->
         <xsl:copy-of select="@*[not(local-name()='nombre')]" />

         <FORM ACTION="javascript:;">
            <xsl:attribute name="NAME">
               <xsl:value-of select="@nombre"/>
            </xsl:attribute>

            <xsl:apply-templates mode="body">
               <xsl:with-param name="nsdoc">
                  <xsl:value-of select="$nsdoc-local"/>
               </xsl:with-param>
            </xsl:apply-templates>

         </FORM>

      </TABLE>
   </xsl:template>

</xsl:stylesheet>

