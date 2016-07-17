package pfc.virtualshopws.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "orders", schema = "untitled")
public class Orders implements Serializable {
	private static final long serialVersionUID = 1L;

	public Orders() {
	}

	public Orders(long userId, BigDecimal total) {
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		Date today = Calendar.getInstance().getTime();
		this.orderDate = df.format(today);
		this.userId = userId;
		this.statusId = (long) 1;
		this.total = total;
	}

	@Id
	@Column(name = "ORDER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;

	@Column(name = "STATUS_ID")
	private Long statusId;

	@Column(name = "USER_ID")
	private Long userId;

	@Column(name = "TOTAL")
	private BigDecimal total;

	@Column(name = "ORDER_DATE")
	private String orderDate;

	@Column(name = "ACTIVE")
	private long active = 1;

	@Transient
	private List<OrderDetails> orderDetails = new ArrayList<OrderDetails>();

	@Transient
	private PaymentDetails paymentDetail = new PaymentDetails();

	// GETTERS AND SETTERS

	public PaymentDetails getPaymentDetail() {
		return paymentDetail;
	}

	public void setPaymentDetail(PaymentDetails paymentDetail) {
		this.paymentDetail = paymentDetail;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getStatusId() {
		return statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public long getActive() {
		return active;
	}

	public void setActive(long active) {
		this.active = active;
	}

	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

}
