import {createSlice, PayloadAction} from '@reduxjs/toolkit'
import {CustomerState} from "../@types/customerstate";

const initialState: CustomerState = {
    customers: [],
    mobileNetwork: "Vodaphone"
}

export const customerPageSlice = createSlice({
    name: 'customertable',
    initialState,
    reducers: {
        updateCustomerPage: (state, action: PayloadAction<CustomerState>) => {
            state.customers = action.payload.customers;
            state.mobileNetwork = action.payload.mobileNetwork;
        },
    },
})

// Action creators are generated for each case reducer function
export default customerPageSlice;
