package es.indra.sicc.entidades.com;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;
import java.math.BigDecimal;

import es.indra.sicc.entidades.com.ComisionesCobranzasTipoParticipanteLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ComisionesCobranzasTipoParticipanteLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-com");
	private EntityManager em = emf.createEntityManager();

	public ComisionesCobranzasTipoParticipanteLocal create(Integer nivelTramo, BigDecimal porcentajeRecuperacion, Long cobranza, BigDecimal porcentajeComision) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("COM_CCTP_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ComisionesCobranzasTipoParticipanteLocal local = new ComisionesCobranzasTipoParticipanteLocal(oid, nivelTramo, porcentajeRecuperacion, cobranza, porcentajeComision);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ComisionesCobranzasTipoParticipanteLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ComisionesCobranzasTipoParticipanteLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ComisionesCobranzasTipoParticipanteLocal findByPrimaryKey(Long  oid) {
		ComisionesCobranzasTipoParticipanteLocal local = (ComisionesCobranzasTipoParticipanteLocal)em.find(ComisionesCobranzasTipoParticipanteLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
                Query query=em.createNamedQuery("ComisionesCobranzasTipoParticipanteLocal.FindAll");          
                return query.getResultList();
        }

	public Collection findByCobranza(Long oidCobranza) {
		Query query=em.createNamedQuery("ComisionesCobranzasTipoParticipanteLocal.FindByCobranza");
		
		query.setParameter(1, oidCobranza);

                return query.getResultList();
	}

}
