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
@Table(name = "products", schema = "untitled")
public class Products implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "PRODUCT_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long productId;

	@Column(name = "PRODUCTNAME")
	private String productname;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "CATEGORY")
	private String category;

	@Column(name = "IMAGE")
	private String image;

	@Column(name = "AUTHOR")
	private String author;

	@Column(name = "PRICE")
	private Long price;

	@Column(name = "TYPE")
	private String type;

	// GETTERS AND SETTERS

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
