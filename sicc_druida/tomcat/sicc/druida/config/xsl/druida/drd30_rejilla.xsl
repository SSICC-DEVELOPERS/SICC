<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
   INDRA/CAR/Druida 3.0
   $Id: drd30_rejilla.xsl,v 1.1 2009/12/03 19:03:44 pecbazalar Exp $
-->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">

   <!--    REJILLA    -->
   <!-- *********** -->

   <xsl:include href="drd30_NTrejilla.xsl" /> 
   

   <!--     head    -->
   <xsl:template match="REJILLA" mode="head">
   </xsl:template>

   <!--     init    -->
   <xsl:template match="REJILLA" mode="init">
      <xsl:if test="@colsbloqueo">
         <xsl:call-template name="REJILLABLQinit"/>
<!--            <xsl:with-param name="nsdoc-local"><xsl:value-of select="$nsdoc-local"/></xsl:with-param>
         </xsl:call-template> -->
      </xsl:if> 
   </xsl:template>


   <!--     estilo    -->
   <xsl:template match="REJILLA" mode="estilo">
      <xsl:param name="nsdoc"/>
      <xsl:variable name="nsdoc-parte-local">.</xsl:variable>
      <xsl:variable name="nsdoc-local">
         <xsl:value-of select="concat($nsdoc,$nsdoc-parte-local)"/>
      </xsl:variable>


      <xsl:if test="@colsbloqueo">
         <xsl:call-template name="REJILLABLQestilo">
            <xsl:with-param name="nsdoc-local"><xsl:value-of select="$nsdoc-local"/></xsl:with-param>
         </xsl:call-template>
      </xsl:if> 
   </xsl:template>


      <!-- script -->
   <xsl:template match="REJILLA" mode="script">
      <xsl:param name="nsdoc"/>
      <xsl:variable name="nsdoc-parte-local">.</xsl:variable>
      <xsl:variable name="nsdoc-local">
         <xsl:value-of select="concat($nsdoc,$nsdoc-parte-local)"/>
      </xsl:variable>


      <xsl:if test="@colsbloqueo">
         <xsl:call-template name="REJILLABLQscript">
            <xsl:with-param name="nsdoc-local"><xsl:value-of select="$nsdoc-local"/></xsl:with-param>
         </xsl:call-template>
      </xsl:if> 
   </xsl:template>


   <!--     body    -->
   <xsl:template match="REJILLA" mode="body">
      <xsl:param name="nsdoc"/>
      <xsl:variable name="nsdoc-parte-local">.</xsl:variable>
      <xsl:variable name="nsdoc-local">
         <xsl:value-of select="concat($nsdoc,$nsdoc-parte-local)"/>
      </xsl:variable>

      <xsl:choose>
         <xsl:when test="@colsbloqueo">
            <xsl:call-template name="REJILLABLQbody">
               <xsl:with-param name="nsdoc-local"><xsl:value-of select="$nsdoc-local"/></xsl:with-param>
            </xsl:call-template>
         </xsl:when>
         <xsl:otherwise>
            <xsl:apply-templates mode="body"/>
         </xsl:otherwise>
      </xsl:choose> 
      
   </xsl:template>


   <xsl:template match="REJILLA/PRESENTACION[@nombre != 'CabeceraX' and @nombre != 'CabeceraY']" mode="body">

         <!-- Ver estilo a aplicar -->
         <xsl:variable name="vTablaTratar" select="position()"/>

         <xsl:choose>
            <xsl:when test="../@colsbloqueo>0">
               <xsl:call-template name="REJILLAPRESENTACION">
                  <xsl:with-param name="pTipo">ID</xsl:with-param>
               </xsl:call-template>
            </xsl:when>
            <xsl:otherwise>

            <TABLE border="0" cellpadding="0" cellspacing="0" bgcolor="{../@colorf}">	
               <xsl:if test="@colorf and string-length(@colorf) > 0">
                  <xsl:attribute name="bgcolor"><xsl:value-of select="@colorf"/></xsl:attribute>
               </xsl:if> 
