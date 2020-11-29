package db;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import entity.UserSample;
import entity.UserSampleExample;
import mapper.UserSampleMapper;

@RequestScoped
public class UserSampleLogic {

	@Inject
	SqlSessionManager sqlSessionManager;

	/**
	 * すべてのユーザーのリストを返す
	 * @return
	 */
	public List<UserSample> getAllUsers() {
		List<UserSample> list = new ArrayList<>();
		try (SqlSession session = sqlSessionManager.getSqlSessionFactory().openSession()) {
			UserSampleMapper mapper = session.getMapper(UserSampleMapper.class);
			UserSampleExample example = new UserSampleExample();
			example.createCriteria().andIdIsNotNull();
			list = mapper.selectByExample(example);
		}
		return list;
	}

	/**
	 * ユーザー情報を更新する<br/>
	 * 楽観的排他制御を行う
	 * @param user
	 * @return
	 */
	public int updateUser(UserSample user) {
		int result = 0;
		try (SqlSession session = sqlSessionManager.getSqlSessionFactory().openSession()) {
			UserSampleMapper mapper = session.getMapper(UserSampleMapper.class);
			UserSampleExample example = new UserSampleExample();
			example.createCriteria().andIdEqualTo(user.getId()).andUpdateDateEqualTo(user.getUpdateDate());
			result = mapper.updateByExampleSelective(user, example);
		}
		return result;
	}
}
