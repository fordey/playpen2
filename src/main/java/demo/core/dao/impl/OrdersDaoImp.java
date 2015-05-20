package demo.core.dao.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import demo.core.dao.api.OrdersDao;
import demo.core.domain.Order;
import demo.core.domain.OrderLineItem;

@Repository
public class OrdersDaoImp implements OrdersDao {

	private List<Order> dummyOrders = new ArrayList<Order>();
	
	@Override
	public List<Order> getOrders() {
		// TODO Auto-generated method stub
		return dummyOrders;
	}

	@PostConstruct
	public void createDummyOrders(){
		//create 10 orders
		
		for (int i=0;i<10;i++){
			Order order = createSingleOrder(i, String.format("Dummy Desc For Order: %s : Date : %s", i, 
					new SimpleDateFormat("dd-MM-yyyy").format(new Date())));
			
			setOrderLineItems(order);
			
			dummyOrders.add(order);
		}
		
	}
	
	private Order createSingleOrder(Integer orderId, String description){
		Order order = new Order();
		order.setOrderId(orderId);
		order.setDescription(description);
		
		return order;
		
	}
	
	private void setOrderLineItems(Order order){
		//2 order lines per order
		
		OrderLineItem lineItem = new OrderLineItem();
		lineItem.setLineItemDescription(order.getOrderId() + ": line item 1");
		lineItem.setPrice(new BigDecimal(100));
		lineItem.setQuantity(1);
		
		OrderLineItem lineItem2 = new OrderLineItem();
		lineItem2.setLineItemDescription(order.getOrderId() + ": line item 2");
		lineItem2.setPrice(new BigDecimal(100));
		lineItem2.setQuantity(1);
		
		order.setLineItems(Arrays.asList(lineItem, lineItem2));
		
	}
}
