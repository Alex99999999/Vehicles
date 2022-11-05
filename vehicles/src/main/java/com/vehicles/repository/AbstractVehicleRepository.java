package com.vehicles.repository;

public class AbstractVehicleRepository {

    String query = "INSERT INTO vehicle (discriminator, id, color, fabrication_date, type, body_type) " +
            "    SELECT 'car', '057761f8-336a-42a8-a8f5-666991ae4a41','coloruu', '2022-09-09', 'CAR', 'SUV' " +
            "WHERE NOT EXISTS ( " +
            "    SELECT discriminator, id, color, fabrication_date, type, body_type FROM vehicle  " +
            "WHERE discriminator='car' " +
            "AND color = 'coloruu' " +
            "AND fabrication_date = '2022-09-09' " +
            "AND type = 'CAR' " +
            "AND body_type = 'SUV') " +
            "ON CONFLICT DO NOTHING";
}
