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
@Table(name="ZON_TERRI")
@NamedQueries({
@NamedQuery(name="TerritorioLocal.FindByCodigoPaisBorrado",query="SELECT OBJECT(a)"
+ " FROM TerritorioLocal AS a "
+ " WHERE a.oidPais = ?2 "
+ " AND a.codTerritorio = ?1"),
// TODO Falta la query FindByCodigoPaisBorradoRTZ, que es complicada, se pasara a un DAO
@NamedQuery(name="TerritorioLocal.FindByCodigoPais",query="SELECT OBJECT(a) "
+ " FROM TerritorioLocal AS a "
+ " WHERE a.oidPais = ?2 "
+ " AND a.codTerritorio = ?1 "
+ " AND a.borrado = 0"),
@NamedQuery(name="TerritorioLocal.FindAll",query="SELECT OBJECT(a) FROM TerritorioLocal AS a")
})
public class TerritorioLocal implements Serializable {

    public TerritorioLocal() {}

    public TerritorioLocal(Long oid, Long cod_terr, Long pais_oid_pais, String nse1,
            String nse2, Long ind_borr, Long vepo_oid_valo_estr_geop)	{
        
        this.oid = oid;
        this.codTerritorio = cod_terr;
        this.oidPais = pais_oid_pais;
        this.nse1 = nse1;
        this.nse2 = nse2;
        this.borrado = ind_borr;
        this.oidValoresEstruGeo = vepo_oid_valo_estr_geop;
    }
    
     public TerritorioLocal(Long oid, Long cod_terr, Long pais_oid_pais, Long ind_borr, 
             Long vepo_oid_valo_estr_geop, Timestamp fec_rtz)   {
         
         this.oid = oid;
         this.codTerritorio = cod_terr;
         this.oidPais = pais_oid_pais;
         this.borrado = ind_borr;
         this.oidValoresEstruGeo = vepo_oid_valo_estr_geop;
         this.fechaRtz = fec_rtz;
     }
     
    @Id
    @Column(name="OID_TERR")
    private Long oid;
    @Column(name="COD_TERR")
    private Long codTerritorio;
    @Column(name="PAIS_OID_PAIS")
    private Long oidPais;
    @Column(name="COD_NSE1")
    private String nse1;
    @Column(name="COD_NSE2")
    private String nse2;
    @Column(name="COD_NSE3")
    private String nse3;
    @Column(name="IND_BORR")
    private Long borrado;
    @Column(name="VEPO_OID_VALO_ESTR_GEOP")
    private Long oidValoresEstruGeo;
    @Column(name="FEC_RTZ")
    private Timestamp fechaRtz;

    
    public Long getOid() {return oid;}
  
    public Long getPrimaryKey() {return oid;}		
            
    public Long getCodTerritorio() {return codTerritorio;}
  
    public void setCodTerritorio(Long codTerritorio){this.codTerritorio=codTerritorio;}
            
    public Long getOidPais() {return oidPais;}
  
    public void setOidPais(Long oidPais){this.oidPais=oidPais;}
            
    public String getNse1() {return nse1;}
  
    public void setNse1(String nse1){this.nse1=nse1;}
            
    public String getNse2() {return nse2;}
  
    public void setNse2(String nse2){this.nse2=nse2;}
            
    public String getNse3() {return nse3;}
  
    public void setNse3(String nse3){this.nse3=nse3;}
            
    public Long getBorrado() {return borrado;}
  
    public void setBorrado(Long borrado){this.borrado=borrado;}
            
    public Long getOidValoresEstruGeo() {return oidValoresEstruGeo;}
  
    public void setOidValoresEstruGeo(Long oidValoresEstruGeo){this.oidValoresEstruGeo=oidValoresEstruGeo;}
            
    public Timestamp getFechaRtz() {return fechaRtz;}
  
    public void setFechaRtz(Timestamp fechaRtz){this.fechaRtz=fechaRtz;}
                    
}
