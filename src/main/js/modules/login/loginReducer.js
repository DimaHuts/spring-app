import * as loginConsts from './constants'
import {handleActions} from 'redux-actions';

const initialState = {
    isAuthenticated: false,
    message: '',
    user: 'undefined'
};

export default handleActions({
    [loginConsts.SET_Login_MESSAGE]: (state, action) => {
        return {...state, message: action.payload}
    },
    [loginConsts.SET_AUTHENTICATED]: (state, action) => {
        return {...state, isAuthenticated: action.payload}
    },

}, initialState)
