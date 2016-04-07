package es.indra.sicc.entidades.car;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.car.ParametrosdeCarteraLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ParametrosdeCarteraLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-car");
	private EntityManager em = emf.createEntityManager();

	public ParametrosdeCarteraLocal create(Long pais_oid_pais, Long grso_oid_grup_soli, Long niri_oid_nive_ries, String cod_conf, Boolean ind_deud_venc, Boolean ind_line_cred, Boolean ind_mont_maxi, Boolean ind_porc_maxi) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CAR_PACA_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ParametrosdeCarteraLocal local = new ParametrosdeCarteraLocal(oid, pais_oid_pais, grso_oid_grup_soli,  niri_oid_nive_ries, cod_conf, ind_deud_venc, ind_line_cred, ind_mont_maxi, ind_porc_maxi);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ParametrosdeCarteraLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ParametrosdeCarteraLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ParametrosdeCarteraLocal findByPrimaryKey(Long  oid) {
		ParametrosdeCarteraLocal local = (ParametrosdeCarteraLocal)em.find(ParametrosdeCarteraLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public ParametrosdeCarteraLocal findByUK(Long oidPais, Long oidGrupoSolicitud, Long oidNivelRiesgo, String codigoConfiguracion) {
		Query query=em.createNamedQuery("ParametrosdeCarteraLocal.FindByUK");
		
		query.setParameter(1, oidPais);

		query.setParameter(2, oidGrupoSolicitud);

		query.setParameter(3, oidNivelRiesgo);

		query.setParameter(4, codigoConfiguracion);

		return (ParametrosdeCarteraLocal)(query.getSingleResult());
	}

	public Collection findByPaisYCodConf(Long oidPais, String codigoConfiguracion) {
		Query query=em.createNamedQuery("ParametrosdeCarteraLocal.FindByPaisYCodConf");
		
		query.setParameter(1, oidPais);

		query.setParameter(2, codigoConfiguracion);

                return query.getResultList();
	}
        
        public Collection findAll() {
            Query query=em.createNamedQuery("ParametrosdeCarteraLocal.FindAll");          
            return query.getResultList();
        }

}
