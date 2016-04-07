package es.indra.sicc.entidades.pre;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.pre.DetalleOfertaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class DetalleOfertaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-pre");
	private EntityManager em = emf.createEntityManager();

	public DetalleOfertaLocal create(Long ofer_oid_ofer, Long prod_oid_prod, Integer num_line_ofer, Integer val_fact_repe, Long tofe_oid_tipo_ofer, Long civi_oid_ciclo_vida, Long oid_grup_ofert) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("PRE_OFDE_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		DetalleOfertaLocal local = new DetalleOfertaLocal(oid, ofer_oid_ofer, prod_oid_prod, num_line_ofer, val_fact_repe, tofe_oid_tipo_ofer, civi_oid_ciclo_vida, oid_grup_ofert);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(DetalleOfertaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(DetalleOfertaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public DetalleOfertaLocal findByPrimaryKey(Long  oid) {
		DetalleOfertaLocal local = (DetalleOfertaLocal)em.find(DetalleOfertaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findByOidOfer(Long oidOfer) {
		Query query=em.createNamedQuery("DetalleOfertaLocal.FindByOidOfer");
		
		query.setParameter(1, oidOfer);

		return query.getResultList();
	}
        
        // vbongiov -- Cambio 20080746 -- 29/10/2008
        public Collection findByOidOferOrde(Long oidOfer) {
                Query query=em.createNamedQuery("DetalleOfertaLocal.FindByOidOferOrde");
                
                query.setParameter(1, oidOfer);
    
                return query.getResultList();
        }

	public Collection findByOfertaCV(Long oidOfer,String codigoVenta) {
		Query query=em.createNamedQuery("DetalleOfertaLocal.FindByOfertaCV");
		
		query.setParameter(1, oidOfer);

		query.setParameter(2, codigoVenta);

		return query.getResultList();
	}

	public Collection findByGrupo(Long oidGrupOfer) {
		Query query=em.createNamedQuery("DetalleOfertaLocal.FindByGrupo");
		
		query.setParameter(1, oidGrupOfer);

		return query.getResultList();
	}

	public Collection findByProducto(Long oidProd) {
		Query query=em.createNamedQuery("DetalleOfertaLocal.FindByProducto");
		
		query.setParameter(1, oidProd);

		return query.getResultList();
	}
        
        public Collection findByCodigoVentaMFNoGenerada(Long oidOfer) {
                Query query=em.createNamedQuery("DetalleOfertaLocal.FindByCodigoVentaMFNoGenerada");
                
                query.setParameter(1, oidOfer);
    
                return query.getResultList();
        }        

}
