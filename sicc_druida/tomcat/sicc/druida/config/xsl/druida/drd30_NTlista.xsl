<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
   INDRA/CAR/Druida 3.0
   $Id: drd30_NTlista.xsl,v 1.1 2009/12/03 19:03:45 pecbazalar Exp $
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">

   <!--                                                          -->
   <!--                          HEAD                            -->
   <!--                                                          -->

   <!--                                                          -->
   <!--                         ESTILO                           -->
   <!--                                                          -->
   <xsl:template name="LISTAestilo">
      <xsl:param name="nsdoc-local"/>

      <xsl:variable name="vIncrex">
         <xsl:choose>
           <xsl:when test="@incy!='0'">
               <xsl:value-of select="number(@incx + 16)"/>
           </xsl:when>
           <xsl:otherwise>0</xsl:otherwise>
         </xsl:choose>
      </xsl:variable>
      <xsl:variable name="vIncrey">
         <xsl:choose>
            <xsl:when test="@incx!='0'">
               <xsl:value-of select="number(CABECERA/@height + @incy + 16)"/>
            </xsl:when>
           <xsl:otherwise><xsl:value-of select="CABECERA/@height"/></xsl:otherwise>
         </xsl:choose>
      </xsl:variable>

      <xsl:text>
</xsl:text>

      <xsl:call-template name="CAPAestilo">
         <xsl:with-param name="nombre"><xsl:value-of select="@nombre"/>Div</xsl:with-param>
         <xsl:with-param name="x"><xsl:value-of select="@x"/></xsl:with-param>
         <xsl:with-param name="y"><xsl:value-of select="@y"/></xsl:with-param>
         <xsl:with-param name="visibilidad"><xsl:value-of select="@visibilidad"/></xsl:with-param>
         <xsl:with-param name="colborde"></xsl:with-param>
         <xsl:with-param name="padding"></xsl:with-param>
         <xsl:with-param name="ancho"><xsl:value-of select="@ancho + $vIncrex"/></xsl:with-param>
         <xsl:with-param name="alto"><xsl:value-of select="@alto + $vIncrey"/></xsl:with-param>
         <xsl:with-param name="zindex">0</xsl:with-param>
         <xsl:with-param name="colorf"></xsl:with-param>
         <xsl:with-param name="imagen"></xsl:with-param>
         <xsl:with-param name="repeat"></xsl:with-param>
      </xsl:call-template>

      <xsl:variable name="anchoCabecera">
         <xsl:choose>
           <xsl:when test="@ajustacab='S' and @incy != '0'">
               <xsl:value-of select="@ancho + 16"/>
           </xsl:when>
           <xsl:otherwise><xsl:value-of select="@ancho + 16"/></xsl:otherwise>
         </xsl:choose> 
         
      </xsl:variable>


      <xsl:call-template name="CAPAestilo">
         <xsl:with-param name="nombre"><xsl:value-of select="@nombre"/>DivCab</xsl:with-param>
         <xsl:with-param name="x">0</xsl:with-param>
         <xsl:with-param name="y">0</xsl:with-param>
         <xsl:with-param name="visibilidad">inherit</xsl:with-param>
         <xsl:with-param name="colborde"></xsl:with-param>
         <xsl:with-param name="padding"></xsl:with-param>
         <xsl:with-param name="ancho"><xsl:value-of select="$anchoCabecera"/></xsl:with-param>
         <xsl:with-param name="alto"><xsl:value-of select="CABECERA/@height"/></xsl:with-param>
         <xsl:with-param name="zindex">0</xsl:with-param>
         <xsl:with-param name="colorf"><xsl:value-of select="@colorf"/></xsl:with-param>
         <xsl:with-param name="imagen"></xsl:with-param>
         <xsl:with-param name="repeat"></xsl:with-param>
      </xsl:call-template>

      <xsl:call-template name="SCROLLestilo">
         <xsl:with-param name="nombre"><xsl:value-of select="@nombre"/>Scroll</xsl:with-param>
         <xsl:with-param name="x">0</xsl:with-param>
         <xsl:with-param name="y"><xsl:value-of select="CABECERA/@height"/></xsl:with-param>
         <xsl:with-param name="incx"><xsl:value-of select="@incx"/></xsl:with-param>
         <xsl:with-param name="incy"><xsl:value-of select="@incy"/></xsl:with-param>
         <xsl:with-param name="ancho"><xsl:value-of select="@ancho"/></xsl:with-param>
         <xsl:with-param name="alto"><xsl:value-of select="@alto"/></xsl:with-param>
         <xsl:with-param name="colorf"><xsl:value-of select="@colorf"/></xsl:with-param>
         <xsl:with-param name="visibilidad">inherit</xsl:with-param>
      </xsl:call-template>


   </xsl:template>

   <!--                                                           -->
   <!--                            INIT                           -->
   <!--                                                           -->
   <xsl:template name="LISTAinit">
      <xsl:text>lista('</xsl:text><xsl:value-of select="@nombre"/><xsl:text>','0',[0]);lista('</xsl:text><xsl:value-of select="@nombre"/><xsl:text>','@');</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>Scroll_init();</xsl:text>
   </xsl:template>


   <!--                                                           -->
   <!--                           SCRIPT                          -->
   <!--                                                           -->
   <xsl:template name="LISTAscript">
      <xsl:param name="nsdoc-local"/>

      <xsl:text>
