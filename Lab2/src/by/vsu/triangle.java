package by.vsu;

public class triangle {
	public static boolean func(Point A, Point B, Point C, Point point) {
        boolean Answer = false, test1 = false, test2 = false, border1 = false, border2 = false, border3 = false, border4 = false;
        double a, b , c, a1, b1, c1, startx, starty, endx, endy ;
       
        a = ((A.getX() - point.getX()) * (B.getY() - A.getY()) - (B.getX() - A.getX()) * (A.getY() - point.getY()));
        b = ((B.getX() - point.getX()) * (C.getY() - B.getY()) - (C.getX() - B.getX()) * (B.getY() - point.getY()));
        c = ((C.getX() - point.getX()) * (A.getY() - C.getY()) - (A.getX() - C.getX()) * (C.getY() - point.getY()));
        
        
        a1 = (int) Math.signum(a);
        b1 = (int) Math.signum(b);
        c1 = (int) Math.signum(c);
        
        System.out.println("a1 " + a1 + " b1 " + b1 + " c1  " + c1);
        
        startx = Math.min(A.getX(), Math.min(B.getX(), C.getX()));
        starty = Math.min(A.getY(), Math.min(B.getY(), C.getY()));
        endx = Math.max(A.getX(), Math.max(B.getX(), C.getX()));
        endy = Math.max(A.getY(), Math.max(B.getY(), C.getY()));
        
        border1 = startx <= point.getX();
        border2 = point.getX() <= endx;
        border3 = starty <= point.getY();
        border4 = point.getY() <= endy;
        
        test1 = a1 == b1;
        test2 = b1 == c1;
        
        if (test1 == test2 ) {
        	
        	Answer = true;
        }
     
        if (a1 == 0 | b1 == 0 | c1 == 0) {
        	if (a1 == b1 | a1 == c1 | b1 == c1) {
        		Answer = true;
        	}
        	if (border1 & border2 & border3 & border4) {
        	}
        	else {
        		Answer = false;
        	}			
        }
        return Answer;
    }
	
	public static void main(String[] args) {
		if (args.length == 8){
		double x1 = Double.parseDouble(args[0]);
		double y1 = Double.parseDouble(args[1]);
		double x2 = Double.parseDouble(args[2]);
		double y2 = Double.parseDouble(args[3]);
		double x3 = Double.parseDouble(args[4]);
		double y3 = Double.parseDouble(args[5]);
		double x0 = Double.parseDouble(args[6]);
		double y0 = Double.parseDouble(args[7]);
		
		Point A = new Point(x1, y1);
		Point B = new Point(x2, y2);
		Point C = new Point(x3, y3);
		Point point = new Point(x0,y0);
		
		System.out.println("Вершины треугольника: A" + A + " B" + B + " C" + C);
		System.out.println("Точка: " + point);
		System.out.println("Точка принадлежит треугольнику: " + func(A, B, C, point));
		}
		else System.out.println("Ошибка в параметрах !");
	}

}
