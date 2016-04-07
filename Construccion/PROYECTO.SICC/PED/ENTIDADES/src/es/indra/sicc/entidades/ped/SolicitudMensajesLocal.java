package es.indra.sicc.entidades.ped;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PED_SOLIC_MENSA")
@NamedQueries({
@NamedQuery(name="SolicitudMensajesLocal.FindBySolicitudMensaje",query="SELECT OBJECT(a) "
+ " FROM SolicitudMensajesLocal AS a "
+ " WHERE a.oidSolicitudCabecera = ?1 "
+ " AND a.oidMensaje = ?2"),
@NamedQuery(name="SolicitudMensajesLocal.FindAll",query="SELECT OBJECT(p) from SolicitudMensajesLocal p")
})
public class SolicitudMensajesLocal implements Serializable {

    public SolicitudMensajesLocal() {}

    public SolicitudMensajesLocal(Long oid, Long soca_oid_soli_cabe, Long mens_oid_mens, Long val_buzo_mens) {
        this.oid=oid;
        this.oidSolicitudCabecera = soca_oid_soli_cabe;
        this.oidMensaje = mens_oid_mens;
        this.valorBuzonMensaje = val_buzo_mens;
    }

    @Id
    @Column(name="OID_SOLI_MENS")
    private Long oid;
    @Column(name="SOCA_OID_SOLI_CABE")
    private Long oidSolicitudCabecera;
    @Column(name="MENS_OID_MENS")
    private Long oidMensaje;
    @Column(name="VAL_BUZO_MENS")
    private Long valorBuzonMensaje;

    
    public Long getOid() {return oid;}
  
    public Long getPrimaryKey() {return oid;}		
            
    public Long getOidSolicitudCabecera() {return oidSolicitudCabecera;}
  
    public void setOidSolicitudCabecera(Long oidSolicitudCabecera){this.oidSolicitudCabecera=oidSolicitudCabecera;}
            
    public Long getOidMensaje() {return oidMensaje;}
  
    public void setOidMensaje(Long oidMensaje){this.oidMensaje=oidMensaje;}
            
    public Long getValorBuzonMensaje() {return valorBuzonMensaje;}
  
    public void setValorBuzonMensaje(Long valorBuzonMensaje){this.valorBuzonMensaje=valorBuzonMensaje;}
	
}
