package spring5_component_scan_study.spring;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberListPrinter {

	@Autowired
	private MemberDao memberDao;
	@Autowired
	private MemberPrinter printer;
	
	public MemberListPrinter() {
	}

	public MemberListPrinter(MemberDao memberDao, MemberPrinter printer) { // injection
		this.memberDao = memberDao;
		this.printer = printer;
	}
	
	public void printAll() {
		Collection<Member> members = memberDao.selectAll();
		members.forEach(m -> printer.print(m));
	}
	
}
