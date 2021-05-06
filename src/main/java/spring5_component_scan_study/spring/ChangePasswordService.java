package spring5_component_scan_study.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service // Service는 Component의 하위 클래스기 때문에 Service 해도 가능함
public class ChangePasswordService {

	@Autowired
	private MemberDao memberDao;
	
	public void changePassword(String email, String oldPwd, String newPwd) {
		Member member = memberDao.selectByEmail(email);
		if(member == null) {
			throw new MemberNotFoundException();
		}
		
		
		member.changePassword(oldPwd, newPwd); // 원래는 true면 update해야하기 때문에 try-catch 필요한데 일단은 그냥 한거임
		
		memberDao.update(member);
	}
	
}