</xsl:text>

      <xsl:value-of select="CABECERA/@nombre"/><xsl:text>=new Object();</xsl:text><xsl:value-of select="CABECERA/@nombre"/><xsl:text>.TC='Tabla';
</xsl:text>

      <xsl:variable name="capadiv">
         <xsl:value-of select="concat(@nombre,'Div')"/>
      </xsl:variable>
      <xsl:variable name="capadivcab">
         <xsl:value-of select="concat(@nombre,'DivCab')"/>
      </xsl:variable>
      <xsl:variable name="listascroll">
         <xsl:value-of select="concat(@nombre,'Scroll')"/>
      </xsl:variable>


      <xsl:variable name="capa-nsdoc-parte-local">
         <xsl:value-of select="concat($capadiv,'.document')"/>
      </xsl:variable>
      <xsl:variable name="capa-nsdoc-local">
<!--         <xsl:value-of select="concat($nsdoc,$capa-nsdoc-parte-local)"/>  -->
         <xsl:value-of select="concat($nsdoc-local,$capa-nsdoc-parte-local)"/>
      </xsl:variable>

      <xsl:call-template name="CAPAscript">
         <xsl:with-param name="nsdoc"><xsl:value-of select="$capa-nsdoc-local"/></xsl:with-param>
         <xsl:with-param name="nombre"><xsl:value-of select="$capadiv"/></xsl:with-param>
         <xsl:with-param name="visibilidad"><xsl:value-of select="@visibilidad"/></xsl:with-param>
      </xsl:call-template>



   <!-- parte script de la lista propiamente dicha -->
      <xsl:value-of select="@nombre"/><xsl:text>=new Object();
</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>.formulario='</xsl:text><xsl:value-of select="ancestor::FORMULARIO/@nombre"/><xsl:text>';</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>.entraday=</xsl:text><xsl:value-of select="@entraday"/><xsl:text>;</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>.entradax=</xsl:text><xsl:value-of select="@entradax"/><xsl:text>;</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>.bgcolor='</xsl:text><xsl:value-of select="@colorf"/><xsl:text>';</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>.oncolor='</xsl:text><xsl:value-of select="@oncolor"/><xsl:text>';</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>.chkcolor='</xsl:text><xsl:value-of select="@chkcolor"/><xsl:text>';</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>.multiple=</xsl:text>
      <xsl:choose>
         <xsl:when test="@multisel='S'">true</xsl:when> <!-- por defecto N false -->
         <xsl:otherwise>false</xsl:otherwise>
      </xsl:choose>
      <xsl:text>;</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>.funcEstilosFilas='</xsl:text><xsl:value-of select="@funcionEstilosFilas"/><xsl:text>';</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>.min=</xsl:text><xsl:value-of select="@nmin"/><xsl:text>;</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>.max=</xsl:text><xsl:value-of select="@nmax"/><xsl:text>;
