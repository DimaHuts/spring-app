import { createStore, applyMiddleware  } from 'redux'
import rootReducer from '../modules/rootReducer'
import  thunk  from 'redux-thunk'
import { createLogger } from 'redux-logger'
import promiseMiddleware from 'redux-promise';

const configureStore = (initialState) => {
    const logger = createLogger();
    return createStore(rootReducer, initialState, applyMiddleware(thunk, promiseMiddleware, logger))
}

export default configureStore