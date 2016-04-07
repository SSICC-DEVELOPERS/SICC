package es.indra.sicc.entidades.com;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.com.ComisionesProductosLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ComisionesProductosLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-com");
	private EntityManager em = emf.createEntityManager();

	public ComisionesProductosLocal create(Integer codigo, Long comision, Long tipoProducto, Long tipoInsercionProducto) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("COM_COPR_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ComisionesProductosLocal local = new ComisionesProductosLocal(oid, codigo, comision, tipoProducto, tipoInsercionProducto);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ComisionesProductosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ComisionesProductosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ComisionesProductosLocal findByPrimaryKey(Long  oid) {
		ComisionesProductosLocal local = (ComisionesProductosLocal)em.find(ComisionesProductosLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
                Query query=em.createNamedQuery("ComisionesProductosLocal.FindAll");          
                return query.getResultList();
        }

	public Collection findByComision(Long oidComision) {
		Query query=em.createNamedQuery("ComisionesProductosLocal.FindByComision");
		
		query.setParameter(1, oidComision);

                return query.getResultList();
	}

}
