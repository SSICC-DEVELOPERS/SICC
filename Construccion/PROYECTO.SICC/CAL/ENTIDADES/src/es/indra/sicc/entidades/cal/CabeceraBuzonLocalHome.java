package es.indra.sicc.entidades.cal;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.cal.CabeceraBuzonLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class CabeceraBuzonLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cal");
	private EntityManager em = emf.createEntityManager();

	public CabeceraBuzonLocal create(String cod_buzo, String cod_usua, String val_desc_cabe_buzo, Long pais_oid_pais) throws MareException {
	        Long oid = SecuenciadorOID.obtenerSiguienteValor("CAL_CABU_SEQ");
                final EntityTransaction et = em.getTransaction();
		et.begin();
		CabeceraBuzonLocal local = new CabeceraBuzonLocal(oid, cod_buzo, cod_usua, val_desc_cabe_buzo, pais_oid_pais);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(CabeceraBuzonLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(CabeceraBuzonLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public CabeceraBuzonLocal findByPrimaryKey(Long  oid) {
		CabeceraBuzonLocal local = (CabeceraBuzonLocal)em.find(CabeceraBuzonLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}
    public Collection findAll() {
        Query query=em.createNamedQuery("CabeceraBuzonLocal.FindAll");
        return query.getResultList();
    }

	
}
