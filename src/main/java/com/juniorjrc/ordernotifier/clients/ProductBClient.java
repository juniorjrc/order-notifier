package com.juniorjrc.ordernotifier.clients;

import com.juniorjrc.ordernotifier.config.feign.BasicFeignClientConfiguration;
import com.juniorjrc.ordermodel.dto.OrderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Component
@FeignClient(name = "product-b-client", url = "${api.clients.product-b-service.url}",
        configuration = BasicFeignClientConfiguration.class)
public interface ProductBClient {

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    void sendOrderNotification(@RequestBody OrderDTO orderDTO);
}
