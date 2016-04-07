package es.indra.sicc.entidades.ccc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="CCC_BANCO")
public class BancosLocal implements Serializable {

	public BancosLocal() {}

	public BancosLocal(Long oid, Long pais, String codigoBanco, String codigoBancario, 
                    String descripcion) {
		this.oid=oid;
                this.pais=pais;
                this.codigo=codigoBanco;
                this.codigoBancario=codigoBancario;
                this.descripcion=descripcion;
	
	}

        public BancosLocal(Long oid, Long pais, String codigoBanco, String codigoBancario,
                String codigoSwift, String descripcion, String observaciones) {
                this.oid=oid;
                this.pais=pais;
                this.codigo=codigoBanco;
                this.codigoBancario=codigoBancario;
                this.codigoSwift=codigoSwift;
                this.descripcion=descripcion;
                this.observaciones=observaciones;
                
        }
    
	@Id
	@Column(name="OID_BANC")
	private Long oid;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="COD_BANC")
	private String codigo;
	@Column(name="COD_BRIO")
	private String codigoBancario;
	@Column(name="COD_SWIF_INFO")
	private String codigoSwift;
	@Column(name="DES_BANC")
	private String descripcion;
	@Column(name="VAL_OBS_BANC")
	private String observaciones;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public String getCodigo() {return codigo;}
      
	public void setCodigo(String codigo){this.codigo=codigo;}
		
	public String getCodigoBancario() {return codigoBancario;}
      
	public void setCodigoBancario(String codigoBancario){this.codigoBancario=codigoBancario;}
		
	public String getCodigoSwift() {return codigoSwift;}
      
	public void setCodigoSwift(String codigoSwift){this.codigoSwift=codigoSwift;}
		
	public String getDescripcion() {return descripcion;}
      
	public void setDescripcion(String descripcion){this.descripcion=descripcion;}
		
	public String getObservaciones() {return observaciones;}
      
	public void setObservaciones(String observaciones){this.observaciones=observaciones;}
			
	
}
