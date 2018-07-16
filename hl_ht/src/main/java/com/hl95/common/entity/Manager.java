package com.hl95.common.entity;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @ClassName: Manager
 * @Description:
 * @author chenYan
 * @date 2018年5月24日
 */
public class Manager {
	
	private static Manager manager = null;
	
	public static synchronized Manager getInstance() {  
        if (manager == null) {    
        	manager = new Manager();  
        }    
       return manager;  
	}  
	
	// 短信消息队列
	private static List<SendInfoEntity> queue = new LinkedList<SendInfoEntity>();

	// 未获取状态的短信状态
	private static List<String> statusQueue = new LinkedList<String>(); 
	
	
	
	/**
	 * 向短信消息队列中添加单条信息
	 * @param sms
	 */
	public synchronized void addSms(SendInfoEntity sms) {
		queue.add(sms);
	}

	
	/**
	 * 向短信消息队列中添加多条信息
	 * @param smsList
	 */
	public synchronized void addNewSmsList(List<SendInfoEntity> smsList) {
		queue.addAll(smsList);
	}

	/**
	 * 获取队列的长度
	 * @return 
	 */
	public synchronized int getSmsSize() {
		return queue.size();
	}

	/**
	 * 获取队列里面第一个数据
	 * @return
	 */
	public synchronized SendInfoEntity fetchSmsSend() {
		if (queue.size() > 0) {
			return queue.remove(0);
		} else {
			return null;
		}
	}

	/**
	 * 获取队列中指定数量的数据
	 * @param num
	 * @return
	 */
	public synchronized LinkedList<SendInfoEntity> fetchSmsSendList(int fetchNum) {

		LinkedList<SendInfoEntity> list = new LinkedList<SendInfoEntity>();

		// 获取队列的总长度
		int queueSize = this.getSmsSize();

		// 判断获取队列的数据量，是否满足当前的要获取数据量，如果不满足，取队列中全部的数据，
		int num = fetchNum >= queueSize ? queueSize : fetchNum;

		for (int i = 0; i < num; i++) {

			list.add(queue.remove(0));
		}

		return list;
	}
	
	
	
	/**
	 * 向短信消息队列中添加单条信息
	 * @param sms
	 */
	public synchronized void addStatus(String str) {
		statusQueue.add(str);
	}

	/**
	 * 向短信消息队列中添加多条信息
	 * @param smsList
	 */
	public synchronized void addStatusList(List<String> smsList) {
		statusQueue.addAll(smsList);
	}

	/**
	 * 获取队列的长度
	 * @return 
	 */
	public synchronized int getStuatusSize() {
		return statusQueue.size();
	}

	/**
	 * 获取队列里面第一个数据
	 * @return
	 */
	public synchronized String fetchStatusSend() {
		if (statusQueue.size() > 0) {
			return statusQueue.remove(0);
		} else {
			return null;
		}
	}

	/**
	 * 获取队列中指定数量的数据
	 * @param num
	 * @return
	 */
	public synchronized LinkedList<String> fetchStatusList(int fetchNum) {

		LinkedList<String> list = new LinkedList<String>();

		// 获取队列的总长度
		int queueSize = this.getStuatusSize();

		// 判断获取队列的数据量，是否满足当前的要获取数据量，如果不满足，取队列中全部的数据，
		int num = fetchNum >= queueSize ? queueSize : fetchNum;

		for (int i = 0; i < num; i++) {

			list.add(statusQueue.remove(0));
		}

		return list;
	}
	

	

}
