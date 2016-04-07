<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
   INDRA/CAR/Druida 3.0
   $Id: drd30_listado.xsl,v 1.1 2009/12/03 19:03:45 pecbazalar Exp $
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">


   <!-- Carga de JS ......................................................................... -->
   <xsl:template match="LISTAEDITABLE" mode="head">

      <SCRIPT TYPE="text/javascript">
         <xsl:attribute name="SRC">
            <xsl:value-of select="$jsDruidaPath"/>
            <xsl:text>d3listado.js</xsl:text>
         </xsl:attribute>
         <xsl:text>&#xa;</xsl:text>
      </SCRIPT>

      <SCRIPT TYPE="text/javascript"><!-- ARREGLAR PARA QUE SOLO LO HAGA UNA VEZ XXX -->
         <xsl:attribute name="SRC">
            <xsl:value-of select="$jsDruidaPath"/>
            <xsl:text>valida.js</xsl:text>
         </xsl:attribute>
         <xsl:text>&#xa;</xsl:text>
      </SCRIPT>

      <SCRIPT TYPE="text/javascript"><!-- ARREGLAR PARA QUE SOLO LO HAGA UNA VEZ XXX -->
         <xsl:attribute name="SRC">
            <xsl:value-of select="$jsDruidaPath"/>
            <xsl:text>entornoV.js</xsl:text>
         </xsl:attribute>
         <xsl:text>&#xa;</xsl:text>
      </SCRIPT>

      <xsl:apply-templates  mode="head"/>
   </xsl:template>



   <!-- Definicion de Capas ............................................................... -->
   <xsl:template match="LISTAEDITABLE" mode="estilo">

      <xsl:param name="nsdoc"/>
      <xsl:variable name="nsdoc-parte-local"/>
      <xsl:variable name="nsdoc-local">
         <xsl:value-of select="concat($nsdoc,$nsdoc-parte-local)"/>
      </xsl:variable>

      <xsl:variable name="incSX"><xsl:choose><xsl:when test="@incScrollx"><xsl:value-of select="@incScrollx"/></xsl:when><xsl:otherwise>2</xsl:otherwise></xsl:choose></xsl:variable>
      <xsl:variable name="incSY"><xsl:choose><xsl:when test="@incScrolly"><xsl:value-of select="@incScrolly"/></xsl:when><xsl:otherwise>2</xsl:otherwise></xsl:choose></xsl:variable>

      <xsl:variable name="gb"><xsl:choose><xsl:when test="LINEAS/GROSOR/@borde"><xsl:value-of select="LINEAS/GROSOR/@borde"/></xsl:when><xsl:otherwise>2</xsl:otherwise></xsl:choose></xsl:variable>

      <xsl:variable name="ghc">
         <xsl:choose>
            <xsl:when test="CABECERA">
               <xsl:choose>
                  <xsl:when test="LINEAS/GROSOR/@horizCabecera">
                     <xsl:value-of select="LINEAS/GROSOR/@horizCabecera"/>
                  </xsl:when>
                  <xsl:otherwise>2</xsl:otherwise>
               </xsl:choose>
            </xsl:when>
            <xsl:otherwise>0</xsl:otherwise>
         </xsl:choose>
      </xsl:variable>

      <xsl:variable name="cb"><xsl:choose><xsl:when test="LINEAS/COLOR/@borde"><xsl:value-of select="LINEAS/COLOR/@borde"/></xsl:when><xsl:otherwise>black</xsl:otherwise></xsl:choose></xsl:variable>
      <xsl:variable name="vAltoCab">
         <xsl:choose>
            <xsl:when test="CABECERA/@alto">
               <xsl:value-of select="CABECERA/@alto"/>
            </xsl:when>
            <xsl:otherwise>
               <xsl:choose><xsl:when test="CABECERA">22</xsl:when><xsl:otherwise>0</xsl:otherwise></xsl:choose>
            </xsl:otherwise>
         </xsl:choose>
      </xsl:variable>

      <xsl:variable name="colorFondo"><xsl:choose><xsl:when test="@colorFondo"><xsl:value-of select="@colorFondo"/></xsl:when><xsl:otherwise>white</xsl:otherwise></xsl:choose></xsl:variable>

      <xsl:variable name="vAltoTitulo">
         <xsl:choose>
            <xsl:when test="TITULO"><xsl:choose><xsl:when test="TITULO/@alto"><xsl:value-of select="TITULO/@alto"/></xsl:when><xsl:otherwise>22</xsl:otherwise></xsl:choose></xsl:when> <!-- ojo valor por defecto igual en los dos sitios. Template? xxxxxxxx -->
            <xsl:otherwise>0</xsl:otherwise>
         </xsl:choose>
      </xsl:variable>

      <xsl:variable name="vGrHTitulo">
         <xsl:choose>
            <xsl:when test="TITULO"><xsl:choose><xsl:when test="LINEAS/GROSOR/@horizTitulo"><xsl:value-of select="LINEAS/GROSOR/@horizTitulo"/></xsl:when><xsl:otherwise>2</xsl:otherwise></xsl:choose></xsl:when> <!-- ojo valor por defecto igual en los dos sitios. Template? xxxxxxxx -->
            <xsl:otherwise>0</xsl:otherwise>
         </xsl:choose>
      </xsl:variable>
      <xsl:variable name="vReservadoTitulo"><xsl:value-of select="$vAltoTitulo + $vGrHTitulo"/></xsl:variable>


      <xsl:variable name="vAltoBase">
         <xsl:choose>
            <xsl:when test="BASE"><xsl:choose><xsl:when test="BASE/@alto"><xsl:value-of select="BASE/@alto"/></xsl:when><xsl:otherwise>22</xsl:otherwise></xsl:choose></xsl:when> 
            <xsl:otherwise>0</xsl:otherwise>
         </xsl:choose>
      </xsl:variable>
      <xsl:variable name="vGrHBase">
         <xsl:choose>
            <xsl:when test="BASE"><xsl:choose><xsl:when test="LINEAS/GROSOR/@horizBase"><xsl:value-of select="LINEAS/GROSOR/@horizBase"/></xsl:when><xsl:otherwise>2</xsl:otherwise></xsl:choose></xsl:when>
            <xsl:otherwise>0</xsl:otherwise>
         </xsl:choose>
      </xsl:variable>
      <xsl:variable name="vReservadoBase"><xsl:value-of select="$vAltoBase + $vGrHBase"/></xsl:variable>

      
      <!-- Cp contenedora -->
      <xsl:text>&#xa;#Cp</xsl:text><xsl:value-of select="@nombre"/>{position:absolute; width:<xsl:value-of select="@ancho"/>; height:<xsl:value-of select="@alto"/>; left: <xsl:value-of select="@x"/>; top: <xsl:value-of select="@y"/>; background-color: <xsl:value-of select="$colorFondo"/>; layer-background-color: <xsl:value-of select="$colorFondo"/>; <xsl:text>}&#xa;</xsl:text>

      <!-- Cp cabecera -->
      <xsl:text>#CpCab</xsl:text><xsl:value-of select="@nombre"/>{position:absolute; width:<xsl:value-of select="@ancho - (2 * $gb)"/>; height:<xsl:value-of select="$gb + $ghc + $vAltoCab"/>; left: <xsl:value-of select="$gb"/>; top: <xsl:value-of select="$gb + $vReservadoTitulo"/>; <xsl:text>;}&#xa;</xsl:text>  <!-- layer-background-color: <xsl:value-of select="LINEAS/COLOR/@horizCabecera"/>; background-color: <xsl:value-of select="LINEAS/COLOR/@horizCabecera"/> -->
      <!--<xsl:text>#CpCab</xsl:text><xsl:value-of select="@nombre"/>{position:absolute; width:; height:<xsl:value-of select="CABECERA/@alto + LINEAS/GROSOR/@borde + LINEAS/GROSOR/@horizCabecera"/>; left: 0; top: 0; overflow: hidden; layer-background-color: <xsl:value-of select="LINEAS/COLOR/@horizCabecera"/>; background-color: <xsl:value-of select="LINEAS/COLOR/@horizCabecera"/><xsl:text>;}</xsl:text>-->

      <!-- Cp fondo cab-->
      <xsl:if test="CABECERA/@imgFondo or CABECERA/@colFondo">
         <xsl:variable name="imgfond"><xsl:if test="CABECERA/@imgFondo"> background-image: url(<xsl:value-of select="$vgImgPath"/><xsl:value-of select="CABECERA/@imgFondo"/>);layer-background-image: url(<xsl:value-of select="$vgImgPath"/><xsl:value-of select="CABECERA/@imgFondo"/>);</xsl:if></xsl:variable>
         <xsl:variable name="colfond"><xsl:if test="CABECERA/@colFondo"> layer-background-color: <xsl:value-of select="CABECERA/@colFondo"/>; background-color: <xsl:value-of select="CABECERA/@colFondo"/> ;</xsl:if></xsl:variable>
         <xsl:text>#CpFCab</xsl:text><xsl:value-of select="@nombre"/>{position:absolute; width:<xsl:value-of select="@ancho"/>; height:<xsl:value-of select="$vAltoCab + $ghc"/>; left: 0; top: <xsl:value-of select="$gb+$vReservadoTitulo"/>; <xsl:value-of select="$imgfond"/> <xsl:value-of select="$colfond"/> <xsl:text>;}</xsl:text>
      </xsl:if>

      <xsl:variable name="cColScr"><xsl:if test="DATOS/@coloresScrollNativo"><xsl:value-of select="DATOS/@coloresScrollNativo"/></xsl:if></xsl:variable>

      <xsl:if test="CABECERA and $ghc > 0"> <!-- linea bajo la cabecera -->
         <xsl:variable name="chc"><xsl:choose><xsl:when test="LINEAS/COLOR/@horizCabecera"><xsl:value-of select="LINEAS/COLOR/@horizCabecera"/></xsl:when><xsl:otherwise>black</xsl:otherwise></xsl:choose></xsl:variable>
         <xsl:text>#CpLCab</xsl:text><xsl:value-of select="@nombre"/> {border: <xsl:value-of select="$ghc"/>px solid <xsl:value-of select="$chc"/>;position:absolute; width:<xsl:value-of select="@ancho"/>; height:<xsl:value-of select="$ghc"/>; left: 0; top: <xsl:value-of select="$gb + $vAltoCab + $vReservadoTitulo"/><xsl:text>; overflow: hidden;}&#xa;</xsl:text>   
      </xsl:if>

      <!-- Cp Titulo -->
      <xsl:if test="TITULO">
         <xsl:variable name="imgfondTit"><xsl:if test="TITULO/@imgFondo"> background-image: url(<xsl:value-of select="$vgImgPath"/><xsl:value-of select="TITULO/@imgFondo"/>);layer-background-image: url(<xsl:value-of select="$vgImgPath"/><xsl:value-of select="TITULO/@imgFondo"/>);</xsl:if></xsl:variable>
         <xsl:variable name="colfondTit"><xsl:if test="TITULO/@colFondo"> layer-background-color: <xsl:value-of select="TITULO/@colFondo"/>; background-color: <xsl:value-of select="TITULO/@colFondo"/> ;</xsl:if></xsl:variable>
