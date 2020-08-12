package operation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.Follow;
import dao.FollowJDBC;
import dao.Invitation;
import dao.InvitationJDBC;
import dao.User;
import dao.UserJDBCtemplate;

@Controller
@RequestMapping(value = "personal")
public class space {
	//更改用户
	@RequestMapping(value = "updateuser")
//	public @ResponseBody boolean updateuser(@RequestBody User user) {
	public @ResponseBody boolean updateuser(String name,String gender,String mailbox,String birthday,String personality,HttpServletRequest request){
		if(request.getSession().getAttribute("id")!=null) {
			@SuppressWarnings("resource")
			ApplicationContext recontext = new ClassPathXmlApplicationContext("applicationContext.xml");
			UserJDBCtemplate userJDBCtemplate = (UserJDBCtemplate)recontext.getBean("UserJDBCtemplate");
			User users = userJDBCtemplate.record("" + request.getSession().getAttribute("id"),"" + request.getSession().getAttribute("pw"));
			userJDBCtemplate.modify(""+request.getSession().getAttribute("id"), "name", name, users.getName());
			userJDBCtemplate.modify(""+request.getSession().getAttribute("id"), "gender",gender, users.getGender());
			userJDBCtemplate.modify(""+request.getSession().getAttribute("id"), "mailbox", mailbox, users.getMailbox());
			userJDBCtemplate.modify(""+request.getSession().getAttribute("id"), "birthday", birthday, users.getBirthday());
			userJDBCtemplate.modify(""+request.getSession().getAttribute("id"), "personality", personality, users.getPersonality());
			return true;
			}else {
			return false;
			}
		}
	//获取用户资源
	@RequestMapping(value = "uesr")
	public @ResponseBody User lookuser(HttpServletRequest request) {
		@SuppressWarnings("resource")
		ApplicationContext recontext = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserJDBCtemplate userJDBCtemplate = (UserJDBCtemplate)recontext.getBean("UserJDBCtemplate");
		User users = null;
		if(request.getSession().getAttribute("id")!=null) {
			users = userJDBCtemplate.record("" + request.getSession().getAttribute("id"),"" + request.getSession().getAttribute("pw"));
		}
//		System.out.println(users);
		return users;
	}
	
	//获取资源的帖子
	@RequestMapping(value = "my")
	public @ResponseBody Map<String, Object> lookmyin(HttpServletRequest request){
//		System.out.println(1);
		@SuppressWarnings("resource")
		ApplicationContext recontext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//打开查找帖子的对象
		InvitationJDBC invitationJDBC= (InvitationJDBC) recontext.getBean("invitationJDBC");
		//打开查找用户的对象
		UserJDBCtemplate userJDBCtemplate = (UserJDBCtemplate)recontext.getBean("UserJDBCtemplate");
		//打开查找关注的对象
		FollowJDBC followJDBC = (FollowJDBC) recontext.getBean("followJDBC");
		List<Invitation> invitations = null;
		User users = null;
		int follows = 0;
		int coverfollows = 0;
		if(request.getSession().getAttribute("id")!=null) {
			invitations = (List<Invitation>) invitationJDBC.lookmyinvitations("" + request.getSession().getAttribute("id"));
			users = userJDBCtemplate.record("" + request.getSession().getAttribute("id"),"" + request.getSession().getAttribute("pw"));
			follows = followJDBC.lookfollow("" + request.getSession().getAttribute("id")).size();
			coverfollows = followJDBC.coverlookfollow("" + request.getSession().getAttribute("id")).size();
			for(Invitation x : invitations) {
				x.setName(userJDBCtemplate.chaname(x.getAccount()).getName());
			}
		}
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("invitation",invitations);
		map.put("user", users);
		map.put("follow",follows);
		map.put("coverfollows", coverfollows);
		return map;
	}
	
	//发表帖子
	@RequestMapping(value = "sand")
	public @ResponseBody boolean sand(String title,String subtitle,String content,HttpServletRequest request) throws IOException{
		if(request.getSession().getAttribute("id")!=null) {
			Random random = new Random();
			@SuppressWarnings("resource")
			ApplicationContext recontext = new ClassPathXmlApplicationContext("applicationContext.xml");
			InvitationJDBC invitationJDBC= (InvitationJDBC) recontext.getBean("invitationJDBC");
			Invitation invitation =null;
			int s;
			do {
				s = random.nextInt(1000000)%(1000000-100000+1) + 100000;
				invitation = invitationJDBC.lookinvitation(""+s);
			} while (invitation != null);
			String text = "C:\\Users\\Administrator\\Desktop\\关于编程\\java\\maven\\src\\main\\webapp\\txt\\"+s+".txt";
			File file = new File(text);
			FileWriter fw = new FileWriter(file);
			fw.write(content);
			fw.close();
			String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			invitationJDBC.publishinvitation(""+s, "" + request.getSession().getAttribute("id"), time, title, subtitle, text);
			return true;
		}
		else {
			return false;
		}
	}
	
	//看关注我的人
	@RequestMapping(value = "follow")
	public @ResponseBody Map<String, Object> follow(HttpServletRequest request){
		if(request.getSession().getAttribute("id")!=null) {
		@SuppressWarnings("resource")
		ApplicationContext recontext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//打开查找用户的对象
		UserJDBCtemplate userJDBCtemplate = (UserJDBCtemplate)recontext.getBean("UserJDBCtemplate");
		FollowJDBC followJDBC = (FollowJDBC) recontext.getBean("followJDBC");
		List<Follow> follows = followJDBC.lookfollow("" + request.getSession().getAttribute("id"));
		User users = userJDBCtemplate.record("" + request.getSession().getAttribute("id"),"" + request.getSession().getAttribute("pw"));
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("user", users);
		map.put("follow",follows);
		return map;}
		else {
			return null;
		}
	}
	//粉丝
	@RequestMapping(value = "fans")
	public @ResponseBody Map<String, Object> fans(HttpServletRequest request){
		if(request.getSession().getAttribute("id")!=null) {
		@SuppressWarnings("resource")
		ApplicationContext recontext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//打开查找用户的对象
		UserJDBCtemplate userJDBCtemplate = (UserJDBCtemplate)recontext.getBean("UserJDBCtemplate");
		FollowJDBC followJDBC = (FollowJDBC) recontext.getBean("followJDBC");
		List<Follow> follows = followJDBC.coverlookfollow("" + request.getSession().getAttribute("id"));
		User users = userJDBCtemplate.record("" + request.getSession().getAttribute("id"),"" + request.getSession().getAttribute("pw"));
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("user", users);
		map.put("follow",follows);
		return map;}
		else {
			return null;
		}
	}
}
