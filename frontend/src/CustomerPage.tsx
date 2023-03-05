import React from 'react'
import { useAppSelector, useAppDispatch } from './hooks'
import Customer from "./@types/customer";
import ButtonComponent from "./components/ButtonComponent";
import TableComponent from "./components/Customertable";
import {fetchCustomersForNetwork} from "./store/customerSlice";
import HeaderComponent from "./components/HeaderComponent";


const CustomerPage=() => {
    const mobileNetwork : string = useAppSelector((state: any) => state.customertable.mobileNetwork);
    const customers : Customer[] = useAppSelector( (state: any) => state.customertable.customers);
    const dispatch = useAppDispatch()

    return (
        <div className="App container">
            { HeaderComponent(mobileNetwork + " customers") }
            { ButtonComponent((mobileNetwork: string) => dispatch(fetchCustomersForNetwork(mobileNetwork.toLowerCase()))) }
            <br/>
            { TableComponent(customers) }
        </div>
    )
}

export default CustomerPage;