<!--         <xsl:text>#CpTit</xsl:text><xsl:value-of select="@nombre"/>{position:absolute; width:<xsl:value-of select="@ancho - (2 * $gb)"/>; height:<xsl:value-of select="$vAltoTitulo"/>; left: <xsl:value-of select="$gb"/>; top: <xsl:value-of select="$gb "/>; <xsl:value-of select="$imgfondTit"/><xsl:value-of select="$colfondTit"/><xsl:text>;}&#xa;</xsl:text> -->
         <xsl:text>#CpTit</xsl:text><xsl:value-of select="@nombre"/>{position:absolute; width:100%; height:<xsl:value-of select="$vAltoTitulo"/>; left:0; top: <xsl:value-of select="$gb "/>; <xsl:value-of select="$imgfondTit"/><xsl:value-of select="$colfondTit"/><xsl:text>;}&#xa;</xsl:text>
         <xsl:if test="not($vGrHTitulo='0')">
            <xsl:variable name="cht"><xsl:choose><xsl:when test="LINEAS/COLOR/@horizTitulo"><xsl:value-of select="LINEAS/COLOR/@horizTitulo"/></xsl:when><xsl:otherwise>black</xsl:otherwise></xsl:choose></xsl:variable>
            <!--<xsl:text>#CpLTit</xsl:text><xsl:value-of select="@nombre"/>{border: <xsl:value-of select="$vGrHTitulo"/>px solid <xsl:value-of select="$cht"/>;position:absolute; width:<xsl:value-of select="@ancho"/>; height:<xsl:value-of select="$vGrHTitulo"/>; left: 0; top: <xsl:value-of select="$gb + $vAltoTitulo"/><xsl:text>; overflow: hidden;}&#xa;</xsl:text>   -->
            <xsl:text>#CpLTit</xsl:text><xsl:value-of select="@nombre"/>{border: <xsl:value-of select="$vGrHTitulo"/>px solid <xsl:value-of select="$cht"/>;position:absolute; width:100%; height:<xsl:value-of select="$vGrHTitulo"/>; left: 0; top: <xsl:value-of select="$gb + $vAltoTitulo"/><xsl:text>; overflow: hidden;}&#xa;</xsl:text>
         </xsl:if>
      </xsl:if>

      <!-- Cp Base -->
      <xsl:if test="BASE">
         <xsl:variable name="imgfondBas"><xsl:if test="BASE/@imgFondo"> background-image: url(<xsl:value-of select="$vgImgPath"/><xsl:value-of select="BASE/@imgFondo"/>);layer-background-image: url(<xsl:value-of select="$vgImgPath"/><xsl:value-of select="BASE/@imgFondo"/>);</xsl:if></xsl:variable>
         <xsl:variable name="colfondBas"><xsl:if test="BASE/@colFondo"> layer-background-color: <xsl:value-of select="BASE/@colFondo"/>; background-color: <xsl:value-of select="BASE/@colFondo"/> ;</xsl:if></xsl:variable>
         <xsl:text>#CpBas</xsl:text><xsl:value-of select="@nombre"/>{position:absolute; width:100%; height:<xsl:value-of select="$vAltoBase"/>; left:0; top: <xsl:value-of select="@alto -$vAltoBase -$gb"/>; <xsl:value-of select="$imgfondBas"/><xsl:value-of select="$colfondBas"/><xsl:text>;}&#xa;</xsl:text>
         <xsl:if test="not($vGrHBase='0')">
            <xsl:variable name="chb"><xsl:choose><xsl:when test="LINEAS/COLOR/@horizBase"><xsl:value-of select="LINEAS/COLOR/@horizBase"/></xsl:when><xsl:otherwise>black</xsl:otherwise></xsl:choose></xsl:variable>
            <xsl:text>#CpLBas</xsl:text><xsl:value-of select="@nombre"/>{border: <xsl:value-of select="$vGrHBase"/>px solid <xsl:value-of select="$chb"/>;position:absolute; width:100%; height:<xsl:value-of select="$vGrHBase"/>; left: 0; top: <xsl:value-of select="@alto -$vReservadoBase -$gb"/><xsl:text>; overflow: hidden;}&#xa;</xsl:text>
         </xsl:if>
      </xsl:if>


      <!-- Cp Scroll -->
      <xsl:call-template name="SCROLLestilo">
         <xsl:with-param name="nombre">CpScroll<xsl:value-of select="@nombre"/></xsl:with-param>
         <xsl:with-param name="x"><xsl:value-of select="$gb"/></xsl:with-param>
         <xsl:with-param name="y"><xsl:value-of select="$vAltoCab + $ghc + $gb + $vReservadoTitulo"/></xsl:with-param>
         <xsl:with-param name="incx"><xsl:value-of select="$incSX"/></xsl:with-param>
         <xsl:with-param name="incy"><xsl:value-of select="$incSY"/></xsl:with-param>
         <xsl:with-param name="ancho"><xsl:value-of select="@ancho - ($gb * 2) -16"/></xsl:with-param>
         <xsl:with-param name="alto"><xsl:value-of select="@alto - $vAltoCab - ($gb * 2) -16 - $ghc -$vReservadoTitulo -$vReservadoBase"/></xsl:with-param>
         <xsl:with-param name="colorf"><xsl:value-of select="$colorFondo"/></xsl:with-param>
         <xsl:with-param name="visibilidad">inherit</xsl:with-param>
         <xsl:with-param name="colores"><xsl:value-of select="$cColScr"/></xsl:with-param>
      </xsl:call-template>

      <!-- Bordes -->

      <xsl:text>#CpLin1</xsl:text><xsl:value-of select="@nombre"/> {border: <xsl:value-of select="$gb"/>px solid <xsl:value-of select="$cb"/>;position:absolute; width:<xsl:value-of select="@ancho"/>; height:<xsl:value-of select="$gb"/>; left: <xsl:value-of select="@x"/>; top: <xsl:value-of select="@y"/><xsl:text>; overflow: hidden;}&#xa;</xsl:text>
      <xsl:text>#CpLin3</xsl:text><xsl:value-of select="@nombre"/> {border: <xsl:value-of select="$gb"/>px solid <xsl:value-of select="$cb"/>;position:absolute; width:<xsl:value-of select="@ancho"/>; height:<xsl:value-of select="$gb"/>; left: <xsl:value-of select="@x"/>; top: <xsl:value-of select="@alto +@y - $gb"/><xsl:text>; overflow: hidden;}&#xa;</xsl:text>
      <xsl:text>#CpLin2</xsl:text><xsl:value-of select="@nombre"/> {position:absolute; width:<xsl:value-of select="$gb"/>; height:<xsl:value-of select="@alto"/>; left: <xsl:value-of select="@x"/>; top: <xsl:value-of select="@y"/>; overflow: hidden;background-color:<xsl:value-of select="$cb"/>;layer-background-color:<xsl:value-of select="$cb"/>;clip:rect(0,<xsl:value-of select="$gb"/>,<xsl:value-of select="@alto"/><xsl:text>,0);}&#xa;</xsl:text>
      <xsl:text>#CpLin4</xsl:text><xsl:value-of select="@nombre"/> {position:absolute; width:<xsl:value-of select="$gb"/>; height:<xsl:value-of select="@alto"/>; left: <xsl:value-of select="@x + @ancho - $gb"/>; top: <xsl:value-of select="@y"/>; overflow: hidden;background-color:<xsl:value-of select="$cb"/>;layer-background-color:<xsl:value-of select="$cb"/>;clip:rect(0,<xsl:value-of select="$gb"/>,<xsl:value-of select="@alto"/><xsl:text>,0);}&#xa;</xsl:text>

      <xsl:apply-templates mode="estilo" >
         <xsl:with-param name="nsdoc">
            <xsl:value-of select="$nsdoc-local"/>
         </xsl:with-param>
      </xsl:apply-templates>

   </xsl:template>




   
   <!-- Bloque JS  ................................................................... -->
   <xsl:template match="LISTAEDITABLE" mode="script">
      <xsl:param name="nsdoc"/>
      <xsl:variable name="nsdoc-parte-local"/>
      <xsl:variable name="nsdoc-local">
         <xsl:value-of select="concat($nsdoc,'.')"/>
      </xsl:variable>

      <!-- meto lo necesario para que funcione como campo de formulario -->
      <xsl:variable name="frmNombre" select="ancestor::FORMULARIO/@nombre"/>
      <xsl:if test="$frmNombre!=''">
         <xsl:variable name="nombrFinal" select="concat($frmNombre,'.',@nombre)"/>         
         <xsl:value-of select="$nombrFinal"/><xsl:text>TC='Listado';&#xa;</xsl:text>
         <xsl:value-of select="$nombrFinal"/><xsl:text>NS='';&#xa;</xsl:text>
         <xsl:value-of select="$nombrFinal"/><xsl:text>IE='';&#xa;</xsl:text>
         <xsl:value-of select="$nombrFinal"/>OBJ='<xsl:value-of select="@nombre"/><xsl:text>';&#xa;</xsl:text>
      </xsl:if>

     
      <xsl:variable name="gb"><xsl:choose><xsl:when test="LINEAS/GROSOR/@borde"><xsl:value-of select="LINEAS/GROSOR/@borde"/></xsl:when><xsl:otherwise>2</xsl:otherwise></xsl:choose></xsl:variable>
      <xsl:variable name="gv"><xsl:choose><xsl:when test="LINEAS/GROSOR/@vertical"><xsl:value-of select="LINEAS/GROSOR/@vertical"/></xsl:when><xsl:otherwise>1</xsl:otherwise></xsl:choose></xsl:variable>
      <xsl:variable name="ghd"><xsl:choose><xsl:when test="LINEAS/GROSOR/@horizDatos"><xsl:value-of select="LINEAS/GROSOR/@horizDatos"/></xsl:when><xsl:otherwise>1</xsl:otherwise></xsl:choose></xsl:variable>
      <!--<xsl:variable name="ghc"><xsl:choose><xsl:when test="LINEAS/GROSOR/@horizCabecera"><xsl:value-of select="LINEAS/GROSOR/@horizCabecera"/></xsl:when><xsl:otherwise>2</xsl:otherwise></xsl:choose></xsl:variable>-->
      <xsl:variable name="ghc">
         <xsl:choose>
            <xsl:when test="CABECERA">
               <xsl:choose>
                  <xsl:when test="LINEAS/GROSOR/@horizCabecera">
                     <xsl:value-of select="LINEAS/GROSOR/@horizCabecera"/>
                  </xsl:when>
                  <xsl:otherwise>2</xsl:otherwise>
               </xsl:choose>
            </xsl:when>
            <xsl:otherwise>0</xsl:otherwise>
         </xsl:choose>
      </xsl:variable>

      <xsl:variable name="vAltoCabLEs">
         <xsl:choose>
            <xsl:when test="CABECERA/@alto">
               <xsl:value-of select="CABECERA/@alto"/>
            </xsl:when>
            <xsl:otherwise>
               <xsl:choose>
                  <xsl:when test="CABECERA">22</xsl:when>
                  <xsl:otherwise>0</xsl:otherwise>
               </xsl:choose>
            </xsl:otherwise>
         </xsl:choose>
      </xsl:variable>

      <xsl:variable name="cb"><xsl:choose><xsl:when test="LINEAS/COLOR/@borde"><xsl:value-of select="LINEAS/COLOR/@borde"/></xsl:when><xsl:otherwise>black</xsl:otherwise></xsl:choose></xsl:variable>
      <xsl:variable name="cvd"><xsl:choose><xsl:when test="LINEAS/COLOR/@vertDatos"><xsl:value-of select="LINEAS/COLOR/@vertDatos"/></xsl:when><xsl:otherwise>black</xsl:otherwise></xsl:choose></xsl:variable>
      <xsl:variable name="cvc"><xsl:choose><xsl:when test="LINEAS/COLOR/@vertCabecera"><xsl:value-of select="LINEAS/COLOR/@vertCabecera"/></xsl:when><xsl:otherwise>black</xsl:otherwise></xsl:choose></xsl:variable>
      <xsl:variable name="chd"><xsl:choose><xsl:when test="LINEAS/COLOR/@horizDatos"><xsl:value-of select="LINEAS/COLOR/@horizDatos"/></xsl:when><xsl:otherwise>black</xsl:otherwise></xsl:choose></xsl:variable>
      <xsl:variable name="chc"><xsl:choose><xsl:when test="LINEAS/COLOR/@horizCabecera"><xsl:value-of select="LINEAS/COLOR/@horizCabecera"/></xsl:when><xsl:otherwise>black</xsl:otherwise></xsl:choose></xsl:variable>
      <xsl:variable name="incSX"><xsl:choose><xsl:when test="@incScrollx"><xsl:value-of select="@incScrollx"/></xsl:when><xsl:otherwise>2</xsl:otherwise></xsl:choose></xsl:variable>
      <xsl:variable name="incSY"><xsl:choose><xsl:when test="@incScrolly"><xsl:value-of select="@incScrolly"/></xsl:when><xsl:otherwise>2</xsl:otherwise></xsl:choose></xsl:variable>
      
      <xsl:variable name="capcabdoc" select="concat('Cp',@nombre,'.document.CpCab',@nombre,'.document')"/>
      <xsl:call-template name="CAPAscript">
         <xsl:with-param name="nsdoc"><xsl:value-of select="concat($nsdoc-local,$capcabdoc)"/></xsl:with-param>
         <xsl:with-param name="nombre"><xsl:value-of select="concat('CpCab',@nombre)"/></xsl:with-param>
         <xsl:with-param name="visibilidad">visible</xsl:with-param>
      </xsl:call-template>

      <xsl:variable name="capadiv">
         <xsl:value-of select="concat('Cp',@nombre)"/>
      </xsl:variable>
      <xsl:variable name="listascroll">
         <xsl:value-of select="concat('CpScroll',@nombre)"/>
      </xsl:variable>
      <xsl:variable name="capa-nsdoc-parte-local">
         <xsl:value-of select="concat($capadiv,'.document')"/>
      </xsl:variable>
      <xsl:variable name="capa-nsdoc-local">
         <xsl:value-of select="concat($nsdoc-local,$capa-nsdoc-parte-local)"/>
      </xsl:variable>
      <xsl:variable name="nsdocSC-parte-local">
         <xsl:value-of select="concat($listascroll,'Div.document.')"/>
         <xsl:value-of select="concat($listascroll,'Divtv.document')"/>
      </xsl:variable>
      <xsl:variable name="nsdocSC-local">
         <xsl:value-of select="concat(concat($capa-nsdoc-local,'.'),$nsdocSC-parte-local)"/>
      </xsl:variable>
      <!-- parametros compuestos igual que en estilo  -->
      <xsl:call-template name="SCROLLscript">
         <xsl:with-param name="nsdoc"><xsl:value-of select="$nsdocSC-local"/></xsl:with-param>
         <xsl:with-param name="nombre">CpScroll<xsl:value-of select="@nombre"/></xsl:with-param>
         <xsl:with-param name="x"><xsl:value-of select="$gb"/></xsl:with-param>
         <xsl:with-param name="y"><xsl:value-of select="$vAltoCabLEs + ($gb * 2)"/></xsl:with-param>
         <xsl:with-param name="incx"><xsl:value-of select="$incSX"/></xsl:with-param>
         <xsl:with-param name="incy"><xsl:value-of select="$incSY"/></xsl:with-param>
         <xsl:with-param name="ancho"><xsl:value-of select="@ancho - ($gb * 2) -16"/></xsl:with-param>
         <xsl:with-param name="alto"><xsl:value-of select="@alto - $vAltoCabLEs - ($gb * 3) - 16"/></xsl:with-param>
      </xsl:call-template>

      <xsl:text>&#xa;if (!CpCab</xsl:text><xsl:value-of select="@nombre"/>) CpCab<xsl:value-of select="@nombre"/>=new Object() &#xa;CpCab<xsl:value-of select="@nombre"/>.nsLay='<xsl:value-of select="$nsdoc-local"/>Cp<xsl:value-of select="@nombre"/>.document.CpCab<xsl:value-of select="@nombre"/><xsl:text>';&#xa;</xsl:text>
      
      <!-- esto debería ir siempre -->
      <xsl:text>imgTransp="</xsl:text>
      <xsl:value-of select="$imgTranspPath"/>
      <xsl:text>";&#xa;</xsl:text>


      <xsl:variable name="vAccion">
         <xsl:if test="DATOS/@accion">
            <xsl:call-template name="escapa">
                <xsl:with-param name="text" select="DATOS/@accion"/>
                <xsl:with-param name="caracter">&quot;</xsl:with-param>
            </xsl:call-template>
         </xsl:if>
      </xsl:variable>
      <xsl:variable name="vAnchos">
         <xsl:text>[</xsl:text>
         <xsl:apply-templates select="COLUMNAS/COL" mode="GeneraAnchos"/>
         <xsl:text>]</xsl:text>
      </xsl:variable>
      <xsl:variable name="vTiposCol">
         <xsl:text>[</xsl:text>
         <xsl:apply-templates select="DATOS/COL" mode="GenTipCol"/>
         <xsl:text>]</xsl:text>
      </xsl:variable>
      <xsl:variable name="vTiposAnchos">
         <xsl:text>[</xsl:text>
         <xsl:apply-templates select="COLUMNAS/COL" mode="GenTipAnchos"/>
         <xsl:text>]</xsl:text>
      </xsl:variable>
      <xsl:variable name="vColMinimiz">
         <xsl:text>[</xsl:text>
         <xsl:apply-templates select="COLUMNAS/COL" mode="GenMinimiz"/>
         <xsl:text>]</xsl:text>
      </xsl:variable>
      <xsl:variable name="vDatos">
         <xsl:text>[</xsl:text>
         <xsl:apply-templates select="ROWSET/ROW" mode="GenDatos"/>
         <xsl:text>]</xsl:text>
      </xsl:variable>
      <xsl:variable name="vOrdenesCol">
         <xsl:text>[</xsl:text>
         <xsl:apply-templates select="COLUMNAS/COL" mode="GenOrdCol"/>
         <xsl:text>]</xsl:text>
      </xsl:variable>

      <xsl:variable name="vTxtCab">
         <xsl:text>[</xsl:text>
         <xsl:for-each select="CABECERA//COL">    
            <xsl:text>'</xsl:text>
            <xsl:choose>
               <xsl:when test="@cod">
                  <xsl:call-template name="langtxt">
                     <xsl:with-param name="pCod" select="@cod"/>
                  </xsl:call-template>
               </xsl:when>
               <xsl:otherwise>
                  <xsl:call-template name="escapa">
                     <xsl:with-param name="text" select="translate(., '&#xa;',' ')"/>
                     <xsl:with-param name="caracter">'</xsl:with-param>
                  </xsl:call-template>
               </xsl:otherwise>
            </xsl:choose>
            <xsl:text>',</xsl:text>
         </xsl:for-each>
         <xsl:text>'']</xsl:text><!-- el último campo es ficticio -->
      </xsl:variable>


      <xsl:variable name="vEstilosCab">
         <xsl:text>[</xsl:text>
         <xsl:for-each select="CABECERA//COL">    
            <xsl:text>"</xsl:text>
               <xsl:if test="@ID">
                  <xsl:value-of select="@ID"/>
               </xsl:if>
            <xsl:text>",</xsl:text>
         </xsl:for-each>
         <xsl:text>""]</xsl:text><!-- el último campo es ficticio -->
      </xsl:variable>

      <xsl:variable name="vEstilosDat">
         <xsl:text>[</xsl:text>
         <xsl:apply-templates select="DATOS/COL" mode="GenEstDat"/>
         <xsl:text>]</xsl:text>
      </xsl:variable>

      <xsl:variable name="vColoresCab">
         <xsl:text>[</xsl:text>
         <xsl:for-each select="CABECERA//COL">
            <xsl:text>"</xsl:text>
               <xsl:if test="@colFondo">
                  <xsl:value-of select="@colFondo"/>
               </xsl:if>
            <xsl:text>",</xsl:text>
         </xsl:for-each>      
         <xsl:text>""]</xsl:text><!-- el último campo es ficticio -->
      </xsl:variable>

      <xsl:variable name="vGruposCab">
         <xsl:text>[</xsl:text>

         <xsl:for-each select="CABECERA/COL | CABECERA/GRUPO">
            <xsl:if test="name() = 'COL'">null</xsl:if>
            <xsl:if test="name() = 'GRUPO'">
               <xsl:text>[</xsl:text>
               <xsl:value-of select="count(COL)"/>
               <xsl:text>,'</xsl:text>
               <xsl:choose>
                  <xsl:when test="@cod">
                     <xsl:call-template name="langtxt">
                        <xsl:with-param name="pCod" select="@cod"/>
                     </xsl:call-template>
                  </xsl:when>
                  <xsl:when test="@txt">
                     <xsl:call-template name="escapa">
                        <xsl:with-param name="text" select="translate(@txt, '&#xa;',' ')"/>
                        <xsl:with-param name="caracter">'</xsl:with-param>
                     </xsl:call-template>
                  </xsl:when>
                  <xsl:otherwise></xsl:otherwise>
               </xsl:choose>
               <xsl:text>',"</xsl:text>
               <xsl:if test="@ID">
                  <xsl:value-of select="@ID"/>
               </xsl:if>
               <xsl:text>","</xsl:text>
               <xsl:if test="@colFondo">
                  <xsl:value-of select="@colFondo"/>
               </xsl:if>
               <xsl:text>"]</xsl:text>
               <xsl:for-each select="COL">
                  <xsl:if test="not(position() = last())">,[]</xsl:if>
               </xsl:for-each>
            </xsl:if>
            <xsl:if test="not(position() = last())">,</xsl:if>
         </xsl:for-each>   
         
         <xsl:text>]</xsl:text>
      </xsl:variable>

      <xsl:variable name="vColFonScr">
         <xsl:if test="CABECERA/@colFondoScroll">
            <xsl:value-of select="CABECERA/@colFondoScroll"/>
         </xsl:if>
      </xsl:variable>

      <xsl:variable name="vAltoDat">
         <xsl:choose>
            <xsl:when test="DATOS/@alto">
               <xsl:value-of select="DATOS/@alto"/>
            </xsl:when>
            <xsl:otherwise>22</xsl:otherwise>
         </xsl:choose>
      </xsl:variable>       
      <xsl:variable name="vAnchoColMinim"><xsl:choose><xsl:when test="COLUMNAS/@anchoMinimizadas"><xsl:value-of select="COLUMNAS/@anchoMinimizadas"/></xsl:when><xsl:otherwise>9</xsl:otherwise></xsl:choose></xsl:variable>
      <xsl:variable name="vNumNbsp"><xsl:choose><xsl:when test="COLUMNAS/@blancosAInsertar"><xsl:value-of select="COLUMNAS/@blancosAInsertar"/></xsl:when><xsl:otherwise>0</xsl:otherwise></xsl:choose></xsl:variable>
      <xsl:variable name="vAjusteMin"><xsl:choose><xsl:when test="COLUMNAS/@ajustarMinimo and COLUMNAS/@ajustarMinimo='N'">false</xsl:when><xsl:otherwise>true</xsl:otherwise></xsl:choose></xsl:variable>
      <xsl:variable name="vNoWrap"><xsl:choose><xsl:when test="COLUMNAS/@sinSaltoLinea and COLUMNAS/@sinSaltoLinea='S'">true</xsl:when><xsl:otherwise>false</xsl:otherwise></xsl:choose></xsl:variable>
      <xsl:variable name="vBtnOff"><xsl:if test="IMGBOTONES/BTNSELECCION/@normal"><xsl:value-of select="$vgImgPath"/><xsl:value-of select="IMGBOTONES/BTNSELECCION/@normal"/></xsl:if></xsl:variable>
      <xsl:variable name="vBtnOn"><xsl:if test="IMGBOTONES/BTNSELECCION/@rollOver"><xsl:value-of select="$vgImgPath"/><xsl:value-of select="IMGBOTONES/BTNSELECCION/@rollOver"/></xsl:if></xsl:variable>
      <xsl:variable name="vBtnSel"><xsl:if test="IMGBOTONES/BTNSELECCION/@seleccionado"><xsl:value-of select="$vgImgPath"/><xsl:value-of select="IMGBOTONES/BTNSELECCION/@seleccionado"/></xsl:if></xsl:variable>
      <xsl:variable name="vBtnDesac"><xsl:if test="IMGBOTONES/BTNSELECCION/@desactivado"><xsl:value-of select="$vgImgPath"/><xsl:value-of select="IMGBOTONES/BTNSELECCION/@desactivado"/></xsl:if></xsl:variable>
      <xsl:variable name="vBtnMinN"><xsl:if test="IMGBOTONES/BTNMINIMIZAR/@minimizar"><xsl:value-of select="$vgImgPath"/><xsl:value-of select="IMGBOTONES/BTNMINIMIZAR/@minimizar"/></xsl:if></xsl:variable>
      <xsl:variable name="vBtnMinS"><xsl:if test="IMGBOTONES/BTNMINIMIZAR/@minimROver"><xsl:value-of select="$vgImgPath"/><xsl:value-of select="IMGBOTONES/BTNMINIMIZAR/@minimROver"/></xsl:if></xsl:variable>
      <xsl:variable name="vBtnMaxN"><xsl:if test="IMGBOTONES/BTNMINIMIZAR/@maximizar"><xsl:value-of select="$vgImgPath"/><xsl:value-of select="IMGBOTONES/BTNMINIMIZAR/@maximizar"/></xsl:if></xsl:variable>
      <xsl:variable name="vBtnMaxS"><xsl:if test="IMGBOTONES/BTNMINIMIZAR/@maximROver"><xsl:value-of select="$vgImgPath"/><xsl:value-of select="IMGBOTONES/BTNMINIMIZAR/@maximROver"/></xsl:if></xsl:variable>
      <xsl:variable name="vConRoll"><xsl:choose><xsl:when test="IMGBOTONES/@conROver and IMGBOTONES/@conROver='N'">false</xsl:when><xsl:otherwise>true</xsl:otherwise></xsl:choose></xsl:variable>
      <xsl:variable name="vBtnOrd"><xsl:if test="IMGBOTONES/BTNORDENAR/@ordenar"><xsl:value-of select="$vgImgPath"/><xsl:value-of select="IMGBOTONES/BTNORDENAR/@ordenar"/></xsl:if></xsl:variable>
      <xsl:variable name="vBtnOrdInv"><xsl:if test="IMGBOTONES/BTNORDENAR/@ordenarInv"><xsl:value-of select="$vgImgPath"/><xsl:value-of select="IMGBOTONES/BTNORDENAR/@ordenarInv"/></xsl:if></xsl:variable>
      <xsl:variable name="vMaxSel"><xsl:choose><xsl:when test="DATOS/@maxSel"><xsl:value-of select="DATOS/@maxSel"/></xsl:when><xsl:otherwise>-1</xsl:otherwise></xsl:choose></xsl:variable>
      <xsl:variable name="vOnSetDatos">
         <xsl:if test="DATOS/@onSetDatos">
            <xsl:call-template name="escapa">
                <xsl:with-param name="text" select="DATOS/@onSetDatos"/>
                <xsl:with-param name="caracter">&quot;</xsl:with-param>
            </xsl:call-template>
         </xsl:if>
      </xsl:variable>
      <xsl:variable name="vOnLoad">
         <xsl:if test="DATOS/@onLoad">
            <xsl:call-template name="escapa">
                <xsl:with-param name="text" select="DATOS/@onLoad"/>
                <xsl:with-param name="caracter">&quot;</xsl:with-param>
            </xsl:call-template>
         </xsl:if>
      </xsl:variable>
      <xsl:variable name="vOrdCol"><xsl:choose><xsl:when test="not(COLUMNAS/@permiteOrdenar)">true</xsl:when><xsl:when test="COLUMNAS/@permiteOrdenar='N'">false</xsl:when><xsl:otherwise>true</xsl:otherwise></xsl:choose></xsl:variable>
      <xsl:variable name="vFondCab"><xsl:choose><xsl:when test="CABECERA/@imgFondo"><xsl:value-of select="$vgImgPath"/><xsl:value-of select="CABECERA/@imgFondo"/></xsl:when><xsl:otherwise></xsl:otherwise></xsl:choose></xsl:variable>
      <xsl:variable name="vTxtMinim"><xsl:choose><xsl:when test="CABECERA/@txtEnMinimizadas and CABECERA/@txtEnMinimizadas='S'">true</xsl:when><xsl:otherwise>false</xsl:otherwise></xsl:choose></xsl:variable>
      <xsl:variable name="vMsgDebugJS"><xsl:choose><xsl:when test="@msgDebugJS and @msgDebugJS='S'">true</xsl:when><xsl:otherwise>false</xsl:otherwise></xsl:choose></xsl:variable>
      <xsl:variable name="vTipEnvio"><xsl:choose><xsl:when test="DATOS/@tipoEnvio"><xsl:value-of select="DATOS/@tipoEnvio"/></xsl:when><xsl:otherwise>seleccion</xsl:otherwise></xsl:choose></xsl:variable>
      <xsl:variable name="vNSdoc"><xsl:value-of select="concat($nsdoc-local,'Cp',@nombre,'.document')"/></xsl:variable>
      <xsl:variable name="vRepntCab"><xsl:choose><xsl:when test="CABECERA">true</xsl:when><xsl:otherwise>false</xsl:otherwise></xsl:choose></xsl:variable>
      <xsl:variable name="vFormaEnv"><xsl:choose><xsl:when test="DATOS/@formaEnvio"><xsl:value-of select="DATOS/@formaEnvio"/></xsl:when><xsl:otherwise>serializado</xsl:otherwise></xsl:choose></xsl:variable>

      <xsl:variable name="vDeseleccSiMax"><xsl:choose><xsl:when test="DATOS/@deseleccionaSiMaxSel and DATOS/@deseleccionaSiMaxSel='S'">true</xsl:when><xsl:otherwise>false</xsl:otherwise></xsl:choose></xsl:variable>
      <xsl:variable name="vAjustarAMitadInf"><xsl:choose><xsl:when test="CABECERA/@ajustarAMitadInf and CABECERA/@ajustarAMitadInf='S'">true</xsl:when><xsl:otherwise>false</xsl:otherwise></xsl:choose></xsl:variable>

      <xsl:variable name="vHayBotonOrdenar"><xsl:choose><xsl:when test="COLUMNAS/@botonOrdenar and COLUMNAS/@botonOrdenar='S'">true</xsl:when><xsl:otherwise>false</xsl:otherwise></xsl:choose></xsl:variable>

      <xsl:variable name="vHayTitulo"><xsl:choose><xsl:when test="TITULO and not(TITULO/@alto='0')">true</xsl:when><xsl:otherwise>false</xsl:otherwise></xsl:choose></xsl:variable>

      <xsl:variable name="vDatosTitulo">
         <xsl:text>[</xsl:text>
         <xsl:if test="TITULO">
            <xsl:text>'</xsl:text>
            <xsl:choose>
               <xsl:when test="TITULO/@cod">
                  <xsl:call-template name="escapaCaracterYBarra">
                     <xsl:with-param name="text" ><xsl:call-template name="langtxt"><xsl:with-param name="pCod" select="TITULO/@cod"/></xsl:call-template></xsl:with-param>
                     <xsl:with-param name="caracter">'</xsl:with-param>
                  </xsl:call-template>
               </xsl:when>
               <xsl:otherwise>
                  <xsl:call-template name="escapaCaracterYBarra"><xsl:with-param name="text" select="TITULO"/><xsl:with-param name="caracter">'</xsl:with-param></xsl:call-template>
               </xsl:otherwise>
            </xsl:choose>
            <xsl:text>',</xsl:text>
            <xsl:choose><xsl:when test="TITULO/@ID">'<xsl:value-of select="TITULO/@ID"/>'</xsl:when><xsl:otherwise>''</xsl:otherwise></xsl:choose>
            <xsl:text>,</xsl:text>
            <xsl:choose><xsl:when test="TITULO/@alto"><xsl:value-of select="TITULO/@alto"/></xsl:when><xsl:otherwise>22</xsl:otherwise></xsl:choose>
         </xsl:if>
         <xsl:text>]</xsl:text>
      </xsl:variable>

      <!-- generamos el objeto JS listado con todas estas variables -->
      <xsl:value-of select="@nombre"/>=new TListado('<xsl:value-of select="@nombre"/>',<xsl:value-of select="@ancho"/>,<xsl:value-of select="@alto"/>,<xsl:value-of select="$gb"/>,<xsl:value-of select="$ghc"/>,<xsl:value-of select="$ghd"/>,<xsl:value-of select="$gv"/>
      <xsl:text>,'</xsl:text><xsl:value-of select="$chd"/>','<xsl:value-of select="$cvd"/>','<xsl:value-of select="$cvc"/>',"<xsl:value-of select="$vAccion"/>",<xsl:value-of select="$vAnchos"/>,<xsl:value-of select="$vTiposAnchos"/>,<xsl:value-of select="$vColMinimiz"/>
      <xsl:text>,</xsl:text><xsl:value-of select="$vAltoDat"/>,<xsl:value-of select="$vAltoCabLEs"/>,<xsl:value-of select="$vAnchoColMinim"/>,<xsl:value-of select="$vDatos"/>
      <xsl:text>,</xsl:text><xsl:value-of select="$vTiposCol"/>,<xsl:value-of select="$vOrdenesCol"/>,<xsl:value-of select="$vTxtCab"/>,<xsl:value-of select="$vEstilosCab"/>,<xsl:value-of select="$vColoresCab"/>,<xsl:value-of select="$vEstilosDat"/>
      <xsl:text>,</xsl:text><xsl:value-of select="$vNumNbsp"/>,<xsl:value-of select="$vAjusteMin"/>,<xsl:value-of select="$vNoWrap"/>
      <xsl:text>,"</xsl:text><xsl:value-of select="$vBtnOff"/>","<xsl:value-of select="$vBtnOn"/>","<xsl:value-of select="$vBtnSel"/>","<xsl:value-of select="$vBtnDesac"/>
      <xsl:text>","</xsl:text><xsl:value-of select="$vBtnMinN"/>","<xsl:value-of select="$vBtnMinS"/>","<xsl:value-of select="$vBtnMaxN"/>","<xsl:value-of select="$vBtnMaxS"/>
      <xsl:text>",</xsl:text><xsl:value-of select="$vConRoll"/>,"<xsl:value-of select="$vFondCab"/>",'',<xsl:value-of select="$vMaxSel"/>,"<xsl:if test="@msgErrMaxSel"><xsl:value-of select="@msgErrMaxSel"/></xsl:if>","<xsl:if test="DATOS/@colorROver"><xsl:value-of select="DATOS/@colorROver"/></xsl:if>","<xsl:if test="DATOS/@colorSelecc"><xsl:value-of select="DATOS/@colorSelecc"/></xsl:if>
      <xsl:text>",</xsl:text><xsl:value-of select="$vOrdCol"/>,"<xsl:value-of select="$vOnSetDatos"/>",<xsl:value-of select="$vTxtMinim"/>,<xsl:value-of select="$vMsgDebugJS"/>,"<xsl:value-of select="$vTipEnvio"/>","<xsl:value-of select="$vFormaEnv"/>","<xsl:value-of select="$vNSdoc"/>","<xsl:value-of select="$vOnLoad"/>",<xsl:value-of select="$vRepntCab"/>,"<xsl:value-of select="$vColFonScr"/>",<xsl:value-of select="$vGruposCab"/>,<xsl:value-of select="$vDeseleccSiMax"/>,<xsl:value-of select="$vAjustarAMitadInf"/>
      <xsl:text>,"</xsl:text><xsl:value-of select="$vBtnOrd"/>","<xsl:value-of select="$vBtnOrdInv"/>",<xsl:value-of select="$vHayBotonOrdenar"/>
      <xsl:text>,</xsl:text><xsl:value-of select="$vHayTitulo"/>,<xsl:value-of select="$vDatosTitulo"/>
      <xsl:text>);</xsl:text>

      
      <!-- Precarga de las imágenes -->
      <xsl:if test="IMGBOTONES/@precarga and IMGBOTONES/@precarga='S'">      
         <xsl:text>&#xa;DrPrecargaImg(""</xsl:text>
         <xsl:if test="IMGBOTONES/BTNSELECCION/@normal">,"<xsl:value-of select="IMGBOTONES/BTNSELECCION/@normal"/>"</xsl:if>
         <xsl:if test="IMGBOTONES/BTNSELECCION/@rollOver">,"<xsl:value-of select="IMGBOTONES/BTNSELECCION/@rollOver"/>"</xsl:if>
         <xsl:if test="IMGBOTONES/BTNSELECCION/@seleccionado">,"<xsl:value-of select="IMGBOTONES/BTNSELECCION/@seleccionado"/>"</xsl:if>
         <xsl:if test="IMGBOTONES/BTNSELECCION/@desactivado">,"<xsl:value-of select="IMGBOTONES/BTNSELECCION/@desactivado"/>"</xsl:if>
         <xsl:if test="IMGBOTONES/BTNMINIMIZAR/@minimizar">,"<xsl:value-of select="IMGBOTONES/BTNMINIMIZAR/@minimizar"/>"</xsl:if>
         <xsl:if test="IMGBOTONES/BTNMINIMIZAR/@minimROver">,"<xsl:value-of select="IMGBOTONES/BTNMINIMIZAR/@minimROver"/>"</xsl:if>
         <xsl:if test="IMGBOTONES/BTNMINIMIZAR/@maximizar">,"<xsl:value-of select="IMGBOTONES/BTNMINIMIZAR/@maximizar"/>"</xsl:if>
         <xsl:if test="IMGBOTONES/BTNMINIMIZAR/@maximROver">,"<xsl:value-of select="IMGBOTONES/BTNMINIMIZAR/@maximROver"/>"</xsl:if>
         <xsl:text>);&#xa;</xsl:text>
      </xsl:if>

      <xsl:apply-templates  mode="script">
         <xsl:with-param name="nsdoc">
            <xsl:value-of select="$nsdoc"/>  
         </xsl:with-param>
      </xsl:apply-templates>
      
   </xsl:template>

   
   <xsl:template match="COLUMNAS/COL" mode="GeneraAnchos">
      <xsl:choose>
         <xsl:when test="not(@ancho)">1</xsl:when>
         <xsl:otherwise><xsl:value-of select="@ancho"/></xsl:otherwise>
      </xsl:choose>
      <xsl:if test="not(position()=last())">,</xsl:if>
   </xsl:template>

   <xsl:template match="DATOS/COL" mode="GenTipCol">
      <xsl:text>[</xsl:text>
      <xsl:variable name="posic" select="position()"/>
      <xsl:variable name="col" select="../../COLUMNAS/COL[position()=$posic]"/>
      <xsl:if test="$col/@oculta and $col/@oculta='S'">"OCULTA",</xsl:if>
      <xsl:if test="$col/@minimizada and $col/@minimizada='S'">"MINIMIZADA",</xsl:if>
      <xsl:if test="@tipo">
         <xsl:choose>
            <xsl:when test="@tipo='boton'">"BOTON"</xsl:when>
            <xsl:when test="@tipo='cajatexto'">
               <xsl:variable name="vValid">
                  <xsl:if test="@validacion"><xsl:call-template name="escapa"><xsl:with-param name="text" select="@validacion"/><xsl:with-param name="caracter">&quot;</xsl:with-param></xsl:call-template></xsl:if>
               </xsl:variable>
               <xsl:variable name="vReq"><xsl:choose><xsl:when test="@req"><xsl:value-of select="@req"/></xsl:when><xsl:otherwise>N</xsl:otherwise></xsl:choose></xsl:variable>
               <xsl:variable name="vOnchange"><xsl:if test="@onchange"><xsl:call-template name="escapaCaracterYBarra"><xsl:with-param name="text" select="@onchange"/><xsl:with-param name="caracter">"</xsl:with-param></xsl:call-template></xsl:if></xsl:variable>
               <xsl:variable name="vOnTab"><xsl:if test="@onTab"><xsl:call-template name="escapaCaracterYBarra"><xsl:with-param name="text" select="@onTab"/><xsl:with-param name="caracter">"</xsl:with-param></xsl:call-template></xsl:if></xsl:variable>
               <xsl:variable name="vOnShTab"><xsl:if test="@onShTab"><xsl:call-template name="escapaCaracterYBarra"><xsl:with-param name="text" select="@onShTab"/><xsl:with-param name="caracter">"</xsl:with-param></xsl:call-template></xsl:if></xsl:variable>
               <xsl:variable name="vOnBlur"><xsl:if test="@onBlur"><xsl:call-template name="escapaCaracterYBarra"><xsl:with-param name="text" select="@onBlur"/><xsl:with-param name="caracter">"</xsl:with-param></xsl:call-template></xsl:if></xsl:variable>
               <xsl:variable name="vDeshab"><xsl:choose><xsl:when test="@deshabilitado and @deshabilitado='S'">true</xsl:when><xsl:otherwise>false</xsl:otherwise></xsl:choose></xsl:variable>
               <xsl:variable name="vOnKeyDown"><xsl:if test="@onKeyDown"><xsl:call-template name="escapaCaracterYBarra"><xsl:with-param name="text" select="@onKeyDown"/><xsl:with-param name="caracter">"</xsl:with-param></xsl:call-template></xsl:if></xsl:variable>
               <xsl:text>"CAJATEXTO","</xsl:text><xsl:value-of select="@nombre"/>",<xsl:value-of select="@size"/>,<xsl:value-of select="@max"/>,"<xsl:value-of select="@IDOBJ"/>","<xsl:value-of select="$vValid"/>","<xsl:value-of select="$vReq"/>","<xsl:value-of select="$vOnchange"/>",<xsl:value-of select="$vDeshab"/>,"<xsl:value-of select="$vOnTab"/>","<xsl:value-of select="$vOnShTab"/>","<xsl:value-of select="$vOnBlur"/>","<xsl:value-of select="$vOnKeyDown"/><xsl:text>"</xsl:text>
            </xsl:when>
            <xsl:when test="@tipo='areatexto'">
               <xsl:variable name="vValid">
                  <xsl:if test="@validacion"><xsl:call-template name="escapa"><xsl:with-param name="text" select="@validacion"/><xsl:with-param name="caracter">&quot;</xsl:with-param></xsl:call-template></xsl:if>
               </xsl:variable>
               <xsl:variable name="vOnchange"><xsl:if test="@onchange"><xsl:call-template name="escapaCaracterYBarra"><xsl:with-param name="text" select="@onchange"/><xsl:with-param name="caracter">"</xsl:with-param></xsl:call-template></xsl:if></xsl:variable>
               <xsl:variable name="vCols"><xsl:if test="@cols"><xsl:value-of select="@cols"/></xsl:if></xsl:variable>
               <xsl:variable name="vRows"><xsl:if test="@rows"><xsl:value-of select="@rows"/></xsl:if></xsl:variable>
               <xsl:variable name="vReq"><xsl:choose><xsl:when test="@req"><xsl:value-of select="@req"/></xsl:when><xsl:otherwise>N</xsl:otherwise></xsl:choose></xsl:variable>
               <xsl:text>"AREATEXTO","</xsl:text><xsl:value-of select="@nombre"/>",<xsl:value-of select="$vRows"/>,<xsl:value-of select="$vCols"/>,"<xsl:value-of select="@IDOBJ"/>","<xsl:value-of select="$vValid"/>","<xsl:value-of select="$vReq"/>","<xsl:value-of select="$vOnchange"/><xsl:text>"</xsl:text>
            </xsl:when>
            <xsl:when test="@tipo='checkbox'">
               <xsl:variable name="vOnTab"><xsl:if test="@onTab"><xsl:call-template name="escapaCaracterYBarra"><xsl:with-param name="text" select="@onTab"/><xsl:with-param name="caracter">"</xsl:with-param></xsl:call-template></xsl:if></xsl:variable>
               <xsl:variable name="vOnShTab"><xsl:if test="@onShTab"><xsl:call-template name="escapaCaracterYBarra"><xsl:with-param name="text" select="@onShTab"/><xsl:with-param name="caracter">"</xsl:with-param></xsl:call-template></xsl:if></xsl:variable>
               <xsl:variable name="vOnchange"><xsl:if test="@onchange"><xsl:call-template name="escapaCaracterYBarra"><xsl:with-param name="text" select="@onchange"/><xsl:with-param name="caracter">"</xsl:with-param></xsl:call-template></xsl:if></xsl:variable>
               <xsl:variable name="vDeshab"><xsl:choose><xsl:when test="@deshabilitado and @deshabilitado='S'">true</xsl:when><xsl:otherwise>false</xsl:otherwise></xsl:choose></xsl:variable>
               <xsl:text>"CHECKBOX","</xsl:text><xsl:value-of select="@nombre"/>","N","<xsl:value-of select="$vOnchange"/>","<xsl:value-of select="$vOnTab"/>","<xsl:value-of select="$vOnShTab"/>",<xsl:value-of select="$vDeshab"/>
            </xsl:when>
            <xsl:when test="@tipo='combo'">
               <xsl:variable name="vOnTab"><xsl:if test="@onTab"><xsl:call-template name="escapaCaracterYBarra"><xsl:with-param name="text" select="@onTab"/><xsl:with-param name="caracter">"</xsl:with-param></xsl:call-template></xsl:if></xsl:variable>
               <xsl:variable name="vOnShTab"><xsl:if test="@onShTab"><xsl:call-template name="escapaCaracterYBarra"><xsl:with-param name="text" select="@onShTab"/><xsl:with-param name="caracter">"</xsl:with-param></xsl:call-template></xsl:if></xsl:variable>
               <xsl:variable name="vReq"><xsl:choose><xsl:when test="@req"><xsl:value-of select="@req"/></xsl:when><xsl:otherwise>N</xsl:otherwise></xsl:choose></xsl:variable>
               <xsl:variable name="vMult"><xsl:choose><xsl:when test="@multiple and @multiple='S'">true</xsl:when><xsl:otherwise>false</xsl:otherwise></xsl:choose></xsl:variable>
               <xsl:variable name="vSiz"><xsl:choose><xsl:when test="@size"><xsl:value-of select="@size"/></xsl:when><xsl:otherwise>1</xsl:otherwise></xsl:choose></xsl:variable>
               <xsl:variable name="vDeshab"><xsl:choose><xsl:when test="@deshabilitado and @deshabilitado='S'">true</xsl:when><xsl:otherwise>false</xsl:otherwise></xsl:choose></xsl:variable>
               <xsl:variable name="vOnchange"><xsl:if test="@onchange"><xsl:call-template name="escapaCaracterYBarra"><xsl:with-param name="text" select="@onchange"/><xsl:with-param name="caracter">"</xsl:with-param></xsl:call-template></xsl:if></xsl:variable>
               <xsl:text>"COMBO","</xsl:text><xsl:value-of select="@nombre"/>",[<xsl:apply-templates select="ROWSET/ROW" mode="GenDatCombo"/>],"<xsl:value-of select="@IDOBJ"/>","<xsl:value-of select="$vReq"/>",<xsl:value-of select="$vMult"/>,<xsl:value-of select="$vSiz"/>,"<xsl:value-of select="$vOnchange"/>",<xsl:value-of select="$vDeshab"/>,"<xsl:value-of select="$vOnTab"/>","<xsl:value-of select="$vOnShTab"/><xsl:text>"</xsl:text>
            </xsl:when>
            <xsl:when test="@tipo='imagen'">
               <xsl:text>"IMAGEN"</xsl:text>
            </xsl:when>
            <xsl:when test="@tipo='radiobutton'">
               <xsl:variable name="vReq"><xsl:choose><xsl:when test="@req"><xsl:value-of select="@req"/></xsl:when><xsl:otherwise>N</xsl:otherwise></xsl:choose></xsl:variable>
               <xsl:variable name="rbinputs">
                  <xsl:text>[</xsl:text>
                  <xsl:for-each select="RBINPUT">
                     <xsl:text>["</xsl:text>
                     <xsl:call-template name="escapa"><xsl:with-param name="text" select="@valor"/><xsl:with-param name="caracter">&quot;</xsl:with-param></xsl:call-template>
                     <xsl:text>","</xsl:text>
                     <xsl:choose>
                        <xsl:when test="@cod">
                           <xsl:call-template name="escapa">
                              <xsl:with-param name="text" >
                                 <xsl:call-template name="langtxt">
                                    <xsl:with-param name="pCod" select="@cod"/>
                                 </xsl:call-template>
                              </xsl:with-param>
                              <xsl:with-param name="caracter">&quot;</xsl:with-param>
                           </xsl:call-template>
                        </xsl:when>
                        <xsl:otherwise>
                           <xsl:call-template name="escapa"><xsl:with-param name="text" select="."/><xsl:with-param name="caracter">&quot;</xsl:with-param></xsl:call-template>
                        </xsl:otherwise>
                     </xsl:choose>
                     <xsl:text>"]</xsl:text>
                     <xsl:if test="not(position()=last())">,</xsl:if>
                  </xsl:for-each>
                  <xsl:text>]</xsl:text>
               </xsl:variable>
               <xsl:text>"RADIOBUTTON","</xsl:text><xsl:value-of select="@nombre"/>",<xsl:value-of select="$rbinputs"/>,"<xsl:value-of select="$vReq"/><xsl:text>"</xsl:text>
            </xsl:when>
            <xsl:when test="@tipo='botonytexto'"> <!-- normal|rollover|js|texto|ID-->
               <xsl:text>"BOTONYTEXTO"</xsl:text>
            </xsl:when>
            <xsl:otherwise>"TEXTO"</xsl:otherwise>
         </xsl:choose>
      </xsl:if>
      <xsl:if test="not(@tipo)">"TEXTO"</xsl:if>
      <xsl:text>]</xsl:text>
      <xsl:if test="not(position()=last())">,</xsl:if>
   </xsl:template>

   <xsl:template match="ROWSET/ROW" mode="GenDatCombo">
      <xsl:variable name="cod" select="concat(CAMPO[1]/@VALOR,CAMPO[1])"/>
      <xsl:variable name="desc" select="concat(CAMPO[2]/@VALOR,CAMPO[2])"/>
      <xsl:text>["</xsl:text>
      <xsl:value-of select="$cod"/>","<xsl:value-of select="$desc"/>
      <xsl:text>"]</xsl:text>
      <xsl:if test="not(position()=last())">,</xsl:if>
   </xsl:template>

   <xsl:template match="COLUMNAS/COL" mode="GenTipAnchos">
      <xsl:text>"</xsl:text>
      <xsl:if test="@tipoAncho and @tipoAncho='fijo'">F</xsl:if>
      <xsl:text>"</xsl:text>
      <xsl:if test="not(position()=last())">,</xsl:if>
   </xsl:template>

   <xsl:template match="COLUMNAS/COL" mode="GenMinimiz">
      <xsl:if test="@minimizable and @minimizable='S'">1</xsl:if>
      <xsl:if test="not(@minimizable and @minimizable='S')">0</xsl:if>
      <xsl:if test="not(position()=last())">,</xsl:if>
   </xsl:template>

   <xsl:template match="ROWSET/ROW" mode="GenDatos">
      <xsl:text>[</xsl:text>
      <xsl:apply-templates select="CAMPO" mode="GenDatos"/>
      <xsl:text>]</xsl:text>
      <xsl:if test="not(position()=last())">,</xsl:if>
   </xsl:template>

   <xsl:template match="CAMPO" mode="GenDatos">
      <xsl:text>"</xsl:text>
      <xsl:call-template name="escapa">
          <xsl:with-param name="text" select="concat(@VALOR,.)"/>
          <xsl:with-param name="caracter">&quot;</xsl:with-param>
      </xsl:call-template>
      <xsl:text>"</xsl:text>
      <xsl:if test="not(position()=last())">,</xsl:if>
   </xsl:template>

   <xsl:template match="COLUMNAS/COL" mode="GenOrdCol">
      <xsl:if test="@orden and @orden='numerico'">1</xsl:if>
      <xsl:if test="not(@orden and @orden='numerico')">0</xsl:if>
      <xsl:if test="not(position()=last())">,</xsl:if>
   </xsl:template>

<!--   <xsl:template match="CABECERA//COL" mode="GenTxtCab">
      <xsl:text>'</xsl:text>
      <xsl:choose>
         <xsl:when test="@cod">
            <xsl:call-template name="langtxt">
               <xsl:with-param name="pCod" select="@cod"/>
            </xsl:call-template>
         </xsl:when>
         <xsl:otherwise>
            <xsl:call-template name="escapa">
               <xsl:with-param name="text" select="translate(., '&#xa;',' ')"/>
               <xsl:with-param name="caracter">'</xsl:with-param>
            </xsl:call-template>
         </xsl:otherwise>
      </xsl:choose>
      <xsl:text>'</xsl:text>

      <xsl:if test="not(position()=last())">,</xsl:if>
   </xsl:template>
   <xsl:template match="CABECERA/COL" mode="GenEstCab">
      <xsl:text>"</xsl:text>
         <xsl:if test="@ID">
            <xsl:value-of select="@ID"/>
         </xsl:if>
      <xsl:text>"</xsl:text>
      <xsl:if test="not(position()=last())">,</xsl:if>
   </xsl:template>
   <xsl:template match="CABECERA/COL" mode="GenColCab">
      <xsl:text>"</xsl:text>
         <xsl:if test="@colFondo">
            <xsl:value-of select="@colFondo"/>
         </xsl:if>
      <xsl:text>"</xsl:text>
      <xsl:if test="not(position()=last())">,</xsl:if>
   </xsl:template>
   -->

   <xsl:template match="DATOS/COL" mode="GenEstDat">
      <xsl:text>["</xsl:text>
         <xsl:if test="@ID">
            <xsl:value-of select="@ID"/>
         </xsl:if>
      <xsl:text>"]</xsl:text>
      <xsl:if test="not(position()=last())">,</xsl:if>
   </xsl:template>




   <!-- Llamada Inicial JS  ............................................................... -->
   <xsl:template match="LISTAEDITABLE" mode="init">

       <!--alert('err1');-->

      <!-- scroll interno -->
      <xsl:call-template name="SCROLLinit">
         <xsl:with-param name="nombre"><xsl:value-of select="concat('CpScroll',@nombre)"/></xsl:with-param>
      </xsl:call-template>
      
<!--       alert('err2');      -->
      
      <!-- preparamos el sincronizado de capas -->

      <xsl:variable name="gb"><xsl:choose><xsl:when test="LINEAS/GROSOR/@borde"><xsl:value-of select="LINEAS/GROSOR/@borde"/></xsl:when><xsl:otherwise>2</xsl:otherwise></xsl:choose></xsl:variable>

      <xsl:if test="CABECERA">
         <xsl:text>&#xa;CpScroll</xsl:text><xsl:value-of select="@nombre"/>.asociax='CpCab<xsl:value-of select="@nombre"/>';&#xa;CpScroll<xsl:value-of select="@nombre"/>.tipoAsoc='scrollInterno';&#xa;CpScroll<xsl:value-of select="@nombre"/>.xoffset=<xsl:value-of select="$gb"/><xsl:text>;&#xa;</xsl:text>
      </xsl:if>
      <xsl:text>&#xa;</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>.init();&#xa;</xsl:text>

      <xsl:apply-templates mode="init"/>

   </xsl:template>



   
   <!-- BLOQUE HTML ......................................................................-->
   <xsl:template match="LISTAEDITABLE" mode="body">
      <xsl:param name="nsdoc"/>
      <xsl:variable name="nsdoc-parte-local"/>
      <xsl:variable name="nsdoc-local">
         <xsl:value-of select="concat($nsdoc,$nsdoc-parte-local)"/>
      </xsl:variable>

      <xsl:variable name="incSX"><xsl:choose><xsl:when test="@incScrollx"><xsl:value-of select="@incScrollx"/></xsl:when><xsl:otherwise>2</xsl:otherwise></xsl:choose></xsl:variable>
      <xsl:variable name="incSY"><xsl:choose><xsl:when test="@incScrolly"><xsl:value-of select="@incScrolly"/></xsl:when><xsl:otherwise>2</xsl:otherwise></xsl:choose></xsl:variable>
      
      <DIV ID="Cp{@nombre}">
         <xsl:if test="CABECERA">
            <xsl:apply-templates select="CABECERA"/>
         </xsl:if>
         <xsl:if test="TITULO">
            <DIV ID="CpTit{@nombre}" />
            <xsl:if test="(TITULO and not(GROSOR/@horizTitulo)) or (TITULO and not(GROSOR/@horizTitulo='0'))">
               <DIV ID="CpLTit{@nombre}" />
            </xsl:if>
         </xsl:if>
         <xsl:if test="BASE">
            <DIV ID="CpBas{@nombre}" />
            <xsl:if test="(BASE and not(GROSOR/@horizBase)) or (BASE and not(GROSOR/@horizBase='0'))">
               <DIV ID="CpLBas{@nombre}" />
            </xsl:if>
         </xsl:if>
         <xsl:call-template name="SCROLLbody">
            <xsl:with-param name="nsdoc"><xsl:value-of select="$nsdoc-local"/></xsl:with-param>
            <xsl:with-param name="nombre">CpScroll<xsl:value-of select="@nombre"/></xsl:with-param>
            <xsl:with-param name="incx"><xsl:value-of select="$incSX"/></xsl:with-param>
            <xsl:with-param name="incy"><xsl:value-of select="$incSY"/></xsl:with-param>
         </xsl:call-template>
      </DIV>

      <!-- bordes del listado -->
      <DIV ID="CpLin1{@nombre}"/>
      <DIV ID="CpLin2{@nombre}"/>
      <DIV ID="CpLin3{@nombre}"/>
      <DIV ID="CpLin4{@nombre}"/>

      <xsl:apply-templates mode="body">
         <xsl:with-param name="nsdoc">
            <xsl:value-of select="$nsdoc-local"/>
         </xsl:with-param>
      </xsl:apply-templates>
      
   </xsl:template>

   <!-- ... CABECERA ............................................. -->
   <xsl:template match="LISTAEDITABLE/CABECERA" >
      <xsl:if test="@imgFondo or @colFondo">
         <DIV ID="CpFCab{../@nombre}"/>
      </xsl:if>
      <DIV ID="CpCab{../@nombre}"/>

      <xsl:variable name="ghc"><xsl:choose><xsl:when test="../LINEAS/GROSOR/@horizCabecera"><xsl:value-of select="../LINEAS/GROSOR/@horizCabecera"/></xsl:when><xsl:otherwise>2</xsl:otherwise></xsl:choose></xsl:variable>
      <xsl:if test="../CABECERA and $ghc > 0">
         <DIV ID="CpLCab{../@nombre}"/> <!-- linea bajo la cabecera -->
      </xsl:if>
   </xsl:template>

   <!-- Lo siguiente lo captura el scroll, hay que ponerlo vacío -->
   <xsl:template match="LISTAEDITABLE/IMGBOTONES | LISTAEDITABLE/LINEAS | LISTAEDITABLE/COLUMNAS | LISTAEDITABLE/DATOS" mode="body">
   </xsl:template>

   <xsl:template match="LISTAEDITABLE/TITULO" mode="body"></xsl:template>   

   <xsl:template match="LISTAEDITABLE" mode="form">
      <INPUT TYPE="hidden" VALUE="">
         <xsl:attribute name="NAME">
            <xsl:value-of select="@nombre"/>
         </xsl:attribute>
      </INPUT>
   </xsl:template>





</xsl:stylesheet>