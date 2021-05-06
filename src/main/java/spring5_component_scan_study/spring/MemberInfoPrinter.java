package spring5_component_scan_study.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("infoPrinter")
public class MemberInfoPrinter {

	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private MemberPrinter printer;

	public void printMemberInfo(String email) {
		Member member = memberDao.selectByEmail(email);

		if (member == null) {
			System.out.println("데이터가 없습니다.\n");
			return;
		}
		printer.print(member);

		System.out.println();

	}

}
