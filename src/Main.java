import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

class Laptop {
    private String name;
    private int ram;
    private int storageCap;
    private String os;
    private String color;

    public Laptop(String name, int ram, int storageCap, String os, String color) {
        this.name = name;
        this.ram = ram;
        this.storageCap = storageCap;
        this.os = os;
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format(
                "Название ноутбука: %s \nОбъем оперативной памяти: %d Гб \nОбъем накопителя %d Гб \nПредустановленная ОС: %s \nЦвет ноутбука: %s \n",
                this.name, this.ram, this.storageCap, this.os, this.color);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Laptop) {
            return this.name.equals(((Laptop) obj).name) && this.ram == ((Laptop) obj).ram
                    && this.storageCap == ((Laptop) obj).storageCap && this.os.equals(((Laptop) obj).os)
                    && this.color.equals(((Laptop) obj).color);
        }
        return false;
    }

    public int getRam() {
        return this.ram;
    }

    public int getStorageCap() {
        return this.storageCap;
    }

    public String getOS() {
        return this.os;
    }

    public String getColor() {
        return this.color;
    }
}

class App {
    public static void main(String[] args) throws Exception {
        Set<Laptop> laptops = new HashSet<>();
        laptops.add(new Laptop("Thunderobot 911 Air X", 16, 512, "Windows", "Black"));
        laptops.add(new Laptop("Apple MacBook Pro 14", 16, 512, "MacOS", "Black"));
        laptops.add(new Laptop("Gigabyte G5 GE", 8, 512, "Windows", "Black"));
        laptops.add(new Laptop("Frbby V10", 8, 256, "Windows", "Gray"));
        laptops.add(new Laptop("AKPAD Silver", 8, 256, "Windows", "Gray"));
        laptops.add(new Laptop("Irbis NB702", 4, 128, "Windows", "Gray"));

        Map<Integer, String> mapCrit = new HashMap<>();
        mapCrit.put(1, "ОЗУ");
        mapCrit.put(2, "SSD");
        mapCrit.put(3, "ОС");
        mapCrit.put(4, "Цвет");

        System.out.println("Введите желаемые характеристики:");
        Map<String, String> filterParams = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        for (Map.Entry<Integer, String> entry : mapCrit.entrySet()) {
            System.out.println("\nВведите характеристики для " + entry.getValue() + ":");
            String value = scanner.next();
            filterParams.put(entry.getValue(), value);
        }

        Set<Laptop> filteredLaptops = new HashSet<>();
        for (Laptop laptop : laptops) {
            if (laptop.getRam() >= Integer.parseInt(filterParams.get("ОЗУ")) &&
                    laptop.getStorageCap() >= Integer.parseInt(filterParams.get("SSD")) &&
                    laptop.getOS().equals(filterParams.get("ОС")) &&
                    laptop.getColor().equals(filterParams.get("Цвет"))) {
                filteredLaptops.add(laptop);
            }
        }

        System.out.println("\nПодходящие ноутбуки:");
        for (Laptop laptop : filteredLaptops) {
            System.out.println(laptop);
        }
    }
}