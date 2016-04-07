package es.indra.sicc.entidades.pre;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.pre.MatrizFacturacionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class MatrizFacturacionLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-pre");
	private EntityManager em = emf.createEntityManager();

	public MatrizFacturacionLocal create(Long mfca_oid_cabe, Long ofde_oid_deta_ofer) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("PRE_MAFA_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		MatrizFacturacionLocal local = new MatrizFacturacionLocal(oid, mfca_oid_cabe, ofde_oid_deta_ofer);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(MatrizFacturacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(MatrizFacturacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public MatrizFacturacionLocal findByPrimaryKey(Long  oid) {
		MatrizFacturacionLocal local = (MatrizFacturacionLocal)em.find(MatrizFacturacionLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findByOidCabecera(Long oidCabe) {
		Query query=em.createNamedQuery("MatrizFacturacionLocal.FindByOidCabecera");
		
		query.setParameter(1, oidCabe);

		return query.getResultList();
	}

	public MatrizFacturacionLocal findByOidDetaOfer(Long oidDetaOfer) {
		Query query=em.createNamedQuery("MatrizFacturacionLocal.FindByOidDetaOfer");
		
		query.setParameter(1, oidDetaOfer);

		return (MatrizFacturacionLocal)(query.getSingleResult());
	}

	public MatrizFacturacionLocal findByUK(Long oidCabe,Long oidDetaOfer) {
		Query query=em.createNamedQuery("MatrizFacturacionLocal.FindByUK");
		
		query.setParameter(1, oidCabe);

		query.setParameter(2, oidDetaOfer);

		return (MatrizFacturacionLocal)(query.getSingleResult());
	}

}
