package application;

import models.entities.Sale;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.Comparator.reverseOrder;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Entre o caminho do arquivo: ");
        String path = sc.nextLine();

        List<Sale> saleList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null){
                String[] fields = line.split(",");
                int month = Integer.parseInt(fields[0]);
                int year = Integer.parseInt(fields[1]);
                String seller = fields[2];
                int items = Integer.parseInt(fields[3]);
                double total = Double.parseDouble(fields[4]);
                saleList.add(new Sale(month, year, seller, items, total));

                line = br.readLine();
            }

            List<Sale> topSales = saleList.stream()
                    .filter(s -> s.getYear() == 2016)
                    .sorted(comparing(Sale::averagePrice).reversed())
                    .limit(5)
                    .collect(Collectors.toList());

            topSales.forEach(System.out::println);

            double sellerTotalSales = saleList.stream()
                    .filter(s -> s.getSeller().equals("Logan"))
                    .filter(s -> Arrays.asList(1, 7).contains(s.getMonth()))
                    .map(s -> s.getTotal())
                    .reduce(0.0, (s1, s2) -> s1 + s2);

            System.out.println();
            System.out.print(
                    "Valor total vendido pelo vendedor Logan nos meses 1 e 7 = " + String.format("%.2f", sellerTotalSales)
            );

        } catch (IOException e) {
            System.out.print("Erro: " + e.getMessage());
        }

        sc.close();
    }
}