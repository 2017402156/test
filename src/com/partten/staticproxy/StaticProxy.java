package com.partten.staticproxy;
//��̬����
//ͨ�������Ļ��ƣ�ʵ�ֶ�Ӧ�ӿ����෽������ʱ�Ĺ�����ǿ
//������ǿ������ԭ�����ϼ����¹���
//���������Ҫ�������˶��ĳ�  ��ֲ����
//������//--dao  userdao.add   deptdao.add   studao.add  ִ��ǰ��ʾ
public class StaticProxy {

	public static void main(String[] args) {
		
		SuperStar star=new Star();
		
		new ProxyStar(star).showStarMessage();
		
	}
	
}
//�����������
class ProxyStar{
	private SuperStar superStar;
	public ProxyStar(SuperStar superStar) {
		this.superStar = superStar;
	}
	public void pre() {
		System.out.println("��һ��");
	}
	public void showStarMessage() {
		pre();
//		superStar.show();
		new Star() {
			@Override
			public void show() {
				System.out.println("��ֲ����");
			}
		}.show();
		
		after();
	}
	public void after() {
		System.out.println("��������ѽ");
	}
}
//�������ǵĹ��÷���
interface SuperStar{
	public void show();
}
//��ʵ����
class Star implements SuperStar{
	public void show() {
		System.out.println("�����˶�");
	}
}


