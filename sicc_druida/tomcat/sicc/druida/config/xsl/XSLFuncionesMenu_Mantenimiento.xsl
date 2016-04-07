<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
	$Id: XSLFuncionesMenu_Mantenimiento.xsl,v 1.1 2009/12/03 19:02:30 pecbazalar Exp $
-->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  	<xsl:output method="xml" version="1.0" encoding="iso-8859-1" indent="no" omit-xml-declaration="no"/>
	<xsl:template match="/">
		<table style="table-layout:fixed; border-collapse:collapse" cellpadding="0" cellspacing="0" width="100%" id="menu" name="tblMenu">
			<colgroup>
				<col width="5%" style="text-align:right;padding-right:2px"></col>
				<col width="5%" style="text-align:left;padding-left:2px"></col>
				<col width="5%"></col><col width="5%"></col>
				<col width="5%"></col><col width="5%"></col>
				<col width="5%"></col><col width="5%"></col>
				<col width="5%"></col><col width="5%"></col>
				<col width="5%"></col><col width="5%"></col>
				<col width="5%"></col><col width="5%"></col>
				<col width="5%"></col><col width="5%"></col>
				<col width="5%"></col><col width="5%"></col>
				<col width="5%"></col><col width="5%"></col>
			</colgroup>
			<tbody>
            <xsl:for-each select="//ROW[CAMPO[@NOMBRE='idfuncion']!=2 and CAMPO[@NOMBRE='jerarquia']!=2]">
               <xsl:variable name="jerarquia">
                  <xsl:value-of select="number(CAMPO[@NOMBRE='nivel'])+1"/>
               </xsl:variable>
               <tr>
                  <xsl:attribute name="class">
                     <xsl:choose>
                        <xsl:when test="number($jerarquia)=0">
                           <xsl:text>menu</xsl:text>
                        </xsl:when>
                        <xsl:when test="number($jerarquia)=1">
                           <xsl:text>menu1</xsl:text>
                        </xsl:when>
                        <xsl:when test="number($jerarquia)=2">
                           <xsl:text>menu2</xsl:text>
                        </xsl:when>
                        <xsl:when test="number($jerarquia)=3">
                           <xsl:text>menu3</xsl:text>
                        </xsl:when>
                        <xsl:when test="number($jerarquia)=4">
                           <xsl:text>menu4</xsl:text>
                        </xsl:when>               
                        <xsl:otherwise>
                           <xsl:text>menu5</xsl:text>
                        </xsl:otherwise>
                     </xsl:choose>
                  </xsl:attribute>
                  <td colspan="{$jerarquia}">
                     <xsl:choose>
                        <xsl:when test="number(CAMPO[@NOMBRE='nodofinal'])=0">
                           <input type="radio" name="inputSeleccionado" value="{CAMPO[@NOMBRE='idfuncion']}"/>
                        </xsl:when>
                        <xsl:otherwise>
                           <xsl:text disable-output-escaping="yes"> </xsl:text>
                        </xsl:otherwise>
                     </xsl:choose>
                  </td>
                  <td colspan="{20-number($jerarquia)}">
                     <xsl:if test="number(CAMPO[@NOMBRE='nodofinal'])=0">
                        <xsl:text>\ </xsl:text>
                     </xsl:if>
                     <xsl:value-of select="CAMPO[@NOMBRE='nombrefuncion']" disable-output-escaping="yes"/>
                  </td>
               </tr>
            </xsl:for-each>
			</tbody>
		</table>
	</xsl:template>
</xsl:stylesheet>
