package es.indra.sicc.entidades.rec;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.rec.ClientesAChequearLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ClientesAChequearLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-rec");
	private EntityManager em = emf.createEntityManager();

	public ClientesAChequearLocal create(Long tipoRevision, Long cliente, Long periodo) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("REC_CACH_SEQ");
                final EntityTransaction et = em.getTransaction();
		et.begin();
                ClientesAChequearLocal local = new ClientesAChequearLocal(oid, tipoRevision, cliente, periodo);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ClientesAChequearLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ClientesAChequearLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ClientesAChequearLocal findByPrimaryKey(Long  oid) {
		ClientesAChequearLocal local = (ClientesAChequearLocal)em.find(ClientesAChequearLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public ClientesAChequearLocal findByUK(Long param1,Long param2,Long param3) {
		Query query=em.createNamedQuery("ClientesAChequearLocal.FindByUK");
		
		query.setParameter(1, param1);

		query.setParameter(2, param2);

		query.setParameter(3, param3);

		return (ClientesAChequearLocal)(query.getSingleResult());
	}

	public Collection findByPeriodoTipoChequeo(Long param1,Long param2) {
		Query query=em.createNamedQuery("ClientesAChequearLocal.FindByPeriodoTipoChequeo");
		
		query.setParameter(1, param1);

		query.setParameter(2, param2);

		return query.getResultList();
	}

	public Collection findAll() {
		Query query=em.createNamedQuery("ClientesAChequearLocal.FindAll");
		
		return query.getResultList();
	}

}
