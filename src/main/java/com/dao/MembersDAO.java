package com.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.bean.Members;
import com.bean.Mento;
import com.bean.ReplyList;

public class MembersDAO extends SqlSessionDaoSupport implements MembersInterface {
	
	public boolean accessMember(Members members) {
		boolean result = false;
		int count = getSqlSession().selectOne("MembersInterface.getLoginResult", members);
		
		if(count != 0) {  // false를 반환하면 ID가 존재하지 않음
			result = true;
		}
		System.out.println(result);
		return result;
	}
	
	// selectOne(네임스페이스, ID)
	public int getLoginResult(Map<String, String>map) {
		return getSqlSession().selectOne("MembersInterface.getLoginResult", map);
	}
	
	public Members getMemberInfo(String id) {
		return getSqlSession().selectOne("MembersInterface.getMemberInfo", id);
	}

	public List<Mento> Mento(int pageNum) {
		return getSqlSession().selectList("MembersInterface.getmento", pageNum);
	}

	public int getPageCount() {
		return getSqlSession().selectOne("MembersInterface.getPageCount");
	}

	public Mento getContents(int bnum){		
		return getSqlSession().selectOne("MembersInterface.getContents", bnum);
	}
	
	public List<ReplyList> getReply(int bnum){
		return getSqlSession().selectList("MembersInterface.getReply", bnum);
	}
	
	// 회원정보에 필요한 정보를 mb에 저장
	public int memInsert(Members mb) {
		return getSqlSession().insert("MembersInterface.memInsert", mb);
	}

	@SuppressWarnings("unused")
	public int rInsert(ReplyList rl, DataSourceTransactionManager txManager) {
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus status = txManager.getTransaction(def);
		
		ReplyList r=new ReplyList();
		r.setBnum(119);
		r.setRcontents("롤백 안한거");
		r.setWriter("HANA");
		try {
		  getSqlSession().insert("MembersInterface.rInsert", rl);
		  //txManager.rollback(status);
		  //getSqlSession().insert("MembersInterface.rInsert", r);
		  //txManager.commit(status);
		}
		catch (Exception ex) {
		  //txManager.rollback(status);
		  //throw ex;
		}
		//txManager.commit(status);
		return 1;
	}

}



