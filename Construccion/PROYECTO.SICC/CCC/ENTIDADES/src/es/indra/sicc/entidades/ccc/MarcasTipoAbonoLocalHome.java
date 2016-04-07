package es.indra.sicc.entidades.ccc;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;

import es.indra.sicc.entidades.ccc.MarcasTipoAbonoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.util.Collection;

public class MarcasTipoAbonoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ccc");
	private EntityManager em = emf.createEntityManager();
    
	public MarcasTipoAbonoLocal create(Long tipoAbonoSubproceso) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CCC_MTAB_SEQ");    
		final EntityTransaction et = em.getTransaction();
		et.begin();
		MarcasTipoAbonoLocal local = new MarcasTipoAbonoLocal(oid, tipoAbonoSubproceso);
		em.persist(local);
		et.commit();
		return local;
	}
	
        
        public MarcasTipoAbonoLocal create(String idEntradaSalida, String observaciones, Long marca, Long tipoAbonoSubproceso) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CCC_MTAB_SEQ");    
                final EntityTransaction et = em.getTransaction();
                et.begin();
                MarcasTipoAbonoLocal local = new MarcasTipoAbonoLocal(oid, idEntradaSalida, observaciones, marca, tipoAbonoSubproceso);
                em.persist(local);
                et.commit();
                return local;
        }
    
	public void remove(MarcasTipoAbonoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(MarcasTipoAbonoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public MarcasTipoAbonoLocal findByPrimaryKey(Long  oid) {
		MarcasTipoAbonoLocal local = (MarcasTipoAbonoLocal)em.find(MarcasTipoAbonoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findByTipoAbonoSubproceso(Long tipoAbonoSubproceso) {
		Query query=em.createNamedQuery("MarcasTipoAbonoLocal.FindByTipoAbonoSubproceso");
		
		query.setParameter(1, tipoAbonoSubproceso);

		return query.getResultList();
	}

	public Collection findByTipoAbonoSubprocesoEoS(Long oidTipoAbonoSubproceso,String entradaOsalida) {
		Query query=em.createNamedQuery("MarcasTipoAbonoLocal.FindByTipoAbonoSubprocesoEoS");
		
		query.setParameter(1, oidTipoAbonoSubproceso);

		query.setParameter(2, entradaOsalida);

		return query.getResultList();
	}

}
