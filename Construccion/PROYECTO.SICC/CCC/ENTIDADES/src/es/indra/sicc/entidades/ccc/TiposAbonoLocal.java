package es.indra.sicc.entidades.ccc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="CCC_TIPO_CARGO_ABONO")
public class TiposAbonoLocal implements Serializable {

	public TiposAbonoLocal() {}

	public TiposAbonoLocal(Long oid, Long pais, String codigo) {
	
		this.oid=oid;
                this.pais=pais;
                this.codigo=codigo;
	
	}
        

        public TiposAbonoLocal(Long oid, Long pais, String codigo, String observaciones) {
        
                this.oid=oid;
                this.pais=pais;
                this.codigo=codigo;
                this.observaciones= observaciones;
        
        }

	@Id
	@Column(name="OID_TIPO_CARG_ABON")
	private Long oid;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="COD_TIPO_CARG_ABON")
	private String codigo;
	@Column(name="VAL_OBSE")
	private String observaciones;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public String getCodigo() {return codigo;}
      
	public void setCodigo(String codigo){this.codigo=codigo;}
		
	public String getObservaciones() {return observaciones;}
      
	public void setObservaciones(String observaciones){this.observaciones=observaciones;}
			
	
}
