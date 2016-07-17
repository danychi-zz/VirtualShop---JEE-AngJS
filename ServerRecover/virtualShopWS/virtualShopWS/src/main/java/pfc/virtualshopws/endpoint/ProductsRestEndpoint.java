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

import pfc.virtualshopws.entity.Products;
import pfc.virtualshopws.service.ProductsService;

@Controller
@Path("products")
public class ProductsRestEndpoint {
	@Autowired
	private ProductsService productsService;

	@GET
	@Path("/{id}")
	@Produces("application/json")
	@Consumes("application/json")
	public Products findById(@PathParam("id") Long id) {

		return productsService.findById(id);

	}

	@GET
	@Path("/response/{id}")
	@Produces("application/json")
	@Consumes("application/json")
	public Response findByIdResponse(@PathParam("id") Long id) {

		Products product = productsService.findById(id);

		return Response.status(HttpStatus.ACCEPTED.value()).entity(product).build();

	}

	@GET
	@Path("")
	@Produces("application/json")
	@Consumes("application/json")
	public List<Products> findAll() {

		return productsService.findAll();

	}

	@Transactional
	@POST
	@Path("")
	@Produces("application/json")
	@Consumes("application/json")
	public Products create(@RequestParam Products product) {

		return productsService.create(product);

	}

	@Transactional
	@PUT
	@Path("{id}")
	@Produces("application/json")
	@Consumes("application/json")
	public Products update(@RequestParam Products product, @PathParam("id") Long id) {

		Products productRecovered = productsService.findById(id);
		product.setProductId(id);
		BeanUtils.copyProperties(product, productRecovered);

		return productsService.update(productRecovered);
	}

	@Transactional
	@DELETE
	@Path("{id}")
	@Produces("application/json")
	@Consumes("application/json")
	public Boolean delete(@PathParam("id") Long id) {

		Products productRecovered = productsService.findById(id);

		productsService.delete(productRecovered);

		return true;

	}

	// ########## MÉTODOS AGREGADOS ##########
	@POST
	@Path("productsId")
	@Produces("application/json")
	@Consumes("application/json")
	public Response getProductsByProductsId(@RequestParam List<Long> productsId) {

		if (productsId != null) {
			List<Products> products = productsService.getProductsByProductsId(productsId);
			return Response.status(HttpStatus.ACCEPTED.value()).entity(products).build();
		} else {
			return Response.status(HttpStatus.ACCEPTED.value()).build();
		}

	}

}
