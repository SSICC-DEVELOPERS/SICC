<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
$Id: genjava.xsl,v 1.1 2009/12/03 19:03:51 pecbazalar Exp $
Genera una clase java que construye en memoria un arbol DOM del objeto XML (PAGINA ó CONECTOR) original.
DRUIDATARGET=/bin/root/scripts

Se ha intentado adaptar el codigo java generado a las conclusiones obtenidas de la auditoria sobre el 
codigo fuente en QY. En concreto lo referente al numero de lineas y metodos obtenidos de Logiscope Audit. Estos valores se encuentran 
parametrizados con las variables pgNumLineas y pgNumMetodos.
===================================================================================
Inspección de código de QY y G1. 
Análisis Estático de Aplicaciones Java con Logiscope.
EDICIÓN:				1.1
FECHA EDICIÓN:			04/07/02
FICHERO:				InspCod_QY&G1_v1.1
AUTORES:				Metodología y E-Business
RESUMEN:	Este documento contiene información acerca del análisis y las conclusiones 
obtenidas tras la inspección del código fuente de los anagramas QY y G1.
===================================================================================

-->

<xsl:stylesheet version='1.0'
   xmlns:xsl='http://www.w3.org/1999/XSL/Transform'
   xmlns:saxon="http://icl.com/saxon"
   extension-element-prefixes="saxon">


<xsl:output method="text" indent="no" encoding="ISO-8859-1"/>
<!-- Por defecto todos los elementos que contienen nodos de texto vacios (whitespace-only) se eliminan de codigo -->
<xsl:strip-space elements="*" />
<!-- En estos elementos los nodos de texto se mantienen -->
<xsl:preserve-space elements="LITERAL" />

<!-- Nombre de la clase a generar -->
<xsl:param name="pNombreClase"/>
<!-- Numero maximo de lineas por metodo, por defecto 90 -->
<xsl:param name="pgNumLineas">90</xsl:param>
<!-- Numero maximo de llamadas a metodos en cada metodo, por defecto 60 -->
<xsl:param name="pgNumMetodos">60</xsl:param>
<!-- modo debug -->
<xsl:param name="pgDebug">N</xsl:param>


<xsl:variable name="i" saxon:assignable="yes">0</xsl:variable>
<xsl:variable name="vLinea" saxon:assignable="yes">0</xsl:variable>
<xsl:variable name="vMetodos" saxon:assignable="yes">0</xsl:variable>
<xsl:variable name="vContMetodos" saxon:assignable="yes">0</xsl:variable>

<!-- Numero total de nodos -->
<xsl:variable name="vgNodos" select="count(//@*) + count(descendant::text()) + count(descendant::*)"/>
<!-- Contador nodos encontrados -->
<xsl:variable name="vgContNodos" saxon:assignable="yes" select="0"/>

<xsl:variable name="vgIndent"><xsl:text>      </xsl:text></xsl:variable>


<xsl:template match="/">
import org.w3c.dom.*;
import java.util.ArrayList;

public class <xsl:value-of select="$pNombreClase"/>  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      <xsl:apply-templates select="*" mode="metodos"/>
      <xsl:if test="$vgContNodos &lt; $vgNodos or $vContMetodos=0">
      return (Element)v.get(0);
      </xsl:if>
   }

   <saxon:assign name="vLinea" select="0"/>
   <xsl:apply-templates select="*" mode="inicial"/>

   }

}
</xsl:template>



<xsl:template match="*" mode="metodos">
   <xsl:call-template name="Metodos"/>
   <saxon:assign name="vLinea" select="$vLinea+1"/>
   <saxon:assign name="vgContNodos" select="$vgContNodos + 1"/>

   <xsl:for-each select="@*">
      <xsl:call-template name="Metodos"/>
      <saxon:assign name="vLinea" select="$vLinea+1"/>
         <saxon:assign name="vgContNodos" select="$vgContNodos + 1"/>
   </xsl:for-each>

   <xsl:call-template name="Metodos"/>
   <saxon:assign name="vLinea" select="$vLinea+1"/>

   <xsl:apply-templates mode="metodos"/>
</xsl:template>


