package es.indra.sicc.entidades.msg;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MSG_METAC")
public class MetacaracterLocal implements Serializable {

	public MetacaracterLocal() {}

	public MetacaracterLocal(Long oid, Long cod_meta, String val_lite_iden, String val_esta, Long time_oid_tipo)	{
	
		this.oid=oid;
                this.cod_meta=cod_meta;
                this.val_lite_iden=val_lite_iden;
                this.val_esta=val_esta;
                this.time_oid_tipo=time_oid_tipo;
	}

	@Id
	@Column(name="OID_META")
	private Long oid;
	@Column(name="COD_META")
	private Long cod_meta;
	@Column(name="VAL_LITE_IDEN")
	private String val_lite_iden;
	@Column(name="VAL_ESTA")
	private String val_esta;
	@Column(name="TIME_OID_TIPO")
	private Long time_oid_tipo;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getCod_meta() {return cod_meta;}
      
	public void setCod_meta(Long cod_meta){this.cod_meta=cod_meta;}
		
	public String getVal_lite_iden() {return val_lite_iden;}
      
	public void setVal_lite_iden(String val_lite_iden){this.val_lite_iden=val_lite_iden;}
		
	public String getVal_esta() {return val_esta;}
      
	public void setVal_esta(String val_esta){this.val_esta=val_esta;}
		
	public Long getTime_oid_tipo() {return time_oid_tipo;}
      
	public void setTime_oid_tipo(Long time_oid_tipo){this.time_oid_tipo=time_oid_tipo;}
			
	
}
