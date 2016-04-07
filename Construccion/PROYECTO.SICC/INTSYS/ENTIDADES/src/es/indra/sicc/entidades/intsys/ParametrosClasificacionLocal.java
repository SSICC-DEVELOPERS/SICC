package es.indra.sicc.entidades.intsys;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INT_PARAM_CLASI")
@NamedQueries({
@NamedQuery(name="ParametrosClasificacionLocal.FindAll",query="select object(o) from ParametrosClasificacionLocal o")
})
public class ParametrosClasificacionLocal implements Serializable {

	public ParametrosClasificacionLocal() {}

	public ParametrosClasificacionLocal(Long oid, String valParaEjec, String valTipoClas, Long cmejOidCodi, Long paisOidPais)	{
            this.oid=oid;
	    this.valParaEjec=valParaEjec;
	    this.valTipoClas=valTipoClas;
	    this.cmejOidCodi=cmejOidCodi;
	    this.paisOidPais=paisOidPais;
	}

	@Id
	@Column(name="OID_PARA_CLAS")
	private Long oid;
	@Column(name="VAL_PARA_EJEC")
	private String valParaEjec;
	@Column(name="VAL_TIPO_CLAS")
	private String valTipoClas;
	@Column(name="CMEJ_OID_CODI")
	private Long cmejOidCodi;
	@Column(name="PAIS_OID_PAIS")
	private Long paisOidPais;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getValParaEjec() {return valParaEjec;}
      
	public void setValParaEjec(String valParaEjec){this.valParaEjec=valParaEjec;}
		
	public String getValTipoClas() {return valTipoClas;}
      
	public void setValTipoClas(String valTipoClas){this.valTipoClas=valTipoClas;}
		
	public Long getCmejOidCodi() {return cmejOidCodi;}
      
	public void setCmejOidCodi(Long cmejOidCodi){this.cmejOidCodi=cmejOidCodi;}
		
	public Long getPaisOidPais() {return paisOidPais;}
      
	public void setPaisOidPais(Long paisOidPais){this.paisOidPais=paisOidPais;}
			
	
}
