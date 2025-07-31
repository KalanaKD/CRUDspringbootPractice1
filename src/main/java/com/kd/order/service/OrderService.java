package com.kd.order.service;

import com.kd.order.dto.OrderDTO;
import com.kd.order.model.Orders;
import com.kd.order.repo.OrderRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<OrderDTO> getOrders(){
        List<Orders> orderList = orderRepo.findAll();
        return modelMapper.map(orderList, new TypeToken<List<OrderDTO>>(){}.getType());
    }

    public OrderDTO updateOrder(OrderDTO orderDTO){
        orderRepo.save(modelMapper.map(orderDTO, Orders.class));
        return orderDTO;
    }
    public String deleteOrder(Integer orderDTO){
        orderRepo.deleteById(orderDTO);
        return "Item deleted successfully";
    }
    public OrderDTO getOrderById(Integer orderId){
        Orders order = orderRepo.getOrderById(orderId);
        return modelMapper.map(order, OrderDTO.class );
    }

    public OrderDTO saveOrder(OrderDTO orderDTO) {
        orderRepo.save(modelMapper.map(orderDTO, Orders.class));
        return orderDTO;
    }
}
