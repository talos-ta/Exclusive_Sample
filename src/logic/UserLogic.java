package logic;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import db.UserSampleLogic;
import entity.Message;
import entity.UserSample;
import message.MessageQueue;

@RequestScoped
public class UserLogic {

	@Inject
	private UserSampleLogic usLogic;

	@Inject
	private MessageQueue msgQueue;

	/**
	 * すべてのユーザーのリストを返す
	 * @return
	 */
	public List<UserSample> getAllUsers() {
		return usLogic.getAllUsers();
	}

	/**
	 * ユーザー情報を更新する
	 * @param user
	 * @return
	 */
	public boolean updateUser(UserSample user) {
		int result = usLogic.updateUser(user);

		if (result > 0) {
			return true;
		}

		Message msg = new Message("updateErr", "更新に失敗しました", null);
		msgQueue.enqueue(msg);
		return false;
	}
}
