<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
   INDRA/CAR/Druida 3.0
   $Id: drd30_NTrejilla.xsl,v 1.1 2009/12/03 19:03:45 pecbazalar Exp $
-->
<!DOCTYPE xsl:stylesheet [
   <!ENTITY nbsp "&#160;">
]>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">

   <!--    REJILLA    -->
   <!-- *********** -->

   <!--     init    -->
   <xsl:template name="REJILLABLQinit">
      <xsl:call-template name="SCROLLinit">
         <xsl:with-param name="nombre"><xsl:value-of select="concat(@nombre,'scroll')"/></xsl:with-param>
      </xsl:call-template>
   </xsl:template>

   <!--     estilo    -->
   <xsl:template name="REJILLABLQestilo">
      <xsl:param name="nsdoc-local"/>

      <xsl:variable name="vNumColsBlq" select="@colsbloqueo + 1"/>

      <!-- Nodeset con las COLumnas a bloquear -->
      <xsl:variable name="vColsYBlq" 
                    select="PRESENTACION[@nombre='CabeceraY']/COL[position() &lt; number($vNumColsBlq)]"/>

      <!-- Ancho total de las COLumnas a bloquear -->
      <xsl:variable name="vAnchoCols" select="sum($vColsYBlq/@ancho)"/>

      <xsl:variable name="vAnchoSI" select="$vAnchoCols"/>
         <!-- 
<REJILLA nombre="MiRej" colsbloqueo="1" filasbloqueo="3" ancho="800" alto="400" x="10" y="30">
   <PRESENTACION nombre="Cabeceras">
      <COL NOMBRE="cabcol1" ancho="120" alto="40" ID="col_izq_centrado" IDULTIMA="titulo_grupo" IDPRIMERA="titulo_grupo"/>
      <COL NOMBRE="cabcol2" ancho="840" alto="40" ID="col_izq_centrado" IDULTIMA="titulo_grupo" IDPRIMERA="titulo_grupo"/>
      <ROWSET>
         <ROW>
            <CAMPO NOMBRE="1" colext="2">TABLA DE REFERENCIAS: EXTRACTO DE CLIENTES</CAMPO>
         </ROW>
         <ROW>
            <CAMPO NOMBRE="1" colext="2">TOTAL DE CLIENTES</CAMPO>
         </ROW>
         <ROW>
            <CAMPO NOMBRE="1">SEGMENTO/SUBSEG.</CAMPO>
            <CAMPO NOMBRE="2">E S T A D O</CAMPO>
         </ROW>
      </ROWSET>
   </PRESENTACION>

         Hay que saber al ancho maximo de la primeras(colsbloqueo) columnas de TODAS las PRESENTACIONES 

         -->

      <!-- el alto sera el de la primera columna * el numero de filas -->
      <xsl:variable name="vNumFilasCab" 
                    select="count(PRESENTACION[@nombre='CabeceraX']/ROWSET/ROW)"/>
      <xsl:variable name="vAltoSI" 
                    select="PRESENTACION[@nombre='CabeceraX']/COL[1]/@alto * $vNumFilasCab"/>

      <xsl:text>
</xsl:text>
<!--      <xsl:comment>
SI: x=<xsl:value-of select="@x"/>, y=<xsl:value-of select="@y"/> Ancho=<xsl:value-of select="$vAnchoSI"/>, Alto=<xsl:value-of select="$vAltoSI"/>
</xsl:comment> -->

      <!-- CAPA esquina Superior Izquierda -->
      <xsl:call-template name="CAPAestilo">
         <xsl:with-param name="nombre"><xsl:value-of select="@nombre"/>SI</xsl:with-param>
         <xsl:with-param name="x"><xsl:value-of select="@x"/></xsl:with-param>
         <xsl:with-param name="y"><xsl:value-of select="@y"/></xsl:with-param>
         <xsl:with-param name="visibilidad">visible</xsl:with-param>
         <xsl:with-param name="colborde"></xsl:with-param>
         <xsl:with-param name="padding"></xsl:with-param>
         <xsl:with-param name="ancho"><xsl:value-of select="$vAnchoSI"/></xsl:with-param>
         <xsl:with-param name="alto"><xsl:value-of select="$vAltoSI"/></xsl:with-param>
         <xsl:with-param name="zindex">0</xsl:with-param>
         <xsl:with-param name="colorf"></xsl:with-param>
         <xsl:with-param name="imagen"></xsl:with-param>
         <xsl:with-param name="repeat"></xsl:with-param>
      </xsl:call-template>
      

      <!-- CAPA esquina Superior Derecha -->
      <xsl:variable name="vAnchoSD" select="@ancho - $vAnchoSI"/>
      <xsl:variable name="vAltoSD" select="$vAltoSI"/>

      <xsl:text>
</xsl:text>
<!--      <xsl:comment>
SD: x=<xsl:value-of select="@x + $vAnchoSI"/>, y=<xsl:value-of select="@y"/> Ancho=<xsl:value-of select="$vAnchoSD"/>, Alto=<xsl:value-of select="$vAltoSD"/>
</xsl:comment> -->

      <xsl:call-template name="CAPAestilo">
         <xsl:with-param name="nombre"><xsl:value-of select="@nombre"/>SD</xsl:with-param>
         <xsl:with-param name="x">0</xsl:with-param>
         <xsl:with-param name="y">0</xsl:with-param>
         <xsl:with-param name="visibilidad">visible</xsl:with-param>
         <xsl:with-param name="colborde"></xsl:with-param>
         <xsl:with-param name="padding"></xsl:with-param>
         <xsl:with-param name="ancho"/>
         <xsl:with-param name="alto"/>
         <xsl:with-param name="zindex">0</xsl:with-param>
         <xsl:with-param name="colorf"></xsl:with-param>
         <xsl:with-param name="imagen"></xsl:with-param>
         <xsl:with-param name="repeat"></xsl:with-param>
      </xsl:call-template>

