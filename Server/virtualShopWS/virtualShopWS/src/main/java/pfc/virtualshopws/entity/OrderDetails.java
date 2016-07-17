package pfc.virtualshopws.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "orderdetails", schema = "untitled")
public class OrderDetails implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ORDER_DETAIL_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderDetailId;

	@Column(name = "ACTIVE")
	private Boolean active = true;

	@Column(name = "ORDER_ID")
	private Long orderId;

	@Column(name = "PRODUCT_ID")
	private Long productId;

	@Column(name = "QUANTITY")
	private Long quantity;

	@Column(name = "TOTAL")
	private BigDecimal total;

	// GETTER AMD SETTER

	public Long getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(Long orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

}
