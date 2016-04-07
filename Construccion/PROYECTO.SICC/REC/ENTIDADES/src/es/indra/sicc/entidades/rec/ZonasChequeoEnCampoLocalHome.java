package es.indra.sicc.entidades.rec;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.rec.ZonasChequeoEnCampoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ZonasChequeoEnCampoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-rec");
	private EntityManager em = emf.createEntityManager();

	public ZonasChequeoEnCampoLocal create(Long codigoZonasChequeo, Long confCliCheqCampo,
        Long region, Long seccion, Long subgerenciaVentas, Long zona)
        throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("REC_ZCEC_SEQ");
                final EntityTransaction et = em.getTransaction();
		et.begin();
                ZonasChequeoEnCampoLocal local = new ZonasChequeoEnCampoLocal(oid, codigoZonasChequeo, confCliCheqCampo, region, seccion, subgerenciaVentas, zona);		
                em.persist(local);
		et.commit();
		return local;
	}
        
        public ZonasChequeoEnCampoLocal create(Long codigoZonasChequeo, Long confCliCheqCampo, Long subgerenciaVentas) throws MareException {
                    Long oid = SecuenciadorOID.obtenerSiguienteValor("REC_ZCEC_SEQ");
                    final EntityTransaction et = em.getTransaction();
                    et.begin();
                    ZonasChequeoEnCampoLocal local = new ZonasChequeoEnCampoLocal(oid, codigoZonasChequeo, confCliCheqCampo, subgerenciaVentas);             
                    em.persist(local);
                    et.commit();
                    return local;    
        }
	
	public void remove(ZonasChequeoEnCampoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ZonasChequeoEnCampoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ZonasChequeoEnCampoLocal findByPrimaryKey(Long  oid) {
		ZonasChequeoEnCampoLocal local = (ZonasChequeoEnCampoLocal)em.find(ZonasChequeoEnCampoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findByConfiguracionClientes(Long param1) {
		Query query=em.createNamedQuery("ZonasChequeoEnCampoLocal.FindByConfiguracionClientes");
		
		query.setParameter(1, param1);

		return query.getResultList();
	}

	public Collection findAll() {
		Query query=em.createNamedQuery("ZonasChequeoEnCampoLocal.FindAll");
		
		return query.getResultList();
	}

}
