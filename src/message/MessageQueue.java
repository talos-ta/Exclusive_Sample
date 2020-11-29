package message;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Deque;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;

import entity.Message;

@SessionScoped
public class MessageQueue implements Serializable {

	private Deque<Message> msgQueue;

	@PostConstruct
	public void init() {
		msgQueue = new ArrayDeque<>();
	}

	/**
	 * キューの末尾に{@code message}を追加する。
	 *
	 * @param message
	 * 			{@code null}でない{@code Message}オブジェクト
	 *
	 * @return なし
	 */
	public void enqueue(Message message) {
		msgQueue.add(message);
	}

	/**キューの先頭から{@code message}を取り出す。
	 *
	 * @return キューの先頭の{@code Message}オブジェクト。キューが空の場合は{@code null}
	 */
	public Message dequeue() {
		return msgQueue.poll();
	}

	/**
	 * キューから{@code message}の取り出しが可能か判定する。
	 *
	 * @return 取り出し可能な場合は{@code true}、それ以外の場合{@code false}
	 */
	public boolean hasNext() {
		return !msgQueue.isEmpty();
	}

	public Deque<Message> getmsgQueue() {
		return msgQueue;
	}

	public void setmsgQueue(Deque<Message> msgQueue) {
		this.msgQueue = msgQueue;
	}

}
