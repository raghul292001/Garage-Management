package com.garage.garageManager.business;


import com.garage.garageManager.repository.entity.JobCardEntity;
import com.garage.garageManager.service.CustomerDetailsService;
import com.garage.garageManager.service.JobCardEntityService;
import com.garage.garageManager.service.ServiceDetailsService;
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
    @Autowired
    ServiceDetailsService serviceDetailsService;
    @Autowired
    JobCardEntityService jobCardEntityService;


    public void saveJobCardDetails(String jobCardEntity) throws Exception {
        traverseJsonString(jobCardEntity);
    }

    private void traverseJsonString(String jsonString) throws Exception {
        try {
            JSONObject responseJsonObject = new JSONObject(jsonString);
            JSONArray jsonArray = responseJsonObject.getJSONArray("appointments");
            for (int index = 0; index < jsonArray.length(); index++) {
                JSONObject jobCardData = jsonArray.getJSONObject(index);
                saveJobCardDetails(jobCardData);
            }
        } catch (Exception exception) {
            log.error("Error traversing the json string ", jsonString);
        }

    }

    private void saveJobCardDetails(JSONObject jobCardData)throws Exception {
        String customerDetails = Constants.EMPTY_STRING;
        String vehicleDetails = Constants.EMPTY_STRING;
        String serviceDetails = Constants.EMPTY_STRING;
        customerDetails = saveCustomerDetails(jobCardData);
        vehicleDetails = saveVehicleDetails(jobCardData);
        serviceDetails = saveServiceDetails(jobCardData);
        jobCardEntityService.saveJobCardDetails(jobCardData.toString());
        customerDetailsService.saveCustomerDetails(customerDetails);
        vehicleDetailsService.saveVehicleDetails(vehicleDetails);
        serviceDetailsService.saveServiceDetails(serviceDetails);

    }

    private String saveCustomerDetails(JSONObject jobCardData) throws Exception {
        String customerDetails = Constants.EMPTY_STRING;
        if (jobCardData.has("customerDetails")) {
            customerDetails = jobCardData.get("customerDetails").toString();
            jobCardData.remove("customerDetails");
        }
        return customerDetails;
    }

    private String saveVehicleDetails(JSONObject jobCardData)throws Exception {
        String vehicleDetails = Constants.EMPTY_STRING;
        if (jobCardData.has("vehicleDetails")) {
            vehicleDetails = jobCardData.get("vehicleDetails").toString();
            jobCardData.remove("vehicleDetails");
        }
        return vehicleDetails;
    }

    private String saveServiceDetails(JSONObject jobCardData) throws Exception {
        String serviceDetails = Constants.EMPTY_STRING;
        if (jobCardData.has("serviceDetails")) {
            serviceDetails = jobCardData.get("serviceDetails").toString();
            jobCardData.remove("serviceDetails");
        }
        return serviceDetails;
    }
}
