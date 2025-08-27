/*
import React,{Component} from "react";

//Loading Component
class LoadingComponent extends Component{
    render(){
        return(
            <div className="alert alert-info text-center">
                <strong>Loading product details...</strong>
            </div>
        );
    }
    
}

// 2. Error Component
class ErrorComponent extends Component {
  render() {
    return (
      <div className="alert alert-danger text-center">
        ⚠️ <strong>Error fetching product details</strong>
      </div>
    );
  }
}

// 3. Product Component

class ProductComponent extends Component{
    render(){
        const {name, brand, price, category, warranty, availability} =this.props.product;
        return (
            <div className="card mt-3">
                <div className="card-header bg-dark text-white">
                    <h3>{name}</h3>
                </div>

                <div className="card-body">
                    <p><strong>Brand:</strong>{brand}</p>
                    <p>
                        <strong>Price:</strong>&#8377;{price} {" "}
                        {price >50000 ?}(
                            <span className="badge bg-warning text-dark">Premium Product</span>
                        ):(
                            <span className="badge bg-success">Budgent Product</span>
                        )}
                    </p>

                    <p>{warranty > 0 ? (
                        <span>Warranty: {warranty} years</span>
                    ): (
                        <span>No Warranty</span>
                    )}  
                    </p>

                    <p>
                        {availability ? (
                        <span className="text-success">✅ In Stock</span>
                        ) : (
                        <span className="text-danger">❌ Out of Stock</span>
                        )}
                    </p>
                    <p>
                        {category === "Laptop" ? "🎒 Free Laptop Bag Offer" : ""}
                    </p>

                </div>
            </div>
        );

    }
}
*/
