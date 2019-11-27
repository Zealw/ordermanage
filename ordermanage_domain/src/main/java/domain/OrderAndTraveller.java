package domain;

import java.util.List;

public class OrderAndTraveller {
    private String memberId;
    private String productId;
    private String[] travellerId;
    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String[] getTravellerId() {
        return travellerId;
    }

    public void setTravellerId(String[] travellerId) {
        this.travellerId = travellerId;
    }
}
