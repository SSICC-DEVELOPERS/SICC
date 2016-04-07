package es.indra.sicc.entidades.pre;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.pre.MatrizEstadisticaDevolucionesLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class MatrizEstadisticaDevolucionesLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-pre");
	private EntityManager em = emf.createEntityManager();

	public MatrizEstadisticaDevolucionesLocal create(Long oidProducto, Long oidTipoOperacion, Long oidPeriodo, Long oidMotivoDevolucion) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("PRE_MEPD_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		MatrizEstadisticaDevolucionesLocal local = new MatrizEstadisticaDevolucionesLocal(oid, oidProducto, oidTipoOperacion, oidPeriodo, oidMotivoDevolucion);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(MatrizEstadisticaDevolucionesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(MatrizEstadisticaDevolucionesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public MatrizEstadisticaDevolucionesLocal findByPrimaryKey(Long  oid) {
		MatrizEstadisticaDevolucionesLocal local = (MatrizEstadisticaDevolucionesLocal)em.find(MatrizEstadisticaDevolucionesLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("MatrizEstadisticaDevolucionesLocal.FindAll");
		
		return query.getResultList();
	}

	public Collection findByPeriodo(Long oidPeriodo) {
		Query query=em.createNamedQuery("MatrizEstadisticaDevolucionesLocal.FindByPeriodo");
		
		query.setParameter(1, oidPeriodo);

		return query.getResultList();
	}

}
