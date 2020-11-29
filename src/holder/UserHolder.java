package holder;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

import entity.UserSample;

@SessionScoped
public class UserHolder implements Serializable {

	private UserSample user;

	/**
	 * @return user
	 */
	public UserSample getUser() {
		return user;
	}

	/**
	 * @param user セットする user
	 */
	public void setUser(UserSample user) {
		this.user = user;
	}
}
