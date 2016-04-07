package es.indra.sicc.entidades.edu;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="EDU_TIPO_CURSO")
public class TiposCursoLocal implements Serializable {

	public TiposCursoLocal() {}

	public TiposCursoLocal(Long oid_tipo_curs, Long marc_oid_marc, Integer cod_tipo_curs, Long nothing)	{
	
		this.oid=oid_tipo_curs;
                this.marca=marc_oid_marc;
                this.codigo=cod_tipo_curs;                
	
	}

        public TiposCursoLocal(Long oid, Long marc_oid_marc, Integer cod_tipo_curs)   {
        
                this.oid=oid;
                this.marca=marc_oid_marc;
                this.codigo=cod_tipo_curs;                
        
        }

	@Id
	@Column(name="OID_TIPO_CURS")
	private Long oid;
	@Column(name="MARC_OID_MARC")
	private Long marca;
	@Column(name="COD_TIPO_CURS")
	private Integer codigo;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getMarca() {return marca;}
      
	public void setMarca(Long marca){this.marca=marca;}
		
	public Integer getCodigo() {return codigo;}
      
	public void setCodigo(Integer codigo){this.codigo=codigo;}
			
	
}
