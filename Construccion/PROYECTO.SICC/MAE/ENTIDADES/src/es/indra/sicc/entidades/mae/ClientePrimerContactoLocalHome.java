package es.indra.sicc.entidades.mae;	

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mae.ClientePrimerContactoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.sql.Date;

public class ClientePrimerContactoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mae");
	private EntityManager em = emf.createEntityManager();

	public ClientePrimerContactoLocal create(Long clie_oid_clie, Long ctsu_clie_cont, Date fec_ulti_actu) throws MareException {
            Long oid = SecuenciadorOID.obtenerSiguienteValor("MAE_CPRC_SEQ");
            final EntityTransaction et = em.getTransaction();
            et.begin();
            ClientePrimerContactoLocal local = new ClientePrimerContactoLocal(oid, clie_oid_clie, ctsu_clie_cont, fec_ulti_actu);
            em.persist(local);
            et.commit();
            return local;
	}
	
	public void remove(ClientePrimerContactoLocal local) {
            final EntityTransaction et = em.getTransaction();
            et.begin();
            em.remove(local);
            et.commit();
	}
	
	public void merge(ClientePrimerContactoLocal local) {
            final EntityTransaction et = em.getTransaction();
            et.begin();
            em.merge(local);
            et.commit();
	}
	
	public ClientePrimerContactoLocal findByPrimaryKey(Long  oid) {
            ClientePrimerContactoLocal local = em.find(ClientePrimerContactoLocal.class, oid);
            if (local==null) throw new NoResultException();
            return local;
	}
        
        public ClientePrimerContactoLocal findByCliente(Long oidCliente) {
            Query query = em.createNamedQuery("ClientePrimerContactoLocal.FindByCliente");
            query.setParameter(1, oidCliente);
            return (ClientePrimerContactoLocal)query.getSingleResult();
        }

	public Collection findAll() {
            Query query = em.createNamedQuery("ClientePrimerContactoLocal.FindAll");
            return query.getResultList();
        }
}
