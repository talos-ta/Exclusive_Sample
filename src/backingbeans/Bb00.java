package backingbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entity.UserSample;
import holder.UserHolder;
import logic.UserLogic;

@Named
@RequestScoped
public class Bb00 {

	private List<UserSample> userList;

	@Inject
	private UserLogic userLogic;

	@Inject
	private UserHolder userHolder;

	@PostConstruct
	public void init() {
		userList = userLogic.getAllUsers();
	}

	/**
	 * 編集ボタン押下時の処理
	 * @param user
	 * @return
	 */
	public String edit(UserSample user) {
		userHolder.setUser(user);
		return "01.xhtml";
	}

	/**
	 * @return userList
	 */
	public List<UserSample> getUserList() {
		return userList;
	}

	/**
	 * @param userList セットする userList
	 */
	public void setUserList(List<UserSample> userList) {
		this.userList = userList;
	}
}
