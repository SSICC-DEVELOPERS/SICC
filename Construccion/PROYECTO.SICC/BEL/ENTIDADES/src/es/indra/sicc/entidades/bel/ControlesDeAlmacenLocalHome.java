package es.indra.sicc.entidades.bel;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.bel.ControlesDeAlmacenLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ControlesDeAlmacenLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-bel");
	private EntityManager em = emf.createEntityManager();

	public ControlesDeAlmacenLocal create(Long subAcceso, Long producto, Long almacen) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("BEL_COAL_SEQ");
		ControlesDeAlmacenLocal local = new ControlesDeAlmacenLocal(oid, subAcceso, producto, almacen);
		em.persist(local);
		et.commit();
		return local;
	}
        
        public ControlesDeAlmacenLocal create(Long subAcceso, Long producto, Long stockMinimo, Long stockMaximo, Long stockReposicion, Character activado, Long almacen) throws MareException{
                final EntityTransaction et = em.getTransaction();
                et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("BEL_COAL_SEQ");
                ControlesDeAlmacenLocal local = new ControlesDeAlmacenLocal(oid, subAcceso, producto, stockMinimo, stockMaximo, stockReposicion, activado, almacen);
                em.persist(local);
                et.commit();
                return local;
        }      
	
	public void remove(ControlesDeAlmacenLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ControlesDeAlmacenLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ControlesDeAlmacenLocal findByPrimaryKey(Long  oid) {
		ControlesDeAlmacenLocal local = (ControlesDeAlmacenLocal)em.find(ControlesDeAlmacenLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public ControlesDeAlmacenLocal findByUK(Long param1,Long param2,Long param3) {
		Query query=em.createNamedQuery("ControlesDeAlmacenLocal.FindByUK");
		
		query.setParameter(1, param1);

		query.setParameter(2, param2);

		query.setParameter(3, param3);

		return (ControlesDeAlmacenLocal)(query.getSingleResult());
	}

}
