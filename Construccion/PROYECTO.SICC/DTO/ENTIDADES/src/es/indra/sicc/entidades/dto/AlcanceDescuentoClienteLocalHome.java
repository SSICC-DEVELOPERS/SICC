package es.indra.sicc.entidades.dto;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.dto.AlcanceDescuentoClienteLocal;
import es.indra.sicc.util.SecuenciadorOID;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class AlcanceDescuentoClienteLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-dto");
	private EntityManager em = emf.createEntityManager();

	public AlcanceDescuentoClienteLocal create(Long dcto_oid_desc, Long clie_oid_clie) throws MareException {
		Long oid = SecuenciadorOID.obtenerSiguienteValor("DTO_ADCC_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		AlcanceDescuentoClienteLocal local = new AlcanceDescuentoClienteLocal(oid, dcto_oid_desc, clie_oid_clie);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(AlcanceDescuentoClienteLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(AlcanceDescuentoClienteLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public AlcanceDescuentoClienteLocal findByPrimaryKey(Long  oid) {
		AlcanceDescuentoClienteLocal local = (AlcanceDescuentoClienteLocal)em.find(AlcanceDescuentoClienteLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findByOidDescuento(Long oidDescu) {
		Query query=em.createNamedQuery("AlcanceDescuentoClienteLocal.FindByOidDescuento");
		
		query.setParameter(1, oidDescu);

		return query.getResultList();
	}

}
