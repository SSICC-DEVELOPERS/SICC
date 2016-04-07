package es.indra.sicc.entidades.ped;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PED_SECUE_TIPIF")
@NamedQueries({
@NamedQuery(name="SecuenciaTipificacionLocal.FindAll",query="SELECT OBJECT(p) from SecuenciaTipificacionLocal p"),
@NamedQuery(name="SecuenciaTipificacionLocal.FindByPais",query="SELECT OBJECT(p) from SecuenciaTipificacionLocal p "
+ " WHERE p.pais = ?1")
})
public class SecuenciaTipificacionLocal implements Serializable {

    public SecuenciaTipificacionLocal() {}

    public SecuenciaTipificacionLocal(Long oid, Long num_orde, Long pais_oid_pais, Long ticl_oid_tipo_clie) {
        this.oid=oid;
        this.orden = num_orde;
        this.pais = pais_oid_pais;
        this.tipoCliente = ticl_oid_tipo_clie;
    }

    @Id
    @Column(name="OID_SECU_TIPI")
    private Long oid;
    @Column(name="NUM_ORDE")
    private Long orden;
    @Column(name="PAIS_OID_PAIS")
    private Long pais;
    @Column(name="TICL_OID_TIPO_CLIE")
    private Long tipoCliente;
    @Column(name="SBTI_OID_SUBT_CLIE")
    private Long subtipoCliente;
    @Column(name="CLAS_OID_CLAS")
    private Long clasificacion;
    @Column(name="TCCL_OID_TIPO_CLAS")
    private Long tipoClasificacion;

    
    public Long getOid() {return oid;}
  
    public Long getPrimaryKey() {return oid;}		
            
    public Long getOrden() {return orden;}
  
    public void setOrden(Long orden){this.orden=orden;}
            
    public Long getPais() {return pais;}
  
    public void setPais(Long pais){this.pais=pais;}
            
    public Long getTipoCliente() {return tipoCliente;}
  
    public void setTipoCliente(Long tipoCliente){this.tipoCliente=tipoCliente;}
            
    public Long getSubtipoCliente() {return subtipoCliente;}
  
    public void setSubtipoCliente(Long subtipoCliente){this.subtipoCliente=subtipoCliente;}
            
    public Long getClasificacion() {return clasificacion;}
  
    public void setClasificacion(Long clasificacion){this.clasificacion=clasificacion;}
            
    public Long getTipoClasificacion() {return tipoClasificacion;}
  
    public void setTipoClasificacion(Long tipoClasificacion){this.tipoClasificacion=tipoClasificacion;}
	
}
