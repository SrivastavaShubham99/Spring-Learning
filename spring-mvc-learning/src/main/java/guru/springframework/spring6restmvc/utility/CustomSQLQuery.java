package guru.springframework.spring6restmvc.utility;

public class CustomSQLQuery {
    public static final String findCustomersWithOrdersTotalPriceBetween=
            "SELECT DISTINCT c FROM Customer c LEFT JOIN c.orders o " +
            "WHERE o.totalAmount BETWEEN :startTotalPrice AND :endTotalPrice";


}
