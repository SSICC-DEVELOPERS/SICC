package es.indra.sicc.entidades.ape;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.sql.Timestamp;

@Entity
@Table(name="APE_TURNO_CHEQU")
@NamedQueries({
@NamedQuery(name="TurnosChequeoLocal.FindAll",query="select object(o) from TurnosChequeoLocal o"),
@NamedQuery(name="TurnosChequeoLocal.FindByUK",query="SELECT OBJECT(o) FROM TurnosChequeoLocal o WHERE o.configuracionCentroDistribucion = ?1 AND o.numeroTurno = ?2")
})
public class TurnosChequeoLocal implements Serializable {

    public TurnosChequeoLocal() {}
    
    public TurnosChequeoLocal(Long oid, Integer numTurno, Timestamp horaInicioTurno,
            Timestamp horaFinTurno, Long oidConfiguracionCD)	{
    
        this.oid=oid;
        this.setNumeroTurno(numTurno);
        this.setHoraInicioTurno(horaInicioTurno);
        this.setHoraFinTurno(horaFinTurno);
        this.setConfiguracionCentroDistribucion(oidConfiguracionCD);
    }
    
    @Id
    @Column(name="OID_TURN_CHEQ")
    private Long oid;
    @Column(name="NUM_TURN")
    private Integer numeroTurno;
    @Column(name="FEC_HORA_INIC_TURN")
    private java.sql.Timestamp horaInicioTurno;
    @Column(name="FEC_HORA_FINA_TURN")
    private java.sql.Timestamp horaFinTurno;
    @Column(name="CCDI_OID_CONF_CENT_DIST")
    private Long configuracionCentroDistribucion;
    
    
    public Long getOid() {return oid;}
    
    public Integer getNumeroTurno() {return numeroTurno;}
    
    public void setNumeroTurno(Integer numeroTurno){this.numeroTurno=numeroTurno;}
        
    public java.sql.Timestamp getHoraInicioTurno() {return horaInicioTurno;}
    
    public void setHoraInicioTurno(java.sql.Timestamp horaInicioTurno){this.horaInicioTurno=horaInicioTurno;}
        
    public java.sql.Timestamp getHoraFinTurno() {return horaFinTurno;}
    
    public void setHoraFinTurno(java.sql.Timestamp horaFinTurno){this.horaFinTurno=horaFinTurno;}
        
    public Long getConfiguracionCentroDistribucion() {return configuracionCentroDistribucion;}
    
    public void setConfiguracionCentroDistribucion(Long configuracionCentroDistribucion){this.configuracionCentroDistribucion=configuracionCentroDistribucion;}
                
	
}
