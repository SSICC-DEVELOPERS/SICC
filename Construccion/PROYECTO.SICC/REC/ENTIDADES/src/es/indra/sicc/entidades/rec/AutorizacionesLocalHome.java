package es.indra.sicc.entidades.rec;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.rec.AutorizacionesLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class AutorizacionesLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-rec");
	private EntityManager em = emf.createEntityManager();

	public AutorizacionesLocal create(Integer idUsuario, Long pais, Long tipoOperacion) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("REC_AUTO_SEQ");
                final EntityTransaction et = em.getTransaction();
		et.begin();
                AutorizacionesLocal local = new AutorizacionesLocal(oid, idUsuario, pais, tipoOperacion);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(AutorizacionesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(AutorizacionesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public AutorizacionesLocal findByPrimaryKey(Long  oid) {
		AutorizacionesLocal local = (AutorizacionesLocal)em.find(AutorizacionesLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("AutorizacionesLocal.FindAll");
		
		return query.getResultList();
	}

	public AutorizacionesLocal findByUK(Long param1,Long param2,Integer param3) {
		Query query=em.createNamedQuery("AutorizacionesLocal.FindByUK");
		
		query.setParameter(1, param1);

		query.setParameter(2, param2);

		query.setParameter(3, param3);

		return (AutorizacionesLocal)(query.getSingleResult());
	}

}
