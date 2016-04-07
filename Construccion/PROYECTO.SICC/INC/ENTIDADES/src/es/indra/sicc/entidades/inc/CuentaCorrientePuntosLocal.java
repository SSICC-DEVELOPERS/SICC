package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;
import java.sql.Date;


@Entity
@Table(name="INC_CUENT_CORRI_PUNTO")
@NamedQueries({
@NamedQuery(name="CuentaCorrientePuntosLocal.FindAll",query="select object(o) from CuentaCorrientePuntosLocal o"),
@NamedQuery(name="CuentaCorrientePuntosLocal.FindByUK",query="SELECT OBJECT (a) "
+ " FROM CuentaCorrientePuntosLocal AS a "
+ " WHERE a.cliente = ?1 "
+ " AND a.concurso = ?2 "
+ " AND a.numMovimiento = ?3"),
@NamedQuery(name="CuentaCorrientePuntosLocal.FindByConcurso",query="SELECT OBJECT (a) "
+ " FROM CuentaCorrientePuntosLocal AS a "
+ " WHERE a.concurso = ?1")
})
public class CuentaCorrientePuntosLocal implements Serializable {

	public CuentaCorrientePuntosLocal() {}

	public CuentaCorrientePuntosLocal(Long oid, Integer numPunt, Integer numPuntExig, Date fecMovi, Long copaOidParaGral, Long clieOidClie, Long perdOidPeri, Long tmovOidTipoMovi)	{
	
		this.oid=oid;
                this.setNumeroPuntos(numPunt);
                this.setPuntosExigidos(numPuntExig);
                this.setFechaMovimiento(fecMovi);
                this.setConcurso(copaOidParaGral);
                this.setCliente(clieOidClie);
                this.setPeriodo(perdOidPeri);
                this.setTipoMovimiento(tmovOidTipoMovi);
                this.setNumMovimiento(new Integer(oid.intValue()));   
	
	}
        
        
    public CuentaCorrientePuntosLocal(Long oid, Integer numPunt, Integer numPuntExig, Date fecMovi, Long copaOidParaGral, Long clieOidClie, Long perdOidPeri, Long tmovOidTipoMovi, String descripcion) {
    
            this.oid=oid;
            this.setNumeroPuntos(numPunt);
            this.setPuntosExigidos(numPuntExig);
            this.setFechaMovimiento(fecMovi);
            this.setConcurso(copaOidParaGral);
            this.setCliente(clieOidClie);
            this.setPeriodo(perdOidPeri);
            this.setTipoMovimiento(tmovOidTipoMovi);
            this.setNumMovimiento(new Integer(oid.intValue()));    
            this.setVal_desc(descripcion);    
    
    }

	@Id
	@Column(name="OID_CUEN_CORR_PUNT")
	private Long oid;
	@Column(name="NUM_PUNT")
	private Integer numeroPuntos;
	@Column(name="NUM_PUNT_EXIG")
	private Integer puntosExigidos;
	@Column(name="FEC_MOVI")
	private java.sql.Date fechaMovimiento;
	@Column(name="COPA_OID_PARA_GRAL")
	private Long concurso;
	@Column(name="CLIE_OID_CLIE")
	private Long cliente;
	@Column(name="PERD_OID_PERI")
	private Long periodo;
	@Column(name="TMOV_OID_TIPO_MOVI")
	private Long tipoMovimiento;
	@Column(name="NUM_MOVI")
	private Integer numMovimiento;
	@Column(name="FEC_ULTI_ACTU")
	private java.sql.Date fechaUltiActu;
	@Column(name="VAL_DESC")
	private String val_desc;

        //sapaza -- COL-SiCC-2014-0175 -- 04/06/2014
        @Column(name="NUM_PUNT_BONI")
        private Integer puntosBonificados;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Integer getNumeroPuntos() {return numeroPuntos;}
      
	public void setNumeroPuntos(Integer numeroPuntos){this.numeroPuntos=numeroPuntos;}
		
	public Integer getPuntosExigidos() {return puntosExigidos;}
      
	public void setPuntosExigidos(Integer puntosExigidos){this.puntosExigidos=puntosExigidos;}
		
	public java.sql.Date getFechaMovimiento() {return fechaMovimiento;}
      
	public void setFechaMovimiento(java.sql.Date fechaMovimiento){this.fechaMovimiento=fechaMovimiento;}
		
	public Long getConcurso() {return concurso;}
      
	public void setConcurso(Long concurso){this.concurso=concurso;}
		
	public Long getCliente() {return cliente;}
      
	public void setCliente(Long cliente){this.cliente=cliente;}
		
	public Long getPeriodo() {return periodo;}
      
	public void setPeriodo(Long periodo){this.periodo=periodo;}
		
	public Long getTipoMovimiento() {return tipoMovimiento;}
      
	public void setTipoMovimiento(Long tipoMovimiento){this.tipoMovimiento=tipoMovimiento;}
		
	public Integer getNumMovimiento() {return numMovimiento;}
      
	public void setNumMovimiento(Integer numMovimiento){this.numMovimiento=numMovimiento;}	
		
	public java.sql.Date getFechaUltiActu() {return fechaUltiActu;}
      
	public void setFechaUltiActu(java.sql.Date fechaUltiActu){this.fechaUltiActu=fechaUltiActu;}
		
	public String getVal_desc() {return val_desc;}
      
	public void setVal_desc(String val_desc){this.val_desc=val_desc;}

        public void setPuntosBonificados(Integer puntosBonificados) {
            this.puntosBonificados = puntosBonificados;
        }

        public Integer getPuntosBonificados() {
            return puntosBonificados;
        }
}
