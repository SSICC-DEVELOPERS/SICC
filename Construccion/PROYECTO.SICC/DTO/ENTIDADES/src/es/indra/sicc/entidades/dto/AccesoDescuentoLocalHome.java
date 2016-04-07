package es.indra.sicc.entidades.dto;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.dto.AccesoDescuentoLocal;
import es.indra.sicc.util.SecuenciadorOID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;


public class AccesoDescuentoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-dto");
	private EntityManager em = emf.createEntityManager();

	public AccesoDescuentoLocal create(Long dcto_oid_desc, Long acce_oid_acce) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("DTO_DEAC_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		AccesoDescuentoLocal local = new AccesoDescuentoLocal(oid, dcto_oid_desc, acce_oid_acce);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(AccesoDescuentoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(AccesoDescuentoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public AccesoDescuentoLocal findByPrimaryKey(Long  oid) {
		AccesoDescuentoLocal local = (AccesoDescuentoLocal)em.find(AccesoDescuentoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
