package models.entities;

public class Sale {

    private Integer month;
    private Integer year;
    private String seller;
    private Integer items;
    private Double total;

    public Sale(Integer month, Integer year, String seller, Integer items, Double total) {
        this.month = month;
        this.year = year;
        this.seller = seller;
        this.items = items;
        this.total = total;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public Integer getItems() {
        return items;
    }

    public void setItems(Integer items) {
        this.items = items;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double averagePrice(){
        return total / (double) items;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(month);
        sb.append("/");
        sb.append(year);
        sb.append(", ");
        sb.append(seller);
        sb.append(", ");
        sb.append(items);
        sb.append(String.format(", %.2f", total));
        sb.append(", pm = ");
        sb.append(String.format("%.2f", averagePrice()));
        return sb.toString();
    }
}
