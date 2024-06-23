class Employee extends User {
    private static int idCounter = 0;
    private int employeeId;

    public Employee(String firstName, String lastName) {
        super(firstName, lastName);
        this.employeeId = ++idCounter;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public Client addClient(String firstName, String lastName) {
        BankAccount account = new BankAccount();
        return new Client(firstName, lastName, account);
    }

    public void acceptDeposit(BankAccount account, double amount) {
        account.deposit(amount);
    }
}
