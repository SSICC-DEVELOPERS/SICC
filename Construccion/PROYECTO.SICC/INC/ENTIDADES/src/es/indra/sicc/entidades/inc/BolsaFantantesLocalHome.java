package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;
import java.sql.Timestamp;

import es.indra.sicc.entidades.inc.BolsaFantantesLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class BolsaFantantesLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public BolsaFantantesLocal create(Long num_unid_falt, Timestamp fec_alta, Long sopo_oid_soli_posi) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_BOFA_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		BolsaFantantesLocal local = new BolsaFantantesLocal(oid, num_unid_falt, fec_alta, sopo_oid_soli_posi);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(BolsaFantantesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(BolsaFantantesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public BolsaFantantesLocal findByPrimaryKey(Long  oid) {
		BolsaFantantesLocal local = (BolsaFantantesLocal)em.find(BolsaFantantesLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public BolsaFantantesLocal findByUK(Long posicion) {
		Query query=em.createNamedQuery("BolsaFantantesLocal.FindByUK");
		
		query.setParameter(1, posicion);

		return (BolsaFantantesLocal)(query.getSingleResult());
	}

        public Collection findAll() {
                    Query query = em.createNamedQuery("BolsaFantantesLocal.FindAll");
                    return query.getResultList();
            }

}
