/**
 * Copyright (c) 2020 SMC Treviso Srl. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.smc.techblog.apache.aries.rsa.examples.whoiam.consumer;

import it.smc.techblog.apache.aries.rsa.examples.whoiam.api.WhoIamService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Antonio Musarra
 */
@Component(immediate=true)
public class WhoIamConsumer {

    WhoIamService _whoIamService;

    @Activate
    public void activate() {
        System.out.println("Sending to Who I am service");
        System.out.println(_whoIamService.whoiam());
    }

    @Reference
    public void setWhoIamService(WhoIamService whoIamService) {
        this._whoIamService = whoIamService;
    }
}
