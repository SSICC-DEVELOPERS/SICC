<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
   INDRA/CAR/PROY
   $Id: XSLBuscarPreguntaMAE.xsl,v 1.1 2009/12/03 19:02:40 pecbazalar Exp $
   DESC
-->

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:output method="xml" indent="yes" encoding="ISO-8859-1"/>

<xsl:template match="/">
   <xsl:copy>
      <xsl:apply-templates/>
   </xsl:copy>
</xsl:template>

<xsl:template match="CONECTOR">
   <xsl:copy>
      <xsl:apply-templates/>
   </xsl:copy>
</xsl:template>

<xsl:template match="ROWSET"> 
   <xsl:copy> 
      <xsl:attribute name="ID">lista</xsl:attribute> 
     
      <xsl:for-each select="ROW"> 
         <ROW> 
         
            
            <CAMPO NOMBRE="ESTA_CO_ESTADO" TIPO="STRING"> 
               <xsl:attribute name="VALOR"> 
               <xsl:value-of select="CAMPO[@NOMBRE='ESTA_CO_ESTADO']/@VALOR"/> 
               </xsl:attribute> 
            </CAMPO> 


            <CAMPO NOMBRE="ESAP_DS_ESTADO" TIPO="STRING"> 
               <xsl:attribute name="VALOR"> 
               <xsl:value-of select="CAMPO[@NOMBRE='ESAP_DS_ESTADO']/@VALOR"/> 
               </xsl:attribute> 
            </CAMPO> 

         </ROW> 
      </xsl:for-each> 
   </xsl:copy> 
</xsl:template> 

</xsl:stylesheet>


