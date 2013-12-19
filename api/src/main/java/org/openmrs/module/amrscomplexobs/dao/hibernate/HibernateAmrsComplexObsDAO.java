
/**
 * 
 */
package org.openmrs.module.amrscomplexobs.dao.hibernate;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;
import org.hibernate.SessionFactory;

import org.hibernate.criterion.Restrictions;
import org.openmrs.Field;
import org.openmrs.Form;
import org.openmrs.Patient;
import org.openmrs.module.amrscomplexobs.dao.AmrsComplexObsDAO;
import org.openmrs.module.amrscomplexobs.model.AmrsComplexObs;

import org.openmrs.module.amrscomplexobs.model.AmrsPersonType;

/**
 * @author Ampath Developers
 *
 */
public class HibernateAmrsComplexObsDAO implements AmrsComplexObsDAO {
	
	private SessionFactory sessionFactory;
	
	
    /**
     * @return the sessionFactory
     */
    public SessionFactory getSessionFactory() {
    	return sessionFactory;
    }

	
    /**
     * @param sessionFactory the sessionFactory to set
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
    	this.sessionFactory = sessionFactory;
    }




    @SuppressWarnings("unchecked")
    public AmrsComplexObs getAmrsComplexObsByUuid(String uuid){

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(AmrsComplexObs.class).add(
                Expression.eq("uuid", uuid));




        @SuppressWarnings("unchecked")

        List<AmrsComplexObs>amrscomplexobs=criteria.list();
        if (null==amrscomplexobs||amrscomplexobs.isEmpty()){
            return null;
        }
        return amrscomplexobs.get(0);


    }

    public List<AmrsComplexObs> getAmrsComplexObsByPersonType(AmrsPersonType amrsPersonType, Patient patient){

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(AmrsComplexObs.class)
                .add(Expression.eq("personType",amrsPersonType))
                .add(Expression.eq("patient", patient));



        @SuppressWarnings("unchecked")

        List<AmrsComplexObs>amrscomplexobs=criteria.list();
        if (null==amrscomplexobs||amrscomplexobs.isEmpty()){
            return null;
        }
        return amrscomplexobs;

    }
    public AmrsComplexObs saveAmrsComplexObs(AmrsComplexObs amrsComplexObs) {
        // TODO Auto-generated method stub

        sessionFactory.getCurrentSession().saveOrUpdate(amrsComplexObs);

        return amrsComplexObs;

    }

    public List<AmrsComplexObs> getAmrsComplexObs() {
        // TODO Auto-generated method stub


        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(AmrsComplexObs.class);


        return criteria.list();

    }


    public List<Field> getComplexConceptFieldUuids() {

        String hql = " FROM Field WHERE concept_id in (select  conceptId from ConceptComplex)";

        Query q = sessionFactory.getCurrentSession().createQuery(hql);

        List<Field> fieldUuids = q.list();
      return fieldUuids;
    }

    //New

    public AmrsPersonType saveAmrsPersonType(AmrsPersonType amrspersontype) {
        // TODO Auto-generated method stub

        sessionFactory.getCurrentSession().saveOrUpdate(amrspersontype);

        return amrspersontype;

    }


    @SuppressWarnings("unchecked")
    public List<AmrsPersonType> getAmrsPersonType() {
        // TODO Auto-generated method stub


        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(AmrsPersonType.class);


        return criteria.list();

    }
    @SuppressWarnings("unchecked")
    public AmrsPersonType getAmrsPersonTypeByUuid(String uuid) {

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(AmrsPersonType.class).add(
                Expression.eq("uuid", uuid));

        @SuppressWarnings("unchecked")

        List<AmrsPersonType>amrspersontype=criteria.list();
        if (null==amrspersontype||amrspersontype.isEmpty()){
            return null;
        }
        return amrspersontype.get(0);
    }



	}