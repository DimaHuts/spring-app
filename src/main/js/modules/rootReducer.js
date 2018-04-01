import {combineReducers} from 'redux';
import loginReducer from './login/loginReducer'
import productsReducer from './products/productsReducer'

export default combineReducers({
    loginReducer,
    productsReducer
})