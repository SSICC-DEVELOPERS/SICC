package es.indra.sicc.entidades.pre;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.pre.EstrategiaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class EstrategiaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-pre");
	private EntityManager em = emf.createEntityManager();
        
	public EstrategiaLocal create(Long pais_oid_pais, Long ties_oid_tipo_estr, String cod_estr) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("PRE_COES_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		EstrategiaLocal local = new EstrategiaLocal(oid, pais_oid_pais, ties_oid_tipo_estr, cod_estr);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(EstrategiaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(EstrategiaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public EstrategiaLocal findByPrimaryKey(Long  oid) {
		EstrategiaLocal local = (EstrategiaLocal)em.find(EstrategiaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findByOidPais(Long oidPais) {
		Query query=em.createNamedQuery("EstrategiaLocal.FindByOidPais");
		
		query.setParameter(1, oidPais);

		return query.getResultList();
	}

	public EstrategiaLocal findByUK(String codigo,Long oidPais) {
		Query query=em.createNamedQuery("EstrategiaLocal.FindByUK");
		
		query.setParameter(1, codigo);

		query.setParameter(2, oidPais);

		return (EstrategiaLocal)(query.getSingleResult());
	}

}
