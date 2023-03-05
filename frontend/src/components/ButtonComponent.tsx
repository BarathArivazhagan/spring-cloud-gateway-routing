import * as React from "react";
import {MouseEvent} from "react";

const ButtonComponent = (handleClick : (mobileNetwork: string) => void): JSX.Element => {

    const mobileNetworks : string[] = ["Vodaphone", "Airtel", "Jio"];
    const buttonColors: string[] = ["primary", "success", "danger"]

    return (
        <div>
            <div className="row">
                <p>Click a button to fetch data for a mobile network</p>
            </div>
            <div className="row">
                { mobileNetworks.map ( function (mobileNetwork, index) {
                    const className = "btn btn-" + buttonColors[index] + " get-customers-btn";
                    return <div className="col">
                        <button type="button" className={className} onClick={(e: MouseEvent) => handleClick(e.currentTarget.innerHTML)}>{mobileNetwork}</button>
                    </div>
                })}
            </div>
        </div>
    );
}

export default ButtonComponent;