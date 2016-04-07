package es.indra.sicc.entidades.pre;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.pre.CatalogoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class CatalogoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-pre");
	private EntityManager em = emf.createEntityManager();
    
	public CatalogoLocal create(Integer cod_cata, String des_cata, Long oidPais) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("PRE_CATO_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		CatalogoLocal local = new CatalogoLocal(oid, cod_cata, des_cata, oidPais);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(CatalogoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(CatalogoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public CatalogoLocal findByPrimaryKey(Long  oid) {
		CatalogoLocal local = (CatalogoLocal)em.find(CatalogoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public CatalogoLocal findByUK(Long oidPais,Integer codigoCatalogo) {
		Query query=em.createNamedQuery("CatalogoLocal.FindByUK");
		
		query.setParameter(1, oidPais);

		query.setParameter(2, codigoCatalogo);

		return (CatalogoLocal)(query.getSingleResult());
	}

}
