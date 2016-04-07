package es.indra.sicc.entidades.ape;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="APE_SUBLI_ARMAD")
@NamedQueries({
@NamedQuery(name="SublineaArmadoLocal.FindAll",query="select object(o) from SublineaArmadoLocal o")
})
public class SublineaArmadoLocal implements Serializable {

    public SublineaArmadoLocal() {}

    public SublineaArmadoLocal(Long oid, Long codigoSublinea, Boolean postVenta, 
            char letraParaAnaquel, Boolean imprimirListaPicado, Boolean frenteEspalda, 
            Integer bahiasFrente, Integer bahiaEspalda, Integer numeroNivelesFrente, 
            Integer numeroNivelesEspalda, Integer numeroColumnasFrente, Integer numeroColumnasEspalda, 
            Long numeroOrdenBalanceo, Long oidLineaArmado, Long oidSistemaPicado, Long oidCentroDistribucion)	{
            
        this.oid=oid;
        setCodigoSublinea(codigoSublinea);
        setPostVenta(postVenta);
        setLetraParaAnaquel(letraParaAnaquel);
        setImprimirListaPicado(imprimirListaPicado);
        setFrenteEspalda(frenteEspalda);
        setBahiasFrente(bahiasFrente);
        setBahiaEspalda(bahiaEspalda);
        setNumeroNivelesFrente(numeroNivelesFrente);
        setNumeroNivelesEspalda(numeroNivelesEspalda);        
        setNumeroColumnasFrente(numeroColumnasFrente);
        setNumeroColumnasEspalda(numeroColumnasEspalda);
        setNumeroOrdenBalanceo(numeroOrdenBalanceo);
        setOidLineaArmado(oidLineaArmado);
        setOidSistemaPicado(oidSistemaPicado);
        setOidCentroDistribucion(oidCentroDistribucion);
    }

    @Id
    @Column(name="OID_SUBL_ARMA")
    private Long oid;
    @Column(name="COD_SUBL_ARMA")
    private Long codigoSublinea;
    @Column(name="IND_POST_VENT")
    private Boolean postVenta;
    @Column(name="VAL_LETR_PARA_ANAQ")
    private char letraParaAnaquel;
    @Column(name="IND_IMPR_LIST_PICA")
    private Boolean imprimirListaPicado;
    @Column(name="IND_FREN_ESPA")
    private Boolean frenteEspalda;
    @Column(name="NUM_BAHI_FREN")
    private Integer bahiasFrente;
    @Column(name="NUM_BAHI_ESPA")
    private Integer bahiaEspalda;
    @Column(name="NUM_NIVE_FREN")
    private Integer numeroNivelesFrente;
    @Column(name="NUM_NIVE_ESPA")
    private Integer numeroNivelesEspalda;
    @Column(name="NUM_COLU_FREN")
    private Integer numeroColumnasFrente;
    @Column(name="NUM_COLU_ESPA")
    private Integer numeroColumnasEspalda;
    @Column(name="NUM_ORDE_BALA")
    private Long numeroOrdenBalanceo;
    @Column(name="LIAR_OID_LINE_ARMA")
    private Long oidLineaArmado;
    @Column(name="SIPI_OID_SIST_PICA")
    private Long oidSistemaPicado;
    @Column(name="CCDI_OID_CONF_CENT_DIST")
    private Long oidCentroDistribucion;

    
    public Long getOid() {return oid;}
    
    public Long getCodigoSublinea() {return codigoSublinea;}
  
    public void setCodigoSublinea(Long codigoSublinea){this.codigoSublinea=codigoSublinea;}
            
    public Boolean getPostVenta() {return postVenta;}
  
    public void setPostVenta(Boolean postVenta){this.postVenta=postVenta;}
            
    public char getLetraParaAnaquel() {return letraParaAnaquel;}
  
    public void setLetraParaAnaquel(char letraParaAnaquel){this.letraParaAnaquel=letraParaAnaquel;}
            
    public Boolean getImprimirListaPicado() {return imprimirListaPicado;}
  
    public void setImprimirListaPicado(Boolean imprimirListaPicado){this.imprimirListaPicado=imprimirListaPicado;}
            
    public Boolean getFrenteEspalda() {return frenteEspalda;}
  
    public void setFrenteEspalda(Boolean frenteEspalda){this.frenteEspalda=frenteEspalda;}
            
    public Integer getBahiasFrente() {return bahiasFrente;}
  
    public void setBahiasFrente(Integer bahiasFrente){this.bahiasFrente=bahiasFrente;}
            
    public Integer getBahiaEspalda() {return bahiaEspalda;}
  
    public void setBahiaEspalda(Integer bahiaEspalda){this.bahiaEspalda=bahiaEspalda;}
            
    public Integer getNumeroNivelesFrente() {return numeroNivelesFrente;}
  
    public void setNumeroNivelesFrente(Integer numeroNivelesFrente){this.numeroNivelesFrente=numeroNivelesFrente;}
            
    public Integer getNumeroNivelesEspalda() {return numeroNivelesEspalda;}
  
    public void setNumeroNivelesEspalda(Integer numeroNivelesEspalda){this.numeroNivelesEspalda=numeroNivelesEspalda;}
            
    public Integer getNumeroColumnasFrente() {return numeroColumnasFrente;}
  
    public void setNumeroColumnasFrente(Integer numeroColumnasFrente){this.numeroColumnasFrente=numeroColumnasFrente;}
            
    public Integer getNumeroColumnasEspalda() {return numeroColumnasEspalda;}
  
    public void setNumeroColumnasEspalda(Integer numeroColumnasEspalda){this.numeroColumnasEspalda=numeroColumnasEspalda;}
            
    public Long getNumeroOrdenBalanceo() {return numeroOrdenBalanceo;}
  
    public void setNumeroOrdenBalanceo(Long numeroOrdenBalanceo){this.numeroOrdenBalanceo=numeroOrdenBalanceo;}
            
    public Long getOidLineaArmado() {return oidLineaArmado;}
  
    public void setOidLineaArmado(Long oidLineaArmado){this.oidLineaArmado=oidLineaArmado;}
            
    public Long getOidSistemaPicado() {return oidSistemaPicado;}
  
    public void setOidSistemaPicado(Long oidSistemaPicado){this.oidSistemaPicado=oidSistemaPicado;}
            
    public Long getOidCentroDistribucion() {return oidCentroDistribucion;}
  
    public void setOidCentroDistribucion(Long oidCentroDistribucion){this.oidCentroDistribucion=oidCentroDistribucion;}
                    
	
}
