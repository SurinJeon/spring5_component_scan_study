package spring5_component_scan_study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import spring5_component_scan_study.spring.MemberPrinter;
import spring5_component_scan_study.spring.VersionPrinter;

@Configuration
@ComponentScan(basePackages = {"spring5_component_scan_study.spring"}) // di들 있는 package명 기준으로 검색해서 니가 스캔해온 뒤에 넣어라
public class AppCtx { // Assembler와 다른건 여기서는 Composite 관계임
	
	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}

	
	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);
		return versionPrinter;
	}
}
