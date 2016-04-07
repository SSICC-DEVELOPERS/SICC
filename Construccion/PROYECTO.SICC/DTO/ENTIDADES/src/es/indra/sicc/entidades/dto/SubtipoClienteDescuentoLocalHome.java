package es.indra.sicc.entidades.dto;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.dto.SubtipoClienteDescuentoLocal;
import es.indra.sicc.util.SecuenciadorOID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;


public class SubtipoClienteDescuentoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-dto");
	private EntityManager em = emf.createEntityManager();

	public SubtipoClienteDescuentoLocal create(Long dcto_oid_desc, Long sbti_oid_subt_clie) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("DTO_DSCL_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		SubtipoClienteDescuentoLocal local = new SubtipoClienteDescuentoLocal(oid, dcto_oid_desc, sbti_oid_subt_clie);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(SubtipoClienteDescuentoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(SubtipoClienteDescuentoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public SubtipoClienteDescuentoLocal findByPrimaryKey(Long  oid) {
		SubtipoClienteDescuentoLocal local = (SubtipoClienteDescuentoLocal)em.find(SubtipoClienteDescuentoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
