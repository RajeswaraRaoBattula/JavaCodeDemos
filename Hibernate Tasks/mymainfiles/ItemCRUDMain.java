package mymainfiles;

import mypojos.Item;
import mydaodemos.ItemDao;

import java.util.List;
import java.util.Scanner;

public class ItemCRUDMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ItemDao dao = new ItemDao();
        int choice;

        do {
            System.out.println("\nHibernate Item CRUD -------------------------------");
            System.out.println("1. Add");
            System.out.println("2. View All");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Get by ID");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    dao.addItem(new Item(name, price));
                    System.out.println("Item added.");
                    break;

                case 2:
                    List<Item> items = dao.getAllItems();
                    items.forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Enter ID to update: ");
                    int idToUpdate = scanner.nextInt();
                    scanner.nextLine();
                    Item updateItem = dao.getItemById(idToUpdate);
                    if (updateItem != null) {
                        System.out.print("Enter new name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter new price: ");
                        double newPrice = scanner.nextDouble();
                        updateItem.setName(newName);
                        updateItem.setPrice(newPrice);
                        dao.updateItem(updateItem);
                        System.out.println("Item updated.");
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    int idToDelete = scanner.nextInt();
                    Item deleteItem = dao.getItemById(idToDelete);
                    if (deleteItem != null) {
                        dao.deleteItem(deleteItem);
                        System.out.println("Item deleted.");
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    Item item = dao.getItemById(id);
                    if (item != null) {
                        System.out.println(item);
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;
            }

        } while (choice != 0);

        dao.closeFactory();
        scanner.close();
    }
}
