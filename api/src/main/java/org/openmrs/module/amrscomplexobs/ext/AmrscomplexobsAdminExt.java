/**
 * 
 */
package org.openmrs.module.amrscomplexobs.ext;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.openmrs.module.Extension;
import org.openmrs.module.web.extension.AdministrationSectionExt;

/**
 * @author Ampath Developers
 * 
 */
public class AmrscomplexobsAdminExt extends AdministrationSectionExt {

    public Extension.MEDIA_TYPE getMediaType() {
        return Extension.MEDIA_TYPE.html;
    }

    /**
     * @see AdministrationSectionExt#getTitle()
     */
    public String getTitle() {
        return "amrscomplexobs.title";
    }

    /**
     * @see AdministrationSectionExt#getLinks()
     */
    public Map<String, String> getLinks() {
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();

        map.put("module/amrscomplexobs/manage.form", "Define AMRS Person Types ");

        return map;
    }

}
