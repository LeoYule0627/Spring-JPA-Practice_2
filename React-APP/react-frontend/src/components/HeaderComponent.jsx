import { Component } from "react";

class HeaderComponent extends Component{
    constructor(props){
        super(props)

        this.state ={

        }
    }
    
    render(){
        return(
            <div>
                <header>
                    <nav className="navbar navbar-expand-md navbar-dark bg-dark">
                        <div><h5 className="navbar-brand">User App</h5></div>
                    </nav>
                </header>
            </div>
        )
    }
}
export default HeaderComponent