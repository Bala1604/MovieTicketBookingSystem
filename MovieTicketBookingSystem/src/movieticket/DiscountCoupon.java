package movieticket;

public class DiscountCoupon {

    // Apply discount based on coupon code
    public double applyDiscount(String couponCode, double price) {

        couponCode = couponCode.toUpperCase();

        double discount = 0;

        if (couponCode.equals("MOVIE10")) {

            discount = price * 0.10;

        } else if (couponCode.equals("MOVIE20")) {

            discount = price * 0.20;

        } else if (couponCode.equals("NO")) {

            discount = 0;

        } else {

            System.out.println("Invalid coupon code.");
        }

        return discount;
    }
} 	