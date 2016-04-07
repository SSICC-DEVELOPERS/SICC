package es.indra.sicc.entidades.pre;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.pre.CabeceraMFLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class CabeceraMFLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-pre");
	private EntityManager em = emf.createEntityManager();
    
	public CabeceraMFLocal create(Long perd_oid_peri, Long num_pedi_esti, Long num_unid_esti, Long num_clie_esti, Long tota_mont_vent_neta) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("PRE_MFCA_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		CabeceraMFLocal local = new CabeceraMFLocal(oid, perd_oid_peri, num_pedi_esti, num_unid_esti, num_clie_esti, tota_mont_vent_neta);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(CabeceraMFLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(CabeceraMFLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public CabeceraMFLocal findByPrimaryKey(Long  oid) {
		CabeceraMFLocal local = (CabeceraMFLocal)em.find(CabeceraMFLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public CabeceraMFLocal findByUK(Long oidPeri) {
		Query query=em.createNamedQuery("CabeceraMFLocal.FindByUK");
		
		query.setParameter(1, oidPeri);

		return (CabeceraMFLocal)(query.getSingleResult());
	}

}
