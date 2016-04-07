package es.indra.sicc.entidades.fac;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.fac.ProcesosPorCierreLocal;
import es.indra.sicc.util.SecuenciadorOID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;


public class ProcesosPorCierreLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-fac");
	private EntityManager em = emf.createEntityManager();

	public ProcesosPorCierreLocal create(Long pais, String tipoCierre, String proceso, Byte ordenEjecucion) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("FAC_PRCI_SEQ");
		ProcesosPorCierreLocal local = new ProcesosPorCierreLocal(oid, pais, tipoCierre, proceso, ordenEjecucion);
		em.persist(local);
		et.commit();
		return local;
	}

        public ProcesosPorCierreLocal create(Long pais, String tipoCierre, String proceso, Byte ordenEjecucion, String programa) throws MareException {
                final EntityTransaction et = em.getTransaction();
                et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("FAC_PRCI_SEQ");
                ProcesosPorCierreLocal local = new ProcesosPorCierreLocal(oid, pais, tipoCierre, proceso, ordenEjecucion, programa);
                em.persist(local);
                et.commit();
                return local;
        }
	
	public void remove(ProcesosPorCierreLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ProcesosPorCierreLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ProcesosPorCierreLocal findByPrimaryKey(Long  oid) {
		ProcesosPorCierreLocal local = (ProcesosPorCierreLocal)em.find(ProcesosPorCierreLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