<xsl:template match="text()" mode="metodos">
   <xsl:if test="string-length(.) > 0">
      <xsl:call-template name="Metodos"/>
      <saxon:assign name="vLinea" select="$vLinea+1"/>
   <saxon:assign name="vgContNodos" select="$vgContNodos + 1"/>

      <xsl:call-template name="Metodos"/>
      <saxon:assign name="vLinea" select="$vLinea+1"/>
   </xsl:if>
</xsl:template>





<xsl:template match="*" mode="inicial">
/* Primer nodo */
   <xsl:call-template name="EscribeLinea">
      <xsl:with-param name="pLin">
         <xsl:text>v.add(doc.createElement("</xsl:text><xsl:value-of select="name()"/><xsl:text>"));</xsl:text>
      </xsl:with-param>
   </xsl:call-template>

   <xsl:for-each select="@*">
      <xsl:call-template name="EscribeLinea">
         <xsl:with-param name="pLin">
            <xsl:text>((Element)v.get(0)).setAttribute("</xsl:text><xsl:value-of select="name()"/><xsl:text>","</xsl:text><xsl:value-of select="."/><xsl:text>" );</xsl:text>
         </xsl:with-param>
      </xsl:call-template>
   </xsl:for-each>


   <xsl:apply-templates select="*" mode="siguientes">
      <xsl:with-param name="padre" select="$i"/>
   </xsl:apply-templates>

</xsl:template>





<xsl:template match="*" mode="siguientes">
   <xsl:param name="padre"/>
   <xsl:variable name="vNodoActual" select="$i+1"/>

   <xsl:value-of select="concat('&#xa;',$vgIndent,'/* Empieza nodo:',$vNodoActual,' / Elemento padre: ',$padre,'   */', '&#xa;')"/>
   <saxon:assign name="i" select="$i+1"/>

   <xsl:call-template name="EscribeLinea">
      <xsl:with-param name="pLin">
         <xsl:text>v.add(doc.createElement("</xsl:text><xsl:value-of select="name()"/><xsl:text>"));</xsl:text>
      </xsl:with-param>
   </xsl:call-template>

   <xsl:for-each select="@*">
      <xsl:call-template name="EscribeLinea">
         <xsl:with-param name="pLin">
            <xsl:text>((Element)v.get(</xsl:text><xsl:value-of select="$i"/><xsl:text>)).setAttribute("</xsl:text><xsl:value-of select="name()"/><xsl:text>","</xsl:text><xsl:value-of select="."/><xsl:text>" );</xsl:text>
         </xsl:with-param>
      </xsl:call-template>
   </xsl:for-each>

   <xsl:if test="name()!='PAGINA'">
      <xsl:variable name="appendChild" select="concat('((Element)v.get(',$padre,')).appendChild((Element)v.get(',$i,'));')"/>
      <xsl:call-template name="EscribeLinea">
         <xsl:with-param name="pLin" select="$appendChild"/>
      </xsl:call-template>
   </xsl:if>

   <xsl:apply-templates  select="*|text()" mode="siguientes">
      <xsl:with-param name="padre" select="$i"/>
   </xsl:apply-templates>

   <xsl:value-of select="concat($vgIndent,'/* Termina nodo:',$vNodoActual,'   */', '&#xa;')"/>
</xsl:template>



