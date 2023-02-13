import java.util.Scanner;

// Урок 2. Почему вы не можете не использовать API

public class Home_work_2 {
    public static void main(String[] args) {
    // Напишите программу, чтобы найти вхождение в строке (содержащей все символы другой строки).
        StringBuilder builder = new StringBuilder("можете"); 
        StringBuilder builder1 = new StringBuilder("Почему вы не можете не использовать API");
        System.out.println(builder1.toString().contains(builder.toString()));
    // Напишите программу, чтобы проверить, являются ли две данные строки вращением друг друга (вхождение в обратном порядке).
        StringBuilder builder2 = new StringBuilder("12345"); 
        StringBuilder builder3 = new StringBuilder("54321");
        System.out.println(builder2.compareTo(builder3.reverse()) == 0);
    // *Напишите программу, чтобы перевернуть строку с помощью рекурсии.
        Scanner iScanner = new Scanner(System.in);       
        System.out.printf("Введите строку для получения реверса строки: ");       
        String str_reverse = iScanner.nextLine ( );      
        iScanner.close ( );   
        System.out.printf("Перевернутая строка: %s", reverse(str_reverse));
        
    // Дано два числа, например 3 и 56, необходимо составить следующие строки: 3 + 56 = 59 3 – 56 = -53 3 * 56 = 168 Используем метод StringBuilder.append().
        int a = 3;
        int b = 56;
        StringBuilder sum = new StringBuilder();
        sum
            .append(a)
            .append(" + ")
            .append(b)
            .append(" = ")
            .append(a + b);
        StringBuilder dif = new StringBuilder();
        dif
            .append(a)
            .append(" - ")
            .append(b)
            .append(" = ")
            .append(a - b);
        StringBuilder mul = new StringBuilder();
        mul
            .append(a)
            .append(" * ")
            .append(b)
            .append(" = ")
            .append(a * b);
        System.out.println();
        System.out.println(sum + "\n" + dif + "\n" + mul);
    
    // Замените символ “=” на слово “равно”. Используйте методы StringBuilder.insert(),StringBuilder.deleteCharAt().
        int index_sum = sum.indexOf("=");
        sum.deleteCharAt(index_sum);
        sum.insert(index_sum, " равно ");
        int index_dif = dif.indexOf("=");
        dif.deleteCharAt(index_dif);
        dif.insert(index_dif, " равно ");
        int index_mul = mul.indexOf("=");
        mul.deleteCharAt(index_mul);
        mul.insert(index_mul, " равно ");
        System.out.println();
        System.out.println(sum + "\n" + dif + "\n" + mul);

        sum.replace(index_sum - 1, index_sum + 8, " = "); // возвращаем “=”
        dif.replace(index_dif - 1, index_dif + 8, " = "); // возвращаем “=”
        mul.replace(index_mul - 1, index_mul + 8, " = "); // возвращаем “=”

    // *Замените символ “=” на слово “равно”. Используйте методы StringBuilder.replace().
        sum.replace(index_sum, index_sum + 1, " равно ");
        dif.replace(index_dif, index_dif + 1, " равно ");
        mul.replace(index_mul, index_mul + 1, " равно ");
        System.out.println();
        System.out.println(sum + "\n" + dif + "\n" + mul);

    // **Сравнить время выполнения пунка 6 со строкой содержащей 10000 символов "=" средствами String и StringBuilder.
        // средствами String
        String sum1 = sum.toString(); // Создаем строку sum1 из 10000 символов '='
        sum1 = "=".repeat(10000);
        String dif1 = dif.toString(); // Создаем строку dif1 из  10000 символов '='
        dif1 = "=".repeat(10000);
        String mul1 = mul.toString(); // Создаем строку mul1 из  10000 символов '='
        mul1 = "=".repeat(10000);

        long start1 = System.currentTimeMillis(); 
        String sum2 = sum1.replaceAll("=", "равно"); // Заменяю символ “=” на слово “равно”
        String dif2 = dif1.replaceAll("=", "равно"); // Заменяю символ “=” на слово “равно”
        String mul2 = mul1.replaceAll("=", "равно"); // Заменяю символ “=” на слово “равно”
        System.out.println();
        System.out.println(sum2 + "\n" + dif2 + "\n" + mul2);
        long finish1 = System.currentTimeMillis();
        System.out.println("время выполнения пункта 6 средствами String: " + (finish1 - start1));
        


        // средствами StringBuilder
        sum.delete(0, sum.length()); // очищаем строку sum и добавляем 10000 символов '='
        for (int i = 0; i < 10000; i++) {
            sum.append("=");      }
        dif.delete(0, dif.length()); // очищаем строку dif и добавляем 10000 символов '='
        for (int i = 0; i < 10000; i++) {
            dif.append("=");      }
        mul.delete(0, mul.length()); // очищаем строку mul и добавляем  10000 символов '='
        for (int i = 0; i < 10000; i++) {
            mul.append("=");      }
        
        long start = System.currentTimeMillis();
        for (int i = 0; i < 50000; i = i + 5){
        sum.replace(i, i + 1, "равно"); // Заменяю символ “=” на слово “равно”
        dif.replace(i, i + 1, "равно"); // Заменяю символ “=” на слово “равно”
        mul.replace(i, i + 1, "равно");} // Заменяю символ “=” на слово “равно”
        // System.out.println();
        // System.out.println(sum + "\n" + dif + "\n" + mul);
        long finish = System.currentTimeMillis();
        System.out.println("время выполнения пункта 6 средствами StringBuilder: " + (finish - start));
    }
    
    public static String reverse(String str) {  // Функция переворачивания строки с помощью рекурсии.
        if (str.length() <= 1) {
            return str;
        }
        return reverse(str.substring(1)) + str.charAt(0);
     }
}
