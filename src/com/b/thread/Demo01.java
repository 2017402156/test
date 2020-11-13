package com.b.thread;

public class Demo01 {
	//ThreadLocal
	public static void main(String[] args) {
		//单个cpu执行代码是顺序执行，一条一条执行
		
		//有多个不同的代码 User{1,2,3}  Student{a,b}
		
		//cpu执行方式是轮流交替   User1  Student-a  user2,3   student-b
		
		//cpu执行每行代码的时间都很短，短到你察觉不到，0.000000001s
		
		//由于交替执行每行代码时间都很短，感觉上就是同时在执行user和student
		
		//也有多个cpu，真的是独立在执行  user和student  cpu1-user123  cpu2-studentab，真的同时在运行代码
		
		//我们需要在单个cpu上模拟出cpu1，cpu2的假象，仿佛cpu1就是专门执行user123，cpu2-studentab
		
//		new Thread().start();   启动一个线程
//		Thread cpu1=new Thread();
//		Thread cpu2=new Thread();
		
		//线程----进程
		//每个进程中，独立的感觉在同时运行的子模块代码，就是线程
		//eclipse[目录的功能-run,控制台-run,code-run]  dir[]  word[]  feiqiu[]  xmind[]  ---正在内存中执行的代码就是进程
		//system
		
		Thread t1=new MyThread();
		Thread t2=new MyThread();
		//让两个线程同时开启
		t1.start();
		t2.start();
		
		MyThread2 t3=new MyThread2();
		/*
		    @Override
		    public void run() {
		        if (target != null) {
		            target.run();
		        }
		    }
		 */
		new Thread(t3) {
			public void run() {
				System.out.println("Thread-2run");
			}
		}.start();//Thread-2开始运行
		
		new Thread(t3).start();
		
		//常规问题
		
	}
	
}
//定义自己有独立功能的线程
class MyThread extends Thread{
	//必须复写run方法
	public void run() {
		try {
			if(Thread.currentThread().getName().equals("Thread-0"))
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"开始运行");
	}
}
class MyThread2 implements Runnable{
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"开始运行");
	}
}





