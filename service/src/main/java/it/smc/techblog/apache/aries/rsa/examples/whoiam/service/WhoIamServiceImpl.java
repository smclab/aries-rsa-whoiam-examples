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

package it.smc.techblog.apache.aries.rsa.examples.whoiam.service;

import it.smc.techblog.apache.aries.rsa.examples.whoiam.api.WhoIamService;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.log.LogService;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Antonio Musarra
 */
@Component(
	property = {
		"service.exported.interfaces=*",
		"aries.rsa.port=8202"
	})
public class WhoIamServiceImpl implements WhoIamService {

	@Override
	public String whoiam() {
		Bundle bundle = _bc.getBundle();

		String hostAddress = "NA";

		try {
			hostAddress = InetAddress.getLocalHost().getHostAddress();
		}
		catch (UnknownHostException uhe) {
			_log.log(_log.LOG_ERROR, uhe.getMessage());
		}

		String response =
			"Who I am : {Bundle Id: %s, Bundle Name: %s, Bundle Version: %s, Framework Id: %s, HostAddress: %s}";

		return String.format(
			response, bundle.getBundleId(), bundle.getHeaders().get(
				Constants.BUNDLE_NAME), bundle.getVersion(),
			_bc.getProperty(Constants.FRAMEWORK_UUID), hostAddress
		);
	}

	@Activate
	protected void activate(BundleContext bundleContext) {
		_bc = bundleContext;
	}

	private BundleContext _bc;

	@Reference
	private LogService _log;
}
