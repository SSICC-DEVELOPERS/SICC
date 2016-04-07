package es.indra.sicc.cmn.negocio.print;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="GEN_COLAS")
@NamedQueries({
@NamedQuery(name="IMPQueueLocal.FindByUK",query="select Object(a) from IMPQueueLocal a "
+ " where a.idSpool = ?1 "
+ " and a.idType = ?2"),
@NamedQuery(name="IMPQueueLocal.FindAll", query="select Object(a) from IMPQueueLocal a ")
})
public class IMPQueueLocal implements Serializable {

    public IMPQueueLocal() {}

    IMPQueueLocal(Long idQueue, Long idType, Long idSpool)	{
        this.idQueue = idQueue;
        this.idType = idType;
        this.idSpool = idSpool;
    }

    @Id
    @Column(name="OID_COLA")
    private Long idQueue;
    @Column(name="NUM_ULTI_SECU")
    private Long lastSequence;
    @Column(name="FEC_BLOQ")
    private java.sql.Timestamp startOwner;
    @Column(name="COD_MAQU")
    private String owner;
    @Column(name="IMVI_OID_IMPR")
    private Long idType;
    @Column(name="GSPO_OID_SPOOL")
    private Long idSpool;

    
    public Long getIdQueue() {return idQueue;}
  
    public Long getPrimaryKey() {return idQueue;}		
            
    public Long getLastSequence() {return lastSequence;}
  
    public void setLastSequence(Long lastSequence){this.lastSequence=lastSequence;}
            
    public java.sql.Timestamp getStartOwner() {return startOwner;}
  
    public void setStartOwner(java.sql.Timestamp startOwner){this.startOwner=startOwner;}
            
    public String getOwner() {return owner;}
  
    public void setOwner(String owner){this.owner=owner;}
            
    public Long getIdType() {return idType;}
  
    public void setIdType(Long idType){this.idType=idType;}
            
    public Long getIdSpool() {return idSpool;}
  
    public void setIdSpool(Long idSpool){this.idSpool=idSpool;}
}
