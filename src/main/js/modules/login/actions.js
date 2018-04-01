import * as loginConstants from './constants'
import { createAction } from 'redux-actions'

export const setLoginMessage = createAction(loginConstants.SET_Login_MESSAGE)
export const setAuthenticated = createAction(loginConstants.SET_AUTHENTICATED)