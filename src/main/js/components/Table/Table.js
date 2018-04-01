import React from 'react'
import THead from './THead';
import styles from './styles.sass'


export default class Table extends React.Component {
    render () {
        return (
            <table>
                <THead fields={this.props.headerFields}/>
                {this.props.children}
            </table>
        )
    }
}