
package org.openmrs.module.amrscomplexobs;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.ModuleActivator;
import org.openmrs.module.amrscomplexobs.handler.OutreachMotherHandler;


/**
 * 
 */

/**
 * @author Ampath Developers
 *
 */
public class AmrscomplexobsActivator implements ModuleActivator {
    protected Log log = LogFactory.getLog(getClass());

    /**
     * @see ModuleActivator#willRefreshContext()
     */
    public void willRefreshContext() {
        log.info("Refreshing FCT Support Module");
    }

    /**
     * @see ModuleActivator#contextRefreshed()
     */
    public void contextRefreshed() {
        log.info("FCT Support Module refreshed");
    }

    /**
     * @see ModuleActivator#willStart()
     */
    public void willStart() {
        log.info("Starting FCT Support Module");
    }

    /**
     * @see ModuleActivator#started()
     */
    public void started() {
        log.info("FCT Support Module started");
        log.info("Starting AmrsComplexObs module");
        Context.getObsService().registerHandler("OutReachMotherHandler", new OutreachMotherHandler());
    }

    /**
     * @see ModuleActivator#willStop()
     */
    public void willStop() {
        log.info("Stopping FCT Support Module");
    }

    /**
     * @see ModuleActivator#stopped()
     */
    public void stopped() {
        log.info("FCT Support Module stopped");
    }
	
}

