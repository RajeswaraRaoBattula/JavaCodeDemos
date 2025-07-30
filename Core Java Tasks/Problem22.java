/*
 * Create two interfaces namely Drawable and Fillable. Create class called Line, Circle, Square and
implement following methods through interface.

<I>Drawable ------ drawingColor(), thickness ()
<I>Fillable ---------- fillingColor (), size ()
 */
package myjavacodes;

interface Drawable{
	void drawingColor();
	void thickness();
}

interface Fillable{
	void fillingColor();
	void size();
}

class Line implements Drawable{
	public void drawingColor() {
		System.out.println("This line is drwable...");
	}
	
	public void thickness() {
		System.out.println("This line is very thick...");
	}
	
}

class Circle implements Drawable, Fillable{
	public void drawingColor() {
		System.out.println("This Circle is drwable...");
	}
	
	public void thickness() {
		System.out.println("This circle is very thick...");
	}
	
	public void fillingColor() {
		System.out.println("This circle is very filled with color...");
	}
	
	public void size() {
		System.out.println("This circle size is small...");
	}
}

class Square implements Drawable, Fillable{
	public void drawingColor() {
		System.out.println("This Square is drwable...");
	}
	
	public void thickness() {
		System.out.println("This Square is very thick...");
	}
	
	public void fillingColor() {
		System.out.println("This Square is very filled with color...");
	}
	
	public void size() {
		System.out.println("This Square size is small...");
	}
}

public class Problem22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Line l=new Line();
		Circle c=new Circle();
		Square s=new Square();
		
		System.out.println("----Line----");
		l.drawingColor();
		l.thickness();
		System.out.println("----Circle----");
		c.drawingColor();
		c.thickness();
		c.fillingColor();
		c.size();
		System.out.println("----Square----");
		s.drawingColor();
		s.thickness();
		s.fillingColor();
		s.size();
		
		
	}

}
