<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
   <xsl:output version="1.0" encoding="ISO-8859-1" omit-xml-declaration="no" method="xml" indent="yes"/> 
   <xsl:strip-space elements="*" /> 
   <xsl:key name="ids" match="ROW" use="CAMPO[@NOMBRE='lineaProducto']" />   
   <xsl:template match="/CONECTOR">
      <xsl:copy>
         <xsl:copy-of select="@*" />
	 <ROWSET2>
           <ROWSET ID="dtoSalida.resultado_ROWSET">
	     <xsl:apply-templates select="ROWSET2/ROWSET/ROW"/>
	   </ROWSET>
	 </ROWSET2>
      </xsl:copy>
   </xsl:template>
   <xsl:template match="ROW">
      
      <xsl:if test="generate-id(key('ids',./CAMPO[@NOMBRE='lineaProducto'])[1])=generate-id(.)">
         <xsl:copy>
            <xsl:copy-of select="@*" /> 
            <xsl:apply-templates/>
         </xsl:copy>
      </xsl:if>
   </xsl:template>
   <xsl:template match="CAMPO">
      <xsl:copy>
         <xsl:copy-of select="@*" /> 
         <xsl:apply-templates/>
      </xsl:copy> 
   </xsl:template>
</xsl:stylesheet>