package es.indra.sicc.entidades.mae;	

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mae.ClienteVinculoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.sql.Date;

public class ClienteVinculoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mae");
	private EntityManager em = emf.createEntityManager();

	public ClienteVinculoLocal create(Long clie_oid_clie_vnte, Long clie_oid_clie_vndo, Long tivc_oid_tipo_vinc,
                Date fec_ulti_actu) throws MareException {
        
            Long oid = SecuenciadorOID.obtenerSiguienteValor("MAE_CVIN_SEQ");
            final EntityTransaction et = em.getTransaction();
            et.begin();
            ClienteVinculoLocal local = new ClienteVinculoLocal(oid, clie_oid_clie_vnte, clie_oid_clie_vndo, tivc_oid_tipo_vinc, fec_ulti_actu);
            em.persist(local);
            et.commit();
            return local;
	}
	
	public void remove(ClienteVinculoLocal local) {
            final EntityTransaction et = em.getTransaction();
            et.begin();
            em.remove(local);
            et.commit();
	}
	
	public void merge(ClienteVinculoLocal local) {
            final EntityTransaction et = em.getTransaction();
            et.begin();
            em.merge(local);
            et.commit();
	}
	
	public ClienteVinculoLocal findByPrimaryKey(Long  oid) {
            ClienteVinculoLocal local = em.find(ClienteVinculoLocal.class, oid);
            if (local==null) throw new NoResultException();
            return local;
	}

	public Collection findByClienteVinculanteTipoVinculo(Long clienteVinculante,Long tipoVinculo) {
            Query query=em.createNamedQuery("ClienteVinculoLocal.FindByClienteVinculanteTipoVinculo");
            query.setParameter(1, clienteVinculante);
            query.setParameter(2, tipoVinculo);
            return query.getResultList();
	}

	public ClienteVinculoLocal findByUK(Long clienteVinculante,Long clienteVinculado,Long tipoVinculo) {
            Query query=em.createNamedQuery("ClienteVinculoLocal.FindByUK");
            query.setParameter(1, clienteVinculante);
            query.setParameter(2, clienteVinculado);
            query.setParameter(3, tipoVinculo);
            return (ClienteVinculoLocal)(query.getSingleResult());
	}

        public Collection findAll() {
            Query query=em.createNamedQuery("ClienteVinculoLocal.FindAll");
            return query.getResultList();
        }
    
}