<!--
      <xsl:call-template name="CAPAestilo">
         <xsl:with-param name="nombre"><xsl:value-of select="@nombre"/>SD</xsl:with-param>
         <xsl:with-param name="x"><xsl:value-of select="@x + $vAnchoSI"/></xsl:with-param>
         <xsl:with-param name="y"><xsl:value-of select="@y"/></xsl:with-param>
         <xsl:with-param name="visibilidad">visible</xsl:with-param>
         <xsl:with-param name="colborde"></xsl:with-param>
         <xsl:with-param name="padding"></xsl:with-param>
         <xsl:with-param name="ancho"><xsl:value-of select="$vAnchoSD"/></xsl:with-param>
         <xsl:with-param name="alto"><xsl:value-of select="$vAltoSD"/></xsl:with-param>
         <xsl:with-param name="zindex">0</xsl:with-param>
         <xsl:with-param name="colorf"></xsl:with-param>
         <xsl:with-param name="imagen"></xsl:with-param>
         <xsl:with-param name="repeat"></xsl:with-param>
      </xsl:call-template>
-->

      <!-- CAPA esquina Inferior Izquierda -->
      <xsl:variable name="vAnchoII" select="$vAnchoSI"/>
      <xsl:variable name="vAltoII" select="@alto - $vAltoSI"/>

      <xsl:text>
</xsl:text>
<!--      <xsl:comment>
II: x=<xsl:value-of select="@x"/>, y=<xsl:value-of select="@y + $vAltoSI"/>, Ancho=<xsl:value-of select="$vAnchoII"/>, Alto=<xsl:value-of select="$vAltoII"/>
</xsl:comment> -->


      <xsl:call-template name="CAPAestilo">
         <xsl:with-param name="nombre"><xsl:value-of select="@nombre"/>II</xsl:with-param>
         <xsl:with-param name="x">0</xsl:with-param>
         <xsl:with-param name="y">0</xsl:with-param>
         <xsl:with-param name="visibilidad">visible</xsl:with-param>
         <xsl:with-param name="colborde"></xsl:with-param>
         <xsl:with-param name="padding"></xsl:with-param>
         <xsl:with-param name="ancho"/>
         <xsl:with-param name="alto"/>
         <xsl:with-param name="zindex">0</xsl:with-param>
         <xsl:with-param name="colorf"></xsl:with-param>
         <xsl:with-param name="imagen"></xsl:with-param>
         <xsl:with-param name="repeat"></xsl:with-param>
<!--
         <xsl:with-param name="nombre"><xsl:value-of select="@nombre"/>II</xsl:with-param>
         <xsl:with-param name="x"><xsl:value-of select="@x"/></xsl:with-param>
         <xsl:with-param name="y"><xsl:value-of select="@y + $vAltoSI"/></xsl:with-param>
         <xsl:with-param name="visibilidad">visible</xsl:with-param>
         <xsl:with-param name="colborde"></xsl:with-param>
         <xsl:with-param name="padding"></xsl:with-param>
         <xsl:with-param name="ancho"><xsl:value-of select="$vAnchoII"/></xsl:with-param>
         <xsl:with-param name="alto"><xsl:value-of select="$vAltoII"/></xsl:with-param>
         <xsl:with-param name="zindex">0</xsl:with-param>
         <xsl:with-param name="colorf"></xsl:with-param>
         <xsl:with-param name="imagen"></xsl:with-param>
         <xsl:with-param name="repeat"></xsl:with-param>
-->
      </xsl:call-template>

      <!-- CAPA esquina Inferior Derecha -->
      <xsl:variable name="vAnchoID" select="@ancho - $vAnchoSI"/>
      <xsl:variable name="vAltoID" select="$vAltoII"/>

      <xsl:text>
</xsl:text>


      <xsl:call-template name="SCROLLestilo">
         <xsl:with-param name="nombre"><xsl:value-of select="@nombre"/>scroll</xsl:with-param>
         <xsl:with-param name="x"><xsl:value-of select="@x + $vAnchoSI"/></xsl:with-param>
         <xsl:with-param name="y"><xsl:value-of select="@y + $vAltoSI"/></xsl:with-param>
         <xsl:with-param name="incx">10</xsl:with-param>
         <xsl:with-param name="incy">10</xsl:with-param>
         <xsl:with-param name="ancho"><xsl:value-of select="$vAnchoID"/></xsl:with-param>
         <xsl:with-param name="alto"><xsl:value-of select="$vAltoID"/></xsl:with-param>
         <xsl:with-param name="colorf"></xsl:with-param>
         <xsl:with-param name="visibilidad">inherit</xsl:with-param>
      </xsl:call-template>
<!--
      <xsl:call-template name="CAPAestilo">
         <xsl:with-param name="nombre"><xsl:value-of select="@nombre"/>ID</xsl:with-param>
         <xsl:with-param name="x"><xsl:value-of select="@x"/></xsl:with-param>
         <xsl:with-param name="y"><xsl:value-of select="@y"/></xsl:with-param>
         <xsl:with-param name="visibilidad">visible</xsl:with-param>
         <xsl:with-param name="colborde"></xsl:with-param>
         <xsl:with-param name="padding"></xsl:with-param>
         <xsl:with-param name="ancho"><xsl:value-of select="$vAnchoID"/></xsl:with-param>
         <xsl:with-param name="alto"><xsl:value-of select="$vAltoID"/></xsl:with-param>
         <xsl:with-param name="zindex">0</xsl:with-param>
         <xsl:with-param name="colorf"></xsl:with-param>
         <xsl:with-param name="imagen"></xsl:with-param>
         <xsl:with-param name="repeat"></xsl:with-param>
      </xsl:call-template>
