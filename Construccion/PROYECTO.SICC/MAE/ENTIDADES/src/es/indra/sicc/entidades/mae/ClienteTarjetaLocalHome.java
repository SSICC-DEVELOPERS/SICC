package es.indra.sicc.entidades.mae;	

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mae.ClienteTarjetaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ClienteTarjetaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mae");
	private EntityManager em = emf.createEntityManager();

	public ClienteTarjetaLocal create(Long clie_oid_clie, Long titr_oid_tipo_tarj) throws MareException {
            Long oid = SecuenciadorOID.obtenerSiguienteValor("MAE_CTAR_SEQ");
            final EntityTransaction et = em.getTransaction();
            et.begin();
            ClienteTarjetaLocal local = new ClienteTarjetaLocal(oid, clie_oid_clie, titr_oid_tipo_tarj);
            em.persist(local);
            et.commit();
            return local;
	}
	
	public void remove(ClienteTarjetaLocal local) {
            final EntityTransaction et = em.getTransaction();
            et.begin();
            em.remove(local);
            et.commit();
	}
	
	public void merge(ClienteTarjetaLocal local) {
            final EntityTransaction et = em.getTransaction();
            et.begin();
            em.merge(local);
            et.commit();
	}
	
	public ClienteTarjetaLocal findByPrimaryKey(Long  oid) {
            ClienteTarjetaLocal local = em.find(ClienteTarjetaLocal.class, oid);
            if (local==null) throw new NoResultException();
            return local;
	}

        public Collection findAll() {
            Query query = em.createNamedQuery("ClienteTarjetaLocal.FindAll");
            return query.getResultList();
        }
}
