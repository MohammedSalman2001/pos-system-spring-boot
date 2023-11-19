package com.possystem.possystemapi.service.impl;

import com.possystem.possystemapi.dto.core.OrderDto;
import com.possystem.possystemapi.dto.queryInterfaces.OrderDetailsInterface;
import com.possystem.possystemapi.dto.responseDto.ResponseOrderDetailsDto;
import com.possystem.possystemapi.entity.Item;
import com.possystem.possystemapi.entity.OrderDetails;
import com.possystem.possystemapi.entity.Orders;
import com.possystem.possystemapi.repo.ItemRepo;
import com.possystem.possystemapi.repo.OrderDetailsRepo;
import com.possystem.possystemapi.repo.PlaceOrderRepo;
import com.possystem.possystemapi.service.PlaceOrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PlaceOrderServiceImpl implements PlaceOrderService {

    private final ModelMapper mapper;

    private final OrderDetailsRepo orderDetailsRepo;
    private final PlaceOrderRepo placeOrderRepo;

    private final ItemRepo itemRepo;
    public PlaceOrderServiceImpl(ModelMapper mapper, OrderDetailsRepo orderDetailsRepo, PlaceOrderRepo placeOrderRepo, ItemRepo itemRepo) {
        this.mapper = mapper;
        this.orderDetailsRepo = orderDetailsRepo;
        this.placeOrderRepo = placeOrderRepo;
        this.itemRepo = itemRepo;
    }

    @Override
    @Transactional
    public OrderDto saveOrder(OrderDto orderDto) {
        if(!placeOrderRepo.existsById(orderDto.getOid())){

            Orders orders = mapper.map(orderDto, Orders.class);
            for(OrderDetails orderDetails: orders.getOrderDetails()){
                Item checkQty = itemRepo.findById(orderDetails.getItemCode()).get();
                if(checkQty.getQtyOnHand()>=orderDetails.getQty()){
                    placeOrderRepo.save(orders);

                    if (orderDto.getOrderDetails().size()<1)throw new RuntimeException("No item added");

                    for (OrderDetails details:orders.getOrderDetails()){
                        Item item = itemRepo.findById(orderDetails.getItemCode()).get();
                        item.setQtyOnHand(item.getQtyOnHand()-details.getQty());
                        itemRepo.save(item);
                    }

                } else {
                    throw new RuntimeException("Item Qty Not found");
                }

            }


        }else {
            throw  new RuntimeException("Duplicate Id :" +orderDto.getOid());
        }
        return null;

    }

    @Override
    public void delete(String id) {
        placeOrderRepo.deleteById(id);
    }

    @Override
    public List<OrderDto> findAll() {
        List<Orders> all = placeOrderRepo.findAll();
       return mapper.map(all,new TypeToken<List<OrderDto>>(){}.getType());
    }

    @Override
    public List<ResponseOrderDetailsDto> getOrderDetailsJoinQuery() {
        List<OrderDetailsInterface> allOrderDetails = placeOrderRepo.getAllOrderDetails();
        return mapper.map(allOrderDetails, new TypeToken<List<ResponseOrderDetailsDto>>(){}.getType());
    }


}
