package es.indra.sicc.entidades.pre;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.pre.MatrizEstadisticaCampanyaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class MatrizEstadisticaCampanyaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-pre");
	private EntityManager em = emf.createEntityManager();
    
	public MatrizEstadisticaCampanyaLocal create(Long cabecera) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("PRE_MECA_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		MatrizEstadisticaCampanyaLocal local = new MatrizEstadisticaCampanyaLocal(oid, cabecera);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(MatrizEstadisticaCampanyaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(MatrizEstadisticaCampanyaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public MatrizEstadisticaCampanyaLocal findByPrimaryKey(Long  oid) {
		MatrizEstadisticaCampanyaLocal local = (MatrizEstadisticaCampanyaLocal)em.find(MatrizEstadisticaCampanyaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("MatrizEstadisticaCampanyaLocal.FindAll");
		
		return query.getResultList();
	}

	public MatrizEstadisticaCampanyaLocal findByUK(Long cabeceraMF) {
		Query query=em.createNamedQuery("MatrizEstadisticaCampanyaLocal.FindByUK");
		
		query.setParameter(1, cabeceraMF);

		return (MatrizEstadisticaCampanyaLocal)(query.getSingleResult());
	}

}
