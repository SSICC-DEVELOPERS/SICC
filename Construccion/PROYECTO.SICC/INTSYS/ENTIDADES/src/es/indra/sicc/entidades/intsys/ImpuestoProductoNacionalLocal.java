package es.indra.sicc.entidades.intsys;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name="INT_IMPUE_PRODU_NACIO")
@NamedQueries({
@NamedQuery(name="ImpuestoProductoNacionalLocal.FindAll",query="select object(o) from ImpuestoProductoNacionalLocal o"),
@NamedQuery(name="ImpuestoProductoNacionalLocal.findByCodSAPYFecha",query="SELECT OBJECT(o) FROM  ImpuestoProductoNacionalLocal o WHERE o.oidProducto = ?1 AND o.fechaCarga = ?2")
})

public class ImpuestoProductoNacionalLocal
    implements Serializable
{
    @Id
	@Column(name="OID_IMPU_PROD_NACI")
    private Long oid;
	@Column(name="PROD_OID_PROD")
    private Long oidProducto;
	@Column(name="VAL_IMPU_PROD_NACI")
    private BigDecimal impuestoProdNacional;
	@Column(name="FEC_CARG")
    private Date fechaCarga;


    public ImpuestoProductoNacionalLocal()
    {
    }

    public ImpuestoProductoNacionalLocal(Long oid, Long oidProducto)
    {
        this.oid = oid;
        this.oidProducto = oidProducto;
    }

    public Long getOid()
    {
        return oid;
    }

    public Long getPrimaryKey()
    {
        return oid;
    }

    public Long getOidProducto()
    {
        return oidProducto;
    }

    public void setOidProducto(Long oidProducto)
    {
        this.oidProducto = oidProducto;
    }

    public BigDecimal getImpuestoProdNacional()
    {
        return impuestoProdNacional;
    }

    public void setImpuestoProdNacional(BigDecimal impuestoProdNacional)
    {
        this.impuestoProdNacional = impuestoProdNacional;
    }

    public Date getFechaCarga()
    {
        return fechaCarga;
    }

    public void setFechaCarga(Date fechaCarga)
    {
        this.fechaCarga = fechaCarga;
    }
}