<xsl:template match="text()" mode="siguientes">
   <xsl:param name="padre"/>
   <saxon:assign name="i" select="$i+1"/>

   <xsl:value-of select="concat('&#xa;',$vgIndent,'/* Elemento padre:',$padre,' / Elemento actual: ',$i,'   */', '&#xa;')"/>

   <xsl:if test="string-length(.) > 0">
      <xsl:variable name="SinComentarios">
         <xsl:call-template name="QuitaComentariosJS">
             <xsl:with-param name="cadena" select="string(.)"/>
         </xsl:call-template>
      </xsl:variable>

            <xsl:variable name="esc2">
                <xsl:call-template name="escapaBarra">
                    <xsl:with-param name="text" select="$SinComentarios"/>
                </xsl:call-template>
            </xsl:variable>

            <xsl:variable name="SinRetorno">
                <xsl:call-template name="retorno_carro">
                    <xsl:with-param name="text" select="$esc2"/>
                </xsl:call-template>
            </xsl:variable>

            <xsl:variable name="SinLinea">
                <xsl:call-template name="fin_linea">
                    <xsl:with-param name="text" select="$SinRetorno"/>
                </xsl:call-template>
            </xsl:variable>


            <xsl:variable name="esc">
                <xsl:call-template name="escapa">
                    <xsl:with-param name="text" select="translate($SinLinea, '&#x0022;', '±')"/>
                </xsl:call-template>
            </xsl:variable>


      <xsl:call-template name="EscribeLinea">
         <xsl:with-param name="pLin">
            <xsl:text>v.add(doc.createTextNode("</xsl:text><xsl:value-of select="$esc"/><xsl:text>"));</xsl:text>
         </xsl:with-param>
      </xsl:call-template>
      <xsl:call-template name="EscribeLinea">
         <xsl:with-param name="pLin">
            <xsl:text>((Element)v.get(</xsl:text><xsl:value-of select="$padre"/><xsl:text>)).appendChild((Text)v.get(</xsl:text><xsl:value-of select="$i"/><xsl:text>));</xsl:text>
         </xsl:with-param>
      </xsl:call-template>

      <xsl:value-of select="concat('&#xa;',$vgIndent,'/* Termina nodo Texto:',$i,'   */', '&#xa;')"/>
   </xsl:if>
</xsl:template>

<xsl:template match="processing-instruction()">
</xsl:template>




