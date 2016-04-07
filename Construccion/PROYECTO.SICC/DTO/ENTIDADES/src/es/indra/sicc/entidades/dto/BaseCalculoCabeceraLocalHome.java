package es.indra.sicc.entidades.dto;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.dto.BaseCalculoCabeceraLocal;
import es.indra.sicc.util.SecuenciadorOID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;


public class BaseCalculoCabeceraLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-dto");
	private EntityManager em = emf.createEntityManager();

	public BaseCalculoCabeceraLocal create(Long dcto_oid_desc) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("DTO_BCCA_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		BaseCalculoCabeceraLocal local = new BaseCalculoCabeceraLocal(oid, dcto_oid_desc);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(BaseCalculoCabeceraLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(BaseCalculoCabeceraLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public BaseCalculoCabeceraLocal findByPrimaryKey(Long  oid) {
		BaseCalculoCabeceraLocal local = (BaseCalculoCabeceraLocal)em.find(BaseCalculoCabeceraLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