-->
   </xsl:template>



      <!-- script -->
   <xsl:template name="REJILLABLQscript">
      <xsl:param name="nsdoc-local"/>

      <!-- Capa Superior Izquierda -->
      <xsl:variable name="capadiv-SI">
         <xsl:value-of select="concat(@nombre,'SI')"/>
      </xsl:variable>
      <xsl:variable name="capa-nsdoc-parte-local-SI">
         <xsl:value-of select="concat($capadiv-SI,'.document')"/>
      </xsl:variable>
      <xsl:variable name="capa-nsdoc-local-SI">
         <xsl:value-of select="concat($nsdoc-local,$capa-nsdoc-parte-local-SI)"/>
      </xsl:variable>

      <xsl:call-template name="CAPAscript">
         <xsl:with-param name="nsdoc"><xsl:value-of select="$capa-nsdoc-local-SI"/></xsl:with-param>
         <xsl:with-param name="nombre"><xsl:value-of select="$capadiv-SI"/></xsl:with-param>
         <xsl:with-param name="visibilidad">visible</xsl:with-param>
      </xsl:call-template>



      <!-- Capa Superior Derecha -->
      <xsl:variable name="capa0div-SD">
         <xsl:value-of select="concat(@nombre,'SD0')"/>
      </xsl:variable>
      <xsl:variable name="capa0-nsdoc-parte-local-SD">
         <xsl:value-of select="concat($capa0div-SD,'.document.')"/>
      </xsl:variable>

      <xsl:variable name="capadiv-SD">
         <xsl:value-of select="concat(@nombre,'SD')"/>
      </xsl:variable>
      <xsl:variable name="capa-nsdoc-parte-local-SD">
         <xsl:value-of select="concat($capadiv-SD,'.document')"/>
      </xsl:variable>
      <xsl:variable name="capa-nsdoc-local-SD">
         <xsl:value-of select="concat($nsdoc-local,$capa0-nsdoc-parte-local-SD,$capa-nsdoc-parte-local-SD)"/>
      </xsl:variable>


      <xsl:call-template name="CAPAscript">
         <xsl:with-param name="nsdoc"><xsl:value-of select="$capa-nsdoc-local-SD"/></xsl:with-param>
         <xsl:with-param name="nombre"><xsl:value-of select="$capadiv-SD"/></xsl:with-param>
         <xsl:with-param name="visibilidad">visible</xsl:with-param>
      </xsl:call-template>



      <!-- Capa Inferior Izquierda -->
<!--
      <xsl:variable name="capa0div">
         <xsl:value-of select="concat(@nombre,'II0')"/>
      </xsl:variable>
      <xsl:variable name="capa0-nsdoc-parte-local">
         <xsl:value-of select="concat($cap0adiv,'.document')"/>
      </xsl:variable>
      <xsl:variable name="capa0-nsdoc-local">
         <xsl:value-of select="concat($nsdoc-local,$capa0-nsdoc-parte-local)"/>
      </xsl:variable>
      <xsl:call-template name="CAPAscript">
         <xsl:with-param name="nsdoc"><xsl:value-of select="$capa0-nsdoc-local"/></xsl:with-param>
         <xsl:with-param name="nombre"><xsl:value-of select="$capa0div"/></xsl:with-param>
         <xsl:with-param name="visibilidad">visible</xsl:with-param>
      </xsl:call-template>
-->
      
      
      <xsl:variable name="capa0div-II">
         <xsl:value-of select="concat(@nombre,'II0')"/>
      </xsl:variable>
      <xsl:variable name="capa0-nsdoc-parte-local-II">
         <xsl:value-of select="concat($capa0div-II,'.document.')"/>
      </xsl:variable>

      <xsl:variable name="capadiv-II">
         <xsl:value-of select="concat(@nombre,'II')"/>
      </xsl:variable>
      <xsl:variable name="capa-nsdoc-parte-local-II">
