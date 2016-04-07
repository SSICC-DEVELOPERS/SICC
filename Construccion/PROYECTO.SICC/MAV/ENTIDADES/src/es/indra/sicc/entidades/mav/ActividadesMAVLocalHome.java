package es.indra.sicc.entidades.mav;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mav.ActividadesMAVLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ActividadesMAVLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mav");
	private EntityManager em = emf.createEntityManager();
            
	public ActividadesMAVLocal create(Long oidPais, Long oidTipoCondicionDePago, Long oidCanal, Long oidFormaDePago, String descripcionDetallada,
                                                    Long oidMarca, Long oidTipoCliente) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("MAV_ACTI_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ActividadesMAVLocal local = new ActividadesMAVLocal(oid, oidPais, oidTipoCondicionDePago, oidCanal, oidFormaDePago, descripcionDetallada,
                                                 oidMarca, oidTipoCliente);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ActividadesMAVLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ActividadesMAVLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ActividadesMAVLocal findByPrimaryKey(Long  oid) {
		ActividadesMAVLocal local = (ActividadesMAVLocal)em.find(ActividadesMAVLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
