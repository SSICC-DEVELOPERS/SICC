package es.indra.sicc.entidades.ccc;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;

import es.indra.sicc.entidades.ccc.ProcesosLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ProcesosLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ccc");
	private EntityManager em = emf.createEntityManager();

	public ProcesosLocal create(Long pais_oid_pais, String cod_proc, String des_proc) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CCC_CCPR_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ProcesosLocal local = new ProcesosLocal(oid, pais_oid_pais, cod_proc, des_proc);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ProcesosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ProcesosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ProcesosLocal findByPrimaryKey(Long  oid) {
		ProcesosLocal local = (ProcesosLocal)em.find(ProcesosLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public ProcesosLocal findByUk(Long oidPais,String codProceso) {
		Query query=em.createNamedQuery("ProcesosLocal.FindByUk");
		
		query.setParameter(1, oidPais);

		query.setParameter(2, codProceso);

		return (ProcesosLocal)(query.getSingleResult());
	}

}
