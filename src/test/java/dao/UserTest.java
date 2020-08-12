package dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
	@Test
	public void TestUserjdbc() {		
		@SuppressWarnings("resource")
		ApplicationContext recontext = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserJDBCtemplate userJDBCtemplate = (UserJDBCtemplate)recontext.getBean("UserJDBCtemplate");
		User user = userJDBCtemplate.record("840359379","123456");
		System.out.println(user.getName());
		assertEquals("盛建辉", user.getName());
	}
	@Test
	public void TestInvitationJDBC() {
		@SuppressWarnings("resource")
		ApplicationContext recontext = new ClassPathXmlApplicationContext("applicationContext.xml");
		InvitationJDBC invitationJDBC= (InvitationJDBC) recontext.getBean("invitationJDBC");
		Invitation invitation = invitationJDBC.lookinvitation("100001");
		assertEquals("论真理",invitation.getTitle());
	}
	@Test
	public void TestFollowJDBC() {
		@SuppressWarnings("resource")
		ApplicationContext recontext = new ClassPathXmlApplicationContext("applicationContext.xml");
		FollowJDBC followJDBC = (FollowJDBC) recontext.getBean("followJDBC");
		List<Follow> follows = followJDBC.lookfollow("840359379");
		List<Follow> follows2 = followJDBC.coverlookfollow("840359379");
		System.out.println(follows.size());
		System.out.println(follows2.size());
		assertEquals(2, follows.size());
	}
	@Test 
	public void TextGoodJDBC() {
		@SuppressWarnings("resource")
		ApplicationContext recontext = new ClassPathXmlApplicationContext("applicationContext.xml");
		GoodJDBC goodJDBC = (GoodJDBC) recontext.getBean("goodJDBC");
		List<Good> goods = goodJDBC.lookgoodat("840359379");
		assertEquals(2,goods.size());
	}
	@Test
	public void TestInvitationJDBC_2() {
		@SuppressWarnings("resource")
		ApplicationContext recontext = new ClassPathXmlApplicationContext("applicationContext.xml");
		InvitationJDBC invitationJDBC= (InvitationJDBC) recontext.getBean("invitationJDBC");
		UserJDBCtemplate userJDBCtemplate = (UserJDBCtemplate)recontext.getBean("UserJDBCtemplate");
		List<Invitation> invitations = (List<Invitation>) invitationJDBC.lookinvitations();
		for(Invitation x : invitations) {
			x.setName(userJDBCtemplate.chaname(x.getAccount()).getName());
		}
		System.out.println(invitations);
		assertEquals("盛建辉",invitations.get(0).getName());
	}
}
