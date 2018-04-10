import * as productsConsts from './constants'
import {handleActions} from 'redux-actions';

const initialState = {
    listProducts: [],
    isFetching: true
}

export default handleActions({
    [productsConsts.GET_ALL_PRODUCTS]: (state, action) => ({
         ...state,
         listProducts: [...action.payload],
         isFetching: false
    }),
    [productsConsts.ADD_PRODUCT]: (state, action) => ({
        ...state,
        listProducts: [...state.listProducts, action.payload]
    })
}, initialState)