<!--         <xsl:value-of select="concat('MirejII0.document.',$capadiv,'.document')"/> -->
         <xsl:value-of select="concat($capa0div-II,'.document')"/>
      </xsl:variable>
      <xsl:variable name="capa-nsdoc-local-II">
         <xsl:value-of select="concat($nsdoc-local,$capa0-nsdoc-parte-local-II,$capa-nsdoc-parte-local-II)"/>
      </xsl:variable>

      <xsl:variable name="vNumColsBlq" select="@colsbloqueo + 1"/>

      <!-- Nodeset con las COLumnas a bloquear -->
      <xsl:variable name="vColsYBlq" 
                    select="PRESENTACION[@nombre='CabeceraY']/COL[position() &lt; number($vNumColsBlq)]"/>

      <!-- Ancho total de las COLumnas a bloquear -->
      <xsl:variable name="vAnchoCols" select="sum($vColsYBlq/@ancho)"/>

      <xsl:variable name="vAnchoSI" select="$vAnchoCols"/>
      <!-- el alto sera el de la primera columna * el numero de filas -->
      <xsl:variable name="vNumFilasCab" 
                    select="count(PRESENTACION[@nombre='CabeceraX']/ROWSET/ROW)"/>
      <xsl:variable name="vAltoSI" 
                    select="PRESENTACION[@nombre='CabeceraX']/COL[1]/@alto * $vNumFilasCab"/>

      <xsl:variable name="vAnchoSD" select="@ancho - $vAnchoSI"/>
      <xsl:variable name="vAltoSD" select="$vAltoSI"/>

      <xsl:variable name="vAnchoII" select="$vAnchoSI"/>
      <xsl:variable name="vAltoII" select="@alto - $vAltoSI"/>
      <xsl:variable name="vAnchoID" select="@ancho - $vAnchoSI"/>
      <xsl:variable name="vAltoID" select="$vAltoII"/>

      <xsl:call-template name="CAPAscript">
         <xsl:with-param name="nsdoc"><xsl:value-of select="$capa-nsdoc-local-II"/></xsl:with-param>
         <xsl:with-param name="nombre"><xsl:value-of select="$capadiv-II"/></xsl:with-param>
         <xsl:with-param name="visibilidad">visible</xsl:with-param>
      </xsl:call-template>


      <!-- Capa Inferior Derecha 
      <xsl:variable name="capa-nsdoc-parte-local">
         <xsl:value-of select="concat($capacapa,'.document')"/>
      </xsl:variable>
      <xsl:variable name="capa-nsdoc-local">
         <xsl:value-of select="concat($nsdoc-local,'.',$capa-nsdoc-parte-local)"/>
      </xsl:variable>
      
      -->
      <xsl:variable name="vAnchoID-Scroll" select="$vAnchoSD"/>
      <xsl:variable name="vAltoID-Scroll" select="$vAltoII"/>
      <xsl:variable name="vCabHeight">0</xsl:variable>
      <xsl:variable name="pixelsborde">2</xsl:variable>
      <xsl:variable name="vIncX">10</xsl:variable>
      <xsl:variable name="vIncY">10</xsl:variable>

      <xsl:variable name="regillascroll">
         <xsl:value-of select="concat(@nombre,'scroll')"/>
      </xsl:variable>

      <xsl:variable name="nsdocSC-parte-local">
         <xsl:value-of select="concat($regillascroll,'Div.document.')"/>
         <xsl:value-of select="concat($regillascroll,'Divtv.document')"/>
      </xsl:variable>
      <xsl:variable name="nsdocSC-local">
         <xsl:value-of select="concat(concat($capa-nsdoc-local-II,'.'),$nsdocSC-parte-local)"/>
      </xsl:variable>


      <!-- parametros compuestos igual que en estilo -->
      <xsl:call-template name="SCROLLscript">
         <xsl:with-param name="nsdoc"><xsl:value-of select="$nsdocSC-local"/></xsl:with-param>
         <xsl:with-param name="nombre"><xsl:value-of select="@nombre"/>scroll</xsl:with-param>
         <xsl:with-param name="x"><xsl:value-of select="$pixelsborde"/></xsl:with-param>
         <xsl:with-param name="y"><xsl:value-of select="$vCabHeight + 2 * $pixelsborde"/></xsl:with-param>
         <xsl:with-param name="incx"><xsl:value-of select="$vIncX"/></xsl:with-param>
         <xsl:with-param name="incy"><xsl:value-of select="$vIncY"/></xsl:with-param>
         <xsl:with-param name="ancho"><xsl:value-of select="$vAnchoID-Scroll - 16 - 2 * $pixelsborde"/></xsl:with-param>
         <xsl:with-param name="alto"><xsl:value-of select="$vAltoID-Scroll - $vCabHeight - 3 * $pixelsborde"/></xsl:with-param>
      </xsl:call-template>

<!--  Sincronizacion Scroll Vertical con la capa de la izquierda (II) -->
      <xsl:value-of select="@nombre"/><xsl:text>scroll.asociay='</xsl:text><xsl:value-of select="@nombre"/><xsl:text>II';
</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>scroll.yoffset=0;
</xsl:text>

<!--  Sincronizacion Scroll Horizontal con la capa superior (SD) 
      Por defecto se sicronizan, y solo si @desplazar=N no se sincronizan   -->
      <xsl:variable name="vScrollH">
         <xsl:choose>
           <xsl:when test="PRESENTACION[@nombre='CabeceraX']/@desplazar='N'">N</xsl:when>
           <xsl:otherwise>S</xsl:otherwise>
         </xsl:choose> 
      </xsl:variable>

      <xsl:if test="$vScrollH = 'S'">
         <xsl:value-of select="@nombre"/><xsl:text>scroll.asociax='</xsl:text><xsl:value-of select="@nombre"/><xsl:text>SD';
   </xsl:text>
         <xsl:value-of select="@nombre"/><xsl:text>scroll.xoffset=0;
   </xsl:text>
      </xsl:if> 
      


<!--
      <xsl:variable name="capadiv">
         <xsl:value-of select="concat(@nombre,'ID')"/>
      </xsl:variable>
      <xsl:variable name="capa-nsdoc-parte-local">
         <xsl:value-of select="concat($capadiv,'.document')"/>
      </xsl:variable>
      <xsl:variable name="capa-nsdoc-local">
         <xsl:value-of select="concat($nsdoc-local,$capa-nsdoc-parte-local)"/>
      </xsl:variable>

      <xsl:call-template name="CAPAscript">
         <xsl:with-param name="nsdoc"><xsl:value-of select="$capa-nsdoc-local"/></xsl:with-param>
         <xsl:with-param name="nombre"><xsl:value-of select="$capadiv"/></xsl:with-param>
         <xsl:with-param name="visibilidad">visible</xsl:with-param>
      </xsl:call-template>
