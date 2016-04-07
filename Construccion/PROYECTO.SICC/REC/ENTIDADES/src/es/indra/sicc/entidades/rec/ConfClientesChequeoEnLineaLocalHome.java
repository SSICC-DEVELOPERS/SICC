package es.indra.sicc.entidades.rec;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.rec.ConfClientesChequeoEnLineaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ConfClientesChequeoEnLineaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-rec");
	private EntityManager em = emf.createEntityManager();

	public ConfClientesChequeoEnLineaLocal create(Integer cantidadMinimaReclamos, Boolean indChequearNuevas, Boolean indGenerado, Long periodo, Long periodoFinal, Long zona, Long region, Long subgerenciaVentas, Long seccion, Long periodoInicial) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("REC_CCCL_SEQ");
                final EntityTransaction et = em.getTransaction();
		et.begin();
                ConfClientesChequeoEnLineaLocal local = new ConfClientesChequeoEnLineaLocal(oid, cantidadMinimaReclamos, indChequearNuevas, indGenerado, periodo, periodoFinal, zona, region, subgerenciaVentas, seccion, periodoInicial);
		em.persist(local);
		et.commit();
		return local;
	}
        
        public ConfClientesChequeoEnLineaLocal create(Integer cantidadMinimaReclamos, Boolean indChequearNuevas, Boolean indGenerado, Long periodo, Long periodoFinal, Long subgerenciaVentas, Long periodoInicial)throws MareException{
            Long oid = SecuenciadorOID.obtenerSiguienteValor("REC_CCCL_SEQ");
            final EntityTransaction et = em.getTransaction();
            et.begin();
            ConfClientesChequeoEnLineaLocal local = new ConfClientesChequeoEnLineaLocal(oid, cantidadMinimaReclamos, indChequearNuevas, indGenerado, periodo, periodoFinal, subgerenciaVentas, periodoInicial);
            em.persist(local);
            et.commit();
            return local;
        }
	
	public void remove(ConfClientesChequeoEnLineaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ConfClientesChequeoEnLineaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ConfClientesChequeoEnLineaLocal findByPrimaryKey(Long  oid) {
		ConfClientesChequeoEnLineaLocal local = (ConfClientesChequeoEnLineaLocal)em.find(ConfClientesChequeoEnLineaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("ConfClientesChequeoEnLineaLocal.FindAll");
		
		return query.getResultList();
	}

}