</xsl:text>


      <xsl:value-of select="@nombre"/><xsl:text>.caracteres=[</xsl:text>
      <xsl:for-each select="PRESENTACION/COL[@oculto='N' and @tipo!='indice']">
        <xsl:choose>
            <xsl:when test="@caracteres">
                <xsl:value-of select="@caracteres"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:text>0</xsl:text>
            </xsl:otherwise>
        </xsl:choose> 

         <xsl:if test="position()!=last()">
            <xsl:text>,</xsl:text>
         </xsl:if>
      </xsl:for-each>
      <xsl:text>];
</xsl:text>


   <xsl:choose>
      <xsl:when test="@accion!=''">
            <xsl:value-of select="@nombre"/>.accion="<xsl:value-of select="@accion"/><xsl:text>";</xsl:text>
      </xsl:when>
      <xsl:otherwise>
            <xsl:value-of select="@nombre"/><xsl:text>.accion=true;</xsl:text>
      </xsl:otherwise>
   </xsl:choose>


<xsl:text>
</xsl:text>
   <!-- Campos visibles -->
   <xsl:value-of select="@nombre"/><xsl:text>.col=new Array();</xsl:text>
   <xsl:value-of select="@nombre"/><xsl:text>.col[0]=[</xsl:text>

               <!-- preseleccionado -->
               <xsl:choose>
                 <xsl:when test="ancestor::PRESENTACION/@premarcado='S'">"'*'"</xsl:when>
                 <xsl:otherwise>""</xsl:otherwise>
               </xsl:choose>
            <xsl:text>,</xsl:text>

      <xsl:for-each select="PRESENTACION/COL[@oculto='N']">

         <xsl:choose>
            <xsl:when test="@tipo = 'indice'">
            </xsl:when>
            <xsl:when test="@tipo = 'campo'">
               <xsl:text>"get('</xsl:text><xsl:value-of select="@form"/><xsl:text>.</xsl:text><xsl:value-of select="@campo"/><xsl:text>')"</xsl:text>
            </xsl:when>
            <xsl:when test="@tipo = 'javascript'">
               <xsl:text>"</xsl:text><xsl:value-of select="@funcion"/><xsl:text>"</xsl:text>
            </xsl:when>
            <xsl:otherwise>
            </xsl:otherwise>
         </xsl:choose>

         <xsl:if test="position()!=last()">
            <xsl:text>,</xsl:text>
         </xsl:if>
      </xsl:for-each>
      <xsl:text>];
</xsl:text>

   <!-- Campos a enviar -->
   <xsl:value-of select="@nombre"/><xsl:text>.campos=new Array();</xsl:text>
   <xsl:value-of select="@nombre"/><xsl:text>.campos[0]=[0,</xsl:text>
      <xsl:for-each select="PRESENTACION/COL[@enviar='S']">

         <xsl:choose>
            <xsl:when test="@tipo = 'indice'"> <!-- no pasa nunca por aqui -->
               <xsl:text>""</xsl:text>
            </xsl:when>
            <xsl:when test="@tipo = 'campo'">
               <xsl:text>"get('</xsl:text><xsl:value-of select="@form"/><xsl:text>.</xsl:text><xsl:value-of select="@campo"/><xsl:text>')"</xsl:text>
            </xsl:when>
            <xsl:when test="@tipo = 'javascript'">
               <xsl:text>"</xsl:text><xsl:value-of select="@funcion"/><xsl:text>"</xsl:text>
            </xsl:when>
            <xsl:otherwise>
            </xsl:otherwise>
         </xsl:choose>

         <xsl:if test="position()!=last()">
            <xsl:text>,</xsl:text>
         </xsl:if>
      </xsl:for-each>
      <xsl:text>];
