public class Main {
    public static void main(String[] args) {
        Admin admin = new Admin("Admin", "One");
        Employee emp1 = admin.addEmployee("Employee", "One");
        Employee emp2 = admin.addEmployee("Employee", "Two");

        Client client1 = emp1.addClient("Client", "One");
        Client client2 = emp1.addClient("Client", "Two");
        Client client3 = emp2.addClient("Client", "Three");
        Client client4 = emp2.addClient("Client", "Four");

        emp1.acceptDeposit(client1.getAccount(), 1000);
        emp1.acceptDeposit(client2.getAccount(), 2000);
        emp2.acceptDeposit(client3.getAccount(), 1500);
        emp2.acceptDeposit(client4.getAccount(), 2500);

        try {
            client1.getAccount().transfer(client2.getAccount(), 500);
            client3.getAccount().transfer(client4.getAccount(), 300);
            // Additional transactions
        } catch (AccountOperationException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Balance of Client 1: " + client1.getAccount().checkBalance());
        System.out.println("Balance of Client 2: " + client2.getAccount().checkBalance());
        System.out.println("Balance of Client 3: " + client3.getAccount().checkBalance());
        System.out.println("Balance of Client 4: " + client4.getAccount().checkBalance());
    }
}