-->
   </xsl:template>


   <!--     body    -->
   <xsl:template name="REJILLABLQbody">
      <xsl:param name="nsdoc-local"/>

      <DIV ID="{@nombre}SI">
         <xsl:for-each select="PRESENTACION[@nombre='CabeceraY']">
            <xsl:call-template name="REJILLAPRESENTACION">
               <xsl:with-param name="pTipo">SI</xsl:with-param>
            </xsl:call-template>
         </xsl:for-each> 
      </DIV>

      <xsl:variable name="vNumColsBlq" select="@colsbloqueo + 1"/>

      <!-- Nodeset con las COLumnas a bloquear -->
      <xsl:variable name="vColsYBlq" 
                    select="PRESENTACION[@nombre='CabeceraY']/COL[position() &lt; number($vNumColsBlq)]"/>

      <!-- Ancho total de las COLumnas a bloquear -->
      <xsl:variable name="vAnchoCols" select="sum($vColsYBlq/@ancho)"/>

      <xsl:variable name="vAnchoSI" select="$vAnchoCols"/>

      <!-- el alto sera el de la primera columna * el numero de filas -->
      <xsl:variable name="vNumFilasCab" 
                    select="count(PRESENTACION[@nombre='CabeceraX']/ROWSET/ROW)"/>
      <xsl:variable name="vAltoSI" 
                    select="PRESENTACION[@nombre='CabeceraX']/COL[1]/@alto * $vNumFilasCab"/>

      <!-- CAPA esquina Superior Derecha -->
      <xsl:variable name="vAnchoSD" select="@ancho - $vAnchoSI"/>
      <xsl:variable name="vAltoSD" select="$vAltoSI"/>

      <!-- CAPA esquina Inferior Izquierda -->
      <xsl:variable name="vAnchoII" select="$vAnchoSI"/>
      <xsl:variable name="vAltoII" select="@alto - $vAltoSI"/>

      <DIV ID="{@nombre}SD0" style="position:absolute;top:{@y};left:{@x+$vAnchoSI};clip:rect(0,{$vAnchoSD},{$vAltoSD},0);">
         <DIV ID="{@nombre}SD">
            <xsl:for-each select="PRESENTACION[@nombre='CabeceraX']">
               <xsl:call-template name="REJILLAPRESENTACION">
                  <xsl:with-param name="pTipo">SD</xsl:with-param>
               </xsl:call-template>
            </xsl:for-each>
         </DIV>
      </DIV>

      <DIV ID="{@nombre}II0" style="position:absolute;top:{@y+$vAltoSI};left:{@x};clip:rect(0,{$vAnchoII},{$vAltoII},0)">
         <DIV ID="{@nombre}II">

            <xsl:for-each select="PRESENTACION[@nombre!='CabeceraX' and @nombre!='CabeceraY']">
               <xsl:call-template name="REJILLAPRESENTACION">
                  <xsl:with-param name="pTipo">II</xsl:with-param>
               </xsl:call-template>
            </xsl:for-each>

         </DIV>
      </DIV>

      <xsl:variable name="vIncX">10</xsl:variable>
      <xsl:variable name="vIncY">10</xsl:variable>

      <DIV ID="{@nombre}ID">
         <!-- body de scroll -->
         <xsl:variable name="nuevonombre">
            <xsl:value-of select="@nombre"/>
            <xsl:text>scroll</xsl:text>
         </xsl:variable>

         <xsl:call-template name="SCROLLbody">
            <xsl:with-param name="nsdoc"><xsl:value-of select="$nsdoc-local"/></xsl:with-param>
            <xsl:with-param name="nombre"><xsl:value-of select="$nuevonombre"/></xsl:with-param>
            <xsl:with-param name="incx"><xsl:value-of select="$vIncX"/></xsl:with-param> 
            <xsl:with-param name="incy"><xsl:value-of select="$vIncY"/></xsl:with-param>
         </xsl:call-template>
      </DIV>

   </xsl:template>



   <xsl:template name="REJILLAPRESENTACION">
      <xsl:param name="pTipo"/>

         <TABLE border="0" cellpadding="0" cellspacing="0" bgcolor="{../@colorf}">	
            <xsl:if test="@ID">
               <xsl:attribute name="id"><xsl:value-of select="@ID"/></xsl:attribute>
            </xsl:if> 
            <xsl:if test="@espaciado">
               <xsl:attribute name="cellspacing"><xsl:value-of select="@espaciado"/></xsl:attribute>
            </xsl:if> 

            <xsl:variable name="vNumFilas" select="count(ROWSET/ROW)"/>

            <xsl:for-each select="ROWSET/ROW">
               <TR>            	
                  <!-- Ver estilo a aplicar -->
                  <xsl:variable name="vFilaActual" select="position()"/>

                  <xsl:variable name="vUltima">
                     <xsl:choose>
                       <xsl:when test="position()=last()">S</xsl:when>
                       <xsl:otherwise>N</xsl:otherwise>
                     </xsl:choose> 
                  </xsl:variable>

                  <xsl:variable name="vPrimera">
                     <xsl:choose>
                       <xsl:when test="position()=1">S</xsl:when>
                       <xsl:otherwise>N</xsl:otherwise>
                     </xsl:choose> 
                  </xsl:variable>

                  <!-- condicional, selecciono los campos necesarios 
                     La capa Inferior izquierda hay que seleccionar los campos menores de REJILLA/@colsbloqueo
                  -->


