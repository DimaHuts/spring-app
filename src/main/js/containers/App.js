import React, { Component } from 'react'
import Login from './Login'
import {connect} from 'react-redux';
import Main from './Main';
import * as loginActions from '../modules/login/actions';
import {bindActionCreators} from 'redux';

class App extends Component {
  render() {
      let temp = this.props.loginReducer.isAuthenticated
          ? <Main setAuthenticated={this.props.loginActions.setAuthenticated}/>
          : <Login user={this.props.user}/>;
    return (
        <div className='row'>
            {temp}
        </div>
    )
  }
}

const mapStateToProps = (state) => {
    return {
        user: state.user
    }
}

const mapDispatchToProps = (dispatch) => {
    return {
        loginActions: bindActionCreators(loginActions, dispatch),
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(App)