<!-- 
<xsl:text>.bgcolor='</xsl:text><xsl:value-of select="@colorf"/><xsl:text>
-->
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

                     <xsl:for-each select="CAMPO">

                        <xsl:variable name="vCampoActual" select="position()"/>
                        <xsl:variable name="vContenido" select="concat(.,@VALOR)"/>
                        <xsl:variable name="vCol" select="ancestor::PRESENTACION/COL[number($vCampoActual)]"/>

                        <!-- Ver estilo a aplicar -->
                        <xsl:variable name="vEstilo">
                           <xsl:choose>
                              <xsl:when test="$vUltima='S'">
                                 <xsl:choose>
                                    <xsl:when test="$vCol/@IDULTIMA">
                                       <xsl:value-of select="$vCol/@IDULTIMA"/>
                                    </xsl:when>
                                    <xsl:otherwise>
                                       <xsl:call-template name="Estilo_PAR-IMPAR">
                                          <xsl:with-param name="vFilaActual" select="$vFilaActual"/>
                                          <xsl:with-param name="vCol" select="$vCol"/>
                                       </xsl:call-template>
                                    </xsl:otherwise>
                                 </xsl:choose> 
                              </xsl:when>
                              <xsl:when test="$vPrimera='S'">
                                 <xsl:choose>
                                    <xsl:when test="$vCol/@IDPRIMERA">
                                       <xsl:value-of select="$vCol/@IDPRIMERA"/>
                                    </xsl:when>
                                    <xsl:otherwise>
                                       <xsl:call-template name="Estilo_PAR-IMPAR">
                                          <xsl:with-param name="vFilaActual" select="$vFilaActual"/>
                                          <xsl:with-param name="vCol" select="$vCol"/>
                                       </xsl:call-template>
                                    </xsl:otherwise>
                                 </xsl:choose> 
                              </xsl:when>
                              <xsl:otherwise>

                                 <xsl:call-template name="Estilo_PAR-IMPAR">
                                    <xsl:with-param name="vFilaActual" select="$vFilaActual"/>
                                    <xsl:with-param name="vCol" select="$vCol"/>
                                 </xsl:call-template>
<!--                                                      
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
-->
                             </xsl:otherwise>
                           </xsl:choose> 
                        </xsl:variable> 

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
                              <TD ID="{$vEstilo}" width="{$vCol/@ancho}" height="{$vCol/@alto}">
                                 <xsl:if test="$vFilaActual = $vNumFilas">
                                    <IMG src="{$imgTranspPath}"  height="1">
                                       <xsl:if test="$vCol/@ancho">
                                          <xsl:attribute name="width">
                                             <xsl:value-of select="$vCol/@ancho"/>
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
   <!-- <xsl:comment>UNO</xsl:comment> -->
                                   <xsl:call-template name="TDNORMAL">
                                    <xsl:with-param name="pCampoActual" select="$vCampoActual"/>
                                    <xsl:with-param name="pEstilo" select="$vEstilo"/>
                                    <xsl:with-param name="pFilaActual" select="$vFilaActual"/>
                                    <xsl:with-param name="pNumFilas" select="$vNumFilas"/>
                                   </xsl:call-template>
                                </xsl:when>

                                <xsl:when test="$vAgrupo='S'">
                                       <xsl:choose>
                                         <xsl:when test="$vPrimera='S'">
   <!-- <xsl:comment>DOS-1</xsl:comment> -->
                                             <xsl:call-template name="TDFILAEXTENDER">
                                                <xsl:with-param name="pCampoActual" select="$vCampoActual"/>
                                                <xsl:with-param name="pEstilo" select="$vEstilo"/>
                                                <xsl:with-param name="pFilaActual" select="$vFilaActual"/>
                                                <xsl:with-param name="pNumFilas" select="$vNumFilas"/>
                                             </xsl:call-template>
                                         </xsl:when>
                                         <xsl:otherwise>
         
                                                <xsl:choose>
                                                  <xsl:when test="ancestor::ROWSET/ROW[$vFilaActual - 1]/CAMPO[$vCampoActual] != $vContenido">
   <!-- <xsl:comment>DOS-2</xsl:comment> -->
                                                      <xsl:call-template name="TDFILAEXTENDER">
                                                         <xsl:with-param name="pCampoActual" select="$vCampoActual"/>
                                                         <xsl:with-param name="pEstilo" select="$vEstilo"/>
                                                         <xsl:with-param name="pFilaActual" select="$vFilaActual"/>
                                                         <xsl:with-param name="pNumFilas" select="$vNumFilas"/>
                                                     </xsl:call-template>
                                                  </xsl:when>
                                                  <xsl:otherwise>
                                                      <!-- No hay TD -->
   <!--                                                  <xsl:comment>DOS-3</xsl:comment> -->
                                                  </xsl:otherwise>
                                                </xsl:choose> 
                                                
                                         </xsl:otherwise>
                                       </xsl:choose> 
                                       

                                </xsl:when>
                              </xsl:choose> 
                          </xsl:otherwise>
                        </xsl:choose>                      
                     </xsl:for-each> 
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

         </xsl:otherwise>
      </xsl:choose> 
         



<!--      </xsl:for-each>  -->
      
   
   </xsl:template>



</xsl:stylesheet>

