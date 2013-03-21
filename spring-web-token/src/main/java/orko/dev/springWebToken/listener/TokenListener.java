package orko.dev.springWebToken.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import orko.dev.springWebToken.TokenManager;
import orko.dev.springWebToken.TokenManagerImpl;



public class TokenListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent sessionEvent) {
		HttpSession session = sessionEvent.getSession();
		TokenManager iTokenManager = new TokenManagerImpl();
		session.setAttribute(iTokenManager.getTokenKey(),iTokenManager.nextToken());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
