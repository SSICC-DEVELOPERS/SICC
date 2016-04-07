package es.indra.sicc.entidades.rec;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.rec.OperacionReclamoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class OperacionReclamoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-rec");
	private EntityManager em = emf.createEntityManager();

	public OperacionReclamoLocal create(Integer secuencialOperacion, Long numeroAtencion, Long periodoReclamo, Long tipoOperacion, Long documentoReferencia) throws MareException  {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("REC_OPRE_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
                OperacionReclamoLocal local = new OperacionReclamoLocal(oid, secuencialOperacion, numeroAtencion, periodoReclamo, tipoOperacion, documentoReferencia);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(OperacionReclamoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(OperacionReclamoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public OperacionReclamoLocal findByPrimaryKey(Long  oid) {
		OperacionReclamoLocal local = em.find(OperacionReclamoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("OperacionReclamoLocal.FindAll");
		
		return (query.getResultList());
	}

	public Collection findByCabeceraReclamo(Long param1) {
		Query query=em.createNamedQuery("OperacionReclamoLocal.FindByCabeceraReclamo");
		
		query.setParameter(1, param1);

		return query.getResultList();
	}

	public Collection findByDocumentoReferencia(Long param1) {
		Query query=em.createNamedQuery("OperacionReclamoLocal.FindByDocumentoReferencia");
		
		query.setParameter(1, param1);

		return query.getResultList();
	}

	public OperacionReclamoLocal findByUK(Long param1,Integer param2) {
		Query query=em.createNamedQuery("OperacionReclamoLocal.FindByUK");
		
		query.setParameter(1, param1);

		query.setParameter(2, param2);

		return (OperacionReclamoLocal)(query.getSingleResult());
	}

}
