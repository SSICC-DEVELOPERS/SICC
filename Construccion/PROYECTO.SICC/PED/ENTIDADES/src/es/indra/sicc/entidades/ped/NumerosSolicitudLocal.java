package es.indra.sicc.entidades.ped;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PED_NUMER_SOLIC")
@NamedQueries({
@NamedQuery(name="NumerosSolicitudLocal.FindByUK",query="select Object(n) from NumerosSolicitudLocal n "
+ " WHERE n.codPais = ?1 and n.codCanal = ?2 and "
+ " n.codAcceso = ?3 and n.codSubacceso =?4 and n.operacion =?5 and n.anyo = ?6"),
@NamedQuery(name="NumerosSolicitudLocal.FindAll", query="SELECT OBJECT(o) FROM NumerosSolicitudLocal AS o")
})
public class NumerosSolicitudLocal implements Serializable {

    public NumerosSolicitudLocal() {}

    public NumerosSolicitudLocal(Long oid, String anyo, Integer ultimoNumSolicitud, String operacion,
            String codPais, String codCanal, String codAcceso, String codSubacceso) {
        this.oid=oid;
        this.anyo = anyo;
        this.ultimoNumSolicitud = ultimoNumSolicitud;
        this.operacion = operacion;
        this.codPais = codPais;
        this.codCanal = codCanal;
        this.codAcceso = codAcceso;
        this.codSubacceso = codSubacceso;            
    }

    @Column(name="VAL_ANIO")
    private String anyo;
    @Column(name="VAL_ULTI_NUME_SOLI")
    private Integer ultimoNumSolicitud;
    @Column(name="VAL_OPER")
    private String operacion;
    @Id
    @Column(name="OID_NUME_SOLI")
    private Long oid;
    @Column(name="COD_PAIS")
    private String codPais;
    @Column(name="COD_CANA")
    private String codCanal;
    @Column(name="COD_ACCE")
    private String codAcceso;
    @Column(name="COD_SUBA")
    private String codSubacceso;

    
    public String getAnyo() {return anyo;}
  
    public void setAnyo(String anyo){this.anyo=anyo;}
            
    public Integer getUltimoNumSolicitud() {return ultimoNumSolicitud;}
  
    public void setUltimoNumSolicitud(Integer ultimoNumSolicitud){this.ultimoNumSolicitud=ultimoNumSolicitud;}
            
    public String getOperacion() {return operacion;}
  
    public void setOperacion(String operacion){this.operacion=operacion;}
            
    public Long getOid() {return oid;}
  
    public Long getPrimaryKey() {return oid;}		
            
    public String getCodPais() {return codPais;}
  
    public void setCodPais(String codPais){this.codPais=codPais;}
            
    public String getCodCanal() {return codCanal;}
  
    public void setCodCanal(String codCanal){this.codCanal=codCanal;}
            
    public String getCodAcceso() {return codAcceso;}
  
    public void setCodAcceso(String codAcceso){this.codAcceso=codAcceso;}
            
    public String getCodSubacceso() {return codSubacceso;}
  
    public void setCodSubacceso(String codSubacceso){this.codSubacceso=codSubacceso;}
			
	
}
