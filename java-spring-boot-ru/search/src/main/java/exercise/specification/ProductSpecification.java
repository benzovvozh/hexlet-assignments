package exercise.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import exercise.dto.ProductParamsDTO;
import exercise.model.Product;

// BEGIN
@Component
public class ProductSpecification {
    public Specification<Product> build(ProductParamsDTO paramsDTO) {
        return withCategory(paramsDTO.getCategoryId())
                .and(withPriceGt(paramsDTO.getPriceGt()))
                .and(withPriceLt(paramsDTO.getPriceLt()))
                .and(withRating(paramsDTO.getRatingGt()))
                .and(withString(paramsDTO.getTitleCont()));
    }

    private Specification<Product> withCategory(Long categoryId) {
        return ((root, query, cb)
                -> categoryId == null ? cb.conjunction() : cb.equal(root.get("category").get("id"), categoryId));
    }

    private Specification<Product> withPriceGt(Integer priceGt) {
        return ((root, query, cb)
                -> priceGt == null ? cb.conjunction() : cb.greaterThan(root.get("price"), priceGt));
    }

    private Specification<Product> withPriceLt(Integer priceLt) {
        return ((root, query, cb)
                -> priceLt == null ? cb.conjunction() : cb.lessThan(root.get("price"), priceLt));
    }

    private Specification<Product> withRating(Double ratingGt) {
        return ((root, query, cb)
                -> ratingGt == null ? cb.conjunction() : cb.greaterThan(root.get("rating"), ratingGt));
    }

    private Specification<Product> withString(String titleCont) {
        return ((root, query, cb)
                -> titleCont == null ? cb.conjunction() : cb.like(root.get("title"), titleCont));
    }
}
// END
