package pfc.virtualshopws.endpoint;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import pfc.virtualshopws.dto.UsersDto;

public enum SSOTokenMap {
	INSTANCE;

	private static final Logger LOGGER = Logger.getLogger(SSOTokenMap.class);

	protected Map<String, SSOToken> tokens = Collections.synchronizedMap(new HashMap<String, SSOToken>());

	private String timeout = "3600000";

	public void deleteToken(String idToken) {
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("[INI] SSOTokenMap deleteToken(String idToken): idToken=[" + idToken + "]");
		}
		synchronized (tokens) {
			tokens.remove(idToken);
		}
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("[END] SSOTokenMap deleteToken(String idToken): idToken=[" + idToken + "]");
		}
	}

	public Map<String, SSOToken> getTokens() {
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("[INI] SSOTokenMap getTokens()");
		}
		synchronized (tokens) {
			if (LOGGER.isInfoEnabled()) {
				LOGGER.info("[END] SSOTokenMap getTokens()");
			}
			return tokens;
		}

	}

	public SSOToken getSSOToken(String id) {
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("[INI] SSOTokenMap getSSOToken(String id): idToken=[" + id + "]");
		}
		synchronized (tokens) {
			if (LOGGER.isInfoEnabled()) {
				LOGGER.info("[END] SSOTokenMap getSSOToken(String id): idToken=[" + id + "]");
			}
			return tokens.get(id);
		}
	}

	public void addSSOToken(SSOToken SSOToken) {
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("[INI] SSOTokenMap addSSOToken(SSOToken SSOToken)");

		}
		synchronized (tokens) {
			if (LOGGER.isInfoEnabled()) {
				LOGGER.info("[END] SSOTokenMap addSSOToken(SSOToken SSOToken)");
			}
			tokens.put(SSOToken.getTokenId(), SSOToken);
		}

	}

	public String addToken(UsersDto user, int userId) {
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("[INI] SSOTokenMap addToken(UsersDto user)");

		}
		cleanUpTokens();
		Date now = new Date();
		SSOToken token = new SSOToken(user, new Date(now.getTime() + Integer.valueOf(timeout)), userId);
		synchronized (tokens) {
			tokens.put(token.getTokenId(), token);
		}
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("[END] SSOTokenMap addToken(UsersDto user)");

		}
		return token.getTokenId();
	}

	public String addTokenById(String tokenId, UsersDto user, int userId) {
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("[INI] SSOTokenMap addTokenById(String tokenId, UsersDto user)");

		}
		cleanUpTokens();
		Date now = new Date();
		SSOToken token = new SSOToken(tokenId, user, new Date(now.getTime() + Integer.valueOf(timeout)), userId);
		synchronized (tokens) {
			tokens.put(token.getTokenId(), token);
		}
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("[END] SSOTokenMap addTokenById(String tokenId, UsersDto user)");

		}
		return token.getTokenId();
	}

	private void cleanUpTokens() {
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("[INI] SSOTokenMap cleanUpTokens()");

		}
		Date now = new Date();
		synchronized (tokens) {
			for (SSOToken token : tokens.values()) {
				if (token.getExpiration().before(now)) {
					tokens.remove(token);
				}
			}
		}
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("[END] SSOTokenMap cleanUpTokens()");

		}

	}

	public void printTokens() {

		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("[INI] SSOTokenMap printTokens()");

		}
		synchronized (tokens) {

			for (SSOToken token : tokens.values()) {
				LOGGER.info("ID:" + token.getTokenId());
				LOGGER.info("USERNAME:" + token.getUser().getEmail());

			}
		}
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("[END] SSOTokenMap printTokens()");

		}
	}

	public UsersDto getUser(String tokenId) {
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("[INI] SSOTokenMap getUser(String tokenId): idToken=[" + tokenId + "]");

		}
		UsersDto user = null;
		synchronized (tokens) {
			if (tokens.containsKey(tokenId)) {
				Date now = new Date();
				if (tokens.get(tokenId).getExpiration().after(now)) {
					user = tokens.get(tokenId).getUser();
					tokens.get(tokenId).getExpiration().setTime(now.getTime() + Integer.valueOf(timeout));
				} else {
					removeToken(tokenId);
				}
			}
		}
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("[END] SSOTokenMap getUser(String tokenId): idToken=[" + tokenId + "]");

		}
		return user;
	}

	public void clearTokens() {
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("[INI] SSOTokenMap clearTokens()");

		}
		synchronized (tokens) {
			tokens.clear();
		}
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("[END] SSOTokenMap clearTokens()");

		}
	}

	public void removeToken(String tokenId) {
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("[INI] SSOTokenMap removeToken(String tokenId): idToken=[" + tokenId + "]");

		}
		synchronized (tokens) {
			if (tokens.containsKey(tokenId)) {
				tokens.remove(tokenId);
			}
		}
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("[END] SSOTokenMap removeToken(String tokenId): idToken=[" + tokenId + "]");

		}
	}

	public String getTimeout() {
		return timeout;
	}

	public void setTimeout(String timeout) {
		this.timeout = timeout;
	}

}
