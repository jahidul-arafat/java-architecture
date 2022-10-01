package ecommerce;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import ecommerce.data.CartData;
import ecommerce.data.PromotionData;

public class App implements RequestHandler<CartData, PromotionData> {
    @Override
    public PromotionData handleRequest(CartData cartData, Context context) {
        // business logic
        PromotionData promotionData = new PromotionData();

        String promotionMsg="";

        if (cartData.getSum() > 1000) {
            double reducedPrice = cartData.getSum() - cartData.getSum() * 0.10;
            promotionData.setReducedPrice(reducedPrice);
            promotionMsg+="10% discount applied";
        }
        if (cartData.getCouponCode().equalsIgnoreCase("freeshipping")) {
            promotionData.setFreeShipping(true);
            //System.out.println(promotionData.isFreeShipping());
        }
        promotionData.setPromoMsg(promotionMsg);


        return promotionData;
    }
}
