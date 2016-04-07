package es.indra.sicc.entidades.intsys;


import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.intsys.EstadoLlamadaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;


public class EstadoLlamadaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-intsys");
	private EntityManager em = emf.createEntityManager();

	public EstadoLlamadaLocal create(Long usuarioCobranzas, Long tipoCargo, Long subTipoCliente, Long etapasDeuda, Long cliente, Long periodo) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INT_IELL_SEQ");
                EstadoLlamadaLocal local = new EstadoLlamadaLocal(oid, usuarioCobranzas, tipoCargo, subTipoCliente, etapasDeuda, cliente, periodo);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(EstadoLlamadaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(EstadoLlamadaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public EstadoLlamadaLocal findByPrimaryKey(Long  oid) {
		EstadoLlamadaLocal local = em.find(EstadoLlamadaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("EstadoLlamadaLocal.FindAll");
		return query.getResultList();
	}

	public EstadoLlamadaLocal findByUK(Long identificador) {
		Query query=em.createNamedQuery("EstadoLlamadaLocal.FindByUK");
		query.setParameter(1, identificador);
		return (EstadoLlamadaLocal)(query.getSingleResult());
	}

}
