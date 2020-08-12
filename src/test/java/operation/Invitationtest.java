package operation;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class Invitationtest {
	@Test
	public void Invitationt() throws IOException {
		FileInputStream x = new FileInputStream("src/main/java/txt/100001.txt");
		InputStreamReader reader = new InputStreamReader(x);
		BufferedReader buffReader = new BufferedReader(reader);
        String strTmp = "";
        String y = "";
        while((strTmp = buffReader.readLine())!=null){
        	y = y + strTmp;
        }
        System.out.println(y);
        buffReader.close();
        assertEquals("盛建辉", "盛建辉");
	}
	@Test
	public void addInvitationt() throws IOException {
//		File file = new File("src/main/webapp/txt/100004.txt");
		int s = 103201;
		String text = "src/main/webapp/txt/"+s+".txt";
		FileWriter fw = new FileWriter(text);
		fw.write("有些时候 你怀念从前日子 可天真离开时 你却没说一个字 你只是挥一挥手 像扔掉废纸 说是人生必经的事 酒喝到七分 却又感觉怅然若失 镜子里面 像看到人生终点 或许再过上几年 你也有张虚伪的脸 难道我们 是为了这样 才来到这世上 这问题来不及想 每一天一年 总是匆匆忙忙 你我来自湖北四川广西宁夏河南山东贵州云南的小镇乡村 曾经发誓 要做了不起的人 却在北京上海广州深圳某天夜半忽然醒来 站在寂寞的阳台 只想从这无边的寂寞中逃出来 许多年前 你有一双清澈的双眼 奔跑起来 像是一道春天的闪电 想看遍这世界 去最遥远的远方 感觉有双翅膀 能飞越高山和海洋 许多年前 你曾是个朴素的少年 爱上一个人 就不怕付出自己一生 相信爱会永恒 相信每个陌生人 相信你会成为最想成为的人");
		fw.close();
	}
	@Test 
	public void time () {
//		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date = new Date();
//        String strDate = format.format(date);
		String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        System.out.println(format);
	}
	
}
