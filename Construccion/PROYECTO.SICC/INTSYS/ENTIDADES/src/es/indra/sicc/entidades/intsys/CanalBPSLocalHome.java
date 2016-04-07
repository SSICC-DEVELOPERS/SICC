package es.indra.sicc.entidades.intsys;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.intsys.CanalBPSLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class CanalBPSLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-intsys");
	private EntityManager em = emf.createEntityManager();

	public CanalBPSLocal create(String canalBPS, Long tipoCliente, Long tipoSolicitud) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INT_CBPS_SEQ");
                CanalBPSLocal local = new CanalBPSLocal(oid, canalBPS, tipoCliente, tipoSolicitud);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(CanalBPSLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(CanalBPSLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public CanalBPSLocal findByPrimaryKey(Long  oid) {
		CanalBPSLocal local = em.find(CanalBPSLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("CanalBPSLocal.FindAll");
		return query.getResultList();
	}

	public CanalBPSLocal findByUk(Long tipoCliente,Long tipoSolicitudPais) {
		Query query=em.createNamedQuery("CanalBPSLocal.FindByUk");
		query.setParameter(1, tipoCliente);
		query.setParameter(2, tipoSolicitudPais);
		return (CanalBPSLocal)(query.getSingleResult());
	}

}
