package es.indra.sicc.entidades.app;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.app.ConfiguracionCentroDistribucionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ConfiguracionCentroDistribucionLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-app");
	private EntityManager em = emf.createEntityManager();

	public ConfiguracionCentroDistribucionLocal create(Long pais, Long nivelOut, Long ordProd, Long ordenListaPicado, Long agrupacionDefaultAFP, Long imprDatoBasiClie,  
                                                           Long OidOrdeVisuCheq, String valOrdeVisuCheq  ) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("APP_CCDI_SEQ");
		ConfiguracionCentroDistribucionLocal local = new ConfiguracionCentroDistribucionLocal(oid, pais, nivelOut, ordProd, ordenListaPicado, agrupacionDefaultAFP, imprDatoBasiClie, 
                                                                                                      OidOrdeVisuCheq, valOrdeVisuCheq);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ConfiguracionCentroDistribucionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ConfiguracionCentroDistribucionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ConfiguracionCentroDistribucionLocal findByPrimaryKey(Long  oid) {
		ConfiguracionCentroDistribucionLocal local = (ConfiguracionCentroDistribucionLocal)em.find(ConfiguracionCentroDistribucionLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("ConfiguracionCentroDistribucionLocal.FindAll");		
		return (query.getResultList());
	}

}
