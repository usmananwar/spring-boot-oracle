package com.bezkoder.spring.oracle.http;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bezkoder.spring.oracle.config.FeignConfig;

@FeignClient(value = "httpApiClient", url = "http://hqgis001:6080/arcgis/rest/services/NAMADashboard", configuration = FeignConfig.class)
public interface HttpApiClient {

	@RequestMapping(method = RequestMethod.GET, value = "/{zone}/MapServer/{mapServerId}/query")
	String mapServerQuery(@PathVariable("zone") String zone, @PathVariable("mapServerId") String mapServerId, @SpringQueryMap Map<String, String> parameters);

}