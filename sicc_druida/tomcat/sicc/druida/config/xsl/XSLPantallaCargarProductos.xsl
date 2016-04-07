<?xml version="1.0" encoding="ISO-8859-1"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:output omit-xml-declaration="no" encoding="ISO-8859-1" indent="yes" version="1.0"/>

<xsl:template match="//ROWSET2">
<xsl:copy>
	<xsl:apply-templates select="@*"></xsl:apply-templates>
	<xsl:apply-templates select="./ROWSET"></xsl:apply-templates>
</xsl:copy>
</xsl:template>

<xsl:template match="ROWSET">
	<xsl:copy>
		<xsl:apply-templates select="@*"></xsl:apply-templates>
		<xsl:choose>
			<xsl:when test="./@ID='dtoSalida.marcas_ROWSET'">
				<xsl:apply-templates select="./ROW">
					<xsl:sort select="CAMPO[@NOMBRE='DESC_MARC']"></xsl:sort>
				</xsl:apply-templates>
			</xsl:when>
			<xsl:when test="./@ID='dtoSalida.lineasProductos_ROWSET'">
				<xsl:apply-templates select="./ROW">
					<xsl:sort select="CAMPO[@NOMBRE='DES_LINE_PROD']"></xsl:sort>
				</xsl:apply-templates>
			</xsl:when>
			<xsl:when test="./@ID='dtoSalida.supergenericos_ROWSET'">
				<xsl:apply-templates select="./ROW">
					<xsl:sort select="CAMPO[@NOMBRE='DES_SUPE_GENE']"></xsl:sort>
				</xsl:apply-templates>
			</xsl:when>
			<xsl:when test="./@ID='dtoSalida.genericos_ROWSET'">
				<xsl:apply-templates select="./ROW">
					<xsl:sort select="CAMPO[@NOMBRE='DES_GENE']"></xsl:sort>
				</xsl:apply-templates>
			</xsl:when>
			<xsl:when test="./@ID='dtoSalida.negocios_ROWSET'">
				<xsl:apply-templates select="./ROW">
					<xsl:sort select="CAMPO[@NOMBRE='DES_NEGO']"></xsl:sort>
				</xsl:apply-templates>
			</xsl:when>
			<xsl:when test="./@ID='dtoSalida.unidadesNegocio_ROWSET'">
				<xsl:apply-templates select="./ROW">
					<xsl:sort select="CAMPO[@NOMBRE='DES_UNID_NEGO']"></xsl:sort>
				</xsl:apply-templates>
			</xsl:when>
			<xsl:when test="./@ID='dtoSalida.catalogos_ROWSET'">
				<xsl:apply-templates select="./ROW">
					<xsl:sort select="CAMPO[@NOMBRE='DES_CATA']"></xsl:sort>
				</xsl:apply-templates>
			</xsl:when>
		</xsl:choose>
	</xsl:copy>
</xsl:template>

<xsl:template match="ROW">
	<xsl:copy>
		<xsl:apply-templates select="@*"></xsl:apply-templates>
		<xsl:choose>
			<xsl:when test="./../@ID='dtoSalida.marcas_ROWSET'">
				<xsl:copy-of select="CAMPO[@NOMBRE='COD_MARC']"/>
				<xsl:copy-of select="CAMPO[@NOMBRE='DES_MARC']"/>
			</xsl:when>
			<xsl:when test="./../@ID='dtoSalida.lineasProductos_ROWSET'">
				<xsl:copy-of select="CAMPO[@NOMBRE='COD_LINE_PROD']"/>
				<xsl:copy-of select="CAMPO[@NOMBRE='DES_LINE_PROD']"/>
				<xsl:copy-of select="CAMPO[@NOMBRE='PAIS_COD_PAIS']"/>
			</xsl:when>
			<xsl:when test="./../@ID='dtoSalida.supergenericos_ROWSET'">
				<xsl:copy-of select="CAMPO[@NOMBRE='COD_SUPE_GENE']"/>
				<xsl:copy-of select="CAMPO[@NOMBRE='DES_SUPE_GENE']"/>
				<xsl:copy-of select="CAMPO[@NOMBRE='PAIS_COD_PAIS']"/>
			</xsl:when>
			<xsl:when test="./../@ID='dtoSalida.genericos_ROWSET'">
				<xsl:copy-of select="CAMPO[@NOMBRE='COD_GENE']"/>
				<xsl:copy-of select="CAMPO[@NOMBRE='DES_GENE']"/>
				<xsl:copy-of select="CAMPO[@NOMBRE='PAIS_COD_PAIS']"/>
			</xsl:when>
			<xsl:when test="./../@ID='dtoSalida.negocios_ROWSET'">
				<xsl:copy-of select="CAMPO[@NOMBRE='COD_NEGO']"/>
				<xsl:copy-of select="CAMPO[@NOMBRE='DES_NEGO']"/>
				<xsl:copy-of select="CAMPO[@NOMBRE='PAIS_COD_PAIS']"/>
			</xsl:when>
			<xsl:when test="./../@ID='dtoSalida.unidadesNegocio_ROWSET'">
				<xsl:copy-of select="CAMPO[@NOMBRE='COD_UNID_NEGO']"/>
				<xsl:copy-of select="CAMPO[@NOMBRE='DES_UNID_NEGO']"/>
				<xsl:copy-of select="CAMPO[@NOMBRE='PAIS_COD_PAIS']"/>
			</xsl:when>
			<xsl:when test="./../@ID='dtoSalida.catalogos_ROWSET'">
				<xsl:copy-of select="CAMPO[@NOMBRE='COD_CATA']"/>
				<xsl:copy-of select="CAMPO[@NOMBRE='DES_CATA']"/>
				<xsl:copy-of select="CAMPO[@NOMBRE='PAIS_COD_PAIS']"/>
			</xsl:when>
		</xsl:choose>
	</xsl:copy>
</xsl:template>
<xsl:template match="@*">
	<xsl:copy></xsl:copy>
</xsl:template>
</xsl:stylesheet>