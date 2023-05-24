package logics;

import java.io.Serializable;

public class Data implements Serializable {
    private User user;
    private Money money;

    public Data() {
    }
    public void setUser(User user) { this.user = user; }
    public void setMoney(Money money) { this.money = money; }
    public User getUser() { return user; }
    public Money getMoney() {return money; }

    public void write(){
        
    }
}
