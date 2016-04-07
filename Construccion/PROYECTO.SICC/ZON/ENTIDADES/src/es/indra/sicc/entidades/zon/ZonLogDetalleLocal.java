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
@Table(name="ZON_LOG_DETAL")
@NamedQueries({
//$1 = $zlogOidZonLog order by $fechaLog
@NamedQuery(name="ZonLogDetalleLocal.FindByLogId", query="SELECT OBJECT(o) FROM ZonLogDetalleLocal AS o "
+ " WHERE o.zlogOidZonLog = ?1 "
+ " ORDER BY o.fechaLog"),
@NamedQuery(name="ZonLogDetalleLocal.FindAll", query="SELECT OBJECT(o) FROM ZonLogDetalleLocal AS o")
})
public class ZonLogDetalleLocal implements Serializable {

    public ZonLogDetalleLocal() {}

    public ZonLogDetalleLocal(Long oidLogDeta, Long zlog_oid_zon_log, Timestamp fec_log,String typeProc, String mensaje, Object data)	{
        this.oidLogDeta=oidLogDeta;
        this.zlogOidZonLog = zlog_oid_zon_log;
        this.fechaLog = fec_log;
        this.valTipoProc = typeProc;
        this.valMensaje = mensaje;
        this.valDato = data.toString();
    }

    @Id
    @Column(name="OID_LOG_DETA")
    private Long oidLogDeta;
    @Column(name="VAL_TIPO_PROC")
    private String valTipoProc;
    @Column(name="VAL_DATO")
    private String valDato;
    @Column(name="VAL_MENS")
    private String valMensaje;
    @Column(name="FEC_LOG")
    private java.sql.Timestamp fechaLog;
    @Column(name="ZLOG_OID_ZON_LOG")
    private Long zlogOidZonLog;

    
    public Long getOidLogDeta() {return oidLogDeta;}
  
    public Long getPrimaryKey() {return oidLogDeta;}		
            
    public String getValTipoProc() {return valTipoProc;}
  
    public void setValTipoProc(String valTipoProc){this.valTipoProc=valTipoProc;}
            
    public String getValDato() {return valDato;}
  
    public void setValDato(String valDato){this.valDato=valDato;}
            
    public String getValMensaje() {return valMensaje;}
  
    public void setValMensaje(String valMensaje){this.valMensaje=valMensaje;}
            
    public java.sql.Timestamp getFechaLog() {return fechaLog;}
  
    public void setFechaLog(java.sql.Timestamp fechaLog){this.fechaLog=fechaLog;}
            
    public Long getZlogOidZonLog() {return zlogOidZonLog;}
  
    public void setZlogOidZonLog(Long zlogOidZonLog){this.zlogOidZonLog=zlogOidZonLog;}
                    
    public String getMensajeError() {
        FileInterfaceMensajes intMensaje = new FileInterfaceMensajes();
        return intMensaje.obtenerDescMen(this.getValMensaje());
    }

}
