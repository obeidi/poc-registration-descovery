package client.eureka;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Dieser Service Ruft den in Eureka registrierten Service, ohne ihn zu kennen.
 * Was er zum Aufruf benötigt ist nur der 'applicationName'. 
 * @author ahmadobeidi
 *
 */

@EnableEurekaClient
@RestController
class ServiceInstanceRestController {

	@Autowired
	private DiscoveryClient discoveryClient;

	@RequestMapping("/service-instances/{applicationName}")
	public List<ServiceInstance> serviceInstancesByApplicationName(
			@PathVariable String applicationName) {
		System.out.println(applicationName);
		return this.discoveryClient.getInstances(applicationName);
	}
}