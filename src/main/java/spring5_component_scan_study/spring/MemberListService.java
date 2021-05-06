package spring5_component_scan_study.spring;

import java.util.Map;

public class MemberListService {
	private MemberDao memberDao;

	public MemberListService() {
	}
	
	public Map<String, Member> showMemberList() {
		return memberDao.getMember();
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
}
