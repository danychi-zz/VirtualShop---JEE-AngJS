package pfc.virtualshopws.endpoint;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import pfc.virtualshopws.entity.PaymentDetails;
import pfc.virtualshopws.service.PaymentDetailsService;

@Controller
@Path("paymentDetails")
public class PaymentDetailsRestEndpoint {
	@Autowired
	private PaymentDetailsService paymentDetailsService;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	@Consumes("application/json")
	public PaymentDetails findById(@PathParam("id") Long id) {
		return paymentDetailsService.findById(id);
	}

	@GET
	@Path("/response/{id}")
	@Produces("application/json")
	@Consumes("application/json")
	public Response findByIdResponse(@PathParam("id") Long id) {
		PaymentDetails paymentDetail = paymentDetailsService.findById(id);

		return Response.status(HttpStatus.ACCEPTED.value()).entity(paymentDetail).build();
	}

	@GET
	@Path("")
	@Produces("application/json")
	@Consumes("application/json")
	public List<PaymentDetails> findAll() {
		return paymentDetailsService.findAll();
	}

	@Transactional
	@POST
	@Path("")
	@Produces("application/json")
	@Consumes("application/json")
	public PaymentDetails create(@RequestParam PaymentDetails paymentDetail) {
		return paymentDetailsService.create(paymentDetail);
	}

	@Transactional
	@PUT
	@Path("{id}")
	@Produces("application/json")
	@Consumes("application/json")
	public PaymentDetails update(@RequestParam PaymentDetails paymentDetail, @PathParam("id") Long id) {
		PaymentDetails paymentDetailRecovered = paymentDetailsService.findById(id);
		paymentDetail.setPaymentDetailId(id);
		BeanUtils.copyProperties(paymentDetail, paymentDetailRecovered);

		return paymentDetailsService.update(paymentDetailRecovered);
	}

	@Transactional
	@DELETE
	@Path("{id}")
	@Produces("application/json")
	@Consumes("application/json")
	public Boolean delete(@PathParam("id") Long id) {
		PaymentDetails paymentDetailRecovered = paymentDetailsService.findById(id);
		paymentDetailsService.delete(paymentDetailRecovered);

		return true;
	}
	// ########## MÉTODOS AGREGADOS ##########

	@GET
	@Path("orderId/{id}")
	@Produces("application/json")
	@Consumes("application/json")
	public Response findPaymentDetailByOrderId(@PathParam("id") Long orderId) {
		PaymentDetails paymentDetails = paymentDetailsService.findPaymentDetailByOrderId(orderId);
		return Response.status(HttpStatus.ACCEPTED.value()).entity(paymentDetails).build();
	}

}
