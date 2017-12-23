package com.marcuschiu.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
class ExampleController {

    @Value("${foo.bar:default}")
    private String value;

    @GetMapping("/get-property-2")
    public String sayValue() {
        return value;
    }
}
