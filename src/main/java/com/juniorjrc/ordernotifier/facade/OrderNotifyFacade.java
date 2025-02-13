package com.juniorjrc.ordernotifier.facade;

import com.juniorjrc.ordernotifier.service.OrderNotifyService;
import com.juniorjrc.ordermodel.dto.OrderDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderNotifyFacade {

    private final OrderNotifyService orderNotifyService;

    public void notifyOrderInProductB(final OrderDTO orderDTO) {
        this.orderNotifyService.notifyOrderInProductB(orderDTO);
    }
}
