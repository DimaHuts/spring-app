import React from 'react';
import * as productsApi from '../api/products';
import {connect} from 'react-redux';
import {bindActionCreators} from 'redux';
import * as productsActions from '../modules/products/actions'
import Product from '../components/Product/Product'
import Table from '../components/Table/Table'
import productFields from '../components/Product/productFields'
import Loader from '../components/Loader/Loader'

class ListProducts extends React.Component {

  componentDidMount = () => {
      productsApi.getAllProducts()
          .then(res => {
              this.props.productsActions.getAllProducts(res.body)
          })
  }

  render() {

      const {
          products
      } = this.props

      let template = 'No products';

      if (products.listProducts.length !== 0) {
          template =  products.listProducts.map(product => (
                <Product
                    product={product}
                    key={product.id}
                 />
            ))
      }

    return (
        <div>
        {
            products.isFetching
            ? <Loader/>
            :
            <Table headerFields={productFields}>
                <tbody>{template}</tbody>
            </Table>
        }
        </div>
    )
  }
}

const mapStateToProps = (state) => {
    return {
        products: state.productsReducer
    }
}

const mapDispatchToProps = (dispatch) => {
    return {
        productsActions: bindActionCreators(productsActions, dispatch)
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(ListProducts)
