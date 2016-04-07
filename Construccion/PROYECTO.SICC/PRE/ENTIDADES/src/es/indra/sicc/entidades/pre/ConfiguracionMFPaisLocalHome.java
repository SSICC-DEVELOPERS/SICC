package es.indra.sicc.entidades.pre;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.pre.ConfiguracionMFPaisLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ConfiguracionMFPaisLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-pre");
	private EntityManager em = emf.createEntityManager();
    
	public ConfiguracionMFPaisLocal create(Long pais_oid_pais, Long marc_oid_marc, Long cana_oid_cana, Long mone_oid_mone) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("PRE_MFPA_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ConfiguracionMFPaisLocal local = new ConfiguracionMFPaisLocal(oid, pais_oid_pais, marc_oid_marc, cana_oid_cana, mone_oid_mone);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ConfiguracionMFPaisLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ConfiguracionMFPaisLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ConfiguracionMFPaisLocal findByPrimaryKey(Long  oid) {
		ConfiguracionMFPaisLocal local = (ConfiguracionMFPaisLocal)em.find(ConfiguracionMFPaisLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findByPaisMarcaCanal(Long oidPais,Long oidMarca,Long oidCanal) {
		Query query=em.createNamedQuery("ConfiguracionMFPaisLocal.FindByPaisMarcaCanal");
		
		query.setParameter(1, oidPais);

		query.setParameter(2, oidMarca);

		query.setParameter(3, oidCanal);

		return query.getResultList();
	}

}
