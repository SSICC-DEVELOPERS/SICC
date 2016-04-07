package es.indra.sicc.entidades.seg;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="SEG_ACCES")
@NamedQueries({
@NamedQuery(name="AccesoLocal.FindByClaveUnica",query="SELECT OBJECT(i)"
+ " FROM AccesoLocal AS i"
+ " WHERE i.codigo = ?1 and "
+ " i.oidCanal = ?2"),
@NamedQuery(name="AccesoLocal.FindAll", query="SELECT OBJECT(i) FROM AccesoLocal AS i")
})
public class AccesoLocal implements Serializable {

	public AccesoLocal() {}

	public AccesoLocal(Long oid, String codigo, Long oidCanal, String indicador)	{
		this.oid=oid;
		this.codigo = codigo;
		this.oidCanal = oidCanal;
		this.indicador = indicador;
	}

	@Id
	@Column(name="OID_ACCE")
	private Long oid;
	@Column(name="COD_ACCE")
	private String codigo;
	@Column(name="CANA_OID_CANA")
	private Long oidCanal;
	@Column(name="IND_ACCE")
	private String indicador;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigo() {return codigo;}
      
	public void setCodigo(String codigo){this.codigo=codigo;}
		
	public Long getOidCanal() {return oidCanal;}
      
	public void setOidCanal(Long oidCanal){this.oidCanal=oidCanal;}
		
	public String getIndicador() {return indicador;}
      
	public void setIndicador(String indicador){this.indicador=indicador;}
			
	
}
