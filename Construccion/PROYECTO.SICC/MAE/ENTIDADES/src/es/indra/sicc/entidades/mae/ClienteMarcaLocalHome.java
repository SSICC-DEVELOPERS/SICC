package es.indra.sicc.entidades.mae;	

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mae.ClienteMarcaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.sql.Date;

public class ClienteMarcaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mae");
	private EntityManager em = emf.createEntityManager();

	public ClienteMarcaLocal create(Long clie_oid_clie, Long marc_oid_marc, Long ind_ppal, Date fec_ulti_actu) throws MareException {
            Long oid = SecuenciadorOID.obtenerSiguienteValor("MAE_CLMR_SEQ");
            final EntityTransaction et = em.getTransaction();
            et.begin();
            ClienteMarcaLocal local = new ClienteMarcaLocal(oid, clie_oid_clie, marc_oid_marc, ind_ppal, fec_ulti_actu);
            em.persist(local);
            et.commit();
            return local;
	}
	
	public void remove(ClienteMarcaLocal local) {
            final EntityTransaction et = em.getTransaction();
            et.begin();
            em.remove(local);
            et.commit();
	}
	
	public void merge(ClienteMarcaLocal local) {
            final EntityTransaction et = em.getTransaction();
            et.begin();
            em.merge(local);
            et.commit();
	}
	
	public ClienteMarcaLocal findByPrimaryKey(Long  oid) {
            ClienteMarcaLocal local = em.find(ClienteMarcaLocal.class, oid);
            if (local==null) throw new NoResultException();
            return local;
	}

	
	public ClienteMarcaLocal findByUK(Long cliente,Long marca) {
            Query query=em.createNamedQuery("ClienteMarcaLocal.FindByUK");
            query.setParameter(1, cliente);
            query.setParameter(2, marca);
            return (ClienteMarcaLocal)(query.getSingleResult());
	}

        public Collection findAll(Long cliente,Long marca) {
            Query query=em.createNamedQuery("ClienteMarcaLocal.FindAll");
            return query.getResultList();
        }
    
}
