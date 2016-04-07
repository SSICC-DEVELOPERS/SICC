package es.indra.sicc.entidades.mae;	

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mae.ClienteTipoSubTipoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.sql.Date;

public class ClienteTipoSubTipoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mae");
	private EntityManager em = emf.createEntityManager();

	public ClienteTipoSubTipoLocal create(Long clie_oid_clie, Long ticl_oid_tipo_clie, Long sbti_oid_subt_clie, Long ind_ppal, Date fec_ulti_actu)
                throws MareException {
            Long oid = SecuenciadorOID.obtenerSiguienteValor("MAE_CTSU_SEQ");
            final EntityTransaction et = em.getTransaction();
            et.begin();
            ClienteTipoSubTipoLocal local = new ClienteTipoSubTipoLocal(oid, clie_oid_clie, ticl_oid_tipo_clie, sbti_oid_subt_clie, ind_ppal, fec_ulti_actu);
            em.persist(local);
            et.commit();
            return local;
	}
	
	public void remove(ClienteTipoSubTipoLocal local) {
            final EntityTransaction et = em.getTransaction();
            et.begin();
            em.remove(local);
            et.commit();
	}
	
	public void merge(ClienteTipoSubTipoLocal local) {
            final EntityTransaction et = em.getTransaction();
            et.begin();
            em.merge(local);
            et.commit();
	}
	
	public ClienteTipoSubTipoLocal findByPrimaryKey(Long oid) {
            ClienteTipoSubTipoLocal local = em.find(ClienteTipoSubTipoLocal.class, oid);
            if (local==null) throw new NoResultException();
            return local;
	}

	public ClienteTipoSubTipoLocal findByUK(Long clie,Long tipoClie) {
            Query query=em.createNamedQuery("ClienteTipoSubTipoLocal.FindByUK");
            query.setParameter(1, clie);
            query.setParameter(2, tipoClie);
            return (ClienteTipoSubTipoLocal)(query.getSingleResult());
	}

        public ClienteTipoSubTipoLocal findByClienteTipo(Long cliente, Long tipo) {
            Query query=em.createNamedQuery("ClienteTipoSubTipoLocal.FindByUK");
            query.setParameter(1, cliente);
            query.setParameter(2, tipo);
            return (ClienteTipoSubTipoLocal)(query.getSingleResult());
        }

	public Collection findByCliente(Long oid) {
            Query query=em.createNamedQuery("ClienteTipoSubTipoLocal.FindByCliente");
            query.setParameter(1, oid);
            return query.getResultList();
	}

        public Collection findAll() {
            Query query=em.createNamedQuery("ClienteTipoSubTipoLocal.FindAll");
            return query.getResultList();
        }
    
}
