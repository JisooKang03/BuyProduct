import java.util.Scanner;

class ProductTester {

    // Global variables
    static String choice = "Y";
    static int productSize = 0;
    static double totalCost = 0;
    static Product[] productList = new Product[50];

    public static void main(String[] args) throws Exception {

        System.out.println(" ");
        getAllProducts();
        String quit = "";
        Scanner scanner = new Scanner(System.in);

        while (!quit.toLowerCase().equals("shutdown")) {
            System.out.println(" ");
            choice = "Y";
            while (!choice.equals("N")) {
                displayMenu();
                System.out.print("Want to buy more items? - in caps (Y/N): ");
                choice = scanner.nextLine();
            }

            System.out.println("Your total price would be " + totalCost );
            System.out.println("Thanks for shopping with us!");
            System.out.println("Are there any changes in price due to the new inflation rate? - in caps(Yes/No):");
            String specialCase = scanner.nextLine();
            if (specialCase.toLowerCase().equals("yes")) {
                System.out.println("Re-enter all the product details:- ");
                getAllProducts();
            }
            System.out.println("Continue for new user? (Type 'shutdown/continue'): ");
            quit = scanner.nextLine();
        }
    }

    private static void getAllProducts() throws Exception {
        System.out.println("Enter the product Details :");
        Scanner scanner = new Scanner(System.in);
        while (!choice.equals("N")) {

            System.out.print("Enter the name of the item: ");
            String name = scanner.nextLine();
            System.out.print("Enter the Quantity of the Item: ");
            int qty = scanner.nextInt();
            System.out.print("Enter the Price of the Item: ");
            double price = scanner.nextDouble();
            scanner.nextLine();

            // Instantiating object.
            productList[productSize] = new Product();
            productList[productSize].setItemName(name);
            productList[productSize].setItemQty(qty);
            productList[productSize].setItemPrice(price);


            System.out.print("Want to add more products? - in caps (Y/N): ");
            choice = scanner.nextLine();
            productSize += 1;

        }
        System.out.println("-----------------------------------------------------");
    }

    private static void displayMenu() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("Welcome to the Kiosk!");
        System.out.println("Product List: ");
        for (int i = 0; i < productSize; i++) {
            System.out.println((i + 1) + ". " + productList[i].toString());
        }
        System.out.println((productSize + 1) + ". Exit");

        System.out.print("what do you want to buy?: ");
        String choice = scanner.nextLine();
        for (int i = 0; i < productSize; i++) {
            if (choice.toLowerCase().equals(productList[i].getItemName().toLowerCase())) {
                System.out.print("Want to buy more? ");
                double itemCost = productList[i].calcTotal(scanner.nextInt());
                totalCost += itemCost;
                return;
            }
        }
        System.out.println("Product Not found! Try again.");
    }
}