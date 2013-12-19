/**
 * 
 */
package org.openmrs.module.amrscomplexobs.service;

import java.util.List;

import org.openmrs.Field;

import org.openmrs.Patient;
import org.openmrs.api.OpenmrsService;

import org.openmrs.module.amrscomplexobs.model.AmrsComplexObs;

import org.springframework.transaction.annotation.Transactional;

import org.openmrs.module.amrscomplexobs.model.AmrsPersonType;

/**
 * @author Ampath Developers
 *
 */
@Transactional

public interface AmrscomplexobsService extends OpenmrsService{

    public AmrsComplexObs saveAmrsComplexObs(AmrsComplexObs amrsComplexObs);

    public List<AmrsComplexObs> getAmrsComplexObs();

    public AmrsComplexObs getAmrsComplexObsByUuid(String uuid);

    public List<Field> getComplexConceptFieldUuids();

    public AmrsPersonType saveAmrsPersonType(AmrsPersonType amrspersontype);

    public List<AmrsPersonType> getAmrsPersonType();

    public AmrsPersonType getAmrsPersonTypeByUuid(String uuid);

    public List<AmrsComplexObs> getAmrsComplexObsByPersonType(AmrsPersonType amrsPersonType, Patient patient);





}