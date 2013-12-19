package org.openmrs.module.amrscomplexobs.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.openmrs.Concept;
import org.openmrs.FieldType;
import org.openmrs.Patient;
import org.openmrs.Person;
import org.openmrs.PersonAddress;
import org.openmrs.PersonAttribute;
import org.openmrs.PersonAttributeType;
import org.openmrs.PersonName;
import org.openmrs.api.ConceptService;
import org.openmrs.api.FormService;
import org.openmrs.api.PersonService;
import org.openmrs.api.context.Context;
import org.openmrs.attribute.AttributeType;
import org.openmrs.module.amrscomplexobs.model.AmrsComplexObs;
import org.openmrs.module.amrscomplexobs.model.LocatorPersonDetails;
import org.openmrs.module.amrscomplexobs.model.AmrsPersonType;
import org.openmrs.module.amrscomplexobs.service.AmrscomplexobsService;
import org.openmrs.web.controller.PortletController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("**/outreachlocator.portlet")
public class OutReachLocatorPortletController extends PortletController {

    @Override
    protected void populateModel(HttpServletRequest request, Map<String, Object> model) {



        AmrscomplexobsService service=Context.getService(AmrscomplexobsService.class);
        List<AmrsPersonType> personTpesList=service.getAmrsPersonType();

        Patient patient = (Patient) model.get("patient");

        Map<String, Object> response= new HashMap<String, Object>();

        for (AmrsPersonType personType : personTpesList) {

            List<AmrsComplexObs> personTypeObsLists=service.getAmrsComplexObsByPersonType(personType,patient);
            List<LocatorPersonDetails>ldetails=generateObjectMap(personTypeObsLists) ;
            String me="hhh";
            response.put(personType.getPersonTypeName(),personTypeObsLists.toArray());
        }



        model.put("listPersonTypes", personTpesList);
        model.put("listComplexObs",response);





    }
    private List<LocatorPersonDetails> generateObjectMap(List<AmrsComplexObs> personTypeObsLists) {
        // try to stick to basic types; String, Integer, etc (not Date)
        PersonService personService=Context.getPersonService();
        List<LocatorPersonDetails>locatorDetails=new ArrayList<LocatorPersonDetails>();

          for(AmrsComplexObs obs:personTypeObsLists){
              LocatorPersonDetails locatorPersonDetails=new LocatorPersonDetails();

              Person person =obs.getPerson();

              locatorPersonDetails.setOfficialName(person.getPersonName().getGivenName()+" "+person.getPersonName().getMiddleName()+" "+person.getPersonName().getFamilyName());

              Set<PersonAttribute>personAttributes=person.getAttributes();

              for (Iterator<PersonAttribute> it = personAttributes.iterator(); it.hasNext(); ) {
                  PersonAttribute personAttribute = it.next();
                  PersonAttributeType attributeType=personAttribute.getAttributeType()  ;


                  System.out.print(personAttribute.getValue());

              }

              /*locatorPersonDetails.setTribe(person.get);
              locatorPersonDetails.setMaritalStatus(person);
              locatorPersonDetails.setPhoneNum(person);
              locatorPersonDetails.setPhoneNumOwner(person);
              locatorPersonDetails.setRelationshiptoPhoneNumOwner(person);
              locatorPersonDetails.setAlternativePhoneNum(person);
              locatorPersonDetails.setAlternativePhoneNumOwner(person);
              locatorPersonDetails.setRelationshipToAlternativePhoneNumOwner(person);
              locatorPersonDetails.setOccupation(person);
              locatorPersonDetails.setPlaceofWork(person);
              locatorPersonDetails.setPlaceofWorkDepartment(person);
              locatorPersonDetails.setSectionHomestead(person);
              locatorPersonDetails.setResidentialAddressTownHouse(person);
              locatorPersonDetails.setResidentialAddressvillageHome(person);
              locatorPersonDetails.setSublocation(person);
              locatorPersonDetails.setLandmark(person);
              locatorPersonDetails.setNearestChurch(person);
              locatorPersonDetails.setNearestSchool(person);
              locatorPersonDetails.setNearestShoppingCenter(person);
              locatorPersonDetails.setEstate(person);
              locatorPersonDetails.setGeneralRoute(person);
              locatorPersonDetails.setStage(person);
              locatorPersonDetails.setPlot(person);
              locatorPersonDetails.setWellKnownNeighbor(person);
              locatorPersonDetails.setWhomToAskFor(person);
              locatorPersonDetails.setLandlord(person);
              locatorPersonDetails.setReligiousAffiliation(person);
              locatorPersonDetails.setLocationOfReligiousAffiliation(person);*/


              person.getAttributes();
              PersonAddress      personAddress= person.getPersonAddress();
              PersonName         personName=person.getPersonName();
              Set<PersonAddress> personAddresses=person.getAddresses();



          }

        return locatorDetails;
    }
}