<!--                  <xsl:for-each select="CAMPO">  -->


                     <xsl:variable name="vCampoActual" select="position()"/>

                     <xsl:choose>
                        <xsl:when test="$pTipo='II'"> 
                           <!-- trato columnas bloqueadas -->
                           <xsl:for-each select="CAMPO[position() &lt;= ancestor::REJILLA/@colsbloqueo and not (preceding-sibling::CAMPO/@colext > 0)]">
                              <xsl:call-template name="REJILLAPRESENTACIONCAMPO">
                                 <xsl:with-param name="pTipo" select="$pTipo"/>
                                 <xsl:with-param name="vCampoActual" select="position()"/>
                                 <xsl:with-param name="vNumFilas" select="$vNumFilas"/>
                                 <xsl:with-param name="vFilaActual" select="$vFilaActual"/>
                                 <xsl:with-param name="vPrimera" select="$vPrimera"/>
                                 <xsl:with-param name="vUltima" select="$vUltima"/>
                              </xsl:call-template>
                           </xsl:for-each>
                        </xsl:when>
                        <xsl:when test="$pTipo='ID'">
                           <xsl:for-each select="CAMPO[position() > ancestor::REJILLA/@colsbloqueo]">
                              <xsl:call-template name="REJILLAPRESENTACIONCAMPO">
                                 <xsl:with-param name="pTipo" select="$pTipo"/>
                                 <xsl:with-param name="vCampoActual" select="position()"/>
                                 <xsl:with-param name="vNumFilas" select="$vNumFilas"/>
                                 <xsl:with-param name="vFilaActual" select="$vFilaActual"/>
                                 <xsl:with-param name="vPrimera" select="$vPrimera"/>
                                 <xsl:with-param name="vUltima" select="$vUltima"/>
                              </xsl:call-template>
                           </xsl:for-each> 
                        </xsl:when>
                        <xsl:when test="$pTipo='SD'">
                           <xsl:for-each select="CAMPO">
                              <xsl:call-template name="REJILLAPRESENTACIONCAMPO">
                                 <xsl:with-param name="pTipo" select="$pTipo"/>
                                 <xsl:with-param name="vCampoActual" select="position()"/>
                                 <xsl:with-param name="vNumFilas" select="$vNumFilas"/>
                                 <xsl:with-param name="vFilaActual" select="$vFilaActual"/>
                                 <xsl:with-param name="vPrimera" select="$vPrimera"/>
                                 <xsl:with-param name="vUltima" select="$vUltima"/>
                              </xsl:call-template>
                           </xsl:for-each> 
                        </xsl:when>
                        <xsl:when test="$pTipo='SI'">
                           <xsl:for-each select="CAMPO">
                              <xsl:call-template name="REJILLAPRESENTACIONCAMPO">
                                 <xsl:with-param name="pTipo" select="$pTipo"/>
                                 <xsl:with-param name="vCampoActual" select="position()"/>
                                 <xsl:with-param name="vNumFilas" select="$vNumFilas"/>
                                 <xsl:with-param name="vFilaActual" select="$vFilaActual"/>
                                 <xsl:with-param name="vPrimera" select="$vPrimera"/>
                                 <xsl:with-param name="vUltima" select="$vUltima"/>
                              </xsl:call-template>
                           </xsl:for-each> 
                        </xsl:when>
                        <xsl:otherwise>
                        </xsl:otherwise>
                     </xsl:choose> 



<!--                  </xsl:for-each>   -->
                  <!-- creo una primera columna para permitir agrupaciones concurrentes del resto de las columnas en una misma fila -->
                  <TD><IMG src="{$imgTranspPath}" width="0" height="{ancestor::PRESENTACION/COL[1]/@alto}"/>
                  </TD>
               </TR>            	
            </xsl:for-each> 
            

            <xsl:if test="TOTALES">
               <TR>
                  <xsl:for-each select="TOTALES/CAMPO">
                     <TD ID="{../@ID}" COLSPAN="{@colext}">
                        <xsl:choose>
                           <xsl:when test="@NOMBRE">
                              <xsl:variable name="vNombreCampo" select="@NOMBRE"/>
                              <xsl:value-of select="sum(ancestor::PRESENTACION/ROWSET/ROW/CAMPO[@NOMBRE=$vNombreCampo])"/>
                           </xsl:when>
                           <xsl:otherwise>
                              <xsl:value-of select="."/>
                           </xsl:otherwise>
                        </xsl:choose> 
                     </TD>
                  </xsl:for-each>
               </TR>
            </xsl:if> 

         </TABLE>	
