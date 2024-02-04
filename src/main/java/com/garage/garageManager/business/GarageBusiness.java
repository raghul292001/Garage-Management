package com.garage.garageManager.business;


import com.garage.garageManager.repository.entity.JobCardEntity;
import com.garage.garageManager.service.CustomerDetailsService;
import com.garage.garageManager.service.VehicleDetailsService;
import com.garage.garageManager.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class GarageBusiness {

    @Autowired
    CustomerDetailsService customerDetailsService;

    @Autowired
    VehicleDetailsService vehicleDetailsService;


    public JobCardEntity  saveJobCardDetails(String jobCardEntity){
        traverseJsonString(jobCardEntity);
        return null;
    }

    private void traverseJsonString(String jsonString){

        try{
            JSONObject responseJsonObject = new JSONObject(jsonString);
            JSONArray jsonArray = responseJsonObject.getJSONArray("appointments");
            for(int index = 0; index < jsonArray.length(); index++){
                JSONObject jobCardData = jsonArray.getJSONObject(index);
                saveJobCardDetails(jobCardData);
            }
        }catch (Exception exception){
            log.error("Error traversing the json string ",jsonString);
        }

    }

    private void saveJobCardDetails(JSONObject jobCardData){
        saveCustomerDetails(jobCardData);
        saveVehicleDetails(jobCardData);
        saveServiceDetails(jobCardData);
    }

    private void saveCustomerDetails(JSONObject jobCardData){
        String customerDetails = Constants.EMPTY_STRING;
        if(jobCardData.has("customerDetails")) {
            customerDetails = jobCardData.get("customerDetails").toString();
            jobCardData.remove("customerDetails");
            customerDetailsService.saveCustomerDetails(customerDetails);
        }
    }

    private void saveVehicleDetails(JSONObject jobCardData){
        String vehicleDetails = Constants.EMPTY_STRING;
        if(jobCardData.has("vehicleDetails")) {
            vehicleDetails = jobCardData.get("vehicleDetails").toString();
            jobCardData.remove("vehicleDetails");
            vehicleDetailsService.saveVehicleDetails(vehicleDetails);

        }

    }

    private void saveServiceDetails(JSONObject jobCardData){
        String serviceDetails = Constants.EMPTY_STRING;
        if(jobCardData.has("serviceDetails")) {
            serviceDetails = jobCardData.get("serviceDetails").toString();
            jobCardData.remove("serviceDetails");

        }

    }

    private void saveEmployeeAssignedDetails(String employeeAssigned){

    }

}
