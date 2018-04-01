import React from 'react'
import { Provider } from 'react-redux';
import { BrowserRouter as Router, Route} from 'react-router-dom'
import requireAuthentication from './components/Login/Auth/AuthenticatedComponent'
import configureStore from './store/configureStore'
import Main from './containers/Main'
import Login from './containers/Login'
import LoginForm from './components/Login/Auth/LoginForm';
import RegisterForm from './components/Login/Register/RegisterForm';

const Root = () => (
        <Provider store={configureStore()}>
            <Router>
                <div>
                    <Route path='/login' component={Login}/>
                    <Route path='/login' component={LoginForm}/>
                    <Route path='/confirm/:token' component={LoginForm}/>
                    <Route path='/register' component={Login}/>
                    <Route path='/register' component={RegisterForm}/>
                    <Route exact={true} path='/' component={Main}/>
                </div>
            </Router>
        </Provider>
)

export default Root;