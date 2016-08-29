

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.net.*;

public class CheckoutServlet extends HttpServlet
{
    public void service(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException
        {
	        Billing billing = new Billing();
	
	        billing.setCardName(request.getParameter("nameOnCard"));
	        billing.setCreditID(Integer.parseInt(request.getParameter(
	            "creditID")));
	        billing.setExpiration(request.getParameter(
	            "expiration"));
	        billing.setEmail(request.getParameter(
		            "emailAddress"));
	        billing.setPassword(request.getParameter(
		            "password"));
	        
	        HttpSession session = request.getSession();
	        
	        shoppingCart cart =
	                (shoppingCart) session.getAttribute("shoppingCart");

	        if(cart == null)
	        {
	        	cart = new shoppingCart();
	        	session.setAttribute("shoppingCart", cart);
	        	   
	        }
	        try
	        {
	        	String confirmation = cart.completeOrder(billing);
	        	response.sendRedirect(response.encodeRedirectURL(
	                    "/shoppingcart/ShowConfirmation.jsp"+
	                    "?confirmationNumber="+URLEncoder.encode(confirmation)));
	        }
	        catch (ShoppingCartException exc)
	        {
	            PrintWriter out = response.getWriter();

	            out.println("<html><body><h1>Error</h1>");
	            out.println("The following error occurred while "+
	                "processing your order:");
	            out.println("<pre>");
	            out.println(exc.getMessage());
	            out.println("</pre>");
	            out.println("</body></html>");
	            return;
	        }
        }
}