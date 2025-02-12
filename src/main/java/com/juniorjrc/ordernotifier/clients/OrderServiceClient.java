package com.juniorjrc.ordernotifier.clients;

import com.juniorjrc.ordernotifier.config.feign.BasicFeignClientConfiguration;
import com.juniorjrc.ordermodel.dto.UpdateOrderStatusRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(name = "order-service-client", url = "${api.clients.order-service.url}/order",
        configuration = BasicFeignClientConfiguration.class)
public interface OrderServiceClient {

    @PutMapping("/status/{orderId}")
    void updateOrderStatus(@PathVariable("orderId") final Long orderId,
                           @RequestBody UpdateOrderStatusRequestDTO updateOrderStatusRequestDTO);
}
