package backingbeans;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entity.UserSample;
import holder.UserHolder;
import logic.UserLogic;
import message.MessageQueue;
import message.MessageView;

@Named
@RequestScoped
public class Bb01 {

	private String id;
	private String name;
	private Date updateDate;

	@Inject
	private UserHolder userHolder;

	@Inject
	private UserLogic userLogic;

	@Inject
	private MessageQueue msgQueue;

	@Inject
	private MessageView msgView;

	/**
	 * 画面01遷移時の初期設定
	 */
	@PostConstruct
	public void init() {
		UserSample user = userHolder.getUser();
		id = user.getId();
		name = user.getName();
		updateDate = user.getUpdateDate();
	}

	/**
	 * 実行ボタン押下時の処理
	 * @return
	 */
	public String execute() {
		boolean success = userLogic.updateUser(new UserSample(id, name, updateDate));

		if (success) {
			return "00.xhtml";
		}

		while (msgQueue.hasNext()) {
			msgView.error(msgQueue.dequeue());
		}
		return null;
	}

	/**
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id セットする id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return updateDate
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate セットする updateDate
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
