package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.PagoMonetariosLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class PagoMonetariosLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public PagoMonetariosLocal create(Long numPago, Double valPorcPrem, Long perdOidPeri, Long prmoOidPremMone) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_PRMO_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		PagoMonetariosLocal local = new PagoMonetariosLocal(oid, numPago, valPorcPrem, perdOidPeri, prmoOidPremMone);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(PagoMonetariosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(PagoMonetariosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public PagoMonetariosLocal findByPrimaryKey(Long  oid) {
		PagoMonetariosLocal local = (PagoMonetariosLocal)em.find(PagoMonetariosLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
                    Query query = em.createNamedQuery("PagoMonetariosLocal.FindAll");
                    return query.getResultList();
            }

	public Collection findByPremioMonetario(Long premioMonetario) {
		Query query=em.createNamedQuery("PagoMonetariosLocal.FindByPremioMonetario");
		
		query.setParameter(1, premioMonetario);

	    return query.getResultList();
	}

}
