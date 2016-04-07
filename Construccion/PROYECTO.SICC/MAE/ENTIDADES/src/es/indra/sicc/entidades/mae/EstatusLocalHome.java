package es.indra.sicc.entidades.mae;	

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mae.EstatusLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class EstatusLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mae");
	private EntityManager em = emf.createEntityManager();

	public EstatusLocal create(String codEstaProd, Long paisOidPais) throws MareException {
            Long oid = SecuenciadorOID.obtenerSiguienteValor("MAE_MEUD_SEQ");
            final EntityTransaction et = em.getTransaction();
            et.begin();
            EstatusLocal local = new EstatusLocal(oid, codEstaProd, paisOidPais);
            em.persist(local);
            et.commit();
            return local;
	}
	
	public void remove(EstatusLocal local) {
            final EntityTransaction et = em.getTransaction();
            et.begin();
            em.remove(local);
            et.commit();
	}
	
	public void merge(EstatusLocal local) {
            final EntityTransaction et = em.getTransaction();
            et.begin();
            em.merge(local);
            et.commit();
	}
	
	public EstatusLocal findByPrimaryKey(Long  oid) {
            EstatusLocal local = em.find(EstatusLocal.class, oid);
            if (local==null) throw new NoResultException();
            return local;
	}

	
	public Collection findAll() {
            Query query=em.createNamedQuery("EstatusLocal.FindAll");
            return query.getResultList();
	}

	public EstatusLocal findByUk(Long oidPais,String codigoEstatus) {
            Query query=em.createNamedQuery("EstatusLocal.FindByUk");
            query.setParameter(1, oidPais);
            query.setParameter(2, codigoEstatus);
            return (EstatusLocal)(query.getSingleResult());
	}

}
