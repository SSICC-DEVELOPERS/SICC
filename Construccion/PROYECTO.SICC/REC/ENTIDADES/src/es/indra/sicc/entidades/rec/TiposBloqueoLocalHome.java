package es.indra.sicc.entidades.rec;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.rec.TiposBloqueoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class TiposBloqueoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-rec");
	private EntityManager em = emf.createEntityManager();

	public TiposBloqueoLocal create(String codTipoBloqueo, Long pais) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("REC_TIBL_SEQ");
                final EntityTransaction et = em.getTransaction();
		et.begin();
                TiposBloqueoLocal local = new TiposBloqueoLocal(oid, codTipoBloqueo, pais);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(TiposBloqueoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(TiposBloqueoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public TiposBloqueoLocal findByPrimaryKey(Long  oid) {
		TiposBloqueoLocal local = (TiposBloqueoLocal)em.find(TiposBloqueoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("TiposBloqueoLocal.FindAll");
		
		return (query.getResultList());
	}

	public TiposBloqueoLocal findByUK(Long param1,String param2) {
		Query query=em.createNamedQuery("TiposBloqueoLocal.FindByUK");
		
		query.setParameter(1, param1);

		query.setParameter(2, param2);

		return (TiposBloqueoLocal)(query.getSingleResult());
	}

}
