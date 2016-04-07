package es.indra.sicc.entidades.ccc;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;

import es.indra.sicc.entidades.ccc.TiposAbonoSubprocesoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.util.Collection;

public class TiposAbonoSubprocesoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ccc");
	private EntityManager em = emf.createEntityManager();


	public TiposAbonoSubprocesoLocal create(Long subproceso, Long cuenta, Long tipoAbono) 
                                                                    throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CCC_TASP_SEQ");                                                                    
		final EntityTransaction et = em.getTransaction();
		et.begin();
		TiposAbonoSubprocesoLocal local = new TiposAbonoSubprocesoLocal(oid, subproceso, cuenta, tipoAbono);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(TiposAbonoSubprocesoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(TiposAbonoSubprocesoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public TiposAbonoSubprocesoLocal findByPrimaryKey(Long  oid) {
		TiposAbonoSubprocesoLocal local = (TiposAbonoSubprocesoLocal)em.find(TiposAbonoSubprocesoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findBySubproceso(Long subproceso) {
		Query query=em.createNamedQuery("TiposAbonoSubprocesoLocal.FindBySubproceso");
		
		query.setParameter(1, subproceso);

		return query.getResultList();
	}

	public TiposAbonoSubprocesoLocal findByUK(Long tipoAbono,Long subproceso) {
		Query query=em.createNamedQuery("TiposAbonoSubprocesoLocal.FindByUK");
		
		query.setParameter(1, tipoAbono);

		query.setParameter(2, subproceso);

		return (TiposAbonoSubprocesoLocal)(query.getSingleResult());
	}

}
