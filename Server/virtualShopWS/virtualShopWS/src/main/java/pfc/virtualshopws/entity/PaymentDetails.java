package pfc.virtualshopws.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "paymentdetails", schema = "untitled")
public class PaymentDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "PM_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long paymentDetailId;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "ORDER_ID")
	private Long orderId;

	@Column(name = "NUMBER")
	private Long number;

	@Column(name = "EXP_DATE")
	private String expDate;

	@Column(name = "HOLDER_NAME")
	private String holderName;

	public Long getPaymentDetailId() {
		return paymentDetailId;
	}

	public void setPaymentDetailId(Long paymentDetailId) {
		this.paymentDetailId = paymentDetailId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

}
