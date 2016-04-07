package es.indra.sicc.entidades.mae;	

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mae.ClienteDireccionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.sql.Date;

public class ClienteDireccionLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mae");
	private EntityManager em = emf.createEntityManager();

	public ClienteDireccionLocal create(Long clie_oid_clie, Long tidc_oid_tipo_dire, Long tivi_oid_tipo_via, Date fechaActua, String est_geop)
                throws MareException {
            
            Long oid = SecuenciadorOID.obtenerSiguienteValor("MAE_CLDI_SEQ");
            final EntityTransaction et = em.getTransaction();
            et.begin();
            ClienteDireccionLocal local = new ClienteDireccionLocal(oid, clie_oid_clie, tidc_oid_tipo_dire, tivi_oid_tipo_via, fechaActua, est_geop);
            em.persist(local);
            et.commit();
            return local;
	}
	
	public void remove(ClienteDireccionLocal local) {
            final EntityTransaction et = em.getTransaction();
            et.begin();
            em.remove(local);
            et.commit();
	}
	
	public void merge(ClienteDireccionLocal local) {
            final EntityTransaction et = em.getTransaction();
            et.begin();
            em.merge(local);
            et.commit();
	}
	
	public ClienteDireccionLocal findByPrimaryKey(Long  oid) {
            ClienteDireccionLocal local = em.find(ClienteDireccionLocal.class, oid);
            if (local==null) throw new NoResultException();
            return local;
	}

	
	public Collection findDireccionPrincipalCliente(Long cliente) {
            Query query=em.createNamedQuery("ClienteDireccionLocal.FindDireccionPrincipalCliente");
            query.setParameter(1, cliente);
            return query.getResultList();
	}

	public Collection findByClienteYTipo(Long cliente,Long tipo) {
            Query query=em.createNamedQuery("ClienteDireccionLocal.FindByClienteYTipo");
            query.setParameter(1, cliente);
            query.setParameter(2, tipo);
            return query.getResultList();
	}

}
