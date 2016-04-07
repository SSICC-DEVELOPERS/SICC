package es.indra.sicc.entidades.intsys;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.intsys.CodigoMedioSAPBPSLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class CodigoMedioSAPBPSLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-intsys");
	private EntityManager em = emf.createEntityManager();

	public CodigoMedioSAPBPSLocal create(String medio, Long pais, Long subAcceso) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INT_ICMS_SEQ");
		CodigoMedioSAPBPSLocal local = new CodigoMedioSAPBPSLocal(oid, medio, pais, subAcceso);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(CodigoMedioSAPBPSLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(CodigoMedioSAPBPSLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public CodigoMedioSAPBPSLocal findByPrimaryKey(Long  oid) {
		CodigoMedioSAPBPSLocal local = em.find(CodigoMedioSAPBPSLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("CodigoMedioSAPBPSLocal.FindAll");
		return query.getResultList();
	}

	public CodigoMedioSAPBPSLocal findByUk(Long pais,Long subAcceso) {
		Query query=em.createNamedQuery("CodigoMedioSAPBPSLocal.FindByUk");
		query.setParameter(1, pais);
		query.setParameter(2, subAcceso);
		return (CodigoMedioSAPBPSLocal)(query.getSingleResult());
	}

}
