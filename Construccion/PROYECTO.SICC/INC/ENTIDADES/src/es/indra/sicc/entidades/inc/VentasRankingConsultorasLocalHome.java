package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.VentasRankingConsultorasLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class VentasRankingConsultorasLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public VentasRankingConsultorasLocal create(Double valCant, Long copaOidParaGral, Long vvrcOidVariVentRankConc, Long clieOidClie) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_VERC_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		VentasRankingConsultorasLocal local = new VentasRankingConsultorasLocal(oid, valCant, copaOidParaGral, vvrcOidVariVentRankConc, clieOidClie);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(VentasRankingConsultorasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(VentasRankingConsultorasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public VentasRankingConsultorasLocal findByPrimaryKey(Long  oid) {
		VentasRankingConsultorasLocal local = (VentasRankingConsultorasLocal)em.find(VentasRankingConsultorasLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("VentasRankingConsultorasLocal.FindAll");
                    return query.getResultList();
            }

}