</xsl:text>


   <xsl:value-of select="@nombre"/><xsl:text>.nonulos=[0];
</xsl:text>


   <xsl:value-of select="@nombre"/><xsl:text>.entrada=new Array();
</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>.entrada[0]=</xsl:text>
      <xsl:text>'&lt;TABLE BORDER="0" CELLSPACING="1" CELLPADDING="0"&gt;&lt;TR&gt;&lt;TD&gt;</xsl:text>
      <xsl:text>&lt;TABLE BGCOLOR="" BORDER="0" CELLPADDING="0" CELLSPACING="0" WIDTH="</xsl:text><xsl:value-of select="@ancho"/><xsl:text>"&gt;&lt;TR&gt;</xsl:text>

      
      <xsl:variable name="vHayIndice">
         <xsl:choose>
           <xsl:when test="count(PRESENTACION/COL[@tipo='indice']) > 0">1</xsl:when>
           <xsl:otherwise>0</xsl:otherwise>
         </xsl:choose> 
      </xsl:variable>

      <xsl:for-each select="PRESENTACION/COL[@oculto='N']">
         <xsl:text>&lt;TD ID="</xsl:text><xsl:value-of select="@id"/>
         <xsl:text>" WIDTH="</xsl:text><xsl:value-of select="@ancho"/><xsl:text>"&gt;</xsl:text>

         <xsl:choose>

            <xsl:when test="position()=1">
<!--               <xsl:text>&amp;nbsp;$i$&amp;nbsp;</xsl:text> -->

               <xsl:choose>
                  <xsl:when test="@tipo='indice'">
                     <xsl:text>&amp;nbsp;$i$&amp;nbsp;</xsl:text>
                  </xsl:when> 
                  <xsl:otherwise>
                     <xsl:text disable-output-escaping="no">&amp;nbsp;$</xsl:text>
                     <xsl:value-of select="position() - $vHayIndice"/>
                     <xsl:text disable-output-escaping="no">$&amp;nbsp;</xsl:text>
                  </xsl:otherwise>
               </xsl:choose>

               
            
            </xsl:when>

            <xsl:otherwise>
               <xsl:text disable-output-escaping="no">&amp;nbsp;$</xsl:text>
               <xsl:value-of select="position() - $vHayIndice"/>
               <xsl:text disable-output-escaping="no">$&amp;nbsp;</xsl:text>
            </xsl:otherwise>
         </xsl:choose>


         <xsl:text>&lt;/TD&gt;</xsl:text>
      </xsl:for-each>
      <xsl:text>&lt;/TR&gt;&lt;/TABLE&gt;</xsl:text>
      <xsl:text>&lt;/TD&gt;&lt;/TR&gt;&lt;/TABLE&gt;';
</xsl:text>


   <!-- Campos visibles INICIALES -->

   <!-- Si no coincide el numero de campos de col0 y de campos0 no funciona -->

   <xsl:value-of select="@nombre"/><xsl:text>.col0=new Array();
