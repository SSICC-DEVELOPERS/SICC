package es.indra.sicc.entidades.mae;	

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mae.ClienteDatosAdicionalesLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.sql.Date;

public class ClienteDatosAdicionalesLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mae");
	private EntityManager em = emf.createEntityManager();

	public ClienteDatosAdicionalesLocal create(Long clie_oid_clie, Long esta_oid_esta_clie, Date fec_ulti_actu)
                throws MareException {
            
            Long oid = SecuenciadorOID.obtenerSiguienteValor("MAE_CLDA_SEQ");
            final EntityTransaction et = em.getTransaction();
            et.begin();
            ClienteDatosAdicionalesLocal local = new ClienteDatosAdicionalesLocal(oid, clie_oid_clie, esta_oid_esta_clie, fec_ulti_actu);
            em.persist(local);
            et.commit();
            return local;
	}
	
	public void remove(ClienteDatosAdicionalesLocal local) {
            final EntityTransaction et = em.getTransaction();
            et.begin();
            em.remove(local);
            et.commit();
	}
	
	public void merge(ClienteDatosAdicionalesLocal local) {
            final EntityTransaction et = em.getTransaction();
            et.begin();
            em.merge(local);
            et.commit();
	}
	
	public ClienteDatosAdicionalesLocal findByPrimaryKey(Long  oid) {
            ClienteDatosAdicionalesLocal local = em.find(ClienteDatosAdicionalesLocal.class, oid);
            if (local==null) throw new NoResultException();
            return local;
	}

	
	public ClienteDatosAdicionalesLocal findByCliente(Long cliente) {
            Query query=em.createNamedQuery("ClienteDatosAdicionalesLocal.FindByCliente");
            query.setParameter(1, cliente);
            return (ClienteDatosAdicionalesLocal)(query.getSingleResult());
	}

        public Collection findAll() {
            Query query=em.createNamedQuery("ClienteDatosAdicionalesLocal.FindAll");
            return query.getResultList();
        }
}