<xsl:template name="EscribeLinea">
   <xsl:param name="pLin"/>

   <!-- Control numero maximo de lineas en un metodo -->
   <xsl:if test="$vLinea mod $pgNumLineas=0">
      <xsl:if test="$vLinea > 0">
         <xsl:text>   }</xsl:text>
      </xsl:if>
   <xsl:value-of select="'&#xa;&#xa;'"/><xsl:text>   private void getXML</xsl:text><xsl:value-of select="$vLinea"/><xsl:text>(Document doc) {</xsl:text><xsl:value-of select="'&#xa;'"/>
   </xsl:if>
   <xsl:value-of select="$vgIndent"/><xsl:value-of select="$pLin"/><xsl:value-of select="'&#xa;'"/>
   <saxon:assign name="vLinea" select="$vLinea+1"/>
</xsl:template>



<xsl:template name="escapa">
   <xsl:param name="text" select="."/>
   <xsl:choose>
   <xsl:when test="contains($text, '±')">
      <xsl:value-of select="substring-before($text, '±')"/>
      <xsl:text>\&#x0022;</xsl:text>
      <xsl:call-template name="escapa">
          <xsl:with-param name="text" select="substring-after($text,'±')"/>
      </xsl:call-template>
   </xsl:when>
   <xsl:otherwise>
      <xsl:value-of select="$text"/>
   </xsl:otherwise>
   </xsl:choose>
</xsl:template>

<xsl:template name="escapaBarra">
   <xsl:param name="text" select="."/>
   <xsl:choose>
   <xsl:when test="contains($text, '\')">
      <xsl:value-of select="substring-before($text, '\')"/>
      <xsl:text>\\</xsl:text>
      <xsl:call-template name="escapaBarra">
          <xsl:with-param name="text" select="substring-after($text,'\')"/>
      </xsl:call-template>
   </xsl:when>
   <xsl:otherwise>
      <xsl:value-of select="$text"/>
   </xsl:otherwise>
   </xsl:choose>
</xsl:template>

    <xsl:template name="retorno_carro">
        <xsl:param name="text" select="."/>
        <xsl:choose>
            <xsl:when test="contains($text, '&#xD;')">
                <xsl:value-of select="substring-before($text, '&#xD;')"/>
                <xsl:text>\n</xsl:text>
                <xsl:call-template name="retorno_carro">
                    <xsl:with-param name="text" select="substring-after($text,'&#xD;')"/>
                </xsl:call-template>
            </xsl:when>
            <xsl:otherwise>
                <xsl:value-of select="$text"/>
            </xsl:otherwise>
        </xsl:choose>
    </xsl:template>

    <xsl:template name="fin_linea">
        <xsl:param name="text" select="."/>
        <xsl:choose>
            <xsl:when test="contains($text, '&#xA;')">
                <xsl:value-of select="substring-before($text, '&#xA;')"/>
                <xsl:text>\r</xsl:text>
                <xsl:call-template name="fin_linea">
                    <xsl:with-param name="text" select="substring-after($text,'&#xA;')"/>
                </xsl:call-template>
            </xsl:when>
            <xsl:otherwise>
                <xsl:value-of select="$text"/>
            </xsl:otherwise>
        </xsl:choose>
    </xsl:template>

<xsl:template name="QuitaComentariosJS">
   <xsl:param name="cadena"/>
   <xsl:choose>
      <xsl:when test="contains($cadena, '//')">

         <xsl:variable name="Anterior" select="substring-before($cadena, '//')"/>
         <xsl:variable name="Resto"    select="substring-after($cadena, '//')"/>

         <xsl:value-of select="$Anterior"/>

         <xsl:call-template name="QuitaComentariosJS">
             <xsl:with-param name="cadena" select="substring-after($Resto,'&#xA;')"/>
         </xsl:call-template>
      </xsl:when>
      <xsl:otherwise>
         <xsl:value-of select="$cadena"/>
      </xsl:otherwise>
   </xsl:choose>
</xsl:template>

<xsl:template match="comment()" mode="siguientes">
   <xsl:param name="padre"/>
   <saxon:assign name="i" select="$i+1"/>
   <xsl:value-of select="concat('&#xa;',$vgIndent,'/* Elemento padre:',$padre,' / Elemento actual: ',$i,'   */', '&#xa;')"/>
   <xsl:text>v.add(new String());</xsl:text>
   <xsl:value-of select="'&#xa;'"/>
</xsl:template>



<xsl:template name="Metodos">

   <xsl:if test="$pgDebug='S'">
		<xsl:text>vLinea=</xsl:text><xsl:value-of select="$vLinea"/>
      <xsl:text>, pgNumLineas=</xsl:text><xsl:value-of select="$pgNumLineas"/>
      <xsl:text>, vgContNodos=</xsl:text><xsl:value-of select="$vgContNodos"/>
      <xsl:text>, vgNodos=</xsl:text><xsl:value-of select="$vgNodos"/>
      <xsl:text>, pgNumMetodos=</xsl:text><xsl:value-of select="$pgNumMetodos"/>
      <xsl:text>, vMetodos=</xsl:text><xsl:value-of select="$vMetodos"/>
      <xsl:text>    cond-1=</xsl:text><xsl:value-of select="$vLinea mod $pgNumLineas=0"/>
      <xsl:text>, cond-2=</xsl:text><xsl:value-of select="not ($vgContNodos &gt; $vgNodos - 1)"/>
      <xsl:text>, cond-3=</xsl:text><xsl:value-of select="($vgContNodos &lt; $vgNodos - 1)"/>
      <xsl:value-of select="'&#xa;'"/>
   </xsl:if> 
      <!-- Control numero maximo de lineas en un metodo y ultimo nodo -->
      <xsl:if test="($vLinea mod $pgNumLineas=0) and ($vgContNodos &lt; $vgNodos)">

      getXML<xsl:value-of select="$vLinea"/>(doc);
         <saxon:assign name="vMetodos" select="$vMetodos+1"/>

         <!-- Control numero maximo de llamadas a metodos en un metodo -->
         <xsl:if test="$vMetodos mod $pgNumMetodos=0">
      MgetXML<xsl:value-of select="$vContMetodos"/> (doc);
            <xsl:if test="$vContMetodos=0">
            return (Element)v.get(0);
            </xsl:if>
}
   private void MgetXML<xsl:value-of select="$vContMetodos"/> (Document doc) {
            <saxon:assign name="vContMetodos" select="$vContMetodos+1"/>
            <saxon:assign name="vMetodos" select="0"/>
         </xsl:if>

      </xsl:if>

</xsl:template>




</xsl:stylesheet>
