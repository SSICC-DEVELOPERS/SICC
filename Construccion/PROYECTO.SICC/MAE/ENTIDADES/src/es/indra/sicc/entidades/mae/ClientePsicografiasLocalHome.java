package es.indra.sicc.entidades.mae;	

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mae.ClientePsicografiasLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ClientePsicografiasLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mae");
	private EntityManager em = emf.createEntityManager();

	public ClientePsicografiasLocal create(Long clie_oid_clie, Long marc_oid_marc, Long tpoid_tipo_perf_psic) throws MareException {
            Long oid = SecuenciadorOID.obtenerSiguienteValor("MAE_PSIC_SEQ");
            final EntityTransaction et = em.getTransaction();
            et.begin();
            ClientePsicografiasLocal local = new ClientePsicografiasLocal(oid, clie_oid_clie, marc_oid_marc, tpoid_tipo_perf_psic);
            em.persist(local);
            et.commit();
            return local;
	}
	
	public void remove(ClientePsicografiasLocal local) {
            final EntityTransaction et = em.getTransaction();
            et.begin();
            em.remove(local);
            et.commit();
	}
	
	public void merge(ClientePsicografiasLocal local) {
            final EntityTransaction et = em.getTransaction();
            et.begin();
            em.merge(local);
            et.commit();
	}
	
	public ClientePsicografiasLocal findByPrimaryKey(Long  oid) {
            ClientePsicografiasLocal local = em.find(ClientePsicografiasLocal.class, oid);
            if (local==null) throw new NoResultException();
            return local;
	}

        public Collection findAll() {
            Query query = em.createNamedQuery("ClientePsicografiasLocal.FindAll");
            return query.getResultList();
        }
}
