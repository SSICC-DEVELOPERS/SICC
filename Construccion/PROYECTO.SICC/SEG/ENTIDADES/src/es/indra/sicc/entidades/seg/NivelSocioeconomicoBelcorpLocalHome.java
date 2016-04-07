package es.indra.sicc.entidades.seg;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.seg.NivelSocioeconomicoBelcorpLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class NivelSocioeconomicoBelcorpLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-seg");
	private EntityManager em = emf.createEntityManager();

	public NivelSocioeconomicoBelcorpLocal create(String cod_nive_soci_econ_belc, String des_nive_soci_econ_belc)
			throws MareException {
		
		Long oid = SecuenciadorOID.obtenerSiguienteValor("SEG_NSEB_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		NivelSocioeconomicoBelcorpLocal local = new NivelSocioeconomicoBelcorpLocal(oid, cod_nive_soci_econ_belc, des_nive_soci_econ_belc);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(NivelSocioeconomicoBelcorpLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(NivelSocioeconomicoBelcorpLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public NivelSocioeconomicoBelcorpLocal findByPrimaryKey(Long  oid) {
		NivelSocioeconomicoBelcorpLocal local = em.find(NivelSocioeconomicoBelcorpLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}
	
	public NivelSocioeconomicoBelcorpLocal findByUK(String codigoNSEBelcorp) {
		Query query = em.createNamedQuery("NivelSocioeconomicoBelcorpLocal.FindByUK");
		query.setParameter(1, codigoNSEBelcorp);
		return (NivelSocioeconomicoBelcorpLocal)query.getSingleResult();
	}

	public Collection findAll(String codigoNSEBelcorp) {
		Query query = em.createNamedQuery("NivelSocioeconomicoBelcorpLocal.FindAll");
		return query.getResultList();
	}
	
}
