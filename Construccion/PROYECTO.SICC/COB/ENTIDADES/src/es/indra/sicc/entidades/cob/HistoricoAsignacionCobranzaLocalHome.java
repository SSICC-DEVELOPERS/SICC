package es.indra.sicc.entidades.cob;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.cob.HistoricoAsignacionCobranzaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class HistoricoAsignacionCobranzaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cob");
	private EntityManager em = emf.createEntityManager();

	public HistoricoAsignacionCobranzaLocal create(Long ordenHistorico, Long cliente, Long periodo, Long pais, Long sociedad, Long tipoCargo, Long unidadAdministrativaCliente, Long usuario, Long idCartera, Long etapaDeuda) throws MareException {
		final EntityTransaction et = em.getTransaction();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("COB_HACO_SEQ");
		et.begin();
		HistoricoAsignacionCobranzaLocal local = new HistoricoAsignacionCobranzaLocal(oid, ordenHistorico, cliente, periodo, pais, sociedad, tipoCargo, unidadAdministrativaCliente, usuario, idCartera, etapaDeuda);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(HistoricoAsignacionCobranzaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(HistoricoAsignacionCobranzaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public HistoricoAsignacionCobranzaLocal findByPrimaryKey(Long  oid) {
		HistoricoAsignacionCobranzaLocal local = (HistoricoAsignacionCobranzaLocal)em.find(HistoricoAsignacionCobranzaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
            Query query=em.createNamedQuery("HistoricoAsignacionCobranzaLocal.FindAll");          
            return query.getResultList();
        }
}
