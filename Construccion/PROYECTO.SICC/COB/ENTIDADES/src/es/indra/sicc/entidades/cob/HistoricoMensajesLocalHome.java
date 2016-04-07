package es.indra.sicc.entidades.cob;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.cob.HistoricoMensajesLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class HistoricoMensajesLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cob");
	private EntityManager em = emf.createEntityManager();

	public HistoricoMensajesLocal create(Long idLote, Long sociedad, Long periodo, Long buzonMensajes, Long etapaDeuda, Long usuarioCobranza) throws MareException {
		final EntityTransaction et = em.getTransaction();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("COB_HIME_SEQ");
		et.begin();
		HistoricoMensajesLocal local = new HistoricoMensajesLocal(oid, idLote, sociedad, periodo, buzonMensajes, etapaDeuda, usuarioCobranza);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(HistoricoMensajesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(HistoricoMensajesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public HistoricoMensajesLocal findByPrimaryKey(Long  oid) {
		HistoricoMensajesLocal local = (HistoricoMensajesLocal)em.find(HistoricoMensajesLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
            Query query=em.createNamedQuery("HistoricoMensajesLocal.FindAll");          
            return query.getResultList();
        }

}
