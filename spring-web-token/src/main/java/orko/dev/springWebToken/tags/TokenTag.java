package orko.dev.springWebToken.tags;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import orko.dev.springWebToken.TokenManager;
import orko.dev.springWebToken.TokenManagerImpl;



public class TokenTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int doStartTag() throws JspException{
		TokenManager iToken = new TokenManagerImpl();
		HttpSession session = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
		try {
			pageContext.getOut().write("<input type=\"hidden\"  name=\""+iToken.getTokenKey()+"\"" +
					"  value=\""+session.getAttribute(iToken.getTokenKey())+"\" />");
		} catch (IOException e) {
			throw new JspTagException("An IOException occurred.");
		}
		return Tag.SKIP_BODY;
	}

}
