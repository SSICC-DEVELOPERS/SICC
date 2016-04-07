package es.indra.sicc.entidades.ped;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PED_TIPO_DOCUM_SEGUI")
@NamedQueries({
@NamedQuery(name="TipoDocumentoSeguimientoLocal.FindAll",query="SELECT OBJECT(p) from TipoDocumentoSeguimientoLocal p")
})
public class TipoDocumentoSeguimientoLocal implements Serializable {

    public TipoDocumentoSeguimientoLocal() {}

    public TipoDocumentoSeguimientoLocal(Long oid)	{
    
            this.oid=oid;
    
    }

    @Id
    @Column(name="OID_TIPO")
    private Long oid;

    
    public Long getOid() {return oid;}
  
    public Long getPrimaryKey() {return oid;}		
}
