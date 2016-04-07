package es.indra.sicc.entidades.mae;	

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ClienteDatosBasicosLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mae");
	private EntityManager em = emf.createEntityManager();

	public ClienteDatosBasicosLocal create(Long pais_oid_pais, String cod_clie, boolean indFichaInscripcion) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("MAE_CLIE_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ClienteDatosBasicosLocal local = new ClienteDatosBasicosLocal(oid, pais_oid_pais, cod_clie, indFichaInscripcion);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ClienteDatosBasicosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ClienteDatosBasicosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ClienteDatosBasicosLocal findByPrimaryKey(Long  oid) {
		ClienteDatosBasicosLocal local = em.find(ClienteDatosBasicosLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public ClienteDatosBasicosLocal findByUK(Long pais,String codClie) {
		Query query=em.createNamedQuery("ClienteDatosBasicosLocal.FindByUK");
		query.setParameter(1, pais);
		query.setParameter(2, codClie);
		return (ClienteDatosBasicosLocal)(query.getSingleResult());
	}

        public ClienteDatosBasicosLocal findByCodigoYPais(Long pais,String codClie) {
                Query query=em.createNamedQuery("ClienteDatosBasicosLocal.FindByCodigoYPais");
                query.setParameter(1, pais);
                query.setParameter(2, codClie);
                return (ClienteDatosBasicosLocal)(query.getSingleResult());
        }
        
        public Collection findAll() {
                Query query=em.createNamedQuery("ClienteDatosBasicosLocal.FindAll");
                return query.getResultList();
        }
    
}
