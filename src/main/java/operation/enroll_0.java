package operation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.FollowJDBC;
import dao.Invitation;
import dao.InvitationJDBC;
import dao.User;
import dao.UserJDBCtemplate;

@Controller
@RequestMapping(value = "/operation")
public class enroll_0 {
	//关于登录的接口
	@RequestMapping(value = "/enroll")
	public @ResponseBody boolean enroll(String id,String pw,HttpServletRequest request) {
		@SuppressWarnings("resource")
		ApplicationContext recontext = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserJDBCtemplate userJDBCtemplate = (UserJDBCtemplate)recontext.getBean("UserJDBCtemplate");
		User user = userJDBCtemplate.record(id,pw);
		if(user != null) {
			request.getSession().setAttribute("id", id);
			request.getSession().setAttribute("pw", pw);
//			System.out.println(user.getName());
			return true;
		}else return false;
	}
	
	
	//关于加载的接口
	@RequestMapping(value = "/invitations")
	public @ResponseBody Map<String, Object> invitations(HttpServletRequest request) {
		@SuppressWarnings("resource")
		ApplicationContext recontext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//打开查找帖子的对象
		InvitationJDBC invitationJDBC= (InvitationJDBC) recontext.getBean("invitationJDBC");
		//打开查找用户的对象
		UserJDBCtemplate userJDBCtemplate = (UserJDBCtemplate)recontext.getBean("UserJDBCtemplate");
		//打开查找关注的对象
		FollowJDBC followJDBC = (FollowJDBC) recontext.getBean("followJDBC");
		List<Invitation> invitations = (List<Invitation>) invitationJDBC.lookinvitations();
		User users = null;
		int follows = 0;
		int coverfollows = 0;
		List<Invitation> myinvitations = null;
		if(request.getSession().getAttribute("id")!=null) {
			users = userJDBCtemplate.record("" + request.getSession().getAttribute("id"),"" + request.getSession().getAttribute("pw"));
			follows = followJDBC.lookfollow("" + request.getSession().getAttribute("id")).size();
			coverfollows = followJDBC.coverlookfollow("" + request.getSession().getAttribute("id")).size();
			myinvitations = invitationJDBC.lookmyinvitations("" + request.getSession().getAttribute("id"));
		}
		for(Invitation x : invitations) {
			x.setName(userJDBCtemplate.chaname(x.getAccount()).getName());
		}
		
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("invitation",invitations);
		map.put("user", users);
		map.put("follow",follows);
		map.put("coverfollows", coverfollows);
		map.put("myinvitations", myinvitations);
		return map;
	}
}

