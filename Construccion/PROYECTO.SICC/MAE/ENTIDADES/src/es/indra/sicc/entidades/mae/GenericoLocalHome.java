package es.indra.sicc.entidades.mae;	

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mae.GenericoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class GenericoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mae");
	private EntityManager em = emf.createEntityManager();

	public GenericoLocal create(Long paisOidPais, String codGene) throws MareException {
            Long oid = SecuenciadorOID.obtenerSiguienteValor("MAE_GENE_SEQ");
            final EntityTransaction et = em.getTransaction();
            et.begin();
            GenericoLocal local = new GenericoLocal(oid, paisOidPais, codGene);
            em.persist(local);
            et.commit();
            return local;
	}
	
	public void remove(GenericoLocal local) {
            final EntityTransaction et = em.getTransaction();
            et.begin();
            em.remove(local);
            et.commit();
	}
	
	public void merge(GenericoLocal local) {
            final EntityTransaction et = em.getTransaction();
            et.begin();
            em.merge(local);
            et.commit();
	}
	
	public GenericoLocal findByPrimaryKey(Long  oid) {
            GenericoLocal local = em.find(GenericoLocal.class, oid);
            if (local==null) throw new NoResultException();
            return local;
	}

	
	public Collection findAll() {
            Query query=em.createNamedQuery("GenericoLocal.FindAll");
            return query.getResultList();
	}

	public GenericoLocal findByUk(Long oidPais,String codigoGenerico) {
            Query query=em.createNamedQuery("GenericoLocal.FindByUk");
            query.setParameter(1, oidPais);
            query.setParameter(2, codigoGenerico);
            return (GenericoLocal)(query.getSingleResult());
	}

}
