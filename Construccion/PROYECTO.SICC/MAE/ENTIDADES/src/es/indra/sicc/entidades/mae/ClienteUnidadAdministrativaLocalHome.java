package es.indra.sicc.entidades.mae;	

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mae.ClienteUnidadAdministrativaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ClienteUnidadAdministrativaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mae");
	private EntityManager em = emf.createEntityManager();

	public ClienteUnidadAdministrativaLocal create(Long clie_oid_clie, Long perd_oid_peri_ini, Long perd_oid_peri_fin,
                Long ztad_oid_terr_admi, Long ind_acti) throws MareException {
                
            Long oid = SecuenciadorOID.obtenerSiguienteValor("MAE_CUAD_SEQ");
            final EntityTransaction et = em.getTransaction();
            et.begin();
            ClienteUnidadAdministrativaLocal local = new ClienteUnidadAdministrativaLocal(oid, clie_oid_clie, perd_oid_peri_ini, perd_oid_peri_fin, ztad_oid_terr_admi, ind_acti);
            em.persist(local);
            et.commit();
            return local;
	}
	
	public void remove(ClienteUnidadAdministrativaLocal local) {
            final EntityTransaction et = em.getTransaction();
            et.begin();
            em.remove(local);
            et.commit();
	}
	
	public void merge(ClienteUnidadAdministrativaLocal local) {
            final EntityTransaction et = em.getTransaction();
            et.begin();
            em.merge(local);
            et.commit();
	}
	
	public ClienteUnidadAdministrativaLocal findByPrimaryKey(Long  oid) {
            ClienteUnidadAdministrativaLocal local = em.find(ClienteUnidadAdministrativaLocal.class, oid);
            if (local==null) throw new NoResultException();
            return local;
	}

	
	public Collection findUAActiva(Long cliente,Long territorioAdm) {
            Query query=em.createNamedQuery("ClienteUnidadAdministrativaLocal.FindUAActiva");
            query.setParameter(1, cliente);
            query.setParameter(2, territorioAdm);
            return query.getResultList();
	}

	public Collection findByCliente(Long oidCliente) {
            Query query=em.createNamedQuery("ClienteUnidadAdministrativaLocal.FindByCliente");
            query.setParameter(1, oidCliente);
	    return query.getResultList();
	}

	public Collection findOidTerriAdmin(Long oidCliente) {
            Query query=em.createNamedQuery("ClienteUnidadAdministrativaLocal.FindOidTerriAdmin");
            query.setParameter(1, oidCliente);
	    return query.getResultList();
	}

	public Collection findUAActivaByCliente(Long oidCliente) {
            Query query=em.createNamedQuery("ClienteUnidadAdministrativaLocal.FindUAActivaByCliente");
            query.setParameter(1, oidCliente);
	    return query.getResultList();
	}

	public Collection findUAUltima(Long oidCliente) {
            Query query=em.createNamedQuery("ClienteUnidadAdministrativaLocal.FindUAUltima");
            query.setParameter(1, oidCliente);
	    return query.getResultList();
	}

        public Collection findAll() {
            Query query=em.createNamedQuery("ClienteUnidadAdministrativaLocal.FindAll");
            return query.getResultList();
        }
    
}
