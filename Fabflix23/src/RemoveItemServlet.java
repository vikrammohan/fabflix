

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class RemoveItemServlet extends HttpServlet
{
	public void service(HttpServletRequest request,
		HttpServletResponse response)
		throws IOException, ServletException
	{
		int itemIndex = Integer.parseInt(request.getParameter("item"));
		
		HttpSession session = request.getSession();
		
		shoppingCart cart = (shoppingCart) session.getAttribute("shoppingCart");
		
		if(cart == null)
		{
			cart = new shoppingCart();
			session.setAttribute("shoppingCart", cart);
			
		}
		
		cart.removeItem(itemIndex);
		response.sendRedirect(response.encodeRedirectURL("/shoppingcart/ShowCartAfterREmove.jsp"));
	}
}