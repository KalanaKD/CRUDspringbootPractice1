package com.kd.order.controller;

import com.kd.order.dto.OrderDTO;
import com.kd.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/getorders")
    public List<OrderDTO> getOrders(){
        return orderService.getOrders();
    }

    @GetMapping("/getorder/{orderId}")
    public OrderDTO getOrder(@PathVariable("orderId") Integer orderId){
        return orderService.getOrderById(orderId);
    }

    @PostMapping("/addorder")
    public String addOrder(@RequestBody OrderDTO orderDTO){
        orderService.saveOrder(orderDTO);
        return "order added successfully ";
    }

    @PutMapping("/updateOrder")
    public OrderDTO updateOrder(@RequestBody OrderDTO orderDTO){
        orderService.updateOrder(orderDTO);
        return orderDTO;
    }

    @DeleteMapping("/deleteorder/{orderId}")
    public String deleteOrder(@PathVariable("orderId") Integer orderId){
        orderService.deleteOrder(orderId);
        return "order deleted successfully ";
    }

}
