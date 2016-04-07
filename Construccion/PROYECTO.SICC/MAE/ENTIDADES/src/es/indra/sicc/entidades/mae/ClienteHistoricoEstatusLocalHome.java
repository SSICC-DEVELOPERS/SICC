package es.indra.sicc.entidades.mae;	

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mae.ClienteHistoricoEstatusLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ClienteHistoricoEstatusLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mae");
	private EntityManager em = emf.createEntityManager();

	public ClienteHistoricoEstatusLocal create(Long cliente, Long estatus) throws MareException {
            Long oid = SecuenciadorOID.obtenerSiguienteValor("MAE_CLHE_SEQ");
            final EntityTransaction et = em.getTransaction();
            et.begin();
            ClienteHistoricoEstatusLocal local = new ClienteHistoricoEstatusLocal(oid, cliente, estatus);
            em.persist(local);
            et.commit();
            return local;
	}
	
        public ClienteHistoricoEstatusLocal create(Long cliente, Long estatus, Long periodoInicio, Long periodoFin) throws MareException {
            Long oid = SecuenciadorOID.obtenerSiguienteValor("MAE_CLHE_SEQ");
            final EntityTransaction et = em.getTransaction();
            et.begin();
            ClienteHistoricoEstatusLocal local = new ClienteHistoricoEstatusLocal(oid, cliente, estatus, periodoInicio, periodoFin);
            em.persist(local);
            et.commit();
            return local;
        }
        
	public void remove(ClienteHistoricoEstatusLocal local) {
            final EntityTransaction et = em.getTransaction();
            et.begin();
            em.remove(local);
            et.commit();
	}
	
	public void merge(ClienteHistoricoEstatusLocal local) {
            final EntityTransaction et = em.getTransaction();
            et.begin();
            em.merge(local);
            et.commit();
	}
	
	public ClienteHistoricoEstatusLocal findByPrimaryKey(Long  oid) {
            ClienteHistoricoEstatusLocal local = em.find(ClienteHistoricoEstatusLocal.class, oid);
            if (local==null) throw new NoResultException();
            return local;
	}

	
	public ClienteHistoricoEstatusLocal findByClienteEstatus(Long cliente,Long estatus) {
            Query query=em.createNamedQuery("ClienteHistoricoEstatusLocal.FindByClienteEstatus");
            query.setParameter(1, cliente);
            query.setParameter(2, estatus);
            return (ClienteHistoricoEstatusLocal)(query.getSingleResult());
	}

	public Collection findUltimoHistorico(Long cliente) {
            Query query=em.createNamedQuery("ClienteHistoricoEstatusLocal.FindUltimoHistorico");
            query.setParameter(1, cliente);
            return query.getResultList();
	}

	public ClienteHistoricoEstatusLocal findByUK(Long cliente,Long periodo) {
            Query query=em.createNamedQuery("ClienteHistoricoEstatusLocal.FindByUK");
            query.setParameter(1, cliente);
            query.setParameter(2, periodo);
            return (ClienteHistoricoEstatusLocal)(query.getSingleResult());
	}

	public ClienteHistoricoEstatusLocal findHistoricoPorPeriodoFin(Long cliente,Long periodo) {
            Query query=em.createNamedQuery("ClienteHistoricoEstatusLocal.FindHistoricoPorPeriodoFin");
            query.setParameter(1, cliente);
            query.setParameter(2, periodo);
            return (ClienteHistoricoEstatusLocal)(query.getSingleResult());
	}

        public Collection findAll() {
            Query query=em.createNamedQuery("ClienteHistoricoEstatusLocal.FindAll");
            return query.getResultList();
        }

}
