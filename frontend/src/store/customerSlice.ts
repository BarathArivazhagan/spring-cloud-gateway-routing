import {AnyAction, ThunkAction} from '@reduxjs/toolkit'
import {CustomerState} from "../@types/customerstate";
import {customerPageSlice} from "./customerPageSlice";
import Customer from "../@types/customer";
import {RootState} from "../store";
import apiClient from "../ApiClient";
import {Simulate} from "react-dom/test-utils";
import error = Simulate.error;
import axios, { AxiosError } from "axios";

export const customerPageActions = customerPageSlice.actions;

export const fetchCustomersForNetwork=(mobileNetwork: string):ThunkAction<void,RootState,unknown,AnyAction>=>{
    return async(dispatch,getState)=>{
        const customersResponse : Customer[] = await apiClient.findCustomersForNetwork(mobileNetwork).catch(
           function ( error: Error | AxiosError ) {
               console.log(error);
               const baseAlertMessage = "Could not fetch customers for network. Are the containers running and reachable?";
               if (axios.isAxiosError(error)) {
                   const axiosMessage = `Error message: ${error.message}, Error code: ${error.code}, Error response ${error.response}`;
                   alert(`${baseAlertMessage}\n${axiosMessage}`);
               } else {
                   alert(baseAlertMessage);
               }
               return [];
            }
        );
        const updatedCustomerPageState : CustomerState = {customers: customersResponse, mobileNetwork: mobileNetwork};
        dispatch(customerPageActions.updateCustomerPage(updatedCustomerPageState));
    }

}