<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output version="1.0" encoding="ISO-8859-1" omit-xml-declaration="no" method="xml" indent="yes"/>

<xsl:key name="grupo" match="ROW" use="CAMPO[@NOMBRE='GOFE_NUM_GRUPO'][position()=1]"/>

<xsl:template match="//ROWSET2">
  <table width="597" border="0" cellspacing="0" cellpadding="0" align="center">
    <tr> 
      <td width="12" align="center"><IMG src="b.gif" width="12" height="12"/></td>
      <td><IMG src="b.gif" width="12" height="12"/></td>
      <td><IMG src="b.gif" width="12" height="12"/></td>
    </tr>
    <tr>      
      <td width="10" align="center"><IMG src="b.gif" width="10" height="12"/></td>
      <td>
	  <table width="582" border="1" cellspacing="1" cellpadding="0" bordercolor="#CCCCCC">
          <tr>            
	    <td class="tablaTitle">
	       <LABELC nombre="lblGrupo" alto="25" ancho="70"  filas="1" id = "datosCamposCabecera"  cod="645"/>
 	    </td>
          </tr>
          <tr> 
            <td>		  
	       <xsl:apply-templates select="//ROWSET[@ID='dtoSalida.grupo_ROWSET']"></xsl:apply-templates>		  		 		
	    </td>
	  </tr>          
	  </table>
      </td>
      <td width="12" align="center"><IMG src="b.gif" width="12" height="12"/></td>
    </tr>   
  </table>		
</xsl:template>

<xsl:template match="ROWSET">
	<xsl:for-each select="ROW[count(. | key('grupo',CAMPO[@NOMBRE='GOFE_NUM_GRUPO'])[1])=1]">
	<xsl:sort select="CAMPO[@NOMBRE='GOFE_NUM_GRUPO']"/>
		<!--
		ak se arma el header de las tablas, es decir, el agrupado
		-->
	  <table width="98%" border="1" cellspacing="1" cellpadding="0" align="center" bordercolor="#CCCCCC">
           <tr>
           <td>
              <table width="98%" border="0" cellspacing="0" cellpadding="0" align="center">   
		<tr>
		   <td colspan="3" class="datosCampos"><IMG src="b.gif" width="8" height="8"/></td>
		</tr>
		<tr>
		  <td width="133px">
		    <LABELC nombre="lblNumGrupo_{CAMPO[@NOMBRE='GOFE_NUM_GRUPO']}" alto="30" ancho="133" filas="1" id="datosTitle"  cod="646"/>
		  </td>
		  <td width="8"><IMG src="b.gif" width="8" height="8"/></td>
		  <td class="datosCamposLeft">
		    <xsl:value-of select="CAMPO[@NOMBRE='GOFE_NUM_GRUPO']"></xsl:value-of>
		  </td>
		</tr>
		<tr>
		  <td width="133px">
		   <LABELC nombre="lblIndCuadreGrupo_{CAMPO[@NOMBRE='GOFE_NUM_GRUPO']}" alto="30" ancho="133" filas="1" id="datosTitle"  cod="184"/>
		  </td>
		  <td width="8"><IMG src="b.gif" width="8" height="8"/></td>
		  <td class="datosCamposLeft">
		    <xsl:value-of select="CAMPO[@NOMBRE='DES_IND_CUAD']"></xsl:value-of>
		  </td>
		</tr>
		<tr>
		  <td width="133px">
		    <LABELC nombre="lblFactCuadreGrupo_{CAMPO[@NOMBRE='GOFE_NUM_GRUPO']}" alto="30" ancho="133" filas="1" id="datosTitle"  cod="183"/>
		  </td>
		  <td width="8"><IMG src="b.gif" width="8" height="8"/></td>
		  <td class="datosCamposLeft">
		    <xsl:value-of select="CAMPO[@NOMBRE='COD_FACT_CUAD']"></xsl:value-of>
		  </td>					
		</tr>
		<tr>
		  <td width="133px">
		    <LABELC nombre="lblTipoGrupo_{CAMPO[@NOMBRE='GOFE_NUM_GRUPO']}" alto="30" ancho="133" filas="1" id="datosTitle"  cod="647"/>
		  </td>
		  <td width="8"><IMG src="b.gif" width="8" height="8"/></td>
		  <td class="datosCamposLeft">
		     <xsl:choose>
		     <xsl:when test="CAMPO[@NOMBRE='IND_COND']=1 and CAMPO[@NOMBRE='IND_PAQUE']=0">
			<LABELC nombre="lblCondicionante_{CAMPO[@NOMBRE='GOFE_NUM_GRUPO']}" alto="30" ancho="133" filas="1" id="datosCamposLeft"  cod="927"/>
		     </xsl:when>
		     <xsl:when test="CAMPO[@NOMBRE='IND_COND']=0 and CAMPO[@NOMBRE='IND_PAQUE']=0">
			<LABELC nombre="lblCondicionado_{CAMPO[@NOMBRE='GOFE_NUM_GRUPO']}" alto="30" ancho="133" filas="1" id="datosCamposLeft"  cod="928"/>
		     </xsl:when>
		     <xsl:when test="CAMPO[@NOMBRE='IND_COND']=0 and CAMPO[@NOMBRE='IND_PAQUE']=1">
			<LABELC nombre="lblPaquete_{CAMPO[@NOMBRE='GOFE_NUM_GRUPO']}" alto="30" ancho="133" filas="1" id="datosCamposLeft"  cod="929"/>
		     </xsl:when>
 		     </xsl:choose>
		  </td>					
		</tr>
		<tr>
		  <td colspan="3" class="datosCampos"><IMG src="b.gif" width="8" height="8"/></td>
		</tr>
		<xsl:apply-templates select="." ></xsl:apply-templates>
		
                </table>
           </td>
	   </tr>	   
	   <tr>
	   <td class="datosCampos" style="border:none"><IMG src="b.gif" width="8" height="8"/></td>
	   </tr>
	   </table>
	</xsl:for-each>
