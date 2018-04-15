import * as constants from './constants'
import * as api from '../../api/products'

export const getAllProducts = () => ({
    type: constants.GET_ALL_PRODUCTS,
    payload: api.getAllProducts()
})