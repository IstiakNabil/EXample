public class AddMoney {
    private double balance;

    public AddMoney() {
        this.balance = 200;
    }

    public AddMoney(double balance) {
        this.balance = balance;
    }

    public void addBalance(double amount) {
        if (amount < 0) {
            System.out.println("Error: Cannot add a negative amount.");
        } else {
            balance += amount;
        }
    }

    public void deductBalance(double amount) {
        if (amount < 0) {
            System.out.println("Error: Cannot deduct a negative amount.");
        } else if (amount > balance) {
            System.out.println("Error: Insufficient balance.");
        } else {
            balance -= amount;
            
        }
      
    }

    public double getBalance() {
        return balance;
    }
}
