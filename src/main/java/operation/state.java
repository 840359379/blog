package operation;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class state {
	@RequestMapping(value = "/state")
	public void handle(HttpServletRequest request,HttpServletResponse response) throws IOException {
		if(request.getSession().getAttribute("id")!=null) {
			request.getSession().removeAttribute("id");
			request.getSession().removeAttribute("pw");
		}
		response.sendRedirect("http://localhost:8080/maven/core/landing.html");
	}
}