</xsl:template>

<xsl:template match="ROW">
	<!--
		ak se arman los detalles, es decir, lo que serian las listas internas,
		El detalle del grupo, incluido el nodo que se uso para agrupar
	-->
	<tr>
	<td height="151" colspan="3" valign="top">
	<LISTA seleccion="boton" nombre="lstGrupo_{CAMPO[@NOMBRE='GOFE_NUM_GRUPO']}"  
	        ancho="547" alto="150"	entradax = "" entraday = "" x="" y=""
		colorf = "#EFEFEF" oncolor = "" chkcolor = "" visibilidad = ""
		incx = "10" incy = "10" nmin = "" nmax = "-1" multisel = "0" accion=""
		sep = "|" imagenon = "close_up.gif" imagenoff = "close_no.gif" 
		pixelsborde = "2" colorborde = "#CCCCCC"  onSetDatos = "" blockImg = "">			
	  <CABECERA nombre = "cab1" height = "30">	   
	    <COL id = "fondoCabecera" ancho = "210"><LABELC nombre = "lblCodProd_{CAMPO[@NOMBRE='GOFE_NUM_GRUPO']}" ancho = "210" alto = "30" filas = "1" 	
		id = "datosCamposCabecera" cod = "510" valor = "" enviaroculto = "N"/></COL>
	    <COL id = "fondoCabecera" ancho = "210"><LABELC nombre = "lblDesc_{CAMPO[@NOMBRE='GOFE_NUM_GRUPO']}" ancho = "210"	alto = "30" 
		filas = "1"	id = "datosCamposCabecera" cod = "28" valor = "" enviaroculto = "N"/></COL>
	    <COL id = "fondoCabecera" ancho = "70"><LABELC nombre = "lblUniMax_{CAMPO[@NOMBRE='GOFE_NUM_GRUPO']}" ancho = "70" alto = "30" filas = "1"
		id = "datosCamposCabecera" cod = "633"	valor = "" enviaroculto = "N"/></COL>
	    <COL id = "fondoCabecera" ancho = "110"><LABELC nombre = "lblPrecioUnit_{CAMPO[@NOMBRE='GOFE_NUM_GRUPO']}"	ancho = "110" alto = "30" 
		filas = "1" id = "datosCamposCabecera" cod = "649"	valor = "" enviaroculto = "N"/></COL>
	    <COL id = "fondoCabecera" ancho = "70"><LABELC nombre = "lblFactorRepet_{CAMPO[@NOMBRE='GOFE_NUM_GRUPO']}" 	ancho = "70" alto = "30" filas = "1" 
		id = "datosCamposCabecera" cod = "650"	valor = "" enviaroculto = "N"/></COL>	 
	    <COL id = "fondoCabecera" ancho = "70"><LABELC nombre = "lblAtrib1_{CAMPO[@NOMBRE='GOFE_NUM_GRUPO']}" 	ancho = "70" alto = "30" filas = "1" 
		id = "datosCamposCabecera" cod = "651"	valor = "" enviaroculto = "N"/></COL>	 
	    <COL id = "fondoCabecera" ancho = "70"><LABELC nombre = "lblAtrib2_{CAMPO[@NOMBRE='GOFE_NUM_GRUPO']}" 	ancho = "70" alto = "30" filas = "1" 
		id = "datosCamposCabecera" cod = "652"	valor = "" enviaroculto = "N"/></COL>	 
	    <COL id = "fondoCabecera" ancho = "110"><LABELC nombre = "lblAtrib3_{CAMPO[@NOMBRE='GOFE_NUM_GRUPO']}" 	ancho = "110" alto = "30" filas = "1" 
		id = "datosCamposCabecera" cod = "653"	valor = "" enviaroculto = "N"/></COL>	 
	    <COL id = "fondoCabecera" ancho = "20"></COL>	
	  </CABECERA>

	  <PRESENTACION ancho = "920" filas = "1"	bloquesid = "['datosCamposCenterImpar',	'datosCamposCenterPar',
									'datosCamposRightImpar','datosCamposRightPar',
									'datosCamposRightImpar', 'datosCamposCenterPar',
									'datosCamposCenterImpar','datosCamposCenterPar']">			
	    <COL ancho = "210" caracteres = "50"/>
	    <COL ancho = "210" caracteres = "50"/>
	    <COL ancho = "70" caracteres = "50"/>
	    <COL ancho = "110" caracteres = "50"/>
	    <COL ancho = "70" caracteres = "50"/>
	    <COL ancho = "70" caracteres = "50"/>	  
	    <COL ancho = "70" caracteres = "50"/>
	    <COL ancho = "110" caracteres = "50"/>	  
	  </PRESENTACION>
			
	  <ROWSET>
					
	  <xsl:for-each select="key('grupo', CAMPO[@NOMBRE='GOFE_NUM_GRUPO'])">
	  <xsl:sort select="CAMPO[@NOMBRE='MAFA_PROD_COD_SAP']" />

                <ROW>		      	    
		    <xsl:copy-of select="CAMPO[position()=2]"/>
		    <xsl:copy-of select="CAMPO[position()=3]"/>
		    <xsl:copy-of select="CAMPO[position()=6]"/>
		    <xsl:copy-of select="CAMPO[position()=5]"/>
		    <xsl:copy-of select="CAMPO[position()=4]"/>		    
		    <xsl:copy-of select="CAMPO[position()=7]"/>		
		    <xsl:copy-of select="CAMPO[position()=8]"/>		
		    <xsl:copy-of select="CAMPO[position()=9]"/>		
		</ROW>
		
	  </xsl:for-each>
          </ROWSET>
        </LISTA>
        </td>
      </tr>      
</xsl:template>


</xsl:stylesheet>