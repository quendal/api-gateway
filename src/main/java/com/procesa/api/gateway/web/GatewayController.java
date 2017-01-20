package com.procesa.api.gateway.web;

import com.netflix.discovery.EurekaClient;
import com.procesa.api.gateway.client.UserServiceClient;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("/user")
    @Secured("ACCESO_USUARIO")
    public Principal user(Principal user) {
        return user;
    }
}
