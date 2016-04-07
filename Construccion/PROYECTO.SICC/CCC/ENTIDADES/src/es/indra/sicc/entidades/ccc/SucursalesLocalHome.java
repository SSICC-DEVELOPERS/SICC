package es.indra.sicc.entidades.ccc;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import es.indra.sicc.entidades.ccc.SucursalesLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class SucursalesLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ccc");
	private EntityManager em = emf.createEntityManager();

	public SucursalesLocal create(Long banco, String codigo, String direccion)
                                        throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CCC_SUCU_SEQ");                                        
		final EntityTransaction et = em.getTransaction();
		et.begin();
		SucursalesLocal local = new SucursalesLocal(oid, banco, codigo, direccion);
		em.persist(local);
		et.commit();
		return local;
	}

        public SucursalesLocal create(Long banco, String codigo, String direccion, 
                                    String contacto, String telefono, String observaciones, 
                                    String ciudad, String departamento, String distrito)
                                        throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CCC_SUCU_SEQ");                                        
                final EntityTransaction et = em.getTransaction();
                et.begin();
                SucursalesLocal local = new SucursalesLocal(oid, banco, codigo, direccion, 
                                             contacto, telefono, observaciones, 
                                             ciudad, departamento, distrito);
                em.persist(local);
                et.commit();
                return local;
        }    	
        
	public void remove(SucursalesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(SucursalesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public SucursalesLocal findByPrimaryKey(Long  oid) {
		SucursalesLocal local = (SucursalesLocal)em.find(SucursalesLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
