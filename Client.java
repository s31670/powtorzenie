class Client extends User {
    private static int idCounter = 0;
    private int clientId;
    private BankAccount account;

    public Client(String firstName, String lastName, BankAccount account) {
        super(firstName, lastName);
        this.clientId = ++idCounter;
        this.account = account;
    }

    public int getClientId() {
        return clientId;
    }

    public BankAccount getAccount() {
        return account;
    }
}

