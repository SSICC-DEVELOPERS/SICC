package es.indra.sicc.entidades.pre;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.pre.MatrizEstadisticaCodigoVentaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class MatrizEstadisticaCodigoVentaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-pre");
	private EntityManager em = emf.createEntityManager();

	public MatrizEstadisticaCodigoVentaLocal create(Long matrizFacturacion) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("PRE_MECV_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		MatrizEstadisticaCodigoVentaLocal local = new MatrizEstadisticaCodigoVentaLocal(oid, matrizFacturacion);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(MatrizEstadisticaCodigoVentaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(MatrizEstadisticaCodigoVentaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public MatrizEstadisticaCodigoVentaLocal findByPrimaryKey(Long  oid) {
		MatrizEstadisticaCodigoVentaLocal local = (MatrizEstadisticaCodigoVentaLocal)em.find(MatrizEstadisticaCodigoVentaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("MatrizEstadisticaCodigoVentaLocal.FindAll");
		
		return query.getResultList();
	}

	public MatrizEstadisticaCodigoVentaLocal findByUK(Long matrizFacturacion) {
		Query query=em.createNamedQuery("MatrizEstadisticaCodigoVentaLocal.FindByUK");
		
		query.setParameter(1, matrizFacturacion);

		return (MatrizEstadisticaCodigoVentaLocal)(query.getSingleResult());
	}

}
