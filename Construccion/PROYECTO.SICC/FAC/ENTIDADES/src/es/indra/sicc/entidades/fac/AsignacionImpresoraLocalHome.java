package es.indra.sicc.entidades.fac;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.fac.AsignacionImpresoraLocal;
import es.indra.sicc.util.SecuenciadorOID;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class AsignacionImpresoraLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-fac");
	private EntityManager em = emf.createEntityManager();

	public AsignacionImpresoraLocal create(Long impresoraVirtual, Long subacceso, Long formulario) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("FAC_ASIM_SEQ");
		AsignacionImpresoraLocal local = new AsignacionImpresoraLocal(oid, impresoraVirtual, subacceso, formulario);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(AsignacionImpresoraLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(AsignacionImpresoraLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public AsignacionImpresoraLocal findByPrimaryKey(Long  oid) {
		AsignacionImpresoraLocal local = (AsignacionImpresoraLocal)em.find(AsignacionImpresoraLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("AsignacionImpresoraLocal.FindAll");
		return (query.getResultList());
	}

	public AsignacionImpresoraLocal findByUK(Long param1,Long param2) {
		Query query=em.createNamedQuery("AsignacionImpresoraLocal.FindByUK");
		query.setParameter(1, param1);
		query.setParameter(2, param2);
		return (AsignacionImpresoraLocal)(query.getSingleResult());
	}

}
