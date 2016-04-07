package es.indra.sicc.entidades.dto;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.dto.SubaccesoDescuentoLocal;
import es.indra.sicc.util.SecuenciadorOID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;


public class SubaccesoDescuentoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-dto");
	private EntityManager em = emf.createEntityManager();

	public SubaccesoDescuentoLocal create(Long sbac_oid_sbac, Long dcto_oid_des) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("DTO_DESA_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		SubaccesoDescuentoLocal local = new SubaccesoDescuentoLocal(oid, sbac_oid_sbac, dcto_oid_des);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(SubaccesoDescuentoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(SubaccesoDescuentoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public SubaccesoDescuentoLocal findByPrimaryKey(Long  oid) {
		SubaccesoDescuentoLocal local = (SubaccesoDescuentoLocal)em.find(SubaccesoDescuentoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
