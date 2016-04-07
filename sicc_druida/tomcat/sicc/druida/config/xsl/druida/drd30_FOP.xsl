<?xml version="1.0" encoding="iso-8859-1"?>
<!DOCTYPE xsl:stylesheet [
    <!ENTITY aacute "&#225;">
    <!ENTITY copy   "&#169;">
    <!ENTITY nbsp   "&#x00A0;">
  ]>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fo="http://www.w3.org/1999/XSL/Format"
                version="1.1">

<xsl:output method="xml" indent="yes"/>

<xsl:include href="misc.xslt"/>
<xsl:include href="fo-pages.xsl"/>
<xsl:variable name="version">$Id: drd30_FOP.xsl,v 1.1 2009/12/03 19:03:44 pecbazalar Exp $</xsl:variable>

<xsl:template match="/">
    <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
	<xsl:comment>Estoy en root 1</xsl:comment>
        <fo:layout-master-set>
            <xsl:call-template name="paginas"/>
        </fo:layout-master-set>
	<xsl:comment>Estoy en root 2</xsl:comment>
	<xsl:apply-templates/>
	<xsl:comment>Estoy en root 3</xsl:comment>
    </fo:root>
</xsl:template>

<xsl:template match="INFORME">
	<xsl:comment>Estoy en INFORME 1</xsl:comment>
	<xsl:apply-templates/>
</xsl:template>


