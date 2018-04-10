import * as productsConsts from './constants'
import {createAction} from 'redux-actions'

export const getAllProducts = createAction(productsConsts.GET_ALL_PRODUCTS);
export const addProduct = createAction(productsConsts.ADD_PRODUCT);