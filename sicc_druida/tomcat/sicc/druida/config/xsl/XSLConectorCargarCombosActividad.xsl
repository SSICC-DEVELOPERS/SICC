<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:preserve-space elements="*"/>
	<xsl:output encoding="ISO-8859-1" method="xml" omit-xml-declaration="no" indent="yes"></xsl:output>

	<xsl:template match="//ROWSET2">
		<xsl:copy>
			<xsl:apply-templates select="@*"/>
			<xsl:apply-templates select="ROWSET[@ID='DTOCombosActividad.tipoCliente_ROWSET']" mode="tipoCliente"/>
			<xsl:apply-templates select="ROWSET[@ID='DTOCombosActividad.tipoClasificacion_ROWSET']" mode="tipoClasificacion"/>
			<xsl:apply-templates select="ROWSET[@ID='DTOCombosActividad.tipoOferta_ROWSET']" mode="tipoOferta"/>
			<xsl:apply-templates select="ROWSET[@ID='DTOCombosActividad.tipoDespacho_ROWSET']" mode="tipoDespacho"/>
			<xsl:apply-templates select="ROWSET[@ID='DTOCombosActividad.pagoFraccionado_ROWSET']" mode="pagoFraccionado"/>
			<xsl:apply-templates select="ROWSET[@ID='DTOCombosActividad.criterioAsignacion_ROWSET']" mode="criterioAsignacion"/>
		</xsl:copy>
	</xsl:template>

	<xsl:template match="ROWSET" mode="tipoCliente">
		<xsl:copy>
			<xsl:apply-templates select="@*"/>
			<xsl:apply-templates select="./ROW">
				<xsl:sort select="CAMPO[@NOMBRE='DES_TIPO_CLIE']"/>
			</xsl:apply-templates>
		</xsl:copy>
	</xsl:template>

	<xsl:template match="ROWSET" mode="tipoClasificacion">
		<xsl:copy>
			<xsl:apply-templates select="@*"/>
			<xsl:apply-templates select="./ROW">
				<xsl:sort select="CAMPO[@NOMBRE='DES_TIPO_CLAS']"/>
			</xsl:apply-templates>
		</xsl:copy>
	</xsl:template>

	<xsl:template match="ROWSET" mode="tipoOferta">
		<xsl:copy>
			<xsl:apply-templates select="@*"/>
			<xsl:apply-templates select="./ROW">
				<xsl:sort select="CAMPO[@NOMBRE='DES_TIPO_OFER']"/>
			</xsl:apply-templates>
		</xsl:copy>
	</xsl:template>

	<xsl:template match="ROWSET" mode="tipoDespacho">
		<xsl:copy>
			<xsl:apply-templates select="@*"/>
			<xsl:apply-templates select="./ROW">
				<xsl:sort select="CAMPO[@NOMBRE='DES_TIPO_DESP']"/>
			</xsl:apply-templates>
		</xsl:copy>
	</xsl:template>

	<xsl:template match="ROWSET" mode="pagoFraccionado">
		<xsl:copy>
			<xsl:apply-templates select="@*"/>
			<xsl:apply-templates select="./ROW">
				<xsl:sort select="CAMPO[@NOMBRE='DES_PAGO_FRAC']"/>
			</xsl:apply-templates>
		</xsl:copy>
	</xsl:template>

	<xsl:template match="ROWSET" mode="criterioAsignacion">
		<xsl:copy>
			<xsl:apply-templates select="@*"/>
			<xsl:apply-templates select="./ROW">
				<xsl:sort select="CAMPO[@NOMBRE='DES']"/>
			</xsl:apply-templates>
		</xsl:copy>
	</xsl:template>

	<xsl:template match="ROW">
		<xsl:copy-of select="current()"/>
	</xsl:template>

	<xsl:template match="@*">
		<xsl:copy></xsl:copy>
	</xsl:template>

</xsl:stylesheet>