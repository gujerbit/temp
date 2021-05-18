package observer;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class NumberGenerator {
    private ArrayList observers = new ArrayList();     // Observer들을 저장
    public void addObserver(Observer observer) {    // Observer을 추가
        observers.add(observer);
    }
    public void deleteObserver(Observer observer) {  // Observer을 삭제
        observers.remove(observer);
    }
    public void notifyObservers() {                  // Observer에 통지
        Iterator it = observers.iterator();      
        while (it.hasNext()) {                 
            Observer o = (Observer)it.next();  
            o.update(this);                   
        }                                     
    }                                      
    public abstract int getNumber();                // 수를 취득한다
    public abstract void execute();                  // 수를 생성한다
}
