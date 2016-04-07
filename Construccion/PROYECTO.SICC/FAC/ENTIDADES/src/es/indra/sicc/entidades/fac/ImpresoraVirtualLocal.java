package es.indra.sicc.entidades.fac;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="FAC_IMPRE_VIRTU")
public class ImpresoraVirtualLocal implements Serializable {

	public ImpresoraVirtualLocal() {}

	public ImpresoraVirtualLocal(Long oid, Long pais, String codigoImpresora, String descripcion, Long tipo, Long statusActivo)	{
            this.oid=oid;
	    this.pais = pais;
	    this.codigoImpresora = codigoImpresora;
	    this.descripcion = descripcion;
	    this.tipo = tipo;
	    this.statusActivo = statusActivo;
	}

        public ImpresoraVirtualLocal(Long oid,Long pais, String codigoImpresora, String descripcion, Long tipo, Long statusActivo, String atributo_1)  {
            this.oid=oid;
            this.pais = pais;
            this.codigoImpresora = codigoImpresora;
            this.descripcion = descripcion;
            this.tipo = tipo;
            this.statusActivo = statusActivo;
            this.atributo_1 = atributo_1;
        }

	@Id
	@Column(name="OID_IMPR")
	private Long oid;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="COD_IMPR")
	private String codigoImpresora;
	@Column(name="DES_IMPR")
	private String descripcion;
	@Column(name="TIIM_OID_TIPO")
	private Long tipo;
	@Column(name="IND_ESTA_ACTI")
	private Long statusActivo;
	@Column(name="VAL_ATR1")
	private String atributo_1;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public String getCodigoImpresora() {return codigoImpresora;}
      
	public void setCodigoImpresora(String codigoImpresora){this.codigoImpresora=codigoImpresora;}
		
	public String getDescripcion() {return descripcion;}
      
	public void setDescripcion(String descripcion){this.descripcion=descripcion;}
		
	public Long getTipo() {return tipo;}
      
	public void setTipo(Long tipo){this.tipo=tipo;}
		
	public Long getStatusActivo() {return statusActivo;}
      
	public void setStatusActivo(Long statusActivo){this.statusActivo=statusActivo;}
		
	public String getAtributo_1() {return atributo_1;}
      
	public void setAtributo_1(String atributo_1){this.atributo_1=atributo_1;}
			
	
}
