package orko.dev.springWebToken.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import orko.dev.springWebToken.TokenManager;
import orko.dev.springWebToken.TokenManagerImpl;
import orko.dev.springWebToken.exception.ExceptionToken;
import orko.dev.springWebToken.exception.InvalidTokenException;

public class TokenWebValidator {

	public void validateToken() throws ExceptionToken{
		TokenManager iTokenManager = new TokenManagerImpl();
		HttpSession session = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		String requestToken = request.getParameter(iTokenManager.getTokenKey());
		if (requestToken == null){
			throw new ExceptionToken("No se ha seteado el token para la request.");
		}
		String sessionToken = (String) session.getAttribute(iTokenManager.getTokenKey());
		if (sessionToken == null){
			throw new ExceptionToken("No se ha seteado el token para la sesión.");
		}
		if (sessionToken.equals(requestToken)) {
			session.setAttribute(iTokenManager.getTokenKey(), iTokenManager.nextToken());
		}else{
			throw new InvalidTokenException("Token Invalido");
		}
	}

}
