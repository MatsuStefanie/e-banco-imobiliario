package com.matsu.ebancoimobiliario.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Street extends Property{

    Integer rentalAmount;
    Integer rentalOneHouseAmount;
    Integer rentalTwoHouseAmount;
    Integer rentalThreeHouseAmount;
    Integer rentalFourHouseAmount;
    Integer rentalHotelAmount;
    Integer buyHomeAmount;
    Integer buyHotelAmount;
    Integer buildingsMade;


    public void addBuildingsMade(){
        this.buildingsMade++;
    }
    public void removeBuildingsMade(){
        this.buildingsMade--;
    }


}
