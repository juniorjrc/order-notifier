package com.juniorjrc.ordernotifier.facade;

import com.juniorjrc.ordermodel.dto.OrderDTO;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.juniorjrc.ordermodel.constants.OrderMessageQueue.ORDER_NOTIFIER_QUEUE;

@Component
@AllArgsConstructor
public class OrderNotifierListener {

    private final OrderNotifyFacade orderNotifyFacade;

    @RabbitListener(queues = ORDER_NOTIFIER_QUEUE, autoStartup = "true", concurrency = "3")
    public void processNotification(final OrderDTO orderDTO) {
        this.orderNotifyFacade.notifyOrderInProductB(orderDTO);
    }
}
