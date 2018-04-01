import React from 'react'
import styles from './styles.sass'

export default class Loader extends React.Component {
    render () {
        return (
            <div className={styles.loader}></div>
        )

    }
}