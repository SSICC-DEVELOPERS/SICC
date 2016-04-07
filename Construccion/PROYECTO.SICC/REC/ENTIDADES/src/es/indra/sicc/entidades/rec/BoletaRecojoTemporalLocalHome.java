package es.indra.sicc.entidades.rec;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.rec.BoletaRecojoTemporalLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.sql.Date;

public class BoletaRecojoTemporalLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-rec");
	private EntityManager em = emf.createEntityManager();

	public BoletaRecojoTemporalLocal create(Long numBole, Date fecCapt, String valUsua, Long numOrdeIngr, Long paisOidPais, Long erecOidEstaReco) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("REC_BRTE_SEQ");
                final EntityTransaction et = em.getTransaction();
		et.begin();
	        BoletaRecojoTemporalLocal local = new BoletaRecojoTemporalLocal(oid, numBole, fecCapt, valUsua, numOrdeIngr, paisOidPais, erecOidEstaReco);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(BoletaRecojoTemporalLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(BoletaRecojoTemporalLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public BoletaRecojoTemporalLocal findByPrimaryKey(Long  oid) {
		BoletaRecojoTemporalLocal local = (BoletaRecojoTemporalLocal)em.find(BoletaRecojoTemporalLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("BoletaRecojoTemporalLocal.FindAll");
		
		return query.getResultList();
	}

}
