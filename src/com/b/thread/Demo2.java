package com.b.thread;

public class Demo2 {

	//ThreadLocal
	public static void main(String[] args) {
		//web������������һ��һ��ҳ�淢��һ��request�������������ᴴ��һЩ�е�����
		/**
		public void processRequest(request){
		//α����
			User user=request.getSession.getUser();
			//���Ȩ��
			checkPermission();
			//���û�ȥִ������
			doSthWork(){
				queryUserInfo();
				updateUser(){
//					User user=map.get(Thread);
 					ThreadLocal.get();
					update-->user
				}
			}
			//����״̬
			saveStauts();
			//����http��Ӧ
			returnResponse();
		}
		 */
		
		
		//��ΪThreadLocal  ==  Map<Thread,Object>  map.get(Thread)-->Object
		//ThreadLocal.set(conn);   map.put(Thread.getCurrentThread()=t1,conn)
		//ThreadLocal.get()  map.get(Thread.getCurrentThread()=t1)-->conn
	}
	
}
