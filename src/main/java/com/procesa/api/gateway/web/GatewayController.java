package com.procesa.api.gateway.web;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.procesa.api.gateway.client.UserServiceClient;
import com.procesa.api.gateway.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author erick
 */
@RestController
@RequestMapping(value = "/gateway")
public class GatewayController {

    @Autowired
    private EurekaClient eurekaClient;
    @Autowired
    private UserServiceClient userServiceClient;
    
    @RequestMapping(value = "/services/{name}", method = RequestMethod.GET)
    public InstanceInfo findUserByDbid(@PathVariable String name) {
        User user = new User();
        user.setName("Juancho");
        user.setEmail("juancho@gmail.com");
        userServiceClient.save(user);
        return eurekaClient.getNextServerFromEureka(name, true);
    }
}
