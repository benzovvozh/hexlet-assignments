package exercise.mapper;

import exercise.dto.CarCreateDTO;
import exercise.dto.CarDTO;
import exercise.dto.CarUpdateDTO;
import exercise.model.Car;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-03T19:04:36+0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.6 (Ubuntu)"
)
@Component
public class CarMapperImpl extends CarMapper {

    @Autowired
    private JsonNullableMapper jsonNullableMapper;

    @Override
    public Car map(CarCreateDTO model) {
        if ( model == null ) {
            return null;
        }

        Car car = new Car();

        car.setModel( model.getModel() );
        car.setManufacturer( model.getManufacturer() );
        car.setEnginePower( model.getEnginePower() );

        return car;
    }

    @Override
    public void update(CarUpdateDTO model, Car car) {
        if ( model == null ) {
            return;
        }

        if ( jsonNullableMapper.isPresent( model.getModel() ) ) {
            car.setModel( jsonNullableMapper.unwrap( model.getModel() ) );
        }
        if ( jsonNullableMapper.isPresent( model.getManufacturer() ) ) {
            car.setManufacturer( jsonNullableMapper.unwrap( model.getManufacturer() ) );
        }
        if ( jsonNullableMapper.isPresent( model.getEnginePower() ) ) {
            car.setEnginePower( jsonNullableMapper.unwrap( model.getEnginePower() ) );
        }
    }

    @Override
    public CarDTO map(Car car) {
        if ( car == null ) {
            return null;
        }

        CarDTO carDTO = new CarDTO();

        carDTO.setId( car.getId() );
        carDTO.setModel( car.getModel() );
        carDTO.setManufacturer( car.getManufacturer() );
        carDTO.setEnginePower( car.getEnginePower() );
        carDTO.setUpdatedAt( car.getUpdatedAt() );
        carDTO.setCreatedAt( car.getCreatedAt() );

        return carDTO;
    }
}
