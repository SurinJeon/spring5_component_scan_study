package spring5_component_scan_study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring5_component_scan_study.spring.ChangePasswordService;
import spring5_component_scan_study.spring.MemberDao;
import spring5_component_scan_study.spring.MemberInfoPrinter;
import spring5_component_scan_study.spring.MemberListPrinter;
import spring5_component_scan_study.spring.MemberPrinter;
import spring5_component_scan_study.spring.MemberRegisterService;
import spring5_component_scan_study.spring.VersionPrinter;

@Configuration
public class AppCtx { // Assembler와 다른건 여기서는 Composite 관계임

	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao());
	}
	
	@Bean
	public ChangePasswordService changePwdSvc() {
		ChangePasswordService pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao());
		return pwdSvc;
	}
	
	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	
	@Bean
	public MemberListPrinter memberListPrinter() {
		return new MemberListPrinter(memberDao(), memberPrinter());
	}
	
	@Bean
	public MemberInfoPrinter memberInfoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		
		/*@Autowired로 아래부분 생략 가능*/
		
//		infoPrinter.setMemberDao(memberDao());
//		infoPrinter.setPrinter(memberPrinter());
		return infoPrinter;
	}
	
	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);
		return versionPrinter;
	}
}
