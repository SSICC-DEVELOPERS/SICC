package es.indra.sicc.entidades.bel;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.bel.RegistroAbastecimientoDetalleLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class RegistroAbastecimientoDetalleLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-bel");
	private EntityManager em = emf.createEntityManager();

	public RegistroAbastecimientoDetalleLocal create(Long registroAbastecimientoCabecera, Long producto, Integer numeroLinea) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("BEL_RABD_SEQ");
                RegistroAbastecimientoDetalleLocal local = new RegistroAbastecimientoDetalleLocal(oid, registroAbastecimientoCabecera, producto, numeroLinea);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(RegistroAbastecimientoDetalleLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(RegistroAbastecimientoDetalleLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public RegistroAbastecimientoDetalleLocal findByPrimaryKey(Long  oid) {
		RegistroAbastecimientoDetalleLocal local = (RegistroAbastecimientoDetalleLocal)em.find(RegistroAbastecimientoDetalleLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("RegistroAbastecimientoDetalleLocal.FindAll");
		return query.getResultList();
	}

}
