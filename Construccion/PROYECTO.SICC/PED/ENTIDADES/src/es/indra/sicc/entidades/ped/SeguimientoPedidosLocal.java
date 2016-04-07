package es.indra.sicc.entidades.ped;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="PED_SEGUI_PEDID")
@NamedQueries({
@NamedQuery(name="SeguimientoPedidosLocal.FindBySolicitud",query="SELECT OBJECT(a) "
+ " FROM SeguimientoPedidosLocal AS a "
+ " WHERE a.solicitud = ?1"),
@NamedQuery(name="SeguimientoPedidosLocal.FindAll",query="SELECT OBJECT(p) from SeguimientoPedidosLocal p")
})
public class SeguimientoPedidosLocal implements Serializable {

    public SeguimientoPedidosLocal() {}

    public SeguimientoPedidosLocal(Long oid, Long tdse_oid_tipo, Long hise_oid_hito, String num_docu) {
        this.oid=oid;
        this.tipoDocumento = tdse_oid_tipo;
        this.hito = hise_oid_hito;
        this.numeroDocumento = num_docu;
    }

    @Id
    @Column(name="OID_SEGU_PEDI")
    private Long oid;
    @Column(name="SOCA_OID_SOLI_CABE")
    private Long solicitud;
    @Column(name="SOCA_OID_CONS")
    private Long consolidado;
    @Column(name="TDSE_OID_TIPO")
    private Long tipoDocumento;
    @Column(name="HISE_OID_HITO")
    private Long hito;
    @Column(name="FEC")
    private Timestamp fecha;
    @Column(name="NUM_DOCU")
    private String numeroDocumento;
    @Column(name="IND_COMP")
    private Boolean indCompleto;

    
    public Long getOid() {return oid;}
  
    public Long getPrimaryKey() {return oid;}		
            
    public Long getSolicitud() {return solicitud;}
  
    public void setSolicitud(Long solicitud){this.solicitud=solicitud;}
            
    public Long getConsolidado() {return consolidado;}
  
    public void setConsolidado(Long consolidado){this.consolidado=consolidado;}
            
    public Long getTipoDocumento() {return tipoDocumento;}
  
    public void setTipoDocumento(Long tipoDocumento){this.tipoDocumento=tipoDocumento;}
            
    public Long getHito() {return hito;}
  
    public void setHito(Long hito){this.hito=hito;}
            
    public java.sql.Timestamp getFecha() {return fecha;}
  
    public void setFecha(java.sql.Timestamp fecha){this.fecha=fecha;}
            
    public String getNumeroDocumento() {return numeroDocumento;}
  
    public void setNumeroDocumento(String numeroDocumento){this.numeroDocumento=numeroDocumento;}
            
    public Boolean getIndCompleto() {return indCompleto;}
  
    public void setIndCompleto(Boolean indCompleto){this.indCompleto=indCompleto;}
                    
	
}
