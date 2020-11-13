package com.partten.staticproxy;
//静态代理
//通过方法的环绕，实现对应接口子类方法调用时的功能增强
//功能增强就是在原功能上加了新功能
//新需求？如果要将多人运动改成  种植花草
//新需求？//--dao  userdao.add   deptdao.add   studao.add  执行前提示
public class StaticProxy {

	public static void main(String[] args) {
		
		SuperStar star=new Star();
		
		new ProxyStar(star).showStarMessage();
		
	}
	
}
//新闻里的明星
class ProxyStar{
	private SuperStar superStar;
	public ProxyStar(SuperStar superStar) {
		this.superStar = superStar;
	}
	public void pre() {
		System.out.println("周一见");
	}
	public void showStarMessage() {
		pre();
//		superStar.show();
		new Star() {
			@Override
			public void show() {
				System.out.println("种植花草");
			}
		}.show();
		
		after();
	}
	public void after() {
		System.out.println("你来告我呀");
	}
}
//所有明星的公用方法
interface SuperStar{
	public void show();
}
//真实明星
class Star implements SuperStar{
	public void show() {
		System.out.println("多人运动");
	}
}


