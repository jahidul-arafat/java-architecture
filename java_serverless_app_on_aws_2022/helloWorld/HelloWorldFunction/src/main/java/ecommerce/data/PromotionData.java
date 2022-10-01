package ecommerce.data;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PromotionData {
    private double reducedPrice;
    private boolean freeShipping;
    private String promoMsg;

    // Getter and Setter
    public double getReducedPrice() {
        return reducedPrice;
    }

    public void setReducedPrice(double reducedPrice) {
        this.reducedPrice = reducedPrice;
    }

    public boolean isFreeShipping() {
        return freeShipping;
    }

    public void setFreeShipping(boolean freeShipping) {
        this.freeShipping = freeShipping;
    }

    public String getPromoMsg() {
        return promoMsg;
    }

    public void setPromoMsg(String promoMsg) {
        this.promoMsg = promoMsg;
    }
}
