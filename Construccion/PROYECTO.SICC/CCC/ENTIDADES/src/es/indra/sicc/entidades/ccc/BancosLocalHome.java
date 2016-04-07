package es.indra.sicc.entidades.ccc;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import es.indra.sicc.entidades.ccc.BancosLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class BancosLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ccc");
	private EntityManager em = emf.createEntityManager();
    
	public BancosLocal create(Long pais, String codigoBanco, String codigoBancario, 
                    String descripcion) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CCC_CBAN_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		BancosLocal local = new BancosLocal(oid, pais, codigoBanco, codigoBancario, descripcion);
		em.persist(local);
		et.commit();
		return local;
	}

        public BancosLocal create(Long pais, String codigoBanco, String codigoBancario,
                String codigoSwift, String descripcion, String observaciones) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CCC_CBAN_SEQ");
                final EntityTransaction et = em.getTransaction();
                et.begin();
                BancosLocal local = new BancosLocal(oid, pais, codigoBanco, codigoBancario,
                                            codigoSwift, descripcion, observaciones);
                em.persist(local);
                et.commit();
                return local;
        }    
    
	public void remove(BancosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(BancosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public BancosLocal findByPrimaryKey(Long  oid) {
		BancosLocal local = (BancosLocal)em.find(BancosLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