<!--      </xsl:for-each>  -->
      
   
   </xsl:template>


   <xsl:template name="SUMAS">
      <xsl:param name="pNodos"/>
      <xsl:param name="pCampo"/>
      <xsl:param name="pValor"/>

      <!-- extraer la PRESENTACION de nodos -->   
      <xsl:variable name="vPresentacion">   
         <xsl:choose>
            <xsl:when test="contains($pNodos,',')">
               <xsl:value-of select="normalize-space(substring-before($pNodos,','))" />
            </xsl:when>
            <xsl:otherwise>
               <xsl:value-of select="normalize-space($pNodos)" />
            </xsl:otherwise>
         </xsl:choose>
      </xsl:variable>   

      <!-- Sumo -->   
      <xsl:variable name="vSumaLocal" select="sum(//PRESENTACION[@nombre=$vPresentacion]/ROWSET/ROW/CAMPO[@NOMBRE=$pCampo])"/>
      <xsl:variable name="vSumaParcial" select="$pValor + $vSumaLocal"/>

      <xsl:variable name="vNodosRestantes">
         <xsl:value-of select="normalize-space(substring-after($pNodos,','))" />
      </xsl:variable>

      <xsl:choose>
         <xsl:when test="string-length($vNodosRestantes)>0">
            <xsl:call-template name="SUMAS">
               <xsl:with-param name="pNodos" select="$vNodosRestantes"/>
               <xsl:with-param name="pCampo" select="$pCampo"/>
               <xsl:with-param name="pValor" select="$vSumaParcial"/>
            </xsl:call-template>
         </xsl:when>
         <xsl:otherwise>
            <xsl:value-of select="$vSumaParcial"/>
         </xsl:otherwise>
      </xsl:choose> 


   </xsl:template>



   <xsl:template name="TDFILAEXTENDER">
      <xsl:param name="pCampoActual"/>
      <xsl:param name="pEstilo"/>
      <xsl:param name="pFilaActual"/>
      <xsl:param name="pNumFilas"/>

      <xsl:variable name="vContenido" select="concat(.,@VALOR)"/>
      <xsl:variable name="vCol" select="ancestor::PRESENTACION/COL[number($pCampoActual)]"/>

      <!-- Ver los CAMPOS con el mismo contenido para rowspan -->
      <xsl:variable name="vRowSpan" select="count(ancestor::ROWSET/ROW/CAMPO[number($pCampoActual)][.=$vContenido])" /> 

      <TD ID="{$pEstilo}" height="{$vCol/@alto}">
         <xsl:if test="@colext">
            <xsl:attribute name="COLSPAN">
               <xsl:value-of select="@colext"/>
            </xsl:attribute>
         </xsl:if>

         <xsl:if test="$vCol/@agrupar='S' and $vRowSpan > 1">
            <xsl:attribute name="rowspan">
               <xsl:value-of select="$vRowSpan" /> 
            </xsl:attribute>
         </xsl:if> 
         <!--  Imagen para dimensionar exactamente las columnas.
               Se trata la última fila; teniendo en cuenta el rowspan     --> 
         <xsl:if test="$pFilaActual = $pNumFilas or $pFilaActual + $vRowSpan - 1 = $pNumFilas">
            <IMG src="{$imgTranspPath}" height="1">
               <xsl:if test="$vCol/@ancho">
                  <xsl:attribute name="width">
                     <xsl:value-of select="$vCol/@ancho"/>
                  </xsl:attribute> 
               </xsl:if> 
            </IMG><br/>
         </xsl:if> 
         <xsl:value-of select="$vContenido"/>
      </TD>
   </xsl:template>



   <xsl:template name="TDNORMAL">
      <xsl:param name="pCampoActual"/>
      <xsl:param name="pEstilo"/>
      <xsl:param name="pFilaActual"/>
      <xsl:param name="pNumFilas"/>

      <xsl:variable name="vContenido" select="concat(.,@VALOR)"/>
      <xsl:variable name="vCol" select="ancestor::PRESENTACION/COL[number($pCampoActual)]"/>
      
      <TD ID="{$pEstilo}" height="{$vCol/@alto}">
         <xsl:if test="@colext">
            <xsl:attribute name="COLSPAN">
               <xsl:value-of select="@colext"/>
            </xsl:attribute>
         </xsl:if>

         <!-- imagen para dimensionar exactamente las columnas --> 
         <xsl:if test="$pFilaActual = $pNumFilas">
            <IMG src="{$imgTranspPath}" height="1">
               <xsl:if test="$vCol/@ancho">
                  <xsl:attribute name="width">
                     <xsl:value-of select="$vCol/@ancho"/>
                  </xsl:attribute> 
               </xsl:if> 
            </IMG><br/>
         </xsl:if> 
         <xsl:value-of select="$vContenido"/>
      </TD>
   </xsl:template>




   <xsl:template name="REJILLAPRESENTACIONCAMPO">
      <xsl:param name="pTipo"/>
      <xsl:param name="vCampoActual"/>
      <xsl:param name="vNumFilas"/>
      <xsl:param name="vFilaActual"/>
      <xsl:param name="vPrimera"/>
      <xsl:param name="vUltima"/>


      <!-- REJILLAPRESENTACIONCAMPO -->
