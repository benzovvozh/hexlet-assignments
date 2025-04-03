package exercise.mapper;

// BEGIN

import exercise.dto.ProductCreateDTO;
import exercise.dto.ProductDTO;
import exercise.dto.ProductUpdateDTO;
import exercise.model.Product;
import org.mapstruct.*;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class ProductMapper {
    // преобразование из дто создания в сущность
    @Mapping(target = "cost", source = "price")
    @Mapping(target = "name", source = "title")
    @Mapping(target = "barcode", source = "vendorCode")
    public abstract Product map(ProductCreateDTO data);

    // преобразование из сущности в дто
    @Mapping(target = "price", source = "cost")
    @Mapping(target = "title", source = "name")
    @Mapping(target = "vendorCode", source = "barcode")
    public abstract ProductDTO map(Product data);

    //преобразование из дто обновления в сущность
    @Mapping(target = "cost", source = "price")
    public abstract void update(ProductUpdateDTO updateDTO, @MappingTarget Product data);
}
// END
