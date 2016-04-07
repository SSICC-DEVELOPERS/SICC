package es.indra.sicc.entidades.cob;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.cob.HistoricoComisionesCobranzaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class HistoricoComisionesCobranzaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cob");
	private EntityManager em = emf.createEntityManager();

	public HistoricoComisionesCobranzaLocal create(Long idLiquidacion, Long periodo, Long usuario, Long metodoLiquidacion, Long etapaDeuda) throws MareException {
		final EntityTransaction et = em.getTransaction();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("COB_HICC_SEQ");
		et.begin();
		HistoricoComisionesCobranzaLocal local = new HistoricoComisionesCobranzaLocal(oid, idLiquidacion, periodo, usuario, metodoLiquidacion, etapaDeuda);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(HistoricoComisionesCobranzaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(HistoricoComisionesCobranzaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public HistoricoComisionesCobranzaLocal findByPrimaryKey(Long  oid) {
		HistoricoComisionesCobranzaLocal local = (HistoricoComisionesCobranzaLocal)em.find(HistoricoComisionesCobranzaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
            Query query=em.createNamedQuery("HistoricoComisionesCobranzaLocal.FindAll");          
            return query.getResultList();
        }

}
