package operation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.Good;
import dao.GoodJDBC;
import dao.Invitation;
import dao.InvitationJDBC;
import dao.User;
import dao.UserJDBCtemplate;

@Controller
@RequestMapping(value = "article")
public class LookArticle {
	@RequestMapping(value = "look")
	public @ResponseBody Map<String, Object> look(String id,HttpServletRequest request) throws IOException{
		@SuppressWarnings("resource")
		ApplicationContext recontext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//加载帖子
		InvitationJDBC invitationJDBC= (InvitationJDBC) recontext.getBean("invitationJDBC");
		UserJDBCtemplate userJDBCtemplate = (UserJDBCtemplate) recontext.getBean("UserJDBCtemplate");
		//发帖人
		Invitation invitation = invitationJDBC.lookinvitation(id);
		//点赞
		GoodJDBC goodJDBC = (GoodJDBC) recontext.getBean("goodJDBC");
		List<Good> goods = goodJDBC.lookgoodnr(id);
		//拿到储存的文章
		User user = userJDBCtemplate.chaname(invitation.getAccount());
		FileInputStream x = new FileInputStream(invitation.getText());
		InputStreamReader reader = new InputStreamReader(x,"UTF-8");
		@SuppressWarnings("resource")
		BufferedReader buffReader = new BufferedReader(reader);
        String strTmp = "";
        String y = "";
        while((strTmp = buffReader.readLine())!=null){
        	y = y + strTmp;
        }
//        System.out.println(y);
        //获得此时登录状态
        User users = null;
		if(request.getSession().getAttribute("id")!=null) {
			users = userJDBCtemplate.record("" + request.getSession().getAttribute("id"),"" + request.getSession().getAttribute("pw"));
		}
		Map<String, Object> map = new HashMap<String,Object>();
		invitation.setText(y);
		map.put("user", user);
		map.put("invitation", invitation);
		map.put("goods", goods);
		map.put("my", users);
		return map;
	}
	
	//搜索帖子
	@RequestMapping(value = "search")
	public @ResponseBody List<Invitation> search(String id,HttpServletRequest request){
		@SuppressWarnings("resource")
		ApplicationContext recontext = new ClassPathXmlApplicationContext("applicationContext.xml");
//		System.out.println(id);
		//加载帖子
		InvitationJDBC invitationJDBC= (InvitationJDBC) recontext.getBean("invitationJDBC");
		List<Invitation> invitations = invitationJDBC.seekinvitations(id);
		return invitations;
	}
}
