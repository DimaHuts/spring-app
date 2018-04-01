import { createStore, applyMiddleware  } from 'redux'
import rootReducer from '../modules/rootReducer'
import  thunk  from 'redux-thunk'
import { createLogger } from 'redux-logger'

const configureStore = (initialState) => {
    const logger = createLogger();
    return createStore(rootReducer, initialState, applyMiddleware(thunk, logger))
}

export default configureStore