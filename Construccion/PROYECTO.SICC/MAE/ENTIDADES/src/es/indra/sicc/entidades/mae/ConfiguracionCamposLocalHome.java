package es.indra.sicc.entidades.mae;	

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mae.ConfiguracionCamposLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ConfiguracionCamposLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mae");
	private EntityManager em = emf.createEntityManager();

	public ConfiguracionCamposLocal create(Long pais_oid_pais, Long atre_oid_atri_espe, String val_defe, Long ind_obli, Long ind_modi)
                throws MareException {
            Long oid = SecuenciadorOID.obtenerSiguienteValor("MAE_COCA_SEQ");
            final EntityTransaction et = em.getTransaction();
            et.begin();
            ConfiguracionCamposLocal local = new ConfiguracionCamposLocal(oid, pais_oid_pais, atre_oid_atri_espe, val_defe, ind_obli, ind_modi);
            em.persist(local);
            et.commit();
            return local;
	}
	
	public void remove(ConfiguracionCamposLocal local) {
            final EntityTransaction et = em.getTransaction();
            et.begin();
            em.remove(local);
            et.commit();
	}
	
	public void merge(ConfiguracionCamposLocal local) {
            final EntityTransaction et = em.getTransaction();
            et.begin();
            em.merge(local);
            et.commit();
	}
	
	public ConfiguracionCamposLocal findByPrimaryKey(Long oid) {
            ConfiguracionCamposLocal local = em.find(ConfiguracionCamposLocal.class, oid);
            if (local==null) throw new NoResultException();
            return local;
	}
        
        public Collection findAll() {
            Query query = em.createNamedQuery("ConfiguracionCamposLocal.FindAll");
            return query.getResultList();
        }
}
