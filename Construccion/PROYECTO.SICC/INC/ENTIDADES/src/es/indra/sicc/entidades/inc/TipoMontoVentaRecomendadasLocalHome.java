package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.TipoMontoVentaRecomendadasLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class TipoMontoVentaRecomendadasLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public TipoMontoVentaRecomendadasLocal create() throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_TMVR_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		TipoMontoVentaRecomendadasLocal local = new TipoMontoVentaRecomendadasLocal(oid);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(TipoMontoVentaRecomendadasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(TipoMontoVentaRecomendadasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public TipoMontoVentaRecomendadasLocal findByPrimaryKey(Long  oid) {
		TipoMontoVentaRecomendadasLocal local = (TipoMontoVentaRecomendadasLocal)em.find(TipoMontoVentaRecomendadasLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("TipoMontoVentaRecomendadasLocal.FindAll");
                    return query.getResultList();
            }

}
