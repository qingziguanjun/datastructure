package com.cn.javass.dp.state.example7;
/**
 * ����״̬�ӿ�
 */
public interface State {
	/**
	 * ִ��״̬��Ӧ�Ĺ��ܴ���
	 * @param ctx �����ĵ�ʵ������
	 */
	public void doWork(StateMachine ctx);
}