package es.indra.sicc.entidades.ccc;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;

import es.indra.sicc.entidades.ccc.CuentasCorrientesLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class CuentasCorrientesLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ccc");
	private EntityManager em = emf.createEntityManager();
    
	public CuentasCorrientesLocal create(Long sociedad, Long sucursal, Long cuentaPuente,
                                        Long cuentaTesoreria, String codigo, String codigoCuenta, 
                                        String descripicion, Long pais) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CCC_CCBA_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		CuentasCorrientesLocal local = new CuentasCorrientesLocal(oid, sociedad, sucursal, cuentaPuente,
                                                                 cuentaTesoreria, codigo, codigoCuenta, 
                                                                 descripicion, pais);
		em.persist(local);
		et.commit();
		return local;
	}

        public CuentasCorrientesLocal create(Long sociedad, Long sucursal, Long cuentaPuente, 
                                    Long cuentaTesoreria, String codigo, String codigoCuenta,
                                    String descripcion, String numeroSwift, String direccion, 
                                    String contacto, String telefono, String observaciones, Long pais)
                                    throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CCC_CCBA_SEQ");
                final EntityTransaction et = em.getTransaction();
                et.begin();
                CuentasCorrientesLocal local = new CuentasCorrientesLocal(oid, sociedad, sucursal, cuentaPuente, 
                                                             cuentaTesoreria, codigo, codigoCuenta,
                                                             descripcion, numeroSwift, direccion, 
                                                             contacto, telefono, observaciones, pais);
                em.persist(local);
                et.commit();
                return local;
        }
    
	public void remove(CuentasCorrientesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(CuentasCorrientesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public CuentasCorrientesLocal findByPrimaryKey(Long  oid) {
		CuentasCorrientesLocal local = (CuentasCorrientesLocal)em.find(CuentasCorrientesLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public CuentasCorrientesLocal findByUK(String codigo,Long pais) {
		Query query=em.createNamedQuery("CuentasCorrientesLocal.FindByUK");
		
		query.setParameter(1, codigo);

		query.setParameter(2, pais);

		return (CuentasCorrientesLocal)(query.getSingleResult());
	}

}