<xsl:template match="ROWSET2">	
	<xsl:comment>Estoy en rowset2</xsl:comment>
    <fo:page-sequence master-reference="contents">

    <fo:static-content flow-name="CABPAGIZQ">
        <fo:table>
            <fo:table-column column-width="7cm"/>
            <fo:table-column column-width="8.5cm"/>
            <fo:table-body>
                <fo:table-row>
                    <fo:table-cell>
                        <fo:block font-family="Times" font-size="10pt"
                            text-align="start" color="#7C7C7C">
                            INFORME
                        </fo:block>
                    </fo:table-cell>
                    <fo:table-cell>
                        <fo:block font-family="Times" font-size="10pt"
                                  text-align="end" color="#7C7C7C">
                            <xsl:value-of select="CABART/TITULO"/>
                        </fo:block>
                    </fo:table-cell>
                </fo:table-row>
            </fo:table-body>
        </fo:table>
        <fo:block>
            <fo:leader leader-pattern="rule" leader-length="15.5cm" color="#7C7C7C"/>
        </fo:block>
    </fo:static-content>

    <fo:static-content flow-name="CABPAGDER">
        <fo:table>
            <fo:table-column column-width="7cm"/>
            <fo:table-column column-width="8.5cm"/>
            <fo:table-body>
                <fo:table-row>
                    <fo:table-cell>
                        <fo:block font-family="Times" font-size="10pt"
                                  text-align="start" color="#7C7C7C">
                            <xsl:value-of select="CABART/TITULO"/>
                        </fo:block>
                    </fo:table-cell>
                    <fo:table-cell>
                        <fo:block font-family="Times" font-size="10pt"
                            text-align="end" color="#7C7C7C">
                            INFORME
                        </fo:block>
                    </fo:table-cell>
                </fo:table-row>
            </fo:table-body>
        </fo:table>
        <fo:block>
            <fo:leader leader-pattern="rule" leader-length="15.5cm" color="#7C7C7C"/>
        </fo:block>
    </fo:static-content>

    <fo:static-content flow-name="PPAGIZQ">
        <fo:block>
            <fo:leader leader-pattern="rule" leader-length="15.5cm" color="#7C7C7C"/>
        </fo:block>
        <fo:table>
            <fo:table-column column-width="5cm"/>
            <fo:table-column column-width="5.5cm"/>
            <fo:table-column column-width="5cm"/>
            <fo:table-body>
                <fo:table-row>
                    <fo:table-cell>
                        <fo:block font-family="Times" font-size="10pt"
                                  text-align="start" color="#7C7C7C">
                            P&aacute;gina <fo:page-number/>
                        </fo:block>
                    </fo:table-cell>
                    <!-- <fo:table-cell>
                        <fo:block text-align="end">
                            <fo:external-graphic src="logowww.gif"
                                width="92px" height="39px"/> 
                        </fo:block>
                    </fo:table-cell>
                    <fo:table-cell>
                        <fo:block font-family="Times" font-size="10pt"
                                  text-align="end" color="#7C7C7C">
                            Amigos de Serrablo
                        </fo:block>
                    </fo:table-cell> -->
                </fo:table-row>
            </fo:table-body>
        </fo:table>
    </fo:static-content>

    <fo:static-content flow-name="PPAGDER">
        <fo:block>
            <fo:leader leader-pattern="rule" leader-length="15.5cm" color="#7C7C7C"/>
        </fo:block>
        <fo:table>
            <fo:table-column column-width="5cm"/>
            <fo:table-column column-width="5.5cm"/>
            <fo:table-column column-width="5cm"/>
            <fo:table-body>
                <fo:table-row>
                    <fo:table-cell>
                        <fo:block font-family="Times" font-size="10pt"
                                  text-align="end" color="#7C7C7C">
                            P&aacute;gina <fo:page-number/>
                        </fo:block>
                    </fo:table-cell>
                </fo:table-row>
            </fo:table-body>
        </fo:table>
    </fo:static-content>

        <fo:flow flow-name="xsl-region-body">

            <fo:block font-family="Helvetica"
                      font-size="18pt"
                      text-align="start"
                      space-after="15pt"
                      color="#400080">
                <xsl:attribute name="id">
                    <xsl:value-of select="generate-id()"/>
                </xsl:attribute>
                -TITULO-<xsl:value-of select="CABART/TITULO"/>
            </fo:block>

            <fo:block font-family="Helvetica"
                      font-size="16pt"
                      text-align="start"
                      space-after="15pt"
                      color="#400080">
                -SUBTITULO-<xsl:value-of select="CABART/SUBTITULO"/>
            </fo:block>

            <xsl:for-each select="CABART/AUTOR">
                <fo:block font-family="Times-Roman"
                          font-size="14pt"
                          text-align="end"
                          color="#400080"
                          space-after="4pt">
                    -NOMBRE- <xsl:value-of select="NOMBRE"/>
                    <xsl:text> </xsl:text>
                    -APELLIDOS- <xsl:value-of select="APELLIDOS"/>
                </fo:block>
            </xsl:for-each>

            <xsl:apply-templates/>

        </fo:flow>

 </fo:page-sequence>
