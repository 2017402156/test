package com.b.thread;

public class Demo01 {
	//ThreadLocal
	public static void main(String[] args) {
		//����cpuִ�д�����˳��ִ�У�һ��һ��ִ��
		
		//�ж����ͬ�Ĵ��� User{1,2,3}  Student{a,b}
		
		//cpuִ�з�ʽ����������   User1  Student-a  user2,3   student-b
		
		//cpuִ��ÿ�д����ʱ�䶼�̣ܶ��̵�����������0.000000001s
		
		//���ڽ���ִ��ÿ�д���ʱ�䶼�̣ܶ��о��Ͼ���ͬʱ��ִ��user��student
		
		//Ҳ�ж��cpu������Ƕ�����ִ��  user��student  cpu1-user123  cpu2-studentab�����ͬʱ�����д���
		
		//������Ҫ�ڵ���cpu��ģ���cpu1��cpu2�ļ��󣬷·�cpu1����ר��ִ��user123��cpu2-studentab
		
//		new Thread().start();   ����һ���߳�
//		Thread cpu1=new Thread();
//		Thread cpu2=new Thread();
		
		//�߳�----����
		//ÿ�������У������ĸо���ͬʱ���е���ģ����룬�����߳�
		//eclipse[Ŀ¼�Ĺ���-run,����̨-run,code-run]  dir[]  word[]  feiqiu[]  xmind[]  ---�����ڴ���ִ�еĴ�����ǽ���
		//system
		
		Thread t1=new MyThread();
		Thread t2=new MyThread();
		//�������߳�ͬʱ����
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
		}.start();//Thread-2��ʼ����
		
		new Thread(t3).start();
		
		//��������
		
	}
	
}
//�����Լ��ж������ܵ��߳�
class MyThread extends Thread{
	//���븴дrun����
	public void run() {
		try {
			if(Thread.currentThread().getName().equals("Thread-0"))
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"��ʼ����");
	}
}
class MyThread2 implements Runnable{
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"��ʼ����");
	}
}





