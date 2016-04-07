package es.indra.sicc.entidades.men;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocal;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocalHome;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.util.Iterator;
import java.util.Vector;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

@Entity
@Table(name="MEN_FUNCI")
@NamedQueries({
@NamedQuery(name="FuncionLocal.FindAll",query="select object(f) from FuncionLocal f")
})
public class FuncionLocal implements Serializable {

	public FuncionLocal() {}

        public FuncionLocal(Long oid, Boolean indicadorNivel, Boolean indicadorRastreo, Long funcOid) {
                this.oid = oid;
                this.funcOid = funcOid;
                this.indicadorNivel = indicadorNivel;
                this.indicadorRastreo = indicadorRastreo;                
        }

        public FuncionLocal(Long oid, Boolean indicadorNivel, Boolean indicadorRastreo, Vector valores, Long funcOid) {
                this.oid = oid;
                this.funcOid = funcOid;
                this.indicadorNivel = indicadorNivel;
                this.indicadorRastreo = indicadorRastreo;  
        }

    
	@Id
	@Column(name="OID_FUNC")
	private Long oid;
	@Column(name="VAL_NOMB_PROG")
	private String nombrePrograma;
	@Column(name="FUNC_OID_FUNC")
	private Long funcOid;
	@Column(name="IND_NIVE")
	private Boolean indicadorNivel;
	@Column(name="IND_RAST")
	private Boolean indicadorRastreo;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getNombrePrograma() {return nombrePrograma;}
      
	public void setNombrePrograma(String nombrePrograma){this.nombrePrograma=nombrePrograma;}
		
	public Long getFuncOid() {return funcOid;}
      
	public void setFuncOid(Long funcOid){this.funcOid=funcOid;}
		
	public Boolean getIndicadorNivel() {return indicadorNivel;}
      
	public void setIndicadorNivel(Boolean indicadorNivel){this.indicadorNivel=indicadorNivel;}
		
	public Boolean getIndicadorRastreo() {return indicadorRastreo;}
      
	public void setIndicadorRastreo(Boolean indicadorRastreo){this.indicadorRastreo=indicadorRastreo;}
        
        public void setTraducciones(Vector valores) throws MareException {
            Entidadi18nLocalHome i18nlh = new Entidadi18nLocalHome();
            String entidad = new String("MEN_FUNCI");

            for (Iterator iteValores = valores.iterator(); iteValores.hasNext();) {
            
                DTOI18nSICC valor = (DTOI18nSICC)iteValores.next();
                if(valor != null) {
                    try {
                        Entidadi18nLocal locali18n = i18nlh.findByEntAtrIdioPK(entidad, valor.getOidAtriuto(), valor.getOidIdioma(), oid);
                        locali18n.setDetalle(valor.getValorI18n());
                        i18nlh.merge(locali18n);
                    } catch(NoResultException nre) { 
                        i18nlh.create(entidad, valor.getOidAtriuto(), valor.getOidIdioma(), valor.getValorI18n(), oid);
                    } catch(PersistenceException pe){
                        String codigoError = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
                        throw new MareException(pe, UtilidadesError.armarCodigoError(codigoError));                            
                    }
                }
            }        
        }
			
	
}
