package es.indra.sicc.entidades.edu;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.edu.MatrizCursosExigidosLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class MatrizCursosExigidosLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-edu");
	private EntityManager em = emf.createEntityManager();

	public MatrizCursosExigidosLocal create(Long  oidCurs, Long oidCursRequ) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("EDU_MCUR_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		MatrizCursosExigidosLocal local = new MatrizCursosExigidosLocal(oid, oidCurs, oidCursRequ);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(MatrizCursosExigidosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(MatrizCursosExigidosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public MatrizCursosExigidosLocal findByPrimaryKey(Long  oid) {
		MatrizCursosExigidosLocal local = (MatrizCursosExigidosLocal)em.find(MatrizCursosExigidosLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("MatrizCursosExigidosLocal.FindAll");
		
		return query.getResultList();
	}

	public Collection findByCurso(Long curso) {
		Query query=em.createNamedQuery("MatrizCursosExigidosLocal.FindByCurso");
		
		query.setParameter(1, curso);

		return query.getResultList();
	}

}
