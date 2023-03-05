import * as React from "react";
import Customer from "../@types/customer";

const TableComponent = (customers: Customer[]): JSX.Element => {

    const tableHeaders = ["customerName", "customerAge", "customerGender"];

    return (
        <div className="row">
            <table className="table table-striped table-hover table-bordered">
                <thead>
                <tr>
                    { tableHeaders.map ( function ( header: string) {
                        return <th scope="col">{header}</th>
                    })}
                </tr>
                </thead>
                <tbody>
                { customers.map( function ( customer: Customer ) {
                    const customerAsTableRow : JSX.Element[] = tableHeaders.map(function ( header: string ) {
                        return <td>{customer[header as keyof Customer]}</td>
                    })
                    return (
                        <tr>{customerAsTableRow}</tr>
                    )
                })}
                </tbody>
            </table>
        </div>
    );
}

export default TableComponent;