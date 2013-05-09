package com.toxind.benchmark.jvm.introspector;

public class Person {

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getHome() {
		return home;
	}
	public void setHome(String home) {
		this.home = home;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public double getSalry() {
		return salry;
	}
	public void setSalry(double salry) {
		this.salry = salry;
	}
	private String name;
	private int age;
	private String home;
	private String sex;
	private double salry;
	
	private Person x12312;

	public Person getPxxxx() {
		return x12312;
	}
	public void setPxxxx(Person pxxxx) {
		this.x12312 = pxxxx;
	}

	@Override
	public String toString() {
		String re ="name >> " + name + "       age >> " +age + "    sex >> "+ sex + "   home >> " + home;
		if(x12312 !=null){
			re += "\r\n    ## " + x12312.toString();
		}
		return re;
	}
	
}
