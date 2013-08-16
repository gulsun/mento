package a.b.c;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.action.MembersAction;
import com.bean.Members;
import com.dao.MembersDAO;

@Controller
@SessionAttributes("members")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	// DAO의 인스턴스가 단1번만 생성되는 이점
	@Resource(name="membersDao")
	private MembersDAO memberDao;
	
	@Resource(name="transactionManager")
	private DataSourceTransactionManager txManager;
	
	// 세션 객체를 갖다 붙임
	private HttpSession session;
	
	// home.jsp로 가기위해 구현
	@RequestMapping(value="/")
	public String home() {
		return "home";
	}
	
	@RequestMapping(value="/join")
	public String join() {
		return "join";
	}
	
	@RequestMapping(value="/memJoin")
	public String memJoin(HttpServletRequest request, Model model) {
		String result = "join";
		Members mb = new Members();
		
		try {
			request.setCharacterEncoding("UTF-8");
			mb.setId(request.getParameter("id"));
			mb.setPwd(request.getParameter("pwd"));
			mb.setMname(request.getParameter("name"));
			mb.setBirth(request.getParameter("birth"));
			mb.setAddr(request.getParameter("addr"));
			mb.setPhone(request.getParameter("phone"));
			
			MembersAction ma = new MembersAction(memberDao);
			result = ma.memInsert(mb);
			model.addAttribute("check", 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// URL이 "/"이구 Get 방식으로 호출할 때 사용
	// model의 view 인스턴스가 전달이됨
	/*@RequestMapping(value = "/", method = RequestMethod.GET) 
	public String home(Locale locale, Model model) { 
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance
				(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate ); // 표준시간을 문자열에 담음
		
		return "home"; // views에 들어가 있는 home.jsp
	}*/
	
}
