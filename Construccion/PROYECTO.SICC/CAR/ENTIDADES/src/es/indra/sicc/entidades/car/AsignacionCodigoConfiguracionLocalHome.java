package es.indra.sicc.entidades.car;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.car.AsignacionCodigoConfiguracionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class AsignacionCodigoConfiguracionLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-car");
	private EntityManager em = emf.createEntityManager();

	public AsignacionCodigoConfiguracionLocal create(Long zsgv_oid_subg_vent, Long zorg_oid_regi, Long zzon_oid_zona, Long grso_oid_grup_soli, Long niri_oid_nive_ries, Long niri_oid_nive_ries_inici, Long paca_oid_para_cart, Double val_line_cred_inic) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CAR_ASCC_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		AsignacionCodigoConfiguracionLocal local = new AsignacionCodigoConfiguracionLocal(oid, zsgv_oid_subg_vent, zorg_oid_regi, zzon_oid_zona, grso_oid_grup_soli, niri_oid_nive_ries, niri_oid_nive_ries_inici, paca_oid_para_cart, val_line_cred_inic);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(AsignacionCodigoConfiguracionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(AsignacionCodigoConfiguracionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public AsignacionCodigoConfiguracionLocal findByPrimaryKey(Long  oid) {
		AsignacionCodigoConfiguracionLocal local = (AsignacionCodigoConfiguracionLocal)em.find(AsignacionCodigoConfiguracionLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findByCodigoConfiguracion(Long oid) {
		Query query=em.createNamedQuery("AsignacionCodigoConfiguracionLocal.FindByCodigoConfiguracion");
		
		query.setParameter(1, oid);

                return query.getResultList();
	}
        
        public Collection findAll() {
            Query query=em.createNamedQuery("AsignacionCodigoConfiguracionLocal.FindAll");          
            return query.getResultList();
        }

}
