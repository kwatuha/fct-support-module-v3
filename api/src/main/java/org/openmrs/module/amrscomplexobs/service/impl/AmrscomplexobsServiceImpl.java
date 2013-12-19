
package org.openmrs.module.amrscomplexobs.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.openmrs.Field;
import org.openmrs.Patient;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.amrscomplexobs.dao.AmrsComplexObsDAO;
import org.openmrs.module.amrscomplexobs.model.AmrsComplexObs;

import org.openmrs.module.amrscomplexobs.service.AmrscomplexobsService;

import org.openmrs.module.amrscomplexobs.model.AmrsPersonType;


/**
 * @author Ampath developers
 *
 */
public class AmrscomplexobsServiceImpl extends BaseOpenmrsService implements AmrscomplexobsService {
protected static final Log log = LogFactory.getLog(AmrscomplexobsServiceImpl.class);


    public void setAmrscomplexobsDAO(AmrsComplexObsDAO amrscomplexobsDAO) {
        this.amrscomplexobsDAO = amrscomplexobsDAO;
    }

    private AmrsComplexObsDAO amrscomplexobsDAO;

//////////////////////////////////////////////////////////////////////


    public AmrsComplexObs saveAmrsComplexObs(AmrsComplexObs amrsComplexObs) {

        return amrscomplexobsDAO.saveAmrsComplexObs(amrsComplexObs);

    }

    public List<AmrsComplexObs> getAmrsComplexObs() {

        return amrscomplexobsDAO.getAmrsComplexObs();
    }

    public AmrsComplexObs getAmrsComplexObsByUuid(String uuid) {

        return amrscomplexobsDAO.getAmrsComplexObsByUuid(uuid);
    }


    public List<AmrsComplexObs> getAmrsComplexObsByPersonType(AmrsPersonType amrsPersonType, Patient patient){

        return amrscomplexobsDAO.getAmrsComplexObsByPersonType(amrsPersonType,patient);

    }



    public List<Field> getComplexConceptFieldUuids(){
        return amrscomplexobsDAO.getComplexConceptFieldUuids();
    }

    public AmrsPersonType saveAmrsPersonType(AmrsPersonType amrsPersonType) {

        return amrscomplexobsDAO.saveAmrsPersonType(amrsPersonType);

    }

    public List<AmrsPersonType> getAmrsPersonType() {

        return amrscomplexobsDAO.getAmrsPersonType();
    }

    public  AmrsPersonType getAmrsPersonTypeByUuid(String uuid) {

        return amrscomplexobsDAO.getAmrsPersonTypeByUuid(uuid);
    }


}