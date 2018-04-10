package leanTaas.pms.util;

/***
 * A pair class that contains two object with same type.
 * @author Yanwu_Alienware
 *
 * @param <T>
 */
public class Pair<T> {
	
	T o1;
	T o2;
	public Pair(T o1, T o2) {
		this.o1 = o1;
		this.o2 = o2;
	}
	public T getO1() {
		return o1;
	}
	public void setO1(T o1) {
		this.o1 = o1;
	}
	public T getO2() {
		return o2;
	}
	public void setO2(T o2) {
		this.o2 = o2;
	}
	
	@Override
	public String toString() {
		return o1.toString() + " " + o2.toString();
	}
}
