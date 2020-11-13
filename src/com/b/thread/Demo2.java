package com.b.thread;

public class Demo2 {

	//ThreadLocal
	public static void main(String[] args) {
		//web程序多任务程序，一般一个页面发送一个request过来，服务器会创建一些列的任务
		/**
		public void processRequest(request){
		//伪代码
			User user=request.getSession.getUser();
			//检查权限
			checkPermission();
			//让用户去执行任务
			doSthWork(){
				queryUserInfo();
				updateUser(){
//					User user=map.get(Thread);
 					ThreadLocal.get();
					update-->user
				}
			}
			//保存状态
			saveStauts();
			//返回http响应
			returnResponse();
		}
		 */
		
		
		//认为ThreadLocal  ==  Map<Thread,Object>  map.get(Thread)-->Object
		//ThreadLocal.set(conn);   map.put(Thread.getCurrentThread()=t1,conn)
		//ThreadLocal.get()  map.get(Thread.getCurrentThread()=t1)-->conn
	}
	
}
