package es.indra.sicc.entidades.bel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="BEL_OPERA")
@NamedQueries({
@NamedQuery(name="OperacionesLocal.FindByUK",query="SELECT OBJECT(a) FROM OperacionesLocal AS a WHERE a.codigoOperacion=?1")
})
public class OperacionesLocal implements Serializable {

	public OperacionesLocal() {}

        public OperacionesLocal(Long oid, String codigoOperacion, String descripcion) {
                this.oid=oid;
                this.codigoOperacion = codigoOperacion;
                this.descripcion = descripcion;
        }

	public OperacionesLocal(Long oid, String codigoOperacion, String descripcion, Boolean indicadorContadores, Boolean indicadorMovAlmacen, Boolean indicadorSolicitudModExt) {
		this.oid=oid;
                this.codigoOperacion = codigoOperacion;
                this.descripcion = descripcion;
                this.indicadorContadores = indicadorContadores;
                this.indicadorMovAlmacen = indicadorMovAlmacen;
                this.indicadorSolicitudModExt = indicadorSolicitudModExt;
	}

	@Id
	@Column(name="OID_OPER")
	private Long oid;
	@Column(name="COD_OPER")
	private String codigoOperacion;
	@Column(name="DES_OPER")
	private String descripcion;
	@Column(name="IND_CONT")
	private Boolean indicadorContadores;
	@Column(name="IND_MOVI_ALMA")
	private Boolean indicadorMovAlmacen;
	@Column(name="IND_SOLI_MODU_EXTE")
	private Boolean indicadorSolicitudModExt;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigoOperacion() {return codigoOperacion;}
      
	public void setCodigoOperacion(String codigoOperacion){this.codigoOperacion=codigoOperacion;}
		
	public String getDescripcion() {return descripcion;}
      
	public void setDescripcion(String descripcion){this.descripcion=descripcion;}
		
	public Boolean getIndicadorContadores() {return indicadorContadores;}
      
	public void setIndicadorContadores(Boolean indicadorContadores){this.indicadorContadores=indicadorContadores;}
		
	public Boolean getIndicadorMovAlmacen() {return indicadorMovAlmacen;}
      
	public void setIndicadorMovAlmacen(Boolean indicadorMovAlmacen){this.indicadorMovAlmacen=indicadorMovAlmacen;}
		
	public Boolean getIndicadorSolicitudModExt() {return indicadorSolicitudModExt;}
      
	public void setIndicadorSolicitudModExt(Boolean indicadorSolicitudModExt){this.indicadorSolicitudModExt=indicadorSolicitudModExt;}
			
	
}
