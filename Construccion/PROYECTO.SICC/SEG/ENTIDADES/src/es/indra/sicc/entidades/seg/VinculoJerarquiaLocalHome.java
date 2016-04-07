package es.indra.sicc.entidades.seg;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.seg.VinculoJerarquiaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class VinculoJerarquiaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-seg");
	private EntityManager em = emf.createEntityManager();

	public VinculoJerarquiaLocal create(Long pais, Long marca, Long canal, Long acceso, Long subacceso, Long empresa)
			throws MareException {
		
		Long oid = SecuenciadorOID.obtenerSiguienteValor("SEG_VIJE_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		VinculoJerarquiaLocal local = new VinculoJerarquiaLocal(oid, pais, marca, canal, acceso, subacceso, empresa);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(VinculoJerarquiaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(VinculoJerarquiaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public VinculoJerarquiaLocal findByPrimaryKey(Long  oid) {
		VinculoJerarquiaLocal local = em.find(VinculoJerarquiaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}
	
	public Collection findAll() {
		Query query = em.createNamedQuery("VinculoJerarquiaLocal.FindAll");
		return query.getResultList();
	}

	
}
