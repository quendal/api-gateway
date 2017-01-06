package com.procesa.api.gateway.client;

import com.procesa.api.gateway.domain.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author erick
 */
@FeignClient("user-service")
public interface UserServiceClient {
    
    @RequestMapping(method = RequestMethod.POST, value = "/users/", consumes = "application/json")
    User save(User user);
}
