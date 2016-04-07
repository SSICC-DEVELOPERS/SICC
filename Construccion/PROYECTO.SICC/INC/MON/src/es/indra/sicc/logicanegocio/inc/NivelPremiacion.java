package es.indra.sicc.logicanegocio.inc;
import java.io.Serializable;


/**
 * <p>Copyright 2005 © por Indra Sistemas,S.A - Todos los derechos reservados.<br>
 * Avda. de Bruselas, 35<br>
 * Parque Empresarial Arroyo de la Vega<br>
 * 28108 Alcobendas, Madrid<br>
 * España<br>
 * <p>Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 *
 * @date 28/04/2005
 * @author Gustavo Viñales
 */
public class NivelPremiacion implements Serializable {
    private Double cantidadFijaPuntos;
    private Double cantidadFinalPuntos;
    private Double cantidadInicialPuntos;
    private Integer nivel;
    private Long oidNivel;
    
    // sapaza -- PER-SiCC-2014-0192 -- 06/03/2014
    private boolean nivelSelectivo;

    public void setCantidadFijaPuntos(Double cantidadFijaPuntos) {
        this.cantidadFijaPuntos = cantidadFijaPuntos;
    }

    public Double getCantidadFijaPuntos() {
        return cantidadFijaPuntos;
    }

    public void setCantidadFinalPuntos(Double cantidadFinalPuntos) {
        this.cantidadFinalPuntos = cantidadFinalPuntos;
    }

    public Double getCantidadFinalPuntos() {
        return cantidadFinalPuntos;
    }

    public void setCantidadInicialPuntos(Double cantidadInicialPuntos) {
        this.cantidadInicialPuntos = cantidadInicialPuntos;
    }

    public Double getCantidadInicialPuntos() {
        return cantidadInicialPuntos;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setOidNivel(Long oidNivel) {
        this.oidNivel = oidNivel;
    }

    public Long getOidNivel() {
        return oidNivel;
    }
    
    public String toString(){
      StringBuffer st = new StringBuffer( this.getClass().getName() );
      
      st.append("\n cantidadFijaPuntos: "+ cantidadFijaPuntos );
      st.append("\n cantidadFinalPuntos: "+ cantidadFinalPuntos );
      st.append("\n cantidadInicialPuntos: "+ cantidadInicialPuntos );
      st.append("\n nivel: "+ nivel );
      st.append("\n oidNivel: "+ oidNivel );
      st.append("\n nivelSelectivo: "+ nivelSelectivo );
        
      return st.toString();
    }

    public void setNivelSelectivo(boolean nivelSelectivo) {
        this.nivelSelectivo = nivelSelectivo;
    }

    public boolean isNivelSelectivo() {
        return nivelSelectivo;
    }
}
