package es.indra.sicc.entidades.com;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.com.ComisionesClientesLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ComisionesClientesLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-com");
	private EntityManager em = emf.createEntityManager();

	public ComisionesClientesLocal create(Long comision, Long tipoClienteComisionesCabecera, Integer codigoOrden) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("COM_COCL_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ComisionesClientesLocal local = new ComisionesClientesLocal(oid, comision, tipoClienteComisionesCabecera, codigoOrden);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ComisionesClientesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ComisionesClientesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ComisionesClientesLocal findByPrimaryKey(Long  oid) {
		ComisionesClientesLocal local = (ComisionesClientesLocal)em.find(ComisionesClientesLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
                Query query=em.createNamedQuery("ComisionesClientesLocal.FindAll");          
                return query.getResultList();
        }
            
	public Collection findByComision(Long oidComision) {
		Query query=em.createNamedQuery("ComisionesClientesLocal.FindByComision");
		
		query.setParameter(1, oidComision);

                return query.getResultList();
	}

}
