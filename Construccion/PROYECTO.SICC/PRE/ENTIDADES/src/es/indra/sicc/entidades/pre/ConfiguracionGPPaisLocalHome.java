package es.indra.sicc.entidades.pre;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.pre.ConfiguracionGPPaisLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ConfiguracionGPPaisLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-pre");
	private EntityManager em = emf.createEntityManager();

	public ConfiguracionGPPaisLocal create(Long pais_oid_pais, Long marc_oid_marc, Long cana_oid_cana, Integer val_incr) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("PRE_CGPP_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ConfiguracionGPPaisLocal local = new ConfiguracionGPPaisLocal(oid, pais_oid_pais, marc_oid_marc, cana_oid_cana, val_incr);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ConfiguracionGPPaisLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ConfiguracionGPPaisLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ConfiguracionGPPaisLocal findByPrimaryKey(Long  oid) {
		ConfiguracionGPPaisLocal local = (ConfiguracionGPPaisLocal)em.find(ConfiguracionGPPaisLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findByPaisMarcaCanal(Long oidPais,Long oidMarca,Long oidCanal) {
		Query query=em.createNamedQuery("ConfiguracionGPPaisLocal.FindByPaisMarcaCanal");
		
		query.setParameter(1, oidPais);

		query.setParameter(2, oidMarca);

		query.setParameter(3, oidCanal);

		return query.getResultList();
	}

}
