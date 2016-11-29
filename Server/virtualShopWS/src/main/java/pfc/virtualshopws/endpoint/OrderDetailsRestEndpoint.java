package pfc.virtualshopws.endpoint;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import pfc.virtualshopws.entity.OrderDetails;
import pfc.virtualshopws.service.OrderDetailsService;

@Controller
@Path("orderDetails")
public class OrderDetailsRestEndpoint {

	@Autowired
	private OrderDetailsService orderDetailsService;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	@Consumes("application/json")
	public OrderDetails findById(@PathParam("id") Long id) {
		return orderDetailsService.findById(id);
	}

	@GET
	@Path("/response/{id}")
	@Produces("application/json")
	@Consumes("application/json")
	public Response findByIdResponse(@PathParam("id") Long id) {
		OrderDetails orderDetail = orderDetailsService.findById(id);

		return Response.status(HttpStatus.ACCEPTED.value()).entity(orderDetail).build();
	}

	@GET
	@Path("")
	@Produces("application/json")
	@Consumes("application/json")
	public List<OrderDetails> findAll() {
		return orderDetailsService.findAll();
	}

	@Transactional
	@POST
	@Path("")
	@Produces("application/json")
	@Consumes("application/json")
	public OrderDetails create(@RequestParam OrderDetails orderDetail) {
		return orderDetailsService.create(orderDetail);
	}

	@Transactional
	@PUT
	@Path("{id}")
	@Produces("application/json")
	@Consumes("application/json")
	public OrderDetails update(@RequestParam OrderDetails orderDetail, @PathParam("id") Long id) {
		OrderDetails orderDetailRecovered = orderDetailsService.findById(id);
		orderDetail.setOrderDetailId(id);
		BeanUtils.copyProperties(orderDetail, orderDetailRecovered);

		return orderDetailsService.update(orderDetailRecovered);
	}

	@Transactional
	@DELETE
	@Path("{id}")
	@Produces("application/json")
	@Consumes("application/json")
	public Boolean delete(@PathParam("id") Long id) {
		OrderDetails orderDetailRecovered = orderDetailsService.findById(id);
		orderDetailsService.delete(orderDetailRecovered);

		return true;
	}

	@GET
	@Path("orderId/{id}")
	@Produces("application/json")
	@Consumes("application/json")
	public Response getProductsIdByOrderId(@PathParam("id") Long orderId, @Context HttpServletRequest req) {
		String ssoTokenReqId = req.getHeader("Authorization");
		if (orderId != null) {
			if (SSOTokenMap.INSTANCE.getUser(ssoTokenReqId) != null) {
				// si el user está logueado, renovamos la sesión
				Date expirationTime = new Date();
				expirationTime.setTime(expirationTime.getTime() + (3600 * 1000));
				SSOTokenMap.INSTANCE.getSSOToken(ssoTokenReqId).setExpiration(expirationTime);
				// devolvemos los productsId según el OrderId
				List<Long> orderDetails = orderDetailsService.getProductsIdByOrderId(orderId);
				return Response.status(HttpStatus.ACCEPTED.value()).entity(orderDetails).build();
			} else {
				return Response.status(HttpStatus.FORBIDDEN.value()).build();
			}
		} else {
			return Response.status(HttpStatus.ACCEPTED.value()).build();
		}
	}

	@GET
	@Path("orderDetailsOrderId/{id}")
	@Produces("application/json")
	@Consumes("application/json")
	public Response getOrderDetailsByOrderId(@PathParam("id") Long orderId) {
		if (orderId != null) {
			List<OrderDetails> orderDetails = orderDetailsService.getOrderDetailsByOrderId(orderId);
			return Response.status(HttpStatus.ACCEPTED.value()).entity(orderDetails).build();
		} else {
			return Response.status(HttpStatus.ACCEPTED.value()).build();
		}

	}

}
