import React from 'react'
import styles from './styles.sass'


export default class Product extends React.Component{
    render () {
        return (
            <tr>
                <td className={styles['thead-item']}>{this.props.product.name}</td>
                <td className={styles['thead-item']}>{this.props.product.price}</td>
                <td className={styles['thead-item']}>{this.props.product.description}</td>
            </tr>
        )
    }
}