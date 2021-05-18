package command;
import command.Command;
import java.awt.Point;

public class DrawCommand implements Command {
    // 그림 그리기 대상
    protected Drawable drawable;
    // 그림 그리기 위치
    private Point position;
    // 생성자
    public DrawCommand(Drawable drawable, Point position) {
        this.drawable = drawable;
        this.position = position;
    }
    // 실행
    public void execute() {                  
        drawable.draw(position.x, position.y); 
    }                                      
}
