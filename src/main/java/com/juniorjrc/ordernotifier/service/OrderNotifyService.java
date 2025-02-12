package com.juniorjrc.ordernotifier.service;

import com.juniorjrc.ordernotifier.clients.OrderServiceClient;
import com.juniorjrc.ordernotifier.clients.ProductBClient;
import com.juniorjrc.ordermodel.dto.OrderDTO;
import com.juniorjrc.ordermodel.dto.UpdateOrderStatusRequestDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.juniorjrc.ordermodel.enums.OrderStatusEnum.NOTIFICATION_ERROR;

@Service
@AllArgsConstructor
public class OrderNotifyService {

    private static final String ERROR_NOTIFYING_PRODUCT_B = "Error notifying product B . Details: %s";

    private final ProductBClient productBClient;
    private final OrderServiceClient orderServiceClient;

    public void notifyOrderInProductB(final OrderDTO orderDTO) {
        try {
            this.productBClient.sendOrderNotification(orderDTO);
        } catch (Exception e) {
            this.orderServiceClient.updateOrderStatus(
                    orderDTO.id(),
                    new UpdateOrderStatusRequestDTO(NOTIFICATION_ERROR, String.format(ERROR_NOTIFYING_PRODUCT_B, e.getMessage())));
        }
    }
}
