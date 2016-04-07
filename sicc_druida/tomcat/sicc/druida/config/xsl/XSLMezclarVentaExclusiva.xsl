<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
   <xsl:output encoding="ISO-8859-1" method="xml" omit-xml-declaration="yes"/>
   <xsl:strip-space elements="*" /> 
   <xsl:key name="ids" match="ROW" use="CAMPO[@NOMBRE='PK']" />   
   <xsl:template match="/CONECTOR">
      <xsl:copy>
         <xsl:copy-of select="@*" />        
         <ROWSET ID="dtoSalida.resultado_ROWSET">
	   <xsl:apply-templates select="ROWSET2/ROWSET/ROW"/>
	 </ROWSET>
      </xsl:copy>
   </xsl:template>
   <xsl:template match="ROW">
      
      <xsl:if test="generate-id(key('ids',./CAMPO[@NOMBRE='PK'])[1])=generate-id(.)">
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