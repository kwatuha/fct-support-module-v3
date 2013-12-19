/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.amrscomplexobs.web;


import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.openmrs.Concept;
import org.openmrs.FieldType;
import org.openmrs.Form;
import org.openmrs.PersonAttributeType;
import org.openmrs.api.ConceptService;
import org.openmrs.api.FormService;
import org.openmrs.api.PersonService;
import org.openmrs.api.context.Context;

import org.openmrs.module.amrscomplexobs.model.AmrsPersonType;
import org.openmrs.module.amrscomplexobs.service.AmrscomplexobsService;
import org.openmrs.module.amrscomplexobs.util.AMRSComplexObsUtil;

import java.util.List;


/**
 *DWR class for AMRS Complex Obs module
 */
public class DWRAMRSComplexObsService {

    private static final Log log = LogFactory.getLog(AmrscomplexobsService.class);


    public String savePersonTypeDetails(String  persontypename,Integer displayPosition,String  fieldName,String  description){
        AmrscomplexobsService service=Context.getService(AmrscomplexobsService.class);
        AmrsPersonType amrspersontype=new AmrsPersonType();
        amrspersontype.setPersonTypeName(persontypename);
        amrspersontype.setDisplayPosition(displayPosition);
        amrspersontype.setFieldName(fieldName);
        amrspersontype.setDescription(description);
        service.saveAmrsPersonType(amrspersontype);
        return "saved succedded ";
    }

}