<!--                     <xsl:variable name="vCampoActual" select="position()"/> -->
      
      <xsl:variable name="vContenido" select="concat(.,@VALOR)"/>

      <xsl:variable name="vCBloqueo" select="ancestor::REJILLA/@colsbloqueo"/>

      <xsl:variable name="vCampoReal">
         <xsl:choose>
           <xsl:when test="$pTipo='ID'">
               <xsl:value-of select="$vCampoActual + $vCBloqueo"/>
           </xsl:when>
           <xsl:otherwise>
               <xsl:value-of select="$vCampoActual"/>
           </xsl:otherwise>
         </xsl:choose> 
      </xsl:variable>

      <xsl:variable name="vEstiloPrimera" select="ancestor::PRESENTACION/COL[number($vCampoReal)]/@IDPRIMERA"/>
      <xsl:variable name="vEstiloUltima"  select="ancestor::PRESENTACION/COL[number($vCampoReal)]/@IDULTIMA"/>
      <xsl:variable name="vEstiloN"       select="ancestor::PRESENTACION/COL[number($vCampoReal)]/@ID"/>
      <xsl:variable name="vEstiloPar"     select="ancestor::PRESENTACION/COL[number($vCampoReal)]/@IDPAR"/>
      <xsl:variable name="vEstiloImpar"   select="ancestor::PRESENTACION/COL[number($vCampoReal)]/@IDIMPAR"/>
      <xsl:variable name="vCol" select="ancestor::PRESENTACION/COL[number($vCampoReal)]"/>

      <!-- Ver estilo a aplicar -->
      <xsl:variable name="vEstilo">
         <xsl:choose>
            <xsl:when test="$vUltima='S'">
               <xsl:choose>
                  <xsl:when test="$vCol/@IDULTIMA">
                     <xsl:value-of select="$vCol/@IDULTIMA"/>
                  </xsl:when>
                  <xsl:otherwise>
                     <xsl:value-of select="$vCol/@ID"/>
                  </xsl:otherwise>
               </xsl:choose> 
            </xsl:when>
            <xsl:when test="$vPrimera='S'">
               <xsl:choose>
                  <xsl:when test="$vCol/@IDPRIMERA">
                     <xsl:value-of select="$vCol/@IDPRIMERA"/>
                  </xsl:when>
                  <xsl:otherwise>
                     <xsl:value-of select="$vCol/@ID"/>
                  </xsl:otherwise>
               </xsl:choose> 
            </xsl:when>
            <xsl:otherwise>
      
               <xsl:choose>
                  <xsl:when test="$vFilaActual mod 2=0">
                     <xsl:choose>
                        <xsl:when test="string-length($vEstiloPar) > 0">
                           <xsl:value-of select="$vEstiloPar"/>
                        </xsl:when>
                        <xsl:otherwise>
                           <xsl:value-of select="$vEstiloN"/>
                        </xsl:otherwise>
                     </xsl:choose> 
                  </xsl:when>
                  <xsl:otherwise>
                     <xsl:choose>
                        <xsl:when test="string-length($vEstiloImpar) > 0">
                           <xsl:value-of select="$vEstiloImpar"/>
                        </xsl:when>
                        <xsl:otherwise>
                           <xsl:value-of select="$vEstiloN"/>
                        </xsl:otherwise>
                     </xsl:choose> 
                  </xsl:otherwise>
               </xsl:choose> 

            </xsl:otherwise>
         </xsl:choose> 
      </xsl:variable> <!-- de vEstilo -->

      <xsl:variable name="vAgrupo">
         <xsl:choose>
           <xsl:when test="$vCol/@agrupar='S'">S</xsl:when>
           <xsl:otherwise>N</xsl:otherwise>
         </xsl:choose> 
      </xsl:variable> 

      <xsl:choose>
        <xsl:when test="@SUMA">
            <xsl:variable name="vNombreCampo" select="@SUMA"/>
            <xsl:variable name="vSumas">
               <xsl:call-template name="SUMAS">
                  <xsl:with-param name="pNodos" select="@PRESENTACION"/>
                  <xsl:with-param name="pCampo" select="@SUMA"/>
                  <xsl:with-param name="pValor">0</xsl:with-param>
               </xsl:call-template>
            </xsl:variable>
            <TD ID="{$vEstilo}" width="{../../../COL[number($vCampoReal)]/@ancho}" height="{../../../COL[$vCampoReal]/@alto}">
               <xsl:if test="$vFilaActual = $vNumFilas">
               <IMG src="{$imgTranspPath}"  height="1">
                  <xsl:if test="../../../COL[$vCampoReal]/@ancho">
                     <xsl:attribute name="width">
                        <xsl:value-of select="../../../COL[number($vCampoReal)]/@ancho"/>
                     </xsl:attribute> 
                  </xsl:if> 
                 </IMG><br/>
               </xsl:if> 
               <xsl:value-of select="$vSumas"/>
            </TD>
        </xsl:when>

        
        <xsl:otherwise>                     
         <!-- CAMPO normal -->
            <xsl:choose>
               <xsl:when test="$vAgrupo='N'">
                  <xsl:call-template name="TDNORMAL">
                     <xsl:with-param name="pCampoActual" select="$vCampoReal"/>
                     <xsl:with-param name="pEstilo" select="$vEstilo"/>
                     <xsl:with-param name="pFilaActual" select="$vFilaActual"/>
                     <xsl:with-param name="pNumFilas" select="$vNumFilas"/>
                  </xsl:call-template>
               </xsl:when>

               <xsl:when test="$vAgrupo='S'">
                  <xsl:choose>
                    <xsl:when test="$vPrimera='S'">
                        <xsl:call-template name="TDFILAEXTENDER">
                           <xsl:with-param name="pCampoActual" select="$vCampoReal"/>
                           <xsl:with-param name="pEstilo" select="$vEstilo"/>
                           <xsl:with-param name="pFilaActual" select="$vFilaActual"/>
                           <xsl:with-param name="pNumFilas" select="$vNumFilas"/>
                        </xsl:call-template>
                    </xsl:when>
                    <xsl:otherwise>
                        <xsl:choose>
                           <xsl:when test="ancestor::ROWSET/ROW[number($vFilaActual - 1)]/CAMPO[number($vCampoReal)] != $vContenido">
                              <xsl:call-template name="TDFILAEXTENDER">
                                 <xsl:with-param name="pCampoActual" select="$vCampoReal"/>
                                 <xsl:with-param name="pEstilo" select="$vEstilo"/>
                                 <xsl:with-param name="pFilaActual" select="$vFilaActual"/>
                                 <xsl:with-param name="pNumFilas" select="$vNumFilas"/>
                              </xsl:call-template>
                           </xsl:when>
                           <xsl:otherwise>
                              <!-- No hay TD -->
                           </xsl:otherwise>
                        </xsl:choose> 
                           
                    </xsl:otherwise>
                  </xsl:choose> 

               </xsl:when>
            </xsl:choose> 

         </xsl:otherwise>
      </xsl:choose>  

   </xsl:template>


   <xsl:template name="Estilo_PAR-IMPAR">
      <xsl:param name="vFilaActual"/>
      <xsl:param name="vCol"/>

      <xsl:choose>
         <xsl:when test="$vFilaActual mod 2 = 0">
            <xsl:choose>
               <xsl:when test="$vCol/@IDPAR">
                  <xsl:value-of select="$vCol/@IDPAR"/>
               </xsl:when>
               <xsl:otherwise>
                  <xsl:value-of select="$vCol/@ID"/>
               </xsl:otherwise>
            </xsl:choose> 
         </xsl:when>
         <xsl:otherwise>
            <xsl:choose>
               <xsl:when test="$vCol/@IDIMPAR">
                  <xsl:value-of select="$vCol/@IDIMPAR"/>
               </xsl:when>
               <xsl:otherwise>
                  <xsl:value-of select="$vCol/@ID"/>
               </xsl:otherwise>
            </xsl:choose> 
         </xsl:otherwise>
      </xsl:choose> 
   </xsl:template> 

</xsl:stylesheet>

