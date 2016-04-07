package es.indra.sicc.entidades.mae;	

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mae.ClienteIdentificacionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.sql.Date;

public class ClienteIdentificacionLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mae");
	private EntityManager em = emf.createEntityManager();

	public ClienteIdentificacionLocal create(Long tdoc_oid_tipo_docu, Long clie_oid_clie, String num_docu_iden,
                Long val_iden_docu_prin, Date fec_ulti_actu) throws MareException {
                
            Long oid = SecuenciadorOID.obtenerSiguienteValor("MAE_CLID_SEQ");
            final EntityTransaction et = em.getTransaction();
            et.begin();
            ClienteIdentificacionLocal local = new ClienteIdentificacionLocal(oid, tdoc_oid_tipo_docu, clie_oid_clie, num_docu_iden, val_iden_docu_prin, fec_ulti_actu);
            em.persist(local);
            et.commit();
            return local;
	}
	
	public void remove(ClienteIdentificacionLocal local) {
            final EntityTransaction et = em.getTransaction();
            et.begin();
            em.remove(local);
            et.commit();
	}
	
	public void merge(ClienteIdentificacionLocal local) {
            final EntityTransaction et = em.getTransaction();
            et.begin();
            em.merge(local);
            et.commit();
	}
	
	public ClienteIdentificacionLocal findByPrimaryKey(Long  oid) {
            ClienteIdentificacionLocal local = em.find(ClienteIdentificacionLocal.class, oid);
            if (local==null) throw new NoResultException();
            return local;
	}

	public ClienteIdentificacionLocal findByUK(Long param1) {
            Query query=em.createNamedQuery("ClienteIdentificacionLocal.FindByUK");
            query.setParameter(1, param1);
            return (ClienteIdentificacionLocal)(query.getSingleResult());
	}

        public Collection findAll() {
            Query query=em.createNamedQuery("ClienteIdentificacionLocal.FindAll");
            return query.getResultList();
        }
        
}