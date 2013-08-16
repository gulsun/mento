package com.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.bean.Members;
import com.bean.Mento;
import com.bean.ReplyList;

public interface MembersInterface {
	
	public int getLoginResult(Map<String, String> map); // 로그인 결과 리턴
	public Members getMemberInfo(String id);            // 회원정보 리턴
	public List<Mento> Mento(int pageNum);       // Page number 리턴
	public int getPageCount();                          // Page 개수
	public Mento getContents(int bnum);                 // 내용보기 number 리턴
	public List<ReplyList> getReply(int bnum);          // 답글 목록 number 리턴
	public int rInsert(ReplyList rl, DataSourceTransactionManager txManager); // 트렌젝션
	public int memInsert(Members mb);

}