</xsl:text>

   <xsl:for-each select="ROWSET/ROW">
      <xsl:variable name="FilActual"><xsl:value-of select="position()"/></xsl:variable>

      <xsl:value-of select="ancestor::LISTA/@nombre"/><xsl:text>.col0[</xsl:text>
      <xsl:value-of select="position() - 1"/>
<!--      <xsl:value-of select="position() - $vHayIndice"/> -->
      <xsl:text>]=[</xsl:text>

<!--     Preseleccionado   <xsl:if test="$FilActual = 1 and $ColActual = 1">"'*'"</xsl:if>  -->
      <xsl:text>""</xsl:text>

      <xsl:for-each select="CAMPO">
         <xsl:variable name="vValorSinComilladoble">
            <xsl:call-template name="escapa">
                <xsl:with-param name="text" select="translate(concat(.,@VALOR), '&#xa;',' ')"/>
                <xsl:with-param name="caracter">"</xsl:with-param>
            </xsl:call-template>
         </xsl:variable> 
         <xsl:variable name="vValorEscapado">
            <xsl:call-template name="escapa2">
                <xsl:with-param name="text" select="$vValorSinComilladoble"/>
                <xsl:with-param name="caracter">'</xsl:with-param>
            </xsl:call-template>
         </xsl:variable> 
         
         <xsl:variable name="ColActual"><xsl:value-of select="position()"/></xsl:variable>

         <xsl:if test="../../../PRESENTACION/COL[position() - $vHayIndice = $ColActual and @oculto='N' and @tipo != 'indice']">
             <xsl:text>,"</xsl:text>
             <xsl:call-template name="DELIMITA">
               <xsl:with-param name="cadena" select="$vValorEscapado"/>
               <xsl:with-param name="sep">'</xsl:with-param>
             </xsl:call-template>
             <xsl:text>"</xsl:text>
         </xsl:if>

      </xsl:for-each>

      <xsl:text>];&#xa;</xsl:text>

   </xsl:for-each>





   <!-- Campos a enviar INICIALES -->
   <xsl:value-of select="@nombre"/><xsl:text>.campos0=new Array();&#xa;</xsl:text>

   <xsl:for-each select="ROWSET/ROW">
      <xsl:variable name="FilActual"><xsl:value-of select="position()"/></xsl:variable>

      <xsl:value-of select="ancestor::LISTA/@nombre"/><xsl:text>.campos0[</xsl:text>
      <xsl:value-of select="position() - 1"/>
<!--      <xsl:value-of select="position() - $vHayIndice"/> -->
      <xsl:text>]=[</xsl:text>

      <xsl:text>0</xsl:text>

      <xsl:for-each select="CAMPO">

         <xsl:variable name="vValorSinComilladoble">
            <xsl:call-template name="escapa">
                <xsl:with-param name="text" select="translate(concat(.,@VALOR), '&#xa;',' ')"/>
                <xsl:with-param name="caracter">"</xsl:with-param>
            </xsl:call-template>
         </xsl:variable> 
         <xsl:variable name="vValorEscapado">
            <xsl:call-template name="escapa2">
                <xsl:with-param name="text" select="$vValorSinComilladoble"/>
                <xsl:with-param name="caracter">'</xsl:with-param>
            </xsl:call-template>
         </xsl:variable> 

         <xsl:variable name="ColActual"><xsl:value-of select="position()"/></xsl:variable>

         <xsl:if test="../../../PRESENTACION/COL[position() - $vHayIndice = $ColActual and @enviar='S' and @tipo!='indice']">
             <xsl:text>,"</xsl:text>
             <xsl:call-template name="DELIMITA">
               <xsl:with-param name="cadena" select="$vValorEscapado"/>
               <xsl:with-param name="sep">'</xsl:with-param>
             </xsl:call-template>
             <xsl:text>"</xsl:text>
         </xsl:if>

      </xsl:for-each>

      <xsl:text>];
