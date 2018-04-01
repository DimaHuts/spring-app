import React from 'react'

export default class THeadItem extends React.Component {
    render () {

        const {
            field
        } = this.props

        return (
            <th width={field.width}>{field.title}</th>
        )
    }
}
