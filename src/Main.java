import java.util.*;

public class Main {

    // Task 1
    public static void task1(Scanner sc) {
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        if (Arrays.equals(a, b)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    // Task 2
    public static void task2(Scanner sc) {
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        Arrays.sort(arr);
        System.out.println(arr[k - 1]);
    }

    // Task 3
    public static void task3(Scanner sc) {
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        System.out.println(arr[n / 2]);
    }

    // Task 4
    public static boolean canShip(int[] weights, int days, int capacity) {
        int current = 0;
        int d = 1;

        for (int w : weights) {
            if (current + w > capacity) {
                d++;
                current = 0;
            }
            current += w;
        }

        return d <= days;
    }

    public static int shipWithinDays(int[] weights, int days) {
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();

        while (left < right) {
            int mid = (left + right) / 2;

            if (canShip(weights, days, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void task4(Scanner sc) {
        int n = sc.nextInt();
        int[] weights = new int[n];

        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
        }

        int days = sc.nextInt();

        System.out.println(shipWithinDays(weights, days));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter task number (1-4):");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                task1(sc);
                break;
            case 2:
                task2(sc);
                break;
            case 3:
                task3(sc);
                break;
            case 4:
                System.out.println("Enter 1) size of array 2)weights 3)days");
                task4(sc);
                break;
            default:
                System.out.println("Invalid task number");
        }
    }
}