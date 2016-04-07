package es.indra.sicc.entidades.ape;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="APE_FORMA_ETIQU")
@NamedQueries({
@NamedQuery(name="FormatoEtiquetaLocal.FindAll",query="select object(o) from FormatoEtiquetaLocal o"),
@NamedQuery(name="FormatoEtiquetaLocal.FindBySublinea",query="SELECT OBJECT(o) FROM FormatoEtiquetaLocal o WHERE o.oidSublinea = ?1")
})
public class FormatoEtiquetaLocal implements Serializable {

    public FormatoEtiquetaLocal() {}

    public FormatoEtiquetaLocal(Long oid, Long oidProgramaEtiqueta, Long oidSublinea)	{
        this.oid = oid;
        setOidProgramaEtiqueta(oidProgramaEtiqueta);
        setOidSublinea(oidSublinea);
    }

    @Id
    @Column(name="OID_FORM_ETIQ")
    private Long oid;
    @Column(name="VAL_FORM_ETIQ")
    private String valorFormatoEtiqueta;
    @Column(name="SBAR_OID_SUBL_ARMA")
    private Long oidSublinea;
    @Column(name="PRET_OID_PROG_ETIQ")
    private Long oidProgramaEtiqueta;

    
    public Long getOid() {return oid;}
    
    public String getValorFormatoEtiqueta() {return valorFormatoEtiqueta;}
  
    public void setValorFormatoEtiqueta(String valorFormatoEtiqueta){this.valorFormatoEtiqueta=valorFormatoEtiqueta;}
            
    public Long getOidSublinea() {return oidSublinea;}
  
    public void setOidSublinea(Long oidSublinea){this.oidSublinea=oidSublinea;}
            
    public Long getOidProgramaEtiqueta() {return oidProgramaEtiqueta;}
  
    public void setOidProgramaEtiqueta(Long oidProgramaEtiqueta){this.oidProgramaEtiqueta=oidProgramaEtiqueta;}
                    
	
}
