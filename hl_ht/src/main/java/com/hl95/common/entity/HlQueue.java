package com.hl95.common.entity;

import java.util.List;

/**
 * 
 * @ClassName: HlQueue  
 * @Description: 全局队列 
 * @author chenYan  
 * @date 2018年5月28日  
 *
 */
public class HlQueue<E> extends java.util.LinkedList<E>{
	
	private static final long serialVersionUID = 1L;
	
	private HlQueue<E> queue = null;
	
	public HlQueue(){
		
		queue = new HlQueue<E>();
	}

	/**
	 * 
	 * @Title: add  
	 * @Description: 像指定队列中添加元素
	 * @param queue
	 * @param e
	 * @return 
	 *
	 */
	public synchronized boolean addElement(E e) {
		
		return queue.add(e);
	}

	/**
	 * 向短信消息队列中添加多条信息
	 * @param smsList
	 */
	public synchronized void addList(List<E> list) {
		
		queue.addAll(list);
	}

	/**
	 * 获取队列的长度
	 * @return 
	 */
	public synchronized int getSize() {
		
		return queue.size();
	}

	/**
	 * 获取队列里面第一个数据
	 * @return
	 */
	public synchronized E fetchSmsSend() {
		
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
	public synchronized HlQueue<E> fetchList(int fetchNum) {

		HlQueue<E> newQueue = new HlQueue<E>();

		// 获取队列的总长度
		int queueSize = this.getSize();

		// 判断获取队列的数据量，是否满足当前的要获取数据量，如果不满足，取队列中全部的数据，
		int num = fetchNum >= queueSize ? queueSize : fetchNum;

		for (int i = 0; i < num; i++) {

			newQueue.add(queue.remove(0));
		}
		
		return newQueue;
	}

}
