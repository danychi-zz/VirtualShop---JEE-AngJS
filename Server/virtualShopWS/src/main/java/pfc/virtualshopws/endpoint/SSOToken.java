package pfc.virtualshopws.endpoint;

import java.util.Date;
import java.util.Random;

import pfc.virtualshopws.dto.UsersDto;

public class SSOToken {

	private String tokenId;
	private UsersDto user;
	private Date expiration;
	private long userId;

	public SSOToken(UsersDto user, Date expiration, long userId) {
		super();
		Random random = new Random();

		this.tokenId = new String("" + Math.abs(random.nextInt()));
		this.user = user;
		this.expiration = expiration;
		this.userId = userId;

	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public SSOToken(String tokenId, UsersDto user, Date expiration, long userId) {
		super();

		this.tokenId = tokenId;
		this.user = user;
		this.expiration = expiration;
		this.userId = userId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public SSOToken() {
		super();
	}

	public UsersDto getUser() {
		return user;
	}

	public void setUser(UsersDto user) {
		this.user = user;
	}

	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	public String getTokenId() {
		return tokenId;
	}
}