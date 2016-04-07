package es.indra.sicc.cmn.negocio.print;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="GEN_DOCUM_IMPRI")
@NamedQueries({
@NamedQuery(name="IMPPrintableDocumentLocal.FindAll",query="select object(o) from IMPPrintableDocumentLocal o")
})
public class IMPPrintableDocumentLocal implements Serializable {

    public IMPPrintableDocumentLocal() {}

    public IMPPrintableDocumentLocal(Long idDocument, Long gcolOidCola)	{
        this.idDocument = idDocument;
        this.idQueue = gcolOidCola;
    }

    @Id
    @Column(name="OID_DOCU_IMPR")
    private Long idDocument;
    @Column(name="NUM_SECU")
    private Long numSecuencia;
    @Column(name="IND_IMPR")
    private Boolean print;
    @Column(name="VAL_BUFF")
    private byte[] buffer;
    @Column(name="IND_DOCU_FANT")
    private Boolean ghostDoc;
    @Column(name="GCOL_OID_COLA")
    private Long idQueue;

    
    public Long getIdDocument() {return idDocument;}
  
    public Long getPrimaryKey() {return idDocument;}		
            
    public Long getNumSecuencia() {return numSecuencia;}
  
    public void setNumSecuencia(Long numSecuencia){this.numSecuencia=numSecuencia;}
            
    public Boolean getPrint() {return print;}
  
    public void setPrint(Boolean print){this.print=print;}
            
    public byte[] getBuffer() {return buffer;}
  
    public void setBuffer(byte[] buffer){this.buffer=buffer;}
            
    public Boolean getGhostDoc() {return ghostDoc;}
  
    public void setGhostDoc(Boolean ghostDoc){this.ghostDoc=ghostDoc;}
            
    public Long getIdQueue() {return idQueue;}
  
    public void setIdQueue(Long idQueue){this.idQueue=idQueue;}
}
