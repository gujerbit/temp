package template;

public class Main {
    public static void main(String[] args) {
	// 'H'을 가진 CharDisplay 인스턴스를 1개 만든다>
        AbstractDisplay d1 = new CharDisplay('H');
	// “Hello, world.”을 가진 StringDisplay의 인스턴스를 1개 만든다.
        AbstractDisplay d2 = new StringDisplay("Hello, world.");
    	// “안녕하세요.”를 가진 StringDisplay의 인스턴스를 1개 만든다.
        AbstractDisplay d3 = new StringDisplay("안녕하세요.");
        d1.display();   // d1, d2, d3 모두 AbstractDisplay의 하위클래스의 인스턴스이기 때문에
        d2.display();   // 상속한 display메소드를 호출할 수 있다.
        d3.display();   // 실제 동작은 CharDisplay나 StringDisplay에서 결정한다.
    }
}
