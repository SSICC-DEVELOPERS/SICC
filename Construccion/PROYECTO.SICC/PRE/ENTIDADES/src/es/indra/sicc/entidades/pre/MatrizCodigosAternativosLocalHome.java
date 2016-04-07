package es.indra.sicc.entidades.pre;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.pre.MatrizCodigosAternativosLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class MatrizCodigosAternativosLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-pre");
	private EntityManager em = emf.createEntityManager();

	public MatrizCodigosAternativosLocal create(Long mafa_oid_cod_ppal, Long mafa_oid_cod_alte, Long num_orde, Boolean ind_mens) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("PRE_MTCA_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		MatrizCodigosAternativosLocal local = new MatrizCodigosAternativosLocal(oid, mafa_oid_cod_ppal, mafa_oid_cod_alte, num_orde, ind_mens);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(MatrizCodigosAternativosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(MatrizCodigosAternativosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public MatrizCodigosAternativosLocal findByPrimaryKey(Long  oid) {
		MatrizCodigosAternativosLocal local = (MatrizCodigosAternativosLocal)em.find(MatrizCodigosAternativosLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findByOidPpal(Long oidCodPpal) {
		Query query=em.createNamedQuery("MatrizCodigosAternativosLocal.FindByOidPpal");
		
		query.setParameter(1, oidCodPpal);

		return query.getResultList();
	}

	public Collection findByOidAlte(Long oidCodAlte) {
		Query query=em.createNamedQuery("MatrizCodigosAternativosLocal.FindByOidAlte");
		
		query.setParameter(1, oidCodAlte);

		return query.getResultList();
	}

}
