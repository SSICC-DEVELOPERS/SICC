package es.indra.sicc.entidades.zon;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.sql.Timestamp;

@Entity
@Table(name="ZON_TERRI_ADMIN")
@NamedQueries({
@NamedQuery(name="TerritorioAdministrativoLocal.FindByPaisMarcaCanal",query="SELECT OBJECT(a) "
+ " FROM TerritorioAdministrativoLocal AS a "
+ " WHERE a.oidPais = ?1 "
+ " AND a.oidMarca = ?2 "
+ " AND a.oidCanal = ?3 "
+ " AND a.oidTerritorio = ?4"
+ " AND a.borrado = 0"),
@NamedQuery(name="TerritorioAdministrativoLocal.FindBySeccionTerritorio",query="SELECT OBJECT(a) "
+ " FROM TerritorioAdministrativoLocal AS a  "
+ " WHERE a.oidSeccion = ?1 "
+ " AND a.oidTerritorio = ?2"
+ " AND a.borrado = 0"),
// TODO falta el finder findBySeccionTerritorioBorrRTZ, se pasara a un DAO
@NamedQuery(name="TerritorioAdministrativoLocal.FindAll",query="SELECT OBJECT(a) FROM TerritorioAdministrativoLocal AS a")
})
public class TerritorioAdministrativoLocal implements Serializable {

    public TerritorioAdministrativoLocal() {}

    public TerritorioAdministrativoLocal(Long oid, Long oidPais, Long oidMarca,
            Long oidCanal, Long seccOidSecc, Long terrOidTerr, Long periodoIni) {
        
        this.oid=oid;
        this.oidPais = oidPais;
        this.oidMarca = oidMarca;
        this.oidCanal = oidCanal;
        this.oidSeccion = seccOidSecc;
        this.oidTerritorio = terrOidTerr;
        this.periodoIni = periodoIni;
    }

    public TerritorioAdministrativoLocal(Long oid, Long oidPais, Long oidMarca, Long oidCanal, 
            Long seccOidSecc, Long terrOidTerr, Long periodoIni, Long borrado) {
        
        this(oid,oidPais,oidMarca,oidCanal,seccOidSecc,terrOidTerr,periodoIni);
        this.borrado = borrado;
    }
    
     public TerritorioAdministrativoLocal(Long oid, Long oidPais, Long oidMarca, Long oidCanal, 
             Long seccOidSecc, Long terrOidTerr, Long periodoIni, Timestamp fecRtz) {
         
         this(oid,oidPais,oidMarca,oidCanal,seccOidSecc,terrOidTerr,periodoIni);
         this.fechaReterri = fecRtz;
     }
     

    @Id
    @Column(name="OID_TERR_ADMI")
    private Long oid;
    @Column(name="IND_BORR")
    private Long borrado;
    @Column(name="ZSCC_OID_SECC")
    private Long oidSeccion;
    @Column(name="TERR_OID_TERR")
    private Long oidTerritorio;
    @Column(name="FEC_RTZ")
    private Timestamp fechaReterri;
    @Column(name="PAIS_OID_PAIS")
    private Long oidPais;
    @Column(name="MARC_OID_MARC")
    private Long oidMarca;
    @Column(name="CANA_OID_CANA")
    private Long oidCanal;
    @Column(name="PERD_OID_PERI_INIC")
    private Long periodoIni;
    @Column(name="PERD_OID_PERI_FINA")
    private Long periodoFin;

    
    public Long getOid() {return oid;}
  
    public Long getPrimaryKey() {return oid;}		
            
    public Long getBorrado() {return borrado;}
  
    public void setBorrado(Long borrado){this.borrado=borrado;}
            
    public Long getOidSeccion() {return oidSeccion;}
  
    public void setOidSeccion(Long oidSeccion){this.oidSeccion=oidSeccion;}
            
    public Long getOidTerritorio() {return oidTerritorio;}
  
    public void setOidTerritorio(Long oidTerritorio){this.oidTerritorio=oidTerritorio;}
            
    public Timestamp getFechaReterri() {return fechaReterri;}
  
    public void setFechaReterri(Timestamp fechaReterri){this.fechaReterri=fechaReterri;}
            
    public Long getOidPais() {return oidPais;}
  
    public void setOidPais(Long oidPais){this.oidPais=oidPais;}
            
    public Long getOidMarca() {return oidMarca;}
  
    public void setOidMarca(Long oidMarca){this.oidMarca=oidMarca;}
            
    public Long getOidCanal() {return oidCanal;}
  
    public void setOidCanal(Long oidCanal){this.oidCanal=oidCanal;}
            
    public Long getPeriodoIni() {return periodoIni;}
  
    public void setPeriodoIni(Long periodoIni){this.periodoIni=periodoIni;}
            
    public Long getPeriodoFin() {return periodoFin;}
  
    public void setPeriodoFin(Long periodoFin){this.periodoFin=periodoFin;}
	
}
