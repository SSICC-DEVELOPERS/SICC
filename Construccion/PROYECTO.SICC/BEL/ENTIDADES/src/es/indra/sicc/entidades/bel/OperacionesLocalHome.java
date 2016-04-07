package es.indra.sicc.entidades.bel;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.bel.OperacionesLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class OperacionesLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-bel");
	private EntityManager em = emf.createEntityManager();

	public OperacionesLocal create(String codigoOperacion, String descripcion) throws MareException{
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("BEL_OPER_SEQ");
                OperacionesLocal local = new OperacionesLocal(oid, codigoOperacion, descripcion);
		em.persist(local);
		et.commit();
		return local;
	}
        
        public OperacionesLocal create(String codigoOperacion, String descripcion, Boolean indicadorContadores, Boolean indicadorMovAlmacen, Boolean indicadorSolicitudModExt) throws MareException{
                final EntityTransaction et = em.getTransaction();
                et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("BEL_OPER_SEQ");
                OperacionesLocal local = new OperacionesLocal(oid, codigoOperacion, descripcion, indicadorContadores, indicadorMovAlmacen, indicadorSolicitudModExt);
                em.persist(local);
                et.commit();
                return local;
        }        
	
	public void remove(OperacionesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(OperacionesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public OperacionesLocal findByPrimaryKey(Long  oid) {
		OperacionesLocal local = (OperacionesLocal)em.find(OperacionesLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public OperacionesLocal findByUK(String param1) {
		Query query=em.createNamedQuery("OperacionesLocal.FindByUK");
		
		query.setParameter(1, param1);

		return (OperacionesLocal)(query.getSingleResult());
	}

}
