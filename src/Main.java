import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void printArr(ArrayList list) {
        for (int j = 0; j < list.size(); j++) {
            System.out.println((j + 1) + "." + list.get(j));
        }
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        list.add("сыр");
        list.add("сырник");
        list.add("Булочка");
        list.add("Хлебобулочное");
        list.add("КОлбасы");

        while (true) {
            System.out.println("Выберите необходимую операцию 1-4");
            String mode = scan.nextLine();

            switch (mode) {
                case "1":
                    System.out.println("Какую покупку хотите добавить?");
                    String addScan = scan.nextLine();
                    list.add(addScan);
                    printArr(list);

                    System.out.println("Итого в списке покупок: " + list.size());

                    continue;
                case "2":
                    System.out.println("Список покупок: ");
                    printArr(list);
                    continue;
                case "3":
                    System.out.println("Какую хотите удалить? Введите номер или название: ");
                    String deleteScan = scan.nextLine();
                    try {

                        list.remove(Integer.parseInt(deleteScan) - 1);
                        printArr(list);

                    } catch (RuntimeException e) {

                        list.remove(list.indexOf(deleteScan));
                        System.out.println("Покупка " + deleteScan + " удалена, список покупок:");
                        printArr(list);
                    }
                case "4":
                    String itemLower;
                    System.out.println("Введите текст для поиска: ");
                    String searchScan = scan.nextLine();

                    itemLower = searchScan.toLowerCase();

                    for (int j = 0; j < list.size(); j++) {
                        if (list.get(j).toLowerCase().contains(itemLower))
                            System.out.println((j + 1) + "." + list.get(j));
                    }
                default:
                    System.out.println("Вы ввели неправильное значение:");
            }
        }
    }
}
