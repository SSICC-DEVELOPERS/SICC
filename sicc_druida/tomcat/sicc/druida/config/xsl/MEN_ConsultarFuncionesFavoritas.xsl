<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output version="1.0" encoding="ISO-8859-1" omit-xml-declaration="no" method="xml" indent="yes"/>
         <xsl:template match="//ROWSET2">
                  <ROWSET2>
                           <xsl:apply-templates select="@*"></xsl:apply-templates>
                           <xsl:apply-templates select="./ROWSET[@ID='dtoSalida.resultado_ROWSET']"></xsl:apply-templates>
                  </ROWSET2>
         </xsl:template>

         <xsl:template match="ROWSET" >
                  <xsl:copy>
                           <xsl:apply-templates select="@*"></xsl:apply-templates>
				<xsl:apply-templates select="./ROW" ></xsl:apply-templates>
                  </xsl:copy>
         </xsl:template>
         <xsl:template match="ROW">
                  <xsl:copy>
                           <xsl:apply-templates select="@*"></xsl:apply-templates>
                           <xsl:element name="CAMPO">
                                    <xsl:attribute name="NOMBRE">idFuncion</xsl:attribute>
                                    <xsl:attribute name="TIPO">STRING</xsl:attribute>
				    <xsl:value-of select="CAMPO[position()=1]"></xsl:value-of>
                           </xsl:element>
                           <xsl:if test="CAMPO[position()=5]">
	                           <xsl:apply-templates select="CAMPO[position()=2]"></xsl:apply-templates>
                           </xsl:if>
                  </xsl:copy>
         </xsl:template>

 
         <xsl:template match="CAMPO" >
                  <xsl:copy-of select="."></xsl:copy-of>
         </xsl:template>

         <xsl:template match="@*">
                  <xsl:copy></xsl:copy>
         </xsl:template>

</xsl:stylesheet>


