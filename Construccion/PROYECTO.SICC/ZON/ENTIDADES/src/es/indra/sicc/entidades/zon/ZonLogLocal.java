package es.indra.sicc.entidades.zon;

import es.indra.sicc.logicanegocio.zon.FileInterfaceMensajes;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.sql.Timestamp;

@Entity
@Table(name="ZON_LOG")
@NamedQueries({
@NamedQuery(name="ZonLogLocal.FindAll", query="SELECT OBJECT(o) FROM ZonLogLocal AS o")
})
public class ZonLogLocal implements Serializable {

    public ZonLogLocal() {}

    public ZonLogLocal(Long oid_zon_log, String val_tipo_proc, Long val_esta, Timestamp fec_log) {
        this.oidZonLog = oid_zon_log;
        this.valTipoProc = val_tipo_proc;
        this.valEstado = val_esta;
        this.fechaLog = fec_log;
    }
    
    @Id
    @Column(name="OID_ZON_LOG")
    private Long oidZonLog;
    @Column(name="VAL_TIPO_PROC")
    private String valTipoProc;
    @Column(name="VAL_ESTA")
    private Long valEstado;
    @Column(name="VAL_MENS")
    private String valMensaje;
    @Column(name="FEC_LOG")
    private Timestamp fechaLog;

    
    public Long getOidZonLog() {return oidZonLog;}
  
    public Long getPrimaryKey() {return oidZonLog;}		
            
    public String getValTipoProc() {return valTipoProc;}
  
    public void setValTipoProc(String valTipoProc){this.valTipoProc=valTipoProc;}
            
    public Long getValEstado() {return valEstado;}
  
    public void setValEstado(Long valEstado){this.valEstado=valEstado;}
            
    public String getValMensaje() {return valMensaje;}
  
    public void setValMensaje(String valMensaje){this.valMensaje=valMensaje;}
            
    public Timestamp getFechaLog() {return fechaLog;}
  
    public void setFechaLog(Timestamp fechaLog){this.fechaLog=fechaLog;}
                    
    public String getMensajeError() {
        FileInterfaceMensajes intMensaje = new FileInterfaceMensajes();
        return intMensaje.obtenerDescMen(this.getValMensaje());
    }
	
}
