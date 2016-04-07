<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
   INDRA/CAR/
   $Id: drd30_trazas.xsl,v 1.1 2009/12/03 19:03:44 pecbazalar Exp $
   Plantilla para las trazas en caliente

   DRUIDATARGET=/../../config/scripts/iniciales
-->

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<!--<xsl:output method="xml" indent="yes" encoding="ISO-8859-1"/>-->


<xsl:template match="TRAZAS">

<HTML>

<HEAD><title>MONITOR DRUIDA</title></HEAD>
   <BODY leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" text="#000000" bgcolor="#8F4784">
	
	<TABLE width="100%" align="center" bgcolor="#8F4784" style="color:white;font-size:16px;font-weight:bold;font-family: Geneva, Arial, Helvetica, san-serif;">
		<TR height="36"><TD align="center">TRAZAS  DRUIDA</TD></TR>
	</TABLE>

<TABLE width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#FFEBD8">      
     
      <TR>
	 <TD bgcolor="#FFAD42" colspan="14" style="font-family: Arial, Helvetica, sans-serif; font-size: 13px; font-style: italic; line-height: normal; font-weight: bolder; font-variant: small-caps; text-transform: capitalize; color: #FFFFFF; text-align: left; text-indent: 4px; vertical-align: middle">TRAZAS</TD>     
      </TR> 
      
      <TD height="1"></TD>

      <TR ALIGN="LEFT" height="30" bgcolor="#FEB05F" style="color: #DA8823;background-color: #FADBB0;font-family: Geneva, Arial, Helvetica, san-serif;font-size: 11px;font-weight: bold;padding-right: 3px;padding-left: 7px;">
	 
		<TD align="center" width="25%" nowrap="">Tiempo</TD>
		<TD align="center" width="25%" nowrap="">Tipo</TD>
		<TD align="center" width="25%" nowrap="">Fecha</TD>
		<TD align="center" width="25%" nowrap="">Hora</TD>
		<TD align="center" width="25%" nowrap="">Dir. IP</TD>
		<TD align="center" width="25%" nowrap="">Id de la Traza</TD>
		<TD align="center" nowrap="">Usuario Remoto</TD>
		<TD align="center" width="25%" nowrap="">Objeto</TD>
		<TD align="center" width="25%" nowrap="">Tipo Negocio</TD>
		<TD align="center" width="25%" nowrap="">O. Afectado</TD>
		<TD align="center" width="25%" nowrap="">Tipo Secuencia</TD>
		<TD align="center" width="25%" nowrap="">Tipo Marca</TD>
		<TD align="center" width="25%" nowrap="">Valores Entrada</TD>
		<TD align="center" width="25%" nowrap="">Excepción</TD>
	</TR>

	<xsl:for-each select="T">
		<!--  PARA FUTURAS ORDENACIONES. -->
		<!--  <xsl:sort select="@e" data-type="number"/> -->
		<!--  <xsl:sort select="@b" data-type="text"/> -->
		<!--  <xsl:sort select="@g" data-type="text"/> -->
		<!--  <xsl:sort select="@f" data-type="number"/> -->

		<xsl:call-template name="TIPOTRAZAS"/>
	</xsl:for-each>

</TABLE>
   </BODY>
</HTML>
</xsl:template> 


<xsl:template name="TIPOTRAZAS">


	<TR ALIGN="CENTER" style="font-family: Geneva, Arial, Helvetica, san-serif;font-size: 11px;color: #000000;background-color: #FFF1E3;padding-right: 3px;padding-left: 7px;">

		<!-- NO MONTA BIEN LA PAGINA HACIENDO TODOS A LA VEZ !!!  <xsl:apply-templates select="@*"/> -->

<!-- Colores para las filas de la lista FFF3E3 FFF7F0 -->

		<TD bgcolor="FFF3E3"><xsl:value-of select="@a"/></TD>
		<TD bgcolor="FFF7F0"><xsl:value-of select="@b"/></TD>
		<TD bgcolor="FFF3E3"><xsl:value-of select="@c"/></TD>
		<TD bgcolor="FFF7F0"><xsl:value-of select="@d"/></TD>
		<TD bgcolor="FFF3E3"><xsl:value-of select="@e"/></TD>
		<TD bgcolor="FFF7F0"><xsl:value-of select="@f"/></TD>
		<TD bgcolor="FFF3E3"><xsl:value-of select="@g"/></TD>
		<TD bgcolor="FFF7F0"><xsl:value-of select="@h"/></TD>
		<TD bgcolor="FFF3E3"><xsl:value-of select="@i"/></TD>
		<TD bgcolor="FFF7F0"><xsl:value-of select="@j"/></TD>
		<TD bgcolor="FFF3E3"><xsl:value-of select="@k"/></TD>
		<TD bgcolor="FFF7F0"><xsl:value-of select="@l"/></TD>
		<!-- <TD bgcolor="FFFFCC"><xsl:value-of select="@m"/></TD> -->

		<TD bgcolor="FFF3E3"> 
		<xsl:choose>
			<xsl:when test="string-length(@m)>0">
			<textarea style="font-size: 11px" name="comentario" rows="4" cols="10"><xsl:value-of select="@m"/></textarea> 
			</xsl:when> 

			<xsl:otherwise>
				VACIO
			</xsl:otherwise> 
		</xsl:choose>
		</TD>  


		<TD bgcolor="FFF7F0"> 
		<xsl:choose>
			<xsl:when test="string-length(.)>0">
			<textarea style="font-size: 11px" name="comentario" rows="6" cols="40"><xsl:value-of select="."/></textarea> 
				
			</xsl:when> 
			<xsl:otherwise>
				VACIO
			</xsl:otherwise> 
		</xsl:choose>
		</TD>  

	    </TR>

</xsl:template>

</xsl:stylesheet> 