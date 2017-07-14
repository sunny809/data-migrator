<#list root as order>
INSERT INTO AISOI_ORDER_HEADER  (order_id, order_code, user_id, user_cn,type,status, thetime, is_pay, AdjustedPrice, deduct, discount, remarks, province, city,area, shipName, address, telPhone, celPhone) 
VALUES 
(${order.orderId?string["000"]}, ‘${order.orderCode}’,'${order.BuyerId}','${order.BuyerName}',${order.OrderType},${order.OrderStatus},'${order.CreatedDate}',0,0,'','${order.ShipRegion}','${order.ShipRegion}','${order.ShipAddress}','${order.ShipTelPhone}','${order.ShipCellPhone}');
</#list>