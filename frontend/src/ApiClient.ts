import axios from "axios";
import Customer from "./@types/customer";

const apiClient = axios.create({
    baseURL: "http://gateway-service:9500/",
    withCredentials: false,
    headers: {
        "Content-type": "application/json",
    },
});

const findCustomersByNetwork = async (networkName: string) => {
    const response = await apiClient.get<Customer[]>(`${networkName}/customers`);
    return response.data;
}

const CustomerInformationService = {
    findCustomersForNetwork: findCustomersByNetwork
}

export default CustomerInformationService;
