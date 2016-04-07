<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:param name="textoBreve"></xsl:param>
	<xsl:param name="unidadesMaximas"></xsl:param>
	<xsl:param name="unidadesEstimadas"></xsl:param>
	<xsl:param name="factorRepeticion"></xsl:param>
	<xsl:param name="digitableGuiaProductos"></xsl:param>
	<xsl:param name="imprimibleGuiaProductos"></xsl:param>
	<xsl:param name="comisionable"></xsl:param>
	<xsl:param name="puntaje"></xsl:param>
	<xsl:param name="estadisticable"></xsl:param>
	<xsl:param name="montoMinimo"></xsl:param>
	<xsl:param name="aportaMontoEscala"></xsl:param>

	<xsl:preserve-space elements="*"/>
	<xsl:output encoding="ISO-8859-1" method="xml" omit-xml-declaration="no" indent="yes"></xsl:output>

	<xsl:template match="//ROWSET2">
		<xsl:copy>
			<xsl:apply-templates select="./@*"/>
			<xsl:apply-templates select="./ROWSET"/>
		</xsl:copy>
	</xsl:template>

	<xsl:template match="ROWSET">
		<xsl:copy>
			<xsl:apply-templates select="./@*"/>
			<xsl:apply-templates select="./ROW"/>
		</xsl:copy>
	</xsl:template>

	<xsl:template match="ROW">
		<xsl:copy>
			<xsl:apply-templates select="./@*"/>
			<xsl:apply-templates select="./CAMPO"/>
		</xsl:copy>
	</xsl:template>
	
	<xsl:template match="CAMPO">
		<xsl:choose>
			<xsl:when test="@NOMBRE='TEXTO_BREVE'">
				<xsl:copy>
					<xsl:apply-templates select="@*"/>
					<xsl:value-of select="$textoBreve"/>
				</xsl:copy>
			</xsl:when>
			<xsl:when test="@NOMBRE='VAL_UNID_MAXI'">
				<xsl:copy>
					<xsl:apply-templates select="@*"/>
					<xsl:value-of select="$unidadesMaximas"/>
				</xsl:copy>
			</xsl:when>
			<xsl:when test="@NOMBRE='VAL_UNID_ESTI'">
				<xsl:copy>
					<xsl:apply-templates select="@*"/>
					<xsl:value-of select="$unidadesEstimadas"/>
				</xsl:copy>
			</xsl:when>
			<xsl:when test="@NOMBRE='FACT_REPE'">
				<xsl:copy>
					<xsl:apply-templates select="@*"/>
					<xsl:value-of select="$factorRepeticion"/>
				</xsl:copy>
			</xsl:when>
			<xsl:when test="@NOMBRE='IND_DIGI'">
				<xsl:copy>
					<xsl:apply-templates select="@*"/>
					<xsl:value-of select="$digitableGuiaProductos"/>
				</xsl:copy>
			</xsl:when>
			<xsl:when test="@NOMBRE='IND_IMPR'">
				<xsl:copy>
					<xsl:apply-templates select="@*"/>
					<xsl:value-of select="$imprimibleGuiaProductos"/>
				</xsl:copy>
			</xsl:when>
			<xsl:when test="@NOMBRE='IND_COMI'">
				<xsl:copy>
					<xsl:apply-templates select="@*"/>
					<xsl:value-of select="$comisionable"/>
				</xsl:copy>
			</xsl:when>
			<xsl:when test="@NOMBRE='IND_PUNT'">
				<xsl:copy>
					<xsl:apply-templates select="@*"/>
					<xsl:value-of select="$puntaje"/>
				</xsl:copy>
			</xsl:when>
			<xsl:when test="@NOMBRE='IND_ESTA'">
				<xsl:copy>
					<xsl:apply-templates select="@*"/>
					<xsl:value-of select="$estadisticable"/>
				</xsl:copy>
			</xsl:when>
			<xsl:when test="@NOMBRE='IND_MONT_MIN'">
				<xsl:copy>
					<xsl:apply-templates select="@*"/>
					<xsl:value-of select="$montoMinimo"/>
				</xsl:copy>
			</xsl:when>
			<xsl:when test="@NOMBRE='IND_APOR_MONT_ESCA'">
				<xsl:copy>
					<xsl:apply-templates select="@*"/>
					<xsl:value-of select="$aportaMontoEscala"/>
				</xsl:copy>
			</xsl:when>
			<xsl:otherwise>
				<xsl:copy-of select="."/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
	
	<xsl:template match="@*">
		<xsl:copy></xsl:copy>
	</xsl:template>
</xsl:stylesheet>