package es.indra.sicc.entidades.mae;	

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mae.ClienteComunicacionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.sql.Date;

public class ClienteComunicacionLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mae");
	private EntityManager em = emf.createEntityManager();

	public ClienteComunicacionLocal create(Long clie_oid_clie, Long ticm_oid_tipo_comu, Date fec_ulti_actu)
                throws MareException {
            
            Long oid = SecuenciadorOID.obtenerSiguienteValor("MAE_CLCO_SEQ");
            final EntityTransaction et = em.getTransaction();
            et.begin();
            ClienteComunicacionLocal local = new ClienteComunicacionLocal(oid, clie_oid_clie, ticm_oid_tipo_comu, fec_ulti_actu);
            em.persist(local);
            et.commit();
            return local;
	}
	
	public void remove(ClienteComunicacionLocal local) {
            final EntityTransaction et = em.getTransaction();
            et.begin();
            em.remove(local);
            et.commit();
	}
	
	public void merge(ClienteComunicacionLocal local) {
            final EntityTransaction et = em.getTransaction();
            et.begin();
            em.merge(local);
            et.commit();
	}
	
	public ClienteComunicacionLocal findByPrimaryKey(Long  oid) {
            ClienteComunicacionLocal local = em.find(ClienteComunicacionLocal.class, oid);
            if (local==null) throw new NoResultException();
            return local;
	}

	public ClienteComunicacionLocal findByUK(Long oidCliente,Long oidTipoComunicacion) {
            Query query=em.createNamedQuery("ClienteComunicacionLocal.FindByUK");
            query.setParameter(1, oidCliente);
            query.setParameter(2, oidTipoComunicacion);
            return (ClienteComunicacionLocal)(query.getSingleResult());
	}

        public Collection findAll() {
            Query query=em.createNamedQuery("ClienteComunicacionLocal.FindAll");
            return query.getResultList();
        }
}
