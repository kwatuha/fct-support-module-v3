
/**
 * 
 */
package org.openmrs.module.amrscomplexobs.dao;

import java.util.List;


import org.openmrs.Field;
import org.openmrs.Patient;
import org.openmrs.module.amrscomplexobs.model.AmrsComplexObs;
import org.openmrs.module.amrscomplexobs.model.AmrsPersonType;

public interface AmrsComplexObsDAO {



    ///
    public AmrsComplexObs saveAmrsComplexObs(AmrsComplexObs AmrsComplexObs);

    public List<AmrsComplexObs> getAmrsComplexObs();

    public AmrsComplexObs getAmrsComplexObsByUuid(String uuid);

    public List<Field> getComplexConceptFieldUuids() ;

    public AmrsPersonType saveAmrsPersonType(AmrsPersonType amrspersontype);

    public List<AmrsPersonType> getAmrsPersonType();

    public AmrsPersonType getAmrsPersonTypeByUuid(String uuid);
    public List<AmrsComplexObs> getAmrsComplexObsByPersonType(AmrsPersonType amrsPersonType, Patient patient);



}