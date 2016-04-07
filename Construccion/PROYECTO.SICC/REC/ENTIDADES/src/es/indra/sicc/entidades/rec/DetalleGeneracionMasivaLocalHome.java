package es.indra.sicc.entidades.rec;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.rec.DetalleGeneracionMasivaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class DetalleGeneracionMasivaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-rec");
	private EntityManager em = emf.createEntityManager();

	public DetalleGeneracionMasivaLocal create(Long numeroGeneracion, Long numeroSolicitud, Long cliente, Long tipoSolicitud) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("REC_DEGM_SEQ");
                final EntityTransaction et = em.getTransaction();
		et.begin();
                DetalleGeneracionMasivaLocal local = new DetalleGeneracionMasivaLocal(oid, numeroGeneracion, numeroSolicitud, cliente, tipoSolicitud);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(DetalleGeneracionMasivaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(DetalleGeneracionMasivaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public DetalleGeneracionMasivaLocal findByPrimaryKey(Long  oid) {
		DetalleGeneracionMasivaLocal local = (DetalleGeneracionMasivaLocal)em.find(DetalleGeneracionMasivaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("DetalleGeneracionMasivaLocal.FindAll");
		
		return query.getResultList();
	}

	public DetalleGeneracionMasivaLocal findByUK(Long param1,Long param2,Long param3,Long param4) {
		Query query=em.createNamedQuery("DetalleGeneracionMasivaLocal.FindByUK");
		
		query.setParameter(1, param1);

		query.setParameter(2, param2);

		query.setParameter(3, param3);

		query.setParameter(4, param4);

		return (DetalleGeneracionMasivaLocal)(query.getSingleResult());
	}

}
