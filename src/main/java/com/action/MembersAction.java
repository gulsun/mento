package com.action;

import com.bean.Members;
import com.dao.MembersDAO;

public class MembersAction {
	
	MembersDAO mDao;
	
	public MembersAction(MembersDAO dao) {
		this.mDao = dao;
	}
	
	// 회원가입이 성공하면 home으로 이동
	public String memInsert(Members mb) {
		String result = "join";
		if(mDao.memInsert(mb)==1) {
			result = "home";
		}
		return result;
	}
}