</xsl:template>

    <xsl:template match="ROWSET">
	<xsl:comment>Estoy en rowset 1</xsl:comment>
        <fo:block>

            <!-- NodeSet con el numero de columnas por fila -->
            <xsl:variable name="vNumColxFila">
                <xsl:for-each select="ROW">
                    <F><xsl:value-of select="count(CAMPO)"/></F>
                </xsl:for-each>
            </xsl:variable>

            <!-- Numero maximo de Columnas -->
            <!-- <xsl:variable name="vMaxCol">
                <xsl:for-each select="$vNumColxFila/F">
                    <xsl:sort select="." data-type="number" order="descending"/>
                    <xsl:if test="position() = 1">
                        <xsl:value-of select="."/>
                    </xsl:if>
                </xsl:for-each>
            </xsl:variable> -->

	    <xsl:variable name="vMaxCol">11</xsl:variable>

            <fo:table>
               <xsl:for-each select = "tam/CAMPO">
                       <fo:table-column column-width="{@longitud}cm"/>
               </xsl:for-each> 


                <fo:table-header>
                    <fo:table-row>
                        <fo:table-cell number-columns-spanned="{$vMaxCol}">
                            <fo:block font-family="Times-Roman"
                                      font-size="11pt"
                                      text-align="start"
                                      space-after="4pt">
                                -Cabecera-<xsl:value-of select="@ID"/>
                            </fo:block>
                        </fo:table-cell>
                    </fo:table-row>
                </fo:table-header>

                <fo:table-footer>
                    <fo:table-row>
                        <fo:table-cell number-columns-spanned="{$vMaxCol}">
                            <fo:block font-family="Times-Roman"
                                      font-size="11pt"
                                      text-align="start"
                                      space-after="4pt">
                                -pie-<xsl:apply-templates select="TPIE"/>
                            </fo:block>
                        </fo:table-cell>
                    </fo:table-row>

                </fo:table-footer>

                <fo:table-body>
                <xsl:for-each select="ROW">
                        <xsl:variable name="colorf">
                           <xsl:choose>
                           	<xsl:when test="position() mod 2 = 1">#EBB99F</xsl:when> 
                           	<xsl:otherwise>white</xsl:otherwise> 
                           </xsl:choose> 
                        </xsl:variable>

                    <fo:table-row background-color="{$colorf}">
                        <xsl:apply-templates />
                    </fo:table-row>

                </xsl:for-each>

                </fo:table-body>

            </fo:table>

        </fo:block>

    </xsl:template>

    <!-- plantilla recursiva para establecer las columnas de la tabla -->
    <xsl:template name="FOCOLS">
        <xsl:param name="vCol"/>
        <xsl:param name="vLong"/>
         
        <fo:table-column column-width="{$vLong}cm"/>

        <xsl:if test="$vCol > 1">
            <xsl:call-template name="FOCOLS">
                <xsl:with-param name="vCol" select="$vCol - 1"/>
                <xsl:with-param name="vLong" select="$vLong"/>
            </xsl:call-template>
        </xsl:if>

    </xsl:template>

    <xsl:template match="ROW">
	<xsl:comment>Estoy en row 1</xsl:comment>
        <fo:table-row>
            <xsl:apply-templates/>
        </fo:table-row>
    </xsl:template>

    <xsl:template match="ROW/CAMPO">
	<xsl:comment>Estoy en row/campo 1</xsl:comment>
        <fo:table-cell>
            <xsl:if test="boolean(normalize-space(@EXT))">
                <xsl:attribute name="number-columns-spanned">
                    <xsl:value-of select="@EXT"/>
                </xsl:attribute>
            </xsl:if>
            <fo:block font-size="9pt">
                <xsl:choose>
                    <xsl:when test="string-length(.) = 0">&nbsp;</xsl:when>
                    <xsl:otherwise>
                        <xsl:value-of select = "."/> 
                    </xsl:otherwise>
                </xsl:choose>
            </fo:block>
        </fo:table-cell>
    </xsl:template>

    <xsl:template match="ROWSET2/CAMPO">
	<xsl:comment>Estoy en rowset2/campo 1</xsl:comment>
	<!-- Si el padre es ROWSET2 metemos cabecera-->
	<fo:table>
	<fo:table-column column-width="7cm"/>
            <fo:table-column column-width="8.5cm"/>
		    <fo:table-body>
		       <fo:table-row>
			
		       

        <fo:table-cell>
            <xsl:if test="boolean(normalize-space(@EXT))">
                <xsl:attribute name="number-columns-spanned">
                    <xsl:value-of select="@EXT"/>
                </xsl:attribute>
            </xsl:if>
            <fo:block font-size="9pt">
                <xsl:choose>
                    <xsl:when test="string-length(.) = 0">&nbsp;</xsl:when>
                    <xsl:otherwise>
                        <xsl:value-of select = "."/> 
                    </xsl:otherwise>
                </xsl:choose>
            </fo:block>
        </fo:table-cell>
	</fo:table-row>
		    </fo:table-body>
	    </fo:table>
    </xsl:template>

    <xsl:template match="TPIE">
        <xsl:apply-templates/>
    </xsl:template>


    <xsl:template match="text()">
                <!-- xsl:value-of select="."/ -->
    </xsl:template>



</xsl:stylesheet>