</xsl:text>

   </xsl:for-each>

   <xsl:value-of select="@nombre"/><xsl:text>.separador='</xsl:text><xsl:value-of select="@sep"/><xsl:text>';</xsl:text>
   <xsl:value-of select="@nombre"/><xsl:text>.ultima=0;</xsl:text>
   <xsl:value-of select="@nombre"/><xsl:text>.V=new Vector('</xsl:text><xsl:value-of select="@nombre"/><xsl:text>.V');</xsl:text>
   <xsl:value-of select="@nombre"/><xsl:text>.H=new Vector('</xsl:text><xsl:value-of select="@nombre"/><xsl:text>.H');</xsl:text>

   <!-- FIN parte script de la lista -->

   <xsl:variable name="nsdocSC-parte-local">
      <xsl:value-of select="concat($listascroll,'Div.document.')"/>
      <xsl:value-of select="concat($listascroll,'Divtv.document')"/>
   </xsl:variable>
   <xsl:variable name="nsdocSC-local">
      <xsl:value-of select="concat(concat($capa-nsdoc-local,'.'),$nsdocSC-parte-local)"/>
   </xsl:variable>


   <xsl:call-template name="SCROLLscript">
      <xsl:with-param name="nsdoc"><xsl:value-of select="$nsdocSC-local"/></xsl:with-param>
      <xsl:with-param name="nombre"><xsl:value-of select="@nombre"/>Scroll</xsl:with-param>
      <xsl:with-param name="x">0</xsl:with-param>
      <xsl:with-param name="y"><xsl:value-of select="CABECERA/@height"/></xsl:with-param>
      <xsl:with-param name="incx"><xsl:value-of select="@incx"/></xsl:with-param>
      <xsl:with-param name="incy"><xsl:value-of select="@incy"/></xsl:with-param>
      <xsl:with-param name="ancho"><xsl:value-of select="@ancho"/></xsl:with-param>
      <xsl:with-param name="alto"><xsl:value-of select="@alto"/></xsl:with-param>
   </xsl:call-template>


   <xsl:variable name="capacab-nsdoc-parte-local">
      <xsl:value-of select="concat('.',concat($capadivcab,'.document'))"/>
   </xsl:variable>
   <xsl:variable name="capacab-nsdoc-local">
      <xsl:value-of select="concat($capa-nsdoc-local,$capacab-nsdoc-parte-local)"/>
   </xsl:variable>

   <xsl:call-template name="CAPAscript">
      <xsl:with-param name="nsdoc"><xsl:value-of select="$capacab-nsdoc-local"/></xsl:with-param>
      <xsl:with-param name="nombre"><xsl:value-of select="$capadivcab"/></xsl:with-param>
      <xsl:with-param name="visibilidad">inherit</xsl:with-param>
   </xsl:call-template>


      <!-- definicion campos ocultos -->
   <xsl:text>
</xsl:text>
   <xsl:for-each select="PRESENTACION/COL[@enviar='S']">
         <xsl:value-of select="ancestor::FORMULARIO/@nombre"/><xsl:text>.</xsl:text><xsl:value-of select="ancestor::LISTA/@nombre"/><xsl:text>H</xsl:text><xsl:value-of select="position()" /><xsl:text>TC='Hidden';
</xsl:text>
   </xsl:for-each>

   </xsl:template>



   <!--                                                          -->
   <!--                           BODY                           -->
   <!--                                                          -->
   <!--
      a diferencia de los modos estilo y script,
      aqui he duplicado todo el codigo en lugar de llamar a
      las plantillas SCROLLestilo y SCROLLscript
   -->

   <xsl:template name="LISTAbody">
      <xsl:param name="nsdoc-local"/>

      <xsl:variable name="capadiv">
         <xsl:value-of select="concat(@nombre,'Div')"/>
      </xsl:variable>
      <xsl:variable name="capadivcab">
         <xsl:value-of select="concat(@nombre,'DivCab')"/>
      </xsl:variable>

<!--   ver CAPAbody -->
      <DIV>
         <xsl:attribute name="ID">
            <xsl:value-of select="$capadiv"/>
         </xsl:attribute>

         <DIV>
            <xsl:attribute name="ID">
               <xsl:value-of select="$capadivcab"/>
            </xsl:attribute>

            <xsl:apply-templates select="CABECERA"/>


         </DIV> <!-- de capadivcab-->

      <!-- body de scroll -->
         <xsl:variable name="nuevonombre">
            <xsl:value-of select="@nombre"/>
            <xsl:text>Scroll</xsl:text>
         </xsl:variable>

         <xsl:call-template name="SCROLLbody">
            <xsl:with-param name="nsdoc"><xsl:value-of select="$nsdoc-local"/></xsl:with-param>
            <xsl:with-param name="nombre"><xsl:value-of select="$nuevonombre"/></xsl:with-param>
            <xsl:with-param name="incx"><xsl:value-of select="@incx"/></xsl:with-param>
            <xsl:with-param name="incy"><xsl:value-of select="@incy"/></xsl:with-param>
         </xsl:call-template>

      </DIV>  <!-- de $capadiv -->

   </xsl:template>


</xsl:stylesheet>

