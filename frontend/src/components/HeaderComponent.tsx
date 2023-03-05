import * as React from "react";

const HeaderComponent = (heading: string): JSX.Element => {

    return (
        <div className="row">
            <div className="col">
                <h1>{heading}</h1>
            </div>
        </div>
    );
}

export default HeaderComponent;