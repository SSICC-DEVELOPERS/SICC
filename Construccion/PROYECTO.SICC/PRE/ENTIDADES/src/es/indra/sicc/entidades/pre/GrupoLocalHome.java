package es.indra.sicc.entidades.pre;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.pre.GrupoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class GrupoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-pre");
	private EntityManager em = emf.createEntityManager();

	public GrupoLocal create(Long ofer_oid_ofer, Integer num_grup, Boolean ind_grup) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("PRE_GOFE_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		GrupoLocal local = new GrupoLocal(oid, ofer_oid_ofer, num_grup, ind_grup);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(GrupoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(GrupoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public GrupoLocal findByPrimaryKey(Long  oid) {
		GrupoLocal local = (GrupoLocal)em.find(GrupoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findByOidOferta(Long oidOferta) {
		Query query=em.createNamedQuery("GrupoLocal.FindByOidOferta");
		
		query.setParameter(1, oidOferta);

		return query.getResultList();
	}

}
